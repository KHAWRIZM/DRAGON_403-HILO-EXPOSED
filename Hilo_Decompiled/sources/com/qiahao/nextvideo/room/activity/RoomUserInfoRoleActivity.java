package com.qiahao.nextvideo.room.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import com.qiahao.base_common.model.common.User;
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
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ActivityRoomUserInfoLevelBinding;
import com.qiahao.nextvideo.network.AppServer;
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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001/B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001b\u001a\u00020\u0007H\u0014J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0007J\b\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020#H\u0002J\u0006\u0010)\u001a\u00020#J\u0010\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0016J\u000e\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020\u0007R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f¨\u00060"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/RoomUserInfoRoleActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityRoomUserInfoLevelBinding;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "mIsSelectCode", "", "getMIsSelectCode", "()I", "setMIsSelectCode", "(I)V", "mGroupId", "", "getMGroupId", "()Ljava/lang/String;", "setMGroupId", "(Ljava/lang/String;)V", "mExtraId", "getMExtraId", "setMExtraId", "mUserRole", "getMUserRole", "setMUserRole", "mMyRole", "getMMyRole", "setMMyRole", "getLayoutResId", "mViewModel", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "getMViewModel", "()Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "onInitialize", "", "onRoomEvent", "event", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "getMyRole", "showUserCurrentRole", "getData", "onClick", "v", "Landroid/view/View;", "selectShow", Constants.KEY_HTTP_CODE, "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomUserInfoRoleActivity extends HiloBaseBindingActivity<ActivityRoomUserInfoLevelBinding> implements View.OnClickListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String GROUP_ID = "group_id";

    @NotNull
    private static final String TAG = "RoomUserInfoRoleActivit";

    @NotNull
    public static final String USER_CODE = "User_CODE";
    private int mIsSelectCode;
    private int mMyRole;
    private int mUserRole;

    @NotNull
    private String mGroupId = "";

    @NotNull
    private String mExtraId = "";

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.activity.a2
        public final Object invoke() {
            BaseViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = RoomUserInfoRoleActivity.mViewModel_delegate$lambda$0(RoomUserInfoRoleActivity.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/RoomUserInfoRoleActivity$Companion;", "", "<init>", "()V", "TAG", "", "USER_CODE", "GROUP_ID", "start", "", "context", "Landroid/content/Context;", "groupId", Constants.KEY_HTTP_CODE, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context, @NotNull String groupId, @NotNull String code) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
            Intent putExtra = new Intent(context, (Class<?>) RoomUserInfoRoleActivity.class).putExtra("group_id", groupId).putExtra("User_CODE", code);
            Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
            context.startActivity(putExtra);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$4(RoomUserInfoRoleActivity roomUserInfoRoleActivity, ApiResponse apiResponse) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        User user = (User) apiResponse.getData();
        if (user != null) {
            TextView textView = roomUserInfoRoleActivity.getBinding().userName;
            String nick = user.getNick();
            if (nick == null) {
                nick = "";
            }
            textView.setText(nick);
            CircleImageView circleImageView = roomUserInfoRoleActivity.getBinding().userAvatarCimageView;
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
            int roomUserRole = meetingRoomManager.getRoomUserRole(roomUserInfoRoleActivity.mExtraId);
            int i3 = 0;
            if (roomUserRole > 1) {
                roomUserInfoRoleActivity.getBinding().userTag.setVisibility(0);
                ImageView imageView = roomUserInfoRoleActivity.getBinding().userTag;
                Intrinsics.checkNotNullExpressionValue(imageView, "userTag");
                ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(meetingRoomManager.getLevelRes(roomUserRole)), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            } else {
                roomUserInfoRoleActivity.getBinding().userTag.setVisibility(8);
            }
            ImageView imageView2 = roomUserInfoRoleActivity.getBinding().countryImage;
            Intrinsics.checkNotNullExpressionValue(imageView2, "countryImage");
            ViewUtilitiesKt.bind(imageView2, companion.countryTag(user.getCountryIcon()));
            GenderAgeTextView genderAgeTextView = roomUserInfoRoleActivity.getBinding().ageTextView;
            Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
            Resources resources = roomUserInfoRoleActivity.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            if (user.getSex() == 1) {
                i = R.drawable.icon_boy;
            } else {
                i = R.drawable.icon_girl;
            }
            ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, ResourceUtilsKt.getDrawable(resources, i, 0));
            GenderAgeTextView genderAgeTextView2 = roomUserInfoRoleActivity.getBinding().ageTextView;
            if (user.getSex() == 1) {
                i2 = R.drawable.bg_age_male;
            } else {
                i2 = R.drawable.bg_age_female;
            }
            genderAgeTextView2.setBackgroundResource(i2);
            roomUserInfoRoleActivity.getBinding().ageTextView.setText(user.getAge());
            HiloGradeView.setLevelBg$default(roomUserInfoRoleActivity.getBinding().wealthLevel, user.getWealthUserGrade(), false, true, false, 10, (Object) null);
            HiloGradeView.setLevelBg$default(roomUserInfoRoleActivity.getBinding().charmLevel, user.getCharmUserGrade(), true, false, false, 12, (Object) null);
            Integer groupRole = user.getGroupRole();
            if (groupRole != null) {
                i3 = groupRole.intValue();
            }
            roomUserInfoRoleActivity.mUserRole = i3;
            roomUserInfoRoleActivity.showUserCurrentRole();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit getData$lambda$5(RoomUserInfoRoleActivity roomUserInfoRoleActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        String string = roomUserInfoRoleActivity.getString(2131952667);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toast normal$default = HiloToasty.Companion.normal$default(companion, roomUserInfoRoleActivity, string, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final BaseViewModel getMViewModel() {
        return (BaseViewModel) this.mViewModel.getValue();
    }

    private final void getMyRole() {
        String str;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        Intrinsics.checkNotNull(str);
        this.mMyRole = meetingRoomManager.getRoomUserRole(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseViewModel mViewModel_delegate$lambda$0(RoomUserInfoRoleActivity roomUserInfoRoleActivity) {
        return new ViewModelProvider(roomUserInfoRoleActivity).get(BaseViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onClick$lambda$6(RoomUserInfoRoleActivity roomUserInfoRoleActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().updateUserLevel(roomUserInfoRoleActivity.mGroupId, roomUserInfoRoleActivity.mIsSelectCode, roomUserInfoRoleActivity.mExtraId));
            HiloToasty.Companion companion = HiloToasty.Companion;
            String string = roomUserInfoRoleActivity.getString(2131954177);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast normal$default = HiloToasty.Companion.normal$default(companion, roomUserInfoRoleActivity, string, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            roomUserInfoRoleActivity.finish();
        } else if (apiResponse.getCode() == 14013) {
            HiloToasty.Companion companion2 = HiloToasty.Companion;
            String string2 = roomUserInfoRoleActivity.getString(2131953383);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            Toast normal$default2 = HiloToasty.Companion.normal$default(companion2, roomUserInfoRoleActivity, string2, false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        } else {
            HiloToasty.Companion companion3 = HiloToasty.Companion;
            String string3 = roomUserInfoRoleActivity.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            Toast normal$default3 = HiloToasty.Companion.normal$default(companion3, roomUserInfoRoleActivity, string3, false, 4, (Object) null);
            if (normal$default3 != null) {
                normal$default3.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onClick$lambda$7(RoomUserInfoRoleActivity roomUserInfoRoleActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            int code = ((HiloException) th).getCode();
            if (code != 14002) {
                if (code != 14013) {
                    HiloToasty.Companion companion = HiloToasty.Companion;
                    String string = roomUserInfoRoleActivity.getString(2131952667);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    Toast normal$default = HiloToasty.Companion.normal$default(companion, roomUserInfoRoleActivity, string, false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                } else {
                    HiloToasty.Companion companion2 = HiloToasty.Companion;
                    String string2 = roomUserInfoRoleActivity.getString(2131953383);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    Toast normal$default2 = HiloToasty.Companion.normal$default(companion2, roomUserInfoRoleActivity, string2, false, 4, (Object) null);
                    if (normal$default2 != null) {
                        normal$default2.show();
                    }
                }
            } else {
                HiloToasty.Companion companion3 = HiloToasty.Companion;
                String string3 = roomUserInfoRoleActivity.getString(2131953018);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                Toast normal$default3 = HiloToasty.Companion.normal$default(companion3, roomUserInfoRoleActivity, string3, false, 4, (Object) null);
                if (normal$default3 != null) {
                    normal$default3.show();
                }
            }
        } else {
            HiloToasty.Companion companion4 = HiloToasty.Companion;
            String string4 = roomUserInfoRoleActivity.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            Toast normal$default4 = HiloToasty.Companion.normal$default(companion4, roomUserInfoRoleActivity, string4, false, 4, (Object) null);
            if (normal$default4 != null) {
                normal$default4.show();
            }
        }
        Log.d(TAG, "onError: " + th.getLocalizedMessage());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$1(RoomUserInfoRoleActivity roomUserInfoRoleActivity, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = roomUserInfoRoleActivity.getBinding().titleBar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMargins(0, i, 0, 0);
        return Unit.INSTANCE;
    }

    private final void showUserCurrentRole() {
        selectShow(this.mUserRole);
        if (this.mMyRole == 50) {
            getBinding().llManager.setVisibility(8);
            getBinding().memberContent.setVisibility(8);
        }
    }

    @JvmStatic
    public static final void start(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        INSTANCE.start(context, str, str2);
    }

    public final void getData() {
        RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().fetchUserDetail(this.mExtraId, this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.activity.y1
            public final Object invoke(Object obj) {
                Unit data$lambda$4;
                data$lambda$4 = RoomUserInfoRoleActivity.getData$lambda$4(RoomUserInfoRoleActivity.this, (ApiResponse) obj);
                return data$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.activity.z1
            public final Object invoke(Object obj) {
                Unit data$lambda$5;
                data$lambda$5 = RoomUserInfoRoleActivity.getData$lambda$5(RoomUserInfoRoleActivity.this, (Throwable) obj);
                return data$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_room_user_info_level;
    }

    @NotNull
    public final String getMExtraId() {
        return this.mExtraId;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    public final int getMIsSelectCode() {
        return this.mIsSelectCode;
    }

    public final int getMMyRole() {
        return this.mMyRole;
    }

    public final int getMUserRole() {
        return this.mUserRole;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        switch (v.getId()) {
            case R.id.back_image_view /* 2131362039 */:
                finish();
                return;
            case R.id.confim /* 2131362418 */:
                if (FastClickUtils.INSTANCE.isFastClick()) {
                    RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().setRoomUserRole(this.mGroupId, this.mIsSelectCode, this.mExtraId), new Function1() { // from class: com.qiahao.nextvideo.room.activity.b2
                        public final Object invoke(Object obj) {
                            Unit onClick$lambda$6;
                            onClick$lambda$6 = RoomUserInfoRoleActivity.onClick$lambda$6(RoomUserInfoRoleActivity.this, (ApiResponse) obj);
                            return onClick$lambda$6;
                        }
                    }, new Function1() { // from class: com.qiahao.nextvideo.room.activity.c2
                        public final Object invoke(Object obj) {
                            Unit onClick$lambda$7;
                            onClick$lambda$7 = RoomUserInfoRoleActivity.onClick$lambda$7(RoomUserInfoRoleActivity.this, (Throwable) obj);
                            return onClick$lambda$7;
                        }
                    }, (Function0) null, false, 12, (Object) null);
                    Log.d(TAG, "onClick: selected " + this.mIsSelectCode);
                    return;
                }
                return;
            case R.id.ll_admin /* 2131363530 */:
                selectShow(10);
                return;
            case R.id.ll_manager /* 2131363566 */:
                selectShow(50);
                return;
            case R.id.ll_member /* 2131363569 */:
                selectShow(1);
                return;
            case R.id.tourist /* 2131365327 */:
                selectShow(0);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        Toolbar toolbar = ((ActivityRoomUserInfoLevelBinding) getBinding()).titleBar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "titleBar");
        getStatusBarTopOrBottom(toolbar, new Function2() { // from class: com.qiahao.nextvideo.room.activity.d2
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$1;
                onInitialize$lambda$1 = RoomUserInfoRoleActivity.onInitialize$lambda$1(RoomUserInfoRoleActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$1;
            }
        });
        setStatusBarIconColor(false);
        ((ActivityRoomUserInfoLevelBinding) getBinding()).setClick(this);
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
        getData();
        getMyRole();
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
                if (code != 10) {
                    if (code == 50) {
                        getBinding().viewManager.setVisibility(0);
                        getBinding().viewAdmin.setVisibility(8);
                        getBinding().viewMember.setVisibility(8);
                        getBinding().viewTourist.setVisibility(8);
                        this.mIsSelectCode = 50;
                        return;
                    }
                    return;
                }
                getBinding().viewManager.setVisibility(8);
                getBinding().viewAdmin.setVisibility(0);
                getBinding().viewMember.setVisibility(8);
                getBinding().viewTourist.setVisibility(8);
                this.mIsSelectCode = 10;
                return;
            }
            getBinding().viewManager.setVisibility(8);
            getBinding().viewAdmin.setVisibility(8);
            getBinding().viewMember.setVisibility(0);
            getBinding().viewTourist.setVisibility(8);
            this.mIsSelectCode = 1;
            return;
        }
        getBinding().viewManager.setVisibility(8);
        getBinding().viewAdmin.setVisibility(8);
        getBinding().viewMember.setVisibility(8);
        getBinding().viewTourist.setVisibility(0);
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

    public final void setMIsSelectCode(int i) {
        this.mIsSelectCode = i;
    }

    public final void setMMyRole(int i) {
        this.mMyRole = i;
    }

    public final void setMUserRole(int i) {
        this.mUserRole = i;
    }
}
