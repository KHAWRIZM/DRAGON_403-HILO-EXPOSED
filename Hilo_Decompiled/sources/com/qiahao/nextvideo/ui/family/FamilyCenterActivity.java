package com.qiahao.nextvideo.ui.family;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.opensource.svgaplayer.SVGAImageView;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.HiloResUtilsKt;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.family.FamilyCenterData;
import com.qiahao.nextvideo.data.family.FamilyCenterMember;
import com.qiahao.nextvideo.data.family.FamilyRoomInfo;
import com.qiahao.nextvideo.data.family.FamilyWheel;
import com.qiahao.nextvideo.databinding.ActivityFamilyCenterBinding;
import com.qiahao.nextvideo.databinding.ActivityFamilyCenterHeaderBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.ui.family.FamilyMoreDialog;
import com.qiahao.nextvideo.ui.family.FamilyStarActivity;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.ui.videocall.HelperDialog;
import com.qiahao.nextvideo.ui.webview.DefaultWebActivity;
import com.qiahao.nextvideo.utilities.HiloResUtilKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.therouter.TheRouter;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.common.AgooConstants;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0007J\u0012\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0003J\b\u0010'\u001a\u00020\u001fH\u0002J\b\u0010(\u001a\u00020\u001fH\u0014J\b\u0010)\u001a\u00020\u001fH\u0002J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0002J\u0016\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020\u001dJ\u0010\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u0006H\u0002J\b\u00102\u001a\u00020\u001fH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001a¨\u00064"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyCenterActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityFamilyCenterBinding;", "<init>", "()V", "familyId", "", "viewModel", "Lcom/qiahao/nextvideo/ui/family/FamilyCenterViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/family/FamilyCenterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mHeaderBinding", "Lcom/qiahao/nextvideo/databinding/ActivityFamilyCenterHeaderBinding;", "getMHeaderBinding", "()Lcom/qiahao/nextvideo/databinding/ActivityFamilyCenterHeaderBinding;", "mHeaderBinding$delegate", "mRoomAdapter", "Lcom/qiahao/nextvideo/ui/family/FamilyCenterAdapter;", "getMRoomAdapter", "()Lcom/qiahao/nextvideo/ui/family/FamilyCenterAdapter;", "mRoomAdapter$delegate", "mMemberAdapter", "Lcom/qiahao/nextvideo/ui/family/FamilyCenterMembersAdapter;", "getMMemberAdapter", "()Lcom/qiahao/nextvideo/ui/family/FamilyCenterMembersAdapter;", "mMemberAdapter$delegate", "getLayoutResId", "", "onInitialize", "", "initData", "onDisbandFamilyEvent", "event", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "refreshHeader", "familyCenterData", "Lcom/qiahao/nextvideo/data/family/FamilyCenterData;", "initView", "onResume", "initHeader", "startUser", SupportGiftRankActivity.EXTERNAL_ID, "", "quitFamily", "userExtId", "type", "applyFamily", AgooConstants.MESSAGE_ID, "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFamilyCenterActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FamilyCenterActivity.kt\ncom/qiahao/nextvideo/ui/family/FamilyCenterActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,607:1\n1#2:608\n61#3,9:609\n61#3,9:618\n61#3,9:629\n61#3,9:638\n61#3,9:647\n61#3,9:656\n61#3,9:665\n61#3,9:674\n61#3,9:683\n61#3,9:692\n61#3,9:701\n61#3,9:710\n61#3,9:719\n61#3,9:728\n61#3,9:737\n1869#4,2:627\n*S KotlinDebug\n*F\n+ 1 FamilyCenterActivity.kt\ncom/qiahao/nextvideo/ui/family/FamilyCenterActivity\n*L\n174#1:609,9\n221#1:618,9\n301#1:629,9\n332#1:638,9\n341#1:647,9\n347#1:656,9\n350#1:665,9\n375#1:674,9\n379#1:683,9\n491#1:692,9\n499#1:701,9\n506#1:710,9\n513#1:719,9\n520#1:728,9\n523#1:737,9\n231#1:627,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyCenterActivity extends HiloBaseBindingActivity<ActivityFamilyCenterBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String FAMILY_ID = "familyID";
    private long familyId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.d0
        public final Object invoke() {
            FamilyCenterViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = FamilyCenterActivity.viewModel_delegate$lambda$0(FamilyCenterActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mHeaderBinding$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mHeaderBinding = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.e0
        public final Object invoke() {
            ActivityFamilyCenterHeaderBinding mHeaderBinding_delegate$lambda$1;
            mHeaderBinding_delegate$lambda$1 = FamilyCenterActivity.mHeaderBinding_delegate$lambda$1(FamilyCenterActivity.this);
            return mHeaderBinding_delegate$lambda$1;
        }
    });

    /* renamed from: mRoomAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mRoomAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.f0
        public final Object invoke() {
            FamilyCenterAdapter mRoomAdapter_delegate$lambda$2;
            mRoomAdapter_delegate$lambda$2 = FamilyCenterActivity.mRoomAdapter_delegate$lambda$2();
            return mRoomAdapter_delegate$lambda$2;
        }
    });

    /* renamed from: mMemberAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMemberAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.g0
        public final Object invoke() {
            FamilyCenterMembersAdapter mMemberAdapter_delegate$lambda$3;
            mMemberAdapter_delegate$lambda$3 = FamilyCenterActivity.mMemberAdapter_delegate$lambda$3();
            return mMemberAdapter_delegate$lambda$3;
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyCenterActivity$Companion;", "", "<init>", "()V", "FAMILY_ID", "", "startActivity", "", "context", "Landroid/content/Context;", "familyID", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context, long familyID) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) FamilyCenterActivity.class);
            intent.putExtra("familyID", familyID);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyFamily(long id2) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().applyFamily(id2), new Function1() { // from class: com.qiahao.nextvideo.ui.family.k0
            public final Object invoke(Object obj) {
                Unit applyFamily$lambda$45;
                applyFamily$lambda$45 = FamilyCenterActivity.applyFamily$lambda$45(FamilyCenterActivity.this, (ApiResponse) obj);
                return applyFamily$lambda$45;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.family.l0
            public final Object invoke(Object obj) {
                Unit applyFamily$lambda$46;
                applyFamily$lambda$46 = FamilyCenterActivity.applyFamily$lambda$46(FamilyCenterActivity.this, (Throwable) obj);
                return applyFamily$lambda$46;
            }
        }, (Function0) null, false, 12, (Object) null), getViewModel().getMCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyFamily$lambda$45(FamilyCenterActivity familyCenterActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        familyCenterActivity.getViewModel().familyInfo(familyCenterActivity.familyId);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit applyFamily$lambda$46(FamilyCenterActivity familyCenterActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(familyCenterActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, familyCenterActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    private final ActivityFamilyCenterHeaderBinding getMHeaderBinding() {
        Object value = this.mHeaderBinding.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ActivityFamilyCenterHeaderBinding) value;
    }

    private final FamilyCenterMembersAdapter getMMemberAdapter() {
        return (FamilyCenterMembersAdapter) this.mMemberAdapter.getValue();
    }

    private final FamilyCenterAdapter getMRoomAdapter() {
        return (FamilyCenterAdapter) this.mRoomAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FamilyCenterViewModel getViewModel() {
        return (FamilyCenterViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getFamilyInfo().observe(this, new FamilyCenterActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.h0
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = FamilyCenterActivity.initData$lambda$4(FamilyCenterActivity.this, (FamilyCenterData) obj);
                return initData$lambda$4;
            }
        }));
        getViewModel().getFamilyRoomList().observe(this, new FamilyCenterActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.i0
            public final Object invoke(Object obj) {
                Unit initData$lambda$6;
                initData$lambda$6 = FamilyCenterActivity.initData$lambda$6(FamilyCenterActivity.this, (List) obj);
                return initData$lambda$6;
            }
        }));
        getViewModel().getError().observe(this, new FamilyCenterActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.j0
            public final Object invoke(Object obj) {
                Unit initData$lambda$7;
                initData$lambda$7 = FamilyCenterActivity.initData$lambda$7(FamilyCenterActivity.this, (Throwable) obj);
                return initData$lambda$7;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(FamilyCenterActivity familyCenterActivity, FamilyCenterData familyCenterData) {
        familyCenterActivity.refreshHeader(familyCenterData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$6(FamilyCenterActivity familyCenterActivity, List list) {
        if (familyCenterActivity.getViewModel().getFamilyRoomListData().isOnePage()) {
            familyCenterActivity.getMRoomAdapter().setList(list);
            if (HiloUtils.INSTANCE.isEmpty(list)) {
                familyCenterActivity.getMHeaderBinding().statusView.showEmpty();
                familyCenterActivity.getMHeaderBinding().statusView.setVisibility(0);
            } else {
                familyCenterActivity.getMHeaderBinding().statusView.setVisibility(8);
            }
        } else if (list != null) {
            familyCenterActivity.getMRoomAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$7(FamilyCenterActivity familyCenterActivity, Throwable th) {
        familyCenterActivity.getMHeaderBinding().statusView.showError();
        familyCenterActivity.getMHeaderBinding().statusView.setVisibility(0);
        familyCenterActivity.getMRoomAdapter().setList((Collection) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initHeader() {
        Toolbar toolbar = ((ActivityFamilyCenterBinding) getBinding()).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        setStatusBarTopOrBottom(toolbar, false);
        ConstraintLayout constraintLayout = getMHeaderBinding().famous.constraintLayout;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        constraintLayout.setBackground(ShapeUtil.createShape$default(shapeUtil, this, 2131100017, 2131100017, 10, (GradientDrawable.Orientation) null, false, 48, (Object) null));
        getMHeaderBinding().active.constraintLayout.setBackground(ShapeUtil.createShape$default(shapeUtil, this, 2131099975, 2131099975, 10, (GradientDrawable.Orientation) null, false, 48, (Object) null));
        getMHeaderBinding().charm.constraintLayout.setBackground(ShapeUtil.createShape$default(shapeUtil, this, 2131100013, 2131100013, 10, (GradientDrawable.Orientation) null, false, 48, (Object) null));
        if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
            getMHeaderBinding().famous.typeText.setBackground(ShapeUtil.createShape$default(shapeUtil, this, 2131100007, 2131099998, 0, 10, 0, 10, (GradientDrawable.Orientation) null, 128, (Object) null));
            getMHeaderBinding().active.typeText.setBackground(ShapeUtil.createShape$default(shapeUtil, this, 2131099893, 2131099875, 0, 10, 0, 10, (GradientDrawable.Orientation) null, 128, (Object) null));
            getMHeaderBinding().charm.typeText.setBackground(ShapeUtil.createShape$default(shapeUtil, this, 2131100000, 2131099990, 0, 10, 0, 10, (GradientDrawable.Orientation) null, 128, (Object) null));
        } else {
            getMHeaderBinding().famous.typeText.setBackground(ShapeUtil.createShape$default(shapeUtil, this, 2131100007, 2131099998, 10, 0, 10, 0, (GradientDrawable.Orientation) null, 128, (Object) null));
            getMHeaderBinding().active.typeText.setBackground(ShapeUtil.createShape$default(shapeUtil, this, 2131099893, 2131099875, 10, 0, 10, 0, (GradientDrawable.Orientation) null, 128, (Object) null));
            getMHeaderBinding().charm.typeText.setBackground(ShapeUtil.createShape$default(shapeUtil, this, 2131100000, 2131099990, 10, 0, 10, 0, (GradientDrawable.Orientation) null, 128, (Object) null));
        }
        getMHeaderBinding().famous.typeText.setText(ResourcesKtxKt.getStringById(this, 2131952697));
        getMHeaderBinding().active.typeText.setText(ResourcesKtxKt.getStringById(this, 2131951944));
        getMHeaderBinding().charm.typeText.setText(ResourcesKtxKt.getStringById(this, 2131952206));
        getMHeaderBinding().famous.headerBg.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.family_famous_header));
        getMHeaderBinding().active.headerBg.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.family_active_header));
        getMHeaderBinding().charm.headerBg.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.family_charm_header));
        final ConstraintLayout constraintLayout2 = getMHeaderBinding().familyMemberLayout;
        final long j = 800;
        constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyCenterActivity$initHeader$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyCenterViewModel viewModel;
                FamilyInfo info;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout2) > j || (constraintLayout2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout2, currentTimeMillis);
                    ConstraintLayout constraintLayout3 = constraintLayout2;
                    viewModel = this.getViewModel();
                    FamilyCenterData familyCenterData = (FamilyCenterData) viewModel.getFamilyInfo().getValue();
                    if (familyCenterData != null && (info = familyCenterData.getInfo()) != null) {
                        FamilyMembersActivity.INSTANCE.startActivity(this, info);
                    }
                }
            }
        });
        final View root = getMHeaderBinding().famous.getRoot();
        root.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyCenterActivity$initHeader$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyCenterViewModel viewModel;
                ArrayList<FamilyCenterMember> stars;
                String str;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                    viewModel = this.getViewModel();
                    FamilyCenterData familyCenterData = (FamilyCenterData) viewModel.getFamilyInfo().getValue();
                    if (familyCenterData != null && (stars = familyCenterData.getStars()) != null) {
                        for (FamilyCenterMember familyCenterMember : stars) {
                            Integer rankingType = familyCenterMember.getRankingType();
                            if (rankingType != null && rankingType.intValue() == 1) {
                                FamilyCenterActivity familyCenterActivity = this;
                                User user = familyCenterMember.getUser();
                                if (user == null || (str = user.getExternalId()) == null) {
                                    str = "";
                                }
                                familyCenterActivity.startUser(str);
                            }
                        }
                    }
                }
            }
        });
        final View root2 = getMHeaderBinding().active.getRoot();
        root2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyCenterActivity$initHeader$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyCenterViewModel viewModel;
                ArrayList<FamilyCenterMember> stars;
                String str;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root2) > j || (root2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root2, currentTimeMillis);
                    viewModel = this.getViewModel();
                    FamilyCenterData familyCenterData = (FamilyCenterData) viewModel.getFamilyInfo().getValue();
                    if (familyCenterData != null && (stars = familyCenterData.getStars()) != null) {
                        for (FamilyCenterMember familyCenterMember : stars) {
                            Integer rankingType = familyCenterMember.getRankingType();
                            if (rankingType != null && rankingType.intValue() == 2) {
                                FamilyCenterActivity familyCenterActivity = this;
                                User user = familyCenterMember.getUser();
                                if (user == null || (str = user.getExternalId()) == null) {
                                    str = "";
                                }
                                familyCenterActivity.startUser(str);
                            }
                        }
                    }
                }
            }
        });
        final View root3 = getMHeaderBinding().charm.getRoot();
        root3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyCenterActivity$initHeader$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyCenterViewModel viewModel;
                ArrayList<FamilyCenterMember> stars;
                String str;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root3) > j || (root3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root3, currentTimeMillis);
                    viewModel = this.getViewModel();
                    FamilyCenterData familyCenterData = (FamilyCenterData) viewModel.getFamilyInfo().getValue();
                    if (familyCenterData != null && (stars = familyCenterData.getStars()) != null) {
                        for (FamilyCenterMember familyCenterMember : stars) {
                            Integer rankingType = familyCenterMember.getRankingType();
                            if (rankingType != null && rankingType.intValue() == 3) {
                                FamilyCenterActivity familyCenterActivity = this;
                                User user = familyCenterMember.getUser();
                                if (user == null || (str = user.getExternalId()) == null) {
                                    str = "";
                                }
                                familyCenterActivity.startUser(str);
                            }
                        }
                    }
                }
            }
        });
        final ConstraintLayout constraintLayout3 = getMHeaderBinding().familyStarLayout;
        constraintLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyCenterActivity$initHeader$$inlined$singleClick$default$5
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [android.content.Context, com.qiahao.nextvideo.ui.family.FamilyCenterActivity] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyCenterViewModel viewModel;
                long j2;
                FamilyInfo info;
                Long id2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout3) > j || (constraintLayout3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout3, currentTimeMillis);
                    ConstraintLayout constraintLayout4 = constraintLayout3;
                    FamilyStarActivity.Companion companion = FamilyStarActivity.INSTANCE;
                    ?? r0 = this;
                    viewModel = r0.getViewModel();
                    FamilyCenterData familyCenterData = (FamilyCenterData) viewModel.getFamilyInfo().getValue();
                    if (familyCenterData != null && (info = familyCenterData.getInfo()) != null && (id2 = info.getId()) != null) {
                        j2 = id2.longValue();
                    } else {
                        j2 = 0;
                    }
                    companion.startActivity(r0, j2, 0);
                }
            }
        });
        final AppCompatTextView appCompatTextView = getMHeaderBinding().familyWelcome;
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyCenterActivity$initHeader$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyCenterViewModel viewModel;
                String str;
                FamilyInfo info;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatTextView) > j || (appCompatTextView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatTextView, currentTimeMillis);
                    AppCompatTextView appCompatTextView2 = appCompatTextView;
                    HelperDialog hideCancel = new HelperDialog(this).hideCancel(true);
                    viewModel = this.getViewModel();
                    FamilyCenterData familyCenterData = (FamilyCenterData) viewModel.getFamilyInfo().getValue();
                    if (familyCenterData == null || (info = familyCenterData.getInfo()) == null || (str = info.getDeclaration()) == null) {
                        str = "";
                    }
                    hideCancel.setTipContent(str).show();
                }
            }
        });
        getMHeaderBinding().memberRecycleView.setAdapter(getMMemberAdapter());
        getMHeaderBinding().memberRecycleView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.qiahao.nextvideo.ui.family.FamilyCenterActivity$initHeader$7
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                super.getItemOffsets(outRect, view, parent, state);
                int childLayoutPosition = parent.getChildLayoutPosition(view);
                int itemCount = state.getItemCount() - 1;
                if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
                    outRect.right = UiKtxKt.toPX(14);
                    if (childLayoutPosition == itemCount) {
                        outRect.left = UiKtxKt.toPX(14);
                        return;
                    }
                    return;
                }
                outRect.left = UiKtxKt.toPX(14);
                if (childLayoutPosition == itemCount) {
                    outRect.right = UiKtxKt.toPX(14);
                }
            }
        });
        FamilyCenterAdapter mRoomAdapter = getMRoomAdapter();
        View root4 = getMHeaderBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root4, "getRoot(...)");
        BaseQuickAdapter.addHeaderView$default(mRoomAdapter, root4, 0, 0, 6, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        View view = getMHeaderBinding().diamondBg;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        view.setBackground(ShapeUtil.createShape$default(shapeUtil, "#FFF6C4", "#FFDA75", 10, (GradientDrawable.Orientation) null, 8, (Object) null));
        getMHeaderBinding().numberBg.setBackground(ShapeUtil.createShape$default(shapeUtil, "#FFF6C4", "#FFDA75", 10, (GradientDrawable.Orientation) null, 8, (Object) null));
        setStatusBarIconColor(false);
        long longExtra = getIntent().getLongExtra("familyID", 0L);
        this.familyId = longExtra;
        if (longExtra == 0) {
            finish();
        }
        final AppCompatImageView appCompatImageView = ((ActivityFamilyCenterBinding) getBinding()).setting;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyCenterActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FamilyCenterViewModel viewModel;
                FamilyInfo info;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    viewModel = this.getViewModel();
                    FamilyCenterData familyCenterData = (FamilyCenterData) viewModel.getFamilyInfo().getValue();
                    if (familyCenterData != null && (info = familyCenterData.getInfo()) != null) {
                        int role = info.getRole();
                        if (role != 1) {
                            if (role != 2) {
                                if (role != 3) {
                                    return;
                                }
                            } else {
                                FamilySettingActivity.INSTANCE.startActivity(this, info);
                                return;
                            }
                        }
                        FamilyMoreDialog familyMoreDialog = new FamilyMoreDialog(this, false, false, false, true, false);
                        final FamilyCenterActivity familyCenterActivity = this;
                        familyMoreDialog.setListener(new FamilyMoreDialog.FamilyMoreDialogListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyCenterActivity$initView$1$1$1
                            @Override // com.qiahao.nextvideo.ui.family.FamilyMoreDialog.FamilyMoreDialogListener
                            public void clickType(String type) {
                                String str;
                                Intrinsics.checkNotNullParameter(type, "type");
                                if (Intrinsics.areEqual(type, "exit")) {
                                    FamilyCenterActivity familyCenterActivity2 = FamilyCenterActivity.this;
                                    User user = UserStore.INSTANCE.getShared().getUser();
                                    if (user == null || (str = user.getExternalId()) == null) {
                                        str = "";
                                    }
                                    familyCenterActivity2.quitFamily(str, 1);
                                }
                            }
                        }).show();
                    }
                }
            }
        });
        final AppCompatImageView appCompatImageView2 = ((ActivityFamilyCenterBinding) getBinding()).share;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyCenterActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FamilyCenterViewModel viewModel;
                FamilyInfo info;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView2) > j || (appCompatImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView2, currentTimeMillis);
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    viewModel = this.getViewModel();
                    FamilyCenterData familyCenterData = (FamilyCenterData) viewModel.getFamilyInfo().getValue();
                    if (familyCenterData != null && (info = familyCenterData.getInfo()) != null) {
                        FamilyShareActivity.INSTANCE.startActivity(this, info);
                    }
                }
            }
        });
        final SVGAImageView sVGAImageView = ((ActivityFamilyCenterBinding) getBinding()).svgaView;
        sVGAImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyCenterActivity$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(sVGAImageView) > j || (sVGAImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(sVGAImageView, currentTimeMillis);
                    SVGAImageView sVGAImageView2 = sVGAImageView;
                    String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "FAMILY_WHEEL_URL", "", (String) null, 4, (Object) null);
                    AppService appService = (AppService) TheRouter.get(AppService.class, new Object[0]);
                    if (appService != null) {
                        appService.openCommonLink(str);
                    }
                }
            }
        });
        final View view2 = getMHeaderBinding().diamondBg;
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyCenterActivity$initView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(view2) > j || (view2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(view2, currentTimeMillis);
                    new DailyRecordDialog(this).show();
                }
            }
        });
        final View view3 = getMHeaderBinding().numberBg;
        view3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyCenterActivity$initView$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(view3) > j || (view3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(view3, currentTimeMillis);
                    new DailyRecordDialog(this).show();
                }
            }
        });
        ((ActivityFamilyCenterBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        ((ActivityFamilyCenterBinding) getBinding()).recyclerView.setAdapter(getMRoomAdapter());
        BaseListData.registerStatusLayoutAndRefreshLayout$default(getViewModel().getFamilyRoomListData(), ((ActivityFamilyCenterBinding) getBinding()).refreshLayout, (SuperStatusView) null, 2, (Object) null);
        ((ActivityFamilyCenterBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.family.m0
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                FamilyCenterActivity.initView$lambda$22(FamilyCenterActivity.this, fVar);
            }
        });
        ((ActivityFamilyCenterBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.family.n0
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                FamilyCenterActivity.initView$lambda$23(FamilyCenterActivity.this, fVar);
            }
        });
        getMHeaderBinding().statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyCenterActivity$initView$8
            public void onRetry(IStatusView statusView, Status status) {
                FamilyCenterViewModel viewModel;
                FamilyCenterViewModel viewModel2;
                long j2;
                FamilyCenterViewModel viewModel3;
                long j3;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                viewModel = FamilyCenterActivity.this.getViewModel();
                viewModel.getFamilyRoomListData().resetPage();
                viewModel2 = FamilyCenterActivity.this.getViewModel();
                j2 = FamilyCenterActivity.this.familyId;
                viewModel2.familyRoomList(j2);
                viewModel3 = FamilyCenterActivity.this.getViewModel();
                j3 = FamilyCenterActivity.this.familyId;
                viewModel3.familyInfo(j3);
            }
        });
        final AppCompatImageView appCompatImageView3 = ((ActivityFamilyCenterBinding) getBinding()).backImageView;
        appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyCenterActivity$initView$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView3) > j || (appCompatImageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView3, currentTimeMillis);
                    AppCompatImageView appCompatImageView4 = appCompatImageView3;
                    this.finish();
                }
            }
        });
        final TextView textView = ((ActivityFamilyCenterBinding) getBinding()).applyButton;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyCenterActivity$initView$$inlined$singleClick$default$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                FamilyCenterViewModel viewModel;
                FamilyInfo info;
                Long id2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    viewModel = this.getViewModel();
                    FamilyCenterData familyCenterData = (FamilyCenterData) viewModel.getFamilyInfo().getValue();
                    if (familyCenterData != null && (info = familyCenterData.getInfo()) != null && info.getRole() == 0 && !info.isApply() && (id2 = info.getId()) != null) {
                        this.applyFamily(id2.longValue());
                    }
                }
            }
        });
        getMMemberAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.family.o0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view4, int i) {
                FamilyCenterActivity.initView$lambda$28(FamilyCenterActivity.this, baseQuickAdapter, view4, i);
            }
        });
        getMRoomAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.family.p0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view4, int i) {
                FamilyCenterActivity.initView$lambda$29(FamilyCenterActivity.this, baseQuickAdapter, view4, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$22(FamilyCenterActivity familyCenterActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        familyCenterActivity.getViewModel().getFamilyRoomListData().resetPage();
        familyCenterActivity.getViewModel().familyRoomList(familyCenterActivity.familyId);
        familyCenterActivity.getViewModel().familyInfo(familyCenterActivity.familyId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$23(FamilyCenterActivity familyCenterActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        familyCenterActivity.getViewModel().familyRoomList(familyCenterActivity.familyId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$28(FamilyCenterActivity familyCenterActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        User user = ((FamilyCenterMember) familyCenterActivity.getMMemberAdapter().getData().get(i)).getUser();
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        familyCenterActivity.startUser(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$29(FamilyCenterActivity familyCenterActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, ((FamilyRoomInfo) familyCenterActivity.getMRoomAdapter().getData().get(i)).getGroupId(), null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ActivityFamilyCenterHeaderBinding mHeaderBinding_delegate$lambda$1(FamilyCenterActivity familyCenterActivity) {
        return (ActivityFamilyCenterHeaderBinding) androidx.databinding.g.h(LayoutInflater.from(familyCenterActivity), R.layout.activity_family_center_header, (ViewGroup) null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FamilyCenterMembersAdapter mMemberAdapter_delegate$lambda$3() {
        return new FamilyCenterMembersAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FamilyCenterAdapter mRoomAdapter_delegate$lambda$2() {
        return new FamilyCenterAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit quitFamily$lambda$42(FamilyCenterActivity familyCenterActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        familyCenterActivity.getViewModel().familyInfo(familyCenterActivity.familyId);
        HiloBaseActivity.dismissProgressDialog$default(familyCenterActivity, false, new Function0() { // from class: com.qiahao.nextvideo.ui.family.y
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit quitFamily$lambda$44(FamilyCenterActivity familyCenterActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(familyCenterActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, familyCenterActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        HiloBaseActivity.dismissProgressDialog$default(familyCenterActivity, false, new Function0() { // from class: com.qiahao.nextvideo.ui.family.c0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    private final void refreshHeader(final FamilyCenterData familyCenterData) {
        String str;
        int i;
        String str2;
        String str3;
        int i2;
        String str4;
        int i3;
        String str5;
        String str6;
        Drawable drawable;
        Drawable drawable2;
        int i4;
        Object obj;
        double d;
        double d2;
        Integer num;
        int i5;
        String str7;
        String str8;
        Integer num2;
        Integer num3;
        long j;
        Object obj2;
        Object obj3;
        int i6;
        Long diamond;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        Long nextExp;
        Long exp;
        String l;
        Long nextExp2;
        Long exp2;
        Integer grade;
        Integer grade2;
        String nameplate;
        Integer grade3;
        boolean z = true;
        if (familyCenterData != null) {
            AppCompatTextView appCompatTextView = getMHeaderBinding().familyName;
            FamilyInfo info = familyCenterData.getInfo();
            if (info == null || (str = info.getName()) == null) {
                str = "";
            }
            appCompatTextView.setText(str);
            IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding = getMHeaderBinding().familyNamePlate;
            Intrinsics.checkNotNullExpressionValue(includeFamilyNamePlateBinding, "familyNamePlate");
            FamilyInfo info2 = familyCenterData.getInfo();
            if (info2 != null && (grade3 = info2.getGrade()) != null) {
                i = grade3.intValue();
            } else {
                i = -1;
            }
            FamilyInfo info3 = familyCenterData.getInfo();
            if (info3 == null || (nameplate = info3.getNameplate()) == null) {
                str2 = "";
            } else {
                str2 = nameplate;
            }
            AppUtilitiesKt.familyNamePlate$default(includeFamilyNamePlateBinding, i, str2, 0, 4, (Object) null);
            AppCompatTextView appCompatTextView2 = getMHeaderBinding().familyWelcome;
            FamilyInfo info4 = familyCenterData.getInfo();
            if (info4 == null || (str3 = info4.getDeclaration()) == null) {
                str3 = "";
            }
            if (TextUtils.isEmpty(str3)) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            appCompatTextView2.setVisibility(i2);
            ImageView imageView = getMHeaderBinding().familyWelcomeImage;
            FamilyInfo info5 = familyCenterData.getInfo();
            if (info5 == null || (str4 = info5.getDeclaration()) == null) {
                str4 = "";
            }
            if (TextUtils.isEmpty(str4)) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            imageView.setVisibility(i3);
            AppCompatTextView appCompatTextView3 = getMHeaderBinding().familyWelcome;
            FamilyInfo info6 = familyCenterData.getInfo();
            if (info6 == null || (str5 = info6.getDeclaration()) == null) {
                str5 = "";
            }
            appCompatTextView3.setText(str5);
            PolygonImageView polygonImageView = getMHeaderBinding().avatar;
            Intrinsics.checkNotNullExpressionValue(polygonImageView, "avatar");
            FamilyInfo info7 = familyCenterData.getInfo();
            Integer num4 = null;
            if (info7 != null) {
                str6 = info7.getIcon();
            } else {
                str6 = null;
            }
            ImageKtxKt.loadImage$default(polygonImageView, str6, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232548, (c5.g) null, 49150, (Object) null);
            ImageView imageView2 = getMHeaderBinding().gradeMedal;
            FamilyInfo info8 = familyCenterData.getInfo();
            if (info8 != null && (grade2 = info8.getGrade()) != null) {
                drawable = androidx.core.content.a.getDrawable(this, HiloResUtilsKt.familyMedalCenter(grade2.intValue()));
            } else {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            ImageView imageView3 = getMHeaderBinding().familyHeader;
            FamilyInfo info9 = familyCenterData.getInfo();
            if (info9 != null && (grade = info9.getGrade()) != null) {
                drawable2 = androidx.core.content.a.getDrawable(this, HiloResUtilsKt.familyHeader(grade.intValue()));
            } else {
                drawable2 = null;
            }
            imageView3.setImageDrawable(drawable2);
            TextView textView = getMHeaderBinding().rankText;
            String stringById = ResourcesKtxKt.getStringById(this, 2131952682);
            FamilyInfo info10 = familyCenterData.getInfo();
            if (info10 != null) {
                i4 = info10.getMonthRank();
            } else {
                i4 = 0;
            }
            if (i4 < 31) {
                FamilyInfo info11 = familyCenterData.getInfo();
                if (info11 != null) {
                    obj = Integer.valueOf(info11.getMonthRank());
                } else {
                    obj = null;
                }
            } else {
                obj = "30+";
            }
            String format = String.format(stringById, Arrays.copyOf(new Object[]{obj}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
            final TextView textView2 = getMHeaderBinding().rankText;
            final long j2 = 800;
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyCenterActivity$refreshHeader$lambda$14$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j2 || (textView2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                        FamilyRankActivity.INSTANCE.startActivity(this);
                    }
                }
            });
            getMHeaderBinding().progressBar.setMax(100);
            FamilyInfo info12 = familyCenterData.getInfo();
            if (info12 != null && (exp2 = info12.getExp()) != null) {
                d = exp2.longValue();
            } else {
                d = 0.0d;
            }
            FamilyInfo info13 = familyCenterData.getInfo();
            if (info13 != null && (nextExp2 = info13.getNextExp()) != null) {
                d2 = nextExp2.longValue();
            } else {
                d2 = 1.0d;
            }
            getMHeaderBinding().progressBar.setProgress((int) ((d / d2) * 100));
            ProgressBar progressBar = getMHeaderBinding().progressBar;
            FamilyInfo info14 = familyCenterData.getInfo();
            if (info14 != null) {
                num = info14.getGrade();
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 0) {
                i5 = R.drawable.progressbar_family_bg0;
            } else if (num != null && num.intValue() == 1) {
                i5 = R.drawable.progressbar_family_bg1;
            } else if (num != null && num.intValue() == 2) {
                i5 = R.drawable.progressbar_family_bg2;
            } else {
                if ((num == null || num.intValue() != 3) && ((num == null || num.intValue() != 4) && num != null)) {
                    num.intValue();
                }
                i5 = R.drawable.progressbar_family_bg3;
            }
            progressBar.setProgressDrawable(androidx.core.content.a.getDrawable(this, i5));
            SpannableTextBuilder appendText$default = SpannableTextBuilder.appendText$default(new SpannableTextBuilder(getMHeaderBinding().exp), ResourcesKtxKt.getStringById(this, 2131952646), Integer.valueOf(androidx.core.content.a.getColor(this, 2131101214)), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 252, (Object) null);
            FamilyInfo info15 = familyCenterData.getInfo();
            if (info15 == null || (exp = info15.getExp()) == null || (l = exp.toString()) == null) {
                str7 = "";
            } else {
                str7 = l;
            }
            SpannableTextBuilder appendText$default2 = SpannableTextBuilder.appendText$default(appendText$default, str7, Integer.valueOf(androidx.core.content.a.getColor(this, 2131100014)), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 252, (Object) null);
            FamilyInfo info16 = familyCenterData.getInfo();
            if (info16 != null && (nextExp = info16.getNextExp()) != null) {
                str8 = nextExp.toString();
            } else {
                str8 = null;
            }
            SpannableTextBuilder.appendText$default(appendText$default2, "/" + str8, Integer.valueOf(androidx.core.content.a.getColor(this, 2131101214)), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 252, (Object) null).apply();
            TextView textView3 = getMHeaderBinding().familyMember;
            String stringById2 = ResourcesKtxKt.getStringById(this, 2131952678);
            FamilyInfo info17 = familyCenterData.getInfo();
            if (info17 != null) {
                num2 = info17.getMemberNum();
            } else {
                num2 = null;
            }
            FamilyInfo info18 = familyCenterData.getInfo();
            if (info18 != null) {
                num3 = info18.getMemberMax();
            } else {
                num3 = null;
            }
            String format2 = String.format(stringById2, Arrays.copyOf(new Object[]{num2, num3}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            textView3.setText(format2);
            FamilyInfo info19 = familyCenterData.getInfo();
            if (info19 != null) {
                int gradeRes = HiloResUtilKt.getGradeRes(info19);
                ConstraintLayout constraintLayout = getMHeaderBinding().familyLevelLayout;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "familyLevelLayout");
                ImageKtxKt.toHorizontalMirror(constraintLayout, gradeRes);
            }
            final ConstraintLayout constraintLayout2 = getMHeaderBinding().familyLevelLayout;
            final long j3 = 800;
            constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyCenterActivity$refreshHeader$lambda$14$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Long l2;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout2) > j3 || (constraintLayout2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(constraintLayout2, currentTimeMillis);
                        ConstraintLayout constraintLayout3 = constraintLayout2;
                        String str15 = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "family_level_url", "", (String) null, 4, (Object) null);
                        if (!TextUtils.isEmpty(str15)) {
                            NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
                            FamilyInfo info20 = familyCenterData.getInfo();
                            if (info20 != null) {
                                l2 = info20.getId();
                            } else {
                                l2 = null;
                            }
                            DefaultWebActivity.Companion.start$default(DefaultWebActivity.INSTANCE, this, navigationHelper.addParams(str15, new Pair[]{new Pair("family_id", String.valueOf(l2))}), null, 4, null);
                        }
                    }
                }
            });
            getMMemberAdapter().setList(familyCenterData.getMembers());
            ArrayList<FamilyCenterMember> stars = familyCenterData.getStars();
            if (stars != null) {
                for (FamilyCenterMember familyCenterMember : stars) {
                    Integer rankingType = familyCenterMember.getRankingType();
                    if (rankingType != null && rankingType.intValue() == 1) {
                        QMUIRadiusImageView qMUIRadiusImageView = getMHeaderBinding().famous.header;
                        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "header");
                        User user = familyCenterMember.getUser();
                        if (user != null) {
                            str13 = user.getAvatar();
                        } else {
                            str13 = null;
                        }
                        ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(str13), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
                        TextView textView4 = getMHeaderBinding().famous.name;
                        User user2 = familyCenterMember.getUser();
                        if (user2 == null || (str14 = user2.getNick()) == null) {
                            str14 = "";
                        }
                        textView4.setText(str14);
                    } else if (rankingType != null && rankingType.intValue() == 2) {
                        QMUIRadiusImageView qMUIRadiusImageView2 = getMHeaderBinding().active.header;
                        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "header");
                        User user3 = familyCenterMember.getUser();
                        if (user3 != null) {
                            str11 = user3.getAvatar();
                        } else {
                            str11 = null;
                        }
                        ImageKtxKt.loadImage$default(qMUIRadiusImageView2, ImageSizeKt.image100(str11), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
                        TextView textView5 = getMHeaderBinding().active.name;
                        User user4 = familyCenterMember.getUser();
                        if (user4 == null || (str12 = user4.getNick()) == null) {
                            str12 = "";
                        }
                        textView5.setText(str12);
                    } else if (rankingType != null && rankingType.intValue() == 3) {
                        QMUIRadiusImageView qMUIRadiusImageView3 = getMHeaderBinding().charm.header;
                        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView3, "header");
                        User user5 = familyCenterMember.getUser();
                        if (user5 != null) {
                            str9 = user5.getAvatar();
                        } else {
                            str9 = null;
                        }
                        ImageKtxKt.loadImage$default(qMUIRadiusImageView3, ImageSizeKt.image100(str9), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
                        TextView textView6 = getMHeaderBinding().charm.name;
                        User user6 = familyCenterMember.getUser();
                        if (user6 == null || (str10 = user6.getNick()) == null) {
                            str10 = "";
                        }
                        textView6.setText(str10);
                    }
                }
            }
            FamilyInfo info20 = familyCenterData.getInfo();
            if (info20 != null) {
                num4 = Integer.valueOf(info20.getRole());
            }
            if (num4 != null && num4.intValue() == 0) {
                ((ActivityFamilyCenterBinding) getBinding()).applyLayout.setVisibility(0);
                ((ActivityFamilyCenterBinding) getBinding()).setting.setVisibility(8);
                FamilyInfo info21 = familyCenterData.getInfo();
                if (info21 == null || !info21.isApply()) {
                    z = false;
                }
                if (z) {
                    ((ActivityFamilyCenterBinding) getBinding()).applyButton.setText(ResourcesKtxKt.getStringById(this, 2131952017));
                    ((ActivityFamilyCenterBinding) getBinding()).applyButton.setBackground(androidx.core.content.a.getDrawable(this, R.drawable.shape_809036ff_25));
                } else {
                    ((ActivityFamilyCenterBinding) getBinding()).applyButton.setText(ResourcesKtxKt.getStringById(this, 2131952018));
                    ((ActivityFamilyCenterBinding) getBinding()).applyButton.setBackground(androidx.core.content.a.getDrawable(this, R.drawable.shape_9036ff_25));
                }
            } else if (num4 != null && num4.intValue() == 2) {
                ((ActivityFamilyCenterBinding) getBinding()).setting.setVisibility(0);
            } else if ((num4 != null && num4.intValue() == 1) || (num4 != null && num4.intValue() == 3)) {
                ((ActivityFamilyCenterBinding) getBinding()).setting.setVisibility(0);
            }
            TextView textView7 = getMHeaderBinding().diamondNumber;
            FamilyWheel wheelDaily = familyCenterData.getWheelDaily();
            if (wheelDaily != null && (diamond = wheelDaily.getDiamond()) != null) {
                j = diamond.longValue();
            } else {
                j = 0;
            }
            textView7.setText(String.valueOf(j));
            TextView textView8 = getMHeaderBinding().numberNumber;
            FamilyWheel wheelDaily2 = familyCenterData.getWheelDaily();
            if (wheelDaily2 == null || (obj2 = wheelDaily2.getUserNum()) == null) {
                obj2 = 0L;
            }
            FamilyWheel wheelDaily3 = familyCenterData.getWheelDaily();
            if (wheelDaily3 == null || (obj3 = wheelDaily3.getTotalUserNum()) == null) {
                obj3 = 0L;
            }
            textView8.setText(obj2 + "/" + obj3);
            FamilyInfo info22 = familyCenterData.getInfo();
            if (info22 != null) {
                i6 = info22.getRole();
            } else {
                i6 = 0;
            }
            if (i6 > 0) {
                getMHeaderBinding().todayDetail.setVisibility(0);
                ((ActivityFamilyCenterBinding) getBinding()).svgaView.setVisibility(0);
                ((ActivityFamilyCenterBinding) getBinding()).text.setVisibility(0);
            } else {
                getMHeaderBinding().todayDetail.setVisibility(8);
                ((ActivityFamilyCenterBinding) getBinding()).svgaView.setVisibility(8);
                ((ActivityFamilyCenterBinding) getBinding()).text.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startUser(String externalId) {
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openPersonPage(externalId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FamilyCenterViewModel viewModel_delegate$lambda$0(FamilyCenterActivity familyCenterActivity) {
        return new ViewModelProvider(familyCenterActivity).get(FamilyCenterViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_family_center;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        getViewModel().getFamilyRoomListData().destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onDisbandFamilyEvent(@NotNull EventBusKey event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "disband_family")) {
            finish();
        }
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initHeader();
        initView();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onResume() {
        super.onResume();
        getViewModel().getFamilyRoomListData().resetPage();
        getViewModel().familyRoomList(this.familyId);
        getViewModel().familyInfo(this.familyId);
    }

    public final void quitFamily(@NotNull String userExtId, int type) {
        Intrinsics.checkNotNullParameter(userExtId, "userExtId");
        HiloBaseActivity.showProgressDialog$default((HiloBaseActivity) this, (String) null, false, new Function0() { // from class: com.qiahao.nextvideo.ui.family.z
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 3, (Object) null);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().quitFamily(userExtId, type), new Function1() { // from class: com.qiahao.nextvideo.ui.family.a0
            public final Object invoke(Object obj) {
                Unit quitFamily$lambda$42;
                quitFamily$lambda$42 = FamilyCenterActivity.quitFamily$lambda$42(FamilyCenterActivity.this, (ApiResponse) obj);
                return quitFamily$lambda$42;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.family.b0
            public final Object invoke(Object obj) {
                Unit quitFamily$lambda$44;
                quitFamily$lambda$44 = FamilyCenterActivity.quitFamily$lambda$44(FamilyCenterActivity.this, (Throwable) obj);
                return quitFamily$lambda$44;
            }
        }, (Function0) null, false, 12, (Object) null), getViewModel().getMCompositeDisposable());
    }
}
