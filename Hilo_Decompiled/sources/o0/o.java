package o0;

import anet.channel.request.Request;
import anet.channel.util.HttpConstant;
import org.json.JSONObject;
import qf.x;
import tech.sud.gip.core.ISudListenerInitSDK;
import tech.sud.gip.core.network.detection.NetworkDetectionStatus;
import tech.sud.gip.core.network.detection.NetworkDetectionStep;
import tech.sud.gip.core.network.detection.NetworkDetectionStepResult;
import tech.sud.gip.core.network.detection.SudNetworkDetectionParamModel;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class o implements ISudListenerInitSDK {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f١٦٤٥٣a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f١٦٤٥٤b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f١٦٤٥٥c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ m f١٦٤٥٦d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ j f١٦٤٥٧e;

    public o(j jVar, n nVar, m mVar, n nVar2, m mVar2) {
        this.f١٦٤٥٧e = jVar;
        this.f١٦٤٥٣a = nVar;
        this.f١٦٤٥٤b = mVar;
        this.f١٦٤٥٥c = nVar2;
        this.f١٦٤٥٦d = mVar2;
    }

    public final void onFailure(int i10, String str) {
        LogUtils.file("NetworkDetectionTask", "initSDK failure:" + i10 + " retMsg:" + str);
        NetworkDetectionStepResult networkDetectionStepResult = new NetworkDetectionStepResult();
        networkDetectionStepResult.code = i10;
        networkDetectionStepResult.msg = str;
        n nVar = this.f١٦٤٥٣a;
        nVar.f١٦٤٥٢c = ((vf.b) this.f١٦٤٥٤b).b;
        NetworkDetectionStep networkDetectionStep = nVar.f١٦٤٥٠a;
        NetworkDetectionStatus networkDetectionStatus = networkDetectionStep.status;
        NetworkDetectionStatus networkDetectionStatus2 = NetworkDetectionStatus.WAITING;
        if (networkDetectionStatus != networkDetectionStatus2) {
            networkDetectionStep.status = NetworkDetectionStatus.COMPLETED;
            networkDetectionStep.result = networkDetectionStepResult;
        }
        n nVar2 = this.f١٦٤٥٥c;
        nVar2.f١٦٤٥٢c = ((vf.b) this.f١٦٤٥٦d).b;
        NetworkDetectionStep networkDetectionStep2 = nVar2.f١٦٤٥٠a;
        if (networkDetectionStep2.status != networkDetectionStatus2) {
            networkDetectionStep2.status = NetworkDetectionStatus.COMPLETED;
            networkDetectionStep2.result = networkDetectionStepResult;
        }
        this.f١٦٤٥٧e.g(i10, str);
    }

    public final void onSuccess() {
        NetworkDetectionStepResult networkDetectionStepResult = new NetworkDetectionStepResult();
        networkDetectionStepResult.code = 0;
        networkDetectionStepResult.msg = "success";
        n nVar = this.f١٦٤٥٣a;
        nVar.f١٦٤٥٢c = ((vf.b) this.f١٦٤٥٤b).b;
        NetworkDetectionStep networkDetectionStep = nVar.f١٦٤٥٠a;
        NetworkDetectionStatus networkDetectionStatus = NetworkDetectionStatus.COMPLETED;
        networkDetectionStep.status = networkDetectionStatus;
        networkDetectionStep.result = networkDetectionStepResult;
        n nVar2 = this.f١٦٤٥٥c;
        nVar2.f١٦٤٥٢c = ((vf.b) this.f١٦٤٥٦d).b;
        NetworkDetectionStep networkDetectionStep2 = nVar2.f١٦٤٥٠a;
        networkDetectionStep2.status = networkDetectionStatus;
        networkDetectionStep2.result = networkDetectionStepResult;
        j jVar = this.f١٦٤٥٧e;
        if (jVar.f١٦٤٣٦d) {
            return;
        }
        x xVar = e.d.f١٣٧١٩b;
        String str = xVar.c;
        n nVar3 = new n();
        nVar3.f١٦٤٥١b = "getCheckerUrlConfig";
        nVar3.f١٦٤٥٢c = str;
        NetworkDetectionStep networkDetectionStep3 = nVar3.f١٦٤٥٠a;
        int i10 = jVar.f١٦٤٤١i + 1;
        jVar.f١٦٤٤١i = i10;
        networkDetectionStep3.identifier = i10;
        networkDetectionStep3.protocol = HttpConstant.HTTPS;
        networkDetectionStep3.method = Request.Method.POST;
        jVar.f١٦٤٣٧e.add(nVar3);
        m mVar = new m(nVar3.f١٦٤٥٠a);
        JSONObject jSONObject = new JSONObject();
        try {
            SudNetworkDetectionParamModel sudNetworkDetectionParamModel = jVar.f١٦٤٣٣a;
            if (sudNetworkDetectionParamModel != null) {
                jSONObject.put("app_id", sudNetworkDetectionParamModel.appId);
            }
        } catch (Exception e10) {
            LogUtils.file("NetworkDetectionTask", "getCheckerUrlConfig error:" + LogUtils.getErrorInfo(e10));
        }
        String jSONObject2 = jSONObject.toString();
        p pVar = new p(jVar, nVar3);
        qf.a aVar = new qf.a();
        jVar.f١٦٤٤٠h.add(aVar);
        xVar.o(str, jSONObject2, mVar, pVar, aVar);
    }
}
