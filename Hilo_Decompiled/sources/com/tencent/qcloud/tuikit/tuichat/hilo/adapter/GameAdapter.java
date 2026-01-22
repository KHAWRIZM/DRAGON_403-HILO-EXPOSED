package com.tencent.qcloud.tuikit.tuichat.hilo.adapter;

import androidx.core.content.a;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.databinding.ItemGameBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.game.GameData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/adapter/GameAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/game/GameData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/ItemGameBinding;", "<init>", "()V", "convert", "", "holder", "item", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class GameAdapter extends BaseQuickAdapter<GameData, BaseDataBindingHolder<ItemGameBinding>> {
    public GameAdapter() {
        super(R.layout.item_game, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemGameBinding> holder, @NotNull GameData item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.tencent.qcloud.tuikit.tuichat.databinding.ItemGameBinding");
        ItemGameBinding itemGameBinding = (ItemGameBinding) dataBinding;
        itemGameBinding.title.setText(item.getTitle());
        itemGameBinding.image.setImageDrawable(a.getDrawable(getContext(), item.getIconRes()));
    }
}
