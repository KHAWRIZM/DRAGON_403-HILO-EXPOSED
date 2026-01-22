package com.qiahao.nextvideo.ui.foodie.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.foodie.FoodieJettonBean;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/adapter/FoodieJettonAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/foodie/FoodieJettonBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "<init>", "()V", "convert", "", "holder", "item", "selectItem", "position", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFoodieJettonAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FoodieJettonAdapter.kt\ncom/qiahao/nextvideo/ui/foodie/adapter/FoodieJettonAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,34:1\n1878#2,3:35\n*S KotlinDebug\n*F\n+ 1 FoodieJettonAdapter.kt\ncom/qiahao/nextvideo/ui/foodie/adapter/FoodieJettonAdapter\n*L\n27#1:35,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieJettonAdapter extends BaseQuickAdapter<FoodieJettonBean, BaseViewHolder> {
    public FoodieJettonAdapter() {
        super(R.layout.item_chat_room_foodie_bet_choice, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public final void selectItem(int position) {
        boolean z;
        if (position >= 0 && position < 4) {
            int i = 0;
            for (Object obj : getData()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FoodieJettonBean foodieJettonBean = (FoodieJettonBean) obj;
                if (i == position) {
                    z = true;
                } else {
                    z = false;
                }
                foodieJettonBean.setSelect(z);
                i = i2;
            }
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseViewHolder holder, @NotNull FoodieJettonBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        holder.setText(R.id.tvBet, NumberUtilsKt.rankNumberFormat(item.getGold()));
        if (item.isSelect()) {
            holder.setBackgroundResource(R.id.rlContainer, R.drawable.ic_foodie_bet_choice_selected);
        } else {
            holder.setBackgroundResource(R.id.rlContainer, R.drawable.ic_foodie_bet_choice_normal);
        }
    }
}
