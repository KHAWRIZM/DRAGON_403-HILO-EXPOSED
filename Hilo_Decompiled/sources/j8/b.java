package j8;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleTypeVisitor8;
import k8.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a extends SimpleTypeVisitor8 {

        /* renamed from: a, reason: collision with root package name */
        private static final a f١٥٣٤٢a = new a();

        private a() {
        }
    }

    /* renamed from: j8.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class C٠١٧٦b extends SimpleTypeVisitor8 {

        /* renamed from: a, reason: collision with root package name */
        private final Class f١٥٣٤٣a;

        C٠١٧٦b(Class cls) {
            this.f١٥٣٤٣a = cls;
        }
    }

    public static Element a(TypeMirror typeMirror) {
        return (Element) typeMirror.accept(a.f١٥٣٤٢a, (Object) null);
    }

    public static TypeElement b(TypeMirror typeMirror) {
        return j8.a.a(a(typeMirror));
    }

    public static boolean c(Class cls, TypeMirror typeMirror) {
        h.i(cls);
        return ((Boolean) typeMirror.accept(new C٠١٧٦b(cls), (Object) null)).booleanValue();
    }
}
