package b9;

import io.agora.rtc.Constants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class a implements g {
    private static char b(char c10, char c11) {
        if (j.f(c10) && j.f(c11)) {
            return (char) (((c10 - '0') * 10) + (c11 - '0') + Constants.ERR_ENCRYPTED_STREAM_NOT_ALLOWED_PUBLISHED);
        }
        throw new IllegalArgumentException("not digits: " + c10 + c11);
    }

    @Override // b9.g
    public void a(h hVar) {
        if (j.a(hVar.d(), hVar.f٥٥٥٥d) >= 2) {
            hVar.r(b(hVar.d().charAt(hVar.f٥٥٥٥d), hVar.d().charAt(hVar.f٥٥٥٥d + 1)));
            hVar.f٥٥٥٥d += 2;
            return;
        }
        char c10 = hVar.c();
        int n10 = j.n(hVar.d(), hVar.f٥٥٥٥d, c());
        if (n10 != c()) {
            if (n10 != 1) {
                if (n10 != 2) {
                    if (n10 != 3) {
                        if (n10 != 4) {
                            if (n10 == 5) {
                                hVar.r((char) 231);
                                hVar.o(5);
                                return;
                            }
                            throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(n10)));
                        }
                        hVar.r((char) 240);
                        hVar.o(4);
                        return;
                    }
                    hVar.r((char) 238);
                    hVar.o(3);
                    return;
                }
                hVar.r((char) 239);
                hVar.o(2);
                return;
            }
            hVar.r((char) 230);
            hVar.o(1);
            return;
        }
        if (j.g(c10)) {
            hVar.r((char) 235);
            hVar.r((char) (c10 - 127));
            hVar.f٥٥٥٥d++;
        } else {
            hVar.r((char) (c10 + 1));
            hVar.f٥٥٥٥d++;
        }
    }

    public int c() {
        return 0;
    }
}
