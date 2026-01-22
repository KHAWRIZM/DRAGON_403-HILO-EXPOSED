package com.qiahao.nextvideo.ui.foodie;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.common.BaseBindingDialogFragment;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.ui.loading.LoadingDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.overlayView.CustomOverlayView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserObjectEvent;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.foodie.FoodieDrawResult;
import com.qiahao.nextvideo.data.foodie.FoodieGameInfo;
import com.qiahao.nextvideo.data.foodie.FoodieHotMessage;
import com.qiahao.nextvideo.data.foodie.FoodieItem;
import com.qiahao.nextvideo.data.foodie.FoodieJettonBean;
import com.qiahao.nextvideo.data.foodie.FoodieRepeat;
import com.qiahao.nextvideo.data.foodie.FoodieRepeatItem;
import com.qiahao.nextvideo.databinding.ViewFoodieDialogBinding;
import com.qiahao.nextvideo.ui.foodie.adapter.FoodieJettonAdapter;
import com.qiahao.nextvideo.ui.foodie.adapter.FoodieResultAdapter;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010$\u001a\u00020\fH\u0014J\b\u0010%\u001a\u00020\fH\u0014J\b\u0010&\u001a\u00020\u0014H\u0016J\b\u0010'\u001a\u00020\u0014H\u0016J\u0006\u0010(\u001a\u00020\u0014J\b\u0010)\u001a\u00020\u0014H\u0002J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\nH\u0002J\u0010\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\u0014H\u0002J\b\u00105\u001a\u00020\u0014H\u0016J\b\u00106\u001a\u00020\u0014H\u0016J\b\u00107\u001a\u00020\u0014H\u0002J\u0006\u00108\u001a\u00020\u0014J\u0006\u00109\u001a\u00020:J\u000e\u0010;\u001a\u00020\u00142\u0006\u00102\u001a\u00020<J\u001e\u0010=\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\f2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0010\u0010@\u001a\u00020\u00142\u0006\u0010A\u001a\u00020BH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b!\u0010\"¨\u0006C"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/FoodieGameDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialogFragment;", "Lcom/qiahao/nextvideo/databinding/ViewFoodieDialogBinding;", "<init>", "()V", "mJettonAdapter", "Lcom/qiahao/nextvideo/ui/foodie/adapter/FoodieJettonAdapter;", "mResultAdapter", "Lcom/qiahao/nextvideo/ui/foodie/adapter/FoodieResultAdapter;", "credit", "", "mCurrentJettonPosition", "", "winToday", "loadingDialog", "Lcom/qiahao/base_common/ui/loading/LoadingDialog;", "mIsDontShowNextTime", "", "mListener", "Lkotlin/Function0;", "", "getMListener", "()Lkotlin/jvm/functions/Function0;", "setMListener", "(Lkotlin/jvm/functions/Function0;)V", "viewModel", "Lcom/qiahao/nextvideo/ui/foodie/FoodieViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/foodie/FoodieViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mBetAnimHelper", "Lcom/qiahao/nextvideo/ui/foodie/FoodieBetAnimHelper;", "getMBetAnimHelper", "()Lcom/qiahao/nextvideo/ui/foodie/FoodieBetAnimHelper;", "mBetAnimHelper$delegate", "getLayoutResId", "getHeight", "onStart", "onInitialize", "initView", "initObservers", "refreshPageData", "info", "Lcom/qiahao/nextvideo/data/foodie/FoodieGameInfo;", "changeWinToday", "gold", "", "setBalance", "setFirstRank", "bean", "Lcom/qiahao/nextvideo/data/foodie/FoodieDrawResult;", "loadData", "onDestroy", "onResume", "destroyOnDismiss", "setDrawResult", "getOverlayView", "Lcom/qiahao/base_common/wedgit/overlayView/CustomOverlayView;", "refreshHotItem", "Lcom/qiahao/nextvideo/data/foodie/FoodieHotMessage;", "checkIsShowClickItemTipsDialog", "money", "cb", "triggerBetAnim", "targetView", "Landroid/view/View;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFoodieGameDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FoodieGameDialog.kt\ncom/qiahao/nextvideo/ui/foodie/FoodieGameDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Color.kt\nandroidx/core/graphics/ColorKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,450:1\n61#2,9:451\n61#2,9:460\n61#2,9:470\n61#2,9:479\n61#2,9:488\n61#2,9:497\n61#2,9:506\n61#2,9:515\n61#2,9:524\n1#3:469\n439#4:533\n439#4:537\n1878#5,3:534\n1869#5,2:538\n*S KotlinDebug\n*F\n+ 1 FoodieGameDialog.kt\ncom/qiahao/nextvideo/ui/foodie/FoodieGameDialog\n*L\n108#1:451,9\n111#1:460,9\n130#1:470,9\n140#1:479,9\n151#1:488,9\n162#1:497,9\n173#1:506,9\n176#1:515,9\n189#1:524,9\n359#1:533\n336#1:537\n236#1:534,3\n339#1:538,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieGameDialog extends BaseBindingDialogFragment<ViewFoodieDialogBinding> {
    private double credit;

    @Nullable
    private LoadingDialog loadingDialog;
    private int mCurrentJettonPosition;
    private boolean mIsDontShowNextTime;

    @Nullable
    private FoodieJettonAdapter mJettonAdapter;

    @Nullable
    private Function0<Unit> mListener;

    @Nullable
    private FoodieResultAdapter mResultAdapter;
    private double winToday;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.foodie.a0
        public final Object invoke() {
            FoodieViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = FoodieGameDialog.viewModel_delegate$lambda$0(FoodieGameDialog.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mBetAnimHelper$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mBetAnimHelper = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.foodie.c0
        public final Object invoke() {
            FoodieBetAnimHelper mBetAnimHelper_delegate$lambda$1;
            mBetAnimHelper_delegate$lambda$1 = FoodieGameDialog.mBetAnimHelper_delegate$lambda$1(FoodieGameDialog.this);
            return mBetAnimHelper_delegate$lambda$1;
        }
    });

    public static final /* synthetic */ ViewFoodieDialogBinding access$getBinding(FoodieGameDialog foodieGameDialog) {
        return (ViewFoodieDialogBinding) foodieGameDialog.getBinding();
    }

    private final void changeWinToday(long gold) {
        this.winToday += gold;
        ((ViewFoodieDialogBinding) getBinding()).tvRevenue.setText(NumberUtilsKt.rankNumberFormat((long) this.winToday));
    }

    private final void checkIsShowClickItemTipsDialog(int money, final Function0<Unit> cb) {
        if (this.mIsDontShowNextTime) {
            cb.invoke();
            return;
        }
        Context context = getContext();
        if (context != null) {
            new FoodieConfirmBetDialog(context, money).showDialog(new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.q
                public final Object invoke(Object obj) {
                    Unit checkIsShowClickItemTipsDialog$lambda$49$lambda$48;
                    checkIsShowClickItemTipsDialog$lambda$49$lambda$48 = FoodieGameDialog.checkIsShowClickItemTipsDialog$lambda$49$lambda$48(FoodieGameDialog.this, cb, ((Boolean) obj).booleanValue());
                    return checkIsShowClickItemTipsDialog$lambda$49$lambda$48;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkIsShowClickItemTipsDialog$lambda$49$lambda$48(FoodieGameDialog foodieGameDialog, Function0 function0, boolean z) {
        foodieGameDialog.mIsDontShowNextTime = z;
        function0.invoke();
        return Unit.INSTANCE;
    }

    private final void destroyOnDismiss() {
        ((ViewFoodieDialogBinding) getBinding()).foodieWheel.cleanCountDown();
        ((ViewFoodieDialogBinding) getBinding()).foodieWheel.removeHotTag();
        ((ViewFoodieDialogBinding) getBinding()).foodieWheel.cleanItemHots();
        ((ViewFoodieDialogBinding) getBinding()).foodieWheel.resetItemBeanHasDrawState();
        ((ViewFoodieDialogBinding) getBinding()).foodieWheel.resetData();
        FoodieHotIconHelper hotIconHelper = getViewModel().getHotIconHelper();
        if (hotIconHelper != null) {
            hotIconHelper.destroy();
        }
        getViewModel().destroyMusic();
    }

    private final FoodieBetAnimHelper getMBetAnimHelper() {
        return (FoodieBetAnimHelper) this.mBetAnimHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FoodieViewModel getViewModel() {
        return (FoodieViewModel) this.viewModel.getValue();
    }

    private final void initObservers() {
        getViewModel().getGameInfoObserver().observe(this, new FoodieGameDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.j0
            public final Object invoke(Object obj) {
                Unit initObservers$lambda$27;
                initObservers$lambda$27 = FoodieGameDialog.initObservers$lambda$27(FoodieGameDialog.this, (FoodieGameInfo) obj);
                return initObservers$lambda$27;
            }
        }));
        getViewModel().getAnimObserver().observe(this, new FoodieGameDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.m0
            public final Object invoke(Object obj) {
                Unit initObservers$lambda$30;
                initObservers$lambda$30 = FoodieGameDialog.initObservers$lambda$30(FoodieGameDialog.this, (FoodieItem) obj);
                return initObservers$lambda$30;
            }
        }));
        getViewModel().getOutsideRankObserver().observe(this, new FoodieGameDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.r
            public final Object invoke(Object obj) {
                Unit initObservers$lambda$32;
                initObservers$lambda$32 = FoodieGameDialog.initObservers$lambda$32(FoodieGameDialog.this, (List) obj);
                return initObservers$lambda$32;
            }
        }));
        getViewModel().getPlaceBetObserver().observe(this, new FoodieGameDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.s
            public final Object invoke(Object obj) {
                Unit initObservers$lambda$33;
                initObservers$lambda$33 = FoodieGameDialog.initObservers$lambda$33(FoodieGameDialog.this, (Pair) obj);
                return initObservers$lambda$33;
            }
        }));
        getViewModel().getRewardObserver().observe(this, new FoodieGameDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.t
            public final Object invoke(Object obj) {
                Unit initObservers$lambda$34;
                initObservers$lambda$34 = FoodieGameDialog.initObservers$lambda$34(FoodieGameDialog.this, (Long) obj);
                return initObservers$lambda$34;
            }
        }));
        getViewModel().getPageStateObserver().observe(this, new FoodieGameDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.u
            public final Object invoke(Object obj) {
                Unit initObservers$lambda$35;
                initObservers$lambda$35 = FoodieGameDialog.initObservers$lambda$35(FoodieGameDialog.this, (FoodiePageState) obj);
                return initObservers$lambda$35;
            }
        }));
        getViewModel().getGameInfoError().observe(this, new FoodieGameDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.v
            public final Object invoke(Object obj) {
                Unit initObservers$lambda$36;
                initObservers$lambda$36 = FoodieGameDialog.initObservers$lambda$36(FoodieGameDialog.this, (HiloException) obj);
                return initObservers$lambda$36;
            }
        }));
        getViewModel().getRecordError().observe(this, new FoodieGameDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.w
            public final Object invoke(Object obj) {
                Unit initObservers$lambda$37;
                initObservers$lambda$37 = FoodieGameDialog.initObservers$lambda$37(FoodieGameDialog.this, (HiloException) obj);
                return initObservers$lambda$37;
            }
        }));
        getViewModel().getPlaceError().observe(this, new FoodieGameDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.x
            public final Object invoke(Object obj) {
                Unit initObservers$lambda$38;
                initObservers$lambda$38 = FoodieGameDialog.initObservers$lambda$38(FoodieGameDialog.this, (HiloException) obj);
                return initObservers$lambda$38;
            }
        }));
        getViewModel().getMException().observe(this, new FoodieGameDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.y
            public final Object invoke(Object obj) {
                Unit initObservers$lambda$39;
                initObservers$lambda$39 = FoodieGameDialog.initObservers$lambda$39(FoodieGameDialog.this, (Pair) obj);
                return initObservers$lambda$39;
            }
        }));
        getViewModel().getMFoodieRepeatData().observe(this, new FoodieGameDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.k0
            public final Object invoke(Object obj) {
                Unit initObservers$lambda$43;
                initObservers$lambda$43 = FoodieGameDialog.initObservers$lambda$43(FoodieGameDialog.this, (FoodieRepeat) obj);
                return initObservers$lambda$43;
            }
        }));
        getViewModel().getMFoodieRepeat().observe(this, new FoodieGameDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.l0
            public final Object invoke(Object obj) {
                Unit initObservers$lambda$46;
                initObservers$lambda$46 = FoodieGameDialog.initObservers$lambda$46(FoodieGameDialog.this, (FoodieRepeat) obj);
                return initObservers$lambda$46;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObservers$lambda$27(FoodieGameDialog foodieGameDialog, FoodieGameInfo foodieGameInfo) {
        FragmentActivity activity;
        Integer status;
        FragmentActivity activity2 = foodieGameDialog.getActivity();
        if ((activity2 != null && activity2.isFinishing()) || ((activity = foodieGameDialog.getActivity()) != null && activity.isDestroyed())) {
            return Unit.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<Integer> betNums = foodieGameInfo.getBetNums();
        if (betNums != null) {
            int i = 0;
            for (Object obj : betNums) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(new FoodieJettonBean(i, ((Number) obj).intValue(), false, 4, null));
                i = i2;
            }
        }
        FoodieJettonAdapter foodieJettonAdapter = foodieGameDialog.mJettonAdapter;
        if (foodieJettonAdapter != null) {
            foodieJettonAdapter.setList(arrayList);
        }
        int intValue = ((Number) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, FoodieConstants.KEY_FOODIE_PREVIOUS_JETTON, 0, (String) null, 4, (Object) null)).intValue();
        foodieGameDialog.mCurrentJettonPosition = intValue;
        FoodieJettonAdapter foodieJettonAdapter2 = foodieGameDialog.mJettonAdapter;
        if (foodieJettonAdapter2 != null) {
            foodieJettonAdapter2.selectItem(intValue);
        }
        Integer status2 = foodieGameInfo.getStatus();
        if ((status2 != null && status2.intValue() == 2) || ((status = foodieGameInfo.getStatus()) != null && status.intValue() == 3)) {
            ((ViewFoodieDialogBinding) foodieGameDialog.getBinding()).foodieWheel.setResultItemPositions();
        }
        Intrinsics.checkNotNull(foodieGameInfo);
        foodieGameDialog.refreshPageData(foodieGameInfo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObservers$lambda$30(final FoodieGameDialog foodieGameDialog, final FoodieItem foodieItem) {
        int i;
        double d;
        List data;
        FoodieJettonBean foodieJettonBean;
        List data2;
        FoodieJettonAdapter foodieJettonAdapter = foodieGameDialog.mJettonAdapter;
        final int i2 = 0;
        if (foodieJettonAdapter != null && (data2 = foodieJettonAdapter.getData()) != null) {
            i = data2.size();
        } else {
            i = 0;
        }
        if (i <= foodieGameDialog.mCurrentJettonPosition) {
            return Unit.INSTANCE;
        }
        FoodieJettonAdapter foodieJettonAdapter2 = foodieGameDialog.mJettonAdapter;
        if (foodieJettonAdapter2 != null && (data = foodieJettonAdapter2.getData()) != null && (foodieJettonBean = (FoodieJettonBean) data.get(foodieGameDialog.mCurrentJettonPosition)) != null) {
            i2 = foodieJettonBean.getGold();
        }
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            d = user.getDiamondNum();
        } else {
            d = 0.0d;
        }
        if (d < i2) {
            Context context = foodieGameDialog.getContext();
            if (context != null) {
                new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(foodieGameDialog, 2131953126)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieGameDialog$initObservers$2$1$1
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                        AppService service = AppController.INSTANCE.getService();
                        if (service != null) {
                            service.openWallet();
                        }
                    }
                }).show();
            }
            return Unit.INSTANCE;
        }
        foodieGameDialog.checkIsShowClickItemTipsDialog(i2, new Function0() { // from class: com.qiahao.nextvideo.ui.foodie.z
            public final Object invoke() {
                Unit initObservers$lambda$30$lambda$29;
                initObservers$lambda$30$lambda$29 = FoodieGameDialog.initObservers$lambda$30$lambda$29(FoodieGameDialog.this, foodieItem, i2);
                return initObservers$lambda$30$lambda$29;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObservers$lambda$30$lambda$29(FoodieGameDialog foodieGameDialog, FoodieItem foodieItem, int i) {
        foodieGameDialog.triggerBetAnim(foodieItem.getView());
        FoodieViewModel viewModel = foodieGameDialog.getViewModel();
        int type = foodieItem.getType();
        Intrinsics.checkNotNull(foodieItem);
        viewModel.placeBet(type, i, foodieItem);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObservers$lambda$32(FoodieGameDialog foodieGameDialog, List list) {
        if (list != null) {
            foodieGameDialog.setFirstRank((FoodieDrawResult) list.get(0));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObservers$lambda$33(FoodieGameDialog foodieGameDialog, Pair pair) {
        foodieGameDialog.setBalance(foodieGameDialog.credit - ((Number) pair.getFirst()).doubleValue());
        ((FoodieItem) pair.getSecond()).getView().setState(FoodieItemState.PICKED);
        foodieGameDialog.getViewModel().getSelectedPositionSet().add(Integer.valueOf(((FoodieItem) pair.getSecond()).getPosition()));
        ((ViewFoodieDialogBinding) foodieGameDialog.getBinding()).foodieWheel.refreshItemBet(((Number) pair.getFirst()).intValue(), (FoodieItem) pair.getSecond());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObservers$lambda$34(FoodieGameDialog foodieGameDialog, Long l) {
        double d = foodieGameDialog.credit;
        Intrinsics.checkNotNull(l);
        foodieGameDialog.setBalance(d + l.longValue());
        foodieGameDialog.changeWinToday(l.longValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObservers$lambda$35(FoodieGameDialog foodieGameDialog, FoodiePageState foodiePageState) {
        if (foodiePageState != FoodiePageState.RESULT && foodiePageState != FoodiePageState.OPENING) {
            ((ViewFoodieDialogBinding) foodieGameDialog.getBinding()).meatRewardView.setShadow(false);
            ((ViewFoodieDialogBinding) foodieGameDialog.getBinding()).vegetableRewardView.setShadow(false);
        } else {
            ((ViewFoodieDialogBinding) foodieGameDialog.getBinding()).meatRewardView.setShadow(true);
            ((ViewFoodieDialogBinding) foodieGameDialog.getBinding()).vegetableRewardView.setShadow(true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObservers$lambda$36(FoodieGameDialog foodieGameDialog, HiloException hiloException) {
        String str;
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = foodieGameDialog.getContext();
        String errorMessage = hiloException.getErrorMessage();
        if (errorMessage == null) {
            str = ResourcesKtxKt.getStringById(foodieGameDialog, 2131952667);
        } else {
            str = errorMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObservers$lambda$37(FoodieGameDialog foodieGameDialog, HiloException hiloException) {
        String str;
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = foodieGameDialog.getContext();
        String errorMessage = hiloException.getErrorMessage();
        if (errorMessage == null) {
            str = ResourcesKtxKt.getStringById(foodieGameDialog, 2131952667);
        } else {
            str = errorMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObservers$lambda$38(FoodieGameDialog foodieGameDialog, HiloException hiloException) {
        String str;
        hiloException.getCode();
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = foodieGameDialog.getContext();
        String errorMessage = hiloException.getErrorMessage();
        if (errorMessage == null) {
            str = ResourcesKtxKt.getStringById(foodieGameDialog, 2131952667);
        } else {
            str = errorMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObservers$lambda$39(FoodieGameDialog foodieGameDialog, Pair pair) {
        String str;
        if (pair.getSecond() instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = foodieGameDialog.getContext();
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            String errorMessage = ((HiloException) second).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(foodieGameDialog, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.qiahao.nextvideo.ui.foodie.FoodieConfirmRepeatDialog, android.app.Dialog] */
    public static final Unit initObservers$lambda$43(final FoodieGameDialog foodieGameDialog, FoodieRepeat foodieRepeat) {
        Long l;
        Context context = foodieGameDialog.getContext();
        if (context != null) {
            foodieGameDialog.getViewModel().setOtherDialogShowing(true);
            if (foodieRepeat != null) {
                l = foodieRepeat.getStake();
            } else {
                l = null;
            }
            ?? listener = new FoodieConfirmRepeatDialog(context, l).setListener(new Function0() { // from class: com.qiahao.nextvideo.ui.foodie.d0
                public final Object invoke() {
                    Unit initObservers$lambda$43$lambda$42$lambda$40;
                    initObservers$lambda$43$lambda$42$lambda$40 = FoodieGameDialog.initObservers$lambda$43$lambda$42$lambda$40(FoodieGameDialog.this);
                    return initObservers$lambda$43$lambda$42$lambda$40;
                }
            });
            listener.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.ui.foodie.e0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    FoodieGameDialog.initObservers$lambda$43$lambda$42$lambda$41(FoodieGameDialog.this, dialogInterface);
                }
            });
            listener.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObservers$lambda$43$lambda$42$lambda$40(FoodieGameDialog foodieGameDialog) {
        foodieGameDialog.getViewModel().foodieRepeat();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initObservers$lambda$43$lambda$42$lambda$41(FoodieGameDialog foodieGameDialog, DialogInterface dialogInterface) {
        foodieGameDialog.getViewModel().setOtherDialogShowing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObservers$lambda$46(FoodieGameDialog foodieGameDialog, FoodieRepeat foodieRepeat) {
        Drawable drawable;
        double d;
        ArrayList<FoodieRepeatItem> autoBets;
        int i;
        long j;
        Long diamondNum;
        Long diamondNum2;
        TextView textView = ((ViewFoodieDialogBinding) foodieGameDialog.getBinding()).repeat;
        Context context = foodieGameDialog.getContext();
        if (context != null) {
            drawable = androidx.core.content.a.getDrawable(context, R.drawable.foodie_one_again_bg_default);
        } else {
            drawable = null;
        }
        textView.setBackground(drawable);
        ((ViewFoodieDialogBinding) foodieGameDialog.getBinding()).repeat.setTextColor(Color.parseColor("#5B5B5B"));
        UserStore shared = UserStore.INSTANCE.getShared();
        double d2 = 0.0d;
        if (foodieRepeat != null && (diamondNum2 = foodieRepeat.getDiamondNum()) != null) {
            d = diamondNum2.longValue();
        } else {
            d = 0.0d;
        }
        UserStore.refreshDiamondOrGem$default(shared, d, 0.0d, 2, null);
        if (foodieRepeat != null && (diamondNum = foodieRepeat.getDiamondNum()) != null) {
            d2 = diamondNum.longValue();
        }
        foodieGameDialog.setBalance(d2);
        if (foodieRepeat != null && (autoBets = foodieRepeat.getAutoBets()) != null) {
            for (FoodieRepeatItem foodieRepeatItem : autoBets) {
                FoodieWheelLayout foodieWheelLayout = ((ViewFoodieDialogBinding) foodieGameDialog.getBinding()).foodieWheel;
                Integer foodieId = foodieRepeatItem.getFoodieId();
                if (foodieId != null) {
                    i = foodieId.intValue();
                } else {
                    i = 0;
                }
                Long stake = foodieRepeatItem.getStake();
                if (stake != null) {
                    j = stake.longValue();
                } else {
                    j = 0;
                }
                foodieWheelLayout.checkFoodieItem(i, j);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$19(FoodieGameDialog foodieGameDialog) {
        long j;
        Long winDay;
        List<Integer> list;
        FoodieResultAdapter foodieResultAdapter = foodieGameDialog.mResultAdapter;
        if (foodieResultAdapter != null) {
            FoodieGameInfo gameInfo = foodieGameDialog.getViewModel().getGameInfo();
            if (gameInfo != null) {
                list = gameInfo.getHistoryResult();
            } else {
                list = null;
            }
            foodieResultAdapter.setList(list);
        }
        TextView textView = ((ViewFoodieDialogBinding) foodieGameDialog.getBinding()).tvRevenue;
        FoodieGameInfo gameInfo2 = foodieGameDialog.getViewModel().getGameInfo();
        if (gameInfo2 != null && (winDay = gameInfo2.getWinDay()) != null) {
            j = winDay.longValue();
        } else {
            j = 0;
        }
        textView.setText(NumberUtilsKt.rankNumberFormat(j));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$21(FoodieGameDialog foodieGameDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        FoodieJettonAdapter foodieJettonAdapter = foodieGameDialog.mJettonAdapter;
        if (foodieJettonAdapter != null) {
            foodieJettonAdapter.selectItem(i);
        }
        foodieGameDialog.mCurrentJettonPosition = i;
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, FoodieConstants.KEY_FOODIE_PREVIOUS_JETTON, Integer.valueOf(i), (String) null, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$25(FoodieGameDialog foodieGameDialog, View view) {
        Drawable drawable;
        int i;
        boolean switchMute = foodieGameDialog.getViewModel().switchMute();
        ImageView imageView = ((ViewFoodieDialogBinding) foodieGameDialog.getBinding()).ivMusic;
        Context context = foodieGameDialog.getContext();
        if (context != null) {
            if (switchMute) {
                i = R.drawable.ic_foodie_music_close;
            } else {
                i = R.drawable.ic_foodie_music_open;
            }
            drawable = androidx.core.content.a.getDrawable(context, i);
        } else {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(FoodieGameDialog foodieGameDialog) {
        if (((ViewFoodieDialogBinding) foodieGameDialog.getBinding()).ivRule.getLayoutDirection() == 1) {
            ((ViewFoodieDialogBinding) foodieGameDialog.getBinding()).ivRankArrow.setScaleX(-1.0f);
            ((ViewFoodieDialogBinding) foodieGameDialog.getBinding()).ivHistoryArrowRight.setScaleX(-1.0f);
        }
    }

    private final void loadData() {
        getViewModel().requestFoodieGameInfo();
        getViewModel().requestOutSideRank();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FoodieBetAnimHelper mBetAnimHelper_delegate$lambda$1(FoodieGameDialog foodieGameDialog) {
        return new FoodieBetAnimHelper(foodieGameDialog);
    }

    private final void refreshPageData(FoodieGameInfo info) {
        double d;
        long j;
        int i;
        String str;
        String str2;
        String str3;
        Integer status;
        int i2;
        Integer status2;
        Integer status3;
        getViewModel().setHasData(true);
        Double diamondNum = info.getDiamondNum();
        if (diamondNum != null) {
            d = diamondNum.doubleValue();
        } else {
            d = 0.0d;
        }
        setBalance(d);
        if (getViewModel().getPageState() == FoodiePageState.NORMAL || ((status3 = info.getStatus()) != null && status3.intValue() == 1)) {
            FoodieResultAdapter foodieResultAdapter = this.mResultAdapter;
            if (foodieResultAdapter != null) {
                foodieResultAdapter.setList(info.getHistoryResult());
            }
            TextView textView = ((ViewFoodieDialogBinding) getBinding()).tvRevenue;
            Long winDay = info.getWinDay();
            if (winDay != null) {
                j = winDay.longValue();
            } else {
                j = 0;
            }
            textView.setText(NumberUtilsKt.rankNumberFormat(j));
        }
        ((ViewFoodieDialogBinding) getBinding()).foodieWheel.setDataAndStart(info);
        TextView textView2 = ((ViewFoodieDialogBinding) getBinding()).tvTodayRound;
        String stringById = ResourcesKtxKt.getStringById(this, 2131952782);
        Integer round = info.getRound();
        if (round != null) {
            i = round.intValue();
        } else {
            i = 0;
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView2.setText(format);
        QMUIRadiusImageView qMUIRadiusImageView = ((ViewFoodieDialogBinding) getBinding()).ivAvatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "ivAvatar");
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        Drawable drawable = null;
        if (user != null) {
            str = user.getAvatar();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        TextView textView3 = ((ViewFoodieDialogBinding) getBinding()).tvName;
        User user2 = companion.getShared().getUser();
        if (user2 != null) {
            str2 = user2.getNick();
        } else {
            str2 = null;
        }
        textView3.setText(str2);
        TextView textView4 = ((ViewFoodieDialogBinding) getBinding()).repeat;
        Context context = getContext();
        if (context != null) {
            if (Intrinsics.areEqual(info.getAutoBet(), Boolean.FALSE) && (status2 = info.getStatus()) != null && status2.intValue() == 1) {
                i2 = R.drawable.foodie_one_again_bg;
            } else {
                i2 = R.drawable.foodie_one_again_bg_default;
            }
            drawable = androidx.core.content.a.getDrawable(context, i2);
        }
        textView4.setBackground(drawable);
        TextView textView5 = ((ViewFoodieDialogBinding) getBinding()).repeat;
        if (Intrinsics.areEqual(info.getAutoBet(), Boolean.FALSE) && (status = info.getStatus()) != null && status.intValue() == 1) {
            str3 = "#A55524";
        } else {
            str3 = "#5B5B5B";
        }
        textView5.setTextColor(Color.parseColor(str3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setBalance(double gold) {
        if (gold < 0.0d) {
            return;
        }
        this.credit = gold;
        ((ViewFoodieDialogBinding) getBinding()).tvBalance.setText(FoodieUtil.INSTANCE.formatKValue(this.credit));
    }

    private final void setFirstRank(FoodieDrawResult bean) {
        String str;
        QMUIRadiusImageView qMUIRadiusImageView = ((ViewFoodieDialogBinding) getBinding()).ivRankFirstAvatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "ivRankFirstAvatar");
        User user = bean.getUser();
        String str2 = null;
        if (user != null) {
            str = user.getAvatar();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        TextView textView = ((ViewFoodieDialogBinding) getBinding()).tvRankFirstName;
        User user2 = bean.getUser();
        if (user2 != null) {
            str2 = user2.getNick();
        }
        textView.setText(str2);
        ((ViewFoodieDialogBinding) getBinding()).tvRankValue.setText("***");
    }

    private final void triggerBetAnim(View targetView) {
        View view;
        FoodieJettonAdapter foodieJettonAdapter = this.mJettonAdapter;
        if (foodieJettonAdapter != null) {
            view = foodieJettonAdapter.getViewByPosition(this.mCurrentJettonPosition, R.id.ivGold);
        } else {
            view = null;
        }
        if (view != null) {
            getMBetAnimHelper().startTranslateAnim(view, targetView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FoodieViewModel viewModel_delegate$lambda$0(FoodieGameDialog foodieGameDialog) {
        return new ViewModelProvider(foodieGameDialog).get(FoodieViewModel.class);
    }

    protected int getHeight() {
        return -1;
    }

    protected int getLayoutResId() {
        return R.layout.view_foodie_dialog;
    }

    @Nullable
    public final Function0<Unit> getMListener() {
        return this.mListener;
    }

    @NotNull
    public final CustomOverlayView getOverlayView() {
        CustomOverlayView customOverlayView = ((ViewFoodieDialogBinding) getBinding()).overlay;
        Intrinsics.checkNotNullExpressionValue(customOverlayView, "overlay");
        return customOverlayView;
    }

    public final void initView() {
        LoadingDialog loadingDialog;
        int i;
        Lifecycle lifecycle;
        nd.c subscribe = UserStore.INSTANCE.getShared().getUserObjectRelay().observeOn(RxUtilsKt.getMainThread()).subscribeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieGameDialog$initView$1
            public final void accept(UserObjectEvent userObjectEvent) {
                if (userObjectEvent != null) {
                    FoodieGameDialog foodieGameDialog = FoodieGameDialog.this;
                    User user = UserStore.INSTANCE.getShared().getUser();
                    foodieGameDialog.setBalance(user != null ? user.getDiamondNum() : 0.0d);
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, getViewModel().getMCompositeDisposable());
        final ConstraintLayout constraintLayout = ((ViewFoodieDialogBinding) getBinding()).constraint;
        final long j = 800;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieGameDialog$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                    ConstraintLayout constraintLayout2 = constraintLayout;
                }
            }
        });
        final ConstraintLayout constraintLayout2 = ((ViewFoodieDialogBinding) getBinding()).root;
        constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieGameDialog$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout2) > j || (constraintLayout2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout2, currentTimeMillis);
                    ConstraintLayout constraintLayout3 = constraintLayout2;
                    this.dismiss();
                }
            }
        });
        ImageView imageView = ((ViewFoodieDialogBinding) getBinding()).ivBack;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivBack");
        ImageKtxKt.toHorizontalMirror(imageView, R.drawable.ic_foodie_back);
        ((ViewFoodieDialogBinding) getBinding()).foodieWheel.setViewModel(getViewModel(), this);
        FragmentActivity activity = getActivity();
        if (activity != null && (lifecycle = activity.getLifecycle()) != null) {
            lifecycle.addObserver(this);
        }
        this.mIsDontShowNextTime = ((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, FoodieConstants.KEY_DONT_SHOW_NEXT_TIME, Boolean.FALSE, (String) null, 4, (Object) null)).booleanValue();
        Context context = getContext();
        Drawable drawable = null;
        if (context != null) {
            loadingDialog = new LoadingDialog(context, false, 2, (DefaultConstructorMarker) null);
        } else {
            loadingDialog = null;
        }
        this.loadingDialog = loadingDialog;
        ((ViewFoodieDialogBinding) getBinding()).vegetableRewardView.configView(h.VEGETABLE);
        ((ViewFoodieDialogBinding) getBinding()).meatRewardView.configView(h.MEAT);
        ((ViewFoodieDialogBinding) getBinding()).ivRule.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.foodie.b0
            @Override // java.lang.Runnable
            public final void run() {
                FoodieGameDialog.initView$lambda$6(FoodieGameDialog.this);
            }
        });
        final RelativeLayout relativeLayout = ((ViewFoodieDialogBinding) getBinding()).rlRanking;
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieGameDialog$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FoodieViewModel viewModel;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(relativeLayout) > j || (relativeLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(relativeLayout, currentTimeMillis);
                    Context context2 = this.getContext();
                    if (context2 != null) {
                        viewModel = this.getViewModel();
                        viewModel.setOtherDialogShowing(true);
                        BaseBindingDialog foodieRankDialog = new FoodieRankDialog(context2);
                        final FoodieGameDialog foodieGameDialog = this;
                        foodieRankDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieGameDialog$initView$6$1$1
                            @Override // android.content.DialogInterface.OnDismissListener
                            public final void onDismiss(DialogInterface dialogInterface) {
                                FoodieViewModel viewModel2;
                                viewModel2 = FoodieGameDialog.this.getViewModel();
                                viewModel2.setOtherDialogShowing(false);
                            }
                        });
                        foodieRankDialog.show();
                    }
                }
            }
        });
        final ImageView imageView2 = ((ViewFoodieDialogBinding) getBinding()).ivRule;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieGameDialog$initView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FoodieViewModel viewModel;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                    Context context2 = this.getContext();
                    if (context2 != null) {
                        viewModel = this.getViewModel();
                        viewModel.setOtherDialogShowing(true);
                        BaseBindingDialog foodieIntroDialog = new FoodieIntroDialog(context2);
                        final FoodieGameDialog foodieGameDialog = this;
                        foodieIntroDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieGameDialog$initView$7$1$1
                            @Override // android.content.DialogInterface.OnDismissListener
                            public final void onDismiss(DialogInterface dialogInterface) {
                                FoodieViewModel viewModel2;
                                viewModel2 = FoodieGameDialog.this.getViewModel();
                                viewModel2.setOtherDialogShowing(false);
                            }
                        });
                        foodieIntroDialog.show();
                    }
                }
            }
        });
        final ConstraintLayout constraintLayout3 = ((ViewFoodieDialogBinding) getBinding()).clHistory;
        constraintLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieGameDialog$initView$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FoodieViewModel viewModel;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout3) > j || (constraintLayout3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout3, currentTimeMillis);
                    ConstraintLayout constraintLayout4 = constraintLayout3;
                    Context context2 = this.getContext();
                    if (context2 != null) {
                        viewModel = this.getViewModel();
                        viewModel.setOtherDialogShowing(true);
                        BaseBindingDialog foodieRecordDialog = new FoodieRecordDialog(context2);
                        final FoodieGameDialog foodieGameDialog = this;
                        foodieRecordDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieGameDialog$initView$8$1$1
                            @Override // android.content.DialogInterface.OnDismissListener
                            public final void onDismiss(DialogInterface dialogInterface) {
                                FoodieViewModel viewModel2;
                                viewModel2 = FoodieGameDialog.this.getViewModel();
                                viewModel2.setOtherDialogShowing(false);
                            }
                        });
                        foodieRecordDialog.show();
                    }
                }
            }
        });
        final TextView textView = ((ViewFoodieDialogBinding) getBinding()).repeat;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieGameDialog$initView$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FoodieViewModel viewModel;
                boolean z;
                FoodieViewModel viewModel2;
                FoodieViewModel viewModel3;
                FoodieViewModel viewModel4;
                Integer status;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    viewModel = this.getViewModel();
                    FoodieGameInfo foodieGameInfo = (FoodieGameInfo) viewModel.getGameInfoObserver().getValue();
                    boolean z2 = false;
                    if (foodieGameInfo != null) {
                        z = Intrinsics.areEqual(foodieGameInfo.getAutoBet(), Boolean.FALSE);
                    } else {
                        z = false;
                    }
                    if (z) {
                        viewModel2 = this.getViewModel();
                        FoodieGameInfo foodieGameInfo2 = (FoodieGameInfo) viewModel2.getGameInfoObserver().getValue();
                        if (foodieGameInfo2 != null && (status = foodieGameInfo2.getStatus()) != null && status.intValue() == 1) {
                            z2 = true;
                        }
                        if (z2) {
                            if (!((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "show_foodie_repeat", Boolean.FALSE, (String) null, 4, (Object) null)).booleanValue()) {
                                viewModel4 = this.getViewModel();
                                viewModel4.foodieRepeatData();
                            } else {
                                viewModel3 = this.getViewModel();
                                viewModel3.foodieRepeat();
                            }
                        }
                    }
                }
            }
        });
        final ConstraintLayout constraintLayout4 = ((ViewFoodieDialogBinding) getBinding()).clBalance;
        constraintLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieGameDialog$initView$$inlined$singleClick$default$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout4) > j || (constraintLayout4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout4, currentTimeMillis);
                    ConstraintLayout constraintLayout5 = constraintLayout4;
                    AppService service = AppController.INSTANCE.getService();
                    if (service != null) {
                        service.openWallet();
                    }
                }
            }
        });
        final FoodieBigRewardView foodieBigRewardView = ((ViewFoodieDialogBinding) getBinding()).vegetableRewardView;
        foodieBigRewardView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieGameDialog$initView$$inlined$singleClick$default$8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Context context2;
                FoodieViewModel viewModel;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(foodieBigRewardView) > j || (foodieBigRewardView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(foodieBigRewardView, currentTimeMillis);
                    if (!FoodieGameDialog.access$getBinding(this).vegetableRewardView.getMIsShadow() && (context2 = this.getContext()) != null) {
                        viewModel = this.getViewModel();
                        viewModel.setOtherDialogShowing(true);
                        BaseBindingDialog foodieBigRewardRuleDialog = new FoodieBigRewardRuleDialog(context2, h.VEGETABLE);
                        final FoodieGameDialog foodieGameDialog = this;
                        foodieBigRewardRuleDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieGameDialog$initView$11$1$1
                            @Override // android.content.DialogInterface.OnDismissListener
                            public final void onDismiss(DialogInterface dialogInterface) {
                                FoodieViewModel viewModel2;
                                viewModel2 = FoodieGameDialog.this.getViewModel();
                                viewModel2.setOtherDialogShowing(false);
                            }
                        });
                        foodieBigRewardRuleDialog.show();
                    }
                }
            }
        });
        final FoodieBigRewardView foodieBigRewardView2 = ((ViewFoodieDialogBinding) getBinding()).meatRewardView;
        foodieBigRewardView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieGameDialog$initView$$inlined$singleClick$default$9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Context context2;
                FoodieViewModel viewModel;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(foodieBigRewardView2) > j || (foodieBigRewardView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(foodieBigRewardView2, currentTimeMillis);
                    if (!FoodieGameDialog.access$getBinding(this).meatRewardView.getMIsShadow() && (context2 = this.getContext()) != null) {
                        viewModel = this.getViewModel();
                        viewModel.setOtherDialogShowing(true);
                        BaseBindingDialog foodieBigRewardRuleDialog = new FoodieBigRewardRuleDialog(context2, h.MEAT);
                        final FoodieGameDialog foodieGameDialog = this;
                        foodieBigRewardRuleDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieGameDialog$initView$12$1$1
                            @Override // android.content.DialogInterface.OnDismissListener
                            public final void onDismiss(DialogInterface dialogInterface) {
                                FoodieViewModel viewModel2;
                                viewModel2 = FoodieGameDialog.this.getViewModel();
                                viewModel2.setOtherDialogShowing(false);
                            }
                        });
                        foodieBigRewardRuleDialog.show();
                    }
                }
            }
        });
        ((ViewFoodieDialogBinding) getBinding()).foodieWheel.setMListener(new Function0() { // from class: com.qiahao.nextvideo.ui.foodie.f0
            public final Object invoke() {
                Unit initView$lambda$19;
                initView$lambda$19 = FoodieGameDialog.initView$lambda$19(FoodieGameDialog.this);
                return initView$lambda$19;
            }
        });
        ((ViewFoodieDialogBinding) getBinding()).ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FoodieGameDialog.this.dismiss();
            }
        });
        this.mJettonAdapter = new FoodieJettonAdapter();
        ((ViewFoodieDialogBinding) getBinding()).rvJetton.addItemDecoration(new t1(0, UiKtxKt.getDp(11), false));
        ((ViewFoodieDialogBinding) getBinding()).rvJetton.setLayoutManager(new GridLayoutManager(getContext(), 4));
        ((ViewFoodieDialogBinding) getBinding()).rvJetton.setAdapter(this.mJettonAdapter);
        FoodieJettonAdapter foodieJettonAdapter = this.mJettonAdapter;
        if (foodieJettonAdapter != null) {
            foodieJettonAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.h0
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                    FoodieGameDialog.initView$lambda$21(FoodieGameDialog.this, baseQuickAdapter, view, i2);
                }
            });
        }
        this.mResultAdapter = new FoodieResultAdapter();
        ((ViewFoodieDialogBinding) getBinding()).rvResult.setAdapter(this.mResultAdapter);
        Context context2 = getContext();
        if (context2 != null) {
            getViewModel().initMusicHelper(context2);
        }
        boolean isMute = getViewModel().isMute();
        ImageView imageView3 = ((ViewFoodieDialogBinding) getBinding()).ivMusic;
        Context context3 = getContext();
        if (context3 != null) {
            if (isMute) {
                i = R.drawable.ic_foodie_music_close;
            } else {
                i = R.drawable.ic_foodie_music_open;
            }
            drawable = androidx.core.content.a.getDrawable(context3, i);
        }
        imageView3.setImageDrawable(drawable);
        ((ViewFoodieDialogBinding) getBinding()).ivMusic.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FoodieGameDialog.initView$lambda$25(FoodieGameDialog.this, view);
            }
        });
        initObservers();
        Log.d(FoodieConstants.FOODIE_TAG, "初始化的时候，请求foodie信息");
    }

    public void onDestroy() {
        destroyOnDismiss();
        getViewModel().setHasData(false);
        Function0<Unit> function0 = this.mListener;
        if (function0 != null) {
            function0.invoke();
        }
        super/*com.qiahao.base_common.common.BaseDialogFragment*/.onDestroy();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseDialogFragment*/.onInitialize();
        initView();
        loadData();
    }

    public void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        ((ViewFoodieDialogBinding) getBinding()).foodieWheel.onResume();
    }

    public void onStart() {
        Window window;
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.0f;
            window.setAttributes(attributes);
        }
    }

    public final void refreshHotItem(@NotNull FoodieHotMessage bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        if (isResumed() && getViewModel().getHasData()) {
            ((ViewFoodieDialogBinding) getBinding()).foodieWheel.setHotItem(bean);
        }
    }

    public final void setDrawResult() {
        if (isAdded()) {
            getViewModel().requestFoodieGameInfo();
        }
    }

    public final void setMListener(@Nullable Function0<Unit> function0) {
        this.mListener = function0;
    }
}
