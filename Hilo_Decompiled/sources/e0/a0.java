package e0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Future;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a0 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final c f١٣٧٣٢a;

    public a0(Looper looper, c cVar) {
        super(looper);
        this.f١٣٧٣٢a = cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleMessage(Message message) {
        ArrayList arrayList;
        Future future;
        boolean z10;
        boolean z11;
        Object b10;
        boolean z12;
        ArrayList arrayList2;
        NetworkInfo networkInfo = null;
        ArrayList arrayList3 = null;
        int i10 = 0;
        switch (message.what) {
            case 1:
                this.f١٣٧٣٢a.b((u) message.obj, true);
                return;
            case 2:
                u uVar = (u) message.obj;
                c cVar = this.f١٣٧٣٢a;
                cVar.getClass();
                String str = uVar.f١٣٨٣١e;
                d dVar = (d) cVar.f١٣٧٤٨d.get(str);
                if (dVar != null) {
                    dVar.c(uVar);
                    if (dVar.f١٣٧٧٢k == null && (((arrayList = dVar.f١٣٧٧٣l) == null || arrayList.isEmpty()) && (future = dVar.f١٣٧٧٥n) != null && future.cancel(false))) {
                        i10 = 1;
                    }
                    if (i10 != 0) {
                        cVar.f١٣٧٤٨d.remove(str);
                    }
                }
                if (cVar.f١٣٧٥١g.contains(uVar.f١٣٨٣٢f)) {
                    cVar.f١٣٧٥٠f.remove(uVar.b());
                }
                return;
            case 3:
            case 8:
            default:
                b.f١٣٧٣٣i.post(new t(message));
                return;
            case 4:
                d dVar2 = (d) message.obj;
                c cVar2 = this.f١٣٧٣٢a;
                cVar2.getClass();
                if ((dVar2.f١٣٧٦٩h & 2) == 0) {
                    cVar2.f١٣٧٥٤j.c(dVar2.f١٣٧٦٧f, dVar2.f١٣٧٧٤m);
                }
                cVar2.f١٣٧٤٨d.remove(dVar2.f١٣٧٦٧f);
                cVar2.a(dVar2);
                dVar2.f١٣٧٦٣b.getClass();
                return;
            case 5:
                d dVar3 = (d) message.obj;
                c cVar3 = this.f١٣٧٣٢a;
                cVar3.getClass();
                Future future2 = dVar3.f١٣٧٧٥n;
                if (future2 != null && future2.isCancelled()) {
                    return;
                }
                if (cVar3.f١٣٧٤٦b.isShutdown()) {
                    dVar3.f١٣٧٦٣b.getClass();
                    cVar3.f١٣٧٤٨d.remove(dVar3.f١٣٧٦٧f);
                    cVar3.a(dVar3);
                    return;
                }
                if (cVar3.f١٣٧٥٧m) {
                    Context context = cVar3.f١٣٧٤٥a;
                    StringBuilder sb = u0.f١٣٨٣٥a;
                    networkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
                }
                int i11 = dVar3.f١٣٧٧٩r;
                if (i11 > 0) {
                    dVar3.f١٣٧٧٩r = i11 - 1;
                    z10 = dVar3.f١٣٧٧١j.c(networkInfo);
                } else {
                    z10 = false;
                }
                if (z10) {
                    dVar3.f١٣٧٦٣b.getClass();
                    if (dVar3.f١٣٧٧٧p instanceof s0) {
                        dVar3.f١٣٧٧٠i |= 1;
                    }
                    q qVar = cVar3.f١٣٧٤٦b;
                    qVar.getClass();
                    o oVar = new o(dVar3);
                    qVar.execute(oVar);
                    dVar3.f١٣٧٧٥n = oVar;
                    return;
                }
                if (cVar3.f١٣٧٥٧m) {
                    j0 j0Var = dVar3.f١٣٧٧١j;
                    j0Var.getClass();
                    if (j0Var instanceof b0) {
                        z11 = true;
                        dVar3.f١٣٧٦٣b.getClass();
                        cVar3.f١٣٧٤٨d.remove(dVar3.f١٣٧٦٧f);
                        cVar3.a(dVar3);
                        if (!z11) {
                            u uVar2 = dVar3.f١٣٧٧٢k;
                            if (uVar2 != null && (b10 = uVar2.b()) != null) {
                                uVar2.f١٣٨٣٣g = true;
                                cVar3.f١٣٧٤٩e.put(b10, uVar2);
                            }
                            ArrayList arrayList4 = dVar3.f١٣٧٧٣l;
                            if (arrayList4 != null) {
                                int size = arrayList4.size();
                                while (i10 < size) {
                                    u uVar3 = (u) arrayList4.get(i10);
                                    Object b11 = uVar3.b();
                                    if (b11 != null) {
                                        uVar3.f١٣٨٣٣g = true;
                                        cVar3.f١٣٧٤٩e.put(b11, uVar3);
                                    }
                                    i10++;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                z11 = false;
                dVar3.f١٣٧٦٣b.getClass();
                cVar3.f١٣٧٤٨d.remove(dVar3.f١٣٧٦٧f);
                cVar3.a(dVar3);
                if (!z11) {
                }
                break;
            case 6:
                d dVar4 = (d) message.obj;
                c cVar4 = this.f١٣٧٣٢a;
                cVar4.getClass();
                dVar4.f١٣٧٦٣b.getClass();
                cVar4.f١٣٧٤٨d.remove(dVar4.f١٣٧٦٧f);
                cVar4.a(dVar4);
                return;
            case 7:
                c cVar5 = this.f١٣٧٣٢a;
                cVar5.getClass();
                ArrayList arrayList5 = new ArrayList(cVar5.f١٣٧٥٦l);
                cVar5.f١٣٧٥٦l.clear();
                Handler handler = cVar5.f١٣٧٥٣i;
                handler.sendMessage(handler.obtainMessage(8, arrayList5));
                if (!arrayList5.isEmpty()) {
                    ((d) arrayList5.get(0)).f١٣٧٦٣b.getClass();
                    return;
                }
                return;
            case 9:
                NetworkInfo networkInfo2 = (NetworkInfo) message.obj;
                c cVar6 = this.f١٣٧٣٢a;
                q qVar2 = cVar6.f١٣٧٤٦b;
                if (qVar2 instanceof q) {
                    qVar2.b(networkInfo2);
                }
                if (networkInfo2 != null && networkInfo2.isConnected() && !cVar6.f١٣٧٤٩e.isEmpty()) {
                    Iterator it = cVar6.f١٣٧٤٩e.values().iterator();
                    while (it.hasNext()) {
                        u uVar4 = (u) it.next();
                        it.remove();
                        b bVar = uVar4.f١٣٨٢٧a;
                        cVar6.b(uVar4, false);
                    }
                    return;
                }
                return;
            case 10:
                this.f١٣٧٣٢a.getClass();
                return;
            case 11:
                Object obj = message.obj;
                c cVar7 = this.f١٣٧٣٢a;
                if (cVar7.f١٣٧٥١g.add(obj)) {
                    Iterator it2 = cVar7.f١٣٧٤٨d.values().iterator();
                    while (it2.hasNext()) {
                        d dVar5 = (d) it2.next();
                        dVar5.f١٣٧٦٣b.getClass();
                        u uVar5 = dVar5.f١٣٧٧٢k;
                        ArrayList arrayList6 = dVar5.f١٣٧٧٣l;
                        if (arrayList6 != null && !arrayList6.isEmpty()) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (uVar5 != null || z12) {
                            if (uVar5 != null && uVar5.f١٣٨٣٢f.equals(obj)) {
                                dVar5.c(uVar5);
                                cVar7.f١٣٧٥٠f.put(uVar5.b(), uVar5);
                            }
                            if (z12) {
                                for (int size2 = arrayList6.size() - 1; size2 >= 0; size2--) {
                                    u uVar6 = (u) arrayList6.get(size2);
                                    if (uVar6.f١٣٨٣٢f.equals(obj)) {
                                        dVar5.c(uVar6);
                                        cVar7.f١٣٧٥٠f.put(uVar6.b(), uVar6);
                                    }
                                }
                            }
                            if (dVar5.f١٣٧٧٢k == null && ((arrayList2 = dVar5.f١٣٧٧٣l) == null || arrayList2.isEmpty())) {
                                Future future3 = dVar5.f١٣٧٧٥n;
                                if (future3 != null && future3.cancel(false)) {
                                    it2.remove();
                                }
                            }
                        }
                    }
                    return;
                }
                return;
            case 12:
                Object obj2 = message.obj;
                c cVar8 = this.f١٣٧٣٢a;
                if (cVar8.f١٣٧٥١g.remove(obj2)) {
                    Iterator it3 = cVar8.f١٣٧٥٠f.values().iterator();
                    while (it3.hasNext()) {
                        u uVar7 = (u) it3.next();
                        if (uVar7.f١٣٨٣٢f.equals(obj2)) {
                            if (arrayList3 == null) {
                                arrayList3 = new ArrayList();
                            }
                            arrayList3.add(uVar7);
                            it3.remove();
                        }
                    }
                    if (arrayList3 != null) {
                        Handler handler2 = cVar8.f١٣٧٥٣i;
                        handler2.sendMessage(handler2.obtainMessage(13, arrayList3));
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
