package okhttp3.mockwebserver;

import anet.channel.util.HttpConstant;
import com.google.android.gms.appinvite.PreviewActivity;
import com.qiahao.base_common.network.ServerConfigureKt;
import gf.a;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocketListener;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.duplex.MwsDuplexAccess;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Header;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.internal.ws.WebSocketExtensions;
import okhttp3.internal.ws.WebSocketProtocol;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.internal.duplex.DuplexResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Sink;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u009f\u00012\u00020\u00012\u00020\u0002:\b\u009f\u0001 \u0001¡\u0001¢\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ7\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J'\u0010!\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J?\u0010/\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010,\u001a\u00020'2\u0006\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0007H\u0014¢\u0006\u0004\b3\u0010\u0004J\u000f\u00106\u001a\u00020\u0010H\u0007¢\u0006\u0004\b4\u00105J\r\u00108\u001a\u000207¢\u0006\u0004\b8\u00109J\u0017\u0010>\u001a\u00020\u00072\u0006\u0010;\u001a\u00020:H\u0007¢\u0006\u0004\b<\u0010=J\u0015\u0010B\u001a\u00020A2\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bB\u0010CJ\u0017\u0010F\u001a\u00020\u00072\u0006\u0010D\u001a\u00020'H\u0007¢\u0006\u0004\bE\u0010*J\u0017\u0010J\u001a\u00020\u00072\u0006\u0010G\u001a\u00020-H\u0007¢\u0006\u0004\bH\u0010IJ\u001d\u0010P\u001a\u00020\u00072\f\u0010M\u001a\b\u0012\u0004\u0012\u00020L0KH\u0007¢\u0006\u0004\bN\u0010OJ\u0015\u0010M\u001a\b\u0012\u0004\u0012\u00020L0KH\u0007¢\u0006\u0004\bN\u0010QJ\u001d\u0010U\u001a\u00020\u00072\u0006\u0010S\u001a\u00020R2\u0006\u0010T\u001a\u00020-¢\u0006\u0004\bU\u0010VJ\r\u0010W\u001a\u00020\u0007¢\u0006\u0004\bW\u0010\u0004J\r\u0010X\u001a\u00020\u0007¢\u0006\u0004\bX\u0010\u0004J\r\u0010Y\u001a\u00020\u0007¢\u0006\u0004\bY\u0010\u0004J\r\u0010Z\u001a\u00020\u0019¢\u0006\u0004\bZ\u0010[J\u001f\u0010Z\u001a\u0004\u0018\u00010\u00192\u0006\u0010\\\u001a\u00020'2\u0006\u0010^\u001a\u00020]¢\u0006\u0004\bZ\u0010_J\u000f\u0010a\u001a\u00020\u0010H\u0007¢\u0006\u0004\b`\u00105J\u0015\u0010b\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\bb\u0010cJ\u0019\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010d\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\b\u0010eJ\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010g\u001a\u00020f2\u0006\u0010d\u001a\u00020\u0010¢\u0006\u0004\b\b\u0010hJ\r\u0010i\u001a\u00020\u0007¢\u0006\u0004\bi\u0010\u0004J\u000f\u0010j\u001a\u00020\u0007H\u0014¢\u0006\u0004\bj\u0010\u0004J\u000f\u0010k\u001a\u00020?H\u0016¢\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00020\u0007H\u0016¢\u0006\u0004\bm\u0010\u0004R\u0014\u0010o\u001a\u00020n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010r\u001a\u00020q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u001a\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00190t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR8\u0010z\u001a&\u0012\f\u0012\n x*\u0004\u0018\u00010\u000b0\u000b x*\u0012\u0012\f\u0012\n x*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010y0w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R8\u0010}\u001a&\u0012\f\u0012\n x*\u0004\u0018\u00010|0| x*\u0012\u0012\f\u0012\n x*\u0004\u0018\u00010|0|\u0018\u00010y0w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010{R\u0015\u0010\u007f\u001a\u00020~8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R%\u0010D\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bD\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0004\bF\u0010*R2\u0010;\u001a\u0004\u0018\u00010:2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010:8F@FX\u0086\u000e¢\u0006\u0015\n\u0005\b;\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0004\b>\u0010=R\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0019\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bS\u0010\u008b\u0001R\u0017\u0010T\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bT\u0010\u008c\u0001R\u0019\u0010\u008d\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R*\u0010\u0090\u0001\u001a\u00030\u008f\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0019\u0010\u0096\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u008e\u0001R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0006\u0010\u0097\u0001R%\u0010G\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bG\u0010\u008c\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0004\bJ\u0010IR8\u0010M\u001a\b\u0012\u0004\u0012\u00020L0K2\r\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020L0K8G@FX\u0086\u000e¢\u0006\u0013\n\u0005\bM\u0010\u009a\u0001\u001a\u0004\bM\u0010Q\"\u0004\bP\u0010OR\u0019\u0010\u009b\u0001\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u008c\u0001R\u0012\u0010\u009c\u0001\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\ba\u00105R\u0011\u0010d\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b6\u00105R\u0013\u0010\u009e\u0001\u001a\u00020?8F¢\u0006\u0007\u001a\u0005\b\u009d\u0001\u0010l¨\u0006£\u0001"}, d2 = {"Lokhttp3/mockwebserver/MockWebServer;", "Lgf/a;", "Ljava/io/Closeable;", "<init>", "()V", "Ljava/net/InetSocketAddress;", "inetSocketAddress", "", "start", "(Ljava/net/InetSocketAddress;)V", "acceptConnections", "Ljava/net/Socket;", "raw", "serveConnection", "(Ljava/net/Socket;)V", "processHandshakeFailure", "", "sequenceNumber", "socket", "dispatchBookkeepingRequest", "(ILjava/net/Socket;)V", "Lokio/BufferedSource;", "source", "Lokio/BufferedSink;", "sink", "Lokhttp3/mockwebserver/RecordedRequest;", "readRequest", "(Ljava/net/Socket;Lokio/BufferedSource;Lokio/BufferedSink;I)Lokhttp3/mockwebserver/RecordedRequest;", "request", "Lokhttp3/mockwebserver/MockResponse;", "response", "handleWebSocketUpgrade", "(Ljava/net/Socket;Lokio/BufferedSource;Lokio/BufferedSink;Lokhttp3/mockwebserver/RecordedRequest;Lokhttp3/mockwebserver/MockResponse;)V", "writeHttpResponse", "(Ljava/net/Socket;Lokio/BufferedSink;Lokhttp3/mockwebserver/MockResponse;)V", "Lokhttp3/Headers;", "headers", "writeHeaders", "(Lokio/BufferedSink;Lokhttp3/Headers;)V", "", "delayMs", "sleepIfDelayed", "(J)V", "policy", "byteCount", "", "isRequest", "throttledTransfer", "(Lokhttp3/mockwebserver/MockResponse;Ljava/net/Socket;Lokio/BufferedSource;Lokio/BufferedSink;JZ)V", "readEmptyLine", "(Lokio/BufferedSource;)V", "before", "-deprecated_port", "()I", "getPort", "Ljava/net/Proxy;", "toProxyAddress", "()Ljava/net/Proxy;", "Ljavax/net/ServerSocketFactory;", "serverSocketFactory", "-deprecated_serverSocketFactory", "(Ljavax/net/ServerSocketFactory;)V", "setServerSocketFactory", "", "path", "Lokhttp3/HttpUrl;", "url", "(Ljava/lang/String;)Lokhttp3/HttpUrl;", "bodyLimit", "-deprecated_bodyLimit", "setBodyLimit", "protocolNegotiationEnabled", "-deprecated_protocolNegotiationEnabled", "(Z)V", "setProtocolNegotiationEnabled", "", "Lokhttp3/Protocol;", "protocols", "-deprecated_protocols", "(Ljava/util/List;)V", "setProtocols", "()Ljava/util/List;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "tunnelProxy", "useHttps", "(Ljavax/net/ssl/SSLSocketFactory;Z)V", "noClientAuth", "requestClientAuth", "requireClientAuth", "takeRequest", "()Lokhttp3/mockwebserver/RecordedRequest;", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "(JLjava/util/concurrent/TimeUnit;)Lokhttp3/mockwebserver/RecordedRequest;", "-deprecated_requestCount", "getRequestCount", "enqueue", "(Lokhttp3/mockwebserver/MockResponse;)V", "port", "(I)V", "Ljava/net/InetAddress;", "inetAddress", "(Ljava/net/InetAddress;I)V", "shutdown", "after", "toString", "()Ljava/lang/String;", PreviewActivity.ON_CLICK_LISTENER_CLOSE, "Lokhttp3/internal/concurrent/TaskRunner$RealBackend;", "taskRunnerBackend", "Lokhttp3/internal/concurrent/TaskRunner$RealBackend;", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "Ljava/util/concurrent/LinkedBlockingQueue;", "requestQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "", "kotlin.jvm.PlatformType", "", "openClientSockets", "Ljava/util/Set;", "Lokhttp3/internal/http2/Http2Connection;", "openConnections", "Ljava/util/concurrent/atomic/AtomicInteger;", "atomicRequestCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "J", "getBodyLimit", "()J", "value", "Ljavax/net/ServerSocketFactory;", "getServerSocketFactory", "()Ljavax/net/ServerSocketFactory;", "Ljava/net/ServerSocket;", "serverSocket", "Ljava/net/ServerSocket;", "Ljavax/net/ssl/SSLSocketFactory;", "Z", "clientAuth", "I", "Lokhttp3/mockwebserver/Dispatcher;", "dispatcher", "Lokhttp3/mockwebserver/Dispatcher;", "getDispatcher", "()Lokhttp3/mockwebserver/Dispatcher;", "setDispatcher", "(Lokhttp3/mockwebserver/Dispatcher;)V", "portField", "Ljava/net/InetSocketAddress;", "getProtocolNegotiationEnabled", "()Z", "Ljava/util/List;", "started", "requestCount", "getHostName", "hostName", "Companion", "Http2SocketHandler", "SocketHandler", "TruncatingBuffer", "mockwebserver"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMockWebServer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MockWebServer.kt\nokhttp3/mockwebserver/MockWebServer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue\n*L\n1#1,1168:1\n1#2:1169\n90#3,13:1170\n90#3,13:1183\n*S KotlinDebug\n*F\n+ 1 MockWebServer.kt\nokhttp3/mockwebserver/MockWebServer\n*L\n394#1:1170,13\n469#1:1183,13\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class MockWebServer extends a implements Closeable {
    private static final int CLIENT_AUTH_NONE = 0;
    private static final int CLIENT_AUTH_REQUESTED = 1;
    private static final int CLIENT_AUTH_REQUIRED = 2;

    @NotNull
    private static final MockWebServer$Companion$UNTRUSTED_TRUST_MANAGER$1 UNTRUSTED_TRUST_MANAGER;
    private static final Logger logger;

    @NotNull
    private final AtomicInteger atomicRequestCount;
    private long bodyLimit;
    private int clientAuth;

    @NotNull
    private Dispatcher dispatcher;

    @Nullable
    private InetSocketAddress inetSocketAddress;
    private final Set<Socket> openClientSockets;
    private final Set<Http2Connection> openConnections;
    private int portField;
    private boolean protocolNegotiationEnabled;

    @NotNull
    private List<? extends Protocol> protocols;

    @NotNull
    private final LinkedBlockingQueue<RecordedRequest> requestQueue;

    @Nullable
    private ServerSocket serverSocket;

    @Nullable
    private ServerSocketFactory serverSocketFactory;

    @Nullable
    private SSLSocketFactory sslSocketFactory;
    private boolean started;

    @NotNull
    private final TaskRunner taskRunner;

    @NotNull
    private final TaskRunner.RealBackend taskRunnerBackend;
    private boolean tunnelProxy;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J&\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lokhttp3/mockwebserver/MockWebServer$Http2SocketHandler;", "Lokhttp3/internal/http2/Http2Connection$Listener;", "socket", "Ljava/net/Socket;", "protocol", "Lokhttp3/Protocol;", "(Lokhttp3/mockwebserver/MockWebServer;Ljava/net/Socket;Lokhttp3/Protocol;)V", "sequenceNumber", "Ljava/util/concurrent/atomic/AtomicInteger;", "onStream", "", "stream", "Lokhttp3/internal/http2/Http2Stream;", "pushPromises", "request", "Lokhttp3/mockwebserver/RecordedRequest;", "promises", "", "Lokhttp3/mockwebserver/PushPromise;", "readRequest", "writeResponse", "response", "Lokhttp3/mockwebserver/MockResponse;", "mockwebserver"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nMockWebServer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MockWebServer.kt\nokhttp3/mockwebserver/MockWebServer$Http2SocketHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1168:1\n1855#2,2:1169\n*S KotlinDebug\n*F\n+ 1 MockWebServer.kt\nokhttp3/mockwebserver/MockWebServer$Http2SocketHandler\n*L\n1029#1:1169,2\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private final class Http2SocketHandler extends Http2Connection.Listener {

        @NotNull
        private final Protocol protocol;

        @NotNull
        private final AtomicInteger sequenceNumber;

        @NotNull
        private final Socket socket;
        final /* synthetic */ MockWebServer this$0;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SocketPolicy.values().length];
                try {
                    iArr[SocketPolicy.DISCONNECT_AT_END.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SocketPolicy.DO_NOT_READ_REQUEST_BODY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public Http2SocketHandler(@NotNull MockWebServer mockWebServer, @NotNull Socket socket, Protocol protocol) {
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            this.this$0 = mockWebServer;
            this.socket = socket;
            this.protocol = protocol;
            this.sequenceNumber = new AtomicInteger();
        }

        private final void pushPromises(Http2Stream stream, RecordedRequest request, List<PushPromise> promises) throws IOException {
            boolean z10;
            for (PushPromise pushPromise : promises) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Header(Header.TARGET_AUTHORITY, this.this$0.url(pushPromise.path()).host()));
                arrayList.add(new Header(Header.TARGET_METHOD, pushPromise.method()));
                arrayList.add(new Header(Header.TARGET_PATH, pushPromise.path()));
                Iterator it = pushPromise.headers().iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    arrayList.add(new Header((String) pair.component1(), (String) pair.component2()));
                }
                this.this$0.requestQueue.add(new RecordedRequest(pushPromise.method() + ' ' + pushPromise.path() + " HTTP/1.1", pushPromise.headers(), CollectionsKt.emptyList(), 0L, new Buffer(), this.sequenceNumber.getAndIncrement(), this.socket, null, 128, null));
                if (pushPromise.response().getBody() != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                writeResponse(stream.getConnection().pushStream(stream.getId(), arrayList, z10), request, pushPromise.response());
            }
        }

        private final RecordedRequest readRequest(Http2Stream stream) throws IOException {
            IOException e10;
            long j10;
            Headers takeHeaders = stream.takeHeaders();
            Headers.Builder builder = new Headers.Builder();
            Iterator it = takeHeaders.iterator();
            String str = "<:method omitted>";
            String str2 = "<:path omitted>";
            boolean z10 = true;
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                String str3 = (String) pair.component1();
                String str4 = (String) pair.component2();
                if (Intrinsics.areEqual(str3, ":method")) {
                    str = str4;
                } else if (Intrinsics.areEqual(str3, ":path")) {
                    str2 = str4;
                } else {
                    Protocol protocol = this.protocol;
                    if (protocol != Protocol.HTTP_2 && protocol != Protocol.H2_PRIOR_KNOWLEDGE) {
                        throw new IllegalStateException();
                    }
                    builder.add(str3, str4);
                }
                if (Intrinsics.areEqual(str3, "expect") && StringsKt.equals(str4, "100-continue", true)) {
                    z10 = false;
                }
            }
            Headers build = builder.build();
            MockResponse peek = this.this$0.getDispatcher().peek();
            if (!z10 && peek.getSocketPolicy() == SocketPolicy.EXPECT_CONTINUE) {
                stream.writeHeaders(CollectionsKt.listOf(new Header(Header.RESPONSE_STATUS, ByteString.INSTANCE.encodeUtf8("100 Continue"))), false, true);
                stream.getConnection().flush();
                z10 = true;
            }
            Iterator<T> it2 = peek.getInformationalResponses$mockwebserver().iterator();
            while (it2.hasNext()) {
                stream.writeHeaders(CollectionsKt.listOf(new Header(Header.RESPONSE_STATUS, StringsKt.replace$default(((MockResponse) it2.next()).getStatus(), "HTTP/1.1 ", "", false, 4, (Object) null))), false, true);
                stream.getConnection().flush();
            }
            Buffer buffer = new Buffer();
            String str5 = str + ' ' + str2 + " HTTP/1.1";
            if (z10 && !peek.isDuplex() && peek.getSocketPolicy() != SocketPolicy.DO_NOT_READ_REQUEST_BODY) {
                try {
                    String str6 = build.get("content-length");
                    if (str6 != null) {
                        j10 = Long.parseLong(str6);
                    } else {
                        j10 = LongCompanionObject.MAX_VALUE;
                    }
                    this.this$0.throttledTransfer(peek, this.socket, Okio.buffer(stream.getSource()), buffer, j10, true);
                } catch (IOException e11) {
                    e10 = e11;
                }
            }
            e10 = null;
            return new RecordedRequest(str5, build, CollectionsKt.emptyList(), buffer.size(), buffer, this.sequenceNumber.getAndIncrement(), this.socket, e10);
        }

        private final void writeResponse(Http2Stream stream, RecordedRequest request, MockResponse response) throws IOException {
            boolean z10;
            boolean z11 = false;
            stream.getConnection().setSettings(response.getSettings());
            if (response.getSocketPolicy() == SocketPolicy.NO_RESPONSE) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            List split$default = StringsKt.split$default((CharSequence) response.getStatus(), new char[]{' '}, false, 3, 2, (Object) null);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long headersDelay = response.getHeadersDelay(timeUnit);
            long bodyDelay = response.getBodyDelay(timeUnit);
            if (split$default.size() >= 2) {
                arrayList.add(new Header(Header.RESPONSE_STATUS, (String) split$default.get(1)));
                Iterator it = response.getHeaders().iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    arrayList.add(new Header((String) pair.component1(), (String) pair.component2()));
                }
                Headers trailers = response.getTrailers();
                this.this$0.sleepIfDelayed(headersDelay);
                Buffer body = response.getBody();
                if (body == null && response.getPushPromises().isEmpty() && !response.isDuplex()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (body == null || bodyDelay != 0) {
                    z11 = true;
                }
                if (z10 && trailers.size() != 0) {
                    throw new IllegalArgumentException(("unsupported: no body and non-empty trailers " + trailers).toString());
                }
                stream.writeHeaders(arrayList, z10, z11);
                if (trailers.size() > 0) {
                    stream.enqueueTrailers(trailers);
                }
                pushPromises(stream, request, response.getPushPromises());
                if (body != null) {
                    BufferedSink buffer = Okio.buffer(stream.getSink());
                    MockWebServer mockWebServer = this.this$0;
                    try {
                        mockWebServer.sleepIfDelayed(bodyDelay);
                        mockWebServer.throttledTransfer(response, this.socket, body, buffer, body.size(), false);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(buffer, null);
                        return;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(buffer, th);
                            throw th2;
                        }
                    }
                }
                if (response.isDuplex()) {
                    DuplexResponseBody duplexResponseBody = response.getDuplexResponseBody();
                    Intrinsics.checkNotNull(duplexResponseBody);
                    duplexResponseBody.onRequest(request, stream);
                    return;
                } else {
                    if (!z10) {
                        stream.close(ErrorCode.NO_ERROR, (IOException) null);
                        return;
                    }
                    return;
                }
            }
            throw new AssertionError("Unexpected status: " + response.getStatus());
        }

        public void onStream(@NotNull Http2Stream stream) throws IOException {
            Intrinsics.checkNotNullParameter(stream, "stream");
            MockResponse peek = this.this$0.getDispatcher().peek();
            if (peek.getSocketPolicy() == SocketPolicy.RESET_STREAM_AT_START) {
                this.this$0.dispatchBookkeepingRequest(this.sequenceNumber.getAndIncrement(), this.socket);
                ErrorCode fromHttp2 = ErrorCode.Companion.fromHttp2(peek.getHttp2ErrorCode());
                Intrinsics.checkNotNull(fromHttp2);
                stream.close(fromHttp2, (IOException) null);
                return;
            }
            RecordedRequest readRequest = readRequest(stream);
            this.this$0.atomicRequestCount.incrementAndGet();
            this.this$0.requestQueue.add(readRequest);
            if (readRequest.getFailure() != null) {
                return;
            }
            MockResponse dispatch = this.this$0.getDispatcher().dispatch(readRequest);
            SocketPolicy socketPolicy = dispatch.getSocketPolicy();
            if (socketPolicy == SocketPolicy.DISCONNECT_AFTER_REQUEST) {
                this.socket.close();
                return;
            }
            writeResponse(stream, readRequest, dispatch);
            if (MockWebServer.logger.isLoggable(Level.FINE)) {
                MockWebServer.logger.fine(this.this$0 + " received request: " + readRequest + " and responded: " + dispatch + " protocol is " + this.protocol);
            }
            int i10 = WhenMappings.$EnumSwitchMapping$0[socketPolicy.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    ErrorCode fromHttp22 = ErrorCode.Companion.fromHttp2(dispatch.getHttp2ErrorCode());
                    Intrinsics.checkNotNull(fromHttp22);
                    stream.close(fromHttp22, (IOException) null);
                    return;
                }
                return;
            }
            stream.getConnection().shutdown(ErrorCode.NO_ERROR);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0006\u0010\t\u001a\u00020\bJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokhttp3/mockwebserver/MockWebServer$SocketHandler;", "", "raw", "Ljava/net/Socket;", "(Lokhttp3/mockwebserver/MockWebServer;Ljava/net/Socket;)V", "sequenceNumber", "", "createTunnel", "", "handle", "processOneRequest", "", "socket", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "mockwebserver"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nMockWebServer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MockWebServer.kt\nokhttp3/mockwebserver/MockWebServer$SocketHandler\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1168:1\n1#2:1169\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public final class SocketHandler {

        @NotNull
        private final Socket raw;
        private int sequenceNumber;
        final /* synthetic */ MockWebServer this$0;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SocketPolicy.values().length];
                try {
                    iArr[SocketPolicy.DISCONNECT_AT_END.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SocketPolicy.DO_NOT_READ_REQUEST_BODY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SocketPolicy.SHUTDOWN_INPUT_AT_END.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[SocketPolicy.SHUTDOWN_OUTPUT_AT_END.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[SocketPolicy.SHUTDOWN_SERVER_AFTER_RESPONSE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public SocketHandler(@NotNull MockWebServer mockWebServer, Socket raw) {
            Intrinsics.checkNotNullParameter(raw, "raw");
            this.this$0 = mockWebServer;
            this.raw = raw;
        }

        private final void createTunnel() throws IOException, InterruptedException {
            SocketPolicy socketPolicy;
            BufferedSource buffer = Okio.buffer(Okio.source(this.raw));
            BufferedSink buffer2 = Okio.buffer(Okio.sink(this.raw));
            do {
                socketPolicy = this.this$0.getDispatcher().peek().getSocketPolicy();
                if (!processOneRequest(this.raw, buffer, buffer2)) {
                    throw new IllegalStateException("Tunnel without any CONNECT!");
                }
            } while (socketPolicy != SocketPolicy.UPGRADE_TO_SSL_AT_END);
        }

        private final boolean processOneRequest(Socket socket, BufferedSource source, BufferedSink sink) throws IOException, InterruptedException {
            boolean z10;
            boolean z11;
            boolean z12;
            if (!source.exhausted()) {
                RecordedRequest readRequest = this.this$0.readRequest(socket, source, sink, this.sequenceNumber);
                this.this$0.atomicRequestCount.incrementAndGet();
                this.this$0.requestQueue.add(readRequest);
                if (readRequest.getFailure() != null) {
                    return false;
                }
                MockResponse dispatch = this.this$0.getDispatcher().dispatch(readRequest);
                if (dispatch.getSocketPolicy() == SocketPolicy.DISCONNECT_AFTER_REQUEST) {
                    socket.close();
                    return false;
                }
                if (dispatch.getSocketPolicy() == SocketPolicy.NO_RESPONSE) {
                    if (source.exhausted()) {
                        return false;
                    }
                    throw new ProtocolException("unexpected data");
                }
                if (StringsKt.equals("Upgrade", readRequest.getHeader(com.amazonaws.services.s3.Headers.CONNECTION), true) && StringsKt.equals("websocket", readRequest.getHeader("Upgrade"), true)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (dispatch.getWebSocketListener() != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z10 || !z11) {
                    this.this$0.writeHttpResponse(socket, sink, dispatch);
                    z12 = true;
                } else {
                    this.this$0.handleWebSocketUpgrade(socket, source, sink, readRequest, dispatch);
                    z12 = false;
                }
                if (MockWebServer.logger.isLoggable(Level.FINE)) {
                    MockWebServer.logger.fine(this.this$0 + " received request: " + readRequest + " and responded: " + dispatch);
                }
                int i10 = WhenMappings.$EnumSwitchMapping$0[dispatch.getSocketPolicy().ordinal()];
                if (i10 != 1 && i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 == 5) {
                                this.this$0.shutdown();
                            }
                        } else {
                            socket.shutdownOutput();
                        }
                    } else {
                        socket.shutdownInput();
                    }
                    this.sequenceNumber++;
                    return z12;
                }
                socket.close();
                return false;
            }
            return false;
        }

        public final void handle() throws Exception {
            Protocol protocol;
            Socket socket;
            SocketPolicy socketPolicy = this.this$0.getDispatcher().peek().getSocketPolicy();
            Protocol protocol2 = Protocol.HTTP_1_1;
            if (this.this$0.sslSocketFactory != null) {
                if (this.this$0.tunnelProxy) {
                    createTunnel();
                }
                if (socketPolicy == SocketPolicy.FAIL_HANDSHAKE) {
                    this.this$0.dispatchBookkeepingRequest(this.sequenceNumber, this.raw);
                    this.this$0.processHandshakeFailure(this.raw);
                    return;
                }
                SSLSocketFactory sSLSocketFactory = this.this$0.sslSocketFactory;
                Intrinsics.checkNotNull(sSLSocketFactory);
                Socket socket2 = this.raw;
                socket = sSLSocketFactory.createSocket(socket2, socket2.getInetAddress().getHostAddress(), this.raw.getPort(), true);
                Intrinsics.checkNotNullExpressionValue(socket, "sslSocketFactory!!.creat…          raw.port, true)");
                SSLSocket sSLSocket = (SSLSocket) socket;
                sSLSocket.setUseClientMode(false);
                if (this.this$0.clientAuth == 2) {
                    sSLSocket.setNeedClientAuth(true);
                } else if (this.this$0.clientAuth == 1) {
                    sSLSocket.setWantClientAuth(true);
                }
                this.this$0.openClientSockets.add(socket);
                if (this.this$0.getProtocolNegotiationEnabled()) {
                    Platform.Companion.get().configureTlsExtensions(sSLSocket, (String) null, this.this$0.protocols());
                }
                sSLSocket.startHandshake();
                if (this.this$0.getProtocolNegotiationEnabled()) {
                    Platform.Companion companion = Platform.Companion;
                    String selectedProtocol = companion.get().getSelectedProtocol(sSLSocket);
                    if (selectedProtocol != null) {
                        protocol = Protocol.Companion.get(selectedProtocol);
                    } else {
                        protocol = protocol2;
                    }
                    companion.get().afterHandshake(sSLSocket);
                } else {
                    protocol = protocol2;
                }
                this.this$0.openClientSockets.remove(this.raw);
            } else {
                List<Protocol> protocols = this.this$0.protocols();
                protocol = Protocol.H2_PRIOR_KNOWLEDGE;
                if (protocols.contains(protocol)) {
                    socket = this.raw;
                } else {
                    socket = this.raw;
                    protocol = protocol2;
                }
            }
            if (socketPolicy == SocketPolicy.STALL_SOCKET_AT_START) {
                this.this$0.dispatchBookkeepingRequest(this.sequenceNumber, socket);
                return;
            }
            if (protocol != Protocol.HTTP_2 && protocol != Protocol.H2_PRIOR_KNOWLEDGE) {
                if (protocol == protocol2) {
                    do {
                    } while (processOneRequest(socket, Okio.buffer(Okio.source(socket)), Okio.buffer(Okio.sink(socket))));
                    if (this.sequenceNumber == 0) {
                        MockWebServer.logger.warning(this.this$0 + " connection from " + this.raw.getInetAddress() + " didn't make a request");
                    }
                    socket.close();
                    this.this$0.openClientSockets.remove(socket);
                    return;
                }
                throw new AssertionError();
            }
            Http2Connection build = Http2Connection.Builder.socket$default(new Http2Connection.Builder(false, this.this$0.taskRunner), socket, (String) null, (BufferedSource) null, (BufferedSink) null, 14, (Object) null).listener(new Http2SocketHandler(this.this$0, socket, protocol)).build();
            Http2Connection.start$default(build, false, this.this$0.taskRunner, 1, (Object) null);
            this.this$0.openConnections.add(build);
            this.this$0.openClientSockets.remove(socket);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0003H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lokhttp3/mockwebserver/MockWebServer$TruncatingBuffer;", "Lokio/Sink;", "remainingByteCount", "", "(J)V", "buffer", "Lokio/Buffer;", "getBuffer$mockwebserver", "()Lokio/Buffer;", "receivedByteCount", "getReceivedByteCount$mockwebserver", "()J", "setReceivedByteCount$mockwebserver", PreviewActivity.ON_CLICK_LISTENER_CLOSE, "", "flush", "timeout", "Lokio/Timeout;", "write", "source", "byteCount", "mockwebserver"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class TruncatingBuffer implements Sink {

        @NotNull
        private final Buffer buffer = new Buffer();
        private long receivedByteCount;
        private long remainingByteCount;

        public TruncatingBuffer(long j10) {
            this.remainingByteCount = j10;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
        }

        @NotNull
        /* renamed from: getBuffer$mockwebserver, reason: from getter */
        public final Buffer getBuffer() {
            return this.buffer;
        }

        /* renamed from: getReceivedByteCount$mockwebserver, reason: from getter */
        public final long getReceivedByteCount() {
            return this.receivedByteCount;
        }

        public final void setReceivedByteCount$mockwebserver(long j10) {
            this.receivedByteCount = j10;
        }

        @Override // okio.Sink
        @NotNull
        /* renamed from: timeout */
        public Timeout getTimeout() {
            return Timeout.NONE;
        }

        @Override // okio.Sink
        public void write(@NotNull Buffer source, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            long min = Math.min(this.remainingByteCount, byteCount);
            if (min > 0) {
                source.read(this.buffer, min);
            }
            long j10 = byteCount - min;
            if (j10 > 0) {
                source.skip(j10);
            }
            this.remainingByteCount -= min;
            this.receivedByteCount += byteCount;
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [okhttp3.mockwebserver.MockWebServer$Companion$UNTRUSTED_TRUST_MANAGER$1] */
    static {
        MwsDuplexAccess.Companion companion = MwsDuplexAccess.Companion;
        MwsDuplexAccess.instance = new MwsDuplexAccess() { // from class: okhttp3.mockwebserver.MockWebServer.Companion.1
            public void setBody(@NotNull MockResponse mockResponse, @NotNull DuplexResponseBody duplexResponseBody) {
                Intrinsics.checkNotNullParameter(mockResponse, "mockResponse");
                Intrinsics.checkNotNullParameter(duplexResponseBody, "duplexResponseBody");
                mockResponse.setBody(duplexResponseBody);
            }
        };
        UNTRUSTED_TRUST_MANAGER = new X509TrustManager() { // from class: okhttp3.mockwebserver.MockWebServer$Companion$UNTRUSTED_TRUST_MANAGER$1
            @Override // javax.net.ssl.X509TrustManager
            @NotNull
            public X509Certificate[] getAcceptedIssuers() {
                throw new AssertionError();
            }

            @Override // javax.net.ssl.X509TrustManager
            @NotNull
            public Void checkClientTrusted(@NotNull X509Certificate[] chain, @NotNull String authType) throws CertificateException {
                Intrinsics.checkNotNullParameter(chain, "chain");
                Intrinsics.checkNotNullParameter(authType, "authType");
                throw new CertificateException();
            }

            @Override // javax.net.ssl.X509TrustManager
            @NotNull
            public Void checkServerTrusted(@NotNull X509Certificate[] chain, @NotNull String authType) {
                Intrinsics.checkNotNullParameter(chain, "chain");
                Intrinsics.checkNotNullParameter(authType, "authType");
                throw new AssertionError();
            }
        };
        logger = Logger.getLogger(MockWebServer.class.getName());
    }

    public MockWebServer() {
        TaskRunner.RealBackend realBackend = new TaskRunner.RealBackend(Util.threadFactory("MockWebServer TaskRunner", false));
        this.taskRunnerBackend = realBackend;
        this.taskRunner = new TaskRunner(realBackend);
        this.requestQueue = new LinkedBlockingQueue<>();
        this.openClientSockets = Collections.newSetFromMap(new ConcurrentHashMap());
        this.openConnections = Collections.newSetFromMap(new ConcurrentHashMap());
        this.atomicRequestCount = new AtomicInteger();
        this.bodyLimit = LongCompanionObject.MAX_VALUE;
        this.dispatcher = new QueueDispatcher();
        this.portField = -1;
        this.protocolNegotiationEnabled = true;
        this.protocols = Util.immutableListOf(new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void acceptConnections() throws Exception {
        while (true) {
            try {
                ServerSocket serverSocket = this.serverSocket;
                Intrinsics.checkNotNull(serverSocket);
                Socket accept = serverSocket.accept();
                Intrinsics.checkNotNullExpressionValue(accept, "serverSocket!!.accept()");
                if (this.dispatcher.peek().getSocketPolicy() == SocketPolicy.DISCONNECT_AT_START) {
                    dispatchBookkeepingRequest(0, accept);
                    accept.close();
                } else {
                    this.openClientSockets.add(accept);
                    serveConnection(accept);
                }
            } catch (SocketException e10) {
                logger.fine(this + " done accepting connections: " + e10.getMessage());
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchBookkeepingRequest(int sequenceNumber, Socket socket) throws InterruptedException {
        RecordedRequest recordedRequest = new RecordedRequest("", Headers.Companion.of(new String[0]), CollectionsKt.emptyList(), 0L, new Buffer(), sequenceNumber, socket, null, 128, null);
        this.atomicRequestCount.incrementAndGet();
        this.requestQueue.add(recordedRequest);
        this.dispatcher.dispatch(recordedRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleWebSocketUpgrade(Socket socket, final BufferedSource source, final BufferedSink sink, RecordedRequest request, MockResponse response) throws IOException {
        String str;
        String header = request.getHeader("Sec-WebSocket-Key");
        WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
        Intrinsics.checkNotNull(header);
        response.setHeader("Sec-WebSocket-Accept", webSocketProtocol.acceptHeader(header));
        writeHttpResponse(socket, sink, response);
        if (request.getTlsVersion() != null) {
            str = HttpConstant.HTTPS;
        } else {
            str = HttpConstant.HTTP;
        }
        String header2 = request.getHeader("Host");
        Request build = new Request.Builder().url(str + HttpConstant.SCHEME_SPLIT + header2 + '/').headers(request.getHeaders()).build();
        List split$default = StringsKt.split$default((CharSequence) response.getStatus(), new char[]{' '}, false, 3, 2, (Object) null);
        Response build2 = new Response.Builder().code(Integer.parseInt((String) split$default.get(1))).message((String) split$default.get(2)).headers(response.getHeaders()).request(build).protocol(Protocol.HTTP_1_1).build();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        RealWebSocket.Streams streams = new RealWebSocket.Streams(source, sink) { // from class: okhttp3.mockwebserver.MockWebServer$handleWebSocketUpgrade$streams$1
            public void close() {
                countDownLatch.countDown();
            }
        };
        TaskRunner taskRunner = this.taskRunner;
        WebSocketListener webSocketListener = response.getWebSocketListener();
        Intrinsics.checkNotNull(webSocketListener);
        RealWebSocket realWebSocket = new RealWebSocket(taskRunner, build, webSocketListener, new SecureRandom(), 0L, WebSocketExtensions.Companion.parse(response.getHeaders()), 0L);
        WebSocketListener webSocketListener2 = response.getWebSocketListener();
        Intrinsics.checkNotNull(webSocketListener2);
        webSocketListener2.onOpen(realWebSocket, build2);
        StringBuilder sb = new StringBuilder();
        sb.append("MockWebServer WebSocket ");
        String path = request.getPath();
        Intrinsics.checkNotNull(path);
        sb.append(path);
        realWebSocket.initReaderAndWriter(sb.toString(), streams);
        try {
            try {
                realWebSocket.loopReader();
                countDownLatch.await();
            } catch (IOException e10) {
                realWebSocket.failWebSocket(e10, (Response) null);
            }
        } finally {
            Util.closeQuietly(source);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processHandshakeFailure(Socket raw) throws Exception {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, new TrustManager[]{UNTRUSTED_TRUST_MANAGER}, new SecureRandom());
        Socket createSocket = sSLContext.getSocketFactory().createSocket(raw, raw.getInetAddress().getHostAddress(), raw.getPort(), true);
        Intrinsics.checkNotNull(createSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
        SSLSocket sSLSocket = (SSLSocket) createSocket;
        try {
            sSLSocket.startHandshake();
            throw new AssertionError();
        } catch (IOException unused) {
            sSLSocket.close();
        }
    }

    private final void readEmptyLine(BufferedSource source) throws IOException {
        String readUtf8LineStrict = source.readUtf8LineStrict();
        if (readUtf8LineStrict.length() == 0) {
            return;
        }
        throw new IllegalStateException(("Expected empty but was: " + readUtf8LineStrict).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x004b, code lost:
    
        if (r13 == okhttp3.mockwebserver.SocketPolicy.CONTINUE_ALWAYS) goto L١٨;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final RecordedRequest readRequest(Socket socket, BufferedSource source, BufferedSink sink, int sequenceNumber) throws IOException {
        ArrayList arrayList;
        String str;
        IOException iOException;
        String str2;
        boolean z10;
        Object obj;
        int i10;
        String str3;
        boolean z11;
        boolean z12;
        Headers.Builder builder = new Headers.Builder();
        TruncatingBuffer truncatingBuffer = new TruncatingBuffer(this.bodyLimit);
        ArrayList arrayList2 = new ArrayList();
        try {
            str = source.readUtf8LineStrict();
            try {
            } catch (IOException e10) {
                e = e10;
                arrayList = arrayList2;
            }
        } catch (IOException e11) {
            e = e11;
            arrayList = arrayList2;
            str = "";
        }
        try {
        } catch (IOException e12) {
            e = e12;
            iOException = e;
            str2 = str;
            return new RecordedRequest(str2, builder.build(), arrayList, truncatingBuffer.getReceivedByteCount(), truncatingBuffer.getBuffer(), sequenceNumber, socket, iOException);
        }
        if (str.length() != 0) {
            long j10 = -1;
            long j11 = -1;
            boolean z13 = false;
            boolean z14 = false;
            while (true) {
                String readUtf8LineStrict = source.readUtf8LineStrict();
                z10 = z14;
                obj = null;
                if (readUtf8LineStrict.length() == 0) {
                    break;
                }
                ArrayList arrayList3 = arrayList2;
                Internal.addHeaderLenient(builder, readUtf8LineStrict);
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase = readUtf8LineStrict.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (j11 == j10 && StringsKt.startsWith$default(lowerCase, "content-length:", false, 2, (Object) null)) {
                    String substring = readUtf8LineStrict.substring(15);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    j11 = Long.parseLong(StringsKt.trim((CharSequence) substring).toString());
                }
                if (StringsKt.startsWith$default(lowerCase, "transfer-encoding:", false, 2, (Object) null)) {
                    String substring2 = lowerCase.substring(18);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                    if (Intrinsics.areEqual(StringsKt.trim((CharSequence) substring2).toString(), "chunked")) {
                        z10 = true;
                    }
                }
                if (StringsKt.startsWith$default(lowerCase, "expect:", false, 2, (Object) null)) {
                    String substring3 = lowerCase.substring(7);
                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                    if (StringsKt.equals(StringsKt.trim((CharSequence) substring3).toString(), "100-continue", true)) {
                        z14 = z10;
                        arrayList2 = arrayList3;
                        j10 = -1;
                        z13 = true;
                    }
                }
                z14 = z10;
                arrayList2 = arrayList3;
                j10 = -1;
            }
            SocketPolicy socketPolicy = this.dispatcher.peek().getSocketPolicy();
            if (z13) {
                if (socketPolicy != SocketPolicy.EXPECT_CONTINUE) {
                }
                sink.writeUtf8("HTTP/1.1 100 Continue\r\n");
                sink.writeUtf8("Content-Length: 0\r\n");
                sink.writeUtf8("\r\n");
                sink.flush();
                MockResponse peek = this.dispatcher.peek();
                if (peek.getSocketPolicy() != SocketPolicy.DO_NOT_READ_REQUEST_BODY) {
                    if (j11 != j10) {
                        if (j11 > 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        throttledTransfer(peek, socket, source, Okio.buffer(truncatingBuffer), j11, true);
                        arrayList = arrayList2;
                        z11 = z12;
                        i10 = 2;
                        str3 = 0;
                    } else {
                        i10 = 2;
                        if (z10) {
                            while (true) {
                                int parseInt = Integer.parseInt(StringsKt.trim((CharSequence) source.readUtf8LineStrict()).toString(), CharsKt.checkRadix(16));
                                if (parseInt == 0) {
                                    break;
                                }
                                arrayList2.add(Integer.valueOf(parseInt));
                                ArrayList arrayList4 = arrayList2;
                                Object obj2 = obj;
                                throttledTransfer(peek, socket, source, Okio.buffer(truncatingBuffer), parseInt, true);
                                readEmptyLine(source);
                                obj = obj2;
                                arrayList2 = arrayList4;
                            }
                            readEmptyLine(source);
                            arrayList = arrayList2;
                            z11 = true;
                            str3 = obj;
                        } else {
                            arrayList = arrayList2;
                        }
                    }
                    String substringBefore$default = StringsKt.substringBefore$default(str, ' ', str3, i10, (Object) str3);
                    if (z11 && !HttpMethod.permitsRequestBody(substringBefore$default)) {
                        throw new IllegalArgumentException(("Request must not have a body: " + str).toString());
                    }
                    str2 = str;
                    iOException = str3;
                    return new RecordedRequest(str2, builder.build(), arrayList, truncatingBuffer.getReceivedByteCount(), truncatingBuffer.getBuffer(), sequenceNumber, socket, iOException);
                }
                arrayList = arrayList2;
                i10 = 2;
                str3 = 0;
                z11 = false;
                String substringBefore$default2 = StringsKt.substringBefore$default(str, ' ', str3, i10, (Object) str3);
                if (z11) {
                    throw new IllegalArgumentException(("Request must not have a body: " + str).toString());
                }
                str2 = str;
                iOException = str3;
                return new RecordedRequest(str2, builder.build(), arrayList, truncatingBuffer.getReceivedByteCount(), truncatingBuffer.getBuffer(), sequenceNumber, socket, iOException);
            }
        } else {
            throw new ProtocolException("no request because the stream is exhausted");
        }
    }

    private final void serveConnection(final Socket raw) {
        TaskQueue newQueue = this.taskRunner.newQueue();
        final String str = "MockWebServer " + raw.getRemoteSocketAddress();
        final boolean z10 = false;
        newQueue.schedule(new Task(str, z10) { // from class: okhttp3.mockwebserver.MockWebServer$serveConnection$$inlined$execute$default$1
            public long runOnce() {
                try {
                    new MockWebServer.SocketHandler(this, raw).handle();
                    return -1L;
                } catch (IOException e10) {
                    MockWebServer.logger.fine(this + " connection from " + raw.getInetAddress() + " failed: " + e10);
                    return -1L;
                } catch (Exception e11) {
                    MockWebServer.logger.log(Level.SEVERE, this + " connection from " + raw.getInetAddress() + " crashed", (Throwable) e11);
                    return -1L;
                }
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sleepIfDelayed(long delayMs) {
        if (delayMs != 0) {
            Thread.sleep(delayMs);
        }
    }

    public static /* synthetic */ void start$default(MockWebServer mockWebServer, int i10, int i11, Object obj) throws IOException {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        mockWebServer.start(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void throttledTransfer(MockResponse policy, Socket socket, BufferedSource source, BufferedSink sink, long byteCount, boolean isRequest) throws IOException {
        long j10 = 0;
        if (byteCount == 0) {
            return;
        }
        Buffer buffer = new Buffer();
        long throttleBytesPerPeriod = policy.getThrottleBytesPerPeriod();
        long throttlePeriod = policy.getThrottlePeriod(TimeUnit.MILLISECONDS);
        long j11 = byteCount / 2;
        boolean z10 = false;
        if (!isRequest ? policy.getSocketPolicy() == SocketPolicy.DISCONNECT_DURING_RESPONSE_BODY : policy.getSocketPolicy() == SocketPolicy.DISCONNECT_DURING_REQUEST_BODY) {
            z10 = true;
        }
        long j12 = byteCount;
        while (!socket.isClosed()) {
            long j13 = j10;
            while (j13 < throttleBytesPerPeriod) {
                long min = Math.min(j12, throttleBytesPerPeriod - j13);
                long j14 = throttleBytesPerPeriod;
                if (z10) {
                    min = Math.min(min, j12 - j11);
                }
                long read = source.read(buffer, min);
                if (read == -1) {
                    return;
                }
                sink.write(buffer, read);
                sink.flush();
                j13 += read;
                j12 -= read;
                if (z10 && j12 == j11) {
                    socket.close();
                    return;
                }
                j10 = 0;
                if (j12 == 0) {
                    return;
                } else {
                    throttleBytesPerPeriod = j14;
                }
            }
            sleepIfDelayed(throttlePeriod);
            throttleBytesPerPeriod = throttleBytesPerPeriod;
        }
    }

    private final void writeHeaders(BufferedSink sink, Headers headers) throws IOException {
        Iterator it = headers.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            String str = (String) pair.component1();
            String str2 = (String) pair.component2();
            sink.writeUtf8(str);
            sink.writeUtf8(": ");
            sink.writeUtf8(str2);
            sink.writeUtf8("\r\n");
        }
        sink.writeUtf8("\r\n");
        sink.flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeHttpResponse(Socket socket, BufferedSink sink, MockResponse response) throws IOException {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        sleepIfDelayed(response.getHeadersDelay(timeUnit));
        sink.writeUtf8(response.getStatus());
        sink.writeUtf8("\r\n");
        writeHeaders(sink, response.getHeaders());
        Buffer body = response.getBody();
        if (body == null) {
            return;
        }
        sleepIfDelayed(response.getBodyDelay(timeUnit));
        throttledTransfer(response, socket, body, sink, body.size(), false);
        if (StringsKt.equals("chunked", response.getHeaders().get(com.liulishuo.okdownload.core.Util.TRANSFER_ENCODING), true)) {
            writeHeaders(sink, response.getTrailers());
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @ReplaceWith(expression = "run { this.bodyLimit = bodyLimit }", imports = {}))
    @JvmName(name = "-deprecated_bodyLimit")
    /* renamed from: -deprecated_bodyLimit, reason: not valid java name */
    public final void m٢٢٠١deprecated_bodyLimit(long bodyLimit) {
        this.bodyLimit = bodyLimit;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "port", imports = {}))
    @JvmName(name = "-deprecated_port")
    /* renamed from: -deprecated_port, reason: not valid java name */
    public final int m٢٢٠٢deprecated_port() {
        return getPort();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @ReplaceWith(expression = "run { this.protocolNegotiationEnabled = protocolNegotiationEnabled }", imports = {}))
    @JvmName(name = "-deprecated_protocolNegotiationEnabled")
    /* renamed from: -deprecated_protocolNegotiationEnabled, reason: not valid java name */
    public final void m٢٢٠٣deprecated_protocolNegotiationEnabled(boolean protocolNegotiationEnabled) {
        this.protocolNegotiationEnabled = protocolNegotiationEnabled;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @ReplaceWith(expression = "run { this.protocols = protocols }", imports = {}))
    @JvmName(name = "-deprecated_protocols")
    /* renamed from: -deprecated_protocols, reason: not valid java name */
    public final void m٢٢٠٥deprecated_protocols(@NotNull List<? extends Protocol> protocols) {
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        setProtocols(protocols);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "requestCount", imports = {}))
    @JvmName(name = "-deprecated_requestCount")
    /* renamed from: -deprecated_requestCount, reason: not valid java name */
    public final int m٢٢٠٦deprecated_requestCount() {
        return getRequestCount();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @ReplaceWith(expression = "run { this.serverSocketFactory = serverSocketFactory }", imports = {}))
    @JvmName(name = "-deprecated_serverSocketFactory")
    /* renamed from: -deprecated_serverSocketFactory, reason: not valid java name */
    public final void m٢٢٠٧deprecated_serverSocketFactory(@NotNull ServerSocketFactory serverSocketFactory) {
        Intrinsics.checkNotNullParameter(serverSocketFactory, "serverSocketFactory");
        setServerSocketFactory(serverSocketFactory);
    }

    protected synchronized void after() {
        try {
            shutdown();
        } catch (IOException e10) {
            logger.log(Level.WARNING, "MockWebServer shutdown failed", (Throwable) e10);
        }
    }

    protected synchronized void before() {
        if (this.started) {
            return;
        }
        try {
            start$default(this, 0, 1, null);
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        shutdown();
    }

    public final void enqueue(@NotNull MockResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        Dispatcher dispatcher = this.dispatcher;
        Intrinsics.checkNotNull(dispatcher, "null cannot be cast to non-null type okhttp3.mockwebserver.QueueDispatcher");
        ((QueueDispatcher) dispatcher).enqueueResponse(response.clone());
    }

    public final long getBodyLimit() {
        return this.bodyLimit;
    }

    @NotNull
    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    @NotNull
    public final String getHostName() {
        before();
        InetSocketAddress inetSocketAddress = this.inetSocketAddress;
        Intrinsics.checkNotNull(inetSocketAddress);
        String canonicalHostName = inetSocketAddress.getAddress().getCanonicalHostName();
        Intrinsics.checkNotNullExpressionValue(canonicalHostName, "inetSocketAddress!!.address.canonicalHostName");
        return canonicalHostName;
    }

    public final int getPort() {
        before();
        return this.portField;
    }

    public final boolean getProtocolNegotiationEnabled() {
        return this.protocolNegotiationEnabled;
    }

    public final int getRequestCount() {
        return this.atomicRequestCount.get();
    }

    @Nullable
    public final ServerSocketFactory getServerSocketFactory() {
        if (this.serverSocketFactory == null && this.started) {
            this.serverSocketFactory = ServerSocketFactory.getDefault();
        }
        return this.serverSocketFactory;
    }

    public final void noClientAuth() {
        this.clientAuth = 0;
    }

    @JvmName(name = "protocols")
    @NotNull
    public final List<Protocol> protocols() {
        return this.protocols;
    }

    public final void requestClientAuth() {
        this.clientAuth = 1;
    }

    public final void requireClientAuth() {
        this.clientAuth = 2;
    }

    public final void setBodyLimit(long j10) {
        this.bodyLimit = j10;
    }

    public final void setDispatcher(@NotNull Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "<set-?>");
        this.dispatcher = dispatcher;
    }

    public final void setProtocolNegotiationEnabled(boolean z10) {
        this.protocolNegotiationEnabled = z10;
    }

    public final void setProtocols(@NotNull List<? extends Protocol> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        List<? extends Protocol> immutableList = Util.toImmutableList(value);
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        if (immutableList.contains(protocol) && immutableList.size() != 1) {
            throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + immutableList).toString());
        }
        if (!immutableList.contains(Protocol.HTTP_1_1) && !immutableList.contains(protocol)) {
            throw new IllegalArgumentException(("protocols doesn't contain http/1.1: " + immutableList).toString());
        }
        Intrinsics.checkNotNull(immutableList, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Protocol?>");
        if (!immutableList.contains(null)) {
            this.protocols = immutableList;
            return;
        }
        throw new IllegalArgumentException("protocols must not contain null");
    }

    public final void setServerSocketFactory(@Nullable ServerSocketFactory serverSocketFactory) {
        if (!this.started) {
            this.serverSocketFactory = serverSocketFactory;
            return;
        }
        throw new IllegalStateException("serverSocketFactory must not be set after start()");
    }

    public final synchronized void shutdown() throws IOException {
        try {
            if (!this.started) {
                return;
            }
            ServerSocket serverSocket = this.serverSocket;
            if (serverSocket != null) {
                Intrinsics.checkNotNull(serverSocket);
                serverSocket.close();
                Iterator it = this.taskRunner.activeQueues().iterator();
                while (it.hasNext()) {
                    if (!((TaskQueue) it.next()).idleLatch().await(5L, TimeUnit.SECONDS)) {
                        throw new IOException("Gave up waiting for queue to shut down");
                    }
                }
                this.taskRunnerBackend.shutdown();
                return;
            }
            throw new IllegalArgumentException("shutdown() before start()");
        } catch (Throwable th) {
            throw th;
        }
    }

    @JvmOverloads
    public final void start() throws IOException {
        start$default(this, 0, 1, null);
    }

    @NotNull
    public final RecordedRequest takeRequest() throws InterruptedException {
        RecordedRequest take = this.requestQueue.take();
        Intrinsics.checkNotNullExpressionValue(take, "requestQueue.take()");
        return take;
    }

    @NotNull
    public final Proxy toProxyAddress() {
        before();
        InetSocketAddress inetSocketAddress = this.inetSocketAddress;
        Intrinsics.checkNotNull(inetSocketAddress);
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetSocketAddress.getAddress().getCanonicalHostName(), getPort()));
    }

    @NotNull
    public String toString() {
        return "MockWebServer[" + this.portField + ']';
    }

    @NotNull
    public final HttpUrl url(@NotNull String path) {
        String str;
        Intrinsics.checkNotNullParameter(path, "path");
        HttpUrl.Builder builder = new HttpUrl.Builder();
        if (this.sslSocketFactory != null) {
            str = HttpConstant.HTTPS;
        } else {
            str = HttpConstant.HTTP;
        }
        HttpUrl resolve = builder.scheme(str).host(getHostName()).port(getPort()).build().resolve(path);
        Intrinsics.checkNotNull(resolve);
        return resolve;
    }

    public final void useHttps(@NotNull SSLSocketFactory sslSocketFactory, boolean tunnelProxy) {
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        this.sslSocketFactory = sslSocketFactory;
        this.tunnelProxy = tunnelProxy;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @ReplaceWith(expression = "protocols", imports = {}))
    @JvmName(name = "-deprecated_protocols")
    @NotNull
    /* renamed from: -deprecated_protocols, reason: not valid java name */
    public final List<Protocol> m٢٢٠٤deprecated_protocols() {
        return this.protocols;
    }

    @JvmOverloads
    public final void start(int port) throws IOException {
        InetAddress byName = InetAddress.getByName(ServerConfigureKt.kLocalServer);
        Intrinsics.checkNotNullExpressionValue(byName, "getByName(\"localhost\")");
        start(byName, port);
    }

    @Nullable
    public final RecordedRequest takeRequest(long timeout, @NotNull TimeUnit unit) throws InterruptedException {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return this.requestQueue.poll(timeout, unit);
    }

    public final void start(@NotNull InetAddress inetAddress, int port) throws IOException {
        Intrinsics.checkNotNullParameter(inetAddress, "inetAddress");
        start(new InetSocketAddress(inetAddress, port));
    }

    private final synchronized void start(InetSocketAddress inetSocketAddress) throws IOException {
        if (!this.started) {
            boolean z10 = true;
            this.started = true;
            this.inetSocketAddress = inetSocketAddress;
            ServerSocketFactory serverSocketFactory = getServerSocketFactory();
            Intrinsics.checkNotNull(serverSocketFactory);
            ServerSocket createServerSocket = serverSocketFactory.createServerSocket();
            this.serverSocket = createServerSocket;
            Intrinsics.checkNotNull(createServerSocket);
            final boolean z11 = false;
            if (inetSocketAddress.getPort() == 0) {
                z10 = false;
            }
            createServerSocket.setReuseAddress(z10);
            ServerSocket serverSocket = this.serverSocket;
            Intrinsics.checkNotNull(serverSocket);
            serverSocket.bind(inetSocketAddress, 50);
            ServerSocket serverSocket2 = this.serverSocket;
            Intrinsics.checkNotNull(serverSocket2);
            this.portField = serverSocket2.getLocalPort();
            TaskQueue newQueue = this.taskRunner.newQueue();
            final String str = "MockWebServer " + this.portField;
            newQueue.schedule(new Task(str, z11) { // from class: okhttp3.mockwebserver.MockWebServer$start$$inlined$execute$default$1
                public long runOnce() {
                    ServerSocket serverSocket3;
                    try {
                        MockWebServer.logger.fine(this + " starting to accept connections");
                        this.acceptConnections();
                    } catch (Throwable th) {
                        MockWebServer.logger.log(Level.WARNING, this + " failed unexpectedly", th);
                    }
                    serverSocket3 = this.serverSocket;
                    if (serverSocket3 != null) {
                        Util.closeQuietly(serverSocket3);
                    }
                    Iterator it = this.openClientSockets.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "openClientSocket.next()");
                        Util.closeQuietly((Socket) next);
                        it.remove();
                    }
                    Iterator it2 = this.openConnections.iterator();
                    while (it2.hasNext()) {
                        Object next2 = it2.next();
                        Intrinsics.checkNotNullExpressionValue(next2, "httpConnection.next()");
                        Util.closeQuietly((Closeable) next2);
                        it2.remove();
                    }
                    this.getDispatcher().shutdown();
                    return -1L;
                }
            }, 0L);
        } else {
            throw new IllegalArgumentException("start() already called");
        }
    }
}
