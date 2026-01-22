package ja;

import android.app.Activity;
import android.content.Intent;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f١٥٣٦٥a;

    public c(Activity activity) {
        this.f١٥٣٦٥a = activity;
    }

    @Override // ja.a
    public void startActivity(Intent intent) {
        this.f١٥٣٦٥a.startActivity(intent);
    }

    @Override // ja.a
    public void startActivityForResult(Intent intent, int i10) {
        this.f١٥٣٦٥a.startActivityForResult(intent, i10);
    }
}
