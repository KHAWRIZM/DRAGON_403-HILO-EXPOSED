package dc;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.Spanned;
import android.util.ArrayMap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.appcompat.app.a0;
import androidx.collection.SimpleArrayMap;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.amazonaws.services.s3.internal.Constants;
import com.facebook.internal.security.CertificateUtil;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.qqface.QMUIQQFaceView;
import gc.j;
import gc.k;
import gc.l;
import gc.m;
import gc.n;
import gc.o;
import gc.p;
import gc.q;
import gc.s;
import gc.t;
import gc.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class e {

    /* renamed from: i, reason: collision with root package name */
    private static final String[] f١٣٦٦٩i = new String[0];

    /* renamed from: j, reason: collision with root package name */
    private static ArrayMap f١٣٦٧٠j = new ArrayMap();

    /* renamed from: k, reason: collision with root package name */
    public static final InterfaceC٠١٥٣e f١٣٦٧١k;

    /* renamed from: l, reason: collision with root package name */
    private static InterfaceC٠١٥٣e f١٣٦٧٢l;

    /* renamed from: m, reason: collision with root package name */
    private static HashMap f١٣٦٧٣m;

    /* renamed from: n, reason: collision with root package name */
    private static HashMap f١٣٦٧٤n;

    /* renamed from: o, reason: collision with root package name */
    private static View.OnLayoutChangeListener f١٣٦٧٥o;

    /* renamed from: p, reason: collision with root package name */
    private static ViewGroup.OnHierarchyChangeListener f١٣٦٧٦p;

    /* renamed from: a, reason: collision with root package name */
    private String f١٣٦٧٧a;

    /* renamed from: b, reason: collision with root package name */
    private Resources f١٣٦٧٨b;

    /* renamed from: c, reason: collision with root package name */
    private String f١٣٦٧٩c;

    /* renamed from: d, reason: collision with root package name */
    private SparseArray f١٣٦٨٠d = new SparseArray();

    /* renamed from: e, reason: collision with root package name */
    private boolean f١٣٦٨١e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f١٣٦٨٢f = -1;

    /* renamed from: g, reason: collision with root package name */
    private final List f١٣٦٨٣g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final List f١٣٦٨٤h = new ArrayList();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a implements InterfaceC٠١٥٣e {
        a() {
        }

        @Override // dc.e.InterfaceC٠١٥٣e
        public d a(ViewGroup viewGroup) {
            if (!(viewGroup instanceof RecyclerView) && !(viewGroup instanceof ViewPager) && !(viewGroup instanceof AdapterView) && !viewGroup.getClass().isAnnotationPresent(ec.a.class)) {
                return d.LISTEN_ON_LAYOUT;
            }
            return d.LISTEN_ON_HIERARCHY_CHANGE;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class b implements View.OnLayoutChangeListener {
        b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            ViewGroup viewGroup;
            int childCount;
            g i18;
            if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0 && (i18 = e.i(viewGroup)) != null) {
                for (int i19 = 0; i19 < childCount; i19++) {
                    View childAt = viewGroup.getChildAt(i19);
                    if (!i18.equals(e.i(childAt))) {
                        e.j(i18.f١٣٦٨٨a, childAt.getContext()).e(childAt, i18.f١٣٦٨٩b);
                    }
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum d {
        LISTEN_ON_LAYOUT,
        LISTEN_ON_HIERARCHY_CHANGE
    }

    /* renamed from: dc.e$e, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface InterfaceC٠١٥٣e {
        d a(ViewGroup viewGroup);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface f {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class g {

        /* renamed from: a, reason: collision with root package name */
        String f١٣٦٨٨a;

        /* renamed from: b, reason: collision with root package name */
        int f١٣٦٨٩b;

        g(String str, int i10) {
            this.f١٣٦٨٨a = str;
            this.f١٣٦٨٩b = i10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            g gVar = (g) obj;
            if (this.f١٣٦٨٩b == gVar.f١٣٦٨٩b && Objects.equals(this.f١٣٦٨٨a, gVar.f١٣٦٨٨a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.f١٣٦٨٨a, Integer.valueOf(this.f١٣٦٨٩b));
        }
    }

    static {
        a aVar = new a();
        f١٣٦٧١k = aVar;
        f١٣٦٧٢l = aVar;
        f١٣٦٧٣m = new HashMap();
        f١٣٦٧٤n = new HashMap();
        f١٣٦٧٣m.put("background", new gc.c());
        p pVar = new p();
        f١٣٦٧٣m.put("textColor", pVar);
        f١٣٦٧٣m.put("secondTextColor", pVar);
        f١٣٦٧٣m.put("src", new o());
        f١٣٦٧٣m.put("border", new gc.e());
        n nVar = new n();
        f١٣٦٧٣m.put("topSeparator", nVar);
        f١٣٦٧٣m.put("rightSeparator", nVar);
        f١٣٦٧٣m.put("bottomSeparator", nVar);
        f١٣٦٧٣m.put("LeftSeparator", nVar);
        f١٣٦٧٣m.put("tintColor", new t());
        f١٣٦٧٣m.put("alpha", new gc.b());
        f١٣٦٧٣m.put("bgTintColor", new gc.d());
        f١٣٦٧٣m.put("progressColor", new m());
        f١٣٦٧٣m.put("tcTintColor", new s());
        q qVar = new q();
        f١٣٦٧٣m.put("tclSrc", qVar);
        f١٣٦٧٣m.put("tctSrc", qVar);
        f١٣٦٧٣m.put("tcrSrc", qVar);
        f١٣٦٧٣m.put("tcbSrc", qVar);
        f١٣٦٧٣m.put("hintColor", new j());
        f١٣٦٧٣m.put("underline", new u());
        f١٣٦٧٣m.put("moreTextColor", new l());
        f١٣٦٧٣m.put("moreBgColor", new k());
        f١٣٦٧٥o = new b();
        f١٣٦٧٦p = new c();
    }

    public e(String str, Resources resources, String str2) {
        this.f١٣٦٧٧a = str;
        this.f١٣٦٧٨b = resources;
        this.f١٣٦٧٩c = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(View view, int i10, Resources.Theme theme) {
        String simpleArrayMap;
        SimpleArrayMap g10 = g(view);
        try {
            if (view instanceof dc.c) {
                ((dc.c) view).a(this, i10, theme, g10);
            } else {
                d(view, theme, g10);
            }
            view.getTag(R.id.qmui_skin_apply_listener);
            if (view instanceof RecyclerView) {
                RecyclerView recyclerView = (RecyclerView) view;
                int itemDecorationCount = recyclerView.getItemDecorationCount();
                for (int i11 = 0; i11 < itemDecorationCount; i11++) {
                    recyclerView.getItemDecorationAt(i11);
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("catch error when apply theme: ");
            sb.append(view.getClass().getSimpleName());
            sb.append("; ");
            sb.append(i10);
            sb.append("; attrs = ");
            if (g10 == null) {
                simpleArrayMap = Constants.NULL_VERSION_ID;
            } else {
                simpleArrayMap = g10.toString();
            }
            sb.append(simpleArrayMap);
            yb.b.b("QMUISkinManager", th, sb.toString(), new Object[0]);
        }
    }

    private boolean b(Object obj) {
        for (int size = this.f١٣٦٨٣g.size() - 1; size >= 0; size--) {
            Object obj2 = ((WeakReference) this.f١٣٦٨٣g.get(size)).get();
            if (obj2 == obj) {
                return true;
            }
            if (obj2 == null) {
                this.f١٣٦٨٣g.remove(size);
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SimpleArrayMap g(View view) {
        String[] strArr;
        SimpleArrayMap simpleArrayMap;
        SimpleArrayMap defaultSkinAttrs;
        SimpleArrayMap defaultSkinAttrs2;
        String str = (String) view.getTag(R.id.qmui_skin_value);
        if (str != null && !str.isEmpty()) {
            strArr = str.split("[|]");
        } else {
            strArr = f١٣٦٦٩i;
        }
        if ((view instanceof fc.a) && (defaultSkinAttrs2 = ((fc.a) view).getDefaultSkinAttrs()) != null && !defaultSkinAttrs2.isEmpty()) {
            simpleArrayMap = new SimpleArrayMap(defaultSkinAttrs2);
        } else {
            simpleArrayMap = null;
        }
        fc.a aVar = (fc.a) view.getTag(R.id.qmui_skin_default_attr_provider);
        if (aVar != null && (defaultSkinAttrs = aVar.getDefaultSkinAttrs()) != null && !defaultSkinAttrs.isEmpty()) {
            if (simpleArrayMap != null) {
                simpleArrayMap.putAll(defaultSkinAttrs);
            } else {
                simpleArrayMap = new SimpleArrayMap(defaultSkinAttrs);
            }
        }
        if (simpleArrayMap == null) {
            if (strArr.length <= 0) {
                return null;
            }
            simpleArrayMap = new SimpleArrayMap(strArr.length);
        }
        for (String str2 : strArr) {
            String[] split = str2.split(CertificateUtil.DELIMITER);
            if (split.length == 2) {
                String trim = split[0].trim();
                if (!ic.g.f(trim)) {
                    int f10 = f(split[1].trim());
                    if (f10 == 0) {
                        yb.b.c("QMUISkinManager", "Failed to get attr id from name: " + split[1], new Object[0]);
                    } else {
                        simpleArrayMap.put(trim, Integer.valueOf(f10));
                    }
                }
            }
        }
        return simpleArrayMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g i(View view) {
        Object tag = view.getTag(R.id.qmui_skin_current);
        if (tag instanceof g) {
            return (g) tag;
        }
        return null;
    }

    public static e j(String str, Context context) {
        Context applicationContext = context.getApplicationContext();
        return k(str, applicationContext.getResources(), applicationContext.getPackageName());
    }

    public static e k(String str, Resources resources, String str2) {
        e eVar = (e) f١٣٦٧٠j.get(str);
        if (eVar == null) {
            e eVar2 = new e(str, resources, str2);
            f١٣٦٧٠j.put(str, eVar2);
            return eVar2;
        }
        return eVar;
    }

    private void n(Object obj) {
        for (int size = this.f١٣٦٨٣g.size() - 1; size >= 0; size--) {
            Object obj2 = ((WeakReference) this.f١٣٦٨٣g.get(size)).get();
            if (obj2 == obj) {
                this.f١٣٦٨٣g.remove(size);
                return;
            } else {
                if (obj2 == null) {
                    this.f١٣٦٨٣g.remove(size);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void o(View view, int i10, Resources.Theme theme) {
        boolean z10;
        CharSequence text;
        g i11 = i(view);
        if (i11 != null && i11.f١٣٦٨٩b == i10 && Objects.equals(i11.f١٣٦٨٨a, this.f١٣٦٧٧a)) {
            return;
        }
        view.setTag(R.id.qmui_skin_current, new g(this.f١٣٦٧٧a, i10));
        if ((view instanceof dc.a) && ((dc.a) view).a(i10, theme)) {
            return;
        }
        Object tag = view.getTag(R.id.qmui_skin_intercept_dispatch);
        if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
            return;
        }
        Object tag2 = view.getTag(R.id.qmui_skin_ignore_apply);
        if ((tag2 instanceof Boolean) && ((Boolean) tag2).booleanValue()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            a(view, i10, theme);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (f١٣٦٧٢l.a(viewGroup) == d.LISTEN_ON_HIERARCHY_CHANGE) {
                viewGroup.setOnHierarchyChangeListener(f١٣٦٧٦p);
            } else {
                viewGroup.addOnLayoutChangeListener(f١٣٦٧٥o);
            }
            for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                o(viewGroup.getChildAt(i12), i10, theme);
            }
            return;
        }
        if (!z10) {
            boolean z11 = view instanceof TextView;
            if (z11 || (view instanceof QMUIQQFaceView)) {
                if (z11) {
                    text = ((TextView) view).getText();
                } else {
                    text = ((QMUIQQFaceView) view).getText();
                }
                if (text instanceof Spanned) {
                    dc.b[] bVarArr = (dc.b[]) ((Spanned) text).getSpans(0, text.length(), dc.b.class);
                    if (bVarArr != null && bVarArr.length > 0) {
                        dc.b bVar = bVarArr[0];
                        throw null;
                    }
                    view.invalidate();
                }
            }
        }
    }

    public void addSkinChangeListener(f fVar) {
        if (!this.f١٣٦٨١e) {
            this.f١٣٦٨٤h.add(fVar);
            return;
        }
        throw new RuntimeException("Can not add skinChangeListener while dispatching");
    }

    public void c(View view, Resources.Theme theme, String str, int i10) {
        if (i10 == 0) {
            return;
        }
        gc.a aVar = (gc.a) f١٣٦٧٣m.get(str);
        if (aVar == null) {
            yb.b.c("QMUISkinManager", "Do not find handler for skin attr name: " + str, new Object[0]);
            return;
        }
        aVar.a(this, view, theme, str, i10);
    }

    public void d(View view, Resources.Theme theme, SimpleArrayMap simpleArrayMap) {
        if (simpleArrayMap != null) {
            for (int i10 = 0; i10 < simpleArrayMap.getSize(); i10++) {
                String str = (String) simpleArrayMap.keyAt(i10);
                Integer num = (Integer) simpleArrayMap.valueAt(i10);
                if (num != null) {
                    c(view, theme, str, num.intValue());
                }
            }
        }
    }

    public void e(View view, int i10) {
        if (view == null) {
            return;
        }
        a0.a(this.f١٣٦٨٠d.get(i10));
        if (i10 == -1) {
            o(view, i10, view.getContext().getTheme());
            return;
        }
        throw new IllegalArgumentException("The skin " + i10 + " does not exist");
    }

    public int f(String str) {
        return this.f١٣٦٧٨b.getIdentifier(str, "attr", this.f١٣٦٧٩c);
    }

    public Resources.Theme h(int i10) {
        a0.a(this.f١٣٦٨٠d.get(i10));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(View view, int i10) {
        a0.a(this.f١٣٦٨٠d.get(i10));
    }

    public void m(Dialog dialog) {
        if (!b(dialog)) {
            this.f١٣٦٨٣g.add(new WeakReference(dialog));
        }
        Window window = dialog.getWindow();
        if (window != null) {
            e(window.getDecorView(), this.f١٣٦٨٢f);
        }
    }

    public void p(Dialog dialog) {
        n(dialog);
    }

    public void removeSkinChangeListener(f fVar) {
        if (!this.f١٣٦٨١e) {
            this.f١٣٦٨٤h.remove(fVar);
            return;
        }
        throw new RuntimeException("Can not add skinChangeListener while dispatching");
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class c implements ViewGroup.OnHierarchyChangeListener {
        c() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            g i10 = e.i(view);
            if (i10 != null && !i10.equals(e.i(view2))) {
                e.j(i10.f١٣٦٨٨a, view2.getContext()).e(view2, i10.f١٣٦٨٩b);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
        }
    }
}
