package j0;

import java.util.ArrayList;
import tech.sud.gip.core.GameInfo;
import tech.sud.gip.core.ISudListenerPreloadMGPkg;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class l {

    /* renamed from: i, reason: collision with root package name */
    public static final String f١٥٠٩٣i = "SudGIP ".concat(l.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    public final long f١٥٠٩٤a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f١٥٠٩٥b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public boolean f١٥٠٩٦c = false;

    /* renamed from: d, reason: collision with root package name */
    public final id.a f١٥٠٩٧d;

    /* renamed from: e, reason: collision with root package name */
    public final xe.a f١٥٠٩٨e;

    /* renamed from: f, reason: collision with root package name */
    public long f١٥٠٩٩f;

    /* renamed from: g, reason: collision with root package name */
    public long f١٥١٠٠g;

    /* renamed from: h, reason: collision with root package name */
    public u f١٥١٠١h;

    public l(long j10) {
        this.f١٥٠٩٤a = j10;
        gd.a aVar = gd.a.c;
        if (aVar != null) {
            this.f١٥٠٩٧d = aVar.b;
            this.f١٥٠٩٨e = aVar.a;
            return;
        }
        throw new IllegalStateException("SudGameRuntime hasn't been initialized");
    }

    public final void a(int i10, String str) {
        ArrayList arrayList = this.f١٥٠٩٥b;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            ((ISudListenerPreloadMGPkg) obj).onPreloadFailure(this.f١٥٠٩٤a, i10, str);
        }
        this.f١٥٠٩٦c = false;
        this.f١٥٠٩٥b.clear();
        u uVar = this.f١٥١٠١h;
        if (uVar != null) {
            uVar.f١٥١٢٧a.f١٥١٢٩a.remove(Long.valueOf(this.f١٥٠٩٤a));
        }
    }

    public final void b(final GameInfo gameInfo) {
        xe.a aVar = this.f١٥٠٩٨e;
        int i10 = gameInfo.engine;
        long j10 = gameInfo.mgId;
        String str = gameInfo.version;
        re.b bVar = new re.b() { // from class: j0.k
            @Override // re.b
            public final void a(boolean z10, String str2, boolean z11) {
                l.this.c(gameInfo, z10, str2, z11);
            }
        };
        if (1 == i10) {
            aVar.a.d(i10, j10, str, bVar);
        } else if (5 == i10) {
            aVar.b.d(i10, j10, str, bVar);
        } else {
            aVar.getClass();
        }
    }

    public final void c(GameInfo gameInfo, boolean z10, String str, boolean z11) {
        String str2;
        if (this.f١٥٠٩٦c) {
            String str3 = f١٥٠٩٣i;
            SudLogger.d(str3, "preload isGameInstalled isInstalled=" + z10);
            if (z10) {
                LogUtils.file("SudGamePkgPreloadTask", "preload gamepackage is installed");
                SudLogger.d(str3, "preload gamepackage is installed");
                ArrayList arrayList = this.f١٥٠٩٥b;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((ISudListenerPreloadMGPkg) obj).onPreloadSuccess(this.f١٥٠٩٤a);
                }
                this.f١٥٠٩٦c = false;
                this.f١٥٠٩٥b.clear();
                u uVar = this.f١٥١٠١h;
                if (uVar != null) {
                    uVar.f١٥١٢٧a.f١٥١٢٩a.remove(Long.valueOf(this.f١٥٠٩٤a));
                    return;
                }
                return;
            }
            if (1 == gameInfo.engine) {
                str2 = gameInfo.eUrl;
            } else {
                str2 = "";
            }
            if (str2 != null && !str2.isEmpty()) {
                t.c cVar = new t.c();
                cVar.f١٧٩٣٤a = gameInfo.engine;
                cVar.f١٧٩٣٥b = t.b.PreloadPackageGamePackage;
                cVar.f١٧٩٣٦c = gameInfo.mgId;
                cVar.f١٧٩٣٧d = str2;
                cVar.f١٧٩٣٨e = gameInfo.version;
                cVar.f١٧٩٣٩f = gameInfo.hash;
                f.a aVar = new f.a("checkoutGamePkg");
                aVar.f١٤٠٠٧j.put("engine", Integer.valueOf(gameInfo.engine));
                aVar.f١٤٠٠٧j.put("package_type", 4);
                aVar.f١٤٠٠٤g = String.valueOf(gameInfo.mgId);
                xe.a aVar2 = this.f١٥٠٩٨e;
                j jVar = new j(this, aVar);
                aVar2.getClass();
                int i11 = cVar.f١٧٩٣٤a;
                if (1 == i11) {
                    aVar2.a.a(cVar, jVar);
                    return;
                } else {
                    if (5 == i11) {
                        aVar2.b.a(cVar, jVar);
                        return;
                    }
                    return;
                }
            }
            a(-1, "null == gameInfo.eUrl || gameInfo.eUrl.isEmpty()");
        }
    }
}
