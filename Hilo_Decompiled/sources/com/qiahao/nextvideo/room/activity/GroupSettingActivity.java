package com.qiahao.nextvideo.room.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.makeramen.roundedimageview.RoundedImageView;
import com.oudi.core.callback.SuperCallBack;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.picture.PictureSelector;
import com.qiahao.base_common.utils.picture.PictureSelectorConfigures;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.databinding.ActivityGroupSettingBinding;
import com.qiahao.nextvideo.room.activity.CommonChangeRoomSettingActivity;
import com.qiahao.nextvideo.room.activity.GroupThemesActivity;
import com.qiahao.nextvideo.room.dialog.JoinedPassWordDialog;
import com.qiahao.nextvideo.room.dialog.NumberOfDiceDialog;
import com.qiahao.nextvideo.room.dialog.OnJoinedPassWordDialogListener;
import com.qiahao.nextvideo.room.dialog.OnNumberOfDiceListener;
import com.qiahao.nextvideo.room.dialog.RoomPowerDiamondDialog;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.room.record.RoomRecordActivity;
import com.qiahao.nextvideo.room.viewmodel.GroupSettingViewModel;
import com.qiahao.nextvideo.ui.reusable.views.SwitchButton;
import com.qiahao.nextvideo.utilities.StorageUtils;
import java.io.File;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001'B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0016J\"\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020\u0015H\u0003R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lcom/qiahao/nextvideo/room/activity/GroupSettingActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityGroupSettingBinding;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "mViewModel", "Lcom/qiahao/nextvideo/room/viewmodel/GroupSettingViewModel;", "getMViewModel", "()Lcom/qiahao/nextvideo/room/viewmodel/GroupSettingViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "mGroupId", "", "getMGroupId", "()Ljava/lang/String;", "setMGroupId", "(Ljava/lang/String;)V", "onInitialize", "", "onRoomEvent", "event", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "initObserve", "initView", "groupDetailBean", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "initSwitchListener", "onClick", "v", "Landroid/view/View;", "onActivityResult", "requestCode", com.taobao.agoo.a.a.b.JSON_ERRORCODE, "data", "Landroid/content/Intent;", "choosePicture", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupSettingActivity extends HiloBaseBindingActivity<ActivityGroupSettingBinding> implements View.OnClickListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String GROUP_ID = "group_id";

    @NotNull
    private static final String TAG = "GroupSettingActivity";

    @NotNull
    public static final String TYPE_ROOM_CHANGE_DATA = "change_mic_data";
    public static final int TYPE_ROOM_CHANGE_MIC = 5;

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.activity.t
        public final Object invoke() {
            GroupSettingViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = GroupSettingActivity.mViewModel_delegate$lambda$0(GroupSettingActivity.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    @NotNull
    private String mGroupId = "";

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/GroupSettingActivity$Companion;", "", "<init>", "()V", "TAG", "", "GROUP_ID", "TYPE_ROOM_CHANGE_MIC", "", "TYPE_ROOM_CHANGE_DATA", "start", "", "context", "Landroid/content/Context;", "groupId", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context, @NotNull String groupId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intent putExtra = new Intent(context, (Class<?>) GroupSettingActivity.class).putExtra("group_id", groupId);
            Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
            context.startActivity(putExtra);
        }

        private Companion() {
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private final void choosePicture() {
        PictureSelector.INSTANCE.selectorPicture(new PictureSelectorConfigures.Companion.Builder().isEnablePreviewImage(true).setWithCamera(true).isMEnableCrop(true).build(), new OnResultCallbackListener<LocalMedia>() { // from class: com.qiahao.nextvideo.room.activity.GroupSettingActivity$choosePicture$1
            public void onCancel() {
            }

            public void onResult(ArrayList<LocalMedia> result) {
                String compressPath;
                GroupSettingViewModel mViewModel;
                if (result != null && result.size() > 0) {
                    LocalMedia localMedia = result.get(0);
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
                    File fileCompat = StorageUtils.INSTANCE.getFileCompat(compressPath);
                    if (fileCompat != null && fileCompat.exists()) {
                        mViewModel = GroupSettingActivity.this.getMViewModel();
                        mViewModel.startUpload(fileCompat);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GroupSettingViewModel getMViewModel() {
        return (GroupSettingViewModel) this.mViewModel.getValue();
    }

    private final void initObserve() {
        getMViewModel().getMGroupDetail().observe(this, new GroupSettingActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.activity.w
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$2;
                initObserve$lambda$2 = GroupSettingActivity.initObserve$lambda$2(GroupSettingActivity.this, (GroupDetailBean) obj);
                return initObserve$lambda$2;
            }
        }));
        getMViewModel().getMCanShowSupportLayout().observe(this, new GroupSettingActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.activity.x
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$3;
                initObserve$lambda$3 = GroupSettingActivity.initObserve$lambda$3(GroupSettingActivity.this, (Boolean) obj);
                return initObserve$lambda$3;
            }
        }));
        getMViewModel().getMErrorDetail().observe(this, new GroupSettingActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.activity.y
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$4;
                initObserve$lambda$4 = GroupSettingActivity.initObserve$lambda$4(GroupSettingActivity.this, (Pair) obj);
                return initObserve$lambda$4;
            }
        }));
        getMViewModel().getMException().observe(this, new GroupSettingActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.activity.z
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$5;
                initObserve$lambda$5 = GroupSettingActivity.initObserve$lambda$5((Pair) obj);
                return initObserve$lambda$5;
            }
        }));
        getMViewModel().getUpdateGroupInfo().observe(this, new GroupSettingActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.activity.a0
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$6;
                initObserve$lambda$6 = GroupSettingActivity.initObserve$lambda$6(GroupSettingActivity.this, (Boolean) obj);
                return initObserve$lambda$6;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObserve$lambda$2(GroupSettingActivity groupSettingActivity, GroupDetailBean groupDetailBean) {
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        Intrinsics.checkNotNull(groupDetailBean);
        meetingRoomManager.setGroupDetailBean(groupDetailBean);
        meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().updateGroupDetail(groupDetailBean));
        groupSettingActivity.initView(groupDetailBean);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObserve$lambda$3(GroupSettingActivity groupSettingActivity, Boolean bool) {
        Log.d(TAG, "initObserve: mCanShowSupportLayout " + bool);
        if (bool.booleanValue()) {
            groupSettingActivity.getBinding().lcGroupSupport.setVisibility(0);
        } else {
            groupSettingActivity.getBinding().lcGroupSupport.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initObserve$lambda$4(GroupSettingActivity groupSettingActivity, Pair pair) {
        HiloToasty.Companion companion = HiloToasty.Companion;
        String str = (String) pair.getSecond();
        if (str == null) {
            str = groupSettingActivity.getApplication().getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, groupSettingActivity, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObserve$lambda$5(Pair pair) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initObserve$lambda$6(GroupSettingActivity groupSettingActivity, Boolean bool) {
        HiloToasty.Companion companion = HiloToasty.Companion;
        String string = groupSettingActivity.getApplication().getString(2131954177);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toast normal$default = HiloToasty.Companion.normal$default(companion, groupSettingActivity, string, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final void initSwitchListener() {
        getBinding().switchLockText.setVisibility(8);
        getBinding().switchLockText.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.qiahao.nextvideo.room.activity.v
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                GroupSettingActivity.initSwitchListener$lambda$10(compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSwitchListener$lambda$10(CompoundButton compoundButton, boolean z) {
        Log.d(TAG, "switchLockText: isChecked = " + z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView(GroupDetailBean groupDetailBean) {
        int i;
        boolean z;
        boolean z2;
        int i2;
        RoundedImageView roundedImageView = ((ActivityGroupSettingBinding) getBinding()).imgPic;
        Intrinsics.checkNotNullExpressionValue(roundedImageView, "imgPic");
        ImageKtxKt.loadImage$default(roundedImageView, groupDetailBean.getFaceUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231930, (c5.g) null, 49150, (Object) null);
        ((ActivityGroupSettingBinding) getBinding()).name.setText(groupDetailBean.getName());
        ((ActivityGroupSettingBinding) getBinding()).introduction.setText(groupDetailBean.getIntroduction());
        ((ActivityGroupSettingBinding) getBinding()).announcement.setText(groupDetailBean.getNotification());
        if (!TextUtils.isEmpty(groupDetailBean.getPassword())) {
            ((ActivityGroupSettingBinding) getBinding()).joinedPassword.setText(groupDetailBean.getPassword());
        } else {
            ((ActivityGroupSettingBinding) getBinding()).joinedPassword.setText(getString(2131953004));
        }
        ((ActivityGroupSettingBinding) getBinding()).autoWelcomeContnet.setText(groupDetailBean.getWelcomeText());
        boolean z3 = false;
        if (groupDetailBean.getMicOn()) {
            TextView textView = ((ActivityGroupSettingBinding) getBinding()).micNumber;
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            Integer micNumType = groupDetailBean.getMicNumType();
            if (micNumType != null) {
                i2 = micNumType.intValue();
            } else {
                i2 = 0;
            }
            textView.setText(String.valueOf(meetingRoomManager.getMicSize(i2)));
        } else {
            ((ActivityGroupSettingBinding) getBinding()).micNumber.setText(getString(2131952273));
        }
        AppCompatTextView appCompatTextView = ((ActivityGroupSettingBinding) getBinding()).membershipDiamond;
        Integer memberFee = groupDetailBean.getMemberFee();
        if (memberFee != null) {
            i = memberFee.intValue();
        } else {
            i = 0;
        }
        appCompatTextView.setText(String.valueOf(i));
        SwitchButton switchButton = ((ActivityGroupSettingBinding) getBinding()).setMicButton;
        Integer touristMic = groupDetailBean.getTouristMic();
        if (touristMic != null && touristMic.intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        switchButton.setChecked(z);
        SwitchButton switchButton2 = ((ActivityGroupSettingBinding) getBinding()).setMessageButton;
        Integer touristSendMsg = groupDetailBean.getTouristSendMsg();
        if (touristSendMsg != null && touristSendMsg.intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        switchButton2.setChecked(z2);
        SwitchButton switchButton3 = ((ActivityGroupSettingBinding) getBinding()).setPictureButton;
        Integer touristSendPic = groupDetailBean.getTouristSendPic();
        if (touristSendPic != null && touristSendPic.intValue() == 1) {
            z3 = true;
        }
        switchButton3.setChecked(z3);
        ((ActivityGroupSettingBinding) getBinding()).setMicButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.qiahao.nextvideo.room.activity.d0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                GroupSettingActivity.initView$lambda$7(GroupSettingActivity.this, compoundButton, z4);
            }
        });
        ((ActivityGroupSettingBinding) getBinding()).setMessageButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.qiahao.nextvideo.room.activity.e0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                GroupSettingActivity.initView$lambda$8(GroupSettingActivity.this, compoundButton, z4);
            }
        });
        ((ActivityGroupSettingBinding) getBinding()).setPictureButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.qiahao.nextvideo.room.activity.u
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                GroupSettingActivity.initView$lambda$9(GroupSettingActivity.this, compoundButton, z4);
            }
        });
        ((ActivityGroupSettingBinding) getBinding()).diceNumber.setText(String.valueOf(groupDetailBean.getDiceNum()));
        initSwitchListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(GroupSettingActivity groupSettingActivity, CompoundButton compoundButton, boolean z) {
        int i;
        GroupSettingViewModel mViewModel = groupSettingActivity.getMViewModel();
        String str = groupSettingActivity.mGroupId;
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        GroupSettingViewModel.updateGroupInfo$default(mViewModel, str, null, null, null, null, null, null, null, null, GroupSettingViewModel.TOURIST_MIC, Integer.valueOf(i), null, null, 0, null, null, null, 129534, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(GroupSettingActivity groupSettingActivity, CompoundButton compoundButton, boolean z) {
        int i;
        GroupSettingViewModel mViewModel = groupSettingActivity.getMViewModel();
        String str = groupSettingActivity.mGroupId;
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        GroupSettingViewModel.updateGroupInfo$default(mViewModel, str, null, null, null, null, null, null, null, null, GroupSettingViewModel.TOURIST_MSG, null, Integer.valueOf(i), null, 0, null, null, null, 128510, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(GroupSettingActivity groupSettingActivity, CompoundButton compoundButton, boolean z) {
        int i;
        GroupSettingViewModel mViewModel = groupSettingActivity.getMViewModel();
        String str = groupSettingActivity.mGroupId;
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        GroupSettingViewModel.updateGroupInfo$default(mViewModel, str, null, null, null, null, null, null, null, null, GroupSettingViewModel.TOURIST_PIC, null, null, Integer.valueOf(i), 0, null, null, null, 126462, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GroupSettingViewModel mViewModel_delegate$lambda$0(GroupSettingActivity groupSettingActivity) {
        return new ViewModelProvider(groupSettingActivity).get(GroupSettingViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClick$lambda$12$lambda$11(GroupSettingActivity groupSettingActivity, int i) {
        GroupSettingViewModel.updateGroupInfo$default(groupSettingActivity.getMViewModel(), groupSettingActivity.mGroupId, null, null, null, null, null, null, null, null, GroupSettingViewModel.TOURIST_FEE, null, null, null, 1, Integer.valueOf(i), null, null, 105982, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$1(GroupSettingActivity groupSettingActivity, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = groupSettingActivity.getBinding().titleBar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMargins(0, i, 0, 0);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void start(@NotNull Context context, @NotNull String str) {
        INSTANCE.start(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_group_setting;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String str;
        String str2;
        String str3;
        String str4;
        super/*com.oudi.core.component.SuperActivity*/.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            String str5 = null;
            if (requestCode != 1) {
                if (requestCode != 2) {
                    if (requestCode != 3) {
                        if (requestCode != 4) {
                            if (requestCode == 5) {
                                int i = 0;
                                if (data != null) {
                                    i = data.getIntExtra(TYPE_ROOM_CHANGE_DATA, 0);
                                }
                                if (i == 0) {
                                    return;
                                }
                                getMViewModel().updateMicNumber(i);
                                return;
                            }
                            return;
                        }
                        GroupSettingViewModel mViewModel = getMViewModel();
                        if (data != null) {
                            str4 = data.getStringExtra("type");
                        } else {
                            str4 = null;
                        }
                        GroupSettingViewModel.updateGroupInfo$default(mViewModel, null, null, null, null, null, null, null, str4, null, GroupSettingViewModel.INTERFACE_GROUP_AUTO_WELCOME, null, null, null, 0, null, null, null, 130431, null);
                        if (data != null) {
                            str5 = data.getStringExtra("type");
                        }
                        Log.d(TAG, "onActivityResult: TYPE_ROOM_AUTO_WELCOME = " + str5);
                        return;
                    }
                    GroupSettingViewModel mViewModel2 = getMViewModel();
                    if (data != null) {
                        str3 = data.getStringExtra("type");
                    } else {
                        str3 = null;
                    }
                    GroupSettingViewModel.updateGroupInfo$default(mViewModel2, null, null, null, str3, null, null, null, null, null, GroupSettingViewModel.INTERFACE_GROUP_NOTIFICATION, null, null, null, 0, null, null, null, 130551, null);
                    if (data != null) {
                        str5 = data.getStringExtra("type");
                    }
                    Log.d(TAG, "onActivityResult: TYPE_ROOM_ANNOUNCEMENT = " + str5);
                    return;
                }
                GroupSettingViewModel mViewModel3 = getMViewModel();
                if (data != null) {
                    str2 = data.getStringExtra("type");
                } else {
                    str2 = null;
                }
                GroupSettingViewModel.updateGroupInfo$default(mViewModel3, null, null, str2, null, null, null, null, null, null, GroupSettingViewModel.INTERFACE_GROUP_INTRODUCTION, null, null, null, 0, null, null, null, 130555, null);
                if (data != null) {
                    str5 = data.getStringExtra("type");
                }
                Log.d(TAG, "onActivityResult: TYPE_ROOM_INTRODUCTION = " + str5);
                return;
            }
            GroupDetailBean groupDetailBean = (GroupDetailBean) getMViewModel().getMGroupDetail().getValue();
            if (groupDetailBean != null) {
                GroupSettingViewModel mViewModel4 = getMViewModel();
                String groupId = groupDetailBean.getGroupId();
                if (groupId == null) {
                    groupId = "";
                }
                String str6 = groupId;
                if (data != null) {
                    str = data.getStringExtra("type");
                } else {
                    str = null;
                }
                GroupSettingViewModel.updateGroupInfo$default(mViewModel4, str6, str, null, null, null, null, null, null, null, GroupSettingViewModel.INTERFACE_GROUP_NAME, null, null, null, 0, null, null, null, 130556, null);
                if (data != null) {
                    str5 = data.getStringExtra("type");
                }
                Log.d(TAG, "onActivityResult: TYPE_ROOM_NAME = " + str5);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.qiahao.nextvideo.room.dialog.JoinedPassWordDialog, android.app.Dialog] */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        String notification;
        String welcomeText;
        int i;
        Integer diceType;
        Integer diceNum;
        String introduction;
        int i2;
        Integer themeType;
        Integer themeId;
        String groupId;
        Integer memberFee;
        String name;
        Intrinsics.checkNotNullParameter(v, "v");
        int i3 = 0;
        int i4 = 1;
        String str = "";
        switch (v.getId()) {
            case R.id.actionRecords /* 2131361883 */:
                RoomRecordActivity.INSTANCE.start(this, this.mGroupId);
                return;
            case R.id.back_image_view /* 2131362039 */:
                finish();
                return;
            case R.id.cl_announcement /* 2131362336 */:
                CommonChangeRoomSettingActivity.Companion companion = CommonChangeRoomSettingActivity.INSTANCE;
                GroupDetailBean groupDetailBean = (GroupDetailBean) getMViewModel().getMGroupDetail().getValue();
                if (groupDetailBean != null && (notification = groupDetailBean.getNotification()) != null) {
                    str = notification;
                }
                companion.start(this, 3, str);
                return;
            case R.id.cl_auto_welcome /* 2131362337 */:
                CommonChangeRoomSettingActivity.Companion companion2 = CommonChangeRoomSettingActivity.INSTANCE;
                GroupDetailBean groupDetailBean2 = (GroupDetailBean) getMViewModel().getMGroupDetail().getValue();
                if (groupDetailBean2 != null && (welcomeText = groupDetailBean2.getWelcomeText()) != null) {
                    str = welcomeText;
                }
                companion2.start(this, 4, str);
                return;
            case R.id.cl_blocklist /* 2131362338 */:
                BlockedListActivity.INSTANCE.start(this, this.mGroupId);
                return;
            case R.id.cl_dice /* 2131362342 */:
                GroupDetailBean groupDetailBean3 = (GroupDetailBean) getMViewModel().getMGroupDetail().getValue();
                if (groupDetailBean3 != null && (diceNum = groupDetailBean3.getDiceNum()) != null) {
                    i = diceNum.intValue();
                } else {
                    i = 1;
                }
                GroupDetailBean groupDetailBean4 = (GroupDetailBean) getMViewModel().getMGroupDetail().getValue();
                if (groupDetailBean4 != null && (diceType = groupDetailBean4.getDiceType()) != null) {
                    i4 = diceType.intValue();
                }
                new NumberOfDiceDialog(this, i, i4, new OnNumberOfDiceListener() { // from class: com.qiahao.nextvideo.room.activity.GroupSettingActivity$onClick$1
                    @Override // com.qiahao.nextvideo.room.dialog.OnNumberOfDiceListener
                    public void cancel() {
                    }

                    @Override // com.qiahao.nextvideo.room.dialog.OnNumberOfDiceListener
                    public void confim(int diceNum2, int diceType2) {
                        GroupSettingViewModel mViewModel;
                        mViewModel = GroupSettingActivity.this.getMViewModel();
                        GroupSettingViewModel.updateGroupInfo$default(mViewModel, GroupSettingActivity.this.getMGroupId(), null, null, null, null, null, null, null, Integer.valueOf(diceNum2), GroupSettingViewModel.INTERFACE_GROUP_DICE_NUM, null, null, null, 0, null, Integer.valueOf(diceType2), null, 97534, null);
                    }
                }).show();
                return;
            case R.id.cl_introduction /* 2131362343 */:
                CommonChangeRoomSettingActivity.Companion companion3 = CommonChangeRoomSettingActivity.INSTANCE;
                GroupDetailBean groupDetailBean5 = (GroupDetailBean) getMViewModel().getMGroupDetail().getValue();
                if (groupDetailBean5 != null && (introduction = groupDetailBean5.getIntroduction()) != null) {
                    str = introduction;
                }
                companion3.start(this, 2, str);
                return;
            case R.id.cl_joined_password /* 2131362344 */:
                ?? joinedPassWordDialog = new JoinedPassWordDialog(this);
                joinedPassWordDialog.setListener(new OnJoinedPassWordDialogListener() { // from class: com.qiahao.nextvideo.room.activity.GroupSettingActivity$onClick$2
                    @Override // com.qiahao.nextvideo.room.dialog.OnJoinedPassWordDialogListener
                    public void cancel() {
                        Log.d("GroupSettingActivity", "cancel:");
                    }

                    @Override // com.qiahao.nextvideo.room.dialog.OnJoinedPassWordDialogListener
                    public void confim(boolean isPublicSelected, String password) {
                        GroupSettingViewModel mViewModel;
                        GroupSettingViewModel mViewModel2;
                        GroupSettingViewModel mViewModel3;
                        GroupSettingViewModel mViewModel4;
                        Intrinsics.checkNotNullParameter(password, "password");
                        Log.d("GroupSettingActivity", "confim:" + isPublicSelected + " == " + password);
                        String str2 = null;
                        if (!isPublicSelected) {
                            mViewModel3 = GroupSettingActivity.this.getMViewModel();
                            GroupDetailBean groupDetailBean6 = (GroupDetailBean) mViewModel3.getMGroupDetail().getValue();
                            if (groupDetailBean6 != null) {
                                str2 = groupDetailBean6.getPassword();
                            }
                            if (str2 == null || !Intrinsics.areEqual(groupDetailBean6.getPassword(), password)) {
                                mViewModel4 = GroupSettingActivity.this.getMViewModel();
                                GroupSettingViewModel.updateGroupInfo$default(mViewModel4, null, null, null, null, null, password, null, null, null, GroupSettingViewModel.INTERFACE_GROUP_PASSWORD, null, null, null, 0, null, null, null, 130527, null);
                                return;
                            }
                            return;
                        }
                        mViewModel = GroupSettingActivity.this.getMViewModel();
                        GroupDetailBean groupDetailBean7 = (GroupDetailBean) mViewModel.getMGroupDetail().getValue();
                        if (groupDetailBean7 != null) {
                            str2 = groupDetailBean7.getPassword();
                        }
                        if (str2 != null && str2.length() != 0) {
                            mViewModel2 = GroupSettingActivity.this.getMViewModel();
                            GroupSettingViewModel.updateGroupInfo$default(mViewModel2, null, null, null, null, null, "", null, null, null, GroupSettingViewModel.INTERFACE_GROUP_PASSWORD, null, null, null, 0, null, null, null, 130527, null);
                        }
                    }
                });
                joinedPassWordDialog.show();
                return;
            case R.id.cl_mic /* 2131362348 */:
                NumberOfMicActivity.INSTANCE.start(this, 5, MeetingRoomManager.INSTANCE.getMCurrentRoomMicType());
                return;
            case R.id.cl_theme /* 2131362350 */:
                GroupThemesActivity.Companion companion4 = GroupThemesActivity.INSTANCE;
                GroupDetailBean groupDetailBean6 = (GroupDetailBean) getMViewModel().getMGroupDetail().getValue();
                if (groupDetailBean6 != null && (groupId = groupDetailBean6.getGroupId()) != null) {
                    str = groupId;
                }
                GroupDetailBean groupDetailBean7 = (GroupDetailBean) getMViewModel().getMGroupDetail().getValue();
                if (groupDetailBean7 != null && (themeId = groupDetailBean7.getThemeId()) != null) {
                    i2 = themeId.intValue();
                } else {
                    i2 = 0;
                }
                GroupDetailBean groupDetailBean8 = (GroupDetailBean) getMViewModel().getMGroupDetail().getValue();
                if (groupDetailBean8 != null && (themeType = groupDetailBean8.getThemeType()) != null) {
                    i3 = themeType.intValue();
                }
                companion4.start(this, str, i2, i3);
                return;
            case R.id.img_pic /* 2131363255 */:
                choosePicture();
                return;
            case R.id.lc_group_support /* 2131363425 */:
                NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
                NavigationHelper.jump$default(navigationHelper, navigationHelper.addGroupStatus(GroupService.INSTANCE.getInstance().getGroupSupportH5(), this.mGroupId), (SuperCallBack) null, 2, (Object) null);
                return;
            case R.id.membership /* 2131363819 */:
                GroupDetailBean groupDetailBean9 = (GroupDetailBean) getMViewModel().getMGroupDetail().getValue();
                if (groupDetailBean9 != null && (memberFee = groupDetailBean9.getMemberFee()) != null) {
                    i3 = memberFee.intValue();
                }
                RoomPowerDiamondDialog roomPowerDiamondDialog = new RoomPowerDiamondDialog(this, i3);
                roomPowerDiamondDialog.setListener(new Function1() { // from class: com.qiahao.nextvideo.room.activity.c0
                    public final Object invoke(Object obj) {
                        Unit onClick$lambda$12$lambda$11;
                        onClick$lambda$12$lambda$11 = GroupSettingActivity.onClick$lambda$12$lambda$11(GroupSettingActivity.this, ((Integer) obj).intValue());
                        return onClick$lambda$12$lambda$11;
                    }
                });
                roomPowerDiamondDialog.show();
                return;
            case R.id.room_name /* 2131364672 */:
                CommonChangeRoomSettingActivity.Companion companion5 = CommonChangeRoomSettingActivity.INSTANCE;
                GroupDetailBean groupDetailBean10 = (GroupDetailBean) getMViewModel().getMGroupDetail().getValue();
                if (groupDetailBean10 != null && (name = groupDetailBean10.getName()) != null) {
                    str = name;
                }
                companion5.start(this, 1, str);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        Toolbar toolbar = ((ActivityGroupSettingBinding) getBinding()).titleBar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "titleBar");
        getStatusBarTopOrBottom(toolbar, new Function2() { // from class: com.qiahao.nextvideo.room.activity.b0
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$1;
                onInitialize$lambda$1 = GroupSettingActivity.onInitialize$lambda$1(GroupSettingActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$1;
            }
        });
        setStatusBarIconColor(false);
        ((ActivityGroupSettingBinding) getBinding()).setClick(this);
        initObserve();
        String stringExtra = getIntent().getStringExtra("group_id");
        Intrinsics.checkNotNull(stringExtra);
        this.mGroupId = stringExtra;
        getMViewModel().getGroupDetail(this.mGroupId);
        getMViewModel().isCanShowSupportLayout(this.mGroupId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onRoomEvent(@NotNull RoomEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int mEventId = event.getMEventId();
        if (mEventId != 214) {
            if (mEventId == 502) {
                GroupDetailBean groupDetailBean = (GroupDetailBean) getMViewModel().getMGroupDetail().getValue();
                if (groupDetailBean != null) {
                    int mThemeId = event.getMThemeId();
                    if (mThemeId == null) {
                        mThemeId = 0;
                    }
                    groupDetailBean.setThemeId(mThemeId);
                }
                GroupDetailBean groupDetailBean2 = (GroupDetailBean) getMViewModel().getMGroupDetail().getValue();
                if (groupDetailBean2 != null) {
                    String mThemeUrl = event.getMThemeUrl();
                    if (mThemeUrl == null) {
                        mThemeUrl = "";
                    }
                    groupDetailBean2.setThemeUrl(mThemeUrl);
                    return;
                }
                return;
            }
            return;
        }
        finish();
    }

    public final void setMGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGroupId = str;
    }
}
