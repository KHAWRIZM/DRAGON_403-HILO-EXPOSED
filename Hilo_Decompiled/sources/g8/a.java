package g8;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.view.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f١٤٤٣٢a = {R.attr.theme, androidx.appcompat.R.attr.theme};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f١٤٤٣٣b = {com.google.android.material.R.attr.materialThemeOverlay};

    private static int a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f١٤٤٣٢a);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        if (resourceId == 0) {
            return resourceId2;
        }
        return resourceId;
    }

    private static int[] b(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11) {
        int[] iArr2 = new int[iArr.length];
        if (iArr.length > 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, i11);
            for (int i12 = 0; i12 < iArr.length; i12++) {
                iArr2[i12] = obtainStyledAttributes.getResourceId(i12, 0);
            }
            obtainStyledAttributes.recycle();
        }
        return iArr2;
    }

    private static int c(Context context, AttributeSet attributeSet, int i10, int i11) {
        return b(context, attributeSet, f١٤٤٣٣b, i10, i11)[0];
    }

    public static Context d(Context context, AttributeSet attributeSet, int i10, int i11) {
        return e(context, attributeSet, i10, i11, new int[0]);
    }

    public static Context e(Context context, AttributeSet attributeSet, int i10, int i11, int[] iArr) {
        boolean z10;
        int c10 = c(context, attributeSet, i10, i11);
        if ((context instanceof d) && ((d) context).c() == c10) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (c10 != 0 && !z10) {
            d dVar = new d(context, c10);
            for (int i12 : b(context, attributeSet, iArr, i10, i11)) {
                if (i12 != 0) {
                    dVar.getTheme().applyStyle(i12, true);
                }
            }
            int a10 = a(context, attributeSet);
            if (a10 != 0) {
                dVar.getTheme().applyStyle(a10, true);
            }
            return dVar;
        }
        return context;
    }
}
