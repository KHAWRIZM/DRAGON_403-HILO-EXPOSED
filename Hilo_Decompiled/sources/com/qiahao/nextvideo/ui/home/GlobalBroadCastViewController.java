package com.qiahao.nextvideo.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.interfaceing.ControllerListener;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.ui.dialog.ReportWhiteDialog;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces;
import com.qiahao.nextvideo.data.model.GlobalBroadCastBean;
import com.qiahao.nextvideo.data.model.IsBroadCastMangerBean;
import com.qiahao.nextvideo.data.model.PurchaseFeeDetailsX;
import com.qiahao.nextvideo.data.model.SvipCheckData;
import com.qiahao.nextvideo.data.service.FeedbackService;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.DialogUserMenuBinding;
import com.qiahao.nextvideo.databinding.ViewControllerGlobalBroadCastBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.dialog.UserMenuDialog;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0005Jf\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102M\u0010\u001a\u001aI\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\b0\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\"\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020!H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\b2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b+\u0010*J\u0015\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0013¢\u0006\u0004\b-\u0010.J\u0015\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u000b¢\u0006\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020@8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\"\u0010F\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u00101R\"\u0010K\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010G\u001a\u0004\bL\u0010I\"\u0004\bM\u00101R\"\u0010N\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010G\u001a\u0004\bO\u0010I\"\u0004\bP\u00101R\"\u0010R\u001a\u00020Q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006X"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/GlobalBroadCastViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Lvc/g;", "Lvc/e;", "<init>", "()V", "Lcom/qiahao/nextvideo/data/model/GlobalBroadCastBean;", "globalBroadCastBean", "", "showUserMenuDialog", "(Lcom/qiahao/nextvideo/data/model/GlobalBroadCastBean;)V", "", "delType", "deleteBroadCast", "(Lcom/qiahao/nextvideo/data/model/GlobalBroadCastBean;I)V", "goToWallet", "", SupportGiftRankActivity.EXTERNAL_ID, "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "isManager", "isPinned", "Lcom/qiahao/nextvideo/data/model/SvipCheckData;", "checkSvip", com.taobao.agoo.a.a.b.JSON_SUCCESS, "checkIsBroadcastManager", "(Ljava/lang/String;Lkotlin/jvm/functions/Function3;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;", "view", "viewDidLoad", "(Landroid/view/View;)V", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "onLoadMore", "isRefresh", "getData", "(Z)V", AgooConstants.MESSAGE_ID, "broadCastTop", "(I)V", "Lcom/qiahao/nextvideo/databinding/ViewControllerGlobalBroadCastBinding;", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ViewControllerGlobalBroadCastBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ViewControllerGlobalBroadCastBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ViewControllerGlobalBroadCastBinding;)V", "Lcom/qiahao/base_common/interfaceing/ControllerListener;", "mListener", "Lcom/qiahao/base_common/interfaceing/ControllerListener;", "getMListener", "()Lcom/qiahao/base_common/interfaceing/ControllerListener;", "setMListener", "(Lcom/qiahao/base_common/interfaceing/ControllerListener;)V", "Lcom/qiahao/nextvideo/ui/home/GlobalBroadCastHistoryAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/home/GlobalBroadCastHistoryAdapter;", "mAdapter", "mPageIndex", "I", "getMPageIndex", "()I", "setMPageIndex", "mPageSize", "getMPageSize", "setMPageSize", "mCurrentSelectIndex", "getMCurrentSelectIndex", "setMCurrentSelectIndex", "", "mCurrentSelectGlobalBroadCastId", "J", "getMCurrentSelectGlobalBroadCastId", "()J", "setMCurrentSelectGlobalBroadCastId", "(J)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGlobalBroadCastViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlobalBroadCastViewController.kt\ncom/qiahao/nextvideo/ui/home/GlobalBroadCastViewController\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,379:1\n61#2,9:380\n1#3:389\n*S KotlinDebug\n*F\n+ 1 GlobalBroadCastViewController.kt\ncom/qiahao/nextvideo/ui/home/GlobalBroadCastViewController\n*L\n146#1:380,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GlobalBroadCastViewController extends BaseViewController implements vc.g, vc.e {
    public ViewControllerGlobalBroadCastBinding mDataBinding;

    @Nullable
    private ControllerListener mListener;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.g
        public final Object invoke() {
            GlobalBroadCastHistoryAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = GlobalBroadCastViewController.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });
    private int mPageIndex = 1;
    private int mPageSize = 10;
    private int mCurrentSelectIndex = -1;
    private long mCurrentSelectGlobalBroadCastId = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit broadCastTop$lambda$17(GlobalBroadCastViewController globalBroadCastViewController, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, globalBroadCastViewController.getRequireContext(), ResourcesKtxKt.getStringById(globalBroadCastViewController, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        globalBroadCastViewController.getData(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit broadCastTop$lambda$18(GlobalBroadCastViewController globalBroadCastViewController, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context requireContext = globalBroadCastViewController.getRequireContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(globalBroadCastViewController, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, requireContext, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    private final void checkIsBroadcastManager(String externalId, final Function3<? super Boolean, ? super Boolean, ? super SvipCheckData, Unit> success) {
        showProgressDialog("");
        RxUtilsKt.observeOnMainThread$default(UserService.checkIsBroadcastManager$default(UserService.INSTANCE.getShared(), null, externalId, true, 1, null), new Function1() { // from class: com.qiahao.nextvideo.ui.home.n
            public final Object invoke(Object obj) {
                Unit checkIsBroadcastManager$lambda$12;
                checkIsBroadcastManager$lambda$12 = GlobalBroadCastViewController.checkIsBroadcastManager$lambda$12(success, this, (ApiResponse) obj);
                return checkIsBroadcastManager$lambda$12;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.o
            public final Object invoke(Object obj) {
                Unit checkIsBroadcastManager$lambda$13;
                checkIsBroadcastManager$lambda$13 = GlobalBroadCastViewController.checkIsBroadcastManager$lambda$13(GlobalBroadCastViewController.this, success, (Throwable) obj);
                return checkIsBroadcastManager$lambda$13;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkIsBroadcastManager$lambda$12(Function3 function3, GlobalBroadCastViewController globalBroadCastViewController, ApiResponse apiResponse) {
        boolean z;
        SvipCheckData svipCheckData;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        IsBroadCastMangerBean isBroadCastMangerBean = (IsBroadCastMangerBean) apiResponse.getData();
        boolean z2 = false;
        if (isBroadCastMangerBean != null && isBroadCastMangerBean.isManager()) {
            z = true;
        } else {
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        IsBroadCastMangerBean isBroadCastMangerBean2 = (IsBroadCastMangerBean) apiResponse.getData();
        if (isBroadCastMangerBean2 != null && isBroadCastMangerBean2.isPinned()) {
            z2 = true;
        }
        Boolean valueOf2 = Boolean.valueOf(z2);
        IsBroadCastMangerBean isBroadCastMangerBean3 = (IsBroadCastMangerBean) apiResponse.getData();
        if (isBroadCastMangerBean3 != null) {
            svipCheckData = isBroadCastMangerBean3.getSvipCheck();
        } else {
            svipCheckData = null;
        }
        function3.invoke(valueOf, valueOf2, svipCheckData);
        globalBroadCastViewController.dismissProgressDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkIsBroadcastManager$lambda$13(GlobalBroadCastViewController globalBroadCastViewController, Function3 function3, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        globalBroadCastViewController.dismissProgressDialog();
        Boolean bool = Boolean.FALSE;
        function3.invoke(bool, bool, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteBroadCast(GlobalBroadCastBean globalBroadCastBean, int delType) {
        new TipDialog(getRequireActivity()).setTipContent(ResourcesKtxKt.getStringById(this, 2131952550)).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131952331)).setDialogListener(new GlobalBroadCastViewController$deleteBroadCast$1(globalBroadCastBean, delType, this)).show();
    }

    static /* synthetic */ void deleteBroadCast$default(GlobalBroadCastViewController globalBroadCastViewController, GlobalBroadCastBean globalBroadCastBean, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        globalBroadCastViewController.deleteBroadCast(globalBroadCastBean, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$15(GlobalBroadCastViewController globalBroadCastViewController, boolean z, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        globalBroadCastViewController.mPageIndex++;
        if (z) {
            globalBroadCastViewController.getMDataBinding().commonIdSwipeRefreshLayout.finishRefresh();
        } else {
            globalBroadCastViewController.getMDataBinding().commonIdSwipeRefreshLayout.finishLoadMore();
        }
        List list = (List) apiResponse.getData();
        if (list != null && list.isEmpty()) {
            if (z) {
                globalBroadCastViewController.getMDataBinding().emptyTipTextView.setVisibility(0);
                globalBroadCastViewController.getMAdapter().setList((Collection) null);
            }
            globalBroadCastViewController.getMDataBinding().commonIdSwipeRefreshLayout.setEnableLoadMore(false);
        } else {
            globalBroadCastViewController.getMDataBinding().emptyTipTextView.setVisibility(8);
            List list2 = (List) apiResponse.getData();
            if (list2 != null && list2.size() == globalBroadCastViewController.mPageSize) {
                globalBroadCastViewController.getMDataBinding().commonIdSwipeRefreshLayout.setEnableLoadMore(true);
            } else {
                globalBroadCastViewController.getMDataBinding().commonIdSwipeRefreshLayout.setEnableLoadMore(false);
            }
            if (z) {
                globalBroadCastViewController.getMAdapter().setList((Collection) apiResponse.getData());
            } else {
                List list3 = (List) apiResponse.getData();
                if (list3 != null) {
                    globalBroadCastViewController.getMAdapter().addData(list3);
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$16(boolean z, GlobalBroadCastViewController globalBroadCastViewController, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (z) {
            globalBroadCastViewController.getMAdapter().setList((Collection) null);
        }
        if (globalBroadCastViewController.getMAdapter().getData().isEmpty()) {
            globalBroadCastViewController.getMDataBinding().emptyTipTextView.setVisibility(0);
        } else {
            globalBroadCastViewController.getMDataBinding().emptyTipTextView.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goToWallet() {
        new TipDialog(getRequireContext()).setTipContent(ResourcesKtxKt.getStringById(this, 2131953126)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.GlobalBroadCastViewController$goToWallet$1
            public void cancel() {
                OnCommonDialogListener.DefaultImpls.cancel(this);
            }

            public void confirm() {
                WalletActivity.INSTANCE.start(GlobalBroadCastViewController.this.getRequireContext());
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GlobalBroadCastHistoryAdapter mAdapter_delegate$lambda$0() {
        return new GlobalBroadCastHistoryAdapter(R.layout.item_global_broadcast_history);
    }

    @SuppressLint({"SetTextI18n"})
    private final void showUserMenuDialog(final GlobalBroadCastBean globalBroadCastBean) {
        String externalId = globalBroadCastBean.getUser().getExternalId();
        if (externalId == null) {
            externalId = "";
        }
        checkIsBroadcastManager(externalId, new Function3() { // from class: com.qiahao.nextvideo.ui.home.k
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit showUserMenuDialog$lambda$11;
                showUserMenuDialog$lambda$11 = GlobalBroadCastViewController.showUserMenuDialog$lambda$11(GlobalBroadCastViewController.this, globalBroadCastBean, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (SvipCheckData) obj3);
                return showUserMenuDialog$lambda$11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showUserMenuDialog$lambda$11(final GlobalBroadCastViewController globalBroadCastViewController, final GlobalBroadCastBean globalBroadCastBean, boolean z, boolean z2, final SvipCheckData svipCheckData) {
        Integer num;
        BaseActivity requireActivity = globalBroadCastViewController.getRequireActivity();
        String externalId = globalBroadCastBean.getUser().getExternalId();
        if (externalId == null) {
            externalId = "";
        }
        final UserMenuDialog userMenuDialog = new UserMenuDialog(requireActivity, externalId);
        userMenuDialog.setHideDelete(!z);
        userMenuDialog.setHidePinned(Boolean.valueOf(!z2));
        final DialogUserMenuBinding viewBinding = userMenuDialog.getViewBinding();
        viewBinding.deleteButton.setText(ResourcesKtxKt.getStringById(viewBinding, 2131951981));
        viewBinding.svipLayout.setVisibility(0);
        TextView textView = viewBinding.svipButton;
        String stringById = ResourcesKtxKt.getStringById(viewBinding, 2131952536);
        Integer num2 = null;
        if (svipCheckData != null) {
            num = svipCheckData.getDelTimes();
        } else {
            num = null;
        }
        if (svipCheckData != null) {
            num2 = svipCheckData.getMaxTimes();
        }
        textView.setText(stringById + "(" + num + "/" + num2 + ")");
        final ConstraintLayout constraintLayout = viewBinding.svipLayout;
        final long j = 800;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.GlobalBroadCastViewController$showUserMenuDialog$lambda$11$lambda$10$lambda$9$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean z3;
                int i;
                Integer maxTimes;
                Integer delTimes;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    SvipCheckData svipCheckData2 = svipCheckData;
                    int i2 = 0;
                    if (svipCheckData2 != null) {
                        z3 = Intrinsics.areEqual(svipCheckData2.getCanDel(), Boolean.FALSE);
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, globalBroadCastViewController.getRequireContext(), ResourcesKtxKt.getStringById(viewBinding, 2131954188), false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                            return;
                        }
                        return;
                    }
                    SvipCheckData svipCheckData3 = svipCheckData;
                    if (svipCheckData3 != null && (delTimes = svipCheckData3.getDelTimes()) != null) {
                        i = delTimes.intValue();
                    } else {
                        i = 0;
                    }
                    SvipCheckData svipCheckData4 = svipCheckData;
                    if (svipCheckData4 != null && (maxTimes = svipCheckData4.getMaxTimes()) != null) {
                        i2 = maxTimes.intValue();
                    }
                    if (i >= i2) {
                        Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, globalBroadCastViewController.getRequireContext(), ResourcesKtxKt.getStringById(viewBinding, 2131954189), false, 4, (Object) null);
                        if (normal$default2 != null) {
                            normal$default2.show();
                            return;
                        }
                        return;
                    }
                    UserMenuInterfaces listener = userMenuDialog.getListener();
                    if (listener != null) {
                        listener.onClickDeleteSvip10();
                    }
                    userMenuDialog.dismiss();
                }
            }
        });
        userMenuDialog.setListener(new UserMenuInterfaces() { // from class: com.qiahao.nextvideo.ui.home.GlobalBroadCastViewController$showUserMenuDialog$1$1$2
            @Override // com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces
            public void onClickBlock(String uid) {
                Intrinsics.checkNotNullParameter(uid, "uid");
                if (GlobalBroadCastViewController.this.getMCurrentSelectIndex() != -1) {
                    GlobalBroadCastViewController.this.getMAdapter().removeAt(GlobalBroadCastViewController.this.getMCurrentSelectIndex());
                    GlobalBroadCastViewController.this.setMCurrentSelectIndex(-1);
                }
                FeedbackService.INSTANCE.getShared().getReportEventRelay().accept(uid);
            }

            @Override // com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces
            public void onClickDelete() {
                GlobalBroadCastViewController.this.deleteBroadCast(globalBroadCastBean, 0);
            }

            @Override // com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces
            public void onClickDeleteSvip10() {
                GlobalBroadCastViewController.this.deleteBroadCast(globalBroadCastBean, 1);
            }

            @Override // com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces
            public void onClickPinned() {
                final int i;
                PurchaseFeeDetailsX purchaseFeeDetail = PurchaseService.INSTANCE.getShared().getPurchaseFeeDetail();
                if (purchaseFeeDetail != null) {
                    i = purchaseFeeDetail.getTopGlobalBroadcastFee();
                } else {
                    i = 0;
                }
                TipDialog tipDialog = new TipDialog(GlobalBroadCastViewController.this.getRequireActivity());
                SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(new SpannableTextBuilder(tipDialog.getConfirmButton()), ResourcesKtxKt.getStringById(tipDialog, 2131952331), (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 254, (Object) null), "(", (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 254, (Object) null), String.valueOf(i), (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 254, (Object) null).appendDrawable(R.drawable.bill_diamond, (Function1) null), ")", (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 254, (Object) null).apply();
                TipDialog tipContent = tipDialog.setTipContent(ResourcesKtxKt.getStringById(this, 2131952340));
                final GlobalBroadCastViewController globalBroadCastViewController2 = GlobalBroadCastViewController.this;
                final GlobalBroadCastBean globalBroadCastBean2 = globalBroadCastBean;
                tipContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.GlobalBroadCastViewController$showUserMenuDialog$1$1$2$onClickPinned$2
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                        double d;
                        User user = UserStore.INSTANCE.getShared().getUser();
                        if (user != null) {
                            d = user.getDiamondNum();
                        } else {
                            d = 0.0d;
                        }
                        if (d < i) {
                            globalBroadCastViewController2.goToWallet();
                        } else {
                            globalBroadCastViewController2.broadCastTop((int) globalBroadCastBean2.getUserGlobalBroadcastId());
                        }
                    }
                }).show();
            }

            @Override // com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces
            public void onClickProfile(String uid) {
                Intrinsics.checkNotNullParameter(uid, "uid");
                BaseControlUtils.INSTANCE.openPersonPage(uid);
            }

            @Override // com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces
            public void onClickReport(String uid) {
                Intrinsics.checkNotNullParameter(uid, "uid");
                new ReportWhiteDialog(GlobalBroadCastViewController.this.getRequireActivity()).setListener(new GlobalBroadCastViewController$showUserMenuDialog$1$1$2$onClickReport$1(GlobalBroadCastViewController.this, uid)).show();
            }
        });
        userMenuDialog.show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$3(GlobalBroadCastViewController globalBroadCastViewController, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "bindView");
        GlobalBroadCastBean globalBroadCastBean = (GlobalBroadCastBean) globalBroadCastViewController.getMAdapter().getData().get(i);
        if (view.getId() == 2131365536 && FastClickOneUtils.INSTANCE.isFastClick()) {
            globalBroadCastViewController.mCurrentSelectIndex = i;
            globalBroadCastViewController.mCurrentSelectGlobalBroadCastId = globalBroadCastBean.getUserGlobalBroadcastId();
            globalBroadCastViewController.showUserMenuDialog(globalBroadCastBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$4(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            Object item = baseQuickAdapter.getItem(i);
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.GlobalBroadCastBean");
            StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, ((GlobalBroadCastBean) item).getGroupId(), null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean viewDidLoad$lambda$5(GlobalBroadCastViewController globalBroadCastViewController, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        GlobalBroadCastBean globalBroadCastBean = (GlobalBroadCastBean) globalBroadCastViewController.getMAdapter().getItem(i);
        globalBroadCastViewController.mCurrentSelectIndex = i;
        globalBroadCastViewController.mCurrentSelectGlobalBroadCastId = globalBroadCastBean.getUserGlobalBroadcastId();
        globalBroadCastViewController.showUserMenuDialog(globalBroadCastBean);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$7(GlobalBroadCastViewController globalBroadCastViewController, View view) {
        ControllerListener controllerListener = globalBroadCastViewController.mListener;
        if (controllerListener != null) {
            controllerListener.onBackPress();
        }
    }

    public final void broadCastTop(int id2) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().broadcastTop(id2), new Function1() { // from class: com.qiahao.nextvideo.ui.home.p
            public final Object invoke(Object obj) {
                Unit broadCastTop$lambda$17;
                broadCastTop$lambda$17 = GlobalBroadCastViewController.broadCastTop$lambda$17(GlobalBroadCastViewController.this, (ApiResponse) obj);
                return broadCastTop$lambda$17;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.f
            public final Object invoke(Object obj) {
                Unit broadCastTop$lambda$18;
                broadCastTop$lambda$18 = GlobalBroadCastViewController.broadCastTop$lambda$18(GlobalBroadCastViewController.this, (Throwable) obj);
                return broadCastTop$lambda$18;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    public final void getData(final boolean isRefresh) {
        if (isRefresh) {
            this.mPageIndex = 1;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getGlobalBroadCast(this.mPageIndex, this.mPageSize), new Function1() { // from class: com.qiahao.nextvideo.ui.home.l
            public final Object invoke(Object obj) {
                Unit data$lambda$15;
                data$lambda$15 = GlobalBroadCastViewController.getData$lambda$15(GlobalBroadCastViewController.this, isRefresh, (ApiResponse) obj);
                return data$lambda$15;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.m
            public final Object invoke(Object obj) {
                Unit data$lambda$16;
                data$lambda$16 = GlobalBroadCastViewController.getData$lambda$16(isRefresh, this, (Throwable) obj);
                return data$lambda$16;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    @NotNull
    public final GlobalBroadCastHistoryAdapter getMAdapter() {
        return (GlobalBroadCastHistoryAdapter) this.mAdapter.getValue();
    }

    public final long getMCurrentSelectGlobalBroadCastId() {
        return this.mCurrentSelectGlobalBroadCastId;
    }

    public final int getMCurrentSelectIndex() {
        return this.mCurrentSelectIndex;
    }

    @NotNull
    public final ViewControllerGlobalBroadCastBinding getMDataBinding() {
        ViewControllerGlobalBroadCastBinding viewControllerGlobalBroadCastBinding = this.mDataBinding;
        if (viewControllerGlobalBroadCastBinding != null) {
            return viewControllerGlobalBroadCastBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDataBinding");
        return null;
    }

    @Nullable
    public final ControllerListener getMListener() {
        return this.mListener;
    }

    public final int getMPageIndex() {
        return this.mPageIndex;
    }

    public final int getMPageSize() {
        return this.mPageSize;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerGlobalBroadCastBinding inflate = ViewControllerGlobalBroadCastBinding.inflate(inflater, container, false);
        setMDataBinding(inflate);
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // vc.e
    public void onLoadMore(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        getData(false);
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        getData(true);
    }

    public final void setMCurrentSelectGlobalBroadCastId(long j) {
        this.mCurrentSelectGlobalBroadCastId = j;
    }

    public final void setMCurrentSelectIndex(int i) {
        this.mCurrentSelectIndex = i;
    }

    public final void setMDataBinding(@NotNull ViewControllerGlobalBroadCastBinding viewControllerGlobalBroadCastBinding) {
        Intrinsics.checkNotNullParameter(viewControllerGlobalBroadCastBinding, "<set-?>");
        this.mDataBinding = viewControllerGlobalBroadCastBinding;
    }

    public final void setMListener(@Nullable ControllerListener controllerListener) {
        this.mListener = controllerListener;
    }

    public final void setMPageIndex(int i) {
        this.mPageIndex = i;
    }

    public final void setMPageSize(int i) {
        this.mPageSize = i;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        HiloBaseActivity requireActivity = getRequireActivity();
        Toolbar toolbar = getMDataBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        requireActivity.setStatusBarTopOrBottom(toolbar, false);
        RecyclerView recyclerView = getMDataBinding().commonIdRecyclerView;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getMAdapter());
        getMAdapter().addChildClickViewIds(new int[]{2131365536});
        getMAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.home.e
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                GlobalBroadCastViewController.viewDidLoad$lambda$3(GlobalBroadCastViewController.this, baseQuickAdapter, view2, i);
            }
        });
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.h
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                GlobalBroadCastViewController.viewDidLoad$lambda$4(baseQuickAdapter, view2, i);
            }
        });
        getMAdapter().setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.qiahao.nextvideo.ui.home.i
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                boolean viewDidLoad$lambda$5;
                viewDidLoad$lambda$5 = GlobalBroadCastViewController.viewDidLoad$lambda$5(GlobalBroadCastViewController.this, baseQuickAdapter, view2, i);
                return viewDidLoad$lambda$5;
            }
        });
        getMDataBinding().commonIdSwipeRefreshLayout.setEnableLoadMore(false);
        getMDataBinding().commonIdSwipeRefreshLayout.setEnableRefresh(true);
        getMDataBinding().commonIdSwipeRefreshLayout.setOnRefreshListener(this);
        getMDataBinding().commonIdSwipeRefreshLayout.setOnLoadMoreListener(this);
        SmartRefreshLayout smartRefreshLayout = getMDataBinding().commonIdSwipeRefreshLayout;
        FootLoading footLoading = new FootLoading(getRequireContext());
        footLoading.setBackground(footLoading.getContext().getDrawable(2131101214));
        smartRefreshLayout.setRefreshFooter(footLoading);
        getData(true);
        getMDataBinding().backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GlobalBroadCastViewController.viewDidLoad$lambda$7(GlobalBroadCastViewController.this, view2);
            }
        });
    }
}
