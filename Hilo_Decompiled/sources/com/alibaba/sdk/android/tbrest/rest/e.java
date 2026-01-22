package com.alibaba.sdk.android.tbrest.rest;

import android.content.Context;
import android.os.Build;
import com.alibaba.sdk.android.tbrest.SendService;
import com.alibaba.sdk.android.tbrest.utils.DeviceUtils;
import com.alibaba.sdk.android.tbrest.utils.LogUtil;
import com.alibaba.sdk.android.tbrest.utils.StringUtils;
import com.davemorrissey.labs.subscaleview.BuildConfig;
import com.oudi.utils.date.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    private static long f٦٨٤٧c = System.currentTimeMillis();

    private static String a(String str) {
        if (StringUtils.isBlank(str)) {
            return "-";
        }
        if ("".equals(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (char c10 : str.toCharArray()) {
            if (c10 != '\n' && c10 != '\r' && c10 != '\t' && c10 != '|') {
                sb.append(c10);
            }
        }
        return sb.toString();
    }

    public static String a(SendService sendService, String str, long j10, String str2, int i10, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        String str3;
        String str4 = null;
        if (i10 == 0) {
            return null;
        }
        try {
            String utdid = DeviceUtils.getUtdid(sendService.context);
            if (utdid == null) {
                LogUtil.e("get utdid failure, so build report failure, now return");
                return null;
            }
            String[] networkType = DeviceUtils.getNetworkType(sendService.context);
            String str5 = networkType[0];
            if (networkType.length > 1 && str5 != null && !DeviceUtils.NETWORK_CLASS_WIFI.equals(str5)) {
                str4 = networkType[1];
            }
            String str6 = "" + (j10 > 0 ? j10 : System.currentTimeMillis());
            String a10 = a(str2);
            String a11 = a(String.valueOf(i10));
            String a12 = a(StringUtils.convertObjectToString(obj));
            String a13 = a(StringUtils.convertObjectToString(obj2));
            String a14 = a(StringUtils.convertObjectToString(obj3));
            String a15 = a(StringUtils.convertMapToString(map));
            String a16 = a(DeviceUtils.getImei(sendService.context));
            String a17 = a(DeviceUtils.getImsi(sendService.context));
            String a18 = a(Build.BRAND);
            a(DeviceUtils.getCpuName());
            a(a16);
            String a19 = a(Build.MODEL);
            String a20 = a(DeviceUtils.getResolution(sendService.context));
            String a21 = a(DeviceUtils.getCarrier(sendService.context));
            String a22 = a(str5);
            String a23 = a(str4);
            String a24 = a(str);
            String a25 = a(sendService.appVersion);
            String a26 = a(sendService.channel);
            String a27 = a(sendService.userNick);
            String a28 = a(sendService.userNick);
            a(DeviceUtils.getCountry());
            String a29 = a(DeviceUtils.getLanguage());
            String str7 = sendService.appId;
            String str8 = "a";
            String a30 = a(Build.VERSION.RELEASE);
            String a31 = a(utdid);
            String a32 = a(sendService.country);
            StringUtils.isBlank("");
            if (str7 != null) {
                str3 = a32;
                if (str7.contains("aliyunos")) {
                    str8 = "y";
                }
            } else {
                str3 = a32;
            }
            String str9 = str8;
            HashMap hashMap = new HashMap();
            hashMap.put(a.IMEI.toString(), a16);
            hashMap.put(a.IMSI.toString(), a17);
            hashMap.put(a.BRAND.toString(), a18);
            hashMap.put(a.DEVICE_MODEL.toString(), a19);
            hashMap.put(a.RESOLUTION.toString(), a20);
            hashMap.put(a.CARRIER.toString(), a21);
            hashMap.put(a.ACCESS.toString(), a22);
            hashMap.put(a.ACCESS_SUBTYPE.toString(), a23);
            hashMap.put(a.CHANNEL.toString(), a26);
            hashMap.put(a.APPKEY.toString(), a24);
            hashMap.put(a.APPVERSION.toString(), a25);
            hashMap.put(a.LL_USERNICK.toString(), a27);
            hashMap.put(a.USERNICK.toString(), a28);
            hashMap.put(a.LL_USERID.toString(), "-");
            hashMap.put(a.USERID.toString(), "-");
            hashMap.put(a.LANGUAGE.toString(), a29);
            hashMap.put(a.OS.toString(), str9);
            hashMap.put(a.OSVERSION.toString(), a30);
            hashMap.put(a.SDKVERSION.toString(), BuildConfig.VERSION_NAME);
            hashMap.put(a.START_SESSION_TIMESTAMP.toString(), "" + f٦٨٤٧c);
            hashMap.put(a.UTDID.toString(), a31);
            hashMap.put(a.SDKTYPE.toString(), "mini");
            hashMap.put(a.RESERVE2.toString(), a31);
            hashMap.put(a.RESERVE3.toString(), "-");
            hashMap.put(a.RESERVE4.toString(), "-");
            hashMap.put(a.RESERVE5.toString(), "-");
            hashMap.put(a.RESERVES.toString(), str3);
            hashMap.put(a.RECORD_TIMESTAMP.toString(), str6);
            hashMap.put(a.PAGE.toString(), a10);
            hashMap.put(a.EVENTID.toString(), a11);
            hashMap.put(a.ARG1.toString(), a12);
            hashMap.put(a.ARG2.toString(), a13);
            hashMap.put(a.ARG3.toString(), a14);
            hashMap.put(a.ARGS.toString(), a15);
            return a(hashMap);
        } catch (Exception e10) {
            LogUtil.e("UTRestAPI buildTracePostReqDataObj catch!", e10);
            return "";
        }
    }

    public static String a(Map<String, String> map) {
        boolean z10;
        a aVar;
        StringBuffer stringBuffer = new StringBuffer();
        a[] values = a.values();
        int length = values.length;
        int i10 = 0;
        while (true) {
            String str = null;
            if (i10 >= length || (aVar = values[i10]) == a.ARGS) {
                break;
            }
            if (map.containsKey(aVar.toString())) {
                str = StringUtils.convertObjectToString(map.get(aVar.toString()));
                map.remove(aVar.toString());
            }
            stringBuffer.append(a(str));
            stringBuffer.append("||");
            i10++;
        }
        a aVar2 = a.ARGS;
        if (map.containsKey(aVar2.toString())) {
            stringBuffer.append(a(StringUtils.convertObjectToString(map.get(aVar2.toString()))));
            map.remove(aVar2.toString());
            z10 = false;
        } else {
            z10 = true;
        }
        for (String str2 : map.keySet()) {
            String convertObjectToString = map.containsKey(str2) ? StringUtils.convertObjectToString(map.get(str2)) : null;
            if (z10) {
                if ("StackTrace".equals(str2)) {
                    stringBuffer.append("StackTrace=====>");
                    stringBuffer.append(convertObjectToString);
                } else {
                    stringBuffer.append(a(str2));
                    stringBuffer.append("=");
                    stringBuffer.append(convertObjectToString);
                }
                z10 = false;
            } else if ("StackTrace".equals(str2)) {
                stringBuffer.append(",");
                stringBuffer.append("StackTrace=====>");
                stringBuffer.append(convertObjectToString);
            } else {
                stringBuffer.append(",");
                stringBuffer.append(a(str2));
                stringBuffer.append("=");
                stringBuffer.append(convertObjectToString);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        if (StringUtils.isEmpty(stringBuffer2) || !stringBuffer2.endsWith("||")) {
            return stringBuffer2;
        }
        return stringBuffer2 + "-";
    }

    public static d a(SendService sendService, String str, String str2, Context context, long j10, String str3, int i10, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        String str4 = "aliyunos";
        if (i10 == 0) {
            return null;
        }
        try {
            String utdid = DeviceUtils.getUtdid(sendService.context);
            if (utdid == null) {
                LogUtil.e("get utdid failure, so build report failure, now return");
                return null;
            }
            String[] networkType = DeviceUtils.getNetworkType(sendService.context);
            String str5 = networkType[0];
            String str6 = (networkType.length <= 1 || str5 == null || DeviceUtils.NETWORK_CLASS_WIFI.equals(str5)) ? null : networkType[1];
            long currentTimeMillis = j10 > 0 ? j10 : System.currentTimeMillis();
            String str7 = "" + currentTimeMillis;
            String format = new SimpleDateFormat(DateFormat.YMD_HMS).format(Long.valueOf(currentTimeMillis));
            String a10 = a(str3);
            String a11 = a(String.valueOf(i10));
            String a12 = a(StringUtils.convertObjectToString(obj));
            String a13 = a(StringUtils.convertObjectToString(obj2));
            String a14 = a(StringUtils.convertObjectToString(obj3));
            String a15 = a(StringUtils.convertMapToString(map));
            String a16 = a(DeviceUtils.getImei(sendService.context));
            String a17 = a(DeviceUtils.getImsi(sendService.context));
            String a18 = a(Build.BRAND);
            String a19 = a(DeviceUtils.getCpuName());
            String a20 = a(a16);
            String a21 = a(Build.MODEL);
            String a22 = a(DeviceUtils.getResolution(sendService.context));
            String a23 = a(DeviceUtils.getCarrier(sendService.context));
            String a24 = a(str5);
            String a25 = a(str6);
            String a26 = a(str);
            String a27 = a(sendService.appVersion);
            String a28 = a(sendService.channel);
            String a29 = a(sendService.userNick);
            String a30 = a(sendService.userNick);
            String a31 = a(DeviceUtils.getCountry());
            String a32 = a(DeviceUtils.getLanguage());
            String str8 = sendService.appId;
            if (str8 == null || !str8.contains("aliyunos")) {
                str4 = "Android";
            }
            String a33 = a(Build.VERSION.RELEASE);
            String str9 = "" + f٦٨٤٧c;
            String a34 = a(utdid);
            StringUtils.isBlank("");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("5.0.1");
            stringBuffer.append("||");
            stringBuffer.append(a16);
            stringBuffer.append("||");
            stringBuffer.append(a17);
            stringBuffer.append("||");
            stringBuffer.append(a18);
            stringBuffer.append("||");
            stringBuffer.append(a19);
            stringBuffer.append("||");
            stringBuffer.append(a20);
            stringBuffer.append("||");
            stringBuffer.append(a21);
            stringBuffer.append("||");
            stringBuffer.append(a22);
            stringBuffer.append("||");
            stringBuffer.append(a23);
            stringBuffer.append("||");
            stringBuffer.append(a24);
            stringBuffer.append("||");
            stringBuffer.append(a25);
            stringBuffer.append("||");
            stringBuffer.append(a28);
            stringBuffer.append("||");
            stringBuffer.append(a26);
            stringBuffer.append("||");
            stringBuffer.append(a27);
            stringBuffer.append("||");
            stringBuffer.append(a29);
            stringBuffer.append("||");
            stringBuffer.append(a30);
            stringBuffer.append("||");
            stringBuffer.append("-");
            stringBuffer.append("||");
            stringBuffer.append(a31);
            stringBuffer.append("||");
            stringBuffer.append(a32);
            stringBuffer.append("||");
            stringBuffer.append(str4);
            stringBuffer.append("||");
            stringBuffer.append(a33);
            stringBuffer.append("||");
            stringBuffer.append("mini");
            stringBuffer.append("||");
            stringBuffer.append(BuildConfig.VERSION_NAME);
            stringBuffer.append("||");
            stringBuffer.append(str9);
            stringBuffer.append("||");
            stringBuffer.append(a34);
            stringBuffer.append("||");
            stringBuffer.append("-");
            stringBuffer.append("||");
            stringBuffer.append("-");
            stringBuffer.append("||");
            stringBuffer.append("-");
            stringBuffer.append("||");
            stringBuffer.append("-");
            stringBuffer.append("||");
            stringBuffer.append(format);
            stringBuffer.append("||");
            stringBuffer.append(str7);
            stringBuffer.append("||");
            stringBuffer.append(a10);
            stringBuffer.append("||");
            stringBuffer.append(a11);
            stringBuffer.append("||");
            stringBuffer.append(a12);
            stringBuffer.append("||");
            stringBuffer.append(a13);
            stringBuffer.append("||");
            stringBuffer.append(a14);
            stringBuffer.append("||");
            stringBuffer.append(a15);
            String stringBuffer2 = stringBuffer.toString();
            HashMap hashMap = new HashMap();
            hashMap.put("stm_x", stringBuffer2.getBytes());
            d dVar = new d();
            dVar.b(RestUrlWrapper.getSignedTransferUrl(str2, null, hashMap, context, a26, a28, a27, str4, "", a34));
            dVar.a(hashMap);
            return dVar;
        } catch (Exception e10) {
            LogUtil.e("UTRestAPI buildTracePostReqDataObj catch!", e10);
            return null;
        }
    }
}
