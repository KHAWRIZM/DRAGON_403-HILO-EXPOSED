package e0;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class i0 extends Handler {
    public i0(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        boolean z10;
        Bitmap bitmap;
        int i10 = message.what;
        if (i10 != 3) {
            if (i10 != 8) {
                if (i10 == 13) {
                    List list = (List) message.obj;
                    int size = list.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        u uVar = (u) list.get(i11);
                        b bVar = uVar.f١٣٨٢٧a;
                        if ((uVar.f١٣٨٣٠d & 1) == 0) {
                            bitmap = bVar.f١٣٧٣٨d.b(uVar.f١٣٨٣١e);
                            if (bitmap != null) {
                                bVar.f١٣٧٣٩e.f١٣٨٠٩b.sendEmptyMessage(0);
                            } else {
                                bVar.f١٣٧٣٩e.f١٣٨٠٩b.sendEmptyMessage(1);
                            }
                        } else {
                            bitmap = null;
                        }
                        if (bitmap != null) {
                            bVar.a(bitmap, 1, uVar, null);
                        } else {
                            Object b10 = uVar.b();
                            if (b10 != null && bVar.f١٣٧٤٠f.get(b10) != uVar) {
                                bVar.b(b10);
                                bVar.f١٣٧٤٠f.put(b10, uVar);
                            }
                            a0 a0Var = bVar.f١٣٧٣٧c.f١٣٧٥٢h;
                            a0Var.sendMessage(a0Var.obtainMessage(1, uVar));
                        }
                    }
                    return;
                }
                throw new AssertionError("Unknown handler message received: " + message.what);
            }
            List list2 = (List) message.obj;
            int size2 = list2.size();
            for (int i12 = 0; i12 < size2; i12++) {
                d dVar = (d) list2.get(i12);
                b bVar2 = dVar.f١٣٧٦٣b;
                bVar2.getClass();
                u uVar2 = dVar.f١٣٧٧٢k;
                ArrayList arrayList = dVar.f١٣٧٧٣l;
                if (arrayList != null && !arrayList.isEmpty()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (uVar2 != null || z10) {
                    Uri uri = dVar.f١٣٧٦٨g.f١٣٧٨٣a;
                    Exception exc = dVar.f١٣٧٧٧p;
                    Bitmap bitmap2 = dVar.f١٣٧٧٤m;
                    int i13 = dVar.f١٣٧٧٦o;
                    if (uVar2 != null) {
                        bVar2.a(bitmap2, i13, uVar2, exc);
                    }
                    if (z10) {
                        int size3 = arrayList.size();
                        for (int i14 = 0; i14 < size3; i14++) {
                            bVar2.a(bitmap2, i13, (u) arrayList.get(i14), exc);
                        }
                    }
                }
            }
            return;
        }
        u uVar3 = (u) message.obj;
        uVar3.f١٣٨٢٧a.b(uVar3.b());
    }
}
