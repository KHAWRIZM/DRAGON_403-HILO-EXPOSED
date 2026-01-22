package z4;

import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private final Set f١٩٤٦٠a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    private final Set f١٩٤٦١b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٩٤٦٢c;

    public boolean a(c5.d dVar) {
        boolean z10 = true;
        if (dVar == null) {
            return true;
        }
        boolean remove = this.f١٩٤٦٠a.remove(dVar);
        if (!this.f١٩٤٦١b.remove(dVar) && !remove) {
            z10 = false;
        }
        if (z10) {
            dVar.clear();
        }
        return z10;
    }

    public void b() {
        Iterator it = f5.l.k(this.f١٩٤٦٠a).iterator();
        while (it.hasNext()) {
            a((c5.d) it.next());
        }
        this.f١٩٤٦١b.clear();
    }

    public void c() {
        this.f١٩٤٦٢c = true;
        for (c5.d dVar : f5.l.k(this.f١٩٤٦٠a)) {
            if (dVar.isRunning() || dVar.g()) {
                dVar.clear();
                this.f١٩٤٦١b.add(dVar);
            }
        }
    }

    public void d() {
        this.f١٩٤٦٢c = true;
        for (c5.d dVar : f5.l.k(this.f١٩٤٦٠a)) {
            if (dVar.isRunning()) {
                dVar.pause();
                this.f١٩٤٦١b.add(dVar);
            }
        }
    }

    public void e() {
        for (c5.d dVar : f5.l.k(this.f١٩٤٦٠a)) {
            if (!dVar.g() && !dVar.e()) {
                dVar.clear();
                if (!this.f١٩٤٦٢c) {
                    dVar.j();
                } else {
                    this.f١٩٤٦١b.add(dVar);
                }
            }
        }
    }

    public void f() {
        this.f١٩٤٦٢c = false;
        for (c5.d dVar : f5.l.k(this.f١٩٤٦٠a)) {
            if (!dVar.g() && !dVar.isRunning()) {
                dVar.j();
            }
        }
        this.f١٩٤٦١b.clear();
    }

    public void g(c5.d dVar) {
        this.f١٩٤٦٠a.add(dVar);
        if (!this.f١٩٤٦٢c) {
            dVar.j();
            return;
        }
        dVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f١٩٤٦١b.add(dVar);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f١٩٤٦٠a.size() + ", isPaused=" + this.f١٩٤٦٢c + "}";
    }
}
