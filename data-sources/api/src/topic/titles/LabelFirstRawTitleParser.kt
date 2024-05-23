/*
 * Ani
 * Copyright (C) 2022-2024 Him188
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package me.him188.ani.datasources.api.topic.titles

import me.him188.ani.datasources.api.EpisodeSort
import me.him188.ani.datasources.api.topic.EpisodeRange
import me.him188.ani.datasources.api.topic.FrameRate
import me.him188.ani.datasources.api.topic.MediaOrigin
import me.him188.ani.datasources.api.topic.Resolution
import me.him188.ani.datasources.api.topic.SubtitleLanguage

class LabelFirstRawTitleParser : RawTitleParser() {
    private val newAnime = Regex("(?:★?|★(.*)?)([0-9]|[一二三四五六七八九十]{0,4}) ?[月年] ?(?:新番|日剧)★?")
    private val brackets = Regex("""[\[【(](.*?)[]】)]""")

    override fun parse(
        text: String,
        allianceName: String?,
        collectTag: (title: String) -> Unit,
        collectChineseTitle: (String) -> Unit,
        collectOtherTitle: (String) -> Unit,
        collectEpisode: (EpisodeRange) -> Unit,
        collectResolution: (Resolution) -> Unit,
        collectFrameRate: (FrameRate) -> Unit,
        collectMediaOrigin: (MediaOrigin) -> Unit,
        collectSubtitleLanguage: (SubtitleLanguage) -> Unit,
    ) {
        for (s in text.splitTags()) {
            if (s.isBlank()) continue
            if (newAnime.matches(s)) {
                collectTag(s)
                continue
            }
            processTag(
                s.remove("招募").remove("招新").trim(), collectSubtitleLanguage, collectResolution, collectFrameRate,
                collectMediaOrigin, collectEpisode
            )
        }
        return
    }

    fun String.splitTags(): Sequence<String> {
        val text = this
        return sequence {
            var index = 0
            for (result in brackets.findAll(text)) {
                if (index < result.range.first) {
                    yieldAll(
                        text.substring(index until result.range.first)
                            .splitToSequence('/', '\\', '|', ' ')
                    )
                }
                index = result.range.last + 1

                val tag = result.groups[1]!!.value // can be "WebRip 1080p HEVC-10bit AAC" or "简繁内封字幕"
                yield(tag)
            }
            if (index < text.length) {
                yieldAll(
                    text.substring(index until text.length)
                        .splitToSequence('/', '\\', '|', ' ')
                )
            }

//               var start = 0
//                var end = 0
//                while (end < length) {
//                    val c = get(end).toString()
//                    if (c in delimiters.keys) {
//                        val delimiter = delimiters[c]!!
//                        val next = indexOf(delimiter, end + 1)
//                        if (next == -1) {
//                            end++
//                            continue
//                        }
//                        yield(substring(start, next + 1))
//                        start = next + 1
//                        end = start
//                    } else {
//                        end++
//                    }
//                }
//                if (start < length) {
//                    yield(substring(start))
//                }
        }
    }

    private fun parseNames(
        string: String,
        collectChineseTitle: (String) -> Unit,
        collectOtherTitle: (String) -> Unit,
    ) {
        val names = string.substringBeforeLast('-').split('/', '\\', '-', '_')
        names.firstOrNull()?.let(collectChineseTitle)
        names.asSequence().drop(1).mapNotNull { it.trim().takeIf(String::isNotEmpty) }.forEach(collectOtherTitle)
    }

    private fun processTag(
        tag: String,
        collectSubtitleLanguage: (SubtitleLanguage) -> Unit,
        collectResolution: (Resolution) -> Unit,
        collectFrameRate: (FrameRate) -> Unit,
        collectMediaOrigin: (MediaOrigin) -> Unit,
        collectEpisode: (EpisodeRange) -> Unit,
    ): Boolean {
        var anyMatched = false
        anyMatched = anyMatched or tag.parseSubtitleLanguages(collectSubtitleLanguage)
        anyMatched = anyMatched or tag.parseResolution(collectResolution)
        anyMatched = anyMatched or tag.parseFrameRate(collectFrameRate)
        anyMatched = anyMatched or tag.parseEpisode(collectEpisode)
        anyMatched = anyMatched or tag.parseMediaOrigin(collectMediaOrigin)

        return anyMatched
    }


    private fun String.parseSubtitleLanguages(collect: (SubtitleLanguage) -> Unit): Boolean {
        var any = false
        for (entry in SubtitleLanguage.matchableEntries) {
            if (entry.matches(this)) {
                collect(entry)
                any = true
            }
        }
        return any
    }

    private fun String.parseResolution(collect: (Resolution) -> Unit): Boolean {
        return Resolution.tryParse(this)?.let(collect) != null
    }

    private fun String.parseFrameRate(collect: (FrameRate) -> Unit): Boolean {
        return FrameRate.tryParse(this)?.let(collect) != null
    }

    private fun String.parseMediaOrigin(collect: (MediaOrigin) -> Unit): Boolean {
        return MediaOrigin.tryParse(this)?.let(collect) != null
    }

    private val collectionPattern = Regex(
        """(\d{1,4})\s?-{1,2}\s?(\d{1,4})(TV|BDrip|BD)?(\+.+)?""",
        RegexOption.IGNORE_CASE
    )

    private fun String.remove(str: String) = replace(str, "", ignoreCase = true)

    private fun String.parseEpisode(collectEpisode: (EpisodeRange) -> Unit): Boolean {
        if (this.contains("x264", ignoreCase = true)
            || this.contains("x265", ignoreCase = true)
        ) return false

        val str = this
            .remove("第")
            .remove("_完")
            .remove("完")
            .remove("话")
            .remove("END")
            .remove("集")
            .remove("話")
            .remove("版") // 第06話V2版
            .remove("v1")
            .remove("v2")
            .remove("v3")
        str.toFloatOrNull()?.let {
            collectEpisode(EpisodeRange.single(str))
            return true
        }
        collectionPattern.find(str)?.let { result ->
            if (result.groupValues.size < 4) {
                return@let
            }
            val (start, end) = result.destructured
            if (end.startsWith("0") && !start.startsWith("0")) {
                // "Hibike! Euphonium 3 - 02"
                return@let
            }

            if (result.groupValues.size >= 5 && result.groupValues[4].isNotBlank()) {
                collectEpisode(
                    EpisodeRange.combined(
                        EpisodeRange.range(start, end),
                        EpisodeRange.single(EpisodeSort(result.groupValues[4].removePrefix("+")))
                    )
                )
            } else {
                collectEpisode(EpisodeRange.range(start, end))
            }
            return true
        }
        if (str.contains("SP", ignoreCase = true) // 包括 "Special"
            || str.contains("OVA", ignoreCase = true)
            || str.contains("小剧场")
            || str.contains("特别篇")
        ) {
            collectEpisode(EpisodeRange.single(this))
            return true
        }
        return false
    }
}
