package com.taobao.agoo;

import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class IListAliasCallback extends ICallback {
    @Override // com.taobao.agoo.ICallback
    public final void onSuccess() {
    }

    public abstract void onSuccess(List<String> list);
}
