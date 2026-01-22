package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.appcompat.app.a0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class a {

    /* renamed from: c, reason: collision with root package name */
    private static a f١٠٠١١c;

    /* renamed from: a, reason: collision with root package name */
    private final Object f١٠٠١٢a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final Handler f١٠٠١٣b = new Handler(Looper.getMainLooper(), new C٠١١٩a());

    /* renamed from: com.google.android.material.snackbar.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class C٠١١٩a implements Handler.Callback {
        C٠١١٩a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            a aVar = a.this;
            a0.a(message.obj);
            aVar.c(null);
            return true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    interface b {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c {
    }

    private a() {
    }

    private boolean a(c cVar, int i10) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a b() {
        if (f١٠٠١١c == null) {
            f١٠٠١١c = new a();
        }
        return f١٠٠١١c;
    }

    private boolean d(b bVar) {
        return false;
    }

    void c(c cVar) {
        synchronized (this.f١٠٠١٢a) {
            a(cVar, 2);
        }
    }

    public void e(b bVar) {
        synchronized (this.f١٠٠١٢a) {
            try {
                if (d(bVar)) {
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(b bVar) {
        synchronized (this.f١٠٠١٢a) {
            try {
                if (d(bVar)) {
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
