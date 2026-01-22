package f8;

import android.graphics.RectF;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    private final float f١٤٠٨٩a;

    public c(float f10) {
        this.f١٤٠٨٩a = f10;
    }

    public static c b(a aVar) {
        return new c(aVar.b());
    }

    private static float c(RectF rectF) {
        return Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f);
    }

    @Override // f8.d
    public float a(RectF rectF) {
        return j2.a.a(this.f١٤٠٨٩a, DownloadProgress.UNKNOWN_PROGRESS, c(rectF));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof c) && this.f١٤٠٨٩a == ((c) obj).f١٤٠٨٩a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f١٤٠٨٩a)});
    }
}
