package androidx.viewpager2.widget;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.view.View;
import androidx.core.view.d1;
import androidx.core.view.d2;
import androidx.core.view.j0;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class WindowInsetsApplier implements j0 {
    private WindowInsetsApplier() {
    }

    private d2 consumeAllInsets(d2 d2Var) {
        d2 d2Var2 = d2.f٢٩٣٥b;
        if (d2Var2.w() != null) {
            return d2Var2;
        }
        return d2Var.c().b();
    }

    public static boolean install(ViewPager2 viewPager2) {
        ApplicationInfo applicationInfo = viewPager2.getContext().getApplicationInfo();
        if (Build.VERSION.SDK_INT >= 30 && applicationInfo.targetSdkVersion >= 30) {
            return false;
        }
        d1.E0(viewPager2, new WindowInsetsApplier());
        return true;
    }

    @Override // androidx.core.view.j0
    public d2 onApplyWindowInsets(View view, d2 d2Var) {
        ViewPager2 viewPager2 = (ViewPager2) view;
        d2 c02 = d1.c0(viewPager2, d2Var);
        if (c02.q()) {
            return c02;
        }
        RecyclerView recyclerView = viewPager2.mRecyclerView;
        int childCount = recyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            d1.j(recyclerView.getChildAt(i10), new d2(c02));
        }
        return consumeAllInsets(c02);
    }
}
