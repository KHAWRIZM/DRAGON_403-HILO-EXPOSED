package cf;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class o {
    final Method a;
    final ThreadMode b;
    final Class c;
    final int d;
    final boolean e;
    String f;

    public o(Method method, Class cls, ThreadMode threadMode, int i, boolean z) {
        this.a = method;
        this.b = threadMode;
        this.c = cls;
        this.d = i;
        this.e = z;
    }

    private synchronized void a() {
        if (this.f == null) {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append(this.a.getDeclaringClass().getName());
            sb2.append('#');
            sb2.append(this.a.getName());
            sb2.append('(');
            sb2.append(this.c.getName());
            this.f = sb2.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            a();
            o oVar = (o) obj;
            oVar.a();
            return this.f.equals(oVar.f);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
