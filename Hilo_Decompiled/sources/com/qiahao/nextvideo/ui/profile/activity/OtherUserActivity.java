package com.qiahao.nextvideo.ui.profile.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.Checkable;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import com.oudi.core.loading.ILoading;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.model.common.CheckSessionBean;
import com.qiahao.base_common.model.common.LikeResult;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.VideoEvent;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.model.svip.SvipInfo;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.permission.PermissionInterceptor;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.ui.loading.HiloLoadingDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.DialogItemData;
import com.qiahao.nextvideo.data.model.IsBroadCastMangerBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ActivityUserDetailBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.ui.balloon.LikeEachOtherBalloon;
import com.qiahao.nextvideo.ui.balloon.LikeEachOtherBalloonDelegate;
import com.qiahao.nextvideo.ui.base.BlockOrReportDialog;
import com.qiahao.nextvideo.ui.home.chat.activity.ChatActivity;
import com.qiahao.nextvideo.ui.svip.SvipPrivilegesActivity;
import com.qiahao.nextvideo.ui.videocall.VideoCallMessage;
import com.qiahao.nextvideo.ui.vip.VipViewDialog;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\u0005H\u0003J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/activity/OtherUserActivity;", "Lcom/qiahao/nextvideo/ui/profile/activity/BaseUserDetailActivity;", "<init>", "()V", "onInitialize", "", "onVideoEvent", "event", "Lcom/qiahao/base_common/model/eventBus/VideoEvent;", "showLikedStatus", "reportImageViewPressed", "likedImageViewPressed", "chatImageViewPressed", "svipUnBlock", "svipPrivileges", "privilegesId", "", "videoCallButtonPressed", "checkVideoPermission", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOtherUserActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OtherUserActivity.kt\ncom/qiahao/nextvideo/ui/profile/activity/OtherUserActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 LikeEachOtherBalloon.kt\ncom/qiahao/nextvideo/ui/balloon/LikeEachOtherBalloonKt\n*L\n1#1,659:1\n61#2,9:660\n61#2,9:669\n35#3:678\n*S KotlinDebug\n*F\n+ 1 OtherUserActivity.kt\ncom/qiahao/nextvideo/ui/profile/activity/OtherUserActivity\n*L\n99#1:660,9\n113#1:669,9\n144#1:678\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class OtherUserActivity extends BaseUserDetailActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/activity/OtherUserActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "user", "Lcom/qiahao/base_common/model/common/User;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, @NotNull User user) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(user, "user");
            Intent intent = new Intent(context, (Class<?>) OtherUserActivity.class);
            intent.putExtra("user", (Parcelable) user);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit chatImageViewPressed$lambda$11(OtherUserActivity otherUserActivity, ApiResponse apiResponse) {
        Integer num;
        String str;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        CheckSessionBean checkSessionBean = (CheckSessionBean) apiResponse.getData();
        if (checkSessionBean != null) {
            num = Integer.valueOf(checkSessionBean.getCanTalk());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
            User uiModel = otherUserActivity.getUiModel();
            if (uiModel == null || (str = uiModel.getExternalId()) == null) {
                str = "";
            }
            appRequestUtils.openChatActivity(str);
        } else if (num != null && num.intValue() == 2) {
            new TipDialog(otherUserActivity).setTipContent(ResourcesKtxKt.getStringById(otherUserActivity, 2131953227)).setConfirmContent(ResourcesKtxKt.getStringById(otherUserActivity, 2131953219)).setDialogListener(new OtherUserActivity$chatImageViewPressed$1$1(otherUserActivity)).show();
        } else if (num != null && num.intValue() == 3) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String string = otherUserActivity.getString(2131953227);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast normal$default = HiloToasty.Companion.normal$default(companion, otherUserActivity, string, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        } else if (num != null && num.intValue() == 5) {
            HiloToasty.Companion companion2 = HiloToasty.Companion;
            String string2 = otherUserActivity.getString(2131954530);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            Toast normal$default2 = HiloToasty.Companion.normal$default(companion2, otherUserActivity, string2, false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit chatImageViewPressed$lambda$12(OtherUserActivity otherUserActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = otherUserActivity.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(localizedMessage, "getString(...)");
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, otherUserActivity, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit chatImageViewPressed$lambda$13(HiloLoadingDialog hiloLoadingDialog) {
        hiloLoadingDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean checkVideoPermission() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(fa.b.f());
        arrayList.add(fa.b.o());
        boolean n = w9.h.n(this, arrayList);
        if (!n) {
            w9.h.t(this).q(arrayList).j(new PermissionInterceptor()).r(new w9.c() { // from class: com.qiahao.nextvideo.ui.profile.activity.z
                public final void onResult(List list, List list2) {
                    OtherUserActivity.checkVideoPermission$lambda$20(OtherUserActivity.this, list, list2);
                }
            });
        }
        return n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkVideoPermission$lambda$20(OtherUserActivity otherUserActivity, List list, List list2) {
        Intrinsics.checkNotNullParameter(list, "grantedList");
        Intrinsics.checkNotNullParameter(list2, "deniedList");
        if (list2.isEmpty()) {
            otherUserActivity.videoCallButtonPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit likedImageViewPressed$lambda$10(OtherUserActivity otherUserActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            int code = hiloException.getCode();
            if (code != 9004) {
                if (code != 9005) {
                    HiloToasty.Companion companion = HiloToasty.Companion;
                    String localizedMessage = hiloException.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = ResourcesKtxKt.getStringById(otherUserActivity, 2131952667);
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(companion, otherUserActivity, localizedMessage, false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                } else {
                    Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, otherUserActivity, ResourcesKtxKt.getStringById(otherUserActivity, 2131953231), false, 4, (Object) null);
                    if (normal$default2 != null) {
                        normal$default2.show();
                    }
                }
            } else {
                new VipViewDialog(5, otherUserActivity).show();
            }
        } else {
            HiloToasty.Companion companion2 = HiloToasty.Companion;
            String localizedMessage2 = th.getLocalizedMessage();
            if (localizedMessage2 == null) {
                localizedMessage2 = ResourcesKtxKt.getStringById(otherUserActivity, 2131952667);
            }
            Toast normal$default3 = HiloToasty.Companion.normal$default(companion2, otherUserActivity, localizedMessage2, false, 4, (Object) null);
            if (normal$default3 != null) {
                normal$default3.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit likedImageViewPressed$lambda$9(OtherUserActivity otherUserActivity, ApiResponse apiResponse) {
        Boolean bool;
        Boolean bool2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        User uiModel = otherUserActivity.getUiModel();
        if (uiModel != null) {
            LikeResult likeResult = (LikeResult) apiResponse.getData();
            if (likeResult != null) {
                bool2 = Boolean.valueOf(likeResult.getStatus());
            } else {
                bool2 = Boolean.FALSE;
            }
            uiModel.setLike(bool2);
        }
        User uiModel2 = otherUserActivity.getUiModel();
        if (uiModel2 != null) {
            LikeResult likeResult2 = (LikeResult) apiResponse.getData();
            if (likeResult2 != null) {
                bool = Boolean.valueOf(likeResult2.isLikeEach());
            } else {
                bool = Boolean.FALSE;
            }
            uiModel2.setLikeMe(bool);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onVideoEvent$lambda$4(final OtherUserActivity otherUserActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (otherUserActivity.isFinishing()) {
            return Unit.INSTANCE;
        }
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null) {
            return Unit.INSTANCE;
        }
        LikeEachOtherBalloon.Builder builder = new LikeEachOtherBalloon.Builder(otherUserActivity);
        User user2 = (User) apiResponse.getData();
        if (user2 != null) {
            builder.setRemoteUser(user2);
        }
        builder.setLocalUser(user);
        builder.setDelegate(new LikeEachOtherBalloonDelegate() { // from class: com.qiahao.nextvideo.ui.profile.activity.OtherUserActivity$onVideoEvent$1$1$2
            @Override // com.qiahao.nextvideo.ui.balloon.LikeEachOtherBalloonDelegate
            public void likeEachClick(User remoteUser) {
                if (!OtherUserActivity.this.isFinishing() && remoteUser != null) {
                    ChatActivity.Companion.start$default(ChatActivity.INSTANCE, OtherUserActivity.this, remoteUser, false, 4, null);
                }
            }
        });
        builder.build().show(otherUserActivity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onVideoEvent$lambda$5(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit reportImageViewPressed$lambda$8(OtherUserActivity otherUserActivity, ApiResponse apiResponse) {
        boolean z;
        boolean z2;
        ArrayList<DialogItemData> textList;
        int i;
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(apiResponse, "data");
        IsBroadCastMangerBean isBroadCastMangerBean = (IsBroadCastMangerBean) apiResponse.getData();
        boolean z5 = false;
        if (isBroadCastMangerBean != null && isBroadCastMangerBean.isManager()) {
            BlockOrReportDialog.Companion companion = BlockOrReportDialog.INSTANCE;
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null && user.isOfficialStaff()) {
                z3 = true;
            } else {
                z3 = false;
            }
            IsBroadCastMangerBean isBroadCastMangerBean2 = (IsBroadCastMangerBean) apiResponse.getData();
            if (isBroadCastMangerBean2 != null && isBroadCastMangerBean2.checkPermission(5)) {
                z4 = true;
            } else {
                z4 = false;
            }
            IsBroadCastMangerBean isBroadCastMangerBean3 = (IsBroadCastMangerBean) apiResponse.getData();
            if (isBroadCastMangerBean3 != null && isBroadCastMangerBean3.checkPermission(4)) {
                z5 = true;
            }
            textList = companion.getTextList(BlockOrReportDialog.REPORT_USER, z3, z4, z5);
        } else {
            BlockOrReportDialog.Companion companion2 = BlockOrReportDialog.INSTANCE;
            User user2 = UserStore.INSTANCE.getShared().getUser();
            if (user2 != null && user2.isOfficialStaff()) {
                z = true;
            } else {
                z = false;
            }
            IsBroadCastMangerBean isBroadCastMangerBean4 = (IsBroadCastMangerBean) apiResponse.getData();
            if (isBroadCastMangerBean4 != null && isBroadCastMangerBean4.checkPermission(5)) {
                z2 = true;
            } else {
                z2 = false;
            }
            IsBroadCastMangerBean isBroadCastMangerBean5 = (IsBroadCastMangerBean) apiResponse.getData();
            if (isBroadCastMangerBean5 != null && isBroadCastMangerBean5.checkPermission(4)) {
                z5 = true;
            }
            textList = companion2.getTextList(BlockOrReportDialog.REPORT_AND_BLOCK, z, z2, z5);
        }
        User user3 = UserStore.INSTANCE.getShared().getUser();
        if (user3 != null && user3.isOfficialStaff()) {
            User uiModel = otherUserActivity.getUiModel();
            if (uiModel != null && uiModel.getNotRecommend() == 0) {
                i = 2131953554;
            } else {
                i = 2131953861;
            }
            textList.add(new DialogItemData(ResourcesKtxKt.getStringById(textList, i), 101));
        }
        BlockOrReportDialog blockOrReportDialog = new BlockOrReportDialog(otherUserActivity, textList);
        blockOrReportDialog.setMListener(new OtherUserActivity$reportImageViewPressed$1$2$1(otherUserActivity, blockOrReportDialog, apiResponse));
        blockOrReportDialog.show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void showLikedStatus() {
        boolean z;
        boolean z2;
        int i;
        boolean z3;
        AppCompatImageView appCompatImageView = ((ActivityUserDetailBinding) getBinding()).likedImageButton;
        User uiModel = getUiModel();
        boolean z4 = false;
        if (uiModel != null) {
            z = Intrinsics.areEqual(uiModel.isLike(), Boolean.TRUE);
        } else {
            z = false;
        }
        appCompatImageView.setSelected(z);
        AppCompatImageView appCompatImageView2 = ((ActivityUserDetailBinding) getBinding()).likedImageButton;
        User uiModel2 = getUiModel();
        if (uiModel2 != null) {
            z2 = Intrinsics.areEqual(uiModel2.isLikeMe(), Boolean.TRUE);
        } else {
            z2 = false;
        }
        if (z2) {
            User uiModel3 = getUiModel();
            if (uiModel3 != null) {
                z3 = Intrinsics.areEqual(uiModel3.isLike(), Boolean.TRUE);
            } else {
                z3 = false;
            }
            if (z3) {
                i = R.drawable.ic_info_like_each;
                appCompatImageView2.setImageDrawable(getDrawable(i));
            }
        }
        User uiModel4 = getUiModel();
        if (uiModel4 != null) {
            z4 = Intrinsics.areEqual(uiModel4.isLike(), Boolean.TRUE);
        }
        if (z4) {
            i = R.drawable.ic_info_liked;
        } else {
            i = R.drawable.ic_info_unlike;
        }
        appCompatImageView2.setImageDrawable(getDrawable(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit svipPrivileges$lambda$17(OtherUserActivity otherUserActivity, int i, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        SvipInfo svipInfo = (SvipInfo) apiResponse.getData();
        if (svipInfo != null) {
            Intent intent = new Intent((Context) otherUserActivity, (Class<?>) SvipPrivilegesActivity.class);
            intent.putExtra("data", BaseApplication.Companion.getGSON().s(svipInfo));
            intent.putExtra("type", i);
            otherUserActivity.startActivity(intent);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit svipPrivileges$lambda$18(OtherUserActivity otherUserActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(otherUserActivity);
        if (activity != null) {
            ILoading.DefaultImpls.dismissLoading$default(activity, (Integer) null, 1, (Object) null);
        }
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(otherUserActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, otherUserActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit svipUnBlock$lambda$14(OtherUserActivity otherUserActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, otherUserActivity, ResourcesKtxKt.getStringById(otherUserActivity, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit svipUnBlock$lambda$15(OtherUserActivity otherUserActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(otherUserActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, otherUserActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void videoCallButtonPressed() {
        String str;
        VideoCallMessage videoCallMessage = VideoCallMessage.INSTANCE;
        User uiModel = getUiModel();
        if (uiModel == null || (str = uiModel.getExternalId()) == null) {
            str = "";
        }
        VideoCallMessage.newStartVideo$default(videoCallMessage, this, str, new Function2() { // from class: com.qiahao.nextvideo.ui.profile.activity.v
            public final Object invoke(Object obj, Object obj2) {
                Unit videoCallButtonPressed$lambda$19;
                videoCallButtonPressed$lambda$19 = OtherUserActivity.videoCallButtonPressed$lambda$19(OtherUserActivity.this, (String) obj, ((Boolean) obj2).booleanValue());
                return videoCallButtonPressed$lambda$19;
            }
        }, null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit videoCallButtonPressed$lambda$19(OtherUserActivity otherUserActivity, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        otherUserActivity.likedImageViewPressed();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.ui.profile.activity.BaseUserDetailActivity
    public void chatImageViewPressed() {
        String str;
        super.chatImageViewPressed();
        final HiloLoadingDialog hiloLoadingDialog = new HiloLoadingDialog(this, false, 2, (DefaultConstructorMarker) null);
        hiloLoadingDialog.show();
        UserService shared = UserService.INSTANCE.getShared();
        User uiModel = getUiModel();
        if (uiModel == null || (str = uiModel.getExternalId()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.checkCanSession(str), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.d0
            public final Object invoke(Object obj) {
                Unit chatImageViewPressed$lambda$11;
                chatImageViewPressed$lambda$11 = OtherUserActivity.chatImageViewPressed$lambda$11(OtherUserActivity.this, (ApiResponse) obj);
                return chatImageViewPressed$lambda$11;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.e0
            public final Object invoke(Object obj) {
                Unit chatImageViewPressed$lambda$12;
                chatImageViewPressed$lambda$12 = OtherUserActivity.chatImageViewPressed$lambda$12(OtherUserActivity.this, (Throwable) obj);
                return chatImageViewPressed$lambda$12;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.ui.profile.activity.s
            public final Object invoke() {
                Unit chatImageViewPressed$lambda$13;
                chatImageViewPressed$lambda$13 = OtherUserActivity.chatImageViewPressed$lambda$13(hiloLoadingDialog);
                return chatImageViewPressed$lambda$13;
            }
        }, false, 8, (Object) null), getCompositeDisposable());
    }

    @Override // com.qiahao.nextvideo.ui.profile.activity.BaseUserDetailActivity
    public void likedImageViewPressed() {
        String str;
        boolean z;
        UserService shared = UserService.INSTANCE.getShared();
        User uiModel = getUiModel();
        if (uiModel == null || (str = uiModel.getExternalId()) == null) {
            str = "";
        }
        String str2 = str;
        User uiModel2 = getUiModel();
        if (uiModel2 != null) {
            z = Intrinsics.areEqual(uiModel2.isLike(), Boolean.TRUE);
        } else {
            z = false;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.like$default(shared, str2, z, false, 4, null), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.a0
            public final Object invoke(Object obj) {
                Unit likedImageViewPressed$lambda$9;
                likedImageViewPressed$lambda$9 = OtherUserActivity.likedImageViewPressed$lambda$9(OtherUserActivity.this, (ApiResponse) obj);
                return likedImageViewPressed$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.b0
            public final Object invoke(Object obj) {
                Unit likedImageViewPressed$lambda$10;
                likedImageViewPressed$lambda$10 = OtherUserActivity.likedImageViewPressed$lambda$10(OtherUserActivity.this, (Throwable) obj);
                return likedImageViewPressed$lambda$10;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    @Override // com.qiahao.nextvideo.ui.profile.activity.BaseUserDetailActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        String str;
        String str2;
        long j;
        int i;
        String str3;
        super.onInitialize();
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        String str4 = null;
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        User uiModel = getUiModel();
        if (uiModel != null) {
            str2 = uiModel.getExternalId();
        } else {
            str2 = null;
        }
        if (!Intrinsics.areEqual(str, str2)) {
            UserService shared = UserService.INSTANCE.getShared();
            User uiModel2 = getUiModel();
            if (uiModel2 == null || (str3 = uiModel2.getExternalId()) == null) {
                str3 = "";
            }
            shared.userVisit(str3);
        }
        nd.c subscribe = companion.getShared().getLikeEventRelay().observeOn(RxUtilsKt.getMainThread()).filter(new pd.q() { // from class: com.qiahao.nextvideo.ui.profile.activity.OtherUserActivity$onInitialize$1
            public final boolean test(Pair<String, Boolean> pair) {
                Object first = pair.getFirst();
                User uiModel3 = OtherUserActivity.this.getUiModel();
                return Intrinsics.areEqual(first, uiModel3 != null ? uiModel3.getExternalId() : null);
            }
        }).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.profile.activity.OtherUserActivity$onInitialize$2
            public final void accept(Pair<String, Boolean> pair) {
                ActivityUserDetailBinding binding;
                ActivityUserDetailBinding binding2;
                try {
                    if (((Boolean) pair.getSecond()).booleanValue()) {
                        binding = OtherUserActivity.this.getBinding();
                        binding.likeSvgaImageView.stopAnimation();
                        binding2 = OtherUserActivity.this.getBinding();
                        binding2.likeSvgaImageView.startAnimation();
                    }
                    User uiModel3 = OtherUserActivity.this.getUiModel();
                    if (uiModel3 != null) {
                        uiModel3.setLike((Boolean) pair.getSecond());
                    }
                    OtherUserActivity.this.showLikedStatus();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, getCompositeDisposable());
        final AppCompatImageButton appCompatImageButton = getBinding().videoCallImageButton;
        final long j2 = 800;
        appCompatImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.OtherUserActivity$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean checkVideoPermission;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageButton) > j2 || (appCompatImageButton instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageButton, currentTimeMillis);
                    AppCompatImageButton appCompatImageButton2 = appCompatImageButton;
                    checkVideoPermission = this.checkVideoPermission();
                    if (checkVideoPermission) {
                        this.videoCallButtonPressed();
                    }
                }
            }
        });
        User user2 = companion.getShared().getUser();
        if (user2 != null && user2.isAr()) {
            AppCompatImageButton appCompatImageButton2 = getBinding().videoCallImageButton;
            User user3 = companion.getShared().getUser();
            if (user3 != null) {
                j = user3.getWealthUserGrade();
            } else {
                j = 0;
            }
            if (j > 10) {
                i = 0;
            } else {
                i = 8;
            }
            appCompatImageButton2.setVisibility(i);
        } else {
            getBinding().videoCallImageButton.setVisibility(0);
        }
        User uiModel3 = getUiModel();
        if (uiModel3 != null) {
            str4 = uiModel3.getCurrentRoom();
        }
        if (str4 != null && str4.length() != 0) {
            getBinding().roomImageButton.setVisibility(0);
            final AppCompatImageButton appCompatImageButton3 = getBinding().roomImageButton;
            appCompatImageButton3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.OtherUserActivity$onInitialize$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str5;
                    SvipData svip;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageButton3) > j2 || (appCompatImageButton3 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(appCompatImageButton3, currentTimeMillis);
                        AppCompatImageButton appCompatImageButton4 = appCompatImageButton3;
                        User uiModel4 = this.getUiModel();
                        if (uiModel4 != null && (svip = uiModel4.getSvip()) != null && svip.isNotFollow()) {
                            HiloToasty.Companion companion2 = HiloToasty.Companion;
                            BaseActivity baseActivity = this;
                            Toast normal$default = HiloToasty.Companion.normal$default(companion2, baseActivity, ResourcesKtxKt.getStringById(baseActivity, 2131954199), false, 4, (Object) null);
                            if (normal$default != null) {
                                normal$default.show();
                                return;
                            }
                            return;
                        }
                        StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
                        User uiModel5 = this.getUiModel();
                        if (uiModel5 == null || (str5 = uiModel5.getCurrentRoom()) == null) {
                            str5 = "";
                        }
                        StartRoomUtils.startRoom$default(startRoomUtils, str5, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
                    }
                }
            });
        } else {
            getBinding().roomImageButton.setVisibility(8);
        }
        showLikedStatus();
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onVideoEvent(@NotNull VideoEvent event) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "LIKE_EACH_OTHER")) {
            Object data = event.getData();
            if (data instanceof String) {
                str = (String) data;
            } else {
                str = null;
            }
            User uiModel = getUiModel();
            if (uiModel != null) {
                str2 = uiModel.getExternalId();
            } else {
                str2 = null;
            }
            if (Intrinsics.areEqual(str, str2)) {
                try {
                    UserService shared = UserService.INSTANCE.getShared();
                    User uiModel2 = getUiModel();
                    if (uiModel2 != null) {
                        str3 = uiModel2.getExternalId();
                        if (str3 == null) {
                        }
                        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.fetchUserDetail$default(shared, str3, null, 2, null), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.r
                            public final Object invoke(Object obj) {
                                Unit onVideoEvent$lambda$4;
                                onVideoEvent$lambda$4 = OtherUserActivity.onVideoEvent$lambda$4(OtherUserActivity.this, (ApiResponse) obj);
                                return onVideoEvent$lambda$4;
                            }
                        }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.w
                            public final Object invoke(Object obj) {
                                Unit onVideoEvent$lambda$5;
                                onVideoEvent$lambda$5 = OtherUserActivity.onVideoEvent$lambda$5((Throwable) obj);
                                return onVideoEvent$lambda$5;
                            }
                        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
                    }
                    str3 = "";
                    RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.fetchUserDetail$default(shared, str3, null, 2, null), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.r
                        public final Object invoke(Object obj) {
                            Unit onVideoEvent$lambda$4;
                            onVideoEvent$lambda$4 = OtherUserActivity.onVideoEvent$lambda$4(OtherUserActivity.this, (ApiResponse) obj);
                            return onVideoEvent$lambda$4;
                        }
                    }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.w
                        public final Object invoke(Object obj) {
                            Unit onVideoEvent$lambda$5;
                            onVideoEvent$lambda$5 = OtherUserActivity.onVideoEvent$lambda$5((Throwable) obj);
                            return onVideoEvent$lambda$5;
                        }
                    }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.qiahao.nextvideo.ui.profile.activity.BaseUserDetailActivity
    public void reportImageViewPressed() {
        String str;
        UserService shared = UserService.INSTANCE.getShared();
        User uiModel = getUiModel();
        if (uiModel == null || (str = uiModel.getExternalId()) == null) {
            str = "";
        }
        RxUtilsKt.observeOnMainThread$default(UserService.checkIsBroadcastManager$default(shared, null, str, false, 5, null), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.c0
            public final Object invoke(Object obj) {
                Unit reportImageViewPressed$lambda$8;
                reportImageViewPressed$lambda$8 = OtherUserActivity.reportImageViewPressed$lambda$8(OtherUserActivity.this, (ApiResponse) obj);
                return reportImageViewPressed$lambda$8;
            }
        }, (Function1) null, (Function0) null, false, 14, (Object) null);
    }

    public final void svipPrivileges(final int privilegesId) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getSvipInfo(), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.x
            public final Object invoke(Object obj) {
                Unit svipPrivileges$lambda$17;
                svipPrivileges$lambda$17 = OtherUserActivity.svipPrivileges$lambda$17(OtherUserActivity.this, privilegesId, (ApiResponse) obj);
                return svipPrivileges$lambda$17;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.y
            public final Object invoke(Object obj) {
                Unit svipPrivileges$lambda$18;
                svipPrivileges$lambda$18 = OtherUserActivity.svipPrivileges$lambda$18(OtherUserActivity.this, (Throwable) obj);
                return svipPrivileges$lambda$18;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    public final void svipUnBlock() {
        String str;
        ServerApi apis = AppServer.INSTANCE.getApis();
        User uiModel = getUiModel();
        if (uiModel == null || (str = uiModel.getExternalId()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.svipUnblock(str), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.t
            public final Object invoke(Object obj) {
                Unit svipUnBlock$lambda$14;
                svipUnBlock$lambda$14 = OtherUserActivity.svipUnBlock$lambda$14(OtherUserActivity.this, (ApiResponse) obj);
                return svipUnBlock$lambda$14;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.u
            public final Object invoke(Object obj) {
                Unit svipUnBlock$lambda$15;
                svipUnBlock$lambda$15 = OtherUserActivity.svipUnBlock$lambda$15(OtherUserActivity.this, (Throwable) obj);
                return svipUnBlock$lambda$15;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }
}
