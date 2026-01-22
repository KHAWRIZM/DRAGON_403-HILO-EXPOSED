package com.qiahao.nextvideo.ui.home.medal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.data.model.MedalAllTypeBean;
import com.qiahao.nextvideo.databinding.ItemAllMedalBinding;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/medal/AllTypeMedalAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/MedalAllTypeBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemAllMedalBinding;", "layout", "", "<init>", "(I)V", "fragmentType", "", "getFragmentType", "()Ljava/lang/String;", "setFragmentType", "(Ljava/lang/String;)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AllTypeMedalAdapter extends BaseQuickAdapter<MedalAllTypeBean, BaseDataBindingHolder<ItemAllMedalBinding>> {

    @NotNull
    private String fragmentType;

    public AllTypeMedalAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
        this.fragmentType = "";
    }

    @NotNull
    public final String getFragmentType() {
        return this.fragmentType;
    }

    public final void setFragmentType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fragmentType = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemAllMedalBinding> holder, @NotNull MedalAllTypeBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemAllMedalBinding");
        ItemAllMedalBinding itemAllMedalBinding = (ItemAllMedalBinding) dataBinding;
        Dimens dimens = Dimens.INSTANCE;
        int screenWidth = ((dimens.getScreenWidth() - dimens.dpToPx(58)) - dimens.dpToPx(33)) / 2;
        GridLayoutManager.LayoutParams layoutParams = itemAllMedalBinding.content.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
        GridLayoutManager.LayoutParams layoutParams2 = layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = screenWidth;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = -2;
        itemAllMedalBinding.content.setLayoutParams(layoutParams2);
        if (Intrinsics.areEqual(this.fragmentType, MedalActivity.TYPE_PERSONAL)) {
            TextView textView = itemAllMedalBinding.medalTypeName;
            String name = item.getName();
            textView.setText(name != null ? name : "");
            ImageView imageView = itemAllMedalBinding.medalImg;
            Intrinsics.checkNotNullExpressionValue(imageView, "medalImg");
            ImageKtxKt.loadImage$default(imageView, ImageSizeKt.image200(item.getPicUrl()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            return;
        }
        TextView textView2 = itemAllMedalBinding.medalTypeName;
        String desc = item.getDesc();
        textView2.setText(desc != null ? desc : "");
        ImageView imageView2 = itemAllMedalBinding.medalImg;
        Intrinsics.checkNotNullExpressionValue(imageView2, "medalImg");
        ImageKtxKt.loadImage$default(imageView2, ImageSizeKt.image200(item.getPreviewUrl()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
    }
}
