package tech.sud.runtime.component.c;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class h {
    private static h c = new h();
    private boolean d = false;
    public int a = 0;
    public int b = 0;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class a {
        private static int a = -1;

        public static int a(Context context, int i) {
            if (a < 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((Activity) context).getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
                int i2 = displayMetrics.widthPixels;
                int i3 = displayMetrics.heightPixels;
                if (((i != 0 && i != 2) || i3 <= i2) && ((i != 1 && i != 3) || i2 <= i3)) {
                    a = 1;
                } else {
                    a = 0;
                }
            }
            if (a == 0) {
                if (i == 0) {
                    return 0;
                }
                if (i == 1) {
                    return 1;
                }
                if (i == 2) {
                    return 2;
                }
                if (i == 3) {
                    return 3;
                }
                return 4;
            }
            if (i == 0) {
                return 3;
            }
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            if (i == 3) {
                return 2;
            }
            return 4;
        }
    }

    public static int a(Context context) {
        return a.a(context, ((Activity) context).getWindowManager().getDefaultDisplay().getRotation());
    }

    public static boolean b(Context context) {
        int a2 = a(context);
        if (a2 != 0 && a2 != 2) {
            return false;
        }
        return true;
    }

    public void a(Context context, tech.sud.runtime.core.g gVar) {
        if (this.a == 0 || !this.d) {
            this.d = true;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            if (i > i2) {
                if (b.b()) {
                    this.d = false;
                }
                i2 = i;
                i = i2;
            }
            this.a = i;
            this.b = i2;
            gVar.a(i, i2);
        }
    }
}
