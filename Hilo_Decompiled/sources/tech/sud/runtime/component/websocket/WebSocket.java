package tech.sud.runtime.component.websocket;

import java.nio.ByteBuffer;
import p0.g;
import tech.sud.a.a.Sudif;
import tech.sud.runtime.component.h.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class WebSocket {
    public final String a = "SudNative WebSocket";
    private a b;

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onbinarymessage(long j, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onclose(long j, int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onerror(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onopen(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void ontextmessage(long j, String str);

    public void close() {
        f.c("SudNative WebSocket", "close");
        this.b.g();
    }

    public void destroy() {
        this.b.j();
    }

    public void open(String str, long j) {
        f.c("SudNative WebSocket", "open uri:" + str + " cPtr:" + j);
        try {
            a aVar = new a(str, j);
            this.b = aVar;
            aVar.f();
        } catch (Exception e) {
            e.printStackTrace();
            f.b("WebSocket", "cPtr:" + j + " open fail:", e);
        }
    }

    public void send(String str) {
        this.b.a(str);
    }

    public void send(byte[] bArr) {
        this.b.a(bArr);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class a extends Sudif {
        private long c;

        public a(String str, long j) {
            super(new tech.sud.runtime.component.websocket.a(str));
            this.c = j;
        }

        @Override // tech.sud.a.a.Sudif
        public void a(g gVar) {
            f.c("SudNative WebSocketClient", "onOpen");
            synchronized (this) {
                try {
                    long j = this.c;
                    if (j != 0) {
                        WebSocket.onopen(j);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // tech.sud.a.a.Sudif
        public void b(int i, String str, boolean z) {
            synchronized (this) {
                try {
                    long j = this.c;
                    if (j != 0) {
                        WebSocket.onclose(j, i, str);
                    }
                    f.b("SudNative WebSocketClient", "J: WS: closed (code:" + i + "reason: " + str + ")");
                    this.c = 0L;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // tech.sud.a.a.Sudif
        public void c(String str) {
            synchronized (this) {
                try {
                    long j = this.c;
                    if (j != 0) {
                        WebSocket.ontextmessage(j, str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void j() {
            f.c("SudNative WebSocketClient", "destroy:" + this.c);
            synchronized (this) {
                this.c = 0L;
            }
            g();
        }

        @Override // tech.sud.a.a.Sudif
        public void a(ByteBuffer byteBuffer) {
            synchronized (this) {
                try {
                    long j = this.c;
                    if (j != 0) {
                        WebSocket.onbinarymessage(j, byteBuffer.array());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // tech.sud.a.a.Sudif
        public void a(Exception exc) {
            synchronized (this) {
                try {
                    if (exc != null) {
                        f.e("SudNative WebSocketClient", "J: WS: error (exception: " + exc.getMessage() + ")");
                        long j = this.c;
                        if (j != 0) {
                            WebSocket.onerror(j, exc.getMessage());
                        }
                    } else {
                        f.e("SudNative WebSocketClient", "J: WS: error (unknown reason)");
                        long j2 = this.c;
                        if (j2 != 0) {
                            WebSocket.onerror(j2, "");
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
