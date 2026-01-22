package com.tencent.qcloud.tuikit.tuichat.presenter;

import android.text.TextUtils;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.model.ChatProvider;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ForwardPresenter extends ChatPresenter {
    public static final String TAG = "ForwardPresenter";
    private ChatInfo chatInfo;
    List<TUIMessageBean> loadedData = new ArrayList();
    private IMessageAdapter messageListAdapter;
    private final ChatProvider provider;

    public ForwardPresenter() {
        TUIChatLog.i(TAG, "ChatPresenter Init");
        this.provider = new ChatProvider();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMergeMessageDownloaded(List<TUIMessageBean> list) {
        this.loadedData.clear();
        this.loadedData.addAll(list);
        IMessageAdapter iMessageAdapter = this.messageListAdapter;
        if (iMessageAdapter != null) {
            iMessageAdapter.onDataSourceChanged(this.loadedData);
            this.messageListAdapter.onViewNeedRefresh(4, this.loadedData.size());
        }
    }

    public void downloadMergerMessage(MergeMessageBean mergeMessageBean) {
        if (mergeMessageBean != null) {
            if (mergeMessageBean.isLayersOverLimit()) {
                TUIChatLog.e(TAG, "merge message Layers Over Limit");
            } else {
                this.provider.downloadMergerMessage(mergeMessageBean, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ForwardPresenter.1
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str, int i, String str2) {
                        TUIChatLog.e(ForwardPresenter.TAG, "downloadMergerMessage error , code = " + i + "  message = " + str2);
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(final List<TUIMessageBean> list) {
                        ForwardPresenter.this.preProcessMessage(list, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ForwardPresenter.1.1
                            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                            public void onError(String str, int i, String str2) {
                                ForwardPresenter.this.onMergeMessageDownloaded(list);
                            }

                            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                            public void onSuccess(List<TUIMessageBean> list2) {
                                ForwardPresenter.this.onMergeMessageDownloaded(list2);
                            }
                        });
                    }
                });
            }
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public ChatInfo getChatInfo() {
        return this.chatInfo;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public void locateMessage(String str, IUIKitCallback<Void> iUIKitCallback) {
        for (TUIMessageBean tUIMessageBean : this.loadedData) {
            if (TextUtils.equals(str, tUIMessageBean.getId())) {
                updateAdapter(9, tUIMessageBean);
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
                return;
            }
        }
        TUIChatUtils.callbackOnError(iUIKitCallback, -1, "not find");
    }

    public void setChatInfo(ChatInfo chatInfo) {
        this.chatInfo = chatInfo;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public void setMessageListAdapter(IMessageAdapter iMessageAdapter) {
        this.messageListAdapter = iMessageAdapter;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    protected void updateAdapter(int i, TUIMessageBean tUIMessageBean) {
        IMessageAdapter iMessageAdapter = this.messageListAdapter;
        if (iMessageAdapter != null) {
            iMessageAdapter.onViewNeedRefresh(i, tUIMessageBean);
        }
    }
}
