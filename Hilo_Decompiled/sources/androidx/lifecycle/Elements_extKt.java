package androidx.lifecycle;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0006\u001a\n\u0010\t\u001a\u00020\b*\u00020\u0006\u001a\u0010\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b*\u00020\f\u001a\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006\u001a\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006\"\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"getPackage", "Ljavax/lang/model/element/PackageElement;", "Ljavax/lang/model/element/Element;", "getPackageQName", "", "name", "Ljavax/lang/model/element/ExecutableElement;", "isPackagePrivate", "", "isProtected", "methods", "", "Ljavax/lang/model/element/TypeElement;", "SYNTHETIC", "syntheticName", FirebaseAnalytics.Param.METHOD, "isSyntheticMethod", "lifecycle-compiler"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nelements_ext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 elements_ext.kt\nandroidx/lifecycle/Elements_extKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,45:1\n1755#2,3:46\n*S KotlinDebug\n*F\n+ 1 elements_ext.kt\nandroidx/lifecycle/Elements_extKt\n*L\n34#1:46,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class Elements_extKt {

    @NotNull
    private static final String SYNTHETIC = "__synthetic_";

    @NotNull
    public static final PackageElement getPackage(@NotNull Element element) {
        Intrinsics.checkNotNullParameter(element, "<this>");
        PackageElement d10 = j8.a.d(element);
        Intrinsics.checkNotNullExpressionValue(d10, "getPackage(...)");
        return d10;
    }

    @NotNull
    public static final String getPackageQName(@NotNull Element element) {
        Intrinsics.checkNotNullParameter(element, "<this>");
        return getPackage(element).getQualifiedName().toString();
    }

    public static final boolean isPackagePrivate(@NotNull ExecutableElement executableElement) {
        Intrinsics.checkNotNullParameter(executableElement, "<this>");
        Set<Modifier> modifiers = executableElement.getModifiers();
        Intrinsics.checkNotNullExpressionValue(modifiers, "getModifiers(...)");
        boolean z10 = false;
        if (!(modifiers instanceof Collection) || !modifiers.isEmpty()) {
            for (Modifier modifier : modifiers) {
                if (modifier == Modifier.PUBLIC || modifier == Modifier.PROTECTED || modifier == Modifier.PRIVATE) {
                    z10 = true;
                    break;
                }
            }
        }
        return !z10;
    }

    public static final boolean isProtected(@NotNull ExecutableElement executableElement) {
        Intrinsics.checkNotNullParameter(executableElement, "<this>");
        return executableElement.getModifiers().contains(Modifier.PROTECTED);
    }

    public static final boolean isSyntheticMethod(@NotNull ExecutableElement method) {
        Intrinsics.checkNotNullParameter(method, "method");
        return StringsKt.startsWith$default(name(method), SYNTHETIC, false, 2, (Object) null);
    }

    @NotNull
    public static final List<ExecutableElement> methods(@NotNull TypeElement typeElement) {
        Intrinsics.checkNotNullParameter(typeElement, "<this>");
        List<ExecutableElement> methodsIn = ElementFilter.methodsIn(typeElement.getEnclosedElements());
        Intrinsics.checkNotNullExpressionValue(methodsIn, "methodsIn(...)");
        return methodsIn;
    }

    @NotNull
    public static final String name(@NotNull ExecutableElement executableElement) {
        Intrinsics.checkNotNullParameter(executableElement, "<this>");
        return executableElement.getSimpleName().toString();
    }

    @NotNull
    public static final String syntheticName(@NotNull ExecutableElement method) {
        Intrinsics.checkNotNullParameter(method, "method");
        return SYNTHETIC + method.getSimpleName();
    }
}
