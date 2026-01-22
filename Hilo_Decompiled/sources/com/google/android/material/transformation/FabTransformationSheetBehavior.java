package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.transformation.FabTransformationBehavior;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.HashMap;
import java.util.Map;
import p7.h;
import p7.j;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: i, reason: collision with root package name */
    private Map f١٠٣٧٢i;

    public FabTransformationSheetBehavior() {
    }

    private void m0(View view, boolean z10) {
        boolean z11;
        ViewParent parent = view.getParent();
        if (!(parent instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
        int childCount = coordinatorLayout.getChildCount();
        if (z10) {
            this.f١٠٣٧٢i = new HashMap(childCount);
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = coordinatorLayout.getChildAt(i10);
            if ((childAt.getLayoutParams() instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) childAt.getLayoutParams()).f() instanceof FabTransformationScrimBehavior)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (childAt != view && !z11) {
                if (!z10) {
                    Map map = this.f١٠٣٧٢i;
                    if (map != null && map.containsKey(childAt)) {
                        childAt.setImportantForAccessibility(((Integer) this.f١٠٣٧٢i.get(childAt)).intValue());
                    }
                } else {
                    this.f١٠٣٧٢i.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    childAt.setImportantForAccessibility(4);
                }
            }
        }
        if (!z10) {
            this.f١٠٣٧٢i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public boolean N(View view, View view2, boolean z10, boolean z11) {
        m0(view2, z10);
        return super.N(view, view2, z10, z11);
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    protected FabTransformationBehavior.e k0(Context context, boolean z10) {
        int i10;
        if (z10) {
            i10 = R.animator.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            i10 = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationBehavior.e eVar = new FabTransformationBehavior.e();
        eVar.f١٠٣٦٥a = h.d(context, i10);
        eVar.f١٠٣٦٦b = new j(17, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
        return eVar;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
