package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input;

import com.tencent.qcloud.tuicore.component.fragments.BaseFragment;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.IChatLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class BaseInputFragment extends BaseFragment {
    private IChatLayout mChatLayout;

    public IChatLayout getChatLayout() {
        return this.mChatLayout;
    }

    public BaseInputFragment setChatLayout(IChatLayout iChatLayout) {
        this.mChatLayout = iChatLayout;
        return this;
    }
}
