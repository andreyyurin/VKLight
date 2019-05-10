/*******************************************************************************
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 vk.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/

package com.vk.api.sdk.utils.log

import android.util.Log

open class DefaultApiLogger(override var logLevel: Logger.LogLevel,
                            override val tag: String) : Logger {
    override fun log(level: Logger.LogLevel, msg: String?, err: Throwable?) {
        if (checkLevel(level)) return

        when (level) {
            Logger.LogLevel.NONE -> {}
            Logger.LogLevel.VERBOSE -> Log.v(tag, msg, err)
            Logger.LogLevel.DEBUG -> Log.d(tag, msg, err)
            Logger.LogLevel.WARNING -> Log.w(tag, msg, err)
            Logger.LogLevel.ERROR -> Log.e(tag, msg, err)
        }
    }

    private fun checkLevel(messageLevel: Logger.LogLevel): Boolean {
        return logLevel.ordinal > messageLevel.ordinal
    }
}