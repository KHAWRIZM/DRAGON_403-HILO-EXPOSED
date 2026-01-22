package g0;

import java.io.IOException;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f١٤٣٧٤a;

    public i(b bVar) {
        this.f١٤٣٧٤a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f١٤٣٧٤a;
        synchronized (bVar) {
            ArrayList arrayList = bVar.f١٤٣٦١u;
            if (arrayList != null && !bVar.f١٤٣٤٥e) {
                bVar.f١٤٣٤٥e = true;
                bVar.f١٤٣٦٠t.addAll(arrayList);
                int i10 = 0;
                try {
                    if (bVar.f١٤٣٤٣c.get() <= 0) {
                        ArrayList arrayList2 = bVar.f١٤٣٦١u;
                        int size = arrayList2.size();
                        while (i10 < size) {
                            Object obj = arrayList2.get(i10);
                            i10++;
                            try {
                                bVar.b(((Integer) obj).intValue());
                            } catch (IOException e10) {
                                int i11 = bVar.f١٤٣٥٠j.f١٦١١٣b;
                                e10.toString();
                            }
                        }
                        bVar.f١٤٣٥١k.e(bVar.f١٤٣٥٠j.f١٦١١٣b, 3);
                        return;
                    }
                    if (bVar.f١٤٣٥٤n != null && !bVar.f١٤٣٥٤n.isDone()) {
                        if (bVar.f١٤٣٥٨r == null && bVar.f١٤٣٥٠j.h() != null) {
                            bVar.f١٤٣٥٨r = bVar.f١٤٣٥٠j.h().getAbsolutePath();
                        }
                        n0.f.a().f١٦١٤٢f.f١٤٣٦٥a.c(bVar.f١٤٣٥٨r);
                        try {
                            bVar.c(-1, true);
                            n0.f.a().f١٦١٤٢f.f١٤٣٦٥a.a(bVar.f١٤٣٥٨r);
                        } catch (Throwable th) {
                            n0.f.a().f١٦١٤٢f.f١٤٣٦٥a.a(bVar.f١٤٣٥٨r);
                            throw th;
                        }
                    }
                    ArrayList arrayList3 = bVar.f١٤٣٦١u;
                    int size2 = arrayList3.size();
                    while (i10 < size2) {
                        Object obj2 = arrayList3.get(i10);
                        i10++;
                        try {
                            bVar.b(((Integer) obj2).intValue());
                        } catch (IOException e11) {
                            int i12 = bVar.f١٤٣٥٠j.f١٦١١٣b;
                            e11.toString();
                        }
                    }
                    bVar.f١٤٣٥١k.e(bVar.f١٤٣٥٠j.f١٦١١٣b, 3);
                    return;
                } finally {
                }
            }
        }
    }
}
