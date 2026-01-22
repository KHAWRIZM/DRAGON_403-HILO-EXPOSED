package v3;

import android.graphics.Color;
import android.graphics.PointF;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinVersion;
import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class s {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤٥٠a = c.a.a("x", "y");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٨٤٥١a;

        static {
            int[] iArr = new int[c.b.values().length];
            f١٨٤٥١a = iArr;
            try {
                iArr[c.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٨٤٥١a[c.b.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٨٤٥١a[c.b.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static PointF a(w3.c cVar, float f10) {
        cVar.b();
        float m10 = (float) cVar.m();
        float m11 = (float) cVar.m();
        while (cVar.u() != c.b.END_ARRAY) {
            cVar.A();
        }
        cVar.g();
        return new PointF(m10 * f10, m11 * f10);
    }

    private static PointF b(w3.c cVar, float f10) {
        float m10 = (float) cVar.m();
        float m11 = (float) cVar.m();
        while (cVar.j()) {
            cVar.A();
        }
        return new PointF(m10 * f10, m11 * f10);
    }

    private static PointF c(w3.c cVar, float f10) {
        cVar.c();
        float f11 = DownloadProgress.UNKNOWN_PROGRESS;
        float f12 = DownloadProgress.UNKNOWN_PROGRESS;
        while (cVar.j()) {
            int x10 = cVar.x(f١٨٤٥٠a);
            if (x10 != 0) {
                if (x10 != 1) {
                    cVar.z();
                    cVar.A();
                } else {
                    f12 = g(cVar);
                }
            } else {
                f11 = g(cVar);
            }
        }
        cVar.h();
        return new PointF(f11 * f10, f12 * f10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(w3.c cVar) {
        cVar.b();
        int m10 = (int) (cVar.m() * 255.0d);
        int m11 = (int) (cVar.m() * 255.0d);
        int m12 = (int) (cVar.m() * 255.0d);
        while (cVar.j()) {
            cVar.A();
        }
        cVar.g();
        return Color.argb(KotlinVersion.MAX_COMPONENT_VALUE, m10, m11, m12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PointF e(w3.c cVar, float f10) {
        int i10 = a.f١٨٤٥١a[cVar.u().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return c(cVar, f10);
                }
                throw new IllegalArgumentException("Unknown point starts with " + cVar.u());
            }
            return a(cVar, f10);
        }
        return b(cVar, f10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List f(w3.c cVar, float f10) {
        ArrayList arrayList = new ArrayList();
        cVar.b();
        while (cVar.u() == c.b.BEGIN_ARRAY) {
            cVar.b();
            arrayList.add(e(cVar, f10));
            cVar.g();
        }
        cVar.g();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float g(w3.c cVar) {
        c.b u10 = cVar.u();
        int i10 = a.f١٨٤٥١a[u10.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                cVar.b();
                float m10 = (float) cVar.m();
                while (cVar.j()) {
                    cVar.A();
                }
                cVar.g();
                return m10;
            }
            throw new IllegalArgumentException("Unknown value for token of type " + u10);
        }
        return (float) cVar.m();
    }
}
