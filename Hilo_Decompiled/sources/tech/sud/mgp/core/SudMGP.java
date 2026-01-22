package tech.sud.mgp.core;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.tencent.imsdk.BaseConstants;
import e.d;
import h0.b;
import j0.v;
import java.util.List;
import o0.j;
import o0.m;
import q0.c;
import qf.i;
import qf.x;
import tech.sud.base.utils.Utils;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.ISudCfg;
import tech.sud.gip.core.ISudFSMMG;
import tech.sud.gip.core.ISudFSTAPP;
import tech.sud.gip.core.ISudListenerGetMGList;
import tech.sud.gip.core.ISudListenerInitSDK;
import tech.sud.gip.core.ISudListenerPreloadMGPkg;
import tech.sud.gip.core.ISudListenerReportStatsEvent;
import tech.sud.gip.core.ISudListenerUninitSDK;
import tech.sud.gip.core.ISudLogger;
import tech.sud.gip.core.SudInitSDKParamModel;
import tech.sud.gip.core.SudLoadMGParamModel;
import tech.sud.gip.core.network.detection.INetworkDetectionFuture;
import tech.sud.gip.core.network.detection.INetworkDetectionListener;
import tech.sud.gip.core.network.detection.NetworkDetectionResult;
import tech.sud.gip.core.network.detection.SudNetworkDetectionParamModel;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class SudMGP {
    private static final String FILE_TAG = "SudMGP";
    private static final String _TAG = "SudMGP SudMGP";

    public static void cancelPreloadMGPkgList(List<Long> list) {
        if (!ThreadUtils.checkUIThread()) {
            LogUtils.file(FILE_TAG, "cancelPreloadMGPkgList Please call on UI or Main thread");
            return;
        }
        v vVar = v.c;
        if (vVar == null) {
            LogUtils.file(FILE_TAG, "cancelPreloadMGPkgList preloader is null");
        } else {
            vVar.cancelPreloadMGPkgList(list);
        }
    }

    public static boolean destroyMG(ISudFSTAPP iSudFSTAPP) {
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(FILE_TAG, "destroyMG Please call on UI or Main thread");
            LogUtils.file(FILE_TAG, "destroyMG Please call on UI or Main thread");
            return false;
        }
        if (iSudFSTAPP != null) {
            return iSudFSTAPP.destroyMG();
        }
        return true;
    }

    public static ISudCfg getCfg() {
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(FILE_TAG, "Please call on UI or Main thread");
        }
        return b.a;
    }

    public static String getLogDirPath(Context context) {
        return LogUtils.getLogDirPath(context);
    }

    public static void getMGList(ISudListenerGetMGList iSudListenerGetMGList) {
        if (!ThreadUtils.checkUIThread() && iSudListenerGetMGList != null) {
            iSudListenerGetMGList.onFailure(-1, "Please call on UI or Main thread");
        }
        String str = d.a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            x xVar = d.b;
            if (!xVar.a) {
                if (iSudListenerGetMGList != null) {
                    iSudListenerGetMGList.onFailure(BaseConstants.ERR_SVR_SSO_IDENTIFIER_INVALID, "Please call initSDK first successfully");
                    return;
                }
                return;
            } else {
                i.c.execute(new qf.b(xVar, xVar.i, iSudListenerGetMGList));
                return;
            }
        }
        if (iSudListenerGetMGList != null) {
            iSudListenerGetMGList.onFailure(-1, "Please call on UI or Main thread");
        }
    }

    public static String getVersion() {
        return "1.6.6.1277";
    }

    public static String getVersionAlias() {
        return "v1.6.6.1277-static";
    }

    public static void initSDK(SudInitSDKParamModel sudInitSDKParamModel, ISudListenerInitSDK iSudListenerInitSDK) {
        d.b(sudInitSDKParamModel, iSudListenerInitSDK, (m) null, (m) null);
    }

    @Deprecated
    public static ISudFSTAPP loadMG(Activity activity, String str, String str2, String str3, long j, String str4, ISudFSMMG iSudFSMMG) {
        SudLoadMGParamModel sudLoadMGParamModel = new SudLoadMGParamModel();
        sudLoadMGParamModel.activity = activity;
        sudLoadMGParamModel.userId = str;
        sudLoadMGParamModel.roomId = str2;
        sudLoadMGParamModel.code = str3;
        sudLoadMGParamModel.mgId = j;
        sudLoadMGParamModel.language = str4;
        return loadMG(sudLoadMGParamModel, iSudFSMMG);
    }

    public static void preloadMGPkgList(Context context, List<Long> list, ISudListenerPreloadMGPkg iSudListenerPreloadMGPkg) {
        if (!ThreadUtils.checkUIThread()) {
            if (iSudListenerPreloadMGPkg != null) {
                iSudListenerPreloadMGPkg.onPreloadFailure(0L, -1, "Please call on UI or Main thread");
            }
            LogUtils.file(FILE_TAG, "preloadMGPkgList Please call on UI or Main thread");
            return;
        }
        v vVar = v.c;
        if (vVar == null) {
            if (iSudListenerPreloadMGPkg != null) {
                iSudListenerPreloadMGPkg.onPreloadFailure(0L, BaseConstants.ERR_SVR_SSO_IDENTIFIER_INVALID, "Please call initSDK first successfully");
            }
            LogUtils.file(FILE_TAG, "preloadMGPkgList Please call initSDK first successfully");
        } else {
            if (list != null && list.size() != 0) {
                vVar.preloadMGPkgList(context, list, iSudListenerPreloadMGPkg);
                return;
            }
            if (iSudListenerPreloadMGPkg != null) {
                iSudListenerPreloadMGPkg.onPreloadFailure(0L, BaseConstants.ERR_SVR_SSO_CLIENT_CLOSE, "Parameters cannot be null");
            }
            LogUtils.file(FILE_TAG, "preloadMGPkgList Please call initSDK first successfully");
        }
    }

    public static void setLogLevel(int i) {
        LogUtils.file(FILE_TAG, "setLogLevel:" + i);
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(FILE_TAG, "Please call on UI or Main thread");
            LogUtils.file(FILE_TAG, "setLogLevel Please call on UI or Main thread");
        } else {
            SudLogger.setLogLevel(i);
        }
    }

    public static void setLogger(ISudLogger iSudLogger) {
        LogUtils.file(FILE_TAG, "setLogger:" + iSudLogger);
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(FILE_TAG, "Please call on UI or Main thread");
            LogUtils.file(FILE_TAG, "setLogger Please call on UI or Main thread");
        } else {
            SudLogger.setLogger(iSudLogger);
        }
    }

    public static boolean setReportStatsEventListener(ISudListenerReportStatsEvent iSudListenerReportStatsEvent) {
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(FILE_TAG, "Please call on UI or Main thread");
            return false;
        }
        f.d.b = iSudListenerReportStatsEvent;
        return true;
    }

    @Deprecated
    public static void setUserId(String str) {
    }

    public static INetworkDetectionFuture startNetworkDetection(SudNetworkDetectionParamModel sudNetworkDetectionParamModel, INetworkDetectionListener iNetworkDetectionListener) {
        if (sudNetworkDetectionParamModel != null && sudNetworkDetectionParamModel.check()) {
            j jVar = new j(sudNetworkDetectionParamModel, iNetworkDetectionListener);
            new Thread((Runnable) jVar).start();
            return jVar.c;
        }
        LogUtils.file(FILE_TAG, "initSDK Parameters cannot be null");
        SudLogger.e(_TAG, "initSDK Parameters cannot be null");
        if (iNetworkDetectionListener != null) {
            NetworkDetectionResult networkDetectionResult = new NetworkDetectionResult();
            networkDetectionResult.code = BaseConstants.ERR_SVR_SSO_CLIENT_CLOSE;
            networkDetectionResult.msg = "Parameters cannot be null";
            iNetworkDetectionListener.onCompleted(networkDetectionResult);
            return null;
        }
        return null;
    }

    public static void uninitSDK(ISudListenerUninitSDK iSudListenerUninitSDK) {
        LogUtils.file(FILE_TAG, "uninitSDK");
        if (!ThreadUtils.checkUIThread()) {
            if (iSudListenerUninitSDK != null) {
                iSudListenerUninitSDK.onFailure(-1, "Please call on UI or Main thread");
            }
        } else {
            d.b.f();
            if (iSudListenerUninitSDK != null) {
                iSudListenerUninitSDK.onSuccess();
            }
        }
    }

    @Deprecated
    public static void initSDK(Context context, String str, String str2, boolean z, ISudListenerInitSDK iSudListenerInitSDK) {
        SudInitSDKParamModel sudInitSDKParamModel = new SudInitSDKParamModel();
        sudInitSDKParamModel.context = context.getApplicationContext();
        sudInitSDKParamModel.appId = str;
        sudInitSDKParamModel.appKey = str2;
        sudInitSDKParamModel.isTestEnv = z;
        initSDK(sudInitSDKParamModel, iSudListenerInitSDK);
    }

    public static ISudFSTAPP loadMG(SudLoadMGParamModel sudLoadMGParamModel, ISudFSMMG iSudFSMMG) {
        String str = _TAG;
        SudLogger.i(str, "loadMG");
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(str, "Please call on UI or Main thread");
            LogUtils.file(FILE_TAG, "loadMG Please call on UI or Main thread");
            return null;
        }
        if (sudLoadMGParamModel != null && sudLoadMGParamModel.check() && iSudFSMMG != null) {
            Utils.initContext(sudLoadMGParamModel.activity);
            f.d.a = sudLoadMGParamModel.userId;
            d.d = sudLoadMGParamModel.language;
            return new c(sudLoadMGParamModel, iSudFSMMG);
        }
        SudLogger.e(str, "Parameters cannot be null");
        LogUtils.file(FILE_TAG, "loadMG Parameters cannot be null");
        return null;
    }
}
