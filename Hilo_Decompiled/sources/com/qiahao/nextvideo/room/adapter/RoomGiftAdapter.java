package com.qiahao.nextvideo.room.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.a;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.model.MultiGiftData;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemRoomGiftBinding;
import com.qiahao.nextvideo.databinding.ItemRoomGiftCustomizeBinding;
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

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014J,\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/RoomGiftAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/qiahao/base_common/model/MultiGiftData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemRoomGiftBinding;", "<init>", "()V", "selectPosition", "", "getSelectPosition", "()I", "setSelectPosition", "(I)V", "convert", "", "holder", "item", "payloads", "", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomGiftAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomGiftAdapter.kt\ncom/qiahao/nextvideo/room/adapter/RoomGiftAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,133:1\n1869#2,2:134\n*S KotlinDebug\n*F\n+ 1 RoomGiftAdapter.kt\ncom/qiahao/nextvideo/room/adapter/RoomGiftAdapter\n*L\n92#1:134,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomGiftAdapter extends BaseMultiItemQuickAdapter<MultiGiftData, BaseDataBindingHolder<ItemRoomGiftBinding>> {
    private int selectPosition;

    public RoomGiftAdapter() {
        super((List) null, 1, (DefaultConstructorMarker) null);
        this.selectPosition = -1;
        addItemType(0, R.layout.item_room_gift);
        addItemType(1, R.layout.item_room_gift_customize);
    }

    public final int getSelectPosition() {
        return this.selectPosition;
    }

    public final void setSelectPosition(int i) {
        this.selectPosition = i;
    }

    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj, List list) {
        convert((BaseDataBindingHolder<ItemRoomGiftBinding>) baseViewHolder, (MultiGiftData) obj, (List<? extends Object>) list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemRoomGiftBinding> holder, @NotNull MultiGiftData item) {
        Integer type;
        GiftData giftData;
        Integer type2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        int itemType = item.getItemType();
        if (itemType != 0) {
            if (itemType != 1) {
                return;
            }
            ViewDataBinding dataBinding = holder.getDataBinding();
            Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRoomGiftCustomizeBinding");
            ((ItemRoomGiftCustomizeBinding) dataBinding).bg.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#19D9D9D9", "#19D9D9D9", 5, (GradientDrawable.Orientation) null, 8, (Object) null));
            return;
        }
        ViewDataBinding dataBinding2 = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding2, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRoomGiftBinding");
        ItemRoomGiftBinding itemRoomGiftBinding = (ItemRoomGiftBinding) dataBinding2;
        AppCompatImageView appCompatImageView = itemRoomGiftBinding.image;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "image");
        GiftData giftData2 = item.getGiftData();
        String image200 = ImageSizeKt.image200(giftData2 != null ? giftData2.getIconUrl() : null);
        if (image200 == null) {
            image200 = "";
        }
        ImageKtxKt.loadImage$default(appCompatImageView, image200, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
        itemRoomGiftBinding.diamondImage.setImageDrawable(a.getDrawable(getContext(), R.drawable.gift_group_chat_diamond));
        AppCompatTextView appCompatTextView = itemRoomGiftBinding.diamond;
        GiftData giftData3 = item.getGiftData();
        appCompatTextView.setText(String.valueOf(giftData3 != null ? Integer.valueOf((int) giftData3.getDiamondNum()) : null));
        TextView textView = itemRoomGiftBinding.giftName;
        GiftData giftData4 = item.getGiftData();
        textView.setText(giftData4 != null ? giftData4.getName() : null);
        GiftData giftData5 = item.getGiftData();
        if (giftData5 != null && giftData5.isMedal()) {
            itemRoomGiftBinding.iconMedal.setVisibility(0);
        } else {
            itemRoomGiftBinding.iconMedal.setVisibility(8);
        }
        GiftData giftData6 = item.getGiftData();
        if (giftData6 != null && giftData6.isWeek()) {
            itemRoomGiftBinding.iconWeek.setVisibility(0);
        } else {
            itemRoomGiftBinding.iconWeek.setVisibility(8);
        }
        GiftData giftData7 = item.getGiftData();
        if (giftData7 != null && giftData7.is3D()) {
            itemRoomGiftBinding.icon3D.setVisibility(0);
        } else {
            itemRoomGiftBinding.icon3D.setVisibility(8);
        }
        GiftData giftData8 = item.getGiftData();
        if (giftData8 != null && giftData8.isActivity()) {
            itemRoomGiftBinding.iconActivity.setVisibility(0);
        } else {
            itemRoomGiftBinding.iconActivity.setVisibility(8);
        }
        GiftData giftData9 = item.getGiftData();
        if (giftData9 != null && giftData9.isSelected() && (giftData = item.getGiftData()) != null && (type2 = giftData.getType()) != null && type2.intValue() == 0) {
            itemRoomGiftBinding.background.setVisibility(0);
            AnimationUtility.INSTANCE.giftSelect(itemRoomGiftBinding.image);
        } else {
            itemRoomGiftBinding.background.setVisibility(8);
        }
        GiftData giftData10 = item.getGiftData();
        if (giftData10 != null && (type = giftData10.getType()) != null && type.intValue() == 0) {
            itemRoomGiftBinding.buttonLayout.setVisibility(0);
        } else {
            itemRoomGiftBinding.buttonLayout.setVisibility(4);
        }
    }

    protected void convert(@NotNull BaseDataBindingHolder<ItemRoomGiftBinding> holder, @NotNull MultiGiftData item, @NotNull List<? extends Object> payloads) {
        Integer type;
        GiftData giftData;
        Integer type2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Iterator<T> it = payloads.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof Boolean) {
                if (item.getItemType() == 0) {
                    ViewDataBinding dataBinding = holder.getDataBinding();
                    Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRoomGiftBinding");
                    ItemRoomGiftBinding itemRoomGiftBinding = (ItemRoomGiftBinding) dataBinding;
                    AppCompatImageView appCompatImageView = itemRoomGiftBinding.image;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "image");
                    GiftData giftData2 = item.getGiftData();
                    String image200 = ImageSizeKt.image200(giftData2 != null ? giftData2.getIconUrl() : null);
                    if (image200 == null) {
                        image200 = "";
                    }
                    ImageKtxKt.loadImage$default(appCompatImageView, image200, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
                    itemRoomGiftBinding.diamondImage.setImageDrawable(a.getDrawable(getContext(), R.drawable.gift_group_chat_diamond));
                    AppCompatTextView appCompatTextView = itemRoomGiftBinding.diamond;
                    GiftData giftData3 = item.getGiftData();
                    appCompatTextView.setText(String.valueOf(giftData3 != null ? Integer.valueOf((int) giftData3.getDiamondNum()) : null));
                    TextView textView = itemRoomGiftBinding.giftName;
                    GiftData giftData4 = item.getGiftData();
                    textView.setText(giftData4 != null ? giftData4.getName() : null);
                    GiftData giftData5 = item.getGiftData();
                    if (giftData5 != null && giftData5.isMedal()) {
                        itemRoomGiftBinding.iconMedal.setVisibility(0);
                    } else {
                        itemRoomGiftBinding.iconMedal.setVisibility(8);
                    }
                    GiftData giftData6 = item.getGiftData();
                    if (giftData6 != null && giftData6.isWeek()) {
                        itemRoomGiftBinding.iconWeek.setVisibility(0);
                    } else {
                        itemRoomGiftBinding.iconWeek.setVisibility(8);
                    }
                    GiftData giftData7 = item.getGiftData();
                    if (giftData7 != null && giftData7.isSelected() && (giftData = item.getGiftData()) != null && (type2 = giftData.getType()) != null && type2.intValue() == 0) {
                        itemRoomGiftBinding.background.setVisibility(0);
                        AnimationUtility.INSTANCE.giftSelect(itemRoomGiftBinding.image);
                    } else {
                        itemRoomGiftBinding.background.setVisibility(8);
                    }
                    GiftData giftData8 = item.getGiftData();
                    if (giftData8 != null && (type = giftData8.getType()) != null && type.intValue() == 0) {
                        itemRoomGiftBinding.buttonLayout.setVisibility(0);
                    } else {
                        itemRoomGiftBinding.buttonLayout.setVisibility(4);
                    }
                } else if (item.getItemType() == 1) {
                    ViewDataBinding dataBinding2 = holder.getDataBinding();
                    Intrinsics.checkNotNull(dataBinding2, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRoomGiftCustomizeBinding");
                    ((ItemRoomGiftCustomizeBinding) dataBinding2).bg.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#19D9D9D9", "#19D9D9D9", 5, (GradientDrawable.Orientation) null, 8, (Object) null));
                }
            }
        }
    }
}
