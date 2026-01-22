package com.qiahao.base_common.download;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/qiahao/base_common/download/DownloadListener;", "", "onCompleted", "", "task", "Lcom/qiahao/base_common/download/DownloadTask;", "onProgress", "soFarBytes", "", "totalBytes", "onError", "throwable", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface DownloadListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static void onCompleted(@NotNull DownloadListener downloadListener, @NotNull DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
        }

        public static void onError(@NotNull DownloadListener downloadListener, @NotNull DownloadTask task, @NotNull Throwable throwable) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
        }

        public static void onProgress(@NotNull DownloadListener downloadListener, @NotNull DownloadTask task, int i10, int i11) {
            Intrinsics.checkNotNullParameter(task, "task");
        }
    }

    void onCompleted(@NotNull DownloadTask task);

    void onError(@NotNull DownloadTask task, @NotNull Throwable throwable);

    void onProgress(@NotNull DownloadTask task, int soFarBytes, int totalBytes);
}
