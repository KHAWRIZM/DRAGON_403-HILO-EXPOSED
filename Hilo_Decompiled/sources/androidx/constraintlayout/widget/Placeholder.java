package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import c2.e;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class Placeholder extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f٢٣٦٢a;

    /* renamed from: b, reason: collision with root package name */
    private View f٢٣٦٣b;

    /* renamed from: c, reason: collision with root package name */
    private int f٢٣٦٤c;

    public Placeholder(Context context) {
        super(context);
        this.f٢٣٦٢a = -1;
        this.f٢٣٦٣b = null;
        this.f٢٣٦٤c = 4;
        a(null);
    }

    private void a(AttributeSet attributeSet) {
        super.setVisibility(this.f٢٣٦٤c);
        this.f٢٣٦٢a = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_placeholder);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_placeholder_content) {
                    this.f٢٣٦٢a = obtainStyledAttributes.getResourceId(index, this.f٢٣٦٢a);
                } else if (index == R.styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) {
                    this.f٢٣٦٤c = obtainStyledAttributes.getInt(index, this.f٢٣٦٤c);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f٢٣٦٣b == null) {
            return;
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) this.f٢٣٦٣b.getLayoutParams();
        bVar2.f٢٣٤٢v0.n1(0);
        e.b C = bVar.f٢٣٤٢v0.C();
        e.b bVar3 = e.b.FIXED;
        if (C != bVar3) {
            bVar.f٢٣٤٢v0.o1(bVar2.f٢٣٤٢v0.Y());
        }
        if (bVar.f٢٣٤٢v0.V() != bVar3) {
            bVar.f٢٣٤٢v0.P0(bVar2.f٢٣٤٢v0.z());
        }
        bVar2.f٢٣٤٢v0.n1(8);
    }

    public void c(ConstraintLayout constraintLayout) {
        if (this.f٢٣٦٢a == -1 && !isInEditMode()) {
            setVisibility(this.f٢٣٦٤c);
        }
        View findViewById = constraintLayout.findViewById(this.f٢٣٦٢a);
        this.f٢٣٦٣b = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.b) findViewById.getLayoutParams()).f٢٣١٨j0 = true;
            this.f٢٣٦٣b.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f٢٣٦٣b;
    }

    public int getEmptyVisibility() {
        return this.f٢٣٦٤c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(KotlinVersion.MAX_COMPONENT_VALUE, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((height / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i10) {
        View findViewById;
        if (this.f٢٣٦٢a == i10) {
            return;
        }
        View view = this.f٢٣٦٣b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.b) this.f٢٣٦٣b.getLayoutParams()).f٢٣١٨j0 = false;
            this.f٢٣٦٣b = null;
        }
        this.f٢٣٦٢a = i10;
        if (i10 != -1 && (findViewById = ((View) getParent()).findViewById(i10)) != null) {
            findViewById.setVisibility(8);
        }
    }

    public void setEmptyVisibility(int i10) {
        this.f٢٣٦٤c = i10;
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٢٣٦٢a = -1;
        this.f٢٣٦٣b = null;
        this.f٢٣٦٤c = 4;
        a(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٢٣٦٢a = -1;
        this.f٢٣٦٣b = null;
        this.f٢٣٦٤c = 4;
        a(attributeSet);
    }
}
