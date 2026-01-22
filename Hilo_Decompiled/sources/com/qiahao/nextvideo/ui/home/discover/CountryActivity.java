package com.qiahao.nextvideo.ui.home.discover;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.MedalInfo;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.CountryTop3ContributeAllBean;
import com.qiahao.nextvideo.data.model.CountryTop3ContributeBean;
import com.qiahao.nextvideo.data.model.HotGroupBean;
import com.qiahao.nextvideo.data.model.HotGroupListBean;
import com.qiahao.nextvideo.data.model.UserSummaryInfo;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ActivityCountryBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.manager.GroupEvent;
import com.qiahao.nextvideo.ui.rank.MedalGridLayout;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\r\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0004J\u0015\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0018\u0010\u0004R\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001f\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R2\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00120#j\b\u0012\u0004\u0012\u00020\u0012`$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010+\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u0010\fR\u001b\u00105\u001a\u0002008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/CountryActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityCountryBinding;", "<init>", "()V", "", "initData", "initView", "getCountryTop3User", "", SupportGiftRankActivity.EXTERNAL_ID, "openUserProfile", "(Ljava/lang/String;)V", "", "getLayoutResId", "()I", "onInitialize", "getCountryList", "Lcom/qiahao/nextvideo/data/model/CountryTop3ContributeBean;", "countryTop3ContributeBean", "showAvatar1", "(Lcom/qiahao/nextvideo/data/model/CountryTop3ContributeBean;)V", "showAvatar2", "showAvatar3", "onDestroy", "Lcom/qiahao/base_common/model/BaseListData;", "baseData", "Lcom/qiahao/base_common/model/BaseListData;", "getBaseData", "()Lcom/qiahao/base_common/model/BaseListData;", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "Ljava/util/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", CountryActivity.COUNTRY_SHORT, "Ljava/lang/String;", "getShortName", "()Ljava/lang/String;", "setShortName", "Lcom/qiahao/nextvideo/ui/home/discover/CountryGroupAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/home/discover/CountryGroupAdapter;", "mAdapter", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCountryActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CountryActivity.kt\ncom/qiahao/nextvideo/ui/home/discover/CountryActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,494:1\n61#2,9:495\n61#2,9:504\n61#2,9:513\n61#2,9:522\n61#2,9:531\n1869#3,2:540\n*S KotlinDebug\n*F\n+ 1 CountryActivity.kt\ncom/qiahao/nextvideo/ui/home/discover/CountryActivity\n*L\n111#1:495,9\n114#1:504,9\n245#1:513,9\n317#1:522,9\n400#1:531,9\n177#1:540,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CountryActivity extends HiloBaseBindingActivity<ActivityCountryBinding> {

    @NotNull
    public static final String COUNTRY_SHORT = "shortName";

    @NotNull
    public static final String COUNTRY_TITLE = "title";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final BaseListData baseData;

    @NotNull
    private final nd.a compositeDisposable;

    @NotNull
    private ArrayList<CountryTop3ContributeBean> list;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    @NotNull
    private String shortName;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/CountryActivity$Companion;", "", "<init>", "()V", "COUNTRY_TITLE", "", "COUNTRY_SHORT", "start", "", "context", "Landroid/content/Context;", "title", CountryActivity.COUNTRY_SHORT, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str = "";
            }
            if ((i & 4) != 0) {
                str2 = "";
            }
            companion.start(context, str, str2);
        }

        @JvmStatic
        public final void start(@NotNull Context context, @Nullable String title, @Nullable String shortName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) CountryActivity.class);
            intent.putExtra("title", title);
            intent.putExtra(CountryActivity.COUNTRY_SHORT, shortName);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    public CountryActivity() {
        BaseListData baseListData = new BaseListData();
        baseListData.setPageSize(20);
        this.baseData = baseListData;
        this.compositeDisposable = new nd.a();
        this.list = new ArrayList<>();
        this.shortName = "";
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.discover.f0
            public final Object invoke() {
                CountryGroupAdapter mAdapter_delegate$lambda$1;
                mAdapter_delegate$lambda$1 = CountryActivity.mAdapter_delegate$lambda$1();
                return mAdapter_delegate$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCountryList$lambda$10(CountryActivity countryActivity, ApiResponse apiResponse) {
        List<HotGroupBean> list;
        List<HotGroupBean> data;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        BaseListData baseListData = countryActivity.baseData;
        HotGroupListBean hotGroupListBean = (HotGroupListBean) apiResponse.getData();
        if (hotGroupListBean != null) {
            list = hotGroupListBean.getData();
        } else {
            list = null;
        }
        baseListData.setList(list);
        ArrayList arrayList = new ArrayList();
        ArrayList<String> blockRoomIdList = GroupService.INSTANCE.getInstance().getBlockRoomIdList();
        if (blockRoomIdList == null) {
            blockRoomIdList = new ArrayList<>();
        }
        HotGroupListBean hotGroupListBean2 = (HotGroupListBean) apiResponse.getData();
        if (hotGroupListBean2 != null && (data = hotGroupListBean2.getData()) != null) {
            for (HotGroupBean hotGroupBean : data) {
                if (!blockRoomIdList.contains(hotGroupBean.getGroupId())) {
                    arrayList.add(hotGroupBean);
                }
            }
        }
        if (countryActivity.baseData.isOnePage()) {
            if (arrayList.isEmpty()) {
                countryActivity.getBinding().statusView.showEmpty();
            } else {
                countryActivity.getBinding().statusView.showContent();
            }
            countryActivity.getMAdapter().setList(arrayList);
        } else {
            countryActivity.getMAdapter().addData(arrayList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCountryList$lambda$11(CountryActivity countryActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        countryActivity.baseData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCountryTop3User() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getCountryTop3Contribute(this.shortName), new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.d0
            public final Object invoke(Object obj) {
                Unit countryTop3User$lambda$12;
                countryTop3User$lambda$12 = CountryActivity.getCountryTop3User$lambda$12(CountryActivity.this, (ApiResponse) obj);
                return countryTop3User$lambda$12;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.e0
            public final Object invoke(Object obj) {
                Unit countryTop3User$lambda$13;
                countryTop3User$lambda$13 = CountryActivity.getCountryTop3User$lambda$13(CountryActivity.this, (Throwable) obj);
                return countryTop3User$lambda$13;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCountryTop3User$lambda$12(CountryActivity countryActivity, ApiResponse apiResponse) {
        int i;
        int i2;
        List<CountryTop3ContributeBean> userDiamond;
        List<CountryTop3ContributeBean> userDiamond2;
        CountryTop3ContributeBean countryTop3ContributeBean;
        List<CountryTop3ContributeBean> userDiamond3;
        List<CountryTop3ContributeBean> userDiamond4;
        List<CountryTop3ContributeBean> arrayList;
        CountryTop3ContributeBean countryTop3ContributeBean2;
        List<CountryTop3ContributeBean> userDiamond5;
        List<CountryTop3ContributeBean> userDiamond6;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        countryActivity.list.clear();
        countryActivity.getBinding().llTop1.setVisibility(8);
        countryActivity.getBinding().llTop2.setVisibility(8);
        countryActivity.getBinding().llTop3.setVisibility(8);
        CountryTop3ContributeAllBean countryTop3ContributeAllBean = (CountryTop3ContributeAllBean) apiResponse.getData();
        int i3 = 0;
        if (countryTop3ContributeAllBean != null && (userDiamond6 = countryTop3ContributeAllBean.getUserDiamond()) != null) {
            i = userDiamond6.size();
        } else {
            i = 0;
        }
        CountryTop3ContributeBean countryTop3ContributeBean3 = null;
        if (i > 0) {
            ArrayList<CountryTop3ContributeBean> arrayList2 = countryActivity.list;
            CountryTop3ContributeAllBean countryTop3ContributeAllBean2 = (CountryTop3ContributeAllBean) apiResponse.getData();
            if (countryTop3ContributeAllBean2 == null || (arrayList = countryTop3ContributeAllBean2.getUserDiamond()) == null) {
                arrayList = new ArrayList<>();
            }
            arrayList2.addAll(arrayList);
            CountryTop3ContributeAllBean countryTop3ContributeAllBean3 = (CountryTop3ContributeAllBean) apiResponse.getData();
            if (countryTop3ContributeAllBean3 != null && (userDiamond5 = countryTop3ContributeAllBean3.getUserDiamond()) != null) {
                countryTop3ContributeBean2 = userDiamond5.get(0);
            } else {
                countryTop3ContributeBean2 = null;
            }
            Intrinsics.checkNotNull(countryTop3ContributeBean2);
            countryActivity.showAvatar1(countryTop3ContributeBean2);
        }
        CountryTop3ContributeAllBean countryTop3ContributeAllBean4 = (CountryTop3ContributeAllBean) apiResponse.getData();
        if (countryTop3ContributeAllBean4 != null && (userDiamond4 = countryTop3ContributeAllBean4.getUserDiamond()) != null) {
            i2 = userDiamond4.size();
        } else {
            i2 = 0;
        }
        if (i2 > 1) {
            CountryTop3ContributeAllBean countryTop3ContributeAllBean5 = (CountryTop3ContributeAllBean) apiResponse.getData();
            if (countryTop3ContributeAllBean5 != null && (userDiamond3 = countryTop3ContributeAllBean5.getUserDiamond()) != null) {
                countryTop3ContributeBean = userDiamond3.get(1);
            } else {
                countryTop3ContributeBean = null;
            }
            Intrinsics.checkNotNull(countryTop3ContributeBean);
            countryActivity.showAvatar2(countryTop3ContributeBean);
        }
        CountryTop3ContributeAllBean countryTop3ContributeAllBean6 = (CountryTop3ContributeAllBean) apiResponse.getData();
        if (countryTop3ContributeAllBean6 != null && (userDiamond2 = countryTop3ContributeAllBean6.getUserDiamond()) != null) {
            i3 = userDiamond2.size();
        }
        if (i3 > 2) {
            CountryTop3ContributeAllBean countryTop3ContributeAllBean7 = (CountryTop3ContributeAllBean) apiResponse.getData();
            if (countryTop3ContributeAllBean7 != null && (userDiamond = countryTop3ContributeAllBean7.getUserDiamond()) != null) {
                countryTop3ContributeBean3 = userDiamond.get(2);
            }
            Intrinsics.checkNotNull(countryTop3ContributeBean3);
            countryActivity.showAvatar3(countryTop3ContributeBean3);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCountryTop3User$lambda$13(CountryActivity countryActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        countryActivity.getBinding().llTop1.setVisibility(8);
        countryActivity.getBinding().llTop2.setVisibility(8);
        countryActivity.getBinding().llTop3.setVisibility(8);
        return Unit.INSTANCE;
    }

    private final void initData() {
        getCountryList();
        getCountryTop3User();
        nd.c l = GroupService.INSTANCE.getMGroupEventProcessorObservable().l(new pd.g() { // from class: com.qiahao.nextvideo.ui.home.discover.CountryActivity$initData$1
            public final void accept(GroupEvent groupEvent) {
                ActivityCountryBinding binding;
                ActivityCountryBinding binding2;
                Intrinsics.checkNotNullParameter(groupEvent, "it");
                if (groupEvent.getMEventId() == 14) {
                    int i = 0;
                    int i2 = -1;
                    for (T t : CountryActivity.this.getMAdapter().getData()) {
                        int i3 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (Intrinsics.areEqual(((HotGroupBean) t).getGroupId(), groupEvent.getMGroupId())) {
                            i2 = i;
                        }
                        i = i3;
                    }
                    if (i2 != -1) {
                        CountryActivity.this.getMAdapter().removeAt(i2);
                    }
                    if (CountryActivity.this.getMAdapter().getData().isEmpty()) {
                        binding2 = CountryActivity.this.getBinding();
                        binding2.statusView.showEmpty();
                    } else {
                        binding = CountryActivity.this.getBinding();
                        binding.statusView.showContent();
                    }
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(l, "subscribe(...)");
        RxUtilsKt.addTo(l, this.compositeDisposable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        Toolbar toolbar = ((ActivityCountryBinding) getBinding()).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        setStatusBarTopOrBottom(toolbar, false);
        setStatusBarIconColor(false);
        AppCompatTextView appCompatTextView = ((ActivityCountryBinding) getBinding()).title;
        String stringExtra = getIntent().getStringExtra("title");
        String str = "";
        if (stringExtra == null) {
            stringExtra = "";
        }
        appCompatTextView.setText(stringExtra);
        String stringExtra2 = getIntent().getStringExtra(COUNTRY_SHORT);
        if (stringExtra2 != null) {
            str = stringExtra2;
        }
        this.shortName = str;
        final AppCompatImageView appCompatImageView = ((ActivityCountryBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.CountryActivity$initView$$inlined$singleClick$default$1
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
        final ImageView imageView = ((ActivityCountryBinding) getBinding()).icQuestion;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.CountryActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    new TipDialog(this).setTipContent(ResourcesKtxKt.getStringById(this, 2131953827)).hideCancel(true).show();
                }
            }
        });
        SmartRefreshLayout smartRefreshLayout = ((ActivityCountryBinding) getBinding()).commonIdSwipeRefreshLayout;
        FootLoading footLoading = new FootLoading((Context) this);
        footLoading.setRootBackgroundColor(2131101214);
        smartRefreshLayout.setRefreshFooter(footLoading);
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.i0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CountryActivity.initView$lambda$5(baseQuickAdapter, view, i);
            }
        });
        getMAdapter().setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.j0
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                boolean initView$lambda$6;
                initView$lambda$6 = CountryActivity.initView$lambda$6(CountryActivity.this, baseQuickAdapter, view, i);
                return initView$lambda$6;
            }
        });
        ((ActivityCountryBinding) getBinding()).commonIdRecyclerView.setAdapter(getMAdapter());
        this.baseData.registerStatusLayoutAndRefreshLayout(((ActivityCountryBinding) getBinding()).commonIdSwipeRefreshLayout, ((ActivityCountryBinding) getBinding()).statusView);
        ((ActivityCountryBinding) getBinding()).commonIdSwipeRefreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.home.discover.k0
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                CountryActivity.initView$lambda$7(CountryActivity.this, fVar);
            }
        });
        ((ActivityCountryBinding) getBinding()).commonIdSwipeRefreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.home.discover.l0
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                CountryActivity.initView$lambda$8(CountryActivity.this, fVar);
            }
        });
        ((ActivityCountryBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.CountryActivity$initView$8
            public void onRetry(IStatusView statusView, Status status) {
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                CountryActivity.this.getBaseData().resetPage();
                CountryActivity.this.getCountryList();
                CountryActivity.this.getCountryTop3User();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            Object item = baseQuickAdapter.getItem(i);
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.HotGroupBean");
            HotGroupBean hotGroupBean = (HotGroupBean) item;
            StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, hotGroupBean.getGroupId(), hotGroupBean.getCode(), hotGroupBean.getFaceUrl(), hotGroupBean.getName(), Boolean.valueOf(hotGroupBean.getHasPassWord()), hotGroupBean.getCountryIcon(), hotGroupBean.getIntroduction(), hotGroupBean.getNotification(), 0, 0, null, 0, false, 7936, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$6(CountryActivity countryActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        AppRequestUtils.roomReportOrBlack$default(AppRequestUtils.INSTANCE, ((HotGroupBean) countryActivity.getMAdapter().getData().get(i)).getGroupId(), null, null, 6, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(CountryActivity countryActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        countryActivity.baseData.resetPage();
        countryActivity.getCountryList();
        countryActivity.getCountryTop3User();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(CountryActivity countryActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        countryActivity.getCountryList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CountryGroupAdapter mAdapter_delegate$lambda$1() {
        return new CountryGroupAdapter(R.layout.item_group_popular1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openUserProfile(String externalId) {
        AppService service;
        if (UserStore.INSTANCE.getShared().checkSvipAndWealth() && (service = AppController.INSTANCE.getService()) != null) {
            service.openPersonPage(externalId);
        }
    }

    @JvmStatic
    public static final void start(@NotNull Context context, @Nullable String str, @Nullable String str2) {
        INSTANCE.start(context, str, str2);
    }

    @NotNull
    public final BaseListData getBaseData() {
        return this.baseData;
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    public final void getCountryList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().getCountryGroup(this.shortName, this.baseData.nextPage(), this.baseData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.g0
            public final Object invoke(Object obj) {
                Unit countryList$lambda$10;
                countryList$lambda$10 = CountryActivity.getCountryList$lambda$10(CountryActivity.this, (ApiResponse) obj);
                return countryList$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.h0
            public final Object invoke(Object obj) {
                Unit countryList$lambda$11;
                countryList$lambda$11 = CountryActivity.getCountryList$lambda$11(CountryActivity.this, (Throwable) obj);
                return countryList$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_country;
    }

    @NotNull
    public final ArrayList<CountryTop3ContributeBean> getList() {
        return this.list;
    }

    @NotNull
    public final CountryGroupAdapter getMAdapter() {
        return (CountryGroupAdapter) this.mAdapter.getValue();
    }

    @NotNull
    public final String getShortName() {
        return this.shortName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        this.compositeDisposable.d();
        this.baseData.destroy();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }

    public final void setList(@NotNull ArrayList<CountryTop3ContributeBean> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.list = arrayList;
    }

    public final void setShortName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shortName = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showAvatar1(@NotNull CountryTop3ContributeBean countryTop3ContributeBean) {
        int i;
        int i2;
        int i3;
        UserSummaryInfo user;
        SvipData svip;
        UserSummaryInfo user2;
        SvipData svip2;
        UserSummaryInfo user3;
        SvipData svip3;
        int i4;
        Integer level;
        Integer level2;
        List list;
        boolean z = true;
        Intrinsics.checkNotNullParameter(countryTop3ContributeBean, "countryTop3ContributeBean");
        int i5 = 0;
        ((ActivityCountryBinding) getBinding()).llTop1.setVisibility(0);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (!this.list.isEmpty()) {
            objectRef.element = this.list.get(0);
        }
        HiloImageView.loadImage$default(((ActivityCountryBinding) getBinding()).top1Avatar, ImageSizeKt.image100(countryTop3ContributeBean.getUser().getAvatar()), 0, 0, 6, (Object) null);
        ((ActivityCountryBinding) getBinding()).top1Name.setText(countryTop3ContributeBean.getUser().getName());
        ((ActivityCountryBinding) getBinding()).top1Id.setText(getString(2131953102, countryTop3ContributeBean.getUser().getCode()));
        Boolean isPrettyCode = countryTop3ContributeBean.getUser().isPrettyCode();
        Boolean bool = Boolean.TRUE;
        Integer num = null;
        if (Intrinsics.areEqual(isPrettyCode, bool)) {
            ShineTextView shineTextView = ((ActivityCountryBinding) getBinding()).top1Id;
            Intrinsics.checkNotNullExpressionValue(shineTextView, "top1Id");
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(shineTextView, ResourceUtilsKt.getDrawable(resources, 2131232463, Dimens.INSTANCE.dpToPx(4)));
        } else {
            ShineTextView shineTextView2 = ((ActivityCountryBinding) getBinding()).top1Id;
            Intrinsics.checkNotNullExpressionValue(shineTextView2, "top1Id");
            ViewUtilitiesKt.setDrawableLeft(shineTextView2, null);
        }
        final HiloImageView hiloImageView = ((ActivityCountryBinding) getBinding()).top1Avatar;
        final long j = 800;
        hiloImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.CountryActivity$showAvatar1$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str;
                String str2;
                UserSummaryInfo user4;
                UserSummaryInfo user5;
                UserSummaryInfo user6;
                SvipData svip4;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(hiloImageView) > j || (hiloImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(hiloImageView, currentTimeMillis);
                    HiloImageView hiloImageView2 = hiloImageView;
                    CountryTop3ContributeBean countryTop3ContributeBean2 = (CountryTop3ContributeBean) objectRef.element;
                    if (countryTop3ContributeBean2 != null && (user6 = countryTop3ContributeBean2.getUser()) != null && (svip4 = user6.getSvip()) != null && svip4.isRankStealth() && ((CountryTop3ContributeBean) objectRef.element).getUser().checkNotOfficialStaff()) {
                        new TipDialog(this).setTipContent(ResourcesKtxKt.getStringById(this, 2131954198)).show();
                        return;
                    }
                    CountryTop3ContributeBean countryTop3ContributeBean3 = (CountryTop3ContributeBean) objectRef.element;
                    if (countryTop3ContributeBean3 != null && (user5 = countryTop3ContributeBean3.getUser()) != null) {
                        str = user5.getExternalId();
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        CountryActivity countryActivity = this;
                        CountryTop3ContributeBean countryTop3ContributeBean4 = (CountryTop3ContributeBean) objectRef.element;
                        if (countryTop3ContributeBean4 == null || (user4 = countryTop3ContributeBean4.getUser()) == null || (str2 = user4.getExternalId()) == null) {
                            str2 = "";
                        }
                        countryActivity.openUserProfile(str2);
                    }
                }
            }
        });
        if (countryTop3ContributeBean.getUser().getMedalInfo() != null) {
            MedalGridLayout medalGridLayout = ((ActivityCountryBinding) getBinding()).top1Medal;
            List<MedalInfo> medalInfo = countryTop3ContributeBean.getUser().getMedalInfo();
            if (medalInfo != null) {
                list = CollectionsKt.toMutableList(medalInfo);
            } else {
                list = null;
            }
            Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
            medalGridLayout.setDataAndLayoutView((ArrayList) list, 15);
        }
        ImageView imageView = ((ActivityCountryBinding) getBinding()).iconVip1;
        if (Intrinsics.areEqual(countryTop3ContributeBean.getUser().isVip(), bool)) {
            i = 0;
        } else {
            i = 8;
        }
        imageView.setVisibility(i);
        NobleInfo noble = countryTop3ContributeBean.getUser().getNoble();
        if (noble != null && (level2 = noble.getLevel()) != null) {
            i2 = level2.intValue();
        } else {
            i2 = 0;
        }
        if (i2 > 0) {
            ((ActivityCountryBinding) getBinding()).iconVip1.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).iconNoble1.setVisibility(0);
            ImageView imageView2 = ((ActivityCountryBinding) getBinding()).iconNoble1;
            Context context = ((ActivityCountryBinding) getBinding()).getRoot().getContext();
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble2 = countryTop3ContributeBean.getUser().getNoble();
            if (noble2 != null && (level = noble2.getLevel()) != null) {
                i4 = level.intValue();
            } else {
                i4 = 0;
            }
            imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context, companion.getNobleDrawableRes(i4)));
        } else {
            ((ActivityCountryBinding) getBinding()).iconNoble1.setVisibility(8);
        }
        CountryTop3ContributeBean countryTop3ContributeBean2 = (CountryTop3ContributeBean) objectRef.element;
        if (countryTop3ContributeBean2 != null && (user3 = countryTop3ContributeBean2.getUser()) != null && (svip3 = user3.getSvip()) != null) {
            i3 = svip3.getSvipLevel();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            ((ActivityCountryBinding) getBinding()).iconVip1.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).iconNoble1.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).svip1.setVisibility(0);
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            CountryTop3ContributeBean countryTop3ContributeBean3 = (CountryTop3ContributeBean) objectRef.element;
            if (countryTop3ContributeBean3 != null && (user2 = countryTop3ContributeBean3.getUser()) != null && (svip2 = user2.getSvip()) != null) {
                num = Integer.valueOf(svip2.getSvipLevel());
            }
            Integer svipMedal = svipTypeUtils.getSvipMedal(num);
            if (svipMedal != null) {
                ((ActivityCountryBinding) getBinding()).svip1.setImageDrawable(androidx.core.content.a.getDrawable(((ActivityCountryBinding) getBinding()).getRoot().getContext(), svipMedal.intValue()));
            }
        } else {
            ((ActivityCountryBinding) getBinding()).svip1.setVisibility(8);
        }
        CountryTop3ContributeBean countryTop3ContributeBean4 = (CountryTop3ContributeBean) objectRef.element;
        if (countryTop3ContributeBean4 == null || (user = countryTop3ContributeBean4.getUser()) == null || (svip = user.getSvip()) == null || !svip.isRankStealth()) {
            z = false;
        }
        if (z) {
            HiloImageView.loadImage$default(((ActivityCountryBinding) getBinding()).top1Avatar, Integer.valueOf(R.drawable.svip_hide_heard), 0, 0, 6, (Object) null);
            ((ActivityCountryBinding) getBinding()).top1Id.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).top1Name.setText(ResourcesKtxKt.getStringById(this, 2131954197));
            ((ActivityCountryBinding) getBinding()).iconVip1.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).iconNoble1.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).svip1.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).top1Medal.setVisibility(8);
            return;
        }
        ShineTextView shineTextView3 = ((ActivityCountryBinding) getBinding()).top1Id;
        if (!UserStore.INSTANCE.getShared().checkSvipAndWealth()) {
            i5 = 8;
        }
        shineTextView3.setVisibility(i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showAvatar2(@NotNull CountryTop3ContributeBean countryTop3ContributeBean) {
        int i;
        int i2;
        int i3;
        UserSummaryInfo user;
        SvipData svip;
        UserSummaryInfo user2;
        SvipData svip2;
        UserSummaryInfo user3;
        SvipData svip3;
        int i4;
        Integer level;
        Integer level2;
        List list;
        Intrinsics.checkNotNullParameter(countryTop3ContributeBean, "countryTop3ContributeBean");
        int i5 = 0;
        ((ActivityCountryBinding) getBinding()).llTop2.setVisibility(0);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        boolean z = true;
        if (this.list.size() > 1) {
            objectRef.element = this.list.get(1);
        }
        HiloImageView.loadImage$default(((ActivityCountryBinding) getBinding()).top2Avatar, ImageSizeKt.image100(countryTop3ContributeBean.getUser().getAvatar()), 0, 0, 6, (Object) null);
        final HiloImageView hiloImageView = ((ActivityCountryBinding) getBinding()).top2Avatar;
        final long j = 800;
        hiloImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.CountryActivity$showAvatar2$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str;
                String str2;
                UserSummaryInfo user4;
                UserSummaryInfo user5;
                UserSummaryInfo user6;
                SvipData svip4;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(hiloImageView) > j || (hiloImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(hiloImageView, currentTimeMillis);
                    HiloImageView hiloImageView2 = hiloImageView;
                    CountryTop3ContributeBean countryTop3ContributeBean2 = (CountryTop3ContributeBean) objectRef.element;
                    if (countryTop3ContributeBean2 != null && (user6 = countryTop3ContributeBean2.getUser()) != null && (svip4 = user6.getSvip()) != null && svip4.isRankStealth() && ((CountryTop3ContributeBean) objectRef.element).getUser().checkNotOfficialStaff()) {
                        new TipDialog(this).setTipContent(ResourcesKtxKt.getStringById(this, 2131954198)).show();
                        return;
                    }
                    CountryTop3ContributeBean countryTop3ContributeBean3 = (CountryTop3ContributeBean) objectRef.element;
                    if (countryTop3ContributeBean3 != null && (user5 = countryTop3ContributeBean3.getUser()) != null) {
                        str = user5.getExternalId();
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        CountryActivity countryActivity = this;
                        CountryTop3ContributeBean countryTop3ContributeBean4 = (CountryTop3ContributeBean) objectRef.element;
                        if (countryTop3ContributeBean4 == null || (user4 = countryTop3ContributeBean4.getUser()) == null || (str2 = user4.getExternalId()) == null) {
                            str2 = "";
                        }
                        countryActivity.openUserProfile(str2);
                    }
                }
            }
        });
        ((ActivityCountryBinding) getBinding()).top2Name.setText(countryTop3ContributeBean.getUser().getName());
        ((ActivityCountryBinding) getBinding()).top2Id.setText(getString(2131953102, countryTop3ContributeBean.getUser().getCode()));
        Boolean isPrettyCode = countryTop3ContributeBean.getUser().isPrettyCode();
        Boolean bool = Boolean.TRUE;
        Integer num = null;
        if (Intrinsics.areEqual(isPrettyCode, bool)) {
            ShineTextView shineTextView = ((ActivityCountryBinding) getBinding()).top2Id;
            Intrinsics.checkNotNullExpressionValue(shineTextView, "top2Id");
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(shineTextView, ResourceUtilsKt.getDrawable(resources, 2131232463, Dimens.INSTANCE.dpToPx(4)));
        } else {
            ShineTextView shineTextView2 = ((ActivityCountryBinding) getBinding()).top2Id;
            Intrinsics.checkNotNullExpressionValue(shineTextView2, "top2Id");
            ViewUtilitiesKt.setDrawableLeft(shineTextView2, null);
        }
        if (countryTop3ContributeBean.getUser().getMedalInfo() != null) {
            MedalGridLayout medalGridLayout = ((ActivityCountryBinding) getBinding()).top2Medal;
            List<MedalInfo> medalInfo = countryTop3ContributeBean.getUser().getMedalInfo();
            if (medalInfo != null) {
                list = CollectionsKt.toMutableList(medalInfo);
            } else {
                list = null;
            }
            Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
            medalGridLayout.setDataAndLayoutView((ArrayList) list, 15);
        }
        ImageView imageView = ((ActivityCountryBinding) getBinding()).iconVip2;
        if (Intrinsics.areEqual(countryTop3ContributeBean.getUser().isVip(), bool)) {
            i = 0;
        } else {
            i = 8;
        }
        imageView.setVisibility(i);
        NobleInfo noble = countryTop3ContributeBean.getUser().getNoble();
        if (noble != null && (level2 = noble.getLevel()) != null) {
            i2 = level2.intValue();
        } else {
            i2 = 0;
        }
        if (i2 > 0) {
            ((ActivityCountryBinding) getBinding()).iconVip2.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).iconNoble2.setVisibility(0);
            ImageView imageView2 = ((ActivityCountryBinding) getBinding()).iconNoble2;
            Context context = ((ActivityCountryBinding) getBinding()).getRoot().getContext();
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble2 = countryTop3ContributeBean.getUser().getNoble();
            if (noble2 != null && (level = noble2.getLevel()) != null) {
                i4 = level.intValue();
            } else {
                i4 = 0;
            }
            imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context, companion.getNobleDrawableRes(i4)));
        } else {
            ((ActivityCountryBinding) getBinding()).iconNoble2.setVisibility(8);
        }
        CountryTop3ContributeBean countryTop3ContributeBean2 = (CountryTop3ContributeBean) objectRef.element;
        if (countryTop3ContributeBean2 != null && (user3 = countryTop3ContributeBean2.getUser()) != null && (svip3 = user3.getSvip()) != null) {
            i3 = svip3.getSvipLevel();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            ((ActivityCountryBinding) getBinding()).iconVip2.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).iconNoble2.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).svip2.setVisibility(0);
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            CountryTop3ContributeBean countryTop3ContributeBean3 = (CountryTop3ContributeBean) objectRef.element;
            if (countryTop3ContributeBean3 != null && (user2 = countryTop3ContributeBean3.getUser()) != null && (svip2 = user2.getSvip()) != null) {
                num = Integer.valueOf(svip2.getSvipLevel());
            }
            Integer svipMedal = svipTypeUtils.getSvipMedal(num);
            if (svipMedal != null) {
                ((ActivityCountryBinding) getBinding()).svip2.setImageDrawable(androidx.core.content.a.getDrawable(((ActivityCountryBinding) getBinding()).getRoot().getContext(), svipMedal.intValue()));
            }
        } else {
            ((ActivityCountryBinding) getBinding()).svip2.setVisibility(8);
        }
        CountryTop3ContributeBean countryTop3ContributeBean4 = (CountryTop3ContributeBean) objectRef.element;
        if (countryTop3ContributeBean4 == null || (user = countryTop3ContributeBean4.getUser()) == null || (svip = user.getSvip()) == null || !svip.isRankStealth()) {
            z = false;
        }
        if (z) {
            HiloImageView.loadImage$default(((ActivityCountryBinding) getBinding()).top2Avatar, Integer.valueOf(R.drawable.svip_hide_heard), 0, 0, 6, (Object) null);
            ((ActivityCountryBinding) getBinding()).top2Id.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).top2Name.setText(ResourcesKtxKt.getStringById(this, 2131954197));
            ((ActivityCountryBinding) getBinding()).iconVip2.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).iconNoble2.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).svip2.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).top2Medal.setVisibility(8);
            return;
        }
        ShineTextView shineTextView3 = ((ActivityCountryBinding) getBinding()).top2Id;
        if (!UserStore.INSTANCE.getShared().checkSvipAndWealth()) {
            i5 = 8;
        }
        shineTextView3.setVisibility(i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showAvatar3(@NotNull CountryTop3ContributeBean countryTop3ContributeBean) {
        int i;
        int i2;
        int i3;
        UserSummaryInfo user;
        SvipData svip;
        UserSummaryInfo user2;
        SvipData svip2;
        UserSummaryInfo user3;
        SvipData svip3;
        int i4;
        Integer level;
        Integer level2;
        List list;
        boolean z = true;
        Intrinsics.checkNotNullParameter(countryTop3ContributeBean, "countryTop3ContributeBean");
        int i5 = 0;
        ((ActivityCountryBinding) getBinding()).llTop3.setVisibility(0);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (this.list.size() > 2) {
            objectRef.element = this.list.get(2);
        }
        final HiloImageView hiloImageView = ((ActivityCountryBinding) getBinding()).top3Avatar;
        final long j = 800;
        hiloImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.CountryActivity$showAvatar3$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str;
                String str2;
                UserSummaryInfo user4;
                UserSummaryInfo user5;
                UserSummaryInfo user6;
                SvipData svip4;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(hiloImageView) > j || (hiloImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(hiloImageView, currentTimeMillis);
                    HiloImageView hiloImageView2 = hiloImageView;
                    CountryTop3ContributeBean countryTop3ContributeBean2 = (CountryTop3ContributeBean) objectRef.element;
                    if (countryTop3ContributeBean2 != null && (user6 = countryTop3ContributeBean2.getUser()) != null && (svip4 = user6.getSvip()) != null && svip4.isRankStealth() && ((CountryTop3ContributeBean) objectRef.element).getUser().checkNotOfficialStaff()) {
                        new TipDialog(this).setTipContent(ResourcesKtxKt.getStringById(this, 2131954198)).show();
                        return;
                    }
                    CountryTop3ContributeBean countryTop3ContributeBean3 = (CountryTop3ContributeBean) objectRef.element;
                    if (countryTop3ContributeBean3 != null && (user5 = countryTop3ContributeBean3.getUser()) != null) {
                        str = user5.getExternalId();
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        CountryActivity countryActivity = this;
                        CountryTop3ContributeBean countryTop3ContributeBean4 = (CountryTop3ContributeBean) objectRef.element;
                        if (countryTop3ContributeBean4 == null || (user4 = countryTop3ContributeBean4.getUser()) == null || (str2 = user4.getExternalId()) == null) {
                            str2 = "";
                        }
                        countryActivity.openUserProfile(str2);
                    }
                }
            }
        });
        HiloImageView.loadImage$default(((ActivityCountryBinding) getBinding()).top3Avatar, ImageSizeKt.image100(countryTop3ContributeBean.getUser().getAvatar()), 0, 0, 6, (Object) null);
        ((ActivityCountryBinding) getBinding()).top3Name.setText(countryTop3ContributeBean.getUser().getName());
        ((ActivityCountryBinding) getBinding()).top3Id.setText(getString(2131953102, countryTop3ContributeBean.getUser().getCode()));
        Boolean isPrettyCode = countryTop3ContributeBean.getUser().isPrettyCode();
        Boolean bool = Boolean.TRUE;
        Integer num = null;
        if (Intrinsics.areEqual(isPrettyCode, bool)) {
            ShineTextView shineTextView = ((ActivityCountryBinding) getBinding()).top3Id;
            Intrinsics.checkNotNullExpressionValue(shineTextView, "top3Id");
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(shineTextView, ResourceUtilsKt.getDrawable(resources, 2131232463, Dimens.INSTANCE.dpToPx(4)));
        } else {
            ShineTextView shineTextView2 = ((ActivityCountryBinding) getBinding()).top3Id;
            Intrinsics.checkNotNullExpressionValue(shineTextView2, "top3Id");
            ViewUtilitiesKt.setDrawableLeft(shineTextView2, null);
        }
        if (countryTop3ContributeBean.getUser().getMedalInfo() != null) {
            MedalGridLayout medalGridLayout = ((ActivityCountryBinding) getBinding()).top3Medal;
            List<MedalInfo> medalInfo = countryTop3ContributeBean.getUser().getMedalInfo();
            if (medalInfo != null) {
                list = CollectionsKt.toMutableList(medalInfo);
            } else {
                list = null;
            }
            Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
            medalGridLayout.setDataAndLayoutView((ArrayList) list, 15);
        }
        ImageView imageView = ((ActivityCountryBinding) getBinding()).iconVip3;
        if (Intrinsics.areEqual(countryTop3ContributeBean.getUser().isVip(), bool)) {
            i = 0;
        } else {
            i = 8;
        }
        imageView.setVisibility(i);
        NobleInfo noble = countryTop3ContributeBean.getUser().getNoble();
        if (noble != null && (level2 = noble.getLevel()) != null) {
            i2 = level2.intValue();
        } else {
            i2 = 0;
        }
        if (i2 > 0) {
            ((ActivityCountryBinding) getBinding()).iconVip3.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).iconNoble3.setVisibility(0);
            ImageView imageView2 = ((ActivityCountryBinding) getBinding()).iconNoble3;
            Context context = ((ActivityCountryBinding) getBinding()).getRoot().getContext();
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble2 = countryTop3ContributeBean.getUser().getNoble();
            if (noble2 != null && (level = noble2.getLevel()) != null) {
                i4 = level.intValue();
            } else {
                i4 = 0;
            }
            imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context, companion.getNobleDrawableRes(i4)));
        } else {
            ((ActivityCountryBinding) getBinding()).iconNoble3.setVisibility(8);
        }
        CountryTop3ContributeBean countryTop3ContributeBean2 = (CountryTop3ContributeBean) objectRef.element;
        if (countryTop3ContributeBean2 != null && (user3 = countryTop3ContributeBean2.getUser()) != null && (svip3 = user3.getSvip()) != null) {
            i3 = svip3.getSvipLevel();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            ((ActivityCountryBinding) getBinding()).iconVip3.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).iconNoble3.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).svip3.setVisibility(0);
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            CountryTop3ContributeBean countryTop3ContributeBean3 = (CountryTop3ContributeBean) objectRef.element;
            if (countryTop3ContributeBean3 != null && (user2 = countryTop3ContributeBean3.getUser()) != null && (svip2 = user2.getSvip()) != null) {
                num = Integer.valueOf(svip2.getSvipLevel());
            }
            Integer svipMedal = svipTypeUtils.getSvipMedal(num);
            if (svipMedal != null) {
                ((ActivityCountryBinding) getBinding()).svip3.setImageDrawable(androidx.core.content.a.getDrawable(((ActivityCountryBinding) getBinding()).getRoot().getContext(), svipMedal.intValue()));
            }
        } else {
            ((ActivityCountryBinding) getBinding()).svip3.setVisibility(8);
        }
        CountryTop3ContributeBean countryTop3ContributeBean4 = (CountryTop3ContributeBean) objectRef.element;
        if (countryTop3ContributeBean4 == null || (user = countryTop3ContributeBean4.getUser()) == null || (svip = user.getSvip()) == null || !svip.isRankStealth()) {
            z = false;
        }
        if (z) {
            HiloImageView.loadImage$default(((ActivityCountryBinding) getBinding()).top3Avatar, Integer.valueOf(R.drawable.svip_hide_heard), 0, 0, 6, (Object) null);
            ((ActivityCountryBinding) getBinding()).top3Id.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).top3Name.setText(ResourcesKtxKt.getStringById(this, 2131954197));
            ((ActivityCountryBinding) getBinding()).iconVip3.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).iconNoble3.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).svip3.setVisibility(8);
            ((ActivityCountryBinding) getBinding()).top3Medal.setVisibility(8);
            return;
        }
        ShineTextView shineTextView3 = ((ActivityCountryBinding) getBinding()).top3Id;
        if (!UserStore.INSTANCE.getShared().checkSvipAndWealth()) {
            i5 = 8;
        }
        shineTextView3.setVisibility(i5);
    }
}
