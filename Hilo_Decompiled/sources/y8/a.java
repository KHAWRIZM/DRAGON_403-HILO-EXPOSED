package y8;

import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class a implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private int[] f١٩١٩٦a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٩١٩٧b;

    public a() {
        this.f١٩١٩٧b = 0;
        this.f١٩١٩٦a = new int[1];
    }

    private void e(int i10) {
        if (i10 > (this.f١٩١٩٦a.length << 5)) {
            int[] i11 = i(i10);
            int[] iArr = this.f١٩١٩٦a;
            System.arraycopy(iArr, 0, i11, 0, iArr.length);
            this.f١٩١٩٦a = i11;
        }
    }

    private static int[] i(int i10) {
        return new int[(i10 + 31) / 32];
    }

    public void a(boolean z10) {
        e(this.f١٩١٩٧b + 1);
        if (z10) {
            int[] iArr = this.f١٩١٩٦a;
            int i10 = this.f١٩١٩٧b;
            int i11 = i10 / 32;
            iArr[i11] = (1 << (i10 & 31)) | iArr[i11];
        }
        this.f١٩١٩٧b++;
    }

    public void b(a aVar) {
        int i10 = aVar.f١٩١٩٧b;
        e(this.f١٩١٩٧b + i10);
        for (int i11 = 0; i11 < i10; i11++) {
            a(aVar.f(i11));
        }
    }

    public void c(int i10, int i11) {
        if (i11 >= 0 && i11 <= 32) {
            e(this.f١٩١٩٧b + i11);
            while (i11 > 0) {
                boolean z10 = true;
                if (((i10 >> (i11 - 1)) & 1) != 1) {
                    z10 = false;
                }
                a(z10);
                i11--;
            }
            return;
        }
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a clone() {
        return new a((int[]) this.f١٩١٩٦a.clone(), this.f١٩١٩٧b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f١٩١٩٧b != aVar.f١٩١٩٧b || !Arrays.equals(this.f١٩١٩٦a, aVar.f١٩١٩٦a)) {
            return false;
        }
        return true;
    }

    public boolean f(int i10) {
        if (((1 << (i10 & 31)) & this.f١٩١٩٦a[i10 / 32]) != 0) {
            return true;
        }
        return false;
    }

    public int g() {
        return this.f١٩١٩٧b;
    }

    public int h() {
        return (this.f١٩١٩٧b + 7) / 8;
    }

    public int hashCode() {
        return (this.f١٩١٩٧b * 31) + Arrays.hashCode(this.f١٩١٩٦a);
    }

    public void j(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = 0;
            for (int i15 = 0; i15 < 8; i15++) {
                if (f(i10)) {
                    i14 |= 1 << (7 - i15);
                }
                i10++;
            }
            bArr[i11 + i13] = (byte) i14;
        }
    }

    public void k(a aVar) {
        if (this.f١٩١٩٧b == aVar.f١٩١٩٧b) {
            int i10 = 0;
            while (true) {
                int[] iArr = this.f١٩١٩٦a;
                if (i10 < iArr.length) {
                    iArr[i10] = iArr[i10] ^ aVar.f١٩١٩٦a[i10];
                    i10++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Sizes don't match");
        }
    }

    public String toString() {
        char c10;
        int i10 = this.f١٩١٩٧b;
        StringBuilder sb = new StringBuilder(i10 + (i10 / 8) + 1);
        for (int i11 = 0; i11 < this.f١٩١٩٧b; i11++) {
            if ((i11 & 7) == 0) {
                sb.append(' ');
            }
            if (f(i11)) {
                c10 = 'X';
            } else {
                c10 = '.';
            }
            sb.append(c10);
        }
        return sb.toString();
    }

    a(int[] iArr, int i10) {
        this.f١٩١٩٦a = iArr;
        this.f١٩١٩٧b = i10;
    }
}
