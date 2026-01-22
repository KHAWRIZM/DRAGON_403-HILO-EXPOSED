package j;

import org.json.JSONException;
import org.json.JSONObject;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class n extends k {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ab  */
    @Override // j.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        pf.u uVar;
        d1.c cVar;
        p1.a aVar = (p1.a) this;
        String str6 = "";
        try {
            str = jSONObject.getString("cmd");
            try {
                str2 = jSONObject.getString("param");
                try {
                    str3 = jSONObject.getString("state");
                    try {
                        str6 = jSONObject.getJSONObject("dataJson").toString();
                    } catch (JSONException e10) {
                        e = e10;
                        e.printStackTrace();
                        String str7 = str6;
                        str4 = str;
                        String str8 = str2;
                        str5 = str3;
                        p1.b bVar = aVar.f١٦٨٤٢c;
                        g1.a aVar2 = new g1.a(str5, bVar.f١٦٨٤٥b);
                        String str9 = "handleCmd cmd = " + str4 + ", param = " + str8 + ", state = " + str5 + ", dataJson = " + str7;
                        LogUtils.file("SUDGameCustomCommandHandler", str9);
                        SudLogger.d(p1.b.f١٦٨٤٣c, str9);
                        uVar = bVar.f١٦٨٤٤a;
                        uVar.getClass();
                        if (str4.equals("game")) {
                        }
                        cVar = (d1.c) uVar.a.get(str5);
                        if (cVar != null) {
                        }
                    }
                } catch (JSONException e11) {
                    e = e11;
                    str3 = "";
                }
            } catch (JSONException e12) {
                e = e12;
                str2 = "";
                str3 = str2;
                e.printStackTrace();
                String str72 = str6;
                str4 = str;
                String str82 = str2;
                str5 = str3;
                p1.b bVar2 = aVar.f١٦٨٤٢c;
                g1.a aVar22 = new g1.a(str5, bVar2.f١٦٨٤٥b);
                String str92 = "handleCmd cmd = " + str4 + ", param = " + str82 + ", state = " + str5 + ", dataJson = " + str72;
                LogUtils.file("SUDGameCustomCommandHandler", str92);
                SudLogger.d(p1.b.f١٦٨٤٣c, str92);
                uVar = bVar2.f١٦٨٤٤a;
                uVar.getClass();
                if (str4.equals("game")) {
                }
                cVar = (d1.c) uVar.a.get(str5);
                if (cVar != null) {
                }
            }
        } catch (JSONException e13) {
            e = e13;
            str = "";
            str2 = str;
        }
        String str722 = str6;
        str4 = str;
        String str822 = str2;
        str5 = str3;
        p1.b bVar22 = aVar.f١٦٨٤٢c;
        g1.a aVar222 = new g1.a(str5, bVar22.f١٦٨٤٥b);
        String str922 = "handleCmd cmd = " + str4 + ", param = " + str822 + ", state = " + str5 + ", dataJson = " + str722;
        LogUtils.file("SUDGameCustomCommandHandler", str922);
        SudLogger.d(p1.b.f١٦٨٤٣c, str922);
        uVar = bVar22.f١٦٨٤٤a;
        uVar.getClass();
        if (str4.equals("game") && !str4.equals("player")) {
            try {
                aVar222.success(new JSONObject(d.a.b("cmd not equals game or player")).toString());
                return;
            } catch (JSONException unused) {
                return;
            }
        }
        cVar = (d1.c) uVar.a.get(str5);
        if (cVar != null) {
            cVar.a(str4, str822, str5, str722, aVar222);
        } else {
            uVar.a(str4, str822, str5, str722, aVar222);
        }
    }

    @Override // j.t
    public final void a() {
    }
}
