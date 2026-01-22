package t3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.j;
import com.airbnb.lottie.j0;
import com.airbnb.lottie.n0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinVersion;
import o3.o;
import q3.b;
import r3.k;
import s3.q;
import x3.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class i extends t3.b {
    private final StringBuilder D;
    private final RectF E;
    private final Matrix F;
    private final Paint G;
    private final Paint H;
    private final Map I;
    private final LongSparseArray J;
    private final List K;
    private final o L;
    private final j0 M;
    private final j N;
    private o3.a O;
    private o3.a P;
    private o3.a Q;
    private o3.a R;
    private o3.a S;
    private o3.a T;
    private o3.a U;
    private o3.a V;
    private o3.a W;
    private o3.a X;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a extends Paint {
        a(int i10) {
            super(i10);
            setStyle(Paint.Style.FILL);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b extends Paint {
        b(int i10) {
            super(i10);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٨٠٢١a;

        static {
            int[] iArr = new int[b.a.values().length];
            f١٨٠٢١a = iArr;
            try {
                iArr[b.a.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٨٠٢١a[b.a.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٨٠٢١a[b.a.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(j0 j0Var, e eVar) {
        super(j0Var, eVar);
        r3.b bVar;
        r3.b bVar2;
        r3.a aVar;
        r3.a aVar2;
        this.D = new StringBuilder(2);
        this.E = new RectF();
        this.F = new Matrix();
        this.G = new a(1);
        this.H = new b(1);
        this.I = new HashMap();
        this.J = new LongSparseArray();
        this.K = new ArrayList();
        this.M = j0Var;
        this.N = eVar.c();
        o a10 = eVar.t().a();
        this.L = a10;
        a10.a(this);
        i(a10);
        k u10 = eVar.u();
        if (u10 != null && (aVar2 = u10.f١٧٣٢٥a) != null) {
            o3.a a11 = aVar2.a();
            this.O = a11;
            a11.a(this);
            i(this.O);
        }
        if (u10 != null && (aVar = u10.f١٧٣٢٦b) != null) {
            o3.a a12 = aVar.a();
            this.Q = a12;
            a12.a(this);
            i(this.Q);
        }
        if (u10 != null && (bVar2 = u10.f١٧٣٢٧c) != null) {
            o3.a a13 = bVar2.a();
            this.S = a13;
            a13.a(this);
            i(this.S);
        }
        if (u10 != null && (bVar = u10.f١٧٣٢٨d) != null) {
            o3.a a14 = bVar.a();
            this.U = a14;
            a14.a(this);
            i(this.U);
        }
    }

    private String P(String str, int i10) {
        int codePointAt = str.codePointAt(i10);
        int charCount = Character.charCount(codePointAt) + i10;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!d0(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j10 = codePointAt;
        if (this.J.containsKey(j10)) {
            return (String) this.J.get(j10);
        }
        this.D.setLength(0);
        while (i10 < charCount) {
            int codePointAt3 = str.codePointAt(i10);
            this.D.appendCodePoint(codePointAt3);
            i10 += Character.charCount(codePointAt3);
        }
        String sb = this.D.toString();
        this.J.put(j10, sb);
        return sb;
    }

    private void Q(q3.b bVar, int i10) {
        int intValue;
        o3.a aVar = this.P;
        if (aVar != null) {
            this.G.setColor(((Integer) aVar.h()).intValue());
        } else {
            o3.a aVar2 = this.O;
            if (aVar2 != null) {
                this.G.setColor(((Integer) aVar2.h()).intValue());
            } else {
                this.G.setColor(bVar.f١٧٠٩٤h);
            }
        }
        o3.a aVar3 = this.R;
        if (aVar3 != null) {
            this.H.setColor(((Integer) aVar3.h()).intValue());
        } else {
            o3.a aVar4 = this.Q;
            if (aVar4 != null) {
                this.H.setColor(((Integer) aVar4.h()).intValue());
            } else {
                this.H.setColor(bVar.f١٧٠٩٥i);
            }
        }
        if (this.f١٧٩٧٣x.h() == null) {
            intValue = 100;
        } else {
            intValue = ((Integer) this.f١٧٩٧٣x.h().h()).intValue();
        }
        int i11 = (((intValue * KotlinVersion.MAX_COMPONENT_VALUE) / 100) * i10) / KotlinVersion.MAX_COMPONENT_VALUE;
        this.G.setAlpha(i11);
        this.H.setAlpha(i11);
        o3.a aVar5 = this.T;
        if (aVar5 != null) {
            this.H.setStrokeWidth(((Float) aVar5.h()).floatValue());
            return;
        }
        o3.a aVar6 = this.S;
        if (aVar6 != null) {
            this.H.setStrokeWidth(((Float) aVar6.h()).floatValue());
        } else {
            this.H.setStrokeWidth(bVar.f١٧٠٩٦j * l.e());
        }
    }

    private void R(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == DownloadProgress.UNKNOWN_PROGRESS) {
            return;
        }
        canvas.drawText(str, 0, str.length(), DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, paint);
    }

    private void S(q3.d dVar, float f10, q3.b bVar, Canvas canvas) {
        List a02 = a0(dVar);
        for (int i10 = 0; i10 < a02.size(); i10++) {
            Path path = ((n3.d) a02.get(i10)).getPath();
            path.computeBounds(this.E, false);
            this.F.reset();
            this.F.preTranslate(DownloadProgress.UNKNOWN_PROGRESS, (-bVar.f١٧٠٩٣g) * l.e());
            this.F.preScale(f10, f10);
            path.transform(this.F);
            if (bVar.f١٧٠٩٧k) {
                V(path, this.G, canvas);
                V(path, this.H, canvas);
            } else {
                V(path, this.H, canvas);
                V(path, this.G, canvas);
            }
        }
    }

    private void T(String str, q3.b bVar, Canvas canvas) {
        if (bVar.f١٧٠٩٧k) {
            R(str, this.G, canvas);
            R(str, this.H, canvas);
        } else {
            R(str, this.H, canvas);
            R(str, this.G, canvas);
        }
    }

    private void U(String str, q3.b bVar, Canvas canvas, float f10) {
        int i10 = 0;
        while (i10 < str.length()) {
            String P = P(str, i10);
            i10 += P.length();
            T(P, bVar, canvas);
            canvas.translate(this.G.measureText(P) + f10, DownloadProgress.UNKNOWN_PROGRESS);
        }
    }

    private void V(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == DownloadProgress.UNKNOWN_PROGRESS) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void W(String str, q3.b bVar, q3.c cVar, Canvas canvas, float f10, float f11, float f12) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            q3.d dVar = (q3.d) this.N.c().get(q3.d.c(str.charAt(i10), cVar.a(), cVar.c()));
            if (dVar != null) {
                S(dVar, f11, bVar, canvas);
                canvas.translate((((float) dVar.b()) * f11 * l.e()) + f12, DownloadProgress.UNKNOWN_PROGRESS);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void X(q3.b bVar, q3.c cVar, Canvas canvas) {
        float f10;
        float floatValue;
        int size;
        int i10;
        float f11;
        Typeface c02 = c0(cVar);
        if (c02 == null) {
            return;
        }
        String str = bVar.f١٧٠٨٧a;
        this.M.a0();
        this.G.setTypeface(c02);
        o3.a aVar = this.W;
        if (aVar != null) {
            f10 = ((Float) aVar.h()).floatValue();
        } else {
            f10 = bVar.f١٧٠٨٩c;
        }
        this.G.setTextSize(l.e() * f10);
        this.H.setTypeface(this.G.getTypeface());
        this.H.setTextSize(this.G.getTextSize());
        float f12 = bVar.f١٧٠٩١e / 10.0f;
        o3.a aVar2 = this.V;
        if (aVar2 != null) {
            floatValue = ((Float) aVar2.h()).floatValue();
        } else {
            o3.a aVar3 = this.U;
            if (aVar3 != null) {
                floatValue = ((Float) aVar3.h()).floatValue();
            }
            float e10 = ((f12 * l.e()) * f10) / 100.0f;
            List b02 = b0(str);
            size = b02.size();
            i10 = 0;
            int i11 = -1;
            while (i10 < size) {
                String str2 = (String) b02.get(i10);
                PointF pointF = bVar.f١٧٠٩٩m;
                if (pointF == null) {
                    f11 = DownloadProgress.UNKNOWN_PROGRESS;
                } else {
                    f11 = pointF.x;
                }
                int i12 = i10;
                List f02 = f0(str2, f11, cVar, DownloadProgress.UNKNOWN_PROGRESS, e10, false);
                for (int i13 = 0; i13 < f02.size(); i13++) {
                    d dVar = (d) f02.get(i13);
                    i11++;
                    canvas.save();
                    if (e0(canvas, bVar, i11, dVar.f١٨٠٢٣b)) {
                        U(dVar.f١٨٠٢٢a, bVar, canvas, e10);
                    }
                    canvas.restore();
                }
                i10 = i12 + 1;
            }
        }
        f12 += floatValue;
        float e102 = ((f12 * l.e()) * f10) / 100.0f;
        List b022 = b0(str);
        size = b022.size();
        i10 = 0;
        int i112 = -1;
        while (i10 < size) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void Y(q3.b bVar, Matrix matrix, q3.c cVar, Canvas canvas) {
        float f10;
        float floatValue;
        int i10;
        float f11;
        int i11;
        List list;
        int i12;
        o3.a aVar = this.W;
        if (aVar != null) {
            f10 = ((Float) aVar.h()).floatValue();
        } else {
            f10 = bVar.f١٧٠٨٩c;
        }
        float f12 = f10 / 100.0f;
        float g10 = l.g(matrix);
        List b02 = b0(bVar.f١٧٠٨٧a);
        int size = b02.size();
        float f13 = bVar.f١٧٠٩١e / 10.0f;
        o3.a aVar2 = this.V;
        if (aVar2 != null) {
            floatValue = ((Float) aVar2.h()).floatValue();
        } else {
            o3.a aVar3 = this.U;
            if (aVar3 != null) {
                floatValue = ((Float) aVar3.h()).floatValue();
            }
            float f14 = f13;
            i10 = 0;
            int i13 = -1;
            while (i10 < size) {
                String str = (String) b02.get(i10);
                PointF pointF = bVar.f١٧٠٩٩m;
                if (pointF == null) {
                    f11 = DownloadProgress.UNKNOWN_PROGRESS;
                } else {
                    f11 = pointF.x;
                }
                int i14 = i10;
                List f02 = f0(str, f11, cVar, f12, f14, true);
                int i15 = 0;
                while (i15 < f02.size()) {
                    d dVar = (d) f02.get(i15);
                    int i16 = i13 + 1;
                    canvas.save();
                    if (e0(canvas, bVar, i16, dVar.f١٨٠٢٣b)) {
                        i11 = i15;
                        list = f02;
                        i12 = i16;
                        W(dVar.f١٨٠٢٢a, bVar, cVar, canvas, g10, f12, f14);
                    } else {
                        i11 = i15;
                        list = f02;
                        i12 = i16;
                    }
                    canvas.restore();
                    i15 = i11 + 1;
                    f02 = list;
                    i13 = i12;
                }
                i10 = i14 + 1;
            }
        }
        f13 += floatValue;
        float f142 = f13;
        i10 = 0;
        int i132 = -1;
        while (i10 < size) {
        }
    }

    private d Z(int i10) {
        for (int size = this.K.size(); size < i10; size++) {
            this.K.add(new d(null));
        }
        return (d) this.K.get(i10 - 1);
    }

    private List a0(q3.d dVar) {
        if (this.I.containsKey(dVar)) {
            return (List) this.I.get(dVar);
        }
        List a10 = dVar.a();
        int size = a10.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new n3.d(this.M, this, (q) a10.get(i10), this.N));
        }
        this.I.put(dVar, arrayList);
        return arrayList;
    }

    private List b0(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private Typeface c0(q3.c cVar) {
        Typeface typeface;
        o3.a aVar = this.X;
        if (aVar != null && (typeface = (Typeface) aVar.h()) != null) {
            return typeface;
        }
        Typeface b02 = this.M.b0(cVar);
        if (b02 != null) {
            return b02;
        }
        return cVar.d();
    }

    private boolean d0(int i10) {
        if (Character.getType(i10) != 16 && Character.getType(i10) != 27 && Character.getType(i10) != 6 && Character.getType(i10) != 28 && Character.getType(i10) != 8 && Character.getType(i10) != 19) {
            return false;
        }
        return true;
    }

    private boolean e0(Canvas canvas, q3.b bVar, int i10, float f10) {
        float f11;
        float f12;
        PointF pointF = bVar.f١٧٠٩٨l;
        PointF pointF2 = bVar.f١٧٠٩٩m;
        float e10 = l.e();
        float f13 = DownloadProgress.UNKNOWN_PROGRESS;
        if (pointF == null) {
            f11 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            f11 = (bVar.f١٧٠٩٢f * e10) + pointF.y;
        }
        float f14 = (i10 * bVar.f١٧٠٩٢f * e10) + f11;
        if (this.M.H() && pointF2 != null && pointF != null && f14 >= pointF.y + pointF2.y + bVar.f١٧٠٨٩c) {
            return false;
        }
        if (pointF == null) {
            f12 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            f12 = pointF.x;
        }
        if (pointF2 != null) {
            f13 = pointF2.x;
        }
        int i11 = c.f١٨٠٢١a[bVar.f١٧٠٩٠d.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 == 3) {
                    canvas.translate((f12 + (f13 / 2.0f)) - (f10 / 2.0f), f14);
                }
            } else {
                canvas.translate((f12 + f13) - f10, f14);
            }
        } else {
            canvas.translate(f12, f14);
        }
        return true;
    }

    private List f0(String str, float f10, q3.c cVar, float f11, float f12, boolean z10) {
        float measureText;
        float f13 = DownloadProgress.UNKNOWN_PROGRESS;
        int i10 = 0;
        int i11 = 0;
        boolean z11 = false;
        float f14 = DownloadProgress.UNKNOWN_PROGRESS;
        int i12 = 0;
        float f15 = DownloadProgress.UNKNOWN_PROGRESS;
        for (int i13 = 0; i13 < str.length(); i13++) {
            char charAt = str.charAt(i13);
            if (z10) {
                q3.d dVar = (q3.d) this.N.c().get(q3.d.c(charAt, cVar.a(), cVar.c()));
                if (dVar != null) {
                    measureText = ((float) dVar.b()) * f11 * l.e();
                }
            } else {
                measureText = this.G.measureText(str.substring(i13, i13 + 1));
            }
            float f16 = measureText + f12;
            if (charAt == ' ') {
                z11 = true;
                f15 = f16;
            } else if (z11) {
                i12 = i13;
                f14 = f16;
                z11 = false;
            } else {
                f14 += f16;
            }
            f13 += f16;
            if (f10 > DownloadProgress.UNKNOWN_PROGRESS && f13 >= f10 && charAt != ' ') {
                i10++;
                d Z = Z(i10);
                if (i12 == i11) {
                    Z.c(str.substring(i11, i13).trim(), (f13 - f16) - ((r9.length() - r7.length()) * f15));
                    i11 = i13;
                    i12 = i11;
                    f13 = f16;
                    f14 = f13;
                } else {
                    Z.c(str.substring(i11, i12 - 1).trim(), ((f13 - f14) - ((r7.length() - r13.length()) * f15)) - f15);
                    f13 = f14;
                    i11 = i12;
                }
            }
        }
        if (f13 > DownloadProgress.UNKNOWN_PROGRESS) {
            i10++;
            Z(i10).c(str.substring(i11), f13);
        }
        return this.K.subList(0, i10);
    }

    @Override // t3.b, q3.f
    public void c(Object obj, y3.c cVar) {
        super.c(obj, cVar);
        if (obj == n0.f٦٢٤٥a) {
            o3.a aVar = this.P;
            if (aVar != null) {
                H(aVar);
            }
            if (cVar == null) {
                this.P = null;
                return;
            }
            o3.q qVar = new o3.q(cVar);
            this.P = qVar;
            qVar.a(this);
            i(this.P);
            return;
        }
        if (obj == n0.f٦٢٤٦b) {
            o3.a aVar2 = this.R;
            if (aVar2 != null) {
                H(aVar2);
            }
            if (cVar == null) {
                this.R = null;
                return;
            }
            o3.q qVar2 = new o3.q(cVar);
            this.R = qVar2;
            qVar2.a(this);
            i(this.R);
            return;
        }
        if (obj == n0.f٦٢٦٣s) {
            o3.a aVar3 = this.T;
            if (aVar3 != null) {
                H(aVar3);
            }
            if (cVar == null) {
                this.T = null;
                return;
            }
            o3.q qVar3 = new o3.q(cVar);
            this.T = qVar3;
            qVar3.a(this);
            i(this.T);
            return;
        }
        if (obj == n0.f٦٢٦٤t) {
            o3.a aVar4 = this.V;
            if (aVar4 != null) {
                H(aVar4);
            }
            if (cVar == null) {
                this.V = null;
                return;
            }
            o3.q qVar4 = new o3.q(cVar);
            this.V = qVar4;
            qVar4.a(this);
            i(this.V);
            return;
        }
        if (obj == n0.F) {
            o3.a aVar5 = this.W;
            if (aVar5 != null) {
                H(aVar5);
            }
            if (cVar == null) {
                this.W = null;
                return;
            }
            o3.q qVar5 = new o3.q(cVar);
            this.W = qVar5;
            qVar5.a(this);
            i(this.W);
            return;
        }
        if (obj == n0.M) {
            o3.a aVar6 = this.X;
            if (aVar6 != null) {
                H(aVar6);
            }
            if (cVar == null) {
                this.X = null;
                return;
            }
            o3.q qVar6 = new o3.q(cVar);
            this.X = qVar6;
            qVar6.a(this);
            i(this.X);
            return;
        }
        if (obj == n0.O) {
            this.L.r(cVar);
        }
    }

    @Override // t3.b, n3.e
    public void f(RectF rectF, Matrix matrix, boolean z10) {
        super.f(rectF, matrix, z10);
        rectF.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, this.N.b().width(), this.N.b().height());
    }

    @Override // t3.b
    void t(Canvas canvas, Matrix matrix, int i10) {
        q3.b bVar = (q3.b) this.L.h();
        q3.c cVar = (q3.c) this.N.g().get(bVar.f١٧٠٨٨b);
        if (cVar == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        Q(bVar, i10);
        if (this.M.j1()) {
            Y(bVar, matrix, cVar, canvas);
        } else {
            X(bVar, cVar, canvas);
        }
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private String f١٨٠٢٢a;

        /* renamed from: b, reason: collision with root package name */
        private float f١٨٠٢٣b;

        private d() {
            this.f١٨٠٢٢a = "";
            this.f١٨٠٢٣b = DownloadProgress.UNKNOWN_PROGRESS;
        }

        void c(String str, float f10) {
            this.f١٨٠٢٢a = str;
            this.f١٨٠٢٣b = f10;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }
}
