package g1;

import a.ServiceProvider__TheRouter__851042640;
import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import anetwork.channel.util.RequestConstant;
import com.google.android.gms.actions.SearchIntents;
import j.v;
import j.z;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pf.u;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.GameInfo;
import tech.sud.gip.core.ISudFSMMG;
import tech.sud.gip.core.ISudListenerNotifyStateChange;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;
import tech.sud.runtime.a.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class h extends d1.d {

    /* renamed from: k, reason: collision with root package name */
    public static final String f١٤٣٨٢k = "SudGIP ".concat(h.class.getSimpleName());

    /* renamed from: l, reason: collision with root package name */
    public static final ExecutorService f١٤٣٨٣l = Executors.newSingleThreadExecutor();

    /* renamed from: m, reason: collision with root package name */
    public static boolean f١٤٣٨٤m;

    /* renamed from: a, reason: collision with root package name */
    public final Activity f١٤٣٨٥a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f١٤٣٨٦b;

    /* renamed from: c, reason: collision with root package name */
    public final String f١٤٣٨٧c;

    /* renamed from: d, reason: collision with root package name */
    public final long f١٤٣٨٨d;

    /* renamed from: e, reason: collision with root package name */
    public j.d f١٤٣٨٩e;

    /* renamed from: g, reason: collision with root package name */
    public final p1.b f١٤٣٩١g;

    /* renamed from: h, reason: collision with root package name */
    public final pf.h f١٤٣٩٢h;

    /* renamed from: i, reason: collision with root package name */
    public d1.b f١٤٣٩٣i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f١٤٣٩٤j = false;

    /* renamed from: f, reason: collision with root package name */
    public final b f١٤٣٩٠f = new b(this);

    static {
        try {
            f fVar = new f();
            j.d.C = fVar;
            o.b.f١٦٤٠٨a = fVar;
        } catch (Throwable th) {
            th.printStackTrace();
            LogUtils.file("SUDRealSudFSTAPPImpl", "初始化引擎的日志监听发生了异常：" + LogUtils.getErrorInfo(th));
        }
    }

    public h(Activity activity, String str, long j10, FrameLayout frameLayout, u uVar) {
        this.f١٤٣٨٥a = activity;
        this.f١٤٣٨٦b = frameLayout;
        this.f١٤٣٨٧c = str;
        this.f١٤٣٨٨d = j10;
        this.f١٤٣٩٢h = uVar;
        this.f١٤٣٩١g = new p1.b(uVar);
    }

    public static /* synthetic */ void d(ISudListenerNotifyStateChange iSudListenerNotifyStateChange, JSONArray jSONArray) {
        if (iSudListenerNotifyStateChange != null) {
            if (jSONArray.length() > 0) {
                try {
                    iSudListenerNotifyStateChange.onSuccess(jSONArray.getString(0));
                    return;
                } catch (Exception e10) {
                    iSudListenerNotifyStateChange.onFailure(-1, e10.toString());
                    return;
                }
            }
            iSudListenerNotifyStateChange.onSuccess(ServiceProvider__TheRouter__851042640.FLOW_TASK_JSON);
        }
    }

    @Override // d1.d
    public final void a(d1.b bVar) {
        this.f١٤٣٩٣i = bVar;
    }

    @Override // d1.d
    public final void b(GameInfo gameInfo, String str) {
        String str2;
        String str3;
        HashMap hashMap;
        String str4;
        String str5;
        String str6;
        FrameLayout frameLayout;
        j.a aVar;
        LogUtils.file("SUDRealSudFSTAPPImpl", "_startGame");
        String str7 = f١٤٣٨٢k;
        SudLogger.d(str7, "_startGame");
        if (!this.f١٤٣٩٤j) {
            j.d dVar = new j.d(this.f١٤٣٨٥a);
            this.f١٤٣٨٩e = dVar;
            dVar.d("custom.CustomCommand", new e(this.f١٤٣٩١g));
            j.d dVar2 = this.f١٤٣٨٩e;
            dVar2.f١٤٩٩٣h = this.f١٤٣٩٠f;
            this.f١٤٣٨٦b.addView(dVar2.f١٤٩٩٥j, 0, new FrameLayout.LayoutParams(-1, -1));
            v vVar = this.f١٤٣٨٩e.f١٤٩٨٦a;
            if (vVar != null && vVar.c()) {
                j.d dVar3 = this.f١٤٣٨٩e;
                dVar3.f١٤٩٩٩n = "";
                dVar3.f١٥٠٠٨w = false;
                dVar3.f١٥٠٠٧v = false;
                dVar3.f١٥٠٠٦u = true;
                if (d1.a.f١٣٥٤٠a) {
                    dVar3.f١٥٠٠٠o = true;
                    dVar3.f١٥٠٠٢q = "";
                    dVar3.f١٥٠٠٥t = true;
                } else {
                    dVar3.f١٥٠٠٠o = false;
                    dVar3.f١٥٠٠٢q = "";
                    dVar3.f١٥٠٠٥t = false;
                }
                h0.a aVar2 = h0.b.f١٤٤٨٧a;
                dVar3.A = "true".equals(aVar2.f١٤٤٨٦d.get("disable_audio_focus"));
                String str8 = (String) aVar2.f١٤٤٨٦d.get("keyboard_bottom_offset");
                if (str8 != null) {
                    try {
                        this.f١٤٣٨٩e.f١٤٩٨٥B = Integer.valueOf(Integer.parseInt(str8));
                    } catch (Exception e10) {
                        LogUtils.file("SUDRealSudFSTAPPImpl", LogUtils.getErrorInfo(e10));
                    }
                }
                j.d dVar4 = this.f١٤٣٨٩e;
                dVar4.f١٥٠١٠y = "local_storage.db";
                dVar4.f١٥٠٠٤s = "SudPlugin";
                j.f fVar = new j.f();
                Locale locale = Locale.US;
                String absolutePath = new File(this.f١٤٣٨٥a.getFilesDir(), "sud/mgp/user/" + this.f١٤٣٨٧c + "/" + gameInfo.mgId + "/data").getAbsolutePath();
                j.d dVar5 = this.f١٤٣٨٩e;
                String str9 = this.f١٤٣٨٧c;
                String valueOf = String.valueOf(gameInfo.mgId);
                v vVar2 = dVar5.f١٤٩٨٦a;
                if (vVar2 != null) {
                    if (dVar5.f١٤٩٩٧l) {
                        o.b.c("WXGame", "Game.start called more than once, skipped.");
                    } else {
                        dVar5.f١٤٩٩٧l = true;
                        try {
                            int i10 = dVar5.f١٥٠١١z;
                            if (i10 == 6 || i10 == 8 || i10 == 0 || i10 == 1) {
                                vVar2.a("defaultOrientation", "1");
                            }
                            String str10 = str9 + "_" + valueOf;
                            if (absolutePath == null || absolutePath.length() == 0) {
                                absolutePath = "{{USER_ID}}/{{GAME_ID}}";
                            }
                            if (!new File(absolutePath).isAbsolute()) {
                                absolutePath = new File(dVar5.f١٤٩٨٧b.getFilesDir(), absolutePath).getAbsolutePath();
                            }
                            if (!absolutePath.contains("{{USER_ID}}") && !absolutePath.contains("{{GAME_ID}}")) {
                                absolutePath = new File(absolutePath, "{{USER_ID}}/{{GAME_ID}}").getAbsolutePath();
                            }
                            String replace = absolutePath.replace("{{USER_ID}}", str9).replace("{{GAME_ID}}", valueOf);
                            v vVar3 = dVar5.f١٤٩٨٦a;
                            j.u uVar = vVar3.f١٥٠٤٨b;
                            uVar.f١٥٠٤٢c = replace;
                            uVar.f١٥٠٤٠a = dVar5.f١٥٠٠٠o;
                            vVar3.a("runtime.mode", "" + dVar5.f١٥٠٠١p);
                            dVar5.f١٤٩٨٦a.a("runtime.LoadPath", dVar5.f١٤٩٩٩n);
                            v vVar4 = dVar5.f١٤٩٨٦a;
                            try {
                                JSONObject jSONObject = new JSONObject();
                                if (fVar.f١٥٠١٣a == 0) {
                                    fVar.f١٥٠١٣a = 1001L;
                                }
                                jSONObject.put("scene", fVar.f١٥٠١٣a);
                                String str11 = fVar.f١٥٠١٤b;
                                if (str11 == null || str11.length() == 0) {
                                    fVar.f١٥٠١٤b = ServiceProvider__TheRouter__851042640.FLOW_TASK_JSON;
                                }
                                jSONObject.put(SearchIntents.EXTRA_QUERY, fVar.f١٥٠١٤b);
                                jSONObject.put("shareTicket", "");
                                jSONObject.put("referrerInfo", new JSONObject());
                                str2 = jSONObject.toString();
                            } catch (Exception e11) {
                                e11.printStackTrace();
                                str2 = ServiceProvider__TheRouter__851042640.FLOW_TASK_JSON;
                            }
                            vVar4.a("wx.launchOptions", str2);
                            dVar5.f١٤٩٨٦a.a("wx.packHost", dVar5.f١٥٠٠٢q);
                            dVar5.f١٤٩٨٦a.a("wx.packExt", dVar5.f١٥٠٠٣r);
                            dVar5.f١٤٩٨٦a.a("wx.pluginPath", dVar5.f١٥٠٠٤s);
                            dVar5.f١٤٩٨٦a.a("wx.identification", str10);
                            dVar5.f١٤٩٨٦a.a("wx.gameId", valueOf);
                            dVar5.f١٤٩٨٦a.a("wx.userId", str9);
                            dVar5.f١٤٩٨٦a.a("systemLanguage", dVar5.f١٥٠٠٩x);
                            v vVar5 = dVar5.f١٤٩٨٦a;
                            if (dVar5.A) {
                                str3 = "true";
                            } else {
                                str3 = RequestConstant.FALSE;
                            }
                            vVar5.a("disableAudioFocus", str3);
                            if (dVar5.f١٤٩٨٥B != null) {
                                dVar5.f١٤٩٨٦a.a("keyboardBottomOffset", dVar5.f١٤٩٨٥B + "");
                            }
                            if (!dVar5.f١٥٠٠٦u) {
                                dVar5.f١٤٩٨٦a.a("jsConsole.noLogcat", "1");
                            }
                            String str12 = dVar5.f١٥٠١٠y;
                            if (str12 != null) {
                                dVar5.f١٤٩٨٦a.a("localStorageDb", str12.replace("{{USER_ID}}", str9).replace("{{GAME_ID}}", valueOf));
                            }
                            if (dVar5.f١٥٠٠٥t) {
                                dVar5.f١٤٩٨٦a.a("jsConsole", "1");
                                dVar5.f١٤٩٨٦a.a("jsConsole.autoCreate", "0");
                            }
                            if (!dVar5.f١٥٠٠٨w) {
                                dVar5.f١٤٩٨٦a.a("sysUIVis", "0");
                            }
                            if (!dVar5.f١٥٠٠٧v) {
                                dVar5.f١٤٩٨٦a.a("activityLifecycle", "0");
                            }
                            v vVar6 = dVar5.f١٤٩٨٦a;
                            HashMap hashMap2 = vVar6.f١٥٠٥١e;
                            if (hashMap2 == null) {
                                hashMap = new HashMap();
                            } else {
                                hashMap = (HashMap) hashMap2.clone();
                            }
                            HashMap hashMap3 = hashMap;
                            hashMap3.put("Entry", str);
                            StringBuilder sb = new StringBuilder("");
                            vVar6.f١٥٠٤٨b.getClass();
                            sb.append(0L);
                            hashMap3.put("loadingTimeout", sb.toString());
                            if (vVar6.f١٥٠٤٨b.f١٥٠٤٠a) {
                                hashMap3.put("fps.show", "true");
                                vVar6.f١٥٠٤٨b.getClass();
                                hashMap3.put("fps.logTime", Long.valueOf(30).toString());
                            }
                            if (vVar6.f١٥٠٤٨b.f١٥٠٤١b) {
                                str4 = "NO";
                            } else {
                                str4 = "YES";
                            }
                            hashMap3.put("nativeRender", str4);
                            vVar6.f١٥٠٤٨b.getClass();
                            hashMap3.put("nativeGLBatch", "NO");
                            hashMap3.put("cachePath", vVar6.f١٥٠٤٨b.f١٥٠٤٢c);
                            hashMap3.put("preloadPath", vVar6.f١٥٠٤٨b.f١٥٠٤٣d);
                            vVar6.f١٥٠٤٨b.getClass();
                            hashMap3.put("transparent", "0");
                            if (vVar6.f١٥٠٤٨b.f١٥٠٤٤e) {
                                str5 = "1";
                            } else {
                                str5 = "0";
                            }
                            hashMap3.put("immersiveMode", str5);
                            if (vVar6.f١٥٠٤٨b.f١٥٠٤٥f) {
                                str6 = "1";
                            } else {
                                str6 = "0";
                            }
                            hashMap3.put("useCutout", str6);
                            vVar6.f١٥٠٤٨b.getClass();
                            hashMap3.put("enableOrientation", "0");
                            o.b.c("SudNative", "NativePlayerFactory precreate");
                            try {
                                vVar6.f١٥٠٤٩c = new tech.sud.runtime.a.c();
                            } catch (Exception e12) {
                                e12.printStackTrace();
                                o.b.c("SudNative", "NativePlayerFactory CreatePlayer error:" + o.b.a(e12));
                            }
                            if (vVar6.f١٥٠٤٩c == null) {
                                o.b.b("Unable to create player object.");
                            } else {
                                if (v.f١٥٠٤٦h == null && vVar6.f١٥٠٥٢f != null) {
                                    synchronized (v.class) {
                                        try {
                                            if (v.f١٥٠٤٦h == null && (aVar = vVar6.f١٥٠٥٢f) != null) {
                                                v.f١٥٠٤٦h = aVar;
                                                vVar6.f١٥٠٤٩c.a(aVar);
                                            }
                                        } finally {
                                        }
                                    }
                                }
                                vVar6.f١٥٠٤٩c.a(vVar6.f١٥٠٤٧a, hashMap3);
                                Object[] e13 = vVar6.f١٥٠٤٩c.e();
                                if (e13.length >= 2 && e13[0].equals(e13[1])) {
                                    Object obj = e13[0];
                                    vVar6.f١٥٠٤٨b.getClass();
                                    for (Map.Entry entry : vVar6.f١٥٠٥٣g.entrySet()) {
                                        vVar6.f١٥٠٤٩c.a((String) entry.getKey(), (a.a) entry.getValue());
                                    }
                                    vVar6.f١٥٠٥٣g.clear();
                                    vVar6.f١٥٠٥٠d = true;
                                    FrameLayout frameLayout2 = dVar5.f١٤٩٩٥j;
                                    tech.sud.runtime.a.c cVar = dVar5.f١٤٩٨٦a.f١٥٠٤٩c;
                                    if (cVar == null) {
                                        frameLayout = null;
                                    } else {
                                        frameLayout = (FrameLayout) cVar.a();
                                    }
                                    frameLayout2.addView(frameLayout, -1, new FrameLayout.LayoutParams(-1, -1));
                                    if (dVar5.f١٤٩٩٨m == null) {
                                        dVar5.f١٤٩٩٨m = new FrameLayout(dVar5.f١٤٩٨٧b);
                                    }
                                    dVar5.f١٤٩٩٥j.addView(dVar5.f١٤٩٩٨m, new FrameLayout.LayoutParams(-1, -1));
                                    dVar5.f١٤٩٩٥j.addView(dVar5.f١٤٩٩٦k, new FrameLayout.LayoutParams(-1, -1));
                                    if (dVar5.f١٤٩٩٢g == null) {
                                        dVar5.f١٤٩٩٢g = new k.a(dVar5.f١٤٩٨٧b, dVar5);
                                    }
                                    if (dVar5.f١٥٠٠٥t) {
                                        v vVar7 = dVar5.f١٤٩٨٦a;
                                        FrameLayout frameLayout3 = dVar5.f١٤٩٩٥j;
                                        tech.sud.runtime.a.c cVar2 = vVar7.f١٥٠٤٩c;
                                        if (cVar2 != null) {
                                            cVar2.a(frameLayout3);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                for (int i11 = 0; i11 < e13.length; i11++) {
                                    o.b.b("index:" + i11 + "  version:" + e13[i11]);
                                }
                                o.b.b("Versions of jar and so are different.");
                            }
                        } catch (Exception e14) {
                            e14.printStackTrace();
                            o.b.c("WXGame", "read game.json failed");
                        }
                    }
                }
                LogUtils.file("SUDRealSudFSTAPPImpl", "error _game->start failed.");
                SudLogger.e(f١٤٣٨٢k, "_game->start failed.");
                return;
            }
            LogUtils.file("SUDRealSudFSTAPPImpl", "error _startGame This device does not support OpenGL ES 2.0.");
            SudLogger.e(str7, "_startGame This device does not support OpenGL ES 2.0.");
        }
    }

    @Override // d1.d
    public final void c(GameInfo gameInfo, String str) {
        if (this.f١٤٣٩٤j) {
            return;
        }
        LogUtils.file("SUDRealSudFSTAPPImpl", "exeCommonGameReload");
        j.d dVar = this.f١٤٣٨٩e;
        if (dVar != null) {
            dVar.a();
            this.f١٤٣٨٩e = null;
        }
        b(gameInfo, str);
    }

    @Override // d1.d
    public final boolean destroyMG() {
        ISudFSMMG iSudFSMMG;
        if (!this.f١٤٣٩٤j) {
            this.f١٤٣٩٤j = true;
            LogUtils.file("SUDRealSudFSTAPPImpl", "_destroyMGInternal");
            String str = f١٤٣٨٢k;
            SudLogger.d(str, "_destroyMGInternal");
            j.d dVar = this.f١٤٣٨٩e;
            if (dVar != null) {
                dVar.a();
                this.f١٤٣٨٩e = null;
                u uVar = this.f١٤٣٩٢h;
                if (uVar != null && (iSudFSMMG = (ISudFSMMG) uVar.c.get()) != null) {
                    SudLogger.i(str, "onGameDestroyed");
                    iSudFSMMG.onGameDestroyed();
                }
                new Thread(new c(this)).start();
            }
        }
        return true;
    }

    @Override // d1.d
    public final String getGameState(String str) {
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(f١٤٣٨٢k, "Please call on UI or Main thread");
        }
        u uVar = this.f١٤٣٩٢h;
        if (uVar != null) {
            String str2 = (String) uVar.j.get(str);
            if (str2 == null) {
                return ServiceProvider__TheRouter__851042640.FLOW_TASK_JSON;
            }
            return str2;
        }
        return "";
    }

    @Override // d1.d
    public final View getGameView() {
        return this.f١٤٣٨٦b;
    }

    @Override // d1.d
    public final String getPlayerState(String str, String str2) {
        String str3;
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(f١٤٣٨٢k, "Please call on UI or Main thread");
        }
        u uVar = this.f١٤٣٩٢h;
        if (uVar != null) {
            Map map = (Map) uVar.k.get(str);
            if (map == null || (str3 = (String) map.get(str2)) == null) {
                return ServiceProvider__TheRouter__851042640.FLOW_TASK_JSON;
            }
            return str3;
        }
        return "";
    }

    @Override // d1.d
    public final void notifyStateChange(String str, String str2, final ISudListenerNotifyStateChange iSudListenerNotifyStateChange) {
        String obj;
        int i10;
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(f١٤٣٨٢k, "Please call on UI or Main thread");
        }
        u uVar = this.f١٤٣٩٢h;
        if (uVar != null) {
            uVar.l.put(str, str2);
        }
        if (this.f١٤٣٨٩e != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("state", str);
                jSONObject.put("dataJson", new JSONObject(str2));
                obj = null;
            } catch (JSONException e10) {
                LogUtils.file("error 发送给游戏的消息格式错误：" + LogUtils.getErrorInfo(e10));
                obj = e10.toString();
            }
            if (obj != null) {
                if (iSudListenerNotifyStateChange != null) {
                    iSudListenerNotifyStateChange.onFailure(-1, obj);
                    return;
                }
                return;
            }
            LogUtils.file("SUDRealSudFSTAPPImpl", "notifyStateChange:" + jSONObject.toString());
            j.d dVar = this.f١٤٣٨٩e;
            z zVar = new z() { // from class: g1.g
                @Override // j.z
                public final void a(JSONArray jSONArray) {
                    h.d(iSudListenerNotifyStateChange, jSONArray);
                }
            };
            dVar.getClass();
            if (dVar.f١٤٩٨٦a != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("cmd", "custom.CustomCommandEvent");
                    synchronized (dVar.f١٤٩٩١f) {
                        i10 = dVar.f١٤٩٩٠e + 1;
                        dVar.f١٤٩٩٠e = i10;
                        dVar.f١٤٩٩١f.put(i10, zVar);
                    }
                    jSONObject2.put("id", i10);
                    jSONObject2.put("data", jSONObject);
                    v vVar = dVar.f١٤٩٨٦a;
                    String jSONObject3 = jSONObject2.toString();
                    tech.sud.runtime.a.c cVar = vVar.f١٥٠٤٩c;
                    if (cVar != null) {
                        cVar.a("RTGlobalEvent", jSONObject3);
                        return;
                    }
                    return;
                } catch (JSONException e11) {
                    o.b.c("WXGame", e11.getMessage());
                    return;
                }
            }
            return;
        }
        if (iSudListenerNotifyStateChange != null) {
            iSudListenerNotifyStateChange.onFailure(-1, "This game has been destroyed");
        }
    }

    @Override // d1.d
    public final void pauseMG() {
        tech.sud.runtime.a.c cVar;
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(f١٤٣٨٢k, "Please call on UI or Main thread");
        }
        if (this.f١٤٣٨٩e != null) {
            notifyStateChange("a2ms-notify-pause-game", ServiceProvider__TheRouter__851042640.FLOW_TASK_JSON, null);
            v vVar = this.f١٤٣٨٩e.f١٤٩٨٦a;
            if (vVar != null && (cVar = vVar.f١٥٠٤٩c) != null) {
                cVar.c();
            }
        }
    }

    @Override // d1.d
    public final void playMG() {
        tech.sud.runtime.a.c cVar;
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(f١٤٣٨٢k, "Please call on UI or Main thread");
        }
        j.d dVar = this.f١٤٣٨٩e;
        if (dVar != null) {
            v vVar = dVar.f١٤٩٨٦a;
            if (vVar != null && (cVar = vVar.f١٥٠٤٩c) != null) {
                cVar.d();
            }
            notifyStateChange("a2ms-notify-resume-game", ServiceProvider__TheRouter__851042640.FLOW_TASK_JSON, null);
        }
    }

    @Override // d1.d
    public final void startMG() {
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(f١٤٣٨٢k, "Please call on UI or Main thread");
        }
    }

    @Override // d1.d
    public final void stopMG() {
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(f١٤٣٨٢k, "Please call on UI or Main thread");
        }
    }

    @Override // d1.d
    public final void updateCode(String str, ISudListenerNotifyStateChange iSudListenerNotifyStateChange) {
        String str2;
        if (!ThreadUtils.checkUIThread()) {
            SudLogger.e(f١٤٣٨٢k, "Please call on UI or Main thread");
        }
        if (this.f١٤٣٩٤j) {
            if (iSudListenerNotifyStateChange != null) {
                iSudListenerNotifyStateChange.onFailure(-1, "This Game has been destroyed");
                return;
            }
            return;
        }
        u uVar = this.f١٤٣٩٢h;
        if (uVar != null) {
            uVar.f = str;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret_code", 0);
            jSONObject.put("ret_msg", "success");
            jSONObject.put("code", str);
            str2 = jSONObject.toString();
        } catch (Exception e10) {
            SudLogger.e(f١٤٣٨٢k, e10.toString());
            str2 = "";
        }
        notifyStateChange("a2ms-update-code", str2, iSudListenerNotifyStateChange);
    }

    @Override // d1.d
    public final void reloadMG() {
    }

    @Override // d1.d
    public final void pushAudio(ByteBuffer byteBuffer, int i10) {
    }
}
