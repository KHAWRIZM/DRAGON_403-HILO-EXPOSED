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

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzgx implements Runnable {
    final /* synthetic */ zzgy zza;
    private final URL zzb;
    private final byte[] zzc;
    private final zzgv zzd;
    private final String zze;
    private final Map zzf;

    public zzgx(zzgy zzgyVar, String str, URL url, byte[] bArr, Map map, zzgv zzgvVar) {
        Objects.requireNonNull(zzgyVar);
        this.zza = zzgyVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzgvVar);
        this.zzb = url;
        this.zzc = bArr;
        this.zzd = zzgvVar;
        this.zze = str;
        this.zzf = map;
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00fd: MOVE (r8 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:254), block:B:81:0x00fc */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0100: MOVE (r10 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:257), block:B:79:0x00ff */
    /* JADX WARN: Removed duplicated region for block: B:25:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0161 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        HttpURLConnection httpURLConnection;
        Map map;
        IOException iOException;
        Map map2;
        int i10;
        zzgw zzgwVar;
        zzhy zzhyVar;
        int i11;
        URLConnection openConnection;
        Map map3;
        Map map4;
        InputStream inputStream;
        zzgy zzgyVar = this.zza;
        zzgyVar.zzaX();
        OutputStream outputStream = null;
        try {
            URL url = this.zzb;
            int i12 = com.google.android.gms.internal.measurement.zzcj.zzb;
            openConnection = url.openConnection();
        } catch (IOException e10) {
            iOException = e10;
            httpURLConnection = null;
            map2 = null;
        } catch (Throwable th) {
            th = th;
            httpURLConnection = null;
            map = null;
        }
        if (openConnection instanceof HttpURLConnection) {
            httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            zzib zzibVar = zzgyVar.zzu;
            zzibVar.zzc();
            httpURLConnection.setConnectTimeout(DateUtils.MINUTE);
            zzibVar.zzc();
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            try {
                Map map5 = this.zzf;
                if (map5 != null) {
                    for (Map.Entry entry : map5.entrySet()) {
                        httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                byte[] bArr = this.zzc;
                if (bArr != null) {
                    byte[] zzv = zzgyVar.zzg.zzp().zzv(bArr);
                    zzgr zzk = zzibVar.zzaV().zzk();
                    int length = zzv.length;
                    zzk.zzb("Uploading data. size", Integer.valueOf(length));
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.addRequestProperty("Content-Encoding", HttpConstant.GZIP);
                    httpURLConnection.setFixedLengthStreamingMode(length);
                    httpURLConnection.connect();
                    OutputStream outputStream2 = httpURLConnection.getOutputStream();
                    try {
                        outputStream2.write(zzv);
                        outputStream2.close();
                    } catch (IOException e11) {
                        iOException = e11;
                        map2 = null;
                        outputStream = outputStream2;
                        i11 = 0;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        zzgy zzgyVar2 = this.zza;
                        String str = this.zze;
                        zzgv zzgvVar = this.zzd;
                        zzhyVar = zzgyVar2.zzu.zzaW();
                        zzgwVar = new zzgw(str, zzgvVar, i11, iOException, null, map2, null);
                        zzhyVar.zzj(zzgwVar);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        map = null;
                        outputStream = outputStream2;
                        i10 = 0;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        this.zza.zzu.zzaW().zzj(new zzgw(this.zze, this.zzd, i10, null, null, map, null));
                        throw th;
                    }
                }
                int responseCode = httpURLConnection.getResponseCode();
                try {
                    try {
                        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                byte[] bArr2 = new byte[1024];
                                while (true) {
                                    int read = inputStream.read(bArr2);
                                    if (read <= 0) {
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(bArr2, 0, read);
                                    }
                                }
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                inputStream.close();
                                httpURLConnection.disconnect();
                                zzgy zzgyVar3 = this.zza;
                                String str2 = this.zze;
                                zzgv zzgvVar2 = this.zzd;
                                zzhyVar = zzgyVar3.zzu.zzaW();
                                zzgwVar = new zzgw(str2, zzgvVar2, responseCode, null, byteArray, headerFields, null);
                            } catch (Throwable th3) {
                                th = th3;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = null;
                        }
                    } catch (IOException e12) {
                        e = e12;
                        map2 = null;
                        i11 = responseCode;
                        iOException = e;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e13) {
                                this.zza.zzu.zzaV().zzb().zzc("Error closing HTTP compressed POST connection output stream. appId", zzgt.zzl(this.zze), e13);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzgy zzgyVar22 = this.zza;
                        String str3 = this.zze;
                        zzgv zzgvVar3 = this.zzd;
                        zzhyVar = zzgyVar22.zzu.zzaW();
                        zzgwVar = new zzgw(str3, zzgvVar3, i11, iOException, null, map2, null);
                        zzhyVar.zzj(zzgwVar);
                        return;
                    } catch (Throwable th5) {
                        th = th5;
                        i10 = responseCode;
                        map = null;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e14) {
                                this.zza.zzu.zzaV().zzb().zzc("Error closing HTTP compressed POST connection output stream. appId", zzgt.zzl(this.zze), e14);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.zza.zzu.zzaW().zzj(new zzgw(this.zze, this.zzd, i10, null, null, map, null));
                        throw th;
                    }
                } catch (IOException e15) {
                    e = e15;
                    i11 = responseCode;
                    map2 = map4;
                    iOException = e;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    zzgy zzgyVar222 = this.zza;
                    String str32 = this.zze;
                    zzgv zzgvVar32 = this.zzd;
                    zzhyVar = zzgyVar222.zzu.zzaW();
                    zzgwVar = new zzgw(str32, zzgvVar32, i11, iOException, null, map2, null);
                    zzhyVar.zzj(zzgwVar);
                    return;
                } catch (Throwable th6) {
                    th = th6;
                    i10 = responseCode;
                    map = map3;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    this.zza.zzu.zzaW().zzj(new zzgw(this.zze, this.zzd, i10, null, null, map, null));
                    throw th;
                }
            } catch (IOException e16) {
                iOException = e16;
                map2 = null;
            } catch (Throwable th7) {
                th = th7;
                map = null;
            }
            zzhyVar.zzj(zzgwVar);
            return;
        }
        throw new IOException("Failed to obtain HTTP connection");
    }
}
