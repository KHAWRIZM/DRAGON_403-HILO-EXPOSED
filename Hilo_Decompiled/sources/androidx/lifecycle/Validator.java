package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001d"}, d2 = {"Landroidx/lifecycle/Validator;", "", "processingEnv", "Ljavax/annotation/processing/ProcessingEnvironment;", "<init>", "(Ljavax/annotation/processing/ProcessingEnvironment;)V", "getProcessingEnv", "()Ljavax/annotation/processing/ProcessingEnvironment;", "printErrorMessage", "", "msg", "", "elem", "Ljavax/lang/model/element/Element;", "validateParam", "", "param", "Ljavax/lang/model/element/VariableElement;", "expectedType", "Ljava/lang/Class;", "errorMsg", "", "validateMethod", FirebaseAnalytics.Param.METHOD, "Ljavax/lang/model/element/ExecutableElement;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "validateClass", "classElement", "lifecycle-compiler"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class Validator {

    @NotNull
    private final ProcessingEnvironment processingEnv;

    public Validator(@NotNull ProcessingEnvironment processingEnv) {
        Intrinsics.checkNotNullParameter(processingEnv, "processingEnv");
        this.processingEnv = processingEnv;
    }

    @NotNull
    public final ProcessingEnvironment getProcessingEnv() {
        return this.processingEnv;
    }

    public final void printErrorMessage(@NotNull CharSequence msg, @NotNull Element elem) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(elem, "elem");
        this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, msg, elem);
    }

    public final boolean validateClass(@NotNull Element classElement) {
        Intrinsics.checkNotNullParameter(classElement, "classElement");
        if (!j8.a.f(classElement)) {
            printErrorMessage(ErrorMessages.INVALID_ENCLOSING_ELEMENT, classElement);
            return false;
        }
        if (classElement.getModifiers().contains(Modifier.PRIVATE)) {
            printErrorMessage(ErrorMessages.INVALID_CLASS_MODIFIER, classElement);
            return false;
        }
        return true;
    }

    public final boolean validateMethod(@NotNull ExecutableElement method, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(event, "event");
        if (method.getModifiers().contains(Modifier.PRIVATE)) {
            printErrorMessage(ErrorMessages.INVALID_METHOD_MODIFIER, (Element) method);
            return false;
        }
        List parameters = method.getParameters();
        if (parameters.size() > 2) {
            printErrorMessage(ErrorMessages.TOO_MANY_ARGS, (Element) method);
            return false;
        }
        if (parameters.size() == 2 && event != Lifecycle.Event.ON_ANY) {
            printErrorMessage(ErrorMessages.TOO_MANY_ARGS_NOT_ON_ANY, (Element) method);
            return false;
        }
        if (parameters.size() == 2 && !validateParam((VariableElement) parameters.get(1), Lifecycle.Event.class, ErrorMessages.INVALID_SECOND_ARGUMENT)) {
            return false;
        }
        if (parameters.size() <= 0) {
            return true;
        }
        return validateParam((VariableElement) parameters.get(0), LifecycleOwner.class, ErrorMessages.INVALID_FIRST_ARGUMENT);
    }

    public final boolean validateParam(@NotNull VariableElement param, @NotNull Class<?> expectedType, @NotNull String errorMsg) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(expectedType, "expectedType");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        if (!j8.b.c(expectedType, param.asType())) {
            printErrorMessage(errorMsg, (Element) param);
            return false;
        }
        return true;
    }
}
