package com.qiahao.nextvideo.ui.cp;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.model.cp.CpPrivilege;
import com.qiahao.base_common.utils.RelationTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemCpSpaceBinding;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpSpaceAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/base_common/model/cp/CpPrivilege;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemCpSpaceBinding;", "<init>", "()V", CpSpaceActivity.RELATION_TYPE, "", "getRelationType", "()I", "setRelationType", "(I)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCpSpaceAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpSpaceAdapter.kt\ncom/qiahao/nextvideo/ui/cp/CpSpaceAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,30:1\n1#2:31\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpSpaceAdapter extends BaseQuickAdapter<CpPrivilege, BaseDataBindingHolder<ItemCpSpaceBinding>> {
    private int relationType;

    public CpSpaceAdapter() {
        super(R.layout.item_cp_space, (List) null, 2, (DefaultConstructorMarker) null);
        this.relationType = 1;
    }

    public final int getRelationType() {
        return this.relationType;
    }

    public final void setRelationType(int i) {
        this.relationType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemCpSpaceBinding> holder, @NotNull CpPrivilege item) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemCpSpaceBinding");
        ItemCpSpaceBinding itemCpSpaceBinding = (ItemCpSpaceBinding) dataBinding;
        ImageView imageView = itemCpSpaceBinding.bg;
        Integer spaceRelationIcon19 = RelationTypeUtils.INSTANCE.spaceRelationIcon19(this.relationType);
        if (spaceRelationIcon19 != null) {
            drawable = androidx.core.content.a.getDrawable(getContext(), spaceRelationIcon19.intValue());
        } else {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
        ImageView imageView2 = itemCpSpaceBinding.privilegeImage;
        Intrinsics.checkNotNullExpressionValue(imageView2, "privilegeImage");
        ImageKtxKt.loadImage$default(imageView2, item.getIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        itemCpSpaceBinding.title.setText(item.getName());
    }
}
