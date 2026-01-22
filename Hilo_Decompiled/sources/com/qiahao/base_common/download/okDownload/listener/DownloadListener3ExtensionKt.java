package com.qiahao.base_common.download.okDownload.listener;

import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.liulishuo.okdownload.core.listener.DownloadListener3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0095\u0004\u0010\u0011\u001a\u00020\u00122+\b\u0002\u0010\u0007\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0001j\u0004\u0018\u0001`\u00132j\b\u0002\u0010\u0014\u001ad\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015j\u0004\u0018\u0001`\u001b2U\b\u0002\u0010\u001c\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e2+\b\u0002\u0010\t\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0001j\u0004\u0018\u0001`\u001f2+\b\u0002\u0010\n\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0001j\u0004\u0018\u0001` 2+\b\u0002\u0010\u000b\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0001j\u0004\u0018\u0001`!2@\b\u0002\u0010\"\u001a:\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rj\u0004\u0018\u0001`%2D\b\u0002\u0010\f\u001a>\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0017\u0012\u00150\u000fj\u0002`\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rj\u0004\u0018\u0001`&2\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060(*@\u0010\u0000\"\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001*)\u0010\u0007\"\u0002`\b2!\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\b*)\u0010\t\"\u0002`\b2!\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\b*)\u0010\n\"\u0002`\b2!\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\b*)\u0010\u000b\"\u0002`\b2!\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\b*_\u0010\f\"#\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u0002`\u000e\u0012\u0004\u0012\u00020\u00060\r26\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0017\u0012\u00150\u000fj\u0002`\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\r¨\u0006)"}, d2 = {"taskCallback", "Lkotlin/Function1;", "Lcom/liulishuo/okdownload/DownloadTask;", "Lkotlin/ParameterName;", "name", "task", "", "onStarted", "Lcom/qiahao/base_common/download/okDownload/listener/taskCallback;", "onCompleted", "onCanceled", "onWarn", "onError", "Lkotlin/Function2;", "Lkotlin/Exception;", "Ljava/lang/Exception;", "e", "createListener3", "Lcom/liulishuo/okdownload/core/listener/DownloadListener3;", "Lcom/qiahao/base_common/download/okDownload/listener/onStarted;", "onConnected", "Lkotlin/Function4;", "", "blockCount", "", "currentOffset", "totalLength", "Lcom/qiahao/base_common/download/okDownload/listener/onConnected;", "onProgress", "Lkotlin/Function3;", "Lcom/qiahao/base_common/download/okDownload/listener/onProgress;", "Lcom/qiahao/base_common/download/okDownload/listener/onCompleted;", "Lcom/qiahao/base_common/download/okDownload/listener/onCanceled;", "Lcom/qiahao/base_common/download/okDownload/listener/onWarn;", "onRetry", "Lcom/liulishuo/okdownload/core/cause/ResumeFailedCause;", "cause", "Lcom/qiahao/base_common/download/okDownload/listener/onRetry;", "Lcom/qiahao/base_common/download/okDownload/listener/onError;", "onTerminal", "Lkotlin/Function0;", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DownloadListener3ExtensionKt {
    @NotNull
    public static final DownloadListener3 createListener3(@Nullable final Function1<? super DownloadTask, Unit> function1, @Nullable final Function4<? super DownloadTask, ? super Integer, ? super Long, ? super Long, Unit> function4, @Nullable final Function3<? super DownloadTask, ? super Long, ? super Long, Unit> function3, @Nullable final Function1<? super DownloadTask, Unit> function12, @Nullable final Function1<? super DownloadTask, Unit> function13, @Nullable final Function1<? super DownloadTask, Unit> function14, @Nullable final Function2<? super DownloadTask, ? super ResumeFailedCause, Unit> function2, @Nullable final Function2<? super DownloadTask, ? super Exception, Unit> function22, @NotNull final Function0<Unit> onTerminal) {
        Intrinsics.checkNotNullParameter(onTerminal, "onTerminal");
        return new DownloadListener3() { // from class: com.qiahao.base_common.download.okDownload.listener.DownloadListener3ExtensionKt$createListener3$2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.liulishuo.okdownload.core.listener.DownloadListener3
            public void canceled(DownloadTask task) {
                Intrinsics.checkNotNullParameter(task, "task");
                Function1<DownloadTask, Unit> function15 = function13;
                if (function15 != null) {
                    function15.invoke(task);
                }
                onTerminal.invoke();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.liulishuo.okdownload.core.listener.DownloadListener3
            public void completed(DownloadTask task) {
                Intrinsics.checkNotNullParameter(task, "task");
                Function1<DownloadTask, Unit> function15 = function12;
                if (function15 != null) {
                    function15.invoke(task);
                }
                onTerminal.invoke();
            }

            @Override // com.liulishuo.okdownload.core.listener.assist.Listener1Assist.Listener1Callback
            public void connected(DownloadTask task, int blockCount, long currentOffset, long totalLength) {
                Intrinsics.checkNotNullParameter(task, "task");
                Function4<DownloadTask, Integer, Long, Long, Unit> function42 = function4;
                if (function42 != null) {
                    function42.invoke(task, Integer.valueOf(blockCount), Long.valueOf(currentOffset), Long.valueOf(totalLength));
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.liulishuo.okdownload.core.listener.DownloadListener3
            public void error(DownloadTask task, Exception e10) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(e10, "e");
                Function2<DownloadTask, Exception, Unit> function23 = function22;
                if (function23 != null) {
                    function23.invoke(task, e10);
                }
                onTerminal.invoke();
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
                Function2<DownloadTask, ResumeFailedCause, Unit> function23 = function2;
                if (function23 != null) {
                    function23.invoke(task, cause);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.liulishuo.okdownload.core.listener.DownloadListener3
            public void started(DownloadTask task) {
                Intrinsics.checkNotNullParameter(task, "task");
                Function1<DownloadTask, Unit> function15 = function1;
                if (function15 != null) {
                    function15.invoke(task);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.liulishuo.okdownload.core.listener.DownloadListener3
            public void warn(DownloadTask task) {
                Intrinsics.checkNotNullParameter(task, "task");
                Function1<DownloadTask, Unit> function15 = function14;
                if (function15 != null) {
                    function15.invoke(task);
                }
                onTerminal.invoke();
            }
        };
    }

    public static /* synthetic */ DownloadListener3 createListener3$default(Function1 function1, Function4 function4, Function3 function3, Function1 function12, Function1 function13, Function1 function14, Function2 function2, Function2 function22, Function0 function0, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function1 = null;
        }
        if ((i10 & 2) != 0) {
            function4 = null;
        }
        if ((i10 & 4) != 0) {
            function3 = null;
        }
        if ((i10 & 8) != 0) {
            function12 = null;
        }
        if ((i10 & 16) != 0) {
            function13 = null;
        }
        if ((i10 & 32) != 0) {
            function14 = null;
        }
        if ((i10 & 64) != 0) {
            function2 = null;
        }
        if ((i10 & 128) != 0) {
            function22 = null;
        }
        if ((i10 & 256) != 0) {
            function0 = new Function0() { // from class: com.qiahao.base_common.download.okDownload.listener.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        return createListener3(function1, function4, function3, function12, function13, function14, function2, function22, function0);
    }
}
