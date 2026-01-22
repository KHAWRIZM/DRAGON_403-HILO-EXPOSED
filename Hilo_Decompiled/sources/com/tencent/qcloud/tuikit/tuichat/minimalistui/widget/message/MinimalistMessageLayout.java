package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MinimalistMessageLayout extends RelativeLayout {
    private boolean isStart;
    private View msgArea;
    private Rect msgAreaRect;
    private Paint paint;
    private View quoteArea;
    private Path quotePath;
    private Rect quoteRect;
    private View replyArea;
    private Path replyPath;
    private Rect replyRect;
    private float strokeWidth;
    private View translationArea;
    private Path translationPath;
    private Rect translationRect;

    public MinimalistMessageLayout(Context context) {
        super(context);
        this.isStart = false;
        init();
    }

    private void drawLine(Canvas canvas) {
        float f;
        int i;
        int i2;
        int i3;
        canvas.drawColor(16777215);
        if (this.msgArea.getVisibility() == 0) {
            this.msgAreaRect = getChildRectInParent(this.msgArea);
            if (this.isStart) {
                this.paint.setColor(getResources().getColor(R.color.chat_minimalist_left_message_bubble_color));
                f = this.msgAreaRect.left + (this.strokeWidth / 2.0f);
            } else {
                this.paint.setColor(getResources().getColor(R.color.chat_minimalist_right_message_bubble_color));
                f = this.msgAreaRect.right - (this.strokeWidth / 2.0f);
            }
            Rect rect = this.msgAreaRect;
            float height = rect.top + ((rect.height() * 1.0f) / 2.0f);
            if (this.translationArea.getVisibility() == 0) {
                Rect childRectInParent = getChildRectInParent(this.translationArea);
                this.translationRect = childRectInParent;
                if (this.isStart) {
                    i3 = childRectInParent.left;
                } else {
                    i3 = childRectInParent.right;
                }
                float f2 = i3;
                float height2 = childRectInParent.top + ((childRectInParent.height() * 1.0f) / 2.0f);
                int abs = (int) Math.abs(f2 - f);
                this.translationPath.reset();
                this.translationPath.moveTo(f, height);
                float f3 = height2 - abs;
                this.translationPath.quadTo(f, f3, f, f3);
                this.translationPath.quadTo(f, height2, f2, height2);
                canvas.drawPath(this.translationPath, this.paint);
            }
            if (this.quoteArea.getVisibility() == 0) {
                Rect childRectInParent2 = getChildRectInParent(this.quoteArea);
                this.quoteRect = childRectInParent2;
                if (this.isStart) {
                    i2 = childRectInParent2.left;
                } else {
                    i2 = childRectInParent2.right;
                }
                float f4 = i2;
                float height3 = childRectInParent2.top + ((childRectInParent2.height() * 1.0f) / 2.0f);
                int abs2 = (int) Math.abs(f4 - f);
                this.quotePath.reset();
                this.quotePath.moveTo(f, height);
                float f5 = height3 - abs2;
                this.quotePath.quadTo(f, f5, f, f5);
                this.quotePath.quadTo(f, height3, f4, height3);
                canvas.drawPath(this.quotePath, this.paint);
            }
            if (this.replyArea.getVisibility() == 0) {
                Rect childRectInParent3 = getChildRectInParent(this.replyArea);
                this.replyRect = childRectInParent3;
                if (this.isStart) {
                    i = childRectInParent3.left;
                } else {
                    i = childRectInParent3.right;
                }
                float f6 = i;
                float height4 = childRectInParent3.top + ((childRectInParent3.height() * 1.0f) / 2.0f);
                int abs3 = (int) Math.abs(f6 - f);
                this.replyPath.reset();
                this.replyPath.moveTo(f, height);
                float f7 = height4 - abs3;
                this.replyPath.quadTo(f, f7, f, f7);
                this.replyPath.quadTo(f, height4, f6, height4);
                canvas.drawPath(this.replyPath, this.paint);
            }
        }
    }

    private Rect getChildRectInParent(View view) {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        Rect rect = new Rect();
        int[] iArr2 = new int[2];
        view.getLocationInWindow(iArr2);
        int i = iArr2[0] - iArr[0];
        int i2 = iArr2[1] - iArr[1];
        rect.set(i, i2, view.getWidth() + i, view.getHeight() + i2);
        return rect;
    }

    private void init() {
        setWillNotDraw(false);
        this.quotePath = new Path();
        this.translationPath = new Path();
        this.replyPath = new Path();
        this.msgAreaRect = new Rect();
        this.translationRect = new Rect();
        this.quoteRect = new Rect();
        this.replyRect = new Rect();
        this.paint = new Paint();
        float dimension = getResources().getDimension(R.dimen.chat_minimalist_message_quato_line_width);
        this.strokeWidth = dimension;
        this.paint.setStrokeWidth(dimension);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.msgArea = findViewById(R.id.msg_area);
        this.translationArea = findViewById(R.id.translate_content_fl);
        this.quoteArea = findViewById(R.id.quote_content_fl);
        this.replyArea = findViewById(R.id.msg_reply_preview);
        drawLine(canvas);
    }

    public void setIsStart(boolean z) {
        this.isStart = z;
    }

    public MinimalistMessageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isStart = false;
        init();
    }

    public MinimalistMessageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isStart = false;
        init();
    }

    @RequiresApi(api = 21)
    public MinimalistMessageLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.isStart = false;
        init();
    }
}
