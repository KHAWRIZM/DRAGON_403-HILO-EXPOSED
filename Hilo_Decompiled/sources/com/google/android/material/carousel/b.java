package com.google.android.material.carousel;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class b {

    /* renamed from: a, reason: collision with root package name */
    final int f٨٦٥٤a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CarouselLayoutManager f٨٦٥٥b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i10, CarouselLayoutManager carouselLayoutManager) {
            super(i10, null);
            this.f٨٦٥٥b = carouselLayoutManager;
        }

        @Override // com.google.android.material.carousel.b
        public void a(RectF rectF, RectF rectF2, RectF rectF3) {
            float f10 = rectF2.top;
            float f11 = rectF3.top;
            if (f10 < f11 && rectF2.bottom > f11) {
                float f12 = f11 - f10;
                rectF.top += f12;
                rectF3.top += f12;
            }
            float f13 = rectF2.bottom;
            float f14 = rectF3.bottom;
            if (f13 > f14 && rectF2.top < f14) {
                float f15 = f13 - f14;
                rectF.bottom = Math.max(rectF.bottom - f15, rectF.top);
                rectF2.bottom = Math.max(rectF2.bottom - f15, rectF2.top);
            }
        }

        @Override // com.google.android.material.carousel.b
        public RectF e(float f10, float f11, float f12, float f13) {
            return new RectF(DownloadProgress.UNKNOWN_PROGRESS, f12, f11, f10 - f12);
        }

        @Override // com.google.android.material.carousel.b
        int f() {
            return this.f٨٦٥٥b.getHeight();
        }

        @Override // com.google.android.material.carousel.b
        int g() {
            return this.f٨٦٥٥b.getPaddingLeft();
        }

        @Override // com.google.android.material.carousel.b
        int h() {
            return this.f٨٦٥٥b.getWidth() - this.f٨٦٥٥b.getPaddingRight();
        }

        @Override // com.google.android.material.carousel.b
        int i() {
            return j();
        }

        @Override // com.google.android.material.carousel.b
        int j() {
            return 0;
        }

        @Override // com.google.android.material.carousel.b
        public void k(View view, int i10, int i11) {
            int g10 = g();
            this.f٨٦٥٥b.layoutDecoratedWithMargins(view, g10, i10, g10 + n(view), i11);
        }

        @Override // com.google.android.material.carousel.b
        public void l(RectF rectF, RectF rectF2, RectF rectF3) {
            if (rectF2.bottom <= rectF3.top) {
                float floor = ((float) Math.floor(rectF.bottom)) - 1.0f;
                rectF.bottom = floor;
                rectF.top = Math.min(rectF.top, floor);
            }
            if (rectF2.top >= rectF3.bottom) {
                float ceil = ((float) Math.ceil(rectF.top)) + 1.0f;
                rectF.top = ceil;
                rectF.bottom = Math.max(ceil, rectF.bottom);
            }
        }

        @Override // com.google.android.material.carousel.b
        public void m(View view, Rect rect, float f10, float f11) {
            view.offsetTopAndBottom((int) (f11 - (rect.top + f10)));
        }

        int n(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f٨٦٥٥b.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.material.carousel.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class C٠١٠٨b extends b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CarouselLayoutManager f٨٦٥٦b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C٠١٠٨b(int i10, CarouselLayoutManager carouselLayoutManager) {
            super(i10, null);
            this.f٨٦٥٦b = carouselLayoutManager;
        }

        @Override // com.google.android.material.carousel.b
        public void a(RectF rectF, RectF rectF2, RectF rectF3) {
            float f10 = rectF2.left;
            float f11 = rectF3.left;
            if (f10 < f11 && rectF2.right > f11) {
                float f12 = f11 - f10;
                rectF.left += f12;
                rectF2.left += f12;
            }
            float f13 = rectF2.right;
            float f14 = rectF3.right;
            if (f13 > f14 && rectF2.left < f14) {
                float f15 = f13 - f14;
                rectF.right = Math.max(rectF.right - f15, rectF.left);
                rectF2.right = Math.max(rectF2.right - f15, rectF2.left);
            }
        }

        @Override // com.google.android.material.carousel.b
        public RectF e(float f10, float f11, float f12, float f13) {
            return new RectF(f13, DownloadProgress.UNKNOWN_PROGRESS, f11 - f13, f10);
        }

        @Override // com.google.android.material.carousel.b
        int f() {
            return this.f٨٦٥٦b.getHeight() - this.f٨٦٥٦b.getPaddingBottom();
        }

        @Override // com.google.android.material.carousel.b
        int g() {
            return 0;
        }

        @Override // com.google.android.material.carousel.b
        int h() {
            return this.f٨٦٥٦b.getWidth();
        }

        @Override // com.google.android.material.carousel.b
        int i() {
            if (this.f٨٦٥٦b.P()) {
                return h();
            }
            return g();
        }

        @Override // com.google.android.material.carousel.b
        int j() {
            return this.f٨٦٥٦b.getPaddingTop();
        }

        @Override // com.google.android.material.carousel.b
        public void k(View view, int i10, int i11) {
            int j10 = j();
            this.f٨٦٥٦b.layoutDecoratedWithMargins(view, i10, j10, i11, j10 + n(view));
        }

        @Override // com.google.android.material.carousel.b
        public void l(RectF rectF, RectF rectF2, RectF rectF3) {
            if (rectF2.right <= rectF3.left) {
                float floor = ((float) Math.floor(rectF.right)) - 1.0f;
                rectF.right = floor;
                rectF.left = Math.min(rectF.left, floor);
            }
            if (rectF2.left >= rectF3.right) {
                float ceil = ((float) Math.ceil(rectF.left)) + 1.0f;
                rectF.left = ceil;
                rectF.right = Math.max(ceil, rectF.right);
            }
        }

        @Override // com.google.android.material.carousel.b
        public void m(View view, Rect rect, float f10, float f11) {
            view.offsetLeftAndRight((int) (f11 - (rect.left + f10)));
        }

        int n(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f٨٦٥٦b.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
    }

    /* synthetic */ b(int i10, a aVar) {
        this(i10);
    }

    private static b b(CarouselLayoutManager carouselLayoutManager) {
        return new C٠١٠٨b(0, carouselLayoutManager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b c(CarouselLayoutManager carouselLayoutManager, int i10) {
        if (i10 != 0) {
            if (i10 == 1) {
                return d(carouselLayoutManager);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return b(carouselLayoutManager);
    }

    private static b d(CarouselLayoutManager carouselLayoutManager) {
        return new a(1, carouselLayoutManager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(RectF rectF, RectF rectF2, RectF rectF3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract RectF e(float f10, float f11, float f12, float f13);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int f();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int g();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int h();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int i();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int j();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void k(View view, int i10, int i11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void l(RectF rectF, RectF rectF2, RectF rectF3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void m(View view, Rect rect, float f10, float f11);

    private b(int i10) {
        this.f٨٦٥٤a = i10;
    }
}
