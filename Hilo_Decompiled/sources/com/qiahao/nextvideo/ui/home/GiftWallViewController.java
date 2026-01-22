package com.qiahao.nextvideo.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.interfaceing.ControllerListener;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.data.model.GiftWallBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ViewControllerGiftWallBinding;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.Collection;
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

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0015\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u00101\u001a\u00020,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\"\u00103\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u00104\u001a\u0004\b:\u00106\"\u0004\b;\u00108¨\u0006<"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/GiftWallViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Lvc/g;", "Lvc/e;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;", "view", "", "viewDidLoad", "(Landroid/view/View;)V", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "onLoadMore", "", "isRefresh", "getData", "(Z)V", "", SupportGiftRankActivity.EXTERNAL_ID, "onOpenUserProfile", "(Ljava/lang/String;)V", "Lcom/qiahao/nextvideo/databinding/ViewControllerGiftWallBinding;", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ViewControllerGiftWallBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ViewControllerGiftWallBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ViewControllerGiftWallBinding;)V", "Lcom/qiahao/base_common/interfaceing/ControllerListener;", "mListener", "Lcom/qiahao/base_common/interfaceing/ControllerListener;", "getMListener", "()Lcom/qiahao/base_common/interfaceing/ControllerListener;", "setMListener", "(Lcom/qiahao/base_common/interfaceing/ControllerListener;)V", "Lcom/qiahao/nextvideo/ui/home/GiftWallAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/home/GiftWallAdapter;", "mAdapter", "", "mPageIndex", "I", "getMPageIndex", "()I", "setMPageIndex", "(I)V", "mPageSize", "getMPageSize", "setMPageSize", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGiftWallViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GiftWallViewController.kt\ncom/qiahao/nextvideo/ui/home/GiftWallViewController\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,145:1\n61#2,9:146\n*S KotlinDebug\n*F\n+ 1 GiftWallViewController.kt\ncom/qiahao/nextvideo/ui/home/GiftWallViewController\n*L\n84#1:146,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GiftWallViewController extends BaseViewController implements vc.g, vc.e {
    public ViewControllerGiftWallBinding mDataBinding;

    @Nullable
    private ControllerListener mListener;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.d
        public final Object invoke() {
            GiftWallAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = GiftWallViewController.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });
    private int mPageIndex = 1;
    private int mPageSize = 10;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$6(GiftWallViewController giftWallViewController, boolean z, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        giftWallViewController.mPageIndex++;
        if (z) {
            giftWallViewController.getMDataBinding().commonIdSwipeRefreshLayout.finishRefresh();
        } else {
            giftWallViewController.getMDataBinding().commonIdSwipeRefreshLayout.finishLoadMore();
        }
        List list = (List) apiResponse.getData();
        if (list != null && list.isEmpty()) {
            giftWallViewController.getMDataBinding().emptyTipTextView.setVisibility(0);
            giftWallViewController.getMAdapter().setList((Collection) null);
            giftWallViewController.getMDataBinding().commonIdSwipeRefreshLayout.setEnableLoadMore(false);
        } else {
            giftWallViewController.getMDataBinding().emptyTipTextView.setVisibility(8);
            List list2 = (List) apiResponse.getData();
            if (list2 != null && list2.size() == giftWallViewController.mPageSize) {
                giftWallViewController.getMDataBinding().commonIdSwipeRefreshLayout.setEnableLoadMore(true);
            } else {
                giftWallViewController.getMDataBinding().commonIdSwipeRefreshLayout.setEnableLoadMore(false);
            }
            List list3 = (List) apiResponse.getData();
            if (list3 != null) {
                if (z) {
                    giftWallViewController.getMAdapter().setList(list3);
                } else {
                    giftWallViewController.getMAdapter().addData(list3);
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$7(boolean z, GiftWallViewController giftWallViewController, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (z) {
            giftWallViewController.getMAdapter().setList((Collection) null);
        }
        if (giftWallViewController.getMAdapter().getData().isEmpty()) {
            giftWallViewController.getMDataBinding().emptyTipTextView.setVisibility(0);
        } else {
            giftWallViewController.getMDataBinding().emptyTipTextView.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GiftWallAdapter mAdapter_delegate$lambda$0() {
        return new GiftWallAdapter(R.layout.item_gift_wall);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$3(GiftWallViewController giftWallViewController, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.GiftWallBean");
        GiftWallBean giftWallBean = (GiftWallBean) item;
        int id2 = view.getId();
        String str = "";
        if (id2 != 2131364480) {
            if (id2 == 2131364783 && FastClickOneUtils.INSTANCE.isFastClick()) {
                String externalId = giftWallBean.getSendUser().getExternalId();
                if (externalId != null) {
                    str = externalId;
                }
                giftWallViewController.onOpenUserProfile(str);
                return;
            }
            return;
        }
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            String externalId2 = giftWallBean.getReceiveUser().getExternalId();
            if (externalId2 != null) {
                str = externalId2;
            }
            giftWallViewController.onOpenUserProfile(str);
        }
    }

    public final void getData(final boolean isRefresh) {
        if (isRefresh) {
            this.mPageIndex = 1;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getGiftWall(this.mPageIndex, this.mPageSize), new Function1() { // from class: com.qiahao.nextvideo.ui.home.b
            public final Object invoke(Object obj) {
                Unit data$lambda$6;
                data$lambda$6 = GiftWallViewController.getData$lambda$6(GiftWallViewController.this, isRefresh, (ApiResponse) obj);
                return data$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.c
            public final Object invoke(Object obj) {
                Unit data$lambda$7;
                data$lambda$7 = GiftWallViewController.getData$lambda$7(isRefresh, this, (Throwable) obj);
                return data$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    @NotNull
    public final GiftWallAdapter getMAdapter() {
        return (GiftWallAdapter) this.mAdapter.getValue();
    }

    @NotNull
    public final ViewControllerGiftWallBinding getMDataBinding() {
        ViewControllerGiftWallBinding viewControllerGiftWallBinding = this.mDataBinding;
        if (viewControllerGiftWallBinding != null) {
            return viewControllerGiftWallBinding;
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
        ViewControllerGiftWallBinding inflate = ViewControllerGiftWallBinding.inflate(inflater, container, false);
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
        getData(true);
    }

    public final void setMDataBinding(@NotNull ViewControllerGiftWallBinding viewControllerGiftWallBinding) {
        Intrinsics.checkNotNullParameter(viewControllerGiftWallBinding, "<set-?>");
        this.mDataBinding = viewControllerGiftWallBinding;
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
        getRequireActivity().setStatusBarIconColor(false);
        RecyclerView recyclerView = getMDataBinding().commonIdRecyclerView;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getMAdapter());
        getMAdapter().addChildClickViewIds(new int[]{R.id.send_avatar});
        getMAdapter().addChildClickViewIds(new int[]{R.id.receiver_avatar});
        getMAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.home.a
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                GiftWallViewController.viewDidLoad$lambda$3(GiftWallViewController.this, baseQuickAdapter, view2, i);
            }
        });
        getMDataBinding().commonIdSwipeRefreshLayout.setEnableLoadMore(false);
        getMDataBinding().commonIdSwipeRefreshLayout.setEnableRefresh(true);
        getMDataBinding().commonIdSwipeRefreshLayout.setOnRefreshListener(this);
        getMDataBinding().commonIdSwipeRefreshLayout.setOnLoadMoreListener(this);
        getMDataBinding().commonIdSwipeRefreshLayout.setRefreshFooter(new FootLoading(getRequireContext()));
        getData(true);
        final AppCompatImageView appCompatImageView = getMDataBinding().backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.GiftWallViewController$viewDidLoad$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    ControllerListener mListener = this.getMListener();
                    if (mListener != null) {
                        mListener.onBackPress();
                    }
                }
            }
        });
    }
}
