package mc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class b extends c {
    public b(Context context, CompoundButton compoundButton, AttributeSet attributeSet) {
        super(context, compoundButton, attributeSet);
    }

    @Override // mc.c
    protected boolean N() {
        View view = this.F0;
        if (view != null) {
            return ((CompoundButton) view).isChecked();
        }
        return false;
    }
}
