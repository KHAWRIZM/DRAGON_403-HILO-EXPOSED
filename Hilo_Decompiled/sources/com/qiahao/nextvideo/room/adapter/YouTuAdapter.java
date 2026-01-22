package com.qiahao.nextvideo.room.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.youtube.YouTuBeData;
import com.qiahao.nextvideo.databinding.ItemYouTuListBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0016\u0010\r\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0016\u0010\u000e\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/YouTuAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/youtube/YouTuBeData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemYouTuListBinding;", "<init>", "()V", "parser", "Lcom/opensource/svgaplayer/SVGAParser;", "convert", "", "holder", "item", "onViewAttachedToWindow", "onViewRecycled", "showSVGA", "svga", "Lcom/opensource/svgaplayer/SVGAImageView;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class YouTuAdapter extends BaseQuickAdapter<YouTuBeData, BaseDataBindingHolder<ItemYouTuListBinding>> {

    @NotNull
    private final SVGAParser parser;

    public YouTuAdapter() {
        super(R.layout.item_you_tu_list, (List) null, 2, (DefaultConstructorMarker) null);
        this.parser = SVGAParser.Companion.shareParser();
    }

    private final void showSVGA(final SVGAImageView svga) {
        try {
            this.parser.decodeFromAssets("svga/you_tu_play.svga", new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.adapter.YouTuAdapter$showSVGA$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    Drawable sVGADrawable = new SVGADrawable(videoItem);
                    SVGAImageView sVGAImageView = svga;
                    if (sVGAImageView != null) {
                        sVGAImageView.stopAnimation(true);
                    }
                    SVGAImageView sVGAImageView2 = svga;
                    if (sVGAImageView2 != null) {
                        sVGAImageView2.setImageDrawable(sVGADrawable);
                    }
                    SVGAImageView sVGAImageView3 = svga;
                    if (sVGAImageView3 != null) {
                        sVGAImageView3.startAnimation();
                    }
                }

                public void onError() {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemYouTuListBinding> holder, @NotNull YouTuBeData item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemYouTuListBinding");
        ItemYouTuListBinding itemYouTuListBinding = (ItemYouTuListBinding) dataBinding;
        QMUIRadiusImageView qMUIRadiusImageView = itemYouTuListBinding.image;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "image");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, item.getVideoPic(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
        itemYouTuListBinding.title.setText(item.getVideoTitle());
        itemYouTuListBinding.playIcon.setVisibility(Intrinsics.areEqual(item.isPlay(), Boolean.TRUE) ? 0 : 8);
    }

    public void onViewRecycled(@NotNull BaseDataBindingHolder<ItemYouTuListBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(holder);
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemYouTuListBinding");
        ((ItemYouTuListBinding) dataBinding).playIcon.stopAnimation();
    }

    public void onViewAttachedToWindow(@NotNull BaseDataBindingHolder<ItemYouTuListBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemYouTuListBinding");
        showSVGA(((ItemYouTuListBinding) dataBinding).playIcon);
    }
}
