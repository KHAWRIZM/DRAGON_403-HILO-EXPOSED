package t0;

import com.liulishuo.okdownload.core.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l0.d;
import l1.c;
import n0.e;
import n0.f;
import okhttp3.Request;
import okhttp3.Response;
import r0.g;
import w.m;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b implements m0.b {
    @Override // m0.b
    public final l1.a b(x.b bVar) {
        Map multimap;
        Map multimap2;
        boolean z10;
        g gVar = bVar.f١٨٨١٠c;
        c a10 = bVar.a();
        e eVar = bVar.f١٨٨٠٩b;
        Map map = eVar.f١٦١١٦e;
        if (map != null) {
            d.c(map, a10);
        }
        if (map == null || !map.containsKey("User-Agent")) {
            ((l1.d) a10).f١٥٦٨٩b.addHeader("User-Agent", "OkDownload/1.0.7");
        }
        int i10 = bVar.f١٨٨٠٨a;
        r0.e eVar2 = (r0.e) gVar.f١٧٢٨٨g.get(i10);
        if (eVar2 != null) {
            l1.d dVar = (l1.d) a10;
            dVar.f١٥٦٨٩b.addHeader("Range", ("bytes=" + (eVar2.f١٧٢٧٩c.get() + eVar2.f١٧٢٧٧a) + "-") + ((eVar2.f١٧٢٧٧a + eVar2.f١٧٢٧٨b) - 1));
            eVar2.f١٧٢٧٩c.get();
            eVar2.f١٧٢٧٩c.get();
            String str = gVar.f١٧٢٨٤c;
            if (!d.d(str)) {
                dVar.f١٥٦٨٩b.addHeader("If-Match", str);
            }
            if (!bVar.f١٨٨١١d.c()) {
                m mVar = f.a().f١٦١٣٨b.f١٨٦٦٣a;
                Request request = dVar.f١٥٦٩٠c;
                if (request != null) {
                    multimap = request.headers().toMultimap();
                } else {
                    multimap = dVar.f١٥٦٨٩b.build().headers().toMultimap();
                }
                mVar.e(eVar, i10, multimap);
                l1.a c10 = bVar.c();
                if (!bVar.f١٨٨١١d.c()) {
                    l1.d dVar2 = (l1.d) c10;
                    Response response = dVar2.f١٥٦٩١d;
                    if (response == null) {
                        multimap2 = null;
                    } else {
                        multimap2 = response.headers().toMultimap();
                    }
                    if (multimap2 == null) {
                        multimap2 = new HashMap();
                    }
                    m mVar2 = f.a().f١٦١٣٨b.f١٨٦٦٣a;
                    Response response2 = dVar2.f١٥٦٩١d;
                    if (response2 != null) {
                        mVar2.a(eVar, i10, response2.code(), multimap2);
                        x.e eVar3 = f.a().f١٦١٤٣g;
                        r0.e eVar4 = (r0.e) gVar.f١٧٢٨٨g.get(i10);
                        Response response3 = dVar2.f١٥٦٩١d;
                        if (response3 != null) {
                            int code = response3.code();
                            String a11 = dVar2.a(Util.ETAG);
                            x.e eVar5 = f.a().f١٦١٤٣g;
                            boolean z11 = false;
                            if (eVar4.f١٧٢٧٩c.get() != 0) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            int a12 = x.e.a(code, z10, gVar, a11);
                            if (a12 == 0) {
                                x.e eVar6 = f.a().f١٦١٤٣g;
                                if (eVar4.f١٧٢٧٩c.get() != 0) {
                                    z11 = true;
                                }
                                if ((code != 206 && code != 200) || (code == 200 && z11)) {
                                    throw new z.b(code, eVar4.f١٧٢٧٩c.get());
                                }
                                String a13 = dVar2.a("Content-Length");
                                long j10 = -1;
                                if (a13 != null && a13.length() != 0) {
                                    try {
                                        j10 = Long.parseLong(a13);
                                    } catch (NumberFormatException unused) {
                                    }
                                } else {
                                    String a14 = dVar2.a("Content-Range");
                                    if (a14 != null && a14.length() != 0) {
                                        try {
                                            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(a14);
                                            if (matcher.find()) {
                                                j10 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                                            }
                                        } catch (Exception e10) {
                                            e10.toString();
                                        }
                                    }
                                }
                                bVar.f١٨٨١٦i = j10;
                                return dVar2;
                            }
                            throw new z.g(a12);
                        }
                        throw new IOException("Please invoke execute first!");
                    }
                    throw new IOException("Please invoke execute first!");
                }
                throw z.d.f١٩٣٢٧a;
            }
            throw z.d.f١٩٣٢٧a;
        }
        throw new IOException(e0.m.a(i10, "No block-info found on "));
    }
}
