package com.qiahao.nextvideo.room.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.picture.PictureSelector;
import com.qiahao.base_common.utils.picture.PictureSelectorConfigures;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GroupThemeCustomConfig;
import com.qiahao.nextvideo.databinding.ActivityGroupCustomThemeBinding;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.room.viewmodel.CustomThemeViewModel;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qiahao.nextvideo.utilities.FastClickUtils;
import com.qiahao.nextvideo.utilities.StorageUtils;
import java.io.File;
import java.util.ArrayList;
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

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0018B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/CustomThemeActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityGroupCustomThemeBinding;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/room/viewmodel/CustomThemeViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/room/viewmodel/CustomThemeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "onInitialize", "", "onRoomEvent", "event", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "initObserve", "onClick", "v", "Landroid/view/View;", "selectPictureShow", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CustomThemeActivity extends HiloBaseBindingActivity<ActivityGroupCustomThemeBinding> implements View.OnClickListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.activity.p
        public final Object invoke() {
            CustomThemeViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = CustomThemeActivity.viewModel_delegate$lambda$0(CustomThemeActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/CustomThemeActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "groupId", "", "nowSize", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context, @NotNull String groupId, int nowSize) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intent intent = new Intent(context, (Class<?>) CustomThemeActivity.class);
            intent.putExtra("groupId", groupId);
            intent.putExtra("nowSize", nowSize);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CustomThemeViewModel getViewModel() {
        return (CustomThemeViewModel) this.viewModel.getValue();
    }

    private final void initObserve() {
        getViewModel().getMCustomConfigUnPeekLiveData().observe(this, new CustomThemeActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.activity.q
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$2;
                initObserve$lambda$2 = CustomThemeActivity.initObserve$lambda$2(CustomThemeActivity.this, (GroupThemeCustomConfig) obj);
                return initObserve$lambda$2;
            }
        }));
        getViewModel().getMUploadSuccessUnPeekLiveData().observe(this, new CustomThemeActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.activity.r
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$3;
                initObserve$lambda$3 = CustomThemeActivity.initObserve$lambda$3(CustomThemeActivity.this, (Boolean) obj);
                return initObserve$lambda$3;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initObserve$lambda$2(CustomThemeActivity customThemeActivity, GroupThemeCustomConfig groupThemeCustomConfig) {
        ((ActivityGroupCustomThemeBinding) customThemeActivity.getBinding()).diamondAndTime.setText(groupThemeCustomConfig.getDiamondNum() + "/" + groupThemeCustomConfig.getDays() + customThemeActivity.getString(2131952500));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initObserve$lambda$3(CustomThemeActivity customThemeActivity, Boolean bool) {
        customThemeActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$1(CustomThemeActivity customThemeActivity, int i, int i2) {
        ConstraintLayout.b layoutParams = customThemeActivity.getBinding().titleBar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        layoutParams.setMargins(0, i, 0, 0);
        return Unit.INSTANCE;
    }

    private final void selectPictureShow() {
        PictureSelector.INSTANCE.selectorPicture(new PictureSelectorConfigures.Companion.Builder().isEnablePreviewImage(true).setWithCamera(false).isMEnableCrop(false).build(), new OnResultCallbackListener<LocalMedia>() { // from class: com.qiahao.nextvideo.room.activity.CustomThemeActivity$selectPictureShow$1
            public void onCancel() {
            }

            public void onResult(ArrayList<LocalMedia> result) {
                String compressPath;
                CustomThemeViewModel viewModel;
                ActivityGroupCustomThemeBinding binding;
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
                        viewModel = CustomThemeActivity.this.getViewModel();
                        viewModel.setMFilePath(fileCompat.getAbsolutePath());
                        binding = CustomThemeActivity.this.getBinding();
                        ImageView imageView = binding.addThemeImage;
                        Intrinsics.checkNotNullExpressionValue(imageView, "addThemeImage");
                        ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, fileCompat, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65531, (Object) null);
                    }
                }
            }
        });
    }

    @JvmStatic
    public static final void start(@NotNull Context context, @NotNull String str, int i) {
        INSTANCE.start(context, str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomThemeViewModel viewModel_delegate$lambda$0(CustomThemeActivity customThemeActivity) {
        return new ViewModelProvider(customThemeActivity).get(CustomThemeViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_group_custom_theme;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        double d;
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131361934) {
            if (id2 != 2131362039) {
                if (id2 == 2131362583 && FastClickUtils.INSTANCE.isFastClick() && getViewModel().getMCustomConfigUnPeekLiveData().getValue() != null && getViewModel().getMFilePath().length() != 0) {
                    Object value = getViewModel().getMCustomConfigUnPeekLiveData().getValue();
                    Intrinsics.checkNotNull(value);
                    int diamondNum = ((GroupThemeCustomConfig) value).getDiamondNum();
                    User user = UserStore.INSTANCE.getShared().getUser();
                    if (user != null) {
                        d = user.getDiamondNum();
                    } else {
                        d = 0.0d;
                    }
                    if (d >= diamondNum) {
                        getViewModel().uploadImage();
                        return;
                    } else {
                        WalletActivity.INSTANCE.start(this);
                        return;
                    }
                }
                return;
            }
            finish();
            return;
        }
        if (getViewModel().getMNowSize() >= 50) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String string = getString(2131954248);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast normal$default = HiloToasty.Companion.normal$default(companion, this, string, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
                return;
            }
            return;
        }
        selectPictureShow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        ((ActivityGroupCustomThemeBinding) getBinding()).setClick(this);
        CustomThemeViewModel viewModel = getViewModel();
        String stringExtra = getIntent().getStringExtra("groupId");
        if (stringExtra == null) {
            stringExtra = "";
        }
        viewModel.setMGroupId(stringExtra);
        getViewModel().setMNowSize(getIntent().getIntExtra("nowSize", 0));
        initObserve();
        getViewModel().getConfig();
        Toolbar toolbar = ((ActivityGroupCustomThemeBinding) getBinding()).titleBar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "titleBar");
        getStatusBarTopOrBottom(toolbar, new Function2() { // from class: com.qiahao.nextvideo.room.activity.s
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$1;
                onInitialize$lambda$1 = CustomThemeActivity.onInitialize$lambda$1(CustomThemeActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$1;
            }
        });
        setStatusBarIconColor(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onRoomEvent(@NotNull RoomEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getMEventId() == 214) {
            finish();
        }
    }
}
