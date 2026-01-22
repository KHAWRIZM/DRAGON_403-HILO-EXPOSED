package b9;

import io.agora.rtc.Constants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class d extends k {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }

    @Override // b9.k
    public int b(int i10) {
        if (i10 <= 8) {
            return Constants.ERR_PUBLISH_STREAM_FORMAT_NOT_SUPPORTED;
        }
        return Constants.ERR_PUBLISH_STREAM_NOT_FOUND;
    }

    @Override // b9.k
    public int f() {
        return 10;
    }
}
