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

package org.overrun.swgl.core.model;

import org.overrun.swgl.core.gl.GLDataType;

import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL20C.*;
import static org.overrun.swgl.core.gl.GLDataType.*;
import static org.overrun.swgl.core.model.IVertProcessor.*;

/**
 * @author squid233
 * @since 0.1.0
 */
public enum VertexFormat {
    V2F(2, FLOAT, false, 1, FLOAT2),
    V3F(3, FLOAT, false, 1, FLOAT3),
    V4F(4, FLOAT, false, 1, FLOAT4),
    C3UB(3, UNSIGNED_BYTE, true, 2, BYTE3),
    C4UB(4, UNSIGNED_BYTE, true, 2, BYTE4),
    C3F(3, FLOAT, false, 2, FLOAT3),
    C4F(4, FLOAT, false, 2, FLOAT4),
    T2F(2, FLOAT, false, 4, FLOAT2),
    T3F(3, FLOAT, false, 4, FLOAT3),
    T4F(4, FLOAT, false, 4, FLOAT4),
    N3F(3, FLOAT, false, 8, FLOAT3),
    N3B(3, BYTE, true, 8, BYTE3);

    public static final int PROP_VERTEX = 1;
    public static final int PROP_COLOR = 1 << 1;
    public static final int PROP_TEX_COORD = 1 << 2;
    public static final int PROP_NORMAL = 1 << 3;
    private final int bytes;
    private final GLDataType dataType;
    private final int length;
    private final boolean normalized;
    private final int property;
    private final IVertProcessor processor;

    VertexFormat(int length,
                 GLDataType dataType,
                 boolean normalized,
                 int property,
                 IVertProcessor processor) {
        this.processor = processor;
        this.bytes = dataType.getBytes() * length;
        this.dataType = dataType;
        this.length = length;
        this.normalized = normalized;
        this.property = property;
    }

    public int getBytes() {
        return bytes;
    }

    public GLDataType getDataType() {
        return dataType;
    }

    public int getLength() {
        return length;
    }

    public boolean isNormalized() {
        return normalized;
    }

    /**
     * Get the property.
     *
     * @return the property
     * @since 0.2.0
     */
    public int getProperty() {
        return property;
    }

    /**
     * has position
     *
     * @return is this format has position
     * @since 0.2.0
     */
    public boolean hasPosition() {
        return property == PROP_VERTEX;
    }

    /**
     * has color
     *
     * @return is this format has color
     * @since 0.2.0
     */
    public boolean hasColor() {
        return property == PROP_COLOR;
    }

    /**
     * has tex coord
     *
     * @return is this format has tex coord
     * @since 0.2.0
     */
    public boolean hasTexture() {
        return property == PROP_TEX_COORD;
    }

    /**
     * has normal
     *
     * @return is this format has normal
     * @since 0.2.0
     */
    public boolean hasNormal() {
        return property == PROP_NORMAL;
    }

    public void beginDraw(int attribIndex, int stride, int offset) {
        glEnableVertexAttribArray(attribIndex);
        glVertexAttribPointer(
            attribIndex,
            getLength(),
            getDataType().getDataType(),
            isNormalized(),
            stride,
            offset
        );
    }

    /**
     * Puts into the buffer with this format.
     *
     * @param buffer the dist buffer
     * @param x      data x
     * @param y      data y
     * @param z      data z
     * @param w      data w
     * @since 0.2.0
     */
    public void processBuffer(ByteBuffer buffer, Object x, Object y, Object z, Object w) {
        processor.process(buffer, x, y, z, w);
    }
}
