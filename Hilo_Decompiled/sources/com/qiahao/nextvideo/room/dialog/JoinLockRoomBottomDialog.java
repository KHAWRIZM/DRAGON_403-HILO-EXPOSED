package com.qiahao.nextvideo.room.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.makeramen.roundedimageview.RoundedImageView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.interfaceing.SelectInterface;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.ReportDialog;
import com.qiahao.base_common.ui.dialog.TipBlackDialog;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.InRoomBean;
import com.qiahao.nextvideo.data.room.RoomPK;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.databinding.DialogJoinLockRoomBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.manager.GroupEvent;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.ui.base.BlockOrReportDialog;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.FastClickUtils;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001^B\u0087\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001a\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u0016H\u0003¢\u0006\u0004\b\u001b\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001c\u0010\u0018J\u000f\u0010\u001d\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001d\u0010\u0018J\u0017\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010!H\u0014¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0016¢\u0006\u0004\b%\u0010\u0018J\u0017\u0010(\u001a\u00020\u00162\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0016H\u0016¢\u0006\u0004\b*\u0010\u0018J\r\u0010+\u001a\u00020\u0016¢\u0006\u0004\b+\u0010\u0018R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u0010 R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u00101\u001a\u0004\b5\u00103\"\u0004\b6\u0010 R$\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u00101\u001a\u0004\b7\u00103\"\u0004\b8\u0010 R$\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u00101\u001a\u0004\b9\u00103\"\u0004\b:\u0010 R$\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u00101\u001a\u0004\b;\u00103\"\u0004\b<\u0010 R$\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u00101\u001a\u0004\b=\u00103\"\u0004\b>\u0010 R\"\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\"\u0010O\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u00101\u001a\u0004\bP\u00103\"\u0004\bQ\u0010 R\u0018\u0010R\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR$\u0010U\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010[\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010D\u001a\u0004\b\\\u0010F\"\u0004\b]\u0010H¨\u0006_"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/JoinLockRoomBottomDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "mCurrentContext", "", "groupId", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "groupDetail", "", "theme", "groupCode", "groupFaceString", "groupName", "groupCountry", TUIConstants.TUIGroup.GROUP_INTRODUCTION, "groupAnnouncement", "sceneType", "", "needFinishOlderRoom", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/qiahao/nextvideo/data/model/GroupDetailBean;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "", "initDataBindingAndView", "()V", "initFistView", "requestDataAndinitView", "initView", "showBlockOrReport", "reportGroup", "password", "enterRoom", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initStyle", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "dismiss", "blackOrReport", "Landroid/content/Context;", "getMCurrentContext", "()Landroid/content/Context;", "setMCurrentContext", "(Landroid/content/Context;)V", "Ljava/lang/String;", "getGroupCode", "()Ljava/lang/String;", "setGroupCode", "getGroupFaceString", "setGroupFaceString", "getGroupName", "setGroupName", "getGroupCountry", "setGroupCountry", "getGroupIntroduction", "setGroupIntroduction", "getGroupAnnouncement", "setGroupAnnouncement", "I", "getSceneType", "()I", "setSceneType", "(I)V", "Z", "getNeedFinishOlderRoom", "()Z", "setNeedFinishOlderRoom", "(Z)V", "Lcom/qiahao/nextvideo/databinding/DialogJoinLockRoomBinding;", "mDialogJoinLockRoomBinding", "Lcom/qiahao/nextvideo/databinding/DialogJoinLockRoomBinding;", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "mGroupId", "getMGroupId", "setMGroupId", "mGroupDetail", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "Lcom/qiahao/nextvideo/room/dialog/CommonLoadingDialog;", "dialog", "Lcom/qiahao/nextvideo/room/dialog/CommonLoadingDialog;", "getDialog", "()Lcom/qiahao/nextvideo/room/dialog/CommonLoadingDialog;", "setDialog", "(Lcom/qiahao/nextvideo/room/dialog/CommonLoadingDialog;)V", "canTouch", "getCanTouch", "setCanTouch", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class JoinLockRoomBottomDialog extends BottomSheetDialog implements View.OnClickListener {

    @NotNull
    private static final String TAG = "JoinedRoomInfoBottomShe";
    private boolean canTouch;

    @Nullable
    private CommonLoadingDialog dialog;

    @Nullable
    private String groupAnnouncement;

    @Nullable
    private String groupCode;

    @Nullable
    private String groupCountry;

    @Nullable
    private String groupFaceString;

    @Nullable
    private String groupIntroduction;

    @Nullable
    private String groupName;

    @Nullable
    private nd.a mCompositeDisposable;

    @NotNull
    private Context mCurrentContext;
    private DialogJoinLockRoomBinding mDialogJoinLockRoomBinding;

    @Nullable
    private GroupDetailBean mGroupDetail;

    @NotNull
    private String mGroupId;
    private boolean needFinishOlderRoom;
    private int sceneType;

    public /* synthetic */ JoinLockRoomBottomDialog(Context context, String str, GroupDetailBean groupDetailBean, int i, String str2, String str3, String str4, String str5, String str6, String str7, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, groupDetailBean, (i3 & 8) != 0 ? R.style.HiloBottomSheetDialog : i, (i3 & 16) != 0 ? "" : str2, (i3 & 32) != 0 ? "" : str3, (i3 & 64) != 0 ? "" : str4, (i3 & 128) != 0 ? "" : str5, (i3 & 256) != 0 ? "" : str6, (i3 & 512) != 0 ? "" : str7, (i3 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? 0 : i2, (i3 & 2048) != 0 ? false : z);
    }

    private final void enterRoom(final String password) {
        nd.c observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().inRoom(this.mGroupId, this.sceneType, "", password, 0, "", false, 0), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.a0
            public final Object invoke(Object obj) {
                Unit enterRoom$lambda$9;
                enterRoom$lambda$9 = JoinLockRoomBottomDialog.enterRoom$lambda$9(JoinLockRoomBottomDialog.this, password, (ApiResponse) obj);
                return enterRoom$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.b0
            public final Object invoke(Object obj) {
                Unit enterRoom$lambda$10;
                enterRoom$lambda$10 = JoinLockRoomBottomDialog.enterRoom$lambda$10(JoinLockRoomBottomDialog.this, (Throwable) obj);
                return enterRoom$lambda$10;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.room.dialog.c0
            public final Object invoke() {
                Unit enterRoom$lambda$11;
                enterRoom$lambda$11 = JoinLockRoomBottomDialog.enterRoom$lambda$11(JoinLockRoomBottomDialog.this);
                return enterRoom$lambda$11;
            }
        }, false, 8, (Object) null);
        nd.a aVar = this.mCompositeDisposable;
        Intrinsics.checkNotNull(aVar);
        RxUtilsKt.addTo(observeOnMainThread$default, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit enterRoom$lambda$10(JoinLockRoomBottomDialog joinLockRoomBottomDialog, Throwable th) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            int code = hiloException.getCode();
            if (code != 14005) {
                if (code != 14007) {
                    if (code != 14011) {
                        HiloToasty.Companion companion = HiloToasty.Companion;
                        Context context = joinLockRoomBottomDialog.getContext();
                        String localizedMessage = hiloException.getLocalizedMessage();
                        if (localizedMessage == null) {
                            str2 = ResourcesKtxKt.getStringById(joinLockRoomBottomDialog, 2131952667);
                        } else {
                            str2 = localizedMessage;
                        }
                        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str2, false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                        }
                    } else {
                        Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, joinLockRoomBottomDialog.getContext(), ResourcesKtxKt.getStringById(joinLockRoomBottomDialog, 2131952976), false, 4, (Object) null);
                        if (normal$default2 != null) {
                            normal$default2.show();
                        }
                    }
                } else {
                    HiloToasty.Companion companion2 = HiloToasty.Companion;
                    Context context2 = joinLockRoomBottomDialog.getContext();
                    String format = String.format(ResourcesKtxKt.getStringById(joinLockRoomBottomDialog, 2131952985), Arrays.copyOf(new Object[]{AgooConstants.ACK_REMOVE_PACKAGE}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    Toast normal$default3 = HiloToasty.Companion.normal$default(companion2, context2, format, false, 4, (Object) null);
                    if (normal$default3 != null) {
                        normal$default3.show();
                    }
                }
            } else {
                Toast normal = HiloToasty.Companion.normal(joinLockRoomBottomDialog.getContext(), ResourcesKtxKt.getStringById(joinLockRoomBottomDialog, 2131952092), false);
                if (normal != null) {
                    normal.show();
                }
            }
        } else {
            HiloToasty.Companion companion3 = HiloToasty.Companion;
            Context context3 = joinLockRoomBottomDialog.getContext();
            String localizedMessage2 = th.getLocalizedMessage();
            if (localizedMessage2 == null) {
                str = ResourcesKtxKt.getStringById(joinLockRoomBottomDialog, 2131952667);
            } else {
                str = localizedMessage2;
            }
            Toast normal$default4 = HiloToasty.Companion.normal$default(companion3, context3, str, false, 4, (Object) null);
            if (normal$default4 != null) {
                normal$default4.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit enterRoom$lambda$11(JoinLockRoomBottomDialog joinLockRoomBottomDialog) {
        joinLockRoomBottomDialog.canTouch = true;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit enterRoom$lambda$9(JoinLockRoomBottomDialog joinLockRoomBottomDialog, String str, ApiResponse apiResponse) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        int i3;
        String token;
        String channelId;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (!meetingRoomManager.isRoomSmall()) {
            str2 = "";
        } else {
            str2 = meetingRoomManager.getMGroupId();
        }
        boolean areEqual = Intrinsics.areEqual(joinLockRoomBottomDialog.mGroupId, str2);
        RoomPK roomPK = null;
        if (meetingRoomManager.getMGroupId().length() > 0) {
            if (str2.length() == 0) {
                if (Intrinsics.areEqual(joinLockRoomBottomDialog.mGroupId, meetingRoomManager.getMGroupId())) {
                    cf.c.c().l(new RoomEvent().closeRoom(meetingRoomManager.getMGroupId(), false));
                } else {
                    cf.c.c().l(new RoomEvent().closeRoom(meetingRoomManager.getMGroupId(), true));
                }
            } else if (!areEqual) {
                MeetingRoomManager.leaveRoom$default(meetingRoomManager, false, 1, null);
            }
        }
        cf.c.c().l(new RoomEvent().setEventId(RoomEvent.ROOM_IN));
        n5.e.c("startFormPassWord 打开房间页面8");
        StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
        String str5 = joinLockRoomBottomDialog.mGroupId;
        boolean areEqual2 = Intrinsics.areEqual(str5, str2);
        InRoomBean inRoomBean = (InRoomBean) apiResponse.getData();
        if (inRoomBean == null || (channelId = inRoomBean.getChannelId()) == null) {
            str3 = "";
        } else {
            str3 = channelId;
        }
        InRoomBean inRoomBean2 = (InRoomBean) apiResponse.getData();
        if (inRoomBean2 != null) {
            i = inRoomBean2.getAgoraId();
        } else {
            i = 0;
        }
        InRoomBean inRoomBean3 = (InRoomBean) apiResponse.getData();
        if (inRoomBean3 == null || (token = inRoomBean3.getToken()) == null) {
            str4 = "";
        } else {
            str4 = token;
        }
        InRoomBean inRoomBean4 = (InRoomBean) apiResponse.getData();
        if (inRoomBean4 != null) {
            i2 = inRoomBean4.getMicNumType();
        } else {
            i2 = 0;
        }
        InRoomBean inRoomBean5 = (InRoomBean) apiResponse.getData();
        if (inRoomBean5 != null) {
            i3 = inRoomBean5.getProvider();
        } else {
            i3 = -1;
        }
        com.google.gson.d gson = BaseApplication.Companion.getGSON();
        InRoomBean inRoomBean6 = (InRoomBean) apiResponse.getData();
        if (inRoomBean6 != null) {
            roomPK = inRoomBean6.getGroupPk();
        }
        StartRoomUtils.start$default(startRoomUtils, str5, areEqual2, 0, null, str, str3, str4, i, i2, 0, null, gson.s(roomPK), true, i3, false, 0, 50700, null);
        joinLockRoomBottomDialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void initDataBindingAndView() {
        DialogJoinLockRoomBinding dialogJoinLockRoomBinding = null;
        DialogJoinLockRoomBinding dialogJoinLockRoomBinding2 = (DialogJoinLockRoomBinding) androidx.databinding.g.h(LayoutInflater.from(this.mCurrentContext), R.layout.dialog_join_lock_room, (ViewGroup) null, false);
        this.mDialogJoinLockRoomBinding = dialogJoinLockRoomBinding2;
        if (dialogJoinLockRoomBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogJoinLockRoomBinding");
            dialogJoinLockRoomBinding2 = null;
        }
        setContentView(dialogJoinLockRoomBinding2.getRoot());
        DialogJoinLockRoomBinding dialogJoinLockRoomBinding3 = this.mDialogJoinLockRoomBinding;
        if (dialogJoinLockRoomBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogJoinLockRoomBinding");
        } else {
            dialogJoinLockRoomBinding = dialogJoinLockRoomBinding3;
        }
        dialogJoinLockRoomBinding.setClick(this);
        if (this.mGroupDetail != null) {
            initView();
        } else {
            initFistView();
        }
        requestDataAndinitView();
    }

    private final void initFistView() {
        String str = this.groupFaceString;
        if (str != null && str.length() != 0) {
            DialogJoinLockRoomBinding dialogJoinLockRoomBinding = this.mDialogJoinLockRoomBinding;
            if (dialogJoinLockRoomBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogJoinLockRoomBinding");
                dialogJoinLockRoomBinding = null;
            }
            ImageView imageView = dialogJoinLockRoomBinding.bgGroupPic;
            Intrinsics.checkNotNullExpressionValue(imageView, "bgGroupPic");
            ImageKtxKt.loadImage$default(imageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            DialogJoinLockRoomBinding dialogJoinLockRoomBinding2 = this.mDialogJoinLockRoomBinding;
            if (dialogJoinLockRoomBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogJoinLockRoomBinding");
                dialogJoinLockRoomBinding2 = null;
            }
            RoundedImageView roundedImageView = dialogJoinLockRoomBinding2.groupPic;
            Intrinsics.checkNotNullExpressionValue(roundedImageView, "groupPic");
            ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
            ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
            Dimens dimens = Dimens.INSTANCE;
            fill.setWidth(dimens.dpToPx(97));
            fill.setHeight(dimens.dpToPx(97));
            Unit unit = Unit.INSTANCE;
            ViewUtilitiesKt.bind(roundedImageView, companion.displayImage(str, fill));
        }
        String str2 = this.groupName;
        if (str2 != null && str2.length() != 0) {
            DialogJoinLockRoomBinding dialogJoinLockRoomBinding3 = this.mDialogJoinLockRoomBinding;
            if (dialogJoinLockRoomBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogJoinLockRoomBinding");
                dialogJoinLockRoomBinding3 = null;
            }
            dialogJoinLockRoomBinding3.groupName.setText(str2);
        }
        String str3 = this.groupCountry;
        if (str3 != null && str3.length() != 0) {
            DialogJoinLockRoomBinding dialogJoinLockRoomBinding4 = this.mDialogJoinLockRoomBinding;
            if (dialogJoinLockRoomBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogJoinLockRoomBinding");
                dialogJoinLockRoomBinding4 = null;
            }
            ImageView imageView2 = dialogJoinLockRoomBinding4.countPic;
            Intrinsics.checkNotNullExpressionValue(imageView2, "countPic");
            ViewUtilitiesKt.bind(imageView2, ImageUIModel.INSTANCE.countryTag(this.groupCountry));
        }
        String str4 = this.groupCode;
        if (str4 != null && str4.length() != 0) {
            DialogJoinLockRoomBinding dialogJoinLockRoomBinding5 = this.mDialogJoinLockRoomBinding;
            if (dialogJoinLockRoomBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogJoinLockRoomBinding");
                dialogJoinLockRoomBinding5 = null;
            }
            dialogJoinLockRoomBinding5.groupId.setText(this.mCurrentContext.getString(2131953102, str4));
        }
    }

    @SuppressLint({"StringFormatInvalid"})
    private final void initView() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Integer role;
        DialogJoinLockRoomBinding dialogJoinLockRoomBinding = this.mDialogJoinLockRoomBinding;
        DialogJoinLockRoomBinding dialogJoinLockRoomBinding2 = null;
        if (dialogJoinLockRoomBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogJoinLockRoomBinding");
            dialogJoinLockRoomBinding = null;
        }
        ImageView imageView = dialogJoinLockRoomBinding.bgGroupPic;
        Intrinsics.checkNotNullExpressionValue(imageView, "bgGroupPic");
        GroupDetailBean groupDetailBean = this.mGroupDetail;
        if (groupDetailBean != null) {
            str = groupDetailBean.getFaceUrl();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(imageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        DialogJoinLockRoomBinding dialogJoinLockRoomBinding3 = this.mDialogJoinLockRoomBinding;
        if (dialogJoinLockRoomBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogJoinLockRoomBinding");
            dialogJoinLockRoomBinding3 = null;
        }
        RoundedImageView roundedImageView = dialogJoinLockRoomBinding3.groupPic;
        Intrinsics.checkNotNullExpressionValue(roundedImageView, "groupPic");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        GroupDetailBean groupDetailBean2 = this.mGroupDetail;
        if (groupDetailBean2 != null) {
            str2 = groupDetailBean2.getFaceUrl();
        } else {
            str2 = null;
        }
        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        fill.setWidth(dimens.dpToPx(97));
        fill.setHeight(dimens.dpToPx(97));
        Unit unit = Unit.INSTANCE;
        ViewUtilitiesKt.bind(roundedImageView, companion.displayImage(str2, fill));
        DialogJoinLockRoomBinding dialogJoinLockRoomBinding4 = this.mDialogJoinLockRoomBinding;
        if (dialogJoinLockRoomBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogJoinLockRoomBinding");
            dialogJoinLockRoomBinding4 = null;
        }
        ImageView imageView2 = dialogJoinLockRoomBinding4.countPic;
        Intrinsics.checkNotNullExpressionValue(imageView2, "countPic");
        GroupDetailBean groupDetailBean3 = this.mGroupDetail;
        if (groupDetailBean3 != null) {
            str3 = groupDetailBean3.getCountryIcon();
        } else {
            str3 = null;
        }
        ViewUtilitiesKt.bind(imageView2, companion.countryTag(str3));
        DialogJoinLockRoomBinding dialogJoinLockRoomBinding5 = this.mDialogJoinLockRoomBinding;
        if (dialogJoinLockRoomBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogJoinLockRoomBinding");
            dialogJoinLockRoomBinding5 = null;
        }
        TextView textView = dialogJoinLockRoomBinding5.groupId;
        Context context = this.mCurrentContext;
        GroupDetailBean groupDetailBean4 = this.mGroupDetail;
        if (groupDetailBean4 != null) {
            str4 = groupDetailBean4.getCode();
        } else {
            str4 = null;
        }
        textView.setText(context.getString(2131953102, str4));
        DialogJoinLockRoomBinding dialogJoinLockRoomBinding6 = this.mDialogJoinLockRoomBinding;
        if (dialogJoinLockRoomBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogJoinLockRoomBinding");
            dialogJoinLockRoomBinding6 = null;
        }
        TextView textView2 = dialogJoinLockRoomBinding6.groupName;
        GroupDetailBean groupDetailBean5 = this.mGroupDetail;
        if (groupDetailBean5 != null) {
            str5 = groupDetailBean5.getName();
        } else {
            str5 = null;
        }
        textView2.setText(str5);
        DialogJoinLockRoomBinding dialogJoinLockRoomBinding7 = this.mDialogJoinLockRoomBinding;
        if (dialogJoinLockRoomBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogJoinLockRoomBinding");
            dialogJoinLockRoomBinding7 = null;
        }
        dialogJoinLockRoomBinding7.llShowPassWord.setVisibility(8);
        GroupDetailBean groupDetailBean6 = this.mGroupDetail;
        if (groupDetailBean6 != null && (role = groupDetailBean6.getRole()) != null && role.intValue() == 100) {
            DialogJoinLockRoomBinding dialogJoinLockRoomBinding8 = this.mDialogJoinLockRoomBinding;
            if (dialogJoinLockRoomBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogJoinLockRoomBinding");
                dialogJoinLockRoomBinding8 = null;
            }
            dialogJoinLockRoomBinding8.reportImageView.setVisibility(8);
        }
        DialogJoinLockRoomBinding dialogJoinLockRoomBinding9 = this.mDialogJoinLockRoomBinding;
        if (dialogJoinLockRoomBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogJoinLockRoomBinding");
            dialogJoinLockRoomBinding9 = null;
        }
        dialogJoinLockRoomBinding9.llShowPassWord.setVisibility(0);
        DialogJoinLockRoomBinding dialogJoinLockRoomBinding10 = this.mDialogJoinLockRoomBinding;
        if (dialogJoinLockRoomBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogJoinLockRoomBinding");
        } else {
            dialogJoinLockRoomBinding2 = dialogJoinLockRoomBinding10;
        }
        dialogJoinLockRoomBinding2.enterButton.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportGroup() {
        new ReportDialog(this.mCurrentContext).setListener(new JoinLockRoomBottomDialog$reportGroup$1(this)).show();
    }

    private final void requestDataAndinitView() {
        nd.c observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getGroupDetail(this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.d0
            public final Object invoke(Object obj) {
                Unit requestDataAndinitView$lambda$5;
                requestDataAndinitView$lambda$5 = JoinLockRoomBottomDialog.requestDataAndinitView$lambda$5(JoinLockRoomBottomDialog.this, (ApiResponse) obj);
                return requestDataAndinitView$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.e0
            public final Object invoke(Object obj) {
                Unit requestDataAndinitView$lambda$6;
                requestDataAndinitView$lambda$6 = JoinLockRoomBottomDialog.requestDataAndinitView$lambda$6(JoinLockRoomBottomDialog.this, (Throwable) obj);
                return requestDataAndinitView$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null);
        nd.a aVar = this.mCompositeDisposable;
        Intrinsics.checkNotNull(aVar);
        RxUtilsKt.addTo(observeOnMainThread$default, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestDataAndinitView$lambda$5(JoinLockRoomBottomDialog joinLockRoomBottomDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        joinLockRoomBottomDialog.mGroupDetail = (GroupDetailBean) apiResponse.getData();
        joinLockRoomBottomDialog.initView();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestDataAndinitView$lambda$6(JoinLockRoomBottomDialog joinLockRoomBottomDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = joinLockRoomBottomDialog.mCurrentContext;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            String string = joinLockRoomBottomDialog.mCurrentContext.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str = string;
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final void showBlockOrReport() {
        BlockOrReportDialog blockOrReportDialog = new BlockOrReportDialog(this.mCurrentContext, BlockOrReportDialog.Companion.getTextList$default(BlockOrReportDialog.INSTANCE, BlockOrReportDialog.REPORT_AND_BLOCK, false, false, false, 14, null));
        blockOrReportDialog.setMListener(new SelectInterface() { // from class: com.qiahao.nextvideo.room.dialog.JoinLockRoomBottomDialog$showBlockOrReport$1$1
            public void onSelect(int index) {
                if (index == 0) {
                    JoinLockRoomBottomDialog.this.reportGroup();
                } else if (index == 1) {
                    TipBlackDialog confirmContent = new TipBlackDialog(JoinLockRoomBottomDialog.this.getMCurrentContext(), (Integer) null, 2, (DefaultConstructorMarker) null).setTipContent(ResourcesKtxKt.getStringById(this, 2131952131)).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131952331));
                    final JoinLockRoomBottomDialog joinLockRoomBottomDialog = JoinLockRoomBottomDialog.this;
                    confirmContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.dialog.JoinLockRoomBottomDialog$showBlockOrReport$1$1$onSelect$1
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            GroupDetailBean groupDetailBean;
                            groupDetailBean = JoinLockRoomBottomDialog.this.mGroupDetail;
                            if (groupDetailBean == null) {
                                return;
                            }
                            io.reactivex.rxjava3.core.i0 k = GroupService.INSTANCE.getInstance().leaveGroup(JoinLockRoomBottomDialog.this.getMGroupId()).p(ke.a.b()).k(md.b.c());
                            final JoinLockRoomBottomDialog joinLockRoomBottomDialog2 = JoinLockRoomBottomDialog.this;
                            k.a(new io.reactivex.rxjava3.core.k0() { // from class: com.qiahao.nextvideo.room.dialog.JoinLockRoomBottomDialog$showBlockOrReport$1$1$onSelect$1$confirm$1
                                public void onError(Throwable e) {
                                    Intrinsics.checkNotNullParameter(e, "e");
                                    HiloToasty.Companion companion = HiloToasty.Companion;
                                    Context mCurrentContext = JoinLockRoomBottomDialog.this.getMCurrentContext();
                                    String localizedMessage = e.getLocalizedMessage();
                                    if (localizedMessage == null) {
                                        localizedMessage = JoinLockRoomBottomDialog.this.getMCurrentContext().getString(2131952667);
                                        Intrinsics.checkNotNullExpressionValue(localizedMessage, "getString(...)");
                                    }
                                    Toast normal = companion.normal(mCurrentContext, localizedMessage, false);
                                    if (normal != null) {
                                        normal.show();
                                    }
                                }

                                public void onSubscribe(nd.c d) {
                                    nd.a aVar;
                                    Intrinsics.checkNotNullParameter(d, "d");
                                    aVar = JoinLockRoomBottomDialog.this.mCompositeDisposable;
                                    if (aVar != null) {
                                        aVar.a(d);
                                    }
                                }

                                public void onSuccess(ApiResponse<Object> t) {
                                    Intrinsics.checkNotNullParameter(t, "t");
                                    if (t.isOk()) {
                                        JoinLockRoomBottomDialog.this.blackOrReport();
                                        return;
                                    }
                                    HiloToasty.Companion companion = HiloToasty.Companion;
                                    Context mCurrentContext = JoinLockRoomBottomDialog.this.getMCurrentContext();
                                    String message = t.getMessage();
                                    if (message == null) {
                                        message = JoinLockRoomBottomDialog.this.getMCurrentContext().getString(2131952667);
                                        Intrinsics.checkNotNullExpressionValue(message, "getString(...)");
                                    }
                                    Toast normal = companion.normal(mCurrentContext, message, false);
                                    if (normal != null) {
                                        normal.show();
                                    }
                                }
                            });
                        }
                    }).show();
                }
            }
        });
        blockOrReportDialog.show();
    }

    public final void blackOrReport() {
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = this.mCurrentContext;
        String string = context.getString(2131954177);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toast normal = companion.normal(context, string, false);
        if (normal != null) {
            normal.show();
        }
        dismiss();
        GroupService.Companion companion2 = GroupService.INSTANCE;
        companion2.getMGroupEventProcessorObservable().onNext(new GroupEvent().leaveGroup(this.mGroupId));
        cf.c.c().l(new LiveEvent("EXIT_ROOM", DataExternalKt.createExitRoom(this.mGroupId, 1)));
        companion2.getInstance().setBlockRoomIdList(this.mGroupId);
        companion2.getMGroupEventProcessorObservable().onNext(new GroupEvent().blockRoomToLocal(this.mGroupId));
    }

    public void dismiss() {
        super/*androidx.appcompat.app.AppCompatDialog*/.dismiss();
        this.canTouch = true;
        nd.a aVar = this.mCompositeDisposable;
        if (aVar != null) {
            aVar.d();
        }
        this.mCompositeDisposable = null;
        if (this.needFinishOlderRoom) {
            Context context = this.mCurrentContext;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context).finish();
        }
    }

    public final boolean getCanTouch() {
        return this.canTouch;
    }

    @Nullable
    public final CommonLoadingDialog getDialog() {
        return this.dialog;
    }

    @Nullable
    public final String getGroupAnnouncement() {
        return this.groupAnnouncement;
    }

    @Nullable
    public final String getGroupCode() {
        return this.groupCode;
    }

    @Nullable
    public final String getGroupCountry() {
        return this.groupCountry;
    }

    @Nullable
    public final String getGroupFaceString() {
        return this.groupFaceString;
    }

    @Nullable
    public final String getGroupIntroduction() {
        return this.groupIntroduction;
    }

    @Nullable
    public final String getGroupName() {
        return this.groupName;
    }

    @NotNull
    public final Context getMCurrentContext() {
        return this.mCurrentContext;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    public final boolean getNeedFinishOlderRoom() {
        return this.needFinishOlderRoom;
    }

    public final int getSceneType() {
        return this.sceneType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void initStyle() {
        setCanceledOnTouchOutside(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131362643);
        if (frameLayout != null) {
            BottomSheetBehavior.s0(frameLayout).c1(false);
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            Dimens dimens = Dimens.INSTANCE;
            layoutParams.height = dimens.getScreenHeight() - dimens.dpToPx(67);
            BottomSheetBehavior.s0(frameLayout).c(3);
            frameLayout.setBackground(new ColorDrawable(0));
        }
        Object systemService = this.mCurrentContext.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.horizontalMargin = 0.0f;
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(attributes);
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        window3.setDimAmount(0.8f);
        Window window4 = getWindow();
        Intrinsics.checkNotNull(window4);
        window4.getDecorView().setPadding(0, 0, 0, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131362369) {
            if (id2 != 2131362781) {
                if (id2 != 2131364588 || !FastClickUtils.INSTANCE.isFastClick() || this.mGroupDetail == null) {
                    return;
                }
                showBlockOrReport();
                return;
            }
            Log.d(TAG, "onClick: 需要密码-进入房间");
            if (this.mGroupDetail == null || !this.canTouch) {
                return;
            }
            DialogJoinLockRoomBinding dialogJoinLockRoomBinding = this.mDialogJoinLockRoomBinding;
            DialogJoinLockRoomBinding dialogJoinLockRoomBinding2 = null;
            if (dialogJoinLockRoomBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogJoinLockRoomBinding");
                dialogJoinLockRoomBinding = null;
            }
            Editable text = dialogJoinLockRoomBinding.password.getText();
            if (text != null && text.length() == 4) {
                this.canTouch = false;
                DialogJoinLockRoomBinding dialogJoinLockRoomBinding3 = this.mDialogJoinLockRoomBinding;
                if (dialogJoinLockRoomBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDialogJoinLockRoomBinding");
                } else {
                    dialogJoinLockRoomBinding2 = dialogJoinLockRoomBinding3;
                }
                enterRoom(String.valueOf(dialogJoinLockRoomBinding2.password.getText()));
                return;
            }
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = this.mCurrentContext;
            String string = context.getString(2131953014);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, string, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
                return;
            }
            return;
        }
        dismiss();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mCompositeDisposable = new nd.a();
        initDataBindingAndView();
        initStyle();
    }

    public final void setCanTouch(boolean z) {
        this.canTouch = z;
    }

    public final void setDialog(@Nullable CommonLoadingDialog commonLoadingDialog) {
        this.dialog = commonLoadingDialog;
    }

    public final void setGroupAnnouncement(@Nullable String str) {
        this.groupAnnouncement = str;
    }

    public final void setGroupCode(@Nullable String str) {
        this.groupCode = str;
    }

    public final void setGroupCountry(@Nullable String str) {
        this.groupCountry = str;
    }

    public final void setGroupFaceString(@Nullable String str) {
        this.groupFaceString = str;
    }

    public final void setGroupIntroduction(@Nullable String str) {
        this.groupIntroduction = str;
    }

    public final void setGroupName(@Nullable String str) {
        this.groupName = str;
    }

    public final void setMCurrentContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mCurrentContext = context;
    }

    public final void setMGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGroupId = str;
    }

    public final void setNeedFinishOlderRoom(boolean z) {
        this.needFinishOlderRoom = z;
    }

    public final void setSceneType(int i) {
        this.sceneType = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JoinLockRoomBottomDialog(@NotNull Context context, @NotNull String str, @Nullable GroupDetailBean groupDetailBean, int i, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, int i2, boolean z) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "mCurrentContext");
        Intrinsics.checkNotNullParameter(str, "groupId");
        this.mCurrentContext = context;
        this.groupCode = str2;
        this.groupFaceString = str3;
        this.groupName = str4;
        this.groupCountry = str5;
        this.groupIntroduction = str6;
        this.groupAnnouncement = str7;
        this.sceneType = i2;
        this.needFinishOlderRoom = z;
        this.mGroupId = str;
        this.mGroupDetail = groupDetailBean;
        this.canTouch = true;
    }
}
