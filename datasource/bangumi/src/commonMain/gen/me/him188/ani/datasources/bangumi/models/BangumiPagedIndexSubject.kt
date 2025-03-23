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

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 
 *
 * @param total
 * @param limit
 * @param offset 
 * @param `data` 
 */
@Serializable

data class BangumiPagedIndexSubject(

    @SerialName(value = "total") val total: kotlin.Int? = 0,

    @SerialName(value = "limit") val limit: kotlin.Int? = 0,

    @SerialName(value = "offset") val offset: kotlin.Int? = 0,

    @SerialName(value = "data") val `data`: kotlin.collections.List<BangumiIndexSubject>? = arrayListOf()

) {


}

