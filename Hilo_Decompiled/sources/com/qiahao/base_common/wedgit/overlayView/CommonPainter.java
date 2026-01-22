package com.qiahao.base_common.wedgit.overlayView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.R;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J.\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0016\u0010\u0012\u001a\u00020\u00132\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\u0015"}, d2 = {"Lcom/qiahao/base_common/wedgit/overlayView/CommonPainter;", "Lcom/qiahao/base_common/wedgit/overlayView/IPainter;", "<init>", "()V", "getBackgroundColor", "", "onDraw", "", "context", "Landroid/content/Context;", "absRectList", "", "Landroid/graphics/Rect;", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "unionRect", "getUnionPath", "Landroid/graphics/Path;", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CommonPainter implements IPainter {
    private static final int CLOSE_DISTANCE = 100;
    private static final int CORNER_SIZE = UiKtxKt.toPX(12);
    private static final int STROKE_WIDTH = UiKtxKt.toPX(2);
    private static final int BACKGROUND_COLOR = R.color.black_overlay;
    private static final int STROKE_COLOR = R.color.ayp_red;

    private final Path getUnionPath(List<Rect> absRectList) {
        if (absRectList.isEmpty()) {
            return new Path();
        }
        Region region = new Region();
        Iterator<Rect> it = absRectList.iterator();
        while (it.hasNext()) {
            region.union(it.next());
        }
        Path path = new Path();
        region.getBoundaryPath(path);
        return path;
    }

    private final void unionRect(List<Rect> absRectList) {
        List<Rect> list = absRectList;
        int size = absRectList.size();
        int i10 = 0;
        while (i10 < size) {
            int size2 = absRectList.size();
            int i11 = 0;
            while (i11 < size2) {
                Rect rect = list.get(i10);
                Rect rect2 = list.get(i11);
                int i12 = rect.top;
                int i13 = rect2.bottom;
                int i14 = i12 - i13;
                int i15 = rect.left;
                int i16 = rect2.right;
                int i17 = i15 - i16;
                int i18 = rect2.top;
                int i19 = rect.bottom;
                int i20 = i18 - i19;
                int i21 = rect2.left;
                int i22 = rect.right;
                int i23 = size;
                int i24 = i21 - i22;
                int i25 = size2;
                int i26 = i10;
                if (1 <= i14 && i14 < 101 && i15 >= i21 && i22 <= i16) {
                    rect.top = i18;
                } else if (1 <= i17 && i17 < 101 && i12 >= i18 && i19 <= i13) {
                    rect.left = i21;
                } else if (1 <= i20 && i20 < 101 && i15 >= i21 && i22 <= i16) {
                    rect.bottom = i13;
                } else if (1 <= i24 && i24 < 101 && i12 >= i18 && i19 <= i13) {
                    rect.right = i16;
                }
                i11++;
                list = absRectList;
                size = i23;
                size2 = i25;
                i10 = i26;
            }
            i10++;
            list = absRectList;
        }
    }

    @Override // com.qiahao.base_common.wedgit.overlayView.IPainter
    public int getBackgroundColor() {
        return BACKGROUND_COLOR;
    }

    @Override // com.qiahao.base_common.wedgit.overlayView.IPainter
    public void onDraw(@NotNull Context context, @NotNull List<Rect> absRectList, @NotNull Canvas canvas, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(absRectList, "absRectList");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        unionRect(absRectList);
        Path unionPath = getUnionPath(absRectList);
        CornerPathEffect cornerPathEffect = new CornerPathEffect(CORNER_SIZE);
        paint.setPathEffect(cornerPathEffect);
        canvas.drawPath(unionPath, paint);
        Paint paint2 = new Paint();
        paint2.setColor(androidx.core.content.a.getColor(context, STROKE_COLOR));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(STROKE_WIDTH);
        paint2.setPathEffect(cornerPathEffect);
        canvas.drawPath(unionPath, paint2);
    }
}
