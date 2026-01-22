package com.qiahao.nextvideo.room.adapter;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.TextData;
import com.qiahao.nextvideo.databinding.ItemTextGroupBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/TextGroupAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/TextData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemTextGroupBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TextGroupAdapter extends BaseQuickAdapter<TextData, BaseDataBindingHolder<ItemTextGroupBinding>> {
    public TextGroupAdapter() {
        super(R.layout.item_text_group, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemTextGroupBinding> holder, @NotNull TextData item) {
        RecyclerView recyclerView;
        TextView textView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemTextGroupBinding itemTextGroupBinding = (ItemTextGroupBinding) holder.getDataBinding();
        RecyclerView.Adapter adapter = null;
        if (((itemTextGroupBinding == null || (recyclerView3 = itemTextGroupBinding.recyclerView) == null) ? null : recyclerView3.getAdapter()) == null) {
            TextAdapter textAdapter = new TextAdapter();
            ItemTextGroupBinding itemTextGroupBinding2 = (ItemTextGroupBinding) holder.getDataBinding();
            if (itemTextGroupBinding2 != null && (recyclerView2 = itemTextGroupBinding2.recyclerView) != null) {
                recyclerView2.setAdapter(textAdapter);
            }
        }
        ItemTextGroupBinding itemTextGroupBinding3 = (ItemTextGroupBinding) holder.getDataBinding();
        if (itemTextGroupBinding3 != null && (textView = itemTextGroupBinding3.title) != null) {
            textView.setText(item.getTitle());
        }
        ItemTextGroupBinding itemTextGroupBinding4 = (ItemTextGroupBinding) holder.getDataBinding();
        if (itemTextGroupBinding4 != null && (recyclerView = itemTextGroupBinding4.recyclerView) != null) {
            adapter = recyclerView.getAdapter();
        }
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.qiahao.nextvideo.room.adapter.TextAdapter");
        ((TextAdapter) adapter).setList(item.getList());
    }
}
