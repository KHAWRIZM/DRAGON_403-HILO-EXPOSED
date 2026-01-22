package com.alibaba.sdk.android.tbrest.rest;

import android.content.Context;
import com.alibaba.sdk.android.tbrest.SendService;
import com.alibaba.sdk.android.tbrest.request.BizRequest;
import com.alibaba.sdk.android.tbrest.request.UrlWrapper;
import com.alibaba.sdk.android.tbrest.utils.LogUtil;
import com.alibaba.sdk.android.tbrest.utils.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f {
    public static boolean a(SendService sendService, String str, Context context, String str2, long j10, String str3, int i10, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        byte[] bArr;
        try {
            LogUtil.i("RestAPI start send log!");
            String a10 = e.a(sendService, str, j10, str3, i10, obj, obj2, obj3, map);
            if (StringUtils.isNotBlank(a10)) {
                LogUtil.i("RestAPI build data succ!");
                HashMap hashMap = new HashMap(1);
                hashMap.put(String.valueOf(i10), a10);
                try {
                    bArr = BizRequest.getPackRequest(sendService, str, context, hashMap);
                } catch (Exception e10) {
                    LogUtil.e(e10.toString());
                    bArr = null;
                }
                if (bArr == null) {
                    return false;
                }
                LogUtil.i("packRequest success!");
                return UrlWrapper.sendRequest(sendService, str2, bArr).isSuccess();
            }
            LogUtil.i("UTRestAPI build data failure!");
            return false;
        } catch (Throwable th) {
            LogUtil.e("system error!", th);
            return false;
        }
    }

    public static boolean b(SendService sendService, String str, Context context, String str2, long j10, String str3, int i10, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        byte[] bArr;
        try {
            LogUtil.i("RestAPI start send log by url!");
            String a10 = e.a(sendService, str, j10, str3, i10, obj, obj2, obj3, map);
            if (StringUtils.isNotBlank(a10)) {
                LogUtil.i("RestAPI build data succ by url!");
                HashMap hashMap = new HashMap(1);
                hashMap.put(String.valueOf(i10), a10);
                try {
                    bArr = BizRequest.getPackRequest(sendService, str, context, hashMap);
                } catch (Exception e10) {
                    LogUtil.e(e10.toString());
                    bArr = null;
                }
                if (bArr == null) {
                    return false;
                }
                LogUtil.i("packRequest success by url!");
                return UrlWrapper.sendRequest(sendService, str, str2, bArr).isSuccess();
            }
            LogUtil.i("UTRestAPI build data failure by url!");
            return false;
        } catch (Throwable th) {
            LogUtil.e("system error by url!", th);
            return false;
        }
    }

    @Deprecated
    public static String a(SendService sendService, String str, String str2, Context context, long j10, String str3, int i10, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        try {
            LogUtil.i("sendLogByUrl RestAPI start send log!");
            d a10 = e.a(sendService, str2, str, context, j10, str3, i10, obj, obj2, obj3, map);
            if (a10 != null) {
                LogUtil.i("sendLogByUrl RestAPI build data succ!");
                Map<String, Object> map2 = a10.m٢٦٠a();
                if (map2 == null) {
                    LogUtil.i("sendLogByUrl postReqData is null!");
                    return null;
                }
                String a11 = a10.a();
                if (StringUtils.isEmpty(a11)) {
                    LogUtil.i("sendLogByUrl reqUrl is null!");
                    return null;
                }
                byte[] a12 = b.a(2, a11, map2, true);
                if (a12 != null) {
                    try {
                        String str4 = new String(a12, "UTF-8");
                        if (!StringUtils.isEmpty(str4)) {
                            return str4;
                        }
                    } catch (UnsupportedEncodingException e10) {
                        LogUtil.e("sendLogByUrl result encoding UTF-8 error!", e10);
                    }
                }
            } else {
                LogUtil.i("sendLogByUrl UTRestAPI build data failure!");
            }
        } catch (Throwable th) {
            LogUtil.e("sendLogByUrl system error!", th);
        }
        return null;
    }
}
