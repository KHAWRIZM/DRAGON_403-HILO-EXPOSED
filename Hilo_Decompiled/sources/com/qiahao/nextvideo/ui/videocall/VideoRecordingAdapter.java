package com.qiahao.nextvideo.ui.videocall;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.VideoBaseData;
import com.qiahao.nextvideo.databinding.ItemVideoBinding;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J,\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0014¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/VideoRecordingAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/VideoBaseData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemVideoBinding;", "<init>", "()V", "convert", "", "holder", "item", "payloads", "", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVideoRecordingAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VideoRecordingAdapter.kt\ncom/qiahao/nextvideo/ui/videocall/VideoRecordingAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,81:1\n1869#2,2:82\n*S KotlinDebug\n*F\n+ 1 VideoRecordingAdapter.kt\ncom/qiahao/nextvideo/ui/videocall/VideoRecordingAdapter\n*L\n66#1:82,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoRecordingAdapter extends BaseQuickAdapter<VideoBaseData, BaseDataBindingHolder<ItemVideoBinding>> {
    public VideoRecordingAdapter() {
        super(R.layout.item_video, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj, List list) {
        convert((BaseDataBindingHolder<ItemVideoBinding>) baseViewHolder, (VideoBaseData) obj, (List<? extends Object>) list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemVideoBinding> holder, @NotNull VideoBaseData item) {
        ImageView imageView;
        LinearLayout linearLayout;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        AppCompatImageView appCompatImageView3;
        LinearLayout linearLayout2;
        ImageView imageView2;
        AppCompatImageView appCompatImageView4;
        QMUIRadiusImageView2 qMUIRadiusImageView2;
        AppCompatTextView appCompatTextView;
        GenderAgeTextView genderAgeTextView;
        GenderAgeTextView genderAgeTextView2;
        AppCompatTextView appCompatTextView2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemVideoBinding itemVideoBinding = (ItemVideoBinding) holder.getDataBinding();
        if (itemVideoBinding != null && (appCompatTextView2 = itemVideoBinding.name) != null) {
            String nick = item.getNick();
            if (nick == null) {
                nick = "";
            }
            appCompatTextView2.setText(nick);
        }
        ItemVideoBinding itemVideoBinding2 = (ItemVideoBinding) holder.getDataBinding();
        if (itemVideoBinding2 != null && (genderAgeTextView2 = itemVideoBinding2.ageTextView) != null) {
            Resources resources = getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            Integer sex = item.getSex();
            ViewUtilitiesKt.setDrawableLeft(genderAgeTextView2, ResourceUtilsKt.getDrawable(resources, (sex != null && sex.intValue() == 1) ? R.drawable.icon_boy : R.drawable.icon_girl, 0));
        }
        ItemVideoBinding itemVideoBinding3 = (ItemVideoBinding) holder.getDataBinding();
        if (itemVideoBinding3 != null && (genderAgeTextView = itemVideoBinding3.ageTextView) != null) {
            Integer sex2 = item.getSex();
            genderAgeTextView.setBackgroundResource((sex2 != null && sex2.intValue() == 1) ? R.drawable.bg_age_male : R.drawable.bg_age_female);
        }
        ItemVideoBinding itemVideoBinding4 = (ItemVideoBinding) holder.getDataBinding();
        if (itemVideoBinding4 != null && (appCompatTextView = itemVideoBinding4.ageTextView) != null) {
            appCompatTextView.setText(item.getAge());
        }
        ItemVideoBinding itemVideoBinding5 = (ItemVideoBinding) holder.getDataBinding();
        if (itemVideoBinding5 != null && (qMUIRadiusImageView2 = itemVideoBinding5.image) != null) {
            ViewUtilitiesKt.bind$default(qMUIRadiusImageView2, ImageUIModel.Companion.displayUserAvatarImage$default(ImageUIModel.INSTANCE, item.getAvatar(), null, 2, null), null, 2, null);
        }
        ItemVideoBinding itemVideoBinding6 = (ItemVideoBinding) holder.getDataBinding();
        if (itemVideoBinding6 != null && (appCompatImageView4 = itemVideoBinding6.fromCountryImageView) != null) {
            ImageKtxKt.loadImage$default(appCompatImageView4, item.getCountryIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        }
        Boolean isVip = item.isVip();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(isVip, bool)) {
            ItemVideoBinding itemVideoBinding7 = (ItemVideoBinding) holder.getDataBinding();
            if (itemVideoBinding7 != null && (imageView2 = itemVideoBinding7.iconVip) != null) {
                imageView2.setVisibility(0);
            }
        } else {
            ItemVideoBinding itemVideoBinding8 = (ItemVideoBinding) holder.getDataBinding();
            if (itemVideoBinding8 != null && (imageView = itemVideoBinding8.iconVip) != null) {
                imageView.setVisibility(8);
            }
        }
        if (Intrinsics.areEqual(item.isOnline(), bool)) {
            ItemVideoBinding itemVideoBinding9 = (ItemVideoBinding) holder.getDataBinding();
            if (itemVideoBinding9 != null && (linearLayout2 = itemVideoBinding9.stateLayout) != null) {
                linearLayout2.setVisibility(0);
            }
        } else {
            ItemVideoBinding itemVideoBinding10 = (ItemVideoBinding) holder.getDataBinding();
            if (itemVideoBinding10 != null && (linearLayout = itemVideoBinding10.stateLayout) != null) {
                linearLayout.setVisibility(8);
            }
        }
        if (Intrinsics.areEqual(item.isLike(), bool) && Intrinsics.areEqual(item.isLikeMe(), bool)) {
            ItemVideoBinding itemVideoBinding11 = (ItemVideoBinding) holder.getDataBinding();
            if (itemVideoBinding11 == null || (appCompatImageView3 = itemVideoBinding11.likeImageView) == null) {
                return;
            }
            ImageKtxKt.loadImage$default(appCompatImageView3, (String) null, (Uri) null, (File) null, 2131232578, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            return;
        }
        if (Intrinsics.areEqual(item.isLike(), bool) && Intrinsics.areEqual(item.isLikeMe(), Boolean.FALSE)) {
            ItemVideoBinding itemVideoBinding12 = (ItemVideoBinding) holder.getDataBinding();
            if (itemVideoBinding12 == null || (appCompatImageView2 = itemVideoBinding12.likeImageView) == null) {
                return;
            }
            ImageKtxKt.loadImage$default(appCompatImageView2, (String) null, (Uri) null, (File) null, 2131232579, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            return;
        }
        ItemVideoBinding itemVideoBinding13 = (ItemVideoBinding) holder.getDataBinding();
        if (itemVideoBinding13 == null || (appCompatImageView = itemVideoBinding13.likeImageView) == null) {
            return;
        }
        ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, (File) null, 2131232577, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
    }

    protected void convert(@NotNull BaseDataBindingHolder<ItemVideoBinding> holder, @NotNull VideoBaseData item, @NotNull List<? extends Object> payloads) {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        AppCompatImageView appCompatImageView3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Iterator<T> it = payloads.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof Boolean) {
                Boolean isLike = item.isLike();
                Boolean bool = Boolean.TRUE;
                if (Intrinsics.areEqual(isLike, bool) && Intrinsics.areEqual(item.isLikeMe(), bool)) {
                    ItemVideoBinding itemVideoBinding = (ItemVideoBinding) holder.getDataBinding();
                    if (itemVideoBinding != null && (appCompatImageView3 = itemVideoBinding.likeImageView) != null) {
                        ImageKtxKt.loadImage$default(appCompatImageView3, (String) null, (Uri) null, (File) null, 2131232578, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                    }
                } else if (Intrinsics.areEqual(item.isLike(), bool) && Intrinsics.areEqual(item.isLikeMe(), Boolean.FALSE)) {
                    ItemVideoBinding itemVideoBinding2 = (ItemVideoBinding) holder.getDataBinding();
                    if (itemVideoBinding2 != null && (appCompatImageView2 = itemVideoBinding2.likeImageView) != null) {
                        ImageKtxKt.loadImage$default(appCompatImageView2, (String) null, (Uri) null, (File) null, 2131232579, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                    }
                } else {
                    ItemVideoBinding itemVideoBinding3 = (ItemVideoBinding) holder.getDataBinding();
                    if (itemVideoBinding3 != null && (appCompatImageView = itemVideoBinding3.likeImageView) != null) {
                        ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, (File) null, 2131232577, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                    }
                }
            }
        }
    }
}
