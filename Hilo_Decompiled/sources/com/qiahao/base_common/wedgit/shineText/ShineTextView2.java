package com.qiahao.base_common.wedgit.shineText;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class ShineTextView2 extends AppCompatTextView {

    /* renamed from: a, reason: collision with root package name */
    private LinearGradient f١٢٦٧٨a;

    /* renamed from: b, reason: collision with root package name */
    private Matrix f١٢٦٧٩b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f١٢٦٨٠c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٢٦٨١d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٢٦٨٢e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٢٦٨٣f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٢٦٨٤g;

    public ShineTextView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٢٦٨١d = 0;
        this.f١٢٦٨٢e = 0;
        this.f١٢٦٨٣f = 0;
        this.f١٢٦٨٤g = 0;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Matrix matrix = this.f١٢٦٧٩b;
        if (matrix != null) {
            int i10 = this.f١٢٦٨٣f;
            int i11 = this.f١٢٦٨١d;
            int i12 = i10 + (i11 / 10);
            this.f١٢٦٨٣f = i12;
            int i13 = this.f١٢٦٨٤g;
            int i14 = this.f١٢٦٨٢e;
            int i15 = i13 + (i14 / 10);
            this.f١٢٦٨٤g = i15;
            if (i12 > i11 * 1.5d || i15 > i14 * 1.5d) {
                this.f١٢٦٨٣f = -i11;
                this.f١٢٦٨٤g = -i14;
            }
            matrix.setTranslate(this.f١٢٦٨٣f, DownloadProgress.UNKNOWN_PROGRESS);
            this.f١٢٦٧٨a.setLocalMatrix(this.f١٢٦٧٩b);
            postInvalidateDelayed(100L);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (this.f١٢٦٨١d == 0 || this.f١٢٦٨٢e == 0) {
            this.f١٢٦٨١d = getMeasuredWidth();
            this.f١٢٦٨٢e = getMeasuredHeight();
            LogUtil.INSTANCE.e("eTag", "字数" + getText().length(), false);
            if (this.f١٢٦٨١d > 0 || this.f١٢٦٨٢e > 0) {
                this.f١٢٦٨٠c = getPaint();
                LinearGradient linearGradient = new LinearGradient(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, this.f١٢٦٨١d / 8, DownloadProgress.UNKNOWN_PROGRESS, new int[]{-1291862206, -16574, -1291862206}, (float[]) null, Shader.TileMode.CLAMP);
                this.f١٢٦٧٨a = linearGradient;
                this.f١٢٦٨٠c.setShader(linearGradient);
                this.f١٢٦٧٩b = new Matrix();
            }
        }
    }
}
