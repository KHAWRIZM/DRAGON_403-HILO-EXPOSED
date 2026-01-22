package com.qiahao.nextvideo.ui.profile.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Checkable;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EditEvent;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.CheckUserInfo;
import com.qiahao.nextvideo.data.model.CountriesResponse;
import com.qiahao.nextvideo.data.model.EditCountryData;
import com.qiahao.nextvideo.databinding.ActivitySelectCountryBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.home.discover.ChangeCountryDialog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u0015\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0013\u0010\u0004R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020!8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R0\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/activity/SelectCountryActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivitySelectCountryBinding;", "<init>", "()V", "Lcom/qiahao/nextvideo/data/model/EditCountryData;", "editCountryData", "Lcom/qiahao/nextvideo/data/model/CheckUserInfo;", "checkUserInfo", "", "changeCountry", "(Lcom/qiahao/nextvideo/data/model/EditCountryData;Lcom/qiahao/nextvideo/data/model/CheckUserInfo;)V", "", "getLayoutResId", "()I", "onInitialize", "checkEditCountry", "(Lcom/qiahao/nextvideo/data/model/EditCountryData;)V", "getData", "onDestroy", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "setCompositeDisposable", "(Lnd/a;)V", "", "isFullUserInfo", "Z", "()Z", "setFullUserInfo", "(Z)V", "Lcom/qiahao/nextvideo/ui/profile/activity/MultiItemCountryAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/profile/activity/MultiItemCountryAdapter;", "mAdapter", "Lkotlin/Function1;", "mListener", "Lkotlin/jvm/functions/Function1;", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSelectCountryActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectCountryActivity.kt\ncom/qiahao/nextvideo/ui/profile/activity/SelectCountryActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,187:1\n61#2,9:188\n167#3,2:197\n1869#4,2:199\n1869#4,2:201\n1869#4,2:203\n*S KotlinDebug\n*F\n+ 1 SelectCountryActivity.kt\ncom/qiahao/nextvideo/ui/profile/activity/SelectCountryActivity\n*L\n63#1:188,9\n60#1:197,2\n155#1:199,2\n161#1:201,2\n167#1:203,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SelectCountryActivity extends HiloBaseBindingActivity<ActivitySelectCountryBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String IS_FULL = "isFull";
    private boolean isFullUserInfo;

    @Nullable
    private Function1<? super EditCountryData, Unit> mListener;

    @NotNull
    private nd.a compositeDisposable = new nd.a();

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.profile.activity.x1
        public final Object invoke() {
            MultiItemCountryAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = SelectCountryActivity.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/activity/SelectCountryActivity$Companion;", "", "<init>", "()V", "IS_FULL", "", "start", "", "context", "Landroid/content/Context;", "isFullUserInfo", "", "(Landroid/content/Context;Ljava/lang/Boolean;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, @Nullable Boolean isFullUserInfo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) SelectCountryActivity.class);
            intent.putExtra(SelectCountryActivity.IS_FULL, isFullUserInfo);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void changeCountry(EditCountryData editCountryData, CheckUserInfo checkUserInfo) {
        ChangeCountryDialog changeCountryDialog = new ChangeCountryDialog(this, editCountryData, checkUserInfo);
        changeCountryDialog.setListener(new SelectCountryActivity$changeCountry$1$1(editCountryData, this, changeCountryDialog));
        changeCountryDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkEditCountry$lambda$5(SelectCountryActivity selectCountryActivity, EditCountryData editCountryData, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        selectCountryActivity.changeCountry(editCountryData, (CheckUserInfo) apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit checkEditCountry$lambda$6(SelectCountryActivity selectCountryActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(selectCountryActivity, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, selectCountryActivity, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$11(SelectCountryActivity selectCountryActivity, ApiResponse apiResponse) {
        List<Country> noCommon;
        List<Country> noCommon2;
        List<Country> recommend;
        List<Country> common;
        List<Country> recommend2;
        List<Country> recommend3;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ArrayList arrayList = new ArrayList();
        CountriesResponse countriesResponse = (CountriesResponse) apiResponse.getData();
        if (countriesResponse != null && (recommend2 = countriesResponse.getRecommend()) != null && (!recommend2.isEmpty())) {
            arrayList.add(new EditCountryData(1, null, ResourcesKtxKt.getStringById(selectCountryActivity, 2131953861), null, 0L, 26, null));
            CountriesResponse countriesResponse2 = (CountriesResponse) apiResponse.getData();
            if (countriesResponse2 != null && (recommend3 = countriesResponse2.getRecommend()) != null) {
                for (Country country : recommend3) {
                    arrayList.add(new EditCountryData(0, country.getShortName(), country.getName(), country.getIcon(), 0L, 16, null));
                }
            }
        }
        CountriesResponse countriesResponse3 = (CountriesResponse) apiResponse.getData();
        if (countriesResponse3 != null && (recommend = countriesResponse3.getRecommend()) != null && (!recommend.isEmpty())) {
            arrayList.add(new EditCountryData(1, null, ResourcesKtxKt.getStringById(selectCountryActivity, 2131952307), null, 0L, 26, null));
            CountriesResponse countriesResponse4 = (CountriesResponse) apiResponse.getData();
            if (countriesResponse4 != null && (common = countriesResponse4.getCommon()) != null) {
                for (Country country2 : common) {
                    arrayList.add(new EditCountryData(0, country2.getShortName(), country2.getName(), country2.getIcon(), 0L, 16, null));
                }
            }
        }
        CountriesResponse countriesResponse5 = (CountriesResponse) apiResponse.getData();
        if (countriesResponse5 != null && (noCommon = countriesResponse5.getNoCommon()) != null && (!noCommon.isEmpty())) {
            arrayList.add(new EditCountryData(1, null, ResourcesKtxKt.getStringById(selectCountryActivity, 2131952003), null, 0L, 26, null));
            CountriesResponse countriesResponse6 = (CountriesResponse) apiResponse.getData();
            if (countriesResponse6 != null && (noCommon2 = countriesResponse6.getNoCommon()) != null) {
                for (Country country3 : noCommon2) {
                    arrayList.add(new EditCountryData(0, country3.getShortName(), country3.getName(), country3.getIcon(), 0L, 16, null));
                }
            }
        }
        selectCountryActivity.getMAdapter().setList(arrayList);
        selectCountryActivity.getBinding().commonIdSwipeRefreshLayout.finishRefresh();
        selectCountryActivity.getBinding().emptyTipTextView.setVisibility(8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$12(SelectCountryActivity selectCountryActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        selectCountryActivity.getBinding().commonIdSwipeRefreshLayout.finishRefresh();
        selectCountryActivity.getBinding().emptyTipTextView.setVisibility(0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MultiItemCountryAdapter mAdapter_delegate$lambda$0() {
        return new MultiItemCountryAdapter(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$1(SelectCountryActivity selectCountryActivity, int i, int i2) {
        LinearLayoutCompat linearLayoutCompat = selectCountryActivity.getBinding().linearLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayoutCompat, "linearLayout");
        linearLayoutCompat.setPadding(0, i, 0, 0);
        ViewKtxKt.setMargin(selectCountryActivity.getBinding().linearLayout, 0, 0, 0, Integer.valueOf(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onInitialize$lambda$3(SelectCountryActivity selectCountryActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        Country countryInfo;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        EditCountryData editCountryData = (EditCountryData) selectCountryActivity.getMAdapter().getData().get(i);
        if (selectCountryActivity.isFullUserInfo) {
            cf.c.c().l(new EditEvent("country", editCountryData));
            selectCountryActivity.finish();
            return;
        }
        String shortName = editCountryData.getShortName();
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null && (countryInfo = user.getCountryInfo()) != null) {
            str = countryInfo.getShortName();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(shortName, str) && editCountryData.getItemType() == 0) {
            selectCountryActivity.checkEditCountry(editCountryData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$4(SelectCountryActivity selectCountryActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        selectCountryActivity.getData();
    }

    public final void checkEditCountry(@NotNull final EditCountryData editCountryData) {
        Intrinsics.checkNotNullParameter(editCountryData, "editCountryData");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().checkEditeUserInfo(), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.v1
            public final Object invoke(Object obj) {
                Unit checkEditCountry$lambda$5;
                checkEditCountry$lambda$5 = SelectCountryActivity.checkEditCountry$lambda$5(SelectCountryActivity.this, editCountryData, (ApiResponse) obj);
                return checkEditCountry$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.w1
            public final Object invoke(Object obj) {
                Unit checkEditCountry$lambda$6;
                checkEditCountry$lambda$6 = SelectCountryActivity.checkEditCountry$lambda$6(SelectCountryActivity.this, (Throwable) obj);
                return checkEditCountry$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    public final void getData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().countries(1), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.t1
            public final Object invoke(Object obj) {
                Unit data$lambda$11;
                data$lambda$11 = SelectCountryActivity.getData$lambda$11(SelectCountryActivity.this, (ApiResponse) obj);
                return data$lambda$11;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.u1
            public final Object invoke(Object obj) {
                Unit data$lambda$12;
                data$lambda$12 = SelectCountryActivity.getData$lambda$12(SelectCountryActivity.this, (Throwable) obj);
                return data$lambda$12;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_select_country;
    }

    @NotNull
    public final MultiItemCountryAdapter getMAdapter() {
        return (MultiItemCountryAdapter) this.mAdapter.getValue();
    }

    @Nullable
    public final Function1<EditCountryData, Unit> getMListener() {
        return this.mListener;
    }

    /* renamed from: isFullUserInfo, reason: from getter */
    public final boolean getIsFullUserInfo() {
        return this.isFullUserInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        this.compositeDisposable.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        this.isFullUserInfo = getIntent().getBooleanExtra(IS_FULL, false);
        LinearLayoutCompat linearLayoutCompat = ((ActivitySelectCountryBinding) getBinding()).linearLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayoutCompat, "linearLayout");
        getStatusBarTopOrBottom(linearLayoutCompat, new Function2() { // from class: com.qiahao.nextvideo.ui.profile.activity.q1
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$1;
                onInitialize$lambda$1 = SelectCountryActivity.onInitialize$lambda$1(SelectCountryActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$1;
            }
        });
        final AppCompatImageView appCompatImageView = ((ActivitySelectCountryBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.SelectCountryActivity$onInitialize$$inlined$singleClick$default$1
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
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.r1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SelectCountryActivity.onInitialize$lambda$3(SelectCountryActivity.this, baseQuickAdapter, view, i);
            }
        });
        ((ActivitySelectCountryBinding) getBinding()).commonIdRecyclerView.setAdapter(getMAdapter());
        ((ActivitySelectCountryBinding) getBinding()).commonIdSwipeRefreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.profile.activity.s1
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                SelectCountryActivity.onInitialize$lambda$4(SelectCountryActivity.this, fVar);
            }
        });
        getData();
    }

    public final void setCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.compositeDisposable = aVar;
    }

    public final void setFullUserInfo(boolean z) {
        this.isFullUserInfo = z;
    }

    public final void setMListener(@Nullable Function1<? super EditCountryData, Unit> function1) {
        this.mListener = function1;
    }
}
