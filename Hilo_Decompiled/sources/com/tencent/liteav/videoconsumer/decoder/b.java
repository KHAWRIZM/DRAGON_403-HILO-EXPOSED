package com.tencent.liteav.videoconsumer.decoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class b {
    int b;
    private InputStream c;
    private int d;
    private int e;
    private final OutputStream f;
    private int h;
    protected a a = new a();
    private int[] g = new int[8];

    public b(InputStream inputStream, OutputStream outputStream) throws IOException {
        this.c = inputStream;
        this.f = outputStream;
        this.d = inputStream.read();
        this.e = inputStream.read();
    }

    private int c(boolean z) throws IOException {
        if (this.b == 8) {
            f();
            if (this.d == -1) {
                return -1;
            }
        }
        int i = this.d;
        int i2 = this.b;
        int i3 = (i >> (7 - i2)) & 1;
        this.b = i2 + 1;
        if (z && this.f != null) {
            f(i3);
        }
        return i3;
    }

    private long e(int i) throws IOException {
        if (i > 64) {
            throw new IllegalArgumentException("Can not readByte more then 64 bit");
        }
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 1) | c(true);
        }
        return j;
    }

    private void f() throws IOException {
        this.d = this.e;
        this.e = this.c.read();
        this.b = 0;
    }

    private int g() throws IOException {
        int i = 0;
        while (c(true) == 0) {
            i++;
        }
        if (i <= 0) {
            return 0;
        }
        return (int) (((1 << i) - 1) + e(i));
    }

    private void h() throws IOException {
        int[] iArr = this.g;
        this.f.write(iArr[7] | (iArr[0] << 7) | (iArr[1] << 6) | (iArr[2] << 5) | (iArr[3] << 4) | (iArr[4] << 3) | (iArr[5] << 2) | (iArr[6] << 1));
    }

    public final boolean a(boolean z) throws IOException {
        return c(z) == 1;
    }

    public final void b(int i) throws IOException {
        a(i);
    }

    public final void d() throws IOException {
        int i = 0;
        while (c(true) == 0) {
            i++;
        }
        if (i > 0) {
            a(i);
        }
    }

    public final long a() throws IOException {
        long e = e(8);
        String.valueOf(e);
        return e;
    }

    public final int b() throws IOException {
        int i = 0;
        while (c(false) == 0) {
            i++;
        }
        if (i <= 0) {
            return 0;
        }
        if (i > 64) {
            throw new IllegalArgumentException("Can not readByte more then 64 bit");
        }
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 1) | c(false);
        }
        return (int) (((1 << i) - 1) + j);
    }

    public final void d(int i) throws IOException {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= 15) {
                break;
            }
            int i5 = (1 << i3) + i4;
            if (i < i5) {
                i2 = i3;
                break;
            } else {
                i3++;
                i4 = i5;
            }
        }
        a(0L, i2);
        f(1);
        a(i - i4, i2);
    }

    public final void e() throws IOException {
        f(1);
        a(0L, 8 - this.h);
        for (int i = this.h; i < 8; i++) {
            this.g[i] = 0;
        }
        this.h = 0;
        h();
    }

    private void f(int i) throws IOException {
        if (this.h == 8) {
            this.h = 0;
            h();
        }
        int[] iArr = this.g;
        int i2 = this.h;
        this.h = i2 + 1;
        iArr[i2] = i;
    }

    public final void a(int i) throws IOException {
        if (i > 64) {
            throw new IllegalArgumentException("Can not skip more then 64 bit");
        }
        for (int i2 = 0; i2 < i; i2++) {
            c(true);
        }
    }

    public final void b(boolean z) throws IOException {
        f(z ? 1 : 0);
    }

    private void a(long j, int i) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            f(((int) (j >> ((i - i2) - 1))) & 1);
        }
    }

    public final int c() throws IOException {
        int g = g();
        String.valueOf(g);
        return g;
    }

    public final void c(int i) throws IOException {
        int[] iArr = new int[i];
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 != 0) {
                int g = g();
                int i5 = ((g >> 1) + (g & 1)) * ((r4 << 1) - 1);
                String.valueOf(i5);
                i2 = ((i5 + i3) + 256) % 256;
            }
            if (i2 != 0) {
                i3 = i2;
            }
            iArr[i4] = i3;
        }
    }
}
