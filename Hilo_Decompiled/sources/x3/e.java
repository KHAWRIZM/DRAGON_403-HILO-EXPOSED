package x3;

import android.util.Log;
import com.airbnb.lottie.m0;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e implements m0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Set f١٨٨٩٩a = new HashSet();

    @Override // com.airbnb.lottie.m0
    public void a(String str) {
        d(str, null);
    }

    @Override // com.airbnb.lottie.m0
    public void b(String str, Throwable th) {
        if (com.airbnb.lottie.e.f٦١٦٠a) {
            Log.d("LOTTIE", str, th);
        }
    }

    @Override // com.airbnb.lottie.m0
    public void c(String str) {
        e(str, null);
    }

    @Override // com.airbnb.lottie.m0
    public void d(String str, Throwable th) {
        Set set = f١٨٨٩٩a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        set.add(str);
    }

    public void e(String str, Throwable th) {
        if (com.airbnb.lottie.e.f٦١٦٠a) {
            Log.d("LOTTIE", str, th);
        }
    }
}
