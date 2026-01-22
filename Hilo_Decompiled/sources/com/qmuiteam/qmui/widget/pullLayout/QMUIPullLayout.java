package com.qmuiteam.qmui.widget.pullLayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.g0;
import androidx.core.view.i0;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qmuiteam.qmui.R;
import ic.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIPullLayout extends FrameLayout implements g0 {

    /* renamed from: a, reason: collision with root package name */
    private int f١٣١٨٠a;

    /* renamed from: b, reason: collision with root package name */
    private View f١٣١٨١b;

    /* renamed from: c, reason: collision with root package name */
    private l f١٣١٨٢c;

    /* renamed from: d, reason: collision with root package name */
    private g f١٣١٨٣d;

    /* renamed from: e, reason: collision with root package name */
    private g f١٣١٨٤e;

    /* renamed from: f, reason: collision with root package name */
    private g f١٣١٨٥f;

    /* renamed from: g, reason: collision with root package name */
    private g f١٣١٨٦g;

    /* renamed from: h, reason: collision with root package name */
    private final int[] f١٣١٨٧h;

    /* renamed from: i, reason: collision with root package name */
    private i f١٣١٨٨i;

    /* renamed from: j, reason: collision with root package name */
    private Runnable f١٣١٨٩j;

    /* renamed from: k, reason: collision with root package name */
    private OverScroller f١٣١٩٠k;

    /* renamed from: l, reason: collision with root package name */
    private float f١٣١٩١l;

    /* renamed from: m, reason: collision with root package name */
    private int f١٣١٩٢m;

    /* renamed from: n, reason: collision with root package name */
    private int f١٣١٩٣n;

    /* renamed from: o, reason: collision with root package name */
    private final i0 f١٣١٩٤o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f١٣١٩٥a;

        a(View view) {
            this.f١٣١٩٥a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            QMUIPullLayout.this.f١٣١٨٨i.a(this.f١٣١٩٥a);
            QMUIPullLayout.this.f١٣١٨٩j = null;
            QMUIPullLayout.this.l(false);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface b {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface c {
        void a();

        void h(g gVar, int i10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface d {
        int a(g gVar, int i10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class e implements i {

        /* renamed from: a, reason: collision with root package name */
        private static e f١٣١٩٧a;

        private e() {
        }

        public static e b() {
            if (f١٣١٩٧a == null) {
                f١٣١٩٧a = new e();
            }
            return f١٣١٩٧a;
        }

        @Override // com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout.i
        public void a(View view) {
            if (view instanceof RecyclerView) {
                ((RecyclerView) view).stopScroll();
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        private final View f١٣٢٠٩a;

        /* renamed from: b, reason: collision with root package name */
        private final int f١٣٢١٠b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f١٣٢١١c;

        /* renamed from: d, reason: collision with root package name */
        private final float f١٣٢١٢d;

        /* renamed from: e, reason: collision with root package name */
        private final float f١٣٢١٣e;

        /* renamed from: f, reason: collision with root package name */
        private final int f١٣٢١٤f;

        /* renamed from: g, reason: collision with root package name */
        private final int f١٣٢١٥g;

        /* renamed from: h, reason: collision with root package name */
        private final float f١٣٢١٦h;

        /* renamed from: i, reason: collision with root package name */
        private final boolean f١٣٢١٧i;

        /* renamed from: j, reason: collision with root package name */
        private final boolean f١٣٢١٨j;

        /* renamed from: k, reason: collision with root package name */
        private final boolean f١٣٢١٩k;

        /* renamed from: l, reason: collision with root package name */
        private final l f١٣٢٢٠l;

        /* renamed from: m, reason: collision with root package name */
        private final d f١٣٢٢١m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f١٣٢٢٢n = false;

        g(View view, int i10, boolean z10, float f10, int i11, int i12, float f11, boolean z11, float f12, boolean z12, boolean z13, d dVar) {
            this.f١٣٢٠٩a = view;
            this.f١٣٢١٠b = i10;
            this.f١٣٢١١c = z10;
            this.f١٣٢١٢d = f10;
            this.f١٣٢١٧i = z11;
            this.f١٣٢١٣e = f12;
            this.f١٣٢١٤f = i11;
            this.f١٣٢١٦h = f11;
            this.f١٣٢١٥g = i12;
            this.f١٣٢١٨j = z12;
            this.f١٣٢١٩k = z13;
            this.f١٣٢٢١m = dVar;
            this.f١٣٢٢٠l = new l(view);
            q(i11);
        }

        public int j() {
            return this.f١٣٢١٤f;
        }

        public int k() {
            int i10 = this.f١٣٢١٥g;
            if (i10 != 2 && i10 != 8) {
                return this.f١٣٢٠٩a.getWidth();
            }
            return this.f١٣٢٠٩a.getHeight();
        }

        public float l(int i10) {
            float f10 = this.f١٣٢١٢d;
            return Math.min(f10, Math.max(f10 - ((i10 - n()) * this.f١٣٢١٣e), DownloadProgress.UNKNOWN_PROGRESS));
        }

        public float m() {
            return this.f١٣٢١٢d;
        }

        public int n() {
            int i10 = this.f١٣٢١٠b;
            if (i10 == -2) {
                return k() - (j() * 2);
            }
            return i10;
        }

        public boolean o() {
            return this.f١٣٢١١c;
        }

        void p(int i10) {
            q(this.f١٣٢٢١m.a(this, i10));
        }

        void q(int i10) {
            int i11 = this.f١٣٢١٥g;
            if (i11 == 1) {
                this.f١٣٢٢٠l.g(i10);
                return;
            }
            if (i11 == 2) {
                this.f١٣٢٢٠l.h(i10);
            } else if (i11 == 4) {
                this.f١٣٢٢٠l.g(-i10);
            } else {
                this.f١٣٢٢٠l.h(-i10);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        private final View f١٣٢٢٣a;

        /* renamed from: c, reason: collision with root package name */
        private boolean f١٣٢٢٥c;

        /* renamed from: g, reason: collision with root package name */
        private int f١٣٢٢٩g;

        /* renamed from: i, reason: collision with root package name */
        private int f١٣٢٣١i;

        /* renamed from: j, reason: collision with root package name */
        private d f١٣٢٣٢j;

        /* renamed from: b, reason: collision with root package name */
        private int f١٣٢٢٤b = -2;

        /* renamed from: d, reason: collision with root package name */
        private float f١٣٢٢٦d = 0.45f;

        /* renamed from: e, reason: collision with root package name */
        private boolean f١٣٢٢٧e = true;

        /* renamed from: f, reason: collision with root package name */
        private float f١٣٢٢٨f = 0.002f;

        /* renamed from: h, reason: collision with root package name */
        private float f١٣٢٣٠h = 1.5f;

        /* renamed from: k, reason: collision with root package name */
        private boolean f١٣٢٣٣k = false;

        /* renamed from: l, reason: collision with root package name */
        private boolean f١٣٢٣٤l = true;

        public h(View view, int i10) {
            this.f١٣٢٢٣a = view;
            this.f١٣٢٣١i = i10;
        }

        public h c(int i10) {
            this.f١٣٢٢٩g = i10;
            return this;
        }

        g d() {
            if (this.f١٣٢٣٢j == null) {
                this.f١٣٢٣٢j = new com.qmuiteam.qmui.widget.pullLayout.a();
            }
            return new g(this.f١٣٢٢٣a, this.f١٣٢٢٤b, this.f١٣٢٢٥c, this.f١٣٢٢٦d, this.f١٣٢٢٩g, this.f١٣٢٣١i, this.f١٣٢٣٠h, this.f١٣٢٢٧e, this.f١٣٢٢٨f, this.f١٣٢٣٣k, this.f١٣٢٣٤l, this.f١٣٢٣٢j);
        }

        public h e(boolean z10) {
            this.f١٣٢٢٥c = z10;
            return this;
        }

        public h f(boolean z10) {
            this.f١٣٢٢٧e = z10;
            return this;
        }

        public h g(float f10) {
            this.f١٣٢٢٦d = f10;
            return this;
        }

        public h h(float f10) {
            this.f١٣٢٢٨f = f10;
            return this;
        }

        public h i(float f10) {
            this.f١٣٢٣٠h = f10;
            return this;
        }

        public h j(boolean z10) {
            this.f١٣٢٣٤l = z10;
            return this;
        }

        public h k(int i10) {
            this.f١٣٢٢٤b = i10;
            return this;
        }

        public h l(boolean z10) {
            this.f١٣٢٣٣k = z10;
            return this;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface i {
        void a(View view);
    }

    public QMUIPullLayout(Context context) {
        this(context, null);
    }

    private int d(int i10, int[] iArr, int i11) {
        float l10;
        int i12;
        if (i10 > 0 && q(8) && !this.f١٣١٨١b.canScrollVertically(1) && (i11 == 0 || this.f١٣١٨٦g.f١٣٢١٧i)) {
            int d10 = this.f١٣١٨٢c.d();
            if (i11 == 0) {
                l10 = this.f١٣١٨٦g.m();
            } else {
                l10 = this.f١٣١٨٦g.l(-d10);
            }
            int i13 = (int) (i10 * l10);
            if (i13 == 0) {
                return i10;
            }
            if (!this.f١٣١٨٦g.f١٣٢١١c && d10 - i13 < (-this.f١٣١٨٦g.n())) {
                int i14 = (int) (((-this.f١٣١٨٦g.n()) - d10) / l10);
                iArr[1] = iArr[1] + i14;
                i10 -= i14;
                i12 = -this.f١٣١٨٦g.n();
            } else {
                iArr[1] = iArr[1] + i10;
                i10 = 0;
                i12 = d10 - i13;
            }
            setVerOffsetToTargetOffsetHelper(i12);
        }
        return i10;
    }

    private int e(int i10, int[] iArr, int i11) {
        float f10;
        int d10 = this.f١٣١٨٢c.d();
        if (i10 < 0 && q(8) && d10 < 0) {
            if (i11 == 0) {
                f10 = this.f١٣١٨٦g.m();
            } else {
                f10 = 1.0f;
            }
            int i12 = (int) (i10 * f10);
            if (i12 == 0) {
                return i10;
            }
            int i13 = 0;
            if (d10 <= i12) {
                iArr[1] = iArr[1] + i10;
                i13 = d10 - i12;
                i10 = 0;
            } else {
                int i14 = (int) (d10 / f10);
                iArr[1] = iArr[1] + i14;
                i10 -= i14;
            }
            setVerOffsetToTargetOffsetHelper(i13);
        }
        return i10;
    }

    private int f(int i10, int[] iArr, int i11) {
        float l10;
        int i12;
        int c10 = this.f١٣١٨٢c.c();
        if (i10 < 0 && q(1) && !this.f١٣١٨١b.canScrollHorizontally(-1) && (i11 == 0 || this.f١٣١٨٣d.f١٣٢١٧i)) {
            if (i11 == 0) {
                l10 = this.f١٣١٨٣d.m();
            } else {
                l10 = this.f١٣١٨٣d.l(c10);
            }
            int i13 = (int) (i10 * l10);
            if (i13 == 0) {
                return i10;
            }
            if (!this.f١٣١٨٣d.f١٣٢١١c && (-i13) > this.f١٣١٨٣d.n() - c10) {
                int n10 = (int) ((c10 - this.f١٣١٨٣d.n()) / l10);
                iArr[0] = iArr[0] + n10;
                i10 -= n10;
                i12 = this.f١٣١٨٣d.n();
            } else {
                iArr[0] = iArr[0] + i10;
                i12 = c10 - i13;
                i10 = 0;
            }
            setHorOffsetToTargetOffsetHelper(i12);
        }
        return i10;
    }

    private int g(int i10, int[] iArr, int i11) {
        float f10;
        int c10 = this.f١٣١٨٢c.c();
        if (i10 > 0 && q(1) && c10 > 0) {
            if (i11 == 0) {
                f10 = this.f١٣١٨٣d.m();
            } else {
                f10 = 1.0f;
            }
            int i12 = (int) (i10 * f10);
            if (i12 == 0) {
                return i10;
            }
            int i13 = 0;
            if (c10 >= i12) {
                iArr[0] = iArr[0] + i10;
                i13 = c10 - i12;
                i10 = 0;
            } else {
                int i14 = (int) (c10 / f10);
                iArr[0] = iArr[0] + i14;
                i10 -= i14;
            }
            setHorOffsetToTargetOffsetHelper(i13);
        }
        return i10;
    }

    private int h(int i10, int[] iArr, int i11) {
        float f10;
        int c10 = this.f١٣١٨٢c.c();
        if (i10 < 0 && q(4) && c10 < 0) {
            if (i11 == 0) {
                f10 = this.f١٣١٨٥f.m();
            } else {
                f10 = 1.0f;
            }
            int i12 = (int) (i10 * f10);
            if (i12 == 0) {
                return i10;
            }
            int i13 = 0;
            if (c10 <= i10) {
                iArr[0] = iArr[0] + i10;
                i13 = c10 - i12;
                i10 = 0;
            } else {
                int i14 = (int) (c10 / f10);
                iArr[0] = iArr[0] + i14;
                i10 -= i14;
            }
            setHorOffsetToTargetOffsetHelper(i13);
        }
        return i10;
    }

    private int i(int i10, int[] iArr, int i11) {
        float l10;
        int i12;
        if (i10 > 0 && q(4) && !this.f١٣١٨١b.canScrollHorizontally(1) && (i11 == 0 || this.f١٣١٨٥f.f١٣٢١٧i)) {
            int c10 = this.f١٣١٨٢c.c();
            if (i11 == 0) {
                l10 = this.f١٣١٨٥f.m();
            } else {
                l10 = this.f١٣١٨٥f.l(-c10);
            }
            int i13 = (int) (i10 * l10);
            if (i13 == 0) {
                return i10;
            }
            if (!this.f١٣١٨٥f.f١٣٢١١c && c10 - i13 < (-this.f١٣١٨٥f.n())) {
                int i14 = (int) (((-this.f١٣١٨٥f.n()) - c10) / l10);
                iArr[0] = iArr[0] + i14;
                i10 -= i14;
                i12 = -this.f١٣١٨٥f.n();
            } else {
                iArr[0] = iArr[0] + i10;
                i12 = c10 - i13;
                i10 = 0;
            }
            setHorOffsetToTargetOffsetHelper(i12);
        }
        return i10;
    }

    private int j(int i10, int[] iArr, int i11) {
        float f10;
        int d10 = this.f١٣١٨٢c.d();
        if (i10 > 0 && q(2) && d10 > 0) {
            if (i11 == 0) {
                f10 = this.f١٣١٨٤e.m();
            } else {
                f10 = 1.0f;
            }
            int i12 = (int) (i10 * f10);
            if (i12 == 0) {
                return i10;
            }
            int i13 = 0;
            if (d10 >= i12) {
                iArr[1] = iArr[1] + i10;
                i13 = d10 - i12;
                i10 = 0;
            } else {
                int i14 = (int) (d10 / f10);
                iArr[1] = iArr[1] + i14;
                i10 -= i14;
            }
            setVerOffsetToTargetOffsetHelper(i13);
        }
        return i10;
    }

    private int k(int i10, int[] iArr, int i11) {
        float l10;
        int i12;
        if (i10 < 0 && q(2) && !this.f١٣١٨١b.canScrollVertically(-1) && (i11 == 0 || this.f١٣١٨٤e.f١٣٢١٧i)) {
            int d10 = this.f١٣١٨٢c.d();
            if (i11 == 0) {
                l10 = this.f١٣١٨٤e.m();
            } else {
                l10 = this.f١٣١٨٤e.l(d10);
            }
            int i13 = (int) (i10 * l10);
            if (i13 == 0) {
                return i10;
            }
            if (!this.f١٣١٨٤e.f١٣٢١١c && (-i13) > this.f١٣١٨٤e.n() - d10) {
                int n10 = (int) ((d10 - this.f١٣١٨٤e.n()) / l10);
                iArr[1] = iArr[1] + n10;
                i10 -= n10;
                i12 = this.f١٣١٨٦g.n();
            } else {
                iArr[1] = iArr[1] + i10;
                i10 = 0;
                i12 = d10 - i13;
            }
            setVerOffsetToTargetOffsetHelper(i12);
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z10) {
        if (this.f١٣١٨١b == null) {
            return;
        }
        this.f١٣١٩٠k.abortAnimation();
        int c10 = this.f١٣١٨٢c.c();
        int d10 = this.f١٣١٨٢c.d();
        int i10 = 0;
        if (this.f١٣١٨٣d != null && q(1) && c10 > 0) {
            this.f١٣١٩٣n = 4;
            if (!z10) {
                int n10 = this.f١٣١٨٣d.n();
                if (c10 == n10) {
                    r(this.f١٣١٨٣d);
                    return;
                }
                if (c10 > n10) {
                    if (!this.f١٣١٨٣d.f١٣٢١٩k) {
                        this.f١٣١٩٣n = 3;
                        r(this.f١٣١٨٣d);
                        return;
                    } else {
                        if (!this.f١٣١٨٣d.f١٣٢١٨j) {
                            this.f١٣١٩٣n = 3;
                            r(this.f١٣١٨٣d);
                        } else {
                            this.f١٣١٩٣n = 2;
                        }
                        i10 = n10;
                    }
                }
            }
            int i11 = i10 - c10;
            this.f١٣١٩٠k.startScroll(c10, d10, i11, 0, v(this.f١٣١٨٣d, i11));
            postInvalidateOnAnimation();
            return;
        }
        if (this.f١٣١٨٥f != null && q(4) && c10 < 0) {
            this.f١٣١٩٣n = 4;
            if (!z10) {
                int i12 = -this.f١٣١٨٥f.n();
                if (c10 == i12) {
                    this.f١٣١٩٣n = 3;
                    r(this.f١٣١٨٥f);
                    return;
                } else if (c10 < i12) {
                    if (!this.f١٣١٨٥f.f١٣٢١٩k) {
                        this.f١٣١٩٣n = 3;
                        r(this.f١٣١٨٥f);
                        return;
                    } else {
                        if (!this.f١٣١٨٥f.f١٣٢١٨j) {
                            this.f١٣١٩٣n = 3;
                            r(this.f١٣١٨٥f);
                        } else {
                            this.f١٣١٩٣n = 2;
                        }
                        i10 = i12;
                    }
                }
            }
            int i13 = i10 - c10;
            this.f١٣١٩٠k.startScroll(c10, d10, i13, 0, v(this.f١٣١٨٥f, i13));
            postInvalidateOnAnimation();
            return;
        }
        if (this.f١٣١٨٤e != null && q(2) && d10 > 0) {
            this.f١٣١٩٣n = 4;
            if (!z10) {
                int n11 = this.f١٣١٨٤e.n();
                if (d10 == n11) {
                    this.f١٣١٩٣n = 3;
                    r(this.f١٣١٨٤e);
                    return;
                } else if (d10 > n11) {
                    if (!this.f١٣١٨٤e.f١٣٢١٩k) {
                        this.f١٣١٩٣n = 3;
                        r(this.f١٣١٨٤e);
                        return;
                    } else {
                        if (!this.f١٣١٨٤e.f١٣٢١٨j) {
                            this.f١٣١٩٣n = 3;
                            r(this.f١٣١٨٤e);
                        } else {
                            this.f١٣١٩٣n = 2;
                        }
                        i10 = n11;
                    }
                }
            }
            int i14 = i10 - d10;
            this.f١٣١٩٠k.startScroll(c10, d10, c10, i14, v(this.f١٣١٨٤e, i14));
            postInvalidateOnAnimation();
            return;
        }
        if (this.f١٣١٨٦g != null && q(8) && d10 < 0) {
            this.f١٣١٩٣n = 4;
            if (!z10) {
                int i15 = -this.f١٣١٨٦g.n();
                if (d10 == i15) {
                    r(this.f١٣١٨٦g);
                    return;
                }
                if (d10 < i15) {
                    if (!this.f١٣١٨٦g.f١٣٢١٩k) {
                        this.f١٣١٩٣n = 3;
                        r(this.f١٣١٨٦g);
                        return;
                    } else {
                        if (!this.f١٣١٨٦g.f١٣٢١٨j) {
                            this.f١٣١٩٣n = 3;
                            r(this.f١٣١٨٦g);
                        } else {
                            this.f١٣١٩٣n = 2;
                        }
                        i10 = i15;
                    }
                }
            }
            int i16 = i10 - d10;
            this.f١٣١٩٠k.startScroll(c10, d10, c10, i16, v(this.f١٣١٨٦g, i16));
            postInvalidateOnAnimation();
            return;
        }
        this.f١٣١٩٣n = 0;
    }

    private void m(View view, int i10, int i11, int i12) {
        if (this.f١٣١٨٩j == null && i12 != 0) {
            if ((i11 < 0 && !this.f١٣١٨١b.canScrollVertically(-1)) || ((i11 > 0 && !this.f١٣١٨١b.canScrollVertically(1)) || ((i10 < 0 && !this.f١٣١٨١b.canScrollHorizontally(-1)) || (i10 > 0 && !this.f١٣١٨١b.canScrollHorizontally(1))))) {
                a aVar = new a(view);
                this.f١٣١٨٩j = aVar;
                post(aVar);
            }
        }
    }

    private g o(int i10) {
        if (i10 == 1) {
            return this.f١٣١٨٣d;
        }
        if (i10 == 2) {
            return this.f١٣١٨٤e;
        }
        if (i10 == 4) {
            return this.f١٣١٨٥f;
        }
        if (i10 == 8) {
            return this.f١٣١٨٦g;
        }
        return null;
    }

    private void p(View view) {
        this.f١٣١٨١b = view;
        this.f١٣١٨٢c = new l(view);
    }

    private void r(g gVar) {
        if (!gVar.f١٣٢٢٢n) {
            gVar.f١٣٢٢٢n = true;
            if (gVar.f١٣٢٠٩a instanceof c) {
                ((c) gVar.f١٣٢٠٩a).a();
            }
        }
    }

    private void setHorOffsetToTargetOffsetHelper(int i10) {
        this.f١٣١٨٢c.g(i10);
        s(i10);
        g gVar = this.f١٣١٨٣d;
        if (gVar != null) {
            gVar.p(i10);
            if (this.f١٣١٨٣d.f١٣٢٠٩a instanceof c) {
                ((c) this.f١٣١٨٣d.f١٣٢٠٩a).h(this.f١٣١٨٣d, i10);
            }
        }
        g gVar2 = this.f١٣١٨٥f;
        if (gVar2 != null) {
            int i11 = -i10;
            gVar2.p(i11);
            if (this.f١٣١٨٥f.f١٣٢٠٩a instanceof c) {
                ((c) this.f١٣١٨٥f.f١٣٢٠٩a).h(this.f١٣١٨٥f, i11);
            }
        }
    }

    private void setVerOffsetToTargetOffsetHelper(int i10) {
        this.f١٣١٨٢c.h(i10);
        t(i10);
        g gVar = this.f١٣١٨٤e;
        if (gVar != null) {
            gVar.p(i10);
            if (this.f١٣١٨٤e.f١٣٢٠٩a instanceof c) {
                ((c) this.f١٣١٨٤e.f١٣٢٠٩a).h(this.f١٣١٨٤e, i10);
            }
        }
        g gVar2 = this.f١٣١٨٦g;
        if (gVar2 != null) {
            int i11 = -i10;
            gVar2.p(i11);
            if (this.f١٣١٨٦g.f١٣٢٠٩a instanceof c) {
                ((c) this.f١٣١٨٦g.f١٣٢٠٩a).h(this.f١٣١٨٦g, i11);
            }
        }
    }

    private void u() {
        Runnable runnable = this.f١٣١٨٩j;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f١٣١٨٩j = null;
        }
    }

    private int v(g gVar, int i10) {
        return Math.max(this.f١٣١٩٢m, Math.abs((int) (gVar.f١٣٢١٦h * i10)));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof f) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f١٣١٩٠k.computeScrollOffset()) {
            if (this.f١٣١٩٠k.isFinished()) {
                int i10 = this.f١٣١٩٣n;
                if (i10 == 4) {
                    this.f١٣١٩٣n = 0;
                    return;
                }
                if (i10 == 3) {
                    return;
                }
                if (i10 == 6) {
                    l(false);
                    return;
                }
                if (i10 == 2) {
                    this.f١٣١٩٣n = 3;
                    if (this.f١٣١٨٣d != null && q(1) && this.f١٣١٩٠k.getFinalX() == this.f١٣١٨٣d.n()) {
                        r(this.f١٣١٨٣d);
                    }
                    if (this.f١٣١٨٥f != null && q(4) && this.f١٣١٩٠k.getFinalX() == (-this.f١٣١٨٥f.n())) {
                        r(this.f١٣١٨٥f);
                    }
                    if (this.f١٣١٨٤e != null && q(2) && this.f١٣١٩٠k.getFinalY() == this.f١٣١٨٤e.n()) {
                        r(this.f١٣١٨٤e);
                    }
                    if (this.f١٣١٨٦g != null && q(8) && this.f١٣١٩٠k.getFinalY() == (-this.f١٣١٨٦g.n())) {
                        r(this.f١٣١٨٦g);
                    }
                    setHorOffsetToTargetOffsetHelper(this.f١٣١٩٠k.getCurrX());
                    setVerOffsetToTargetOffsetHelper(this.f١٣١٩٠k.getCurrY());
                    return;
                }
                return;
            }
            setHorOffsetToTargetOffsetHelper(this.f١٣١٩٠k.getCurrX());
            setVerOffsetToTargetOffsetHelper(this.f١٣١٩٠k.getCurrY());
            postInvalidateOnAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new f(layoutParams);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        String str;
        super.onFinishInflate();
        int i10 = 0;
        boolean z10 = false;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.f١٣١٩٨a) {
                if (!z10) {
                    setTargetView(childAt);
                    z10 = true;
                } else {
                    throw new RuntimeException("More than one view in xml are marked by qmui_is_target = true.");
                }
            } else {
                int i12 = fVar.f١٣١٩٩b;
                if ((i10 & i12) != 0) {
                    if (i12 != 1) {
                        if (i12 != 2) {
                            if (i12 != 4) {
                                if (i12 == 8) {
                                    str = "bottom";
                                } else {
                                    str = "";
                                }
                            } else {
                                str = "right";
                            }
                        } else {
                            str = ViewHierarchyConstants.DIMENSION_TOP_KEY;
                        }
                    } else {
                        str = ViewHierarchyConstants.DIMENSION_LEFT_KEY;
                    }
                    throw new RuntimeException("More than one view in xml marked by qmui_layout_edge = " + str);
                }
                i10 |= i12;
                w(childAt, fVar);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        View view = this.f١٣١٨١b;
        if (view != null) {
            view.layout(0, 0, i14, i15);
            this.f١٣١٨٢c.e();
        }
        g gVar = this.f١٣١٨٣d;
        if (gVar != null) {
            View view2 = gVar.f١٣٢٠٩a;
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight = view2.getMeasuredHeight();
            int i16 = (i15 - measuredHeight) / 2;
            view2.layout(-measuredWidth, i16, 0, measuredHeight + i16);
            this.f١٣١٨٣d.f١٣٢٢٠l.e();
        }
        g gVar2 = this.f١٣١٨٤e;
        if (gVar2 != null) {
            View view3 = gVar2.f١٣٢٠٩a;
            int measuredWidth2 = view3.getMeasuredWidth();
            int i17 = (i14 - measuredWidth2) / 2;
            view3.layout(i17, -view3.getMeasuredHeight(), measuredWidth2 + i17, 0);
            this.f١٣١٨٤e.f١٣٢٢٠l.e();
        }
        g gVar3 = this.f١٣١٨٥f;
        if (gVar3 != null) {
            View view4 = gVar3.f١٣٢٠٩a;
            int measuredWidth3 = view4.getMeasuredWidth();
            int measuredHeight2 = view4.getMeasuredHeight();
            int i18 = (i15 - measuredHeight2) / 2;
            view4.layout(i14, i18, measuredWidth3 + i14, measuredHeight2 + i18);
            this.f١٣١٨٥f.f١٣٢٢٠l.e();
        }
        g gVar4 = this.f١٣١٨٦g;
        if (gVar4 != null) {
            View view5 = gVar4.f١٣٢٠٩a;
            int measuredWidth4 = view5.getMeasuredWidth();
            int i19 = (i14 - measuredWidth4) / 2;
            view5.layout(i19, i15, measuredWidth4 + i19, view5.getMeasuredHeight() + i15);
            this.f١٣١٨٦g.f١٣٢٢٠l.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        int i10;
        int n10;
        int i11;
        int n11;
        int c10 = this.f١٣١٨٢c.c();
        int d10 = this.f١٣١٨٢c.d();
        if (this.f١٣١٨٣d != null && q(1)) {
            if (f10 < DownloadProgress.UNKNOWN_PROGRESS && !this.f١٣١٨١b.canScrollHorizontally(-1)) {
                this.f١٣١٩٣n = 6;
                float f12 = f10 / this.f١٣١٩١l;
                if (this.f١٣١٨٣d.o()) {
                    n11 = Integer.MAX_VALUE;
                } else {
                    n11 = this.f١٣١٨٣d.n();
                }
                this.f١٣١٩٠k.fling(c10, d10, (int) (-f12), 0, 0, n11, d10, d10);
                postInvalidateOnAnimation();
                return true;
            }
            if (f10 > DownloadProgress.UNKNOWN_PROGRESS && c10 > 0) {
                this.f١٣١٩٣n = 4;
                this.f١٣١٩٠k.startScroll(c10, d10, -c10, 0, v(this.f١٣١٨٣d, c10));
                postInvalidateOnAnimation();
                return true;
            }
        }
        if (this.f١٣١٨٥f != null && q(4)) {
            if (f10 > DownloadProgress.UNKNOWN_PROGRESS && !this.f١٣١٨١b.canScrollHorizontally(1)) {
                this.f١٣١٩٣n = 6;
                float f13 = f10 / this.f١٣١٩١l;
                if (this.f١٣١٨٥f.o()) {
                    i11 = Integer.MIN_VALUE;
                } else {
                    i11 = -this.f١٣١٨٥f.n();
                }
                this.f١٣١٩٠k.fling(c10, d10, (int) (-f13), 0, i11, 0, d10, d10);
                postInvalidateOnAnimation();
                return true;
            }
            if (f10 < DownloadProgress.UNKNOWN_PROGRESS && c10 < 0) {
                this.f١٣١٩٣n = 4;
                this.f١٣١٩٠k.startScroll(c10, d10, -c10, 0, v(this.f١٣١٨٥f, c10));
                postInvalidateOnAnimation();
                return true;
            }
        }
        if (this.f١٣١٨٤e != null && q(2)) {
            if (f11 < DownloadProgress.UNKNOWN_PROGRESS && !this.f١٣١٨١b.canScrollVertically(-1)) {
                this.f١٣١٩٣n = 6;
                float f14 = f11 / this.f١٣١٩١l;
                if (this.f١٣١٨٤e.o()) {
                    n10 = Integer.MAX_VALUE;
                } else {
                    n10 = this.f١٣١٨٤e.n();
                }
                this.f١٣١٩٠k.fling(c10, d10, 0, (int) (-f14), c10, c10, 0, n10);
                postInvalidateOnAnimation();
                return true;
            }
            if (f11 > DownloadProgress.UNKNOWN_PROGRESS && d10 > 0) {
                this.f١٣١٩٣n = 4;
                this.f١٣١٩٠k.startScroll(c10, d10, 0, -d10, v(this.f١٣١٨٤e, d10));
                postInvalidateOnAnimation();
                return true;
            }
        }
        if (this.f١٣١٨٦g != null && q(8)) {
            if (f11 > DownloadProgress.UNKNOWN_PROGRESS && !this.f١٣١٨١b.canScrollVertically(1)) {
                this.f١٣١٩٣n = 6;
                float f15 = f11 / this.f١٣١٩١l;
                if (this.f١٣١٨٦g.o()) {
                    i10 = Integer.MIN_VALUE;
                } else {
                    i10 = -this.f١٣١٨٦g.n();
                }
                this.f١٣١٩٠k.fling(c10, d10, 0, (int) (-f15), c10, c10, i10, 0);
                postInvalidateOnAnimation();
                return true;
            }
            if (f11 < DownloadProgress.UNKNOWN_PROGRESS && d10 < 0) {
                this.f١٣١٩٣n = 4;
                this.f١٣١٩٠k.startScroll(c10, d10, 0, -d10, v(this.f١٣١٨٦g, d10));
                postInvalidateOnAnimation();
                return true;
            }
        }
        this.f١٣١٩٣n = 5;
        return super.onNestedPreFling(view, f10, f11);
    }

    @Override // androidx.core.view.f0
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        int e10 = e(k(d(j(i11, iArr, i12), iArr, i12), iArr, i12), iArr, i12);
        int h10 = h(f(i(g(i10, iArr, i12), iArr, i12), iArr, i12), iArr, i12);
        if (i10 == h10 && i11 == e10 && this.f١٣١٩٣n == 5) {
            m(view, h10, e10, i12);
        }
    }

    @Override // androidx.core.view.g0
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        int e10 = e(k(d(j(i13, iArr, i14), iArr, i14), iArr, i14), iArr, i14);
        int h10 = h(f(i(g(i12, iArr, i14), iArr, i14), iArr, i14), iArr, i14);
        if (e10 == i13 && h10 == i12 && this.f١٣١٩٣n == 5) {
            m(view, h10, e10, i14);
        }
    }

    @Override // androidx.core.view.f0
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            u();
            this.f١٣١٩٠k.abortAnimation();
            this.f١٣١٩٣n = 1;
        }
        this.f١٣١٩٤o.b(view, view2, i10);
    }

    @Override // androidx.core.view.f0
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        if (this.f١٣١٨١b == view2 && i10 == 1 && (q(1) || q(4))) {
            return true;
        }
        return i10 == 2 && (q(2) || q(8));
    }

    @Override // androidx.core.view.f0
    public void onStopNestedScroll(View view, int i10) {
        int i11 = this.f١٣١٩٣n;
        if (i11 == 1) {
            l(false);
        } else if (i11 == 5 && i10 != 0) {
            u();
            l(false);
        }
    }

    public boolean q(int i10) {
        if ((this.f١٣١٨٠a & i10) == i10 && o(i10) != null) {
            return true;
        }
        return false;
    }

    protected void s(int i10) {
    }

    public void setActionListener(b bVar) {
    }

    public void setActionView(h hVar) {
        if (hVar.f١٣٢٢٣a.getParent() == this) {
            if (hVar.f١٣٢٢٣a.getParent() == null) {
                ViewGroup.LayoutParams layoutParams = hVar.f١٣٢٢٣a.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-2, -2);
                }
                addView(hVar.f١٣٢٢٣a, layoutParams);
            }
            if (hVar.f١٣٢٣١i == 1) {
                this.f١٣١٨٣d = hVar.d();
                return;
            }
            if (hVar.f١٣٢٣١i == 2) {
                this.f١٣١٨٤e = hVar.d();
                return;
            } else if (hVar.f١٣٢٣١i == 4) {
                this.f١٣١٨٥f = hVar.d();
                return;
            } else {
                if (hVar.f١٣٢٣١i == 8) {
                    this.f١٣١٨٦g = hVar.d();
                    return;
                }
                return;
            }
        }
        throw new RuntimeException("Action view already exists other parent view.");
    }

    public void setEnabledEdges(int i10) {
        this.f١٣١٨٠a = i10;
    }

    public void setMinScrollDuration(int i10) {
        this.f١٣١٩٢m = i10;
    }

    public void setNestedPreFlingVelocityScaleDown(float f10) {
        this.f١٣١٩١l = f10;
    }

    public void setStopTargetViewFlingImpl(i iVar) {
        this.f١٣١٨٨i = iVar;
    }

    public void setTargetView(View view) {
        if (view.getParent() == this) {
            if (view.getParent() == null) {
                addView(view, new f(-1, -1));
            }
            p(view);
            return;
        }
        throw new RuntimeException("Target already exists other parent view.");
    }

    protected void t(int i10) {
    }

    public void w(View view, f fVar) {
        h c10 = new h(view, fVar.f١٣١٩٩b).e(fVar.f١٣٢٠١d).g(fVar.f١٣٢٠٢e).f(fVar.f١٣٢٠٣f).h(fVar.f١٣٢٠٤g).i(fVar.f١٣٢٠٦i).k(fVar.f١٣٢٠٠c).l(fVar.f١٣٢٠٧j).j(fVar.f١٣٢٠٨k).c(fVar.f١٣٢٠٥h);
        view.setLayoutParams(fVar);
        setActionView(c10);
    }

    public QMUIPullLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUIPullLayoutStyle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    public QMUIPullLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣١٨٣d = null;
        this.f١٣١٨٤e = null;
        this.f١٣١٨٥f = null;
        this.f١٣١٨٦g = null;
        this.f١٣١٨٧h = new int[2];
        this.f١٣١٨٨i = e.b();
        this.f١٣١٨٩j = null;
        this.f١٣١٩١l = 10.0f;
        this.f١٣١٩٢m = 300;
        this.f١٣١٩٣n = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIPullLayout, i10, 0);
        this.f١٣١٨٠a = obtainStyledAttributes.getInt(R.styleable.QMUIPullLayout_qmui_pull_enable_edge, 15);
        obtainStyledAttributes.recycle();
        this.f١٣١٩٤o = new i0(this);
        this.f١٣١٩٠k = new OverScroller(context, yb.a.f١٩٢٣٨h);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return onStartNestedScroll(view, view2, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        onNestedScrollAccepted(view, view2, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        onNestedPreScroll(view, i10, i11, iArr, 0);
    }

    @Override // androidx.core.view.f0
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        onNestedScroll(view, i10, i11, i12, i13, i14, this.f١٣١٨٧h);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        onNestedScroll(view, i10, i11, i12, i13, 0);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class f extends FrameLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public boolean f١٣١٩٨a;

        /* renamed from: b, reason: collision with root package name */
        public int f١٣١٩٩b;

        /* renamed from: c, reason: collision with root package name */
        public int f١٣٢٠٠c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f١٣٢٠١d;

        /* renamed from: e, reason: collision with root package name */
        public float f١٣٢٠٢e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f١٣٢٠٣f;

        /* renamed from: g, reason: collision with root package name */
        public float f١٣٢٠٤g;

        /* renamed from: h, reason: collision with root package name */
        public int f١٣٢٠٥h;

        /* renamed from: i, reason: collision with root package name */
        public float f١٣٢٠٦i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f١٣٢٠٧j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f١٣٢٠٨k;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f١٣١٩٨a = false;
            this.f١٣١٩٩b = 2;
            this.f١٣٢٠٠c = -2;
            this.f١٣٢٠١d = false;
            this.f١٣٢٠٢e = 0.45f;
            this.f١٣٢٠٣f = true;
            this.f١٣٢٠٤g = 0.002f;
            this.f١٣٢٠٥h = 0;
            this.f١٣٢٠٦i = 1.5f;
            this.f١٣٢٠٧j = false;
            this.f١٣٢٠٨k = true;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIPullLayout_Layout);
            boolean z10 = obtainStyledAttributes.getBoolean(R.styleable.QMUIPullLayout_Layout_qmui_is_target, false);
            this.f١٣١٩٨a = z10;
            if (!z10) {
                this.f١٣١٩٩b = obtainStyledAttributes.getInteger(R.styleable.QMUIPullLayout_Layout_qmui_pull_edge, 2);
                try {
                    this.f١٣٢٠٠c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIPullLayout_Layout_qmui_target_view_trigger_offset, -2);
                } catch (Exception unused) {
                    if (obtainStyledAttributes.getInt(R.styleable.QMUIPullLayout_Layout_qmui_target_view_trigger_offset, -2) == -2) {
                        this.f١٣٢٠٠c = -2;
                    }
                }
                this.f١٣٢٠١d = obtainStyledAttributes.getBoolean(R.styleable.QMUIPullLayout_Layout_qmui_can_over_pull, false);
                this.f١٣٢٠٢e = obtainStyledAttributes.getFloat(R.styleable.QMUIPullLayout_Layout_qmui_pull_rate, this.f١٣٢٠٢e);
                this.f١٣٢٠٣f = obtainStyledAttributes.getBoolean(R.styleable.QMUIPullLayout_Layout_qmui_need_receive_fling_from_target_view, true);
                this.f١٣٢٠٤g = obtainStyledAttributes.getFloat(R.styleable.QMUIPullLayout_Layout_qmui_received_fling_fraction, this.f١٣٢٠٤g);
                this.f١٣٢٠٥h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIPullLayout_Layout_qmui_action_view_init_offset, 0);
                this.f١٣٢٠٦i = obtainStyledAttributes.getFloat(R.styleable.QMUIPullLayout_Layout_qmui_scroll_speed_per_pixel, this.f١٣٢٠٦i);
                this.f١٣٢٠٧j = obtainStyledAttributes.getBoolean(R.styleable.QMUIPullLayout_Layout_qmui_trigger_until_scroll_to_trigger_offset, false);
                this.f١٣٢٠٨k = obtainStyledAttributes.getBoolean(R.styleable.QMUIPullLayout_Layout_qmui_scroll_to_trigger_offset_after_touch_up, true);
            }
            obtainStyledAttributes.recycle();
        }

        public f(int i10, int i11) {
            super(i10, i11);
            this.f١٣١٩٨a = false;
            this.f١٣١٩٩b = 2;
            this.f١٣٢٠٠c = -2;
            this.f١٣٢٠١d = false;
            this.f١٣٢٠٢e = 0.45f;
            this.f١٣٢٠٣f = true;
            this.f١٣٢٠٤g = 0.002f;
            this.f١٣٢٠٥h = 0;
            this.f١٣٢٠٦i = 1.5f;
            this.f١٣٢٠٧j = false;
            this.f١٣٢٠٨k = true;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f١٣١٩٨a = false;
            this.f١٣١٩٩b = 2;
            this.f١٣٢٠٠c = -2;
            this.f١٣٢٠١d = false;
            this.f١٣٢٠٢e = 0.45f;
            this.f١٣٢٠٣f = true;
            this.f١٣٢٠٤g = 0.002f;
            this.f١٣٢٠٥h = 0;
            this.f١٣٢٠٦i = 1.5f;
            this.f١٣٢٠٧j = false;
            this.f١٣٢٠٨k = true;
        }
    }
}
