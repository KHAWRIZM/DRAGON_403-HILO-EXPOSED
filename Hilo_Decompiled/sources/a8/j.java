package a8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import com.google.android.material.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class j extends a8.a {

    /* renamed from: g, reason: collision with root package name */
    private final float f٤٤٨g;

    /* renamed from: h, reason: collision with root package name */
    private final float f٤٤٩h;

    /* renamed from: i, reason: collision with root package name */
    private final float f٤٥٠i;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f٤٥١a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f٤٥٢b;

        a(boolean z10, int i10) {
            this.f٤٥١a = z10;
            this.f٤٥٢b = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            j.this.f٤٢٤b.setTranslationX(DownloadProgress.UNKNOWN_PROGRESS);
            j.this.k(DownloadProgress.UNKNOWN_PROGRESS, this.f٤٥١a, this.f٤٥٢b);
        }
    }

    public j(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f٤٤٨g = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.f٤٤٩h = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.f٤٥٠i = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
    }

    private boolean g(int i10, int i11) {
        if ((Gravity.getAbsoluteGravity(i10, this.f٤٢٤b.getLayoutDirection()) & i11) == i11) {
            return true;
        }
        return false;
    }

    private int i(boolean z10) {
        ViewGroup.LayoutParams layoutParams = this.f٤٢٤b.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (z10) {
                return marginLayoutParams.leftMargin;
            }
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f٤٢٤b, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f٤٢٤b, (Property<View, Float>) View.SCALE_Y, 1.0f));
        View view = this.f٤٢٤b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i10), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(this.f٤٢٧e);
        animatorSet.start();
    }

    public void h(BackEventCompat backEventCompat, int i10, Animator.AnimatorListener animatorListener, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        boolean z10;
        if (backEventCompat.getSwipeEdge() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean g10 = g(i10, 3);
        float width = (this.f٤٢٤b.getWidth() * this.f٤٢٤b.getScaleX()) + i(g10);
        View view = this.f٤٢٤b;
        Property property = View.TRANSLATION_X;
        if (g10) {
            width = -width;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, width);
        if (animatorUpdateListener != null) {
            ofFloat.addUpdateListener(animatorUpdateListener);
        }
        ofFloat.setInterpolator(new z2.b());
        ofFloat.setDuration(p7.a.c(this.f٤٢٥c, this.f٤٢٦d, backEventCompat.getProgress()));
        ofFloat.addListener(new a(z10, i10));
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        ofFloat.start();
    }

    public void j(BackEventCompat backEventCompat) {
        super.d(backEventCompat);
    }

    public void k(float f10, boolean z10, int i10) {
        boolean z11;
        int i11;
        float f11;
        float f12;
        float a10 = a(f10);
        boolean g10 = g(i10, 3);
        if (z10 == g10) {
            z11 = true;
        } else {
            z11 = false;
        }
        int width = this.f٤٢٤b.getWidth();
        int height = this.f٤٢٤b.getHeight();
        float f13 = width;
        if (f13 > DownloadProgress.UNKNOWN_PROGRESS) {
            float f14 = height;
            if (f14 > DownloadProgress.UNKNOWN_PROGRESS) {
                float f15 = this.f٤٤٨g / f13;
                float f16 = this.f٤٤٩h / f13;
                float f17 = this.f٤٥٠i / f14;
                View view = this.f٤٢٤b;
                if (g10) {
                    f13 = DownloadProgress.UNKNOWN_PROGRESS;
                }
                view.setPivotX(f13);
                if (!z11) {
                    f16 = -f15;
                }
                float a11 = p7.a.a(DownloadProgress.UNKNOWN_PROGRESS, f16, a10);
                float f18 = a11 + 1.0f;
                float a12 = 1.0f - p7.a.a(DownloadProgress.UNKNOWN_PROGRESS, f17, a10);
                if (!Float.isNaN(f18) && !Float.isNaN(a12)) {
                    this.f٤٢٤b.setScaleX(f18);
                    this.f٤٢٤b.setScaleY(a12);
                    View view2 = this.f٤٢٤b;
                    if (view2 instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view2;
                        for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                            View childAt = viewGroup.getChildAt(i12);
                            if (g10) {
                                i11 = (width - childAt.getRight()) + childAt.getWidth();
                            } else {
                                i11 = -childAt.getLeft();
                            }
                            childAt.setPivotX(i11);
                            childAt.setPivotY(-childAt.getTop());
                            if (z11) {
                                f11 = 1.0f - a11;
                            } else {
                                f11 = 1.0f;
                            }
                            if (a12 != DownloadProgress.UNKNOWN_PROGRESS) {
                                f12 = (f18 / a12) * f11;
                            } else {
                                f12 = 1.0f;
                            }
                            if (!Float.isNaN(f11) && !Float.isNaN(f12)) {
                                childAt.setScaleX(f11);
                                childAt.setScaleY(f12);
                            }
                        }
                    }
                }
            }
        }
    }

    public void l(BackEventCompat backEventCompat, int i10) {
        boolean z10;
        if (super.e(backEventCompat) == null) {
            return;
        }
        if (backEventCompat.getSwipeEdge() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        k(backEventCompat.getProgress(), z10, i10);
    }
}
