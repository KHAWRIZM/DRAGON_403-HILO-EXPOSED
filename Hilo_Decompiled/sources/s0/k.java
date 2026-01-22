package s0;

import android.content.Context;
import android.os.Looper;
import qf.x;
import tech.sud.gip.R;
import tech.sud.gip.core.GameInfo;
import tech.sud.gip.core.SudLoadMGParamModel;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class k implements j {

    /* renamed from: g, reason: collision with root package name */
    public static final String f١٧٥٧٨g = "SudGIP ".concat(k.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    public final o f١٧٥٧٩a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f١٧٥٨٠b;

    /* renamed from: c, reason: collision with root package name */
    public final xe.a f١٧٥٨١c;

    /* renamed from: d, reason: collision with root package name */
    public GameInfo f١٧٥٨٢d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f١٧٥٨٣e = false;

    /* renamed from: f, reason: collision with root package name */
    public final SudLoadMGParamModel f١٧٥٨٤f;

    public k(Context context, SudLoadMGParamModel sudLoadMGParamModel, gd.a aVar, o oVar) {
        this.f١٧٥٨٠b = context;
        this.f١٧٥٨٤f = sudLoadMGParamModel;
        this.f١٧٥٧٩a = oVar;
        this.f١٧٥٨١c = aVar.a;
    }

    @Override // s0.j
    public final void a(GameInfo gameInfo, int i10, String str) {
        long j10;
        this.f١٧٥٨٣e = false;
        this.f١٧٥٧٩a.c(this.f١٧٥٨٠b.getString(R.string.fsm_mgp_game_loading_stage_get_mginfo));
        long j11 = gameInfo.mgId;
        h hVar = new h(this);
        if (i10 == 0) {
            String str2 = this.f١٧٥٨٤f.roomId;
            String str3 = e.d.f١٣٧١٨a;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                x xVar = e.d.f١٣٧١٩b;
                if (!xVar.a) {
                    hVar.onFailure(-10103, "Please call initSDK first successfully");
                    return;
                }
                GameInfo gameInfo2 = (GameInfo) xVar.o.get(Long.valueOf(j11));
                if (gameInfo2 != null) {
                    j10 = gameInfo2.clientVersion;
                } else {
                    j10 = 0;
                }
                qf.i.c.execute(new qf.d(xVar, j11, xVar.i, j10, str2, hVar));
                return;
            }
            hVar.onFailure(-1, "Please call on UI or Main thread");
            return;
        }
        if (1 == i10) {
            String str4 = this.f١٧٥٨٤f.roomId;
            String str5 = e.d.f١٣٧١٨a;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                x xVar2 = e.d.f١٣٧١٩b;
                if (!xVar2.a) {
                    hVar.onFailure(-10103, "Please call initSDK first successfully");
                    return;
                } else {
                    qf.i.c.execute(new qf.h(xVar2, j11, xVar2.i, str, str4, hVar));
                    return;
                }
            }
            hVar.onFailure(-1, "Please call on UI or Main thread");
            return;
        }
        LogUtils.file("SudGameLoadingStageGetMGInfo", "getMGInfo not support loadMgMode=" + i10);
        SudLogger.e(f١٧٥٧٨g, "getMGInfo not support loadMgMode=" + i10);
    }

    @Override // s0.j
    public final void cancel() {
        this.f١٧٥٨٣e = true;
    }
}
