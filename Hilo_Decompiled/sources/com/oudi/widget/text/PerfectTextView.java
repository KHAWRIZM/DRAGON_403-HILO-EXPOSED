package com.oudi.widget.text;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatTextView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import l2.q;

@RequiresApi(api = 3)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class PerfectTextView extends AppCompatTextView {
    private ClickScope clickScope;
    private CharSequence defaultHint;
    private CharSequence defaultText;
    private ClickScope doubleClickScope;
    private int drawableBottomHeight;
    private int drawableBottomPadding;
    private int drawableBottomWidth;
    private int drawableEndHeight;
    private int drawableEndPadding;
    private int drawableEndWidth;
    private int drawableLeftHeight;
    private int drawableLeftPadding;
    private int drawableLeftWidth;
    private int drawableRightHeight;
    private int drawableRightPadding;
    private int drawableRightWidth;
    private int drawableStartHeight;
    private int drawableStartPadding;
    private int drawableStartWidth;
    private int drawableTopHeight;
    private int drawableTopPadding;
    private int drawableTopWidth;
    private final GestureDetector gestureDetector;
    private boolean isDrawableBottomSelected;
    private boolean isDrawableLeftSelected;
    private boolean isDrawableRightSelected;
    private boolean isDrawableTopSelected;
    private final boolean isInitSuper;
    private final boolean isRtl;
    private boolean isUpdateDefaultText;
    private ClickScope longClickScope;
    private View.OnClickListener onClickListener;
    private View.OnClickListener onDoubleClickListener;
    private View.OnClickListener onDrawableBottomClickListener;
    private View.OnClickListener onDrawableBottomDoubleClickListener;
    private View.OnLongClickListener onDrawableBottomLongClickListener;
    private View.OnClickListener onDrawableEndClickListener;
    private View.OnClickListener onDrawableEndDoubleClickListener;
    private View.OnLongClickListener onDrawableEndLongClickListener;
    private View.OnClickListener onDrawableLeftClickListener;
    private View.OnClickListener onDrawableLeftDoubleClickListener;
    private View.OnLongClickListener onDrawableLeftLongClickListener;
    private View.OnClickListener onDrawableRightClickListener;
    private View.OnClickListener onDrawableRightDoubleClickListener;
    private View.OnLongClickListener onDrawableRightLongClickListener;
    private View.OnClickListener onDrawableStartClickListener;
    private View.OnClickListener onDrawableStartDoubleClickListener;
    private View.OnLongClickListener onDrawableStartLongClickListener;
    private View.OnClickListener onDrawableTopClickListener;
    private View.OnClickListener onDrawableTopDoubleClickListener;
    private View.OnLongClickListener onDrawableTopLongClickListener;
    private View.OnLongClickListener onLongClickListener;
    private View.OnTouchListener onTouchListener;
    private CharSequence selectedHint;
    private CharSequence selectedText;
    private Drawable textBackground;
    private TextBackgroundScope textBackgroundScope;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum ClickScope {
        textScope,
        allScope
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum ClickType {
        Click,
        DoubleClick,
        LongClick
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum TextBackgroundScope {
        wrappedText,
        fitDrawablePadding
    }

    @RequiresApi(api = 17)
    public PerfectTextView(Context context) {
        this(context, null);
    }

    private int getDrawablePadding(int i10) {
        if (getCompoundDrawables()[i10] != null) {
            return getDrawablePaddings()[i10];
        }
        return 0;
    }

    private int[] getDrawablePaddings() {
        int i10 = this.drawableLeftPadding;
        int i11 = this.drawableRightPadding;
        int[] iArr = {i10, this.drawableTopPadding, i11, this.drawableBottomPadding};
        if (this.isRtl) {
            int i12 = this.drawableEndPadding;
            if (i12 != 0) {
                i10 = i12;
            }
            iArr[0] = i10;
            int i13 = this.drawableStartPadding;
            if (i13 != 0) {
                i11 = i13;
            }
            iArr[2] = i11;
        } else {
            int i14 = this.drawableStartPadding;
            if (i14 != 0) {
                i10 = i14;
            }
            iArr[0] = i10;
            int i15 = this.drawableEndPadding;
            if (i15 != 0) {
                i11 = i15;
            }
            iArr[2] = i11;
        }
        return iArr;
    }

    private void getLineLeftRight(Rect rect) {
        Layout layout = getLayout();
        int lineCount = layout.getLineCount();
        float width = getWidth();
        float height = getHeight();
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        float f11 = DownloadProgress.UNKNOWN_PROGRESS;
        for (int i10 = 0; i10 < lineCount; i10++) {
            float lineLeft = layout.getLineLeft(i10);
            if (lineLeft < width) {
                width = lineLeft;
            }
            float lineRight = layout.getLineRight(i10);
            if (lineRight > f11) {
                f11 = lineRight;
            }
            float lineTop = layout.getLineTop(i10);
            if (lineTop < height) {
                height = lineTop;
            }
            float lineBottom = layout.getLineBottom(i10);
            if (lineBottom > f10) {
                f10 = lineBottom;
            }
        }
        rect.left = getCompoundPaddingLeft() + ((int) width);
        rect.right = getCompoundPaddingLeft() + ((int) f11);
        rect.top = getCompoundPaddingTop() + ((int) height);
        rect.bottom = getCompoundPaddingTop() + ((int) f10);
    }

    private Rect getTextBound() {
        Rect rect = new Rect();
        if (this.textBackgroundScope != TextBackgroundScope.fitDrawablePadding && !TextUtils.isEmpty(getText())) {
            Layout layout = getLayout();
            Drawable[] compoundDrawables = getCompoundDrawables();
            int i10 = 0;
            Drawable drawable = compoundDrawables[0];
            Drawable drawable2 = compoundDrawables[2];
            if (drawable != null && drawable2 != null) {
                if (drawable.getBounds().height() > layout.getHeight() || drawable2.getBounds().height() > layout.getHeight()) {
                    i10 = (Math.max(drawable.getBounds().height(), drawable2.getBounds().height()) - layout.getHeight()) / 2;
                }
            } else if (drawable != null) {
                if (drawable.getBounds().height() > layout.getHeight()) {
                    i10 = (drawable.getBounds().height() - layout.getHeight()) / 2;
                }
            } else if (drawable2 != null && drawable2.getBounds().height() > layout.getHeight()) {
                i10 = (drawable2.getBounds().height() - layout.getHeight()) / 2;
            }
            getLineLeftRight(rect);
            rect.top += i10;
            rect.bottom += i10;
        } else {
            rect.left = getCompoundPaddingLeft();
            rect.top = getCompoundPaddingTop();
            rect.right = getWidth() - getCompoundPaddingRight();
            rect.bottom = getHeight() - getCompoundPaddingBottom();
        }
        return rect;
    }

    @RequiresApi(api = 17)
    private void initCompoundDrawables() {
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable = compoundDrawables[0];
        Drawable drawable2 = compoundDrawables[1];
        Drawable drawable3 = compoundDrawables[2];
        Drawable drawable4 = compoundDrawables[3];
        Drawable drawable5 = compoundDrawablesRelative[0];
        Drawable drawable6 = compoundDrawablesRelative[2];
        if (this.isRtl) {
            if (drawable5 != null) {
                drawable3 = drawable5;
            }
            if (drawable6 != null) {
                drawable = drawable6;
            }
            setCompoundDrawablesRelative(drawable3, drawable2, drawable, drawable4);
            return;
        }
        if (drawable5 != null) {
            drawable = drawable5;
        }
        if (drawable6 != null) {
            drawable3 = drawable6;
        }
        setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onSpanTouchEvent(Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 1 && action != 0) {
            return false;
        }
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        int totalPaddingLeft = x10 - getTotalPaddingLeft();
        int totalPaddingTop = y10 - getTotalPaddingTop();
        int scrollX = getScrollX() + totalPaddingLeft;
        int scrollY = getScrollY() + totalPaddingTop;
        Layout layout = getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        if (((ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class)).length == 0) {
            return false;
        }
        return true;
    }

    private void setDrawableWidthHeight(Drawable drawable, int i10, int i11) {
        if (drawable != null) {
            if (i10 == 0) {
                i10 = drawable.getIntrinsicWidth();
            }
            if (i11 == 0) {
                i11 = drawable.getIntrinsicHeight();
            }
            drawable.setBounds(0, 0, i10, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e0  */
    @RequiresApi(api = 17)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setPressed(boolean z10, MotionEvent motionEvent) {
        boolean z11;
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable = compoundDrawables[1];
        Drawable drawable2 = compoundDrawables[3];
        Drawable drawable3 = compoundDrawables[0];
        Drawable drawable4 = compoundDrawables[2];
        if (drawable3 != null) {
            int paddingLeft = getPaddingLeft();
            int width = drawable3.getBounds().width() + paddingLeft;
            int compoundPaddingTop = getCompoundPaddingTop() + (((getHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom()) / 2);
            int height = compoundPaddingTop - (drawable3.getBounds().height() / 2);
            int height2 = (drawable3.getBounds().height() / 2) + compoundPaddingTop;
            if (motionEvent.getX() >= paddingLeft && motionEvent.getX() <= width && motionEvent.getY() >= height && motionEvent.getY() <= height2) {
                if (compoundDrawablesRelative[0] == drawable3) {
                    if (this.onDrawableStartClickListener != null || this.onDrawableLeftClickListener != null) {
                        setPressed(drawable3, z10);
                    }
                } else if (this.onDrawableEndClickListener != null || this.onDrawableLeftClickListener != null) {
                    setPressed(drawable3, z10);
                }
                z11 = true;
                if (drawable != null) {
                    int compoundPaddingLeft = getCompoundPaddingLeft() + (((getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight()) / 2);
                    int width2 = compoundPaddingLeft - (drawable.getBounds().width() / 2);
                    int width3 = (drawable.getBounds().width() / 2) + compoundPaddingLeft;
                    int paddingTop = getPaddingTop();
                    int height3 = drawable.getBounds().height() + paddingTop;
                    if (motionEvent.getX() >= width2 && motionEvent.getX() <= width3 && motionEvent.getY() >= paddingTop && motionEvent.getY() <= height3) {
                        if (this.onDrawableTopClickListener != null) {
                            setPressed(drawable, z10);
                        }
                        z11 = true;
                    }
                }
                if (drawable4 != null) {
                    int width4 = getWidth() - getPaddingRight();
                    int width5 = width4 - drawable4.getBounds().width();
                    int compoundPaddingTop2 = getCompoundPaddingTop() + (((getHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom()) / 2);
                    int height4 = compoundPaddingTop2 - (drawable4.getBounds().height() / 2);
                    int height5 = (drawable4.getBounds().height() / 2) + compoundPaddingTop2;
                    if (motionEvent.getX() >= width5 && motionEvent.getX() <= width4 && motionEvent.getY() >= height4 && motionEvent.getY() <= height5) {
                        if (compoundDrawablesRelative[2] == drawable4) {
                            if (this.onDrawableEndClickListener != null || this.onDrawableRightClickListener != null) {
                                setPressed(drawable4, z10);
                            }
                        } else if (this.onDrawableStartClickListener != null || this.onDrawableRightClickListener != null) {
                            setPressed(drawable4, z10);
                        }
                        z11 = true;
                    }
                }
                if (drawable2 != null) {
                    int height6 = getHeight() - getPaddingBottom();
                    int height7 = height6 - drawable2.getBounds().height();
                    int compoundPaddingLeft2 = getCompoundPaddingLeft() + (((getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight()) / 2);
                    int width6 = compoundPaddingLeft2 - (drawable2.getBounds().width() / 2);
                    int width7 = (drawable2.getBounds().width() / 2) + compoundPaddingLeft2;
                    if (motionEvent.getX() >= width6 && motionEvent.getX() <= width7 && motionEvent.getY() >= height7 && motionEvent.getY() <= height6) {
                        if (this.onDrawableBottomClickListener != null) {
                            setPressed(drawable2, z10);
                        }
                        z11 = true;
                    }
                }
                if (!z10) {
                    setPressed(drawable3, false);
                    setPressed(drawable, false);
                    setPressed(drawable4, false);
                    setPressed(drawable2, false);
                }
                int compoundPaddingLeft3 = getCompoundPaddingLeft();
                int compoundPaddingTop3 = getCompoundPaddingTop();
                int width8 = getWidth() - getCompoundPaddingRight();
                int height8 = getHeight() - getCompoundPaddingBottom();
                if (!z11 || this.onClickListener == null) {
                }
                ClickScope clickScope = this.clickScope;
                if (clickScope == ClickScope.allScope || (clickScope == ClickScope.textScope && motionEvent.getX() >= compoundPaddingLeft3 && motionEvent.getX() <= width8 && motionEvent.getY() >= compoundPaddingTop3 && motionEvent.getY() <= height8)) {
                    setPressed(true);
                    return;
                }
                return;
            }
        }
        z11 = false;
        if (drawable != null) {
        }
        if (drawable4 != null) {
        }
        if (drawable2 != null) {
        }
        if (!z10) {
        }
        int compoundPaddingLeft32 = getCompoundPaddingLeft();
        int compoundPaddingTop32 = getCompoundPaddingTop();
        int width82 = getWidth() - getCompoundPaddingRight();
        int height82 = getHeight() - getCompoundPaddingBottom();
        if (z11) {
        }
    }

    private void setSelectText() {
        this.isUpdateDefaultText = false;
        if (isSelected()) {
            if (!TextUtils.isEmpty(this.selectedText)) {
                setText(this.selectedText);
            }
            if (!TextUtils.isEmpty(this.selectedHint)) {
                setHint(this.selectedHint);
                return;
            }
            return;
        }
        setText(this.defaultText);
        setHint(this.defaultHint);
    }

    private void setSelected(Drawable drawable, boolean z10) {
        int[] iArr;
        if (drawable != null) {
            int[] state = drawable.getState();
            int i10 = 0;
            if (state != null) {
                HashSet hashSet = new HashSet();
                for (int i11 : state) {
                    hashSet.add(Integer.valueOf(i11));
                }
                if (z10) {
                    hashSet.add(Integer.valueOf(R.attr.state_selected));
                } else {
                    hashSet.remove(Integer.valueOf(R.attr.state_selected));
                }
                iArr = new int[hashSet.size()];
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    iArr[i10] = ((Integer) it.next()).intValue();
                    i10++;
                }
            } else {
                iArr = z10 ? new int[]{R.attr.state_selected} : new int[0];
            }
            drawable.setState(iArr);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable = compoundDrawables[1];
        Drawable drawable2 = compoundDrawables[3];
        Drawable drawable3 = compoundDrawables[0];
        Drawable drawable4 = compoundDrawables[2];
        setPressed(drawable3, false);
        setPressed(drawable, false);
        setPressed(drawable4, false);
        setPressed(drawable2, false);
        setDrawableLeftSelected(this.isDrawableLeftSelected);
        setDrawableTopSelected(this.isDrawableTopSelected);
        setDrawableRightSelected(this.isDrawableRightSelected);
        setDrawableBottomSelected(this.isDrawableBottomSelected);
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingBottom() {
        return super.getCompoundPaddingBottom() + getDrawablePadding(3);
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingLeft() {
        return super.getCompoundPaddingLeft() + getDrawablePadding(0);
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingRight() {
        return super.getCompoundPaddingRight() + getDrawablePadding(2);
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingTop() {
        return super.getCompoundPaddingTop() + getDrawablePadding(1);
    }

    public int getDrawableBottomHeight() {
        return this.drawableBottomHeight;
    }

    public int getDrawableBottomPadding() {
        return this.drawableBottomPadding;
    }

    public int getDrawableBottomWidth() {
        return this.drawableBottomWidth;
    }

    public int getDrawableEndHeight() {
        return this.drawableEndHeight;
    }

    public int getDrawableEndPadding() {
        return this.drawableEndPadding;
    }

    public int getDrawableEndWidth() {
        return this.drawableEndWidth;
    }

    public int getDrawableLeftHeight() {
        return this.drawableLeftHeight;
    }

    public int getDrawableLeftPadding() {
        return this.drawableLeftPadding;
    }

    public int getDrawableLeftWidth() {
        return this.drawableLeftWidth;
    }

    public int getDrawableRightHeight() {
        return this.drawableRightHeight;
    }

    public int getDrawableRightPadding() {
        return this.drawableRightPadding;
    }

    public int getDrawableRightWidth() {
        return this.drawableRightWidth;
    }

    public int getDrawableStartHeight() {
        return this.drawableStartHeight;
    }

    public int getDrawableStartPadding() {
        return this.drawableStartPadding;
    }

    public int getDrawableStartWidth() {
        return this.drawableStartWidth;
    }

    public int getDrawableTopHeight() {
        return this.drawableTopHeight;
    }

    public int getDrawableTopPadding() {
        return this.drawableTopPadding;
    }

    public int getDrawableTopWidth() {
        return this.drawableTopWidth;
    }

    public Drawable getTextBackground() {
        return this.textBackground;
    }

    public TextBackgroundScope getTextBackgroundScope() {
        return this.textBackgroundScope;
    }

    public boolean isDrawableBottomSelected() {
        return this.isDrawableBottomSelected;
    }

    public boolean isDrawableEndSelected() {
        if (this.isRtl) {
            return this.isDrawableLeftSelected;
        }
        return this.isDrawableRightSelected;
    }

    public boolean isDrawableLeftSelected() {
        return this.isDrawableLeftSelected;
    }

    public boolean isDrawableRightSelected() {
        return this.isDrawableRightSelected;
    }

    public boolean isDrawableStartSelected() {
        if (this.isRtl) {
            return this.isDrawableRightSelected;
        }
        return this.isDrawableLeftSelected;
    }

    public boolean isDrawableTopSelected() {
        return this.isDrawableTopSelected;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.textBackground != null) {
            this.textBackground.setBounds(getTextBound());
            this.textBackground.draw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablePadding(int i10) {
        if (!this.isInitSuper) {
            super.setCompoundDrawablePadding(i10);
            return;
        }
        this.drawableStartPadding = i10;
        this.drawableTopPadding = i10;
        this.drawableEndPadding = i10;
        this.drawableBottomPadding = i10;
        this.drawableLeftPadding = i10;
        this.drawableRightPadding = i10;
        super.setCompoundDrawablePadding(0);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        setDrawableWidthHeight(drawable2, this.drawableTopWidth, this.drawableTopHeight);
        setDrawableWidthHeight(drawable4, this.drawableBottomWidth, this.drawableBottomHeight);
        if (this.isRtl) {
            int i10 = this.drawableEndWidth;
            if (i10 == 0) {
                i10 = this.drawableLeftWidth;
            }
            int i11 = this.drawableEndHeight;
            if (i11 == 0) {
                i11 = this.drawableLeftHeight;
            }
            setDrawableWidthHeight(drawable, i10, i11);
            int i12 = this.drawableStartWidth;
            if (i12 == 0) {
                i12 = this.drawableRightWidth;
            }
            int i13 = this.drawableStartHeight;
            if (i13 == 0) {
                i13 = this.drawableRightWidth;
            }
            setDrawableWidthHeight(drawable3, i12, i13);
        } else {
            int i14 = this.drawableStartWidth;
            if (i14 == 0) {
                i14 = this.drawableLeftWidth;
            }
            int i15 = this.drawableStartHeight;
            if (i15 == 0) {
                i15 = this.drawableLeftHeight;
            }
            setDrawableWidthHeight(drawable, i14, i15);
            int i16 = this.drawableEndWidth;
            if (i16 == 0) {
                i16 = this.drawableRightWidth;
            }
            int i17 = this.drawableEndHeight;
            if (i17 == 0) {
                i17 = this.drawableRightHeight;
            }
            setDrawableWidthHeight(drawable3, i16, i17);
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    @RequiresApi(api = 17)
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        setDrawableWidthHeight(drawable2, this.drawableTopWidth, this.drawableTopHeight);
        setDrawableWidthHeight(drawable4, this.drawableBottomWidth, this.drawableBottomHeight);
        if (this.isRtl) {
            int i10 = this.drawableStartWidth;
            if (i10 == 0) {
                i10 = this.drawableRightWidth;
            }
            int i11 = this.drawableStartHeight;
            if (i11 == 0) {
                i11 = this.drawableRightHeight;
            }
            setDrawableWidthHeight(drawable, i10, i11);
            int i12 = this.drawableEndWidth;
            if (i12 == 0) {
                i12 = this.drawableLeftWidth;
            }
            int i13 = this.drawableEndHeight;
            if (i13 == 0) {
                i13 = this.drawableLeftHeight;
            }
            setDrawableWidthHeight(drawable3, i12, i13);
        } else {
            int i14 = this.drawableStartWidth;
            if (i14 == 0) {
                i14 = this.drawableLeftWidth;
            }
            int i15 = this.drawableStartHeight;
            if (i15 == 0) {
                i15 = this.drawableLeftHeight;
            }
            setDrawableWidthHeight(drawable, i14, i15);
            int i16 = this.drawableEndWidth;
            if (i16 == 0) {
                i16 = this.drawableRightWidth;
            }
            int i17 = this.drawableEndHeight;
            if (i17 == 0) {
                i17 = this.drawableRightHeight;
            }
            setDrawableWidthHeight(drawable3, i16, i17);
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    public void setDefaultHint(CharSequence charSequence) {
        this.defaultHint = charSequence;
        setSelectText();
    }

    @RequiresApi(api = 17)
    public void setDrawableBottom(Drawable drawable) {
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable2 = compoundDrawables[0];
        Drawable drawable3 = compoundDrawables[1];
        Drawable drawable4 = compoundDrawables[2];
        Drawable drawable5 = compoundDrawablesRelative[0];
        Drawable drawable6 = compoundDrawablesRelative[2];
        if (this.isRtl) {
            if (drawable5 != null) {
                drawable4 = drawable5;
            }
            if (drawable6 != null) {
                drawable2 = drawable6;
            }
            setCompoundDrawablesRelative(drawable4, drawable3, drawable2, drawable);
            return;
        }
        if (drawable5 != null) {
            drawable2 = drawable5;
        }
        if (drawable6 != null) {
            drawable4 = drawable6;
        }
        setCompoundDrawablesRelative(drawable2, drawable3, drawable4, drawable);
    }

    public void setDrawableBottomPadding(int i10) {
        this.drawableBottomPadding = i10;
        super.setCompoundDrawablePadding(0);
    }

    public void setDrawableBottomSelected(boolean z10) {
        setSelected(getCompoundDrawables()[3], z10);
        this.isDrawableBottomSelected = z10;
    }

    @RequiresApi(api = 17)
    public void setDrawableBottomWidthHeight(int i10, int i11) {
        this.drawableBottomWidth = i10;
        this.drawableBottomHeight = i11;
        initCompoundDrawables();
    }

    @RequiresApi(api = 17)
    public void setDrawableEnd(Drawable drawable) {
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable2 = compoundDrawables[0];
        Drawable drawable3 = compoundDrawables[1];
        Drawable drawable4 = compoundDrawables[2];
        Drawable drawable5 = compoundDrawables[3];
        Drawable drawable6 = compoundDrawablesRelative[0];
        if (this.isRtl) {
            if (drawable6 != null) {
                drawable4 = drawable6;
            }
            setCompoundDrawablesRelative(drawable4, drawable3, drawable, drawable5);
        } else {
            if (drawable6 != null) {
                drawable2 = drawable6;
            }
            setCompoundDrawablesRelative(drawable2, drawable3, drawable, drawable5);
        }
    }

    public void setDrawableEndPadding(int i10) {
        this.drawableEndPadding = i10;
        super.setCompoundDrawablePadding(0);
    }

    public void setDrawableEndSelected(boolean z10) {
        if (this.isRtl) {
            setDrawableLeftSelected(z10);
        } else {
            setDrawableRightSelected(z10);
        }
    }

    @RequiresApi(api = 17)
    public void setDrawableEndWidthHeight(int i10, int i11) {
        this.drawableEndWidth = i10;
        this.drawableEndHeight = i11;
        initCompoundDrawables();
    }

    public void setDrawableLeft(Drawable drawable) {
        Drawable[] compoundDrawables = getCompoundDrawables();
        setCompoundDrawables(drawable, compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }

    public void setDrawableLeftPadding(int i10) {
        this.drawableLeftPadding = i10;
        super.setCompoundDrawablePadding(0);
    }

    public void setDrawableLeftSelected(boolean z10) {
        setSelected(getCompoundDrawables()[0], z10);
        this.isDrawableLeftSelected = z10;
    }

    @RequiresApi(api = 17)
    public void setDrawableLeftWidthHeight(int i10, int i11) {
        this.drawableLeftWidth = i10;
        this.drawableLeftHeight = i11;
        initCompoundDrawables();
    }

    public void setDrawableRight(Drawable drawable) {
        Drawable[] compoundDrawables = getCompoundDrawables();
        setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], drawable, compoundDrawables[3]);
    }

    public void setDrawableRightPadding(int i10) {
        this.drawableRightPadding = i10;
        super.setCompoundDrawablePadding(0);
    }

    public void setDrawableRightSelected(boolean z10) {
        setSelected(getCompoundDrawables()[2], z10);
        this.isDrawableRightSelected = z10;
    }

    @RequiresApi(api = 17)
    public void setDrawableRightWidthHeight(int i10, int i11) {
        this.drawableRightWidth = i10;
        this.drawableRightHeight = i11;
        initCompoundDrawables();
    }

    @RequiresApi(api = 17)
    public void setDrawableStart(Drawable drawable) {
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable2 = compoundDrawables[0];
        Drawable drawable3 = compoundDrawables[1];
        Drawable drawable4 = compoundDrawables[2];
        Drawable drawable5 = compoundDrawables[3];
        Drawable drawable6 = compoundDrawablesRelative[2];
        if (this.isRtl) {
            if (drawable6 != null) {
                drawable2 = drawable6;
            }
            setCompoundDrawablesRelative(drawable, drawable3, drawable2, drawable5);
        } else {
            if (drawable6 != null) {
                drawable4 = drawable6;
            }
            setCompoundDrawablesRelative(drawable, drawable3, drawable4, drawable5);
        }
    }

    public void setDrawableStartPadding(int i10) {
        this.drawableStartPadding = i10;
        super.setCompoundDrawablePadding(0);
    }

    public void setDrawableStartSelected(boolean z10) {
        if (this.isRtl) {
            setDrawableRightSelected(z10);
        } else {
            setDrawableLeftSelected(z10);
        }
    }

    @RequiresApi(api = 17)
    public void setDrawableStartWidthHeight(int i10, int i11) {
        this.drawableStartWidth = i10;
        this.drawableStartHeight = i11;
        initCompoundDrawables();
    }

    @RequiresApi(api = 17)
    public void setDrawableTop(Drawable drawable) {
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable2 = compoundDrawables[0];
        Drawable drawable3 = compoundDrawables[2];
        Drawable drawable4 = compoundDrawables[3];
        Drawable drawable5 = compoundDrawablesRelative[0];
        Drawable drawable6 = compoundDrawablesRelative[2];
        if (this.isRtl) {
            if (drawable5 != null) {
                drawable3 = drawable5;
            }
            if (drawable6 != null) {
                drawable2 = drawable6;
            }
            setCompoundDrawablesRelative(drawable3, drawable, drawable2, drawable4);
            return;
        }
        if (drawable5 != null) {
            drawable2 = drawable5;
        }
        if (drawable6 != null) {
            drawable3 = drawable6;
        }
        setCompoundDrawablesRelative(drawable2, drawable, drawable3, drawable4);
    }

    public void setDrawableTopPadding(int i10) {
        this.drawableTopPadding = i10;
        super.setCompoundDrawablePadding(0);
    }

    public void setDrawableTopSelected(boolean z10) {
        setSelected(getCompoundDrawables()[1], z10);
        this.isDrawableTopSelected = z10;
    }

    @RequiresApi(api = 17)
    public void setDrawableTopWidthHeight(int i10, int i11) {
        this.drawableTopWidth = i10;
        this.drawableTopHeight = i11;
        initCompoundDrawables();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener, ClickScope.allScope);
    }

    public void setOnDoubleClickListener(View.OnClickListener onClickListener) {
        setOnDoubleClickListener(onClickListener, ClickScope.allScope);
    }

    public void setOnDrawableBottomClickListener(View.OnClickListener onClickListener) {
        this.onDrawableBottomClickListener = onClickListener;
    }

    public void setOnDrawableBottomDoubleClickListener(View.OnClickListener onClickListener) {
        this.onDrawableBottomDoubleClickListener = onClickListener;
    }

    public void setOnDrawableBottomLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onDrawableBottomLongClickListener = onLongClickListener;
    }

    public void setOnDrawableEndClickListener(View.OnClickListener onClickListener) {
        this.onDrawableEndClickListener = onClickListener;
    }

    public void setOnDrawableEndDoubleClickListener(View.OnClickListener onClickListener) {
        this.onDrawableEndDoubleClickListener = onClickListener;
    }

    public void setOnDrawableEndLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onDrawableEndLongClickListener = onLongClickListener;
    }

    public void setOnDrawableLeftClickListener(View.OnClickListener onClickListener) {
        this.onDrawableLeftClickListener = onClickListener;
    }

    public void setOnDrawableLeftDoubleClickListener(View.OnClickListener onClickListener) {
        this.onDrawableLeftDoubleClickListener = onClickListener;
    }

    public void setOnDrawableLeftLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onDrawableLeftLongClickListener = onLongClickListener;
    }

    public void setOnDrawableRightClickListener(View.OnClickListener onClickListener) {
        this.onDrawableRightClickListener = onClickListener;
    }

    public void setOnDrawableRightDoubleClickListener(View.OnClickListener onClickListener) {
        this.onDrawableRightDoubleClickListener = onClickListener;
    }

    public void setOnDrawableRightLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onDrawableRightLongClickListener = onLongClickListener;
    }

    public void setOnDrawableStartClickListener(View.OnClickListener onClickListener) {
        this.onDrawableStartClickListener = onClickListener;
    }

    public void setOnDrawableStartDoubleClickListener(View.OnClickListener onClickListener) {
        this.onDrawableStartDoubleClickListener = onClickListener;
    }

    public void setOnDrawableStartLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onDrawableStartLongClickListener = onLongClickListener;
    }

    public void setOnDrawableTopClickListener(View.OnClickListener onClickListener) {
        this.onDrawableTopClickListener = onClickListener;
    }

    public void setOnDrawableTopDoubleClickListener(View.OnClickListener onClickListener) {
        this.onDrawableTopDoubleClickListener = onClickListener;
    }

    public void setOnDrawableTopLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onDrawableTopLongClickListener = onLongClickListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        setOnLongClickListener(onLongClickListener, ClickScope.allScope);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.onTouchListener = onTouchListener;
    }

    public void setSelectedHint(CharSequence charSequence) {
        this.selectedHint = charSequence;
        setSelectText();
    }

    public void setSelectedIgnoreDrawable(boolean z10) {
        super.setSelected(z10);
        setDrawableLeftSelected(this.isDrawableLeftSelected);
        setDrawableTopSelected(this.isDrawableTopSelected);
        setDrawableRightSelected(this.isDrawableRightSelected);
        setDrawableBottomSelected(this.isDrawableBottomSelected);
        setSelectText();
        setSelected(this.textBackground, z10);
    }

    public void setSelectedText(CharSequence charSequence) {
        this.selectedText = charSequence;
        setSelectText();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        boolean z10 = this.isUpdateDefaultText;
        if (z10) {
            this.defaultText = charSequence;
        }
        if (!z10 || !isSelected()) {
            super.setText(charSequence, bufferType);
        }
        this.isUpdateDefaultText = true;
    }

    public void setTextBackground(Drawable drawable) {
        this.textBackground = drawable;
        Rect rect = new Rect();
        rect.left = getCompoundPaddingLeft();
        rect.top = getCompoundPaddingTop();
        rect.right = getWidth() - getCompoundPaddingRight();
        rect.bottom = getHeight() - getCompoundPaddingBottom();
        invalidate(rect);
    }

    public void setTextBackgroundColor(int i10) {
        setTextBackground(new ColorDrawable(i10));
    }

    public void setTextBackgroundResource(int i10) {
        setTextBackground(getResources().getDrawable(i10));
    }

    public void setTextBackgroundScope(TextBackgroundScope textBackgroundScope) {
        this.textBackgroundScope = textBackgroundScope;
        Rect rect = new Rect();
        rect.left = getCompoundPaddingLeft();
        rect.top = getCompoundPaddingTop();
        rect.right = getWidth() - getCompoundPaddingRight();
        rect.bottom = getHeight() - getCompoundPaddingBottom();
        invalidate(rect);
    }

    @RequiresApi(api = 17)
    public PerfectTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnClickListener(View.OnClickListener onClickListener, ClickScope clickScope) {
        this.onClickListener = onClickListener;
        this.clickScope = clickScope;
    }

    public void setOnDoubleClickListener(View.OnClickListener onClickListener, ClickScope clickScope) {
        this.onDoubleClickListener = onClickListener;
        this.doubleClickScope = clickScope;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener, ClickScope clickScope) {
        this.onLongClickListener = onLongClickListener;
        this.longClickScope = clickScope;
    }

    @RequiresApi(api = 17)
    @SuppressLint({"ClickableViewAccessibility"})
    public PerfectTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        ClickScope clickScope = ClickScope.allScope;
        this.clickScope = clickScope;
        this.longClickScope = clickScope;
        this.doubleClickScope = clickScope;
        this.gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.oudi.widget.text.PerfectTextView.2
            /* JADX WARN: Removed duplicated region for block: B:100:0x02a2  */
            /* JADX WARN: Removed duplicated region for block: B:126:0x0343  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0113  */
            /* JADX WARN: Removed duplicated region for block: B:50:0x01ac  */
            @RequiresApi(api = 17)
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private boolean clickEvent(MotionEvent motionEvent, ClickType clickType) {
                boolean z10;
                boolean z11;
                ClickScope clickScope2;
                ClickScope clickScope3;
                ClickScope clickScope4;
                Drawable[] compoundDrawablesRelative = PerfectTextView.this.getCompoundDrawablesRelative();
                Drawable[] compoundDrawables = PerfectTextView.this.getCompoundDrawables();
                Drawable drawable = compoundDrawables[1];
                Drawable drawable2 = compoundDrawables[3];
                boolean z12 = false;
                Drawable drawable3 = compoundDrawables[0];
                Drawable drawable4 = compoundDrawables[2];
                if (drawable3 != null) {
                    int paddingLeft = PerfectTextView.this.getPaddingLeft();
                    int width = drawable3.getBounds().width() + paddingLeft;
                    int compoundPaddingTop = PerfectTextView.this.getCompoundPaddingTop() + (((PerfectTextView.this.getHeight() - PerfectTextView.this.getCompoundPaddingTop()) - PerfectTextView.this.getCompoundPaddingBottom()) / 2);
                    int height = compoundPaddingTop - (drawable3.getBounds().height() / 2);
                    int height2 = (drawable3.getBounds().height() / 2) + compoundPaddingTop;
                    if (motionEvent.getX() >= paddingLeft && motionEvent.getX() <= width && motionEvent.getY() >= height && motionEvent.getY() <= height2) {
                        if (clickType == ClickType.Click) {
                            PerfectTextView perfectTextView = PerfectTextView.this;
                            View.OnClickListener onClickListener = perfectTextView.onDrawableLeftClickListener;
                            if (onClickListener != null) {
                                onClickListener.onClick(perfectTextView);
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (compoundDrawablesRelative[0] == drawable3) {
                                PerfectTextView perfectTextView2 = PerfectTextView.this;
                                View.OnClickListener onClickListener2 = perfectTextView2.onDrawableStartClickListener;
                                if (onClickListener2 != null) {
                                    onClickListener2.onClick(perfectTextView2);
                                    z11 = true;
                                }
                                z10 = true;
                            } else {
                                PerfectTextView perfectTextView3 = PerfectTextView.this;
                                View.OnClickListener onClickListener3 = perfectTextView3.onDrawableEndClickListener;
                                if (onClickListener3 != null) {
                                    onClickListener3.onClick(perfectTextView3);
                                    z11 = true;
                                }
                                z10 = true;
                            }
                        } else {
                            if (clickType == ClickType.LongClick) {
                                PerfectTextView perfectTextView4 = PerfectTextView.this;
                                View.OnLongClickListener onLongClickListener = perfectTextView4.onDrawableLeftLongClickListener;
                                if (onLongClickListener != null) {
                                    z11 = onLongClickListener.onLongClick(perfectTextView4);
                                } else {
                                    z11 = false;
                                }
                                if (compoundDrawablesRelative[0] == drawable3) {
                                    PerfectTextView perfectTextView5 = PerfectTextView.this;
                                    View.OnLongClickListener onLongClickListener2 = perfectTextView5.onDrawableStartLongClickListener;
                                    if (onLongClickListener2 != null) {
                                        z11 = onLongClickListener2.onLongClick(perfectTextView5);
                                    }
                                } else {
                                    PerfectTextView perfectTextView6 = PerfectTextView.this;
                                    View.OnLongClickListener onLongClickListener3 = perfectTextView6.onDrawableEndLongClickListener;
                                    if (onLongClickListener3 != null) {
                                        z11 = onLongClickListener3.onLongClick(perfectTextView6);
                                    }
                                }
                            } else if (clickType == ClickType.DoubleClick) {
                                PerfectTextView perfectTextView7 = PerfectTextView.this;
                                View.OnClickListener onClickListener4 = perfectTextView7.onDrawableLeftDoubleClickListener;
                                if (onClickListener4 != null) {
                                    onClickListener4.onClick(perfectTextView7);
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (compoundDrawablesRelative[0] == drawable3) {
                                    PerfectTextView perfectTextView8 = PerfectTextView.this;
                                    View.OnClickListener onClickListener5 = perfectTextView8.onDrawableStartDoubleClickListener;
                                    if (onClickListener5 != null) {
                                        onClickListener5.onClick(perfectTextView8);
                                        z11 = true;
                                    }
                                } else {
                                    PerfectTextView perfectTextView9 = PerfectTextView.this;
                                    View.OnClickListener onClickListener6 = perfectTextView9.onDrawableEndDoubleClickListener;
                                    if (onClickListener6 != null) {
                                        onClickListener6.onClick(perfectTextView9);
                                        z11 = true;
                                    }
                                }
                            } else {
                                z11 = false;
                            }
                            z10 = true;
                        }
                        if (drawable != null) {
                            int compoundPaddingLeft = PerfectTextView.this.getCompoundPaddingLeft() + (((PerfectTextView.this.getWidth() - PerfectTextView.this.getCompoundPaddingLeft()) - PerfectTextView.this.getCompoundPaddingRight()) / 2);
                            int width2 = compoundPaddingLeft - (drawable.getBounds().width() / 2);
                            int width3 = (drawable.getBounds().width() / 2) + compoundPaddingLeft;
                            int paddingTop = PerfectTextView.this.getPaddingTop();
                            int height3 = drawable.getBounds().height() + paddingTop;
                            if (motionEvent.getX() >= width2 && motionEvent.getX() <= width3 && motionEvent.getY() >= paddingTop && motionEvent.getY() <= height3) {
                                if (clickType == ClickType.Click) {
                                    PerfectTextView perfectTextView10 = PerfectTextView.this;
                                    View.OnClickListener onClickListener7 = perfectTextView10.onDrawableTopClickListener;
                                    if (onClickListener7 != null) {
                                        onClickListener7.onClick(perfectTextView10);
                                        z11 = true;
                                        z10 = true;
                                    }
                                }
                                if (clickType == ClickType.LongClick) {
                                    PerfectTextView perfectTextView11 = PerfectTextView.this;
                                    View.OnLongClickListener onLongClickListener4 = perfectTextView11.onDrawableTopLongClickListener;
                                    if (onLongClickListener4 != null) {
                                        z11 = onLongClickListener4.onLongClick(perfectTextView11);
                                        z10 = true;
                                    }
                                }
                                if (clickType == ClickType.DoubleClick) {
                                    PerfectTextView perfectTextView12 = PerfectTextView.this;
                                    View.OnClickListener onClickListener8 = perfectTextView12.onDrawableTopDoubleClickListener;
                                    if (onClickListener8 != null) {
                                        onClickListener8.onClick(perfectTextView12);
                                        z11 = true;
                                    }
                                }
                                z10 = true;
                            }
                        }
                        if (drawable4 != null) {
                            int width4 = PerfectTextView.this.getWidth() - PerfectTextView.this.getPaddingRight();
                            int width5 = width4 - drawable4.getBounds().width();
                            int compoundPaddingTop2 = PerfectTextView.this.getCompoundPaddingTop() + (((PerfectTextView.this.getHeight() - PerfectTextView.this.getCompoundPaddingTop()) - PerfectTextView.this.getCompoundPaddingBottom()) / 2);
                            int height4 = compoundPaddingTop2 - (drawable4.getBounds().height() / 2);
                            int height5 = (drawable4.getBounds().height() / 2) + compoundPaddingTop2;
                            if (motionEvent.getX() >= width5 && motionEvent.getX() <= width4 && motionEvent.getY() >= height4 && motionEvent.getY() <= height5) {
                                if (clickType == ClickType.Click) {
                                    PerfectTextView perfectTextView13 = PerfectTextView.this;
                                    View.OnClickListener onClickListener9 = perfectTextView13.onDrawableRightClickListener;
                                    if (onClickListener9 != null) {
                                        onClickListener9.onClick(perfectTextView13);
                                        z11 = true;
                                    }
                                    if (compoundDrawablesRelative[2] == drawable4) {
                                        PerfectTextView perfectTextView14 = PerfectTextView.this;
                                        View.OnClickListener onClickListener10 = perfectTextView14.onDrawableEndClickListener;
                                        if (onClickListener10 != null) {
                                            onClickListener10.onClick(perfectTextView14);
                                            z11 = true;
                                        }
                                        z10 = true;
                                    } else {
                                        PerfectTextView perfectTextView15 = PerfectTextView.this;
                                        View.OnClickListener onClickListener11 = perfectTextView15.onDrawableStartClickListener;
                                        if (onClickListener11 != null) {
                                            onClickListener11.onClick(perfectTextView15);
                                            z11 = true;
                                        }
                                        z10 = true;
                                    }
                                } else {
                                    if (clickType == ClickType.LongClick) {
                                        PerfectTextView perfectTextView16 = PerfectTextView.this;
                                        View.OnLongClickListener onLongClickListener5 = perfectTextView16.onDrawableRightLongClickListener;
                                        if (onLongClickListener5 != null) {
                                            z11 = onLongClickListener5.onLongClick(perfectTextView16);
                                        }
                                        if (compoundDrawablesRelative[2] == drawable4) {
                                            PerfectTextView perfectTextView17 = PerfectTextView.this;
                                            View.OnLongClickListener onLongClickListener6 = perfectTextView17.onDrawableEndLongClickListener;
                                            if (onLongClickListener6 != null) {
                                                z11 = onLongClickListener6.onLongClick(perfectTextView17);
                                            }
                                        } else {
                                            PerfectTextView perfectTextView18 = PerfectTextView.this;
                                            View.OnLongClickListener onLongClickListener7 = perfectTextView18.onDrawableStartLongClickListener;
                                            if (onLongClickListener7 != null) {
                                                z11 = onLongClickListener7.onLongClick(perfectTextView18);
                                            }
                                        }
                                    } else if (clickType == ClickType.DoubleClick) {
                                        PerfectTextView perfectTextView19 = PerfectTextView.this;
                                        View.OnClickListener onClickListener12 = perfectTextView19.onDrawableRightDoubleClickListener;
                                        if (onClickListener12 != null) {
                                            onClickListener12.onClick(perfectTextView19);
                                            z11 = true;
                                        }
                                        if (compoundDrawablesRelative[2] == drawable4) {
                                            PerfectTextView perfectTextView20 = PerfectTextView.this;
                                            View.OnClickListener onClickListener13 = perfectTextView20.onDrawableEndDoubleClickListener;
                                            if (onClickListener13 != null) {
                                                onClickListener13.onClick(perfectTextView20);
                                                z11 = true;
                                            }
                                        } else {
                                            PerfectTextView perfectTextView21 = PerfectTextView.this;
                                            View.OnClickListener onClickListener14 = perfectTextView21.onDrawableStartDoubleClickListener;
                                            if (onClickListener14 != null) {
                                                onClickListener14.onClick(perfectTextView21);
                                                z11 = true;
                                            }
                                        }
                                    }
                                    z10 = true;
                                }
                            }
                        }
                        if (drawable2 != null) {
                            int height6 = PerfectTextView.this.getHeight() - PerfectTextView.this.getPaddingBottom();
                            int height7 = height6 - drawable2.getBounds().height();
                            int compoundPaddingLeft2 = PerfectTextView.this.getCompoundPaddingLeft() + (((PerfectTextView.this.getWidth() - PerfectTextView.this.getCompoundPaddingLeft()) - PerfectTextView.this.getCompoundPaddingRight()) / 2);
                            int width6 = compoundPaddingLeft2 - (drawable2.getBounds().width() / 2);
                            int width7 = (drawable2.getBounds().width() / 2) + compoundPaddingLeft2;
                            if (motionEvent.getX() >= width6 && motionEvent.getX() <= width7 && motionEvent.getY() >= height7 && motionEvent.getY() <= height6) {
                                if (clickType == ClickType.Click) {
                                    PerfectTextView perfectTextView22 = PerfectTextView.this;
                                    View.OnClickListener onClickListener15 = perfectTextView22.onDrawableBottomClickListener;
                                    if (onClickListener15 != null) {
                                        onClickListener15.onClick(perfectTextView22);
                                        z11 = true;
                                        z10 = true;
                                    }
                                }
                                if (clickType == ClickType.LongClick) {
                                    PerfectTextView perfectTextView23 = PerfectTextView.this;
                                    View.OnLongClickListener onLongClickListener8 = perfectTextView23.onDrawableBottomLongClickListener;
                                    if (onLongClickListener8 != null) {
                                        z11 = onLongClickListener8.onLongClick(perfectTextView23);
                                        z10 = true;
                                    }
                                }
                                if (clickType == ClickType.DoubleClick) {
                                    PerfectTextView perfectTextView24 = PerfectTextView.this;
                                    View.OnClickListener onClickListener16 = perfectTextView24.onDrawableBottomDoubleClickListener;
                                    if (onClickListener16 != null) {
                                        onClickListener16.onClick(perfectTextView24);
                                        z11 = true;
                                    }
                                }
                                z10 = true;
                            }
                        }
                        if (!z10) {
                            int compoundPaddingLeft3 = PerfectTextView.this.getCompoundPaddingLeft();
                            int compoundPaddingTop3 = PerfectTextView.this.getCompoundPaddingTop();
                            int width8 = PerfectTextView.this.getWidth() - PerfectTextView.this.getCompoundPaddingRight();
                            int height8 = PerfectTextView.this.getHeight() - PerfectTextView.this.getCompoundPaddingBottom();
                            if (motionEvent.getX() >= compoundPaddingLeft3 && motionEvent.getX() <= width8 && motionEvent.getY() >= compoundPaddingTop3 && motionEvent.getY() <= height8) {
                                z12 = true;
                            }
                            if (clickType == ClickType.Click) {
                                PerfectTextView perfectTextView25 = PerfectTextView.this;
                                View.OnClickListener onClickListener17 = perfectTextView25.onClickListener;
                                if (onClickListener17 != null && ((clickScope4 = perfectTextView25.clickScope) == ClickScope.allScope || (clickScope4 == ClickScope.textScope && z12))) {
                                    onClickListener17.onClick(perfectTextView25);
                                    z11 = true;
                                }
                            }
                            if (clickType == ClickType.LongClick) {
                                PerfectTextView perfectTextView26 = PerfectTextView.this;
                                View.OnLongClickListener onLongClickListener9 = perfectTextView26.onLongClickListener;
                                if (onLongClickListener9 != null && ((clickScope3 = perfectTextView26.longClickScope) == ClickScope.allScope || (clickScope3 == ClickScope.textScope && z12))) {
                                    z11 = onLongClickListener9.onLongClick(perfectTextView26);
                                }
                            }
                            if (clickType == ClickType.DoubleClick) {
                                PerfectTextView perfectTextView27 = PerfectTextView.this;
                                View.OnClickListener onClickListener18 = perfectTextView27.onDoubleClickListener;
                                if (onClickListener18 != null && ((clickScope2 = perfectTextView27.doubleClickScope) == ClickScope.allScope || (clickScope2 == ClickScope.textScope && z12))) {
                                    onClickListener18.onClick(perfectTextView27);
                                    return true;
                                }
                            }
                        }
                        return z11;
                    }
                }
                z10 = false;
                z11 = false;
                if (drawable != null) {
                }
                if (drawable4 != null) {
                }
                if (drawable2 != null) {
                }
                if (!z10) {
                }
                return z11;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            @RequiresApi(api = 17)
            public boolean onDoubleTap(MotionEvent motionEvent) {
                return clickEvent(motionEvent, ClickType.DoubleClick);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            @RequiresApi(api = 17)
            public boolean onDown(MotionEvent motionEvent) {
                PerfectTextView.this.setPressed(true, motionEvent);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            @RequiresApi(api = 17)
            public void onLongPress(MotionEvent motionEvent) {
                super.onLongPress(motionEvent);
                clickEvent(motionEvent, ClickType.LongClick);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            @RequiresApi(api = 17)
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return clickEvent(motionEvent, ClickType.Click);
            }
        });
        this.isUpdateDefaultText = true;
        this.isRtl = q.a(Locale.getDefault()) == 1;
        this.isInitSuper = true;
        int compoundDrawablePadding = getCompoundDrawablePadding();
        setCompoundDrawablePadding(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.oudi.widget.R.styleable.PerfectTextView);
        this.drawableStartWidth = obtainStyledAttributes.getDimensionPixelOffset(com.oudi.widget.R.styleable.PerfectTextView_perfect_drawableStart_width, 0);
        this.drawableStartHeight = obtainStyledAttributes.getDimensionPixelOffset(com.oudi.widget.R.styleable.PerfectTextView_perfect_drawableStart_height, 0);
        this.drawableStartPadding = obtainStyledAttributes.getDimensionPixelOffset(com.oudi.widget.R.styleable.PerfectTextView_perfect_drawableStart_padding, compoundDrawablePadding);
        this.drawableTopWidth = obtainStyledAttributes.getDimensionPixelOffset(com.oudi.widget.R.styleable.PerfectTextView_perfect_drawableTop_width, 0);
        this.drawableTopHeight = obtainStyledAttributes.getDimensionPixelOffset(com.oudi.widget.R.styleable.PerfectTextView_perfect_drawableTop_height, 0);
        this.drawableTopPadding = obtainStyledAttributes.getDimensionPixelOffset(com.oudi.widget.R.styleable.PerfectTextView_perfect_drawableTop_padding, compoundDrawablePadding);
        this.drawableEndWidth = obtainStyledAttributes.getDimensionPixelOffset(com.oudi.widget.R.styleable.PerfectTextView_perfect_drawableEnd_width, 0);
        this.drawableEndHeight = obtainStyledAttributes.getDimensionPixelOffset(com.oudi.widget.R.styleable.PerfectTextView_perfect_drawableEnd_height, 0);
        this.drawableEndPadding = obtainStyledAttributes.getDimensionPixelOffset(com.oudi.widget.R.styleable.PerfectTextView_perfect_drawableEnd_padding, compoundDrawablePadding);
        this.drawableBottomWidth = obtainStyledAttributes.getDimensionPixelOffset(com.oudi.widget.R.styleable.PerfectTextView_perfect_drawableBottom_width, 0);
        this.drawableBottomHeight = obtainStyledAttributes.getDimensionPixelOffset(com.oudi.widget.R.styleable.PerfectTextView_perfect_drawableBottom_height, 0);
        this.drawableBottomPadding = obtainStyledAttributes.getDimensionPixelOffset(com.oudi.widget.R.styleable.PerfectTextView_perfect_drawableBottom_padding, compoundDrawablePadding);
        this.drawableLeftWidth = obtainStyledAttributes.getDimensionPixelOffset(com.oudi.widget.R.styleable.PerfectTextView_perfect_drawableLeft_width, 0);
        this.drawableLeftHeight = obtainStyledAttributes.getDimensionPixelOffset(com.oudi.widget.R.styleable.PerfectTextView_perfect_drawableLeft_height, 0);
        this.drawableLeftPadding = obtainStyledAttributes.getDimensionPixelOffset(com.oudi.widget.R.styleable.PerfectTextView_perfect_drawableLeft_padding, compoundDrawablePadding);
        this.drawableRightWidth = obtainStyledAttributes.getDimensionPixelOffset(com.oudi.widget.R.styleable.PerfectTextView_perfect_drawableRight_width, 0);
        this.drawableRightHeight = obtainStyledAttributes.getDimensionPixelOffset(com.oudi.widget.R.styleable.PerfectTextView_perfect_drawableRight_height, 0);
        this.drawableRightPadding = obtainStyledAttributes.getDimensionPixelOffset(com.oudi.widget.R.styleable.PerfectTextView_perfect_drawableRight_padding, compoundDrawablePadding);
        this.selectedText = obtainStyledAttributes.getText(com.oudi.widget.R.styleable.PerfectTextView_perfect_selected_text);
        this.selectedHint = obtainStyledAttributes.getText(com.oudi.widget.R.styleable.PerfectTextView_perfect_selected_hint);
        this.textBackground = obtainStyledAttributes.getDrawable(com.oudi.widget.R.styleable.PerfectTextView_perfect_text_background);
        this.textBackgroundScope = TextBackgroundScope.values()[obtainStyledAttributes.getInt(com.oudi.widget.R.styleable.PerfectTextView_perfect_text_background_scope, 0)];
        this.defaultText = getText();
        this.defaultHint = getHint();
        obtainStyledAttributes.recycle();
        initCompoundDrawables();
        super.setOnTouchListener(new View.OnTouchListener() { // from class: com.oudi.widget.text.PerfectTextView.1
            @Override // android.view.View.OnTouchListener
            @RequiresApi(api = 3)
            public boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z10;
                boolean z11 = true;
                if (motionEvent.getAction() == 1) {
                    PerfectTextView.this.setPressed(false, motionEvent);
                    PerfectTextView.this.setPressed(false);
                }
                View.OnTouchListener onTouchListener = PerfectTextView.this.onTouchListener;
                if (onTouchListener != null) {
                    onTouchListener.onTouch(view, motionEvent);
                }
                MovementMethod movementMethod = PerfectTextView.this.getMovementMethod();
                CharSequence text = PerfectTextView.this.getText();
                if ((movementMethod != null || PerfectTextView.this.onCheckIsTextEditor()) && PerfectTextView.this.isEnabled() && (text instanceof Spannable) && PerfectTextView.this.getLayout() != null) {
                    Spannable spannable = (Spannable) text;
                    if (movementMethod != null) {
                        z10 = PerfectTextView.this.onSpanTouchEvent(spannable, motionEvent);
                    } else {
                        z10 = false;
                    }
                    int compoundPaddingLeft = PerfectTextView.this.getCompoundPaddingLeft();
                    int compoundPaddingTop = PerfectTextView.this.getCompoundPaddingTop();
                    int width = PerfectTextView.this.getWidth() - PerfectTextView.this.getCompoundPaddingRight();
                    int height = PerfectTextView.this.getHeight() - PerfectTextView.this.getCompoundPaddingBottom();
                    if (motionEvent.getX() < compoundPaddingLeft || motionEvent.getX() > width || motionEvent.getY() < compoundPaddingTop || motionEvent.getY() > height) {
                        z11 = false;
                    }
                    if (z10 && z11) {
                        return false;
                    }
                }
                return PerfectTextView.this.gestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    public void setDefaultHint(int i10) {
        setDefaultHint(getContext().getResources().getText(i10));
    }

    public void setSelectedHint(int i10) {
        setSelectedHint(getContext().getResources().getText(i10));
    }

    public void setSelectedText(int i10) {
        setSelectedText(getContext().getResources().getText(i10));
    }

    public void setDrawableLeft(int i10) {
        setDrawableLeft(getResources().getDrawable(i10));
    }

    public void setDrawableRight(int i10) {
        setDrawableRight(getResources().getDrawable(i10));
    }

    @RequiresApi(api = 17)
    public void setDrawableBottom(int i10) {
        setDrawableBottom(getResources().getDrawable(i10));
    }

    @RequiresApi(api = 17)
    public void setDrawableEnd(int i10) {
        setDrawableEnd(getResources().getDrawable(i10));
    }

    @RequiresApi(api = 17)
    public void setDrawableStart(int i10) {
        setDrawableStart(getResources().getDrawable(i10));
    }

    @RequiresApi(api = 17)
    public void setDrawableTop(int i10) {
        setDrawableTop(getResources().getDrawable(i10));
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z10) {
        super.setSelected(z10);
        setDrawableLeftSelected(z10);
        setDrawableTopSelected(z10);
        setDrawableRightSelected(z10);
        setDrawableBottomSelected(z10);
        setSelectText();
        setSelected(this.textBackground, z10);
    }

    private void setPressed(Drawable drawable, boolean z10) {
        int[] iArr;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        int[] state = drawable.getState();
        int i10 = 0;
        if (state != null) {
            HashSet hashSet = new HashSet();
            for (int i11 : state) {
                hashSet.add(Integer.valueOf(i11));
            }
            if (z10) {
                hashSet.add(Integer.valueOf(R.attr.state_pressed));
            } else {
                hashSet.remove(Integer.valueOf(R.attr.state_pressed));
            }
            iArr = new int[hashSet.size()];
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                iArr[i10] = ((Integer) it.next()).intValue();
                i10++;
            }
        } else {
            iArr = z10 ? new int[]{R.attr.state_pressed} : new int[0];
        }
        drawable.setState(iArr);
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        super.setPressed(z10);
        setDrawableLeftSelected(this.isDrawableLeftSelected);
        setDrawableTopSelected(this.isDrawableTopSelected);
        setDrawableRightSelected(this.isDrawableRightSelected);
        setDrawableBottomSelected(this.isDrawableBottomSelected);
        setPressed(this.textBackground, z10);
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable = compoundDrawables[1];
        Drawable drawable2 = compoundDrawables[3];
        Drawable drawable3 = compoundDrawables[0];
        Drawable drawable4 = compoundDrawables[2];
        if (this.isRtl) {
            if (this.onDrawableLeftClickListener == null && this.onDrawableLeftDoubleClickListener == null && this.onDrawableLeftLongClickListener == null && this.onDrawableEndClickListener == null && this.onDrawableEndDoubleClickListener == null && this.onDrawableEndLongClickListener == null) {
                setPressed(drawable3, z10);
            }
            if (this.onDrawableRightClickListener == null && this.onDrawableRightDoubleClickListener == null && this.onDrawableRightLongClickListener == null && this.onDrawableStartClickListener == null && this.onDrawableStartDoubleClickListener == null && this.onDrawableStartLongClickListener == null) {
                setPressed(drawable4, z10);
            }
        } else {
            if (this.onDrawableLeftClickListener == null && this.onDrawableLeftDoubleClickListener == null && this.onDrawableLeftLongClickListener == null && this.onDrawableStartClickListener == null && this.onDrawableStartDoubleClickListener == null && this.onDrawableStartLongClickListener == null) {
                setPressed(drawable3, z10);
            }
            if (this.onDrawableRightClickListener == null && this.onDrawableRightDoubleClickListener == null && this.onDrawableRightLongClickListener == null && this.onDrawableEndClickListener == null && this.onDrawableEndDoubleClickListener == null && this.onDrawableEndLongClickListener == null) {
                setPressed(drawable4, z10);
            }
        }
        if (this.onDrawableTopDoubleClickListener == null && this.onDrawableTopClickListener == null && this.onDrawableTopLongClickListener == null) {
            setPressed(drawable, z10);
        }
        if (this.onDrawableBottomDoubleClickListener == null && this.onDrawableBottomClickListener == null && this.onDrawableBottomLongClickListener == null) {
            setPressed(drawable2, z10);
        }
    }
}
