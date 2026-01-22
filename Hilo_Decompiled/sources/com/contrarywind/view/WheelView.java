package com.contrarywind.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class WheelView extends View {
    private static final String[] U = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09"};
    private float A;

    /* renamed from: B, reason: collision with root package name */
    private float f٧٦١٠B;
    private float C;
    private float D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private float M;
    private long N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private float S;
    private boolean T;

    /* renamed from: a, reason: collision with root package name */
    private c f٧٦١١a;

    /* renamed from: b, reason: collision with root package name */
    private Context f٧٦١٢b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f٧٦١٣c;

    /* renamed from: d, reason: collision with root package name */
    private GestureDetector f٧٦١٤d;

    /* renamed from: e, reason: collision with root package name */
    private l5.b f٧٦١٥e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f٧٦١٦f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f٧٦١٧g;

    /* renamed from: h, reason: collision with root package name */
    private ScheduledExecutorService f٧٦١٨h;

    /* renamed from: i, reason: collision with root package name */
    private ScheduledFuture f٧٦١٩i;

    /* renamed from: j, reason: collision with root package name */
    private Paint f٧٦٢٠j;

    /* renamed from: k, reason: collision with root package name */
    private Paint f٧٦٢١k;

    /* renamed from: l, reason: collision with root package name */
    private Paint f٧٦٢٢l;

    /* renamed from: m, reason: collision with root package name */
    private k5.a f٧٦٢٣m;

    /* renamed from: n, reason: collision with root package name */
    private String f٧٦٢٤n;

    /* renamed from: o, reason: collision with root package name */
    private int f٧٦٢٥o;

    /* renamed from: p, reason: collision with root package name */
    private int f٧٦٢٦p;

    /* renamed from: q, reason: collision with root package name */
    private int f٧٦٢٧q;

    /* renamed from: r, reason: collision with root package name */
    private int f٧٦٢٨r;

    /* renamed from: s, reason: collision with root package name */
    private float f٧٦٢٩s;

    /* renamed from: t, reason: collision with root package name */
    private Typeface f٧٦٣٠t;

    /* renamed from: u, reason: collision with root package name */
    private int f٧٦٣١u;

    /* renamed from: v, reason: collision with root package name */
    private int f٧٦٣٢v;

    /* renamed from: w, reason: collision with root package name */
    private int f٧٦٣٣w;

    /* renamed from: x, reason: collision with root package name */
    private int f٧٦٣٤x;

    /* renamed from: y, reason: collision with root package name */
    private float f٧٦٣٥y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f٧٦٣٦z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WheelView.this.f٧٦١٥e.a(WheelView.this.getCurrentItem());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum b {
        CLICK,
        FLING,
        DAGGLE
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum c {
        FILL,
        WRAP,
        CIRCLE
    }

    public WheelView(Context context) {
        this(context, null);
    }

    private String c(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            return d(((Integer) obj).intValue());
        }
        return obj.toString();
    }

    private String d(int i10) {
        if (i10 >= 0 && i10 < 10) {
            return U[i10];
        }
        return String.valueOf(i10);
    }

    private int e(int i10) {
        if (i10 < 0) {
            return e(i10 + this.f٧٦٢٣m.a());
        }
        if (i10 > this.f٧٦٢٣m.a() - 1) {
            return e(i10 - this.f٧٦٢٣m.a());
        }
        return i10;
    }

    private void g(Context context) {
        this.f٧٦١٢b = context;
        this.f٧٦١٣c = new m5.b(this);
        GestureDetector gestureDetector = new GestureDetector(context, new l5.a(this));
        this.f٧٦١٤d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f٧٦٣٦z = true;
        this.D = DownloadProgress.UNKNOWN_PROGRESS;
        this.E = -1;
        h();
    }

    private void h() {
        Paint paint = new Paint();
        this.f٧٦٢٠j = paint;
        paint.setColor(this.f٧٦٣١u);
        this.f٧٦٢٠j.setAntiAlias(true);
        this.f٧٦٢٠j.setTypeface(this.f٧٦٣٠t);
        this.f٧٦٢٠j.setTextSize(this.f٧٦٢٥o);
        Paint paint2 = new Paint();
        this.f٧٦٢١k = paint2;
        paint2.setColor(this.f٧٦٣٢v);
        this.f٧٦٢١k.setAntiAlias(true);
        this.f٧٦٢١k.setTextScaleX(1.1f);
        this.f٧٦٢١k.setTypeface(this.f٧٦٣٠t);
        this.f٧٦٢١k.setTextSize(this.f٧٦٢٥o);
        Paint paint3 = new Paint();
        this.f٧٦٢٢l = paint3;
        paint3.setColor(this.f٧٦٣٣w);
        this.f٧٦٢٢l.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void k() {
        float f10 = this.f٧٦٣٥y;
        if (f10 < 1.0f) {
            this.f٧٦٣٥y = 1.0f;
        } else if (f10 > 4.0f) {
            this.f٧٦٣٥y = 4.0f;
        }
    }

    private void l() {
        Rect rect = new Rect();
        for (int i10 = 0; i10 < this.f٧٦٢٣m.a(); i10++) {
            String c10 = c(this.f٧٦٢٣m.getItem(i10));
            this.f٧٦٢١k.getTextBounds(c10, 0, c10.length(), rect);
            int width = rect.width();
            if (width > this.f٧٦٢٦p) {
                this.f٧٦٢٦p = width;
            }
        }
        this.f٧٦٢١k.getTextBounds("星期", 0, 2, rect);
        int height = rect.height() + 2;
        this.f٧٦٢٧q = height;
        this.f٧٦٢٩s = this.f٧٦٣٥y * height;
    }

    private void m(String str) {
        String str2;
        Rect rect = new Rect();
        this.f٧٦٢١k.getTextBounds(str, 0, str.length(), rect);
        int i10 = this.P;
        if (i10 != 3) {
            if (i10 != 5) {
                if (i10 == 17) {
                    if (!this.f٧٦١٦f && (str2 = this.f٧٦٢٤n) != null && !str2.equals("") && this.f٧٦١٧g) {
                        this.Q = (int) ((this.J - rect.width()) * 0.25d);
                        return;
                    } else {
                        this.Q = (int) ((this.J - rect.width()) * 0.5d);
                        return;
                    }
                }
                return;
            }
            this.Q = (this.J - rect.width()) - ((int) this.S);
            return;
        }
        this.Q = 0;
    }

    private void n(String str) {
        String str2;
        Rect rect = new Rect();
        this.f٧٦٢٠j.getTextBounds(str, 0, str.length(), rect);
        int i10 = this.P;
        if (i10 != 3) {
            if (i10 != 5) {
                if (i10 == 17) {
                    if (!this.f٧٦١٦f && (str2 = this.f٧٦٢٤n) != null && !str2.equals("") && this.f٧٦١٧g) {
                        this.R = (int) ((this.J - rect.width()) * 0.25d);
                        return;
                    } else {
                        this.R = (int) ((this.J - rect.width()) * 0.5d);
                        return;
                    }
                }
                return;
            }
            this.R = (this.J - rect.width()) - ((int) this.S);
            return;
        }
        this.R = 0;
    }

    private void p() {
        if (this.f٧٦٢٣m == null) {
            return;
        }
        l();
        int i10 = (int) (this.f٧٦٢٩s * (this.H - 1));
        this.I = (int) ((i10 * 2) / 3.141592653589793d);
        this.K = (int) (i10 / 3.141592653589793d);
        this.J = View.MeasureSpec.getSize(this.O);
        int i11 = this.I;
        float f10 = this.f٧٦٢٩s;
        this.A = (i11 - f10) / 2.0f;
        float f11 = (i11 + f10) / 2.0f;
        this.f٧٦١٠B = f11;
        this.C = (f11 - ((f10 - this.f٧٦٢٧q) / 2.0f)) - this.S;
        if (this.E == -1) {
            if (this.f٧٦٣٦z) {
                this.E = (this.f٧٦٢٣m.a() + 1) / 2;
            } else {
                this.E = 0;
            }
        }
        this.G = this.E;
    }

    private void q(String str) {
        Rect rect = new Rect();
        this.f٧٦٢١k.getTextBounds(str, 0, str.length(), rect);
        int i10 = this.f٧٦٢٥o;
        for (int width = rect.width(); width > this.J; width = rect.width()) {
            i10--;
            this.f٧٦٢١k.setTextSize(i10);
            this.f٧٦٢١k.getTextBounds(str, 0, str.length(), rect);
        }
        this.f٧٦٢٠j.setTextSize(i10);
    }

    private void s(float f10, float f11) {
        int i10;
        int i11;
        int i12 = this.f٧٦٢٨r;
        int i13 = -1;
        if (i12 > 0) {
            i10 = 1;
        } else if (i12 < 0) {
            i10 = -1;
        } else {
            i10 = 0;
        }
        Paint paint = this.f٧٦٢٠j;
        if (f11 <= DownloadProgress.UNKNOWN_PROGRESS) {
            i13 = 1;
        }
        paint.setTextSkewX(i10 * i13 * 0.5f * f10);
        if (this.T) {
            i11 = (int) (((90.0f - Math.abs(f11)) / 90.0f) * 255.0f);
        } else {
            i11 = KotlinVersion.MAX_COMPONENT_VALUE;
        }
        this.f٧٦٢٠j.setAlpha(i11);
    }

    public void b() {
        ScheduledFuture scheduledFuture = this.f٧٦١٩i;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f٧٦١٩i.cancel(true);
            this.f٧٦١٩i = null;
        }
    }

    public int f(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            i10 += (int) Math.ceil(r2[i11]);
        }
        return i10;
    }

    public final k5.a getAdapter() {
        return this.f٧٦٢٣m;
    }

    public final int getCurrentItem() {
        int i10;
        k5.a aVar = this.f٧٦٢٣m;
        if (aVar == null) {
            return 0;
        }
        if (this.f٧٦٣٦z && ((i10 = this.F) < 0 || i10 >= aVar.a())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.F) - this.f٧٦٢٣m.a()), this.f٧٦٢٣m.a() - 1));
        }
        return Math.max(0, Math.min(this.F, this.f٧٦٢٣m.a() - 1));
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.f٧٦١٣c;
    }

    public int getInitPosition() {
        return this.E;
    }

    public float getItemHeight() {
        return this.f٧٦٢٩s;
    }

    public int getItemsCount() {
        k5.a aVar = this.f٧٦٢٣m;
        if (aVar != null) {
            return aVar.a();
        }
        return 0;
    }

    public float getTotalScrollY() {
        return this.D;
    }

    public void i(boolean z10) {
        this.f٧٦١٧g = z10;
    }

    public boolean j() {
        return this.f٧٦٣٦z;
    }

    public final void o() {
        if (this.f٧٦١٥e != null) {
            postDelayed(new a(), 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f10;
        Object obj;
        float f11;
        String c10;
        int i10;
        float f12;
        if (this.f٧٦٢٣m == null) {
            return;
        }
        int min = Math.min(Math.max(0, this.E), this.f٧٦٢٣m.a() - 1);
        this.E = min;
        try {
            this.G = min + (((int) (this.D / this.f٧٦٢٩s)) % this.f٧٦٢٣m.a());
        } catch (ArithmeticException unused) {
            Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
        }
        if (!this.f٧٦٣٦z) {
            if (this.G < 0) {
                this.G = 0;
            }
            if (this.G > this.f٧٦٢٣m.a() - 1) {
                this.G = this.f٧٦٢٣m.a() - 1;
            }
        } else {
            if (this.G < 0) {
                this.G = this.f٧٦٢٣m.a() + this.G;
            }
            if (this.G > this.f٧٦٢٣m.a() - 1) {
                this.G -= this.f٧٦٢٣m.a();
            }
        }
        float f13 = this.D % this.f٧٦٢٩s;
        c cVar = this.f٧٦١١a;
        float f14 = 10.0f;
        if (cVar == c.WRAP) {
            if (TextUtils.isEmpty(this.f٧٦٢٤n)) {
                i10 = (this.J - this.f٧٦٢٦p) / 2;
            } else {
                i10 = (this.J - this.f٧٦٢٦p) / 4;
            }
            float f15 = i10 - 12;
            if (f15 <= DownloadProgress.UNKNOWN_PROGRESS) {
                f12 = 10.0f;
            } else {
                f12 = f15;
            }
            float f16 = this.J - f12;
            float f17 = this.A;
            float f18 = f12;
            canvas.drawLine(f18, f17, f16, f17, this.f٧٦٢٢l);
            float f19 = this.f٧٦١٠B;
            canvas.drawLine(f18, f19, f16, f19, this.f٧٦٢٢l);
        } else if (cVar == c.CIRCLE) {
            this.f٧٦٢٢l.setStyle(Paint.Style.STROKE);
            this.f٧٦٢٢l.setStrokeWidth(this.f٧٦٣٤x);
            if (TextUtils.isEmpty(this.f٧٦٢٤n)) {
                f10 = (this.J - this.f٧٦٢٦p) / 2.0f;
            } else {
                f10 = (this.J - this.f٧٦٢٦p) / 4.0f;
            }
            float f20 = f10 - 12.0f;
            if (f20 > DownloadProgress.UNKNOWN_PROGRESS) {
                f14 = f20;
            }
            canvas.drawCircle(this.J / 2.0f, this.I / 2.0f, Math.max((this.J - f14) - f14, this.f٧٦٢٩s) / 1.8f, this.f٧٦٢٢l);
        } else {
            float f21 = this.A;
            canvas.drawLine(DownloadProgress.UNKNOWN_PROGRESS, f21, this.J, f21, this.f٧٦٢٢l);
            float f22 = this.f٧٦١٠B;
            canvas.drawLine(DownloadProgress.UNKNOWN_PROGRESS, f22, this.J, f22, this.f٧٦٢٢l);
        }
        if (!TextUtils.isEmpty(this.f٧٦٢٤n) && this.f٧٦١٧g) {
            canvas.drawText(this.f٧٦٢٤n, (this.J - f(this.f٧٦٢١k, this.f٧٦٢٤n)) - this.S, this.C, this.f٧٦٢١k);
        }
        int i11 = 0;
        while (true) {
            int i12 = this.H;
            if (i11 < i12) {
                int i13 = this.G - ((i12 / 2) - i11);
                if (this.f٧٦٣٦z) {
                    obj = this.f٧٦٢٣m.getItem(e(i13));
                } else {
                    obj = "";
                    if (i13 >= 0 && i13 <= this.f٧٦٢٣m.a() - 1) {
                        obj = this.f٧٦٢٣m.getItem(i13);
                    }
                }
                canvas.save();
                double d10 = ((this.f٧٦٢٩s * i11) - f13) / this.K;
                float f23 = (float) (90.0d - ((d10 / 3.141592653589793d) * 180.0d));
                if (f23 > 90.0f || f23 < -90.0f) {
                    f11 = f13;
                    canvas.restore();
                } else {
                    if (!this.f٧٦١٧g && !TextUtils.isEmpty(this.f٧٦٢٤n) && !TextUtils.isEmpty(c(obj))) {
                        c10 = c(obj) + this.f٧٦٢٤n;
                    } else {
                        c10 = c(obj);
                    }
                    float pow = (float) Math.pow(Math.abs(f23) / 90.0f, 2.2d);
                    q(c10);
                    m(c10);
                    n(c10);
                    f11 = f13;
                    float cos = (float) ((this.K - (Math.cos(d10) * this.K)) - ((Math.sin(d10) * this.f٧٦٢٧q) / 2.0d));
                    canvas.translate(DownloadProgress.UNKNOWN_PROGRESS, cos);
                    float f24 = this.A;
                    if (cos <= f24 && this.f٧٦٢٧q + cos >= f24) {
                        canvas.save();
                        canvas.clipRect(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, this.J, this.A - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d10)) * 0.8f);
                        s(pow, f23);
                        canvas.drawText(c10, this.R, this.f٧٦٢٧q, this.f٧٦٢٠j);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(DownloadProgress.UNKNOWN_PROGRESS, this.A - cos, this.J, (int) this.f٧٦٢٩s);
                        canvas.scale(1.0f, ((float) Math.sin(d10)) * 1.0f);
                        canvas.drawText(c10, this.Q, this.f٧٦٢٧q - this.S, this.f٧٦٢١k);
                        canvas.restore();
                    } else {
                        float f25 = this.f٧٦١٠B;
                        if (cos <= f25 && this.f٧٦٢٧q + cos >= f25) {
                            canvas.save();
                            canvas.clipRect(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, this.J, this.f٧٦١٠B - cos);
                            canvas.scale(1.0f, ((float) Math.sin(d10)) * 1.0f);
                            canvas.drawText(c10, this.Q, this.f٧٦٢٧q - this.S, this.f٧٦٢١k);
                            canvas.restore();
                            canvas.save();
                            canvas.clipRect(DownloadProgress.UNKNOWN_PROGRESS, this.f٧٦١٠B - cos, this.J, (int) this.f٧٦٢٩s);
                            canvas.scale(1.0f, ((float) Math.sin(d10)) * 0.8f);
                            s(pow, f23);
                            canvas.drawText(c10, this.R, this.f٧٦٢٧q, this.f٧٦٢٠j);
                            canvas.restore();
                        } else {
                            if (cos >= f24) {
                                int i14 = this.f٧٦٢٧q;
                                if (i14 + cos <= f25) {
                                    canvas.drawText(c10, this.Q, i14 - this.S, this.f٧٦٢١k);
                                    this.F = this.G - ((this.H / 2) - i11);
                                }
                            }
                            canvas.save();
                            canvas.clipRect(0, 0, this.J, (int) this.f٧٦٢٩s);
                            canvas.scale(1.0f, ((float) Math.sin(d10)) * 0.8f);
                            s(pow, f23);
                            canvas.drawText(c10, this.R + (this.f٧٦٢٨r * pow), this.f٧٦٢٧q, this.f٧٦٢٠j);
                            canvas.restore();
                            canvas.restore();
                            this.f٧٦٢١k.setTextSize(this.f٧٦٢٥o);
                        }
                    }
                    canvas.restore();
                    this.f٧٦٢١k.setTextSize(this.f٧٦٢٥o);
                }
                i11++;
                f13 = f11;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        this.O = i10;
        p();
        setMeasuredDimension(this.J, this.I);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.f٧٦١٤d.onTouchEvent(motionEvent);
        float f10 = (-this.E) * this.f٧٦٢٩s;
        float a10 = ((this.f٧٦٢٣m.a() - 1) - this.E) * this.f٧٦٢٩s;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                if (!onTouchEvent) {
                    float y10 = motionEvent.getY();
                    int i10 = this.K;
                    double acos = Math.acos((i10 - y10) / i10) * this.K;
                    float f11 = this.f٧٦٢٩s;
                    this.L = (int) (((((int) ((acos + (f11 / 2.0f)) / f11)) - (this.H / 2)) * f11) - (((this.D % f11) + f11) % f11));
                    if (System.currentTimeMillis() - this.N > 120) {
                        t(b.DAGGLE);
                    } else {
                        t(b.CLICK);
                    }
                }
            } else {
                float rawY = this.M - motionEvent.getRawY();
                this.M = motionEvent.getRawY();
                float f12 = this.D + rawY;
                this.D = f12;
                if (!this.f٧٦٣٦z) {
                    float f13 = this.f٧٦٢٩s;
                    if ((f12 - (f13 * 0.25f) < f10 && rawY < DownloadProgress.UNKNOWN_PROGRESS) || ((f13 * 0.25f) + f12 > a10 && rawY > DownloadProgress.UNKNOWN_PROGRESS)) {
                        this.D = f12 - rawY;
                        return true;
                    }
                }
            }
        } else {
            this.N = System.currentTimeMillis();
            b();
            this.M = motionEvent.getRawY();
        }
        if (motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public final void r(float f10) {
        b();
        this.f٧٦١٩i = this.f٧٦١٨h.scheduleWithFixedDelay(new m5.a(this, f10), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public final void setAdapter(k5.a aVar) {
        this.f٧٦٢٣m = aVar;
        p();
        invalidate();
    }

    public void setAlphaGradient(boolean z10) {
        this.T = z10;
    }

    public final void setCurrentItem(int i10) {
        this.F = i10;
        this.E = i10;
        this.D = DownloadProgress.UNKNOWN_PROGRESS;
        invalidate();
    }

    public final void setCyclic(boolean z10) {
        this.f٧٦٣٦z = z10;
    }

    public void setDividerColor(int i10) {
        this.f٧٦٣٣w = i10;
        this.f٧٦٢٢l.setColor(i10);
    }

    public void setDividerType(c cVar) {
        this.f٧٦١١a = cVar;
    }

    public void setDividerWidth(int i10) {
        this.f٧٦٣٤x = i10;
        this.f٧٦٢٢l.setStrokeWidth(i10);
    }

    public void setGravity(int i10) {
        this.P = i10;
    }

    public void setIsOptions(boolean z10) {
        this.f٧٦١٦f = z10;
    }

    public void setItemsVisibleCount(int i10) {
        if (i10 % 2 == 0) {
            i10++;
        }
        this.H = i10 + 2;
    }

    public void setLabel(String str) {
        this.f٧٦٢٤n = str;
    }

    public void setLineSpacingMultiplier(float f10) {
        if (f10 != DownloadProgress.UNKNOWN_PROGRESS) {
            this.f٧٦٣٥y = f10;
            k();
        }
    }

    public final void setOnItemSelectedListener(l5.b bVar) {
        this.f٧٦١٥e = bVar;
    }

    public void setTextColorCenter(int i10) {
        this.f٧٦٣٢v = i10;
        this.f٧٦٢١k.setColor(i10);
    }

    public void setTextColorOut(int i10) {
        this.f٧٦٣١u = i10;
        this.f٧٦٢٠j.setColor(i10);
    }

    public final void setTextSize(float f10) {
        if (f10 > DownloadProgress.UNKNOWN_PROGRESS) {
            int i10 = (int) (this.f٧٦١٢b.getResources().getDisplayMetrics().density * f10);
            this.f٧٦٢٥o = i10;
            this.f٧٦٢٠j.setTextSize(i10);
            this.f٧٦٢١k.setTextSize(this.f٧٦٢٥o);
        }
    }

    public void setTextXOffset(int i10) {
        this.f٧٦٢٨r = i10;
        if (i10 != 0) {
            this.f٧٦٢١k.setTextScaleX(1.0f);
        }
    }

    public void setTotalScrollY(float f10) {
        this.D = f10;
    }

    public final void setTypeface(Typeface typeface) {
        this.f٧٦٣٠t = typeface;
        this.f٧٦٢٠j.setTypeface(typeface);
        this.f٧٦٢١k.setTypeface(this.f٧٦٣٠t);
    }

    public void t(b bVar) {
        b();
        if (bVar == b.FLING || bVar == b.DAGGLE) {
            float f10 = this.D;
            float f11 = this.f٧٦٢٩s;
            int i10 = (int) (((f10 % f11) + f11) % f11);
            this.L = i10;
            if (i10 > f11 / 2.0f) {
                this.L = (int) (f11 - i10);
            } else {
                this.L = -i10;
            }
        }
        this.f٧٦١٩i = this.f٧٦١٨h.scheduleWithFixedDelay(new m5.c(this, this.L), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٧٦١٦f = false;
        this.f٧٦١٧g = true;
        this.f٧٦١٨h = Executors.newSingleThreadScheduledExecutor();
        this.f٧٦٣٠t = Typeface.MONOSPACE;
        this.f٧٦٣٥y = 1.6f;
        this.H = 11;
        this.L = 0;
        this.M = DownloadProgress.UNKNOWN_PROGRESS;
        this.N = 0L;
        this.P = 17;
        this.Q = 0;
        this.R = 0;
        this.T = false;
        this.f٧٦٢٥o = getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        float f10 = getResources().getDisplayMetrics().density;
        if (f10 < 1.0f) {
            this.S = 2.4f;
        } else if (1.0f <= f10 && f10 < 2.0f) {
            this.S = 4.0f;
        } else if (2.0f <= f10 && f10 < 3.0f) {
            this.S = 6.0f;
        } else if (f10 >= 3.0f) {
            this.S = f10 * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.pickerview, 0, 0);
            this.P = obtainStyledAttributes.getInt(R.styleable.pickerview_wheelview_gravity, 17);
            this.f٧٦٣١u = obtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_textColorOut, -5723992);
            this.f٧٦٣٢v = obtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_textColorCenter, -14013910);
            this.f٧٦٣٣w = obtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_dividerColor, -2763307);
            this.f٧٦٣٤x = obtainStyledAttributes.getDimensionPixelSize(R.styleable.pickerview_wheelview_dividerWidth, 2);
            this.f٧٦٢٥o = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.pickerview_wheelview_textSize, this.f٧٦٢٥o);
            this.f٧٦٣٥y = obtainStyledAttributes.getFloat(R.styleable.pickerview_wheelview_lineSpacingMultiplier, this.f٧٦٣٥y);
            obtainStyledAttributes.recycle();
        }
        k();
        g(context);
    }
}
