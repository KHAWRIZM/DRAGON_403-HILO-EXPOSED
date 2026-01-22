package androidx.datastore.preferences.core;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.okio.OkioSerializer;
import androidx.datastore.preferences.PreferencesMapCompat;
import androidx.datastore.preferences.b;
import androidx.datastore.preferences.c;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.d;
import androidx.datastore.preferences.protobuf.f;
import androidx.datastore.preferences.protobuf.t;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.BufferedSink;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\n8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Landroidx/datastore/preferences/core/PreferencesSerializer;", "Landroidx/datastore/core/okio/OkioSerializer;", "Landroidx/datastore/preferences/core/Preferences;", "<init>", "()V", "", "value", "Landroidx/datastore/preferences/d;", "getValueProto", "(Ljava/lang/Object;)Landroidx/datastore/preferences/d;", "", "name", "Landroidx/datastore/preferences/core/MutablePreferences;", "mutablePreferences", "", "addProtoEntryToPreferences", "(Ljava/lang/String;Landroidx/datastore/preferences/d;Landroidx/datastore/preferences/core/MutablePreferences;)V", "Lokio/BufferedSource;", "source", "readFrom", "(Lokio/BufferedSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "Lokio/BufferedSink;", "sink", "writeTo", "(Landroidx/datastore/preferences/core/Preferences;Lokio/BufferedSink;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fileExtension", "Ljava/lang/String;", "getDefaultValue", "()Landroidx/datastore/preferences/core/Preferences;", "defaultValue", "datastore-preferences-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPreferencesSerializer.jvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreferencesSerializer.jvm.kt\nandroidx/datastore/preferences/core/PreferencesSerializer\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,115:1\n215#2,2:116\n*S KotlinDebug\n*F\n+ 1 PreferencesSerializer.jvm.kt\nandroidx/datastore/preferences/core/PreferencesSerializer\n*L\n50#1:116,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class PreferencesSerializer implements OkioSerializer<Preferences> {

    @NotNull
    public static final PreferencesSerializer INSTANCE = new PreferencesSerializer();

    @NotNull
    public static final String fileExtension = "preferences_pb";

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[d.b.values().length];
            try {
                iArr[d.b.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.b.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d.b.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d.b.INTEGER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[d.b.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[d.b.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[d.b.STRING_SET.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[d.b.BYTES.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[d.b.VALUE_NOT_SET.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PreferencesSerializer() {
    }

    private final void addProtoEntryToPreferences(String name, d value, MutablePreferences mutablePreferences) {
        int i10;
        d.b c02 = value.c0();
        if (c02 == null) {
            i10 = -1;
        } else {
            i10 = WhenMappings.$EnumSwitchMapping$0[c02.ordinal()];
        }
        switch (i10) {
            case -1:
                throw new CorruptionException("Value case is null.", null, 2, null);
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                mutablePreferences.set(PreferencesKeys.booleanKey(name), Boolean.valueOf(value.T()));
                return;
            case 2:
                mutablePreferences.set(PreferencesKeys.floatKey(name), Float.valueOf(value.X()));
                return;
            case 3:
                mutablePreferences.set(PreferencesKeys.doubleKey(name), Double.valueOf(value.W()));
                return;
            case 4:
                mutablePreferences.set(PreferencesKeys.intKey(name), Integer.valueOf(value.Y()));
                return;
            case 5:
                mutablePreferences.set(PreferencesKeys.longKey(name), Long.valueOf(value.Z()));
                return;
            case 6:
                Preferences.Key<String> stringKey = PreferencesKeys.stringKey(name);
                String a02 = value.a0();
                Intrinsics.checkNotNullExpressionValue(a02, "value.string");
                mutablePreferences.set(stringKey, a02);
                return;
            case 7:
                Preferences.Key<Set<String>> stringSetKey = PreferencesKeys.stringSetKey(name);
                List P = value.b0().P();
                Intrinsics.checkNotNullExpressionValue(P, "value.stringSet.stringsList");
                mutablePreferences.set(stringSetKey, CollectionsKt.toSet(P));
                return;
            case 8:
                Preferences.Key<byte[]> byteArrayKey = PreferencesKeys.byteArrayKey(name);
                byte[] s10 = value.U().s();
                Intrinsics.checkNotNullExpressionValue(s10, "value.bytes.toByteArray()");
                mutablePreferences.set(byteArrayKey, s10);
                return;
            case 9:
                throw new CorruptionException("Value not set.", null, 2, null);
        }
    }

    private final d getValueProto(Object value) {
        if (value instanceof Boolean) {
            t e10 = d.d0().m(((Boolean) value).booleanValue()).e();
            Intrinsics.checkNotNullExpressionValue(e10, "newBuilder().setBoolean(value).build()");
            return (d) e10;
        }
        if (value instanceof Float) {
            t e11 = d.d0().p(((Number) value).floatValue()).e();
            Intrinsics.checkNotNullExpressionValue(e11, "newBuilder().setFloat(value).build()");
            return (d) e11;
        }
        if (value instanceof Double) {
            t e12 = d.d0().o(((Number) value).doubleValue()).e();
            Intrinsics.checkNotNullExpressionValue(e12, "newBuilder().setDouble(value).build()");
            return (d) e12;
        }
        if (value instanceof Integer) {
            t e13 = d.d0().q(((Number) value).intValue()).e();
            Intrinsics.checkNotNullExpressionValue(e13, "newBuilder().setInteger(value).build()");
            return (d) e13;
        }
        if (value instanceof Long) {
            t e14 = d.d0().r(((Number) value).longValue()).e();
            Intrinsics.checkNotNullExpressionValue(e14, "newBuilder().setLong(value).build()");
            return (d) e14;
        }
        if (value instanceof String) {
            t e15 = d.d0().s((String) value).e();
            Intrinsics.checkNotNullExpressionValue(e15, "newBuilder().setString(value).build()");
            return (d) e15;
        }
        if (value instanceof Set) {
            d.a d02 = d.d0();
            c.a Q = c.Q();
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
            t e16 = d02.t(Q.m((Set) value)).e();
            Intrinsics.checkNotNullExpressionValue(e16, "newBuilder().setStringSe…                ).build()");
            return (d) e16;
        }
        if (value instanceof byte[]) {
            t e17 = d.d0().n(f.i((byte[]) value)).e();
            Intrinsics.checkNotNullExpressionValue(e17, "newBuilder().setBytes(By….copyFrom(value)).build()");
            return (d) e17;
        }
        throw new IllegalStateException("PreferencesSerializer does not support type: " + value.getClass().getName());
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    @Nullable
    public Object readFrom(@NotNull BufferedSource bufferedSource, @NotNull Continuation<? super Preferences> continuation) throws IOException, CorruptionException {
        b readFrom = PreferencesMapCompat.INSTANCE.readFrom(bufferedSource.inputStream());
        MutablePreferences createMutable = PreferencesFactory.createMutable(new Preferences.Pair[0]);
        Map N = readFrom.N();
        Intrinsics.checkNotNullExpressionValue(N, "preferencesProto.preferencesMap");
        for (Map.Entry entry : N.entrySet()) {
            String name = (String) entry.getKey();
            d value = (d) entry.getValue();
            PreferencesSerializer preferencesSerializer = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(name, "name");
            Intrinsics.checkNotNullExpressionValue(value, "value");
            preferencesSerializer.addProtoEntryToPreferences(name, value, createMutable);
        }
        return createMutable.toPreferences();
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    public /* bridge */ /* synthetic */ Object writeTo(Preferences preferences, BufferedSink bufferedSink, Continuation continuation) {
        return writeTo2(preferences, bufferedSink, (Continuation<? super Unit>) continuation);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.datastore.core.okio.OkioSerializer
    @NotNull
    public Preferences getDefaultValue() {
        return PreferencesFactory.createEmpty();
    }

    @Nullable
    /* renamed from: writeTo, reason: avoid collision after fix types in other method */
    public Object writeTo2(@NotNull Preferences preferences, @NotNull BufferedSink bufferedSink, @NotNull Continuation<? super Unit> continuation) throws IOException, CorruptionException {
        Map<Preferences.Key<?>, Object> asMap = preferences.asMap();
        b.a Q = b.Q();
        for (Map.Entry<Preferences.Key<?>, Object> entry : asMap.entrySet()) {
            Q.m(entry.getKey().getName(), getValueProto(entry.getValue()));
        }
        ((b) Q.e()).e(bufferedSink.outputStream());
        return Unit.INSTANCE;
    }
}
