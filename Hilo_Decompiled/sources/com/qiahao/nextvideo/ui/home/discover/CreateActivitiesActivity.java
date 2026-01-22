package com.qiahao.nextvideo.ui.home.discover;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.oudi.core.loading.ILoading;
import com.oudi.utils.date.DateUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.interfaceing.SelectInterface;
import com.qiahao.base_common.model.ActivityConfigData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.BaseSelectDialog;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.DatePickerBuilder;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.ViewUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.picture.PictureSelector;
import com.qiahao.base_common.utils.picture.PictureSelectorConfigures;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.CreateActivityData;
import com.qiahao.nextvideo.data.model.PurchaseFeeDetailsX;
import com.qiahao.nextvideo.data.service.AliCloudService;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ActivityCreateActivitiesBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qiahao.nextvideo.utilities.StorageUtils;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;
import com.tencent.mmkv.MMKV;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000e\u0010\u0004R\u001b\u0010\u0014\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b\t\u0010+\"\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/CreateActivitiesActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityCreateActivitiesBinding;", "<init>", "()V", "", "showBeginDialog", "uploadPicture", "createActivity", "getDefaultImage", "", "getLayoutResId", "()I", "onInitialize", "onDestroy", "Lcom/qiahao/nextvideo/ui/home/discover/CreateActivityImageAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/home/discover/CreateActivityImageAdapter;", "mAdapter", "Lcom/qiahao/nextvideo/data/model/CreateActivityData;", "createActivityData", "Lcom/qiahao/nextvideo/data/model/CreateActivityData;", "getCreateActivityData", "()Lcom/qiahao/nextvideo/data/model/CreateActivityData;", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Ljava/io/File;", "pictureFile", "Ljava/io/File;", "getPictureFile", "()Ljava/io/File;", "setPictureFile", "(Ljava/io/File;)V", "", "defaultImage", "Ljava/lang/String;", "()Ljava/lang/String;", "setDefaultImage", "(Ljava/lang/String;)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCreateActivitiesActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CreateActivitiesActivity.kt\ncom/qiahao/nextvideo/ui/home/discover/CreateActivitiesActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,373:1\n61#2,9:374\n61#2,9:383\n61#2,9:392\n61#2,9:401\n61#2,9:410\n61#2,9:419\n*S KotlinDebug\n*F\n+ 1 CreateActivitiesActivity.kt\ncom/qiahao/nextvideo/ui/home/discover/CreateActivitiesActivity\n*L\n94#1:374,9\n98#1:383,9\n129#1:392,9\n172#1:401,9\n188#1:410,9\n210#1:419,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CreateActivitiesActivity extends HiloBaseBindingActivity<ActivityCreateActivitiesBinding> {

    @NotNull
    public static final String GROUP_ID = "groupId";

    @Nullable
    private String defaultImage;

    @Nullable
    private File pictureFile;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.discover.s0
        public final Object invoke() {
            CreateActivityImageAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = CreateActivitiesActivity.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });

    @NotNull
    private final CreateActivityData createActivityData = new CreateActivityData(null, null, null, null, 0, 0, 0, null, 255, null);

    @NotNull
    private nd.a mCompositeDisposable = new nd.a();

    /* JADX INFO: Access modifiers changed from: private */
    public final void createActivity() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.crateActivity$default(UserService.INSTANCE.getShared(), this.createActivityData, null, 2, null), new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.a1
            public final Object invoke(Object obj) {
                Unit createActivity$lambda$14;
                createActivity$lambda$14 = CreateActivitiesActivity.createActivity$lambda$14(CreateActivitiesActivity.this, (ApiResponse) obj);
                return createActivity$lambda$14;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.b1
            public final Object invoke(Object obj) {
                Unit createActivity$lambda$15;
                createActivity$lambda$15 = CreateActivitiesActivity.createActivity$lambda$15(CreateActivitiesActivity.this, (Throwable) obj);
                return createActivity$lambda$15;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit createActivity$lambda$14(CreateActivitiesActivity createActivitiesActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ILoading.DefaultImpls.dismissLoading$default(createActivitiesActivity, (Integer) null, 1, (Object) null);
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, createActivitiesActivity, ResourcesKtxKt.getStringById(createActivitiesActivity, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        createActivitiesActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit createActivity$lambda$15(CreateActivitiesActivity createActivitiesActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        ILoading.DefaultImpls.dismissLoading$default(createActivitiesActivity, (Integer) null, 1, (Object) null);
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            int code = hiloException.getCode();
            if (code != 25001) {
                if (code != 25005) {
                    HiloToasty.Companion companion = HiloToasty.Companion;
                    String errorMessage = hiloException.getErrorMessage();
                    if (errorMessage == null) {
                        errorMessage = "";
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(companion, createActivitiesActivity, errorMessage, false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                } else {
                    Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, createActivitiesActivity, ResourcesKtxKt.getStringById(createActivitiesActivity, 2131951951), false, 4, (Object) null);
                    if (normal$default2 != null) {
                        normal$default2.show();
                    }
                }
            } else {
                Toast normal$default3 = HiloToasty.Companion.normal$default(HiloToasty.Companion, createActivitiesActivity, ResourcesKtxKt.getStringById(createActivitiesActivity, 2131951960), false, 4, (Object) null);
                if (normal$default3 != null) {
                    normal$default3.show();
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getDefaultImage$lambda$16(CreateActivitiesActivity createActivitiesActivity, ApiResponse apiResponse) {
        ArrayList recommendBanners;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ActivityConfigData activityConfigData = (ActivityConfigData) apiResponse.getData();
        if (activityConfigData != null && (recommendBanners = activityConfigData.getRecommendBanners()) != null && (!recommendBanners.isEmpty())) {
            CreateActivityImageAdapter mAdapter = createActivitiesActivity.getMAdapter();
            ActivityConfigData activityConfigData2 = (ActivityConfigData) apiResponse.getData();
            if (activityConfigData2 != null) {
                arrayList = activityConfigData2.getRecommendBanners();
            } else {
                arrayList = null;
            }
            mAdapter.setList(arrayList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit getDefaultImage$lambda$17(CreateActivitiesActivity createActivitiesActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(createActivitiesActivity, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, createActivitiesActivity, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CreateActivityImageAdapter mAdapter_delegate$lambda$0() {
        return new CreateActivityImageAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$1(CreateActivitiesActivity createActivitiesActivity, int i, int i2) {
        createActivitiesActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$4(CreateActivitiesActivity createActivitiesActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        createActivitiesActivity.defaultImage = (String) createActivitiesActivity.getMAdapter().getData().get(i);
        createActivitiesActivity.pictureFile = null;
        createActivitiesActivity.getBinding().createDefaultImage.setVisibility(8);
        QMUIRadiusImageView2 qMUIRadiusImageView2 = createActivitiesActivity.getBinding().createImage;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "createImage");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView2, createActivitiesActivity.defaultImage, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231930, 2131231930, (c5.g) null, 40958, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showBeginDialog() {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar3 = Calendar.getInstance();
        calendar2.setTimeInMillis(calendar2.getTimeInMillis() + 172800000);
        calendar3.setTimeInMillis(calendar.getTimeInMillis() + 900000);
        DatePickerBuilder rangDate = new DatePickerBuilder(this).setOnDateConfirmListener(new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.y0
            public final Object invoke(Object obj) {
                Unit showBeginDialog$lambda$9;
                showBeginDialog$lambda$9 = CreateActivitiesActivity.showBeginDialog$lambda$9(CreateActivitiesActivity.this, ((Long) obj).longValue());
                return showBeginDialog$lambda$9;
            }
        }).setToastyListener(new Function0() { // from class: com.qiahao.nextvideo.ui.home.discover.z0
            public final Object invoke() {
                Unit showBeginDialog$lambda$10;
                showBeginDialog$lambda$10 = CreateActivitiesActivity.showBeginDialog$lambda$10(CreateActivitiesActivity.this);
                return showBeginDialog$lambda$10;
            }
        }).setInterceptToasty(true).setType(new boolean[]{false, false, true, true, true, false}).setTitle("").setRangDate(calendar, calendar2);
        Intrinsics.checkNotNull(calendar3);
        rangDate.setDate(calendar3).create().t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit showBeginDialog$lambda$10(CreateActivitiesActivity createActivitiesActivity) {
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, createActivitiesActivity, ResourcesKtxKt.getStringById(createActivitiesActivity, 2131951960), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showBeginDialog$lambda$9(CreateActivitiesActivity createActivitiesActivity, long j) {
        createActivitiesActivity.createActivityData.setStartAt(j);
        createActivitiesActivity.getBinding().beginTimeText.setText(DateUtils.INSTANCE.formatDate("MM-dd HH:mm", Long.valueOf(j)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uploadPicture() {
        ILoading.DefaultImpls.showLoading$default(this, (Integer) null, (CharSequence) null, 3, (Object) null);
        String str = this.defaultImage;
        if (str != null) {
            CreateActivityData createActivityData = this.createActivityData;
            if (str == null) {
                str = "";
            }
            createActivityData.setBanner(str);
            createActivity();
            return;
        }
        final File file = this.pictureFile;
        if (file != null) {
            RxUtilsKt.observeOnMainThread$default(AliCloudService.uploadFileToAWS$default(AliCloudService.INSTANCE.getShared(), AliCloudService.OSS_FOLDER_GROUP, file, null, 4, null), new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.r0
                public final Object invoke(Object obj) {
                    Unit uploadPicture$lambda$13$lambda$11;
                    uploadPicture$lambda$13$lambda$11 = CreateActivitiesActivity.uploadPicture$lambda$13$lambda$11(CreateActivitiesActivity.this, file, (Pair) obj);
                    return uploadPicture$lambda$13$lambda$11;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.t0
                public final Object invoke(Object obj) {
                    Unit uploadPicture$lambda$13$lambda$12;
                    uploadPicture$lambda$13$lambda$12 = CreateActivitiesActivity.uploadPicture$lambda$13$lambda$12(CreateActivitiesActivity.this, (Throwable) obj);
                    return uploadPicture$lambda$13$lambda$12;
                }
            }, (Function0) null, false, 12, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit uploadPicture$lambda$13$lambda$11(CreateActivitiesActivity createActivitiesActivity, File file, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "data");
        if (((Boolean) pair.getFirst()).booleanValue()) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(createActivitiesActivity), (CoroutineContext) null, (CoroutineStart) null, new CreateActivitiesActivity$uploadPicture$1$1$1(file, createActivitiesActivity, pair, null), 3, (Object) null);
        } else {
            ILoading.DefaultImpls.dismissLoading$default(createActivitiesActivity, (Integer) null, 1, (Object) null);
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, createActivitiesActivity, ResourcesKtxKt.getStringById(createActivitiesActivity, 2131952667), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit uploadPicture$lambda$13$lambda$12(CreateActivitiesActivity createActivitiesActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        ILoading.DefaultImpls.dismissLoading$default(createActivitiesActivity, (Integer) null, 1, (Object) null);
        HiloToasty.Companion companion = HiloToasty.Companion;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(createActivitiesActivity, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, createActivitiesActivity, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public final CreateActivityData getCreateActivityData() {
        return this.createActivityData;
    }

    @Nullable
    public final String getDefaultImage() {
        return this.defaultImage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_create_activities;
    }

    @NotNull
    public final CreateActivityImageAdapter getMAdapter() {
        return (CreateActivityImageAdapter) this.mAdapter.getValue();
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @Nullable
    public final File getPictureFile() {
        return this.pictureFile;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        this.mCompositeDisposable.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        Integer num;
        super.onInitialize();
        String stringExtra = getIntent().getStringExtra("groupId");
        if (stringExtra == null) {
            stringExtra = "";
        }
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
        }
        ((ActivityCreateActivitiesBinding) getBinding()).desNumber.setText("(0/400)");
        this.createActivityData.setGroupId(stringExtra);
        View view = ((ActivityCreateActivitiesBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.home.discover.w0
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$1;
                onInitialize$lambda$1 = CreateActivitiesActivity.onInitialize$lambda$1(CreateActivitiesActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$1;
            }
        });
        setStatusBarIconColor(false);
        final AppCompatImageView appCompatImageView = ((ActivityCreateActivitiesBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.CreateActivitiesActivity$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.onBackPressed();
                }
            }
        });
        final FrameLayout frameLayout = ((ActivityCreateActivitiesBinding) getBinding()).beginTimeLayout;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.CreateActivitiesActivity$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                    this.showBeginDialog();
                }
            }
        });
        RecyclerView recyclerView = ((ActivityCreateActivitiesBinding) getBinding()).recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        ViewUtilsKt.addItemDecoration(recyclerView, 14.0f, 4.0f);
        ((ActivityCreateActivitiesBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.x0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                CreateActivitiesActivity.onInitialize$lambda$4(CreateActivitiesActivity.this, baseQuickAdapter, view2, i);
            }
        });
        ((ActivityCreateActivitiesBinding) getBinding()).activityDesEditText.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.ui.home.discover.CreateActivitiesActivity$onInitialize$5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            @SuppressLint({"SetTextI18n"})
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ActivityCreateActivitiesBinding binding;
                Integer num2;
                binding = CreateActivitiesActivity.this.getBinding();
                TextView textView = binding.desNumber;
                if (s != null) {
                    num2 = Integer.valueOf(s.length());
                } else {
                    num2 = null;
                }
                textView.setText("(" + num2 + "/400)");
            }
        });
        final FrameLayout frameLayout2 = ((ActivityCreateActivitiesBinding) getBinding()).imageLayout;
        frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.CreateActivitiesActivity$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout2) > j || (frameLayout2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout2, currentTimeMillis);
                    PictureSelectorConfigures build = new PictureSelectorConfigures.Companion.Builder().isEnablePreviewImage(true).setWithCamera(true).setCropWH(1416, RoomEvent.ROOM_MIC_EMOJI).build();
                    PictureSelector pictureSelector = PictureSelector.INSTANCE;
                    final CreateActivitiesActivity createActivitiesActivity = this;
                    pictureSelector.selectorPicture(build, new OnResultCallbackListener<LocalMedia>() { // from class: com.qiahao.nextvideo.ui.home.discover.CreateActivitiesActivity$onInitialize$6$1
                        public void onCancel() {
                        }

                        public void onResult(ArrayList<LocalMedia> result) {
                            String compressPath;
                            ActivityCreateActivitiesBinding binding;
                            ActivityCreateActivitiesBinding binding2;
                            ActivityCreateActivitiesBinding binding3;
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
                                    CreateActivitiesActivity.this.setPictureFile(fileCompat);
                                    CreateActivitiesActivity.this.setDefaultImage(null);
                                    binding = CreateActivitiesActivity.this.getBinding();
                                    binding.createDefaultImage.setVisibility(8);
                                    binding2 = CreateActivitiesActivity.this.getBinding();
                                    binding2.createImage.setVisibility(0);
                                    binding3 = CreateActivitiesActivity.this.getBinding();
                                    QMUIRadiusImageView2 qMUIRadiusImageView2 = binding3.createImage;
                                    Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "createImage");
                                    ImageKtxKt.loadImage$default(qMUIRadiusImageView2, (String) null, (Uri) null, fileCompat, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231930, 2131231930, (c5.g) null, 40955, (Object) null);
                                }
                            }
                        }
                    });
                }
            }
        });
        final FrameLayout frameLayout3 = ((ActivityCreateActivitiesBinding) getBinding()).selectLayout;
        frameLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.CreateActivitiesActivity$onInitialize$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout3) > j || (frameLayout3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout3, currentTimeMillis);
                    final ArrayList arrayList = new ArrayList();
                    arrayList.add(ResourcesKtxKt.getStringById(this, 2131951971));
                    arrayList.add(ResourcesKtxKt.getStringById(this, 2131951974));
                    arrayList.add(ResourcesKtxKt.getStringById(this, 2131951973));
                    arrayList.add(ResourcesKtxKt.getStringById(this, 2131951975));
                    BaseSelectDialog dataListOfString = new BaseSelectDialog(this).setDataListOfString(arrayList);
                    final CreateActivitiesActivity createActivitiesActivity = this;
                    dataListOfString.setListener(new SelectInterface() { // from class: com.qiahao.nextvideo.ui.home.discover.CreateActivitiesActivity$onInitialize$7$1
                        public void onSelect(int index) {
                            ActivityCreateActivitiesBinding binding;
                            CreateActivitiesActivity.this.getCreateActivityData().setActivityType(index);
                            binding = CreateActivitiesActivity.this.getBinding();
                            binding.selectText.setText(arrayList.get(index));
                        }
                    }).show();
                }
            }
        });
        final FrameLayout frameLayout4 = ((ActivityCreateActivitiesBinding) getBinding()).timeDurationLayout;
        frameLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.CreateActivitiesActivity$onInitialize$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout4) > j || (frameLayout4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout4, currentTimeMillis);
                    final ArrayList arrayList = new ArrayList();
                    arrayList.add(ResourcesKtxKt.getStringById(this, 2131951958));
                    arrayList.add(ResourcesKtxKt.getStringById(this, 2131951970));
                    BaseSelectDialog dataListOfString = new BaseSelectDialog(this).setDataListOfString(arrayList);
                    final CreateActivitiesActivity createActivitiesActivity = this;
                    dataListOfString.setListener(new SelectInterface() { // from class: com.qiahao.nextvideo.ui.home.discover.CreateActivitiesActivity$onInitialize$8$1
                        public void onSelect(int index) {
                            ActivityCreateActivitiesBinding binding;
                            if (index == 0) {
                                CreateActivitiesActivity.this.getCreateActivityData().setDuration(MMKV.ExpireInHour);
                            } else {
                                CreateActivitiesActivity.this.getCreateActivityData().setDuration(7200);
                            }
                            binding = CreateActivitiesActivity.this.getBinding();
                            binding.timeDurationText.setText(arrayList.get(index));
                        }
                    }).show();
                }
            }
        });
        TextView textView = ((ActivityCreateActivitiesBinding) getBinding()).interestedText;
        String stringById = ResourcesKtxKt.getStringById(this, 2131951962);
        PurchaseFeeDetailsX purchaseFeeDetail = PurchaseService.INSTANCE.getShared().getPurchaseFeeDetail();
        if (purchaseFeeDetail != null) {
            num = Integer.valueOf(purchaseFeeDetail.getGroupActivityFee());
        } else {
            num = null;
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{String.valueOf(num)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        final LinearLayout linearLayout = ((ActivityCreateActivitiesBinding) getBinding()).interested;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.CreateActivitiesActivity$onInitialize$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActivityCreateActivitiesBinding binding;
                ActivityCreateActivitiesBinding binding2;
                long j2;
                int i;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout) > j || (linearLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(linearLayout, currentTimeMillis);
                    CreateActivityData createActivityData = this.getCreateActivityData();
                    binding = this.getBinding();
                    createActivityData.setTheme(String.valueOf(binding.activityThemeEditText.getText()));
                    CreateActivityData createActivityData2 = this.getCreateActivityData();
                    binding2 = this.getBinding();
                    createActivityData2.setDesc(String.valueOf(binding2.activityDesEditText.getText()));
                    if (this.getCreateActivityData().checkInfo() && (this.getPictureFile() != null || this.getDefaultImage() != null)) {
                        User user = UserStore.INSTANCE.getShared().getUser();
                        if (user != null) {
                            j2 = (long) user.getDiamondNum();
                        } else {
                            j2 = 0;
                        }
                        PurchaseFeeDetailsX purchaseFeeDetail2 = PurchaseService.INSTANCE.getShared().getPurchaseFeeDetail();
                        if (purchaseFeeDetail2 != null) {
                            i = purchaseFeeDetail2.getGroupActivityFee();
                        } else {
                            i = 0;
                        }
                        if (j2 >= i) {
                            this.uploadPicture();
                            return;
                        }
                        TipDialog confirmContent = new TipDialog(this).setTipContent(ResourcesKtxKt.getStringById(this, 2131953126)).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131952373));
                        final CreateActivitiesActivity createActivitiesActivity = this;
                        confirmContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.discover.CreateActivitiesActivity$onInitialize$9$1
                            public void cancel() {
                                OnCommonDialogListener.DefaultImpls.cancel(this);
                            }

                            public void confirm() {
                                WalletActivity.Companion.start(CreateActivitiesActivity.this);
                            }
                        }).show();
                        return;
                    }
                    HiloToasty.Companion companion = HiloToasty.Companion;
                    BaseActivity baseActivity = this;
                    Toast normal$default = HiloToasty.Companion.normal$default(companion, baseActivity, ResourcesKtxKt.getStringById(baseActivity, 2131951955), false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                }
            }
        });
        getDefaultImage();
    }

    public final void setDefaultImage(@Nullable String str) {
        this.defaultImage = str;
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void setPictureFile(@Nullable File file) {
        this.pictureFile = file;
    }

    private final void getDefaultImage() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().activityConfig(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.u0
            public final Object invoke(Object obj) {
                Unit defaultImage$lambda$16;
                defaultImage$lambda$16 = CreateActivitiesActivity.getDefaultImage$lambda$16(CreateActivitiesActivity.this, (ApiResponse) obj);
                return defaultImage$lambda$16;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.v0
            public final Object invoke(Object obj) {
                Unit defaultImage$lambda$17;
                defaultImage$lambda$17 = CreateActivitiesActivity.getDefaultImage$lambda$17(CreateActivitiesActivity.this, (Throwable) obj);
                return defaultImage$lambda$17;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }
}
