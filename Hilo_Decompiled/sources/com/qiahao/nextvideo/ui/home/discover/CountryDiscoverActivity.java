package com.qiahao.nextvideo.ui.home.discover;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.model.CountriesResponse;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.databinding.ActivityCountryDiscoverBinding;
import com.qiahao.nextvideo.ui.edition.country.CountryCellUIModel;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001$B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u0005J\r\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\u0005J\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u0005J\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0011\u0010\u0005R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR&\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/CountryDiscoverActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityCountryDiscoverBinding;", "Lvc/g;", "<init>", "()V", "", "getLayoutResId", "()I", "", "onInitialize", "initView", "getData", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "onDestroy", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "setCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/nextvideo/ui/home/discover/CountryAdapter;", "mCountryAdapter$delegate", "Lkotlin/Lazy;", "getMCountryAdapter", "()Lcom/qiahao/nextvideo/ui/home/discover/CountryAdapter;", "mCountryAdapter", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/ui/edition/country/CountryCellUIModel;", "Lkotlin/collections/ArrayList;", "countryData", "Ljava/util/ArrayList;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCountryDiscoverActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CountryDiscoverActivity.kt\ncom/qiahao/nextvideo/ui/home/discover/CountryDiscoverActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,109:1\n61#2,9:110\n1563#3:119\n1634#3,3:120\n1563#3:123\n1634#3,3:124\n*S KotlinDebug\n*F\n+ 1 CountryDiscoverActivity.kt\ncom/qiahao/nextvideo/ui/home/discover/CountryDiscoverActivity\n*L\n64#1:110,9\n79#1:119\n79#1:120,3\n82#1:123\n82#1:124,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CountryDiscoverActivity extends HiloBaseBindingActivity<ActivityCountryDiscoverBinding> implements vc.g {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private nd.a compositeDisposable = new nd.a();

    /* renamed from: mCountryAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mCountryAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.discover.o0
        public final Object invoke() {
            CountryAdapter mCountryAdapter_delegate$lambda$0;
            mCountryAdapter_delegate$lambda$0 = CountryDiscoverActivity.mCountryAdapter_delegate$lambda$0();
            return mCountryAdapter_delegate$lambda$0;
        }
    });

    @NotNull
    private ArrayList<CountryCellUIModel> countryData = new ArrayList<>();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/CountryDiscoverActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) CountryDiscoverActivity.class));
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$7(CountryDiscoverActivity countryDiscoverActivity, ApiResponse apiResponse) {
        List<Country> noCommon;
        List<Country> common;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        countryDiscoverActivity.countryData.clear();
        CountriesResponse countriesResponse = (CountriesResponse) apiResponse.getData();
        if (countriesResponse != null && (common = countriesResponse.getCommon()) != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(common, 10));
            Iterator<T> it = common.iterator();
            while (it.hasNext()) {
                arrayList.add(Boolean.valueOf(countryDiscoverActivity.countryData.add(CountryCellUIModel.INSTANCE.init((Country) it.next()))));
            }
        }
        CountriesResponse countriesResponse2 = (CountriesResponse) apiResponse.getData();
        if (countriesResponse2 != null && (noCommon = countriesResponse2.getNoCommon()) != null) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(noCommon, 10));
            Iterator<T> it2 = noCommon.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Boolean.valueOf(countryDiscoverActivity.countryData.add(CountryCellUIModel.INSTANCE.init((Country) it2.next()))));
            }
        }
        Collections.sort(countryDiscoverActivity.countryData, new Comparator() { // from class: com.qiahao.nextvideo.ui.home.discover.q0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int data$lambda$7$lambda$6;
                data$lambda$7$lambda$6 = CountryDiscoverActivity.getData$lambda$7$lambda$6((CountryCellUIModel) obj, (CountryCellUIModel) obj2);
                return data$lambda$7$lambda$6;
            }
        });
        countryDiscoverActivity.getMCountryAdapter().setList(countryDiscoverActivity.countryData);
        countryDiscoverActivity.getBinding().commonIdSwipeRefreshLayout.finishRefresh();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getData$lambda$7$lambda$6(CountryCellUIModel countryCellUIModel, CountryCellUIModel countryCellUIModel2) {
        Collator collator = Collator.getInstance(Locale.ENGLISH);
        return collator.getCollationKey(countryCellUIModel.getName()).compareTo(collator.getCollationKey(countryCellUIModel2.getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$8(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final CountryAdapter getMCountryAdapter() {
        return (CountryAdapter) this.mCountryAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$2(CountryDiscoverActivity countryDiscoverActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        CountryCellUIModel countryCellUIModel = (CountryCellUIModel) countryDiscoverActivity.getMCountryAdapter().getItem(i);
        if (countryCellUIModel.getName().length() > 0) {
            CountryActivity.INSTANCE.start(countryDiscoverActivity, countryCellUIModel.getName(), countryCellUIModel.getShortName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CountryAdapter mCountryAdapter_delegate$lambda$0() {
        return new CountryAdapter(R.layout.item_country);
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    public final void getData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(GroupService.fetchCountries$default(GroupService.INSTANCE.getInstance(), 0, 1, null), new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.m0
            public final Object invoke(Object obj) {
                Unit data$lambda$7;
                data$lambda$7 = CountryDiscoverActivity.getData$lambda$7(CountryDiscoverActivity.this, (ApiResponse) obj);
                return data$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.n0
            public final Object invoke(Object obj) {
                Unit data$lambda$8;
                data$lambda$8 = CountryDiscoverActivity.getData$lambda$8((Throwable) obj);
                return data$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_country_discover;
    }

    public final void initView() {
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        setStatusBarTopOrBottom(toolbar, false);
        RecyclerView recyclerView = getBinding().commonIdRecyclerView;
        recyclerView.setAdapter(getMCountryAdapter());
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 4));
        recyclerView.setHasFixedSize(true);
        getMCountryAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.p0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CountryDiscoverActivity.initView$lambda$2(CountryDiscoverActivity.this, baseQuickAdapter, view, i);
            }
        });
        final AppCompatImageView appCompatImageView = getBinding().backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.CountryDiscoverActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.finish();
                }
            }
        });
        getData();
        getBinding().commonIdSwipeRefreshLayout.setEnableLoadMore(false);
        getBinding().commonIdSwipeRefreshLayout.setEnableRefresh(true);
        getBinding().commonIdSwipeRefreshLayout.setOnRefreshListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        this.compositeDisposable.d();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        getData();
    }

    public final void setCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.compositeDisposable = aVar;
    }
}
