package com.qiahao.nextvideo.room.luckyfruit;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.data.model.LuckyFruitResultMyRecordItemBean;
import com.qiahao.nextvideo.data.model.MyStake;
import com.qiahao.nextvideo.databinding.ItemChatRoomLuckyFruitRecordBinding;
import com.qiahao.nextvideo.utilities.decorate.GridSpacingItemMulityCountryDecoration;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0014J\u001e\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitRecordAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/LuckyFruitResultMyRecordItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemChatRoomLuckyFruitRecordBinding;", "layoutResId", "", "<init>", "(I)V", "onCreateDefViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LuckyFruitRecordAdapter extends BaseQuickAdapter<LuckyFruitResultMyRecordItemBean, BaseDataBindingHolder<ItemChatRoomLuckyFruitRecordBinding>> {
    public LuckyFruitRecordAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemChatRoomLuckyFruitRecordBinding> holder, @NotNull LuckyFruitResultMyRecordItemBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemChatRoomLuckyFruitRecordBinding");
        ItemChatRoomLuckyFruitRecordBinding itemChatRoomLuckyFruitRecordBinding = (ItemChatRoomLuckyFruitRecordBinding) dataBinding;
        itemChatRoomLuckyFruitRecordBinding.recordDate.setText(DateTimeUtilityKt.getDateInSecs$default(item.getStartTime(), (Locale) null, "yyyy-MM-dd HH:mm:ss ", 2, (Object) null));
        TextView textView = itemChatRoomLuckyFruitRecordBinding.recordRound;
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131953086), Arrays.copyOf(new Object[]{String.valueOf(item.getRound())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        itemChatRoomLuckyFruitRecordBinding.winImage.setImageDrawable(LuckyFruitDialog.INSTANCE.getResultDrawable(item.getFruitId()));
        if (item.getMyAward() > 0) {
            itemChatRoomLuckyFruitRecordBinding.llWin.setVisibility(0);
            itemChatRoomLuckyFruitRecordBinding.lostView.setVisibility(8);
            itemChatRoomLuckyFruitRecordBinding.wonDiamond.setText(NumberUtilsKt.rankNumberFormat(item.getMyAward()));
        } else {
            itemChatRoomLuckyFruitRecordBinding.llWin.setVisibility(8);
            itemChatRoomLuckyFruitRecordBinding.lostView.setVisibility(0);
        }
        List<MyStake> myStake = item.getMyStake();
        if (myStake != null && myStake.isEmpty()) {
            itemChatRoomLuckyFruitRecordBinding.fruitResultRecyclerView.setVisibility(8);
            return;
        }
        itemChatRoomLuckyFruitRecordBinding.fruitResultRecyclerView.setVisibility(0);
        LuckyFruitBetAdapter adapter = itemChatRoomLuckyFruitRecordBinding.fruitResultRecyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.qiahao.nextvideo.room.luckyfruit.LuckyFruitBetAdapter");
        adapter.setList(item.getMyStake());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: onCreateDefViewHolder, reason: merged with bridge method [inline-methods] */
    public BaseDataBindingHolder<ItemChatRoomLuckyFruitRecordBinding> m٦٣onCreateDefViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        BaseDataBindingHolder<ItemChatRoomLuckyFruitRecordBinding> onCreateDefViewHolder = super.onCreateDefViewHolder(parent, viewType);
        ViewDataBinding dataBinding = onCreateDefViewHolder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemChatRoomLuckyFruitRecordBinding");
        RecyclerView recyclerView = ((ItemChatRoomLuckyFruitRecordBinding) dataBinding).fruitResultRecyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3));
        recyclerView.addItemDecoration(new GridSpacingItemMulityCountryDecoration(3, Dimens.INSTANCE.dpToPx(11), false));
        recyclerView.setAdapter(new LuckyFruitBetAdapter());
        return onCreateDefViewHolder;
    }
}
