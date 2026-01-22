package com.tencent.qcloud.tuikit.tuichat.hilo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
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
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.permission.PermissionInterceptor;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.picture.PictureSelector;
import com.qiahao.base_common.utils.picture.PictureSelectorConfigures;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.qiahao.nextvideo.ui.family.FamilySettingFragment;
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
import com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder;
import com.tencent.qcloud.tuikit.tuichat.component.face.CustomFace;
import com.tencent.qcloud.tuikit.tuichat.component.face.Emoji;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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

@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 ¸\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\bµ\u0001¶\u0001·\u0001¸\u0001B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nB%\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rJ\u0010\u0010k\u001a\u00020l2\b\u0010\\\u001a\u0004\u0018\u00010]J\b\u0010m\u001a\u00020lH\u0002J\b\u0010n\u001a\u00020lH\u0005J\u0010\u0010o\u001a\u00020l2\u0006\u0010p\u001a\u00020\u0015H\u0002J\u0006\u0010q\u001a\u00020\u0015J\u001a\u0010r\u001a\u00020l2\u0006\u0010s\u001a\u00020V2\n\b\u0002\u0010t\u001a\u0004\u0018\u00010VJ:\u0010u\u001a\u00020l2\u0016\u0010v\u001a\u0012\u0012\u0004\u0012\u00020V0wj\b\u0012\u0004\u0012\u00020V`x2\u001a\u0010y\u001a\u0016\u0012\u0004\u0012\u00020V\u0018\u00010wj\n\u0012\u0004\u0012\u00020V\u0018\u0001`xJ0\u0010z\u001a\u000e\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020V0{2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020V0|2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020V0|H\u0002J8\u0010}\u001a\u00020l2\u0016\u0010v\u001a\u0012\u0012\u0004\u0012\u00020V0wj\b\u0012\u0004\u0012\u00020V`x2\u0016\u0010y\u001a\u0012\u0012\u0004\u0012\u00020V0wj\b\u0012\u0004\u0012\u00020V`xH\u0002J\b\u0010~\u001a\u00020lH\u0014J\u0011\u0010\u007f\u001a\u00020l2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010DJ\u0012\u0010\u0081\u0001\u001a\u00020l2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010FJ\u0012\u0010\u0082\u0001\u001a\u00020l2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010XJ\u0012\u0010\u0084\u0001\u001a\u00020l2\u0007\u0010\u0085\u0001\u001a\u000204H\u0016J\u0010\u0010\u0086\u0001\u001a\u00020l2\u0007\u0010\u0087\u0001\u001a\u00020\u0015J\t\u0010\u0088\u0001\u001a\u00020lH\u0007J\t\u0010\u0089\u0001\u001a\u00020lH\u0007J\u0007\u0010\u008a\u0001\u001a\u00020lJ\u0010\u0010\u008f\u0001\u001a\u00020l2\u0007\u0010\u0090\u0001\u001a\u00020\u0015J\t\u0010\u0091\u0001\u001a\u00020lH\u0002J\t\u0010\u0092\u0001\u001a\u00020lH\u0002J\t\u0010\u0093\u0001\u001a\u00020lH\u0002J.\u0010\u0094\u0001\u001a\u00020l2\b\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u0097\u0001\u001a\u00020\f2\u0007\u0010\u0098\u0001\u001a\u00020\f2\u0007\u0010\u0099\u0001\u001a\u00020\fH\u0016J.\u0010\u009a\u0001\u001a\u00020l2\b\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u0097\u0001\u001a\u00020\f2\u0007\u0010\u009b\u0001\u001a\u00020\f2\u0007\u0010\u0098\u0001\u001a\u00020\fH\u0016J\u0013\u0010\u009c\u0001\u001a\u00020l2\b\u0010\u0095\u0001\u001a\u00030\u009d\u0001H\u0016J\u0007\u0010\u009e\u0001\u001a\u00020lJ\u0012\u0010\u009f\u0001\u001a\u00020l2\t\u0010 \u0001\u001a\u0004\u0018\u00010VJ\u0010\u0010¡\u0001\u001a\u00020l2\u0007\u0010\u0090\u0001\u001a\u00020\u0015J\u0007\u0010¢\u0001\u001a\u00020lJ\u0010\u0010§\u0001\u001a\u00020l2\u0007\u0010¨\u0001\u001a\u00020aJ\u0007\u0010©\u0001\u001a\u00020lJ\t\u0010ª\u0001\u001a\u00020lH\u0002J\u0010\u0010«\u0001\u001a\u00020l2\u0007\u0010¬\u0001\u001a\u00020\fJ&\u0010\u00ad\u0001\u001a\u00020l2\u0007\u0010®\u0001\u001a\u00020\u00152\t\b\u0002\u0010¯\u0001\u001a\u00020\f2\t\b\u0002\u0010°\u0001\u001a\u00020\fJ\u0012\u0010±\u0001\u001a\u00020l2\u0007\u0010¬\u0001\u001a\u00020\fH\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001c\u0010 \u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001c\u0010#\u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010I\u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0011\"\u0004\bK\u0010\u0013R\u001c\u0010L\u001a\u0004\u0018\u00010MX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u000e\u0010R\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020V0ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u0004\u0018\u00010]X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020hX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u008b\u0001\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u008b\u0001\u0010\u0017R\u0017\u0010\u008c\u0001\u001a\u00020\f8CX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0017\u0010£\u0001\u001a\u0005\u0018\u00010¤\u00018F¢\u0006\b\u001a\u0006\b¥\u0001\u0010¦\u0001R,\u0010²\u0001\u001a\u0004\u0018\u00010:2\t\u0010²\u0001\u001a\u0004\u0018\u00010:8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b³\u0001\u0010<\"\u0005\b´\u0001\u0010>¨\u0006¹\u0001"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/C2CInputView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "Landroid/text/TextWatcher;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mEmojiInputButton", "Landroid/widget/ImageView;", "getMEmojiInputButton", "()Landroid/widget/ImageView;", "setMEmojiInputButton", "(Landroid/widget/ImageView;)V", "mEmojiInputDisable", "", "getMEmojiInputDisable", "()Z", "setMEmojiInputDisable", "(Z)V", "mSendButton", "getMSendButton", "setMSendButton", "mImageButton", "getMImageButton", "setMImageButton", "mVideoButton", "getMVideoButton", "setMVideoButton", "mGiftButton", "getMGiftButton", "setMGiftButton", "mTextInput", "Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/input/TIMMentionEditText;", "getMTextInput", "()Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/input/TIMMentionEditText;", "setMTextInput", "(Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/input/TIMMentionEditText;)V", "mIsSending", "mActivity", "Landroidx/appcompat/app/AppCompatActivity;", "getMActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "setMActivity", "(Landroidx/appcompat/app/AppCompatActivity;)V", "mInputMoreView", "Landroid/view/View;", "getMInputMoreView", "()Landroid/view/View;", "setMInputMoreView", "(Landroid/view/View;)V", "mChatInfo", "Lcom/tencent/qcloud/tuikit/tuichat/bean/ChatInfo;", "getMChatInfo", "()Lcom/tencent/qcloud/tuikit/tuichat/bean/ChatInfo;", "setMChatInfo", "(Lcom/tencent/qcloud/tuikit/tuichat/bean/ChatInfo;)V", "mFaceFragment", "Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/input/face/FaceFragment;", "mGameFragment", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/GameMoreFragment;", "mChatInputHandler", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/C2CInputView$ChatInputHandler;", "mMessageHandler", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/C2CInputView$MessageHandler;", "mFragmentManager", "Landroidx/fragment/app/FragmentManager;", "mGameButton", "getMGameButton", "setMGameButton", "mSvipView", "Landroid/widget/TextView;", "getMSvipView", "()Landroid/widget/TextView;", "setMSvipView", "(Landroid/widget/TextView;)V", "mSendEnable", "mCurrentState", "mLastMsgLineCount", "mInputContent", "", "mOnInputViewListener", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/C2CInputView$OnInputViewListener;", "atUserInfoMap", "", "displayInputString", "presenter", "Lcom/tencent/qcloud/tuikit/tuichat/presenter/ChatPresenter;", "isReplyModel", "isQuoteModel", "replyPreviewBean", "Lcom/tencent/qcloud/tuikit/tuichat/bean/ReplyPreviewBean;", "isShowCustomFace", "mAudioButton", "Landroid/widget/Button;", "mAudioSwitchButton", "showAudio", "mStartRecordY", "", "mAudioCancel", "mShowVipView", "setPresenter", "", "initViews", "init", "recordComplete", com.taobao.agoo.a.a.b.JSON_SUCCESS, "checkMicPermission", "addInputText", "name", AgooConstants.MESSAGE_ID, "updateInputText", "names", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ids", "getDisplayAtNameMap", "", "", "updateAtUserInfoMap", "onDetachedFromWindow", "setChatInputHandler", "handler", "setMessageHandler", "setOnInputViewListener", "listener", "onClick", "view", "showAudioView", "isShow", "showSoftInput", "hideSoftInput", "onEmptyClick", "isSoftInputShown", "navigateBarHeight", "getNavigateBarHeight", "()I", "disableShowCustomFace", "disable", "showGameView", "showFaceViewGroup", "hideInputMoreLayout", "beforeTextChanged", "s", "", "start", "count", "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "setDraft", "appendText", "text", "disableEmojiInput", "sendPicture", "inputText", "Landroid/widget/EditText;", "getInputText", "()Landroid/widget/EditText;", "showReplyPreview", "previewBean", "exitReply", "updateChatBackground", "showVideo", "visibility", "showSvip", "show", "svip", FamilySettingFragment.FAMILY_NUMBER, "showEmojiInputButton", TUIChatConstants.CHAT_INFO, "getChatInfo", "setChatInfo", "MessageHandler", "ChatInputHandler", "OnInputViewListener", "Companion", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nC2CInputView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 C2CInputView.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/C2CInputView\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,965:1\n106#2:966\n78#2,22:967\n1#3:989\n*S KotlinDebug\n*F\n+ 1 C2CInputView.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/C2CInputView\n*L\n732#1:966\n732#1:967,22\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class C2CInputView extends LinearLayout implements View.OnClickListener, TextWatcher {
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
    private Button mAudioButton;
    private boolean mAudioCancel;

    @Nullable
    private ImageView mAudioSwitchButton;

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
    private boolean mShowVipView;
    private float mStartRecordY;

    @Nullable
    private TextView mSvipView;

    @Nullable
    private TIMMentionEditText mTextInput;

    @Nullable
    private ImageView mVideoButton;

    @Nullable
    private ChatPresenter presenter;

    @Nullable
    private ReplyPreviewBean replyPreviewBean;
    private boolean showAudio;
    private static final String TAG = C2CInputView.class.getSimpleName();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/C2CInputView$ChatInputHandler;", "", "onInputAreaClick", "", "onUserTyping", "status", "", AgooConstants.MESSAGE_TIME, "", "onRecordStatusChanged", "", "Companion", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface ChatInputHandler {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int RECORD_CANCEL = 3;
        public static final int RECORD_FAILED = 5;
        public static final int RECORD_START = 1;
        public static final int RECORD_STOP = 2;
        public static final int RECORD_TOO_SHORT = 4;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/C2CInputView$ChatInputHandler$Companion;", "", "<init>", "()V", "RECORD_START", "", "RECORD_STOP", "RECORD_CANCEL", "RECORD_TOO_SHORT", "RECORD_FAILED", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int RECORD_CANCEL = 3;
            public static final int RECORD_FAILED = 5;
            public static final int RECORD_START = 1;
            public static final int RECORD_STOP = 2;
            public static final int RECORD_TOO_SHORT = 4;

            private Companion() {
            }
        }

        void onInputAreaClick();

        void onRecordStatusChanged(int status);

        void onUserTyping(boolean status, long time);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/C2CInputView$MessageHandler;", "", TUIConstants.TUIChat.METHOD_SEND_MESSAGE, "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "scrollToEnd", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface MessageHandler {
        void scrollToEnd();

        void sendMessage(@Nullable TUIMessageBean msg);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/C2CInputView$OnInputViewListener;", "", "onStartGroupMemberSelectActivity", "", "onUpdateChatBackground", "onClickGift", "onClickVideo", "onClickImage", "onClickGame", GameMatchActivity.GAME_ID, "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnInputViewListener {
        void onClickGame(int gameId);

        void onClickGift();

        void onClickImage();

        void onClickVideo();

        void onStartGroupMemberSelectActivity();

        void onUpdateChatBackground();
    }

    public C2CInputView(@Nullable Context context) {
        super(context);
        this.atUserInfoMap = new HashMap();
        this.isShowCustomFace = true;
        initViews();
    }

    public static /* synthetic */ void addInputText$default(C2CInputView c2CInputView, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        c2CInputView.addInputText(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkMicPermission$lambda$7$lambda$6(List list, List list2) {
        Intrinsics.checkNotNullParameter(list, "grantedList");
        Intrinsics.checkNotNullParameter(list2, "deniedList");
        list2.isEmpty();
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

    @SuppressLint({"WrongConstant"})
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
    public static final boolean init$lambda$0(C2CInputView c2CInputView, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            ChatPresenter chatPresenter = c2CInputView.presenter;
            if (chatPresenter != null && chatPresenter != null) {
                chatPresenter.scrollToNewestMessage();
            }
            c2CInputView.showSoftInput();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
    
        if (r6 != 3) goto L٤٤;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean init$lambda$1(final C2CInputView c2CInputView, View view, MotionEvent motionEvent) {
        ChatInputHandler chatInputHandler;
        if (!c2CInputView.checkMicPermission()) {
            return false;
        }
        int action = motionEvent.getAction();
        boolean z = true;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (motionEvent.getY() - c2CInputView.mStartRecordY < -100.0f) {
                        c2CInputView.mAudioCancel = true;
                        ChatInputHandler chatInputHandler2 = c2CInputView.mChatInputHandler;
                        if (chatInputHandler2 != null) {
                            chatInputHandler2.onRecordStatusChanged(3);
                        }
                    } else {
                        if (c2CInputView.mAudioCancel && (chatInputHandler = c2CInputView.mChatInputHandler) != null) {
                            chatInputHandler.onRecordStatusChanged(1);
                        }
                        c2CInputView.mAudioCancel = false;
                    }
                    Button button = c2CInputView.mAudioButton;
                    if (button != null) {
                        button.setText(ResourcesKtxKt.getStringById(c2CInputView, R.string.release_end));
                    }
                }
            }
            if (motionEvent.getY() - c2CInputView.mStartRecordY >= -100.0f) {
                z = false;
            }
            c2CInputView.mAudioCancel = z;
            ChatInputHandler chatInputHandler3 = c2CInputView.mChatInputHandler;
            if (chatInputHandler3 != null) {
                chatInputHandler3.onRecordStatusChanged(2);
            }
            AudioRecorder.getInstance().stopRecord();
            Button button2 = c2CInputView.mAudioButton;
            if (button2 != null) {
                button2.setText(ResourcesKtxKt.getStringById(c2CInputView, R.string.hold_say));
            }
        } else {
            c2CInputView.mAudioCancel = true;
            c2CInputView.mStartRecordY = motionEvent.getY();
            ChatInputHandler chatInputHandler4 = c2CInputView.mChatInputHandler;
            if (chatInputHandler4 != null) {
                chatInputHandler4.onRecordStatusChanged(1);
            }
            Button button3 = c2CInputView.mAudioButton;
            if (button3 != null) {
                button3.setText(ResourcesKtxKt.getStringById(c2CInputView, R.string.release_end));
            }
            AudioRecorder.getInstance().startRecord(new AudioRecorder.Callback() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView$init$2$1
                @Override // com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder.Callback
                public /* bridge */ /* synthetic */ void onCompletion(Boolean bool) {
                    onCompletion(bool.booleanValue());
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder.Callback
                public void onVoiceDb(double db) {
                }

                public void onCompletion(boolean success) {
                    C2CInputView.this.recordComplete(success);
                }
            });
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$2(C2CInputView c2CInputView, View view, int i, KeyEvent keyEvent) {
        Editable editable;
        if (i == 67 && keyEvent.getAction() == 0) {
            if (c2CInputView.isQuoteModel || c2CInputView.isReplyModel) {
                TIMMentionEditText tIMMentionEditText = c2CInputView.mTextInput;
                if (tIMMentionEditText != null) {
                    editable = tIMMentionEditText.getText();
                } else {
                    editable = null;
                }
                if (TextUtils.isEmpty(String.valueOf(editable))) {
                    c2CInputView.exitReply();
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$3(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$4(C2CInputView c2CInputView, View view, boolean z) {
        ChatInputHandler chatInputHandler;
        if (!z && (chatInputHandler = c2CInputView.mChatInputHandler) != null) {
            chatInputHandler.onUserTyping(false, V2TIMManager.getInstance().getServerTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$5(C2CInputView c2CInputView, String str) {
        int i;
        OnInputViewListener onInputViewListener;
        if (Intrinsics.areEqual(str, "@") || Intrinsics.areEqual(str, "＠")) {
            ChatInfo chatInfo = c2CInputView.mChatInfo;
            if (chatInfo != null) {
                i = chatInfo.getType();
            } else {
                i = 0;
            }
            if (TUIChatUtils.isGroupChat(i) && (onInputViewListener = c2CInputView.mOnInputViewListener) != null) {
                onInputViewListener.onStartGroupMemberSelectActivity();
            }
        }
    }

    private final void initViews() {
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(getContext());
        this.mActivity = activity;
        View.inflate(activity, R.layout.hilo_chat_input_layout, this);
        this.mInputMoreView = findViewById(R.id.more_groups);
        this.mEmojiInputButton = (ImageView) findViewById(R.id.emoji);
        this.mSendButton = (ImageView) findViewById(R.id.send_btn);
        this.mImageButton = (ImageView) findViewById(R.id.image);
        this.mGameButton = (ImageView) findViewById(R.id.game);
        this.mVideoButton = (ImageView) findViewById(R.id.video);
        this.mGiftButton = (ImageView) findViewById(R.id.gift);
        this.mTextInput = (TIMMentionEditText) findViewById(R.id.chat_message_input);
        this.mSvipView = (TextView) findViewById(R.id.svipPrivilege);
        this.mAudioButton = (Button) findViewById(R.id.chatVoiceInput);
        this.mAudioSwitchButton = (ImageView) findViewById(R.id.voiceInputSwitch);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordComplete(boolean success) {
        int duration = AudioRecorder.getInstance().getDuration();
        if (success && duration != 0) {
            if (this.mAudioCancel) {
                ChatInputHandler chatInputHandler = this.mChatInputHandler;
                if (chatInputHandler != null) {
                    chatInputHandler.onRecordStatusChanged(3);
                    return;
                }
                return;
            }
            if (duration < 1000) {
                ChatInputHandler chatInputHandler2 = this.mChatInputHandler;
                if (chatInputHandler2 != null) {
                    chatInputHandler2.onRecordStatusChanged(4);
                    return;
                }
                return;
            }
            ChatInputHandler chatInputHandler3 = this.mChatInputHandler;
            if (chatInputHandler3 != null) {
                chatInputHandler3.onRecordStatusChanged(2);
            }
            MessageHandler messageHandler = this.mMessageHandler;
            if (messageHandler != null && success && messageHandler != null) {
                messageHandler.sendMessage(ChatMessageBuilder.buildAudioMessage(AudioRecorder.getInstance().getPath(), duration));
                return;
            }
            return;
        }
        ChatInputHandler chatInputHandler4 = this.mChatInputHandler;
        if (chatInputHandler4 != null) {
            chatInputHandler4.onRecordStatusChanged(5);
        }
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
            faceFragment2.setListener(new FaceFragment.OnEmojiClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView$showFaceViewGroup$1
                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face.FaceFragment.OnEmojiClickListener
                public void onCustomFaceClick(int groupIndex, CustomFace customFace) {
                    C2CInputView.MessageHandler messageHandler;
                    Intrinsics.checkNotNullParameter(customFace, "customFace");
                    messageHandler = C2CInputView.this.mMessageHandler;
                    if (messageHandler != null) {
                        messageHandler.sendMessage(ChatMessageBuilder.buildFaceMessage(groupIndex, customFace.getFaceKey()));
                    }
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face.FaceFragment.OnEmojiClickListener
                public void onEmojiClick(Emoji emoji) {
                    int i;
                    Editable editable;
                    Intrinsics.checkNotNullParameter(emoji, "emoji");
                    TIMMentionEditText mTextInput = C2CInputView.this.getMTextInput();
                    if (mTextInput != null) {
                        i = mTextInput.getSelectionStart();
                    } else {
                        i = 0;
                    }
                    TIMMentionEditText mTextInput2 = C2CInputView.this.getMTextInput();
                    if (mTextInput2 != null) {
                        editable = mTextInput2.getText();
                    } else {
                        editable = null;
                    }
                    if (editable != null) {
                        editable.insert(i, emoji.getFaceKey());
                    }
                    FaceManager.handlerEmojiText(C2CInputView.this.getMTextInput(), editable, true);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face.FaceFragment.OnEmojiClickListener
                public void onEmojiDelete() {
                    int i;
                    Editable editable;
                    Object obj;
                    Object obj2;
                    TIMMentionEditText mTextInput = C2CInputView.this.getMTextInput();
                    if (mTextInput != null) {
                        i = mTextInput.getSelectionStart();
                    } else {
                        i = 0;
                    }
                    TIMMentionEditText mTextInput2 = C2CInputView.this.getMTextInput();
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
        postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.g
            @Override // java.lang.Runnable
            public final void run() {
                C2CInputView.showFaceViewGroup$lambda$15(C2CInputView.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFaceViewGroup$lambda$15(C2CInputView c2CInputView) {
        ChatInputHandler chatInputHandler = c2CInputView.mChatInputHandler;
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
            gameMoreFragment.setClickListener(new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.e
                public final Object invoke(Object obj) {
                    Unit showGameView$lambda$13;
                    showGameView$lambda$13 = C2CInputView.showGameView$lambda$13(C2CInputView.this, ((Integer) obj).intValue());
                    return showGameView$lambda$13;
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
        postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.f
            @Override // java.lang.Runnable
            public final void run() {
                C2CInputView.showGameView$lambda$14(C2CInputView.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGameView$lambda$13(C2CInputView c2CInputView, int i) {
        OnInputViewListener onInputViewListener = c2CInputView.mOnInputViewListener;
        if (onInputViewListener != null) {
            onInputViewListener.onClickGame(i);
        }
        c2CInputView.onEmptyClick();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGameView$lambda$14(C2CInputView c2CInputView) {
        ChatInputHandler chatInputHandler = c2CInputView.mChatInputHandler;
        if (chatInputHandler != null) {
            chatInputHandler.onInputAreaClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSoftInput$lambda$10(C2CInputView c2CInputView) {
        Window window;
        c2CInputView.hideInputMoreLayout();
        ImageView imageView = c2CInputView.mEmojiInputButton;
        if (imageView != null) {
            imageView.setImageDrawable(androidx.core.content.a.getDrawable(c2CInputView.getContext(), R.drawable.icon_chat_emoji));
        }
        TIMMentionEditText tIMMentionEditText = c2CInputView.mTextInput;
        if (tIMMentionEditText != null) {
            tIMMentionEditText.setVisibility(0);
        }
        TIMMentionEditText tIMMentionEditText2 = c2CInputView.mTextInput;
        if (tIMMentionEditText2 != null) {
            tIMMentionEditText2.requestFocus();
        }
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(c2CInputView.getContext());
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSoftInput$lambda$11(C2CInputView c2CInputView) {
        ChatInputHandler chatInputHandler = c2CInputView.mChatInputHandler;
        if (chatInputHandler != null) {
            chatInputHandler.onInputAreaClick();
        }
    }

    public static /* synthetic */ void showSvip$default(C2CInputView c2CInputView, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        c2CInputView.showSvip(z, i, i2);
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
            updateAtUserInfoMap(new ArrayList<String>(name) { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView$addInputText$nameList$1
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
            }, new ArrayList<String>(id2) { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView$addInputText$idList$1
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

    public final boolean checkMicPermission() {
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(getContext());
        if (activity != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(fa.b.j());
            arrayList.add(fa.b.o());
            boolean n = w9.h.n(activity, arrayList);
            if (!n) {
                w9.h.t(activity).q(arrayList).j(new PermissionInterceptor()).r(new w9.c() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.a
                    public final void onResult(List list, List list2) {
                        C2CInputView.checkMicPermission$lambda$7$lambda$6(list, list2);
                    }
                });
                return n;
            }
            return n;
        }
        return false;
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

    @Nullable
    protected final TextView getMSvipView() {
        return this.mSvipView;
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

    @SuppressLint({"WrongConstant"})
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
        TextView textView = this.mSvipView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        ImageView imageView7 = this.mAudioSwitchButton;
        if (imageView7 != null) {
            imageView7.setOnClickListener(this);
        }
        TIMMentionEditText tIMMentionEditText2 = this.mTextInput;
        if (tIMMentionEditText2 != null) {
            tIMMentionEditText2.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.k
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean init$lambda$0;
                    init$lambda$0 = C2CInputView.init$lambda$0(C2CInputView.this, view, motionEvent);
                    return init$lambda$0;
                }
            });
        }
        Button button = this.mAudioButton;
        if (button != null) {
            button.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.l
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean init$lambda$1;
                    init$lambda$1 = C2CInputView.init$lambda$1(C2CInputView.this, view, motionEvent);
                    return init$lambda$1;
                }
            });
        }
        TIMMentionEditText tIMMentionEditText3 = this.mTextInput;
        if (tIMMentionEditText3 != null) {
            tIMMentionEditText3.setOnKeyListener(new View.OnKeyListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.m
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    boolean init$lambda$2;
                    init$lambda$2 = C2CInputView.init$lambda$2(C2CInputView.this, view, i, keyEvent);
                    return init$lambda$2;
                }
            });
        }
        TIMMentionEditText tIMMentionEditText4 = this.mTextInput;
        if (tIMMentionEditText4 != null) {
            tIMMentionEditText4.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.b
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                    boolean init$lambda$3;
                    init$lambda$3 = C2CInputView.init$lambda$3(textView2, i, keyEvent);
                    return init$lambda$3;
                }
            });
        }
        TIMMentionEditText tIMMentionEditText5 = this.mTextInput;
        if (tIMMentionEditText5 != null) {
            tIMMentionEditText5.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.c
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    C2CInputView.init$lambda$4(C2CInputView.this, view, z);
                }
            });
        }
        TIMMentionEditText tIMMentionEditText6 = this.mTextInput;
        if (tIMMentionEditText6 != null) {
            tIMMentionEditText6.setOnMentionInputListener(new TIMMentionEditText.OnMentionInputListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.d
                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText.OnMentionInputListener
                public final void onMentionCharacterInput(String str) {
                    C2CInputView.init$lambda$5(C2CInputView.this, str);
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
        if (id2 == R.id.voiceInputSwitch) {
            hideInputMoreLayout();
            if (!this.showAudio && this.mShowVipView) {
                TextView textView = this.mSvipView;
                if (textView != null) {
                    textView.setVisibility(0);
                }
            } else {
                TextView textView2 = this.mSvipView;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            }
            if (!this.mShowVipView) {
                showAudioView(!this.showAudio);
                return;
            }
            return;
        }
        if (id2 == R.id.emoji) {
            if (this.mCurrentState == 1) {
                this.showAudio = false;
                this.mCurrentState = -1;
                ImageView imageView = this.mAudioSwitchButton;
                if (imageView != null) {
                    imageView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.icon_chat_audio));
                }
                Button button = this.mAudioButton;
                if (button != null) {
                    button.setVisibility(8);
                }
                TIMMentionEditText tIMMentionEditText3 = this.mTextInput;
                if (tIMMentionEditText3 != null) {
                    tIMMentionEditText3.setVisibility(0);
                }
            }
            if (this.mCurrentState == 2) {
                this.mCurrentState = 0;
                ImageView imageView2 = this.mEmojiInputButton;
                if (imageView2 != null) {
                    imageView2.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.icon_chat_emoji));
                }
                TIMMentionEditText tIMMentionEditText4 = this.mTextInput;
                if (tIMMentionEditText4 != null) {
                    tIMMentionEditText4.setVisibility(0);
                }
                showSoftInput();
                return;
            }
            this.mCurrentState = 2;
            ImageView imageView3 = this.mEmojiInputButton;
            if (imageView3 != null) {
                imageView3.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.chat_input_keyboard));
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
        if (id2 == R.id.svipPrivilege) {
            showSvip$default(this, false, 0, 0, 6, null);
            TIMMentionEditText tIMMentionEditText5 = this.mTextInput;
            if (tIMMentionEditText5 != null) {
                tIMMentionEditText5.requestFocus();
                return;
            }
            return;
        }
        if (id2 == R.id.game) {
            ImageView imageView4 = this.mEmojiInputButton;
            if (imageView4 != null) {
                imageView4.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.icon_chat_emoji));
            }
            if (this.mCurrentState == 1) {
                ImageView imageView5 = this.mAudioSwitchButton;
                if (imageView5 != null) {
                    imageView5.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.icon_chat_audio));
                }
                Button button2 = this.mAudioButton;
                if (button2 != null) {
                    button2.setVisibility(8);
                }
                TIMMentionEditText tIMMentionEditText6 = this.mTextInput;
                if (tIMMentionEditText6 != null) {
                    tIMMentionEditText6.setVisibility(0);
                }
            }
            if (this.mCurrentState == 3) {
                this.mCurrentState = 0;
                TIMMentionEditText tIMMentionEditText7 = this.mTextInput;
                if (tIMMentionEditText7 != null) {
                    tIMMentionEditText7.setVisibility(0);
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
                    TIMMentionEditText tIMMentionEditText8 = this.mTextInput;
                    if (tIMMentionEditText8 != null) {
                        editable = tIMMentionEditText8.getText();
                    }
                    messageHandler.sendMessage(ChatMessageBuilder.buildTextMessage(String.valueOf(editable)));
                }
            } else if ((this.isQuoteModel || this.isReplyModel) && this.replyPreviewBean != null) {
                if (chatInfo != null) {
                    i = chatInfo.getType();
                }
                if (TUIChatUtils.isGroupChat(i) && (tIMMentionEditText = this.mTextInput) != null && (mentionIdList = tIMMentionEditText.getMentionIdList()) != null && (!mentionIdList.isEmpty())) {
                    TIMMentionEditText tIMMentionEditText9 = this.mTextInput;
                    if (tIMMentionEditText9 != null) {
                        list = tIMMentionEditText9.getMentionIdList();
                    } else {
                        list = null;
                    }
                    ArrayList arrayList = new ArrayList(list);
                    MessageHandler messageHandler2 = this.mMessageHandler;
                    if (messageHandler2 != null) {
                        TIMMentionEditText tIMMentionEditText10 = this.mTextInput;
                        if (tIMMentionEditText10 != null) {
                            editable = tIMMentionEditText10.getText();
                        }
                        messageHandler2.sendMessage(ChatMessageBuilder.buildAtReplyMessage(String.valueOf(editable), arrayList, this.replyPreviewBean));
                    }
                } else {
                    MessageHandler messageHandler3 = this.mMessageHandler;
                    if (messageHandler3 != null) {
                        TIMMentionEditText tIMMentionEditText11 = this.mTextInput;
                        if (tIMMentionEditText11 != null) {
                            editable = tIMMentionEditText11.getText();
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
                    TIMMentionEditText tIMMentionEditText12 = this.mTextInput;
                    if (tIMMentionEditText12 != null) {
                        list2 = tIMMentionEditText12.getMentionIdList();
                    } else {
                        list2 = null;
                    }
                    ArrayList arrayList2 = new ArrayList(list2);
                    if (arrayList2.isEmpty()) {
                        MessageHandler messageHandler4 = this.mMessageHandler;
                        if (messageHandler4 != null) {
                            TIMMentionEditText tIMMentionEditText13 = this.mTextInput;
                            if (tIMMentionEditText13 != null) {
                                editable = tIMMentionEditText13.getText();
                            }
                            messageHandler4.sendMessage(ChatMessageBuilder.buildTextMessage(String.valueOf(editable)));
                        }
                    } else {
                        MessageHandler messageHandler5 = this.mMessageHandler;
                        if (messageHandler5 != null) {
                            TIMMentionEditText tIMMentionEditText14 = this.mTextInput;
                            if (tIMMentionEditText14 != null) {
                                editable = tIMMentionEditText14.getText();
                            }
                            messageHandler5.sendMessage(ChatMessageBuilder.buildTextAtMessage(arrayList2, String.valueOf(editable)));
                        }
                    }
                } else {
                    MessageHandler messageHandler6 = this.mMessageHandler;
                    if (messageHandler6 != null) {
                        TIMMentionEditText tIMMentionEditText15 = this.mTextInput;
                        if (tIMMentionEditText15 != null) {
                            editable = tIMMentionEditText15.getText();
                        }
                        messageHandler6.sendMessage(ChatMessageBuilder.buildTextMessage(String.valueOf(editable)));
                    }
                }
            }
            this.mIsSending = true;
            TIMMentionEditText tIMMentionEditText16 = this.mTextInput;
            if (tIMMentionEditText16 != null) {
                tIMMentionEditText16.setText("");
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
        ImageView imageView2 = this.mAudioSwitchButton;
        if (imageView2 != null) {
            imageView2.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.icon_chat_audio));
        }
        this.showAudio = false;
        Button button = this.mAudioButton;
        if (button != null) {
            button.setVisibility(8);
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

    public final void sendPicture() {
        try {
            PictureSelector.INSTANCE.selectorPicture(new PictureSelectorConfigures.Companion.Builder().setMShowType(SelectMimeType.ofAll()).isEnablePreviewImage(true).setWithCamera(true).setMMaxSelect(9).isMEnableCrop(false).build(), new OnResultCallbackListener<LocalMedia>() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView$sendPicture$1
                public void onCancel() {
                }

                public void onResult(ArrayList<LocalMedia> result) {
                    String compressPath;
                    C2CInputView.MessageHandler messageHandler;
                    C2CInputView.MessageHandler messageHandler2;
                    if (result != null && result.size() > 0) {
                        C2CInputView c2CInputView = C2CInputView.this;
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
                                        messageHandler2 = c2CInputView.mMessageHandler;
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
                                        messageHandler = c2CInputView.mMessageHandler;
                                        if (messageHandler != null) {
                                            messageHandler.sendMessage(buildImageMessage);
                                        }
                                    }
                                }
                            } else {
                                return;
                            }
                        }
                        C2CInputView.this.hideSoftInput();
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

    protected final void setMSvipView(@Nullable TextView textView) {
        this.mSvipView = textView;
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

    public final void showAudioView(boolean isShow) {
        this.showAudio = isShow;
        if (isShow) {
            this.mCurrentState = 1;
            ImageView imageView = this.mAudioSwitchButton;
            if (imageView != null) {
                imageView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.icon_chat_keyboard));
            }
            Button button = this.mAudioButton;
            if (button != null) {
                button.setVisibility(0);
            }
            TIMMentionEditText tIMMentionEditText = this.mTextInput;
            if (tIMMentionEditText != null) {
                tIMMentionEditText.setVisibility(8);
                return;
            }
            return;
        }
        this.mCurrentState = 0;
        ImageView imageView2 = this.mAudioSwitchButton;
        if (imageView2 != null) {
            imageView2.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.icon_chat_audio));
        }
        Button button2 = this.mAudioButton;
        if (button2 != null) {
            button2.setVisibility(8);
        }
        TIMMentionEditText tIMMentionEditText2 = this.mTextInput;
        if (tIMMentionEditText2 != null) {
            tIMMentionEditText2.setVisibility(0);
        }
        showSoftInput();
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

    @SuppressLint({"WrongConstant"})
    public final void showSoftInput() {
        TUIChatLog.i(TAG, "showSoftInput");
        this.mCurrentState = 0;
        Object systemService = getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (!isSoftInputShown()) {
            inputMethodManager.toggleSoftInput(0, 0);
        }
        BackgroundTasks.getInstance().postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.h
            @Override // java.lang.Runnable
            public final void run() {
                C2CInputView.showSoftInput$lambda$10(C2CInputView.this);
            }
        }, 200L);
        postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.i
            @Override // java.lang.Runnable
            public final void run() {
                C2CInputView.showSoftInput$lambda$11(C2CInputView.this);
            }
        }, 200L);
    }

    public final void showSvip(boolean show, int svip, int number) {
        if (show) {
            if (svip > 7 && number > 0) {
                TextView textView = this.mSvipView;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                TextView textView2 = this.mSvipView;
                if (textView2 != null) {
                    String format = String.format(ResourcesKtxKt.getStringById(this, R.string.svip_privilege_chat), Arrays.copyOf(new Object[]{Integer.valueOf(number)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    textView2.setText(format);
                }
                this.mShowVipView = true;
                return;
            }
            return;
        }
        TextView textView3 = this.mSvipView;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        this.mShowVipView = false;
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
                BackgroundTasks.getInstance().postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        C2CInputView.this.showSoftInput();
                    }
                }, 200L);
            }
        }
    }

    public C2CInputView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.atUserInfoMap = new HashMap();
        this.isShowCustomFace = true;
        initViews();
    }

    public C2CInputView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.atUserInfoMap = new HashMap();
        this.isShowCustomFace = true;
        initViews();
    }
}
