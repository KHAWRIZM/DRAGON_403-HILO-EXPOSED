package o0;

import android.os.Handler;
import android.os.Looper;
import anet.channel.request.Request;
import anet.channel.util.HttpConstant;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.SudInitSDKParamModel;
import tech.sud.gip.core.network.detection.INetworkDetectionListener;
import tech.sud.gip.core.network.detection.NetworkDetectionDetail;
import tech.sud.gip.core.network.detection.NetworkDetectionResult;
import tech.sud.gip.core.network.detection.NetworkDetectionStep;
import tech.sud.gip.core.network.detection.NetworkDetectionStepResult;
import tech.sud.gip.core.network.detection.SudNetworkDetectionParamModel;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public SudNetworkDetectionParamModel f١٦٤٣٣a;

    /* renamed from: b, reason: collision with root package name */
    public INetworkDetectionListener f١٦٤٣٤b;

    /* renamed from: c, reason: collision with root package name */
    public final e f١٦٤٣٥c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f١٦٤٣٦d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f١٦٤٣٧e;

    /* renamed from: f, reason: collision with root package name */
    public int f١٦٤٣٨f;

    /* renamed from: g, reason: collision with root package name */
    public int f١٦٤٣٩g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f١٦٤٤٠h;

    /* renamed from: i, reason: collision with root package name */
    public int f١٦٤٤١i;

    /* renamed from: j, reason: collision with root package name */
    public f.a f١٦٤٤٢j;

    public j(SudNetworkDetectionParamModel sudNetworkDetectionParamModel, INetworkDetectionListener iNetworkDetectionListener) {
        new Handler(Looper.getMainLooper());
        this.f١٦٤٣٥c = new e(this);
        this.f١٦٤٣٧e = new ArrayList();
        this.f١٦٤٤٠h = new ArrayList();
        this.f١٦٤٣٣a = sudNetworkDetectionParamModel;
        this.f١٦٤٣٤b = iNetworkDetectionListener;
        this.f١٦٤٤٢j = new f.a("networkDetection");
    }

    public final void a() {
        final n nVar = new n();
        nVar.f١٦٤٥١b = "getFqs";
        NetworkDetectionStep networkDetectionStep = nVar.f١٦٤٥٠a;
        int i10 = this.f١٦٤٤١i + 1;
        this.f١٦٤٤١i = i10;
        networkDetectionStep.identifier = i10;
        networkDetectionStep.protocol = HttpConstant.HTTPS;
        networkDetectionStep.method = Request.Method.GET;
        this.f١٦٤٣٧e.add(nVar);
        final m mVar = new m(nVar.f١٦٤٥٠a);
        final n nVar2 = new n();
        nVar2.f١٦٤٥١b = "getSdkToken";
        NetworkDetectionStep networkDetectionStep2 = nVar2.f١٦٤٥٠a;
        int i11 = this.f١٦٤٤١i + 1;
        this.f١٦٤٤١i = i11;
        networkDetectionStep2.identifier = i11;
        networkDetectionStep2.protocol = HttpConstant.HTTPS;
        networkDetectionStep2.method = Request.Method.GET;
        this.f١٦٤٣٧e.add(nVar2);
        final m mVar2 = new m(nVar2.f١٦٤٥٠a);
        ThreadUtils.postUITask(new Runnable() { // from class: o0.f
            @Override // java.lang.Runnable
            public final void run() {
                j.this.c(nVar, mVar, nVar2, mVar2);
            }
        });
    }

    public final void b(int i10, String str) {
        NetworkDetectionResult networkDetectionResult = new NetworkDetectionResult();
        networkDetectionResult.code = i10;
        networkDetectionResult.msg = str;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f١٦٤٣٧e;
        int size = arrayList2.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList2.get(i11);
            i11++;
            arrayList.add(((n) obj).f١٦٤٥٠a.deepCopy());
        }
        networkDetectionResult.stepList = arrayList;
        INetworkDetectionListener iNetworkDetectionListener = this.f١٦٤٣٤b;
        if (iNetworkDetectionListener != null) {
            iNetworkDetectionListener.onCompleted(networkDetectionResult);
        }
        d(networkDetectionResult);
        this.f١٦٤٣٣a = null;
        this.f١٦٤٣٤b = null;
    }

    public final /* synthetic */ void c(n nVar, m mVar, n nVar2, m mVar2) {
        SudInitSDKParamModel sudInitSDKParamModel = new SudInitSDKParamModel();
        SudNetworkDetectionParamModel sudNetworkDetectionParamModel = this.f١٦٤٣٣a;
        if (sudNetworkDetectionParamModel != null) {
            sudInitSDKParamModel.context = sudNetworkDetectionParamModel.context;
            sudInitSDKParamModel.appId = sudNetworkDetectionParamModel.appId;
            sudInitSDKParamModel.appKey = sudNetworkDetectionParamModel.appKey;
            sudInitSDKParamModel.isTestEnv = sudNetworkDetectionParamModel.isTestEnv;
            sudInitSDKParamModel.userId = sudNetworkDetectionParamModel.userId;
        }
        e.d.b(sudInitSDKParamModel, new o(this, nVar, mVar, nVar2, mVar2), mVar, mVar2);
    }

    public final void d(NetworkDetectionResult networkDetectionResult) {
        if (this.f١٦٤٤٢j == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = this.f١٦٤٣٧e;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            n nVar = (n) obj;
            nVar.getClass();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", nVar.f١٦٤٥١b);
                jSONObject.put("url", nVar.f١٦٤٥٢c);
                jSONObject.put("identifier", nVar.f١٦٤٥٠a.identifier);
                jSONObject.put("protocol", nVar.f١٦٤٥٠a.protocol);
                jSONObject.put(FirebaseAnalytics.Param.METHOD, nVar.f١٦٤٥٠a.method);
                jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, nVar.f١٦٤٥٠a.status);
                JSONArray jSONArray2 = new JSONArray();
                for (int i11 = 0; i11 < nVar.f١٦٤٥٠a.detailList.size(); i11++) {
                    NetworkDetectionDetail networkDetectionDetail = (NetworkDetectionDetail) nVar.f١٦٤٥٠a.detailList.get(i11);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("type", networkDetectionDetail.type);
                    jSONObject2.put(HeaderInterceptor.TIMESTAMP, networkDetectionDetail.timestamp);
                    jSONArray2.put(jSONObject2);
                }
                jSONObject.put("detailList", jSONArray2);
                NetworkDetectionStepResult networkDetectionStepResult = nVar.f١٦٤٥٠a.result;
                if (networkDetectionStepResult != null) {
                    jSONObject.put("result", networkDetectionStepResult.toJsonObject());
                }
            } catch (Exception e10) {
                LogUtils.file("InnelNetworkDetectionStep", "jsonError:" + LogUtils.getErrorInfo(e10));
            }
            jSONArray.put(jSONObject);
        }
        this.f١٦٤٤٢j.f١٤٠٠٧j.put("stepList", jSONArray);
        f.a aVar = this.f١٦٤٤٢j;
        aVar.f١٤٠٠٢e = networkDetectionResult.code;
        String str = networkDetectionResult.msg;
        if (str != null) {
            aVar.f١٤٠٠٣f = str;
        }
        f.d.b(aVar);
        this.f١٦٤٤٢j = null;
    }

    public final /* synthetic */ void e() {
        INetworkDetectionListener iNetworkDetectionListener = this.f١٦٤٣٤b;
        if (iNetworkDetectionListener != null) {
            iNetworkDetectionListener.onStarted();
        }
    }

    public final void f() {
        NetworkDetectionResult networkDetectionResult = new NetworkDetectionResult();
        int i10 = 0;
        networkDetectionResult.code = 0;
        networkDetectionResult.msg = "success";
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f١٦٤٣٧e;
        int size = arrayList2.size();
        while (i10 < size) {
            Object obj = arrayList2.get(i10);
            i10++;
            arrayList.add(((n) obj).f١٦٤٥٠a.deepCopy());
        }
        networkDetectionResult.stepList = arrayList;
        INetworkDetectionListener iNetworkDetectionListener = this.f١٦٤٣٤b;
        if (iNetworkDetectionListener != null) {
            iNetworkDetectionListener.onCompleted(networkDetectionResult);
        }
        d(networkDetectionResult);
        this.f١٦٤٣٣a = null;
        this.f١٦٤٣٤b = null;
    }

    public final void g(final int i10, final String str) {
        ThreadUtils.postUITask(new Runnable() { // from class: o0.h
            @Override // java.lang.Runnable
            public final void run() {
                j.this.b(i10, str);
            }
        });
    }

    public final void h() {
        ThreadUtils.postUITask(new Runnable() { // from class: o0.i
            @Override // java.lang.Runnable
            public final void run() {
                j.this.f();
            }
        });
    }

    public final void i() {
        ThreadUtils.postUITask(new Runnable() { // from class: o0.g
            @Override // java.lang.Runnable
            public final void run() {
                j.this.e();
            }
        });
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f١٦٤٣٦d) {
            return;
        }
        i();
        a();
    }
}
