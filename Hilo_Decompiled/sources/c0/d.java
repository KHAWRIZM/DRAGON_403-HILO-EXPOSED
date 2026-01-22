package c0;

import android.text.TextUtils;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import org.json.JSONObject;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d implements i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f٥٦٣٨a;

    public d(f fVar) {
        this.f٥٦٣٨a = fVar;
    }

    @Override // c0.i
    public final void onCompleted(String str) {
        f fVar = this.f٥٦٣٨a;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i10 = jSONObject.getInt("ret_code");
            String optString = jSONObject.optString("ret_msg");
            if (i10 != 0) {
                fVar.f٥٦٤١a.onFailure(i10, optString);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                fVar.f٥٦٤٢b = optJSONObject.optString("model_url");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("crypto");
                if (optJSONObject2 != null) {
                    fVar.f٥٦٤٣c = optJSONObject2.optString("algorithm");
                    fVar.f٥٦٤٤d = optJSONObject2.optString(TransferTable.COLUMN_KEY);
                }
            }
            if (TextUtils.isEmpty(fVar.f٥٦٤٢b)) {
                fVar.f٥٦٤١a.onFailure(-1, "modelUrl can not be empty");
                return;
            }
            if (TextUtils.isEmpty(fVar.f٥٦٤٣c)) {
                fVar.f٥٦٤١a.onFailure(-1, "algorithm can not be empty");
            } else if (TextUtils.isEmpty(fVar.f٥٦٤٤d)) {
                fVar.f٥٦٤١a.onFailure(-1, "key can not be empty");
            } else {
                fVar.a();
            }
        } catch (Exception e10) {
            LogUtils.file("AiLoadModelTask", LogUtils.getErrorInfo(e10));
            fVar.f٥٦٤١a.onFailure(-1, "json error:" + e10.toString());
        }
    }
}
