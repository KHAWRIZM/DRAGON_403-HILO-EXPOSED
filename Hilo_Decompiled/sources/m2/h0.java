package m2;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h0 {

    /* renamed from: a, reason: collision with root package name */
    private final Object f١٥٩٥٥a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a extends AccessibilityNodeProvider {

        /* renamed from: a, reason: collision with root package name */
        final h0 f١٥٩٥٦a;

        a(h0 h0Var) {
            this.f١٥٩٥٦a = h0Var;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i10) {
            g0 b10 = this.f١٥٩٥٦a.b(i10);
            if (b10 == null) {
                return null;
            }
            return b10.U0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List findAccessibilityNodeInfosByText(String str, int i10) {
            List c10 = this.f١٥٩٥٦a.c(str, i10);
            if (c10 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = c10.size();
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(((g0) c10.get(i11)).U0());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i10) {
            g0 d10 = this.f١٥٩٥٦a.d(i10);
            if (d10 == null) {
                return null;
            }
            return d10.U0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i10, int i11, Bundle bundle) {
            return this.f١٥٩٥٦a.f(i10, i11, bundle);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class b extends a {
        b(h0 h0Var) {
            super(h0Var);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i10, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f١٥٩٥٦a.a(i10, g0.V0(accessibilityNodeInfo), str, bundle);
        }
    }

    public h0() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f١٥٩٥٥a = new b(this);
        } else {
            this.f١٥٩٥٥a = new a(this);
        }
    }

    public g0 b(int i10) {
        return null;
    }

    public List c(String str, int i10) {
        return null;
    }

    public g0 d(int i10) {
        return null;
    }

    public Object e() {
        return this.f١٥٩٥٥a;
    }

    public boolean f(int i10, int i11, Bundle bundle) {
        return false;
    }

    public h0(Object obj) {
        this.f١٥٩٥٥a = obj;
    }

    public void a(int i10, g0 g0Var, String str, Bundle bundle) {
    }
}
