package com.alibaba.sdk.android.tbrest.rest;

import android.content.Context;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.sdk.android.tbrest.utils.LogUtil;
import com.alibaba.sdk.android.tbrest.utils.MD5Utils;
import com.alibaba.sdk.android.tbrest.utils.StringUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class RestUrlWrapper {
    public static final String FIELD_APPKEY = "appkey";
    public static final String FIELD_APPVERSION = "app_version";
    public static final String FIELD_CHANNEL = "channel";
    public static final String FIELD_PLATFORM = "platform";
    public static final String FIELD_SDK_VERSION = "sdk_version";
    public static final String FIELD_T = "t";
    public static final String FIELD_UTDID = "utdid";
    public static final String FIELD_V = "v";
    static boolean enableSecuritySDK;
    static Context mContext;

    public static void enableSecuritySDK() {
        enableSecuritySDK = true;
    }

    private static String getEncoded(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            return str;
        }
    }

    public static String getSignedTransferUrl(String str, Map<String, Object> map, Map<String, Object> map2, Context context, String str2, String str3, String str4, String str5, String str6, String str7) throws Exception {
        String str8 = "";
        if (map2 != null && map2.size() > 0) {
            Set<String> keySet = map2.keySet();
            String[] strArr = new String[keySet.size()];
            keySet.toArray(strArr);
            for (String str9 : c.a().a(strArr, true)) {
                str8 = str8 + str9 + MD5Utils.getMd5Hex((byte[]) map2.get(str9));
            }
        }
        try {
            return wrapUrl(str, null, null, str8, context, str2, str3, str4, str5, str6, str7);
        } catch (Exception unused) {
            return wrapUrl(RestConstants.getTransferUrl(), null, null, str8, context, str2, str3, str4, str5, str6, str7);
        }
    }

    public static void setContext(Context context) {
        mContext = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String wrapUrl(String str, String str2, String str3, String str4, Context context, String str5, String str6, String str7, String str8, String str9, String str10) throws Exception {
        String str11;
        String str12;
        String str13;
        String valueOf = String.valueOf(System.currentTimeMillis());
        if (!enableSecuritySDK || mContext == null) {
            str11 = "";
            str12 = str11;
        } else {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str5);
                sb.append(str6);
                sb.append(str7);
                sb.append(str8);
                sb.append(RestConstants.G_SDK_VERSION);
                sb.append(str10);
                sb.append(valueOf);
                sb.append("3.0");
                sb.append("");
                if (str3 == null) {
                    str3 = "";
                }
                sb.append(str3);
                if (str4 == null) {
                    str4 = "";
                }
                sb.append(str4);
                str11 = new g(mContext, str5).b(MD5Utils.getMd5Hex(sb.toString().getBytes()));
            } catch (Exception e10) {
                e = e10;
                str11 = "";
            }
            try {
                if (StringUtils.isNotBlank(RestConstants.G_SDK_VERSION)) {
                    str12 = "1";
                }
            } catch (Exception e11) {
                e = e11;
                LogUtil.w("security sdk signed", e);
                str12 = "";
                if (StringUtils.isEmpty(str2)) {
                }
                return String.format("%s?%sak=%s&av=%s&c=%s&v=%s&s=%s&d=%s&sv=%s&p=%s&t=%s&u=%s&is=%s", str, str13, getEncoded(str5), getEncoded(str7), getEncoded(str6), getEncoded("3.0"), getEncoded(str11), getEncoded(str10), RestConstants.G_SDK_VERSION, str8, valueOf, "", str12);
            }
            str12 = "";
        }
        if (StringUtils.isEmpty(str2)) {
            str13 = str2 + DispatchConstants.SIGN_SPLIT_SYMBOL;
        } else {
            str13 = "";
        }
        return String.format("%s?%sak=%s&av=%s&c=%s&v=%s&s=%s&d=%s&sv=%s&p=%s&t=%s&u=%s&is=%s", str, str13, getEncoded(str5), getEncoded(str7), getEncoded(str6), getEncoded("3.0"), getEncoded(str11), getEncoded(str10), RestConstants.G_SDK_VERSION, str8, valueOf, "", str12);
    }
}
