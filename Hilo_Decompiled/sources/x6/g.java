package x6;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final float f١٨٩٤٩a;

    /* renamed from: b, reason: collision with root package name */
    private final float f١٨٩٥٠b;

    /* renamed from: c, reason: collision with root package name */
    private final Path f١٨٩٥١c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Path path, float f10, float f11) {
        this.f١٨٩٥١c = path;
        path.computeBounds(new RectF(), true);
        if (f10 <= DownloadProgress.UNKNOWN_PROGRESS && f11 <= DownloadProgress.UNKNOWN_PROGRESS) {
            f10 = (float) Math.ceil(r0.width());
            f11 = (float) Math.ceil(r0.height());
            path.offset(((float) Math.floor(r0.left)) * (-1.0f), Math.round(r0.top) * (-1.0f));
        }
        this.f١٨٩٤٩a = f10;
        this.f١٨٩٥٠b = f11;
    }

    public float a() {
        return this.f١٨٩٥٠b;
    }

    public float b() {
        return this.f١٨٩٤٩a;
    }

    public void c(Matrix matrix, Path path) {
        this.f١٨٩٥١c.transform(matrix, path);
    }
}
