package com.qiahao.nextvideo.ui.svip;

import android.graphics.Color;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.date.DateUtils;
import com.qiahao.base_common.model.svip.Details;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemSvipPointBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/svip/SvipPointAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/base_common/model/svip/Details;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemSvipPointBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSvipPointAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SvipPointAdapter.kt\ncom/qiahao/nextvideo/ui/svip/SvipPointAdapter\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,34:1\n439#2:35\n439#2:36\n*S KotlinDebug\n*F\n+ 1 SvipPointAdapter.kt\ncom/qiahao/nextvideo/ui/svip/SvipPointAdapter\n*L\n28#1:35\n31#1:36\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SvipPointAdapter extends BaseQuickAdapter<Details, BaseDataBindingHolder<ItemSvipPointBinding>> {
    public SvipPointAdapter() {
        super(R.layout.item_svip_point, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemSvipPointBinding> holder, @NotNull Details item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemSvipPointBinding");
        ItemSvipPointBinding itemSvipPointBinding = (ItemSvipPointBinding) dataBinding;
        itemSvipPointBinding.title.setText(item.getRemark());
        itemSvipPointBinding.subTitle.setText(DateUtils.INSTANCE.formatDate("yyyy-MM-dd HH:mm:ss", Long.valueOf(item.getCreatedTimeUnix() * 1000)));
        if (item.getAddReduce() == 1) {
            itemSvipPointBinding.diamond.setText("+" + item.getNum());
            itemSvipPointBinding.diamond.setTextColor(Color.parseColor("#27d063"));
            return;
        }
        if (item.getAddReduce() == 2) {
            itemSvipPointBinding.diamond.setText(String.valueOf(item.getNum()));
            itemSvipPointBinding.diamond.setTextColor(Color.parseColor("#ff5575"));
        }
    }
}
