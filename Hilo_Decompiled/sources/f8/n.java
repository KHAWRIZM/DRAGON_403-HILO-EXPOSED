package f8;

import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class n extends e {

    /* renamed from: a, reason: collision with root package name */
    float f١٤١٧٧a = -1.0f;

    @Override // f8.e
    public void a(q qVar, float f10, float f11, float f12) {
        float f13 = f12 * f11;
        qVar.o(DownloadProgress.UNKNOWN_PROGRESS, f13, 180.0f, 180.0f - f10);
        float f14 = f13 * 2.0f;
        qVar.a(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, f14, f14, 180.0f, f10);
    }
}
