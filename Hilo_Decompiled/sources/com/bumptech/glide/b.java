package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.d;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import q4.a;
import q4.i;
import z4.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    private o4.k f٧٢٢٦c;

    /* renamed from: d, reason: collision with root package name */
    private p4.d f٧٢٢٧d;

    /* renamed from: e, reason: collision with root package name */
    private p4.b f٧٢٢٨e;

    /* renamed from: f, reason: collision with root package name */
    private q4.h f٧٢٢٩f;

    /* renamed from: g, reason: collision with root package name */
    private r4.a f٧٢٣٠g;

    /* renamed from: h, reason: collision with root package name */
    private r4.a f٧٢٣١h;

    /* renamed from: i, reason: collision with root package name */
    private a.InterfaceC٠٢١٠a f٧٢٣٢i;

    /* renamed from: j, reason: collision with root package name */
    private q4.i f٧٢٣٣j;

    /* renamed from: k, reason: collision with root package name */
    private z4.c f٧٢٣٤k;

    /* renamed from: n, reason: collision with root package name */
    private o.b f٧٢٣٧n;

    /* renamed from: o, reason: collision with root package name */
    private r4.a f٧٢٣٨o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f٧٢٣٩p;

    /* renamed from: q, reason: collision with root package name */
    private List f٧٢٤٠q;

    /* renamed from: a, reason: collision with root package name */
    private final Map f٧٢٢٤a = new androidx.collection.a();

    /* renamed from: b, reason: collision with root package name */
    private final d.a f٧٢٢٥b = new d.a();

    /* renamed from: l, reason: collision with root package name */
    private int f٧٢٣٥l = 4;

    /* renamed from: m, reason: collision with root package name */
    private Glide.a f٧٢٣٦m = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements Glide.a {
        a() {
        }

        @Override // com.bumptech.glide.Glide.a
        public c5.h build() {
            return new c5.h();
        }
    }

    /* renamed from: com.bumptech.glide.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static final class C٠١٠٣b {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class c {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Glide a(Context context, List list, a5.a aVar) {
        if (this.f٧٢٣٠g == null) {
            this.f٧٢٣٠g = r4.a.j();
        }
        if (this.f٧٢٣١h == null) {
            this.f٧٢٣١h = r4.a.h();
        }
        if (this.f٧٢٣٨o == null) {
            this.f٧٢٣٨o = r4.a.f();
        }
        if (this.f٧٢٣٣j == null) {
            this.f٧٢٣٣j = new i.a(context).a();
        }
        if (this.f٧٢٣٤k == null) {
            this.f٧٢٣٤k = new z4.e();
        }
        if (this.f٧٢٢٧d == null) {
            int b10 = this.f٧٢٣٣j.b();
            if (b10 > 0) {
                this.f٧٢٢٧d = new p4.j(b10);
            } else {
                this.f٧٢٢٧d = new p4.e();
            }
        }
        if (this.f٧٢٢٨e == null) {
            this.f٧٢٢٨e = new p4.i(this.f٧٢٣٣j.a());
        }
        if (this.f٧٢٢٩f == null) {
            this.f٧٢٢٩f = new q4.g(this.f٧٢٣٣j.d());
        }
        if (this.f٧٢٣٢i == null) {
            this.f٧٢٣٢i = new q4.f(context);
        }
        if (this.f٧٢٢٦c == null) {
            this.f٧٢٢٦c = new o4.k(this.f٧٢٢٩f, this.f٧٢٣٢i, this.f٧٢٣١h, this.f٧٢٣٠g, r4.a.k(), this.f٧٢٣٨o, this.f٧٢٣٩p);
        }
        List list2 = this.f٧٢٤٠q;
        if (list2 == null) {
            this.f٧٢٤٠q = Collections.emptyList();
        } else {
            this.f٧٢٤٠q = Collections.unmodifiableList(list2);
        }
        return new Glide(context, this.f٧٢٢٦c, this.f٧٢٢٩f, this.f٧٢٢٧d, this.f٧٢٢٨e, new o(this.f٧٢٣٧n), this.f٧٢٣٤k, this.f٧٢٣٥l, this.f٧٢٣٦m, this.f٧٢٢٤a, this.f٧٢٤٠q, list, aVar, this.f٧٢٢٥b.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(o.b bVar) {
        this.f٧٢٣٧n = bVar;
    }
}
