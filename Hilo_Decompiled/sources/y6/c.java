package y6;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.siyamed.shapeimageview.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class c extends d {

    /* renamed from: l, reason: collision with root package name */
    private final RectF f١٩١٦٨l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    private final RectF f١٩١٦٩m = new RectF();

    /* renamed from: n, reason: collision with root package name */
    private int f١٩١٧٠n = 0;

    /* renamed from: o, reason: collision with root package name */
    private int f١٩١٧١o;

    @Override // y6.d
    public void a(int i10, int i11, float f10, float f11, float f12, float f13, float f14) {
        this.f١٩١٦٩m.set(-f13, -f14, i10 + f13, i11 + f14);
        this.f١٩١٧١o = Math.round(this.f١٩١٧٠n / f12);
    }

    @Override // y6.d
    public void e(Canvas canvas, Paint paint, Paint paint2) {
        RectF rectF = this.f١٩١٦٨l;
        int i10 = this.f١٩١٧٠n;
        canvas.drawRoundRect(rectF, i10, i10, paint2);
        canvas.save();
        canvas.concat(this.f١٩١٨٢k);
        RectF rectF2 = this.f١٩١٦٩m;
        int i11 = this.f١٩١٧١o;
        canvas.drawRoundRect(rectF2, i11, i11, paint);
        canvas.restore();
    }

    @Override // y6.d
    public void i(Context context, AttributeSet attributeSet, int i10) {
        super.i(context, attributeSet, i10);
        this.f١٩١٧٨g.setStrokeWidth(this.f١٩١٧٥d * 2);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShaderImageView, i10, 0);
            this.f١٩١٧٠n = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShaderImageView_siRadius, this.f١٩١٧٠n);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // y6.d
    public void m(int i10, int i11) {
        super.m(i10, i11);
        RectF rectF = this.f١٩١٦٨l;
        int i12 = this.f١٩١٧٥d;
        rectF.set(i12, i12, this.f١٩١٧٢a - i12, this.f١٩١٧٣b - i12);
    }

    @Override // y6.d
    public void n() {
        this.f١٩١٦٩m.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
        this.f١٩١٧١o = 0;
    }

    public final int s() {
        return this.f١٩١٧٠n;
    }

    public final void t(int i10) {
        this.f١٩١٧٠n = i10;
    }
}
