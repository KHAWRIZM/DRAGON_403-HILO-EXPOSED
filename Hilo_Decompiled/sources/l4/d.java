package l4;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.UByte;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f١٥٨٠٣b;

    /* renamed from: c, reason: collision with root package name */
    private c f١٥٨٠٤c;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f١٥٨٠٢a = new byte[256];

    /* renamed from: d, reason: collision with root package name */
    private int f١٥٨٠٥d = 0;

    private boolean b() {
        if (this.f١٥٨٠٤c.f١٥٧٩٠b != 0) {
            return true;
        }
        return false;
    }

    private int d() {
        try {
            return this.f١٥٨٠٣b.get() & UByte.MAX_VALUE;
        } catch (Exception unused) {
            this.f١٥٨٠٤c.f١٥٧٩٠b = 1;
            return 0;
        }
    }

    private void e() {
        boolean z10;
        this.f١٥٨٠٤c.f١٥٧٩٢d.f١٥٧٧٨a = n();
        this.f١٥٨٠٤c.f١٥٧٩٢d.f١٥٧٧٩b = n();
        this.f١٥٨٠٤c.f١٥٧٩٢d.f١٥٧٨٠c = n();
        this.f١٥٨٠٤c.f١٥٧٩٢d.f١٥٧٨١d = n();
        int d10 = d();
        boolean z11 = false;
        if ((d10 & 128) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int pow = (int) Math.pow(2.0d, (d10 & 7) + 1);
        b bVar = this.f١٥٨٠٤c.f١٥٧٩٢d;
        if ((d10 & 64) != 0) {
            z11 = true;
        }
        bVar.f١٥٧٨٢e = z11;
        if (z10) {
            bVar.f١٥٧٨٨k = g(pow);
        } else {
            bVar.f١٥٧٨٨k = null;
        }
        this.f١٥٨٠٤c.f١٥٧٩٢d.f١٥٧٨٧j = this.f١٥٨٠٣b.position();
        r();
        if (b()) {
            return;
        }
        c cVar = this.f١٥٨٠٤c;
        cVar.f١٥٧٩١c++;
        cVar.f١٥٧٩٣e.add(cVar.f١٥٧٩٢d);
    }

    private void f() {
        int d10 = d();
        this.f١٥٨٠٥d = d10;
        if (d10 > 0) {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                try {
                    i11 = this.f١٥٨٠٥d;
                    if (i10 < i11) {
                        i11 -= i10;
                        this.f١٥٨٠٣b.get(this.f١٥٨٠٢a, i10, i11);
                        i10 += i11;
                    } else {
                        return;
                    }
                } catch (Exception e10) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i10 + " count: " + i11 + " blockSize: " + this.f١٥٨٠٥d, e10);
                    }
                    this.f١٥٨٠٤c.f١٥٧٩٠b = 1;
                    return;
                }
            }
        }
    }

    private int[] g(int i10) {
        byte[] bArr = new byte[i10 * 3];
        int[] iArr = null;
        try {
            this.f١٥٨٠٣b.get(bArr);
            iArr = new int[256];
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10) {
                int i13 = bArr[i12] & UByte.MAX_VALUE;
                int i14 = i12 + 2;
                int i15 = bArr[i12 + 1] & UByte.MAX_VALUE;
                i12 += 3;
                int i16 = i11 + 1;
                iArr[i11] = (i15 << 8) | (i13 << 16) | (-16777216) | (bArr[i14] & UByte.MAX_VALUE);
                i11 = i16;
            }
        } catch (BufferUnderflowException e10) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e10);
            }
            this.f١٥٨٠٤c.f١٥٧٩٠b = 1;
        }
        return iArr;
    }

    private void h() {
        i(Integer.MAX_VALUE);
    }

    private void i(int i10) {
        boolean z10 = false;
        while (!z10 && !b() && this.f١٥٨٠٤c.f١٥٧٩١c <= i10) {
            int d10 = d();
            if (d10 != 33) {
                if (d10 != 44) {
                    if (d10 != 59) {
                        this.f١٥٨٠٤c.f١٥٧٩٠b = 1;
                    } else {
                        z10 = true;
                    }
                } else {
                    c cVar = this.f١٥٨٠٤c;
                    if (cVar.f١٥٧٩٢d == null) {
                        cVar.f١٥٧٩٢d = new b();
                    }
                    e();
                }
            } else {
                int d11 = d();
                if (d11 != 1) {
                    if (d11 != 249) {
                        if (d11 != 254) {
                            if (d11 != 255) {
                                q();
                            } else {
                                f();
                                StringBuilder sb = new StringBuilder();
                                for (int i11 = 0; i11 < 11; i11++) {
                                    sb.append((char) this.f١٥٨٠٢a[i11]);
                                }
                                if (sb.toString().equals("NETSCAPE2.0")) {
                                    m();
                                } else {
                                    q();
                                }
                            }
                        } else {
                            q();
                        }
                    } else {
                        this.f١٥٨٠٤c.f١٥٧٩٢d = new b();
                        j();
                    }
                } else {
                    q();
                }
            }
        }
    }

    private void j() {
        d();
        int d10 = d();
        b bVar = this.f١٥٨٠٤c.f١٥٧٩٢d;
        int i10 = (d10 & 28) >> 2;
        bVar.f١٥٧٨٤g = i10;
        boolean z10 = true;
        if (i10 == 0) {
            bVar.f١٥٧٨٤g = 1;
        }
        if ((d10 & 1) == 0) {
            z10 = false;
        }
        bVar.f١٥٧٨٣f = z10;
        int n10 = n();
        if (n10 < 2) {
            n10 = 10;
        }
        b bVar2 = this.f١٥٨٠٤c.f١٥٧٩٢d;
        bVar2.f١٥٧٨٦i = n10 * 10;
        bVar2.f١٥٧٨٥h = d();
        d();
    }

    private void k() {
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < 6; i10++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f١٥٨٠٤c.f١٥٧٩٠b = 1;
            return;
        }
        l();
        if (this.f١٥٨٠٤c.f١٥٧٩٦h && !b()) {
            c cVar = this.f١٥٨٠٤c;
            cVar.f١٥٧٨٩a = g(cVar.f١٥٧٩٧i);
            c cVar2 = this.f١٥٨٠٤c;
            cVar2.f١٥٨٠٠l = cVar2.f١٥٧٨٩a[cVar2.f١٥٧٩٨j];
        }
    }

    private void l() {
        boolean z10;
        this.f١٥٨٠٤c.f١٥٧٩٤f = n();
        this.f١٥٨٠٤c.f١٥٧٩٥g = n();
        int d10 = d();
        c cVar = this.f١٥٨٠٤c;
        if ((d10 & 128) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        cVar.f١٥٧٩٦h = z10;
        cVar.f١٥٧٩٧i = (int) Math.pow(2.0d, (d10 & 7) + 1);
        this.f١٥٨٠٤c.f١٥٧٩٨j = d();
        this.f١٥٨٠٤c.f١٥٧٩٩k = d();
    }

    private void m() {
        do {
            f();
            byte[] bArr = this.f١٥٨٠٢a;
            if (bArr[0] == 1) {
                this.f١٥٨٠٤c.f١٥٨٠١m = ((bArr[2] & UByte.MAX_VALUE) << 8) | (bArr[1] & UByte.MAX_VALUE);
            }
            if (this.f١٥٨٠٥d <= 0) {
                return;
            }
        } while (!b());
    }

    private int n() {
        return this.f١٥٨٠٣b.getShort();
    }

    private void o() {
        this.f١٥٨٠٣b = null;
        Arrays.fill(this.f١٥٨٠٢a, (byte) 0);
        this.f١٥٨٠٤c = new c();
        this.f١٥٨٠٥d = 0;
    }

    private void q() {
        int d10;
        do {
            d10 = d();
            this.f١٥٨٠٣b.position(Math.min(this.f١٥٨٠٣b.position() + d10, this.f١٥٨٠٣b.limit()));
        } while (d10 > 0);
    }

    private void r() {
        d();
        q();
    }

    public void a() {
        this.f١٥٨٠٣b = null;
        this.f١٥٨٠٤c = null;
    }

    public c c() {
        if (this.f١٥٨٠٣b != null) {
            if (b()) {
                return this.f١٥٨٠٤c;
            }
            k();
            if (!b()) {
                h();
                c cVar = this.f١٥٨٠٤c;
                if (cVar.f١٥٧٩١c < 0) {
                    cVar.f١٥٧٩٠b = 1;
                }
            }
            return this.f١٥٨٠٤c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public d p(ByteBuffer byteBuffer) {
        o();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f١٥٨٠٣b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f١٥٨٠٣b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
