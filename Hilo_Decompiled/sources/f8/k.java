package f8;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.graphics.shapes.CornerRounding;
import androidx.graphics.shapes.RoundedPolygon;
import androidx.graphics.shapes.RoundedPolygonKt;
import androidx.graphics.shapes.ShapesKt;
import androidx.graphics.shapes.Shapes_androidKt;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    private static final CornerRounding f١٤١٤٦a = new CornerRounding(0.15f, DownloadProgress.UNKNOWN_PROGRESS);

    /* renamed from: b, reason: collision with root package name */
    private static final CornerRounding f١٤١٤٧b = new CornerRounding(0.2f, DownloadProgress.UNKNOWN_PROGRESS);

    /* renamed from: c, reason: collision with root package name */
    private static final CornerRounding f١٤١٤٨c = new CornerRounding(0.3f, DownloadProgress.UNKNOWN_PROGRESS);

    /* renamed from: d, reason: collision with root package name */
    private static final CornerRounding f١٤١٤٩d = new CornerRounding(0.5f, DownloadProgress.UNKNOWN_PROGRESS);

    /* renamed from: e, reason: collision with root package name */
    private static final CornerRounding f١٤١٥٠e = new CornerRounding(1.0f, DownloadProgress.UNKNOWN_PROGRESS);

    /* renamed from: f, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٥١f = P(i(), true);

    /* renamed from: g, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٥٢g = P(K(), true);

    /* renamed from: h, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٥٣h = P(H(), true);

    /* renamed from: i, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٥٤i = P(d(), true);

    /* renamed from: j, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٥٥j = P(s(), true);

    /* renamed from: k, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٥٦k = P(e(), true);

    /* renamed from: l, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٥٧l = P(G(), true);

    /* renamed from: m, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٥٨m = P(z(-45.0f), true);

    /* renamed from: n, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٥٩n = P(B(), true);

    /* renamed from: o, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٦٠o = P(N(-90.0f), true);

    /* renamed from: p, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٦١p = P(r(), true);

    /* renamed from: q, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٦٢q = P(j(), true);

    /* renamed from: r, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٦٣r = P(A(), true);

    /* renamed from: s, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٦٤s = P(v(-90.0f), true);

    /* renamed from: t, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٦٥t = P(L(), true);

    /* renamed from: u, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٦٦u = P(O(), true);

    /* renamed from: v, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٦٧v = P(n(), true);

    /* renamed from: w, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٦٨w = P(o(), true);

    /* renamed from: x, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٦٩x = P(p(), true);

    /* renamed from: y, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٧٠y = P(q(), true);

    /* renamed from: z, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٧١z = P(m(), true);
    public static final RoundedPolygon A = P(w(), true);

    /* renamed from: B, reason: collision with root package name */
    public static final RoundedPolygon f١٤١٤٥B = P(k(), true);
    public static final RoundedPolygon C = P(l(), true);
    public static final RoundedPolygon D = P(h(), true);
    public static final RoundedPolygon E = P(J(), true);
    public static final RoundedPolygon F = P(f(), true);
    public static final RoundedPolygon G = P(I(), true);
    public static final RoundedPolygon H = P(t(), true);
    public static final RoundedPolygon I = P(E(), true);
    public static final RoundedPolygon J = P(F(), true);
    public static final RoundedPolygon K = P(C(), true);
    public static final RoundedPolygon L = P(D(), true);
    public static final RoundedPolygon M = P(g(), true);
    public static final RoundedPolygon N = P(x(), true);

    private static RoundedPolygon A() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.5f, -0.009f), new CornerRounding(0.172f, DownloadProgress.UNKNOWN_PROGRESS)));
        return c(arrayList, 5, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon B() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.961f, 0.039f), new CornerRounding(0.426f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(1.001f, 0.428f)));
        arrayList.add(new b(new PointF(1.0f, 0.609f), f١٤١٥٠e));
        return c(arrayList, 2, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon C() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.5f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.704f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.704f, 0.065f)));
        arrayList.add(new b(new PointF(0.843f, 0.065f)));
        arrayList.add(new b(new PointF(0.843f, 0.148f)));
        arrayList.add(new b(new PointF(0.926f, 0.148f)));
        arrayList.add(new b(new PointF(0.926f, 0.296f)));
        arrayList.add(new b(new PointF(1.0f, 0.296f)));
        return c(arrayList, 2, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon D() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.11f, 0.5f)));
        arrayList.add(new b(new PointF(0.113f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.287f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.287f, 0.087f)));
        arrayList.add(new b(new PointF(0.421f, 0.087f)));
        arrayList.add(new b(new PointF(0.421f, 0.17f)));
        arrayList.add(new b(new PointF(0.56f, 0.17f)));
        arrayList.add(new b(new PointF(0.56f, 0.265f)));
        arrayList.add(new b(new PointF(0.674f, 0.265f)));
        arrayList.add(new b(new PointF(0.675f, 0.344f)));
        arrayList.add(new b(new PointF(0.789f, 0.344f)));
        arrayList.add(new b(new PointF(0.789f, 0.439f)));
        arrayList.add(new b(new PointF(0.888f, 0.439f)));
        return c(arrayList, 1, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon E() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.5f, 0.053f)));
        arrayList.add(new b(new PointF(0.545f, -0.04f), new CornerRounding(0.405f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.67f, -0.035f), new CornerRounding(0.426f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.717f, 0.066f), new CornerRounding(0.574f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.722f, 0.128f)));
        arrayList.add(new b(new PointF(0.777f, 0.002f), new CornerRounding(0.36f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.914f, 0.149f), new CornerRounding(0.66f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.926f, 0.289f), new CornerRounding(0.66f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.881f, 0.346f)));
        arrayList.add(new b(new PointF(0.94f, 0.344f), new CornerRounding(0.126f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(1.003f, 0.437f), new CornerRounding(0.255f, DownloadProgress.UNKNOWN_PROGRESS)));
        return Shapes_androidKt.transformed(c(arrayList, 2, 0.5f, 0.5f, true), b(1.0f, 0.742f));
    }

    private static RoundedPolygon F() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.87f, 0.13f), new CornerRounding(0.146f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.818f, 0.357f)));
        arrayList.add(new b(new PointF(1.0f, 0.332f), new CornerRounding(0.853f, DownloadProgress.UNKNOWN_PROGRESS)));
        return c(arrayList, 4, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon G() {
        RoundedPolygon.Companion companion = RoundedPolygon.INSTANCE;
        CornerRounding cornerRounding = CornerRounding.Unrounded;
        CornerRounding cornerRounding2 = f١٤١٤٧b;
        CornerRounding cornerRounding3 = f١٤١٥٠e;
        return ShapesKt.rectangle(companion, 1.6f, 1.0f, cornerRounding, Arrays.asList(cornerRounding2, cornerRounding2, cornerRounding3, cornerRounding3), DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
    }

    private static RoundedPolygon H() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.926f, 0.97f), new CornerRounding(0.189f, 0.811f)));
        arrayList.add(new b(new PointF(-0.021f, 0.967f), new CornerRounding(0.187f, 0.057f)));
        return c(arrayList, 2, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon I() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.733f, 0.454f)));
        arrayList.add(new b(new PointF(0.839f, 0.437f), new CornerRounding(0.532f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.949f, 0.449f), new CornerRounding(0.439f, 1.0f)));
        arrayList.add(new b(new PointF(0.998f, 0.478f), new CornerRounding(0.174f, DownloadProgress.UNKNOWN_PROGRESS)));
        return c(arrayList, 16, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon J() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.193f, 0.277f), new CornerRounding(0.053f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.176f, 0.055f), new CornerRounding(0.053f, DownloadProgress.UNKNOWN_PROGRESS)));
        return c(arrayList, 10, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon K() {
        return ShapesKt.rectangle(RoundedPolygon.INSTANCE, 1.0f, 1.0f, f١٤١٤٨c, null, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
    }

    private static RoundedPolygon L() {
        return ShapesKt.star(RoundedPolygon.INSTANCE, 8, 1.0f, 0.8f, f١٤١٤٦a);
    }

    private static RoundedPolygon M() {
        return RoundedPolygonKt.RoundedPolygon(3, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, f١٤١٤٧b);
    }

    private static RoundedPolygon N(float f10) {
        return Shapes_androidKt.transformed(M(), a(f10));
    }

    private static RoundedPolygon O() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.5f, 1.08f), new CornerRounding(0.085f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.358f, 0.843f), new CornerRounding(0.085f, DownloadProgress.UNKNOWN_PROGRESS)));
        return c(arrayList, 8, 0.5f, 0.5f, false);
    }

    public static RoundedPolygon P(RoundedPolygon roundedPolygon, boolean z10) {
        return Q(roundedPolygon, z10, new RectF(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, 1.0f));
    }

    public static RoundedPolygon Q(RoundedPolygon roundedPolygon, boolean z10, RectF rectF) {
        float[] fArr = new float[4];
        if (z10) {
            roundedPolygon.calculateMaxBounds(fArr);
        } else {
            roundedPolygon.calculateBounds(fArr);
        }
        RectF rectF2 = new RectF(fArr[0], fArr[1], fArr[2], fArr[3]);
        float min = Math.min(rectF.width() / rectF2.width(), rectF.height() / rectF2.height());
        Matrix b10 = b(min, min);
        b10.preTranslate(-rectF2.centerX(), -rectF2.centerY());
        b10.postTranslate(rectF.centerX(), rectF.centerY());
        return Shapes_androidKt.transformed(roundedPolygon, b10);
    }

    private static void R(List list, List list2, int i10, float f10, float f11, boolean z10) {
        boolean z11;
        int i11;
        float f12;
        list2.clear();
        T(list, f10, f11);
        float f13 = (float) (6.283185307179586d / i10);
        if (z10) {
            int i12 = i10 * 2;
            float f14 = f13 / 2.0f;
            for (int i13 = 0; i13 < i12; i13++) {
                for (int i14 = 0; i14 < list.size(); i14++) {
                    if (i13 % 2 != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        i11 = (list.size() - 1) - i14;
                    } else {
                        i11 = i14;
                    }
                    b bVar = (b) list.get(i11);
                    if (i11 > 0 || !z11) {
                        float f15 = i13 * f14;
                        if (z11) {
                            f12 = (f14 - bVar.f١٤١٧٢a.x) + (((b) list.get(0)).f١٤١٧٢a.x * 2.0f);
                        } else {
                            f12 = bVar.f١٤١٧٢a.x;
                        }
                        list2.add(new b(new PointF(f15 + f12, bVar.f١٤١٧٢a.y), bVar.f١٤١٧٣b));
                    }
                }
            }
        } else {
            for (int i15 = 0; i15 < i10; i15++) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    b bVar2 = (b) it.next();
                    list2.add(new b(new PointF((i15 * f13) + bVar2.f١٤١٧٢a.x, bVar2.f١٤١٧٢a.y), bVar2.f١٤١٧٣b));
                }
            }
        }
        S(list2, f10, f11);
    }

    private static void S(List list, float f10, float f11) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((b) it.next()).e(f10, f11);
        }
    }

    private static void T(List list, float f10, float f11) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((b) it.next()).f(f10, f11);
        }
    }

    private static List U(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            arrayList.add(((b) list.get(i10)).f١٤١٧٣b);
        }
        return arrayList;
    }

    private static float[] V(List list) {
        float[] fArr = new float[list.size() * 2];
        for (int i10 = 0; i10 < list.size(); i10++) {
            int i11 = i10 * 2;
            fArr[i11] = ((b) list.get(i10)).f١٤١٧٢a.x;
            fArr[i11 + 1] = ((b) list.get(i10)).f١٤١٧٢a.y;
        }
        return fArr;
    }

    static Matrix a(float f10) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f10);
        return matrix;
    }

    static Matrix b(float f10, float f11) {
        Matrix matrix = new Matrix();
        matrix.setScale(f10, f11);
        return matrix;
    }

    private static RoundedPolygon c(List list, int i10, float f10, float f11, boolean z10) {
        ArrayList arrayList = new ArrayList();
        R(list, arrayList, i10, f10, f11, z10);
        return RoundedPolygonKt.RoundedPolygon(V(arrayList), CornerRounding.Unrounded, (List<CornerRounding>) U(arrayList), f10, f11);
    }

    private static RoundedPolygon d() {
        CornerRounding cornerRounding = CornerRounding.Unrounded;
        CornerRounding cornerRounding2 = f١٤١٥٠e;
        CornerRounding cornerRounding3 = f١٤١٤٧b;
        return Shapes_androidKt.transformed(RoundedPolygonKt.RoundedPolygon(4, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, cornerRounding, Arrays.asList(cornerRounding2, cornerRounding2, cornerRounding3, cornerRounding3)), a(-135.0f));
    }

    private static RoundedPolygon e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.5f, 0.892f), new CornerRounding(0.313f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(-0.216f, 1.05f), new CornerRounding(0.207f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.499f, -0.16f), new CornerRounding(0.215f, 1.0f)));
        arrayList.add(new b(new PointF(1.225f, 1.06f), new CornerRounding(0.211f, DownloadProgress.UNKNOWN_PROGRESS)));
        return c(arrayList, 1, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.457f, 0.296f), new CornerRounding(0.007f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.5f, -0.051f), new CornerRounding(0.007f, DownloadProgress.UNKNOWN_PROGRESS)));
        return c(arrayList, 15, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.796f, 0.5f)));
        PointF pointF = new PointF(0.853f, 0.518f);
        CornerRounding cornerRounding = f١٤١٥٠e;
        arrayList.add(new b(pointF, cornerRounding));
        arrayList.add(new b(new PointF(0.992f, 0.631f), cornerRounding));
        arrayList.add(new b(new PointF(0.968f, 1.0f), cornerRounding));
        return c(arrayList, 2, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.5f, -0.006f), new CornerRounding(0.006f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.592f, 0.158f), new CornerRounding(0.006f, DownloadProgress.UNKNOWN_PROGRESS)));
        return c(arrayList, 12, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon i() {
        return ShapesKt.circle(RoundedPolygon.INSTANCE, 10);
    }

    private static RoundedPolygon j() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.171f, 0.841f), new CornerRounding(0.159f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(-0.02f, 0.5f), new CornerRounding(0.14f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.17f, 0.159f), new CornerRounding(0.159f, DownloadProgress.UNKNOWN_PROGRESS)));
        return c(arrayList, 2, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon k() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.5f, 0.074f)));
        arrayList.add(new b(new PointF(0.725f, -0.099f), new CornerRounding(0.476f, DownloadProgress.UNKNOWN_PROGRESS)));
        return c(arrayList, 4, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon l() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.5f, 0.036f)));
        arrayList.add(new b(new PointF(0.758f, -0.101f), new CornerRounding(0.209f, DownloadProgress.UNKNOWN_PROGRESS)));
        return c(arrayList, 8, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon m() {
        return Shapes_androidKt.transformed(ShapesKt.star(RoundedPolygon.INSTANCE, 12, 1.0f, 0.8f, f١٤١٤٩d), a(-90.0f));
    }

    private static RoundedPolygon n() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(1.237f, 1.236f), new CornerRounding(0.258f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.5f, 0.918f), new CornerRounding(0.233f, DownloadProgress.UNKNOWN_PROGRESS)));
        return c(arrayList, 4, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon o() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.723f, 0.884f), new CornerRounding(0.394f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.5f, 1.099f), new CornerRounding(0.398f, DownloadProgress.UNKNOWN_PROGRESS)));
        return c(arrayList, 6, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon p() {
        return Shapes_androidKt.transformed(ShapesKt.star(RoundedPolygon.INSTANCE, 7, 1.0f, 0.75f, f١٤١٤٩d), a(-90.0f));
    }

    private static RoundedPolygon q() {
        return Shapes_androidKt.transformed(ShapesKt.star(RoundedPolygon.INSTANCE, 9, 1.0f, 0.8f, f١٤١٤٩d), a(-90.0f));
    }

    private static RoundedPolygon r() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.5f, 1.096f), new CornerRounding(0.151f, 0.524f)));
        arrayList.add(new b(new PointF(0.04f, 0.5f), new CornerRounding(0.159f, DownloadProgress.UNKNOWN_PROGRESS)));
        return c(arrayList, 2, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon s() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(1.0f, 1.0f), new CornerRounding(0.148f, 0.417f)));
        arrayList.add(new b(new PointF(DownloadProgress.UNKNOWN_PROGRESS, 1.0f), new CornerRounding(0.151f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS), new CornerRounding(0.148f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.978f, 0.02f), new CornerRounding(0.803f, DownloadProgress.UNKNOWN_PROGRESS)));
        return c(arrayList, 1, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon t() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.37f, 0.187f)));
        arrayList.add(new b(new PointF(0.416f, 0.049f), new CornerRounding(0.381f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.479f, DownloadProgress.UNKNOWN_PROGRESS), new CornerRounding(0.095f, DownloadProgress.UNKNOWN_PROGRESS)));
        return c(arrayList, 8, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon u() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.499f, 1.023f), new CornerRounding(0.241f, 0.778f)));
        arrayList.add(new b(new PointF(-0.005f, 0.792f), new CornerRounding(0.208f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.073f, 0.258f), new CornerRounding(0.228f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.433f, -0.0f), new CornerRounding(0.491f, DownloadProgress.UNKNOWN_PROGRESS)));
        return c(arrayList, 1, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon v(float f10) {
        return Shapes_androidKt.transformed(u(), a(f10));
    }

    private static RoundedPolygon w() {
        ArrayList arrayList = new ArrayList();
        PointF pointF = new PointF(0.5f, DownloadProgress.UNKNOWN_PROGRESS);
        CornerRounding cornerRounding = f١٤١٥٠e;
        arrayList.add(new b(pointF, cornerRounding));
        arrayList.add(new b(new PointF(1.0f, DownloadProgress.UNKNOWN_PROGRESS), cornerRounding));
        arrayList.add(new b(new PointF(1.0f, 1.14f), new CornerRounding(0.254f, 0.106f)));
        arrayList.add(new b(new PointF(0.575f, 0.906f), new CornerRounding(0.253f, DownloadProgress.UNKNOWN_PROGRESS)));
        return c(arrayList, 1, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon x() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(new PointF(0.5f, 0.268f), new CornerRounding(0.016f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(0.792f, -0.066f), new CornerRounding(0.958f, DownloadProgress.UNKNOWN_PROGRESS)));
        arrayList.add(new b(new PointF(1.064f, 0.276f), f١٤١٥٠e));
        arrayList.add(new b(new PointF(0.501f, 0.946f), new CornerRounding(0.129f, DownloadProgress.UNKNOWN_PROGRESS)));
        return c(arrayList, 1, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon y() {
        return Shapes_androidKt.transformed(ShapesKt.circle(RoundedPolygon.INSTANCE), b(1.0f, 0.64f));
    }

    private static RoundedPolygon z(float f10) {
        return Shapes_androidKt.transformed(y(), a(f10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private PointF f١٤١٧٢a;

        /* renamed from: b, reason: collision with root package name */
        private CornerRounding f١٤١٧٣b;

        /* JADX INFO: Access modifiers changed from: private */
        public void e(float f10, float f11) {
            PointF pointF = this.f١٤١٧٢a;
            float cos = (float) ((pointF.y * Math.cos(pointF.x)) + f10);
            PointF pointF2 = this.f١٤١٧٢a;
            float sin = (float) ((pointF2.y * Math.sin(pointF2.x)) + f11);
            PointF pointF3 = this.f١٤١٧٢a;
            pointF3.x = cos;
            pointF3.y = sin;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(float f10, float f11) {
            this.f١٤١٧٢a.offset(-f10, -f11);
            PointF pointF = this.f١٤١٧٢a;
            float atan2 = (float) Math.atan2(pointF.y, pointF.x);
            PointF pointF2 = this.f١٤١٧٢a;
            float hypot = (float) Math.hypot(pointF2.x, pointF2.y);
            PointF pointF3 = this.f١٤١٧٢a;
            pointF3.x = atan2;
            pointF3.y = hypot;
        }

        private b(PointF pointF) {
            this(pointF, CornerRounding.Unrounded);
        }

        private b(PointF pointF, CornerRounding cornerRounding) {
            this.f١٤١٧٢a = pointF;
            this.f١٤١٧٣b = cornerRounding;
        }
    }
}
