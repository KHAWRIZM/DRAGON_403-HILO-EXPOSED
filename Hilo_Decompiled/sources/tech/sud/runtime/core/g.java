package tech.sud.runtime.core;

import android.content.res.AssetManager;
import android.graphics.Bitmap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class g {
    public static h a;
    private tech.sud.runtime.component.g.a f;
    private int d = 0;
    private int e = 0;
    private long b = JNIShell.create(0);
    private long c = 0;

    private synchronized void i() {
        if (this.c == 0) {
            this.c = JNIShell.create(this.b);
        }
    }

    public synchronized void a() {
        long j = this.b;
        if (j != 0) {
            JNIShell.destroy(j);
            this.b = 0L;
        }
    }

    public tech.sud.runtime.component.g.a b() {
        return this.f;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public boolean e() {
        return JNIShell.gRender(this.c);
    }

    public void f() {
        JNIShell.gPause(this.c);
    }

    public void g() {
        JNIShell.gResume(this.c);
    }

    public void h() {
        JNIShell.gDestroy(this.c);
        this.c = 0L;
    }

    public void b(int i, int i2) {
        a(i, i2, 0, (String) null);
    }

    public void a(String str, String str2) {
        JNIShell.setOption(this.b, str, str2);
    }

    public void a(int i, int[] iArr, float[] fArr, float[] fArr2, double d) {
        JNIShell.onTouch(this.b, i, iArr, fArr, fArr2, d);
    }

    public void a(b bVar, AssetManager assetManager, String str) {
        this.f = new tech.sud.runtime.component.g.a(assetManager);
        JNIShell.setJNIContext(this.b, bVar, assetManager, str);
    }

    public void a(int i, int i2) {
        JNIShell.setScreenSize(this.b, i, i2);
    }

    public void a(boolean z, int i, int i2) {
        JNIShell.setNotchInfo(this.b, z, i, i2);
    }

    public void a(int i, String str) {
        a(i, 0, 0, str);
    }

    public synchronized void a(int i, int i2, int i3, String str) {
        JNIShell.call(this.b, i, i2, i3, str);
    }

    public void a(int i, int i2, int i3, float f) {
        if (this.c == 0) {
            i();
        }
        this.d = i;
        this.e = i2;
        JNIShell.gInitOrResize(this.c, i, i2, i3, f);
    }

    public void a(int i, int i2, Bitmap bitmap, int i3, int i4) {
        JNIShell.gTextBitmap(this.c, i, i2, bitmap, i3, i4);
    }

    public static void a(tech.sud.runtime.a.b bVar) {
        if (a != null) {
            JNIShell.setLogCallback(null);
            a = null;
        }
        if (bVar == null) {
            JNIShell.setLogCallback(null);
            return;
        }
        h hVar = new h(bVar);
        a = hVar;
        JNIShell.setLogCallback(hVar);
    }
}
