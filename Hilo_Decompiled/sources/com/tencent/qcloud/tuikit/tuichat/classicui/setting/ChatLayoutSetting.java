package com.tencent.qcloud.tuikit.tuichat.classicui.setting;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.gson.d;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.CustomHelloMessage;
import com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ChatLayoutSetting {
    private static final String TAG = "ChatLayoutSetting";
    private String groupId;
    private Context mContext;

    public ChatLayoutSetting(Context context) {
        this.mContext = context;
    }

    public void customizeChatLayout(ChatView chatView) {
        ViewGroup customNoticeLayout = TUIChatConfigs.getConfigs().getNoticeLayoutConfig().getCustomNoticeLayout();
        FrameLayout customView = chatView.getCustomView();
        if (customNoticeLayout != null && customView.getVisibility() == 8) {
            ViewParent parent = customNoticeLayout.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeAllViews();
            }
            customView.addView(customNoticeLayout);
            customView.setVisibility(0);
        }
        chatView.getMessageLayout();
        InputView inputLayout = chatView.getInputLayout();
        InputMoreActionUnit inputMoreActionUnit = new InputMoreActionUnit() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.setting.ChatLayoutSetting.1
        };
        inputMoreActionUnit.setIconResId(R.drawable.custom);
        inputMoreActionUnit.setTitleId(R.string.test_custom_action);
        inputMoreActionUnit.setActionId(3);
        inputMoreActionUnit.setPriority(10);
        inputMoreActionUnit.setOnClickListener(new InputMoreActionUnit.OnActionClickListener(inputMoreActionUnit, chatView) { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.setting.ChatLayoutSetting.2
            final /* synthetic */ ChatView val$layout;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                this.val$layout = chatView;
                Objects.requireNonNull(inputMoreActionUnit);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit.OnActionClickListener
            public void onClick() {
                d dVar = new d();
                CustomHelloMessage customHelloMessage = new CustomHelloMessage();
                customHelloMessage.version = TUIChatConstants.version;
                String s = dVar.s(customHelloMessage);
                String str = customHelloMessage.text;
                this.val$layout.sendMessage(ChatMessageBuilder.buildCustomMessage(s, str, str.getBytes()), false);
            }
        });
        inputLayout.addAction(inputMoreActionUnit);
    }

    public void customizeMessageLayout(MessageRecyclerView messageRecyclerView) {
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
