package com.qiahao.nextvideo.room.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.AllModuleServiceManager;
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
import com.qiahao.base_common.service.BaseService;
import com.qiahao.base_common.ui.dialog.ReportWhiteDialog;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RelationTypeUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.HiloImageView;
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
import com.qiahao.nextvideo.databinding.DialogRoomCpUserInfoBinding;
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
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 x2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001xB1\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001b\u0010\u0012J\u0017\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\"\u0010\u0012J\u000f\u0010#\u001a\u00020\u0010H\u0002¢\u0006\u0004\b#\u0010\u0012J\u000f\u0010$\u001a\u00020\u0010H\u0002¢\u0006\u0004\b$\u0010\u0012J\u000f\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0004\b%\u0010\u0012J\u000f\u0010&\u001a\u00020\u0010H\u0002¢\u0006\u0004\b&\u0010\u0012J\u000f\u0010'\u001a\u00020\u0010H\u0002¢\u0006\u0004\b'\u0010\u0012J\u000f\u0010(\u001a\u00020\u0010H\u0002¢\u0006\u0004\b(\u0010\u0012J\u0017\u0010*\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\fH\u0002¢\u0006\u0004\b*\u0010\u001aJ\u0017\u0010,\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\nH\u0002¢\u0006\u0004\b,\u0010!J\u0019\u0010/\u001a\u00020\u00102\b\u0010.\u001a\u0004\u0018\u00010-H\u0014¢\u0006\u0004\b/\u00100J\u0015\u00103\u001a\u00020\u00102\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\u0010¢\u0006\u0004\b5\u0010\u0012J\u0017\u00108\u001a\u00020\u00102\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0010H\u0016¢\u0006\u0004\b:\u0010\u0012J\u000f\u0010;\u001a\u00020\u0010H\u0016¢\u0006\u0004\b;\u0010\u0012R\u0016\u0010<\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\"\u0010?\u001a\u00020>8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010E\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010!R\"\u0010J\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010\u001eR\"\u0010O\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010K\u001a\u0004\bP\u0010M\"\u0004\bQ\u0010\u001eR\"\u0010R\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010K\u001a\u0004\bS\u0010M\"\u0004\bT\u0010\u001eR\"\u0010U\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010\u001aR$\u0010Z\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u00104R\"\u0010_\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010V\u001a\u0004\b`\u0010X\"\u0004\ba\u0010\u001aR$\u0010b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010\u0017R\"\u0010g\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010V\u001a\u0004\bg\u0010X\"\u0004\bh\u0010\u001aR2\u0010l\u001a\u0012\u0012\u0004\u0012\u00020j0ij\b\u0012\u0004\u0012\u00020j`k8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u0014\u0010s\u001a\u00020r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010v\u001a\u00020u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010w¨\u0006y"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/UserInfoCpDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "Lcom/qiahao/nextvideo/ui/base/OnBlockCommonDialogListener;", "Landroid/content/Context;", "context", "Lcom/qiahao/base_common/model/common/User;", "user", "", "micPosition", "", "groupId", "", "roomHasMicOn", "<init>", "(Landroid/content/Context;Lcom/qiahao/base_common/model/common/User;ILjava/lang/String;Z)V", "", "initStyle", "()V", "isMyself", "initUserView", "(Lcom/qiahao/base_common/model/common/User;Z)V", "userMedalShow", "(Lcom/qiahao/base_common/model/common/User;)V", "isMute", "isShowMuteIcon", "(Z)V", "userRoomTagShow", OnlineCellViewHolder.CLICK_LIKE, "showLikeImageView", "(I)V", "svgaUrl", "playSvga", "(Ljava/lang/String;)V", "confirmLike", "downMic", "inviteUserUpMic", "operateMuteOrUnMuteMic", "toVideoCurrent", "showBlockOrReport", "reportCurrentUser", "isMarginBottom", "updateNobleBgViewMarginBottom", TUIConstants.TUILive.USER_ID, "checkCanSendMessage", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/qiahao/nextvideo/room/interfaces/UserInfoListener;", "userInfoListener", "setUserInfoListener", "(Lcom/qiahao/nextvideo/room/interfaces/UserInfoListener;)V", "getData", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "dismiss", "blockTextDialogConfirm", "mCurrentContext", "Landroid/content/Context;", "Lcom/qiahao/nextvideo/databinding/DialogRoomCpUserInfoBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/DialogRoomCpUserInfoBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/DialogRoomCpUserInfoBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/DialogRoomCpUserInfoBinding;)V", "mGroupId", "Ljava/lang/String;", "getMGroupId", "()Ljava/lang/String;", "setMGroupId", "mMicPosition", "I", "getMMicPosition", "()I", "setMMicPosition", "mUserRole", "getMUserRole", "setMUserRole", "mMyUserRole", "getMMyUserRole", "setMMyUserRole", "mRoomHasMicOn", "Z", "getMRoomHasMicOn", "()Z", "setMRoomHasMicOn", "mUserInfoListener", "Lcom/qiahao/nextvideo/room/interfaces/UserInfoListener;", "getMUserInfoListener", "()Lcom/qiahao/nextvideo/room/interfaces/UserInfoListener;", "setMUserInfoListener", "mIsMyself", "getMIsMyself", "setMIsMyself", "mUser", "Lcom/qiahao/base_common/model/common/User;", "getMUser", "()Lcom/qiahao/base_common/model/common/User;", "setMUser", "isRequest", "setRequest", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/MedalBean;", "Lkotlin/collections/ArrayList;", "mMedalList", "Ljava/util/ArrayList;", "getMMedalList", "()Ljava/util/ArrayList;", "setMMedalList", "(Ljava/util/ArrayList;)V", "Lkotlinx/coroutines/CoroutineScope;", "dialogScope", "Lkotlinx/coroutines/CoroutineScope;", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUserInfoCpDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserInfoCpDialog.kt\ncom/qiahao/nextvideo/room/dialog/UserInfoCpDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1158:1\n1#2:1159\n61#3,9:1160\n61#3,9:1169\n1208#4,2:1178\n1236#4,4:1180\n1869#4,2:1184\n*S KotlinDebug\n*F\n+ 1 UserInfoCpDialog.kt\ncom/qiahao/nextvideo/room/dialog/UserInfoCpDialog\n*L\n317#1:1160,9\n448#1:1169,9\n653#1:1178,2\n653#1:1180,4\n654#1:1184,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class UserInfoCpDialog extends AppCompatDialog implements View.OnClickListener, OnBlockCommonDialogListener {

    @NotNull
    private static final String TAG = "UserInfoBottomSheetDial";
    public DialogRoomCpUserInfoBinding binding;

    @NotNull
    private final CoroutineScope dialogScope;
    private boolean isRequest;

    @NotNull
    private nd.a mCompositeDisposable;

    @NotNull
    private Context mCurrentContext;

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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserInfoCpDialog(@NotNull Context context, @NotNull User user, int i, @NotNull String str, boolean z) {
        super(context, R.style.HiloBottomSheetDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(str, "groupId");
        this.mRoomHasMicOn = true;
        this.mMedalList = new ArrayList<>();
        this.dialogScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        this.mCompositeDisposable = new nd.a();
        this.mCurrentContext = context;
        this.mUser = user;
        this.mMicPosition = i;
        this.mGroupId = str;
        this.mRoomHasMicOn = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit blockTextDialogConfirm$lambda$23(UserInfoCpDialog userInfoCpDialog, Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        userInfoCpDialog.dismiss();
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, userInfoCpDialog.getContext(), ResourcesKtxKt.getStringById(userInfoCpDialog, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit blockTextDialogConfirm$lambda$24(UserInfoCpDialog userInfoCpDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = userInfoCpDialog.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = ResourcesKtxKt.getStringById(userInfoCpDialog, 2131952667);
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
    public static final Unit blockTextDialogConfirm$lambda$25(UserInfoCpDialog userInfoCpDialog) {
        String str;
        la.c reportEventRelay = FeedbackService.INSTANCE.getShared().getReportEventRelay();
        User user = userInfoCpDialog.mUser;
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
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().checkCanSession(userId), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.s4
            public final Object invoke(Object obj) {
                Unit checkCanSendMessage$lambda$27;
                checkCanSendMessage$lambda$27 = UserInfoCpDialog.checkCanSendMessage$lambda$27(UserInfoCpDialog.this, (ApiResponse) obj);
                return checkCanSendMessage$lambda$27;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.t4
            public final Object invoke(Object obj) {
                Unit checkCanSendMessage$lambda$28;
                checkCanSendMessage$lambda$28 = UserInfoCpDialog.checkCanSendMessage$lambda$28(UserInfoCpDialog.this, (Throwable) obj);
                return checkCanSendMessage$lambda$28;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.lang.Object, android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
    public static final Unit checkCanSendMessage$lambda$27(final UserInfoCpDialog userInfoCpDialog, ApiResponse apiResponse) {
        Integer num;
        Toast normal$default;
        String str;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        userInfoCpDialog.isRequest = false;
        CheckSessionBean checkSessionBean = (CheckSessionBean) apiResponse.getData();
        if (checkSessionBean != null) {
            num = Integer.valueOf(checkSessionBean.getCanTalk());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
            User user = userInfoCpDialog.mUser;
            if (user == null || (str = user.getExternalId()) == null) {
                str = "";
            }
            appRequestUtils.openChatActivity(str);
        } else if (num != null && num.intValue() == 2) {
            final ?? commonTextDialog = new CommonTextDialog(userInfoCpDialog.mCurrentContext, 0.0f, 2, null);
            commonTextDialog.setContentText(ResourcesKtxKt.getStringById((Object) commonTextDialog, 2131953227), true, ResourcesKtxKt.getStringById((Object) commonTextDialog, 2131953219), ResourcesKtxKt.getStringById((Object) commonTextDialog, 2131952171), new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoCpDialog$checkCanSendMessage$1$1$1
                public void cancel() {
                    commonTextDialog.dismiss();
                    UserInfoCpDialog.this.dismiss();
                }

                public void confirm() {
                    UserInfoCpDialog.this.confirmLike();
                    commonTextDialog.dismiss();
                }
            });
            commonTextDialog.show();
        } else if (num != null && num.intValue() == 3) {
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, userInfoCpDialog.getContext(), ResourcesKtxKt.getStringById(userInfoCpDialog, 2131953227), false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        } else if (num != null && num.intValue() == 5 && (normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, userInfoCpDialog.getContext(), ResourcesKtxKt.getStringById(userInfoCpDialog, 2131954530), false, 4, (Object) null)) != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit checkCanSendMessage$lambda$28(UserInfoCpDialog userInfoCpDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        userInfoCpDialog.isRequest = false;
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = userInfoCpDialog.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = ResourcesKtxKt.getStringById(userInfoCpDialog, 2131952667);
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
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.like$default(shared, str2, z, false, 4, null), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.y4
            public final Object invoke(Object obj) {
                Unit confirmLike$lambda$17;
                confirmLike$lambda$17 = UserInfoCpDialog.confirmLike$lambda$17(UserInfoCpDialog.this, (ApiResponse) obj);
                return confirmLike$lambda$17;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.z4
            public final Object invoke(Object obj) {
                Unit confirmLike$lambda$18;
                confirmLike$lambda$18 = UserInfoCpDialog.confirmLike$lambda$18(UserInfoCpDialog.this, (Throwable) obj);
                return confirmLike$lambda$18;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmLike$lambda$17(UserInfoCpDialog userInfoCpDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        LikeResult likeResult = (LikeResult) apiResponse.getData();
        if (likeResult != null) {
            User user = userInfoCpDialog.mUser;
            if (user != null) {
                user.setLike(Boolean.valueOf(likeResult.getStatus()));
            }
            User user2 = userInfoCpDialog.mUser;
            if (user2 != null) {
                user2.setLikeMe(Boolean.valueOf(likeResult.isLikeEach()));
            }
            if (likeResult.getStatus() && likeResult.isLikeEach()) {
                userInfoCpDialog.showLikeImageView(2);
            } else if (likeResult.getStatus()) {
                userInfoCpDialog.showLikeImageView(1);
            } else {
                userInfoCpDialog.showLikeImageView(0);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmLike$lambda$18(UserInfoCpDialog userInfoCpDialog, Throwable th) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            int code = hiloException.getCode();
            if (code != 9004) {
                if (code != 9005) {
                    HiloToasty.Companion companion = HiloToasty.Companion;
                    Context context = userInfoCpDialog.mCurrentContext;
                    String localizedMessage = hiloException.getLocalizedMessage();
                    if (localizedMessage == null) {
                        str2 = ResourcesKtxKt.getStringById(userInfoCpDialog, 2131952667);
                    } else {
                        str2 = localizedMessage;
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str2, false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                } else {
                    Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, userInfoCpDialog.mCurrentContext, ResourcesKtxKt.getStringById(userInfoCpDialog, 2131953231), false, 4, (Object) null);
                    if (normal$default2 != null) {
                        normal$default2.show();
                    }
                }
            } else {
                new VipViewDialog(5, userInfoCpDialog.mCurrentContext).show();
            }
        } else {
            HiloToasty.Companion companion2 = HiloToasty.Companion;
            Context context2 = userInfoCpDialog.mCurrentContext;
            String localizedMessage2 = th.getLocalizedMessage();
            if (localizedMessage2 == null) {
                str = ResourcesKtxKt.getStringById(userInfoCpDialog, 2131952667);
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
    private final void initStyle() {
        WindowManager.LayoutParams layoutParams;
        View decorView;
        setCanceledOnTouchOutside(true);
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        Window window = getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.width = -1;
        }
        if (layoutParams != null) {
            layoutParams.height = -1;
        }
        if (layoutParams != null) {
            layoutParams.horizontalMargin = 0.0f;
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setDimAmount(0.0f);
        }
        Window window4 = getWindow();
        if (window4 != null && (decorView = window4.getDecorView()) != null) {
            decorView.setPadding(0, 0, 0, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:281:0x06e4  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0757  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x07d9  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x07e5  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x081e  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x082c  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0861  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x09ba  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0841  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x07de  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0773  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initUserView(final User user, boolean isMyself) {
        int i;
        int i2;
        int i3;
        int i4;
        Integer num;
        Drawable drawable;
        HeadWearBean headWearBean;
        String str;
        String str2;
        int i5;
        int i6;
        int i7;
        boolean z;
        String str3;
        int i8;
        int i9;
        int i10;
        int i11;
        CharSequence charSequence;
        Long l;
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
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        Boolean forbid;
        String externalId;
        String str5;
        String str6;
        boolean z11;
        int i12;
        String str7;
        String title;
        Integer level;
        Integer level2;
        boolean z12;
        int i13;
        String str8;
        String nameplate;
        Integer grade;
        Long id2;
        Integer level3;
        User cpUserInfo;
        String str9;
        boolean z13;
        String str10;
        String str11;
        User cpUserInfo2;
        HeadWearBean headwear;
        User cpUserInfo3;
        HeadWearBean headwear2;
        String str12;
        boolean z14;
        String str13;
        User cpUserInfo4;
        HeadWearBean headwear3;
        User cpUserInfo5;
        HeadWearBean headwear4;
        User cpUserInfo6;
        HeadWearBean headwear5;
        User cpUserInfo7;
        String str14;
        boolean z15;
        String str15;
        String str16;
        String str17;
        boolean z16;
        String str18;
        CpLevel cpLevel;
        Integer num2;
        User cpUserInfo8;
        SvipData svip;
        User cpUserInfo9;
        SvipData svip2;
        Integer num3;
        Integer num4;
        int i14;
        User cpUserInfo10;
        NobleInfo noble;
        Integer level4;
        User cpUserInfo11;
        NobleInfo noble2;
        Integer level5;
        int i15;
        Integer level6;
        Integer level7;
        long j;
        int i16;
        UserStore.Companion companion = UserStore.INSTANCE;
        User user4 = companion.getShared().getUser();
        if (user4 != null && user4.isAr()) {
            LinearLayout linearLayout = getBinding().llVideo;
            User user5 = companion.getShared().getUser();
            if (user5 != null) {
                j = user5.getWealthUserGrade();
            } else {
                j = 0;
            }
            if (j > 10) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            linearLayout.setVisibility(i16);
        } else {
            getBinding().llVideo.setVisibility(0);
        }
        if (user.isVip()) {
            getBinding().iconVip.setVisibility(0);
        } else {
            getBinding().iconVip.setVisibility(8);
        }
        NobleInfo noble3 = user.getNoble();
        if (noble3 != null && (level7 = noble3.getLevel()) != null) {
            i = level7.intValue();
        } else {
            i = 0;
        }
        if (i > 0) {
            getBinding().iconNoble.setVisibility(0);
            ImageView imageView = getBinding().iconNoble;
            Context context = getContext();
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble4 = user.getNoble();
            if (noble4 != null && (level6 = noble4.getLevel()) != null) {
                i15 = level6.intValue();
            } else {
                i15 = 0;
            }
            imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, companion2.getNobleDrawableRes(i15)));
        } else {
            getBinding().iconNoble.setVisibility(8);
        }
        MyCp cp = user.getCp();
        if (cp != null && (cpUserInfo11 = cp.getCpUserInfo()) != null && (noble2 = cpUserInfo11.getNoble()) != null && (level5 = noble2.getLevel()) != null) {
            i2 = level5.intValue();
        } else {
            i2 = 0;
        }
        if (i2 > 0) {
            getBinding().iconNobleTwo.setVisibility(0);
            ImageView imageView2 = getBinding().iconNobleTwo;
            Context context2 = getContext();
            UserService.Companion companion3 = UserService.INSTANCE;
            MyCp cp2 = user.getCp();
            if (cp2 != null && (cpUserInfo10 = cp2.getCpUserInfo()) != null && (noble = cpUserInfo10.getNoble()) != null && (level4 = noble.getLevel()) != null) {
                i14 = level4.intValue();
            } else {
                i14 = 0;
            }
            imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context2, companion3.getNobleDrawableRes(i14)));
        } else {
            getBinding().iconNobleTwo.setVisibility(8);
        }
        SvipData svip3 = user.getSvip();
        if (svip3 != null) {
            i3 = svip3.getSvipLevel();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            getBinding().iconNoble.setVisibility(8);
            getBinding().svipMedal.setVisibility(0);
            getBinding().svipType.setVisibility(0);
            getBinding().svipTypeLine.setVisibility(0);
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            SvipData svip4 = user.getSvip();
            if (svip4 != null) {
                num3 = Integer.valueOf(svip4.getSvipLevel());
            } else {
                num3 = null;
            }
            Integer svipType = svipTypeUtils.getSvipType(num3);
            if (svipType != null) {
                getBinding().svipType.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), svipType.intValue()));
                Unit unit = Unit.INSTANCE;
            }
            SvipData svip5 = user.getSvip();
            if (svip5 != null) {
                num4 = Integer.valueOf(svip5.getSvipLevel());
            } else {
                num4 = null;
            }
            Integer svipMedal = svipTypeUtils.getSvipMedal(num4);
            if (svipMedal != null) {
                getBinding().svipMedal.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), svipMedal.intValue()));
                Unit unit2 = Unit.INSTANCE;
            }
        } else {
            getBinding().svipType.setVisibility(8);
            getBinding().svipTypeLine.setVisibility(8);
            getBinding().svipMedal.setVisibility(8);
            Unit unit3 = Unit.INSTANCE;
        }
        MyCp cp3 = user.getCp();
        if (cp3 != null && (cpUserInfo9 = cp3.getCpUserInfo()) != null && (svip2 = cpUserInfo9.getSvip()) != null) {
            i4 = svip2.getSvipLevel();
        } else {
            i4 = 0;
        }
        if (i4 > 0) {
            getBinding().svipMedalTwo.setVisibility(0);
            SvipTypeUtils svipTypeUtils2 = SvipTypeUtils.INSTANCE;
            MyCp cp4 = user.getCp();
            if (cp4 != null && (cpUserInfo8 = cp4.getCpUserInfo()) != null && (svip = cpUserInfo8.getSvip()) != null) {
                num2 = Integer.valueOf(svip.getSvipLevel());
            } else {
                num2 = null;
            }
            Integer svipMedal2 = svipTypeUtils2.getSvipMedal(num2);
            if (svipMedal2 != null) {
                getBinding().svipMedalTwo.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), svipMedal2.intValue()));
                Unit unit4 = Unit.INSTANCE;
            }
        } else {
            getBinding().svipMedalTwo.setVisibility(8);
            Unit unit5 = Unit.INSTANCE;
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
            Unit unit6 = Unit.INSTANCE;
        }
        ImageView imageView3 = getBinding().cpModel;
        RelationTypeUtils relationTypeUtils = RelationTypeUtils.INSTANCE;
        MyCp cp5 = user.getCp();
        if (cp5 != null && (cpLevel = cp5.getCpLevel()) != null) {
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
        imageView3.setBackground(drawable);
        final ImageView imageView4 = getBinding().cpModel;
        final long j2 = 800;
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoCpDialog$initUserView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i17;
                CpLevel cpLevel2;
                Integer level8;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView4) > j2 || (imageView4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView4, currentTimeMillis);
                    MyCp cp6 = user.getCp();
                    if (cp6 != null && (cpLevel2 = cp6.getCpLevel()) != null && (level8 = cpLevel2.getLevel()) != null) {
                        i17 = level8.intValue();
                    } else {
                        i17 = 0;
                    }
                    if (i17 > 0) {
                        CpSpaceActivity.Companion companion4 = CpSpaceActivity.Companion;
                        Context context3 = this.getContext();
                        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                        CpSpaceActivity.Companion.startActivity$default(companion4, context3, user.getExternalId(), null, 0, 12, null);
                    }
                }
            }
        });
        getBinding().countryID.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.qiahao.nextvideo.room.dialog.u4
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean initUserView$lambda$7;
                initUserView$lambda$7 = UserInfoCpDialog.initUserView$lambda$7(user, this, view);
                return initUserView$lambda$7;
            }
        });
        if (user.getHeadwear() != null) {
            HeadWearBean headwear6 = user.getHeadwear();
            if (headwear6 != null) {
                str14 = headwear6.getEffectUrl1();
            } else {
                str14 = null;
            }
            if (str14 != null && str14.length() != 0) {
                z15 = false;
            } else {
                z15 = true;
            }
            if (z15) {
                HeadWearBean headwear7 = user.getHeadwear();
                if (headwear7 != null) {
                    str17 = headwear7.getPicUrl();
                } else {
                    str17 = null;
                }
                if (str17 != null && str17.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    ImageView imageView5 = getBinding().micUserHeadImg;
                    Intrinsics.checkNotNullExpressionValue(imageView5, "micUserHeadImg");
                    HeadWearBean headwear8 = user.getHeadwear();
                    if (headwear8 != null) {
                        str18 = headwear8.getPicUrl();
                    } else {
                        str18 = null;
                    }
                    ViewUtilitiesKt.bind(imageView5, new ImageUIModel(str18, null, null, null, 0, 0, null, 126, null));
                }
                Unit unit7 = Unit.INSTANCE;
            } else {
                HeadWearBean headwear9 = user.getHeadwear();
                if (headwear9 != null) {
                    str15 = headwear9.getEffectUrl1();
                } else {
                    str15 = null;
                }
                if (TextUtils.isEmpty(str15)) {
                    return;
                }
                try {
                    SVGAParser shareParser = SVGAParser.Companion.shareParser();
                    HeadWearBean headwear10 = user.getHeadwear();
                    if (headwear10 != null) {
                        str16 = headwear10.getEffectUrl1();
                    } else {
                        str16 = null;
                    }
                    shareParser.decodeFromURL(new URL(str16 + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoCpDialog$initUserView$8
                        public void onComplete(SVGAVideoEntity videoItem) {
                            String headwearIcon;
                            String str19;
                            Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                            SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                            HeadWearBean headwear11 = user.getHeadwear();
                            if (headwear11 != null && (headwearIcon = headwear11.getHeadwearIcon()) != null && StringKtxKt.isUrl(headwearIcon)) {
                                HeadWearBean headwear12 = user.getHeadwear();
                                if (headwear12 == null || (str19 = headwear12.getHeadwearIcon()) == null) {
                                    str19 = "";
                                }
                                DataExternalKt.setDynamicImageEntity$default(sVGADynamicEntity, str19, null, 2, null);
                            }
                            this.getBinding().micUserHeadSvga.stopAnimation(true);
                            this.getBinding().micUserHeadSvga.setImageDrawable(new SVGADrawable(videoItem, sVGADynamicEntity));
                            this.getBinding().micUserHeadSvga.startAnimation();
                        }

                        public void onError() {
                        }
                    });
                } catch (Exception unused) {
                    Unit unit8 = Unit.INSTANCE;
                }
            }
        }
        if (!TextUtils.isEmpty(user.getCardEffect())) {
            SVGAParser.Companion.shareParser().decodeFromURL(new URL(user.getCardEffect() + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoCpDialog$initUserView$9
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    Drawable sVGADrawable = new SVGADrawable(videoItem, new SVGADynamicEntity());
                    UserInfoCpDialog.this.getBinding().cpSvga.stopAnimation(true);
                    UserInfoCpDialog.this.getBinding().cpSvga.setImageDrawable(sVGADrawable);
                    UserInfoCpDialog.this.getBinding().cpSvga.startAnimation();
                }

                public void onError() {
                }
            });
        }
        MyCp cp6 = user.getCp();
        if (cp6 != null && (cpUserInfo7 = cp6.getCpUserInfo()) != null) {
            headWearBean = cpUserInfo7.getHeadwear();
        } else {
            headWearBean = null;
        }
        if (headWearBean != null) {
            MyCp cp7 = user.getCp();
            if (cp7 != null && (cpUserInfo6 = cp7.getCpUserInfo()) != null && (headwear5 = cpUserInfo6.getHeadwear()) != null) {
                str9 = headwear5.getEffectUrl1();
            } else {
                str9 = null;
            }
            if (str9 != null && str9.length() != 0) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (z13) {
                MyCp cp8 = user.getCp();
                if (cp8 != null && (cpUserInfo5 = cp8.getCpUserInfo()) != null && (headwear4 = cpUserInfo5.getHeadwear()) != null) {
                    str12 = headwear4.getPicUrl();
                } else {
                    str12 = null;
                }
                if (str12 != null && str12.length() != 0) {
                    z14 = false;
                } else {
                    z14 = true;
                }
                if (!z14) {
                    ImageView imageView6 = getBinding().micUserHeadImgTwo;
                    Intrinsics.checkNotNullExpressionValue(imageView6, "micUserHeadImgTwo");
                    MyCp cp9 = user.getCp();
                    if (cp9 != null && (cpUserInfo4 = cp9.getCpUserInfo()) != null && (headwear3 = cpUserInfo4.getHeadwear()) != null) {
                        str13 = headwear3.getPicUrl();
                    } else {
                        str13 = null;
                    }
                    ViewUtilitiesKt.bind(imageView6, new ImageUIModel(str13, null, null, null, 0, 0, null, 126, null));
                }
                Unit unit9 = Unit.INSTANCE;
            } else {
                MyCp cp10 = user.getCp();
                if (cp10 != null && (cpUserInfo3 = cp10.getCpUserInfo()) != null && (headwear2 = cpUserInfo3.getHeadwear()) != null) {
                    str10 = headwear2.getEffectUrl1();
                } else {
                    str10 = null;
                }
                if (TextUtils.isEmpty(str10)) {
                    return;
                }
                try {
                    SVGAParser shareParser2 = SVGAParser.Companion.shareParser();
                    MyCp cp11 = user.getCp();
                    if (cp11 != null && (cpUserInfo2 = cp11.getCpUserInfo()) != null && (headwear = cpUserInfo2.getHeadwear()) != null) {
                        str11 = headwear.getEffectUrl1();
                    } else {
                        str11 = null;
                    }
                    shareParser2.decodeFromURL(new URL(str11 + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoCpDialog$initUserView$10
                        public void onComplete(SVGAVideoEntity videoItem) {
                            User cpUserInfo12;
                            HeadWearBean headwear11;
                            String headwearIcon;
                            String str19;
                            User cpUserInfo13;
                            HeadWearBean headwear12;
                            Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                            SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                            MyCp cp12 = user.getCp();
                            if (cp12 != null && (cpUserInfo12 = cp12.getCpUserInfo()) != null && (headwear11 = cpUserInfo12.getHeadwear()) != null && (headwearIcon = headwear11.getHeadwearIcon()) != null && StringKtxKt.isUrl(headwearIcon)) {
                                MyCp cp13 = user.getCp();
                                if (cp13 == null || (cpUserInfo13 = cp13.getCpUserInfo()) == null || (headwear12 = cpUserInfo13.getHeadwear()) == null || (str19 = headwear12.getHeadwearIcon()) == null) {
                                    str19 = "";
                                }
                                DataExternalKt.setDynamicImageEntity$default(sVGADynamicEntity, str19, null, 2, null);
                            }
                            this.getBinding().micUserHeadSvgaTwo.stopAnimation(true);
                            this.getBinding().micUserHeadSvgaTwo.setImageDrawable(new SVGADrawable(videoItem, sVGADynamicEntity));
                            this.getBinding().micUserHeadSvgaTwo.startAnimation();
                        }

                        public void onError() {
                        }
                    });
                } catch (Exception unused2) {
                    Unit unit10 = Unit.INSTANCE;
                }
            }
        }
        HiloImageView hiloImageView = getBinding().userAvatarTwo;
        MyCp cp12 = user.getCp();
        if (cp12 != null && (cpUserInfo = cp12.getCpUserInfo()) != null) {
            str = cpUserInfo.getAvatar();
        } else {
            str = null;
        }
        String image200 = ImageSizeKt.image200(str);
        String str19 = "";
        if (image200 == null) {
            str2 = "";
        } else {
            str2 = image200;
        }
        HiloImageView.loadImage$default(hiloImageView, str2, 0, 0, 6, (Object) null);
        NickTextView nickTextView = getBinding().userName;
        String nick = user.getNick();
        SvipData svip6 = user.getSvip();
        if (svip6 != null) {
            i5 = svip6.getSvipLevel();
        } else {
            i5 = 0;
        }
        NobleInfo noble5 = user.getNoble();
        if (noble5 != null && (level3 = noble5.getLevel()) != null) {
            i6 = level3.intValue();
        } else {
            i6 = 0;
        }
        nickTextView.setSVipAndNoble(nick, i5, i6);
        CountryIDView countryIDView = getBinding().countryID;
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{user.getCode()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        Integer idFrameType = user.getIdFrameType();
        if (idFrameType != null) {
            i7 = idFrameType.intValue();
        } else {
            i7 = 0;
        }
        int color = androidx.core.content.a.getColor(getContext(), 2131099909);
        Boolean isPrettyCode = user.isPrettyCode();
        if (isPrettyCode != null) {
            z = isPrettyCode.booleanValue();
        } else {
            z = false;
        }
        countryIDView.refreshText(format, i7, color, z);
        HiloImageView hiloImageView2 = getBinding().userAvatar;
        String image2002 = ImageSizeKt.image200(user.getAvatar());
        if (image2002 == null) {
            str3 = "";
        } else {
            str3 = image2002;
        }
        HiloImageView.loadImage$default(hiloImageView2, str3, 0, 0, 6, (Object) null);
        ImageView imageView7 = getBinding().imageViewCountry;
        Intrinsics.checkNotNullExpressionValue(imageView7, "imageViewCountry");
        ViewUtilitiesKt.bind(imageView7, ImageUIModel.INSTANCE.countryTag(user.getCountryIcon()));
        getBinding().countryText.setText(user.getCountry());
        ImageView imageView8 = getBinding().newUser;
        if (user.getCornerMark() == 2) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        imageView8.setVisibility(i8);
        GenderAgeTextView genderAgeTextView = getBinding().ageTextView;
        Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        if (user.getSex() == 1) {
            i9 = R.drawable.icon_boy;
        } else {
            i9 = R.drawable.icon_girl;
        }
        ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, ResourceUtilsKt.getDrawable(resources, i9, 0));
        GenderAgeTextView genderAgeTextView2 = getBinding().ageTextView;
        if (user.getSex() == 1) {
            i10 = R.drawable.bg_age_male;
        } else {
            i10 = R.drawable.bg_age_female;
        }
        genderAgeTextView2.setBackgroundResource(i10);
        AppCompatTextView appCompatTextView = getBinding().ageTextView;
        Integer isShowAge = user.isShowAge();
        if (isShowAge != null) {
            i11 = isShowAge.intValue();
        } else {
            i11 = 1;
        }
        if (i11 != 1) {
            charSequence = "";
        } else {
            charSequence = user.getAge();
        }
        appCompatTextView.setText(charSequence);
        final HiloImageView hiloImageView3 = getBinding().userAvatar;
        final long j3 = 800;
        hiloImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoCpDialog$initUserView$$inlined$singleClick$default$2
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
        HiloGradeView.setLevelBg$default(getBinding().wealthLevel, user.getWealthUserGrade(), false, true, false, 10, (Object) null);
        HiloGradeView.setLevelBg$default(getBinding().charmLevel, user.getCharmUserGrade(), true, false, false, 12, (Object) null);
        HiloGradeView.setLevelBg$default(getBinding().activityLevel, user.getActivityUserGrade(), false, false, true, 6, (Object) null);
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
                getBinding().familyNamePlate.getRoot().setVisibility(0);
                IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding = getBinding().familyNamePlate;
                Intrinsics.checkNotNullExpressionValue(includeFamilyNamePlateBinding, "familyNamePlate");
                FamilyInfo groupPower3 = user.getGroupPower();
                if (groupPower3 != null && (grade = groupPower3.getGrade()) != null) {
                    i13 = grade.intValue();
                } else {
                    i13 = -1;
                }
                FamilyInfo groupPower4 = user.getGroupPower();
                if (groupPower4 == null || (nameplate = groupPower4.getNameplate()) == null) {
                    str8 = "";
                } else {
                    str8 = nameplate;
                }
                AppUtilitiesKt.familyNamePlate$default(includeFamilyNamePlateBinding, i13, str8, 0, 4, (Object) null);
                if (user.getGameLevel() != null) {
                    MyGameLevel gameLevel = user.getGameLevel();
                    if (gameLevel != null && (level2 = gameLevel.getLevel()) != null && level2.intValue() == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z11) {
                        getBinding().gameLevel.getRoot().setVisibility(0);
                        IncludeGameLevelBinding includeGameLevelBinding = getBinding().gameLevel;
                        Intrinsics.checkNotNullExpressionValue(includeGameLevelBinding, "gameLevel");
                        MyGameLevel gameLevel2 = user.getGameLevel();
                        if (gameLevel2 != null && (level = gameLevel2.getLevel()) != null) {
                            i12 = level.intValue();
                        } else {
                            i12 = -1;
                        }
                        MyGameLevel gameLevel3 = user.getGameLevel();
                        if (gameLevel3 == null || (title = gameLevel3.getTitle()) == null) {
                            str7 = "";
                        } else {
                            str7 = title;
                        }
                        AppUtilitiesKt.gameLevelBinding$default(includeGameLevelBinding, i12, str7, 0, 4, (Object) null);
                        if (isMyself) {
                            getBinding().llUserOperator.setVisibility(8);
                            getBinding().reportImageView.setVisibility(8);
                            getBinding().micMute.setVisibility(8);
                        } else {
                            getBinding().micMute.setVisibility(0);
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
                                str5 = user10.getExternalId();
                            } else {
                                str5 = null;
                            }
                            User user11 = this.mUser;
                            if (user11 != null) {
                                str6 = user11.getExternalId();
                            } else {
                                str6 = null;
                            }
                            if (!Intrinsics.areEqual(str5, str6)) {
                                getBinding().micMute.setVisibility(0);
                                user3 = this.mUser;
                                if (user3 != null && (externalId = user3.getExternalId()) != null) {
                                    str19 = externalId;
                                }
                                if (!meetingRoomManager.haveLocalMute(str19)) {
                                    getBinding().micMute.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.person_mic_off));
                                } else {
                                    getBinding().micMute.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.person_mic_on));
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
                                        getBinding().llUserMicroRoomOperator.setVisibility(0);
                                        updateNobleBgViewMarginBottom(true);
                                        getBinding().imageUserInfo.setVisibility(8);
                                        getBinding().imageUserMuteOpenMic.setVisibility(0);
                                        getBinding().imageUserDownMic.setVisibility(0);
                                        getBinding().imageUserLeaveRoom.setVisibility(8);
                                    } else {
                                        int i17 = this.mMyUserRole;
                                        if (i17 != 1) {
                                            if (i17 != 10) {
                                                if (i17 != 50 && i17 != 100 && i17 != 1000) {
                                                    User user12 = this.mUser;
                                                    if (user12 != null) {
                                                        z10 = Intrinsics.areEqual(user12.getHasGroupCountryManagerPower(), Boolean.TRUE);
                                                    } else {
                                                        z10 = false;
                                                    }
                                                    if (z10) {
                                                        getBinding().llUserMicroRoomOperator.setVisibility(0);
                                                        updateNobleBgViewMarginBottom(true);
                                                        getBinding().imageUserInfo.setVisibility(8);
                                                        getBinding().imageUserDownMic.setVisibility(0);
                                                        getBinding().imageUserLeaveRoom.setVisibility(0);
                                                    }
                                                    Unit unit11 = Unit.INSTANCE;
                                                } else {
                                                    getBinding().llUserMicroRoomOperator.setVisibility(0);
                                                    updateNobleBgViewMarginBottom(true);
                                                    getBinding().imageUserInfo.setVisibility(0);
                                                    getBinding().imageUserMuteOpenMic.setVisibility(0);
                                                    getBinding().imageUserDownMic.setVisibility(0);
                                                    getBinding().imageUserLeaveRoom.setVisibility(0);
                                                    Unit unit12 = Unit.INSTANCE;
                                                }
                                            } else {
                                                getBinding().llUserMicroRoomOperator.setVisibility(0);
                                                updateNobleBgViewMarginBottom(true);
                                                getBinding().imageUserInfo.setVisibility(8);
                                                getBinding().imageUserMuteOpenMic.setVisibility(0);
                                                getBinding().imageUserDownMic.setVisibility(0);
                                                getBinding().imageUserLeaveRoom.setVisibility(0);
                                                Unit unit13 = Unit.INSTANCE;
                                            }
                                        } else {
                                            User user13 = this.mUser;
                                            if (user13 != null) {
                                                z9 = Intrinsics.areEqual(user13.getHasGroupCountryManagerPower(), Boolean.TRUE);
                                            } else {
                                                z9 = false;
                                            }
                                            if (z9) {
                                                getBinding().llUserMicroRoomOperator.setVisibility(0);
                                                updateNobleBgViewMarginBottom(true);
                                                getBinding().imageUserInfo.setVisibility(8);
                                                getBinding().imageUserDownMic.setVisibility(0);
                                                getBinding().imageUserLeaveRoom.setVisibility(0);
                                            } else {
                                                getBinding().llUserMicroRoomOperator.setVisibility(8);
                                                updateNobleBgViewMarginBottom(false);
                                            }
                                            Unit unit14 = Unit.INSTANCE;
                                        }
                                    }
                                    getBinding().imageInviteUserUpMic.setVisibility(8);
                                } else {
                                    getBinding().imageUserMuteOpenMic.setVisibility(8);
                                    getBinding().imageUserDownMic.setVisibility(8);
                                    if (isMyself) {
                                        getBinding().llUserMicroRoomOperator.setVisibility(8);
                                        updateNobleBgViewMarginBottom(false);
                                    } else {
                                        int i18 = this.mMyUserRole;
                                        if (i18 != 1) {
                                            if (i18 != 10) {
                                                if (i18 != 50 && i18 != 100 && i18 != 1000) {
                                                    User user14 = this.mUser;
                                                    if (user14 != null) {
                                                        z7 = Intrinsics.areEqual(user14.getHasGroupCountryManagerPower(), Boolean.TRUE);
                                                    } else {
                                                        z7 = false;
                                                    }
                                                    if (z7) {
                                                        getBinding().llUserMicroRoomOperator.setVisibility(0);
                                                        updateNobleBgViewMarginBottom(true);
                                                        getBinding().imageUserLeaveRoom.setVisibility(0);
                                                        getBinding().imageUserInfo.setVisibility(8);
                                                        getBinding().imageInviteUserUpMic.setVisibility(8);
                                                    }
                                                    Unit unit15 = Unit.INSTANCE;
                                                } else {
                                                    getBinding().llUserMicroRoomOperator.setVisibility(0);
                                                    updateNobleBgViewMarginBottom(true);
                                                    getBinding().imageUserInfo.setVisibility(0);
                                                    getBinding().imageUserLeaveRoom.setVisibility(0);
                                                    if (this.mRoomHasMicOn) {
                                                        if (meetingRoomManager.checkUserOnMic(user.getExternalId())) {
                                                            getBinding().imageInviteUserUpMic.setVisibility(8);
                                                        } else {
                                                            getBinding().imageInviteUserUpMic.setVisibility(0);
                                                        }
                                                    } else {
                                                        getBinding().imageInviteUserUpMic.setVisibility(8);
                                                    }
                                                    Unit unit16 = Unit.INSTANCE;
                                                }
                                            } else {
                                                getBinding().llUserMicroRoomOperator.setVisibility(0);
                                                updateNobleBgViewMarginBottom(true);
                                                getBinding().imageUserLeaveRoom.setVisibility(0);
                                                getBinding().imageUserInfo.setVisibility(8);
                                                if (this.mRoomHasMicOn) {
                                                    if (meetingRoomManager.checkUserOnMic(user.getExternalId())) {
                                                        getBinding().imageInviteUserUpMic.setVisibility(8);
                                                    } else {
                                                        getBinding().imageInviteUserUpMic.setVisibility(0);
                                                    }
                                                } else {
                                                    getBinding().imageInviteUserUpMic.setVisibility(8);
                                                }
                                                Unit unit17 = Unit.INSTANCE;
                                            }
                                        } else {
                                            User user15 = this.mUser;
                                            if (user15 != null) {
                                                z6 = Intrinsics.areEqual(user15.getHasGroupCountryManagerPower(), Boolean.TRUE);
                                            } else {
                                                z6 = false;
                                            }
                                            if (z6) {
                                                getBinding().llUserMicroRoomOperator.setVisibility(0);
                                                updateNobleBgViewMarginBottom(true);
                                                getBinding().imageUserLeaveRoom.setVisibility(0);
                                                getBinding().imageUserInfo.setVisibility(8);
                                                getBinding().imageInviteUserUpMic.setVisibility(8);
                                            } else {
                                                getBinding().llUserMicroRoomOperator.setVisibility(8);
                                                updateNobleBgViewMarginBottom(false);
                                            }
                                            Unit unit18 = Unit.INSTANCE;
                                        }
                                    }
                                }
                                getBinding().rootBg.setVisibility(0);
                            }
                        }
                        getBinding().micMute.setVisibility(8);
                        user3 = this.mUser;
                        if (user3 != null) {
                            str19 = externalId;
                        }
                        if (!meetingRoomManager.haveLocalMute(str19)) {
                        }
                        if (this.mMicPosition <= 0) {
                        }
                        getBinding().rootBg.setVisibility(0);
                    }
                }
                getBinding().gameLevel.getRoot().setVisibility(8);
                if (isMyself) {
                }
                meetingRoomManager = MeetingRoomManager.INSTANCE;
                user2 = this.mUser;
                if (user2 != null) {
                }
                if (meetingRoomManager.checkUserOnMic(str4)) {
                }
                getBinding().micMute.setVisibility(8);
                user3 = this.mUser;
                if (user3 != null) {
                }
                if (!meetingRoomManager.haveLocalMute(str19)) {
                }
                if (this.mMicPosition <= 0) {
                }
                getBinding().rootBg.setVisibility(0);
            }
        }
        getBinding().familyNamePlate.getRoot().setVisibility(8);
        if (user.getGameLevel() != null) {
        }
        getBinding().gameLevel.getRoot().setVisibility(8);
        if (isMyself) {
        }
        meetingRoomManager = MeetingRoomManager.INSTANCE;
        user2 = this.mUser;
        if (user2 != null) {
        }
        if (meetingRoomManager.checkUserOnMic(str4)) {
        }
        getBinding().micMute.setVisibility(8);
        user3 = this.mUser;
        if (user3 != null) {
        }
        if (!meetingRoomManager.haveLocalMute(str19)) {
        }
        if (this.mMicPosition <= 0) {
        }
        getBinding().rootBg.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean initUserView$lambda$7(User user, UserInfoCpDialog userInfoCpDialog, View view) {
        Toast normal$default;
        if (StringKtxKt.copyToClipboard(user.getCode()) && (normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, userInfoCpDialog.getContext(), ResourcesKtxKt.getStringById(userInfoCpDialog, 2131952379), false, 4, (Object) null)) != null) {
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
            getBinding().imageUserMuteOpenMic.setVisibility(8);
        } else {
            getBinding().imageUserMuteOpenMic.setVisibility(0);
        }
        User user = this.mUser;
        if (user != null) {
            z = Intrinsics.areEqual(user.getHasGroupCountryManagerPower(), Boolean.TRUE);
        }
        if (z && !this.mIsMyself && isMute) {
            getBinding().imageUserMuteOpenMic.setVisibility(8);
        }
        ImageView imageView = getBinding().imageUserMuteOpenMic;
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
            SVGAParser.Companion.shareParser().decodeFromAssets(svgaUrl, new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoCpDialog$playSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    Drawable sVGADrawable = new SVGADrawable(videoItem, new SVGADynamicEntity());
                    UserInfoCpDialog.this.getBinding().countrySVGA.setVisibility(0);
                    UserInfoCpDialog.this.getBinding().countrySVGA.stopAnimation(true);
                    UserInfoCpDialog.this.getBinding().countrySVGA.setImageDrawable(sVGADrawable);
                    UserInfoCpDialog.this.getBinding().countrySVGA.startAnimation();
                }

                public void onError() {
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportCurrentUser() {
        new ReportWhiteDialog(this.mCurrentContext).setListener(new UserInfoCpDialog$reportCurrentUser$1(this)).show();
    }

    private final void showBlockOrReport() {
        BlockOrReportDialog blockOrReportDialog = new BlockOrReportDialog(this.mCurrentContext, BlockOrReportDialog.Companion.getTextList$default(BlockOrReportDialog.INSTANCE, BlockOrReportDialog.REPORT_AND_BLOCK, false, false, false, 14, null));
        blockOrReportDialog.setMListener(new SelectInterface() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoCpDialog$showBlockOrReport$1$1
            /* JADX WARN: Type inference failed for: r5v2, types: [android.app.Dialog, com.qiahao.nextvideo.ui.base.BlockTextDialog] */
            public void onSelect(int index) {
                Context context;
                if (index == 0) {
                    UserInfoCpDialog.this.reportCurrentUser();
                    return;
                }
                if (index == 1) {
                    context = UserInfoCpDialog.this.mCurrentContext;
                    ?? blockTextDialog = new BlockTextDialog(context);
                    UserInfoCpDialog userInfoCpDialog = UserInfoCpDialog.this;
                    String string = blockTextDialog.getMContext().getString(2131952131);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    blockTextDialog.setContentText(string, true, userInfoCpDialog);
                    blockTextDialog.show();
                }
            }
        });
        blockOrReportDialog.show();
    }

    private final void showLikeImageView(int like) {
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
        getBinding().imageLike.setImageDrawable(this.mCurrentContext.getResources().getDrawable(i));
    }

    private final void toVideoCurrent() {
        User user = this.mUser;
        if (user != null) {
            VideoCallMessage.INSTANCE.newStartVideo(this.mCurrentContext, user.getExternalId(), new Function2() { // from class: com.qiahao.nextvideo.room.dialog.a5
                public final Object invoke(Object obj, Object obj2) {
                    Unit videoCurrent$lambda$21$lambda$19;
                    videoCurrent$lambda$21$lambda$19 = UserInfoCpDialog.toVideoCurrent$lambda$21$lambda$19(UserInfoCpDialog.this, (String) obj, ((Boolean) obj2).booleanValue());
                    return videoCurrent$lambda$21$lambda$19;
                }
            }, new Function0() { // from class: com.qiahao.nextvideo.room.dialog.b5
                public final Object invoke() {
                    Unit videoCurrent$lambda$21$lambda$20;
                    videoCurrent$lambda$21$lambda$20 = UserInfoCpDialog.toVideoCurrent$lambda$21$lambda$20(UserInfoCpDialog.this);
                    return videoCurrent$lambda$21$lambda$20;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toVideoCurrent$lambda$21$lambda$19(UserInfoCpDialog userInfoCpDialog, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        userInfoCpDialog.confirmLike();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toVideoCurrent$lambda$21$lambda$20(UserInfoCpDialog userInfoCpDialog) {
        userInfoCpDialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void updateNobleBgViewMarginBottom(boolean isMarginBottom) {
        ConstraintLayout.b layoutParams = getBinding().nobleBg.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = layoutParams;
        if (isMarginBottom) {
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = Dimens.INSTANCE.dpToPx(47);
        } else {
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = 0;
        }
        getBinding().nobleBg.setLayoutParams(bVar);
    }

    private final void userMedalShow(User user) {
        List medals = user.getMedals();
        if (medals != null && !medals.isEmpty()) {
            getBinding().llMeadl.cleanAllMedal();
            getBinding().llMeadl.setMaxSize(15);
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
                        getBinding().llMeadl.addMedal(medalBean.getPicUrl());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void userRoomTagShow() {
        if (this.mUserRole > 1) {
            getBinding().userTagView.setVisibility(0);
            getBinding().imageUserTag.setVisibility(0);
            getBinding().userTagText.setVisibility(0);
            TextView textView = getBinding().userTagText;
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            textView.setText(meetingRoomManager.getLevelString(this.mUserRole));
            getBinding().imageUserTag.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), meetingRoomManager.getLevelRes(this.mUserRole)));
            return;
        }
        getBinding().userTagView.setVisibility(8);
        getBinding().imageUserTag.setVisibility(8);
        getBinding().userTagText.setVisibility(8);
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
        io.reactivex.rxjava3.core.i0 j = shared.blockUser(str).j(new pd.o() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoCpDialog$blockTextDialogConfirm$1
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                apply((ApiResponse<Object>) obj);
                return Unit.INSTANCE;
            }

            public final void apply(ApiResponse<Object> apiResponse) {
                Intrinsics.checkNotNullParameter(apiResponse, "it");
                V2TIMConversationManager conversationManager = V2TIMManager.getConversationManager();
                User mUser = UserInfoCpDialog.this.getMUser();
                conversationManager.deleteConversation(mUser != null ? mUser.getExternalId() : null, new V2TIMCallback() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoCpDialog$blockTextDialogConfirm$1.1
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
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(j, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.v4
            public final Object invoke(Object obj) {
                Unit blockTextDialogConfirm$lambda$23;
                blockTextDialogConfirm$lambda$23 = UserInfoCpDialog.blockTextDialogConfirm$lambda$23(UserInfoCpDialog.this, (Unit) obj);
                return blockTextDialogConfirm$lambda$23;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.w4
            public final Object invoke(Object obj) {
                Unit blockTextDialogConfirm$lambda$24;
                blockTextDialogConfirm$lambda$24 = UserInfoCpDialog.blockTextDialogConfirm$lambda$24(UserInfoCpDialog.this, (Throwable) obj);
                return blockTextDialogConfirm$lambda$24;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.room.dialog.x4
            public final Object invoke() {
                Unit blockTextDialogConfirm$lambda$25;
                blockTextDialogConfirm$lambda$25 = UserInfoCpDialog.blockTextDialogConfirm$lambda$25(UserInfoCpDialog.this);
                return blockTextDialogConfirm$lambda$25;
            }
        }, false, 8, (Object) null), this.mCompositeDisposable);
    }

    public void dismiss() {
        super.dismiss();
        CoroutineScopeKt.cancel$default(this.dialogScope, (CancellationException) null, 1, (Object) null);
        this.mUserInfoListener = null;
        this.mCompositeDisposable.d();
    }

    @NotNull
    public final DialogRoomCpUserInfoBinding getBinding() {
        DialogRoomCpUserInfoBinding dialogRoomCpUserInfoBinding = this.binding;
        if (dialogRoomCpUserInfoBinding != null) {
            return dialogRoomCpUserInfoBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
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

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    public final boolean getMIsMyself() {
        return this.mIsMyself;
    }

    @NotNull
    public final ArrayList<MedalBean> getMMedalList() {
        return this.mMedalList;
    }

    public final int getMMicPosition() {
        return this.mMicPosition;
    }

    public final int getMMyUserRole() {
        return this.mMyUserRole;
    }

    public final boolean getMRoomHasMicOn() {
        return this.mRoomHasMicOn;
    }

    @Nullable
    public final User getMUser() {
        return this.mUser;
    }

    @Nullable
    public final UserInfoListener getMUserInfoListener() {
        return this.mUserInfoListener;
    }

    public final int getMUserRole() {
        return this.mUserRole;
    }

    /* renamed from: isRequest, reason: from getter */
    public final boolean getIsRequest() {
        return this.isRequest;
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
                    getBinding().micMute.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.person_mic_on));
                } else {
                    ArrayList<String> localMuteList = meetingRoomManager.getLocalMuteList();
                    User user11 = this.mUser;
                    if (user11 != null && (externalId3 = user11.getExternalId()) != null) {
                        str6 = externalId3;
                    }
                    localMuteList.add(str6);
                    getBinding().micMute.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.person_mic_off));
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

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding((DialogRoomCpUserInfoBinding) androidx.databinding.g.h(LayoutInflater.from(this.mCurrentContext), R.layout.dialog_room_cp_user_info, (ViewGroup) null, false));
        setContentView(getBinding().getRoot());
        getBinding().setClick(this);
        BuildersKt.launch$default(this.dialogScope, Dispatchers.getMain(), (CoroutineStart) null, new UserInfoCpDialog$onCreate$1(this, null), 2, (Object) null);
        getData();
        initStyle();
    }

    public final void setBinding(@NotNull DialogRoomCpUserInfoBinding dialogRoomCpUserInfoBinding) {
        Intrinsics.checkNotNullParameter(dialogRoomCpUserInfoBinding, "<set-?>");
        this.binding = dialogRoomCpUserInfoBinding;
    }

    public final void setMGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGroupId = str;
    }

    public final void setMIsMyself(boolean z) {
        this.mIsMyself = z;
    }

    public final void setMMedalList(@NotNull ArrayList<MedalBean> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mMedalList = arrayList;
    }

    public final void setMMicPosition(int i) {
        this.mMicPosition = i;
    }

    public final void setMMyUserRole(int i) {
        this.mMyUserRole = i;
    }

    public final void setMRoomHasMicOn(boolean z) {
        this.mRoomHasMicOn = z;
    }

    public final void setMUser(@Nullable User user) {
        this.mUser = user;
    }

    public final void setMUserInfoListener(@Nullable UserInfoListener userInfoListener) {
        this.mUserInfoListener = userInfoListener;
    }

    public final void setMUserRole(int i) {
        this.mUserRole = i;
    }

    public final void setRequest(boolean z) {
        this.isRequest = z;
    }

    public final void setUserInfoListener(@NotNull UserInfoListener userInfoListener) {
        Intrinsics.checkNotNullParameter(userInfoListener, "userInfoListener");
        this.mUserInfoListener = userInfoListener;
    }
}
