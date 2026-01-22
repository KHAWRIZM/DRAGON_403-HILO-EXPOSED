package com.qhqc.core.basic.widget.svprogresshud;

import com.qhqc.core.basic.widget.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/qhqc/core/basic/widget/svprogresshud/SVProgressHUDAnimateUtil;", "", "()V", "INVALID", "", "getAnimationResource", "gravity", "isInAnimation", "", "basic_widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class SVProgressHUDAnimateUtil {

    @NotNull
    public static final SVProgressHUDAnimateUtil INSTANCE = new SVProgressHUDAnimateUtil();
    private static final int INVALID = -1;

    private SVProgressHUDAnimateUtil() {
    }

    public final int getAnimationResource(int gravity, boolean isInAnimation) {
        if (gravity != 17) {
            if (gravity != 48) {
                if (gravity != 80) {
                    return -1;
                }
                if (isInAnimation) {
                    return R.anim.svslide_in_bottom;
                }
                return R.anim.svslide_out_bottom;
            }
            if (isInAnimation) {
                return R.anim.svslide_in_top;
            }
            return R.anim.svslide_out_top;
        }
        if (isInAnimation) {
            return R.anim.svfade_in_center;
        }
        return R.anim.svfade_out_center;
    }
}
