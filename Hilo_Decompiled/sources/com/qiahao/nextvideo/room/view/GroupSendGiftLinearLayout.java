package com.qiahao.nextvideo.room.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ViewSendGiftLinearlayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0010R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/room/view/GroupSendGiftLinearLayout;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewSendGiftLinearlayoutBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewSendGiftLinearlayoutBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewSendGiftLinearlayoutBinding;)V", "setGroupSendGiftListener", "Lcom/qiahao/nextvideo/room/view/SetGroupSendGiftListener;", "getSetGroupSendGiftListener", "()Lcom/qiahao/nextvideo/room/view/SetGroupSendGiftListener;", "setSetGroupSendGiftListener", "(Lcom/qiahao/nextvideo/room/view/SetGroupSendGiftListener;)V", "isSendButtonEnable", "", "boolean", "", "onClick", "v", "Landroid/view/View;", "setListener", "x", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupSendGiftLinearLayout extends LinearLayoutCompat implements View.OnClickListener {

    @NotNull
    private static final String TAG = "GroupSendGiftLinearLayo";

    @NotNull
    private ViewSendGiftLinearlayoutBinding binding;
    public SetGroupSendGiftListener setGroupSendGiftListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GroupSendGiftLinearLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ViewSendGiftLinearlayoutBinding viewSendGiftLinearlayoutBinding = (ViewSendGiftLinearlayoutBinding) androidx.databinding.g.h(LayoutInflater.from(context), R.layout.view_send_gift_linearlayout, this, true);
        this.binding = viewSendGiftLinearlayoutBinding;
        viewSendGiftLinearlayoutBinding.giftNumberSelector.setOnClickListener(this);
        viewSendGiftLinearlayoutBinding.giftSendButton.setOnClickListener(this);
    }

    @NotNull
    public final ViewSendGiftLinearlayoutBinding getBinding() {
        return this.binding;
    }

    @NotNull
    public final SetGroupSendGiftListener getSetGroupSendGiftListener() {
        SetGroupSendGiftListener setGroupSendGiftListener = this.setGroupSendGiftListener;
        if (setGroupSendGiftListener != null) {
            return setGroupSendGiftListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("setGroupSendGiftListener");
        return null;
    }

    public final void isSendButtonEnable(boolean r2) {
        this.binding.giftSendButton.setEnabled(r2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131363031) {
            if (id2 == 2131363038) {
                Log.d(TAG, "gift_send_button-----");
                getSetGroupSendGiftListener().sendGift();
                return;
            }
            return;
        }
        Log.d(TAG, "gift_number_selector-----");
        SetGroupSendGiftListener setGroupSendGiftListener = getSetGroupSendGiftListener();
        ConstraintLayout constraintLayout = this.binding.giftNumberSelector;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "giftNumberSelector");
        setGroupSendGiftListener.selectNumber(constraintLayout);
    }

    public final void setBinding(@NotNull ViewSendGiftLinearlayoutBinding viewSendGiftLinearlayoutBinding) {
        Intrinsics.checkNotNullParameter(viewSendGiftLinearlayoutBinding, "<set-?>");
        this.binding = viewSendGiftLinearlayoutBinding;
    }

    public final void setListener(@NotNull SetGroupSendGiftListener x) {
        Intrinsics.checkNotNullParameter(x, "x");
        setSetGroupSendGiftListener(x);
    }

    public final void setSetGroupSendGiftListener(@NotNull SetGroupSendGiftListener setGroupSendGiftListener) {
        Intrinsics.checkNotNullParameter(setGroupSendGiftListener, "<set-?>");
        this.setGroupSendGiftListener = setGroupSendGiftListener;
    }
}
