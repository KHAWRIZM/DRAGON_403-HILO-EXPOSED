package com.qiahao.nextvideo.room.help;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.hilo_message.data.GroupMessageNew;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.listener.RoomMessageItemListener;
import com.qiahao.hilo_message.message.RoomMessageView;
import com.qiahao.hilo_message.utils.BuildMessageUtilsKt;
import com.qiahao.nextvideo.room.dialog.RoomTipDialog;
import com.qiahao.nextvideo.room.help.VideoUploadManager;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.viewmodel.RoomViewModel;
import com.qiahao.nextvideo.ui.task.TasksActivity;
import com.qiahao.nextvideo.utilities.im.RoomMessageUtil;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.hilo.dialog.IMMessageClickBottomDialog;
import com.tencent.qcloud.tuikit.tuichat.hilo.dialog.IMMessageListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import roomMessage.RoomMessage;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/qiahao/nextvideo/room/help/AudioRoomFragmentHelp$initChatUI$1", "Lcom/qiahao/hilo_message/listener/RoomMessageItemListener;", "onUserIconClick", "", "messageInfo", "Lcom/qiahao/hilo_message/data/RoomMessageMulti;", "onResendMessage", "onType", "type", "", "data", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAudioRoomFragmentHelp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioRoomFragmentHelp.kt\ncom/qiahao/nextvideo/room/help/AudioRoomFragmentHelp$initChatUI$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3693:1\n1#2:3694\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AudioRoomFragmentHelp$initChatUI$1 implements RoomMessageItemListener {
    final /* synthetic */ AudioRoomFragmentHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioRoomFragmentHelp$initChatUI$1(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        this.this$0 = audioRoomFragmentHelp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onType$lambda$1(AudioRoomFragmentHelp audioRoomFragmentHelp, AudioRoomFragmentHelp$initChatUI$1 audioRoomFragmentHelp$initChatUI$1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = audioRoomFragmentHelp.getFragment().getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(audioRoomFragmentHelp$initChatUI$1, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    public void onMessageClick(RoomMessageMulti roomMessageMulti) {
        RoomMessageItemListener.DefaultImpls.onMessageClick(this, roomMessageMulti);
    }

    public void onMessageLongClick(RoomMessageMulti roomMessageMulti) {
        RoomMessageItemListener.DefaultImpls.onMessageLongClick(this, roomMessageMulti);
    }

    public void onReEditRevokeMessage(RoomMessageMulti roomMessageMulti) {
        RoomMessageItemListener.DefaultImpls.onReEditRevokeMessage(this, roomMessageMulti);
    }

    public void onReactOnClick(String str, RoomMessageMulti roomMessageMulti) {
        RoomMessageItemListener.DefaultImpls.onReactOnClick(this, str, roomMessageMulti);
    }

    public void onRecallClick(RoomMessageMulti roomMessageMulti) {
        RoomMessageItemListener.DefaultImpls.onRecallClick(this, roomMessageMulti);
    }

    public void onReplyDetailClick(RoomMessageMulti roomMessageMulti) {
        RoomMessageItemListener.DefaultImpls.onReplyDetailClick(this, roomMessageMulti);
    }

    public void onResendMessage(final RoomMessageMulti messageInfo) {
        final Context context = this.this$0.getFragment().getContext();
        if (context != null) {
            final AudioRoomFragmentHelp audioRoomFragmentHelp = this.this$0;
            new RoomTipDialog(context).setTipContent(ResourcesKtxKt.getStringById(this, 2131953917)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initChatUI$1$onResendMessage$1$1
                public void cancel() {
                    OnCommonDialogListener.DefaultImpls.cancel(this);
                }

                public void confirm() {
                    Integer num;
                    final AudioRoomFragmentHelp audioRoomFragmentHelp2 = audioRoomFragmentHelp;
                    VideoUploadManager.UploadCallback uploadCallback = new VideoUploadManager.UploadCallback() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initChatUI$1$onResendMessage$1$1$confirm$listener$1
                        @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                        public Object addMessageLocal(RoomMessageMulti roomMessageMulti, Continuation<? super Unit> continuation) {
                            return BuildersKt.withContext(Dispatchers.getMain(), new AudioRoomFragmentHelp$initChatUI$1$onResendMessage$1$1$confirm$listener$1$addMessageLocal$2(AudioRoomFragmentHelp.this, roomMessageMulti, null), continuation);
                        }

                        @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                        public Object onUploadFailed(Exception exc, Continuation<? super Unit> continuation) {
                            return VideoUploadManager.UploadCallback.DefaultImpls.onUploadFailed(this, exc, continuation);
                        }

                        @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                        public void onUploadProgress(String str, int i) {
                            VideoUploadManager.UploadCallback.DefaultImpls.onUploadProgress(this, str, i);
                        }

                        @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                        public Object onUploadSuccess(String str, String str2, Continuation<? super Unit> continuation) {
                            return VideoUploadManager.UploadCallback.DefaultImpls.onUploadSuccess(this, str, str2, continuation);
                        }

                        @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                        public Object refreshLocalMessage(RoomMessageMulti roomMessageMulti, Continuation<? super Unit> continuation) {
                            return BuildersKt.withContext(Dispatchers.getMain(), new AudioRoomFragmentHelp$initChatUI$1$onResendMessage$1$1$confirm$listener$1$refreshLocalMessage$2(AudioRoomFragmentHelp.this, roomMessageMulti, null), continuation);
                        }

                        @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                        public Object onUploadFailed(RoomMessageMulti roomMessageMulti, Exception exc, Continuation<? super Unit> continuation) {
                            return BuildersKt.withContext(Dispatchers.getMain(), new AudioRoomFragmentHelp$initChatUI$1$onResendMessage$1$1$confirm$listener$1$onUploadFailed$2(AudioRoomFragmentHelp.this, roomMessageMulti, null), continuation);
                        }

                        @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                        public Object onUploadSuccess(RoomMessage.GroupMessageSend groupMessageSend, boolean z, Continuation<? super Unit> continuation) {
                            Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new AudioRoomFragmentHelp$initChatUI$1$onResendMessage$1$1$confirm$listener$1$onUploadSuccess$2(AudioRoomFragmentHelp.this, groupMessageSend, z, null), continuation);
                            return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
                        }
                    };
                    RoomMessageMulti roomMessageMulti = messageInfo;
                    if (roomMessageMulti != null) {
                        num = Integer.valueOf(roomMessageMulti.getItemType());
                    } else {
                        num = null;
                    }
                    if (num != null && num.intValue() == 1) {
                        GroupMessageNew data = messageInfo.getData();
                        if (data != null) {
                            data.setStatus(0);
                        }
                        RoomMessageView mChatLayout = audioRoomFragmentHelp.getFragment().getMChatLayout();
                        if (mChatLayout != null) {
                            mChatLayout.refreshMessageStatus(messageInfo);
                        }
                        RoomMessageUtil.INSTANCE.sendMessage(audioRoomFragmentHelp.getFragment().getMChatLayout(), BuildMessageUtilsKt.toGroupMessageSend(messageInfo), false);
                        return;
                    }
                    if (num != null && num.intValue() == 2) {
                        VideoUploadManager.INSTANCE.reSendImage(messageInfo, uploadCallback);
                    } else if (num != null && num.intValue() == 3) {
                        VideoUploadManager.INSTANCE.resendVideo(messageInfo, context, uploadCallback);
                    }
                }
            }).show();
        }
    }

    public void onSendFailBtnClick(RoomMessageMulti roomMessageMulti) {
        RoomMessageItemListener.DefaultImpls.onSendFailBtnClick(this, roomMessageMulti);
    }

    public void onTextSelected(RoomMessageMulti roomMessageMulti) {
        RoomMessageItemListener.DefaultImpls.onTextSelected(this, roomMessageMulti);
    }

    public void onTranslationLongClick(RoomMessageMulti roomMessageMulti) {
        RoomMessageItemListener.DefaultImpls.onTranslationLongClick(this, roomMessageMulti);
    }

    public void onType(int type, final Object data) {
        AudioRoomDialogHelp mDialogHelp;
        if (type != 3) {
            if (type != 8) {
                if (type != 5) {
                    if (type == 6 && (data instanceof Long)) {
                        RoomViewModel mViewModel = this.this$0.getFragment().getMViewModel();
                        long longValue = ((Number) data).longValue();
                        final AudioRoomFragmentHelp audioRoomFragmentHelp = this.this$0;
                        mViewModel.getEnvelopeInfo(longValue, new Function1() { // from class: com.qiahao.nextvideo.room.help.q2
                            public final Object invoke(Object obj) {
                                Unit onType$lambda$1;
                                onType$lambda$1 = AudioRoomFragmentHelp$initChatUI$1.onType$lambda$1(AudioRoomFragmentHelp.this, this, (Throwable) obj);
                                return onType$lambda$1;
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((data instanceof String) && (mDialogHelp = this.this$0.getFragment().getMDialogHelp()) != null) {
                    String str = (String) data;
                    mDialogHelp.showUserInfoDialog(str, MeetingRoomManager.INSTANCE.findMicPositionFromExtraId(str));
                    return;
                }
                return;
            }
            Context context = this.this$0.getFragment().getContext();
            if (context != null) {
                TasksActivity.INSTANCE.start(context, 0);
                return;
            }
            return;
        }
        FragmentActivity activity = this.this$0.getFragment().getActivity();
        if (activity != null) {
            final AudioRoomFragmentHelp audioRoomFragmentHelp2 = this.this$0;
            if (!audioRoomFragmentHelp2.getFragment().isDetached() && audioRoomFragmentHelp2.getFragment().getContext() != null) {
                IMMessageClickBottomDialog iMMessageClickBottomDialog = new IMMessageClickBottomDialog(activity);
                iMMessageClickBottomDialog.setMShowDelete(false);
                iMMessageClickBottomDialog.setClickListener(new IMMessageListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initChatUI$1$onType$2$2
                    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.dialog.IMMessageListener
                    @SuppressLint({"WrongConstant"})
                    public void copy() {
                        Object obj;
                        FragmentActivity activity2 = AudioRoomFragmentHelp.this.getFragment().getActivity();
                        String str2 = null;
                        if (activity2 != null) {
                            obj = activity2.getSystemService("clipboard");
                        } else {
                            obj = null;
                        }
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.content.ClipboardManager");
                        ClipboardManager clipboardManager = (ClipboardManager) obj;
                        Object obj2 = data;
                        if (obj2 instanceof String) {
                            str2 = (String) obj2;
                        }
                        clipboardManager.setPrimaryClip(ClipData.newPlainText(Constants.SHARED_MESSAGE_ID_FILE, str2));
                        if (!TextUtils.isEmpty(str2)) {
                            ToastUtil.toastShortMessage(ResourcesKtxKt.getStringById(this, 2131954177));
                        }
                    }

                    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.dialog.IMMessageListener
                    public void delete() {
                    }

                    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.dialog.IMMessageListener
                    public void revocation() {
                        IMMessageListener.DefaultImpls.revocation(this);
                    }
                }).show();
            }
        }
    }

    public void onTypeClick(RoomMessageMulti roomMessageMulti, int i) {
        RoomMessageItemListener.DefaultImpls.onTypeClick(this, roomMessageMulti, i);
    }

    public void onUserIconClick(RoomMessageMulti messageInfo) {
        String str;
        GroupMessageNew data;
        String fromAccount;
        GroupMessageNew data2;
        AudioRoomDialogHelp mDialogHelp = this.this$0.getFragment().getMDialogHelp();
        if (mDialogHelp != null) {
            String str2 = "";
            if (messageInfo == null || (data2 = messageInfo.getData()) == null || (str = data2.getFromAccount()) == null) {
                str = "";
            }
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            if (messageInfo != null && (data = messageInfo.getData()) != null && (fromAccount = data.getFromAccount()) != null) {
                str2 = fromAccount;
            }
            mDialogHelp.showUserInfoDialog(str, meetingRoomManager.findMicPositionFromExtraId(str2));
        }
    }

    public void onUserIconLongClick(RoomMessageMulti roomMessageMulti) {
        RoomMessageItemListener.DefaultImpls.onUserIconLongClick(this, roomMessageMulti);
    }
}
