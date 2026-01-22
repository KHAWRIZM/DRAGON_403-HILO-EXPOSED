package s0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.amazonaws.services.s3.internal.Constants;
import org.json.JSONObject;
import tech.sud.gip.R;
import tech.sud.gip.core.GameInfo;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f١٧٥٨٧a;

    public o(p pVar) {
        this.f١٧٥٨٧a = pVar;
    }

    public final void a(int i10) {
        d1.d dVar;
        String str;
        this.f١٧٥٨٧a.f١٧٥٩٦h.b(i10, null);
        boolean z10 = false;
        if (1 == i10) {
            p pVar = this.f١٧٥٨٧a;
            k kVar = (k) pVar.f١٧٥٩٢d.get(pVar.f١٧٥٩٥g);
            p pVar2 = this.f١٧٥٨٧a;
            GameInfo gameInfo = kVar.f١٧٥٨٢d;
            pVar2.f١٧٥٩٣e = gameInfo;
            pVar2.f١٧٥٩٦h.f(gameInfo.bigLoadingPic);
            p pVar3 = this.f١٧٥٨٧a;
            m mVar = pVar3.f١٧٥٩٤f;
            GameInfo gameInfo2 = pVar3.f١٧٥٩٣e;
            q0.f fVar = (q0.f) mVar;
            if (gameInfo2 != null) {
                q0.c cVar = fVar.f١٧٠٧٩a;
                xf.a aVar = gameInfo2.gameLargeModelCfg;
                cVar.D = aVar;
                n1.b bVar = cVar.f١٧٠٥٠B;
                if (bVar != null && aVar != null) {
                    bVar.f١٦١٥٨m = aVar.a;
                    bVar.f١٦١٥٩n = aVar.c;
                }
                cVar.f١٧٠٥٧g = gameInfo2;
                pf.u uVar = cVar.f١٧٠٧١u;
                String str2 = gameInfo2.dynamicConfig;
                uVar.getClass();
                LogUtils.file("SudFSMMGStateHandlerImpl", "setDynamicConfigJson dynamicConfig = " + str2);
                SudLogger.d(pf.u.n, "setDynamicConfigJson dynamicConfig = " + str2);
                uVar.h = str2;
                q0.c cVar2 = fVar.f١٧٠٧٩a;
                pf.u uVar2 = cVar2.f١٧٠٧١u;
                String str3 = cVar2.f١٧٠٥١a.authorizationSecret;
                uVar2.getClass();
                if (str3 != null && str3.length() > 0) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("authorization_secret", str3);
                        uVar2.i = jSONObject.toString();
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
                int i11 = gameInfo2.engine;
                if (1 == i11) {
                    q0.c cVar3 = fVar.f١٧٠٧٩a;
                    q0.c cVar4 = fVar.f١٧٠٧٩a;
                    cVar3.f١٧٠٦٣m = new g1.h(cVar4.f١٧٠٥٢b, cVar4.f١٧٠٥٣c, cVar4.f١٧٠٥٥e, cVar4.f١٧٠٦٤n, cVar4.f١٧٠٧١u);
                    int i12 = e.d.f١٣٧٢٣f;
                    if (i12 != 4 && i12 != 3) {
                        g1.h.f١٤٣٨٤m = false;
                    } else {
                        g1.h.f١٤٣٨٤m = true;
                    }
                } else if (5 == i11) {
                    fVar.f١٧٠٧٩a.A = e.d.f();
                    q0.c cVar5 = fVar.f١٧٠٧٩a;
                    SudLogger.d(q0.c.F, "isOpenUnityMultiProcess:" + cVar5.A);
                    LogUtils.file("ProxySudFSTAPPImpl", "isOpenUnityMultiProcess:" + cVar5.A);
                    if (cVar5.A) {
                        fVar.f١٧٠٧٩a.f١٧٠٦٣m = new l3.a();
                    } else {
                        fVar.f١٧٠٧٩a.f١٧٠٦٣m = new k3.a();
                    }
                }
            } else {
                fVar.getClass();
            }
        }
        p pVar4 = this.f١٧٥٨٧a;
        int i13 = pVar4.f١٧٥٩٥g + 1;
        pVar4.f١٧٥٩٥g = i13;
        if (i13 >= pVar4.f١٧٥٩٢d.size()) {
            LogUtils.file("SudGameLoadingModel", "loading finish");
            SudLogger.d(p.f١٧٥٨٨i, "loading finish");
            Context context = this.f١٧٥٨٧a.f١٧٥٨٩a;
            if (context != null) {
                c(context.getString(R.string.fsm_mgp_game_loading_stage_loadPackage_launch_game));
            }
            if (this.f١٧٥٨٧a.f١٧٥٩٦h != null) {
                LogUtils.file("SudGameLoadingNormalViewModel", "loading complete");
                SudLogger.d(e.f١٧٥٤٥v, "loading complete");
            }
            p pVar5 = this.f١٧٥٨٧a;
            m mVar2 = pVar5.f١٧٥٩٤f;
            GameInfo gameInfo3 = pVar5.f١٧٥٩٣e;
            q0.f fVar2 = (q0.f) mVar2;
            if (gameInfo3 != null) {
                q0.c cVar6 = fVar2.f١٧٠٧٩a;
                String str4 = gameInfo3.gamePath;
                cVar6.f١٧٠٧٤x = gameInfo3;
                cVar6.f١٧٠٧٥y = str4;
                LogUtils.file("ProxySudFSTAPPImpl", "_startGame");
                String str5 = q0.c.F;
                SudLogger.d(str5, "proxy _startGame");
                if (!cVar6.f١٧٠٦١k && cVar6.f١٧٠٥٧g != null && (dVar = cVar6.f١٧٠٦٣m) != null) {
                    dVar.a(cVar6.f١٧٠٧٣w);
                    int i14 = gameInfo3.engine;
                    if (1 == i14) {
                        cVar6.f١٧٠٦٣m.b(gameInfo3, str4);
                    } else if (5 == i14) {
                        SudLogger.d(str5, "isOpenUnityMultiProcess:" + cVar6.A);
                        LogUtils.file("ProxySudFSTAPPImpl", "isOpenUnityMultiProcess:" + cVar6.A);
                        if (cVar6.A) {
                            cVar6.f١٧٠٧٣w.f١٩٠٧٢o = true;
                            cVar6.f١٧٠٦٣m.b(gameInfo3, str4);
                        } else {
                            cVar6.f١٧٠٧٣w.f١٩٠٧٢o = false;
                            cVar6.f١٧٠٦٣m.b(gameInfo3, str4);
                        }
                    } else {
                        return;
                    }
                    if (e.d.f١٣٧٢٣f == 2) {
                        View inflate = LayoutInflater.from(cVar6.f١٧٠٥٢b).inflate(R.layout.fsm_mgp_game_running_sud_test_logo, (ViewGroup) null);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388693);
                        float f10 = 10;
                        layoutParams.setMargins(0, 0, (int) ((cVar6.f١٧٠٥٢b.getResources().getDisplayMetrics().density * f10) + 0.5f), (int) ((f10 * cVar6.f١٧٠٥٢b.getResources().getDisplayMetrics().density) + 0.5f));
                        inflate.setLayoutParams(layoutParams);
                        TextView textView = (TextView) inflate.findViewById(R.id.fsm_mgp_game_running_only_test);
                        String str6 = e.d.f١٣٧٢١d;
                        if (str6 != null && str6.substring(0, 2).equals("zh")) {
                            if (e.d.f١٣٧٢١d.equals("zh-CN")) {
                                str = "仅供测试";
                            } else {
                                str = "僅供測試";
                            }
                        } else {
                            str = "Only Test";
                        }
                        textView.setText(str);
                        cVar6.f١٧٠٦٤n.addView(inflate);
                    }
                    y0.e eVar = cVar6.f١٧٠٧٣w;
                    eVar.getClass();
                    LogUtils.file("LoadGameStatsManager", "onStartGame");
                    eVar.f١٩٠٦٣f = true;
                    eVar.e(true);
                    if (cVar6.C == null) {
                        xf.a aVar2 = gameInfo3.gameLargeModelCfg;
                        if (aVar2 != null) {
                            z10 = aVar2.b;
                        }
                        if (z10) {
                            g.g gVar = new g.g(e.d.f١٣٧٢٤g, cVar6.f١٧٠٥٣c, cVar6.f١٧٠٥٤d, cVar6.f١٧٠٥٥e, new q0.b(cVar6));
                            cVar6.C = gVar;
                            SudLogger.d(gVar.f١٤٣٢٨a, "start curIsRunning:" + gVar.f١٤٣٣٣f.get());
                            LogUtils.file("SudGIPWebSocket", "start curIsRunning:" + gVar.f١٤٣٣٣f.get());
                            if (!gVar.f١٤٣٣٣f.get()) {
                                gVar.f١٤٣٣٣f.set(true);
                                gVar.a();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            fVar2.getClass();
            return;
        }
        p pVar6 = this.f١٧٥٨٧a;
        j jVar = (j) pVar6.f١٧٥٩٢d.get(pVar6.f١٧٥٩٥g);
        p pVar7 = this.f١٧٥٨٧a;
        jVar.a(pVar7.f١٧٥٩٣e, pVar7.f١٧٥٩٠b, pVar7.f١٧٥٩١c);
    }

    public final void b(int i10, int i11, String str) {
        String str2;
        LogUtils.file("SudGameLoadingModel", "loading failed=" + str);
        SudLogger.d(p.f١٧٥٨٨i, "loading failed=" + str);
        e eVar = this.f١٧٥٨٧a.f١٧٥٩٦h;
        if (eVar != null) {
            if (d1.a.f١٣٥٤٠a) {
                TextView textView = eVar.f١٧٥٥٤k;
                StringBuilder sb = new StringBuilder();
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (i10 != 4) {
                                if (i10 != 5) {
                                    str2 = Constants.NULL_VERSION_ID;
                                } else {
                                    str2 = "LoadGame";
                                }
                            } else {
                                str2 = "LoadPlugin";
                            }
                        } else {
                            str2 = "LoadPackage";
                        }
                    } else {
                        str2 = "LoadCore";
                    }
                } else {
                    str2 = "GetMGInfo";
                }
                sb.append(str2);
                sb.append(" ");
                sb.append(str);
                textView.setText(sb.toString());
            }
            eVar.f١٧٥٨٥a.f١٧٠٧٨a.b(2, i11, eVar.f١٧٥٤٦c, false);
            eVar.g();
            eVar.a();
            eVar.c(i11, true, eVar.f١٧٥٤٧d, false);
            if (!eVar.f١٧٥٦٢s) {
                eVar.f١٧٥٥٠g.setVisibility(0);
            }
            q0.c cVar = eVar.f١٧٥٨٥a.f١٧٠٧٨a;
            cVar.f١٧٠٥٩i = true;
            y0.e eVar2 = cVar.f١٧٠٧٣w;
            eVar2.f١٩٠٦٧j.stop();
            eVar2.f١٩٠٦٨k.stop();
            eVar2.f١٩٠٦٩l.stop();
            eVar2.a();
            f.a aVar = eVar2.f١٩٠٥٨a;
            if (aVar != null) {
                aVar.f١٤٠٠٢e = i11;
            }
            if (aVar != null && str != null) {
                aVar.f١٤٠٠٣f = str;
            }
            eVar2.h();
        }
    }

    public final void c(String str) {
        e eVar = this.f١٧٥٨٧a.f١٧٥٩٦h;
        if (eVar != null) {
            if (d1.a.f١٣٥٤٠a) {
                eVar.f١٧٥٥٤k.setText(str);
            }
            eVar.f١٧٥٨٦b = str;
        }
    }
}
