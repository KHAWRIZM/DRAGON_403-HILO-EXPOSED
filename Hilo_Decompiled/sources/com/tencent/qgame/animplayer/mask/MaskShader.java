package com.tencent.qgame.animplayer.mask;

import android.opengl.GLES20;
import com.tencent.qgame.animplayer.util.ShaderUtil;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/tencent/qgame/animplayer/mask/MaskShader;", "", "edgeBlurBoolean", "", "(Z)V", "aPositionLocation", "", "getAPositionLocation", "()I", "aTextureMaskCoordinatesLocation", "getATextureMaskCoordinatesLocation", "program", "uTextureMaskUnitLocation", "getUTextureMaskUnitLocation", "useProgram", "", "Companion", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class MaskShader {
    private static final String A_POSITION = "vPosition";
    private static final String A_TEXTURE_MASK_COORDINATES = "vTexCoordinateAlphaMask";
    private static final String FRAGMENT_BLUR_EDGE = "precision mediump float;\nuniform sampler2D uTextureAlphaMask;\nvarying vec2 v_TexCoordinateAlphaMask;\nmat3 weight = mat3(0.0625,0.125,0.0625,0.125,0.25,0.125,0.0625,0.125,0.0625);\n int coreSize=3;\nfloat texelOffset = .01;\n\nvoid main() {\n   float alphaResult = 0.;\n   for(int y = 0; y < coreSize; y++) {\n       for(int x = 0;x < coreSize; x++) {\n           alphaResult += texture2D(uTextureAlphaMask, vec2(v_TexCoordinateAlphaMask.x + (-1.0 + float(x)) * texelOffset,v_TexCoordinateAlphaMask.y + (-1.0 + float(y)) * texelOffset)).a * weight[x][y];\n       }\n    }\n    gl_FragColor = vec4(0, 0, 0, alphaResult);\n}";
    private static final String FRAGMENT_NO_BLUR_EDGE = "precision mediump float;\nuniform sampler2D uTextureAlphaMask;\nvarying vec2 v_TexCoordinateAlphaMask;\n\nvoid main () {\n    vec4 alphaMaskColor = texture2D(uTextureAlphaMask, v_TexCoordinateAlphaMask);\n    gl_FragColor = vec4(0, 0, 0, alphaMaskColor.a);\n}";
    private static final String FRAGMENT_ROW = "precision mediump float;\nuniform sampler2D uTextureAlphaMask;\nvarying vec2 v_TexCoordinateAlphaMask;\nvec3 weight = vec3(0.4026,0.2442,0.0545);\n \nvoid main() {\n   float texelOffset = .01;\n   vec2 uv[5];\n   uv[0]= v_TexCoordinateAlphaMask;\n   uv[1]=vec2(uv[0].x+texelOffset*1.0,  uv[0].y);\n   uv[2]=vec2(uv[0].x-texelOffset*1.0,  uv[0].y);\n   uv[3]=vec2(uv[0].x+texelOffset*2.0,  uv[0].y);\n   uv[4]=vec2(uv[0].x-texelOffset*2.0,  uv[0].y);\n   float alphaResult = texture2D(uTextureAlphaMask, uv[0]).a * weight[0];\n   for(int i = 1; i < 3; ++i) {\n       alphaResult += texture2D(uTextureAlphaMask, uv[2*i-1]).a * weight[i];\n       alphaResult += texture2D(uTextureAlphaMask, uv[2*i]).a * weight[i];\n    }\n    gl_FragColor = vec4(0, 0, 0, alphaResult);\n}";
    private static final String U_TEXTURE_ALPHA_MASK_UNIT = "uTextureAlphaMask";
    private static final String VERTEX = "attribute vec4 vPosition;\nattribute vec4 vTexCoordinateAlphaMask;\nvarying vec2 v_TexCoordinateAlphaMask;\n\nvoid main() {\n    v_TexCoordinateAlphaMask = vec2(vTexCoordinateAlphaMask.x, vTexCoordinateAlphaMask.y);\n    gl_Position = vPosition;\n}";
    private final int aPositionLocation;
    private final int aTextureMaskCoordinatesLocation;
    private final int program;
    private final int uTextureMaskUnitLocation;

    public MaskShader(boolean z) {
        ShaderUtil shaderUtil;
        String str;
        if (z) {
            shaderUtil = ShaderUtil.INSTANCE;
            str = FRAGMENT_BLUR_EDGE;
        } else {
            shaderUtil = ShaderUtil.INSTANCE;
            str = FRAGMENT_NO_BLUR_EDGE;
        }
        int createProgram = shaderUtil.createProgram(VERTEX, str);
        this.program = createProgram;
        this.uTextureMaskUnitLocation = GLES20.glGetUniformLocation(createProgram, U_TEXTURE_ALPHA_MASK_UNIT);
        this.aPositionLocation = GLES20.glGetAttribLocation(createProgram, A_POSITION);
        this.aTextureMaskCoordinatesLocation = GLES20.glGetAttribLocation(createProgram, A_TEXTURE_MASK_COORDINATES);
    }

    public final int getAPositionLocation() {
        return this.aPositionLocation;
    }

    public final int getATextureMaskCoordinatesLocation() {
        return this.aTextureMaskCoordinatesLocation;
    }

    public final int getUTextureMaskUnitLocation() {
        return this.uTextureMaskUnitLocation;
    }

    public final void useProgram() {
        GLES20.glUseProgram(this.program);
    }
}
