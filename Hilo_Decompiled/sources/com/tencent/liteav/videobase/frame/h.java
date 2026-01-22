package com.tencent.liteav.videobase.frame;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class h {
    private static final float[] a = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final float[] b = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private static final float[] c = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
    private static final float[] d = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    private int e;
    private int f;
    private final FloatBuffer g;
    private final FloatBuffer h;
    private GLConstants.GLScaleType j;
    private c n;
    private final com.tencent.liteav.videobase.a.a[] i = new com.tencent.liteav.videobase.a.a[GLConstants.PixelFormatType.values().length];
    private PixelFrame k = null;
    private com.tencent.liteav.videobase.b.a l = null;
    private com.tencent.liteav.videobase.a.a m = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.videobase.frame.h$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[k.values().length];
            a = iArr;
            try {
                iArr[k.ROTATION_90.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[k.ROTATION_180.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[k.ROTATION_270.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[k.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public h(int i, int i2) {
        this.e = i;
        this.f = i2;
        float[] fArr = GLConstants.d;
        this.g = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr);
        this.h = OpenGlUtils.createTextureCoordsBuffer(k.NORMAL, false, false);
    }

    private static float a(float f) {
        return f == 0.0f ? 1.0f : 0.0f;
    }

    private void b() {
        boolean z;
        float f;
        float f2;
        PixelFrame pixelFrame = this.k;
        if (pixelFrame == null) {
            return;
        }
        if (pixelFrame.getRotation() != k.ROTATION_90 && this.k.getRotation() != k.ROTATION_270) {
            z = false;
        } else {
            z = true;
        }
        float max = Math.max((this.e * 1.0f) / this.k.getWidth(), (this.f * 1.0f) / this.k.getHeight());
        float round = (Math.round(r2 * max) * 1.0f) / this.e;
        float round2 = (Math.round(r5 * max) * 1.0f) / this.f;
        float[] fArr = GLConstants.d;
        float[] fArr2 = new float[8];
        if (this.k.getPixelBufferType() == GLConstants.a.TEXTURE_OES) {
            a(fArr2, this.k.getRotation(), this.k.isMirrorHorizontal(), this.k.isMirrorVertical());
        } else {
            OpenGlUtils.initTextureCoordsBuffer(fArr2, this.k.getRotation(), this.k.isMirrorHorizontal(), this.k.isMirrorVertical());
        }
        GLConstants.GLScaleType gLScaleType = this.j;
        if (gLScaleType == GLConstants.GLScaleType.CENTER_CROP) {
            if (z) {
                f = 1.0f / round2;
            } else {
                f = 1.0f / round;
            }
            float f3 = (1.0f - f) / 2.0f;
            if (z) {
                f2 = 1.0f / round;
            } else {
                f2 = 1.0f / round2;
            }
            float f4 = (1.0f - f2) / 2.0f;
            fArr2[0] = a(fArr2[0], f3);
            fArr2[1] = a(fArr2[1], f4);
            fArr2[2] = a(fArr2[2], f3);
            fArr2[3] = a(fArr2[3], f4);
            fArr2[4] = a(fArr2[4], f3);
            fArr2[5] = a(fArr2[5], f4);
            fArr2[6] = a(fArr2[6], f3);
            fArr2[7] = a(fArr2[7], f4);
        } else if (gLScaleType == GLConstants.GLScaleType.FIT_CENTER) {
            fArr = new float[]{fArr[0] / round2, fArr[1] / round, fArr[2] / round2, fArr[3] / round, fArr[4] / round2, fArr[5] / round, fArr[6] / round2, fArr[7] / round};
        }
        this.g.clear();
        this.g.put(fArr).position(0);
        this.h.clear();
        this.h.put(fArr2).position(0);
    }

    private void c() {
        if (this.m != null) {
            return;
        }
        com.tencent.liteav.videobase.a.a aVar = new com.tencent.liteav.videobase.a.a();
        this.m = aVar;
        aVar.a();
    }

    private void d() {
        com.tencent.liteav.videobase.b.a aVar = this.l;
        if (aVar != null) {
            aVar.c();
            this.l = null;
        }
        com.tencent.liteav.videobase.a.a aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.c();
            this.m = null;
        }
        c cVar = this.n;
        if (cVar != null) {
            cVar.d();
            this.n = null;
        }
        int i = 0;
        while (true) {
            com.tencent.liteav.videobase.a.a[] aVarArr = this.i;
            if (i < aVarArr.length) {
                com.tencent.liteav.videobase.a.a aVar3 = aVarArr[i];
                if (aVar3 != null) {
                    aVar3.c();
                    this.i[i] = null;
                }
                i++;
            } else {
                LiteavLog.i("PixelFrameRenderer", "uninitialize GL components");
                return;
            }
        }
    }

    private static float a(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }

    public final void a(PixelFrame pixelFrame, GLConstants.GLScaleType gLScaleType, d dVar) {
        if (pixelFrame != null && pixelFrame.isFrameDataValid()) {
            if (this.k == null || a(pixelFrame, gLScaleType)) {
                this.j = gLScaleType;
                this.k = new PixelFrame(pixelFrame);
                d();
                b();
            }
            if (gLScaleType == GLConstants.GLScaleType.FIT_CENTER) {
                a(dVar);
            }
            if (this.k.getPixelBufferType() == GLConstants.a.BYTE_BUFFER) {
                if (this.k.getPixelFormatType() != GLConstants.PixelFormatType.RGBA) {
                    a(this.k.getPixelFormatType(), dVar, pixelFrame.getBuffer(), pixelFrame.getColorRange(), pixelFrame.getColorSpace());
                    return;
                } else {
                    a(dVar, pixelFrame.getBuffer());
                    return;
                }
            }
            if (this.k.getPixelBufferType() == GLConstants.a.BYTE_ARRAY) {
                if (this.k.getPixelFormatType() != GLConstants.PixelFormatType.RGBA) {
                    a(this.k.getPixelFormatType(), dVar, ByteBuffer.wrap(pixelFrame.getData()), pixelFrame.getColorRange(), pixelFrame.getColorSpace());
                    return;
                } else {
                    a(dVar, ByteBuffer.wrap(pixelFrame.getData()));
                    return;
                }
            }
            if (this.k.getPixelBufferType() == GLConstants.a.TEXTURE_OES) {
                a(dVar, pixelFrame.getTextureId(), pixelFrame.getMatrix());
                return;
            } else {
                if (this.k.getPixelBufferType() == GLConstants.a.TEXTURE_2D) {
                    a(dVar, pixelFrame.getTextureId());
                    return;
                }
                return;
            }
        }
        LiteavLog.w("PixelFrameRenderer", "renderFrame: pixelFrame is not valid");
    }

    public final void a() {
        this.k = null;
        d();
    }

    private boolean a(PixelFrame pixelFrame, GLConstants.GLScaleType gLScaleType) {
        return (gLScaleType == this.j && pixelFrame.getWidth() == this.k.getWidth() && pixelFrame.getHeight() == this.k.getHeight() && pixelFrame.getPixelBufferType() == this.k.getPixelBufferType() && pixelFrame.getPixelFormatType() == this.k.getPixelFormatType() && pixelFrame.isMirrorHorizontal() == this.k.isMirrorHorizontal() && pixelFrame.isMirrorVertical() == this.k.isMirrorVertical() && pixelFrame.getRotation() == this.k.getRotation()) ? false : true;
    }

    private void a(d dVar, Buffer buffer) {
        int ordinal = GLConstants.PixelFormatType.RGBA.ordinal();
        com.tencent.liteav.videobase.a.a[] aVarArr = this.i;
        if (aVarArr[ordinal] == null) {
            aVarArr[ordinal] = new com.tencent.liteav.videobase.b.b();
            this.i[ordinal].a();
        }
        com.tencent.liteav.videobase.b.b bVar = (com.tencent.liteav.videobase.b.b) this.i[ordinal];
        bVar.a(this.e, this.f);
        OpenGlUtils.glViewport(0, 0, this.e, this.f);
        if (this.k.getRotation() != k.ROTATION_90 && this.k.getRotation() != k.ROTATION_270) {
            bVar.a(buffer, this.k.getWidth(), this.k.getHeight());
        } else {
            bVar.a(buffer, this.k.getHeight(), this.k.getWidth());
        }
        bVar.a(-1, dVar, this.g, this.h);
    }

    private void a(GLConstants.PixelFormatType pixelFormatType, d dVar, ByteBuffer byteBuffer, GLConstants.ColorRange colorRange, GLConstants.ColorSpace colorSpace) {
        int ordinal = pixelFormatType.ordinal();
        com.tencent.liteav.videobase.a.a[] aVarArr = this.i;
        if (aVarArr[ordinal] == null) {
            if (pixelFormatType == GLConstants.PixelFormatType.I420) {
                aVarArr[ordinal] = new com.tencent.liteav.videobase.c.a(colorRange, colorSpace);
            } else if (pixelFormatType == GLConstants.PixelFormatType.NV21) {
                aVarArr[ordinal] = new com.tencent.liteav.videobase.c.d();
            } else {
                aVarArr[ordinal] = new com.tencent.liteav.videobase.c.c();
            }
            this.i[ordinal].a();
        }
        com.tencent.liteav.videobase.c.e eVar = (com.tencent.liteav.videobase.c.e) this.i[ordinal];
        eVar.a(this.e, this.f);
        OpenGlUtils.glViewport(0, 0, this.e, this.f);
        if (this.k.getRotation() != k.ROTATION_90 && this.k.getRotation() != k.ROTATION_270) {
            eVar.a(byteBuffer, this.k.getWidth(), this.k.getHeight());
        } else {
            eVar.a(byteBuffer, this.k.getHeight(), this.k.getWidth());
        }
        eVar.a(-1, dVar, this.g, this.h);
    }

    private void a(d dVar, int i, float[] fArr) {
        if (this.l == null) {
            com.tencent.liteav.videobase.b.a aVar = new com.tencent.liteav.videobase.b.a();
            this.l = aVar;
            aVar.a();
        }
        OpenGlUtils.glViewport(0, 0, this.e, this.f);
        com.tencent.liteav.videobase.b.a aVar2 = this.l;
        aVar2.h = fArr;
        aVar2.a(this.e, this.f);
        this.l.a(i, dVar, this.g, this.h);
    }

    private void a(d dVar, int i) {
        c();
        OpenGlUtils.glViewport(0, 0, this.e, this.f);
        this.m.a(this.e, this.f);
        this.m.a(i, dVar, this.g, this.h);
    }

    private void a(d dVar) {
        if (this.n == null) {
            c cVar = new c();
            this.n = cVar;
            cVar.a();
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        if (dVar == null) {
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glClear(16640);
            return;
        }
        this.n.a(dVar.a());
        this.n.b();
        GLES20.glClear(16640);
        OpenGlUtils.bindFramebuffer(36160, 0);
        this.n.c();
    }

    private static void a(float[] fArr, k kVar, boolean z, boolean z2) {
        float[] fArr2 = a;
        if (kVar != null) {
            int i = AnonymousClass1.a[kVar.ordinal()];
            if (i == 1) {
                fArr2 = b;
            } else if (i == 2) {
                fArr2 = d;
            } else if (i == 3) {
                fArr2 = c;
            }
        }
        System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
        if (z) {
            fArr[0] = a(fArr[0]);
            fArr[2] = a(fArr[2]);
            fArr[4] = a(fArr[4]);
            fArr[6] = a(fArr[6]);
        }
        if (z2) {
            fArr[1] = a(fArr[1]);
            fArr[3] = a(fArr[3]);
            fArr[5] = a(fArr[5]);
            fArr[7] = a(fArr[7]);
        }
    }
}
