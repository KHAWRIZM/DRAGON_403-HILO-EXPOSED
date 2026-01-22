package h9;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final byte[][] f١٤٥٤١a;

    /* renamed from: b, reason: collision with root package name */
    private final int f١٤٥٤٢b;

    /* renamed from: c, reason: collision with root package name */
    private final int f١٤٥٤٣c;

    public b(int i10, int i11) {
        this.f١٤٥٤١a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i11, i10);
        this.f١٤٥٤٢b = i10;
        this.f١٤٥٤٣c = i11;
    }

    public void a(byte b10) {
        for (byte[] bArr : this.f١٤٥٤١a) {
            Arrays.fill(bArr, b10);
        }
    }

    public byte b(int i10, int i11) {
        return this.f١٤٥٤١a[i11][i10];
    }

    public byte[][] c() {
        return this.f١٤٥٤١a;
    }

    public int d() {
        return this.f١٤٥٤٣c;
    }

    public int e() {
        return this.f١٤٥٤٢b;
    }

    public void f(int i10, int i11, int i12) {
        this.f١٤٥٤١a[i11][i10] = (byte) i12;
    }

    public void g(int i10, int i11, boolean z10) {
        this.f١٤٥٤١a[i11][i10] = z10 ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f١٤٥٤٢b * 2 * this.f١٤٥٤٣c) + 2);
        for (int i10 = 0; i10 < this.f١٤٥٤٣c; i10++) {
            byte[] bArr = this.f١٤٥٤١a[i10];
            for (int i11 = 0; i11 < this.f١٤٥٤٢b; i11++) {
                byte b10 = bArr[i11];
                if (b10 != 0) {
                    if (b10 != 1) {
                        sb.append("  ");
                    } else {
                        sb.append(" 1");
                    }
                } else {
                    sb.append(" 0");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
