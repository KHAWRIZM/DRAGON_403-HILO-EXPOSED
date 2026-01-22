package b7;

import android.content.Context;
import b7.v;
import j7.n0;
import j7.w0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class e {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class b implements v.a {

        /* renamed from: a, reason: collision with root package name */
        private Context f٥٥٠٦a;

        private b() {
        }

        @Override // b7.v.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Context context) {
            this.f٥٥٠٦a = (Context) d7.d.b(context);
            return this;
        }

        @Override // b7.v.a
        public v build() {
            d7.d.a(this.f٥٥٠٦a, Context.class);
            return new c(this.f٥٥٠٦a);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class c extends v {

        /* renamed from: a, reason: collision with root package name */
        private final c f٥٥٠٧a;

        /* renamed from: b, reason: collision with root package name */
        private ne.a f٥٥٠٨b;

        /* renamed from: c, reason: collision with root package name */
        private ne.a f٥٥٠٩c;

        /* renamed from: d, reason: collision with root package name */
        private ne.a f٥٥١٠d;

        /* renamed from: e, reason: collision with root package name */
        private ne.a f٥٥١١e;

        /* renamed from: f, reason: collision with root package name */
        private ne.a f٥٥١٢f;

        /* renamed from: g, reason: collision with root package name */
        private ne.a f٥٥١٣g;

        /* renamed from: h, reason: collision with root package name */
        private ne.a f٥٥١٤h;

        /* renamed from: i, reason: collision with root package name */
        private ne.a f٥٥١٥i;

        /* renamed from: j, reason: collision with root package name */
        private ne.a f٥٥١٦j;

        /* renamed from: k, reason: collision with root package name */
        private ne.a f٥٥١٧k;

        /* renamed from: l, reason: collision with root package name */
        private ne.a f٥٥١٨l;

        /* renamed from: m, reason: collision with root package name */
        private ne.a f٥٥١٩m;

        /* renamed from: n, reason: collision with root package name */
        private ne.a f٥٥٢٠n;

        private void c(Context context) {
            this.f٥٥٠٨b = d7.a.a(k.a());
            d7.b a10 = d7.c.a(context);
            this.f٥٥٠٩c = a10;
            c7.j a11 = c7.j.a(a10, l7.c.a(), l7.d.a());
            this.f٥٥١٠d = a11;
            this.f٥٥١١e = d7.a.a(c7.l.a(this.f٥٥٠٩c, a11));
            this.f٥٥١٢f = w0.a(this.f٥٥٠٩c, j7.g.a(), j7.i.a());
            this.f٥٥١٣g = d7.a.a(j7.h.a(this.f٥٥٠٩c));
            this.f٥٥١٤h = d7.a.a(n0.a(l7.c.a(), l7.d.a(), j7.j.a(), this.f٥٥١٢f, this.f٥٥١٣g));
            h7.g b10 = h7.g.b(l7.c.a());
            this.f٥٥١٥i = b10;
            h7.i a12 = h7.i.a(this.f٥٥٠٩c, this.f٥٥١٤h, b10, l7.d.a());
            this.f٥٥١٦j = a12;
            ne.a aVar = this.f٥٥٠٨b;
            ne.a aVar2 = this.f٥٥١١e;
            ne.a aVar3 = this.f٥٥١٤h;
            this.f٥٥١٧k = h7.d.a(aVar, aVar2, a12, aVar3, aVar3);
            ne.a aVar4 = this.f٥٥٠٩c;
            ne.a aVar5 = this.f٥٥١١e;
            ne.a aVar6 = this.f٥٥١٤h;
            this.f٥٥١٨l = i7.s.a(aVar4, aVar5, aVar6, this.f٥٥١٦j, this.f٥٥٠٨b, aVar6, l7.c.a(), l7.d.a(), this.f٥٥١٤h);
            ne.a aVar7 = this.f٥٥٠٨b;
            ne.a aVar8 = this.f٥٥١٤h;
            this.f٥٥١٩m = i7.w.a(aVar7, aVar8, this.f٥٥١٦j, aVar8);
            this.f٥٥٢٠n = d7.a.a(w.a(l7.c.a(), l7.d.a(), this.f٥٥١٧k, this.f٥٥١٨l, this.f٥٥١٩m));
        }

        @Override // b7.v
        j7.d a() {
            return (j7.d) this.f٥٥١٤h.get();
        }

        @Override // b7.v
        u b() {
            return (u) this.f٥٥٢٠n.get();
        }

        private c(Context context) {
            this.f٥٥٠٧a = this;
            c(context);
        }
    }

    public static v.a a() {
        return new b();
    }
}
