package aa;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a extends Fragment implements y9.c {
    @Override // y9.d
    public void b(boolean z10) {
        e().q(z10);
    }

    @Override // y9.d
    public void c(x9.b bVar) {
        e().r(bVar);
    }

    @Override // y9.d
    public void d() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        fragmentManager.beginTransaction().remove(this).commitAllowingStateLoss();
    }

    @Override // y9.d
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void a(FragmentManager fragmentManager) {
        if (fragmentManager == null) {
            return;
        }
        fragmentManager.beginTransaction().add(this, toString()).commitAllowingStateLoss();
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        e().k(i10, i11, intent);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        e().l();
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        e().m(i10, strArr, iArr);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        e().n();
    }
}
