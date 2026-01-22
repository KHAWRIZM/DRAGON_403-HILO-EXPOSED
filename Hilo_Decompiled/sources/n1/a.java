package n1;

import d.k;
import d.m;
import d.p;
import e.d;
import tech.sud.gip.asr.base.Sudif;
import tech.sud.gip.asr.base.utils.ByteArrayBlockingQueue;
import tech.sud.gip.core.model.VolcCfg;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f١٦١٤٥a;

    public a(b bVar) {
        this.f١٦١٤٥a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VolcCfg volcCfg;
        k kVar;
        m mVar;
        b bVar = this.f١٦١٤٥a;
        String str = bVar.f١٦١٥٢g;
        synchronized (bVar) {
            try {
                String str2 = "startASR:" + str + " currentIsRunning:" + bVar.f١٦١٥١f;
                LogUtils.file("AiAgentImpl", str2);
                SudLogger.d(bVar.f١٦١٤٦a, str2);
                if (!bVar.f١٦١٥١f) {
                    bVar.f١٦١٥١f = true;
                    p pVar = d.f١٣٧٢٢e;
                    if (pVar != null && (kVar = pVar.f١٣٥٣٧c) != null && (mVar = kVar.f١٣٥٢٣n) != null) {
                        volcCfg = mVar.f١٣٥٢٩a;
                    } else {
                        volcCfg = null;
                    }
                    if (volcCfg == null) {
                        LogUtils.file("AiAgentImpl", "无法开启asr识别，因为后台没有给volcCfg配置");
                    } else if (!volcCfg.canRecognitionLanguage(str)) {
                        LogUtils.file("AiAgentImpl", "无法开启asr识别，因为当前语言不在于后台给的语言配置列表当中");
                    } else {
                        j1.p pVar2 = bVar.f١٦١٥٣h;
                        if (pVar2 != null) {
                            pVar2.b();
                        }
                        bVar.f١٦١٥٣h = new j1.p(new Sudif(d.f١٣٧٢٤g));
                        j1.a aVar = new j1.a();
                        aVar.f١٥١٣٤a = volcCfg.async_url;
                        aVar.f١٥١٣٥b = volcCfg.app_key;
                        aVar.f١٥١٣٦c = volcCfg.access_key;
                        aVar.f١٥١٣٧d = volcCfg.resource_id;
                        aVar.f١٥١٤١h = volcCfg.model_name;
                        aVar.f١٥١٤٤k = volcCfg.request_config;
                        aVar.f١٥١٣٨e = bVar.f١٦١٤٩d;
                        f1.a aVar2 = bVar.f١٦١٥٤i;
                        if (aVar2 != null) {
                            ByteArrayBlockingQueue byteArrayBlockingQueue = aVar2.f١٤٠٣٧a;
                            if (byteArrayBlockingQueue != null) {
                                byteArrayBlockingQueue.offer((byte) 0);
                                aVar2.f١٤٠٣٧a = null;
                            }
                            bVar.f١٦١٥٤i = null;
                        }
                        f1.a aVar3 = new f1.a();
                        bVar.f١٦١٥٤i = aVar3;
                        aVar.f١٥١٣٩f = aVar3;
                        aVar.f١٥١٤٠g = str;
                        aVar.f١٥١٤٢i = bVar.f١٦١٤٧b;
                        aVar.f١٥١٤٣j = bVar.f١٦١٤٨c;
                        bVar.f١٦١٥٣h.c(new j1.b(aVar), new c(bVar));
                        LogUtils.file("AiAgentImpl", "startAudioRecognize success ");
                        SudLogger.d(bVar.f١٦١٤٦a, "startAudioRecognize success ");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f١٦١٤٥a.f١٦١٥٧l = null;
    }
}
