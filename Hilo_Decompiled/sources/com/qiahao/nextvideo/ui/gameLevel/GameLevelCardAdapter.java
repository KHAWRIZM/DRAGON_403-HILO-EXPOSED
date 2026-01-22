package com.qiahao.nextvideo.ui.gameLevel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.date.DateUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.utils.GameTypeUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.gameLevel.GameLevelCard;
import com.qiahao.nextvideo.data.model.gameLevel.UserGameLevel;
import com.qiahao.nextvideo.ui.svip.CustomProgressView;
import com.qiahao.nextvideo.ui.svip.TriangleView;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J9\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/gameLevel/GameLevelCardAdapter;", "Lcom/zhpan/bannerview/e;", "Lcom/qiahao/nextvideo/data/model/gameLevel/GameLevelCard;", "<init>", "()V", "Lcom/zhpan/bannerview/f;", "holder", "data", "", "position", "pageSize", "", "bindData", "(Lcom/zhpan/bannerview/f;Lcom/qiahao/nextvideo/data/model/gameLevel/GameLevelCard;II)V", "viewType", "getLayoutId", "(I)I", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameLevelCardAdapter extends com.zhpan.bannerview.e {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindData$lambda$0(ConstraintLayout constraintLayout) {
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.height = (constraintLayout.getWidth() * 32) / 65;
        constraintLayout.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindData$lambda$4(CustomProgressView customProgressView, ConstraintLayout constraintLayout, Ref.DoubleRef doubleRef) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (customProgressView.getWidth() != 0) {
            if (constraintLayout == null || constraintLayout.getWidth() != 0) {
                double width = (customProgressView.getWidth() - UiKtxKt.toPX(10)) * doubleRef.element;
                if (constraintLayout != null) {
                    i = constraintLayout.getWidth();
                } else {
                    i = 0;
                }
                double px = (width - (i / 2)) + UiKtxKt.toPX(5);
                if (constraintLayout != null) {
                    layoutParams = constraintLayout.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
                bVar.setMarginStart((int) px);
                constraintLayout.setLayoutParams(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindData$lambda$5(CustomProgressView customProgressView, ConstraintLayout constraintLayout, Ref.DoubleRef doubleRef) {
        int i;
        if ((customProgressView != null && customProgressView.getWidth() == 0) || constraintLayout.getWidth() == 0) {
            return;
        }
        if (customProgressView != null) {
            i = customProgressView.getWidth();
        } else {
            i = 0;
        }
        double px = (((i - UiKtxKt.toPX(10)) * doubleRef.element) - (constraintLayout.getWidth() / 2)) + UiKtxKt.toPX(5);
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        bVar.setMarginStart((int) px);
        constraintLayout.setLayoutParams(bVar);
    }

    @Override // com.zhpan.bannerview.e
    public int getLayoutId(int viewType) {
        return R.layout.item_game_level_card;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zhpan.bannerview.e
    public void bindData(@Nullable com.zhpan.bannerview.f holder, @Nullable GameLevelCard data, int position, int pageSize) {
        final Ref.DoubleRef doubleRef;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        Group group;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        Long nextLevelPoints;
        Long leftPoints;
        Long expireAtUnix;
        Long points;
        Long levelPoints;
        Long levelPoints2;
        String str;
        String medalUrl;
        String str2;
        UserGameLevel userLevel;
        Ref.DoubleRef doubleRef2;
        long j;
        Long nextLevelPoints2;
        Long points2;
        ImageView imageView2 = holder != null ? (ImageView) holder.a(2131362100) : null;
        ImageView imageView3 = holder != null ? (ImageView) holder.a(R.id.medalImg) : null;
        TextView textView8 = holder != null ? (TextView) holder.a(2131364012) : null;
        TextView textView9 = holder != null ? (TextView) holder.a(2131365026) : null;
        TextView textView10 = holder != null ? (TextView) holder.a(R.id.date) : null;
        TextView textView11 = holder != null ? (TextView) holder.a(2131364936) : null;
        TextView textView12 = holder != null ? (TextView) holder.a(R.id.number) : null;
        TextView textView13 = holder != null ? (TextView) holder.a(R.id.defaultText) : null;
        Group group2 = holder != null ? (Group) holder.a(2131363072) : null;
        final CustomProgressView customProgressView = holder != null ? (CustomProgressView) holder.a(2131364343) : null;
        final TriangleView triangleView = holder != null ? (TriangleView) holder.a(2131365349) : null;
        final ConstraintLayout a = holder != null ? holder.a(2131362433) : null;
        if (a != null) {
            a.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.gameLevel.j
                @Override // java.lang.Runnable
                public final void run() {
                    GameLevelCardAdapter.bindData$lambda$0(a);
                }
            });
        }
        Ref.DoubleRef doubleRef3 = new Ref.DoubleRef();
        long j2 = 0;
        if ((data != null ? data.getUserLevel() : null) != null) {
            UserGameLevel userLevel2 = data.getUserLevel();
            if (userLevel2 == null || (points2 = userLevel2.getPoints()) == null) {
                doubleRef2 = doubleRef3;
                j = 0;
            } else {
                doubleRef2 = doubleRef3;
                j = points2.longValue();
            }
            double d = j;
            UserGameLevel userLevel3 = data.getUserLevel();
            imageView = imageView2;
            double longValue = d / ((userLevel3 == null || (nextLevelPoints2 = userLevel3.getNextLevelPoints()) == null) ? 1L : nextLevelPoints2.longValue());
            doubleRef = doubleRef2;
            doubleRef.element = longValue;
            textView = textView8;
            if (Double.isNaN(longValue) || doubleRef.element > 1.0d) {
                doubleRef.element = 1.0d;
            }
        } else {
            doubleRef = doubleRef3;
            imageView = imageView2;
            textView = textView8;
        }
        if (customProgressView != null) {
            CustomProgressView.Configs configs = new CustomProgressView.Configs();
            GameTypeUtils gameTypeUtils = GameTypeUtils.INSTANCE;
            configs.setBackgroundStartColor(gameTypeUtils.getProgressBgColor(data != null ? data.getLevel() : null));
            configs.setBackgroundEndColor(gameTypeUtils.getProgressBgColor(data != null ? data.getLevel() : null));
            configs.setStartColor(gameTypeUtils.getProgressStartColor(data != null ? data.getLevel() : null));
            configs.setEndColor(androidx.core.content.a.getColor(customProgressView.getContext(), gameTypeUtils.getProgressEndColor(data != null ? data.getLevel() : null)));
            configs.setPointColor(androidx.core.content.a.getColor(customProgressView.getContext(), 2131101214));
            customProgressView.setConfigs(configs);
            customProgressView.setCurrentProgress((float) (doubleRef.element * 100));
        }
        GameTypeUtils gameTypeUtils2 = GameTypeUtils.INSTANCE;
        final int progressTextBgColor = gameTypeUtils2.getProgressTextBgColor(data != null ? data.getLevel() : null);
        if (triangleView != null) {
            triangleView.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.gameLevel.k
                @Override // java.lang.Runnable
                public final void run() {
                    TriangleView.this.b(progressTextBgColor, 1, false);
                }
            });
        }
        if (textView9 != null) {
            ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
            Context context = textView9.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView9.setBackground(ShapeUtil.createShape$default(shapeUtil, context, progressTextBgColor, progressTextBgColor, 6, (GradientDrawable.Orientation) null, false, 16, (Object) null));
            textView9.setTextColor(androidx.core.content.a.getColor(textView9.getContext(), gameTypeUtils2.getTipTextColor((data == null || (userLevel = data.getUserLevel()) == null) ? null : userLevel.getLevel())));
        }
        final ConstraintLayout a2 = holder != null ? holder.a(R.id.tipLayout) : null;
        if (customProgressView != null) {
            customProgressView.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.gameLevel.l
                @Override // java.lang.Runnable
                public final void run() {
                    GameLevelCardAdapter.bindData$lambda$4(CustomProgressView.this, a2, doubleRef);
                }
            });
        }
        if (a2 != null) {
            a2.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.gameLevel.m
                @Override // java.lang.Runnable
                public final void run() {
                    GameLevelCardAdapter.bindData$lambda$5(CustomProgressView.this, a2, doubleRef);
                }
            });
        }
        int progressTextColor = gameTypeUtils2.getProgressTextColor(data != null ? data.getLevel() : null);
        if (textView13 != null) {
            textView13.setTextColor(androidx.core.content.a.getColor(textView13.getContext(), progressTextColor));
        }
        if (textView12 != null) {
            textView12.setTextColor(androidx.core.content.a.getColor(textView12.getContext(), progressTextColor));
        }
        if (textView10 != null) {
            textView10.setTextColor(androidx.core.content.a.getColor(textView10.getContext(), progressTextColor));
        }
        if (textView11 != null) {
            textView11.setTextColor(androidx.core.content.a.getColor(textView11.getContext(), progressTextColor));
        }
        String str3 = "";
        if (imageView != null) {
            Context context2 = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            if (data == null || (str2 = data.getCardUrl()) == null) {
                str2 = "";
            }
            ImageKtxKt.toHorizontalMirror(imageView, context2, str2);
        }
        if (imageView3 != null) {
            if (data != null && (medalUrl = data.getMedalUrl()) != null) {
                str3 = medalUrl;
            }
            group = group2;
            textView3 = textView13;
            textView4 = textView12;
            textView5 = textView11;
            textView6 = textView10;
            textView2 = textView9;
            ImageKtxKt.loadImage$default(imageView3, str3, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        } else {
            textView2 = textView9;
            group = group2;
            textView3 = textView13;
            textView4 = textView12;
            textView5 = textView11;
            textView6 = textView10;
        }
        if (textView != null) {
            if (data != null) {
                str = data.getTitle();
                textView7 = textView;
            } else {
                textView7 = textView;
                str = null;
            }
            textView7.setText(str);
        } else {
            textView7 = textView;
        }
        if (textView7 != null) {
            textView7.setTextColor(gameTypeUtils2.getTitleColor(data != null ? data.getLevel() : null));
        }
        if ((data != null ? data.getUserLevel() : null) == null) {
            if (textView3 != null) {
                String format = String.format(ResourcesKtxKt.getStringById(this, 2131952840), Arrays.copyOf(new Object[]{NumberUtilsKt.formatRankNumber$default((data == null || (levelPoints2 = data.getLevelPoints()) == null) ? 0L : levelPoints2.longValue(), 1, false, 4, null)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                SpannableTextBuilder spannableTextBuilder = new SpannableTextBuilder(textView3);
                if (data != null && (levelPoints = data.getLevelPoints()) != null) {
                    j2 = levelPoints.longValue();
                }
                SpannableTextBuilder.changeTextColor$default(spannableTextBuilder, format, NumberUtilsKt.formatRankNumber$default(j2, 1, false, 4, null), Integer.valueOf(gameTypeUtils2.getSubTitleColor(data != null ? data.getLevel() : null)), (Integer) null, 8, (Object) null).apply();
            }
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            if (group != null) {
                group.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView14 = textView4;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        if (group != null) {
            group.setVisibility(0);
        }
        if (textView2 != null) {
            UserGameLevel userLevel4 = data.getUserLevel();
            textView2.setText(NumberUtilsKt.formatRankNumber$default((userLevel4 == null || (points = userLevel4.getPoints()) == null) ? 0L : points.longValue(), 1, false, 4, null));
        }
        TextView textView15 = textView6;
        if (textView15 != null) {
            String stringById = ResourcesKtxKt.getStringById(this, 2131954193);
            DateUtils dateUtils = DateUtils.INSTANCE;
            UserGameLevel userLevel5 = data.getUserLevel();
            String format2 = String.format(stringById, Arrays.copyOf(new Object[]{dateUtils.formatDate("yyyy/MM/dd HH:mm", Long.valueOf(((userLevel5 == null || (expireAtUnix = userLevel5.getExpireAtUnix()) == null) ? 0L : expireAtUnix.longValue()) * 1000))}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            textView15.setText(format2);
        }
        TextView textView16 = textView5;
        if (textView16 != null) {
            String stringById2 = ResourcesKtxKt.getStringById(this, 2131954200);
            UserGameLevel userLevel6 = data.getUserLevel();
            String format3 = String.format(stringById2, Arrays.copyOf(new Object[]{NumberUtilsKt.formatRankNumber$default((userLevel6 == null || (leftPoints = userLevel6.getLeftPoints()) == null) ? 0L : leftPoints.longValue(), 1, false, 4, null)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
            textView16.setText(format3);
        }
        if (textView14 != null) {
            UserGameLevel userLevel7 = data.getUserLevel();
            if (userLevel7 != null && (nextLevelPoints = userLevel7.getNextLevelPoints()) != null) {
                j2 = nextLevelPoints.longValue();
            }
            textView14.setText(NumberUtilsKt.formatRankNumber$default(j2, 1, false, 4, null));
        }
    }
}
