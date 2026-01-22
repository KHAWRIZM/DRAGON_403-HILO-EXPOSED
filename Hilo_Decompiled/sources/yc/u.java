package yc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.Modifier;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
abstract class u {
    static String a(char c) {
        if (c != '\f') {
            if (c != '\r') {
                if (c != '\"') {
                    if (c != '\'') {
                        if (c != '\\') {
                            switch (c) {
                                case '\b':
                                    return "\\b";
                                case '\t':
                                    return "\\t";
                                case '\n':
                                    return "\\n";
                                default:
                                    if (Character.isISOControl(c)) {
                                        return String.format("\\u%04x", Integer.valueOf(c));
                                    }
                                    return Character.toString(c);
                            }
                        }
                        return "\\\\";
                    }
                    return "\\'";
                }
                return "\"";
            }
            return "\\r";
        }
        return "\\f";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z, String str, Object... objArr) {
        if (z) {
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object c(Object obj, String str, Object... objArr) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(boolean z, String str, Object... objArr) {
        if (z) {
        } else {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List e(Collection collection) {
        return Collections.unmodifiableList(new ArrayList(collection));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map f(Map map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map g(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (!((List) entry.getValue()).isEmpty()) {
                linkedHashMap.put(entry.getKey(), e((Collection) entry.getValue()));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set h(Collection collection) {
        return Collections.unmodifiableSet(new LinkedHashSet(collection));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Set set, Modifier... modifierArr) {
        boolean z;
        int i = 0;
        for (Modifier modifier : modifierArr) {
            if (set.contains(modifier)) {
                i++;
            }
        }
        if (i == 1) {
            z = true;
        } else {
            z = false;
        }
        b(z, "modifiers %s must contain one of %s", set, Arrays.toString(modifierArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String j(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(str.length() + 2);
        sb2.append('\"');
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\'') {
                sb2.append("'");
            } else if (charAt == '\"') {
                sb2.append("\\\"");
            } else {
                sb2.append(a(charAt));
                if (charAt == '\n' && i + 1 < str.length()) {
                    sb2.append("\"\n");
                    sb2.append(str2);
                    sb2.append(str2);
                    sb2.append("+ \"");
                }
            }
        }
        sb2.append('\"');
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set k(Set set, Set set2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(set);
        linkedHashSet.addAll(set2);
        return linkedHashSet;
    }
}
