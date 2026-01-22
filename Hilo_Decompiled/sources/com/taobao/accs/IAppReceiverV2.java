package com.taobao.accs;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class IAppReceiverV2 extends IAppReceiverV1 {
    @Override // com.taobao.accs.IAppReceiverV1
    @Deprecated
    public void onBindApp(int i, String str) {
        onBindApp(i, "", str);
    }

    public abstract void onBindApp(int i, String str, String str2);

    @Override // com.taobao.accs.IAppReceiverV1, com.taobao.accs.IAppReceiver
    public void onBindUser(String str, int i) {
    }

    @Override // com.taobao.accs.IAppReceiverV1, com.taobao.accs.IAppReceiver
    public void onUnbindApp(int i) {
    }

    @Override // com.taobao.accs.IAppReceiverV1, com.taobao.accs.IAppReceiver
    public void onUnbindUser(int i) {
    }

    public void onBindUser(String str, int i, String str2) {
        onBindUser(str, i);
    }

    public void onUnbindApp(int i, String str) {
        onUnbindApp(i);
    }

    public void onUnbindUser(int i, String str) {
        onUnbindUser(i);
    }
}
