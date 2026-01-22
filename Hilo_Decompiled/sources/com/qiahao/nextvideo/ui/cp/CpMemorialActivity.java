package com.qiahao.nextvideo.ui.cp;

import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import com.oudi.adapter.IListAdapter;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.interfaceing.MoreDialogListener;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.cp.CpInfo;
import com.qiahao.base_common.model.cp.CpMemorial;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.cp.CpMemorialData;
import com.qiahao.nextvideo.databinding.ActivityCpMemorialBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpMemorialActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityCpMemorialBinding;", "<init>", "()V", "mAdapter", "Lcom/qiahao/nextvideo/ui/cp/CpMemorialAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/cp/CpMemorialAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/qiahao/nextvideo/ui/cp/CpMemorialViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/cp/CpMemorialViewModel;", "viewModel$delegate", "getLayoutResId", "", "onInitialize", "", "initData", "onResume", "initView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCpMemorialActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpMemorialActivity.kt\ncom/qiahao/nextvideo/ui/cp/CpMemorialActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,144:1\n61#2,9:145\n61#2,9:154\n1563#3:163\n1634#3,3:164\n1563#3:167\n1634#3,3:168\n*S KotlinDebug\n*F\n+ 1 CpMemorialActivity.kt\ncom/qiahao/nextvideo/ui/cp/CpMemorialActivity\n*L\n79#1:145,9\n89#1:154,9\n46#1:163\n46#1:164,3\n48#1:167\n48#1:168,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpMemorialActivity extends HiloBaseBindingActivity<ActivityCpMemorialBinding> {

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.cp.p
        public final Object invoke() {
            CpMemorialAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = CpMemorialActivity.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.cp.q
        public final Object invoke() {
            CpMemorialViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = CpMemorialActivity.viewModel_delegate$lambda$1(CpMemorialActivity.this);
            return viewModel_delegate$lambda$1;
        }
    });

    private final CpMemorialAdapter getMAdapter() {
        return (CpMemorialAdapter) this.mAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CpMemorialViewModel getViewModel() {
        return (CpMemorialViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getCpMemorial().observe(this, new CpMemorialActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.w
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = CpMemorialActivity.initData$lambda$4(CpMemorialActivity.this, (List) obj);
                return initData$lambda$4;
            }
        }));
        getViewModel().getDeleteSuccess().observe(this, new CpMemorialActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.x
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = CpMemorialActivity.initData$lambda$5(CpMemorialActivity.this, (Integer) obj);
                return initData$lambda$5;
            }
        }));
        getViewModel().getError().observe(this, new CpMemorialActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.y
            public final Object invoke(Object obj) {
                Unit initData$lambda$6;
                initData$lambda$6 = CpMemorialActivity.initData$lambda$6(CpMemorialActivity.this, (Throwable) obj);
                return initData$lambda$6;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(CpMemorialActivity cpMemorialActivity, List list) {
        if (cpMemorialActivity.getViewModel().getCpMemorialData().isOnePage()) {
            CpMemorialAdapter mAdapter = cpMemorialActivity.getMAdapter();
            Intrinsics.checkNotNull(list);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CpMemorial cpMemorial = (CpMemorial) it.next();
                arrayList.add(new CpMemorialData(cpMemorial.getType(), cpMemorial));
            }
            mAdapter.setList(arrayList);
        } else {
            CpMemorialAdapter mAdapter2 = cpMemorialActivity.getMAdapter();
            Intrinsics.checkNotNull(list);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                CpMemorial cpMemorial2 = (CpMemorial) it2.next();
                arrayList2.add(new CpMemorialData(cpMemorial2.getType(), cpMemorial2));
            }
            mAdapter2.addData(arrayList2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$5(CpMemorialActivity cpMemorialActivity, Integer num) {
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, cpMemorialActivity, ResourcesKtxKt.getStringById(cpMemorialActivity, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        CpMemorialAdapter mAdapter = cpMemorialActivity.getMAdapter();
        Intrinsics.checkNotNull(num);
        mAdapter.removeAt(num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$6(CpMemorialActivity cpMemorialActivity, Throwable th) {
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(cpMemorialActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, cpMemorialActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        View view = getBinding().titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.cp.r
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$7;
                initView$lambda$7 = CpMemorialActivity.initView$lambda$7(CpMemorialActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$7;
            }
        });
        getBinding().recyclerView.setAdapter(getMAdapter());
        getViewModel().getCpMemorialData().registerStatusLayoutAndRefreshLayout(getBinding().refreshLayout, getBinding().statusView);
        final AppCompatImageView appCompatImageView = getBinding().titleBar.backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpMemorialActivity$initView$$inlined$singleClick$default$1
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
        getBinding().titleBar.title.setText(ResourcesKtxKt.getStringById(this, 2131952424));
        getBinding().refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.cp.s
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                CpMemorialActivity.initView$lambda$9(CpMemorialActivity.this, fVar);
            }
        });
        final ImageView imageView = getBinding().add;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpMemorialActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    CpMemorialEditActivity.INSTANCE.startActivity(this, null);
                }
            }
        });
        getBinding().statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpMemorialActivity$initView$5
            public void onRetry(IStatusView statusView, Status status) {
                CpMemorialViewModel viewModel;
                CpMemorialViewModel viewModel2;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                viewModel = CpMemorialActivity.this.getViewModel();
                viewModel.getCpMemorialData().resetPage();
                viewModel2 = CpMemorialActivity.this.getViewModel();
                viewModel2.m٦٦getCpMemorial();
            }
        });
        getMAdapter().addChildClickViewIds(new int[]{R.id.leftAvatar, R.id.rightAvatar, R.id.addImage});
        getMAdapter().setOnItemChildClickListener(new Function3() { // from class: com.qiahao.nextvideo.ui.cp.t
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit initView$lambda$11;
                initView$lambda$11 = CpMemorialActivity.initView$lambda$11(CpMemorialActivity.this, (IListAdapter) obj, (View) obj2, ((Integer) obj3).intValue());
                return initView$lambda$11;
            }
        });
        getMAdapter().setOnItemClickListener(new Function3() { // from class: com.qiahao.nextvideo.ui.cp.u
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit initView$lambda$12;
                initView$lambda$12 = CpMemorialActivity.initView$lambda$12(CpMemorialActivity.this, (IListAdapter) obj, (View) obj2, ((Integer) obj3).intValue());
                return initView$lambda$12;
            }
        });
        getMAdapter().setOnItemLongClickListener(new Function3() { // from class: com.qiahao.nextvideo.ui.cp.v
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                boolean initView$lambda$13;
                initView$lambda$13 = CpMemorialActivity.initView$lambda$13(CpMemorialActivity.this, (IListAdapter) obj, (View) obj2, ((Integer) obj3).intValue());
                return Boolean.valueOf(initView$lambda$13);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initView$lambda$11(CpMemorialActivity cpMemorialActivity, IListAdapter iListAdapter, View view, int i) {
        CpInfo cpInfo;
        User userInfo;
        String externalId;
        CpInfo cpInfo2;
        User cpUserInfo;
        String externalId2;
        Intrinsics.checkNotNullParameter(iListAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        CpMemorialData cpMemorialData = (CpMemorialData) cpMemorialActivity.getMAdapter().getData().get(i);
        int id2 = view.getId();
        if (id2 != 2131361925) {
            String str = "";
            if (id2 != 2131363432) {
                if (id2 == 2131364631) {
                    BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                    CpMemorial item = cpMemorialData.getItem();
                    if (item != null && (cpInfo2 = item.getCpInfo()) != null && (cpUserInfo = cpInfo2.getCpUserInfo()) != null && (externalId2 = cpUserInfo.getExternalId()) != null) {
                        str = externalId2;
                    }
                    baseControlUtils.openPersonPage(str);
                }
            } else {
                BaseControlUtils baseControlUtils2 = BaseControlUtils.INSTANCE;
                CpMemorial item2 = cpMemorialData.getItem();
                if (item2 != null && (cpInfo = item2.getCpInfo()) != null && (userInfo = cpInfo.getUserInfo()) != null && (externalId = userInfo.getExternalId()) != null) {
                    str = externalId;
                }
                baseControlUtils2.openPersonPage(str);
            }
        } else {
            CpMemorialEditActivity.INSTANCE.startActivity(cpMemorialActivity, cpMemorialData.getItem());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initView$lambda$12(CpMemorialActivity cpMemorialActivity, IListAdapter iListAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(iListAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        CpMemorialData cpMemorialData = (CpMemorialData) cpMemorialActivity.getMAdapter().getData().get(i);
        if (cpMemorialData.getItemType() == 1) {
            return Unit.INSTANCE;
        }
        CpMemorialEditActivity.INSTANCE.startActivity(cpMemorialActivity, cpMemorialData.getItem());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean initView$lambda$13(final CpMemorialActivity cpMemorialActivity, IListAdapter iListAdapter, View view, final int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(iListAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        final CpMemorialData cpMemorialData = (CpMemorialData) cpMemorialActivity.getMAdapter().getData().get(i);
        CpMemorial item = cpMemorialData.getItem();
        if (item != null) {
            z = Intrinsics.areEqual(item.getCanDel(), Boolean.FALSE);
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        new CpDeleteDialog(cpMemorialActivity).setListener(new MoreDialogListener() { // from class: com.qiahao.nextvideo.ui.cp.CpMemorialActivity$initView$8$1
            public void clickType(String type) {
                Intrinsics.checkNotNullParameter(type, "type");
                CpConfirmTwoDialog tipContent = new CpConfirmTwoDialog(CpMemorialActivity.this, false, 2, null).setTipContent(ResourcesKtxKt.getStringById(this, 2131952405));
                final CpMemorialActivity cpMemorialActivity2 = CpMemorialActivity.this;
                final CpMemorialData cpMemorialData2 = cpMemorialData;
                final int i2 = i;
                tipContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.cp.CpMemorialActivity$initView$8$1$clickType$1
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                        CpMemorialViewModel viewModel;
                        int i3;
                        Integer id2;
                        viewModel = CpMemorialActivity.this.getViewModel();
                        CpMemorial item2 = cpMemorialData2.getItem();
                        if (item2 != null && (id2 = item2.getId()) != null) {
                            i3 = id2.intValue();
                        } else {
                            i3 = 0;
                        }
                        viewModel.deleteCpMemorial(i3, i2);
                    }
                }).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131952536)).setCancelContent(ResourcesKtxKt.getStringById(this, 2131952171)).show();
            }
        }).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$7(CpMemorialActivity cpMemorialActivity, int i, int i2) {
        cpMemorialActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(CpMemorialActivity cpMemorialActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        cpMemorialActivity.getViewModel().getCpMemorialData().resetPage();
        cpMemorialActivity.getViewModel().m٦٦getCpMemorial();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CpMemorialAdapter mAdapter_delegate$lambda$0() {
        return new CpMemorialAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CpMemorialViewModel viewModel_delegate$lambda$1(CpMemorialActivity cpMemorialActivity) {
        return new ViewModelProvider(cpMemorialActivity).get(CpMemorialViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_cp_memorial;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onResume() {
        super.onResume();
        getViewModel().m٦٦getCpMemorial();
    }
}
