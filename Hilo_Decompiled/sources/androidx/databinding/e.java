package androidx.databinding;

import android.view.View;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class e {
    public List collectDependencies() {
        return Collections.emptyList();
    }

    public abstract ViewDataBinding getDataBinder(f fVar, View view, int i10);

    public abstract ViewDataBinding getDataBinder(f fVar, View[] viewArr, int i10);

    public abstract int getLayoutId(String str);
}
