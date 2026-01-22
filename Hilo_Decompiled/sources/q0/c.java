package q0;

import a.ServiceProvider__TheRouter__851042640;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import okhttp3.WebSocket;
import pf.k;
import pf.l;
import pf.m;
import pf.n;
import pf.o;
import pf.q;
import pf.r;
import pf.t;
import pf.u;
import pf.v;
import pf.w;
import s0.p;
import tech.sud.gip.asr.base.BaseRealSudASRImpl;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.GameInfo;
import tech.sud.gip.core.ISudAiAgent;
import tech.sud.gip.core.ISudFSMMG;
import tech.sud.gip.core.ISudFSTAPP;
import tech.sud.gip.core.ISudListenerNotifyStateChange;
import tech.sud.gip.core.SudLoadMGParamModel;
import tech.sud.gip.core.view.SudGameView;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;
import u.j;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c implements ISudFSTAPP, y0.g {
    public static final String F = "SudGIP ".concat(c.class.getSimpleName());
    public static c G;
    public boolean A;

    /* renamed from: B, reason: collision with root package name */
    public n1.b f١٧٠٥٠B;
    public g.g C;
    public xf.a D;
    public y0.b E;

    /* renamed from: a, reason: collision with root package name */
    public final SudLoadMGParamModel f١٧٠٥١a;

    /* renamed from: b, reason: collision with root package name */
    public final Activity f١٧٠٥٢b;

    /* renamed from: c, reason: collision with root package name */
    public final String f١٧٠٥٣c;

    /* renamed from: d, reason: collision with root package name */
    public final String f١٧٠٥٤d;

    /* renamed from: e, reason: collision with root package name */
    public final long f١٧٠٥٥e;

    /* renamed from: f, reason: collision with root package name */
    public final ISudFSMMG f١٧٠٥٦f;

    /* renamed from: g, reason: collision with root package name */
    public GameInfo f١٧٠٥٧g;

    /* renamed from: h, reason: collision with root package name */
    public final Context f١٧٠٥٨h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f١٧٠٥٩i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f١٧٠٦٠j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f١٧٠٦١k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f١٧٠٦٢l = true;

    /* renamed from: m, reason: collision with root package name */
    public d1.d f١٧٠٦٣m;

    /* renamed from: n, reason: collision with root package name */
    public final SudGameView f١٧٠٦٤n;

    /* renamed from: o, reason: collision with root package name */
    public p f١٧٠٦٥o;

    /* renamed from: p, reason: collision with root package name */
    public s0.e f١٧٠٦٦p;

    /* renamed from: q, reason: collision with root package name */
    public View f١٧٠٦٧q;

    /* renamed from: r, reason: collision with root package name */
    public final f f١٧٠٦٨r;

    /* renamed from: s, reason: collision with root package name */
    public final e f١٧٠٦٩s;

    /* renamed from: t, reason: collision with root package name */
    public final a f١٧٠٧٠t;

    /* renamed from: u, reason: collision with root package name */
    public final u f١٧٠٧١u;

    /* renamed from: v, reason: collision with root package name */
    public c1.a f١٧٠٧٢v;

    /* renamed from: w, reason: collision with root package name */
    public final y0.e f١٧٠٧٣w;

    /* renamed from: x, reason: collision with root package name */
    public GameInfo f١٧٠٧٤x;

    /* renamed from: y, reason: collision with root package name */
    public String f١٧٠٧٥y;

    /* renamed from: z, reason: collision with root package name */
    public ArrayList f١٧٠٧٦z;

    public c(SudLoadMGParamModel sudLoadMGParamModel, ISudFSMMG iSudFSMMG) {
        y0.e eVar = new y0.e(this);
        this.f١٧٠٧٣w = eVar;
        LogUtils.file("ProxySudFSTAPPImpl", "初始化" + LogUtils.buildField("userId", sudLoadMGParamModel.userId) + LogUtils.buildField("roomId", sudLoadMGParamModel.roomId) + LogUtils.buildField("code", sudLoadMGParamModel.code) + LogUtils.buildField("mgId", Long.valueOf(sudLoadMGParamModel.mgId)) + LogUtils.buildField(HeaderInterceptor.LANGUAGE, sudLoadMGParamModel.language));
        if (G != null) {
            LogUtils.file("ProxySudFSTAPPImpl", "Hey, guy! You not hold or call the destroyMG, but the instance will be dealloc. Please check it!");
            SudLogger.d(F, "Hey, guy! You not hold or call the destroyMG, but the instance will be dealloc. Please check it!");
            G.destroyMG();
        }
        G = this;
        this.f١٧٠٥١a = sudLoadMGParamModel;
        Activity activity = sudLoadMGParamModel.activity;
        this.f١٧٠٥٢b = activity;
        String str = sudLoadMGParamModel.userId;
        this.f١٧٠٥٣c = str;
        String str2 = sudLoadMGParamModel.roomId;
        this.f١٧٠٥٤d = str2;
        String str3 = sudLoadMGParamModel.code;
        long j10 = sudLoadMGParamModel.mgId;
        this.f١٧٠٥٥e = j10;
        this.f١٧٠٥٦f = iSudFSMMG;
        Context applicationContext = activity.getApplicationContext();
        this.f١٧٠٥٨h = applicationContext;
        eVar.f١٩٠٧٦s = activity;
        GameInfo gameInfo = new GameInfo();
        this.f١٧٠٥٧g = gameInfo;
        gameInfo.mgId = sudLoadMGParamModel.mgId;
        SudGameView sudGameView = new SudGameView(activity);
        sudGameView.setLifecycleListener(new d(this));
        this.f١٧٠٦٤n = sudGameView;
        long j11 = sudLoadMGParamModel.mgId;
        String str4 = f.d.f١٤٠٢٣a;
        f.d.f١٤٠٢٦d.put(String.valueOf(j11), j.b(UUID.randomUUID().toString()));
        if (gd.a.c == null) {
            gd.a.c = new gd.a(applicationContext);
        }
        this.f١٧٠٦٨r = new f(this);
        this.f١٧٠٦٩s = new e(this);
        a aVar = new a(this, this);
        this.f١٧٠٧٠t = aVar;
        u uVar = new u(applicationContext);
        this.f١٧٠٧١u = uVar;
        if (iSudFSMMG == null) {
            SudLogger.w(u.n, "fsmMg2App is null");
        } else {
            uVar.c = new WeakReference(iSudFSMMG);
            uVar.d = str;
            uVar.e = str2;
            uVar.f = str3;
            uVar.g = j10;
            uVar.j.clear();
            uVar.k.clear();
            uVar.l.clear();
            uVar.a.clear();
            uVar.a.put("m2as-set-debug", new pf.p());
            uVar.a.put("m2as-mg-log", new w(uVar));
            uVar.a.put("m2as-get-net-status", new pf.a(uVar));
            uVar.a.put("m2as-get-game-view-info", new pf.d(uVar));
            uVar.a.put("m2as-get-game-cfg", new pf.f(uVar));
            uVar.a.put("m2as-login", new pf.g(uVar));
            uVar.a.put("m2as-expire-code", new pf.j(uVar));
            uVar.a.put("m2as-vibrate", new k(uVar));
            uVar.a.put("m2as-get-sdk-info", new r(uVar));
            uVar.a.put("m2as-get-state", new n(uVar));
            uVar.a.put("m2as-notify-game-load-started", new l(uVar));
            uVar.a.put("m2as-notify-game-load-completed", new o(uVar));
            uVar.a.put("m2as-notify-game-started", new q(uVar));
            uVar.a.put("mg_common_game_asr", new m(uVar));
            uVar.a.put("mg_common_game_load_percent", new v(uVar));
            uVar.a.put("mg_common_game_reload", new pf.b(uVar));
            uVar.a.put("m2as-ai-common", new pf.c(uVar));
            uVar.a.put("m2as-ai-sse", new pf.e(uVar));
            uVar.a.put("mg_common_game_player_self_info", new pf.i(uVar));
            uVar.a.put("mg_common_game_llm_asr", new t(uVar));
        }
        uVar.m = aVar;
        c(this.f١٧٠٥٧g);
    }

    public final void a() {
        d1.d dVar;
        if (this.f١٧٠٦٦p != null) {
            if (this.f١٧٠٥٧g != null && (dVar = this.f١٧٠٦٣m) != null) {
                if (dVar instanceof l3.a) {
                } else if (dVar instanceof k3.a) {
                }
            }
            this.f١٧٠٦٤n.removeView(this.f١٧٠٦٧q);
            this.f١٧٠٦٦p = null;
            this.f١٧٠٦٧q = null;
        }
        p pVar = this.f١٧٠٦٥o;
        if (pVar != null) {
            String str = p.f١٧٥٨٨i;
            SudLogger.v(str, "stop loading");
            pVar.f١٧٥٩٣e = null;
            if (pVar.f١٧٥٩٥g < pVar.f١٧٥٩٢d.size()) {
                ((s0.j) pVar.f١٧٥٩٢d.get(pVar.f١٧٥٩٥g)).cancel();
                pVar.f١٧٥٩٥g = 0;
                LogUtils.file("SudGameLoadingModel", "loading canceled");
                SudLogger.d(str, "loading canceled");
            } else if (pVar.f١٧٥٩٦h != null) {
                LogUtils.file("SudGameLoadingModel", "loading done");
                SudLogger.d(str, "loading done");
                pVar.f١٧٥٩٦h.getClass();
            }
            this.f١٧٠٦٥o = null;
        }
    }

    public final void b(int i10, int i11, int i12, boolean z10) {
        String str = "onGameLoadingProgress stage:" + i10 + "  retCode:" + i11 + "  progress:" + i12;
        LogUtils.file("ProxySudFSTAPPImpl", str);
        SudLogger.i(F, str);
        y0.e eVar = this.f١٧٠٧٣w;
        eVar.getClass();
        if (i11 == 0 && !z10) {
            eVar.f١٩٠٧١n = i12;
            eVar.f١٩٠٦٩l.reset();
            eVar.f١٩٠٦٩l.start();
        }
        ISudFSMMG iSudFSMMG = this.f١٧٠٥٦f;
        if (iSudFSMMG != null) {
            iSudFSMMG.onGameLoadingProgress(i10, i11, i12);
        }
    }

    public final void c(GameInfo gameInfo) {
        LogUtils.file("ProxySudFSTAPPImpl", "_loadGame");
        String str = F;
        SudLogger.d(str, "_loadGame");
        this.f١٧٠٥٩i = false;
        this.f١٧٠٦٢l = true;
        y0.e eVar = this.f١٧٠٧٣w;
        eVar.getClass();
        LogUtils.file("LoadGameStatsManager", "startLoad:" + gameInfo.mgId);
        f.a aVar = new f.a("loadGameFinished");
        eVar.f١٩٠٥٨a = aVar;
        aVar.f١٤٠١٠m = 0;
        eVar.f١٩٠٥٩b = new ArrayList();
        f.a aVar2 = eVar.f١٩٠٥٨a;
        Boolean bool = Boolean.TRUE;
        aVar2.f١٤٠٠٩l = bool;
        aVar2.f١٤٠٠٨k = bool;
        aVar2.f١٤٠٠٤g = String.valueOf(gameInfo.mgId);
        eVar.f١٩٠٧٣p = gameInfo.mgId;
        eVar.f١٩٠٦٠c = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
        eVar.a();
        eVar.f١٩٠٦٧j.reset();
        eVar.f١٩٠٦٨k.reset();
        eVar.f١٩٠٦٩l.reset();
        eVar.f١٩٠٦٩l.start();
        eVar.f١٩٠٦٤g = false;
        eVar.f١٩٠٦٦i = false;
        eVar.f١٩٠٦٥h = false;
        eVar.f١٩٠٦٣f = false;
        eVar.f١٩٠٦١d = null;
        eVar.f١٩٠٧٠m.clear();
        eVar.f١٩٠٧٢o = false;
        eVar.f١٩٠٧١n = 0;
        this.f١٧٠٦٦p = new s0.e(this.f١٧٠٥٢b);
        Activity activity = this.f١٧٠٥٢b;
        SudLoadMGParamModel sudLoadMGParamModel = this.f١٧٠٥١a;
        p pVar = new p(activity, sudLoadMGParamModel, sudLoadMGParamModel.loadMGMode, sudLoadMGParamModel.authorizationSecret, this.f١٧٠٦٨r);
        this.f١٧٠٦٥o = pVar;
        s0.e eVar2 = this.f١٧٠٦٦p;
        View view = eVar2.f١٧٥٤٩f;
        this.f١٧٠٦٧q = view;
        eVar2.f١٧٥٨٥a = this.f١٧٠٦٩s;
        pVar.f١٧٥٩٦h = eVar2;
        this.f١٧٠٦٤n.addView(view);
        e eVar3 = this.f١٧٠٦٦p.f١٧٥٨٥a;
        eVar3.getClass();
        LogUtils.file("ProxySudFSTAPPImpl", "onLoadingStart");
        SudLogger.d(str, "onLoadingStart");
        p pVar2 = eVar3.f١٧٠٧٨a.f١٧٠٦٥o;
        pVar2.getClass();
        SudLogger.v(p.f١٧٥٨٨i, "start loading");
        pVar2.f١٧٥٩٣e = gameInfo;
        s0.e eVar4 = pVar2.f١٧٥٩٦h;
        if (eVar4 != null) {
            eVar4.f١٧٥٤٦c = 10;
            eVar4.f١٧٥٥٢i.setProgress(10);
            eVar4.f١٧٥٥٦m.setVisibility(0);
            if (d1.a.f١٣٥٤٠a && !eVar4.f١٧٥٦٢s) {
                eVar4.f١٧٥٥٤k.setVisibility(0);
            } else {
                eVar4.f١٧٥٥٤k.setVisibility(4);
            }
            eVar4.f١٧٥٨٥a.f١٧٠٧٨a.b(1, 0, eVar4.f١٧٥٤٦c, false);
            eVar4.g();
            eVar4.a();
            eVar4.c(0, true, eVar4.f١٧٥٤٦c, false);
            eVar4.f١٧٥٥٠g.setVisibility(4);
        }
        int i10 = pVar2.f١٧٥٩٥g;
        if (i10 != 0 && i10 < pVar2.f١٧٥٩٢d.size()) {
            ((s0.j) pVar2.f١٧٥٩٢d.get(pVar2.f١٧٥٩٥g)).cancel();
        }
        pVar2.f١٧٥٩٥g = 0;
        ((s0.j) pVar2.f١٧٥٩٢d.get(0)).a(pVar2.f١٧٥٩٣e, pVar2.f١٧٥٩٠b, pVar2.f١٧٥٩١c);
    }

    public final boolean destroyMG() {
        BaseRealSudASRImpl baseRealSudASRImpl;
        String str = F;
        SudLogger.i(str, "destroyMG");
        LogUtils.file("ProxySudFSTAPPImpl", "destroyMG");
        if (!this.f١٧٠٦١k) {
            this.f١٧٠٦١k = true;
            LogUtils.file("ProxySudFSTAPPImpl", "_destroyMGInternal");
            SudLogger.d(str, "_destroyMGInternal");
            y0.e eVar = this.f١٧٠٧٣w;
            eVar.f١٩٠٦٦i = true;
            eVar.f١٩٠٦٧j.stop();
            eVar.f١٩٠٦٨k.stop();
            eVar.f١٩٠٦٩l.stop();
            eVar.a();
            f.a aVar = eVar.f١٩٠٥٨a;
            if (aVar != null) {
                aVar.f١٤٠٠٢e = -10301;
            }
            if (aVar != null) {
                aVar.f١٤٠٠٣f = "销毁游戏";
            }
            eVar.h();
            a();
            d1.d dVar = this.f١٧٠٦٣m;
            if (dVar != null) {
                dVar.destroyMG();
                this.f١٧٠٦٣m = null;
            }
            f.d.f١٤٠٢٦d.remove(String.valueOf(this.f١٧٠٥٥e));
            n1.b bVar = this.f١٧٠٥٠B;
            if (bVar != null) {
                bVar.a();
                this.f١٧٠٥٠B = null;
            }
            g.g gVar = this.C;
            if (gVar != null) {
                SudLogger.d(gVar.f١٤٣٢٨a, "destroy isRunning:" + gVar.f١٤٣٣٣f.get());
                LogUtils.file("SudGIPWebSocket", "destroy isRunning:" + gVar.f١٤٣٣٣f.get());
                if (gVar.f١٤٣٣٣f.get()) {
                    gVar.f١٤٣٣٣f.set(false);
                    gVar.f١٤٣٣٤g.removeCallbacks(gVar.f١٤٣٣٦i);
                    WebSocket webSocket = gVar.f١٤٣٣٥h;
                    if (webSocket != null) {
                        webSocket.close(1000, "destroy");
                        gVar.f١٤٣٣٥h = null;
                    }
                }
                this.C = null;
            }
            c1.a aVar2 = this.f١٧٠٧٢v;
            if (aVar2 != null && (baseRealSudASRImpl = aVar2.f٥٦٥٥a) != null) {
                baseRealSudASRImpl.stopASR(true);
            }
        }
        if (G == this) {
            G = null;
        }
        return true;
    }

    public final ISudAiAgent getAiAgent() {
        synchronized (this) {
            try {
                if (this.f١٧٠٥٠B == null) {
                    n1.b bVar = new n1.b();
                    this.f١٧٠٥٠B = bVar;
                    xf.a aVar = this.D;
                    if (aVar != null) {
                        bVar.f١٦١٥٨m = aVar.a;
                        bVar.f١٦١٥٩n = aVar.c;
                    }
                    bVar.f١٦١٤٧b = this.f١٧٠٥٥e;
                    bVar.f١٦١٤٨c = this.f١٧٠٥٤d;
                    bVar.f١٦١٤٩d = this.f١٧٠٥٣c;
                    SudLoadMGParamModel sudLoadMGParamModel = this.f١٧٠٥١a;
                    if (sudLoadMGParamModel != null) {
                        bVar.f١٦١٥٢g = sudLoadMGParamModel.language;
                    }
                    y0.b bVar2 = this.E;
                    if (bVar2 != null) {
                        bVar.f١٦١٦٠o = bVar2;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f١٧٠٥٠B;
    }

    public final String getGameState(String str) {
        d1.d dVar;
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(F, "Please call on UI or Main thread");
        }
        if (!this.f١٧٠٦١k && (dVar = this.f١٧٠٦٣m) != null) {
            return dVar.getGameState(str);
        }
        return ServiceProvider__TheRouter__851042640.FLOW_TASK_JSON;
    }

    public final View getGameView() {
        LogUtils.file("ProxySudFSTAPPImpl", "getGameView");
        return this.f١٧٠٦٤n;
    }

    public final String getPlayerState(String str, String str2) {
        d1.d dVar;
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(F, "Please call on UI or Main thread");
        }
        if (!this.f١٧٠٦١k && (dVar = this.f١٧٠٦٣m) != null) {
            return dVar.getPlayerState(str, str2);
        }
        return ServiceProvider__TheRouter__851042640.FLOW_TASK_JSON;
    }

    public final void notifyStateChange(String str, String str2, ISudListenerNotifyStateChange iSudListenerNotifyStateChange) {
        d1.d dVar;
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(F, "Please call on UI or Main thread");
        }
        boolean z10 = this.f١٧٠٦١k;
        if (z10) {
            LogUtils.file("ProxySudFSTAPPImpl", "notifyStateChange 游戏已销毁 state:" + str + "  dataJson:" + str2);
            SudLogger.e(F, "This SudFSTAPP instance has been destroyed. Please attention");
            if (iSudListenerNotifyStateChange != null) {
                iSudListenerNotifyStateChange.onFailure(-1, "This SudFSTAPP instance has been destroyed. Please attention");
                return;
            }
            return;
        }
        if (!z10 && (dVar = this.f١٧٠٦٣m) != null) {
            dVar.notifyStateChange(str, str2, iSudListenerNotifyStateChange);
        }
    }

    public final void pauseMG() {
        d1.d dVar;
        LogUtils.file("ProxySudFSTAPPImpl", "pauseMG");
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(F, "Please call on UI or Main thread");
        }
        if (!this.f١٧٠٦١k && (dVar = this.f١٧٠٦٣m) != null) {
            dVar.pauseMG();
        }
        y0.e eVar = this.f١٧٠٧٣w;
        eVar.getClass();
        ThreadUtils.getUIHandler().postDelayed(new y0.d(eVar), 1L);
    }

    public final void playMG() {
        d1.d dVar;
        LogUtils.file("ProxySudFSTAPPImpl", "playMG");
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(F, "Please call on UI or Main thread");
        }
        if (!this.f١٧٠٦١k && (dVar = this.f١٧٠٦٣m) != null) {
            dVar.playMG();
        }
        y0.e eVar = this.f١٧٠٧٣w;
        eVar.getClass();
        ThreadUtils.getUIHandler().postDelayed(new y0.c(eVar), 1L);
    }

    public final void pushAudio(ByteBuffer byteBuffer, int i10) {
        c1.a aVar;
        BaseRealSudASRImpl baseRealSudASRImpl;
        if (!this.f١٧٠٦١k && this.f١٧٠٦٣m != null && byteBuffer != null && i10 > 0 && (aVar = this.f١٧٠٧٢v) != null && (baseRealSudASRImpl = aVar.f٥٦٥٥a) != null) {
            baseRealSudASRImpl.pushAudio(byteBuffer, i10);
        }
    }

    public final void reloadMG() {
        LogUtils.file("ProxySudFSTAPPImpl", "reloadMG");
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(F, "Please call on UI or Main thread");
        }
        if (h0.b.f١٤٤٨٧a.f١٤٤٨٤b && this.f١٧٠٥٩i) {
            this.f١٧٠٧٣w.h();
            a();
            c(this.f١٧٠٥٧g);
        }
    }

    public final void startMG() {
        d1.d dVar;
        LogUtils.file("ProxySudFSTAPPImpl", "startMG");
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(F, "Please call on UI or Main thread");
        }
        if (!this.f١٧٠٦١k && (dVar = this.f١٧٠٦٣m) != null) {
            dVar.startMG();
        }
    }

    public final void stopMG() {
        d1.d dVar;
        LogUtils.file("ProxySudFSTAPPImpl", "stopMG");
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(F, "Please call on UI or Main thread");
        }
        if (!this.f١٧٠٦١k && (dVar = this.f١٧٠٦٣m) != null) {
            dVar.stopMG();
        }
    }

    public final void updateCode(String str, ISudListenerNotifyStateChange iSudListenerNotifyStateChange) {
        d1.d dVar;
        LogUtils.file("ProxySudFSTAPPImpl", "updateCode:" + str);
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(F, "Please call on UI or Main thread");
        }
        if (!this.f١٧٠٦١k && (dVar = this.f١٧٠٦٣m) != null) {
            dVar.updateCode(str, iSudListenerNotifyStateChange);
        }
    }
}
