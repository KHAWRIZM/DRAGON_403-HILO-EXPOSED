package com.qiahao.nextvideo.ui.home.matching;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.StringKtxKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.databinding.ItemMatchGameBinding;
import java.io.File;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0016\u0010\u000b\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0016\u0010\f\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/matching/MatchGameListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemMatchGameBinding;", "<init>", "()V", "convert", "", "holder", "item", "onViewRecycled", "onViewAttachedToWindow", "playSvga", "svgaView", "Lcom/opensource/svgaplayer/SVGAImageView;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MatchGameListAdapter extends BaseQuickAdapter<GameConfiguration, BaseDataBindingHolder<ItemMatchGameBinding>> {
    public MatchGameListAdapter() {
        super(R.layout.item_match_game, (List) null, 2, (DefaultConstructorMarker) null);
    }

    private final void playSvga(final SVGAImageView svgaView) {
        try {
            String obj = svgaView.getTag().toString();
            if (!TextUtils.isEmpty(obj)) {
                SVGAParser.Companion.shareParser().decodeFromURL(new URL(obj + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.home.matching.MatchGameListAdapter$playSvga$1
                    public void onComplete(SVGAVideoEntity videoItem) {
                        Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                        svgaView.stopAnimation(true);
                        svgaView.setImageDrawable(new SVGADrawable(videoItem));
                        svgaView.startAnimation();
                    }

                    public void onError() {
                    }
                });
            }
        } catch (Exception unused) {
            svgaView.setTag("");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemMatchGameBinding> holder, @NotNull GameConfiguration item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemMatchGameBinding");
        ItemMatchGameBinding itemMatchGameBinding = (ItemMatchGameBinding) dataBinding;
        String icon = item.getIcon();
        if (icon != null && StringKtxKt.checkEndSVGA(icon)) {
            SVGAImageView sVGAImageView = itemMatchGameBinding.svga;
            String icon2 = item.getIcon();
            if (icon2 == null) {
                icon2 = "";
            }
            sVGAImageView.setTag(icon2);
            itemMatchGameBinding.svga.setVisibility(0);
            itemMatchGameBinding.image.setVisibility(8);
        } else {
            itemMatchGameBinding.svga.setTag("");
            itemMatchGameBinding.svga.setVisibility(8);
            itemMatchGameBinding.image.setVisibility(0);
            ImageView imageView = itemMatchGameBinding.image;
            Intrinsics.checkNotNullExpressionValue(imageView, "image");
            ImageKtxKt.loadImage$default(imageView, ImageSizeKt.image100(item.getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        }
        TextView textView = itemMatchGameBinding.title;
        String title = item.getTitle();
        if (title == null) {
            title = "";
        }
        textView.setText(title);
        ConstraintLayout constraintLayout = itemMatchGameBinding.constraintLayout;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        String startColor = item.getStartColor();
        if (startColor == null) {
            startColor = "";
        }
        String endColor = item.getEndColor();
        if (endColor == null) {
            endColor = "";
        }
        constraintLayout.setBackground(shapeUtil.createShape(startColor, endColor, 10, GradientDrawable.Orientation.TOP_BOTTOM));
        TextView textView2 = itemMatchGameBinding.subTitle;
        String desc = item.getDesc();
        textView2.setText(desc != null ? desc : "");
    }

    public void onViewRecycled(@NotNull BaseDataBindingHolder<ItemMatchGameBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(holder);
        holder.getView(2131364958).stopAnimation();
    }

    public void onViewAttachedToWindow(@NotNull BaseDataBindingHolder<ItemMatchGameBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        playSvga((SVGAImageView) holder.getView(2131364958));
    }
}
