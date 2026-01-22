package tech.sud.gip.core;

import android.content.Context;
import android.text.TextUtils;
import c0.c;
import c0.e;
import c0.f;
import c0.g;
import c0.j;
import c0.l;
import com.tencent.imsdk.BaseConstants;
import d.b;
import d.k;
import d.p;
import e.d;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.UUID;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;
import qf.i;
import qf.x;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.ai.ISudListenerAiCommon;
import tech.sud.gip.core.ai.ISudListenerAiSse;
import tech.sud.gip.core.ai.ISudListenerLoadModel;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;
import u.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class SudAiModel {
    public static void aiCommon(String str, ISudListenerAiCommon iSudListenerAiCommon) {
        String str2 = l.a;
        if (iSudListenerAiCommon == null) {
            LogUtils.file("SudAiModelImpl", "aiCommon listener is null");
            return;
        }
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(l.a, "Please call on UI or Main thread");
            LogUtils.file("SudAiModelImpl", "aiCommon Please call on UI or Main thread");
            iSudListenerAiCommon.onCompleted(l.a(-1, "Please call on UI or Main thread"));
        } else {
            if (!d.b.a) {
                LogUtils.file("SudAiModelImpl", "aiCommon Please call initSDK first successfully");
                iSudListenerAiCommon.onCompleted(l.a(BaseConstants.ERR_SVR_SSO_IDENTIFIER_INVALID, "Please call initSDK first successfully"));
                return;
            }
            e eVar = new e(str, iSudListenerAiCommon);
            ArrayList arrayList = l.b;
            if (!arrayList.contains(eVar)) {
                arrayList.add(eVar);
            }
            c.b(str, eVar);
        }
    }

    public static void aiSse(String str, ISudListenerAiSse iSudListenerAiSse) {
        String str2 = l.a;
        if (iSudListenerAiSse == null) {
            LogUtils.file("SudAiModelImpl", "aiSse listener is null");
            return;
        }
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(l.a, "aiSse Please call on UI or Main thread");
            LogUtils.file("SudAiModelImpl", "aiSse Please call on UI or Main thread");
            iSudListenerAiSse.onFailure(-1, "Please call on UI or Main thread");
        } else {
            if (!d.b.a) {
                LogUtils.file("SudAiModelImpl", "aiSse Please call initSDK first successfully");
                iSudListenerAiSse.onFailure(BaseConstants.ERR_SVR_SSO_IDENTIFIER_INVALID, "Please call initSDK first successfully");
                return;
            }
            g gVar = new g(iSudListenerAiSse);
            ArrayList arrayList = l.b;
            if (!arrayList.contains(gVar)) {
                arrayList.add(gVar);
            }
            c.c(str, gVar);
        }
    }

    public static void clearAllCache(Context context) {
        String absolutePath;
        String str = l.a;
        if (ThreadUtils.checkUIThread()) {
            SudLogger.e(l.a, "clearAllCache Cannot be called in the main thread");
            LogUtils.file("SudAiModelImpl", "clearAllCache Cannot be called in the main thread");
            return;
        }
        if (context == null) {
            absolutePath = null;
        } else {
            absolutePath = new File(context.getFilesDir(), "sud/mgp/ai").getAbsolutePath();
        }
        if (TextUtils.isEmpty(absolutePath)) {
            return;
        }
        a.c(absolutePath);
    }

    public static String getCachePath(Context context) {
        String str = l.a;
        if (context == null) {
            return null;
        }
        return new File(context.getFilesDir(), "sud/mgp/ai").getAbsolutePath();
    }

    public static void loadModel(String str, ISudListenerLoadModel iSudListenerLoadModel) {
        String str2;
        b bVar;
        String str3;
        k kVar;
        String str4 = l.a;
        if (iSudListenerLoadModel == null) {
            LogUtils.file("SudAiModelImpl", "loadModel listener is null");
            return;
        }
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(l.a, "loadModel Please call on UI or Main thread");
            LogUtils.file("SudAiModelImpl", "loadModel Please call on UI or Main thread");
            iSudListenerLoadModel.onFailure(-1, "Please call on UI or Main thread");
            return;
        }
        if (!d.b.a) {
            LogUtils.file("SudAiModelImpl", "loadModel Please call initSDK first successfully");
            iSudListenerLoadModel.onFailure(BaseConstants.ERR_SVR_SSO_IDENTIFIER_INVALID, "Please call initSDK first successfully");
            return;
        }
        f fVar = new f(str, new j(iSudListenerLoadModel));
        ArrayList arrayList = l.b;
        if (!arrayList.contains(fVar)) {
            arrayList.add(fVar);
        }
        c0.d dVar = new c0.d(fVar);
        try {
            str2 = new JSONObject(str).optString("request_id");
        } catch (Exception e) {
            LogUtils.file("SudAiManager", LogUtils.getErrorInfo(e));
            str2 = null;
        }
        c0.b bVar2 = new c0.b(new WeakReference(dVar), str2);
        if (!d.b.a) {
            bVar2.onFailure(BaseConstants.ERR_SVR_SSO_IDENTIFIER_INVALID, "Please call initSDK first successfully");
            return;
        }
        p pVar = d.e;
        if (pVar != null && (kVar = pVar.c) != null) {
            bVar = kVar.m;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            str3 = bVar.c;
        } else {
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            bVar2.onFailure(-1, "model_api_cfg ai_normal url is null");
            return;
        }
        Request.Builder post = x.e(u.j.b(UUID.randomUUID().toString()), new wf.e(), null).url(str3).post(RequestBody.create(MediaType.get("application/json; charset=utf-8"), str));
        i.a(post);
        i.b.newCall(post.build()).enqueue(new uf.c(bVar2));
    }
}
