package com.qiahao.base_common.download.okDownload.listener;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.SpeedCalculator;
import com.liulishuo.okdownload.core.breakpoint.BlockInfo;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.listener.DownloadListener4WithSpeed;
import com.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a£\u0006\u0010 \u001a\u00020!2+\b\u0002\u0010\"\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010#j\u0004\u0018\u0001`$2g\b\u0002\u0010%\u001aa\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012%\u0012#\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0(0&¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\f\u0018\u00010\u0015j\u0004\u0018\u0001`*2|\b\u0002\u0010+\u001av\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(,\u0012%\u0012#\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0(0&¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\f\u0018\u00010\u0001j\u0004\u0018\u0001`.2j\b\u0002\u0010\u0000\u001ad\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0001j\u0004\u0018\u0001`/2j\b\u0002\u0010\r\u001ad\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f\u0018\u00010\u0001j\u0004\u0018\u0001`02U\b\u0002\u0010\u0014\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\f\u0018\u00010\u0015j\u0004\u0018\u0001`12j\b\u0002\u0010\u0018\u001ad\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f\u0018\u00010\u0001j\u0004\u0018\u0001`22l\u0010\u001a\u001ah\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001c\u0012\u001b\u0012\u0019\u0018\u00010\u001ej\u0004\u0018\u0001`\u001d¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\f0\u0001j\u0002`3*¾\u0001\u0010\u0000\"\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u00012\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0001*¾\u0001\u0010\r\"\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u00012\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u0001*\u0094\u0001\u0010\u0014\"G\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\f0\u00152G\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\f0\u0015*¾\u0001\u0010\u0018\"\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u00012\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u0001*¹\u0001\u0010\u001a\"O\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001c\u0012\u0006\u0012\u0004\u0018\u0001`\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\f0\u00012d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001c\u0012\u001b\u0012\u0019\u0018\u00010\u001ej\u0004\u0018\u0001`\u001d¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\f0\u0001¨\u00064"}, d2 = {"onInfoReadyWithSpeed", "Lkotlin/Function4;", "Lcom/liulishuo/okdownload/DownloadTask;", "Lkotlin/ParameterName;", "name", "task", "Lcom/liulishuo/okdownload/core/breakpoint/BreakpointInfo;", "info", "", "fromBreakpoint", "Lcom/liulishuo/okdownload/core/listener/assist/Listener4SpeedAssistExtend$Listener4SpeedModel;", DeviceRequestsHelper.DEVICE_INFO_MODEL, "", "onProgressBlockWithSpeed", "", "blockIndex", "", "currentBlockOffset", "Lcom/liulishuo/okdownload/SpeedCalculator;", "blockSpeed", "onProgressWithSpeed", "Lkotlin/Function3;", "currentOffset", "taskSpeed", "onBlockEndWithSpeed", "Lcom/liulishuo/okdownload/core/breakpoint/BlockInfo;", "onTaskEndWithSpeed", "Lcom/liulishuo/okdownload/core/cause/EndCause;", "cause", "Lkotlin/Exception;", "Ljava/lang/Exception;", "realCause", "createListener4WithSpeed", "Lcom/liulishuo/okdownload/core/listener/DownloadListener4WithSpeed;", "onTaskStart", "Lkotlin/Function1;", "Lcom/qiahao/base_common/download/okDownload/listener/onTaskStart;", "onConnectStart", "", "", "", "requestHeaderFields", "Lcom/qiahao/base_common/download/okDownload/listener/onConnectStart;", "onConnectEnd", "responseCode", "responseHeaderFields", "Lcom/qiahao/base_common/download/okDownload/listener/onConnectEnd;", "Lcom/qiahao/base_common/download/okDownload/listener/onInfoReadyWithSpeed;", "Lcom/qiahao/base_common/download/okDownload/listener/onProgressBlockWithSpeed;", "Lcom/qiahao/base_common/download/okDownload/listener/onProgressWithSpeed;", "Lcom/qiahao/base_common/download/okDownload/listener/onBlockEndWithSpeed;", "Lcom/qiahao/base_common/download/okDownload/listener/onTaskEndWithSpeed;", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DownloadListener4WithSpeedExtensionKt {
    @NotNull
    public static final DownloadListener4WithSpeed createListener4WithSpeed(@Nullable final Function1<? super DownloadTask, Unit> function1, @Nullable final Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function3, @Nullable final Function4<? super DownloadTask, ? super Integer, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function4, @Nullable final Function4<? super DownloadTask, ? super BreakpointInfo, ? super Boolean, ? super Listener4SpeedAssistExtend.Listener4SpeedModel, Unit> function42, @Nullable final Function4<? super DownloadTask, ? super Integer, ? super Long, ? super SpeedCalculator, Unit> function43, @Nullable final Function3<? super DownloadTask, ? super Long, ? super SpeedCalculator, Unit> function32, @Nullable final Function4<? super DownloadTask, ? super Integer, ? super BlockInfo, ? super SpeedCalculator, Unit> function44, @NotNull final Function4<? super DownloadTask, ? super EndCause, ? super Exception, ? super SpeedCalculator, Unit> onTaskEndWithSpeed) {
        Intrinsics.checkNotNullParameter(onTaskEndWithSpeed, "onTaskEndWithSpeed");
        return new DownloadListener4WithSpeed() { // from class: com.qiahao.base_common.download.okDownload.listener.DownloadListener4WithSpeedExtensionKt$createListener4WithSpeed$1
            @Override // com.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
            public void blockEnd(DownloadTask task, int blockIndex, BlockInfo info, SpeedCalculator blockSpeed) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(info, "info");
                Intrinsics.checkNotNullParameter(blockSpeed, "blockSpeed");
                Function4<DownloadTask, Integer, BlockInfo, SpeedCalculator, Unit> function45 = function44;
                if (function45 != null) {
                    function45.invoke(task, Integer.valueOf(blockIndex), info, blockSpeed);
                }
            }

            @Override // com.liulishuo.okdownload.DownloadListener
            public void connectEnd(DownloadTask task, int blockIndex, int responseCode, Map<String, List<String>> responseHeaderFields) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(responseHeaderFields, "responseHeaderFields");
                Function4<DownloadTask, Integer, Integer, Map<String, ? extends List<String>>, Unit> function45 = function4;
                if (function45 != null) {
                    function45.invoke(task, Integer.valueOf(blockIndex), Integer.valueOf(responseCode), responseHeaderFields);
                }
            }

            @Override // com.liulishuo.okdownload.DownloadListener
            public void connectStart(DownloadTask task, int blockIndex, Map<String, List<String>> requestHeaderFields) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(requestHeaderFields, "requestHeaderFields");
                Function3<DownloadTask, Integer, Map<String, ? extends List<String>>, Unit> function33 = function3;
                if (function33 != null) {
                    function33.invoke(task, Integer.valueOf(blockIndex), requestHeaderFields);
                }
            }

            @Override // com.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
            public void infoReady(DownloadTask task, BreakpointInfo info, boolean fromBreakpoint, Listener4SpeedAssistExtend.Listener4SpeedModel model) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(info, "info");
                Intrinsics.checkNotNullParameter(model, "model");
                Function4<DownloadTask, BreakpointInfo, Boolean, Listener4SpeedAssistExtend.Listener4SpeedModel, Unit> function45 = function42;
                if (function45 != null) {
                    function45.invoke(task, info, Boolean.valueOf(fromBreakpoint), model);
                }
            }

            @Override // com.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
            public void progress(DownloadTask task, long currentOffset, SpeedCalculator taskSpeed) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(taskSpeed, "taskSpeed");
                Function3<DownloadTask, Long, SpeedCalculator, Unit> function33 = function32;
                if (function33 != null) {
                    function33.invoke(task, Long.valueOf(currentOffset), taskSpeed);
                }
            }

            @Override // com.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
            public void progressBlock(DownloadTask task, int blockIndex, long currentBlockOffset, SpeedCalculator blockSpeed) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(blockSpeed, "blockSpeed");
                Function4<DownloadTask, Integer, Long, SpeedCalculator, Unit> function45 = function43;
                if (function45 != null) {
                    function45.invoke(task, Integer.valueOf(blockIndex), Long.valueOf(currentBlockOffset), blockSpeed);
                }
            }

            @Override // com.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
            public void taskEnd(DownloadTask task, EndCause cause, Exception realCause, SpeedCalculator taskSpeed) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(cause, "cause");
                Intrinsics.checkNotNullParameter(taskSpeed, "taskSpeed");
                onTaskEndWithSpeed.invoke(task, cause, realCause, taskSpeed);
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

    public static /* synthetic */ DownloadListener4WithSpeed createListener4WithSpeed$default(Function1 function1, Function3 function3, Function4 function4, Function4 function42, Function4 function43, Function3 function32, Function4 function44, Function4 function45, int i10, Object obj) {
        Function1 function12;
        Function3 function33;
        Function4 function46;
        Function4 function47;
        Function4 function48;
        Function3 function34;
        Function4 function49;
        if ((i10 & 1) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        if ((i10 & 2) != 0) {
            function33 = null;
        } else {
            function33 = function3;
        }
        if ((i10 & 4) != 0) {
            function46 = null;
        } else {
            function46 = function4;
        }
        if ((i10 & 8) != 0) {
            function47 = null;
        } else {
            function47 = function42;
        }
        if ((i10 & 16) != 0) {
            function48 = null;
        } else {
            function48 = function43;
        }
        if ((i10 & 32) != 0) {
            function34 = null;
        } else {
            function34 = function32;
        }
        if ((i10 & 64) != 0) {
            function49 = null;
        } else {
            function49 = function44;
        }
        return createListener4WithSpeed(function12, function33, function46, function47, function48, function34, function49, function45);
    }
}
