package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class MockView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f٢٢٣١a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f٢٢٣٢b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f٢٢٣٣c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٢٢٣٤d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٢٢٣٥e;

    /* renamed from: f, reason: collision with root package name */
    protected String f٢٢٣٦f;

    /* renamed from: g, reason: collision with root package name */
    private Rect f٢٢٣٧g;

    /* renamed from: h, reason: collision with root package name */
    private int f٢٢٣٨h;

    /* renamed from: i, reason: collision with root package name */
    private int f٢٢٣٩i;

    /* renamed from: j, reason: collision with root package name */
    private int f٢٢٤٠j;

    /* renamed from: k, reason: collision with root package name */
    private int f٢٢٤١k;

    public MockView(Context context) {
        super(context);
        this.f٢٢٣١a = new Paint();
        this.f٢٢٣٢b = new Paint();
        this.f٢٢٣٣c = new Paint();
        this.f٢٢٣٤d = true;
        this.f٢٢٣٥e = true;
        this.f٢٢٣٦f = null;
        this.f٢٢٣٧g = new Rect();
        this.f٢٢٣٨h = Color.argb(KotlinVersion.MAX_COMPONENT_VALUE, 0, 0, 0);
        this.f٢٢٣٩i = Color.argb(KotlinVersion.MAX_COMPONENT_VALUE, 200, 200, 200);
        this.f٢٢٤٠j = Color.argb(KotlinVersion.MAX_COMPONENT_VALUE, 50, 50, 50);
        this.f٢٢٤١k = 4;
        a(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MockView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.MockView_mock_label) {
                    this.f٢٢٣٦f = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MockView_mock_showDiagonals) {
                    this.f٢٢٣٤d = obtainStyledAttributes.getBoolean(index, this.f٢٢٣٤d);
                } else if (index == R.styleable.MockView_mock_diagonalsColor) {
                    this.f٢٢٣٨h = obtainStyledAttributes.getColor(index, this.f٢٢٣٨h);
                } else if (index == R.styleable.MockView_mock_labelBackgroundColor) {
                    this.f٢٢٤٠j = obtainStyledAttributes.getColor(index, this.f٢٢٤٠j);
                } else if (index == R.styleable.MockView_mock_labelColor) {
                    this.f٢٢٣٩i = obtainStyledAttributes.getColor(index, this.f٢٢٣٩i);
                } else if (index == R.styleable.MockView_mock_showLabel) {
                    this.f٢٢٣٥e = obtainStyledAttributes.getBoolean(index, this.f٢٢٣٥e);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f٢٢٣٦f == null) {
            try {
                this.f٢٢٣٦f = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.f٢٢٣١a.setColor(this.f٢٢٣٨h);
        this.f٢٢٣١a.setAntiAlias(true);
        this.f٢٢٣٢b.setColor(this.f٢٢٣٩i);
        this.f٢٢٣٢b.setAntiAlias(true);
        this.f٢٢٣٣c.setColor(this.f٢٢٤٠j);
        this.f٢٢٤١k = Math.round(this.f٢٢٤١k * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f٢٢٣٤d) {
            width--;
            height--;
            float f10 = width;
            float f11 = height;
            canvas.drawLine(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, f10, f11, this.f٢٢٣١a);
            canvas.drawLine(DownloadProgress.UNKNOWN_PROGRESS, f11, f10, DownloadProgress.UNKNOWN_PROGRESS, this.f٢٢٣١a);
            canvas.drawLine(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, f10, DownloadProgress.UNKNOWN_PROGRESS, this.f٢٢٣١a);
            canvas.drawLine(f10, DownloadProgress.UNKNOWN_PROGRESS, f10, f11, this.f٢٢٣١a);
            canvas.drawLine(f10, f11, DownloadProgress.UNKNOWN_PROGRESS, f11, this.f٢٢٣١a);
            canvas.drawLine(DownloadProgress.UNKNOWN_PROGRESS, f11, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, this.f٢٢٣١a);
        }
        String str = this.f٢٢٣٦f;
        if (str != null && this.f٢٢٣٥e) {
            this.f٢٢٣٢b.getTextBounds(str, 0, str.length(), this.f٢٢٣٧g);
            float width2 = (width - this.f٢٢٣٧g.width()) / 2.0f;
            float height2 = ((height - this.f٢٢٣٧g.height()) / 2.0f) + this.f٢٢٣٧g.height();
            this.f٢٢٣٧g.offset((int) width2, (int) height2);
            Rect rect = this.f٢٢٣٧g;
            int i10 = rect.left;
            int i11 = this.f٢٢٤١k;
            rect.set(i10 - i11, rect.top - i11, rect.right + i11, rect.bottom + i11);
            canvas.drawRect(this.f٢٢٣٧g, this.f٢٢٣٣c);
            canvas.drawText(this.f٢٢٣٦f, width2, height2, this.f٢٢٣٢b);
        }
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٢٢٣١a = new Paint();
        this.f٢٢٣٢b = new Paint();
        this.f٢٢٣٣c = new Paint();
        this.f٢٢٣٤d = true;
        this.f٢٢٣٥e = true;
        this.f٢٢٣٦f = null;
        this.f٢٢٣٧g = new Rect();
        this.f٢٢٣٨h = Color.argb(KotlinVersion.MAX_COMPONENT_VALUE, 0, 0, 0);
        this.f٢٢٣٩i = Color.argb(KotlinVersion.MAX_COMPONENT_VALUE, 200, 200, 200);
        this.f٢٢٤٠j = Color.argb(KotlinVersion.MAX_COMPONENT_VALUE, 50, 50, 50);
        this.f٢٢٤١k = 4;
        a(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٢٢٣١a = new Paint();
        this.f٢٢٣٢b = new Paint();
        this.f٢٢٣٣c = new Paint();
        this.f٢٢٣٤d = true;
        this.f٢٢٣٥e = true;
        this.f٢٢٣٦f = null;
        this.f٢٢٣٧g = new Rect();
        this.f٢٢٣٨h = Color.argb(KotlinVersion.MAX_COMPONENT_VALUE, 0, 0, 0);
        this.f٢٢٣٩i = Color.argb(KotlinVersion.MAX_COMPONENT_VALUE, 200, 200, 200);
        this.f٢٢٤٠j = Color.argb(KotlinVersion.MAX_COMPONENT_VALUE, 50, 50, 50);
        this.f٢٢٤١k = 4;
        a(context, attributeSet);
    }
}
