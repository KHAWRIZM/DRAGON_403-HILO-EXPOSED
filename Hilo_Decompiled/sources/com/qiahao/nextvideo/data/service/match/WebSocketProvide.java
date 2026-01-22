package com.qiahao.nextvideo.data.service.match;

import android.os.CountDownTimer;
import android.text.TextUtils;
import com.google.protobuf.h0;
import com.oudi.utils.TimerTask;
import com.oudi.utils.ktx.TimerKtxKt;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.network.BaseServer;
import com.qiahao.base_common.network.ServerInfo;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.picture.AdvancedMessageProcessingSystem;
import com.qiahao.nextvideo.HiloApplication;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.game.YouTuGameData;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.utilities.f0;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.net.Proxy;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import roomMessage.RoomMessage;
import userProxy.UserProxy;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000Ó\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004*\u0001c\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJi\u0010)\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00142\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010 2:\b\u0002\u0010(\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110&¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u0004\u0018\u00010#¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\u0004¢\u0006\u0004\b+\u0010\u0003J\r\u0010,\u001a\u00020\u0004¢\u0006\u0004\b,\u0010\u0003Js\u00102\u001a\u00020\u00042\u001c\u0010/\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0.\u0012\u0006\u0012\u0004\u0018\u00010\u00010-27\b\u0002\u00101\u001a1\b\u0001\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(0\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040.\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010#2\n\b\u0002\u00100\u001a\u0004\u0018\u00010 H\u0086@¢\u0006\u0004\b2\u00103Jc\u00108\u001a\u00020\u00042\u0006\u00105\u001a\u0002042L\b\u0002\u0010(\u001aF\b\u0001\u0012\u0015\u0012\u0013\u0018\u000104¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(7\u0012\u0013\u0012\u00110&¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b('\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040.\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u000106¢\u0006\u0004\b8\u00109R\u0018\u0010:\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001e\u0010C\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010E\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010AR\u001e\u0010F\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010H\u001a\u00020G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010Q\u001a\u00020P8\u0002X\u0082T¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020P8\u0002X\u0082T¢\u0006\u0006\n\u0004\bS\u0010RR\u0014\u0010T\u001a\u00020P8\u0002X\u0082T¢\u0006\u0006\n\u0004\bT\u0010RR\u0014\u0010U\u001a\u00020P8\u0002X\u0082T¢\u0006\u0006\n\u0004\bU\u0010RR\u0017\u0010W\u001a\u00020V8\u0006¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0018\u0010\\\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u001d\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00180^8\u0006¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\u0014\u0010d\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010e¨\u0006f"}, d2 = {"Lcom/qiahao/nextvideo/data/service/match/WebSocketProvide;", "", "<init>", "()V", "", "keepWebSocket", "sendHeartbeat", "", "t", "handleWebSocketFailure", "(Ljava/lang/Throwable;)V", "Lokhttp3/WebSocket;", "socket", "handleWebSocketOpen", "(Lokhttp3/WebSocket;)V", "roomSocketConnect", "exitRoomSocket", "Lokhttp3/OkHttpClient$Builder;", "getOkHttpClientBuilder", "()Lokhttp3/OkHttpClient$Builder;", "", "msgType", "Lcom/google/protobuf/h0;", "generatedMessageV3", "Lokio/ByteString;", "pack", "(ILcom/google/protobuf/h0;)Lokio/ByteString;", "Lcom/qiahao/nextvideo/data/game/YouTuGameData;", "dat", "youtubeVideoSync", "(Lcom/qiahao/nextvideo/data/game/YouTuGameData;)V", "type", "", "groupId", "seqId", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "isSuccess", "completion", "roomWebSocket", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "reconnect", "disconnect", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "sendAction", "msgId", "errorAction", "executeWithTimeout", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LroomMessage/RoomMessage$GroupMessageSend;", "messageData", "Lkotlin/Function3;", "msg", "roomMessage", "(LroomMessage/RoomMessage$GroupMessageSend;Lkotlin/jvm/functions/Function3;)V", "webSocket", "Lokhttp3/WebSocket;", "Lokhttp3/OkHttpClient;", "okHttpClient", "Lokhttp3/OkHttpClient;", "Lcom/oudi/utils/TimerTask;", "mRoomTimerTask", "Lcom/oudi/utils/TimerTask;", "Ljava/lang/ref/WeakReference;", "mRoomTimerTaskRef", "Ljava/lang/ref/WeakReference;", "mAppTimerTask", "mAppTimerTaskRef", "Lkotlinx/coroutines/CompletableJob;", "webSocketJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "coroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlinx/coroutines/CoroutineScope;", "webSocketScope", "Lkotlinx/coroutines/CoroutineScope;", "", "RECONNECT_WAIT_TIME_IN_MILLS", "J", "CONNECT_TIME_OUT_IN_SECS", "PING_INTERVAL_IN_SECS", "SEND_TIMEOUT_MILLIS", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "Landroid/os/CountDownTimer;", "mCountDownTimer", "Landroid/os/CountDownTimer;", "Lcom/qiahao/base_common/utils/picture/AdvancedMessageProcessingSystem;", "mSystem", "Lcom/qiahao/base_common/utils/picture/AdvancedMessageProcessingSystem;", "getMSystem", "()Lcom/qiahao/base_common/utils/picture/AdvancedMessageProcessingSystem;", "com/qiahao/nextvideo/data/service/match/WebSocketProvide$webSocketListener$1", "webSocketListener", "Lcom/qiahao/nextvideo/data/service/match/WebSocketProvide$webSocketListener$1;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWebSocketProvide.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebSocketProvide.kt\ncom/qiahao/nextvideo/data/service/match/WebSocketProvide\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n1#1,528:1\n1#2:529\n44#3,4:530\n*S KotlinDebug\n*F\n+ 1 WebSocketProvide.kt\ncom/qiahao/nextvideo/data/service/match/WebSocketProvide\n*L\n72#1:530,4\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WebSocketProvide {
    private static final long CONNECT_TIME_OUT_IN_SECS = 10;

    @NotNull
    public static final WebSocketProvide INSTANCE;
    private static final long PING_INTERVAL_IN_SECS = 5;
    private static final long RECONNECT_WAIT_TIME_IN_MILLS = 1000;
    private static final long SEND_TIMEOUT_MILLIS = 10000;

    @NotNull
    private static final nd.a compositeDisposable;

    @NotNull
    private static final CoroutineExceptionHandler coroutineExceptionHandler;

    @Nullable
    private static TimerTask mAppTimerTask;

    @Nullable
    private static WeakReference<TimerTask> mAppTimerTaskRef;

    @Nullable
    private static CountDownTimer mCountDownTimer;

    @Nullable
    private static TimerTask mRoomTimerTask;

    @Nullable
    private static WeakReference<TimerTask> mRoomTimerTaskRef;

    @NotNull
    private static final AdvancedMessageProcessingSystem<ByteString> mSystem;

    @Nullable
    private static OkHttpClient okHttpClient;

    @Nullable
    private static WebSocket webSocket;

    @NotNull
    private static CompletableJob webSocketJob;

    @NotNull
    private static final WebSocketProvide$webSocketListener$1 webSocketListener;

    @NotNull
    private static CoroutineScope webSocketScope;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.qiahao.nextvideo.data.service.match.WebSocketProvide$1 */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    static final class AnonymousClass1<T> implements pd.g {
        public static final AnonymousClass1<T> INSTANCE = ;

        AnonymousClass1() {
        }

        public final void accept(String str) {
            WebSocketProvide.INSTANCE.reconnect();
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.qiahao.nextvideo.data.service.match.WebSocketProvide$webSocketListener$1] */
    static {
        WebSocketProvide webSocketProvide = new WebSocketProvide();
        INSTANCE = webSocketProvide;
        webSocketJob = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        WebSocketProvide$special$$inlined$CoroutineExceptionHandler$1 webSocketProvide$special$$inlined$CoroutineExceptionHandler$1 = new WebSocketProvide$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
        coroutineExceptionHandler = webSocketProvide$special$$inlined$CoroutineExceptionHandler$1;
        webSocketScope = CoroutineScopeKt.CoroutineScope(webSocketJob.plus(Dispatchers.getIO().limitedParallelism(5)).plus(webSocketProvide$special$$inlined$CoroutineExceptionHandler$1));
        nd.a aVar = new nd.a();
        compositeDisposable = aVar;
        mSystem = new AdvancedMessageProcessingSystem<>("webSocket", 5, 0, 0, new WebSocketProvide$mSystem$1(null), 12, (DefaultConstructorMarker) null);
        okHttpClient = webSocketProvide.getOkHttpClientBuilder().build();
        nd.c subscribe = BaseServer.INSTANCE.getSelectedServerChange().observeOn(md.b.c()).subscribe(AnonymousClass1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, aVar);
        webSocketListener = new WebSocketListener() { // from class: com.qiahao.nextvideo.data.service.match.WebSocketProvide$webSocketListener$1
            @Override // okhttp3.WebSocketListener
            public void onFailure(WebSocket socket, Throwable t, Response response) {
                Intrinsics.checkNotNullParameter(socket, "socket");
                Intrinsics.checkNotNullParameter(t, "t");
                super.onFailure(socket, t, response);
                WebSocketProvide.INSTANCE.handleWebSocketFailure(t);
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket2, ByteString bytes) {
                CoroutineScope coroutineScope;
                Intrinsics.checkNotNullParameter(webSocket2, "webSocket");
                Intrinsics.checkNotNullParameter(bytes, "bytes");
                super.onMessage(webSocket2, bytes);
                try {
                    coroutineScope = WebSocketProvide.webSocketScope;
                    BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new WebSocketProvide$webSocketListener$1$onMessage$1(bytes, null), 3, (Object) null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // okhttp3.WebSocketListener
            public void onOpen(WebSocket socket, Response response) {
                Intrinsics.checkNotNullParameter(socket, "socket");
                Intrinsics.checkNotNullParameter(response, "response");
                super.onOpen(socket, response);
                WebSocketProvide.INSTANCE.handleWebSocketOpen(socket);
            }
        };
    }

    private WebSocketProvide() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object executeWithTimeout$default(WebSocketProvide webSocketProvide, Function1 function1, Function2 function2, String str, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        return webSocketProvide.executeWithTimeout(function1, function2, str, continuation);
    }

    private final void exitRoomSocket() {
        try {
            try {
                TimerTask timerTask = mRoomTimerTask;
                if (timerTask != null) {
                    timerTask.cancel();
                }
                WeakReference<TimerTask> weakReference = mRoomTimerTaskRef;
                if (weakReference != null) {
                    weakReference.clear();
                }
                CountDownTimer countDownTimer = mCountDownTimer;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            } catch (Exception e) {
                LogUtil logUtil = LogUtil.INSTANCE;
                e.printStackTrace();
                LogUtil.w$default(logUtil, "WebSocketProvide", "取消定时任务时发生异常" + Unit.INSTANCE, false, 4, (Object) null);
            }
            mRoomTimerTask = null;
            mRoomTimerTaskRef = null;
            mCountDownTimer = null;
        } catch (Throwable th) {
            mRoomTimerTask = null;
            mRoomTimerTaskRef = null;
            mCountDownTimer = null;
            throw th;
        }
    }

    private final OkHttpClient.Builder getOkHttpClientBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder pingInterval = builder.connectTimeout(10L, timeUnit).pingInterval(5L, timeUnit);
        pingInterval.proxy(Proxy.NO_PROXY);
        return pingInterval;
    }

    public final void handleWebSocketFailure(Throwable t) {
        Dispatcher dispatcher;
        try {
            OkHttpClient okHttpClient2 = okHttpClient;
            if (okHttpClient2 != null && (dispatcher = okHttpClient2.dispatcher()) != null) {
                dispatcher.cancelAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebSocket webSocket2 = webSocket;
        if (webSocket2 != null) {
            webSocket2.cancel();
        }
        WebSocket webSocket3 = webSocket;
        if (webSocket3 != null) {
            webSocket3.close(1000, "close by myself.");
        }
        webSocket = null;
        if (UserStore.INSTANCE.getShared().getUser() != null) {
            HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.data.service.match.m
                @Override // java.lang.Runnable
                public final void run() {
                    WebSocketProvide.handleWebSocketFailure$lambda$2();
                }
            }, RECONNECT_WAIT_TIME_IN_MILLS);
        }
    }

    public static final void handleWebSocketFailure$lambda$2() {
        LogUtil.w$default(LogUtil.INSTANCE, "WebSocketProvide", "连接失败，尝试重新连接", false, 4, (Object) null);
        WebSocketProvide webSocketProvide = INSTANCE;
        webSocketProvide.reconnect();
        webSocketProvide.roomSocketConnect();
    }

    public final void handleWebSocketOpen(WebSocket socket) {
        WebSocket webSocket2;
        if (webSocket == null) {
            webSocket = socket;
            String authenticationToken = UserStore.INSTANCE.getShared().getAuthenticationToken();
            if (authenticationToken != null && (webSocket2 = webSocket) != null) {
                WebSocketProvide webSocketProvide = INSTANCE;
                UserProxy.Login login = UserProxy.Login.newBuilder().setToken(authenticationToken).m٢١٠٧build();
                Intrinsics.checkNotNullExpressionValue(login, "build(...)");
                webSocket2.send(webSocketProvide.pack(1, login));
            }
        }
    }

    private final void keepWebSocket() {
        try {
            TimerTask timerTask = mAppTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
            }
        } catch (Exception e) {
            LogUtil logUtil = LogUtil.INSTANCE;
            e.printStackTrace();
            LogUtil.w$default(logUtil, "WebSocketProvide", "取消旧定时任务时发生异常:" + Unit.INSTANCE, false, 4, (Object) null);
        }
        TimerTask loopTask = TimerKtxKt.loopTask(HiloApplication.INSTANCE.getAppLifecycleScope(), false, 5000L, new Function1() { // from class: com.qiahao.nextvideo.data.service.match.k
            public final Object invoke(Object obj) {
                Unit keepWebSocket$lambda$1;
                keepWebSocket$lambda$1 = WebSocketProvide.keepWebSocket$lambda$1(((Long) obj).longValue());
                return keepWebSocket$lambda$1;
            }
        });
        mAppTimerTask = loopTask;
        mAppTimerTaskRef = new WeakReference<>(loopTask);
    }

    public static final Unit keepWebSocket$lambda$1(long j) {
        INSTANCE.sendHeartbeat();
        return Unit.INSTANCE;
    }

    public final ByteString pack(int msgType, h0 generatedMessageV3) {
        long currentTimeMillis = System.currentTimeMillis() * 1000;
        int length = generatedMessageV3.toByteArray().length;
        byte[] byteArray = generatedMessageV3.toByteArray();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(f0.d((short) 1));
        byteArrayOutputStream.write(f0.b(msgType));
        byteArrayOutputStream.write(f0.c(System.currentTimeMillis()));
        byteArrayOutputStream.write(f0.c(currentTimeMillis));
        byteArrayOutputStream.write(f0.b(length));
        byteArrayOutputStream.write(byteArray);
        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(byteArray2);
        byteArrayOutputStream.write(f0.b((int) crc32.getValue()));
        ByteString.Companion companion = ByteString.Companion;
        byte[] byteArray3 = byteArrayOutputStream.toByteArray();
        return companion.of(Arrays.copyOf(byteArray3, byteArray3.length));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void roomMessage$default(WebSocketProvide webSocketProvide, RoomMessage.GroupMessageSend groupMessageSend, Function3 function3, int i, Object obj) {
        if ((i & 2) != 0) {
            function3 = null;
        }
        webSocketProvide.roomMessage(groupMessageSend, function3);
    }

    public final void roomSocketConnect() {
        final String str;
        String videoID;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.getMGroupId().length() > 0) {
            str = meetingRoomManager.getMGroupId();
        } else {
            MatchingProvide matchingProvide = MatchingProvide.INSTANCE;
            if (Intrinsics.areEqual(matchingProvide.getMatchStatue(), MatchingProvide.IS_VIDEO) && (videoID = matchingProvide.getVideoID()) != null && videoID.length() > 0) {
                str = matchingProvide.getVideoID();
                if (str == null) {
                    str = "";
                }
            } else {
                str = null;
            }
        }
        if (str != null) {
            try {
                TimerTask timerTask = mRoomTimerTask;
                if (timerTask != null) {
                    timerTask.cancel();
                }
            } catch (Exception e) {
                LogUtil.w$default(LogUtil.INSTANCE, "WebSocketProvide", "取消旧定时任务时发生异常: " + e.getMessage(), false, 4, (Object) null);
            }
            TimerTask loopTask = TimerKtxKt.loopTask(HiloApplication.INSTANCE.getAppLifecycleScope(), false, 6000L, new Function1() { // from class: com.qiahao.nextvideo.data.service.match.l
                public final Object invoke(Object obj) {
                    Unit roomSocketConnect$lambda$5;
                    roomSocketConnect$lambda$5 = WebSocketProvide.roomSocketConnect$lambda$5(str, ((Long) obj).longValue());
                    return roomSocketConnect$lambda$5;
                }
            });
            mRoomTimerTask = loopTask;
            mRoomTimerTaskRef = new WeakReference<>(loopTask);
        }
    }

    public static final Unit roomSocketConnect$lambda$5(String str, long j) {
        roomWebSocket$default(INSTANCE, 154, str, null, null, 12, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void roomWebSocket$default(WebSocketProvide webSocketProvide, int i, String str, String str2, Function2 function2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        if ((i2 & 8) != 0) {
            function2 = null;
        }
        webSocketProvide.roomWebSocket(i, str, str2, function2);
    }

    private final void sendHeartbeat() {
        try {
            if (webSocket != null && UserStore.INSTANCE.getShared().getUser() != null) {
                if (!HiloUtils.INSTANCE.isNetworkAvailable()) {
                    LogUtil.w$default(LogUtil.INSTANCE, "WebSocketProvide", "网络不可用，跳过心跳包发送", false, 4, (Object) null);
                } else {
                    BuildersKt.launch$default(webSocketScope, Dispatchers.getIO(), (CoroutineStart) null, new WebSocketProvide$sendHeartbeat$1(null), 2, (Object) null);
                }
            }
        } catch (Exception e) {
            LogUtil logUtil = LogUtil.INSTANCE;
            e.printStackTrace();
            LogUtil.w$default(logUtil, "WebSocketProvide", "准备心跳包数据失败" + Unit.INSTANCE, false, 4, (Object) null);
        }
    }

    public final void disconnect() {
        Dispatcher dispatcher;
        exitRoomSocket();
        try {
            try {
                TimerTask timerTask = mAppTimerTask;
                if (timerTask != null) {
                    timerTask.cancel();
                }
                WeakReference<TimerTask> weakReference = mAppTimerTaskRef;
                if (weakReference != null) {
                    weakReference.clear();
                }
            } catch (Exception e) {
                LogUtil.w$default(LogUtil.INSTANCE, "WebSocketProvide", "取消App定时任务时发生异常: " + e.getMessage(), false, 4, (Object) null);
            }
            mAppTimerTask = null;
            mAppTimerTaskRef = null;
            BuildersKt.launch$default(webSocketScope, (CoroutineContext) null, (CoroutineStart) null, new WebSocketProvide$disconnect$1(null), 3, (Object) null);
            Job.DefaultImpls.cancel$default(webSocketJob, (CancellationException) null, 1, (Object) null);
            OkHttpClient okHttpClient2 = okHttpClient;
            if (okHttpClient2 != null && (dispatcher = okHttpClient2.dispatcher()) != null) {
                dispatcher.cancelAll();
            }
            WebSocket webSocket2 = webSocket;
            if (webSocket2 != null) {
                webSocket2.cancel();
            }
            WebSocket webSocket3 = webSocket;
            if (webSocket3 != null) {
                webSocket3.close(1000, "user was logout.");
            }
            webSocket = null;
        } catch (Throwable th) {
            mAppTimerTask = null;
            mAppTimerTaskRef = null;
            throw th;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(1:(3:15|16|17)(2:12|13))(2:18|19))(3:22|23|(1:25))|20|16|17))|36|6|7|(0)(0)|20|16|17) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0070, code lost:
    
        if (r11 != null) goto L٦٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007c, code lost:
    
        if (r11.invoke(r12, r0) == r1) goto L٧٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007e, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
    
        if (r11 != null) goto L٦٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0063, code lost:
    
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006d, code lost:
    
        if (r11.invoke(r12, r0) == r1) goto L٦٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006f, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeWithTimeout(@NotNull Function1<? super Continuation<? super Boolean>, ? extends Object> function1, @Nullable Function2<? super String, ? super Continuation<? super Unit>, ? extends Object> function2, @Nullable String str, @NotNull Continuation<? super Unit> continuation) {
        WebSocketProvide$executeWithTimeout$1 webSocketProvide$executeWithTimeout$1;
        int i;
        if (continuation instanceof WebSocketProvide$executeWithTimeout$1) {
            webSocketProvide$executeWithTimeout$1 = (WebSocketProvide$executeWithTimeout$1) continuation;
            int i2 = webSocketProvide$executeWithTimeout$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                webSocketProvide$executeWithTimeout$1.label = i2 - Integer.MIN_VALUE;
                Object obj = webSocketProvide$executeWithTimeout$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = webSocketProvide$executeWithTimeout$1.label;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2 || i == 3) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) webSocketProvide$executeWithTimeout$1.L$1;
                    function2 = (Function2) webSocketProvide$executeWithTimeout$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    WebSocketProvide$executeWithTimeout$2 webSocketProvide$executeWithTimeout$2 = new WebSocketProvide$executeWithTimeout$2(function1, function2, str, null);
                    webSocketProvide$executeWithTimeout$1.L$0 = function2;
                    webSocketProvide$executeWithTimeout$1.L$1 = str;
                    webSocketProvide$executeWithTimeout$1.label = 1;
                    if (TimeoutKt.withTimeout(SEND_TIMEOUT_MILLIS, webSocketProvide$executeWithTimeout$2, webSocketProvide$executeWithTimeout$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        webSocketProvide$executeWithTimeout$1 = new WebSocketProvide$executeWithTimeout$1(this, continuation);
        Object obj2 = webSocketProvide$executeWithTimeout$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = webSocketProvide$executeWithTimeout$1.label;
        if (i == 0) {
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return compositeDisposable;
    }

    @NotNull
    public final AdvancedMessageProcessingSystem<ByteString> getMSystem() {
        return mSystem;
    }

    public final void reconnect() {
        String str;
        if (webSocketJob.isCancelled()) {
            CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
            webSocketJob = SupervisorJob$default;
            webSocketScope = CoroutineScopeKt.CoroutineScope(SupervisorJob$default.plus(Dispatchers.getIO().limitedParallelism(5)).plus(coroutineExceptionHandler));
        }
        keepWebSocket();
        mSystem.start();
        Request.Builder builder = new Request.Builder().get();
        ServerInfo selectedServerInfo = BaseServer.INSTANCE.getSelectedServerInfo();
        if (selectedServerInfo == null || (str = selectedServerInfo.getMatchWebSocketAddr()) == null) {
            str = "";
        }
        Request build = builder.url(str).build();
        OkHttpClient okHttpClient2 = okHttpClient;
        if (okHttpClient2 != null) {
            okHttpClient2.newWebSocket(build, webSocketListener);
        }
        String authenticationToken = UserStore.INSTANCE.getShared().getAuthenticationToken();
        if (authenticationToken != null) {
            BuildersKt.launch$default(webSocketScope, Dispatchers.getIO(), (CoroutineStart) null, new WebSocketProvide$reconnect$1$1(authenticationToken, null), 2, (Object) null);
        }
    }

    public final void roomMessage(@NotNull RoomMessage.GroupMessageSend messageData, @Nullable Function3<? super RoomMessage.GroupMessageSend, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> completion) {
        Intrinsics.checkNotNullParameter(messageData, "messageData");
        if (!TextUtils.isEmpty(messageData.getGroupId()) && !TextUtils.isEmpty(messageData.getMsgId())) {
            BuildersKt.launch$default(webSocketScope, Dispatchers.getIO(), (CoroutineStart) null, new WebSocketProvide$roomMessage$1(completion, messageData, null), 2, (Object) null);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x000d. Please report as an issue. */
    public final void roomWebSocket(int type, @Nullable String groupId, @Nullable String seqId, @Nullable Function2<? super Integer, ? super Boolean, Unit> completion) {
        ByteString pack;
        ByteString pack2;
        try {
            if (type != 156) {
                if (type != 194) {
                    switch (type) {
                        case 152:
                            if (TextUtils.isEmpty(groupId)) {
                                return;
                            }
                            UserProxy1.EnterRoom enterRoom = UserProxy1.EnterRoom.newBuilder().setGroupId(groupId).m٣٤٨٧build();
                            Intrinsics.checkNotNullExpressionValue(enterRoom, "build(...)");
                            pack2 = pack(152, enterRoom);
                            CountDownTimer countDownTimer = mCountDownTimer;
                            if (countDownTimer != null) {
                                countDownTimer.cancel();
                            }
                            mCountDownTimer = new CountDownTimer() { // from class: com.qiahao.nextvideo.data.service.match.WebSocketProvide$roomWebSocket$1
                                @Override // android.os.CountDownTimer
                                public void onFinish() {
                                    WebSocketProvide.INSTANCE.roomSocketConnect();
                                }

                                @Override // android.os.CountDownTimer
                                public void onTick(long millisUntilFinished) {
                                }
                            }.start();
                            LogUtil.w$default(LogUtil.INSTANCE, "WebSocketProvide", "房间socket 用户进房(" + groupId + ") 上行", false, 4, (Object) null);
                            pack = pack2;
                            break;
                        case 153:
                            if (TextUtils.isEmpty(groupId) || HiloUtils.INSTANCE.isFastClick()) {
                                return;
                            }
                            UserProxy1.LeaveRoom leaveRoom = UserProxy1.LeaveRoom.newBuilder().setGroupId(groupId).m٤٤٩٩build();
                            Intrinsics.checkNotNullExpressionValue(leaveRoom, "build(...)");
                            pack2 = pack(153, leaveRoom);
                            exitRoomSocket();
                            LogUtil.w$default(LogUtil.INSTANCE, "WebSocketProvide", "房间socket 用户离房(" + groupId + ") 上行", false, 4, (Object) null);
                            pack = pack2;
                            break;
                            break;
                        case 154:
                            if (TextUtils.isEmpty(groupId)) {
                                return;
                            }
                            UserProxy1.RoomHeartBeat roomHeartBeat = UserProxy1.RoomHeartBeat.newBuilder().setGroupId(groupId).m٥١٤٣build();
                            Intrinsics.checkNotNullExpressionValue(roomHeartBeat, "build(...)");
                            pack = pack(154, roomHeartBeat);
                            break;
                        default:
                            pack = null;
                            break;
                    }
                } else {
                    if (TextUtils.isEmpty(groupId)) {
                        return;
                    }
                    UserProxy1.RoomReady roomReady = UserProxy1.RoomReady.newBuilder().setGroupId(groupId).m٥٢٨١build();
                    Intrinsics.checkNotNullExpressionValue(roomReady, "build(...)");
                    pack = pack(UserProxyUtility.roomReady, roomReady);
                }
            } else {
                if (TextUtils.isEmpty(seqId) || MeetingRoomManager.INSTANCE.getMGroupId().length() == 0) {
                    return;
                }
                UserProxy1.GroupMicChangeRsp groupMicChangeRsp = UserProxy1.GroupMicChangeRsp.newBuilder().setSeqId(seqId).m٣٩٤٧build();
                Intrinsics.checkNotNullExpressionValue(groupMicChangeRsp, "build(...)");
                pack = pack(156, groupMicChangeRsp);
            }
            if (pack != null) {
                BuildersKt.launch$default(webSocketScope, Dispatchers.getIO(), (CoroutineStart) null, new WebSocketProvide$roomWebSocket$2$1(pack, completion, type, null), 2, (Object) null);
            }
        } catch (Exception e) {
            if (completion != null) {
                completion.invoke(Integer.valueOf(type), Boolean.FALSE);
            }
            LogUtil.w$default(LogUtil.INSTANCE, "WebSocketProvide", "房间socket消息错误：" + e.getMessage(), false, 4, (Object) null);
        }
    }

    public final void youtubeVideoSync(@NotNull YouTuGameData dat) {
        Intrinsics.checkNotNullParameter(dat, "dat");
        BuildersKt.launch$default(webSocketScope, Dispatchers.getIO(), (CoroutineStart) null, new WebSocketProvide$youtubeVideoSync$1(dat, null), 2, (Object) null);
    }
}
