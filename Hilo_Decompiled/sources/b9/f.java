package b9;

import kotlin.KotlinVersion;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class f implements g {
    private static void b(char c10, StringBuilder sb) {
        if (c10 >= ' ' && c10 <= '?') {
            sb.append(c10);
        } else if (c10 >= '@' && c10 <= '^') {
            sb.append((char) (c10 - '@'));
        } else {
            j.e(c10);
        }
    }

    private static String c(CharSequence charSequence, int i10) {
        char c10;
        char c11;
        int length = charSequence.length() - i10;
        if (length != 0) {
            char charAt = charSequence.charAt(i10);
            char c12 = 0;
            if (length >= 2) {
                c10 = charSequence.charAt(i10 + 1);
            } else {
                c10 = 0;
            }
            if (length >= 3) {
                c11 = charSequence.charAt(i10 + 2);
            } else {
                c11 = 0;
            }
            if (length >= 4) {
                c12 = charSequence.charAt(i10 + 3);
            }
            int i11 = (charAt << 18) + (c10 << '\f') + (c11 << 6) + c12;
            char c13 = (char) ((i11 >> 16) & KotlinVersion.MAX_COMPONENT_VALUE);
            char c14 = (char) ((i11 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
            char c15 = (char) (i11 & KotlinVersion.MAX_COMPONENT_VALUE);
            StringBuilder sb = new StringBuilder(3);
            sb.append(c13);
            if (length >= 2) {
                sb.append(c14);
            }
            if (length >= 3) {
                sb.append(c15);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }

    private static void e(h hVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z10 = true;
            if (length == 1) {
                hVar.p();
                int a10 = hVar.g().a() - hVar.a();
                int f10 = hVar.f();
                if (f10 > a10) {
                    hVar.q(hVar.a() + 1);
                    a10 = hVar.g().a() - hVar.a();
                }
                if (f10 <= a10 && a10 <= 2) {
                    return;
                }
            }
            if (length <= 4) {
                int i10 = length - 1;
                String c10 = c(charSequence, 0);
                if (hVar.i() || i10 > 2) {
                    z10 = false;
                }
                if (i10 <= 2) {
                    hVar.q(hVar.a() + i10);
                    if (hVar.g().a() - hVar.a() >= 3) {
                        hVar.q(hVar.a() + c10.length());
                        z10 = false;
                    }
                }
                if (z10) {
                    hVar.k();
                    hVar.f٥٥٥٥d -= i10;
                } else {
                    hVar.s(c10);
                }
                return;
            }
            throw new IllegalStateException("Count must not exceed 4");
        } finally {
            hVar.o(0);
        }
    }

    @Override // b9.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.i()) {
                break;
            }
            b(hVar.c(), sb);
            hVar.f٥٥٥٥d++;
            if (sb.length() >= 4) {
                hVar.s(c(sb, 0));
                sb.delete(0, 4);
                if (j.n(hVar.d(), hVar.f٥٥٥٥d, d()) != d()) {
                    hVar.o(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        e(hVar, sb);
    }

    public int d() {
        return 4;
    }
}
