package com.tencent.qcloud.tuikit.tuichat.minimalistui.page;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.c;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.component.fragments.BaseFragment;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.FileUtil;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CallingMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.CameraActivity;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.InputView;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.DataStoreUtil;
import com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import d5.b;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TUIBaseChatMinimalistFragment extends BaseFragment {
    public static final int REQUEST_CODE_PHOTO = 1012;
    private static final String TAG = "TUIBaseChatMinimalistFragment";
    public static TUIBaseChatMinimalistFragment fragment;
    protected View baseView;
    protected ChatView chatView;
    protected String mChatBackgroundThumbnailUrl;
    protected String mChatBackgroundUrl;
    private int mForwardMode;
    private List<TUIMessageBean> mForwardSelectMsgInfos = null;
    private boolean mOnlyForTranslation;
    private MessageRecyclerView messageRecyclerView;
    private int messageViewBackgroundHeight;

    private void onCaptureResult(Intent intent) {
        String str = TAG;
        TUIChatLog.i(str, "onSuccess: " + intent);
        Uri data = intent.getData();
        if (data == null) {
            TUIChatLog.e(str, "data is null");
            return;
        }
        if (TextUtils.isEmpty(data.toString())) {
            TUIChatLog.e(str, "uri is empty");
            return;
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(FileUtil.getFileExtensionFromUrl(FileUtil.getFileName(ServiceInitializer.getAppContext(), data)));
        if (TextUtils.isEmpty(mimeTypeFromExtension)) {
            TUIChatLog.e(str, "mimeType is empty.");
            return;
        }
        if (mimeTypeFromExtension.contains("video")) {
            TUIMessageBean buildVideoMessage = this.chatView.getInputLayout().buildVideoMessage(FileUtil.getPathFromUri(data));
            if (buildVideoMessage == null) {
                ToastUtil.toastShortMessage(getResources().getString(R.string.send_failed_file_not_exists));
                TUIChatLog.e(str, "start send video error data: " + data);
                return;
            }
            this.chatView.sendMessage(buildVideoMessage, false);
            this.chatView.getInputLayout().hideSoftInput();
            return;
        }
        if (mimeTypeFromExtension.contains("image")) {
            TUIMessageBean buildImageMessage = ChatMessageBuilder.buildImageMessage(data);
            if (buildImageMessage == null) {
                TUIChatLog.e(str, "start send image error data: " + data);
                ToastUtil.toastShortMessage(getResources().getString(R.string.send_failed_file_not_exists));
                return;
            }
            this.chatView.sendMessage(buildImageMessage, false);
            this.chatView.getInputLayout().hideSoftInput();
            return;
        }
        TUIChatLog.e(str, "Send photo or video failed , invalid mimeType : " + mimeTypeFromExtension);
    }

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
            DataStoreUtil.getInstance().getValueAsync(getChatInfo().getId(), new DataStoreUtil.GetResult<String>() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIBaseChatMinimalistFragment.6
                @Override // com.tencent.qcloud.tuikit.tuichat.util.DataStoreUtil.GetResult
                public void onFail() {
                    TUIChatLog.e(TUIBaseChatMinimalistFragment.TAG, "initChatViewBackground onFail");
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.util.DataStoreUtil.GetResult
                public void onSuccess(String str) {
                    TUIBaseChatMinimalistFragment.this.setChatViewBackground(str);
                }
            }, String.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        ChatView chatView = (ChatView) this.baseView.findViewById(R.id.chat_layout);
        this.chatView = chatView;
        chatView.initDefault();
        this.chatView.setOnBackClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIBaseChatMinimalistFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((InputMethodManager) TUIBaseChatMinimalistFragment.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(TUIBaseChatMinimalistFragment.this.chatView.getWindowToken(), 0);
                TUIBaseChatMinimalistFragment.this.getActivity().finish();
            }
        });
        this.chatView.setForwardSelectActivityListener(new ChatView.ForwardSelectActivityListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIBaseChatMinimalistFragment.2
            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.ForwardSelectActivityListener
            public void onStartForwardSelectActivity(int i, List<TUIMessageBean> list, boolean z) {
                TUIBaseChatMinimalistFragment.this.mForwardMode = i;
                TUIBaseChatMinimalistFragment.this.mForwardSelectMsgInfos = list;
                TUIBaseChatMinimalistFragment.this.mOnlyForTranslation = z;
                Bundle bundle = new Bundle();
                bundle.putInt(TUIChatConstants.FORWARD_MODE, i);
                TUICore.startActivity(TUIBaseChatMinimalistFragment.this, "TUIForwardSelectMinimalistActivity", bundle, 101);
            }
        });
        this.chatView.getMessageLayout().setOnItemClickListener(new OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIBaseChatMinimalistFragment.3
            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onMessageLongClick(View view, int i, TUIMessageBean tUIMessageBean) {
                TUIBaseChatMinimalistFragment.this.chatView.getMessageLayout().showItemPopMenu(tUIMessageBean, view);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onReEditRevokeMessage(View view, int i, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean == null) {
                    return;
                }
                int msgType = tUIMessageBean.getMsgType();
                if (msgType != 1) {
                    TUIChatLog.e(TUIBaseChatMinimalistFragment.TAG, "error type: " + msgType);
                    return;
                }
                TUIBaseChatMinimalistFragment.this.chatView.getInputLayout().appendText(tUIMessageBean.getV2TIMMessage().getTextElem().getText());
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
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

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onTextSelected(View view, int i, TUIMessageBean tUIMessageBean) {
                TUIBaseChatMinimalistFragment.this.chatView.getMessageLayout().setSelectedPosition(i);
                TUIBaseChatMinimalistFragment.this.chatView.getMessageLayout().showItemPopMenu(tUIMessageBean, view);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onTranslationLongClick(View view, int i, TUIMessageBean tUIMessageBean) {
                TUIBaseChatMinimalistFragment.this.chatView.getMessageLayout().showTranslationItemPopMenu(i - 1, tUIMessageBean, view);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onUserIconClick(View view, int i, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean == null) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("chatId", tUIMessageBean.getSender());
                TUICore.startActivity("FriendProfileMinimalistActivity", bundle);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onUserIconLongClick(View view, int i, TUIMessageBean tUIMessageBean) {
            }
        });
        this.chatView.getInputLayout().setOnInputViewListener(new InputView.OnInputViewListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIBaseChatMinimalistFragment.4
            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.InputView.OnInputViewListener
            public void onClickCapture() {
                TUIBaseChatMinimalistFragment.this.startCapture();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.InputView.OnInputViewListener
            public void onStartGroupMemberSelectActivity() {
                Bundle bundle = new Bundle();
                bundle.putString("group_id", TUIBaseChatMinimalistFragment.this.getChatInfo().getId());
                TUICore.startActivity(TUIBaseChatMinimalistFragment.this, "StartGroupMemberSelectActivity", bundle, 1);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.InputView.OnInputViewListener
            public void onUpdateChatBackground() {
                TUIBaseChatMinimalistFragment tUIBaseChatMinimalistFragment = TUIBaseChatMinimalistFragment.this;
                tUIBaseChatMinimalistFragment.setChatViewBackground(tUIBaseChatMinimalistFragment.mChatBackgroundUrl);
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
        if (i == 101 && i2 == 101) {
            if (intent != null && (list = this.mForwardSelectMsgInfos) != null && !list.isEmpty() && (hashMap = (HashMap) intent.getSerializableExtra(TUIChatConstants.FORWARD_SELECT_CONVERSATION_KEY)) != null && !hashMap.isEmpty()) {
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
                    getPresenter().forwardMessage(this.mForwardSelectMsgInfos, booleanValue, str2, str3, this.mForwardMode, z, false, new IUIKitCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIBaseChatMinimalistFragment.5
                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onError(String str4, int i3, String str5) {
                            TUIChatLog.v(TUIBaseChatMinimalistFragment.TAG, "sendMessage fail:" + i3 + "=" + str5);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(TUIBaseChatMinimalistFragment.this.getString(R.string.send_failed));
                            sb2.append(", ");
                            sb2.append(str5);
                            ToastUtil.toastLongMessage(sb2.toString());
                        }

                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onSuccess(Object obj) {
                            TUIChatLog.v(TUIBaseChatMinimalistFragment.TAG, "sendMessage onSuccess:");
                        }
                    });
                }
                return;
            }
            return;
        }
        if (i != 1012 || i2 != -1) {
            return;
        }
        onCaptureResult(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        fragment = this;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TUIChatLog.i(TAG, "oncreate view " + this);
        View inflate = layoutInflater.inflate(R.layout.chat_minimalist_fragment, viewGroup, false);
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
            this.messageRecyclerView.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIBaseChatMinimalistFragment.7
                @Override // java.lang.Runnable
                public void run() {
                    final int width = TUIBaseChatMinimalistFragment.this.messageRecyclerView.getWidth();
                    int height = TUIBaseChatMinimalistFragment.this.messageRecyclerView.getHeight();
                    if (height > TUIBaseChatMinimalistFragment.this.messageViewBackgroundHeight) {
                        TUIBaseChatMinimalistFragment.this.messageViewBackgroundHeight = height;
                    }
                    TUIChatLog.d(TUIBaseChatMinimalistFragment.TAG, "messageRecyclerView  width = " + width + ", height = " + TUIBaseChatMinimalistFragment.this.messageViewBackgroundHeight);
                    if (width != 0 && TUIBaseChatMinimalistFragment.this.messageViewBackgroundHeight != 0) {
                        Glide.with(TUIBaseChatMinimalistFragment.this.getContext()).b().K0(TUIBaseChatMinimalistFragment.this.mChatBackgroundUrl).A0(new c(width, TUIBaseChatMinimalistFragment.this.messageViewBackgroundHeight) { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIBaseChatMinimalistFragment.7.1
                            public void onLoadCleared(Drawable drawable) {
                            }

                            public void onResourceReady(Bitmap bitmap, b bVar) {
                                TUIChatLog.d(TUIBaseChatMinimalistFragment.TAG, "messageRecyclerView onGlobalLayout url = " + TUIBaseChatMinimalistFragment.this.mChatBackgroundUrl);
                                TUIBaseChatMinimalistFragment tUIBaseChatMinimalistFragment = TUIBaseChatMinimalistFragment.this;
                                final Bitmap zoomImg = tUIBaseChatMinimalistFragment.zoomImg(bitmap, width, tUIBaseChatMinimalistFragment.messageViewBackgroundHeight);
                                TUIBaseChatMinimalistFragment.this.messageRecyclerView.setBackground(new BitmapDrawable(TUIBaseChatMinimalistFragment.this.getResources(), bitmap) { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIBaseChatMinimalistFragment.7.1.1
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

    protected void startCapture() {
        PermissionHelper.requestPermission(2, new PermissionHelper.PermissionCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIBaseChatMinimalistFragment.8
            @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
            public void onDenied() {
                TUIChatLog.i(TUIBaseChatMinimalistFragment.TAG, "startCapture checkPermission failed");
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
            public void onGranted() {
                Intent intent = new Intent(TUIBaseChatMinimalistFragment.this.getContext(), (Class<?>) CameraActivity.class);
                intent.putExtra(TUIChatConstants.CAMERA_TYPE, 257);
                CameraActivity.mCallBack = new IUIKitCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIBaseChatMinimalistFragment.8.1
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str, int i, String str2) {
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(Object obj) {
                        TUIBaseChatMinimalistFragment.this.chatView.sendMessage(ChatMessageBuilder.buildImageMessage(Uri.fromFile(new File(obj.toString()))), false);
                        TUIBaseChatMinimalistFragment.this.chatView.getInputLayout().hideSoftInput();
                    }
                };
                TUIBaseChatMinimalistFragment.this.startActivityForResult(intent, 1012);
            }
        });
    }
}
