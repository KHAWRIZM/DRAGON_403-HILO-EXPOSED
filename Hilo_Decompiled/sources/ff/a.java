package ff;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public abstract class a {
    public static void a(Object obj, Object obj2) {
        b(null, obj, obj2);
    }

    public static void b(String str, Object obj, Object obj2) {
        if (e(obj, obj2)) {
            return;
        }
        if ((obj instanceof String) && (obj2 instanceof String)) {
            if (str == null) {
                str = "";
            }
            throw new b(str, (String) obj, (String) obj2);
        }
        h(str, obj, obj2);
    }

    public static void c(String str, boolean z) {
        if (!z) {
            g(str);
        }
    }

    public static void d(boolean z) {
        c(null, z);
    }

    private static boolean e(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return k(obj, obj2);
    }

    public static void f() {
        g(null);
    }

    public static void g(String str) {
        if (str == null) {
            throw new AssertionError();
        }
        throw new AssertionError(str);
    }

    private static void h(String str, Object obj, Object obj2) {
        g(i(str, obj, obj2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String i(String str, Object obj, Object obj2) {
        String str2 = "";
        if (str != null && !"".equals(str)) {
            str2 = str + " ";
        }
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        if (e(valueOf, valueOf2)) {
            return str2 + "expected: " + j(obj, valueOf) + " but was: " + j(obj2, valueOf2);
        }
        return str2 + "expected:<" + valueOf + "> but was:<" + valueOf2 + ">";
    }

    private static String j(Object obj, String str) {
        String name;
        if (obj == null) {
            name = "null";
        } else {
            name = obj.getClass().getName();
        }
        return name + "<" + str + ">";
    }

    private static boolean k(Object obj, Object obj2) {
        return obj.equals(obj2);
    }
}
