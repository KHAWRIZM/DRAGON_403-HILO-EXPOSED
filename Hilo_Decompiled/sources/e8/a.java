package e8;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.core.graphics.x;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f١٣٩٣٠i = new int[3];

    /* renamed from: j, reason: collision with root package name */
    private static final float[] f١٣٩٣١j = {DownloadProgress.UNKNOWN_PROGRESS, 0.5f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f١٣٩٣٢k = new int[4];

    /* renamed from: l, reason: collision with root package name */
    private static final float[] f١٣٩٣٣l = {DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 0.5f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    private final Paint f١٣٩٣٤a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f١٣٩٣٥b;

    /* renamed from: c, reason: collision with root package name */
    private final Paint f١٣٩٣٦c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٣٩٣٧d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٣٩٣٨e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٣٩٣٩f;

    /* renamed from: g, reason: collision with root package name */
    private final Path f١٣٩٤٠g;

    /* renamed from: h, reason: collision with root package name */
    private final Paint f١٣٩٤١h;

    public a() {
        this(-16777216);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i10, float f10, float f11) {
        boolean z10;
        if (f11 < DownloadProgress.UNKNOWN_PROGRESS) {
            z10 = true;
        } else {
            z10 = false;
        }
        Path path = this.f١٣٩٤٠g;
        if (z10) {
            int[] iArr = f١٣٩٣٢k;
            iArr[0] = 0;
            iArr[1] = this.f١٣٩٣٩f;
            iArr[2] = this.f١٣٩٣٨e;
            iArr[3] = this.f١٣٩٣٧d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f10, f11);
            path.close();
            float f12 = -i10;
            rectF.inset(f12, f12);
            int[] iArr2 = f١٣٩٣٢k;
            iArr2[0] = 0;
            iArr2[1] = this.f١٣٩٣٧d;
            iArr2[2] = this.f١٣٩٣٨e;
            iArr2[3] = this.f١٣٩٣٩f;
        }
        float width = rectF.width() / 2.0f;
        if (width <= DownloadProgress.UNKNOWN_PROGRESS) {
            return;
        }
        float f13 = 1.0f - (i10 / width);
        float[] fArr = f١٣٩٣٣l;
        fArr[1] = f13;
        fArr[2] = ((1.0f - f13) / 2.0f) + f13;
        this.f١٣٩٣٥b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, f١٣٩٣٢k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z10) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f١٣٩٤١h);
        }
        canvas.drawArc(rectF, f10, f11, true, this.f١٣٩٣٥b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i10) {
        rectF.bottom += i10;
        rectF.offset(DownloadProgress.UNKNOWN_PROGRESS, -i10);
        int[] iArr = f١٣٩٣٠i;
        iArr[0] = this.f١٣٩٣٩f;
        iArr[1] = this.f١٣٩٣٨e;
        iArr[2] = this.f١٣٩٣٧d;
        Paint paint = this.f١٣٩٣٦c;
        float f10 = rectF.left;
        paint.setShader(new LinearGradient(f10, rectF.top, f10, rectF.bottom, iArr, f١٣٩٣١j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f١٣٩٣٦c);
        canvas.restore();
    }

    public Paint c() {
        return this.f١٣٩٣٤a;
    }

    public void d(int i10) {
        this.f١٣٩٣٧d = x.l(i10, 68);
        this.f١٣٩٣٨e = x.l(i10, 20);
        this.f١٣٩٣٩f = x.l(i10, 0);
        this.f١٣٩٣٤a.setColor(this.f١٣٩٣٧d);
    }

    public a(int i10) {
        this.f١٣٩٤٠g = new Path();
        Paint paint = new Paint();
        this.f١٣٩٤١h = paint;
        this.f١٣٩٣٤a = new Paint();
        d(i10);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f١٣٩٣٥b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f١٣٩٣٦c = new Paint(paint2);
    }
}
