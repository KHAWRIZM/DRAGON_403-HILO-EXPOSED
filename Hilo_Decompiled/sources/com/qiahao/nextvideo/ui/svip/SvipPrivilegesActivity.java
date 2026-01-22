package com.qiahao.nextvideo.ui.svip;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.svip.Privilege;
import com.qiahao.base_common.model.svip.SvipInfo;
import com.qiahao.base_common.model.svip.SvipPrivilege;
import com.qiahao.base_common.model.svip.UserSvip;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.DeepCopy;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.ActivitySvipPrivilegesBinding;
import com.qiahao.nextvideo.databinding.ItemPrivilegesImageHeaderBinding;
import com.qiahao.nextvideo.ui.reusable.views.SwitchButton;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010/\u001a\u00020\fH\u0014J\b\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u000201H\u0002J\b\u00103\u001a\u000201H\u0002J\b\u00104\u001a\u000201H\u0003R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001f\u001a\u0004\b,\u0010-¨\u00066"}, d2 = {"Lcom/qiahao/nextvideo/ui/svip/SvipPrivilegesActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivitySvipPrivilegesBinding;", "<init>", "()V", "svipInfo", "Lcom/qiahao/base_common/model/svip/SvipInfo;", "getSvipInfo", "()Lcom/qiahao/base_common/model/svip/SvipInfo;", "setSvipInfo", "(Lcom/qiahao/base_common/model/svip/SvipInfo;)V", "mPosition", "", "getMPosition", "()I", "setMPosition", "(I)V", "mType", "getMType", "setMType", "myPrivilege", "Lcom/qiahao/base_common/model/svip/Privilege;", "getMyPrivilege", "()Lcom/qiahao/base_common/model/svip/Privilege;", "setMyPrivilege", "(Lcom/qiahao/base_common/model/svip/Privilege;)V", "viewModel", "Lcom/qiahao/nextvideo/ui/svip/SvipViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/svip/SvipViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mHeaderBinding", "Lcom/qiahao/nextvideo/databinding/ItemPrivilegesImageHeaderBinding;", "getMHeaderBinding", "()Lcom/qiahao/nextvideo/databinding/ItemPrivilegesImageHeaderBinding;", "mHeaderBinding$delegate", "mPrivilegesAdapter", "Lcom/qiahao/nextvideo/ui/svip/SvipPrivilegesDetailAdapter;", "getMPrivilegesAdapter", "()Lcom/qiahao/nextvideo/ui/svip/SvipPrivilegesDetailAdapter;", "mPrivilegesAdapter$delegate", "mImageAdapter", "Lcom/qiahao/nextvideo/ui/svip/SvipPrivilegesImageAdapter;", "getMImageAdapter", "()Lcom/qiahao/nextvideo/ui/svip/SvipPrivilegesImageAdapter;", "mImageAdapter$delegate", "getLayoutResId", "onInitialize", "", "initData", "initView", "refreshView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSvipPrivilegesActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SvipPrivilegesActivity.kt\ncom/qiahao/nextvideo/ui/svip/SvipPrivilegesActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,177:1\n1878#2,3:178\n1869#2,2:190\n61#3,9:181\n*S KotlinDebug\n*F\n+ 1 SvipPrivilegesActivity.kt\ncom/qiahao/nextvideo/ui/svip/SvipPrivilegesActivity\n*L\n86#1:178,3\n161#1:190,2\n144#1:181,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SvipPrivilegesActivity extends HiloBaseBindingActivity<ActivitySvipPrivilegesBinding> {

    @NotNull
    public static final String DATA = "data";

    @NotNull
    public static final String POSITION = "position";

    @NotNull
    public static final String TYPE = "type";
    private int mPosition;

    @Nullable
    private Privilege myPrivilege;

    @Nullable
    private SvipInfo svipInfo;
    private int mType = -1;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.svip.c0
        public final Object invoke() {
            SvipViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = SvipPrivilegesActivity.viewModel_delegate$lambda$0(SvipPrivilegesActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mHeaderBinding$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mHeaderBinding = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.svip.d0
        public final Object invoke() {
            ItemPrivilegesImageHeaderBinding mHeaderBinding_delegate$lambda$1;
            mHeaderBinding_delegate$lambda$1 = SvipPrivilegesActivity.mHeaderBinding_delegate$lambda$1(SvipPrivilegesActivity.this);
            return mHeaderBinding_delegate$lambda$1;
        }
    });

    /* renamed from: mPrivilegesAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPrivilegesAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.svip.e0
        public final Object invoke() {
            SvipPrivilegesDetailAdapter mPrivilegesAdapter_delegate$lambda$2;
            mPrivilegesAdapter_delegate$lambda$2 = SvipPrivilegesActivity.mPrivilegesAdapter_delegate$lambda$2();
            return mPrivilegesAdapter_delegate$lambda$2;
        }
    });

    /* renamed from: mImageAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mImageAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.svip.f0
        public final Object invoke() {
            SvipPrivilegesImageAdapter mImageAdapter_delegate$lambda$3;
            mImageAdapter_delegate$lambda$3 = SvipPrivilegesActivity.mImageAdapter_delegate$lambda$3();
            return mImageAdapter_delegate$lambda$3;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final ItemPrivilegesImageHeaderBinding getMHeaderBinding() {
        Object value = this.mHeaderBinding.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ItemPrivilegesImageHeaderBinding) value;
    }

    private final SvipPrivilegesImageAdapter getMImageAdapter() {
        return (SvipPrivilegesImageAdapter) this.mImageAdapter.getValue();
    }

    private final SvipPrivilegesDetailAdapter getMPrivilegesAdapter() {
        return (SvipPrivilegesDetailAdapter) this.mPrivilegesAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SvipViewModel getViewModel() {
        return (SvipViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initData() {
        int i;
        List svipPrivilege;
        SvipInfo svipInfo;
        List svipPrivilege2;
        UserSvip userSvip;
        Integer level;
        com.google.gson.d gson = BaseApplication.Companion.getGSON();
        String stringExtra = getIntent().getStringExtra("data");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.svipInfo = (SvipInfo) gson.j(stringExtra, SvipInfo.class);
        int i2 = 0;
        this.mPosition = getIntent().getIntExtra("position", 0);
        SvipPrivilegesDetailAdapter mPrivilegesAdapter = getMPrivilegesAdapter();
        SvipInfo svipInfo2 = this.svipInfo;
        if (svipInfo2 != null && (userSvip = svipInfo2.getUserSvip()) != null && (level = userSvip.getLevel()) != null) {
            i = level.intValue();
        } else {
            i = 0;
        }
        mPrivilegesAdapter.setMCurrentLevel(i);
        int intExtra = getIntent().getIntExtra("type", -1);
        this.mType = intExtra;
        if (intExtra > -1 && (svipInfo = this.svipInfo) != null && (svipPrivilege2 = svipInfo.getSvipPrivilege()) != null) {
            for (Object obj : svipPrivilege2) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (((SvipPrivilege) obj).getType() == this.mType) {
                    this.mPosition = i2;
                }
                i2 = i3;
            }
        }
        SvipInfo svipInfo3 = this.svipInfo;
        if (svipInfo3 != null && (svipPrivilege = svipInfo3.getSvipPrivilege()) != null) {
            getMPrivilegesAdapter().setSelectPosition(this.mPosition);
            getMPrivilegesAdapter().setList(svipPrivilege);
        }
        if (this.mPosition >= 6) {
            ((ActivitySvipPrivilegesBinding) getBinding()).recyclerView.scrollToPosition(this.mPosition);
        }
        refreshView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        ((ActivitySvipPrivilegesBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.getStringById(this, 2131954203));
        ((ActivitySvipPrivilegesBinding) getBinding()).titleBar.linearLayout.setBackgroundColor(androidx.core.content.a.getColor(this, 2131101214));
        View view = ((ActivitySvipPrivilegesBinding) getBinding()).titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.svip.w
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$6;
                initView$lambda$6 = SvipPrivilegesActivity.initView$lambda$6(SvipPrivilegesActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$6;
            }
        });
        ((ActivitySvipPrivilegesBinding) getBinding()).titleBar.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.svip.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SvipPrivilegesActivity.this.finish();
            }
        });
        ((ActivitySvipPrivilegesBinding) getBinding()).recyclerView.setAdapter(getMPrivilegesAdapter());
        getMPrivilegesAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.svip.y
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                SvipPrivilegesActivity.initView$lambda$8(SvipPrivilegesActivity.this, baseQuickAdapter, view2, i);
            }
        });
        getViewModel().getError().observe(this, new SvipPrivilegesActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.svip.z
            public final Object invoke(Object obj) {
                Unit initView$lambda$9;
                initView$lambda$9 = SvipPrivilegesActivity.initView$lambda$9(SvipPrivilegesActivity.this, (Throwable) obj);
                return initView$lambda$9;
            }
        }));
        getViewModel().getSuccess().observe(this, new SvipPrivilegesActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.svip.a0
            public final Object invoke(Object obj) {
                Unit initView$lambda$10;
                initView$lambda$10 = SvipPrivilegesActivity.initView$lambda$10(SvipPrivilegesActivity.this, (Boolean) obj);
                return initView$lambda$10;
            }
        }));
        getViewModel().getSvipInfo().observe(this, new SvipPrivilegesActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.svip.b0
            public final Object invoke(Object obj) {
                Unit initView$lambda$11;
                initView$lambda$11 = SvipPrivilegesActivity.initView$lambda$11(SvipPrivilegesActivity.this, (SvipInfo) obj);
                return initView$lambda$11;
            }
        }));
        SvipPrivilegesImageAdapter mImageAdapter = getMImageAdapter();
        View root = getMHeaderBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        BaseQuickAdapter.addHeaderView$default(mImageAdapter, root, 0, 0, 6, (Object) null);
        ((ActivitySvipPrivilegesBinding) getBinding()).imageRecyclerView.setAdapter(getMImageAdapter());
        final SwitchButton switchButton = getMHeaderBinding().selectButton;
        final long j = 800;
        switchButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.svip.SvipPrivilegesActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SvipViewModel viewModel;
                int i;
                ItemPrivilegesImageHeaderBinding mHeaderBinding;
                ItemPrivilegesImageHeaderBinding mHeaderBinding2;
                ItemPrivilegesImageHeaderBinding mHeaderBinding3;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(switchButton) > j || (switchButton instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(switchButton, currentTimeMillis);
                    int i2 = 1;
                    if (this.getMyPrivilege() != null) {
                        viewModel = this.getViewModel();
                        Privilege myPrivilege = this.getMyPrivilege();
                        if (myPrivilege != null) {
                            i = myPrivilege.getType();
                        } else {
                            i = 0;
                        }
                        mHeaderBinding = this.getMHeaderBinding();
                        if (!mHeaderBinding.selectButton.isChecked()) {
                            i2 = 2;
                        }
                        viewModel.privilegeOpen(i, i2);
                        return;
                    }
                    new TipDialog(this).setTipContent(ResourcesKtxKt.getStringById(this, 2131954195)).show();
                    mHeaderBinding2 = this.getMHeaderBinding();
                    SwitchButton switchButton2 = mHeaderBinding2.selectButton;
                    mHeaderBinding3 = this.getMHeaderBinding();
                    switchButton2.setChecked(true ^ mHeaderBinding3.selectButton.isChecked());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initView$lambda$10(SvipPrivilegesActivity svipPrivilegesActivity, Boolean bool) {
        UserStore.INSTANCE.getShared().fetchUserDetailInfo(true);
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, svipPrivilegesActivity, ResourcesKtxKt.getStringById(svipPrivilegesActivity, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$11(SvipPrivilegesActivity svipPrivilegesActivity, SvipInfo svipInfo) {
        svipPrivilegesActivity.svipInfo = svipInfo;
        svipPrivilegesActivity.getMPrivilegesAdapter().setList(svipInfo.getSvipPrivilege());
        svipPrivilegesActivity.refreshView();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$6(SvipPrivilegesActivity svipPrivilegesActivity, int i, int i2) {
        svipPrivilegesActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(SvipPrivilegesActivity svipPrivilegesActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        int selectPosition = svipPrivilegesActivity.getMPrivilegesAdapter().getSelectPosition();
        svipPrivilegesActivity.getMPrivilegesAdapter().setSelectPosition(i);
        svipPrivilegesActivity.getMPrivilegesAdapter().notifyItemChanged(selectPosition, 0);
        svipPrivilegesActivity.getMPrivilegesAdapter().notifyItemChanged(i, 0);
        svipPrivilegesActivity.refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initView$lambda$9(SvipPrivilegesActivity svipPrivilegesActivity, Throwable th) {
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(svipPrivilegesActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, svipPrivilegesActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ItemPrivilegesImageHeaderBinding mHeaderBinding_delegate$lambda$1(SvipPrivilegesActivity svipPrivilegesActivity) {
        return (ItemPrivilegesImageHeaderBinding) androidx.databinding.g.h(LayoutInflater.from(svipPrivilegesActivity), R.layout.item_privileges_image_header, (ViewGroup) null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SvipPrivilegesImageAdapter mImageAdapter_delegate$lambda$3() {
        return new SvipPrivilegesImageAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SvipPrivilegesDetailAdapter mPrivilegesAdapter_delegate$lambda$2() {
        return new SvipPrivilegesDetailAdapter();
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0118  */
    @SuppressLint({"SetTextI18n"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void refreshView() {
        SvipPrivilege svipPrivilege;
        String str;
        String str2;
        String mysteryCode;
        String mysteryCode2;
        UserSvip userSvip;
        List<Privilege> privileges;
        Integer num;
        Integer num2;
        Privilege privilege;
        List svipPrivilege2;
        SvipInfo svipInfo = this.svipInfo;
        ArrayList arrayList = null;
        if (svipInfo != null && (svipPrivilege2 = svipInfo.getSvipPrivilege()) != null) {
            svipPrivilege = (SvipPrivilege) svipPrivilege2.get(getMPrivilegesAdapter().getSelectPosition());
        } else {
            svipPrivilege = null;
        }
        SvipInfo svipInfo2 = this.svipInfo;
        if (svipInfo2 != null && (userSvip = svipInfo2.getUserSvip()) != null && (privileges = userSvip.getPrivileges()) != null) {
            for (Privilege privilege2 : privileges) {
                if (svipPrivilege != null) {
                    num = Integer.valueOf(svipPrivilege.getType());
                } else {
                    num = null;
                }
                if (privilege2 != null) {
                    num2 = Integer.valueOf(privilege2.getType());
                } else {
                    num2 = null;
                }
                if (Intrinsics.areEqual(num, num2)) {
                    if (privilege2 != null) {
                        privilege = (Privilege) DeepCopy.INSTANCE.deepCopy(privilege2);
                    } else {
                        privilege = null;
                    }
                    this.myPrivilege = privilege;
                }
            }
        }
        AppCompatTextView appCompatTextView = getBinding().title;
        String str3 = "";
        if (svipPrivilege == null || (str = svipPrivilege.getTitle()) == null) {
            str = "";
        }
        appCompatTextView.setText(str);
        if (svipPrivilege != null) {
            boolean z = true;
            if (svipPrivilege.getCanSwitch()) {
                getMHeaderBinding().getRoot().setVisibility(0);
                TextView textView = getMHeaderBinding().selectText;
                Privilege privilege3 = this.myPrivilege;
                if (privilege3 != null && (mysteryCode2 = privilege3.getMysteryCode()) != null) {
                    str2 = StringsKt.trim(mysteryCode2).toString();
                } else {
                    str2 = null;
                }
                if (str2 != null && str2.length() != 0) {
                    String title = svipPrivilege.getTitle();
                    if (title == null) {
                        title = "";
                    }
                    Privilege privilege4 = this.myPrivilege;
                    if (privilege4 != null && (mysteryCode = privilege4.getMysteryCode()) != null) {
                        str3 = mysteryCode;
                    }
                    str3 = title + "(" + str3 + ")";
                } else {
                    String title2 = svipPrivilege.getTitle();
                    if (title2 != null) {
                        str3 = title2;
                    }
                }
                textView.setText(str3);
                SwitchButton switchButton = getMHeaderBinding().selectButton;
                Privilege privilege5 = this.myPrivilege;
                if (privilege5 == null || !privilege5.getUserSwitch()) {
                    z = false;
                }
                switchButton.setChecked(z);
                SvipPrivilegesImageAdapter mImageAdapter = getMImageAdapter();
                if (svipPrivilege != null) {
                    arrayList = svipPrivilege.getDetails();
                }
                mImageAdapter.setList(arrayList);
            }
        }
        getMHeaderBinding().getRoot().setVisibility(8);
        SvipPrivilegesImageAdapter mImageAdapter2 = getMImageAdapter();
        if (svipPrivilege != null) {
        }
        mImageAdapter2.setList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SvipViewModel viewModel_delegate$lambda$0(SvipPrivilegesActivity svipPrivilegesActivity) {
        return new ViewModelProvider(svipPrivilegesActivity).get(SvipViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_svip_privileges;
    }

    public final int getMPosition() {
        return this.mPosition;
    }

    public final int getMType() {
        return this.mType;
    }

    @Nullable
    public final Privilege getMyPrivilege() {
        return this.myPrivilege;
    }

    @Nullable
    public final SvipInfo getSvipInfo() {
        return this.svipInfo;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }

    public final void setMPosition(int i) {
        this.mPosition = i;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    public final void setMyPrivilege(@Nullable Privilege privilege) {
        this.myPrivilege = privilege;
    }

    public final void setSvipInfo(@Nullable SvipInfo svipInfo) {
        this.svipInfo = svipInfo;
    }
}
