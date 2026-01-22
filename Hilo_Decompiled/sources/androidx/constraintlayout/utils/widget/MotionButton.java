package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class MotionButton extends AppCompatButton {

    /* renamed from: a, reason: collision with root package name */
    private float f٢٢٤٢a;

    /* renamed from: b, reason: collision with root package name */
    private float f٢٢٤٣b;

    /* renamed from: c, reason: collision with root package name */
    private Path f٢٢٤٤c;

    /* renamed from: d, reason: collision with root package name */
    ViewOutlineProvider f٢٢٤٥d;

    /* renamed from: e, reason: collision with root package name */
    RectF f٢٢٤٦e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), (Math.min(r3, r4) * MotionButton.this.f٢٢٤٢a) / 2.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), MotionButton.this.f٢٢٤٣b);
        }
    }

    public MotionButton(Context context) {
        super(context);
        this.f٢٢٤٢a = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢٢٤٣b = Float.NaN;
        c(context, null);
    }

    private void c(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, DownloadProgress.UNKNOWN_PROGRESS));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, DownloadProgress.UNKNOWN_PROGRESS));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getRound() {
        return this.f٢٢٤٣b;
    }

    public float getRoundPercent() {
        return this.f٢٢٤٢a;
    }

    @RequiresApi(21)
    public void setRound(float f10) {
        boolean z10;
        if (Float.isNaN(f10)) {
            this.f٢٢٤٣b = f10;
            float f11 = this.f٢٢٤٢a;
            this.f٢٢٤٢a = -1.0f;
            setRoundPercent(f11);
            return;
        }
        if (this.f٢٢٤٣b != f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f٢٢٤٣b = f10;
        if (f10 != DownloadProgress.UNKNOWN_PROGRESS) {
            if (this.f٢٢٤٤c == null) {
                this.f٢٢٤٤c = new Path();
            }
            if (this.f٢٢٤٦e == null) {
                this.f٢٢٤٦e = new RectF();
            }
            if (this.f٢٢٤٥d == null) {
                b bVar = new b();
                this.f٢٢٤٥d = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f٢٢٤٦e.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, getWidth(), getHeight());
            this.f٢٢٤٤c.reset();
            Path path = this.f٢٢٤٤c;
            RectF rectF = this.f٢٢٤٦e;
            float f12 = this.f٢٢٤٣b;
            path.addRoundRect(rectF, f12, f12, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    @RequiresApi(21)
    public void setRoundPercent(float f10) {
        boolean z10;
        if (this.f٢٢٤٢a != f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f٢٢٤٢a = f10;
        if (f10 != DownloadProgress.UNKNOWN_PROGRESS) {
            if (this.f٢٢٤٤c == null) {
                this.f٢٢٤٤c = new Path();
            }
            if (this.f٢٢٤٦e == null) {
                this.f٢٢٤٦e = new RectF();
            }
            if (this.f٢٢٤٥d == null) {
                a aVar = new a();
                this.f٢٢٤٥d = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f٢٢٤٢a) / 2.0f;
            this.f٢٢٤٦e.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, width, height);
            this.f٢٢٤٤c.reset();
            this.f٢٢٤٤c.addRoundRect(this.f٢٢٤٦e, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public MotionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٢٢٤٢a = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢٢٤٣b = Float.NaN;
        c(context, attributeSet);
    }

    public MotionButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٢٢٤٢a = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢٢٤٣b = Float.NaN;
        c(context, attributeSet);
    }
}
