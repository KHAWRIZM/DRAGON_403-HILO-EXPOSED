package com.tencent.qgame.animplayer;

import com.taobao.accs.utl.UtilityImpl;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\r2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u00020\r8\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0002R\u0016\u0010\u001c\u001a\u00020\r8\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u0002R\u0016\u0010\u001e\u001a\u00020\r8\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u0002R\u0016\u0010 \u001a\u00020\r8\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u0002¨\u0006%"}, d2 = {"Lcom/tencent/qgame/animplayer/Constant;", "", "()V", "ERROR_MSG_CONFIG_PLUGIN_MIX", "", "ERROR_MSG_CREATE_RENDER", "ERROR_MSG_CREATE_THREAD", "ERROR_MSG_DECODE_EXC", "ERROR_MSG_EXTRACTOR_EXC", "ERROR_MSG_FILE_ERROR", "ERROR_MSG_HEVC_NOT_SUPPORT", "ERROR_MSG_PARSE_CONFIG", "OK", "", "ORIEN_DEFAULT", "ORIEN_LANDSCAPE", "ORIEN_PORTRAIT", "REPORT_ERROR_TYPE_CONFIG_PLUGIN_MIX", "REPORT_ERROR_TYPE_CREATE_RENDER", "REPORT_ERROR_TYPE_CREATE_THREAD", "REPORT_ERROR_TYPE_DECODE_EXC", "REPORT_ERROR_TYPE_EXTRACTOR_EXC", "REPORT_ERROR_TYPE_FILE_ERROR", "REPORT_ERROR_TYPE_HEVC_NOT_SUPPORT", "REPORT_ERROR_TYPE_PARSE_CONFIG", "TAG", "VIDEO_MODE_SPLIT_HORIZONTAL", "VIDEO_MODE_SPLIT_HORIZONTAL$annotations", "VIDEO_MODE_SPLIT_HORIZONTAL_REVERSE", "VIDEO_MODE_SPLIT_HORIZONTAL_REVERSE$annotations", "VIDEO_MODE_SPLIT_VERTICAL", "VIDEO_MODE_SPLIT_VERTICAL$annotations", "VIDEO_MODE_SPLIT_VERTICAL_REVERSE", "VIDEO_MODE_SPLIT_VERTICAL_REVERSE$annotations", "getErrorMsg", "errorType", "errorMsg", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class Constant {

    @NotNull
    public static final String ERROR_MSG_CONFIG_PLUGIN_MIX = "0x6 vapx fail";

    @NotNull
    public static final String ERROR_MSG_CREATE_RENDER = "0x4 render create fail";

    @NotNull
    public static final String ERROR_MSG_CREATE_THREAD = "0x3 thread create fail";

    @NotNull
    public static final String ERROR_MSG_DECODE_EXC = "0x2 MediaCodec exception";

    @NotNull
    public static final String ERROR_MSG_EXTRACTOR_EXC = "0x1 MediaExtractor exception";

    @NotNull
    public static final String ERROR_MSG_FILE_ERROR = "0x7 file can't read";

    @NotNull
    public static final String ERROR_MSG_HEVC_NOT_SUPPORT = "0x8 hevc not support";

    @NotNull
    public static final String ERROR_MSG_PARSE_CONFIG = "0x5 parse config fail";
    public static final Constant INSTANCE = new Constant();
    public static final int OK = 0;
    public static final int ORIEN_DEFAULT = 0;
    public static final int ORIEN_LANDSCAPE = 2;
    public static final int ORIEN_PORTRAIT = 1;
    public static final int REPORT_ERROR_TYPE_CONFIG_PLUGIN_MIX = 10006;
    public static final int REPORT_ERROR_TYPE_CREATE_RENDER = 10004;
    public static final int REPORT_ERROR_TYPE_CREATE_THREAD = 10003;
    public static final int REPORT_ERROR_TYPE_DECODE_EXC = 10002;
    public static final int REPORT_ERROR_TYPE_EXTRACTOR_EXC = 10001;
    public static final int REPORT_ERROR_TYPE_FILE_ERROR = 10007;
    public static final int REPORT_ERROR_TYPE_HEVC_NOT_SUPPORT = 10008;
    public static final int REPORT_ERROR_TYPE_PARSE_CONFIG = 10005;

    @NotNull
    public static final String TAG = "AnimPlayer";
    public static final int VIDEO_MODE_SPLIT_HORIZONTAL = 1;
    public static final int VIDEO_MODE_SPLIT_HORIZONTAL_REVERSE = 3;
    public static final int VIDEO_MODE_SPLIT_VERTICAL = 2;
    public static final int VIDEO_MODE_SPLIT_VERTICAL_REVERSE = 4;

    private Constant() {
    }

    @Deprecated(message = "Compatible older version mp4")
    public static /* synthetic */ void VIDEO_MODE_SPLIT_HORIZONTAL$annotations() {
    }

    @Deprecated(message = "Compatible older version mp4")
    public static /* synthetic */ void VIDEO_MODE_SPLIT_HORIZONTAL_REVERSE$annotations() {
    }

    @Deprecated(message = "Compatible older version mp4")
    public static /* synthetic */ void VIDEO_MODE_SPLIT_VERTICAL$annotations() {
    }

    @Deprecated(message = "Compatible older version mp4")
    public static /* synthetic */ void VIDEO_MODE_SPLIT_VERTICAL_REVERSE$annotations() {
    }

    public static /* synthetic */ String getErrorMsg$default(Constant constant, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return constant.getErrorMsg(i, str);
    }

    @NotNull
    public final String getErrorMsg(int errorType, @Nullable String errorMsg) {
        String str;
        StringBuilder sb2 = new StringBuilder();
        switch (errorType) {
            case REPORT_ERROR_TYPE_EXTRACTOR_EXC /* 10001 */:
                str = ERROR_MSG_EXTRACTOR_EXC;
                break;
            case 10002:
                str = ERROR_MSG_DECODE_EXC;
                break;
            case 10003:
                str = ERROR_MSG_CREATE_THREAD;
                break;
            case 10004:
                str = ERROR_MSG_CREATE_RENDER;
                break;
            case 10005:
                str = ERROR_MSG_PARSE_CONFIG;
                break;
            case 10006:
                str = ERROR_MSG_CONFIG_PLUGIN_MIX;
                break;
            default:
                str = UtilityImpl.NET_TYPE_UNKNOWN;
                break;
        }
        sb2.append(str);
        sb2.append(' ');
        if (errorMsg == null) {
            errorMsg = "";
        }
        sb2.append(errorMsg);
        return sb2.toString();
    }
}
