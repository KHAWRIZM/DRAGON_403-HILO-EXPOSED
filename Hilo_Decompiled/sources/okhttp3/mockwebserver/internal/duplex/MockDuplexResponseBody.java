package okhttp3.mockwebserver.internal.duplex;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.mockwebserver.RecordedRequest;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0000J\u0006\u0010\u0014\u001a\u00020\u0000J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0000J\u001a\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0016\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%R6\u0010\u0003\u001a*\u0012&\u0012$\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lokhttp3/mockwebserver/internal/duplex/MockDuplexResponseBody;", "Lokhttp3/mockwebserver/internal/duplex/DuplexResponseBody;", "()V", "actions", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lkotlin/Function4;", "Lokhttp3/mockwebserver/RecordedRequest;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "Lokhttp3/internal/http2/Http2Stream;", "", "Lokhttp3/mockwebserver/internal/duplex/Action;", "results", "Ljava/util/concurrent/FutureTask;", "Ljava/lang/Void;", "awaitSuccess", "cancelStream", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "exhaustRequest", "exhaustResponse", "onRequest", "request", "http2Stream", "receiveRequest", "expected", "", "requestIOException", "sendResponse", "s", "responseSent", "Ljava/util/concurrent/CountDownLatch;", "serviceStreamTask", "sleep", "duration", "", "unit", "Ljava/util/concurrent/TimeUnit;", "mockwebserver"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class MockDuplexResponseBody implements DuplexResponseBody {

    @NotNull
    private final LinkedBlockingQueue<Function4<RecordedRequest, BufferedSource, BufferedSink, Http2Stream, Unit>> actions = new LinkedBlockingQueue<>();

    @NotNull
    private final LinkedBlockingQueue<FutureTask<Void>> results = new LinkedBlockingQueue<>();

    public static /* synthetic */ MockDuplexResponseBody sendResponse$default(MockDuplexResponseBody mockDuplexResponseBody, String str, CountDownLatch countDownLatch, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            countDownLatch = new CountDownLatch(0);
        }
        return mockDuplexResponseBody.sendResponse(str, countDownLatch);
    }

    private final FutureTask<Void> serviceStreamTask(final RecordedRequest request, final Http2Stream http2Stream) {
        return new FutureTask<>(new Callable() { // from class: okhttp3.mockwebserver.internal.duplex.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void serviceStreamTask$lambda$9;
                serviceStreamTask$lambda$9 = MockDuplexResponseBody.serviceStreamTask$lambda$9(http2Stream, this, request);
                return serviceStreamTask$lambda$9;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void serviceStreamTask$lambda$9(Http2Stream http2Stream, MockDuplexResponseBody this$0, RecordedRequest request) {
        Intrinsics.checkNotNullParameter(http2Stream, "$http2Stream");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        BufferedSource buffer = Okio.buffer(http2Stream.getSource());
        try {
            BufferedSink buffer2 = Okio.buffer(http2Stream.getSink());
            while (true) {
                try {
                    Function4<RecordedRequest, BufferedSource, BufferedSink, Http2Stream, Unit> poll = this$0.actions.poll();
                    if (poll == null) {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(buffer2, null);
                        CloseableKt.closeFinally(buffer, null);
                        return null;
                    }
                    Intrinsics.checkNotNullExpressionValue(poll, "actions.poll() ?: break");
                    poll.invoke(request, buffer, buffer2, http2Stream);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(buffer2, th);
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(buffer, th3);
                throw th4;
            }
        }
    }

    public final void awaitSuccess() {
        LinkedBlockingQueue<FutureTask<Void>> linkedBlockingQueue = this.results;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        FutureTask<Void> poll = linkedBlockingQueue.poll(5L, timeUnit);
        if (poll != null) {
            poll.get(5L, timeUnit);
            return;
        }
        throw new AssertionError("no onRequest call received");
    }

    @NotNull
    public final MockDuplexResponseBody cancelStream(@NotNull final ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.actions.add(new Function4<RecordedRequest, BufferedSource, BufferedSink, Http2Stream, Unit>() { // from class: okhttp3.mockwebserver.internal.duplex.MockDuplexResponseBody$cancelStream$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(RecordedRequest recordedRequest, BufferedSource bufferedSource, BufferedSink bufferedSink, Http2Stream http2Stream) {
                invoke2(recordedRequest, bufferedSource, bufferedSink, http2Stream);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RecordedRequest recordedRequest, @NotNull BufferedSource bufferedSource, @NotNull BufferedSink bufferedSink, @NotNull Http2Stream stream) {
                Intrinsics.checkNotNullParameter(recordedRequest, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(bufferedSource, "<anonymous parameter 1>");
                Intrinsics.checkNotNullParameter(bufferedSink, "<anonymous parameter 2>");
                Intrinsics.checkNotNullParameter(stream, "stream");
                stream.closeLater(errorCode);
            }
        });
        return this;
    }

    @NotNull
    public final MockDuplexResponseBody exhaustRequest() {
        this.actions.add(new Function4<RecordedRequest, BufferedSource, BufferedSink, Http2Stream, Unit>() { // from class: okhttp3.mockwebserver.internal.duplex.MockDuplexResponseBody$exhaustRequest$1$1
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(RecordedRequest recordedRequest, BufferedSource bufferedSource, BufferedSink bufferedSink, Http2Stream http2Stream) {
                invoke2(recordedRequest, bufferedSource, bufferedSink, http2Stream);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RecordedRequest recordedRequest, @NotNull BufferedSource requestBody, @NotNull BufferedSink bufferedSink, @NotNull Http2Stream http2Stream) {
                Intrinsics.checkNotNullParameter(recordedRequest, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(requestBody, "requestBody");
                Intrinsics.checkNotNullParameter(bufferedSink, "<anonymous parameter 2>");
                Intrinsics.checkNotNullParameter(http2Stream, "<anonymous parameter 3>");
                ff.a.d(requestBody.exhausted());
            }
        });
        return this;
    }

    @NotNull
    public final MockDuplexResponseBody exhaustResponse() {
        this.actions.add(new Function4<RecordedRequest, BufferedSource, BufferedSink, Http2Stream, Unit>() { // from class: okhttp3.mockwebserver.internal.duplex.MockDuplexResponseBody$exhaustResponse$1$1
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(RecordedRequest recordedRequest, BufferedSource bufferedSource, BufferedSink bufferedSink, Http2Stream http2Stream) {
                invoke2(recordedRequest, bufferedSource, bufferedSink, http2Stream);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RecordedRequest recordedRequest, @NotNull BufferedSource bufferedSource, @NotNull BufferedSink responseBody, @NotNull Http2Stream http2Stream) {
                Intrinsics.checkNotNullParameter(recordedRequest, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(bufferedSource, "<anonymous parameter 1>");
                Intrinsics.checkNotNullParameter(responseBody, "responseBody");
                Intrinsics.checkNotNullParameter(http2Stream, "<anonymous parameter 3>");
                responseBody.close();
            }
        });
        return this;
    }

    @Override // okhttp3.mockwebserver.internal.duplex.DuplexResponseBody
    public void onRequest(@NotNull RecordedRequest request, @NotNull Http2Stream http2Stream) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(http2Stream, "http2Stream");
        FutureTask<Void> serviceStreamTask = serviceStreamTask(request, http2Stream);
        this.results.add(serviceStreamTask);
        serviceStreamTask.run();
    }

    @NotNull
    public final MockDuplexResponseBody receiveRequest(@NotNull final String expected) {
        Intrinsics.checkNotNullParameter(expected, "expected");
        this.actions.add(new Function4<RecordedRequest, BufferedSource, BufferedSink, Http2Stream, Unit>() { // from class: okhttp3.mockwebserver.internal.duplex.MockDuplexResponseBody$receiveRequest$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(RecordedRequest recordedRequest, BufferedSource bufferedSource, BufferedSink bufferedSink, Http2Stream http2Stream) {
                invoke2(recordedRequest, bufferedSource, bufferedSink, http2Stream);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RecordedRequest recordedRequest, @NotNull BufferedSource requestBody, @NotNull BufferedSink bufferedSink, @NotNull Http2Stream http2Stream) {
                Intrinsics.checkNotNullParameter(recordedRequest, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(requestBody, "requestBody");
                Intrinsics.checkNotNullParameter(bufferedSink, "<anonymous parameter 2>");
                Intrinsics.checkNotNullParameter(http2Stream, "<anonymous parameter 3>");
                String str = expected;
                ff.a.a(str, requestBody.readUtf8(Utf8.size$default(str, 0, 0, 3, null)));
            }
        });
        return this;
    }

    @NotNull
    public final MockDuplexResponseBody requestIOException() {
        this.actions.add(new Function4<RecordedRequest, BufferedSource, BufferedSink, Http2Stream, Unit>() { // from class: okhttp3.mockwebserver.internal.duplex.MockDuplexResponseBody$requestIOException$1$1
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(RecordedRequest recordedRequest, BufferedSource bufferedSource, BufferedSink bufferedSink, Http2Stream http2Stream) {
                invoke2(recordedRequest, bufferedSource, bufferedSink, http2Stream);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RecordedRequest recordedRequest, @NotNull BufferedSource requestBody, @NotNull BufferedSink bufferedSink, @NotNull Http2Stream http2Stream) {
                Intrinsics.checkNotNullParameter(recordedRequest, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(requestBody, "requestBody");
                Intrinsics.checkNotNullParameter(bufferedSink, "<anonymous parameter 2>");
                Intrinsics.checkNotNullParameter(http2Stream, "<anonymous parameter 3>");
                try {
                    requestBody.exhausted();
                    ff.a.f();
                } catch (IOException unused) {
                }
            }
        });
        return this;
    }

    @JvmOverloads
    @NotNull
    public final MockDuplexResponseBody sendResponse(@NotNull String s10) {
        Intrinsics.checkNotNullParameter(s10, "s");
        return sendResponse$default(this, s10, null, 2, null);
    }

    @NotNull
    public final MockDuplexResponseBody sleep(final long duration, @NotNull final TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.actions.add(new Function4<RecordedRequest, BufferedSource, BufferedSink, Http2Stream, Unit>() { // from class: okhttp3.mockwebserver.internal.duplex.MockDuplexResponseBody$sleep$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(RecordedRequest recordedRequest, BufferedSource bufferedSource, BufferedSink bufferedSink, Http2Stream http2Stream) {
                invoke2(recordedRequest, bufferedSource, bufferedSink, http2Stream);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RecordedRequest recordedRequest, @NotNull BufferedSource bufferedSource, @NotNull BufferedSink bufferedSink, @NotNull Http2Stream http2Stream) {
                Intrinsics.checkNotNullParameter(recordedRequest, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(bufferedSource, "<anonymous parameter 1>");
                Intrinsics.checkNotNullParameter(bufferedSink, "<anonymous parameter 2>");
                Intrinsics.checkNotNullParameter(http2Stream, "<anonymous parameter 3>");
                Thread.sleep(unit.toMillis(duration));
            }
        });
        return this;
    }

    @JvmOverloads
    @NotNull
    public final MockDuplexResponseBody sendResponse(@NotNull final String s10, @NotNull final CountDownLatch responseSent) {
        Intrinsics.checkNotNullParameter(s10, "s");
        Intrinsics.checkNotNullParameter(responseSent, "responseSent");
        this.actions.add(new Function4<RecordedRequest, BufferedSource, BufferedSink, Http2Stream, Unit>() { // from class: okhttp3.mockwebserver.internal.duplex.MockDuplexResponseBody$sendResponse$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(RecordedRequest recordedRequest, BufferedSource bufferedSource, BufferedSink bufferedSink, Http2Stream http2Stream) {
                invoke2(recordedRequest, bufferedSource, bufferedSink, http2Stream);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RecordedRequest recordedRequest, @NotNull BufferedSource bufferedSource, @NotNull BufferedSink responseBody, @NotNull Http2Stream http2Stream) {
                Intrinsics.checkNotNullParameter(recordedRequest, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(bufferedSource, "<anonymous parameter 1>");
                Intrinsics.checkNotNullParameter(responseBody, "responseBody");
                Intrinsics.checkNotNullParameter(http2Stream, "<anonymous parameter 3>");
                responseBody.writeUtf8(s10);
                responseBody.flush();
                responseSent.countDown();
            }
        });
        return this;
    }
}
