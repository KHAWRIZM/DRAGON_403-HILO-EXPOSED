package com.google.android.datatransport.cct;

import a7.n;
import a7.o;
import a7.p;
import a7.q;
import a7.r;
import a7.s;
import a7.t;
import a7.u;
import a7.v;
import a7.w;
import a7.x;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import anet.channel.request.Request;
import anet.channel.util.HttpConstant;
import b7.h;
import b7.i;
import c7.f;
import c7.g;
import c7.m;
import com.alibaba.sdk.android.tbrest.rest.RestConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.datatransport.cct.d;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class d implements m {

    /* renamed from: a, reason: collision with root package name */
    private final DataEncoder f٨١٠٨a;

    /* renamed from: b, reason: collision with root package name */
    private final ConnectivityManager f٨١٠٩b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f٨١١٠c;

    /* renamed from: d, reason: collision with root package name */
    final URL f٨١١١d;

    /* renamed from: e, reason: collision with root package name */
    private final l7.a f٨١١٢e;

    /* renamed from: f, reason: collision with root package name */
    private final l7.a f٨١١٣f;

    /* renamed from: g, reason: collision with root package name */
    private final int f٨١١٤g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final URL f٨١١٥a;

        /* renamed from: b, reason: collision with root package name */
        final n f٨١١٦b;

        /* renamed from: c, reason: collision with root package name */
        final String f٨١١٧c;

        a(URL url, n nVar, String str) {
            this.f٨١١٥a = url;
            this.f٨١١٦b = nVar;
            this.f٨١١٧c = str;
        }

        a a(URL url) {
            return new a(url, this.f٨١١٦b, this.f٨١١٧c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final int f٨١١٨a;

        /* renamed from: b, reason: collision with root package name */
        final URL f٨١١٩b;

        /* renamed from: c, reason: collision with root package name */
        final long f٨١٢٠c;

        b(int i10, URL url, long j10) {
            this.f٨١١٨a = i10;
            this.f٨١١٩b = url;
            this.f٨١٢٠c = j10;
        }
    }

    d(Context context, l7.a aVar, l7.a aVar2, int i10) {
        this.f٨١٠٨a = n.b();
        this.f٨١١٠c = context;
        this.f٨١٠٩b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f٨١١١d = o(com.google.android.datatransport.cct.a.f٨٠٩٩c);
        this.f٨١١٢e = aVar2;
        this.f٨١١٣f = aVar;
        this.f٨١١٤g = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b e(a aVar) {
        f7.a.f("CctTransportBackend", "Making request to: %s", aVar.f٨١١٥a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f٨١١٥a.openConnection();
        httpURLConnection.setConnectTimeout(RestConstants.G_MAX_READ_CONNECTION_STREAM_TIME_OUT);
        httpURLConnection.setReadTimeout(this.f٨١١٤g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod(Request.Method.POST);
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "3.3.0"));
        httpURLConnection.setRequestProperty("Content-Encoding", HttpConstant.GZIP);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty(HttpConstant.ACCEPT_ENCODING, HttpConstant.GZIP);
        String str = aVar.f٨١١٧c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.f٨١٠٨a.encode(aVar.f٨١١٦b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    f7.a.f("CctTransportBackend", "Status Code: %d", Integer.valueOf(responseCode));
                    f7.a.b("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                    f7.a.b("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode != 302 && responseCode != 301 && responseCode != 307) {
                        if (responseCode != 200) {
                            return new b(responseCode, null, 0L);
                        }
                        InputStream inputStream = httpURLConnection.getInputStream();
                        try {
                            InputStream n10 = n(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                            try {
                                b bVar = new b(responseCode, null, v.b(new BufferedReader(new InputStreamReader(n10))).c());
                                if (n10 != null) {
                                    n10.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                return bVar;
                            } finally {
                            }
                        } catch (Throwable th) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    }
                    return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                } finally {
                }
            } catch (Throwable th3) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (EncodingException e10) {
            e = e10;
            f7.a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        } catch (ConnectException e11) {
            e = e11;
            f7.a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (UnknownHostException e12) {
            e = e12;
            f7.a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (IOException e13) {
            e = e13;
            f7.a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        }
    }

    private static String f(Context context) {
        String simOperator = k(context).getSimOperator();
        if (simOperator != null) {
            return simOperator;
        }
        return "";
    }

    private static int g(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return w.b.UNKNOWN_MOBILE_SUBTYPE.c();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return w.b.COMBINED.c();
        }
        if (w.b.a(subtype) == null) {
            return 0;
        }
        return subtype;
    }

    private static int h(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return w.c.NONE.c();
        }
        return networkInfo.getType();
    }

    private static int i(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            f7.a.d("CctTransportBackend", "Unable to find version code for package", e10);
            return -1;
        }
    }

    private n j(f fVar) {
        t.a l10;
        HashMap hashMap = new HashMap();
        for (i iVar : fVar.b()) {
            String n10 = iVar.n();
            if (!hashMap.containsKey(n10)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(iVar);
                hashMap.put(n10, arrayList);
            } else {
                ((List) hashMap.get(n10)).add(iVar);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            i iVar2 = (i) ((List) entry.getValue()).get(0);
            u.a b10 = u.a().f(x.DEFAULT).g(this.f٨١١٣f.a()).h(this.f٨١١٢e.a()).b(o.a().c(o.b.ANDROID_FIREBASE).b(a7.a.a().m(Integer.valueOf(iVar2.i("sdk-version"))).j(iVar2.b(DeviceRequestsHelper.DEVICE_INFO_MODEL)).f(iVar2.b("hardware")).d(iVar2.b(DeviceRequestsHelper.DEVICE_INFO_DEVICE)).l(iVar2.b("product")).k(iVar2.b("os-uild")).h(iVar2.b("manufacturer")).e(iVar2.b("fingerprint")).c(iVar2.b("country")).g(iVar2.b("locale")).i(iVar2.b("mcc_mnc")).b(iVar2.b("application_build")).a()).a());
            try {
                b10.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                b10.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (i iVar3 : (List) entry.getValue()) {
                h e10 = iVar3.e();
                z6.c b11 = e10.b();
                if (b11.equals(z6.c.b("proto"))) {
                    l10 = t.l(e10.a());
                } else if (b11.equals(z6.c.b("json"))) {
                    l10 = t.k(new String(e10.a(), Charset.forName("UTF-8")));
                } else {
                    f7.a.g("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", b11);
                }
                l10.d(iVar3.f()).e(iVar3.o()).j(iVar3.j("tz-offset")).g(w.a().c(w.c.a(iVar3.i("net-type"))).b(w.b.a(iVar3.i("mobile-subtype"))).a());
                if (iVar3.d() != null) {
                    l10.c(iVar3.d());
                }
                if (iVar3.l() != null) {
                    l10.b(p.a().b(s.a().b(r.a().b(iVar3.l()).a()).a()).c(p.b.EVENT_OVERRIDE).a());
                }
                if (iVar3.g() != null || iVar3.h() != null) {
                    q.a a10 = q.a();
                    if (iVar3.g() != null) {
                        a10.b(iVar3.g());
                    }
                    if (iVar3.h() != null) {
                        a10.c(iVar3.h());
                    }
                    l10.f(a10.a());
                }
                arrayList3.add(l10.a());
            }
            b10.c(arrayList3);
            arrayList2.add(b10.a());
        }
        return n.a(arrayList2);
    }

    private static TelephonyManager k(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    static long l() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ a m(a aVar, b bVar) {
        URL url = bVar.f٨١١٩b;
        if (url != null) {
            f7.a.b("CctTransportBackend", "Following redirect to: %s", url);
            return aVar.a(bVar.f٨١١٩b);
        }
        return null;
    }

    private static InputStream n(InputStream inputStream, String str) {
        if (HttpConstant.GZIP.equals(str)) {
            return new GZIPInputStream(inputStream);
        }
        return inputStream;
    }

    private static URL o(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e10) {
            throw new IllegalArgumentException("Invalid url: " + str, e10);
        }
    }

    @Override // c7.m
    public g a(f fVar) {
        n j10 = j(fVar);
        URL url = this.f٨١١١d;
        String str = null;
        if (fVar.c() != null) {
            try {
                com.google.android.datatransport.cct.a c10 = com.google.android.datatransport.cct.a.c(fVar.c());
                if (c10.d() != null) {
                    str = c10.d();
                }
                if (c10.e() != null) {
                    url = o(c10.e());
                }
            } catch (IllegalArgumentException unused) {
                return g.a();
            }
        }
        try {
            b bVar = (b) g7.b.a(5, new a(url, j10, str), new g7.a() { // from class: com.google.android.datatransport.cct.b
                @Override // g7.a
                public final Object apply(Object obj) {
                    d.b e10;
                    e10 = d.this.e((d.a) obj);
                    return e10;
                }
            }, new g7.c() { // from class: com.google.android.datatransport.cct.c
                @Override // g7.c
                public final Object a(Object obj, Object obj2) {
                    d.a m10;
                    m10 = d.m((d.a) obj, (d.b) obj2);
                    return m10;
                }
            });
            int i10 = bVar.f٨١١٨a;
            if (i10 == 200) {
                return g.e(bVar.f٨١٢٠c);
            }
            if (i10 < 500 && i10 != 404) {
                if (i10 == 400) {
                    return g.d();
                }
                return g.a();
            }
            return g.f();
        } catch (IOException e10) {
            f7.a.d("CctTransportBackend", "Could not make request to the backend", e10);
            return g.f();
        }
    }

    @Override // c7.m
    public i b(i iVar) {
        NetworkInfo activeNetworkInfo = this.f٨١٠٩b.getActiveNetworkInfo();
        return iVar.p().a("sdk-version", Build.VERSION.SDK_INT).c(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL).c("hardware", Build.HARDWARE).c(DeviceRequestsHelper.DEVICE_INFO_DEVICE, Build.DEVICE).c("product", Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", l()).a("net-type", h(activeNetworkInfo)).a("mobile-subtype", g(activeNetworkInfo)).c("country", Locale.getDefault().getCountry()).c("locale", Locale.getDefault().getLanguage()).c("mcc_mnc", f(this.f٨١١٠c)).c("application_build", Integer.toString(i(this.f٨١١٠c))).d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, l7.a aVar, l7.a aVar2) {
        this(context, aVar, aVar2, 130000);
    }
}
