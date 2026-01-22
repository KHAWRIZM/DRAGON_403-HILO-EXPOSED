package com.tencent.liteav.videobase.c;

import android.opengl.GLES20;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class e extends com.tencent.liteav.videobase.a.a {
    protected final GLConstants.ColorSpace i;
    protected final GLConstants.ColorRange j;
    private int k;
    private final int[] l;
    private int m;
    private int n;

    public e(String str, String str2, GLConstants.ColorRange colorRange, GLConstants.ColorSpace colorSpace) {
        super(str, str2);
        int[] iArr = new int[2];
        this.l = iArr;
        this.m = 0;
        this.n = 0;
        Arrays.fill(iArr, -1);
        this.i = colorSpace == GLConstants.ColorSpace.UNKNOWN ? GLConstants.ColorSpace.BT601 : colorSpace;
        this.j = colorRange == GLConstants.ColorRange.UNKNOWN ? GLConstants.ColorRange.VIDEO_RANGE : colorRange;
    }

    private void f() {
        int i = 0;
        while (true) {
            int[] iArr = this.l;
            if (i < iArr.length) {
                OpenGlUtils.deleteTexture(iArr[i]);
                this.l[i] = -1;
                i++;
            } else {
                return;
            }
        }
    }

    public final void a(ByteBuffer byteBuffer, int i, int i2) {
        if (this.m != i || this.n != i2) {
            f();
            this.m = i;
            this.n = i2;
        }
        OpenGlUtils.loadYuv420DataToTextures(byteBuffer, e(), i, i2, this.l);
    }

    @Override // com.tencent.liteav.videobase.a.a
    public final void d() {
        f();
        super.d();
    }

    protected abstract int e();

    @Override // com.tencent.liteav.videobase.a.a
    public void a(com.tencent.liteav.videobase.frame.e eVar) {
        super.a(eVar);
        this.k = GLES20.glGetUniformLocation(this.g, "uvTexture");
    }

    public e(String str, String str2) {
        this(str, str2, GLConstants.ColorRange.VIDEO_RANGE, GLConstants.ColorSpace.BT601);
    }

    @Override // com.tencent.liteav.videobase.a.a
    public final void a(int i, com.tencent.liteav.videobase.frame.d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        super.a(this.l[0], dVar, floatBuffer, floatBuffer2);
    }

    @Override // com.tencent.liteav.videobase.a.a
    public final void a(int i) {
        super.a(i);
        GLES20.glActiveTexture(33985);
        OpenGlUtils.bindTexture(b(), this.l[1]);
        GLES20.glUniform1i(this.k, 1);
    }
}
