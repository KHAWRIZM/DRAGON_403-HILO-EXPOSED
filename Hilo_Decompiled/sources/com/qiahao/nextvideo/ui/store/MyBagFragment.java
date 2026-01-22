package com.qiahao.nextvideo.ui.store;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.MyBagBean;
import com.qiahao.base_common.model.eventBus.BagEvent;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.ContactsLikeEachItem;
import com.qiahao.nextvideo.databinding.FragmentMyBagBinding;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0007R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/ui/store/MyBagFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentMyBagBinding;", "<init>", "()V", "mViewModel", "Lcom/qiahao/nextvideo/ui/store/MyBagViewModel;", "getMViewModel", "()Lcom/qiahao/nextvideo/ui/store/MyBagViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "myBagAdapter", "Lcom/qiahao/nextvideo/ui/store/MyBagAdapter;", "getMyBagAdapter", "()Lcom/qiahao/nextvideo/ui/store/MyBagAdapter;", "myBagAdapter$delegate", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "onResume", "onBagEvent", "event", "Lcom/qiahao/base_common/model/eventBus/BagEvent;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMyBagFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyBagFragment.kt\ncom/qiahao/nextvideo/ui/store/MyBagFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,158:1\n1#2:159\n1878#3,3:160\n*S KotlinDebug\n*F\n+ 1 MyBagFragment.kt\ncom/qiahao/nextvideo/ui/store/MyBagFragment\n*L\n48#1:160,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MyBagFragment extends BaseBindingFragment<FragmentMyBagBinding> {

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.store.q
        public final Object invoke() {
            MyBagViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = MyBagFragment.mViewModel_delegate$lambda$0();
            return mViewModel_delegate$lambda$0;
        }
    });

    /* renamed from: myBagAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy myBagAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.store.r
        public final Object invoke() {
            MyBagAdapter myBagAdapter_delegate$lambda$1;
            myBagAdapter_delegate$lambda$1 = MyBagFragment.myBagAdapter_delegate$lambda$1();
            return myBagAdapter_delegate$lambda$1;
        }
    });

    private final MyBagAdapter getMyBagAdapter() {
        return (MyBagAdapter) this.myBagAdapter.getValue();
    }

    private final void initData() {
        getMViewModel().getBagList().observe(this, new MyBagFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.store.s
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = MyBagFragment.initData$lambda$3(MyBagFragment.this, (List) obj);
                return initData$lambda$3;
            }
        }));
        getMViewModel().getMException().observe(this, new MyBagFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.store.t
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = MyBagFragment.initData$lambda$4(MyBagFragment.this, (Pair) obj);
                return initData$lambda$4;
            }
        }));
        getMViewModel().getMSuccess().observe(this, new MyBagFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.store.u
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = MyBagFragment.initData$lambda$5(MyBagFragment.this, (Pair) obj);
                return initData$lambda$5;
            }
        }));
        getMViewModel().getList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$3(MyBagFragment myBagFragment, List list) {
        SuperStatusView superStatusView;
        SuperStatusView superStatusView2;
        SmartRefreshLayout smartRefreshLayout;
        FragmentMyBagBinding fragmentMyBagBinding = (FragmentMyBagBinding) myBagFragment.getBinding();
        if (fragmentMyBagBinding != null && (smartRefreshLayout = fragmentMyBagBinding.refreshLayout) != null) {
            smartRefreshLayout.finishRefresh();
        }
        if (list != null && !list.isEmpty()) {
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (((MyBagBean) obj).getUsing()) {
                    myBagFragment.getMyBagAdapter().setSelectData((MyBagBean) list.get(i));
                    myBagFragment.getMViewModel().setMSelectData((MyBagBean) list.get(i));
                }
                i = i2;
            }
            cf.c.c().l(new BagEvent("bag_select", myBagFragment.getMViewModel().getMSelectData()));
            FragmentMyBagBinding fragmentMyBagBinding2 = (FragmentMyBagBinding) myBagFragment.getBinding();
            if (fragmentMyBagBinding2 != null && (superStatusView2 = fragmentMyBagBinding2.statusView) != null) {
                superStatusView2.showContent();
            }
            myBagFragment.getMyBagAdapter().setList(list);
        } else {
            FragmentMyBagBinding fragmentMyBagBinding3 = (FragmentMyBagBinding) myBagFragment.getBinding();
            if (fragmentMyBagBinding3 != null && (superStatusView = fragmentMyBagBinding3.statusView) != null) {
                superStatusView.showEmpty();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
    
        r7 = (com.qiahao.nextvideo.databinding.FragmentMyBagBinding) r7.getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
    
        if (r7 == null) goto L٣٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
    
        r7 = r7.statusView;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
    
        if (r7 == null) goto L٣٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
    
        r7.showEmpty();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001f, code lost:
    
        if (r0.equals(com.qiahao.nextvideo.ui.store.MyBagViewModel.BAG_HEAD) == false) goto L٣٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
    
        if ((r8.getSecond() instanceof com.qiahao.base_common.network.interceptors.HiloException) == false) goto L٣٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
    
        r1 = com.qiahao.base_common.utils.HiloToasty.Companion;
        r2 = r7.getContext();
        r8 = r8.getSecond();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
        r8 = ((com.qiahao.base_common.network.interceptors.HiloException) r8).getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006f, code lost:
    
        if (r8 != null) goto L٣١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0071, code lost:
    
        r3 = com.oudi.utils.ktx.ResourcesKtxKt.getStringById(r7, 2131952667);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007b, code lost:
    
        r7 = com.qiahao.base_common.utils.HiloToasty.Companion.normal$default(r1, r2, r3, false, 4, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0082, code lost:
    
        if (r7 == null) goto L٣٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0084, code lost:
    
        r7.show();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
    
        r3 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0028, code lost:
    
        if (r0.equals(com.qiahao.nextvideo.ui.store.MyBagViewModel.BAG_HEAD_LIST) != false) goto L١٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
    
        if (r0.equals(com.qiahao.nextvideo.ui.store.MyBagViewModel.BAG_MOUNTS) == false) goto L٣٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0015, code lost:
    
        if (r0.equals(com.qiahao.nextvideo.ui.store.MyBagViewModel.BAG_MOUNTS_LIST) == false) goto L٣٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002a, code lost:
    
        r8 = (com.qiahao.nextvideo.databinding.FragmentMyBagBinding) r7.getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0030, code lost:
    
        if (r8 == null) goto L١٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0032, code lost:
    
        r8 = r8.refreshLayout;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
    
        if (r8 == null) goto L١٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
    
        r8.finishRefresh();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit initData$lambda$4(MyBagFragment myBagFragment, Pair pair) {
        String str = (String) pair.getFirst();
        switch (str.hashCode()) {
            case -1068284038:
                break;
            case -219002979:
                break;
            case 3198432:
                break;
            case 2034089539:
                break;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$5(MyBagFragment myBagFragment, Pair pair) {
        Toast normal$default;
        String str = (String) pair.getFirst();
        if ((Intrinsics.areEqual(str, MyBagViewModel.BAG_HEAD) || Intrinsics.areEqual(str, MyBagViewModel.BAG_MOUNTS)) && (normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, myBagFragment.getContext(), ResourcesKtxKt.getStringById(myBagFragment, 2131954177), false, 4, (Object) null)) != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        String str;
        RecyclerView recyclerView;
        SmartRefreshLayout smartRefreshLayout;
        FragmentMyBagBinding fragmentMyBagBinding = (FragmentMyBagBinding) getBinding();
        if (fragmentMyBagBinding != null && (smartRefreshLayout = fragmentMyBagBinding.refreshLayout) != null) {
            smartRefreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.store.v
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    MyBagFragment.initView$lambda$6(MyBagFragment.this, fVar);
                }
            });
        }
        MyBagViewModel mViewModel = getMViewModel();
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("type")) == null) {
            str = MyBagViewModel.BAG_HEAD;
        }
        mViewModel.setMType(str);
        FragmentMyBagBinding fragmentMyBagBinding2 = (FragmentMyBagBinding) getBinding();
        if (fragmentMyBagBinding2 != null && (recyclerView = fragmentMyBagBinding2.recyclerView) != null) {
            recyclerView.setAdapter(getMyBagAdapter());
        }
        getMyBagAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.store.w
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MyBagFragment.initView$lambda$7(MyBagFragment.this, baseQuickAdapter, view, i);
            }
        });
        getMyBagAdapter().addChildClickViewIds(new int[]{2131362625});
        getMyBagAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.store.x
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MyBagFragment.initView$lambda$9(MyBagFragment.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(MyBagFragment myBagFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        myBagFragment.getMViewModel().getList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(MyBagFragment myBagFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        myBagFragment.getMViewModel().setMSelectData((MyBagBean) myBagFragment.getMyBagAdapter().getData().get(i));
        myBagFragment.getMyBagAdapter().setSelectData((MyBagBean) myBagFragment.getMyBagAdapter().getData().get(i));
        myBagFragment.getMyBagAdapter().notifyDataSetChanged();
        cf.c.c().l(new BagEvent("bag_select", myBagFragment.getMViewModel().getMSelectData()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(final MyBagFragment myBagFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (HiloUtils.INSTANCE.notFastClick()) {
            final MyBagBean myBagBean = (MyBagBean) myBagFragment.getMyBagAdapter().getItem(i);
            Context context = myBagFragment.getContext();
            if (context != null) {
                new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(myBagFragment, 2131952335)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.store.MyBagFragment$initView$3$1$1
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                        MyBagFragment.this.getMViewModel().deleteBagGoods(myBagBean);
                    }
                }).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MyBagViewModel mViewModel_delegate$lambda$0() {
        return new MyBagViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MyBagAdapter myBagAdapter_delegate$lambda$1() {
        return new MyBagAdapter(R.layout.item_my_bag);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_my_bag;
    }

    @NotNull
    public final MyBagViewModel getMViewModel() {
        return (MyBagViewModel) this.mViewModel.getValue();
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onBagEvent(@NotNull BagEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String type = event.getType();
        if (Intrinsics.areEqual(type, "bag_use")) {
            if (event.getData() instanceof String) {
                String mType = getMViewModel().getMType();
                Object data = event.getData();
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.String");
                if (!Intrinsics.areEqual(mType, (String) data)) {
                    return;
                }
            }
            Context context = getContext();
            if (context != null) {
                TipDialog tipDialog = new TipDialog(context);
                String string = getString(2131952356);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                tipDialog.setTipContent(string).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.store.MyBagFragment$onBagEvent$1$1
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                        MyBagBean mSelectData = MyBagFragment.this.getMViewModel().getMSelectData();
                        if (mSelectData != null) {
                            MyBagFragment.this.getMViewModel().useBagGoods(mSelectData);
                        }
                    }
                }).show();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(type, "bag_send")) {
            if (event.getData() instanceof ContactsLikeEachItem) {
                String mType2 = getMViewModel().getMType();
                Object data2 = event.getData();
                Intrinsics.checkNotNull(data2, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.ContactsLikeEachItem");
                if (!Intrinsics.areEqual(mType2, ((ContactsLikeEachItem) data2).getType())) {
                    return;
                }
            }
            MyBagBean mSelectData = getMViewModel().getMSelectData();
            if (mSelectData != null) {
                MyBagViewModel mViewModel = getMViewModel();
                long id2 = mSelectData.getId();
                Object data3 = event.getData();
                Intrinsics.checkNotNull(data3, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.ContactsLikeEachItem");
                mViewModel.sendBagGoods(id2, ((ContactsLikeEachItem) data3).getUserBase().getExternalId());
            }
        }
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initData();
    }

    public void onResume() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        if (getMViewModel().getMSelectData() != null) {
            getMyBagAdapter().setSelectData(getMViewModel().getMSelectData());
            getMyBagAdapter().notifyDataSetChanged();
            cf.c.c().l(new BagEvent("bag_select", getMViewModel().getMSelectData()));
        }
    }
}
