package com.luck.picture.lib.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class ActivityCompatHelper {
    private static final int MIN_FRAGMENT_COUNT = 1;

    public static boolean assertValidRequest(Context context) {
        if (context instanceof Activity) {
            return !isDestroy((Activity) context);
        }
        if (context instanceof ContextWrapper) {
            if (((ContextWrapper) context).getBaseContext() instanceof Activity) {
                return !isDestroy((Activity) r2.getBaseContext());
            }
        }
        return true;
    }

    public static boolean checkFragmentNonExits(FragmentActivity fragmentActivity, String str) {
        if (isDestroy(fragmentActivity) || fragmentActivity.getSupportFragmentManager().findFragmentByTag(str) != null) {
            return false;
        }
        return true;
    }

    public static boolean checkRootFragment(FragmentActivity fragmentActivity) {
        if (isDestroy(fragmentActivity) || fragmentActivity.getSupportFragmentManager().getBackStackEntryCount() != 1) {
            return false;
        }
        return true;
    }

    public static boolean isDestroy(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return true;
        }
        return false;
    }
}
