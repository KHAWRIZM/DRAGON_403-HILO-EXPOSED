package com.oudi.widget.nine;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.oudi.adapter.nine.StandardAdapter;
import com.oudi.widget.R;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0089\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00126\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006\u0012@\b\u0002\u0010\r\u001a:\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0019\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\f2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001dJ\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0007H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012RJ\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016RR\u0010\r\u001a:\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/oudi/widget/nine/StandardImageAdapter;", "T", "Lcom/oudi/adapter/nine/StandardAdapter;", "radius", "", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function2;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lkotlin/ParameterName;", "name", "holder", "item", "", "onAttach", "adapter", "<init>", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getRadius", "()I", "getBlock", "()Lkotlin/jvm/functions/Function2;", "setBlock", "(Lkotlin/jvm/functions/Function2;)V", "getOnAttach", "setOnAttach", "convert", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;)V", "setData", "list", "", "onViewAttachedToWindow", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class StandardImageAdapter<T> extends StandardAdapter<T> {

    @NotNull
    private Function2<? super BaseViewHolder, ? super T, Unit> block;

    @Nullable
    private Function2<? super BaseViewHolder, ? super StandardImageAdapter<T>, Unit> onAttach;
    private final int radius;

    public /* synthetic */ StandardImageAdapter(int i10, Function2 function2, Function2 function22, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, function2, (i11 & 4) != 0 ? null : function22);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder holder, T item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.block.invoke(holder, item);
    }

    @NotNull
    public final Function2<BaseViewHolder, T, Unit> getBlock() {
        return this.block;
    }

    @Nullable
    public final Function2<BaseViewHolder, StandardImageAdapter<T>, Unit> getOnAttach() {
        return this.onAttach;
    }

    public final int getRadius() {
        return this.radius;
    }

    public final void setBlock(@NotNull Function2<? super BaseViewHolder, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.block = function2;
    }

    public final void setData(@Nullable List<? extends T> list) {
        setList(list);
    }

    public final void setOnAttach(@Nullable Function2<? super BaseViewHolder, ? super StandardImageAdapter<T>, Unit> function2) {
        this.onAttach = function2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StandardImageAdapter(int i10, @NotNull Function2<? super BaseViewHolder, ? super T, Unit> block, @Nullable Function2<? super BaseViewHolder, ? super StandardImageAdapter<T>, Unit> function2) {
        super(R.layout.custom_item_nine_grid_image);
        Intrinsics.checkNotNullParameter(block, "block");
        this.radius = i10;
        this.block = block;
        this.onAttach = function2;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow((StandardImageAdapter<T>) holder);
        Function2<? super BaseViewHolder, ? super StandardImageAdapter<T>, Unit> function2 = this.onAttach;
        if (function2 != null) {
            function2.invoke(holder, this);
        }
    }
}
