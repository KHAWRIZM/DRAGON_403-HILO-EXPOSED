package com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces;

import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface IMessageLayout extends IMessageProperties {
    void addPopAction(ChatPopActivity.ChatPopMenuAction chatPopMenuAction);

    OnItemClickListener getOnItemClickListener();

    List<ChatPopActivity.ChatPopMenuAction> getPopActions();

    void setAdapter(MessageAdapter messageAdapter);

    void setOnItemClickListener(OnItemClickListener onItemClickListener);
}
