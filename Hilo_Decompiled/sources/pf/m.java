package pf;

import android.content.Context;
import java.lang.ref.WeakReference;
import tech.sud.gip.asr.base.BaseRealSudASRImpl;
import tech.sud.gip.asr.base.model.InitASRParamModel;
import tech.sud.gip.core.ISudFSMMG;
import tech.sud.mgp.SudMGPWrapper.state.SudMGPMGState;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class m implements d1.c {
    public final /* synthetic */ u a;

    public m(u uVar) {
        this.a = uVar;
    }

    public final void a(String str, String str2, String str3, String str4, g1.a aVar) {
        a1.b a;
        q0.a aVar2 = this.a.m;
        if (aVar2 != null && (((a = a1.b.a(str4)) != null && a.a) || aVar2.b.v != null)) {
            q0.c cVar = aVar2.b;
            if (cVar.v == null) {
                Context context = cVar.h;
                q0.c cVar2 = aVar2.a;
                String str5 = cVar.c;
                long j = cVar.e;
                String str6 = cVar.d;
                InitASRParamModel initASRParamModel = new InitASRParamModel();
                initASRParamModel.context = context;
                initASRParamModel.iSudFSTAPP = new WeakReference<>(cVar2);
                initASRParamModel.userId = str5;
                initASRParamModel.mgId = j;
                initASRParamModel.roomId = str6;
                cVar.v = new c1.a(initASRParamModel);
            }
            BaseRealSudASRImpl baseRealSudASRImpl = aVar2.b.v.a;
            if (baseRealSudASRImpl != null) {
                baseRealSudASRImpl.handleGameASR(str4);
            }
        }
        ISudFSMMG iSudFSMMG = (ISudFSMMG) this.a.c.get();
        if (iSudFSMMG != null) {
            iSudFSMMG.onGameStateChange(aVar, SudMGPMGState.MG_COMMON_GAME_ASR, str4);
        }
    }
}
