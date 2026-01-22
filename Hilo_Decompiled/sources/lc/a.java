package lc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.d1;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import lc.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f١٥٨٦٤a;

    /* renamed from: b, reason: collision with root package name */
    protected PorterDuffXfermode f١٥٨٦٥b;

    /* renamed from: c, reason: collision with root package name */
    protected PorterDuffXfermode f١٥٨٦٦c;

    /* renamed from: d, reason: collision with root package name */
    private final Path f١٥٨٦٧d;

    /* renamed from: e, reason: collision with root package name */
    private final Path f١٥٨٦٨e;

    /* renamed from: f, reason: collision with root package name */
    private b f١٥٨٦٩f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f١٥٨٧٠g;

    /* renamed from: h, reason: collision with root package name */
    private View f١٥٨٧١h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f١٥٨٧٢i;

    public a() {
        Paint paint = new Paint(1);
        this.f١٥٨٦٤a = paint;
        this.f١٥٨٦٥b = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.f١٥٨٦٦c = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.f١٥٨٦٧d = new Path();
        this.f١٥٨٦٨e = new Path();
        this.f١٥٨٦٩f = new b();
        this.f١٥٨٧٠g = true;
        paint.setAntiAlias(true);
        paint.setColor(-16776961);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(1.0f);
    }

    private void a(int i10, int i11) {
        this.f١٥٨٦٨e.reset();
        this.f١٥٨٦٨e.addRect(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, d().getWidth() * 1.0f, d().getHeight() * 1.0f, Path.Direction.CW);
        if (i10 > 0 && i11 > 0) {
            this.f١٥٨٦٩f.c(i10, i11);
            this.f١٥٨٦٧d.reset();
            this.f١٥٨٦٧d.set(this.f١٥٨٦٩f.a());
            if (Build.VERSION.SDK_INT > 27) {
                this.f١٥٨٦٨e.op(this.f١٥٨٦٧d, Path.Op.DIFFERENCE);
            }
            if (d1.x(d()) > DownloadProgress.UNKNOWN_PROGRESS) {
                try {
                    d().setOutlineProvider(d().getOutlineProvider());
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
        d().postInvalidate();
    }

    public boolean b() {
        if (d() != null && (d() instanceof ViewGroup) && this.f١٥٨٧٢i) {
            return true;
        }
        return false;
    }

    public void c(Canvas canvas) {
        if (!b()) {
            return;
        }
        if (this.f١٥٨٧٠g) {
            a(canvas.getWidth(), canvas.getHeight());
            this.f١٥٨٧٠g = false;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 <= 27) {
            canvas.drawPath(this.f١٥٨٦٧d, this.f١٥٨٦٤a);
        } else {
            canvas.drawPath(this.f١٥٨٦٨e, this.f١٥٨٦٤a);
        }
        if (i10 <= 27) {
            d().setLayerType(2, null);
        }
    }

    public View d() {
        return this.f١٥٨٧١h;
    }

    public void e(View view, boolean z10, b.a aVar) {
        this.f١٥٨٧١h = view;
        this.f١٥٨٧٢i = z10;
        if (!b()) {
            return;
        }
        d().setDrawingCacheEnabled(true);
        d().setWillNotDraw(false);
        if (Build.VERSION.SDK_INT <= 27) {
            this.f١٥٨٦٤a.setXfermode(this.f١٥٨٦٦c);
            d().setLayerType(1, this.f١٥٨٦٤a);
        } else {
            this.f١٥٨٦٤a.setXfermode(this.f١٥٨٦٥b);
            d().setLayerType(1, null);
        }
        this.f١٥٨٦٩f.b(aVar);
        g();
    }

    public void f(boolean z10, int i10, int i11, int i12, int i13) {
        if (b() && z10) {
            g();
        }
    }

    public void g() {
        this.f١٥٨٧٠g = true;
        d().postInvalidate();
    }
}
