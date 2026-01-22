package com.qiahao.nextvideo.ui.transfer;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.transfer.SecondRank;
import com.qiahao.nextvideo.databinding.ItemFragmentSecondTfBinding;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0015¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/SecondFragmentAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/transfer/SecondRank;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemFragmentSecondTfBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SecondFragmentAdapter extends BaseQuickAdapter<SecondRank, BaseDataBindingHolder<ItemFragmentSecondTfBinding>> {
    public SecondFragmentAdapter() {
        super(R.layout.item_fragment_second_tf, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemFragmentSecondTfBinding> holder, @NotNull SecondRank item) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemFragmentSecondTfBinding");
        ItemFragmentSecondTfBinding itemFragmentSecondTfBinding = (ItemFragmentSecondTfBinding) dataBinding;
        ConstraintLayout constraintLayout = itemFragmentSecondTfBinding.constraintLayout;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        constraintLayout.setBackground(ShapeUtil.createShape$default(shapeUtil, getContext(), 2131101214, 2131101214, 5, (GradientDrawable.Orientation) null, false, 48, (Object) null));
        itemFragmentSecondTfBinding.transfer.setBackground(ShapeUtil.createShape$default(shapeUtil, "#9036FF", "#9036FF", 14, (GradientDrawable.Orientation) null, 8, (Object) null));
        QMUIRadiusImageView qMUIRadiusImageView = itemFragmentSecondTfBinding.avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
        User user = item.getUser();
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, user != null ? user.getAvatar() : null, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        TextView textView = itemFragmentSecondTfBinding.name;
        User user2 = item.getUser();
        textView.setText(user2 != null ? user2.getNick() : null);
        TextView textView2 = itemFragmentSecondTfBinding.userId;
        String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
        User user3 = item.getUser();
        if (user3 == null || (str = user3.getCode()) == null) {
            str = "";
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView2.setText("(" + format + ")");
        TextView textView3 = itemFragmentSecondTfBinding.subTitle;
        String stringById2 = ResourcesKtxKt.getStringById(this, 2131952054);
        Long diamond = item.getDiamond();
        String format2 = String.format(stringById2, Arrays.copyOf(new Object[]{Long.valueOf(diamond != null ? diamond.longValue() : 0L)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        textView3.setText(format2);
        itemFragmentSecondTfBinding.salesLayout.title.setText(ResourcesKtxKt.getStringById(this, 2131954300));
        itemFragmentSecondTfBinding.rechargeLayout.title.setText(ResourcesKtxKt.getStringById(this, 2131953850));
        itemFragmentSecondTfBinding.clientLayout.title.setText(ResourcesKtxKt.getStringById(this, 2131952270));
        TextView textView4 = itemFragmentSecondTfBinding.salesLayout.number;
        Long totalSales = item.getTotalSales();
        long j = 100;
        textView4.setText("$" + NumberUtilsKt.rankNumberFormat((totalSales != null ? totalSales.longValue() : 0L) / j));
        TextView textView5 = itemFragmentSecondTfBinding.rechargeLayout.number;
        Long reCharges = item.getReCharges();
        textView5.setText("$" + NumberUtilsKt.rankNumberFormat((reCharges != null ? reCharges.longValue() : 0L) / j));
        TextView textView6 = itemFragmentSecondTfBinding.clientLayout.number;
        Integer clients = item.getClients();
        if (clients == null || (str2 = clients.toString()) == null) {
            str2 = MessageService.MSG_DB_READY_REPORT;
        }
        textView6.setText(str2);
    }
}
