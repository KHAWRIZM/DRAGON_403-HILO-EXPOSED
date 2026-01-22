package j;

import android.app.Activity;
import android.graphics.Point;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.amazonaws.services.s3.internal.Constants;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d {
    public static g1.f C;
    public static a D;
    public boolean A;

    /* renamed from: B, reason: collision with root package name */
    public Integer f١٤٩٨٥B;

    /* renamed from: a, reason: collision with root package name */
    public v f١٤٩٨٦a;

    /* renamed from: b, reason: collision with root package name */
    public final Activity f١٤٩٨٧b;

    /* renamed from: g, reason: collision with root package name */
    public k.a f١٤٩٩٢g;

    /* renamed from: h, reason: collision with root package name */
    public g1.b f١٤٩٩٣h;

    /* renamed from: i, reason: collision with root package name */
    public final float f١٤٩٩٤i;

    /* renamed from: j, reason: collision with root package name */
    public final FrameLayout f١٤٩٩٥j;

    /* renamed from: k, reason: collision with root package name */
    public final FrameLayout f١٤٩٩٦k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f١٤٩٩٧l;

    /* renamed from: m, reason: collision with root package name */
    public FrameLayout f١٤٩٩٨m;

    /* renamed from: n, reason: collision with root package name */
    public String f١٤٩٩٩n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f١٥٠٠٠o;

    /* renamed from: q, reason: collision with root package name */
    public String f١٥٠٠٢q;

    /* renamed from: t, reason: collision with root package name */
    public boolean f١٥٠٠٥t;

    /* renamed from: y, reason: collision with root package name */
    public String f١٥٠١٠y;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f١٤٩٨٨c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final SparseArray f١٤٩٨٩d = new SparseArray(100);

    /* renamed from: e, reason: collision with root package name */
    public int f١٤٩٩٠e = 0;

    /* renamed from: f, reason: collision with root package name */
    public final SparseArray f١٤٩٩١f = new SparseArray(100);

    /* renamed from: p, reason: collision with root package name */
    public final int f١٥٠٠١p = 1;

    /* renamed from: r, reason: collision with root package name */
    public final String f١٥٠٠٣r = ".zip";

    /* renamed from: s, reason: collision with root package name */
    public String f١٥٠٠٤s = "";

    /* renamed from: u, reason: collision with root package name */
    public boolean f١٥٠٠٦u = true;

    /* renamed from: v, reason: collision with root package name */
    public boolean f١٥٠٠٧v = true;

    /* renamed from: w, reason: collision with root package name */
    public boolean f١٥٠٠٨w = true;

    /* renamed from: x, reason: collision with root package name */
    public final String f١٥٠٠٩x = "zh";

    /* renamed from: z, reason: collision with root package name */
    public final int f١٥٠١١z = -1;

    public d(Activity activity) {
        this.f١٤٩٨٧b = activity;
        v vVar = new v(activity);
        this.f١٤٩٨٦a = vVar;
        g1.f fVar = C;
        if (fVar != null && D == null) {
            a aVar = new a(fVar);
            D = aVar;
            vVar.f١٥٠٥٢f = aVar;
            tech.sud.runtime.a.c cVar = vVar.f١٥٠٤٩c;
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
        v vVar2 = this.f١٤٩٨٦a;
        u uVar = vVar2.f١٥٠٤٨b;
        uVar.f١٥٠٤٠a = this.f١٥٠٠٠o;
        uVar.f١٥٠٤١b = true;
        uVar.f١٥٠٤٤e = true;
        uVar.f١٥٠٤٥f = true;
        vVar2.b("RTObjCreate", new s(this));
        this.f١٤٩٨٦a.b("RTObjMsg", new c(this));
        this.f١٤٩٨٦a.b("RTObjDestroy", new e(this));
        this.f١٤٩٨٦a.b("RTGlobalCallback", new i(this));
        this.f١٤٩٨٦a.b("exitRuntime", new m(this));
        this.f١٤٩٨٦a.b("@enableConsole", new q(this));
        this.f١٤٩٨٦a.b("@onState", new w(this));
        this.f١٤٩٨٦a.b("GameViewOnAttachedToWindowReload", new l(this));
        this.f١٤٩٨٦a.b("GameViewOnSurfaceCreated", new p(this));
        this.f١٤٩٨٦a.b("GameViewOnSurfaceDestroyed", new y(this));
        this.f١٤٩٨٦a.b("onGameANRDetected", new b(this));
        d("Button", new h());
        d("BannerAd", new l.b());
        d("RewardedVideoAd", new l.g());
        d("InterstitialAd", new l.e());
        d("UpdateManager", new m.a());
        d("GetLocation@", new j(n.a.class));
        d("Authorize@", new j(p.j.class));
        d("Login@", new j(p.g.class));
        d("CheckSession@", new j(p.k.class));
        d("GetSetting@", new j(p.c.class));
        d("GetUserInfo@", new j(p.e.class));
        d("UserInfoButtonTap@", new j(p.d.class));
        d("NavigateToMiniProgram@", new j(p.i.class));
        d("CheckIsUserAdvisedToRest@", new j(p.h.class));
        d("GetRunData@", new j(p.b.class));
        d("AddCard@", new j(p.f.class));
        d("OpenCard@", new j(p.l.class));
        d("FeedbackButtonTap@", new j(p.m.class));
        d("GameClubButtonTap@", new j(p.o.class));
        d("OpenCustomerServiceConversation@", new j(p.n.class));
        d("OpenSettingButtonTap@", new j(p.p.class));
        d("OpenSetting@", new j(p.a.class));
        d("RequestPayment@", new j(q.a.class));
        d("GetShareInfo@", new j(r.a.class));
        d("HideShareMenu@", new j(r.c.class));
        d("ShareAppMessage@", new j(r.b.class));
        d("ShowShareMenu@", new j(r.d.class));
        d("UpdateShareMenu@", new j(r.e.class));
        d("ShowLoading@", new j(s.f.class));
        d("HideLoading@", new j(s.b.class));
        d("ShowToast@", new j(s.a.class));
        d("HideToast@", new j(s.d.class));
        d("ShowModal@", new j(s.g.class));
        d("ShowActionSheet@", new j(s.e.class));
        d("SetMenuStyle@", new j(s.c.class));
        activity.getWindowManager().getDefaultDisplay().getRealSize(new Point());
        this.f١٤٩٩٤i = activity.getResources().getDisplayMetrics().density;
        this.f١٤٩٩٥j = new FrameLayout(activity);
        this.f١٤٩٩٦k = new FrameLayout(activity);
        this.f١٤٩٩٧l = false;
    }

    public static void b(d dVar, int i10, String str, JSONObject jSONObject) {
        t tVar = (t) dVar.f١٤٩٨٩d.get(i10);
        String str2 = Constants.NULL_VERSION_ID;
        if (tVar == null) {
            Integer valueOf = Integer.valueOf(i10);
            if (jSONObject != null) {
                str2 = jSONObject.toString();
            }
            o.b.c("WXGame", String.format("objectMsg: obj %d not found, cmd %s, data %s", valueOf, str, str2));
            return;
        }
        if (!tVar.c(str, jSONObject)) {
            Integer valueOf2 = Integer.valueOf(i10);
            if (jSONObject != null) {
                str2 = jSONObject.toString();
            }
            o.b.c("WXGame", String.format("objectMsg: cmd not processed obj %d cmd %s, data %s", valueOf2, str, str2));
        }
    }

    public static void c(d dVar, String str, int i10, JSONObject jSONObject) {
        Object obj = dVar.f١٤٩٨٩d.get(i10);
        String str2 = Constants.NULL_VERSION_ID;
        if (obj != null) {
            Integer valueOf = Integer.valueOf(i10);
            if (jSONObject != null) {
                str2 = jSONObject.toString();
            }
            o.b.c("WXGame", String.format("objectCreate: \"%s\" dup obj %d data %s", str, valueOf, str2));
            return;
        }
        r rVar = (r) dVar.f١٤٩٨٨c.get(str);
        if (rVar == null) {
            Integer valueOf2 = Integer.valueOf(i10);
            if (jSONObject != null) {
                str2 = jSONObject.toString();
            }
            o.b.c("WXGame", String.format("objectCreate: \"%s\" not found for obj %d data %s", str, valueOf2, str2));
            return;
        }
        t a10 = rVar.a(jSONObject);
        if (a10 == null) {
            Integer valueOf3 = Integer.valueOf(i10);
            if (jSONObject != null) {
                str2 = jSONObject.toString();
            }
            o.b.c("WXGame", String.format("objectCreate: \"%s\" failed for obj %d data %s", str, valueOf3, str2));
            return;
        }
        a10.f١٥٠٣٩b = dVar;
        a10.f١٥٠٣٨a = i10;
        dVar.f١٤٩٨٩d.put(i10, a10);
        try {
            a10.b(jSONObject);
            a10.a();
        } catch (Exception e10) {
            o.b.c("WXGame", "Dispatch:" + e10.getMessage());
            a10.e();
        }
    }

    public final void a() {
        v vVar = this.f١٤٩٨٦a;
        if (vVar != null) {
            tech.sud.runtime.a.c cVar = vVar.f١٥٠٤٩c;
            if (cVar != null) {
                cVar.a(true);
            }
            this.f١٤٩٨٦a = null;
            ViewParent parent = this.f١٤٩٩٥j.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f١٤٩٩٥j);
            } else {
                this.f١٤٩٩٥j.removeAllViews();
            }
        }
    }

    public final void d(String str, r rVar) {
        if (this.f١٤٩٨٨c.get(str) != null) {
            o.b.c("WXGame", "registerFactory: \"" + str + "\" dup factory");
            return;
        }
        this.f١٤٩٨٨c.put(str, rVar);
    }
}
