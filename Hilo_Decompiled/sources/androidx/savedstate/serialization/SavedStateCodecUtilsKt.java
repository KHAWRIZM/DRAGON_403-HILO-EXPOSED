package androidx.savedstate.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0014\u0010\b\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\"\u0014\u0010\n\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0003\"\u0014\u0010\f\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0003\"\u0014\u0010\u000e\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0003\"\u0014\u0010\u0010\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0003\"\u001a\u0010\u0012\u001a\u00020\u0001X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0003¨\u0006\u0016"}, d2 = {"intListDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getIntListDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "stringListDescriptor", "getStringListDescriptor", "booleanArrayDescriptor", "getBooleanArrayDescriptor", "charArrayDescriptor", "getCharArrayDescriptor", "doubleArrayDescriptor", "getDoubleArrayDescriptor", "floatArrayDescriptor", "getFloatArrayDescriptor", "intArrayDescriptor", "getIntArrayDescriptor", "longArrayDescriptor", "getLongArrayDescriptor", "stringArrayDescriptor", "getStringArrayDescriptor$annotations", "()V", "getStringArrayDescriptor", "savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSavedStateCodecUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateCodecUtils.kt\nandroidx/savedstate/serialization/SavedStateCodecUtilsKt\n+ 2 BuiltinSerializers.kt\nkotlinx/serialization/builtins/BuiltinSerializersKt\n*L\n1#1,41:1\n194#2:42\n*S KotlinDebug\n*F\n+ 1 SavedStateCodecUtils.kt\nandroidx/savedstate/serialization/SavedStateCodecUtilsKt\n*L\n40#1:42\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class SavedStateCodecUtilsKt {

    @NotNull
    private static final SerialDescriptor booleanArrayDescriptor;

    @NotNull
    private static final SerialDescriptor charArrayDescriptor;

    @NotNull
    private static final SerialDescriptor doubleArrayDescriptor;

    @NotNull
    private static final SerialDescriptor floatArrayDescriptor;

    @NotNull
    private static final SerialDescriptor intArrayDescriptor;

    @NotNull
    private static final SerialDescriptor intListDescriptor = BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE)).getDescriptor();

    @NotNull
    private static final SerialDescriptor longArrayDescriptor;

    @NotNull
    private static final SerialDescriptor stringArrayDescriptor;

    @NotNull
    private static final SerialDescriptor stringListDescriptor;

    static {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        stringListDescriptor = BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(stringCompanionObject)).getDescriptor();
        booleanArrayDescriptor = BuiltinSerializersKt.BooleanArraySerializer().getDescriptor();
        charArrayDescriptor = BuiltinSerializersKt.CharArraySerializer().getDescriptor();
        doubleArrayDescriptor = BuiltinSerializersKt.DoubleArraySerializer().getDescriptor();
        floatArrayDescriptor = BuiltinSerializersKt.FloatArraySerializer().getDescriptor();
        intArrayDescriptor = BuiltinSerializersKt.IntArraySerializer().getDescriptor();
        longArrayDescriptor = BuiltinSerializersKt.LongArraySerializer().getDescriptor();
        stringArrayDescriptor = BuiltinSerializersKt.ArraySerializer(Reflection.getOrCreateKotlinClass(String.class), BuiltinSerializersKt.serializer(stringCompanionObject)).getDescriptor();
    }

    @NotNull
    public static final SerialDescriptor getBooleanArrayDescriptor() {
        return booleanArrayDescriptor;
    }

    @NotNull
    public static final SerialDescriptor getCharArrayDescriptor() {
        return charArrayDescriptor;
    }

    @NotNull
    public static final SerialDescriptor getDoubleArrayDescriptor() {
        return doubleArrayDescriptor;
    }

    @NotNull
    public static final SerialDescriptor getFloatArrayDescriptor() {
        return floatArrayDescriptor;
    }

    @NotNull
    public static final SerialDescriptor getIntArrayDescriptor() {
        return intArrayDescriptor;
    }

    @NotNull
    public static final SerialDescriptor getIntListDescriptor() {
        return intListDescriptor;
    }

    @NotNull
    public static final SerialDescriptor getLongArrayDescriptor() {
        return longArrayDescriptor;
    }

    @NotNull
    public static final SerialDescriptor getStringArrayDescriptor() {
        return stringArrayDescriptor;
    }

    public static /* synthetic */ void getStringArrayDescriptor$annotations() {
    }

    @NotNull
    public static final SerialDescriptor getStringListDescriptor() {
        return stringListDescriptor;
    }
}
