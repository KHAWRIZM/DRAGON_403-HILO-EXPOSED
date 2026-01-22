package com.qiahao.nextvideo.ui.profile.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.MyBagBean;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.ViewUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.FragmentUserPropsBinding;
import com.qiahao.nextvideo.databinding.FragmentUserPropsHeadBinding;
import com.qiahao.nextvideo.ui.profile.MountsAdapter;
import com.qiahao.nextvideo.ui.profile.UserGiftAdapter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0004R$\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0017\u0010#\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&Rm\u0010.\u001aM\u0012\u0013\u0012\u00110(¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0015\u0012\u0013\u0018\u00010(¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(,\u0012\u0015\u0012\u0013\u0018\u00010(¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u0005\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u00106\u001a\u0004\b<\u0010=¨\u0006?"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/activity/PropsFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentUserPropsBinding;", "<init>", "()V", "", "initView", "getMounts", "getGiftList", "", "getLayoutResId", "()I", "onInitialize", "Lcom/qiahao/base_common/model/common/User;", "user", "refreshView", "(Lcom/qiahao/base_common/model/common/User;)V", "refreshData", "onDestroy", "uiModel", "Lcom/qiahao/base_common/model/common/User;", "getUiModel", "()Lcom/qiahao/base_common/model/common/User;", "setUiModel", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "setCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/nextvideo/databinding/FragmentUserPropsHeadBinding;", "headBinding", "Lcom/qiahao/nextvideo/databinding/FragmentUserPropsHeadBinding;", "Lcom/qiahao/base_common/model/BaseListData;", "baseListData", "Lcom/qiahao/base_common/model/BaseListData;", "getBaseListData", "()Lcom/qiahao/base_common/model/BaseListData;", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "effectUrl", "senderAvatar", "receiverAvatar", "mListener", "Lkotlin/jvm/functions/Function3;", "getMListener", "()Lkotlin/jvm/functions/Function3;", "setMListener", "(Lkotlin/jvm/functions/Function3;)V", "Lcom/qiahao/nextvideo/ui/profile/UserGiftAdapter;", "galleryAdapter$delegate", "Lkotlin/Lazy;", "getGalleryAdapter", "()Lcom/qiahao/nextvideo/ui/profile/UserGiftAdapter;", "galleryAdapter", "Lcom/qiahao/nextvideo/ui/profile/MountsAdapter;", "mountsAdapter$delegate", "getMountsAdapter", "()Lcom/qiahao/nextvideo/ui/profile/MountsAdapter;", "mountsAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPropsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PropsFragment.kt\ncom/qiahao/nextvideo/ui/profile/activity/PropsFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,180:1\n1#2:181\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PropsFragment extends BaseBindingFragment<FragmentUserPropsBinding> {

    @NotNull
    private final BaseListData baseListData;

    @NotNull
    private nd.a compositeDisposable = new nd.a();

    /* renamed from: galleryAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy galleryAdapter;

    @Nullable
    private FragmentUserPropsHeadBinding headBinding;

    @Nullable
    private Function3<? super String, ? super String, ? super String, Unit> mListener;

    /* renamed from: mountsAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mountsAdapter;

    @Nullable
    private User uiModel;

    public PropsFragment() {
        BaseListData baseListData = new BaseListData();
        baseListData.setPageSize(40);
        this.baseListData = baseListData;
        this.galleryAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.profile.activity.o1
            public final Object invoke() {
                UserGiftAdapter galleryAdapter_delegate$lambda$1;
                galleryAdapter_delegate$lambda$1 = PropsFragment.galleryAdapter_delegate$lambda$1();
                return galleryAdapter_delegate$lambda$1;
            }
        });
        this.mountsAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.profile.activity.p1
            public final Object invoke() {
                MountsAdapter mountsAdapter_delegate$lambda$2;
                mountsAdapter_delegate$lambda$2 = PropsFragment.mountsAdapter_delegate$lambda$2();
                return mountsAdapter_delegate$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserGiftAdapter galleryAdapter_delegate$lambda$1() {
        return new UserGiftAdapter();
    }

    private final UserGiftAdapter getGalleryAdapter() {
        return (UserGiftAdapter) this.galleryAdapter.getValue();
    }

    private final void getGiftList() {
        String str;
        UserService shared = UserService.INSTANCE.getShared();
        User user = this.uiModel;
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.fetchReceviedGifts(str, this.baseListData.nextPage(), this.baseListData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.i1
            public final Object invoke(Object obj) {
                Unit giftList$lambda$13;
                giftList$lambda$13 = PropsFragment.getGiftList$lambda$13(PropsFragment.this, (ApiResponse) obj);
                return giftList$lambda$13;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.j1
            public final Object invoke(Object obj) {
                Unit giftList$lambda$14;
                giftList$lambda$14 = PropsFragment.getGiftList$lambda$14(PropsFragment.this, (Throwable) obj);
                return giftList$lambda$14;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGiftList$lambda$13(PropsFragment propsFragment, ApiResponse apiResponse) {
        SmartRefreshLayout smartRefreshLayout;
        List data;
        User user;
        List data2;
        SmartRefreshLayout smartRefreshLayout2;
        int i;
        List data3;
        SmartRefreshLayout smartRefreshLayout3;
        int i2;
        List data4;
        AppCompatTextView appCompatTextView;
        SvipData svip;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout4;
        SmartRefreshLayout smartRefreshLayout5;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        FragmentUserPropsBinding fragmentUserPropsBinding = (FragmentUserPropsBinding) propsFragment.getBinding();
        if (fragmentUserPropsBinding != null && (smartRefreshLayout5 = fragmentUserPropsBinding.refreshLayout) != null) {
            smartRefreshLayout5.finishRefresh();
        }
        FragmentUserPropsBinding fragmentUserPropsBinding2 = (FragmentUserPropsBinding) propsFragment.getBinding();
        if (fragmentUserPropsBinding2 != null && (smartRefreshLayout4 = fragmentUserPropsBinding2.refreshLayout) != null) {
            smartRefreshLayout4.finishLoadMore();
        }
        FragmentUserPropsBinding fragmentUserPropsBinding3 = (FragmentUserPropsBinding) propsFragment.getBinding();
        if (fragmentUserPropsBinding3 != null && (superStatusView = fragmentUserPropsBinding3.statusView) != null) {
            superStatusView.showContent();
        }
        ApiList apiList = (ApiList) apiResponse.getData();
        List list = null;
        boolean z = true;
        if (apiList != null && (data = apiList.getData()) != null && (!data.isEmpty()) && ((user = propsFragment.uiModel) == null || (svip = user.getSvip()) == null || !svip.isHideGift())) {
            FragmentUserPropsHeadBinding fragmentUserPropsHeadBinding = propsFragment.headBinding;
            if (fragmentUserPropsHeadBinding != null && (appCompatTextView = fragmentUserPropsHeadBinding.gift) != null) {
                appCompatTextView.setVisibility(0);
            }
            if (propsFragment.baseListData.isOnePage()) {
                FragmentUserPropsBinding fragmentUserPropsBinding4 = (FragmentUserPropsBinding) propsFragment.getBinding();
                if (fragmentUserPropsBinding4 != null && (smartRefreshLayout3 = fragmentUserPropsBinding4.refreshLayout) != null) {
                    ApiList apiList2 = (ApiList) apiResponse.getData();
                    if (apiList2 != null && (data4 = apiList2.getData()) != null) {
                        i2 = data4.size();
                    } else {
                        i2 = 0;
                    }
                    if (i2 >= propsFragment.baseListData.getPageSize()) {
                        z = false;
                    }
                    smartRefreshLayout3.setNoMoreData(z);
                }
                UserGiftAdapter galleryAdapter = propsFragment.getGalleryAdapter();
                ApiList apiList3 = (ApiList) apiResponse.getData();
                if (apiList3 != null) {
                    list = apiList3.getData();
                }
                galleryAdapter.setList(list);
            } else {
                FragmentUserPropsBinding fragmentUserPropsBinding5 = (FragmentUserPropsBinding) propsFragment.getBinding();
                if (fragmentUserPropsBinding5 != null && (smartRefreshLayout2 = fragmentUserPropsBinding5.refreshLayout) != null) {
                    ApiList apiList4 = (ApiList) apiResponse.getData();
                    if (apiList4 != null && (data3 = apiList4.getData()) != null) {
                        i = data3.size();
                    } else {
                        i = 0;
                    }
                    if (i >= propsFragment.baseListData.getPageSize()) {
                        z = false;
                    }
                    smartRefreshLayout2.setNoMoreData(z);
                }
                ApiList apiList5 = (ApiList) apiResponse.getData();
                if (apiList5 != null && (data2 = apiList5.getData()) != null) {
                    propsFragment.getGalleryAdapter().addData(data2);
                }
            }
        } else {
            FragmentUserPropsBinding fragmentUserPropsBinding6 = (FragmentUserPropsBinding) propsFragment.getBinding();
            if (fragmentUserPropsBinding6 != null && (smartRefreshLayout = fragmentUserPropsBinding6.refreshLayout) != null) {
                smartRefreshLayout.setNoMoreData(true);
            }
            propsFragment.getGalleryAdapter().setList((Collection) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGiftList$lambda$14(PropsFragment propsFragment, Throwable th) {
        SmartRefreshLayout smartRefreshLayout;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        Intrinsics.checkNotNullParameter(th, "it");
        FragmentUserPropsBinding fragmentUserPropsBinding = (FragmentUserPropsBinding) propsFragment.getBinding();
        if (fragmentUserPropsBinding != null && (smartRefreshLayout3 = fragmentUserPropsBinding.refreshLayout) != null) {
            smartRefreshLayout3.finishRefresh();
        }
        FragmentUserPropsBinding fragmentUserPropsBinding2 = (FragmentUserPropsBinding) propsFragment.getBinding();
        if (fragmentUserPropsBinding2 != null && (smartRefreshLayout2 = fragmentUserPropsBinding2.refreshLayout) != null) {
            smartRefreshLayout2.finishLoadMore();
        }
        FragmentUserPropsBinding fragmentUserPropsBinding3 = (FragmentUserPropsBinding) propsFragment.getBinding();
        if (fragmentUserPropsBinding3 != null && (superStatusView = fragmentUserPropsBinding3.statusView) != null) {
            superStatusView.showContent();
        }
        if (propsFragment.baseListData.isOnePage()) {
            FragmentUserPropsBinding fragmentUserPropsBinding4 = (FragmentUserPropsBinding) propsFragment.getBinding();
            if (fragmentUserPropsBinding4 != null && (smartRefreshLayout = fragmentUserPropsBinding4.refreshLayout) != null) {
                smartRefreshLayout.setNoMoreData(true);
            }
            propsFragment.getGalleryAdapter().setList((Collection) null);
        }
        return Unit.INSTANCE;
    }

    private final void getMounts() {
        String str;
        UserService shared = UserService.INSTANCE.getShared();
        User user = this.uiModel;
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.getMyProperty(str), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.m1
            public final Object invoke(Object obj) {
                Unit mounts$lambda$10;
                mounts$lambda$10 = PropsFragment.getMounts$lambda$10(PropsFragment.this, (ApiResponse) obj);
                return mounts$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.n1
            public final Object invoke(Object obj) {
                Unit mounts$lambda$11;
                mounts$lambda$11 = PropsFragment.getMounts$lambda$11(PropsFragment.this, (Throwable) obj);
                return mounts$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMounts$lambda$10(PropsFragment propsFragment, ApiResponse apiResponse) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Collection collection = (Collection) apiResponse.getData();
        if (collection != null && !collection.isEmpty()) {
            FragmentUserPropsHeadBinding fragmentUserPropsHeadBinding = propsFragment.headBinding;
            if (fragmentUserPropsHeadBinding != null && (linearLayout2 = fragmentUserPropsHeadBinding.llMounts) != null) {
                linearLayout2.setVisibility(0);
            }
            propsFragment.getMountsAdapter().setList((Collection) apiResponse.getData());
        } else {
            FragmentUserPropsHeadBinding fragmentUserPropsHeadBinding2 = propsFragment.headBinding;
            if (fragmentUserPropsHeadBinding2 != null && (linearLayout = fragmentUserPropsHeadBinding2.llMounts) != null) {
                linearLayout.setVisibility(8);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMounts$lambda$11(PropsFragment propsFragment, Throwable th) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(th, "it");
        FragmentUserPropsHeadBinding fragmentUserPropsHeadBinding = propsFragment.headBinding;
        if (fragmentUserPropsHeadBinding != null && (linearLayout = fragmentUserPropsHeadBinding.llMounts) != null) {
            linearLayout.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    private final MountsAdapter getMountsAdapter() {
        return (MountsAdapter) this.mountsAdapter.getValue();
    }

    private final void initView() {
        User user;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        SmartRefreshLayout smartRefreshLayout;
        RecyclerView recyclerView3;
        View root;
        SmartRefreshLayout smartRefreshLayout2;
        Bundle arguments = getArguments();
        if (arguments != null) {
            user = (User) arguments.getParcelable("user");
        } else {
            user = null;
        }
        this.uiModel = user;
        this.headBinding = (FragmentUserPropsHeadBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.fragment_user_props_head, (ViewGroup) null, false);
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            FragmentUserPropsBinding fragmentUserPropsBinding = (FragmentUserPropsBinding) getBinding();
            if (fragmentUserPropsBinding != null && (smartRefreshLayout2 = fragmentUserPropsBinding.refreshLayout) != null) {
                smartRefreshLayout2.setRefreshFooter(footLoading);
            }
        }
        FragmentUserPropsHeadBinding fragmentUserPropsHeadBinding = this.headBinding;
        if (fragmentUserPropsHeadBinding != null && (root = fragmentUserPropsHeadBinding.getRoot()) != null) {
            BaseQuickAdapter.setHeaderView$default(getGalleryAdapter(), root, 0, 0, 6, (Object) null);
        }
        FragmentUserPropsBinding fragmentUserPropsBinding2 = (FragmentUserPropsBinding) getBinding();
        if (fragmentUserPropsBinding2 != null && (recyclerView3 = fragmentUserPropsBinding2.giftsRecyclerView) != null) {
            recyclerView3.setLayoutManager(new GridLayoutManager(recyclerView3.getContext(), 4, 1, false));
            recyclerView3.setHasFixedSize(true);
            recyclerView3.setAdapter(getGalleryAdapter());
        }
        FragmentUserPropsBinding fragmentUserPropsBinding3 = (FragmentUserPropsBinding) getBinding();
        if (fragmentUserPropsBinding3 != null && (smartRefreshLayout = fragmentUserPropsBinding3.refreshLayout) != null) {
            smartRefreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.profile.activity.k1
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    PropsFragment.initView$lambda$7(PropsFragment.this, fVar);
                }
            });
        }
        FragmentUserPropsHeadBinding fragmentUserPropsHeadBinding2 = this.headBinding;
        if (fragmentUserPropsHeadBinding2 != null && (recyclerView2 = fragmentUserPropsHeadBinding2.mountsRecyclerView) != null) {
            ViewUtilsKt.addItemDecoration(recyclerView2, 0.0f, 5.0f);
        }
        FragmentUserPropsHeadBinding fragmentUserPropsHeadBinding3 = this.headBinding;
        if (fragmentUserPropsHeadBinding3 != null && (recyclerView = fragmentUserPropsHeadBinding3.mountsRecyclerView) != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 4, 1, false));
            recyclerView.setHasFixedSize(true);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setAdapter(getMountsAdapter());
        }
        getMountsAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.l1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PropsFragment.initView$lambda$9(PropsFragment.this, baseQuickAdapter, view, i);
            }
        });
        refreshView(this.uiModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(PropsFragment propsFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        propsFragment.getGiftList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(PropsFragment propsFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Function3<? super String, ? super String, ? super String, Unit> function3;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.base_common.model.MyBagBean");
        MyBagBean myBagBean = (MyBagBean) item;
        if (myBagBean.getTimeLeft() > 0 && (function3 = propsFragment.mListener) != null) {
            function3.invoke(myBagBean.getEffectUrl(), myBagBean.getSenderAvatar(), myBagBean.getReceiverAvatar());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MountsAdapter mountsAdapter_delegate$lambda$2() {
        return new MountsAdapter(R.layout.item_mounts);
    }

    @NotNull
    public final BaseListData getBaseListData() {
        return this.baseListData;
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    protected int getLayoutResId() {
        return R.layout.fragment_user_props;
    }

    @Nullable
    public final Function3<String, String, String, Unit> getMListener() {
        return this.mListener;
    }

    @Nullable
    public final User getUiModel() {
        return this.uiModel;
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        this.compositeDisposable.d();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        getMounts();
        getGiftList();
    }

    public final void refreshData() {
        this.baseListData.resetPage();
        getMounts();
        getGiftList();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if (r4.isHideGift() == true) goto L١٧;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void refreshView(@Nullable User user) {
        int i;
        AppCompatTextView appCompatTextView;
        LinearLayoutCompat linearLayoutCompat;
        boolean z;
        AppCompatTextView appCompatTextView2;
        LinearLayoutCompat linearLayoutCompat2;
        AppCompatTextView appCompatTextView3;
        LinearLayoutCompat linearLayoutCompat3;
        SvipData svip;
        this.uiModel = user;
        if (user != null && (svip = user.getSvip()) != null) {
            i = svip.getSvipLevel();
        } else {
            i = 0;
        }
        if (i > 0) {
            if (user != null && (r4 = user.getSvip()) != null) {
                z = true;
            }
            z = false;
            if (z) {
                FragmentUserPropsHeadBinding fragmentUserPropsHeadBinding = this.headBinding;
                if (fragmentUserPropsHeadBinding != null && (linearLayoutCompat3 = fragmentUserPropsHeadBinding.hideGiftLayout) != null) {
                    linearLayoutCompat3.setVisibility(0);
                }
                FragmentUserPropsHeadBinding fragmentUserPropsHeadBinding2 = this.headBinding;
                if (fragmentUserPropsHeadBinding2 != null && (appCompatTextView3 = fragmentUserPropsHeadBinding2.gift) != null) {
                    appCompatTextView3.setVisibility(0);
                }
                getGalleryAdapter().setList((Collection) null);
                return;
            }
            FragmentUserPropsHeadBinding fragmentUserPropsHeadBinding3 = this.headBinding;
            if (fragmentUserPropsHeadBinding3 != null && (linearLayoutCompat2 = fragmentUserPropsHeadBinding3.hideGiftLayout) != null) {
                linearLayoutCompat2.setVisibility(8);
            }
            FragmentUserPropsHeadBinding fragmentUserPropsHeadBinding4 = this.headBinding;
            if (fragmentUserPropsHeadBinding4 != null && (appCompatTextView2 = fragmentUserPropsHeadBinding4.gift) != null) {
                appCompatTextView2.setVisibility(8);
                return;
            }
            return;
        }
        FragmentUserPropsHeadBinding fragmentUserPropsHeadBinding5 = this.headBinding;
        if (fragmentUserPropsHeadBinding5 != null && (linearLayoutCompat = fragmentUserPropsHeadBinding5.hideGiftLayout) != null) {
            linearLayoutCompat.setVisibility(8);
        }
        FragmentUserPropsHeadBinding fragmentUserPropsHeadBinding6 = this.headBinding;
        if (fragmentUserPropsHeadBinding6 != null && (appCompatTextView = fragmentUserPropsHeadBinding6.gift) != null) {
            appCompatTextView.setVisibility(8);
        }
    }

    public final void setCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.compositeDisposable = aVar;
    }

    public final void setMListener(@Nullable Function3<? super String, ? super String, ? super String, Unit> function3) {
        this.mListener = function3;
    }

    public final void setUiModel(@Nullable User user) {
        this.uiModel = user;
    }
}
