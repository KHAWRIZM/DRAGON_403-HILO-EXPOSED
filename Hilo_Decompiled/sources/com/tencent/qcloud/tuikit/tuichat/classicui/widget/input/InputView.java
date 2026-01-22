package com.tencent.qcloud.tuikit.tuichat.classicui.widget.input;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.google.gson.d;
import com.google.gson.r;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.FileUtil;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.DraftInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit;
import com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.CameraActivity;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.IChatLayout;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face.FaceFragment;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.inputmore.InputMoreFragment;
import com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder;
import com.tencent.qcloud.tuikit.tuichat.component.face.CustomFace;
import com.tencent.qcloud.tuikit.tuichat.component.face.Emoji;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class InputView extends LinearLayout implements View.OnClickListener, TextWatcher {
    protected static final int CALL_MEMBER_LIMIT = 8;
    private static final int STATE_ACTION_INPUT = 3;
    private static final int STATE_FACE_INPUT = 2;
    private static final int STATE_NONE_INPUT = -1;
    private static final int STATE_SOFT_INPUT = 0;
    private static final int STATE_VOICE_INPUT = 1;
    private static final String TAG = "InputView";
    private Map<String, String> atUserInfoMap;
    private String displayInputString;
    private boolean isQuoteModel;
    private boolean isReplyModel;
    private boolean isShowCustomFace;
    protected AppCompatActivity mActivity;
    private boolean mAudioCancel;
    protected boolean mAudioInputDisable;
    protected ImageView mAudioInputSwitchButton;
    private boolean mCaptureDisable;
    protected ChatInfo mChatInfo;
    private ChatInputHandler mChatInputHandler;
    private IChatLayout mChatLayout;
    private int mCurrentState;
    protected ImageView mEmojiInputButton;
    protected boolean mEmojiInputDisable;
    private FaceFragment mFaceFragment;
    private FragmentManager mFragmentManager;
    private String mInputContent;
    protected List<InputMoreActionUnit> mInputMoreActionList;
    protected List<InputMoreActionUnit> mInputMoreCustomActionList;
    private InputMoreFragment mInputMoreFragment;
    protected View mInputMoreLayout;
    protected View mInputMoreView;
    private boolean mIsSending;
    private int mLastMsgLineCount;
    private MessageHandler mMessageHandler;
    protected ImageView mMoreInputButton;
    protected boolean mMoreInputDisable;
    protected Object mMoreInputEvent;
    private OnInputViewListener mOnInputViewListener;
    private AlertDialog mPermissionDialog;
    protected Button mSendAudioButton;
    private boolean mSendEnable;
    private boolean mSendFileDisable;
    private boolean mSendPhotoDisable;
    protected TextView mSendTextButton;
    private float mStartRecordY;
    protected TIMMentionEditText mTextInput;
    private boolean mVideoRecordDisable;
    private ChatPresenter presenter;
    private ImageView quoteCloseBtn;
    private View quotePreviewBar;
    private TextView quoteTv;
    private ImageView replyCloseBtn;
    private View replyPreviewBar;
    private ReplyPreviewBean replyPreviewBean;
    private TextView replyTv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView$14, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class AnonymousClass14 implements PermissionHelper.PermissionCallback {
        AnonymousClass14() {
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
        public void onDenied() {
            TUIChatLog.i(InputView.TAG, "startVideoRecord checkPermission failed");
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
        public void onGranted() {
            PermissionHelper.requestPermission(1, new PermissionHelper.PermissionCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.14.1
                @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                public void onDenied() {
                    TUIChatLog.i(InputView.TAG, "startVideoRecord checkPermission failed");
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                public void onGranted() {
                    Intent intent = new Intent(InputView.this.getContext(), (Class<?>) CameraActivity.class);
                    intent.putExtra(TUIChatConstants.CAMERA_TYPE, 258);
                    CameraActivity.mCallBack = new IUIKitCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.14.1.1
                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onError(String str, int i, String str2) {
                        }

                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onSuccess(Object obj) {
                            Intent intent2 = (Intent) obj;
                            TUIMessageBean buildVideoMessage = ChatMessageBuilder.buildVideoMessage(intent2.getStringExtra(TUIChatConstants.CAMERA_IMAGE_PATH), intent2.getStringExtra(TUIChatConstants.CAMERA_VIDEO_PATH), intent2.getIntExtra(TUIChatConstants.IMAGE_WIDTH, 0), intent2.getIntExtra(TUIChatConstants.IMAGE_HEIGHT, 0), intent2.getLongExtra(TUIChatConstants.VIDEO_TIME, 0L));
                            if (InputView.this.mMessageHandler != null) {
                                InputView.this.mMessageHandler.sendMessage(buildVideoMessage);
                                InputView.this.hideSoftInput();
                            }
                        }
                    };
                    InputView.this.setOpenPhotoCallback();
                    InputView.this.mInputMoreFragment.startActivityForResult(intent, 1012);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView$29, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class AnonymousClass29 extends InputMoreActionUnit.OnActionClickListener {
        final /* synthetic */ InputMoreActionUnit val$videoUnit;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass29(InputMoreActionUnit inputMoreActionUnit, InputMoreActionUnit inputMoreActionUnit2) {
            super();
            this.val$videoUnit = inputMoreActionUnit2;
            Objects.requireNonNull(inputMoreActionUnit);
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit.OnActionClickListener
        public void onClick() {
            PermissionHelper.requestPermission(1, new PermissionHelper.PermissionCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.29.1
                @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                public void onDenied() {
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                public void onGranted() {
                    PermissionHelper.requestPermission(2, new PermissionHelper.PermissionCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.29.1.1
                        @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                        public void onDenied() {
                        }

                        @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                        public void onGranted() {
                            AnonymousClass29 anonymousClass29 = AnonymousClass29.this;
                            InputView.this.onCustomActionClick(anonymousClass29.val$videoUnit.getActionId());
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView$5, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class AnonymousClass5 implements View.OnTouchListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, final MotionEvent motionEvent) {
            TUIChatLog.i(InputView.TAG, "mSendAudioButton onTouch action:" + motionEvent.getAction());
            PermissionHelper.requestPermission(1, new PermissionHelper.PermissionCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.5.1
                @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                public void onDenied() {
                    TUIChatLog.i(InputView.TAG, "audio record checkPermission failed");
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                public void onGranted() {
                    int action = motionEvent.getAction();
                    boolean z = true;
                    if (action == 0) {
                        InputView.this.mAudioCancel = true;
                        InputView.this.mStartRecordY = motionEvent.getY();
                        if (InputView.this.mChatInputHandler != null) {
                            InputView.this.mChatInputHandler.onRecordStatusChanged(1);
                        }
                        InputView.this.mSendAudioButton.setText(ServiceInitializer.getAppContext().getString(R.string.release_end));
                        AudioRecorder.getInstance().startRecord(new AudioRecorder.Callback() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.5.1.1
                            @Override // com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder.Callback
                            public void onCompletion(Boolean bool) {
                                InputView.this.recordComplete(bool.booleanValue());
                            }

                            @Override // com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder.Callback
                            public void onVoiceDb(double d) {
                            }
                        });
                        return;
                    }
                    if (action != 1) {
                        if (action != 2) {
                            if (action != 3) {
                                return;
                            }
                        } else {
                            if (motionEvent.getY() - InputView.this.mStartRecordY < -100.0f) {
                                InputView.this.mAudioCancel = true;
                                if (InputView.this.mChatInputHandler != null) {
                                    InputView.this.mChatInputHandler.onRecordStatusChanged(3);
                                }
                            } else {
                                if (InputView.this.mAudioCancel && InputView.this.mChatInputHandler != null) {
                                    InputView.this.mChatInputHandler.onRecordStatusChanged(1);
                                }
                                InputView.this.mAudioCancel = false;
                            }
                            InputView.this.mSendAudioButton.setText(ServiceInitializer.getAppContext().getString(R.string.release_end));
                            return;
                        }
                    }
                    InputView inputView = InputView.this;
                    if (motionEvent.getY() - InputView.this.mStartRecordY >= -100.0f) {
                        z = false;
                    }
                    inputView.mAudioCancel = z;
                    if (InputView.this.mChatInputHandler != null) {
                        InputView.this.mChatInputHandler.onRecordStatusChanged(2);
                    }
                    AudioRecorder.getInstance().stopRecord();
                    InputView.this.mSendAudioButton.setText(ServiceInitializer.getAppContext().getString(R.string.hold_say));
                }
            });
            return false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface ChatInputHandler {
        public static final int RECORD_CANCEL = 3;
        public static final int RECORD_FAILED = 5;
        public static final int RECORD_START = 1;
        public static final int RECORD_STOP = 2;
        public static final int RECORD_TOO_SHORT = 4;

        void onInputAreaClick();

        void onRecordStatusChanged(int i);

        void onUserTyping(boolean z, long j);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface MessageHandler {
        void scrollToEnd();

        void sendMessage(TUIMessageBean tUIMessageBean);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnInputViewListener {
        void onStartGroupMemberSelectActivity();

        void onUpdateChatBackground();
    }

    public InputView(Context context) {
        super(context);
        this.mIsSending = false;
        this.mInputMoreActionList = new ArrayList();
        this.mInputMoreCustomActionList = new ArrayList();
        this.atUserInfoMap = new HashMap();
        this.isReplyModel = false;
        this.isQuoteModel = false;
        this.isShowCustomFace = true;
        initViews();
    }

    private void addActionsFromListeners() {
        if (this.mChatInfo == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("chatId", this.mChatInfo.getId());
        hashMap.put(TUIConstants.TUIChat.CHAT_NAME, this.mChatInfo.getChatName());
        hashMap.put(TUIConstants.TUIChat.CHAT_TYPE, Integer.valueOf(this.mChatInfo.getType()));
        hashMap.put("context", getContext());
        Map<String, Object> extensionInfo = TUICore.getExtensionInfo(TUIConstants.TUIChat.EXTENSION_INPUT_MORE_CUSTOM_MESSAGE, hashMap);
        if (extensionInfo != null) {
            Integer num = (Integer) extensionInfo.get(TUIConstants.TUIChat.INPUT_MORE_ICON);
            Integer num2 = (Integer) extensionInfo.get("title");
            Integer num3 = (Integer) extensionInfo.get(TUIConstants.TUIChat.INPUT_MORE_ACTION_ID);
            InputMoreActionUnit inputMoreActionUnit = new InputMoreActionUnit();
            inputMoreActionUnit.setActionId(num3.intValue());
            inputMoreActionUnit.setIconResId(num.intValue());
            inputMoreActionUnit.setTitleId(num2.intValue());
            inputMoreActionUnit.setPriority(10);
            inputMoreActionUnit.setOnClickListener(new InputMoreActionUnit.OnActionClickListener(inputMoreActionUnit, inputMoreActionUnit) { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.27
                final /* synthetic */ InputMoreActionUnit val$unit;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                    this.val$unit = inputMoreActionUnit;
                    Objects.requireNonNull(inputMoreActionUnit);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit.OnActionClickListener
                public void onClick() {
                    InputView.this.onCustomActionClick(this.val$unit.getActionId());
                }
            });
            this.mInputMoreActionList.add(inputMoreActionUnit);
        }
        if (TUIChatUtils.isTopicGroup(this.mChatInfo.getId())) {
            return;
        }
        Map<String, Object> extensionInfo2 = TUICore.getExtensionInfo(TUIConstants.TUIChat.EXTENSION_INPUT_MORE_AUDIO_CALL, hashMap);
        if (extensionInfo2 != null) {
            View view = (View) extensionInfo2.get(TUIConstants.TUIChat.INPUT_MORE_VIEW);
            int intValue = ((Integer) extensionInfo2.get(TUIConstants.TUIChat.INPUT_MORE_ACTION_ID)).intValue();
            InputMoreActionUnit inputMoreActionUnit2 = new InputMoreActionUnit();
            inputMoreActionUnit2.setActionId(intValue);
            inputMoreActionUnit2.setUnitView(view);
            inputMoreActionUnit2.setPriority(2);
            inputMoreActionUnit2.setOnClickListener(new InputMoreActionUnit.OnActionClickListener(inputMoreActionUnit2, inputMoreActionUnit2) { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.28
                final /* synthetic */ InputMoreActionUnit val$audioUnit;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                    this.val$audioUnit = inputMoreActionUnit2;
                    Objects.requireNonNull(inputMoreActionUnit2);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit.OnActionClickListener
                public void onClick() {
                    PermissionHelper.requestPermission(1, new PermissionHelper.PermissionCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.28.1
                        @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                        public void onDenied() {
                        }

                        @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                        public void onGranted() {
                            AnonymousClass28 anonymousClass28 = AnonymousClass28.this;
                            InputView.this.onCustomActionClick(anonymousClass28.val$audioUnit.getActionId());
                        }
                    });
                }
            });
            this.mInputMoreActionList.add(inputMoreActionUnit2);
        }
        Map<String, Object> extensionInfo3 = TUICore.getExtensionInfo(TUIConstants.TUIChat.EXTENSION_INPUT_MORE_VIDEO_CALL, hashMap);
        if (extensionInfo3 != null) {
            View view2 = (View) extensionInfo3.get(TUIConstants.TUIChat.INPUT_MORE_VIEW);
            int intValue2 = ((Integer) extensionInfo3.get(TUIConstants.TUIChat.INPUT_MORE_ACTION_ID)).intValue();
            InputMoreActionUnit inputMoreActionUnit3 = new InputMoreActionUnit();
            inputMoreActionUnit3.setActionId(intValue2);
            inputMoreActionUnit3.setUnitView(view2);
            inputMoreActionUnit3.setPriority(1);
            inputMoreActionUnit3.setOnClickListener(new AnonymousClass29(inputMoreActionUnit3, inputMoreActionUnit3));
            this.mInputMoreActionList.add(inputMoreActionUnit3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TUIMessageBean buildVideoMessage(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L, 1);
                if (frameAtTime == null) {
                    TUIChatLog.e(TAG, "buildVideoMessage() bitmap is null");
                    try {
                        mediaMetadataRetriever.release();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
                TUIMessageBean buildVideoMessage = ChatMessageBuilder.buildVideoMessage(FileUtil.saveBitmap("JCamera", frameAtTime), str, frameAtTime.getWidth(), frameAtTime.getHeight(), Long.valueOf(extractMetadata).longValue());
                try {
                    mediaMetadataRetriever.release();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return buildVideoMessage;
            } catch (Exception e3) {
                TUIChatLog.e(TAG, "MediaMetadataRetriever exception " + e3);
                try {
                    mediaMetadataRetriever.release();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return null;
            }
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Map<String, String> getDisplayAtNameMap(List<String> list, List<String> list2) {
        String str;
        int i;
        String str2;
        HashMap hashMap = new HashMap();
        TIMMentionEditText tIMMentionEditText = this.mTextInput;
        if (tIMMentionEditText != null) {
            Editable text = tIMMentionEditText.getText();
            int selectionEnd = this.mTextInput.getSelectionEnd();
            if (text != null && selectionEnd > 0) {
                String obj = text.toString();
                if (!TextUtils.isEmpty(obj)) {
                    str = obj.substring(selectionEnd - 1, selectionEnd);
                    for (i = 0; i < list2.size(); i++) {
                        if (i == 0) {
                            if (TextUtils.isEmpty(list.get(0))) {
                                hashMap.put(str + list2.get(0) + " ", list2.get(0));
                            } else {
                                hashMap.put(str + list.get(0) + " ", list2.get(0));
                            }
                        } else {
                            if (TextUtils.isEmpty(list.get(i))) {
                                str2 = "@" + list2.get(i);
                            } else {
                                str2 = "@" + list.get(i);
                            }
                            hashMap.put(str2 + " ", list2.get(i));
                        }
                    }
                    return hashMap;
                }
            }
        }
        str = "@";
        while (i < list2.size()) {
        }
        return hashMap;
    }

    private int getNavigateBarHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        if (i2 > i) {
            return i2 - i;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideInputMoreLayout() {
        this.mInputMoreView.setVisibility(8);
    }

    private void initViews() {
        AppCompatActivity context = getContext();
        this.mActivity = context;
        View.inflate(context, R.layout.chat_input_layout, this);
        this.mInputMoreView = findViewById(R.id.more_groups);
        this.mSendAudioButton = (Button) findViewById(R.id.chat_voice_input);
        this.mAudioInputSwitchButton = (ImageView) findViewById(R.id.voice_input_switch);
        this.mEmojiInputButton = (ImageView) findViewById(R.id.face_btn);
        this.mMoreInputButton = (ImageView) findViewById(R.id.more_btn);
        this.mSendTextButton = (TextView) findViewById(R.id.send_btn);
        this.mTextInput = (TIMMentionEditText) findViewById(R.id.chat_message_input);
        View findViewById = findViewById(R.id.reply_preview_bar);
        this.replyPreviewBar = findViewById;
        int i = R.id.reply_text;
        this.replyTv = (TextView) findViewById.findViewById(i);
        View view = this.replyPreviewBar;
        int i2 = R.id.reply_close_btn;
        this.replyCloseBtn = (ImageView) view.findViewById(i2);
        View findViewById2 = findViewById(R.id.quote_preview_bar);
        this.quotePreviewBar = findViewById2;
        this.quoteTv = (TextView) findViewById2.findViewById(i);
        this.quoteCloseBtn = (ImageView) this.quotePreviewBar.findViewById(i2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.chat_input_icon_size);
        ViewGroup.LayoutParams layoutParams = this.mEmojiInputButton.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = dimensionPixelSize;
        this.mEmojiInputButton.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.mAudioInputSwitchButton.getLayoutParams();
        layoutParams2.width = dimensionPixelSize;
        layoutParams2.height = dimensionPixelSize;
        this.mAudioInputSwitchButton.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.mMoreInputButton.getLayoutParams();
        layoutParams3.width = dimensionPixelSize;
        layoutParams3.height = dimensionPixelSize;
        this.mMoreInputButton.setLayoutParams(layoutParams3);
        this.mIsSending = false;
        init();
    }

    private boolean isSoftInputShown() {
        View decorView = ((Activity) getContext()).getWindow().getDecorView();
        int height = decorView.getHeight();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        if ((height - rect.bottom) - getNavigateBarHeight() >= 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCustomActionClick(int i) {
        String str;
        if (i != 1 && i != 2) {
            HashMap hashMap = new HashMap();
            hashMap.put(TUIConstants.TUIChat.INPUT_MORE_ACTION_ID, Integer.valueOf(i));
            hashMap.put("chatId", this.mChatInfo.getId());
            hashMap.put(TUIConstants.TUIChat.CHAT_NAME, this.mChatInfo.getChatName());
            hashMap.put(TUIConstants.TUIChat.CHAT_TYPE, Integer.valueOf(this.mChatInfo.getType()));
            TUICore.notifyEvent(TUIConstants.TUIChat.EVENT_KEY_INPUT_MORE, TUIConstants.TUIChat.EVENT_SUB_KEY_ON_CLICK, hashMap);
            return;
        }
        if (i == 1) {
            str = TUIConstants.TUICalling.TYPE_AUDIO;
        } else {
            str = "video";
        }
        if (TUIChatUtils.isGroupChat(getChatInfo().getType())) {
            Bundle bundle = new Bundle();
            bundle.putString("groupId", getChatInfo().getId());
            bundle.putString("type", str);
            bundle.putString("group_id", getChatInfo().getId());
            bundle.putBoolean("isSelectForCall", true);
            bundle.putInt("limit", 8);
            TUICore.startActivity(getContext(), "StartGroupMemberSelectActivity", bundle, 11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordComplete(boolean z) {
        int duration = AudioRecorder.getInstance().getDuration();
        TUIChatLog.i(TAG, "recordComplete duration:" + duration);
        ChatInputHandler chatInputHandler = this.mChatInputHandler;
        if (chatInputHandler != null) {
            if (z && duration != 0) {
                if (this.mAudioCancel) {
                    chatInputHandler.onRecordStatusChanged(3);
                    return;
                } else {
                    if (duration < 1000) {
                        chatInputHandler.onRecordStatusChanged(4);
                        return;
                    }
                    chatInputHandler.onRecordStatusChanged(2);
                }
            } else {
                chatInputHandler.onRecordStatusChanged(5);
                return;
            }
        }
        MessageHandler messageHandler = this.mMessageHandler;
        if (messageHandler != null && z) {
            messageHandler.sendMessage(ChatMessageBuilder.buildAudioMessage(AudioRecorder.getInstance().getPath(), duration));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOpenPhotoCallback() {
        this.mInputMoreFragment.setCallback(new IUIKitCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.12
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                TUIChatLog.i(InputView.TAG, "errCode: " + i);
                ToastUtil.toastLongMessage(str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Object obj) {
                TUIChatLog.i(InputView.TAG, "onSuccess: " + obj);
                if (obj == null) {
                    TUIChatLog.e(InputView.TAG, "data is null");
                    return;
                }
                if (TextUtils.isEmpty(obj.toString())) {
                    TUIChatLog.e(InputView.TAG, "uri is empty");
                    return;
                }
                Uri uri = (Uri) obj;
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(FileUtil.getFileExtensionFromUrl(FileUtil.getFileName(ServiceInitializer.getAppContext(), uri)));
                if (TextUtils.isEmpty(mimeTypeFromExtension)) {
                    TUIChatLog.e(InputView.TAG, "mimeType is empty.");
                    return;
                }
                if (mimeTypeFromExtension.contains("video")) {
                    TUIMessageBean buildVideoMessage = InputView.this.buildVideoMessage(FileUtil.getPathFromUri(uri));
                    if (buildVideoMessage == null) {
                        ToastUtil.toastShortMessage(InputView.this.getResources().getString(R.string.send_failed_file_not_exists));
                        TUIChatLog.e(InputView.TAG, "start send video error data: " + obj);
                        return;
                    }
                    if (InputView.this.mMessageHandler != null) {
                        InputView.this.mMessageHandler.sendMessage(buildVideoMessage);
                        InputView.this.hideSoftInput();
                        return;
                    }
                    return;
                }
                if (!mimeTypeFromExtension.contains("image")) {
                    TUIChatLog.e(InputView.TAG, "Send photo or video failed , invalid mimeType : " + mimeTypeFromExtension);
                    return;
                }
                TUIMessageBean buildImageMessage = ChatMessageBuilder.buildImageMessage(uri);
                if (buildImageMessage == null) {
                    TUIChatLog.e(InputView.TAG, "start send image error data: " + obj);
                    ToastUtil.toastShortMessage(InputView.this.getResources().getString(R.string.send_failed_file_not_exists));
                    return;
                }
                if (InputView.this.mMessageHandler != null) {
                    InputView.this.mMessageHandler.sendMessage(buildImageMessage);
                    InputView.this.hideSoftInput();
                }
            }
        });
    }

    private void showCustomInputMoreFragment() {
        TUIChatLog.i(TAG, "showCustomInputMoreFragment");
        if (this.mFragmentManager == null) {
            this.mFragmentManager = this.mActivity.getSupportFragmentManager();
        }
        BaseInputFragment baseInputFragment = (BaseInputFragment) this.mMoreInputEvent;
        hideSoftInput();
        this.mInputMoreView.setVisibility(0);
        this.mFragmentManager.beginTransaction().replace(R.id.more_groups, baseInputFragment).commitAllowingStateLoss();
        if (this.mChatInputHandler != null) {
            postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.20
                @Override // java.lang.Runnable
                public void run() {
                    InputView.this.mChatInputHandler.onInputAreaClick();
                }
            }, 100L);
        }
    }

    private void showFaceViewGroup() {
        TUIChatLog.i(TAG, "showFaceViewGroup");
        if (this.mFragmentManager == null) {
            this.mFragmentManager = this.mActivity.getSupportFragmentManager();
        }
        if (this.mFaceFragment == null) {
            this.mFaceFragment = new FaceFragment();
        }
        hideSoftInput();
        this.mInputMoreView.setVisibility(0);
        this.mTextInput.requestFocus();
        this.mFaceFragment.setShowCustomFace(this.isShowCustomFace);
        this.mFaceFragment.setListener(new FaceFragment.OnEmojiClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.18
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face.FaceFragment.OnEmojiClickListener
            public void onCustomFaceClick(int i, CustomFace customFace) {
                InputView.this.mMessageHandler.sendMessage(ChatMessageBuilder.buildFaceMessage(i, customFace.getFaceKey()));
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face.FaceFragment.OnEmojiClickListener
            public void onEmojiClick(Emoji emoji) {
                int selectionStart = InputView.this.mTextInput.getSelectionStart();
                Editable text = InputView.this.mTextInput.getText();
                text.insert(selectionStart, emoji.getFaceKey());
                FaceManager.handlerEmojiText(InputView.this.mTextInput, text, true);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face.FaceFragment.OnEmojiClickListener
            public void onEmojiDelete() {
                int selectionStart = InputView.this.mTextInput.getSelectionStart();
                Editable text = InputView.this.mTextInput.getText();
                if (selectionStart <= 0) {
                    return;
                }
                int i = selectionStart - 1;
                if (text.charAt(i) == ']') {
                    int i2 = selectionStart - 2;
                    while (true) {
                        if (i2 < 0) {
                            break;
                        }
                        if (text.charAt(i2) == '[') {
                            if (FaceManager.isFaceChar(text.subSequence(i2, selectionStart).toString())) {
                                text.delete(i2, selectionStart);
                                return;
                            }
                        } else {
                            i2--;
                        }
                    }
                }
                text.delete(i, selectionStart);
            }
        });
        this.mFragmentManager.beginTransaction().replace(R.id.more_groups, this.mFaceFragment).commitAllowingStateLoss();
        if (this.mChatInputHandler != null) {
            postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.19
                @Override // java.lang.Runnable
                public void run() {
                    InputView.this.mChatInputHandler.onInputAreaClick();
                }
            }, 100L);
        }
    }

    private void showInputMoreLayout() {
        TUIChatLog.i(TAG, "showInputMoreLayout");
        if (this.mFragmentManager == null) {
            this.mFragmentManager = this.mActivity.getSupportFragmentManager();
        }
        if (this.mInputMoreFragment == null) {
            this.mInputMoreFragment = new InputMoreFragment();
        }
        assembleActions();
        this.mInputMoreFragment.setActions(this.mInputMoreActionList);
        hideSoftInput();
        this.mInputMoreView.setVisibility(0);
        this.mFragmentManager.beginTransaction().replace(R.id.more_groups, this.mInputMoreFragment).commitAllowingStateLoss();
        if (this.mChatInputHandler != null) {
            postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.21
                @Override // java.lang.Runnable
                public void run() {
                    InputView.this.mChatInputHandler.onInputAreaClick();
                }
            }, 100L);
        }
    }

    private void updateAtUserInfoMap(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.displayInputString = "";
        for (int i = 0; i < arrayList2.size(); i++) {
            this.atUserInfoMap.put(arrayList2.get(i), arrayList.get(i));
            if (TextUtils.isEmpty(arrayList.get(i))) {
                this.displayInputString += arrayList2.get(i);
                this.displayInputString += " ";
                this.displayInputString += "@";
            } else {
                this.displayInputString += arrayList.get(i);
                this.displayInputString += " ";
                this.displayInputString += "@";
            }
        }
        if (!this.displayInputString.isEmpty()) {
            this.displayInputString = this.displayInputString.substring(0, r7.length() - 1);
        }
    }

    private void updateChatBackground() {
        OnInputViewListener onInputViewListener = this.mOnInputViewListener;
        if (onInputViewListener != null) {
            onInputViewListener.onUpdateChatBackground();
        }
    }

    public void addAction(InputMoreActionUnit inputMoreActionUnit) {
        this.mInputMoreCustomActionList.add(inputMoreActionUnit);
    }

    public void addInputText(String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            updateAtUserInfoMap(new ArrayList<String>(str) { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.9
                final /* synthetic */ String val$name;

                {
                    this.val$name = str;
                    add(str);
                }
            }, new ArrayList<String>(str2) { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.10
                final /* synthetic */ String val$id;

                {
                    this.val$id = str2;
                    add(str2);
                }
            });
            if (this.mTextInput != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("@" + this.displayInputString, str2);
                this.mTextInput.setMentionMap(hashMap);
                int selectionEnd = this.mTextInput.getSelectionEnd();
                if (selectionEnd != -1) {
                    String str3 = "@" + this.displayInputString;
                    FaceManager.handlerEmojiText(this.mTextInput, this.mTextInput.getText().insert(selectionEnd, str3).toString(), true);
                    this.mTextInput.setSelection(selectionEnd + str3.length());
                }
                showSoftInput();
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(editable.toString().trim())) {
            this.mSendEnable = false;
            showSendTextButton(8);
            showMoreInputButton(0);
            ChatInputHandler chatInputHandler = this.mChatInputHandler;
            if (chatInputHandler != null) {
                chatInputHandler.onUserTyping(false, V2TIMManager.getInstance().getServerTime());
            }
        } else {
            this.mSendEnable = true;
            showSendTextButton(0);
            showMoreInputButton(8);
            if (this.mTextInput.getLineCount() != this.mLastMsgLineCount) {
                this.mLastMsgLineCount = this.mTextInput.getLineCount();
                ChatInputHandler chatInputHandler2 = this.mChatInputHandler;
                if (chatInputHandler2 != null) {
                    chatInputHandler2.onInputAreaClick();
                }
            }
            if (!TextUtils.equals(this.mInputContent, this.mTextInput.getText().toString())) {
                TIMMentionEditText tIMMentionEditText = this.mTextInput;
                FaceManager.handlerEmojiText(tIMMentionEditText, tIMMentionEditText.getText(), true);
            }
        }
        ChatInputHandler chatInputHandler3 = this.mChatInputHandler;
        if (chatInputHandler3 != null && !this.mIsSending) {
            chatInputHandler3.onUserTyping(true, V2TIMManager.getInstance().getServerTime());
        }
        if (this.mIsSending) {
            this.mIsSending = false;
        }
    }

    public void appendText(String str) {
        if (this.mChatInfo == null) {
            TUIChatLog.e(TAG, "appendText error :  chatInfo is null");
            return;
        }
        TIMMentionEditText tIMMentionEditText = this.mTextInput;
        if (tIMMentionEditText == null) {
            TUIChatLog.e(TAG, "appendText error :  textInput is null");
            return;
        }
        this.mTextInput.setText(tIMMentionEditText.getText().toString() + str);
        TIMMentionEditText tIMMentionEditText2 = this.mTextInput;
        tIMMentionEditText2.setSelection(tIMMentionEditText2.getText().length());
    }

    protected void assembleActions() {
        this.mInputMoreActionList.clear();
        if (!this.mSendPhotoDisable) {
            InputMoreActionUnit inputMoreActionUnit = new InputMoreActionUnit() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.22
                @Override // com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit
                public void onAction(String str, int i) {
                    InputView.this.startSendPhoto();
                }
            };
            inputMoreActionUnit.setIconResId(R.drawable.ic_more_picture);
            inputMoreActionUnit.setTitleId(R.string.pic);
            this.mInputMoreActionList.add(inputMoreActionUnit);
        }
        if (!this.mCaptureDisable) {
            InputMoreActionUnit inputMoreActionUnit2 = new InputMoreActionUnit() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.23
                @Override // com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit
                public void onAction(String str, int i) {
                    InputView.this.startCapture();
                }
            };
            inputMoreActionUnit2.setIconResId(R.drawable.ic_more_camera);
            inputMoreActionUnit2.setTitleId(R.string.photo);
            this.mInputMoreActionList.add(inputMoreActionUnit2);
        }
        if (!this.mVideoRecordDisable) {
            InputMoreActionUnit inputMoreActionUnit3 = new InputMoreActionUnit() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.24
                @Override // com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit
                public void onAction(String str, int i) {
                    InputView.this.startVideoRecord();
                }
            };
            inputMoreActionUnit3.setIconResId(R.drawable.ic_more_video);
            inputMoreActionUnit3.setTitleId(R.string.video);
            this.mInputMoreActionList.add(inputMoreActionUnit3);
        }
        if (!this.mSendFileDisable) {
            InputMoreActionUnit inputMoreActionUnit4 = new InputMoreActionUnit() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.25
                @Override // com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit
                public void onAction(String str, int i) {
                    InputView.this.startSendFile();
                }
            };
            inputMoreActionUnit4.setIconResId(R.drawable.ic_more_file);
            inputMoreActionUnit4.setTitleId(R.string.file);
            this.mInputMoreActionList.add(inputMoreActionUnit4);
        }
        addActionsFromListeners();
        this.mInputMoreActionList.addAll(this.mInputMoreCustomActionList);
        Collections.sort(this.mInputMoreActionList, new Comparator<InputMoreActionUnit>() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.26
            @Override // java.util.Comparator
            public int compare(InputMoreActionUnit inputMoreActionUnit5, InputMoreActionUnit inputMoreActionUnit6) {
                return inputMoreActionUnit5.getPriority() - inputMoreActionUnit6.getPriority();
            }
        });
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.mInputContent = charSequence.toString();
    }

    public void clearCustomActionList() {
        this.mInputMoreCustomActionList.clear();
    }

    public void disableAudioInput(boolean z) {
        this.mAudioInputDisable = z;
        if (z) {
            this.mAudioInputSwitchButton.setVisibility(8);
        } else {
            this.mAudioInputSwitchButton.setVisibility(0);
        }
    }

    public void disableCaptureAction(boolean z) {
        this.mCaptureDisable = z;
    }

    public void disableEmojiInput(boolean z) {
        this.mEmojiInputDisable = z;
        if (z) {
            this.mEmojiInputButton.setVisibility(8);
        } else {
            this.mEmojiInputButton.setVisibility(0);
        }
    }

    public void disableMoreInput(boolean z) {
        this.mMoreInputDisable = z;
        if (z) {
            this.mMoreInputButton.setVisibility(8);
            this.mSendTextButton.setVisibility(0);
        } else {
            this.mMoreInputButton.setVisibility(0);
            this.mSendTextButton.setVisibility(8);
        }
    }

    public void disableSendFileAction(boolean z) {
        this.mSendFileDisable = z;
    }

    public void disableSendPhotoAction(boolean z) {
        this.mSendPhotoDisable = z;
    }

    public void disableShowCustomFace(boolean z) {
        this.isShowCustomFace = !z;
    }

    public void disableVideoRecordAction(boolean z) {
        this.mVideoRecordDisable = z;
    }

    public void exitReply() {
        this.isReplyModel = false;
        this.replyPreviewBean = null;
        this.replyPreviewBar.setVisibility(8);
        this.isQuoteModel = false;
        this.quotePreviewBar.setVisibility(8);
        updateChatBackground();
    }

    public ChatInfo getChatInfo() {
        return this.mChatInfo;
    }

    public EditText getInputText() {
        return this.mTextInput;
    }

    public void hideSoftInput() {
        Window window;
        TUIChatLog.i(TAG, "hideSoftInput");
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mTextInput.getWindowToken(), 0);
        this.mTextInput.clearFocus();
        Context context = getContext();
        if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null) {
            window.setSoftInputMode(48);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void init() {
        this.mAudioInputSwitchButton.setOnClickListener(this);
        this.mEmojiInputButton.setOnClickListener(this);
        this.mMoreInputButton.setOnClickListener(this);
        this.mSendTextButton.setOnClickListener(this);
        this.mTextInput.addTextChangedListener(this);
        this.mTextInput.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (InputView.this.presenter != null) {
                        InputView.this.presenter.scrollToNewestMessage();
                    }
                    InputView.this.showSoftInput();
                    return false;
                }
                return false;
            }
        });
        this.mTextInput.setOnKeyListener(new View.OnKeyListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == 67 && keyEvent.getAction() == 0) {
                    if ((InputView.this.isQuoteModel || InputView.this.isReplyModel) && TextUtils.isEmpty(InputView.this.mTextInput.getText().toString())) {
                        InputView.this.exitReply();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        this.mTextInput.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        this.mTextInput.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z && InputView.this.mChatInputHandler != null) {
                    InputView.this.mChatInputHandler.onUserTyping(false, V2TIMManager.getInstance().getServerTime());
                }
            }
        });
        this.mSendAudioButton.setOnTouchListener(new AnonymousClass5());
        this.mTextInput.setOnMentionInputListener(new TIMMentionEditText.OnMentionInputListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.6
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText.OnMentionInputListener
            public void onMentionCharacterInput(String str) {
                if ((str.equals("@") || str.equals("＠")) && TUIChatUtils.isGroupChat(InputView.this.mChatLayout.getChatInfo().getType()) && InputView.this.mOnInputViewListener != null) {
                    InputView.this.mOnInputViewListener.onStartGroupMemberSelectActivity();
                }
            }
        });
        this.replyCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InputView.this.exitReply();
            }
        });
        this.quoteCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InputView.this.exitReply();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onClick id:");
        sb2.append(view.getId());
        sb2.append("|voice_input_switch:");
        int i = R.id.voice_input_switch;
        sb2.append(i);
        sb2.append("|face_btn:");
        int i2 = R.id.face_btn;
        sb2.append(i2);
        sb2.append("|more_btn:");
        int i3 = R.id.more_btn;
        sb2.append(i3);
        sb2.append("|send_btn:");
        int i4 = R.id.send_btn;
        sb2.append(i4);
        sb2.append("|mCurrentState:");
        sb2.append(this.mCurrentState);
        sb2.append("|mSendEnable:");
        sb2.append(this.mSendEnable);
        sb2.append("|mMoreInputEvent:");
        sb2.append(this.mMoreInputEvent);
        TUIChatLog.i(str, sb2.toString());
        if (view.getId() == i) {
            int i5 = this.mCurrentState;
            if (i5 != 2 && i5 != 3) {
                if (i5 == 0) {
                    this.mCurrentState = 1;
                } else {
                    this.mCurrentState = 0;
                }
            } else {
                this.mCurrentState = 1;
                this.mInputMoreView.setVisibility(8);
                this.mEmojiInputButton.setImageResource(R.drawable.action_face_selector);
            }
            if (this.mCurrentState == 1) {
                this.mSendAudioButton.setVisibility(0);
                this.mTextInput.setVisibility(8);
                this.mAudioInputSwitchButton.setImageResource(R.drawable.chat_input_keyboard);
                hideInputMoreLayout();
                hideSoftInput();
                return;
            }
            this.mAudioInputSwitchButton.setImageResource(R.drawable.action_audio_selector);
            this.mSendAudioButton.setVisibility(8);
            this.mTextInput.setVisibility(0);
            showSoftInput();
            return;
        }
        if (view.getId() == i2) {
            this.mAudioInputSwitchButton.setImageResource(R.drawable.action_audio_selector);
            if (this.mCurrentState == 1) {
                this.mCurrentState = -1;
                this.mSendAudioButton.setVisibility(8);
                this.mTextInput.setVisibility(0);
            }
            if (this.mCurrentState == 2) {
                this.mCurrentState = 0;
                this.mEmojiInputButton.setImageResource(R.drawable.action_face_selector);
                this.mTextInput.setVisibility(0);
                showSoftInput();
                return;
            }
            this.mCurrentState = 2;
            this.mEmojiInputButton.setImageResource(R.drawable.chat_input_keyboard);
            showFaceViewGroup();
            return;
        }
        if (view.getId() == i3) {
            hideSoftInput();
            Object obj = this.mMoreInputEvent;
            if (obj instanceof View.OnClickListener) {
                ((View.OnClickListener) obj).onClick(view);
                return;
            }
            if (obj instanceof BaseInputFragment) {
                showCustomInputMoreFragment();
                return;
            }
            if (this.mCurrentState == 3) {
                this.mCurrentState = -1;
                this.mInputMoreView.setVisibility(0);
                return;
            }
            showInputMoreLayout();
            this.mCurrentState = 3;
            this.mAudioInputSwitchButton.setImageResource(R.drawable.action_audio_selector);
            this.mEmojiInputButton.setImageResource(R.drawable.action_face_selector);
            this.mSendAudioButton.setVisibility(8);
            this.mTextInput.setVisibility(0);
            return;
        }
        if (view.getId() == i4 && this.mSendEnable) {
            MessageHandler messageHandler = this.mMessageHandler;
            if (messageHandler != null) {
                IChatLayout iChatLayout = this.mChatLayout;
                if (iChatLayout == null) {
                    messageHandler.sendMessage(ChatMessageBuilder.buildTextMessage(this.mTextInput.getText().toString()));
                } else if ((this.isQuoteModel || this.isReplyModel) && this.replyPreviewBean != null) {
                    if (TUIChatUtils.isGroupChat(iChatLayout.getChatInfo().getType()) && !this.mTextInput.getMentionIdList().isEmpty()) {
                        this.mMessageHandler.sendMessage(ChatMessageBuilder.buildAtReplyMessage(this.mTextInput.getText().toString(), new ArrayList(this.mTextInput.getMentionIdList()), this.replyPreviewBean));
                    } else {
                        this.mMessageHandler.sendMessage(ChatMessageBuilder.buildReplyMessage(this.mTextInput.getText().toString(), this.replyPreviewBean));
                    }
                    exitReply();
                } else if (TUIChatUtils.isGroupChat(iChatLayout.getChatInfo().getType()) && !this.mTextInput.getMentionIdList().isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.mTextInput.getMentionIdList());
                    if (arrayList.isEmpty()) {
                        this.mMessageHandler.sendMessage(ChatMessageBuilder.buildTextMessage(this.mTextInput.getText().toString()));
                    } else {
                        this.mMessageHandler.sendMessage(ChatMessageBuilder.buildTextAtMessage(arrayList, this.mTextInput.getText().toString()));
                    }
                } else {
                    this.mMessageHandler.sendMessage(ChatMessageBuilder.buildTextMessage(this.mTextInput.getText().toString()));
                }
            }
            this.mIsSending = true;
            this.mTextInput.setText("");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mTextInput.removeTextChangedListener(this);
        this.atUserInfoMap.clear();
        ChatInputHandler chatInputHandler = this.mChatInputHandler;
        if (chatInputHandler != null) {
            chatInputHandler.onUserTyping(false, V2TIMManager.getInstance().getServerTime());
        }
    }

    public void onEmptyClick() {
        hideSoftInput();
        this.mCurrentState = 0;
        hideInputMoreLayout();
        this.mEmojiInputButton.setImageResource(R.drawable.action_face_selector);
        this.mAudioInputSwitchButton.setImageResource(R.drawable.action_audio_selector);
        this.mSendAudioButton.setVisibility(8);
        this.mTextInput.setVisibility(0);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void replaceMoreInput(BaseInputFragment baseInputFragment) {
        this.mMoreInputEvent = baseInputFragment;
    }

    public void setChatInfo(ChatInfo chatInfo) {
        DraftInfo draft;
        this.mChatInfo = chatInfo;
        if (chatInfo != null && (draft = chatInfo.getDraft()) != null && !TextUtils.isEmpty(draft.getDraftText()) && this.mTextInput != null) {
            d dVar = new d();
            String draftText = draft.getDraftText();
            try {
                HashMap hashMap = (HashMap) dVar.j(draft.getDraftText(), HashMap.class);
                if (hashMap != null) {
                    String str = (String) hashMap.get("content");
                    try {
                        ReplyPreviewBean replyPreviewBean = (ReplyPreviewBean) dVar.j((String) hashMap.get("reply"), ReplyPreviewBean.class);
                        if (replyPreviewBean != null) {
                            showReplyPreview(replyPreviewBean);
                        }
                        draftText = str;
                    } catch (r unused) {
                        draftText = str;
                        TUIChatLog.e(TAG, " getCustomJsonMap error ");
                        this.mTextInput.setText(draftText);
                        TIMMentionEditText tIMMentionEditText = this.mTextInput;
                        tIMMentionEditText.setSelection(tIMMentionEditText.getText().length());
                    }
                }
            } catch (r unused2) {
            }
            this.mTextInput.setText(draftText);
            TIMMentionEditText tIMMentionEditText2 = this.mTextInput;
            tIMMentionEditText2.setSelection(tIMMentionEditText2.getText().length());
        }
    }

    public void setChatInputHandler(ChatInputHandler chatInputHandler) {
        this.mChatInputHandler = chatInputHandler;
    }

    public void setChatLayout(IChatLayout iChatLayout) {
        this.mChatLayout = iChatLayout;
    }

    public void setDraft() {
        if (this.mChatInfo == null) {
            TUIChatLog.e(TAG, "set drafts error :  chatInfo is null");
            return;
        }
        TIMMentionEditText tIMMentionEditText = this.mTextInput;
        if (tIMMentionEditText == null) {
            TUIChatLog.e(TAG, "set drafts error :  textInput is null");
            return;
        }
        String obj = tIMMentionEditText.getText().toString();
        if ((this.isQuoteModel || this.isReplyModel) && this.replyPreviewBean != null) {
            d dVar = new d();
            HashMap hashMap = new HashMap();
            hashMap.put("content", obj);
            hashMap.put("reply", dVar.s(this.replyPreviewBean));
            obj = dVar.s(hashMap);
        }
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            chatPresenter.setDraft(obj);
        }
    }

    public void setMessageHandler(MessageHandler messageHandler) {
        this.mMessageHandler = messageHandler;
    }

    public void setOnInputViewListener(OnInputViewListener onInputViewListener) {
        this.mOnInputViewListener = onInputViewListener;
    }

    public void setPresenter(ChatPresenter chatPresenter) {
        this.presenter = chatPresenter;
    }

    protected void showEmojiInputButton(int i) {
        if (this.mEmojiInputDisable) {
            return;
        }
        this.mEmojiInputButton.setVisibility(i);
    }

    protected void showMoreInputButton(int i) {
        if (this.mMoreInputDisable) {
            return;
        }
        this.mMoreInputButton.setVisibility(i);
    }

    public void showReplyPreview(ReplyPreviewBean replyPreviewBean) {
        exitReply();
        this.replyPreviewBean = replyPreviewBean;
        String messageAbstract = replyPreviewBean.getMessageAbstract();
        String emojiJudge = FaceManager.emojiJudge(replyPreviewBean.getMessageSender() + " : " + ChatMessageParser.getMsgTypeStr(replyPreviewBean.getMessageType()) + " " + messageAbstract);
        if (replyPreviewBean.isReplyMessage()) {
            this.isReplyModel = true;
            this.replyTv.setText(emojiJudge);
            this.replyPreviewBar.setVisibility(0);
        } else {
            this.isQuoteModel = true;
            this.quoteTv.setText(emojiJudge);
            this.quotePreviewBar.setVisibility(0);
        }
        if (replyPreviewBean.getOriginalMessageBean() instanceof FileMessageBean) {
            TextView textView = this.replyTv;
            TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.MIDDLE;
            textView.setEllipsize(truncateAt);
            this.quoteTv.setEllipsize(truncateAt);
        } else {
            TextView textView2 = this.replyTv;
            TextUtils.TruncateAt truncateAt2 = TextUtils.TruncateAt.END;
            textView2.setEllipsize(truncateAt2);
            this.quoteTv.setEllipsize(truncateAt2);
        }
        MessageHandler messageHandler = this.mMessageHandler;
        if (messageHandler != null) {
            messageHandler.scrollToEnd();
        }
        showSoftInput();
    }

    protected void showSendTextButton(int i) {
        if (this.mMoreInputDisable) {
            this.mSendTextButton.setVisibility(0);
        } else {
            this.mSendTextButton.setVisibility(i);
        }
    }

    public void showSoftInput() {
        TUIChatLog.i(TAG, "showSoftInput");
        this.mCurrentState = 0;
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (!isSoftInputShown()) {
            inputMethodManager.toggleSoftInput(0, 0);
        }
        BackgroundTasks.getInstance().postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.16
            @Override // java.lang.Runnable
            public void run() {
                Window window;
                InputView.this.hideInputMoreLayout();
                InputView.this.mAudioInputSwitchButton.setImageResource(R.drawable.action_audio_selector);
                InputView.this.mEmojiInputButton.setImageResource(R.drawable.chat_input_face);
                InputView.this.mSendAudioButton.setVisibility(8);
                InputView.this.mTextInput.setVisibility(0);
                InputView.this.mTextInput.requestFocus();
                Context context = InputView.this.getContext();
                if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null) {
                    window.setSoftInputMode(16);
                }
            }
        }, 200L);
        if (this.mChatInputHandler != null) {
            postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.17
                @Override // java.lang.Runnable
                public void run() {
                    InputView.this.mChatInputHandler.onInputAreaClick();
                }
            }, 200L);
        }
    }

    protected void startCapture() {
        TUIChatLog.i(TAG, "startCapture");
        PermissionHelper.requestPermission(2, new PermissionHelper.PermissionCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.13
            @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
            public void onDenied() {
                TUIChatLog.i(InputView.TAG, "startCapture checkPermission failed");
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
            public void onGranted() {
                Intent intent = new Intent(InputView.this.getContext(), (Class<?>) CameraActivity.class);
                intent.putExtra(TUIChatConstants.CAMERA_TYPE, 257);
                CameraActivity.mCallBack = new IUIKitCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.13.1
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str, int i, String str2) {
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(Object obj) {
                        TUIMessageBean buildImageMessage = ChatMessageBuilder.buildImageMessage(Uri.fromFile(new File(obj.toString())));
                        if (InputView.this.mMessageHandler != null) {
                            InputView.this.mMessageHandler.sendMessage(buildImageMessage);
                            InputView.this.hideSoftInput();
                        }
                    }
                };
                InputView.this.setOpenPhotoCallback();
                InputView.this.mInputMoreFragment.startActivityForResult(intent, 1012);
            }
        });
    }

    protected void startSendFile() {
        TUIChatLog.i(TAG, "startSendFile");
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        this.mInputMoreFragment.setCallback(new IUIKitCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.15
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                ToastUtil.toastLongMessage(str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Object obj) {
                TUIMessageBean buildFileMessage = ChatMessageBuilder.buildFileMessage((Uri) obj);
                if (buildFileMessage == null) {
                    ToastUtil.toastShortMessage(InputView.this.getResources().getString(R.string.send_failed_file_not_exists));
                } else if (InputView.this.mMessageHandler != null) {
                    InputView.this.mMessageHandler.sendMessage(buildFileMessage);
                    InputView.this.hideSoftInput();
                }
            }
        });
        this.mInputMoreFragment.startActivityForResult(intent, 1011);
    }

    protected void startSendPhoto() {
        TUIChatLog.i(TAG, "startSendPhoto");
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
        setOpenPhotoCallback();
        this.mInputMoreFragment.startActivityForResult(intent, 1012);
    }

    protected void startVideoRecord() {
        TUIChatLog.i(TAG, "startVideoRecord");
        PermissionHelper.requestPermission(2, new AnonymousClass14());
    }

    public void updateInputText(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            updateAtUserInfoMap(arrayList, arrayList2);
            if (this.mTextInput != null) {
                this.mTextInput.setMentionMap(getDisplayAtNameMap(arrayList, arrayList2));
                int selectionEnd = this.mTextInput.getSelectionEnd();
                if (selectionEnd != -1) {
                    FaceManager.handlerEmojiText(this.mTextInput, this.mTextInput.getText().insert(selectionEnd, this.displayInputString).toString(), true);
                    this.mTextInput.setSelection(selectionEnd + this.displayInputString.length());
                }
                BackgroundTasks.getInstance().postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.11
                    @Override // java.lang.Runnable
                    public void run() {
                        InputView.this.showSoftInput();
                    }
                }, 200L);
            }
        }
    }

    public void replaceMoreInput(View.OnClickListener onClickListener) {
        this.mMoreInputEvent = onClickListener;
    }

    public InputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsSending = false;
        this.mInputMoreActionList = new ArrayList();
        this.mInputMoreCustomActionList = new ArrayList();
        this.atUserInfoMap = new HashMap();
        this.isReplyModel = false;
        this.isQuoteModel = false;
        this.isShowCustomFace = true;
        initViews();
    }

    public InputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsSending = false;
        this.mInputMoreActionList = new ArrayList();
        this.mInputMoreCustomActionList = new ArrayList();
        this.atUserInfoMap = new HashMap();
        this.isReplyModel = false;
        this.isQuoteModel = false;
        this.isShowCustomFace = true;
        initViews();
    }
}
