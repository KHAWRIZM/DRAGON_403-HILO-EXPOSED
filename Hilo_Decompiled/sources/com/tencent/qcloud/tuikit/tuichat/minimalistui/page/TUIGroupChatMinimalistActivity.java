package com.tencent.qcloud.tuikit.tuichat.minimalistui.page;

import android.os.Bundle;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TUIGroupChatMinimalistActivity extends TUIBaseChatMinimalistActivity {
    private static final String TAG = "TUIGroupChatMinimalistActivity";
    private TUIGroupChatMinimalistFragment chatFragment;
    private GroupChatPresenter presenter;

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIBaseChatMinimalistActivity
    public void initChat(ChatInfo chatInfo) {
        String str = TAG;
        TUIChatLog.i(str, "inti chat " + chatInfo);
        if (!TUIChatUtils.isGroupChat(chatInfo.getType())) {
            TUIChatLog.e(str, "init group chat failed , chatInfo = " + chatInfo);
            ToastUtil.toastShortMessage("init group chat failed.");
        }
        this.chatFragment = new TUIGroupChatMinimalistFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(TUIChatConstants.CHAT_INFO, (GroupInfo) chatInfo);
        this.chatFragment.setArguments(bundle);
        GroupChatPresenter groupChatPresenter = new GroupChatPresenter();
        this.presenter = groupChatPresenter;
        groupChatPresenter.initListener();
        this.chatFragment.setPresenter(this.presenter);
        getSupportFragmentManager().beginTransaction().replace(R.id.empty_view, this.chatFragment).commitAllowingStateLoss();
    }
}
