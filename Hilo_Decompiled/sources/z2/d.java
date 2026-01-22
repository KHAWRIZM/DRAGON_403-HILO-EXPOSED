package z2;

import android.view.animation.Interpolator;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class d implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f١٩٤٣٦a;

    /* renamed from: b, reason: collision with root package name */
    private final float f١٩٤٣٧b;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(float[] fArr) {
        this.f١٩٤٣٦a = fArr;
        this.f١٩٤٣٧b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        if (f10 >= 1.0f) {
            return 1.0f;
        }
        if (f10 <= DownloadProgress.UNKNOWN_PROGRESS) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        float[] fArr = this.f١٩٤٣٦a;
        int min = Math.min((int) ((fArr.length - 1) * f10), fArr.length - 2);
        float f11 = this.f١٩٤٣٧b;
        float f12 = (f10 - (min * f11)) / f11;
        float[] fArr2 = this.f١٩٤٣٦a;
        float f13 = fArr2[min];
        return f13 + (f12 * (fArr2[min + 1] - f13));
    }
}
