package com.qiahao.nextvideo.ui.cp;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.RelationTypeUtils;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.cp.CpRecord;
import com.qiahao.nextvideo.databinding.ItemCpRecordBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0016\u0010\r\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0016\u0010\u000e\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0016\u0010\u000f\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpRecordAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/cp/CpRecord;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemCpRecordBinding;", "<init>", "()V", "parser", "Lcom/opensource/svgaplayer/SVGAParser;", "convert", "", "holder", "item", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "showSVGA", "svga", "Lcom/opensource/svgaplayer/SVGAImageView;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCpRecordAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpRecordAdapter.kt\ncom/qiahao/nextvideo/ui/cp/CpRecordAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,73:1\n1#2:74\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpRecordAdapter extends BaseQuickAdapter<CpRecord, BaseDataBindingHolder<ItemCpRecordBinding>> {

    @NotNull
    private final SVGAParser parser;

    public CpRecordAdapter() {
        super(R.layout.item_cp_record, (List) null, 2, (DefaultConstructorMarker) null);
        this.parser = SVGAParser.Companion.shareParser();
    }

    private final void showSVGA(final SVGAImageView svga) {
        try {
            this.parser.decodeFromAssets("svga/cp_rank.svga", new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.cp.CpRecordAdapter$showSVGA$1
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
    public void convert(@NotNull BaseDataBindingHolder<ItemCpRecordBinding> holder, @NotNull CpRecord item) {
        String str;
        String nick;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemCpRecordBinding");
        ItemCpRecordBinding itemCpRecordBinding = (ItemCpRecordBinding) dataBinding;
        HiloImageView hiloImageView = itemCpRecordBinding.avatar1;
        User user1 = item.getUser1();
        HiloImageView.loadImage$default(hiloImageView, ImageSizeKt.image100(user1 != null ? user1.getAvatar() : null), 2131231655, 0, 4, (Object) null);
        NickTextView nickTextView = itemCpRecordBinding.userName1;
        User user12 = item.getUser1();
        String str2 = "";
        if (user12 == null || (str = user12.getNick()) == null) {
            str = "";
        }
        nickTextView.setText(str);
        TextView textView = itemCpRecordBinding.title;
        String typeDesc = item.getTypeDesc();
        if (typeDesc == null) {
            typeDesc = "";
        }
        textView.setText(typeDesc);
        HiloImageView hiloImageView2 = itemCpRecordBinding.avatar2;
        User user2 = item.getUser2();
        HiloImageView.loadImage$default(hiloImageView2, ImageSizeKt.image100(user2 != null ? user2.getAvatar() : null), 2131231655, 0, 4, (Object) null);
        NickTextView nickTextView2 = itemCpRecordBinding.userName2;
        User user22 = item.getUser2();
        if (user22 != null && (nick = user22.getNick()) != null) {
            str2 = nick;
        }
        nickTextView2.setText(str2);
        TextView textView2 = itemCpRecordBinding.time;
        Long timeUnix = item.getTimeUnix();
        textView2.setText(com.qiahao.base_common.utils.f.h((timeUnix != null ? timeUnix.longValue() : 0L) * 1000, com.qiahao.base_common.utils.f.e));
        ImageView imageView = itemCpRecordBinding.medal;
        Integer relationMedal$default = RelationTypeUtils.getRelationMedal$default(RelationTypeUtils.INSTANCE, item.getCpLevel(), true, 0, 4, (Object) null);
        imageView.setImageDrawable(relationMedal$default != null ? androidx.core.content.a.getDrawable(getContext(), relationMedal$default.intValue()) : null);
    }

    public void onViewDetachedFromWindow(@NotNull BaseDataBindingHolder<ItemCpRecordBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewDetachedFromWindow(holder);
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemCpRecordBinding");
        ((ItemCpRecordBinding) dataBinding).svga.stopAnimation();
    }

    public void onViewRecycled(@NotNull BaseDataBindingHolder<ItemCpRecordBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(holder);
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemCpRecordBinding");
        ((ItemCpRecordBinding) dataBinding).svga.stopAnimation();
    }

    public void onViewAttachedToWindow(@NotNull BaseDataBindingHolder<ItemCpRecordBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemCpRecordBinding");
        showSVGA(((ItemCpRecordBinding) dataBinding).svga);
    }
}
