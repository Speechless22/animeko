/*
 * Copyright (C) 2024-2025 OpenAni and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license, which can be found at the following link.
 *
 * https://github.com/open-ani/ani/blob/main/LICENSE
 */

package me.him188.ani.app.ui.framework

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.runComposeUiTest

/**
 * 相对于 [runComposeUiTest], 有一些修改:
 * - [ComposeUiTest.waitUntil] 的超时时间更长
 */
expect fun runAniComposeUiTest(
    testBody: AniComposeUiTest.() -> Unit
)

/**
 * @see ComposeUiTest
 */
// compatibility
typealias AniComposeUiTest = ComposeUiTest

// compatibility
inline val AniComposeUiTest.composeUiTest get() = this

/**
 * 截图当前的 UI 并与 resources 目录下的图片 [expectedResource] 进行比较.
 */
expect fun AniComposeUiTest.assertScreenshot(expectedResource: String)

expect fun ImageBitmap.assertScreenshot(expectedResource: String)

