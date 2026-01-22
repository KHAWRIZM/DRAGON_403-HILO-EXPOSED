package com.qiahao.nextvideo.ui.family;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.family.FamilyWheelRecord;
import com.qiahao.nextvideo.databinding.ItemDailyRecordBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/DailyRecordAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/family/FamilyWheelRecord;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemDailyRecordBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DailyRecordAdapter extends BaseQuickAdapter<FamilyWheelRecord, BaseDataBindingHolder<ItemDailyRecordBinding>> {
    public DailyRecordAdapter() {
        super(R.layout.item_daily_record, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemDailyRecordBinding> holder, @NotNull FamilyWheelRecord item) {
        String str;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemDailyRecordBinding");
        ItemDailyRecordBinding itemDailyRecordBinding = (ItemDailyRecordBinding) dataBinding;
        QMUIRadiusImageView qMUIRadiusImageView = itemDailyRecordBinding.avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
        User user = item.getUser();
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, user != null ? user.getAvatar() : null, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        TextView textView = itemDailyRecordBinding.name;
        User user2 = item.getUser();
        if (user2 == null || (str = user2.getNick()) == null) {
            str = "";
        }
        textView.setText(str);
        TextView textView2 = itemDailyRecordBinding.content;
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131953935), Arrays.copyOf(new Object[]{item.getDiamond()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView2.setText(format);
        TextView textView3 = itemDailyRecordBinding.time;
        Long createTimestamp = item.getCreateTimestamp();
        textView3.setText(com.qiahao.base_common.utils.f.h((createTimestamp != null ? createTimestamp.longValue() : 0L) * 1000, com.qiahao.base_common.utils.f.a));
    }
}
