package e9;

import java.lang.reflect.Array;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b[] f١٣٩٤٢a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٣٩٤٣b;

    /* renamed from: c, reason: collision with root package name */
    private final int f١٣٩٤٤c;

    /* renamed from: d, reason: collision with root package name */
    private final int f١٣٩٤٥d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i10, int i11) {
        b[] bVarArr = new b[i10];
        this.f١٣٩٤٢a = bVarArr;
        int length = bVarArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            this.f١٣٩٤٢a[i12] = new b(((i11 + 4) * 17) + 1);
        }
        this.f١٣٩٤٥d = i11 * 17;
        this.f١٣٩٤٤c = i10;
        this.f١٣٩٤٣b = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a() {
        return this.f١٣٩٤٢a[this.f١٣٩٤٣b];
    }

    public byte[][] b(int i10, int i11) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.f١٣٩٤٤c * i11, this.f١٣٩٤٥d * i10);
        int i12 = this.f١٣٩٤٤c * i11;
        for (int i13 = 0; i13 < i12; i13++) {
            bArr[(i12 - i13) - 1] = this.f١٣٩٤٢a[i13 / i11].b(i10);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f١٣٩٤٣b++;
    }
}
