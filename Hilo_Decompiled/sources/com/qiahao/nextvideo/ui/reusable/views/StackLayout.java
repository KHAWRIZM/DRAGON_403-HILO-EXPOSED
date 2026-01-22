package com.qiahao.nextvideo.ui.reusable.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.qiahao.nextvideo.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001:\u000234B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0014J\u0018\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0002J0\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nH\u0014J\u0018\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\nH\u0002J\u0018\u00102\u001a\u00020!2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\nH\u0002R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/StackLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "orientation", "Lcom/qiahao/nextvideo/ui/reusable/views/StackLayout$Orientation;", "getOrientation", "()Lcom/qiahao/nextvideo/ui/reusable/views/StackLayout$Orientation;", "setOrientation", "(Lcom/qiahao/nextvideo/ui/reusable/views/StackLayout$Orientation;)V", "gravity", "Lcom/qiahao/nextvideo/ui/reusable/views/StackLayout$Gravity;", "childGravity", "newValue", "", "spacing", "getSpacing", "()F", "setSpacing", "(F)V", "totalChildrenWidth", "maxChildWidth", "totalChildrenHeight", "maxChildHeight", "commonInit", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resolveMeasureSpec", "wanted", "measureSpec", "onLayout", "changed", "", "left", "top", "right", "bottom", "layoutHorizontally", "width", "height", "layoutVertically", "Orientation", "Gravity", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class StackLayout extends ViewGroup {

    @NotNull
    private Gravity childGravity;

    @NotNull
    private Gravity gravity;
    private float maxChildHeight;
    private float maxChildWidth;

    @NotNull
    private Orientation orientation;
    private float spacing;
    private float totalChildrenHeight;
    private float totalChildrenWidth;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/StackLayout$Gravity;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT_OR_TOP", "CENTER", "RIGHT_OR_BOTTOM", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Gravity {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Gravity[] $VALUES;
        public static final Gravity LEFT_OR_TOP = new Gravity("LEFT_OR_TOP", 0);
        public static final Gravity CENTER = new Gravity("CENTER", 1);
        public static final Gravity RIGHT_OR_BOTTOM = new Gravity("RIGHT_OR_BOTTOM", 2);

        private static final /* synthetic */ Gravity[] $values() {
            return new Gravity[]{LEFT_OR_TOP, CENTER, RIGHT_OR_BOTTOM};
        }

        static {
            Gravity[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Gravity(String str, int i) {
        }

        @NotNull
        public static EnumEntries<Gravity> getEntries() {
            return $ENTRIES;
        }

        public static Gravity valueOf(String str) {
            return (Gravity) Enum.valueOf(Gravity.class, str);
        }

        public static Gravity[] values() {
            return (Gravity[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/StackLayout$Orientation;", "", "<init>", "(Ljava/lang/String;I)V", "VERTICAL", "HORIZONTAL", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Orientation {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Orientation[] $VALUES;
        public static final Orientation VERTICAL = new Orientation("VERTICAL", 0);
        public static final Orientation HORIZONTAL = new Orientation("HORIZONTAL", 1);

        private static final /* synthetic */ Orientation[] $values() {
            return new Orientation[]{VERTICAL, HORIZONTAL};
        }

        static {
            Orientation[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Orientation(String str, int i) {
        }

        @NotNull
        public static EnumEntries<Orientation> getEntries() {
            return $ENTRIES;
        }

        public static Orientation valueOf(String str) {
            return (Orientation) Enum.valueOf(Orientation.class, str);
        }

        public static Orientation[] values() {
            return (Orientation[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Gravity.values().length];
            try {
                iArr[Gravity.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Gravity.LEFT_OR_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Gravity.RIGHT_OR_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.orientation = Orientation.HORIZONTAL;
        this.gravity = Gravity.LEFT_OR_TOP;
        this.childGravity = Gravity.CENTER;
        commonInit(context, null);
    }

    private final void commonInit(Context context, AttributeSet attrs) {
        Orientation orientation;
        Gravity gravity;
        Gravity gravity2;
        if (attrs != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.StackLayout);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
            if (obtainStyledAttributes.getInt(2, 0) == 1) {
                orientation = Orientation.VERTICAL;
            } else {
                orientation = Orientation.HORIZONTAL;
            }
            this.orientation = orientation;
            int i = obtainStyledAttributes.getInt(1, 1);
            if (i != 0) {
                if (i != 2) {
                    gravity = Gravity.CENTER;
                } else {
                    gravity = Gravity.RIGHT_OR_BOTTOM;
                }
            } else {
                gravity = Gravity.LEFT_OR_TOP;
            }
            this.gravity = gravity;
            int i2 = obtainStyledAttributes.getInt(0, 1);
            if (i2 != 0) {
                if (i2 != 2) {
                    gravity2 = Gravity.CENTER;
                } else {
                    gravity2 = Gravity.RIGHT_OR_BOTTOM;
                }
            } else {
                gravity2 = Gravity.LEFT_OR_TOP;
            }
            this.childGravity = gravity2;
            setSpacing(obtainStyledAttributes.getDimension(3, this.spacing));
            obtainStyledAttributes.recycle();
        }
    }

    private final void layoutHorizontally(int width, int height) {
        int i;
        int measuredHeight;
        int childCount = getChildCount();
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.gravity.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    i = (width - getPaddingEnd()) - ((int) this.totalChildrenWidth);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                i = getPaddingStart();
            }
        } else {
            i = (width - ((int) this.totalChildrenWidth)) / 2;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                int i4 = WhenMappings.$EnumSwitchMapping$0[this.childGravity.ordinal()];
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 3) {
                            measuredHeight = (getMeasuredHeight() - getPaddingBottom()) - childAt.getMeasuredHeight();
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        measuredHeight = getPaddingTop();
                    }
                } else {
                    measuredHeight = (height - childAt.getMeasuredHeight()) / 2;
                }
                childAt.layout(i, measuredHeight, childAt.getMeasuredWidth() + i, childAt.getMeasuredHeight() + measuredHeight);
                i += ((int) this.spacing) + childAt.getMeasuredWidth();
            }
        }
    }

    private final void layoutVertically(int width, int height) {
        int i;
        int measuredWidth;
        int childCount = getChildCount();
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.gravity.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    i = (height - getPaddingBottom()) - ((int) this.totalChildrenHeight);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                i = getPaddingTop();
            }
        } else {
            i = (height - ((int) this.totalChildrenHeight)) / 2;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                int i4 = WhenMappings.$EnumSwitchMapping$0[this.childGravity.ordinal()];
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 3) {
                            measuredWidth = (getMeasuredWidth() - getPaddingEnd()) - childAt.getMeasuredWidth();
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        measuredWidth = getPaddingStart();
                    }
                } else {
                    measuredWidth = (width - childAt.getMeasuredWidth()) / 2;
                }
                childAt.layout(measuredWidth, i, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + i);
                i += ((int) this.spacing) + childAt.getMeasuredHeight();
            }
        }
    }

    private final int resolveMeasureSpec(int wanted, int measureSpec) {
        int size = View.MeasureSpec.getSize(measureSpec);
        if (View.MeasureSpec.getMode(measureSpec) == Integer.MIN_VALUE) {
            return Math.min(size, wanted);
        }
        return size;
    }

    @NotNull
    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final float getSpacing() {
        return this.spacing;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top2, int right, int bottom) {
        int i = right - left;
        int i2 = bottom - top2;
        if (this.orientation == Orientation.HORIZONTAL) {
            layoutHorizontally(i, i2);
        } else {
            layoutVertically(i, i2);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        float paddingStart;
        float paddingTop;
        int paddingBottom;
        this.totalChildrenWidth = 0.0f;
        this.totalChildrenHeight = 0.0f;
        this.maxChildWidth = 0.0f;
        this.maxChildHeight = 0.0f;
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                i++;
                measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
                this.totalChildrenWidth += childAt.getMeasuredWidth();
                this.maxChildWidth = Math.max(this.maxChildWidth, childAt.getMeasuredWidth());
                this.totalChildrenHeight += childAt.getMeasuredHeight();
                this.maxChildHeight = Math.max(this.maxChildHeight, childAt.getMeasuredHeight());
            }
        }
        if (this.orientation == Orientation.HORIZONTAL) {
            float max = this.totalChildrenWidth + (this.spacing * Math.max(0, i - 1));
            this.totalChildrenWidth = max;
            paddingStart = max + getPaddingStart() + getPaddingEnd();
            paddingTop = this.maxChildHeight + getPaddingTop();
            paddingBottom = getPaddingBottom();
        } else {
            this.totalChildrenHeight += this.spacing * Math.max(0, i - 1);
            paddingStart = this.maxChildWidth + getPaddingStart() + getPaddingEnd();
            paddingTop = this.totalChildrenHeight + getPaddingTop();
            paddingBottom = getPaddingBottom();
        }
        setMeasuredDimension(resolveMeasureSpec((int) paddingStart, widthMeasureSpec), resolveMeasureSpec((int) (paddingTop + paddingBottom), heightMeasureSpec));
    }

    public final void setOrientation(@NotNull Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "<set-?>");
        this.orientation = orientation;
    }

    public final void setSpacing(float f) {
        this.spacing = f;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.orientation = Orientation.HORIZONTAL;
        this.gravity = Gravity.LEFT_OR_TOP;
        this.childGravity = Gravity.CENTER;
        commonInit(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.orientation = Orientation.HORIZONTAL;
        this.gravity = Gravity.LEFT_OR_TOP;
        this.childGravity = Gravity.CENTER;
        commonInit(context, attributeSet);
    }
}
