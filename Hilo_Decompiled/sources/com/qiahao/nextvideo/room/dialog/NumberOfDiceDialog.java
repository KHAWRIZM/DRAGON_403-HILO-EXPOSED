package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogNumberOfDiceBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/NumberOfDiceDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "mCurrentContext", "Landroid/content/Context;", "mMicType", "", "mDiceType", "mOnNumberOfDiceListener", "Lcom/qiahao/nextvideo/room/dialog/OnNumberOfDiceListener;", "<init>", "(Landroid/content/Context;IILcom/qiahao/nextvideo/room/dialog/OnNumberOfDiceListener;)V", "binding", "Lcom/qiahao/nextvideo/databinding/DialogNumberOfDiceBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/DialogNumberOfDiceBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/DialogNumberOfDiceBinding;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setSelectDiceType", "diceType", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNumberOfDiceDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NumberOfDiceDialog.kt\ncom/qiahao/nextvideo/room/dialog/NumberOfDiceDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,165:1\n61#2,9:166\n61#2,9:175\n61#2,9:184\n61#2,9:193\n61#2,9:202\n61#2,9:211\n61#2,9:220\n61#2,9:229\n61#2,9:238\n*S KotlinDebug\n*F\n+ 1 NumberOfDiceDialog.kt\ncom/qiahao/nextvideo/room/dialog/NumberOfDiceDialog\n*L\n69#1:166,9\n72#1:175,9\n75#1:184,9\n78#1:193,9\n81#1:202,9\n84#1:211,9\n88#1:220,9\n92#1:229,9\n113#1:238,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class NumberOfDiceDialog extends AppCompatDialog {
    public static final int FIVE_DICE = 5;
    public static final int FOUR_DICE = 4;
    public static final int ONE_DICE = 1;

    @NotNull
    private static final String TAG = "NumberOfDiceDialog";
    public static final int THREE_DICE = 3;
    public static final int TWO_DICE = 2;
    public DialogNumberOfDiceBinding binding;

    @NotNull
    private final Context mCurrentContext;
    private final int mDiceType;
    private final int mMicType;

    @NotNull
    private final OnNumberOfDiceListener mOnNumberOfDiceListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumberOfDiceDialog(@NotNull Context context, int i, int i2, @NotNull OnNumberOfDiceListener onNumberOfDiceListener) {
        super(context, R.style.CommonDialogStyle);
        Intrinsics.checkNotNullParameter(context, "mCurrentContext");
        Intrinsics.checkNotNullParameter(onNumberOfDiceListener, "mOnNumberOfDiceListener");
        this.mCurrentContext = context;
        this.mMicType = i;
        this.mDiceType = i2;
        this.mOnNumberOfDiceListener = onNumberOfDiceListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSelectDiceType(int diceType) {
        if (diceType != 1) {
            if (diceType != 2) {
                if (diceType != 3) {
                    if (diceType != 4) {
                        if (diceType == 5) {
                            getBinding().oneDice.diceButton.setSelected(false);
                            getBinding().twoDice.diceButton.setSelected(false);
                            getBinding().threeDice.diceButton.setSelected(false);
                            getBinding().fourDice.diceButton.setSelected(false);
                            getBinding().fiveDice.diceButton.setSelected(true);
                            return;
                        }
                        return;
                    }
                    getBinding().oneDice.diceButton.setSelected(false);
                    getBinding().twoDice.diceButton.setSelected(false);
                    getBinding().threeDice.diceButton.setSelected(false);
                    getBinding().fourDice.diceButton.setSelected(true);
                    getBinding().fiveDice.diceButton.setSelected(false);
                    return;
                }
                getBinding().oneDice.diceButton.setSelected(false);
                getBinding().twoDice.diceButton.setSelected(false);
                getBinding().threeDice.diceButton.setSelected(true);
                getBinding().fourDice.diceButton.setSelected(false);
                getBinding().fiveDice.diceButton.setSelected(false);
                return;
            }
            getBinding().oneDice.diceButton.setSelected(false);
            getBinding().twoDice.diceButton.setSelected(true);
            getBinding().threeDice.diceButton.setSelected(false);
            getBinding().fourDice.diceButton.setSelected(false);
            getBinding().fiveDice.diceButton.setSelected(false);
            return;
        }
        getBinding().oneDice.diceButton.setSelected(true);
        getBinding().twoDice.diceButton.setSelected(false);
        getBinding().threeDice.diceButton.setSelected(false);
        getBinding().fourDice.diceButton.setSelected(false);
        getBinding().fiveDice.diceButton.setSelected(false);
    }

    @NotNull
    public final DialogNumberOfDiceBinding getBinding() {
        DialogNumberOfDiceBinding dialogNumberOfDiceBinding = this.binding;
        if (dialogNumberOfDiceBinding != null) {
            return dialogNumberOfDiceBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
        setBinding((DialogNumberOfDiceBinding) androidx.databinding.g.h(LayoutInflater.from(this.mCurrentContext), R.layout.dialog_number_of_dice, (ViewGroup) null, false));
        setContentView(getBinding().getRoot());
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        ViewGroup.LayoutParams layoutParams = getBinding().bgRoot.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        Dimens dimens = Dimens.INSTANCE;
        layoutParams2.setMarginStart(dimens.dpToPx(34));
        layoutParams2.setMarginEnd(dimens.dpToPx(34));
        getBinding().bgRoot.setLayoutParams(layoutParams2);
        if (this.mDiceType == 1) {
            getBinding().oneNiceDice.diceButton.setSelected(true);
            getBinding().oneSixDice.diceButton.setSelected(false);
        } else {
            getBinding().oneNiceDice.diceButton.setSelected(false);
            getBinding().oneSixDice.diceButton.setSelected(true);
        }
        setSelectDiceType(this.mMicType);
        String stringById = ResourcesKtxKt.getStringById(this, 2131952571);
        getBinding().oneDice.textDice.setText(MessageService.MSG_DB_NOTIFY_REACHED + stringById);
        getBinding().twoDice.textDice.setText(MessageService.MSG_DB_NOTIFY_CLICK + stringById);
        getBinding().threeDice.textDice.setText("3" + stringById);
        getBinding().fourDice.textDice.setText(MessageService.MSG_ACCS_READY_REPORT + stringById);
        getBinding().fiveDice.textDice.setText("5" + stringById);
        getBinding().oneNiceDice.textDice.setText("1-9" + ResourcesKtxKt.getStringById(this, 2131953561));
        getBinding().oneSixDice.textDice.setText("1-6" + ResourcesKtxKt.getStringById(this, 2131953561));
        final View root = getBinding().oneDice.getRoot();
        final long j = 800;
        root.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.NumberOfDiceDialog$onCreate$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                    this.setSelectDiceType(1);
                }
            }
        });
        final View root2 = getBinding().twoDice.getRoot();
        root2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.NumberOfDiceDialog$onCreate$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root2) > j || (root2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root2, currentTimeMillis);
                    this.setSelectDiceType(2);
                }
            }
        });
        final View root3 = getBinding().threeDice.getRoot();
        root3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.NumberOfDiceDialog$onCreate$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root3) > j || (root3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root3, currentTimeMillis);
                    this.setSelectDiceType(3);
                }
            }
        });
        final View root4 = getBinding().fourDice.getRoot();
        root4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.NumberOfDiceDialog$onCreate$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root4) > j || (root4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root4, currentTimeMillis);
                    this.setSelectDiceType(4);
                }
            }
        });
        final View root5 = getBinding().fiveDice.getRoot();
        root5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.NumberOfDiceDialog$onCreate$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root5) > j || (root5 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root5, currentTimeMillis);
                    this.setSelectDiceType(5);
                }
            }
        });
        final View root6 = getBinding().oneNiceDice.getRoot();
        root6.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.NumberOfDiceDialog$onCreate$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root6) > j || (root6 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root6, currentTimeMillis);
                    this.getBinding().oneNiceDice.diceButton.setSelected(true);
                    this.getBinding().oneSixDice.diceButton.setSelected(false);
                }
            }
        });
        final View root7 = getBinding().oneSixDice.getRoot();
        root7.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.NumberOfDiceDialog$onCreate$$inlined$singleClick$default$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root7) > j || (root7 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root7, currentTimeMillis);
                    this.getBinding().oneNiceDice.diceButton.setSelected(false);
                    this.getBinding().oneSixDice.diceButton.setSelected(true);
                }
            }
        });
        final TextView textView = getBinding().confirmButton;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.NumberOfDiceDialog$onCreate$$inlined$singleClick$default$8
            /* JADX WARN: Code restructure failed: missing block: B:16:0x00ac, code lost:
            
                if (r0 != r1) goto L٣٠;
             */
            /* JADX WARN: Removed duplicated region for block: B:15:0x00a6  */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void onClick(View view) {
                int i;
                int i2;
                OnNumberOfDiceListener onNumberOfDiceListener;
                int i3;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    int i4 = 2;
                    if (!this.getBinding().oneDice.diceButton.isSelected()) {
                        if (this.getBinding().twoDice.diceButton.isSelected()) {
                            i = 2;
                        } else if (this.getBinding().threeDice.diceButton.isSelected()) {
                            i = 3;
                        } else if (this.getBinding().fourDice.diceButton.isSelected()) {
                            i = 4;
                        } else if (this.getBinding().fiveDice.diceButton.isSelected()) {
                            i = 5;
                        }
                        if (!this.getBinding().oneNiceDice.diceButton.isSelected() || !this.getBinding().oneSixDice.diceButton.isSelected()) {
                            i4 = 1;
                        }
                        i2 = this.mMicType;
                        if (i == i2) {
                            i3 = this.mDiceType;
                        }
                        onNumberOfDiceListener = this.mOnNumberOfDiceListener;
                        onNumberOfDiceListener.confim(i, i4);
                        this.dismiss();
                    }
                    i = 1;
                    if (!this.getBinding().oneNiceDice.diceButton.isSelected()) {
                    }
                    i4 = 1;
                    i2 = this.mMicType;
                    if (i == i2) {
                    }
                    onNumberOfDiceListener = this.mOnNumberOfDiceListener;
                    onNumberOfDiceListener.confim(i, i4);
                    this.dismiss();
                }
            }
        });
        final TextView textView2 = getBinding().cancelButton;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.NumberOfDiceDialog$onCreate$$inlined$singleClick$default$9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
    }

    public final void setBinding(@NotNull DialogNumberOfDiceBinding dialogNumberOfDiceBinding) {
        Intrinsics.checkNotNullParameter(dialogNumberOfDiceBinding, "<set-?>");
        this.binding = dialogNumberOfDiceBinding;
    }
}
