package androidx.transition;

import android.view.ViewGroup;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class j {
    public static j a(ViewGroup viewGroup) {
        androidx.appcompat.app.a0.a(viewGroup.getTag(R.id.transition_current_scene));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(ViewGroup viewGroup, j jVar) {
        viewGroup.setTag(R.id.transition_current_scene, jVar);
    }
}
