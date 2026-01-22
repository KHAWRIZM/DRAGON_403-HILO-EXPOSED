package e0;

import Suddo.Sudvoid;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f١٣٧٤٥a;

    /* renamed from: b, reason: collision with root package name */
    public final q f١٣٧٤٦b;

    /* renamed from: c, reason: collision with root package name */
    public final g0 f١٣٧٤٧c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f١٣٧٤٨d;

    /* renamed from: e, reason: collision with root package name */
    public final WeakHashMap f١٣٧٤٩e;

    /* renamed from: f, reason: collision with root package name */
    public final WeakHashMap f١٣٧٥٠f;

    /* renamed from: g, reason: collision with root package name */
    public final LinkedHashSet f١٣٧٥١g;

    /* renamed from: h, reason: collision with root package name */
    public final a0 f١٣٧٥٢h;

    /* renamed from: i, reason: collision with root package name */
    public final Handler f١٣٧٥٣i;

    /* renamed from: j, reason: collision with root package name */
    public final r f١٣٧٥٤j;

    /* renamed from: k, reason: collision with root package name */
    public final p0 f١٣٧٥٥k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f١٣٧٥٦l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f١٣٧٥٧m;

    public c(Context context, q qVar, Handler handler, g0 g0Var, r rVar, p0 p0Var) {
        boolean z10;
        n0 n0Var = new n0();
        n0Var.start();
        Looper looper = n0Var.getLooper();
        StringBuilder sb = u0.f١٣٨٣٥a;
        x xVar = new x(looper);
        xVar.sendMessageDelayed(xVar.obtainMessage(), 1000L);
        this.f١٣٧٤٥a = context;
        this.f١٣٧٤٦b = qVar;
        this.f١٣٧٤٨d = new LinkedHashMap();
        this.f١٣٧٤٩e = new WeakHashMap();
        this.f١٣٧٥٠f = new WeakHashMap();
        this.f١٣٧٥١g = new LinkedHashSet();
        this.f١٣٧٥٢h = new a0(n0Var.getLooper(), this);
        this.f١٣٧٤٧c = g0Var;
        this.f١٣٧٥٣i = handler;
        this.f١٣٧٥٤j = rVar;
        this.f١٣٧٥٥k = p0Var;
        this.f١٣٧٥٦l = new ArrayList(4);
        u0.e(context);
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f١٣٧٥٧m = z10;
        Sudvoid sudvoid = new Sudvoid(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        if (sudvoid.f٣٨a.f١٣٧٥٧m) {
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        sudvoid.f٣٨a.f١٣٧٤٥a.registerReceiver(sudvoid, intentFilter);
    }

    public final void a(d dVar) {
        Future future = dVar.f١٣٧٧٥n;
        if (future != null && future.isCancelled()) {
            return;
        }
        Bitmap bitmap = dVar.f١٣٧٧٤m;
        if (bitmap != null) {
            bitmap.prepareToDraw();
        }
        this.f١٣٧٥٦l.add(dVar);
        if (!this.f١٣٧٥٢h.hasMessages(7)) {
            this.f١٣٧٥٢h.sendEmptyMessageDelayed(7, 200L);
        }
    }

    public final void b(u uVar, boolean z10) {
        d dVar;
        if (this.f١٣٧٥١g.contains(uVar.f١٣٨٣٢f)) {
            this.f١٣٧٥٠f.put(uVar.b(), uVar);
            return;
        }
        d dVar2 = (d) this.f١٣٧٤٨d.get(uVar.f١٣٨٣١e);
        if (dVar2 != null) {
            dVar2.f١٣٧٦٣b.getClass();
            if (dVar2.f١٣٧٧٢k == null) {
                dVar2.f١٣٧٧٢k = uVar;
                return;
            }
            if (dVar2.f١٣٧٧٣l == null) {
                dVar2.f١٣٧٧٣l = new ArrayList(3);
            }
            dVar2.f١٣٧٧٣l.add(uVar);
            int i10 = uVar.f١٣٨٢٨b.f١٣٧٨٥c;
            if (h0.a(i10) > h0.a(dVar2.f١٣٧٨٠s)) {
                dVar2.f١٣٧٨٠s = i10;
                return;
            }
            return;
        }
        if (this.f١٣٧٤٦b.isShutdown()) {
            return;
        }
        b bVar = uVar.f١٣٨٢٧a;
        r rVar = this.f١٣٧٥٤j;
        p0 p0Var = this.f١٣٧٥٥k;
        Object obj = d.f١٣٧٥٨t;
        e0 e0Var = uVar.f١٣٨٢٨b;
        List list = bVar.f١٣٧٣٥a;
        int size = list.size();
        int i11 = 0;
        while (true) {
            if (i11 < size) {
                j0 j0Var = (j0) list.get(i11);
                if (j0Var.d(e0Var)) {
                    dVar = new d(bVar, this, rVar, p0Var, uVar, j0Var);
                    break;
                }
                i11++;
            } else {
                dVar = new d(bVar, this, rVar, p0Var, uVar, d.f١٣٧٦١w);
                break;
            }
        }
        q qVar = this.f١٣٧٤٦b;
        qVar.getClass();
        o oVar = new o(dVar);
        qVar.execute(oVar);
        dVar.f١٣٧٧٥n = oVar;
        this.f١٣٧٤٨d.put(uVar.f١٣٨٣١e, dVar);
        if (z10) {
            this.f١٣٧٤٩e.remove(uVar.b());
        }
    }

    public final void c(d dVar) {
        a0 a0Var = this.f١٣٧٥٢h;
        a0Var.sendMessage(a0Var.obtainMessage(6, dVar));
    }

    public final void d(d dVar) {
        a0 a0Var = this.f١٣٧٥٢h;
        a0Var.sendMessage(a0Var.obtainMessage(4, dVar));
    }
}
