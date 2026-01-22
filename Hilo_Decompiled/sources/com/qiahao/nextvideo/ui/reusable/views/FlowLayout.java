package com.qiahao.nextvideo.ui.reusable.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.qiahao.nextvideo.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0002'(B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0002J&\u0010\u0019\u001a\u00020\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J0\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0014R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/FlowLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mVerticalAlignType", "Lcom/qiahao/nextvideo/ui/reusable/views/FlowLayout$VerticalAlignType;", "mHorizontalAlignType", "Lcom/qiahao/nextvideo/ui/reusable/views/FlowLayout$HorizontalAlignType;", "mHorizontalSpacing", "mVerticalSpacing", "mMaximumWidth", "commonInit", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "calculateLayout", "assignLayoutForLine", "children", "", "Landroid/view/View;", "yStart", "", "maxHeight", "onLayout", "changed", "", "left", "top", "right", "bottom", "VerticalAlignType", "HorizontalAlignType", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FlowLayout extends ViewGroup {

    @Nullable
    private HorizontalAlignType mHorizontalAlignType;
    private int mHorizontalSpacing;
    private int mMaximumWidth;

    @Nullable
    private VerticalAlignType mVerticalAlignType;
    private int mVerticalSpacing;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/FlowLayout$HorizontalAlignType;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "CENTER", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class HorizontalAlignType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HorizontalAlignType[] $VALUES;
        public static final HorizontalAlignType LEFT = new HorizontalAlignType("LEFT", 0);
        public static final HorizontalAlignType CENTER = new HorizontalAlignType("CENTER", 1);

        private static final /* synthetic */ HorizontalAlignType[] $values() {
            return new HorizontalAlignType[]{LEFT, CENTER};
        }

        static {
            HorizontalAlignType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private HorizontalAlignType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<HorizontalAlignType> getEntries() {
            return $ENTRIES;
        }

        public static HorizontalAlignType valueOf(String str) {
            return (HorizontalAlignType) Enum.valueOf(HorizontalAlignType.class, str);
        }

        public static HorizontalAlignType[] values() {
            return (HorizontalAlignType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/FlowLayout$VerticalAlignType;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "CENTER", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class VerticalAlignType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ VerticalAlignType[] $VALUES;
        public static final VerticalAlignType TOP = new VerticalAlignType("TOP", 0);
        public static final VerticalAlignType BOTTOM = new VerticalAlignType("BOTTOM", 1);
        public static final VerticalAlignType CENTER = new VerticalAlignType("CENTER", 2);

        private static final /* synthetic */ VerticalAlignType[] $values() {
            return new VerticalAlignType[]{TOP, BOTTOM, CENTER};
        }

        static {
            VerticalAlignType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private VerticalAlignType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<VerticalAlignType> getEntries() {
            return $ENTRIES;
        }

        public static VerticalAlignType valueOf(String str) {
            return (VerticalAlignType) Enum.valueOf(VerticalAlignType.class, str);
        }

        public static VerticalAlignType[] values() {
            return (VerticalAlignType[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VerticalAlignType.values().length];
            try {
                iArr[VerticalAlignType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VerticalAlignType.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VerticalAlignType.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        commonInit(context, null);
    }

    private final void assignLayoutForLine(List<? extends View> children, float yStart, float maxHeight) {
        int i;
        float paddingLeft = getPaddingLeft();
        if (this.mHorizontalAlignType == HorizontalAlignType.CENTER) {
            float f = 0.0f;
            for (int i2 = 0; i2 < children.size(); i2++) {
                f += children.get(i2).getMeasuredWidth() + this.mHorizontalSpacing;
            }
            paddingLeft = (this.mMaximumWidth - (f - this.mHorizontalSpacing)) / 2;
        }
        int size = children.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = children.get(i3);
            float measuredWidth = view.getMeasuredWidth();
            float measuredHeight = view.getMeasuredHeight();
            VerticalAlignType verticalAlignType = this.mVerticalAlignType;
            if (verticalAlignType == null) {
                i = -1;
            } else {
                i = WhenMappings.$EnumSwitchMapping$0[verticalAlignType.ordinal()];
            }
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        view.setTag(R.id.view_layout_info_tag_key, new RectF(paddingLeft, yStart, paddingLeft + measuredWidth, measuredHeight + yStart));
                    }
                } else {
                    float f2 = yStart + maxHeight;
                    view.setTag(R.id.view_layout_info_tag_key, new RectF(paddingLeft, f2 - measuredHeight, paddingLeft + measuredWidth, f2));
                }
            } else {
                float f3 = ((maxHeight - measuredHeight) / 2) + yStart;
                view.setTag(R.id.view_layout_info_tag_key, new RectF(paddingLeft, f3, paddingLeft + measuredWidth, measuredHeight + f3));
            }
            paddingLeft += measuredWidth + this.mHorizontalSpacing;
        }
    }

    private final void calculateLayout() {
        float f;
        float f2;
        int childCount = getChildCount();
        float paddingLeft = getPaddingLeft();
        float paddingTop = getPaddingTop();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        loop0: while (true) {
            f = 0.0f;
            while (i < childCount) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    float measuredWidth = childAt.getMeasuredWidth();
                    float measuredHeight = childAt.getMeasuredHeight();
                    if (this.mHorizontalSpacing + paddingLeft + measuredWidth < this.mMaximumWidth - getPaddingRight() || arrayList.size() == 0) {
                        f = Math.max(f, measuredHeight);
                        arrayList.add(childAt);
                        paddingLeft += measuredWidth + this.mHorizontalSpacing;
                    }
                }
                i++;
            }
            assignLayoutForLine(arrayList, paddingTop, f);
            arrayList.clear();
            paddingTop += f + this.mVerticalSpacing;
            paddingLeft = getPaddingLeft();
        }
        if (arrayList.size() > 0) {
            assignLayoutForLine(arrayList, paddingTop, f);
            arrayList.clear();
            f2 = paddingTop + f;
        } else {
            f2 = paddingTop - this.mVerticalSpacing;
        }
        setMeasuredDimension(this.mMaximumWidth, ((int) f2) + getPaddingBottom());
    }

    private final void commonInit(Context context, AttributeSet attrs) {
        VerticalAlignType verticalAlignType = VerticalAlignType.CENTER;
        this.mVerticalAlignType = verticalAlignType;
        HorizontalAlignType horizontalAlignType = HorizontalAlignType.LEFT;
        this.mHorizontalAlignType = horizontalAlignType;
        this.mHorizontalSpacing = 24;
        this.mVerticalSpacing = 24;
        if (attrs != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.FlowLayout);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
            this.mHorizontalSpacing = (int) obtainStyledAttributes.getDimension(3, this.mHorizontalSpacing);
            this.mVerticalSpacing = (int) obtainStyledAttributes.getDimension(5, this.mVerticalSpacing);
            int i = obtainStyledAttributes.getInt(4, 0);
            if (i != 0) {
                if (i != 1) {
                    this.mVerticalAlignType = VerticalAlignType.TOP;
                } else {
                    this.mVerticalAlignType = VerticalAlignType.BOTTOM;
                }
            } else {
                this.mVerticalAlignType = verticalAlignType;
            }
            if (obtainStyledAttributes.getInt(2, 0) == 1) {
                this.mHorizontalAlignType = HorizontalAlignType.CENTER;
            } else {
                this.mHorizontalAlignType = horizontalAlignType;
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top2, int right, int bottom) {
        RectF rectF;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Object tag = childAt.getTag(R.id.view_layout_info_tag_key);
            if (tag instanceof RectF) {
                rectF = (RectF) tag;
            } else {
                rectF = null;
            }
            if (rectF != null) {
                childAt.layout((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            measureChild(getChildAt(i), widthMeasureSpec, heightMeasureSpec);
        }
        this.mMaximumWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        calculateLayout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayout(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        commonInit(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayout(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        commonInit(context, attributeSet);
    }
}
