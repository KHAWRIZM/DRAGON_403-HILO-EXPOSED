package pf;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import tech.sud.gip.core.ISudFSMMG;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class u implements h {
    public static final String n = "SudGIP ".concat(u.class.getSimpleName());
    public final Context b;
    public WeakReference c;
    public q0.a m;
    public final HashMap a = new HashMap();
    public String d = "";
    public String e = "";
    public String f = "";
    public long g = 0;
    public String h = "{}";
    public String i = "{}";
    public final HashMap j = new HashMap();
    public final HashMap k = new HashMap();
    public final HashMap l = new HashMap();

    public u(Context context) {
        this.b = context;
    }

    public final void a(String str, String str2, String str3, String str4, g1.a aVar) {
        if (str.equals("game")) {
            this.j.put(str3, str4);
            ISudFSMMG iSudFSMMG = (ISudFSMMG) this.c.get();
            if (iSudFSMMG != null) {
                iSudFSMMG.onGameStateChange(aVar, str3, str4);
                return;
            }
            return;
        }
        Map map = (Map) this.k.get(str2);
        if (map == null) {
            map = new HashMap();
            this.k.put(str2, map);
        }
        map.put(str3, str4);
        ISudFSMMG iSudFSMMG2 = (ISudFSMMG) this.c.get();
        if (iSudFSMMG2 != null) {
            iSudFSMMG2.onPlayerStateChange(aVar, str2, str3, str4);
        }
    }

    public final void b(k1.c cVar) {
        q0.a aVar = this.m;
        if (aVar != null) {
            y0.e eVar = aVar.b.w;
            if (!eVar.m.contains(cVar)) {
                eVar.m.add(cVar);
            }
        }
    }
}
