package qa;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.internal.security.CertificateUtil;
import com.qiahao.base_common.network.model.ErrorCode;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class f implements g {

    /* renamed from: a, reason: collision with root package name */
    private String f١٧٢٥٤a;

    /* renamed from: b, reason: collision with root package name */
    private final ThreadLocal f١٧٢٥٥b = new ThreadLocal();

    /* renamed from: c, reason: collision with root package name */
    private final ThreadLocal f١٧٢٥٦c = new ThreadLocal();

    /* renamed from: d, reason: collision with root package name */
    private final h f١٧٢٥٧d = new h();

    public f() {
        m("PRETTYLOGGER");
    }

    private String d(String str, Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            return String.format(str, objArr);
        }
        return str;
    }

    private String h(String str) {
        if (!b.c(str) && !b.a(this.f١٧٢٥٤a, str)) {
            return this.f١٧٢٥٤a + "-" + str;
        }
        return this.f١٧٢٥٤a;
    }

    private int i() {
        Integer num = (Integer) this.f١٧٢٥٦c.get();
        int c10 = this.f١٧٢٥٧d.c();
        if (num != null) {
            this.f١٧٢٥٦c.remove();
            c10 = num.intValue();
        }
        if (c10 >= 0) {
            return c10;
        }
        throw new IllegalStateException("methodCount cannot be negative");
    }

    private String j(String str) {
        return str.substring(str.lastIndexOf(InstructionFileId.DOT) + 1);
    }

    private int k(StackTraceElement[] stackTraceElementArr) {
        for (int i10 = 3; i10 < stackTraceElementArr.length; i10++) {
            String className = stackTraceElementArr[i10].getClassName();
            if (!className.equals(f.class.getName()) && !className.equals(e.class.getName())) {
                return i10 - 1;
            }
        }
        return -1;
    }

    private String l() {
        String str = (String) this.f١٧٢٥٥b.get();
        if (str != null) {
            this.f١٧٢٥٥b.remove();
            return str;
        }
        return this.f١٧٢٥٤a;
    }

    private synchronized void o(int i10, Throwable th, String str, Object... objArr) {
        if (this.f١٧٢٥٧d.b() == d.NONE) {
            return;
        }
        n(i10, l(), d(str, objArr), th);
    }

    private void p(int i10, String str) {
        q(i10, str, "╚════════════════════════════════════════════════════════════════════════════════════════");
    }

    private void q(int i10, String str, String str2) {
        String h10 = h(str);
        if (i10 != 2) {
            if (i10 != 4) {
                if (i10 != 5) {
                    if (i10 != 6) {
                        if (i10 != 7) {
                            this.f١٧٢٥٧d.a().d(h10, str2);
                            return;
                        } else {
                            this.f١٧٢٥٧d.a().b(h10, str2);
                            return;
                        }
                    }
                    this.f١٧٢٥٧d.a().e(h10, str2);
                    return;
                }
                this.f١٧٢٥٧d.a().w(h10, str2);
                return;
            }
            this.f١٧٢٥٧d.a().i(h10, str2);
            return;
        }
        this.f١٧٢٥٧d.a().a(h10, str2);
    }

    private void r(int i10, String str, String str2) {
        for (String str3 : str2.split(System.getProperty("line.separator"))) {
            q(i10, str, "║ " + str3);
        }
    }

    private void s(int i10, String str) {
        q(i10, str, "╟────────────────────────────────────────────────────────────────────────────────────────");
    }

    private void t(int i10, String str, int i11) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (this.f١٧٢٥٧d.e()) {
            q(i10, str, "║ Thread: " + Thread.currentThread().getName());
            s(i10, str);
        }
        int k10 = k(stackTrace) + this.f١٧٢٥٧d.d();
        if (i11 + k10 > stackTrace.length) {
            i11 = (stackTrace.length - k10) - 1;
        }
        String str2 = "";
        while (i11 > 0) {
            int i12 = i11 + k10;
            if (i12 < stackTrace.length) {
                str2 = str2 + "   ";
                q(i10, str, "║ " + str2 + j(stackTrace[i12].getClassName()) + InstructionFileId.DOT + stackTrace[i12].getMethodName() + "  (" + stackTrace[i12].getFileName() + CertificateUtil.DELIMITER + stackTrace[i12].getLineNumber() + ")");
            }
            i11--;
        }
    }

    private void u(int i10, String str) {
        q(i10, str, "╔════════════════════════════════════════════════════════════════════════════════════════");
    }

    @Override // qa.g
    public void a(String str) {
        if (b.c(str)) {
            e("Empty/Null json content");
            return;
        }
        try {
            String trim = str.trim();
            if (trim.startsWith("{")) {
                e(new JSONObject(trim).toString(2));
            } else if (trim.startsWith("[")) {
                e(new JSONArray(trim).toString(2));
            } else {
                f("Invalid Json", new Object[0]);
            }
        } catch (JSONException unused) {
            f("Invalid Json", new Object[0]);
        }
    }

    @Override // qa.g
    public void b(String str, Object... objArr) {
        o(4, null, str, objArr);
    }

    @Override // qa.g
    public void c(String str, Object... objArr) {
        o(3, null, str, objArr);
    }

    public void e(Object obj) {
        String obj2;
        if (obj.getClass().isArray()) {
            obj2 = Arrays.deepToString((Object[]) obj);
        } else {
            obj2 = obj.toString();
        }
        o(3, null, obj2, new Object[0]);
    }

    public void f(String str, Object... objArr) {
        g(null, str, objArr);
    }

    public void g(Throwable th, String str, Object... objArr) {
        o(6, th, str, objArr);
    }

    public h m(String str) {
        if (str != null) {
            if (str.trim().length() != 0) {
                this.f١٧٢٥٤a = str;
                return this.f١٧٢٥٧d;
            }
            throw new IllegalStateException("tag may not be empty");
        }
        throw new NullPointerException("tag may not be null");
    }

    public synchronized void n(int i10, String str, String str2, Throwable th) {
        try {
            if (this.f١٧٢٥٧d.b() == d.NONE) {
                return;
            }
            if (th != null && str2 != null) {
                str2 = str2 + " : " + b.b(th);
            }
            if (th != null && str2 == null) {
                str2 = b.b(th);
            }
            if (str2 == null) {
                str2 = "No message/exception is set";
            }
            int i11 = i();
            if (b.c(str2)) {
                str2 = "Empty/NULL log message";
            }
            u(i10, str);
            t(i10, str, i11);
            byte[] bytes = str2.getBytes();
            int length = bytes.length;
            if (length <= 4000) {
                if (i11 > 0) {
                    s(i10, str);
                }
                r(i10, str, str2);
                p(i10, str);
                return;
            }
            if (i11 > 0) {
                s(i10, str);
            }
            for (int i12 = 0; i12 < length; i12 += ErrorCode.ERROR_4000) {
                r(i10, str, new String(bytes, i12, Math.min(length - i12, ErrorCode.ERROR_4000)));
            }
            p(i10, str);
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
