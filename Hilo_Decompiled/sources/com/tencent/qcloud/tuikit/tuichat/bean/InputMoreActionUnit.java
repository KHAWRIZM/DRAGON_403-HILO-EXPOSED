package com.tencent.qcloud.tuikit.tuichat.bean;

import android.view.View;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class InputMoreActionUnit {
    private int actionId;
    private ChatInfo chatInfo;
    private int iconResId;
    private int titleId;
    private View unitView;
    private int actionType = 0;
    private int priority = 0;
    private OnActionClickListener onClickListener = new OnActionClickListener();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class OnActionClickListener {
        public OnActionClickListener() {
        }

        public void onClick() {
            InputMoreActionUnit inputMoreActionUnit = InputMoreActionUnit.this;
            inputMoreActionUnit.onAction(inputMoreActionUnit.getChatId(), InputMoreActionUnit.this.getChatType());
        }
    }

    public int getActionId() {
        return this.actionId;
    }

    public int getActionType() {
        return this.actionType;
    }

    public String getChatId() {
        ChatInfo chatInfo = this.chatInfo;
        if (chatInfo != null) {
            return chatInfo.getId();
        }
        return null;
    }

    public int getChatType() {
        ChatInfo chatInfo = this.chatInfo;
        if (chatInfo != null) {
            return chatInfo.getType();
        }
        return 0;
    }

    public int getIconResId() {
        return this.iconResId;
    }

    public OnActionClickListener getOnClickListener() {
        return this.onClickListener;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getTitleId() {
        return this.titleId;
    }

    public View getUnitView() {
        return this.unitView;
    }

    public boolean isEnable(int i) {
        return true;
    }

    public void onAction(String str, int i) {
    }

    public void setActionId(int i) {
        this.actionId = i;
    }

    public void setActionType(int i) {
        this.actionType = i;
    }

    public void setChatInfo(ChatInfo chatInfo) {
        this.chatInfo = chatInfo;
    }

    public void setIconResId(int i) {
        this.iconResId = i;
    }

    public void setOnClickListener(OnActionClickListener onActionClickListener) {
        this.onClickListener = onActionClickListener;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setTitleId(int i) {
        this.titleId = i;
    }

    public void setUnitView(View view) {
        this.unitView = view;
    }
}
