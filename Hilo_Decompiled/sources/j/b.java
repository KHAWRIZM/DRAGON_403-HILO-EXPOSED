package j;

import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.internal.security.CertificateUtil;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;
import tech.sud.runtime.a.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b implements a.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f١٤٩٨٣a;

    public b(d dVar) {
        this.f١٤٩٨٣a = dVar;
    }

    public final void a(String str) {
        q0.a aVar;
        if (o.b.f١٦٤٠٨a != null) {
            LogUtils.file(3, "WXGame", "触发了：onGameANRDetected");
            if (g1.h.f١٤٣٨٤m) {
                SudLogger.w("WXGame", "触发了：onGameANRDetected");
            }
        }
        g1.b bVar = this.f١٤٩٨٣a.f١٤٩٩٣h;
        if (bVar != null) {
            StringBuilder sb = new StringBuilder("onGameANRDetected 调用栈为 \n");
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            StringBuilder sb2 = new StringBuilder();
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb2.append("at ");
                sb2.append(stackTraceElement.getClassName());
                sb2.append(InstructionFileId.DOT);
                sb2.append(stackTraceElement.getMethodName());
                sb2.append("(");
                sb2.append(stackTraceElement.getFileName());
                sb2.append(CertificateUtil.DELIMITER);
                sb2.append(stackTraceElement.getLineNumber());
                sb2.append(")\n");
            }
            sb.append(sb2.toString());
            LogUtils.file("SUDRealSudFSTAPPImpl", sb.toString());
            pf.u uVar = bVar.f١٤٣٧٧a.f١٤٣٩٢h;
            if (uVar != null && (aVar = uVar.m) != null) {
                q0.c cVar = aVar.f١٧٠٤٨b;
                y0.e eVar = cVar.f١٧٠٧٣w;
                String str2 = cVar.f١٧٠٥٤d;
                long j10 = cVar.f١٧٠٥٥e;
                eVar.getClass();
                f.a aVar2 = new f.a("onGameANRDetected");
                if (str2 != null) {
                    aVar2.f١٤٠٠٧j.put("room_id", str2);
                }
                aVar2.f١٤٠٠٤g = String.valueOf(j10);
                String str3 = aVar2.f١٤٠٠٠c;
                ThreadUtils.postUITask(new f.b(aVar2.toString(), true, aVar2.f١٣٩٩٨a, aVar2.f١٤٠٠٢e));
                ExecutorService executorService = fd.d.a;
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("logId", str3);
                        jSONObject.put("mgId", j10);
                        d0.a.a("TechSudMGPGlobal.sp").c("key_upload_anr_log_info", jSONObject.toString(), true);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                    fd.d.b(j10, 1, str3);
                }
            }
        }
    }
}
