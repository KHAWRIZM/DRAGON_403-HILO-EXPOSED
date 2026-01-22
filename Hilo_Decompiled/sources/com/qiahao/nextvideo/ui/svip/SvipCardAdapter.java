package com.qiahao.nextvideo.ui.svip;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.date.DateUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.model.svip.SvipCard;
import com.qiahao.base_common.model.svip.UserSvip;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.svip.CustomProgressView;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J9\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/ui/svip/SvipCardAdapter;", "Lcom/zhpan/bannerview/e;", "Lcom/qiahao/base_common/model/svip/SvipCard;", "<init>", "()V", "Lcom/zhpan/bannerview/f;", "holder", "data", "", "position", "pageSize", "", "bindData", "(Lcom/zhpan/bannerview/f;Lcom/qiahao/base_common/model/svip/SvipCard;II)V", "onViewAttachedToWindow", "(Lcom/zhpan/bannerview/f;)V", "onViewDetachedFromWindow", "viewType", "getLayoutId", "(I)I", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSvipCardAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SvipCardAdapter.kt\ncom/qiahao/nextvideo/ui/svip/SvipCardAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,206:1\n1#2:207\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SvipCardAdapter extends com.zhpan.bannerview.e {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindData$lambda$0(ConstraintLayout constraintLayout) {
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.height = (constraintLayout.getWidth() * 34) / 65;
        constraintLayout.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindData$lambda$3(CustomProgressView customProgressView, TextView textView, Ref.DoubleRef doubleRef, ImageView imageView, Ref.DoubleRef doubleRef2) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = null;
        int i2 = 0;
        if (customProgressView.getWidth() != 0 && (textView == null || textView.getWidth() != 0)) {
            double width = (customProgressView.getWidth() - UiKtxKt.toPX(10)) * doubleRef.element;
            if (textView != null) {
                i = textView.getWidth();
            } else {
                i = 0;
            }
            double px = (width - (i / 2)) + UiKtxKt.toPX(5);
            if (textView != null) {
                layoutParams = textView.getLayoutParams();
            } else {
                layoutParams = null;
            }
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            bVar.setMarginStart((int) px);
            textView.setLayoutParams(bVar);
        }
        if (customProgressView.getWidth() != 0) {
            if (imageView == null || imageView.getWidth() != 0) {
                double width2 = (customProgressView.getWidth() - UiKtxKt.toPX(10)) * doubleRef2.element;
                if (imageView != null) {
                    i2 = imageView.getWidth();
                }
                double px2 = (width2 - (i2 / 2)) + UiKtxKt.toPX(5);
                if (imageView != null) {
                    layoutParams2 = imageView.getLayoutParams();
                }
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
                bVar2.setMarginStart((int) px2);
                imageView.setLayoutParams(bVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindData$lambda$4(CustomProgressView customProgressView, TextView textView, Ref.DoubleRef doubleRef) {
        int i;
        if ((customProgressView != null && customProgressView.getWidth() == 0) || textView.getWidth() == 0) {
            return;
        }
        if (customProgressView != null) {
            i = customProgressView.getWidth();
        } else {
            i = 0;
        }
        double px = (((i - UiKtxKt.toPX(10)) * doubleRef.element) - (textView.getWidth() / 2)) + UiKtxKt.toPX(5);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        bVar.setMarginStart((int) px);
        textView.setLayoutParams(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindData$lambda$5(CustomProgressView customProgressView, ImageView imageView, Ref.DoubleRef doubleRef) {
        int i;
        if ((customProgressView != null && customProgressView.getWidth() == 0) || imageView.getWidth() == 0) {
            return;
        }
        if (customProgressView != null) {
            i = customProgressView.getWidth();
        } else {
            i = 0;
        }
        double px = (((i - UiKtxKt.toPX(10)) * doubleRef.element) - (imageView.getWidth() / 2)) + UiKtxKt.toPX(5);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        bVar.setMarginStart((int) px);
        imageView.setLayoutParams(bVar);
    }

    @Override // com.zhpan.bannerview.e
    public int getLayoutId(int viewType) {
        return R.layout.item_svip_card;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0103, code lost:
    
        if (r2.element > 1.0d) goto L٦٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0141, code lost:
    
        if (r10.element > 1.0d) goto L٨٠;
     */
    @Override // com.zhpan.bannerview.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bindData(@Nullable com.zhpan.bannerview.f holder, @Nullable SvipCard data, int position, int pageSize) {
        final Ref.DoubleRef doubleRef;
        SVGAImageView sVGAImageView;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        Group group;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        Long points;
        Long continuePoints;
        Long expireAtUnix;
        final SVGAImageView sVGAImageView2;
        String effectUrl;
        String str;
        int i;
        Integer level;
        Long levelPoints;
        UserSvip userSvip;
        long j;
        Ref.DoubleRef doubleRef2;
        long j2;
        Long nextLevelPoints;
        Long continuePoints2;
        Long nextLevelPoints2;
        Long points2;
        ImageView imageView2 = holder != null ? (ImageView) holder.a(2131362100) : null;
        TextView textView6 = holder != null ? (TextView) holder.a(R.id.date) : null;
        TextView textView7 = holder != null ? (TextView) holder.a(2131364936) : null;
        TextView textView8 = holder != null ? (TextView) holder.a(R.id.grading) : null;
        TextView textView9 = holder != null ? (TextView) holder.a(R.id.number) : null;
        TextView textView10 = holder != null ? (TextView) holder.a(R.id.defaultText) : null;
        Group group2 = holder != null ? (Group) holder.a(2131363072) : null;
        final CustomProgressView customProgressView = holder != null ? (CustomProgressView) holder.a(2131364343) : null;
        final ConstraintLayout a = holder != null ? holder.a(2131362433) : null;
        final ImageView imageView3 = holder != null ? (ImageView) holder.a(R.id.gradingImage) : null;
        SVGAImageView a2 = holder != null ? holder.a(2131364958) : null;
        if (a != null) {
            a.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.svip.j
                @Override // java.lang.Runnable
                public final void run() {
                    SvipCardAdapter.bindData$lambda$0(a);
                }
            });
        }
        Ref.DoubleRef doubleRef3 = new Ref.DoubleRef();
        final Ref.DoubleRef doubleRef4 = new Ref.DoubleRef();
        if ((data != null ? data.getUserSvip() : null) != null) {
            UserSvip userSvip2 = data.getUserSvip();
            if (userSvip2 == null || (points2 = userSvip2.getPoints()) == null) {
                sVGAImageView = a2;
                j = 0;
            } else {
                sVGAImageView = a2;
                j = points2.longValue();
            }
            double d = j;
            UserSvip userSvip3 = data.getUserSvip();
            long j3 = 1;
            if (userSvip3 == null || (nextLevelPoints2 = userSvip3.getNextLevelPoints()) == null) {
                doubleRef2 = doubleRef3;
                j2 = 1;
            } else {
                doubleRef2 = doubleRef3;
                j2 = nextLevelPoints2.longValue();
            }
            double d2 = d / j2;
            doubleRef = doubleRef2;
            doubleRef.element = d2;
            if (Double.isNaN(d2)) {
                imageView = imageView2;
                textView = textView7;
            } else {
                imageView = imageView2;
                textView = textView7;
            }
            doubleRef.element = 1.0d;
            UserSvip userSvip4 = data.getUserSvip();
            double longValue = (userSvip4 == null || (continuePoints2 = userSvip4.getContinuePoints()) == null) ? 0L : continuePoints2.longValue();
            UserSvip userSvip5 = data.getUserSvip();
            if (userSvip5 != null && (nextLevelPoints = userSvip5.getNextLevelPoints()) != null) {
                j3 = nextLevelPoints.longValue();
            }
            double d3 = longValue / j3;
            doubleRef4.element = d3;
            double d4 = !Double.isNaN(d3) ? 1.0d : 1.0d;
            doubleRef4.element = d4;
        } else {
            doubleRef = doubleRef3;
            sVGAImageView = a2;
            imageView = imageView2;
            textView = textView7;
        }
        if (customProgressView != null) {
            CustomProgressView.Configs configs = new CustomProgressView.Configs();
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            configs.setBackgroundStartColor(svipTypeUtils.getProgressStartBgColor(data != null ? data.getLevel() : null));
            configs.setBackgroundEndColor(svipTypeUtils.getProgressEndBgColor(data != null ? data.getLevel() : null));
            configs.setStartColor(androidx.core.content.a.getColor(customProgressView.getContext(), svipTypeUtils.getProgressStartColor(data != null ? data.getLevel() : null)));
            configs.setEndColor(androidx.core.content.a.getColor(customProgressView.getContext(), svipTypeUtils.getProgressEndColor(data != null ? data.getLevel() : null)));
            configs.setPointColor(androidx.core.content.a.getColor(customProgressView.getContext(), 2131101214));
            customProgressView.setConfigs(configs);
            customProgressView.setCurrentProgress((float) (doubleRef.element * 100));
        }
        if (imageView3 != null) {
            imageView3.setImageDrawable(androidx.core.content.a.getDrawable(imageView3.getContext(), SvipTypeUtils.INSTANCE.getGradingImage(data != null ? data.getLevel() : null)));
        }
        final TextView textView11 = holder != null ? (TextView) holder.a(R.id.tipLayout) : null;
        SvipTypeUtils svipTypeUtils2 = SvipTypeUtils.INSTANCE;
        int tipBg = svipTypeUtils2.getTipBg(data != null ? data.getLevel() : null);
        if (textView11 != null) {
            Context context = textView11.getContext();
            textView11.setBackground(context != null ? androidx.core.content.a.getDrawable(context, tipBg) : null);
        }
        if (textView11 != null) {
            textView11.setTextColor(androidx.core.content.a.getColor(textView11.getContext(), svipTypeUtils2.getTipTextColor((data == null || (userSvip = data.getUserSvip()) == null) ? null : userSvip.getLevel())));
        }
        if (customProgressView != null) {
            final CustomProgressView customProgressView2 = customProgressView;
            final TextView textView12 = textView11;
            final Ref.DoubleRef doubleRef5 = doubleRef;
            final ImageView imageView4 = imageView3;
            customProgressView.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.svip.k
                @Override // java.lang.Runnable
                public final void run() {
                    SvipCardAdapter.bindData$lambda$3(CustomProgressView.this, textView12, doubleRef5, imageView4, doubleRef4);
                }
            });
        }
        if (textView11 != null) {
            textView11.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.svip.l
                @Override // java.lang.Runnable
                public final void run() {
                    SvipCardAdapter.bindData$lambda$4(CustomProgressView.this, textView11, doubleRef);
                }
            });
        }
        if (imageView3 != null) {
            imageView3.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.svip.m
                @Override // java.lang.Runnable
                public final void run() {
                    SvipCardAdapter.bindData$lambda$5(CustomProgressView.this, imageView3, doubleRef4);
                }
            });
        }
        int progressTextColor = svipTypeUtils2.getProgressTextColor(data != null ? data.getLevel() : null);
        if (textView10 != null) {
            textView10.setTextColor(androidx.core.content.a.getColor(textView10.getContext(), progressTextColor));
        }
        if (textView9 != null) {
            textView9.setTextColor(androidx.core.content.a.getColor(textView9.getContext(), progressTextColor));
        }
        if (textView6 != null) {
            textView6.setTextColor(androidx.core.content.a.getColor(textView6.getContext(), progressTextColor));
        }
        if (textView != null) {
            textView2 = textView;
            textView2.setTextColor(androidx.core.content.a.getColor(textView.getContext(), progressTextColor));
        } else {
            textView2 = textView;
        }
        if (textView8 != null) {
            textView8.setTextColor(androidx.core.content.a.getColor(textView8.getContext(), progressTextColor));
        }
        if (imageView != null) {
            group = group2;
            textView4 = textView9;
            textView5 = textView8;
            textView3 = textView10;
            ImageKtxKt.loadImage$default(imageView, data != null ? data.getCardUrl() : null, (Uri) null, (File) null, (Integer) null, (Bitmap) null, ImageView.ScaleType.CENTER_INSIDE, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65502, (Object) null);
        } else {
            group = group2;
            textView3 = textView10;
            textView4 = textView9;
            textView5 = textView8;
        }
        if ((data != null ? data.getUserSvip() : null) == null) {
            if (textView3 != null) {
                String stringById = ResourcesKtxKt.getStringById(this, 2131954204);
                if (data != null && (levelPoints = data.getLevelPoints()) != null) {
                    r26 = levelPoints.longValue();
                }
                i = 0;
                String format = String.format(stringById, Arrays.copyOf(new Object[]{Long.valueOf(r26), Integer.valueOf((data == null || (level = data.getLevel()) == null) ? 0 : level.intValue())}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView3.setText(format);
            } else {
                i = 0;
            }
            if (textView3 != null) {
                textView3.setVisibility(i);
            }
            if (group != null) {
                group.setVisibility(8);
            }
        } else {
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            if (group != null) {
                group.setVisibility(0);
            }
            if (textView11 != null) {
                UserSvip userSvip6 = data.getUserSvip();
                textView11.setText(String.valueOf(userSvip6 != null ? userSvip6.getPoints() : null));
            }
            if (textView6 != null) {
                String stringById2 = ResourcesKtxKt.getStringById(this, 2131954193);
                DateUtils dateUtils = DateUtils.INSTANCE;
                UserSvip userSvip7 = data.getUserSvip();
                String format2 = String.format(stringById2, Arrays.copyOf(new Object[]{dateUtils.formatDate("yyyy/MM/dd HH:mm", Long.valueOf(((userSvip7 == null || (expireAtUnix = userSvip7.getExpireAtUnix()) == null) ? 0L : expireAtUnix.longValue()) * 1000))}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                textView6.setText(format2);
            }
            if (textView2 != null) {
                String stringById3 = ResourcesKtxKt.getStringById(this, 2131954200);
                UserSvip userSvip8 = data.getUserSvip();
                String format3 = String.format(stringById3, Arrays.copyOf(new Object[]{userSvip8 != null ? userSvip8.getLeftPoints() : null}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                textView2.setText(format3);
            }
            UserSvip userSvip9 = data.getUserSvip();
            long longValue2 = (userSvip9 == null || (continuePoints = userSvip9.getContinuePoints()) == null) ? 0L : continuePoints.longValue();
            UserSvip userSvip10 = data.getUserSvip();
            long longValue3 = longValue2 - ((userSvip10 == null || (points = userSvip10.getPoints()) == null) ? 0L : points.longValue());
            r26 = longValue3 >= 0 ? longValue3 : 0L;
            TextView textView13 = textView5;
            if (textView13 != null) {
                String format4 = String.format(ResourcesKtxKt.getStringById(this, 2131952935), Arrays.copyOf(new Object[]{Long.valueOf(r26)}, 1));
                Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
                textView13.setText(format4);
            }
            TextView textView14 = textView4;
            if (textView14 != null) {
                UserSvip userSvip11 = data.getUserSvip();
                textView14.setText(String.valueOf(userSvip11 != null ? userSvip11.getNextLevelPoints() : null));
            }
        }
        String str2 = "";
        if (sVGAImageView != null) {
            if (data == null || (str = data.getEffectUrl()) == null) {
                str = "";
            }
            sVGAImageView2 = sVGAImageView;
            sVGAImageView2.setTag(str);
        } else {
            sVGAImageView2 = sVGAImageView;
        }
        SVGAParser shareParser = SVGAParser.Companion.shareParser();
        if (data != null && (effectUrl = data.getEffectUrl()) != null) {
            str2 = effectUrl;
        }
        shareParser.decodeFromURL(new URL(str2), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.svip.SvipCardAdapter$bindData$7
            public void onComplete(SVGAVideoEntity videoItem) {
                Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                SVGAImageView sVGAImageView3 = sVGAImageView2;
                if (sVGAImageView3 != null) {
                    sVGAImageView3.stopAnimation(true);
                }
                SVGAImageView sVGAImageView4 = sVGAImageView2;
                if (sVGAImageView4 != null) {
                    sVGAImageView4.setImageDrawable(new SVGADrawable(videoItem));
                }
                SVGAImageView sVGAImageView5 = sVGAImageView2;
                if (sVGAImageView5 != null) {
                    sVGAImageView5.startAnimation();
                }
            }

            public void onError() {
            }
        });
    }

    public void onViewAttachedToWindow(@NotNull com.zhpan.bannerview.f holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        final SVGAImageView a = holder.a(2131364958);
        if (a == null) {
            return;
        }
        Object tag = a.getTag();
        String str = tag instanceof String ? (String) tag : null;
        if (str == null || str.length() <= 0 || a.isAnimating()) {
            return;
        }
        SVGAParser.Companion.shareParser().decodeFromURL(new URL(str), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.svip.SvipCardAdapter$onViewAttachedToWindow$1
            public void onComplete(SVGAVideoEntity videoItem) {
                Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                a.stopAnimation(true);
                a.setImageDrawable(new SVGADrawable(videoItem));
                a.startAnimation();
            }

            public void onError() {
            }
        });
    }

    public void onViewDetachedFromWindow(@NotNull com.zhpan.bannerview.f holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        holder.a(2131364958).stopAnimation(true);
    }
}
