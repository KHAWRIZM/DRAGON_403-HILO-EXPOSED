package com.qiahao.nextvideo.ui.videocall;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ViewSendGiftLinearlayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0012J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0014R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/SendGiftLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewSendGiftLinearlayoutBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewSendGiftLinearlayoutBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewSendGiftLinearlayoutBinding;)V", "setSendGiftListener", "Lcom/qiahao/nextvideo/ui/videocall/SetSendGiftListener;", "getSetSendGiftListener", "()Lcom/qiahao/nextvideo/ui/videocall/SetSendGiftListener;", "setSetSendGiftListener", "(Lcom/qiahao/nextvideo/ui/videocall/SetSendGiftListener;)V", "isSendButtonEnable", "", "boolean", "", "onClick", "v", "Landroid/view/View;", "setListener", "x", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SendGiftLinearLayout extends LinearLayout implements View.OnClickListener {

    @NotNull
    private static final String TAG = "SendGiftLinearLayout";

    @NotNull
    private ViewSendGiftLinearlayoutBinding binding;
    public SetSendGiftListener setSendGiftListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SendGiftLinearLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @NotNull
    public final ViewSendGiftLinearlayoutBinding getBinding() {
        return this.binding;
    }

    @NotNull
    public final SetSendGiftListener getSetSendGiftListener() {
        SetSendGiftListener setSendGiftListener = this.setSendGiftListener;
        if (setSendGiftListener != null) {
            return setSendGiftListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("setSendGiftListener");
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
                getSetSendGiftListener().sendGift();
                return;
            }
            return;
        }
        Log.d(TAG, "gift_number_selector-----");
        SetSendGiftListener setSendGiftListener = getSetSendGiftListener();
        ConstraintLayout constraintLayout = this.binding.giftNumberSelector;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "giftNumberSelector");
        setSendGiftListener.selectNumber(constraintLayout);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Dimens dimens = Dimens.INSTANCE;
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(dimens.dpToPx(130), 1073741824), View.MeasureSpec.makeMeasureSpec(dimens.dpToPx(30), 1073741824));
    }

    public final void setBinding(@NotNull ViewSendGiftLinearlayoutBinding viewSendGiftLinearlayoutBinding) {
        Intrinsics.checkNotNullParameter(viewSendGiftLinearlayoutBinding, "<set-?>");
        this.binding = viewSendGiftLinearlayoutBinding;
    }

    public final void setListener(@NotNull SetSendGiftListener x) {
        Intrinsics.checkNotNullParameter(x, "x");
        setSetSendGiftListener(x);
    }

    public final void setSetSendGiftListener(@NotNull SetSendGiftListener setSendGiftListener) {
        Intrinsics.checkNotNullParameter(setSendGiftListener, "<set-?>");
        this.setSendGiftListener = setSendGiftListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SendGiftLinearLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SendGiftLinearLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SendGiftLinearLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ViewDataBinding h = androidx.databinding.g.h(LayoutInflater.from(context), R.layout.view_send_gift_linearlayout, (ViewGroup) null, false);
        ViewSendGiftLinearlayoutBinding viewSendGiftLinearlayoutBinding = (ViewSendGiftLinearlayoutBinding) h;
        viewSendGiftLinearlayoutBinding.giftNumberSelector.setOnClickListener(this);
        viewSendGiftLinearlayoutBinding.giftSendButton.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(h, "apply(...)");
        this.binding = viewSendGiftLinearlayoutBinding;
    }
}
