package s3;

import com.airbnb.lottie.j0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class j implements c {

    /* renamed from: a, reason: collision with root package name */
    private final String f١٧٧٨١a;

    /* renamed from: b, reason: collision with root package name */
    private final a f١٧٧٨٢b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f١٧٧٨٣c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static a c(int i10) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 != 5) {
                                return MERGE;
                            }
                            return EXCLUDE_INTERSECTIONS;
                        }
                        return INTERSECT;
                    }
                    return SUBTRACT;
                }
                return ADD;
            }
            return MERGE;
        }
    }

    public j(String str, a aVar, boolean z10) {
        this.f١٧٧٨١a = str;
        this.f١٧٧٨٢b = aVar;
        this.f١٧٧٨٣c = z10;
    }

    @Override // s3.c
    public n3.c a(j0 j0Var, com.airbnb.lottie.j jVar, t3.b bVar) {
        if (!j0Var.A()) {
            x3.f.c("Animation contains merge paths but they are disabled.");
            return null;
        }
        return new n3.l(this);
    }

    public a b() {
        return this.f١٧٧٨٢b;
    }

    public String c() {
        return this.f١٧٧٨١a;
    }

    public boolean d() {
        return this.f١٧٧٨٣c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f١٧٧٨٢b + '}';
    }
}
