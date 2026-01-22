package y6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class b extends d {

    /* renamed from: l, reason: collision with root package name */
    private float f١٩١٦٣l;

    /* renamed from: m, reason: collision with root package name */
    private float f١٩١٦٤m;

    /* renamed from: n, reason: collision with root package name */
    private float f١٩١٦٥n;

    /* renamed from: o, reason: collision with root package name */
    private float f١٩١٦٦o;

    /* renamed from: p, reason: collision with root package name */
    private int f١٩١٦٧p;

    @Override // y6.d
    public void a(int i10, int i11, float f10, float f11, float f12, float f13, float f14) {
        this.f١٩١٦٤m = Math.round(i10 / 2.0f);
        this.f١٩١٦٥n = Math.round(i11 / 2.0f);
        this.f١٩١٦٧p = Math.round(((f10 / f12) / 2.0f) + 0.5f);
    }

    @Override // y6.d
    public void e(Canvas canvas, Paint paint, Paint paint2) {
        float f10 = this.f١٩١٦٣l;
        canvas.drawCircle(f10, f10, this.f١٩١٦٦o, paint2);
        canvas.save();
        canvas.concat(this.f١٩١٨٢k);
        canvas.drawCircle(this.f١٩١٦٤m, this.f١٩١٦٥n, this.f١٩١٦٧p, paint);
        canvas.restore();
    }

    @Override // y6.d
    public void i(Context context, AttributeSet attributeSet, int i10) {
        super.i(context, attributeSet, i10);
        this.f١٩١٧٧f = true;
    }

    @Override // y6.d
    public void m(int i10, int i11) {
        super.m(i10, i11);
        this.f١٩١٦٣l = Math.round(this.f١٩١٧٢a / 2.0f);
        this.f١٩١٦٦o = Math.round((this.f١٩١٧٢a - this.f١٩١٧٥d) / 2.0f);
    }

    @Override // y6.d
    public void n() {
        this.f١٩١٦٧p = 0;
        this.f١٩١٦٤m = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٩١٦٥n = DownloadProgress.UNKNOWN_PROGRESS;
    }

    public final float s() {
        return this.f١٩١٦٦o;
    }

    public final void t(float f10) {
        this.f١٩١٦٦o = f10;
    }
}
