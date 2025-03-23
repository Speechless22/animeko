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
 * @param large
 * @param common
 * @param medium
 * @param small 
 * @param grid 
 */
@Serializable

data class BangumiImages(

    @SerialName(value = "large") @Required val large: kotlin.String,

    @SerialName(value = "common") @Required val common: kotlin.String,

    @SerialName(value = "medium") @Required val medium: kotlin.String,

    @SerialName(value = "small") @Required val small: kotlin.String,

    @SerialName(value = "grid") @Required val grid: kotlin.String

) {


}

