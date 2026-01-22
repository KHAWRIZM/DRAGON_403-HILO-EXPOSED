package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\r\u0010\u0010\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nJ\n\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/HiloMessageContentHolder;", "B", "Landroidx/databinding/ViewDataBinding;", "Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/message/viewholder/MessageContentHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "getVariableLayout", "", "inflateViewBinding", "getBindingLayout", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloMessageContentHolder<B extends ViewDataBinding> extends MessageContentHolder {

    @Nullable
    private B binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiloMessageContentHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Nullable
    public final B getBinding() {
        return this.binding;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    @Nullable
    public View getBindingLayout() {
        B inflateViewBinding = inflateViewBinding();
        this.binding = inflateViewBinding;
        if (inflateViewBinding != null) {
            return inflateViewBinding.getRoot();
        }
        return null;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return 0;
    }

    @NotNull
    public abstract B inflateViewBinding();

    public final void setBinding(@Nullable B b) {
        this.binding = b;
    }
}
