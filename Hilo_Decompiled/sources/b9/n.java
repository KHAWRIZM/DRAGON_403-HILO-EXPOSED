package b9;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class n extends c {
    @Override // b9.c, b9.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.i()) {
                break;
            }
            char c10 = hVar.c();
            hVar.f٥٥٥٥d++;
            c(c10, sb);
            if (sb.length() % 3 == 0) {
                c.g(hVar, sb);
                if (j.n(hVar.d(), hVar.f٥٥٥٥d, e()) != e()) {
                    hVar.o(0);
                    break;
                }
            }
        }
        f(hVar, sb);
    }

    @Override // b9.c
    int c(char c10, StringBuilder sb) {
        if (c10 != '\r') {
            if (c10 != ' ') {
                if (c10 != '*') {
                    if (c10 != '>') {
                        if (c10 >= '0' && c10 <= '9') {
                            sb.append((char) (c10 - ','));
                        } else if (c10 >= 'A' && c10 <= 'Z') {
                            sb.append((char) (c10 - '3'));
                        } else {
                            j.e(c10);
                        }
                    } else {
                        sb.append((char) 2);
                    }
                } else {
                    sb.append((char) 1);
                }
            } else {
                sb.append((char) 3);
            }
        } else {
            sb.append((char) 0);
        }
        return 1;
    }

    @Override // b9.c
    public int e() {
        return 3;
    }

    @Override // b9.c
    void f(h hVar, StringBuilder sb) {
        hVar.p();
        int a10 = hVar.g().a() - hVar.a();
        hVar.f٥٥٥٥d -= sb.length();
        if (hVar.f() > 1 || a10 > 1 || hVar.f() != a10) {
            hVar.r((char) 254);
        }
        if (hVar.e() < 0) {
            hVar.o(0);
        }
    }
}
