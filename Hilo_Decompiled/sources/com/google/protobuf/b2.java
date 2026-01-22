package com.google.protobuf;

import com.google.protobuf.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class b2 implements a.b {

    /* renamed from: a, reason: collision with root package name */
    private a.b f١٠٨٩٤a;

    /* renamed from: b, reason: collision with root package name */
    private a.AbstractC٠١٣٢a f١٠٨٩٥b;

    /* renamed from: c, reason: collision with root package name */
    private a f١٠٨٩٦c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f١٠٨٩٧d;

    public b2(a aVar, a.b bVar, boolean z10) {
        this.f١٠٨٩٦c = (a) j0.a(aVar);
        this.f١٠٨٩٤a = bVar;
        this.f١٠٨٩٧d = z10;
    }

    private void h() {
        a.b bVar;
        if (this.f١٠٨٩٥b != null) {
            this.f١٠٨٩٦c = null;
        }
        if (this.f١٠٨٩٧d && (bVar = this.f١٠٨٩٤a) != null) {
            bVar.a();
            this.f١٠٨٩٧d = false;
        }
    }

    @Override // com.google.protobuf.a.b
    public void a() {
        h();
    }

    public a b() {
        this.f١٠٨٩٧d = true;
        return e();
    }

    public void c() {
        this.f١٠٨٩٤a = null;
    }

    public a.AbstractC٠١٣٢a d() {
        if (this.f١٠٨٩٥b == null) {
            a.AbstractC٠١٣٢a r02 = (a.AbstractC٠١٣٢a) this.f١٠٨٩٦c.newBuilderForType(this);
            this.f١٠٨٩٥b = r02;
            r02.mergeFrom((b1) this.f١٠٨٩٦c);
            this.f١٠٨٩٥b.markClean();
        }
        return this.f١٠٨٩٥b;
    }

    public a e() {
        if (this.f١٠٨٩٦c == null) {
            this.f١٠٨٩٦c = (a) this.f١٠٨٩٥b.buildPartial();
        }
        return this.f١٠٨٩٦c;
    }

    public g1 f() {
        a.AbstractC٠١٣٢a r02 = this.f١٠٨٩٥b;
        if (r02 != null) {
            return r02;
        }
        return this.f١٠٨٩٦c;
    }

    public b2 g(a aVar) {
        if (this.f١٠٨٩٥b == null) {
            b1 b1Var = this.f١٠٨٩٦c;
            if (b1Var == b1Var.getDefaultInstanceForType()) {
                this.f١٠٨٩٦c = aVar;
                h();
                return this;
            }
        }
        d().mergeFrom((b1) aVar);
        h();
        return this;
    }

    public b2 i(a aVar) {
        this.f١٠٨٩٦c = (a) j0.a(aVar);
        a.AbstractC٠١٣٢a r12 = this.f١٠٨٩٥b;
        if (r12 != null) {
            r12.dispose();
            this.f١٠٨٩٥b = null;
        }
        h();
        return this;
    }
}
