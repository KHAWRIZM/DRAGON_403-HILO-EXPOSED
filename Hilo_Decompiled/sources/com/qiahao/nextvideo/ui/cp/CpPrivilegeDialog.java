package com.qiahao.nextvideo.ui.cp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.cp.CpPrivilege;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogCpPrivilegeBinding;
import com.qiahao.nextvideo.ui.reusable.views.SwitchButton;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001d\u001a\u00020\nH\u0014J\b\u0010\u001e\u001a\u00020\u0014H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR9\u0010\u0010\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpPrivilegeDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogCpPrivilegeBinding;", "context", "Landroid/content/Context;", "data", "Lcom/qiahao/base_common/model/cp/CpPrivilege;", "isClick", "", CpSpaceActivity.RELATION_TYPE, "", "<init>", "(Landroid/content/Context;Lcom/qiahao/base_common/model/cp/CpPrivilege;ZI)V", "()Z", "getRelationType", "()I", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "initCheck", "getInitCheck", "setInitCheck", "(Z)V", "getLayoutResId", "onInitialize", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCpPrivilegeDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpPrivilegeDialog.kt\ncom/qiahao/nextvideo/ui/cp/CpPrivilegeDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,89:1\n61#2,9:90\n*S KotlinDebug\n*F\n+ 1 CpPrivilegeDialog.kt\ncom/qiahao/nextvideo/ui/cp/CpPrivilegeDialog\n*L\n77#1:90,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpPrivilegeDialog extends BaseBindingDialog<DialogCpPrivilegeBinding> {

    @Nullable
    private final CpPrivilege data;
    private boolean initCheck;
    private final boolean isClick;

    @Nullable
    private Function1<? super CpPrivilege, Unit> listener;
    private final int relationType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpPrivilegeDialog(@NotNull Context context, @Nullable CpPrivilege cpPrivilege, boolean z, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.data = cpPrivilege;
        this.isClick = z;
        this.relationType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onInitialize$lambda$0(CpPrivilegeDialog cpPrivilegeDialog, CompoundButton compoundButton, boolean z) {
        if (!cpPrivilegeDialog.isClick) {
            CpPrivilege cpPrivilege = cpPrivilegeDialog.data;
            if (cpPrivilege != null) {
                cpPrivilege.setUserSwitch(Boolean.valueOf(!z));
            }
            ((DialogCpPrivilegeBinding) cpPrivilegeDialog.getBinding()).switchView.setChecked(!z);
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, cpPrivilegeDialog.getContext(), ResourcesKtxKt.getStringById(cpPrivilegeDialog, 2131952427), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
                return;
            }
            return;
        }
        CpPrivilege cpPrivilege2 = cpPrivilegeDialog.data;
        if (cpPrivilege2 != null) {
            cpPrivilege2.setUserSwitch(Boolean.valueOf(z));
        }
    }

    public final boolean getInitCheck() {
        return this.initCheck;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_cp_privilege;
    }

    @Nullable
    public final Function1<CpPrivilege, Unit> getListener() {
        return this.listener;
    }

    public final int getRelationType() {
        return this.relationType;
    }

    /* renamed from: isClick, reason: from getter */
    public final boolean getIsClick() {
        return this.isClick;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        String str;
        String str2;
        boolean z;
        boolean z2;
        int i;
        Boolean userSwitch;
        Boolean userSwitch2;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        int i2 = this.relationType;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        ConstraintLayout constraintLayout = ((DialogCpPrivilegeBinding) getBinding()).constraintLayout;
                        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
                        constraintLayout.setBackground(ShapeUtil.createShapeStroke$default(shapeUtil, "#D66058", 14, 2.0f, false, "#FFB6A5", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null));
                        ((DialogCpPrivilegeBinding) getBinding()).confirm.setBackground(ShapeUtil.createShape$default(shapeUtil, "#B8362E", "#B8362E", 17, (GradientDrawable.Orientation) null, 8, (Object) null));
                        ((DialogCpPrivilegeBinding) getBinding()).switchView.setBackColorRes(R.drawable.bg_brother_switch);
                    }
                } else {
                    ConstraintLayout constraintLayout2 = ((DialogCpPrivilegeBinding) getBinding()).constraintLayout;
                    ShapeUtil shapeUtil2 = ShapeUtil.INSTANCE;
                    constraintLayout2.setBackground(ShapeUtil.createShapeStroke$default(shapeUtil2, "#E392FE", 14, 2.0f, false, "#FBE1FF", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null));
                    ((DialogCpPrivilegeBinding) getBinding()).confirm.setBackground(ShapeUtil.createShape$default(shapeUtil2, "#F44BFF", "#F44BFF", 17, (GradientDrawable.Orientation) null, 8, (Object) null));
                    ((DialogCpPrivilegeBinding) getBinding()).switchView.setBackColorRes(R.drawable.bg_bestie_switch);
                }
            } else {
                ConstraintLayout constraintLayout3 = ((DialogCpPrivilegeBinding) getBinding()).constraintLayout;
                ShapeUtil shapeUtil3 = ShapeUtil.INSTANCE;
                constraintLayout3.setBackground(ShapeUtil.createShapeStroke$default(shapeUtil3, "#27B9FF", 14, 2.0f, false, "#A6E2FF", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null));
                ((DialogCpPrivilegeBinding) getBinding()).confirm.setBackground(ShapeUtil.createShape$default(shapeUtil3, "#3298FD", "#3298FD", 17, (GradientDrawable.Orientation) null, 8, (Object) null));
                ((DialogCpPrivilegeBinding) getBinding()).switchView.setBackColorRes(R.drawable.bg_soul_switch);
            }
        } else {
            ConstraintLayout constraintLayout4 = ((DialogCpPrivilegeBinding) getBinding()).constraintLayout;
            ShapeUtil shapeUtil4 = ShapeUtil.INSTANCE;
            constraintLayout4.setBackground(ShapeUtil.createShapeStroke$default(shapeUtil4, "#ff90a4", 14, 2.0f, false, "#ffe1e7", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null));
            TextView textView = ((DialogCpPrivilegeBinding) getBinding()).confirm;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setBackground(ShapeUtil.createShape$default(shapeUtil4, context, 2131099996, 2131099996, 17, (GradientDrawable.Orientation) null, false, 48, (Object) null));
            ((DialogCpPrivilegeBinding) getBinding()).switchView.setBackColorRes(R.drawable.bg_cp_switch);
        }
        View view = ((DialogCpPrivilegeBinding) getBinding()).buttonBg;
        ShapeUtil shapeUtil5 = ShapeUtil.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        view.setBackground(ShapeUtil.createShape$default(shapeUtil5, context2, 2131101214, 2131101214, 0, 0, 17, 17, (GradientDrawable.Orientation) null, 128, (Object) null));
        ImageView imageView = ((DialogCpPrivilegeBinding) getBinding()).image;
        Intrinsics.checkNotNullExpressionValue(imageView, "image");
        CpPrivilege cpPrivilege = this.data;
        String str3 = null;
        if (cpPrivilege != null) {
            str = cpPrivilege.getIcon();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(imageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        TextView textView2 = ((DialogCpPrivilegeBinding) getBinding()).content;
        CpPrivilege cpPrivilege2 = this.data;
        if (cpPrivilege2 == null || (str2 = cpPrivilege2.getDesc()) == null) {
            str2 = "";
        }
        textView2.setText(str2);
        CpPrivilege cpPrivilege3 = this.data;
        boolean z3 = false;
        if (cpPrivilege3 != null && (userSwitch2 = cpPrivilege3.getUserSwitch()) != null) {
            z = userSwitch2.booleanValue();
        } else {
            z = false;
        }
        this.initCheck = z;
        ImageView imageView2 = ((DialogCpPrivilegeBinding) getBinding()).image;
        Intrinsics.checkNotNullExpressionValue(imageView2, "image");
        CpPrivilege cpPrivilege4 = this.data;
        if (cpPrivilege4 != null) {
            str3 = cpPrivilege4.getIcon();
        }
        ImageKtxKt.loadImage$default(imageView2, str3, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        Group group = ((DialogCpPrivilegeBinding) getBinding()).group;
        CpPrivilege cpPrivilege5 = this.data;
        if (cpPrivilege5 != null) {
            z2 = Intrinsics.areEqual(cpPrivilege5.getCanSwitch(), Boolean.TRUE);
        } else {
            z2 = false;
        }
        if (z2) {
            i = 0;
        } else {
            i = 8;
        }
        group.setVisibility(i);
        SwitchButton switchButton = ((DialogCpPrivilegeBinding) getBinding()).switchView;
        CpPrivilege cpPrivilege6 = this.data;
        if (cpPrivilege6 != null && (userSwitch = cpPrivilege6.getUserSwitch()) != null) {
            z3 = userSwitch.booleanValue();
        }
        switchButton.setChecked(z3);
        ((DialogCpPrivilegeBinding) getBinding()).switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.qiahao.nextvideo.ui.cp.n0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                CpPrivilegeDialog.onInitialize$lambda$0(CpPrivilegeDialog.this, compoundButton, z4);
            }
        });
        final TextView textView3 = ((DialogCpPrivilegeBinding) getBinding()).confirm;
        final long j = 800;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpPrivilegeDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CpPrivilege cpPrivilege7;
                boolean z4;
                CpPrivilege cpPrivilege8;
                Function1<CpPrivilege, Unit> listener;
                CpPrivilege cpPrivilege9;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                    if (this.getIsClick()) {
                        cpPrivilege7 = this.data;
                        if (cpPrivilege7 != null) {
                            z4 = Intrinsics.areEqual(cpPrivilege7.getCanSwitch(), Boolean.TRUE);
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            Boolean valueOf = Boolean.valueOf(this.getInitCheck());
                            cpPrivilege8 = this.data;
                            if (!Intrinsics.areEqual(valueOf, cpPrivilege8.getUserSwitch()) && (listener = this.getListener()) != null) {
                                cpPrivilege9 = this.data;
                                listener.invoke(cpPrivilege9);
                            }
                        }
                        this.dismiss();
                        return;
                    }
                    this.dismiss();
                }
            }
        });
    }

    public final void setInitCheck(boolean z) {
        this.initCheck = z;
    }

    public final void setListener(@Nullable Function1<? super CpPrivilege, Unit> function1) {
        this.listener = function1;
    }

    public /* synthetic */ CpPrivilegeDialog(Context context, CpPrivilege cpPrivilege, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : cpPrivilege, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? 1 : i);
    }
}
