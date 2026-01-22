package c0;

import tech.sud.gip.core.ai.ISudListenerAiCommon;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e implements i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f٥٦٣٩a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ISudListenerAiCommon f٥٦٤٠b;

    public e(String str, ISudListenerAiCommon iSudListenerAiCommon) {
        this.f٥٦٣٩a = str;
        this.f٥٦٤٠b = iSudListenerAiCommon;
    }

    @Override // c0.i
    public final void onCompleted(String str) {
        LogUtils.file("SudAiModelImpl", "aiCommon param:" + this.f٥٦٣٩a + " response:" + str);
        l.f٥٦٥٠b.remove(this);
        this.f٥٦٤٠b.onCompleted(str);
    }
}
