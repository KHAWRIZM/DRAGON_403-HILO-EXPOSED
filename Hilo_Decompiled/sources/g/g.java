package g;

import android.os.Handler;
import android.os.Looper;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.WebSocket;
import tech.sud.base.utils.BytesUtils;
import tech.sud.base.utils.CrcChecker;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public final String f١٤٣٢٩b;

    /* renamed from: c, reason: collision with root package name */
    public final String f١٤٣٣٠c;

    /* renamed from: d, reason: collision with root package name */
    public final long f١٤٣٣١d;

    /* renamed from: e, reason: collision with root package name */
    public final q0.b f١٤٣٣٢e;

    /* renamed from: h, reason: collision with root package name */
    public WebSocket f١٤٣٣٥h;

    /* renamed from: a, reason: collision with root package name */
    public final String f١٤٣٢٨a = "SudGIP ".concat(g.class.getSimpleName());

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f١٤٣٣٣f = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    public final Handler f١٤٣٣٤g = new Handler(Looper.getMainLooper());

    /* renamed from: i, reason: collision with root package name */
    public final b f١٤٣٣٦i = new b(this);

    public g(String str, String str2, String str3, long j10, q0.b bVar) {
        this.f١٤٣٢٩b = str;
        this.f١٤٣٣٠c = str3;
        this.f١٤٣٣١d = j10;
        this.f١٤٣٣٢e = bVar;
    }

    public final void a() {
        SudLogger.d(this.f١٤٣٢٨a, "getGateToken curIsRunning:" + this.f١٤٣٣٣f.get());
        LogUtils.file("SudGIPWebSocket", "getGateToken curIsRunning:" + this.f١٤٣٣٣f.get());
        if (!this.f١٤٣٣٣f.get()) {
            return;
        }
        yf.a aVar = new yf.a();
        aVar.a = this.f١٤٣٢٩b;
        e.d.f١٣٧١٩b.w(aVar, new a(this));
    }

    public final void b(long j10) {
        SudLogger.d(this.f١٤٣٢٨a, "delayGetGateToken curIsRunning:" + this.f١٤٣٣٣f.get());
        LogUtils.file("SudGIPWebSocket", "delayGetGateToken curIsRunning:" + this.f١٤٣٣٣f.get());
        if (!this.f١٤٣٣٣f.get()) {
            return;
        }
        this.f١٤٣٣٤g.removeCallbacks(this.f١٤٣٣٦i);
        this.f١٤٣٣٤g.postDelayed(this.f١٤٣٣٦i, j10);
    }

    public final void c(byte[] bArr) {
        n1.b bVar;
        if (bArr != null && bArr.length != 0) {
            if (bArr.length < 12) {
                SudLogger.d(this.f١٤٣٢٨a, "WebSocket后端发的数组长度不对,length:" + bArr.length);
                LogUtils.file("SudGIPWebSocket", "WebSocket后端发的数组长度不对,length:" + bArr.length);
                return;
            }
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 0, 4);
            int bytesToInt = BytesUtils.bytesToInt(bArr2);
            byte[] bArr3 = new byte[2];
            System.arraycopy(bArr, 4, bArr3, 0, 2);
            short bytesToShort = BytesUtils.bytesToShort(bArr3);
            byte[] bArr4 = new byte[2];
            System.arraycopy(bArr, 6, bArr4, 0, 2);
            short bytesToShort2 = BytesUtils.bytesToShort(bArr4);
            Locale locale = Locale.US;
            String str = "parseWebSocketMessage magic:" + bytesToInt + " version:" + ((int) bytesToShort) + " cmd:" + ((int) bytesToShort2);
            SudLogger.d(this.f١٤٣٢٨a, str);
            LogUtils.file("SudGIPWebSocket", str);
            if (bytesToShort2 == 1001) {
                if (bArr.length > 12) {
                    byte[] bArr5 = new byte[4];
                    System.arraycopy(bArr, 8, bArr5, 0, 4);
                    int length = bArr.length - 12;
                    byte[] bArr6 = new byte[length];
                    System.arraycopy(bArr, 12, bArr6, 0, length);
                    CrcChecker.check(bArr5, bArr6);
                    String str2 = new String(bArr6, StandardCharsets.UTF_8);
                    q0.b bVar2 = this.f١٤٣٣٢e;
                    if (bVar2 != null && (bVar = bVar2.f١٧٠٤٩a.f١٧٠٥٠B) != null && bVar.f١٦١٥٥j != null) {
                        SudLogger.d(bVar.f١٦١٤٦a, "onRoomChatMessage:".concat(str2));
                        LogUtils.file("AiAgentImpl", "onRoomChatMessage:".concat(str2));
                        bVar.f١٦١٥٥j.onRoomChatMessage(str2);
                        return;
                    }
                    return;
                }
                SudLogger.d(this.f١٤٣٢٨a, "WebSocket后端发的数组长度不对,length:" + bArr.length);
                LogUtils.file("SudGIPWebSocket", "WebSocket后端发的数组长度不对,length:" + bArr.length);
                return;
            }
            return;
        }
        SudLogger.d(this.f١٤٣٢٨a, "WebSocket后端发的数组为空");
        LogUtils.file("SudGIPWebSocket", "WebSocket后端发的数组为空");
    }
}
