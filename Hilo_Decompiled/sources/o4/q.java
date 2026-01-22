package o4;

import android.util.Log;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class q extends Exception {

    /* renamed from: g, reason: collision with root package name */
    private static final StackTraceElement[] f١٦٧١٦g = new StackTraceElement[0];
    private static final long serialVersionUID = 1;

    /* renamed from: a, reason: collision with root package name */
    private final List f١٦٧١٧a;

    /* renamed from: b, reason: collision with root package name */
    private m4.f f١٦٧١٨b;

    /* renamed from: c, reason: collision with root package name */
    private m4.a f١٦٧١٩c;

    /* renamed from: d, reason: collision with root package name */
    private Class f١٦٧٢٠d;

    /* renamed from: e, reason: collision with root package name */
    private String f١٦٧٢١e;

    /* renamed from: f, reason: collision with root package name */
    private Exception f١٦٧٢٢f;

    public q(String str) {
        this(str, Collections.emptyList());
    }

    private void a(Throwable th, List list) {
        if (th instanceof q) {
            Iterator it = ((q) th).e().iterator();
            while (it.hasNext()) {
                a((Throwable) it.next(), list);
            }
            return;
        }
        list.add(th);
    }

    private static void b(List list, Appendable appendable) {
        try {
            c(list, appendable);
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    private static void c(List list, Appendable appendable) {
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            appendable.append("Cause (").append(String.valueOf(i11)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = (Throwable) list.get(i10);
            if (th instanceof q) {
                ((q) th).h(appendable);
            } else {
                d(th, appendable);
            }
            i10 = i11;
        }
    }

    private static void d(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private void h(Appendable appendable) {
        d(this, appendable);
        b(e(), new a(appendable));
    }

    public List e() {
        return this.f١٦٧١٧a;
    }

    public List f() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    public void g(String str) {
        List f10 = f();
        int size = f10.size();
        int i10 = 0;
        while (i10 < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i11 = i10 + 1;
            sb.append(i11);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), (Throwable) f10.get(i10));
            i10 = i11;
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f١٦٧٢١e);
        String str3 = "";
        if (this.f١٦٧٢٠d == null) {
            str = "";
        } else {
            str = ", " + this.f١٦٧٢٠d;
        }
        sb.append(str);
        if (this.f١٦٧١٩c == null) {
            str2 = "";
        } else {
            str2 = ", " + this.f١٦٧١٩c;
        }
        sb.append(str2);
        if (this.f١٦٧١٨b != null) {
            str3 = ", " + this.f١٦٧١٨b;
        }
        sb.append(str3);
        List<Throwable> f10 = f();
        if (f10.isEmpty()) {
            return sb.toString();
        }
        if (f10.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(f10.size());
            sb.append(" root causes:");
        }
        for (Throwable th : f10) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(m4.f fVar, m4.a aVar) {
        j(fVar, aVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(m4.f fVar, m4.a aVar, Class cls) {
        this.f١٦٧١٨b = fVar;
        this.f١٦٧١٩c = aVar;
        this.f١٦٧٢٠d = cls;
    }

    public void k(Exception exc) {
        this.f١٦٧٢٢f = exc;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public q(String str, Throwable th) {
        this(str, Collections.singletonList(th));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        h(printStream);
    }

    public q(String str, List list) {
        this.f١٦٧٢١e = str;
        setStackTrace(f١٦٧١٦g);
        this.f١٦٧١٧a = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        h(printWriter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a implements Appendable {

        /* renamed from: a, reason: collision with root package name */
        private final Appendable f١٦٧٢٣a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f١٦٧٢٤b = true;

        a(Appendable appendable) {
            this.f١٦٧٢٣a = appendable;
        }

        private CharSequence a(CharSequence charSequence) {
            if (charSequence == null) {
                return "";
            }
            return charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c10) {
            if (this.f١٦٧٢٤b) {
                this.f١٦٧٢٤b = false;
                this.f١٦٧٢٣a.append("  ");
            }
            this.f١٦٧٢٤b = c10 == '\n';
            this.f١٦٧٢٣a.append(c10);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            CharSequence a10 = a(charSequence);
            return append(a10, 0, a10.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i10, int i11) {
            CharSequence a10 = a(charSequence);
            boolean z10 = false;
            if (this.f١٦٧٢٤b) {
                this.f١٦٧٢٤b = false;
                this.f١٦٧٢٣a.append("  ");
            }
            if (a10.length() > 0 && a10.charAt(i11 - 1) == '\n') {
                z10 = true;
            }
            this.f١٦٧٢٤b = z10;
            this.f١٦٧٢٣a.append(a10, i10, i11);
            return this;
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
