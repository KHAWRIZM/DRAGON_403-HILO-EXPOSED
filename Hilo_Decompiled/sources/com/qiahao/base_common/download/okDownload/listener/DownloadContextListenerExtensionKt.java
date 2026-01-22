package com.qiahao.base_common.download.okDownload.listener;

import com.liulishuo.okdownload.DownloadContext;
import com.liulishuo.okdownload.DownloadContextListener;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.core.cause.EndCause;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a±\u0001\u0010\u0011\u001a\u00020\u00122\u0081\u0001\b\u0002\u0010\u0000\u001a{\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0001j\u0004\u0018\u0001`\u00132%\u0010\u000f\u001a!\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u000e0\u0010j\u0002`\u0014*ì\u0001\u0010\u0000\"s\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u00012s\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0001*@\u0010\u000f\"\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u000e0\u00102\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u000e0\u0010¨\u0006\u0015"}, d2 = {"onQueueTaskEnd", "Lkotlin/Function5;", "Lcom/liulishuo/okdownload/DownloadContext;", "Lkotlin/ParameterName;", "name", "context", "Lcom/liulishuo/okdownload/DownloadTask;", "task", "Lcom/liulishuo/okdownload/core/cause/EndCause;", "cause", "Ljava/lang/Exception;", "realException", "", "remainCount", "", "onQueueEnd", "Lkotlin/Function1;", "createDownloadContextListener", "Lcom/liulishuo/okdownload/DownloadContextListener;", "Lcom/qiahao/base_common/download/okDownload/listener/onQueueTaskEnd;", "Lcom/qiahao/base_common/download/okDownload/listener/onQueueEnd;", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DownloadContextListenerExtensionKt {
    @NotNull
    public static final DownloadContextListener createDownloadContextListener(@Nullable final Function5<? super DownloadContext, ? super DownloadTask, ? super EndCause, ? super Exception, ? super Integer, Unit> function5, @NotNull final Function1<? super DownloadContext, Unit> onQueueEnd) {
        Intrinsics.checkNotNullParameter(onQueueEnd, "onQueueEnd");
        return new DownloadContextListener() { // from class: com.qiahao.base_common.download.okDownload.listener.DownloadContextListenerExtensionKt$createDownloadContextListener$1
            @Override // com.liulishuo.okdownload.DownloadContextListener
            public void queueEnd(DownloadContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
                onQueueEnd.invoke(context);
            }

            @Override // com.liulishuo.okdownload.DownloadContextListener
            public void taskEnd(DownloadContext context, DownloadTask task, EndCause cause, Exception realCause, int remainCount) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(cause, "cause");
                Function5<DownloadContext, DownloadTask, EndCause, Exception, Integer, Unit> function52 = function5;
                if (function52 != null) {
                    function52.invoke(context, task, cause, realCause, Integer.valueOf(remainCount));
                }
            }
        };
    }

    public static /* synthetic */ DownloadContextListener createDownloadContextListener$default(Function5 function5, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function5 = null;
        }
        return createDownloadContextListener(function5, function1);
    }
}
