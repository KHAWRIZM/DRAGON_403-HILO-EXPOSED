package io.agora.rtc.video;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class TextureRenderer {
    static final int COORDS_PER_VERTEX = 2;
    private static final String LOG_TAG = "TextureRenderer";
    static float[] squareVertices = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
    private ShortBuffer drawListBuffer;
    private boolean mOesTexture;
    private final int mProgram;
    private int muMVPMatrixHandle;
    private int muSTMatrixHandle;
    private FloatBuffer textureVerticesBuffer;
    private FloatBuffer vertexBuffer;
    private final String mVertexShader = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nuniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nvarying vec2 textureCoordinate;\nvoid main()\n{\ngl_Position = uMVPMatrix * position;\nvec4 tex4 = vec4(inputTextureCoordinate.xy, 1.0, 1.0);\ntextureCoordinate = (uSTMatrix * tex4).xy;\n}";
    private final String mFragmentShaderOes = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {\ngl_FragColor = texture2D(s_texture, textureCoordinate);\n}";
    private final String mFragmentShaderRgba = "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform sampler2D s_texture;\nvoid main() {\ngl_FragColor = texture2D(s_texture, textureCoordinate);\n}";
    float[] textureVertices = {DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, 1.0f, 1.0f, 1.0f, DownloadProgress.UNKNOWN_PROGRESS};
    private short[] drawOrder = {0, 1, 2, 0, 2, 3};
    private final int vertexStride = 8;
    private float[] mMVPMatrix = new float[16];
    private float[] mSTMatrix = new float[16];

    public TextureRenderer(boolean z10) {
        int loadShader;
        this.mOesTexture = z10;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(squareVertices.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.vertexBuffer = asFloatBuffer;
        asFloatBuffer.put(squareVertices);
        this.vertexBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.drawOrder.length * 2);
        allocateDirect2.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect2.asShortBuffer();
        this.drawListBuffer = asShortBuffer;
        asShortBuffer.put(this.drawOrder);
        this.drawListBuffer.position(0);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(this.textureVertices.length * 4);
        allocateDirect3.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect3.asFloatBuffer();
        this.textureVerticesBuffer = asFloatBuffer2;
        asFloatBuffer2.put(this.textureVertices);
        this.textureVerticesBuffer.position(0);
        int loadShader2 = loadShader(35633, "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nuniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nvarying vec2 textureCoordinate;\nvoid main()\n{\ngl_Position = uMVPMatrix * position;\nvec4 tex4 = vec4(inputTextureCoordinate.xy, 1.0, 1.0);\ntextureCoordinate = (uSTMatrix * tex4).xy;\n}");
        if (this.mOesTexture) {
            loadShader = loadShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {\ngl_FragColor = texture2D(s_texture, textureCoordinate);\n}");
        } else {
            loadShader = loadShader(35632, "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform sampler2D s_texture;\nvoid main() {\ngl_FragColor = texture2D(s_texture, textureCoordinate);\n}");
        }
        int glCreateProgram = GLES20.glCreateProgram();
        this.mProgram = glCreateProgram;
        GLES20.glAttachShader(glCreateProgram, loadShader2);
        GLES20.glAttachShader(glCreateProgram, loadShader);
        GLES20.glLinkProgram(glCreateProgram);
        this.muMVPMatrixHandle = GLES20.glGetUniformLocation(glCreateProgram, "uMVPMatrix");
        this.muSTMatrixHandle = GLES20.glGetUniformLocation(glCreateProgram, "uSTMatrix");
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        Matrix.setIdentityM(this.mSTMatrix, 0);
    }

    private int loadShader(int i10, String str) {
        int glCreateShader = GLES20.glCreateShader(i10);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    private void printMatrix(float[] fArr) {
        for (int i10 = 0; i10 < 4; i10++) {
            StringBuilder sb = new StringBuilder();
            int i11 = i10 * 4;
            sb.append(fArr[i11]);
            sb.append(" ");
            sb.append(fArr[i11 + 1]);
            sb.append(" ");
            sb.append(fArr[i11 + 2]);
            sb.append(" ");
            sb.append(fArr[i11 + 3]);
            Log.d(LOG_TAG, sb.toString());
        }
    }

    public void draw(int i10) {
        GLES20.glUseProgram(this.mProgram);
        GLES20.glActiveTexture(33984);
        if (this.mOesTexture) {
            GLES20.glBindTexture(36197, i10);
        } else {
            GLES20.glBindTexture(3553, i10);
        }
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgram, "position");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, (Buffer) this.vertexBuffer);
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.mProgram, "inputTextureCoordinate");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, (Buffer) this.textureVerticesBuffer);
        GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
        GLES20.glDrawElements(4, this.drawOrder.length, 5123, this.drawListBuffer);
        GLES20.glDisableVertexAttribArray(glGetAttribLocation);
        GLES20.glDisableVertexAttribArray(glGetAttribLocation2);
        GLES20.glUseProgram(0);
    }

    public void flip(boolean z10, boolean z11) {
        float f10;
        if (z10 || z11) {
            float[] fArr = this.mMVPMatrix;
            float f11 = -1.0f;
            if (z10) {
                f10 = -1.0f;
            } else {
                f10 = 1.0f;
            }
            if (!z11) {
                f11 = 1.0f;
            }
            Matrix.scaleM(fArr, 0, f10, f11, 1.0f);
        }
    }

    public void rotate(int i10) {
        double d10 = (i10 / 180.0d) * 3.141592653589793d;
        this.mMVPMatrix[0] = (float) Math.cos(d10);
        this.mMVPMatrix[1] = -((float) Math.sin(d10));
        this.mMVPMatrix[4] = (float) Math.sin(d10);
        this.mMVPMatrix[5] = (float) Math.cos(d10);
    }

    public void draw(int i10, float[] fArr) {
        for (int i11 = 0; i11 < fArr.length; i11++) {
            this.mSTMatrix[i11] = fArr[i11];
        }
        draw(i10);
    }
}
