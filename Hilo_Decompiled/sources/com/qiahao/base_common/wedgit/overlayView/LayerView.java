package com.qiahao.base_common.wedgit.overlayView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.qiahao.base_common.model.overlay.Location;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001GB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ0\u0010/\u001a\u00020#2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\nH\u0014J\u0010\u00106\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0014J\u0010\u00107\u001a\u0002012\u0006\u00108\u001a\u000209H\u0016J\u000e\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020\u000eJ4\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u001fJ\u001c\u0010D\u001a\u000201*\u00020\u000e2\u0006\u0010E\u001a\u00020\u00192\u0006\u0010F\u001a\u00020\u0019H\u0002R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R|\u0010\u001b\u001ad\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0002\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0\u001f¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020#\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R7\u0010(\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020#\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006H"}, d2 = {"Lcom/qiahao/base_common/wedgit/overlayView/LayerView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "targetRectList", "", "Landroid/graphics/Rect;", "backColor", "getBackColor", "()I", "setBackColor", "(I)V", "paint", "Landroid/graphics/Paint;", "porterDuffXMode", "Landroid/graphics/PorterDuffXfermode;", "downX", "", "downY", "drawCallBack", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "", "rectList", "Landroid/graphics/Canvas;", "canvas", "", "getDrawCallBack", "()Lkotlin/jvm/functions/Function4;", "setDrawCallBack", "(Lkotlin/jvm/functions/Function4;)V", "targetClickListener", "Lkotlin/Function1;", FirebaseAnalytics.Param.INDEX, "getTargetClickListener", "()Lkotlin/jvm/functions/Function1;", "setTargetClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onLayout", "changed", "", "l", "t", "r", "b", "dispatchDraw", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "addTargetsRect", "rect", "addExtraView", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "targetIndex", "verticalOffset", "horizontalOffset", "locateList", "Lcom/qiahao/base_common/model/overlay/Location;", "contains", "x", "y", "LocBean", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLayerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayerView.kt\ncom/qiahao/base_common/wedgit/overlayView/LayerView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,220:1\n1869#2,2:221\n1563#2:223\n1634#2,3:224\n*S KotlinDebug\n*F\n+ 1 LayerView.kt\ncom/qiahao/base_common/wedgit/overlayView/LayerView\n*L\n66#1:221,2\n156#1:223\n156#1:224,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class LayerView extends RelativeLayout {
    private int backColor;
    private float downX;
    private float downY;

    @Nullable
    private Function4<? super Context, ? super List<Rect>, ? super Canvas, ? super Paint, Unit> drawCallBack;

    @NotNull
    private final Paint paint;

    @NotNull
    private final PorterDuffXfermode porterDuffXMode;

    @Nullable
    private Function1<? super Integer, Unit> targetClickListener;

    @NotNull
    private final List<Rect> targetRectList;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J7\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000e¨\u0006\""}, d2 = {"Lcom/qiahao/base_common/wedgit/overlayView/LayerView$LocBean;", "", "targetIndex", "", "locateList", "", "Lcom/qiahao/base_common/model/overlay/Location;", "verticalOffset", "horizontalOffset", "<init>", "(ILjava/util/List;II)V", "getTargetIndex", "()I", "setTargetIndex", "(I)V", "getLocateList", "()Ljava/util/List;", "setLocateList", "(Ljava/util/List;)V", "getVerticalOffset", "setVerticalOffset", "getHorizontalOffset", "setHorizontalOffset", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private static final /* data */ class LocBean {
        private int horizontalOffset;

        @NotNull
        private List<? extends Location> locateList;
        private int targetIndex;
        private int verticalOffset;

        public LocBean(int i10, @NotNull List<? extends Location> locateList, int i11, int i12) {
            Intrinsics.checkNotNullParameter(locateList, "locateList");
            this.targetIndex = i10;
            this.locateList = locateList;
            this.verticalOffset = i11;
            this.horizontalOffset = i12;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LocBean copy$default(LocBean locBean, int i10, List list, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i10 = locBean.targetIndex;
            }
            if ((i13 & 2) != 0) {
                list = locBean.locateList;
            }
            if ((i13 & 4) != 0) {
                i11 = locBean.verticalOffset;
            }
            if ((i13 & 8) != 0) {
                i12 = locBean.horizontalOffset;
            }
            return locBean.copy(i10, list, i11, i12);
        }

        /* renamed from: component1, reason: from getter */
        public final int getTargetIndex() {
            return this.targetIndex;
        }

        @NotNull
        public final List<Location> component2() {
            return this.locateList;
        }

        /* renamed from: component3, reason: from getter */
        public final int getVerticalOffset() {
            return this.verticalOffset;
        }

        /* renamed from: component4, reason: from getter */
        public final int getHorizontalOffset() {
            return this.horizontalOffset;
        }

        @NotNull
        public final LocBean copy(int targetIndex, @NotNull List<? extends Location> locateList, int verticalOffset, int horizontalOffset) {
            Intrinsics.checkNotNullParameter(locateList, "locateList");
            return new LocBean(targetIndex, locateList, verticalOffset, horizontalOffset);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LocBean)) {
                return false;
            }
            LocBean locBean = (LocBean) other;
            return this.targetIndex == locBean.targetIndex && Intrinsics.areEqual(this.locateList, locBean.locateList) && this.verticalOffset == locBean.verticalOffset && this.horizontalOffset == locBean.horizontalOffset;
        }

        public final int getHorizontalOffset() {
            return this.horizontalOffset;
        }

        @NotNull
        public final List<Location> getLocateList() {
            return this.locateList;
        }

        public final int getTargetIndex() {
            return this.targetIndex;
        }

        public final int getVerticalOffset() {
            return this.verticalOffset;
        }

        public int hashCode() {
            return (((((this.targetIndex * 31) + this.locateList.hashCode()) * 31) + this.verticalOffset) * 31) + this.horizontalOffset;
        }

        public final void setHorizontalOffset(int i10) {
            this.horizontalOffset = i10;
        }

        public final void setLocateList(@NotNull List<? extends Location> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.locateList = list;
        }

        public final void setTargetIndex(int i10) {
            this.targetIndex = i10;
        }

        public final void setVerticalOffset(int i10) {
            this.verticalOffset = i10;
        }

        @NotNull
        public String toString() {
            return "LocBean(targetIndex=" + this.targetIndex + ", locateList=" + this.locateList + ", verticalOffset=" + this.verticalOffset + ", horizontalOffset=" + this.horizontalOffset + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Location.values().length];
            try {
                iArr[Location.TO_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Location.TO_BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Location.TO_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Location.TO_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Location.COVER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Location.ALIGN_TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Location.ALIGN_BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Location.ALIGN_LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Location.ALIGN_RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[Location.ALIGN_PARENT_RIGHT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayerView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.targetRectList = new ArrayList();
        this.backColor = 1610612736;
        this.paint = new Paint();
        this.porterDuffXMode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        setLayerType(1, null);
    }

    private final boolean contains(Rect rect, float f10, float f11) {
        int i10;
        int i11;
        int i12 = rect.left;
        int i13 = rect.right;
        if (i12 < i13 && (i10 = rect.top) < (i11 = rect.bottom) && f10 >= i12 && f10 < i13 && f11 >= i10 && f11 < i11) {
            return true;
        }
        return false;
    }

    public final void addExtraView(@NotNull View view, int targetIndex, int verticalOffset, int horizontalOffset, @NotNull List<? extends Location> locateList) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(locateList, "locateList");
        view.setTag(new LocBean(targetIndex, locateList, verticalOffset, horizontalOffset));
        addView(view);
    }

    public final void addTargetsRect(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.targetRectList.add(rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.drawColor(this.backColor);
        this.paint.reset();
        this.paint.setAntiAlias(true);
        this.paint.setXfermode(this.porterDuffXMode);
        Rect viewAbsRect = HighLightUtils.INSTANCE.getViewAbsRect(this);
        List<Rect> list = this.targetRectList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Rect rect : list) {
            rect.offset(-viewAbsRect.left, -viewAbsRect.top);
            arrayList.add(rect);
        }
        Function4<? super Context, ? super List<Rect>, ? super Canvas, ? super Paint, Unit> function4 = this.drawCallBack;
        if (function4 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            function4.invoke(context, arrayList, canvas, this.paint);
        }
        super.dispatchDraw(canvas);
    }

    public final int getBackColor() {
        return this.backColor;
    }

    @Nullable
    public final Function4<Context, List<Rect>, Canvas, Paint, Unit> getDrawCallBack() {
        return this.drawCallBack;
    }

    @Nullable
    public final Function1<Integer, Unit> getTargetClickListener() {
        return this.targetClickListener;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x006f. Please report as an issue. */
    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l10, int t10, int r10, int b10) {
        int i10;
        Rect viewAbsRect = HighLightUtils.INSTANCE.getViewAbsRect(this);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            Object tag = childAt.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.qiahao.base_common.wedgit.overlayView.LayerView.LocBean");
            LocBean locBean = (LocBean) tag;
            int size = this.targetRectList.size();
            int targetIndex = locBean.getTargetIndex();
            if (targetIndex >= 0 && targetIndex < size) {
                Rect rect = this.targetRectList.get(locBean.getTargetIndex());
                int i12 = (rect.left + rect.right) / 2;
                int i13 = (rect.top + rect.bottom) / 2;
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                Iterator<T> it = locBean.getLocateList().iterator();
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                while (it.hasNext()) {
                    switch (WhenMappings.$EnumSwitchMapping$0[((Location) it.next()).ordinal()]) {
                        case 1:
                            if (i17 == 0) {
                                i17 = i12 - (measuredWidth / 2);
                            }
                            i10 = rect.top;
                            int i18 = i10 - measuredHeight;
                            if (i15 == 0) {
                                i15 = (measuredWidth / 2) + i12;
                            }
                            i16 = i18;
                            i14 = i10;
                        case 2:
                            if (i17 == 0) {
                                i17 = i12 - (measuredWidth / 2);
                            }
                            int i19 = rect.bottom;
                            if (i15 == 0) {
                                i15 = i12 + (measuredWidth / 2);
                            }
                            i16 = i19;
                            i14 = i16 + measuredHeight;
                        case 3:
                            int i20 = rect.left;
                            int i21 = i20 - measuredWidth;
                            if (i16 == 0) {
                                i16 = i13 - (measuredHeight / 2);
                            }
                            if (i14 == 0) {
                                i14 = (measuredHeight / 2) + i13;
                            }
                            i17 = i21;
                            i15 = i20;
                        case 4:
                            int i22 = rect.right;
                            if (i16 == 0) {
                                i16 = i13 - (measuredHeight / 2);
                            }
                            i15 = i22 + measuredWidth;
                            if (i14 == 0) {
                                i14 = (measuredHeight / 2) + i13;
                            }
                            i17 = i22;
                        case 5:
                            int i23 = rect.left;
                            i16 = rect.top;
                            i15 = rect.right;
                            i10 = rect.bottom;
                            i17 = i23;
                            i14 = i10;
                        case 6:
                            if (i17 == 0) {
                                i17 = i12 - (measuredWidth / 2);
                            }
                            int i24 = rect.top;
                            if (i15 == 0) {
                                i15 = (measuredWidth / 2) + i12;
                            }
                            i16 = i24;
                            i14 = i16 + measuredHeight;
                        case 7:
                            if (i17 == 0) {
                                i17 = i12 - (measuredWidth / 2);
                            }
                            i14 = rect.bottom;
                            i16 = i14 - measuredHeight;
                            if (i15 == 0) {
                                i15 = (measuredWidth / 2) + i12;
                            }
                        case 8:
                            int i25 = rect.left;
                            if (i16 == 0) {
                                i16 = i13 - (measuredHeight / 2);
                            }
                            int i26 = i25 + measuredWidth;
                            if (i14 == 0) {
                                i14 = (measuredHeight / 2) + i13;
                            }
                            i17 = i25;
                            i15 = i26;
                        case 9:
                            i15 = rect.right;
                            i17 = i15 - measuredWidth;
                            if (i16 == 0) {
                                i16 = i13 - (measuredHeight / 2);
                            }
                            if (i14 == 0) {
                                i14 = (measuredHeight / 2) + i13;
                            }
                        case 10:
                            i15 = viewAbsRect.right;
                            i17 = i15 - measuredWidth;
                            if (i16 == 0) {
                                i16 = i13 - (measuredHeight / 2);
                            }
                            if (i14 == 0) {
                                i14 = (measuredHeight / 2) + i13;
                            }
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }
                childAt.layout((i17 + locBean.getHorizontalOffset()) - viewAbsRect.left, (i16 + locBean.getVerticalOffset()) - viewAbsRect.top, (i15 + locBean.getHorizontalOffset()) - viewAbsRect.left, (i14 + locBean.getVerticalOffset()) - viewAbsRect.top);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Function1<? super Integer, Unit> function1;
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action == 1) {
                performClick();
                float x10 = event.getX();
                float y10 = event.getY();
                if (Math.abs(x10 - this.downX) < 10.0f && Math.abs(y10 - this.downY) < 10.0f && (function1 = this.targetClickListener) != null) {
                    Iterator<T> it = this.targetRectList.iterator();
                    int i10 = 0;
                    while (it.hasNext()) {
                        int i11 = i10 + 1;
                        if (contains((Rect) it.next(), x10, y10)) {
                            function1.invoke(Integer.valueOf(i10));
                            return true;
                        }
                        i10 = i11;
                    }
                    function1.invoke(-1);
                    return true;
                }
            }
            return super.onTouchEvent(event);
        }
        this.downX = event.getX();
        this.downY = event.getY();
        return true;
    }

    public final void setBackColor(int i10) {
        this.backColor = i10;
    }

    public final void setDrawCallBack(@Nullable Function4<? super Context, ? super List<Rect>, ? super Canvas, ? super Paint, Unit> function4) {
        this.drawCallBack = function4;
    }

    public final void setTargetClickListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.targetClickListener = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayerView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.targetRectList = new ArrayList();
        this.backColor = 1610612736;
        this.paint = new Paint();
        this.porterDuffXMode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        setLayerType(1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayerView(@NotNull Context context, @NotNull AttributeSet attrs, int i10) {
        super(context, attrs, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.targetRectList = new ArrayList();
        this.backColor = 1610612736;
        this.paint = new Paint();
        this.porterDuffXMode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        setLayerType(1, null);
    }
}
