package com.qiahao.nextvideo.ui.rank;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.cache.MMKVToLocalCache;
import com.qiahao.nextvideo.data.model.MyCpBean;
import com.qiahao.nextvideo.data.model.UserSummaryInfo;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ViewCpMyRankBinding;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmPreloadModel;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewController;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 E2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001EB\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u000eJ\u000f\u0010\u001a\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001a\u0010\u000eJ\u000f\u0010\u001b\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001b\u0010\u000eJ\u0015\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010$\u001a\u00020\f2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\fH\u0016¢\u0006\u0004\b&\u0010\u000eR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010)R\"\u0010*\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R$\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0017\u0010;\u001a\u00020:8\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001b\u0010D\u001a\u00020?8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/CpMyRankWrapper;", "Landroid/widget/FrameLayout;", "Lvc/g;", "Lvc/e;", "Lcom/qiahao/nextvideo/ui/rank/MyCpRankMenuViewControllerDelegate;", "Lcom/qiahao/nextvideo/ui/edition/country/confirmtip/ConfirmTipViewControllerDelegate;", "Landroid/content/Context;", "context", "Lcom/qiahao/nextvideo/ui/rank/CpRankViewController;", "viewController", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/ui/rank/CpRankViewController;)V", "", "initRecyclerView", "()V", "initView", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "onLoadMore", "", "isRefresh", "getDate", "(Z)V", "showCache", "myCpRankMenuViewControllerdismiss", "releaseCpRelationship", "", SupportGiftRankActivity.EXTERNAL_ID, "onOpenUserProfile", "(Ljava/lang/String;)V", "", "fromCode", "Landroid/os/Bundle;", "extra", "confirmTipViewControllerDidConfirm", "(ILandroid/os/Bundle;)V", "confirmTipViewControllerDidCancel", "Lcom/qiahao/nextvideo/ui/rank/CpRankViewController;", "getViewController", "()Lcom/qiahao/nextvideo/ui/rank/CpRankViewController;", "mPageIndex", "I", "getMPageIndex", "()I", "setMPageIndex", "(I)V", "mPageSize", "getMPageSize", "setMPageSize", "Lcom/qiahao/nextvideo/data/model/MyCpBean;", "mMyCpBean", "Lcom/qiahao/nextvideo/data/model/MyCpBean;", "getMMyCpBean", "()Lcom/qiahao/nextvideo/data/model/MyCpBean;", "setMMyCpBean", "(Lcom/qiahao/nextvideo/data/model/MyCpBean;)V", "Lcom/qiahao/nextvideo/databinding/ViewCpMyRankBinding;", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ViewCpMyRankBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ViewCpMyRankBinding;", "Lcom/qiahao/nextvideo/ui/rank/CpMyRankAdapter;", "mCpMyRankAdapter$delegate", "Lkotlin/Lazy;", "getMCpMyRankAdapter", "()Lcom/qiahao/nextvideo/ui/rank/CpMyRankAdapter;", "mCpMyRankAdapter", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpMyRankWrapper extends FrameLayout implements vc.g, vc.e, MyCpRankMenuViewControllerDelegate, ConfirmTipViewControllerDelegate {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "CpMyRankWrapper";

    /* renamed from: mCpMyRankAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mCpMyRankAdapter;

    @NotNull
    private final ViewCpMyRankBinding mDataBinding;

    @Nullable
    private MyCpBean mMyCpBean;
    private int mPageIndex;
    private int mPageSize;

    @NotNull
    private final CpRankViewController viewController;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/CpMyRankWrapper$Companion;", "", "<init>", "()V", "TAG", "", "init", "Lcom/qiahao/nextvideo/ui/rank/CpMyRankWrapper;", "viewController", "Lcom/qiahao/nextvideo/ui/rank/CpRankViewController;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CpMyRankWrapper init(@NotNull CpRankViewController viewController) {
            Intrinsics.checkNotNullParameter(viewController, "viewController");
            Log.d(CpMyRankWrapper.TAG, "init: ");
            return new CpMyRankWrapper(viewController.getRequireContext(), viewController);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpMyRankWrapper(@NotNull Context context, @NotNull CpRankViewController cpRankViewController) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cpRankViewController, "viewController");
        this.viewController = cpRankViewController;
        this.mPageIndex = 1;
        this.mPageSize = 10;
        ViewDataBinding h = androidx.databinding.g.h(LayoutInflater.from(context), R.layout.view_cp_my_rank, this, true);
        Intrinsics.checkNotNullExpressionValue(h, "inflate(...)");
        this.mDataBinding = (ViewCpMyRankBinding) h;
        this.mCpMyRankAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.rank.x
            public final Object invoke() {
                CpMyRankAdapter mCpMyRankAdapter_delegate$lambda$0;
                mCpMyRankAdapter_delegate$lambda$0 = CpMyRankWrapper.mCpMyRankAdapter_delegate$lambda$0();
                return mCpMyRankAdapter_delegate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmTipViewControllerDidConfirm$lambda$12(CpMyRankWrapper cpMyRankWrapper, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ViewController.dismiss$default(cpMyRankWrapper.viewController, true, null, 2, null);
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, cpMyRankWrapper.getContext(), BaseViewControllerKt.getString(cpMyRankWrapper.viewController, 2131954177, new Object[0]), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        cpMyRankWrapper.getDate(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmTipViewControllerDidConfirm$lambda$13(CpMyRankWrapper cpMyRankWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, cpMyRankWrapper.getContext(), BaseViewControllerKt.getString(cpMyRankWrapper.viewController, 2131952667, new Object[0]), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getDate$lambda$6(CpMyRankWrapper cpMyRankWrapper, boolean z, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        cpMyRankWrapper.mPageIndex++;
        ArrayList arrayList = (ArrayList) apiResponse.getData();
        if (arrayList != null && arrayList.isEmpty()) {
            if (z) {
                cpMyRankWrapper.mDataBinding.emptyTipTextView.setVisibility(0);
                cpMyRankWrapper.getMCpMyRankAdapter().setList((Collection) apiResponse.getData());
            }
            cpMyRankWrapper.mDataBinding.smartRefreshLayout.setEnableLoadMore(false);
        } else {
            cpMyRankWrapper.mDataBinding.emptyTipTextView.setVisibility(8);
            ArrayList arrayList2 = (ArrayList) apiResponse.getData();
            if (arrayList2 != null && arrayList2.size() == cpMyRankWrapper.mPageSize) {
                cpMyRankWrapper.mDataBinding.smartRefreshLayout.setEnableLoadMore(true);
            } else {
                cpMyRankWrapper.mDataBinding.smartRefreshLayout.setEnableLoadMore(false);
            }
            ArrayList<MyCpBean> arrayList3 = (ArrayList) apiResponse.getData();
            if (arrayList3 != null) {
                if (z) {
                    MMKVToLocalCache.INSTANCE.saveCpMyRankCache(arrayList3);
                    cpMyRankWrapper.getMCpMyRankAdapter().setList(arrayList3);
                } else {
                    cpMyRankWrapper.getMCpMyRankAdapter().addData(arrayList3);
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getDate$lambda$7(CpMyRankWrapper cpMyRankWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (cpMyRankWrapper.mPageIndex == 1) {
            cpMyRankWrapper.mDataBinding.emptyTipTextView.setVisibility(0);
            cpMyRankWrapper.getMCpMyRankAdapter().setList(new ArrayList());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getDate$lambda$8(boolean z, CpMyRankWrapper cpMyRankWrapper) {
        if (z) {
            cpMyRankWrapper.mDataBinding.smartRefreshLayout.finishRefresh();
        } else {
            cpMyRankWrapper.mDataBinding.smartRefreshLayout.finishLoadMore();
        }
        return Unit.INSTANCE;
    }

    private final void initRecyclerView() {
        this.mDataBinding.smartRefreshLayout.setOnRefreshListener(this);
        this.mDataBinding.smartRefreshLayout.setOnLoadMoreListener(this);
        this.mDataBinding.smartRefreshLayout.setEnableLoadMore(false);
        RecyclerView recyclerView = this.mDataBinding.recyclerRank;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getMCpMyRankAdapter());
        getMCpMyRankAdapter().setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.qiahao.nextvideo.ui.rank.q
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                boolean initRecyclerView$lambda$3;
                initRecyclerView$lambda$3 = CpMyRankWrapper.initRecyclerView$lambda$3(CpMyRankWrapper.this, baseQuickAdapter, view, i);
                return initRecyclerView$lambda$3;
            }
        });
        getMCpMyRankAdapter().addChildClickViewIds(new int[]{R.id.user1_avatar_cimage_view});
        getMCpMyRankAdapter().addChildClickViewIds(new int[]{R.id.user2_avatar_cimage_view});
        getMCpMyRankAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.rank.r
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CpMyRankWrapper.initRecyclerView$lambda$4(CpMyRankWrapper.this, baseQuickAdapter, view, i);
            }
        });
        getDate(true);
        showCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initRecyclerView$lambda$3(CpMyRankWrapper cpMyRankWrapper, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        cpMyRankWrapper.mMyCpBean = (MyCpBean) baseQuickAdapter.getData().get(i);
        CpRankViewController cpRankViewController = cpMyRankWrapper.viewController;
        MyCpRankMenuViewController myCpRankMenuViewController = new MyCpRankMenuViewController();
        myCpRankMenuViewController.setDelegate(cpMyRankWrapper);
        ViewController.present$default(cpRankViewController, myCpRankMenuViewController, true, null, 4, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$4(CpMyRankWrapper cpMyRankWrapper, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String externalId;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.MyCpBean");
        MyCpBean myCpBean = (MyCpBean) item;
        int id2 = view.getId();
        String str = "";
        if (id2 != 2131365514) {
            if (id2 == 2131365517) {
                String externalId2 = myCpBean.getUser().getExternalId();
                if (externalId2 != null) {
                    str = externalId2;
                }
                cpMyRankWrapper.onOpenUserProfile(str);
                return;
            }
            return;
        }
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null && (externalId = user.getExternalId()) != null) {
            str = externalId;
        }
        cpMyRankWrapper.onOpenUserProfile(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CpMyRankAdapter mCpMyRankAdapter_delegate$lambda$0() {
        return new CpMyRankAdapter(R.layout.item_cp_my_rank);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit releaseCpRelationship$lambda$11(CpMyRankWrapper cpMyRankWrapper) {
        ConfirmTipViewController confirmTipViewController = new ConfirmTipViewController(ConfirmPreloadModel.INSTANCE.init(BaseViewControllerKt.getString(cpMyRankWrapper.viewController, 2131952343, new Object[0]), BaseViewControllerKt.getString(cpMyRankWrapper.viewController, 2131952331, new Object[0]), BaseViewControllerKt.getString(cpMyRankWrapper.viewController, 2131952171, new Object[0])), null, 2, null);
        confirmTipViewController.setDelegate(cpMyRankWrapper);
        ViewController.present$default(cpMyRankWrapper.viewController, confirmTipViewController, true, null, 4, null);
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidCancel() {
        ViewController.dismiss$default(this.viewController, true, null, 2, null);
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidConfirm(int fromCode, @NotNull Bundle extra) {
        String str;
        UserSummaryInfo user;
        Intrinsics.checkNotNullParameter(extra, "extra");
        ViewController.dismiss$default(this.viewController, true, null, 2, null);
        if (this.mMyCpBean != null) {
            UserService shared = UserService.INSTANCE.getShared();
            MyCpBean myCpBean = this.mMyCpBean;
            if (myCpBean == null || (user = myCpBean.getUser()) == null || (str = user.getExternalId()) == null) {
                str = "";
            }
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.cpDisconnect(str), new Function1() { // from class: com.qiahao.nextvideo.ui.rank.s
                public final Object invoke(Object obj) {
                    Unit confirmTipViewControllerDidConfirm$lambda$12;
                    confirmTipViewControllerDidConfirm$lambda$12 = CpMyRankWrapper.confirmTipViewControllerDidConfirm$lambda$12(CpMyRankWrapper.this, (ApiResponse) obj);
                    return confirmTipViewControllerDidConfirm$lambda$12;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.rank.t
                public final Object invoke(Object obj) {
                    Unit confirmTipViewControllerDidConfirm$lambda$13;
                    confirmTipViewControllerDidConfirm$lambda$13 = CpMyRankWrapper.confirmTipViewControllerDidConfirm$lambda$13(CpMyRankWrapper.this, (Throwable) obj);
                    return confirmTipViewControllerDidConfirm$lambda$13;
                }
            }, (Function0) null, false, 12, (Object) null), this.viewController.getCompositeDisposable());
            return;
        }
        Log.d(TAG, "releaseCpRelationship: mMyCpBean为null");
    }

    public final void getDate(final boolean isRefresh) {
        if (isRefresh) {
            this.mPageIndex = 1;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getMyCpRankList(this.mPageIndex, this.mPageSize), new Function1() { // from class: com.qiahao.nextvideo.ui.rank.u
            public final Object invoke(Object obj) {
                Unit date$lambda$6;
                date$lambda$6 = CpMyRankWrapper.getDate$lambda$6(CpMyRankWrapper.this, isRefresh, (ApiResponse) obj);
                return date$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.rank.v
            public final Object invoke(Object obj) {
                Unit date$lambda$7;
                date$lambda$7 = CpMyRankWrapper.getDate$lambda$7(CpMyRankWrapper.this, (Throwable) obj);
                return date$lambda$7;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.ui.rank.w
            public final Object invoke() {
                Unit date$lambda$8;
                date$lambda$8 = CpMyRankWrapper.getDate$lambda$8(isRefresh, this);
                return date$lambda$8;
            }
        }, false, 8, (Object) null), this.viewController.getCompositeDisposable());
    }

    @NotNull
    public final CpMyRankAdapter getMCpMyRankAdapter() {
        return (CpMyRankAdapter) this.mCpMyRankAdapter.getValue();
    }

    @NotNull
    public final ViewCpMyRankBinding getMDataBinding() {
        return this.mDataBinding;
    }

    @Nullable
    public final MyCpBean getMMyCpBean() {
        return this.mMyCpBean;
    }

    public final int getMPageIndex() {
        return this.mPageIndex;
    }

    public final int getMPageSize() {
        return this.mPageSize;
    }

    @NotNull
    public final CpRankViewController getViewController() {
        return this.viewController;
    }

    public final void initView() {
        initRecyclerView();
    }

    @Override // com.qiahao.nextvideo.ui.rank.MyCpRankMenuViewControllerDelegate
    public void myCpRankMenuViewControllerdismiss() {
        ViewController.dismiss$default(this.viewController, true, null, 2, null);
    }

    @Override // vc.e
    public void onLoadMore(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        getDate(false);
    }

    public final void onOpenUserProfile(@NotNull String externalId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openPersonPage(externalId);
        }
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        getDate(true);
    }

    @Override // com.qiahao.nextvideo.ui.rank.MyCpRankMenuViewControllerDelegate
    public void releaseCpRelationship() {
        this.viewController.dismiss(true, new Function0() { // from class: com.qiahao.nextvideo.ui.rank.p
            public final Object invoke() {
                Unit releaseCpRelationship$lambda$11;
                releaseCpRelationship$lambda$11 = CpMyRankWrapper.releaseCpRelationship$lambda$11(CpMyRankWrapper.this);
                return releaseCpRelationship$lambda$11;
            }
        });
    }

    public final void setMMyCpBean(@Nullable MyCpBean myCpBean) {
        this.mMyCpBean = myCpBean;
    }

    public final void setMPageIndex(int i) {
        this.mPageIndex = i;
    }

    public final void setMPageSize(int i) {
        this.mPageSize = i;
    }

    public final void showCache() {
        ArrayList<MyCpBean> cpMyRankCache = MMKVToLocalCache.INSTANCE.getCpMyRankCache();
        if (cpMyRankCache != null) {
            getMCpMyRankAdapter().setList(cpMyRankCache);
        }
    }
}
