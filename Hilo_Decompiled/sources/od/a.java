package od;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class a extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;

    /* renamed from: a, reason: collision with root package name */
    private final List f١٦٨٠٦a;

    /* renamed from: b, reason: collision with root package name */
    private final String f١٦٨٠٧b;

    /* renamed from: c, reason: collision with root package name */
    private Throwable f١٦٨٠٨c;

    /* renamed from: od.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class C٠٢٠٦a extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        C٠٢٠٦a(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static abstract class b {
        b() {
        }

        abstract void a(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class c extends b {

        /* renamed from: a, reason: collision with root package name */
        private final PrintStream f١٦٨٠٩a;

        c(PrintStream printStream) {
            this.f١٦٨٠٩a = printStream;
        }

        @Override // od.a.b
        void a(Object obj) {
            this.f١٦٨٠٩a.println(obj);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class d extends b {

        /* renamed from: a, reason: collision with root package name */
        private final PrintWriter f١٦٨١٠a;

        d(PrintWriter printWriter) {
            this.f١٦٨١٠a = printWriter;
        }

        @Override // od.a.b
        void a(Object obj) {
            this.f١٦٨١٠a.println(obj);
        }
    }

    public a(Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    private void a(StringBuilder sb, Throwable th, String str) {
        sb.append(str);
        sb.append(th);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), "");
        }
    }

    private void c(b bVar) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i10 = 1;
        for (Throwable th : this.f١٦٨٠٦a) {
            sb.append("  ComposedException ");
            sb.append(i10);
            sb.append(" :\n");
            a(sb, th, "\t");
            i10++;
        }
        bVar.a(sb.toString());
    }

    public List b() {
        return this.f١٦٨٠٦a;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        int i10;
        try {
            if (this.f١٦٨٠٨c == null) {
                String property = System.getProperty("line.separator");
                if (this.f١٦٨٠٦a.size() > 1) {
                    IdentityHashMap identityHashMap = new IdentityHashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Multiple exceptions (");
                    sb.append(this.f١٦٨٠٦a.size());
                    sb.append(")");
                    sb.append(property);
                    for (Throwable th : this.f١٦٨٠٦a) {
                        int i11 = 0;
                        while (true) {
                            if (th != null) {
                                for (int i12 = 0; i12 < i11; i12++) {
                                    sb.append("  ");
                                }
                                sb.append("|-- ");
                                sb.append(th.getClass().getCanonicalName());
                                sb.append(": ");
                                String message = th.getMessage();
                                if (message != null && message.contains(property)) {
                                    sb.append(property);
                                    for (String str : message.split(property)) {
                                        for (int i13 = 0; i13 < i11 + 2; i13++) {
                                            sb.append("  ");
                                        }
                                        sb.append(str);
                                        sb.append(property);
                                    }
                                } else {
                                    sb.append(message);
                                    sb.append(property);
                                }
                                int i14 = 0;
                                while (true) {
                                    i10 = i11 + 2;
                                    if (i14 >= i10) {
                                        break;
                                    }
                                    sb.append("  ");
                                    i14++;
                                }
                                StackTraceElement[] stackTrace = th.getStackTrace();
                                if (stackTrace.length > 0) {
                                    sb.append("at ");
                                    sb.append(stackTrace[0]);
                                    sb.append(property);
                                }
                                if (!identityHashMap.containsKey(th)) {
                                    identityHashMap.put(th, Boolean.TRUE);
                                    th = th.getCause();
                                    i11++;
                                } else {
                                    Throwable cause = th.getCause();
                                    if (cause != null) {
                                        for (int i15 = 0; i15 < i10; i15++) {
                                            sb.append("  ");
                                        }
                                        sb.append("|-- ");
                                        sb.append("(cause not expanded again) ");
                                        sb.append(cause.getClass().getCanonicalName());
                                        sb.append(": ");
                                        sb.append(cause.getMessage());
                                        sb.append(property);
                                    }
                                }
                            }
                        }
                    }
                    this.f١٦٨٠٨c = new C٠٢٠٦a(sb.toString().trim());
                } else {
                    this.f١٦٨٠٨c = (Throwable) this.f١٦٨٠٦a.get(0);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f١٦٨٠٨c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f١٦٨٠٧b;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        c(new c(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        c(new d(printWriter));
    }

    public a(Iterable iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (iterable != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                Throwable th = (Throwable) it.next();
                if (th instanceof a) {
                    linkedHashSet.addAll(((a) th).b());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            List unmodifiableList = Collections.unmodifiableList(new ArrayList(linkedHashSet));
            this.f١٦٨٠٦a = unmodifiableList;
            this.f١٦٨٠٧b = unmodifiableList.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }
}
