package com.qiahao.base_common.download.okDownload.listener;

import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.listener.DownloadListener2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0082\u0001\u0010\u0000\u001a\u00020\u00012'\b\u0002\u0010\u0002\u001a!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\t2Q\u0010\n\u001aM\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\u000bj\u0002`\u0010¨\u0006\u0011"}, d2 = {"createListener2", "Lcom/liulishuo/okdownload/core/listener/DownloadListener2;", "onTaskStart", "Lkotlin/Function1;", "Lcom/liulishuo/okdownload/DownloadTask;", "Lkotlin/ParameterName;", "name", "task", "", "Lcom/qiahao/base_common/download/okDownload/listener/onTaskStart;", "onTaskEnd", "Lkotlin/Function3;", "Lcom/liulishuo/okdownload/core/cause/EndCause;", "cause", "Ljava/lang/Exception;", "realCause", "Lcom/qiahao/base_common/download/okDownload/listener/onTaskEnd;", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DownloadListener2ExtensionKt {
    @NotNull
    public static final DownloadListener2 createListener2(@NotNull final Function1<? super DownloadTask, Unit> onTaskStart, @NotNull final Function3<? super DownloadTask, ? super EndCause, ? super Exception, Unit> onTaskEnd) {
        Intrinsics.checkNotNullParameter(onTaskStart, "onTaskStart");
        Intrinsics.checkNotNullParameter(onTaskEnd, "onTaskEnd");
        return new DownloadListener2() { // from class: com.qiahao.base_common.download.okDownload.listener.DownloadListener2ExtensionKt$createListener2$2
            @Override // com.liulishuo.okdownload.DownloadListener
            public void taskEnd(DownloadTask task, EndCause cause, Exception realCause) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(cause, "cause");
                onTaskEnd.invoke(task, cause, realCause);
            }

            @Override // com.liulishuo.okdownload.DownloadListener
            public void taskStart(DownloadTask task) {
                Intrinsics.checkNotNullParameter(task, "task");
                onTaskStart.invoke(task);
            }
        };
    }

    public static /* synthetic */ DownloadListener2 createListener2$default(Function1 function1, Function3 function3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function1 = new Function1() { // from class: com.qiahao.base_common.download.okDownload.listener.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit createListener2$lambda$0;
                    createListener2$lambda$0 = DownloadListener2ExtensionKt.createListener2$lambda$0((DownloadTask) obj2);
                    return createListener2$lambda$0;
                }
            };
        }
        return createListener2(function1, function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createListener2$lambda$0(DownloadTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
