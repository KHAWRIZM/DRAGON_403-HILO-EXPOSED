package u3;

import android.content.Context;
import android.util.Pair;
import com.airbnb.lottie.j;
import com.airbnb.lottie.o0;
import com.airbnb.lottie.s;
import com.amazonaws.services.s3.util.Mimetypes;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final g f١٨٢٣٥a;

    /* renamed from: b, reason: collision with root package name */
    private final f f١٨٢٣٦b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٨٢٣٧a;

        static {
            int[] iArr = new int[c.values().length];
            f١٨٢٣٧a = iArr;
            try {
                iArr[c.ZIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٨٢٣٧a[c.GZIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public h(g gVar, f fVar) {
        this.f١٨٢٣٥a = gVar;
        this.f١٨٢٣٦b = fVar;
    }

    private j a(Context context, String str, String str2) {
        g gVar;
        Pair a10;
        o0 y10;
        if (str2 == null || (gVar = this.f١٨٢٣٥a) == null || (a10 = gVar.a(str)) == null) {
            return null;
        }
        c cVar = (c) a10.first;
        InputStream inputStream = (InputStream) a10.second;
        int i10 = a.f١٨٢٣٧a[cVar.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                y10 = s.o(inputStream, str2);
            } else {
                try {
                    y10 = s.o(new GZIPInputStream(inputStream), str2);
                } catch (IOException e10) {
                    y10 = new o0((Throwable) e10);
                }
            }
        } else {
            y10 = s.y(context, new ZipInputStream(inputStream), str2);
        }
        if (y10.b() != null) {
            return (j) y10.b();
        }
        return null;
    }

    private o0 b(Context context, String str, String str2) {
        boolean z10;
        x3.f.a("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                d a10 = this.f١٨٢٣٦b.a(str);
                if (a10.isSuccessful()) {
                    o0 e10 = e(context, str, a10.r(), a10.p(), str2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Completed fetch from network. Success: ");
                    if (e10.b() != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    sb.append(z10);
                    x3.f.a(sb.toString());
                    try {
                        a10.close();
                    } catch (IOException e11) {
                        x3.f.d("LottieFetchResult close failed ", e11);
                    }
                    return e10;
                }
                o0 o0Var = new o0((Throwable) new IllegalArgumentException(a10.d()));
                try {
                    a10.close();
                } catch (IOException e12) {
                    x3.f.d("LottieFetchResult close failed ", e12);
                }
                return o0Var;
            } catch (Exception e13) {
                o0 o0Var2 = new o0((Throwable) e13);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e14) {
                        x3.f.d("LottieFetchResult close failed ", e14);
                    }
                }
                return o0Var2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e15) {
                    x3.f.d("LottieFetchResult close failed ", e15);
                }
            }
            throw th;
        }
    }

    private o0 d(String str, InputStream inputStream, String str2) {
        g gVar;
        if (str2 != null && (gVar = this.f١٨٢٣٥a) != null) {
            return s.o(new GZIPInputStream(new FileInputStream(gVar.g(str, inputStream, c.GZIP))), str);
        }
        return s.o(new GZIPInputStream(inputStream), null);
    }

    private o0 e(Context context, String str, InputStream inputStream, String str2, String str3) {
        o0 g10;
        c cVar;
        g gVar;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (!str2.contains("application/zip") && !str2.contains("application/x-zip") && !str2.contains("application/x-zip-compressed") && !str.split("\\?")[0].endsWith(".lottie")) {
            if (!str2.contains("application/gzip") && !str2.contains(Mimetypes.MIMETYPE_GZIP) && !str.split("\\?")[0].endsWith(".tgs")) {
                x3.f.a("Received json response.");
                cVar = c.JSON;
                g10 = f(str, inputStream, str3);
            } else {
                x3.f.a("Handling gzip response.");
                cVar = c.GZIP;
                g10 = d(str, inputStream, str3);
            }
        } else {
            x3.f.a("Handling zip response.");
            c cVar2 = c.ZIP;
            g10 = g(context, str, inputStream, str3);
            cVar = cVar2;
        }
        if (str3 != null && g10.b() != null && (gVar = this.f١٨٢٣٥a) != null) {
            gVar.f(str, cVar);
        }
        return g10;
    }

    private o0 f(String str, InputStream inputStream, String str2) {
        g gVar;
        if (str2 != null && (gVar = this.f١٨٢٣٥a) != null) {
            return s.o(new FileInputStream(gVar.g(str, inputStream, c.JSON).getAbsolutePath()), str);
        }
        return s.o(inputStream, null);
    }

    private o0 g(Context context, String str, InputStream inputStream, String str2) {
        g gVar;
        if (str2 != null && (gVar = this.f١٨٢٣٥a) != null) {
            return s.y(context, new ZipInputStream(new FileInputStream(gVar.g(str, inputStream, c.ZIP))), str);
        }
        return s.y(context, new ZipInputStream(inputStream), null);
    }

    public o0 c(Context context, String str, String str2) {
        j a10 = a(context, str, str2);
        if (a10 != null) {
            return new o0(a10);
        }
        x3.f.a("Animation for " + str + " not found in cache. Fetching from network.");
        return b(context, str, str2);
    }
}
