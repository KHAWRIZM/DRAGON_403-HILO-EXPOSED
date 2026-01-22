package o0;

import tech.sud.gip.core.network.detection.NetworkDetectionStatus;
import tech.sud.gip.core.network.detection.NetworkDetectionStep;
import tech.sud.gip.core.network.detection.NetworkDetectionStepResult;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class q implements vf.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f١٦٤٦٠a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f١٦٤٦١b;

    public q(j jVar, n nVar) {
        this.f١٦٤٦١b = jVar;
        this.f١٦٤٦٠a = nVar;
    }

    public final void onFailure(int i10, String str) {
        LogUtils.file("NetworkDetectionTask", "networkdetection failure:" + i10 + " retMsg:" + str);
        NetworkDetectionStepResult networkDetectionStepResult = new NetworkDetectionStepResult();
        networkDetectionStepResult.code = i10;
        networkDetectionStepResult.msg = str;
        NetworkDetectionStep networkDetectionStep = this.f١٦٤٦٠a.f١٦٤٥٠a;
        networkDetectionStep.status = NetworkDetectionStatus.COMPLETED;
        networkDetectionStep.result = networkDetectionStepResult;
        this.f١٦٤٦١b.g(i10, str);
    }

    public final void onSuccess(String str) {
        NetworkDetectionStepResult networkDetectionStepResult = new NetworkDetectionStepResult();
        networkDetectionStepResult.code = 0;
        networkDetectionStepResult.msg = "success";
        NetworkDetectionStep networkDetectionStep = this.f١٦٤٦٠a.f١٦٤٥٠a;
        networkDetectionStep.status = NetworkDetectionStatus.COMPLETED;
        networkDetectionStep.result = networkDetectionStepResult;
        j jVar = this.f١٦٤٦١b;
        int i10 = jVar.f١٦٤٣٩g + 1;
        jVar.f١٦٤٣٩g = i10;
        if (i10 == jVar.f١٦٤٣٨f) {
            jVar.h();
        }
    }
}
