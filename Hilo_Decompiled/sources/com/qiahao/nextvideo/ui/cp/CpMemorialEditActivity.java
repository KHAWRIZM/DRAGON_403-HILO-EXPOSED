package com.qiahao.nextvideo.ui.cp;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.cp.CpInfo;
import com.qiahao.base_common.model.cp.CpMemorial;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.utils.DatePickerBuilder;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityCpMemorialEditBinding;
import com.qiahao.nextvideo.ui.reusable.views.SwitchButton;
import java.util.Calendar;
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

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpMemorialEditActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityCpMemorialEditBinding;", "<init>", "()V", "cpMemorial", "Lcom/qiahao/base_common/model/cp/CpMemorial;", "viewModel", "Lcom/qiahao/nextvideo/ui/cp/CpMemorialViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/cp/CpMemorialViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "showTimeDialog", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCpMemorialEditActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpMemorialEditActivity.kt\ncom/qiahao/nextvideo/ui/cp/CpMemorialEditActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,143:1\n61#2,9:144\n61#2,9:153\n61#2,9:162\n*S KotlinDebug\n*F\n+ 1 CpMemorialEditActivity.kt\ncom/qiahao/nextvideo/ui/cp/CpMemorialEditActivity\n*L\n75#1:144,9\n94#1:153,9\n114#1:162,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpMemorialEditActivity extends HiloBaseBindingActivity<ActivityCpMemorialEditBinding> {

    @NotNull
    public static final String CP_MEMORIAL = "CpMemorial";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private CpMemorial cpMemorial;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.cp.c0
        public final Object invoke() {
            CpMemorialViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = CpMemorialEditActivity.viewModel_delegate$lambda$0(CpMemorialEditActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpMemorialEditActivity$Companion;", "", "<init>", "()V", "CP_MEMORIAL", "", "startActivity", "", "context", "Landroid/content/Context;", "data", "Lcom/qiahao/base_common/model/cp/CpMemorial;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void startActivity$default(Companion companion, Context context, CpMemorial cpMemorial, int i, Object obj) {
            if ((i & 2) != 0) {
                cpMemorial = null;
            }
            companion.startActivity(context, cpMemorial);
        }

        public final void startActivity(@NotNull Context context, @Nullable CpMemorial data) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) CpMemorialEditActivity.class);
            intent.putExtra(CpMemorialEditActivity.CP_MEMORIAL, (Parcelable) data);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CpMemorialViewModel getViewModel() {
        return (CpMemorialViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getMSuccess().observe(this, new CpMemorialEditActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.d0
            public final Object invoke(Object obj) {
                Unit initData$lambda$1;
                initData$lambda$1 = CpMemorialEditActivity.initData$lambda$1(CpMemorialEditActivity.this, (Pair) obj);
                return initData$lambda$1;
            }
        }));
        getViewModel().getError().observe(this, new CpMemorialEditActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.e0
            public final Object invoke(Object obj) {
                Unit initData$lambda$2;
                initData$lambda$2 = CpMemorialEditActivity.initData$lambda$2(CpMemorialEditActivity.this, (Throwable) obj);
                return initData$lambda$2;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$1(CpMemorialEditActivity cpMemorialEditActivity, Pair pair) {
        String str = (String) pair.getFirst();
        if (Intrinsics.areEqual(str, CpMemorialViewModel.POST_MEMORIAL) || Intrinsics.areEqual(str, CpMemorialViewModel.UPDATE_MEMORIAL)) {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, cpMemorialEditActivity, ResourcesKtxKt.getStringById(cpMemorialEditActivity, 2131954177), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            cpMemorialEditActivity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$2(CpMemorialEditActivity cpMemorialEditActivity, Throwable th) {
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(cpMemorialEditActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, cpMemorialEditActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        long j;
        boolean z;
        CpMemorial parcelableExtra = getIntent().getParcelableExtra(CP_MEMORIAL);
        if (parcelableExtra == null) {
            parcelableExtra = new CpMemorial((Boolean) null, (String) null, (CpInfo) null, (Long) null, (Integer) null, Boolean.TRUE, 0, false, (Long) null, 479, (DefaultConstructorMarker) null);
        }
        this.cpMemorial = parcelableExtra;
        View view = ((ActivityCpMemorialEditBinding) getBinding()).titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.cp.a0
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$3;
                initView$lambda$3 = CpMemorialEditActivity.initView$lambda$3(CpMemorialEditActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$3;
            }
        });
        final AppCompatImageView appCompatImageView = ((ActivityCpMemorialEditBinding) getBinding()).titleBar.backImageView;
        final long j2 = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpMemorialEditActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j2 || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.finish();
                }
            }
        });
        ((ActivityCpMemorialEditBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.getStringById(this, 2131952409));
        CpMemorial cpMemorial = this.cpMemorial;
        if (cpMemorial != null) {
            AppCompatEditText appCompatEditText = ((ActivityCpMemorialEditBinding) getBinding()).editText;
            String content = cpMemorial.getContent();
            if (content == null) {
                content = "";
            }
            appCompatEditText.setText(content, TextView.BufferType.EDITABLE);
            Long timestamp = cpMemorial.getTimestamp();
            long j3 = 0;
            if (timestamp != null) {
                j = timestamp.longValue();
            } else {
                j = 0;
            }
            if (j > 0) {
                TextView textView = ((ActivityCpMemorialEditBinding) getBinding()).time;
                Long timestamp2 = cpMemorial.getTimestamp();
                if (timestamp2 != null) {
                    j3 = timestamp2.longValue();
                }
                textView.setText(com.qiahao.base_common.utils.f.h(j3 * 1000, com.qiahao.base_common.utils.f.b));
            }
            SwitchButton switchButton = ((ActivityCpMemorialEditBinding) getBinding()).switchView;
            Boolean isRemind = cpMemorial.isRemind();
            if (isRemind != null) {
                z = isRemind.booleanValue();
            } else {
                z = false;
            }
            switchButton.setChecked(z);
        }
        ((ActivityCpMemorialEditBinding) getBinding()).switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.qiahao.nextvideo.ui.cp.b0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                CpMemorialEditActivity.initView$lambda$6(CpMemorialEditActivity.this, compoundButton, z2);
            }
        });
        final TextView textView2 = ((ActivityCpMemorialEditBinding) getBinding()).save;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpMemorialEditActivity$initView$$inlined$singleClick$default$2
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0065, code lost:
            
                r10 = r4.cpMemorial;
             */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void onClick(View view2) {
                ActivityCpMemorialEditBinding binding;
                CpMemorial cpMemorial2;
                long j4;
                CpMemorial cpMemorial3;
                Integer num;
                CpMemorialViewModel viewModel;
                ActivityCpMemorialEditBinding binding2;
                CpMemorial cpMemorial4;
                CpMemorial cpMemorial5;
                Boolean isRemind2;
                Long timestamp3;
                CpMemorial cpMemorial6;
                CpMemorialViewModel viewModel2;
                ActivityCpMemorialEditBinding binding3;
                CpMemorial cpMemorial7;
                CpMemorial cpMemorial8;
                boolean z2;
                CpMemorial cpMemorial9;
                int i;
                Integer id2;
                Boolean isRemind3;
                Long timestamp4;
                Integer id3;
                Long timestamp5;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j2 || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    this.hideSoftInput();
                    binding = this.getBinding();
                    if (!TextUtils.isEmpty(binding.editText.getText())) {
                        cpMemorial2 = this.cpMemorial;
                        long j5 = 0;
                        if (cpMemorial2 != null && (timestamp5 = cpMemorial2.getTimestamp()) != null) {
                            j4 = timestamp5.longValue();
                        } else {
                            j4 = 0;
                        }
                        if (j4 != 0) {
                            cpMemorial3 = this.cpMemorial;
                            if (cpMemorial3 != null) {
                                num = cpMemorial3.getId();
                            } else {
                                num = null;
                            }
                            boolean z3 = false;
                            if (num == null || (cpMemorial6 != null && (id3 = cpMemorial6.getId()) != null && id3.intValue() == 0)) {
                                viewModel = this.getViewModel();
                                binding2 = this.getBinding();
                                String valueOf = String.valueOf(binding2.editText.getText());
                                cpMemorial4 = this.cpMemorial;
                                if (cpMemorial4 != null && (timestamp3 = cpMemorial4.getTimestamp()) != null) {
                                    j5 = timestamp3.longValue();
                                }
                                cpMemorial5 = this.cpMemorial;
                                if (cpMemorial5 != null && (isRemind2 = cpMemorial5.isRemind()) != null) {
                                    z3 = isRemind2.booleanValue();
                                }
                                viewModel.postCpMemorial(valueOf, j5, z3);
                                return;
                            }
                            viewModel2 = this.getViewModel();
                            binding3 = this.getBinding();
                            String valueOf2 = String.valueOf(binding3.editText.getText());
                            cpMemorial7 = this.cpMemorial;
                            if (cpMemorial7 != null && (timestamp4 = cpMemorial7.getTimestamp()) != null) {
                                j5 = timestamp4.longValue();
                            }
                            long j6 = j5;
                            cpMemorial8 = this.cpMemorial;
                            if (cpMemorial8 != null && (isRemind3 = cpMemorial8.isRemind()) != null) {
                                z2 = isRemind3.booleanValue();
                            } else {
                                z2 = false;
                            }
                            cpMemorial9 = this.cpMemorial;
                            if (cpMemorial9 != null && (id2 = cpMemorial9.getId()) != null) {
                                i = id2.intValue();
                            } else {
                                i = 0;
                            }
                            viewModel2.updateCpMemorial(valueOf2, j6, z2, i);
                        }
                    }
                }
            }
        });
        final TextView textView3 = ((ActivityCpMemorialEditBinding) getBinding()).time;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpMemorialEditActivity$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j2 || (textView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                    this.hideSoftInput();
                    this.showTimeDialog();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$3(CpMemorialEditActivity cpMemorialEditActivity, int i, int i2) {
        cpMemorialEditActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(CpMemorialEditActivity cpMemorialEditActivity, CompoundButton compoundButton, boolean z) {
        cpMemorialEditActivity.hideSoftInput();
        CpMemorial cpMemorial = cpMemorialEditActivity.cpMemorial;
        if (cpMemorial != null) {
            cpMemorial.setRemind(Boolean.valueOf(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showTimeDialog() {
        long j;
        Long timestamp;
        Long timestamp2;
        Calendar calendar = Calendar.getInstance();
        CpMemorial cpMemorial = this.cpMemorial;
        long j2 = 0;
        if (cpMemorial != null && (timestamp2 = cpMemorial.getTimestamp()) != null) {
            j = timestamp2.longValue();
        } else {
            j = 0;
        }
        if (j > 0) {
            CpMemorial cpMemorial2 = this.cpMemorial;
            if (cpMemorial2 != null && (timestamp = cpMemorial2.getTimestamp()) != null) {
                j2 = timestamp.longValue();
            }
            calendar.setTimeInMillis(j2 * 1000);
        }
        DatePickerBuilder rangDate = new DatePickerBuilder(this).setOnDateConfirmListener(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.z
            public final Object invoke(Object obj) {
                Unit showTimeDialog$lambda$9;
                showTimeDialog$lambda$9 = CpMemorialEditActivity.showTimeDialog$lambda$9(CpMemorialEditActivity.this, ((Long) obj).longValue());
                return showTimeDialog$lambda$9;
            }
        }).setInterceptToasty(false).setType(new boolean[]{true, true, true, false, false, false}).setTitle("").setRangDate((Calendar) null, (Calendar) null);
        Intrinsics.checkNotNull(calendar);
        rangDate.setDate(calendar).create().t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showTimeDialog$lambda$9(CpMemorialEditActivity cpMemorialEditActivity, long j) {
        CpMemorial cpMemorial = cpMemorialEditActivity.cpMemorial;
        if (cpMemorial != null) {
            cpMemorial.setTimestamp(Long.valueOf(j / 1000));
        }
        cpMemorialEditActivity.getBinding().time.setText(com.qiahao.base_common.utils.f.h(j, com.qiahao.base_common.utils.f.b));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CpMemorialViewModel viewModel_delegate$lambda$0(CpMemorialEditActivity cpMemorialEditActivity) {
        return new ViewModelProvider(cpMemorialEditActivity).get(CpMemorialViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_cp_memorial_edit;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }
}
