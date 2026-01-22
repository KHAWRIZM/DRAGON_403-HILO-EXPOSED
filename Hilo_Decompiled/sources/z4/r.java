package z4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import f5.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import z4.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class r {

    /* renamed from: d, reason: collision with root package name */
    private static volatile r f١٩٤٦٣d;

    /* renamed from: a, reason: collision with root package name */
    private final c f١٩٤٦٤a;

    /* renamed from: b, reason: collision with root package name */
    final Set f١٩٤٦٥b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٩٤٦٦c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements f.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f١٩٤٦٧a;

        a(Context context) {
            this.f١٩٤٦٧a = context;
        }

        @Override // f5.f.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConnectivityManager get() {
            return (ConnectivityManager) this.f١٩٤٦٧a.getSystemService("connectivity");
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b implements b.a {
        b() {
        }

        @Override // z4.b.a
        public void a(boolean z10) {
            ArrayList arrayList;
            f5.l.b();
            synchronized (r.this) {
                arrayList = new ArrayList(r.this.f١٩٤٦٥b);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((b.a) it.next()).a(z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface c {
        boolean register();

        void unregister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class d implements c {

        /* renamed from: a, reason: collision with root package name */
        boolean f١٩٤٧٠a;

        /* renamed from: b, reason: collision with root package name */
        final b.a f١٩٤٧١b;

        /* renamed from: c, reason: collision with root package name */
        private final f.b f١٩٤٧٢c;

        /* renamed from: d, reason: collision with root package name */
        private final ConnectivityManager.NetworkCallback f١٩٤٧٣d = new a();

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends ConnectivityManager.NetworkCallback {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: z4.r$d$a$a, reason: collision with other inner class name */
            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            public class RunnableC٠٢٥٦a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ boolean f١٩٤٧٥a;

                RunnableC٠٢٥٦a(boolean z10) {
                    this.f١٩٤٧٥a = z10;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(this.f١٩٤٧٥a);
                }
            }

            a() {
            }

            private void b(boolean z10) {
                f5.l.w(new RunnableC٠٢٥٦a(z10));
            }

            void a(boolean z10) {
                f5.l.b();
                d dVar = d.this;
                boolean z11 = dVar.f١٩٤٧٠a;
                dVar.f١٩٤٧٠a = z10;
                if (z11 != z10) {
                    dVar.f١٩٤٧١b.a(z10);
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                b(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                b(false);
            }
        }

        d(f.b bVar, b.a aVar) {
            this.f١٩٤٧٢c = bVar;
            this.f١٩٤٧١b = aVar;
        }

        @Override // z4.r.c
        public boolean register() {
            Network activeNetwork;
            boolean z10;
            activeNetwork = ((ConnectivityManager) this.f١٩٤٧٢c.get()).getActiveNetwork();
            if (activeNetwork != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f١٩٤٧٠a = z10;
            try {
                ((ConnectivityManager) this.f١٩٤٧٢c.get()).registerDefaultNetworkCallback(this.f١٩٤٧٣d);
                return true;
            } catch (RuntimeException e10) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register callback", e10);
                }
                return false;
            }
        }

        @Override // z4.r.c
        public void unregister() {
            ((ConnectivityManager) this.f١٩٤٧٢c.get()).unregisterNetworkCallback(this.f١٩٤٧٣d);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class e implements c {

        /* renamed from: g, reason: collision with root package name */
        static final Executor f١٩٤٧٧g = AsyncTask.SERIAL_EXECUTOR;

        /* renamed from: a, reason: collision with root package name */
        final Context f١٩٤٧٨a;

        /* renamed from: b, reason: collision with root package name */
        final b.a f١٩٤٧٩b;

        /* renamed from: c, reason: collision with root package name */
        private final f.b f١٩٤٨٠c;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f١٩٤٨١d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f١٩٤٨٢e;

        /* renamed from: f, reason: collision with root package name */
        final BroadcastReceiver f١٩٤٨٣f = new a();

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                e.this.c();
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f١٩٤٨١d = eVar.a();
                try {
                    e eVar2 = e.this;
                    eVar2.f١٩٤٧٨a.registerReceiver(eVar2.f١٩٤٨٣f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    e.this.f١٩٤٨٢e = true;
                } catch (SecurityException e10) {
                    if (Log.isLoggable("ConnectivityMonitor", 5)) {
                        Log.w("ConnectivityMonitor", "Failed to register", e10);
                    }
                    e.this.f١٩٤٨٢e = false;
                }
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!e.this.f١٩٤٨٢e) {
                    return;
                }
                e.this.f١٩٤٨٢e = false;
                e eVar = e.this;
                eVar.f١٩٤٧٨a.unregisterReceiver(eVar.f١٩٤٨٣f);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z10 = e.this.f١٩٤٨١d;
                e eVar = e.this;
                eVar.f١٩٤٨١d = eVar.a();
                if (z10 != e.this.f١٩٤٨١d) {
                    if (Log.isLoggable("ConnectivityMonitor", 3)) {
                        Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + e.this.f١٩٤٨١d);
                    }
                    e eVar2 = e.this;
                    eVar2.b(eVar2.f١٩٤٨١d);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: z4.r$e$e, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public class RunnableC٠٢٥٧e implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f١٩٤٨٨a;

            RunnableC٠٢٥٧e(boolean z10) {
                this.f١٩٤٨٨a = z10;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f١٩٤٧٩b.a(this.f١٩٤٨٨a);
            }
        }

        e(Context context, f.b bVar, b.a aVar) {
            this.f١٩٤٧٨a = context.getApplicationContext();
            this.f١٩٤٨٠c = bVar;
            this.f١٩٤٧٩b = aVar;
        }

        boolean a() {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f١٩٤٨٠c.get()).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    return true;
                }
                return false;
            } catch (RuntimeException e10) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e10);
                }
                return true;
            }
        }

        void b(boolean z10) {
            f5.l.w(new RunnableC٠٢٥٧e(z10));
        }

        void c() {
            f١٩٤٧٧g.execute(new d());
        }

        @Override // z4.r.c
        public boolean register() {
            f١٩٤٧٧g.execute(new b());
            return true;
        }

        @Override // z4.r.c
        public void unregister() {
            f١٩٤٧٧g.execute(new c());
        }
    }

    private r(Context context) {
        c eVar;
        f.b a10 = f5.f.a(new a(context));
        b bVar = new b();
        if (Build.VERSION.SDK_INT >= 24) {
            eVar = new d(a10, bVar);
        } else {
            eVar = new e(context, a10, bVar);
        }
        this.f١٩٤٦٤a = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r a(Context context) {
        if (f١٩٤٦٣d == null) {
            synchronized (r.class) {
                try {
                    if (f١٩٤٦٣d == null) {
                        f١٩٤٦٣d = new r(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f١٩٤٦٣d;
    }

    private void b() {
        if (!this.f١٩٤٦٦c && !this.f١٩٤٦٥b.isEmpty()) {
            this.f١٩٤٦٦c = this.f١٩٤٦٤a.register();
        }
    }

    private void c() {
        if (this.f١٩٤٦٦c && this.f١٩٤٦٥b.isEmpty()) {
            this.f١٩٤٦٤a.unregister();
            this.f١٩٤٦٦c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(b.a aVar) {
        this.f١٩٤٦٥b.add(aVar);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void e(b.a aVar) {
        this.f١٩٤٦٥b.remove(aVar);
        c();
    }
}
