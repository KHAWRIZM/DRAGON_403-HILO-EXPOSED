package com.qiahao.base_common.download.okDownload.listener;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.liulishuo.okdownload.core.listener.DownloadListener1;
import com.liulishuo.okdownload.core.listener.assist.Listener1Assist;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aµ\u0003\u0010\u0019\u001a\u00020\u001a2@\b\u0002\u0010\u001b\u001a:\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0001j\u0004\u0018\u0001`\u001c2@\b\u0002\u0010\u001d\u001a:\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0001j\u0004\u0018\u0001`\u001e2j\b\u0002\u0010\u001f\u001ad\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b\u0018\u00010\rj\u0004\u0018\u0001` 2U\b\u0002\u0010!\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014j\u0004\u0018\u0001`\"2f\u0010#\u001ab\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\rj\u0002`$*j\u0010\u0000\"2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u000122\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001*j\u0010\t\"2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\b0\u000122\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\b0\u0001*¾\u0001\u0010\f\"\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b0\r2\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b0\r*\u0094\u0001\u0010\u0013\"G\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b0\u00142G\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b0\u0014*Â\u0001\u0010\u0015\"^\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\r2^\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\r¨\u0006%"}, d2 = {"onTaskStartWithModel", "Lkotlin/Function2;", "Lcom/liulishuo/okdownload/DownloadTask;", "Lkotlin/ParameterName;", "name", "task", "Lcom/liulishuo/okdownload/core/listener/assist/Listener1Assist$Listener1Model;", DeviceRequestsHelper.DEVICE_INFO_MODEL, "", "onRetry", "Lcom/liulishuo/okdownload/core/cause/ResumeFailedCause;", "cause", "onConnected", "Lkotlin/Function4;", "", "blockCount", "", "currentOffset", "totalLength", "onProgress", "Lkotlin/Function3;", "onTaskEndWithModel", "Lcom/liulishuo/okdownload/core/cause/EndCause;", "Ljava/lang/Exception;", "realCause", "createListener1", "Lcom/liulishuo/okdownload/core/listener/DownloadListener1;", "taskStart", "Lcom/qiahao/base_common/download/okDownload/listener/onTaskStartWithModel;", "retry", "Lcom/qiahao/base_common/download/okDownload/listener/onRetry;", "connected", "Lcom/qiahao/base_common/download/okDownload/listener/onConnected;", "progress", "Lcom/qiahao/base_common/download/okDownload/listener/onProgress;", "taskEnd", "Lcom/qiahao/base_common/download/okDownload/listener/onTaskEndWithModel;", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DownloadListener1ExtensionKt {
    @NotNull
    public static final DownloadListener1 createListener1(@Nullable final Function2<? super DownloadTask, ? super Listener1Assist.Listener1Model, Unit> function2, @Nullable final Function2<? super DownloadTask, ? super ResumeFailedCause, Unit> function22, @Nullable final Function4<? super DownloadTask, ? super Integer, ? super Long, ? super Long, Unit> function4, @Nullable final Function3<? super DownloadTask, ? super Long, ? super Long, Unit> function3, @NotNull final Function4<? super DownloadTask, ? super EndCause, ? super Exception, ? super Listener1Assist.Listener1Model, Unit> taskEnd) {
        Intrinsics.checkNotNullParameter(taskEnd, "taskEnd");
        return new DownloadListener1() { // from class: com.qiahao.base_common.download.okDownload.listener.DownloadListener1ExtensionKt$createListener1$1
            @Override // com.liulishuo.okdownload.core.listener.assist.Listener1Assist.Listener1Callback
            public void connected(DownloadTask task, int blockCount, long currentOffset, long totalLength) {
                Intrinsics.checkNotNullParameter(task, "task");
                Function4<DownloadTask, Integer, Long, Long, Unit> function42 = function4;
                if (function42 != null) {
                    function42.invoke(task, Integer.valueOf(blockCount), Long.valueOf(currentOffset), Long.valueOf(totalLength));
                }
            }

            @Override // com.liulishuo.okdownload.core.listener.assist.Listener1Assist.Listener1Callback
            public void progress(DownloadTask task, long currentOffset, long totalLength) {
                Intrinsics.checkNotNullParameter(task, "task");
                Function3<DownloadTask, Long, Long, Unit> function32 = function3;
                if (function32 != null) {
                    function32.invoke(task, Long.valueOf(currentOffset), Long.valueOf(totalLength));
                }
            }

            @Override // com.liulishuo.okdownload.core.listener.assist.Listener1Assist.Listener1Callback
            public void retry(DownloadTask task, ResumeFailedCause cause) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(cause, "cause");
                Function2<DownloadTask, ResumeFailedCause, Unit> function23 = function22;
                if (function23 != null) {
                    function23.invoke(task, cause);
                }
            }

            @Override // com.liulishuo.okdownload.core.listener.assist.Listener1Assist.Listener1Callback
            public void taskEnd(DownloadTask task, EndCause cause, Exception realCause, Listener1Assist.Listener1Model model) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(cause, "cause");
                Intrinsics.checkNotNullParameter(model, "model");
                taskEnd.invoke(task, cause, realCause, model);
            }

            @Override // com.liulishuo.okdownload.core.listener.assist.Listener1Assist.Listener1Callback
            public void taskStart(DownloadTask task, Listener1Assist.Listener1Model model) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(model, "model");
                Function2<DownloadTask, Listener1Assist.Listener1Model, Unit> function23 = function2;
                if (function23 != null) {
                    function23.invoke(task, model);
                }
            }
        };
    }

    public static /* synthetic */ DownloadListener1 createListener1$default(Function2 function2, Function2 function22, Function4 function4, Function3 function3, Function4 function42, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function2 = null;
        }
        if ((i10 & 2) != 0) {
            function22 = null;
        }
        if ((i10 & 4) != 0) {
            function4 = null;
        }
        if ((i10 & 8) != 0) {
            function3 = null;
        }
        return createListener1(function2, function22, function4, function3, function42);
    }
}
