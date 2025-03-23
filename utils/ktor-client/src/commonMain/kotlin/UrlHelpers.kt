/*
 * Copyright (C) 2024-2025 OpenAni and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license, which can be found at the following link.
 *
 * https://github.com/open-ani/ani/blob/main/LICENSE
 */

package me.him188.ani.utils.ktor

import io.ktor.http.URLBuilder
import io.ktor.http.path

object UrlHelpers {
    fun computeAbsoluteUrl(baseUrl: String, relativeUrl: String): String {
        require(baseUrl.isNotEmpty()) { "baseUrl must not be empty" }
        @Suppress("NAME_SHADOWING")
        var baseUrl = baseUrl
        if (baseUrl.endsWith('/')) {
            baseUrl = baseUrl.dropLast(1)
        }
        return when {
            relativeUrl.startsWith("http") -> relativeUrl
            relativeUrl.startsWith('/') -> {
                URLBuilder(baseUrl).apply {
                    pathSegments = emptyList()
                    path(relativeUrl)
                }.buildString()
            }

            else -> "$baseUrl/$relativeUrl"
        }
    }
}
