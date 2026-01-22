package io.agora.rtc.gl;

import android.opengl.GLES20;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import io.agora.rtc.gl.RendererCommon;
import io.agora.rtc.internal.ATrace;
import java.nio.FloatBuffer;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class GlRectDrawer implements RendererCommon.GlDrawer {
    private static final FloatBuffer FULL_RECTANGLE_BUF = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
    private static final FloatBuffer FULL_RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(new float[]{DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, 1.0f, 1.0f});
    private static final String OES_FRAGMENT_SHADER_STRING = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oes_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(oes_tex, interp_tc);\n}\n";
    private static final String RGB_FRAGMENT_SHADER_STRING = "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D rgb_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(rgb_tex, interp_tc);\n}\n";
    private static final String VERTEX_SHADER_STRING = "varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n";
    private static final String YUV_FRAGMENT_SHADER_STRING = "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\n\nvoid main() {\n  float y = texture2D(y_tex, interp_tc).r;\n  float u = texture2D(u_tex, interp_tc).r - 0.5;\n  float v = texture2D(v_tex, interp_tc).r - 0.5;\n  gl_FragColor = vec4(y + 1.403 * v,                       y - 0.344 * u - 0.714 * v,                       y + 1.77 * u, 1);\n}\n";
    private FloatBuffer mTexCoordinate = GlUtil.createFloatBuffer(new float[]{DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, 1.0f, 1.0f});
    private FloatBuffer mPosCoordinate = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
    private final Map<String, Shader> shaders = new IdentityHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class Shader {
        public final GlShader glShader;
        public final int texMatrixLocation;

        public Shader(String str) {
            GlShader glShader = new GlShader(GlRectDrawer.VERTEX_SHADER_STRING, str);
            this.glShader = glShader;
            this.texMatrixLocation = glShader.getUniformLocation("texMatrix");
        }
    }

    private float[] ComputePosVertexAttribArray(int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        if (i11 == i13) {
            f10 = -1.0f;
        } else {
            f10 = (((i11 - i13) * 2.0f) / i11) - 1.0f;
        }
        if (i10 == i12) {
            f11 = 1.0f;
        } else {
            f11 = ((i12 * 2.0f) / i10) - 1.0f;
        }
        return new float[]{-1.0f, f10, f11, f10, -1.0f, 1.0f, f11, 1.0f};
    }

    private float[] ComputeVertexAttribArray(int i10, int i11, int i12, int i13) {
        float f10 = i12 / i13;
        float f11 = i10;
        float f12 = i11;
        if (f11 / f12 >= f10) {
            float f13 = ((f11 - (f12 * f10)) / 2.0f) / f11;
            float f14 = 1.0f - f13;
            return new float[]{f13, DownloadProgress.UNKNOWN_PROGRESS, f14, DownloadProgress.UNKNOWN_PROGRESS, f13, 1.0f, f14, 1.0f};
        }
        float f15 = ((f12 - (f11 / f10)) / 2.0f) / f12;
        float f16 = 1.0f - f15;
        return new float[]{DownloadProgress.UNKNOWN_PROGRESS, f15, 1.0f, f15, DownloadProgress.UNKNOWN_PROGRESS, f16, 1.0f, f16};
    }

    private void drawRectangle(int i10, int i11, int i12, int i13) {
        GLES20.glViewport(i10, i11, i12, i13);
        ATrace.beginSection("glDrawArrays");
        GLES20.glDrawArrays(5, 0, 4);
        ATrace.endSection();
    }

    private void prepareShader(String str, float[] fArr) {
        Shader shader;
        if (this.shaders.containsKey(str)) {
            shader = this.shaders.get(str);
        } else {
            Shader shader2 = new Shader(str);
            this.shaders.put(str, shader2);
            shader2.glShader.useProgram();
            ATrace.beginSection("initShaderUniforms");
            if (YUV_FRAGMENT_SHADER_STRING.equals(str)) {
                GLES20.glUniform1i(shader2.glShader.getUniformLocation("y_tex"), 0);
                GLES20.glUniform1i(shader2.glShader.getUniformLocation("u_tex"), 1);
                GLES20.glUniform1i(shader2.glShader.getUniformLocation("v_tex"), 2);
            } else if (RGB_FRAGMENT_SHADER_STRING.equals(str)) {
                GLES20.glUniform1i(shader2.glShader.getUniformLocation("rgb_tex"), 0);
            } else if (OES_FRAGMENT_SHADER_STRING.equals(str)) {
                GLES20.glUniform1i(shader2.glShader.getUniformLocation("oes_tex"), 0);
            } else {
                throw new IllegalStateException("Unknown fragment shader: " + str);
            }
            GlUtil.checkNoGLES2Error("Initialize fragment shader uniform values.");
            ATrace.endSection();
            ATrace.beginSection("initVertexShaderAttrs");
            shader2.glShader.setVertexAttribArray("in_pos", 2, FULL_RECTANGLE_BUF);
            shader2.glShader.setVertexAttribArray("in_tc", 2, FULL_RECTANGLE_TEX_BUF);
            ATrace.endSection();
            shader = shader2;
        }
        shader.glShader.useProgram();
        GLES20.glUniformMatrix4fv(shader.texMatrixLocation, 1, false, fArr, 0);
    }

    @Override // io.agora.rtc.gl.RendererCommon.GlDrawer
    public void drawOes(int i10, float[] fArr, int i11, int i12, int i13, int i14, int i15, int i16) {
        ATrace.beginSection("prepareShader");
        prepareShader(OES_FRAGMENT_SHADER_STRING, fArr);
        ATrace.endSection();
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i10);
        drawRectangle(i13, i14, i15, i16);
        GLES20.glBindTexture(36197, 0);
    }

    @Override // io.agora.rtc.gl.RendererCommon.GlDrawer
    public void drawRgb(int i10, float[] fArr, int i11, int i12, int i13, int i14, int i15, int i16) {
        ATrace.beginSection("prepareShader");
        prepareShader(RGB_FRAGMENT_SHADER_STRING, fArr);
        ATrace.endSection();
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i10);
        drawRectangle(i13, i14, i15, i16);
        GLES20.glBindTexture(3553, 0);
    }

    @Override // io.agora.rtc.gl.RendererCommon.GlDrawer
    public void drawYuv(int[] iArr, float[] fArr, int i10, int i11, int i12, int i13, int i14, int i15) {
        prepareShader(YUV_FRAGMENT_SHADER_STRING, fArr);
        for (int i16 = 0; i16 < 3; i16++) {
            GLES20.glActiveTexture(33984 + i16);
            GLES20.glBindTexture(3553, iArr[i16]);
        }
        drawRectangle(i12, i13, i14, i15);
        for (int i17 = 0; i17 < 3; i17++) {
            GLES20.glActiveTexture(i17 + 33984);
            GLES20.glBindTexture(3553, 0);
        }
    }

    @Override // io.agora.rtc.gl.RendererCommon.GlDrawer
    public void release() {
        Iterator<Shader> it = this.shaders.values().iterator();
        while (it.hasNext()) {
            it.next().glShader.release();
        }
        this.shaders.clear();
    }

    public void drawOes(int i10, float[] fArr, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        this.mTexCoordinate = GlUtil.createFloatBuffer(ComputeVertexAttribArray(i11, i12, i17, i18));
        if (i17 == i15 && i18 == i16) {
            this.mPosCoordinate = FULL_RECTANGLE_BUF;
        } else {
            this.mPosCoordinate = GlUtil.createFloatBuffer(ComputePosVertexAttribArray(i15, i16, i17, i18));
        }
        prepareShader(OES_FRAGMENT_SHADER_STRING, fArr, this.mTexCoordinate, this.mPosCoordinate);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i10);
        drawRectangle(i13, i14, i15, i16);
        GLES20.glBindTexture(36197, 0);
    }

    public void drawRgb(int i10, float[] fArr, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        float[] ComputeVertexAttribArray = ComputeVertexAttribArray(i11, i12, i17, i18);
        if (i17 == i15 && i18 == i16) {
            this.mPosCoordinate = FULL_RECTANGLE_BUF;
        } else {
            this.mPosCoordinate = GlUtil.createFloatBuffer(ComputePosVertexAttribArray(i15, i16, i17, i18));
        }
        FloatBuffer createFloatBuffer = GlUtil.createFloatBuffer(ComputeVertexAttribArray);
        this.mTexCoordinate = createFloatBuffer;
        prepareShader(RGB_FRAGMENT_SHADER_STRING, fArr, createFloatBuffer, this.mPosCoordinate);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i10);
        drawRectangle(i13, i14, i15, i16);
        GLES20.glBindTexture(3553, 0);
    }

    private void prepareShader(String str, float[] fArr, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        Shader shader;
        if (this.shaders.containsKey(str)) {
            shader = this.shaders.get(str);
        } else {
            Shader shader2 = new Shader(str);
            this.shaders.put(str, shader2);
            shader2.glShader.useProgram();
            if (str == YUV_FRAGMENT_SHADER_STRING) {
                GLES20.glUniform1i(shader2.glShader.getUniformLocation("y_tex"), 0);
                GLES20.glUniform1i(shader2.glShader.getUniformLocation("u_tex"), 1);
                GLES20.glUniform1i(shader2.glShader.getUniformLocation("v_tex"), 2);
            } else if (str == RGB_FRAGMENT_SHADER_STRING) {
                GLES20.glUniform1i(shader2.glShader.getUniformLocation("rgb_tex"), 0);
            } else if (str == OES_FRAGMENT_SHADER_STRING) {
                GLES20.glUniform1i(shader2.glShader.getUniformLocation("oes_tex"), 0);
            } else {
                throw new IllegalStateException("Unknown fragment shader: " + str);
            }
            GlUtil.checkNoGLES2Error("Initialize fragment shader uniform values.");
            shader = shader2;
        }
        shader.glShader.useProgram();
        shader.glShader.setVertexAttribArray("in_pos", 2, floatBuffer2);
        shader.glShader.setVertexAttribArray("in_tc", 2, floatBuffer);
        GLES20.glUniformMatrix4fv(shader.texMatrixLocation, 1, false, fArr, 0);
    }
}
