package com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces;

import android.view.View;
import com.tencent.qcloud.tuikit.tuichat.bean.message.QuoteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class OnItemClickListener {
    public void onMessageClick(View view, int i, TUIMessageBean tUIMessageBean) {
    }

    public void onMessageLongClick(View view, int i, TUIMessageBean tUIMessageBean) {
    }

    public void onReEditRevokeMessage(View view, int i, TUIMessageBean tUIMessageBean) {
    }

    public void onReactOnClick(String str, TUIMessageBean tUIMessageBean) {
    }

    public void onRecallClick(View view, int i, TUIMessageBean tUIMessageBean) {
    }

    public void onReplyDetailClick(TUIMessageBean tUIMessageBean) {
    }

    public void onReplyMessageClick(View view, int i, QuoteMessageBean quoteMessageBean) {
    }

    public void onSendFailBtnClick(View view, int i, TUIMessageBean tUIMessageBean) {
    }

    public void onTextSelected(View view, int i, TUIMessageBean tUIMessageBean) {
    }

    public void onTranslationLongClick(View view, int i, TUIMessageBean tUIMessageBean) {
    }

    public void onUserIconClick(View view, int i, TUIMessageBean tUIMessageBean) {
    }

    public void onUserIconLongClick(View view, int i, TUIMessageBean tUIMessageBean) {
    }
}
