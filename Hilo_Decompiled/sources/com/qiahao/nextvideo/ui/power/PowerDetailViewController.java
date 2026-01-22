package com.qiahao.nextvideo.ui.power;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.google.android.material.appbar.AppBarLayout;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.cache.MMKVToLocalCache;
import com.qiahao.nextvideo.data.model.GroupPowerTitleDetail;
import com.qiahao.nextvideo.data.model.PowerGroupMemberBean;
import com.qiahao.nextvideo.data.model.PowerManagers;
import com.qiahao.nextvideo.databinding.PowerDetailViewControllerBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmPreloadModel;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewController;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate;
import com.qiahao.nextvideo.ui.rank.PowerRoomAdapter;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ]2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001]B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u000fJ\u000f\u0010\u0016\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u000fJ\u000f\u0010\u0017\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u000fJ\u001f\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001cH\u0016¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\r¢\u0006\u0004\b\"\u0010\u000fJ\u0017\u0010%\u001a\u00020\r2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\r2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b'\u0010&J\u0017\u0010)\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u001cH\u0016¢\u0006\u0004\b)\u0010!J\u000f\u0010*\u001a\u00020\rH\u0016¢\u0006\u0004\b*\u0010\u000fJ\r\u0010+\u001a\u00020\r¢\u0006\u0004\b+\u0010\u000fJ\u001f\u00100\u001a\u00020\r2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\rH\u0016¢\u0006\u0004\b2\u0010\u000fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u00103\u001a\u0004\b4\u00105R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u00106\u001a\u0004\b\n\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b9\u0010:R$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010B\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010H\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010C\u001a\u0004\bI\u0010E\"\u0004\bJ\u0010GR\u001b\u0010P\u001a\u00020K8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001b\u0010U\u001a\u00020Q8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bR\u0010M\u001a\u0004\bS\u0010TR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010\u0013R\u0018\u0010[\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\¨\u0006^"}, d2 = {"Lcom/qiahao/nextvideo/ui/power/PowerDetailViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Lvc/e;", "Lvc/g;", "Landroid/view/View$OnClickListener;", "Lcom/qiahao/nextvideo/ui/power/PowerMenuViewControllerDelegate;", "Lcom/qiahao/nextvideo/ui/edition/country/confirmtip/ConfirmTipViewControllerDelegate;", "", "powerId", "", "isFromActivity", "<init>", "(JZ)V", "", "initDataFromCache", "()V", "Lcom/qiahao/nextvideo/data/model/GroupPowerTitleDetail;", "groupPowerTitleDetail", "initView", "(Lcom/qiahao/nextvideo/data/model/GroupPowerTitleDetail;)V", "fullManagerRecyclerView", "initRecyclerView", "initAppBarView", "joinPowerDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;", "view", "viewDidLoad", "(Landroid/view/View;)V", "getData", "Ltc/f;", "refreshLayout", "onLoadMore", "(Ltc/f;)V", "onRefresh", "v", "onClick", "confirmleave", "showLeaveTip", "", "fromCode", "Landroid/os/Bundle;", "extra", "confirmTipViewControllerDidConfirm", "(ILandroid/os/Bundle;)V", "confirmTipViewControllerDidCancel", "J", "getPowerId", "()J", "Z", "()Z", "Lcom/qiahao/nextvideo/databinding/PowerDetailViewControllerBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/PowerDetailViewControllerBinding;", "Lcom/qiahao/nextvideo/ui/power/PowerDetailListener;", "delegate", "Lcom/qiahao/nextvideo/ui/power/PowerDetailListener;", "getDelegate", "()Lcom/qiahao/nextvideo/ui/power/PowerDetailListener;", "setDelegate", "(Lcom/qiahao/nextvideo/ui/power/PowerDetailListener;)V", "mPageIndex", "I", "getMPageIndex", "()I", "setMPageIndex", "(I)V", "mPageSize", "getMPageSize", "setMPageSize", "Lcom/qiahao/nextvideo/ui/rank/PowerRoomAdapter;", "powerRoomAdapter$delegate", "Lkotlin/Lazy;", "getPowerRoomAdapter", "()Lcom/qiahao/nextvideo/ui/rank/PowerRoomAdapter;", "powerRoomAdapter", "Lcom/qiahao/nextvideo/ui/power/PowerManagerAdapter;", "powerManagerAdapter$delegate", "getPowerManagerAdapter", "()Lcom/qiahao/nextvideo/ui/power/PowerManagerAdapter;", "powerManagerAdapter", "Lcom/qiahao/nextvideo/data/model/GroupPowerTitleDetail;", "getGroupPowerTitleDetail", "()Lcom/qiahao/nextvideo/data/model/GroupPowerTitleDetail;", "setGroupPowerTitleDetail", "Lcom/qiahao/nextvideo/ui/power/CollapsingToolbarLayoutState;", "state", "Lcom/qiahao/nextvideo/ui/power/CollapsingToolbarLayoutState;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPowerDetailViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PowerDetailViewController.kt\ncom/qiahao/nextvideo/ui/power/PowerDetailViewController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,459:1\n1#2:460\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PowerDetailViewController extends BaseViewController implements vc.e, vc.g, View.OnClickListener, PowerMenuViewControllerDelegate, ConfirmTipViewControllerDelegate {

    @NotNull
    private static final String TAG = "PowerDetailViewControll";
    private PowerDetailViewControllerBinding binding;

    @Nullable
    private PowerDetailListener delegate;

    @Nullable
    private GroupPowerTitleDetail groupPowerTitleDetail;
    private final boolean isFromActivity;
    private int mPageIndex;
    private int mPageSize;
    private final long powerId;

    /* renamed from: powerManagerAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy powerManagerAdapter;

    /* renamed from: powerRoomAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy powerRoomAdapter;

    @Nullable
    private CollapsingToolbarLayoutState state;

    public /* synthetic */ PowerDetailViewController(long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? false : z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmTipViewControllerDidConfirm$lambda$27(PowerDetailViewController powerDetailViewController, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, powerDetailViewController.getContext(), ResourcesKtxKt.getStringById(powerDetailViewController, 2131954177), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            PowerDetailViewControllerBinding powerDetailViewControllerBinding = powerDetailViewController.binding;
            if (powerDetailViewControllerBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                powerDetailViewControllerBinding = null;
            }
            powerDetailViewControllerBinding.join.setText(ResourcesKtxKt.getStringById(powerDetailViewController, 2131953154));
            PowerDetailViewControllerBinding powerDetailViewControllerBinding2 = powerDetailViewController.binding;
            if (powerDetailViewControllerBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                powerDetailViewControllerBinding2 = null;
            }
            powerDetailViewControllerBinding2.moreBtn.setVisibility(8);
            PowerDetailViewControllerBinding powerDetailViewControllerBinding3 = powerDetailViewController.binding;
            if (powerDetailViewControllerBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                powerDetailViewControllerBinding3 = null;
            }
            powerDetailViewControllerBinding3.join.setClickable(true);
            UserStore.fetchUserDetailInfo$default(UserStore.INSTANCE.getShared(), false, 1, null);
        } else {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = powerDetailViewController.getContext();
            String message = apiResponse.getMessage();
            if (message == null) {
                message = ResourcesKtxKt.getStringById(powerDetailViewController, 2131952667);
            }
            Toast normal$default2 = HiloToasty.Companion.normal$default(companion, context, message, false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
        ViewController.dismiss$default(powerDetailViewController, true, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmTipViewControllerDidConfirm$lambda$28(PowerDetailViewController powerDetailViewController, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Log.d(TAG, "confirmTipViewControllerDidConfirm: " + th.getLocalizedMessage());
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = powerDetailViewController.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(powerDetailViewController, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        ViewController.dismiss$default(powerDetailViewController, true, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmleave$lambda$25(PowerDetailViewController powerDetailViewController) {
        powerDetailViewController.showLeaveTip();
        return Unit.INSTANCE;
    }

    private final void fullManagerRecyclerView(GroupPowerTitleDetail groupPowerTitleDetail) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(groupPowerTitleDetail.getOwner());
        List<PowerManagers> assistants = groupPowerTitleDetail.getAssistants();
        if (assistants != null && !assistants.isEmpty()) {
            arrayList.addAll(groupPowerTitleDetail.getAssistants());
        }
        getPowerManagerAdapter().setList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$5(PowerDetailViewController powerDetailViewController, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        GroupPowerTitleDetail groupPowerTitleDetail = (GroupPowerTitleDetail) apiResponse.getData();
        if (groupPowerTitleDetail != null) {
            powerDetailViewController.groupPowerTitleDetail = groupPowerTitleDetail;
            MMKVToLocalCache.INSTANCE.savePowerDetailCache(groupPowerTitleDetail);
            powerDetailViewController.initView(groupPowerTitleDetail);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$6(PowerDetailViewController powerDetailViewController, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = powerDetailViewController.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = BaseViewControllerKt.getString(powerDetailViewController, 2131952667, new Object[0]);
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        Log.d(TAG, "getData: " + th.getLocalizedMessage());
        return Unit.INSTANCE;
    }

    private final void initAppBarView() {
        PowerDetailViewControllerBinding powerDetailViewControllerBinding = this.binding;
        PowerDetailViewControllerBinding powerDetailViewControllerBinding2 = null;
        if (powerDetailViewControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            powerDetailViewControllerBinding = null;
        }
        powerDetailViewControllerBinding.appBar.addOnOffsetChangedListener(new AppBarLayout.h() { // from class: com.qiahao.nextvideo.ui.power.j
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                PowerDetailViewController.initAppBarView$lambda$15(PowerDetailViewController.this, appBarLayout, i);
            }
        });
        PowerDetailViewControllerBinding powerDetailViewControllerBinding3 = this.binding;
        if (powerDetailViewControllerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            powerDetailViewControllerBinding2 = powerDetailViewControllerBinding3;
        }
        powerDetailViewControllerBinding2.constraint.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.power.k
            @Override // java.lang.Runnable
            public final void run() {
                PowerDetailViewController.initAppBarView$lambda$16(PowerDetailViewController.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAppBarView$lambda$15(PowerDetailViewController powerDetailViewController, AppBarLayout appBarLayout, int i) {
        PowerDetailViewControllerBinding powerDetailViewControllerBinding = null;
        if (i == 0) {
            CollapsingToolbarLayoutState collapsingToolbarLayoutState = powerDetailViewController.state;
            CollapsingToolbarLayoutState collapsingToolbarLayoutState2 = CollapsingToolbarLayoutState.EXPANDED;
            if (collapsingToolbarLayoutState != collapsingToolbarLayoutState2) {
                powerDetailViewController.state = collapsingToolbarLayoutState2;
                PowerDetailViewControllerBinding powerDetailViewControllerBinding2 = powerDetailViewController.binding;
                if (powerDetailViewControllerBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    powerDetailViewControllerBinding = powerDetailViewControllerBinding2;
                }
                powerDetailViewControllerBinding.collapsingToolbarLayout.setTitle("EXPANDED");
                return;
            }
            return;
        }
        int abs = Math.abs(i);
        PowerDetailViewControllerBinding powerDetailViewControllerBinding3 = powerDetailViewController.binding;
        if (powerDetailViewControllerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            powerDetailViewControllerBinding3 = null;
        }
        if (abs >= powerDetailViewControllerBinding3.appBar.getTotalScrollRange()) {
            CollapsingToolbarLayoutState collapsingToolbarLayoutState3 = powerDetailViewController.state;
            CollapsingToolbarLayoutState collapsingToolbarLayoutState4 = CollapsingToolbarLayoutState.COLLAPSED;
            if (collapsingToolbarLayoutState3 != collapsingToolbarLayoutState4) {
                PowerDetailViewControllerBinding powerDetailViewControllerBinding4 = powerDetailViewController.binding;
                if (powerDetailViewControllerBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    powerDetailViewControllerBinding4 = null;
                }
                powerDetailViewControllerBinding4.collapsingToolbarLayout.setTitle("");
                PowerDetailViewControllerBinding powerDetailViewControllerBinding5 = powerDetailViewController.binding;
                if (powerDetailViewControllerBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    powerDetailViewControllerBinding5 = null;
                }
                ImageView imageView = powerDetailViewControllerBinding5.moreBtn;
                Intrinsics.checkNotNullExpressionValue(imageView, "moreBtn");
                ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, 2131232083, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                PowerDetailViewControllerBinding powerDetailViewControllerBinding6 = powerDetailViewController.binding;
                if (powerDetailViewControllerBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    powerDetailViewControllerBinding6 = null;
                }
                AppCompatImageView appCompatImageView = powerDetailViewControllerBinding6.backImageView;
                PowerDetailViewControllerBinding powerDetailViewControllerBinding7 = powerDetailViewController.binding;
                if (powerDetailViewControllerBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    powerDetailViewControllerBinding7 = null;
                }
                appCompatImageView.setImageDrawable(androidx.core.content.a.getDrawable(powerDetailViewControllerBinding7.getRoot().getContext(), 2131232456));
                PowerDetailViewControllerBinding powerDetailViewControllerBinding8 = powerDetailViewController.binding;
                if (powerDetailViewControllerBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    powerDetailViewControllerBinding = powerDetailViewControllerBinding8;
                }
                powerDetailViewControllerBinding.titleTextView.setVisibility(0);
                powerDetailViewController.state = collapsingToolbarLayoutState4;
                return;
            }
            return;
        }
        CollapsingToolbarLayoutState collapsingToolbarLayoutState5 = powerDetailViewController.state;
        CollapsingToolbarLayoutState collapsingToolbarLayoutState6 = CollapsingToolbarLayoutState.INTERNEDIATE;
        if (collapsingToolbarLayoutState5 != collapsingToolbarLayoutState6) {
            if (collapsingToolbarLayoutState5 == CollapsingToolbarLayoutState.COLLAPSED) {
                PowerDetailViewControllerBinding powerDetailViewControllerBinding9 = powerDetailViewController.binding;
                if (powerDetailViewControllerBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    powerDetailViewControllerBinding9 = null;
                }
                ImageView imageView2 = powerDetailViewControllerBinding9.moreBtn;
                Intrinsics.checkNotNullExpressionValue(imageView2, "moreBtn");
                ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, 2131232084, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                PowerDetailViewControllerBinding powerDetailViewControllerBinding10 = powerDetailViewController.binding;
                if (powerDetailViewControllerBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    powerDetailViewControllerBinding10 = null;
                }
                AppCompatImageView appCompatImageView2 = powerDetailViewControllerBinding10.backImageView;
                PowerDetailViewControllerBinding powerDetailViewControllerBinding11 = powerDetailViewController.binding;
                if (powerDetailViewControllerBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    powerDetailViewControllerBinding11 = null;
                }
                appCompatImageView2.setImageDrawable(androidx.core.content.a.getDrawable(powerDetailViewControllerBinding11.getRoot().getContext(), 2131232457));
                PowerDetailViewControllerBinding powerDetailViewControllerBinding12 = powerDetailViewController.binding;
                if (powerDetailViewControllerBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    powerDetailViewControllerBinding12 = null;
                }
                powerDetailViewControllerBinding12.titleTextView.setVisibility(8);
            }
            PowerDetailViewControllerBinding powerDetailViewControllerBinding13 = powerDetailViewController.binding;
            if (powerDetailViewControllerBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                powerDetailViewControllerBinding = powerDetailViewControllerBinding13;
            }
            powerDetailViewControllerBinding.collapsingToolbarLayout.setTitle("INTERNEDIATE");
            powerDetailViewController.state = collapsingToolbarLayoutState6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAppBarView$lambda$16(PowerDetailViewController powerDetailViewController) {
        PowerDetailViewControllerBinding powerDetailViewControllerBinding = powerDetailViewController.binding;
        PowerDetailViewControllerBinding powerDetailViewControllerBinding2 = null;
        if (powerDetailViewControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            powerDetailViewControllerBinding = null;
        }
        AppBarLayout.e layoutParams = powerDetailViewControllerBinding.collapsingToolbarLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        AppBarLayout.e eVar = layoutParams;
        PowerDetailViewControllerBinding powerDetailViewControllerBinding3 = powerDetailViewController.binding;
        if (powerDetailViewControllerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            powerDetailViewControllerBinding3 = null;
        }
        ((LinearLayout.LayoutParams) eVar).height = powerDetailViewControllerBinding3.constraint.getHeight();
        PowerDetailViewControllerBinding powerDetailViewControllerBinding4 = powerDetailViewController.binding;
        if (powerDetailViewControllerBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            powerDetailViewControllerBinding2 = powerDetailViewControllerBinding4;
        }
        powerDetailViewControllerBinding2.collapsingToolbarLayout.setLayoutParams(eVar);
    }

    private final void initDataFromCache() {
        GroupPowerTitleDetail powerDetailCache = MMKVToLocalCache.INSTANCE.getPowerDetailCache();
        if (powerDetailCache != null) {
            initView(powerDetailCache);
        }
    }

    private final void initRecyclerView() {
        PowerDetailViewControllerBinding powerDetailViewControllerBinding = this.binding;
        PowerDetailViewControllerBinding powerDetailViewControllerBinding2 = null;
        if (powerDetailViewControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            powerDetailViewControllerBinding = null;
        }
        powerDetailViewControllerBinding.smartRefreshLayout.setEnableRefresh(true);
        PowerDetailViewControllerBinding powerDetailViewControllerBinding3 = this.binding;
        if (powerDetailViewControllerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            powerDetailViewControllerBinding3 = null;
        }
        powerDetailViewControllerBinding3.smartRefreshLayout.setEnableLoadMore(false);
        PowerDetailViewControllerBinding powerDetailViewControllerBinding4 = this.binding;
        if (powerDetailViewControllerBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            powerDetailViewControllerBinding4 = null;
        }
        powerDetailViewControllerBinding4.smartRefreshLayout.setOnLoadMoreListener(this);
        PowerDetailViewControllerBinding powerDetailViewControllerBinding5 = this.binding;
        if (powerDetailViewControllerBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            powerDetailViewControllerBinding5 = null;
        }
        powerDetailViewControllerBinding5.smartRefreshLayout.setOnRefreshListener(this);
        PowerDetailViewControllerBinding powerDetailViewControllerBinding6 = this.binding;
        if (powerDetailViewControllerBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            powerDetailViewControllerBinding6 = null;
        }
        RecyclerView recyclerView = powerDetailViewControllerBinding6.recyclerRoom;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(getContext()));
        recyclerView.setAdapter(getPowerRoomAdapter());
        PowerDetailViewControllerBinding powerDetailViewControllerBinding7 = this.binding;
        if (powerDetailViewControllerBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            powerDetailViewControllerBinding7 = null;
        }
        powerDetailViewControllerBinding7.smartRefreshLayout.autoRefresh();
        PowerDetailViewControllerBinding powerDetailViewControllerBinding8 = this.binding;
        if (powerDetailViewControllerBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            powerDetailViewControllerBinding2 = powerDetailViewControllerBinding8;
        }
        RecyclerView recyclerView2 = powerDetailViewControllerBinding2.managerList;
        recyclerView2.setLayoutManager(new CustomLinearLayoutManager(getContext(), 0, false));
        recyclerView2.setAdapter(getPowerManagerAdapter());
        getPowerManagerAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.power.c
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PowerDetailViewController.initRecyclerView$lambda$12(PowerDetailViewController.this, baseQuickAdapter, view, i);
            }
        });
        getPowerRoomAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.power.d
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PowerDetailViewController.initRecyclerView$lambda$14(PowerDetailViewController.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$12(PowerDetailViewController powerDetailViewController, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        ViewController.present$default(powerDetailViewController, new PowerTeamViewController(powerDetailViewController.powerId), true, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$14(PowerDetailViewController powerDetailViewController, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        PowerGroupMemberBean powerGroupMemberBean = (PowerGroupMemberBean) powerDetailViewController.getPowerRoomAdapter().getItem(i);
        if (FastClickOneUtils.INSTANCE.isFastClick() && powerDetailViewController.groupPowerTitleDetail != null) {
            StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, powerGroupMemberBean.getGroupId(), powerGroupMemberBean.getCode(), powerGroupMemberBean.getFaceUrl(), powerGroupMemberBean.getName(), Boolean.valueOf(powerGroupMemberBean.getHasPassWord()), powerGroupMemberBean.getCountryIcon(), powerGroupMemberBean.getIntroduction(), powerGroupMemberBean.getNotification(), 0, 0, null, 0, false, 7936, null);
        }
    }

    private final void initView(GroupPowerTitleDetail groupPowerTitleDetail) {
        PowerDetailViewControllerBinding powerDetailViewControllerBinding = this.binding;
        PowerDetailViewControllerBinding powerDetailViewControllerBinding2 = null;
        if (powerDetailViewControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            powerDetailViewControllerBinding = null;
        }
        powerDetailViewControllerBinding.titleTextView.setText(groupPowerTitleDetail.getName());
        PowerDetailViewControllerBinding powerDetailViewControllerBinding3 = this.binding;
        if (powerDetailViewControllerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            powerDetailViewControllerBinding3 = null;
        }
        powerDetailViewControllerBinding3.powerName.setText(groupPowerTitleDetail.getName());
        PowerDetailViewControllerBinding powerDetailViewControllerBinding4 = this.binding;
        if (powerDetailViewControllerBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            powerDetailViewControllerBinding4 = null;
        }
        powerDetailViewControllerBinding4.powerNumber.setText(groupPowerTitleDetail.getMemberNum());
        if (groupPowerTitleDetail.isMyGroupPower()) {
            PowerDetailViewControllerBinding powerDetailViewControllerBinding5 = this.binding;
            if (powerDetailViewControllerBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                powerDetailViewControllerBinding5 = null;
            }
            powerDetailViewControllerBinding5.join.setText(ResourcesKtxKt.getStringById(this, 2131953165));
            PowerDetailViewControllerBinding powerDetailViewControllerBinding6 = this.binding;
            if (powerDetailViewControllerBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                powerDetailViewControllerBinding6 = null;
            }
            powerDetailViewControllerBinding6.join.setClickable(false);
            PowerDetailViewControllerBinding powerDetailViewControllerBinding7 = this.binding;
            if (powerDetailViewControllerBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                powerDetailViewControllerBinding7 = null;
            }
            powerDetailViewControllerBinding7.moreBtn.setVisibility(0);
        } else {
            PowerDetailViewControllerBinding powerDetailViewControllerBinding8 = this.binding;
            if (powerDetailViewControllerBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                powerDetailViewControllerBinding8 = null;
            }
            powerDetailViewControllerBinding8.join.setText(ResourcesKtxKt.getStringById(this, 2131953154));
            PowerDetailViewControllerBinding powerDetailViewControllerBinding9 = this.binding;
            if (powerDetailViewControllerBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                powerDetailViewControllerBinding9 = null;
            }
            powerDetailViewControllerBinding9.join.setClickable(true);
            PowerDetailViewControllerBinding powerDetailViewControllerBinding10 = this.binding;
            if (powerDetailViewControllerBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                powerDetailViewControllerBinding10 = null;
            }
            powerDetailViewControllerBinding10.moreBtn.setVisibility(8);
        }
        PowerDetailViewControllerBinding powerDetailViewControllerBinding11 = this.binding;
        if (powerDetailViewControllerBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            powerDetailViewControllerBinding11 = null;
        }
        PorterShapeImageView porterShapeImageView = powerDetailViewControllerBinding11.powerAvatar;
        Intrinsics.checkNotNullExpressionValue(porterShapeImageView, "powerAvatar");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        String avatar = groupPowerTitleDetail.getAvatar();
        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        fill.setWidth(dimens.dpToPx(110));
        fill.setHeight(dimens.dpToPx(120));
        Unit unit = Unit.INSTANCE;
        ImageUIModel displayImage = companion.displayImage(avatar, fill);
        displayImage.setScaleType(ImageView.ScaleType.CENTER);
        ViewUtilitiesKt.bind(porterShapeImageView, displayImage);
        PowerDetailViewControllerBinding powerDetailViewControllerBinding12 = this.binding;
        if (powerDetailViewControllerBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            powerDetailViewControllerBinding2 = powerDetailViewControllerBinding12;
        }
        ImageView imageView = powerDetailViewControllerBinding2.powerAvatarBg;
        Intrinsics.checkNotNullExpressionValue(imageView, "powerAvatarBg");
        ImageKtxKt.loadImage$default(imageView, ImageSizeKt.image100(groupPowerTitleDetail.getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        fullManagerRecyclerView(groupPowerTitleDetail);
    }

    private final void joinPowerDialog() {
        ConfirmTipViewController confirmTipViewController = new ConfirmTipViewController(ConfirmPreloadModel.INSTANCE.init(ResourcesKtxKt.getStringById(this, 2131952026), BaseViewControllerKt.getString(this, 2131953574, new Object[0]), BaseViewControllerKt.getString(this, 2131952171, new Object[0])), null, 2, null);
        confirmTipViewController.setDelegate(new PowerDetailViewController$joinPowerDialog$controller$1$1(confirmTipViewController, this));
        ViewController.present$default(this, confirmTipViewController, true, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoadMore$lambda$18(PowerDetailViewController powerDetailViewController, ApiResponse apiResponse) {
        int i;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        PowerDetailViewControllerBinding powerDetailViewControllerBinding = powerDetailViewController.binding;
        PowerDetailViewControllerBinding powerDetailViewControllerBinding2 = null;
        if (powerDetailViewControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            powerDetailViewControllerBinding = null;
        }
        powerDetailViewControllerBinding.smartRefreshLayout.finishLoadMore();
        powerDetailViewController.mPageIndex++;
        List list = (List) apiResponse.getData();
        if (list != null) {
            powerDetailViewController.getPowerRoomAdapter().addData(list);
        }
        List list2 = (List) apiResponse.getData();
        if (list2 != null) {
            i = list2.size();
        } else {
            i = 0;
        }
        if (i < powerDetailViewController.mPageSize) {
            PowerDetailViewControllerBinding powerDetailViewControllerBinding3 = powerDetailViewController.binding;
            if (powerDetailViewControllerBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                powerDetailViewControllerBinding2 = powerDetailViewControllerBinding3;
            }
            powerDetailViewControllerBinding2.smartRefreshLayout.setEnableLoadMore(false);
        } else {
            PowerDetailViewControllerBinding powerDetailViewControllerBinding4 = powerDetailViewController.binding;
            if (powerDetailViewControllerBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                powerDetailViewControllerBinding2 = powerDetailViewControllerBinding4;
            }
            powerDetailViewControllerBinding2.smartRefreshLayout.setEnableLoadMore(true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoadMore$lambda$19(PowerDetailViewController powerDetailViewController, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        PowerDetailViewControllerBinding powerDetailViewControllerBinding = powerDetailViewController.binding;
        PowerDetailViewControllerBinding powerDetailViewControllerBinding2 = null;
        if (powerDetailViewControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            powerDetailViewControllerBinding = null;
        }
        powerDetailViewControllerBinding.smartRefreshLayout.finishLoadMore();
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, powerDetailViewController.getContext(), ResourcesKtxKt.getStringById(powerDetailViewController, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        PowerDetailViewControllerBinding powerDetailViewControllerBinding3 = powerDetailViewController.binding;
        if (powerDetailViewControllerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            powerDetailViewControllerBinding2 = powerDetailViewControllerBinding3;
        }
        powerDetailViewControllerBinding2.smartRefreshLayout.setEnableLoadMore(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRefresh$lambda$20(PowerDetailViewController powerDetailViewController, ApiResponse apiResponse) {
        int i;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        PowerDetailViewControllerBinding powerDetailViewControllerBinding = powerDetailViewController.binding;
        PowerDetailViewControllerBinding powerDetailViewControllerBinding2 = null;
        if (powerDetailViewControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            powerDetailViewControllerBinding = null;
        }
        powerDetailViewControllerBinding.smartRefreshLayout.finishRefresh();
        powerDetailViewController.mPageIndex++;
        if (((List) apiResponse.getData()) != null && (!r0.isEmpty())) {
            powerDetailViewController.getPowerRoomAdapter().setList((Collection) apiResponse.getData());
        }
        List list = (List) apiResponse.getData();
        if (list != null) {
            i = list.size();
        } else {
            i = 0;
        }
        if (i < powerDetailViewController.mPageSize) {
            PowerDetailViewControllerBinding powerDetailViewControllerBinding3 = powerDetailViewController.binding;
            if (powerDetailViewControllerBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                powerDetailViewControllerBinding2 = powerDetailViewControllerBinding3;
            }
            powerDetailViewControllerBinding2.smartRefreshLayout.setEnableLoadMore(false);
        } else {
            PowerDetailViewControllerBinding powerDetailViewControllerBinding4 = powerDetailViewController.binding;
            if (powerDetailViewControllerBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                powerDetailViewControllerBinding2 = powerDetailViewControllerBinding4;
            }
            powerDetailViewControllerBinding2.smartRefreshLayout.setEnableLoadMore(true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRefresh$lambda$21(PowerDetailViewController powerDetailViewController, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        PowerDetailViewControllerBinding powerDetailViewControllerBinding = powerDetailViewController.binding;
        PowerDetailViewControllerBinding powerDetailViewControllerBinding2 = null;
        if (powerDetailViewControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            powerDetailViewControllerBinding = null;
        }
        powerDetailViewControllerBinding.smartRefreshLayout.finishRefresh();
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, powerDetailViewController.getContext(), ResourcesKtxKt.getStringById(powerDetailViewController, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        PowerDetailViewControllerBinding powerDetailViewControllerBinding3 = powerDetailViewController.binding;
        if (powerDetailViewControllerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            powerDetailViewControllerBinding2 = powerDetailViewControllerBinding3;
        }
        powerDetailViewControllerBinding2.smartRefreshLayout.setEnableLoadMore(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PowerManagerAdapter powerManagerAdapter_delegate$lambda$1() {
        return new PowerManagerAdapter(R.layout.item_power_manager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PowerRoomAdapter powerRoomAdapter_delegate$lambda$0() {
        return new PowerRoomAdapter(R.layout.item_power_room);
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidCancel() {
        ViewController.dismiss$default(this, true, null, 2, null);
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidConfirm(int fromCode, @NotNull Bundle extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().leaveGroupPower(this.powerId), new Function1() { // from class: com.qiahao.nextvideo.ui.power.e
            public final Object invoke(Object obj) {
                Unit confirmTipViewControllerDidConfirm$lambda$27;
                confirmTipViewControllerDidConfirm$lambda$27 = PowerDetailViewController.confirmTipViewControllerDidConfirm$lambda$27(PowerDetailViewController.this, (ApiResponse) obj);
                return confirmTipViewControllerDidConfirm$lambda$27;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.power.f
            public final Object invoke(Object obj) {
                Unit confirmTipViewControllerDidConfirm$lambda$28;
                confirmTipViewControllerDidConfirm$lambda$28 = PowerDetailViewController.confirmTipViewControllerDidConfirm$lambda$28(PowerDetailViewController.this, (Throwable) obj);
                return confirmTipViewControllerDidConfirm$lambda$28;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    @Override // com.qiahao.nextvideo.ui.power.PowerMenuViewControllerDelegate
    public void confirmleave() {
        dismiss(true, new Function0() { // from class: com.qiahao.nextvideo.ui.power.n
            public final Object invoke() {
                Unit confirmleave$lambda$25;
                confirmleave$lambda$25 = PowerDetailViewController.confirmleave$lambda$25(PowerDetailViewController.this);
                return confirmleave$lambda$25;
            }
        });
    }

    public final void getData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getGroupPowerTitleDetail(this.powerId), new Function1() { // from class: com.qiahao.nextvideo.ui.power.a
            public final Object invoke(Object obj) {
                Unit data$lambda$5;
                data$lambda$5 = PowerDetailViewController.getData$lambda$5(PowerDetailViewController.this, (ApiResponse) obj);
                return data$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.power.g
            public final Object invoke(Object obj) {
                Unit data$lambda$6;
                data$lambda$6 = PowerDetailViewController.getData$lambda$6(PowerDetailViewController.this, (Throwable) obj);
                return data$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    @Nullable
    public final PowerDetailListener getDelegate() {
        return this.delegate;
    }

    @Nullable
    public final GroupPowerTitleDetail getGroupPowerTitleDetail() {
        return this.groupPowerTitleDetail;
    }

    public final int getMPageIndex() {
        return this.mPageIndex;
    }

    public final int getMPageSize() {
        return this.mPageSize;
    }

    public final long getPowerId() {
        return this.powerId;
    }

    @NotNull
    public final PowerManagerAdapter getPowerManagerAdapter() {
        return (PowerManagerAdapter) this.powerManagerAdapter.getValue();
    }

    @NotNull
    public final PowerRoomAdapter getPowerRoomAdapter() {
        return (PowerRoomAdapter) this.powerRoomAdapter.getValue();
    }

    /* renamed from: isFromActivity, reason: from getter */
    public final boolean getIsFromActivity() {
        return this.isFromActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        long j;
        Intrinsics.checkNotNullParameter(v, "v");
        switch (v.getId()) {
            case R.id.all_power_avatar /* 2131361959 */:
                GroupPowerTitleDetail groupPowerTitleDetail = this.groupPowerTitleDetail;
                if (groupPowerTitleDetail != null && FastClickOneUtils.INSTANCE.isFastClick()) {
                    StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, groupPowerTitleDetail.getGroupId(), null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
                    return;
                }
                return;
            case R.id.back_image_view /* 2131362039 */:
                ViewController.dismiss$default(this, true, null, 2, null);
                PowerDetailListener powerDetailListener = this.delegate;
                if (powerDetailListener != null) {
                    powerDetailListener.callBack();
                    return;
                }
                return;
            case 2131363387:
                User user = UserStore.INSTANCE.getShared().getUser();
                if (user != null) {
                    j = user.getMyGroupPower();
                } else {
                    j = 0;
                }
                if (j > 0) {
                    Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131953040), false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                        return;
                    }
                    return;
                }
                joinPowerDialog();
                return;
            case R.id.linear_layout2 /* 2131363514 */:
            case R.id.manager_list /* 2131363733 */:
                ViewController.present$default(this, new PowerTeamViewController(this.powerId), true, null, 4, null);
                return;
            case 2131363936:
                Log.d(TAG, "onClick: more_btn");
                PowerMenuViewController powerMenuViewController = new PowerMenuViewController();
                powerMenuViewController.setMPowerMenuViewControllerDelegate(this);
                ViewController.present$default(this, powerMenuViewController, true, null, 4, null);
                return;
            default:
                return;
        }
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        PowerDetailViewControllerBinding inflate = PowerDetailViewControllerBinding.inflate(inflater, container, false);
        this.binding = inflate;
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // vc.e
    public void onLoadMore(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getGroupPowerMemberGroup(this.powerId, this.mPageIndex, this.mPageSize), new Function1() { // from class: com.qiahao.nextvideo.ui.power.l
            public final Object invoke(Object obj) {
                Unit onLoadMore$lambda$18;
                onLoadMore$lambda$18 = PowerDetailViewController.onLoadMore$lambda$18(PowerDetailViewController.this, (ApiResponse) obj);
                return onLoadMore$lambda$18;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.power.m
            public final Object invoke(Object obj) {
                Unit onLoadMore$lambda$19;
                onLoadMore$lambda$19 = PowerDetailViewController.onLoadMore$lambda$19(PowerDetailViewController.this, (Throwable) obj);
                return onLoadMore$lambda$19;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        this.mPageIndex = 1;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getGroupPowerMemberGroup(this.powerId, this.mPageIndex, this.mPageSize), new Function1() { // from class: com.qiahao.nextvideo.ui.power.o
            public final Object invoke(Object obj) {
                Unit onRefresh$lambda$20;
                onRefresh$lambda$20 = PowerDetailViewController.onRefresh$lambda$20(PowerDetailViewController.this, (ApiResponse) obj);
                return onRefresh$lambda$20;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.power.b
            public final Object invoke(Object obj) {
                Unit onRefresh$lambda$21;
                onRefresh$lambda$21 = PowerDetailViewController.onRefresh$lambda$21(PowerDetailViewController.this, (Throwable) obj);
                return onRefresh$lambda$21;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    public final void setDelegate(@Nullable PowerDetailListener powerDetailListener) {
        this.delegate = powerDetailListener;
    }

    public final void setGroupPowerTitleDetail(@Nullable GroupPowerTitleDetail groupPowerTitleDetail) {
        this.groupPowerTitleDetail = groupPowerTitleDetail;
    }

    public final void setMPageIndex(int i) {
        this.mPageIndex = i;
    }

    public final void setMPageSize(int i) {
        this.mPageSize = i;
    }

    public final void showLeaveTip() {
        ConfirmTipViewController confirmTipViewController = new ConfirmTipViewController(ConfirmPreloadModel.INSTANCE.init(ResourcesKtxKt.getStringById(this, 2131952025), BaseViewControllerKt.getString(this, 2131952331, new Object[0]), BaseViewControllerKt.getString(this, 2131952171, new Object[0])), null, 2, null);
        confirmTipViewController.setDelegate(this);
        ViewController.present$default(this, confirmTipViewController, true, null, 4, null);
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        PowerDetailViewControllerBinding powerDetailViewControllerBinding = null;
        if (!this.isFromActivity) {
            HiloBaseActivity requireActivity = getRequireActivity();
            PowerDetailViewControllerBinding powerDetailViewControllerBinding2 = this.binding;
            if (powerDetailViewControllerBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                powerDetailViewControllerBinding2 = null;
            }
            Toolbar toolbar = powerDetailViewControllerBinding2.toolbar;
            Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
            requireActivity.setStatusBarTopOrBottom(toolbar, false);
        }
        PowerDetailViewControllerBinding powerDetailViewControllerBinding3 = this.binding;
        if (powerDetailViewControllerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            powerDetailViewControllerBinding = powerDetailViewControllerBinding3;
        }
        powerDetailViewControllerBinding.setClick(this);
        initAppBarView();
        initRecyclerView();
        initDataFromCache();
        getData();
    }

    public PowerDetailViewController(long j, boolean z) {
        this.powerId = j;
        this.isFromActivity = z;
        setTag(TAG);
        this.mPageIndex = 1;
        this.mPageSize = 10;
        this.powerRoomAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.power.h
            public final Object invoke() {
                PowerRoomAdapter powerRoomAdapter_delegate$lambda$0;
                powerRoomAdapter_delegate$lambda$0 = PowerDetailViewController.powerRoomAdapter_delegate$lambda$0();
                return powerRoomAdapter_delegate$lambda$0;
            }
        });
        this.powerManagerAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.power.i
            public final Object invoke() {
                PowerManagerAdapter powerManagerAdapter_delegate$lambda$1;
                powerManagerAdapter_delegate$lambda$1 = PowerDetailViewController.powerManagerAdapter_delegate$lambda$1();
                return powerManagerAdapter_delegate$lambda$1;
            }
        });
    }
}
