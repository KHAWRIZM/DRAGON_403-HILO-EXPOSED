package f2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import kotlin.text.Typography;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface a extends IInterface {

    /* renamed from: e, reason: collision with root package name */
    public static final String f١٤٠٤٨e = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace(Typography.dollar, '.');

    /* renamed from: f2.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class AbstractBinderC٠١٥٩a extends Binder implements a {

        /* renamed from: f2.a$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        private static class C٠١٦٠a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f١٤٠٤٩a;

            C٠١٦٠a(IBinder iBinder) {
                this.f١٤٠٤٩a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f١٤٠٤٩a;
            }
        }

        public static a c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a.f١٤٠٤٨e);
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C٠١٦٠a(iBinder);
        }
    }
}
