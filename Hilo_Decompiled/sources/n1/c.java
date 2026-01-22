package n1;

import e.d;
import j1.q;
import org.json.JSONArray;
import org.json.JSONObject;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c implements q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f١٦١٦١a;

    public c(b bVar) {
        this.f١٦١٦١a = bVar;
    }

    @Override // j1.q
    public final void a() {
        SudLogger.d(this.f١٦١٦١a.f١٦١٤٦a, "onRecognizeSuccess:");
        LogUtils.file("AiAgentImpl", "onRecognizeSuccess:");
    }

    @Override // j1.q
    public final void b() {
        LogUtils.file("AiAgentImpl", "db asr client onClosed");
        SudLogger.d(this.f١٦١٦١a.f١٦١٤٦a, "db asr client onClosed");
        this.f١٦١٦١a.a();
    }

    @Override // j1.q
    public final void c(Throwable th) {
        LogUtils.file("AiAgentImpl", "db asr onFailure:" + LogUtils.getErrorInfo(th));
        SudLogger.d(this.f١٦١٦١a.f١٦١٤٦a, "db asr onFailure:" + LogUtils.getErrorInfo(th));
        b bVar = this.f١٦١٦١a;
        bVar.f١٦١٥٦k = true;
        bVar.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // j1.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(boolean z10, String str, String str2, long j10, long j11) {
        yf.c cVar;
        y0.b bVar;
        JSONObject optJSONObject;
        String str3 = "onText: definite:" + z10 + " text:" + str + " audioStartTime:" + j10 + " audioEndTime:" + j11;
        LogUtils.file("AiAgentImpl", str3);
        SudLogger.d(this.f١٦١٦١a.f١٦١٤٦a, str3);
        b bVar2 = this.f١٦١٦١a;
        if (z10) {
            try {
                optJSONObject = new JSONObject(str2).optJSONObject("result");
            } catch (Exception e10) {
                LogUtils.file("AiAgentImpl", "parserResponse json:" + str2 + " error:" + LogUtils.getErrorInfo(e10));
            }
            if (optJSONObject != null) {
                cVar = new yf.c();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("additions");
                if (optJSONObject2 != null) {
                    cVar.c = optJSONObject2.optString("log_id");
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("utterances");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(0);
                    cVar.b = jSONObject.optLong("end_time");
                    long optLong = jSONObject.optLong("start_time");
                    cVar.d = optLong;
                    cVar.a = cVar.b - optLong;
                }
                cVar.e = j10;
                cVar.f = j11;
                if (bVar2.f١٦١٥٩n) {
                    long j12 = bVar2.f١٦١٤٧b;
                    String str4 = bVar2.f١٦١٤٨c;
                    String str5 = bVar2.f١٦١٤٩d;
                    String str6 = bVar2.f١٦١٥٠e;
                    String str7 = d.f١٣٧١٨a;
                    yf.b bVar3 = new yf.b();
                    bVar3.a = j12;
                    bVar3.b = str4;
                    bVar3.c = str5;
                    bVar3.d = str6;
                    bVar3.e = str;
                    bVar3.f = cVar;
                    d.f١٣٧١٩b.x(bVar3, new e.b());
                }
                bVar = bVar2.f١٦١٦٠o;
                if (bVar == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("content", str);
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    bVar.f١٩٠٥٥a.notifyStateChange("app_common_game_llm_asr_content", jSONObject2.toString(), null);
                    return;
                }
                return;
            }
            cVar = null;
            if (bVar2.f١٦١٥٩n) {
            }
            bVar = bVar2.f١٦١٦٠o;
            if (bVar == null) {
            }
        }
    }
}
