package com.alibaba.sdk.android.push.g;

import android.util.Log;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import kotlinx.coroutines.DebugKt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class i {
    public static String a(int i10, int i11, String str) {
        try {
            if (i11 == 200) {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("code");
                if (string.equals("OK")) {
                    return jSONObject.has("data") ? a(i10, jSONObject.getString("data")) : "";
                }
                throw new com.alibaba.sdk.android.push.b.f(com.alibaba.sdk.android.push.common.a.d.b(string, jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)));
            }
            throw new com.alibaba.sdk.android.push.b.f(com.alibaba.sdk.android.push.common.a.d.f٦٦٠٤p.copy().msg("请求失败" + i11).detail("requestType:" + i10).build());
        } catch (JSONException e10) {
            throw new com.alibaba.sdk.android.push.b.f(com.alibaba.sdk.android.push.common.a.d.f٦٥٩٧i.copy().msg(e10.getMessage()).detail("content: " + str).build());
        }
    }

    public static String a(int i10, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (i10 == com.alibaba.sdk.android.push.common.util.a.d.LIST_TAGS.a()) {
                return jSONObject.getString("tags");
            }
            if (i10 == com.alibaba.sdk.android.push.common.util.a.d.LIST_ALIASES.a()) {
                return jSONObject.getString("alias");
            }
            if (i10 == com.alibaba.sdk.android.push.common.util.a.d.CONFIG.a()) {
                return jSONObject.getString(DispatchConstants.DEVICEID);
            }
            if (i10 == com.alibaba.sdk.android.push.common.util.a.d.CHECK_PUSH_STATUS.a()) {
                return jSONObject.getBoolean(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) ? DebugKt.DEBUG_PROPERTY_VALUE_ON : DebugKt.DEBUG_PROPERTY_VALUE_OFF;
            }
            throw new com.alibaba.sdk.android.push.b.f(com.alibaba.sdk.android.push.common.a.d.f٦٥٩٧i.copy().detail("unknown request type " + i10).detail("data : " + str).build());
        } catch (JSONException e10) {
            throw new com.alibaba.sdk.android.push.b.f(com.alibaba.sdk.android.push.common.a.d.f٦٥٩٧i.copy().detail(e10.getMessage()).detail("data : " + str).build());
        }
    }

    public static String a(int i10, HttpURLConnection httpURLConnection) {
        try {
            if (httpURLConnection.getResponseCode() == 200) {
                JSONObject jSONObject = new JSONObject(a(httpURLConnection));
                String string = jSONObject.getString("code");
                if (string.equals("OK")) {
                    return jSONObject.has("data") ? a(i10, jSONObject.getString("data")) : "";
                }
                throw new com.alibaba.sdk.android.push.b.f(com.alibaba.sdk.android.push.common.a.d.b(string, jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)));
            }
            throw new com.alibaba.sdk.android.push.b.f(com.alibaba.sdk.android.push.common.a.d.f٦٦٠٤p.copy().msg("请求失败" + httpURLConnection.getResponseCode()).detail("requestType:" + i10).build());
        } catch (IOException e10) {
            throw new com.alibaba.sdk.android.push.b.f(com.alibaba.sdk.android.push.common.a.d.f٦٥٩٦h.copy().msg(e10.getMessage()).detail(Log.getStackTraceString(e10)).build());
        } catch (JSONException e11) {
            throw new com.alibaba.sdk.android.push.b.f(com.alibaba.sdk.android.push.common.a.d.f٦٥٩٧i.copy().msg(e11.getMessage()).detail("content: " + ((String) null)).build());
        }
    }

    private static String a(HttpURLConnection httpURLConnection) {
        int read;
        InputStream inputStream = httpURLConnection.getInputStream();
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        while (!Thread.interrupted() && (read = inputStream.read(bArr)) != -1) {
            byteArrayOutputStream.write(bArr, 0, read);
        }
        return byteArrayOutputStream.toString("utf-8");
    }
}
