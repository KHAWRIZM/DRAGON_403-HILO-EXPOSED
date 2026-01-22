package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogNumberOfMicBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/NumberOfMicDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "mCurrentContext", "Landroid/content/Context;", "mMicType", "", "mOnNumberOfMicListener", "Lcom/qiahao/nextvideo/room/dialog/OnNumberOfMicListener;", "<init>", "(Landroid/content/Context;ILcom/qiahao/nextvideo/room/dialog/OnNumberOfMicListener;)V", "mDialogNumberOfMicBinding", "Lcom/qiahao/nextvideo/databinding/DialogNumberOfMicBinding;", "getMDialogNumberOfMicBinding", "()Lcom/qiahao/nextvideo/databinding/DialogNumberOfMicBinding;", "setMDialogNumberOfMicBinding", "(Lcom/qiahao/nextvideo/databinding/DialogNumberOfMicBinding;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onClick", "v", "Landroid/view/View;", "setSelectMicType", "micType", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class NumberOfMicDialog extends AppCompatDialog implements View.OnClickListener {
    public static final int CLOSE_MIC = 2;
    public static final int FIVE_MIC = 1;

    @NotNull
    private static final String TAG = "NumberOfMicDialog";
    public static final int TEN_MIC = 0;

    @NotNull
    private final Context mCurrentContext;
    public DialogNumberOfMicBinding mDialogNumberOfMicBinding;
    private final int mMicType;

    @NotNull
    private final OnNumberOfMicListener mOnNumberOfMicListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumberOfMicDialog(@NotNull Context context, int i, @NotNull OnNumberOfMicListener onNumberOfMicListener) {
        super(context, R.style.CommonDialogStyle);
        Intrinsics.checkNotNullParameter(context, "mCurrentContext");
        Intrinsics.checkNotNullParameter(onNumberOfMicListener, "mOnNumberOfMicListener");
        this.mCurrentContext = context;
        this.mMicType = i;
        this.mOnNumberOfMicListener = onNumberOfMicListener;
    }

    @NotNull
    public final DialogNumberOfMicBinding getMDialogNumberOfMicBinding() {
        DialogNumberOfMicBinding dialogNumberOfMicBinding = this.mDialogNumberOfMicBinding;
        if (dialogNumberOfMicBinding != null) {
            return dialogNumberOfMicBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDialogNumberOfMicBinding");
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v) {
        Integer num;
        if (v != null) {
            num = Integer.valueOf(v.getId());
        } else {
            num = null;
        }
        int i = 0;
        if (num != null && num.intValue() == 2131363593) {
            setSelectMicType(0);
            return;
        }
        if (num != null && num.intValue() == 2131363551) {
            setSelectMicType(1);
            return;
        }
        if (num != null && num.intValue() == 2131363539) {
            setSelectMicType(2);
            return;
        }
        if (num != null && num.intValue() == 2131362424) {
            if (getMDialogNumberOfMicBinding().fiveMic.isSelected()) {
                i = 1;
            } else if (!getMDialogNumberOfMicBinding().tenMic.isSelected()) {
                getMDialogNumberOfMicBinding().closeMic.isSelected();
                i = 2;
            }
            if (i != this.mMicType) {
                this.mOnNumberOfMicListener.confim(i);
            }
            dismiss();
            return;
        }
        if (num != null && num.intValue() == 2131362224) {
            dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
        setMDialogNumberOfMicBinding((DialogNumberOfMicBinding) androidx.databinding.g.h(LayoutInflater.from(this.mCurrentContext), R.layout.dialog_number_of_mic, (ViewGroup) null, false));
        setContentView(getMDialogNumberOfMicBinding().getRoot());
        getMDialogNumberOfMicBinding().setClick(this);
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        ViewGroup.LayoutParams layoutParams = getMDialogNumberOfMicBinding().bgRoot.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        Dimens dimens = Dimens.INSTANCE;
        layoutParams2.setMarginStart(dimens.dpToPx(34));
        layoutParams2.setMarginEnd(dimens.dpToPx(34));
        getMDialogNumberOfMicBinding().bgRoot.setLayoutParams(layoutParams2);
        setSelectMicType(this.mMicType);
    }

    public final void setMDialogNumberOfMicBinding(@NotNull DialogNumberOfMicBinding dialogNumberOfMicBinding) {
        Intrinsics.checkNotNullParameter(dialogNumberOfMicBinding, "<set-?>");
        this.mDialogNumberOfMicBinding = dialogNumberOfMicBinding;
    }

    public final void setSelectMicType(int micType) {
        if (micType != 0) {
            if (micType != 1) {
                if (micType == 2) {
                    getMDialogNumberOfMicBinding().fiveMic.setSelected(false);
                    getMDialogNumberOfMicBinding().tenMic.setSelected(false);
                    getMDialogNumberOfMicBinding().closeMic.setSelected(true);
                    return;
                }
                return;
            }
            getMDialogNumberOfMicBinding().fiveMic.setSelected(true);
            getMDialogNumberOfMicBinding().tenMic.setSelected(false);
            getMDialogNumberOfMicBinding().closeMic.setSelected(false);
            return;
        }
        getMDialogNumberOfMicBinding().fiveMic.setSelected(false);
        getMDialogNumberOfMicBinding().tenMic.setSelected(true);
        getMDialogNumberOfMicBinding().closeMic.setSelected(false);
    }
}
