package f8;

import android.graphics.RectF;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name */
    private final d f١٤٠٨٧a;

    /* renamed from: b, reason: collision with root package name */
    private final float f١٤٠٨٨b;

    public b(float f10, d dVar) {
        while (dVar instanceof b) {
            dVar = ((b) dVar).f١٤٠٨٧a;
            f10 += ((b) dVar).f١٤٠٨٨b;
        }
        this.f١٤٠٨٧a = dVar;
        this.f١٤٠٨٨b = f10;
    }

    @Override // f8.d
    public float a(RectF rectF) {
        return Math.max(DownloadProgress.UNKNOWN_PROGRESS, this.f١٤٠٨٧a.a(rectF) + this.f١٤٠٨٨b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f١٤٠٨٧a.equals(bVar.f١٤٠٨٧a) && this.f١٤٠٨٨b == bVar.f١٤٠٨٨b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f١٤٠٨٧a, Float.valueOf(this.f١٤٠٨٨b)});
    }
}
