package androidx.lifecycle;

import androidx.lifecycle.model.AdapterClass;
import androidx.lifecycle.model.InputModel;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Landroidx/lifecycle/LifecycleProcessor;", "Ljavax/annotation/processing/AbstractProcessor;", "<init>", "()V", "process", "", "annotations", "", "Ljavax/lang/model/element/TypeElement;", "roundEnv", "Ljavax/annotation/processing/RoundEnvironment;", "getSupportedSourceVersion", "Ljavax/lang/model/SourceVersion;", "lifecycle-compiler"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SupportedAnnotationTypes({"androidx.lifecycle.OnLifecycleEvent"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class LifecycleProcessor extends AbstractProcessor {
    @NotNull
    public SourceVersion getSupportedSourceVersion() {
        SourceVersion latest = SourceVersion.latest();
        Intrinsics.checkNotNullExpressionValue(latest, "latest(...)");
        return latest;
    }

    public boolean process(@NotNull Set<? extends TypeElement> annotations, @NotNull RoundEnvironment roundEnv) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(roundEnv, "roundEnv");
        ProcessingEnvironment processingEnv = this.processingEnv;
        Intrinsics.checkNotNullExpressionValue(processingEnv, "processingEnv");
        InputModel collectAndVerifyInput = Input_collectorKt.collectAndVerifyInput(processingEnv, roundEnv);
        ProcessingEnvironment processingEnv2 = this.processingEnv;
        Intrinsics.checkNotNullExpressionValue(processingEnv2, "processingEnv");
        List<AdapterClass> transformToOutput = TransformationKt.transformToOutput(processingEnv2, collectAndVerifyInput);
        ProcessingEnvironment processingEnv3 = this.processingEnv;
        Intrinsics.checkNotNullExpressionValue(processingEnv3, "processingEnv");
        WriterKt.writeModels(transformToOutput, processingEnv3);
        return true;
    }
}
