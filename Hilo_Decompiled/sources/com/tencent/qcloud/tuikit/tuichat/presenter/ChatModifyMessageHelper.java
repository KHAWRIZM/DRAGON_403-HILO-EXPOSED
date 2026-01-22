package com.tencent.qcloud.tuikit.tuichat.presenter;

import android.os.Handler;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.model.ChatProvider;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ChatModifyMessageHelper {
    private static final int RETRY_MAX_TIME = 3000;
    private static final int RETRY_MIN_TIME = 500;
    private static final int RETRY_TIMES = 3;
    private static final ChatModifyMessageHelper helper = new ChatModifyMessageHelper();
    private final Map<String, TUIMessageBean> cache = new HashMap();
    private final ChatProvider provider = new ChatProvider();
    private final Handler handler = new Handler();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static abstract class ModifyMessageTask {
        private final IUIKitCallback<TUIMessageBean> callback;
        private TUIMessageBean messageBean;
        private int retryTimes = 0;

        public ModifyMessageTask(TUIMessageBean tUIMessageBean, IUIKitCallback<TUIMessageBean> iUIKitCallback) {
            this.messageBean = tUIMessageBean;
            this.callback = iUIKitCallback;
        }

        public abstract TUIMessageBean packageMessage(TUIMessageBean tUIMessageBean);
    }

    private ChatModifyMessageHelper() {
        TUIChatService.getInstance().addC2CChatEventListener(new C2CChatEventListener() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatModifyMessageHelper.1
            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener
            public void onRecvMessageModified(TUIMessageBean tUIMessageBean) {
                ChatModifyMessageHelper.this.onUpdateCache(tUIMessageBean);
            }
        });
    }

    public static void enqueueTask(ModifyMessageTask modifyMessageTask) {
        enqueueTask(modifyMessageTask, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRetryDelay() {
        return new Random().nextInt(2501) + 500;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdateCache(TUIMessageBean tUIMessageBean) {
        if (this.cache.get(tUIMessageBean.getId()) != null) {
            this.cache.put(tUIMessageBean.getId(), tUIMessageBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void enqueueTask(final ModifyMessageTask modifyMessageTask, long j) {
        helper.handler.postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatModifyMessageHelper.2
            @Override // java.lang.Runnable
            public void run() {
                if (ModifyMessageTask.this.messageBean == null) {
                    TUIChatUtils.callbackOnError(ModifyMessageTask.this.callback, -1, "params error , message is null");
                    return;
                }
                TUIMessageBean tUIMessageBean = (TUIMessageBean) ChatModifyMessageHelper.helper.cache.get(ModifyMessageTask.this.messageBean.getId());
                if (tUIMessageBean != null) {
                    ModifyMessageTask.this.messageBean = tUIMessageBean;
                }
                ModifyMessageTask modifyMessageTask2 = ModifyMessageTask.this;
                TUIMessageBean packageMessage = modifyMessageTask2.packageMessage(modifyMessageTask2.messageBean);
                if (packageMessage == null) {
                    ChatModifyMessageHelper.helper.cache.remove(ModifyMessageTask.this.messageBean.getId());
                    TUIChatUtils.callbackOnError(ModifyMessageTask.this.callback, -1, "message is null");
                } else {
                    ChatModifyMessageHelper.helper.provider.modifyMessage(packageMessage, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatModifyMessageHelper.2.1
                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onError(int i, String str, TUIMessageBean tUIMessageBean2) {
                            ChatModifyMessageHelper.helper.cache.put(tUIMessageBean2.getId(), tUIMessageBean2);
                            if (ModifyMessageTask.this.retryTimes <= 3) {
                                int retryDelay = ChatModifyMessageHelper.helper.getRetryDelay();
                                ModifyMessageTask.this.retryTimes++;
                                ModifyMessageTask.this.messageBean = tUIMessageBean2;
                                ChatModifyMessageHelper.enqueueTask(ModifyMessageTask.this, retryDelay);
                                return;
                            }
                            ChatModifyMessageHelper.helper.cache.remove(ModifyMessageTask.this.messageBean.getId());
                            TUIChatUtils.callbackOnError(ModifyMessageTask.this.callback, i, str);
                        }

                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onSuccess(TUIMessageBean tUIMessageBean2) {
                            ChatModifyMessageHelper.helper.cache.remove(ModifyMessageTask.this.messageBean.getId());
                            TUIChatUtils.callbackOnSuccess(ModifyMessageTask.this.callback, tUIMessageBean2);
                        }
                    });
                }
            }
        }, j);
    }
}
