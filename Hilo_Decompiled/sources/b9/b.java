package b9;

import kotlin.KotlinVersion;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b implements g {
    private static char c(char c10, int i10) {
        int i11 = c10 + ((i10 * 149) % KotlinVersion.MAX_COMPONENT_VALUE) + 1;
        if (i11 <= 255) {
            return (char) i11;
        }
        return (char) (i11 - 256);
    }

    @Override // b9.g
    public void a(h hVar) {
        boolean z10;
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!hVar.i()) {
                break;
            }
            sb.append(hVar.c());
            hVar.f٥٥٥٥d++;
            if (j.n(hVar.d(), hVar.f٥٥٥٥d, b()) != b()) {
                hVar.o(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int a10 = hVar.a() + length + 1;
        hVar.q(a10);
        if (hVar.g().a() - a10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (hVar.i() || z10) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
            }
        }
        int length2 = sb.length();
        for (int i10 = 0; i10 < length2; i10++) {
            hVar.r(c(sb.charAt(i10), hVar.a() + 1));
        }
    }

    public int b() {
        return 5;
    }
}
