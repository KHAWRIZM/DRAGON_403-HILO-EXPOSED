package com.qiahao.nextvideo.ui.home.earn;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.a;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.EarnDiamondDailyBean;
import com.qiahao.nextvideo.databinding.ItemDailyEarnDiamondTaskBinding;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0015J(\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0012H\u0002¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/earn/EarnDiamondAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/EarnDiamondDailyBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemDailyEarnDiamondTaskBinding;", "layout", "", "<init>", "(I)V", "convert", "", "holder", "item", "showIconTextDiamond", "data", "image1", "Landroid/widget/ImageView;", "text1", "Landroid/widget/TextView;", "text2", "setTextDiamond", "isDiamond", "", "textView", "changeClickThemes", "hasFinish", "hasAward", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class EarnDiamondAdapter extends BaseQuickAdapter<EarnDiamondDailyBean, BaseDataBindingHolder<ItemDailyEarnDiamondTaskBinding>> {
    public EarnDiamondAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    private final void changeClickThemes(int hasFinish, int hasAward, TextView textView) {
        if (hasFinish == 2) {
            textView.setTextColor(Color.parseColor("#9036ff"));
            textView.setText(2131952906);
            textView.setBackgroundResource(R.drawable.shape_earn_diamond_go);
        } else if (hasAward == 2) {
            textView.setTextColor(Color.parseColor("#ffffff"));
            textView.setText(2131952873);
            textView.setBackgroundResource(R.drawable.shape_earn_diamond_get);
        } else {
            textView.setTextColor(Color.parseColor("#a28fff"));
            textView.setText(2131952587);
            textView.setBackgroundResource(R.drawable.shape_earn_diamond_done);
        }
    }

    private final void setTextDiamond(boolean isDiamond, TextView textView) {
        if (isDiamond) {
            Drawable drawable = a.getDrawable(getContext(), R.drawable.ic_lucky_diamond);
            if (drawable != null) {
                drawable.setBounds(0, 0, UiKtxKt.toPX(16), UiKtxKt.toPX(14));
            }
            textView.setCompoundDrawables(drawable, null, null, null);
            return;
        }
        Drawable drawable2 = a.getDrawable(getContext(), 2131231913);
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, UiKtxKt.toPX(16), UiKtxKt.toPX(16));
        }
        textView.setCompoundDrawables(drawable2, null, null, null);
    }

    private final void showIconTextDiamond(EarnDiamondDailyBean data, ImageView image1, TextView text1, TextView text2) {
        setTextDiamond(true, text2);
        int type = data.getType();
        Integer valueOf = Integer.valueOf(R.drawable.ic_earn_level);
        Integer valueOf2 = Integer.valueOf(R.drawable.ic_video_random);
        Integer valueOf3 = Integer.valueOf(R.drawable.ic_earn_up_mic);
        Integer valueOf4 = Integer.valueOf(R.drawable.ic_earn_gift);
        String str = "";
        switch (type) {
            case 1:
                ImageKtxKt.loadImage$default(image1, (String) null, (Uri) null, (File) null, valueOf3, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                text1.setText(ResourcesKtxKt.getStringById(this, 2131954226));
                return;
            case 2:
                ImageKtxKt.loadImage$default(image1, (String) null, (Uri) null, (File) null, valueOf4, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                text1.setText(ResourcesKtxKt.getStringById(this, 2131954030));
                return;
            case 3:
                ImageKtxKt.loadImage$default(image1, (String) null, (Uri) null, (File) null, valueOf4, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                text1.setText(ResourcesKtxKt.getStringById(this, 2131954031));
                return;
            case 4:
                ImageKtxKt.loadImage$default(image1, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_earn_room_member_broadcast), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                text1.setText(ResourcesKtxKt.getStringById(this, 2131954042));
                return;
            case 5:
                ImageKtxKt.loadImage$default(image1, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_earn_global_broadcast), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                text1.setText(ResourcesKtxKt.getStringById(this, 2131954037));
                return;
            case 6:
                ImageKtxKt.loadImage$default(image1, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_earn_first_chrage), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                text1.setText(ResourcesKtxKt.getStringById(this, 2131952758));
                return;
            case 7:
                ImageKtxKt.loadImage$default(image1, (String) null, (Uri) null, (File) null, valueOf, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                text1.setText(ResourcesKtxKt.getStringById(this, 2131953835));
                return;
            case 8:
            default:
                ImageKtxKt.loadImage$default(image1, (String) null, (Uri) null, (File) null, valueOf3, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                text1.setText("");
                return;
            case 9:
                ImageKtxKt.loadImage$default(image1, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_earn_video), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                text1.setText(ResourcesKtxKt.getStringById(this, 2131952606));
                return;
            case 10:
                ImageKtxKt.loadImage$default(image1, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_task_video), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                String format = String.format(ResourcesKtxKt.getStringById(this, 2131954234), Arrays.copyOf(new Object[]{Integer.valueOf(data.getFinishN())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                text1.setText(format);
                return;
            case 11:
                ImageKtxKt.loadImage$default(image1, (String) null, (Uri) null, (File) null, valueOf2, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131954235), Arrays.copyOf(new Object[]{Integer.valueOf(data.getFinishN())}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                text1.setText(format2);
                return;
            case 12:
                setTextDiamond(false, text2);
                ImageKtxKt.loadImage$default(image1, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_earn_super_like), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                String taskText = data.getTaskText();
                if (taskText == null) {
                    taskText = "";
                }
                text1.setText(taskText);
                return;
            case 13:
                setTextDiamond(false, text2);
                ImageKtxKt.loadImage$default(image1, (String) null, (Uri) null, (File) null, valueOf4, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                String taskText2 = data.getTaskText();
                if (taskText2 == null) {
                    taskText2 = "";
                }
                text1.setText(taskText2);
                return;
            case 14:
                setTextDiamond(false, text2);
                ImageKtxKt.loadImage$default(image1, (String) null, (Uri) null, (File) null, valueOf, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                String taskText3 = data.getTaskText();
                if (taskText3 == null) {
                    taskText3 = "";
                }
                text1.setText(taskText3);
                return;
            case 15:
                setTextDiamond(false, text2);
                ImageKtxKt.loadImage$default(image1, (String) null, (Uri) null, (File) null, valueOf2, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                String taskText4 = data.getTaskText();
                if (taskText4 != null) {
                    str = taskText4;
                }
                text1.setText(str);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemDailyEarnDiamondTaskBinding> holder, @NotNull EarnDiamondDailyBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemDailyEarnDiamondTaskBinding");
        ItemDailyEarnDiamondTaskBinding itemDailyEarnDiamondTaskBinding = (ItemDailyEarnDiamondTaskBinding) dataBinding;
        int hasFinish = item.getHasFinish();
        int hasAward = item.getHasAward();
        TextView textView = itemDailyEarnDiamondTaskBinding.earnTakeButton;
        Intrinsics.checkNotNullExpressionValue(textView, "earnTakeButton");
        changeClickThemes(hasFinish, hasAward, textView);
        ImageView imageView = itemDailyEarnDiamondTaskBinding.image1;
        Intrinsics.checkNotNullExpressionValue(imageView, "image1");
        TextView textView2 = itemDailyEarnDiamondTaskBinding.text1;
        Intrinsics.checkNotNullExpressionValue(textView2, "text1");
        TextView textView3 = itemDailyEarnDiamondTaskBinding.diamondText;
        Intrinsics.checkNotNullExpressionValue(textView3, "diamondText");
        showIconTextDiamond(item, imageView, textView2, textView3);
        itemDailyEarnDiamondTaskBinding.diamondText.setText("+" + item.getDiamond());
    }
}
