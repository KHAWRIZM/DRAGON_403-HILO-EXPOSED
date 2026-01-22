package com.qiahao.base_common.wedgit.overlayView;

import android.app.Activity;
import android.view.View;
import com.qiahao.base_common.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t¨\u0006\r"}, d2 = {"Lcom/qiahao/base_common/wedgit/overlayView/HighLightHelper;", "", "<init>", "()V", "showQuickFolderGuide", "", "activity", "Landroid/app/Activity;", "view1", "Landroid/view/View;", "view2", "view3", "view4", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class HighLightHelper {

    @NotNull
    public static final HighLightHelper INSTANCE = new HighLightHelper();

    private HighLightHelper() {
    }

    public final void showQuickFolderGuide(@NotNull Activity activity, @NotNull View view1, @NotNull View view2, @NotNull View view3, @NotNull View view4) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(view1, "view1");
        Intrinsics.checkNotNullParameter(view2, "view2");
        Intrinsics.checkNotNullParameter(view3, "view3");
        Intrinsics.checkNotNullParameter(view4, "view4");
        HighlightGuideManager highlightGuideManager = new HighlightGuideManager(activity);
        BaseLayer addHighlight = new CommonLayer(activity).addHighlight(view1).addHighlight(view2);
        int i10 = R.drawable.relation_dialog_bg;
        highlightGuideManager.addLayer(addHighlight.withImage(i10)).addLayer(new CommonLayer(activity).addHighlight(view3).addHighlight(view4).withImage(i10)).show();
    }
}
