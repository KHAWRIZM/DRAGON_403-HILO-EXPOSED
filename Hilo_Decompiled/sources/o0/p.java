package o0;

import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import okhttp3.Request;
import org.json.JSONArray;
import org.json.JSONObject;
import qf.x;
import tech.sud.gip.core.network.detection.NetworkDetectionStatus;
import tech.sud.gip.core.network.detection.NetworkDetectionStep;
import tech.sud.gip.core.network.detection.NetworkDetectionStepResult;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class p implements vf.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f١٦٤٥٨a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f١٦٤٥٩b;

    public p(j jVar, n nVar) {
        this.f١٦٤٥٩b = jVar;
        this.f١٦٤٥٨a = nVar;
    }

    public final void onFailure(int i10, String str) {
        LogUtils.file("NetworkDetectionTask", "initSDK failure:" + i10 + " retMsg:" + str);
        NetworkDetectionStepResult networkDetectionStepResult = new NetworkDetectionStepResult();
        networkDetectionStepResult.code = i10;
        networkDetectionStepResult.msg = str;
        NetworkDetectionStep networkDetectionStep = this.f١٦٤٥٨a.f١٦٤٥٠a;
        networkDetectionStep.status = NetworkDetectionStatus.COMPLETED;
        networkDetectionStep.result = networkDetectionStepResult;
        this.f١٦٤٥٩b.g(i10, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onSuccess(String str) {
        String str2;
        int i10;
        NetworkDetectionStepResult networkDetectionStepResult = new NetworkDetectionStepResult();
        int i11 = 0;
        networkDetectionStepResult.code = 0;
        networkDetectionStepResult.msg = "success";
        NetworkDetectionStep networkDetectionStep = this.f١٦٤٥٨a.f١٦٤٥٠a;
        networkDetectionStep.status = NetworkDetectionStatus.COMPLETED;
        networkDetectionStep.result = networkDetectionStepResult;
        j jVar = this.f١٦٤٥٩b;
        if (!jVar.f١٦٤٣٦d) {
            ArrayList arrayList = null;
            try {
                JSONObject jSONObject = new JSONObject(str);
                i10 = jSONObject.getInt("ret_code");
                str2 = jSONObject.optString("ret_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i12 = 0; i12 < optJSONArray.length(); i12++) {
                        try {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i12);
                            k kVar = new k();
                            kVar.f١٦٤٤٣a = jSONObject2.optString("name");
                            kVar.f١٦٤٤٤b = jSONObject2.optString("protocol");
                            kVar.f١٦٤٤٥c = jSONObject2.optString(FirebaseAnalytics.Param.METHOD);
                            kVar.f١٦٤٤٦d = jSONObject2.optString("url");
                            arrayList2.add(kVar);
                        } catch (Exception e10) {
                            e = e10;
                            arrayList = arrayList2;
                            LogUtils.file("NetworkDetectionTask", "parseCheckerUrlConfig error:" + LogUtils.getErrorInfo(e));
                            str2 = e.toString();
                            i10 = -1;
                            if (i10 == 0) {
                            }
                        }
                    }
                    arrayList = arrayList2;
                }
            } catch (Exception e11) {
                e = e11;
            }
            if (i10 == 0) {
                jVar.g(i10, str2);
                return;
            }
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList arrayList3 = new ArrayList();
                int size = arrayList.size();
                int i13 = 0;
                while (i13 < size) {
                    Object obj = arrayList.get(i13);
                    i13++;
                    k kVar2 = (k) obj;
                    if (!TextUtils.isEmpty(kVar2.f١٦٤٤٦d)) {
                        if (!HttpConstant.HTTP.equalsIgnoreCase(kVar2.f١٦٤٤٤b) && !HttpConstant.HTTPS.equalsIgnoreCase(kVar2.f١٦٤٤٤b)) {
                            if ("ws".equalsIgnoreCase(kVar2.f١٦٤٤٤b) || "wss".equalsIgnoreCase(kVar2.f١٦٤٤٤b)) {
                                arrayList3.add(kVar2);
                            }
                        } else if ("get".equalsIgnoreCase(kVar2.f١٦٤٤٥c) || "post".equalsIgnoreCase(kVar2.f١٦٤٤٥c)) {
                            arrayList3.add(kVar2);
                        }
                    }
                }
                if (arrayList3.size() == 0) {
                    jVar.h();
                    return;
                }
                jVar.f١٦٤٣٨f = arrayList3.size();
                x xVar = e.d.f١٣٧١٩b;
                int size2 = arrayList3.size();
                while (i11 < size2) {
                    Object obj2 = arrayList3.get(i11);
                    i11++;
                    k kVar3 = (k) obj2;
                    n nVar = new n();
                    nVar.f١٦٤٥١b = kVar3.f١٦٤٤٣a;
                    nVar.f١٦٤٥٢c = kVar3.f١٦٤٤٦d;
                    NetworkDetectionStep networkDetectionStep2 = nVar.f١٦٤٥٠a;
                    int i14 = jVar.f١٦٤٤١i + 1;
                    jVar.f١٦٤٤١i = i14;
                    networkDetectionStep2.identifier = i14;
                    networkDetectionStep2.protocol = kVar3.f١٦٤٤٤b;
                    networkDetectionStep2.method = kVar3.f١٦٤٤٥c;
                    jVar.f١٦٤٣٧e.add(nVar);
                    m mVar = new m(nVar.f١٦٤٥٠a);
                    q qVar = new q(jVar, nVar);
                    ArrayList arrayList4 = arrayList3;
                    if (!HttpConstant.HTTP.equalsIgnoreCase(kVar3.f١٦٤٤٤b) && !HttpConstant.HTTPS.equalsIgnoreCase(kVar3.f١٦٤٤٤b)) {
                        if ("ws".equalsIgnoreCase(kVar3.f١٦٤٤٤b) || "wss".equalsIgnoreCase(kVar3.f١٦٤٤٤b)) {
                            String str3 = kVar3.f١٦٤٤٦d;
                            qf.i.b.newWebSocket(new Request.Builder().url(str3).build(), new d(jVar, str3, nVar));
                        }
                    } else if ("get".equalsIgnoreCase(kVar3.f١٦٤٤٥c)) {
                        String str4 = kVar3.f١٦٤٤٦d;
                        qf.a aVar = new qf.a();
                        jVar.f١٦٤٤٠h.add(aVar);
                        xVar.q(str4, mVar, qVar, aVar);
                    } else if ("post".equalsIgnoreCase(kVar3.f١٦٤٤٥c)) {
                        String str5 = kVar3.f١٦٤٤٦d;
                        qf.a aVar2 = new qf.a();
                        jVar.f١٦٤٤٠h.add(aVar2);
                        xVar.o(str5, "", mVar, qVar, aVar2);
                    }
                    arrayList3 = arrayList4;
                }
                return;
            }
            jVar.h();
        }
    }
}
