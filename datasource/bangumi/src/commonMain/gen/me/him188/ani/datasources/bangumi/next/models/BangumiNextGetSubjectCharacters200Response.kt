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

package me.him188.ani.datasources.bangumi.next.models

import kotlinx.serialization.Required
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 *
 * @param `data`
 * @param total
 */
@Serializable

data class BangumiNextGetSubjectCharacters200Response(

    @SerialName(value = "data") @Required val `data`: kotlin.collections.List<BangumiNextSubjectCharacter>,

    @SerialName(value = "total") @Required val total: kotlin.Int

)

