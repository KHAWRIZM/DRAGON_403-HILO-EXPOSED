package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\njavaTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 javaTypes.kt\norg/jetbrains/kotlin/load/java/structure/JavaTypesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,48:1\n1#2:49\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class JavaTypesKt {
    public static final boolean isSuperWildcard(@Nullable JavaType javaType) {
        JavaWildcardType javaWildcardType;
        if (javaType instanceof JavaWildcardType) {
            javaWildcardType = (JavaWildcardType) javaType;
        } else {
            javaWildcardType = null;
        }
        if (javaWildcardType == null || javaWildcardType.getBound() == null || javaWildcardType.isExtends()) {
            return false;
        }
        return true;
    }
}
