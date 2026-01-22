package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.c;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import e2.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class l implements Comparable {
    static String[] D = {"position", "x", "y", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "pathRotate"};

    /* renamed from: c, reason: collision with root package name */
    int f١٩٩٤c;

    /* renamed from: p, reason: collision with root package name */
    private a2.c f٢٠٠٧p;

    /* renamed from: r, reason: collision with root package name */
    private float f٢٠٠٩r;

    /* renamed from: s, reason: collision with root package name */
    private float f٢٠١٠s;

    /* renamed from: t, reason: collision with root package name */
    private float f٢٠١١t;

    /* renamed from: u, reason: collision with root package name */
    private float f٢٠١٢u;

    /* renamed from: v, reason: collision with root package name */
    private float f٢٠١٣v;

    /* renamed from: a, reason: collision with root package name */
    private float f١٩٩٢a = 1.0f;

    /* renamed from: b, reason: collision with root package name */
    int f١٩٩٣b = 0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f١٩٩٥d = false;

    /* renamed from: e, reason: collision with root package name */
    private float f١٩٩٦e = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: f, reason: collision with root package name */
    private float f١٩٩٧f = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: g, reason: collision with root package name */
    private float f١٩٩٨g = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: h, reason: collision with root package name */
    public float f١٩٩٩h = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: i, reason: collision with root package name */
    private float f٢٠٠٠i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    private float f٢٠٠١j = 1.0f;

    /* renamed from: k, reason: collision with root package name */
    private float f٢٠٠٢k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    private float f٢٠٠٣l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    private float f٢٠٠٤m = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: n, reason: collision with root package name */
    private float f٢٠٠٥n = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: o, reason: collision with root package name */
    private float f٢٠٠٦o = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: q, reason: collision with root package name */
    private int f٢٠٠٨q = 0;

    /* renamed from: w, reason: collision with root package name */
    private float f٢٠١٤w = Float.NaN;

    /* renamed from: x, reason: collision with root package name */
    private float f٢٠١٥x = Float.NaN;

    /* renamed from: y, reason: collision with root package name */
    private int f٢٠١٦y = -1;

    /* renamed from: z, reason: collision with root package name */
    LinkedHashMap f٢٠١٧z = new LinkedHashMap();
    int A = 0;

    /* renamed from: B, reason: collision with root package name */
    double[] f١٩٩١B = new double[18];
    double[] C = new double[18];

    private boolean f(float f10, float f11) {
        if (!Float.isNaN(f10) && !Float.isNaN(f11)) {
            if (Math.abs(f10 - f11) <= 1.0E-6f) {
                return false;
            }
            return true;
        }
        if (Float.isNaN(f10) == Float.isNaN(f11)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0026. Please report as an issue. */
    public void a(HashMap hashMap, int i10) {
        for (String str : hashMap.keySet()) {
            e2.d dVar = (e2.d) hashMap.get(str);
            str.hashCode();
            float f10 = 1.0f;
            float f11 = DownloadProgress.UNKNOWN_PROGRESS;
            char c10 = 65535;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c10 = 5;
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        c10 = 6;
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        c10 = 7;
                        break;
                    }
                    break;
                case -760884510:
                    if (str.equals("transformPivotX")) {
                        c10 = '\b';
                        break;
                    }
                    break;
                case -760884509:
                    if (str.equals("transformPivotY")) {
                        c10 = '\t';
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        c10 = '\n';
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        c10 = 11;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        c10 = '\f';
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        c10 = '\r';
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    if (!Float.isNaN(this.f١٩٩٨g)) {
                        f11 = this.f١٩٩٨g;
                    }
                    dVar.c(i10, f11);
                    break;
                case 1:
                    if (!Float.isNaN(this.f١٩٩٩h)) {
                        f11 = this.f١٩٩٩h;
                    }
                    dVar.c(i10, f11);
                    break;
                case 2:
                    if (!Float.isNaN(this.f٢٠٠٤m)) {
                        f11 = this.f٢٠٠٤m;
                    }
                    dVar.c(i10, f11);
                    break;
                case 3:
                    if (!Float.isNaN(this.f٢٠٠٥n)) {
                        f11 = this.f٢٠٠٥n;
                    }
                    dVar.c(i10, f11);
                    break;
                case 4:
                    if (!Float.isNaN(this.f٢٠٠٦o)) {
                        f11 = this.f٢٠٠٦o;
                    }
                    dVar.c(i10, f11);
                    break;
                case 5:
                    if (!Float.isNaN(this.f٢٠١٥x)) {
                        f11 = this.f٢٠١٥x;
                    }
                    dVar.c(i10, f11);
                    break;
                case 6:
                    if (!Float.isNaN(this.f٢٠٠٠i)) {
                        f10 = this.f٢٠٠٠i;
                    }
                    dVar.c(i10, f10);
                    break;
                case 7:
                    if (!Float.isNaN(this.f٢٠٠١j)) {
                        f10 = this.f٢٠٠١j;
                    }
                    dVar.c(i10, f10);
                    break;
                case '\b':
                    if (!Float.isNaN(this.f٢٠٠٢k)) {
                        f11 = this.f٢٠٠٢k;
                    }
                    dVar.c(i10, f11);
                    break;
                case '\t':
                    if (!Float.isNaN(this.f٢٠٠٣l)) {
                        f11 = this.f٢٠٠٣l;
                    }
                    dVar.c(i10, f11);
                    break;
                case '\n':
                    if (!Float.isNaN(this.f١٩٩٧f)) {
                        f11 = this.f١٩٩٧f;
                    }
                    dVar.c(i10, f11);
                    break;
                case 11:
                    if (!Float.isNaN(this.f١٩٩٦e)) {
                        f11 = this.f١٩٩٦e;
                    }
                    dVar.c(i10, f11);
                    break;
                case '\f':
                    if (!Float.isNaN(this.f٢٠١٤w)) {
                        f11 = this.f٢٠١٤w;
                    }
                    dVar.c(i10, f11);
                    break;
                case '\r':
                    if (!Float.isNaN(this.f١٩٩٢a)) {
                        f10 = this.f١٩٩٢a;
                    }
                    dVar.c(i10, f10);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        if (this.f٢٠١٧z.containsKey(str2)) {
                            androidx.constraintlayout.widget.a aVar = (androidx.constraintlayout.widget.a) this.f٢٠١٧z.get(str2);
                            if (dVar instanceof d.b) {
                                ((d.b) dVar).i(i10, aVar);
                                break;
                            } else {
                                Log.e("MotionPaths", str + " ViewSpline not a CustomSet frame = " + i10 + ", value" + aVar.d() + dVar);
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        Log.e("MotionPaths", "UNKNOWN spline " + str);
                        break;
                    }
            }
        }
    }

    public void c(View view) {
        float alpha;
        this.f١٩٩٤c = view.getVisibility();
        if (view.getVisibility() != 0) {
            alpha = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            alpha = view.getAlpha();
        }
        this.f١٩٩٢a = alpha;
        this.f١٩٩٥d = false;
        this.f١٩٩٦e = view.getElevation();
        this.f١٩٩٧f = view.getRotation();
        this.f١٩٩٨g = view.getRotationX();
        this.f١٩٩٩h = view.getRotationY();
        this.f٢٠٠٠i = view.getScaleX();
        this.f٢٠٠١j = view.getScaleY();
        this.f٢٠٠٢k = view.getPivotX();
        this.f٢٠٠٣l = view.getPivotY();
        this.f٢٠٠٤m = view.getTranslationX();
        this.f٢٠٠٥n = view.getTranslationY();
        this.f٢٠٠٦o = view.getTranslationZ();
    }

    public void d(c.a aVar) {
        float f10;
        c.d dVar = aVar.f٢٤١٧c;
        int i10 = dVar.f٢٤٩٧c;
        this.f١٩٩٣b = i10;
        int i11 = dVar.f٢٤٩٦b;
        this.f١٩٩٤c = i11;
        if (i11 != 0 && i10 == 0) {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            f10 = dVar.f٢٤٩٨d;
        }
        this.f١٩٩٢a = f10;
        c.e eVar = aVar.f٢٤٢٠f;
        this.f١٩٩٥d = eVar.f٢٥١٣m;
        this.f١٩٩٦e = eVar.f٢٥١٤n;
        this.f١٩٩٧f = eVar.f٢٥٠٢b;
        this.f١٩٩٨g = eVar.f٢٥٠٣c;
        this.f١٩٩٩h = eVar.f٢٥٠٤d;
        this.f٢٠٠٠i = eVar.f٢٥٠٥e;
        this.f٢٠٠١j = eVar.f٢٥٠٦f;
        this.f٢٠٠٢k = eVar.f٢٥٠٧g;
        this.f٢٠٠٣l = eVar.f٢٥٠٨h;
        this.f٢٠٠٤m = eVar.f٢٥١٠j;
        this.f٢٠٠٥n = eVar.f٢٥١١k;
        this.f٢٠٠٦o = eVar.f٢٥١٢l;
        this.f٢٠٠٧p = a2.c.c(aVar.f٢٤١٨d.f٢٤٨٤d);
        c.C٠٠١٩c r02 = aVar.f٢٤١٨d;
        this.f٢٠١٤w = r02.f٢٤٨٩i;
        this.f٢٠٠٨q = r02.f٢٤٨٦f;
        this.f٢٠١٦y = r02.f٢٤٨٢b;
        this.f٢٠١٥x = aVar.f٢٤١٧c.f٢٤٩٩e;
        for (String str : aVar.f٢٤٢١g.keySet()) {
            androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) aVar.f٢٤٢١g.get(str);
            if (aVar2.f()) {
                this.f٢٠١٧z.put(str, aVar2);
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(l lVar) {
        return Float.compare(this.f٢٠٠٩r, lVar.f٢٠٠٩r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(l lVar, HashSet hashSet) {
        if (f(this.f١٩٩٢a, lVar.f١٩٩٢a)) {
            hashSet.add("alpha");
        }
        if (f(this.f١٩٩٦e, lVar.f١٩٩٦e)) {
            hashSet.add("elevation");
        }
        int i10 = this.f١٩٩٤c;
        int i11 = lVar.f١٩٩٤c;
        if (i10 != i11 && this.f١٩٩٣b == 0 && (i10 == 0 || i11 == 0)) {
            hashSet.add("alpha");
        }
        if (f(this.f١٩٩٧f, lVar.f١٩٩٧f)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f٢٠١٤w) || !Float.isNaN(lVar.f٢٠١٤w)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f٢٠١٥x) || !Float.isNaN(lVar.f٢٠١٥x)) {
            hashSet.add("progress");
        }
        if (f(this.f١٩٩٨g, lVar.f١٩٩٨g)) {
            hashSet.add("rotationX");
        }
        if (f(this.f١٩٩٩h, lVar.f١٩٩٩h)) {
            hashSet.add("rotationY");
        }
        if (f(this.f٢٠٠٢k, lVar.f٢٠٠٢k)) {
            hashSet.add("transformPivotX");
        }
        if (f(this.f٢٠٠٣l, lVar.f٢٠٠٣l)) {
            hashSet.add("transformPivotY");
        }
        if (f(this.f٢٠٠٠i, lVar.f٢٠٠٠i)) {
            hashSet.add("scaleX");
        }
        if (f(this.f٢٠٠١j, lVar.f٢٠٠١j)) {
            hashSet.add("scaleY");
        }
        if (f(this.f٢٠٠٤m, lVar.f٢٠٠٤m)) {
            hashSet.add("translationX");
        }
        if (f(this.f٢٠٠٥n, lVar.f٢٠٠٥n)) {
            hashSet.add("translationY");
        }
        if (f(this.f٢٠٠٦o, lVar.f٢٠٠٦o)) {
            hashSet.add("translationZ");
        }
    }

    void h(float f10, float f11, float f12, float f13) {
        this.f٢٠١٠s = f10;
        this.f٢٠١١t = f11;
        this.f٢٠١٢u = f12;
        this.f٢٠١٣v = f13;
    }

    public void i(Rect rect, androidx.constraintlayout.widget.c cVar, int i10, int i11) {
        h(rect.left, rect.top, rect.width(), rect.height());
        d(cVar.z(i11));
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        return;
                    }
                }
            }
            float f10 = this.f١٩٩٧f + 90.0f;
            this.f١٩٩٧f = f10;
            if (f10 > 180.0f) {
                this.f١٩٩٧f = f10 - 360.0f;
                return;
            }
            return;
        }
        this.f١٩٩٧f -= 90.0f;
    }

    public void j(View view) {
        h(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        c(view);
    }
}
