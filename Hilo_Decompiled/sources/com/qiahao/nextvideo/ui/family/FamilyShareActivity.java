package com.qiahao.nextvideo.ui.family;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.model.im.InviteFamilyMessage;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.model.ContactsLikeEachItem;
import com.qiahao.nextvideo.databinding.ActivityFamilyShareBinding;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.qiahao.nextvideo.utilities.im.ImMessageUtil;
import java.util.Collection;
import java.util.List;
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

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyShareActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityFamilyShareBinding;", "<init>", "()V", "mMemberAdapter", "Lcom/qiahao/nextvideo/ui/family/FamilyShareAdapter;", "getMMemberAdapter", "()Lcom/qiahao/nextvideo/ui/family/FamilyShareAdapter;", "mMemberAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/qiahao/nextvideo/ui/family/FamilyCenterViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/family/FamilyCenterViewModel;", "viewModel$delegate", "getLayoutResId", "", "onInitialize", "", "checkSelectData", "position", "startUser", SupportGiftRankActivity.EXTERNAL_ID, "", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFamilyShareActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FamilyShareActivity.kt\ncom/qiahao/nextvideo/ui/family/FamilyShareActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,198:1\n61#2,9:199\n61#2,9:208\n61#2,9:217\n1#3:226\n*S KotlinDebug\n*F\n+ 1 FamilyShareActivity.kt\ncom/qiahao/nextvideo/ui/family/FamilyShareActivity\n*L\n63#1:199,9\n68#1:208,9\n89#1:217,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyShareActivity extends HiloBaseBindingActivity<ActivityFamilyShareBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String FAMILY_INFO = "familyInfo";

    /* renamed from: mMemberAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMemberAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.u3
        public final Object invoke() {
            FamilyShareAdapter mMemberAdapter_delegate$lambda$0;
            mMemberAdapter_delegate$lambda$0 = FamilyShareActivity.mMemberAdapter_delegate$lambda$0();
            return mMemberAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.v3
        public final Object invoke() {
            FamilyCenterViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = FamilyShareActivity.viewModel_delegate$lambda$1(FamilyShareActivity.this);
            return viewModel_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyShareActivity$Companion;", "", "<init>", "()V", "FAMILY_INFO", "", "startActivity", "", "context", "Landroid/content/Context;", "familyInfo", "Lcom/qiahao/base_common/model/common/FamilyInfo;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context, @NotNull FamilyInfo familyInfo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(familyInfo, "familyInfo");
            Intent intent = new Intent(context, (Class<?>) FamilyShareActivity.class);
            intent.putExtra("familyInfo", (Parcelable) familyInfo);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkSelectData(int position) {
        int i;
        ContactsLikeEachItem contactsLikeEachItem = (ContactsLikeEachItem) getMMemberAdapter().getData().get(position);
        if (contactsLikeEachItem.getIsSelect()) {
            getViewModel().getSelectData().put(contactsLikeEachItem.getUserBase().getExternalId(), contactsLikeEachItem);
        } else {
            getViewModel().getSelectData().remove(contactsLikeEachItem.getUserBase().getExternalId());
        }
        TextView textView = getBinding().shareBtn;
        int i2 = 8;
        if (getViewModel().getSelectData().size() > 0) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        TextView textView2 = getBinding().cancel;
        if (getViewModel().getSelectData().size() > 0) {
            i2 = 0;
        }
        textView2.setVisibility(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FamilyShareAdapter getMMemberAdapter() {
        return (FamilyShareAdapter) this.mMemberAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FamilyCenterViewModel getViewModel() {
        return (FamilyCenterViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FamilyShareAdapter mMemberAdapter_delegate$lambda$0() {
        return new FamilyShareAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$11(FamilyShareActivity familyShareActivity, List list) {
        if (familyShareActivity.getViewModel().getFamilyShareListData().isOnePage()) {
            familyShareActivity.getMMemberAdapter().setList(list);
        } else if (list != null) {
            familyShareActivity.getMMemberAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$13(FamilyShareActivity familyShareActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == 2131365539) {
            familyShareActivity.startUser(((ContactsLikeEachItem) familyShareActivity.getMMemberAdapter().getData().get(i)).getUserBase().getExternalId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$14(FamilyShareActivity familyShareActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        ContactsLikeEachItem contactsLikeEachItem = (ContactsLikeEachItem) familyShareActivity.getMMemberAdapter().getData().get(i);
        contactsLikeEachItem.setSelect(!contactsLikeEachItem.getIsSelect());
        familyShareActivity.getMMemberAdapter().getData().set(i, contactsLikeEachItem);
        familyShareActivity.checkSelectData(i);
        familyShareActivity.getMMemberAdapter().notifyItemChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onInitialize$lambda$7(FamilyShareActivity familyShareActivity, TextView textView, int i, KeyEvent keyEvent) {
        if ((i == 3 || (keyEvent != null && 66 == keyEvent.getKeyCode() && keyEvent.getAction() == 0)) && FastClickOneUtils.INSTANCE.isFastClick() && !TextUtils.isEmpty(familyShareActivity.getBinding().searchEditText.getText())) {
            familyShareActivity.getViewModel().getFamilyShareListData().resetPage();
            familyShareActivity.getViewModel().searchFriends(familyShareActivity.getBinding().searchEditText.getText().toString(), 1);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$8(FamilyShareActivity familyShareActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        familyShareActivity.getViewModel().getFamilyShareListData().resetPage();
        familyShareActivity.getViewModel().familyShareList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$9(FamilyShareActivity familyShareActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        familyShareActivity.getViewModel().familyShareList();
    }

    private final void startUser(String externalId) {
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openPersonPage(externalId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FamilyCenterViewModel viewModel_delegate$lambda$1(FamilyShareActivity familyShareActivity) {
        return new ViewModelProvider(familyShareActivity).get(FamilyCenterViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_family_share;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        getViewModel().getFamilyShareListData().destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        Toolbar toolbar = ((ActivityFamilyShareBinding) getBinding()).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        setStatusBarTopOrBottom(toolbar, false);
        getViewModel().setFamilyInfoData((FamilyInfo) getIntent().getParcelableExtra("familyInfo"));
        final AppCompatImageView appCompatImageView = ((ActivityFamilyShareBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyShareActivity$onInitialize$$inlined$singleClick$default$1
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
        final TextView textView = ((ActivityFamilyShareBinding) getBinding()).shareBtn;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyShareActivity$onInitialize$$inlined$singleClick$default$2
            /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, com.qiahao.nextvideo.ui.family.FamilyShareActivity] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyCenterViewModel viewModel;
                FamilyCenterViewModel viewModel2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    viewModel = this.getViewModel();
                    FamilyInfo familyInfoData = viewModel.getFamilyInfoData();
                    if (familyInfoData != null) {
                        ?? r1 = this;
                        viewModel2 = r1.getViewModel();
                        FamilyShareDialog familyShareDialog = new FamilyShareDialog(r1, familyInfoData, viewModel2.getSelectData().size());
                        final FamilyShareActivity familyShareActivity = this;
                        familyShareDialog.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyShareActivity$onInitialize$2$1$1
                            public void cancel() {
                                OnCommonDialogListener.DefaultImpls.cancel(this);
                            }

                            /* JADX WARN: Type inference failed for: r1v1, types: [android.content.Context, com.qiahao.nextvideo.ui.family.FamilyShareActivity, android.app.Activity] */
                            public void confirm() {
                                FamilyCenterViewModel viewModel3;
                                FamilyCenterViewModel viewModel4;
                                long j2;
                                FamilyCenterViewModel viewModel5;
                                String str;
                                Long id2;
                                viewModel3 = FamilyShareActivity.this.getViewModel();
                                Collection<ContactsLikeEachItem> values = viewModel3.getSelectData().values();
                                Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
                                ?? r12 = FamilyShareActivity.this;
                                for (ContactsLikeEachItem contactsLikeEachItem : values) {
                                    ImMessageUtil imMessageUtil = ImMessageUtil.INSTANCE;
                                    String externalId = contactsLikeEachItem.getUserBase().getExternalId();
                                    viewModel4 = r12.getViewModel();
                                    FamilyInfo familyInfoData2 = viewModel4.getFamilyInfoData();
                                    if (familyInfoData2 != null && (id2 = familyInfoData2.getId()) != null) {
                                        j2 = id2.longValue();
                                    } else {
                                        j2 = 0;
                                    }
                                    Long valueOf = Long.valueOf(j2);
                                    viewModel5 = r12.getViewModel();
                                    FamilyInfo familyInfoData3 = viewModel5.getFamilyInfoData();
                                    if (familyInfoData3 == null || (str = familyInfoData3.getIcon()) == null) {
                                        str = "";
                                    }
                                    ImMessageUtil.sendC2CMessage$default(imMessageUtil, externalId, new InviteFamilyMessage("TIMFamilyInvitation", valueOf, str), ResourcesKtxKt.getStringById(this, 2131952675), null, 8, null);
                                    Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, (Context) r12, ResourcesKtxKt.getStringById(this, 2131954177), false, 4, (Object) null);
                                    if (normal$default != null) {
                                        normal$default.show();
                                    }
                                    r12.finish();
                                }
                            }
                        }).show();
                    }
                }
            }
        });
        final TextView textView2 = ((ActivityFamilyShareBinding) getBinding()).cancel;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyShareActivity$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyShareAdapter mMemberAdapter;
                FamilyShareAdapter mMemberAdapter2;
                FamilyShareAdapter mMemberAdapter3;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    mMemberAdapter = this.getMMemberAdapter();
                    int i = 0;
                    for (Object obj : mMemberAdapter.getData()) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        ContactsLikeEachItem contactsLikeEachItem = (ContactsLikeEachItem) obj;
                        if (contactsLikeEachItem.getIsSelect()) {
                            contactsLikeEachItem.setSelect(false);
                            mMemberAdapter2 = this.getMMemberAdapter();
                            mMemberAdapter2.getData().set(i, contactsLikeEachItem);
                            this.checkSelectData(i);
                            mMemberAdapter3 = this.getMMemberAdapter();
                            mMemberAdapter3.notifyItemChanged(i);
                        }
                        i = i2;
                    }
                }
            }
        });
        ((ActivityFamilyShareBinding) getBinding()).searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.qiahao.nextvideo.ui.family.w3
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView3, int i, KeyEvent keyEvent) {
                boolean onInitialize$lambda$7;
                onInitialize$lambda$7 = FamilyShareActivity.onInitialize$lambda$7(FamilyShareActivity.this, textView3, i, keyEvent);
                return onInitialize$lambda$7;
            }
        });
        ((ActivityFamilyShareBinding) getBinding()).searchEditText.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.ui.family.FamilyShareActivity$onInitialize$5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                FamilyCenterViewModel viewModel;
                FamilyCenterViewModel viewModel2;
                if (TextUtils.isEmpty(s) && HiloUtils.INSTANCE.notFastClick()) {
                    viewModel = FamilyShareActivity.this.getViewModel();
                    viewModel.getFamilyShareListData().resetPage();
                    viewModel2 = FamilyShareActivity.this.getViewModel();
                    viewModel2.familyShareList();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        ((ActivityFamilyShareBinding) getBinding()).recyclerView.setAdapter(getMMemberAdapter());
        ((ActivityFamilyShareBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        getViewModel().getFamilyShareListData().registerStatusLayoutAndRefreshLayout(((ActivityFamilyShareBinding) getBinding()).refreshLayout, ((ActivityFamilyShareBinding) getBinding()).statusView);
        ((ActivityFamilyShareBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.family.x3
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                FamilyShareActivity.onInitialize$lambda$8(FamilyShareActivity.this, fVar);
            }
        });
        ((ActivityFamilyShareBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.family.y3
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                FamilyShareActivity.onInitialize$lambda$9(FamilyShareActivity.this, fVar);
            }
        });
        ((ActivityFamilyShareBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyShareActivity$onInitialize$8
            public void onRetry(IStatusView statusView, Status status) {
                FamilyCenterViewModel viewModel;
                FamilyCenterViewModel viewModel2;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                viewModel = FamilyShareActivity.this.getViewModel();
                viewModel.getFamilyShareListData().resetPage();
                viewModel2 = FamilyShareActivity.this.getViewModel();
                viewModel2.familyShareList();
            }
        });
        getViewModel().getFamilyShareList().observe(this, new FamilyShareActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.z3
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$11;
                onInitialize$lambda$11 = FamilyShareActivity.onInitialize$lambda$11(FamilyShareActivity.this, (List) obj);
                return onInitialize$lambda$11;
            }
        }));
        getMMemberAdapter().addChildClickViewIds(new int[]{R.id.user_avatar_cimage_view});
        getMMemberAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.family.a4
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FamilyShareActivity.onInitialize$lambda$13(FamilyShareActivity.this, baseQuickAdapter, view, i);
            }
        });
        getMMemberAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.family.b4
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FamilyShareActivity.onInitialize$lambda$14(FamilyShareActivity.this, baseQuickAdapter, view, i);
            }
        });
        getViewModel().familyShareList();
    }
}
