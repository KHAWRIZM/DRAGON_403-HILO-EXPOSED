package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.view.View;
import android.widget.TextView;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder;
import j3.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00028\u0000H&¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomEmptyBaseHolder;", "Lj3/a;", "B", "Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/message/viewholder/MessageBaseHolder;", "Landroid/view/View;", "item", "<init>", "(Landroid/view/View;)V", "", "getVariableLayout", "()I", "getBindingLayout", "()Landroid/view/View;", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "msg", "position", "", "layoutViews", "(Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;I)V", "inflateViewBinding", "()Lj3/a;", "binding", "Lj3/a;", "getBinding", "setBinding", "(Lj3/a;)V", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class RoomEmptyBaseHolder<B extends j3.a> extends MessageBaseHolder {

    @Nullable
    private B binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomEmptyBaseHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "item");
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

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable TUIMessageBean msg, int position) {
        super.layoutViews(msg, position);
        TextView textView = this.chatTimeText;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public final void setBinding(@Nullable B b) {
        this.binding = b;
    }
}
