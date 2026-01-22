package e7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    private static final d f١٣٩١٥c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private final String f١٣٩١٦a;

    /* renamed from: b, reason: collision with root package name */
    private final List f١٣٩١٧b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f١٣٩١٨a = "";

        /* renamed from: b, reason: collision with root package name */
        private List f١٣٩١٩b = new ArrayList();

        a() {
        }

        public d a() {
            return new d(this.f١٣٩١٨a, Collections.unmodifiableList(this.f١٣٩١٩b));
        }

        public a b(List list) {
            this.f١٣٩١٩b = list;
            return this;
        }

        public a c(String str) {
            this.f١٣٩١٨a = str;
            return this;
        }
    }

    d(String str, List list) {
        this.f١٣٩١٦a = str;
        this.f١٣٩١٧b = list;
    }

    public static a c() {
        return new a();
    }

    public List a() {
        return this.f١٣٩١٧b;
    }

    public String b() {
        return this.f١٣٩١٦a;
    }
}
