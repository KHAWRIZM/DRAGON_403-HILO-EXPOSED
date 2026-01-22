package s3;

import android.graphics.Paint;
import com.airbnb.lottie.j0;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class s implements s3.c {

    /* renamed from: a, reason: collision with root package name */
    private final String f١٧٨٣٣a;

    /* renamed from: b, reason: collision with root package name */
    private final r3.b f١٧٨٣٤b;

    /* renamed from: c, reason: collision with root package name */
    private final List f١٧٨٣٥c;

    /* renamed from: d, reason: collision with root package name */
    private final r3.a f١٧٨٣٦d;

    /* renamed from: e, reason: collision with root package name */
    private final r3.d f١٧٨٣٧e;

    /* renamed from: f, reason: collision with root package name */
    private final r3.b f١٧٨٣٨f;

    /* renamed from: g, reason: collision with root package name */
    private final b f١٧٨٣٩g;

    /* renamed from: h, reason: collision with root package name */
    private final c f١٧٨٤٠h;

    /* renamed from: i, reason: collision with root package name */
    private final float f١٧٨٤١i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f١٧٨٤٢j;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٧٨٤٣a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f١٧٨٤٤b;

        static {
            int[] iArr = new int[c.values().length];
            f١٧٨٤٤b = iArr;
            try {
                iArr[c.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٧٨٤٤b[c.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٧٨٤٤b[c.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[b.values().length];
            f١٧٨٤٣a = iArr2;
            try {
                iArr2[b.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f١٧٨٤٣a[b.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f١٧٨٤٣a[b.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum b {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap c() {
            int i10 = a.f١٧٨٤٣a[ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum c {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join c() {
            int i10 = a.f١٧٨٤٤b[ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return null;
                    }
                    return Paint.Join.ROUND;
                }
                return Paint.Join.MITER;
            }
            return Paint.Join.BEVEL;
        }
    }

    public s(String str, r3.b bVar, List list, r3.a aVar, r3.d dVar, r3.b bVar2, b bVar3, c cVar, float f10, boolean z10) {
        this.f١٧٨٣٣a = str;
        this.f١٧٨٣٤b = bVar;
        this.f١٧٨٣٥c = list;
        this.f١٧٨٣٦d = aVar;
        this.f١٧٨٣٧e = dVar;
        this.f١٧٨٣٨f = bVar2;
        this.f١٧٨٣٩g = bVar3;
        this.f١٧٨٤٠h = cVar;
        this.f١٧٨٤١i = f10;
        this.f١٧٨٤٢j = z10;
    }

    @Override // s3.c
    public n3.c a(j0 j0Var, com.airbnb.lottie.j jVar, t3.b bVar) {
        return new n3.t(j0Var, bVar, this);
    }

    public b b() {
        return this.f١٧٨٣٩g;
    }

    public r3.a c() {
        return this.f١٧٨٣٦d;
    }

    public r3.b d() {
        return this.f١٧٨٣٤b;
    }

    public c e() {
        return this.f١٧٨٤٠h;
    }

    public List f() {
        return this.f١٧٨٣٥c;
    }

    public float g() {
        return this.f١٧٨٤١i;
    }

    public String h() {
        return this.f١٧٨٣٣a;
    }

    public r3.d i() {
        return this.f١٧٨٣٧e;
    }

    public r3.b j() {
        return this.f١٧٨٣٨f;
    }

    public boolean k() {
        return this.f١٧٨٤٢j;
    }
}
