package com.qiahao.nextvideo.room.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ActivityRoomUserBlockBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.utilities.FastClickUtils;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.taobao.accs.common.Constants;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00010B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010$\u001a\u00020\u0007H\u0014J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0007J\u0006\u0010*\u001a\u00020&J\u0010\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020-H\u0016J\u000e\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\u0007R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!¨\u00061"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/RoomUserInfoBlockActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityRoomUserBlockBinding;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "mIsSelectCode", "", "getMIsSelectCode", "()I", "setMIsSelectCode", "(I)V", "mExtraId", "", "getMExtraId", "()Ljava/lang/String;", "setMExtraId", "(Ljava/lang/String;)V", "mGroupId", "getMGroupId", "setMGroupId", "mHasPower", "", "getMHasPower", "()Z", "setMHasPower", "(Z)V", "mMyUserRole", "getMMyUserRole", "setMMyUserRole", "mViewModel", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "getMViewModel", "()Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "onInitialize", "", "onRoomEvent", "event", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "getData", "onClick", "v", "Landroid/view/View;", "selectShow", Constants.KEY_HTTP_CODE, "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomUserInfoBlockActivity extends HiloBaseBindingActivity<ActivityRoomUserBlockBinding> implements View.OnClickListener {
    private static final int BLOCK_AND_DELETE_HISTORY = 1;
    private static final int BLOCK_OUT = 2;
    private static final int BLOCK_SVIP = 3;

    @NotNull
    public static final String COUNTRY_MANAGER = "country_manager";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String GROUP_ID = "group_id";
    private static final int KICK_OUT = 0;

    @NotNull
    private static final String TAG = "RoomUserInfoRoleActivit";

    @NotNull
    public static final String USER_CODE = "User_CODE";

    @NotNull
    public static final String USER_ROLE = "USER_ROLE";
    private boolean mHasPower;
    private int mIsSelectCode;
    private int mMyUserRole;

    @NotNull
    private String mExtraId = "";

    @NotNull
    private String mGroupId = "";

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.activity.q1
        public final Object invoke() {
            BaseViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = RoomUserInfoBlockActivity.mViewModel_delegate$lambda$0(RoomUserInfoBlockActivity.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/RoomUserInfoBlockActivity$Companion;", "", "<init>", "()V", "TAG", "", "USER_CODE", "GROUP_ID", "COUNTRY_MANAGER", RoomUserInfoBlockActivity.USER_ROLE, "KICK_OUT", "", "BLOCK_AND_DELETE_HISTORY", "BLOCK_OUT", "BLOCK_SVIP", "start", "", "context", "Landroid/content/Context;", Constants.KEY_HTTP_CODE, "groupId", "countryManager", "", "userRole", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context, @NotNull String code, @NotNull String groupId, boolean countryManager, int userRole) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intent putExtra = new Intent(context, (Class<?>) RoomUserInfoBlockActivity.class).putExtra("User_CODE", code).putExtra("group_id", groupId).putExtra(RoomUserInfoBlockActivity.COUNTRY_MANAGER, countryManager).putExtra(RoomUserInfoBlockActivity.USER_ROLE, userRole);
            Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
            context.startActivity(putExtra);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$4(RoomUserInfoBlockActivity roomUserInfoBlockActivity, ApiResponse apiResponse) {
        int i;
        int i2;
        int i3;
        int i4;
        SvipData svip;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        User user = (User) apiResponse.getData();
        if (user != null) {
            TextView textView = roomUserInfoBlockActivity.getBinding().userName;
            String nick = user.getNick();
            CharSequence charSequence = "";
            if (nick == null) {
                nick = "";
            }
            textView.setText(nick);
            CircleImageView circleImageView = roomUserInfoBlockActivity.getBinding().userAvatarCimageView;
            Intrinsics.checkNotNullExpressionValue(circleImageView, "userAvatarCimageView");
            ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
            String avatar = user.getAvatar();
            ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
            Dimens dimens = Dimens.INSTANCE;
            lfit.setWidth(dimens.dpToPx(42));
            lfit.setHeight(dimens.dpToPx(42));
            Unit unit = Unit.INSTANCE;
            ViewUtilitiesKt.bind$default(circleImageView, companion.displayUserAvatarImage(avatar, lfit), null, 2, null);
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            int roomUserRole = meetingRoomManager.getRoomUserRole(roomUserInfoBlockActivity.mExtraId);
            if (roomUserRole > 1) {
                roomUserInfoBlockActivity.getBinding().userTag.setVisibility(0);
                ImageView imageView = roomUserInfoBlockActivity.getBinding().userTag;
                Intrinsics.checkNotNullExpressionValue(imageView, "userTag");
                ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(meetingRoomManager.getLevelRes(roomUserRole)), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            } else {
                roomUserInfoBlockActivity.getBinding().userTag.setVisibility(8);
            }
            ImageView imageView2 = roomUserInfoBlockActivity.getBinding().countryImage;
            Intrinsics.checkNotNullExpressionValue(imageView2, "countryImage");
            ViewUtilitiesKt.bind(imageView2, companion.countryTag(user.getCountryIcon()));
            GenderAgeTextView genderAgeTextView = roomUserInfoBlockActivity.getBinding().ageTextView;
            Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
            Resources resources = roomUserInfoBlockActivity.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            if (user.getSex() == 1) {
                i = R.drawable.icon_boy;
            } else {
                i = R.drawable.icon_girl;
            }
            ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, ResourceUtilsKt.getDrawable(resources, i, 0));
            GenderAgeTextView genderAgeTextView2 = roomUserInfoBlockActivity.getBinding().ageTextView;
            if (user.getSex() == 1) {
                i2 = R.drawable.bg_age_male;
            } else {
                i2 = R.drawable.bg_age_female;
            }
            genderAgeTextView2.setBackgroundResource(i2);
            AppCompatTextView appCompatTextView = roomUserInfoBlockActivity.getBinding().ageTextView;
            Integer isShowAge = user.isShowAge();
            if (isShowAge != null) {
                i3 = isShowAge.intValue();
            } else {
                i3 = 1;
            }
            if (i3 == 1) {
                charSequence = user.getAge();
            }
            appCompatTextView.setText(charSequence);
            HiloGradeView.setLevelBg$default(roomUserInfoBlockActivity.getBinding().wealthLevel, user.getWealthUserGrade(), false, true, false, 10, (Object) null);
            HiloGradeView.setLevelBg$default(roomUserInfoBlockActivity.getBinding().charmLevel, user.getCharmUserGrade(), true, false, false, 12, (Object) null);
            User user2 = UserStore.INSTANCE.getShared().getUser();
            if (user2 != null && (svip = user2.getSvip()) != null) {
                i4 = svip.getSvipLevel();
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                roomUserInfoBlockActivity.getBinding().svipLinear.setVisibility(0);
            } else {
                roomUserInfoBlockActivity.getBinding().svipLinear.setVisibility(8);
            }
            if (roomUserInfoBlockActivity.mMyUserRole < 10 && roomUserInfoBlockActivity.mHasPower) {
                roomUserInfoBlockActivity.getBinding().llBlockDeleteHistory.setVisibility(8);
                roomUserInfoBlockActivity.getBinding().line.setVisibility(8);
                roomUserInfoBlockActivity.getBinding().llBlockNotDeleteHistory.setVisibility(8);
                roomUserInfoBlockActivity.getBinding().content.setVisibility(8);
                roomUserInfoBlockActivity.getBinding().svipLinear.setVisibility(8);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit getData$lambda$5(RoomUserInfoBlockActivity roomUserInfoBlockActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        String string = roomUserInfoBlockActivity.getString(2131952667);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toast normal$default = HiloToasty.Companion.normal$default(companion, roomUserInfoBlockActivity, string, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final BaseViewModel getMViewModel() {
        return (BaseViewModel) this.mViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseViewModel mViewModel_delegate$lambda$0(RoomUserInfoBlockActivity roomUserInfoBlockActivity) {
        return new ViewModelProvider(roomUserInfoBlockActivity).get(BaseViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onClick$lambda$6(RoomUserInfoBlockActivity roomUserInfoBlockActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String string = roomUserInfoBlockActivity.getString(2131954177);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast normal$default = HiloToasty.Companion.normal$default(companion, roomUserInfoBlockActivity, string, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            roomUserInfoBlockActivity.finish();
        } else {
            HiloToasty.Companion companion2 = HiloToasty.Companion;
            String string2 = roomUserInfoBlockActivity.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            Toast normal$default2 = HiloToasty.Companion.normal$default(companion2, roomUserInfoBlockActivity, string2, false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onClick$lambda$7(RoomUserInfoBlockActivity roomUserInfoBlockActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            if (hiloException.getCode() == 21002) {
                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, roomUserInfoBlockActivity, ResourcesKtxKt.getStringById(roomUserInfoBlockActivity, 2131953533), false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            } else {
                HiloToasty.Companion companion = HiloToasty.Companion;
                String errorMessage = hiloException.getErrorMessage();
                if (errorMessage == null) {
                    errorMessage = ResourcesKtxKt.getStringById(roomUserInfoBlockActivity, 2131952667);
                }
                Toast normal$default2 = HiloToasty.Companion.normal$default(companion, roomUserInfoBlockActivity, errorMessage, false, 4, (Object) null);
                if (normal$default2 != null) {
                    normal$default2.show();
                }
            }
        } else {
            Toast normal$default3 = HiloToasty.Companion.normal$default(HiloToasty.Companion, roomUserInfoBlockActivity, ResourcesKtxKt.getStringById(roomUserInfoBlockActivity, 2131952667), false, 4, (Object) null);
            if (normal$default3 != null) {
                normal$default3.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onClick$lambda$8(RoomUserInfoBlockActivity roomUserInfoBlockActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String string = roomUserInfoBlockActivity.getString(2131954177);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast normal$default = HiloToasty.Companion.normal$default(companion, roomUserInfoBlockActivity, string, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            roomUserInfoBlockActivity.finish();
        } else {
            HiloToasty.Companion companion2 = HiloToasty.Companion;
            String string2 = roomUserInfoBlockActivity.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            Toast normal$default2 = HiloToasty.Companion.normal$default(companion2, roomUserInfoBlockActivity, string2, false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onClick$lambda$9(RoomUserInfoBlockActivity roomUserInfoBlockActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            if (hiloException.getCode() == 21002) {
                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, roomUserInfoBlockActivity, ResourcesKtxKt.getStringById(roomUserInfoBlockActivity, 2131953533), false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            } else {
                HiloToasty.Companion companion = HiloToasty.Companion;
                String errorMessage = hiloException.getErrorMessage();
                if (errorMessage == null) {
                    errorMessage = ResourcesKtxKt.getStringById(roomUserInfoBlockActivity, 2131952667);
                }
                Toast normal$default2 = HiloToasty.Companion.normal$default(companion, roomUserInfoBlockActivity, errorMessage, false, 4, (Object) null);
                if (normal$default2 != null) {
                    normal$default2.show();
                }
            }
        } else {
            Toast normal$default3 = HiloToasty.Companion.normal$default(HiloToasty.Companion, roomUserInfoBlockActivity, ResourcesKtxKt.getStringById(roomUserInfoBlockActivity, 2131952667), false, 4, (Object) null);
            if (normal$default3 != null) {
                normal$default3.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$1(RoomUserInfoBlockActivity roomUserInfoBlockActivity, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = roomUserInfoBlockActivity.getBinding().titleBar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMargins(0, i, 0, 0);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void start(@NotNull Context context, @NotNull String str, @NotNull String str2, boolean z, int i) {
        INSTANCE.start(context, str, str2, z, i);
    }

    public final void getData() {
        RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().fetchUserDetail(this.mExtraId, this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.activity.r1
            public final Object invoke(Object obj) {
                Unit data$lambda$4;
                data$lambda$4 = RoomUserInfoBlockActivity.getData$lambda$4(RoomUserInfoBlockActivity.this, (ApiResponse) obj);
                return data$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.activity.s1
            public final Object invoke(Object obj) {
                Unit data$lambda$5;
                data$lambda$5 = RoomUserInfoBlockActivity.getData$lambda$5(RoomUserInfoBlockActivity.this, (Throwable) obj);
                return data$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_room_user_block;
    }

    @NotNull
    public final String getMExtraId() {
        return this.mExtraId;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    public final boolean getMHasPower() {
        return this.mHasPower;
    }

    public final int getMIsSelectCode() {
        return this.mIsSelectCode;
    }

    public final int getMMyUserRole() {
        return this.mMyUserRole;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        boolean z;
        Intrinsics.checkNotNullParameter(v, "v");
        boolean z2 = false;
        switch (v.getId()) {
            case R.id.back_image_view /* 2131362039 */:
                finish();
                return;
            case R.id.confim /* 2131362418 */:
                if (FastClickUtils.INSTANCE.isFastClick()) {
                    int i = this.mIsSelectCode;
                    if (i != 0) {
                        if (i == 1 || i == 2 || i == 3) {
                            GroupService companion = GroupService.INSTANCE.getInstance();
                            String str = this.mGroupId;
                            String str2 = this.mExtraId;
                            int i2 = this.mIsSelectCode;
                            if (i2 == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (i2 == 3) {
                                z2 = true;
                            }
                            RxUtilsKt.observeOnMainThread$default(companion.groupBlockListAddUser(str, str2, z, z2), new Function1() { // from class: com.qiahao.nextvideo.room.activity.w1
                                public final Object invoke(Object obj) {
                                    Unit onClick$lambda$8;
                                    onClick$lambda$8 = RoomUserInfoBlockActivity.onClick$lambda$8(RoomUserInfoBlockActivity.this, (ApiResponse) obj);
                                    return onClick$lambda$8;
                                }
                            }, new Function1() { // from class: com.qiahao.nextvideo.room.activity.x1
                                public final Object invoke(Object obj) {
                                    Unit onClick$lambda$9;
                                    onClick$lambda$9 = RoomUserInfoBlockActivity.onClick$lambda$9(RoomUserInfoBlockActivity.this, (Throwable) obj);
                                    return onClick$lambda$9;
                                }
                            }, (Function0) null, false, 12, (Object) null);
                            return;
                        }
                        return;
                    }
                    RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().groupKick(this.mGroupId, this.mExtraId), new Function1() { // from class: com.qiahao.nextvideo.room.activity.u1
                        public final Object invoke(Object obj) {
                            Unit onClick$lambda$6;
                            onClick$lambda$6 = RoomUserInfoBlockActivity.onClick$lambda$6(RoomUserInfoBlockActivity.this, (ApiResponse) obj);
                            return onClick$lambda$6;
                        }
                    }, new Function1() { // from class: com.qiahao.nextvideo.room.activity.v1
                        public final Object invoke(Object obj) {
                            Unit onClick$lambda$7;
                            onClick$lambda$7 = RoomUserInfoBlockActivity.onClick$lambda$7(RoomUserInfoBlockActivity.this, (Throwable) obj);
                            return onClick$lambda$7;
                        }
                    }, (Function0) null, false, 12, (Object) null);
                    return;
                }
                return;
            case R.id.ll_block_delete_history /* 2131363535 */:
                selectShow(1);
                return;
            case R.id.ll_block_not_delete_history /* 2131363536 */:
                selectShow(2);
                return;
            case R.id.ll_kick_out /* 2131363560 */:
                selectShow(0);
                return;
            case R.id.svipLinear /* 2131364971 */:
                selectShow(3);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        ((ActivityRoomUserBlockBinding) getBinding()).setClick(this);
        String stringExtra = getIntent().getStringExtra("User_CODE");
        String str = "";
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mExtraId = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("group_id");
        if (stringExtra2 != null) {
            str = stringExtra2;
        }
        this.mGroupId = str;
        this.mHasPower = getIntent().getBooleanExtra(COUNTRY_MANAGER, false);
        this.mMyUserRole = getIntent().getIntExtra(USER_ROLE, 0);
        selectShow(0);
        if (this.mMyUserRole < 10 && this.mHasPower) {
            ((ActivityRoomUserBlockBinding) getBinding()).llBlockDeleteHistory.setVisibility(8);
            ((ActivityRoomUserBlockBinding) getBinding()).line.setVisibility(8);
            ((ActivityRoomUserBlockBinding) getBinding()).llBlockNotDeleteHistory.setVisibility(8);
            ((ActivityRoomUserBlockBinding) getBinding()).content.setVisibility(8);
            ((ActivityRoomUserBlockBinding) getBinding()).svipLinear.setVisibility(8);
        }
        Toolbar toolbar = ((ActivityRoomUserBlockBinding) getBinding()).titleBar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "titleBar");
        getStatusBarTopOrBottom(toolbar, new Function2() { // from class: com.qiahao.nextvideo.room.activity.t1
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$1;
                onInitialize$lambda$1 = RoomUserInfoBlockActivity.onInitialize$lambda$1(RoomUserInfoBlockActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$1;
            }
        });
        setStatusBarIconColor(false);
        getData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onRoomEvent(@NotNull RoomEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getMEventId() == 214) {
            finish();
        }
    }

    public final void selectShow(int code) {
        if (code != 0) {
            if (code != 1) {
                if (code != 2) {
                    if (code == 3) {
                        getBinding().viewKickOut.setVisibility(8);
                        getBinding().viewBlockDeleteHistory.setVisibility(8);
                        getBinding().viewBlockNotDeleteHistory.setVisibility(8);
                        getBinding().svipView.setVisibility(0);
                        this.mIsSelectCode = 3;
                        return;
                    }
                    return;
                }
                getBinding().viewKickOut.setVisibility(8);
                getBinding().viewBlockDeleteHistory.setVisibility(8);
                getBinding().viewBlockNotDeleteHistory.setVisibility(0);
                getBinding().svipView.setVisibility(8);
                this.mIsSelectCode = 2;
                return;
            }
            getBinding().viewKickOut.setVisibility(8);
            getBinding().viewBlockDeleteHistory.setVisibility(0);
            getBinding().viewBlockNotDeleteHistory.setVisibility(8);
            getBinding().svipView.setVisibility(8);
            this.mIsSelectCode = 1;
            return;
        }
        getBinding().viewKickOut.setVisibility(0);
        getBinding().viewBlockDeleteHistory.setVisibility(8);
        getBinding().viewBlockNotDeleteHistory.setVisibility(8);
        getBinding().svipView.setVisibility(8);
        this.mIsSelectCode = 0;
    }

    public final void setMExtraId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mExtraId = str;
    }

    public final void setMGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGroupId = str;
    }

    public final void setMHasPower(boolean z) {
        this.mHasPower = z;
    }

    public final void setMIsSelectCode(int i) {
        this.mIsSelectCode = i;
    }

    public final void setMMyUserRole(int i) {
        this.mMyUserRole = i;
    }
}
