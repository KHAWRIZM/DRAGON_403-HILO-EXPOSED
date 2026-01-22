package com.qiahao.nextvideo.room.adapter;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.a;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemDialogActivityBinding;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/RoomInfoDialogAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/base_common/model/ActivityDetailData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemDialogActivityBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomInfoDialogAdapter extends BaseQuickAdapter<ActivityDetailData, BaseDataBindingHolder<ItemDialogActivityBinding>> {
    public RoomInfoDialogAdapter() {
        super(R.layout.item_dialog_activity, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemDialogActivityBinding> holder, @NotNull ActivityDetailData item) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        AppCompatTextView appCompatTextView;
        ImageView imageView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        AppCompatTextView appCompatTextView4;
        ImageView imageView2;
        AppCompatTextView appCompatTextView5;
        AppCompatTextView appCompatTextView6;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        AppCompatTextView appCompatTextView7;
        ImageView imageView3;
        AppCompatTextView appCompatTextView8;
        QMUIRadiusImageView2 qMUIRadiusImageView2;
        AppCompatTextView appCompatTextView9;
        AppCompatTextView appCompatTextView10;
        ImageView imageView4;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemDialogActivityBinding itemDialogActivityBinding = (ItemDialogActivityBinding) holder.getDataBinding();
        if (itemDialogActivityBinding != null && (imageView4 = itemDialogActivityBinding.stateImage) != null) {
            imageView4.setImageDrawable(a.getDrawable(getContext(), item.getActivityTypeIcon()));
        }
        ItemDialogActivityBinding itemDialogActivityBinding2 = (ItemDialogActivityBinding) holder.getDataBinding();
        if (itemDialogActivityBinding2 != null && (appCompatTextView10 = itemDialogActivityBinding2.stateContent) != null) {
            appCompatTextView10.setText(item.getActivityTypeText());
        }
        ItemDialogActivityBinding itemDialogActivityBinding3 = (ItemDialogActivityBinding) holder.getDataBinding();
        if (itemDialogActivityBinding3 != null && (appCompatTextView9 = itemDialogActivityBinding3.subscribeContent) != null) {
            appCompatTextView9.setText(String.valueOf(item.getPersonNum()));
        }
        ItemDialogActivityBinding itemDialogActivityBinding4 = (ItemDialogActivityBinding) holder.getDataBinding();
        if (itemDialogActivityBinding4 != null && (qMUIRadiusImageView2 = itemDialogActivityBinding4.centerImage) != null) {
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, ImageSizeKt.imageSize(item.getBanner(), UiKtxKt.toPX(345)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231930, 2131231930, (g) null, 40958, (Object) null);
        }
        ItemDialogActivityBinding itemDialogActivityBinding5 = (ItemDialogActivityBinding) holder.getDataBinding();
        if (itemDialogActivityBinding5 != null && (appCompatTextView8 = itemDialogActivityBinding5.timeContent) != null) {
            HiloUtils hiloUtils = HiloUtils.INSTANCE;
            Long startAt = item.getStartAt();
            long longValue = startAt != null ? startAt.longValue() : 0L;
            Long endAt = item.getEndAt();
            appCompatTextView8.setText(hiloUtils.formatActivityTime(longValue, endAt != null ? endAt.longValue() : 0L));
        }
        HiloUtils hiloUtils2 = HiloUtils.INSTANCE;
        Long startAt2 = item.getStartAt();
        long longValue2 = startAt2 != null ? startAt2.longValue() : 0L;
        Long endAt2 = item.getEndAt();
        int checkActivityStart = hiloUtils2.checkActivityStart(longValue2, endAt2 != null ? endAt2.longValue() : 0L);
        if (checkActivityStart == 0) {
            ItemDialogActivityBinding itemDialogActivityBinding6 = (ItemDialogActivityBinding) holder.getDataBinding();
            if (itemDialogActivityBinding6 != null && (imageView = itemDialogActivityBinding6.timeImage) != null) {
                imageView.setImageDrawable(a.getDrawable(getContext(), R.drawable.discover_time));
            }
            ItemDialogActivityBinding itemDialogActivityBinding7 = (ItemDialogActivityBinding) holder.getDataBinding();
            if (itemDialogActivityBinding7 != null && (appCompatTextView = itemDialogActivityBinding7.timeContent) != null) {
                appCompatTextView.setTextColor(a.getColor(getContext(), 2131101214));
            }
            ItemDialogActivityBinding itemDialogActivityBinding8 = (ItemDialogActivityBinding) holder.getDataBinding();
            if (itemDialogActivityBinding8 != null && (linearLayout2 = itemDialogActivityBinding8.incomeLayout) != null) {
                linearLayout2.setVisibility(8);
            }
            ItemDialogActivityBinding itemDialogActivityBinding9 = (ItemDialogActivityBinding) holder.getDataBinding();
            if (itemDialogActivityBinding9 == null || (linearLayout = itemDialogActivityBinding9.peopleLayout) == null) {
                return;
            }
            linearLayout.setVisibility(8);
            return;
        }
        if (checkActivityStart == 1) {
            ItemDialogActivityBinding itemDialogActivityBinding10 = (ItemDialogActivityBinding) holder.getDataBinding();
            if (itemDialogActivityBinding10 != null && (imageView2 = itemDialogActivityBinding10.timeImage) != null) {
                imageView2.setImageDrawable(a.getDrawable(getContext(), 2131231681));
            }
            ItemDialogActivityBinding itemDialogActivityBinding11 = (ItemDialogActivityBinding) holder.getDataBinding();
            if (itemDialogActivityBinding11 != null && (appCompatTextView4 = itemDialogActivityBinding11.timeContent) != null) {
                appCompatTextView4.setTextColor(a.getColor(getContext(), 2131100001));
            }
            ItemDialogActivityBinding itemDialogActivityBinding12 = (ItemDialogActivityBinding) holder.getDataBinding();
            if (itemDialogActivityBinding12 != null && (linearLayout4 = itemDialogActivityBinding12.incomeLayout) != null) {
                linearLayout4.setVisibility(0);
            }
            ItemDialogActivityBinding itemDialogActivityBinding13 = (ItemDialogActivityBinding) holder.getDataBinding();
            if (itemDialogActivityBinding13 != null && (linearLayout3 = itemDialogActivityBinding13.peopleLayout) != null) {
                linearLayout3.setVisibility(0);
            }
            ItemDialogActivityBinding itemDialogActivityBinding14 = (ItemDialogActivityBinding) holder.getDataBinding();
            if (itemDialogActivityBinding14 != null && (appCompatTextView3 = itemDialogActivityBinding14.incomeContent) != null) {
                appCompatTextView3.setText(NumberUtilsKt.rankNumberFormat(item.getDiamond()));
            }
            ItemDialogActivityBinding itemDialogActivityBinding15 = (ItemDialogActivityBinding) holder.getDataBinding();
            if (itemDialogActivityBinding15 == null || (appCompatTextView2 = itemDialogActivityBinding15.peopleContent) == null) {
                return;
            }
            appCompatTextView2.setText(String.valueOf(item.getSupportNum()));
            return;
        }
        if (checkActivityStart != 2) {
            return;
        }
        ItemDialogActivityBinding itemDialogActivityBinding16 = (ItemDialogActivityBinding) holder.getDataBinding();
        if (itemDialogActivityBinding16 != null && (imageView3 = itemDialogActivityBinding16.timeImage) != null) {
            imageView3.setImageDrawable(a.getDrawable(getContext(), R.drawable.discover_time));
        }
        ItemDialogActivityBinding itemDialogActivityBinding17 = (ItemDialogActivityBinding) holder.getDataBinding();
        if (itemDialogActivityBinding17 != null && (appCompatTextView7 = itemDialogActivityBinding17.timeContent) != null) {
            appCompatTextView7.setTextColor(a.getColor(getContext(), 2131101214));
        }
        ItemDialogActivityBinding itemDialogActivityBinding18 = (ItemDialogActivityBinding) holder.getDataBinding();
        if (itemDialogActivityBinding18 != null && (linearLayout6 = itemDialogActivityBinding18.incomeLayout) != null) {
            linearLayout6.setVisibility(0);
        }
        ItemDialogActivityBinding itemDialogActivityBinding19 = (ItemDialogActivityBinding) holder.getDataBinding();
        if (itemDialogActivityBinding19 != null && (linearLayout5 = itemDialogActivityBinding19.peopleLayout) != null) {
            linearLayout5.setVisibility(0);
        }
        ItemDialogActivityBinding itemDialogActivityBinding20 = (ItemDialogActivityBinding) holder.getDataBinding();
        if (itemDialogActivityBinding20 != null && (appCompatTextView6 = itemDialogActivityBinding20.incomeContent) != null) {
            appCompatTextView6.setText(NumberUtilsKt.rankNumberFormat(item.getDiamond()));
        }
        ItemDialogActivityBinding itemDialogActivityBinding21 = (ItemDialogActivityBinding) holder.getDataBinding();
        if (itemDialogActivityBinding21 == null || (appCompatTextView5 = itemDialogActivityBinding21.peopleContent) == null) {
            return;
        }
        appCompatTextView5.setText(String.valueOf(item.getSupportNum()));
    }
}
