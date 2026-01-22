package c0;

import tech.sud.gip.core.ai.ISudListenerLoadModel;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class j implements ISudListenerLoadModel {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ISudListenerLoadModel f٥٦٤٨a;

    public j(ISudListenerLoadModel iSudListenerLoadModel) {
        this.f٥٦٤٨a = iSudListenerLoadModel;
    }

    public final void onCompleted(byte[] bArr) {
        int length;
        StringBuilder sb = new StringBuilder("loadModel onCompleted fileData size:");
        if (bArr == null) {
            length = 0;
        } else {
            length = bArr.length;
        }
        sb.append(length);
        LogUtils.file("SudAiModelImpl", sb.toString());
        l.f٥٦٥٠b.remove(this);
        this.f٥٦٤٨a.onCompleted(bArr);
    }

    public final void onFailure(int i10, String str) {
        LogUtils.file("SudAiModelImpl", "loadModel onFailure retCode:" + i10 + " retMsg:" + str);
        l.f٥٦٥٠b.remove(this);
        this.f٥٦٤٨a.onFailure(i10, str);
    }
}
