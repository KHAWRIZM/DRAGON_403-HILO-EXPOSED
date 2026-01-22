package com.qiahao.nextvideo.ui.login;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.adapter.IListAdapter;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.CountriesResponse;
import com.qiahao.nextvideo.data.model.SelectCountryData;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.FragmentSelectCountryBinding;
import com.qiahao.nextvideo.databinding.IncludeTitleBinding;
import com.qiahao.nextvideo.ui.cp.SearchUserActivity;
import com.qiahao.nextvideo.utilities.data_utils.CountryUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/ui/login/SelectCountryFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentSelectCountryBinding;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "adapter", "Lcom/qiahao/nextvideo/ui/login/SelectCountryAdapter;", "getAdapter", "()Lcom/qiahao/nextvideo/ui/login/SelectCountryAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "listData", "Lcom/qiahao/base_common/model/BaseListData;", "getListData", "()Lcom/qiahao/base_common/model/BaseListData;", "getLayoutResId", "", "onInitialize", "", "initData", "initRecycleView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSelectCountryFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectCountryFragment.kt\ncom/qiahao/nextvideo/ui/login/SelectCountryFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,151:1\n61#2,9:152\n61#2,9:161\n*S KotlinDebug\n*F\n+ 1 SelectCountryFragment.kt\ncom/qiahao/nextvideo/ui/login/SelectCountryFragment\n*L\n72#1:152,9\n75#1:161,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SelectCountryFragment extends BaseBindingFragment<FragmentSelectCountryBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TYPE = "type";

    @NotNull
    public static final String TYPE_LOGIN = "type_login";

    @NotNull
    public static final String TYPE_VERIFICATION = "type_verification";

    @NotNull
    private String type = "";

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.login.e0
        public final Object invoke() {
            SelectCountryAdapter adapter_delegate$lambda$0;
            adapter_delegate$lambda$0 = SelectCountryFragment.adapter_delegate$lambda$0();
            return adapter_delegate$lambda$0;
        }
    });

    @NotNull
    private final BaseListData listData = new BaseListData();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/login/SelectCountryFragment$Companion;", "", "<init>", "()V", SearchUserActivity.TYPE, "", "TYPE_LOGIN", "TYPE_VERIFICATION", "createFragment", "Lcom/qiahao/nextvideo/ui/login/SelectCountryFragment;", "type", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SelectCountryFragment createFragment(@NotNull String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            SelectCountryFragment selectCountryFragment = new SelectCountryFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            selectCountryFragment.setArguments(bundle);
            return selectCountryFragment;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SelectCountryAdapter adapter_delegate$lambda$0() {
        return new SelectCountryAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initData() {
        io.reactivex.rxjava3.core.i0 j = UserService.fetchCountries$default(UserService.INSTANCE.getShared(), 0, 1, null).j(new pd.o() { // from class: com.qiahao.nextvideo.ui.login.SelectCountryFragment$initData$1
            public final ArrayList<SelectCountryData> apply(ApiResponse<CountriesResponse> apiResponse) {
                List<Country> noCommon;
                List<Country> noCommon2;
                List<Country> common;
                List<Country> common2;
                List<Country> recommend;
                List<Country> recommend2;
                Intrinsics.checkNotNullParameter(apiResponse, "it");
                CountryUtils.INSTANCE.saveCountryList((CountriesResponse) apiResponse.getData());
                ArrayList<SelectCountryData> arrayList = new ArrayList<>();
                CountriesResponse countriesResponse = (CountriesResponse) apiResponse.getData();
                if (countriesResponse != null && (recommend = countriesResponse.getRecommend()) != null && (!recommend.isEmpty())) {
                    arrayList.add(new SelectCountryData(1, new Country((String) null, (String) null, ResourcesKtxKt.getStringById(SelectCountryFragment.this, 2131953861), 0L, (String) null, (String) null, 59, (DefaultConstructorMarker) null)));
                    CountriesResponse countriesResponse2 = (CountriesResponse) apiResponse.getData();
                    if (countriesResponse2 != null && (recommend2 = countriesResponse2.getRecommend()) != null) {
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(recommend2, 10));
                        Iterator<T> it = recommend2.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(Boolean.valueOf(arrayList.add(new SelectCountryData(2, (Country) it.next()))));
                        }
                    }
                }
                CountriesResponse countriesResponse3 = (CountriesResponse) apiResponse.getData();
                if (countriesResponse3 != null && (common = countriesResponse3.getCommon()) != null && (!common.isEmpty())) {
                    arrayList.add(new SelectCountryData(1, new Country((String) null, (String) null, ResourcesKtxKt.getStringById(SelectCountryFragment.this, 2131952307), 0L, (String) null, (String) null, 59, (DefaultConstructorMarker) null)));
                    CountriesResponse countriesResponse4 = (CountriesResponse) apiResponse.getData();
                    if (countriesResponse4 != null && (common2 = countriesResponse4.getCommon()) != null) {
                        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(common2, 10));
                        Iterator<T> it2 = common2.iterator();
                        while (it2.hasNext()) {
                            arrayList3.add(Boolean.valueOf(arrayList.add(new SelectCountryData(2, (Country) it2.next()))));
                        }
                    }
                }
                CountriesResponse countriesResponse5 = (CountriesResponse) apiResponse.getData();
                if (countriesResponse5 != null && (noCommon = countriesResponse5.getNoCommon()) != null && (!noCommon.isEmpty())) {
                    arrayList.add(new SelectCountryData(1, new Country((String) null, (String) null, ResourcesKtxKt.getStringById(SelectCountryFragment.this, 2131952003), 0L, (String) null, (String) null, 59, (DefaultConstructorMarker) null)));
                    CountriesResponse countriesResponse6 = (CountriesResponse) apiResponse.getData();
                    if (countriesResponse6 != null && (noCommon2 = countriesResponse6.getNoCommon()) != null) {
                        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(noCommon2, 10));
                        Iterator<T> it3 = noCommon2.iterator();
                        while (it3.hasNext()) {
                            arrayList4.add(Boolean.valueOf(arrayList.add(new SelectCountryData(2, (Country) it3.next()))));
                        }
                    }
                }
                return arrayList;
            }
        });
        Intrinsics.checkNotNullExpressionValue(j, "map(...)");
        RxUtilsKt.observeOnMainThread$default(j, new Function1() { // from class: com.qiahao.nextvideo.ui.login.c0
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = SelectCountryFragment.initData$lambda$4(SelectCountryFragment.this, (ArrayList) obj);
                return initData$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.login.d0
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = SelectCountryFragment.initData$lambda$5(SelectCountryFragment.this, (Throwable) obj);
                return initData$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(SelectCountryFragment selectCountryFragment, ArrayList arrayList) {
        SmartRefreshLayout smartRefreshLayout;
        Intrinsics.checkNotNullParameter(arrayList, "it");
        selectCountryFragment.getAdapter().setList(arrayList);
        FragmentSelectCountryBinding fragmentSelectCountryBinding = (FragmentSelectCountryBinding) selectCountryFragment.getBinding();
        if (fragmentSelectCountryBinding != null && (smartRefreshLayout = fragmentSelectCountryBinding.refreshLayout) != null) {
            smartRefreshLayout.finishRefresh();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$5(SelectCountryFragment selectCountryFragment, Throwable th) {
        String str;
        SmartRefreshLayout smartRefreshLayout;
        Intrinsics.checkNotNullParameter(th, "it");
        FragmentSelectCountryBinding fragmentSelectCountryBinding = (FragmentSelectCountryBinding) selectCountryFragment.getBinding();
        if (fragmentSelectCountryBinding != null && (smartRefreshLayout = fragmentSelectCountryBinding.refreshLayout) != null) {
            smartRefreshLayout.finishRefresh();
        }
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = selectCountryFragment.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(selectCountryFragment, 2131952667);
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

    private final void initRecycleView() {
        SmartRefreshLayout smartRefreshLayout;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        RecyclerView recyclerView;
        FragmentSelectCountryBinding fragmentSelectCountryBinding = (FragmentSelectCountryBinding) getBinding();
        if (fragmentSelectCountryBinding != null && (recyclerView = fragmentSelectCountryBinding.recyclerView) != null) {
            recyclerView.setAdapter(getAdapter());
        }
        BaseListData baseListData = this.listData;
        FragmentSelectCountryBinding fragmentSelectCountryBinding2 = (FragmentSelectCountryBinding) getBinding();
        SuperStatusView superStatusView2 = null;
        if (fragmentSelectCountryBinding2 != null) {
            smartRefreshLayout = fragmentSelectCountryBinding2.refreshLayout;
        } else {
            smartRefreshLayout = null;
        }
        FragmentSelectCountryBinding fragmentSelectCountryBinding3 = (FragmentSelectCountryBinding) getBinding();
        if (fragmentSelectCountryBinding3 != null) {
            superStatusView2 = fragmentSelectCountryBinding3.statusView;
        }
        baseListData.registerStatusLayoutAndRefreshLayout(smartRefreshLayout, superStatusView2);
        FragmentSelectCountryBinding fragmentSelectCountryBinding4 = (FragmentSelectCountryBinding) getBinding();
        if (fragmentSelectCountryBinding4 != null && (smartRefreshLayout3 = fragmentSelectCountryBinding4.refreshLayout) != null) {
            smartRefreshLayout3.setEnableLoadMore(false);
        }
        FragmentSelectCountryBinding fragmentSelectCountryBinding5 = (FragmentSelectCountryBinding) getBinding();
        if (fragmentSelectCountryBinding5 != null && (smartRefreshLayout2 = fragmentSelectCountryBinding5.refreshLayout) != null) {
            smartRefreshLayout2.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.login.z
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    SelectCountryFragment.initRecycleView$lambda$6(SelectCountryFragment.this, fVar);
                }
            });
        }
        FragmentSelectCountryBinding fragmentSelectCountryBinding6 = (FragmentSelectCountryBinding) getBinding();
        if (fragmentSelectCountryBinding6 != null && (superStatusView = fragmentSelectCountryBinding6.statusView) != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.login.SelectCountryFragment$initRecycleView$2
                public void onRetry(IStatusView statusView, Status status) {
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    SelectCountryFragment.this.initData();
                }
            });
        }
        getAdapter().setOnItemClickListener(new Function3() { // from class: com.qiahao.nextvideo.ui.login.a0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit initRecycleView$lambda$7;
                initRecycleView$lambda$7 = SelectCountryFragment.initRecycleView$lambda$7(SelectCountryFragment.this, (IListAdapter) obj, (View) obj2, ((Integer) obj3).intValue());
                return initRecycleView$lambda$7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecycleView$lambda$6(SelectCountryFragment selectCountryFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        selectCountryFragment.initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initRecycleView$lambda$7(SelectCountryFragment selectCountryFragment, IListAdapter iListAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(iListAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (HiloUtils.INSTANCE.notFastClick()) {
            SelectCountryData selectCountryData = (SelectCountryData) selectCountryFragment.getAdapter().getData().get(i);
            if (selectCountryData.getItemType() == 2) {
                Country country = selectCountryData.getCountry();
                if (country != null) {
                    country.setCountryType(selectCountryFragment.type);
                }
                cf.c.c().l(country);
                selectCountryFragment.getParentFragmentManager().popBackStack();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$1(SelectCountryFragment selectCountryFragment, int i, int i2) {
        SuperStatusView superStatusView;
        IncludeTitleBinding includeTitleBinding;
        View view;
        FragmentSelectCountryBinding fragmentSelectCountryBinding = (FragmentSelectCountryBinding) selectCountryFragment.getBinding();
        if (fragmentSelectCountryBinding != null && (includeTitleBinding = fragmentSelectCountryBinding.titleBar) != null && (view = includeTitleBinding.bar) != null) {
            view.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        }
        if (Intrinsics.areEqual(selectCountryFragment.type, TYPE_LOGIN)) {
            FragmentSelectCountryBinding fragmentSelectCountryBinding2 = (FragmentSelectCountryBinding) selectCountryFragment.getBinding();
            if (fragmentSelectCountryBinding2 != null) {
                superStatusView = fragmentSelectCountryBinding2.statusView;
            } else {
                superStatusView = null;
            }
            ViewKtxKt.setMargin(superStatusView, 0, 0, 0, Integer.valueOf(i2));
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public final SelectCountryAdapter getAdapter() {
        return (SelectCountryAdapter) this.adapter.getValue();
    }

    protected int getLayoutResId() {
        return R.layout.fragment_select_country;
    }

    @NotNull
    public final BaseListData getListData() {
        return this.listData;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public void onInitialize() {
        String str;
        View view;
        final View root;
        IncludeTitleBinding includeTitleBinding;
        final AppCompatImageView appCompatImageView;
        IncludeTitleBinding includeTitleBinding2;
        AppCompatTextView appCompatTextView;
        IncludeTitleBinding includeTitleBinding3;
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("type")) == null) {
            str = "";
        }
        this.type = str;
        FragmentSelectCountryBinding fragmentSelectCountryBinding = (FragmentSelectCountryBinding) getBinding();
        if (fragmentSelectCountryBinding != null && (includeTitleBinding3 = fragmentSelectCountryBinding.titleBar) != null) {
            view = includeTitleBinding3.bar;
        } else {
            view = null;
        }
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.login.b0
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$1;
                onInitialize$lambda$1 = SelectCountryFragment.onInitialize$lambda$1(SelectCountryFragment.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$1;
            }
        });
        FragmentSelectCountryBinding fragmentSelectCountryBinding2 = (FragmentSelectCountryBinding) getBinding();
        if (fragmentSelectCountryBinding2 != null && (includeTitleBinding2 = fragmentSelectCountryBinding2.titleBar) != null && (appCompatTextView = includeTitleBinding2.title) != null) {
            appCompatTextView.setText(ResourcesKtxKt.getStringById(this, 2131952394));
        }
        FragmentSelectCountryBinding fragmentSelectCountryBinding3 = (FragmentSelectCountryBinding) getBinding();
        final long j = 800;
        if (fragmentSelectCountryBinding3 != null && (includeTitleBinding = fragmentSelectCountryBinding3.titleBar) != null && (appCompatImageView = includeTitleBinding.backImageView) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.SelectCountryFragment$onInitialize$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                        AppCompatImageView appCompatImageView2 = appCompatImageView;
                        this.getParentFragmentManager().popBackStack();
                    }
                }
            });
        }
        FragmentSelectCountryBinding fragmentSelectCountryBinding4 = (FragmentSelectCountryBinding) getBinding();
        if (fragmentSelectCountryBinding4 != null && (root = fragmentSelectCountryBinding4.getRoot()) != null) {
            root.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.SelectCountryFragment$onInitialize$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                    }
                }
            });
        }
        initRecycleView();
        initData();
    }

    public final void setType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }
}
