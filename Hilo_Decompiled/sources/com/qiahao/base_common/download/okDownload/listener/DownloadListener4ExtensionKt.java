package com.qiahao.base_common.download.okDownload.listener;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.core.breakpoint.BlockInfo;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.listener.DownloadListener4;
import com.liulishuo.okdownload.core.listener.assist.Listener4Assist;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aä\u0005\u0010\u001e\u001a\u00020\u001f2+\b\u0002\u0010 \u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010!j\u0004\u0018\u0001`\"2g\b\u0002\u0010#\u001aa\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012%\u0012#\u0012\u0004\u0012\u00020%\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0&0$¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\f\u0018\u00010\u000ej\u0004\u0018\u0001`(2|\b\u0002\u0010)\u001av\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(*\u0012%\u0012#\u0012\u0004\u0012\u00020%\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0&0$¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\f\u0018\u00010\u0001j\u0004\u0018\u0001`,2j\b\u0002\u0010\u0000\u001ad\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0001j\u0004\u0018\u0001`-2U\b\u0002\u0010\r\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\f\u0018\u00010\u000ej\u0004\u0018\u0001`.2@\b\u0002\u0010\u0013\u001a:\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014j\u0004\u0018\u0001`/2U\b\u0002\u0010\u0016\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000ej\u0004\u0018\u0001`02l\u0010\u0018\u001ah\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001a\u0012\u001b\u0012\u0019\u0018\u00010\u001cj\u0004\u0018\u0001`\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0001j\u0002`1*¾\u0001\u0010\u0000\"\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u00012\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0001*\u0094\u0001\u0010\r\"G\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\f0\u000e2G\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\f0\u000e*j\u0010\u0013\"2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\f0\u001422\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\f0\u0014*\u0094\u0001\u0010\u0016\"G\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\f0\u000e2G\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\f0\u000e*¹\u0001\u0010\u0018\"O\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001a\u0012\u0006\u0012\u0004\u0018\u0001`\u001b\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u00012d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001a\u0012\u001b\u0012\u0019\u0018\u00010\u001cj\u0004\u0018\u0001`\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0001¨\u00062"}, d2 = {"onInfoReady", "Lkotlin/Function4;", "Lcom/liulishuo/okdownload/DownloadTask;", "Lkotlin/ParameterName;", "name", "task", "Lcom/liulishuo/okdownload/core/breakpoint/BreakpointInfo;", "info", "", "fromBreakpoint", "Lcom/liulishuo/okdownload/core/listener/assist/Listener4Assist$Listener4Model;", DeviceRequestsHelper.DEVICE_INFO_MODEL, "", "onProgressBlock", "Lkotlin/Function3;", "", "blockIndex", "", "currentBlockOffset", "onProgressWithoutTotalLength", "Lkotlin/Function2;", "currentOffset", "onBlockEnd", "Lcom/liulishuo/okdownload/core/breakpoint/BlockInfo;", "onTaskEndWithListener4Model", "Lcom/liulishuo/okdownload/core/cause/EndCause;", "cause", "Lkotlin/Exception;", "Ljava/lang/Exception;", "realCause", "createListener4", "Lcom/liulishuo/okdownload/core/listener/DownloadListener4;", "onTaskStart", "Lkotlin/Function1;", "Lcom/qiahao/base_common/download/okDownload/listener/onTaskStart;", "onConnectStart", "", "", "", "requestHeaderFields", "Lcom/qiahao/base_common/download/okDownload/listener/onConnectStart;", "onConnectEnd", "responseCode", "responseHeaderFields", "Lcom/qiahao/base_common/download/okDownload/listener/onConnectEnd;", "Lcom/qiahao/base_common/download/okDownload/listener/onInfoReady;", "Lcom/qiahao/base_common/download/okDownload/listener/onProgressBlock;", "Lcom/qiahao/base_common/download/okDownload/listener/onProgressWithoutTotalLength;", "Lcom/qiahao/base_common/download/okDownload/listener/onBlockEnd;", "Lcom/qiahao/base_common/download/okDownload/listener/onTaskEndWithListener4Model;", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DownloadListener4ExtensionKt {
    @NotNull
    public static final DownloadListener4 createListener4(@Nullable final Function1<? super DownloadTask, Unit> function1, @Nullable final Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function3, @Nullable final Function4<? super DownloadTask, ? super Integer, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function4, @Nullable final Function4<? super DownloadTask, ? super BreakpointInfo, ? super Boolean, ? super Listener4Assist.Listener4Model, Unit> function42, @Nullable final Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function32, @Nullable final Function2<? super DownloadTask, ? super Long, Unit> function2, @Nullable final Function3<? super DownloadTask, ? super Integer, ? super BlockInfo, Unit> function33, @NotNull final Function4<? super DownloadTask, ? super EndCause, ? super Exception, ? super Listener4Assist.Listener4Model, Unit> onTaskEndWithListener4Model) {
        Intrinsics.checkNotNullParameter(onTaskEndWithListener4Model, "onTaskEndWithListener4Model");
        return new DownloadListener4() { // from class: com.qiahao.base_common.download.okDownload.listener.DownloadListener4ExtensionKt$createListener4$1
            @Override // com.liulishuo.okdownload.core.listener.assist.Listener4Assist.Listener4Callback
            public void blockEnd(DownloadTask task, int blockIndex, BlockInfo info) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(info, "info");
                Function3<DownloadTask, Integer, BlockInfo, Unit> function34 = function33;
                if (function34 != null) {
                    function34.invoke(task, Integer.valueOf(blockIndex), info);
                }
            }

            @Override // com.liulishuo.okdownload.DownloadListener
            public void connectEnd(DownloadTask task, int blockIndex, int responseCode, Map<String, List<String>> responseHeaderFields) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(responseHeaderFields, "responseHeaderFields");
                Function4<DownloadTask, Integer, Integer, Map<String, ? extends List<String>>, Unit> function43 = function4;
                if (function43 != null) {
                    function43.invoke(task, Integer.valueOf(blockIndex), Integer.valueOf(responseCode), responseHeaderFields);
                }
            }

            @Override // com.liulishuo.okdownload.DownloadListener
            public void connectStart(DownloadTask task, int blockIndex, Map<String, List<String>> requestHeaderFields) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(requestHeaderFields, "requestHeaderFields");
                Function3<DownloadTask, Integer, Map<String, ? extends List<String>>, Unit> function34 = function3;
                if (function34 != null) {
                    function34.invoke(task, Integer.valueOf(blockIndex), requestHeaderFields);
                }
            }

            @Override // com.liulishuo.okdownload.core.listener.assist.Listener4Assist.Listener4Callback
            public void infoReady(DownloadTask task, BreakpointInfo info, boolean fromBreakpoint, Listener4Assist.Listener4Model model) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(info, "info");
                Intrinsics.checkNotNullParameter(model, "model");
                Function4<DownloadTask, BreakpointInfo, Boolean, Listener4Assist.Listener4Model, Unit> function43 = function42;
                if (function43 != null) {
                    function43.invoke(task, info, Boolean.valueOf(fromBreakpoint), model);
                }
            }

            @Override // com.liulishuo.okdownload.core.listener.assist.Listener4Assist.Listener4Callback
            public void progress(DownloadTask task, long currentOffset) {
                Intrinsics.checkNotNullParameter(task, "task");
                Function2<DownloadTask, Long, Unit> function22 = function2;
                if (function22 != null) {
                    function22.invoke(task, Long.valueOf(currentOffset));
                }
            }

            @Override // com.liulishuo.okdownload.core.listener.assist.Listener4Assist.Listener4Callback
            public void progressBlock(DownloadTask task, int blockIndex, long currentBlockOffset) {
                Intrinsics.checkNotNullParameter(task, "task");
                Function3<DownloadTask, Integer, Long, Unit> function34 = function32;
                if (function34 != null) {
                    function34.invoke(task, Integer.valueOf(blockIndex), Long.valueOf(currentBlockOffset));
                }
            }

            @Override // com.liulishuo.okdownload.core.listener.assist.Listener4Assist.Listener4Callback
            public void taskEnd(DownloadTask task, EndCause cause, Exception realCause, Listener4Assist.Listener4Model model) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(cause, "cause");
                Intrinsics.checkNotNullParameter(model, "model");
                onTaskEndWithListener4Model.invoke(task, cause, realCause, model);
            }

            @Override // com.liulishuo.okdownload.DownloadListener
            public void taskStart(DownloadTask task) {
                Intrinsics.checkNotNullParameter(task, "task");
                Function1<DownloadTask, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(task);
                }
            }
        };
    }

    public static /* synthetic */ DownloadListener4 createListener4$default(Function1 function1, Function3 function3, Function4 function4, Function4 function42, Function3 function32, Function2 function2, Function3 function33, Function4 function43, int i10, Object obj) {
        Function1 function12;
        Function3 function34;
        Function4 function44;
        Function4 function45;
        Function3 function35;
        Function2 function22;
        Function3 function36;
        if ((i10 & 1) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        if ((i10 & 2) != 0) {
            function34 = null;
        } else {
            function34 = function3;
        }
        if ((i10 & 4) != 0) {
            function44 = null;
        } else {
            function44 = function4;
        }
        if ((i10 & 8) != 0) {
            function45 = null;
        } else {
            function45 = function42;
        }
        if ((i10 & 16) != 0) {
            function35 = null;
        } else {
            function35 = function32;
        }
        if ((i10 & 32) != 0) {
            function22 = null;
        } else {
            function22 = function2;
        }
        if ((i10 & 64) != 0) {
            function36 = null;
        } else {
            function36 = function33;
        }
        return createListener4(function12, function34, function44, function45, function35, function22, function36, function43);
    }
}
