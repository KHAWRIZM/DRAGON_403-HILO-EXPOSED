package com.qiahao.base_common.utils;

import android.content.res.Resources;
import android.graphics.Rect;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0007\n\u0002\b%\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR%\u0010\u000e\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R*\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0017\u0010\u001f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001cR\u0017\u0010!\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001cR\u0017\u0010#\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010\u001cR\u0017\u0010%\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001cR\u0017\u0010'\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010\u001cR\u001a\u0010*\u001a\u00020)8\u0006X\u0086D¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020)8\u0006X\u0086D¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b/\u0010-R\u001a\u00100\u001a\u00020)8\u0006X\u0086D¢\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-R\u001a\u00102\u001a\u00020)8\u0006X\u0086D¢\u0006\f\n\u0004\b2\u0010+\u001a\u0004\b3\u0010-R\u001a\u00104\u001a\u00020)8\u0006X\u0086D¢\u0006\f\n\u0004\b4\u0010+\u001a\u0004\b5\u0010-R\u001a\u00106\u001a\u00020)8\u0006X\u0086D¢\u0006\f\n\u0004\b6\u0010+\u001a\u0004\b7\u0010-R\u0017\u00108\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b8\u0010\u001a\u001a\u0004\b9\u0010\u001cR\u0017\u0010:\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b:\u0010\u001a\u001a\u0004\b;\u0010\u001cR\u0017\u0010<\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b<\u0010\u001a\u001a\u0004\b=\u0010\u001cR\u0017\u0010>\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b>\u0010\u001a\u001a\u0004\b?\u0010\u001cR\u0017\u0010@\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b@\u0010\u001a\u001a\u0004\bA\u0010\u001cR\u0017\u0010B\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bB\u0010\u001a\u001a\u0004\bC\u0010\u001cR\u0017\u0010D\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bD\u0010\u001a\u001a\u0004\bE\u0010\u001cR\u001b\u0010I\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010\u001cR\u001b\u0010L\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010G\u001a\u0004\bK\u0010\u001cR\u0014\u0010M\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bM\u0010\u001a¨\u0006N"}, d2 = {"Lcom/qiahao/base_common/utils/Dimens;", "", "<init>", "()V", "", "dp", "dpToPx", "(I)I", "", "safeAreaCalculated", "Z", "Lla/b;", "Landroid/graphics/Rect;", "kotlin.jvm.PlatformType", "safeAreaRelay", "Lla/b;", "getSafeAreaRelay", "()Lla/b;", "rect", "safeArea", "Landroid/graphics/Rect;", "getSafeArea", "()Landroid/graphics/Rect;", "setSafeArea", "(Landroid/graphics/Rect;)V", "marginXSmall", "I", "getMarginXSmall", "()I", "marginSmall", "getMarginSmall", "marginMedium", "getMarginMedium", "marginLarge", "getMarginLarge", "marginXLarge", "getMarginXLarge", "marginXXLarge", "getMarginXXLarge", "marginXXXLarge", "getMarginXXXLarge", "", "fontSizeXXSmall", "F", "getFontSizeXXSmall", "()F", "fontSizeXSmall", "getFontSizeXSmall", "fontSizeSmall", "getFontSizeSmall", "fontSizeMedium", "getFontSizeMedium", "fontSizeLarge", "getFontSizeLarge", "fontSizeXLarge", "getFontSizeXLarge", "purchaseableItemWidth", "getPurchaseableItemWidth", "purchaseableItemHeight", "getPurchaseableItemHeight", "smallAvatarSize", "getSmallAvatarSize", "mediumAvatarSize", "getMediumAvatarSize", "largeAvatarSize", "getLargeAvatarSize", "circleButtonDhefaultItemHeight", "getCircleButtonDhefaultItemHeight", "purchaseableDiamondItemHeight", "getPurchaseableDiamondItemHeight", "screenWidth$delegate", "Lkotlin/Lazy;", "getScreenWidth", "screenWidth", "screenHeight$delegate", "getScreenHeight", "screenHeight", "displayPictureMaxLength", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class Dimens {

    @NotNull
    public static final Dimens INSTANCE;
    private static final int circleButtonDhefaultItemHeight;
    public static final int displayPictureMaxLength = 512;
    private static final float fontSizeLarge;
    private static final float fontSizeMedium;
    private static final float fontSizeSmall;
    private static final float fontSizeXLarge;
    private static final float fontSizeXSmall;
    private static final float fontSizeXXSmall;
    private static final int largeAvatarSize;
    private static final int marginLarge;
    private static final int marginMedium;
    private static final int marginSmall;
    private static final int marginXLarge;
    private static final int marginXSmall;
    private static final int marginXXLarge;
    private static final int marginXXXLarge;
    private static final int mediumAvatarSize;
    private static final int purchaseableDiamondItemHeight;
    private static final int purchaseableItemHeight;
    private static final int purchaseableItemWidth;

    @NotNull
    private static Rect safeArea;
    private static boolean safeAreaCalculated;

    @NotNull
    private static final la.b safeAreaRelay;

    /* renamed from: screenHeight$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy screenHeight;

    /* renamed from: screenWidth$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy screenWidth;
    private static final int smallAvatarSize;

    static {
        Dimens dimens = new Dimens();
        INSTANCE = dimens;
        la.b e10 = la.b.e();
        Intrinsics.checkNotNullExpressionValue(e10, "create(...)");
        safeAreaRelay = e10;
        safeArea = new Rect();
        marginXSmall = dimens.dpToPx(2);
        marginSmall = dimens.dpToPx(5);
        marginMedium = dimens.dpToPx(8);
        marginLarge = dimens.dpToPx(12);
        marginXLarge = dimens.dpToPx(24);
        marginXXLarge = dimens.dpToPx(36);
        marginXXXLarge = dimens.dpToPx(72);
        fontSizeXXSmall = 8.0f;
        fontSizeXSmall = 10.0f;
        fontSizeSmall = 12.0f;
        fontSizeMedium = 14.0f;
        fontSizeLarge = 16.0f;
        fontSizeXLarge = 24.0f;
        purchaseableItemWidth = dimens.dpToPx(100);
        purchaseableItemHeight = dimens.dpToPx(100);
        smallAvatarSize = dimens.dpToPx(32);
        mediumAvatarSize = dimens.dpToPx(48);
        largeAvatarSize = dimens.dpToPx(64);
        circleButtonDhefaultItemHeight = dimens.dpToPx(50);
        purchaseableDiamondItemHeight = dimens.dpToPx(120);
        screenWidth = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.utils.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int screenWidth_delegate$lambda$0;
                screenWidth_delegate$lambda$0 = Dimens.screenWidth_delegate$lambda$0();
                return Integer.valueOf(screenWidth_delegate$lambda$0);
            }
        });
        screenHeight = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.utils.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int screenHeight_delegate$lambda$1;
                screenHeight_delegate$lambda$1 = Dimens.screenHeight_delegate$lambda$1();
                return Integer.valueOf(screenHeight_delegate$lambda$1);
            }
        });
    }

    private Dimens() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int screenHeight_delegate$lambda$1() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int screenWidth_delegate$lambda$0() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public final int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public final int getCircleButtonDhefaultItemHeight() {
        return circleButtonDhefaultItemHeight;
    }

    public final float getFontSizeLarge() {
        return fontSizeLarge;
    }

    public final float getFontSizeMedium() {
        return fontSizeMedium;
    }

    public final float getFontSizeSmall() {
        return fontSizeSmall;
    }

    public final float getFontSizeXLarge() {
        return fontSizeXLarge;
    }

    public final float getFontSizeXSmall() {
        return fontSizeXSmall;
    }

    public final float getFontSizeXXSmall() {
        return fontSizeXXSmall;
    }

    public final int getLargeAvatarSize() {
        return largeAvatarSize;
    }

    public final int getMarginLarge() {
        return marginLarge;
    }

    public final int getMarginMedium() {
        return marginMedium;
    }

    public final int getMarginSmall() {
        return marginSmall;
    }

    public final int getMarginXLarge() {
        return marginXLarge;
    }

    public final int getMarginXSmall() {
        return marginXSmall;
    }

    public final int getMarginXXLarge() {
        return marginXXLarge;
    }

    public final int getMarginXXXLarge() {
        return marginXXXLarge;
    }

    public final int getMediumAvatarSize() {
        return mediumAvatarSize;
    }

    public final int getPurchaseableDiamondItemHeight() {
        return purchaseableDiamondItemHeight;
    }

    public final int getPurchaseableItemHeight() {
        return purchaseableItemHeight;
    }

    public final int getPurchaseableItemWidth() {
        return purchaseableItemWidth;
    }

    @NotNull
    public final Rect getSafeArea() {
        return safeArea;
    }

    @NotNull
    public final la.b getSafeAreaRelay() {
        return safeAreaRelay;
    }

    public final int getScreenHeight() {
        return ((Number) screenHeight.getValue()).intValue();
    }

    public final int getScreenWidth() {
        return ((Number) screenWidth.getValue()).intValue();
    }

    public final int getSmallAvatarSize() {
        return smallAvatarSize;
    }

    public final void setSafeArea(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        safeArea = rect;
        if (!safeAreaCalculated) {
            safeAreaRelay.accept(rect);
            safeAreaCalculated = true;
        }
    }
}
