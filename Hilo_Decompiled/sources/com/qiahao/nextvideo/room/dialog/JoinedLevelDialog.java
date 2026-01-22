package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatDialog;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogJoinedLevelBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\u000e\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0012J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0016R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/JoinedLevelDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "mDialogJoinedLevelBinding", "Lcom/qiahao/nextvideo/databinding/DialogJoinedLevelBinding;", "getMDialogJoinedLevelBinding", "()Lcom/qiahao/nextvideo/databinding/DialogJoinedLevelBinding;", "setMDialogJoinedLevelBinding", "(Lcom/qiahao/nextvideo/databinding/DialogJoinedLevelBinding;)V", "mOnJoinedLevelListener", "Lcom/qiahao/nextvideo/room/dialog/OnJoinedLevelListener;", "getMOnJoinedLevelListener", "()Lcom/qiahao/nextvideo/room/dialog/OnJoinedLevelListener;", "setMOnJoinedLevelListener", "(Lcom/qiahao/nextvideo/room/dialog/OnJoinedLevelListener;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setPublicOrJoinSelected", "isPublicSelected", "", "setPublicOrLevelVisibility", "isShowRadioGroup", "setListener", "onJoinedLevelListener", "onClick", "v", "Landroid/view/View;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nJoinedLevelDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JoinedLevelDialog.kt\ncom/qiahao/nextvideo/room/dialog/JoinedLevelDialog\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,156:1\n255#2:157\n255#2:158\n255#2:159\n*S KotlinDebug\n*F\n+ 1 JoinedLevelDialog.kt\ncom/qiahao/nextvideo/room/dialog/JoinedLevelDialog\n*L\n117#1:157\n123#1:158\n142#1:159\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class JoinedLevelDialog extends AppCompatDialog implements View.OnClickListener {

    @NotNull
    private static final String TAG = "JoinedLevelDialog";

    @NotNull
    private Context mContext;
    public DialogJoinedLevelBinding mDialogJoinedLevelBinding;
    public OnJoinedLevelListener mOnJoinedLevelListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public JoinedLevelDialog(@NotNull Context context) {
        super(context, R.style.CommonDialogStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mContext = context2;
    }

    private final void setPublicOrJoinSelected(boolean isPublicSelected) {
        getMDialogJoinedLevelBinding().joinPublic.setSelected(isPublicSelected);
        getMDialogJoinedLevelBinding().joinedLevel.setSelected(!isPublicSelected);
    }

    private final void setPublicOrLevelVisibility(boolean isShowRadioGroup) {
        int i;
        LinearLayout linearLayout = getMDialogJoinedLevelBinding().radioGroup;
        int i2 = 8;
        if (isShowRadioGroup) {
            i = 0;
        } else {
            i = 8;
        }
        linearLayout.setVisibility(i);
        LinearLayout linearLayout2 = getMDialogJoinedLevelBinding().llLevelEdit;
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
    public final DialogJoinedLevelBinding getMDialogJoinedLevelBinding() {
        DialogJoinedLevelBinding dialogJoinedLevelBinding = this.mDialogJoinedLevelBinding;
        if (dialogJoinedLevelBinding != null) {
            return dialogJoinedLevelBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDialogJoinedLevelBinding");
        return null;
    }

    @NotNull
    public final OnJoinedLevelListener getMOnJoinedLevelListener() {
        OnJoinedLevelListener onJoinedLevelListener = this.mOnJoinedLevelListener;
        if (onJoinedLevelListener != null) {
            return onJoinedLevelListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mOnJoinedLevelListener");
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        switch (v.getId()) {
            case 2131362224:
                if (getMDialogJoinedLevelBinding().joinedLevel.isSelected()) {
                    LinearLayout linearLayout = getMDialogJoinedLevelBinding().llLevelEdit;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "llLevelEdit");
                    if (linearLayout.getVisibility() == 0) {
                        setPublicOrLevelVisibility(true);
                        return;
                    }
                }
                dismiss();
                return;
            case 2131362424:
                if (getMDialogJoinedLevelBinding().joinedLevel.isSelected()) {
                    LinearLayout linearLayout2 = getMDialogJoinedLevelBinding().llLevelEdit;
                    Intrinsics.checkNotNullExpressionValue(linearLayout2, "llLevelEdit");
                    if (linearLayout2.getVisibility() != 0) {
                        setPublicOrLevelVisibility(false);
                        return;
                    }
                }
                if (getMDialogJoinedLevelBinding().joinPublic.isSelected()) {
                    getMOnJoinedLevelListener().confim(true, 0);
                } else {
                    LinearLayout linearLayout3 = getMDialogJoinedLevelBinding().llLevelEdit;
                    Intrinsics.checkNotNullExpressionValue(linearLayout3, "llLevelEdit");
                    if (linearLayout3.getVisibility() == 0) {
                        Editable text = getMDialogJoinedLevelBinding().levelEdit.getText();
                        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                        if (text.length() > 0) {
                            int parseInt = Integer.parseInt(getMDialogJoinedLevelBinding().levelEdit.getText().toString());
                            if (1 <= parseInt && parseInt < 71) {
                                Log.d(TAG, "onClick: " + parseInt);
                                getMOnJoinedLevelListener().confim(false, parseInt);
                            } else {
                                Log.d(TAG, "onClick: 输入数值错误。。。。。。。");
                            }
                        } else {
                            Log.d(TAG, "onClick: 没有输入。。。。。。。");
                            return;
                        }
                    }
                }
                dismiss();
                return;
            case R.id.join_public /* 2131363394 */:
                if (getMDialogJoinedLevelBinding().joinPublic.isSelected()) {
                    return;
                }
                setPublicOrJoinSelected(true);
                return;
            case R.id.joined_level /* 2131363396 */:
                if (getMDialogJoinedLevelBinding().joinedLevel.isSelected()) {
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
        setMDialogJoinedLevelBinding((DialogJoinedLevelBinding) androidx.databinding.g.h(LayoutInflater.from(this.mContext), R.layout.dialog_joined_level, (ViewGroup) null, false));
        setContentView(getMDialogJoinedLevelBinding().getRoot());
        getMDialogJoinedLevelBinding().setClick(this);
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        ViewGroup.LayoutParams layoutParams = getMDialogJoinedLevelBinding().bgRoot.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        Dimens dimens = Dimens.INSTANCE;
        layoutParams2.setMarginStart(dimens.dpToPx(34));
        layoutParams2.setMarginEnd(dimens.dpToPx(34));
        getMDialogJoinedLevelBinding().bgRoot.setLayoutParams(layoutParams2);
        setPublicOrLevelVisibility(true);
        setPublicOrJoinSelected(true);
        getMDialogJoinedLevelBinding().levelEdit.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.room.dialog.JoinedLevelDialog$onCreate$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() > 0 && Integer.parseInt(s.toString()) != 0 && Integer.parseInt(s.toString()) > 70) {
                    JoinedLevelDialog.this.getMDialogJoinedLevelBinding().levelEdit.setText("70");
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    public final void setListener(@NotNull OnJoinedLevelListener onJoinedLevelListener) {
        Intrinsics.checkNotNullParameter(onJoinedLevelListener, "onJoinedLevelListener");
        setMOnJoinedLevelListener(onJoinedLevelListener);
    }

    public final void setMContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mContext = context;
    }

    public final void setMDialogJoinedLevelBinding(@NotNull DialogJoinedLevelBinding dialogJoinedLevelBinding) {
        Intrinsics.checkNotNullParameter(dialogJoinedLevelBinding, "<set-?>");
        this.mDialogJoinedLevelBinding = dialogJoinedLevelBinding;
    }

    public final void setMOnJoinedLevelListener(@NotNull OnJoinedLevelListener onJoinedLevelListener) {
        Intrinsics.checkNotNullParameter(onJoinedLevelListener, "<set-?>");
        this.mOnJoinedLevelListener = onJoinedLevelListener;
    }
}
