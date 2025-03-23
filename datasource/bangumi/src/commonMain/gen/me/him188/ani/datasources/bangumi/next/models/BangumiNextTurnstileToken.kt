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
    "UnusedImport"
)

package me.him188.ani.datasources.bangumi.next.models


import kotlinx.serialization.Required
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 
 *
 * @param turnstileToken 需要 [turnstile](https://developers.cloudflare.com/turnstile/get-started/client-side-rendering/) next.bgm.tv 域名对应的 site-key 为 `0x4AAAAAAABkMYinukE8nzYS` dev.bgm38.tv 域名使用测试用的 site-key `1x00000000000000000000AA`
 */
@Serializable

data class BangumiNextTurnstileToken (

    /* 需要 [turnstile](https://developers.cloudflare.com/turnstile/get-started/client-side-rendering/) next.bgm.tv 域名对应的 site-key 为 `0x4AAAAAAABkMYinukE8nzYS` dev.bgm38.tv 域名使用测试用的 site-key `1x00000000000000000000AA` */
    @SerialName(value = "turnstileToken") @Required val turnstileToken: kotlin.String

) {


}

