package f8;

import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class f extends e {

    /* renamed from: a, reason: collision with root package name */
    float f١٤٠٩٠a = -1.0f;

    @Override // f8.e
    public void a(q qVar, float f10, float f11, float f12) {
        float f13 = f12 * f11;
        qVar.o(DownloadProgress.UNKNOWN_PROGRESS, f13, 180.0f, 180.0f - f10);
        double d10 = f13;
        qVar.m((float) (Math.sin(Math.toRadians(f10)) * d10), (float) (Math.sin(Math.toRadians(90.0f - f10)) * d10));
    }
}
