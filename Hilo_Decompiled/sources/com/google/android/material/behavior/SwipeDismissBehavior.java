package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d1;
import com.amazonaws.services.s3.internal.Constants;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import m2.g0;
import m2.j0;
import s2.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c {

    /* renamed from: a, reason: collision with root package name */
    s2.c f٨٣٣٠a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f٨٣٣١b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٨٣٣٢c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٨٣٣٤e;

    /* renamed from: d, reason: collision with root package name */
    private float f٨٣٣٣d = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: f, reason: collision with root package name */
    int f٨٣٣٥f = 2;

    /* renamed from: g, reason: collision with root package name */
    float f٨٣٣٦g = 0.5f;

    /* renamed from: h, reason: collision with root package name */
    float f٨٣٣٧h = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: i, reason: collision with root package name */
    float f٨٣٣٨i = 0.5f;

    /* renamed from: j, reason: collision with root package name */
    private final c.AbstractC٠٢٢٦c f٨٣٣٩j = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends c.AbstractC٠٢٢٦c {

        /* renamed from: a, reason: collision with root package name */
        private int f٨٣٤٠a;

        /* renamed from: b, reason: collision with root package name */
        private int f٨٣٤١b = -1;

        a() {
        }

        private boolean a(View view, float f10) {
            boolean z10;
            if (f10 != DownloadProgress.UNKNOWN_PROGRESS) {
                if (view.getLayoutDirection() == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                int i10 = SwipeDismissBehavior.this.f٨٣٣٥f;
                if (i10 == 2) {
                    return true;
                }
                if (i10 == 0) {
                    if (z10) {
                        if (f10 >= DownloadProgress.UNKNOWN_PROGRESS) {
                            return false;
                        }
                    } else if (f10 <= DownloadProgress.UNKNOWN_PROGRESS) {
                        return false;
                    }
                    return true;
                }
                if (i10 != 1) {
                    return false;
                }
                if (z10) {
                    if (f10 <= DownloadProgress.UNKNOWN_PROGRESS) {
                        return false;
                    }
                } else if (f10 >= DownloadProgress.UNKNOWN_PROGRESS) {
                    return false;
                }
                return true;
            }
            if (Math.abs(view.getLeft() - this.f٨٣٤٠a) < Math.round(view.getWidth() * SwipeDismissBehavior.this.f٨٣٣٦g)) {
                return false;
            }
            return true;
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            boolean z10;
            int width;
            int width2;
            int width3;
            if (view.getLayoutDirection() == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            int i12 = SwipeDismissBehavior.this.f٨٣٣٥f;
            if (i12 == 0) {
                if (z10) {
                    width = this.f٨٣٤٠a - view.getWidth();
                    width2 = this.f٨٣٤٠a;
                } else {
                    width = this.f٨٣٤٠a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i12 == 1) {
                if (z10) {
                    width = this.f٨٣٤٠a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                } else {
                    width = this.f٨٣٤٠a - view.getWidth();
                    width2 = this.f٨٣٤٠a;
                }
            } else {
                width = this.f٨٣٤٠a - view.getWidth();
                width2 = view.getWidth() + this.f٨٣٤٠a;
            }
            return SwipeDismissBehavior.N(width, i10, width2);
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public int clampViewPositionVertical(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onViewCaptured(View view, int i10) {
            this.f٨٣٤١b = i10;
            this.f٨٣٤٠a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior.this.f٨٣٣٢c = true;
                parent.requestDisallowInterceptTouchEvent(true);
                SwipeDismissBehavior.this.f٨٣٣٢c = false;
            }
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onViewDragStateChanged(int i10) {
            SwipeDismissBehavior.this.getClass();
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
            float width = view.getWidth() * SwipeDismissBehavior.this.f٨٣٣٧h;
            float width2 = view.getWidth() * SwipeDismissBehavior.this.f٨٣٣٨i;
            float abs = Math.abs(i10 - this.f٨٣٤٠a);
            if (abs <= width) {
                view.setAlpha(1.0f);
            } else if (abs >= width2) {
                view.setAlpha(DownloadProgress.UNKNOWN_PROGRESS);
            } else {
                view.setAlpha(SwipeDismissBehavior.M(DownloadProgress.UNKNOWN_PROGRESS, 1.0f - SwipeDismissBehavior.P(width, width2, abs), 1.0f));
            }
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onViewReleased(View view, float f10, float f11) {
            int i10;
            boolean z10;
            this.f٨٣٤١b = -1;
            int width = view.getWidth();
            if (a(view, f10)) {
                if (f10 >= DownloadProgress.UNKNOWN_PROGRESS) {
                    int left = view.getLeft();
                    int i11 = this.f٨٣٤٠a;
                    if (left >= i11) {
                        i10 = i11 + width;
                        z10 = true;
                    }
                }
                i10 = this.f٨٣٤٠a - width;
                z10 = true;
            } else {
                i10 = this.f٨٣٤٠a;
                z10 = false;
            }
            if (SwipeDismissBehavior.this.f٨٣٣٠a.P(i10, view.getTop())) {
                view.postOnAnimation(new d(view, z10));
            } else if (z10) {
                SwipeDismissBehavior.this.getClass();
            }
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public boolean tryCaptureView(View view, int i10) {
            int i11 = this.f٨٣٤١b;
            if ((i11 == -1 || i11 == i10) && SwipeDismissBehavior.this.L(view)) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b implements j0 {
        b() {
        }

        @Override // m2.j0
        public boolean perform(View view, j0.a aVar) {
            int width;
            boolean z10 = false;
            if (!SwipeDismissBehavior.this.L(view)) {
                return false;
            }
            if (view.getLayoutDirection() == 1) {
                z10 = true;
            }
            int i10 = SwipeDismissBehavior.this.f٨٣٣٥f;
            if ((i10 == 0 && z10) || (i10 == 1 && !z10)) {
                width = -view.getWidth();
            } else {
                width = view.getWidth();
            }
            d1.a0(view, width);
            view.setAlpha(DownloadProgress.UNKNOWN_PROGRESS);
            SwipeDismissBehavior.this.getClass();
            return true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface c {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final View f٨٣٤٤a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f٨٣٤٥b;

        d(View view, boolean z10) {
            this.f٨٣٤٤a = view;
            this.f٨٣٤٥b = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            s2.c cVar = SwipeDismissBehavior.this.f٨٣٣٠a;
            if (cVar != null && cVar.n(true)) {
                this.f٨٣٤٤a.postOnAnimation(this);
            } else if (this.f٨٣٤٥b) {
                SwipeDismissBehavior.this.getClass();
            }
        }
    }

    static float M(float f10, float f11, float f12) {
        return Math.min(Math.max(f10, f11), f12);
    }

    static int N(int i10, int i11, int i12) {
        return Math.min(Math.max(i10, i11), i12);
    }

    private void O(ViewGroup viewGroup) {
        s2.c p10;
        if (this.f٨٣٣٠a == null) {
            if (this.f٨٣٣٤e) {
                p10 = s2.c.o(viewGroup, this.f٨٣٣٣d, this.f٨٣٣٩j);
            } else {
                p10 = s2.c.p(viewGroup, this.f٨٣٣٩j);
            }
            this.f٨٣٣٠a = p10;
        }
    }

    static float P(float f10, float f11, float f12) {
        return (f12 - f10) / (f11 - f10);
    }

    private void T(View view) {
        d1.k0(view, Constants.MB);
        if (L(view)) {
            d1.m0(view, g0.a.f١٥٩٤٦y, null, new b());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean J(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f٨٣٣٠a != null) {
            if (!this.f٨٣٣٢c || motionEvent.getActionMasked() != 3) {
                this.f٨٣٣٠a.G(motionEvent);
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean L(View view) {
        return true;
    }

    public void Q(float f10) {
        this.f٨٣٣٨i = M(DownloadProgress.UNKNOWN_PROGRESS, f10, 1.0f);
    }

    public void R(float f10) {
        this.f٨٣٣٧h = M(DownloadProgress.UNKNOWN_PROGRESS, f10, 1.0f);
    }

    public void S(int i10) {
        this.f٨٣٣٥f = i10;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean q(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z10 = this.f٨٣٣١b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                this.f٨٣٣١b = false;
            }
        } else {
            z10 = coordinatorLayout.H(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f٨٣٣١b = z10;
        }
        if (!z10) {
            return false;
        }
        O(coordinatorLayout);
        if (!this.f٨٣٣٢c && this.f٨٣٣٠a.Q(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i10) {
        boolean r10 = super.r(coordinatorLayout, view, i10);
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
            T(view);
        }
        return r10;
    }

    public void setListener(c cVar) {
    }
}
