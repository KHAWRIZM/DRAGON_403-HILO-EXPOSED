package com.qiahao.nextvideo.ui.family;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.family.FamilyCenterMember;
import com.qiahao.nextvideo.databinding.ActivityFamilyMemberBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.family.FamilyMoreDialog;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0014J\u001e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0013J\u001e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0013J\b\u0010\u001f\u001a\u00020\u0015H\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000f\u0010\u0010¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyMembersActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityFamilyMemberBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/ui/family/FamilyCenterViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/family/FamilyCenterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mFamilyInfo", "Lcom/qiahao/base_common/model/common/FamilyInfo;", "mMemberAdapter", "Lcom/qiahao/nextvideo/ui/family/FamilySearchMemberAdapter;", "getMMemberAdapter", "()Lcom/qiahao/nextvideo/ui/family/FamilySearchMemberAdapter;", "mMemberAdapter$delegate", "getLayoutResId", "", "onInitialize", "", "startUser", SupportGiftRankActivity.EXTERNAL_ID, "", "onResume", "quitFamily", "position", "userExtId", "type", "setFamilyAdmin", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFamilyMembersActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FamilyMembersActivity.kt\ncom/qiahao/nextvideo/ui/family/FamilyMembersActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,304:1\n61#2,9:305\n61#2,9:314\n61#2,9:323\n1#3:332\n*S KotlinDebug\n*F\n+ 1 FamilyMembersActivity.kt\ncom/qiahao/nextvideo/ui/family/FamilyMembersActivity\n*L\n84#1:305,9\n121#1:314,9\n125#1:323,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyMembersActivity extends HiloBaseBindingActivity<ActivityFamilyMemberBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String FAMILY_MY = "my_family";

    @Nullable
    private FamilyInfo mFamilyInfo;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.e2
        public final Object invoke() {
            FamilyCenterViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = FamilyMembersActivity.viewModel_delegate$lambda$0(FamilyMembersActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mMemberAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMemberAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.f2
        public final Object invoke() {
            FamilySearchMemberAdapter mMemberAdapter_delegate$lambda$1;
            mMemberAdapter_delegate$lambda$1 = FamilyMembersActivity.mMemberAdapter_delegate$lambda$1();
            return mMemberAdapter_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyMembersActivity$Companion;", "", "<init>", "()V", "FAMILY_MY", "", "startActivity", "", "context", "Landroid/content/Context;", "familyID", "Lcom/qiahao/base_common/model/common/FamilyInfo;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context, @NotNull FamilyInfo familyID) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(familyID, "familyID");
            Intent intent = new Intent(context, (Class<?>) FamilyMembersActivity.class);
            intent.putExtra(FamilyMembersActivity.FAMILY_MY, (Parcelable) familyID);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    private final FamilySearchMemberAdapter getMMemberAdapter() {
        return (FamilySearchMemberAdapter) this.mMemberAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FamilyCenterViewModel getViewModel() {
        return (FamilyCenterViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FamilySearchMemberAdapter mMemberAdapter_delegate$lambda$1() {
        return new FamilySearchMemberAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$11(FamilyMembersActivity familyMembersActivity, List list) {
        if (familyMembersActivity.getViewModel().getFamilyMemberListData().isOnePage()) {
            familyMembersActivity.getMMemberAdapter().setList(list);
        } else if (list != null) {
            familyMembersActivity.getMMemberAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b9, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0, r1) != false) goto L٣٣;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void onInitialize$lambda$12(final FamilyMembersActivity familyMembersActivity, BaseQuickAdapter baseQuickAdapter, View view, final int i) {
        Integer num;
        boolean z;
        boolean z2;
        String str;
        boolean z3;
        String str2;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        final FamilyCenterMember familyCenterMember = (FamilyCenterMember) familyMembersActivity.getMMemberAdapter().getData().get(i);
        FamilyInfo familyInfo = familyMembersActivity.mFamilyInfo;
        String str3 = null;
        if (familyInfo != null) {
            num = Integer.valueOf(familyInfo.getRole());
        } else {
            num = null;
        }
        boolean z4 = true;
        boolean z5 = false;
        if (num != null && num.intValue() == 2) {
            Integer role = familyCenterMember.getRole();
            if (role != null && role.intValue() == 3) {
                z = false;
                z2 = true;
            } else {
                if (role != null && role.intValue() == 1) {
                    z = true;
                    z2 = false;
                }
                z = false;
                z2 = false;
                z4 = false;
                z3 = false;
            }
            z4 = false;
            z5 = true;
            z3 = false;
        } else {
            if (num != null && num.intValue() == 3) {
                Integer role2 = familyCenterMember.getRole();
                if ((role2 == null || role2.intValue() != 2) && (role2 == null || role2.intValue() != 3)) {
                    if (role2 != null && role2.intValue() == 1) {
                        z = false;
                        z2 = false;
                        z4 = false;
                        z5 = true;
                        z3 = true;
                    }
                    z = false;
                    z2 = false;
                    z4 = false;
                    z3 = false;
                }
            } else {
                if (num != null && num.intValue() == 1) {
                    User user = familyCenterMember.getUser();
                    if (user != null) {
                        str = user.getExternalId();
                    } else {
                        str = null;
                    }
                    User user2 = UserStore.INSTANCE.getShared().getUser();
                    if (user2 != null) {
                        str3 = user2.getExternalId();
                    }
                }
                z = false;
                z2 = false;
                z3 = false;
            }
            z = false;
            z2 = false;
            z4 = false;
            z3 = true;
        }
        if (z4) {
            User user3 = familyCenterMember.getUser();
            if (user3 == null || (str2 = user3.getExternalId()) == null) {
                str2 = "";
            }
            familyMembersActivity.startUser(str2);
            return;
        }
        new FamilyMoreDialog(familyMembersActivity, z, z2, z5, z3, false, 32, null).setListener(new FamilyMoreDialog.FamilyMoreDialogListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyMembersActivity$onInitialize$12$1
            @Override // com.qiahao.nextvideo.ui.family.FamilyMoreDialog.FamilyMoreDialogListener
            public void clickType(String type) {
                String externalId;
                String externalId2;
                String externalId3;
                String externalId4;
                String externalId5;
                Intrinsics.checkNotNullParameter(type, "type");
                String str4 = "";
                switch (type.hashCode()) {
                    case -309425751:
                        if (type.equals(FamilyMoreDialog.CLICK_PROFILE)) {
                            FamilyMembersActivity familyMembersActivity2 = FamilyMembersActivity.this;
                            User user4 = familyCenterMember.getUser();
                            if (user4 != null && (externalId = user4.getExternalId()) != null) {
                                str4 = externalId;
                            }
                            familyMembersActivity2.startUser(str4);
                            return;
                        }
                        return;
                    case 3127582:
                        if (type.equals("exit")) {
                            FamilyMembersActivity familyMembersActivity3 = FamilyMembersActivity.this;
                            int i2 = i;
                            User user5 = familyCenterMember.getUser();
                            if (user5 != null && (externalId2 = user5.getExternalId()) != null) {
                                str4 = externalId2;
                            }
                            familyMembersActivity3.quitFamily(i2, str4, 1);
                            return;
                        }
                        return;
                    case 92668751:
                        if (type.equals(FamilyMoreDialog.CLICK_ADMIN)) {
                            FamilyMembersActivity familyMembersActivity4 = FamilyMembersActivity.this;
                            int i3 = i;
                            User user6 = familyCenterMember.getUser();
                            if (user6 != null && (externalId3 = user6.getExternalId()) != null) {
                                str4 = externalId3;
                            }
                            familyMembersActivity4.setFamilyAdmin(i3, str4, 1);
                            return;
                        }
                        return;
                    case 107947501:
                        if (type.equals(FamilyMoreDialog.CLICK_QUICK)) {
                            FamilyMembersActivity familyMembersActivity5 = FamilyMembersActivity.this;
                            int i4 = i;
                            User user7 = familyCenterMember.getUser();
                            if (user7 != null && (externalId4 = user7.getExternalId()) != null) {
                                str4 = externalId4;
                            }
                            familyMembersActivity5.quitFamily(i4, str4, 2);
                            return;
                        }
                        return;
                    case 1610573539:
                        if (type.equals(FamilyMoreDialog.CLICK_NOT_ADMIN)) {
                            FamilyMembersActivity familyMembersActivity6 = FamilyMembersActivity.this;
                            int i5 = i;
                            User user8 = familyCenterMember.getUser();
                            if (user8 != null && (externalId5 = user8.getExternalId()) != null) {
                                str4 = externalId5;
                            }
                            familyMembersActivity6.setFamilyAdmin(i5, str4, 2);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onInitialize$lambda$4(FamilyMembersActivity familyMembersActivity, TextView textView, int i, KeyEvent keyEvent) {
        long j;
        Long id2;
        if ((i == 3 || (keyEvent != null && 66 == keyEvent.getKeyCode() && keyEvent.getAction() == 0)) && FastClickOneUtils.INSTANCE.isFastClick() && !TextUtils.isEmpty(familyMembersActivity.getBinding().searchEditText.getText())) {
            familyMembersActivity.getViewModel().getFamilyMemberListData().resetPage();
            FamilyCenterViewModel viewModel = familyMembersActivity.getViewModel();
            String obj = familyMembersActivity.getBinding().searchEditText.getText().toString();
            FamilyInfo familyInfo = familyMembersActivity.mFamilyInfo;
            if (familyInfo != null && (id2 = familyInfo.getId()) != null) {
                j = id2.longValue();
            } else {
                j = 0;
            }
            viewModel.familyMemberList(obj, j);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$5(FamilyMembersActivity familyMembersActivity, tc.f fVar) {
        long j;
        Long id2;
        Intrinsics.checkNotNullParameter(fVar, "it");
        familyMembersActivity.getViewModel().getFamilyMemberListData().resetPage();
        FamilyCenterViewModel viewModel = familyMembersActivity.getViewModel();
        String obj = familyMembersActivity.getBinding().searchEditText.getText().toString();
        FamilyInfo familyInfo = familyMembersActivity.mFamilyInfo;
        if (familyInfo != null && (id2 = familyInfo.getId()) != null) {
            j = id2.longValue();
        } else {
            j = 0;
        }
        viewModel.familyMemberList(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$6(FamilyMembersActivity familyMembersActivity, tc.f fVar) {
        long j;
        Long id2;
        Intrinsics.checkNotNullParameter(fVar, "it");
        FamilyCenterViewModel viewModel = familyMembersActivity.getViewModel();
        FamilyInfo familyInfo = familyMembersActivity.mFamilyInfo;
        if (familyInfo != null && (id2 = familyInfo.getId()) != null) {
            j = id2.longValue();
        } else {
            j = 0;
        }
        FamilyCenterViewModel.familyMemberList$default(viewModel, null, j, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$9(FamilyMembersActivity familyMembersActivity, Integer num) {
        if (num.intValue() > 0) {
            familyMembersActivity.getBinding().number.setText(num.toString());
            familyMembersActivity.getBinding().number.setVisibility(0);
        } else {
            familyMembersActivity.getBinding().number.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit quitFamily$lambda$15(FamilyMembersActivity familyMembersActivity, int i, int i2, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (i2 == 1) {
            FamilyInfo familyInfo = familyMembersActivity.mFamilyInfo;
            if (familyInfo != null) {
                familyInfo.setRole(0);
            }
            familyMembersActivity.getBinding().newMembersLayout.setVisibility(8);
        }
        familyMembersActivity.getMMemberAdapter().removeAt(i);
        HiloBaseActivity.dismissProgressDialog$default(familyMembersActivity, false, new Function0() { // from class: com.qiahao.nextvideo.ui.family.u1
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit quitFamily$lambda$17(FamilyMembersActivity familyMembersActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(familyMembersActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, familyMembersActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        HiloBaseActivity.dismissProgressDialog$default(familyMembersActivity, false, new Function0() { // from class: com.qiahao.nextvideo.ui.family.d2
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit setFamilyAdmin$lambda$20(FamilyMembersActivity familyMembersActivity, int i, int i2, ApiResponse apiResponse) {
        int i3;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        FamilyCenterMember familyCenterMember = (FamilyCenterMember) familyMembersActivity.getMMemberAdapter().getData().get(i);
        if (i2 == 1) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        familyCenterMember.setRole(i3);
        familyMembersActivity.getMMemberAdapter().getData().set(i, familyCenterMember);
        familyMembersActivity.getMMemberAdapter().notifyItemChanged(i);
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, familyMembersActivity, ResourcesKtxKt.getStringById(familyMembersActivity, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        HiloBaseActivity.dismissProgressDialog$default(familyMembersActivity, false, new Function0() { // from class: com.qiahao.nextvideo.ui.family.g2
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit setFamilyAdmin$lambda$22(FamilyMembersActivity familyMembersActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(familyMembersActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, familyMembersActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        HiloBaseActivity.dismissProgressDialog$default(familyMembersActivity, false, new Function0() { // from class: com.qiahao.nextvideo.ui.family.c2
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startUser(String externalId) {
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openPersonPage(externalId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FamilyCenterViewModel viewModel_delegate$lambda$0(FamilyMembersActivity familyMembersActivity) {
        return new ViewModelProvider(familyMembersActivity).get(FamilyCenterViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_family_member;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        getViewModel().getFamilyMemberListData().destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        Toolbar toolbar = ((ActivityFamilyMemberBinding) getBinding()).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        setStatusBarTopOrBottom(toolbar, false);
        FamilyInfo parcelableExtra = getIntent().getParcelableExtra(FAMILY_MY);
        this.mFamilyInfo = parcelableExtra;
        if (parcelableExtra == null) {
            finish();
        }
        FamilyInfo familyInfo = this.mFamilyInfo;
        if (familyInfo != null) {
            if (familyInfo.getRole() != 3 && familyInfo.getRole() != 2) {
                ((ActivityFamilyMemberBinding) getBinding()).newMembersLayout.setVisibility(8);
                ((ActivityFamilyMemberBinding) getBinding()).exitImage.setVisibility(8);
            } else {
                ((ActivityFamilyMemberBinding) getBinding()).newMembersLayout.setVisibility(0);
                ((ActivityFamilyMemberBinding) getBinding()).exitImage.setVisibility(0);
            }
        }
        ((ActivityFamilyMemberBinding) getBinding()).recyclerView.setAdapter(getMMemberAdapter());
        ((ActivityFamilyMemberBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        getViewModel().getFamilyMemberListData().registerStatusLayoutAndRefreshLayout(((ActivityFamilyMemberBinding) getBinding()).refreshLayout, ((ActivityFamilyMemberBinding) getBinding()).statusView);
        final AppCompatImageView appCompatImageView = ((ActivityFamilyMemberBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyMembersActivity$onInitialize$$inlined$singleClick$default$1
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
        ((ActivityFamilyMemberBinding) getBinding()).searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.qiahao.nextvideo.ui.family.h2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean onInitialize$lambda$4;
                onInitialize$lambda$4 = FamilyMembersActivity.onInitialize$lambda$4(FamilyMembersActivity.this, textView, i, keyEvent);
                return onInitialize$lambda$4;
            }
        });
        ((ActivityFamilyMemberBinding) getBinding()).searchEditText.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.ui.family.FamilyMembersActivity$onInitialize$4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                FamilyCenterViewModel viewModel;
                FamilyCenterViewModel viewModel2;
                ActivityFamilyMemberBinding binding;
                FamilyInfo familyInfo2;
                long j2;
                Long id2;
                if (TextUtils.isEmpty(s) && HiloUtils.INSTANCE.notFastClick()) {
                    viewModel = FamilyMembersActivity.this.getViewModel();
                    viewModel.getFamilyMemberListData().resetPage();
                    viewModel2 = FamilyMembersActivity.this.getViewModel();
                    binding = FamilyMembersActivity.this.getBinding();
                    String obj = binding.searchEditText.getText().toString();
                    familyInfo2 = FamilyMembersActivity.this.mFamilyInfo;
                    if (familyInfo2 != null && (id2 = familyInfo2.getId()) != null) {
                        j2 = id2.longValue();
                    } else {
                        j2 = 0;
                    }
                    viewModel2.familyMemberList(obj, j2);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        ((ActivityFamilyMemberBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.family.i2
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                FamilyMembersActivity.onInitialize$lambda$5(FamilyMembersActivity.this, fVar);
            }
        });
        ((ActivityFamilyMemberBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.family.j2
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                FamilyMembersActivity.onInitialize$lambda$6(FamilyMembersActivity.this, fVar);
            }
        });
        final LinearLayout linearLayout = ((ActivityFamilyMemberBinding) getBinding()).newMembersLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyMembersActivity$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout) > j || (linearLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(linearLayout, currentTimeMillis);
                    FamilyApplicationActivity.INSTANCE.startActivity(this);
                }
            }
        });
        final AppCompatImageView appCompatImageView2 = ((ActivityFamilyMemberBinding) getBinding()).exitImage;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyMembersActivity$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView2) > j || (appCompatImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView2, currentTimeMillis);
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    FamilyExitActivity.INSTANCE.startActivity(this);
                }
            }
        });
        ((ActivityFamilyMemberBinding) getBinding()).number.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, this, 2131101137, 2131101137, 20, (GradientDrawable.Orientation) null, false, 48, (Object) null));
        getViewModel().getFamilyNumber().observe(this, new FamilyMembersActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.k2
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$9;
                onInitialize$lambda$9 = FamilyMembersActivity.onInitialize$lambda$9(FamilyMembersActivity.this, (Integer) obj);
                return onInitialize$lambda$9;
            }
        }));
        ((ActivityFamilyMemberBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyMembersActivity$onInitialize$10
            public void onRetry(IStatusView statusView, Status status) {
                FamilyCenterViewModel viewModel;
                FamilyCenterViewModel viewModel2;
                ActivityFamilyMemberBinding binding;
                FamilyInfo familyInfo2;
                long j2;
                Long id2;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                viewModel = FamilyMembersActivity.this.getViewModel();
                viewModel.getFamilyMemberListData().resetPage();
                viewModel2 = FamilyMembersActivity.this.getViewModel();
                binding = FamilyMembersActivity.this.getBinding();
                String obj = binding.searchEditText.getText().toString();
                familyInfo2 = FamilyMembersActivity.this.mFamilyInfo;
                if (familyInfo2 != null && (id2 = familyInfo2.getId()) != null) {
                    j2 = id2.longValue();
                } else {
                    j2 = 0;
                }
                viewModel2.familyMemberList(obj, j2);
            }
        });
        getViewModel().getFamilyMemberList().observe(this, new FamilyMembersActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.l2
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$11;
                onInitialize$lambda$11 = FamilyMembersActivity.onInitialize$lambda$11(FamilyMembersActivity.this, (List) obj);
                return onInitialize$lambda$11;
            }
        }));
        getMMemberAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.family.v1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FamilyMembersActivity.onInitialize$lambda$12(FamilyMembersActivity.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onResume() {
        long j;
        Long id2;
        super.onResume();
        getViewModel().getFamilyMemberListData().resetPage();
        getViewModel().familyApplicationNumber();
        FamilyCenterViewModel viewModel = getViewModel();
        String obj = getBinding().searchEditText.getText().toString();
        FamilyInfo familyInfo = this.mFamilyInfo;
        if (familyInfo != null && (id2 = familyInfo.getId()) != null) {
            j = id2.longValue();
        } else {
            j = 0;
        }
        viewModel.familyMemberList(obj, j);
    }

    public final void quitFamily(final int position, @NotNull String userExtId, final int type) {
        Intrinsics.checkNotNullParameter(userExtId, "userExtId");
        HiloBaseActivity.showProgressDialog$default((HiloBaseActivity) this, (String) null, false, new Function0() { // from class: com.qiahao.nextvideo.ui.family.z1
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 3, (Object) null);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().quitFamily(userExtId, type), new Function1() { // from class: com.qiahao.nextvideo.ui.family.a2
            public final Object invoke(Object obj) {
                Unit quitFamily$lambda$15;
                quitFamily$lambda$15 = FamilyMembersActivity.quitFamily$lambda$15(FamilyMembersActivity.this, position, type, (ApiResponse) obj);
                return quitFamily$lambda$15;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.family.b2
            public final Object invoke(Object obj) {
                Unit quitFamily$lambda$17;
                quitFamily$lambda$17 = FamilyMembersActivity.quitFamily$lambda$17(FamilyMembersActivity.this, (Throwable) obj);
                return quitFamily$lambda$17;
            }
        }, (Function0) null, false, 12, (Object) null), getViewModel().getMCompositeDisposable());
    }

    public final void setFamilyAdmin(final int position, @NotNull String userExtId, final int type) {
        Intrinsics.checkNotNullParameter(userExtId, "userExtId");
        HiloBaseActivity.showProgressDialog$default((HiloBaseActivity) this, (String) null, false, new Function0() { // from class: com.qiahao.nextvideo.ui.family.w1
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 3, (Object) null);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().setFamilyAdmin(userExtId, type), new Function1() { // from class: com.qiahao.nextvideo.ui.family.x1
            public final Object invoke(Object obj) {
                Unit familyAdmin$lambda$20;
                familyAdmin$lambda$20 = FamilyMembersActivity.setFamilyAdmin$lambda$20(FamilyMembersActivity.this, position, type, (ApiResponse) obj);
                return familyAdmin$lambda$20;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.family.y1
            public final Object invoke(Object obj) {
                Unit familyAdmin$lambda$22;
                familyAdmin$lambda$22 = FamilyMembersActivity.setFamilyAdmin$lambda$22(FamilyMembersActivity.this, (Throwable) obj);
                return familyAdmin$lambda$22;
            }
        }, (Function0) null, false, 12, (Object) null), getViewModel().getMCompositeDisposable());
    }
}
