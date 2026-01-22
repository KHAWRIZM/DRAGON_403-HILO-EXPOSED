package k8;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class d {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f١٥٥٤١a;

        /* renamed from: b, reason: collision with root package name */
        private final a f١٥٥٤٢b;

        /* renamed from: c, reason: collision with root package name */
        private a f١٥٥٤٣c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f١٥٥٤٤d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f١٥٥٤٥e;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            String f١٥٥٤٦a;

            /* renamed from: b, reason: collision with root package name */
            Object f١٥٥٤٧b;

            /* renamed from: c, reason: collision with root package name */
            a f١٥٥٤٨c;

            private a() {
            }
        }

        private a a() {
            a aVar = new a();
            this.f١٥٥٤٣c.f١٥٥٤٨c = aVar;
            this.f١٥٥٤٣c = aVar;
            return aVar;
        }

        private b b(Object obj) {
            a().f١٥٥٤٧b = obj;
            return this;
        }

        private static boolean d(Object obj) {
            if (obj instanceof CharSequence) {
                if (((CharSequence) obj).length() != 0) {
                    return false;
                }
                return true;
            }
            if (obj instanceof Collection) {
                return ((Collection) obj).isEmpty();
            }
            if (obj instanceof Map) {
                return ((Map) obj).isEmpty();
            }
            if (obj instanceof g) {
                return !((g) obj).c();
            }
            if (!obj.getClass().isArray() || Array.getLength(obj) != 0) {
                return false;
            }
            return true;
        }

        public b c(Object obj) {
            return b(obj);
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String toString() {
            String str;
            boolean z10 = this.f١٥٥٤٤d;
            boolean z11 = this.f١٥٥٤٥e;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f١٥٥٤١a);
            sb.append('{');
            String str2 = "";
            for (a aVar = this.f١٥٥٤٢b.f١٥٥٤٨c; aVar != null; aVar = aVar.f١٥٥٤٨c) {
                Object obj = aVar.f١٥٥٤٧b;
                if (obj == null) {
                    if (z10) {
                    }
                    sb.append(str2);
                    str = aVar.f١٥٥٤٦a;
                    if (str != null) {
                        sb.append(str);
                        sb.append('=');
                    }
                    if (obj == null && obj.getClass().isArray()) {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                    } else {
                        sb.append(obj);
                    }
                    str2 = ", ";
                } else {
                    if (z11 && d(obj)) {
                    }
                    sb.append(str2);
                    str = aVar.f١٥٥٤٦a;
                    if (str != null) {
                    }
                    if (obj == null) {
                    }
                    sb.append(obj);
                    str2 = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        private b(String str) {
            a aVar = new a();
            this.f١٥٥٤٢b = aVar;
            this.f١٥٥٤٣c = aVar;
            this.f١٥٥٤٤d = false;
            this.f١٥٥٤٥e = false;
            this.f١٥٥٤١a = (String) h.i(str);
        }
    }

    public static b a(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
