package com.qiahao.base_common.download.okDownload;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.liulishuo.okdownload.DownloadListener;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.SpeedCalculator;
import com.liulishuo.okdownload.core.breakpoint.BlockInfo;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.liulishuo.okdownload.core.listener.DownloadListener1;
import com.liulishuo.okdownload.core.listener.assist.Listener1Assist;
import com.liulishuo.okdownload.core.listener.assist.Listener4Assist;
import com.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend;
import com.qiahao.base_common.download.okDownload.listener.DownloadListener1ExtensionKt;
import com.qiahao.base_common.download.okDownload.listener.DownloadListener2ExtensionKt;
import com.qiahao.base_common.download.okDownload.listener.DownloadListener3ExtensionKt;
import com.qiahao.base_common.download.okDownload.listener.DownloadListener4ExtensionKt;
import com.qiahao.base_common.download.okDownload.listener.DownloadListener4WithSpeedExtensionKt;
import com.qiahao.base_common.download.okDownload.listener.DownloadListenerExtensionKt;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000ð\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aÌ\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022+\b\u0002\u0010\u0003\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\u0004\u0018\u0001`\b2R\b\u0002\u0010\t\u001aL\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012%\u0012#\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0004\u0018\u0001`\u000f2g\b\u0002\u0010\u0010\u001aa\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012%\u0012#\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`\u00152U\b\u0002\u0010\u0016\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`\u001b2@\b\u0002\u0010\u001c\u001a:\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0004\u0018\u0001`\u001d2g\b\u0002\u0010\u001e\u001aa\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012%\u0012#\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001` 2|\b\u0002\u0010!\u001av\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012%\u0012#\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"j\u0004\u0018\u0001`#2U\b\u0002\u0010$\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`'2U\b\u0002\u0010(\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`*2U\b\u0002\u0010+\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`,2Q\u0010-\u001aM\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110.¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010/¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010\u0011j\u0002`1\u001a¹\u0003\u00102\u001a\u00020\u0001*\u00020\u00022@\b\u0002\u00103\u001a:\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u001104¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0004\u0018\u0001`62@\b\u0002\u00107\u001a:\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0004\u0018\u0001`82j\b\u0002\u00109\u001ad\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"j\u0004\u0018\u0001`=2U\b\u0002\u0010>\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`?2f\u0010@\u001ab\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110.¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010/¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(0\u0012\u0013\u0012\u001104¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u00010\"j\u0002`A\u001a\u0086\u0001\u0010B\u001a\u00020\u0001*\u00020\u00022'\b\u0002\u0010\u0003\u001a!\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0004j\u0002`\b2Q\u0010-\u001aM\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110.¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010/¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010\u0011j\u0002`1\u001a\u0099\u0004\u0010C\u001a\u00020\u0001*\u00020\u00022+\b\u0002\u0010D\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\u0004\u0018\u0001`E2j\b\u0002\u0010F\u001ad\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"j\u0004\u0018\u0001`=2U\b\u0002\u0010G\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`?2+\b\u0002\u0010H\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\u0004\u0018\u0001`I2+\b\u0002\u0010J\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\u0004\u0018\u0001`K2+\b\u0002\u0010L\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\u0004\u0018\u0001`M2@\b\u0002\u0010N\u001a:\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0004\u0018\u0001`82D\b\u0002\u0010O\u001a>\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0017\u0012\u00150/j\u0002`Q¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0004\u0018\u0001`R2\u000e\b\u0002\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00010T\u001aè\u0005\u0010U\u001a\u00020\u0001*\u00020\u00022+\b\u0002\u0010\u0003\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\u0004\u0018\u0001`\b2g\b\u0002\u0010\u001e\u001aa\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012%\u0012#\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001` 2|\b\u0002\u0010!\u001av\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012%\u0012#\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"j\u0004\u0018\u0001`#2j\b\u0002\u0010V\u001ad\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110W¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(X\u0012\u0013\u0012\u00110Y¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"j\u0004\u0018\u0001`Z2U\b\u0002\u0010[\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\\\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`]2@\b\u0002\u0010^\u001a:\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0004\u0018\u0001`_2U\b\u0002\u0010`\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110a¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`b2l\u0010c\u001ah\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110.¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u001b\u0012\u0019\u0018\u00010/j\u0004\u0018\u0001`Q¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110Y¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u00010\"j\u0002`d\u001a§\u0006\u0010e\u001a\u00020\u0001*\u00020\u00022+\b\u0002\u0010\u0003\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\u0004\u0018\u0001`\b2g\b\u0002\u0010\u001e\u001aa\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012%\u0012#\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001` 2|\b\u0002\u0010!\u001av\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012%\u0012#\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"j\u0004\u0018\u0001`#2j\b\u0002\u0010f\u001ad\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110W¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(X\u0012\u0013\u0012\u00110g¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"j\u0004\u0018\u0001`h2j\b\u0002\u0010i\u001ad\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\\\u0012\u0013\u0012\u00110j¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"j\u0004\u0018\u0001`l2U\b\u0002\u0010m\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110j¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`o2j\b\u0002\u0010p\u001ad\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110a¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110j¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"j\u0004\u0018\u0001`q2l\u0010r\u001ah\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110.¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u001b\u0012\u0019\u0018\u00010/j\u0004\u0018\u0001`Q¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110j¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(n\u0012\u0004\u0012\u00020\u00010\"j\u0002`s\u001aÌ\u0007\u0010t\u001a\u00020\u0001*\u00020\u00022+\b\u0002\u0010\u0003\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\u0004\u0018\u0001`\b2R\b\u0002\u0010\t\u001aL\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012%\u0012#\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0004\u0018\u0001`\u000f2g\b\u0002\u0010\u0010\u001aa\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012%\u0012#\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`\u00152U\b\u0002\u0010\u0016\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`\u001b2@\b\u0002\u0010\u001c\u001a:\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0004\u0018\u0001`\u001d2g\b\u0002\u0010\u001e\u001aa\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012%\u0012#\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001` 2|\b\u0002\u0010!\u001av\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012%\u0012#\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"j\u0004\u0018\u0001`#2U\b\u0002\u0010$\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`'2U\b\u0002\u0010(\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`*2U\b\u0002\u0010+\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`,2Q\u0010-\u001aM\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110.¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010/¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010\u0011j\u0002`1\u001a¹\u0003\u0010u\u001a\u00020\u0001*\u00020\u00022@\b\u0002\u00103\u001a:\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u001104¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0004\u0018\u0001`62@\b\u0002\u00107\u001a:\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0004\u0018\u0001`82j\b\u0002\u00109\u001ad\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"j\u0004\u0018\u0001`=2U\b\u0002\u0010>\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`?2f\u0010@\u001ab\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110.¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010/¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(0\u0012\u0013\u0012\u001104¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u00010\"j\u0002`A\u001a\u0086\u0001\u0010v\u001a\u00020\u0001*\u00020\u00022'\b\u0002\u0010\u0003\u001a!\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0004j\u0002`\b2Q\u0010-\u001aM\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110.¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010/¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010\u0011j\u0002`1\u001a\u0099\u0004\u0010w\u001a\u00020\u0001*\u00020\u00022+\b\u0002\u0010D\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\u0004\u0018\u0001`E2j\b\u0002\u0010F\u001ad\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"j\u0004\u0018\u0001`=2U\b\u0002\u0010G\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`?2+\b\u0002\u0010H\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\u0004\u0018\u0001`I2+\b\u0002\u0010J\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\u0004\u0018\u0001`K2+\b\u0002\u0010L\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\u0004\u0018\u0001`M2@\b\u0002\u0010N\u001a:\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0004\u0018\u0001`82D\b\u0002\u0010O\u001a>\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0017\u0012\u00150/j\u0002`Q¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0004\u0018\u0001`R2\u000e\b\u0002\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00010T\u001aè\u0005\u0010x\u001a\u00020\u0001*\u00020\u00022+\b\u0002\u0010\u0003\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\u0004\u0018\u0001`\b2g\b\u0002\u0010\u001e\u001aa\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012%\u0012#\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001` 2|\b\u0002\u0010!\u001av\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012%\u0012#\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"j\u0004\u0018\u0001`#2j\b\u0002\u0010V\u001ad\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110W¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(X\u0012\u0013\u0012\u00110Y¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"j\u0004\u0018\u0001`Z2U\b\u0002\u0010[\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\\\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`]2@\b\u0002\u0010^\u001a:\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\u0004\u0018\u0001`_2U\b\u0002\u0010`\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110a¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`b2l\u0010c\u001ah\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110.¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u001b\u0012\u0019\u0018\u00010/j\u0004\u0018\u0001`Q¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110Y¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u00010\"j\u0002`d\u001a§\u0006\u0010y\u001a\u00020\u0001*\u00020\u00022+\b\u0002\u0010\u0003\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\u0004\u0018\u0001`\b2g\b\u0002\u0010\u001e\u001aa\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012%\u0012#\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001` 2|\b\u0002\u0010!\u001av\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012%\u0012#\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"j\u0004\u0018\u0001`#2j\b\u0002\u0010f\u001ad\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110W¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(X\u0012\u0013\u0012\u00110g¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"j\u0004\u0018\u0001`h2j\b\u0002\u0010i\u001ad\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\\\u0012\u0013\u0012\u00110j¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"j\u0004\u0018\u0001`l2U\b\u0002\u0010m\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110j¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`o2j\b\u0002\u0010p\u001ad\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110a¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110j¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"j\u0004\u0018\u0001`q2l\u0010r\u001ah\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110.¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u001b\u0012\u0019\u0018\u00010/j\u0004\u0018\u0001`Q¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110j¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(n\u0012\u0004\u0012\u00020\u00010\"j\u0002`s\u001a\u0010\u0010z\u001a\b\u0012\u0004\u0012\u00020|0{*\u00020\u0002\u001a\u001b\u0010}\u001a\u00020~2\b\u0010\u007f\u001a\u0004\u0018\u00010~2\u0007\u0010\u0080\u0001\u001a\u00020~H\u0000\u001a\u001a\u0010\u0081\u0001\u001a\u00020\u0001*\u0007\u0012\u0002\b\u00030\u0082\u00012\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a&\u0010\u0083\u0001\u001a\u00030\u0084\u0001*\u00020\u00022\u000f\b\u0002\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010TH\u0086@¢\u0006\u0003\u0010\u0086\u0001¨\u0006\u0087\u0001"}, d2 = {"execute", "", "Lcom/liulishuo/okdownload/DownloadTask;", "onTaskStart", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "task", "Lcom/qiahao/base_common/download/okDownload/listener/onTaskStart;", "onConnectTrialStart", "Lkotlin/Function2;", "", "", "", "requestHeaderFields", "Lcom/qiahao/base_common/download/okDownload/listener/onConnectTrialStart;", "onConnectTrialEnd", "Lkotlin/Function3;", "", "responseCode", "responseHeaderFields", "Lcom/qiahao/base_common/download/okDownload/listener/onConnectTrialEnd;", "onDownloadFromBeginning", "Lcom/liulishuo/okdownload/core/breakpoint/BreakpointInfo;", "info", "Lcom/liulishuo/okdownload/core/cause/ResumeFailedCause;", "cause", "Lcom/qiahao/base_common/download/okDownload/listener/onDownloadFromBeginning;", "onDownloadFromBreakpoint", "Lcom/qiahao/base_common/download/okDownload/listener/onDownloadFromBreakpoint;", "onConnectStart", "blockIndex", "Lcom/qiahao/base_common/download/okDownload/listener/onConnectStart;", "onConnectEnd", "Lkotlin/Function4;", "Lcom/qiahao/base_common/download/okDownload/listener/onConnectEnd;", "onFetchStart", "", "contentLength", "Lcom/qiahao/base_common/download/okDownload/listener/onFetchStart;", "onFetchProgress", "increaseBytes", "Lcom/qiahao/base_common/download/okDownload/listener/onFetchProgress;", "onFetchEnd", "Lcom/qiahao/base_common/download/okDownload/listener/onFetchEnd;", "onTaskEnd", "Lcom/liulishuo/okdownload/core/cause/EndCause;", "Ljava/lang/Exception;", "realCause", "Lcom/qiahao/base_common/download/okDownload/listener/onTaskEnd;", "execute1", "taskStart", "Lcom/liulishuo/okdownload/core/listener/assist/Listener1Assist$Listener1Model;", DeviceRequestsHelper.DEVICE_INFO_MODEL, "Lcom/qiahao/base_common/download/okDownload/listener/onTaskStartWithModel;", "retry", "Lcom/qiahao/base_common/download/okDownload/listener/onRetry;", "connected", "blockCount", "currentOffset", "totalLength", "Lcom/qiahao/base_common/download/okDownload/listener/onConnected;", "progress", "Lcom/qiahao/base_common/download/okDownload/listener/onProgress;", "taskEnd", "Lcom/qiahao/base_common/download/okDownload/listener/onTaskEndWithModel;", "execute2", "execute3", "onStarted", "Lcom/qiahao/base_common/download/okDownload/listener/onStarted;", "onConnected", "onProgress", "onCompleted", "Lcom/qiahao/base_common/download/okDownload/listener/onCompleted;", "onCanceled", "Lcom/qiahao/base_common/download/okDownload/listener/onCanceled;", "onWarn", "Lcom/qiahao/base_common/download/okDownload/listener/onWarn;", "onRetry", "onError", "e", "Lkotlin/Exception;", "Lcom/qiahao/base_common/download/okDownload/listener/onError;", "onTerminal", "Lkotlin/Function0;", "execute4", "onInfoReady", "", "fromBreakpoint", "Lcom/liulishuo/okdownload/core/listener/assist/Listener4Assist$Listener4Model;", "Lcom/qiahao/base_common/download/okDownload/listener/onInfoReady;", "onProgressBlock", "currentBlockOffset", "Lcom/qiahao/base_common/download/okDownload/listener/onProgressBlock;", "onProgressWithoutTotalLength", "Lcom/qiahao/base_common/download/okDownload/listener/onProgressWithoutTotalLength;", "onBlockEnd", "Lcom/liulishuo/okdownload/core/breakpoint/BlockInfo;", "Lcom/qiahao/base_common/download/okDownload/listener/onBlockEnd;", "onTaskEndWithListener4Model", "Lcom/qiahao/base_common/download/okDownload/listener/onTaskEndWithListener4Model;", "execute4WithSpeed", "onInfoReadyWithSpeed", "Lcom/liulishuo/okdownload/core/listener/assist/Listener4SpeedAssistExtend$Listener4SpeedModel;", "Lcom/qiahao/base_common/download/okDownload/listener/onInfoReadyWithSpeed;", "onProgressBlockWithSpeed", "Lcom/liulishuo/okdownload/SpeedCalculator;", "blockSpeed", "Lcom/qiahao/base_common/download/okDownload/listener/onProgressBlockWithSpeed;", "onProgressWithSpeed", "taskSpeed", "Lcom/qiahao/base_common/download/okDownload/listener/onProgressWithSpeed;", "onBlockEndWithSpeed", "Lcom/qiahao/base_common/download/okDownload/listener/onBlockEndWithSpeed;", "onTaskEndWithSpeed", "Lcom/qiahao/base_common/download/okDownload/listener/onTaskEndWithSpeed;", "enqueue", "enqueue1", "enqueue2", "enqueue3", "enqueue4", "enqueue4WithSpeed", "spChannel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/qiahao/base_common/download/okDownload/DownloadProgress;", "createReplaceListener", "Lcom/liulishuo/okdownload/DownloadListener;", "oldListener", "progressListener", "cancelDownloadOnCancellation", "Lkotlinx/coroutines/CancellableContinuation;", "await", "Lcom/qiahao/base_common/download/okDownload/DownloadResult;", ChatMenuDialog.CLICK_BLOCK, "(Lcom/liulishuo/okdownload/DownloadTask;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDownloadTaskExtension.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DownloadTaskExtension.kt\ncom/qiahao/base_common/download/okDownload/DownloadTaskExtensionKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,456:1\n1#2:457\n314#3,11:458\n*S KotlinDebug\n*F\n+ 1 DownloadTaskExtension.kt\ncom/qiahao/base_common/download/okDownload/DownloadTaskExtensionKt\n*L\n444#1:458,11\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DownloadTaskExtensionKt {
    @Nullable
    public static final Object await(@NotNull final DownloadTask downloadTask, @NotNull Function0<Unit> function0, @NotNull Continuation<? super DownloadResult> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        downloadTask.enqueue(DownloadListener2ExtensionKt.createListener2(new Function1<DownloadTask, Unit>() { // from class: com.qiahao.base_common.download.okDownload.DownloadTaskExtensionKt$await$3$listener2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadTask downloadTask2) {
                invoke2(downloadTask2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadTask it) {
                Intrinsics.checkNotNullParameter(it, "it");
                DownloadTaskExtensionKt.cancelDownloadOnCancellation(cancellableContinuationImpl, downloadTask);
            }
        }, new Function3<DownloadTask, EndCause, Exception, Unit>() { // from class: com.qiahao.base_common.download.okDownload.DownloadTaskExtensionKt$await$3$listener2$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(DownloadTask downloadTask2, EndCause endCause, Exception exc) {
                invoke2(downloadTask2, endCause, exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadTask downloadTask2, EndCause cause, Exception exc) {
                Intrinsics.checkNotNullParameter(downloadTask2, "<unused var>");
                Intrinsics.checkNotNullParameter(cause, "cause");
                if (exc != null) {
                    CancellableContinuation<DownloadResult> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m٥٤٤constructorimpl(ResultKt.createFailure(exc)));
                } else {
                    CancellableContinuation<DownloadResult> cancellableContinuation2 = cancellableContinuationImpl;
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation2.resumeWith(Result.m٥٤٤constructorimpl(new DownloadResult(cause)));
                }
            }
        }));
        function0.invoke();
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static /* synthetic */ Object await$default(DownloadTask downloadTask, Function0 function0, Continuation continuation, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function0 = new Function0() { // from class: com.qiahao.base_common.download.okDownload.l
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        return await(downloadTask, function0, continuation);
    }

    public static final void cancelDownloadOnCancellation(@NotNull CancellableContinuation<?> cancellableContinuation, @NotNull final DownloadTask task) {
        Intrinsics.checkNotNullParameter(cancellableContinuation, "<this>");
        Intrinsics.checkNotNullParameter(task, "task");
        cancellableContinuation.invokeOnCancellation(new Function1() { // from class: com.qiahao.base_common.download.okDownload.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit cancelDownloadOnCancellation$lambda$18;
                cancelDownloadOnCancellation$lambda$18 = DownloadTaskExtensionKt.cancelDownloadOnCancellation$lambda$18(DownloadTask.this, (Throwable) obj);
                return cancelDownloadOnCancellation$lambda$18;
            }
        });
    }

    public static final Unit cancelDownloadOnCancellation$lambda$18(DownloadTask downloadTask, Throwable th) {
        downloadTask.cancel();
        return Unit.INSTANCE;
    }

    @NotNull
    public static final DownloadListener createReplaceListener(@Nullable DownloadListener downloadListener, @NotNull final DownloadListener progressListener) {
        Intrinsics.checkNotNullParameter(progressListener, "progressListener");
        if (downloadListener == null) {
            return progressListener;
        }
        final DownloadListener switchToExceptProgressListener = DownloadListenerExtensionKt.switchToExceptProgressListener(downloadListener);
        return DownloadListenerExtensionKt.createListener(new Function1() { // from class: com.qiahao.base_common.download.okDownload.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit createReplaceListener$lambda$7;
                createReplaceListener$lambda$7 = DownloadTaskExtensionKt.createReplaceListener$lambda$7(DownloadListener.this, progressListener, (DownloadTask) obj);
                return createReplaceListener$lambda$7;
            }
        }, new Function2() { // from class: com.qiahao.base_common.download.okDownload.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit createReplaceListener$lambda$8;
                createReplaceListener$lambda$8 = DownloadTaskExtensionKt.createReplaceListener$lambda$8(DownloadListener.this, (DownloadTask) obj, (Map) obj2);
                return createReplaceListener$lambda$8;
            }
        }, new Function3() { // from class: com.qiahao.base_common.download.okDownload.c
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit createReplaceListener$lambda$9;
                createReplaceListener$lambda$9 = DownloadTaskExtensionKt.createReplaceListener$lambda$9(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), (Map) obj3);
                return createReplaceListener$lambda$9;
            }
        }, new Function3() { // from class: com.qiahao.base_common.download.okDownload.d
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit createReplaceListener$lambda$10;
                createReplaceListener$lambda$10 = DownloadTaskExtensionKt.createReplaceListener$lambda$10(DownloadListener.this, progressListener, (DownloadTask) obj, (BreakpointInfo) obj2, (ResumeFailedCause) obj3);
                return createReplaceListener$lambda$10;
            }
        }, new Function2() { // from class: com.qiahao.base_common.download.okDownload.e
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit createReplaceListener$lambda$11;
                createReplaceListener$lambda$11 = DownloadTaskExtensionKt.createReplaceListener$lambda$11(DownloadListener.this, progressListener, (DownloadTask) obj, (BreakpointInfo) obj2);
                return createReplaceListener$lambda$11;
            }
        }, new Function3() { // from class: com.qiahao.base_common.download.okDownload.f
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit createReplaceListener$lambda$12;
                createReplaceListener$lambda$12 = DownloadTaskExtensionKt.createReplaceListener$lambda$12(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), (Map) obj3);
                return createReplaceListener$lambda$12;
            }
        }, new Function4() { // from class: com.qiahao.base_common.download.okDownload.g
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit createReplaceListener$lambda$13;
                createReplaceListener$lambda$13 = DownloadTaskExtensionKt.createReplaceListener$lambda$13(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (Map) obj4);
                return createReplaceListener$lambda$13;
            }
        }, new Function3() { // from class: com.qiahao.base_common.download.okDownload.h
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit createReplaceListener$lambda$14;
                createReplaceListener$lambda$14 = DownloadTaskExtensionKt.createReplaceListener$lambda$14(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), ((Long) obj3).longValue());
                return createReplaceListener$lambda$14;
            }
        }, new Function3() { // from class: com.qiahao.base_common.download.okDownload.i
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit createReplaceListener$lambda$15;
                createReplaceListener$lambda$15 = DownloadTaskExtensionKt.createReplaceListener$lambda$15(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), ((Long) obj3).longValue());
                return createReplaceListener$lambda$15;
            }
        }, new Function3() { // from class: com.qiahao.base_common.download.okDownload.j
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit createReplaceListener$lambda$16;
                createReplaceListener$lambda$16 = DownloadTaskExtensionKt.createReplaceListener$lambda$16(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), ((Long) obj3).longValue());
                return createReplaceListener$lambda$16;
            }
        }, new Function3() { // from class: com.qiahao.base_common.download.okDownload.s
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit createReplaceListener$lambda$17;
                createReplaceListener$lambda$17 = DownloadTaskExtensionKt.createReplaceListener$lambda$17(DownloadListener.this, progressListener, (DownloadTask) obj, (EndCause) obj2, (Exception) obj3);
                return createReplaceListener$lambda$17;
            }
        });
    }

    public static final Unit createReplaceListener$lambda$10(DownloadListener downloadListener, DownloadListener downloadListener2, DownloadTask task, BreakpointInfo info, ResumeFailedCause cause) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(cause, "cause");
        downloadListener.downloadFromBeginning(task, info, cause);
        downloadListener2.downloadFromBeginning(task, info, cause);
        return Unit.INSTANCE;
    }

    public static final Unit createReplaceListener$lambda$11(DownloadListener downloadListener, DownloadListener downloadListener2, DownloadTask task, BreakpointInfo info) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(info, "info");
        downloadListener.downloadFromBreakpoint(task, info);
        downloadListener2.downloadFromBreakpoint(task, info);
        return Unit.INSTANCE;
    }

    public static final Unit createReplaceListener$lambda$12(DownloadListener downloadListener, DownloadTask task, int i10, Map requestHeaderFields) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(requestHeaderFields, "requestHeaderFields");
        downloadListener.connectStart(task, i10, requestHeaderFields);
        return Unit.INSTANCE;
    }

    public static final Unit createReplaceListener$lambda$13(DownloadListener downloadListener, DownloadTask task, int i10, int i11, Map responseHeaderFields) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(responseHeaderFields, "responseHeaderFields");
        downloadListener.connectEnd(task, i10, i11, responseHeaderFields);
        return Unit.INSTANCE;
    }

    public static final Unit createReplaceListener$lambda$14(DownloadListener downloadListener, DownloadTask task, int i10, long j10) {
        Intrinsics.checkNotNullParameter(task, "task");
        downloadListener.fetchStart(task, i10, j10);
        return Unit.INSTANCE;
    }

    public static final Unit createReplaceListener$lambda$15(DownloadListener downloadListener, DownloadTask task, int i10, long j10) {
        Intrinsics.checkNotNullParameter(task, "task");
        downloadListener.fetchProgress(task, i10, j10);
        return Unit.INSTANCE;
    }

    public static final Unit createReplaceListener$lambda$16(DownloadListener downloadListener, DownloadTask task, int i10, long j10) {
        Intrinsics.checkNotNullParameter(task, "task");
        downloadListener.fetchEnd(task, i10, j10);
        return Unit.INSTANCE;
    }

    public static final Unit createReplaceListener$lambda$17(DownloadListener downloadListener, DownloadListener downloadListener2, DownloadTask task, EndCause cause, Exception exc) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(cause, "cause");
        downloadListener.taskEnd(task, cause, exc);
        downloadListener2.taskEnd(task, cause, exc);
        return Unit.INSTANCE;
    }

    public static final Unit createReplaceListener$lambda$7(DownloadListener downloadListener, DownloadListener downloadListener2, DownloadTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        downloadListener.taskStart(it);
        downloadListener2.taskStart(it);
        return Unit.INSTANCE;
    }

    public static final Unit createReplaceListener$lambda$8(DownloadListener downloadListener, DownloadTask task, Map requestFields) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(requestFields, "requestFields");
        downloadListener.connectTrialStart(task, requestFields);
        return Unit.INSTANCE;
    }

    public static final Unit createReplaceListener$lambda$9(DownloadListener downloadListener, DownloadTask task, int i10, Map responseHeaderFields) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(responseHeaderFields, "responseHeaderFields");
        downloadListener.connectTrialEnd(task, i10, responseHeaderFields);
        return Unit.INSTANCE;
    }

    public static final void enqueue(@NotNull DownloadTask downloadTask, @Nullable Function1<? super DownloadTask, Unit> function1, @Nullable Function2<? super DownloadTask, ? super Map<String, ? extends List<String>>, Unit> function2, @Nullable Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function3, @Nullable Function3<? super DownloadTask, ? super BreakpointInfo, ? super ResumeFailedCause, Unit> function32, @Nullable Function2<? super DownloadTask, ? super BreakpointInfo, Unit> function22, @Nullable Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function33, @Nullable Function4<? super DownloadTask, ? super Integer, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function4, @Nullable Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function34, @Nullable Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function35, @Nullable Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function36, @NotNull Function3<? super DownloadTask, ? super EndCause, ? super Exception, Unit> onTaskEnd) {
        Intrinsics.checkNotNullParameter(downloadTask, "<this>");
        Intrinsics.checkNotNullParameter(onTaskEnd, "onTaskEnd");
        downloadTask.enqueue(DownloadListenerExtensionKt.createListener(function1, function2, function3, function32, function22, function33, function4, function34, function35, function36, onTaskEnd));
    }

    public static /* synthetic */ void enqueue$default(DownloadTask downloadTask, Function1 function1, Function2 function2, Function3 function3, Function3 function32, Function2 function22, Function3 function33, Function4 function4, Function3 function34, Function3 function35, Function3 function36, Function3 function37, int i10, Object obj) {
        Function1 function12;
        Function2 function23;
        Function3 function38;
        Function3 function39;
        Function2 function24;
        Function3 function310;
        Function4 function42;
        Function3 function311;
        Function3 function312;
        Function3 function313;
        if ((i10 & 1) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        if ((i10 & 2) != 0) {
            function23 = null;
        } else {
            function23 = function2;
        }
        if ((i10 & 4) != 0) {
            function38 = null;
        } else {
            function38 = function3;
        }
        if ((i10 & 8) != 0) {
            function39 = null;
        } else {
            function39 = function32;
        }
        if ((i10 & 16) != 0) {
            function24 = null;
        } else {
            function24 = function22;
        }
        if ((i10 & 32) != 0) {
            function310 = null;
        } else {
            function310 = function33;
        }
        if ((i10 & 64) != 0) {
            function42 = null;
        } else {
            function42 = function4;
        }
        if ((i10 & 128) != 0) {
            function311 = null;
        } else {
            function311 = function34;
        }
        if ((i10 & 256) != 0) {
            function312 = null;
        } else {
            function312 = function35;
        }
        if ((i10 & 512) != 0) {
            function313 = null;
        } else {
            function313 = function36;
        }
        enqueue(downloadTask, function12, function23, function38, function39, function24, function310, function42, function311, function312, function313, function37);
    }

    public static final void enqueue1(@NotNull DownloadTask downloadTask, @Nullable Function2<? super DownloadTask, ? super Listener1Assist.Listener1Model, Unit> function2, @Nullable Function2<? super DownloadTask, ? super ResumeFailedCause, Unit> function22, @Nullable Function4<? super DownloadTask, ? super Integer, ? super Long, ? super Long, Unit> function4, @Nullable Function3<? super DownloadTask, ? super Long, ? super Long, Unit> function3, @NotNull Function4<? super DownloadTask, ? super EndCause, ? super Exception, ? super Listener1Assist.Listener1Model, Unit> taskEnd) {
        Intrinsics.checkNotNullParameter(downloadTask, "<this>");
        Intrinsics.checkNotNullParameter(taskEnd, "taskEnd");
        downloadTask.enqueue(DownloadListener1ExtensionKt.createListener1(function2, function22, function4, function3, taskEnd));
    }

    public static /* synthetic */ void enqueue1$default(DownloadTask downloadTask, Function2 function2, Function2 function22, Function4 function4, Function3 function3, Function4 function42, int i10, Object obj) {
        Function2 function23;
        Function2 function24;
        Function4 function43;
        Function3 function32;
        if ((i10 & 1) != 0) {
            function23 = null;
        } else {
            function23 = function2;
        }
        if ((i10 & 2) != 0) {
            function24 = null;
        } else {
            function24 = function22;
        }
        if ((i10 & 4) != 0) {
            function43 = null;
        } else {
            function43 = function4;
        }
        if ((i10 & 8) != 0) {
            function32 = null;
        } else {
            function32 = function3;
        }
        enqueue1(downloadTask, function23, function24, function43, function32, function42);
    }

    public static final void enqueue2(@NotNull DownloadTask downloadTask, @NotNull Function1<? super DownloadTask, Unit> onTaskStart, @NotNull Function3<? super DownloadTask, ? super EndCause, ? super Exception, Unit> onTaskEnd) {
        Intrinsics.checkNotNullParameter(downloadTask, "<this>");
        Intrinsics.checkNotNullParameter(onTaskStart, "onTaskStart");
        Intrinsics.checkNotNullParameter(onTaskEnd, "onTaskEnd");
        downloadTask.enqueue(DownloadListener2ExtensionKt.createListener2(onTaskStart, onTaskEnd));
    }

    public static /* synthetic */ void enqueue2$default(DownloadTask downloadTask, Function1 function1, Function3 function3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function1 = new Function1() { // from class: com.qiahao.base_common.download.okDownload.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit enqueue2$lambda$2;
                    enqueue2$lambda$2 = DownloadTaskExtensionKt.enqueue2$lambda$2((DownloadTask) obj2);
                    return enqueue2$lambda$2;
                }
            };
        }
        enqueue2(downloadTask, function1, function3);
    }

    public static final Unit enqueue2$lambda$2(DownloadTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public static final void enqueue3(@NotNull DownloadTask downloadTask, @Nullable Function1<? super DownloadTask, Unit> function1, @Nullable Function4<? super DownloadTask, ? super Integer, ? super Long, ? super Long, Unit> function4, @Nullable Function3<? super DownloadTask, ? super Long, ? super Long, Unit> function3, @Nullable Function1<? super DownloadTask, Unit> function12, @Nullable Function1<? super DownloadTask, Unit> function13, @Nullable Function1<? super DownloadTask, Unit> function14, @Nullable Function2<? super DownloadTask, ? super ResumeFailedCause, Unit> function2, @Nullable Function2<? super DownloadTask, ? super Exception, Unit> function22, @NotNull Function0<Unit> onTerminal) {
        Intrinsics.checkNotNullParameter(downloadTask, "<this>");
        Intrinsics.checkNotNullParameter(onTerminal, "onTerminal");
        downloadTask.enqueue(DownloadListener3ExtensionKt.createListener3(function1, function4, function3, function12, function13, function14, function2, function22, onTerminal));
    }

    public static /* synthetic */ void enqueue3$default(DownloadTask downloadTask, Function1 function1, Function4 function4, Function3 function3, Function1 function12, Function1 function13, Function1 function14, Function2 function2, Function2 function22, Function0 function0, int i10, Object obj) {
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
            function0 = new Function0() { // from class: com.qiahao.base_common.download.okDownload.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        enqueue3(downloadTask, function1, function4, function3, function12, function13, function14, function2, function22, function0);
    }

    public static final void enqueue4(@NotNull DownloadTask downloadTask, @Nullable Function1<? super DownloadTask, Unit> function1, @Nullable Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function3, @Nullable Function4<? super DownloadTask, ? super Integer, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function4, @Nullable Function4<? super DownloadTask, ? super BreakpointInfo, ? super Boolean, ? super Listener4Assist.Listener4Model, Unit> function42, @Nullable Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function32, @Nullable Function2<? super DownloadTask, ? super Long, Unit> function2, @Nullable Function3<? super DownloadTask, ? super Integer, ? super BlockInfo, Unit> function33, @NotNull Function4<? super DownloadTask, ? super EndCause, ? super Exception, ? super Listener4Assist.Listener4Model, Unit> onTaskEndWithListener4Model) {
        Intrinsics.checkNotNullParameter(downloadTask, "<this>");
        Intrinsics.checkNotNullParameter(onTaskEndWithListener4Model, "onTaskEndWithListener4Model");
        downloadTask.enqueue(DownloadListener4ExtensionKt.createListener4(function1, function3, function4, function42, function32, function2, function33, onTaskEndWithListener4Model));
    }

    public static /* synthetic */ void enqueue4$default(DownloadTask downloadTask, Function1 function1, Function3 function3, Function4 function4, Function4 function42, Function3 function32, Function2 function2, Function3 function33, Function4 function43, int i10, Object obj) {
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
        enqueue4(downloadTask, function12, function34, function44, function45, function35, function22, function36, function43);
    }

    public static final void enqueue4WithSpeed(@NotNull DownloadTask downloadTask, @Nullable Function1<? super DownloadTask, Unit> function1, @Nullable Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function3, @Nullable Function4<? super DownloadTask, ? super Integer, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function4, @Nullable Function4<? super DownloadTask, ? super BreakpointInfo, ? super Boolean, ? super Listener4SpeedAssistExtend.Listener4SpeedModel, Unit> function42, @Nullable Function4<? super DownloadTask, ? super Integer, ? super Long, ? super SpeedCalculator, Unit> function43, @Nullable Function3<? super DownloadTask, ? super Long, ? super SpeedCalculator, Unit> function32, @Nullable Function4<? super DownloadTask, ? super Integer, ? super BlockInfo, ? super SpeedCalculator, Unit> function44, @NotNull Function4<? super DownloadTask, ? super EndCause, ? super Exception, ? super SpeedCalculator, Unit> onTaskEndWithSpeed) {
        Intrinsics.checkNotNullParameter(downloadTask, "<this>");
        Intrinsics.checkNotNullParameter(onTaskEndWithSpeed, "onTaskEndWithSpeed");
        downloadTask.enqueue(DownloadListener4WithSpeedExtensionKt.createListener4WithSpeed(function1, function3, function4, function42, function43, function32, function44, onTaskEndWithSpeed));
    }

    public static /* synthetic */ void enqueue4WithSpeed$default(DownloadTask downloadTask, Function1 function1, Function3 function3, Function4 function4, Function4 function42, Function4 function43, Function3 function32, Function4 function44, Function4 function45, int i10, Object obj) {
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
        enqueue4WithSpeed(downloadTask, function12, function33, function46, function47, function48, function34, function49, function45);
    }

    public static final void execute(@NotNull DownloadTask downloadTask, @Nullable Function1<? super DownloadTask, Unit> function1, @Nullable Function2<? super DownloadTask, ? super Map<String, ? extends List<String>>, Unit> function2, @Nullable Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function3, @Nullable Function3<? super DownloadTask, ? super BreakpointInfo, ? super ResumeFailedCause, Unit> function32, @Nullable Function2<? super DownloadTask, ? super BreakpointInfo, Unit> function22, @Nullable Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function33, @Nullable Function4<? super DownloadTask, ? super Integer, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function4, @Nullable Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function34, @Nullable Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function35, @Nullable Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function36, @NotNull Function3<? super DownloadTask, ? super EndCause, ? super Exception, Unit> onTaskEnd) {
        Intrinsics.checkNotNullParameter(downloadTask, "<this>");
        Intrinsics.checkNotNullParameter(onTaskEnd, "onTaskEnd");
        downloadTask.execute(DownloadListenerExtensionKt.createListener(function1, function2, function3, function32, function22, function33, function4, function34, function35, function36, onTaskEnd));
    }

    public static /* synthetic */ void execute$default(DownloadTask downloadTask, Function1 function1, Function2 function2, Function3 function3, Function3 function32, Function2 function22, Function3 function33, Function4 function4, Function3 function34, Function3 function35, Function3 function36, Function3 function37, int i10, Object obj) {
        Function1 function12;
        Function2 function23;
        Function3 function38;
        Function3 function39;
        Function2 function24;
        Function3 function310;
        Function4 function42;
        Function3 function311;
        Function3 function312;
        Function3 function313;
        if ((i10 & 1) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        if ((i10 & 2) != 0) {
            function23 = null;
        } else {
            function23 = function2;
        }
        if ((i10 & 4) != 0) {
            function38 = null;
        } else {
            function38 = function3;
        }
        if ((i10 & 8) != 0) {
            function39 = null;
        } else {
            function39 = function32;
        }
        if ((i10 & 16) != 0) {
            function24 = null;
        } else {
            function24 = function22;
        }
        if ((i10 & 32) != 0) {
            function310 = null;
        } else {
            function310 = function33;
        }
        if ((i10 & 64) != 0) {
            function42 = null;
        } else {
            function42 = function4;
        }
        if ((i10 & 128) != 0) {
            function311 = null;
        } else {
            function311 = function34;
        }
        if ((i10 & 256) != 0) {
            function312 = null;
        } else {
            function312 = function35;
        }
        if ((i10 & 512) != 0) {
            function313 = null;
        } else {
            function313 = function36;
        }
        execute(downloadTask, function12, function23, function38, function39, function24, function310, function42, function311, function312, function313, function37);
    }

    public static final void execute1(@NotNull DownloadTask downloadTask, @Nullable Function2<? super DownloadTask, ? super Listener1Assist.Listener1Model, Unit> function2, @Nullable Function2<? super DownloadTask, ? super ResumeFailedCause, Unit> function22, @Nullable Function4<? super DownloadTask, ? super Integer, ? super Long, ? super Long, Unit> function4, @Nullable Function3<? super DownloadTask, ? super Long, ? super Long, Unit> function3, @NotNull Function4<? super DownloadTask, ? super EndCause, ? super Exception, ? super Listener1Assist.Listener1Model, Unit> taskEnd) {
        Intrinsics.checkNotNullParameter(downloadTask, "<this>");
        Intrinsics.checkNotNullParameter(taskEnd, "taskEnd");
        downloadTask.execute(DownloadListener1ExtensionKt.createListener1(function2, function22, function4, function3, taskEnd));
    }

    public static /* synthetic */ void execute1$default(DownloadTask downloadTask, Function2 function2, Function2 function22, Function4 function4, Function3 function3, Function4 function42, int i10, Object obj) {
        Function2 function23;
        Function2 function24;
        Function4 function43;
        Function3 function32;
        if ((i10 & 1) != 0) {
            function23 = null;
        } else {
            function23 = function2;
        }
        if ((i10 & 2) != 0) {
            function24 = null;
        } else {
            function24 = function22;
        }
        if ((i10 & 4) != 0) {
            function43 = null;
        } else {
            function43 = function4;
        }
        if ((i10 & 8) != 0) {
            function32 = null;
        } else {
            function32 = function3;
        }
        execute1(downloadTask, function23, function24, function43, function32, function42);
    }

    public static final void execute2(@NotNull DownloadTask downloadTask, @NotNull Function1<? super DownloadTask, Unit> onTaskStart, @NotNull Function3<? super DownloadTask, ? super EndCause, ? super Exception, Unit> onTaskEnd) {
        Intrinsics.checkNotNullParameter(downloadTask, "<this>");
        Intrinsics.checkNotNullParameter(onTaskStart, "onTaskStart");
        Intrinsics.checkNotNullParameter(onTaskEnd, "onTaskEnd");
        downloadTask.execute(DownloadListener2ExtensionKt.createListener2(onTaskStart, onTaskEnd));
    }

    public static /* synthetic */ void execute2$default(DownloadTask downloadTask, Function1 function1, Function3 function3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function1 = new Function1() { // from class: com.qiahao.base_common.download.okDownload.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit execute2$lambda$0;
                    execute2$lambda$0 = DownloadTaskExtensionKt.execute2$lambda$0((DownloadTask) obj2);
                    return execute2$lambda$0;
                }
            };
        }
        execute2(downloadTask, function1, function3);
    }

    public static final Unit execute2$lambda$0(DownloadTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public static final void execute3(@NotNull DownloadTask downloadTask, @Nullable Function1<? super DownloadTask, Unit> function1, @Nullable Function4<? super DownloadTask, ? super Integer, ? super Long, ? super Long, Unit> function4, @Nullable Function3<? super DownloadTask, ? super Long, ? super Long, Unit> function3, @Nullable Function1<? super DownloadTask, Unit> function12, @Nullable Function1<? super DownloadTask, Unit> function13, @Nullable Function1<? super DownloadTask, Unit> function14, @Nullable Function2<? super DownloadTask, ? super ResumeFailedCause, Unit> function2, @Nullable Function2<? super DownloadTask, ? super Exception, Unit> function22, @NotNull Function0<Unit> onTerminal) {
        Intrinsics.checkNotNullParameter(downloadTask, "<this>");
        Intrinsics.checkNotNullParameter(onTerminal, "onTerminal");
        downloadTask.execute(DownloadListener3ExtensionKt.createListener3(function1, function4, function3, function12, function13, function14, function2, function22, onTerminal));
    }

    public static /* synthetic */ void execute3$default(DownloadTask downloadTask, Function1 function1, Function4 function4, Function3 function3, Function1 function12, Function1 function13, Function1 function14, Function2 function2, Function2 function22, Function0 function0, int i10, Object obj) {
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
            function0 = new Function0() { // from class: com.qiahao.base_common.download.okDownload.m
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        execute3(downloadTask, function1, function4, function3, function12, function13, function14, function2, function22, function0);
    }

    public static final void execute4(@NotNull DownloadTask downloadTask, @Nullable Function1<? super DownloadTask, Unit> function1, @Nullable Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function3, @Nullable Function4<? super DownloadTask, ? super Integer, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function4, @Nullable Function4<? super DownloadTask, ? super BreakpointInfo, ? super Boolean, ? super Listener4Assist.Listener4Model, Unit> function42, @Nullable Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function32, @Nullable Function2<? super DownloadTask, ? super Long, Unit> function2, @Nullable Function3<? super DownloadTask, ? super Integer, ? super BlockInfo, Unit> function33, @NotNull Function4<? super DownloadTask, ? super EndCause, ? super Exception, ? super Listener4Assist.Listener4Model, Unit> onTaskEndWithListener4Model) {
        Intrinsics.checkNotNullParameter(downloadTask, "<this>");
        Intrinsics.checkNotNullParameter(onTaskEndWithListener4Model, "onTaskEndWithListener4Model");
        downloadTask.execute(DownloadListener4ExtensionKt.createListener4(function1, function3, function4, function42, function32, function2, function33, onTaskEndWithListener4Model));
    }

    public static /* synthetic */ void execute4$default(DownloadTask downloadTask, Function1 function1, Function3 function3, Function4 function4, Function4 function42, Function3 function32, Function2 function2, Function3 function33, Function4 function43, int i10, Object obj) {
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
        execute4(downloadTask, function12, function34, function44, function45, function35, function22, function36, function43);
    }

    public static final void execute4WithSpeed(@NotNull DownloadTask downloadTask, @Nullable Function1<? super DownloadTask, Unit> function1, @Nullable Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function3, @Nullable Function4<? super DownloadTask, ? super Integer, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function4, @Nullable Function4<? super DownloadTask, ? super BreakpointInfo, ? super Boolean, ? super Listener4SpeedAssistExtend.Listener4SpeedModel, Unit> function42, @Nullable Function4<? super DownloadTask, ? super Integer, ? super Long, ? super SpeedCalculator, Unit> function43, @Nullable Function3<? super DownloadTask, ? super Long, ? super SpeedCalculator, Unit> function32, @Nullable Function4<? super DownloadTask, ? super Integer, ? super BlockInfo, ? super SpeedCalculator, Unit> function44, @NotNull Function4<? super DownloadTask, ? super EndCause, ? super Exception, ? super SpeedCalculator, Unit> onTaskEndWithSpeed) {
        Intrinsics.checkNotNullParameter(downloadTask, "<this>");
        Intrinsics.checkNotNullParameter(onTaskEndWithSpeed, "onTaskEndWithSpeed");
        downloadTask.execute(DownloadListener4WithSpeedExtensionKt.createListener4WithSpeed(function1, function3, function4, function42, function43, function32, function44, onTaskEndWithSpeed));
    }

    public static /* synthetic */ void execute4WithSpeed$default(DownloadTask downloadTask, Function1 function1, Function3 function3, Function4 function4, Function4 function42, Function4 function43, Function3 function32, Function4 function44, Function4 function45, int i10, Object obj) {
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
        execute4WithSpeed(downloadTask, function12, function33, function46, function47, function48, function34, function49, function45);
    }

    @NotNull
    public static final Channel<DownloadProgress> spChannel(@NotNull DownloadTask downloadTask) {
        Intrinsics.checkNotNullParameter(downloadTask, "<this>");
        final Channel<DownloadProgress> Channel$default = ChannelKt.Channel$default(-1, null, null, 6, null);
        DownloadListener listener = downloadTask.getListener();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        DownloadListener1 createListener1$default = DownloadListener1ExtensionKt.createListener1$default(null, null, null, new Function3() { // from class: com.qiahao.base_common.download.okDownload.p
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit spChannel$lambda$4;
                spChannel$lambda$4 = DownloadTaskExtensionKt.spChannel$lambda$4(atomicBoolean, Channel$default, (DownloadTask) obj, ((Long) obj2).longValue(), ((Long) obj3).longValue());
                return spChannel$lambda$4;
            }
        }, new Function4() { // from class: com.qiahao.base_common.download.okDownload.q
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit spChannel$lambda$5;
                spChannel$lambda$5 = DownloadTaskExtensionKt.spChannel$lambda$5(atomicBoolean, Channel$default, (DownloadTask) obj, (EndCause) obj2, (Exception) obj3, (Listener1Assist.Listener1Model) obj4);
                return spChannel$lambda$5;
            }
        }, 7, null);
        createListener1$default.setAlwaysRecoverAssistModelIfNotSet(true);
        downloadTask.replaceListener(createReplaceListener(listener, createListener1$default));
        return Channel$default;
    }

    public static final Unit spChannel$lambda$4(AtomicBoolean atomicBoolean, Channel channel, DownloadTask task, long j10, long j11) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (atomicBoolean.get()) {
            return Unit.INSTANCE;
        }
        ChannelResult.m٢١٨١isSuccessimpl(channel.mo٢١٩٤trySendJP2dKIU(new DownloadProgress(task, j10, j11)));
        return Unit.INSTANCE;
    }

    public static final Unit spChannel$lambda$5(AtomicBoolean atomicBoolean, Channel channel, DownloadTask downloadTask, EndCause endCause, Exception exc, Listener1Assist.Listener1Model listener1Model) {
        Intrinsics.checkNotNullParameter(downloadTask, "<unused var>");
        Intrinsics.checkNotNullParameter(endCause, "<unused var>");
        Intrinsics.checkNotNullParameter(listener1Model, "<unused var>");
        atomicBoolean.set(true);
        SendChannel.DefaultImpls.close$default(channel, null, 1, null);
        return Unit.INSTANCE;
    }
}
