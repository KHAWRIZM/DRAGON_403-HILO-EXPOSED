package okhttp3.mockwebserver;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Headers;
import okhttp3.WebSocketListener;
import okhttp3.internal.Internal;
import okhttp3.internal.http2.Settings;
import okhttp3.mockwebserver.internal.duplex.DuplexResponseBody;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b)\u0018\u0000 p2\u00020\u0001:\u0001pB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u000204J\u0016\u0010E\u001a\u00020\u00002\u0006\u0010G\u001a\u0002042\u0006\u0010\u000e\u001a\u00020HJ\u0016\u0010I\u001a\u00020\u00002\u0006\u0010G\u001a\u0002042\u0006\u0010\u000e\u001a\u00020HJ\u000e\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020\u0000J\u0006\u0010L\u001a\u00020\u0000J\b\u0010M\u001a\u00020\u0000H\u0016J\b\u0010N\u001a\u0004\u0018\u00010\u0004J\u000e\u0010O\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\bJ\r\u0010\u0011\u001a\u00020\u000fH\u0007¢\u0006\u0002\bQJ\u000e\u0010R\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\bJ\r\u0010\u001a\u001a\u00020\u0018H\u0007¢\u0006\u0002\bSJ\r\u00101\u001a\u00020/H\u0007¢\u0006\u0002\bTJ\r\u00106\u001a\u000204H\u0007¢\u0006\u0002\bUJ\u000e\u0010V\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\bJ\r\u0010?\u001a\u00020\u000fH\u0007¢\u0006\u0002\bWJ\u000e\u0010X\u001a\u00020\u00002\u0006\u0010G\u001a\u000204J\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u000204J\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u0010Z\u001a\u00020\u00002\u0006\u0010[\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\bJ\u0016\u0010\\\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u0002042\u0006\u0010]\u001a\u00020\u0018J\u0016\u0010\\\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\u0018J\u0016\u0010^\u001a\u00020\u00002\u0006\u0010G\u001a\u0002042\u0006\u0010\u000e\u001a\u00020HJ\u000e\u0010_\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010`\u001a\u00020\u00002\u0006\u0010[\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\bJ\u000e\u0010a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010b\u001a\u00020\u00002\u0006\u0010c\u001a\u00020\u0018J\u000e\u0010d\u001a\u00020\u00002\u0006\u00100\u001a\u00020/J\u000e\u0010e\u001a\u00020\u00002\u0006\u00105\u001a\u000204J\u000e\u0010f\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u000fJ\u001e\u0010g\u001a\u00020\u00002\u0006\u0010h\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\bJ\b\u0010j\u001a\u000204H\u0016J\u000e\u0010k\u001a\u00020\u00002\u0006\u0010l\u001a\u00020(J\u000e\u0010m\u001a\u00020\u00002\u0006\u0010,\u001a\u00020+J\u000e\u0010n\u001a\u00020\u00002\u0006\u0010o\u001a\u00020AR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8F@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0010\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u0018@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u0019\u0010\u001cR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00000\u001eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b#\u0010%R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u001e8F¢\u0006\u0006\u001a\u0004\b*\u0010 R\u001e\u0010,\u001a\u00020+2\u0006\u0010\t\u001a\u00020+@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R$\u00100\u001a\u00020/2\u0006\u0010\t\u001a\u00020/@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b0\u00103R$\u00105\u001a\u0002042\u0006\u0010\t\u001a\u000204@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b5\u00108R\u001e\u00109\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010>\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8F@GX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u0010\u0012\"\u0004\b>\u0010\u0013R\u000e\u0010@\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010B\u001a\u0004\u0018\u00010A2\b\u0010\t\u001a\u0004\u0018\u00010A@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010D¨\u0006q"}, d2 = {"Lokhttp3/mockwebserver/MockResponse;", "", "()V", "body", "Lokio/Buffer;", "bodyDelayAmount", "", "bodyDelayUnit", "Ljava/util/concurrent/TimeUnit;", "<set-?>", "Lokhttp3/mockwebserver/internal/duplex/DuplexResponseBody;", "duplexResponseBody", "getDuplexResponseBody", "()Lokhttp3/mockwebserver/internal/duplex/DuplexResponseBody;", "value", "Lokhttp3/Headers;", "headers", "getHeaders", "()Lokhttp3/Headers;", "(Lokhttp3/Headers;)V", "headersBuilder", "Lokhttp3/Headers$Builder;", "headersDelayAmount", "headersDelayUnit", "", "http2ErrorCode", "getHttp2ErrorCode", "()I", "(I)V", "informationalResponses", "", "getInformationalResponses$mockwebserver", "()Ljava/util/List;", "setInformationalResponses$mockwebserver", "(Ljava/util/List;)V", "isDuplex", "", "()Z", "promises", "", "Lokhttp3/mockwebserver/PushPromise;", "pushPromises", "getPushPromises", "Lokhttp3/internal/http2/Settings;", "settings", "getSettings", "()Lokhttp3/internal/http2/Settings;", "Lokhttp3/mockwebserver/SocketPolicy;", "socketPolicy", "getSocketPolicy", "()Lokhttp3/mockwebserver/SocketPolicy;", "(Lokhttp3/mockwebserver/SocketPolicy;)V", "", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "getStatus", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "throttleBytesPerPeriod", "getThrottleBytesPerPeriod", "()J", "throttlePeriodAmount", "throttlePeriodUnit", "trailers", "getTrailers", "trailersBuilder", "Lokhttp3/WebSocketListener;", "webSocketListener", "getWebSocketListener", "()Lokhttp3/WebSocketListener;", "addHeader", "header", "name", "", "addHeaderLenient", "addInformationalResponse", "informationalResponse", "clearHeaders", "clone", "getBody", "getBodyDelay", "unit", "-deprecated_getHeaders", "getHeadersDelay", "-deprecated_getHttp2ErrorCode", "-deprecated_getSocketPolicy", "-deprecated_getStatus", "getThrottlePeriod", "-deprecated_getTrailers", "removeHeader", "setBody", "setBodyDelay", "delay", "setChunkedBody", "maxChunkSize", "setHeader", "setHeaders", "setHeadersDelay", "setHttp2ErrorCode", "setResponseCode", "code", "setSocketPolicy", "setStatus", "setTrailers", "throttleBody", "bytesPerPeriod", "period", "toString", "withPush", "promise", "withSettings", "withWebSocketUpgrade", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Companion", "mockwebserver"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMockResponse.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MockResponse.kt\nokhttp3/mockwebserver/MockResponse\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,360:1\n1#2:361\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class MockResponse implements Cloneable {

    @NotNull
    private static final String CHUNKED_BODY_HEADER = "Transfer-encoding: chunked";

    @Nullable
    private Buffer body;
    private long bodyDelayAmount;

    @NotNull
    private TimeUnit bodyDelayUnit;

    @Nullable
    private DuplexResponseBody duplexResponseBody;
    private long headersDelayAmount;

    @NotNull
    private TimeUnit headersDelayUnit;

    @NotNull
    private List<PushPromise> promises;

    @NotNull
    private Settings settings;

    @Nullable
    private WebSocketListener webSocketListener;

    @NotNull
    private String status = "";

    @NotNull
    private List<MockResponse> informationalResponses = CollectionsKt.emptyList();

    @NotNull
    private Headers.Builder headersBuilder = new Headers.Builder();

    @NotNull
    private Headers.Builder trailersBuilder = new Headers.Builder();
    private long throttleBytesPerPeriod = LongCompanionObject.MAX_VALUE;
    private long throttlePeriodAmount = 1;

    @NotNull
    private TimeUnit throttlePeriodUnit = TimeUnit.SECONDS;

    @NotNull
    private SocketPolicy socketPolicy = SocketPolicy.KEEP_OPEN;
    private int http2ErrorCode = -1;

    public MockResponse() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.bodyDelayUnit = timeUnit;
        this.headersDelayUnit = timeUnit;
        this.promises = new ArrayList();
        this.settings = new Settings();
        setResponseCode(200);
        setHeader("Content-Length", 0L);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @ReplaceWith(expression = "headers", imports = {}))
    @JvmName(name = "-deprecated_getHeaders")
    @NotNull
    /* renamed from: -deprecated_getHeaders, reason: not valid java name */
    public final Headers m٢١٩٥deprecated_getHeaders() {
        return getHeaders();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @ReplaceWith(expression = "http2ErrorCode", imports = {}))
    @JvmName(name = "-deprecated_getHttp2ErrorCode")
    /* renamed from: -deprecated_getHttp2ErrorCode, reason: not valid java name and from getter */
    public final int getHttp2ErrorCode() {
        return this.http2ErrorCode;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @ReplaceWith(expression = "socketPolicy", imports = {}))
    @JvmName(name = "-deprecated_getSocketPolicy")
    @NotNull
    /* renamed from: -deprecated_getSocketPolicy, reason: not valid java name and from getter */
    public final SocketPolicy getSocketPolicy() {
        return this.socketPolicy;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @ReplaceWith(expression = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, imports = {}))
    @JvmName(name = "-deprecated_getStatus")
    @NotNull
    /* renamed from: -deprecated_getStatus, reason: not valid java name and from getter */
    public final String getStatus() {
        return this.status;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @ReplaceWith(expression = "trailers", imports = {}))
    @JvmName(name = "-deprecated_getTrailers")
    @NotNull
    /* renamed from: -deprecated_getTrailers, reason: not valid java name */
    public final Headers m٢١٩٩deprecated_getTrailers() {
        return getTrailers();
    }

    @NotNull
    public final MockResponse addHeader(@NotNull String header) {
        Intrinsics.checkNotNullParameter(header, "header");
        this.headersBuilder.add(header);
        return this;
    }

    @NotNull
    public final MockResponse addHeaderLenient(@NotNull String name, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Internal.addHeaderLenient(this.headersBuilder, name, value.toString());
        return this;
    }

    @NotNull
    public final MockResponse addInformationalResponse(@NotNull MockResponse informationalResponse) {
        Intrinsics.checkNotNullParameter(informationalResponse, "informationalResponse");
        this.informationalResponses = CollectionsKt.plus((Collection<? extends MockResponse>) this.informationalResponses, informationalResponse);
        return this;
    }

    @NotNull
    public final MockResponse clearHeaders() {
        this.headersBuilder = new Headers.Builder();
        return this;
    }

    @Nullable
    public final Buffer getBody() {
        Buffer buffer = this.body;
        if (buffer != null) {
            return buffer.clone();
        }
        return null;
    }

    public final long getBodyDelay(@NotNull TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return unit.convert(this.bodyDelayAmount, this.bodyDelayUnit);
    }

    @Nullable
    public final DuplexResponseBody getDuplexResponseBody() {
        return this.duplexResponseBody;
    }

    @NotNull
    public final Headers getHeaders() {
        return this.headersBuilder.build();
    }

    public final long getHeadersDelay(@NotNull TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return unit.convert(this.headersDelayAmount, this.headersDelayUnit);
    }

    public final int getHttp2ErrorCode() {
        return this.http2ErrorCode;
    }

    @NotNull
    public final List<MockResponse> getInformationalResponses$mockwebserver() {
        return this.informationalResponses;
    }

    @NotNull
    public final List<PushPromise> getPushPromises() {
        return this.promises;
    }

    @NotNull
    public final Settings getSettings() {
        return this.settings;
    }

    @NotNull
    public final SocketPolicy getSocketPolicy() {
        return this.socketPolicy;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    public final long getThrottleBytesPerPeriod() {
        return this.throttleBytesPerPeriod;
    }

    public final long getThrottlePeriod(@NotNull TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return unit.convert(this.throttlePeriodAmount, this.throttlePeriodUnit);
    }

    @NotNull
    public final Headers getTrailers() {
        return this.trailersBuilder.build();
    }

    @Nullable
    public final WebSocketListener getWebSocketListener() {
        return this.webSocketListener;
    }

    @JvmName(name = "headers")
    public final void headers(@NotNull Headers value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.headersBuilder = value.newBuilder();
    }

    @JvmName(name = "http2ErrorCode")
    public final void http2ErrorCode(int i10) {
        this.http2ErrorCode = i10;
    }

    public final boolean isDuplex() {
        if (this.duplexResponseBody != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public final MockResponse removeHeader(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.headersBuilder.removeAll(name);
        return this;
    }

    @NotNull
    public final MockResponse setBody(@NotNull Buffer body) {
        Intrinsics.checkNotNullParameter(body, "body");
        setHeader("Content-Length", Long.valueOf(body.size()));
        this.body = body.clone();
        return this;
    }

    @NotNull
    public final MockResponse setBodyDelay(long delay, @NotNull TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.bodyDelayAmount = delay;
        this.bodyDelayUnit = unit;
        return this;
    }

    @NotNull
    public final MockResponse setChunkedBody(@NotNull Buffer body, int maxChunkSize) {
        Intrinsics.checkNotNullParameter(body, "body");
        removeHeader("Content-Length");
        this.headersBuilder.add(CHUNKED_BODY_HEADER);
        Buffer buffer = new Buffer();
        while (!body.exhausted()) {
            long min = Math.min(body.size(), maxChunkSize);
            buffer.writeHexadecimalUnsignedLong(min);
            buffer.writeUtf8("\r\n");
            buffer.write(body, min);
            buffer.writeUtf8("\r\n");
        }
        buffer.writeUtf8("0\r\n");
        this.body = buffer;
        return this;
    }

    @NotNull
    public final MockResponse setHeader(@NotNull String name, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        removeHeader(name);
        addHeader(name, value);
        return this;
    }

    @NotNull
    public final MockResponse setHeaders(@NotNull Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        headers(headers);
        return this;
    }

    @NotNull
    public final MockResponse setHeadersDelay(long delay, @NotNull TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.headersDelayAmount = delay;
        this.headersDelayUnit = unit;
        return this;
    }

    @NotNull
    public final MockResponse setHttp2ErrorCode(int http2ErrorCode) {
        this.http2ErrorCode = http2ErrorCode;
        return this;
    }

    public final void setInformationalResponses$mockwebserver(@NotNull List<MockResponse> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.informationalResponses = list;
    }

    @NotNull
    public final MockResponse setResponseCode(int code) {
        String str;
        if (100 <= code && code < 200) {
            str = "Informational";
        } else if (200 <= code && code < 300) {
            str = "OK";
        } else if (300 <= code && code < 400) {
            str = "Redirection";
        } else if (400 <= code && code < 500) {
            str = "Client Error";
        } else if (500 <= code && code < 600) {
            str = "Server Error";
        } else {
            str = "Mock Response";
        }
        this.status = "HTTP/1.1 " + code + ' ' + str;
        return this;
    }

    @NotNull
    public final MockResponse setSocketPolicy(@NotNull SocketPolicy socketPolicy) {
        Intrinsics.checkNotNullParameter(socketPolicy, "socketPolicy");
        this.socketPolicy = socketPolicy;
        return this;
    }

    @NotNull
    public final MockResponse setStatus(@NotNull String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.status = status;
        return this;
    }

    @NotNull
    public final MockResponse setTrailers(@NotNull Headers trailers) {
        Intrinsics.checkNotNullParameter(trailers, "trailers");
        trailers(trailers);
        return this;
    }

    @JvmName(name = "socketPolicy")
    public final void socketPolicy(@NotNull SocketPolicy socketPolicy) {
        Intrinsics.checkNotNullParameter(socketPolicy, "<set-?>");
        this.socketPolicy = socketPolicy;
    }

    @JvmName(name = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)
    public final void status(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }

    @NotNull
    public final MockResponse throttleBody(long bytesPerPeriod, long period, @NotNull TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.throttleBytesPerPeriod = bytesPerPeriod;
        this.throttlePeriodAmount = period;
        this.throttlePeriodUnit = unit;
        return this;
    }

    @NotNull
    public String toString() {
        return this.status;
    }

    @JvmName(name = "trailers")
    public final void trailers(@NotNull Headers value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.trailersBuilder = value.newBuilder();
    }

    @NotNull
    public final MockResponse withPush(@NotNull PushPromise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.promises.add(promise);
        return this;
    }

    @NotNull
    public final MockResponse withSettings(@NotNull Settings settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.settings = settings;
        return this;
    }

    @NotNull
    public final MockResponse withWebSocketUpgrade(@NotNull WebSocketListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.status = "HTTP/1.1 101 Switching Protocols";
        setHeader(com.amazonaws.services.s3.Headers.CONNECTION, "Upgrade");
        setHeader("Upgrade", "websocket");
        this.body = null;
        this.webSocketListener = listener;
        return this;
    }

    @NotNull
    public final MockResponse addHeader(@NotNull String name, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.headersBuilder.add(name, value.toString());
        return this;
    }

    @NotNull
    public MockResponse clone() {
        Object clone = super.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type okhttp3.mockwebserver.MockResponse");
        MockResponse mockResponse = (MockResponse) clone;
        mockResponse.headersBuilder = this.headersBuilder.build().newBuilder();
        mockResponse.promises = CollectionsKt.toMutableList((Collection) this.promises);
        return mockResponse;
    }

    @NotNull
    public final MockResponse setBody(@NotNull String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return setBody(new Buffer().writeUtf8(body));
    }

    @NotNull
    public final MockResponse setBody(@NotNull DuplexResponseBody duplexResponseBody) {
        Intrinsics.checkNotNullParameter(duplexResponseBody, "duplexResponseBody");
        this.duplexResponseBody = duplexResponseBody;
        return this;
    }

    @NotNull
    public final MockResponse setChunkedBody(@NotNull String body, int maxChunkSize) {
        Intrinsics.checkNotNullParameter(body, "body");
        return setChunkedBody(new Buffer().writeUtf8(body), maxChunkSize);
    }
}
