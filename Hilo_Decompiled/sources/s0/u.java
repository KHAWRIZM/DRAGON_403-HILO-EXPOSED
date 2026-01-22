package s0;

import android.content.Context;
import tech.sud.gip.core.GameInfo;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class u implements j {

    /* renamed from: f, reason: collision with root package name */
    public static final String f١٧٦٠٠f = "SudGIP ".concat(u.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    public final o f١٧٦٠١a;

    /* renamed from: b, reason: collision with root package name */
    public final id.a f١٧٦٠٢b;

    /* renamed from: c, reason: collision with root package name */
    public GameInfo f١٧٦٠٣c;

    /* renamed from: d, reason: collision with root package name */
    public final long f١٧٦٠٤d = 0;

    /* renamed from: e, reason: collision with root package name */
    public boolean f١٧٦٠٥e = false;

    public u(Context context, gd.a aVar, o oVar) {
        new n(this);
        new q(this);
        this.f١٧٦٠١a = oVar;
        this.f١٧٦٠٢b = aVar.b;
    }

    @Override // s0.j
    public final void a(GameInfo gameInfo, int i10, String str) {
        this.f١٧٦٠٥e = false;
        if (gameInfo == null) {
            this.f١٧٦٠١a.b(2, -1, "gameInfo params cannot be null");
            return;
        }
        this.f١٧٦٠٣c = gameInfo;
        id.a aVar = this.f١٧٦٠٢b;
        int i11 = gameInfo.engine;
        s sVar = new s(this);
        if (1 == i11) {
            aVar.a.b(i11, sVar);
            return;
        }
        if (5 == i11) {
            aVar.b.b(i11, sVar);
            return;
        }
        aVar.getClass();
        sVar.a("不支持engine=" + i11);
    }

    @Override // s0.j
    public final void cancel() {
        this.f١٧٦٠٥e = true;
        GameInfo gameInfo = this.f١٧٦٠٣c;
        if (gameInfo != null) {
            id.a aVar = this.f١٧٦٠٢b;
            int i10 = gameInfo.engine;
            long j10 = this.f١٧٦٠٤d;
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
