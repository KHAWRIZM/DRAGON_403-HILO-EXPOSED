package d2;

import c2.e;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c extends p {

    /* renamed from: k, reason: collision with root package name */
    ArrayList f١٣٥٥٧k;

    /* renamed from: l, reason: collision with root package name */
    private int f١٣٥٥٨l;

    public c(c2.e eVar, int i10) {
        super(eVar);
        this.f١٣٥٥٧k = new ArrayList();
        this.f١٣٦٢٦f = i10;
        q();
    }

    private void q() {
        c2.e eVar;
        int U;
        c2.e eVar2 = this.f١٣٦٢٢b;
        c2.e N = eVar2.N(this.f١٣٦٢٦f);
        while (true) {
            c2.e eVar3 = N;
            eVar = eVar2;
            eVar2 = eVar3;
            if (eVar2 == null) {
                break;
            } else {
                N = eVar2.N(this.f١٣٦٢٦f);
            }
        }
        this.f١٣٦٢٢b = eVar;
        this.f١٣٥٥٧k.add(eVar.P(this.f١٣٦٢٦f));
        c2.e L = eVar.L(this.f١٣٦٢٦f);
        while (L != null) {
            this.f١٣٥٥٧k.add(L.P(this.f١٣٦٢٦f));
            L = L.L(this.f١٣٦٢٦f);
        }
        Iterator it = this.f١٣٥٥٧k.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            int i10 = this.f١٣٦٢٦f;
            if (i10 == 0) {
                pVar.f١٣٦٢٢b.f٥٧٠٥c = this;
            } else if (i10 == 1) {
                pVar.f١٣٦٢٢b.f٥٧٠٧d = this;
            }
        }
        if (this.f١٣٦٢٦f == 0 && ((c2.f) this.f١٣٦٢٢b.M()).U1() && this.f١٣٥٥٧k.size() > 1) {
            ArrayList arrayList = this.f١٣٥٥٧k;
            this.f١٣٦٢٢b = ((p) arrayList.get(arrayList.size() - 1)).f١٣٦٢٢b;
        }
        if (this.f١٣٦٢٦f == 0) {
            U = this.f١٣٦٢٢b.B();
        } else {
            U = this.f١٣٦٢٢b.U();
        }
        this.f١٣٥٥٨l = U;
    }

    private c2.e r() {
        for (int i10 = 0; i10 < this.f١٣٥٥٧k.size(); i10++) {
            p pVar = (p) this.f١٣٥٥٧k.get(i10);
            if (pVar.f١٣٦٢٢b.X() != 8) {
                return pVar.f١٣٦٢٢b;
            }
        }
        return null;
    }

    private c2.e s() {
        for (int size = this.f١٣٥٥٧k.size() - 1; size >= 0; size--) {
            p pVar = (p) this.f١٣٥٥٧k.get(size);
            if (pVar.f١٣٦٢٢b.X() != 8) {
                return pVar.f١٣٦٢٢b;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:288:0x0400, code lost:
    
        r7 = r7 - r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e9  */
    @Override // d2.p, d2.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        float f10;
        boolean z10;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        float f11;
        boolean z11;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        if (this.f١٣٦٢٨h.f١٣٥٧٧j && this.f١٣٦٢٩i.f١٣٥٧٧j) {
            c2.e M = this.f١٣٦٢٢b.M();
            boolean U1 = M instanceof c2.f ? ((c2.f) M).U1() : false;
            int i26 = this.f١٣٦٢٩i.f١٣٥٧٤g - this.f١٣٦٢٨h.f١٣٥٧٤g;
            int size = this.f١٣٥٥٧k.size();
            int i27 = 0;
            while (true) {
                i10 = -1;
                i11 = 8;
                if (i27 >= size) {
                    i27 = -1;
                    break;
                } else if (((p) this.f١٣٥٥٧k.get(i27)).f١٣٦٢٢b.X() != 8) {
                    break;
                } else {
                    i27++;
                }
            }
            int i28 = size - 1;
            int i29 = i28;
            while (true) {
                if (i29 < 0) {
                    break;
                }
                if (((p) this.f١٣٥٥٧k.get(i29)).f١٣٦٢٢b.X() != 8) {
                    i10 = i29;
                    break;
                }
                i29--;
            }
            int i30 = 0;
            while (i30 < 2) {
                int i31 = 0;
                i13 = 0;
                i14 = 0;
                int i32 = 0;
                f10 = DownloadProgress.UNKNOWN_PROGRESS;
                while (i31 < size) {
                    p pVar = (p) this.f١٣٥٥٧k.get(i31);
                    if (pVar.f١٣٦٢٢b.X() != i11) {
                        i32++;
                        if (i31 > 0 && i31 >= i27) {
                            i13 += pVar.f١٣٦٢٨h.f١٣٥٧٣f;
                        }
                        g gVar = pVar.f١٣٦٢٥e;
                        int i33 = gVar.f١٣٥٧٤g;
                        boolean z12 = pVar.f١٣٦٢٤d != e.b.MATCH_CONSTRAINT;
                        if (z12) {
                            int i34 = this.f١٣٦٢٦f;
                            if (i34 == 0 && !pVar.f١٣٦٢٢b.f٥٧٠٩e.f١٣٦٢٥e.f١٣٥٧٧j) {
                                return;
                            }
                            if (i34 == 1 && !pVar.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٥e.f١٣٥٧٧j) {
                                return;
                            } else {
                                i24 = i33;
                            }
                        } else {
                            i24 = i33;
                            if (pVar.f١٣٦٢١a == 1 && i30 == 0) {
                                i25 = gVar.f١٣٥٨٩m;
                                i14++;
                            } else if (gVar.f١٣٥٧٧j) {
                                i25 = i24;
                            }
                            z12 = true;
                            if (z12) {
                                i14++;
                                float f12 = pVar.f١٣٦٢٢b.N0[this.f١٣٦٢٦f];
                                if (f12 >= DownloadProgress.UNKNOWN_PROGRESS) {
                                    f10 += f12;
                                }
                            } else {
                                i13 += i25;
                            }
                            if (i31 < i28 && i31 < i10) {
                                i13 += -pVar.f١٣٦٢٩i.f١٣٥٧٣f;
                            }
                        }
                        i25 = i24;
                        if (z12) {
                        }
                        if (i31 < i28) {
                            i13 += -pVar.f١٣٦٢٩i.f١٣٥٧٣f;
                        }
                    }
                    i31++;
                    i11 = 8;
                }
                if (i13 < i26 || i14 == 0) {
                    i12 = i32;
                    break;
                } else {
                    i30++;
                    i11 = 8;
                }
            }
            i12 = 0;
            i13 = 0;
            i14 = 0;
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
            int i35 = this.f١٣٦٢٨h.f١٣٥٧٤g;
            if (U1) {
                i35 = this.f١٣٦٢٩i.f١٣٥٧٤g;
            }
            if (i13 > i26) {
                i35 = U1 ? i35 + ((int) (((i13 - i26) / 2.0f) + 0.5f)) : i35 - ((int) (((i13 - i26) / 2.0f) + 0.5f));
            }
            if (i14 > 0) {
                float f13 = i26 - i13;
                int i36 = (int) ((f13 / i14) + 0.5f);
                int i37 = 0;
                int i38 = 0;
                while (i37 < size) {
                    p pVar2 = (p) this.f١٣٥٥٧k.get(i37);
                    int i39 = i36;
                    int i40 = i13;
                    if (pVar2.f١٣٦٢٢b.X() != 8 && pVar2.f١٣٦٢٤d == e.b.MATCH_CONSTRAINT) {
                        g gVar2 = pVar2.f١٣٦٢٥e;
                        if (!gVar2.f١٣٥٧٧j) {
                            if (f10 > DownloadProgress.UNKNOWN_PROGRESS) {
                                i19 = i35;
                                i20 = (int) (((pVar2.f١٣٦٢٢b.N0[this.f١٣٦٢٦f] * f13) / f10) + 0.5f);
                            } else {
                                i19 = i35;
                                i20 = i39;
                            }
                            if (this.f١٣٦٢٦f == 0) {
                                c2.e eVar = pVar2.f١٣٦٢٢b;
                                f11 = f13;
                                i22 = eVar.A;
                                i21 = eVar.f٥٧٥١z;
                                z11 = U1;
                            } else {
                                f11 = f13;
                                c2.e eVar2 = pVar2.f١٣٦٢٢b;
                                int i41 = eVar2.D;
                                z11 = U1;
                                i21 = eVar2.C;
                                i22 = i41;
                            }
                            i23 = i12;
                            int max = Math.max(i21, pVar2.f١٣٦٢١a == 1 ? Math.min(i20, gVar2.f١٣٥٨٩m) : i20);
                            if (i22 > 0) {
                                max = Math.min(i22, max);
                            }
                            if (max != i20) {
                                i38++;
                                i20 = max;
                            }
                            pVar2.f١٣٦٢٥e.d(i20);
                            i37++;
                            i36 = i39;
                            i13 = i40;
                            i35 = i19;
                            f13 = f11;
                            U1 = z11;
                            i12 = i23;
                        }
                    }
                    z11 = U1;
                    i23 = i12;
                    i19 = i35;
                    f11 = f13;
                    i37++;
                    i36 = i39;
                    i13 = i40;
                    i35 = i19;
                    f13 = f11;
                    U1 = z11;
                    i12 = i23;
                }
                z10 = U1;
                i15 = i12;
                i16 = i35;
                int i42 = i13;
                if (i38 > 0) {
                    i14 -= i38;
                    i13 = 0;
                    for (int i43 = 0; i43 < size; i43++) {
                        p pVar3 = (p) this.f١٣٥٥٧k.get(i43);
                        if (pVar3.f١٣٦٢٢b.X() != 8) {
                            if (i43 > 0 && i43 >= i27) {
                                i13 += pVar3.f١٣٦٢٨h.f١٣٥٧٣f;
                            }
                            i13 += pVar3.f١٣٦٢٥e.f١٣٥٧٤g;
                            if (i43 < i28 && i43 < i10) {
                                i13 += -pVar3.f١٣٦٢٩i.f١٣٥٧٣f;
                            }
                        }
                    }
                } else {
                    i13 = i42;
                }
                i17 = 2;
                if (this.f١٣٥٥٨l == 2 && i38 == 0) {
                    this.f١٣٥٥٨l = 0;
                }
            } else {
                z10 = U1;
                i15 = i12;
                i16 = i35;
                i17 = 2;
            }
            if (i13 > i26) {
                this.f١٣٥٥٨l = i17;
            }
            if (i15 > 0 && i14 == 0 && i27 == i10) {
                this.f١٣٥٥٨l = i17;
            }
            int i44 = this.f١٣٥٥٨l;
            if (i44 == 1) {
                int i45 = i15;
                if (i45 > 1) {
                    i18 = (i26 - i13) / (i45 - 1);
                } else {
                    i18 = i45 == 1 ? (i26 - i13) / 2 : 0;
                }
                if (i14 > 0) {
                    i18 = 0;
                }
                int i46 = i16;
                for (int i47 = 0; i47 < size; i47++) {
                    p pVar4 = (p) this.f١٣٥٥٧k.get(z10 ? size - (i47 + 1) : i47);
                    if (pVar4.f١٣٦٢٢b.X() == 8) {
                        pVar4.f١٣٦٢٨h.d(i46);
                        pVar4.f١٣٦٢٩i.d(i46);
                    } else {
                        if (i47 > 0) {
                            i46 = z10 ? i46 - i18 : i46 + i18;
                        }
                        if (i47 > 0 && i47 >= i27) {
                            if (z10) {
                                i46 -= pVar4.f١٣٦٢٨h.f١٣٥٧٣f;
                            } else {
                                i46 += pVar4.f١٣٦٢٨h.f١٣٥٧٣f;
                            }
                        }
                        if (z10) {
                            pVar4.f١٣٦٢٩i.d(i46);
                        } else {
                            pVar4.f١٣٦٢٨h.d(i46);
                        }
                        g gVar3 = pVar4.f١٣٦٢٥e;
                        int i48 = gVar3.f١٣٥٧٤g;
                        if (pVar4.f١٣٦٢٤d == e.b.MATCH_CONSTRAINT && pVar4.f١٣٦٢١a == 1) {
                            i48 = gVar3.f١٣٥٨٩m;
                        }
                        i46 = z10 ? i46 - i48 : i46 + i48;
                        if (z10) {
                            pVar4.f١٣٦٢٨h.d(i46);
                        } else {
                            pVar4.f١٣٦٢٩i.d(i46);
                        }
                        pVar4.f١٣٦٢٧g = true;
                        if (i47 < i28 && i47 < i10) {
                            if (z10) {
                                i46 -= -pVar4.f١٣٦٢٩i.f١٣٥٧٣f;
                            } else {
                                i46 += -pVar4.f١٣٦٢٩i.f١٣٥٧٣f;
                            }
                        }
                    }
                }
                return;
            }
            int i49 = i15;
            if (i44 == 0) {
                int i50 = (i26 - i13) / (i49 + 1);
                if (i14 > 0) {
                    i50 = 0;
                }
                int i51 = i16;
                for (int i52 = 0; i52 < size; i52++) {
                    p pVar5 = (p) this.f١٣٥٥٧k.get(z10 ? size - (i52 + 1) : i52);
                    if (pVar5.f١٣٦٢٢b.X() == 8) {
                        pVar5.f١٣٦٢٨h.d(i51);
                        pVar5.f١٣٦٢٩i.d(i51);
                    } else {
                        int i53 = z10 ? i51 - i50 : i51 + i50;
                        if (i52 > 0 && i52 >= i27) {
                            if (z10) {
                                i53 -= pVar5.f١٣٦٢٨h.f١٣٥٧٣f;
                            } else {
                                i53 += pVar5.f١٣٦٢٨h.f١٣٥٧٣f;
                            }
                        }
                        if (z10) {
                            pVar5.f١٣٦٢٩i.d(i53);
                        } else {
                            pVar5.f١٣٦٢٨h.d(i53);
                        }
                        g gVar4 = pVar5.f١٣٦٢٥e;
                        int i54 = gVar4.f١٣٥٧٤g;
                        if (pVar5.f١٣٦٢٤d == e.b.MATCH_CONSTRAINT && pVar5.f١٣٦٢١a == 1) {
                            i54 = Math.min(i54, gVar4.f١٣٥٨٩m);
                        }
                        i51 = z10 ? i53 - i54 : i53 + i54;
                        if (z10) {
                            pVar5.f١٣٦٢٨h.d(i51);
                        } else {
                            pVar5.f١٣٦٢٩i.d(i51);
                        }
                        if (i52 < i28 && i52 < i10) {
                            if (z10) {
                                i51 -= -pVar5.f١٣٦٢٩i.f١٣٥٧٣f;
                            } else {
                                i51 += -pVar5.f١٣٦٢٩i.f١٣٥٧٣f;
                            }
                        }
                    }
                }
                return;
            }
            if (i44 == 2) {
                float A = this.f١٣٦٢٦f == 0 ? this.f١٣٦٢٢b.A() : this.f١٣٦٢٢b.T();
                if (z10) {
                    A = 1.0f - A;
                }
                int i55 = (int) (((i26 - i13) * A) + 0.5f);
                if (i55 < 0 || i14 > 0) {
                    i55 = 0;
                }
                int i56 = z10 ? i16 - i55 : i16 + i55;
                for (int i57 = 0; i57 < size; i57++) {
                    p pVar6 = (p) this.f١٣٥٥٧k.get(z10 ? size - (i57 + 1) : i57);
                    if (pVar6.f١٣٦٢٢b.X() == 8) {
                        pVar6.f١٣٦٢٨h.d(i56);
                        pVar6.f١٣٦٢٩i.d(i56);
                    } else {
                        if (i57 > 0 && i57 >= i27) {
                            if (z10) {
                                i56 -= pVar6.f١٣٦٢٨h.f١٣٥٧٣f;
                            } else {
                                i56 += pVar6.f١٣٦٢٨h.f١٣٥٧٣f;
                            }
                        }
                        if (z10) {
                            pVar6.f١٣٦٢٩i.d(i56);
                        } else {
                            pVar6.f١٣٦٢٨h.d(i56);
                        }
                        g gVar5 = pVar6.f١٣٦٢٥e;
                        int i58 = gVar5.f١٣٥٧٤g;
                        if (pVar6.f١٣٦٢٤d == e.b.MATCH_CONSTRAINT && pVar6.f١٣٦٢١a == 1) {
                            i58 = gVar5.f١٣٥٨٩m;
                        }
                        i56 += i58;
                        if (z10) {
                            pVar6.f١٣٦٢٨h.d(i56);
                        } else {
                            pVar6.f١٣٦٢٩i.d(i56);
                        }
                        if (i57 < i28 && i57 < i10) {
                            if (z10) {
                                i56 -= -pVar6.f١٣٦٢٩i.f١٣٥٧٣f;
                            } else {
                                i56 += -pVar6.f١٣٦٢٩i.f١٣٥٧٣f;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d2.p
    public void d() {
        Iterator it = this.f١٣٥٥٧k.iterator();
        while (it.hasNext()) {
            ((p) it.next()).d();
        }
        int size = this.f١٣٥٥٧k.size();
        if (size < 1) {
            return;
        }
        c2.e eVar = ((p) this.f١٣٥٥٧k.get(0)).f١٣٦٢٢b;
        c2.e eVar2 = ((p) this.f١٣٥٥٧k.get(size - 1)).f١٣٦٢٢b;
        if (this.f١٣٦٢٦f == 0) {
            c2.d dVar = eVar.Q;
            c2.d dVar2 = eVar2.S;
            f i10 = i(dVar, 0);
            int f10 = dVar.f();
            c2.e r10 = r();
            if (r10 != null) {
                f10 = r10.Q.f();
            }
            if (i10 != null) {
                b(this.f١٣٦٢٨h, i10, f10);
            }
            f i11 = i(dVar2, 0);
            int f11 = dVar2.f();
            c2.e s10 = s();
            if (s10 != null) {
                f11 = s10.S.f();
            }
            if (i11 != null) {
                b(this.f١٣٦٢٩i, i11, -f11);
            }
        } else {
            c2.d dVar3 = eVar.R;
            c2.d dVar4 = eVar2.T;
            f i12 = i(dVar3, 1);
            int f12 = dVar3.f();
            c2.e r11 = r();
            if (r11 != null) {
                f12 = r11.R.f();
            }
            if (i12 != null) {
                b(this.f١٣٦٢٨h, i12, f12);
            }
            f i13 = i(dVar4, 1);
            int f13 = dVar4.f();
            c2.e s11 = s();
            if (s11 != null) {
                f13 = s11.T.f();
            }
            if (i13 != null) {
                b(this.f١٣٦٢٩i, i13, -f13);
            }
        }
        this.f١٣٦٢٨h.f١٣٥٦٨a = this;
        this.f١٣٦٢٩i.f١٣٥٦٨a = this;
    }

    @Override // d2.p
    public void e() {
        for (int i10 = 0; i10 < this.f١٣٥٥٧k.size(); i10++) {
            ((p) this.f١٣٥٥٧k.get(i10)).e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d2.p
    public void f() {
        this.f١٣٦٢٣c = null;
        Iterator it = this.f١٣٥٥٧k.iterator();
        while (it.hasNext()) {
            ((p) it.next()).f();
        }
    }

    @Override // d2.p
    public long j() {
        int size = this.f١٣٥٥٧k.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            j10 = j10 + r4.f١٣٦٢٨h.f١٣٥٧٣f + ((p) this.f١٣٥٥٧k.get(i10)).j() + r4.f١٣٦٢٩i.f١٣٥٧٣f;
        }
        return j10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d2.p
    public boolean m() {
        int size = this.f١٣٥٥٧k.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!((p) this.f١٣٥٥٧k.get(i10)).m()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ChainRun ");
        if (this.f١٣٦٢٦f == 0) {
            str = "horizontal : ";
        } else {
            str = "vertical : ";
        }
        sb.append(str);
        Iterator it = this.f١٣٥٥٧k.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            sb.append("<");
            sb.append(pVar);
            sb.append("> ");
        }
        return sb.toString();
    }
}
