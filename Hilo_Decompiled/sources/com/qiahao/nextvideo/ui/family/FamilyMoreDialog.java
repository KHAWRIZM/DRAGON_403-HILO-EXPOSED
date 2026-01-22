package com.qiahao.nextvideo.ui.family;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatButton;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogFamilyMemberMoreBinding;
import com.qiahao.nextvideo.ui.family.FamilyMoreDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cBA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyMoreDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogFamilyMemberMoreBinding;", "context", "Landroid/content/Context;", "showAdmin", "", "notAdmin", "showQuick", "showExit", "showProfile", "<init>", "(Landroid/content/Context;ZZZZZ)V", "getShowAdmin", "()Z", "getNotAdmin", "getShowQuick", "getShowExit", "getShowProfile", "listener", "Lcom/qiahao/nextvideo/ui/family/FamilyMoreDialog$FamilyMoreDialogListener;", "getLayoutResId", "", "onInitialize", "", "setListener", "dialogListener", "Companion", "FamilyMoreDialogListener", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFamilyMoreDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FamilyMoreDialog.kt\ncom/qiahao/nextvideo/ui/family/FamilyMoreDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,107:1\n61#2,9:108\n61#2,9:117\n61#2,9:126\n61#2,9:135\n61#2,9:144\n61#2,9:153\n61#2,9:162\n*S KotlinDebug\n*F\n+ 1 FamilyMoreDialog.kt\ncom/qiahao/nextvideo/ui/family/FamilyMoreDialog\n*L\n32#1:108,9\n74#1:117,9\n77#1:126,9\n81#1:135,9\n85#1:144,9\n89#1:153,9\n93#1:162,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyMoreDialog extends BaseBindingDialog<DialogFamilyMemberMoreBinding> {

    @NotNull
    public static final String CLICK_ADMIN = "admin";

    @NotNull
    public static final String CLICK_EXIT = "exit";

    @NotNull
    public static final String CLICK_NOT_ADMIN = "not_admin";

    @NotNull
    public static final String CLICK_PROFILE = "profile";

    @NotNull
    public static final String CLICK_QUICK = "quick";

    @Nullable
    private FamilyMoreDialogListener listener;
    private final boolean notAdmin;
    private final boolean showAdmin;
    private final boolean showExit;
    private final boolean showProfile;
    private final boolean showQuick;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyMoreDialog$FamilyMoreDialogListener;", "", "clickType", "", "type", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface FamilyMoreDialogListener {
        void clickType(@NotNull String type);
    }

    public /* synthetic */ FamilyMoreDialog(Context context, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) == 0 ? z4 : false, (i & 32) != 0 ? true : z5);
    }

    protected int getLayoutResId() {
        return R.layout.dialog_family_member_more;
    }

    public final boolean getNotAdmin() {
        return this.notAdmin;
    }

    public final boolean getShowAdmin() {
        return this.showAdmin;
    }

    public final boolean getShowExit() {
        return this.showExit;
    }

    public final boolean getShowProfile() {
        return this.showProfile;
    }

    public final boolean getShowQuick() {
        return this.showQuick;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        final View view = ((DialogFamilyMemberMoreBinding) getBinding()).backView;
        final long j = 800;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyMoreDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(view) > j || (view instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(view, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        if (this.showProfile) {
            ((DialogFamilyMemberMoreBinding) getBinding()).profileButton.setVisibility(0);
            ((DialogFamilyMemberMoreBinding) getBinding()).profileLine.setVisibility(0);
        } else {
            ((DialogFamilyMemberMoreBinding) getBinding()).profileButton.setVisibility(8);
            ((DialogFamilyMemberMoreBinding) getBinding()).profileLine.setVisibility(8);
        }
        if (this.showAdmin) {
            ((DialogFamilyMemberMoreBinding) getBinding()).setAdmin.setVisibility(0);
            ((DialogFamilyMemberMoreBinding) getBinding()).setAdminLine.setVisibility(0);
        } else {
            ((DialogFamilyMemberMoreBinding) getBinding()).setAdmin.setVisibility(8);
            ((DialogFamilyMemberMoreBinding) getBinding()).setAdminLine.setVisibility(8);
        }
        if (this.notAdmin) {
            ((DialogFamilyMemberMoreBinding) getBinding()).notAdmin.setVisibility(0);
            ((DialogFamilyMemberMoreBinding) getBinding()).notAdminLine.setVisibility(0);
        } else {
            ((DialogFamilyMemberMoreBinding) getBinding()).notAdmin.setVisibility(8);
            ((DialogFamilyMemberMoreBinding) getBinding()).notAdminLine.setVisibility(8);
        }
        if (this.showQuick) {
            ((DialogFamilyMemberMoreBinding) getBinding()).quick.setVisibility(0);
            ((DialogFamilyMemberMoreBinding) getBinding()).quickLine.setVisibility(0);
        } else {
            ((DialogFamilyMemberMoreBinding) getBinding()).quick.setVisibility(8);
            ((DialogFamilyMemberMoreBinding) getBinding()).quickLine.setVisibility(8);
        }
        if (this.showExit) {
            ((DialogFamilyMemberMoreBinding) getBinding()).exit.setVisibility(0);
        } else {
            ((DialogFamilyMemberMoreBinding) getBinding()).exit.setVisibility(8);
        }
        final AppCompatButton appCompatButton = ((DialogFamilyMemberMoreBinding) getBinding()).cancelButton;
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyMoreDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton) > j || (appCompatButton instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton, currentTimeMillis);
                    AppCompatButton appCompatButton2 = appCompatButton;
                    this.dismiss();
                }
            }
        });
        final AppCompatButton appCompatButton2 = ((DialogFamilyMemberMoreBinding) getBinding()).profileButton;
        appCompatButton2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyMoreDialog$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FamilyMoreDialog.FamilyMoreDialogListener familyMoreDialogListener;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton2) > j || (appCompatButton2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton2, currentTimeMillis);
                    AppCompatButton appCompatButton3 = appCompatButton2;
                    familyMoreDialogListener = this.listener;
                    if (familyMoreDialogListener != null) {
                        familyMoreDialogListener.clickType(FamilyMoreDialog.CLICK_PROFILE);
                    }
                    this.dismiss();
                }
            }
        });
        final AppCompatButton appCompatButton3 = ((DialogFamilyMemberMoreBinding) getBinding()).setAdmin;
        appCompatButton3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyMoreDialog$onInitialize$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FamilyMoreDialog.FamilyMoreDialogListener familyMoreDialogListener;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton3) > j || (appCompatButton3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton3, currentTimeMillis);
                    AppCompatButton appCompatButton4 = appCompatButton3;
                    familyMoreDialogListener = this.listener;
                    if (familyMoreDialogListener != null) {
                        familyMoreDialogListener.clickType(FamilyMoreDialog.CLICK_ADMIN);
                    }
                    this.dismiss();
                }
            }
        });
        final AppCompatButton appCompatButton4 = ((DialogFamilyMemberMoreBinding) getBinding()).notAdmin;
        appCompatButton4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyMoreDialog$onInitialize$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FamilyMoreDialog.FamilyMoreDialogListener familyMoreDialogListener;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton4) > j || (appCompatButton4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton4, currentTimeMillis);
                    AppCompatButton appCompatButton5 = appCompatButton4;
                    familyMoreDialogListener = this.listener;
                    if (familyMoreDialogListener != null) {
                        familyMoreDialogListener.clickType(FamilyMoreDialog.CLICK_NOT_ADMIN);
                    }
                    this.dismiss();
                }
            }
        });
        final AppCompatButton appCompatButton5 = ((DialogFamilyMemberMoreBinding) getBinding()).quick;
        appCompatButton5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyMoreDialog$onInitialize$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FamilyMoreDialog.FamilyMoreDialogListener familyMoreDialogListener;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton5) > j || (appCompatButton5 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton5, currentTimeMillis);
                    AppCompatButton appCompatButton6 = appCompatButton5;
                    familyMoreDialogListener = this.listener;
                    if (familyMoreDialogListener != null) {
                        familyMoreDialogListener.clickType(FamilyMoreDialog.CLICK_QUICK);
                    }
                    this.dismiss();
                }
            }
        });
        final AppCompatButton appCompatButton6 = ((DialogFamilyMemberMoreBinding) getBinding()).exit;
        appCompatButton6.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyMoreDialog$onInitialize$$inlined$singleClick$default$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FamilyMoreDialog.FamilyMoreDialogListener familyMoreDialogListener;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton6) > j || (appCompatButton6 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton6, currentTimeMillis);
                    AppCompatButton appCompatButton7 = appCompatButton6;
                    familyMoreDialogListener = this.listener;
                    if (familyMoreDialogListener != null) {
                        familyMoreDialogListener.clickType("exit");
                    }
                    this.dismiss();
                }
            }
        });
    }

    @NotNull
    public final FamilyMoreDialog setListener(@NotNull FamilyMoreDialogListener dialogListener) {
        Intrinsics.checkNotNullParameter(dialogListener, "dialogListener");
        this.listener = dialogListener;
        return this;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FamilyMoreDialog(@NotNull Context context, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.showAdmin = z;
        this.notAdmin = z2;
        this.showQuick = z3;
        this.showExit = z4;
        this.showProfile = z5;
    }
}
