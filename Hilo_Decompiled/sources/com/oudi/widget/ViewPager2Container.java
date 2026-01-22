package com.oudi.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0015J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J(\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\u0003J(\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/oudi/widget/ViewPager2Container;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mViewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "startX", "", "startY", "touchSlop", "onFinishInflate", "", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "handleHorizontalScroll", "vp", "endX", "disX", "disY", "handleVerticalScroll", "endY", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ViewPager2Container extends FrameLayout {

    @Nullable
    private ViewPager2 mViewPager2;
    private float startX;
    private float startY;
    private int touchSlop;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ViewPager2Container(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
    
        getParent().requestDisallowInterceptTouchEvent(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
    
        return;
     */
    @RequiresApi(17)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleHorizontalScroll(ViewPager2 vp, float endX, float disX, float disY) {
        int i10;
        boolean z10;
        if (disY > disX) {
            getParent().requestDisallowInterceptTouchEvent(false);
            return;
        }
        int currentItem = vp.getCurrentItem();
        RecyclerView.Adapter adapter = vp.getAdapter();
        if (adapter != null) {
            i10 = adapter.getItemCount();
        } else {
            i10 = 0;
        }
        if (getLayoutDirection() == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        float f10 = endX - this.startX;
        if (currentItem == 0) {
            if (z10) {
                getParent().requestDisallowInterceptTouchEvent(true);
                return;
            } else {
                getParent().requestDisallowInterceptTouchEvent(true);
                return;
            }
        }
        if (currentItem == i10 - 1) {
            if (!z10 ? f10 < DownloadProgress.UNKNOWN_PROGRESS : f10 > DownloadProgress.UNKNOWN_PROGRESS) {
                getParent().requestDisallowInterceptTouchEvent(false);
                return;
            } else {
                getParent().requestDisallowInterceptTouchEvent(true);
                return;
            }
        }
        getParent().requestDisallowInterceptTouchEvent(true);
    }

    private final void handleVerticalScroll(ViewPager2 vp, float endY, float disX, float disY) {
        int i10;
        if (disX > disY) {
            getParent().requestDisallowInterceptTouchEvent(false);
            return;
        }
        int currentItem = vp.getCurrentItem();
        RecyclerView.Adapter adapter = vp.getAdapter();
        if (adapter != null) {
            i10 = adapter.getItemCount();
        } else {
            i10 = 0;
        }
        float f10 = endY - this.startY;
        if (currentItem == 0 && f10 > DownloadProgress.UNKNOWN_PROGRESS) {
            getParent().requestDisallowInterceptTouchEvent(false);
        } else if (currentItem == i10 - 1 && f10 < DownloadProgress.UNKNOWN_PROGRESS) {
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.view.View
    @RequiresApi(3)
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            View childAt = getChildAt(i10);
            if (childAt instanceof ViewPager2) {
                this.mViewPager2 = (ViewPager2) childAt;
                break;
            }
            i10++;
        }
        if (this.mViewPager2 != null) {
            this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            return;
        }
        throw new IllegalStateException("The root child of ViewPager2Container must contain a ViewPager2");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
    
        if (r1 != 3) goto L٣٧;
     */
    @Override // android.view.ViewGroup
    @RequiresApi(17)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev) {
        int i10;
        boolean z10;
        Intrinsics.checkNotNullParameter(ev, "ev");
        ViewPager2 viewPager2 = this.mViewPager2;
        if (viewPager2 == null) {
            return super.onInterceptTouchEvent(ev);
        }
        boolean isUserInputEnabled = viewPager2.isUserInputEnabled();
        RecyclerView.Adapter adapter = viewPager2.getAdapter();
        if (adapter != null) {
            i10 = adapter.getItemCount();
        } else {
            i10 = 0;
        }
        if (i10 > 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (isUserInputEnabled && z10) {
            int action = ev.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float x10 = ev.getX();
                        float y10 = ev.getY();
                        float abs = Math.abs(x10 - this.startX);
                        float abs2 = Math.abs(y10 - this.startY);
                        float f10 = this.touchSlop;
                        if (abs < f10 && abs2 < f10) {
                            return super.onInterceptTouchEvent(ev);
                        }
                        if (viewPager2.getOrientation() == 1) {
                            handleVerticalScroll(viewPager2, y10, abs, abs2);
                        } else {
                            handleHorizontalScroll(viewPager2, x10, abs, abs2);
                        }
                    }
                }
                getParent().requestDisallowInterceptTouchEvent(false);
            } else {
                this.startX = ev.getX();
                this.startY = ev.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(ev);
        }
        return super.onInterceptTouchEvent(ev);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ViewPager2Container(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ViewPager2Container(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ViewPager2Container(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
