package y8;

import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private final int f١٩١٩٨a;

    /* renamed from: b, reason: collision with root package name */
    private final int f١٩١٩٩b;

    /* renamed from: c, reason: collision with root package name */
    private final int f١٩٢٠٠c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f١٩٢٠١d;

    public b(int i10) {
        this(i10, i10);
    }

    private String a(String str, String str2, String str3) {
        String str4;
        StringBuilder sb = new StringBuilder(this.f١٩١٩٩b * (this.f١٩١٩٨a + 1));
        for (int i10 = 0; i10 < this.f١٩١٩٩b; i10++) {
            for (int i11 = 0; i11 < this.f١٩١٩٨a; i11++) {
                if (d(i11, i10)) {
                    str4 = str;
                } else {
                    str4 = str2;
                }
                sb.append(str4);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public void b() {
        int length = this.f١٩٢٠١d.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f١٩٢٠١d[i10] = 0;
        }
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b clone() {
        return new b(this.f١٩١٩٨a, this.f١٩١٩٩b, this.f١٩٢٠٠c, (int[]) this.f١٩٢٠١d.clone());
    }

    public boolean d(int i10, int i11) {
        if (((this.f١٩٢٠١d[(i11 * this.f١٩٢٠٠c) + (i10 / 32)] >>> (i10 & 31)) & 1) != 0) {
            return true;
        }
        return false;
    }

    public int e() {
        return this.f١٩١٩٩b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f١٩١٩٨a != bVar.f١٩١٩٨a || this.f١٩١٩٩b != bVar.f١٩١٩٩b || this.f١٩٢٠٠c != bVar.f١٩٢٠٠c || !Arrays.equals(this.f١٩٢٠١d, bVar.f١٩٢٠١d)) {
            return false;
        }
        return true;
    }

    public int f() {
        return this.f١٩١٩٨a;
    }

    public void g(int i10, int i11) {
        int i12 = (i11 * this.f١٩٢٠٠c) + (i10 / 32);
        int[] iArr = this.f١٩٢٠١d;
        iArr[i12] = (1 << (i10 & 31)) | iArr[i12];
    }

    public void h(int i10, int i11, int i12, int i13) {
        if (i11 >= 0 && i10 >= 0) {
            if (i13 > 0 && i12 > 0) {
                int i14 = i12 + i10;
                int i15 = i13 + i11;
                if (i15 <= this.f١٩١٩٩b && i14 <= this.f١٩١٩٨a) {
                    while (i11 < i15) {
                        int i16 = this.f١٩٢٠٠c * i11;
                        for (int i17 = i10; i17 < i14; i17++) {
                            int[] iArr = this.f١٩٢٠١d;
                            int i18 = (i17 / 32) + i16;
                            iArr[i18] = iArr[i18] | (1 << (i17 & 31));
                        }
                        i11++;
                    }
                    return;
                }
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        throw new IllegalArgumentException("Left and top must be nonnegative");
    }

    public int hashCode() {
        int i10 = this.f١٩١٩٨a;
        return (((((((i10 * 31) + i10) * 31) + this.f١٩١٩٩b) * 31) + this.f١٩٢٠٠c) * 31) + Arrays.hashCode(this.f١٩٢٠١d);
    }

    public String i(String str, String str2) {
        return a(str, str2, "\n");
    }

    public String toString() {
        return i("X ", "  ");
    }

    public b(int i10, int i11) {
        if (i10 > 0 && i11 > 0) {
            this.f١٩١٩٨a = i10;
            this.f١٩١٩٩b = i11;
            int i12 = (i10 + 31) / 32;
            this.f١٩٢٠٠c = i12;
            this.f١٩٢٠١d = new int[i12 * i11];
            return;
        }
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }

    private b(int i10, int i11, int i12, int[] iArr) {
        this.f١٩١٩٨a = i10;
        this.f١٩١٩٩b = i11;
        this.f١٩٢٠٠c = i12;
        this.f١٩٢٠١d = iArr;
    }
}
