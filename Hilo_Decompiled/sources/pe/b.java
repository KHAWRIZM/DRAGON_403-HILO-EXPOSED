package pe;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.RSRuntimeException;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.security.MessageDigest;
import m4.f;
import p4.d;
import qe.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class b extends a {

    /* renamed from: b, reason: collision with root package name */
    private final int f١٧٠٤٥b;

    /* renamed from: c, reason: collision with root package name */
    private final int f١٧٠٤٦c;

    public b(int i10, int i11) {
        this.f١٧٠٤٥b = i10;
        this.f١٧٠٤٦c = i11;
    }

    @Override // pe.a
    protected Bitmap b(Context context, d dVar, Bitmap bitmap, int i10, int i11) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i12 = this.f١٧٠٤٦c;
        Bitmap f10 = dVar.f(width / i12, height / i12, Bitmap.Config.ARGB_8888);
        a(bitmap, f10);
        Canvas canvas = new Canvas(f10);
        int i13 = this.f١٧٠٤٦c;
        canvas.scale(1.0f / i13, 1.0f / i13);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, paint);
        try {
            return c.a(context, f10, this.f١٧٠٤٥b);
        } catch (RSRuntimeException unused) {
            return qe.a.a(f10, this.f١٧٠٤٥b, true);
        }
    }

    @Override // m4.f
    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (bVar.f١٧٠٤٥b == this.f١٧٠٤٥b && bVar.f١٧٠٤٦c == this.f١٧٠٤٦c) {
                return true;
            }
        }
        return false;
    }

    @Override // m4.f
    public int hashCode() {
        return 737513610 + (this.f١٧٠٤٥b * 1000) + (this.f١٧٠٤٦c * 10);
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.f١٧٠٤٥b + ", sampling=" + this.f١٧٠٤٦c + ")";
    }

    @Override // m4.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.BlurTransformation.1" + this.f١٧٠٤٥b + this.f١٧٠٤٦c).getBytes(f.f١٥٩٧٢a));
    }
}
