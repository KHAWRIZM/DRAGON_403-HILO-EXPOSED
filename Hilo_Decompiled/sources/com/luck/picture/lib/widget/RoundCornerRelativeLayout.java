package com.luck.picture.lib.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.luck.picture.lib.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class RoundCornerRelativeLayout extends RelativeLayout {
    private final float cornerSize;
    private final boolean isBottomNormal;
    private final boolean isTopNormal;
    private final RectF mRect;
    private final Path path;

    public RoundCornerRelativeLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.path);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.path.reset();
        RectF rectF = this.mRect;
        rectF.right = i10;
        rectF.bottom = i11;
        boolean z10 = this.isTopNormal;
        if (!z10 && !this.isBottomNormal) {
            Path path = this.path;
            float f10 = this.cornerSize;
            path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
            return;
        }
        if (z10) {
            float f11 = this.cornerSize;
            this.path.addRoundRect(rectF, new float[]{DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, f11, f11, f11, f11}, Path.Direction.CW);
        }
        if (this.isBottomNormal) {
            float f12 = this.cornerSize;
            this.path.addRoundRect(this.mRect, new float[]{f12, f12, f12, f12, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS}, Path.Direction.CW);
        }
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mRect = new RectF();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PictureRoundCornerRelativeLayout, i10, 0);
        this.cornerSize = obtainStyledAttributes.getDimension(R.styleable.PictureRoundCornerRelativeLayout_psCorners, DownloadProgress.UNKNOWN_PROGRESS);
        this.isTopNormal = obtainStyledAttributes.getBoolean(R.styleable.PictureRoundCornerRelativeLayout_psTopNormal, false);
        this.isBottomNormal = obtainStyledAttributes.getBoolean(R.styleable.PictureRoundCornerRelativeLayout_psBottomNormal, false);
        obtainStyledAttributes.recycle();
        this.path = new Path();
    }
}
