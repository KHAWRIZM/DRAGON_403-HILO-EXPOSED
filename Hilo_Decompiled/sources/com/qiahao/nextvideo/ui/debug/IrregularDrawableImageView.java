package com.qiahao.nextvideo.ui.debug;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.sud.gip.core.view.round.RoundedDrawable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0014\u0018\u0000 B2\u00020\u0001:\u0001BB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\"\u0010.\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u00100\u001a\u00020\nH\u0002J\b\u00101\u001a\u00020/H\u0016J(\u00102\u001a\u00020/2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\nH\u0014J(\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\n2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\nH\u0002J(\u0010?\u001a\u00020/2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\nH\u0002J\u0010\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020\u000fH\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001a\u0010%\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u00107\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006C"}, d2 = {"Lcom/qiahao/nextvideo/ui/debug/IrregularDrawableImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "PORTER_DUFF_XFERMODE", "Landroid/graphics/PorterDuffXfermode;", "maskCanvas", "Landroid/graphics/Canvas;", "maskBitmap", "Landroid/graphics/Bitmap;", "maskPaint", "Landroid/graphics/Paint;", "drawableCanvas", "drawableBitmap", "drawablePaint", "storePaint", "invalidated", "", TUIConstants.TUICalling.PARAM_NAME_AUDIO_PATH, "Landroid/graphics/Path;", "storePath", "mBorderColor", "getMBorderColor", "()I", "setMBorderColor", "(I)V", "mBorderWidth", "getMBorderWidth", "setMBorderWidth", "mBorderCornor", "getMBorderCornor", "setMBorderCornor", "cornerPathEffect", "Landroid/graphics/CornerPathEffect;", "getCornerPathEffect", "()Landroid/graphics/CornerPathEffect;", "setCornerPathEffect", "(Landroid/graphics/CornerPathEffect;)V", "setUp", "", "defStyle", "invalidate", "onSizeChanged", "w", "h", "oldw", "oldh", "bitmapMask", "getBitmapMask", "()Landroid/graphics/Bitmap;", "setBitmapMask", "(Landroid/graphics/Bitmap;)V", "createMaskCanvas", "width", "height", "paintMaskCanvas", "onDraw", "canvas", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class IrregularDrawableImageView extends AppCompatImageView {

    @NotNull
    private static final String TAG = "IrregularImageView";

    @NotNull
    private final PorterDuffXfermode PORTER_DUFF_XFERMODE;

    @Nullable
    private Bitmap bitmapMask;

    @Nullable
    private CornerPathEffect cornerPathEffect;

    @Nullable
    private Bitmap drawableBitmap;

    @Nullable
    private Canvas drawableCanvas;

    @Nullable
    private Paint drawablePaint;
    private boolean invalidated;
    private int mBorderColor;
    private int mBorderCornor;
    private int mBorderWidth;

    @Nullable
    private Bitmap maskBitmap;

    @Nullable
    private Canvas maskCanvas;

    @Nullable
    private Paint maskPaint;

    @Nullable
    private Path path;

    @Nullable
    private Paint storePaint;

    @Nullable
    private Path storePath;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IrregularDrawableImageView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void createMaskCanvas(int width, int height, int oldw, int oldh) {
        boolean z;
        if (width == oldw && height == oldh) {
            z = false;
        } else {
            z = true;
        }
        if (width > 0 && height > 0) {
            if (this.maskCanvas == null || z) {
                this.maskCanvas = new Canvas();
                this.bitmapMask = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.power_detail_enter_placeholder);
                Bitmap.Config config = Bitmap.Config.ARGB_8888;
                this.maskBitmap = Bitmap.createBitmap(width, height, config);
                Canvas canvas = this.maskCanvas;
                Intrinsics.checkNotNull(canvas);
                canvas.setBitmap(this.maskBitmap);
                Paint paint = this.maskPaint;
                Intrinsics.checkNotNull(paint);
                paint.reset();
                this.drawableCanvas = new Canvas();
                this.drawableBitmap = Bitmap.createBitmap(width, height, config);
                Canvas canvas2 = this.drawableCanvas;
                Intrinsics.checkNotNull(canvas2);
                canvas2.setBitmap(this.drawableBitmap);
                this.drawablePaint = new Paint(1);
                this.storePaint = new Paint(1);
                this.invalidated = true;
            }
        }
    }

    private final void paintMaskCanvas(Canvas maskCanvas, Paint maskPaint, int width, int height) {
        this.path = new Path();
        this.storePath = new Path();
        float f = width;
        float f2 = 0.05f * f;
        float f3 = f - f2;
        float f4 = height;
        float f5 = 0.735f * f4;
        float f6 = f / 2.0f;
        Dimens dimens = Dimens.INSTANCE;
        float dpToPx = f4 - dimens.dpToPx(2);
        Path path = this.path;
        Intrinsics.checkNotNull(path);
        path.moveTo(f2, 0.0f);
        Path path2 = this.path;
        Intrinsics.checkNotNull(path2);
        path2.lineTo(f3, 0.0f);
        Path path3 = this.path;
        Intrinsics.checkNotNull(path3);
        path3.lineTo(f, f5);
        Path path4 = this.path;
        Intrinsics.checkNotNull(path4);
        path4.lineTo(f6, dpToPx);
        Path path5 = this.path;
        Intrinsics.checkNotNull(path5);
        path5.lineTo(0.0f, f5);
        Path path6 = this.path;
        Intrinsics.checkNotNull(path6);
        path6.lineTo(f2, 0.0f);
        Path path7 = this.path;
        Intrinsics.checkNotNull(path7);
        path7.close();
        int dpToPx2 = dimens.dpToPx(this.mBorderWidth) / 6;
        Path path8 = this.storePath;
        Intrinsics.checkNotNull(path8);
        float f7 = dpToPx2;
        float f8 = f2 + f7;
        float f9 = 0.0f + f7;
        path8.moveTo(f8, f9);
        Path path9 = this.storePath;
        Intrinsics.checkNotNull(path9);
        path9.lineTo(f3 - f7, f9);
        Path path10 = this.storePath;
        Intrinsics.checkNotNull(path10);
        path10.lineTo(f - f7, f5);
        Path path11 = this.storePath;
        Intrinsics.checkNotNull(path11);
        path11.lineTo(f6, dpToPx - f7);
        Path path12 = this.storePath;
        Intrinsics.checkNotNull(path12);
        path12.lineTo(f9, f5);
        Path path13 = this.storePath;
        Intrinsics.checkNotNull(path13);
        path13.lineTo(f8, f9);
        Path path14 = this.storePath;
        Intrinsics.checkNotNull(path14);
        path14.close();
        CornerPathEffect cornerPathEffect = this.cornerPathEffect;
        if (cornerPathEffect != null) {
            maskPaint.setPathEffect(cornerPathEffect);
        }
        Path path15 = this.path;
        Intrinsics.checkNotNull(path15);
        maskCanvas.drawPath(path15, maskPaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setUp(Context context, AttributeSet attrs, int defStyle) {
        if (attrs != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.IrregularImageView, defStyle, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
            this.mBorderColor = obtainStyledAttributes.getColor(0, -1);
            this.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            this.mBorderCornor = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.cornerPathEffect = new CornerPathEffect(Dimens.INSTANCE.dpToPx(this.mBorderCornor));
            obtainStyledAttributes.recycle();
        }
        if (getScaleType() == ImageView.ScaleType.FIT_CENTER) {
            setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        Paint paint = new Paint(1);
        this.maskPaint = paint;
        Intrinsics.checkNotNull(paint);
        paint.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
    }

    @Nullable
    public final Bitmap getBitmapMask() {
        return this.bitmapMask;
    }

    @Nullable
    public final CornerPathEffect getCornerPathEffect() {
        return this.cornerPathEffect;
    }

    public final int getMBorderColor() {
        return this.mBorderColor;
    }

    public final int getMBorderCornor() {
        return this.mBorderCornor;
    }

    public final int getMBorderWidth() {
        return this.mBorderWidth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void invalidate() {
        this.invalidated = true;
        super/*android.widget.ImageView*/.invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDraw(@NotNull Canvas canvas) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!isInEditMode()) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            try {
                try {
                    if (this.invalidated && (drawable = getDrawable()) != null) {
                        this.invalidated = false;
                        Matrix imageMatrix = getImageMatrix();
                        if (imageMatrix == null) {
                            Canvas canvas2 = this.drawableCanvas;
                            Intrinsics.checkNotNull(canvas2);
                            drawable.draw(canvas2);
                        } else {
                            Canvas canvas3 = this.drawableCanvas;
                            Intrinsics.checkNotNull(canvas3);
                            int saveCount = canvas3.getSaveCount();
                            Canvas canvas4 = this.drawableCanvas;
                            Intrinsics.checkNotNull(canvas4);
                            canvas4.save();
                            Canvas canvas5 = this.drawableCanvas;
                            Intrinsics.checkNotNull(canvas5);
                            canvas5.concat(imageMatrix);
                            Canvas canvas6 = this.drawableCanvas;
                            Intrinsics.checkNotNull(canvas6);
                            drawable.draw(canvas6);
                            Canvas canvas7 = this.drawableCanvas;
                            Intrinsics.checkNotNull(canvas7);
                            canvas7.restoreToCount(saveCount);
                        }
                        Paint paint = this.drawablePaint;
                        Intrinsics.checkNotNull(paint);
                        paint.reset();
                        Paint paint2 = this.drawablePaint;
                        Intrinsics.checkNotNull(paint2);
                        paint2.setFilterBitmap(false);
                        Paint paint3 = this.drawablePaint;
                        Intrinsics.checkNotNull(paint3);
                        paint3.setXfermode(this.PORTER_DUFF_XFERMODE);
                        Canvas canvas8 = this.drawableCanvas;
                        Intrinsics.checkNotNull(canvas8);
                        Bitmap bitmap = this.bitmapMask;
                        Intrinsics.checkNotNull(bitmap);
                        canvas8.drawBitmap(bitmap, 0.0f, 0.0f, this.drawablePaint);
                        Canvas canvas9 = this.drawableCanvas;
                        Intrinsics.checkNotNull(canvas9);
                        canvas9.save();
                    }
                    if (!this.invalidated) {
                        Paint paint4 = this.drawablePaint;
                        Intrinsics.checkNotNull(paint4);
                        paint4.setXfermode(null);
                        Bitmap bitmap2 = this.drawableBitmap;
                        Intrinsics.checkNotNull(bitmap2);
                        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, this.drawablePaint);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e) {
                    android.util.Log.e(TAG, "Exception occured while drawing " + getId(), e);
                }
                canvas.restoreToCount(saveLayer);
                return;
            } catch (Throwable th) {
                canvas.restoreToCount(saveLayer);
                throw th;
            }
        }
        super/*android.widget.ImageView*/.onDraw(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super/*android.widget.ImageView*/.onSizeChanged(w, h, oldw, oldh);
        createMaskCanvas(w, h, oldw, oldh);
    }

    public final void setBitmapMask(@Nullable Bitmap bitmap) {
        this.bitmapMask = bitmap;
    }

    public final void setCornerPathEffect(@Nullable CornerPathEffect cornerPathEffect) {
        this.cornerPathEffect = cornerPathEffect;
    }

    public final void setMBorderColor(int i) {
        this.mBorderColor = i;
    }

    public final void setMBorderCornor(int i) {
        this.mBorderCornor = i;
    }

    public final void setMBorderWidth(int i) {
        this.mBorderWidth = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IrregularDrawableImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IrregularDrawableImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.PORTER_DUFF_XFERMODE = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.invalidated = true;
        this.mBorderColor = -1;
        setUp(context, attributeSet, i);
    }
}
