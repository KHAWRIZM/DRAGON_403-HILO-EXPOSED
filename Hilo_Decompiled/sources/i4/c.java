package i4;

import com.bigkoo.pickerview.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class c {
    public static int a(int i10, boolean z10) {
        if (i10 != 80) {
            return -1;
        }
        if (z10) {
            return R.anim.pickerview_slide_in_bottom;
        }
        return R.anim.pickerview_slide_out_bottom;
    }
}
