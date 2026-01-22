package okhttp3.internal.http;

import com.taobao.accs.common.Constants;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http2.ConnectionShutdownException;
import okio.BufferedSink;
import okio.Okio;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "forWebSocket", "", "(Z)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "shouldIgnoreAndWaitForRealResponse", Constants.KEY_HTTP_CODE, "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    private final boolean shouldIgnoreAndWaitForRealResponse(int code) {
        if (code == 100) {
            return true;
        }
        return 102 <= code && code < 200;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e4 A[Catch: IOException -> 0x00b7, TryCatch #2 {IOException -> 0x00b7, blocks: (B:64:0x00a9, B:66:0x00b2, B:22:0x00ba, B:24:0x00e4, B:26:0x00ed, B:27:0x00f0, B:28:0x0114, B:32:0x011f, B:33:0x013e, B:35:0x014c, B:43:0x0162, B:45:0x0168, B:48:0x0175, B:50:0x018f, B:51:0x0197, B:52:0x01a1, B:61:0x0157, B:62:0x012e), top: B:63:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0168 A[Catch: IOException -> 0x00b7, TryCatch #2 {IOException -> 0x00b7, blocks: (B:64:0x00a9, B:66:0x00b2, B:22:0x00ba, B:24:0x00e4, B:26:0x00ed, B:27:0x00f0, B:28:0x0114, B:32:0x011f, B:33:0x013e, B:35:0x014c, B:43:0x0162, B:45:0x0168, B:48:0x0175, B:50:0x018f, B:51:0x0197, B:52:0x01a1, B:61:0x0157, B:62:0x012e), top: B:63:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0175 A[Catch: IOException -> 0x00b7, TryCatch #2 {IOException -> 0x00b7, blocks: (B:64:0x00a9, B:66:0x00b2, B:22:0x00ba, B:24:0x00e4, B:26:0x00ed, B:27:0x00f0, B:28:0x0114, B:32:0x011f, B:33:0x013e, B:35:0x014c, B:43:0x0162, B:45:0x0168, B:48:0x0175, B:50:0x018f, B:51:0x0197, B:52:0x01a1, B:61:0x0157, B:62:0x012e), top: B:63:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ab  */
    /* JADX WARN: Type inference failed for: r9v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    @Override // okhttp3.Interceptor
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        Response.Builder builder;
        boolean z;
        Response.Builder builder2;
        Response.Builder builder3;
        Response build;
        int code;
        Response build2;
        ResponseBody body;
        long j;
        Response.Builder builder4;
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Exchange exchange = realInterceptorChain.getExchange();
        Intrinsics.checkNotNull(exchange);
        Request request = realInterceptorChain.getRequest();
        RequestBody body2 = request.body();
        long currentTimeMillis = System.currentTimeMillis();
        Long l = null;
        try {
            exchange.writeRequestHeaders(request);
            ?? permitsRequestBody = HttpMethod.permitsRequestBody(request.method());
            try {
                if (permitsRequestBody != 0 && body2 != null) {
                    if (StringsKt.equals("100-continue", request.header("Expect"), true)) {
                        exchange.flushRequest();
                        builder = exchange.readResponseHeaders(true);
                        try {
                            exchange.responseHeadersStart();
                            z = false;
                            builder4 = builder;
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            builder2 = builder;
                            if (e instanceof ConnectionShutdownException) {
                            }
                        }
                    } else {
                        builder4 = null;
                        z = true;
                    }
                    if (builder4 == null) {
                        if (body2.isDuplex()) {
                            exchange.flushRequest();
                            body2.writeTo(Okio.buffer(exchange.createRequestBody(request, true)));
                            permitsRequestBody = builder4;
                        } else {
                            BufferedSink buffer = Okio.buffer(exchange.createRequestBody(request, false));
                            body2.writeTo(buffer);
                            buffer.close();
                            permitsRequestBody = builder4;
                        }
                    } else {
                        exchange.noRequestBody();
                        permitsRequestBody = builder4;
                        if (!exchange.getConnection().isMultiplexed$okhttp()) {
                            exchange.noNewExchangesOnConnection();
                            permitsRequestBody = builder4;
                        }
                    }
                } else {
                    exchange.noRequestBody();
                    permitsRequestBody = 0;
                    z = true;
                }
                if (body2 == null || !body2.isDuplex()) {
                    exchange.finishRequest();
                }
                e = null;
                builder3 = permitsRequestBody;
            } catch (IOException e2) {
                e = e2;
                builder2 = permitsRequestBody;
                if (e instanceof ConnectionShutdownException) {
                    builder3 = builder2;
                    if (!exchange.getHasFailure()) {
                        throw e;
                    }
                    if (builder3 == null) {
                    }
                    build = builder3.request(request).handshake(exchange.getConnection().getHandshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
                    code = build.code();
                    if (shouldIgnoreAndWaitForRealResponse(code)) {
                    }
                    exchange.responseHeadersEnd(build);
                    if (!this.forWebSocket) {
                    }
                    build2 = build.newBuilder().body(exchange.openResponseBody(build)).build();
                    if (!StringsKt.equals("close", build2.request().header("Connection"), true)) {
                    }
                    exchange.noNewExchangesOnConnection();
                    if (code != 204) {
                    }
                    body = build2.body();
                    if (body == null) {
                    }
                    if (j > 0) {
                    }
                    return build2;
                }
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            builder = null;
        }
        if (builder3 == null) {
            try {
                builder3 = exchange.readResponseHeaders(false);
                Intrinsics.checkNotNull(builder3);
                if (z) {
                    exchange.responseHeadersStart();
                    z = false;
                }
            } catch (IOException e4) {
                if (e != null) {
                    ExceptionsKt.addSuppressed(e, e4);
                    throw e;
                }
                throw e4;
            }
        }
        build = builder3.request(request).handshake(exchange.getConnection().getHandshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        code = build.code();
        if (shouldIgnoreAndWaitForRealResponse(code)) {
            Response.Builder readResponseHeaders = exchange.readResponseHeaders(false);
            Intrinsics.checkNotNull(readResponseHeaders);
            if (z) {
                exchange.responseHeadersStart();
            }
            build = readResponseHeaders.request(request).handshake(exchange.getConnection().getHandshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            code = build.code();
        }
        exchange.responseHeadersEnd(build);
        if (!this.forWebSocket && code == 101) {
            build2 = build.newBuilder().body(Util.EMPTY_RESPONSE).build();
        } else {
            build2 = build.newBuilder().body(exchange.openResponseBody(build)).build();
        }
        if (!StringsKt.equals("close", build2.request().header("Connection"), true) || StringsKt.equals("close", Response.header$default(build2, "Connection", null, 2, null), true)) {
            exchange.noNewExchangesOnConnection();
        }
        if (code != 204 || code == 205) {
            body = build2.body();
            if (body == null) {
                j = body.getContentLength();
            } else {
                j = -1;
            }
            if (j > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("HTTP ");
                sb2.append(code);
                sb2.append(" had non-zero Content-Length: ");
                ResponseBody body3 = build2.body();
                if (body3 != null) {
                    l = Long.valueOf(body3.getContentLength());
                }
                sb2.append(l);
                throw new ProtocolException(sb2.toString());
            }
        }
        return build2;
    }
}
