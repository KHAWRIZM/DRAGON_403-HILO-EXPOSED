package com.tencent.qcloud.tuikit.tuichat.hilo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.picture.PictureSelector;
import com.qiahao.base_common.utils.picture.PictureSelectorConfigures;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.DraftInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face.FaceFragment;
import com.tencent.qcloud.tuikit.tuichat.component.face.CustomFace;
import com.tencent.qcloud.tuikit.tuichat.component.face.Emoji;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloChatStrangeInputLayoutBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 ©\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\b¦\u0001§\u0001¨\u0001©\u0001B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nB%\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rJ\u0010\u0010c\u001a\u00020d2\b\u0010\\\u001a\u0004\u0018\u00010]J\b\u0010e\u001a\u00020dH\u0002J\b\u0010f\u001a\u00020dH\u0005J\u001a\u0010g\u001a\u00020d2\u0006\u0010h\u001a\u00020V2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010VJ:\u0010j\u001a\u00020d2\u0016\u0010k\u001a\u0012\u0012\u0004\u0012\u00020V0lj\b\u0012\u0004\u0012\u00020V`m2\u001a\u0010n\u001a\u0016\u0012\u0004\u0012\u00020V\u0018\u00010lj\n\u0012\u0004\u0012\u00020V\u0018\u0001`mJ0\u0010o\u001a\u000e\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020V0p2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020V0q2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020V0qH\u0002J8\u0010r\u001a\u00020d2\u0016\u0010k\u001a\u0012\u0012\u0004\u0012\u00020V0lj\b\u0012\u0004\u0012\u00020V`m2\u0016\u0010n\u001a\u0012\u0012\u0004\u0012\u00020V0lj\b\u0012\u0004\u0012\u00020V`mH\u0002J\b\u0010s\u001a\u00020dH\u0014J\u0010\u0010t\u001a\u00020d2\b\u0010u\u001a\u0004\u0018\u00010JJ\u0010\u0010v\u001a\u00020d2\b\u0010u\u001a\u0004\u0018\u00010LJ\u0010\u0010w\u001a\u00020d2\b\u0010x\u001a\u0004\u0018\u00010XJ\u0010\u0010y\u001a\u00020d2\u0006\u0010z\u001a\u00020:H\u0016J\u0006\u0010{\u001a\u00020dJ\u0006\u0010|\u001a\u00020dJ\u0006\u0010}\u001a\u00020dJ\u0010\u0010\u0082\u0001\u001a\u00020d2\u0007\u0010\u0083\u0001\u001a\u00020\u0015J\t\u0010\u0084\u0001\u001a\u00020dH\u0002J\t\u0010\u0085\u0001\u001a\u00020dH\u0002J\t\u0010\u0086\u0001\u001a\u00020dH\u0002J.\u0010\u0087\u0001\u001a\u00020d2\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0007\u0010\u008a\u0001\u001a\u00020\f2\u0007\u0010\u008b\u0001\u001a\u00020\f2\u0007\u0010\u008c\u0001\u001a\u00020\fH\u0016J.\u0010\u008d\u0001\u001a\u00020d2\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0007\u0010\u008a\u0001\u001a\u00020\f2\u0007\u0010\u008e\u0001\u001a\u00020\f2\u0007\u0010\u008b\u0001\u001a\u00020\fH\u0016J\u0013\u0010\u008f\u0001\u001a\u00020d2\b\u0010\u0088\u0001\u001a\u00030\u0090\u0001H\u0016J\u0007\u0010\u0091\u0001\u001a\u00020dJ\u0012\u0010\u0092\u0001\u001a\u00020d2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010VJ\u0010\u0010\u0094\u0001\u001a\u00020d2\u0007\u0010\u0083\u0001\u001a\u00020\u0015J\u0007\u0010\u0095\u0001\u001a\u00020dJ\u0010\u0010\u009a\u0001\u001a\u00020d2\u0007\u0010\u009b\u0001\u001a\u00020aJ\u0007\u0010\u009c\u0001\u001a\u00020dJ\t\u0010\u009d\u0001\u001a\u00020dH\u0002J\u0010\u0010\u009e\u0001\u001a\u00020d2\u0007\u0010\u009f\u0001\u001a\u00020\fJ\u0010\u0010 \u0001\u001a\u00020d2\u0007\u0010¡\u0001\u001a\u00020\u0015J\u0012\u0010¢\u0001\u001a\u00020d2\u0007\u0010\u009f\u0001\u001a\u00020\fH\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001c\u0010 \u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001c\u0010#\u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00103\u001a\u0004\u0018\u000104X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010O\u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0011\"\u0004\bQ\u0010\u0013R\u000e\u0010R\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020V0ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u0004\u0018\u00010]X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010~\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b~\u0010\u0017R\u0016\u0010\u007f\u001a\u00020\f8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0017\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u00018F¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R,\u0010£\u0001\u001a\u0004\u0018\u00010@2\t\u0010£\u0001\u001a\u0004\u0018\u00010@8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¤\u0001\u0010B\"\u0005\b¥\u0001\u0010D¨\u0006ª\u0001"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/StrangeInputView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "Landroid/text/TextWatcher;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mEmojiInputButton", "Landroid/widget/ImageView;", "getMEmojiInputButton", "()Landroid/widget/ImageView;", "setMEmojiInputButton", "(Landroid/widget/ImageView;)V", "mEmojiInputDisable", "", "getMEmojiInputDisable", "()Z", "setMEmojiInputDisable", "(Z)V", "mSendButton", "getMSendButton", "setMSendButton", "mImageButton", "getMImageButton", "setMImageButton", "mVideoButton", "getMVideoButton", "setMVideoButton", "mGiftButton", "getMGiftButton", "setMGiftButton", "mBinding", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloChatStrangeInputLayoutBinding;", "getMBinding", "()Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloChatStrangeInputLayoutBinding;", "setMBinding", "(Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloChatStrangeInputLayoutBinding;)V", "mTextInput", "Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/input/TIMMentionEditText;", "getMTextInput", "()Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/input/TIMMentionEditText;", "setMTextInput", "(Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/input/TIMMentionEditText;)V", "mIsSending", "mActivity", "Landroidx/appcompat/app/AppCompatActivity;", "getMActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "setMActivity", "(Landroidx/appcompat/app/AppCompatActivity;)V", "mInputMoreView", "Landroid/view/View;", "getMInputMoreView", "()Landroid/view/View;", "setMInputMoreView", "(Landroid/view/View;)V", "mChatInfo", "Lcom/tencent/qcloud/tuikit/tuichat/bean/ChatInfo;", "getMChatInfo", "()Lcom/tencent/qcloud/tuikit/tuichat/bean/ChatInfo;", "setMChatInfo", "(Lcom/tencent/qcloud/tuikit/tuichat/bean/ChatInfo;)V", "mFaceFragment", "Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/input/face/FaceFragment;", "mGameFragment", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/GameMoreFragment;", "mChatInputHandler", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/StrangeInputView$ChatInputHandler;", "mMessageHandler", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/StrangeInputView$MessageHandler;", "mFragmentManager", "Landroidx/fragment/app/FragmentManager;", "mGameButton", "getMGameButton", "setMGameButton", "mSendEnable", "mCurrentState", "mLastMsgLineCount", "mInputContent", "", "mOnInputViewListener", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/StrangeInputView$OnInputViewListener;", "atUserInfoMap", "", "displayInputString", "presenter", "Lcom/tencent/qcloud/tuikit/tuichat/presenter/ChatPresenter;", "isReplyModel", "isQuoteModel", "replyPreviewBean", "Lcom/tencent/qcloud/tuikit/tuichat/bean/ReplyPreviewBean;", "isShowCustomFace", "setPresenter", "", "initViews", "init", "addInputText", "name", AgooConstants.MESSAGE_ID, "updateInputText", "names", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ids", "getDisplayAtNameMap", "", "", "updateAtUserInfoMap", "onDetachedFromWindow", "setChatInputHandler", "handler", "setMessageHandler", "setOnInputViewListener", "listener", "onClick", "view", "showSoftInput", "hideSoftInput", "onEmptyClick", "isSoftInputShown", "navigateBarHeight", "getNavigateBarHeight", "()I", "disableShowCustomFace", "disable", "showGameView", "showFaceViewGroup", "hideInputMoreLayout", "beforeTextChanged", "s", "", "start", "count", "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "setDraft", "appendText", "text", "disableEmojiInput", "sendPicture", "inputText", "Landroid/widget/EditText;", "getInputText", "()Landroid/widget/EditText;", "showReplyPreview", "previewBean", "exitReply", "updateChatBackground", "showVideo", "visibility", "refreshStrangeView", "isStrange", "showEmojiInputButton", TUIChatConstants.CHAT_INFO, "getChatInfo", "setChatInfo", "MessageHandler", "ChatInputHandler", "OnInputViewListener", "Companion", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStrangeInputView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StrangeInputView.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/StrangeInputView\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,814:1\n106#2:815\n78#2,22:816\n1#3:838\n*S KotlinDebug\n*F\n+ 1 StrangeInputView.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/StrangeInputView\n*L\n586#1:815\n586#1:816,22\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class StrangeInputView extends LinearLayout implements View.OnClickListener, TextWatcher {
    private static final int STATE_FACE_INPUT = 2;
    private static final int STATE_GAME_INPUT = 3;
    private static final int STATE_NONE_INPUT = -1;
    private static final int STATE_SOFT_INPUT = 0;
    private static final int STATE_VOICE_INPUT = 1;

    @NotNull
    private final Map<String, String> atUserInfoMap;

    @Nullable
    private String displayInputString;
    private boolean isQuoteModel;
    private boolean isReplyModel;
    private boolean isShowCustomFace;

    @Nullable
    private AppCompatActivity mActivity;

    @Nullable
    private HiloChatStrangeInputLayoutBinding mBinding;

    @Nullable
    private ChatInfo mChatInfo;

    @Nullable
    private ChatInputHandler mChatInputHandler;
    private int mCurrentState;

    @Nullable
    private ImageView mEmojiInputButton;
    private boolean mEmojiInputDisable;

    @Nullable
    private FaceFragment mFaceFragment;

    @Nullable
    private FragmentManager mFragmentManager;

    @Nullable
    private ImageView mGameButton;

    @Nullable
    private GameMoreFragment mGameFragment;

    @Nullable
    private ImageView mGiftButton;

    @Nullable
    private ImageView mImageButton;

    @Nullable
    private String mInputContent;

    @Nullable
    private View mInputMoreView;
    private boolean mIsSending;
    private int mLastMsgLineCount;

    @Nullable
    private MessageHandler mMessageHandler;

    @Nullable
    private OnInputViewListener mOnInputViewListener;

    @Nullable
    private ImageView mSendButton;
    private boolean mSendEnable;

    @Nullable
    private TIMMentionEditText mTextInput;

    @Nullable
    private ImageView mVideoButton;

    @Nullable
    private ChatPresenter presenter;

    @Nullable
    private ReplyPreviewBean replyPreviewBean;
    private static final String TAG = StrangeInputView.class.getSimpleName();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/StrangeInputView$ChatInputHandler;", "", "onInputAreaClick", "", "onUserTyping", "status", "", AgooConstants.MESSAGE_TIME, "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface ChatInputHandler {
        void onInputAreaClick();

        void onUserTyping(boolean status, long time);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/StrangeInputView$MessageHandler;", "", TUIConstants.TUIChat.METHOD_SEND_MESSAGE, "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "scrollToEnd", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface MessageHandler {
        void scrollToEnd();

        void sendMessage(@Nullable TUIMessageBean msg);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/StrangeInputView$OnInputViewListener;", "", "onStartGroupMemberSelectActivity", "", "onUpdateChatBackground", "onClickGift", "onClickVideo", "onClickImage", "onClickGame", GameMatchActivity.GAME_ID, "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnInputViewListener {
        void onClickGame(int gameId);

        void onClickGift();

        void onClickImage();

        void onClickVideo();

        void onStartGroupMemberSelectActivity();

        void onUpdateChatBackground();
    }

    public StrangeInputView(@Nullable Context context) {
        super(context);
        this.atUserInfoMap = new HashMap();
        this.isShowCustomFace = true;
        initViews();
    }

    public static /* synthetic */ void addInputText$default(StrangeInputView strangeInputView, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        strangeInputView.addInputText(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Map<String, String> getDisplayAtNameMap(List<String> names, List<String> ids) {
        String str;
        int size;
        int i;
        String str2;
        Editable editable;
        int i2;
        HashMap hashMap = new HashMap();
        TIMMentionEditText tIMMentionEditText = this.mTextInput;
        if (tIMMentionEditText != null) {
            if (tIMMentionEditText != null) {
                editable = tIMMentionEditText.getText();
            } else {
                editable = null;
            }
            TIMMentionEditText tIMMentionEditText2 = this.mTextInput;
            if (tIMMentionEditText2 != null) {
                i2 = tIMMentionEditText2.getSelectionEnd();
            } else {
                i2 = 0;
            }
            if (editable != null && i2 > 0) {
                String obj = editable.toString();
                if (!TextUtils.isEmpty(obj)) {
                    str = obj.substring(i2 - 1, i2);
                    Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                    size = ids.size();
                    for (i = 0; i < size; i++) {
                        if (i == 0) {
                            if (TextUtils.isEmpty(names.get(0))) {
                                hashMap.put(str + ((Object) ids.get(0)) + " ", ids.get(0));
                            } else {
                                hashMap.put(str + ((Object) names.get(0)) + " ", ids.get(0));
                            }
                        } else {
                            if (TextUtils.isEmpty(names.get(i))) {
                                str2 = ids.get(i);
                            } else {
                                str2 = names.get(i);
                            }
                            hashMap.put(("@" + str2) + " ", ids.get(i));
                        }
                    }
                    return hashMap;
                }
            }
        }
        str = "@";
        size = ids.size();
        while (i < size) {
        }
        return hashMap;
    }

    private final int getNavigateBarHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        if (i2 > i) {
            return i2 - i;
        }
        return 0;
    }

    private final void hideInputMoreLayout() {
        View view = this.mInputMoreView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$0(StrangeInputView strangeInputView, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            ChatPresenter chatPresenter = strangeInputView.presenter;
            if (chatPresenter != null && chatPresenter != null) {
                chatPresenter.scrollToNewestMessage();
            }
            strangeInputView.showSoftInput();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$1(StrangeInputView strangeInputView, View view, int i, KeyEvent keyEvent) {
        Editable editable;
        if (i == 67 && keyEvent.getAction() == 0) {
            if (strangeInputView.isQuoteModel || strangeInputView.isReplyModel) {
                TIMMentionEditText tIMMentionEditText = strangeInputView.mTextInput;
                if (tIMMentionEditText != null) {
                    editable = tIMMentionEditText.getText();
                } else {
                    editable = null;
                }
                if (TextUtils.isEmpty(String.valueOf(editable))) {
                    strangeInputView.exitReply();
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$2(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$3(StrangeInputView strangeInputView, View view, boolean z) {
        ChatInputHandler chatInputHandler;
        if (!z && (chatInputHandler = strangeInputView.mChatInputHandler) != null) {
            chatInputHandler.onUserTyping(false, V2TIMManager.getInstance().getServerTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$4(StrangeInputView strangeInputView, String str) {
        int i;
        OnInputViewListener onInputViewListener;
        if (Intrinsics.areEqual(str, "@") || Intrinsics.areEqual(str, "＠")) {
            ChatInfo chatInfo = strangeInputView.mChatInfo;
            if (chatInfo != null) {
                i = chatInfo.getType();
            } else {
                i = 0;
            }
            if (TUIChatUtils.isGroupChat(i) && (onInputViewListener = strangeInputView.mOnInputViewListener) != null) {
                onInputViewListener.onStartGroupMemberSelectActivity();
            }
        }
    }

    private final void initViews() {
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(getContext());
        this.mActivity = activity;
        this.mBinding = (HiloChatStrangeInputLayoutBinding) androidx.databinding.g.h(LayoutInflater.from(activity), R.layout.hilo_chat_strange_input_layout, this, true);
        this.mInputMoreView = findViewById(R.id.more_groups);
        this.mEmojiInputButton = (ImageView) findViewById(R.id.emoji);
        this.mSendButton = (ImageView) findViewById(R.id.send_btn);
        this.mImageButton = (ImageView) findViewById(R.id.image);
        this.mGameButton = (ImageView) findViewById(R.id.game);
        this.mVideoButton = (ImageView) findViewById(R.id.video);
        this.mGiftButton = (ImageView) findViewById(R.id.gift);
        this.mTextInput = (TIMMentionEditText) findViewById(R.id.chat_message_input);
        this.mIsSending = false;
        init();
    }

    private final boolean isSoftInputShown() {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        View decorView = ((Activity) context).getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        int height = decorView.getHeight();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        if ((height - rect.bottom) - getNavigateBarHeight() >= 0) {
            return true;
        }
        return false;
    }

    private final void showFaceViewGroup() {
        FragmentTransaction beginTransaction;
        FragmentManager fragmentManager;
        TUIChatLog.i(TAG, "showFaceViewGroup");
        if (this.mFragmentManager == null) {
            AppCompatActivity appCompatActivity = this.mActivity;
            if (appCompatActivity != null) {
                fragmentManager = appCompatActivity.getSupportFragmentManager();
            } else {
                fragmentManager = null;
            }
            this.mFragmentManager = fragmentManager;
        }
        if (this.mFaceFragment == null) {
            this.mFaceFragment = new FaceFragment();
        }
        hideSoftInput();
        View view = this.mInputMoreView;
        if (view != null) {
            view.setVisibility(0);
        }
        TIMMentionEditText tIMMentionEditText = this.mTextInput;
        if (tIMMentionEditText != null) {
            tIMMentionEditText.requestFocus();
        }
        FaceFragment faceFragment = this.mFaceFragment;
        if (faceFragment != null) {
            faceFragment.setShowCustomFace(this.isShowCustomFace);
        }
        FaceFragment faceFragment2 = this.mFaceFragment;
        if (faceFragment2 != null) {
            faceFragment2.setListener(new FaceFragment.OnEmojiClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView$showFaceViewGroup$1
                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face.FaceFragment.OnEmojiClickListener
                public void onCustomFaceClick(int groupIndex, CustomFace customFace) {
                    StrangeInputView.MessageHandler messageHandler;
                    Intrinsics.checkNotNullParameter(customFace, "customFace");
                    messageHandler = StrangeInputView.this.mMessageHandler;
                    if (messageHandler != null) {
                        messageHandler.sendMessage(ChatMessageBuilder.buildFaceMessage(groupIndex, customFace.getFaceKey()));
                    }
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face.FaceFragment.OnEmojiClickListener
                public void onEmojiClick(Emoji emoji) {
                    int i;
                    Editable editable;
                    Intrinsics.checkNotNullParameter(emoji, "emoji");
                    TIMMentionEditText mTextInput = StrangeInputView.this.getMTextInput();
                    if (mTextInput != null) {
                        i = mTextInput.getSelectionStart();
                    } else {
                        i = 0;
                    }
                    TIMMentionEditText mTextInput2 = StrangeInputView.this.getMTextInput();
                    if (mTextInput2 != null) {
                        editable = mTextInput2.getText();
                    } else {
                        editable = null;
                    }
                    if (editable != null) {
                        editable.insert(i, emoji.getFaceKey());
                    }
                    FaceManager.handlerEmojiText(StrangeInputView.this.getMTextInput(), editable, true);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face.FaceFragment.OnEmojiClickListener
                public void onEmojiDelete() {
                    int i;
                    Editable editable;
                    Object obj;
                    Object obj2;
                    TIMMentionEditText mTextInput = StrangeInputView.this.getMTextInput();
                    if (mTextInput != null) {
                        i = mTextInput.getSelectionStart();
                    } else {
                        i = 0;
                    }
                    TIMMentionEditText mTextInput2 = StrangeInputView.this.getMTextInput();
                    CharSequence charSequence = null;
                    if (mTextInput2 != null) {
                        editable = mTextInput2.getText();
                    } else {
                        editable = null;
                    }
                    if (i <= 0) {
                        return;
                    }
                    if (editable == null) {
                        obj = "";
                    } else {
                        obj = Character.valueOf(editable.charAt(i - 1));
                    }
                    if (Intrinsics.areEqual(obj, ']')) {
                        int i2 = i - 2;
                        while (true) {
                            if (-1 >= i2) {
                                break;
                            }
                            if (editable == null) {
                                obj2 = "";
                            } else {
                                obj2 = Character.valueOf(editable.charAt(i2));
                            }
                            if (Intrinsics.areEqual(obj2, '[')) {
                                if (editable != null) {
                                    charSequence = editable.subSequence(i2, i);
                                }
                                if (FaceManager.isFaceChar(String.valueOf(charSequence))) {
                                    if (editable != null) {
                                        editable.delete(i2, i);
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                i2--;
                            }
                        }
                    }
                    if (editable != null) {
                        editable.delete(i - 1, i);
                    }
                }
            });
        }
        FragmentManager fragmentManager2 = this.mFragmentManager;
        if (fragmentManager2 != null && (beginTransaction = fragmentManager2.beginTransaction()) != null) {
            int i = R.id.more_groups;
            FaceFragment faceFragment3 = this.mFaceFragment;
            Intrinsics.checkNotNull(faceFragment3);
            FragmentTransaction replace = beginTransaction.replace(i, faceFragment3);
            if (replace != null) {
                replace.commitAllowingStateLoss();
            }
        }
        postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.p0
            @Override // java.lang.Runnable
            public final void run() {
                StrangeInputView.showFaceViewGroup$lambda$12(StrangeInputView.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFaceViewGroup$lambda$12(StrangeInputView strangeInputView) {
        ChatInputHandler chatInputHandler = strangeInputView.mChatInputHandler;
        if (chatInputHandler != null) {
            chatInputHandler.onInputAreaClick();
        }
    }

    private final void showGameView() {
        FragmentTransaction beginTransaction;
        FragmentManager fragmentManager;
        if (this.mFragmentManager == null) {
            AppCompatActivity appCompatActivity = this.mActivity;
            if (appCompatActivity != null) {
                fragmentManager = appCompatActivity.getSupportFragmentManager();
            } else {
                fragmentManager = null;
            }
            this.mFragmentManager = fragmentManager;
        }
        if (this.mGameFragment == null) {
            GameMoreFragment gameMoreFragment = new GameMoreFragment();
            this.mGameFragment = gameMoreFragment;
            gameMoreFragment.setClickListener(new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.z0
                public final Object invoke(Object obj) {
                    Unit showGameView$lambda$10;
                    showGameView$lambda$10 = StrangeInputView.showGameView$lambda$10(StrangeInputView.this, ((Integer) obj).intValue());
                    return showGameView$lambda$10;
                }
            });
        }
        hideSoftInput();
        View view = this.mInputMoreView;
        if (view != null) {
            view.setVisibility(0);
        }
        FragmentManager fragmentManager2 = this.mFragmentManager;
        if (fragmentManager2 != null && (beginTransaction = fragmentManager2.beginTransaction()) != null) {
            int i = R.id.more_groups;
            GameMoreFragment gameMoreFragment2 = this.mGameFragment;
            Intrinsics.checkNotNull(gameMoreFragment2);
            FragmentTransaction replace = beginTransaction.replace(i, gameMoreFragment2);
            if (replace != null) {
                replace.commitAllowingStateLoss();
            }
        }
        postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.q0
            @Override // java.lang.Runnable
            public final void run() {
                StrangeInputView.showGameView$lambda$11(StrangeInputView.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGameView$lambda$10(StrangeInputView strangeInputView, int i) {
        OnInputViewListener onInputViewListener = strangeInputView.mOnInputViewListener;
        if (onInputViewListener != null) {
            onInputViewListener.onClickGame(i);
        }
        strangeInputView.onEmptyClick();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGameView$lambda$11(StrangeInputView strangeInputView) {
        ChatInputHandler chatInputHandler = strangeInputView.mChatInputHandler;
        if (chatInputHandler != null) {
            chatInputHandler.onInputAreaClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSoftInput$lambda$7(StrangeInputView strangeInputView) {
        Window window;
        strangeInputView.hideInputMoreLayout();
        ImageView imageView = strangeInputView.mEmojiInputButton;
        if (imageView != null) {
            imageView.setImageDrawable(androidx.core.content.a.getDrawable(strangeInputView.getContext(), R.drawable.icon_chat_emoji));
        }
        TIMMentionEditText tIMMentionEditText = strangeInputView.mTextInput;
        if (tIMMentionEditText != null) {
            tIMMentionEditText.setVisibility(0);
        }
        TIMMentionEditText tIMMentionEditText2 = strangeInputView.mTextInput;
        if (tIMMentionEditText2 != null) {
            tIMMentionEditText2.requestFocus();
        }
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(strangeInputView.getContext());
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSoftInput$lambda$8(StrangeInputView strangeInputView) {
        ChatInputHandler chatInputHandler = strangeInputView.mChatInputHandler;
        if (chatInputHandler != null) {
            chatInputHandler.onInputAreaClick();
        }
    }

    private final void updateAtUserInfoMap(ArrayList<String> names, ArrayList<String> ids) {
        String str;
        int i;
        this.displayInputString = "";
        int size = ids.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.atUserInfoMap.put(ids.get(i2), names.get(i2));
            if (TextUtils.isEmpty(names.get(i2))) {
                String str2 = this.displayInputString + ((Object) ids.get(i2));
                this.displayInputString = str2;
                String str3 = str2 + " ";
                this.displayInputString = str3;
                this.displayInputString = str3 + "@";
            } else {
                String str4 = this.displayInputString + ((Object) names.get(i2));
                this.displayInputString = str4;
                String str5 = str4 + " ";
                this.displayInputString = str5;
                this.displayInputString = str5 + "@";
            }
        }
        String str6 = this.displayInputString;
        if (str6 != null && str6.length() > 0) {
            String str7 = this.displayInputString;
            if (str7 != null) {
                if (str7 != null) {
                    i = str7.length();
                } else {
                    i = 0;
                }
                str = str7.substring(0, i - 1);
                Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
            } else {
                str = null;
            }
            this.displayInputString = str;
        }
    }

    private final void updateChatBackground() {
        OnInputViewListener onInputViewListener = this.mOnInputViewListener;
        if (onInputViewListener != null) {
            onInputViewListener.onUpdateChatBackground();
        }
    }

    public final void addInputText(@NotNull final String name, @Nullable final String id2) {
        int i;
        Editable editable;
        Editable text;
        Intrinsics.checkNotNullParameter(name, "name");
        if (id2 != null && id2.length() != 0) {
            updateAtUserInfoMap(new ArrayList<String>(name) { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView$addInputText$nameList$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    add(name);
                }

                @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
                public final /* bridge */ boolean contains(Object obj) {
                    if (obj instanceof String) {
                        return contains((String) obj);
                    }
                    return false;
                }

                public /* bridge */ int getSize() {
                    return super.size();
                }

                @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
                public final /* bridge */ int indexOf(Object obj) {
                    if (obj instanceof String) {
                        return indexOf((String) obj);
                    }
                    return -1;
                }

                @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
                public final /* bridge */ int lastIndexOf(Object obj) {
                    if (obj instanceof String) {
                        return lastIndexOf((String) obj);
                    }
                    return -1;
                }

                @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
                public final /* bridge */ String remove(int i2) {
                    return removeAt(i2);
                }

                public /* bridge */ String removeAt(int i2) {
                    return (String) super.remove(i2);
                }

                @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
                public final /* bridge */ int size() {
                    return getSize();
                }

                public /* bridge */ boolean contains(String str) {
                    return super.contains((Object) str);
                }

                public /* bridge */ int indexOf(String str) {
                    return super.indexOf((Object) str);
                }

                public /* bridge */ int lastIndexOf(String str) {
                    return super.lastIndexOf((Object) str);
                }

                @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
                public final /* bridge */ boolean remove(Object obj) {
                    if (obj instanceof String) {
                        return remove((String) obj);
                    }
                    return false;
                }

                public /* bridge */ boolean remove(String str) {
                    return super.remove((Object) str);
                }
            }, new ArrayList<String>(id2) { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView$addInputText$idList$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    add(id2);
                }

                @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
                public final /* bridge */ boolean contains(Object obj) {
                    if (obj instanceof String) {
                        return contains((String) obj);
                    }
                    return false;
                }

                public /* bridge */ int getSize() {
                    return super.size();
                }

                @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
                public final /* bridge */ int indexOf(Object obj) {
                    if (obj instanceof String) {
                        return indexOf((String) obj);
                    }
                    return -1;
                }

                @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
                public final /* bridge */ int lastIndexOf(Object obj) {
                    if (obj instanceof String) {
                        return lastIndexOf((String) obj);
                    }
                    return -1;
                }

                @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
                public final /* bridge */ String remove(int i2) {
                    return removeAt(i2);
                }

                public /* bridge */ String removeAt(int i2) {
                    return (String) super.remove(i2);
                }

                @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
                public final /* bridge */ int size() {
                    return getSize();
                }

                public /* bridge */ boolean contains(String str) {
                    return super.contains((Object) str);
                }

                public /* bridge */ int indexOf(String str) {
                    return super.indexOf((Object) str);
                }

                public /* bridge */ int lastIndexOf(String str) {
                    return super.lastIndexOf((Object) str);
                }

                @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
                public final /* bridge */ boolean remove(Object obj) {
                    if (obj instanceof String) {
                        return remove((String) obj);
                    }
                    return false;
                }

                public /* bridge */ boolean remove(String str) {
                    return super.remove((Object) str);
                }
            });
            if (this.mTextInput != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("@" + this.displayInputString, id2);
                TIMMentionEditText tIMMentionEditText = this.mTextInput;
                if (tIMMentionEditText != null) {
                    tIMMentionEditText.setMentionMap(hashMap);
                }
                TIMMentionEditText tIMMentionEditText2 = this.mTextInput;
                if (tIMMentionEditText2 != null) {
                    i = tIMMentionEditText2.getSelectionEnd();
                } else {
                    i = 0;
                }
                if (i != -1) {
                    String str = "@" + this.displayInputString;
                    TIMMentionEditText tIMMentionEditText3 = this.mTextInput;
                    if (tIMMentionEditText3 != null && (text = tIMMentionEditText3.getText()) != null) {
                        editable = text.insert(i, str);
                    } else {
                        editable = null;
                    }
                    FaceManager.handlerEmojiText(this.mTextInput, String.valueOf(editable), true);
                    TIMMentionEditText tIMMentionEditText4 = this.mTextInput;
                    if (tIMMentionEditText4 != null) {
                        tIMMentionEditText4.setSelection(i + str.length());
                    }
                }
                showSoftInput();
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@NotNull Editable s) {
        int i;
        Editable editable;
        int i2;
        boolean z;
        Intrinsics.checkNotNullParameter(s, "s");
        String obj = s.toString();
        int length = obj.length() - 1;
        int i3 = 0;
        boolean z2 = false;
        while (i3 <= length) {
            if (!z2) {
                i2 = i3;
            } else {
                i2 = length;
            }
            if (Intrinsics.compare(obj.charAt(i2), 32) <= 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z2) {
                if (!z) {
                    z2 = true;
                } else {
                    i3++;
                }
            } else if (!z) {
                break;
            } else {
                length--;
            }
        }
        if (TextUtils.isEmpty(obj.subSequence(i3, length + 1).toString())) {
            this.mSendEnable = false;
            ChatInputHandler chatInputHandler = this.mChatInputHandler;
            if (chatInputHandler != null) {
                chatInputHandler.onUserTyping(false, V2TIMManager.getInstance().getServerTime());
            }
        } else {
            this.mSendEnable = true;
            TIMMentionEditText tIMMentionEditText = this.mTextInput;
            if (tIMMentionEditText == null || tIMMentionEditText.getLineCount() != this.mLastMsgLineCount) {
                TIMMentionEditText tIMMentionEditText2 = this.mTextInput;
                if (tIMMentionEditText2 != null) {
                    i = tIMMentionEditText2.getLineCount();
                } else {
                    i = 0;
                }
                this.mLastMsgLineCount = i;
                ChatInputHandler chatInputHandler2 = this.mChatInputHandler;
                if (chatInputHandler2 != null) {
                    chatInputHandler2.onInputAreaClick();
                }
            }
            String str = this.mInputContent;
            TIMMentionEditText tIMMentionEditText3 = this.mTextInput;
            Editable editable2 = null;
            if (tIMMentionEditText3 != null) {
                editable = tIMMentionEditText3.getText();
            } else {
                editable = null;
            }
            if (!TextUtils.equals(str, String.valueOf(editable))) {
                TIMMentionEditText tIMMentionEditText4 = this.mTextInput;
                if (tIMMentionEditText4 != null) {
                    editable2 = tIMMentionEditText4.getText();
                }
                FaceManager.handlerEmojiText(tIMMentionEditText4, editable2, true);
            }
        }
        ChatInputHandler chatInputHandler3 = this.mChatInputHandler;
        if (chatInputHandler3 != null) {
            chatInputHandler3.onUserTyping(true, V2TIMManager.getInstance().getServerTime());
        }
        if (this.mIsSending) {
            this.mIsSending = false;
        }
    }

    public final void appendText(@Nullable String text) {
        Editable editable;
        int i;
        Editable text2;
        if (this.mChatInfo == null) {
            TUIChatLog.e(TAG, "appendText error :  chatInfo is null");
            return;
        }
        TIMMentionEditText tIMMentionEditText = this.mTextInput;
        if (tIMMentionEditText == null) {
            TUIChatLog.e(TAG, "appendText error :  textInput is null");
            return;
        }
        if (tIMMentionEditText != null) {
            editable = tIMMentionEditText.getText();
        } else {
            editable = null;
        }
        String str = String.valueOf(editable) + text;
        TIMMentionEditText tIMMentionEditText2 = this.mTextInput;
        if (tIMMentionEditText2 != null) {
            tIMMentionEditText2.setText(str);
        }
        TIMMentionEditText tIMMentionEditText3 = this.mTextInput;
        if (tIMMentionEditText3 != null) {
            if (tIMMentionEditText3 != null && (text2 = tIMMentionEditText3.getText()) != null) {
                i = text2.length();
            } else {
                i = 0;
            }
            tIMMentionEditText3.setSelection(i);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@NotNull CharSequence s, int start, int count, int after) {
        Intrinsics.checkNotNullParameter(s, "s");
        this.mInputContent = s.toString();
    }

    public final void disableEmojiInput(boolean disable) {
        this.mEmojiInputDisable = disable;
        if (disable) {
            ImageView imageView = this.mEmojiInputButton;
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        ImageView imageView2 = this.mEmojiInputButton;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
    }

    public final void disableShowCustomFace(boolean disable) {
        this.isShowCustomFace = !disable;
    }

    public final void exitReply() {
        this.isReplyModel = false;
        this.replyPreviewBean = null;
        this.isQuoteModel = false;
        updateChatBackground();
    }

    @Nullable
    /* renamed from: getChatInfo, reason: from getter */
    public final ChatInfo getMChatInfo() {
        return this.mChatInfo;
    }

    @Nullable
    public final EditText getInputText() {
        return this.mTextInput;
    }

    @Nullable
    protected final AppCompatActivity getMActivity() {
        return this.mActivity;
    }

    @Nullable
    protected final HiloChatStrangeInputLayoutBinding getMBinding() {
        return this.mBinding;
    }

    @Nullable
    protected final ChatInfo getMChatInfo() {
        return this.mChatInfo;
    }

    @Nullable
    protected final ImageView getMEmojiInputButton() {
        return this.mEmojiInputButton;
    }

    protected final boolean getMEmojiInputDisable() {
        return this.mEmojiInputDisable;
    }

    @Nullable
    protected final ImageView getMGameButton() {
        return this.mGameButton;
    }

    @Nullable
    protected final ImageView getMGiftButton() {
        return this.mGiftButton;
    }

    @Nullable
    protected final ImageView getMImageButton() {
        return this.mImageButton;
    }

    @Nullable
    protected final View getMInputMoreView() {
        return this.mInputMoreView;
    }

    @Nullable
    protected final ImageView getMSendButton() {
        return this.mSendButton;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final TIMMentionEditText getMTextInput() {
        return this.mTextInput;
    }

    @Nullable
    protected final ImageView getMVideoButton() {
        return this.mVideoButton;
    }

    public final void hideSoftInput() {
        IBinder iBinder;
        Window window;
        TUIChatLog.i(TAG, "hideSoftInput");
        Object systemService = getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        TIMMentionEditText tIMMentionEditText = this.mTextInput;
        if (tIMMentionEditText != null) {
            iBinder = tIMMentionEditText.getWindowToken();
        } else {
            iBinder = null;
        }
        inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        TIMMentionEditText tIMMentionEditText2 = this.mTextInput;
        if (tIMMentionEditText2 != null) {
            tIMMentionEditText2.clearFocus();
        }
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(getContext());
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(48);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected final void init() {
        ImageView imageView = this.mEmojiInputButton;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        ImageView imageView2 = this.mSendButton;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        ImageView imageView3 = this.mVideoButton;
        if (imageView3 != null) {
            imageView3.setOnClickListener(this);
        }
        ImageView imageView4 = this.mImageButton;
        if (imageView4 != null) {
            imageView4.setOnClickListener(this);
        }
        ImageView imageView5 = this.mGiftButton;
        if (imageView5 != null) {
            imageView5.setOnClickListener(this);
        }
        TIMMentionEditText tIMMentionEditText = this.mTextInput;
        if (tIMMentionEditText != null) {
            tIMMentionEditText.addTextChangedListener(this);
        }
        ImageView imageView6 = this.mGameButton;
        if (imageView6 != null) {
            imageView6.setOnClickListener(this);
        }
        TIMMentionEditText tIMMentionEditText2 = this.mTextInput;
        if (tIMMentionEditText2 != null) {
            tIMMentionEditText2.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.u0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean init$lambda$0;
                    init$lambda$0 = StrangeInputView.init$lambda$0(StrangeInputView.this, view, motionEvent);
                    return init$lambda$0;
                }
            });
        }
        TIMMentionEditText tIMMentionEditText3 = this.mTextInput;
        if (tIMMentionEditText3 != null) {
            tIMMentionEditText3.setOnKeyListener(new View.OnKeyListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.v0
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    boolean init$lambda$1;
                    init$lambda$1 = StrangeInputView.init$lambda$1(StrangeInputView.this, view, i, keyEvent);
                    return init$lambda$1;
                }
            });
        }
        TIMMentionEditText tIMMentionEditText4 = this.mTextInput;
        if (tIMMentionEditText4 != null) {
            tIMMentionEditText4.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.w0
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    boolean init$lambda$2;
                    init$lambda$2 = StrangeInputView.init$lambda$2(textView, i, keyEvent);
                    return init$lambda$2;
                }
            });
        }
        TIMMentionEditText tIMMentionEditText5 = this.mTextInput;
        if (tIMMentionEditText5 != null) {
            tIMMentionEditText5.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.x0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    StrangeInputView.init$lambda$3(StrangeInputView.this, view, z);
                }
            });
        }
        TIMMentionEditText tIMMentionEditText6 = this.mTextInput;
        if (tIMMentionEditText6 != null) {
            tIMMentionEditText6.setOnMentionInputListener(new TIMMentionEditText.OnMentionInputListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.y0
                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText.OnMentionInputListener
                public final void onMentionCharacterInput(String str) {
                    StrangeInputView.init$lambda$4(StrangeInputView.this, str);
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        TIMMentionEditText tIMMentionEditText;
        List<String> mentionIdList;
        List<String> list;
        TIMMentionEditText tIMMentionEditText2;
        List<String> mentionIdList2;
        List<String> list2;
        Intrinsics.checkNotNullParameter(view, "view");
        int id2 = view.getId();
        int i = 0;
        if (id2 == R.id.emoji) {
            if (this.mCurrentState == 1) {
                this.mCurrentState = -1;
                TIMMentionEditText tIMMentionEditText3 = this.mTextInput;
                if (tIMMentionEditText3 != null) {
                    tIMMentionEditText3.setVisibility(0);
                }
            }
            if (this.mCurrentState == 2) {
                this.mCurrentState = 0;
                ImageView imageView = this.mEmojiInputButton;
                if (imageView != null) {
                    imageView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.icon_chat_emoji));
                }
                TIMMentionEditText tIMMentionEditText4 = this.mTextInput;
                if (tIMMentionEditText4 != null) {
                    tIMMentionEditText4.setVisibility(0);
                }
                showSoftInput();
                return;
            }
            this.mCurrentState = 2;
            ImageView imageView2 = this.mEmojiInputButton;
            if (imageView2 != null) {
                imageView2.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.chat_input_keyboard));
            }
            showFaceViewGroup();
            return;
        }
        if (id2 == R.id.image) {
            OnInputViewListener onInputViewListener = this.mOnInputViewListener;
            if (onInputViewListener != null) {
                onInputViewListener.onClickImage();
            }
            onEmptyClick();
            return;
        }
        if (id2 == R.id.video) {
            OnInputViewListener onInputViewListener2 = this.mOnInputViewListener;
            if (onInputViewListener2 != null) {
                onInputViewListener2.onClickVideo();
            }
            onEmptyClick();
            return;
        }
        if (id2 == R.id.gift) {
            OnInputViewListener onInputViewListener3 = this.mOnInputViewListener;
            if (onInputViewListener3 != null) {
                onInputViewListener3.onClickGift();
            }
            onEmptyClick();
            return;
        }
        if (id2 == R.id.game) {
            ImageView imageView3 = this.mEmojiInputButton;
            if (imageView3 != null) {
                imageView3.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.icon_chat_emoji));
            }
            if (this.mCurrentState == 3) {
                this.mCurrentState = 0;
                TIMMentionEditText tIMMentionEditText5 = this.mTextInput;
                if (tIMMentionEditText5 != null) {
                    tIMMentionEditText5.setVisibility(0);
                }
                showSoftInput();
                return;
            }
            this.mCurrentState = 3;
            showGameView();
            return;
        }
        if (id2 == R.id.send_btn && this.mSendEnable) {
            ChatInfo chatInfo = this.mChatInfo;
            Editable editable = null;
            if (chatInfo == null) {
                MessageHandler messageHandler = this.mMessageHandler;
                if (messageHandler != null) {
                    TIMMentionEditText tIMMentionEditText6 = this.mTextInput;
                    if (tIMMentionEditText6 != null) {
                        editable = tIMMentionEditText6.getText();
                    }
                    messageHandler.sendMessage(ChatMessageBuilder.buildTextMessage(String.valueOf(editable)));
                }
            } else if ((this.isQuoteModel || this.isReplyModel) && this.replyPreviewBean != null) {
                if (chatInfo != null) {
                    i = chatInfo.getType();
                }
                if (TUIChatUtils.isGroupChat(i) && (tIMMentionEditText = this.mTextInput) != null && (mentionIdList = tIMMentionEditText.getMentionIdList()) != null && (!mentionIdList.isEmpty())) {
                    TIMMentionEditText tIMMentionEditText7 = this.mTextInput;
                    if (tIMMentionEditText7 != null) {
                        list = tIMMentionEditText7.getMentionIdList();
                    } else {
                        list = null;
                    }
                    ArrayList arrayList = new ArrayList(list);
                    MessageHandler messageHandler2 = this.mMessageHandler;
                    if (messageHandler2 != null) {
                        TIMMentionEditText tIMMentionEditText8 = this.mTextInput;
                        if (tIMMentionEditText8 != null) {
                            editable = tIMMentionEditText8.getText();
                        }
                        messageHandler2.sendMessage(ChatMessageBuilder.buildAtReplyMessage(String.valueOf(editable), arrayList, this.replyPreviewBean));
                    }
                } else {
                    MessageHandler messageHandler3 = this.mMessageHandler;
                    if (messageHandler3 != null) {
                        TIMMentionEditText tIMMentionEditText9 = this.mTextInput;
                        if (tIMMentionEditText9 != null) {
                            editable = tIMMentionEditText9.getText();
                        }
                        messageHandler3.sendMessage(ChatMessageBuilder.buildReplyMessage(String.valueOf(editable), this.replyPreviewBean));
                    }
                }
                exitReply();
            } else {
                if (chatInfo != null) {
                    i = chatInfo.getType();
                }
                if (TUIChatUtils.isGroupChat(i) && (tIMMentionEditText2 = this.mTextInput) != null && (mentionIdList2 = tIMMentionEditText2.getMentionIdList()) != null && (!mentionIdList2.isEmpty())) {
                    TIMMentionEditText tIMMentionEditText10 = this.mTextInput;
                    if (tIMMentionEditText10 != null) {
                        list2 = tIMMentionEditText10.getMentionIdList();
                    } else {
                        list2 = null;
                    }
                    ArrayList arrayList2 = new ArrayList(list2);
                    if (arrayList2.isEmpty()) {
                        MessageHandler messageHandler4 = this.mMessageHandler;
                        if (messageHandler4 != null) {
                            TIMMentionEditText tIMMentionEditText11 = this.mTextInput;
                            if (tIMMentionEditText11 != null) {
                                editable = tIMMentionEditText11.getText();
                            }
                            messageHandler4.sendMessage(ChatMessageBuilder.buildTextMessage(String.valueOf(editable)));
                        }
                    } else {
                        MessageHandler messageHandler5 = this.mMessageHandler;
                        if (messageHandler5 != null) {
                            TIMMentionEditText tIMMentionEditText12 = this.mTextInput;
                            if (tIMMentionEditText12 != null) {
                                editable = tIMMentionEditText12.getText();
                            }
                            messageHandler5.sendMessage(ChatMessageBuilder.buildTextAtMessage(arrayList2, String.valueOf(editable)));
                        }
                    }
                } else {
                    MessageHandler messageHandler6 = this.mMessageHandler;
                    if (messageHandler6 != null) {
                        TIMMentionEditText tIMMentionEditText13 = this.mTextInput;
                        if (tIMMentionEditText13 != null) {
                            editable = tIMMentionEditText13.getText();
                        }
                        messageHandler6.sendMessage(ChatMessageBuilder.buildTextMessage(String.valueOf(editable)));
                    }
                }
            }
            this.mIsSending = true;
            TIMMentionEditText tIMMentionEditText14 = this.mTextInput;
            if (tIMMentionEditText14 != null) {
                tIMMentionEditText14.setText("");
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        TIMMentionEditText tIMMentionEditText = this.mTextInput;
        if (tIMMentionEditText != null) {
            tIMMentionEditText.removeTextChangedListener(this);
        }
        this.atUserInfoMap.clear();
        ChatInputHandler chatInputHandler = this.mChatInputHandler;
        if (chatInputHandler != null) {
            chatInputHandler.onUserTyping(false, V2TIMManager.getInstance().getServerTime());
        }
    }

    public final void onEmptyClick() {
        hideSoftInput();
        this.mCurrentState = 0;
        hideInputMoreLayout();
        ImageView imageView = this.mEmojiInputButton;
        if (imageView != null) {
            imageView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.icon_chat_emoji));
        }
        TIMMentionEditText tIMMentionEditText = this.mTextInput;
        if (tIMMentionEditText != null) {
            tIMMentionEditText.setVisibility(0);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@NotNull CharSequence s, int start, int before, int count) {
        Intrinsics.checkNotNullParameter(s, "s");
    }

    public final void refreshStrangeView(boolean isStrange) {
        TIMMentionEditText tIMMentionEditText;
        TIMMentionEditText tIMMentionEditText2;
        TIMMentionEditText tIMMentionEditText3;
        View view;
        TIMMentionEditText tIMMentionEditText4;
        TIMMentionEditText tIMMentionEditText5;
        TIMMentionEditText tIMMentionEditText6;
        View view2;
        Drawable drawable = null;
        if (isStrange) {
            HiloChatStrangeInputLayoutBinding hiloChatStrangeInputLayoutBinding = this.mBinding;
            if (hiloChatStrangeInputLayoutBinding != null && (view2 = hiloChatStrangeInputLayoutBinding.topLine) != null) {
                view2.setVisibility(8);
            }
            HiloChatStrangeInputLayoutBinding hiloChatStrangeInputLayoutBinding2 = this.mBinding;
            if (hiloChatStrangeInputLayoutBinding2 != null && (tIMMentionEditText6 = hiloChatStrangeInputLayoutBinding2.chatMessageInput) != null) {
                AppCompatActivity appCompatActivity = this.mActivity;
                if (appCompatActivity != null) {
                    drawable = androidx.core.content.a.getDrawable(appCompatActivity, R.drawable.chat_edite_strange_bg);
                }
                tIMMentionEditText6.setBackground(drawable);
            }
            HiloChatStrangeInputLayoutBinding hiloChatStrangeInputLayoutBinding3 = this.mBinding;
            if (hiloChatStrangeInputLayoutBinding3 != null && (tIMMentionEditText5 = hiloChatStrangeInputLayoutBinding3.chatMessageInput) != null) {
                tIMMentionEditText5.setHintTextColor(Color.parseColor("#7fffffff"));
            }
            HiloChatStrangeInputLayoutBinding hiloChatStrangeInputLayoutBinding4 = this.mBinding;
            if (hiloChatStrangeInputLayoutBinding4 != null && (tIMMentionEditText4 = hiloChatStrangeInputLayoutBinding4.chatMessageInput) != null) {
                tIMMentionEditText4.setTextColor(Color.parseColor("#ffffff"));
                return;
            }
            return;
        }
        HiloChatStrangeInputLayoutBinding hiloChatStrangeInputLayoutBinding5 = this.mBinding;
        if (hiloChatStrangeInputLayoutBinding5 != null && (view = hiloChatStrangeInputLayoutBinding5.topLine) != null) {
            view.setVisibility(0);
        }
        HiloChatStrangeInputLayoutBinding hiloChatStrangeInputLayoutBinding6 = this.mBinding;
        if (hiloChatStrangeInputLayoutBinding6 != null && (tIMMentionEditText3 = hiloChatStrangeInputLayoutBinding6.chatMessageInput) != null) {
            AppCompatActivity appCompatActivity2 = this.mActivity;
            if (appCompatActivity2 != null) {
                drawable = androidx.core.content.a.getDrawable(appCompatActivity2, R.drawable.chat_edite_bg);
            }
            tIMMentionEditText3.setBackground(drawable);
        }
        HiloChatStrangeInputLayoutBinding hiloChatStrangeInputLayoutBinding7 = this.mBinding;
        if (hiloChatStrangeInputLayoutBinding7 != null && (tIMMentionEditText2 = hiloChatStrangeInputLayoutBinding7.chatMessageInput) != null) {
            tIMMentionEditText2.setHintTextColor(Color.parseColor("#999999"));
        }
        HiloChatStrangeInputLayoutBinding hiloChatStrangeInputLayoutBinding8 = this.mBinding;
        if (hiloChatStrangeInputLayoutBinding8 != null && (tIMMentionEditText = hiloChatStrangeInputLayoutBinding8.chatMessageInput) != null) {
            tIMMentionEditText.setTextColor(Color.parseColor("#333333"));
        }
    }

    public final void sendPicture() {
        try {
            PictureSelector.INSTANCE.selectorPicture(new PictureSelectorConfigures.Companion.Builder().isEnablePreviewImage(true).setWithCamera(false).setMMaxSelect(9).setMShowType(SelectMimeType.ofAll()).isMEnableCrop(false).build(), new OnResultCallbackListener<LocalMedia>() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView$sendPicture$1
                public void onCancel() {
                }

                public void onResult(ArrayList<LocalMedia> result) {
                    String compressPath;
                    StrangeInputView.MessageHandler messageHandler;
                    StrangeInputView.MessageHandler messageHandler2;
                    if (result != null && result.size() > 0) {
                        StrangeInputView strangeInputView = StrangeInputView.this;
                        for (LocalMedia localMedia : result) {
                            if (localMedia.isCut() && !localMedia.isCompressed()) {
                                compressPath = localMedia.getCutPath();
                            } else if (!localMedia.isCompressed() && (!localMedia.isCut() || !localMedia.isCompressed())) {
                                if (!TextUtils.isEmpty(localMedia.getRealPath())) {
                                    compressPath = localMedia.getRealPath();
                                } else {
                                    compressPath = localMedia.getPath();
                                }
                            } else {
                                compressPath = localMedia.getCompressPath();
                            }
                            File file = BaseControlUtils.INSTANCE.getFile(compressPath);
                            if (file != null && file.exists()) {
                                if (localMedia.getMimeType() != null) {
                                    String mimeType = localMedia.getMimeType();
                                    Intrinsics.checkNotNullExpressionValue(mimeType, "getMimeType(...)");
                                    if (StringsKt.contains$default(mimeType, "video", false, 2, (Object) null)) {
                                        TUIMessageBean buildVideoMessage = ChatMessageBuilder.buildVideoMessage(file);
                                        messageHandler2 = strangeInputView.mMessageHandler;
                                        if (messageHandler2 != null) {
                                            messageHandler2.sendMessage(buildVideoMessage);
                                        }
                                    }
                                }
                                if (localMedia.getMimeType() != null) {
                                    String mimeType2 = localMedia.getMimeType();
                                    Intrinsics.checkNotNullExpressionValue(mimeType2, "getMimeType(...)");
                                    if (StringsKt.contains$default(mimeType2, "image", false, 2, (Object) null)) {
                                        TUIMessageBean buildImageMessage = ChatMessageBuilder.buildImageMessage(Uri.fromFile(file));
                                        messageHandler = strangeInputView.mMessageHandler;
                                        if (messageHandler != null) {
                                            messageHandler.sendMessage(buildImageMessage);
                                        }
                                    }
                                }
                            } else {
                                return;
                            }
                        }
                        StrangeInputView.this.hideSoftInput();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setChatInfo(@Nullable ChatInfo chatInfo) {
        DraftInfo draft;
        TIMMentionEditText tIMMentionEditText;
        TIMMentionEditText tIMMentionEditText2;
        int i;
        Editable text;
        this.mChatInfo = chatInfo;
        if (chatInfo != null && (draft = chatInfo.getDraft()) != null && !TextUtils.isEmpty(draft.getDraftText()) && this.mTextInput != null) {
            com.google.gson.d dVar = new com.google.gson.d();
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
                    } catch (com.google.gson.r unused) {
                        draftText = str;
                        TUIChatLog.e(TAG, " getCustomJsonMap error ");
                        tIMMentionEditText = this.mTextInput;
                        if (tIMMentionEditText != null) {
                        }
                        tIMMentionEditText2 = this.mTextInput;
                        if (tIMMentionEditText2 == null) {
                        }
                    }
                }
            } catch (com.google.gson.r unused2) {
            }
            tIMMentionEditText = this.mTextInput;
            if (tIMMentionEditText != null) {
                tIMMentionEditText.setText(draftText);
            }
            tIMMentionEditText2 = this.mTextInput;
            if (tIMMentionEditText2 == null) {
                if (tIMMentionEditText2 != null && (text = tIMMentionEditText2.getText()) != null) {
                    i = text.length();
                } else {
                    i = 0;
                }
                tIMMentionEditText2.setSelection(i);
            }
        }
    }

    public final void setChatInputHandler(@Nullable ChatInputHandler handler) {
        this.mChatInputHandler = handler;
    }

    public final void setDraft() {
        Editable editable;
        if (this.mChatInfo == null) {
            TUIChatLog.e(TAG, "set drafts error :  chatInfo is null");
            return;
        }
        TIMMentionEditText tIMMentionEditText = this.mTextInput;
        if (tIMMentionEditText == null) {
            TUIChatLog.e(TAG, "set drafts error :  textInput is null");
            return;
        }
        if (tIMMentionEditText != null) {
            editable = tIMMentionEditText.getText();
        } else {
            editable = null;
        }
        String valueOf = String.valueOf(editable);
        if ((this.isQuoteModel || this.isReplyModel) && this.replyPreviewBean != null) {
            com.google.gson.d dVar = new com.google.gson.d();
            HashMap hashMap = new HashMap();
            hashMap.put("content", valueOf);
            hashMap.put("reply", dVar.s(this.replyPreviewBean));
            valueOf = dVar.s(hashMap);
        }
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null && chatPresenter != null) {
            chatPresenter.setDraft(valueOf);
        }
    }

    protected final void setMActivity(@Nullable AppCompatActivity appCompatActivity) {
        this.mActivity = appCompatActivity;
    }

    protected final void setMBinding(@Nullable HiloChatStrangeInputLayoutBinding hiloChatStrangeInputLayoutBinding) {
        this.mBinding = hiloChatStrangeInputLayoutBinding;
    }

    protected final void setMChatInfo(@Nullable ChatInfo chatInfo) {
        this.mChatInfo = chatInfo;
    }

    protected final void setMEmojiInputButton(@Nullable ImageView imageView) {
        this.mEmojiInputButton = imageView;
    }

    protected final void setMEmojiInputDisable(boolean z) {
        this.mEmojiInputDisable = z;
    }

    protected final void setMGameButton(@Nullable ImageView imageView) {
        this.mGameButton = imageView;
    }

    protected final void setMGiftButton(@Nullable ImageView imageView) {
        this.mGiftButton = imageView;
    }

    protected final void setMImageButton(@Nullable ImageView imageView) {
        this.mImageButton = imageView;
    }

    protected final void setMInputMoreView(@Nullable View view) {
        this.mInputMoreView = view;
    }

    protected final void setMSendButton(@Nullable ImageView imageView) {
        this.mSendButton = imageView;
    }

    protected final void setMTextInput(@Nullable TIMMentionEditText tIMMentionEditText) {
        this.mTextInput = tIMMentionEditText;
    }

    protected final void setMVideoButton(@Nullable ImageView imageView) {
        this.mVideoButton = imageView;
    }

    public final void setMessageHandler(@Nullable MessageHandler handler) {
        this.mMessageHandler = handler;
    }

    public final void setOnInputViewListener(@Nullable OnInputViewListener listener) {
        this.mOnInputViewListener = listener;
    }

    public final void setPresenter(@Nullable ChatPresenter presenter) {
        this.presenter = presenter;
    }

    protected final void showEmojiInputButton(int visibility) {
        ImageView imageView;
        if (!this.mEmojiInputDisable && (imageView = this.mEmojiInputButton) != null) {
            imageView.setVisibility(visibility);
        }
    }

    public final void showReplyPreview(@NotNull ReplyPreviewBean previewBean) {
        Intrinsics.checkNotNullParameter(previewBean, "previewBean");
        exitReply();
        this.replyPreviewBean = previewBean;
        String messageAbstract = previewBean.getMessageAbstract();
        String msgTypeStr = ChatMessageParser.getMsgTypeStr(previewBean.getMessageType());
        FaceManager.emojiJudge(previewBean.getMessageSender() + " : " + msgTypeStr + " " + messageAbstract);
        MessageHandler messageHandler = this.mMessageHandler;
        if (messageHandler != null) {
            messageHandler.scrollToEnd();
        }
        showSoftInput();
    }

    public final void showSoftInput() {
        TUIChatLog.i(TAG, "showSoftInput");
        this.mCurrentState = 0;
        Object systemService = getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (!isSoftInputShown()) {
            inputMethodManager.toggleSoftInput(0, 0);
        }
        BackgroundTasks.getInstance().postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.s0
            @Override // java.lang.Runnable
            public final void run() {
                StrangeInputView.showSoftInput$lambda$7(StrangeInputView.this);
            }
        }, 200L);
        postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.t0
            @Override // java.lang.Runnable
            public final void run() {
                StrangeInputView.showSoftInput$lambda$8(StrangeInputView.this);
            }
        }, 200L);
    }

    public final void showVideo(int visibility) {
        ImageView imageView = this.mVideoButton;
        if (imageView != null) {
            imageView.setVisibility(visibility);
        }
    }

    public final void updateInputText(@NotNull ArrayList<String> names, @Nullable ArrayList<String> ids) {
        int i;
        Editable editable;
        Editable text;
        Intrinsics.checkNotNullParameter(names, "names");
        if (ids != null && !ids.isEmpty()) {
            updateAtUserInfoMap(names, ids);
            if (this.mTextInput != null) {
                Map<String, String> displayAtNameMap = getDisplayAtNameMap(names, ids);
                TIMMentionEditText tIMMentionEditText = this.mTextInput;
                if (tIMMentionEditText != null) {
                    tIMMentionEditText.setMentionMap(displayAtNameMap);
                }
                TIMMentionEditText tIMMentionEditText2 = this.mTextInput;
                int i2 = 0;
                if (tIMMentionEditText2 != null) {
                    i = tIMMentionEditText2.getSelectionEnd();
                } else {
                    i = 0;
                }
                if (i != -1) {
                    TIMMentionEditText tIMMentionEditText3 = this.mTextInput;
                    if (tIMMentionEditText3 != null && (text = tIMMentionEditText3.getText()) != null) {
                        editable = text.insert(i, this.displayInputString);
                    } else {
                        editable = null;
                    }
                    FaceManager.handlerEmojiText(this.mTextInput, String.valueOf(editable), true);
                    TIMMentionEditText tIMMentionEditText4 = this.mTextInput;
                    if (tIMMentionEditText4 != null) {
                        String str = this.displayInputString;
                        if (str != null) {
                            i2 = str.length();
                        }
                        tIMMentionEditText4.setSelection(i + i2);
                    }
                }
                BackgroundTasks.getInstance().postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.r0
                    @Override // java.lang.Runnable
                    public final void run() {
                        StrangeInputView.this.showSoftInput();
                    }
                }, 200L);
            }
        }
    }

    public StrangeInputView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.atUserInfoMap = new HashMap();
        this.isShowCustomFace = true;
        initViews();
    }

    public StrangeInputView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.atUserInfoMap = new HashMap();
        this.isShowCustomFace = true;
        initViews();
    }
}
