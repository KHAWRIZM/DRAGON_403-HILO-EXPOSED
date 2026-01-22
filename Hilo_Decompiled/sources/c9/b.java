package c9;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b extends n {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f٥٩٩٠a;

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f٥٩٩١b = {'T', 'N', '*', 'E'};

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f٥٩٩٢c = {'/', ':', '+', '.'};

    /* renamed from: d, reason: collision with root package name */
    private static final char f٥٩٩٣d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        f٥٩٩٠a = cArr;
        f٥٩٩٣d = cArr[0];
    }

    @Override // c9.n
    public boolean[] c(String str) {
        int i10;
        if (str.length() < 2) {
            StringBuilder sb = new StringBuilder();
            char c10 = f٥٩٩٣d;
            sb.append(c10);
            sb.append(str);
            sb.append(c10);
            str = sb.toString();
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = f٥٩٩٠a;
            boolean a10 = a.a(cArr, upperCase);
            boolean a11 = a.a(cArr, upperCase2);
            char[] cArr2 = f٥٩٩١b;
            boolean a12 = a.a(cArr2, upperCase);
            boolean a13 = a.a(cArr2, upperCase2);
            if (a10) {
                if (!a11) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
            } else if (a12) {
                if (!a13) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
            } else if (!a11 && !a13) {
                StringBuilder sb2 = new StringBuilder();
                char c11 = f٥٩٩٣d;
                sb2.append(c11);
                sb2.append(str);
                sb2.append(c11);
                str = sb2.toString();
            } else {
                throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
            }
        }
        int i11 = 20;
        for (int i12 = 1; i12 < str.length() - 1; i12++) {
            if (!Character.isDigit(str.charAt(i12)) && str.charAt(i12) != '-' && str.charAt(i12) != '$') {
                if (a.a(f٥٩٩٢c, str.charAt(i12))) {
                    i11 += 10;
                } else {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i12) + '\'');
                }
            } else {
                i11 += 9;
            }
        }
        boolean[] zArr = new boolean[i11 + (str.length() - 1)];
        int i13 = 0;
        for (int i14 = 0; i14 < str.length(); i14++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i14));
            if (i14 == 0 || i14 == str.length() - 1) {
                if (upperCase3 != '*') {
                    if (upperCase3 != 'E') {
                        if (upperCase3 != 'N') {
                            if (upperCase3 == 'T') {
                                upperCase3 = 'A';
                            }
                        } else {
                            upperCase3 = 'B';
                        }
                    } else {
                        upperCase3 = 'D';
                    }
                } else {
                    upperCase3 = 'C';
                }
            }
            int i15 = 0;
            while (true) {
                char[] cArr3 = a.f٥٩٨٧a;
                if (i15 < cArr3.length) {
                    if (upperCase3 == cArr3[i15]) {
                        i10 = a.f٥٩٨٨b[i15];
                        break;
                    }
                    i15++;
                } else {
                    i10 = 0;
                    break;
                }
            }
            int i16 = 0;
            boolean z10 = true;
            while (true) {
                int i17 = 0;
                while (i16 < 7) {
                    zArr[i13] = z10;
                    i13++;
                    if (((i10 >> (6 - i16)) & 1) != 0 && i17 != 1) {
                        i17++;
                    } else {
                        z10 = !z10;
                        i16++;
                    }
                }
                break;
            }
            if (i14 < str.length() - 1) {
                zArr[i13] = false;
                i13++;
            }
        }
        return zArr;
    }
}
