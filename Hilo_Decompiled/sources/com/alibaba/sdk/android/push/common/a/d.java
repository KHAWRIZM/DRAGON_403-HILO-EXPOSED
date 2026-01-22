package com.alibaba.sdk.android.push.common.a;

import com.alibaba.sdk.android.error.CodeGenerator;
import com.alibaba.sdk.android.error.ErrorBuilder;
import com.alibaba.sdk.android.error.ErrorCode;
import com.alibaba.sdk.android.error.ErrorDefine;
import com.facebook.internal.security.CertificateUtil;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final ErrorCode f٦٥٨٩a;

    /* renamed from: b, reason: collision with root package name */
    public static final ErrorCode f٦٥٩٠b;

    /* renamed from: c, reason: collision with root package name */
    public static final ErrorCode f٦٥٩١c;

    /* renamed from: d, reason: collision with root package name */
    public static final ErrorCode f٦٥٩٢d;

    /* renamed from: e, reason: collision with root package name */
    public static final ErrorCode f٦٥٩٣e;

    /* renamed from: f, reason: collision with root package name */
    public static final ErrorCode f٦٥٩٤f;

    /* renamed from: g, reason: collision with root package name */
    public static final ErrorCode f٦٥٩٥g;

    /* renamed from: h, reason: collision with root package name */
    public static final ErrorCode f٦٥٩٦h;

    /* renamed from: i, reason: collision with root package name */
    public static final ErrorCode f٦٥٩٧i;

    /* renamed from: j, reason: collision with root package name */
    public static final ErrorCode f٦٥٩٨j;

    /* renamed from: k, reason: collision with root package name */
    public static final ErrorCode f٦٥٩٩k;

    /* renamed from: l, reason: collision with root package name */
    public static final ErrorCode f٦٦٠٠l;

    /* renamed from: m, reason: collision with root package name */
    public static final ErrorCode f٦٦٠١m;

    /* renamed from: n, reason: collision with root package name */
    public static final ErrorCode f٦٦٠٢n;

    /* renamed from: o, reason: collision with root package name */
    public static final ErrorCode f٦٦٠٣o;

    /* renamed from: p, reason: collision with root package name */
    public static final ErrorCode f٦٦٠٤p;

    /* renamed from: q, reason: collision with root package name */
    public static final ErrorCode f٦٦٠٥q;

    /* renamed from: r, reason: collision with root package name */
    public static final ErrorCode f٦٦٠٦r;

    /* renamed from: s, reason: collision with root package name */
    public static final ErrorCode f٦٦٠٧s;

    /* renamed from: t, reason: collision with root package name */
    public static final ErrorCode f٦٦٠٨t;

    /* renamed from: u, reason: collision with root package name */
    public static final ErrorCode f٦٦٠٩u;

    /* renamed from: v, reason: collision with root package name */
    public static final ErrorCode f٦٦١٠v;

    /* renamed from: w, reason: collision with root package name */
    public static final ErrorCode f٦٦١١w;

    /* renamed from: x, reason: collision with root package name */
    public static final ErrorCode[] f٦٦١٢x;

    /* renamed from: y, reason: collision with root package name */
    private static final ErrorDefine f٦٦١٣y;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a extends CodeGenerator {
        private a() {
        }

        @Override // com.alibaba.sdk.android.error.CodeGenerator
        public String generateCodeStr(String str, String str2, String str3) {
            return str + "_" + str3;
        }
    }

    static {
        ErrorDefine errorDefine = new ErrorDefine("PUSH", new a());
        f٦٦١٣y = errorDefine;
        ErrorCode build = errorDefine.defineSdkError("00000").msg("success").build();
        f٦٥٨٩a = build;
        ErrorCode build2 = errorDefine.defineServerError("10101").msg("参数缺失").solution("请检查请求参数是否正确").build();
        f٦٥٩٠b = build2;
        ErrorCode build3 = errorDefine.defineServerError("10102").msg("参数无效").solution("请检查请求参数是否正确").build();
        f٦٥٩١c = build3;
        ErrorCode build4 = errorDefine.defineServerError("10103").msg("服务端签名与客户端不匹配").solution("请检查推送配置是否正确").build();
        f٦٥٩٢d = build4;
        ErrorCode build5 = errorDefine.defineServerError("10104").msg("Tag相关错误").solution("请根据具体错误信息排查，如果不能解决，请联系阿里云技术支持").build();
        f٦٥٩٣e = build5;
        ErrorCode build6 = errorDefine.defineServerError("10105").msg("Alias相关错误").solution("请根据具体错误信息排查，如果不能解决，请联系阿里云技术支持").build();
        f٦٥٩٤f = build6;
        ErrorCode build7 = errorDefine.defineServerError("10106").msg("服务端内部错误").solution("请根据具体错误信息联系阿里云技术支持").build();
        f٦٥٩٥g = build7;
        ErrorCode build8 = errorDefine.defineAndroidError("10107").msg("网络IO错误").solution("请检查网络是否可用").solution("请根据具体错误信息排查，如果不能解决，请联系阿里云技术支持").build();
        f٦٥٩٦h = build8;
        ErrorCode build9 = errorDefine.defineSdkError("10108").msg("返回结果解析错误").solution("请保留具体错误信息，联系阿里云技术支持排查").build();
        f٦٥٩٧i = build9;
        ErrorCode build10 = errorDefine.defineSdkError("10109").msg("网络连接失败,请检查网络配置").solution("请检查网络是否可用").build();
        f٦٥٩٨j = build10;
        ErrorCode build11 = errorDefine.defineSdkError("10114").msg("内部错误").solution("请保留具体错误信息，联系阿里云技术支持排查").build();
        f٦٥٩٩k = build11;
        ErrorCode build12 = errorDefine.defineSdkError("10115").msg("通道注册状态异常").solution("请保留具体错误信息，联系阿里云技术支持排查").build();
        f٦٦٠٠l = build12;
        ErrorCode build13 = errorDefine.defineServerError("10118").msg("其它接口错误").solution("请根据具体错误信息联系阿里云技术支持").build();
        f٦٦٠١m = build13;
        ErrorCode build14 = errorDefine.defineSdkError("10119").msg("非主进程不用初始化").solution("在非主进程执行初始化时触发，可以忽略").build();
        f٦٦٠٢n = build14;
        ErrorCode build15 = errorDefine.defineSdkError("10120").msg("推送注册超时").solution("请保留具体错误信息，联系阿里云技术支持排查").build();
        f٦٦٠٣o = build15;
        ErrorCode build16 = errorDefine.defineAndroidError("10121").msg("网络请求失败，请检查网络是否可用").solution("请检查网络是否可用").solution("请根据具体错误信息排查，如果不能解决，请联系阿里云技术支持").build();
        f٦٦٠٤p = build16;
        ErrorCode build17 = errorDefine.defineSdkError("20101").msg("参数输入非法").solution("请检查请求的输入参数是否正确").build();
        f٦٦٠٥q = build17;
        ErrorCode build18 = errorDefine.defineSdkError("20103").msg("appversion参数错误,请检查您的版本号,版本号不能为null或长度不能超过32位").solution("开启debug会检查此错误，请检查应用版本号是否过长").build();
        f٦٦٠٦r = build18;
        ErrorCode build19 = errorDefine.defineSdkError("20106").msg("核心组件未配置").solution("开启debug会检查此错误，请检查是否删除了推送组件的声明").build();
        f٦٦٠٧s = build19;
        ErrorCode build20 = errorDefine.defineSdkError("20107").msg("连续crash，推送服务关闭").solution("应用初始化推送后崩溃，会在下次启动关闭推送服务。请检查应用的崩溃记录").solution("开发测试场景下，人为触发的，请清除应用数据恢复").solution("线上场景会尝试自动恢复，如果仍然崩溃，需要升级应用版本才会恢复").build();
        f٦٦٠٨t = build20;
        ErrorCode build21 = errorDefine.defineSdkError("20108").msg("未初始化，请先调用 PushServiceFactory的init方法").solution("请确认是否正常初始化").build();
        f٦٦٠٩u = build21;
        ErrorCode build22 = errorDefine.defineSdkError("20109").msg("废弃接口").solution("请查看文档，使用合适的api").build();
        f٦٦١٠v = build22;
        ErrorCode build23 = errorDefine.defineSdkError("20110").msg("已经调用注册，重复调用无效").solution("register方法如果失败了，会自动重试，一般情况下不需要重复调用").solution("如果希望内部重试失败的情况，由外部重新调用register，请至少在上一次register失败回调两次（确认内部重试还是失败）的情况下，先调用PushControlService的reset方法，然后再调用下一次register方法").build();
        f٦٦١١w = build23;
        f٦٦١٢x = new ErrorCode[]{build, build2, build3, build4, build5, build6, build7, build8, build9, build10, build11, build12, build13, build14, build15, build16, build17, build18, build19, build20, build21, build22, build23, a(123, "accs错误信息").solution("格式ACCS_123, 123为accs错误码，请结合accs错误码排查").build(), a("xxx", "agoo错误信息").solution("格式AGOO_xxx, xxx为agoo错误码，请结合agoo错误码排查").build()};
    }

    public static ErrorBuilder a(int i10, String str) {
        return f٦٦١٣y.defineSdkError("ACCS_" + i10).msg(str);
    }

    public static ErrorCode b(String str, String str2) {
        ErrorCode errorCode;
        ErrorBuilder msg;
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1693386453:
                if (str.equals("InternalError")) {
                    c10 = 0;
                    break;
                }
                break;
            case -996611353:
                if (str.equals("MissingParam")) {
                    c10 = 1;
                    break;
                }
                break;
            case -723241298:
                if (str.equals("TagError")) {
                    c10 = 2;
                    break;
                }
                break;
            case -265907281:
                if (str.equals("SignNotMatch")) {
                    c10 = 3;
                    break;
                }
                break;
            case 2524:
                if (str.equals("OK")) {
                    c10 = 4;
                    break;
                }
                break;
            case 39557560:
                if (str.equals("AliasError")) {
                    c10 = 5;
                    break;
                }
                break;
            case 677129462:
                if (str.equals("InvalidParam")) {
                    c10 = 6;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                errorCode = f٦٥٩٥g;
                break;
            case 1:
                errorCode = f٦٥٩٠b;
                break;
            case 2:
                errorCode = f٦٥٩٣e;
                break;
            case 3:
                errorCode = f٦٥٩٢d;
                break;
            case 4:
                return f٦٥٨٩a;
            case 5:
                errorCode = f٦٥٩٤f;
                break;
            case 6:
                errorCode = f٦٥٩١c;
                break;
            default:
                msg = f٦٦٠١m.copy().msg(str + CertificateUtil.DELIMITER + str2);
                return msg.build();
        }
        msg = errorCode.copy().msg(str2);
        return msg.build();
    }

    public static ErrorBuilder a(String str, String str2) {
        return f٦٦١٣y.defineSdkError(str).msg(str2);
    }
}
