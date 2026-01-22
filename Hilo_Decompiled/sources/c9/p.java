package c9;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class p extends m {

    /* renamed from: a, reason: collision with root package name */
    static final int[] f٦٠٠٩a = {1, 1, 1};

    /* renamed from: b, reason: collision with root package name */
    static final int[] f٦٠١٠b = {1, 1, 1, 1, 1};

    /* renamed from: c, reason: collision with root package name */
    static final int[] f٦٠١١c = {1, 1, 1, 1, 1, 1};

    /* renamed from: d, reason: collision with root package name */
    static final int[][] f٦٠١٢d;

    /* renamed from: e, reason: collision with root package name */
    static final int[][] f٦٠١٣e;

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f٦٠١٢d = iArr;
        int[][] iArr2 = new int[20];
        f٦٠١٣e = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i10 = 10; i10 < 20; i10++) {
            int[] iArr3 = f٦٠١٢d[i10 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i11 = 0; i11 < iArr3.length; i11++) {
                iArr4[i11] = iArr3[(iArr3.length - i11) - 1];
            }
            f٦٠١٣e[i10] = iArr4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i10 = length - 1;
        if (b(charSequence.subSequence(0, i10)) != Character.digit(charSequence.charAt(i10), 10)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        for (int i11 = length - 1; i11 >= 0; i11 -= 2) {
            int charAt = charSequence.charAt(i11) - '0';
            if (charAt >= 0 && charAt <= 9) {
                i10 += charAt;
            } else {
                throw v8.d.a();
            }
        }
        int i12 = i10 * 3;
        for (int i13 = length - 2; i13 >= 0; i13 -= 2) {
            int charAt2 = charSequence.charAt(i13) - '0';
            if (charAt2 >= 0 && charAt2 <= 9) {
                i12 += charAt2;
            } else {
                throw v8.d.a();
            }
        }
        return (1000 - i12) % 10;
    }
}
