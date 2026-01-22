package com.qiahao.nextvideo.ui.foodie.adapter;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.date.DateUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.foodie.Bet;
import com.qiahao.nextvideo.data.foodie.FoodieRecordBean;
import com.qiahao.nextvideo.databinding.ItemChatRoomFoodieRecordBinding;
import com.qiahao.nextvideo.ui.foodie.FoodieUtil;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/adapter/FoodieRecordAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/foodie/FoodieRecordBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemChatRoomFoodieRecordBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFoodieRecordAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FoodieRecordAdapter.kt\ncom/qiahao/nextvideo/ui/foodie/adapter/FoodieRecordAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,60:1\n1869#2,2:61\n1869#2,2:63\n*S KotlinDebug\n*F\n+ 1 FoodieRecordAdapter.kt\ncom/qiahao/nextvideo/ui/foodie/adapter/FoodieRecordAdapter\n*L\n33#1:61,2\n38#1:63,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieRecordAdapter extends BaseQuickAdapter<FoodieRecordBean, BaseDataBindingHolder<ItemChatRoomFoodieRecordBinding>> {
    public FoodieRecordAdapter() {
        super(R.layout.item_chat_room_foodie_record, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemChatRoomFoodieRecordBinding> holder, @NotNull FoodieRecordBean item) {
        long j;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemChatRoomFoodieRecordBinding");
        ItemChatRoomFoodieRecordBinding itemChatRoomFoodieRecordBinding = (ItemChatRoomFoodieRecordBinding) dataBinding;
        DateUtils dateUtils = DateUtils.INSTANCE;
        Long createTime = item.getCreateTime();
        String formatDate = dateUtils.formatDate("yyyy-MM-dd\nHH:mm:ss", Long.valueOf((createTime != null ? createTime.longValue() : 0L) * 1000));
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131954150), Arrays.copyOf(new Object[]{item.getRound()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        TextView textView = itemChatRoomFoodieRecordBinding.tvTime;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(formatDate);
        sb2.append("\n");
        sb2.append(format);
        textView.setText(sb2);
        ArrayList<Bet> list = item.getList();
        if (list != null) {
            Iterator<T> it = list.iterator();
            j = 0;
            while (it.hasNext()) {
                Long winDiamond = ((Bet) it.next()).getWinDiamond();
                j += winDiamond != null ? winDiamond.longValue() : 0L;
            }
        } else {
            j = 0;
        }
        itemChatRoomFoodieRecordBinding.tvGold.setText(NumberUtilsKt.rankNumberFormat(j));
        itemChatRoomFoodieRecordBinding.llBet.removeAllViews();
        ArrayList<Bet> list2 = item.getList();
        if (list2 != null) {
            for (Bet bet : list2) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_chat_room_foodie_bet, (ViewGroup) null);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                ImageView imageView = (ImageView) inflate.findViewById(R.id.bet);
                TextView textView2 = (TextView) inflate.findViewById(R.id.bet_gold);
                Long betDiamond = bet.getBetDiamond();
                textView2.setText(NumberUtilsKt.rankNumberFormat(betDiamond != null ? betDiamond.longValue() : 0L));
                String foodieIcon = FoodieUtil.INSTANCE.getFoodieIcon(bet.getFoodieId());
                Intrinsics.checkNotNull(imageView);
                ImageKtxKt.loadImage$default(imageView, foodieIcon, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
                itemChatRoomFoodieRecordBinding.llBet.addView(inflate);
            }
        }
        FoodieUtil foodieUtil = FoodieUtil.INSTANCE;
        Integer winFoodieId = item.getWinFoodieId();
        String foodieIcon2 = foodieUtil.getFoodieIcon(winFoodieId != null ? winFoodieId.intValue() : 0);
        ImageView imageView2 = itemChatRoomFoodieRecordBinding.ivReward;
        Intrinsics.checkNotNullExpressionValue(imageView2, "ivReward");
        ImageKtxKt.loadImage$default(imageView2, foodieIcon2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
        if (getData().size() - 1 == holder.getLayoutPosition()) {
            itemChatRoomFoodieRecordBinding.vLine.setVisibility(8);
        } else {
            itemChatRoomFoodieRecordBinding.vLine.setVisibility(0);
        }
    }
}
