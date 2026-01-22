package com.alibaba.sdk.android.tbrest.request;

import android.content.Context;
import android.content.pm.PackageManager;
import com.alibaba.sdk.android.tbrest.SendService;
import com.alibaba.sdk.android.tbrest.rest.RestConstants;
import com.alibaba.sdk.android.tbrest.utils.ByteUtils;
import com.alibaba.sdk.android.tbrest.utils.GzipUtils;
import com.alibaba.sdk.android.tbrest.utils.LogUtil;
import com.facebook.internal.AnalyticsEvents;
import com.ut.device.UTDevice;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class BizRequest {
    private static final byte FLAGS_GET_CONFIG = 32;
    private static final byte FLAGS_GZIP = 1;
    private static final byte FLAGS_GZIP_FLUSH_DIC = 2;
    private static final byte FLAGS_KEEP_ALIVE = 8;
    private static final byte FLAGS_NO_GZIP = 0;
    private static final byte FLAGS_REAL_TIME_DEBUG = 16;
    private static final int HEAD_LENGTH = 8;
    private static final int PAYLOAD_MAX_LENGTH = 16777216;
    private static long mReceivedDataLen;
    static String mResponseAdditionalData;
    static boolean needConfigByResponse;

    public static String getHead(SendService sendService, String str, Context context) {
        String str2;
        String str3 = sendService.appVersion;
        String str4 = "";
        if (str3 == null) {
            str3 = "";
        }
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        String str5 = sendService.channel;
        if (str5 != null) {
            str4 = str5;
        }
        String format = String.format("ak=%s&av=%s&avsys=%s&c=%s&d=%s&sv=%s", str, str3, str2, str4, UTDevice.getUtdid(context), RestConstants.UT_SDK_VRESION);
        LogUtil.i("send url :" + format);
        return format;
    }

    public static byte[] getPackRequest(Context context, SendService sendService, Map<String, String> map) throws Exception {
        return getPackRequest(sendService, sendService.appKey, context, map, 1);
    }

    static byte[] getPackRequestByRealtime(Context context, SendService sendService, Map<String, String> map) throws Exception {
        return getPackRequest(sendService, sendService.appKey, context, map, 2);
    }

    private static byte[] getPayload(SendService sendService, String str, Context context, Map<String, String> map) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String head = getHead(sendService, str, context);
        if (head != null && head.length() > 0) {
            byteArrayOutputStream.write(ByteUtils.intToBytes2(head.getBytes().length));
            byteArrayOutputStream.write(head.getBytes());
        } else {
            byteArrayOutputStream.write(ByteUtils.intToBytes2(0));
        }
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                byteArrayOutputStream.write(ByteUtils.intToBytes4(Integer.valueOf(str2).intValue()));
                String str3 = map.get(str2);
                if (str3 != null) {
                    byteArrayOutputStream.write(ByteUtils.intToBytes4(str3.getBytes().length));
                    byteArrayOutputStream.write(str3.getBytes());
                } else {
                    byteArrayOutputStream.write(ByteUtils.intToBytes4(0));
                }
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e10) {
            LogUtil.e(e10.toString());
        }
        return byteArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int parseResult(byte[] bArr) {
        int i10;
        int i11 = -1;
        if (bArr != null && bArr.length >= 12) {
            mReceivedDataLen = bArr.length;
            boolean z10 = true;
            if (ByteUtils.bytesToInt(bArr, 1, 3) + 8 != bArr.length) {
                LogUtil.e("recv len error");
            } else {
                if (1 != (bArr[5] & FLAGS_GZIP)) {
                    z10 = false;
                }
                i11 = ByteUtils.bytesToInt(bArr, 8, 4);
                if (bArr.length - 12 >= 0) {
                    i10 = bArr.length - 12;
                } else {
                    i10 = 0;
                }
                if (i10 > 0) {
                    if (z10) {
                        byte[] bArr2 = new byte[i10];
                        System.arraycopy(bArr, 12, bArr2, 0, i10);
                        byte[] unGzip = GzipUtils.unGzip(bArr2);
                        mResponseAdditionalData = new String(unGzip, 0, unGzip.length);
                    } else {
                        mResponseAdditionalData = new String(bArr, 12, i10);
                    }
                } else {
                    mResponseAdditionalData = null;
                }
            }
        } else {
            LogUtil.e("recv errCode UNKNOWN_ERROR");
        }
        LogUtil.d("errCode:" + i11);
        return i11;
    }

    public static byte[] getPackRequest(SendService sendService, String str, Context context, Map<String, String> map) throws Exception {
        return getPackRequest(sendService, str, context, map, 1);
    }

    static byte[] getPackRequestByRealtime(SendService sendService, String str, Context context, Map<String, String> map) throws Exception {
        return getPackRequest(sendService, str, context, map, 2);
    }

    static byte[] getPackRequest(SendService sendService, String str, Context context, Map<String, String> map, int i10) throws Exception {
        byte[] gzip = GzipUtils.gzip(getPayload(sendService, str, context, map));
        if (gzip == null || gzip.length >= PAYLOAD_MAX_LENGTH) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(1);
        byteArrayOutputStream.write(ByteUtils.intToBytes3(gzip.length));
        byteArrayOutputStream.write(i10);
        byte b10 = (byte) 9;
        if (needConfigByResponse) {
            b10 = (byte) (b10 | FLAGS_GET_CONFIG);
        }
        byteArrayOutputStream.write(b10);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(gzip);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e10) {
            LogUtil.e(e10.toString());
        }
        return byteArray;
    }
}
