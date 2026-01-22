package com.qiahao.nextvideo.ui.cp;

import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.oudi.adapter.BaseMultiItemAdapter;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.cp.CpInfo;
import com.qiahao.base_common.model.cp.CpMemorial;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.cp.CpMemorialData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpMemorialAdapter;", "Lcom/oudi/adapter/BaseMultiItemAdapter;", "Lcom/qiahao/nextvideo/data/cp/CpMemorialData;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpMemorialAdapter extends BaseMultiItemAdapter<CpMemorialData, BaseViewHolder> {
    public CpMemorialAdapter() {
        super((List) null, 1, (DefaultConstructorMarker) null);
        addItemType(0, R.layout.item_cp_memorial_item);
        addItemType(1, R.layout.item_cp_memorial_top);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseViewHolder holder, @NotNull CpMemorialData item) {
        String str;
        Long timestamp;
        Long originTimestamp;
        Long timestamp2;
        Long timestamp3;
        CpInfo cpInfo;
        User cpUserInfo;
        CpInfo cpInfo2;
        User userInfo;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        int itemType = item.getItemType();
        r5 = null;
        r5 = null;
        String str2 = null;
        if (itemType != 0) {
            if (itemType != 1) {
                return;
            }
            HiloImageView view = holder.getView(R.id.leftAvatar);
            CpMemorial item2 = item.getItem();
            HiloImageView.loadImage$default(view, ImageSizeKt.image100((item2 == null || (cpInfo2 = item2.getCpInfo()) == null || (userInfo = cpInfo2.getUserInfo()) == null) ? null : userInfo.getAvatar()), 2131231655, 0, 4, (Object) null);
            HiloImageView view2 = holder.getView(R.id.rightAvatar);
            CpMemorial item3 = item.getItem();
            if (item3 != null && (cpInfo = item3.getCpInfo()) != null && (cpUserInfo = cpInfo.getCpUserInfo()) != null) {
                str2 = cpUserInfo.getAvatar();
            }
            HiloImageView.loadImage$default(view2, ImageSizeKt.image100(str2), 2131231655, 0, 4, (Object) null);
            return;
        }
        ConstraintLayout view3 = holder.getView(R.id.rootLayout);
        TextView textView = (TextView) holder.getView(2131365189);
        TextView textView2 = (TextView) holder.getView(2131365152);
        LinearLayout linearLayout = (LinearLayout) holder.getView(R.id.timeLayout);
        TextView textView3 = (TextView) holder.getView(R.id.timeTitle);
        TextView textView4 = (TextView) holder.getView(R.id.timeNumber);
        TextView textView5 = (TextView) holder.getView(R.id.today);
        ImageView imageView = (ImageView) holder.getView(R.id.addImage);
        CpMemorial item4 = item.getItem();
        if (item4 == null || (str = item4.getContent()) == null) {
            str = "";
        }
        textView.setText(str);
        CpMemorial item5 = item.getItem();
        if ((item5 != null ? item5.getTimestamp() : null) != null) {
            CpMemorial item6 = item.getItem();
            if (((item6 == null || (timestamp3 = item6.getTimestamp()) == null) ? 0L : timestamp3.longValue()) != 0) {
                Long valueOf = Long.valueOf(com.qiahao.base_common.utils.f.e());
                CpMemorial item7 = item.getItem();
                long j = 1000;
                double d = com.qiahao.base_common.utils.f.d(valueOf, Long.valueOf(((item7 == null || (timestamp2 = item7.getTimestamp()) == null) ? 0L : timestamp2.longValue()) * j));
                CpMemorial item8 = item.getItem();
                textView2.setText(com.qiahao.base_common.utils.f.h(((item8 == null || (originTimestamp = item8.getOriginTimestamp()) == null) ? 0L : originTimestamp.longValue()) * j, com.qiahao.base_common.utils.f.b));
                CpMemorial item9 = item.getItem();
                if (com.qiahao.base_common.utils.f.g(((item9 == null || (timestamp = item9.getTimestamp()) == null) ? 0L : timestamp.longValue()) * j, com.qiahao.base_common.utils.f.e())) {
                    textView2.setVisibility(0);
                    textView5.setVisibility(0);
                    linearLayout.setVisibility(8);
                    imageView.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    textView5.setVisibility(8);
                    linearLayout.setVisibility(0);
                    imageView.setVisibility(8);
                    textView4.setText(String.valueOf((int) Math.ceil(Math.abs(d))));
                    if (d > 0.0d) {
                        textView3.setText(ResourcesKtxKt.getStringById(this, 2131951983));
                        textView3.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffbd6d", "#ffbd6d", 5, (GradientDrawable.Orientation) null, 8, (Object) null));
                    } else {
                        textView3.setText(ResourcesKtxKt.getStringById(this, 2131953609));
                        textView3.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#94cbff", "#94cbff", 5, (GradientDrawable.Orientation) null, 8, (Object) null));
                    }
                }
                CpMemorial item10 = item.getItem();
                if (item10 != null && item10.isTop()) {
                    view3.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.cp_memoril_item_bg_select));
                    return;
                } else {
                    view3.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.cp_memoril_item_bg));
                    return;
                }
            }
        }
        textView2.setVisibility(8);
        textView5.setVisibility(8);
        linearLayout.setVisibility(8);
        imageView.setVisibility(0);
    }
}
