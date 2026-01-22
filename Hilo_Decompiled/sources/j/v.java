package j;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.pm.ConfigurationInfo;
import java.util.HashMap;
import tech.sud.runtime.a.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class v {

    /* renamed from: h, reason: collision with root package name */
    public static a f١٥٠٤٦h;

    /* renamed from: a, reason: collision with root package name */
    public final Activity f١٥٠٤٧a;

    /* renamed from: b, reason: collision with root package name */
    public final u f١٥٠٤٨b;

    /* renamed from: c, reason: collision with root package name */
    public tech.sud.runtime.a.c f١٥٠٤٩c;

    /* renamed from: e, reason: collision with root package name */
    public HashMap f١٥٠٥١e = null;

    /* renamed from: f, reason: collision with root package name */
    public a f١٥٠٥٢f = null;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f١٥٠٥٣g = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public boolean f١٥٠٥٠d = false;

    public v(Activity activity) {
        this.f١٥٠٤٧a = activity;
        u uVar = new u();
        this.f١٥٠٤٨b = uVar;
        uVar.f١٥٠٤٠a = true;
        uVar.f١٥٠٤١b = false;
        uVar.f١٥٠٤٢c = activity.getFilesDir().getAbsolutePath();
        uVar.f١٥٠٤٣d = "";
        uVar.f١٥٠٤٤e = false;
        uVar.f١٥٠٤٥f = false;
    }

    public final void a(String str, String str2) {
        if (str.compareTo("runtime.LoadPath") == 0) {
            return;
        }
        if (this.f١٥٠٥١e == null) {
            this.f١٥٠٥١e = new HashMap();
        }
        this.f١٥٠٥١e.put(str, str2);
    }

    public final void b(String str, a.a aVar) {
        if (str.contains("|")) {
            o.b.b("function name (" + str + ") have illegal character");
            return;
        }
        if (this.f١٥٠٥٠d) {
            this.f١٥٠٤٩c.a(str, aVar);
        } else {
            this.f١٥٠٥٣g.put(str, aVar);
        }
    }

    public final boolean c() {
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) this.f١٥٠٤٧a.getSystemService("activity")).getDeviceConfigurationInfo();
        String glEsVersion = deviceConfigurationInfo.getGlEsVersion();
        boolean z10 = false;
        if (glEsVersion != null) {
            try {
                String[] split = glEsVersion.split("\\.");
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                if (parseInt <= 2 && (parseInt != 2 || parseInt2 < 0)) {
                    o.b.b("checkGlEsVersion 第一次检测不通过，走后面逻辑，当前GlES主版本号为：" + parseInt + " 次版本号为：" + parseInt2);
                }
                return true;
            } catch (Exception e10) {
                o.b.b("checkGlEsVersion 第一次判断报了错误，但不影响什么，内容是：" + o.b.a(e10));
            }
        }
        if (deviceConfigurationInfo.reqGlEsVersion >= 131072) {
            z10 = true;
        }
        if (!z10) {
            o.b.b("checkGlEsVersion 检测出不支持，reqGlEsVersion值为：" + deviceConfigurationInfo.reqGlEsVersion);
        }
        return z10;
    }
}
