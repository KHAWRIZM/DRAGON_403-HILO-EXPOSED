package com.tencent.qcloud.tuikit.tuichat.hilo;

import com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/tencent/qcloud/tuikit/tuichat/hilo/HiloChatStrangeView$initListener$4", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/StrangeInputView$ChatInputHandler;", "onInputAreaClick", "", "onUserTyping", "status", "", "curTime", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class HiloChatStrangeView$initListener$4 implements StrangeInputView.ChatInputHandler {
    final /* synthetic */ HiloChatStrangeView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HiloChatStrangeView$initListener$4(HiloChatStrangeView hiloChatStrangeView) {
        this.this$0 = hiloChatStrangeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r1 = r1.presenter;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void onInputAreaClick$lambda$0(HiloChatStrangeView hiloChatStrangeView) {
        ChatPresenter chatPresenter;
        ChatPresenter chatPresenter2;
        chatPresenter = hiloChatStrangeView.presenter;
        if (chatPresenter != null && chatPresenter2 != null) {
            chatPresenter2.scrollToNewestMessage();
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView.ChatInputHandler
    public void onInputAreaClick() {
        final HiloChatStrangeView hiloChatStrangeView = this.this$0;
        hiloChatStrangeView.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.u
            @Override // java.lang.Runnable
            public final void run() {
                HiloChatStrangeView$initListener$4.onInputAreaClick$lambda$0(HiloChatStrangeView.this);
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView.ChatInputHandler
    public void onUserTyping(boolean status, long curTime) {
    }
}
