package com.google.android.material.carousel;

import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final float f٨٦٦٢a;

    /* renamed from: b, reason: collision with root package name */
    private int f٨٦٦٣b;

    /* renamed from: c, reason: collision with root package name */
    private final List f٨٦٦٤c;

    /* renamed from: d, reason: collision with root package name */
    private final int f٨٦٦٥d;

    /* renamed from: e, reason: collision with root package name */
    private final int f٨٦٦٦e;

    /* renamed from: f, reason: collision with root package name */
    private final int f٨٦٦٧f;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final float f٨٦٦٨a;

        /* renamed from: b, reason: collision with root package name */
        private final int f٨٦٦٩b;

        /* renamed from: d, reason: collision with root package name */
        private c f٨٦٧١d;

        /* renamed from: e, reason: collision with root package name */
        private c f٨٦٧٢e;

        /* renamed from: c, reason: collision with root package name */
        private final List f٨٦٧٠c = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        private int f٨٦٧٣f = -1;

        /* renamed from: g, reason: collision with root package name */
        private int f٨٦٧٤g = -1;

        /* renamed from: h, reason: collision with root package name */
        private float f٨٦٧٥h = DownloadProgress.UNKNOWN_PROGRESS;

        /* renamed from: i, reason: collision with root package name */
        private int f٨٦٧٦i = -1;

        public b(float f10, int i10) {
            this.f٨٦٦٨a = f10;
            this.f٨٦٦٩b = i10;
        }

        private static float j(float f10, float f11, int i10, int i11) {
            return (f10 - (i10 * f11)) + (i11 * f11);
        }

        public b a(float f10, float f11, float f12) {
            return d(f10, f11, f12, false, true);
        }

        public b b(float f10, float f11, float f12) {
            return c(f10, f11, f12, false);
        }

        public b c(float f10, float f11, float f12, boolean z10) {
            return d(f10, f11, f12, z10, false);
        }

        public b d(float f10, float f11, float f12, boolean z10, boolean z11) {
            float f13;
            float abs;
            float f14 = f12 / 2.0f;
            float f15 = f10 - f14;
            float f16 = f14 + f10;
            int i10 = this.f٨٦٦٩b;
            if (f16 > i10) {
                abs = Math.abs(f16 - Math.max(f16 - f12, i10));
            } else if (f15 < DownloadProgress.UNKNOWN_PROGRESS) {
                abs = Math.abs(f15 - Math.min(f15 + f12, DownloadProgress.UNKNOWN_PROGRESS));
            } else {
                f13 = DownloadProgress.UNKNOWN_PROGRESS;
                return e(f10, f11, f12, z10, z11, f13);
            }
            f13 = abs;
            return e(f10, f11, f12, z10, z11, f13);
        }

        public b e(float f10, float f11, float f12, boolean z10, boolean z11, float f13) {
            return f(f10, f11, f12, z10, z11, f13, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
        }

        public b f(float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14, float f15) {
            if (f12 <= DownloadProgress.UNKNOWN_PROGRESS) {
                return this;
            }
            if (z11) {
                if (!z10) {
                    int i10 = this.f٨٦٧٦i;
                    if (i10 != -1 && i10 != 0) {
                        throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                    }
                    this.f٨٦٧٦i = this.f٨٦٧٠c.size();
                } else {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
            }
            c cVar = new c(Float.MIN_VALUE, f10, f11, f12, z11, f13, f14, f15);
            if (z10) {
                if (this.f٨٦٧١d == null) {
                    this.f٨٦٧١d = cVar;
                    this.f٨٦٧٣f = this.f٨٦٧٠c.size();
                }
                if (this.f٨٦٧٤g != -1 && this.f٨٦٧٠c.size() - this.f٨٦٧٤g > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f12 == this.f٨٦٧١d.f٨٦٨٠d) {
                    this.f٨٦٧٢e = cVar;
                    this.f٨٦٧٤g = this.f٨٦٧٠c.size();
                } else {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
            } else {
                if (this.f٨٦٧١d == null && cVar.f٨٦٨٠d < this.f٨٦٧٥h) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.f٨٦٧٢e != null && cVar.f٨٦٨٠d > this.f٨٦٧٥h) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.f٨٦٧٥h = cVar.f٨٦٨٠d;
            this.f٨٦٧٠c.add(cVar);
            return this;
        }

        public b g(float f10, float f11, float f12, int i10) {
            return h(f10, f11, f12, i10, false);
        }

        public b h(float f10, float f11, float f12, int i10, boolean z10) {
            if (i10 > 0 && f12 > DownloadProgress.UNKNOWN_PROGRESS) {
                for (int i11 = 0; i11 < i10; i11++) {
                    c((i11 * f12) + f10, f11, f12, z10);
                }
            }
            return this;
        }

        public e i() {
            if (this.f٨٦٧١d != null) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < this.f٨٦٧٠c.size(); i10++) {
                    c cVar = (c) this.f٨٦٧٠c.get(i10);
                    arrayList.add(new c(j(this.f٨٦٧١d.f٨٦٧٨b, this.f٨٦٦٨a, this.f٨٦٧٣f, i10), cVar.f٨٦٧٨b, cVar.f٨٦٧٩c, cVar.f٨٦٨٠d, cVar.f٨٦٨١e, cVar.f٨٦٨٢f, cVar.f٨٦٨٣g, cVar.f٨٦٨٤h));
                }
                return new e(this.f٨٦٦٨a, arrayList, this.f٨٦٧٣f, this.f٨٦٧٤g, this.f٨٦٦٩b);
            }
            throw new IllegalStateException("There must be a keyline marked as focal.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        final float f٨٦٧٧a;

        /* renamed from: b, reason: collision with root package name */
        final float f٨٦٧٨b;

        /* renamed from: c, reason: collision with root package name */
        final float f٨٦٧٩c;

        /* renamed from: d, reason: collision with root package name */
        final float f٨٦٨٠d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f٨٦٨١e;

        /* renamed from: f, reason: collision with root package name */
        final float f٨٦٨٢f;

        /* renamed from: g, reason: collision with root package name */
        final float f٨٦٨٣g;

        /* renamed from: h, reason: collision with root package name */
        final float f٨٦٨٤h;

        c(float f10, float f11, float f12, float f13) {
            this(f10, f11, f12, f13, false, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
        }

        static c a(c cVar, c cVar2, float f10) {
            return new c(p7.a.a(cVar.f٨٦٧٧a, cVar2.f٨٦٧٧a, f10), p7.a.a(cVar.f٨٦٧٨b, cVar2.f٨٦٧٨b, f10), p7.a.a(cVar.f٨٦٧٩c, cVar2.f٨٦٧٩c, f10), p7.a.a(cVar.f٨٦٨٠d, cVar2.f٨٦٨٠d, f10));
        }

        c(float f10, float f11, float f12, float f13, boolean z10, float f14, float f15, float f16) {
            this.f٨٦٧٧a = f10;
            this.f٨٦٧٨b = f11;
            this.f٨٦٧٩c = f12;
            this.f٨٦٨٠d = f13;
            this.f٨٦٨١e = z10;
            this.f٨٦٨٢f = f14;
            this.f٨٦٨٣g = f15;
            this.f٨٦٨٤h = f16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e o(e eVar, e eVar2, float f10) {
        if (eVar.g() == eVar2.g()) {
            List h10 = eVar.h();
            List h11 = eVar2.h();
            if (h10.size() == h11.size()) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < eVar.h().size(); i10++) {
                    arrayList.add(c.a((c) h10.get(i10), (c) h11.get(i10), f10));
                }
                return new e(eVar.g(), arrayList, p7.a.c(eVar.c(), eVar2.c(), f10), p7.a.c(eVar.j(), eVar2.j(), f10), eVar.f٨٦٦٧f);
            }
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e p(e eVar, int i10) {
        boolean z10;
        b bVar = new b(eVar.g(), i10);
        float f10 = (i10 - eVar.k().f٨٦٧٨b) - (eVar.k().f٨٦٨٠d / 2.0f);
        for (int size = eVar.h().size() - 1; size >= 0; size--) {
            c cVar = (c) eVar.h().get(size);
            float f11 = f10 + (cVar.f٨٦٨٠d / 2.0f);
            if (size >= eVar.c() && size <= eVar.j()) {
                z10 = true;
            } else {
                z10 = false;
            }
            bVar.d(f11, cVar.f٨٦٧٩c, cVar.f٨٦٨٠d, z10, cVar.f٨٦٨١e);
            f10 += cVar.f٨٦٨٠d;
        }
        return bVar.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f٨٦٦٧f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c b() {
        return (c) this.f٨٦٦٤c.get(this.f٨٦٦٥d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f٨٦٦٥d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c d() {
        return (c) this.f٨٦٦٤c.get(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c e() {
        for (int i10 = 0; i10 < this.f٨٦٦٤c.size(); i10++) {
            c cVar = (c) this.f٨٦٦٤c.get(i10);
            if (!cVar.f٨٦٨١e) {
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List f() {
        return this.f٨٦٦٤c.subList(this.f٨٦٦٥d, this.f٨٦٦٦e + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        return this.f٨٦٦٢a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List h() {
        return this.f٨٦٦٤c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c i() {
        return (c) this.f٨٦٦٤c.get(this.f٨٦٦٦e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f٨٦٦٦e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c k() {
        return (c) this.f٨٦٦٤c.get(r0.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c l() {
        for (int size = this.f٨٦٦٤c.size() - 1; size >= 0; size--) {
            c cVar = (c) this.f٨٦٦٤c.get(size);
            if (!cVar.f٨٦٨١e) {
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        Iterator it = this.f٨٦٦٤c.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (((c) it.next()).f٨٦٨١e) {
                i10++;
            }
        }
        return this.f٨٦٦٤c.size() - i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.f٨٦٦٣b;
    }

    private e(float f10, List list, int i10, int i11, int i12) {
        this.f٨٦٦٢a = f10;
        this.f٨٦٦٤c = Collections.unmodifiableList(list);
        this.f٨٦٦٥d = i10;
        this.f٨٦٦٦e = i11;
        while (i10 <= i11) {
            if (((c) list.get(i10)).f٨٦٨٢f == DownloadProgress.UNKNOWN_PROGRESS) {
                this.f٨٦٦٣b++;
            }
            i10++;
        }
        this.f٨٦٦٧f = i12;
    }
}
