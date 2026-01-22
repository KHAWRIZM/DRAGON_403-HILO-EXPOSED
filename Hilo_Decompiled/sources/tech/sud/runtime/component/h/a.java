package tech.sud.runtime.component.h;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class a {
    public static boolean a(Context context, String str) {
        if (str.startsWith("file:////android_asset/")) {
            str = str.substring(23);
        }
        boolean z = false;
        try {
            InputStream open = context.getResources().getAssets().open(str);
            if (open != null) {
                z = true;
            }
            if (open != null) {
                open.close();
            }
        } catch (IOException | Exception unused) {
        }
        return z;
    }
}
