package yc;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class f {
    private static final Pattern c = Pattern.compile("\\$(?<argumentName>[\\w_]+):(?<typeChar>[\\w]).*");
    private static final Pattern d = Pattern.compile("[a-z]+[\\w_]*");
    final List a;
    final List b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class b {
        final List a;
        final List b;

        private void b(String str, char c, Object obj) {
            if (c != 'L') {
                if (c != 'N') {
                    if (c != 'S') {
                        if (c == 'T') {
                            this.b.add(g(obj));
                            return;
                        }
                        throw new IllegalArgumentException(String.format("invalid format string: '%s'", str));
                    }
                    this.b.add(f(obj));
                    return;
                }
                this.b.add(e(obj));
                return;
            }
            this.b.add(d(obj));
        }

        private String e(Object obj) {
            if (obj instanceof CharSequence) {
                return obj.toString();
            }
            if (obj instanceof p) {
                return ((p) obj).a;
            }
            if (obj instanceof l) {
                return ((l) obj).b;
            }
            if (obj instanceof o) {
                return ((o) obj).a;
            }
            if (obj instanceof s) {
                return ((s) obj).b;
            }
            throw new IllegalArgumentException("expected name but was " + obj);
        }

        private String f(Object obj) {
            if (obj != null) {
                return String.valueOf(obj);
            }
            return null;
        }

        private r g(Object obj) {
            if (obj instanceof r) {
                return (r) obj;
            }
            if (obj instanceof TypeMirror) {
                return r.h((TypeMirror) obj);
            }
            if (obj instanceof Element) {
                return r.h(((Element) obj).asType());
            }
            if (obj instanceof Type) {
                return r.f((Type) obj);
            }
            throw new IllegalArgumentException("expected type but was " + obj);
        }

        private boolean l(char c) {
            if (c != '$' && c != '>' && c != '<' && c != '[' && c != ']' && c != 'W' && c != 'Z') {
                return false;
            }
            return true;
        }

        public b a(String str, Object... objArr) {
            String str2;
            int i;
            boolean z;
            boolean z2;
            int i2;
            char charAt;
            boolean z3;
            boolean z4;
            int i3;
            boolean z5;
            boolean z6;
            int i4 = 1;
            int[] iArr = new int[objArr.length];
            int i5 = 0;
            boolean z7 = false;
            int i6 = 0;
            boolean z8 = false;
            while (i5 < str.length()) {
                if (str.charAt(i5) != '$') {
                    int indexOf = str.indexOf(36, i5 + 1);
                    if (indexOf == -1) {
                        indexOf = str.length();
                    }
                    this.a.add(str.substring(i5, indexOf));
                    i5 = indexOf;
                } else {
                    int i7 = i5 + 1;
                    int i8 = i7;
                    while (true) {
                        if (i8 < str.length()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        Object[] objArr2 = new Object[i4];
                        objArr2[0] = str;
                        u.b(z2, "dangling format characters in '%s'", objArr2);
                        i2 = i8 + 1;
                        charAt = str.charAt(i8);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i8 = i2;
                    }
                    if (l(charAt)) {
                        if (i7 == i8) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        u.b(z3, "$$, $>, $<, $[, $], $W, and $Z may not have an index", new Object[0]);
                        this.a.add("$" + charAt);
                        i5 = i2;
                    } else {
                        if (i7 < i8) {
                            int parseInt = Integer.parseInt(str.substring(i7, i8)) - i4;
                            if (objArr.length > 0) {
                                int length = parseInt % objArr.length;
                                iArr[length] = iArr[length] + i4;
                            }
                            z4 = true;
                            i3 = i6;
                            i6 = parseInt;
                        } else {
                            z4 = z8;
                            i3 = i6 + 1;
                            z7 = true;
                        }
                        if (i6 >= 0 && i6 < objArr.length) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        u.b(z5, "index %d for '%s' not in range (received %s arguments)", Integer.valueOf(i6 + 1), str.substring(i5, i8 + i4), Integer.valueOf(objArr.length));
                        if (z4 && z7) {
                            z6 = false;
                        } else {
                            z6 = true;
                        }
                        u.b(z6, "cannot mix indexed and positional parameters", new Object[0]);
                        b(str, charAt, objArr[i6]);
                        this.a.add("$" + charAt);
                        i5 = i2;
                        i6 = i3;
                        z8 = z4;
                        i4 = 1;
                    }
                }
            }
            if (z7) {
                if (i6 >= objArr.length) {
                    z = true;
                } else {
                    z = false;
                }
                u.b(z, "unused arguments: expected %s, received %s", Integer.valueOf(i6), Integer.valueOf(objArr.length));
            }
            if (z8) {
                ArrayList arrayList = new ArrayList();
                int i9 = 0;
                while (i9 < objArr.length) {
                    if (iArr[i9] == 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("$");
                        i = 1;
                        sb2.append(i9 + 1);
                        arrayList.add(sb2.toString());
                    } else {
                        i = 1;
                    }
                    i9 += i;
                }
                if (arrayList.size() == 1) {
                    str2 = "";
                } else {
                    str2 = "s";
                }
                u.b(arrayList.isEmpty(), "unused argument%s: %s", str2, com.google.android.gms.measurement.internal.a.a(", ", arrayList));
            }
            return this;
        }

        public b c(String str, Object... objArr) {
            a("$[", new Object[0]);
            a(str, objArr);
            a(";\n$]", new Object[0]);
            return this;
        }

        public b h(String str, Object... objArr) {
            a(str + " {\n", objArr);
            k();
            return this;
        }

        public f i() {
            return new f(this);
        }

        public b j() {
            m();
            a("}\n", new Object[0]);
            return this;
        }

        public b k() {
            this.a.add("$>");
            return this;
        }

        public b m() {
            this.a.add("$<");
            return this;
        }

        private b() {
            this.a = new ArrayList();
            this.b = new ArrayList();
        }

        private Object d(Object obj) {
            return obj;
        }
    }

    public static b a() {
        return new b();
    }

    public static f c(String str, Object... objArr) {
        return new b().a(str, objArr).i();
    }

    public boolean b() {
        return this.a.isEmpty();
    }

    public b d() {
        b bVar = new b();
        bVar.a.addAll(this.a);
        bVar.b.addAll(this.b);
        return bVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        return toString().equals(obj.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        try {
            new j(sb2).e(this);
            return sb2.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private f(b bVar) {
        this.a = u.e(bVar.a);
        this.b = u.e(bVar.b);
    }
}
