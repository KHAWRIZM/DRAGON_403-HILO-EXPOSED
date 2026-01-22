package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.data.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class j implements d {

    /* renamed from: g, reason: collision with root package name */
    static final b f٧٤٤٥g = new a();

    /* renamed from: a, reason: collision with root package name */
    private final t4.h f٧٤٤٦a;

    /* renamed from: b, reason: collision with root package name */
    private final int f٧٤٤٧b;

    /* renamed from: c, reason: collision with root package name */
    private final b f٧٤٤٨c;

    /* renamed from: d, reason: collision with root package name */
    private HttpURLConnection f٧٤٤٩d;

    /* renamed from: e, reason: collision with root package name */
    private InputStream f٧٤٥٠e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f٧٤٥١f;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.data.j.b
        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
        HttpURLConnection a(URL url);
    }

    public j(t4.h hVar, int i10) {
        this(hVar, i10, f٧٤٤٥g);
    }

    private HttpURLConnection a(URL url, Map map) {
        try {
            HttpURLConnection a10 = this.f٧٤٤٨c.a(url);
            for (Map.Entry entry : map.entrySet()) {
                a10.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            a10.setConnectTimeout(this.f٧٤٤٧b);
            a10.setReadTimeout(this.f٧٤٤٧b);
            a10.setUseCaches(false);
            a10.setDoInput(true);
            a10.setInstanceFollowRedirects(false);
            return a10;
        } catch (IOException e10) {
            throw new m4.e("URL.openConnection threw", 0, e10);
        }
    }

    private static int b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e10) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to get a response code", e10);
                return -1;
            }
            return -1;
        }
    }

    private InputStream c(HttpURLConnection httpURLConnection) {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.f٧٤٥٠e = f5.c.b(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                this.f٧٤٥٠e = httpURLConnection.getInputStream();
            }
            return this.f٧٤٥٠e;
        } catch (IOException e10) {
            throw new m4.e("Failed to obtain InputStream", b(httpURLConnection), e10);
        }
    }

    private static boolean d(int i10) {
        if (i10 / 100 == 2) {
            return true;
        }
        return false;
    }

    private static boolean e(int i10) {
        if (i10 / 100 == 3) {
            return true;
        }
        return false;
    }

    private InputStream f(URL url, int i10, URL url2, Map map) {
        if (i10 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new m4.e("In re-direct loop", -1);
                    }
                } catch (URISyntaxException unused) {
                }
            }
            HttpURLConnection a10 = a(url, map);
            this.f٧٤٤٩d = a10;
            try {
                a10.connect();
                this.f٧٤٥٠e = this.f٧٤٤٩d.getInputStream();
                if (this.f٧٤٥١f) {
                    return null;
                }
                int b10 = b(this.f٧٤٤٩d);
                if (d(b10)) {
                    return c(this.f٧٤٤٩d);
                }
                if (e(b10)) {
                    String headerField = this.f٧٤٤٩d.getHeaderField("Location");
                    if (!TextUtils.isEmpty(headerField)) {
                        try {
                            URL url3 = new URL(url, headerField);
                            cleanup();
                            return f(url3, i10 + 1, url, map);
                        } catch (MalformedURLException e10) {
                            throw new m4.e("Bad redirect url: " + headerField, b10, e10);
                        }
                    }
                    throw new m4.e("Received empty or null redirect url", b10);
                }
                if (b10 == -1) {
                    throw new m4.e(b10);
                }
                try {
                    throw new m4.e(this.f٧٤٤٩d.getResponseMessage(), b10);
                } catch (IOException e11) {
                    throw new m4.e("Failed to get a response message", b10, e11);
                }
            } catch (IOException e12) {
                throw new m4.e("Failed to connect or obtain data", b(this.f٧٤٤٩d), e12);
            }
        }
        throw new m4.e("Too many (> 5) redirects!", -1);
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
        this.f٧٤٥١f = true;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cleanup() {
        InputStream inputStream = this.f٧٤٥٠e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f٧٤٤٩d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f٧٤٤٩d = null;
    }

    @Override // com.bumptech.glide.load.data.d
    public Class getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public m4.a getDataSource() {
        return m4.a.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.d
    public void loadData(com.bumptech.glide.f fVar, d.a aVar) {
        StringBuilder sb;
        long b10 = f5.g.b();
        try {
            try {
                aVar.onDataReady(f(this.f٧٤٤٦a.g(), 0, null, this.f٧٤٤٦a.c()));
            } catch (IOException e10) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e10);
                }
                aVar.onLoadFailed(e10);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    sb = new StringBuilder();
                } else {
                    return;
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(f5.g.a(b10));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + f5.g.a(b10));
            }
            throw th;
        }
    }

    j(t4.h hVar, int i10, b bVar) {
        this.f٧٤٤٦a = hVar;
        this.f٧٤٤٧b = i10;
        this.f٧٤٤٨c = bVar;
    }
}
