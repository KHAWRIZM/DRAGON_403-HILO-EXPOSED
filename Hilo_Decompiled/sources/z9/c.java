package z9;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import ca.d;
import java.util.List;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class c extends a {
    public c(FragmentActivity fragmentActivity, FragmentManager fragmentManager) {
        super(fragmentActivity, fragmentManager);
    }

    @Override // z9.a
    public void a(List list, fa.a aVar, x9.b bVar) {
        y9.c cVar;
        fa.a aVar2 = fa.a.REQUEST_PERMISSIONS;
        if (aVar == aVar2) {
            cVar = new ba.b();
        } else {
            cVar = new ba.c();
        }
        int i10 = 65535;
        if (aVar == aVar2) {
            try {
                ((FragmentActivity) c()).validateRequestPermissionsRequestCode(65535);
            } catch (IllegalArgumentException unused) {
                i10 = KotlinVersion.MAX_COMPONENT_VALUE;
            } catch (Exception unused2) {
            }
        }
        cVar.setArguments(b(list, d.a(i10)));
        cVar.setRetainInstance(true);
        cVar.b(true);
        cVar.c(bVar);
        cVar.a((FragmentManager) d());
    }
}
