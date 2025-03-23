/*
 * Copyright (C) 2024-2025 OpenAni and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license, which can be found at the following link.
 *
 * https://github.com/open-ani/ani/blob/main/LICENSE
 */

/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport",
)

package me.him188.ani.datasources.bangumi.models

import kotlinx.serialization.Required
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 
 *
 * @param id
 * @param title 
 * @param desc 
 * @param stat 目录评论及收藏数
 * @param createdAt
 * @param updatedAt 
 * @param creator 
 * @param ban deprecated, always false.
 * @param nsfw 
 * @param total 收录条目总数
 */
@Serializable

data class BangumiIndex(

    @SerialName(value = "id") @Required val id: kotlin.Int,

    @SerialName(value = "title") @Required val title: kotlin.String,

    @SerialName(value = "desc") @Required val desc: kotlin.String,

    /* 目录评论及收藏数 */
    @SerialName(value = "stat") @Required val stat: BangumiStat,

    @SerialName(value = "created_at") @Required val createdAt: kotlinx.datetime.Instant,

    @SerialName(value = "updated_at") @Required val updatedAt: kotlinx.datetime.Instant,

    @SerialName(value = "creator") @Required val creator: BangumiCreator,

    /* deprecated, always false. */
    @Deprecated(message = "This property is deprecated.")
    @SerialName(value = "ban") @Required val ban: kotlin.Boolean,

    @SerialName(value = "nsfw") @Required val nsfw: kotlin.Boolean,

    /* 收录条目总数 */
    @SerialName(value = "total") val total: kotlin.Int? = 0

) {


}

