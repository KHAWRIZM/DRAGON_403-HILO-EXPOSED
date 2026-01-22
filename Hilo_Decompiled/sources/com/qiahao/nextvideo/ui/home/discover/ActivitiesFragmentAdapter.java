package com.qiahao.nextvideo.ui.home.discover;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemFragmentActivityBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J,\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0014¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/ActivitiesFragmentAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/base_common/model/ActivityDetailData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemFragmentActivityBinding;", "<init>", "()V", "convert", "", "holder", "item", "payloads", "", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nActivitiesFragmentAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivitiesFragmentAdapter.kt\ncom/qiahao/nextvideo/ui/home/discover/ActivitiesFragmentAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,227:1\n1869#2,2:228\n*S KotlinDebug\n*F\n+ 1 ActivitiesFragmentAdapter.kt\ncom/qiahao/nextvideo/ui/home/discover/ActivitiesFragmentAdapter\n*L\n128#1:228,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ActivitiesFragmentAdapter extends BaseQuickAdapter<ActivityDetailData, BaseDataBindingHolder<ItemFragmentActivityBinding>> {
    public ActivitiesFragmentAdapter() {
        super(R.layout.item_fragment_activity, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj, List list) {
        convert((BaseDataBindingHolder<ItemFragmentActivityBinding>) baseViewHolder, (ActivityDetailData) obj, (List<? extends Object>) list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemFragmentActivityBinding> holder, @NotNull ActivityDetailData item) {
        TextView textView;
        TextView textView2;
        ImageView imageView;
        LinearLayout linearLayout;
        TextView textView3;
        TextView textView4;
        ImageView imageView2;
        LinearLayout linearLayout2;
        AppCompatTextView appCompatTextView;
        ImageView imageView3;
        ImageView imageView4;
        TextView textView5;
        TextView textView6;
        ImageView imageView5;
        LinearLayout linearLayout3;
        AppCompatTextView appCompatTextView2;
        ImageView imageView6;
        TextView textView7;
        TextView textView8;
        ImageView imageView7;
        LinearLayout linearLayout4;
        AppCompatTextView appCompatTextView3;
        ImageView imageView8;
        ImageView imageView9;
        TextView textView9;
        AppCompatTextView appCompatTextView4;
        AppCompatTextView appCompatTextView5;
        ShineTextView shineTextView;
        TextView textView10;
        QMUIRadiusImageView2 qMUIRadiusImageView2;
        AppCompatTextView appCompatTextView6;
        ImageView imageView10;
        QMUIRadiusImageView2 qMUIRadiusImageView22;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemFragmentActivityBinding itemFragmentActivityBinding = (ItemFragmentActivityBinding) holder.getDataBinding();
        if (itemFragmentActivityBinding != null && (qMUIRadiusImageView22 = itemFragmentActivityBinding.headerImage) != null) {
            ImageKtxKt.loadImage$default(qMUIRadiusImageView22, ImageSizeKt.image100(item.getGroupIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131232432, 2131232432, (c5.g) null, 40958, (Object) null);
        }
        ItemFragmentActivityBinding itemFragmentActivityBinding2 = (ItemFragmentActivityBinding) holder.getDataBinding();
        if (itemFragmentActivityBinding2 != null && (imageView10 = itemFragmentActivityBinding2.stateImage) != null) {
            imageView10.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), item.getActivityTypeIcon()));
        }
        ItemFragmentActivityBinding itemFragmentActivityBinding3 = (ItemFragmentActivityBinding) holder.getDataBinding();
        if (itemFragmentActivityBinding3 != null && (appCompatTextView6 = itemFragmentActivityBinding3.stateContent) != null) {
            appCompatTextView6.setText(item.getActivityTypeText());
        }
        ItemFragmentActivityBinding itemFragmentActivityBinding4 = (ItemFragmentActivityBinding) holder.getDataBinding();
        if (itemFragmentActivityBinding4 != null && (qMUIRadiusImageView2 = itemFragmentActivityBinding4.centerImage) != null) {
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, item.getBanner(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131232432, 2131232432, (c5.g) null, 40958, (Object) null);
        }
        ItemFragmentActivityBinding itemFragmentActivityBinding5 = (ItemFragmentActivityBinding) holder.getDataBinding();
        if (itemFragmentActivityBinding5 != null && (textView10 = itemFragmentActivityBinding5.nickName) != null) {
            textView10.setText(item.getGroupName());
        }
        ItemFragmentActivityBinding itemFragmentActivityBinding6 = (ItemFragmentActivityBinding) holder.getDataBinding();
        if (itemFragmentActivityBinding6 != null && (shineTextView = itemFragmentActivityBinding6.idText) != null) {
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{item.getGroupCode()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            shineTextView.setText(format);
        }
        ItemFragmentActivityBinding itemFragmentActivityBinding7 = (ItemFragmentActivityBinding) holder.getDataBinding();
        if (itemFragmentActivityBinding7 != null && (appCompatTextView5 = itemFragmentActivityBinding7.title) != null) {
            appCompatTextView5.setText(item.getTheme());
        }
        ItemFragmentActivityBinding itemFragmentActivityBinding8 = (ItemFragmentActivityBinding) holder.getDataBinding();
        if (itemFragmentActivityBinding8 != null && (appCompatTextView4 = itemFragmentActivityBinding8.timeContent) != null) {
            HiloUtils hiloUtils = HiloUtils.INSTANCE;
            Long startAt = item.getStartAt();
            long longValue = startAt != null ? startAt.longValue() : 0L;
            Long endAt = item.getEndAt();
            appCompatTextView4.setText(hiloUtils.formatActivityTime(longValue, endAt != null ? endAt.longValue() : 0L));
        }
        ItemFragmentActivityBinding itemFragmentActivityBinding9 = (ItemFragmentActivityBinding) holder.getDataBinding();
        if (itemFragmentActivityBinding9 != null && (textView9 = itemFragmentActivityBinding9.number) != null) {
            textView9.setText(String.valueOf(item.getGroupHot()));
        }
        ItemFragmentActivityBinding itemFragmentActivityBinding10 = (ItemFragmentActivityBinding) holder.getDataBinding();
        if (itemFragmentActivityBinding10 != null && (imageView9 = itemFragmentActivityBinding10.centerBg) != null) {
            imageView9.setVisibility(8);
        }
        HiloUtils hiloUtils2 = HiloUtils.INSTANCE;
        Long startAt2 = item.getStartAt();
        long longValue2 = startAt2 != null ? startAt2.longValue() : 0L;
        Long endAt2 = item.getEndAt();
        int checkActivityStart = hiloUtils2.checkActivityStart(longValue2, endAt2 != null ? endAt2.longValue() : 0L);
        if (checkActivityStart == 0) {
            ItemFragmentActivityBinding itemFragmentActivityBinding11 = (ItemFragmentActivityBinding) holder.getDataBinding();
            if (itemFragmentActivityBinding11 != null && (imageView3 = itemFragmentActivityBinding11.timeImage) != null) {
                imageView3.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.discover_time));
            }
            ItemFragmentActivityBinding itemFragmentActivityBinding12 = (ItemFragmentActivityBinding) holder.getDataBinding();
            if (itemFragmentActivityBinding12 != null && (appCompatTextView = itemFragmentActivityBinding12.timeContent) != null) {
                appCompatTextView.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
            }
            if (Intrinsics.areEqual(item.isSubscribe(), Boolean.FALSE)) {
                ItemFragmentActivityBinding itemFragmentActivityBinding13 = (ItemFragmentActivityBinding) holder.getDataBinding();
                if (itemFragmentActivityBinding13 != null && (linearLayout2 = itemFragmentActivityBinding13.interested) != null) {
                    linearLayout2.setBackground(androidx.core.content.a.getDrawable(getContext(), 2131233375));
                }
                ItemFragmentActivityBinding itemFragmentActivityBinding14 = (ItemFragmentActivityBinding) holder.getDataBinding();
                if (itemFragmentActivityBinding14 != null && (imageView2 = itemFragmentActivityBinding14.interestedImage) != null) {
                    imageView2.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), 2131230851));
                }
                ItemFragmentActivityBinding itemFragmentActivityBinding15 = (ItemFragmentActivityBinding) holder.getDataBinding();
                if (itemFragmentActivityBinding15 != null && (textView4 = itemFragmentActivityBinding15.interestedText) != null) {
                    textView4.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
                }
                ItemFragmentActivityBinding itemFragmentActivityBinding16 = (ItemFragmentActivityBinding) holder.getDataBinding();
                if (itemFragmentActivityBinding16 == null || (textView3 = itemFragmentActivityBinding16.interestedText) == null) {
                    return;
                }
                String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131951964), Arrays.copyOf(new Object[]{Integer.valueOf(item.getPersonNum())}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                textView3.setText(format2);
                return;
            }
            ItemFragmentActivityBinding itemFragmentActivityBinding17 = (ItemFragmentActivityBinding) holder.getDataBinding();
            if (itemFragmentActivityBinding17 != null && (linearLayout = itemFragmentActivityBinding17.interested) != null) {
                linearLayout.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.shape_gradient_f0f0f0_e6e6e6_24dp));
            }
            ItemFragmentActivityBinding itemFragmentActivityBinding18 = (ItemFragmentActivityBinding) holder.getDataBinding();
            if (itemFragmentActivityBinding18 != null && (imageView = itemFragmentActivityBinding18.interestedImage) != null) {
                imageView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.discover_icon_subscription));
            }
            ItemFragmentActivityBinding itemFragmentActivityBinding19 = (ItemFragmentActivityBinding) holder.getDataBinding();
            if (itemFragmentActivityBinding19 != null && (textView2 = itemFragmentActivityBinding19.interestedText) != null) {
                textView2.setTextColor(androidx.core.content.a.getColor(getContext(), 2131099900));
            }
            ItemFragmentActivityBinding itemFragmentActivityBinding20 = (ItemFragmentActivityBinding) holder.getDataBinding();
            if (itemFragmentActivityBinding20 == null || (textView = itemFragmentActivityBinding20.interestedText) == null) {
                return;
            }
            String format3 = String.format(ResourcesKtxKt.getStringById(this, 2131951963), Arrays.copyOf(new Object[]{Integer.valueOf(item.getPersonNum())}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
            textView.setText(format3);
            return;
        }
        if (checkActivityStart != 1) {
            ItemFragmentActivityBinding itemFragmentActivityBinding21 = (ItemFragmentActivityBinding) holder.getDataBinding();
            if (itemFragmentActivityBinding21 != null && (imageView8 = itemFragmentActivityBinding21.timeImage) != null) {
                imageView8.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.discover_time));
            }
            ItemFragmentActivityBinding itemFragmentActivityBinding22 = (ItemFragmentActivityBinding) holder.getDataBinding();
            if (itemFragmentActivityBinding22 != null && (appCompatTextView3 = itemFragmentActivityBinding22.timeContent) != null) {
                appCompatTextView3.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
            }
            ItemFragmentActivityBinding itemFragmentActivityBinding23 = (ItemFragmentActivityBinding) holder.getDataBinding();
            if (itemFragmentActivityBinding23 != null && (linearLayout4 = itemFragmentActivityBinding23.interested) != null) {
                linearLayout4.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.shape_gradient_f0f0f0_e6e6e6_24dp));
            }
            ItemFragmentActivityBinding itemFragmentActivityBinding24 = (ItemFragmentActivityBinding) holder.getDataBinding();
            if (itemFragmentActivityBinding24 != null && (imageView7 = itemFragmentActivityBinding24.interestedImage) != null) {
                imageView7.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.discover_icon_subscription));
            }
            ItemFragmentActivityBinding itemFragmentActivityBinding25 = (ItemFragmentActivityBinding) holder.getDataBinding();
            if (itemFragmentActivityBinding25 != null && (textView8 = itemFragmentActivityBinding25.interestedText) != null) {
                textView8.setTextColor(androidx.core.content.a.getColor(getContext(), 2131099900));
            }
            ItemFragmentActivityBinding itemFragmentActivityBinding26 = (ItemFragmentActivityBinding) holder.getDataBinding();
            if (itemFragmentActivityBinding26 == null || (textView7 = itemFragmentActivityBinding26.interestedText) == null) {
                return;
            }
            String format4 = String.format(ResourcesKtxKt.getStringById(this, 2131951963), Arrays.copyOf(new Object[]{Integer.valueOf(item.getPersonNum())}, 1));
            Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
            textView7.setText(format4);
            return;
        }
        ItemFragmentActivityBinding itemFragmentActivityBinding27 = (ItemFragmentActivityBinding) holder.getDataBinding();
        if (itemFragmentActivityBinding27 != null && (imageView6 = itemFragmentActivityBinding27.timeImage) != null) {
            imageView6.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), 2131231681));
        }
        ItemFragmentActivityBinding itemFragmentActivityBinding28 = (ItemFragmentActivityBinding) holder.getDataBinding();
        if (itemFragmentActivityBinding28 != null && (appCompatTextView2 = itemFragmentActivityBinding28.timeContent) != null) {
            appCompatTextView2.setTextColor(androidx.core.content.a.getColor(getContext(), 2131100001));
        }
        ItemFragmentActivityBinding itemFragmentActivityBinding29 = (ItemFragmentActivityBinding) holder.getDataBinding();
        if (itemFragmentActivityBinding29 != null && (linearLayout3 = itemFragmentActivityBinding29.interested) != null) {
            linearLayout3.setBackground(androidx.core.content.a.getDrawable(getContext(), 2131233379));
        }
        ItemFragmentActivityBinding itemFragmentActivityBinding30 = (ItemFragmentActivityBinding) holder.getDataBinding();
        if (itemFragmentActivityBinding30 != null && (imageView5 = itemFragmentActivityBinding30.interestedImage) != null) {
            imageView5.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), 2131231678));
        }
        ItemFragmentActivityBinding itemFragmentActivityBinding31 = (ItemFragmentActivityBinding) holder.getDataBinding();
        if (itemFragmentActivityBinding31 != null && (textView6 = itemFragmentActivityBinding31.interestedText) != null) {
            textView6.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
        }
        ItemFragmentActivityBinding itemFragmentActivityBinding32 = (ItemFragmentActivityBinding) holder.getDataBinding();
        if (itemFragmentActivityBinding32 != null && (textView5 = itemFragmentActivityBinding32.interestedText) != null) {
            String format5 = String.format(ResourcesKtxKt.getStringById(this, 2131951956), Arrays.copyOf(new Object[]{Integer.valueOf(item.getPersonNum())}, 1));
            Intrinsics.checkNotNullExpressionValue(format5, "format(...)");
            textView5.setText(format5);
        }
        ItemFragmentActivityBinding itemFragmentActivityBinding33 = (ItemFragmentActivityBinding) holder.getDataBinding();
        if (itemFragmentActivityBinding33 == null || (imageView4 = itemFragmentActivityBinding33.centerBg) == null) {
            return;
        }
        imageView4.setVisibility(0);
    }

    protected void convert(@NotNull BaseDataBindingHolder<ItemFragmentActivityBinding> holder, @NotNull ActivityDetailData item, @NotNull List<? extends Object> payloads) {
        TextView textView;
        TextView textView2;
        ImageView imageView;
        LinearLayout linearLayout;
        AppCompatTextView appCompatTextView;
        ImageView imageView2;
        ImageView imageView3;
        TextView textView3;
        TextView textView4;
        ImageView imageView4;
        LinearLayout linearLayout2;
        AppCompatTextView appCompatTextView2;
        ImageView imageView5;
        TextView textView5;
        TextView textView6;
        ImageView imageView6;
        LinearLayout linearLayout3;
        TextView textView7;
        TextView textView8;
        ImageView imageView7;
        LinearLayout linearLayout4;
        AppCompatTextView appCompatTextView3;
        ImageView imageView8;
        ImageView imageView9;
        TextView textView9;
        AppCompatTextView appCompatTextView4;
        AppCompatTextView appCompatTextView5;
        ShineTextView shineTextView;
        TextView textView10;
        QMUIRadiusImageView2 qMUIRadiusImageView2;
        AppCompatTextView appCompatTextView6;
        ImageView imageView10;
        QMUIRadiusImageView2 qMUIRadiusImageView22;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Iterator<T> it = payloads.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof Boolean) {
                ItemFragmentActivityBinding itemFragmentActivityBinding = (ItemFragmentActivityBinding) holder.getDataBinding();
                if (itemFragmentActivityBinding != null && (qMUIRadiusImageView22 = itemFragmentActivityBinding.headerImage) != null) {
                    ImageKtxKt.loadImage$default(qMUIRadiusImageView22, item.getGroupIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131232432, 2131232432, (c5.g) null, 40958, (Object) null);
                }
                ItemFragmentActivityBinding itemFragmentActivityBinding2 = (ItemFragmentActivityBinding) holder.getDataBinding();
                if (itemFragmentActivityBinding2 != null && (imageView10 = itemFragmentActivityBinding2.stateImage) != null) {
                    imageView10.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), item.getActivityTypeIcon()));
                }
                ItemFragmentActivityBinding itemFragmentActivityBinding3 = (ItemFragmentActivityBinding) holder.getDataBinding();
                if (itemFragmentActivityBinding3 != null && (appCompatTextView6 = itemFragmentActivityBinding3.stateContent) != null) {
                    appCompatTextView6.setText(item.getActivityTypeText());
                }
                ItemFragmentActivityBinding itemFragmentActivityBinding4 = (ItemFragmentActivityBinding) holder.getDataBinding();
                if (itemFragmentActivityBinding4 != null && (qMUIRadiusImageView2 = itemFragmentActivityBinding4.centerImage) != null) {
                    ImageKtxKt.loadImage$default(qMUIRadiusImageView2, item.getBanner(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131232432, 2131232432, (c5.g) null, 40958, (Object) null);
                }
                ItemFragmentActivityBinding itemFragmentActivityBinding5 = (ItemFragmentActivityBinding) holder.getDataBinding();
                if (itemFragmentActivityBinding5 != null && (textView10 = itemFragmentActivityBinding5.nickName) != null) {
                    textView10.setText(item.getGroupName());
                }
                ItemFragmentActivityBinding itemFragmentActivityBinding6 = (ItemFragmentActivityBinding) holder.getDataBinding();
                if (itemFragmentActivityBinding6 != null && (shineTextView = itemFragmentActivityBinding6.idText) != null) {
                    String format = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{item.getGroupCode()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    shineTextView.setText(format);
                }
                ItemFragmentActivityBinding itemFragmentActivityBinding7 = (ItemFragmentActivityBinding) holder.getDataBinding();
                if (itemFragmentActivityBinding7 != null && (appCompatTextView5 = itemFragmentActivityBinding7.title) != null) {
                    appCompatTextView5.setText(item.getTheme());
                }
                ItemFragmentActivityBinding itemFragmentActivityBinding8 = (ItemFragmentActivityBinding) holder.getDataBinding();
                if (itemFragmentActivityBinding8 != null && (appCompatTextView4 = itemFragmentActivityBinding8.timeContent) != null) {
                    HiloUtils hiloUtils = HiloUtils.INSTANCE;
                    Long startAt = item.getStartAt();
                    long longValue = startAt != null ? startAt.longValue() : 0L;
                    Long endAt = item.getEndAt();
                    appCompatTextView4.setText(hiloUtils.formatActivityTime(longValue, endAt != null ? endAt.longValue() : 0L));
                }
                ItemFragmentActivityBinding itemFragmentActivityBinding9 = (ItemFragmentActivityBinding) holder.getDataBinding();
                if (itemFragmentActivityBinding9 != null && (textView9 = itemFragmentActivityBinding9.number) != null) {
                    textView9.setText(String.valueOf(item.getGroupHot()));
                }
                ItemFragmentActivityBinding itemFragmentActivityBinding10 = (ItemFragmentActivityBinding) holder.getDataBinding();
                if (itemFragmentActivityBinding10 != null && (imageView9 = itemFragmentActivityBinding10.centerBg) != null) {
                    imageView9.setVisibility(8);
                }
                HiloUtils hiloUtils2 = HiloUtils.INSTANCE;
                Long startAt2 = item.getStartAt();
                long longValue2 = startAt2 != null ? startAt2.longValue() : 0L;
                Long endAt2 = item.getEndAt();
                int checkActivityStart = hiloUtils2.checkActivityStart(longValue2, endAt2 != null ? endAt2.longValue() : 0L);
                if (checkActivityStart == 0) {
                    ItemFragmentActivityBinding itemFragmentActivityBinding11 = (ItemFragmentActivityBinding) holder.getDataBinding();
                    if (itemFragmentActivityBinding11 != null && (imageView8 = itemFragmentActivityBinding11.timeImage) != null) {
                        imageView8.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.discover_time));
                    }
                    ItemFragmentActivityBinding itemFragmentActivityBinding12 = (ItemFragmentActivityBinding) holder.getDataBinding();
                    if (itemFragmentActivityBinding12 != null && (appCompatTextView3 = itemFragmentActivityBinding12.timeContent) != null) {
                        appCompatTextView3.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
                    }
                    if (Intrinsics.areEqual(item.isSubscribe(), Boolean.FALSE)) {
                        ItemFragmentActivityBinding itemFragmentActivityBinding13 = (ItemFragmentActivityBinding) holder.getDataBinding();
                        if (itemFragmentActivityBinding13 != null && (linearLayout3 = itemFragmentActivityBinding13.interested) != null) {
                            linearLayout3.setBackground(androidx.core.content.a.getDrawable(getContext(), 2131233375));
                        }
                        ItemFragmentActivityBinding itemFragmentActivityBinding14 = (ItemFragmentActivityBinding) holder.getDataBinding();
                        if (itemFragmentActivityBinding14 != null && (imageView6 = itemFragmentActivityBinding14.interestedImage) != null) {
                            imageView6.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), 2131230851));
                        }
                        ItemFragmentActivityBinding itemFragmentActivityBinding15 = (ItemFragmentActivityBinding) holder.getDataBinding();
                        if (itemFragmentActivityBinding15 != null && (textView6 = itemFragmentActivityBinding15.interestedText) != null) {
                            textView6.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
                        }
                        ItemFragmentActivityBinding itemFragmentActivityBinding16 = (ItemFragmentActivityBinding) holder.getDataBinding();
                        if (itemFragmentActivityBinding16 != null && (textView5 = itemFragmentActivityBinding16.interestedText) != null) {
                            String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131951964), Arrays.copyOf(new Object[]{Integer.valueOf(item.getPersonNum())}, 1));
                            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                            textView5.setText(format2);
                        }
                    } else {
                        ItemFragmentActivityBinding itemFragmentActivityBinding17 = (ItemFragmentActivityBinding) holder.getDataBinding();
                        if (itemFragmentActivityBinding17 != null && (linearLayout4 = itemFragmentActivityBinding17.interested) != null) {
                            linearLayout4.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.shape_gradient_f0f0f0_e6e6e6_24dp));
                        }
                        ItemFragmentActivityBinding itemFragmentActivityBinding18 = (ItemFragmentActivityBinding) holder.getDataBinding();
                        if (itemFragmentActivityBinding18 != null && (imageView7 = itemFragmentActivityBinding18.interestedImage) != null) {
                            imageView7.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.discover_icon_subscription));
                        }
                        ItemFragmentActivityBinding itemFragmentActivityBinding19 = (ItemFragmentActivityBinding) holder.getDataBinding();
                        if (itemFragmentActivityBinding19 != null && (textView8 = itemFragmentActivityBinding19.interestedText) != null) {
                            textView8.setTextColor(androidx.core.content.a.getColor(getContext(), 2131099900));
                        }
                        ItemFragmentActivityBinding itemFragmentActivityBinding20 = (ItemFragmentActivityBinding) holder.getDataBinding();
                        if (itemFragmentActivityBinding20 != null && (textView7 = itemFragmentActivityBinding20.interestedText) != null) {
                            String format3 = String.format(ResourcesKtxKt.getStringById(this, 2131951963), Arrays.copyOf(new Object[]{Integer.valueOf(item.getPersonNum())}, 1));
                            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                            textView7.setText(format3);
                        }
                    }
                } else if (checkActivityStart != 1) {
                    ItemFragmentActivityBinding itemFragmentActivityBinding21 = (ItemFragmentActivityBinding) holder.getDataBinding();
                    if (itemFragmentActivityBinding21 != null && (imageView2 = itemFragmentActivityBinding21.timeImage) != null) {
                        imageView2.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.discover_time));
                    }
                    ItemFragmentActivityBinding itemFragmentActivityBinding22 = (ItemFragmentActivityBinding) holder.getDataBinding();
                    if (itemFragmentActivityBinding22 != null && (appCompatTextView = itemFragmentActivityBinding22.timeContent) != null) {
                        appCompatTextView.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
                    }
                    ItemFragmentActivityBinding itemFragmentActivityBinding23 = (ItemFragmentActivityBinding) holder.getDataBinding();
                    if (itemFragmentActivityBinding23 != null && (linearLayout = itemFragmentActivityBinding23.interested) != null) {
                        linearLayout.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.shape_gradient_f0f0f0_e6e6e6_24dp));
                    }
                    ItemFragmentActivityBinding itemFragmentActivityBinding24 = (ItemFragmentActivityBinding) holder.getDataBinding();
                    if (itemFragmentActivityBinding24 != null && (imageView = itemFragmentActivityBinding24.interestedImage) != null) {
                        imageView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.discover_icon_subscription));
                    }
                    ItemFragmentActivityBinding itemFragmentActivityBinding25 = (ItemFragmentActivityBinding) holder.getDataBinding();
                    if (itemFragmentActivityBinding25 != null && (textView2 = itemFragmentActivityBinding25.interestedText) != null) {
                        textView2.setTextColor(androidx.core.content.a.getColor(getContext(), 2131099900));
                    }
                    ItemFragmentActivityBinding itemFragmentActivityBinding26 = (ItemFragmentActivityBinding) holder.getDataBinding();
                    if (itemFragmentActivityBinding26 != null && (textView = itemFragmentActivityBinding26.interestedText) != null) {
                        String format4 = String.format(ResourcesKtxKt.getStringById(this, 2131951963), Arrays.copyOf(new Object[]{Integer.valueOf(item.getPersonNum())}, 1));
                        Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
                        textView.setText(format4);
                    }
                } else {
                    ItemFragmentActivityBinding itemFragmentActivityBinding27 = (ItemFragmentActivityBinding) holder.getDataBinding();
                    if (itemFragmentActivityBinding27 != null && (imageView5 = itemFragmentActivityBinding27.timeImage) != null) {
                        imageView5.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), 2131231681));
                    }
                    ItemFragmentActivityBinding itemFragmentActivityBinding28 = (ItemFragmentActivityBinding) holder.getDataBinding();
                    if (itemFragmentActivityBinding28 != null && (appCompatTextView2 = itemFragmentActivityBinding28.timeContent) != null) {
                        appCompatTextView2.setTextColor(androidx.core.content.a.getColor(getContext(), 2131100001));
                    }
                    ItemFragmentActivityBinding itemFragmentActivityBinding29 = (ItemFragmentActivityBinding) holder.getDataBinding();
                    if (itemFragmentActivityBinding29 != null && (linearLayout2 = itemFragmentActivityBinding29.interested) != null) {
                        linearLayout2.setBackground(androidx.core.content.a.getDrawable(getContext(), 2131233379));
                    }
                    ItemFragmentActivityBinding itemFragmentActivityBinding30 = (ItemFragmentActivityBinding) holder.getDataBinding();
                    if (itemFragmentActivityBinding30 != null && (imageView4 = itemFragmentActivityBinding30.interestedImage) != null) {
                        imageView4.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), 2131231678));
                    }
                    ItemFragmentActivityBinding itemFragmentActivityBinding31 = (ItemFragmentActivityBinding) holder.getDataBinding();
                    if (itemFragmentActivityBinding31 != null && (textView4 = itemFragmentActivityBinding31.interestedText) != null) {
                        textView4.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
                    }
                    ItemFragmentActivityBinding itemFragmentActivityBinding32 = (ItemFragmentActivityBinding) holder.getDataBinding();
                    if (itemFragmentActivityBinding32 != null && (textView3 = itemFragmentActivityBinding32.interestedText) != null) {
                        String format5 = String.format(ResourcesKtxKt.getStringById(this, 2131951963), Arrays.copyOf(new Object[]{Integer.valueOf(item.getPersonNum())}, 1));
                        Intrinsics.checkNotNullExpressionValue(format5, "format(...)");
                        textView3.setText(format5);
                    }
                    ItemFragmentActivityBinding itemFragmentActivityBinding33 = (ItemFragmentActivityBinding) holder.getDataBinding();
                    if (itemFragmentActivityBinding33 != null && (imageView3 = itemFragmentActivityBinding33.centerBg) != null) {
                        imageView3.setVisibility(0);
                    }
                }
            }
        }
    }
}
