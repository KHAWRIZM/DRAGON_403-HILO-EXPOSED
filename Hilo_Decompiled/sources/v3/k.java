package v3;

import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class k {

    /* renamed from: f, reason: collision with root package name */
    private static final c.a f١٨٤٢٨f = c.a.a("ef");

    /* renamed from: g, reason: collision with root package name */
    private static final c.a f١٨٤٢٩g = c.a.a("nm", "v");

    /* renamed from: a, reason: collision with root package name */
    private r3.a f١٨٤٣٠a;

    /* renamed from: b, reason: collision with root package name */
    private r3.b f١٨٤٣١b;

    /* renamed from: c, reason: collision with root package name */
    private r3.b f١٨٤٣٢c;

    /* renamed from: d, reason: collision with root package name */
    private r3.b f١٨٤٣٣d;

    /* renamed from: e, reason: collision with root package name */
    private r3.b f١٨٤٣٤e;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
    
        switch(r3) {
            case 0: goto L٥٠;
            case 1: goto L٤٩;
            case 2: goto L٤٨;
            case 3: goto L٤٧;
            case 4: goto L٤٦;
            default: goto L٥١;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        r5.f١٨٤٣٤e = v3.d.e(r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006e, code lost:
    
        r5.f١٨٤٣٠a = v3.d.c(r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0075, code lost:
    
        r5.f١٨٤٣٢c = v3.d.f(r6, r7, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007c, code lost:
    
        r5.f١٨٤٣١b = v3.d.f(r6, r7, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
    
        r5.f١٨٤٣٣d = v3.d.e(r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0063, code lost:
    
        r6.A();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(w3.c cVar, com.airbnb.lottie.j jVar) {
        cVar.c();
        String str = "";
        while (cVar.j()) {
            int x10 = cVar.x(f١٨٤٢٩g);
            if (x10 != 0) {
                if (x10 != 1) {
                    cVar.z();
                    cVar.A();
                } else {
                    str.hashCode();
                    char c10 = 65535;
                    switch (str.hashCode()) {
                        case 353103893:
                            if (str.equals("Distance")) {
                                c10 = 0;
                                break;
                            }
                            break;
                        case 397447147:
                            if (str.equals("Opacity")) {
                                c10 = 1;
                                break;
                            }
                            break;
                        case 1041377119:
                            if (str.equals("Direction")) {
                                c10 = 2;
                                break;
                            }
                            break;
                        case 1379387491:
                            if (str.equals("Shadow Color")) {
                                c10 = 3;
                                break;
                            }
                            break;
                        case 1383710113:
                            if (str.equals("Softness")) {
                                c10 = 4;
                                break;
                            }
                            break;
                    }
                }
            } else {
                str = cVar.s();
            }
        }
        cVar.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j b(w3.c cVar, com.airbnb.lottie.j jVar) {
        r3.b bVar;
        r3.b bVar2;
        r3.b bVar3;
        r3.b bVar4;
        while (cVar.j()) {
            if (cVar.x(f١٨٤٢٨f) != 0) {
                cVar.z();
                cVar.A();
            } else {
                cVar.b();
                while (cVar.j()) {
                    a(cVar, jVar);
                }
                cVar.g();
            }
        }
        r3.a aVar = this.f١٨٤٣٠a;
        if (aVar != null && (bVar = this.f١٨٤٣١b) != null && (bVar2 = this.f١٨٤٣٢c) != null && (bVar3 = this.f١٨٤٣٣d) != null && (bVar4 = this.f١٨٤٣٤e) != null) {
            return new j(aVar, bVar, bVar2, bVar3, bVar4);
        }
        return null;
    }
}
