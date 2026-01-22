package com.oudi.widget;

import android.annotation.SuppressLint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ICleared;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(3)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001a\u001a\u00020\u001bH\u0003J\b\u0010\u001c\u001a\u00020\u001bH\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/oudi/widget/RecyclerViewBlankAreaClickHelper;", "Lcom/oudi/utils/ICleared;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "onClickListener", "Landroid/view/View$OnClickListener;", "getOnClickListener", "()Landroid/view/View$OnClickListener;", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "onLongClickListener", "Landroid/view/View$OnLongClickListener;", "getOnLongClickListener", "()Landroid/view/View$OnLongClickListener;", "setOnLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "Lkotlin/Lazy;", "run", "", "onCleared", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class RecyclerViewBlankAreaClickHelper implements ICleared {

    /* renamed from: gestureDetector$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy gestureDetector;

    @Nullable
    private View.OnClickListener onClickListener;

    @Nullable
    private View.OnLongClickListener onLongClickListener;

    @NotNull
    private final RecyclerView recyclerView;

    public RecyclerViewBlankAreaClickHelper(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
        run();
        this.gestureDetector = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                GestureDetector gestureDetector_delegate$lambda$0;
                gestureDetector_delegate$lambda$0 = RecyclerViewBlankAreaClickHelper.gestureDetector_delegate$lambda$0(RecyclerViewBlankAreaClickHelper.this);
                return gestureDetector_delegate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GestureDetector gestureDetector_delegate$lambda$0(final RecyclerViewBlankAreaClickHelper recyclerViewBlankAreaClickHelper) {
        return new GestureDetector(recyclerViewBlankAreaClickHelper.recyclerView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.oudi.widget.RecyclerViewBlankAreaClickHelper$gestureDetector$2$1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent p02) {
                Intrinsics.checkNotNullParameter(p02, "p0");
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent p02, MotionEvent p12, float p22, float p32) {
                Intrinsics.checkNotNullParameter(p12, "p1");
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent p02) {
                Intrinsics.checkNotNullParameter(p02, "p0");
                View.OnLongClickListener onLongClickListener = RecyclerViewBlankAreaClickHelper.this.getOnLongClickListener();
                if (onLongClickListener != null) {
                    onLongClickListener.onLongClick(RecyclerViewBlankAreaClickHelper.this.getRecyclerView());
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent p02, MotionEvent p12, float p22, float p32) {
                Intrinsics.checkNotNullParameter(p12, "p1");
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent p02) {
                Intrinsics.checkNotNullParameter(p02, "p0");
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent p02) {
                Intrinsics.checkNotNullParameter(p02, "p0");
                View.OnClickListener onClickListener = RecyclerViewBlankAreaClickHelper.this.getOnClickListener();
                if (onClickListener != null) {
                    onClickListener.onClick(RecyclerViewBlankAreaClickHelper.this.getRecyclerView());
                    return false;
                }
                return false;
            }
        });
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.gestureDetector.getValue();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void run() {
        this.recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: com.oudi.widget.q
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean run$lambda$1;
                run$lambda$1 = RecyclerViewBlankAreaClickHelper.run$lambda$1(RecyclerViewBlankAreaClickHelper.this, view, motionEvent);
                return run$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean run$lambda$1(RecyclerViewBlankAreaClickHelper recyclerViewBlankAreaClickHelper, View view, MotionEvent motionEvent) {
        if (view instanceof RecyclerView) {
            return recyclerViewBlankAreaClickHelper.getGestureDetector().onTouchEvent(motionEvent);
        }
        return false;
    }

    @Nullable
    public final View.OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    @Nullable
    public final View.OnLongClickListener getOnLongClickListener() {
        return this.onLongClickListener;
    }

    @NotNull
    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    @Override // com.oudi.utils.ICleared
    @SuppressLint({"ClickableViewAccessibility"})
    public void onCleared() {
        ICleared.DefaultImpls.onCleared(this);
        this.onClickListener = null;
        this.onLongClickListener = null;
        this.recyclerView.setOnTouchListener(null);
    }

    public final void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public final void setOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }
}
