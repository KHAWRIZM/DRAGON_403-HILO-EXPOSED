package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import c2.j;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c {

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f٢٤٠٥h = {0, 4, 8};

    /* renamed from: i, reason: collision with root package name */
    private static SparseIntArray f٢٤٠٦i = new SparseIntArray();

    /* renamed from: j, reason: collision with root package name */
    private static SparseIntArray f٢٤٠٧j = new SparseIntArray();

    /* renamed from: a, reason: collision with root package name */
    private boolean f٢٤٠٨a;

    /* renamed from: b, reason: collision with root package name */
    public String f٢٤٠٩b;

    /* renamed from: c, reason: collision with root package name */
    public String f٢٤١٠c = "";

    /* renamed from: d, reason: collision with root package name */
    public int f٢٤١١d = 0;

    /* renamed from: e, reason: collision with root package name */
    private HashMap f٢٤١٢e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private boolean f٢٤١٣f = true;

    /* renamed from: g, reason: collision with root package name */
    private HashMap f٢٤١٤g = new HashMap();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f٢٤١٥a;

        /* renamed from: b, reason: collision with root package name */
        String f٢٤١٦b;

        /* renamed from: c, reason: collision with root package name */
        public final d f٢٤١٧c = new d();

        /* renamed from: d, reason: collision with root package name */
        public final C٠٠١٩c f٢٤١٨d = new C٠٠١٩c();

        /* renamed from: e, reason: collision with root package name */
        public final b f٢٤١٩e = new b();

        /* renamed from: f, reason: collision with root package name */
        public final e f٢٤٢٠f = new e();

        /* renamed from: g, reason: collision with root package name */
        public HashMap f٢٤٢١g = new HashMap();

        /* renamed from: h, reason: collision with root package name */
        C٠٠١٨a f٢٤٢٢h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: androidx.constraintlayout.widget.c$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public static class C٠٠١٨a {

            /* renamed from: a, reason: collision with root package name */
            int[] f٢٤٢٣a = new int[10];

            /* renamed from: b, reason: collision with root package name */
            int[] f٢٤٢٤b = new int[10];

            /* renamed from: c, reason: collision with root package name */
            int f٢٤٢٥c = 0;

            /* renamed from: d, reason: collision with root package name */
            int[] f٢٤٢٦d = new int[10];

            /* renamed from: e, reason: collision with root package name */
            float[] f٢٤٢٧e = new float[10];

            /* renamed from: f, reason: collision with root package name */
            int f٢٤٢٨f = 0;

            /* renamed from: g, reason: collision with root package name */
            int[] f٢٤٢٩g = new int[5];

            /* renamed from: h, reason: collision with root package name */
            String[] f٢٤٣٠h = new String[5];

            /* renamed from: i, reason: collision with root package name */
            int f٢٤٣١i = 0;

            /* renamed from: j, reason: collision with root package name */
            int[] f٢٤٣٢j = new int[4];

            /* renamed from: k, reason: collision with root package name */
            boolean[] f٢٤٣٣k = new boolean[4];

            /* renamed from: l, reason: collision with root package name */
            int f٢٤٣٤l = 0;

            C٠٠١٨a() {
            }

            void a(int i10, float f10) {
                int i11 = this.f٢٤٢٨f;
                int[] iArr = this.f٢٤٢٦d;
                if (i11 >= iArr.length) {
                    this.f٢٤٢٦d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f٢٤٢٧e;
                    this.f٢٤٢٧e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f٢٤٢٦d;
                int i12 = this.f٢٤٢٨f;
                iArr2[i12] = i10;
                float[] fArr2 = this.f٢٤٢٧e;
                this.f٢٤٢٨f = i12 + 1;
                fArr2[i12] = f10;
            }

            void b(int i10, int i11) {
                int i12 = this.f٢٤٢٥c;
                int[] iArr = this.f٢٤٢٣a;
                if (i12 >= iArr.length) {
                    this.f٢٤٢٣a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f٢٤٢٤b;
                    this.f٢٤٢٤b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f٢٤٢٣a;
                int i13 = this.f٢٤٢٥c;
                iArr3[i13] = i10;
                int[] iArr4 = this.f٢٤٢٤b;
                this.f٢٤٢٥c = i13 + 1;
                iArr4[i13] = i11;
            }

            void c(int i10, String str) {
                int i11 = this.f٢٤٣١i;
                int[] iArr = this.f٢٤٢٩g;
                if (i11 >= iArr.length) {
                    this.f٢٤٢٩g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f٢٤٣٠h;
                    this.f٢٤٣٠h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f٢٤٢٩g;
                int i12 = this.f٢٤٣١i;
                iArr2[i12] = i10;
                String[] strArr2 = this.f٢٤٣٠h;
                this.f٢٤٣١i = i12 + 1;
                strArr2[i12] = str;
            }

            void d(int i10, boolean z10) {
                int i11 = this.f٢٤٣٤l;
                int[] iArr = this.f٢٤٣٢j;
                if (i11 >= iArr.length) {
                    this.f٢٤٣٢j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f٢٤٣٣k;
                    this.f٢٤٣٣k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f٢٤٣٢j;
                int i12 = this.f٢٤٣٤l;
                iArr2[i12] = i10;
                boolean[] zArr2 = this.f٢٤٣٣k;
                this.f٢٤٣٤l = i12 + 1;
                zArr2[i12] = z10;
            }

            void e(a aVar) {
                for (int i10 = 0; i10 < this.f٢٤٢٥c; i10++) {
                    c.O(aVar, this.f٢٤٢٣a[i10], this.f٢٤٢٤b[i10]);
                }
                for (int i11 = 0; i11 < this.f٢٤٢٨f; i11++) {
                    c.N(aVar, this.f٢٤٢٦d[i11], this.f٢٤٢٧e[i11]);
                }
                for (int i12 = 0; i12 < this.f٢٤٣١i; i12++) {
                    c.P(aVar, this.f٢٤٢٩g[i12], this.f٢٤٣٠h[i12]);
                }
                for (int i13 = 0; i13 < this.f٢٤٣٤l; i13++) {
                    c.Q(aVar, this.f٢٤٣٢j[i13], this.f٢٤٣٣k[i13]);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(int i10, ConstraintLayout.b bVar) {
            this.f٢٤١٥a = i10;
            b bVar2 = this.f٢٤١٩e;
            bVar2.f٢٤٥٥j = bVar.f٢٣٠٧e;
            bVar2.f٢٤٥٧k = bVar.f٢٣٠٩f;
            bVar2.f٢٤٥٩l = bVar.f٢٣١١g;
            bVar2.f٢٤٦١m = bVar.f٢٣١٣h;
            bVar2.f٢٤٦٣n = bVar.f٢٣١٥i;
            bVar2.f٢٤٦٥o = bVar.f٢٣١٧j;
            bVar2.f٢٤٦٧p = bVar.f٢٣١٩k;
            bVar2.f٢٤٦٩q = bVar.f٢٣٢١l;
            bVar2.f٢٤٧١r = bVar.f٢٣٢٣m;
            bVar2.f٢٤٧٢s = bVar.f٢٣٢٥n;
            bVar2.f٢٤٧٣t = bVar.f٢٣٢٧o;
            bVar2.f٢٤٧٤u = bVar.f٢٣٣٥s;
            bVar2.f٢٤٧٥v = bVar.f٢٣٣٧t;
            bVar2.f٢٤٧٦w = bVar.f٢٣٣٩u;
            bVar2.f٢٤٧٧x = bVar.f٢٣٤١v;
            bVar2.f٢٤٧٨y = bVar.G;
            bVar2.f٢٤٧٩z = bVar.H;
            bVar2.A = bVar.I;
            bVar2.f٢٤٣٦B = bVar.f٢٣٢٩p;
            bVar2.C = bVar.f٢٣٣١q;
            bVar2.D = bVar.f٢٣٣٣r;
            bVar2.E = bVar.X;
            bVar2.F = bVar.Y;
            bVar2.G = bVar.Z;
            bVar2.f٢٤٥١h = bVar.f٢٣٠٣c;
            bVar2.f٢٤٤٧f = bVar.f٢٢٩٩a;
            bVar2.f٢٤٤٩g = bVar.f٢٣٠١b;
            bVar2.f٢٤٤٣d = ((ViewGroup.MarginLayoutParams) bVar).width;
            bVar2.f٢٤٤٥e = ((ViewGroup.MarginLayoutParams) bVar).height;
            bVar2.H = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            bVar2.I = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            bVar2.J = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            bVar2.K = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            bVar2.N = bVar.D;
            bVar2.V = bVar.M;
            bVar2.W = bVar.L;
            bVar2.Y = bVar.O;
            bVar2.X = bVar.N;
            bVar2.f٢٤٦٤n0 = bVar.f٢٣٠٠a0;
            bVar2.f٢٤٦٦o0 = bVar.f٢٣٠٢b0;
            bVar2.Z = bVar.P;
            bVar2.f٢٤٣٨a0 = bVar.Q;
            bVar2.f٢٤٤٠b0 = bVar.T;
            bVar2.f٢٤٤٢c0 = bVar.U;
            bVar2.f٢٤٤٤d0 = bVar.R;
            bVar2.f٢٤٤٦e0 = bVar.S;
            bVar2.f٢٤٤٨f0 = bVar.V;
            bVar2.f٢٤٥٠g0 = bVar.W;
            bVar2.f٢٤٦٢m0 = bVar.f٢٣٠٤c0;
            bVar2.P = bVar.f٢٣٤٥x;
            bVar2.R = bVar.f٢٣٤٧z;
            bVar2.O = bVar.f٢٣٤٣w;
            bVar2.Q = bVar.f٢٣٤٦y;
            bVar2.T = bVar.A;
            bVar2.S = bVar.f٢٢٩٨B;
            bVar2.U = bVar.C;
            bVar2.f٢٤٧٠q0 = bVar.f٢٣٠٦d0;
            bVar2.L = bVar.getMarginEnd();
            this.f٢٤١٩e.M = bVar.getMarginStart();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(int i10, Constraints.a aVar) {
            g(i10, aVar);
            this.f٢٤١٧c.f٢٤٩٨d = aVar.f٢٣٥٨x0;
            e eVar = this.f٢٤٢٠f;
            eVar.f٢٥٠٢b = aVar.A0;
            eVar.f٢٥٠٣c = aVar.B0;
            eVar.f٢٥٠٤d = aVar.C0;
            eVar.f٢٥٠٥e = aVar.D0;
            eVar.f٢٥٠٦f = aVar.E0;
            eVar.f٢٥٠٧g = aVar.F0;
            eVar.f٢٥٠٨h = aVar.G0;
            eVar.f٢٥١٠j = aVar.H0;
            eVar.f٢٥١١k = aVar.I0;
            eVar.f٢٥١٢l = aVar.J0;
            eVar.f٢٥١٤n = aVar.f٢٣٦٠z0;
            eVar.f٢٥١٣m = aVar.f٢٣٥٩y0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(ConstraintHelper constraintHelper, int i10, Constraints.a aVar) {
            h(i10, aVar);
            if (constraintHelper instanceof Barrier) {
                b bVar = this.f٢٤١٩e;
                bVar.f٢٤٥٦j0 = 1;
                Barrier barrier = (Barrier) constraintHelper;
                bVar.f٢٤٥٢h0 = barrier.getType();
                this.f٢٤١٩e.f٢٤٥٨k0 = barrier.getReferencedIds();
                this.f٢٤١٩e.f٢٤٥٤i0 = barrier.getMargin();
            }
        }

        public void d(a aVar) {
            C٠٠١٨a r02 = this.f٢٤٢٢h;
            if (r02 != null) {
                r02.e(aVar);
            }
        }

        public void e(ConstraintLayout.b bVar) {
            b bVar2 = this.f٢٤١٩e;
            bVar.f٢٣٠٧e = bVar2.f٢٤٥٥j;
            bVar.f٢٣٠٩f = bVar2.f٢٤٥٧k;
            bVar.f٢٣١١g = bVar2.f٢٤٥٩l;
            bVar.f٢٣١٣h = bVar2.f٢٤٦١m;
            bVar.f٢٣١٥i = bVar2.f٢٤٦٣n;
            bVar.f٢٣١٧j = bVar2.f٢٤٦٥o;
            bVar.f٢٣١٩k = bVar2.f٢٤٦٧p;
            bVar.f٢٣٢١l = bVar2.f٢٤٦٩q;
            bVar.f٢٣٢٣m = bVar2.f٢٤٧١r;
            bVar.f٢٣٢٥n = bVar2.f٢٤٧٢s;
            bVar.f٢٣٢٧o = bVar2.f٢٤٧٣t;
            bVar.f٢٣٣٥s = bVar2.f٢٤٧٤u;
            bVar.f٢٣٣٧t = bVar2.f٢٤٧٥v;
            bVar.f٢٣٣٩u = bVar2.f٢٤٧٦w;
            bVar.f٢٣٤١v = bVar2.f٢٤٧٧x;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = bVar2.H;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = bVar2.I;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = bVar2.J;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = bVar2.K;
            bVar.A = bVar2.T;
            bVar.f٢٢٩٨B = bVar2.S;
            bVar.f٢٣٤٥x = bVar2.P;
            bVar.f٢٣٤٧z = bVar2.R;
            bVar.G = bVar2.f٢٤٧٨y;
            bVar.H = bVar2.f٢٤٧٩z;
            bVar.f٢٣٢٩p = bVar2.f٢٤٣٦B;
            bVar.f٢٣٣١q = bVar2.C;
            bVar.f٢٣٣٣r = bVar2.D;
            bVar.I = bVar2.A;
            bVar.X = bVar2.E;
            bVar.Y = bVar2.F;
            bVar.M = bVar2.V;
            bVar.L = bVar2.W;
            bVar.O = bVar2.Y;
            bVar.N = bVar2.X;
            bVar.f٢٣٠٠a0 = bVar2.f٢٤٦٤n0;
            bVar.f٢٣٠٢b0 = bVar2.f٢٤٦٦o0;
            bVar.P = bVar2.Z;
            bVar.Q = bVar2.f٢٤٣٨a0;
            bVar.T = bVar2.f٢٤٤٠b0;
            bVar.U = bVar2.f٢٤٤٢c0;
            bVar.R = bVar2.f٢٤٤٤d0;
            bVar.S = bVar2.f٢٤٤٦e0;
            bVar.V = bVar2.f٢٤٤٨f0;
            bVar.W = bVar2.f٢٤٥٠g0;
            bVar.Z = bVar2.G;
            bVar.f٢٣٠٣c = bVar2.f٢٤٥١h;
            bVar.f٢٢٩٩a = bVar2.f٢٤٤٧f;
            bVar.f٢٣٠١b = bVar2.f٢٤٤٩g;
            ((ViewGroup.MarginLayoutParams) bVar).width = bVar2.f٢٤٤٣d;
            ((ViewGroup.MarginLayoutParams) bVar).height = bVar2.f٢٤٤٥e;
            String str = bVar2.f٢٤٦٢m0;
            if (str != null) {
                bVar.f٢٣٠٤c0 = str;
            }
            bVar.f٢٣٠٦d0 = bVar2.f٢٤٧٠q0;
            bVar.setMarginStart(bVar2.M);
            bVar.setMarginEnd(this.f٢٤١٩e.L);
            bVar.c();
        }

        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.f٢٤١٩e.a(this.f٢٤١٩e);
            aVar.f٢٤١٨d.a(this.f٢٤١٨d);
            aVar.f٢٤١٧c.a(this.f٢٤١٧c);
            aVar.f٢٤٢٠f.a(this.f٢٤٢٠f);
            aVar.f٢٤١٥a = this.f٢٤١٥a;
            aVar.f٢٤٢٢h = this.f٢٤٢٢h;
            return aVar;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b {

        /* renamed from: r0, reason: collision with root package name */
        private static SparseIntArray f٢٤٣٥r0;

        /* renamed from: d, reason: collision with root package name */
        public int f٢٤٤٣d;

        /* renamed from: e, reason: collision with root package name */
        public int f٢٤٤٥e;

        /* renamed from: k0, reason: collision with root package name */
        public int[] f٢٤٥٨k0;

        /* renamed from: l0, reason: collision with root package name */
        public String f٢٤٦٠l0;

        /* renamed from: m0, reason: collision with root package name */
        public String f٢٤٦٢m0;

        /* renamed from: a, reason: collision with root package name */
        public boolean f٢٤٣٧a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f٢٤٣٩b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f٢٤٤١c = false;

        /* renamed from: f, reason: collision with root package name */
        public int f٢٤٤٧f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f٢٤٤٩g = -1;

        /* renamed from: h, reason: collision with root package name */
        public float f٢٤٥١h = -1.0f;

        /* renamed from: i, reason: collision with root package name */
        public boolean f٢٤٥٣i = true;

        /* renamed from: j, reason: collision with root package name */
        public int f٢٤٥٥j = -1;

        /* renamed from: k, reason: collision with root package name */
        public int f٢٤٥٧k = -1;

        /* renamed from: l, reason: collision with root package name */
        public int f٢٤٥٩l = -1;

        /* renamed from: m, reason: collision with root package name */
        public int f٢٤٦١m = -1;

        /* renamed from: n, reason: collision with root package name */
        public int f٢٤٦٣n = -1;

        /* renamed from: o, reason: collision with root package name */
        public int f٢٤٦٥o = -1;

        /* renamed from: p, reason: collision with root package name */
        public int f٢٤٦٧p = -1;

        /* renamed from: q, reason: collision with root package name */
        public int f٢٤٦٩q = -1;

        /* renamed from: r, reason: collision with root package name */
        public int f٢٤٧١r = -1;

        /* renamed from: s, reason: collision with root package name */
        public int f٢٤٧٢s = -1;

        /* renamed from: t, reason: collision with root package name */
        public int f٢٤٧٣t = -1;

        /* renamed from: u, reason: collision with root package name */
        public int f٢٤٧٤u = -1;

        /* renamed from: v, reason: collision with root package name */
        public int f٢٤٧٥v = -1;

        /* renamed from: w, reason: collision with root package name */
        public int f٢٤٧٦w = -1;

        /* renamed from: x, reason: collision with root package name */
        public int f٢٤٧٧x = -1;

        /* renamed from: y, reason: collision with root package name */
        public float f٢٤٧٨y = 0.5f;

        /* renamed from: z, reason: collision with root package name */
        public float f٢٤٧٩z = 0.5f;
        public String A = null;

        /* renamed from: B, reason: collision with root package name */
        public int f٢٤٣٦B = -1;
        public int C = 0;
        public float D = DownloadProgress.UNKNOWN_PROGRESS;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public int T = Integer.MIN_VALUE;
        public int U = Integer.MIN_VALUE;
        public float V = -1.0f;
        public float W = -1.0f;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;

        /* renamed from: a0, reason: collision with root package name */
        public int f٢٤٣٨a0 = 0;

        /* renamed from: b0, reason: collision with root package name */
        public int f٢٤٤٠b0 = 0;

        /* renamed from: c0, reason: collision with root package name */
        public int f٢٤٤٢c0 = 0;

        /* renamed from: d0, reason: collision with root package name */
        public int f٢٤٤٤d0 = 0;

        /* renamed from: e0, reason: collision with root package name */
        public int f٢٤٤٦e0 = 0;

        /* renamed from: f0, reason: collision with root package name */
        public float f٢٤٤٨f0 = 1.0f;

        /* renamed from: g0, reason: collision with root package name */
        public float f٢٤٥٠g0 = 1.0f;

        /* renamed from: h0, reason: collision with root package name */
        public int f٢٤٥٢h0 = -1;

        /* renamed from: i0, reason: collision with root package name */
        public int f٢٤٥٤i0 = 0;

        /* renamed from: j0, reason: collision with root package name */
        public int f٢٤٥٦j0 = -1;

        /* renamed from: n0, reason: collision with root package name */
        public boolean f٢٤٦٤n0 = false;

        /* renamed from: o0, reason: collision with root package name */
        public boolean f٢٤٦٦o0 = false;

        /* renamed from: p0, reason: collision with root package name */
        public boolean f٢٤٦٨p0 = true;

        /* renamed from: q0, reason: collision with root package name */
        public int f٢٤٧٠q0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f٢٤٣٥r0 = sparseIntArray;
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            f٢٤٣٥r0.append(R.styleable.Layout_guidelineUseRtl, 90);
            f٢٤٣٥r0.append(R.styleable.Layout_android_orientation, 26);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_goneMarginTop, 16);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_goneMarginRight, 14);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_goneMarginStart, 15);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintLeft_creator, 91);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintTop_creator, 91);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintRight_creator, 91);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintBottom_creator, 91);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintBaseline_creator, 91);
            f٢٤٣٥r0.append(R.styleable.Layout_android_layout_marginLeft, 23);
            f٢٤٣٥r0.append(R.styleable.Layout_android_layout_marginRight, 27);
            f٢٤٣٥r0.append(R.styleable.Layout_android_layout_marginStart, 30);
            f٢٤٣٥r0.append(R.styleable.Layout_android_layout_marginEnd, 8);
            f٢٤٣٥r0.append(R.styleable.Layout_android_layout_marginTop, 33);
            f٢٤٣٥r0.append(R.styleable.Layout_android_layout_marginBottom, 2);
            f٢٤٣٥r0.append(R.styleable.Layout_android_layout_width, 22);
            f٢٤٣٥r0.append(R.styleable.Layout_android_layout_height, 21);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintWidth, 41);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintHeight, 42);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constrainedWidth, 41);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constrainedHeight, 42);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_wrapBehaviorInParent, 76);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintCircle, 61);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            f٢٤٣٥r0.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            f٢٤٣٥r0.append(R.styleable.Layout_chainUseRtl, 71);
            f٢٤٣٥r0.append(R.styleable.Layout_barrierDirection, 72);
            f٢٤٣٥r0.append(R.styleable.Layout_barrierMargin, 73);
            f٢٤٣٥r0.append(R.styleable.Layout_constraint_referenced_ids, 74);
            f٢٤٣٥r0.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void a(b bVar) {
            this.f٢٤٣٧a = bVar.f٢٤٣٧a;
            this.f٢٤٤٣d = bVar.f٢٤٤٣d;
            this.f٢٤٣٩b = bVar.f٢٤٣٩b;
            this.f٢٤٤٥e = bVar.f٢٤٤٥e;
            this.f٢٤٤٧f = bVar.f٢٤٤٧f;
            this.f٢٤٤٩g = bVar.f٢٤٤٩g;
            this.f٢٤٥١h = bVar.f٢٤٥١h;
            this.f٢٤٥٣i = bVar.f٢٤٥٣i;
            this.f٢٤٥٥j = bVar.f٢٤٥٥j;
            this.f٢٤٥٧k = bVar.f٢٤٥٧k;
            this.f٢٤٥٩l = bVar.f٢٤٥٩l;
            this.f٢٤٦١m = bVar.f٢٤٦١m;
            this.f٢٤٦٣n = bVar.f٢٤٦٣n;
            this.f٢٤٦٥o = bVar.f٢٤٦٥o;
            this.f٢٤٦٧p = bVar.f٢٤٦٧p;
            this.f٢٤٦٩q = bVar.f٢٤٦٩q;
            this.f٢٤٧١r = bVar.f٢٤٧١r;
            this.f٢٤٧٢s = bVar.f٢٤٧٢s;
            this.f٢٤٧٣t = bVar.f٢٤٧٣t;
            this.f٢٤٧٤u = bVar.f٢٤٧٤u;
            this.f٢٤٧٥v = bVar.f٢٤٧٥v;
            this.f٢٤٧٦w = bVar.f٢٤٧٦w;
            this.f٢٤٧٧x = bVar.f٢٤٧٧x;
            this.f٢٤٧٨y = bVar.f٢٤٧٨y;
            this.f٢٤٧٩z = bVar.f٢٤٧٩z;
            this.A = bVar.A;
            this.f٢٤٣٦B = bVar.f٢٤٣٦B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            this.H = bVar.H;
            this.I = bVar.I;
            this.J = bVar.J;
            this.K = bVar.K;
            this.L = bVar.L;
            this.M = bVar.M;
            this.N = bVar.N;
            this.O = bVar.O;
            this.P = bVar.P;
            this.Q = bVar.Q;
            this.R = bVar.R;
            this.S = bVar.S;
            this.T = bVar.T;
            this.U = bVar.U;
            this.V = bVar.V;
            this.W = bVar.W;
            this.X = bVar.X;
            this.Y = bVar.Y;
            this.Z = bVar.Z;
            this.f٢٤٣٨a0 = bVar.f٢٤٣٨a0;
            this.f٢٤٤٠b0 = bVar.f٢٤٤٠b0;
            this.f٢٤٤٢c0 = bVar.f٢٤٤٢c0;
            this.f٢٤٤٤d0 = bVar.f٢٤٤٤d0;
            this.f٢٤٤٦e0 = bVar.f٢٤٤٦e0;
            this.f٢٤٤٨f0 = bVar.f٢٤٤٨f0;
            this.f٢٤٥٠g0 = bVar.f٢٤٥٠g0;
            this.f٢٤٥٢h0 = bVar.f٢٤٥٢h0;
            this.f٢٤٥٤i0 = bVar.f٢٤٥٤i0;
            this.f٢٤٥٦j0 = bVar.f٢٤٥٦j0;
            this.f٢٤٦٢m0 = bVar.f٢٤٦٢m0;
            int[] iArr = bVar.f٢٤٥٨k0;
            if (iArr != null && bVar.f٢٤٦٠l0 == null) {
                this.f٢٤٥٨k0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.f٢٤٥٨k0 = null;
            }
            this.f٢٤٦٠l0 = bVar.f٢٤٦٠l0;
            this.f٢٤٦٤n0 = bVar.f٢٤٦٤n0;
            this.f٢٤٦٦o0 = bVar.f٢٤٦٦o0;
            this.f٢٤٦٨p0 = bVar.f٢٤٦٨p0;
            this.f٢٤٧٠q0 = bVar.f٢٤٧٠q0;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Layout);
            this.f٢٤٣٩b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                int i11 = f٢٤٣٥r0.get(index);
                switch (i11) {
                    case 1:
                        this.f٢٤٧١r = c.F(obtainStyledAttributes, index, this.f٢٤٧١r);
                        break;
                    case 2:
                        this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case 3:
                        this.f٢٤٦٩q = c.F(obtainStyledAttributes, index, this.f٢٤٦٩q);
                        break;
                    case 4:
                        this.f٢٤٦٧p = c.F(obtainStyledAttributes, index, this.f٢٤٦٧p);
                        break;
                    case 5:
                        this.A = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.E = obtainStyledAttributes.getDimensionPixelOffset(index, this.E);
                        break;
                    case 7:
                        this.F = obtainStyledAttributes.getDimensionPixelOffset(index, this.F);
                        break;
                    case 8:
                        this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        break;
                    case 9:
                        this.f٢٤٧٧x = c.F(obtainStyledAttributes, index, this.f٢٤٧٧x);
                        break;
                    case 10:
                        this.f٢٤٧٦w = c.F(obtainStyledAttributes, index, this.f٢٤٧٦w);
                        break;
                    case 11:
                        this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 12:
                        this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        break;
                    case 13:
                        this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 14:
                        this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 15:
                        this.T = obtainStyledAttributes.getDimensionPixelSize(index, this.T);
                        break;
                    case 16:
                        this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case 17:
                        this.f٢٤٤٧f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f٢٤٤٧f);
                        break;
                    case 18:
                        this.f٢٤٤٩g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f٢٤٤٩g);
                        break;
                    case 19:
                        this.f٢٤٥١h = obtainStyledAttributes.getFloat(index, this.f٢٤٥١h);
                        break;
                    case 20:
                        this.f٢٤٧٨y = obtainStyledAttributes.getFloat(index, this.f٢٤٧٨y);
                        break;
                    case 21:
                        this.f٢٤٤٥e = obtainStyledAttributes.getLayoutDimension(index, this.f٢٤٤٥e);
                        break;
                    case 22:
                        this.f٢٤٤٣d = obtainStyledAttributes.getLayoutDimension(index, this.f٢٤٤٣d);
                        break;
                    case 23:
                        this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 24:
                        this.f٢٤٥٥j = c.F(obtainStyledAttributes, index, this.f٢٤٥٥j);
                        break;
                    case 25:
                        this.f٢٤٥٧k = c.F(obtainStyledAttributes, index, this.f٢٤٥٧k);
                        break;
                    case 26:
                        this.G = obtainStyledAttributes.getInt(index, this.G);
                        break;
                    case 27:
                        this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 28:
                        this.f٢٤٥٩l = c.F(obtainStyledAttributes, index, this.f٢٤٥٩l);
                        break;
                    case 29:
                        this.f٢٤٦١m = c.F(obtainStyledAttributes, index, this.f٢٤٦١m);
                        break;
                    case 30:
                        this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case 31:
                        this.f٢٤٧٤u = c.F(obtainStyledAttributes, index, this.f٢٤٧٤u);
                        break;
                    case 32:
                        this.f٢٤٧٥v = c.F(obtainStyledAttributes, index, this.f٢٤٧٥v);
                        break;
                    case 33:
                        this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 34:
                        this.f٢٤٦٥o = c.F(obtainStyledAttributes, index, this.f٢٤٦٥o);
                        break;
                    case 35:
                        this.f٢٤٦٣n = c.F(obtainStyledAttributes, index, this.f٢٤٦٣n);
                        break;
                    case 36:
                        this.f٢٤٧٩z = obtainStyledAttributes.getFloat(index, this.f٢٤٧٩z);
                        break;
                    case 37:
                        this.W = obtainStyledAttributes.getFloat(index, this.W);
                        break;
                    case 38:
                        this.V = obtainStyledAttributes.getFloat(index, this.V);
                        break;
                    case 39:
                        this.X = obtainStyledAttributes.getInt(index, this.X);
                        break;
                    case 40:
                        this.Y = obtainStyledAttributes.getInt(index, this.Y);
                        break;
                    case 41:
                        c.G(this, obtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        c.G(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i11) {
                            case 61:
                                this.f٢٤٣٦B = c.F(obtainStyledAttributes, index, this.f٢٤٣٦B);
                                break;
                            case 62:
                                this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            case 63:
                                this.D = obtainStyledAttributes.getFloat(index, this.D);
                                break;
                            default:
                                switch (i11) {
                                    case 69:
                                        this.f٢٤٤٨f0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.f٢٤٥٠g0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.f٢٤٥٢h0 = obtainStyledAttributes.getInt(index, this.f٢٤٥٢h0);
                                        break;
                                    case 73:
                                        this.f٢٤٥٤i0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f٢٤٥٤i0);
                                        break;
                                    case 74:
                                        this.f٢٤٦٠l0 = obtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.f٢٤٦٨p0 = obtainStyledAttributes.getBoolean(index, this.f٢٤٦٨p0);
                                        break;
                                    case 76:
                                        this.f٢٤٧٠q0 = obtainStyledAttributes.getInt(index, this.f٢٤٧٠q0);
                                        break;
                                    case 77:
                                        this.f٢٤٧٢s = c.F(obtainStyledAttributes, index, this.f٢٤٧٢s);
                                        break;
                                    case 78:
                                        this.f٢٤٧٣t = c.F(obtainStyledAttributes, index, this.f٢٤٧٣t);
                                        break;
                                    case 79:
                                        this.U = obtainStyledAttributes.getDimensionPixelSize(index, this.U);
                                        break;
                                    case 80:
                                        this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                                        break;
                                    case 81:
                                        this.Z = obtainStyledAttributes.getInt(index, this.Z);
                                        break;
                                    case 82:
                                        this.f٢٤٣٨a0 = obtainStyledAttributes.getInt(index, this.f٢٤٣٨a0);
                                        break;
                                    case 83:
                                        this.f٢٤٤٢c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f٢٤٤٢c0);
                                        break;
                                    case 84:
                                        this.f٢٤٤٠b0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f٢٤٤٠b0);
                                        break;
                                    case 85:
                                        this.f٢٤٤٦e0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f٢٤٤٦e0);
                                        break;
                                    case 86:
                                        this.f٢٤٤٤d0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f٢٤٤٤d0);
                                        break;
                                    case 87:
                                        this.f٢٤٦٤n0 = obtainStyledAttributes.getBoolean(index, this.f٢٤٦٤n0);
                                        break;
                                    case 88:
                                        this.f٢٤٦٦o0 = obtainStyledAttributes.getBoolean(index, this.f٢٤٦٦o0);
                                        break;
                                    case 89:
                                        this.f٢٤٦٢m0 = obtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.f٢٤٥٣i = obtainStyledAttributes.getBoolean(index, this.f٢٤٥٣i);
                                        break;
                                    case 91:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f٢٤٣٥r0.get(index));
                                        break;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f٢٤٣٥r0.get(index));
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.constraintlayout.widget.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class C٠٠١٩c {

        /* renamed from: o, reason: collision with root package name */
        private static SparseIntArray f٢٤٨٠o;

        /* renamed from: a, reason: collision with root package name */
        public boolean f٢٤٨١a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f٢٤٨٢b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f٢٤٨٣c = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f٢٤٨٤d = null;

        /* renamed from: e, reason: collision with root package name */
        public int f٢٤٨٥e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f٢٤٨٦f = 0;

        /* renamed from: g, reason: collision with root package name */
        public float f٢٤٨٧g = Float.NaN;

        /* renamed from: h, reason: collision with root package name */
        public int f٢٤٨٨h = -1;

        /* renamed from: i, reason: collision with root package name */
        public float f٢٤٨٩i = Float.NaN;

        /* renamed from: j, reason: collision with root package name */
        public float f٢٤٩٠j = Float.NaN;

        /* renamed from: k, reason: collision with root package name */
        public int f٢٤٩١k = -1;

        /* renamed from: l, reason: collision with root package name */
        public String f٢٤٩٢l = null;

        /* renamed from: m, reason: collision with root package name */
        public int f٢٤٩٣m = -3;

        /* renamed from: n, reason: collision with root package name */
        public int f٢٤٩٤n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f٢٤٨٠o = sparseIntArray;
            sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
            f٢٤٨٠o.append(R.styleable.Motion_pathMotionArc, 2);
            f٢٤٨٠o.append(R.styleable.Motion_transitionEasing, 3);
            f٢٤٨٠o.append(R.styleable.Motion_drawPath, 4);
            f٢٤٨٠o.append(R.styleable.Motion_animateRelativeTo, 5);
            f٢٤٨٠o.append(R.styleable.Motion_animateCircleAngleTo, 6);
            f٢٤٨٠o.append(R.styleable.Motion_motionStagger, 7);
            f٢٤٨٠o.append(R.styleable.Motion_quantizeMotionSteps, 8);
            f٢٤٨٠o.append(R.styleable.Motion_quantizeMotionPhase, 9);
            f٢٤٨٠o.append(R.styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public void a(C٠٠١٩c r22) {
            this.f٢٤٨١a = r22.f٢٤٨١a;
            this.f٢٤٨٢b = r22.f٢٤٨٢b;
            this.f٢٤٨٤d = r22.f٢٤٨٤d;
            this.f٢٤٨٥e = r22.f٢٤٨٥e;
            this.f٢٤٨٦f = r22.f٢٤٨٦f;
            this.f٢٤٨٩i = r22.f٢٤٨٩i;
            this.f٢٤٨٧g = r22.f٢٤٨٧g;
            this.f٢٤٨٨h = r22.f٢٤٨٨h;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Motion);
            this.f٢٤٨١a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                switch (f٢٤٨٠o.get(index)) {
                    case 1:
                        this.f٢٤٨٩i = obtainStyledAttributes.getFloat(index, this.f٢٤٨٩i);
                        break;
                    case 2:
                        this.f٢٤٨٥e = obtainStyledAttributes.getInt(index, this.f٢٤٨٥e);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.f٢٤٨٤d = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.f٢٤٨٤d = a2.c.f١٢١c[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.f٢٤٨٦f = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f٢٤٨٢b = c.F(obtainStyledAttributes, index, this.f٢٤٨٢b);
                        break;
                    case 6:
                        this.f٢٤٨٣c = obtainStyledAttributes.getInteger(index, this.f٢٤٨٣c);
                        break;
                    case 7:
                        this.f٢٤٨٧g = obtainStyledAttributes.getFloat(index, this.f٢٤٨٧g);
                        break;
                    case 8:
                        this.f٢٤٩١k = obtainStyledAttributes.getInteger(index, this.f٢٤٩١k);
                        break;
                    case 9:
                        this.f٢٤٩٠j = obtainStyledAttributes.getFloat(index, this.f٢٤٩٠j);
                        break;
                    case 10:
                        int i11 = obtainStyledAttributes.peekValue(index).type;
                        if (i11 == 1) {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.f٢٤٩٤n = resourceId;
                            if (resourceId != -1) {
                                this.f٢٤٩٣m = -2;
                                break;
                            } else {
                                break;
                            }
                        } else if (i11 == 3) {
                            String string = obtainStyledAttributes.getString(index);
                            this.f٢٤٩٢l = string;
                            if (string.indexOf("/") > 0) {
                                this.f٢٤٩٤n = obtainStyledAttributes.getResourceId(index, -1);
                                this.f٢٤٩٣m = -2;
                                break;
                            } else {
                                this.f٢٤٩٣m = -1;
                                break;
                            }
                        } else {
                            this.f٢٤٩٣m = obtainStyledAttributes.getInteger(index, this.f٢٤٩٤n);
                            break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f٢٤٩٥a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f٢٤٩٦b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f٢٤٩٧c = 0;

        /* renamed from: d, reason: collision with root package name */
        public float f٢٤٩٨d = 1.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f٢٤٩٩e = Float.NaN;

        public void a(d dVar) {
            this.f٢٤٩٥a = dVar.f٢٤٩٥a;
            this.f٢٤٩٦b = dVar.f٢٤٩٦b;
            this.f٢٤٩٨d = dVar.f٢٤٩٨d;
            this.f٢٤٩٩e = dVar.f٢٤٩٩e;
            this.f٢٤٩٧c = dVar.f٢٤٩٧c;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PropertySet);
            this.f٢٤٩٥a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.PropertySet_android_alpha) {
                    this.f٢٤٩٨d = obtainStyledAttributes.getFloat(index, this.f٢٤٩٨d);
                } else if (index == R.styleable.PropertySet_android_visibility) {
                    this.f٢٤٩٦b = obtainStyledAttributes.getInt(index, this.f٢٤٩٦b);
                    this.f٢٤٩٦b = c.f٢٤٠٥h[this.f٢٤٩٦b];
                } else if (index == R.styleable.PropertySet_visibilityMode) {
                    this.f٢٤٩٧c = obtainStyledAttributes.getInt(index, this.f٢٤٩٧c);
                } else if (index == R.styleable.PropertySet_motionProgress) {
                    this.f٢٤٩٩e = obtainStyledAttributes.getFloat(index, this.f٢٤٩٩e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class e {

        /* renamed from: o, reason: collision with root package name */
        private static SparseIntArray f٢٥٠٠o;

        /* renamed from: a, reason: collision with root package name */
        public boolean f٢٥٠١a = false;

        /* renamed from: b, reason: collision with root package name */
        public float f٢٥٠٢b = DownloadProgress.UNKNOWN_PROGRESS;

        /* renamed from: c, reason: collision with root package name */
        public float f٢٥٠٣c = DownloadProgress.UNKNOWN_PROGRESS;

        /* renamed from: d, reason: collision with root package name */
        public float f٢٥٠٤d = DownloadProgress.UNKNOWN_PROGRESS;

        /* renamed from: e, reason: collision with root package name */
        public float f٢٥٠٥e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        public float f٢٥٠٦f = 1.0f;

        /* renamed from: g, reason: collision with root package name */
        public float f٢٥٠٧g = Float.NaN;

        /* renamed from: h, reason: collision with root package name */
        public float f٢٥٠٨h = Float.NaN;

        /* renamed from: i, reason: collision with root package name */
        public int f٢٥٠٩i = -1;

        /* renamed from: j, reason: collision with root package name */
        public float f٢٥١٠j = DownloadProgress.UNKNOWN_PROGRESS;

        /* renamed from: k, reason: collision with root package name */
        public float f٢٥١١k = DownloadProgress.UNKNOWN_PROGRESS;

        /* renamed from: l, reason: collision with root package name */
        public float f٢٥١٢l = DownloadProgress.UNKNOWN_PROGRESS;

        /* renamed from: m, reason: collision with root package name */
        public boolean f٢٥١٣m = false;

        /* renamed from: n, reason: collision with root package name */
        public float f٢٥١٤n = DownloadProgress.UNKNOWN_PROGRESS;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f٢٥٠٠o = sparseIntArray;
            sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
            f٢٥٠٠o.append(R.styleable.Transform_android_rotationX, 2);
            f٢٥٠٠o.append(R.styleable.Transform_android_rotationY, 3);
            f٢٥٠٠o.append(R.styleable.Transform_android_scaleX, 4);
            f٢٥٠٠o.append(R.styleable.Transform_android_scaleY, 5);
            f٢٥٠٠o.append(R.styleable.Transform_android_transformPivotX, 6);
            f٢٥٠٠o.append(R.styleable.Transform_android_transformPivotY, 7);
            f٢٥٠٠o.append(R.styleable.Transform_android_translationX, 8);
            f٢٥٠٠o.append(R.styleable.Transform_android_translationY, 9);
            f٢٥٠٠o.append(R.styleable.Transform_android_translationZ, 10);
            f٢٥٠٠o.append(R.styleable.Transform_android_elevation, 11);
            f٢٥٠٠o.append(R.styleable.Transform_transformPivotTarget, 12);
        }

        public void a(e eVar) {
            this.f٢٥٠١a = eVar.f٢٥٠١a;
            this.f٢٥٠٢b = eVar.f٢٥٠٢b;
            this.f٢٥٠٣c = eVar.f٢٥٠٣c;
            this.f٢٥٠٤d = eVar.f٢٥٠٤d;
            this.f٢٥٠٥e = eVar.f٢٥٠٥e;
            this.f٢٥٠٦f = eVar.f٢٥٠٦f;
            this.f٢٥٠٧g = eVar.f٢٥٠٧g;
            this.f٢٥٠٨h = eVar.f٢٥٠٨h;
            this.f٢٥٠٩i = eVar.f٢٥٠٩i;
            this.f٢٥١٠j = eVar.f٢٥١٠j;
            this.f٢٥١١k = eVar.f٢٥١١k;
            this.f٢٥١٢l = eVar.f٢٥١٢l;
            this.f٢٥١٣m = eVar.f٢٥١٣m;
            this.f٢٥١٤n = eVar.f٢٥١٤n;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transform);
            this.f٢٥٠١a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                switch (f٢٥٠٠o.get(index)) {
                    case 1:
                        this.f٢٥٠٢b = obtainStyledAttributes.getFloat(index, this.f٢٥٠٢b);
                        break;
                    case 2:
                        this.f٢٥٠٣c = obtainStyledAttributes.getFloat(index, this.f٢٥٠٣c);
                        break;
                    case 3:
                        this.f٢٥٠٤d = obtainStyledAttributes.getFloat(index, this.f٢٥٠٤d);
                        break;
                    case 4:
                        this.f٢٥٠٥e = obtainStyledAttributes.getFloat(index, this.f٢٥٠٥e);
                        break;
                    case 5:
                        this.f٢٥٠٦f = obtainStyledAttributes.getFloat(index, this.f٢٥٠٦f);
                        break;
                    case 6:
                        this.f٢٥٠٧g = obtainStyledAttributes.getDimension(index, this.f٢٥٠٧g);
                        break;
                    case 7:
                        this.f٢٥٠٨h = obtainStyledAttributes.getDimension(index, this.f٢٥٠٨h);
                        break;
                    case 8:
                        this.f٢٥١٠j = obtainStyledAttributes.getDimension(index, this.f٢٥١٠j);
                        break;
                    case 9:
                        this.f٢٥١١k = obtainStyledAttributes.getDimension(index, this.f٢٥١١k);
                        break;
                    case 10:
                        this.f٢٥١٢l = obtainStyledAttributes.getDimension(index, this.f٢٥١٢l);
                        break;
                    case 11:
                        this.f٢٥١٣m = true;
                        this.f٢٥١٤n = obtainStyledAttributes.getDimension(index, this.f٢٥١٤n);
                        break;
                    case 12:
                        this.f٢٥٠٩i = c.F(obtainStyledAttributes, index, this.f٢٥٠٩i);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        f٢٤٠٦i.append(R.styleable.Constraint_guidelineUseRtl, 99);
        f٢٤٠٦i.append(R.styleable.Constraint_android_orientation, 27);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintLeft_creator, 87);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintTop_creator, 87);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintRight_creator, 87);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintBottom_creator, 87);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintBaseline_creator, 87);
        f٢٤٠٦i.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        f٢٤٠٦i.append(R.styleable.Constraint_android_layout_marginRight, 28);
        f٢٤٠٦i.append(R.styleable.Constraint_android_layout_marginStart, 31);
        f٢٤٠٦i.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        f٢٤٠٦i.append(R.styleable.Constraint_android_layout_marginTop, 34);
        f٢٤٠٦i.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        f٢٤٠٦i.append(R.styleable.Constraint_android_layout_width, 23);
        f٢٤٠٦i.append(R.styleable.Constraint_android_layout_height, 21);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintWidth, 95);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintHeight, 96);
        f٢٤٠٦i.append(R.styleable.Constraint_android_visibility, 22);
        f٢٤٠٦i.append(R.styleable.Constraint_android_alpha, 43);
        f٢٤٠٦i.append(R.styleable.Constraint_android_elevation, 44);
        f٢٤٠٦i.append(R.styleable.Constraint_android_rotationX, 45);
        f٢٤٠٦i.append(R.styleable.Constraint_android_rotationY, 46);
        f٢٤٠٦i.append(R.styleable.Constraint_android_rotation, 60);
        f٢٤٠٦i.append(R.styleable.Constraint_android_scaleX, 47);
        f٢٤٠٦i.append(R.styleable.Constraint_android_scaleY, 48);
        f٢٤٠٦i.append(R.styleable.Constraint_android_transformPivotX, 49);
        f٢٤٠٦i.append(R.styleable.Constraint_android_transformPivotY, 50);
        f٢٤٠٦i.append(R.styleable.Constraint_android_translationX, 51);
        f٢٤٠٦i.append(R.styleable.Constraint_android_translationY, 52);
        f٢٤٠٦i.append(R.styleable.Constraint_android_translationZ, 53);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintCircle, 61);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        f٢٤٠٦i.append(R.styleable.Constraint_animateRelativeTo, 64);
        f٢٤٠٦i.append(R.styleable.Constraint_transitionEasing, 65);
        f٢٤٠٦i.append(R.styleable.Constraint_drawPath, 66);
        f٢٤٠٦i.append(R.styleable.Constraint_transitionPathRotate, 67);
        f٢٤٠٦i.append(R.styleable.Constraint_motionStagger, 79);
        f٢٤٠٦i.append(R.styleable.Constraint_android_id, 38);
        f٢٤٠٦i.append(R.styleable.Constraint_motionProgress, 68);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_wrapBehaviorInParent, 97);
        f٢٤٠٦i.append(R.styleable.Constraint_chainUseRtl, 71);
        f٢٤٠٦i.append(R.styleable.Constraint_barrierDirection, 72);
        f٢٤٠٦i.append(R.styleable.Constraint_barrierMargin, 73);
        f٢٤٠٦i.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        f٢٤٠٦i.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        f٢٤٠٦i.append(R.styleable.Constraint_pathMotionArc, 76);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constraintTag, 77);
        f٢٤٠٦i.append(R.styleable.Constraint_visibilityMode, 78);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        f٢٤٠٦i.append(R.styleable.Constraint_layout_constrainedHeight, 81);
        f٢٤٠٦i.append(R.styleable.Constraint_polarRelativeTo, 82);
        f٢٤٠٦i.append(R.styleable.Constraint_transformPivotTarget, 83);
        f٢٤٠٦i.append(R.styleable.Constraint_quantizeMotionSteps, 84);
        f٢٤٠٦i.append(R.styleable.Constraint_quantizeMotionPhase, 85);
        f٢٤٠٦i.append(R.styleable.Constraint_quantizeMotionInterpolator, 86);
        SparseIntArray sparseIntArray = f٢٤٠٧j;
        int i10 = R.styleable.ConstraintOverride_layout_editor_absoluteY;
        sparseIntArray.append(i10, 6);
        f٢٤٠٧j.append(i10, 7);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_orientation, 27);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_goneMarginTop, 16);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_goneMarginRight, 14);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_goneMarginStart, 15);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_layout_marginLeft, 24);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_layout_marginRight, 28);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_layout_marginStart, 31);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_layout_marginEnd, 8);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_layout_marginTop, 34);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_layout_marginBottom, 2);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_layout_width, 23);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_layout_height, 21);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintWidth, 95);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintHeight, 96);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_visibility, 22);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_alpha, 43);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_elevation, 44);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_rotationX, 45);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_rotationY, 46);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_rotation, 60);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_scaleX, 47);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_scaleY, 48);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_transformPivotX, 49);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_transformPivotY, 50);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_translationX, 51);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_translationY, 52);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_translationZ, 53);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_animateRelativeTo, 64);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_transitionEasing, 65);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_drawPath, 66);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_transitionPathRotate, 67);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_motionStagger, 79);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_android_id, 38);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_motionTarget, 98);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_motionProgress, 68);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_chainUseRtl, 71);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_barrierDirection, 72);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_barrierMargin, 73);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_constraint_referenced_ids, 74);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_pathMotionArc, 76);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constraintTag, 77);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_visibilityMode, 78);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constrainedWidth, 80);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_constrainedHeight, 81);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_polarRelativeTo, 82);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_transformPivotTarget, 83);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_quantizeMotionSteps, 84);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_quantizeMotionPhase, 85);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        f٢٤٠٧j.append(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int F(TypedArray typedArray, int i10, int i11) {
        int resourceId = typedArray.getResourceId(i10, i11);
        if (resourceId == -1) {
            return typedArray.getInt(i10, -1);
        }
        return resourceId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if (r4 == (-1)) goto L١٦;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void G(Object obj, TypedArray typedArray, int i10, int i11) {
        int dimensionPixelSize;
        boolean z10;
        if (obj == null) {
            return;
        }
        int i12 = typedArray.peekValue(i10).type;
        if (i12 != 3) {
            int i13 = 0;
            if (i12 != 5) {
                dimensionPixelSize = typedArray.getInt(i10, 0);
                if (dimensionPixelSize != -4) {
                    if (dimensionPixelSize != -3) {
                        if (dimensionPixelSize != -2) {
                        }
                    }
                    z10 = false;
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar = (ConstraintLayout.b) obj;
                        if (i11 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar).width = i13;
                            bVar.f٢٣٠٠a0 = z10;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar).height = i13;
                            bVar.f٢٣٠٢b0 = z10;
                            return;
                        }
                    }
                    if (obj instanceof b) {
                        b bVar2 = (b) obj;
                        if (i11 == 0) {
                            bVar2.f٢٤٤٣d = i13;
                            bVar2.f٢٤٦٤n0 = z10;
                            return;
                        } else {
                            bVar2.f٢٤٤٥e = i13;
                            bVar2.f٢٤٦٦o0 = z10;
                            return;
                        }
                    }
                    if (obj instanceof a.C٠٠١٨a) {
                        a.C٠٠١٨a r32 = (a.C٠٠١٨a) obj;
                        if (i11 == 0) {
                            r32.b(23, i13);
                            r32.d(80, z10);
                            return;
                        } else {
                            r32.b(21, i13);
                            r32.d(81, z10);
                            return;
                        }
                    }
                    return;
                }
                z10 = true;
                i13 = -2;
                if (obj instanceof ConstraintLayout.b) {
                }
            } else {
                dimensionPixelSize = typedArray.getDimensionPixelSize(i10, 0);
            }
            i13 = dimensionPixelSize;
            z10 = false;
            if (obj instanceof ConstraintLayout.b) {
            }
        } else {
            H(obj, typedArray.getString(i10), i11);
        }
    }

    static void H(Object obj, String str, int i10) {
        if (str == null) {
            return;
        }
        int indexOf = str.indexOf(61);
        int length = str.length();
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + 1);
            if (substring2.length() > 0) {
                String trim = substring.trim();
                String trim2 = substring2.trim();
                if ("ratio".equalsIgnoreCase(trim)) {
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar = (ConstraintLayout.b) obj;
                        if (i10 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar).width = 0;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar).height = 0;
                        }
                        I(bVar, trim2);
                        return;
                    }
                    if (obj instanceof b) {
                        ((b) obj).A = trim2;
                        return;
                    } else {
                        if (obj instanceof a.C٠٠١٨a) {
                            ((a.C٠٠١٨a) obj).c(5, trim2);
                            return;
                        }
                        return;
                    }
                }
                try {
                    if ("weight".equalsIgnoreCase(trim)) {
                        float parseFloat = Float.parseFloat(trim2);
                        if (obj instanceof ConstraintLayout.b) {
                            ConstraintLayout.b bVar2 = (ConstraintLayout.b) obj;
                            if (i10 == 0) {
                                ((ViewGroup.MarginLayoutParams) bVar2).width = 0;
                                bVar2.L = parseFloat;
                            } else {
                                ((ViewGroup.MarginLayoutParams) bVar2).height = 0;
                                bVar2.M = parseFloat;
                            }
                        } else if (obj instanceof b) {
                            b bVar3 = (b) obj;
                            if (i10 == 0) {
                                bVar3.f٢٤٤٣d = 0;
                                bVar3.W = parseFloat;
                            } else {
                                bVar3.f٢٤٤٥e = 0;
                                bVar3.V = parseFloat;
                            }
                        } else if (obj instanceof a.C٠٠١٨a) {
                            a.C٠٠١٨a r52 = (a.C٠٠١٨a) obj;
                            if (i10 == 0) {
                                r52.b(23, 0);
                                r52.a(39, parseFloat);
                            } else {
                                r52.b(21, 0);
                                r52.a(40, parseFloat);
                            }
                        }
                    } else if ("parent".equalsIgnoreCase(trim)) {
                        float max = Math.max(DownloadProgress.UNKNOWN_PROGRESS, Math.min(1.0f, Float.parseFloat(trim2)));
                        if (obj instanceof ConstraintLayout.b) {
                            ConstraintLayout.b bVar4 = (ConstraintLayout.b) obj;
                            if (i10 == 0) {
                                ((ViewGroup.MarginLayoutParams) bVar4).width = 0;
                                bVar4.V = max;
                                bVar4.P = 2;
                            } else {
                                ((ViewGroup.MarginLayoutParams) bVar4).height = 0;
                                bVar4.W = max;
                                bVar4.Q = 2;
                            }
                        } else if (obj instanceof b) {
                            b bVar5 = (b) obj;
                            if (i10 == 0) {
                                bVar5.f٢٤٤٣d = 0;
                                bVar5.f٢٤٤٨f0 = max;
                                bVar5.Z = 2;
                            } else {
                                bVar5.f٢٤٤٥e = 0;
                                bVar5.f٢٤٥٠g0 = max;
                                bVar5.f٢٤٣٨a0 = 2;
                            }
                        } else if (obj instanceof a.C٠٠١٨a) {
                            a.C٠٠١٨a r53 = (a.C٠٠١٨a) obj;
                            if (i10 == 0) {
                                r53.b(23, 0);
                                r53.b(54, 2);
                            } else {
                                r53.b(21, 0);
                                r53.b(55, 2);
                            }
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void I(ConstraintLayout.b bVar, String str) {
        float f10 = Float.NaN;
        int i10 = -1;
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i11 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase("W")) {
                    i10 = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    i10 = 1;
                }
                i11 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            try {
                if (indexOf2 >= 0 && indexOf2 < length - 1) {
                    String substring2 = str.substring(i11, indexOf2);
                    String substring3 = str.substring(indexOf2 + 1);
                    if (substring2.length() > 0 && substring3.length() > 0) {
                        float parseFloat = Float.parseFloat(substring2);
                        float parseFloat2 = Float.parseFloat(substring3);
                        if (parseFloat > DownloadProgress.UNKNOWN_PROGRESS && parseFloat2 > DownloadProgress.UNKNOWN_PROGRESS) {
                            f10 = i10 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                        }
                    }
                } else {
                    String substring4 = str.substring(i11);
                    if (substring4.length() > 0) {
                        f10 = Float.parseFloat(substring4);
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        bVar.I = str;
        bVar.J = f10;
        bVar.K = i10;
    }

    private void J(Context context, a aVar, TypedArray typedArray, boolean z10) {
        if (z10) {
            K(context, aVar, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            if (index != R.styleable.Constraint_android_id && R.styleable.Constraint_android_layout_marginStart != index && R.styleable.Constraint_android_layout_marginEnd != index) {
                aVar.f٢٤١٨d.f٢٤٨١a = true;
                aVar.f٢٤١٩e.f٢٤٣٩b = true;
                aVar.f٢٤١٧c.f٢٤٩٥a = true;
                aVar.f٢٤٢٠f.f٢٥٠١a = true;
            }
            switch (f٢٤٠٦i.get(index)) {
                case 1:
                    b bVar = aVar.f٢٤١٩e;
                    bVar.f٢٤٧١r = F(typedArray, index, bVar.f٢٤٧١r);
                    break;
                case 2:
                    b bVar2 = aVar.f٢٤١٩e;
                    bVar2.K = typedArray.getDimensionPixelSize(index, bVar2.K);
                    break;
                case 3:
                    b bVar3 = aVar.f٢٤١٩e;
                    bVar3.f٢٤٦٩q = F(typedArray, index, bVar3.f٢٤٦٩q);
                    break;
                case 4:
                    b bVar4 = aVar.f٢٤١٩e;
                    bVar4.f٢٤٦٧p = F(typedArray, index, bVar4.f٢٤٦٧p);
                    break;
                case 5:
                    aVar.f٢٤١٩e.A = typedArray.getString(index);
                    break;
                case 6:
                    b bVar5 = aVar.f٢٤١٩e;
                    bVar5.E = typedArray.getDimensionPixelOffset(index, bVar5.E);
                    break;
                case 7:
                    b bVar6 = aVar.f٢٤١٩e;
                    bVar6.F = typedArray.getDimensionPixelOffset(index, bVar6.F);
                    break;
                case 8:
                    b bVar7 = aVar.f٢٤١٩e;
                    bVar7.L = typedArray.getDimensionPixelSize(index, bVar7.L);
                    break;
                case 9:
                    b bVar8 = aVar.f٢٤١٩e;
                    bVar8.f٢٤٧٧x = F(typedArray, index, bVar8.f٢٤٧٧x);
                    break;
                case 10:
                    b bVar9 = aVar.f٢٤١٩e;
                    bVar9.f٢٤٧٦w = F(typedArray, index, bVar9.f٢٤٧٦w);
                    break;
                case 11:
                    b bVar10 = aVar.f٢٤١٩e;
                    bVar10.R = typedArray.getDimensionPixelSize(index, bVar10.R);
                    break;
                case 12:
                    b bVar11 = aVar.f٢٤١٩e;
                    bVar11.S = typedArray.getDimensionPixelSize(index, bVar11.S);
                    break;
                case 13:
                    b bVar12 = aVar.f٢٤١٩e;
                    bVar12.O = typedArray.getDimensionPixelSize(index, bVar12.O);
                    break;
                case 14:
                    b bVar13 = aVar.f٢٤١٩e;
                    bVar13.Q = typedArray.getDimensionPixelSize(index, bVar13.Q);
                    break;
                case 15:
                    b bVar14 = aVar.f٢٤١٩e;
                    bVar14.T = typedArray.getDimensionPixelSize(index, bVar14.T);
                    break;
                case 16:
                    b bVar15 = aVar.f٢٤١٩e;
                    bVar15.P = typedArray.getDimensionPixelSize(index, bVar15.P);
                    break;
                case 17:
                    b bVar16 = aVar.f٢٤١٩e;
                    bVar16.f٢٤٤٧f = typedArray.getDimensionPixelOffset(index, bVar16.f٢٤٤٧f);
                    break;
                case 18:
                    b bVar17 = aVar.f٢٤١٩e;
                    bVar17.f٢٤٤٩g = typedArray.getDimensionPixelOffset(index, bVar17.f٢٤٤٩g);
                    break;
                case 19:
                    b bVar18 = aVar.f٢٤١٩e;
                    bVar18.f٢٤٥١h = typedArray.getFloat(index, bVar18.f٢٤٥١h);
                    break;
                case 20:
                    b bVar19 = aVar.f٢٤١٩e;
                    bVar19.f٢٤٧٨y = typedArray.getFloat(index, bVar19.f٢٤٧٨y);
                    break;
                case 21:
                    b bVar20 = aVar.f٢٤١٩e;
                    bVar20.f٢٤٤٥e = typedArray.getLayoutDimension(index, bVar20.f٢٤٤٥e);
                    break;
                case 22:
                    d dVar = aVar.f٢٤١٧c;
                    dVar.f٢٤٩٦b = typedArray.getInt(index, dVar.f٢٤٩٦b);
                    d dVar2 = aVar.f٢٤١٧c;
                    dVar2.f٢٤٩٦b = f٢٤٠٥h[dVar2.f٢٤٩٦b];
                    break;
                case 23:
                    b bVar21 = aVar.f٢٤١٩e;
                    bVar21.f٢٤٤٣d = typedArray.getLayoutDimension(index, bVar21.f٢٤٤٣d);
                    break;
                case 24:
                    b bVar22 = aVar.f٢٤١٩e;
                    bVar22.H = typedArray.getDimensionPixelSize(index, bVar22.H);
                    break;
                case 25:
                    b bVar23 = aVar.f٢٤١٩e;
                    bVar23.f٢٤٥٥j = F(typedArray, index, bVar23.f٢٤٥٥j);
                    break;
                case 26:
                    b bVar24 = aVar.f٢٤١٩e;
                    bVar24.f٢٤٥٧k = F(typedArray, index, bVar24.f٢٤٥٧k);
                    break;
                case 27:
                    b bVar25 = aVar.f٢٤١٩e;
                    bVar25.G = typedArray.getInt(index, bVar25.G);
                    break;
                case 28:
                    b bVar26 = aVar.f٢٤١٩e;
                    bVar26.I = typedArray.getDimensionPixelSize(index, bVar26.I);
                    break;
                case 29:
                    b bVar27 = aVar.f٢٤١٩e;
                    bVar27.f٢٤٥٩l = F(typedArray, index, bVar27.f٢٤٥٩l);
                    break;
                case 30:
                    b bVar28 = aVar.f٢٤١٩e;
                    bVar28.f٢٤٦١m = F(typedArray, index, bVar28.f٢٤٦١m);
                    break;
                case 31:
                    b bVar29 = aVar.f٢٤١٩e;
                    bVar29.M = typedArray.getDimensionPixelSize(index, bVar29.M);
                    break;
                case 32:
                    b bVar30 = aVar.f٢٤١٩e;
                    bVar30.f٢٤٧٤u = F(typedArray, index, bVar30.f٢٤٧٤u);
                    break;
                case 33:
                    b bVar31 = aVar.f٢٤١٩e;
                    bVar31.f٢٤٧٥v = F(typedArray, index, bVar31.f٢٤٧٥v);
                    break;
                case 34:
                    b bVar32 = aVar.f٢٤١٩e;
                    bVar32.J = typedArray.getDimensionPixelSize(index, bVar32.J);
                    break;
                case 35:
                    b bVar33 = aVar.f٢٤١٩e;
                    bVar33.f٢٤٦٥o = F(typedArray, index, bVar33.f٢٤٦٥o);
                    break;
                case 36:
                    b bVar34 = aVar.f٢٤١٩e;
                    bVar34.f٢٤٦٣n = F(typedArray, index, bVar34.f٢٤٦٣n);
                    break;
                case 37:
                    b bVar35 = aVar.f٢٤١٩e;
                    bVar35.f٢٤٧٩z = typedArray.getFloat(index, bVar35.f٢٤٧٩z);
                    break;
                case 38:
                    aVar.f٢٤١٥a = typedArray.getResourceId(index, aVar.f٢٤١٥a);
                    break;
                case 39:
                    b bVar36 = aVar.f٢٤١٩e;
                    bVar36.W = typedArray.getFloat(index, bVar36.W);
                    break;
                case 40:
                    b bVar37 = aVar.f٢٤١٩e;
                    bVar37.V = typedArray.getFloat(index, bVar37.V);
                    break;
                case 41:
                    b bVar38 = aVar.f٢٤١٩e;
                    bVar38.X = typedArray.getInt(index, bVar38.X);
                    break;
                case 42:
                    b bVar39 = aVar.f٢٤١٩e;
                    bVar39.Y = typedArray.getInt(index, bVar39.Y);
                    break;
                case 43:
                    d dVar3 = aVar.f٢٤١٧c;
                    dVar3.f٢٤٩٨d = typedArray.getFloat(index, dVar3.f٢٤٩٨d);
                    break;
                case 44:
                    e eVar = aVar.f٢٤٢٠f;
                    eVar.f٢٥١٣m = true;
                    eVar.f٢٥١٤n = typedArray.getDimension(index, eVar.f٢٥١٤n);
                    break;
                case 45:
                    e eVar2 = aVar.f٢٤٢٠f;
                    eVar2.f٢٥٠٣c = typedArray.getFloat(index, eVar2.f٢٥٠٣c);
                    break;
                case 46:
                    e eVar3 = aVar.f٢٤٢٠f;
                    eVar3.f٢٥٠٤d = typedArray.getFloat(index, eVar3.f٢٥٠٤d);
                    break;
                case 47:
                    e eVar4 = aVar.f٢٤٢٠f;
                    eVar4.f٢٥٠٥e = typedArray.getFloat(index, eVar4.f٢٥٠٥e);
                    break;
                case 48:
                    e eVar5 = aVar.f٢٤٢٠f;
                    eVar5.f٢٥٠٦f = typedArray.getFloat(index, eVar5.f٢٥٠٦f);
                    break;
                case 49:
                    e eVar6 = aVar.f٢٤٢٠f;
                    eVar6.f٢٥٠٧g = typedArray.getDimension(index, eVar6.f٢٥٠٧g);
                    break;
                case 50:
                    e eVar7 = aVar.f٢٤٢٠f;
                    eVar7.f٢٥٠٨h = typedArray.getDimension(index, eVar7.f٢٥٠٨h);
                    break;
                case 51:
                    e eVar8 = aVar.f٢٤٢٠f;
                    eVar8.f٢٥١٠j = typedArray.getDimension(index, eVar8.f٢٥١٠j);
                    break;
                case 52:
                    e eVar9 = aVar.f٢٤٢٠f;
                    eVar9.f٢٥١١k = typedArray.getDimension(index, eVar9.f٢٥١١k);
                    break;
                case 53:
                    e eVar10 = aVar.f٢٤٢٠f;
                    eVar10.f٢٥١٢l = typedArray.getDimension(index, eVar10.f٢٥١٢l);
                    break;
                case 54:
                    b bVar40 = aVar.f٢٤١٩e;
                    bVar40.Z = typedArray.getInt(index, bVar40.Z);
                    break;
                case 55:
                    b bVar41 = aVar.f٢٤١٩e;
                    bVar41.f٢٤٣٨a0 = typedArray.getInt(index, bVar41.f٢٤٣٨a0);
                    break;
                case 56:
                    b bVar42 = aVar.f٢٤١٩e;
                    bVar42.f٢٤٤٠b0 = typedArray.getDimensionPixelSize(index, bVar42.f٢٤٤٠b0);
                    break;
                case 57:
                    b bVar43 = aVar.f٢٤١٩e;
                    bVar43.f٢٤٤٢c0 = typedArray.getDimensionPixelSize(index, bVar43.f٢٤٤٢c0);
                    break;
                case 58:
                    b bVar44 = aVar.f٢٤١٩e;
                    bVar44.f٢٤٤٤d0 = typedArray.getDimensionPixelSize(index, bVar44.f٢٤٤٤d0);
                    break;
                case 59:
                    b bVar45 = aVar.f٢٤١٩e;
                    bVar45.f٢٤٤٦e0 = typedArray.getDimensionPixelSize(index, bVar45.f٢٤٤٦e0);
                    break;
                case 60:
                    e eVar11 = aVar.f٢٤٢٠f;
                    eVar11.f٢٥٠٢b = typedArray.getFloat(index, eVar11.f٢٥٠٢b);
                    break;
                case 61:
                    b bVar46 = aVar.f٢٤١٩e;
                    bVar46.f٢٤٣٦B = F(typedArray, index, bVar46.f٢٤٣٦B);
                    break;
                case 62:
                    b bVar47 = aVar.f٢٤١٩e;
                    bVar47.C = typedArray.getDimensionPixelSize(index, bVar47.C);
                    break;
                case 63:
                    b bVar48 = aVar.f٢٤١٩e;
                    bVar48.D = typedArray.getFloat(index, bVar48.D);
                    break;
                case 64:
                    C٠٠١٩c r22 = aVar.f٢٤١٨d;
                    r22.f٢٤٨٢b = F(typedArray, index, r22.f٢٤٨٢b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        aVar.f٢٤١٨d.f٢٤٨٤d = typedArray.getString(index);
                        break;
                    } else {
                        aVar.f٢٤١٨d.f٢٤٨٤d = a2.c.f١٢١c[typedArray.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    aVar.f٢٤١٨d.f٢٤٨٦f = typedArray.getInt(index, 0);
                    break;
                case 67:
                    C٠٠١٩c r23 = aVar.f٢٤١٨d;
                    r23.f٢٤٨٩i = typedArray.getFloat(index, r23.f٢٤٨٩i);
                    break;
                case 68:
                    d dVar4 = aVar.f٢٤١٧c;
                    dVar4.f٢٤٩٩e = typedArray.getFloat(index, dVar4.f٢٤٩٩e);
                    break;
                case 69:
                    aVar.f٢٤١٩e.f٢٤٤٨f0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f٢٤١٩e.f٢٤٥٠g0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    b bVar49 = aVar.f٢٤١٩e;
                    bVar49.f٢٤٥٢h0 = typedArray.getInt(index, bVar49.f٢٤٥٢h0);
                    break;
                case 73:
                    b bVar50 = aVar.f٢٤١٩e;
                    bVar50.f٢٤٥٤i0 = typedArray.getDimensionPixelSize(index, bVar50.f٢٤٥٤i0);
                    break;
                case 74:
                    aVar.f٢٤١٩e.f٢٤٦٠l0 = typedArray.getString(index);
                    break;
                case 75:
                    b bVar51 = aVar.f٢٤١٩e;
                    bVar51.f٢٤٦٨p0 = typedArray.getBoolean(index, bVar51.f٢٤٦٨p0);
                    break;
                case 76:
                    C٠٠١٩c r24 = aVar.f٢٤١٨d;
                    r24.f٢٤٨٥e = typedArray.getInt(index, r24.f٢٤٨٥e);
                    break;
                case 77:
                    aVar.f٢٤١٩e.f٢٤٦٢m0 = typedArray.getString(index);
                    break;
                case 78:
                    d dVar5 = aVar.f٢٤١٧c;
                    dVar5.f٢٤٩٧c = typedArray.getInt(index, dVar5.f٢٤٩٧c);
                    break;
                case 79:
                    C٠٠١٩c r25 = aVar.f٢٤١٨d;
                    r25.f٢٤٨٧g = typedArray.getFloat(index, r25.f٢٤٨٧g);
                    break;
                case 80:
                    b bVar52 = aVar.f٢٤١٩e;
                    bVar52.f٢٤٦٤n0 = typedArray.getBoolean(index, bVar52.f٢٤٦٤n0);
                    break;
                case 81:
                    b bVar53 = aVar.f٢٤١٩e;
                    bVar53.f٢٤٦٦o0 = typedArray.getBoolean(index, bVar53.f٢٤٦٦o0);
                    break;
                case 82:
                    C٠٠١٩c r26 = aVar.f٢٤١٨d;
                    r26.f٢٤٨٣c = typedArray.getInteger(index, r26.f٢٤٨٣c);
                    break;
                case 83:
                    e eVar12 = aVar.f٢٤٢٠f;
                    eVar12.f٢٥٠٩i = F(typedArray, index, eVar12.f٢٥٠٩i);
                    break;
                case 84:
                    C٠٠١٩c r27 = aVar.f٢٤١٨d;
                    r27.f٢٤٩١k = typedArray.getInteger(index, r27.f٢٤٩١k);
                    break;
                case 85:
                    C٠٠١٩c r28 = aVar.f٢٤١٨d;
                    r28.f٢٤٩٠j = typedArray.getFloat(index, r28.f٢٤٩٠j);
                    break;
                case 86:
                    int i11 = typedArray.peekValue(index).type;
                    if (i11 == 1) {
                        aVar.f٢٤١٨d.f٢٤٩٤n = typedArray.getResourceId(index, -1);
                        C٠٠١٩c r12 = aVar.f٢٤١٨d;
                        if (r12.f٢٤٩٤n != -1) {
                            r12.f٢٤٩٣m = -2;
                            break;
                        } else {
                            break;
                        }
                    } else if (i11 == 3) {
                        aVar.f٢٤١٨d.f٢٤٩٢l = typedArray.getString(index);
                        if (aVar.f٢٤١٨d.f٢٤٩٢l.indexOf("/") > 0) {
                            aVar.f٢٤١٨d.f٢٤٩٤n = typedArray.getResourceId(index, -1);
                            aVar.f٢٤١٨d.f٢٤٩٣m = -2;
                            break;
                        } else {
                            aVar.f٢٤١٨d.f٢٤٩٣m = -1;
                            break;
                        }
                    } else {
                        C٠٠١٩c r29 = aVar.f٢٤١٨d;
                        r29.f٢٤٩٣m = typedArray.getInteger(index, r29.f٢٤٩٤n);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f٢٤٠٦i.get(index));
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f٢٤٠٦i.get(index));
                    break;
                case 91:
                    b bVar54 = aVar.f٢٤١٩e;
                    bVar54.f٢٤٧٢s = F(typedArray, index, bVar54.f٢٤٧٢s);
                    break;
                case 92:
                    b bVar55 = aVar.f٢٤١٩e;
                    bVar55.f٢٤٧٣t = F(typedArray, index, bVar55.f٢٤٧٣t);
                    break;
                case 93:
                    b bVar56 = aVar.f٢٤١٩e;
                    bVar56.N = typedArray.getDimensionPixelSize(index, bVar56.N);
                    break;
                case 94:
                    b bVar57 = aVar.f٢٤١٩e;
                    bVar57.U = typedArray.getDimensionPixelSize(index, bVar57.U);
                    break;
                case 95:
                    G(aVar.f٢٤١٩e, typedArray, index, 0);
                    break;
                case 96:
                    G(aVar.f٢٤١٩e, typedArray, index, 1);
                    break;
                case 97:
                    b bVar58 = aVar.f٢٤١٩e;
                    bVar58.f٢٤٧٠q0 = typedArray.getInt(index, bVar58.f٢٤٧٠q0);
                    break;
            }
        }
        b bVar59 = aVar.f٢٤١٩e;
        if (bVar59.f٢٤٦٠l0 != null) {
            bVar59.f٢٤٥٨k0 = null;
        }
    }

    private static void K(Context context, a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        a.C٠٠١٨a r02 = new a.C٠٠١٨a();
        aVar.f٢٤٢٢h = r02;
        aVar.f٢٤١٨d.f٢٤٨١a = false;
        aVar.f٢٤١٩e.f٢٤٣٩b = false;
        aVar.f٢٤١٧c.f٢٤٩٥a = false;
        aVar.f٢٤٢٠f.f٢٥٠١a = false;
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            switch (f٢٤٠٧j.get(index)) {
                case 2:
                    r02.b(2, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.K));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f٢٤٠٦i.get(index));
                    break;
                case 5:
                    r02.c(5, typedArray.getString(index));
                    break;
                case 6:
                    r02.b(6, typedArray.getDimensionPixelOffset(index, aVar.f٢٤١٩e.E));
                    break;
                case 7:
                    r02.b(7, typedArray.getDimensionPixelOffset(index, aVar.f٢٤١٩e.F));
                    break;
                case 8:
                    r02.b(8, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.L));
                    break;
                case 11:
                    r02.b(11, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.R));
                    break;
                case 12:
                    r02.b(12, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.S));
                    break;
                case 13:
                    r02.b(13, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.O));
                    break;
                case 14:
                    r02.b(14, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.Q));
                    break;
                case 15:
                    r02.b(15, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.T));
                    break;
                case 16:
                    r02.b(16, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.P));
                    break;
                case 17:
                    r02.b(17, typedArray.getDimensionPixelOffset(index, aVar.f٢٤١٩e.f٢٤٤٧f));
                    break;
                case 18:
                    r02.b(18, typedArray.getDimensionPixelOffset(index, aVar.f٢٤١٩e.f٢٤٤٩g));
                    break;
                case 19:
                    r02.a(19, typedArray.getFloat(index, aVar.f٢٤١٩e.f٢٤٥١h));
                    break;
                case 20:
                    r02.a(20, typedArray.getFloat(index, aVar.f٢٤١٩e.f٢٤٧٨y));
                    break;
                case 21:
                    r02.b(21, typedArray.getLayoutDimension(index, aVar.f٢٤١٩e.f٢٤٤٥e));
                    break;
                case 22:
                    r02.b(22, f٢٤٠٥h[typedArray.getInt(index, aVar.f٢٤١٧c.f٢٤٩٦b)]);
                    break;
                case 23:
                    r02.b(23, typedArray.getLayoutDimension(index, aVar.f٢٤١٩e.f٢٤٤٣d));
                    break;
                case 24:
                    r02.b(24, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.H));
                    break;
                case 27:
                    r02.b(27, typedArray.getInt(index, aVar.f٢٤١٩e.G));
                    break;
                case 28:
                    r02.b(28, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.I));
                    break;
                case 31:
                    r02.b(31, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.M));
                    break;
                case 34:
                    r02.b(34, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.J));
                    break;
                case 37:
                    r02.a(37, typedArray.getFloat(index, aVar.f٢٤١٩e.f٢٤٧٩z));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, aVar.f٢٤١٥a);
                    aVar.f٢٤١٥a = resourceId;
                    r02.b(38, resourceId);
                    break;
                case 39:
                    r02.a(39, typedArray.getFloat(index, aVar.f٢٤١٩e.W));
                    break;
                case 40:
                    r02.a(40, typedArray.getFloat(index, aVar.f٢٤١٩e.V));
                    break;
                case 41:
                    r02.b(41, typedArray.getInt(index, aVar.f٢٤١٩e.X));
                    break;
                case 42:
                    r02.b(42, typedArray.getInt(index, aVar.f٢٤١٩e.Y));
                    break;
                case 43:
                    r02.a(43, typedArray.getFloat(index, aVar.f٢٤١٧c.f٢٤٩٨d));
                    break;
                case 44:
                    r02.d(44, true);
                    r02.a(44, typedArray.getDimension(index, aVar.f٢٤٢٠f.f٢٥١٤n));
                    break;
                case 45:
                    r02.a(45, typedArray.getFloat(index, aVar.f٢٤٢٠f.f٢٥٠٣c));
                    break;
                case 46:
                    r02.a(46, typedArray.getFloat(index, aVar.f٢٤٢٠f.f٢٥٠٤d));
                    break;
                case 47:
                    r02.a(47, typedArray.getFloat(index, aVar.f٢٤٢٠f.f٢٥٠٥e));
                    break;
                case 48:
                    r02.a(48, typedArray.getFloat(index, aVar.f٢٤٢٠f.f٢٥٠٦f));
                    break;
                case 49:
                    r02.a(49, typedArray.getDimension(index, aVar.f٢٤٢٠f.f٢٥٠٧g));
                    break;
                case 50:
                    r02.a(50, typedArray.getDimension(index, aVar.f٢٤٢٠f.f٢٥٠٨h));
                    break;
                case 51:
                    r02.a(51, typedArray.getDimension(index, aVar.f٢٤٢٠f.f٢٥١٠j));
                    break;
                case 52:
                    r02.a(52, typedArray.getDimension(index, aVar.f٢٤٢٠f.f٢٥١١k));
                    break;
                case 53:
                    r02.a(53, typedArray.getDimension(index, aVar.f٢٤٢٠f.f٢٥١٢l));
                    break;
                case 54:
                    r02.b(54, typedArray.getInt(index, aVar.f٢٤١٩e.Z));
                    break;
                case 55:
                    r02.b(55, typedArray.getInt(index, aVar.f٢٤١٩e.f٢٤٣٨a0));
                    break;
                case 56:
                    r02.b(56, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.f٢٤٤٠b0));
                    break;
                case 57:
                    r02.b(57, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.f٢٤٤٢c0));
                    break;
                case 58:
                    r02.b(58, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.f٢٤٤٤d0));
                    break;
                case 59:
                    r02.b(59, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.f٢٤٤٦e0));
                    break;
                case 60:
                    r02.a(60, typedArray.getFloat(index, aVar.f٢٤٢٠f.f٢٥٠٢b));
                    break;
                case 62:
                    r02.b(62, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.C));
                    break;
                case 63:
                    r02.a(63, typedArray.getFloat(index, aVar.f٢٤١٩e.D));
                    break;
                case 64:
                    r02.b(64, F(typedArray, index, aVar.f٢٤١٨d.f٢٤٨٢b));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        r02.c(65, typedArray.getString(index));
                        break;
                    } else {
                        r02.c(65, a2.c.f١٢١c[typedArray.getInteger(index, 0)]);
                        break;
                    }
                case 66:
                    r02.b(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    r02.a(67, typedArray.getFloat(index, aVar.f٢٤١٨d.f٢٤٨٩i));
                    break;
                case 68:
                    r02.a(68, typedArray.getFloat(index, aVar.f٢٤١٧c.f٢٤٩٩e));
                    break;
                case 69:
                    r02.a(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    r02.a(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    r02.b(72, typedArray.getInt(index, aVar.f٢٤١٩e.f٢٤٥٢h0));
                    break;
                case 73:
                    r02.b(73, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.f٢٤٥٤i0));
                    break;
                case 74:
                    r02.c(74, typedArray.getString(index));
                    break;
                case 75:
                    r02.d(75, typedArray.getBoolean(index, aVar.f٢٤١٩e.f٢٤٦٨p0));
                    break;
                case 76:
                    r02.b(76, typedArray.getInt(index, aVar.f٢٤١٨d.f٢٤٨٥e));
                    break;
                case 77:
                    r02.c(77, typedArray.getString(index));
                    break;
                case 78:
                    r02.b(78, typedArray.getInt(index, aVar.f٢٤١٧c.f٢٤٩٧c));
                    break;
                case 79:
                    r02.a(79, typedArray.getFloat(index, aVar.f٢٤١٨d.f٢٤٨٧g));
                    break;
                case 80:
                    r02.d(80, typedArray.getBoolean(index, aVar.f٢٤١٩e.f٢٤٦٤n0));
                    break;
                case 81:
                    r02.d(81, typedArray.getBoolean(index, aVar.f٢٤١٩e.f٢٤٦٦o0));
                    break;
                case 82:
                    r02.b(82, typedArray.getInteger(index, aVar.f٢٤١٨d.f٢٤٨٣c));
                    break;
                case 83:
                    r02.b(83, F(typedArray, index, aVar.f٢٤٢٠f.f٢٥٠٩i));
                    break;
                case 84:
                    r02.b(84, typedArray.getInteger(index, aVar.f٢٤١٨d.f٢٤٩١k));
                    break;
                case 85:
                    r02.a(85, typedArray.getFloat(index, aVar.f٢٤١٨d.f٢٤٩٠j));
                    break;
                case 86:
                    int i11 = typedArray.peekValue(index).type;
                    if (i11 == 1) {
                        aVar.f٢٤١٨d.f٢٤٩٤n = typedArray.getResourceId(index, -1);
                        r02.b(89, aVar.f٢٤١٨d.f٢٤٩٤n);
                        C٠٠١٩c r32 = aVar.f٢٤١٨d;
                        if (r32.f٢٤٩٤n != -1) {
                            r32.f٢٤٩٣m = -2;
                            r02.b(88, -2);
                            break;
                        } else {
                            break;
                        }
                    } else if (i11 == 3) {
                        aVar.f٢٤١٨d.f٢٤٩٢l = typedArray.getString(index);
                        r02.c(90, aVar.f٢٤١٨d.f٢٤٩٢l);
                        if (aVar.f٢٤١٨d.f٢٤٩٢l.indexOf("/") > 0) {
                            aVar.f٢٤١٨d.f٢٤٩٤n = typedArray.getResourceId(index, -1);
                            r02.b(89, aVar.f٢٤١٨d.f٢٤٩٤n);
                            aVar.f٢٤١٨d.f٢٤٩٣m = -2;
                            r02.b(88, -2);
                            break;
                        } else {
                            aVar.f٢٤١٨d.f٢٤٩٣m = -1;
                            r02.b(88, -1);
                            break;
                        }
                    } else {
                        C٠٠١٩c r42 = aVar.f٢٤١٨d;
                        r42.f٢٤٩٣m = typedArray.getInteger(index, r42.f٢٤٩٤n);
                        r02.b(88, aVar.f٢٤١٨d.f٢٤٩٣m);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f٢٤٠٦i.get(index));
                    break;
                case 93:
                    r02.b(93, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.N));
                    break;
                case 94:
                    r02.b(94, typedArray.getDimensionPixelSize(index, aVar.f٢٤١٩e.U));
                    break;
                case 95:
                    G(r02, typedArray, index, 0);
                    break;
                case 96:
                    G(r02, typedArray, index, 1);
                    break;
                case 97:
                    r02.b(97, typedArray.getInt(index, aVar.f٢٤١٩e.f٢٤٧٠q0));
                    break;
                case 98:
                    if (MotionLayout.E0) {
                        int resourceId2 = typedArray.getResourceId(index, aVar.f٢٤١٥a);
                        aVar.f٢٤١٥a = resourceId2;
                        if (resourceId2 == -1) {
                            aVar.f٢٤١٦b = typedArray.getString(index);
                            break;
                        } else {
                            break;
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        aVar.f٢٤١٦b = typedArray.getString(index);
                        break;
                    } else {
                        aVar.f٢٤١٥a = typedArray.getResourceId(index, aVar.f٢٤١٥a);
                        break;
                    }
                case 99:
                    r02.d(99, typedArray.getBoolean(index, aVar.f٢٤١٩e.f٢٤٥٣i));
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N(a aVar, int i10, float f10) {
        if (i10 != 19) {
            if (i10 != 20) {
                if (i10 != 37) {
                    if (i10 != 60) {
                        if (i10 != 63) {
                            if (i10 != 79) {
                                if (i10 != 85) {
                                    if (i10 != 87) {
                                        if (i10 != 39) {
                                            if (i10 != 40) {
                                                switch (i10) {
                                                    case 43:
                                                        aVar.f٢٤١٧c.f٢٤٩٨d = f10;
                                                        return;
                                                    case 44:
                                                        e eVar = aVar.f٢٤٢٠f;
                                                        eVar.f٢٥١٤n = f10;
                                                        eVar.f٢٥١٣m = true;
                                                        return;
                                                    case 45:
                                                        aVar.f٢٤٢٠f.f٢٥٠٣c = f10;
                                                        return;
                                                    case 46:
                                                        aVar.f٢٤٢٠f.f٢٥٠٤d = f10;
                                                        return;
                                                    case 47:
                                                        aVar.f٢٤٢٠f.f٢٥٠٥e = f10;
                                                        return;
                                                    case 48:
                                                        aVar.f٢٤٢٠f.f٢٥٠٦f = f10;
                                                        return;
                                                    case 49:
                                                        aVar.f٢٤٢٠f.f٢٥٠٧g = f10;
                                                        return;
                                                    case 50:
                                                        aVar.f٢٤٢٠f.f٢٥٠٨h = f10;
                                                        return;
                                                    case 51:
                                                        aVar.f٢٤٢٠f.f٢٥١٠j = f10;
                                                        return;
                                                    case 52:
                                                        aVar.f٢٤٢٠f.f٢٥١١k = f10;
                                                        return;
                                                    case 53:
                                                        aVar.f٢٤٢٠f.f٢٥١٢l = f10;
                                                        return;
                                                    default:
                                                        switch (i10) {
                                                            case 67:
                                                                aVar.f٢٤١٨d.f٢٤٨٩i = f10;
                                                                return;
                                                            case 68:
                                                                aVar.f٢٤١٧c.f٢٤٩٩e = f10;
                                                                return;
                                                            case 69:
                                                                aVar.f٢٤١٩e.f٢٤٤٨f0 = f10;
                                                                return;
                                                            case 70:
                                                                aVar.f٢٤١٩e.f٢٤٥٠g0 = f10;
                                                                return;
                                                            default:
                                                                Log.w("ConstraintSet", "Unknown attribute 0x");
                                                                return;
                                                        }
                                                }
                                            }
                                            aVar.f٢٤١٩e.V = f10;
                                            return;
                                        }
                                        aVar.f٢٤١٩e.W = f10;
                                        return;
                                    }
                                    return;
                                }
                                aVar.f٢٤١٨d.f٢٤٩٠j = f10;
                                return;
                            }
                            aVar.f٢٤١٨d.f٢٤٨٧g = f10;
                            return;
                        }
                        aVar.f٢٤١٩e.D = f10;
                        return;
                    }
                    aVar.f٢٤٢٠f.f٢٥٠٢b = f10;
                    return;
                }
                aVar.f٢٤١٩e.f٢٤٧٩z = f10;
                return;
            }
            aVar.f٢٤١٩e.f٢٤٧٨y = f10;
            return;
        }
        aVar.f٢٤١٩e.f٢٤٥١h = f10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void O(a aVar, int i10, int i11) {
        if (i10 != 6) {
            if (i10 != 7) {
                if (i10 != 8) {
                    if (i10 != 27) {
                        if (i10 != 28) {
                            if (i10 != 41) {
                                if (i10 != 42) {
                                    if (i10 != 61) {
                                        if (i10 != 62) {
                                            if (i10 != 72) {
                                                if (i10 != 73) {
                                                    switch (i10) {
                                                        case 2:
                                                            aVar.f٢٤١٩e.K = i11;
                                                            return;
                                                        case 11:
                                                            aVar.f٢٤١٩e.R = i11;
                                                            return;
                                                        case 12:
                                                            aVar.f٢٤١٩e.S = i11;
                                                            return;
                                                        case 13:
                                                            aVar.f٢٤١٩e.O = i11;
                                                            return;
                                                        case 14:
                                                            aVar.f٢٤١٩e.Q = i11;
                                                            return;
                                                        case 15:
                                                            aVar.f٢٤١٩e.T = i11;
                                                            return;
                                                        case 16:
                                                            aVar.f٢٤١٩e.P = i11;
                                                            return;
                                                        case 17:
                                                            aVar.f٢٤١٩e.f٢٤٤٧f = i11;
                                                            return;
                                                        case 18:
                                                            aVar.f٢٤١٩e.f٢٤٤٩g = i11;
                                                            return;
                                                        case 31:
                                                            aVar.f٢٤١٩e.M = i11;
                                                            return;
                                                        case 34:
                                                            aVar.f٢٤١٩e.J = i11;
                                                            return;
                                                        case 38:
                                                            aVar.f٢٤١٥a = i11;
                                                            return;
                                                        case 64:
                                                            aVar.f٢٤١٨d.f٢٤٨٢b = i11;
                                                            return;
                                                        case 66:
                                                            aVar.f٢٤١٨d.f٢٤٨٦f = i11;
                                                            return;
                                                        case 76:
                                                            aVar.f٢٤١٨d.f٢٤٨٥e = i11;
                                                            return;
                                                        case 78:
                                                            aVar.f٢٤١٧c.f٢٤٩٧c = i11;
                                                            return;
                                                        case 93:
                                                            aVar.f٢٤١٩e.N = i11;
                                                            return;
                                                        case 94:
                                                            aVar.f٢٤١٩e.U = i11;
                                                            return;
                                                        case 97:
                                                            aVar.f٢٤١٩e.f٢٤٧٠q0 = i11;
                                                            return;
                                                        default:
                                                            switch (i10) {
                                                                case 21:
                                                                    aVar.f٢٤١٩e.f٢٤٤٥e = i11;
                                                                    return;
                                                                case 22:
                                                                    aVar.f٢٤١٧c.f٢٤٩٦b = i11;
                                                                    return;
                                                                case 23:
                                                                    aVar.f٢٤١٩e.f٢٤٤٣d = i11;
                                                                    return;
                                                                case 24:
                                                                    aVar.f٢٤١٩e.H = i11;
                                                                    return;
                                                                default:
                                                                    switch (i10) {
                                                                        case 54:
                                                                            aVar.f٢٤١٩e.Z = i11;
                                                                            return;
                                                                        case 55:
                                                                            aVar.f٢٤١٩e.f٢٤٣٨a0 = i11;
                                                                            return;
                                                                        case 56:
                                                                            aVar.f٢٤١٩e.f٢٤٤٠b0 = i11;
                                                                            return;
                                                                        case 57:
                                                                            aVar.f٢٤١٩e.f٢٤٤٢c0 = i11;
                                                                            return;
                                                                        case 58:
                                                                            aVar.f٢٤١٩e.f٢٤٤٤d0 = i11;
                                                                            return;
                                                                        case 59:
                                                                            aVar.f٢٤١٩e.f٢٤٤٦e0 = i11;
                                                                            return;
                                                                        default:
                                                                            switch (i10) {
                                                                                case 82:
                                                                                    aVar.f٢٤١٨d.f٢٤٨٣c = i11;
                                                                                    return;
                                                                                case 83:
                                                                                    aVar.f٢٤٢٠f.f٢٥٠٩i = i11;
                                                                                    return;
                                                                                case 84:
                                                                                    aVar.f٢٤١٨d.f٢٤٩١k = i11;
                                                                                    return;
                                                                                default:
                                                                                    switch (i10) {
                                                                                        case 87:
                                                                                            return;
                                                                                        case 88:
                                                                                            aVar.f٢٤١٨d.f٢٤٩٣m = i11;
                                                                                            return;
                                                                                        case 89:
                                                                                            aVar.f٢٤١٨d.f٢٤٩٤n = i11;
                                                                                            return;
                                                                                        default:
                                                                                            Log.w("ConstraintSet", "Unknown attribute 0x");
                                                                                            return;
                                                                                    }
                                                                            }
                                                                    }
                                                            }
                                                    }
                                                }
                                                aVar.f٢٤١٩e.f٢٤٥٤i0 = i11;
                                                return;
                                            }
                                            aVar.f٢٤١٩e.f٢٤٥٢h0 = i11;
                                            return;
                                        }
                                        aVar.f٢٤١٩e.C = i11;
                                        return;
                                    }
                                    aVar.f٢٤١٩e.f٢٤٣٦B = i11;
                                    return;
                                }
                                aVar.f٢٤١٩e.Y = i11;
                                return;
                            }
                            aVar.f٢٤١٩e.X = i11;
                            return;
                        }
                        aVar.f٢٤١٩e.I = i11;
                        return;
                    }
                    aVar.f٢٤١٩e.G = i11;
                    return;
                }
                aVar.f٢٤١٩e.L = i11;
                return;
            }
            aVar.f٢٤١٩e.F = i11;
            return;
        }
        aVar.f٢٤١٩e.E = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void P(a aVar, int i10, String str) {
        if (i10 != 5) {
            if (i10 != 65) {
                if (i10 != 74) {
                    if (i10 != 77) {
                        if (i10 != 87) {
                            if (i10 != 90) {
                                Log.w("ConstraintSet", "Unknown attribute 0x");
                                return;
                            } else {
                                aVar.f٢٤١٨d.f٢٤٩٢l = str;
                                return;
                            }
                        }
                        return;
                    }
                    aVar.f٢٤١٩e.f٢٤٦٢m0 = str;
                    return;
                }
                b bVar = aVar.f٢٤١٩e;
                bVar.f٢٤٦٠l0 = str;
                bVar.f٢٤٥٨k0 = null;
                return;
            }
            aVar.f٢٤١٨d.f٢٤٨٤d = str;
            return;
        }
        aVar.f٢٤١٩e.A = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q(a aVar, int i10, boolean z10) {
        if (i10 != 44) {
            if (i10 != 75) {
                if (i10 != 87) {
                    if (i10 != 80) {
                        if (i10 != 81) {
                            Log.w("ConstraintSet", "Unknown attribute 0x");
                            return;
                        } else {
                            aVar.f٢٤١٩e.f٢٤٦٦o0 = z10;
                            return;
                        }
                    }
                    aVar.f٢٤١٩e.f٢٤٦٤n0 = z10;
                    return;
                }
                return;
            }
            aVar.f٢٤١٩e.f٢٤٦٨p0 = z10;
            return;
        }
        aVar.f٢٤٢٠f.f٢٥١٣m = z10;
    }

    private String T(int i10) {
        switch (i10) {
            case 1:
                return ViewHierarchyConstants.DIMENSION_LEFT_KEY;
            case 2:
                return "right";
            case 3:
                return ViewHierarchyConstants.DIMENSION_TOP_KEY;
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public static a m(Context context, XmlPullParser xmlPullParser) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(asAttributeSet, R.styleable.ConstraintOverride);
        K(context, aVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private int[] t(View view, String str) {
        int i10;
        Object designInformation;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i11 = 0;
        int i12 = 0;
        while (i11 < split.length) {
            String trim = split[i11].trim();
            try {
                i10 = R.id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i10 = 0;
            }
            if (i10 == 0) {
                i10 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i10 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i10 = ((Integer) designInformation).intValue();
            }
            iArr[i12] = i10;
            i11++;
            i12++;
        }
        if (i12 != split.length) {
            return Arrays.copyOf(iArr, i12);
        }
        return iArr;
    }

    private a u(Context context, AttributeSet attributeSet, boolean z10) {
        int[] iArr;
        a aVar = new a();
        if (z10) {
            iArr = R.styleable.ConstraintOverride;
        } else {
            iArr = R.styleable.Constraint;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        J(context, aVar, obtainStyledAttributes, z10);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private a v(int i10) {
        if (!this.f٢٤١٤g.containsKey(Integer.valueOf(i10))) {
            this.f٢٤١٤g.put(Integer.valueOf(i10), new a());
        }
        return (a) this.f٢٤١٤g.get(Integer.valueOf(i10));
    }

    public int A(int i10) {
        return v(i10).f٢٤١٧c.f٢٤٩٦b;
    }

    public int B(int i10) {
        return v(i10).f٢٤١٧c.f٢٤٩٧c;
    }

    public int C(int i10) {
        return v(i10).f٢٤١٩e.f٢٤٤٣d;
    }

    public void D(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType != 0) {
                    if (eventType == 2) {
                        String name = xml.getName();
                        a u10 = u(context, Xml.asAttributeSet(xml), false);
                        if (name.equalsIgnoreCase("Guideline")) {
                            u10.f٢٤١٩e.f٢٤٣٧a = true;
                        }
                        this.f٢٤١٤g.put(Integer.valueOf(u10.f٢٤١٥a), u10);
                    }
                } else {
                    xml.getName();
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x01cf, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void E(Context context, XmlPullParser xmlPullParser) {
        try {
            int eventType = xmlPullParser.getEventType();
            a aVar = null;
            while (eventType != 1) {
                if (eventType != 0) {
                    char c10 = 65535;
                    if (eventType != 2) {
                        if (eventType == 3) {
                            String lowerCase = xmlPullParser.getName().toLowerCase(Locale.ROOT);
                            switch (lowerCase.hashCode()) {
                                case -2075718416:
                                    if (lowerCase.equals("guideline")) {
                                        c10 = 3;
                                        break;
                                    }
                                    break;
                                case -190376483:
                                    if (lowerCase.equals("constraint")) {
                                        c10 = 1;
                                        break;
                                    }
                                    break;
                                case 426575017:
                                    if (lowerCase.equals("constraintoverride")) {
                                        c10 = 2;
                                        break;
                                    }
                                    break;
                                case 2146106725:
                                    if (lowerCase.equals("constraintset")) {
                                        c10 = 0;
                                        break;
                                    }
                                    break;
                            }
                            if (c10 != 0) {
                                if (c10 == 1 || c10 == 2 || c10 == 3) {
                                    this.f٢٤١٤g.put(Integer.valueOf(aVar.f٢٤١٥a), aVar);
                                    aVar = null;
                                }
                            } else {
                                return;
                            }
                        }
                    } else {
                        String name = xmlPullParser.getName();
                        switch (name.hashCode()) {
                            case -2025855158:
                                if (name.equals("Layout")) {
                                    c10 = 6;
                                    break;
                                }
                                break;
                            case -1984451626:
                                if (name.equals("Motion")) {
                                    c10 = 7;
                                    break;
                                }
                                break;
                            case -1962203927:
                                if (name.equals("ConstraintOverride")) {
                                    c10 = 1;
                                    break;
                                }
                                break;
                            case -1269513683:
                                if (name.equals("PropertySet")) {
                                    c10 = 4;
                                    break;
                                }
                                break;
                            case -1238332596:
                                if (name.equals("Transform")) {
                                    c10 = 5;
                                    break;
                                }
                                break;
                            case -71750448:
                                if (name.equals("Guideline")) {
                                    c10 = 2;
                                    break;
                                }
                                break;
                            case 366511058:
                                if (name.equals("CustomMethod")) {
                                    c10 = '\t';
                                    break;
                                }
                                break;
                            case 1331510167:
                                if (name.equals("Barrier")) {
                                    c10 = 3;
                                    break;
                                }
                                break;
                            case 1791837707:
                                if (name.equals("CustomAttribute")) {
                                    c10 = '\b';
                                    break;
                                }
                                break;
                            case 1803088381:
                                if (name.equals("Constraint")) {
                                    c10 = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c10) {
                            case 0:
                                aVar = u(context, Xml.asAttributeSet(xmlPullParser), false);
                                break;
                            case 1:
                                aVar = u(context, Xml.asAttributeSet(xmlPullParser), true);
                                break;
                            case 2:
                                aVar = u(context, Xml.asAttributeSet(xmlPullParser), false);
                                b bVar = aVar.f٢٤١٩e;
                                bVar.f٢٤٣٧a = true;
                                bVar.f٢٤٣٩b = true;
                                break;
                            case 3:
                                aVar = u(context, Xml.asAttributeSet(xmlPullParser), false);
                                aVar.f٢٤١٩e.f٢٤٥٦j0 = 1;
                                break;
                            case 4:
                                if (aVar != null) {
                                    aVar.f٢٤١٧c.b(context, Xml.asAttributeSet(xmlPullParser));
                                    break;
                                } else {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                            case 5:
                                if (aVar != null) {
                                    aVar.f٢٤٢٠f.b(context, Xml.asAttributeSet(xmlPullParser));
                                    break;
                                } else {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                            case 6:
                                if (aVar != null) {
                                    aVar.f٢٤١٩e.b(context, Xml.asAttributeSet(xmlPullParser));
                                    break;
                                } else {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                            case 7:
                                if (aVar != null) {
                                    aVar.f٢٤١٨d.b(context, Xml.asAttributeSet(xmlPullParser));
                                    break;
                                } else {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                            case '\b':
                            case '\t':
                                if (aVar != null) {
                                    androidx.constraintlayout.widget.a.h(context, xmlPullParser, aVar.f٢٤٢١g);
                                    break;
                                } else {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                        }
                    }
                } else {
                    xmlPullParser.getName();
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    public void L(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f٢٤١٣f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f٢٤١٤g.containsKey(Integer.valueOf(id))) {
                this.f٢٤١٤g.put(Integer.valueOf(id), new a());
            }
            a aVar = (a) this.f٢٤١٤g.get(Integer.valueOf(id));
            if (aVar != null) {
                if (!aVar.f٢٤١٩e.f٢٤٣٩b) {
                    aVar.g(id, bVar);
                    if (childAt instanceof ConstraintHelper) {
                        aVar.f٢٤١٩e.f٢٤٥٨k0 = ((ConstraintHelper) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = (Barrier) childAt;
                            aVar.f٢٤١٩e.f٢٤٦٨p0 = barrier.getAllowsGoneWidget();
                            aVar.f٢٤١٩e.f٢٤٥٢h0 = barrier.getType();
                            aVar.f٢٤١٩e.f٢٤٥٤i0 = barrier.getMargin();
                        }
                    }
                    aVar.f٢٤١٩e.f٢٤٣٩b = true;
                }
                d dVar = aVar.f٢٤١٧c;
                if (!dVar.f٢٤٩٥a) {
                    dVar.f٢٤٩٦b = childAt.getVisibility();
                    aVar.f٢٤١٧c.f٢٤٩٨d = childAt.getAlpha();
                    aVar.f٢٤١٧c.f٢٤٩٥a = true;
                }
                e eVar = aVar.f٢٤٢٠f;
                if (!eVar.f٢٥٠١a) {
                    eVar.f٢٥٠١a = true;
                    eVar.f٢٥٠٢b = childAt.getRotation();
                    aVar.f٢٤٢٠f.f٢٥٠٣c = childAt.getRotationX();
                    aVar.f٢٤٢٠f.f٢٥٠٤d = childAt.getRotationY();
                    aVar.f٢٤٢٠f.f٢٥٠٥e = childAt.getScaleX();
                    aVar.f٢٤٢٠f.f٢٥٠٦f = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || pivotY != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        e eVar2 = aVar.f٢٤٢٠f;
                        eVar2.f٢٥٠٧g = pivotX;
                        eVar2.f٢٥٠٨h = pivotY;
                    }
                    aVar.f٢٤٢٠f.f٢٥١٠j = childAt.getTranslationX();
                    aVar.f٢٤٢٠f.f٢٥١١k = childAt.getTranslationY();
                    aVar.f٢٤٢٠f.f٢٥١٢l = childAt.getTranslationZ();
                    e eVar3 = aVar.f٢٤٢٠f;
                    if (eVar3.f٢٥١٣m) {
                        eVar3.f٢٥١٤n = childAt.getElevation();
                    }
                }
            }
        }
    }

    public void M(c cVar) {
        for (Integer num : cVar.f٢٤١٤g.keySet()) {
            num.intValue();
            a aVar = (a) cVar.f٢٤١٤g.get(num);
            if (!this.f٢٤١٤g.containsKey(num)) {
                this.f٢٤١٤g.put(num, new a());
            }
            a aVar2 = (a) this.f٢٤١٤g.get(num);
            if (aVar2 != null) {
                b bVar = aVar2.f٢٤١٩e;
                if (!bVar.f٢٤٣٩b) {
                    bVar.a(aVar.f٢٤١٩e);
                }
                d dVar = aVar2.f٢٤١٧c;
                if (!dVar.f٢٤٩٥a) {
                    dVar.a(aVar.f٢٤١٧c);
                }
                e eVar = aVar2.f٢٤٢٠f;
                if (!eVar.f٢٥٠١a) {
                    eVar.a(aVar.f٢٤٢٠f);
                }
                C٠٠١٩c r32 = aVar2.f٢٤١٨d;
                if (!r32.f٢٤٨١a) {
                    r32.a(aVar.f٢٤١٨d);
                }
                for (String str : aVar.f٢٤٢١g.keySet()) {
                    if (!aVar2.f٢٤٢١g.containsKey(str)) {
                        aVar2.f٢٤٢١g.put(str, (androidx.constraintlayout.widget.a) aVar.f٢٤٢١g.get(str));
                    }
                }
            }
        }
    }

    public void R(boolean z10) {
        this.f٢٤١٣f = z10;
    }

    public void S(boolean z10) {
        this.f٢٤٠٨a = z10;
    }

    public void g(ConstraintLayout constraintLayout) {
        a aVar;
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            int id = childAt.getId();
            if (!this.f٢٤١٤g.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + androidx.constraintlayout.motion.widget.a.d(childAt));
            } else {
                if (this.f٢٤١٣f && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (this.f٢٤١٤g.containsKey(Integer.valueOf(id)) && (aVar = (a) this.f٢٤١٤g.get(Integer.valueOf(id))) != null) {
                    androidx.constraintlayout.widget.a.i(childAt, aVar.f٢٤٢١g);
                }
            }
        }
    }

    public void h(c cVar) {
        for (a aVar : cVar.f٢٤١٤g.values()) {
            if (aVar.f٢٤٢٢h != null) {
                if (aVar.f٢٤١٦b != null) {
                    Iterator it = this.f٢٤١٤g.keySet().iterator();
                    while (it.hasNext()) {
                        a w10 = w(((Integer) it.next()).intValue());
                        String str = w10.f٢٤١٩e.f٢٤٦٢m0;
                        if (str != null && aVar.f٢٤١٦b.matches(str)) {
                            aVar.f٢٤٢٢h.e(w10);
                            w10.f٢٤٢١g.putAll((HashMap) aVar.f٢٤٢١g.clone());
                        }
                    }
                } else {
                    aVar.f٢٤٢٢h.e(w(aVar.f٢٤١٥a));
                }
            }
        }
    }

    public void i(ConstraintLayout constraintLayout) {
        k(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void j(ConstraintHelper constraintHelper, c2.e eVar, ConstraintLayout.b bVar, SparseArray sparseArray) {
        a aVar;
        int id = constraintHelper.getId();
        if (this.f٢٤١٤g.containsKey(Integer.valueOf(id)) && (aVar = (a) this.f٢٤١٤g.get(Integer.valueOf(id))) != null && (eVar instanceof j)) {
            constraintHelper.o(aVar, (j) eVar, bVar, sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ConstraintLayout constraintLayout, boolean z10) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f٢٤١٤g.keySet());
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            int id = childAt.getId();
            if (!this.f٢٤١٤g.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + androidx.constraintlayout.motion.widget.a.d(childAt));
            } else {
                if (this.f٢٤١٣f && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.f٢٤١٤g.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        a aVar = (a) this.f٢٤١٤g.get(Integer.valueOf(id));
                        if (aVar != null) {
                            if (childAt instanceof Barrier) {
                                aVar.f٢٤١٩e.f٢٤٥٦j0 = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id);
                                barrier.setType(aVar.f٢٤١٩e.f٢٤٥٢h0);
                                barrier.setMargin(aVar.f٢٤١٩e.f٢٤٥٤i0);
                                barrier.setAllowsGoneWidget(aVar.f٢٤١٩e.f٢٤٦٨p0);
                                b bVar = aVar.f٢٤١٩e;
                                int[] iArr = bVar.f٢٤٥٨k0;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = bVar.f٢٤٦٠l0;
                                    if (str != null) {
                                        bVar.f٢٤٥٨k0 = t(barrier, str);
                                        barrier.setReferencedIds(aVar.f٢٤١٩e.f٢٤٥٨k0);
                                    }
                                }
                            }
                            ConstraintLayout.b bVar2 = (ConstraintLayout.b) childAt.getLayoutParams();
                            bVar2.c();
                            aVar.e(bVar2);
                            if (z10) {
                                androidx.constraintlayout.widget.a.i(childAt, aVar.f٢٤٢١g);
                            }
                            childAt.setLayoutParams(bVar2);
                            d dVar = aVar.f٢٤١٧c;
                            if (dVar.f٢٤٩٧c == 0) {
                                childAt.setVisibility(dVar.f٢٤٩٦b);
                            }
                            childAt.setAlpha(aVar.f٢٤١٧c.f٢٤٩٨d);
                            childAt.setRotation(aVar.f٢٤٢٠f.f٢٥٠٢b);
                            childAt.setRotationX(aVar.f٢٤٢٠f.f٢٥٠٣c);
                            childAt.setRotationY(aVar.f٢٤٢٠f.f٢٥٠٤d);
                            childAt.setScaleX(aVar.f٢٤٢٠f.f٢٥٠٥e);
                            childAt.setScaleY(aVar.f٢٤٢٠f.f٢٥٠٦f);
                            e eVar = aVar.f٢٤٢٠f;
                            if (eVar.f٢٥٠٩i != -1) {
                                if (((View) childAt.getParent()).findViewById(aVar.f٢٤٢٠f.f٢٥٠٩i) != null) {
                                    float top = (r4.getTop() + r4.getBottom()) / 2.0f;
                                    float left = (r4.getLeft() + r4.getRight()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(left - childAt.getLeft());
                                        childAt.setPivotY(top - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(eVar.f٢٥٠٧g)) {
                                    childAt.setPivotX(aVar.f٢٤٢٠f.f٢٥٠٧g);
                                }
                                if (!Float.isNaN(aVar.f٢٤٢٠f.f٢٥٠٨h)) {
                                    childAt.setPivotY(aVar.f٢٤٢٠f.f٢٥٠٨h);
                                }
                            }
                            childAt.setTranslationX(aVar.f٢٤٢٠f.f٢٥١٠j);
                            childAt.setTranslationY(aVar.f٢٤٢٠f.f٢٥١١k);
                            childAt.setTranslationZ(aVar.f٢٤٢٠f.f٢٥١٢l);
                            e eVar2 = aVar.f٢٤٢٠f;
                            if (eVar2.f٢٥١٣m) {
                                childAt.setElevation(eVar2.f٢٥١٤n);
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar2 = (a) this.f٢٤١٤g.get(num);
            if (aVar2 != null) {
                if (aVar2.f٢٤١٩e.f٢٤٥٦j0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    b bVar3 = aVar2.f٢٤١٩e;
                    int[] iArr2 = bVar3.f٢٤٥٨k0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar3.f٢٤٦٠l0;
                        if (str2 != null) {
                            bVar3.f٢٤٥٨k0 = t(barrier2, str2);
                            barrier2.setReferencedIds(aVar2.f٢٤١٩e.f٢٤٥٨k0);
                        }
                    }
                    barrier2.setType(aVar2.f٢٤١٩e.f٢٤٥٢h0);
                    barrier2.setMargin(aVar2.f٢٤١٩e.f٢٤٥٤i0);
                    ConstraintLayout.b generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.v();
                    aVar2.e(generateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, generateDefaultLayoutParams);
                }
                if (aVar2.f٢٤١٩e.f٢٤٣٧a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.b generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    aVar2.e(generateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, generateDefaultLayoutParams2);
                }
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = constraintLayout.getChildAt(i11);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).i(constraintLayout);
            }
        }
    }

    public void l(int i10, ConstraintLayout.b bVar) {
        a aVar;
        if (this.f٢٤١٤g.containsKey(Integer.valueOf(i10)) && (aVar = (a) this.f٢٤١٤g.get(Integer.valueOf(i10))) != null) {
            aVar.e(bVar);
        }
    }

    public void n(Context context, int i10) {
        o((ConstraintLayout) LayoutInflater.from(context).inflate(i10, (ViewGroup) null));
    }

    public void o(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f٢٤١٤g.clear();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f٢٤١٣f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f٢٤١٤g.containsKey(Integer.valueOf(id))) {
                this.f٢٤١٤g.put(Integer.valueOf(id), new a());
            }
            a aVar = (a) this.f٢٤١٤g.get(Integer.valueOf(id));
            if (aVar != null) {
                aVar.f٢٤٢١g = androidx.constraintlayout.widget.a.a(this.f٢٤١٢e, childAt);
                aVar.g(id, bVar);
                aVar.f٢٤١٧c.f٢٤٩٦b = childAt.getVisibility();
                aVar.f٢٤١٧c.f٢٤٩٨d = childAt.getAlpha();
                aVar.f٢٤٢٠f.f٢٥٠٢b = childAt.getRotation();
                aVar.f٢٤٢٠f.f٢٥٠٣c = childAt.getRotationX();
                aVar.f٢٤٢٠f.f٢٥٠٤d = childAt.getRotationY();
                aVar.f٢٤٢٠f.f٢٥٠٥e = childAt.getScaleX();
                aVar.f٢٤٢٠f.f٢٥٠٦f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || pivotY != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    e eVar = aVar.f٢٤٢٠f;
                    eVar.f٢٥٠٧g = pivotX;
                    eVar.f٢٥٠٨h = pivotY;
                }
                aVar.f٢٤٢٠f.f٢٥١٠j = childAt.getTranslationX();
                aVar.f٢٤٢٠f.f٢٥١١k = childAt.getTranslationY();
                aVar.f٢٤٢٠f.f٢٥١٢l = childAt.getTranslationZ();
                e eVar2 = aVar.f٢٤٢٠f;
                if (eVar2.f٢٥١٣m) {
                    eVar2.f٢٥١٤n = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    aVar.f٢٤١٩e.f٢٤٦٨p0 = barrier.getAllowsGoneWidget();
                    aVar.f٢٤١٩e.f٢٤٥٨k0 = barrier.getReferencedIds();
                    aVar.f٢٤١٩e.f٢٤٥٢h0 = barrier.getType();
                    aVar.f٢٤١٩e.f٢٤٥٤i0 = barrier.getMargin();
                }
            }
        }
    }

    public void p(c cVar) {
        this.f٢٤١٤g.clear();
        for (Integer num : cVar.f٢٤١٤g.keySet()) {
            a aVar = (a) cVar.f٢٤١٤g.get(num);
            if (aVar != null) {
                this.f٢٤١٤g.put(num, aVar.clone());
            }
        }
    }

    public void q(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.f٢٤١٤g.clear();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraints.getChildAt(i10);
            Constraints.a aVar = (Constraints.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f٢٤١٣f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f٢٤١٤g.containsKey(Integer.valueOf(id))) {
                this.f٢٤١٤g.put(Integer.valueOf(id), new a());
            }
            a aVar2 = (a) this.f٢٤١٤g.get(Integer.valueOf(id));
            if (aVar2 != null) {
                if (childAt instanceof ConstraintHelper) {
                    aVar2.i((ConstraintHelper) childAt, id, aVar);
                }
                aVar2.h(id, aVar);
            }
        }
    }

    public void r(int i10, int i11, int i12, int i13) {
        if (!this.f٢٤١٤g.containsKey(Integer.valueOf(i10))) {
            this.f٢٤١٤g.put(Integer.valueOf(i10), new a());
        }
        a aVar = (a) this.f٢٤١٤g.get(Integer.valueOf(i10));
        if (aVar == null) {
            return;
        }
        switch (i11) {
            case 1:
                if (i13 == 1) {
                    b bVar = aVar.f٢٤١٩e;
                    bVar.f٢٤٥٥j = i12;
                    bVar.f٢٤٥٧k = -1;
                    return;
                } else if (i13 == 2) {
                    b bVar2 = aVar.f٢٤١٩e;
                    bVar2.f٢٤٥٧k = i12;
                    bVar2.f٢٤٥٥j = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + T(i13) + " undefined");
                }
            case 2:
                if (i13 == 1) {
                    b bVar3 = aVar.f٢٤١٩e;
                    bVar3.f٢٤٥٩l = i12;
                    bVar3.f٢٤٦١m = -1;
                    return;
                } else if (i13 == 2) {
                    b bVar4 = aVar.f٢٤١٩e;
                    bVar4.f٢٤٦١m = i12;
                    bVar4.f٢٤٥٩l = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + T(i13) + " undefined");
                }
            case 3:
                if (i13 == 3) {
                    b bVar5 = aVar.f٢٤١٩e;
                    bVar5.f٢٤٦٣n = i12;
                    bVar5.f٢٤٦٥o = -1;
                    bVar5.f٢٤٧١r = -1;
                    bVar5.f٢٤٧٢s = -1;
                    bVar5.f٢٤٧٣t = -1;
                    return;
                }
                if (i13 == 4) {
                    b bVar6 = aVar.f٢٤١٩e;
                    bVar6.f٢٤٦٥o = i12;
                    bVar6.f٢٤٦٣n = -1;
                    bVar6.f٢٤٧١r = -1;
                    bVar6.f٢٤٧٢s = -1;
                    bVar6.f٢٤٧٣t = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + T(i13) + " undefined");
            case 4:
                if (i13 == 4) {
                    b bVar7 = aVar.f٢٤١٩e;
                    bVar7.f٢٤٦٩q = i12;
                    bVar7.f٢٤٦٧p = -1;
                    bVar7.f٢٤٧١r = -1;
                    bVar7.f٢٤٧٢s = -1;
                    bVar7.f٢٤٧٣t = -1;
                    return;
                }
                if (i13 == 3) {
                    b bVar8 = aVar.f٢٤١٩e;
                    bVar8.f٢٤٦٧p = i12;
                    bVar8.f٢٤٦٩q = -1;
                    bVar8.f٢٤٧١r = -1;
                    bVar8.f٢٤٧٢s = -1;
                    bVar8.f٢٤٧٣t = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + T(i13) + " undefined");
            case 5:
                if (i13 == 5) {
                    b bVar9 = aVar.f٢٤١٩e;
                    bVar9.f٢٤٧١r = i12;
                    bVar9.f٢٤٦٩q = -1;
                    bVar9.f٢٤٦٧p = -1;
                    bVar9.f٢٤٦٣n = -1;
                    bVar9.f٢٤٦٥o = -1;
                    return;
                }
                if (i13 == 3) {
                    b bVar10 = aVar.f٢٤١٩e;
                    bVar10.f٢٤٧٢s = i12;
                    bVar10.f٢٤٦٩q = -1;
                    bVar10.f٢٤٦٧p = -1;
                    bVar10.f٢٤٦٣n = -1;
                    bVar10.f٢٤٦٥o = -1;
                    return;
                }
                if (i13 == 4) {
                    b bVar11 = aVar.f٢٤١٩e;
                    bVar11.f٢٤٧٣t = i12;
                    bVar11.f٢٤٦٩q = -1;
                    bVar11.f٢٤٦٧p = -1;
                    bVar11.f٢٤٦٣n = -1;
                    bVar11.f٢٤٦٥o = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + T(i13) + " undefined");
            case 6:
                if (i13 == 6) {
                    b bVar12 = aVar.f٢٤١٩e;
                    bVar12.f٢٤٧٥v = i12;
                    bVar12.f٢٤٧٤u = -1;
                    return;
                } else if (i13 == 7) {
                    b bVar13 = aVar.f٢٤١٩e;
                    bVar13.f٢٤٧٤u = i12;
                    bVar13.f٢٤٧٥v = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + T(i13) + " undefined");
                }
            case 7:
                if (i13 == 7) {
                    b bVar14 = aVar.f٢٤١٩e;
                    bVar14.f٢٤٧٧x = i12;
                    bVar14.f٢٤٧٦w = -1;
                    return;
                } else if (i13 == 6) {
                    b bVar15 = aVar.f٢٤١٩e;
                    bVar15.f٢٤٧٦w = i12;
                    bVar15.f٢٤٧٧x = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + T(i13) + " undefined");
                }
            default:
                throw new IllegalArgumentException(T(i11) + " to " + T(i13) + " unknown");
        }
    }

    public void s(int i10, int i11, int i12, float f10) {
        b bVar = v(i10).f٢٤١٩e;
        bVar.f٢٤٣٦B = i11;
        bVar.C = i12;
        bVar.D = f10;
    }

    public a w(int i10) {
        if (this.f٢٤١٤g.containsKey(Integer.valueOf(i10))) {
            return (a) this.f٢٤١٤g.get(Integer.valueOf(i10));
        }
        return null;
    }

    public int x(int i10) {
        return v(i10).f٢٤١٩e.f٢٤٤٥e;
    }

    public int[] y() {
        Integer[] numArr = (Integer[]) this.f٢٤١٤g.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = numArr[i10].intValue();
        }
        return iArr;
    }

    public a z(int i10) {
        return v(i10);
    }
}
