package com.qiahao.nextvideo.room.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class PortraitAnimationView extends View {
    private int a;
    private Paint b;
    private float c;
    private float d;
    private float e;
    private int f;
    private final int g;
    private int h;
    private int i;
    private int j;
    int k;
    private final List l;
    private final List m;
    private boolean n;
    private int o;

    public PortraitAnimationView(Context context) {
        super(context);
        this.a = 120;
        this.e = 5.0f;
        this.f = 2;
        this.g = 255;
        this.h = 80;
        this.i = 33;
        this.j = HonorResultCode.ADVANCED_RECORD_SUCCESS;
        this.k = 5;
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = false;
        this.o = 5;
        c(context, null);
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (this.n) {
            this.m.add(255);
            this.l.add(Float.valueOf(0.0f));
        }
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setAlpha(255);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PortraitAnimationView);
            int i = obtainStyledAttributes.getInt(5, this.a);
            Dimens dimens = Dimens.INSTANCE;
            this.a = dimens.dpToPx(i);
            this.h = dimens.dpToPx(obtainStyledAttributes.getInt(4, this.h));
            obtainStyledAttributes.getColor(0, androidx.core.content.a.getColor(context, 2131101214));
            int color = obtainStyledAttributes.getColor(6, androidx.core.content.a.getColor(context, 2131101214));
            this.e = obtainStyledAttributes.getFloat(2, 5.0f);
            this.i = obtainStyledAttributes.getInt(1, 35);
            this.j = obtainStyledAttributes.getInt(3, HonorResultCode.ADVANCED_RECORD_SUCCESS);
            obtainStyledAttributes.recycle();
            this.b.setColor(color);
        }
        int i2 = this.j;
        int i3 = this.i;
        this.f = (int) ((255 / (i2 / i3)) + 0.5f);
        this.e = (this.h - this.a) / (i2 / i3);
    }

    public void a() {
        this.n = false;
    }

    public void b() {
        this.o = 0;
        this.n = false;
        this.m.clear();
        this.l.clear();
        setVisibility(8);
    }

    public boolean d() {
        return this.n;
    }

    public void e() {
        this.o = 5;
        if (getVisibility() == 8) {
            setVisibility(0);
        }
        if (!this.n) {
            if (this.m.size() == 0) {
                this.m.add(255);
                this.l.add(Float.valueOf(0.0f));
            }
            this.n = true;
            postInvalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.o <= 0) {
            b();
            return;
        }
        for (int i = 0; i < this.l.size(); i++) {
            int intValue = ((Integer) this.m.get(i)).intValue();
            this.b.setAlpha(intValue);
            float floatValue = ((Float) this.l.get(i)).floatValue();
            canvas.drawCircle(this.c, this.d, this.a + floatValue, this.b);
            if (intValue > 0 && floatValue < this.h) {
                this.m.set(i, Integer.valueOf(intValue - this.f));
                this.l.set(i, Float.valueOf(floatValue + this.e));
            }
        }
        if (this.n && !this.m.isEmpty()) {
            if (((Integer) this.m.get(r9.size() - 1)).intValue() <= 180 && this.m.size() < this.k) {
                this.l.add(Float.valueOf(0.0f));
                this.m.add(255);
            }
        }
        if (this.l.size() >= this.k || (!this.n && !this.l.isEmpty())) {
            this.m.remove(0);
            this.l.remove(0);
            if (this.l.isEmpty()) {
                postInvalidateDelayed(this.i);
            }
            this.o--;
        }
        if (this.l.size() > 0) {
            postInvalidateDelayed(this.i);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c = i / 2;
        this.d = i2 / 2;
    }

    public void setColor(int i) {
        this.b.setColor(i);
        if (getVisibility() == 0) {
            postInvalidate();
        }
    }

    public void setMaxRadius(int i) {
        this.h = i;
        this.e = i / (this.j / this.i);
    }

    public void setRadius(int i) {
        this.a = i;
    }

    public void setRingCount(int i) {
        this.o = i;
    }

    public PortraitAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 120;
        this.e = 5.0f;
        this.f = 2;
        this.g = 255;
        this.h = 80;
        this.i = 33;
        this.j = HonorResultCode.ADVANCED_RECORD_SUCCESS;
        this.k = 5;
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = false;
        this.o = 5;
        c(context, attributeSet);
    }

    public PortraitAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 120;
        this.e = 5.0f;
        this.f = 2;
        this.g = 255;
        this.h = 80;
        this.i = 33;
        this.j = HonorResultCode.ADVANCED_RECORD_SUCCESS;
        this.k = 5;
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = false;
        this.o = 5;
        c(context, attributeSet);
    }
}
