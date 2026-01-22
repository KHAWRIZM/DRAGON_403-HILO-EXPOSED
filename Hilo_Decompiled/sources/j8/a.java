package j8;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.SimpleElementVisitor8;
import k8.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {

    /* renamed from: j8.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static abstract class AbstractC٠١٧٥a extends SimpleElementVisitor8 {

        /* renamed from: a, reason: collision with root package name */
        private final String f١٥٣٤٠a;

        AbstractC٠١٧٥a(String str) {
            this.f١٥٣٤٠a = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b extends AbstractC٠١٧٥a {

        /* renamed from: b, reason: collision with root package name */
        private static final b f١٥٣٤١b = new b();

        b() {
            super("type element");
        }
    }

    public static TypeElement a(Element element) {
        return (TypeElement) element.accept(b.f١٥٣٤١b, (Object) null);
    }

    public static g b(Element element, Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return g.a();
        }
        return c(element, canonicalName);
    }

    public static g c(Element element, String str) {
        for (AnnotationMirror annotationMirror : element.getAnnotationMirrors()) {
            if (a(annotationMirror.getAnnotationType().asElement()).getQualifiedName().contentEquals(str)) {
                return g.d(annotationMirror);
            }
        }
        return g.a();
    }

    public static PackageElement d(Element element) {
        while (element.getKind() != ElementKind.PACKAGE) {
            element = element.getEnclosingElement();
        }
        return (PackageElement) element;
    }

    public static boolean e(Element element, Class cls) {
        return b(element, cls).c();
    }

    public static boolean f(Element element) {
        if (!element.getKind().isClass() && !element.getKind().isInterface()) {
            return false;
        }
        return true;
    }
}
