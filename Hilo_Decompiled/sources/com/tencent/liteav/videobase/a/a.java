package com.tencent.liteav.videobase.a;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.frame.c;
import com.tencent.liteav.videobase.frame.d;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a {
    private static final float[] i = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private static final AtomicInteger j = new AtomicInteger();
    protected final com.tencent.liteav.videobase.utils.a a;
    protected final Size b;
    protected int c;
    protected int d;
    protected int e;
    protected e f;
    public int g;
    public float[] h;
    private final com.tencent.liteav.videobase.utils.e k;
    private int l;
    private final c m;
    private boolean n;

    public a() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform mat4 textureTransform;\nvarying highp vec2 textureCoordinate;\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2) {
    }

    public int b() {
        return 3553;
    }

    public final void c() {
        if (!this.n) {
            return;
        }
        this.a.a();
        d();
        this.n = false;
        this.m.d();
        int i2 = this.g;
        if (i2 != -1) {
            GLES20.glDeleteProgram(i2);
            this.g = -1;
        }
        LiteavLog.d("TXCGPUImageFilter", "%s uninitialized, count: %d", this, Integer.valueOf(j.decrementAndGet()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
    }

    public a(String str, String str2) {
        this.b = new Size(-1, -1);
        this.g = -1;
        this.m = new c();
        this.a = new com.tencent.liteav.videobase.utils.a();
        this.k = new com.tencent.liteav.videobase.utils.e(str, str2);
    }

    public final void a() {
        if (this.n) {
            return;
        }
        this.m.a();
        com.tencent.liteav.videobase.utils.e eVar = this.k;
        int a = com.tencent.liteav.videobase.utils.e.a(eVar.a, 35633);
        int i2 = -1;
        if (a == 0) {
            LiteavLog.e("Program", "load vertex shader failed.");
        } else {
            int a2 = com.tencent.liteav.videobase.utils.e.a(eVar.b, 35632);
            if (a2 == 0) {
                LiteavLog.e("Program", "load fragment shader failed.");
                GLES20.glDeleteShader(a);
            } else {
                int glCreateProgram = GLES20.glCreateProgram();
                GLES20.glAttachShader(glCreateProgram, a);
                GLES20.glAttachShader(glCreateProgram, a2);
                GLES20.glLinkProgram(glCreateProgram);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
                if (iArr[0] == 0) {
                    LiteavLog.e("Program", "link program failed. status: " + iArr[0]);
                    GLES20.glDeleteShader(a);
                    GLES20.glDeleteShader(a2);
                    GLES20.glDeleteProgram(glCreateProgram);
                } else {
                    GLES20.glDeleteShader(a);
                    GLES20.glDeleteShader(a2);
                    i2 = glCreateProgram;
                }
            }
        }
        this.g = i2;
        this.c = GLES20.glGetAttribLocation(i2, "position");
        this.d = GLES20.glGetUniformLocation(this.g, "inputImageTexture");
        this.e = GLES20.glGetAttribLocation(this.g, "inputTextureCoordinate");
        this.l = GLES20.glGetUniformLocation(this.g, "textureTransform");
        a((e) null);
        this.n = true;
        LiteavLog.d("TXCGPUImageFilter", "%s initialized, count: %d", this, Integer.valueOf(j.incrementAndGet()));
    }

    public final void a(int i2, int i3) {
        Size size = this.b;
        size.width = i2;
        size.height = i3;
    }

    public void a(int i2, d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.n) {
            GLES20.glUseProgram(this.g);
            this.a.a();
            floatBuffer.position(0);
            GLES20.glVertexAttribPointer(this.c, 2, 5126, false, 0, (Buffer) floatBuffer);
            GLES20.glEnableVertexAttribArray(this.c);
            floatBuffer2.position(0);
            GLES20.glVertexAttribPointer(this.e, 2, 5126, false, 0, (Buffer) floatBuffer2);
            GLES20.glEnableVertexAttribArray(this.e);
            if (i2 != -1) {
                GLES20.glActiveTexture(33984);
                OpenGlUtils.bindTexture(b(), i2);
                GLES20.glUniform1i(this.d, 0);
            }
            if (dVar != null) {
                this.m.a(dVar.a());
                this.m.b();
            } else {
                OpenGlUtils.bindFramebuffer(36160, 0);
            }
            float[] fArr = this.h;
            if (fArr == null) {
                fArr = i;
            }
            GLES20.glUniformMatrix4fv(this.l, 1, false, fArr, 0);
            a(i2);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.c);
            GLES20.glDisableVertexAttribArray(this.e);
            GLES20.glActiveTexture(33984);
            OpenGlUtils.bindTexture(b(), 0);
            if (dVar != null) {
                OpenGlUtils.bindFramebuffer(36160, 0);
                this.m.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(e eVar) {
        this.f = eVar;
    }
}
