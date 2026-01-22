package z9;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.login.LoginLogger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f١٩٥٢١a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f١٩٥٢٢b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Activity activity, Object obj) {
        this.f١٩٥٢١a = activity;
        this.f١٩٥٢٢b = obj;
    }

    public abstract void a(List list, fa.a aVar, x9.b bVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle b(List list, int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt(LoginLogger.EVENT_EXTRAS_REQUEST_CODE, i10);
        if (list instanceof ArrayList) {
            bundle.putParcelableArrayList("request_permissions", (ArrayList) list);
        } else {
            bundle.putParcelableArrayList("request_permissions", new ArrayList<>(list));
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity c() {
        return this.f١٩٥٢١a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object d() {
        return this.f١٩٥٢٢b;
    }
}
