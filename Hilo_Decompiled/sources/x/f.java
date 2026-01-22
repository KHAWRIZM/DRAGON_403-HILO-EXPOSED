package x;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class f {

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f١٨٨٣٥g = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f١٨٨٣٦h = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");

    /* renamed from: a, reason: collision with root package name */
    public final n0.e f١٨٨٣٧a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f١٨٨٣٨b;

    /* renamed from: c, reason: collision with root package name */
    public long f١٨٨٣٩c;

    /* renamed from: d, reason: collision with root package name */
    public String f١٨٨٤٠d;

    /* renamed from: e, reason: collision with root package name */
    public String f١٨٨٤١e;

    /* renamed from: f, reason: collision with root package name */
    public int f١٨٨٤٢f;

    public f(n0.e eVar, r0.g gVar) {
        this.f١٨٨٣٧a = eVar;
    }

    public static String a(l1.d dVar) {
        String str;
        String a10 = dVar.a("Content-Disposition");
        if (a10 == null) {
            return null;
        }
        try {
            Matcher matcher = f١٨٨٣٥g.matcher(a10);
            if (matcher.find()) {
                str = matcher.group(1);
            } else {
                Matcher matcher2 = f١٨٨٣٦h.matcher(a10);
                if (matcher2.find()) {
                    str = matcher2.group(1);
                } else {
                    str = null;
                }
            }
            if (str != null && str.contains("../")) {
                throw new z.c("The filename [" + str + "] from the response is not allowable, because it contains '../', which can raise the directory traversal vulnerability");
            }
            return str;
        } catch (IllegalStateException unused) {
            return null;
        }
    }
}
