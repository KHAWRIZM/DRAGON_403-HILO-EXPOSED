package i8;

import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final i8.a f١٤٦٨٦a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final i8.a f١٤٦٨٧b = new C٠١٦٧b();

    /* renamed from: c, reason: collision with root package name */
    private static final i8.a f١٤٦٨٨c = new c();

    /* renamed from: d, reason: collision with root package name */
    private static final i8.a f١٤٦٨٩d = new d();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements i8.a {
        a() {
        }

        @Override // i8.a
        public i8.c a(float f10, float f11, float f12, float f13) {
            return i8.c.a(KotlinVersion.MAX_COMPONENT_VALUE, n.p(0, KotlinVersion.MAX_COMPONENT_VALUE, f11, f12, f10));
        }
    }

    /* renamed from: i8.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class C٠١٦٧b implements i8.a {
        C٠١٦٧b() {
        }

        @Override // i8.a
        public i8.c a(float f10, float f11, float f12, float f13) {
            return i8.c.b(n.p(KotlinVersion.MAX_COMPONENT_VALUE, 0, f11, f12, f10), KotlinVersion.MAX_COMPONENT_VALUE);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class c implements i8.a {
        c() {
        }

        @Override // i8.a
        public i8.c a(float f10, float f11, float f12, float f13) {
            return i8.c.b(n.p(KotlinVersion.MAX_COMPONENT_VALUE, 0, f11, f12, f10), n.p(0, KotlinVersion.MAX_COMPONENT_VALUE, f11, f12, f10));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class d implements i8.a {
        d() {
        }

        @Override // i8.a
        public i8.c a(float f10, float f11, float f12, float f13) {
            float f14 = ((f12 - f11) * f13) + f11;
            return i8.c.b(n.p(KotlinVersion.MAX_COMPONENT_VALUE, 0, f11, f14, f10), n.p(0, KotlinVersion.MAX_COMPONENT_VALUE, f14, f12, f10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i8.a a(int i10, boolean z10) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        return f١٤٦٨٩d;
                    }
                    throw new IllegalArgumentException("Invalid fade mode: " + i10);
                }
                return f١٤٦٨٨c;
            }
            if (z10) {
                return f١٤٦٨٧b;
            }
            return f١٤٦٨٦a;
        }
        if (z10) {
            return f١٤٦٨٦a;
        }
        return f١٤٦٨٧b;
    }
}
