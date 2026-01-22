package com.tencent.qcloud.tuikit.tuichat.hilo;

import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.component.progress.ProgressPresenter;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMCheckDataListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/tencent/qcloud/tuikit/tuichat/hilo/HiloChatStrangeView$sendMessage$1", "Lcom/tencent/qcloud/tuicore/component/interfaces/IUIKitCallback;", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "onSuccess", "", "data", "onError", "module", "", "errCode", "", "errMsg", "onProgress", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class HiloChatStrangeView$sendMessage$1 extends IUIKitCallback<TUIMessageBean> {
    final /* synthetic */ TUIMessageBean $msg;
    final /* synthetic */ HiloChatStrangeView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HiloChatStrangeView$sendMessage$1(HiloChatStrangeView hiloChatStrangeView, TUIMessageBean tUIMessageBean) {
        this.this$0 = hiloChatStrangeView;
        this.$msg = tUIMessageBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSuccess$lambda$0(HiloChatStrangeView hiloChatStrangeView, TUIMessageBean tUIMessageBean) {
        IMCheckDataListener iMCheckDataListener;
        MessageRecyclerView mMessageRecyclerView = hiloChatStrangeView.getMMessageRecyclerView();
        if (mMessageRecyclerView != null && (iMCheckDataListener = mMessageRecyclerView.mIMCheckDataListener) != null) {
            iMCheckDataListener.sendMessageSuccess(tUIMessageBean);
        }
        hiloChatStrangeView.scrollToEnd();
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
    public void onError(String module, int errCode, String errMsg) {
        TUIMessageBean tUIMessageBean;
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        String str = errCode + ", " + errMsg;
        if (errCode == 7013 && (tUIMessageBean = this.$msg) != null && tUIMessageBean.isNeedReadReceipt()) {
            str = this.this$0.getResources().getString(R.string.chat_message_read_receipt) + this.this$0.getResources().getString(com.tencent.qcloud.tuicore.R.string.TUIKitErrorUnsupporInterfaceSuffix);
        }
        ToastUtil.toastLongMessage(str);
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
    public void onProgress(Object data) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        ProgressPresenter progressPresenter = ProgressPresenter.getInstance();
        TUIMessageBean tUIMessageBean = this.$msg;
        if (tUIMessageBean != null) {
            str = tUIMessageBean.getId();
        } else {
            str = null;
        }
        progressPresenter.updateProgress(str, ((Integer) data).intValue());
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
    public void onSuccess(final TUIMessageBean data) {
        BackgroundTasks backgroundTasks = BackgroundTasks.getInstance();
        final HiloChatStrangeView hiloChatStrangeView = this.this$0;
        backgroundTasks.runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.v
            @Override // java.lang.Runnable
            public final void run() {
                HiloChatStrangeView$sendMessage$1.onSuccess$lambda$0(HiloChatStrangeView.this, data);
            }
        });
    }
}
