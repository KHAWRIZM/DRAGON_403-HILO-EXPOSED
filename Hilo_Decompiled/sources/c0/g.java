package c0;

import org.json.JSONObject;
import tech.sud.gip.core.ai.ISudListenerAiSse;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class g implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ISudListenerAiSse f٥٦٤٦a;

    public g(ISudListenerAiSse iSudListenerAiSse) {
        this.f٥٦٤٦a = iSudListenerAiSse;
    }

    @Override // c0.k
    public final void a(String str) {
        String str2;
        LogUtils.file("SudAiModelImpl", "aiSse onFailure:" + str);
        l.f٥٦٥٠b.remove(this);
        int i10 = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            i10 = jSONObject.getInt("ret_code");
            str2 = jSONObject.optString("ret_msg");
        } catch (Exception e10) {
            LogUtils.file("SudAiModelImpl", LogUtils.getErrorInfo(e10));
            str2 = null;
        }
        this.f٥٦٤٦a.onFailure(i10, str2);
    }

    @Override // c0.k
    public final void onCompleted() {
        LogUtils.file("SudAiModelImpl", "aiSse onCompleted");
        l.f٥٦٥٠b.remove(this);
        this.f٥٦٤٦a.onCompleted();
    }

    @Override // c0.k
    public final void onSseLine(String str) {
        LogUtils.file("SudAiModelImpl", "aiSse onSseLine:" + str);
        this.f٥٦٤٦a.onSseLine(str);
    }
}
