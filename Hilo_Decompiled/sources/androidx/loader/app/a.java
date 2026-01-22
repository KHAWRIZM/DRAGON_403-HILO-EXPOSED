package androidx.loader.app;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a {

    /* renamed from: androidx.loader.app.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface InterfaceC٠٠٤٣a {
        androidx.loader.content.b onCreateLoader(int i10, Bundle bundle);

        void onLoadFinished(androidx.loader.content.b bVar, Object obj);

        void onLoaderReset(androidx.loader.content.b bVar);
    }

    public static a b(LifecycleOwner lifecycleOwner) {
        return new b(lifecycleOwner, ((ViewModelStoreOwner) lifecycleOwner).getViewModelStore());
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract androidx.loader.content.b c(int i10, Bundle bundle, InterfaceC٠٠٤٣a r32);

    public abstract void d();
}
