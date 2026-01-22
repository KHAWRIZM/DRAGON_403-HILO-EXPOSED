package com.qiahao.nextvideo.ui.store;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.MyBagBean;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ViewMyBagBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmPreloadModel;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewController;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.qiahao.nextvideo.utilities.decorate.GridSpacingItemMulityCountryDecoration;
import java.io.Serializable;
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

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001UB\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u000fJ\u000f\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u000fJ\u001d\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\r¢\u0006\u0004\b\u001a\u0010\u000fJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\"\u0010!J\u001f\u0010&\u001a\u00020\r2\u0006\u0010#\u001a\u00020\t2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\rH\u0016¢\u0006\u0004\b(\u0010\u000fJ/\u0010/\u001a\u00020\r2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010-¢\u0006\u0004\b/\u00100R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u00101\u001a\u0004\b2\u00103R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u00104\u001a\u0004\b5\u00106R\"\u00107\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00104\u001a\u0004\b8\u00106\"\u0004\b9\u0010:R\"\u0010;\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u00104\u001a\u0004\b<\u00106\"\u0004\b=\u0010:R\"\u0010?\u001a\u00020>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0017\u0010F\u001a\u00020E8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR$\u0010J\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010\u0013R\u001b\u0010T\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S¨\u0006V"}, d2 = {"Lcom/qiahao/nextvideo/ui/store/MyBagWrapper;", "Landroid/widget/FrameLayout;", "Lvc/g;", "Lvc/e;", "Lcom/qiahao/nextvideo/ui/edition/country/confirmtip/ConfirmTipViewControllerDelegate;", "Landroid/content/Context;", "context", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "baseViewController", "", "mType", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;I)V", "", "initRecyclerView", "()V", "Lcom/qiahao/base_common/model/MyBagBean;", "myBagBean", "usingBagGoods", "(Lcom/qiahao/base_common/model/MyBagBean;)V", "getData", "showEmpty", "data", "position", "delete", "(Lcom/qiahao/base_common/model/MyBagBean;I)V", "confirmUsing", "", "checkCanSend", "()Z", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "onLoadMore", "fromCode", "Landroid/os/Bundle;", "extra", "confirmTipViewControllerDidConfirm", "(ILandroid/os/Bundle;)V", "confirmTipViewControllerDidCancel", "", "storeId", "", "extraId", "Lkotlin/Function0;", "completion", "send", "(JLjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "getBaseViewController", "()Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "I", "getMType", "()I", "indexPage", "getIndexPage", "setIndexPage", "(I)V", "pageSize", "getPageSize", "setPageSize", "Lcom/qiahao/nextvideo/databinding/ViewMyBagBinding;", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ViewMyBagBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ViewMyBagBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ViewMyBagBinding;)V", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "bagBean", "Lcom/qiahao/base_common/model/MyBagBean;", "getBagBean", "()Lcom/qiahao/base_common/model/MyBagBean;", "setBagBean", "Lcom/qiahao/nextvideo/ui/store/MyBagAdapter;", "myBagAdapter$delegate", "Lkotlin/Lazy;", "getMyBagAdapter", "()Lcom/qiahao/nextvideo/ui/store/MyBagAdapter;", "myBagAdapter", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMyBagWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyBagWrapper.kt\ncom/qiahao/nextvideo/ui/store/MyBagWrapper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,353:1\n1869#2,2:354\n774#2:356\n865#2,2:357\n774#2:359\n865#2,2:360\n*S KotlinDebug\n*F\n+ 1 MyBagWrapper.kt\ncom/qiahao/nextvideo/ui/store/MyBagWrapper\n*L\n84#1:354,2\n247#1:356\n247#1:357,2\n269#1:359\n269#1:360,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MyBagWrapper extends FrameLayout implements vc.g, vc.e, ConfirmTipViewControllerDelegate {
    public static final int MY_BAG_HEAD_WEAR_TYPE = 1;
    public static final int MY_BAG_MOUNTS_TYPE = 0;

    @NotNull
    private static final String TAG = "HeadWearStoreWrapper";

    @Nullable
    private MyBagBean bagBean;

    @NotNull
    private final BaseViewController baseViewController;

    @NotNull
    private final nd.a compositeDisposable;
    private int indexPage;

    @NotNull
    private ViewMyBagBinding mDataBinding;
    private final int mType;

    /* renamed from: myBagAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy myBagAdapter;
    private int pageSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyBagWrapper(@NotNull Context context, @NotNull BaseViewController baseViewController, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(baseViewController, "baseViewController");
        this.baseViewController = baseViewController;
        this.mType = i;
        this.indexPage = 1;
        this.pageSize = 10;
        ViewDataBinding h = androidx.databinding.g.h(LayoutInflater.from(context), R.layout.view_my_bag, this, true);
        Intrinsics.checkNotNullExpressionValue(h, "inflate(...)");
        this.mDataBinding = (ViewMyBagBinding) h;
        this.compositeDisposable = new nd.a();
        this.myBagAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.store.b1
            public final Object invoke() {
                MyBagAdapter myBagAdapter_delegate$lambda$0;
                myBagAdapter_delegate$lambda$0 = MyBagWrapper.myBagAdapter_delegate$lambda$0();
                return myBagAdapter_delegate$lambda$0;
            }
        });
        initRecyclerView();
        getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmTipViewControllerDidConfirm$lambda$28(Bundle bundle, MyBagWrapper myBagWrapper) {
        Serializable serializable = bundle.getSerializable("myBagBean");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qiahao.base_common.model.MyBagBean");
        myBagWrapper.usingBagGoods((MyBagBean) serializable);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit delete$lambda$6(MyBagWrapper myBagWrapper, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, myBagWrapper.getContext(), ResourcesKtxKt.getStringById(myBagWrapper, 2131954176), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        myBagWrapper.getData();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit delete$lambda$7(MyBagWrapper myBagWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, myBagWrapper.getContext(), ResourcesKtxKt.getStringById(myBagWrapper, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit delete$lambda$8(MyBagWrapper myBagWrapper, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, myBagWrapper.getContext(), ResourcesKtxKt.getStringById(myBagWrapper, 2131954176), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        myBagWrapper.getData();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit delete$lambda$9(MyBagWrapper myBagWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, myBagWrapper.getContext(), ResourcesKtxKt.getStringById(myBagWrapper, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final void getData() {
        String str;
        int i = this.mType;
        if (i == 1) {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getMyHeadWear(), new Function1() { // from class: com.qiahao.nextvideo.ui.store.q1
                public final Object invoke(Object obj) {
                    Unit data$lambda$20;
                    data$lambda$20 = MyBagWrapper.getData$lambda$20(MyBagWrapper.this, (ApiResponse) obj);
                    return data$lambda$20;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.r1
                public final Object invoke(Object obj) {
                    Unit data$lambda$21;
                    data$lambda$21 = MyBagWrapper.getData$lambda$21(MyBagWrapper.this, (Throwable) obj);
                    return data$lambda$21;
                }
            }, new Function0() { // from class: com.qiahao.nextvideo.ui.store.s1
                public final Object invoke() {
                    Unit data$lambda$22;
                    data$lambda$22 = MyBagWrapper.getData$lambda$22(MyBagWrapper.this);
                    return data$lambda$22;
                }
            }, false, 8, (Object) null), this.compositeDisposable);
            return;
        }
        if (i == 0) {
            UserService shared = UserService.INSTANCE.getShared();
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user == null || (str = user.getExternalId()) == null) {
                str = "";
            }
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.getMyProperty(str), new Function1() { // from class: com.qiahao.nextvideo.ui.store.t1
                public final Object invoke(Object obj) {
                    Unit data$lambda$25;
                    data$lambda$25 = MyBagWrapper.getData$lambda$25(MyBagWrapper.this, (ApiResponse) obj);
                    return data$lambda$25;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.u1
                public final Object invoke(Object obj) {
                    Unit data$lambda$26;
                    data$lambda$26 = MyBagWrapper.getData$lambda$26(MyBagWrapper.this, (Throwable) obj);
                    return data$lambda$26;
                }
            }, new Function0() { // from class: com.qiahao.nextvideo.ui.store.v1
                public final Object invoke() {
                    Unit data$lambda$27;
                    data$lambda$27 = MyBagWrapper.getData$lambda$27(MyBagWrapper.this);
                    return data$lambda$27;
                }
            }, false, 8, (Object) null), this.compositeDisposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$20(MyBagWrapper myBagWrapper, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list = (List) apiResponse.getData();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                MyBagBean myBagBean = (MyBagBean) obj;
                if (myBagBean.getUsing()) {
                    myBagWrapper.getMyBagAdapter().setSelectData(myBagBean);
                    myBagWrapper.bagBean = myBagBean;
                }
                if (myBagBean.getTimeLeft() >= 0) {
                    arrayList.add(obj);
                }
            }
            myBagWrapper.getMyBagAdapter().setList(arrayList);
            myBagWrapper.showEmpty();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$21(MyBagWrapper myBagWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        myBagWrapper.showEmpty();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$22(MyBagWrapper myBagWrapper) {
        myBagWrapper.mDataBinding.commonIdSwipeRefreshLayout.finishRefresh();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$25(MyBagWrapper myBagWrapper, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list = (List) apiResponse.getData();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                MyBagBean myBagBean = (MyBagBean) obj;
                if (myBagBean.getUsing()) {
                    myBagWrapper.getMyBagAdapter().setSelectData(myBagBean);
                    myBagWrapper.bagBean = myBagBean;
                }
                if (myBagBean.getTimeLeft() >= 0) {
                    arrayList.add(obj);
                }
            }
            myBagWrapper.getMyBagAdapter().setList(arrayList);
            myBagWrapper.showEmpty();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$26(MyBagWrapper myBagWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        myBagWrapper.showEmpty();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$27(MyBagWrapper myBagWrapper) {
        myBagWrapper.mDataBinding.commonIdSwipeRefreshLayout.finishRefresh();
        return Unit.INSTANCE;
    }

    private final MyBagAdapter getMyBagAdapter() {
        return (MyBagAdapter) this.myBagAdapter.getValue();
    }

    private final void initRecyclerView() {
        this.mDataBinding.commonIdSwipeRefreshLayout.setOnRefreshListener(this);
        this.mDataBinding.commonIdSwipeRefreshLayout.setOnLoadMoreListener(this);
        this.mDataBinding.commonIdSwipeRefreshLayout.setEnableRefresh(true);
        this.mDataBinding.commonIdSwipeRefreshLayout.setEnableLoadMore(false);
        RecyclerView recyclerView = this.mDataBinding.commonIdRecyclerView;
        recyclerView.setAdapter(getMyBagAdapter());
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3));
        recyclerView.addItemDecoration(new GridSpacingItemMulityCountryDecoration(3, UiKtxKt.toPX(10), true));
        getMyBagAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.store.m1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MyBagWrapper.initRecyclerView$lambda$4(MyBagWrapper.this, baseQuickAdapter, view, i);
            }
        });
        getMyBagAdapter().addChildClickViewIds(new int[]{2131362625});
        getMyBagAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.store.p1
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MyBagWrapper.initRecyclerView$lambda$5(MyBagWrapper.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$4(MyBagWrapper myBagWrapper, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.base_common.model.MyBagBean");
        myBagWrapper.bagBean = (MyBagBean) item;
        List<MyBagBean> data = myBagWrapper.getMyBagAdapter().getData();
        for (MyBagBean myBagBean : data) {
            myBagBean.setUsing(false);
            MyBagBean myBagBean2 = myBagWrapper.bagBean;
            if (myBagBean2 != null && myBagBean.getId() == myBagBean2.getId()) {
                myBagBean.setUsing(true);
            }
        }
        myBagWrapper.getMyBagAdapter().setList(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$5(final MyBagWrapper myBagWrapper, BaseQuickAdapter baseQuickAdapter, View view, final int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (HiloUtils.INSTANCE.notFastClick()) {
            final MyBagBean myBagBean = (MyBagBean) myBagWrapper.getMyBagAdapter().getItem(i);
            Context context = myBagWrapper.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(myBagWrapper, 2131952335)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.store.MyBagWrapper$initRecyclerView$3$1
                public void cancel() {
                    OnCommonDialogListener.DefaultImpls.cancel(this);
                }

                public void confirm() {
                    MyBagWrapper.this.delete(myBagBean, i);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MyBagAdapter myBagAdapter_delegate$lambda$0() {
        return new MyBagAdapter(R.layout.item_my_bag);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void send$default(MyBagWrapper myBagWrapper, long j, String str, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        myBagWrapper.send(j, str, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit send$lambda$29(MyBagWrapper myBagWrapper, Function0 function0, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            myBagWrapper.getData();
            if (function0 != null) {
                function0.invoke();
            }
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = myBagWrapper.getContext();
            String string = myBagWrapper.getContext().getString(2131954177);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, string, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit send$lambda$30(Function0 function0, MyBagWrapper myBagWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (function0 != null) {
            function0.invoke();
        }
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = myBagWrapper.getContext();
        String string = myBagWrapper.getContext().getString(2131952667);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, string, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit send$lambda$31(MyBagWrapper myBagWrapper, Function0 function0, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            myBagWrapper.getData();
            if (function0 != null) {
                function0.invoke();
            }
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = myBagWrapper.getContext();
            String string = myBagWrapper.getContext().getString(2131954177);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, string, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit send$lambda$32(Function0 function0, MyBagWrapper myBagWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (function0 != null) {
            function0.invoke();
        }
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = myBagWrapper.getContext();
        String string = myBagWrapper.getContext().getString(2131952667);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, string, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final void showEmpty() {
        if (getMyBagAdapter().getData().isEmpty()) {
            this.mDataBinding.emptyTipTextView.setVisibility(0);
        } else {
            this.mDataBinding.emptyTipTextView.setVisibility(8);
        }
    }

    private final void usingBagGoods(final MyBagBean myBagBean) {
        if (this.mType == 1) {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().setHeadWearUsing(myBagBean.getId()), new Function1() { // from class: com.qiahao.nextvideo.ui.store.g1
                public final Object invoke(Object obj) {
                    Unit usingBagGoods$lambda$14;
                    usingBagGoods$lambda$14 = MyBagWrapper.usingBagGoods$lambda$14(MyBagWrapper.this, myBagBean, (ApiResponse) obj);
                    return usingBagGoods$lambda$14;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.h1
                public final Object invoke(Object obj) {
                    Unit usingBagGoods$lambda$15;
                    usingBagGoods$lambda$15 = MyBagWrapper.usingBagGoods$lambda$15(MyBagWrapper.this, (Throwable) obj);
                    return usingBagGoods$lambda$15;
                }
            }, (Function0) null, false, 12, (Object) null), this.baseViewController.getCompositeDisposable());
        } else {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().setPropertyUsing(myBagBean.getId()), new Function1() { // from class: com.qiahao.nextvideo.ui.store.i1
                public final Object invoke(Object obj) {
                    Unit usingBagGoods$lambda$16;
                    usingBagGoods$lambda$16 = MyBagWrapper.usingBagGoods$lambda$16(MyBagWrapper.this, myBagBean, (ApiResponse) obj);
                    return usingBagGoods$lambda$16;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.j1
                public final Object invoke(Object obj) {
                    Unit usingBagGoods$lambda$17;
                    usingBagGoods$lambda$17 = MyBagWrapper.usingBagGoods$lambda$17(MyBagWrapper.this, (Throwable) obj);
                    return usingBagGoods$lambda$17;
                }
            }, (Function0) null, false, 12, (Object) null), this.baseViewController.getCompositeDisposable());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit usingBagGoods$lambda$14(MyBagWrapper myBagWrapper, MyBagBean myBagBean, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            myBagWrapper.getMyBagAdapter().setSelectData(myBagBean);
            UserStore.INSTANCE.getShared().fetchUserDetailInfo(true);
            myBagWrapper.getMyBagAdapter().notifyDataSetChanged();
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, myBagWrapper.getContext(), ResourcesKtxKt.getStringById(myBagWrapper, 2131954176), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        } else {
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, myBagWrapper.getContext(), ResourcesKtxKt.getStringById(myBagWrapper, 2131952667), false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit usingBagGoods$lambda$15(MyBagWrapper myBagWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, myBagWrapper.getContext(), ResourcesKtxKt.getStringById(myBagWrapper, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit usingBagGoods$lambda$16(MyBagWrapper myBagWrapper, MyBagBean myBagBean, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            myBagWrapper.getMyBagAdapter().setSelectData(myBagBean);
            UserStore.INSTANCE.getShared().fetchUserDetailInfo(true);
            myBagWrapper.getMyBagAdapter().notifyDataSetChanged();
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, myBagWrapper.getContext(), ResourcesKtxKt.getStringById(myBagWrapper, 2131954176), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        } else {
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, myBagWrapper.getContext(), ResourcesKtxKt.getStringById(myBagWrapper, 2131952667), false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit usingBagGoods$lambda$17(MyBagWrapper myBagWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, myBagWrapper.getContext(), ResourcesKtxKt.getStringById(myBagWrapper, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public final boolean checkCanSend() {
        Long l;
        MyBagBean selectData = getMyBagAdapter().getSelectData();
        Long l2 = null;
        if (selectData != null) {
            l = Long.valueOf(selectData.getId());
        } else {
            l = null;
        }
        MyBagBean myBagBean = this.bagBean;
        if (myBagBean != null) {
            l2 = Long.valueOf(myBagBean.getId());
        }
        return !Intrinsics.areEqual(l, l2);
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidCancel() {
        ViewController.dismiss$default(this.baseViewController, true, null, 2, null);
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidConfirm(int fromCode, @NotNull final Bundle extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.baseViewController.dismiss(true, new Function0() { // from class: com.qiahao.nextvideo.ui.store.f1
            public final Object invoke() {
                Unit confirmTipViewControllerDidConfirm$lambda$28;
                confirmTipViewControllerDidConfirm$lambda$28 = MyBagWrapper.confirmTipViewControllerDidConfirm$lambda$28(extra, this);
                return confirmTipViewControllerDidConfirm$lambda$28;
            }
        });
    }

    public final void confirmUsing() {
        Long l;
        Long l2;
        MyBagBean myBagBean = this.bagBean;
        if (myBagBean != null) {
            l = Long.valueOf(myBagBean.getId());
        } else {
            l = null;
        }
        MyBagBean selectData = getMyBagAdapter().getSelectData();
        if (selectData != null) {
            l2 = Long.valueOf(selectData.getId());
        } else {
            l2 = null;
        }
        if (Intrinsics.areEqual(l, l2)) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = getContext();
            String string = getContext().getString(2131954393);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, string, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
                return;
            }
            return;
        }
        Serializable serializable = this.bagBean;
        if (serializable != null) {
            ConfirmPreloadModel init = ConfirmPreloadModel.INSTANCE.init(BaseViewControllerKt.getString(this.baseViewController, 2131952356, new Object[0]), BaseViewControllerKt.getString(this.baseViewController, 2131953574, new Object[0]), BaseViewControllerKt.getString(this.baseViewController, 2131952171, new Object[0]));
            Bundle bundle = new Bundle();
            bundle.putSerializable("myBagBean", serializable);
            init.setExtra(bundle);
            BaseViewController baseViewController = this.baseViewController;
            ConfirmTipViewController confirmTipViewController = new ConfirmTipViewController(init, null, 2, null);
            confirmTipViewController.setDelegate(this);
            ViewController.present$default(baseViewController, confirmTipViewController, true, null, 4, null);
        }
    }

    public final void delete(@NotNull MyBagBean data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.mType == 1) {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().deleteHeadWear((int) data.getId()), new Function1() { // from class: com.qiahao.nextvideo.ui.store.k1
                public final Object invoke(Object obj) {
                    Unit delete$lambda$6;
                    delete$lambda$6 = MyBagWrapper.delete$lambda$6(MyBagWrapper.this, (ApiResponse) obj);
                    return delete$lambda$6;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.l1
                public final Object invoke(Object obj) {
                    Unit delete$lambda$7;
                    delete$lambda$7 = MyBagWrapper.delete$lambda$7(MyBagWrapper.this, (Throwable) obj);
                    return delete$lambda$7;
                }
            }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
        } else {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().deleteProperty((int) data.getId()), new Function1() { // from class: com.qiahao.nextvideo.ui.store.n1
                public final Object invoke(Object obj) {
                    Unit delete$lambda$8;
                    delete$lambda$8 = MyBagWrapper.delete$lambda$8(MyBagWrapper.this, (ApiResponse) obj);
                    return delete$lambda$8;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.o1
                public final Object invoke(Object obj) {
                    Unit delete$lambda$9;
                    delete$lambda$9 = MyBagWrapper.delete$lambda$9(MyBagWrapper.this, (Throwable) obj);
                    return delete$lambda$9;
                }
            }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
        }
    }

    @Nullable
    public final MyBagBean getBagBean() {
        return this.bagBean;
    }

    @NotNull
    public final BaseViewController getBaseViewController() {
        return this.baseViewController;
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    public final int getIndexPage() {
        return this.indexPage;
    }

    @NotNull
    public final ViewMyBagBinding getMDataBinding() {
        return this.mDataBinding;
    }

    public final int getMType() {
        return this.mType;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    @Override // vc.e
    public void onLoadMore(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        getData();
    }

    public final void send(long storeId, @NotNull String extraId, @Nullable final Function0<Unit> completion) {
        Intrinsics.checkNotNullParameter(extraId, "extraId");
        if (this.mType == 1) {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().headWearSend(storeId, extraId), new Function1() { // from class: com.qiahao.nextvideo.ui.store.w1
                public final Object invoke(Object obj) {
                    Unit send$lambda$29;
                    send$lambda$29 = MyBagWrapper.send$lambda$29(MyBagWrapper.this, completion, (ApiResponse) obj);
                    return send$lambda$29;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.c1
                public final Object invoke(Object obj) {
                    Unit send$lambda$30;
                    send$lambda$30 = MyBagWrapper.send$lambda$30(completion, this, (Throwable) obj);
                    return send$lambda$30;
                }
            }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
        } else {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().propertySend(storeId, extraId), new Function1() { // from class: com.qiahao.nextvideo.ui.store.d1
                public final Object invoke(Object obj) {
                    Unit send$lambda$31;
                    send$lambda$31 = MyBagWrapper.send$lambda$31(MyBagWrapper.this, completion, (ApiResponse) obj);
                    return send$lambda$31;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.e1
                public final Object invoke(Object obj) {
                    Unit send$lambda$32;
                    send$lambda$32 = MyBagWrapper.send$lambda$32(completion, this, (Throwable) obj);
                    return send$lambda$32;
                }
            }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
        }
    }

    public final void setBagBean(@Nullable MyBagBean myBagBean) {
        this.bagBean = myBagBean;
    }

    public final void setIndexPage(int i) {
        this.indexPage = i;
    }

    public final void setMDataBinding(@NotNull ViewMyBagBinding viewMyBagBinding) {
        Intrinsics.checkNotNullParameter(viewMyBagBinding, "<set-?>");
        this.mDataBinding = viewMyBagBinding;
    }

    public final void setPageSize(int i) {
        this.pageSize = i;
    }
}
