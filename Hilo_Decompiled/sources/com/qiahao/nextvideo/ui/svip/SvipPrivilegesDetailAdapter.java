package com.qiahao.nextvideo.ui.svip;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.qiahao.base_common.model.svip.SvipPrivilege;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemPrivilegesDetailsBinding;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0014J,\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0013\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/ui/svip/SvipPrivilegesDetailAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/base_common/model/svip/SvipPrivilege;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemPrivilegesDetailsBinding;", "<init>", "()V", "selectPosition", "", "getSelectPosition", "()I", "setSelectPosition", "(I)V", "mCurrentLevel", "getMCurrentLevel", "setMCurrentLevel", "convert", "", "holder", "item", "payloads", "", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSvipPrivilegesDetailAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SvipPrivilegesDetailAdapter.kt\ncom/qiahao/nextvideo/ui/svip/SvipPrivilegesDetailAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,45:1\n1869#2,2:46\n*S KotlinDebug\n*F\n+ 1 SvipPrivilegesDetailAdapter.kt\ncom/qiahao/nextvideo/ui/svip/SvipPrivilegesDetailAdapter\n*L\n37#1:46,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SvipPrivilegesDetailAdapter extends BaseQuickAdapter<SvipPrivilege, BaseDataBindingHolder<ItemPrivilegesDetailsBinding>> {
    private int mCurrentLevel;
    private int selectPosition;

    public SvipPrivilegesDetailAdapter() {
        super(R.layout.item_privileges_details, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public final int getMCurrentLevel() {
        return this.mCurrentLevel;
    }

    public final int getSelectPosition() {
        return this.selectPosition;
    }

    public final void setMCurrentLevel(int i) {
        this.mCurrentLevel = i;
    }

    public final void setSelectPosition(int i) {
        this.selectPosition = i;
    }

    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj, List list) {
        convert((BaseDataBindingHolder<ItemPrivilegesDetailsBinding>) baseViewHolder, (SvipPrivilege) obj, (List<? extends Object>) list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemPrivilegesDetailsBinding> holder, @NotNull SvipPrivilege item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemPrivilegesDetailsBinding");
        ItemPrivilegesDetailsBinding itemPrivilegesDetailsBinding = (ItemPrivilegesDetailsBinding) dataBinding;
        itemPrivilegesDetailsBinding.indicator.setVisibility(this.selectPosition == holder.getAdapterPosition() ? 0 : 8);
        ImageView imageView = itemPrivilegesDetailsBinding.image;
        Intrinsics.checkNotNullExpressionValue(imageView, "image");
        ImageKtxKt.loadImage$default(imageView, this.mCurrentLevel >= 11 ? item.getActiveUrl2() : item.getActiveUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
    }

    protected void convert(@NotNull BaseDataBindingHolder<ItemPrivilegesDetailsBinding> holder, @NotNull SvipPrivilege item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemPrivilegesDetailsBinding");
        ItemPrivilegesDetailsBinding itemPrivilegesDetailsBinding = (ItemPrivilegesDetailsBinding) dataBinding;
        Iterator<T> it = payloads.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof Integer) {
                itemPrivilegesDetailsBinding.indicator.setVisibility(this.selectPosition == holder.getAdapterPosition() ? 0 : 8);
            }
        }
    }
}
