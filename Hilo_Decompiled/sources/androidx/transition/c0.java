package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c0 {

    /* renamed from: b, reason: collision with root package name */
    public View f٤٢٥٩b;

    /* renamed from: a, reason: collision with root package name */
    public final Map f٤٢٥٨a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList f٤٢٦٠c = new ArrayList();

    public c0(View view) {
        this.f٤٢٥٩b = view;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            if (this.f٤٢٥٩b == c0Var.f٤٢٥٩b && this.f٤٢٥٨a.equals(c0Var.f٤٢٥٨a)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (this.f٤٢٥٩b.hashCode() * 31) + this.f٤٢٥٨a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f٤٢٥٩b + "\n") + "    values:";
        for (String str2 : this.f٤٢٥٨a.keySet()) {
            str = str + "    " + str2 + ": " + this.f٤٢٥٨a.get(str2) + "\n";
        }
        return str;
    }
}
