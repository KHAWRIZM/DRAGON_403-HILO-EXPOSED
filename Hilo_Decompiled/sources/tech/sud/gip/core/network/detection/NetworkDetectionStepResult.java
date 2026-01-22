package tech.sud.gip.core.network.detection;

import com.taobao.accs.common.Constants;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class NetworkDetectionStepResult {
    public int code;
    public String msg;

    public NetworkDetectionStepResult deepCopy() {
        NetworkDetectionStepResult networkDetectionStepResult = new NetworkDetectionStepResult();
        networkDetectionStepResult.code = this.code;
        networkDetectionStepResult.msg = this.msg;
        return networkDetectionStepResult;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.KEY_HTTP_CODE, this.code);
        jSONObject.put("msg", this.msg);
        return jSONObject;
    }
}
