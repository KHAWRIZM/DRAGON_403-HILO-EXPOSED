package com.google.android.gms.measurement.internal;

import anet.channel.util.HttpConstant;
import com.google.android.gms.common.internal.Preconditions;
import com.oudi.utils.date.DateUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzlm implements Runnable {
    final /* synthetic */ zzln zza;
    private final URL zzb;
    private final byte[] zzc;
    private final zzlk zzd;
    private final String zze;
    private final Map zzf;

    public zzlm(zzln zzlnVar, String str, URL url, byte[] bArr, Map map, zzlk zzlkVar) {
        Objects.requireNonNull(zzlnVar);
        this.zza = zzlnVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzlkVar);
        this.zzb = url;
        this.zzc = bArr;
        this.zzd = zzlkVar;
        this.zze = str;
        this.zzf = map;
    }

    private final void zzb(final int i10, final Exception exc, final byte[] bArr, final Map map) {
        this.zza.zzu.zzaW().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzll
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzlm.this.zza(i10, exc, bArr, map);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.OutputStream] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        HttpURLConnection httpURLConnection;
        Map map;
        Map map2;
        Map map3;
        Map map4;
        ?? r52;
        ?? r53;
        int responseCode;
        Object obj;
        Object obj2;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        zzln zzlnVar = this.zza;
        zzlnVar.zzaX();
        int i10 = 0;
        try {
            URL url = this.zzb;
            int i11 = com.google.android.gms.internal.measurement.zzcj.zzb;
            URLConnection openConnection = url.openConnection();
            if (openConnection instanceof HttpURLConnection) {
                httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setDefaultUseCaches(false);
                zzib zzibVar = zzlnVar.zzu;
                zzibVar.zzc();
                httpURLConnection.setConnectTimeout(DateUtils.MINUTE);
                zzibVar.zzc();
                httpURLConnection.setReadTimeout(61000);
                httpURLConnection.setInstanceFollowRedirects(false);
                ?? r54 = 1;
                httpURLConnection.setDoInput(true);
                try {
                    try {
                        Map map5 = this.zzf;
                        if (map5 != null) {
                            for (Map.Entry entry : map5.entrySet()) {
                                httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                            }
                        }
                        byte[] bArr = this.zzc;
                        if (bArr != null) {
                            try {
                                zzibVar.zzaU();
                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
                                gZIPOutputStream.write(bArr);
                                gZIPOutputStream.close();
                                byteArrayOutputStream2.close();
                                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                zzgr zzk = this.zza.zzu.zzaV().zzk();
                                int length = byteArray.length;
                                zzk.zzb("Uploading data. size", Integer.valueOf(length));
                                httpURLConnection.setDoOutput(true);
                                httpURLConnection.addRequestProperty("Content-Encoding", HttpConstant.GZIP);
                                httpURLConnection.setFixedLengthStreamingMode(length);
                                httpURLConnection.connect();
                                OutputStream outputStream = httpURLConnection.getOutputStream();
                                try {
                                    outputStream.write(byteArray);
                                    outputStream.close();
                                    r54 = outputStream;
                                } catch (IOException e10) {
                                    e = e10;
                                    map4 = null;
                                    r53 = outputStream;
                                    if (r53 != 0) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    zzb(i10, e, null, map4);
                                } catch (Throwable th) {
                                    th = th;
                                    map3 = null;
                                    r52 = outputStream;
                                    if (r52 != 0) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    zzb(i10, null, null, map3);
                                    throw th;
                                }
                            } catch (IOException e11) {
                                this.zza.zzu.zzaV().zzb().zzb("Failed to gzip post request content", e11);
                                throw e11;
                            }
                        }
                        responseCode = httpURLConnection.getResponseCode();
                    } catch (IOException e12) {
                        e = e12;
                        map2 = null;
                        map4 = map2;
                        r53 = map2;
                        if (r53 != 0) {
                            try {
                                r53.close();
                            } catch (IOException e13) {
                                this.zza.zzu.zzaV().zzb().zzc("Error closing HTTP compressed POST connection output stream. appId", zzgt.zzl(this.zze), e13);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzb(i10, e, null, map4);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    map = null;
                    map3 = map;
                    r52 = map;
                    if (r52 != 0) {
                        try {
                            r52.close();
                        } catch (IOException e14) {
                            this.zza.zzu.zzaV().zzb().zzc("Error closing HTTP compressed POST connection output stream. appId", zzgt.zzl(this.zze), e14);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zzb(i10, null, null, map3);
                    throw th;
                }
                try {
                    try {
                        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            inputStream = httpURLConnection.getInputStream();
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = null;
                        }
                        try {
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr2);
                                if (read > 0) {
                                    byteArrayOutputStream.write(bArr2, 0, read);
                                } else {
                                    byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                                    inputStream.close();
                                    httpURLConnection.disconnect();
                                    zzb(responseCode, null, byteArray2, headerFields);
                                    return;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    } catch (IOException e15) {
                        e = e15;
                        obj2 = null;
                        map4 = null;
                        IOException iOException = e;
                        i10 = responseCode;
                        e = iOException;
                        r53 = obj2;
                        if (r53 != 0) {
                        }
                        if (httpURLConnection != null) {
                        }
                        zzb(i10, e, null, map4);
                    } catch (Throwable th5) {
                        th = th5;
                        obj = null;
                        map3 = null;
                        Throwable th6 = th;
                        i10 = responseCode;
                        th = th6;
                        r52 = obj;
                        if (r52 != 0) {
                        }
                        if (httpURLConnection != null) {
                        }
                        zzb(i10, null, null, map3);
                        throw th;
                    }
                } catch (IOException e16) {
                    e = e16;
                    map4 = r54;
                    obj2 = null;
                    IOException iOException2 = e;
                    i10 = responseCode;
                    e = iOException2;
                    r53 = obj2;
                    if (r53 != 0) {
                    }
                    if (httpURLConnection != null) {
                    }
                    zzb(i10, e, null, map4);
                } catch (Throwable th7) {
                    th = th7;
                    map3 = r54;
                    obj = null;
                    Throwable th62 = th;
                    i10 = responseCode;
                    th = th62;
                    r52 = obj;
                    if (r52 != 0) {
                    }
                    if (httpURLConnection != null) {
                    }
                    zzb(i10, null, null, map3);
                    throw th;
                }
            } else {
                throw new IOException("Failed to obtain HTTP connection");
            }
        } catch (IOException e17) {
            e = e17;
            httpURLConnection = null;
            map2 = null;
        } catch (Throwable th8) {
            th = th8;
            httpURLConnection = null;
            map = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i10, Exception exc, byte[] bArr, Map map) {
        this.zzd.zza(this.zze, i10, exc, bArr, map);
    }
}
