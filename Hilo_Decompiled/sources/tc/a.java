package tc;

import android.view.View;
import vc.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface a extends i {
    boolean autoOpen(int i, float f, boolean z);

    uc.c getSpinnerStyle();

    View getView();

    boolean isSupportHorizontalDrag();

    int onFinish(f fVar, boolean z);

    void onHorizontalDrag(float f, int i, int i2);

    void onInitialized(e eVar, int i, int i2);

    void onMoving(boolean z, float f, int i, int i2, int i3);

    void onReleased(f fVar, int i, int i2);

    void onStartAnimator(f fVar, int i, int i2);

    void setPrimaryColors(int... iArr);
}
