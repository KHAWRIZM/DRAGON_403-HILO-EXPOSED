package com.oudi.utils.ktx;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.facebook.share.internal.ShareConstants;
import com.oudi.utils.AppUtils;
import com.oudi.utils.CoroutineUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\b\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\t2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\n\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u000b2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\f\u001a&\u0010\r\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0002\u001a-\u0010\r\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\b¨\u0006\u000f"}, d2 = {"toast", "", "Landroid/content/Context;", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "", "duration", "", "messageResId", "(Landroid/content/Context;Ljava/lang/Integer;I)V", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Ljava/lang/Integer;I)V", "", "(Ljava/lang/Object;Ljava/lang/Integer;I)V", "toastHandler", "context", "lib_utils_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ToastKtxKt {
    public static final void toast(Context context, CharSequence charSequence, int i10) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        toastHandler(context.getApplicationContext(), charSequence, i10);
    }

    public static /* synthetic */ void toast$default(Context context, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        toast(context, charSequence, i10);
    }

    private static final void toastHandler(Context context, CharSequence charSequence, int i10) {
        if (charSequence == null || charSequence.length() == 0) {
            return;
        }
        if (context == null && (context = AppUtils.getApp()) == null) {
            return;
        }
        try {
            Toast.makeText(context, charSequence, i10).show();
        } catch (Exception e10) {
            Log.e("ToastKtx", "toastHandler() thread:" + Thread.currentThread().getName() + " ,e:" + e10);
            CoroutineUtils.main$default(CoroutineUtils.INSTANCE, (CoroutineScope) null, (CoroutineStart) null, new ToastKtxKt$toastHandler$1(context, charSequence, i10, null), 3, (Object) null);
        }
    }

    public static /* synthetic */ void toastHandler$default(Context context, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        toastHandler(context, charSequence, i10);
    }

    public static final void toast(Context context, Integer num, int i10) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        toastHandler(context.getApplicationContext(), num, i10);
    }

    public static /* synthetic */ void toast$default(Context context, Integer num, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        toast(context, num, i10);
    }

    public static /* synthetic */ void toastHandler$default(Context context, Integer num, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        toastHandler(context, num, i10);
    }

    public static final void toast(Fragment fragment, CharSequence charSequence, int i10) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        toastHandler(context != null ? context.getApplicationContext() : null, charSequence, i10);
    }

    public static /* synthetic */ void toast$default(Fragment fragment, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        toast(fragment, charSequence, i10);
    }

    public static final void toast(Fragment fragment, Integer num, int i10) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        toastHandler(context != null ? context.getApplicationContext() : null, num, i10);
    }

    public static /* synthetic */ void toast$default(Fragment fragment, Integer num, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        toast(fragment, num, i10);
    }

    public static final void toast(Object obj, CharSequence charSequence, int i10) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        toastHandler((Context) null, charSequence, i10);
    }

    public static /* synthetic */ void toast$default(Object obj, CharSequence charSequence, int i10, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        toast(obj, charSequence, i10);
    }

    public static final void toast(Object obj, Integer num, int i10) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        toastHandler((Context) null, num, i10);
    }

    public static /* synthetic */ void toast$default(Object obj, Integer num, int i10, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        toast(obj, num, i10);
    }

    private static final void toastHandler(Context context, Integer num, int i10) {
        if (num == null) {
            return;
        }
        if (context == null && (context = AppUtils.getApp()) == null) {
            return;
        }
        toastHandler$default(context, context.getString(num.intValue()), 0, 4, (Object) null);
    }
}
