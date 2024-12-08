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
 * @param createdAt
 * @param creator
 * @param id
 * @param parent
 * @param reactions
 * @param replies
 * @param state
 * @param text 
 * @param title 
 */
@Serializable

data class BangumiNextTopicDetail(

    @SerialName(value = "createdAt") @Required val createdAt: kotlin.Int,

    @SerialName(value = "creator") @Required val creator: BangumiNextSlimUser,

    @SerialName(value = "id") @Required val id: kotlin.Int,

    @SerialName(value = "parent") @Required val parent: BangumiNextTopicDetailParent,

    @SerialName(value = "reactions") @Required val reactions: kotlin.collections.List<BangumiNextReaction>,

    @SerialName(value = "replies") @Required val replies: kotlin.collections.List<BangumiNextReply>,

    @SerialName(value = "state") @Required val state: kotlin.Int,

    @SerialName(value = "text") @Required val text: kotlin.String,

    @SerialName(value = "title") @Required val title: kotlin.String

)

