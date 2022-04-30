/*
 * MIT License
 *
 * Copyright (c) 2022 Overrun Organization
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
 */

package org.overrun.swgl.core.util;

/**
 * @param left   the left value
 * @param middle the middle value
 * @param right  the right value
 * @author squid233
 * @since 0.1.0
 */
public record IntTri(int left, int middle, int right) {
    /**
     * Get the first value.
     *
     * @return the first value
     * @see #left()
     * @since 0.2.0
     */
    public int first() {
        return left();
    }

    /**
     * Get the second value.
     *
     * @return the second value
     * @see #middle()
     * @since 0.2.0
     */
    public int second() {
        return middle();
    }

    /**
     * Get the third value.
     *
     * @return the third value
     * @see #right()
     * @since 0.2.0
     */
    public int third() {
        return right();
    }

    /**
     * Get the x value.
     *
     * @return the x value
     * @see #left()
     * @since 0.2.0
     */
    public int x() {
        return left();
    }

    /**
     * Get the y value.
     *
     * @return the y value
     * @see #middle()
     * @since 0.2.0
     */
    public int y() {
        return middle();
    }

    /**
     * Get the z value.
     *
     * @return the z value
     * @see #right()
     * @since 0.2.0
     */
    public int z() {
        return right();
    }
}
