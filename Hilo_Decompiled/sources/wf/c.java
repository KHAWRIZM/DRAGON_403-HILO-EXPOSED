package wf;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class c extends EventListener {
    public final b a = new b();
    public long b;
    public final e c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public final EventListener i;

    public c(e eVar, EventListener eventListener) {
        this.c = eVar == null ? new e() : eVar;
        this.i = eventListener;
    }

    public final void a(String str) {
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.b);
        b bVar = this.a;
        Locale.getDefault();
        bVar.a("[" + millis + " ms] " + str);
    }

    @Override // okhttp3.EventListener
    public final void callEnd(Call call) {
        super.callEnd(call);
        a("callEnd");
        e eVar = this.c;
        TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.b);
        eVar.getClass();
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.callEnd(call);
        }
    }

    @Override // okhttp3.EventListener
    public final void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        a("callFailed: " + iOException);
        e eVar = this.c;
        TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.b);
        eVar.getClass();
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.callFailed(call, iOException);
        }
    }

    @Override // okhttp3.EventListener
    public final void callStart(Call call) {
        super.callStart(call);
        this.b = System.nanoTime();
        a("callStart: ${call.request()}");
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.callStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public final void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        a("connectEnd: " + protocol);
        this.c.b = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.e);
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.connectEnd(call, inetSocketAddress, proxy, protocol);
        }
    }

    @Override // okhttp3.EventListener
    public final void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        a("connectFailed: " + protocol + " " + iOException);
        this.c.b = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.e);
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        }
    }

    @Override // okhttp3.EventListener
    public final void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        a("connectStart: " + inetSocketAddress + " " + proxy);
        this.e = System.nanoTime();
        this.c.g = false;
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.connectStart(call, inetSocketAddress, proxy);
        }
    }

    @Override // okhttp3.EventListener
    public final void connectionAcquired(Call call, Connection connection) {
        super.connectionAcquired(call, connection);
        a("connectionAcquired: " + connection);
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.connectionAcquired(call, connection);
        }
    }

    @Override // okhttp3.EventListener
    public final void connectionReleased(Call call, Connection connection) {
        super.connectionReleased(call, connection);
        a("connectionReleased");
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.connectionReleased(call, connection);
        }
    }

    @Override // okhttp3.EventListener
    public final void dnsEnd(Call call, String str, List list) {
        super.dnsEnd(call, str, list);
        a("dnsEnd: " + list);
        this.c.a = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.d);
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.dnsEnd(call, str, list);
        }
    }

    @Override // okhttp3.EventListener
    public final void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        a("dnsStart: $domainName" + str);
        this.d = System.nanoTime();
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.dnsStart(call, str);
        }
    }

    @Override // okhttp3.EventListener
    public final void requestBodyEnd(Call call, long j) {
        super.requestBodyEnd(call, j);
        a("requestBodyEnd: byteCount=" + j);
        this.c.d = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.g);
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.requestBodyEnd(call, j);
        }
    }

    @Override // okhttp3.EventListener
    public final void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        a("requestBodyStart");
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.requestBodyStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public final void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        a("requestHeadersEnd");
        this.c.d = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.g);
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.requestHeadersEnd(call, request);
        }
    }

    @Override // okhttp3.EventListener
    public final void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        a("requestHeadersStart");
        this.g = System.nanoTime();
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.requestHeadersStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public final void responseBodyEnd(Call call, long j) {
        super.responseBodyEnd(call, j);
        a("responseBodyEnd: byteCount=" + j);
        e eVar = this.c;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        eVar.e = timeUnit.toMillis(System.nanoTime() - this.h);
        e eVar2 = this.c;
        eVar2.f = timeUnit.toMillis(this.h - (this.g + eVar2.d));
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.responseBodyEnd(call, j);
        }
    }

    @Override // okhttp3.EventListener
    public final void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        a("responseBodyStart");
        if (this.h == 0) {
            this.h = System.nanoTime();
        }
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.responseBodyStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public final void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        a("responseHeadersEnd: $response");
        this.c.e = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.h);
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.responseHeadersEnd(call, response);
        }
    }

    @Override // okhttp3.EventListener
    public final void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        a("responseHeadersStart");
        this.h = System.nanoTime();
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.responseHeadersStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public final void secureConnectEnd(Call call, Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        a("secureConnectEnd: " + handshake);
        this.c.c = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.f);
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.secureConnectEnd(call, handshake);
        }
    }

    @Override // okhttp3.EventListener
    public final void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        a("secureConnectStart");
        this.f = System.nanoTime();
        EventListener eventListener = this.i;
        if (eventListener != null) {
            eventListener.secureConnectStart(call);
        }
    }
}
