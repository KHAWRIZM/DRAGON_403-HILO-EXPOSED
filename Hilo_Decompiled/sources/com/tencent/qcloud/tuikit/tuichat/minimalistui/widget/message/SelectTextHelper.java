package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.URLSpan;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Magnifier;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.q;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.r;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class SelectTextHelper {
    private static int DEFAULT_SELECTION_LENGTH = 2;
    private static int DEFAULT_SHOW_DURATION = 100;
    private static int STATUS_HEIGHT = 0;
    private static final String TAG = "SelectTextHelper";
    private boolean isHideWhenScroll;
    private List<Builder.onSeparateItemClickListener> itemListenerList;
    private List<Pair<Integer, String>> itemTextList;
    private Context mContext;
    private int mCursorHandleColor;
    private int mCursorHandleSize;
    private CursorHandle mEndHandle;
    private boolean mIsEmoji;
    private Magnifier mMagnifier;
    private boolean mMagnifierShow;
    private ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    private ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener;
    private int mPopArrowImg;
    private int mPopBgResource;
    private int mPopSpanCount;
    private View.OnTouchListener mRootTouchListener;
    private boolean mScrollShow;
    private boolean mSelectAll;
    private OnSelectListener mSelectListener;
    private boolean mSelectedAllNoPop;
    private int mSelectedColor;
    private BackgroundColorSpan mSpan;
    private Spannable mSpannable;
    private CursorHandle mStartHandle;
    private TextView mTextView;
    private int mTouchX;
    private int mTouchY;
    private SelectionInfo mSelectionInfo = new SelectionInfo();
    private int mTextViewMarginStart = 0;
    private boolean isHide = true;
    private boolean usedClickListener = false;
    private final Runnable mShowSelectViewRunnable = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.SelectTextHelper.2
        @Override // java.lang.Runnable
        public void run() {
            if (SelectTextHelper.this.isHide) {
                return;
            }
            if (SelectTextHelper.this.mStartHandle != null) {
                SelectTextHelper selectTextHelper = SelectTextHelper.this;
                selectTextHelper.showCursorHandle(selectTextHelper.mStartHandle);
            }
            if (SelectTextHelper.this.mEndHandle != null) {
                SelectTextHelper selectTextHelper2 = SelectTextHelper.this;
                selectTextHelper2.showCursorHandle(selectTextHelper2.mEndHandle);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class CursorHandle extends View {
        private boolean isLeft;
        private int mAdjustX;
        private int mAdjustY;
        private int mBeforeDragEnd;
        private int mBeforeDragStart;
        private int mCircleRadius;
        private int mHeight;
        private int mPadding;
        private Paint mPaint;
        private PopupWindow mPopupWindow;
        private int[] mTempCoors;
        private int mWidth;

        public CursorHandle(boolean z) {
            super(SelectTextHelper.this.mContext);
            this.mCircleRadius = SelectTextHelper.this.mCursorHandleSize / 2;
            this.mWidth = SelectTextHelper.this.mCursorHandleSize;
            this.mHeight = SelectTextHelper.this.mCursorHandleSize;
            this.mPadding = 32;
            this.mTempCoors = new int[2];
            this.isLeft = z;
            Paint paint = new Paint(1);
            this.mPaint = paint;
            paint.setColor(SelectTextHelper.this.mCursorHandleColor);
            PopupWindow popupWindow = new PopupWindow(this);
            this.mPopupWindow = popupWindow;
            popupWindow.setClippingEnabled(false);
            this.mPopupWindow.setWidth(this.mWidth + (this.mPadding * 2));
            this.mPopupWindow.setHeight(this.mHeight + (this.mPadding / 2));
            invalidate();
        }

        private void changeDirection() {
            this.isLeft = !this.isLeft;
            invalidate();
        }

        private void updateCursorHandle() {
            SelectTextHelper.this.mTextView.getLocationInWindow(this.mTempCoors);
            Layout layout = SelectTextHelper.this.mTextView.getLayout();
            if (this.isLeft) {
                this.mPopupWindow.update((((int) layout.getPrimaryHorizontal(SelectTextHelper.this.mSelectionInfo.mStart)) - this.mWidth) + getExtraX(), layout.getLineBottom(layout.getLineForOffset(SelectTextHelper.this.mSelectionInfo.mStart)) + getExtraY(), -1, -1);
            } else {
                this.mPopupWindow.update(((int) layout.getPrimaryHorizontal(SelectTextHelper.this.mSelectionInfo.mEnd)) + getExtraX(), layout.getLineBottom(layout.getLineForOffset(SelectTextHelper.this.mSelectionInfo.mEnd)) + getExtraY(), -1, -1);
            }
        }

        public void dismiss() {
            this.mPopupWindow.dismiss();
        }

        public int getExtraX() {
            return (this.mTempCoors[0] - this.mPadding) + SelectTextHelper.this.mTextView.getPaddingLeft();
        }

        public int getExtraY() {
            return this.mTempCoors[1] + SelectTextHelper.this.mTextView.getPaddingTop();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int i = this.mCircleRadius;
            canvas.drawCircle(this.mPadding + i, i, i, this.mPaint);
            if (this.isLeft) {
                int i2 = this.mCircleRadius;
                int i3 = this.mPadding;
                canvas.drawRect(i2 + i3, 0.0f, (i2 * 2) + i3, i2, this.mPaint);
            } else {
                canvas.drawRect(this.mPadding, 0.0f, r0 + r1, this.mCircleRadius, this.mPaint);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
        
            if (r0 != 3) goto L٣٠;
         */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (SelectTextHelper.this.mSelectListener != null) {
                            SelectTextHelper.this.mSelectListener.onDismissCustomPop();
                        }
                        update(((this.mAdjustX + ((int) motionEvent.getRawX())) - this.mWidth) - SelectTextHelper.this.mTextViewMarginStart, ((this.mAdjustY + ((int) motionEvent.getRawY())) - this.mHeight) - ((int) SelectTextHelper.this.mTextView.getTextSize()));
                        if (SelectTextHelper.this.mMagnifierShow && Build.VERSION.SDK_INT >= 28) {
                            if (SelectTextHelper.this.mMagnifier == null) {
                                SelectTextHelper selectTextHelper = SelectTextHelper.this;
                                r.a();
                                selectTextHelper.mMagnifier = q.a(SelectTextHelper.this.mTextView);
                                SelectTextHelper.this.mMagnifier.getWidth();
                            }
                            SelectTextHelper.this.mTextView.getLocationOnScreen(new int[2]);
                            SelectTextHelper.this.mMagnifier.show(r0 - r2[0], Math.max((r8 - r2[1]) - SelectTextHelper.dp2px(32.0f), 0));
                        }
                    }
                }
                if (SelectTextHelper.this.mMagnifierShow && Build.VERSION.SDK_INT >= 28 && SelectTextHelper.this.mMagnifier != null) {
                    SelectTextHelper.this.mMagnifier.dismiss();
                }
            } else {
                this.mBeforeDragStart = SelectTextHelper.this.mSelectionInfo.mStart;
                this.mBeforeDragEnd = SelectTextHelper.this.mSelectionInfo.mEnd;
                this.mAdjustX = (int) motionEvent.getX();
                this.mAdjustY = (int) motionEvent.getY();
            }
            return true;
        }

        public void show(int i, int i2) {
            int i3;
            SelectTextHelper.this.mTextView.getLocationInWindow(this.mTempCoors);
            if (this.isLeft) {
                i3 = this.mWidth;
            } else {
                i3 = 0;
            }
            this.mPopupWindow.showAtLocation(SelectTextHelper.this.mTextView, 0, (i - i3) + getExtraX(), i2 + getExtraY());
        }

        public void update(int i, int i2) {
            int i3;
            SelectTextHelper.this.mTextView.getLocationInWindow(this.mTempCoors);
            if (this.isLeft) {
                i3 = SelectTextHelper.this.mSelectionInfo.mStart;
            } else {
                i3 = SelectTextHelper.this.mSelectionInfo.mEnd;
            }
            int hysteresisOffset = SelectTextHelper.getHysteresisOffset(SelectTextHelper.this.mTextView, i, i2 - this.mTempCoors[1], i3);
            if (hysteresisOffset != i3) {
                SelectTextHelper.this.resetSelectionInfo();
                if (this.isLeft) {
                    if (hysteresisOffset > this.mBeforeDragEnd) {
                        CursorHandle cursorHandle = SelectTextHelper.this.getCursorHandle(false);
                        changeDirection();
                        cursorHandle.changeDirection();
                        int i4 = this.mBeforeDragEnd;
                        this.mBeforeDragStart = i4;
                        SelectTextHelper.this.selectText(i4, hysteresisOffset);
                        cursorHandle.updateCursorHandle();
                    } else {
                        SelectTextHelper.this.selectText(hysteresisOffset, -1);
                    }
                    updateCursorHandle();
                    return;
                }
                int i5 = this.mBeforeDragStart;
                if (hysteresisOffset < i5) {
                    CursorHandle cursorHandle2 = SelectTextHelper.this.getCursorHandle(true);
                    cursorHandle2.changeDirection();
                    changeDirection();
                    int i6 = this.mBeforeDragStart;
                    this.mBeforeDragEnd = i6;
                    SelectTextHelper.this.selectText(hysteresisOffset, i6);
                    cursorHandle2.updateCursorHandle();
                } else {
                    SelectTextHelper.this.selectText(i5, hysteresisOffset);
                }
                updateCursorHandle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class LinkMovementMethodInterceptor extends LinkMovementMethod {
        private long downLinkTime;

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int totalPaddingLeft = x - textView.getTotalPaddingLeft();
                int totalPaddingTop = y - textView.getTotalPaddingTop();
                int scrollX = totalPaddingLeft + textView.getScrollX();
                int scrollY = totalPaddingTop + textView.getScrollY();
                Layout layout = textView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    if (action == 1) {
                        if (this.downLinkTime + ViewConfiguration.getLongPressTimeout() < System.currentTimeMillis()) {
                            return false;
                        }
                        ClickableSpan clickableSpan = clickableSpanArr[0];
                        if (clickableSpan instanceof URLSpan) {
                            URLSpan uRLSpan = (URLSpan) clickableSpan;
                            if (!TextUtils.isEmpty(uRLSpan.getURL())) {
                                if (SelectTextHelper.this.mSelectListener != null) {
                                    SelectTextHelper.this.usedClickListener = true;
                                    SelectTextHelper.this.mSelectListener.onClickUrl(uRLSpan.getURL());
                                }
                                return true;
                            }
                            clickableSpanArr[0].onClick(textView);
                        }
                    } else if (action == 0) {
                        this.downLinkTime = System.currentTimeMillis();
                        Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                    }
                    return true;
                }
                Selection.removeSelection(spannable);
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }

        private LinkMovementMethodInterceptor() {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnSelectListener {
        void onClick(View view);

        void onClickUrl(String str);

        void onDismiss();

        void onDismissCustomPop();

        void onLongClick(View view);

        void onReset();

        void onScrolling();

        void onSelectAllShowCustomPop();

        void onTextSelected(CharSequence charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class SelectionInfo {
        public int mEnd;
        public String mSelectionContent;
        public int mStart;

        private SelectionInfo() {
        }
    }

    public SelectTextHelper(Builder builder) {
        this.mIsEmoji = false;
        this.itemListenerList = new LinkedList();
        TextView textView = builder.mTextView;
        this.mTextView = textView;
        this.mContext = textView.getContext();
        this.mSelectedColor = builder.mSelectedColor;
        this.mCursorHandleColor = builder.mCursorHandleColor;
        this.mSelectAll = builder.mSelectAll;
        this.mIsEmoji = builder.mIsEmoji;
        this.mScrollShow = builder.mScrollShow;
        this.mMagnifierShow = builder.mMagnifierShow;
        this.mPopSpanCount = builder.mPopSpanCount;
        this.mPopBgResource = builder.mPopBgResource;
        this.mPopArrowImg = builder.mPopArrowImg;
        this.mSelectedAllNoPop = builder.mSelectedAllNoPop;
        this.itemTextList = builder.itemTextList;
        this.itemListenerList = builder.itemListenerList;
        this.mCursorHandleSize = dp2px(builder.mCursorHandleSizeInDp);
        init();
    }

    public static int dp2px(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CursorHandle getCursorHandle(boolean z) {
        if (this.mStartHandle.isLeft == z) {
            return this.mStartHandle;
        }
        return this.mEndHandle;
    }

    public static int getDisplayHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int getDisplayWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getHysteresisOffset(TextView textView, int i, int i2, int i3) {
        Layout layout = textView.getLayout();
        if (layout == null) {
            return -1;
        }
        int lineForVertical = layout.getLineForVertical(i2);
        if (isEndOfLineOffset(layout, i3)) {
            int primaryHorizontal = (int) layout.getPrimaryHorizontal(i3 - 1);
            int lineRight = (int) layout.getLineRight(lineForVertical);
            if (i > lineRight - ((lineRight - primaryHorizontal) / 2)) {
                i3--;
            }
        }
        int lineForOffset = layout.getLineForOffset(i3);
        int lineTop = layout.getLineTop(lineForOffset);
        int lineBottom = layout.getLineBottom(lineForOffset);
        int i4 = (lineBottom - lineTop) / 2;
        if ((lineForVertical == lineForOffset + 1 && i2 - lineBottom < i4) || (lineForVertical == lineForOffset - 1 && lineTop - i2 < i4)) {
            lineForVertical = lineForOffset;
        }
        int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, i);
        if (offsetForHorizontal < textView.getText().length() - 1) {
            int i5 = offsetForHorizontal + 1;
            if (isEndOfLineOffset(layout, i5)) {
                int primaryHorizontal2 = (int) layout.getPrimaryHorizontal(offsetForHorizontal);
                int lineRight2 = (int) layout.getLineRight(lineForVertical);
                if (i > lineRight2 - ((lineRight2 - primaryHorizontal2) / 2)) {
                    return i5;
                }
                return offsetForHorizontal;
            }
            return offsetForHorizontal;
        }
        return offsetForHorizontal;
    }

    public static int getPreciseOffset(TextView textView, int i, int i2) {
        Layout layout = textView.getLayout();
        if (layout != null) {
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(i2), i);
            if (((int) layout.getPrimaryHorizontal(offsetForHorizontal)) > i) {
                return layout.getOffsetToLeftOf(offsetForHorizontal);
            }
            return offsetForHorizontal;
        }
        return -1;
    }

    public static int getStatusHeight() {
        int i = STATUS_HEIGHT;
        if (i != 0) {
            return i;
        }
        int identifier = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            int dimensionPixelSize = Resources.getSystem().getDimensionPixelSize(identifier);
            STATUS_HEIGHT = dimensionPixelSize;
            return dimensionPixelSize;
        }
        return -1;
    }

    private void handlerEmojiSelectText() {
        Matcher matcher = Pattern.compile("\\[(\\S+?)\\]").matcher(this.mSelectionInfo.mSelectionContent);
        while (matcher.find()) {
            Bitmap emoji = FaceManager.getEmoji(matcher.group());
            if (emoji != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(emoji);
                ShapeDrawable shapeDrawable = new ShapeDrawable();
                shapeDrawable.getPaint().setColor(this.mTextView.getContext().getResources().getColor(R.color.text_select_color));
                LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, bitmapDrawable});
                layerDrawable.setBounds(0, 0, 64, 64);
                ImageSpan imageSpan = new ImageSpan(layerDrawable, 1);
                Spannable spannable = this.mSpannable;
                SelectionInfo selectionInfo = this.mSelectionInfo;
                spannable.setSpan(imageSpan, selectionInfo.mStart, selectionInfo.mEnd, 17);
            }
        }
    }

    private void hideSelectView() {
        this.isHide = true;
        this.usedClickListener = false;
        if (this.mStartHandle != null) {
            TUIChatLog.d(TAG, "mStartHandle.dismiss();");
            this.mStartHandle.dismiss();
        }
        if (this.mEndHandle != null) {
            TUIChatLog.d(TAG, "mEndHandle.dismiss();");
            this.mEndHandle.dismiss();
        }
    }

    private void init() {
        TextView textView = this.mTextView;
        textView.setText(textView.getText(), TextView.BufferType.SPANNABLE);
        this.mTextView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.m
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean lambda$init$0;
                lambda$init$0 = SelectTextHelper.this.lambda$init$0(view, motionEvent);
                return lambda$init$0;
            }
        });
        this.mTextView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectTextHelper.this.lambda$init$1(view);
            }
        });
        this.mTextView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.SelectTextHelper.1
            private void onLongTextViewClick() {
                SelectTextHelper.this.mTextView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.SelectTextHelper.1.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                        SelectTextHelper.this.destroy();
                    }
                });
                SelectTextHelper.this.mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.SelectTextHelper.1.2
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        if (SelectTextHelper.this.isHideWhenScroll) {
                            SelectTextHelper.this.isHideWhenScroll = false;
                            SelectTextHelper.this.postShowSelectView(SelectTextHelper.DEFAULT_SHOW_DURATION);
                        }
                        if (SelectTextHelper.this.mTextViewMarginStart == 0) {
                            int[] iArr = new int[2];
                            SelectTextHelper.this.mTextView.getLocationInWindow(iArr);
                            SelectTextHelper.this.mTextViewMarginStart = iArr[0];
                            return true;
                        }
                        return true;
                    }
                };
                SelectTextHelper.this.mTextView.getViewTreeObserver().addOnPreDrawListener(SelectTextHelper.this.mOnPreDrawListener);
                SelectTextHelper.this.mRootTouchListener = new View.OnTouchListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.SelectTextHelper.1.3
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        SelectTextHelper.this.reset();
                        SelectTextHelper.this.mTextView.getRootView().setOnTouchListener(null);
                        return false;
                    }
                };
                SelectTextHelper.this.mTextView.getRootView().setOnTouchListener(SelectTextHelper.this.mRootTouchListener);
                SelectTextHelper.this.mOnScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.SelectTextHelper.1.4
                    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                    public void onScrollChanged() {
                        if (SelectTextHelper.this.mScrollShow) {
                            if (!SelectTextHelper.this.isHideWhenScroll && !SelectTextHelper.this.isHide) {
                                SelectTextHelper.this.isHideWhenScroll = true;
                                if (SelectTextHelper.this.mStartHandle != null) {
                                    SelectTextHelper.this.mStartHandle.dismiss();
                                }
                                if (SelectTextHelper.this.mEndHandle != null) {
                                    SelectTextHelper.this.mEndHandle.dismiss();
                                }
                            }
                            if (SelectTextHelper.this.mSelectListener != null) {
                                SelectTextHelper.this.mSelectListener.onScrolling();
                                return;
                            }
                            return;
                        }
                        SelectTextHelper.this.reset();
                    }
                };
                SelectTextHelper.this.mTextView.getViewTreeObserver().addOnScrollChangedListener(SelectTextHelper.this.mOnScrollChangedListener);
                if (SelectTextHelper.this.mSelectAll) {
                    SelectTextHelper.this.showAllView();
                } else {
                    SelectTextHelper selectTextHelper = SelectTextHelper.this;
                    selectTextHelper.showSelectView(selectTextHelper.mTouchX, SelectTextHelper.this.mTouchY);
                }
                if (SelectTextHelper.this.mSelectListener != null) {
                    SelectTextHelper.this.mSelectListener.onLongClick(SelectTextHelper.this.mTextView);
                }
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.mTextView.setMovementMethod(new LinkMovementMethodInterceptor());
    }

    private static boolean isEndOfLineOffset(Layout layout, int i) {
        if (i > 0 && layout.getLineForOffset(i) == layout.getLineForOffset(i - 1) + 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$init$0(View view, MotionEvent motionEvent) {
        this.mTouchX = (int) motionEvent.getX();
        this.mTouchY = (int) motionEvent.getY();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(View view) {
        if (this.usedClickListener) {
            this.usedClickListener = false;
            return;
        }
        OnSelectListener onSelectListener = this.mSelectListener;
        if (onSelectListener != null) {
            onSelectListener.onDismiss();
        }
        reset();
        OnSelectListener onSelectListener2 = this.mSelectListener;
        if (onSelectListener2 != null) {
            onSelectListener2.onClick(this.mTextView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postShowSelectView(int i) {
        this.mTextView.removeCallbacks(this.mShowSelectViewRunnable);
        if (i <= 0) {
            this.mShowSelectViewRunnable.run();
        } else {
            this.mTextView.postDelayed(this.mShowSelectViewRunnable, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetSelectionInfo() {
        this.mSelectionInfo.mSelectionContent = null;
        if (this.mSpannable != null && this.mSpan != null) {
            TUIChatLog.d(TAG, "mSpannable.removeSpan(mSpan);");
            this.mSpannable.removeSpan(this.mSpan);
            this.mSpan = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectText(int i, int i2) {
        if (i != -1) {
            this.mSelectionInfo.mStart = i;
        }
        if (i2 != -1) {
            this.mSelectionInfo.mEnd = i2;
        }
        SelectionInfo selectionInfo = this.mSelectionInfo;
        int i3 = selectionInfo.mStart;
        int i4 = selectionInfo.mEnd;
        if (i3 > i4) {
            selectionInfo.mStart = i4;
            selectionInfo.mEnd = i3;
        }
        if (this.mSpannable != null) {
            if (this.mSpan == null) {
                this.mSpan = new BackgroundColorSpan(this.mSelectedColor);
            }
            SelectionInfo selectionInfo2 = this.mSelectionInfo;
            selectionInfo2.mSelectionContent = this.mSpannable.subSequence(selectionInfo2.mStart, selectionInfo2.mEnd).toString();
            Spannable spannable = this.mSpannable;
            BackgroundColorSpan backgroundColorSpan = this.mSpan;
            SelectionInfo selectionInfo3 = this.mSelectionInfo;
            spannable.setSpan(backgroundColorSpan, selectionInfo3.mStart, selectionInfo3.mEnd, 17);
            OnSelectListener onSelectListener = this.mSelectListener;
            if (onSelectListener != null) {
                onSelectListener.onTextSelected(this.mSelectionInfo.mSelectionContent);
            }
        }
    }

    public static void setWidthHeight(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAllView() {
        reset();
        this.isHide = false;
        if (this.mStartHandle == null) {
            this.mStartHandle = new CursorHandle(true);
        }
        if (this.mEndHandle == null) {
            this.mEndHandle = new CursorHandle(false);
        }
        if (this.mTextView.getText() instanceof Spannable) {
            this.mSpannable = (Spannable) this.mTextView.getText();
        }
        if (this.mSpannable == null) {
            return;
        }
        selectText(0, this.mTextView.getText().length());
        showCursorHandle(this.mStartHandle);
        showCursorHandle(this.mEndHandle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCursorHandle(CursorHandle cursorHandle) {
        int i;
        Layout layout = this.mTextView.getLayout();
        if (layout == null) {
            return;
        }
        if (cursorHandle.isLeft) {
            i = this.mSelectionInfo.mStart;
        } else {
            i = this.mSelectionInfo.mEnd;
        }
        cursorHandle.show((int) layout.getPrimaryHorizontal(i), layout.getLineBottom(layout.getLineForOffset(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSelectView(int i, int i2) {
        reset();
        this.isHide = false;
        if (this.mStartHandle == null) {
            this.mStartHandle = new CursorHandle(true);
        }
        if (this.mEndHandle == null) {
            this.mEndHandle = new CursorHandle(false);
        }
        int preciseOffset = getPreciseOffset(this.mTextView, i, i2);
        int i3 = DEFAULT_SELECTION_LENGTH + preciseOffset;
        if (this.mTextView.getText() instanceof Spannable) {
            this.mSpannable = (Spannable) this.mTextView.getText();
        }
        if (this.mSpannable != null && i3 - 1 < this.mTextView.getText().length()) {
            selectText(preciseOffset, i3);
            showCursorHandle(this.mStartHandle);
            showCursorHandle(this.mEndHandle);
        }
    }

    public void destroy() {
        this.mTextView.getViewTreeObserver().removeOnScrollChangedListener(this.mOnScrollChangedListener);
        this.mTextView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        this.mTextView.getRootView().setOnTouchListener(null);
        reset();
        this.mStartHandle = null;
        this.mEndHandle = null;
    }

    public void reset() {
        TUIChatLog.d(TAG, "reset");
        hideSelectView();
        resetSelectionInfo();
        OnSelectListener onSelectListener = this.mSelectListener;
        if (onSelectListener != null) {
            onSelectListener.onReset();
        }
    }

    public void selectAll() {
        showAllView();
    }

    public void setSelectListener(OnSelectListener onSelectListener) {
        this.mSelectListener = onSelectListener;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class Builder {
        private TextView mTextView;
        private int mCursorHandleColor = -15500842;
        private int mSelectedColor = -5250572;
        private float mCursorHandleSizeInDp = 24.0f;
        private boolean mSelectAll = true;
        private boolean mSelectedAllNoPop = false;
        private boolean mScrollShow = true;
        private boolean mMagnifierShow = true;
        private int mPopSpanCount = 5;
        private int mPopBgResource = 0;
        private int mPopArrowImg = 0;
        private boolean mIsEmoji = false;
        private List<Pair<Integer, String>> itemTextList = new LinkedList();
        private List<onSeparateItemClickListener> itemListenerList = new LinkedList();

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public interface onSeparateItemClickListener {
            void onClick();
        }

        public Builder(TextView textView) {
            this.mTextView = textView;
        }

        public Builder addItem(int i, int i2, onSeparateItemClickListener onseparateitemclicklistener) {
            this.itemTextList.add(new Pair<>(Integer.valueOf(i), this.mTextView.getContext().getResources().getString(i2)));
            this.itemListenerList.add(onseparateitemclicklistener);
            return this;
        }

        public SelectTextHelper build() {
            return new SelectTextHelper(this);
        }

        public Builder setCursorHandleColor(int i) {
            this.mCursorHandleColor = i;
            return this;
        }

        public Builder setCursorHandleSizeInDp(float f) {
            this.mCursorHandleSizeInDp = f;
            return this;
        }

        public Builder setIsEmoji(boolean z) {
            this.mIsEmoji = z;
            return this;
        }

        public Builder setMagnifierShow(boolean z) {
            this.mMagnifierShow = z;
            return this;
        }

        public Builder setPopSpanCount(int i) {
            this.mPopSpanCount = i;
            return this;
        }

        public Builder setPopStyle(int i, int i2) {
            this.mPopBgResource = i;
            this.mPopArrowImg = i2;
            return this;
        }

        public Builder setScrollShow(boolean z) {
            this.mScrollShow = z;
            return this;
        }

        public Builder setSelectAll(boolean z) {
            this.mSelectAll = z;
            return this;
        }

        public Builder setSelectedAllNoPop(boolean z) {
            this.mSelectedAllNoPop = z;
            return this;
        }

        public Builder setSelectedColor(int i) {
            this.mSelectedColor = i;
            return this;
        }

        public Builder addItem(int i, String str, onSeparateItemClickListener onseparateitemclicklistener) {
            this.itemTextList.add(new Pair<>(Integer.valueOf(i), str));
            this.itemListenerList.add(onseparateitemclicklistener);
            return this;
        }
    }
}
