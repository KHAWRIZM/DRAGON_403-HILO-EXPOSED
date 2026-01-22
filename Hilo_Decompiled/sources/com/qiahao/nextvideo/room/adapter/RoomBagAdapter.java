package com.qiahao.nextvideo.room.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.a;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemRoomBagBinding;
import com.qiahao.nextvideo.utilities.animation.AnimationUtility;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014J,\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/RoomBagAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/base_common/model/GiftData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemRoomBagBinding;", "<init>", "()V", "selectPosition", "", "getSelectPosition", "()I", "setSelectPosition", "(I)V", "convert", "", "holder", "item", "payloads", "", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomBagAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomBagAdapter.kt\ncom/qiahao/nextvideo/room/adapter/RoomBagAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,100:1\n1869#2,2:101\n*S KotlinDebug\n*F\n+ 1 RoomBagAdapter.kt\ncom/qiahao/nextvideo/room/adapter/RoomBagAdapter\n*L\n73#1:101,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomBagAdapter extends BaseQuickAdapter<GiftData, BaseDataBindingHolder<ItemRoomBagBinding>> {
    private int selectPosition;

    public RoomBagAdapter() {
        super(R.layout.item_room_bag, (List) null, 2, (DefaultConstructorMarker) null);
        this.selectPosition = -1;
    }

    public final int getSelectPosition() {
        return this.selectPosition;
    }

    public final void setSelectPosition(int i) {
        this.selectPosition = i;
    }

    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj, List list) {
        convert((BaseDataBindingHolder<ItemRoomBagBinding>) baseViewHolder, (GiftData) obj, (List<? extends Object>) list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemRoomBagBinding> holder, @NotNull GiftData item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRoomBagBinding");
        ItemRoomBagBinding itemRoomBagBinding = (ItemRoomBagBinding) dataBinding;
        AppCompatImageView appCompatImageView = itemRoomBagBinding.image;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "image");
        String image200 = ImageSizeKt.image200(item.getIconUrl());
        if (image200 == null) {
            image200 = "";
        }
        ImageKtxKt.loadImage$default(appCompatImageView, image200, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
        itemRoomBagBinding.diamondImage.setImageDrawable(a.getDrawable(getContext(), R.drawable.gift_group_chat_diamond));
        itemRoomBagBinding.number.setText("x" + item.getCount());
        itemRoomBagBinding.time.setText(item.getRemainDays() + "d");
        TextView textView = itemRoomBagBinding.number;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        textView.setBackground(ShapeUtil.createShape$default(shapeUtil, getContext(), 2131099997, 2131099992, 6, (GradientDrawable.Orientation) null, false, 48, (Object) null));
        itemRoomBagBinding.time.setBackground(ShapeUtil.createShape$default(shapeUtil, getContext(), 2131099962, 2131099891, 6, (GradientDrawable.Orientation) null, false, 48, (Object) null));
        itemRoomBagBinding.diamond.setText(String.valueOf((int) item.getDiamondNum()));
        itemRoomBagBinding.giftName.setText(item.getName());
        if (item.isMedal()) {
            itemRoomBagBinding.iconMedal.setVisibility(0);
        } else {
            itemRoomBagBinding.iconMedal.setVisibility(8);
        }
        if (item.isWeek()) {
            itemRoomBagBinding.iconWeek.setVisibility(0);
        } else {
            itemRoomBagBinding.iconWeek.setVisibility(8);
        }
        if (item.is3D()) {
            itemRoomBagBinding.icon3D.setVisibility(0);
        } else {
            itemRoomBagBinding.icon3D.setVisibility(8);
        }
        if (item.isSelected()) {
            itemRoomBagBinding.background.setVisibility(0);
            AnimationUtility.INSTANCE.giftSelect(itemRoomBagBinding.image);
        } else {
            itemRoomBagBinding.background.setVisibility(8);
        }
    }

    protected void convert(@NotNull BaseDataBindingHolder<ItemRoomBagBinding> holder, @NotNull GiftData item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Iterator<T> it = payloads.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof Boolean) {
                ViewDataBinding dataBinding = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRoomBagBinding");
                ItemRoomBagBinding itemRoomBagBinding = (ItemRoomBagBinding) dataBinding;
                AppCompatImageView appCompatImageView = itemRoomBagBinding.image;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "image");
                String image200 = ImageSizeKt.image200(item.getIconUrl());
                if (image200 == null) {
                    image200 = "";
                }
                ImageKtxKt.loadImage$default(appCompatImageView, image200, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
                itemRoomBagBinding.diamondImage.setImageDrawable(a.getDrawable(getContext(), R.drawable.gift_group_chat_diamond));
                itemRoomBagBinding.number.setText("x" + item.getCount());
                itemRoomBagBinding.time.setText(item.getRemainDays() + "d");
                TextView textView = itemRoomBagBinding.number;
                ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
                textView.setBackground(ShapeUtil.createShape$default(shapeUtil, getContext(), 2131099997, 2131099992, 6, (GradientDrawable.Orientation) null, false, 48, (Object) null));
                itemRoomBagBinding.time.setBackground(ShapeUtil.createShape$default(shapeUtil, getContext(), 2131099962, 2131099891, 6, (GradientDrawable.Orientation) null, false, 48, (Object) null));
                itemRoomBagBinding.diamond.setText(String.valueOf((int) item.getDiamondNum()));
                itemRoomBagBinding.giftName.setText(item.getName());
                if (item.isSelected()) {
                    itemRoomBagBinding.background.setVisibility(0);
                    AnimationUtility.INSTANCE.giftSelect(itemRoomBagBinding.image);
                } else {
                    itemRoomBagBinding.background.setVisibility(8);
                }
            }
        }
    }
}
