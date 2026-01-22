package hf;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class a implements Serializable {
    private static final Pattern f = Pattern.compile("([\\s\\S]*)\\((.*)\\)");
    public static final a g = new a(null, "No Tests", new Annotation[0]);
    public static final a h = new a(null, "Test mechanism", new Annotation[0]);
    private static final long serialVersionUID = 1;
    private final Collection a;
    private final String b;
    private final Serializable c;
    private final Annotation[] d;
    private volatile Class e;

    private a(Class cls, String str, Annotation... annotationArr) {
        this(cls, str, str, annotationArr);
    }

    public String a() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        return this.c.equals(((a) obj).c);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return a();
    }

    private a(Class cls, String str, Serializable serializable, Annotation... annotationArr) {
        this.a = new ConcurrentLinkedQueue();
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("The display name must not be empty.");
        }
        if (serializable != null) {
            this.e = cls;
            this.b = str;
            this.c = serializable;
            this.d = annotationArr;
            return;
        }
        throw new IllegalArgumentException("The unique id must not be null.");
    }
}
