package com.qiahao.nextvideo.utilities;

import android.content.res.ColorStateList;
import android.graphics.Color;
import kotlin.Metadata;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.sud.gip.core.view.round.RoundedDrawable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u0006\u001a\u00020\u0005J\u001c\u0010\u000e\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u00052\b\b\u0001\u0010\u0010\u001a\u00020\u0005H\u0007J$\u0010\u0011\u001a\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u00052\b\b\u0001\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\bH\u0007J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u0005J\u0010\u0010 \u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u0005R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0017¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/utilities/ColorUtility;", "", "<init>", "()V", "getDarkenColor", "", "color", "degree", "", "getColorWithAlpha", "alpha", "getWhiteColor", "isLightColor", "", "getAverageColor", "color1", "color2", "getTransitionColor", "fromColor", "toColor", "step", "primaryColor", "getPrimaryColor", "()I", "backgroundGray", "getBackgroundGray", "ENABLE_ATTR", "CHECKED_ATTR", "PRESSED_ATTR", "generateThumbColorWithTintColor", "Landroid/content/res/ColorStateList;", "tintColor", "generateBackColorWithTintColor", "randomColorInt", "getRandomColorInt", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ColorUtility {
    private static final int CHECKED_ATTR = 16842912;
    private static final int ENABLE_ATTR = 16842910;
    private static final int PRESSED_ATTR = 16842919;

    @NotNull
    public static final ColorUtility INSTANCE = new ColorUtility();
    private static final int primaryColor = Color.parseColor("#9036ff");
    private static final int backgroundGray = Color.parseColor("#FFFFFF");

    private ColorUtility() {
    }

    @Nullable
    public final ColorStateList generateBackColorWithTintColor(int tintColor) {
        int i = tintColor - (-805306368);
        return new ColorStateList(new int[][]{new int[]{-16842910, 16842912}, new int[]{-16842910}, new int[]{16842912, 16842919}, new int[]{-16842912, 16842919}, new int[]{16842912}, new int[]{-16842912}}, new int[]{tintColor - (-520093696), 268435456, i, 536870912, i, 536870912});
    }

    @Nullable
    public final ColorStateList generateThumbColorWithTintColor(int tintColor) {
        int i = tintColor - (-1728053248);
        return new ColorStateList(new int[][]{new int[]{-16842910, 16842912}, new int[]{-16842910}, new int[]{16842919, -16842912}, new int[]{16842919, 16842912}, new int[]{16842912}, new int[]{-16842912}}, new int[]{tintColor - (-1442840576), -4539718, i, i, tintColor | RoundedDrawable.DEFAULT_BORDER_COLOR, -1118482});
    }

    public final int getAverageColor(int color1, int color2) {
        return getTransitionColor(color1, color2, 0.5f);
    }

    public final int getBackgroundGray() {
        return backgroundGray;
    }

    public final int getColorWithAlpha(int color, float alpha) {
        return Color.argb((int) (255 * alpha), Color.red(color), Color.green(color), Color.blue(color));
    }

    public final int getDarkenColor(int color, float degree) {
        float f = 1 - degree;
        return Color.rgb((int) (Color.red(color) * f), (int) (Color.green(color) * f), (int) (Color.blue(color) * f));
    }

    public final int getPrimaryColor() {
        return primaryColor;
    }

    public final int getRandomColorInt() {
        IntRange intRange = new IntRange(0, 256);
        Random.Default r3 = Random.Default;
        return Color.argb(255, RangesKt.random(intRange, r3), RangesKt.random(new IntRange(0, 256), r3), RangesKt.random(new IntRange(0, 256), r3));
    }

    public final int getTransitionColor(int fromColor, int toColor, float step) {
        float f = 1 - step;
        return Color.argb(255, (int) ((Color.red(fromColor) * step) + (Color.red(toColor) * f)), (int) ((Color.green(fromColor) * step) + (Color.green(toColor) * f)), (int) ((Color.blue(fromColor) * step) + (Color.blue(toColor) * f)));
    }

    public final int getWhiteColor(float degree) {
        int i = (int) (255 * degree);
        return Color.rgb(i, i, i);
    }

    public final boolean isLightColor(int color) {
        if (1 - ((((Color.red(color) * 0.299d) + (Color.green(color) * 0.587d)) + (Color.blue(color) * 0.114d)) / 255) < 0.5d) {
            return true;
        }
        return false;
    }
}
