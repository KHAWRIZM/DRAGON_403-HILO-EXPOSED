package com.skydoves.balloon.overlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import com.skydoves.balloon.extensions.ContextExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0014J\b\u00105\u001a\u00020\u0007H\u0002J0\u00106\u001a\u0002022\u0006\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0007H\u0014J\b\u0010<\u001a\u000202H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010 \u001a\u00020\u00072\b\b\u0001\u0010\u0011\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R&\u0010%\u001a\u00020\u000e2\b\b\u0001\u0010\u0011\u001a\u00020\u000e8G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u0010*\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/skydoves/balloon/overlay/BalloonAnchorOverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_anchorView", "_balloonOverlayShape", "Lcom/skydoves/balloon/overlay/BalloonOverlayShape;", "_overlayColor", "_overlayPadding", "", "_overlayPosition", "Landroid/graphics/Point;", "value", "anchorView", "getAnchorView", "()Landroid/view/View;", "setAnchorView", "(Landroid/view/View;)V", "balloonOverlayShape", "getBalloonOverlayShape", "()Lcom/skydoves/balloon/overlay/BalloonOverlayShape;", "setBalloonOverlayShape", "(Lcom/skydoves/balloon/overlay/BalloonOverlayShape;)V", "bitmap", "Landroid/graphics/Bitmap;", "invalidated", "", "overlayColor", "getOverlayColor", "()I", "setOverlayColor", "(I)V", "overlayPadding", "getOverlayPadding", "()F", "setOverlayPadding", "(F)V", "overlayPosition", "getOverlayPosition", "()Landroid/graphics/Point;", "setOverlayPosition", "(Landroid/graphics/Point;)V", "paint", "Landroid/graphics/Paint;", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "getStatusBarHeight", "onLayout", "changed", "left", "top", "right", "bottom", "prepareBitmap", "balloon_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class BalloonAnchorOverlayView extends View {
    private View _anchorView;
    private BalloonOverlayShape _balloonOverlayShape;
    private int _overlayColor;
    private float _overlayPadding;
    private Point _overlayPosition;
    private Bitmap bitmap;
    private boolean invalidated;
    private final Paint paint;

    @JvmOverloads
    public BalloonAnchorOverlayView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    private final int getStatusBarHeight() {
        Rect rect = new Rect();
        Context context = getContext();
        if (context instanceof Activity) {
            Window window = ((Activity) context).getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "context.window");
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            return rect.top;
        }
        return 0;
    }

    private final void prepareBitmap() {
        RectF rectF;
        if (getWidth() != 0 && getHeight() != 0) {
            View view = get_anchorView();
            if (view == null || view.getWidth() != 0) {
                View view2 = get_anchorView();
                if (view2 == null || view2.getHeight() != 0) {
                    Bitmap bitmap = this.bitmap;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                    this.bitmap = createBitmap;
                    Canvas canvas = new Canvas(createBitmap);
                    Paint paint = this.paint;
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
                    paint.setColor(get_overlayColor());
                    canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.paint);
                    Paint paint2 = this.paint;
                    paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                    paint2.setColor(0);
                    View view3 = get_anchorView();
                    if (view3 != null) {
                        if (get_overlayPosition() != null) {
                            rectF = new RectF(r2.x - get_overlayPadding(), (r2.y - get_overlayPadding()) + getStatusBarHeight(), r2.x + view3.getWidth() + get_overlayPadding(), r2.y + view3.getHeight() + get_overlayPadding() + getStatusBarHeight());
                        } else {
                            rectF = new RectF(view3.getX() - get_overlayPadding(), (view3.getY() - get_overlayPadding()) + getStatusBarHeight(), view3.getX() + view3.getWidth() + get_overlayPadding(), view3.getY() + view3.getHeight() + get_overlayPadding() + getStatusBarHeight());
                        }
                        BalloonOverlayShape balloonOverlayShape = get_balloonOverlayShape();
                        if (balloonOverlayShape instanceof BalloonOverlayRect) {
                            canvas.drawRect(rectF, this.paint);
                        } else if (balloonOverlayShape instanceof BalloonOverlayOval) {
                            canvas.drawOval(rectF, this.paint);
                        } else if (balloonOverlayShape instanceof BalloonOverlayCircle) {
                            canvas.drawCircle(rectF.centerX(), rectF.centerY(), ((BalloonOverlayCircle) balloonOverlayShape).getRadius(), this.paint);
                        } else if (balloonOverlayShape instanceof BalloonOverlayRoundRect) {
                            BalloonOverlayRoundRect balloonOverlayRoundRect = (BalloonOverlayRoundRect) balloonOverlayShape;
                            canvas.drawRoundRect(rectF, balloonOverlayRoundRect.getRadiusX(), balloonOverlayRoundRect.getRadiusY(), this.paint);
                        }
                    }
                    this.invalidated = false;
                }
            }
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(@Nullable Canvas canvas) {
        Bitmap bitmap;
        if (this.invalidated || (bitmap = this.bitmap) == null || (bitmap != null && bitmap.isRecycled())) {
            prepareBitmap();
        }
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null && !bitmap2.isRecycled() && canvas != null) {
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Nullable
    /* renamed from: getAnchorView, reason: from getter */
    public final View get_anchorView() {
        return this._anchorView;
    }

    @NotNull
    /* renamed from: getBalloonOverlayShape, reason: from getter */
    public final BalloonOverlayShape get_balloonOverlayShape() {
        return this._balloonOverlayShape;
    }

    /* renamed from: getOverlayColor, reason: from getter */
    public final int get_overlayColor() {
        return this._overlayColor;
    }

    /* renamed from: getOverlayPadding, reason: from getter */
    public final float get_overlayPadding() {
        return this._overlayPadding;
    }

    @Nullable
    /* renamed from: getOverlayPosition, reason: from getter */
    public final Point get_overlayPosition() {
        return this._overlayPosition;
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top2, int right, int bottom) {
        super.onLayout(changed, left, top2, right, bottom);
        this.invalidated = true;
    }

    public final void setAnchorView(@Nullable View view) {
        this._anchorView = view;
        invalidate();
    }

    public final void setBalloonOverlayShape(@NotNull BalloonOverlayShape balloonOverlayShape) {
        Intrinsics.checkNotNullParameter(balloonOverlayShape, "value");
        this._balloonOverlayShape = balloonOverlayShape;
        invalidate();
    }

    public final void setOverlayColor(int i) {
        this._overlayColor = i;
        invalidate();
    }

    public final void setOverlayPadding(float f) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this._overlayPadding = ContextExtensionKt.dp2Px(context, f);
        invalidate();
    }

    public final void setOverlayPosition(@Nullable Point point) {
        this._overlayPosition = point;
        invalidate();
    }

    @JvmOverloads
    public BalloonAnchorOverlayView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ BalloonAnchorOverlayView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BalloonAnchorOverlayView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this._balloonOverlayShape = BalloonOverlayOval.INSTANCE;
        Paint paint = new Paint(1);
        this.paint = paint;
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
    }
}
