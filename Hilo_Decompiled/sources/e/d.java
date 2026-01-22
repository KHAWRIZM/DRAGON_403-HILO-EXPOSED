package e;

import Sudif.Sudtry;
import android.content.Context;
import android.text.TextUtils;
import anetwork.channel.util.RequestConstant;
import d.g;
import d.k;
import d.l;
import d.p;
import j0.v;
import java.util.ArrayList;
import java.util.UUID;
import o0.m;
import org.json.JSONArray;
import qf.x;
import tech.sud.base.utils.Utils;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.ISudListenerInitSDK;
import tech.sud.gip.core.SudGIP;
import tech.sud.gip.core.SudInitSDKParamModel;
import tech.sud.gip.core.model.VolcCfg;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;
import u.j;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f١٣٧١٨a = "SudGIP ".concat(d.class.getSimpleName());

    /* renamed from: b, reason: collision with root package name */
    public static final x f١٣٧١٩b = new x();

    /* renamed from: c, reason: collision with root package name */
    public static boolean f١٣٧٢٠c = false;

    /* renamed from: d, reason: collision with root package name */
    public static String f١٣٧٢١d = "zh-CN";

    /* renamed from: e, reason: collision with root package name */
    public static p f١٣٧٢٢e = new p();

    /* renamed from: f, reason: collision with root package name */
    public static int f١٣٧٢٣f = 1;

    /* renamed from: g, reason: collision with root package name */
    public static String f١٣٧٢٤g = "";

    /* renamed from: h, reason: collision with root package name */
    public static String f١٣٧٢٥h = "";

    /* renamed from: i, reason: collision with root package name */
    public static String f١٣٧٢٦i = "";

    /* renamed from: j, reason: collision with root package name */
    public static final String f١٣٧٢٧j = j.b(UUID.randomUUID().toString());

    public static ArrayList a() {
        k kVar;
        l lVar;
        ArrayList arrayList;
        String[] split;
        String str = (String) h0.b.f١٤٤٨٧a.f١٤٤٨٦d.get("asr_load_list");
        if (str != null && (split = str.split(",")) != null && split.length > 0) {
            ArrayList arrayList2 = new ArrayList();
            for (String str2 : split) {
                try {
                    arrayList2.add(Integer.valueOf(Integer.parseInt(str2)));
                } catch (Exception e10) {
                    LogUtils.file("SdkMgr", LogUtils.getErrorInfo(e10));
                }
            }
            if (!arrayList2.isEmpty()) {
                return arrayList2;
            }
        }
        p pVar = f١٣٧٢٢e;
        if (pVar != null && (kVar = pVar.f١٣٥٣٧c) != null && (lVar = kVar.f١٣٥١٤e) != null && (arrayList = lVar.f١٣٥٢٧b) != null) {
            return arrayList;
        }
        return null;
    }

    public static void b(SudInitSDKParamModel sudInitSDKParamModel, ISudListenerInitSDK iSudListenerInitSDK, m mVar, m mVar2) {
        String str = f١٣٧١٨a;
        SudLogger.i(str, "initSDK");
        if (!ThreadUtils.checkUIThread()) {
            LogUtils.file("SdkMgr", "initSDK Please call on UI or Main thread");
            SudLogger.e(str, "initSDK Please call on UI or Main thread");
            if (iSudListenerInitSDK != null) {
                iSudListenerInitSDK.onFailure(-1, "Please call on UI or Main thread");
                return;
            }
            return;
        }
        if (sudInitSDKParamModel != null && sudInitSDKParamModel.check()) {
            Context applicationContext = sudInitSDKParamModel.context.getApplicationContext();
            sudInitSDKParamModel.context = applicationContext;
            if (v.f١٥١٢٨c == null) {
                synchronized (v.class) {
                    try {
                        if (v.f١٥١٢٨c == null) {
                            v.f١٥١٢٨c = new v(applicationContext);
                        }
                    } finally {
                    }
                }
            }
            Context context = sudInitSDKParamModel.context;
            String str2 = j0.e.f١٥٠٧٩d;
            if (Sudtry.f٣٩a == null) {
                Sudtry.f٣٩a = context;
            }
            if (sudInitSDKParamModel.userId == null) {
                sudInitSDKParamModel.userId = "";
            }
            f.d.f١٤٠٢٣a = sudInitSDKParamModel.userId;
            Utils.initContext(context);
            String str3 = u.e.f١٨٢١٧e;
            u.c.f١٨٢١٥a.a(Utils.getApp());
            int i10 = f١٣٧٢٣f;
            boolean z10 = f١٣٧٢٠c;
            boolean z11 = sudInitSDKParamModel.isTestEnv;
            f١٣٧٢٠c = z11;
            if (i10 == 1) {
                if (z11) {
                    f١٣٧٢٣f = 2;
                    f١٣٧١٩b.getClass();
                    x.z();
                } else {
                    f١٣٧٢٣f = 1;
                    f١٣٧١٩b.getClass();
                    x.z();
                }
            } else if (i10 == 2) {
                if (z11) {
                    f١٣٧٢٣f = 2;
                    f١٣٧١٩b.getClass();
                    x.z();
                } else {
                    f١٣٧٢٣f = 1;
                    f١٣٧١٩b.getClass();
                    x.z();
                }
            }
            int i11 = f١٣٧٢٣f;
            if (!f١٣٧٢٤g.equals(sudInitSDKParamModel.appId) || !f١٣٧٢٥h.equals(sudInitSDKParamModel.appKey) || i10 != i11 || z10 != sudInitSDKParamModel.isTestEnv) {
                f١٣٧١٩b.f();
            }
            f١٣٧٢٤g = sudInitSDKParamModel.appId;
            f١٣٧٢٥h = sudInitSDKParamModel.appKey;
            String packageName = sudInitSDKParamModel.context.getPackageName();
            if (packageName == null) {
                f١٣٧٢٦i = "";
            } else {
                f١٣٧٢٦i = packageName;
            }
            LogUtils.file("SdkMgr", "initSDK appId:" + f١٣٧٢٤g + "  appKey:" + sudInitSDKParamModel.appKey + "  bundleId:" + f١٣٧٢٦i + "  isTestEnv:" + sudInitSDKParamModel.isTestEnv);
            f١٣٧١٩b.u(iSudListenerInitSDK, sudInitSDKParamModel.context, sudInitSDKParamModel.appId, sudInitSDKParamModel.appKey, sudInitSDKParamModel.isTestEnv, mVar, mVar2);
            return;
        }
        LogUtils.file("SdkMgr", "initSDK Parameters cannot be null");
        SudLogger.e(str, "initSDK Parameters cannot be null");
        if (iSudListenerInitSDK != null) {
            iSudListenerInitSDK.onFailure(-10104, "Parameters cannot be null");
        }
    }

    public static JSONArray c() {
        k kVar;
        d.m mVar;
        VolcCfg volcCfg;
        p pVar = f١٣٧٢٢e;
        if (pVar != null && (kVar = pVar.f١٣٥٣٧c) != null && (mVar = kVar.f١٣٥٢٣n) != null && (volcCfg = mVar.f١٣٥٢٩a) != null) {
            return volcCfg.languages;
        }
        try {
            return new JSONArray("[\"zh-CN\"]");
        } catch (Exception e10) {
            e10.printStackTrace();
            return new JSONArray();
        }
    }

    public static String d() {
        String str = f١٣٧٢٦i;
        if (TextUtils.isEmpty(str)) {
            str = Utils.getApp().getPackageName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static g e() {
        k kVar;
        p pVar = f١٣٧٢٢e;
        if (pVar != null && (kVar = pVar.f١٣٥٣٧c) != null) {
            return kVar.f١٣٥١٨i;
        }
        return null;
    }

    public static boolean f() {
        p pVar;
        k kVar;
        String str = (String) SudGIP.getCfg().getAdvancedConfigMap().get("runtime_3d_multiprocess");
        LogUtils.file("SdkMgr", "runtime3dMultiprocess:" + str);
        if ("true".equals(str)) {
            return true;
        }
        if (RequestConstant.FALSE.equals(str) || (pVar = f١٣٧٢٢e) == null || (kVar = pVar.f١٣٥٣٧c) == null) {
            return false;
        }
        return kVar.f١٣٥٢٠k;
    }
}
