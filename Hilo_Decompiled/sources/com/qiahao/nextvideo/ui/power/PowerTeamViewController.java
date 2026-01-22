package com.qiahao.nextvideo.ui.power;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.data.model.PowerTeamMemberBean;
import com.qiahao.nextvideo.data.model.PowerUser;
import com.qiahao.nextvideo.databinding.ViewControllerPowerTeamBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.TabEntity;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmPreloadModel;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewController;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate;
import com.qiahao.nextvideo.ui.rank.CommonViewPagerAdapter;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 E2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001EB\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u000bJ'\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\"\u0010 J\u0017\u0010#\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b#\u0010 J\u0017\u0010$\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b$\u0010 J\u001f\u0010(\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00182\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\tH\u0016¢\u0006\u0004\b*\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010+\u001a\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R$\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u001101j\b\u0012\u0004\u0012\u00020\u0011`28\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001b\u0010:\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001b\u0010=\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u00107\u001a\u0004\b<\u00109R$\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lcom/qiahao/nextvideo/ui/power/PowerTeamViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Landroidx/viewpager/widget/ViewPager$j;", "Lo6/b;", "Lcom/qiahao/nextvideo/ui/edition/country/confirmtip/ConfirmTipViewControllerDelegate;", "", "powerId", "<init>", "(J)V", "", "initRecyclerView", "()V", "showDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;", "view", "viewDidLoad", "(Landroid/view/View;)V", "getData", "", "position", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", "state", "onPageScrollStateChanged", "onTabSelect", "onTabReselect", "fromCode", "Landroid/os/Bundle;", "extra", "confirmTipViewControllerDidConfirm", "(ILandroid/os/Bundle;)V", "confirmTipViewControllerDidCancel", "J", "getPowerId", "()J", "Lcom/qiahao/nextvideo/databinding/ViewControllerPowerTeamBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerPowerTeamBinding;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pageViews", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/ui/power/PowerTeamUserAdapter;", "mPowerOwnerTeamUserAdapter$delegate", "Lkotlin/Lazy;", "getMPowerOwnerTeamUserAdapter", "()Lcom/qiahao/nextvideo/ui/power/PowerTeamUserAdapter;", "mPowerOwnerTeamUserAdapter", "mAssistantTeamUserAdapter$delegate", "getMAssistantTeamUserAdapter", "mAssistantTeamUserAdapter", "Lcom/qiahao/nextvideo/ui/power/PowerMedalWrapper;", "lastWeekPowerMedalWrapper", "Lcom/qiahao/nextvideo/ui/power/PowerMedalWrapper;", "getLastWeekPowerMedalWrapper", "()Lcom/qiahao/nextvideo/ui/power/PowerMedalWrapper;", "setLastWeekPowerMedalWrapper", "(Lcom/qiahao/nextvideo/ui/power/PowerMedalWrapper;)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPowerTeamViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PowerTeamViewController.kt\ncom/qiahao/nextvideo/ui/power/PowerTeamViewController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,182:1\n1#2:183\n13472#3,2:184\n*S KotlinDebug\n*F\n+ 1 PowerTeamViewController.kt\ncom/qiahao/nextvideo/ui/power/PowerTeamViewController\n*L\n77#1:184,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PowerTeamViewController extends BaseViewController implements ViewPager.j, o6.b, ConfirmTipViewControllerDelegate {

    @NotNull
    private static final String TAG = "PowerTeamViewController";
    private ViewControllerPowerTeamBinding binding;

    @Nullable
    private PowerMedalWrapper lastWeekPowerMedalWrapper;

    /* renamed from: mAssistantTeamUserAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAssistantTeamUserAdapter;

    /* renamed from: mPowerOwnerTeamUserAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPowerOwnerTeamUserAdapter;

    @NotNull
    private final ArrayList<View> pageViews;
    private final long powerId;

    public PowerTeamViewController(long j) {
        this.powerId = j;
        setTag(TAG);
        this.pageViews = new ArrayList<>();
        this.mPowerOwnerTeamUserAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.power.v
            public final Object invoke() {
                PowerTeamUserAdapter mPowerOwnerTeamUserAdapter_delegate$lambda$0;
                mPowerOwnerTeamUserAdapter_delegate$lambda$0 = PowerTeamViewController.mPowerOwnerTeamUserAdapter_delegate$lambda$0();
                return mPowerOwnerTeamUserAdapter_delegate$lambda$0;
            }
        });
        this.mAssistantTeamUserAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.power.w
            public final Object invoke() {
                PowerTeamUserAdapter mAssistantTeamUserAdapter_delegate$lambda$1;
                mAssistantTeamUserAdapter_delegate$lambda$1 = PowerTeamViewController.mAssistantTeamUserAdapter_delegate$lambda$1();
                return mAssistantTeamUserAdapter_delegate$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$7(PowerTeamViewController powerTeamViewController, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        PowerTeamMemberBean powerTeamMemberBean = (PowerTeamMemberBean) apiResponse.getData();
        if (powerTeamMemberBean != null) {
            if (!powerTeamMemberBean.getOwers().isEmpty()) {
                powerTeamViewController.getMPowerOwnerTeamUserAdapter().setMIsPowerOwn(true);
                powerTeamViewController.getMPowerOwnerTeamUserAdapter().setList(powerTeamMemberBean.getOwers());
            }
            List<PowerUser> assistants = powerTeamMemberBean.getAssistants();
            if (assistants != null && !assistants.isEmpty()) {
                powerTeamViewController.getMAssistantTeamUserAdapter().setMIsPowerOwn(false);
                powerTeamViewController.getMAssistantTeamUserAdapter().setList(powerTeamMemberBean.getAssistants());
            }
            PowerMedalWrapper powerMedalWrapper = powerTeamViewController.lastWeekPowerMedalWrapper;
            if (powerMedalWrapper != null) {
                powerMedalWrapper.initDataAndView(powerTeamMemberBean.getLastWeek());
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$8(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final PowerTeamUserAdapter getMAssistantTeamUserAdapter() {
        return (PowerTeamUserAdapter) this.mAssistantTeamUserAdapter.getValue();
    }

    private final PowerTeamUserAdapter getMPowerOwnerTeamUserAdapter() {
        return (PowerTeamUserAdapter) this.mPowerOwnerTeamUserAdapter.getValue();
    }

    private final void initRecyclerView() {
        ViewControllerPowerTeamBinding viewControllerPowerTeamBinding = this.binding;
        ViewControllerPowerTeamBinding viewControllerPowerTeamBinding2 = null;
        if (viewControllerPowerTeamBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerTeamBinding = null;
        }
        RecyclerView recyclerView = viewControllerPowerTeamBinding.ownerRecycleView;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getMPowerOwnerTeamUserAdapter());
        getMPowerOwnerTeamUserAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.power.x
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PowerTeamViewController.initRecyclerView$lambda$10(baseQuickAdapter, view, i);
            }
        });
        ViewControllerPowerTeamBinding viewControllerPowerTeamBinding3 = this.binding;
        if (viewControllerPowerTeamBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerTeamBinding3 = null;
        }
        RecyclerView recyclerView2 = viewControllerPowerTeamBinding3.assistantRecycleView;
        recyclerView2.setLayoutManager(new CustomLinearLayoutManager(recyclerView2.getContext()));
        recyclerView2.setAdapter(getMAssistantTeamUserAdapter());
        getMAssistantTeamUserAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.power.y
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PowerTeamViewController.initRecyclerView$lambda$12(baseQuickAdapter, view, i);
            }
        });
        ViewControllerPowerTeamBinding viewControllerPowerTeamBinding4 = this.binding;
        if (viewControllerPowerTeamBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerPowerTeamBinding2 = viewControllerPowerTeamBinding4;
        }
        viewControllerPowerTeamBinding2.icQuestion.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.power.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PowerTeamViewController.this.showDialog();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$10(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.PowerUser");
        PowerUser powerUser = (PowerUser) item;
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openPersonPage(powerUser.getExternalId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$12(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.PowerUser");
        PowerUser powerUser = (PowerUser) item;
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openPersonPage(powerUser.getExternalId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PowerTeamUserAdapter mAssistantTeamUserAdapter_delegate$lambda$1() {
        return new PowerTeamUserAdapter(R.layout.item_power_team_member_manager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PowerTeamUserAdapter mPowerOwnerTeamUserAdapter_delegate$lambda$0() {
        return new PowerTeamUserAdapter(R.layout.item_power_team_member_manager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDialog() {
        ConfirmTipViewController confirmTipViewController = new ConfirmTipViewController(ConfirmPreloadModel.INSTANCE.init(ResourcesKtxKt.getStringById(this, 2131953704), ResourcesKtxKt.getStringById(this, 2131953574), null), null, 2, null);
        confirmTipViewController.setDelegate(this);
        ViewController.present$default(this, confirmTipViewController, true, null, 4, null);
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidCancel() {
        ViewController.dismiss$default(this, true, null, 2, null);
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidConfirm(int fromCode, @NotNull Bundle extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        ViewController.dismiss$default(this, true, null, 2, null);
    }

    public final void getData() {
        RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getPowerTeamMember(this.powerId), new Function1() { // from class: com.qiahao.nextvideo.ui.power.t
            public final Object invoke(Object obj) {
                Unit data$lambda$7;
                data$lambda$7 = PowerTeamViewController.getData$lambda$7(PowerTeamViewController.this, (ApiResponse) obj);
                return data$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.power.u
            public final Object invoke(Object obj) {
                Unit data$lambda$8;
                data$lambda$8 = PowerTeamViewController.getData$lambda$8((Throwable) obj);
                return data$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    @Nullable
    public final PowerMedalWrapper getLastWeekPowerMedalWrapper() {
        return this.lastWeekPowerMedalWrapper;
    }

    public final long getPowerId() {
        return this.powerId;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerPowerTeamBinding inflate = ViewControllerPowerTeamBinding.inflate(inflater, container, false);
        this.binding = inflate;
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onPageScrollStateChanged(int state) {
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    public void onPageSelected(int position) {
        ViewControllerPowerTeamBinding viewControllerPowerTeamBinding = this.binding;
        if (viewControllerPowerTeamBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerTeamBinding = null;
        }
        viewControllerPowerTeamBinding.commonTabLayout.setCurrentTab(position);
    }

    public void onTabReselect(int position) {
    }

    public void onTabSelect(int position) {
        ViewControllerPowerTeamBinding viewControllerPowerTeamBinding = this.binding;
        if (viewControllerPowerTeamBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerTeamBinding = null;
        }
        viewControllerPowerTeamBinding.viewPager.setCurrentItem(position);
    }

    public final void setLastWeekPowerMedalWrapper(@Nullable PowerMedalWrapper powerMedalWrapper) {
        this.lastWeekPowerMedalWrapper = powerMedalWrapper;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        HiloBaseActivity requireActivity = getRequireActivity();
        ViewControllerPowerTeamBinding viewControllerPowerTeamBinding = this.binding;
        ViewControllerPowerTeamBinding viewControllerPowerTeamBinding2 = null;
        if (viewControllerPowerTeamBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerTeamBinding = null;
        }
        Toolbar toolbar = viewControllerPowerTeamBinding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        requireActivity.setStatusBarTopOrBottom(toolbar, false);
        PowerMedalWrapper init = PowerMedalWrapper.INSTANCE.init(this);
        this.lastWeekPowerMedalWrapper = init;
        ArrayList<View> arrayList = this.pageViews;
        Intrinsics.checkNotNull(init);
        arrayList.add(init);
        ViewControllerPowerTeamBinding viewControllerPowerTeamBinding3 = this.binding;
        if (viewControllerPowerTeamBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerTeamBinding3 = null;
        }
        viewControllerPowerTeamBinding3.viewPager.setAdapter(new CommonViewPagerAdapter(this.pageViews));
        ViewControllerPowerTeamBinding viewControllerPowerTeamBinding4 = this.binding;
        if (viewControllerPowerTeamBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerTeamBinding4 = null;
        }
        viewControllerPowerTeamBinding4.viewPager.setOffscreenPageLimit(this.pageViews.size());
        ViewControllerPowerTeamBinding viewControllerPowerTeamBinding5 = this.binding;
        if (viewControllerPowerTeamBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerTeamBinding5 = null;
        }
        viewControllerPowerTeamBinding5.viewPager.setCurrentItem(0);
        ViewControllerPowerTeamBinding viewControllerPowerTeamBinding6 = this.binding;
        if (viewControllerPowerTeamBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerTeamBinding6 = null;
        }
        viewControllerPowerTeamBinding6.viewPager.addOnPageChangeListener(this);
        ViewControllerPowerTeamBinding viewControllerPowerTeamBinding7 = this.binding;
        if (viewControllerPowerTeamBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerTeamBinding7 = null;
        }
        viewControllerPowerTeamBinding7.commonTabLayout.setOnTabSelectListener(this);
        String[] strArr = {ResourcesKtxKt.getStringById(this, 2131953196)};
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new TabEntity(strArr[0], 0, 0));
        ViewControllerPowerTeamBinding viewControllerPowerTeamBinding8 = this.binding;
        if (viewControllerPowerTeamBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerTeamBinding8 = null;
        }
        viewControllerPowerTeamBinding8.commonTabLayout.setTabData(arrayList2);
        ViewControllerPowerTeamBinding viewControllerPowerTeamBinding9 = this.binding;
        if (viewControllerPowerTeamBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerTeamBinding9 = null;
        }
        viewControllerPowerTeamBinding9.commonTabLayout.setCurrentTab(0);
        ViewControllerPowerTeamBinding viewControllerPowerTeamBinding10 = this.binding;
        if (viewControllerPowerTeamBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerPowerTeamBinding2 = viewControllerPowerTeamBinding10;
        }
        viewControllerPowerTeamBinding2.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.power.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ViewController.dismiss$default(PowerTeamViewController.this, true, null, 2, null);
            }
        });
        initRecyclerView();
        getData();
    }
}
