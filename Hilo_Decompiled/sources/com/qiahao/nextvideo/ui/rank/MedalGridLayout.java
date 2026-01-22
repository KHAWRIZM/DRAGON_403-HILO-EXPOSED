package com.qiahao.nextvideo.ui.rank;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.qiahao.base_common.model.common.MedalInfo;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ,\u0010\u0013\u001a\u00020\u00142\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\nJ\b\u0010\u0017\u001a\u00020\u0014H\u0003J\b\u0010\u0018\u001a\u00020\u0014H\u0002R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/MedalGridLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mMedalInfoList", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/common/MedalInfo;", "Lkotlin/collections/ArrayList;", "getMMedalInfoList", "()Ljava/util/ArrayList;", "mContext", "setDataAndLayoutView", "", "medalInfoList", "maxSize", "init15View", "initOnlineView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MedalGridLayout extends LinearLayout {

    @NotNull
    private Context mContext;

    @NotNull
    private final ArrayList<MedalInfo> mMedalInfoList;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MedalGridLayout(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @SuppressLint({"SuspiciousIndentation"})
    private final void init15View() {
        int i;
        int i2;
        int i3 = 5;
        if (this.mMedalInfoList.size() > 0) {
            int i4 = 0;
            setVisibility(0);
            if (this.mMedalInfoList.size() / 5 > 0) {
                i = this.mMedalInfoList.size() / 5;
            } else {
                i = 1;
            }
            int i5 = 0;
            while (true) {
                int i6 = 4;
                if (i5 >= i) {
                    break;
                }
                LinearLayout linearLayout = new LinearLayout(this.mContext);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                linearLayout.setOrientation(i4);
                linearLayout.setGravity(17);
                if (i5 == 0) {
                    if (this.mMedalInfoList.size() > i3) {
                        i2 = 4;
                    } else {
                        i2 = this.mMedalInfoList.size() - 1;
                    }
                } else {
                    i2 = (i5 * 5) + 4;
                }
                int i7 = i5 * 5;
                if (i7 <= i2) {
                    while (true) {
                        ImageView imageView = new ImageView(this.mContext);
                        Dimens dimens = Dimens.INSTANCE;
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens.dpToPx(18), dimens.dpToPx(15));
                        layoutParams.setMarginEnd(dimens.dpToPx(i6));
                        imageView.setLayoutParams(layoutParams);
                        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
                        String picUrl = this.mMedalInfoList.get(i7).getPicUrl();
                        ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
                        lfit.setWidth(dimens.dpToPx(18));
                        lfit.setHeight(dimens.dpToPx(15));
                        Unit unit = Unit.INSTANCE;
                        ImageUIModel displayImage = companion.displayImage(picUrl, lfit);
                        displayImage.setPlaceholder(null);
                        ViewUtilitiesKt.bind(imageView, displayImage);
                        linearLayout.addView(imageView);
                        if (i7 != i2) {
                            i7++;
                            i6 = 4;
                        }
                    }
                }
                addView(linearLayout);
                i5++;
                i3 = 5;
                i4 = 0;
            }
            if (i <= 1 && this.mMedalInfoList.size() <= 5) {
                return;
            }
            int i8 = i * 5;
            if (this.mMedalInfoList.size() - i8 > 0) {
                LinearLayout linearLayout2 = new LinearLayout(this.mContext);
                linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                linearLayout2.setOrientation(0);
                int size = this.mMedalInfoList.size();
                while (i8 < size) {
                    ImageView imageView2 = new ImageView(this.mContext);
                    Dimens dimens2 = Dimens.INSTANCE;
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimens2.dpToPx(18), dimens2.dpToPx(15));
                    layoutParams2.setMarginEnd(dimens2.dpToPx(4));
                    layoutParams2.topMargin = dimens2.dpToPx(2);
                    imageView2.setLayoutParams(layoutParams2);
                    ImageUIModel.Companion companion2 = ImageUIModel.INSTANCE;
                    String picUrl2 = this.mMedalInfoList.get(i8).getPicUrl();
                    ResizeMode.LFIT lfit2 = ResizeMode.LFIT.INSTANCE;
                    lfit2.setWidth(dimens2.dpToPx(18));
                    lfit2.setHeight(dimens2.dpToPx(15));
                    Unit unit2 = Unit.INSTANCE;
                    ImageUIModel displayImage2 = companion2.displayImage(picUrl2, lfit2);
                    displayImage2.setPlaceholder(null);
                    ViewUtilitiesKt.bind(imageView2, displayImage2);
                    linearLayout2.addView(imageView2);
                    i8++;
                }
                addView(linearLayout2);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    private final void initOnlineView() {
        if (this.mMedalInfoList.size() > 0) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout.setOrientation(0);
            int size = this.mMedalInfoList.size();
            for (int i = 0; i < size; i++) {
                ImageView imageView = new ImageView(this.mContext);
                Dimens dimens = Dimens.INSTANCE;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens.dpToPx(18), dimens.dpToPx(15));
                layoutParams.setMarginEnd(dimens.dpToPx(4));
                imageView.setLayoutParams(layoutParams);
                ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
                String picUrl = this.mMedalInfoList.get(i).getPicUrl();
                ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
                lfit.setWidth(dimens.dpToPx(18));
                lfit.setHeight(dimens.dpToPx(15));
                Unit unit = Unit.INSTANCE;
                ImageUIModel displayImage = companion.displayImage(picUrl, lfit);
                displayImage.setPlaceholder(null);
                ViewUtilitiesKt.bind(imageView, displayImage);
                linearLayout.addView(imageView);
            }
            addView(linearLayout);
        }
    }

    public static /* synthetic */ void setDataAndLayoutView$default(MedalGridLayout medalGridLayout, ArrayList arrayList, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 15;
        }
        medalGridLayout.setDataAndLayoutView(arrayList, i);
    }

    @NotNull
    public final ArrayList<MedalInfo> getMMedalInfoList() {
        return this.mMedalInfoList;
    }

    public final void setDataAndLayoutView(@Nullable ArrayList<MedalInfo> medalInfoList, int maxSize) {
        removeAllViews();
        if (medalInfoList == null) {
            setVisibility(8);
            return;
        }
        this.mMedalInfoList.clear();
        if (medalInfoList.size() > maxSize - 1) {
            this.mMedalInfoList.addAll(medalInfoList.subList(0, maxSize));
        } else {
            this.mMedalInfoList.addAll(medalInfoList);
        }
        if (maxSize == 15) {
            init15View();
        } else {
            initOnlineView();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MedalGridLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MedalGridLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMedalInfoList = new ArrayList<>();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mContext = context2;
    }
}
