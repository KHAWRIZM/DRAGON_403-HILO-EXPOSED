package androidx.databinding;

import android.R;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    private static e f٣٢٢١a = new DataBinderMapperImpl();

    public static ViewDataBinding a(View view) {
        return b(view, null);
    }

    public static ViewDataBinding b(View view, f fVar) {
        ViewDataBinding f10 = f(view);
        if (f10 != null) {
            return f10;
        }
        Object tag = view.getTag();
        if (tag instanceof String) {
            int layoutId = f٣٢٢١a.getLayoutId((String) tag);
            if (layoutId != 0) {
                return f٣٢٢١a.getDataBinder(fVar, view, layoutId);
            }
            throw new IllegalArgumentException("View is not a binding layout. Tag: " + tag);
        }
        throw new IllegalArgumentException("View is not a binding layout");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewDataBinding c(f fVar, View view, int i10) {
        return f٣٢٢١a.getDataBinder(fVar, view, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewDataBinding d(f fVar, View[] viewArr, int i10) {
        return f٣٢٢١a.getDataBinder(fVar, viewArr, i10);
    }

    private static ViewDataBinding e(f fVar, ViewGroup viewGroup, int i10, int i11) {
        int childCount = viewGroup.getChildCount();
        int i12 = childCount - i10;
        if (i12 == 1) {
            return c(fVar, viewGroup.getChildAt(childCount - 1), i11);
        }
        View[] viewArr = new View[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            viewArr[i13] = viewGroup.getChildAt(i13 + i10);
        }
        return d(fVar, viewArr, i11);
    }

    public static ViewDataBinding f(View view) {
        return ViewDataBinding.getBinding(view);
    }

    public static f g() {
        return null;
    }

    public static ViewDataBinding h(LayoutInflater layoutInflater, int i10, ViewGroup viewGroup, boolean z10) {
        return i(layoutInflater, i10, viewGroup, z10, null);
    }

    public static ViewDataBinding i(LayoutInflater layoutInflater, int i10, ViewGroup viewGroup, boolean z10, f fVar) {
        boolean z11;
        int i11 = 0;
        if (viewGroup != null && z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = viewGroup.getChildCount();
        }
        View inflate = layoutInflater.inflate(i10, viewGroup, z10);
        if (z11) {
            return e(fVar, viewGroup, i11, i10);
        }
        return c(fVar, inflate, i10);
    }

    public static ViewDataBinding j(Activity activity, int i10) {
        return k(activity, i10, null);
    }

    public static ViewDataBinding k(Activity activity, int i10, f fVar) {
        activity.setContentView(i10);
        return e(fVar, (ViewGroup) activity.getWindow().getDecorView().findViewById(R.id.content), 0, i10);
    }
}
