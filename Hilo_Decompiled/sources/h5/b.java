package h5;

import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Object f١٤٥٠٧a;

        /* renamed from: b, reason: collision with root package name */
        private List f١٤٥٠٨b;

        public a(Object obj) {
            if (obj != null) {
                this.f١٤٥٠٧a = obj;
                this.f١٤٥٠٨b = new ArrayList();
                return;
            }
            throw new NullPointerException("null reference");
        }

        public final a a(String str, Object obj) {
            this.f١٤٥٠٨b.add(h5.a.a(str + "=" + obj));
            return this;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f١٤٥٠٧a.getClass().getSimpleName());
            sb.append('{');
            int size = this.f١٤٥٠٨b.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb.append((String) this.f١٤٥٠٨b.get(i10));
                if (i10 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static a a(Object obj) {
        return new a(obj);
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || !obj.equals(obj2)) {
                return false;
            }
            return true;
        }
        return true;
    }
}
