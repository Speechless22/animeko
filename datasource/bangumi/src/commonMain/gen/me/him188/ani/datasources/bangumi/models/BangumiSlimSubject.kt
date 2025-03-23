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
 * @param type
 * @param name 
 * @param nameCn 
 * @param shortSummary 截短后的条目描述。
 * @param images 
 * @param volumes 书籍条目的册数，由旧服务端从wiki中解析
 * @param eps 由旧服务端从wiki中解析，对于书籍条目为`话数`
 * @param collectionTotal 收藏人数
 * @param score 分数
 * @param tags 前 10 个 tag
 * @param date air date in `YYYY-MM-DD` format
 */
@Serializable

data class BangumiSlimSubject(

    @SerialName(value = "id") @Required val id: kotlin.Int,

    @SerialName(value = "type") @Required val type: BangumiSubjectType,

    @SerialName(value = "name") @Required val name: kotlin.String,

    @SerialName(value = "name_cn") @Required val nameCn: kotlin.String,

    /* 截短后的条目描述。 */
    @SerialName(value = "short_summary") @Required val shortSummary: kotlin.String,

    @SerialName(value = "images") @Required val images: BangumiImages,

    /* 书籍条目的册数，由旧服务端从wiki中解析 */
    @SerialName(value = "volumes") @Required val volumes: kotlin.Int,

    /* 由旧服务端从wiki中解析，对于书籍条目为`话数` */
    @SerialName(value = "eps") @Required val eps: kotlin.Int,

    /* 收藏人数 */
    @SerialName(value = "collection_total") @Required val collectionTotal: kotlin.Int,

    /* 分数 */
    @SerialName(value = "score") @Required val score: @Serializable(me.him188.ani.utils.serialization.BigNumAsDoubleStringSerializer::class) me.him188.ani.utils.serialization.BigNum,

    /* 前 10 个 tag */
    @SerialName(value = "tags") @Required val tags: kotlin.collections.List<BangumiTag>,

    /* air date in `YYYY-MM-DD` format */
    @SerialName(value = "date") val date: kotlin.String? = null

) {


}

