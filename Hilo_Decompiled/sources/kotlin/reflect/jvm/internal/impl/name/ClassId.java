package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@SourceDebugExtension({"SMAP\nClassId.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassId.kt\norg/jetbrains/kotlin/name/ClassId\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 addToStdlib.kt\norg/jetbrains/kotlin/utils/addToStdlib/AddToStdlibKt\n*L\n1#1,141:1\n1#2:142\n227#3:143\n227#3:144\n*S KotlinDebug\n*F\n+ 1 ClassId.kt\norg/jetbrains/kotlin/name/ClassId\n*L\n37#1:143\n47#1:144\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ClassId {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private final boolean isLocal;

    @NotNull
    private final FqName packageFqName;

    @NotNull
    private final FqName relativeClassName;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ClassId fromString$default(Companion companion, String str, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            return companion.fromString(str, z10);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final ClassId fromString(@NotNull String string, boolean z10) {
            String replace$default;
            String str;
            Intrinsics.checkNotNullParameter(string, "string");
            int indexOf$default = StringsKt.indexOf$default((CharSequence) string, '`', 0, false, 6, (Object) null);
            if (indexOf$default == -1) {
                indexOf$default = string.length();
            }
            int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) string, "/", indexOf$default, false, 4, (Object) null);
            if (lastIndexOf$default == -1) {
                replace$default = StringsKt.replace$default(string, "`", "", false, 4, (Object) null);
                str = "";
            } else {
                String substring = string.substring(0, lastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                String replace$default2 = StringsKt.replace$default(substring, '/', '.', false, 4, (Object) null);
                String substring2 = string.substring(lastIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                replace$default = StringsKt.replace$default(substring2, "`", "", false, 4, (Object) null);
                str = replace$default2;
            }
            return new ClassId(new FqName(str), new FqName(replace$default), z10);
        }

        @JvmStatic
        @NotNull
        public final ClassId topLevel(@NotNull FqName topLevelFqName) {
            Intrinsics.checkNotNullParameter(topLevelFqName, "topLevelFqName");
            return new ClassId(topLevelFqName.parent(), topLevelFqName.shortName());
        }

        private Companion() {
        }
    }

    public ClassId(@NotNull FqName packageFqName, @NotNull FqName relativeClassName, boolean z10) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(relativeClassName, "relativeClassName");
        this.packageFqName = packageFqName;
        this.relativeClassName = relativeClassName;
        this.isLocal = z10;
        relativeClassName.isRoot();
    }

    private static final String asString$escapeSlashes(FqName fqName) {
        String asString = fqName.asString();
        if (StringsKt.contains$default((CharSequence) asString, '/', false, 2, (Object) null)) {
            return '`' + asString + '`';
        }
        return asString;
    }

    @JvmStatic
    @NotNull
    public static final ClassId topLevel(@NotNull FqName fqName) {
        return Companion.topLevel(fqName);
    }

    @NotNull
    public final FqName asSingleFqName() {
        if (this.packageFqName.isRoot()) {
            return this.relativeClassName;
        }
        return new FqName(this.packageFqName.asString() + '.' + this.relativeClassName.asString());
    }

    @NotNull
    public final String asString() {
        if (this.packageFqName.isRoot()) {
            return asString$escapeSlashes(this.relativeClassName);
        }
        return StringsKt.replace$default(this.packageFqName.asString(), '.', '/', false, 4, (Object) null) + "/" + asString$escapeSlashes(this.relativeClassName);
    }

    @NotNull
    public final ClassId createNestedClassId(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ClassId(this.packageFqName, this.relativeClassName.child(name), this.isLocal);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassId)) {
            return false;
        }
        ClassId classId = (ClassId) obj;
        return Intrinsics.areEqual(this.packageFqName, classId.packageFqName) && Intrinsics.areEqual(this.relativeClassName, classId.relativeClassName) && this.isLocal == classId.isLocal;
    }

    @Nullable
    public final ClassId getOuterClassId() {
        FqName parent = this.relativeClassName.parent();
        if (!parent.isRoot()) {
            return new ClassId(this.packageFqName, parent, this.isLocal);
        }
        return null;
    }

    @NotNull
    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    @NotNull
    public final FqName getRelativeClassName() {
        return this.relativeClassName;
    }

    @NotNull
    public final Name getShortClassName() {
        return this.relativeClassName.shortName();
    }

    public int hashCode() {
        return (((this.packageFqName.hashCode() * 31) + this.relativeClassName.hashCode()) * 31) + a.a(this.isLocal);
    }

    public final boolean isLocal() {
        return this.isLocal;
    }

    public final boolean isNestedClass() {
        return !this.relativeClassName.parent().isRoot();
    }

    @NotNull
    public String toString() {
        if (this.packageFqName.isRoot()) {
            return '/' + asString();
        }
        return asString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClassId(@NotNull FqName packageFqName, @NotNull Name topLevelName) {
        this(packageFqName, FqName.Companion.topLevel(topLevelName), false);
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(topLevelName, "topLevelName");
    }
}
