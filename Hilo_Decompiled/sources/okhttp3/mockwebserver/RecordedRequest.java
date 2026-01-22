package okhttp3.mockwebserver;

import anet.channel.util.HttpConstant;
import com.facebook.login.LoginLogger;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.TlsVersion;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u0010\u00105\u001a\u0004\u0018\u00010\u00032\u0006\u00106\u001a\u00020\u0003J\b\u00107\u001a\u00020\u0003H\u0007J\b\u00108\u001a\u00020\u0003H\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0013\u0010'\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u0004\u0018\u00010.8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u00038GX\u0087\u0004¢\u0006\f\u0012\u0004\b2\u00103\u001a\u0004\b4\u0010#¨\u00069"}, d2 = {"Lokhttp3/mockwebserver/RecordedRequest;", "", "requestLine", "", "headers", "Lokhttp3/Headers;", "chunkSizes", "", "", "bodySize", "", "body", "Lokio/Buffer;", "sequenceNumber", "socket", "Ljava/net/Socket;", LoginLogger.EVENT_EXTRAS_FAILURE, "Ljava/io/IOException;", "(Ljava/lang/String;Lokhttp3/Headers;Ljava/util/List;JLokio/Buffer;ILjava/net/Socket;Ljava/io/IOException;)V", "getBody", "()Lokio/Buffer;", "getBodySize", "()J", "getChunkSizes", "()Ljava/util/List;", "getFailure", "()Ljava/io/IOException;", "handshake", "Lokhttp3/Handshake;", "getHandshake", "()Lokhttp3/Handshake;", "getHeaders", "()Lokhttp3/Headers;", FirebaseAnalytics.Param.METHOD, "getMethod", "()Ljava/lang/String;", "path", "getPath", "getRequestLine", "requestUrl", "Lokhttp3/HttpUrl;", "getRequestUrl", "()Lokhttp3/HttpUrl;", "getSequenceNumber", "()I", "tlsVersion", "Lokhttp3/TlsVersion;", "getTlsVersion", "()Lokhttp3/TlsVersion;", "utf8Body", "-deprecated_utf8Body$annotations", "()V", "-deprecated_utf8Body", "getHeader", "name", "getUtf8Body", "toString", "mockwebserver"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class RecordedRequest {

    @NotNull
    private final Buffer body;
    private final long bodySize;

    @NotNull
    private final List<Integer> chunkSizes;

    @Nullable
    private final IOException failure;

    @Nullable
    private final Handshake handshake;

    @NotNull
    private final Headers headers;

    @Nullable
    private final String method;

    @Nullable
    private final String path;

    @NotNull
    private final String requestLine;

    @Nullable
    private final HttpUrl requestUrl;
    private final int sequenceNumber;

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use body.readUtf8()", replaceWith = @ReplaceWith(expression = "body.readUtf8()", imports = {}))
    /* renamed from: -deprecated_utf8Body$annotations, reason: not valid java name */
    public static /* synthetic */ void m٢٢١٢deprecated_utf8Body$annotations() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecordedRequest(@NotNull String requestLine, @NotNull Headers headers, @NotNull List<Integer> chunkSizes, long j10, @NotNull Buffer body, int i10, @NotNull Socket socket) {
        this(requestLine, headers, chunkSizes, j10, body, i10, socket, null, 128, null);
        Intrinsics.checkNotNullParameter(requestLine, "requestLine");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(chunkSizes, "chunkSizes");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(socket, "socket");
    }

    @JvmName(name = "-deprecated_utf8Body")
    @NotNull
    /* renamed from: -deprecated_utf8Body, reason: not valid java name */
    public final String m٢٢١٣deprecated_utf8Body() {
        return this.body.readUtf8();
    }

    @NotNull
    public final Buffer getBody() {
        return this.body;
    }

    public final long getBodySize() {
        return this.bodySize;
    }

    @NotNull
    public final List<Integer> getChunkSizes() {
        return this.chunkSizes;
    }

    @Nullable
    public final IOException getFailure() {
        return this.failure;
    }

    @Nullable
    public final Handshake getHandshake() {
        return this.handshake;
    }

    @Nullable
    public final String getHeader(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (String) CollectionsKt.firstOrNull(this.headers.values(name));
    }

    @NotNull
    public final Headers getHeaders() {
        return this.headers;
    }

    @Nullable
    public final String getMethod() {
        return this.method;
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    @NotNull
    public final String getRequestLine() {
        return this.requestLine;
    }

    @Nullable
    public final HttpUrl getRequestUrl() {
        return this.requestUrl;
    }

    public final int getSequenceNumber() {
        return this.sequenceNumber;
    }

    @Nullable
    public final TlsVersion getTlsVersion() {
        Handshake handshake = this.handshake;
        if (handshake != null) {
            return handshake.tlsVersion();
        }
        return null;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use body.readUtf8()", replaceWith = @ReplaceWith(expression = "body.readUtf8()", imports = {}))
    @NotNull
    public final String getUtf8Body() {
        return this.body.readUtf8();
    }

    @NotNull
    public String toString() {
        return this.requestLine;
    }

    @JvmOverloads
    public RecordedRequest(@NotNull String requestLine, @NotNull Headers headers, @NotNull List<Integer> chunkSizes, long j10, @NotNull Buffer body, int i10, @NotNull Socket socket, @Nullable IOException iOException) {
        Intrinsics.checkNotNullParameter(requestLine, "requestLine");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(chunkSizes, "chunkSizes");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(socket, "socket");
        this.requestLine = requestLine;
        this.headers = headers;
        this.chunkSizes = chunkSizes;
        this.bodySize = j10;
        this.body = body;
        this.sequenceNumber = i10;
        this.failure = iOException;
        boolean z10 = socket instanceof SSLSocket;
        if (z10) {
            try {
                Handshake.Companion companion = Handshake.Companion;
                SSLSession session = ((SSLSocket) socket).getSession();
                Intrinsics.checkNotNullExpressionValue(session, "socket.session");
                this.handshake = companion.get(session);
            } catch (IOException e10) {
                throw new IllegalArgumentException(e10);
            }
        } else {
            this.handshake = null;
        }
        if (requestLine.length() > 0) {
            int indexOf$default = StringsKt.indexOf$default((CharSequence) requestLine, ' ', 0, false, 6, (Object) null);
            int i11 = indexOf$default + 1;
            int indexOf$default2 = StringsKt.indexOf$default((CharSequence) requestLine, ' ', i11, false, 4, (Object) null);
            String substring = requestLine.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            this.method = substring;
            String substring2 = requestLine.substring(i11, indexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            substring2 = StringsKt.startsWith$default(substring2, "/", false, 2, (Object) null) ? substring2 : "/";
            this.path = substring2;
            String str = z10 ? HttpConstant.HTTPS : HttpConstant.HTTP;
            InetAddress localAddress = socket.getLocalAddress();
            String hostname = localAddress.getHostName();
            if (localAddress instanceof Inet6Address) {
                Intrinsics.checkNotNullExpressionValue(hostname, "hostname");
                if (StringsKt.contains$default((CharSequence) hostname, ':', false, 2, (Object) null)) {
                    hostname = '[' + hostname + ']';
                }
            }
            int localPort = socket.getLocalPort();
            this.requestUrl = HttpUrl.Companion.parse(str + HttpConstant.SCHEME_SPLIT + hostname + ':' + localPort + substring2);
            return;
        }
        this.requestUrl = null;
        this.method = null;
        this.path = null;
    }

    public /* synthetic */ RecordedRequest(String str, Headers headers, List list, long j10, Buffer buffer, int i10, Socket socket, IOException iOException, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, headers, list, j10, buffer, i10, socket, (i11 & 128) != 0 ? null : iOException);
    }
}
