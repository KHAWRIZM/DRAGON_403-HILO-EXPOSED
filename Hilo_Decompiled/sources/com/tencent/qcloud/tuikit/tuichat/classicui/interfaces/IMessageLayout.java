package com.tencent.qcloud.tuikit.tuichat.classicui.interfaces;

import com.tencent.qcloud.tuikit.tuichat.classicui.component.popmenu.ChatPopMenu;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageAdapter;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface IMessageLayout extends IMessageProperties {
    void addPopAction(ChatPopMenu.ChatPopMenuAction chatPopMenuAction);

    OnItemClickListener getOnItemClickListener();

    List<ChatPopMenu.ChatPopMenuAction> getPopActions();

    void setAdapter(MessageAdapter messageAdapter);

    void setOnItemClickListener(OnItemClickListener onItemClickListener);
}
