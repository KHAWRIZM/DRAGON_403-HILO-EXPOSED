package qd;

import fe.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class e implements nd.c, nd.d {

    /* renamed from: a, reason: collision with root package name */
    List f١٧٢٦٨a;

    /* renamed from: b, reason: collision with root package name */
    volatile boolean f١٧٢٦٩b;

    @Override // nd.d
    public boolean a(nd.c cVar) {
        Objects.requireNonNull(cVar, "d is null");
        if (!this.f١٧٢٦٩b) {
            synchronized (this) {
                try {
                    if (!this.f١٧٢٦٩b) {
                        List list = this.f١٧٢٦٨a;
                        if (list == null) {
                            list = new LinkedList();
                            this.f١٧٢٦٨a = list;
                        }
                        list.add(cVar);
                        return true;
                    }
                } finally {
                }
            }
        }
        cVar.dispose();
        return false;
    }

    @Override // nd.d
    public boolean b(nd.c cVar) {
        if (c(cVar)) {
            cVar.dispose();
            return true;
        }
        return false;
    }

    @Override // nd.d
    public boolean c(nd.c cVar) {
        Objects.requireNonNull(cVar, "Disposable item is null");
        if (this.f١٧٢٦٩b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f١٧٢٦٩b) {
                    return false;
                }
                List list = this.f١٧٢٦٨a;
                if (list != null && list.remove(cVar)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    void d(List list) {
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                ((nd.c) it.next()).dispose();
            } catch (Throwable th) {
                od.b.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw j.g((Throwable) arrayList.get(0));
            }
            throw new od.a(arrayList);
        }
    }

    @Override // nd.c
    public void dispose() {
        if (this.f١٧٢٦٩b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f١٧٢٦٩b) {
                    return;
                }
                this.f١٧٢٦٩b = true;
                List list = this.f١٧٢٦٨a;
                this.f١٧٢٦٨a = null;
                d(list);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // nd.c
    public boolean isDisposed() {
        return this.f١٧٢٦٩b;
    }
}
