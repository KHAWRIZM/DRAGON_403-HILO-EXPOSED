package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.widget.c;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class o implements Comparable {

    /* renamed from: t, reason: collision with root package name */
    static String[] f٢٠٤٦t = {"position", "x", "y", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "pathRotate"};

    /* renamed from: a, reason: collision with root package name */
    a2.c f٢٠٤٧a;

    /* renamed from: c, reason: collision with root package name */
    float f٢٠٤٩c;

    /* renamed from: d, reason: collision with root package name */
    float f٢٠٥٠d;

    /* renamed from: e, reason: collision with root package name */
    float f٢٠٥١e;

    /* renamed from: f, reason: collision with root package name */
    float f٢٠٥٢f;

    /* renamed from: g, reason: collision with root package name */
    float f٢٠٥٣g;

    /* renamed from: h, reason: collision with root package name */
    float f٢٠٥٤h;

    /* renamed from: k, reason: collision with root package name */
    int f٢٠٥٧k;

    /* renamed from: l, reason: collision with root package name */
    int f٢٠٥٨l;

    /* renamed from: m, reason: collision with root package name */
    float f٢٠٥٩m;

    /* renamed from: n, reason: collision with root package name */
    m f٢٠٦٠n;

    /* renamed from: o, reason: collision with root package name */
    LinkedHashMap f٢٠٦١o;

    /* renamed from: p, reason: collision with root package name */
    int f٢٠٦٢p;

    /* renamed from: q, reason: collision with root package name */
    int f٢٠٦٣q;

    /* renamed from: r, reason: collision with root package name */
    double[] f٢٠٦٤r;

    /* renamed from: s, reason: collision with root package name */
    double[] f٢٠٦٥s;

    /* renamed from: b, reason: collision with root package name */
    int f٢٠٤٨b = 0;

    /* renamed from: i, reason: collision with root package name */
    float f٢٠٥٥i = Float.NaN;

    /* renamed from: j, reason: collision with root package name */
    float f٢٠٥٦j = Float.NaN;

    public o() {
        int i10 = d.f١٩٥١f;
        this.f٢٠٥٧k = i10;
        this.f٢٠٥٨l = i10;
        this.f٢٠٥٩m = Float.NaN;
        this.f٢٠٦٠n = null;
        this.f٢٠٦١o = new LinkedHashMap();
        this.f٢٠٦٢p = 0;
        this.f٢٠٦٤r = new double[18];
        this.f٢٠٦٥s = new double[18];
    }

    private boolean d(float f10, float f11) {
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

    public void a(c.a aVar) {
        this.f٢٠٤٧a = a2.c.c(aVar.f٢٤١٨d.f٢٤٨٤d);
        c.C٠٠١٩c r02 = aVar.f٢٤١٨d;
        this.f٢٠٥٧k = r02.f٢٤٨٥e;
        this.f٢٠٥٨l = r02.f٢٤٨٢b;
        this.f٢٠٥٥i = r02.f٢٤٨٩i;
        this.f٢٠٤٨b = r02.f٢٤٨٦f;
        this.f٢٠٦٣q = r02.f٢٤٨٣c;
        this.f٢٠٥٦j = aVar.f٢٤١٧c.f٢٤٩٩e;
        this.f٢٠٥٩m = aVar.f٢٤١٩e.D;
        for (String str : aVar.f٢٤٢١g.keySet()) {
            androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) aVar.f٢٤٢١g.get(str);
            if (aVar2 != null && aVar2.f()) {
                this.f٢٠٦١o.put(str, aVar2);
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(o oVar) {
        return Float.compare(this.f٢٠٥٠d, oVar.f٢٠٥٠d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(o oVar, boolean[] zArr, String[] strArr, boolean z10) {
        boolean d10 = d(this.f٢٠٥١e, oVar.f٢٠٥١e);
        boolean d11 = d(this.f٢٠٥٢f, oVar.f٢٠٥٢f);
        zArr[0] = zArr[0] | d(this.f٢٠٥٠d, oVar.f٢٠٥٠d);
        boolean z11 = d10 | d11 | z10;
        zArr[1] = zArr[1] | z11;
        zArr[2] = z11 | zArr[2];
        zArr[3] = zArr[3] | d(this.f٢٠٥٣g, oVar.f٢٠٥٣g);
        zArr[4] = d(this.f٢٠٥٤h, oVar.f٢٠٥٤h) | zArr[4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(double[] dArr, int[] iArr) {
        float[] fArr = {this.f٢٠٥٠d, this.f٢٠٥١e, this.f٢٠٥٢f, this.f٢٠٥٣g, this.f٢٠٥٤h, this.f٢٠٥٥i};
        int i10 = 0;
        for (int i11 : iArr) {
            if (i11 < 6) {
                dArr[i10] = fArr[r2];
                i10++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(double d10, int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f٢٠٥١e;
        float f11 = this.f٢٠٥٢f;
        float f12 = this.f٢٠٥٣g;
        float f13 = this.f٢٠٥٤h;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f14 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 != 1) {
                if (i12 != 2) {
                    if (i12 != 3) {
                        if (i12 == 4) {
                            f13 = f14;
                        }
                    } else {
                        f12 = f14;
                    }
                } else {
                    f11 = f14;
                }
            } else {
                f10 = f14;
            }
        }
        m mVar = this.f٢٠٦٠n;
        if (mVar != null) {
            float[] fArr2 = new float[2];
            mVar.i(d10, fArr2, new float[2]);
            float f15 = fArr2[0];
            float f16 = fArr2[1];
            double d11 = f15;
            double d12 = f10;
            double d13 = f11;
            f10 = (float) ((d11 + (Math.sin(d13) * d12)) - (f12 / 2.0f));
            f11 = (float) ((f16 - (d12 * Math.cos(d13))) - (f13 / 2.0f));
        }
        fArr[i10] = f10 + (f12 / 2.0f) + DownloadProgress.UNKNOWN_PROGRESS;
        fArr[i10 + 1] = f11 + (f13 / 2.0f) + DownloadProgress.UNKNOWN_PROGRESS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(double d10, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f10;
        float f11 = this.f٢٠٥١e;
        float f12 = this.f٢٠٥٢f;
        float f13 = this.f٢٠٥٣g;
        float f14 = this.f٢٠٥٤h;
        float f15 = DownloadProgress.UNKNOWN_PROGRESS;
        float f16 = DownloadProgress.UNKNOWN_PROGRESS;
        float f17 = DownloadProgress.UNKNOWN_PROGRESS;
        float f18 = DownloadProgress.UNKNOWN_PROGRESS;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f19 = (float) dArr[i10];
            float f20 = (float) dArr2[i10];
            int i11 = iArr[i10];
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 3) {
                        if (i11 == 4) {
                            f14 = f19;
                            f18 = f20;
                        }
                    } else {
                        f13 = f19;
                        f16 = f20;
                    }
                } else {
                    f12 = f19;
                    f17 = f20;
                }
            } else {
                f11 = f19;
                f15 = f20;
            }
        }
        float f21 = 2.0f;
        float f22 = (f16 / 2.0f) + f15;
        float f23 = (f18 / 2.0f) + f17;
        m mVar = this.f٢٠٦٠n;
        if (mVar != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            mVar.i(d10, fArr3, fArr4);
            float f24 = fArr3[0];
            float f25 = fArr3[1];
            float f26 = fArr4[0];
            float f27 = fArr4[1];
            double d11 = f11;
            double d12 = f12;
            f10 = f13;
            float sin = (float) ((f24 + (Math.sin(d12) * d11)) - (f13 / 2.0f));
            float cos = (float) ((f25 - (d11 * Math.cos(d12))) - (f14 / 2.0f));
            double d13 = f15;
            double d14 = f17;
            float sin2 = (float) (f26 + (Math.sin(d12) * d13) + (Math.cos(d12) * d14));
            f23 = (float) ((f27 - (d13 * Math.cos(d12))) + (Math.sin(d12) * d14));
            f22 = sin2;
            f11 = sin;
            f12 = cos;
            f21 = 2.0f;
        } else {
            f10 = f13;
        }
        fArr[0] = f11 + (f10 / f21) + DownloadProgress.UNKNOWN_PROGRESS;
        fArr[1] = f12 + (f14 / f21) + DownloadProgress.UNKNOWN_PROGRESS;
        fArr2[0] = f22;
        fArr2[1] = f23;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(String str, double[] dArr, int i10) {
        androidx.constraintlayout.widget.a aVar = (androidx.constraintlayout.widget.a) this.f٢٠٦١o.get(str);
        int i11 = 0;
        if (aVar == null) {
            return 0;
        }
        if (aVar.g() == 1) {
            dArr[i10] = aVar.d();
            return 1;
        }
        int g10 = aVar.g();
        aVar.e(new float[g10]);
        while (i11 < g10) {
            dArr[i10] = r2[i11];
            i11++;
            i10++;
        }
        return g10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(String str) {
        androidx.constraintlayout.widget.a aVar = (androidx.constraintlayout.widget.a) this.f٢٠٦١o.get(str);
        if (aVar == null) {
            return 0;
        }
        return aVar.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f٢٠٥١e;
        float f11 = this.f٢٠٥٢f;
        float f12 = this.f٢٠٥٣g;
        float f13 = this.f٢٠٥٤h;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f14 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 != 1) {
                if (i12 != 2) {
                    if (i12 != 3) {
                        if (i12 == 4) {
                            f13 = f14;
                        }
                    } else {
                        f12 = f14;
                    }
                } else {
                    f11 = f14;
                }
            } else {
                f10 = f14;
            }
        }
        m mVar = this.f٢٠٦٠n;
        if (mVar != null) {
            float j10 = mVar.j();
            float k10 = this.f٢٠٦٠n.k();
            double d10 = f10;
            double d11 = f11;
            float sin = (float) ((j10 + (Math.sin(d11) * d10)) - (f12 / 2.0f));
            f11 = (float) ((k10 - (d10 * Math.cos(d11))) - (f13 / 2.0f));
            f10 = sin;
        }
        float f15 = f12 + f10;
        float f16 = f13 + f11;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        float f17 = f10 + DownloadProgress.UNKNOWN_PROGRESS;
        float f18 = f11 + DownloadProgress.UNKNOWN_PROGRESS;
        float f19 = f15 + DownloadProgress.UNKNOWN_PROGRESS;
        float f20 = f11 + DownloadProgress.UNKNOWN_PROGRESS;
        float f21 = f15 + DownloadProgress.UNKNOWN_PROGRESS;
        float f22 = f16 + DownloadProgress.UNKNOWN_PROGRESS;
        float f23 = f10 + DownloadProgress.UNKNOWN_PROGRESS;
        float f24 = f16 + DownloadProgress.UNKNOWN_PROGRESS;
        fArr[i10] = f17;
        fArr[i10 + 1] = f18;
        fArr[i10 + 2] = f19;
        fArr[i10 + 3] = f20;
        fArr[i10 + 4] = f21;
        fArr[i10 + 5] = f22;
        fArr[i10 + 6] = f23;
        fArr[i10 + 7] = f24;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l(String str) {
        return this.f٢٠٦١o.containsKey(str);
    }

    void m(h hVar, o oVar, o oVar2) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14 = hVar.f١٩٥٢a / 100.0f;
        this.f٢٠٤٩c = f14;
        this.f٢٠٤٨b = hVar.f١٩٧٩j;
        if (Float.isNaN(hVar.f١٩٨٠k)) {
            f10 = f14;
        } else {
            f10 = hVar.f١٩٨٠k;
        }
        if (Float.isNaN(hVar.f١٩٨١l)) {
            f11 = f14;
        } else {
            f11 = hVar.f١٩٨١l;
        }
        float f15 = oVar2.f٢٠٥٣g;
        float f16 = oVar.f٢٠٥٣g;
        float f17 = oVar2.f٢٠٥٤h;
        float f18 = oVar.f٢٠٥٤h;
        this.f٢٠٥٠d = this.f٢٠٤٩c;
        float f19 = oVar.f٢٠٥١e;
        float f20 = oVar.f٢٠٥٢f;
        float f21 = (oVar2.f٢٠٥١e + (f15 / 2.0f)) - ((f16 / 2.0f) + f19);
        float f22 = (oVar2.f٢٠٥٢f + (f17 / 2.0f)) - (f20 + (f18 / 2.0f));
        float f23 = ((f15 - f16) * f10) / 2.0f;
        this.f٢٠٥١e = (int) ((f19 + (f21 * f14)) - f23);
        float f24 = ((f17 - f18) * f11) / 2.0f;
        this.f٢٠٥٢f = (int) ((f20 + (f22 * f14)) - f24);
        this.f٢٠٥٣g = (int) (f16 + r9);
        this.f٢٠٥٤h = (int) (f18 + r12);
        if (Float.isNaN(hVar.f١٩٨٢m)) {
            f12 = f14;
        } else {
            f12 = hVar.f١٩٨٢m;
        }
        boolean isNaN = Float.isNaN(hVar.f١٩٨٥p);
        float f25 = DownloadProgress.UNKNOWN_PROGRESS;
        if (isNaN) {
            f13 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            f13 = hVar.f١٩٨٥p;
        }
        if (!Float.isNaN(hVar.f١٩٨٣n)) {
            f14 = hVar.f١٩٨٣n;
        }
        if (!Float.isNaN(hVar.f١٩٨٤o)) {
            f25 = hVar.f١٩٨٤o;
        }
        this.f٢٠٦٢p = 0;
        this.f٢٠٥١e = (int) (((oVar.f٢٠٥١e + (f12 * f21)) + (f25 * f22)) - f23);
        this.f٢٠٥٢f = (int) (((oVar.f٢٠٥٢f + (f21 * f13)) + (f22 * f14)) - f24);
        this.f٢٠٤٧a = a2.c.c(hVar.f١٩٧٧h);
        this.f٢٠٥٧k = hVar.f١٩٧٨i;
    }

    void n(h hVar, o oVar, o oVar2) {
        float f10;
        float f11;
        float f12;
        float f13 = hVar.f١٩٥٢a / 100.0f;
        this.f٢٠٤٩c = f13;
        this.f٢٠٤٨b = hVar.f١٩٧٩j;
        if (Float.isNaN(hVar.f١٩٨٠k)) {
            f10 = f13;
        } else {
            f10 = hVar.f١٩٨٠k;
        }
        if (Float.isNaN(hVar.f١٩٨١l)) {
            f11 = f13;
        } else {
            f11 = hVar.f١٩٨١l;
        }
        float f14 = oVar2.f٢٠٥٣g - oVar.f٢٠٥٣g;
        float f15 = oVar2.f٢٠٥٤h - oVar.f٢٠٥٤h;
        this.f٢٠٥٠d = this.f٢٠٤٩c;
        if (!Float.isNaN(hVar.f١٩٨٢m)) {
            f13 = hVar.f١٩٨٢m;
        }
        float f16 = oVar.f٢٠٥١e;
        float f17 = oVar.f٢٠٥٣g;
        float f18 = oVar.f٢٠٥٢f;
        float f19 = oVar.f٢٠٥٤h;
        float f20 = (oVar2.f٢٠٥١e + (oVar2.f٢٠٥٣g / 2.0f)) - ((f17 / 2.0f) + f16);
        float f21 = (oVar2.f٢٠٥٢f + (oVar2.f٢٠٥٤h / 2.0f)) - ((f19 / 2.0f) + f18);
        float f22 = f20 * f13;
        float f23 = (f14 * f10) / 2.0f;
        this.f٢٠٥١e = (int) ((f16 + f22) - f23);
        float f24 = f13 * f21;
        float f25 = (f15 * f11) / 2.0f;
        this.f٢٠٥٢f = (int) ((f18 + f24) - f25);
        this.f٢٠٥٣g = (int) (f17 + r7);
        this.f٢٠٥٤h = (int) (f19 + r8);
        if (Float.isNaN(hVar.f١٩٨٣n)) {
            f12 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            f12 = hVar.f١٩٨٣n;
        }
        this.f٢٠٦٢p = 1;
        float f26 = (int) ((oVar.f٢٠٥١e + f22) - f23);
        float f27 = (int) ((oVar.f٢٠٥٢f + f24) - f25);
        this.f٢٠٥١e = f26 + ((-f21) * f12);
        this.f٢٠٥٢f = f27 + (f20 * f12);
        this.f٢٠٥٨l = this.f٢٠٥٨l;
        this.f٢٠٤٧a = a2.c.c(hVar.f١٩٧٧h);
        this.f٢٠٥٧k = hVar.f١٩٧٨i;
    }

    void o(int i10, int i11, h hVar, o oVar, o oVar2) {
        float f10;
        float f11;
        float f12;
        float min;
        float f13;
        float f14;
        float f15 = hVar.f١٩٥٢a / 100.0f;
        this.f٢٠٤٩c = f15;
        this.f٢٠٤٨b = hVar.f١٩٧٩j;
        this.f٢٠٦٢p = hVar.f١٩٨٦q;
        if (Float.isNaN(hVar.f١٩٨٠k)) {
            f10 = f15;
        } else {
            f10 = hVar.f١٩٨٠k;
        }
        if (Float.isNaN(hVar.f١٩٨١l)) {
            f11 = f15;
        } else {
            f11 = hVar.f١٩٨١l;
        }
        float f16 = oVar2.f٢٠٥٣g;
        float f17 = oVar.f٢٠٥٣g;
        float f18 = oVar2.f٢٠٥٤h;
        float f19 = oVar.f٢٠٥٤h;
        this.f٢٠٥٠d = this.f٢٠٤٩c;
        this.f٢٠٥٣g = (int) (f17 + ((f16 - f17) * f10));
        this.f٢٠٥٤h = (int) (f19 + ((f18 - f19) * f11));
        int i12 = hVar.f١٩٨٦q;
        if (i12 != 1) {
            if (i12 != 2) {
                if (Float.isNaN(hVar.f١٩٨٢m)) {
                    f14 = f15;
                } else {
                    f14 = hVar.f١٩٨٢m;
                }
                float f20 = oVar2.f٢٠٥١e;
                float f21 = oVar.f٢٠٥١e;
                this.f٢٠٥١e = (f14 * (f20 - f21)) + f21;
                if (!Float.isNaN(hVar.f١٩٨٣n)) {
                    f15 = hVar.f١٩٨٣n;
                }
                float f22 = oVar2.f٢٠٥٢f;
                float f23 = oVar.f٢٠٥٢f;
                this.f٢٠٥٢f = (f15 * (f22 - f23)) + f23;
            } else {
                if (Float.isNaN(hVar.f١٩٨٢m)) {
                    float f24 = oVar2.f٢٠٥١e;
                    float f25 = oVar.f٢٠٥١e;
                    min = ((f24 - f25) * f15) + f25;
                } else {
                    min = Math.min(f11, f10) * hVar.f١٩٨٢m;
                }
                this.f٢٠٥١e = min;
                if (Float.isNaN(hVar.f١٩٨٣n)) {
                    float f26 = oVar2.f٢٠٥٢f;
                    float f27 = oVar.f٢٠٥٢f;
                    f13 = (f15 * (f26 - f27)) + f27;
                } else {
                    f13 = hVar.f١٩٨٣n;
                }
                this.f٢٠٥٢f = f13;
            }
        } else {
            if (Float.isNaN(hVar.f١٩٨٢m)) {
                f12 = f15;
            } else {
                f12 = hVar.f١٩٨٢m;
            }
            float f28 = oVar2.f٢٠٥١e;
            float f29 = oVar.f٢٠٥١e;
            this.f٢٠٥١e = (f12 * (f28 - f29)) + f29;
            if (!Float.isNaN(hVar.f١٩٨٣n)) {
                f15 = hVar.f١٩٨٣n;
            }
            float f30 = oVar2.f٢٠٥٢f;
            float f31 = oVar.f٢٠٥٢f;
            this.f٢٠٥٢f = (f15 * (f30 - f31)) + f31;
        }
        this.f٢٠٥٨l = oVar.f٢٠٥٨l;
        this.f٢٠٤٧a = a2.c.c(hVar.f١٩٧٧h);
        this.f٢٠٥٧k = hVar.f١٩٧٨i;
    }

    void p(int i10, int i11, h hVar, o oVar, o oVar2) {
        float f10;
        float f11;
        float f12 = hVar.f١٩٥٢a / 100.0f;
        this.f٢٠٤٩c = f12;
        this.f٢٠٤٨b = hVar.f١٩٧٩j;
        if (Float.isNaN(hVar.f١٩٨٠k)) {
            f10 = f12;
        } else {
            f10 = hVar.f١٩٨٠k;
        }
        if (Float.isNaN(hVar.f١٩٨١l)) {
            f11 = f12;
        } else {
            f11 = hVar.f١٩٨١l;
        }
        float f13 = oVar2.f٢٠٥٣g;
        float f14 = oVar.f٢٠٥٣g;
        float f15 = oVar2.f٢٠٥٤h;
        float f16 = oVar.f٢٠٥٤h;
        this.f٢٠٥٠d = this.f٢٠٤٩c;
        float f17 = oVar.f٢٠٥١e;
        float f18 = oVar.f٢٠٥٢f;
        float f19 = oVar2.f٢٠٥١e + (f13 / 2.0f);
        float f20 = oVar2.f٢٠٥٢f + (f15 / 2.0f);
        float f21 = (f13 - f14) * f10;
        this.f٢٠٥١e = (int) ((f17 + ((f19 - ((f14 / 2.0f) + f17)) * f12)) - (f21 / 2.0f));
        float f22 = (f15 - f16) * f11;
        this.f٢٠٥٢f = (int) ((f18 + ((f20 - (f18 + (f16 / 2.0f))) * f12)) - (f22 / 2.0f));
        this.f٢٠٥٣g = (int) (f14 + f21);
        this.f٢٠٥٤h = (int) (f16 + f22);
        this.f٢٠٦٢p = 2;
        if (!Float.isNaN(hVar.f١٩٨٢m)) {
            this.f٢٠٥١e = (int) (hVar.f١٩٨٢m * ((int) (i10 - this.f٢٠٥٣g)));
        }
        if (!Float.isNaN(hVar.f١٩٨٣n)) {
            this.f٢٠٥٢f = (int) (hVar.f١٩٨٣n * ((int) (i11 - this.f٢٠٥٤h)));
        }
        this.f٢٠٥٨l = this.f٢٠٥٨l;
        this.f٢٠٤٧a = a2.c.c(hVar.f١٩٧٧h);
        this.f٢٠٥٧k = hVar.f١٩٧٨i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(float f10, float f11, float f12, float f13) {
        this.f٢٠٥١e = f10;
        this.f٢٠٥٢f = f11;
        this.f٢٠٥٣g = f12;
        this.f٢٠٥٤h = f13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(float f10, float f11, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f12 = DownloadProgress.UNKNOWN_PROGRESS;
        float f13 = DownloadProgress.UNKNOWN_PROGRESS;
        float f14 = DownloadProgress.UNKNOWN_PROGRESS;
        float f15 = DownloadProgress.UNKNOWN_PROGRESS;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f16 = (float) dArr[i10];
            double d10 = dArr2[i10];
            int i11 = iArr[i10];
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 3) {
                        if (i11 == 4) {
                            f15 = f16;
                        }
                    } else {
                        f13 = f16;
                    }
                } else {
                    f14 = f16;
                }
            } else {
                f12 = f16;
            }
        }
        float f17 = f12 - ((DownloadProgress.UNKNOWN_PROGRESS * f13) / 2.0f);
        float f18 = f14 - ((DownloadProgress.UNKNOWN_PROGRESS * f15) / 2.0f);
        fArr[0] = (f17 * (1.0f - f10)) + (((f13 * 1.0f) + f17) * f10) + DownloadProgress.UNKNOWN_PROGRESS;
        fArr[1] = (f18 * (1.0f - f11)) + (((f15 * 1.0f) + f18) * f11) + DownloadProgress.UNKNOWN_PROGRESS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void s(float f10, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z10) {
        float f11;
        float f12;
        float f13 = this.f٢٠٥١e;
        float f14 = this.f٢٠٥٢f;
        float f15 = this.f٢٠٥٣g;
        float f16 = this.f٢٠٥٤h;
        if (iArr.length != 0 && this.f٢٠٦٤r.length <= iArr[iArr.length - 1]) {
            int i10 = iArr[iArr.length - 1] + 1;
            this.f٢٠٦٤r = new double[i10];
            this.f٢٠٦٥s = new double[i10];
        }
        Arrays.fill(this.f٢٠٦٤r, Double.NaN);
        for (int i11 = 0; i11 < iArr.length; i11++) {
            double[] dArr4 = this.f٢٠٦٤r;
            int i12 = iArr[i11];
            dArr4[i12] = dArr[i11];
            this.f٢٠٦٥s[i12] = dArr2[i11];
        }
        float f17 = Float.NaN;
        int i13 = 0;
        float f18 = DownloadProgress.UNKNOWN_PROGRESS;
        float f19 = DownloadProgress.UNKNOWN_PROGRESS;
        float f20 = DownloadProgress.UNKNOWN_PROGRESS;
        float f21 = DownloadProgress.UNKNOWN_PROGRESS;
        while (true) {
            double[] dArr5 = this.f٢٠٦٤r;
            if (i13 >= dArr5.length) {
                break;
            }
            boolean isNaN = Double.isNaN(dArr5[i13]);
            double d10 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (isNaN && (dArr3 == null || dArr3[i13] == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
                f12 = f17;
            } else {
                if (dArr3 != null) {
                    d10 = dArr3[i13];
                }
                if (!Double.isNaN(this.f٢٠٦٤r[i13])) {
                    d10 = this.f٢٠٦٤r[i13] + d10;
                }
                f12 = f17;
                float f22 = (float) d10;
                float f23 = (float) this.f٢٠٦٥s[i13];
                if (i13 != 1) {
                    if (i13 != 2) {
                        if (i13 != 3) {
                            if (i13 != 4) {
                                if (i13 == 5) {
                                    f17 = f22;
                                }
                            } else {
                                f17 = f12;
                                f21 = f23;
                                f16 = f22;
                            }
                        } else {
                            f17 = f12;
                            f20 = f23;
                            f15 = f22;
                        }
                    } else {
                        f17 = f12;
                        f19 = f23;
                        f14 = f22;
                    }
                } else {
                    f17 = f12;
                    f18 = f23;
                    f13 = f22;
                }
                i13++;
            }
            f17 = f12;
            i13++;
        }
        float f24 = f17;
        m mVar = this.f٢٠٦٠n;
        if (mVar != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            mVar.i(f10, fArr, fArr2);
            float f25 = fArr[0];
            float f26 = fArr[1];
            float f27 = fArr2[0];
            float f28 = fArr2[1];
            double d11 = f13;
            double d12 = f14;
            float sin = (float) ((f25 + (Math.sin(d12) * d11)) - (f15 / 2.0f));
            f11 = f16;
            float cos = (float) ((f26 - (Math.cos(d12) * d11)) - (f16 / 2.0f));
            double d13 = f18;
            double d14 = f19;
            float sin2 = (float) (f27 + (Math.sin(d12) * d13) + (Math.cos(d12) * d11 * d14));
            float cos2 = (float) ((f28 - (d13 * Math.cos(d12))) + (d11 * Math.sin(d12) * d14));
            if (dArr2.length >= 2) {
                dArr2[0] = sin2;
                dArr2[1] = cos2;
            }
            if (!Float.isNaN(f24)) {
                view.setRotation((float) (f24 + Math.toDegrees(Math.atan2(cos2, sin2))));
            }
            f13 = sin;
            f14 = cos;
        } else {
            f11 = f16;
            if (!Float.isNaN(f24)) {
                view.setRotation((float) (DownloadProgress.UNKNOWN_PROGRESS + f24 + Math.toDegrees(Math.atan2(f19 + (f21 / 2.0f), f18 + (f20 / 2.0f)))));
            }
        }
        if (view instanceof c) {
            ((c) view).a(f13, f14, f15 + f13, f14 + f11);
            return;
        }
        float f29 = f13 + 0.5f;
        int i14 = (int) f29;
        float f30 = f14 + 0.5f;
        int i15 = (int) f30;
        int i16 = (int) (f29 + f15);
        int i17 = (int) (f30 + f11);
        int i18 = i16 - i14;
        int i19 = i17 - i15;
        if (i18 != view.getMeasuredWidth() || i19 != view.getMeasuredHeight() || z10) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(i19, 1073741824));
        }
        view.layout(i14, i15, i16, i17);
    }

    public void t(m mVar, o oVar) {
        double d10 = ((this.f٢٠٥١e + (this.f٢٠٥٣g / 2.0f)) - oVar.f٢٠٥١e) - (oVar.f٢٠٥٣g / 2.0f);
        double d11 = ((this.f٢٠٥٢f + (this.f٢٠٥٤h / 2.0f)) - oVar.f٢٠٥٢f) - (oVar.f٢٠٥٤h / 2.0f);
        this.f٢٠٦٠n = mVar;
        this.f٢٠٥١e = (float) Math.hypot(d11, d10);
        if (Float.isNaN(this.f٢٠٥٩m)) {
            this.f٢٠٥٢f = (float) (Math.atan2(d11, d10) + 1.5707963267948966d);
        } else {
            this.f٢٠٥٢f = (float) Math.toRadians(this.f٢٠٥٩m);
        }
    }

    public o(int i10, int i11, h hVar, o oVar, o oVar2) {
        int i12 = d.f١٩٥١f;
        this.f٢٠٥٧k = i12;
        this.f٢٠٥٨l = i12;
        this.f٢٠٥٩m = Float.NaN;
        this.f٢٠٦٠n = null;
        this.f٢٠٦١o = new LinkedHashMap();
        this.f٢٠٦٢p = 0;
        this.f٢٠٦٤r = new double[18];
        this.f٢٠٦٥s = new double[18];
        if (oVar.f٢٠٥٨l != d.f١٩٥١f) {
            o(i10, i11, hVar, oVar, oVar2);
            return;
        }
        int i13 = hVar.f١٩٨٦q;
        if (i13 == 1) {
            n(hVar, oVar, oVar2);
        } else if (i13 != 2) {
            m(hVar, oVar, oVar2);
        } else {
            p(i10, i11, hVar, oVar, oVar2);
        }
    }
}
