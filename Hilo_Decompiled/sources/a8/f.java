package a8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import com.google.android.material.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class f extends a8.a {

    /* renamed from: g, reason: collision with root package name */
    private final float f٤٣٦g;

    /* renamed from: h, reason: collision with root package name */
    private final float f٤٣٧h;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f٤٢٤b.setTranslationY(DownloadProgress.UNKNOWN_PROGRESS);
            f.this.k(DownloadProgress.UNKNOWN_PROGRESS);
        }
    }

    public f(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f٤٣٦g = resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_x_distance);
        this.f٤٣٧h = resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_y_distance);
    }

    private Animator g() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f٤٢٤b, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f٤٢٤b, (Property<View, Float>) View.SCALE_Y, 1.0f));
        View view = this.f٤٢٤b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i10), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new z2.b());
        return animatorSet;
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        Animator g10 = g();
        g10.setDuration(this.f٤٢٧e);
        g10.start();
    }

    public void h(BackEventCompat backEventCompat, Animator.AnimatorListener animatorListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f٤٢٤b, (Property<View, Float>) View.TRANSLATION_Y, this.f٤٢٤b.getHeight() * this.f٤٢٤b.getScaleY());
        ofFloat.setInterpolator(new z2.b());
        ofFloat.setDuration(p7.a.c(this.f٤٢٥c, this.f٤٢٦d, backEventCompat.getProgress()));
        ofFloat.addListener(new a());
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        ofFloat.start();
    }

    public void i(BackEventCompat backEventCompat, Animator.AnimatorListener animatorListener) {
        Animator g10 = g();
        g10.setDuration(p7.a.c(this.f٤٢٥c, this.f٤٢٦d, backEventCompat.getProgress()));
        if (animatorListener != null) {
            g10.addListener(animatorListener);
        }
        g10.start();
    }

    public void j(BackEventCompat backEventCompat) {
        super.d(backEventCompat);
    }

    public void k(float f10) {
        float f11;
        float a10 = a(f10);
        float width = this.f٤٢٤b.getWidth();
        float height = this.f٤٢٤b.getHeight();
        if (width > DownloadProgress.UNKNOWN_PROGRESS && height > DownloadProgress.UNKNOWN_PROGRESS) {
            float f12 = this.f٤٣٦g / width;
            float f13 = this.f٤٣٧h / height;
            float a11 = 1.0f - p7.a.a(DownloadProgress.UNKNOWN_PROGRESS, f12, a10);
            float a12 = 1.0f - p7.a.a(DownloadProgress.UNKNOWN_PROGRESS, f13, a10);
            if (!Float.isNaN(a11) && !Float.isNaN(a12)) {
                this.f٤٢٤b.setScaleX(a11);
                this.f٤٢٤b.setPivotY(height);
                this.f٤٢٤b.setScaleY(a12);
                View view = this.f٤٢٤b;
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                        View childAt = viewGroup.getChildAt(i10);
                        childAt.setPivotY(-childAt.getTop());
                        if (a12 != DownloadProgress.UNKNOWN_PROGRESS) {
                            f11 = a11 / a12;
                        } else {
                            f11 = 1.0f;
                        }
                        childAt.setScaleY(f11);
                    }
                }
            }
        }
    }

    public void l(BackEventCompat backEventCompat) {
        if (super.e(backEventCompat) == null) {
            return;
        }
        k(backEventCompat.getProgress());
    }
}
