package wc;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import tc.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class b {
    public static void b(View view, e eVar, final vc.a aVar) {
        try {
            if (view instanceof CoordinatorLayout) {
                eVar.i().setEnableNestedScroll(false);
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    AppBarLayout childAt = viewGroup.getChildAt(childCount);
                    if (childAt instanceof AppBarLayout) {
                        childAt.addOnOffsetChangedListener(new AppBarLayout.h() { // from class: wc.a
                            public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                                b.c(vc.a.this, appBarLayout, i);
                            }
                        });
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(vc.a aVar, AppBarLayout appBarLayout, int i) {
        boolean z;
        boolean z2 = false;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (appBarLayout.getTotalScrollRange() + i <= 0) {
            z2 = true;
        }
        aVar.j(z, z2);
    }
}
