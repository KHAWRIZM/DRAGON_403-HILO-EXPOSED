package com.qiahao.nextvideo.ui.cp;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.StringKtxKt;
import com.qiahao.base_common.model.cp.CpResLevel;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import java.io.File;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ9\u0010\u0010\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpBannerAdapter;", "Lcom/zhpan/bannerview/e;", "Lcom/qiahao/base_common/model/cp/CpResLevel;", "<init>", "()V", "Lcom/opensource/svgaplayer/SVGAImageView;", "svga", "", "showSVGA", "(Lcom/opensource/svgaplayer/SVGAImageView;)V", "Lcom/zhpan/bannerview/f;", "holder", "data", "", "position", "pageSize", "bindData", "(Lcom/zhpan/bannerview/f;Lcom/qiahao/base_common/model/cp/CpResLevel;II)V", "viewType", "getLayoutId", "(I)I", "onViewAttachedToWindow", "(Lcom/zhpan/bannerview/f;)V", "onViewRecycled", "Lcom/opensource/svgaplayer/SVGAParser;", "parser", "Lcom/opensource/svgaplayer/SVGAParser;", CpSpaceActivity.RELATION_TYPE, "I", "getRelationType", "()I", "setRelationType", "(I)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpBannerAdapter extends com.zhpan.bannerview.e {

    @NotNull
    private final SVGAParser parser = SVGAParser.Companion.shareParser();
    private int relationType = 1;

    private final void showSVGA(final SVGAImageView svga) {
        Object tag;
        Object tag2;
        if (svga != null) {
            try {
                tag = svga.getTag();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            tag = null;
        }
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.String");
        if (!TextUtils.isEmpty((String) tag) && (tag2 = svga.getTag()) != null) {
            this.parser.decodeFromURL(new URL((String) tag2), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.cp.CpBannerAdapter$showSVGA$1$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    Drawable sVGADrawable = new SVGADrawable(videoItem);
                    svga.stopAnimation(true);
                    svga.setImageDrawable(sVGADrawable);
                    svga.startAnimation();
                    svga.setVisibility(0);
                }

                public void onError() {
                }
            });
        }
    }

    @Override // com.zhpan.bannerview.e
    public int getLayoutId(int viewType) {
        return R.layout.item_cp_medal;
    }

    public final int getRelationType() {
        return this.relationType;
    }

    public final void setRelationType(int i) {
        this.relationType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zhpan.bannerview.e
    public void bindData(@Nullable com.zhpan.bannerview.f holder, @Nullable CpResLevel data, int position, int pageSize) {
        int i;
        String str;
        String medalEffectUrl;
        TextView textView = holder != null ? (TextView) holder.a(2131365189) : null;
        ImageView imageView = holder != null ? (ImageView) holder.a(2131363201) : null;
        if (position == 0 && this.relationType == 1) {
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else if (textView != null) {
            textView.setVisibility(8);
        }
        if (data != null && (medalEffectUrl = data.getMedalEffectUrl()) != null && StringKtxKt.checkEndSVGA(medalEffectUrl)) {
            SVGAImageView a = holder != null ? holder.a(2131364958) : null;
            if (a != null) {
                String medalEffectUrl2 = data.getMedalEffectUrl();
                a.setTag(medalEffectUrl2 != null ? medalEffectUrl2 : "");
            }
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        if (imageView != null) {
            if (data == null || (str = data.getMedalEffectUrl()) == null) {
                str = "";
            }
            i = 0;
            ImageKtxKt.loadImage$default(imageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        } else {
            i = 0;
        }
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public void onViewAttachedToWindow(@NotNull com.zhpan.bannerview.f holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        showSVGA((SVGAImageView) holder.a(2131364958));
    }

    public void onViewRecycled(@NotNull com.zhpan.bannerview.f holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        SVGAImageView a = holder.a(2131364958);
        a.stopAnimation();
        a.setVisibility(8);
    }
}
