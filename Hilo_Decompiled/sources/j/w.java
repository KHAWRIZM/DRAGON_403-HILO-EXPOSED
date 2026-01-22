package j;

import org.json.JSONException;
import org.json.JSONObject;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;
import tech.sud.runtime.a.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class w implements a.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f١٥٠٥٤a;

    public w(d dVar) {
        this.f١٥٠٥٤a = dVar;
    }

    public final void a(String str) {
        try {
            if (new JSONObject(str).optString("state").equals("running") && this.f١٥٠٥٤a.f١٤٩٩٣h != null) {
                LogUtils.file("SUDRealSudFSTAPPImpl", "onStartRender");
                SudLogger.d(g1.h.f١٤٣٨٢k, "onStartRender");
            }
        } catch (JSONException e10) {
            o.b.c("WXGame", "OnState:" + e10.getMessage());
        }
    }
}
