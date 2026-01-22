package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.p;
import androidx.constraintlayout.widget.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class Carousel extends MotionHelper {
    private int A;

    /* renamed from: B, reason: collision with root package name */
    private float f١٧٨١B;
    private int C;
    private int D;
    int E;
    Runnable F;

    /* renamed from: n, reason: collision with root package name */
    private final ArrayList f١٧٨٢n;

    /* renamed from: o, reason: collision with root package name */
    private int f١٧٨٣o;

    /* renamed from: p, reason: collision with root package name */
    private int f١٧٨٤p;

    /* renamed from: q, reason: collision with root package name */
    private MotionLayout f١٧٨٥q;

    /* renamed from: r, reason: collision with root package name */
    private int f١٧٨٦r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f١٧٨٧s;

    /* renamed from: t, reason: collision with root package name */
    private int f١٧٨٨t;

    /* renamed from: u, reason: collision with root package name */
    private int f١٧٨٩u;

    /* renamed from: v, reason: collision with root package name */
    private int f١٧٩٠v;

    /* renamed from: w, reason: collision with root package name */
    private int f١٧٩١w;

    /* renamed from: x, reason: collision with root package name */
    private float f١٧٩٢x;

    /* renamed from: y, reason: collision with root package name */
    private int f١٧٩٣y;

    /* renamed from: z, reason: collision with root package name */
    private int f١٧٩٤z;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Carousel.this.f١٧٨٥q.setProgress(DownloadProgress.UNKNOWN_PROGRESS);
            Carousel.this.J();
            Carousel.H(Carousel.this);
            int unused = Carousel.this.f١٧٨٤p;
            throw null;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface b {
    }

    public Carousel(Context context) {
        super(context);
        this.f١٧٨٢n = new ArrayList();
        this.f١٧٨٣o = 0;
        this.f١٧٨٤p = 0;
        this.f١٧٨٦r = -1;
        this.f١٧٨٧s = false;
        this.f١٧٨٨t = -1;
        this.f١٧٨٩u = -1;
        this.f١٧٩٠v = -1;
        this.f١٧٩١w = -1;
        this.f١٧٩٢x = 0.9f;
        this.f١٧٩٣y = 0;
        this.f١٧٩٤z = 4;
        this.A = 1;
        this.f١٧٨١B = 2.0f;
        this.C = -1;
        this.D = 200;
        this.E = -1;
        this.F = new a();
    }

    static /* synthetic */ b H(Carousel carousel) {
        carousel.getClass();
        return null;
    }

    private void I(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Carousel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.Carousel_carousel_firstView) {
                    this.f١٧٨٦r = obtainStyledAttributes.getResourceId(index, this.f١٧٨٦r);
                } else if (index == R.styleable.Carousel_carousel_backwardTransition) {
                    this.f١٧٨٨t = obtainStyledAttributes.getResourceId(index, this.f١٧٨٨t);
                } else if (index == R.styleable.Carousel_carousel_forwardTransition) {
                    this.f١٧٨٩u = obtainStyledAttributes.getResourceId(index, this.f١٧٨٩u);
                } else if (index == R.styleable.Carousel_carousel_emptyViewsBehavior) {
                    this.f١٧٩٤z = obtainStyledAttributes.getInt(index, this.f١٧٩٤z);
                } else if (index == R.styleable.Carousel_carousel_previousState) {
                    this.f١٧٩٠v = obtainStyledAttributes.getResourceId(index, this.f١٧٩٠v);
                } else if (index == R.styleable.Carousel_carousel_nextState) {
                    this.f١٧٩١w = obtainStyledAttributes.getResourceId(index, this.f١٧٩١w);
                } else if (index == R.styleable.Carousel_carousel_touchUp_dampeningFactor) {
                    this.f١٧٩٢x = obtainStyledAttributes.getFloat(index, this.f١٧٩٢x);
                } else if (index == R.styleable.Carousel_carousel_touchUpMode) {
                    this.A = obtainStyledAttributes.getInt(index, this.A);
                } else if (index == R.styleable.Carousel_carousel_touchUp_velocityThreshold) {
                    this.f١٧٨١B = obtainStyledAttributes.getFloat(index, this.f١٧٨١B);
                } else if (index == R.styleable.Carousel_carousel_infinite) {
                    this.f١٧٨٧s = obtainStyledAttributes.getBoolean(index, this.f١٧٨٧s);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.k
    public void a(MotionLayout motionLayout, int i10, int i11, float f10) {
        this.E = i10;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.k
    public void b(MotionLayout motionLayout, int i10) {
        int i11 = this.f١٧٨٤p;
        this.f١٧٨٣o = i11;
        if (i10 == this.f١٧٩١w) {
            this.f١٧٨٤p = i11 + 1;
        } else if (i10 == this.f١٧٩٠v) {
            this.f١٧٨٤p = i11 - 1;
        }
        if (this.f١٧٨٧s) {
            throw null;
        }
        throw null;
    }

    public int getCount() {
        return 0;
    }

    public int getCurrentIndex() {
        return this.f١٧٨٤p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            for (int i10 = 0; i10 < this.f٢٢٨٩b; i10++) {
                int i11 = this.f٢٢٨٨a[i10];
                View viewById = motionLayout.getViewById(i11);
                if (this.f١٧٨٦r == i11) {
                    this.f١٧٩٣y = i10;
                }
                this.f١٧٨٢n.add(viewById);
            }
            this.f١٧٨٥q = motionLayout;
            if (this.A == 2) {
                p.b Z = motionLayout.Z(this.f١٧٨٩u);
                if (Z != null) {
                    Z.G(5);
                }
                p.b Z2 = this.f١٧٨٥q.Z(this.f١٧٨٨t);
                if (Z2 != null) {
                    Z2.G(5);
                }
            }
            J();
        }
    }

    public void setAdapter(b bVar) {
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٧٨٢n = new ArrayList();
        this.f١٧٨٣o = 0;
        this.f١٧٨٤p = 0;
        this.f١٧٨٦r = -1;
        this.f١٧٨٧s = false;
        this.f١٧٨٨t = -1;
        this.f١٧٨٩u = -1;
        this.f١٧٩٠v = -1;
        this.f١٧٩١w = -1;
        this.f١٧٩٢x = 0.9f;
        this.f١٧٩٣y = 0;
        this.f١٧٩٤z = 4;
        this.A = 1;
        this.f١٧٨١B = 2.0f;
        this.C = -1;
        this.D = 200;
        this.E = -1;
        this.F = new a();
        I(context, attributeSet);
    }

    public Carousel(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٧٨٢n = new ArrayList();
        this.f١٧٨٣o = 0;
        this.f١٧٨٤p = 0;
        this.f١٧٨٦r = -1;
        this.f١٧٨٧s = false;
        this.f١٧٨٨t = -1;
        this.f١٧٨٩u = -1;
        this.f١٧٩٠v = -1;
        this.f١٧٩١w = -1;
        this.f١٧٩٢x = 0.9f;
        this.f١٧٩٣y = 0;
        this.f١٧٩٤z = 4;
        this.A = 1;
        this.f١٧٨١B = 2.0f;
        this.C = -1;
        this.D = 200;
        this.E = -1;
        this.F = new a();
        I(context, attributeSet);
    }
}
