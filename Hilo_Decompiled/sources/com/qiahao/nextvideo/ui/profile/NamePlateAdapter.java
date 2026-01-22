package com.qiahao.nextvideo.ui.profile;

import android.util.Log;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.NamePlateData;
import com.qiahao.nextvideo.databinding.ItemNamePlateBinding;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0016\u0010\u000b\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0016\u0010\f\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/NamePlateAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/NamePlateData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemNamePlateBinding;", "<init>", "()V", "convert", "", "holder", "item", "onViewRecycled", "onViewAttachedToWindow", "showSvga", "binding", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNamePlateAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NamePlateAdapter.kt\ncom/qiahao/nextvideo/ui/profile/NamePlateAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,59:1\n1#2:60\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class NamePlateAdapter extends BaseQuickAdapter<NamePlateData, BaseDataBindingHolder<ItemNamePlateBinding>> {
    public NamePlateAdapter() {
        super(R.layout.item_name_plate, (List) null, 2, (DefaultConstructorMarker) null);
    }

    private final void showSvga(final ItemNamePlateBinding binding) {
        try {
            SVGAParser.Companion.shareParser().decodeFromURL(new URL(binding.svga.getTag() + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.profile.NamePlateAdapter$showSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    ItemNamePlateBinding.this.svga.stopAnimation(true);
                    ItemNamePlateBinding.this.svga.setImageDrawable(new SVGADrawable(videoItem));
                    ItemNamePlateBinding.this.svga.startAnimation();
                }

                public void onError() {
                    Log.d("gameMicAdapter", "onError: ----------");
                }
            });
        } catch (Exception e) {
            DebugToolsKt.printfE("gameMicAdapter", "eventRelay 内部try()catch{}" + e.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemNamePlateBinding> holder, @NotNull NamePlateData item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemNamePlateBinding");
        ItemNamePlateBinding itemNamePlateBinding = (ItemNamePlateBinding) dataBinding;
        itemNamePlateBinding.svga.setTag(item.getSvgaUrl());
        showSvga(itemNamePlateBinding);
    }

    public void onViewRecycled(@NotNull BaseDataBindingHolder<ItemNamePlateBinding> holder) {
        SVGAImageView sVGAImageView;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(holder);
        ItemNamePlateBinding itemNamePlateBinding = (ItemNamePlateBinding) holder.getDataBinding();
        if (itemNamePlateBinding == null || (sVGAImageView = itemNamePlateBinding.svga) == null) {
            return;
        }
        sVGAImageView.stopAnimation();
    }

    public void onViewAttachedToWindow(@NotNull BaseDataBindingHolder<ItemNamePlateBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        ItemNamePlateBinding itemNamePlateBinding = (ItemNamePlateBinding) holder.getDataBinding();
        if (itemNamePlateBinding != null) {
            showSvga(itemNamePlateBinding);
        }
    }
}
