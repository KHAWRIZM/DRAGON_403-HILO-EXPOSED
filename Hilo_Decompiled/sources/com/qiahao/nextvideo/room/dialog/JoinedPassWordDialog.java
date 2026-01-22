package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDialog;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogPassWordLevelBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\u000e\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0012J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0016R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/JoinedPassWordDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "mDialogPassWordLevelBinding", "Lcom/qiahao/nextvideo/databinding/DialogPassWordLevelBinding;", "getMDialogPassWordLevelBinding", "()Lcom/qiahao/nextvideo/databinding/DialogPassWordLevelBinding;", "setMDialogPassWordLevelBinding", "(Lcom/qiahao/nextvideo/databinding/DialogPassWordLevelBinding;)V", "mOnJoinedPassWordDialogListener", "Lcom/qiahao/nextvideo/room/dialog/OnJoinedPassWordDialogListener;", "getMOnJoinedPassWordDialogListener", "()Lcom/qiahao/nextvideo/room/dialog/OnJoinedPassWordDialogListener;", "setMOnJoinedPassWordDialogListener", "(Lcom/qiahao/nextvideo/room/dialog/OnJoinedPassWordDialogListener;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setPublicOrJoinSelected", "isPublicSelected", "", "setPublicOrLevelVisibility", "isShowRadioGroup", "setListener", "onJoinedPassWordDialogListener", "onClick", "v", "Landroid/view/View;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nJoinedPassWordDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JoinedPassWordDialog.kt\ncom/qiahao/nextvideo/room/dialog/JoinedPassWordDialog\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,137:1\n255#2:138\n255#2:139\n255#2:140\n*S KotlinDebug\n*F\n+ 1 JoinedPassWordDialog.kt\ncom/qiahao/nextvideo/room/dialog/JoinedPassWordDialog\n*L\n99#1:138\n105#1:139\n123#1:140\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class JoinedPassWordDialog extends AppCompatDialog implements View.OnClickListener {

    @NotNull
    private static final String TAG = "JoinedPassWordDialog";

    @NotNull
    private Context mContext;
    public DialogPassWordLevelBinding mDialogPassWordLevelBinding;
    public OnJoinedPassWordDialogListener mOnJoinedPassWordDialogListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public JoinedPassWordDialog(@NotNull Context context) {
        super(context, R.style.CommonDialogStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mContext = context2;
    }

    private final void setPublicOrJoinSelected(boolean isPublicSelected) {
        getMDialogPassWordLevelBinding().joinPublic.setSelected(isPublicSelected);
        getMDialogPassWordLevelBinding().joinedPassWord.setSelected(!isPublicSelected);
    }

    private final void setPublicOrLevelVisibility(boolean isShowRadioGroup) {
        int i;
        LinearLayout linearLayout = getMDialogPassWordLevelBinding().radioGroup;
        int i2 = 8;
        if (isShowRadioGroup) {
            i = 0;
        } else {
            i = 8;
        }
        linearLayout.setVisibility(i);
        LinearLayout linearLayout2 = getMDialogPassWordLevelBinding().llPassWordEdit;
        if (!isShowRadioGroup) {
            i2 = 0;
        }
        linearLayout2.setVisibility(i2);
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @NotNull
    public final DialogPassWordLevelBinding getMDialogPassWordLevelBinding() {
        DialogPassWordLevelBinding dialogPassWordLevelBinding = this.mDialogPassWordLevelBinding;
        if (dialogPassWordLevelBinding != null) {
            return dialogPassWordLevelBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDialogPassWordLevelBinding");
        return null;
    }

    @NotNull
    public final OnJoinedPassWordDialogListener getMOnJoinedPassWordDialogListener() {
        OnJoinedPassWordDialogListener onJoinedPassWordDialogListener = this.mOnJoinedPassWordDialogListener;
        if (onJoinedPassWordDialogListener != null) {
            return onJoinedPassWordDialogListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mOnJoinedPassWordDialogListener");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        int i;
        Intrinsics.checkNotNullParameter(v, "v");
        boolean z = false;
        switch (v.getId()) {
            case 2131362224:
                if (getMDialogPassWordLevelBinding().joinedPassWord.isSelected()) {
                    LinearLayout linearLayout = getMDialogPassWordLevelBinding().llPassWordEdit;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "llPassWordEdit");
                    if (linearLayout.getVisibility() == 0) {
                        z = true;
                    }
                    if (z) {
                        setPublicOrLevelVisibility(true);
                        return;
                    }
                }
                dismiss();
                return;
            case 2131362424:
                if (getMDialogPassWordLevelBinding().joinedPassWord.isSelected()) {
                    LinearLayout linearLayout2 = getMDialogPassWordLevelBinding().llPassWordEdit;
                    Intrinsics.checkNotNullExpressionValue(linearLayout2, "llPassWordEdit");
                    if (linearLayout2.getVisibility() != 0) {
                        setPublicOrLevelVisibility(false);
                        return;
                    }
                }
                if (getMDialogPassWordLevelBinding().joinPublic.isSelected()) {
                    getMOnJoinedPassWordDialogListener().confim(true, "");
                } else {
                    LinearLayout linearLayout3 = getMDialogPassWordLevelBinding().llPassWordEdit;
                    Intrinsics.checkNotNullExpressionValue(linearLayout3, "llPassWordEdit");
                    if (linearLayout3.getVisibility() == 0) {
                        Editable text = getMDialogPassWordLevelBinding().password.getText();
                        if (text != null) {
                            i = text.length();
                        } else {
                            i = 0;
                        }
                        if (i == 4) {
                            String valueOf = String.valueOf(getMDialogPassWordLevelBinding().password.getText());
                            Log.d(TAG, "onClick: " + valueOf);
                            getMOnJoinedPassWordDialogListener().confim(false, valueOf);
                        } else {
                            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131952617), false, 4, (Object) null);
                            if (normal$default != null) {
                                normal$default.show();
                            }
                            Log.d(TAG, "onClick: 未达到正确的密码数量。。。。。。。");
                            return;
                        }
                    }
                }
                dismiss();
                return;
            case R.id.join_public /* 2131363394 */:
                if (getMDialogPassWordLevelBinding().joinPublic.isSelected()) {
                    return;
                }
                setPublicOrJoinSelected(true);
                return;
            case R.id.joined_pass_word /* 2131363397 */:
                if (getMDialogPassWordLevelBinding().joinedPassWord.isSelected()) {
                    return;
                }
                setPublicOrJoinSelected(false);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
        setMDialogPassWordLevelBinding((DialogPassWordLevelBinding) androidx.databinding.g.h(LayoutInflater.from(this.mContext), R.layout.dialog_pass_word_level, (ViewGroup) null, false));
        setContentView(getMDialogPassWordLevelBinding().getRoot());
        getMDialogPassWordLevelBinding().setClick(this);
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        ViewGroup.LayoutParams layoutParams = getMDialogPassWordLevelBinding().bgRoot.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        Dimens dimens = Dimens.INSTANCE;
        layoutParams2.setMarginStart(dimens.dpToPx(34));
        layoutParams2.setMarginEnd(dimens.dpToPx(34));
        getMDialogPassWordLevelBinding().bgRoot.setLayoutParams(layoutParams2);
        setPublicOrLevelVisibility(true);
        setPublicOrJoinSelected(true);
    }

    public final void setListener(@NotNull OnJoinedPassWordDialogListener onJoinedPassWordDialogListener) {
        Intrinsics.checkNotNullParameter(onJoinedPassWordDialogListener, "onJoinedPassWordDialogListener");
        setMOnJoinedPassWordDialogListener(onJoinedPassWordDialogListener);
    }

    public final void setMContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mContext = context;
    }

    public final void setMDialogPassWordLevelBinding(@NotNull DialogPassWordLevelBinding dialogPassWordLevelBinding) {
        Intrinsics.checkNotNullParameter(dialogPassWordLevelBinding, "<set-?>");
        this.mDialogPassWordLevelBinding = dialogPassWordLevelBinding;
    }

    public final void setMOnJoinedPassWordDialogListener(@NotNull OnJoinedPassWordDialogListener onJoinedPassWordDialogListener) {
        Intrinsics.checkNotNullParameter(onJoinedPassWordDialogListener, "<set-?>");
        this.mOnJoinedPassWordDialogListener = onJoinedPassWordDialogListener;
    }
}
