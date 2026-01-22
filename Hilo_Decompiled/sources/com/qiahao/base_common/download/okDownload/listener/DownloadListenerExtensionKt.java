package com.qiahao.base_common.download.okDownload.listener;

import com.liulishuo.okdownload.DownloadListener;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.SpeedCalculator;
import com.liulishuo.okdownload.core.breakpoint.BlockInfo;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.liulishuo.okdownload.core.listener.DownloadListener1;
import com.liulishuo.okdownload.core.listener.DownloadListener2;
import com.liulishuo.okdownload.core.listener.DownloadListener3;
import com.liulishuo.okdownload.core.listener.DownloadListener4;
import com.liulishuo.okdownload.core.listener.DownloadListener4WithSpeed;
import com.liulishuo.okdownload.core.listener.assist.Listener1Assist;
import com.liulishuo.okdownload.core.listener.assist.Listener4Assist;
import com.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend;
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

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aÈ\u0007\u0010'\u001a\u00020(2+\b\u0002\u0010\u0000\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0001j\u0004\u0018\u0001`)2R\b\u0002\u0010\u0007\u001aL\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012%\u0012#\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000b0\t¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bj\u0004\u0018\u0001`*2g\b\u0002\u0010\r\u001aa\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012%\u0012#\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000b0\t¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000ej\u0004\u0018\u0001`+2U\b\u0002\u0010\u0012\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000ej\u0004\u0018\u0001`,2@\b\u0002\u0010\u0017\u001a:\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bj\u0004\u0018\u0001`-2g\b\u0002\u0010\u0018\u001aa\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019\u0012%\u0012#\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000b0\t¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000ej\u0004\u0018\u0001`.2|\b\u0002\u0010\u001a\u001av\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012%\u0012#\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000b0\t¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001bj\u0004\u0018\u0001`/2U\b\u0002\u0010\u001c\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000ej\u0004\u0018\u0001`\"2U\b\u0002\u0010\u001f\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000ej\u0004\u0018\u0001`02U\b\u0002\u0010!\u001aO\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000ej\u0004\u0018\u0001`12Q\u0010#\u001aM\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110$¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00060\u000ej\u0002`2\u001a\n\u00103\u001a\u00020(*\u00020(*@\u0010\u0000\"\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001*\u008e\u0001\u0010\u0007\"D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012%\u0012#\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000b0\t¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b2D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012%\u0012#\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000b0\t¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b*¸\u0001\u0010\r\"Y\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012%\u0012#\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000b0\t¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\u000e2Y\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012%\u0012#\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000b0\t¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\u000e*\u0094\u0001\u0010\u0012\"G\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u000e2G\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u000e*j\u0010\u0017\"2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00060\b22\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00060\b*¸\u0001\u0010\u0018\"Y\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019\u0012%\u0012#\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000b0\t¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\u000e2Y\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019\u0012%\u0012#\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000b0\t¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\u000e*â\u0001\u0010\u001a\"n\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012%\u0012#\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000b0\t¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\u001b2n\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012%\u0012#\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000b0\t¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\u001b*\u0094\u0001\u0010\u001c\"G\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00060\u000e2G\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00060\u000e*\u0094\u0001\u0010\u001f\"G\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00060\u000e2G\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00060\u000e*S\u0010!\"\u0002`\"2K\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00060\u000ej\u0002`\"*\u0098\u0001\u0010#\"I\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110$¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00060\u000e2I\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110$¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00060\u000e¨\u00064"}, d2 = {"onTaskStart", "Lkotlin/Function1;", "Lcom/liulishuo/okdownload/DownloadTask;", "Lkotlin/ParameterName;", "name", "task", "", "onConnectTrialStart", "Lkotlin/Function2;", "", "", "", "requestHeaderFields", "onConnectTrialEnd", "Lkotlin/Function3;", "", "responseCode", "responseHeaderFields", "onDownloadFromBeginning", "Lcom/liulishuo/okdownload/core/breakpoint/BreakpointInfo;", "info", "Lcom/liulishuo/okdownload/core/cause/ResumeFailedCause;", "cause", "onDownloadFromBreakpoint", "onConnectStart", "blockIndex", "onConnectEnd", "Lkotlin/Function4;", "onFetchStart", "", "contentLength", "onFetchProgress", "increaseBytes", "onFetchEnd", "Lcom/qiahao/base_common/download/okDownload/listener/onFetchStart;", "onTaskEnd", "Lcom/liulishuo/okdownload/core/cause/EndCause;", "Ljava/lang/Exception;", "realCause", "createListener", "Lcom/liulishuo/okdownload/DownloadListener;", "Lcom/qiahao/base_common/download/okDownload/listener/onTaskStart;", "Lcom/qiahao/base_common/download/okDownload/listener/onConnectTrialStart;", "Lcom/qiahao/base_common/download/okDownload/listener/onConnectTrialEnd;", "Lcom/qiahao/base_common/download/okDownload/listener/onDownloadFromBeginning;", "Lcom/qiahao/base_common/download/okDownload/listener/onDownloadFromBreakpoint;", "Lcom/qiahao/base_common/download/okDownload/listener/onConnectStart;", "Lcom/qiahao/base_common/download/okDownload/listener/onConnectEnd;", "Lcom/qiahao/base_common/download/okDownload/listener/onFetchProgress;", "Lcom/qiahao/base_common/download/okDownload/listener/onFetchEnd;", "Lcom/qiahao/base_common/download/okDownload/listener/onTaskEnd;", "switchToExceptProgressListener", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DownloadListenerExtensionKt {
    @NotNull
    public static final DownloadListener createListener(@Nullable final Function1<? super DownloadTask, Unit> function1, @Nullable final Function2<? super DownloadTask, ? super Map<String, ? extends List<String>>, Unit> function2, @Nullable final Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function3, @Nullable final Function3<? super DownloadTask, ? super BreakpointInfo, ? super ResumeFailedCause, Unit> function32, @Nullable final Function2<? super DownloadTask, ? super BreakpointInfo, Unit> function22, @Nullable final Function3<? super DownloadTask, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function33, @Nullable final Function4<? super DownloadTask, ? super Integer, ? super Integer, ? super Map<String, ? extends List<String>>, Unit> function4, @Nullable final Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function34, @Nullable final Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function35, @Nullable final Function3<? super DownloadTask, ? super Integer, ? super Long, Unit> function36, @NotNull final Function3<? super DownloadTask, ? super EndCause, ? super Exception, Unit> onTaskEnd) {
        Intrinsics.checkNotNullParameter(onTaskEnd, "onTaskEnd");
        return new DownloadListener() { // from class: com.qiahao.base_common.download.okDownload.listener.DownloadListenerExtensionKt$createListener$1
            @Override // com.liulishuo.okdownload.DownloadListener
            public void connectEnd(DownloadTask task, int blockIndex, int responseCode, Map<String, List<String>> responseHeaderFields) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(responseHeaderFields, "responseHeaderFields");
                Function4<DownloadTask, Integer, Integer, Map<String, ? extends List<String>>, Unit> function42 = function4;
                if (function42 != null) {
                    function42.invoke(task, Integer.valueOf(blockIndex), Integer.valueOf(responseCode), responseHeaderFields);
                }
            }

            @Override // com.liulishuo.okdownload.DownloadListener
            public void connectStart(DownloadTask task, int blockIndex, Map<String, List<String>> requestHeaderFields) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(requestHeaderFields, "requestHeaderFields");
                Function3<DownloadTask, Integer, Map<String, ? extends List<String>>, Unit> function37 = function33;
                if (function37 != null) {
                    function37.invoke(task, Integer.valueOf(blockIndex), requestHeaderFields);
                }
            }

            @Override // com.liulishuo.okdownload.DownloadListener
            public void connectTrialEnd(DownloadTask task, int responseCode, Map<String, List<String>> responseHeaderFields) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(responseHeaderFields, "responseHeaderFields");
                Function3<DownloadTask, Integer, Map<String, ? extends List<String>>, Unit> function37 = function3;
                if (function37 != null) {
                    function37.invoke(task, Integer.valueOf(responseCode), responseHeaderFields);
                }
            }

            @Override // com.liulishuo.okdownload.DownloadListener
            public void connectTrialStart(DownloadTask task, Map<String, List<String>> requestHeaderFields) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(requestHeaderFields, "requestHeaderFields");
                Function2<DownloadTask, Map<String, ? extends List<String>>, Unit> function23 = function2;
                if (function23 != null) {
                    function23.invoke(task, requestHeaderFields);
                }
            }

            @Override // com.liulishuo.okdownload.DownloadListener
            public void downloadFromBeginning(DownloadTask task, BreakpointInfo info, ResumeFailedCause cause) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(info, "info");
                Intrinsics.checkNotNullParameter(cause, "cause");
                Function3<DownloadTask, BreakpointInfo, ResumeFailedCause, Unit> function37 = function32;
                if (function37 != null) {
                    function37.invoke(task, info, cause);
                }
            }

            @Override // com.liulishuo.okdownload.DownloadListener
            public void downloadFromBreakpoint(DownloadTask task, BreakpointInfo info) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(info, "info");
                Function2<DownloadTask, BreakpointInfo, Unit> function23 = function22;
                if (function23 != null) {
                    function23.invoke(task, info);
                }
            }

            @Override // com.liulishuo.okdownload.DownloadListener
            public void fetchEnd(DownloadTask task, int blockIndex, long contentLength) {
                Intrinsics.checkNotNullParameter(task, "task");
                Function3<DownloadTask, Integer, Long, Unit> function37 = function36;
                if (function37 != null) {
                    function37.invoke(task, Integer.valueOf(blockIndex), Long.valueOf(contentLength));
                }
            }

            @Override // com.liulishuo.okdownload.DownloadListener
            public void fetchProgress(DownloadTask task, int blockIndex, long increaseBytes) {
                Intrinsics.checkNotNullParameter(task, "task");
                Function3<DownloadTask, Integer, Long, Unit> function37 = function35;
                if (function37 != null) {
                    function37.invoke(task, Integer.valueOf(blockIndex), Long.valueOf(increaseBytes));
                }
            }

            @Override // com.liulishuo.okdownload.DownloadListener
            public void fetchStart(DownloadTask task, int blockIndex, long contentLength) {
                Intrinsics.checkNotNullParameter(task, "task");
                Function3<DownloadTask, Integer, Long, Unit> function37 = function34;
                if (function37 != null) {
                    function37.invoke(task, Integer.valueOf(blockIndex), Long.valueOf(contentLength));
                }
            }

            @Override // com.liulishuo.okdownload.DownloadListener
            public void taskEnd(DownloadTask task, EndCause cause, Exception realCause) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(cause, "cause");
                onTaskEnd.invoke(task, cause, realCause);
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

    public static /* synthetic */ DownloadListener createListener$default(Function1 function1, Function2 function2, Function3 function3, Function3 function32, Function2 function22, Function3 function33, Function4 function4, Function3 function34, Function3 function35, Function3 function36, Function3 function37, int i10, Object obj) {
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
        return createListener(function12, function23, function38, function39, function24, function310, function42, function311, function312, function313, function37);
    }

    @NotNull
    public static final DownloadListener switchToExceptProgressListener(@NotNull final DownloadListener downloadListener) {
        Intrinsics.checkNotNullParameter(downloadListener, "<this>");
        if (downloadListener instanceof DownloadListener4WithSpeed) {
            return DownloadListener4WithSpeedExtensionKt.createListener4WithSpeed$default(new Function1() { // from class: com.qiahao.base_common.download.okDownload.listener.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit switchToExceptProgressListener$lambda$0;
                    switchToExceptProgressListener$lambda$0 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$0(DownloadListener.this, (DownloadTask) obj);
                    return switchToExceptProgressListener$lambda$0;
                }
            }, new Function3() { // from class: com.qiahao.base_common.download.okDownload.listener.e
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit switchToExceptProgressListener$lambda$1;
                    switchToExceptProgressListener$lambda$1 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$1(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), (Map) obj3);
                    return switchToExceptProgressListener$lambda$1;
                }
            }, new Function4() { // from class: com.qiahao.base_common.download.okDownload.listener.q
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit switchToExceptProgressListener$lambda$2;
                    switchToExceptProgressListener$lambda$2 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$2(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (Map) obj4);
                    return switchToExceptProgressListener$lambda$2;
                }
            }, new Function4() { // from class: com.qiahao.base_common.download.okDownload.listener.w
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit switchToExceptProgressListener$lambda$3;
                    switchToExceptProgressListener$lambda$3 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$3(DownloadListener.this, (DownloadTask) obj, (BreakpointInfo) obj2, ((Boolean) obj3).booleanValue(), (Listener4SpeedAssistExtend.Listener4SpeedModel) obj4);
                    return switchToExceptProgressListener$lambda$3;
                }
            }, new Function4() { // from class: com.qiahao.base_common.download.okDownload.listener.x
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit switchToExceptProgressListener$lambda$4;
                    switchToExceptProgressListener$lambda$4 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$4(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), ((Long) obj3).longValue(), (SpeedCalculator) obj4);
                    return switchToExceptProgressListener$lambda$4;
                }
            }, null, new Function4() { // from class: com.qiahao.base_common.download.okDownload.listener.z
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit switchToExceptProgressListener$lambda$5;
                    switchToExceptProgressListener$lambda$5 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$5(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), (BlockInfo) obj3, (SpeedCalculator) obj4);
                    return switchToExceptProgressListener$lambda$5;
                }
            }, new Function4() { // from class: com.qiahao.base_common.download.okDownload.listener.a0
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit switchToExceptProgressListener$lambda$6;
                    switchToExceptProgressListener$lambda$6 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$6(DownloadListener.this, (DownloadTask) obj, (EndCause) obj2, (Exception) obj3, (SpeedCalculator) obj4);
                    return switchToExceptProgressListener$lambda$6;
                }
            }, 32, null);
        }
        if (downloadListener instanceof DownloadListener4) {
            return DownloadListener4ExtensionKt.createListener4$default(new Function1() { // from class: com.qiahao.base_common.download.okDownload.listener.b0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit switchToExceptProgressListener$lambda$7;
                    switchToExceptProgressListener$lambda$7 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$7(DownloadListener.this, (DownloadTask) obj);
                    return switchToExceptProgressListener$lambda$7;
                }
            }, new Function3() { // from class: com.qiahao.base_common.download.okDownload.listener.c0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit switchToExceptProgressListener$lambda$8;
                    switchToExceptProgressListener$lambda$8 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$8(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), (Map) obj3);
                    return switchToExceptProgressListener$lambda$8;
                }
            }, new Function4() { // from class: com.qiahao.base_common.download.okDownload.listener.d0
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit switchToExceptProgressListener$lambda$9;
                    switchToExceptProgressListener$lambda$9 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$9(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (Map) obj4);
                    return switchToExceptProgressListener$lambda$9;
                }
            }, new Function4() { // from class: com.qiahao.base_common.download.okDownload.listener.n
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit switchToExceptProgressListener$lambda$10;
                    switchToExceptProgressListener$lambda$10 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$10(DownloadListener.this, (DownloadTask) obj, (BreakpointInfo) obj2, ((Boolean) obj3).booleanValue(), (Listener4Assist.Listener4Model) obj4);
                    return switchToExceptProgressListener$lambda$10;
                }
            }, new Function3() { // from class: com.qiahao.base_common.download.okDownload.listener.y
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit switchToExceptProgressListener$lambda$11;
                    switchToExceptProgressListener$lambda$11 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$11(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), ((Long) obj3).longValue());
                    return switchToExceptProgressListener$lambda$11;
                }
            }, null, new Function3() { // from class: com.qiahao.base_common.download.okDownload.listener.e0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit switchToExceptProgressListener$lambda$12;
                    switchToExceptProgressListener$lambda$12 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$12(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), (BlockInfo) obj3);
                    return switchToExceptProgressListener$lambda$12;
                }
            }, new Function4() { // from class: com.qiahao.base_common.download.okDownload.listener.f0
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit switchToExceptProgressListener$lambda$13;
                    switchToExceptProgressListener$lambda$13 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$13(DownloadListener.this, (DownloadTask) obj, (EndCause) obj2, (Exception) obj3, (Listener4Assist.Listener4Model) obj4);
                    return switchToExceptProgressListener$lambda$13;
                }
            }, 32, null);
        }
        if (downloadListener instanceof DownloadListener3) {
            return DownloadListener3ExtensionKt.createListener3$default(new Function1() { // from class: com.qiahao.base_common.download.okDownload.listener.g0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit switchToExceptProgressListener$lambda$14;
                    switchToExceptProgressListener$lambda$14 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$14(DownloadListener.this, (DownloadTask) obj);
                    return switchToExceptProgressListener$lambda$14;
                }
            }, new Function4() { // from class: com.qiahao.base_common.download.okDownload.listener.h0
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit switchToExceptProgressListener$lambda$15;
                    switchToExceptProgressListener$lambda$15 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$15(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), ((Long) obj3).longValue(), ((Long) obj4).longValue());
                    return switchToExceptProgressListener$lambda$15;
                }
            }, null, new Function1() { // from class: com.qiahao.base_common.download.okDownload.listener.i0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit switchToExceptProgressListener$lambda$16;
                    switchToExceptProgressListener$lambda$16 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$16(DownloadListener.this, (DownloadTask) obj);
                    return switchToExceptProgressListener$lambda$16;
                }
            }, new Function1() { // from class: com.qiahao.base_common.download.okDownload.listener.j0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit switchToExceptProgressListener$lambda$17;
                    switchToExceptProgressListener$lambda$17 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$17(DownloadListener.this, (DownloadTask) obj);
                    return switchToExceptProgressListener$lambda$17;
                }
            }, new Function1() { // from class: com.qiahao.base_common.download.okDownload.listener.k0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit switchToExceptProgressListener$lambda$18;
                    switchToExceptProgressListener$lambda$18 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$18(DownloadListener.this, (DownloadTask) obj);
                    return switchToExceptProgressListener$lambda$18;
                }
            }, new Function2() { // from class: com.qiahao.base_common.download.okDownload.listener.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit switchToExceptProgressListener$lambda$19;
                    switchToExceptProgressListener$lambda$19 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$19(DownloadListener.this, (DownloadTask) obj, (ResumeFailedCause) obj2);
                    return switchToExceptProgressListener$lambda$19;
                }
            }, new Function2() { // from class: com.qiahao.base_common.download.okDownload.listener.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit switchToExceptProgressListener$lambda$20;
                    switchToExceptProgressListener$lambda$20 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$20(DownloadListener.this, (DownloadTask) obj, (Exception) obj2);
                    return switchToExceptProgressListener$lambda$20;
                }
            }, null, 260, null);
        }
        if (downloadListener instanceof DownloadListener1) {
            return DownloadListener1ExtensionKt.createListener1$default(new Function2() { // from class: com.qiahao.base_common.download.okDownload.listener.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit switchToExceptProgressListener$lambda$21;
                    switchToExceptProgressListener$lambda$21 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$21(DownloadListener.this, (DownloadTask) obj, (Listener1Assist.Listener1Model) obj2);
                    return switchToExceptProgressListener$lambda$21;
                }
            }, new Function2() { // from class: com.qiahao.base_common.download.okDownload.listener.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit switchToExceptProgressListener$lambda$22;
                    switchToExceptProgressListener$lambda$22 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$22(DownloadListener.this, (DownloadTask) obj, (ResumeFailedCause) obj2);
                    return switchToExceptProgressListener$lambda$22;
                }
            }, new Function4() { // from class: com.qiahao.base_common.download.okDownload.listener.i
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit switchToExceptProgressListener$lambda$23;
                    switchToExceptProgressListener$lambda$23 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$23(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), ((Long) obj3).longValue(), ((Long) obj4).longValue());
                    return switchToExceptProgressListener$lambda$23;
                }
            }, null, new Function4() { // from class: com.qiahao.base_common.download.okDownload.listener.j
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit switchToExceptProgressListener$lambda$24;
                    switchToExceptProgressListener$lambda$24 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$24(DownloadListener.this, (DownloadTask) obj, (EndCause) obj2, (Exception) obj3, (Listener1Assist.Listener1Model) obj4);
                    return switchToExceptProgressListener$lambda$24;
                }
            }, 8, null);
        }
        if (!(downloadListener instanceof DownloadListener2)) {
            return createListener$default(new Function1() { // from class: com.qiahao.base_common.download.okDownload.listener.k
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit switchToExceptProgressListener$lambda$25;
                    switchToExceptProgressListener$lambda$25 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$25(DownloadListener.this, (DownloadTask) obj);
                    return switchToExceptProgressListener$lambda$25;
                }
            }, new Function2() { // from class: com.qiahao.base_common.download.okDownload.listener.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit switchToExceptProgressListener$lambda$26;
                    switchToExceptProgressListener$lambda$26 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$26(DownloadListener.this, (DownloadTask) obj, (Map) obj2);
                    return switchToExceptProgressListener$lambda$26;
                }
            }, new Function3() { // from class: com.qiahao.base_common.download.okDownload.listener.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit switchToExceptProgressListener$lambda$27;
                    switchToExceptProgressListener$lambda$27 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$27(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), (Map) obj3);
                    return switchToExceptProgressListener$lambda$27;
                }
            }, new Function3() { // from class: com.qiahao.base_common.download.okDownload.listener.o
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit switchToExceptProgressListener$lambda$28;
                    switchToExceptProgressListener$lambda$28 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$28(DownloadListener.this, (DownloadTask) obj, (BreakpointInfo) obj2, (ResumeFailedCause) obj3);
                    return switchToExceptProgressListener$lambda$28;
                }
            }, new Function2() { // from class: com.qiahao.base_common.download.okDownload.listener.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit switchToExceptProgressListener$lambda$29;
                    switchToExceptProgressListener$lambda$29 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$29(DownloadListener.this, (DownloadTask) obj, (BreakpointInfo) obj2);
                    return switchToExceptProgressListener$lambda$29;
                }
            }, new Function3() { // from class: com.qiahao.base_common.download.okDownload.listener.r
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit switchToExceptProgressListener$lambda$30;
                    switchToExceptProgressListener$lambda$30 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$30(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), (Map) obj3);
                    return switchToExceptProgressListener$lambda$30;
                }
            }, new Function4() { // from class: com.qiahao.base_common.download.okDownload.listener.s
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit switchToExceptProgressListener$lambda$31;
                    switchToExceptProgressListener$lambda$31 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$31(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (Map) obj4);
                    return switchToExceptProgressListener$lambda$31;
                }
            }, new Function3() { // from class: com.qiahao.base_common.download.okDownload.listener.t
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit switchToExceptProgressListener$lambda$32;
                    switchToExceptProgressListener$lambda$32 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$32(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), ((Long) obj3).longValue());
                    return switchToExceptProgressListener$lambda$32;
                }
            }, null, new Function3() { // from class: com.qiahao.base_common.download.okDownload.listener.u
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit switchToExceptProgressListener$lambda$33;
                    switchToExceptProgressListener$lambda$33 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$33(DownloadListener.this, (DownloadTask) obj, ((Integer) obj2).intValue(), ((Long) obj3).longValue());
                    return switchToExceptProgressListener$lambda$33;
                }
            }, new Function3() { // from class: com.qiahao.base_common.download.okDownload.listener.v
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit switchToExceptProgressListener$lambda$34;
                    switchToExceptProgressListener$lambda$34 = DownloadListenerExtensionKt.switchToExceptProgressListener$lambda$34(DownloadListener.this, (DownloadTask) obj, (EndCause) obj2, (Exception) obj3);
                    return switchToExceptProgressListener$lambda$34;
                }
            }, 256, null);
        }
        return downloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$0(DownloadListener downloadListener, DownloadTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        downloadListener.taskStart(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$1(DownloadListener downloadListener, DownloadTask task, int i10, Map requestHeaderFields) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(requestHeaderFields, "requestHeaderFields");
        downloadListener.connectStart(task, i10, requestHeaderFields);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$10(DownloadListener downloadListener, DownloadTask task, BreakpointInfo info, boolean z10, Listener4Assist.Listener4Model model) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(model, "model");
        ((DownloadListener4) downloadListener).infoReady(task, info, z10, model);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$11(DownloadListener downloadListener, DownloadTask task, int i10, long j10) {
        Intrinsics.checkNotNullParameter(task, "task");
        ((DownloadListener4) downloadListener).progressBlock(task, i10, j10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$12(DownloadListener downloadListener, DownloadTask task, int i10, BlockInfo info) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(info, "info");
        ((DownloadListener4) downloadListener).blockEnd(task, i10, info);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$13(DownloadListener downloadListener, DownloadTask task, EndCause cause, Exception exc, Listener4Assist.Listener4Model model) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(model, "model");
        ((DownloadListener4) downloadListener).taskEnd(task, cause, exc, model);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$14(DownloadListener downloadListener, DownloadTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ((DownloadListener3) downloadListener).taskStart(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$15(DownloadListener downloadListener, DownloadTask task, int i10, long j10, long j11) {
        Intrinsics.checkNotNullParameter(task, "task");
        ((DownloadListener3) downloadListener).connected(task, i10, j10, j11);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$16(DownloadListener downloadListener, DownloadTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ((DownloadListener3) downloadListener).taskEnd(it, EndCause.COMPLETED, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$17(DownloadListener downloadListener, DownloadTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ((DownloadListener3) downloadListener).taskEnd(it, EndCause.CANCELED, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$18(DownloadListener downloadListener, DownloadTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ((DownloadListener3) downloadListener).taskEnd(it, EndCause.SAME_TASK_BUSY, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$19(DownloadListener downloadListener, DownloadTask task, ResumeFailedCause cause) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(cause, "cause");
        ((DownloadListener3) downloadListener).retry(task, cause);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$2(DownloadListener downloadListener, DownloadTask task, int i10, int i11, Map responseHeaderFields) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(responseHeaderFields, "responseHeaderFields");
        downloadListener.connectEnd(task, i10, i11, responseHeaderFields);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$20(DownloadListener downloadListener, DownloadTask task, Exception e10) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(e10, "e");
        ((DownloadListener3) downloadListener).taskEnd(task, EndCause.ERROR, e10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$21(DownloadListener downloadListener, DownloadTask task, Listener1Assist.Listener1Model model) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(model, "model");
        ((DownloadListener1) downloadListener).taskStart(task, model);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$22(DownloadListener downloadListener, DownloadTask task, ResumeFailedCause cause) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(cause, "cause");
        ((DownloadListener1) downloadListener).retry(task, cause);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$23(DownloadListener downloadListener, DownloadTask task, int i10, long j10, long j11) {
        Intrinsics.checkNotNullParameter(task, "task");
        ((DownloadListener1) downloadListener).connected(task, i10, j10, j11);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$24(DownloadListener downloadListener, DownloadTask task, EndCause cause, Exception exc, Listener1Assist.Listener1Model model) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(model, "model");
        ((DownloadListener1) downloadListener).taskEnd(task, cause, exc, model);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$25(DownloadListener downloadListener, DownloadTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        downloadListener.taskStart(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$26(DownloadListener downloadListener, DownloadTask task, Map requestFields) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(requestFields, "requestFields");
        downloadListener.connectTrialStart(task, requestFields);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$27(DownloadListener downloadListener, DownloadTask task, int i10, Map responseHeaderFields) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(responseHeaderFields, "responseHeaderFields");
        downloadListener.connectTrialEnd(task, i10, responseHeaderFields);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$28(DownloadListener downloadListener, DownloadTask task, BreakpointInfo info, ResumeFailedCause cause) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(cause, "cause");
        downloadListener.downloadFromBeginning(task, info, cause);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$29(DownloadListener downloadListener, DownloadTask task, BreakpointInfo info) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(info, "info");
        downloadListener.downloadFromBreakpoint(task, info);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$3(DownloadListener downloadListener, DownloadTask task, BreakpointInfo info, boolean z10, Listener4SpeedAssistExtend.Listener4SpeedModel model) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(model, "model");
        ((DownloadListener4WithSpeed) downloadListener).infoReady(task, info, z10, model);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$30(DownloadListener downloadListener, DownloadTask task, int i10, Map requestHeaderFields) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(requestHeaderFields, "requestHeaderFields");
        downloadListener.connectStart(task, i10, requestHeaderFields);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$31(DownloadListener downloadListener, DownloadTask task, int i10, int i11, Map responseHeaderFields) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(responseHeaderFields, "responseHeaderFields");
        downloadListener.connectEnd(task, i10, i11, responseHeaderFields);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$32(DownloadListener downloadListener, DownloadTask task, int i10, long j10) {
        Intrinsics.checkNotNullParameter(task, "task");
        downloadListener.fetchStart(task, i10, j10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$33(DownloadListener downloadListener, DownloadTask task, int i10, long j10) {
        Intrinsics.checkNotNullParameter(task, "task");
        downloadListener.fetchEnd(task, i10, j10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$34(DownloadListener downloadListener, DownloadTask task, EndCause cause, Exception exc) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(cause, "cause");
        downloadListener.taskEnd(task, cause, exc);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$4(DownloadListener downloadListener, DownloadTask task, int i10, long j10, SpeedCalculator blockSpeed) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(blockSpeed, "blockSpeed");
        ((DownloadListener4WithSpeed) downloadListener).progressBlock(task, i10, j10, blockSpeed);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$5(DownloadListener downloadListener, DownloadTask task, int i10, BlockInfo info, SpeedCalculator blockSpeed) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(blockSpeed, "blockSpeed");
        ((DownloadListener4WithSpeed) downloadListener).blockEnd(task, i10, info, blockSpeed);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$6(DownloadListener downloadListener, DownloadTask task, EndCause cause, Exception exc, SpeedCalculator taskSpeed) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(taskSpeed, "taskSpeed");
        ((DownloadListener4WithSpeed) downloadListener).taskEnd(task, cause, exc, taskSpeed);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$7(DownloadListener downloadListener, DownloadTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        downloadListener.taskStart(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$8(DownloadListener downloadListener, DownloadTask task, int i10, Map requestHeaderFields) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(requestHeaderFields, "requestHeaderFields");
        downloadListener.connectStart(task, i10, requestHeaderFields);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit switchToExceptProgressListener$lambda$9(DownloadListener downloadListener, DownloadTask task, int i10, int i11, Map responseHeaderFields) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(responseHeaderFields, "responseHeaderFields");
        downloadListener.connectEnd(task, i10, i11, responseHeaderFields);
        return Unit.INSTANCE;
    }
}
