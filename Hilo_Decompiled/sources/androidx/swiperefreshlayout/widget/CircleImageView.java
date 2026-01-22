package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.d1;
import androidx.swiperefreshlayout.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class CircleImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Animation.AnimationListener f٤١٤٢a;

    /* renamed from: b, reason: collision with root package name */
    private int f٤١٤٣b;

    /* renamed from: c, reason: collision with root package name */
    private int f٤١٤٤c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a extends OvalShape {

        /* renamed from: a, reason: collision with root package name */
        private Paint f٤١٤٥a = new Paint();

        /* renamed from: b, reason: collision with root package name */
        private int f٤١٤٦b;

        /* renamed from: c, reason: collision with root package name */
        private CircleImageView f٤١٤٧c;

        a(CircleImageView circleImageView, int i10) {
            this.f٤١٤٧c = circleImageView;
            this.f٤١٤٦b = i10;
            a((int) rect().width());
        }

        private void a(int i10) {
            float f10 = i10 / 2;
            this.f٤١٤٥a.setShader(new RadialGradient(f10, f10, this.f٤١٤٦b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP));
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            float width = this.f٤١٤٧c.getWidth() / 2;
            float height = this.f٤١٤٧c.getHeight() / 2;
            canvas.drawCircle(width, height, width, this.f٤١٤٥a);
            canvas.drawCircle(width, height, r0 - this.f٤١٤٦b, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f10, float f11) {
            super.onResize(f10, f11);
            a((int) f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleImageView(Context context) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f10 = getContext().getResources().getDisplayMetrics().density;
        int i10 = (int) (1.75f * f10);
        int i11 = (int) (DownloadProgress.UNKNOWN_PROGRESS * f10);
        this.f٤١٤٣b = (int) (3.5f * f10);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(R.styleable.SwipeRefreshLayout);
        this.f٤١٤٤c = obtainStyledAttributes.getColor(R.styleable.SwipeRefreshLayout_swipeRefreshLayoutProgressSpinnerBackgroundColor, -328966);
        obtainStyledAttributes.recycle();
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            d1.x0(this, f10 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new a(this, this.f٤١٤٣b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f٤١٤٣b, i11, i10, 503316480);
            int i12 = this.f٤١٤٣b;
            setPadding(i12, i12, i12, i12);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(this.f٤١٤٤c);
        d1.t0(this, shapeDrawable);
    }

    private boolean a() {
        return true;
    }

    public int getBackgroundColor() {
        return this.f٤١٤٤c;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f٤١٤٢a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f٤١٤٢a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (!a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f٤١٤٣b * 2), getMeasuredHeight() + (this.f٤١٤٣b * 2));
        }
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.f٤١٤٢a = animationListener;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i10);
            this.f٤١٤٤c = i10;
        }
    }
}
