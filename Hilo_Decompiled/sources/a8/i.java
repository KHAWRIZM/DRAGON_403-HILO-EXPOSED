package a8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.RoundedCorner;
import android.view.View;
import android.view.WindowInsets;
import androidx.activity.BackEventCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.k0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class i extends a8.a {

    /* renamed from: g, reason: collision with root package name */
    private final float f٤٤٠g;

    /* renamed from: h, reason: collision with root package name */
    private final float f٤٤١h;

    /* renamed from: i, reason: collision with root package name */
    private float f٤٤٢i;

    /* renamed from: j, reason: collision with root package name */
    private Rect f٤٤٣j;

    /* renamed from: k, reason: collision with root package name */
    private Rect f٤٤٤k;

    /* renamed from: l, reason: collision with root package name */
    private float[] f٤٤٥l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f٤٤٦a;

        a(View view) {
            this.f٤٤٦a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = this.f٤٤٦a;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public i(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f٤٤٠g = resources.getDimension(R.dimen.m3_back_progress_main_container_min_edge_gap);
        this.f٤٤١h = resources.getDimension(R.dimen.m3_back_progress_main_container_max_translation_y);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
    
        r5 = r14.f٤٢٤b.getRootWindowInsets();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float[] h() {
        WindowInsets rootWindowInsets;
        int i10;
        int i11;
        int i12;
        int i13;
        if (Build.VERSION.SDK_INT >= 31 && rootWindowInsets != null) {
            DisplayMetrics displayMetrics = this.f٤٢٤b.getResources().getDisplayMetrics();
            int i14 = displayMetrics.widthPixels;
            int i15 = displayMetrics.heightPixels;
            int[] iArr = new int[2];
            this.f٤٢٤b.getLocationOnScreen(iArr);
            int i16 = iArr[0];
            int i17 = iArr[1];
            int width = this.f٤٢٤b.getWidth();
            int height = this.f٤٢٤b.getHeight();
            if (i16 == 0 && i17 == 0) {
                i10 = q(rootWindowInsets, 0);
            } else {
                i10 = 0;
            }
            int i18 = width + i16;
            if (i18 >= i14 && i17 == 0) {
                i11 = q(rootWindowInsets, 1);
            } else {
                i11 = 0;
            }
            if (i18 >= i14 && i17 + height >= i15) {
                i12 = q(rootWindowInsets, 2);
            } else {
                i12 = 0;
            }
            if (i16 == 0 && i17 + height >= i15) {
                i13 = q(rootWindowInsets, 3);
            } else {
                i13 = 0;
            }
            float f10 = i10;
            float f11 = i11;
            float f12 = i12;
            float f13 = i13;
            return new float[]{f10, f10, f11, f11, f12, f12, f13, f13};
        }
        return new float[]{DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS};
    }

    private ValueAnimator k(final ClippableRoundedCornerLayout clippableRoundedCornerLayout) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new TypeEvaluator() { // from class: a8.g
            @Override // android.animation.TypeEvaluator
            public final Object evaluate(float f10, Object obj, Object obj2) {
                Object r10;
                r10 = i.r(f10, obj, obj2);
                return r10;
            }
        }, clippableRoundedCornerLayout.getCornerRadii(), n());
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: a8.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                i.s(ClippableRoundedCornerLayout.this, valueAnimator);
            }
        });
        return ofObject;
    }

    private AnimatorSet l(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f٤٢٤b, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f٤٢٤b, (Property<View, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.f٤٢٤b, (Property<View, Float>) View.TRANSLATION_X, DownloadProgress.UNKNOWN_PROGRESS), ObjectAnimator.ofFloat(this.f٤٢٤b, (Property<View, Float>) View.TRANSLATION_Y, DownloadProgress.UNKNOWN_PROGRESS));
        animatorSet.addListener(new a(view));
        return animatorSet;
    }

    private int q(WindowInsets windowInsets, int i10) {
        RoundedCorner roundedCorner;
        int radius;
        roundedCorner = windowInsets.getRoundedCorner(i10);
        if (roundedCorner != null) {
            radius = roundedCorner.getRadius();
            return radius;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object r(float f10, Object obj, Object obj2) {
        return u((float[]) obj, (float[]) obj2, f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(ClippableRoundedCornerLayout clippableRoundedCornerLayout, ValueAnimator valueAnimator) {
        clippableRoundedCornerLayout.e((float[]) valueAnimator.getAnimatedValue());
    }

    private static float[] t(float[] fArr, float f10, float f11) {
        return new float[]{p7.a.a(fArr[0], f10, f11), p7.a.a(fArr[1], f10, f11), p7.a.a(fArr[2], f10, f11), p7.a.a(fArr[3], f10, f11), p7.a.a(fArr[4], f10, f11), p7.a.a(fArr[5], f10, f11), p7.a.a(fArr[6], f10, f11), p7.a.a(fArr[7], f10, f11)};
    }

    private static float[] u(float[] fArr, float[] fArr2, float f10) {
        return new float[]{p7.a.a(fArr[0], fArr2[0], f10), p7.a.a(fArr[1], fArr2[1], f10), p7.a.a(fArr[2], fArr2[2], f10), p7.a.a(fArr[3], fArr2[3], f10), p7.a.a(fArr[4], fArr2[4], f10), p7.a.a(fArr[5], fArr2[5], f10), p7.a.a(fArr[6], fArr2[6], f10), p7.a.a(fArr[7], fArr2[7], f10)};
    }

    private void v() {
        this.f٤٤٢i = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٤٤٣j = null;
        this.f٤٤٤k = null;
    }

    public void i(View view) {
        if (super.b() == null) {
            return;
        }
        AnimatorSet l10 = l(view);
        View view2 = this.f٤٢٤b;
        if (view2 instanceof ClippableRoundedCornerLayout) {
            l10.playTogether(k((ClippableRoundedCornerLayout) view2));
        }
        l10.setDuration(this.f٤٢٧e);
        l10.start();
        v();
    }

    public void j() {
        this.f٤٤٥l = null;
    }

    public void m(long j10, View view) {
        AnimatorSet l10 = l(view);
        l10.setDuration(j10);
        l10.start();
        v();
    }

    public float[] n() {
        if (this.f٤٤٥l == null) {
            this.f٤٤٥l = h();
        }
        return this.f٤٤٥l;
    }

    public Rect o() {
        return this.f٤٤٤k;
    }

    public Rect p() {
        return this.f٤٤٣j;
    }

    public void w(float f10, View view) {
        this.f٤٤٣j = k0.c(this.f٤٢٤b);
        if (view != null) {
            this.f٤٤٤k = k0.b(this.f٤٢٤b, view);
        }
        this.f٤٤٢i = f10;
    }

    public void x(BackEventCompat backEventCompat, View view) {
        super.d(backEventCompat);
        w(backEventCompat.getTouchY(), view);
    }

    public void y(float f10, boolean z10, float f11, float f12) {
        int i10;
        float a10 = a(f10);
        float width = this.f٤٢٤b.getWidth();
        float height = this.f٤٢٤b.getHeight();
        if (width > DownloadProgress.UNKNOWN_PROGRESS && height > DownloadProgress.UNKNOWN_PROGRESS) {
            float a11 = p7.a.a(1.0f, 0.9f, a10);
            float a12 = p7.a.a(DownloadProgress.UNKNOWN_PROGRESS, Math.max(DownloadProgress.UNKNOWN_PROGRESS, ((width - (0.9f * width)) / 2.0f) - this.f٤٤٠g), a10);
            if (z10) {
                i10 = 1;
            } else {
                i10 = -1;
            }
            float f13 = a12 * i10;
            float min = Math.min(Math.max(DownloadProgress.UNKNOWN_PROGRESS, ((height - (a11 * height)) / 2.0f) - this.f٤٤٠g), this.f٤٤١h);
            float f14 = f11 - this.f٤٤٢i;
            float a13 = p7.a.a(DownloadProgress.UNKNOWN_PROGRESS, min, Math.abs(f14) / height) * Math.signum(f14);
            if (!Float.isNaN(a11) && !Float.isNaN(f13) && !Float.isNaN(a13)) {
                this.f٤٢٤b.setScaleX(a11);
                this.f٤٢٤b.setScaleY(a11);
                this.f٤٢٤b.setTranslationX(f13);
                this.f٤٢٤b.setTranslationY(a13);
                View view = this.f٤٢٤b;
                if (view instanceof ClippableRoundedCornerLayout) {
                    ((ClippableRoundedCornerLayout) view).e(t(n(), f12, a10));
                }
            }
        }
    }

    public void z(BackEventCompat backEventCompat, View view, float f10) {
        boolean z10;
        if (super.e(backEventCompat) == null) {
            return;
        }
        if (view != null && view.getVisibility() != 4) {
            view.setVisibility(4);
        }
        if (backEventCompat.getSwipeEdge() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        y(backEventCompat.getProgress(), z10, backEventCompat.getTouchY(), f10);
    }
}
