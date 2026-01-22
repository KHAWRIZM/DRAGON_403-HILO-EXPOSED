package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class d2 implements c1 {

    /* renamed from: a, reason: collision with root package name */
    private final t1 f١٠٩٦٠a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f١٠٩٦١b;

    /* renamed from: c, reason: collision with root package name */
    private final int[] f١٠٩٦٢c;

    /* renamed from: d, reason: collision with root package name */
    private final a0[] f١٠٩٦٣d;

    /* renamed from: e, reason: collision with root package name */
    private final e1 f١٠٩٦٤e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List f١٠٩٦٥a;

        /* renamed from: b, reason: collision with root package name */
        private t1 f١٠٩٦٦b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f١٠٩٦٧c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f١٠٩٦٨d;

        /* renamed from: e, reason: collision with root package name */
        private int[] f١٠٩٦٩e = null;

        /* renamed from: f, reason: collision with root package name */
        private Object f١٠٩٧٠f;

        public a(int i10) {
            this.f١٠٩٦٥a = new ArrayList(i10);
        }

        public d2 a() {
            if (!this.f١٠٩٦٧c) {
                if (this.f١٠٩٦٦b != null) {
                    this.f١٠٩٦٧c = true;
                    Collections.sort(this.f١٠٩٦٥a);
                    return new d2(this.f١٠٩٦٦b, this.f١٠٩٦٨d, this.f١٠٩٦٩e, (a0[]) this.f١٠٩٦٥a.toArray(new a0[0]), this.f١٠٩٧٠f);
                }
                throw new IllegalStateException("Must specify a proto syntax");
            }
            throw new IllegalStateException("Builder can only build once");
        }

        public void b(int[] iArr) {
            this.f١٠٩٦٩e = iArr;
        }

        public void c(Object obj) {
            this.f١٠٩٧٠f = obj;
        }

        public void d(a0 a0Var) {
            if (!this.f١٠٩٦٧c) {
                this.f١٠٩٦٥a.add(a0Var);
                return;
            }
            throw new IllegalStateException("Builder can only build once");
        }

        public void e(boolean z10) {
            this.f١٠٩٦٨d = z10;
        }

        public void f(t1 t1Var) {
            this.f١٠٩٦٦b = (t1) j0.b(t1Var, "syntax");
        }
    }

    d2(t1 t1Var, boolean z10, int[] iArr, a0[] a0VarArr, Object obj) {
        this.f١٠٩٦٠a = t1Var;
        this.f١٠٩٦١b = z10;
        this.f١٠٩٦٢c = iArr;
        this.f١٠٩٦٣d = a0VarArr;
        this.f١٠٩٦٤e = (e1) j0.b(obj, "defaultInstance");
    }

    public static a e(int i10) {
        return new a(i10);
    }

    @Override // com.google.protobuf.c1
    public boolean a() {
        return this.f١٠٩٦١b;
    }

    @Override // com.google.protobuf.c1
    public e1 b() {
        return this.f١٠٩٦٤e;
    }

    public int[] c() {
        return this.f١٠٩٦٢c;
    }

    public a0[] d() {
        return this.f١٠٩٦٣d;
    }

    @Override // com.google.protobuf.c1
    public t1 getSyntax() {
        return this.f١٠٩٦٠a;
    }
}
