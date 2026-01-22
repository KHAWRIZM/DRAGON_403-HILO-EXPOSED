package x9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.login.LoginLogger;
import com.hjq.permissions.permission.base.IPermission;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class e implements y9.b {

    /* renamed from: a, reason: collision with root package name */
    private final Object f١٨٩٩٩a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private boolean f١٩٠٠٠b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٩٠٠١c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f١٩٠٠٢d;

    /* renamed from: e, reason: collision with root package name */
    private final y9.c f١٩٠٠٣e;

    /* renamed from: f, reason: collision with root package name */
    private b f١٩٠٠٤f;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(y9.c cVar) {
        this.f١٩٠٠٣e = cVar;
    }

    private void b() {
        this.f١٩٠٠٢d = true;
        this.f١٩٠٠٣e.d();
    }

    private Activity c() {
        return this.f١٩٠٠٣e.getActivity();
    }

    private b d() {
        return this.f١٩٠٠٤f;
    }

    private boolean i() {
        if (this.f١٩٠٠٣e.isAdded() && !this.f١٩٠٠٣e.isRemoving()) {
            return false;
        }
        return true;
    }

    protected void a() {
        ka.d.a(this.f١٨٩٩٩a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e() {
        Bundle arguments = this.f١٩٠٠٣e.getArguments();
        if (arguments == null) {
            return 0;
        }
        return arguments.getInt(LoginLogger.EVENT_EXTRAS_REQUEST_CODE);
    }

    protected List f() {
        ArrayList parcelableArrayList;
        Bundle arguments = this.f١٩٠٠٣e.getArguments();
        if (arguments == null) {
            return null;
        }
        if (ka.h.f()) {
            parcelableArrayList = arguments.getParcelableArrayList("request_permissions", IPermission.class);
            return parcelableArrayList;
        }
        return arguments.getParcelableArrayList("request_permissions");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ja.a g() {
        return this.f١٩٠٠٣e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        if (i() || ka.g.o(c())) {
            return;
        }
        b d10 = d();
        r(null);
        if (d10 != null) {
            d10.a();
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        if (ka.g.o(c())) {
            return;
        }
        p(new Runnable() { // from class: x9.d
            @Override // java.lang.Runnable
            public final void run() {
                e.this.h();
            }
        }, ka.a.f(r0, f()));
    }

    public /* synthetic */ void k(int i10, int i11, Intent intent) {
        y9.a.a(this, i10, i11, intent);
    }

    public void l() {
        a();
        b d10 = d();
        if (d10 != null) {
            d10.b();
            r(null);
        }
        if (this.f١٩٠٠٢d) {
            return;
        }
        Activity c10 = c();
        if (ka.g.o(c10)) {
            return;
        }
        ca.b.d(c10);
    }

    public /* synthetic */ void m(int i10, String[] strArr, int[] iArr) {
        y9.a.b(this, i10, strArr, iArr);
    }

    public void n() {
        int e10;
        List f10;
        if (!this.f١٩٠٠٠b) {
            this.f١٩٠٠٣e.d();
            return;
        }
        if (this.f١٩٠٠١c) {
            return;
        }
        this.f١٩٠٠١c = true;
        Activity c10 = c();
        if (!ka.g.o(c10) && (e10 = e()) > 0 && (f10 = f()) != null && !f10.isEmpty()) {
            s(c10, f10, e10);
            b d10 = d();
            if (d10 == null) {
                return;
            }
            d10.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(String[] strArr, int i10) {
        try {
            this.f١٩٠٠٣e.requestPermissions(strArr, i10);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Runnable runnable, long j10) {
        ka.d.c(runnable, this.f١٨٩٩٩a, j10);
    }

    public void q(boolean z10) {
        this.f١٩٠٠٠b = z10;
    }

    public void r(b bVar) {
        this.f١٩٠٠٤f = bVar;
    }

    protected abstract void s(Activity activity, List list, int i10);
}
