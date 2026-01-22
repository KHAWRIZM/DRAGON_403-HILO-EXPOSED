package com.tencent.qcloud.tuikit.tuichat.interfaces;

import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface IMessageAdapter {
    void onDataSourceChanged(List<TUIMessageBean> list);

    void onScrollToEnd();

    void onViewNeedRefresh(int i, int i2);

    void onViewNeedRefresh(int i, TUIMessageBean tUIMessageBean);
}
