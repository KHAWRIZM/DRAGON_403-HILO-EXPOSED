package dc;

import com.facebook.internal.security.CertificateUtil;
import java.util.HashMap;
import java.util.LinkedList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static LinkedList f١٣٦٩١b;

    /* renamed from: a, reason: collision with root package name */
    private HashMap f١٣٦٩٢a = new HashMap();

    private f() {
    }

    public static f a() {
        LinkedList linkedList = f١٣٦٩١b;
        if (linkedList == null) {
            return new f();
        }
        f fVar = (f) linkedList.poll();
        if (fVar != null) {
            return fVar;
        }
        return new f();
    }

    public static void g(f fVar) {
        fVar.d();
        if (f١٣٦٩١b == null) {
            f١٣٦٩١b = new LinkedList();
        }
        if (f١٣٦٩١b.size() < 2) {
            f١٣٦٩١b.push(fVar);
        }
    }

    public f b(int i10) {
        this.f١٣٦٩٢a.put("background", String.valueOf(i10));
        return this;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        boolean z10 = true;
        for (String str : this.f١٣٦٩٢a.keySet()) {
            String str2 = (String) this.f١٣٦٩٢a.get(str);
            if (str2 != null && !str2.isEmpty()) {
                if (!z10) {
                    sb.append("|");
                }
                sb.append(str);
                sb.append(CertificateUtil.DELIMITER);
                sb.append(str2);
                z10 = false;
            }
        }
        return sb.toString();
    }

    public f d() {
        this.f١٣٦٩٢a.clear();
        return this;
    }

    public f e(String str) {
        for (String str2 : str.split("[|]")) {
            String[] split = str2.split(CertificateUtil.DELIMITER);
            if (split.length == 2) {
                this.f١٣٦٩٢a.put(split[0].trim(), split[1].trim());
            }
        }
        return this;
    }

    public void f() {
        g(this);
    }

    public f h(int i10) {
        this.f١٣٦٩٢a.put("src", String.valueOf(i10));
        return this;
    }

    public f i(int i10) {
        this.f١٣٦٩٢a.put("textColor", String.valueOf(i10));
        return this;
    }

    public f j(int i10) {
        this.f١٣٦٩٢a.put("tintColor", String.valueOf(i10));
        return this;
    }
}
