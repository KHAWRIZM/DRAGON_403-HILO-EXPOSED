package androidx.activity.result;

import android.annotation.SuppressLint;
import androidx.activity.result.contract.ActivityResultContract;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class d {
    public abstract ActivityResultContract getContract();

    public void launch(@SuppressLint({"UnknownNullness"}) Object obj) {
        launch(obj, null);
    }

    public abstract void launch(Object obj, androidx.core.app.c cVar);

    public abstract void unregister();
}
