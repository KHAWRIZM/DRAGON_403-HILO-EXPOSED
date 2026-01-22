package com.qiahao.nextvideo.room.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.AllModuleServiceManager;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.databinding.IncludeGameLevelBinding;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.interfaceing.SelectInterface;
import com.qiahao.base_common.model.MedalBean;
import com.qiahao.base_common.model.common.CheckSessionBean;
import com.qiahao.base_common.model.common.CountryManager;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.model.common.HeadWearBean;
import com.qiahao.base_common.model.common.LikeResult;
import com.qiahao.base_common.model.common.MyGameLevel;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.cp.CpLevel;
import com.qiahao.base_common.model.cp.MyCp;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.base_common.player.vap.VapMediaSource;
import com.qiahao.base_common.service.BaseService;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.ui.dialog.ReportWhiteDialog;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RelationTypeUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.shineText.CountryIDView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.CommonTextDialog;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.service.FeedbackService;
import com.qiahao.nextvideo.data.service.OutPutOtherModuleService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.DialogRoomUserInfoBinding;
import com.qiahao.nextvideo.room.activity.RoomUserInfoBlockActivity;
import com.qiahao.nextvideo.room.activity.RoomUserInfoRoleActivity;
import com.qiahao.nextvideo.room.interfaces.UserInfoListener;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.ui.base.BlockOrReportDialog;
import com.qiahao.nextvideo.ui.base.BlockTextDialog;
import com.qiahao.nextvideo.ui.base.OnBlockCommonDialogListener;
import com.qiahao.nextvideo.ui.cp.CpSpaceActivity;
import com.qiahao.nextvideo.ui.home.onlinefeed.OnlineCellViewHolder;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.qiahao.nextvideo.ui.power.PowerActivity;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.ui.videocall.VideoCallMessage;
import com.qiahao.nextvideo.ui.vip.VipViewDialog;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.PermissionUtils;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMConversationManager;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 `2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001`B5\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0013H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0013H\u0002¢\u0006\u0004\b#\u0010\"J\u000f\u0010$\u001a\u00020\u0013H\u0002¢\u0006\u0004\b$\u0010\"J\u000f\u0010%\u001a\u00020\u0013H\u0002¢\u0006\u0004\b%\u0010\"J\u000f\u0010&\u001a\u00020\u0013H\u0002¢\u0006\u0004\b&\u0010\"J\u000f\u0010'\u001a\u00020\u0013H\u0002¢\u0006\u0004\b'\u0010\"J\u0017\u0010)\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u000bH\u0002¢\u0006\u0004\b)\u0010 J\u000f\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0013H\u0016¢\u0006\u0004\b,\u0010\"J\u000f\u0010-\u001a\u00020\rH\u0014¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\rH\u0014¢\u0006\u0004\b/\u0010.J\u0015\u00102\u001a\u00020\u00132\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\u0013¢\u0006\u0004\b4\u0010\"J\r\u00105\u001a\u00020\u0013¢\u0006\u0004\b5\u0010\"J\u0015\u00107\u001a\u00020\u00132\u0006\u00106\u001a\u00020\t¢\u0006\u0004\b7\u00108J\u0017\u0010;\u001a\u00020\u00132\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020\u0013¢\u0006\u0004\b=\u0010\"J\u000f\u0010>\u001a\u00020\u0013H\u0016¢\u0006\u0004\b>\u0010\"J\u000f\u0010?\u001a\u00020\u0013H\u0016¢\u0006\u0004\b?\u0010\"J\u0015\u0010A\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\r¢\u0006\u0004\bA\u0010\u001eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010B\u001a\u0004\bC\u0010DR$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010\u001bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010IR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010 R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010NR\u0016\u0010O\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010IR\u0016\u0010P\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010IR\u0018\u0010Q\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010NR\u0016\u0010T\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010NR&\u0010X\u001a\u0012\u0012\u0004\u0012\u00020V0Uj\b\u0012\u0004\u0012\u00020V`W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010^\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_¨\u0006a"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/UserInfoBottomSheetDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogRoomUserInfoBinding;", "Landroid/view/View$OnClickListener;", "Lcom/qiahao/nextvideo/ui/base/OnBlockCommonDialogListener;", "Landroid/content/Context;", "mCurrentContext", "Lcom/qiahao/base_common/model/common/User;", "mUser", "", "mMicPosition", "", "mGroupId", "", "mRoomHasMicOn", "<init>", "(Landroid/content/Context;Lcom/qiahao/base_common/model/common/User;ILjava/lang/String;Z)V", "svgaUrl", "isLocal", "", "playTopSvga", "(Ljava/lang/String;Z)V", "user", "isMyself", "initUserView", "(Lcom/qiahao/base_common/model/common/User;Z)V", "userMedalShow", "(Lcom/qiahao/base_common/model/common/User;)V", "isMute", "isShowMuteIcon", "(Z)V", "playSvga", "(Ljava/lang/String;)V", "confirmLike", "()V", "downMic", "inviteUserUpMic", "operateMuteOrUnMuteMic", "showBlockOrReport", "reportCurrentUser", TUIConstants.TUILive.USER_ID, "checkCanSendMessage", "getLayoutResId", "()I", "onInitialize", "isBottomStyle", "()Z", "isNeedFullScreen", "Lcom/qiahao/nextvideo/room/interfaces/UserInfoListener;", "userInfoListener", "setUserInfoListener", "(Lcom/qiahao/nextvideo/room/interfaces/UserInfoListener;)V", "getData", "userRoomTagShow", OnlineCellViewHolder.CLICK_LIKE, "showLikeImageView", "(I)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "toVideoCurrent", "dismiss", "blockTextDialogConfirm", "isMarginBottom", "updateNobleBgViewMarginBottom", "Landroid/content/Context;", "getMCurrentContext", "()Landroid/content/Context;", "Lcom/qiahao/base_common/model/common/User;", "getMUser", "()Lcom/qiahao/base_common/model/common/User;", "setMUser", "I", "Ljava/lang/String;", "getMGroupId", "()Ljava/lang/String;", "setMGroupId", "Z", "mUserRole", "mMyUserRole", "mUserInfoListener", "Lcom/qiahao/nextvideo/room/interfaces/UserInfoListener;", "mIsMyself", "isRequest", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/MedalBean;", "Lkotlin/collections/ArrayList;", "mMedalList", "Ljava/util/ArrayList;", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "Lkotlinx/coroutines/CoroutineScope;", "dialogScope", "Lkotlinx/coroutines/CoroutineScope;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUserInfoBottomSheetDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserInfoBottomSheetDialog.kt\ncom/qiahao/nextvideo/room/dialog/UserInfoBottomSheetDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1210:1\n1#2:1211\n61#3,9:1212\n61#3,9:1221\n1208#4,2:1230\n1236#4,4:1232\n1869#4,2:1236\n*S KotlinDebug\n*F\n+ 1 UserInfoBottomSheetDialog.kt\ncom/qiahao/nextvideo/room/dialog/UserInfoBottomSheetDialog\n*L\n375#1:1212,9\n500#1:1221,9\n705#1:1230,2\n705#1:1232,4\n706#1:1236,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class UserInfoBottomSheetDialog extends BaseBindingDialog<DialogRoomUserInfoBinding> implements View.OnClickListener, OnBlockCommonDialogListener {

    @NotNull
    private static final String TAG = "UserInfoBottomSheetDial";

    @NotNull
    private final CoroutineScope dialogScope;
    private boolean isRequest;

    @NotNull
    private nd.a mCompositeDisposable;

    @NotNull
    private final Context mCurrentContext;

    @NotNull
    private String mGroupId;
    private boolean mIsMyself;

    @NotNull
    private ArrayList<MedalBean> mMedalList;
    private int mMicPosition;
    private int mMyUserRole;
    private boolean mRoomHasMicOn;

    @Nullable
    private User mUser;

    @Nullable
    private UserInfoListener mUserInfoListener;
    private int mUserRole;

    public /* synthetic */ UserInfoBottomSheetDialog(Context context, User user, int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, user, (i2 & 4) != 0 ? 0 : i, str, (i2 & 16) != 0 ? true : z);
    }

    public static final /* synthetic */ DialogRoomUserInfoBinding access$getBinding(UserInfoBottomSheetDialog userInfoBottomSheetDialog) {
        return (DialogRoomUserInfoBinding) userInfoBottomSheetDialog.getBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit blockTextDialogConfirm$lambda$24(UserInfoBottomSheetDialog userInfoBottomSheetDialog, Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        userInfoBottomSheetDialog.dismiss();
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = userInfoBottomSheetDialog.getContext();
        Context context2 = userInfoBottomSheetDialog.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, ResourcesKtxKt.getStringById(context2, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit blockTextDialogConfirm$lambda$25(UserInfoBottomSheetDialog userInfoBottomSheetDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = userInfoBottomSheetDialog.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = ResourcesKtxKt.getStringById(userInfoBottomSheetDialog, 2131952667);
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit blockTextDialogConfirm$lambda$26(UserInfoBottomSheetDialog userInfoBottomSheetDialog) {
        String str;
        la.c reportEventRelay = FeedbackService.INSTANCE.getShared().getReportEventRelay();
        User user = userInfoBottomSheetDialog.mUser;
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        reportEventRelay.accept(str);
        return Unit.INSTANCE;
    }

    private final void checkCanSendMessage(String userId) {
        if (this.isRequest) {
            return;
        }
        this.isRequest = true;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().checkCanSession(userId), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.k4
            public final Object invoke(Object obj) {
                Unit checkCanSendMessage$lambda$28;
                checkCanSendMessage$lambda$28 = UserInfoBottomSheetDialog.checkCanSendMessage$lambda$28(UserInfoBottomSheetDialog.this, (ApiResponse) obj);
                return checkCanSendMessage$lambda$28;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.l4
            public final Object invoke(Object obj) {
                Unit checkCanSendMessage$lambda$29;
                checkCanSendMessage$lambda$29 = UserInfoBottomSheetDialog.checkCanSendMessage$lambda$29(UserInfoBottomSheetDialog.this, (Throwable) obj);
                return checkCanSendMessage$lambda$29;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.lang.Object, android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
    public static final Unit checkCanSendMessage$lambda$28(final UserInfoBottomSheetDialog userInfoBottomSheetDialog, ApiResponse apiResponse) {
        Integer num;
        Toast normal$default;
        String str;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        userInfoBottomSheetDialog.isRequest = false;
        CheckSessionBean checkSessionBean = (CheckSessionBean) apiResponse.getData();
        if (checkSessionBean != null) {
            num = Integer.valueOf(checkSessionBean.getCanTalk());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
            User user = userInfoBottomSheetDialog.mUser;
            if (user == null || (str = user.getExternalId()) == null) {
                str = "";
            }
            appRequestUtils.openChatActivity(str);
        } else if (num != null && num.intValue() == 2) {
            final ?? commonTextDialog = new CommonTextDialog(userInfoBottomSheetDialog.mCurrentContext, 0.0f, 2, null);
            commonTextDialog.setContentText(ResourcesKtxKt.getStringById((Object) commonTextDialog, 2131953227), true, ResourcesKtxKt.getStringById((Object) commonTextDialog, 2131953219), ResourcesKtxKt.getStringById((Object) commonTextDialog, 2131952171), new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoBottomSheetDialog$checkCanSendMessage$1$1$1
                public void cancel() {
                    commonTextDialog.dismiss();
                    UserInfoBottomSheetDialog.this.dismiss();
                }

                public void confirm() {
                    UserInfoBottomSheetDialog.this.confirmLike();
                    commonTextDialog.dismiss();
                }
            });
            commonTextDialog.show();
        } else if (num != null && num.intValue() == 3) {
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, userInfoBottomSheetDialog.getContext(), ResourcesKtxKt.getStringById(userInfoBottomSheetDialog, 2131953227), false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        } else if (num != null && num.intValue() == 5 && (normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, userInfoBottomSheetDialog.getContext(), ResourcesKtxKt.getStringById(userInfoBottomSheetDialog, 2131954530), false, 4, (Object) null)) != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit checkCanSendMessage$lambda$29(UserInfoBottomSheetDialog userInfoBottomSheetDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        userInfoBottomSheetDialog.isRequest = false;
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = userInfoBottomSheetDialog.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = ResourcesKtxKt.getStringById(userInfoBottomSheetDialog, 2131952667);
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void confirmLike() {
        String str;
        boolean z;
        Boolean isLike;
        UserService shared = UserService.INSTANCE.getShared();
        User user = this.mUser;
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        String str2 = str;
        User user2 = this.mUser;
        if (user2 != null && (isLike = user2.isLike()) != null) {
            z = isLike.booleanValue();
        } else {
            z = false;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.like$default(shared, str2, z, false, 4, null), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.f4
            public final Object invoke(Object obj) {
                Unit confirmLike$lambda$18;
                confirmLike$lambda$18 = UserInfoBottomSheetDialog.confirmLike$lambda$18(UserInfoBottomSheetDialog.this, (ApiResponse) obj);
                return confirmLike$lambda$18;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.g4
            public final Object invoke(Object obj) {
                Unit confirmLike$lambda$19;
                confirmLike$lambda$19 = UserInfoBottomSheetDialog.confirmLike$lambda$19(UserInfoBottomSheetDialog.this, (Throwable) obj);
                return confirmLike$lambda$19;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmLike$lambda$18(UserInfoBottomSheetDialog userInfoBottomSheetDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        LikeResult likeResult = (LikeResult) apiResponse.getData();
        if (likeResult != null) {
            User user = userInfoBottomSheetDialog.mUser;
            if (user != null) {
                user.setLike(Boolean.valueOf(likeResult.getStatus()));
            }
            User user2 = userInfoBottomSheetDialog.mUser;
            if (user2 != null) {
                user2.setLikeMe(Boolean.valueOf(likeResult.isLikeEach()));
            }
            if (likeResult.getStatus() && likeResult.isLikeEach()) {
                userInfoBottomSheetDialog.showLikeImageView(2);
            } else if (likeResult.getStatus()) {
                userInfoBottomSheetDialog.showLikeImageView(1);
            } else {
                userInfoBottomSheetDialog.showLikeImageView(0);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmLike$lambda$19(UserInfoBottomSheetDialog userInfoBottomSheetDialog, Throwable th) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            int code = hiloException.getCode();
            if (code != 9004) {
                if (code != 9005) {
                    HiloToasty.Companion companion = HiloToasty.Companion;
                    Context context = userInfoBottomSheetDialog.mCurrentContext;
                    String localizedMessage = hiloException.getLocalizedMessage();
                    if (localizedMessage == null) {
                        str2 = ResourcesKtxKt.getStringById(userInfoBottomSheetDialog, 2131952667);
                    } else {
                        str2 = localizedMessage;
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str2, false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                } else {
                    Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, userInfoBottomSheetDialog.mCurrentContext, ResourcesKtxKt.getStringById(userInfoBottomSheetDialog, 2131953231), false, 4, (Object) null);
                    if (normal$default2 != null) {
                        normal$default2.show();
                    }
                }
            } else {
                new VipViewDialog(5, userInfoBottomSheetDialog.mCurrentContext).show();
            }
        } else {
            HiloToasty.Companion companion2 = HiloToasty.Companion;
            Context context2 = userInfoBottomSheetDialog.mCurrentContext;
            String localizedMessage2 = th.getLocalizedMessage();
            if (localizedMessage2 == null) {
                str = ResourcesKtxKt.getStringById(userInfoBottomSheetDialog, 2131952667);
            } else {
                str = localizedMessage2;
            }
            Toast normal$default3 = HiloToasty.Companion.normal$default(companion2, context2, str, false, 4, (Object) null);
            if (normal$default3 != null) {
                normal$default3.show();
            }
        }
        return Unit.INSTANCE;
    }

    private final void downMic() {
        boolean z;
        if (this.mIsMyself) {
            UserInfoListener userInfoListener = this.mUserInfoListener;
            if (userInfoListener != null) {
                userInfoListener.downMic(this.mMicPosition);
                return;
            }
            return;
        }
        if (this.mMyUserRole <= this.mUserRole) {
            User user = this.mUser;
            if (user != null) {
                z = Intrinsics.areEqual(user.getHasGroupCountryManagerPower(), Boolean.TRUE);
            } else {
                z = false;
            }
            if (!z) {
                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.mCurrentContext, ResourcesKtxKt.getStringById(this, 2131952966), false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                    return;
                }
                return;
            }
        }
        UserInfoListener userInfoListener2 = this.mUserInfoListener;
        if (userInfoListener2 != null) {
            userInfoListener2.kickDownMic(this.mMicPosition);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:276:0x07db  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0850  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x08da  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x08e6  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0925  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0933  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x096c  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0b05  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x094a  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x08df  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x0872  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initUserView(final User user, boolean isMyself) {
        int i;
        int i2;
        int i3;
        Integer num;
        Drawable drawable;
        HeadWearBean headWearBean;
        String str;
        String str2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        String str3;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        CharSequence charSequence;
        Long l;
        int i14;
        boolean z2;
        boolean z3;
        boolean z4;
        Boolean isLikeMe;
        Boolean isLike;
        boolean z5;
        MeetingRoomManager meetingRoomManager;
        User user2;
        String str4;
        User user3;
        String str5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        int i15;
        boolean z10;
        Boolean forbid;
        String str6;
        String str7;
        boolean z11;
        int i16;
        String str8;
        String title;
        Integer level;
        Integer level2;
        boolean z12;
        int i17;
        String str9;
        String nameplate;
        Integer grade;
        Long id2;
        Integer level3;
        Integer level4;
        Integer level5;
        User cpUserInfo;
        String str10;
        boolean z13;
        String str11;
        String str12;
        User cpUserInfo2;
        HeadWearBean headwear;
        User cpUserInfo3;
        HeadWearBean headwear2;
        String str13;
        boolean z14;
        String str14;
        User cpUserInfo4;
        HeadWearBean headwear3;
        User cpUserInfo5;
        HeadWearBean headwear4;
        User cpUserInfo6;
        HeadWearBean headwear5;
        User cpUserInfo7;
        String str15;
        boolean z15;
        String str16;
        String str17;
        String str18;
        String str19;
        boolean z16;
        String str20;
        CpLevel cpLevel;
        Integer num2;
        Integer num3;
        int i18;
        String cardEffect;
        boolean z17;
        Integer level6;
        Integer level7;
        long j;
        int i19;
        UserStore.Companion companion = UserStore.INSTANCE;
        User user4 = companion.getShared().getUser();
        if (user4 != null && user4.isAr()) {
            LinearLayout linearLayout = ((DialogRoomUserInfoBinding) getBinding()).llVideo;
            User user5 = companion.getShared().getUser();
            if (user5 != null) {
                j = user5.getWealthUserGrade();
            } else {
                j = 0;
            }
            if (j > 10) {
                i19 = 0;
            } else {
                i19 = 8;
            }
            linearLayout.setVisibility(i19);
        } else {
            ((DialogRoomUserInfoBinding) getBinding()).llVideo.setVisibility(0);
        }
        if (user.isVip()) {
            ((DialogRoomUserInfoBinding) getBinding()).iconVip.setVisibility(0);
        } else {
            ((DialogRoomUserInfoBinding) getBinding()).iconVip.setVisibility(8);
        }
        ((DialogRoomUserInfoBinding) getBinding()).contentBg.setVisibility(0);
        NobleInfo noble = user.getNoble();
        if (noble != null && (level7 = noble.getLevel()) != null) {
            i = level7.intValue();
        } else {
            i = 0;
        }
        if (i > 0) {
            ((DialogRoomUserInfoBinding) getBinding()).iconNoble.setVisibility(0);
            ImageView imageView = ((DialogRoomUserInfoBinding) getBinding()).iconNoble;
            Context context = getContext();
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble2 = user.getNoble();
            if (noble2 != null && (level6 = noble2.getLevel()) != null) {
                i18 = level6.intValue();
            } else {
                i18 = 0;
            }
            imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, companion2.getNobleDrawableRes(i18)));
            if (i > 1 && i <= 9) {
                ((DialogRoomUserInfoBinding) getBinding()).contentBg.setVisibility(8);
                ((DialogRoomUserInfoBinding) getBinding()).bottomLine.setVisibility(8);
                Pair<Integer, Integer> nobleUserBackRes = companion2.getNobleUserBackRes(i, isMyself);
                ((DialogRoomUserInfoBinding) getBinding()).nobleBg.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), ((Number) nobleUserBackRes.getFirst()).intValue()));
                ((DialogRoomUserInfoBinding) getBinding()).topView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), ((Number) nobleUserBackRes.getSecond()).intValue()));
                ((DialogRoomUserInfoBinding) getBinding()).llUserMicroRoomOperator.setBackgroundColor(-1);
                if (i <= 5) {
                    cardEffect = "svga/room_noble_user_info.svga";
                } else {
                    cardEffect = user.getCardEffect();
                    if (cardEffect == null) {
                        cardEffect = "";
                    }
                }
                if (i <= 5) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                playTopSvga(cardEffect, z17);
            } else if (i > 9) {
                ((DialogRoomUserInfoBinding) getBinding()).contentBg.setVisibility(8);
                ((DialogRoomUserInfoBinding) getBinding()).bottomLine.setVisibility(8);
                ((DialogRoomUserInfoBinding) getBinding()).nobleBg.setVisibility(8);
                String cardEffectV2 = user.getCardEffectV2();
                if (cardEffectV2 != null && StringKtxKt.checkEndMP4(cardEffectV2)) {
                    LightQueueCombinationPlayer lightQueueCombinationPlayer = ((DialogRoomUserInfoBinding) getBinding()).queuePlayer;
                    String cardEffectV22 = user.getCardEffectV2();
                    if (cardEffectV22 == null) {
                        cardEffectV22 = "";
                    }
                    VapMediaSource vapMediaSource = new VapMediaSource(cardEffectV22);
                    vapMediaSource.setLoop();
                    lightQueueCombinationPlayer.addQueue(vapMediaSource);
                }
                ((DialogRoomUserInfoBinding) getBinding()).llUserMicroRoomOperator.setBackgroundColor(-1);
            } else {
                ((DialogRoomUserInfoBinding) getBinding()).nobleSvga.setVisibility(8);
            }
        } else {
            ((DialogRoomUserInfoBinding) getBinding()).iconNoble.setVisibility(8);
            ((DialogRoomUserInfoBinding) getBinding()).nobleSvga.setVisibility(8);
        }
        SvipData svip = user.getSvip();
        if (svip != null) {
            i2 = svip.getSvipLevel();
        } else {
            i2 = 0;
        }
        if (i2 > 0) {
            ((DialogRoomUserInfoBinding) getBinding()).iconNoble.setVisibility(8);
            ((DialogRoomUserInfoBinding) getBinding()).svipMedal.setVisibility(0);
            ((DialogRoomUserInfoBinding) getBinding()).svipType.setVisibility(0);
            ((DialogRoomUserInfoBinding) getBinding()).svipTypeLine.setVisibility(0);
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            SvipData svip2 = user.getSvip();
            if (svip2 != null) {
                num2 = Integer.valueOf(svip2.getSvipLevel());
            } else {
                num2 = null;
            }
            Integer svipType = svipTypeUtils.getSvipType(num2);
            if (svipType != null) {
                ((DialogRoomUserInfoBinding) getBinding()).svipType.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), svipType.intValue()));
                Unit unit = Unit.INSTANCE;
            }
            SvipData svip3 = user.getSvip();
            if (svip3 != null) {
                num3 = Integer.valueOf(svip3.getSvipLevel());
            } else {
                num3 = null;
            }
            Integer svipMedal = svipTypeUtils.getSvipMedal(num3);
            if (svipMedal != null) {
                ((DialogRoomUserInfoBinding) getBinding()).svipMedal.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), svipMedal.intValue()));
                Unit unit2 = Unit.INSTANCE;
            }
        } else {
            ((DialogRoomUserInfoBinding) getBinding()).svipType.setVisibility(8);
            ((DialogRoomUserInfoBinding) getBinding()).svipTypeLine.setVisibility(8);
            ((DialogRoomUserInfoBinding) getBinding()).svipMedal.setVisibility(8);
            Unit unit3 = Unit.INSTANCE;
        }
        CountryManager countryManager = user.getCountryManager();
        if (countryManager != null) {
            Integer role = countryManager.getRole();
            if (role != null && role.intValue() == 1) {
                playSvga("svga/country_admin.svga");
            } else {
                Integer role2 = countryManager.getRole();
                if (role2 != null && role2.intValue() == 2) {
                    playSvga("svga/country_aid.svga");
                }
            }
            Unit unit4 = Unit.INSTANCE;
        }
        Group group = ((DialogRoomUserInfoBinding) getBinding()).cpGroup;
        if (user.getCp() == null) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        group.setVisibility(i3);
        ImageView imageView2 = ((DialogRoomUserInfoBinding) getBinding()).cpModel;
        RelationTypeUtils relationTypeUtils = RelationTypeUtils.INSTANCE;
        MyCp cp = user.getCp();
        if (cp != null && (cpLevel = cp.getCpLevel()) != null) {
            num = cpLevel.getLevel();
        } else {
            num = null;
        }
        Integer relationMedal$default = RelationTypeUtils.getRelationMedal$default(relationTypeUtils, num, true, 0, 4, (Object) null);
        if (relationMedal$default != null) {
            drawable = androidx.core.content.a.getDrawable(getContext(), relationMedal$default.intValue());
        } else {
            drawable = null;
        }
        imageView2.setBackground(drawable);
        final ImageView imageView3 = ((DialogRoomUserInfoBinding) getBinding()).cpModel;
        final long j2 = 800;
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoBottomSheetDialog$initUserView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i20;
                CpLevel cpLevel2;
                Integer level8;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView3) > j2 || (imageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView3, currentTimeMillis);
                    MyCp cp2 = user.getCp();
                    if (cp2 != null && (cpLevel2 = cp2.getCpLevel()) != null && (level8 = cpLevel2.getLevel()) != null) {
                        i20 = level8.intValue();
                    } else {
                        i20 = 0;
                    }
                    if (i20 > 0) {
                        CpSpaceActivity.Companion companion3 = CpSpaceActivity.Companion;
                        Context context2 = this.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                        CpSpaceActivity.Companion.startActivity$default(companion3, context2, user.getExternalId(), null, 0, 12, null);
                    }
                }
            }
        });
        ((DialogRoomUserInfoBinding) getBinding()).countryID.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.qiahao.nextvideo.room.dialog.e4
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean initUserView$lambda$8;
                initUserView$lambda$8 = UserInfoBottomSheetDialog.initUserView$lambda$8(user, this, view);
                return initUserView$lambda$8;
            }
        });
        if (user.getHeadwear() != null) {
            HeadWearBean headwear6 = user.getHeadwear();
            if (headwear6 != null) {
                str15 = headwear6.getEffectUrl1();
            } else {
                str15 = null;
            }
            if (str15 != null && str15.length() != 0) {
                z15 = false;
            } else {
                z15 = true;
            }
            if (z15) {
                HeadWearBean headwear7 = user.getHeadwear();
                if (headwear7 != null) {
                    str19 = headwear7.getPicUrl();
                } else {
                    str19 = null;
                }
                if (str19 != null && str19.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    ImageView imageView4 = ((DialogRoomUserInfoBinding) getBinding()).micUserHeadImg;
                    Intrinsics.checkNotNullExpressionValue(imageView4, "micUserHeadImg");
                    HeadWearBean headwear8 = user.getHeadwear();
                    if (headwear8 != null) {
                        str20 = headwear8.getPicUrl();
                    } else {
                        str20 = null;
                    }
                    ImageKtxKt.loadImage$default(imageView4, str20, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                }
                Unit unit5 = Unit.INSTANCE;
            } else {
                HeadWearBean headwear9 = user.getHeadwear();
                if (headwear9 != null) {
                    str16 = headwear9.getEffectUrl1();
                } else {
                    str16 = null;
                }
                if (TextUtils.isEmpty(str16)) {
                    return;
                }
                try {
                    SVGAParser shareParser = SVGAParser.Companion.shareParser();
                    HeadWearBean headwear10 = user.getHeadwear();
                    if (headwear10 != null) {
                        str18 = headwear10.getEffectUrl1();
                    } else {
                        str18 = null;
                    }
                    shareParser.decodeFromURL(new URL(str18 + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoBottomSheetDialog$initUserView$8
                        public void onComplete(SVGAVideoEntity videoItem) {
                            String headwearIcon;
                            String str21;
                            Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                            SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                            HeadWearBean headwear11 = user.getHeadwear();
                            if (headwear11 != null && (headwearIcon = headwear11.getHeadwearIcon()) != null && StringKtxKt.isUrl(headwearIcon)) {
                                HeadWearBean headwear12 = user.getHeadwear();
                                if (headwear12 == null || (str21 = headwear12.getHeadwearIcon()) == null) {
                                    str21 = "";
                                }
                                DataExternalKt.setDynamicImageEntity$default(sVGADynamicEntity, str21, null, 2, null);
                            }
                            UserInfoBottomSheetDialog.access$getBinding(this).micUserHeadSvga.stopAnimation(true);
                            UserInfoBottomSheetDialog.access$getBinding(this).micUserHeadSvga.setImageDrawable(new SVGADrawable(videoItem, sVGADynamicEntity));
                            UserInfoBottomSheetDialog.access$getBinding(this).micUserHeadSvga.startAnimation();
                        }

                        public void onError() {
                        }
                    });
                } catch (Exception e) {
                    AppService service = AppController.INSTANCE.getService();
                    if (service != null) {
                        String message = e.getMessage();
                        HeadWearBean headwear11 = user.getHeadwear();
                        if (headwear11 != null) {
                            str17 = headwear11.getEffectUrl1();
                        } else {
                            str17 = null;
                        }
                        service.recordLog(message + "     " + str17);
                        Unit unit6 = Unit.INSTANCE;
                    }
                    e.printStackTrace();
                    Unit unit7 = Unit.INSTANCE;
                }
            }
        }
        MyCp cp2 = user.getCp();
        if (cp2 != null && (cpUserInfo7 = cp2.getCpUserInfo()) != null) {
            headWearBean = cpUserInfo7.getHeadwear();
        } else {
            headWearBean = null;
        }
        if (headWearBean != null) {
            MyCp cp3 = user.getCp();
            if (cp3 != null && (cpUserInfo6 = cp3.getCpUserInfo()) != null && (headwear5 = cpUserInfo6.getHeadwear()) != null) {
                str10 = headwear5.getEffectUrl1();
            } else {
                str10 = null;
            }
            if (str10 != null && str10.length() != 0) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (z13) {
                MyCp cp4 = user.getCp();
                if (cp4 != null && (cpUserInfo5 = cp4.getCpUserInfo()) != null && (headwear4 = cpUserInfo5.getHeadwear()) != null) {
                    str13 = headwear4.getPicUrl();
                } else {
                    str13 = null;
                }
                if (str13 != null && str13.length() != 0) {
                    z14 = false;
                } else {
                    z14 = true;
                }
                if (!z14) {
                    ImageView imageView5 = ((DialogRoomUserInfoBinding) getBinding()).micUserHeadImgTwo;
                    Intrinsics.checkNotNullExpressionValue(imageView5, "micUserHeadImgTwo");
                    MyCp cp5 = user.getCp();
                    if (cp5 != null && (cpUserInfo4 = cp5.getCpUserInfo()) != null && (headwear3 = cpUserInfo4.getHeadwear()) != null) {
                        str14 = headwear3.getPicUrl();
                    } else {
                        str14 = null;
                    }
                    ViewUtilitiesKt.bind(imageView5, new ImageUIModel(str14, null, null, null, 0, 0, null, 126, null));
                }
                Unit unit8 = Unit.INSTANCE;
            } else {
                MyCp cp6 = user.getCp();
                if (cp6 != null && (cpUserInfo3 = cp6.getCpUserInfo()) != null && (headwear2 = cpUserInfo3.getHeadwear()) != null) {
                    str11 = headwear2.getEffectUrl1();
                } else {
                    str11 = null;
                }
                if (TextUtils.isEmpty(str11)) {
                    return;
                }
                try {
                    SVGAParser shareParser2 = SVGAParser.Companion.shareParser();
                    MyCp cp7 = user.getCp();
                    if (cp7 != null && (cpUserInfo2 = cp7.getCpUserInfo()) != null && (headwear = cpUserInfo2.getHeadwear()) != null) {
                        str12 = headwear.getEffectUrl1();
                    } else {
                        str12 = null;
                    }
                    shareParser2.decodeFromURL(new URL(str12 + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoBottomSheetDialog$initUserView$9
                        public void onComplete(SVGAVideoEntity videoItem) {
                            User cpUserInfo8;
                            HeadWearBean headwear12;
                            String headwearIcon;
                            String str21;
                            User cpUserInfo9;
                            HeadWearBean headwear13;
                            Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                            SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                            MyCp cp8 = user.getCp();
                            if (cp8 != null && (cpUserInfo8 = cp8.getCpUserInfo()) != null && (headwear12 = cpUserInfo8.getHeadwear()) != null && (headwearIcon = headwear12.getHeadwearIcon()) != null && StringKtxKt.isUrl(headwearIcon)) {
                                MyCp cp9 = user.getCp();
                                if (cp9 == null || (cpUserInfo9 = cp9.getCpUserInfo()) == null || (headwear13 = cpUserInfo9.getHeadwear()) == null || (str21 = headwear13.getHeadwearIcon()) == null) {
                                    str21 = "";
                                }
                                DataExternalKt.setDynamicImageEntity$default(sVGADynamicEntity, str21, null, 2, null);
                            }
                            UserInfoBottomSheetDialog.access$getBinding(this).micUserHeadSvgaTwo.stopAnimation(true);
                            UserInfoBottomSheetDialog.access$getBinding(this).micUserHeadSvgaTwo.setImageDrawable(new SVGADrawable(videoItem, sVGADynamicEntity));
                            UserInfoBottomSheetDialog.access$getBinding(this).micUserHeadSvgaTwo.startAnimation();
                        }

                        public void onError() {
                        }
                    });
                } catch (Exception unused) {
                    Unit unit9 = Unit.INSTANCE;
                }
            }
        }
        HiloImageView hiloImageView = ((DialogRoomUserInfoBinding) getBinding()).userAvatarTwo;
        MyCp cp8 = user.getCp();
        if (cp8 != null && (cpUserInfo = cp8.getCpUserInfo()) != null) {
            str = cpUserInfo.getAvatar();
        } else {
            str = null;
        }
        String image200 = ImageSizeKt.image200(str);
        if (image200 == null) {
            str2 = "";
        } else {
            str2 = image200;
        }
        HiloImageView.loadImage$default(hiloImageView, str2, 0, 0, 6, (Object) null);
        NickTextView nickTextView = ((DialogRoomUserInfoBinding) getBinding()).userName;
        String nick = user.getNick();
        SvipData svip4 = user.getSvip();
        if (svip4 != null) {
            i4 = svip4.getSvipLevel();
        } else {
            i4 = 0;
        }
        NobleInfo noble3 = user.getNoble();
        if (noble3 != null && (level5 = noble3.getLevel()) != null) {
            i5 = level5.intValue();
        } else {
            i5 = 0;
        }
        nickTextView.setSVipAndNoble(nick, i4, i5);
        CountryIDView countryIDView = ((DialogRoomUserInfoBinding) getBinding()).countryID;
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{user.getCode()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        Integer idFrameType = user.getIdFrameType();
        if (idFrameType != null) {
            i6 = idFrameType.intValue();
        } else {
            i6 = 0;
        }
        Context context2 = getContext();
        NobleInfo noble4 = user.getNoble();
        if (noble4 != null && (level4 = noble4.getLevel()) != null) {
            i7 = level4.intValue();
        } else {
            i7 = 0;
        }
        if (i7 > 0) {
            i8 = 2131101214;
        } else {
            i8 = 2131099901;
        }
        int color = androidx.core.content.a.getColor(context2, i8);
        Boolean isPrettyCode = user.isPrettyCode();
        if (isPrettyCode != null) {
            z = isPrettyCode.booleanValue();
        } else {
            z = false;
        }
        countryIDView.refreshText(format, i6, color, z);
        HiloImageView hiloImageView2 = ((DialogRoomUserInfoBinding) getBinding()).userAvatar;
        String image2002 = ImageSizeKt.image200(user.getAvatar());
        if (image2002 == null) {
            str3 = "";
        } else {
            str3 = image2002;
        }
        HiloImageView.loadImage$default(hiloImageView2, str3, 0, 0, 6, (Object) null);
        ImageView imageView6 = ((DialogRoomUserInfoBinding) getBinding()).imageViewCountry;
        Intrinsics.checkNotNullExpressionValue(imageView6, "imageViewCountry");
        ViewUtilitiesKt.bind(imageView6, ImageUIModel.INSTANCE.countryTag(user.getCountryIcon()));
        ((DialogRoomUserInfoBinding) getBinding()).countryText.setText(user.getCountry());
        NobleInfo noble5 = user.getNoble();
        if (noble5 != null && (level3 = noble5.getLevel()) != null) {
            i9 = level3.intValue();
        } else {
            i9 = 0;
        }
        if (i9 > 0) {
            ((DialogRoomUserInfoBinding) getBinding()).userName.setTextColor(-1);
            ((DialogRoomUserInfoBinding) getBinding()).countryID.setDefaultColor(androidx.core.content.a.getColor(getContext(), 2131101214));
            ((DialogRoomUserInfoBinding) getBinding()).countryText.setTextColor(-1);
            ((DialogRoomUserInfoBinding) getBinding()).userTagText.setTextColor(-1);
        }
        ImageView imageView7 = ((DialogRoomUserInfoBinding) getBinding()).newUser;
        if (user.getCornerMark() == 2) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        imageView7.setVisibility(i10);
        GenderAgeTextView genderAgeTextView = ((DialogRoomUserInfoBinding) getBinding()).ageTextView;
        Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        if (user.getSex() == 1) {
            i11 = R.drawable.icon_boy;
        } else {
            i11 = R.drawable.icon_girl;
        }
        ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, ResourceUtilsKt.getDrawable(resources, i11, 0));
        GenderAgeTextView genderAgeTextView2 = ((DialogRoomUserInfoBinding) getBinding()).ageTextView;
        if (user.getSex() == 1) {
            i12 = R.drawable.bg_age_male;
        } else {
            i12 = R.drawable.bg_age_female;
        }
        genderAgeTextView2.setBackgroundResource(i12);
        AppCompatTextView appCompatTextView = ((DialogRoomUserInfoBinding) getBinding()).ageTextView;
        Integer isShowAge = user.isShowAge();
        if (isShowAge != null) {
            i13 = isShowAge.intValue();
        } else {
            i13 = 1;
        }
        if (i13 != 1) {
            charSequence = "";
        } else {
            charSequence = user.getAge();
        }
        appCompatTextView.setText(charSequence);
        final HiloImageView hiloImageView3 = ((DialogRoomUserInfoBinding) getBinding()).userAvatar;
        final long j3 = 800;
        hiloImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoBottomSheetDialog$initUserView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(hiloImageView3) > j3 || (hiloImageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(hiloImageView3, currentTimeMillis);
                    HiloImageView hiloImageView4 = hiloImageView3;
                    AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, user.getExternalId(), false, 2, null);
                }
            }
        });
        HiloGradeView.setLevelBg$default(((DialogRoomUserInfoBinding) getBinding()).wealthLevel, user.getWealthUserGrade(), false, true, false, 10, (Object) null);
        HiloGradeView.setLevelBg$default(((DialogRoomUserInfoBinding) getBinding()).charmLevel, user.getCharmUserGrade(), true, false, false, 12, (Object) null);
        HiloGradeView.setLevelBg$default(((DialogRoomUserInfoBinding) getBinding()).activityLevel, user.getActivityUserGrade(), false, false, true, 6, (Object) null);
        userMedalShow(user);
        userRoomTagShow();
        FamilyInfo groupPower = user.getGroupPower();
        if (groupPower != null) {
            l = groupPower.getId();
        } else {
            l = null;
        }
        if (l != null) {
            FamilyInfo groupPower2 = user.getGroupPower();
            if (groupPower2 != null && (id2 = groupPower2.getId()) != null && id2.longValue() == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                ((DialogRoomUserInfoBinding) getBinding()).familyNamePlate.getRoot().setVisibility(0);
                IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding = ((DialogRoomUserInfoBinding) getBinding()).familyNamePlate;
                Intrinsics.checkNotNullExpressionValue(includeFamilyNamePlateBinding, "familyNamePlate");
                FamilyInfo groupPower3 = user.getGroupPower();
                if (groupPower3 != null && (grade = groupPower3.getGrade()) != null) {
                    i17 = grade.intValue();
                } else {
                    i17 = -1;
                }
                FamilyInfo groupPower4 = user.getGroupPower();
                if (groupPower4 == null || (nameplate = groupPower4.getNameplate()) == null) {
                    str9 = "";
                } else {
                    str9 = nameplate;
                }
                AppUtilitiesKt.familyNamePlate$default(includeFamilyNamePlateBinding, i17, str9, 0, 4, (Object) null);
                if (user.getGameLevel() != null) {
                    MyGameLevel gameLevel = user.getGameLevel();
                    if (gameLevel != null && (level2 = gameLevel.getLevel()) != null && level2.intValue() == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z11) {
                        ((DialogRoomUserInfoBinding) getBinding()).gameLevel.getRoot().setVisibility(0);
                        IncludeGameLevelBinding includeGameLevelBinding = ((DialogRoomUserInfoBinding) getBinding()).gameLevel;
                        Intrinsics.checkNotNullExpressionValue(includeGameLevelBinding, "gameLevel");
                        MyGameLevel gameLevel2 = user.getGameLevel();
                        if (gameLevel2 != null && (level = gameLevel2.getLevel()) != null) {
                            i16 = level.intValue();
                        } else {
                            i16 = -1;
                        }
                        MyGameLevel gameLevel3 = user.getGameLevel();
                        if (gameLevel3 == null || (title = gameLevel3.getTitle()) == null) {
                            str8 = "";
                        } else {
                            str8 = title;
                        }
                        AppUtilitiesKt.gameLevelBinding$default(includeGameLevelBinding, i16, str8, 0, 4, (Object) null);
                        i14 = 8;
                        if (isMyself) {
                            ((DialogRoomUserInfoBinding) getBinding()).llUserOperator.setVisibility(i14);
                            ((DialogRoomUserInfoBinding) getBinding()).reportImageView.setVisibility(i14);
                            ((DialogRoomUserInfoBinding) getBinding()).micMute.setVisibility(i14);
                        } else {
                            ((DialogRoomUserInfoBinding) getBinding()).micMute.setVisibility(0);
                            User user6 = this.mUser;
                            if (user6 != null) {
                                z2 = Intrinsics.areEqual(user6.isLike(), Boolean.TRUE);
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                User user7 = this.mUser;
                                if (user7 != null) {
                                    z5 = Intrinsics.areEqual(user7.isLikeMe(), Boolean.TRUE);
                                } else {
                                    z5 = false;
                                }
                                if (z5) {
                                    showLikeImageView(2);
                                }
                            }
                            User user8 = this.mUser;
                            if (user8 != null && (isLike = user8.isLike()) != null) {
                                z3 = isLike.booleanValue();
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                showLikeImageView(1);
                            } else {
                                User user9 = this.mUser;
                                if (user9 != null && (isLikeMe = user9.isLikeMe()) != null) {
                                    z4 = isLikeMe.booleanValue();
                                } else {
                                    z4 = false;
                                }
                                if (z4) {
                                    showLikeImageView(0);
                                } else {
                                    showLikeImageView(0);
                                }
                            }
                        }
                        meetingRoomManager = MeetingRoomManager.INSTANCE;
                        user2 = this.mUser;
                        if (user2 != null) {
                            str4 = user2.getExternalId();
                        } else {
                            str4 = null;
                        }
                        if (meetingRoomManager.checkUserOnMic(str4)) {
                            User user10 = UserStore.INSTANCE.getShared().getUser();
                            if (user10 != null) {
                                str6 = user10.getExternalId();
                            } else {
                                str6 = null;
                            }
                            User user11 = this.mUser;
                            if (user11 != null) {
                                str7 = user11.getExternalId();
                            } else {
                                str7 = null;
                            }
                            if (!Intrinsics.areEqual(str6, str7)) {
                                ((DialogRoomUserInfoBinding) getBinding()).micMute.setVisibility(0);
                                user3 = this.mUser;
                                if (user3 != null || (str5 = user3.getExternalId()) == null) {
                                    str5 = "";
                                }
                                if (!meetingRoomManager.haveLocalMute(str5)) {
                                    ((DialogRoomUserInfoBinding) getBinding()).micMute.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.person_mic_off));
                                } else {
                                    ((DialogRoomUserInfoBinding) getBinding()).micMute.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.person_mic_on));
                                }
                                if (this.mMicPosition <= 0) {
                                    MicroBean microBean = (MicroBean) MeetingRoomManager.getMicQueue$default(meetingRoomManager, false, 1, null).get(Integer.valueOf(this.mMicPosition));
                                    if (microBean != null && (forbid = microBean.getForbid()) != null) {
                                        z8 = forbid.booleanValue();
                                    } else {
                                        z8 = false;
                                    }
                                    isShowMuteIcon(z8);
                                    if (isMyself) {
                                        ((DialogRoomUserInfoBinding) getBinding()).llUserMicroRoomOperator.setVisibility(0);
                                        updateNobleBgViewMarginBottom(true);
                                        ((DialogRoomUserInfoBinding) getBinding()).imageUserInfo.setVisibility(8);
                                        ((DialogRoomUserInfoBinding) getBinding()).imageUserMuteOpenMic.setVisibility(0);
                                        ((DialogRoomUserInfoBinding) getBinding()).imageUserDownMic.setVisibility(0);
                                        i15 = 8;
                                        ((DialogRoomUserInfoBinding) getBinding()).imageUserLeaveRoom.setVisibility(8);
                                    } else {
                                        int i20 = this.mMyUserRole;
                                        if (i20 != 1) {
                                            if (i20 != 10) {
                                                if (i20 != 50 && i20 != 100 && i20 != 1000) {
                                                    User user12 = this.mUser;
                                                    if (user12 != null) {
                                                        z10 = Intrinsics.areEqual(user12.getHasGroupCountryManagerPower(), Boolean.TRUE);
                                                    } else {
                                                        z10 = false;
                                                    }
                                                    if (z10) {
                                                        ((DialogRoomUserInfoBinding) getBinding()).llUserMicroRoomOperator.setVisibility(0);
                                                        updateNobleBgViewMarginBottom(true);
                                                        ((DialogRoomUserInfoBinding) getBinding()).imageUserInfo.setVisibility(8);
                                                        ((DialogRoomUserInfoBinding) getBinding()).imageUserDownMic.setVisibility(0);
                                                        ((DialogRoomUserInfoBinding) getBinding()).imageUserLeaveRoom.setVisibility(0);
                                                    }
                                                    Unit unit10 = Unit.INSTANCE;
                                                } else {
                                                    ((DialogRoomUserInfoBinding) getBinding()).llUserMicroRoomOperator.setVisibility(0);
                                                    updateNobleBgViewMarginBottom(true);
                                                    ((DialogRoomUserInfoBinding) getBinding()).imageUserInfo.setVisibility(0);
                                                    ((DialogRoomUserInfoBinding) getBinding()).imageUserMuteOpenMic.setVisibility(0);
                                                    ((DialogRoomUserInfoBinding) getBinding()).imageUserDownMic.setVisibility(0);
                                                    ((DialogRoomUserInfoBinding) getBinding()).imageUserLeaveRoom.setVisibility(0);
                                                    Unit unit11 = Unit.INSTANCE;
                                                }
                                            } else {
                                                ((DialogRoomUserInfoBinding) getBinding()).llUserMicroRoomOperator.setVisibility(0);
                                                updateNobleBgViewMarginBottom(true);
                                                ((DialogRoomUserInfoBinding) getBinding()).imageUserInfo.setVisibility(8);
                                                ((DialogRoomUserInfoBinding) getBinding()).imageUserMuteOpenMic.setVisibility(0);
                                                ((DialogRoomUserInfoBinding) getBinding()).imageUserDownMic.setVisibility(0);
                                                ((DialogRoomUserInfoBinding) getBinding()).imageUserLeaveRoom.setVisibility(0);
                                                Unit unit12 = Unit.INSTANCE;
                                            }
                                            i15 = 8;
                                        } else {
                                            User user13 = this.mUser;
                                            if (user13 != null) {
                                                z9 = Intrinsics.areEqual(user13.getHasGroupCountryManagerPower(), Boolean.TRUE);
                                            } else {
                                                z9 = false;
                                            }
                                            if (z9) {
                                                ((DialogRoomUserInfoBinding) getBinding()).llUserMicroRoomOperator.setVisibility(0);
                                                updateNobleBgViewMarginBottom(true);
                                                ((DialogRoomUserInfoBinding) getBinding()).imageUserInfo.setVisibility(8);
                                                ((DialogRoomUserInfoBinding) getBinding()).imageUserDownMic.setVisibility(0);
                                                ((DialogRoomUserInfoBinding) getBinding()).imageUserLeaveRoom.setVisibility(0);
                                                i15 = 8;
                                            } else {
                                                i15 = 8;
                                                ((DialogRoomUserInfoBinding) getBinding()).llUserMicroRoomOperator.setVisibility(8);
                                                updateNobleBgViewMarginBottom(false);
                                            }
                                            Unit unit13 = Unit.INSTANCE;
                                        }
                                    }
                                    ((DialogRoomUserInfoBinding) getBinding()).imageInviteUserUpMic.setVisibility(i15);
                                } else {
                                    ((DialogRoomUserInfoBinding) getBinding()).imageUserMuteOpenMic.setVisibility(8);
                                    ((DialogRoomUserInfoBinding) getBinding()).imageUserDownMic.setVisibility(8);
                                    if (isMyself) {
                                        ((DialogRoomUserInfoBinding) getBinding()).llUserMicroRoomOperator.setVisibility(8);
                                        updateNobleBgViewMarginBottom(false);
                                    } else {
                                        int i21 = this.mMyUserRole;
                                        if (i21 != 1) {
                                            if (i21 != 10) {
                                                if (i21 != 50 && i21 != 100 && i21 != 1000) {
                                                    User user14 = this.mUser;
                                                    if (user14 != null) {
                                                        z7 = Intrinsics.areEqual(user14.getHasGroupCountryManagerPower(), Boolean.TRUE);
                                                    } else {
                                                        z7 = false;
                                                    }
                                                    if (z7) {
                                                        ((DialogRoomUserInfoBinding) getBinding()).llUserMicroRoomOperator.setVisibility(0);
                                                        updateNobleBgViewMarginBottom(true);
                                                        ((DialogRoomUserInfoBinding) getBinding()).imageUserLeaveRoom.setVisibility(0);
                                                        ((DialogRoomUserInfoBinding) getBinding()).imageUserInfo.setVisibility(8);
                                                        ((DialogRoomUserInfoBinding) getBinding()).imageInviteUserUpMic.setVisibility(8);
                                                    }
                                                    Unit unit14 = Unit.INSTANCE;
                                                } else {
                                                    ((DialogRoomUserInfoBinding) getBinding()).llUserMicroRoomOperator.setVisibility(0);
                                                    updateNobleBgViewMarginBottom(true);
                                                    ((DialogRoomUserInfoBinding) getBinding()).imageUserInfo.setVisibility(0);
                                                    ((DialogRoomUserInfoBinding) getBinding()).imageUserLeaveRoom.setVisibility(0);
                                                    if (this.mRoomHasMicOn) {
                                                        if (meetingRoomManager.checkUserOnMic(user.getExternalId())) {
                                                            ((DialogRoomUserInfoBinding) getBinding()).imageInviteUserUpMic.setVisibility(8);
                                                        } else {
                                                            ((DialogRoomUserInfoBinding) getBinding()).imageInviteUserUpMic.setVisibility(0);
                                                        }
                                                    } else {
                                                        ((DialogRoomUserInfoBinding) getBinding()).imageInviteUserUpMic.setVisibility(8);
                                                    }
                                                    Unit unit15 = Unit.INSTANCE;
                                                }
                                            } else {
                                                ((DialogRoomUserInfoBinding) getBinding()).llUserMicroRoomOperator.setVisibility(0);
                                                updateNobleBgViewMarginBottom(true);
                                                ((DialogRoomUserInfoBinding) getBinding()).imageUserLeaveRoom.setVisibility(0);
                                                ((DialogRoomUserInfoBinding) getBinding()).imageUserInfo.setVisibility(8);
                                                if (this.mRoomHasMicOn) {
                                                    if (meetingRoomManager.checkUserOnMic(user.getExternalId())) {
                                                        ((DialogRoomUserInfoBinding) getBinding()).imageInviteUserUpMic.setVisibility(8);
                                                    } else {
                                                        ((DialogRoomUserInfoBinding) getBinding()).imageInviteUserUpMic.setVisibility(0);
                                                    }
                                                } else {
                                                    ((DialogRoomUserInfoBinding) getBinding()).imageInviteUserUpMic.setVisibility(8);
                                                }
                                                Unit unit16 = Unit.INSTANCE;
                                            }
                                        } else {
                                            User user15 = this.mUser;
                                            if (user15 != null) {
                                                z6 = Intrinsics.areEqual(user15.getHasGroupCountryManagerPower(), Boolean.TRUE);
                                            } else {
                                                z6 = false;
                                            }
                                            if (z6) {
                                                ((DialogRoomUserInfoBinding) getBinding()).llUserMicroRoomOperator.setVisibility(0);
                                                updateNobleBgViewMarginBottom(true);
                                                ((DialogRoomUserInfoBinding) getBinding()).imageUserLeaveRoom.setVisibility(0);
                                                ((DialogRoomUserInfoBinding) getBinding()).imageUserInfo.setVisibility(8);
                                                ((DialogRoomUserInfoBinding) getBinding()).imageInviteUserUpMic.setVisibility(8);
                                            } else {
                                                ((DialogRoomUserInfoBinding) getBinding()).llUserMicroRoomOperator.setVisibility(8);
                                                updateNobleBgViewMarginBottom(false);
                                            }
                                            Unit unit17 = Unit.INSTANCE;
                                        }
                                    }
                                }
                                ((DialogRoomUserInfoBinding) getBinding()).rootBg.setVisibility(0);
                            }
                        }
                        ((DialogRoomUserInfoBinding) getBinding()).micMute.setVisibility(8);
                        user3 = this.mUser;
                        if (user3 != null) {
                        }
                        str5 = "";
                        if (!meetingRoomManager.haveLocalMute(str5)) {
                        }
                        if (this.mMicPosition <= 0) {
                        }
                        ((DialogRoomUserInfoBinding) getBinding()).rootBg.setVisibility(0);
                    }
                }
                i14 = 8;
                ((DialogRoomUserInfoBinding) getBinding()).gameLevel.getRoot().setVisibility(8);
                if (isMyself) {
                }
                meetingRoomManager = MeetingRoomManager.INSTANCE;
                user2 = this.mUser;
                if (user2 != null) {
                }
                if (meetingRoomManager.checkUserOnMic(str4)) {
                }
                ((DialogRoomUserInfoBinding) getBinding()).micMute.setVisibility(8);
                user3 = this.mUser;
                if (user3 != null) {
                }
                str5 = "";
                if (!meetingRoomManager.haveLocalMute(str5)) {
                }
                if (this.mMicPosition <= 0) {
                }
                ((DialogRoomUserInfoBinding) getBinding()).rootBg.setVisibility(0);
            }
        }
        ((DialogRoomUserInfoBinding) getBinding()).familyNamePlate.getRoot().setVisibility(8);
        if (user.getGameLevel() != null) {
        }
        i14 = 8;
        ((DialogRoomUserInfoBinding) getBinding()).gameLevel.getRoot().setVisibility(8);
        if (isMyself) {
        }
        meetingRoomManager = MeetingRoomManager.INSTANCE;
        user2 = this.mUser;
        if (user2 != null) {
        }
        if (meetingRoomManager.checkUserOnMic(str4)) {
        }
        ((DialogRoomUserInfoBinding) getBinding()).micMute.setVisibility(8);
        user3 = this.mUser;
        if (user3 != null) {
        }
        str5 = "";
        if (!meetingRoomManager.haveLocalMute(str5)) {
        }
        if (this.mMicPosition <= 0) {
        }
        ((DialogRoomUserInfoBinding) getBinding()).rootBg.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean initUserView$lambda$8(User user, UserInfoBottomSheetDialog userInfoBottomSheetDialog, View view) {
        Toast normal$default;
        if (StringKtxKt.copyToClipboard(user.getCode()) && (normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, userInfoBottomSheetDialog.getContext(), ResourcesKtxKt.getStringById(userInfoBottomSheetDialog, 2131952379), false, 4, (Object) null)) != null) {
            normal$default.show();
            return true;
        }
        return true;
    }

    private final void inviteUserUpMic() {
        String str;
        if (MeetingRoomManager.INSTANCE.findNullMicPosition() > 0) {
            UserInfoListener userInfoListener = this.mUserInfoListener;
            if (userInfoListener != null) {
                User user = this.mUser;
                if (user == null || (str = user.getExternalId()) == null) {
                    str = "";
                }
                userInfoListener.inviteUserUpMic(str);
                return;
            }
            return;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.mCurrentContext, "待翻译:麦位已经满了", false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void isShowMuteIcon(boolean isMute) {
        int i;
        boolean z = false;
        if (isMute && !this.mIsMyself) {
            ((DialogRoomUserInfoBinding) getBinding()).imageUserMuteOpenMic.setVisibility(8);
        } else {
            ((DialogRoomUserInfoBinding) getBinding()).imageUserMuteOpenMic.setVisibility(0);
        }
        User user = this.mUser;
        if (user != null) {
            z = Intrinsics.areEqual(user.getHasGroupCountryManagerPower(), Boolean.TRUE);
        }
        if (z && !this.mIsMyself && isMute) {
            ((DialogRoomUserInfoBinding) getBinding()).imageUserMuteOpenMic.setVisibility(8);
        }
        ImageView imageView = ((DialogRoomUserInfoBinding) getBinding()).imageUserMuteOpenMic;
        Context context = getContext();
        if (isMute) {
            i = R.drawable.icon_user_un_mute_mic;
        } else {
            i = R.drawable.icon_user_mute_mic;
        }
        imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, i));
    }

    private final void operateMuteOrUnMuteMic() {
        boolean z;
        UserInfoListener userInfoListener;
        boolean z2 = false;
        MicroBean microBean = (MicroBean) MeetingRoomManager.getMicQueue$default(MeetingRoomManager.INSTANCE, false, 1, null).get(Integer.valueOf(this.mMicPosition));
        if (microBean != null) {
            z = Intrinsics.areEqual(microBean.getForbid(), Boolean.TRUE);
        } else {
            z = false;
        }
        if (z) {
            if (this.mIsMyself && (userInfoListener = this.mUserInfoListener) != null) {
                userInfoListener.unMuteMic(this.mMicPosition);
                return;
            }
            return;
        }
        boolean z3 = this.mIsMyself;
        if (z3) {
            UserInfoListener userInfoListener2 = this.mUserInfoListener;
            if (userInfoListener2 != null) {
                userInfoListener2.muteMic(this.mMicPosition, z3);
                return;
            }
            return;
        }
        if (this.mMyUserRole <= this.mUserRole) {
            User user = this.mUser;
            if (user != null) {
                z2 = Intrinsics.areEqual(user.getHasGroupCountryManagerPower(), Boolean.TRUE);
            }
            if (!z2) {
                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.mCurrentContext, ResourcesKtxKt.getStringById(this, 2131952966), false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                    return;
                }
                return;
            }
        }
        UserInfoListener userInfoListener3 = this.mUserInfoListener;
        if (userInfoListener3 != null) {
            userInfoListener3.muteMic(this.mMicPosition, this.mIsMyself);
        }
    }

    private final void playSvga(String svgaUrl) {
        try {
            SVGAParser.Companion.shareParser().decodeFromAssets(svgaUrl, new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoBottomSheetDialog$playSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    Drawable sVGADrawable = new SVGADrawable(videoItem, new SVGADynamicEntity());
                    UserInfoBottomSheetDialog.access$getBinding(UserInfoBottomSheetDialog.this).countrySVGA.setVisibility(0);
                    UserInfoBottomSheetDialog.access$getBinding(UserInfoBottomSheetDialog.this).countrySVGA.stopAnimation(true);
                    UserInfoBottomSheetDialog.access$getBinding(UserInfoBottomSheetDialog.this).countrySVGA.setImageDrawable(sVGADrawable);
                    UserInfoBottomSheetDialog.access$getBinding(UserInfoBottomSheetDialog.this).countrySVGA.startAnimation();
                }

                public void onError() {
                }
            });
        } catch (Exception unused) {
        }
    }

    private final void playTopSvga(String svgaUrl, boolean isLocal) {
        if (TextUtils.isEmpty(svgaUrl)) {
            return;
        }
        try {
            SVGAParser.ParseCompletion parseCompletion = new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoBottomSheetDialog$playTopSvga$complete$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    Drawable sVGADrawable = new SVGADrawable(videoItem, new SVGADynamicEntity());
                    UserInfoBottomSheetDialog.access$getBinding(UserInfoBottomSheetDialog.this).nobleSvga.setVisibility(0);
                    UserInfoBottomSheetDialog.access$getBinding(UserInfoBottomSheetDialog.this).nobleSvga.stopAnimation(true);
                    UserInfoBottomSheetDialog.access$getBinding(UserInfoBottomSheetDialog.this).nobleSvga.setImageDrawable(sVGADrawable);
                    UserInfoBottomSheetDialog.access$getBinding(UserInfoBottomSheetDialog.this).nobleSvga.startAnimation();
                }

                public void onError() {
                }
            };
            if (isLocal) {
                SVGAParser.Companion.shareParser().decodeFromAssets(svgaUrl, parseCompletion);
            } else {
                SVGAParser.Companion.shareParser().decodeFromURL(new URL(svgaUrl), parseCompletion);
            }
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void playTopSvga$default(UserInfoBottomSheetDialog userInfoBottomSheetDialog, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        userInfoBottomSheetDialog.playTopSvga(str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportCurrentUser() {
        new ReportWhiteDialog(this.mCurrentContext).setListener(new UserInfoBottomSheetDialog$reportCurrentUser$1(this)).show();
    }

    private final void showBlockOrReport() {
        BlockOrReportDialog blockOrReportDialog = new BlockOrReportDialog(this.mCurrentContext, BlockOrReportDialog.Companion.getTextList$default(BlockOrReportDialog.INSTANCE, BlockOrReportDialog.REPORT_AND_BLOCK, false, false, false, 14, null));
        blockOrReportDialog.setMListener(new SelectInterface() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoBottomSheetDialog$showBlockOrReport$1$1
            /* JADX WARN: Type inference failed for: r5v2, types: [android.app.Dialog, com.qiahao.nextvideo.ui.base.BlockTextDialog] */
            public void onSelect(int index) {
                if (index == 0) {
                    UserInfoBottomSheetDialog.this.reportCurrentUser();
                    return;
                }
                if (index == 1) {
                    ?? blockTextDialog = new BlockTextDialog(UserInfoBottomSheetDialog.this.getMCurrentContext());
                    UserInfoBottomSheetDialog userInfoBottomSheetDialog = UserInfoBottomSheetDialog.this;
                    String string = blockTextDialog.getMContext().getString(2131952131);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    blockTextDialog.setContentText(string, true, userInfoBottomSheetDialog);
                    blockTextDialog.show();
                }
            }
        });
        blockOrReportDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toVideoCurrent$lambda$22$lambda$20(UserInfoBottomSheetDialog userInfoBottomSheetDialog, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        userInfoBottomSheetDialog.confirmLike();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toVideoCurrent$lambda$22$lambda$21(UserInfoBottomSheetDialog userInfoBottomSheetDialog) {
        userInfoBottomSheetDialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void userMedalShow(User user) {
        List medals = user.getMedals();
        if (medals != null && !medals.isEmpty()) {
            ((DialogRoomUserInfoBinding) getBinding()).llMeadl.cleanAllMedal();
            ((DialogRoomUserInfoBinding) getBinding()).llMeadl.setMaxSize(15);
            ArrayList<MedalBean> arrayList = this.mMedalList;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
            for (Object obj : arrayList) {
                linkedHashMap.put(Integer.valueOf(((MedalBean) obj).getMedalId()), obj);
            }
            List medals2 = user.getMedals();
            if (medals2 != null) {
                Iterator it = medals2.iterator();
                while (it.hasNext()) {
                    MedalBean medalBean = (MedalBean) linkedHashMap.get(Integer.valueOf(((Number) it.next()).intValue()));
                    if (medalBean != null) {
                        ((DialogRoomUserInfoBinding) getBinding()).llMeadl.addMedal(medalBean.getPicUrl());
                    }
                }
            }
        }
    }

    @Override // com.qiahao.nextvideo.ui.base.OnBlockCommonDialogListener
    public void blockTextCancel() {
        OnBlockCommonDialogListener.DefaultImpls.blockTextCancel(this);
    }

    @Override // com.qiahao.nextvideo.ui.base.OnBlockCommonDialogListener
    public void blockTextDialogConfirm() {
        String str;
        Log.d(TAG, "confirm: -拉黑的回调-------");
        FeedbackService shared = FeedbackService.INSTANCE.getShared();
        User user = this.mUser;
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        io.reactivex.rxjava3.core.i0 j = shared.blockUser(str).j(new pd.o() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoBottomSheetDialog$blockTextDialogConfirm$1
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                apply((ApiResponse<Object>) obj);
                return Unit.INSTANCE;
            }

            public final void apply(ApiResponse<Object> apiResponse) {
                Intrinsics.checkNotNullParameter(apiResponse, "it");
                V2TIMConversationManager conversationManager = V2TIMManager.getConversationManager();
                User mUser = UserInfoBottomSheetDialog.this.getMUser();
                conversationManager.deleteConversation(mUser != null ? mUser.getExternalId() : null, new V2TIMCallback() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoBottomSheetDialog$blockTextDialogConfirm$1.1
                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onError(int code, String desc) {
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onSuccess() {
                        MessageProvide.INSTANCE.displayData(MessageProvide.MESSAGE_DEFAULT);
                    }
                });
            }
        });
        Intrinsics.checkNotNullExpressionValue(j, "map(...)");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(j, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.h4
            public final Object invoke(Object obj) {
                Unit blockTextDialogConfirm$lambda$24;
                blockTextDialogConfirm$lambda$24 = UserInfoBottomSheetDialog.blockTextDialogConfirm$lambda$24(UserInfoBottomSheetDialog.this, (Unit) obj);
                return blockTextDialogConfirm$lambda$24;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.i4
            public final Object invoke(Object obj) {
                Unit blockTextDialogConfirm$lambda$25;
                blockTextDialogConfirm$lambda$25 = UserInfoBottomSheetDialog.blockTextDialogConfirm$lambda$25(UserInfoBottomSheetDialog.this, (Throwable) obj);
                return blockTextDialogConfirm$lambda$25;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.room.dialog.j4
            public final Object invoke() {
                Unit blockTextDialogConfirm$lambda$26;
                blockTextDialogConfirm$lambda$26 = UserInfoBottomSheetDialog.blockTextDialogConfirm$lambda$26(UserInfoBottomSheetDialog.this);
                return blockTextDialogConfirm$lambda$26;
            }
        }, false, 8, (Object) null), this.mCompositeDisposable);
    }

    public void dismiss() {
        super.dismiss();
        CoroutineScopeKt.cancel$default(this.dialogScope, (CancellationException) null, 1, (Object) null);
        ((DialogRoomUserInfoBinding) getBinding()).queuePlayer.onDestroy();
        this.mUserInfoListener = null;
        this.mCompositeDisposable.d();
    }

    public final void getData() {
        String str;
        String str2;
        String str3;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        User user = this.mUser;
        String str4 = null;
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        this.mUserRole = meetingRoomManager.getRoomUserRole(str);
        UserStore.Companion companion = UserStore.INSTANCE;
        User user2 = companion.getShared().getUser();
        if (user2 != null) {
            str2 = user2.getExternalId();
        } else {
            str2 = null;
        }
        this.mMyUserRole = meetingRoomManager.getRoomUserRole(str2);
        User user3 = companion.getShared().getUser();
        if (user3 != null && user3.isOfficialStaff()) {
            this.mMyUserRole = 1000;
        }
        BaseService appService = AllModuleServiceManager.Companion.get().getAppService();
        Intrinsics.checkNotNull(appService, "null cannot be cast to non-null type com.qiahao.nextvideo.data.service.OutPutOtherModuleService");
        this.mMedalList = ((OutPutOtherModuleService) appService).m٠getMedalList();
        User user4 = this.mUser;
        if (user4 != null) {
            str3 = user4.getExternalId();
        } else {
            str3 = null;
        }
        User user5 = companion.getShared().getUser();
        if (user5 != null) {
            str4 = user5.getExternalId();
        }
        boolean areEqual = Intrinsics.areEqual(str3, str4);
        this.mIsMyself = areEqual;
        User user6 = this.mUser;
        if (user6 != null) {
            initUserView(user6, areEqual);
        }
    }

    protected int getLayoutResId() {
        return R.layout.dialog_room_user_info;
    }

    @NotNull
    public final Context getMCurrentContext() {
        return this.mCurrentContext;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    @Nullable
    public final User getMUser() {
        return this.mUser;
    }

    protected boolean isBottomStyle() {
        return true;
    }

    protected boolean isNeedFullScreen() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        UserInfoListener userInfoListener;
        String str;
        String externalId;
        String str2;
        boolean z;
        Boolean hasGroupCountryManagerPower;
        boolean z2;
        UserInfoListener userInfoListener2;
        String str3;
        String externalId2;
        String str4;
        String externalId3;
        String str5;
        String externalId4;
        Intrinsics.checkNotNullParameter(v, "v");
        String str6 = "";
        switch (v.getId()) {
            case R.id.call_user /* 2131362212 */:
                User user = this.mUser;
                if (user != null && (userInfoListener = this.mUserInfoListener) != null) {
                    if (user == null || (str = user.getExternalId()) == null) {
                        str = "";
                    }
                    String nick = user.getNick();
                    if (nick != null) {
                        str6 = nick;
                    }
                    userInfoListener.callUser(str, str6);
                }
                dismiss();
                return;
            case R.id.image_invite_user_up_mic /* 2131363223 */:
                inviteUserUpMic();
                dismiss();
                return;
            case R.id.image_user_down_mic /* 2131363233 */:
                downMic();
                dismiss();
                return;
            case R.id.image_user_info /* 2131363234 */:
                if (this.mMyUserRole > this.mUserRole) {
                    RoomUserInfoRoleActivity.Companion companion = RoomUserInfoRoleActivity.INSTANCE;
                    Context context = this.mCurrentContext;
                    String str7 = this.mGroupId;
                    User user2 = this.mUser;
                    if (user2 != null && (externalId = user2.getExternalId()) != null) {
                        str6 = externalId;
                    }
                    companion.start(context, str7, str6);
                } else {
                    Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.mCurrentContext, ResourcesKtxKt.getStringById(this, 2131952966), false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                }
                dismiss();
                return;
            case R.id.image_user_leave_room /* 2131363235 */:
                if (this.mMyUserRole <= this.mUserRole) {
                    User user3 = this.mUser;
                    if (user3 != null) {
                        z2 = Intrinsics.areEqual(user3.getHasGroupCountryManagerPower(), Boolean.TRUE);
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.mCurrentContext, ResourcesKtxKt.getStringById(this, 2131952966), false, 4, (Object) null);
                        if (normal$default2 != null) {
                            normal$default2.show();
                        }
                        dismiss();
                        return;
                    }
                }
                RoomUserInfoBlockActivity.Companion companion2 = RoomUserInfoBlockActivity.INSTANCE;
                Context context2 = this.mCurrentContext;
                User user4 = this.mUser;
                if (user4 == null || (str2 = user4.getExternalId()) == null) {
                    str2 = "";
                }
                String str8 = this.mGroupId;
                User user5 = this.mUser;
                if (user5 != null && (hasGroupCountryManagerPower = user5.getHasGroupCountryManagerPower()) != null) {
                    z = hasGroupCountryManagerPower.booleanValue();
                } else {
                    z = false;
                }
                companion2.start(context2, str2, str8, z, this.mMyUserRole);
                dismiss();
                return;
            case R.id.image_user_mute_open_mic /* 2131363236 */:
                operateMuteOrUnMuteMic();
                dismiss();
                return;
            case R.id.ll_gift /* 2131363552 */:
                User user6 = this.mUser;
                if (user6 != null && (userInfoListener2 = this.mUserInfoListener) != null) {
                    if (user6 == null || (str3 = user6.getExternalId()) == null) {
                        str3 = "";
                    }
                    String nick2 = user6.getNick();
                    if (nick2 != null) {
                        str6 = nick2;
                    }
                    userInfoListener2.giftShow(str3, str6);
                }
                dismiss();
                return;
            case R.id.ll_like /* 2131363564 */:
                if (this.mUser == null) {
                    return;
                }
                confirmLike();
                return;
            case R.id.ll_message /* 2131363570 */:
                User user7 = this.mUser;
                if (user7 == null) {
                    return;
                }
                if (user7 != null && (externalId2 = user7.getExternalId()) != null) {
                    str6 = externalId2;
                }
                checkCanSendMessage(str6);
                return;
            case R.id.ll_power_name /* 2131363581 */:
                User user8 = this.mUser;
                if (user8 != null && user8.getMyGroupPower() > 0) {
                    PowerActivity.INSTANCE.start(this.mCurrentContext, user8.getMyGroupPower());
                    return;
                }
                return;
            case R.id.ll_video /* 2131363604 */:
                Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
                if (currentActivity != null && !PermissionUtils.INSTANCE.checkPermission(currentActivity)) {
                    UserInfoListener userInfoListener3 = this.mUserInfoListener;
                    if (userInfoListener3 != null) {
                        userInfoListener3.videoRequesPermiss();
                        return;
                    }
                    return;
                }
                toVideoCurrent();
                return;
            case R.id.micMute /* 2131363859 */:
                MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                User user9 = this.mUser;
                if (user9 == null || (str4 = user9.getExternalId()) == null) {
                    str4 = "";
                }
                if (meetingRoomManager.haveLocalMute(str4)) {
                    User user10 = this.mUser;
                    if (user10 != null && (externalId4 = user10.getExternalId()) != null) {
                        str6 = externalId4;
                    }
                    meetingRoomManager.removeLocalMute(str6);
                    ((DialogRoomUserInfoBinding) getBinding()).micMute.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.person_mic_on));
                } else {
                    ArrayList<String> localMuteList = meetingRoomManager.getLocalMuteList();
                    User user11 = this.mUser;
                    if (user11 != null && (externalId3 = user11.getExternalId()) != null) {
                        str6 = externalId3;
                    }
                    localMuteList.add(str6);
                    ((DialogRoomUserInfoBinding) getBinding()).micMute.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.person_mic_off));
                }
                cf.c c = cf.c.c();
                User user12 = this.mUser;
                if (user12 != null) {
                    str5 = user12.getExternalId();
                } else {
                    str5 = null;
                }
                c.l(new LiveEvent("local_mute", str5));
                return;
            case R.id.report_image_view /* 2131364588 */:
                if (this.mUser == null) {
                    return;
                }
                showBlockOrReport();
                return;
            case R.id.root_bg /* 2131364681 */:
                dismiss();
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
        }
        ((DialogRoomUserInfoBinding) getBinding()).setClick(this);
        View root = ((DialogRoomUserInfoBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(root);
        if (lifecycleOwner != null) {
            ((DialogRoomUserInfoBinding) getBinding()).queuePlayer.bindingLifeCycle(lifecycleOwner);
        }
        BuildersKt.launch$default(this.dialogScope, Dispatchers.getMain(), (CoroutineStart) null, new UserInfoBottomSheetDialog$onInitialize$2(this, null), 2, (Object) null);
        getData();
    }

    public final void setMGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGroupId = str;
    }

    public final void setMUser(@Nullable User user) {
        this.mUser = user;
    }

    public final void setUserInfoListener(@NotNull UserInfoListener userInfoListener) {
        Intrinsics.checkNotNullParameter(userInfoListener, "userInfoListener");
        this.mUserInfoListener = userInfoListener;
    }

    public final void showLikeImageView(int like) {
        int i = R.drawable.icon_room_user_unlike;
        if (like != 0) {
            if (like != 1) {
                if (like == 2) {
                    i = R.drawable.icon_room_user_like_each_other;
                }
            } else {
                i = R.drawable.icon_room_user_like;
            }
        }
        ((DialogRoomUserInfoBinding) getBinding()).imageLike.setImageDrawable(this.mCurrentContext.getResources().getDrawable(i));
    }

    public final void toVideoCurrent() {
        User user = this.mUser;
        if (user != null) {
            VideoCallMessage.INSTANCE.newStartVideo(this.mCurrentContext, user.getExternalId(), new Function2() { // from class: com.qiahao.nextvideo.room.dialog.m4
                public final Object invoke(Object obj, Object obj2) {
                    Unit videoCurrent$lambda$22$lambda$20;
                    videoCurrent$lambda$22$lambda$20 = UserInfoBottomSheetDialog.toVideoCurrent$lambda$22$lambda$20(UserInfoBottomSheetDialog.this, (String) obj, ((Boolean) obj2).booleanValue());
                    return videoCurrent$lambda$22$lambda$20;
                }
            }, new Function0() { // from class: com.qiahao.nextvideo.room.dialog.n4
                public final Object invoke() {
                    Unit videoCurrent$lambda$22$lambda$21;
                    videoCurrent$lambda$22$lambda$21 = UserInfoBottomSheetDialog.toVideoCurrent$lambda$22$lambda$21(UserInfoBottomSheetDialog.this);
                    return videoCurrent$lambda$22$lambda$21;
                }
            });
        }
    }

    public final void updateNobleBgViewMarginBottom(boolean isMarginBottom) {
        ConstraintLayout.b layoutParams = ((DialogRoomUserInfoBinding) getBinding()).nobleBg.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = layoutParams;
        if (isMarginBottom) {
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = Dimens.INSTANCE.dpToPx(47);
        } else {
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = 0;
        }
        ((DialogRoomUserInfoBinding) getBinding()).nobleBg.setLayoutParams(bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void userRoomTagShow() {
        if (this.mUserRole > 1) {
            ((DialogRoomUserInfoBinding) getBinding()).userTagView.setVisibility(0);
            ((DialogRoomUserInfoBinding) getBinding()).imageUserTag.setVisibility(0);
            ((DialogRoomUserInfoBinding) getBinding()).userTagText.setVisibility(0);
            TextView textView = ((DialogRoomUserInfoBinding) getBinding()).userTagText;
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            textView.setText(meetingRoomManager.getLevelString(this.mUserRole));
            ((DialogRoomUserInfoBinding) getBinding()).imageUserTag.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), meetingRoomManager.getLevelRes(this.mUserRole)));
            return;
        }
        ((DialogRoomUserInfoBinding) getBinding()).userTagView.setVisibility(8);
        ((DialogRoomUserInfoBinding) getBinding()).imageUserTag.setVisibility(8);
        ((DialogRoomUserInfoBinding) getBinding()).userTagText.setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserInfoBottomSheetDialog(@NotNull Context context, @Nullable User user, int i, @NotNull String str, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mCurrentContext");
        Intrinsics.checkNotNullParameter(str, "mGroupId");
        this.mCurrentContext = context;
        this.mUser = user;
        this.mMicPosition = i;
        this.mGroupId = str;
        this.mRoomHasMicOn = z;
        this.mMedalList = new ArrayList<>();
        this.mCompositeDisposable = new nd.a();
        this.dialogScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
    }
}
