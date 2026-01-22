package com.taobao.accs;

import android.util.Log;
import anet.channel.GlobalAppRuntimeInfo;
import com.alibaba.sdk.android.error.ErrorBuilder;
import com.alibaba.sdk.android.error.ErrorDefine;
import com.alibaba.sdk.android.error.IntCodeGenerator;
import com.taobao.accs.utl.i;
import com.tencent.imsdk.BaseConstants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class AccsErrorCode {
    public static final com.alibaba.sdk.android.error.ErrorCode APPKEY_NULL;
    public static final com.alibaba.sdk.android.error.ErrorCode APPSECRET_NULL;
    public static final com.alibaba.sdk.android.error.ErrorCode APP_NOT_BIND;
    public static final com.alibaba.sdk.android.error.ErrorCode DM_APPKEY_INVALID;
    public static final com.alibaba.sdk.android.error.ErrorCode DM_DEVICEID_INVALID;
    public static final com.alibaba.sdk.android.error.ErrorCode DM_PACKAGENAME_INVALID;
    public static final com.alibaba.sdk.android.error.ErrorCode DM_TAIR_ERROR;
    public static final com.alibaba.sdk.android.error.ErrorCode ERROR_SHOULD_NEVER_HAPPEN;
    private static final int HTTP_CODE_DM_APPKEY_INVALID = 303;
    private static final int HTTP_CODE_DM_DEVICEID_INVALID = 302;
    private static final int HTTP_CODE_DM_PACKAGENAME_INVALID = 304;
    private static final int HTTP_CODE_DM_TAIR_ERROR = 102;
    private static final int HTTP_CODE_SUCCESS = 200;
    public static final com.alibaba.sdk.android.error.ErrorCode INAPP_CON_DISCONNECTED;
    public static final com.alibaba.sdk.android.error.ErrorCode MESSAGE_HOST_NULL;
    public static final com.alibaba.sdk.android.error.ErrorCode MESSAGE_QUEUE_FULL;
    public static final com.alibaba.sdk.android.error.ErrorCode MESSAGE_TOO_LARGE;
    public static final com.alibaba.sdk.android.error.ErrorCode NETWORKSDK_SPDY_CLOSE_ERROR;
    public static final com.alibaba.sdk.android.error.ErrorCode NETWORKSDK_SPDY_RES_ERROR;
    public static final com.alibaba.sdk.android.error.ErrorCode NETWORK_INAPP_ARGS_INVALID;
    public static final com.alibaba.sdk.android.error.ErrorCode NETWORK_INAPP_CONNECT_FAIL;
    public static final com.alibaba.sdk.android.error.ErrorCode NETWORK_INAPP_EXCEPTION;
    public static final com.alibaba.sdk.android.error.ErrorCode NETWORK_INAPP_NO_STRATEGY;
    public static final com.alibaba.sdk.android.error.ErrorCode NETWORK_INAPP_TIMEOUT;
    public static final com.alibaba.sdk.android.error.ErrorCode NO_NETWORK;
    public static final com.alibaba.sdk.android.error.ErrorCode PARAMETER_ERROR;
    public static final com.alibaba.sdk.android.error.ErrorCode REQ_TIME_OUT;
    public static final com.alibaba.sdk.android.error.ErrorCode RESPONSE_PARSE_ERROR;
    public static final com.alibaba.sdk.android.error.ErrorCode SEND_LOCAL_EXCEPTION;
    public static final com.alibaba.sdk.android.error.ErrorCode SERVER_UNKNOWN_ERROR;
    public static final com.alibaba.sdk.android.error.ErrorCode SERVIER_HIGH_LIMIT;
    public static final com.alibaba.sdk.android.error.ErrorCode SERVIER_HIGH_LIMIT_BRUSH;
    public static final com.alibaba.sdk.android.error.ErrorCode SERVIER_LOW_LIMIT;
    public static final com.alibaba.sdk.android.error.ErrorCode SPDY_AUTH_EXCEPTION;
    public static final com.alibaba.sdk.android.error.ErrorCode SPDY_AUTH_PARAM_ERROR;
    public static final com.alibaba.sdk.android.error.ErrorCode SPDY_CONNECTION_DISCONNECTED_WHEN_SEND_DATA;
    public static final com.alibaba.sdk.android.error.ErrorCode SPDY_CON_DISCONNECTED;
    public static final com.alibaba.sdk.android.error.ErrorCode SPDY_PING_TIME_OUT;
    public static final com.alibaba.sdk.android.error.ErrorCode SUCCESS;
    public static final com.alibaba.sdk.android.error.ErrorCode[] codes;
    private static final ErrorDefine define;

    static {
        ErrorDefine errorDefine = new ErrorDefine("EACCS", new IntCodeGenerator());
        define = errorDefine;
        com.alibaba.sdk.android.error.ErrorCode build = errorDefine.defineSdkError("200").msg("成功").build();
        SUCCESS = build;
        com.alibaba.sdk.android.error.ErrorCode build2 = errorDefine.defineSdkError("300").msg("通道未建立").solution("请先初始化，bindApp，再调用其它api").build();
        APP_NOT_BIND = build2;
        com.alibaba.sdk.android.error.ErrorCode build3 = errorDefine.defineSdkError("-1").msg("静默连接中断，无法发送消息").solution("内部会重试，如果一直失败，需要排查下静默通道是否正常").build();
        SPDY_CONNECTION_DISCONNECTED_WHEN_SEND_DATA = build3;
        com.alibaba.sdk.android.error.ErrorCode build4 = errorDefine.defineSdkError("-2").msg("参数错误,发送的msg为null").solution("请检查发起请求的参数是否正确").build();
        PARAMETER_ERROR = build4;
        com.alibaba.sdk.android.error.ErrorCode build5 = errorDefine.defineSdkError("-3").msg("服务返回数据异常").solution("请关注错误信息中的服务返回数据，并联系阿里云技术支持同学确认原因").build();
        RESPONSE_PARSE_ERROR = build5;
        com.alibaba.sdk.android.error.ErrorCode build6 = errorDefine.defineSdkError("-4").msg("单次发送数据过大").solution("请减少一次发送的数据量，封装之后总的数据量要小于16KB").build();
        MESSAGE_TOO_LARGE = build6;
        com.alibaba.sdk.android.error.ErrorCode build7 = errorDefine.defineSdkError("-5").msg("发送服务地址为null").solution("请检查下初始化配置是否正确").build();
        MESSAGE_HOST_NULL = build7;
        com.alibaba.sdk.android.error.ErrorCode build8 = errorDefine.defineSdkError("-6").msg("静默通道长连接认证参数错误").solution("请检查初始化参数配置是否正确").build();
        SPDY_AUTH_PARAM_ERROR = build8;
        com.alibaba.sdk.android.error.ErrorCode build9 = errorDefine.defineSdkError("-7").msg("静默通道长连接认证异常").solution("请查看错误信息，确认具体异常信息").build();
        SPDY_AUTH_EXCEPTION = build9;
        com.alibaba.sdk.android.error.ErrorCode build10 = errorDefine.defineSdkError("-8").msg("发送数据异常").solution("请查看错误信息，确认具体异常信息").build();
        SEND_LOCAL_EXCEPTION = build10;
        com.alibaba.sdk.android.error.ErrorCode build11 = errorDefine.defineSdkError("-9").msg("发送消息超时").solution("需要结合具体是查看为什么超时").build();
        REQ_TIME_OUT = build11;
        com.alibaba.sdk.android.error.ErrorCode build12 = errorDefine.defineSdkError("-10").msg("静默通道长连接断连").solution("断连需要查看之前的日志").build();
        SPDY_CON_DISCONNECTED = build12;
        com.alibaba.sdk.android.error.ErrorCode build13 = errorDefine.defineSdkError("-11").msg("应用内长连接断开").solution("一般为长连接建连失败造成，需要看日志分析").build();
        INAPP_CON_DISCONNECTED = build13;
        com.alibaba.sdk.android.error.ErrorCode build14 = errorDefine.defineSdkError("-12").msg("静默通道长连接ping超时").build();
        SPDY_PING_TIME_OUT = build14;
        com.alibaba.sdk.android.error.ErrorCode build15 = errorDefine.defineSdkError("-13").msg("无网络").solution("请检查网络连接").build();
        NO_NETWORK = build15;
        com.alibaba.sdk.android.error.ErrorCode build16 = errorDefine.defineSdkError("-14").msg("appKey不存在").solution("请检查初始化配置是否正确").build();
        APPKEY_NULL = build16;
        com.alibaba.sdk.android.error.ErrorCode build17 = errorDefine.defineSdkError("-15").msg("appSecret不存在").solution("请检查初始化配置是否正确").build();
        APPSECRET_NULL = build17;
        com.alibaba.sdk.android.error.ErrorCode build18 = errorDefine.defineServerError("70008").msg("长连接发送队列已满").solution("请确认是否有高并发发送消息，如果有，请限制发送频次").build();
        MESSAGE_QUEUE_FULL = build18;
        com.alibaba.sdk.android.error.ErrorCode build19 = errorDefine.defineServerError("70020").msg("低级别限流").solution("请和部署同学确认限流策略").build();
        SERVIER_LOW_LIMIT = build19;
        com.alibaba.sdk.android.error.ErrorCode build20 = errorDefine.defineServerError("70021").msg("高级别限流,不发送").solution("请和部署同学确认限流策略").build();
        SERVIER_HIGH_LIMIT = build20;
        com.alibaba.sdk.android.error.ErrorCode build21 = errorDefine.defineServerError("70023").msg("防刷解封后触发的限流，不发送").solution("请和部署同学确认限流策略").build();
        SERVIER_HIGH_LIMIT_BRUSH = build21;
        com.alibaba.sdk.android.error.ErrorCode build22 = errorDefine.defineServerError("102").msg("设备无效").solution("如果是测试时发现的，请清除应用数据重新尝试").build();
        DM_TAIR_ERROR = build22;
        com.alibaba.sdk.android.error.ErrorCode build23 = errorDefine.defineServerError("302").msg("设备无效").solution("如果是测试时发现的，请清除应用数据重新尝试").build();
        DM_DEVICEID_INVALID = build23;
        com.alibaba.sdk.android.error.ErrorCode build24 = errorDefine.defineServerError("303").msg("appkey配置错误").solution("请检查appKey配置是否正确").build();
        DM_APPKEY_INVALID = build24;
        com.alibaba.sdk.android.error.ErrorCode build25 = errorDefine.defineServerError("304").msg("包名错误").solution("请检查appKey和应用包名是否匹配").build();
        DM_PACKAGENAME_INVALID = build25;
        com.alibaba.sdk.android.error.ErrorCode build26 = errorDefine.defineServerError("-20").msg("服务返回错误").solution("请关注下错误信息中的服务返回的错误码，并联系阿里云技术支持同学确认原因").build();
        SERVER_UNKNOWN_ERROR = build26;
        com.alibaba.sdk.android.error.ErrorCode build27 = errorDefine.defineSdkError("-22").msg("底层sdk连接关闭").solution("请关注下错误信息中的底层sdk返回的错误信息，并联系阿里云技术支持同学确认原因").build();
        NETWORKSDK_SPDY_CLOSE_ERROR = build27;
        com.alibaba.sdk.android.error.ErrorCode build28 = errorDefine.defineSdkError("-23").msg("发送数据返回错误").solution("请关注下错误信息中的底层sdk返回的错误信息，并联系阿里云技术支持同学确认原因").build();
        NETWORKSDK_SPDY_RES_ERROR = build28;
        com.alibaba.sdk.android.error.ErrorCode build29 = errorDefine.defineSdkError("-25").msg("不应该发生的错误").solution("请关注下错误信息，检查初始化是否存在错误").build();
        ERROR_SHOULD_NEVER_HAPPEN = build29;
        com.alibaba.sdk.android.error.ErrorCode build30 = errorDefine.defineSdkError("-26").msg("建连参数错误").solution("请检查初始化配置是否正确").build();
        NETWORK_INAPP_ARGS_INVALID = build30;
        com.alibaba.sdk.android.error.ErrorCode build31 = errorDefine.defineSdkError("-27").msg("建连超时").solution("请查看具体错误信息排查").solution("请检查网络是否正常").build();
        NETWORK_INAPP_TIMEOUT = build31;
        com.alibaba.sdk.android.error.ErrorCode build32 = errorDefine.defineSdkError("-28").msg("建连失败").solution("请查看具体错误信息排查").solution("请检查网络是否正常").build();
        NETWORK_INAPP_CONNECT_FAIL = build32;
        com.alibaba.sdk.android.error.ErrorCode build33 = errorDefine.defineSdkError("-29").msg("连接地址不存在").solution("当前网络下无法解析长链接地址").solution("请检查网络是否正常").build();
        NETWORK_INAPP_NO_STRATEGY = build33;
        com.alibaba.sdk.android.error.ErrorCode build34 = errorDefine.defineSdkError("-30").msg("建连异常").solution("请查看具体错误信息排查").build();
        NETWORK_INAPP_EXCEPTION = build34;
        codes = new com.alibaba.sdk.android.error.ErrorCode[]{build, build2, build3, build4, build5, build6, build7, build8, build9, build10, build11, build12, build13, build14, build15, build16, build17, build18, build19, build20, build21, build22, build23, build24, build25, build26, build27, build28, build29, build30, build31, build32, build33, build34, convertNetworkSdkError(0, "底层网络库信息").solution("小于-10000时，加上10000是底层网络库对应的错误码，请接口底层网络库错误码信息排查").build()};
    }

    private static StringBuilder addThrowableInfo(StringBuilder sb2, Throwable th) {
        while (true) {
            sb2.append(th.getMessage());
            sb2.append('\t');
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                sb2.append(stackTrace[0].getClassName());
                sb2.append(".");
                sb2.append(stackTrace[0].getMethodName());
                sb2.append('\t');
                for (int i = 1; i < stackTrace.length; i++) {
                    if (stackTrace[i].getClassName().startsWith("com.taobao") || stackTrace[i].getClassName().startsWith("com.aliyun") || stackTrace[i].getClassName().startsWith("org.android.agoo") || stackTrace[i].getClassName().startsWith("org.alibaba")) {
                        sb2.append(stackTrace[i].getClassName());
                        sb2.append(".");
                        sb2.append(stackTrace[i].getMethodName());
                        sb2.append("(");
                        sb2.append(stackTrace[i].getFileName());
                        sb2.append(":");
                        sb2.append(stackTrace[i].getLineNumber());
                        sb2.append(")");
                        sb2.append('\t');
                        break;
                    }
                }
            }
            th = th.getCause();
            if (th != null) {
                sb2.append("caused by ");
                sb2.append('\t');
            } else {
                return sb2;
            }
        }
    }

    public static ErrorBuilder convertNetworkSdkError(int i, String str) {
        return define.defineSdkError(String.valueOf(i + BaseConstants.ERR_SVR_SSO_VCODE)).msg(str);
    }

    public static String getAllDetails(String str) {
        return "[" + AccsState.getInstance().getState() + "][" + i.a().b() + "][" + GlobalAppRuntimeInfo.isAppBackground() + "]" + str;
    }

    public static String getExceptionInfo(Throwable th) {
        if (th == null) {
            return "throwable null";
        }
        return addThrowableInfo(new StringBuilder(), th).toString();
    }

    public static boolean isChannelError(int i) {
        if (i != SPDY_CONNECTION_DISCONNECTED_WHEN_SEND_DATA.getCodeInt() && i != SPDY_AUTH_PARAM_ERROR.getCodeInt() && i != SPDY_AUTH_EXCEPTION.getCodeInt() && i != REQ_TIME_OUT.getCodeInt() && i != SPDY_CON_DISCONNECTED.getCodeInt() && i != INAPP_CON_DISCONNECTED.getCodeInt() && i != SPDY_PING_TIME_OUT.getCodeInt() && i != NETWORKSDK_SPDY_CLOSE_ERROR.getCodeInt() && i != NETWORK_INAPP_ARGS_INVALID.getCodeInt() && i != NETWORK_INAPP_TIMEOUT.getCodeInt() && i != NETWORK_INAPP_CONNECT_FAIL.getCodeInt() && i != NETWORK_INAPP_NO_STRATEGY.getCodeInt() && i != NETWORK_INAPP_EXCEPTION.getCodeInt()) {
            return false;
        }
        return true;
    }

    public static com.alibaba.sdk.android.error.ErrorCode parseHttpCode(int i) {
        if (i != 102) {
            if (i != 200) {
                switch (i) {
                    case 302:
                        return DM_DEVICEID_INVALID;
                    case 303:
                        return DM_APPKEY_INVALID;
                    case 304:
                        return DM_PACKAGENAME_INVALID;
                    default:
                        return SERVER_UNKNOWN_ERROR.copy().detail("code:" + i).build();
                }
            }
            return SUCCESS;
        }
        return DM_TAIR_ERROR;
    }

    public static void printErrorCode() {
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("ACCS错误码，一共");
        com.alibaba.sdk.android.error.ErrorCode[] errorCodeArr = codes;
        sb3.append(errorCodeArr.length);
        sb3.append("个");
        sb2.append(sb3.toString());
        sb2.append('\n');
        sb2.append(com.alibaba.sdk.android.error.ErrorCode.docTitle());
        sb2.append(com.alibaba.sdk.android.error.ErrorCode.docContent(errorCodeArr));
        Log.w("ACCS_ERROR_CODE", sb2.toString());
    }
}
