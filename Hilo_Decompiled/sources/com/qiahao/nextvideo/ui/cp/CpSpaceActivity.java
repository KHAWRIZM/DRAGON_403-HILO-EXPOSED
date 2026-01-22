package com.qiahao.nextvideo.ui.cp;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.interfaceing.MoreDialogListener;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.StoreBean;
import com.qiahao.base_common.model.common.Special;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.cp.CpInfo;
import com.qiahao.base_common.model.cp.CpLevel;
import com.qiahao.base_common.model.cp.CpMemorial;
import com.qiahao.base_common.model.cp.CpPrivilege;
import com.qiahao.base_common.model.cp.CpResLevel;
import com.qiahao.base_common.model.cp.CpSpace;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RelationTypeUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.ActivityCpSpaceBinding;
import com.qiahao.nextvideo.ui.cp.CpSpaceActivity;
import com.qiahao.nextvideo.ui.cp.SearchUserActivity;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.view.CpLevelView;
import com.zhpan.bannerview.BannerViewPager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010!\u001a\u00020\fH\u0014J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0002J\u0006\u0010%\u001a\u00020#J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020#H\u0002R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b\u001e\u0010\u001f¨\u0006*"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpSpaceActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityCpSpaceBinding;", "<init>", "()V", "resLevelList", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/cp/CpResLevel;", "Lkotlin/collections/ArrayList;", "getResLevelList", "()Ljava/util/ArrayList;", "mPosition", "", "getMPosition", "()I", "setMPosition", "(I)V", "mAdapter", "Lcom/qiahao/nextvideo/ui/cp/CpSpaceAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/cp/CpSpaceAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/qiahao/nextvideo/ui/cp/CpSpaceViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/cp/CpSpaceViewModel;", "viewModel$delegate", "bannerAdapter", "Lcom/qiahao/nextvideo/ui/cp/CpBannerAdapter;", "getBannerAdapter", "()Lcom/qiahao/nextvideo/ui/cp/CpBannerAdapter;", "bannerAdapter$delegate", "getLayoutResId", "onInitialize", "", "initData", "refreshPoints", "initView", "refreshRelationView", "initBanner", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCpSpaceActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpSpaceActivity.kt\ncom/qiahao/nextvideo/ui/cp/CpSpaceActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,673:1\n61#2,9:674\n61#2,9:683\n61#2,9:692\n61#2,9:701\n61#2,9:710\n61#2,9:719\n61#2,9:728\n61#2,9:737\n61#2,9:746\n61#2,9:755\n61#2,9:764\n1#3:773\n1869#4,2:774\n*S KotlinDebug\n*F\n+ 1 CpSpaceActivity.kt\ncom/qiahao/nextvideo/ui/cp/CpSpaceActivity\n*L\n279#1:674,9\n289#1:683,9\n296#1:692,9\n326#1:701,9\n332#1:710,9\n337#1:719,9\n347#1:728,9\n359#1:737,9\n377#1:746,9\n386#1:755,9\n400#1:764,9\n175#1:774,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpSpaceActivity extends HiloBaseBindingActivity<ActivityCpSpaceBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String EXTERNAL_ID1 = "externalId1";

    @NotNull
    public static final String EXTERNAL_ID2 = "externalId2";

    @NotNull
    public static final String RELATION_TYPE = "relationType";
    private int mPosition;

    @NotNull
    private final ArrayList<CpResLevel> resLevelList = new ArrayList<>();

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.cp.h1
        public final Object invoke() {
            CpSpaceAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = CpSpaceActivity.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.cp.n1
        public final Object invoke() {
            CpSpaceViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = CpSpaceActivity.viewModel_delegate$lambda$1(CpSpaceActivity.this);
            return viewModel_delegate$lambda$1;
        }
    });

    /* renamed from: bannerAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy bannerAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.cp.o1
        public final Object invoke() {
            CpBannerAdapter bannerAdapter_delegate$lambda$2;
            bannerAdapter_delegate$lambda$2 = CpSpaceActivity.bannerAdapter_delegate$lambda$2();
            return bannerAdapter_delegate$lambda$2;
        }
    });

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpSpaceActivity$Companion;", "", "<init>", "()V", "EXTERNAL_ID1", "", "EXTERNAL_ID2", "RELATION_TYPE", "startActivity", "", "context", "Landroid/content/Context;", CpSpaceActivity.EXTERNAL_ID1, CpSpaceActivity.EXTERNAL_ID2, CpSpaceActivity.RELATION_TYPE, "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void startActivity$default(Companion companion, Context context, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                str2 = null;
            }
            if ((i2 & 8) != 0) {
                i = 1;
            }
            companion.startActivity(context, str, str2, i);
        }

        public final void startActivity(@NotNull Context context, @NotNull String r5, @Nullable String r6, int r7) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(r5, CpSpaceActivity.EXTERNAL_ID1);
            Intent intent = new Intent(context, (Class<?>) CpSpaceActivity.class);
            intent.putExtra(CpSpaceActivity.EXTERNAL_ID1, r5);
            intent.putExtra(CpSpaceActivity.EXTERNAL_ID2, r6);
            intent.putExtra(CpSpaceActivity.RELATION_TYPE, r7);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    public static final CpBannerAdapter bannerAdapter_delegate$lambda$2() {
        return new CpBannerAdapter();
    }

    private final CpBannerAdapter getBannerAdapter() {
        return (CpBannerAdapter) this.bannerAdapter.getValue();
    }

    public final CpSpaceAdapter getMAdapter() {
        return (CpSpaceAdapter) this.mAdapter.getValue();
    }

    public final CpSpaceViewModel getViewModel() {
        return (CpSpaceViewModel) this.viewModel.getValue();
    }

    private final void initBanner() {
        BannerViewPager bannerViewPager = getBinding().banner;
        Intrinsics.checkNotNull(bannerViewPager, "null cannot be cast to non-null type com.zhpan.bannerview.BannerViewPager<com.qiahao.base_common.model.cp.CpResLevel>");
        bannerViewPager.G(getBannerAdapter());
        bannerViewPager.E(new ViewPager2.OnPageChangeCallback() { // from class: com.qiahao.nextvideo.ui.cp.CpSpaceActivity$initBanner$1
            public void onPageSelected(int position) {
                ActivityCpSpaceBinding binding;
                CpSpaceViewModel viewModel;
                Drawable drawable;
                ActivityCpSpaceBinding binding2;
                CpSpaceViewModel viewModel2;
                Drawable drawable2;
                ActivityCpSpaceBinding binding3;
                CpSpaceViewModel viewModel3;
                Drawable drawable3;
                ActivityCpSpaceBinding binding4;
                CpSpaceViewModel viewModel4;
                Drawable drawable4;
                CpSpaceViewModel viewModel5;
                ActivityCpSpaceBinding binding5;
                CpSpaceAdapter mAdapter;
                CpSpaceViewModel viewModel6;
                List privilegeList;
                List privilegeList2;
                ActivityCpSpaceBinding binding6;
                CpSpaceViewModel viewModel7;
                Drawable drawable5;
                ActivityCpSpaceBinding binding7;
                CpSpaceViewModel viewModel8;
                Drawable drawable6;
                super.onPageSelected(position);
                List list = null;
                int i = 0;
                if (position == 0) {
                    binding6 = CpSpaceActivity.this.getBinding();
                    AppCompatImageView appCompatImageView = binding6.leftButton;
                    RelationTypeUtils relationTypeUtils = RelationTypeUtils.INSTANCE;
                    viewModel7 = CpSpaceActivity.this.getViewModel();
                    Integer spaceRelationLeftOrRight = relationTypeUtils.spaceRelationLeftOrRight(viewModel7.getMRelationType(), true, true);
                    if (spaceRelationLeftOrRight != null) {
                        drawable5 = androidx.core.content.a.getDrawable(CpSpaceActivity.this, spaceRelationLeftOrRight.intValue());
                    } else {
                        drawable5 = null;
                    }
                    appCompatImageView.setImageDrawable(drawable5);
                    binding7 = CpSpaceActivity.this.getBinding();
                    AppCompatImageView appCompatImageView2 = binding7.rightButton;
                    viewModel8 = CpSpaceActivity.this.getViewModel();
                    Integer spaceRelationLeftOrRight2 = relationTypeUtils.spaceRelationLeftOrRight(viewModel8.getMRelationType(), false, false);
                    if (spaceRelationLeftOrRight2 != null) {
                        drawable6 = androidx.core.content.a.getDrawable(CpSpaceActivity.this, spaceRelationLeftOrRight2.intValue());
                    } else {
                        drawable6 = null;
                    }
                    appCompatImageView2.setImageDrawable(drawable6);
                } else if (position == CpSpaceActivity.this.getResLevelList().size() - 1) {
                    binding3 = CpSpaceActivity.this.getBinding();
                    AppCompatImageView appCompatImageView3 = binding3.rightButton;
                    RelationTypeUtils relationTypeUtils2 = RelationTypeUtils.INSTANCE;
                    viewModel3 = CpSpaceActivity.this.getViewModel();
                    Integer spaceRelationLeftOrRight3 = relationTypeUtils2.spaceRelationLeftOrRight(viewModel3.getMRelationType(), false, true);
                    if (spaceRelationLeftOrRight3 != null) {
                        drawable3 = androidx.core.content.a.getDrawable(CpSpaceActivity.this, spaceRelationLeftOrRight3.intValue());
                    } else {
                        drawable3 = null;
                    }
                    appCompatImageView3.setImageDrawable(drawable3);
                    binding4 = CpSpaceActivity.this.getBinding();
                    AppCompatImageView appCompatImageView4 = binding4.leftButton;
                    viewModel4 = CpSpaceActivity.this.getViewModel();
                    Integer spaceRelationLeftOrRight4 = relationTypeUtils2.spaceRelationLeftOrRight(viewModel4.getMRelationType(), true, false);
                    if (spaceRelationLeftOrRight4 != null) {
                        drawable4 = androidx.core.content.a.getDrawable(CpSpaceActivity.this, spaceRelationLeftOrRight4.intValue());
                    } else {
                        drawable4 = null;
                    }
                    appCompatImageView4.setImageDrawable(drawable4);
                } else {
                    binding = CpSpaceActivity.this.getBinding();
                    AppCompatImageView appCompatImageView5 = binding.leftButton;
                    RelationTypeUtils relationTypeUtils3 = RelationTypeUtils.INSTANCE;
                    viewModel = CpSpaceActivity.this.getViewModel();
                    Integer spaceRelationLeftOrRight5 = relationTypeUtils3.spaceRelationLeftOrRight(viewModel.getMRelationType(), true, false);
                    if (spaceRelationLeftOrRight5 != null) {
                        drawable = androidx.core.content.a.getDrawable(CpSpaceActivity.this, spaceRelationLeftOrRight5.intValue());
                    } else {
                        drawable = null;
                    }
                    appCompatImageView5.setImageDrawable(drawable);
                    binding2 = CpSpaceActivity.this.getBinding();
                    AppCompatImageView appCompatImageView6 = binding2.rightButton;
                    viewModel2 = CpSpaceActivity.this.getViewModel();
                    Integer spaceRelationLeftOrRight6 = relationTypeUtils3.spaceRelationLeftOrRight(viewModel2.getMRelationType(), false, false);
                    if (spaceRelationLeftOrRight6 != null) {
                        drawable2 = androidx.core.content.a.getDrawable(CpSpaceActivity.this, spaceRelationLeftOrRight6.intValue());
                    } else {
                        drawable2 = null;
                    }
                    appCompatImageView6.setImageDrawable(drawable2);
                }
                CpSpaceActivity.this.setMPosition(position);
                viewModel5 = CpSpaceActivity.this.getViewModel();
                CpSpace cpSpace = (CpSpace) viewModel5.getCpSpace().getValue();
                if (cpSpace != null && (privilegeList2 = cpSpace.getPrivilegeList()) != null) {
                    i = privilegeList2.size();
                }
                if (i > CpSpaceActivity.this.getMPosition()) {
                    mAdapter = CpSpaceActivity.this.getMAdapter();
                    viewModel6 = CpSpaceActivity.this.getViewModel();
                    CpSpace cpSpace2 = (CpSpace) viewModel6.getCpSpace().getValue();
                    if (cpSpace2 != null && (privilegeList = cpSpace2.getPrivilegeList()) != null) {
                        list = (List) privilegeList.get(CpSpaceActivity.this.getMPosition());
                    }
                    mAdapter.setList(list);
                }
                binding5 = CpSpaceActivity.this.getBinding();
                binding5.cpLevel.changeSelect(CpSpaceActivity.this.getMPosition());
                CpSpaceActivity.this.refreshPoints();
            }
        });
        bannerViewPager.g();
    }

    private final void initData() {
        getViewModel().getCpSpace().observe(this, new CpSpaceActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.q1
            public final Object invoke(Object obj) {
                Unit initData$lambda$7;
                initData$lambda$7 = CpSpaceActivity.initData$lambda$7(CpSpaceActivity.this, (CpSpace) obj);
                return initData$lambda$7;
            }
        }));
        getViewModel().getPrivilegeOpen().observe(this, new CpSpaceActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.r1
            public final Object invoke(Object obj) {
                Unit initData$lambda$8;
                initData$lambda$8 = CpSpaceActivity.initData$lambda$8(CpSpaceActivity.this, (Integer) obj);
                return initData$lambda$8;
            }
        }));
        getViewModel().getCpExit().observe(this, new CpSpaceActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.s1
            public final Object invoke(Object obj) {
                Unit initData$lambda$9;
                initData$lambda$9 = CpSpaceActivity.initData$lambda$9(CpSpaceActivity.this, (Boolean) obj);
                return initData$lambda$9;
            }
        }));
        getViewModel().getError().observe(this, new CpSpaceActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.t1
            public final Object invoke(Object obj) {
                Unit initData$lambda$10;
                initData$lambda$10 = CpSpaceActivity.initData$lambda$10(CpSpaceActivity.this, (Throwable) obj);
                return initData$lambda$10;
            }
        }));
        getViewModel().getSuccess().observe(this, new CpSpaceActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.u1
            public final Object invoke(Object obj) {
                Unit initData$lambda$11;
                initData$lambda$11 = CpSpaceActivity.initData$lambda$11(CpSpaceActivity.this, (Boolean) obj);
                return initData$lambda$11;
            }
        }));
        getViewModel().cpSpace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$10(CpSpaceActivity cpSpaceActivity, Throwable th) {
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(cpSpaceActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, cpSpaceActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$11(CpSpaceActivity cpSpaceActivity, Boolean bool) {
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, cpSpaceActivity, ResourcesKtxKt.getStringById(cpSpaceActivity, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0332  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit initData$lambda$7(CpSpaceActivity cpSpaceActivity, final CpSpace cpSpace) {
        String str;
        String str2;
        User user;
        int i;
        CpInfo cpInfo;
        User user2;
        CpInfo cpInfo2;
        boolean z;
        CpInfo cpInfo3;
        String str3;
        CpInfo cpInfo4;
        String str4;
        CpInfo cpInfo5;
        String str5;
        CpInfo cpInfo6;
        String str6;
        CpInfo cpInfo7;
        CpInfo cpInfo8;
        CpLevel cpLevel;
        CpLevel cpLevel2;
        int i2;
        CpInfo cpInfo9;
        String str7;
        User user3;
        String str8;
        List resLevelList;
        List privilegeList;
        int i3;
        List resLevelList2;
        int i4;
        CpLevel cpLevel3;
        int i5;
        long longValue;
        long e;
        String str9;
        StringBuilder sb2;
        List<CpMemorial> cpAnniversary;
        Integer level;
        List list;
        User userInfo;
        Integer level2;
        String settlementDate;
        Integer cpDays;
        String num;
        User cpUserInfo;
        User userInfo2;
        User cpUserInfo2;
        User userInfo3;
        Integer visitTimes;
        String str10;
        User user4;
        String str11;
        String str12;
        User cpUserInfo3;
        User userInfo4;
        if (cpSpace != null) {
            CpInfo cpInfo10 = cpSpace.getCpInfo();
            if (cpInfo10 != null && (userInfo4 = cpInfo10.getUserInfo()) != null) {
                str = userInfo4.getExternalId();
            } else {
                str = null;
            }
            UserStore.Companion companion = UserStore.INSTANCE;
            User user5 = companion.getShared().getUser();
            if (user5 != null) {
                str2 = user5.getExternalId();
            } else {
                str2 = null;
            }
            if (!Intrinsics.areEqual(str, str2)) {
                CpInfo cpInfo11 = cpSpace.getCpInfo();
                if (cpInfo11 != null && (cpUserInfo3 = cpInfo11.getCpUserInfo()) != null) {
                    str11 = cpUserInfo3.getExternalId();
                } else {
                    str11 = null;
                }
                User user6 = companion.getShared().getUser();
                if (user6 != null) {
                    str12 = user6.getExternalId();
                } else {
                    str12 = null;
                }
                if (!Intrinsics.areEqual(str11, str12)) {
                    ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).myCpLayout.setVisibility(0);
                    ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).leftButton.setVisibility(8);
                    ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).rightButton.setVisibility(8);
                    ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).touchBanner.setVisibility(0);
                    ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).pointLayout.setVisibility(8);
                    ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).cpLevel.setVisibility(8);
                    ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).memorialGroup.setVisibility(8);
                    Group group = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).certificateGroup;
                    if (cpSpaceActivity.getViewModel().getMRelationType() != 1) {
                        CpInfo cpInfo12 = cpSpace.getCpInfo();
                        if (cpInfo12 != null) {
                            user4 = cpInfo12.getCpUserInfo();
                        } else {
                            user4 = null;
                        }
                        if (user4 != null) {
                            i = 0;
                            group.setVisibility(i);
                            cpInfo = cpSpace.getCpInfo();
                            if (cpInfo != null) {
                                user2 = cpInfo.getCpUserInfo();
                            } else {
                                user2 = null;
                            }
                            if (user2 == null) {
                                ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).bindGroup.setVisibility(8);
                                ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).unBindGroup.setVisibility(0);
                            } else {
                                ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).bindGroup.setVisibility(0);
                                ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).unBindGroup.setVisibility(8);
                            }
                            cpInfo2 = cpSpace.getCpInfo();
                            if (cpInfo2 != null) {
                                z = Intrinsics.areEqual(cpInfo2.getApplyToUnbind(), Boolean.TRUE);
                            } else {
                                z = false;
                            }
                            if (z) {
                                ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).unBindApply.setVisibility(0);
                                HiloImageView hiloImageView = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).applyAvatar;
                                User user7 = companion.getShared().getUser();
                                if (user7 != null) {
                                    str10 = user7.getAvatar();
                                } else {
                                    str10 = null;
                                }
                                HiloImageView.loadImage$default(hiloImageView, ImageSizeKt.image100(str10), 2131231655, 0, 4, (Object) null);
                            } else {
                                ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).unBindApply.setVisibility(8);
                            }
                            TextView textView = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).visit;
                            cpInfo3 = cpSpace.getCpInfo();
                            str3 = MessageService.MSG_DB_READY_REPORT;
                            if (cpInfo3 != null || (visitTimes = cpInfo3.getVisitTimes()) == null || (r5 = visitTimes.toString()) == null) {
                                String str13 = MessageService.MSG_DB_READY_REPORT;
                            }
                            textView.setText(str13);
                            HiloImageView hiloImageView2 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).leftAvatar;
                            cpInfo4 = cpSpace.getCpInfo();
                            if (cpInfo4 == null && (userInfo3 = cpInfo4.getUserInfo()) != null) {
                                str4 = userInfo3.getAvatar();
                            } else {
                                str4 = null;
                            }
                            HiloImageView.loadImage$default(hiloImageView2, ImageSizeKt.image100(str4), 2131231655, 0, 4, (Object) null);
                            HiloImageView hiloImageView3 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).rightAvatar;
                            cpInfo5 = cpSpace.getCpInfo();
                            if (cpInfo5 == null && (cpUserInfo2 = cpInfo5.getCpUserInfo()) != null) {
                                str5 = cpUserInfo2.getAvatar();
                            } else {
                                str5 = null;
                            }
                            HiloImageView.loadImage$default(hiloImageView3, ImageSizeKt.image100(str5), 2131231655, 0, 4, (Object) null);
                            TextView textView2 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).leftName;
                            cpInfo6 = cpSpace.getCpInfo();
                            str6 = "";
                            if (cpInfo6 != null || (userInfo2 = cpInfo6.getUserInfo()) == null || (r5 = userInfo2.getNick()) == null) {
                                String str14 = "";
                            }
                            textView2.setText(str14);
                            TextView textView3 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).rightName;
                            cpInfo7 = cpSpace.getCpInfo();
                            if (cpInfo7 != null || (cpUserInfo = cpInfo7.getCpUserInfo()) == null || (r5 = cpUserInfo.getNick()) == null) {
                                String str15 = "";
                            }
                            textView3.setText(str15);
                            TextView textView4 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).dayNumber;
                            cpInfo8 = cpSpace.getCpInfo();
                            if (cpInfo8 != null && (cpDays = cpInfo8.getCpDays()) != null && (num = cpDays.toString()) != null) {
                                str3 = num;
                            }
                            textView4.setText(str3);
                            TextView textView5 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).time;
                            String stringById = ResourcesKtxKt.getStringById(cpSpaceActivity, 2131952438);
                            cpLevel = cpSpace.getCpLevel();
                            if (cpLevel != null && (settlementDate = cpLevel.getSettlementDate()) != null) {
                                str6 = settlementDate;
                            }
                            String format = String.format(stringById, Arrays.copyOf(new Object[]{str6}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                            textView5.setText(format);
                            CpLevelView cpLevelView = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).cpLevel;
                            cpLevel2 = cpSpace.getCpLevel();
                            if (cpLevel2 == null && (level2 = cpLevel2.getLevel()) != null) {
                                i2 = level2.intValue();
                            } else {
                                i2 = 0;
                            }
                            cpInfo9 = cpSpace.getCpInfo();
                            if (cpInfo9 == null && (userInfo = cpInfo9.getUserInfo()) != null) {
                                str7 = userInfo.getExternalId();
                            } else {
                                str7 = null;
                            }
                            user3 = companion.getShared().getUser();
                            if (user3 != null) {
                                str8 = user3.getExternalId();
                            } else {
                                str8 = null;
                            }
                            cpLevelView.changeLevel(i2, Intrinsics.areEqual(str7, str8));
                            cpSpaceActivity.refreshPoints();
                            cpSpaceActivity.resLevelList.clear();
                            resLevelList = cpSpace.getResLevelList();
                            if (resLevelList != null) {
                                cpSpaceActivity.resLevelList.addAll(resLevelList);
                            }
                            ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).banner.C(cpSpace.getResLevelList());
                            privilegeList = cpSpace.getPrivilegeList();
                            if (privilegeList != null) {
                                i3 = privilegeList.size();
                            } else {
                                i3 = 0;
                            }
                            if (i3 > cpSpaceActivity.mPosition) {
                                CpSpaceAdapter mAdapter = cpSpaceActivity.getMAdapter();
                                List privilegeList2 = cpSpace.getPrivilegeList();
                                if (privilegeList2 != null) {
                                    list = (List) privilegeList2.get(cpSpaceActivity.mPosition);
                                } else {
                                    list = null;
                                }
                                mAdapter.setList(list);
                            }
                            resLevelList2 = cpSpace.getResLevelList();
                            if (resLevelList2 != null) {
                                i4 = resLevelList2.size();
                            } else {
                                i4 = 0;
                            }
                            cpLevel3 = cpSpace.getCpLevel();
                            if (cpLevel3 == null && (level = cpLevel3.getLevel()) != null) {
                                i5 = level.intValue();
                            } else {
                                i5 = 0;
                            }
                            if (i4 > i5) {
                                ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).cpLevel.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.cp.p1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        CpSpaceActivity.initData$lambda$7$lambda$6$lambda$4(CpSpaceActivity.this, cpSpace);
                                    }
                                }, 400L);
                            }
                            MMKVStore mMKVStore = MMKVStore.INSTANCE;
                            longValue = ((Number) IStore.DefaultImpls.getValue$default(mMKVStore, "memorial_tip", 0L, (String) null, 4, (Object) null)).longValue();
                            e = com.qiahao.base_common.utils.f.e();
                            if (!com.qiahao.base_common.utils.f.g(e, longValue)) {
                                IStore.DefaultImpls.setValue$default(mMKVStore, "memorial_tip", Long.valueOf(e), (String) null, 4, (Object) null);
                                IStore.DefaultImpls.setValue$default(mMKVStore, "memorial_id", "", (String) null, 4, (Object) null);
                            }
                            str9 = (String) IStore.DefaultImpls.getValue$default(mMKVStore, "memorial_id", "", (String) null, 4, (Object) null);
                            sb2 = new StringBuilder();
                            cpAnniversary = cpSpace.getCpAnniversary();
                            if (cpAnniversary != null) {
                                for (CpMemorial cpMemorial : cpAnniversary) {
                                    sb2.append(cpMemorial.getId());
                                    if (!StringsKt.contains$default(str9, String.valueOf(cpMemorial.getId()), false, 2, (Object) null)) {
                                        cpMemorial.setCpInfo(cpSpace.getCpInfo());
                                        new CpTipDialog(cpSpaceActivity, cpMemorial).show();
                                    }
                                }
                            }
                            if (!Intrinsics.areEqual(str9, sb2.toString())) {
                                IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "memorial_id", sb2.toString(), (String) null, 4, (Object) null);
                            }
                        }
                    }
                    i = 8;
                    group.setVisibility(i);
                    cpInfo = cpSpace.getCpInfo();
                    if (cpInfo != null) {
                    }
                    if (user2 == null) {
                    }
                    cpInfo2 = cpSpace.getCpInfo();
                    if (cpInfo2 != null) {
                    }
                    if (z) {
                    }
                    TextView textView6 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).visit;
                    cpInfo3 = cpSpace.getCpInfo();
                    str3 = MessageService.MSG_DB_READY_REPORT;
                    if (cpInfo3 != null) {
                    }
                    String str132 = MessageService.MSG_DB_READY_REPORT;
                    textView6.setText(str132);
                    HiloImageView hiloImageView22 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).leftAvatar;
                    cpInfo4 = cpSpace.getCpInfo();
                    if (cpInfo4 == null) {
                    }
                    str4 = null;
                    HiloImageView.loadImage$default(hiloImageView22, ImageSizeKt.image100(str4), 2131231655, 0, 4, (Object) null);
                    HiloImageView hiloImageView32 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).rightAvatar;
                    cpInfo5 = cpSpace.getCpInfo();
                    if (cpInfo5 == null) {
                    }
                    str5 = null;
                    HiloImageView.loadImage$default(hiloImageView32, ImageSizeKt.image100(str5), 2131231655, 0, 4, (Object) null);
                    TextView textView22 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).leftName;
                    cpInfo6 = cpSpace.getCpInfo();
                    str6 = "";
                    if (cpInfo6 != null) {
                    }
                    String str142 = "";
                    textView22.setText(str142);
                    TextView textView32 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).rightName;
                    cpInfo7 = cpSpace.getCpInfo();
                    if (cpInfo7 != null) {
                    }
                    String str152 = "";
                    textView32.setText(str152);
                    TextView textView42 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).dayNumber;
                    cpInfo8 = cpSpace.getCpInfo();
                    if (cpInfo8 != null) {
                        str3 = num;
                    }
                    textView42.setText(str3);
                    TextView textView52 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).time;
                    String stringById2 = ResourcesKtxKt.getStringById(cpSpaceActivity, 2131952438);
                    cpLevel = cpSpace.getCpLevel();
                    if (cpLevel != null) {
                        str6 = settlementDate;
                    }
                    String format2 = String.format(stringById2, Arrays.copyOf(new Object[]{str6}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                    textView52.setText(format2);
                    CpLevelView cpLevelView2 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).cpLevel;
                    cpLevel2 = cpSpace.getCpLevel();
                    if (cpLevel2 == null) {
                    }
                    i2 = 0;
                    cpInfo9 = cpSpace.getCpInfo();
                    if (cpInfo9 == null) {
                    }
                    str7 = null;
                    user3 = companion.getShared().getUser();
                    if (user3 != null) {
                    }
                    cpLevelView2.changeLevel(i2, Intrinsics.areEqual(str7, str8));
                    cpSpaceActivity.refreshPoints();
                    cpSpaceActivity.resLevelList.clear();
                    resLevelList = cpSpace.getResLevelList();
                    if (resLevelList != null) {
                    }
                    ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).banner.C(cpSpace.getResLevelList());
                    privilegeList = cpSpace.getPrivilegeList();
                    if (privilegeList != null) {
                    }
                    if (i3 > cpSpaceActivity.mPosition) {
                    }
                    resLevelList2 = cpSpace.getResLevelList();
                    if (resLevelList2 != null) {
                    }
                    cpLevel3 = cpSpace.getCpLevel();
                    if (cpLevel3 == null) {
                    }
                    i5 = 0;
                    if (i4 > i5) {
                    }
                    MMKVStore mMKVStore2 = MMKVStore.INSTANCE;
                    longValue = ((Number) IStore.DefaultImpls.getValue$default(mMKVStore2, "memorial_tip", 0L, (String) null, 4, (Object) null)).longValue();
                    e = com.qiahao.base_common.utils.f.e();
                    if (!com.qiahao.base_common.utils.f.g(e, longValue)) {
                    }
                    str9 = (String) IStore.DefaultImpls.getValue$default(mMKVStore2, "memorial_id", "", (String) null, 4, (Object) null);
                    sb2 = new StringBuilder();
                    cpAnniversary = cpSpace.getCpAnniversary();
                    if (cpAnniversary != null) {
                    }
                    if (!Intrinsics.areEqual(str9, sb2.toString())) {
                    }
                }
            }
            ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).myCpLayout.setVisibility(8);
            ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).leftButton.setVisibility(0);
            ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).rightButton.setVisibility(0);
            ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).touchBanner.setVisibility(8);
            CpInfo cpInfo13 = cpSpace.getCpInfo();
            if (cpInfo13 != null) {
                user = cpInfo13.getCpUserInfo();
            } else {
                user = null;
            }
            if (user == null) {
                ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).pointLayout.setVisibility(8);
                ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).cpLevel.setVisibility(8);
                ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).memorialGroup.setVisibility(8);
            } else {
                ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).pointLayout.setVisibility(0);
                ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).cpLevel.setVisibility(0);
                if (cpSpaceActivity.getViewModel().getMRelationType() == 1) {
                    ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).memorialGroup.setVisibility(0);
                }
            }
            Group group2 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).certificateGroup;
            if (cpSpaceActivity.getViewModel().getMRelationType() != 1) {
            }
            i = 8;
            group2.setVisibility(i);
            cpInfo = cpSpace.getCpInfo();
            if (cpInfo != null) {
            }
            if (user2 == null) {
            }
            cpInfo2 = cpSpace.getCpInfo();
            if (cpInfo2 != null) {
            }
            if (z) {
            }
            TextView textView62 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).visit;
            cpInfo3 = cpSpace.getCpInfo();
            str3 = MessageService.MSG_DB_READY_REPORT;
            if (cpInfo3 != null) {
            }
            String str1322 = MessageService.MSG_DB_READY_REPORT;
            textView62.setText(str1322);
            HiloImageView hiloImageView222 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).leftAvatar;
            cpInfo4 = cpSpace.getCpInfo();
            if (cpInfo4 == null) {
            }
            str4 = null;
            HiloImageView.loadImage$default(hiloImageView222, ImageSizeKt.image100(str4), 2131231655, 0, 4, (Object) null);
            HiloImageView hiloImageView322 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).rightAvatar;
            cpInfo5 = cpSpace.getCpInfo();
            if (cpInfo5 == null) {
            }
            str5 = null;
            HiloImageView.loadImage$default(hiloImageView322, ImageSizeKt.image100(str5), 2131231655, 0, 4, (Object) null);
            TextView textView222 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).leftName;
            cpInfo6 = cpSpace.getCpInfo();
            str6 = "";
            if (cpInfo6 != null) {
            }
            String str1422 = "";
            textView222.setText(str1422);
            TextView textView322 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).rightName;
            cpInfo7 = cpSpace.getCpInfo();
            if (cpInfo7 != null) {
            }
            String str1522 = "";
            textView322.setText(str1522);
            TextView textView422 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).dayNumber;
            cpInfo8 = cpSpace.getCpInfo();
            if (cpInfo8 != null) {
            }
            textView422.setText(str3);
            TextView textView522 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).time;
            String stringById22 = ResourcesKtxKt.getStringById(cpSpaceActivity, 2131952438);
            cpLevel = cpSpace.getCpLevel();
            if (cpLevel != null) {
            }
            String format22 = String.format(stringById22, Arrays.copyOf(new Object[]{str6}, 1));
            Intrinsics.checkNotNullExpressionValue(format22, "format(...)");
            textView522.setText(format22);
            CpLevelView cpLevelView22 = ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).cpLevel;
            cpLevel2 = cpSpace.getCpLevel();
            if (cpLevel2 == null) {
            }
            i2 = 0;
            cpInfo9 = cpSpace.getCpInfo();
            if (cpInfo9 == null) {
            }
            str7 = null;
            user3 = companion.getShared().getUser();
            if (user3 != null) {
            }
            cpLevelView22.changeLevel(i2, Intrinsics.areEqual(str7, str8));
            cpSpaceActivity.refreshPoints();
            cpSpaceActivity.resLevelList.clear();
            resLevelList = cpSpace.getResLevelList();
            if (resLevelList != null) {
            }
            ((ActivityCpSpaceBinding) cpSpaceActivity.getBinding()).banner.C(cpSpace.getResLevelList());
            privilegeList = cpSpace.getPrivilegeList();
            if (privilegeList != null) {
            }
            if (i3 > cpSpaceActivity.mPosition) {
            }
            resLevelList2 = cpSpace.getResLevelList();
            if (resLevelList2 != null) {
            }
            cpLevel3 = cpSpace.getCpLevel();
            if (cpLevel3 == null) {
            }
            i5 = 0;
            if (i4 > i5) {
            }
            MMKVStore mMKVStore22 = MMKVStore.INSTANCE;
            longValue = ((Number) IStore.DefaultImpls.getValue$default(mMKVStore22, "memorial_tip", 0L, (String) null, 4, (Object) null)).longValue();
            e = com.qiahao.base_common.utils.f.e();
            if (!com.qiahao.base_common.utils.f.g(e, longValue)) {
            }
            str9 = (String) IStore.DefaultImpls.getValue$default(mMKVStore22, "memorial_id", "", (String) null, 4, (Object) null);
            sb2 = new StringBuilder();
            cpAnniversary = cpSpace.getCpAnniversary();
            if (cpAnniversary != null) {
            }
            if (!Intrinsics.areEqual(str9, sb2.toString())) {
            }
        }
        return Unit.INSTANCE;
    }

    public static final void initData$lambda$7$lambda$6$lambda$4(CpSpaceActivity cpSpaceActivity, CpSpace cpSpace) {
        int i;
        Integer level;
        CpLevel cpLevel = cpSpace.getCpLevel();
        if (cpLevel != null && (level = cpLevel.getLevel()) != null) {
            i = level.intValue();
        } else {
            i = 0;
        }
        cpSpaceActivity.mPosition = i;
        cpSpaceActivity.getBinding().banner.setCurrentItem(cpSpaceActivity.mPosition);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$8(CpSpaceActivity cpSpaceActivity, Integer num) {
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, cpSpaceActivity, ResourcesKtxKt.getStringById(cpSpaceActivity, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$9(CpSpaceActivity cpSpaceActivity, Boolean bool) {
        boolean z;
        int i;
        if (cpSpaceActivity.getViewModel().getMRelationType() == 1) {
            z = true;
        } else {
            z = false;
        }
        CpConfirmDialog cpConfirmDialog = new CpConfirmDialog(cpSpaceActivity, z);
        if (cpSpaceActivity.getViewModel().getMRelationType() == 1) {
            i = 2131952447;
        } else {
            i = 2131954243;
        }
        cpConfirmDialog.setTipContent(ResourcesKtxKt.getStringById(cpSpaceActivity, i)).setConfirmContent(ResourcesKtxKt.getStringById(cpSpaceActivity, 2131952331)).show();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        getViewModel().setMExternalId1(getIntent().getStringExtra(EXTERNAL_ID1));
        getViewModel().setMExternalId2(getIntent().getStringExtra(EXTERNAL_ID2));
        getViewModel().setMRelationType(getIntent().getIntExtra(RELATION_TYPE, 0));
        if (TextUtils.isEmpty(getViewModel().getMExternalId1()) || !RelationTypeUtils.INSTANCE.checkRelation(getViewModel().getMRelationType())) {
            finish();
        }
        refreshRelationView();
        initBanner();
        View view = ((ActivityCpSpaceBinding) getBinding()).titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.cp.v1
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$13;
                initView$lambda$13 = CpSpaceActivity.initView$lambda$13(CpSpaceActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$13;
            }
        });
        final AppCompatImageView appCompatImageView = ((ActivityCpSpaceBinding) getBinding()).titleBar.backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpSpaceActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.finish();
                }
            }
        });
        ((ActivityCpSpaceBinding) getBinding()).titleBar.endImage.setVisibility(0);
        ((ActivityCpSpaceBinding) getBinding()).titleBar.endImage.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.icon_more));
        final ImageView imageView = ((ActivityCpSpaceBinding) getBinding()).memorial;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpSpaceActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    this.startActivity(new Intent((Context) this, (Class<?>) CpMemorialActivity.class));
                }
            }
        });
        ConstraintLayout constraintLayout = ((ActivityCpSpaceBinding) getBinding()).unBindApply;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        constraintLayout.setBackground(ShapeUtil.createShapeStroke$default(shapeUtil, "#88d0ff", 14, 1.0f, false, "#daf1ff", "#ffffff", (GradientDrawable.Orientation) null, 64, (Object) null));
        ((ActivityCpSpaceBinding) getBinding()).revoke.setBackground(ShapeUtil.createShape$default(shapeUtil, "#8fd3ff", "#41b5ff", 11, (GradientDrawable.Orientation) null, 8, (Object) null));
        final AppCompatImageView appCompatImageView2 = ((ActivityCpSpaceBinding) getBinding()).titleBar.endImage;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpSpaceActivity$initView$$inlined$singleClick$default$3
            /* JADX WARN: Type inference failed for: r0v1, types: [android.content.Context, com.qiahao.nextvideo.ui.cp.CpSpaceActivity] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CpSpaceViewModel viewModel;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView2) > j || (appCompatImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView2, currentTimeMillis);
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    ?? r0 = this;
                    viewModel = r0.getViewModel();
                    CpMoreDialog cpMoreDialog = new CpMoreDialog(r0, viewModel.checkMySpace());
                    final CpSpaceActivity cpSpaceActivity = this;
                    cpMoreDialog.setListener(new MoreDialogListener() { // from class: com.qiahao.nextvideo.ui.cp.CpSpaceActivity$initView$4$1
                        /* JADX WARN: Type inference failed for: r0v4, types: [android.content.Context, com.qiahao.nextvideo.ui.cp.CpSpaceActivity] */
                        /* JADX WARN: Type inference failed for: r0v5, types: [android.content.Context, com.qiahao.nextvideo.ui.cp.CpSpaceActivity] */
                        public void clickType(String type) {
                            CpSpaceViewModel viewModel2;
                            CpSpaceViewModel viewModel3;
                            boolean z;
                            CpSpaceViewModel viewModel4;
                            int i;
                            Intrinsics.checkNotNullParameter(type, "type");
                            if (Intrinsics.areEqual(type, "exit")) {
                                ?? r02 = CpSpaceActivity.this;
                                viewModel3 = r02.getViewModel();
                                if (viewModel3.getMRelationType() == 1) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                CpConfirmTwoDialog cpConfirmTwoDialog = new CpConfirmTwoDialog(r02, z);
                                viewModel4 = CpSpaceActivity.this.getViewModel();
                                if (viewModel4.getMRelationType() == 1) {
                                    i = 2131952448;
                                } else {
                                    i = 2131954186;
                                }
                                CpConfirmTwoDialog confirmContent = cpConfirmTwoDialog.setTipContent(ResourcesKtxKt.getStringById(this, i)).setCancelContent(ResourcesKtxKt.getStringById(this, 2131952171)).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131952331));
                                final CpSpaceActivity cpSpaceActivity2 = CpSpaceActivity.this;
                                confirmContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.cp.CpSpaceActivity$initView$4$1$clickType$1
                                    public void cancel() {
                                        OnCommonDialogListener.DefaultImpls.cancel(this);
                                    }

                                    public void confirm() {
                                        CpSpaceViewModel viewModel5;
                                        CpSpaceViewModel viewModel6;
                                        String str;
                                        CpInfo cpInfo;
                                        User cpUserInfo;
                                        viewModel5 = CpSpaceActivity.this.getViewModel();
                                        viewModel6 = CpSpaceActivity.this.getViewModel();
                                        CpSpace cpSpace = (CpSpace) viewModel6.getCpSpace().getValue();
                                        if (cpSpace == null || (cpInfo = cpSpace.getCpInfo()) == null || (cpUserInfo = cpInfo.getCpUserInfo()) == null || (str = cpUserInfo.getExternalId()) == null) {
                                            str = "";
                                        }
                                        viewModel5.cpRelation(str);
                                    }
                                }).show();
                                return;
                            }
                            if (Intrinsics.areEqual(type, CpMoreDialog.CLICK_INTRODUCE)) {
                                ?? r03 = CpSpaceActivity.this;
                                viewModel2 = r03.getViewModel();
                                new CpRuleDialog(r03, viewModel2.getMRelationType()).show();
                            }
                        }
                    }).show();
                }
            }
        });
        final HiloImageView hiloImageView = ((ActivityCpSpaceBinding) getBinding()).leftAvatar;
        hiloImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpSpaceActivity$initView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CpSpaceViewModel viewModel;
                String str;
                CpInfo cpInfo;
                User userInfo;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(hiloImageView) > j || (hiloImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(hiloImageView, currentTimeMillis);
                    HiloImageView hiloImageView2 = hiloImageView;
                    AppService service = AppController.INSTANCE.getService();
                    if (service != null) {
                        viewModel = this.getViewModel();
                        CpSpace cpSpace = (CpSpace) viewModel.getCpSpace().getValue();
                        if (cpSpace == null || (cpInfo = cpSpace.getCpInfo()) == null || (userInfo = cpInfo.getUserInfo()) == null || (str = userInfo.getExternalId()) == null) {
                            str = "";
                        }
                        service.openPersonPage(str);
                    }
                }
            }
        });
        final HiloImageView hiloImageView2 = ((ActivityCpSpaceBinding) getBinding()).rightAvatar;
        hiloImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpSpaceActivity$initView$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CpSpaceViewModel viewModel;
                String str;
                CpInfo cpInfo;
                User cpUserInfo;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(hiloImageView2) > j || (hiloImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(hiloImageView2, currentTimeMillis);
                    HiloImageView hiloImageView3 = hiloImageView2;
                    AppService service = AppController.INSTANCE.getService();
                    if (service != null) {
                        viewModel = this.getViewModel();
                        CpSpace cpSpace = (CpSpace) viewModel.getCpSpace().getValue();
                        if (cpSpace == null || (cpInfo = cpSpace.getCpInfo()) == null || (cpUserInfo = cpInfo.getCpUserInfo()) == null || (str = cpUserInfo.getExternalId()) == null) {
                            str = "";
                        }
                        service.openPersonPage(str);
                    }
                }
            }
        });
        final ImageView imageView2 = ((ActivityCpSpaceBinding) getBinding()).certificate;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpSpaceActivity$initView$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CpSpaceViewModel viewModel;
                CpInfo cpInfo;
                User userInfo;
                CpSpaceViewModel viewModel2;
                CpSpaceViewModel viewModel3;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                    viewModel = this.getViewModel();
                    CpSpace cpSpace = (CpSpace) viewModel.getCpSpace().getValue();
                    if (cpSpace != null && (cpInfo = cpSpace.getCpInfo()) != null && (userInfo = cpInfo.getUserInfo()) != null) {
                        viewModel2 = this.getViewModel();
                        CpSpace cpSpace2 = (CpSpace) viewModel2.getCpSpace().getValue();
                        if (cpSpace2 != null) {
                            viewModel3 = this.getViewModel();
                            Special special = DataExternalKt.toSpecial(cpSpace2, viewModel3.getMRelationType());
                            if (special != null) {
                                new CpCertificateDialog(this, userInfo, special).show();
                            }
                        }
                    }
                }
            }
        });
        final TextView textView = ((ActivityCpSpaceBinding) getBinding()).certificateText;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpSpaceActivity$initView$$inlined$singleClick$default$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CpSpaceViewModel viewModel;
                CpInfo cpInfo;
                User userInfo;
                CpSpaceViewModel viewModel2;
                CpSpaceViewModel viewModel3;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    viewModel = this.getViewModel();
                    CpSpace cpSpace = (CpSpace) viewModel.getCpSpace().getValue();
                    if (cpSpace != null && (cpInfo = cpSpace.getCpInfo()) != null && (userInfo = cpInfo.getUserInfo()) != null) {
                        viewModel2 = this.getViewModel();
                        CpSpace cpSpace2 = (CpSpace) viewModel2.getCpSpace().getValue();
                        if (cpSpace2 != null) {
                            viewModel3 = this.getViewModel();
                            Special special = DataExternalKt.toSpecial(cpSpace2, viewModel3.getMRelationType());
                            if (special != null) {
                                new CpCertificateDialog(this, userInfo, special).show();
                            }
                        }
                    }
                }
            }
        });
        final TextView textView2 = ((ActivityCpSpaceBinding) getBinding()).revoke;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpSpaceActivity$initView$$inlined$singleClick$default$8
            /* JADX WARN: Type inference failed for: r0v1, types: [android.content.Context, com.qiahao.nextvideo.ui.cp.CpSpaceActivity] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CpSpaceViewModel viewModel;
                boolean z;
                CpSpaceViewModel viewModel2;
                int i;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    ?? r0 = this;
                    viewModel = r0.getViewModel();
                    if (viewModel.getMRelationType() == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    CpConfirmTwoDialog cpConfirmTwoDialog = new CpConfirmTwoDialog(r0, z);
                    CpSpaceActivity cpSpaceActivity = this;
                    viewModel2 = cpSpaceActivity.getViewModel();
                    if (viewModel2.getMRelationType() == 1) {
                        i = 2131952404;
                    } else {
                        i = 2131952027;
                    }
                    CpConfirmTwoDialog tipContent = cpConfirmTwoDialog.setTipContent(ResourcesKtxKt.getStringById(cpSpaceActivity, i));
                    final CpSpaceActivity cpSpaceActivity2 = this;
                    tipContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.cp.CpSpaceActivity$initView$9$1
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            CpSpaceViewModel viewModel3;
                            CpSpaceViewModel viewModel4;
                            String str;
                            CpInfo cpInfo;
                            User cpUserInfo;
                            viewModel3 = CpSpaceActivity.this.getViewModel();
                            viewModel4 = CpSpaceActivity.this.getViewModel();
                            CpSpace cpSpace = (CpSpace) viewModel4.getCpSpace().getValue();
                            if (cpSpace == null || (cpInfo = cpSpace.getCpInfo()) == null || (cpUserInfo = cpInfo.getCpUserInfo()) == null || (str = cpUserInfo.getExternalId()) == null) {
                                str = "";
                            }
                            viewModel3.cpReply(str);
                        }
                    }).show();
                }
            }
        });
        ((ActivityCpSpaceBinding) getBinding()).leftButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CpSpaceActivity.initView$lambda$26(CpSpaceActivity.this, view2);
            }
        });
        final View view2 = ((ActivityCpSpaceBinding) getBinding()).touchBanner;
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpSpaceActivity$initView$$inlined$singleClick$default$9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(view2) > j || (view2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(view2, currentTimeMillis);
                }
            }
        });
        ((ActivityCpSpaceBinding) getBinding()).rightButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.j1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                CpSpaceActivity.initView$lambda$28(CpSpaceActivity.this, view3);
            }
        });
        ((ActivityCpSpaceBinding) getBinding()).cpLevel.setListener(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.k1
            public final Object invoke(Object obj) {
                Unit initView$lambda$29;
                initView$lambda$29 = CpSpaceActivity.initView$lambda$29(CpSpaceActivity.this, ((Integer) obj).intValue());
                return initView$lambda$29;
            }
        });
        final TextView textView3 = ((ActivityCpSpaceBinding) getBinding()).bindCp;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpSpaceActivity$initView$$inlined$singleClick$default$10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                CpSpaceViewModel viewModel;
                CpSpaceViewModel viewModel2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                    viewModel = this.getViewModel();
                    if (viewModel.getMRelationType() == 1) {
                        SearchUserActivity.Companion.startActivity$default(SearchUserActivity.Companion, this, SearchUserActivity.BIND_CP, null, 4, null);
                        return;
                    }
                    StoreBean storeBean = new StoreBean((String) null, (Long) null, (String) null, (Long) null, (String) null, (Integer) null, (String) null, (Integer) null, 255, (DefaultConstructorMarker) null);
                    viewModel2 = this.getViewModel();
                    storeBean.setRelationType(Integer.valueOf(viewModel2.getMRelationType()));
                    SearchUserActivity.Companion.startActivity(this, SearchUserActivity.BIND_RELATION, new com.google.gson.d().s(storeBean));
                }
            }
        });
        final TextView textView4 = ((ActivityCpSpaceBinding) getBinding()).myCp;
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpSpaceActivity$initView$$inlined$singleClick$default$11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                String str;
                CpSpaceViewModel viewModel;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView4) > j || (textView4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView4, currentTimeMillis);
                    CpSpaceActivity.Companion companion = CpSpaceActivity.INSTANCE;
                    BaseActivity baseActivity = this;
                    User user = UserStore.INSTANCE.getShared().getUser();
                    if (user == null || (str = user.getExternalId()) == null) {
                        str = "";
                    }
                    viewModel = this.getViewModel();
                    companion.startActivity(baseActivity, str, "", viewModel.getMRelationType());
                }
            }
        });
        ((ActivityCpSpaceBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.cp.l1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view3, int i) {
                CpSpaceActivity.initView$lambda$34(CpSpaceActivity.this, baseQuickAdapter, view3, i);
            }
        });
    }

    public static final Unit initView$lambda$13(CpSpaceActivity cpSpaceActivity, int i, int i2) {
        cpSpaceActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    public static final void initView$lambda$26(CpSpaceActivity cpSpaceActivity, View view) {
        cpSpaceActivity.getBinding().banner.setCurrentItem(r0.getCurrentItem() - 1);
    }

    public static final void initView$lambda$28(CpSpaceActivity cpSpaceActivity, View view) {
        BannerViewPager bannerViewPager = cpSpaceActivity.getBinding().banner;
        bannerViewPager.setCurrentItem(bannerViewPager.getCurrentItem() + 1);
    }

    public static final Unit initView$lambda$29(CpSpaceActivity cpSpaceActivity, int i) {
        cpSpaceActivity.getBinding().banner.setCurrentItem(i);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$34(CpSpaceActivity cpSpaceActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Integer num;
        CpLevel cpLevel;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (!cpSpaceActivity.getViewModel().checkMySpace()) {
            return;
        }
        CpPrivilege cpPrivilege = (CpPrivilege) cpSpaceActivity.getMAdapter().getData().get(i);
        ArrayList levelList = cpPrivilege.getLevelList();
        boolean z = false;
        if (levelList != null) {
            CpSpace cpSpace = (CpSpace) cpSpaceActivity.getViewModel().getCpSpace().getValue();
            if (cpSpace != null && (cpLevel = cpSpace.getCpLevel()) != null) {
                num = cpLevel.getLevel();
            } else {
                num = null;
            }
            if (CollectionsKt.contains(levelList, num)) {
                z = true;
            }
        }
        CpPrivilegeDialog cpPrivilegeDialog = new CpPrivilegeDialog(cpSpaceActivity, cpPrivilege, z, cpSpaceActivity.getViewModel().getMRelationType());
        cpPrivilegeDialog.setListener(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.m1
            public final Object invoke(Object obj) {
                Unit initView$lambda$34$lambda$33$lambda$32;
                initView$lambda$34$lambda$33$lambda$32 = CpSpaceActivity.initView$lambda$34$lambda$33$lambda$32(CpSpaceActivity.this, (CpPrivilege) obj);
                return initView$lambda$34$lambda$33$lambda$32;
            }
        });
        cpPrivilegeDialog.show();
    }

    public static final Unit initView$lambda$34$lambda$33$lambda$32(CpSpaceActivity cpSpaceActivity, CpPrivilege cpPrivilege) {
        int i;
        int i2;
        Integer type;
        CpSpaceViewModel viewModel = cpSpaceActivity.getViewModel();
        boolean z = false;
        if (cpPrivilege != null && (type = cpPrivilege.getType()) != null) {
            i = type.intValue();
        } else {
            i = 0;
        }
        if (cpPrivilege != null) {
            z = Intrinsics.areEqual(cpPrivilege.getUserSwitch(), Boolean.TRUE);
        }
        if (z) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        viewModel.privilegeOpen(i, i2);
        return Unit.INSTANCE;
    }

    public static final CpSpaceAdapter mAdapter_delegate$lambda$0() {
        return new CpSpaceAdapter();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void refreshRelationView() {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        Drawable drawable6;
        Drawable drawable7;
        Drawable drawable8;
        Drawable drawable9;
        Drawable drawable10;
        Drawable drawable11;
        Drawable drawable12;
        Drawable drawable13;
        Drawable drawable14;
        Drawable drawable15;
        Drawable drawable16;
        Drawable drawable17;
        Drawable drawable18;
        int i;
        int i2;
        int i3;
        int i4;
        getMAdapter().setRelationType(getViewModel().getMRelationType());
        getBannerAdapter().setRelationType(getViewModel().getMRelationType());
        ((ActivityCpSpaceBinding) getBinding()).cpLevel.setRelationType(getViewModel().getMRelationType());
        ImageView imageView = ((ActivityCpSpaceBinding) getBinding()).topBg;
        RelationTypeUtils relationTypeUtils = RelationTypeUtils.INSTANCE;
        Integer spaceRelationTobBg = relationTypeUtils.spaceRelationTobBg(getViewModel().getMRelationType());
        Drawable drawable19 = null;
        if (spaceRelationTobBg != null) {
            drawable = androidx.core.content.a.getDrawable(this, spaceRelationTobBg.intValue());
        } else {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
        ImageView imageView2 = ((ActivityCpSpaceBinding) getBinding()).buttonBg;
        Integer spaceRelationButtonBg = relationTypeUtils.spaceRelationButtonBg(getViewModel().getMRelationType());
        if (spaceRelationButtonBg != null) {
            drawable2 = androidx.core.content.a.getDrawable(this, spaceRelationButtonBg.intValue());
        } else {
            drawable2 = null;
        }
        imageView2.setImageDrawable(drawable2);
        ImageView imageView3 = ((ActivityCpSpaceBinding) getBinding()).topIcon;
        Integer spaceRelationIcon1 = relationTypeUtils.spaceRelationIcon1(getViewModel().getMRelationType());
        if (spaceRelationIcon1 != null) {
            drawable3 = androidx.core.content.a.getDrawable(this, spaceRelationIcon1.intValue());
        } else {
            drawable3 = null;
        }
        imageView3.setImageDrawable(drawable3);
        ImageView imageView4 = ((ActivityCpSpaceBinding) getBinding()).leftIcon;
        Integer spaceRelationAvatarBorder = relationTypeUtils.spaceRelationAvatarBorder(getViewModel().getMRelationType());
        if (spaceRelationAvatarBorder != null) {
            drawable4 = androidx.core.content.a.getDrawable(this, spaceRelationAvatarBorder.intValue());
        } else {
            drawable4 = null;
        }
        imageView4.setImageDrawable(drawable4);
        ImageView imageView5 = ((ActivityCpSpaceBinding) getBinding()).rightIcon;
        Integer spaceRelationAvatarBorder2 = relationTypeUtils.spaceRelationAvatarBorder(getViewModel().getMRelationType());
        if (spaceRelationAvatarBorder2 != null) {
            drawable5 = androidx.core.content.a.getDrawable(this, spaceRelationAvatarBorder2.intValue());
        } else {
            drawable5 = null;
        }
        imageView5.setImageDrawable(drawable5);
        ImageView imageView6 = ((ActivityCpSpaceBinding) getBinding()).unBindAvatar;
        Integer spaceRelationUnbinding = relationTypeUtils.spaceRelationUnbinding(getViewModel().getMRelationType());
        if (spaceRelationUnbinding != null) {
            drawable6 = androidx.core.content.a.getDrawable(this, spaceRelationUnbinding.intValue());
        } else {
            drawable6 = null;
        }
        imageView6.setImageDrawable(drawable6);
        ImageView imageView7 = ((ActivityCpSpaceBinding) getBinding()).addImage;
        Integer spaceRelationIcon2 = relationTypeUtils.spaceRelationIcon2(getViewModel().getMRelationType());
        if (spaceRelationIcon2 != null) {
            drawable7 = androidx.core.content.a.getDrawable(this, spaceRelationIcon2.intValue());
        } else {
            drawable7 = null;
        }
        imageView7.setImageDrawable(drawable7);
        ImageView imageView8 = ((ActivityCpSpaceBinding) getBinding()).topLine;
        Integer spaceRelationIcon3 = relationTypeUtils.spaceRelationIcon3(getViewModel().getMRelationType());
        if (spaceRelationIcon3 != null) {
            drawable8 = androidx.core.content.a.getDrawable(this, spaceRelationIcon3.intValue());
        } else {
            drawable8 = null;
        }
        imageView8.setImageDrawable(drawable8);
        TextView textView = ((ActivityCpSpaceBinding) getBinding()).bindCp;
        Integer spaceRelationIcon4 = relationTypeUtils.spaceRelationIcon4(getViewModel().getMRelationType());
        if (spaceRelationIcon4 != null) {
            drawable9 = androidx.core.content.a.getDrawable(this, spaceRelationIcon4.intValue());
        } else {
            drawable9 = null;
        }
        textView.setBackground(drawable9);
        ImageView imageView9 = ((ActivityCpSpaceBinding) getBinding()).dayLine;
        Integer spaceRelationIcon5 = relationTypeUtils.spaceRelationIcon5(getViewModel().getMRelationType());
        if (spaceRelationIcon5 != null) {
            drawable10 = androidx.core.content.a.getDrawable(this, spaceRelationIcon5.intValue());
        } else {
            drawable10 = null;
        }
        imageView9.setImageDrawable(drawable10);
        ImageView imageView10 = ((ActivityCpSpaceBinding) getBinding()).stage;
        Integer spaceRelationIcon6 = relationTypeUtils.spaceRelationIcon6(getViewModel().getMRelationType());
        if (spaceRelationIcon6 != null) {
            drawable11 = androidx.core.content.a.getDrawable(this, spaceRelationIcon6.intValue());
        } else {
            drawable11 = null;
        }
        imageView10.setImageDrawable(drawable11);
        TextView textView2 = ((ActivityCpSpaceBinding) getBinding()).time;
        Integer spaceRelationIcon7 = relationTypeUtils.spaceRelationIcon7(getViewModel().getMRelationType());
        if (spaceRelationIcon7 != null) {
            drawable12 = androidx.core.content.a.getDrawable(this, spaceRelationIcon7.intValue());
        } else {
            drawable12 = null;
        }
        textView2.setBackground(drawable12);
        TextView textView3 = ((ActivityCpSpaceBinding) getBinding()).unBindText;
        Integer spaceRelationIcon72 = relationTypeUtils.spaceRelationIcon7(getViewModel().getMRelationType());
        if (spaceRelationIcon72 != null) {
            drawable13 = androidx.core.content.a.getDrawable(this, spaceRelationIcon72.intValue());
        } else {
            drawable13 = null;
        }
        textView3.setBackground(drawable13);
        ConstraintLayout constraintLayout = ((ActivityCpSpaceBinding) getBinding()).pointLayout;
        Integer spaceRelationIcon8 = relationTypeUtils.spaceRelationIcon8(getViewModel().getMRelationType());
        if (spaceRelationIcon8 != null) {
            drawable14 = androidx.core.content.a.getDrawable(this, spaceRelationIcon8.intValue());
        } else {
            drawable14 = null;
        }
        constraintLayout.setBackground(drawable14);
        ImageView imageView11 = ((ActivityCpSpaceBinding) getBinding()).progressBg;
        Integer spaceRelationIcon9 = relationTypeUtils.spaceRelationIcon9(getViewModel().getMRelationType());
        if (spaceRelationIcon9 != null) {
            drawable15 = androidx.core.content.a.getDrawable(this, spaceRelationIcon9.intValue());
        } else {
            drawable15 = null;
        }
        imageView11.setImageDrawable(drawable15);
        ProgressBar progressBar = ((ActivityCpSpaceBinding) getBinding()).progressBar;
        Integer spaceRelationIcon10 = relationTypeUtils.spaceRelationIcon10(getViewModel().getMRelationType());
        if (spaceRelationIcon10 != null) {
            drawable16 = androidx.core.content.a.getDrawable(this, spaceRelationIcon10.intValue());
        } else {
            drawable16 = null;
        }
        progressBar.setProgressDrawable(drawable16);
        FrameLayout frameLayout = ((ActivityCpSpaceBinding) getBinding()).privilegeLayout;
        Integer spaceRelationIcon11 = relationTypeUtils.spaceRelationIcon11(getViewModel().getMRelationType());
        if (spaceRelationIcon11 != null) {
            drawable17 = androidx.core.content.a.getDrawable(this, spaceRelationIcon11.intValue());
        } else {
            drawable17 = null;
        }
        frameLayout.setBackground(drawable17);
        TextView textView4 = ((ActivityCpSpaceBinding) getBinding()).privilegeTitle;
        Integer spaceRelationIcon12 = relationTypeUtils.spaceRelationIcon12(getViewModel().getMRelationType());
        if (spaceRelationIcon12 != null) {
            drawable18 = androidx.core.content.a.getDrawable(this, spaceRelationIcon12.intValue());
        } else {
            drawable18 = null;
        }
        textView4.setBackground(drawable18);
        Integer spaceRelationIcon13 = relationTypeUtils.spaceRelationIcon13(getViewModel().getMRelationType());
        if (spaceRelationIcon13 != null) {
            ((ActivityCpSpaceBinding) getBinding()).myCpLayout.setBackgroundColor(spaceRelationIcon13.intValue());
        }
        TextView textView5 = ((ActivityCpSpaceBinding) getBinding()).myCp;
        Integer spaceRelationIcon14 = relationTypeUtils.spaceRelationIcon14(getViewModel().getMRelationType());
        if (spaceRelationIcon14 != null) {
            drawable19 = androidx.core.content.a.getDrawable(this, spaceRelationIcon14.intValue());
        }
        textView5.setBackground(drawable19);
        ((ActivityCpSpaceBinding) getBinding()).leftName.setTextColor(relationTypeUtils.spaceRelationDefaultColor(getViewModel().getMRelationType()));
        ((ActivityCpSpaceBinding) getBinding()).rightName.setTextColor(relationTypeUtils.spaceRelationDefaultColor(getViewModel().getMRelationType()));
        ((ActivityCpSpaceBinding) getBinding()).fell.setTextColor(relationTypeUtils.spaceRelationDefaultColor(getViewModel().getMRelationType()));
        ((ActivityCpSpaceBinding) getBinding()).dayNumber.setTextColor(relationTypeUtils.spaceRelationDefaultColor(getViewModel().getMRelationType()));
        ((ActivityCpSpaceBinding) getBinding()).day.setTextColor(relationTypeUtils.spaceRelationDefaultColor(getViewModel().getMRelationType()));
        ((ActivityCpSpaceBinding) getBinding()).cpTip.setTextColor(relationTypeUtils.spaceRelationDefaultColor(getViewModel().getMRelationType()));
        ((ActivityCpSpaceBinding) getBinding()).pointNumber.setTextColor(relationTypeUtils.spaceRelationPointNumberColor(getViewModel().getMRelationType()));
        ((ActivityCpSpaceBinding) getBinding()).pointText.setTextColor(relationTypeUtils.spaceRelationPointNumberColor(getViewModel().getMRelationType()));
        ((ActivityCpSpaceBinding) getBinding()).pointTip.setTextColor(relationTypeUtils.spaceRelationPointTipColor(getViewModel().getMRelationType()));
        ((ActivityCpSpaceBinding) getBinding()).progressStart.setTextColor(relationTypeUtils.spaceRelationPointTipColor(getViewModel().getMRelationType()));
        ((ActivityCpSpaceBinding) getBinding()).progressEnd.setTextColor(relationTypeUtils.spaceRelationPointTipColor(getViewModel().getMRelationType()));
        ((ActivityCpSpaceBinding) getBinding()).privilegeTitle.setTextColor(relationTypeUtils.spaceRelationPrivilegeTitleColor(getViewModel().getMRelationType()));
        ((ActivityCpSpaceBinding) getBinding()).myCp.setTextColor(relationTypeUtils.spaceRelationMyCpColor(getViewModel().getMRelationType()));
        ((ActivityCpSpaceBinding) getBinding()).time.setTextColor(relationTypeUtils.spaceRelationTimeColor(getViewModel().getMRelationType()));
        ((ActivityCpSpaceBinding) getBinding()).unBindText.setTextColor(relationTypeUtils.spaceRelationTimeColor(getViewModel().getMRelationType()));
        TextView textView6 = ((ActivityCpSpaceBinding) getBinding()).applyContent;
        if (getViewModel().getMRelationType() == 1) {
            i = 2131952400;
        } else {
            i = 2131952016;
        }
        textView6.setText(ResourcesKtxKt.getStringById(this, i));
        TextView textView7 = ((ActivityCpSpaceBinding) getBinding()).bindCp;
        if (getViewModel().getMRelationType() == 1) {
            i2 = 2131952116;
        } else {
            i2 = 2131952121;
        }
        textView7.setText(ResourcesKtxKt.getStringById(this, i2));
        TextView textView8 = ((ActivityCpSpaceBinding) getBinding()).pointText;
        if (getViewModel().getMRelationType() == 1) {
            i3 = 2131952428;
        } else {
            i3 = 2131953889;
        }
        textView8.setText(ResourcesKtxKt.getStringById(this, i3));
        TextView textView9 = ((ActivityCpSpaceBinding) getBinding()).fell;
        if (getViewModel().getMRelationType() == 1) {
            i4 = 2131952411;
        } else {
            i4 = 2131952119;
        }
        textView9.setText(ResourcesKtxKt.getStringById(this, i4));
        int mRelationType = getViewModel().getMRelationType();
        if (mRelationType != 1) {
            if (mRelationType != 2) {
                if (mRelationType != 3) {
                    if (mRelationType == 4) {
                        TextView textView10 = ((ActivityCpSpaceBinding) getBinding()).certificateText;
                        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
                        textView10.setBackground(ShapeUtil.createShapeStroke$default(shapeUtil, "#ffffff", 8, 1.0f, false, "#FF396C", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null));
                        ((ActivityCpSpaceBinding) getBinding()).visit.setBackground(ShapeUtil.createShapeStroke$default(shapeUtil, "#ffffff", 11, 1.0f, false, "#8d3727", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null));
                        ((ActivityCpSpaceBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.getStringById(this, 2131953080));
                        ((ActivityCpSpaceBinding) getBinding()).myCp.setText(ResourcesKtxKt.getStringById(this, 2131953497));
                        ((ActivityCpSpaceBinding) getBinding()).cpTip.setText(ResourcesKtxKt.getStringById(this, 2131952629));
                        return;
                    }
                    return;
                }
                TextView textView11 = ((ActivityCpSpaceBinding) getBinding()).certificateText;
                ShapeUtil shapeUtil2 = ShapeUtil.INSTANCE;
                textView11.setBackground(ShapeUtil.createShapeStroke$default(shapeUtil2, "#ffffff", 8, 1.0f, false, "#FF396C", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null));
                ((ActivityCpSpaceBinding) getBinding()).visit.setBackground(ShapeUtil.createShapeStroke$default(shapeUtil2, "#ffffff", 11, 1.0f, false, "#FC67FF", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null));
                ((ActivityCpSpaceBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.getStringById(this, 2131952105));
                ((ActivityCpSpaceBinding) getBinding()).myCp.setText(ResourcesKtxKt.getStringById(this, 2131953493));
                ((ActivityCpSpaceBinding) getBinding()).cpTip.setText(ResourcesKtxKt.getStringById(this, 2131952628));
                return;
            }
            TextView textView12 = ((ActivityCpSpaceBinding) getBinding()).certificateText;
            ShapeUtil shapeUtil3 = ShapeUtil.INSTANCE;
            textView12.setBackground(ShapeUtil.createShapeStroke$default(shapeUtil3, "#ffffff", 8, 1.0f, false, "#FF396C", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null));
            ((ActivityCpSpaceBinding) getBinding()).visit.setBackground(ShapeUtil.createShapeStroke$default(shapeUtil3, "#ffffff", 11, 1.0f, false, "#4eaaff", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null));
            ((ActivityCpSpaceBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.getStringById(this, 2131954111));
            ((ActivityCpSpaceBinding) getBinding()).myCp.setText(ResourcesKtxKt.getStringById(this, 2131953501));
            ((ActivityCpSpaceBinding) getBinding()).cpTip.setText(ResourcesKtxKt.getStringById(this, 2131952630));
            return;
        }
        TextView textView13 = ((ActivityCpSpaceBinding) getBinding()).visit;
        ShapeUtil shapeUtil4 = ShapeUtil.INSTANCE;
        textView13.setBackground(ShapeUtil.createShapeStroke$default(shapeUtil4, "#ffffff", 11, 1.0f, false, "#ff8aaf", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null));
        ((ActivityCpSpaceBinding) getBinding()).memorialText.setBackground(ShapeUtil.createShapeStroke$default(shapeUtil4, "#ffffff", 8, 1.0f, false, "#ff396c", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null));
        ((ActivityCpSpaceBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.getStringById(this, 2131952450));
        ((ActivityCpSpaceBinding) getBinding()).myCp.setText(ResourcesKtxKt.getStringById(this, 2131953494));
        ((ActivityCpSpaceBinding) getBinding()).cpTip.setText(ResourcesKtxKt.getStringById(this, 2131952423));
    }

    public static final CpSpaceViewModel viewModel_delegate$lambda$1(CpSpaceActivity cpSpaceActivity) {
        return new ViewModelProvider(cpSpaceActivity).get(CpSpaceViewModel.class);
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_cp_space;
    }

    public final int getMPosition() {
        return this.mPosition;
    }

    @NotNull
    public final ArrayList<CpResLevel> getResLevelList() {
        return this.resLevelList;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }

    public final void refreshPoints() {
        int i;
        CpResLevel cpResLevel;
        long j;
        long j2;
        Object valueOf;
        Long maxLevel;
        String str;
        int i2;
        long j3;
        int i3;
        int i4;
        Integer num;
        Long l;
        long j4;
        int i5;
        int i6;
        Integer endPoints;
        Long points;
        long j5;
        long j6;
        long j7;
        long j8;
        Long endPoints2;
        Long points2;
        Long endPoints3;
        Long startPoints;
        Integer level;
        Long points3;
        Integer endPoints4;
        Long points4;
        Long maxLevel2;
        List resLevelList;
        CpSpace cpSpace = (CpSpace) getViewModel().getCpSpace().getValue();
        if (cpSpace != null) {
            List resLevelList2 = cpSpace.getResLevelList();
            if (resLevelList2 != null) {
                i = resLevelList2.size();
            } else {
                i = 0;
            }
            if (i > getBinding().banner.getCurrentItem() && (resLevelList = cpSpace.getResLevelList()) != null) {
                cpResLevel = (CpResLevel) resLevelList.get(getBinding().banner.getCurrentItem());
            } else {
                cpResLevel = null;
            }
            CpLevel cpLevel = cpSpace.getCpLevel();
            if (cpLevel != null && (maxLevel2 = cpLevel.getMaxLevel()) != null) {
                j = maxLevel2.longValue();
            } else {
                j = 0;
            }
            if (j > getBinding().banner.getCurrentItem()) {
                valueOf = Integer.valueOf(getBinding().banner.getCurrentItem() + 1);
            } else {
                CpLevel cpLevel2 = cpSpace.getCpLevel();
                if (cpLevel2 != null && (maxLevel = cpLevel2.getMaxLevel()) != null) {
                    j2 = maxLevel.longValue();
                } else {
                    j2 = 0;
                }
                valueOf = Long.valueOf(j2);
            }
            TextView textView = getBinding().pointNumber;
            CpLevel cpLevel3 = cpSpace.getCpLevel();
            if (cpLevel3 == null || (points4 = cpLevel3.getPoints()) == null || (str = points4.toString()) == null) {
                str = "";
            }
            textView.setText(str);
            if (cpResLevel != null && (endPoints4 = cpResLevel.getEndPoints()) != null) {
                i2 = endPoints4.intValue();
            } else {
                i2 = 0;
            }
            long j9 = i2;
            CpLevel cpLevel4 = cpSpace.getCpLevel();
            if (cpLevel4 != null && (points3 = cpLevel4.getPoints()) != null) {
                j3 = points3.longValue();
            } else {
                j3 = 0;
            }
            long j10 = j9 - j3;
            if (j10 < 0) {
                j10 = 0;
            }
            CpLevel cpLevel5 = cpSpace.getCpLevel();
            if (cpLevel5 != null && (level = cpLevel5.getLevel()) != null) {
                i3 = level.intValue();
            } else {
                i3 = 0;
            }
            if (i3 > getBinding().banner.getCurrentItem()) {
                getBinding().pointTip.setText(ResourcesKtxKt.getStringById(this, 2131952416));
                getBinding().keepTip.setVisibility(8);
            } else if (i3 == getBinding().banner.getCurrentItem()) {
                TextView textView2 = getBinding().keepTip;
                String stringById = ResourcesKtxKt.getStringById(this, 2131953888);
                CpLevel cpLevel6 = cpSpace.getCpLevel();
                if (cpLevel6 != null) {
                    l = cpLevel6.getKeepPoints();
                } else {
                    l = null;
                }
                String format = String.format(stringById, Arrays.copyOf(new Object[]{l, "LV." + i3}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView2.setText(format);
                CpLevel cpLevel7 = cpSpace.getCpLevel();
                if (cpLevel7 != null && (points = cpLevel7.getPoints()) != null) {
                    j4 = points.longValue();
                } else {
                    j4 = 0;
                }
                if (cpResLevel != null && (endPoints = cpResLevel.getEndPoints()) != null) {
                    i5 = endPoints.intValue();
                } else {
                    i5 = 0;
                }
                if (j4 >= i5) {
                    getBinding().pointTip.setText(ResourcesKtxKt.getStringById(this, 2131952416));
                    getBinding().keepTip.setVisibility(0);
                } else {
                    TextView textView3 = getBinding().pointTip;
                    String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131952449), Arrays.copyOf(new Object[]{String.valueOf(j10), valueOf.toString()}, 2));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                    textView3.setText(format2);
                    TextView textView4 = getBinding().keepTip;
                    if (i3 > 0) {
                        i6 = 0;
                    } else {
                        i6 = 8;
                    }
                    textView4.setVisibility(i6);
                }
            } else {
                getBinding().keepTip.setVisibility(8);
                TextView textView5 = getBinding().pointTip;
                if (getViewModel().getMRelationType() == 1) {
                    i4 = 2131952403;
                } else {
                    i4 = 2131952167;
                }
                String stringById2 = ResourcesKtxKt.getStringById(this, i4);
                if (cpResLevel != null) {
                    num = cpResLevel.getStartPoints();
                } else {
                    num = null;
                }
                String format3 = String.format(stringById2, Arrays.copyOf(new Object[]{num}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                textView5.setText(format3);
            }
            TextView textView6 = getBinding().progressStart;
            CpLevel cpLevel8 = cpSpace.getCpLevel();
            if (cpLevel8 != null && (startPoints = cpLevel8.getStartPoints()) != null) {
                j5 = startPoints.longValue();
            } else {
                j5 = 0;
            }
            textView6.setText(String.valueOf(j5));
            TextView textView7 = getBinding().progressEnd;
            CpLevel cpLevel9 = cpSpace.getCpLevel();
            if (cpLevel9 != null && (endPoints3 = cpLevel9.getEndPoints()) != null) {
                j6 = endPoints3.longValue();
            } else {
                j6 = 0;
            }
            textView7.setText(String.valueOf(j6));
            CpLevel cpLevel10 = cpSpace.getCpLevel();
            if (cpLevel10 != null && (points2 = cpLevel10.getPoints()) != null) {
                j7 = points2.longValue();
            } else {
                j7 = 0;
            }
            double d = j7 * 100.0d;
            CpLevel cpLevel11 = cpSpace.getCpLevel();
            if (cpLevel11 != null && (endPoints2 = cpLevel11.getEndPoints()) != null) {
                j8 = endPoints2.longValue();
            } else {
                j8 = 1;
            }
            getBinding().progressBar.setProgress((int) (d / j8));
            CpLevel cpLevel12 = cpSpace.getCpLevel();
            if (cpLevel12 != null) {
                int currentItem = getBinding().banner.getCurrentItem();
                Integer level2 = cpLevel12.getLevel();
                if (level2 != null && currentItem == level2.intValue()) {
                    getBinding().pointGroup.setVisibility(0);
                    return;
                }
            }
            getBinding().pointGroup.setVisibility(8);
        }
    }

    public final void setMPosition(int i) {
        this.mPosition = i;
    }
}
