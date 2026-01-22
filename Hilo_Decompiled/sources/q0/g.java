package q0;

import java.util.ArrayList;
import org.json.JSONObject;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f١٧٠٨٠a;

    public g(a aVar) {
        this.f١٧٠٨٠a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g1.h hVar;
        ArrayList arrayList;
        long j10;
        c cVar = this.f١٧٠٨٠a.f١٧٠٤٨b;
        LogUtils.file("ProxySudFSTAPPImpl", "游戏窗口被移除之后又重新添加了执行：exeGameViewAttachedToWindowReload");
        if (!cVar.f١٧٠٦١k) {
            d1.d dVar = cVar.f١٧٠٦٣m;
            if (dVar instanceof g1.h) {
                hVar = (g1.h) dVar;
            } else {
                hVar = null;
            }
            if (hVar == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("onGameViewAttachedToWindowReload", 1);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            s0.e eVar = cVar.f١٧٠٦٦p;
            if (eVar == null) {
                cVar.f١٧٠٧٣w.d("checkoutGamePackage", 80, jSONObject);
            } else {
                eVar.b(3, jSONObject);
            }
            y0.e eVar2 = cVar.f١٧٠٧٣w;
            if (eVar2.f١٩٠٥٨a != null && eVar2.f١٩٠٥٩b != null) {
                eVar2.e(true);
                if (eVar2.f١٩٠٥٨a != null && (arrayList = eVar2.f١٩٠٥٩b) != null) {
                    int size = arrayList.size();
                    int i10 = 0;
                    long j11 = 0;
                    while (i10 < size) {
                        Object obj = arrayList.get(i10);
                        i10++;
                        k1.a aVar = (k1.a) obj;
                        int i11 = aVar.f١٥٤٠٨b;
                        if (i11 > 80) {
                            j10 = aVar.f١٥٤١٠d;
                        } else if (i11 == 80 && j11 > 0) {
                            j10 = aVar.f١٥٤١٠d;
                        }
                        j11 += j10;
                    }
                    eVar2.f١٩٠٥٨a.f١٤٠١٨u = Long.valueOf(j11);
                }
            }
            hVar.c(cVar.f١٧٠٧٤x, cVar.f١٧٠٧٥y);
        }
    }
}
