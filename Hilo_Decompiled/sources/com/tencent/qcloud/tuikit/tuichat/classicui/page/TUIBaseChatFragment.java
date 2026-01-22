package com.tencent.qcloud.tuikit.tuichat.classicui.page;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.c;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.fragments.BaseFragment;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CallingMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.DataStoreUtil;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import d5.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TUIBaseChatFragment extends BaseFragment {
    private static final String TAG = "TUIBaseChatFragment";
    protected View baseView;
    protected ChatView chatView;
    protected String mChatBackgroundThumbnailUrl;
    protected String mChatBackgroundUrl;
    private int mForwardMode;
    private List<TUIMessageBean> mForwardSelectMsgInfos = null;
    private boolean mOnlyForTranslation;
    private MessageRecyclerView messageRecyclerView;
    private int messageViewBackgroundHeight;
    protected TitleBarLayout titleBar;

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap zoomImg(Bitmap bitmap, int i, int i2) {
        Matrix matrix = new Matrix();
        matrix.postScale((i * 1.0f) / bitmap.getWidth(), (i2 * 1.0f) / bitmap.getHeight(), 0.0f, 0.0f);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
        new Canvas(createBitmap).drawBitmap(bitmap, matrix, new Paint());
        return createBitmap;
    }

    public ChatInfo getChatInfo() {
        return null;
    }

    public ChatPresenter getPresenter() {
        return null;
    }

    protected void initChatViewBackground() {
        if (getChatInfo() == null) {
            TUIChatLog.e(TAG, "initChatViewBackground getChatInfo is null");
        } else {
            DataStoreUtil.getInstance().getValueAsync(getChatInfo().getId(), new DataStoreUtil.GetResult<String>() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.TUIBaseChatFragment.6
                @Override // com.tencent.qcloud.tuikit.tuichat.util.DataStoreUtil.GetResult
                public void onFail() {
                    TUIChatLog.e(TUIBaseChatFragment.TAG, "initChatViewBackground onFail");
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.util.DataStoreUtil.GetResult
                public void onSuccess(String str) {
                    TUIBaseChatFragment.this.setChatViewBackground(str);
                }
            }, String.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        ChatView chatView = (ChatView) this.baseView.findViewById(R.id.chat_layout);
        this.chatView = chatView;
        chatView.initDefault();
        TitleBarLayout titleBar = this.chatView.getTitleBar();
        this.titleBar = titleBar;
        titleBar.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.TUIBaseChatFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((InputMethodManager) TUIBaseChatFragment.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(TUIBaseChatFragment.this.chatView.getWindowToken(), 0);
                TUIBaseChatFragment.this.getActivity().finish();
            }
        });
        this.chatView.setForwardSelectActivityListener(new ChatView.ForwardSelectActivityListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.TUIBaseChatFragment.2
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.ForwardSelectActivityListener
            public void onStartForwardSelectActivity(int i, List<TUIMessageBean> list, boolean z) {
                TUIBaseChatFragment.this.mForwardMode = i;
                TUIBaseChatFragment.this.mForwardSelectMsgInfos = list;
                TUIBaseChatFragment.this.mOnlyForTranslation = z;
                Bundle bundle = new Bundle();
                bundle.putInt(TUIChatConstants.FORWARD_MODE, i);
                TUICore.startActivity(TUIBaseChatFragment.this, "TUIForwardSelectActivity", bundle, 101);
            }
        });
        this.chatView.getMessageLayout().setOnItemClickListener(new OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.TUIBaseChatFragment.3
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
            public void onMessageLongClick(View view, int i, TUIMessageBean tUIMessageBean) {
                TUIChatLog.d(TUIBaseChatFragment.TAG, "chatfragment onTextSelected selectedText = ");
                TUIBaseChatFragment.this.chatView.getMessageLayout().showItemPopMenu(i - 1, tUIMessageBean, view);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
            public void onReEditRevokeMessage(View view, int i, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean == null) {
                    return;
                }
                int msgType = tUIMessageBean.getMsgType();
                if (msgType != 1) {
                    TUIChatLog.e(TUIBaseChatFragment.TAG, "error type: " + msgType);
                    return;
                }
                TUIBaseChatFragment.this.chatView.getInputLayout().appendText(tUIMessageBean.getV2TIMMessage().getTextElem().getText());
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
            public void onRecallClick(View view, int i, TUIMessageBean tUIMessageBean) {
                String str;
                if (tUIMessageBean == null) {
                    return;
                }
                int callType = ((CallingMessageBean) tUIMessageBean).getCallType();
                if (callType == 2) {
                    str = "video";
                } else if (callType == 1) {
                    str = TUIConstants.TUICalling.TYPE_AUDIO;
                } else {
                    str = "";
                }
                HashMap hashMap = new HashMap();
                hashMap.put(TUIConstants.TUICalling.PARAM_NAME_USERIDS, new String[]{tUIMessageBean.getUserId()});
                hashMap.put("type", str);
                TUICore.callService("TUICallingService", TUIConstants.TUICalling.METHOD_NAME_CALL, hashMap);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
            public void onTextSelected(View view, int i, TUIMessageBean tUIMessageBean) {
                TUIBaseChatFragment.this.chatView.getMessageLayout().setSelectedPosition(i);
                TUIBaseChatFragment.this.chatView.getMessageLayout().showItemPopMenu(i - 1, tUIMessageBean, view);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
            public void onTranslationLongClick(View view, int i, TUIMessageBean tUIMessageBean) {
                TUIBaseChatFragment.this.chatView.getMessageLayout().showTranslationItemPopMenu(i - 1, tUIMessageBean, view);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
            public void onUserIconClick(View view, int i, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean == null) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("chatId", tUIMessageBean.getSender());
                TUICore.startActivity("FriendProfileActivity", bundle);
            }
        });
        this.chatView.getInputLayout().setOnInputViewListener(new InputView.OnInputViewListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.TUIBaseChatFragment.4
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.OnInputViewListener
            public void onStartGroupMemberSelectActivity() {
                Bundle bundle = new Bundle();
                bundle.putString("group_id", TUIBaseChatFragment.this.getChatInfo().getId());
                TUICore.startActivity(TUIBaseChatFragment.this, "StartGroupMemberSelectActivity", bundle, 1);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.OnInputViewListener
            public void onUpdateChatBackground() {
                TUIBaseChatFragment tUIBaseChatFragment = TUIBaseChatFragment.this;
                tUIBaseChatFragment.setChatViewBackground(tUIBaseChatFragment.mChatBackgroundUrl);
            }
        });
        this.messageRecyclerView = this.chatView.getMessageLayout();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        List<TUIMessageBean> list;
        HashMap hashMap;
        String id2;
        String str;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == 3) {
            this.chatView.getInputLayout().updateInputText(intent.getStringArrayListExtra(TUIChatConstants.Selection.USER_NAMECARD_SELECT), intent.getStringArrayListExtra(TUIChatConstants.Selection.USER_ID_SELECT));
            return;
        }
        if (i == 101 && i2 == 101 && intent != null && (list = this.mForwardSelectMsgInfos) != null && !list.isEmpty() && (hashMap = (HashMap) intent.getSerializableExtra(TUIChatConstants.FORWARD_SELECT_CONVERSATION_KEY)) != null && !hashMap.isEmpty()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                boolean booleanValue = ((Boolean) entry.getValue()).booleanValue();
                String str2 = (String) entry.getKey();
                ChatInfo chatInfo = getChatInfo();
                if (chatInfo == null) {
                    return;
                }
                if (TUIChatUtils.isGroupChat(chatInfo.getType())) {
                    str = getString(R.string.forward_chats);
                } else {
                    String selfNickName = TUIConfig.getSelfNickName();
                    if (TextUtils.isEmpty(selfNickName)) {
                        selfNickName = TUILogin.getLoginUser();
                    }
                    if (!TextUtils.isEmpty(getChatInfo().getChatName())) {
                        id2 = getChatInfo().getChatName();
                    } else {
                        id2 = getChatInfo().getId();
                    }
                    str = selfNickName + getString(R.string.and_text) + id2 + getString(R.string.forward_chats_c2c);
                }
                String str3 = str;
                if (str2 != null && str2.equals(chatInfo.getId())) {
                    z = true;
                } else {
                    z = false;
                }
                getPresenter().forwardMessage(this.mForwardSelectMsgInfos, booleanValue, str2, str3, this.mForwardMode, z, this.mOnlyForTranslation, new IUIKitCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.TUIBaseChatFragment.5
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str4, int i3, String str5) {
                        TUIChatLog.v(TUIBaseChatFragment.TAG, "sendMessage fail:" + i3 + "=" + str5);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(TUIBaseChatFragment.this.getString(R.string.send_failed));
                        sb2.append(", ");
                        sb2.append(str5);
                        ToastUtil.toastLongMessage(sb2.toString());
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(Object obj) {
                        TUIChatLog.v(TUIBaseChatFragment.TAG, "sendMessage onSuccess:");
                    }
                });
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TUIChatLog.i(TAG, "oncreate view " + this);
        View inflate = layoutInflater.inflate(R.layout.chat_fragment, viewGroup, false);
        this.baseView = inflate;
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        ChatView chatView = this.chatView;
        if (chatView != null) {
            chatView.exitChat();
        }
    }

    public void onPause() {
        super.onPause();
        ChatView chatView = this.chatView;
        if (chatView != null) {
            if (chatView.getInputLayout() != null) {
                this.chatView.getInputLayout().setDraft();
            }
            if (getPresenter() != null) {
                getPresenter().setChatFragmentShow(false);
            }
        }
        AudioPlayer.getInstance().stopPlay();
    }

    public void onResume() {
        super.onResume();
        if (getPresenter() != null) {
            getPresenter().setChatFragmentShow(true);
        }
        initChatViewBackground();
    }

    protected void setChatViewBackground(String str) {
        String str2 = TAG;
        TUIChatLog.d(str2, "setChatViewBackground uri = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.chatView == null) {
            TUIChatLog.e(str2, "setChatViewBackground chatview is null");
            return;
        }
        if (this.messageRecyclerView == null) {
            TUIChatLog.e(str2, "setChatViewBackground messageRecyclerView is null");
            return;
        }
        String[] split = str.split(",");
        if (split.length > 0) {
            this.mChatBackgroundThumbnailUrl = split[0];
        }
        if (split.length > 1) {
            this.mChatBackgroundUrl = split[1];
        }
        if (TextUtils.equals(TUIConstants.TUIChat.CHAT_CONVERSATION_BACKGROUND_DEFAULT_URL, this.mChatBackgroundUrl)) {
            this.mChatBackgroundThumbnailUrl = TUIConstants.TUIChat.CHAT_CONVERSATION_BACKGROUND_DEFAULT_URL;
            this.messageRecyclerView.setBackgroundResource(R.color.chat_background_color);
        } else {
            this.messageRecyclerView.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.TUIBaseChatFragment.7
                @Override // java.lang.Runnable
                public void run() {
                    final int width = TUIBaseChatFragment.this.messageRecyclerView.getWidth();
                    int height = TUIBaseChatFragment.this.messageRecyclerView.getHeight();
                    if (height > TUIBaseChatFragment.this.messageViewBackgroundHeight) {
                        TUIBaseChatFragment.this.messageViewBackgroundHeight = height;
                    }
                    TUIChatLog.d(TUIBaseChatFragment.TAG, "messageRecyclerView  width = " + width + ", height = " + TUIBaseChatFragment.this.messageViewBackgroundHeight);
                    if (width != 0 && TUIBaseChatFragment.this.messageViewBackgroundHeight != 0) {
                        Glide.with(TUIBaseChatFragment.this.getContext()).b().K0(TUIBaseChatFragment.this.mChatBackgroundUrl).A0(new c(width, TUIBaseChatFragment.this.messageViewBackgroundHeight) { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.TUIBaseChatFragment.7.1
                            public void onLoadCleared(Drawable drawable) {
                            }

                            public void onResourceReady(Bitmap bitmap, b bVar) {
                                TUIChatLog.d(TUIBaseChatFragment.TAG, "messageRecyclerView onGlobalLayout url = " + TUIBaseChatFragment.this.mChatBackgroundUrl);
                                TUIBaseChatFragment tUIBaseChatFragment = TUIBaseChatFragment.this;
                                final Bitmap zoomImg = tUIBaseChatFragment.zoomImg(bitmap, width, tUIBaseChatFragment.messageViewBackgroundHeight);
                                TUIBaseChatFragment.this.messageRecyclerView.setBackground(new BitmapDrawable(TUIBaseChatFragment.this.getResources(), bitmap) { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.TUIBaseChatFragment.7.1.1
                                    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
                                    public void draw(Canvas canvas) {
                                        canvas.drawBitmap(zoomImg, canvas.getClipBounds(), canvas.getClipBounds(), (Paint) null);
                                    }
                                });
                            }
                        });
                    }
                }
            });
        }
    }
}
