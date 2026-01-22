package kotlin.reflect.jvm.internal.impl.load.kotlin;

import io.agora.rtc.Constants;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class TypeMappingMode {

    @JvmField
    @NotNull
    public static final TypeMappingMode CLASS_DECLARATION;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final TypeMappingMode DEFAULT;

    @JvmField
    @NotNull
    public static final TypeMappingMode DEFAULT_UAST;

    @JvmField
    @NotNull
    public static final TypeMappingMode GENERIC_ARGUMENT;

    @JvmField
    @NotNull
    public static final TypeMappingMode GENERIC_ARGUMENT_UAST;

    @JvmField
    @NotNull
    public static final TypeMappingMode RETURN_TYPE_BOXED;

    @JvmField
    @NotNull
    public static final TypeMappingMode SUPER_TYPE;

    @JvmField
    @NotNull
    public static final TypeMappingMode SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS;

    @JvmField
    @NotNull
    public static final TypeMappingMode VALUE_FOR_ANNOTATION;

    @Nullable
    private final TypeMappingMode genericArgumentMode;

    @Nullable
    private final TypeMappingMode genericContravariantArgumentMode;

    @Nullable
    private final TypeMappingMode genericInvariantArgumentMode;
    private final boolean isForAnnotationParameter;
    private final boolean kotlinCollectionsToJavaCollections;
    private final boolean mapTypeAliases;
    private final boolean needInlineClassWrapping;
    private final boolean needPrimitiveBoxing;
    private final boolean skipDeclarationSiteWildcards;
    private final boolean skipDeclarationSiteWildcardsIfPossible;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.IN_VARIANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Variance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        TypeMappingMode typeMappingMode = null;
        boolean z14 = false;
        TypeMappingMode typeMappingMode2 = null;
        TypeMappingMode typeMappingMode3 = null;
        boolean z15 = false;
        TypeMappingMode typeMappingMode4 = new TypeMappingMode(z10, false, z11, z12, z13, typeMappingMode, z14, typeMappingMode2, typeMappingMode3, z15, 1023, defaultConstructorMarker);
        GENERIC_ARGUMENT = typeMappingMode4;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        boolean z20 = false;
        boolean z21 = false;
        TypeMappingMode typeMappingMode5 = null;
        TypeMappingMode typeMappingMode6 = null;
        boolean z22 = true;
        TypeMappingMode typeMappingMode7 = new TypeMappingMode(z16, z17, z18, z19, z20, null, z21, typeMappingMode5, typeMappingMode6, z22, 511, defaultConstructorMarker2);
        GENERIC_ARGUMENT_UAST = typeMappingMode7;
        RETURN_TYPE_BOXED = new TypeMappingMode(z10, true, z11, z12, z13, typeMappingMode, z14, typeMappingMode2, typeMappingMode3, z15, Constants.WARN_ADM_RECORD_ABNORMAL_FREQUENCY, defaultConstructorMarker);
        int i10 = 988;
        DEFAULT = new TypeMappingMode(z10, false, z11, z12, z13, typeMappingMode4, z14, typeMappingMode2, typeMappingMode3, z15, i10, defaultConstructorMarker);
        DEFAULT_UAST = new TypeMappingMode(z16, z17, z18, z19, z20, typeMappingMode7, z21, typeMappingMode5, typeMappingMode6, z22, 476, defaultConstructorMarker2);
        CLASS_DECLARATION = new TypeMappingMode(z10, true, z11, z12, z13, typeMappingMode4, z14, typeMappingMode2, typeMappingMode3, z15, i10, defaultConstructorMarker);
        boolean z23 = false;
        boolean z24 = true;
        SUPER_TYPE = new TypeMappingMode(z10, z23, z11, z24, z13, typeMappingMode4, z14, typeMappingMode2, typeMappingMode3, z15, 983, defaultConstructorMarker);
        SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = new TypeMappingMode(z10, z23, z11, z24, z13, typeMappingMode4, z14, typeMappingMode2, typeMappingMode3, z15, 919, defaultConstructorMarker);
        VALUE_FOR_ANNOTATION = new TypeMappingMode(z10, z23, true, false, z13, typeMappingMode4, z14, typeMappingMode2, typeMappingMode3, z15, 984, defaultConstructorMarker);
    }

    public TypeMappingMode() {
        this(false, false, false, false, false, null, false, null, null, false, 1023, null);
    }

    public final boolean getKotlinCollectionsToJavaCollections() {
        return this.kotlinCollectionsToJavaCollections;
    }

    public final boolean getMapTypeAliases() {
        return this.mapTypeAliases;
    }

    public final boolean getNeedInlineClassWrapping() {
        return this.needInlineClassWrapping;
    }

    public final boolean getNeedPrimitiveBoxing() {
        return this.needPrimitiveBoxing;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    @NotNull
    public final TypeMappingMode toGenericArgumentMode(@NotNull Variance effectiveVariance, boolean z10) {
        Intrinsics.checkNotNullParameter(effectiveVariance, "effectiveVariance");
        if (!z10 || !this.isForAnnotationParameter) {
            int i10 = WhenMappings.$EnumSwitchMapping$0[effectiveVariance.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    TypeMappingMode typeMappingMode = this.genericArgumentMode;
                    if (typeMappingMode != null) {
                        return typeMappingMode;
                    }
                } else {
                    TypeMappingMode typeMappingMode2 = this.genericInvariantArgumentMode;
                    if (typeMappingMode2 != null) {
                        return typeMappingMode2;
                    }
                }
            } else {
                TypeMappingMode typeMappingMode3 = this.genericContravariantArgumentMode;
                if (typeMappingMode3 != null) {
                    return typeMappingMode3;
                }
            }
        }
        return this;
    }

    @NotNull
    public final TypeMappingMode wrapInlineClassesMode() {
        return new TypeMappingMode(this.needPrimitiveBoxing, true, this.isForAnnotationParameter, this.skipDeclarationSiteWildcards, this.skipDeclarationSiteWildcardsIfPossible, this.genericArgumentMode, this.kotlinCollectionsToJavaCollections, this.genericContravariantArgumentMode, this.genericInvariantArgumentMode, false, 512, null);
    }

    public TypeMappingMode(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, @Nullable TypeMappingMode typeMappingMode, boolean z15, @Nullable TypeMappingMode typeMappingMode2, @Nullable TypeMappingMode typeMappingMode3, boolean z16) {
        this.needPrimitiveBoxing = z10;
        this.needInlineClassWrapping = z11;
        this.isForAnnotationParameter = z12;
        this.skipDeclarationSiteWildcards = z13;
        this.skipDeclarationSiteWildcardsIfPossible = z14;
        this.genericArgumentMode = typeMappingMode;
        this.kotlinCollectionsToJavaCollections = z15;
        this.genericContravariantArgumentMode = typeMappingMode2;
        this.genericInvariantArgumentMode = typeMappingMode3;
        this.mapTypeAliases = z16;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TypeMappingMode(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, TypeMappingMode typeMappingMode, boolean z15, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, boolean z16, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r4, r6, r7, r8, (i10 & 64) == 0 ? z15 : true, (i10 & 128) != 0 ? r8 : typeMappingMode2, (i10 & 256) != 0 ? r8 : typeMappingMode3, (i10 & 512) == 0 ? z16 : false);
        boolean z17 = (i10 & 1) != 0 ? true : z10;
        boolean z18 = (i10 & 2) != 0 ? true : z11;
        boolean z19 = (i10 & 4) != 0 ? false : z12;
        boolean z20 = (i10 & 8) != 0 ? false : z13;
        boolean z21 = (i10 & 16) != 0 ? false : z14;
        TypeMappingMode typeMappingMode4 = (i10 & 32) != 0 ? null : typeMappingMode;
    }
}
