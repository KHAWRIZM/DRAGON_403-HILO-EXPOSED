package ic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.appcompat.R;
import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f١٤٨٩٤a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f١٤٨٩٥b = {R.attr.colorPrimary};

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final ThreadLocal f١٤٨٩٦a = new ThreadLocal();

        /* renamed from: b, reason: collision with root package name */
        private static final ThreadLocal f١٤٨٩٧b = new ThreadLocal();

        static void a(ViewParent viewParent, View view, Matrix matrix) {
            Object parent = view.getParent();
            if ((parent instanceof View) && parent != viewParent) {
                a(viewParent, (View) parent, matrix);
                matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
            }
            matrix.preTranslate(view.getLeft(), view.getTop());
            if (!view.getMatrix().isIdentity()) {
                matrix.preConcat(view.getMatrix());
            }
        }

        public static void b(ViewGroup viewGroup, View view, Rect rect) {
            ThreadLocal threadLocal = f١٤٨٩٦a;
            Matrix matrix = (Matrix) threadLocal.get();
            if (matrix == null) {
                matrix = new Matrix();
                threadLocal.set(matrix);
            } else {
                matrix.reset();
            }
            a(viewGroup, view, matrix);
            ThreadLocal threadLocal2 = f١٤٨٩٧b;
            RectF rectF = (RectF) threadLocal2.get();
            if (rectF == null) {
                rectF = new RectF();
                threadLocal2.set(rectF);
            }
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
        }
    }

    public static void a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f١٤٨٩٥b);
        boolean hasValue = obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        if (hasValue) {
        } else {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }

    public static int b() {
        return View.generateViewId();
    }

    public static void c(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        a.b(viewGroup, view, rect);
    }

    public static l d(View view) {
        int i10 = com.qmuiteam.qmui.R.id.qmui_view_offset_helper;
        Object tag = view.getTag(i10);
        if (tag instanceof l) {
            return (l) tag;
        }
        l lVar = new l(view);
        view.setTag(i10, lVar);
        return lVar;
    }

    public static void e(View view, boolean z10) {
        ViewParent parent = view.getParent();
        if (parent != null) {
            for (ViewParent viewParent = parent; viewParent != null; viewParent = viewParent.getParent()) {
                if (viewParent instanceof QMUIPullRefreshLayout) {
                    ((QMUIPullRefreshLayout) viewParent).z();
                }
            }
            parent.requestDisallowInterceptTouchEvent(z10);
        }
    }

    public static void f(ImageView imageView, boolean z10) {
        Drawable drawable = imageView.getDrawable();
        if (drawable == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        imageView.setSelected(z10);
        if (drawable.getIntrinsicWidth() != intrinsicWidth || drawable.getIntrinsicHeight() != intrinsicHeight) {
            imageView.requestLayout();
        }
    }

    public static void g(View view, Drawable drawable) {
        int[] iArr = {view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
        view.setBackground(drawable);
        view.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
    }
}
