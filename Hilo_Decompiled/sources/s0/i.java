package s0;

import android.content.Context;
import tech.sud.gip.core.GameInfo;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class i implements j {

    /* renamed from: j, reason: collision with root package name */
    public static final String f١٧٥٦٨j = "SudGIP ".concat(i.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    public final Context f١٧٥٦٩a;

    /* renamed from: b, reason: collision with root package name */
    public GameInfo f١٧٥٧٠b;

    /* renamed from: c, reason: collision with root package name */
    public final o f١٧٥٧١c;

    /* renamed from: d, reason: collision with root package name */
    public final xe.a f١٧٥٧٢d;

    /* renamed from: e, reason: collision with root package name */
    public long f١٧٥٧٣e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f١٧٥٧٤f = false;

    /* renamed from: g, reason: collision with root package name */
    public long f١٧٥٧٥g = 0;

    /* renamed from: h, reason: collision with root package name */
    public final a f١٧٥٧٦h = new a(this);

    /* renamed from: i, reason: collision with root package name */
    public final f f١٧٥٧٧i = new f(this);

    public i(Context context, gd.a aVar, o oVar) {
        this.f١٧٥٦٩a = context;
        this.f١٧٥٧٢d = aVar.a;
        this.f١٧٥٧١c = oVar;
    }

    @Override // s0.j
    public final void a(GameInfo gameInfo, int i10, String str) {
        String str2;
        long j10;
        this.f١٧٥٧٤f = false;
        if (gameInfo == null) {
            this.f١٧٥٧١c.b(3, -1, "null == gameInfo");
            return;
        }
        this.f١٧٥٧٠b = gameInfo;
        this.f١٧٥٧٥g = gameInfo.mgId;
        if (gameInfo.isInstalled) {
            this.f١٧٥٧١c.a(3);
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
            cVar.f١٧٩٣٥b = t.b.LoadMGPackageGamePackage;
            cVar.f١٧٩٣٦c = gameInfo.mgId;
            cVar.f١٧٩٣٧d = str2;
            cVar.f١٧٩٣٨e = gameInfo.version;
            cVar.f١٧٩٣٩f = gameInfo.hash;
            xe.a aVar = this.f١٧٥٧٢d;
            a aVar2 = this.f١٧٥٧٦h;
            aVar.getClass();
            int i11 = cVar.f١٧٩٣٤a;
            if (1 == i11) {
                j10 = aVar.a.a(cVar, aVar2);
            } else if (5 == i11) {
                j10 = aVar.b.a(cVar, aVar2);
            } else {
                j10 = 0;
            }
            this.f١٧٥٧٣e = j10;
            return;
        }
        this.f١٧٥٧١c.b(3, -1, "null == gameInfo.eUrl || gameInfo.eUrl.isEmpty()");
    }

    @Override // s0.j
    public final void cancel() {
        this.f١٧٥٧٤f = true;
        GameInfo gameInfo = this.f١٧٥٧٠b;
        if (gameInfo != null) {
            xe.a aVar = this.f١٧٥٧٢d;
            int i10 = gameInfo.engine;
            long j10 = this.f١٧٥٧٣e;
            if (1 == i10) {
                aVar.a.getClass();
                String str = j0.e.f١٥٠٧٩d;
                j0.b.f١٥٠٥٧a.e(j10);
            } else {
                if (5 == i10) {
                    aVar.b.getClass();
                    String str2 = j0.e.f١٥٠٧٩d;
                    j0.b.f١٥٠٥٧a.e(j10);
                    return;
                }
                aVar.getClass();
            }
        }
    }
}
