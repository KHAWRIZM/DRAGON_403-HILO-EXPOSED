package g;

import com.amazonaws.services.s3.internal.Constants;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class f extends WebSocketListener {

    /* renamed from: a, reason: collision with root package name */
    public boolean f١٤٣٢٦a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f١٤٣٢٧b;

    public f(g gVar) {
        this.f١٤٣٢٧b = gVar;
    }

    public final void a() {
        if (!this.f١٤٣٢٦a) {
            this.f١٤٣٢٦a = true;
            SudLogger.d(this.f١٤٣٢٧b.f١٤٣٢٨a, "reconnect mWebSocket:" + this.f١٤٣٢٧b.f١٤٣٣٥h);
            LogUtils.file("SudGIPWebSocket", "reconnect mWebSocket:" + this.f١٤٣٢٧b.f١٤٣٣٥h);
            g gVar = this.f١٤٣٢٧b;
            if (gVar.f١٤٣٣٥h != null) {
                gVar.f١٤٣٣٥h = null;
                gVar.b(1000L);
            }
        }
    }

    public final /* synthetic */ void b(byte[] bArr) {
        try {
            this.f١٤٣٢٧b.c(bArr);
        } catch (Exception e10) {
            LogUtils.file("SudGIPWebSocket", "WebSocket解析数据发生了异常：" + LogUtils.getErrorInfo(e10));
        }
    }

    public final void c() {
        if (!this.f١٤٣٢٦a) {
            this.f١٤٣٢٦a = true;
            SudLogger.d(this.f١٤٣٢٧b.f١٤٣٢٨a, "reconnect mWebSocket:" + this.f١٤٣٢٧b.f١٤٣٣٥h);
            LogUtils.file("SudGIPWebSocket", "reconnect mWebSocket:" + this.f١٤٣٢٧b.f١٤٣٣٥h);
            g gVar = this.f١٤٣٢٧b;
            if (gVar.f١٤٣٣٥h != null) {
                gVar.f١٤٣٣٥h = null;
                gVar.b(1000L);
            }
        }
    }

    public final void onClosed(WebSocket webSocket, int i10, String str) {
        super.onClosed(webSocket, i10, str);
        LogUtils.file("SudGIPWebSocket", "===> onClosed： code:" + i10 + " reason:" + str);
        SudLogger.d(this.f١٤٣٢٧b.f١٤٣٢٨a, "===> onClosed： code:" + i10 + " reason:" + str);
        this.f١٤٣٢٧b.f١٤٣٣٤g.post(new Runnable() { // from class: g.e
            @Override // java.lang.Runnable
            public final void run() {
                f.this.a();
            }
        });
    }

    public final void onClosing(WebSocket webSocket, int i10, String str) {
        super.onClosing(webSocket, i10, str);
        webSocket.close(i10, str);
        LogUtils.file("SudGIPWebSocket", "===> onClosing： code:" + i10 + " reason:" + str);
        SudLogger.d(this.f١٤٣٢٧b.f١٤٣٢٨a, "===> onClosing： code:" + i10 + " reason:" + str);
    }

    public final void onFailure(WebSocket webSocket, Throwable th, Response response) {
        String response2;
        super.onFailure(webSocket, th, response);
        StringBuilder sb = new StringBuilder("===> onFailure： Throwable:");
        sb.append(th.getMessage());
        sb.append(" Response:");
        String str = Constants.NULL_VERSION_ID;
        if (response == null) {
            response2 = Constants.NULL_VERSION_ID;
        } else {
            response2 = response.toString();
        }
        sb.append(response2);
        LogUtils.file("SudGIPWebSocket", sb.toString());
        String str2 = this.f١٤٣٢٧b.f١٤٣٢٨a;
        StringBuilder sb2 = new StringBuilder("===> onFailure： Throwable:");
        sb2.append(th.getMessage());
        sb2.append(" Response:");
        if (response != null) {
            str = response.toString();
        }
        sb2.append(str);
        SudLogger.d(str2, sb2.toString());
        this.f١٤٣٢٧b.f١٤٣٣٤g.post(new Runnable() { // from class: g.c
            @Override // java.lang.Runnable
            public final void run() {
                f.this.c();
            }
        });
    }

    public final void onMessage(WebSocket webSocket, ByteString byteString) {
        super.onMessage(webSocket, byteString);
        final byte[] byteArray = byteString.toByteArray();
        this.f١٤٣٢٧b.f١٤٣٣٤g.post(new Runnable() { // from class: g.d
            @Override // java.lang.Runnable
            public final void run() {
                f.this.b(byteArray);
            }
        });
    }

    public final void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);
        SudLogger.d(this.f١٤٣٢٧b.f١٤٣٢٨a, "websocket onOpen");
        LogUtils.file("SudGIPWebSocket", "websocket onOpen");
    }
}
