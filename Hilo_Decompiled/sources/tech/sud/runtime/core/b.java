package tech.sud.runtime.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tech.sud.runtime.a.a;
import tech.sud.runtime.component.file.FileOperation;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class b {
    private static b c;
    public tech.sud.runtime.core.a a;
    private final Activity d;
    private final a e;
    private final tech.sud.runtime.component.b.a f;
    private tech.sud.runtime.component.c.f g;
    private tech.sud.runtime.component.c.e h;
    private tech.sud.runtime.component.c.a i;
    private final tech.sud.runtime.component.d.a j;
    private tech.sud.runtime.component.c.i k;
    private final g l;
    private String m;
    private tech.sud.runtime.component.f.a n;
    private boolean p;
    public boolean b = false;
    private int o = 0;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class a implements Application.ActivityLifecycleCallbacks {
        b a;
        boolean b;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            final Application application = activity.getApplication();
            b bVar = this.a;
            if (bVar != null && activity.equals(bVar.d)) {
                this.a.a(new Runnable() { // from class: tech.sud.runtime.core.b.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b bVar2 = a.this.a;
                        if (bVar2 != null && !bVar2.b) {
                            bVar2.a();
                            a.this.a = null;
                        }
                        try {
                            application.unregisterActivityLifecycleCallbacks(this);
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            b bVar = this.a;
            if (bVar != null && activity.equals(bVar.d)) {
                this.a.a(new Runnable() { // from class: tech.sud.runtime.core.b.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        tech.sud.runtime.component.h.f.e("SudNative", "J: onActivityPaused");
                        a aVar = a.this;
                        b bVar2 = aVar.a;
                        if (bVar2 != null && !aVar.b) {
                            bVar2.g();
                        }
                        a.this.b = true;
                    }
                });
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            b bVar = this.a;
            if (bVar != null && activity.equals(bVar.d)) {
                this.a.a(new Runnable() { // from class: tech.sud.runtime.core.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        tech.sud.runtime.component.h.f.e("SudNative", "J: onActivityResumed");
                        a aVar = a.this;
                        b bVar2 = aVar.a;
                        if (bVar2 != null && aVar.b) {
                            bVar2.f();
                        }
                        a.this.b = false;
                    }
                });
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        private a(b bVar) {
            this.b = false;
            this.a = bVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01fe A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x020a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0221 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0231 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x023d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0150 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0185 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x018e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01f4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(Activity activity, g gVar, HashMap<String, String> hashMap, tech.sud.runtime.component.d.a aVar) {
        int i;
        int i2;
        int i3;
        b bVar = c;
        if (bVar != null && !bVar.b) {
            tech.sud.runtime.component.h.f.e("SudNative", "J: NativePlayer _currentNativePlayer != null");
            c.a();
        }
        c = this;
        this.l = gVar;
        this.d = activity;
        this.m = activity.getFilesDir().getAbsolutePath();
        String str = "";
        Integer num = null;
        boolean z = false;
        int i4 = 0;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        int i5 = 0;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = true;
        boolean z10 = false;
        boolean z11 = false;
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            key.getClass();
            char c2 = 65535;
            switch (key.hashCode()) {
                case -1932342228:
                    if (key.equals("fps.logTime")) {
                        c2 = 0;
                    }
                    switch (c2) {
                        case 0:
                            i4 = a(entry.getValue());
                            break;
                        case 1:
                            z2 = b(entry.getValue());
                            break;
                        case 2:
                            if (z3) {
                                break;
                            } else {
                                i5 = a(entry.getValue()) & 15;
                                break;
                            }
                        case 3:
                            z8 = b(entry.getValue());
                            this.l.a(key, entry.getValue());
                            break;
                        case 4:
                            z7 = b(entry.getValue());
                            break;
                        case 5:
                            this.m = entry.getValue();
                            break;
                        case 6:
                            try {
                                num = Integer.valueOf(Integer.parseInt(entry.getValue()));
                                break;
                            } catch (Exception e) {
                                e.printStackTrace();
                                break;
                            }
                        case 7:
                            this.p = b(entry.getValue());
                            break;
                        case '\b':
                            z6 = b(entry.getValue());
                            z4 = true;
                            break;
                        case '\t':
                            z5 = b(entry.getValue());
                            if (z4) {
                                break;
                            } else {
                                z6 = z5;
                                break;
                            }
                        case '\n':
                            z11 = "true".equals(entry.getValue());
                            break;
                        case 11:
                            z9 = b(entry.getValue());
                            break;
                        case '\f':
                            z = b(entry.getValue());
                            break;
                        case '\r':
                            str = entry.getValue();
                            break;
                        case 14:
                            a(entry.getValue());
                            this.l.a(key, entry.getValue());
                            z3 = true;
                            i5 = 3;
                            break;
                        case 15:
                            z10 = !b(entry.getValue());
                            break;
                        default:
                            this.l.a(key, entry.getValue());
                            break;
                    }
                case -1825565413:
                    if (key.equals("activityLifecycle")) {
                        c2 = 1;
                    }
                    switch (c2) {
                    }
                    break;
                case -1726194350:
                    if (key.equals("transparent")) {
                        c2 = 2;
                    }
                    switch (c2) {
                    }
                    break;
                case -1435722802:
                    if (key.equals("jsConsole")) {
                        c2 = 3;
                    }
                    switch (c2) {
                    }
                    break;
                case -985719245:
                    if (key.equals("useCutout")) {
                        c2 = 4;
                    }
                    switch (c2) {
                    }
                    break;
                case -553716025:
                    if (key.equals("cachePath")) {
                        c2 = 5;
                    }
                    switch (c2) {
                    }
                    break;
                case -508394459:
                    if (key.equals("keyboardBottomOffset")) {
                        c2 = 6;
                    }
                    switch (c2) {
                    }
                    break;
                case -122292147:
                    if (key.equals("enableOrientation")) {
                        c2 = 7;
                    }
                    switch (c2) {
                    }
                    break;
                case 110066619:
                    if (key.equals("fullscreen")) {
                        c2 = '\b';
                    }
                    switch (c2) {
                    }
                    break;
                case 316244734:
                    if (key.equals("immersiveMode")) {
                        c2 = '\t';
                    }
                    switch (c2) {
                    }
                    break;
                case 384187306:
                    if (key.equals("disableAudioFocus")) {
                        c2 = '\n';
                    }
                    switch (c2) {
                    }
                    break;
                case 687923627:
                    if (key.equals("jsConsole.autoCreate")) {
                        c2 = 11;
                    }
                    switch (c2) {
                    }
                    break;
                case 1332556002:
                    if (key.equals("fps.show")) {
                        c2 = '\f';
                    }
                    switch (c2) {
                    }
                    break;
                case 1874680614:
                    if (key.equals("sud.frameworkVersion")) {
                        c2 = '\r';
                    }
                    switch (c2) {
                    }
                    break;
                case 1890175481:
                    if (key.equals("runtime.mode")) {
                        c2 = 14;
                    }
                    switch (c2) {
                    }
                    break;
                case 1946601023:
                    if (key.equals("sysUIVis")) {
                        c2 = 15;
                    }
                    switch (c2) {
                    }
                    break;
                default:
                    switch (c2) {
                    }
                    break;
            }
        }
        if (z2) {
            a aVar2 = new a();
            this.e = aVar2;
            activity.getApplication().registerActivityLifecycleCallbacks(aVar2);
        } else {
            this.e = null;
        }
        Context d = d();
        String packageName = d.getPackageName();
        this.l.a("app.id", packageName);
        try {
            PackageManager packageManager = d.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            this.l.a("app.verName", packageInfo.versionName);
            this.l.a("app.verCode", Integer.toString(packageInfo.versionCode));
            this.l.a("app.name", packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, 0)).toString());
        } catch (PackageManager.NameNotFoundException unused) {
        }
        this.j = aVar;
        if (!aVar.a("@enableConsole")) {
            aVar.a("@enableConsole", new a.InterfaceC٠٠٥٦a() { // from class: tech.sud.runtime.core.b.1
                @Override // tech.sud.runtime.a.a.InterfaceC٠٠٥٦a
                public void a(String str2) {
                    tech.sud.runtime.core.a aVar3;
                    b bVar2 = b.this;
                    if (str2.equals("true")) {
                        aVar3 = b.this.a;
                    } else {
                        aVar3 = null;
                    }
                    bVar2.a(aVar3);
                }
            });
        }
        e();
        if (z5) {
            i = 16;
        } else {
            i = 0;
        }
        int i6 = i5 | i;
        if (z6) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        int i7 = i6 | i2;
        if (z7) {
            i3 = 64;
        } else {
            i3 = 0;
        }
        int i8 = i7 | i3;
        int i9 = z10 ? 128 : 0;
        tech.sud.runtime.component.h.f.b("SudNative", "NativePlayer AdapterLayout");
        this.a = new tech.sud.runtime.core.a(activity, i8 | i9, this.l, z, i4, str, aVar, num);
        this.f = new tech.sud.runtime.component.b.a(activity);
        this.g = new tech.sud.runtime.component.c.f(this.l, activity);
        if (z8 && z9) {
            a(this.a);
        }
        this.h = new tech.sud.runtime.component.c.e(activity);
        this.k = new tech.sud.runtime.component.c.i(this);
        if (!z11) {
            this.i = new tech.sud.runtime.component.c.a(this.l, activity);
        }
    }

    private void j() {
        if (c == null) {
            return;
        }
        tech.sud.runtime.component.h.f.b("SudNative", "J: Begin destroy NativePlayer");
        k();
        this.a.h();
        this.j.a();
        tech.sud.runtime.component.f.a aVar = this.n;
        if (aVar != null) {
            aVar.c();
            this.n = null;
        }
        tech.sud.runtime.component.c.e eVar = this.h;
        if (eVar != null) {
            eVar.a(this.d);
            this.h = null;
        }
        tech.sud.runtime.component.c.f fVar = this.g;
        if (fVar != null) {
            fVar.a(this.d);
            this.g = null;
        }
        tech.sud.runtime.component.c.i iVar = this.k;
        if (iVar != null) {
            iVar.a();
            this.k = null;
        }
        tech.sud.runtime.component.c.a aVar2 = this.i;
        if (aVar2 != null) {
            aVar2.a();
            this.i = null;
        }
        this.l.a();
        try {
            if (this.e != null) {
                this.d.getApplication().unregisterActivityLifecycleCallbacks(this.e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this == c) {
            c = null;
        }
        tech.sud.runtime.component.h.f.b("SudNative", "J: End destroy NativePlayer");
        ViewParent parent = this.a.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.a);
        } else {
            this.a.removeAllViews();
        }
    }

    private void k() {
        tech.sud.runtime.component.b.a aVar = this.f;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        k();
    }

    public Object emit(final int i, final int i2, final int i3, final String str) {
        if (i != 1) {
            if (i != 18) {
                if (i != 26) {
                    switch (i) {
                        case 29:
                            return tech.sud.runtime.component.c.c.a((Context) this.d);
                        case 30:
                            if (!tech.sud.runtime.component.c.c.a((Context) this.d, str)) {
                                return null;
                            }
                            return Boolean.TRUE;
                        case 31:
                            return tech.sud.runtime.component.c.c.b(this.d);
                        default:
                            switch (i) {
                                case 33:
                                    return "" + ((int) (tech.sud.runtime.component.c.c.a(this.d) * 10000.0f));
                                case 34:
                                    if (!this.h.a()) {
                                        return null;
                                    }
                                    return Boolean.TRUE;
                                case 35:
                                    return "" + tech.sud.runtime.component.c.f.b(this.d);
                                default:
                                    switch (i) {
                                        case 37:
                                            if (i2 != 1) {
                                                return null;
                                            }
                                            return new tech.sud.runtime.component.g.g(this.l);
                                        case 38:
                                            return this.l.b().b(str);
                                        case 39:
                                            this.l.b().a(i2);
                                            return null;
                                    }
                            }
                    }
                }
                this.a.e().a().a(i2);
                return null;
            }
            this.a.c().a(true);
        } else {
            this.l.b().a();
        }
        a(new Runnable() { // from class: tech.sud.runtime.core.b.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i4 = i;
                    if (i4 == 27) {
                        tech.sud.runtime.component.c.c.a(b.this.d, i2 != 0);
                        return;
                    }
                    if (i4 == 28) {
                        tech.sud.runtime.component.c.c.a((Context) b.this.d, i2);
                        return;
                    }
                    if (i4 != 32) {
                        switch (i4) {
                            case 1:
                                b.this.l();
                                return;
                            case 2:
                                if (b.this.f != null) {
                                    b.this.f.a(str);
                                    return;
                                }
                                return;
                            case 3:
                                if (b.this.n != null) {
                                    b.this.n.a(str);
                                    return;
                                }
                                return;
                            case 4:
                                if (b.this.g != null) {
                                    b.this.g.a();
                                    return;
                                }
                                return;
                            case 5:
                                tech.sud.runtime.component.a.a i5 = b.this.a.i();
                                if (i5 != null) {
                                    i5.a(true);
                                    return;
                                }
                                return;
                            case 6:
                                JSONArray jSONArray = new JSONArray(str);
                                b.this.j.a(jSONArray.opt(0).toString(), jSONArray.opt(1).toString());
                                return;
                            case 7:
                                tech.sud.runtime.component.a.a i6 = b.this.a.i();
                                if (i6 != null) {
                                    i6.a(i2, str);
                                    return;
                                }
                                return;
                            case 8:
                                tech.sud.runtime.component.a.a i7 = b.this.a.i();
                                if (i7 != null) {
                                    i7.a(i2, i3, str);
                                    return;
                                }
                                return;
                            case 9:
                                if (b.this.k != null) {
                                    b.this.k.a(i2, i3);
                                    return;
                                }
                                return;
                            case 10:
                                if (b.this.k != null) {
                                    b.this.k.a(i2);
                                    return;
                                }
                                return;
                            case 11:
                                b bVar = b.this;
                                if (bVar.b) {
                                    return;
                                }
                                bVar.a.a().a(b.b(), i2);
                                return;
                            case 12:
                                b bVar2 = b.this;
                                if (bVar2.b) {
                                    return;
                                }
                                bVar2.a.a().a(i2);
                                return;
                            case 13:
                                b.this.a.a().a(i2, str);
                                return;
                            case 14:
                                b.this.a.a().b(i2);
                                return;
                            case 15:
                                b.this.a.a().c(i2);
                                return;
                            case 16:
                                b.this.a.a().a(i2, i3);
                                return;
                            case 17:
                                b.this.a.a().a(i2, i3 * 0.01f);
                                return;
                            case 18:
                                b.this.a.c().a(false);
                                JSONArray jSONArray2 = new JSONArray(str);
                                b.this.a.b().a(jSONArray2.opt(0).toString(), i2, (float) jSONArray2.optDouble(1), (float) jSONArray2.optDouble(2), jSONArray2.optBoolean(3));
                                return;
                            case 19:
                                b.this.a.b().b();
                                b.this.a(new Runnable() { // from class: tech.sud.runtime.core.b.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.a.c().b();
                                    }
                                }, 500L);
                                return;
                            case 20:
                                b.this.a.b().a(str, i2);
                                return;
                            case 21:
                                b.this.a.b().a(str);
                                return;
                            case 22:
                                b.this.a.d().a(str);
                                return;
                            case 23:
                                b.this.a.d().b(str);
                                return;
                            case 24:
                                if (b.this.p) {
                                    tech.sud.runtime.component.c.c.a(b.this.d, i2, i3);
                                    return;
                                }
                                return;
                            case 25:
                                if (b.this.p) {
                                    tech.sud.runtime.component.c.c.a(b.this.d, str);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                    tech.sud.runtime.component.c.c.a(b.this.d, i2 * 1.0E-4f);
                } catch (Exception e) {
                    tech.sud.runtime.component.h.f.e("SudNative", "J: Async emit get: " + e.getMessage());
                }
            }
        });
        return null;
    }

    public String[] i() {
        return new String[]{"1.2.8", JNIShell.version(0), JNIShell.version(1)};
    }

    public static Context b() {
        b bVar = c;
        if (bVar == null) {
            return null;
        }
        return bVar.d;
    }

    public void a() {
        this.b = true;
        j();
    }

    public Activity c() {
        return this.d;
    }

    public Context d() {
        return c();
    }

    public void e() {
        this.l.a(this, this.d.getResources().getAssets(), this.m);
    }

    public void f() {
        int i;
        if (c != this || this.b || (i = this.o) == 0) {
            return;
        }
        int i2 = i - 1;
        this.o = i2;
        if (i2 == 0) {
            this.a.f();
            tech.sud.runtime.component.c.i iVar = this.k;
            if (iVar != null) {
                iVar.c();
            }
            tech.sud.runtime.component.c.a aVar = this.i;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void g() {
        if (c != this || this.b) {
            return;
        }
        if (this.o == 0) {
            this.a.g();
            tech.sud.runtime.component.c.i iVar = this.k;
            if (iVar != null) {
                iVar.b();
            }
            tech.sud.runtime.component.c.a aVar = this.i;
            if (aVar != null) {
                aVar.b();
            }
        }
        this.o++;
    }

    public void h() {
        FileOperation.a(new File(this.m + "/games/"));
    }

    public static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static boolean b(String str) {
        if (str.compareToIgnoreCase("YES") == 0 || str.compareToIgnoreCase("TRUE") == 0) {
            return true;
        }
        return Integer.parseInt(str) != 0;
    }

    public void a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        tech.sud.runtime.core.a aVar = this.a;
        if (aVar == null) {
            this.d.runOnUiThread(runnable);
        } else {
            aVar.post(runnable);
        }
    }

    public void b(String str, String str2) {
        if ("WXAudioInterruption_onChange".equals(str)) {
            this.l.b(13, MessageService.MSG_DB_NOTIFY_REACHED.equals(str2) ? 1 : 0);
        }
    }

    public void a(Runnable runnable, long j) {
        if (j == 0) {
            a(runnable);
        } else {
            this.a.postDelayed(runnable, j);
        }
    }

    public void a(FrameLayout frameLayout) {
        tech.sud.runtime.component.f.a aVar = this.n;
        if (aVar == null && frameLayout != null) {
            tech.sud.runtime.component.f.a aVar2 = new tech.sud.runtime.component.f.a(this.d, frameLayout);
            this.n = aVar2;
            aVar2.b();
        } else {
            if (aVar == null || frameLayout != null) {
                return;
            }
            aVar.b();
            ((FrameLayout) this.n.getParent()).removeView(this.n);
            this.n.c();
            this.n = null;
        }
    }

    public void a(String str, String str2) {
        tech.sud.runtime.component.d.a aVar = this.j;
        if (aVar != null) {
            aVar.b(str, str2);
        }
    }

    public void a(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.taobao.agoo.a.a.b.JSON_CMD, str);
            if (jSONObject != null) {
                jSONObject2.put("data", jSONObject);
            }
            a("RTGlobalEvent", jSONObject2.toString());
        } catch (JSONException unused) {
        }
    }
}
