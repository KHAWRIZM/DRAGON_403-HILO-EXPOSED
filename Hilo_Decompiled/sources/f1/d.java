package f1;

import android.text.TextUtils;
import j1.p;
import java.nio.ByteBuffer;
import tech.sud.gip.asr.base.BaseRealSudASRImpl;
import tech.sud.gip.asr.base.model.InitASRParamModel;
import tech.sud.gip.asr.base.utils.ByteArrayBlockingQueue;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.model.VolcCfg;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d extends BaseRealSudASRImpl {

    /* renamed from: a, reason: collision with root package name */
    public final String f١٤٠٤٠a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f١٤٠٤١b;

    /* renamed from: c, reason: collision with root package name */
    public p f١٤٠٤٢c;

    /* renamed from: d, reason: collision with root package name */
    public a f١٤٠٤٣d;

    /* renamed from: e, reason: collision with root package name */
    public final VolcCfg f١٤٠٤٤e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f١٤٠٤٥f;

    /* renamed from: g, reason: collision with root package name */
    public c f١٤٠٤٦g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f١٤٠٤٧h;

    public d(InitASRParamModel initASRParamModel, VolcCfg volcCfg) {
        super(initASRParamModel);
        String concat = "SudGIP ".concat(d.class.getSimpleName());
        this.f١٤٠٤٠a = concat;
        this.f١٤٠٤٤e = volcCfg;
        LogUtils.file("DoubaoRealSudASRImpl", "db asr init:");
        SudLogger.d(concat, "db asr init:");
    }

    public final void pushAudio(ByteBuffer byteBuffer, int i10) {
        if (byteBuffer != null && i10 > 0) {
            if (!this.f١٤٠٤١b && ((BaseRealSudASRImpl) this).isIntentRunning) {
                this.f١٤٠٤٥f = true;
                if (this.f١٤٠٤٦g == null) {
                    c cVar = new c(this);
                    this.f١٤٠٤٦g = cVar;
                    if (this.f١٤٠٤٧h) {
                        this.f١٤٠٤٧h = false;
                        ThreadUtils.postDelayedUITask(cVar, 5000L);
                    } else {
                        ThreadUtils.postUITask(cVar);
                    }
                }
            }
            if (this.f١٤٠٤٣d != null) {
                try {
                    byte[] bArr = new byte[i10];
                    byteBuffer.get(bArr, 0, i10);
                    a aVar = this.f١٤٠٤٣d;
                    aVar.getClass();
                    if (i10 != 0) {
                        aVar.f١٤٠٣٧a.offerBuffer(bArr);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void startASR(String str) {
        super.startASR(str);
        String str2 = "startASR:" + str + " currentIsRunning:" + this.f١٤٠٤١b + " isHavePcmData:" + this.f١٤٠٤٥f;
        LogUtils.file("DoubaoRealSudASRImpl", str2);
        SudLogger.d(this.f١٤٠٤٠a, str2);
        if (!this.f١٤٠٤١b && this.f١٤٠٤٥f) {
            this.f١٤٠٤١b = true;
            VolcCfg volcCfg = this.f١٤٠٤٤e;
            if (volcCfg == null) {
                SudLogger.d(this.f١٤٠٤٠a, "mDoubaoRtssCfg can not be empty");
                LogUtils.file("DoubaoRealSudASRImpl", "mDoubaoRtssCfg can not be empty");
                return;
            }
            if (!TextUtils.isEmpty(volcCfg.url) && !TextUtils.isEmpty(this.f١٤٠٤٤e.app_key) && !TextUtils.isEmpty(this.f١٤٠٤٤e.access_key)) {
                p pVar = this.f١٤٠٤٢c;
                if (pVar != null) {
                    pVar.b();
                }
                this.f١٤٠٤٢c = new p(null);
                j1.a aVar = new j1.a();
                VolcCfg volcCfg2 = this.f١٤٠٤٤e;
                if (volcCfg2 != null) {
                    aVar.f١٥١٣٤a = volcCfg2.async_url;
                    aVar.f١٥١٣٥b = volcCfg2.app_key;
                    aVar.f١٥١٣٦c = volcCfg2.access_key;
                    aVar.f١٥١٣٧d = volcCfg2.resource_id;
                    aVar.f١٥١٤١h = volcCfg2.model_name;
                    aVar.f١٥١٤٤k = volcCfg2.request_config;
                }
                aVar.f١٥١٣٨e = ((BaseRealSudASRImpl) this)._paramModel.userId;
                aVar.f١٥١٤٠g = str;
                a aVar2 = this.f١٤٠٤٣d;
                if (aVar2 != null) {
                    ByteArrayBlockingQueue byteArrayBlockingQueue = aVar2.f١٤٠٣٧a;
                    if (byteArrayBlockingQueue != null) {
                        byteArrayBlockingQueue.offer((byte) 0);
                        aVar2.f١٤٠٣٧a = null;
                    }
                    this.f١٤٠٤٣d = null;
                }
                a aVar3 = new a();
                this.f١٤٠٤٣d = aVar3;
                aVar.f١٥١٣٩f = aVar3;
                InitASRParamModel initASRParamModel = ((BaseRealSudASRImpl) this)._paramModel;
                aVar.f١٥١٤٢i = initASRParamModel.mgId;
                aVar.f١٥١٤٣j = initASRParamModel.roomId;
                this.f١٤٠٤٢c.c(new j1.b(aVar), new b(this));
                LogUtils.file("DoubaoRealSudASRImpl", "startAudioRecognize success ");
                SudLogger.d(this.f١٤٠٤٠a, "startAudioRecognize success ");
                return;
            }
            SudLogger.d(this.f١٤٠٤٠a, "url and app_key and access_key can not be empty");
            LogUtils.file("DoubaoRealSudASRImpl", "url and app_key and access_key can not be empty");
        }
    }

    public final void stopASR(boolean z10) {
        super.stopASR(z10);
        this.f١٤٠٤٥f = false;
        LogUtils.file("DoubaoRealSudASRImpl", "stopASR currentIsRunning:" + this.f١٤٠٤١b);
        SudLogger.d(this.f١٤٠٤٠a, "stopASR currentIsRunning:" + this.f١٤٠٤١b);
        if (this.f١٤٠٤١b) {
            this.f١٤٠٤١b = false;
            if (this.f١٤٠٤٢c != null) {
                a aVar = this.f١٤٠٤٣d;
                if (aVar != null) {
                    ByteArrayBlockingQueue byteArrayBlockingQueue = aVar.f١٤٠٣٧a;
                    if (byteArrayBlockingQueue != null) {
                        byteArrayBlockingQueue.offer((byte) 0);
                        aVar.f١٤٠٣٧a = null;
                    }
                    this.f١٤٠٤٣d = null;
                }
                p pVar = this.f١٤٠٤٢c;
                if (pVar != null) {
                    pVar.b();
                    this.f١٤٠٤٢c = null;
                    LogUtils.file("DoubaoRealSudASRImpl", "Continuous recognition stopped.");
                    SudLogger.d(this.f١٤٠٤٠a, "Continuous recognition stopped.");
                }
            }
        }
    }
}
