package x;

import com.liulishuo.okdownload.core.Util;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import kotlin.UByte;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import w.m;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public boolean f١٨٨٤٣a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f١٨٨٤٤b;

    /* renamed from: c, reason: collision with root package name */
    public int f١٨٨٤٥c;

    /* renamed from: d, reason: collision with root package name */
    public long f١٨٨٤٦d;

    /* renamed from: e, reason: collision with root package name */
    public final n0.e f١٨٨٤٧e;

    /* renamed from: f, reason: collision with root package name */
    public final r0.g f١٨٨٤٨f;

    public g(n0.e eVar, r0.g gVar) {
        this.f١٨٨٤٧e = eVar;
        this.f١٨٨٤٨f = gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x013e A[Catch: all -> 0x0047, TryCatch #3 {all -> 0x0047, blocks: (B:3:0x0035, B:5:0x003d, B:6:0x004a, B:8:0x0057, B:9:0x005a, B:11:0x0066, B:12:0x007d, B:14:0x009a, B:16:0x00a2, B:28:0x00be, B:29:0x00ce, B:31:0x00d4, B:33:0x00de, B:36:0x00f5, B:42:0x011a, B:44:0x0122, B:46:0x0128, B:50:0x0148, B:51:0x014d, B:177:0x015b, B:179:0x0163, B:182:0x016a, B:184:0x0172, B:187:0x017b, B:189:0x0183, B:192:0x013e, B:193:0x0103, B:196:0x010c, B:199:0x00e9, B:200:0x0360, B:201:0x0367, B:202:0x0368, B:203:0x036f, B:205:0x006f), top: B:2:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011a A[Catch: all -> 0x0047, TRY_ENTER, TryCatch #3 {all -> 0x0047, blocks: (B:3:0x0035, B:5:0x003d, B:6:0x004a, B:8:0x0057, B:9:0x005a, B:11:0x0066, B:12:0x007d, B:14:0x009a, B:16:0x00a2, B:28:0x00be, B:29:0x00ce, B:31:0x00d4, B:33:0x00de, B:36:0x00f5, B:42:0x011a, B:44:0x0122, B:46:0x0128, B:50:0x0148, B:51:0x014d, B:177:0x015b, B:179:0x0163, B:182:0x016a, B:184:0x0172, B:187:0x017b, B:189:0x0183, B:192:0x013e, B:193:0x0103, B:196:0x010c, B:199:0x00e9, B:200:0x0360, B:201:0x0367, B:202:0x0368, B:203:0x036f, B:205:0x006f), top: B:2:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0148 A[Catch: all -> 0x0047, TryCatch #3 {all -> 0x0047, blocks: (B:3:0x0035, B:5:0x003d, B:6:0x004a, B:8:0x0057, B:9:0x005a, B:11:0x0066, B:12:0x007d, B:14:0x009a, B:16:0x00a2, B:28:0x00be, B:29:0x00ce, B:31:0x00d4, B:33:0x00de, B:36:0x00f5, B:42:0x011a, B:44:0x0122, B:46:0x0128, B:50:0x0148, B:51:0x014d, B:177:0x015b, B:179:0x0163, B:182:0x016a, B:184:0x0172, B:187:0x017b, B:189:0x0183, B:192:0x013e, B:193:0x0103, B:196:0x010c, B:199:0x00e9, B:200:0x0360, B:201:0x0367, B:202:0x0368, B:203:0x036f, B:205:0x006f), top: B:2:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0250  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        Map multimap;
        String str;
        boolean equals;
        long parseLong;
        Response response;
        Map multimap2;
        String a10;
        String a11;
        String a12;
        boolean z10;
        Response response2;
        long j10;
        boolean z11;
        n0.e eVar;
        boolean z12;
        boolean z13;
        boolean z14;
        byte[] bArr;
        Map multimap3;
        Map multimap4;
        long parseLong2;
        Response response3;
        int code;
        e eVar2 = n0.f.a().f١٦١٤٣g;
        n0.e eVar3 = this.f١٨٨٤٧e;
        r0.g gVar = this.f١٨٨٤٨f;
        f fVar = new f(eVar3, gVar);
        n0.f.a().f١٦١٤٣g.c(eVar3);
        n0.f.a().f١٦١٤٣g.b();
        l1.d a13 = n0.f.a().f١٦١٤٠d.a(eVar3.f١٦١١٤c);
        a13.b(eVar3.f١٦١٣٥x);
        String str2 = null;
        try {
            if (!l0.d.d(gVar.f١٧٢٨٤c)) {
                a13.f١٥٦٨٩b.addHeader("If-Match", gVar.f١٧٢٨٤c);
            }
            a13.f١٥٦٨٩b.addHeader("Range", "bytes=0-0");
            Map map = eVar3.f١٦١١٦e;
            if (map != null) {
                l0.d.c(map, a13);
            }
            m mVar = n0.f.a().f١٦١٣٨b.f١٨٦٦٣a;
            Request request = a13.f١٥٦٩٠c;
            if (request != null) {
                multimap = request.headers().toMultimap();
            } else {
                multimap = a13.f١٥٦٨٩b.build().headers().toMultimap();
            }
            mVar.f(eVar3, multimap);
            Request build = a13.f١٥٦٨٩b.build();
            a13.f١٥٦٩٠c = build;
            Response execute = a13.f١٥٦٨٨a.newCall(build).execute();
            a13.f١٥٦٩١d = execute;
            Response priorResponse = execute.priorResponse();
            if (priorResponse != null && a13.f١٥٦٩١d.isSuccessful() && ((code = priorResponse.code()) == 301 || code == 302 || code == 303 || code == 300 || code == 307 || code == 308)) {
                str = a13.f١٥٦٩١d.request().url().toString();
            } else {
                str = null;
            }
            eVar3.f١٦١٣٤w = str;
            Response response4 = a13.f١٥٦٩١d;
            if (response4 != null) {
                fVar.f١٨٨٤٢f = response4.code();
                Response response5 = a13.f١٥٦٩١d;
                if (response5 != null) {
                    if (response5.code() == 206) {
                        equals = true;
                    } else {
                        equals = "bytes".equals(a13.a(Util.ACCEPT_RANGES));
                    }
                    fVar.f١٨٨٣٨b = equals;
                    String a14 = a13.a("Content-Range");
                    if (a14 != null) {
                        String[] split = a14.split("/");
                        if (split.length >= 2) {
                            try {
                                parseLong = Long.parseLong(split[1]);
                            } catch (NumberFormatException unused) {
                            }
                            if (parseLong == -1) {
                                String a15 = a13.a(Util.TRANSFER_ENCODING);
                                if (a15 != null) {
                                    a15.equals("chunked");
                                }
                                parseLong = -1;
                            }
                            fVar.f١٨٨٣٩c = parseLong;
                            fVar.f١٨٨٤٠d = a13.a(Util.ETAG);
                            fVar.f١٨٨٤١e = f.a(a13);
                            response = a13.f١٥٦٩١d;
                            if (response != null) {
                                multimap2 = null;
                            } else {
                                multimap2 = response.headers().toMultimap();
                            }
                            if (multimap2 == null) {
                                multimap2 = new HashMap();
                            }
                            mVar.h(fVar.f١٨٨٣٧a, fVar.f١٨٨٤٢f, multimap2);
                            if (fVar.f١٨٨٣٩c == -1 && (((a10 = a13.a("Content-Range")) == null || a10.length() <= 0) && (((a11 = a13.a(Util.TRANSFER_ENCODING)) == null || !a11.equals("chunked")) && (a12 = a13.a("Content-Length")) != null && a12.length() > 0))) {
                                z10 = true;
                                a13.f١٥٦٩٠c = null;
                                response2 = a13.f١٥٦٩١d;
                                if (response2 != null) {
                                    response2.close();
                                }
                                a13.f١٥٦٩١d = null;
                                if (z10) {
                                    a13 = n0.f.a().f١٦١٤٠d.a(fVar.f١٨٨٣٧a.f١٦١١٤c);
                                    a13.b(fVar.f١٨٨٣٧a.f١٦١٣٥x);
                                    m mVar2 = n0.f.a().f١٦١٣٨b.f١٨٦٦٣a;
                                    try {
                                        a13.f١٥٦٨٩b.method("HEAD", (RequestBody) null);
                                        Map map2 = fVar.f١٨٨٣٧a.f١٦١١٦e;
                                        if (map2 != null) {
                                            l0.d.c(map2, a13);
                                        }
                                        n0.e eVar4 = fVar.f١٨٨٣٧a;
                                        Request request2 = a13.f١٥٦٩٠c;
                                        if (request2 != null) {
                                            multimap3 = request2.headers().toMultimap();
                                        } else {
                                            multimap3 = a13.f١٥٦٨٩b.build().headers().toMultimap();
                                        }
                                        mVar2.f(eVar4, multimap3);
                                        Request build2 = a13.f١٥٦٨٩b.build();
                                        a13.f١٥٦٩٠c = build2;
                                        Response execute2 = a13.f١٥٦٨٨a.newCall(build2).execute();
                                        a13.f١٥٦٩١d = execute2;
                                        n0.e eVar5 = fVar.f١٨٨٣٧a;
                                        if (execute2 != null) {
                                            int code2 = execute2.code();
                                            Response response6 = a13.f١٥٦٩١d;
                                            if (response6 == null) {
                                                multimap4 = null;
                                            } else {
                                                multimap4 = response6.headers().toMultimap();
                                            }
                                            mVar2.h(eVar5, code2, multimap4);
                                            String a16 = a13.a("Content-Length");
                                            if (a16 != null) {
                                                try {
                                                    parseLong2 = Long.parseLong(a16);
                                                } catch (NumberFormatException unused2) {
                                                }
                                                fVar.f١٨٨٣٩c = parseLong2;
                                                a13.f١٥٦٩٠c = null;
                                                response3 = a13.f١٥٦٩١d;
                                                if (response3 != null) {
                                                    response3.close();
                                                }
                                                a13.f١٥٦٩١d = null;
                                            }
                                            parseLong2 = -1;
                                            fVar.f١٨٨٣٩c = parseLong2;
                                            a13.f١٥٦٩٠c = null;
                                            response3 = a13.f١٥٦٩١d;
                                            if (response3 != null) {
                                            }
                                            a13.f١٥٦٩١d = null;
                                        } else {
                                            throw new IOException("Please invoke execute first!");
                                        }
                                    } finally {
                                    }
                                }
                                boolean z15 = fVar.f١٨٨٣٨b;
                                j10 = fVar.f١٨٨٣٩c;
                                if (j10 != -1) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                String str3 = fVar.f١٨٨٤٠d;
                                String str4 = fVar.f١٨٨٤١e;
                                int i10 = fVar.f١٨٨٤٢f;
                                eVar = this.f١٨٨٤٧e;
                                r0.g gVar2 = this.f١٨٨٤٨f;
                                if (l0.d.d(eVar.f١٦١٣٠s.f١٨٨٢٤a)) {
                                    if (l0.d.d(str4)) {
                                        String str5 = eVar.f١٦١١٤c;
                                        Matcher matcher = e.f١٨٨٣٢c.matcher(str5);
                                        String str6 = null;
                                        while (matcher.find()) {
                                            str6 = matcher.group(1);
                                        }
                                        if (l0.d.d(str6)) {
                                            try {
                                                bArr = MessageDigest.getInstance("MD5").digest(str5.getBytes("UTF-8"));
                                            } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused3) {
                                                bArr = null;
                                            }
                                            if (bArr != null) {
                                                StringBuilder sb = new StringBuilder(bArr.length * 2);
                                                for (byte b10 : bArr) {
                                                    int i11 = b10 & UByte.MAX_VALUE;
                                                    if (i11 < 16) {
                                                        sb.append('0');
                                                    }
                                                    sb.append(Integer.toHexString(i11));
                                                }
                                                str2 = sb.toString();
                                            }
                                        } else {
                                            str2 = str6;
                                        }
                                        if (str2 != null) {
                                            str4 = str2;
                                        } else {
                                            throw new IOException("Can't find valid filename.");
                                        }
                                    }
                                    if (l0.d.d(eVar.f١٦١٣٠s.f١٨٨٢٤a)) {
                                        synchronized (eVar) {
                                            try {
                                                if (l0.d.d(eVar.f١٦١٣٠s.f١٨٨٢٤a)) {
                                                    eVar.f١٦١٣٠s.f١٨٨٢٤a = str4;
                                                    gVar2.f١٧٢٨٧f.f١٨٨٢٤a = str4;
                                                }
                                            } finally {
                                            }
                                        }
                                    }
                                }
                                r0.g gVar3 = this.f١٨٨٤٨f;
                                gVar3.f١٧٢٩٠i = z11;
                                gVar3.f١٧٢٨٤c = str3;
                                if (n0.f.a().f١٦١٣٧a.i(this.f١٨٨٤٧e)) {
                                    if (this.f١٨٨٤٨f.e() != 0) {
                                        z12 = true;
                                    } else {
                                        z12 = false;
                                    }
                                    int a17 = e.a(i10, z12, this.f١٨٨٤٨f, str3);
                                    if (a17 == 0) {
                                        z13 = true;
                                    } else {
                                        z13 = false;
                                    }
                                    this.f١٨٨٤٤b = z13;
                                    this.f١٨٨٤٥c = a17;
                                    this.f١٨٨٤٦d = j10;
                                    this.f١٨٨٤٣a = z15;
                                    if (i10 != 416 || j10 < 0 || !z13) {
                                        if (this.f١٨٨٤٨f.e() != 0) {
                                            z14 = true;
                                        } else {
                                            z14 = false;
                                        }
                                        if ((i10 != 206 && i10 != 200) || (i10 == 200 && z14)) {
                                            throw new z.b(i10, this.f١٨٨٤٨f.e());
                                        }
                                        return;
                                    }
                                    return;
                                }
                                throw z.e.f١٩٣٢٨a;
                            }
                            z10 = false;
                            a13.f١٥٦٩٠c = null;
                            response2 = a13.f١٥٦٩١d;
                            if (response2 != null) {
                            }
                            a13.f١٥٦٩١d = null;
                            if (z10) {
                            }
                            boolean z152 = fVar.f١٨٨٣٨b;
                            j10 = fVar.f١٨٨٣٩c;
                            if (j10 != -1) {
                            }
                            String str32 = fVar.f١٨٨٤٠d;
                            String str42 = fVar.f١٨٨٤١e;
                            int i102 = fVar.f١٨٨٤٢f;
                            eVar = this.f١٨٨٤٧e;
                            r0.g gVar22 = this.f١٨٨٤٨f;
                            if (l0.d.d(eVar.f١٦١٣٠s.f١٨٨٢٤a)) {
                            }
                            r0.g gVar32 = this.f١٨٨٤٨f;
                            gVar32.f١٧٢٩٠i = z11;
                            gVar32.f١٧٢٨٤c = str32;
                            if (n0.f.a().f١٦١٣٧a.i(this.f١٨٨٤٧e)) {
                            }
                        }
                    }
                    parseLong = -1;
                    if (parseLong == -1) {
                    }
                    fVar.f١٨٨٣٩c = parseLong;
                    fVar.f١٨٨٤٠d = a13.a(Util.ETAG);
                    fVar.f١٨٨٤١e = f.a(a13);
                    response = a13.f١٥٦٩١d;
                    if (response != null) {
                    }
                    if (multimap2 == null) {
                    }
                    mVar.h(fVar.f١٨٨٣٧a, fVar.f١٨٨٤٢f, multimap2);
                    if (fVar.f١٨٨٣٩c == -1) {
                        z10 = true;
                        a13.f١٥٦٩٠c = null;
                        response2 = a13.f١٥٦٩١d;
                        if (response2 != null) {
                        }
                        a13.f١٥٦٩١d = null;
                        if (z10) {
                        }
                        boolean z1522 = fVar.f١٨٨٣٨b;
                        j10 = fVar.f١٨٨٣٩c;
                        if (j10 != -1) {
                        }
                        String str322 = fVar.f١٨٨٤٠d;
                        String str422 = fVar.f١٨٨٤١e;
                        int i1022 = fVar.f١٨٨٤٢f;
                        eVar = this.f١٨٨٤٧e;
                        r0.g gVar222 = this.f١٨٨٤٨f;
                        if (l0.d.d(eVar.f١٦١٣٠s.f١٨٨٢٤a)) {
                        }
                        r0.g gVar322 = this.f١٨٨٤٨f;
                        gVar322.f١٧٢٩٠i = z11;
                        gVar322.f١٧٢٨٤c = str322;
                        if (n0.f.a().f١٦١٣٧a.i(this.f١٨٨٤٧e)) {
                        }
                    }
                    z10 = false;
                    a13.f١٥٦٩٠c = null;
                    response2 = a13.f١٥٦٩١d;
                    if (response2 != null) {
                    }
                    a13.f١٥٦٩١d = null;
                    if (z10) {
                    }
                    boolean z15222 = fVar.f١٨٨٣٨b;
                    j10 = fVar.f١٨٨٣٩c;
                    if (j10 != -1) {
                    }
                    String str3222 = fVar.f١٨٨٤٠d;
                    String str4222 = fVar.f١٨٨٤١e;
                    int i10222 = fVar.f١٨٨٤٢f;
                    eVar = this.f١٨٨٤٧e;
                    r0.g gVar2222 = this.f١٨٨٤٨f;
                    if (l0.d.d(eVar.f١٦١٣٠s.f١٨٨٢٤a)) {
                    }
                    r0.g gVar3222 = this.f١٨٨٤٨f;
                    gVar3222.f١٧٢٩٠i = z11;
                    gVar3222.f١٧٢٨٤c = str3222;
                    if (n0.f.a().f١٦١٣٧a.i(this.f١٨٨٤٧e)) {
                    }
                } else {
                    throw new IOException("Please invoke execute first!");
                }
            } else {
                throw new IOException("Please invoke execute first!");
            }
        } finally {
        }
    }

    public final String toString() {
        return "acceptRange[" + this.f١٨٨٤٣a + "] resumable[" + this.f١٨٨٤٤b + "] failedCause[" + v0.b.a(this.f١٨٨٤٥c) + "] instanceLength[" + this.f١٨٨٤٦d + "] " + super.toString();
    }
}
