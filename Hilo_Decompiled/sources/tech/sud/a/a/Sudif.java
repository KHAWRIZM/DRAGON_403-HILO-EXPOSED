package tech.sud.a.a;

import android.os.Build;
import b1.b;
import b1.c;
import b1.e;
import com.taobao.accs.common.Constants;
import com.tencent.rtmp.TXLiveConstants;
import e0.m;
import f0.j;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import org.android.agoo.common.AgooConstants;
import p0.d;
import p0.g;
import tech.sud.runtime.component.h.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public abstract class Sudif extends c implements Runnable, b {
    public final String a;
    protected tech.sud.runtime.component.websocket.a b;
    private e c;
    private Socket d;
    private OutputStream e;
    private Proxy f;
    private Thread g;
    private Thread h;
    private e1.a i;
    private Map<String, String> j;
    private CountDownLatch k;
    private CountDownLatch l;
    private int m;

    public Sudif(tech.sud.runtime.component.websocket.a aVar) {
        e1.b bVar = new e1.b(Collections.EMPTY_LIST, Collections.singletonList(new u0.a()));
        this.a = "SudNative WebSocketClient";
        this.b = null;
        this.c = null;
        this.d = null;
        this.f = Proxy.NO_PROXY;
        this.k = new CountDownLatch(1);
        this.l = new CountDownLatch(1);
        this.b = aVar;
        this.i = bVar;
        this.j = null;
        this.m = 15000;
        a(false);
        b(false);
        this.c = new e(this, bVar);
        f.c("SudNative WebSocketClient", "created WebSocketClient");
    }

    public static void c(Sudif sudif) {
        sudif.getClass();
        try {
            Socket socket = sudif.d;
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            sudif.a((b) sudif, (Exception) e);
        }
    }

    public final int Suddo() {
        int e = this.b.e();
        if (e == -1) {
            String a = this.b.a();
            if ("wss".equals(a)) {
                return Constants.PORT;
            }
            if ("ws".equals(a)) {
                return 80;
            }
            throw new IllegalArgumentException("unknown scheme: " + a);
        }
        return e;
    }

    public final void Sudif() {
        String str;
        String c = this.b.c();
        String d = this.b.d();
        if (c == null || c.length() == 0) {
            c = "/";
        }
        if (d != null) {
            c = c + '?' + d;
        }
        int Suddo = Suddo();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.b.b());
        if (Suddo != 80 && Suddo != 443) {
            str = m.a(Suddo, ":");
        } else {
            str = "";
        }
        sb2.append(str);
        String sb3 = sb2.toString();
        d dVar = new d();
        if (c != null) {
            dVar.b = c;
            ((p0.f) dVar).a.put("Host", sb3);
            Map<String, String> map = this.j;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    ((p0.f) dVar).a.put(entry.getKey(), entry.getValue());
                }
            }
            e eVar = this.c;
            e1.b bVar = eVar.e;
            bVar.getClass();
            ((p0.f) dVar).a.put("Upgrade", "websocket");
            ((p0.f) dVar).a.put("Connection", "Upgrade");
            byte[] bArr = new byte[16];
            bVar.i.nextBytes(bArr);
            ((p0.f) dVar).a.put("Sec-WebSocket-Key", z0.a.a(bArr));
            ((p0.f) dVar).a.put("Sec-WebSocket-Version", AgooConstants.ACK_FLAG_NULL);
            StringBuilder sb4 = new StringBuilder();
            ArrayList arrayList = bVar.c;
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                ((o1.a) obj).getClass();
            }
            if (sb4.length() != 0) {
                ((p0.f) dVar).a.put("Sec-WebSocket-Extensions", sb4.toString());
            }
            StringBuilder sb5 = new StringBuilder();
            ArrayList arrayList2 = bVar.e;
            int size2 = arrayList2.size();
            while (i < size2) {
                Object obj2 = arrayList2.get(i);
                i++;
                ((u0.a) obj2).getClass();
            }
            if (sb5.length() != 0) {
                ((p0.f) dVar).a.put("Sec-WebSocket-Protocol", sb5.toString());
            }
            eVar.h = dVar;
            String str2 = dVar.b;
            if (!e.o && str2 == null) {
                throw new AssertionError();
            }
            try {
                eVar.b.a(eVar, dVar);
                e1.b bVar2 = eVar.e;
                p0.c cVar = eVar.h;
                bVar2.getClass();
                StringBuilder sb6 = new StringBuilder(100);
                if (cVar instanceof p0.b) {
                    sb6.append("GET ");
                    sb6.append(((d) cVar).b);
                    sb6.append(" HTTP/1.1");
                } else if (cVar instanceof g) {
                    sb6.append("HTTP/1.1 101 ");
                    sb6.append(((g) cVar).b);
                } else {
                    throw new IllegalArgumentException("unknown role");
                }
                sb6.append("\r\n");
                for (String str3 : Collections.unmodifiableSet(((p0.f) cVar).a.keySet())) {
                    String a = cVar.a(str3);
                    sb6.append(str3);
                    sb6.append(": ");
                    sb6.append(a);
                    sb6.append("\r\n");
                }
                sb6.append("\r\n");
                String sb7 = sb6.toString();
                CodingErrorAction codingErrorAction = z0.b.a;
                try {
                    byte[] bytes = sb7.getBytes("ASCII");
                    ByteBuffer allocate = ByteBuffer.allocate(bytes.length);
                    allocate.put(bytes);
                    allocate.flip();
                    eVar.g(Collections.singletonList(allocate));
                    return;
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            } catch (RuntimeException e2) {
                eVar.b.a(eVar, e2);
                throw new i1.g("rejected because of" + e2);
            } catch (i1.d unused) {
                throw new i1.g("Handshake data rejected by client.");
            }
        }
        throw new IllegalArgumentException("http resource descriptor must not be null");
    }

    public void a(int i, String str) {
    }

    public abstract void a(Exception exc);

    public abstract void a(ByteBuffer byteBuffer);

    public abstract void a(g gVar);

    public abstract void b(int i, String str, boolean z);

    public abstract void c(String str);

    public void f() {
        if (this.h == null) {
            Thread thread = new Thread(this);
            this.h = thread;
            thread.setName("WebSocketConnectReadThread-" + this.h.getId());
            this.h.start();
            return;
        }
        throw new IllegalStateException("WebSocketClient objects are not reuseable");
    }

    public void g() {
        if (this.g != null) {
            this.c.a(1000, "", false);
        }
    }

    public boolean h() {
        if (this.c.d == 5) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.c.d == 4) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        int read;
        InetSocketAddress inetSocketAddress;
        try {
            Socket socket = this.d;
            if (socket == null) {
                this.d = new Socket(this.f);
                z = true;
            } else if (!socket.isClosed()) {
                z = false;
            } else {
                throw new IOException();
            }
            this.d.setTcpNoDelay(d());
            this.d.setReuseAddress(e());
            if (!this.d.isBound()) {
                f.c("SudNative WebSocketClient", "connect start host:" + this.b.b() + " port:" + Suddo());
                InetAddress b = b(this.b.b());
                if (b == null) {
                    inetSocketAddress = new InetSocketAddress(this.b.b(), Suddo());
                } else {
                    inetSocketAddress = new InetSocketAddress(b, Suddo());
                }
                this.d.connect(inetSocketAddress, this.m);
                f.c("SudNative WebSocketClient", "connect end host:" + this.b.b() + " port:" + Suddo());
            }
            if (z && "wss".equals(this.b.a())) {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                Socket createSocket = sSLContext.getSocketFactory().createSocket(this.d, this.b.b(), Suddo(), true);
                this.d = createSocket;
                if (createSocket instanceof SSLSocket) {
                    SSLSocket sSLSocket = (SSLSocket) createSocket;
                    SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                    if (Build.VERSION.SDK_INT >= 24) {
                        a.a();
                        sSLParameters.setServerNames(Collections.singletonList(com.tencent.imsdk.common.b.a(this.b.b())));
                    }
                    sSLSocket.setSSLParameters(sSLParameters);
                }
            }
            InputStream inputStream = this.d.getInputStream();
            this.e = this.d.getOutputStream();
            Sudif();
            Thread thread = new Thread(new Suddo(this));
            this.g = thread;
            thread.start();
            byte[] bArr = new byte[16384];
            while (!i() && !h() && (read = inputStream.read(bArr)) != -1) {
                try {
                    this.c.b(ByteBuffer.wrap(bArr, 0, read));
                } catch (IOException e) {
                    if (e instanceof SSLException) {
                        a(e);
                    }
                    e eVar = this.c;
                    if (eVar.d == 1) {
                        eVar.e(-1, "", true);
                    } else if (eVar.c) {
                        eVar.e(eVar.j.intValue(), eVar.i, eVar.k.booleanValue());
                    } else {
                        eVar.e.getClass();
                        eVar.e.getClass();
                        eVar.e(TXLiveConstants.PUSH_EVT_CHANGE_BITRATE, "", true);
                    }
                } catch (RuntimeException e2) {
                    a(e2);
                    this.c.e(TXLiveConstants.PUSH_EVT_CHANGE_BITRATE, e2.getMessage(), false);
                }
            }
            e eVar2 = this.c;
            if (eVar2.d == 1) {
                eVar2.e(-1, "", true);
            } else if (eVar2.c) {
                eVar2.e(eVar2.j.intValue(), eVar2.i, eVar2.k.booleanValue());
            } else {
                eVar2.e.getClass();
                eVar2.e.getClass();
                eVar2.e(TXLiveConstants.PUSH_EVT_CHANGE_BITRATE, "", true);
            }
            this.h = null;
        } catch (Exception e3) {
            a((b) this.c, e3);
            this.c.e(-1, e3.getMessage(), false);
        }
    }

    public void a(int i, String str, boolean z) {
    }

    public InetAddress b(String str) {
        InetAddress[] allByName = InetAddress.getAllByName(str);
        InetAddress inetAddress = null;
        if (allByName != null && allByName.length > 0) {
            int i = 0;
            while (true) {
                if (i >= allByName.length) {
                    break;
                }
                InetAddress inetAddress2 = allByName[i];
                if (i == 0) {
                    StringBuilder sb2 = new StringBuilder("getInetAddressPriorityIpv4 原本应该连接的第一位InetAddress:");
                    sb2.append(inetAddress2 == null ? "null" : inetAddress2.toString());
                    f.c("SudNative WebSocketClient", sb2.toString());
                }
                if (inetAddress2 instanceof Inet4Address) {
                    inetAddress = inetAddress2;
                    break;
                }
                i++;
            }
            if (inetAddress == null) {
                inetAddress = allByName[0];
            }
        }
        StringBuilder sb3 = new StringBuilder("getInetAddressPriorityIpv4 调整后连接的InetAddress:");
        sb3.append(inetAddress != null ? inetAddress.toString() : "null");
        f.c("SudNative WebSocketClient", sb3.toString());
        return inetAddress;
    }

    public void a(String str) {
        e eVar = this.c;
        if (str != null) {
            e1.b bVar = eVar.e;
            boolean z = eVar.f == 1;
            bVar.getClass();
            j jVar = new j();
            CodingErrorAction codingErrorAction = z0.b.a;
            try {
                ((f0.c) jVar).c = ByteBuffer.wrap(str.getBytes("UTF8"));
                ((f0.c) jVar).d = z;
                try {
                    jVar.a();
                    eVar.c(Collections.singletonList(jVar));
                    return;
                } catch (i1.d e) {
                    throw new i1.a(e);
                }
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException(e2);
            }
        }
        eVar.getClass();
        throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
    }

    public Collection<b> c() {
        return Collections.singletonList(this.c);
    }

    public void b(b bVar, int i, String str, boolean z) {
        a(i, str, z);
    }

    public void a(byte[] bArr) {
        e eVar = this.c;
        eVar.getClass();
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap != null) {
            e1.b bVar = eVar.e;
            boolean z = eVar.f == 1;
            bVar.getClass();
            f0.d dVar = new f0.d();
            ((f0.c) dVar).c = wrap;
            ((f0.c) dVar).d = z;
            eVar.c(Collections.singletonList(dVar));
            return;
        }
        throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
    }

    public final void a(b bVar, String str) {
        c(str);
    }

    public final void a(b bVar, ByteBuffer byteBuffer) {
        a(byteBuffer);
    }

    public final void a(b bVar, p0.e eVar) {
        b();
        a((g) eVar);
        this.k.countDown();
    }

    public final void a(b bVar, int i, String str, boolean z) {
        a();
        Thread thread = this.g;
        if (thread != null) {
            thread.interrupt();
        }
        b(i, str, z);
        this.k.countDown();
        this.l.countDown();
    }

    public final void a(b bVar, Exception exc) {
        a(exc);
    }

    public final void a(b bVar) {
    }

    public void a(b bVar, int i, String str) {
        a(i, str);
    }

    public void a(f0.a aVar) {
        e eVar = this.c;
        eVar.getClass();
        eVar.c(Collections.singletonList(aVar));
    }

    public static void a(Sudif sudif, IOException iOException) {
        if (iOException instanceof SSLException) {
            sudif.a(iOException);
        }
        e eVar = sudif.c;
        if (eVar.d == 1) {
            eVar.e(-1, "", true);
        } else {
            if (eVar.c) {
                eVar.e(eVar.j.intValue(), eVar.i, eVar.k.booleanValue());
                return;
            }
            eVar.e.getClass();
            eVar.e.getClass();
            eVar.e(TXLiveConstants.PUSH_EVT_CHANGE_BITRATE, "", true);
        }
    }
}
