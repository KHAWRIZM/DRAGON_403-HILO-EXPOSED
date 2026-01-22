package com.tencent.qgame.animplayer.mix;

import android.opengl.GLES20;
import com.tencent.qgame.animplayer.util.ShaderUtil;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/tencent/qgame/animplayer/mix/MixShader;", "", "()V", "aPositionLocation", "", "getAPositionLocation", "()I", "aTextureMaskCoordinatesLocation", "getATextureMaskCoordinatesLocation", "aTextureSrcCoordinatesLocation", "getATextureSrcCoordinatesLocation", "program", "getProgram", "uColorLocation", "getUColorLocation", "uIsFillLocation", "getUIsFillLocation", "uTextureMaskUnitLocation", "getUTextureMaskUnitLocation", "uTextureSrcUnitLocation", "getUTextureSrcUnitLocation", "useProgram", "", "Companion", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class MixShader {
    private static final String A_POSITION = "a_Position";
    private static final String A_TEXTURE_MASK_COORDINATES = "a_TextureMaskCoordinates";
    private static final String A_TEXTURE_SRC_COORDINATES = "a_TextureSrcCoordinates";
    private static final String FRAGMENT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float; \nuniform sampler2D u_TextureSrcUnit;\nuniform samplerExternalOES u_TextureMaskUnit;\nuniform int u_isFill;\nuniform vec4 u_Color;\nvarying vec2 v_TextureSrcCoordinates;\nvarying vec2 v_TextureMaskCoordinates;\nvoid main()\n{\n    vec4 srcRgba = texture2D(u_TextureSrcUnit, v_TextureSrcCoordinates);\n    vec4 maskRgba = texture2D(u_TextureMaskUnit, v_TextureMaskCoordinates);\n    float isFill = step(0.5, float(u_isFill));\n    vec4 srcRgbaCal = isFill * vec4(u_Color.r, u_Color.g, u_Color.b, srcRgba.a) + (1.0 - isFill) * srcRgba;\n    gl_FragColor = vec4(srcRgbaCal.r, srcRgbaCal.g, srcRgbaCal.b, srcRgba.a * maskRgba.r);\n}";
    private static final String U_COLOR = "u_Color";
    private static final String U_IS_FILL = "u_isFill";
    private static final String U_TEXTURE_MASK_UNIT = "u_TextureMaskUnit";
    private static final String U_TEXTURE_SRC_UNIT = "u_TextureSrcUnit";
    private static final String VERTEX = "attribute vec4 a_Position;  \nattribute vec2 a_TextureSrcCoordinates;\nattribute vec2 a_TextureMaskCoordinates;\nvarying vec2 v_TextureSrcCoordinates;\nvarying vec2 v_TextureMaskCoordinates;\nvoid main()\n{\n    v_TextureSrcCoordinates = a_TextureSrcCoordinates;\n    v_TextureMaskCoordinates = a_TextureMaskCoordinates;\n    gl_Position = a_Position;\n}";
    private final int aPositionLocation;
    private final int aTextureMaskCoordinatesLocation;
    private final int aTextureSrcCoordinatesLocation;
    private final int program;
    private final int uColorLocation;
    private final int uIsFillLocation;
    private final int uTextureMaskUnitLocation;
    private final int uTextureSrcUnitLocation;

    public MixShader() {
        int createProgram = ShaderUtil.INSTANCE.createProgram(VERTEX, FRAGMENT);
        this.program = createProgram;
        this.uTextureSrcUnitLocation = GLES20.glGetUniformLocation(createProgram, U_TEXTURE_SRC_UNIT);
        this.uTextureMaskUnitLocation = GLES20.glGetUniformLocation(createProgram, U_TEXTURE_MASK_UNIT);
        this.uIsFillLocation = GLES20.glGetUniformLocation(createProgram, U_IS_FILL);
        this.uColorLocation = GLES20.glGetUniformLocation(createProgram, U_COLOR);
        this.aPositionLocation = GLES20.glGetAttribLocation(createProgram, A_POSITION);
        this.aTextureSrcCoordinatesLocation = GLES20.glGetAttribLocation(createProgram, A_TEXTURE_SRC_COORDINATES);
        this.aTextureMaskCoordinatesLocation = GLES20.glGetAttribLocation(createProgram, A_TEXTURE_MASK_COORDINATES);
    }

    public final int getAPositionLocation() {
        return this.aPositionLocation;
    }

    public final int getATextureMaskCoordinatesLocation() {
        return this.aTextureMaskCoordinatesLocation;
    }

    public final int getATextureSrcCoordinatesLocation() {
        return this.aTextureSrcCoordinatesLocation;
    }

    public final int getProgram() {
        return this.program;
    }

    public final int getUColorLocation() {
        return this.uColorLocation;
    }

    public final int getUIsFillLocation() {
        return this.uIsFillLocation;
    }

    public final int getUTextureMaskUnitLocation() {
        return this.uTextureMaskUnitLocation;
    }

    public final int getUTextureSrcUnitLocation() {
        return this.uTextureSrcUnitLocation;
    }

    public final void useProgram() {
        GLES20.glUseProgram(this.program);
    }
}
