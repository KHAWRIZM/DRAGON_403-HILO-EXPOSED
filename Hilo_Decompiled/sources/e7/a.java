package e7;

import b7.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    private static final a f١٣٨٨٩e = new C٠١٥٨a().b();

    /* renamed from: a, reason: collision with root package name */
    private final f f١٣٨٩٠a;

    /* renamed from: b, reason: collision with root package name */
    private final List f١٣٨٩١b;

    /* renamed from: c, reason: collision with root package name */
    private final b f١٣٨٩٢c;

    /* renamed from: d, reason: collision with root package name */
    private final String f١٣٨٩٣d;

    /* renamed from: e7.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class C٠١٥٨a {

        /* renamed from: a, reason: collision with root package name */
        private f f١٣٨٩٤a = null;

        /* renamed from: b, reason: collision with root package name */
        private List f١٣٨٩٥b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        private b f١٣٨٩٦c = null;

        /* renamed from: d, reason: collision with root package name */
        private String f١٣٨٩٧d = "";

        C٠١٥٨a() {
        }

        public C٠١٥٨a a(d dVar) {
            this.f١٣٨٩٥b.add(dVar);
            return this;
        }

        public a b() {
            return new a(this.f١٣٨٩٤a, Collections.unmodifiableList(this.f١٣٨٩٥b), this.f١٣٨٩٦c, this.f١٣٨٩٧d);
        }

        public C٠١٥٨a c(String str) {
            this.f١٣٨٩٧d = str;
            return this;
        }

        public C٠١٥٨a d(b bVar) {
            this.f١٣٨٩٦c = bVar;
            return this;
        }

        public C٠١٥٨a e(f fVar) {
            this.f١٣٨٩٤a = fVar;
            return this;
        }
    }

    a(f fVar, List list, b bVar, String str) {
        this.f١٣٨٩٠a = fVar;
        this.f١٣٨٩١b = list;
        this.f١٣٨٩٢c = bVar;
        this.f١٣٨٩٣d = str;
    }

    public static C٠١٥٨a e() {
        return new C٠١٥٨a();
    }

    public String a() {
        return this.f١٣٨٩٣d;
    }

    public b b() {
        return this.f١٣٨٩٢c;
    }

    public List c() {
        return this.f١٣٨٩١b;
    }

    public f d() {
        return this.f١٣٨٩٠a;
    }

    public byte[] f() {
        return m.a(this);
    }
}
