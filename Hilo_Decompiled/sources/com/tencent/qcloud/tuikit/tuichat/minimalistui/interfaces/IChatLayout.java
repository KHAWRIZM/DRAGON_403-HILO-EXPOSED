package com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces;

import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.component.noticelayout.NoticeLayout;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.InputView;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface IChatLayout {
    void exitChat();

    ChatInfo getChatInfo();

    InputView getInputLayout();

    MessageRecyclerView getMessageLayout();

    NoticeLayout getNoticeLayout();

    void initDefault();

    void loadMessages(int i);

    void sendMessage(TUIMessageBean tUIMessageBean, boolean z);

    void setChatInfo(ChatInfo chatInfo);
}
