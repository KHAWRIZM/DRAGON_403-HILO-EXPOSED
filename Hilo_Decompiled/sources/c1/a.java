package c1;

import a1.e;
import d.i;
import d.k;
import d.l;
import d.m;
import d.p;
import e.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.json.JSONArray;
import tech.sud.gip.asr.base.BaseRealSudASRImpl;
import tech.sud.gip.asr.base.Sudif;
import tech.sud.gip.asr.base.Sudtry;
import tech.sud.gip.asr.base.model.InitASRParamModel;
import tech.sud.gip.core.TccRtssCfg;
import tech.sud.gip.core.model.VolcCfg;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a implements Sudtry {

    /* renamed from: c, reason: collision with root package name */
    public static final String f٥٦٥٤c = "SudGIP ".concat(a.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    public final BaseRealSudASRImpl f٥٦٥٥a;

    /* renamed from: b, reason: collision with root package name */
    public final e f٥٦٥٦b;

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0072, code lost:
    
        if (r4 != 4) goto L٤٧;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(InitASRParamModel initASRParamModel) {
        l lVar;
        i iVar;
        k kVar;
        BaseRealSudASRImpl baseRealSudASRImpl;
        l lVar2;
        TccRtssCfg tccRtssCfg;
        k kVar2;
        VolcCfg volcCfg;
        k kVar3;
        m mVar;
        e eVar = new e();
        this.f٥٦٥٦b = eVar;
        initASRParamModel.supportTextLanguageList = c();
        initASRParamModel.supportNumberLanguageList = a();
        int b10 = b();
        ArrayList a10 = d.a();
        String str = f٥٦٥٤c;
        SudLogger.d(str, "asrType:" + b10);
        SudLogger.d(str, "asrLoadList:" + a10);
        LogUtils.file("ProxyASRImpl", "asrType:" + b10);
        LogUtils.file("ProxyASRImpl", "asrLoadList:" + a10);
        eVar.f٩٢a = b10;
        BaseRealSudASRImpl baseRealSudASRImpl2 = null;
        if (b10 != 1) {
            if (b10 != 3) {
            }
        } else {
            p pVar = d.f١٣٧٢٢e;
            if (pVar != null && (kVar = pVar.f١٣٥٣٧c) != null) {
                lVar = kVar.f١٣٥١٤e;
            } else {
                lVar = null;
            }
            if (lVar != null && (iVar = lVar.f١٣٥٢٦a) != null) {
                try {
                    BaseRealSudASRImpl baseRealSudASRImpl3 = (BaseRealSudASRImpl) Class.forName("tech.sud.gip.asr.azure.AzureRealSudASRImpl").getDeclaredConstructor(String.class, String.class, InitASRParamModel.class).newInstance(iVar.f١٣٥٠٥a, iVar.f١٣٥٠٦b, initASRParamModel);
                    baseRealSudASRImpl3.setMatchASREvent(eVar);
                    baseRealSudASRImpl = baseRealSudASRImpl3;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    LogUtils.file("ProxyASRImpl", "not found azure asr impl");
                }
                baseRealSudASRImpl2 = baseRealSudASRImpl;
                this.f٥٦٥٥a = baseRealSudASRImpl2;
            }
            SudLogger.w(str, "asr ms cfg empty");
        }
        p pVar2 = d.f١٣٧٢٢e;
        if (pVar2 != null && (kVar2 = pVar2.f١٣٥٣٧c) != null) {
            lVar2 = kVar2.f١٣٥١٤e;
        } else {
            lVar2 = null;
        }
        if (lVar2 != null && (tccRtssCfg = lVar2.f١٣٥٢٨c) != null) {
            try {
                BaseRealSudASRImpl baseRealSudASRImpl4 = (BaseRealSudASRImpl) Class.forName("tech.sud.gip.asr.tx.TxRealSudASRImpl").getDeclaredConstructor(InitASRParamModel.class, TccRtssCfg.class).newInstance(initASRParamModel, tccRtssCfg);
                baseRealSudASRImpl4.setMatchASREvent(this.f٥٦٥٦b);
                baseRealSudASRImpl = baseRealSudASRImpl4;
                baseRealSudASRImpl2 = baseRealSudASRImpl;
            } catch (Exception e11) {
                e11.printStackTrace();
                LogUtils.file("ProxyASRImpl", "not found tx asr impl");
            }
            this.f٥٦٥٥a = baseRealSudASRImpl2;
        }
        LogUtils.file("ProxyASRImpl", "asr tx cfg empty");
        SudLogger.w(f٥٦٥٤c, "asr tx cfg empty");
        p pVar3 = d.f١٣٧٢٢e;
        if (pVar3 != null && (kVar3 = pVar3.f١٣٥٣٧c) != null && (mVar = kVar3.f١٣٥٢٣n) != null) {
            volcCfg = mVar.f١٣٥٢٩a;
        } else {
            volcCfg = null;
        }
        if (volcCfg != null) {
            "SudGIP ".concat(Sudif.class.getSimpleName());
            baseRealSudASRImpl2 = new f1.d(initASRParamModel, volcCfg);
            baseRealSudASRImpl2.setMatchASREvent(this.f٥٦٥٦b);
        } else {
            LogUtils.file("ProxyASRImpl", "asr tx cfg empty");
            SudLogger.w(f٥٦٥٤c, "asr tx cfg empty");
        }
        this.f٥٦٥٥a = baseRealSudASRImpl2;
    }

    public static JSONArray a() {
        k kVar;
        l lVar;
        i iVar;
        k kVar2;
        l lVar2;
        TccRtssCfg tccRtssCfg;
        int b10 = b();
        if (b10 != 1) {
            if (b10 != 3) {
                if (b10 != 4) {
                    return null;
                }
                return d.c();
            }
            p pVar = d.f١٣٧٢٢e;
            if (pVar != null && (kVar2 = pVar.f١٣٥٣٧c) != null && (lVar2 = kVar2.f١٣٥١٤e) != null && (tccRtssCfg = lVar2.f١٣٥٢٨c) != null) {
                return tccRtssCfg.asr_number_language_list;
            }
            try {
                return new JSONArray("[\"zh-CN\"]");
            } catch (Exception e10) {
                e10.printStackTrace();
                return new JSONArray();
            }
        }
        p pVar2 = d.f١٣٧٢٢e;
        if (pVar2 != null && (kVar = pVar2.f١٣٥٣٧c) != null && (lVar = kVar.f١٣٥١٤e) != null && (iVar = lVar.f١٣٥٢٦a) != null) {
            return iVar.f١٣٥٠٨d;
        }
        try {
            return new JSONArray("[\"zh-CN\"]");
        } catch (Exception e11) {
            e11.printStackTrace();
            return new JSONArray();
        }
    }

    public static int b() {
        ArrayList a10 = d.a();
        if (a10 != null && a10.size() != 0) {
            int size = a10.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = a10.get(i10);
                i10++;
                Integer num = (Integer) obj;
                if (num.intValue() == 1) {
                    Class.forName("tech.sud.gip.asr.azure.AzureRealSudASRImpl");
                    return 1;
                }
                if (num.intValue() == 3) {
                    Class.forName("tech.sud.gip.asr.tx.TxRealSudASRImpl");
                    return 3;
                }
            }
        }
        return -1;
    }

    public static JSONArray c() {
        k kVar;
        l lVar;
        i iVar;
        k kVar2;
        l lVar2;
        TccRtssCfg tccRtssCfg;
        int b10 = b();
        if (b10 != 1) {
            if (b10 != 3) {
                if (b10 != 4) {
                    return null;
                }
                return d.c();
            }
            p pVar = d.f١٣٧٢٢e;
            if (pVar != null && (kVar2 = pVar.f١٣٥٣٧c) != null && (lVar2 = kVar2.f١٣٥١٤e) != null && (tccRtssCfg = lVar2.f١٣٥٢٨c) != null) {
                return tccRtssCfg.asr_text_language_list;
            }
            try {
                return new JSONArray("[\"zh-CN\"]");
            } catch (Exception e10) {
                e10.printStackTrace();
                return new JSONArray();
            }
        }
        p pVar2 = d.f١٣٧٢٢e;
        if (pVar2 != null && (kVar = pVar2.f١٣٥٣٧c) != null && (lVar = kVar.f١٣٥١٤e) != null && (iVar = lVar.f١٣٥٢٦a) != null) {
            return iVar.f١٣٥٠٧c;
        }
        try {
            return new JSONArray("[\"zh-CN\"]");
        } catch (Exception e11) {
            e11.printStackTrace();
            return new JSONArray();
        }
    }

    public final void handleGameASR(String str) {
        BaseRealSudASRImpl baseRealSudASRImpl = this.f٥٦٥٥a;
        if (baseRealSudASRImpl != null) {
            baseRealSudASRImpl.handleGameASR(str);
        }
    }

    public final void pushAudio(ByteBuffer byteBuffer, int i10) {
        throw null;
    }

    public final void stopASR(boolean z10) {
        throw null;
    }
}
