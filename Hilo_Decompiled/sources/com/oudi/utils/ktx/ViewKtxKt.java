package com.oudi.utils.ktx;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.core.view.o0;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.utils.ColorUtils;
import com.oudi.utils.ShapeViewOutlineProvider;
import com.oudi.utils.UiUtils;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a2\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u000b\u001a2\u0010\f\u001a\u00020\u0005*\u00020\u00002\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000b\u001aA\u0010\u0011\u001a\u00020\u0005\"\b\b\u0000\u0010\r*\u00020\u0000*\u00028\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0014\b\u0004\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a-\u0010\u0011\u001a\u00020\u0005\"\b\b\u0000\u0010\r*\u00020\u0000*\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0015\u001a#\u0010\u0018\u001a\u00020\u0005\"\b\b\u0000\u0010\r*\u00020\u0000*\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001b\u0010\u001a\u001a\u00020\u0005\"\b\b\u0000\u0010\r*\u00020\u0000*\u00028\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0011\u0010\u001d\u001a\u00020\u001c*\u00020\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aC\u0010#\u001a\u00020\u0005*\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b#\u0010$\u001aC\u0010%\u001a\u00020\u0005*\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b%\u0010$\u001a\u0019\u0010)\u001a\u00020\u0005*\u00020&2\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*\u001a\u0011\u0010,\u001a\u00020\u0005*\u00020+¢\u0006\u0004\b,\u0010-\u001a\u0019\u0010/\u001a\u00020\u0005*\u00020\u00002\u0006\u0010.\u001a\u00020\u0001¢\u0006\u0004\b/\u0010\u0007\u001a3\u00106\u001a\u00020\u0005*\u00020\u00002\u000e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001002\u0006\u00103\u001a\u00020\u00162\b\b\u0002\u00105\u001a\u000204¢\u0006\u0004\b6\u00107\"2\u0010=\u001a\u00020\u000e\"\b\b\u0000\u0010\r*\u00020\u0000*\u00028\u00002\u0006\u00108\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006>"}, d2 = {"Landroid/view/View;", "", "isRtl", "(Landroid/view/View;)Z", LiveEvent.SHOW_ANIMATION, "", "visibleOrGone", "(Landroid/view/View;Z)V", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "show", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "visibleOrInvisible", "T", "", "time", ChatMenuDialog.CLICK_BLOCK, "singleClick", "(Landroid/view/View;JLkotlin/jvm/functions/Function1;)V", "Landroid/view/View$OnClickListener;", "onClickListener", "(Landroid/view/View;Landroid/view/View$OnClickListener;J)V", "", "corner", "roundCorner", "(Landroid/view/View;I)V", "circle", "(Landroid/view/View;)V", "Landroid/graphics/Bitmap;", "getBitmap", "(Landroid/view/View;)Landroid/graphics/Bitmap;", "start", ViewHierarchyConstants.DIMENSION_TOP_KEY, "end", "bottom", "setMargin", "(Landroid/view/View;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setPadding2", "Landroid/widget/TextView;", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "strokeWidth", "(Landroid/widget/TextView;F)V", "Landroidx/core/view/o0;", "simulateClickAndCancel", "(Landroidx/core/view/o0;)V", "isGray", "applyGrayFilter", "", "", "colorList", "radius", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "orientation", "setShape", "(Landroid/view/View;Ljava/util/List;ILandroid/graphics/drawable/GradientDrawable$Orientation;)V", "value", "getLastClickTime", "(Landroid/view/View;)J", "setLastClickTime", "(Landroid/view/View;J)V", "lastClickTime", "lib_utils_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ViewKtxKt {
    public static final void applyGrayFilter(View view, boolean z10) {
        float f10;
        Intrinsics.checkNotNullParameter(view, "<this>");
        try {
            Paint paint = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            if (z10) {
                f10 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                f10 = 1.0f;
            }
            colorMatrix.setSaturation(f10);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            view.setLayerType(2, paint);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static final <T extends View> void circle(T t10) {
        Intrinsics.checkNotNullParameter(t10, "<this>");
        if (t10.getOutlineProvider() == null || !(t10.getOutlineProvider() instanceof ShapeViewOutlineProvider.Circle)) {
            t10.setOutlineProvider(new ShapeViewOutlineProvider.Circle());
        }
        t10.setClipToOutline(true);
    }

    public static final Bitmap getBitmap(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        canvas.translate(view.getScrollX(), view.getScrollY());
        view.draw(canvas);
        return createBitmap;
    }

    public static final <T extends View> long getLastClickTime(T t10) {
        Long l10;
        Intrinsics.checkNotNullParameter(t10, "<this>");
        Object tag = t10.getTag(1766613352);
        if (tag instanceof Long) {
            l10 = (Long) tag;
        } else {
            l10 = null;
        }
        if (l10 != null) {
            return l10.longValue();
        }
        return 0L;
    }

    public static final boolean isRtl(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return UiUtils.INSTANCE.isRtl(view);
    }

    public static final <T extends View> void roundCorner(T t10, int i10) {
        Intrinsics.checkNotNullParameter(t10, "<this>");
        if (t10.getOutlineProvider() != null && (t10.getOutlineProvider() instanceof ShapeViewOutlineProvider.Round)) {
            if (t10.getOutlineProvider() != null && (t10.getOutlineProvider() instanceof ShapeViewOutlineProvider.Round)) {
                ViewOutlineProvider outlineProvider = t10.getOutlineProvider();
                Intrinsics.checkNotNull(outlineProvider, "null cannot be cast to non-null type com.oudi.utils.ShapeViewOutlineProvider.Round");
                ((ShapeViewOutlineProvider.Round) outlineProvider).setCorner(i10);
            }
        } else {
            t10.setOutlineProvider(new ShapeViewOutlineProvider.Round(i10));
        }
        t10.setClipToOutline(true);
    }

    public static final <T extends View> void setLastClickTime(T t10, long j10) {
        Intrinsics.checkNotNullParameter(t10, "<this>");
        t10.setTag(1766613352, Long.valueOf(j10));
    }

    public static final void setMargin(View view, Integer num, Integer num2, Integer num3, Integer num4) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        }
        if (marginLayoutParams != null) {
            if (num != null) {
                marginLayoutParams.setMarginStart(num.intValue());
            }
            if (num2 != null) {
                marginLayoutParams.topMargin = num2.intValue();
            }
            if (num3 != null) {
                marginLayoutParams.setMarginEnd(num3.intValue());
            }
            if (num4 != null) {
                marginLayoutParams.bottomMargin = num4.intValue();
            }
        }
    }

    public static /* synthetic */ void setMargin$default(View view, Integer num, Integer num2, Integer num3, Integer num4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        if ((i10 & 2) != 0) {
            num2 = null;
        }
        if ((i10 & 4) != 0) {
            num3 = null;
        }
        if ((i10 & 8) != 0) {
            num4 = null;
        }
        setMargin(view, num, num2, num3, num4);
    }

    public static final void setPadding2(View view, Integer num, Integer num2, Integer num3, Integer num4) {
        int paddingStart;
        int paddingTop;
        int paddingEnd;
        int paddingBottom;
        if (view == null) {
            return;
        }
        if (num != null) {
            paddingStart = num.intValue();
        } else {
            paddingStart = view.getPaddingStart();
        }
        if (num2 != null) {
            paddingTop = num2.intValue();
        } else {
            paddingTop = view.getPaddingTop();
        }
        if (num3 != null) {
            paddingEnd = num3.intValue();
        } else {
            paddingEnd = view.getPaddingEnd();
        }
        if (num4 != null) {
            paddingBottom = num4.intValue();
        } else {
            paddingBottom = view.getPaddingBottom();
        }
        view.setPadding(paddingStart, paddingTop, paddingEnd, paddingBottom);
    }

    public static /* synthetic */ void setPadding2$default(View view, Integer num, Integer num2, Integer num3, Integer num4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        if ((i10 & 2) != 0) {
            num2 = null;
        }
        if ((i10 & 4) != 0) {
            num3 = null;
        }
        if ((i10 & 8) != 0) {
            num4 = null;
        }
        setPadding2(view, num, num2, num3, num4);
    }

    public static final void setShape(View view, List<String> list, int i10, GradientDrawable.Orientation orientation) {
        int[] intArray;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (list != null) {
            try {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(ColorUtils.string2Int((String) it.next())));
                }
                intArray = CollectionsKt.toIntArray(arrayList);
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        } else {
            intArray = null;
        }
        if (intArray != null && intArray.length != 0) {
            if (intArray.length == 1) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(ArraysKt.first(intArray));
                gradientDrawable.setOrientation(orientation);
                gradientDrawable.setCornerRadius(UiKtxKt.toPX(i10));
                view.setBackground(gradientDrawable);
                return;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable(orientation, intArray);
            gradientDrawable2.setCornerRadius(UiKtxKt.toPX(i10));
            view.setBackground(gradientDrawable2);
        }
    }

    public static /* synthetic */ void setShape$default(View view, List list, int i10, GradientDrawable.Orientation orientation, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            orientation = GradientDrawable.Orientation.LEFT_RIGHT;
        }
        setShape(view, list, i10, orientation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void simulateClickAndCancel(o0 o0Var) {
        View view;
        Intrinsics.checkNotNullParameter(o0Var, "<this>");
        if (o0Var instanceof View) {
            view = (View) o0Var;
        } else {
            view = null;
        }
        if (view == null) {
            return;
        }
        view.dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), 0, (view.getRight() - view.getLeft()) / 2.0f, (view.getBottom() - view.getTop()) / 2.0f, 0));
        view.dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), 3, (view.getRight() - view.getLeft()) / 2.0f, (view.getBottom() - view.getTop()) / 2.0f, 0));
    }

    public static final <T extends View> void singleClick(T t10, long j10, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(t10, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        t10.setOnClickListener(new ViewKtxKt$singleClick$1(t10, j10, block));
    }

    public static /* synthetic */ void singleClick$default(View view, View.OnClickListener onClickListener, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 800;
        }
        singleClick(view, onClickListener, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void singleClick$lambda$0(View view, long j10, View.OnClickListener onClickListener, View view2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - getLastClickTime(view) > j10 || (view instanceof Checkable)) {
            setLastClickTime(view, currentTimeMillis);
            onClickListener.onClick(view);
        }
    }

    public static final void strokeWidth(TextView textView, float f10) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        TextPaint paint = textView.getPaint();
        if (paint != null) {
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        TextPaint paint2 = textView.getPaint();
        if (paint2 != null) {
            paint2.setStrokeWidth(f10);
        }
        textView.invalidate();
    }

    public static final void visibleOrGone(View view, boolean z10) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(z10 ? 0 : 8);
    }

    public static /* synthetic */ void visibleOrGone$default(View view, Function1 show, int i10, Object obj) {
        int i11;
        if ((i10 & 1) != 0) {
            show = new Function1<View, Boolean>() { // from class: com.oudi.utils.ktx.ViewKtxKt$visibleOrGone$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(View view2) {
                    Intrinsics.checkNotNullParameter(view2, "<this>");
                    return Boolean.TRUE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(show, "show");
        if (((Boolean) show.invoke(view)).booleanValue()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        view.setVisibility(i11);
    }

    public static final void visibleOrInvisible(View view, Function1<? super View, Boolean> show) {
        int i10;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(show, "show");
        if (show.invoke(view).booleanValue()) {
            i10 = 0;
        } else {
            i10 = 4;
        }
        view.setVisibility(i10);
    }

    public static /* synthetic */ void visibleOrInvisible$default(View view, Function1 show, int i10, Object obj) {
        int i11;
        if ((i10 & 1) != 0) {
            show = new Function1<View, Boolean>() { // from class: com.oudi.utils.ktx.ViewKtxKt$visibleOrInvisible$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(View view2) {
                    Intrinsics.checkNotNullParameter(view2, "<this>");
                    return Boolean.TRUE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(show, "show");
        if (((Boolean) show.invoke(view)).booleanValue()) {
            i11 = 0;
        } else {
            i11 = 4;
        }
        view.setVisibility(i11);
    }

    public static final <T extends View> void singleClick(final T t10, final View.OnClickListener onClickListener, final long j10) {
        Intrinsics.checkNotNullParameter(t10, "<this>");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        t10.setOnClickListener(new View.OnClickListener() { // from class: com.oudi.utils.ktx.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewKtxKt.singleClick$lambda$0(t10, j10, onClickListener, view);
            }
        });
    }

    public static /* synthetic */ void singleClick$default(View view, long j10, Function1 block, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 800;
        }
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        view.setOnClickListener(new ViewKtxKt$singleClick$1(view, j10, block));
    }

    public static final void visibleOrGone(View view, Function1<? super View, Boolean> show) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(show, "show");
        view.setVisibility(show.invoke(view).booleanValue() ? 0 : 8);
    }
}
