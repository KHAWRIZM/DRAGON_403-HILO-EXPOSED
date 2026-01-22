package com.qiahao.base_common.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.LruCache;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.model.ShapeKey;
import com.qiahao.base_common.model.StrokeKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000*\u0002\u0005\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0011JH\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J>\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u001aJ(\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\rJP\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0011JH\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0011JH\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0003\u0010\"\u001a\u00020\r2\b\b\u0003\u0010#\u001a\u00020\r2\b\b\u0002\u0010$\u001a\u00020\u001a2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J@\u0010%\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010&\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020\u001a2\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0011JN\u0010%\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001b2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010&\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020\u001a2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u0006\u0010(\u001a\u00020)R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006*"}, d2 = {"Lcom/qiahao/base_common/utils/ShapeUtil;", "", "<init>", "()V", "shapeCache", "com/qiahao/base_common/utils/ShapeUtil$shapeCache$1", "Lcom/qiahao/base_common/utils/ShapeUtil$shapeCache$1;", "strokeCache", "com/qiahao/base_common/utils/ShapeUtil$strokeCache$1", "Lcom/qiahao/base_common/utils/ShapeUtil$strokeCache$1;", "getGradientShape", "Landroid/graphics/drawable/Drawable;", "startColor", "", "endColor", "round", "orientation", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "round1", "round2", "round3", "round4", "createShape", "context", "Landroid/content/Context;", "resolver", "", "", "createShapeTop", "color", "getStrokeShape", "strokeColor", "strokeWidthDp", "", "fillColor1", "fillColor2", "isCircle", "createShapeStroke", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "fillColor", "clearCache", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nShapeUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShapeUtil.kt\ncom/qiahao/base_common/utils/ShapeUtil\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,359:1\n439#2:360\n439#2:361\n439#2:362\n439#2:363\n439#2:364\n439#2:365\n439#2:366\n439#2:367\n439#2:369\n439#2:370\n1#3:368\n*S KotlinDebug\n*F\n+ 1 ShapeUtil.kt\ncom/qiahao/base_common/utils/ShapeUtil\n*L\n120#1:360\n121#1:361\n124#1:362\n139#1:363\n141#1:364\n208#1:365\n211#1:366\n334#1:367\n336#1:369\n337#1:370\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ShapeUtil {

    @NotNull
    public static final ShapeUtil INSTANCE = new ShapeUtil();

    @NotNull
    private static final ShapeUtil$shapeCache$1 shapeCache = new LruCache<ShapeKey, GradientDrawable>() { // from class: com.qiahao.base_common.utils.ShapeUtil$shapeCache$1
    };

    @NotNull
    private static final ShapeUtil$strokeCache$1 strokeCache = new LruCache<StrokeKey, GradientDrawable>() { // from class: com.qiahao.base_common.utils.ShapeUtil$strokeCache$1
    };

    private ShapeUtil() {
    }

    public static /* synthetic */ Drawable createShape$default(ShapeUtil shapeUtil, Context context, int i10, int i11, int i12, GradientDrawable.Orientation orientation, boolean z10, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            orientation = GradientDrawable.Orientation.LEFT_RIGHT;
        }
        return shapeUtil.createShape(context, i10, i11, i12, orientation, (i13 & 32) != 0 ? true : z10);
    }

    public static /* synthetic */ Drawable getGradientShape$default(ShapeUtil shapeUtil, int i10, int i11, int i12, GradientDrawable.Orientation orientation, int i13, Object obj) {
        if ((i13 & 8) != 0) {
            orientation = GradientDrawable.Orientation.LEFT_RIGHT;
        }
        return shapeUtil.getGradientShape(i10, i11, i12, orientation);
    }

    public static /* synthetic */ Drawable getStrokeShape$default(ShapeUtil shapeUtil, int i10, float f10, int i11, int i12, int i13, boolean z10, GradientDrawable.Orientation orientation, int i14, Object obj) {
        int i15;
        int i16;
        int i17;
        boolean z11;
        GradientDrawable.Orientation orientation2;
        if ((i14 & 4) != 0) {
            i15 = 0;
        } else {
            i15 = i11;
        }
        if ((i14 & 8) != 0) {
            i16 = 0;
        } else {
            i16 = i12;
        }
        if ((i14 & 16) != 0) {
            i17 = 0;
        } else {
            i17 = i13;
        }
        if ((i14 & 32) != 0) {
            z11 = false;
        } else {
            z11 = z10;
        }
        if ((i14 & 64) != 0) {
            orientation2 = GradientDrawable.Orientation.LEFT_RIGHT;
        } else {
            orientation2 = orientation;
        }
        return shapeUtil.getStrokeShape(i10, f10, i15, i16, i17, z11, orientation2);
    }

    public final void clearCache() {
        shapeCache.evictAll();
        strokeCache.evictAll();
    }

    @NotNull
    public final Drawable createShape(@NotNull Context context, int startColor, int endColor, int round, @NotNull GradientDrawable.Orientation orientation, boolean resolver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (resolver) {
            startColor = androidx.core.content.a.getColor(context, startColor);
        }
        if (resolver) {
            endColor = androidx.core.content.a.getColor(context, endColor);
        }
        return getGradientShape(startColor, endColor, round, orientation);
    }

    @NotNull
    public final Drawable createShapeStroke(int color, int round, float width, boolean isCircle, int fillColor, @NotNull GradientDrawable.Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return getStrokeShape$default(this, color, width, round, fillColor, 0, isCircle, orientation, 16, null);
    }

    @NotNull
    public final Drawable createShapeTop(@NotNull String color, int round) {
        Intrinsics.checkNotNullParameter(color, "color");
        int parseColor = Color.parseColor("#671bcf");
        if (color.length() > 0) {
            parseColor = Color.parseColor(color);
        }
        int i10 = parseColor;
        return getGradientShape$default(this, i10, i10, round, round, 0, 0, null, 64, null);
    }

    @NotNull
    public final Drawable getGradientShape(int startColor, int endColor, int round, @NotNull GradientDrawable.Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return getGradientShape(startColor, endColor, round, round, round, round, orientation);
    }

    @NotNull
    public final Drawable getStrokeShape(int strokeColor, float strokeWidthDp, int round, int fillColor1, int fillColor2, boolean isCircle, @NotNull GradientDrawable.Orientation orientation) {
        Drawable newDrawable;
        Drawable mutate;
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        int px = UiKtxKt.toPX(strokeWidthDp);
        StrokeKey strokeKey = new StrokeKey(strokeColor, px, fillColor1, fillColor2, round, isCircle, orientation);
        ShapeUtil$strokeCache$1 shapeUtil$strokeCache$1 = strokeCache;
        GradientDrawable gradientDrawable = shapeUtil$strokeCache$1.get(strokeKey);
        if (gradientDrawable != null) {
            Drawable.ConstantState constantState = gradientDrawable.getConstantState();
            if (constantState == null || (newDrawable = constantState.newDrawable()) == null || (mutate = newDrawable.mutate()) == null) {
                Drawable mutate2 = gradientDrawable.mutate();
                Intrinsics.checkNotNullExpressionValue(mutate2, "mutate(...)");
                return mutate2;
            }
            return mutate;
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(isCircle ? 1 : 0);
        if (round > 0) {
            gradientDrawable2.setCornerRadius(UiKtxKt.toPX(round));
        }
        if (fillColor1 != 0 && fillColor2 != 0) {
            if (fillColor1 == fillColor2) {
                gradientDrawable2.setColor(fillColor1);
            } else {
                gradientDrawable2.setColors(new int[]{fillColor1, fillColor2});
            }
        } else if (fillColor1 != 0) {
            gradientDrawable2.setColor(fillColor1);
        } else if (fillColor2 != 0) {
            gradientDrawable2.setColor(fillColor2);
        }
        gradientDrawable2.setStroke(px, strokeColor);
        gradientDrawable2.setOrientation(orientation);
        shapeUtil$strokeCache$1.put(strokeKey, gradientDrawable2);
        Drawable.ConstantState constantState2 = gradientDrawable2.getConstantState();
        Intrinsics.checkNotNull(constantState2);
        Drawable mutate3 = constantState2.newDrawable().mutate();
        Intrinsics.checkNotNullExpressionValue(mutate3, "mutate(...)");
        return mutate3;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Drawable createShapeStroke(@NotNull String color, int round, float width, boolean isCircle, @Nullable String fillColor1, @Nullable String fillColor2, @NotNull GradientDrawable.Orientation orientation) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        try {
            i10 = color.length() > 0 ? Color.parseColor(color) : 0;
        } catch (Exception e10) {
            e = e10;
            i10 = 0;
        }
        if (fillColor1 != null) {
            try {
                str = fillColor1.length() > 0 ? fillColor1 : null;
            } catch (Exception e11) {
                e = e11;
                i11 = 0;
                e.printStackTrace();
                i14 = i10;
                i13 = i11;
                i12 = 0;
                return getStrokeShape(i14, width, round, i13, i12, isCircle, orientation);
            }
            if (str != null) {
                i11 = Color.parseColor(str);
                if (fillColor2 != null) {
                    try {
                        str2 = fillColor2.length() > 0 ? fillColor2 : null;
                    } catch (Exception e12) {
                        e = e12;
                        e.printStackTrace();
                        i14 = i10;
                        i13 = i11;
                        i12 = 0;
                        return getStrokeShape(i14, width, round, i13, i12, isCircle, orientation);
                    }
                    if (str2 != null) {
                        i12 = Color.parseColor(str2);
                        i14 = i10;
                        i13 = i11;
                        return getStrokeShape(i14, width, round, i13, i12, isCircle, orientation);
                    }
                }
                i14 = i10;
                i13 = i11;
                i12 = 0;
                return getStrokeShape(i14, width, round, i13, i12, isCircle, orientation);
            }
        }
        i11 = 0;
        if (fillColor2 != null) {
        }
        i14 = i10;
        i13 = i11;
        i12 = 0;
        return getStrokeShape(i14, width, round, i13, i12, isCircle, orientation);
    }

    @NotNull
    public final Drawable getGradientShape(int startColor, int endColor, int round1, int round2, int round3, int round4, @NotNull GradientDrawable.Orientation orientation) {
        Drawable newDrawable;
        Drawable mutate;
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        ShapeKey shapeKey = new ShapeKey(startColor, endColor, round1, round2, round3, round4, orientation);
        ShapeUtil$shapeCache$1 shapeUtil$shapeCache$1 = shapeCache;
        GradientDrawable gradientDrawable = shapeUtil$shapeCache$1.get(shapeKey);
        if (gradientDrawable != null) {
            Drawable.ConstantState constantState = gradientDrawable.getConstantState();
            if (constantState != null && (newDrawable = constantState.newDrawable()) != null && (mutate = newDrawable.mutate()) != null) {
                return mutate;
            }
            Drawable mutate2 = gradientDrawable.mutate();
            Intrinsics.checkNotNullExpressionValue(mutate2, "mutate(...)");
            return mutate2;
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColors(new int[]{startColor, endColor});
        gradientDrawable2.setCornerRadii(new float[]{UiKtxKt.toPX(round1), UiKtxKt.toPX(round1), UiKtxKt.toPX(round2), UiKtxKt.toPX(round2), UiKtxKt.toPX(round3), UiKtxKt.toPX(round3), UiKtxKt.toPX(round4), UiKtxKt.toPX(round4)});
        gradientDrawable2.setOrientation(orientation);
        shapeUtil$shapeCache$1.put(shapeKey, gradientDrawable2);
        Drawable.ConstantState constantState2 = gradientDrawable2.getConstantState();
        Intrinsics.checkNotNull(constantState2);
        Drawable mutate3 = constantState2.newDrawable().mutate();
        Intrinsics.checkNotNullExpressionValue(mutate3, "mutate(...)");
        return mutate3;
    }

    public static /* synthetic */ Drawable createShape$default(ShapeUtil shapeUtil, String str, String str2, int i10, GradientDrawable.Orientation orientation, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            orientation = GradientDrawable.Orientation.LEFT_RIGHT;
        }
        return shapeUtil.createShape(str, str2, i10, orientation);
    }

    public static /* synthetic */ Drawable getGradientShape$default(ShapeUtil shapeUtil, int i10, int i11, int i12, int i13, int i14, int i15, GradientDrawable.Orientation orientation, int i16, Object obj) {
        return shapeUtil.getGradientShape(i10, i11, (i16 & 4) != 0 ? 0 : i12, (i16 & 8) != 0 ? 0 : i13, (i16 & 16) != 0 ? 0 : i14, (i16 & 32) != 0 ? 0 : i15, (i16 & 64) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : orientation);
    }

    @NotNull
    public final Drawable createShape(@NotNull String startColor, @NotNull String endColor, int round, @NotNull GradientDrawable.Orientation orientation) {
        int i10;
        int i11;
        Intrinsics.checkNotNullParameter(startColor, "startColor");
        Intrinsics.checkNotNullParameter(endColor, "endColor");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        int i12 = -1;
        try {
            if (startColor.length() > 0) {
                int parseColor = Color.parseColor(startColor);
                try {
                    i11 = Color.parseColor(startColor);
                    i12 = parseColor;
                } catch (Exception e10) {
                    e = e10;
                    i12 = parseColor;
                    i10 = -1;
                    e.printStackTrace();
                    i11 = i10;
                    return getGradientShape(i12, i11, round, orientation);
                }
            } else {
                i11 = -1;
            }
        } catch (Exception e11) {
            e = e11;
        }
        try {
            if (endColor.length() > 0) {
                i11 = Color.parseColor(endColor);
            }
        } catch (Exception e12) {
            i10 = i11;
            e = e12;
            e.printStackTrace();
            i11 = i10;
            return getGradientShape(i12, i11, round, orientation);
        }
        return getGradientShape(i12, i11, round, orientation);
    }

    @NotNull
    public final Drawable createShape(@NotNull Context context, int startColor, int endColor, int round1, int round2, int round3, int round4, @NotNull GradientDrawable.Orientation orientation) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return getGradientShape(androidx.core.content.a.getColor(context, startColor), androidx.core.content.a.getColor(context, endColor), round1, round2, round3, round4, orientation);
    }

    @NotNull
    public final Drawable createShape(@NotNull String startColor, @NotNull String endColor, int round1, int round2, int round3, int round4, @NotNull GradientDrawable.Orientation orientation) {
        int i10;
        Intrinsics.checkNotNullParameter(startColor, "startColor");
        Intrinsics.checkNotNullParameter(endColor, "endColor");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        int i11 = 0;
        try {
            i10 = startColor.length() > 0 ? Color.parseColor(startColor) : 0;
        } catch (Exception e10) {
            e = e10;
            i10 = 0;
        }
        try {
            if (endColor.length() > 0) {
                i11 = Color.parseColor(endColor);
            }
        } catch (Exception e11) {
            e = e11;
            e.printStackTrace();
            return getGradientShape(i10, i11, round1, round2, round3, round4, orientation);
        }
        return getGradientShape(i10, i11, round1, round2, round3, round4, orientation);
    }
}
