package com.taobao.agoo;

import com.alibaba.sdk.android.error.ErrorBuilder;
import com.alibaba.sdk.android.error.ErrorCode;
import com.alibaba.sdk.android.error.ErrorDefine;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a {
    public static final ErrorCode ACCS_CHECK_ERROR;
    public static final ErrorCode AGOO_NOT_BIND;
    public static final ErrorCode INVALID_ARG;
    public static final ErrorCode REGISTER_DATA_ERROR;
    public static final ErrorCode REMOVE_ALIAS_FAIL_NO_ALIAS;
    public static final ErrorCode REMOVE_ALIAS_FAIL_NO_TOKEN;
    public static final ErrorCode SUCCESS;
    private static final ErrorDefine a;
    public static final ErrorCode[] codes;

    static {
        ErrorDefine errorDefine = new ErrorDefine("EAGOO");
        a = errorDefine;
        ErrorCode build = errorDefine.defineSdkError(com.taobao.agoo.a.a.b.JSON_SUCCESS).msg(com.taobao.agoo.a.a.b.JSON_SUCCESS).build();
        SUCCESS = build;
        ErrorCode build2 = errorDefine.defineSdkError("remove_alias_fail_no_token").msg("移除别名失败，本地没有别名记录").solution("请检查输入的别名是否正确").solution("低版本推送有概率出现，添加别名后，应用的数据被清除，导致sdk内部存储的别名信息丢失，无法移除").build();
        REMOVE_ALIAS_FAIL_NO_TOKEN = build2;
        ErrorCode build3 = errorDefine.defineSdkError("remove_alias_fail_no_alias").msg("移除别名失败，本地没有别名记录").solution("请检查输入的别名是否正确").solution("低版本推送有概率出现，添加别名后，应用的数据被清除，导致sdk内部存储的别名信息丢失，无法移除").build();
        REMOVE_ALIAS_FAIL_NO_ALIAS = build3;
        ErrorCode build4 = errorDefine.defineSdkError("invalid_arg").msg("请求参数错误").solution("请检查输入参数").build();
        INVALID_ARG = build4;
        ErrorCode build5 = errorDefine.defineSdkError("accs_disabled").msg("accs检查不通过").solution("请检查初始化是否成功").solution("请检查配置是否正确").solution("请检查请求是否是在主进程").build();
        ACCS_CHECK_ERROR = build5;
        ErrorCode build6 = errorDefine.defineSdkError("agoo_not_bind").msg("请先注册初始化agoo").solution("请检查初始化是否成功").build();
        AGOO_NOT_BIND = build6;
        REGISTER_DATA_ERROR = errorDefine.defineSdkError("register_data_error").msg("构造注册数据失败").solution("请检查配置参数是否正确，初始化是否成功").build();
        codes = new ErrorCode[]{build, build2, build3, build4, build5, build6, a(123, "accs 错误信息").solution("格式EAGOO_ACCS_123, 123为accs错误码，请结合accs错误码排查").build(), a("XXX", "服务错误信息").solution("格式EAGOO_SERVER_XXX, XXX为agoo服务错误码，请联系阿里云技术支持排查").build()};
    }

    public static ErrorBuilder a(int i, String str) {
        return a.defineError("ACCS", String.valueOf(i)).msg(str).solution("accs底层错误，需要根据错误码排查");
    }

    public static ErrorBuilder a(String str, String str2) {
        return a.defineServerError(str).msg(str2).solution("agoo 服务报错，请联系技术支持排查");
    }
}
