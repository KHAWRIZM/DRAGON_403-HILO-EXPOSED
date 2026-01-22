package io.agora.rtc.gl;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class TextureConverter {
    static final int COORDS_PER_VERTEX = 3;
    public static final int CV_TYPE_2D2OES = 1;
    public static final int CV_TYPE_OES22D = 2;
    public static final int CV_TYPE_OES2OES = 0;
    private static final String TEXTURE_2D2OES_FRAGMENT_SHADER_STRING = "#version 300 es\n#extension GL_OES_EGL_image_external_essl3 : require\n#extension GL_EXT_YUV_target : require\nin vec2 vTextureCoord;\nuniform __samplerExternal2DY2YEXT uTextureSampler;\nlayout(yuv) out vec4 gl_FragColor;\nvoid main() {\ngl_FragColor = texture(uTextureSampler, vTextureCoord);\n}\n";
    private static final String TEXTURE_OES2OES_FRAGMENT_SHADER_STRING = "#version 300 es\n#extension GL_OES_EGL_image_external_essl3 : require\n#extension GL_EXT_YUV_target : require\nin vec2 vTextureCoord;\nuniform __samplerExternal2DY2YEXT uTextureSampler;\nlayout(yuv) out vec4 gl_FragColor;\nvoid main() {\ngl_FragColor = texture(uTextureSampler, vTextureCoord);\n}\n";
    private static final String TEXTURE_OES_FRAGMENT_SHADER_STRING = "#version 300 es\n#extension GL_OES_EGL_image_external_essl3 : require\nin vec2 vTextureCoord;\nuniform samplerExternalOES uTextureSampler;\nout vec4 gl_FragColor;\nvoid main() {\ngl_FragColor = texture(uTextureSampler, vTextureCoord);\n}\n";
    private static final String VERTEX_SHADER_STRING = "#version 300 es\nuniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nin vec4 aPosition;\nin vec4 aTextureCoord;\nout vec2 vTextureCoord;\nvoid main() {\ngl_Position = uMVPMatrix * aPosition;\nvTextureCoord = (uSTMatrix * aTextureCoord).st;\n}\n";
    static final float[] rectCoords = {-1.0f, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, -1.0f, -1.0f, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, -1.0f, DownloadProgress.UNKNOWN_PROGRESS};
    static final float[] textureCoords = {DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, 1.0f, 1.0f};
    private int[] mFrameBuffer;
    private float[] mMVPMatrix;
    private int mMVPMatrixHandle;
    private int mPositionHandle;
    private final int mProgram;
    private float[] mSTMatrix = new float[16];
    private int mSTMatrixHandle;
    private int mTextureCoordHandle;
    private int mTextureHandle;
    private int mTextureID;
    private int mTextureTarget;
    private FloatBuffer textureCoordBuffer;
    private FloatBuffer vertexBuffer;
    private final int vertexCount;
    private final int vertexStride;

    public TextureConverter(int i10, int i11, int i12) {
        int loadShader;
        float[] fArr = new float[16];
        this.mMVPMatrix = fArr;
        float[] fArr2 = rectCoords;
        this.vertexCount = fArr2.length / 3;
        this.vertexStride = 12;
        Matrix.setIdentityM(fArr, 0);
        Matrix.setIdentityM(this.mSTMatrix, 0);
        this.vertexBuffer = arrayToBuffer(fArr2);
        this.textureCoordBuffer = arrayToBuffer(textureCoords);
        this.mTextureID = i10;
        this.mTextureTarget = i11;
        int loadShader2 = loadShader(35633, VERTEX_SHADER_STRING);
        if (i12 != 0) {
            if (i12 != 1) {
                if (i12 != 2) {
                    loadShader = loadShader(35632, "#version 300 es\n#extension GL_OES_EGL_image_external_essl3 : require\n#extension GL_EXT_YUV_target : require\nin vec2 vTextureCoord;\nuniform __samplerExternal2DY2YEXT uTextureSampler;\nlayout(yuv) out vec4 gl_FragColor;\nvoid main() {\ngl_FragColor = texture(uTextureSampler, vTextureCoord);\n}\n");
                } else {
                    loadShader = loadShader(35632, TEXTURE_OES_FRAGMENT_SHADER_STRING);
                }
            } else {
                loadShader = loadShader(35632, "#version 300 es\n#extension GL_OES_EGL_image_external_essl3 : require\n#extension GL_EXT_YUV_target : require\nin vec2 vTextureCoord;\nuniform __samplerExternal2DY2YEXT uTextureSampler;\nlayout(yuv) out vec4 gl_FragColor;\nvoid main() {\ngl_FragColor = texture(uTextureSampler, vTextureCoord);\n}\n");
            }
        } else {
            loadShader = loadShader(35632, "#version 300 es\n#extension GL_OES_EGL_image_external_essl3 : require\n#extension GL_EXT_YUV_target : require\nin vec2 vTextureCoord;\nuniform __samplerExternal2DY2YEXT uTextureSampler;\nlayout(yuv) out vec4 gl_FragColor;\nvoid main() {\ngl_FragColor = texture(uTextureSampler, vTextureCoord);\n}\n");
        }
        int createProgram = createProgram(loadShader2, loadShader);
        this.mProgram = createProgram;
        this.mPositionHandle = GLES20.glGetAttribLocation(createProgram, "aPosition");
        this.mTextureCoordHandle = GLES20.glGetAttribLocation(createProgram, "aTextureCoord");
        this.mMVPMatrixHandle = GLES20.glGetUniformLocation(createProgram, "uMVPMatrix");
        this.mSTMatrixHandle = GLES20.glGetUniformLocation(createProgram, "uSTMatrix");
        this.mTextureHandle = GLES20.glGetUniformLocation(createProgram, "uTextureSampler");
    }

    private FloatBuffer arrayToBuffer(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    private void beginRenderTarget(int i10, int i11) {
        if (this.mFrameBuffer == null) {
            int[] iArr = new int[1];
            this.mFrameBuffer = iArr;
            GLES20.glGenFramebuffers(1, iArr, 0);
            checkGlError();
        }
        GLES20.glBindFramebuffer(36160, this.mFrameBuffer[0]);
        checkGlError();
        GLES20.glFramebufferTexture2D(36160, 36064, i10, i11, 0);
        checkFramebufferStatus();
    }

    private void checkFramebufferStatus() {
        String str;
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus != 36053) {
            switch (glCheckFramebufferStatus) {
                case 36054:
                    str = "GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT";
                    break;
                case 36055:
                    str = "GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT";
                    break;
                case 36057:
                    str = "GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS";
                    break;
                case 36061:
                    str = "GL_FRAMEBUFFER_UNSUPPORTED";
                    break;
                default:
                    str = "";
                    break;
            }
            throw new RuntimeException(str + " : 0x" + Integer.toHexString(glCheckFramebufferStatus));
        }
    }

    private void checkGlError() {
        if (GLES20.glGetError() != 0) {
            new Throwable();
        }
    }

    private int createProgram(int... iArr) {
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram == 0) {
            return glCreateProgram;
        }
        for (int i10 : iArr) {
            GLES20.glAttachShader(glCreateProgram, i10);
        }
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr2, 0);
        if (iArr2[0] != 1) {
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    private void draw() {
        GLES20.glUseProgram(this.mProgram);
        GLES20.glEnableVertexAttribArray(this.mPositionHandle);
        GLES20.glVertexAttribPointer(this.mPositionHandle, 3, 5126, false, 12, (Buffer) this.vertexBuffer);
        GLES20.glEnableVertexAttribArray(this.mTextureCoordHandle);
        GLES20.glVertexAttribPointer(this.mTextureCoordHandle, 2, 5126, false, 8, (Buffer) this.textureCoordBuffer);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(this.mTextureTarget, this.mTextureID);
        GLES20.glUniform1i(this.mTextureHandle, 3);
        GLES20.glUniformMatrix4fv(this.mMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.mSTMatrixHandle, 1, false, this.mSTMatrix, 0);
        GLES20.glDrawArrays(5, 0, this.vertexCount);
        GLES20.glDisableVertexAttribArray(this.mPositionHandle);
    }

    private void endRenderTarget() {
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(this.mTextureTarget, 0);
        checkGlError();
    }

    private int loadShader(int i10, String str) {
        int glCreateShader = GLES20.glCreateShader(i10);
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }

    public void convert(int i10, int i11) {
        beginRenderTarget(i10, i11);
        draw();
        GLES20.glFinish();
        endRenderTarget();
    }

    public int getOneTexture(int i10) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(i10, iArr[0]);
        GLES20.glTexParameterf(i10, 10241, 9729.0f);
        GLES20.glTexParameterf(i10, 10240, 9729.0f);
        GLES20.glTexParameterf(i10, 10242, 33071.0f);
        GLES20.glTexParameterf(i10, 10243, 33071.0f);
        return iArr[0];
    }

    public void release() {
        int[] iArr = this.mFrameBuffer;
        if (iArr != null) {
            GLES20.glDeleteFramebuffers(1, iArr, 0);
        }
    }
}
