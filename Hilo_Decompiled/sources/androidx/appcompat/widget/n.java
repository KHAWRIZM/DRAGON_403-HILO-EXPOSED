package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;
import androidx.core.view.d1;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class n extends l {

    /* renamed from: d, reason: collision with root package name */
    private final SeekBar f١٦١٣d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f١٦١٤e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f١٦١٥f;

    /* renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f١٦١٦g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f١٦١٧h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f١٦١٨i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SeekBar seekBar) {
        super(seekBar);
        this.f١٦١٥f = null;
        this.f١٦١٦g = null;
        this.f١٦١٧h = false;
        this.f١٦١٨i = false;
        this.f١٦١٣d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f١٦١٤e;
        if (drawable != null) {
            if (this.f١٦١٧h || this.f١٦١٨i) {
                Drawable r10 = h2.b.r(drawable.mutate());
                this.f١٦١٤e = r10;
                if (this.f١٦١٧h) {
                    h2.b.o(r10, this.f١٦١٥f);
                }
                if (this.f١٦١٨i) {
                    h2.b.p(this.f١٦١٤e, this.f١٦١٦g);
                }
                if (this.f١٦١٤e.isStateful()) {
                    this.f١٦١٤e.setState(this.f١٦١٣d.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.widget.l
    public void c(AttributeSet attributeSet, int i10) {
        super.c(attributeSet, i10);
        Context context = this.f١٦١٣d.getContext();
        int[] iArr = R.styleable.AppCompatSeekBar;
        p0 v10 = p0.v(context, attributeSet, iArr, i10, 0);
        SeekBar seekBar = this.f١٦١٣d;
        d1.o0(seekBar, seekBar.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        Drawable h10 = v10.h(R.styleable.AppCompatSeekBar_android_thumb);
        if (h10 != null) {
            this.f١٦١٣d.setThumb(h10);
        }
        j(v10.g(R.styleable.AppCompatSeekBar_tickMark));
        int i11 = R.styleable.AppCompatSeekBar_tickMarkTintMode;
        if (v10.s(i11)) {
            this.f١٦١٦g = c0.e(v10.k(i11, -1), this.f١٦١٦g);
            this.f١٦١٨i = true;
        }
        int i12 = R.styleable.AppCompatSeekBar_tickMarkTint;
        if (v10.s(i12)) {
            this.f١٦١٥f = v10.c(i12);
            this.f١٦١٧h = true;
        }
        v10.x();
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Canvas canvas) {
        int i10;
        if (this.f١٦١٤e != null) {
            int max = this.f١٦١٣d.getMax();
            int i11 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f١٦١٤e.getIntrinsicWidth();
                int intrinsicHeight = this.f١٦١٤e.getIntrinsicHeight();
                if (intrinsicWidth >= 0) {
                    i10 = intrinsicWidth / 2;
                } else {
                    i10 = 1;
                }
                if (intrinsicHeight >= 0) {
                    i11 = intrinsicHeight / 2;
                }
                this.f١٦١٤e.setBounds(-i10, -i11, i10, i11);
                float width = ((this.f١٦١٣d.getWidth() - this.f١٦١٣d.getPaddingLeft()) - this.f١٦١٣d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f١٦١٣d.getPaddingLeft(), this.f١٦١٣d.getHeight() / 2);
                for (int i12 = 0; i12 <= max; i12++) {
                    this.f١٦١٤e.draw(canvas);
                    canvas.translate(width, DownloadProgress.UNKNOWN_PROGRESS);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        Drawable drawable = this.f١٦١٤e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f١٦١٣d.getDrawableState())) {
            this.f١٦١٣d.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f١٦١٤e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) {
        Drawable drawable2 = this.f١٦١٤e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f١٦١٤e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f١٦١٣d);
            h2.b.m(drawable, this.f١٦١٣d.getLayoutDirection());
            if (drawable.isStateful()) {
                drawable.setState(this.f١٦١٣d.getDrawableState());
            }
            f();
        }
        this.f١٦١٣d.invalidate();
    }
}
