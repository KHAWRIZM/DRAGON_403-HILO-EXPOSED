package com.qiahao.nextvideo.ui.cp;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.StoreBean;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.BagEvent;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.cp.CpCheck;
import com.qiahao.nextvideo.data.model.ContactsLikeEachItem;
import com.qiahao.nextvideo.data.noble.NobleCard;
import com.qiahao.nextvideo.databinding.ActivitySearchUserBinding;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/SearchUserActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivitySearchUserBinding;", "<init>", "()V", "mMemberAdapter", "Lcom/qiahao/nextvideo/ui/cp/SearchUserAdapter;", "getMMemberAdapter", "()Lcom/qiahao/nextvideo/ui/cp/SearchUserAdapter;", "mMemberAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/qiahao/nextvideo/ui/cp/SearchViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/cp/SearchViewModel;", "viewModel$delegate", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSearchUserActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchUserActivity.kt\ncom/qiahao/nextvideo/ui/cp/SearchUserActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,328:1\n61#2,9:329\n*S KotlinDebug\n*F\n+ 1 SearchUserActivity.kt\ncom/qiahao/nextvideo/ui/cp/SearchUserActivity\n*L\n192#1:329,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SearchUserActivity extends HiloBaseBindingActivity<ActivitySearchUserBinding> {

    @NotNull
    public static final String BIND_CP = "BIND_CP";

    @NotNull
    public static final String BIND_RELATION = "BIND_RELATION";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String SEND_BAG = "SEND_BAG";

    @NotNull
    public static final String SEND_CARD = "SEND_CARD";

    @NotNull
    public static final String SEND_STORE = "SEND_STORE";

    @NotNull
    public static final String TYPE = "TYPE";

    @NotNull
    public static final String TYPE_DATA = "TYPE_DATA";

    /* renamed from: mMemberAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMemberAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.cp.x2
        public final Object invoke() {
            SearchUserAdapter mMemberAdapter_delegate$lambda$0;
            mMemberAdapter_delegate$lambda$0 = SearchUserActivity.mMemberAdapter_delegate$lambda$0();
            return mMemberAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.cp.y2
        public final Object invoke() {
            SearchViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = SearchUserActivity.viewModel_delegate$lambda$1(SearchUserActivity.this);
            return viewModel_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/SearchUserActivity$Companion;", "", "<init>", "()V", SearchUserActivity.TYPE, "", SearchUserActivity.TYPE_DATA, SearchUserActivity.BIND_CP, "SEND_CARD", "SEND_STORE", SearchUserActivity.BIND_RELATION, SearchUserActivity.SEND_BAG, "startActivity", "", "context", "Landroid/content/Context;", "type", "data", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void startActivity$default(Companion companion, Context context, String str, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            companion.startActivity(context, str, str2);
        }

        public final void startActivity(@NotNull Context context, @NotNull String type, @Nullable String data) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(type, "type");
            Intent intent = new Intent(context, (Class<?>) SearchUserActivity.class);
            intent.putExtra(SearchUserActivity.TYPE, type);
            intent.putExtra(SearchUserActivity.TYPE_DATA, data);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    private final SearchUserAdapter getMMemberAdapter() {
        return (SearchUserAdapter) this.mMemberAdapter.getValue();
    }

    public final SearchViewModel getViewModel() {
        return (SearchViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getShareList().observe(this, new SearchUserActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.b3
            public final Object invoke(Object obj) {
                Unit initData$lambda$2;
                initData$lambda$2 = SearchUserActivity.initData$lambda$2(SearchUserActivity.this, (List) obj);
                return initData$lambda$2;
            }
        }));
        getViewModel().getMException().observe(this, new SearchUserActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.n2
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = SearchUserActivity.initData$lambda$3(SearchUserActivity.this, (Pair) obj);
                return initData$lambda$3;
            }
        }));
        getViewModel().getCheckCP().observe(this, new SearchUserActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.o2
            public final Object invoke(Object obj) {
                Unit initData$lambda$6;
                initData$lambda$6 = SearchUserActivity.initData$lambda$6(SearchUserActivity.this, (CpCheck) obj);
                return initData$lambda$6;
            }
        }));
        getViewModel().getCheckRelation().observe(this, new SearchUserActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.p2
            public final Object invoke(Object obj) {
                Unit initData$lambda$9;
                initData$lambda$9 = SearchUserActivity.initData$lambda$9(SearchUserActivity.this, (CpCheck) obj);
                return initData$lambda$9;
            }
        }));
        getViewModel().getMSuccess().observe(this, new SearchUserActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.q2
            public final Object invoke(Object obj) {
                Unit initData$lambda$10;
                initData$lambda$10 = SearchUserActivity.initData$lambda$10(SearchUserActivity.this, (Pair) obj);
                return initData$lambda$10;
            }
        }));
        getViewModel().getMException().observe(this, new SearchUserActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.r2
            public final Object invoke(Object obj) {
                Unit initData$lambda$11;
                initData$lambda$11 = SearchUserActivity.initData$lambda$11(SearchUserActivity.this, (Pair) obj);
                return initData$lambda$11;
            }
        }));
        getViewModel().getCpBindSuccess().observe(this, new SearchUserActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.s2
            public final Object invoke(Object obj) {
                Unit initData$lambda$12;
                initData$lambda$12 = SearchUserActivity.initData$lambda$12(SearchUserActivity.this, (Boolean) obj);
                return initData$lambda$12;
            }
        }));
        getViewModel().shareFriendsList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$10(SearchUserActivity searchUserActivity, Pair pair) {
        String str = (String) pair.getFirst();
        if (Intrinsics.areEqual(str, "SEND_CARD") || Intrinsics.areEqual(str, "SEND_STORE")) {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, searchUserActivity, ResourcesKtxKt.getStringById(searchUserActivity, 2131954177), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            searchUserActivity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$11(SearchUserActivity searchUserActivity, Pair pair) {
        String str = (String) pair.getFirst();
        if ((Intrinsics.areEqual(str, "SEND_CARD") || Intrinsics.areEqual(str, "SEND_STORE")) && (pair.getSecond() instanceof HiloException)) {
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) second).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(searchUserActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, searchUserActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$12(SearchUserActivity searchUserActivity, Boolean bool) {
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, searchUserActivity, ResourcesKtxKt.getStringById(searchUserActivity, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        searchUserActivity.finish();
        return Unit.INSTANCE;
    }

    public static final Unit initData$lambda$2(SearchUserActivity searchUserActivity, List list) {
        searchUserActivity.getBinding().refreshLayout.finishRefresh();
        searchUserActivity.getBinding().refreshLayout.finishLoadMore();
        searchUserActivity.getBinding().refreshLayout.setEnableLoadMore(false);
        if (list != null && list.isEmpty()) {
            searchUserActivity.getBinding().statusView.showEmpty();
        } else {
            searchUserActivity.getBinding().statusView.showContent();
        }
        searchUserActivity.getMMemberAdapter().setList(list);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0054, code lost:
    
        r7 = com.qiahao.base_common.utils.HiloToasty.Companion.normal$default(r1, r7, r8, false, 4, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x005d, code lost:
    
        if (r7 == null) goto L٥٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005f, code lost:
    
        r7.show();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
    
        if (r0.equals(com.qiahao.nextvideo.ui.cp.SearchViewModel.ERROR_CP_SEND) == false) goto L٥٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        if (r0.equals(com.qiahao.nextvideo.ui.cp.SearchViewModel.ERROR_RELATION_SEND) == false) goto L٥٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        if (r0.equals(com.qiahao.nextvideo.ui.cp.SearchViewModel.CHECK_RELATION) == false) goto L٥٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
    
        if (r0.equals(com.qiahao.nextvideo.ui.cp.SearchViewModel.ERROR_CHECK_CP) != false) goto L٤٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0038, code lost:
    
        if ((r8.getSecond() instanceof com.qiahao.base_common.network.interceptors.HiloException) == false) goto L٥٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003a, code lost:
    
        r1 = com.qiahao.base_common.utils.HiloToasty.Companion;
        r8 = r8.getSecond();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
        r8 = ((com.qiahao.base_common.network.interceptors.HiloException) r8).getErrorMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x004b, code lost:
    
        if (r8 != null) goto L٤٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004d, code lost:
    
        r8 = com.oudi.utils.ktx.ResourcesKtxKt.getStringById(r7, 2131952667);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit initData$lambda$3(SearchUserActivity searchUserActivity, Pair pair) {
        String str = (String) pair.getFirst();
        switch (str.hashCode()) {
            case -517655693:
                break;
            case 454388715:
                break;
            case 966277146:
                break;
            case 1536888580:
                break;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$6(SearchUserActivity searchUserActivity, CpCheck cpCheck) {
        Intrinsics.checkNotNull(cpCheck);
        CpInvitationSendDialog cpInvitationSendDialog = new CpInvitationSendDialog(searchUserActivity, cpCheck);
        cpInvitationSendDialog.setListener(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.a3
            public final Object invoke(Object obj) {
                Unit initData$lambda$6$lambda$5$lambda$4;
                initData$lambda$6$lambda$5$lambda$4 = SearchUserActivity.initData$lambda$6$lambda$5$lambda$4(SearchUserActivity.this, (CpCheck) obj);
                return initData$lambda$6$lambda$5$lambda$4;
            }
        });
        cpInvitationSendDialog.show();
        return Unit.INSTANCE;
    }

    public static final Unit initData$lambda$6$lambda$5$lambda$4(SearchUserActivity searchUserActivity, CpCheck cpCheck) {
        String str;
        Intrinsics.checkNotNullParameter(cpCheck, "it");
        SearchViewModel viewModel = searchUserActivity.getViewModel();
        User user = cpCheck.getUser();
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        viewModel.cpRelation(str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$9(SearchUserActivity searchUserActivity, CpCheck cpCheck) {
        int i;
        Intrinsics.checkNotNull(cpCheck);
        Integer relationType = searchUserActivity.getViewModel().getRelationType();
        if (relationType != null) {
            i = relationType.intValue();
        } else {
            i = 0;
        }
        RelationInvitationSendDialog relationInvitationSendDialog = new RelationInvitationSendDialog(searchUserActivity, cpCheck, i);
        relationInvitationSendDialog.setListener(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.z2
            public final Object invoke(Object obj) {
                Unit initData$lambda$9$lambda$8$lambda$7;
                initData$lambda$9$lambda$8$lambda$7 = SearchUserActivity.initData$lambda$9$lambda$8$lambda$7(SearchUserActivity.this, (CpCheck) obj);
                return initData$lambda$9$lambda$8$lambda$7;
            }
        });
        relationInvitationSendDialog.show();
        return Unit.INSTANCE;
    }

    public static final Unit initData$lambda$9$lambda$8$lambda$7(SearchUserActivity searchUserActivity, CpCheck cpCheck) {
        String str;
        int i;
        Intrinsics.checkNotNullParameter(cpCheck, "it");
        SearchViewModel viewModel = searchUserActivity.getViewModel();
        User user = cpCheck.getUser();
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        Integer relationType = searchUserActivity.getViewModel().getRelationType();
        if (relationType != null) {
            i = relationType.intValue();
        } else {
            i = 0;
        }
        viewModel.specialRelation(str, i);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0042, code lost:
    
        if (r0.equals(com.qiahao.nextvideo.ui.cp.SearchUserActivity.SEND_BAG) == false) goto L٦٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x00a3, code lost:
    
        ((com.qiahao.nextvideo.databinding.ActivitySearchUserBinding) getBinding()).title.setText(com.oudi.utils.ktx.ResourcesKtxKt.getStringById(r4, 2131952370));
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a0, code lost:
    
        if (r0.equals("SEND_STORE") == false) goto L٦٤;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initView() {
        SearchViewModel viewModel = getViewModel();
        String stringExtra = getIntent().getStringExtra(TYPE);
        String str = "";
        if (stringExtra == null) {
            stringExtra = "";
        }
        viewModel.setMType(stringExtra);
        SearchViewModel viewModel2 = getViewModel();
        String stringExtra2 = getIntent().getStringExtra(TYPE_DATA);
        if (stringExtra2 != null) {
            str = stringExtra2;
        }
        viewModel2.setMData(str);
        String mType = getViewModel().getMType();
        switch (mType.hashCode()) {
            case -2066062006:
                break;
            case -1452615321:
                if (mType.equals("SEND_CARD")) {
                    ((ActivitySearchUserBinding) getBinding()).title.setText(ResourcesKtxKt.getStringById(this, 2131952371));
                    break;
                }
                break;
            case 60781502:
                if (mType.equals(BIND_RELATION)) {
                    ((ActivitySearchUserBinding) getBinding()).title.setText(ResourcesKtxKt.getStringById(this, 2131952121));
                    break;
                }
                break;
            case 609782703:
                if (mType.equals(BIND_CP)) {
                    ((ActivitySearchUserBinding) getBinding()).title.setText(ResourcesKtxKt.getStringById(this, 2131952116));
                    break;
                }
                break;
            case 2031350449:
                break;
        }
        View view = ((ActivitySearchUserBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.cp.m2
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$13;
                initView$lambda$13 = SearchUserActivity.initView$lambda$13(SearchUserActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$13;
            }
        });
        ((ActivitySearchUserBinding) getBinding()).recyclerView.setAdapter(getMMemberAdapter());
        ((ActivitySearchUserBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        getViewModel().getShareListData().registerStatusLayoutAndRefreshLayout(((ActivitySearchUserBinding) getBinding()).refreshLayout, ((ActivitySearchUserBinding) getBinding()).statusView);
        final AppCompatImageView appCompatImageView = ((ActivitySearchUserBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.SearchUserActivity$initView$$inlined$singleClick$default$1
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
        ((ActivitySearchUserBinding) getBinding()).searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.qiahao.nextvideo.ui.cp.t2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean initView$lambda$15;
                initView$lambda$15 = SearchUserActivity.initView$lambda$15(SearchUserActivity.this, textView, i, keyEvent);
                return initView$lambda$15;
            }
        });
        ((ActivitySearchUserBinding) getBinding()).searchEditText.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.ui.cp.SearchUserActivity$initView$4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                SearchViewModel viewModel3;
                if (TextUtils.isEmpty(s) && HiloUtils.INSTANCE.notFastClick()) {
                    viewModel3 = SearchUserActivity.this.getViewModel();
                    viewModel3.shareFriendsList();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        ((ActivitySearchUserBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.cp.u2
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                SearchUserActivity.initView$lambda$16(SearchUserActivity.this, fVar);
            }
        });
        ((ActivitySearchUserBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.cp.SearchUserActivity$initView$6
            public void onRetry(IStatusView statusView, Status status) {
                ActivitySearchUserBinding binding;
                SearchViewModel viewModel3;
                ActivitySearchUserBinding binding2;
                SearchViewModel viewModel4;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                binding = SearchUserActivity.this.getBinding();
                if (TextUtils.isEmpty(binding.searchEditText.getText().toString())) {
                    viewModel4 = SearchUserActivity.this.getViewModel();
                    viewModel4.shareFriendsList();
                } else {
                    viewModel3 = SearchUserActivity.this.getViewModel();
                    binding2 = SearchUserActivity.this.getBinding();
                    viewModel3.searchFriends(binding2.searchEditText.getText().toString(), 1);
                }
            }
        });
        getMMemberAdapter().addChildClickViewIds(new int[]{2131362013});
        getMMemberAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.cp.v2
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                SearchUserActivity.initView$lambda$17(SearchUserActivity.this, baseQuickAdapter, view2, i);
            }
        });
        getMMemberAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.cp.w2
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                SearchUserActivity.initView$lambda$18(SearchUserActivity.this, baseQuickAdapter, view2, i);
            }
        });
    }

    public static final Unit initView$lambda$13(SearchUserActivity searchUserActivity, int i, int i2) {
        searchUserActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    public static final boolean initView$lambda$15(SearchUserActivity searchUserActivity, TextView textView, int i, KeyEvent keyEvent) {
        if ((i == 3 || (keyEvent != null && 66 == keyEvent.getKeyCode() && keyEvent.getAction() == 0)) && FastClickOneUtils.INSTANCE.isFastClick() && !TextUtils.isEmpty(searchUserActivity.getBinding().searchEditText.getText().toString())) {
            searchUserActivity.getViewModel().searchFriends(searchUserActivity.getBinding().searchEditText.getText().toString(), 1);
            return false;
        }
        return false;
    }

    public static final void initView$lambda$16(SearchUserActivity searchUserActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        if (TextUtils.isEmpty(searchUserActivity.getBinding().searchEditText.getText().toString())) {
            searchUserActivity.getViewModel().getShareListData().resetPage();
            searchUserActivity.getViewModel().shareFriendsList();
        } else {
            searchUserActivity.getViewModel().searchFriends(searchUserActivity.getBinding().searchEditText.getText().toString(), 1);
        }
    }

    public static final void initView$lambda$17(SearchUserActivity searchUserActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, ((ContactsLikeEachItem) searchUserActivity.getMMemberAdapter().getData().get(i)).getUserBase().getExternalId(), false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$18(final SearchUserActivity searchUserActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Integer num;
        int i2 = 0;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        final ContactsLikeEachItem contactsLikeEachItem = (ContactsLikeEachItem) searchUserActivity.getMMemberAdapter().getData().get(i);
        String mType = searchUserActivity.getViewModel().getMType();
        Object obj = null;
        switch (mType.hashCode()) {
            case -2066062006:
                if (mType.equals("SEND_STORE")) {
                    try {
                        searchUserActivity.getViewModel().setSelectStoreBean((StoreBean) new com.google.gson.d().j(searchUserActivity.getViewModel().getMData(), StoreBean.class));
                        TipDialog tipDialog = new TipDialog(searchUserActivity);
                        String stringById = ResourcesKtxKt.getStringById(searchUserActivity, 2131954025);
                        StoreBean selectStoreBean = searchUserActivity.getViewModel().getSelectStoreBean();
                        if (selectStoreBean != null) {
                            obj = selectStoreBean.getDiamondNum();
                        }
                        String format = String.format(stringById, Arrays.copyOf(new Object[]{obj, contactsLikeEachItem.getUserBase().getNick()}, 2));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        tipDialog.setTipContent(format).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.cp.SearchUserActivity$initView$8$2
                            public void cancel() {
                                OnCommonDialogListener.DefaultImpls.cancel(this);
                            }

                            public void confirm() {
                                SearchViewModel viewModel;
                                SearchViewModel viewModel2;
                                int i3;
                                SearchViewModel viewModel3;
                                long j;
                                Long id2;
                                viewModel = SearchUserActivity.this.getViewModel();
                                viewModel2 = SearchUserActivity.this.getViewModel();
                                StoreBean selectStoreBean2 = viewModel2.getSelectStoreBean();
                                if (selectStoreBean2 != null) {
                                    i3 = selectStoreBean2.getType();
                                } else {
                                    i3 = 0;
                                }
                                viewModel3 = SearchUserActivity.this.getViewModel();
                                StoreBean selectStoreBean3 = viewModel3.getSelectStoreBean();
                                if (selectStoreBean3 != null && (id2 = selectStoreBean3.getId()) != null) {
                                    j = id2.longValue();
                                } else {
                                    j = 0;
                                }
                                viewModel.sendHeadOrMounts(i3, j, contactsLikeEachItem.getUserBase().getExternalId());
                            }
                        }).show();
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            case -1452615321:
                if (mType.equals("SEND_CARD")) {
                    try {
                        searchUserActivity.getViewModel().setSelectNoble((NobleCard) new com.google.gson.d().j(searchUserActivity.getViewModel().getMData(), NobleCard.class));
                        TipDialog tipDialog2 = new TipDialog(searchUserActivity);
                        String stringById2 = ResourcesKtxKt.getStringById(searchUserActivity, 2131953545);
                        String nick = contactsLikeEachItem.getUserBase().getNick();
                        String stringById3 = ResourcesKtxKt.getStringById(searchUserActivity, 2131954024);
                        NobleCard selectNoble = searchUserActivity.getViewModel().getSelectNoble();
                        if (selectNoble != null) {
                            num = selectNoble.getLevel();
                        } else {
                            num = null;
                        }
                        String format2 = String.format(stringById3, Arrays.copyOf(new Object[]{" VIP" + num}, 1));
                        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                        String str = nick + format2;
                        String stringById4 = ResourcesKtxKt.getStringById(searchUserActivity, 2131952502);
                        NobleCard selectNoble2 = searchUserActivity.getViewModel().getSelectNoble();
                        if (selectNoble2 != null) {
                            obj = selectNoble2.getDay();
                        }
                        String format3 = String.format(stringById4, Arrays.copyOf(new Object[]{obj}, 1));
                        Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                        String format4 = String.format(stringById2, Arrays.copyOf(new Object[]{str, format3}, 2));
                        Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
                        tipDialog2.setTipContent(format4).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.cp.SearchUserActivity$initView$8$1
                            public void cancel() {
                                OnCommonDialogListener.DefaultImpls.cancel(this);
                            }

                            public void confirm() {
                                SearchViewModel viewModel;
                                SearchViewModel viewModel2;
                                int i3;
                                Integer id2;
                                viewModel = SearchUserActivity.this.getViewModel();
                                viewModel2 = SearchUserActivity.this.getViewModel();
                                NobleCard selectNoble3 = viewModel2.getSelectNoble();
                                if (selectNoble3 != null && (id2 = selectNoble3.getId()) != null) {
                                    i3 = id2.intValue();
                                } else {
                                    i3 = 0;
                                }
                                viewModel.sendNobleCard(i3, contactsLikeEachItem.getUserBase().getExternalId());
                            }
                        }).show();
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                return;
            case 60781502:
                if (mType.equals(BIND_RELATION)) {
                    try {
                        searchUserActivity.getViewModel().setRelationType(((StoreBean) new com.google.gson.d().j(searchUserActivity.getViewModel().getMData(), StoreBean.class)).getRelationType());
                        SearchViewModel viewModel = searchUserActivity.getViewModel();
                        User userBase = contactsLikeEachItem.getUserBase();
                        Integer relationType = searchUserActivity.getViewModel().getRelationType();
                        if (relationType != null) {
                            i2 = relationType.intValue();
                        }
                        viewModel.checkBindRelation(userBase, i2);
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            case 609782703:
                if (mType.equals(BIND_CP)) {
                    searchUserActivity.getViewModel().checkBindCp(contactsLikeEachItem.getUserBase());
                    return;
                }
                return;
            case 2031350449:
                if (mType.equals(SEND_BAG)) {
                    TipDialog tipDialog3 = new TipDialog(searchUserActivity);
                    String format5 = String.format(ResourcesKtxKt.getStringById(searchUserActivity, 2131952345), Arrays.copyOf(new Object[]{contactsLikeEachItem.getUserBase().getNick()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format5, "format(...)");
                    tipDialog3.setTipContent(format5).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.cp.SearchUserActivity$initView$8$3
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            SearchViewModel viewModel2;
                            ContactsLikeEachItem contactsLikeEachItem2 = ContactsLikeEachItem.this;
                            viewModel2 = searchUserActivity.getViewModel();
                            contactsLikeEachItem2.setType(viewModel2.getMData());
                            cf.c.c().l(new BagEvent("bag_send", ContactsLikeEachItem.this));
                            searchUserActivity.finish();
                        }
                    }).show();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static final SearchUserAdapter mMemberAdapter_delegate$lambda$0() {
        return new SearchUserAdapter();
    }

    public static final SearchViewModel viewModel_delegate$lambda$1(SearchUserActivity searchUserActivity) {
        return new ViewModelProvider(searchUserActivity).get(SearchViewModel.class);
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_search_user;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }
}
