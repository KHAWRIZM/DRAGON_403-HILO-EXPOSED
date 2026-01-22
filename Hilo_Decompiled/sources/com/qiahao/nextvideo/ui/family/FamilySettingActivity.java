package com.qiahao.nextvideo.ui.family;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.ViewModelProvider;
import com.oudi.core.utils.FragmentUtils;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityFamilySettingBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilySettingActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityFamilySettingBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/ui/family/FamilySettingViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/family/FamilySettingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "onInitialize", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilySettingActivity extends HiloBaseBindingActivity<ActivityFamilySettingBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String FAMILY_INFO = "familyInfo";

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.f3
        public final Object invoke() {
            FamilySettingViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = FamilySettingActivity.viewModel_delegate$lambda$0(FamilySettingActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilySettingActivity$Companion;", "", "<init>", "()V", "FAMILY_INFO", "", "startActivity", "", "context", "Landroid/content/Context;", "familyInfo", "Lcom/qiahao/base_common/model/common/FamilyInfo;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context, @NotNull FamilyInfo familyInfo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(familyInfo, "familyInfo");
            Intent intent = new Intent(context, (Class<?>) FamilySettingActivity.class);
            intent.putExtra("familyInfo", (Parcelable) familyInfo);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$1(FamilySettingActivity familySettingActivity, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        FamilySettingEditFragment familySettingEditFragment = new FamilySettingEditFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", str);
        int i = 15;
        if (!Intrinsics.areEqual(str, FamilySettingFragment.FAMILY_NAME) && !Intrinsics.areEqual(str, FamilySettingFragment.FAMILY_NAME_PLATE)) {
            i = 50;
        }
        bundle.putInt(FamilySettingFragment.FAMILY_NUMBER, i);
        familySettingEditFragment.setArguments(bundle);
        FragmentUtils.INSTANCE.addFragmentBackStack(familySettingActivity.getSupportFragmentManager(), R.id.frameLayout, familySettingEditFragment, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FamilySettingViewModel viewModel_delegate$lambda$0(FamilySettingActivity familySettingActivity) {
        return new ViewModelProvider(familySettingActivity).get(FamilySettingViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_family_setting;
    }

    @NotNull
    public final FamilySettingViewModel getViewModel() {
        return (FamilySettingViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        getViewModel().getFamilyInfo().setValue(getIntent().getParcelableExtra("familyInfo"));
        if (getViewModel().getFamilyInfo().getValue() == null) {
            finish();
        }
        FamilySettingFragment familySettingFragment = new FamilySettingFragment();
        familySettingFragment.setListener(new Function1() { // from class: com.qiahao.nextvideo.ui.family.e3
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$1;
                onInitialize$lambda$1 = FamilySettingActivity.onInitialize$lambda$1(FamilySettingActivity.this, (String) obj);
                return onInitialize$lambda$1;
            }
        });
        FragmentUtils.INSTANCE.addFragment(getSupportFragmentManager(), R.id.frameLayout, familySettingFragment, FamilySettingFragment.class.getName());
    }
}
