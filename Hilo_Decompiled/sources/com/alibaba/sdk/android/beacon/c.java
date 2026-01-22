package com.alibaba.sdk.android.beacon;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.request.Request;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.sdk.android.beacon.Beacon;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.ta.utdid2.device.UTDevice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f٦٣٤٢a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f٦٣٤٣b;

    /* renamed from: a, reason: collision with other field name */
    private final Beacon f٣a;

    /* renamed from: c, reason: collision with root package name */
    private final List<Beacon.Config> f٦٣٤٤c = new ArrayList();

    /* renamed from: a, reason: collision with other field name */
    private final a f٤a = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public final class a {
        private a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:48:0x00be A[Catch: IOException -> 0x00c1, TRY_LEAVE, TryCatch #7 {IOException -> 0x00c1, blocks: (B:53:0x00b9, B:48:0x00be), top: B:52:0x00b9 }] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        String a(String str, byte[] bArr) {
            BufferedReader bufferedReader;
            OutputStream outputStream;
            int responseCode;
            boolean a10;
            OutputStream outputStream2 = null;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setRequestMethod(Request.Method.POST);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                if (com.alibaba.sdk.android.beacon.a.f٦٣٤٠a) {
                    httpURLConnection.setRequestProperty("Host", "beacon-api.aliyuncs.com");
                }
                outputStream = httpURLConnection.getOutputStream();
                try {
                    outputStream.write(bArr);
                    outputStream.flush();
                    responseCode = httpURLConnection.getResponseCode();
                    a10 = a(responseCode);
                    bufferedReader = new BufferedReader(new InputStreamReader(a10 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream(), "UTF-8"));
                } catch (Exception e10) {
                    e = e10;
                    bufferedReader = null;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = null;
                }
            } catch (Exception e11) {
                e = e11;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                if (!a10) {
                    c.this.b(String.valueOf(responseCode), sb.toString());
                }
                String sb2 = sb.toString();
                try {
                    outputStream.close();
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return sb2;
            } catch (Exception e12) {
                e = e12;
                outputStream2 = outputStream;
                try {
                    com.alibaba.sdk.android.beacon.b.a("beacon", e.getMessage(), e);
                    c.this.b("-100", e.getMessage());
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException unused2) {
                            return "";
                        }
                    }
                    if (bufferedReader == null) {
                        return "";
                    }
                    bufferedReader.close();
                    return "";
                } catch (Throwable th3) {
                    th = th3;
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException unused3) {
                            throw th;
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                outputStream2 = outputStream;
                if (outputStream2 != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        }

        boolean a(int i10) {
            return i10 >= 200 && i10 < 300;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final Map<String, String> f٦٣٤٦a;

        /* renamed from: c, reason: collision with root package name */
        final String f٦٣٤٧c;

        /* renamed from: d, reason: collision with root package name */
        final String f٦٣٤٨d;

        /* renamed from: e, reason: collision with root package name */
        final String f٦٣٤٩e;

        /* renamed from: f, reason: collision with root package name */
        final String f٦٣٥٠f;

        /* renamed from: g, reason: collision with root package name */
        final String f٦٣٥١g;

        /* renamed from: h, reason: collision with root package name */
        final String f٦٣٥٢h;

        /* renamed from: i, reason: collision with root package name */
        final String f٦٣٥٣i;
        final String mAppKey;
        final Map<String, String> mExtras;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public static final class a {

            /* renamed from: b, reason: collision with root package name */
            Map<String, String> f٦٣٥٤b = new HashMap();

            /* renamed from: j, reason: collision with root package name */
            String f٦٣٥٥j;

            /* renamed from: k, reason: collision with root package name */
            String f٦٣٥٦k;

            /* renamed from: l, reason: collision with root package name */
            String f٦٣٥٧l;

            /* renamed from: m, reason: collision with root package name */
            String f٦٣٥٨m;

            /* renamed from: n, reason: collision with root package name */
            String f٦٣٥٩n;

            /* renamed from: o, reason: collision with root package name */
            String f٦٣٦٠o;

            /* renamed from: p, reason: collision with root package name */
            String f٦٣٦١p;

            a() {
            }

            a a(String str) {
                this.f٦٣٥٥j = str;
                return this;
            }

            a b(String str) {
                this.f٦٣٥٦k = str;
                return this;
            }

            a c(String str) {
                this.f٦٣٥٧l = str;
                return this;
            }

            a d(String str) {
                this.f٦٣٥٨m = str;
                return this;
            }

            a e(String str) {
                this.f٦٣٥٩n = str;
                return this;
            }

            a f(String str) {
                this.f٦٣٦٠o = str;
                return this;
            }

            a g(String str) {
                this.f٦٣٦١p = str;
                return this;
            }

            a a(Map<String, String> map) {
                this.f٦٣٥٤b.putAll(map);
                return this;
            }

            public b a() {
                return new b(this);
            }
        }

        private b(a aVar) {
            this.f٦٣٤٦a = new TreeMap();
            this.mAppKey = aVar.f٦٣٥٥j;
            this.f٦٣٤٧c = aVar.f٦٣٥٦k;
            this.f٦٣٤٨d = aVar.f٦٣٥٧l;
            this.f٦٣٤٩e = aVar.f٦٣٥٨m;
            this.f٦٣٥٠f = aVar.f٦٣٥٩n;
            this.f٦٣٥١g = aVar.f٦٣٦٠o;
            this.f٦٣٥٢h = aVar.f٦٣٦١p;
            this.mExtras = aVar.f٦٣٥٤b;
            this.f٦٣٥٣i = a();
        }

        private String a() {
            this.f٦٣٤٦a.put("appKey", this.mAppKey);
            this.f٦٣٤٦a.put("appVer", this.f٦٣٤٨d);
            this.f٦٣٤٦a.put("osType", this.f٦٣٤٩e);
            this.f٦٣٤٦a.put("osVer", this.f٦٣٥٠f);
            this.f٦٣٤٦a.put(DispatchConstants.DEVICEID, this.f٦٣٥١g);
            this.f٦٣٤٦a.put("beaconVer", this.f٦٣٥٢h);
            for (String str : this.mExtras.keySet()) {
                this.f٦٣٤٦a.put(str, this.mExtras.get(str));
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : this.f٦٣٤٦a.keySet()) {
                sb.append(str2);
                sb.append(this.f٦٣٤٦a.get(str2));
            }
            String a10 = d.a(this.f٦٣٤٧c, sb.toString());
            this.f٦٣٤٦a.put(DispatchConstants.SIGN, a10);
            return a10;
        }
    }

    static {
        String str = com.alibaba.sdk.android.beacon.a.f٦٣٤٠a ? "100.67.64.54" : "beacon-api.aliyuncs.com";
        f٦٣٤٢a = str;
        f٦٣٤٣b = "https://" + str + "/beacon/fetch/config";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Beacon beacon) {
        this.f٣a = beacon;
    }

    private b a(Context context, String str, String str2, Map<String, String> map) {
        return new b.a().a(str).b(str2).c(d.a(context)).d("Android").e(String.valueOf(Build.VERSION.SDK_INT)).f(UTDevice.getUtdid(context)).g("1.0.8").a(map).a();
    }

    private void b(String str) {
        JSONArray optJSONArray;
        try {
            if (TextUtils.isEmpty(str) || (optJSONArray = new JSONObject(str).optJSONArray("result")) == null || optJSONArray.length() <= 0) {
                return;
            }
            this.f٦٣٤٤c.clear();
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                JSONObject jSONObject = (JSONObject) optJSONArray.get(i10);
                this.f٦٣٤٤c.add(new Beacon.Config(jSONObject.optString(TransferTable.COLUMN_KEY), jSONObject.optString("value")));
            }
        } catch (Exception unused) {
        }
    }

    private String encode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    private String a(b bVar) {
        Map<String, String> map = bVar.f٦٣٤٦a;
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            sb.append(encode(str));
            sb.append("=");
            sb.append(encode(map.get(str)));
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        this.f٣a.a(new Beacon.Error(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Beacon.Config> a() {
        return Collections.unmodifiableList(this.f٦٣٤٤c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a, reason: collision with other method in class */
    public void m٢٤٨a(Context context, String str, String str2, Map<String, String> map) {
        b a10 = a(context, str, str2, map);
        String str3 = f٦٣٤٣b + "/byappkey";
        com.alibaba.sdk.android.beacon.b.a("beacon", "url=" + str3);
        String a11 = this.f٤a.a(str3, a(a10).getBytes());
        com.alibaba.sdk.android.beacon.b.a("beacon", "[fetchByAppKey] result: " + a11);
        a(a11);
    }

    private void a(String str) {
        b(str);
    }
}
