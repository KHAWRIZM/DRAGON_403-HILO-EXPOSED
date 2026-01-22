package com.google.protobuf;

import com.google.protobuf.n;
import java.util.Collections;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class t extends v {

    /* renamed from: j, reason: collision with root package name */
    static final t f١١٩٥٣j = new t(true);

    /* renamed from: f, reason: collision with root package name */
    private final Map f١١٩٥٤f;

    /* renamed from: g, reason: collision with root package name */
    private final Map f١١٩٥٥g;

    /* renamed from: h, reason: collision with root package name */
    private final Map f١١٩٥٦h;

    /* renamed from: i, reason: collision with root package name */
    private final Map f١١٩٥٧i;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final n.b f١١٩٥٨a;

        /* renamed from: b, reason: collision with root package name */
        private final int f١١٩٥٩b;

        a(n.b bVar, int i10) {
            this.f١١٩٥٨a = bVar;
            this.f١١٩٥٩b = i10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f١١٩٥٨a != aVar.f١١٩٥٨a || this.f١١٩٥٩b != aVar.f١١٩٥٩b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f١١٩٥٨a.hashCode() * 65535) + this.f١١٩٥٩b;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b {
    }

    t(boolean z10) {
        super(v.f١١٩٧٠e);
        this.f١١٩٥٤f = Collections.emptyMap();
        this.f١١٩٥٥g = Collections.emptyMap();
        this.f١١٩٥٦h = Collections.emptyMap();
        this.f١١٩٥٧i = Collections.emptyMap();
    }

    public static t e() {
        return f١١٩٥٣j;
    }

    public b d(n.b bVar, int i10) {
        androidx.appcompat.app.a0.a(this.f١١٩٥٦h.get(new a(bVar, i10)));
        return null;
    }
}
