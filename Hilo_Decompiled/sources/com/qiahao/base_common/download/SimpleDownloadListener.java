package com.qiahao.base_common.download;

import com.qiahao.base_common.download.DownloadListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/qiahao/base_common/download/SimpleDownloadListener;", "Lcom/qiahao/base_common/download/DownloadListener;", "<init>", "()V", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class SimpleDownloadListener implements DownloadListener {
    @Override // com.qiahao.base_common.download.DownloadListener
    public void onCompleted(@NotNull DownloadTask downloadTask) {
        DownloadListener.DefaultImpls.onCompleted(this, downloadTask);
    }

    @Override // com.qiahao.base_common.download.DownloadListener
    public void onError(@NotNull DownloadTask downloadTask, @NotNull Throwable th) {
        DownloadListener.DefaultImpls.onError(this, downloadTask, th);
    }

    @Override // com.qiahao.base_common.download.DownloadListener
    public void onProgress(@NotNull DownloadTask downloadTask, int i10, int i11) {
        DownloadListener.DefaultImpls.onProgress(this, downloadTask, i10, i11);
    }
}
