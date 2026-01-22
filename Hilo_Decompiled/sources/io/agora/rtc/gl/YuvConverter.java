package io.agora.rtc.gl;

import android.opengl.GLES20;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.utils.ThreadUtils;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class YuvConverter {
    private static final String OES_FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES tex;\nuniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      texture2D(tex, interp_tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      texture2D(tex, interp_tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      texture2D(tex, interp_tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      texture2D(tex, interp_tc + 1.5 * xUnit).rgb);\n}\n";
    private static final String RGB_FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D tex;\nuniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      texture2D(tex, interp_tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      texture2D(tex, interp_tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      texture2D(tex, interp_tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      texture2D(tex, interp_tc + 1.5 * xUnit).rgb);\n}\n";
    private static final String VERTEX_SHADER = "varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n";
    private int coeffsLoc;
    private long nativeHanlder;
    private boolean released;
    private GlShader shader;
    private VideoFrame.TextureBuffer.Type shaderTextureType;
    private int texMatrixLoc;
    private final GlTextureFrameBuffer textureFrameBuffer;
    private final ThreadUtils.ThreadChecker threadChecker;
    private int xUnitLoc;
    private static final FloatBuffer DEVICE_RECTANGLE = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
    private static final FloatBuffer TEXTURE_RECTANGLE = GlUtil.createFloatBuffer(new float[]{DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, 1.0f, 1.0f});

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.agora.rtc.gl.YuvConverter$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$agora$rtc$gl$VideoFrame$TextureBuffer$Type;

        static {
            int[] iArr = new int[VideoFrame.TextureBuffer.Type.values().length];
            $SwitchMap$io$agora$rtc$gl$VideoFrame$TextureBuffer$Type = iArr;
            try {
                iArr[VideoFrame.TextureBuffer.Type.OES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$agora$rtc$gl$VideoFrame$TextureBuffer$Type[VideoFrame.TextureBuffer.Type.RGB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public YuvConverter() {
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.threadChecker = threadChecker;
        this.released = false;
        this.nativeHanlder = 0L;
        threadChecker.checkIsOnValidThread();
        this.textureFrameBuffer = new GlTextureFrameBuffer(6408);
    }

    private native long GPUFBOInit(int i10, int i11);

    private native int GPUFBOReadFrame(long j10, byte[] bArr, int i10, int i11);

    private native void GPUFBORelease(long j10);

    private native void GPUFBOResetFirstInit(long j10);

    private native boolean GPUFBOValid();

    private void initShader(VideoFrame.TextureBuffer.Type type) {
        String str;
        GlShader glShader = this.shader;
        if (glShader != null) {
            glShader.release();
        }
        int i10 = AnonymousClass1.$SwitchMap$io$agora$rtc$gl$VideoFrame$TextureBuffer$Type[type.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                str = RGB_FRAGMENT_SHADER;
            } else {
                throw new IllegalArgumentException("Unsupported texture type.");
            }
        } else {
            str = OES_FRAGMENT_SHADER;
        }
        this.shaderTextureType = type;
        GlShader glShader2 = new GlShader(VERTEX_SHADER, str);
        this.shader = glShader2;
        glShader2.useProgram();
        this.texMatrixLoc = this.shader.getUniformLocation("texMatrix");
        this.xUnitLoc = this.shader.getUniformLocation("xUnit");
        this.coeffsLoc = this.shader.getUniformLocation("coeffs");
        GLES20.glUniform1i(this.shader.getUniformLocation("tex"), 0);
        GlUtil.checkNoGLES2Error("Initialize fragment shader uniform values.");
        this.shader.setVertexAttribArray("in_pos", 2, DEVICE_RECTANGLE);
        this.shader.setVertexAttribArray("in_tc", 2, TEXTURE_RECTANGLE);
    }

    public VideoFrame.I420Buffer convert(VideoFrame.TextureBuffer textureBuffer) {
        int width = textureBuffer.getWidth();
        int height = textureBuffer.getHeight();
        int i10 = ((width + 7) / 8) * 8;
        int i11 = (height + 1) / 2;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect((height + i11 + 1) * i10);
        convert(allocateDirect, width, height, i10, textureBuffer.getTextureId(), RendererCommon.convertMatrixFromAndroidGraphicsMatrix(textureBuffer.getTransformMatrix()), textureBuffer.getType());
        int i12 = i10 * height;
        int i13 = (i10 / 2) + i12;
        allocateDirect.position(0);
        allocateDirect.limit(i12);
        ByteBuffer slice = allocateDirect.slice();
        allocateDirect.position(i12);
        int i14 = i11 * i10;
        allocateDirect.limit(i12 + i14);
        ByteBuffer slice2 = allocateDirect.slice();
        allocateDirect.position(i13);
        allocateDirect.limit(i13 + i14);
        return JavaI420Buffer.wrap(width, height, slice, i10, slice2, i10, allocateDirect.slice(), i10, null);
    }

    public void release() {
        this.threadChecker.checkIsOnValidThread();
        this.released = true;
        GlShader glShader = this.shader;
        if (glShader != null) {
            glShader.release();
        }
        this.textureFrameBuffer.release();
        if (GPUFBOValid()) {
            GPUFBORelease(this.nativeHanlder);
        }
    }

    @Deprecated
    void convert(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, float[] fArr) {
        convert(byteBuffer, i10, i11, i12, i13, fArr, VideoFrame.TextureBuffer.Type.OES);
    }

    private void convert(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, float[] fArr, VideoFrame.TextureBuffer.Type type) {
        int i14;
        int i15;
        int i16;
        this.threadChecker.checkIsOnValidThread();
        if (!this.released) {
            if (type != this.shaderTextureType) {
                initShader(type);
            }
            this.shader.useProgram();
            if (i12 % 8 != 0) {
                throw new IllegalArgumentException("Invalid stride, must be a multiple of 8");
            }
            if (i12 >= i10) {
                int i17 = (i10 + 3) / 4;
                int i18 = (i10 + 7) / 8;
                int i19 = (i11 + 1) / 2;
                int i20 = i11 + i19;
                if (byteBuffer.capacity() >= i12 * i20) {
                    float[] multiplyMatrices = RendererCommon.multiplyMatrices(fArr, RendererCommon.verticalFlipMatrix());
                    int i21 = i12 / 4;
                    this.textureFrameBuffer.setSize(i21, i20);
                    GLES20.glBindFramebuffer(36160, this.textureFrameBuffer.getFrameBufferId());
                    GlUtil.checkNoGLES2Error("glBindFramebuffer");
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(type.getGlTarget(), i13);
                    GLES20.glUniformMatrix4fv(this.texMatrixLoc, 1, false, multiplyMatrices, 0);
                    GLES20.glViewport(0, 0, i17, i11);
                    float f10 = i10;
                    GLES20.glUniform2f(this.xUnitLoc, multiplyMatrices[0] / f10, multiplyMatrices[1] / f10);
                    GLES20.glUniform4f(this.coeffsLoc, 0.299f, 0.587f, 0.114f, DownloadProgress.UNKNOWN_PROGRESS);
                    GLES20.glDrawArrays(5, 0, 4);
                    GLES20.glViewport(0, i11, i18, i19);
                    GLES20.glUniform2f(this.xUnitLoc, (multiplyMatrices[0] * 2.0f) / f10, (multiplyMatrices[1] * 2.0f) / f10);
                    GLES20.glUniform4f(this.coeffsLoc, -0.169f, -0.331f, 0.499f, 0.5f);
                    GLES20.glDrawArrays(5, 0, 4);
                    GLES20.glViewport(i12 / 8, i11, i18, i19);
                    GLES20.glUniform4f(this.coeffsLoc, 0.499f, -0.418f, -0.0813f, 0.5f);
                    GLES20.glDrawArrays(5, 0, 4);
                    if (GPUFBOValid()) {
                        if (this.nativeHanlder == 0) {
                            this.nativeHanlder = GPUFBOInit(i21, i20);
                        }
                        i14 = GPUFBOReadFrame(this.nativeHanlder, byteBuffer.array(), i21, i20);
                    } else {
                        i14 = -1;
                    }
                    if (i14 != 0) {
                        i16 = 0;
                        i15 = 36160;
                        GLES20.glReadPixels(0, 0, i21, i20, 6408, 5121, byteBuffer);
                    } else {
                        i15 = 36160;
                        i16 = 0;
                    }
                    GlUtil.checkNoGLES2Error("YuvConverter.convert");
                    GLES20.glBindFramebuffer(i15, i16);
                    GLES20.glBindTexture(3553, i16);
                    GLES20.glBindTexture(type.getGlTarget(), i16);
                    return;
                }
                throw new IllegalArgumentException("YuvConverter.convert called with too small buffer");
            }
            throw new IllegalArgumentException("Invalid stride, must >= width");
        }
        throw new IllegalStateException("YuvConverter.convert called on released object");
    }
}
