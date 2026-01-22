package tech.sud.gip.core;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public interface ISudListenerPreloadMGPkg {
    void onPreloadFailure(long j, int i, String str);

    void onPreloadStatus(long j, long j2, long j3, PkgDownloadStatus pkgDownloadStatus);

    void onPreloadSuccess(long j);
}
