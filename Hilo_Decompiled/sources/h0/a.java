package h0;

import java.util.HashMap;
import java.util.Map;
import tech.sud.gip.core.ISudCfg;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a implements ISudCfg {

    /* renamed from: a, reason: collision with root package name */
    public boolean f١٤٤٨٣a = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f١٤٤٨٤b = false;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f١٤٤٨٥c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f١٤٤٨٦d = new HashMap();

    public final void addEmbeddedMGPkg(long j10, String str) {
        this.f١٤٤٨٥c.put(Long.valueOf(j10), str);
        mf.a aVar = (mf.a) mf.b.a.a.get(Long.valueOf(j10));
        if (aVar != null && !aVar.b) {
            aVar.a = true;
        }
    }

    public final Map getAdvancedConfigMap() {
        return this.f١٤٤٨٦d;
    }

    public final String getEmbeddedMGPkgPath(long j10) {
        return (String) this.f١٤٤٨٥c.get(Long.valueOf(j10));
    }

    public final boolean getShowCustomLoading() {
        return this.f١٤٤٨٤b;
    }

    public final boolean getShowLoadingGameBg() {
        return this.f١٤٤٨٣a;
    }

    public final void removeEmbeddedMGPkg(long j10) {
        this.f١٤٤٨٥c.remove(Long.valueOf(j10));
    }

    public final void setShowCustomLoading(boolean z10) {
        this.f١٤٤٨٤b = z10;
    }

    public final void setShowLoadingGameBg(boolean z10) {
        this.f١٤٤٨٣a = z10;
    }
}
