package com.alibaba.sdk.android.push.common.util.a;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import anet.channel.request.Request;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class c extends AsyncTask<Map<String, String>, Void, b> {

    /* renamed from: a, reason: collision with root package name */
    static AmsLogger f٦٦٢٠a = AmsLogger.getLogger("MPS:SendRequestTask");

    /* renamed from: c, reason: collision with root package name */
    private Context f٦٦٢٢c;

    /* renamed from: d, reason: collision with root package name */
    private String f٦٦٢٣d;

    /* renamed from: b, reason: collision with root package name */
    public String f٦٦٢١b = Request.Method.POST;

    /* renamed from: e, reason: collision with root package name */
    private int f٦٦٢٤e = 0;

    public c(Context context, String str) {
        this.f٦٦٢٢c = context;
        this.f٦٦٢٣d = str;
    }

    public int a() {
        return this.f٦٦٢٤e;
    }

    protected abstract Map<String, String> a(Context context, Map<String, String> map);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b doInBackground(Map<String, String>... mapArr) {
        b bVar;
        Map<String, String> map = mapArr[0];
        if (map.containsKey("VipRequestType")) {
            this.f٦٦٢٤e = Integer.parseInt(map.get("VipRequestType"));
            bVar = new b(Integer.parseInt(map.get("VipRequestType")));
        } else {
            bVar = new b();
        }
        try {
            String a10 = a(this.f٦٦٢٢c, this.f٦٦٢٣d, map);
            bVar.f٦٦١٧b = 200;
            bVar.f٦٦١٦a = a10;
        } catch (a e10) {
            bVar.f٦٦١٨c = e10.a();
            bVar.f٦٦١٧b = -1;
            bVar.f٦٦١٦a = e10.getMessage();
        }
        return bVar;
    }

    public String a(Context context, String str, Map<String, String> map) {
        int read;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                try {
                    Map<String, String> a10 = a(context, map);
                    a(str, a10);
                    HttpURLConnection a11 = com.alibaba.sdk.android.ams.common.util.a.a(str, a10, this.f٦٦٢١b);
                    if (a11 == null) {
                        f٦٦٢٠a.e("failed to access VIP service.");
                        throw new a(com.alibaba.sdk.android.push.common.a.d.f٦٦٠٤p.copy().msg("创建请求连接失败").build());
                    }
                    if (a11.getResponseCode() != 200) {
                        throw new a(com.alibaba.sdk.android.push.common.a.d.f٦٦٠٤p.copy().msg("请求失败：" + a11.getResponseCode()).build());
                    }
                    InputStream inputStream = a11.getInputStream();
                    byte[] bArr = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    while (!Thread.interrupted() && (read = inputStream.read(bArr)) != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString("utf-8");
                    a11.disconnect();
                    return byteArrayOutputStream2;
                } catch (a e10) {
                    throw e10;
                }
            } catch (Throwable th) {
                f٦٦٢٠a.e("VIP API failed! error: ", th);
                throw new a(com.alibaba.sdk.android.push.common.a.d.f٦٦٠٤p.copy().msg(th.getMessage()).detail(Log.getStackTraceString(th)).build());
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(b bVar) {
        f٦٦٢٠a.i("HTTP Return code: " + bVar.f٦٦١٧b);
    }

    private void a(String str, Map<String, String> map) {
        try {
            f٦٦٢٠a.d("request url :" + str);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                f٦٦٢٠a.d("key: " + entry.getKey() + " value: " + entry.getValue());
            }
        } catch (Throwable unused) {
        }
    }
}
