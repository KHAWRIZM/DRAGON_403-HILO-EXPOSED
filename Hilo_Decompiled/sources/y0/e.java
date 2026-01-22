package y0;

import d.h;
import d.k;
import d.p;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import tech.sud.base.utils.SudStopwatch;
import tech.sud.base.utils.Utils;
import tech.sud.logger.LogUtils;
import u.j;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e implements d1.b {

    /* renamed from: a, reason: collision with root package name */
    public f.a f١٩٠٥٨a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f١٩٠٥٩b;

    /* renamed from: c, reason: collision with root package name */
    public long f١٩٠٦٠c;

    /* renamed from: d, reason: collision with root package name */
    public a f١٩٠٦١d;

    /* renamed from: e, reason: collision with root package name */
    public final q0.c f١٩٠٦٢e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f١٩٠٦٣f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f١٩٠٦٤g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f١٩٠٦٥h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f١٩٠٦٦i;

    /* renamed from: j, reason: collision with root package name */
    public final SudStopwatch f١٩٠٦٧j = new SudStopwatch();

    /* renamed from: k, reason: collision with root package name */
    public final SudStopwatch f١٩٠٦٨k = new SudStopwatch();

    /* renamed from: l, reason: collision with root package name */
    public final SudStopwatch f١٩٠٦٩l = new SudStopwatch();

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f١٩٠٧٠m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    public int f١٩٠٧١n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f١٩٠٧٢o;

    /* renamed from: p, reason: collision with root package name */
    public long f١٩٠٧٣p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f١٩٠٧٤q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f١٩٠٧٥r;

    /* renamed from: s, reason: collision with root package name */
    public Object f١٩٠٧٦s;

    public e(q0.c cVar) {
        this.f١٩٠٦٢e = cVar;
    }

    public final void a() {
        a aVar = this.f١٩٠٦١d;
        if (aVar != null) {
            synchronized (aVar) {
                if (!aVar.f١٩٠٥٢e) {
                    return;
                }
                aVar.f١٩٠٥٢e = false;
                aVar.f١٩٠٥١d.removeCallbacks(aVar.f١٩٠٥٤g);
            }
        }
    }

    public final void b(int i10) {
        boolean z10;
        k kVar;
        h hVar;
        f.a aVar = this.f١٩٠٥٨a;
        if (aVar != null) {
            p pVar = e.d.f١٣٧٢٢e;
            int i11 = 1;
            if (pVar != null && (kVar = pVar.f١٣٥٣٧c) != null && (hVar = kVar.f١٣٥٢١l) != null) {
                z10 = hVar.f١٣٥٠٣a;
            } else {
                z10 = true;
            }
            if (z10) {
                k1.d dVar = new k1.d();
                dVar.f١٥٤٢٠a = e.d.f١٣٧٢٤g;
                dVar.f١٥٤٢١b = this.f١٩٠٧٣p;
                dVar.f١٥٤٢٢c = aVar.f١٤٠٠٠c;
                dVar.f١٥٤٢٣d = this.f١٩٠٧٢o;
                fd.d.a.execute(new fd.c(dVar));
            }
            this.f١٩٠٥٨a.f١٤٠١٢o = Long.valueOf(this.f١٩٠٦٧j.getElapsedTimeInMillis());
            this.f١٩٠٥٨a.f١٤٠١٣p = Integer.valueOf(this.f١٩٠٧١n);
            this.f١٩٠٥٨a.f١٤٠١٤q = Long.valueOf(this.f١٩٠٦٩l.getElapsedTimeInMillis());
            f.a aVar2 = this.f١٩٠٥٨a;
            String str = u.e.f١٨٢١٧e;
            int i12 = u.c.f١٨٢١٥a.f١٨٢١٨a;
            if (i12 == 3 || (i12 != 2 && i12 == 1 && this.f١٩٠٧٥r)) {
                i11 = 0;
            }
            aVar2.f١٤٠١٥r = Integer.valueOf(i11);
            File filesDir = Utils.getApp().getFilesDir();
            this.f١٩٠٥٨a.f١٤٠١٦s = Long.valueOf(filesDir.getTotalSpace());
            this.f١٩٠٥٨a.f١٤٠١٧t = Long.valueOf(filesDir.getUsableSpace());
            c(this.f١٩٠٥٨a);
            if (i10 == 80) {
                f.a aVar3 = this.f١٩٠٥٨a;
                aVar3.f١٤٠٠٢e = -10303;
                aVar3.f١٤٠١٠m = -10303;
                this.f١٩٠٥٨a.f١٤٠٠٣f = "引擎加载超时";
            } else if (i10 >= 85 && i10 < 100) {
                f.a aVar4 = this.f١٩٠٥٨a;
                aVar4.f١٤٠٠٢e = -10304;
                aVar4.f١٤٠١٠m = -10304;
                this.f١٩٠٥٨a.f١٤٠٠٣f = "游戏加载超时";
            } else {
                return;
            }
            f.a aVar5 = this.f١٩٠٥٨a;
            aVar5.f١٣٩٩٨a = "loadGameTimeout";
            aVar5.f١٣٩٩٩b = f.d.a("loadGameTimeout");
            f.a aVar6 = this.f١٩٠٥٨a;
            JSONArray g10 = g();
            if (g10 != null) {
                aVar6.f١٤٠٠٧j.put("loadGame", g10);
            } else {
                aVar6.getClass();
            }
            f.d.b(this.f١٩٠٥٨a);
            f.a aVar7 = this.f١٩٠٥٨a;
            aVar7.f١٣٩٩٨a = "loadGameFinished";
            aVar7.f١٣٩٩٩b = f.d.a("loadGameFinished");
            f.a aVar8 = this.f١٩٠٥٨a;
            aVar8.getClass();
            aVar8.f١٤٠٠٠c = j.b(UUID.randomUUID().toString());
        }
    }

    public final void c(f.a aVar) {
        int i10 = 0;
        if (this.f١٩٠٧٠m.size() != 0 && aVar != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = this.f١٩٠٧٠m;
            int size = arrayList2.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList2.get(i11);
                i11++;
                k1.c cVar = (k1.c) obj;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    k1.c cVar2 = (k1.c) it.next();
                    if (cVar2.f١٥٤١٦a.equals(cVar.f١٥٤١٦a)) {
                        if (cVar.f١٥٤١٧b > cVar2.f١٥٤١٧b) {
                            it.remove();
                        }
                    }
                }
                arrayList.add(cVar);
            }
            this.f١٩٠٧٠m.clear();
            this.f١٩٠٧٠m.addAll(arrayList);
        }
        if (this.f١٩٠٧٠m.size() != 0 && aVar != null) {
            JSONArray jSONArray = new JSONArray();
            ArrayList arrayList3 = this.f١٩٠٧٠m;
            int size2 = arrayList3.size();
            while (i10 < size2) {
                Object obj2 = arrayList3.get(i10);
                i10++;
                k1.c cVar3 = (k1.c) obj2;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", cVar3.f١٥٤١٦a);
                    jSONObject.put("mg_timestamp", cVar3.f١٥٤١٧b);
                    jSONObject.put("app_timestamp", cVar3.f١٥٤١٨c);
                    jSONObject.put("cost_time", cVar3.f١٥٤١٩d);
                    jSONArray.put(jSONObject);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            aVar.f١٤٠٠٧j.put("local_info_transfer", jSONArray);
        }
    }

    public final void d(String str, int i10, JSONObject jSONObject) {
        if (this.f١٩٠٥٩b == null) {
            return;
        }
        try {
            this.f١٩٠٦٨k.stop();
            long elapsedTimeInMillis = this.f١٩٠٦٨k.getElapsedTimeInMillis();
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
            k1.a aVar = new k1.a();
            aVar.f١٥٤٠٧a = str;
            aVar.f١٥٤٠٨b = i10;
            aVar.f١٥٤٠٩c = jSONObject;
            aVar.f١٥٤١٠d = (millis - this.f١٩٠٦٠c) - elapsedTimeInMillis;
            aVar.f١٥٤١١e = elapsedTimeInMillis;
            this.f١٩٠٥٩b.add(aVar);
            this.f١٩٠٦٠c = millis;
            this.f١٩٠٦٨k.reset();
            StringBuilder sb = new StringBuilder("putStatsEvent:");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("step", aVar.f١٥٤٠٧a);
            jSONObject2.put("percent", aVar.f١٥٤٠٨b);
            jSONObject2.put("extra", aVar.f١٥٤٠٩c);
            jSONObject2.put("cost_time", aVar.f١٥٤١٠d);
            jSONObject2.put("pause_cost_time", aVar.f١٥٤١١e);
            sb.append(jSONObject2);
            LogUtils.file("LoadGameStatsManager", sb.toString());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        if (r0.f١٨٢٢١d == r4.f١٩٠٧٦s) goto L٢١;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(boolean z10) {
        k kVar;
        k kVar2;
        if (this.f١٩٠٦٣f && !this.f١٩٠٦٦i && !this.f١٩٠٦٥h) {
            if (this.f١٩٠٧٤q && !this.f١٩٠٦٤g) {
                if (!this.f١٩٠٧٥r) {
                    String str = u.e.f١٨٢١٧e;
                    u.e eVar = u.c.f١٨٢١٥a;
                    if (eVar.f١٨٢١٨a == 3) {
                    }
                }
                LogUtils.file("LoadGameStatsManager", "onLoadGameStateChanged 停止算暂停时间 游戏正常run");
                this.f١٩٠٦٧j.stop();
                this.f١٩٠٦٨k.stop();
                this.f١٩٠٦٩l.start();
                int i10 = 0;
                if (z10) {
                    if (this.f١٩٠٦١d == null) {
                        p pVar = e.d.f١٣٧٢٢e;
                        if (pVar != null && (kVar2 = pVar.f١٣٥٣٧c) != null) {
                            i10 = kVar2.f١٣٥١٩j;
                        }
                        this.f١٩٠٦١d = new a(i10 * 1000, this.f١٩٠٦٢e);
                    }
                    this.f١٩٠٦١d.b();
                    return;
                }
                if (this.f١٩٠٦١d == null) {
                    p pVar2 = e.d.f١٣٧٢٢e;
                    if (pVar2 != null && (kVar = pVar2.f١٣٥٣٧c) != null) {
                        i10 = kVar.f١٣٥١٩j;
                    }
                    a aVar = new a(i10 * 1000, this.f١٩٠٦٢e);
                    this.f١٩٠٦١d = aVar;
                    aVar.b();
                }
                a aVar2 = this.f١٩٠٦١d;
                if (aVar2 != null) {
                    synchronized (aVar2) {
                        if (aVar2.f١٩٠٥٢e) {
                            return;
                        }
                        aVar2.f١٩٠٥٢e = true;
                        aVar2.a();
                        return;
                    }
                }
                return;
            }
            LogUtils.file("LoadGameStatsManager", "onLoadGameStateChanged 开始算暂停时间");
            this.f١٩٠٦٧j.start();
            this.f١٩٠٦٨k.start();
            this.f١٩٠٦٩l.stop();
            if (z10) {
                a();
            } else {
                f();
            }
        }
    }

    public final void f() {
        a aVar = this.f١٩٠٦١d;
        if (aVar != null) {
            synchronized (aVar) {
                if (!aVar.f١٩٠٥٢e) {
                    return;
                }
                aVar.f١٩٠٥٢e = false;
                aVar.f١٩٠٥١d.removeCallbacks(aVar.f١٩٠٥٤g);
            }
        }
    }

    public final JSONArray g() {
        if (this.f١٩٠٥٩b == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = this.f١٩٠٥٩b;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            k1.a aVar = (k1.a) obj;
            try {
                aVar.getClass();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("step", aVar.f١٥٤٠٧a);
                jSONObject.put("percent", aVar.f١٥٤٠٨b);
                jSONObject.put("extra", aVar.f١٥٤٠٩c);
                jSONObject.put("cost_time", aVar.f١٥٤١٠d);
                jSONObject.put("pause_cost_time", aVar.f١٥٤١١e);
                jSONArray.put(jSONObject);
            } catch (Exception e10) {
                e10.printStackTrace();
                LogUtils.file("LoadGameStatsManager", "getStepsJSONArray fail:" + LogUtils.getErrorInfo(e10));
            }
        }
        return jSONArray;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
    
        if (r4.f١٩٠٧٥r == false) goto L١٥;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h() {
        int i10;
        JSONArray g10;
        f.a aVar = this.f١٩٠٥٨a;
        if (aVar == null) {
            return;
        }
        aVar.f١٤٠١٢o = Long.valueOf(this.f١٩٠٦٧j.getElapsedTimeInMillis());
        this.f١٩٠٥٨a.f١٤٠١٣p = Integer.valueOf(this.f١٩٠٧١n);
        this.f١٩٠٥٨a.f١٤٠١٤q = Long.valueOf(this.f١٩٠٦٩l.getElapsedTimeInMillis());
        f.a aVar2 = this.f١٩٠٥٨a;
        String str = u.e.f١٨٢١٧e;
        int i11 = u.c.f١٨٢١٥a.f١٨٢١٨a;
        if (i11 != 3) {
            i10 = 1;
            if (i11 != 2) {
                if (i11 == 1) {
                }
            }
            aVar2.f١٤٠١٥r = Integer.valueOf(i10);
            File filesDir = Utils.getApp().getFilesDir();
            this.f١٩٠٥٨a.f١٤٠١٦s = Long.valueOf(filesDir.getTotalSpace());
            this.f١٩٠٥٨a.f١٤٠١٧t = Long.valueOf(filesDir.getUsableSpace());
            c(this.f١٩٠٥٨a);
            if (!"loadGameFinished".equals(this.f١٩٠٥٨a.f١٣٩٩٨a)) {
                f.a aVar3 = this.f١٩٠٥٨a;
                aVar3.f١٣٩٩٨a = "loadGameFinished";
                aVar3.f١٣٩٩٩b = f.d.a("loadGameFinished");
                f.a aVar4 = this.f١٩٠٥٨a;
                aVar4.getClass();
                aVar4.f١٤٠٠٠c = j.b(UUID.randomUUID().toString());
            }
            f.a aVar5 = this.f١٩٠٥٨a;
            g10 = g();
            if (g10 == null) {
                aVar5.f١٤٠٠٧j.put("loadGame", g10);
            } else {
                aVar5.getClass();
            }
            f.d.b(this.f١٩٠٥٨a);
            this.f١٩٠٥٨a = null;
            this.f١٩٠٥٩b = null;
        }
        i10 = 0;
        aVar2.f١٤٠١٥r = Integer.valueOf(i10);
        File filesDir2 = Utils.getApp().getFilesDir();
        this.f١٩٠٥٨a.f١٤٠١٦s = Long.valueOf(filesDir2.getTotalSpace());
        this.f١٩٠٥٨a.f١٤٠١٧t = Long.valueOf(filesDir2.getUsableSpace());
        c(this.f١٩٠٥٨a);
        if (!"loadGameFinished".equals(this.f١٩٠٥٨a.f١٣٩٩٨a)) {
        }
        f.a aVar52 = this.f١٩٠٥٨a;
        g10 = g();
        if (g10 == null) {
        }
        f.d.b(this.f١٩٠٥٨a);
        this.f١٩٠٥٨a = null;
        this.f١٩٠٥٩b = null;
    }
}
