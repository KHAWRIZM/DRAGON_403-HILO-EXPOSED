package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import f2.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private b.a f٢٧٣١a = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a extends b.a {
        a() {
        }

        @Override // f2.b
        public void b(f2.a aVar) {
            if (aVar == null) {
                return;
            }
            UnusedAppRestrictionsBackportService.this.a(new c(aVar));
        }
    }

    protected abstract void a(c cVar);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f٢٧٣١a;
    }
}
