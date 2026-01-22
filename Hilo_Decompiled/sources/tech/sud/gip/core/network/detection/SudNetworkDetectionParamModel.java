package tech.sud.gip.core.network.detection;

import android.content.Context;
import android.text.TextUtils;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class SudNetworkDetectionParamModel {
    private static final String FILE_TAG = "SudNetworkDetectionParamModel";
    private static String _TAG = "SudNetworkDetectionParamModel";
    public String appId;
    public String appKey;
    public Context context;
    public boolean isTestEnv;
    public String userId;

    public boolean check() {
        if (this.context == null) {
            SudLogger.e(_TAG, "Please check context invalid");
            LogUtils.file(FILE_TAG, "Please check context invalid");
            return false;
        }
        if (TextUtils.isEmpty(this.appId)) {
            SudLogger.e(_TAG, "Please check appId invalid");
            LogUtils.file(FILE_TAG, "Please check appId invalid");
            return false;
        }
        if (TextUtils.isEmpty(this.appKey)) {
            SudLogger.e(_TAG, "Please check appKey invalid");
            LogUtils.file(FILE_TAG, "Please check appKey invalid");
            return false;
        }
        return true;
    }
}
