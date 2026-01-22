package com.qiahao.nextvideo.room.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class TurnTableView extends RelativeLayout {
    private Context a;
    private int b;
    private Paint c;
    private Paint d;
    private Bitmap e;
    private Bitmap f;
    private int g;
    private int h;
    private float i;
    private List j;
    private float k;
    private int l;
    private int m;
    private int n;
    private int o;
    private final int p;
    private String[] q;
    private Integer[] r;
    private Integer[] s;
    private boolean t;
    private Integer u;
    private Integer v;
    private float w;
    private int x;
    private final Rect y;
    private final RectF z;

    public TurnTableView(Context context) {
        super(context);
        this.k = 0.0f;
        this.m = 1;
        this.n = 10;
        this.o = 75;
        this.p = HonorResultCode.AUDIO_PLAY_SERVICE_SUCCESS;
        this.t = false;
        this.y = new Rect();
        this.z = new RectF();
        a(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.a = context;
        setBackgroundColor(0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TurnTableView);
            this.m = obtainStyledAttributes.getInt(4, this.m);
            this.n = obtainStyledAttributes.getInt(10, 10);
            this.o = obtainStyledAttributes.getInt(8, 75);
            this.u = Integer.valueOf(obtainStyledAttributes.getResourceId(5, 0));
            this.v = Integer.valueOf(obtainStyledAttributes.getResourceId(1, 0));
            this.t = obtainStyledAttributes.getBoolean(3, false);
            if (this.u.intValue() != 0) {
                this.e = BitmapFactory.decodeResource(context.getResources(), this.u.intValue());
            }
            if (this.v.intValue() != 0) {
                this.f = BitmapFactory.decodeResource(context.getResources(), this.v.intValue());
            }
            this.w = obtainStyledAttributes.getDimension(12, 14.0f);
            this.x = obtainStyledAttributes.getColor(11, -1);
            this.i = (float) (360.0d / this.n);
            Paint paint = new Paint();
            this.d = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.d.setAntiAlias(true);
            this.d.setDither(true);
            this.d.setColor(this.x);
            this.d.setTextSize(this.w);
            int resourceId = obtainStyledAttributes.getResourceId(7, -1);
            if (resourceId != -1) {
                String[] stringArray = context.getResources().getStringArray(resourceId);
                this.s = new Integer[stringArray.length];
                for (int i = 0; i < stringArray.length; i++) {
                    try {
                        this.s[i] = Integer.valueOf(Color.parseColor(stringArray[i]));
                    } catch (Exception unused) {
                        throw new RuntimeException("颜色值有误");
                    }
                }
                int resourceId2 = obtainStyledAttributes.getResourceId(2, -1);
                if (resourceId2 != -1) {
                    String[] stringArray2 = context.getResources().getStringArray(resourceId2);
                    ArrayList arrayList = new ArrayList();
                    for (String str : stringArray2) {
                        arrayList.add(Integer.valueOf(context.getResources().getIdentifier(str, "mipmap", context.getPackageName())));
                    }
                    this.r = (Integer[]) arrayList.toArray(new Integer[arrayList.size()]);
                    this.j = new ArrayList();
                    for (int i2 = 0; i2 < this.n; i2++) {
                        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), this.r[i2].intValue());
                        int width = decodeResource.getWidth();
                        int height = decodeResource.getHeight();
                        Matrix matrix = new Matrix();
                        matrix.postScale(1.0f, 1.0f);
                        matrix.postRotate(this.i * i2);
                        this.j.add(Bitmap.createBitmap(decodeResource, 0, 0, width, height, matrix, true));
                    }
                }
                obtainStyledAttributes.recycle();
            } else {
                throw new RuntimeException("缺少扇形颜色资源");
            }
        }
        Paint paint2 = new Paint();
        this.c = paint2;
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        this.c.setAntiAlias(true);
        this.c.setDither(true);
    }

    public void b() {
        if (this.e == null && this.u.intValue() != 0) {
            this.e = BitmapFactory.decodeResource(this.a.getResources(), this.u.intValue());
        }
        if (this.d == null) {
            Paint paint = new Paint();
            this.d = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.d.setAntiAlias(true);
            this.d.setDither(true);
            this.d.setColor(this.x);
            this.d.setTextSize(this.w);
        }
        int i = this.n;
        if (i != 0) {
            this.i = (float) (360.0d / i);
        }
        if (this.o == 0) {
            this.o = 75;
        }
        this.k = 0.0f;
        this.l = 0;
        invalidate();
    }

    public float getAngle() {
        return this.i;
    }

    public Integer[] getColors() {
        return this.s;
    }

    public float getCurrAngle() {
        return this.k;
    }

    public Bitmap getHaloImage() {
        return this.f;
    }

    public Integer[] getIcons() {
        return this.r;
    }

    public int getLastPosition() {
        return this.l;
    }

    public int getMinTimes() {
        return this.m;
    }

    public String[] getNames() {
        return this.q;
    }

    public int getRadius() {
        return this.h;
    }

    public Integer getRingImgRes() {
        return this.u;
    }

    public int getSectorTimes() {
        return this.o;
    }

    public int getSum() {
        return this.n;
    }

    public int getTextColor() {
        return this.x;
    }

    public float getTextSize() {
        return this.w;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.z;
        int i = this.g;
        int i2 = this.h;
        rectF.set(i - i2, i - i2, i + i2, i + i2);
        float f = -90.0f;
        for (int i3 = 0; i3 < this.n; i3++) {
            Integer[] numArr = this.s;
            if (i3 < numArr.length) {
                this.c.setColor(numArr[i3].intValue());
            } else {
                int length = i3 % numArr.length;
                if (length < numArr.length) {
                    this.c.setColor(numArr[length].intValue());
                }
            }
            canvas.drawArc(this.z, f, this.i, true, this.c);
            f += this.i;
        }
        if (this.f != null) {
            Rect rect = this.y;
            int i4 = this.b;
            rect.set(0, 0, i4, i4);
            canvas.drawBitmap(this.f, (Rect) null, this.y, this.c);
        }
        if (this.e != null) {
            Rect rect2 = this.y;
            int i5 = this.b;
            rect2.set(0, 0, i5, i5);
            canvas.drawBitmap(this.e, (Rect) null, this.y, this.c);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(RoomEvent.ROOM_MIC_EMOJI, size);
            } else {
                size = RoomEvent.ROOM_MIC_EMOJI;
            }
        }
        this.b = size;
        this.g = size / 2;
        this.h = size / 2;
        setMeasuredDimension(size, size);
    }

    public void setAngle(float f) {
        this.i = f;
    }

    public void setColors(Integer[] numArr) {
        this.s = numArr;
    }

    public void setCurrAngle(float f) {
        this.k = f;
    }

    public void setHaloImage(Bitmap bitmap) {
        this.f = bitmap;
    }

    public void setIcons(Integer[] numArr) {
        this.r = numArr;
    }

    public void setLastPosition(int i) {
        this.l = i;
    }

    public void setMinTimes(int i) {
        this.m = i;
    }

    public void setNames(String[] strArr) {
        this.q = strArr;
    }

    public void setRadius(int i) {
        this.h = i;
    }

    public void setRingImgRes(Integer num) {
        this.u = num;
    }

    public void setSectorTimes(int i) {
        this.o = i;
    }

    public void setSum(int i) {
        this.n = i;
    }

    public void setTextColor(int i) {
        this.x = i;
    }

    public void setTextSize(float f) {
        this.w = f;
    }

    public TurnTableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = 0.0f;
        this.m = 1;
        this.n = 10;
        this.o = 75;
        this.p = HonorResultCode.AUDIO_PLAY_SERVICE_SUCCESS;
        this.t = false;
        this.y = new Rect();
        this.z = new RectF();
        a(context, attributeSet);
    }

    public TurnTableView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = 0.0f;
        this.m = 1;
        this.n = 10;
        this.o = 75;
        this.p = HonorResultCode.AUDIO_PLAY_SERVICE_SUCCESS;
        this.t = false;
        this.y = new Rect();
        this.z = new RectF();
        a(context, attributeSet);
    }
}
