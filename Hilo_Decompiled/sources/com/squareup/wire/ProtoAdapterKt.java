package com.squareup.wire;

import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okhttp3.internal.http2.Http2Connection;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\u001a\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0000\u001a\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u0000\u001a\u0012\u0010\u000b\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u0005H\u0000\u001a\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0000\u001a\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001a\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005H\u0000\u001a\u0012\u0010\u0015\u001a\f\u0012\b\u0012\u00060\u0016j\u0002`\u00170\u0005H\u0000\u001a\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001aC\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001d0\u001b0\u0005\"\u0004\b\u0000\u0010\u001c\"\u0004\b\u0001\u0010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u0005H\u0080\b\u001a\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001a\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001a\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0005H\u0000\u001a\u0014\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010'0\u0005H\u0000\u001a\u001a\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0002\b\u0003\u0018\u00010\u001b0\u0005H\u0000\u001a\u0010\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0\u0005H\u0000\u001a\u0010\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\u0005H\u0000\u001a\u001c\u0010-\u001a\u00020%\"\u0004\b\u0000\u0010.2\u0006\u0010/\u001a\u0002H.H\u0080\b¢\u0006\u0002\u00100\u001a\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001a0\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H40\u0005\"\b\b\u0000\u00104*\u00020,2\f\u00105\u001a\b\u0012\u0004\u0012\u0002H40\u00052\u0006\u00106\u001a\u00020%H\u0000\u001a%\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H.0'0\u0005\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u0005H\u0080\b\u001a%\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H.0'0\u0005\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u0005H\u0080\b\u001a&\u00109\u001a\u0002H.\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010:\u001a\u00020;H\u0080\b¢\u0006\u0002\u0010<\u001a&\u00109\u001a\u0002H.\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010=\u001a\u00020>H\u0080\b¢\u0006\u0002\u0010?\u001a&\u00109\u001a\u0002H.\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010:\u001a\u00020\bH\u0080\b¢\u0006\u0002\u0010@\u001a&\u0010A\u001a\u00020;\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010/\u001a\u0002H.H\u0080\b¢\u0006\u0002\u0010B\u001a.\u0010A\u001a\u00020\u000f\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010C\u001a\u00020D2\u0006\u0010/\u001a\u0002H.H\u0080\b¢\u0006\u0002\u0010E\u001a&\u0010F\u001a\u00020\b\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010/\u001a\u0002H.H\u0080\b¢\u0006\u0002\u0010G\u001a8\u0010H\u001a\u00020\u000f\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00012\b\u0010/\u001a\u0004\u0018\u0001H.H\u0080\b¢\u0006\u0002\u0010L\u001a8\u0010H\u001a\u00020\u000f\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010I\u001a\u00020M2\u0006\u0010K\u001a\u00020\u00012\b\u0010/\u001a\u0004\u0018\u0001H.H\u0080\b¢\u0006\u0002\u0010N\u001a0\u0010O\u001a\u00020\u0001\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010K\u001a\u00020\u00012\b\u0010/\u001a\u0004\u0018\u0001H.H\u0080\b¢\u0006\u0002\u0010P\u001a%\u0010Q\u001a\u0006\u0012\u0002\b\u00030\u0005\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010R\u001a\u00020SH\u0080\b\u001a.\u0010T\u001a\u00020\u000f\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010I\u001a\u00020M2\u0006\u0010/\u001a\u0002H.H\u0080\b¢\u0006\u0002\u0010U\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"FIXED_32_SIZE", "", "FIXED_64_SIZE", "FIXED_BOOL_SIZE", "commonBool", "Lcom/squareup/wire/ProtoAdapter;", "", "commonBytes", "Lokio/ByteString;", "commonDouble", "", "commonDuration", "Ljava/time/Duration;", "Lcom/squareup/wire/Duration;", "commonEmpty", "", "commonFixed32", "commonFixed64", "", "commonFloat", "", "commonInstant", "Ljava/time/Instant;", "Lcom/squareup/wire/Instant;", "commonInt32", "commonInt64", "commonNewMapAdapter", "", "K", "V", "keyAdapter", "valueAdapter", "commonSfixed32", "commonSfixed64", "commonSint32", "commonSint64", "commonString", "", "commonStructList", "", "commonStructMap", "commonStructNull", "", "commonStructValue", "", "commonToString", "E", "value", "(Ljava/lang/Object;)Ljava/lang/String;", "commonUint32", "commonUint64", "commonWrapper", "T", "delegate", "typeUrl", "commonCreatePacked", "commonCreateRepeated", "commonDecode", "bytes", "", "(Lcom/squareup/wire/ProtoAdapter;[B)Ljava/lang/Object;", "source", "Lokio/BufferedSource;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/BufferedSource;)Ljava/lang/Object;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/ByteString;)Ljava/lang/Object;", "commonEncode", "(Lcom/squareup/wire/ProtoAdapter;Ljava/lang/Object;)[B", "sink", "Lokio/BufferedSink;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/BufferedSink;Ljava/lang/Object;)V", "commonEncodeByteString", "(Lcom/squareup/wire/ProtoAdapter;Ljava/lang/Object;)Lokio/ByteString;", "commonEncodeWithTag", "writer", "Lcom/squareup/wire/ProtoWriter;", "tag", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ProtoWriter;ILjava/lang/Object;)V", "Lcom/squareup/wire/ReverseProtoWriter;", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ReverseProtoWriter;ILjava/lang/Object;)V", "commonEncodedSizeWithTag", "(Lcom/squareup/wire/ProtoAdapter;ILjava/lang/Object;)I", "commonWithLabel", "label", "Lcom/squareup/wire/WireField$Label;", "delegateEncode", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ReverseProtoWriter;Ljava/lang/Object;)V", "wire-runtime"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class ProtoAdapterKt {
    private static final int FIXED_32_SIZE = 4;
    private static final int FIXED_64_SIZE = 8;
    private static final int FIXED_BOOL_SIZE = 1;

    @NotNull
    public static final ProtoAdapter<Boolean> commonBool() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Boolean>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonBool$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Boolean bool = Boolean.FALSE;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Boolean bool) {
                encode(protoWriter, bool.booleanValue());
            }

            public int encodedSize(boolean value) {
                return 1;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Boolean redact(Boolean bool) {
                return redact(bool.booleanValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Boolean decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Boolean.valueOf(reader.readVarint32() != 0);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Boolean bool) {
                encode(reverseProtoWriter, bool.booleanValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Boolean bool) {
                return encodedSize(bool.booleanValue());
            }

            @NotNull
            public Boolean redact(boolean value) {
                throw new UnsupportedOperationException();
            }

            public void encode(@NotNull ProtoWriter writer, boolean value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint32(value ? 1 : 0);
            }

            public void encode(@NotNull ReverseProtoWriter writer, boolean value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint32(value ? 1 : 0);
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<ByteString> commonBytes() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ByteString.class);
        final Syntax syntax = Syntax.PROTO_2;
        final ByteString byteString = ByteString.EMPTY;
        return new ProtoAdapter<ByteString>(fieldEncoding, orCreateKotlinClass, syntax, byteString) { // from class: com.squareup.wire.ProtoAdapterKt$commonBytes$1
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public ByteString decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return reader.readBytes();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull ByteString value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value.size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public ByteString redact(@NotNull ByteString value) {
                Intrinsics.checkNotNullParameter(value, "value");
                throw new UnsupportedOperationException();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull ByteString value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                writer.writeBytes(value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ReverseProtoWriter writer, @NotNull ByteString value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                writer.writeBytes(value);
            }
        };
    }

    @NotNull
    public static final <E> ProtoAdapter<List<E>> commonCreatePacked(@NotNull ProtoAdapter<E> protoAdapter) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        if (protoAdapter.getFieldEncoding() != FieldEncoding.LENGTH_DELIMITED) {
            return new PackedProtoAdapter(protoAdapter);
        }
        throw new IllegalArgumentException("Unable to pack a length-delimited type.");
    }

    @NotNull
    public static final <E> ProtoAdapter<List<E>> commonCreateRepeated(@NotNull ProtoAdapter<E> protoAdapter) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        return new RepeatedProtoAdapter(protoAdapter);
    }

    public static final <E> E commonDecode(@NotNull ProtoAdapter<E> protoAdapter, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        return protoAdapter.decode((BufferedSource) new Buffer().write(bArr));
    }

    @NotNull
    public static final ProtoAdapter<Double> commonDouble() {
        final FieldEncoding fieldEncoding = FieldEncoding.FIXED64;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Double.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Double>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonDouble$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Double valueOf = Double.valueOf(0.0d);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Double d) {
                encode(protoWriter, d.doubleValue());
            }

            public int encodedSize(double value) {
                return 8;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Double redact(Double d) {
                return redact(d.doubleValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Double decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
                return Double.valueOf(Double.longBitsToDouble(reader.readFixed64()));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Double d) {
                encode(reverseProtoWriter, d.doubleValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Double d) {
                return encodedSize(d.doubleValue());
            }

            @NotNull
            public Double redact(double value) {
                throw new UnsupportedOperationException();
            }

            public void encode(@NotNull ProtoWriter writer, double value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeFixed64(Double.doubleToLongBits(value));
            }

            public void encode(@NotNull ReverseProtoWriter writer, double value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeFixed64(Double.doubleToLongBits(value));
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Duration> commonDuration() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(g.a());
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter<Duration>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonDuration$1
            private final int getSameSignNanos(Duration duration) {
                long seconds;
                int nano;
                int nano2;
                int nano3;
                seconds = duration.getSeconds();
                if (seconds < 0) {
                    nano2 = duration.getNano();
                    if (nano2 != 0) {
                        nano3 = duration.getNano();
                        return nano3 - Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
                    }
                }
                nano = duration.getNano();
                return nano;
            }

            private final long getSameSignSeconds(Duration duration) {
                long seconds;
                long seconds2;
                int nano;
                long seconds3;
                seconds = duration.getSeconds();
                if (seconds < 0) {
                    nano = duration.getNano();
                    if (nano != 0) {
                        seconds3 = duration.getSeconds();
                        return seconds3 + 1;
                    }
                }
                seconds2 = duration.getSeconds();
                return seconds2;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Duration duration) {
                encode2(protoWriter, h.a(duration));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Duration duration) {
                return encodedSize2(h.a(duration));
            }

            @NotNull
            /* renamed from: redact, reason: avoid collision after fix types in other method */
            public Duration redact2(@NotNull Duration value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value;
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Duration decode(@NotNull ProtoReader reader) {
                Duration ofSeconds;
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                long j = 0;
                int i = 0;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        reader.endMessageAndGetUnknownFields(beginMessage);
                        ofSeconds = Duration.ofSeconds(j, i);
                        Intrinsics.checkNotNullExpressionValue(ofSeconds, "ofSeconds(seconds, nano)");
                        return ofSeconds;
                    }
                    if (nextTag == 1) {
                        j = ProtoAdapter.INT64.decode(reader).longValue();
                    } else if (nextTag != 2) {
                        reader.readUnknownField(nextTag);
                    } else {
                        i = ProtoAdapter.INT32.decode(reader).intValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Duration duration) {
                encode2(reverseProtoWriter, h.a(duration));
            }

            /* renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(@NotNull Duration value) {
                Intrinsics.checkNotNullParameter(value, "value");
                long sameSignSeconds = getSameSignSeconds(value);
                int encodedSizeWithTag = sameSignSeconds != 0 ? ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(sameSignSeconds)) : 0;
                int sameSignNanos = getSameSignNanos(value);
                return sameSignNanos != 0 ? encodedSizeWithTag + ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(sameSignNanos)) : encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Duration redact(Duration duration) {
                return redact2(h.a(duration));
            }

            /* renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(@NotNull ProtoWriter writer, @NotNull Duration value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                long sameSignSeconds = getSameSignSeconds(value);
                if (sameSignSeconds != 0) {
                    ProtoAdapter.INT64.encodeWithTag(writer, 1, (int) Long.valueOf(sameSignSeconds));
                }
                int sameSignNanos = getSameSignNanos(value);
                if (sameSignNanos != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 2, (int) Integer.valueOf(sameSignNanos));
                }
            }

            /* renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(@NotNull ReverseProtoWriter writer, @NotNull Duration value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                int sameSignNanos = getSameSignNanos(value);
                if (sameSignNanos != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 2, (int) Integer.valueOf(sameSignNanos));
                }
                long sameSignSeconds = getSameSignSeconds(value);
                if (sameSignSeconds != 0) {
                    ProtoAdapter.INT64.encodeWithTag(writer, 1, (int) Long.valueOf(sameSignSeconds));
                }
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Unit> commonEmpty() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Unit.class);
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter<Unit>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonEmpty$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Unit decode(ProtoReader protoReader) {
                decode2(protoReader);
                return Unit.INSTANCE;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull Unit value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull Unit value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return 0;
            }

            /* renamed from: redact, reason: avoid collision after fix types in other method */
            public void redact2(@NotNull Unit value) {
                Intrinsics.checkNotNullParameter(value, "value");
            }

            /* renamed from: decode, reason: avoid collision after fix types in other method */
            public void decode2(@NotNull ProtoReader reader) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        reader.endMessageAndGetUnknownFields(beginMessage);
                        return;
                    }
                    reader.readUnknownField(nextTag);
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ReverseProtoWriter writer, @NotNull Unit value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Unit redact(Unit unit) {
                redact2(unit);
                return Unit.INSTANCE;
            }
        };
    }

    public static final <E> void commonEncode(@NotNull ProtoAdapter<E> protoAdapter, @NotNull BufferedSink bufferedSink, E e) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Intrinsics.checkNotNullParameter(bufferedSink, "sink");
        ReverseProtoWriter reverseProtoWriter = new ReverseProtoWriter();
        protoAdapter.encode(reverseProtoWriter, (ReverseProtoWriter) e);
        reverseProtoWriter.writeTo(bufferedSink);
    }

    @NotNull
    public static final <E> ByteString commonEncodeByteString(@NotNull ProtoAdapter<E> protoAdapter, E e) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Buffer buffer = new Buffer();
        protoAdapter.encode((BufferedSink) buffer, (Buffer) e);
        return buffer.readByteString();
    }

    public static final <E> void commonEncodeWithTag(@NotNull ProtoAdapter<E> protoAdapter, @NotNull ProtoWriter protoWriter, int i, @Nullable E e) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        if (e == null) {
            return;
        }
        protoWriter.writeTag(i, protoAdapter.getFieldEncoding());
        if (protoAdapter.getFieldEncoding() == FieldEncoding.LENGTH_DELIMITED) {
            protoWriter.writeVarint32(protoAdapter.encodedSize(e));
        }
        protoAdapter.encode(protoWriter, (ProtoWriter) e);
    }

    public static final <E> int commonEncodedSizeWithTag(@NotNull ProtoAdapter<E> protoAdapter, int i, @Nullable E e) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        if (e == null) {
            return 0;
        }
        int encodedSize = protoAdapter.encodedSize(e);
        if (protoAdapter.getFieldEncoding() == FieldEncoding.LENGTH_DELIMITED) {
            encodedSize += ProtoWriter.INSTANCE.varint32Size$wire_runtime(encodedSize);
        }
        return encodedSize + ProtoWriter.INSTANCE.tagSize$wire_runtime(i);
    }

    @NotNull
    public static final ProtoAdapter<Integer> commonFixed32() {
        final FieldEncoding fieldEncoding = FieldEncoding.FIXED32;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Integer>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonFixed32$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Integer num) {
                encode(protoWriter, num.intValue());
            }

            public int encodedSize(int value) {
                return 4;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Integer redact(Integer num) {
                return redact(num.intValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Integer decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Integer.valueOf(reader.readFixed32());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Integer num) {
                encode(reverseProtoWriter, num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Integer num) {
                return encodedSize(num.intValue());
            }

            @NotNull
            public Integer redact(int value) {
                throw new UnsupportedOperationException();
            }

            public void encode(@NotNull ProtoWriter writer, int value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeFixed32(value);
            }

            public void encode(@NotNull ReverseProtoWriter writer, int value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeFixed32(value);
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Long> commonFixed64() {
        final FieldEncoding fieldEncoding = FieldEncoding.FIXED64;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Long>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonFixed64$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Long l) {
                encode(protoWriter, l.longValue());
            }

            public int encodedSize(long value) {
                return 8;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Long redact(Long l) {
                return redact(l.longValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Long decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Long.valueOf(reader.readFixed64());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Long l) {
                encode(reverseProtoWriter, l.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Long l) {
                return encodedSize(l.longValue());
            }

            @NotNull
            public Long redact(long value) {
                throw new UnsupportedOperationException();
            }

            public void encode(@NotNull ProtoWriter writer, long value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeFixed64(value);
            }

            public void encode(@NotNull ReverseProtoWriter writer, long value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeFixed64(value);
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Float> commonFloat() {
        final FieldEncoding fieldEncoding = FieldEncoding.FIXED32;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Float.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Float>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonFloat$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Float valueOf = Float.valueOf(0.0f);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Float f) {
                encode(protoWriter, f.floatValue());
            }

            public int encodedSize(float value) {
                return 4;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Float redact(Float f) {
                return redact(f.floatValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Float decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
                return Float.valueOf(Float.intBitsToFloat(reader.readFixed32()));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Float f) {
                encode(reverseProtoWriter, f.floatValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Float f) {
                return encodedSize(f.floatValue());
            }

            @NotNull
            public Float redact(float value) {
                throw new UnsupportedOperationException();
            }

            public void encode(@NotNull ProtoWriter writer, float value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeFixed32(Float.floatToIntBits(value));
            }

            public void encode(@NotNull ReverseProtoWriter writer, float value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeFixed32(Float.floatToIntBits(value));
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Instant> commonInstant() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(f.a());
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter<Instant>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonInstant$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Instant instant) {
                encode2(protoWriter, k.a(instant));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Instant instant) {
                return encodedSize2(k.a(instant));
            }

            @NotNull
            /* renamed from: redact, reason: avoid collision after fix types in other method */
            public Instant redact2(@NotNull Instant value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value;
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Instant decode(@NotNull ProtoReader reader) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                long j = 0;
                int i = 0;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        reader.endMessageAndGetUnknownFields(beginMessage);
                        Instant a = com.google.firebase.h.a(j, i);
                        Intrinsics.checkNotNullExpressionValue(a, "ofEpochSecond(epochSecond, nano)");
                        return a;
                    }
                    if (nextTag == 1) {
                        j = ProtoAdapter.INT64.decode(reader).longValue();
                    } else if (nextTag != 2) {
                        reader.readUnknownField(nextTag);
                    } else {
                        i = ProtoAdapter.INT32.decode(reader).intValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Instant instant) {
                encode2(reverseProtoWriter, k.a(instant));
            }

            /* renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(@NotNull Instant value) {
                Intrinsics.checkNotNullParameter(value, "value");
                long a = com.google.firebase.i.a(value);
                int encodedSizeWithTag = a != 0 ? ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(a)) : 0;
                int a2 = com.google.firebase.j.a(value);
                return a2 != 0 ? encodedSizeWithTag + ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(a2)) : encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Instant redact(Instant instant) {
                return redact2(k.a(instant));
            }

            /* renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(@NotNull ProtoWriter writer, @NotNull Instant value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                long a = com.google.firebase.i.a(value);
                if (a != 0) {
                    ProtoAdapter.INT64.encodeWithTag(writer, 1, (int) Long.valueOf(a));
                }
                int a2 = com.google.firebase.j.a(value);
                if (a2 != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 2, (int) Integer.valueOf(a2));
                }
            }

            /* renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(@NotNull ReverseProtoWriter writer, @NotNull Instant value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                int a = com.google.firebase.j.a(value);
                if (a != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 2, (int) Integer.valueOf(a));
                }
                long a2 = com.google.firebase.i.a(value);
                if (a2 != 0) {
                    ProtoAdapter.INT64.encodeWithTag(writer, 1, (int) Long.valueOf(a2));
                }
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Integer> commonInt32() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Integer>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonInt32$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Integer num) {
                encode(protoWriter, num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Integer num) {
                return encodedSize(num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Integer redact(Integer num) {
                return redact(num.intValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Integer decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Integer.valueOf(reader.readVarint32());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Integer num) {
                encode(reverseProtoWriter, num.intValue());
            }

            public int encodedSize(int value) {
                return ProtoWriter.INSTANCE.int32Size$wire_runtime(value);
            }

            @NotNull
            public Integer redact(int value) {
                throw new UnsupportedOperationException();
            }

            public void encode(@NotNull ProtoWriter writer, int value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeSignedVarint32$wire_runtime(value);
            }

            public void encode(@NotNull ReverseProtoWriter writer, int value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeSignedVarint32$wire_runtime(value);
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Long> commonInt64() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Long>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonInt64$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Long l) {
                encode(protoWriter, l.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Long l) {
                return encodedSize(l.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Long redact(Long l) {
                return redact(l.longValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Long decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Long.valueOf(reader.readVarint64());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Long l) {
                encode(reverseProtoWriter, l.longValue());
            }

            public int encodedSize(long value) {
                return ProtoWriter.INSTANCE.varint64Size$wire_runtime(value);
            }

            @NotNull
            public Long redact(long value) {
                throw new UnsupportedOperationException();
            }

            public void encode(@NotNull ProtoWriter writer, long value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint64(value);
            }

            public void encode(@NotNull ReverseProtoWriter writer, long value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint64(value);
            }
        };
    }

    @NotNull
    public static final <K, V> ProtoAdapter<Map<K, V>> commonNewMapAdapter(@NotNull ProtoAdapter<K> protoAdapter, @NotNull ProtoAdapter<V> protoAdapter2) {
        Intrinsics.checkNotNullParameter(protoAdapter, "keyAdapter");
        Intrinsics.checkNotNullParameter(protoAdapter2, "valueAdapter");
        return new MapProtoAdapter(protoAdapter, protoAdapter2);
    }

    @NotNull
    public static final ProtoAdapter<Integer> commonSfixed32() {
        return commonFixed32();
    }

    @NotNull
    public static final ProtoAdapter<Long> commonSfixed64() {
        return commonFixed64();
    }

    @NotNull
    public static final ProtoAdapter<Integer> commonSint32() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Integer>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonSint32$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Integer num) {
                encode(protoWriter, num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Integer num) {
                return encodedSize(num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Integer redact(Integer num) {
                return redact(num.intValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Integer decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Integer.valueOf(ProtoWriter.INSTANCE.decodeZigZag32$wire_runtime(reader.readVarint32()));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Integer num) {
                encode(reverseProtoWriter, num.intValue());
            }

            public int encodedSize(int value) {
                ProtoWriter.Companion companion = ProtoWriter.INSTANCE;
                return companion.varint32Size$wire_runtime(companion.encodeZigZag32$wire_runtime(value));
            }

            @NotNull
            public Integer redact(int value) {
                throw new UnsupportedOperationException();
            }

            public void encode(@NotNull ProtoWriter writer, int value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint32(ProtoWriter.INSTANCE.encodeZigZag32$wire_runtime(value));
            }

            public void encode(@NotNull ReverseProtoWriter writer, int value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint32(ProtoWriter.INSTANCE.encodeZigZag32$wire_runtime(value));
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Long> commonSint64() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Long>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonSint64$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Long l) {
                encode(protoWriter, l.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Long l) {
                return encodedSize(l.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Long redact(Long l) {
                return redact(l.longValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Long decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Long.valueOf(ProtoWriter.INSTANCE.decodeZigZag64$wire_runtime(reader.readVarint64()));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Long l) {
                encode(reverseProtoWriter, l.longValue());
            }

            public int encodedSize(long value) {
                ProtoWriter.Companion companion = ProtoWriter.INSTANCE;
                return companion.varint64Size$wire_runtime(companion.encodeZigZag64$wire_runtime(value));
            }

            @NotNull
            public Long redact(long value) {
                throw new UnsupportedOperationException();
            }

            public void encode(@NotNull ProtoWriter writer, long value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint64(ProtoWriter.INSTANCE.encodeZigZag64$wire_runtime(value));
            }

            public void encode(@NotNull ReverseProtoWriter writer, long value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint64(ProtoWriter.INSTANCE.encodeZigZag64$wire_runtime(value));
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<String> commonString() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<String>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonString$1
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public String decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return reader.readString();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (int) Utf8.size$default(value, 0, 0, 3, (Object) null);
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public String redact(@NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                throw new UnsupportedOperationException();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull String value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                writer.writeString(value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ReverseProtoWriter writer, @NotNull String value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                writer.writeString(value);
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<List<?>> commonStructList() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Map.class);
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter<List<?>>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonStructList$1
            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public List<?> decode(@NotNull ProtoReader reader) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long beginMessage = reader.beginMessage();
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        reader.endMessageAndGetUnknownFields(beginMessage);
                        return arrayList;
                    }
                    if (nextTag != 1) {
                        reader.skip();
                    } else {
                        arrayList.add(ProtoAdapter.STRUCT_VALUE.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@Nullable List<?> value) {
                int i = 0;
                if (value == null) {
                    return 0;
                }
                Iterator<?> it = value.iterator();
                while (it.hasNext()) {
                    i += ProtoAdapter.STRUCT_VALUE.encodedSizeWithTag(1, it.next());
                }
                return i;
            }

            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public List<Object> redact(@Nullable List<?> value) {
                if (value == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(value, 10));
                Iterator<T> it = value.iterator();
                while (it.hasNext()) {
                    arrayList.add(ProtoAdapter.STRUCT_VALUE.redact(it.next()));
                }
                return arrayList;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @Nullable List<?> value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value == null) {
                    return;
                }
                Iterator<?> it = value.iterator();
                while (it.hasNext()) {
                    ProtoAdapter.STRUCT_VALUE.encodeWithTag(writer, 1, (int) it.next());
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ReverseProtoWriter writer, @Nullable List<?> value) {
                int size;
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value == null || (size = value.size() - 1) < 0) {
                    return;
                }
                while (true) {
                    int i = size - 1;
                    ProtoAdapter.STRUCT_VALUE.encodeWithTag(writer, 1, (int) value.get(size));
                    if (i < 0) {
                        return;
                    } else {
                        size = i;
                    }
                }
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Map<String, ?>> commonStructMap() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Map.class);
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter<Map<String, ?>>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonStructMap$1
            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public Map<String, ?> decode(@NotNull ProtoReader reader) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                long beginMessage = reader.beginMessage();
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        reader.endMessageAndGetUnknownFields(beginMessage);
                        return linkedHashMap;
                    }
                    if (nextTag != 1) {
                        reader.skip();
                    } else {
                        long beginMessage2 = reader.beginMessage();
                        String str = null;
                        Object obj = null;
                        while (true) {
                            int nextTag2 = reader.nextTag();
                            if (nextTag2 == -1) {
                                break;
                            }
                            if (nextTag2 == 1) {
                                str = ProtoAdapter.STRING.decode(reader);
                            } else if (nextTag2 != 2) {
                                reader.readUnknownField(nextTag2);
                            } else {
                                obj = ProtoAdapter.STRUCT_VALUE.decode(reader);
                            }
                        }
                        reader.endMessageAndGetUnknownFields(beginMessage2);
                        if (str != null) {
                            linkedHashMap.put(str, obj);
                        }
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@Nullable Map<String, ?> value) {
                int i = 0;
                if (value == null) {
                    return 0;
                }
                for (Map.Entry<String, ?> entry : value.entrySet()) {
                    int encodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(1, entry.getKey()) + ProtoAdapter.STRUCT_VALUE.encodedSizeWithTag(2, entry.getValue());
                    ProtoWriter.Companion companion = ProtoWriter.INSTANCE;
                    i += companion.tagSize$wire_runtime(1) + companion.varint32Size$wire_runtime(encodedSizeWithTag) + encodedSizeWithTag;
                }
                return i;
            }

            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public Map<String, Object> redact(@Nullable Map<String, ?> value) {
                if (value == null) {
                    return null;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(value.size()));
                Iterator<T> it = value.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    linkedHashMap.put(entry.getKey(), ProtoAdapter.STRUCT_VALUE.redact(entry));
                }
                return linkedHashMap;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @Nullable Map<String, ?> value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value == null) {
                    return;
                }
                for (Map.Entry<String, ?> entry : value.entrySet()) {
                    String key = entry.getKey();
                    Object value2 = entry.getValue();
                    ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
                    int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, key);
                    ProtoAdapter<Object> protoAdapter2 = ProtoAdapter.STRUCT_VALUE;
                    int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(2, value2);
                    writer.writeTag(1, FieldEncoding.LENGTH_DELIMITED);
                    writer.writeVarint32(encodedSizeWithTag2);
                    protoAdapter.encodeWithTag(writer, 1, (int) key);
                    protoAdapter2.encodeWithTag(writer, 2, (int) value2);
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ReverseProtoWriter writer, @Nullable Map<String, ?> value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value == null) {
                    return;
                }
                int i = 0;
                Object[] array = value.entrySet().toArray(new Map.Entry[0]);
                if (array != null) {
                    Map.Entry[] entryArr = (Map.Entry[]) array;
                    ArraysKt.reverse(entryArr);
                    int length = entryArr.length;
                    while (i < length) {
                        Map.Entry entry = entryArr[i];
                        i++;
                        String str = (String) entry.getKey();
                        Object value2 = entry.getValue();
                        int byteCount = writer.getByteCount();
                        ProtoAdapter.STRUCT_VALUE.encodeWithTag(writer, 2, (int) value2);
                        ProtoAdapter.STRING.encodeWithTag(writer, 1, (int) str);
                        writer.writeVarint32(writer.getByteCount() - byteCount);
                        writer.writeTag(1, FieldEncoding.LENGTH_DELIMITED);
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        };
    }

    @NotNull
    public static final ProtoAdapter commonStructNull() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Void.class);
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonStructNull$1
            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public Void redact(@Nullable Void value) {
                return null;
            }

            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public Void decode(@NotNull ProtoReader reader) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                int readVarint32 = reader.readVarint32();
                if (readVarint32 == 0) {
                    return null;
                }
                throw new IOException(Intrinsics.stringPlus("expected 0 but was ", Integer.valueOf(readVarint32)));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@Nullable Void value) {
                return ProtoWriter.INSTANCE.varint32Size$wire_runtime(0);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSizeWithTag(int tag, @Nullable Void value) {
                int encodedSize = encodedSize(value);
                ProtoWriter.Companion companion = ProtoWriter.INSTANCE;
                return companion.tagSize$wire_runtime(tag) + companion.varint32Size$wire_runtime(encodedSize);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @Nullable Void value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint32(0);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encodeWithTag(@NotNull ProtoWriter writer, int tag, @Nullable Void value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeTag(tag, getFieldEncoding());
                encode(writer, value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ReverseProtoWriter writer, @Nullable Void value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint32(0);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encodeWithTag(@NotNull ReverseProtoWriter writer, int tag, @Nullable Void value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                encode(writer, value);
                writer.writeTag(tag, getFieldEncoding());
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Object> commonStructValue() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter<Object>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonStructValue$1
            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public Object decode(@NotNull ProtoReader reader) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                Object obj = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        reader.endMessageAndGetUnknownFields(beginMessage);
                        return obj;
                    }
                    switch (nextTag) {
                        case 1:
                            obj = ProtoAdapter.STRUCT_NULL.decode(reader);
                            break;
                        case 2:
                            obj = ProtoAdapter.DOUBLE.decode(reader);
                            break;
                        case 3:
                            obj = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            obj = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 5:
                            obj = ProtoAdapter.STRUCT_MAP.decode(reader);
                            break;
                        case 6:
                            obj = ProtoAdapter.STRUCT_LIST.decode(reader);
                            break;
                        default:
                            reader.skip();
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @Nullable Object value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value == null) {
                    ProtoAdapter.STRUCT_NULL.encodeWithTag(writer, 1, (int) value);
                    return;
                }
                if (value instanceof Number) {
                    ProtoAdapter.DOUBLE.encodeWithTag(writer, 2, (int) Double.valueOf(((Number) value).doubleValue()));
                    return;
                }
                if (value instanceof String) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, (int) value);
                    return;
                }
                if (value instanceof Boolean) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 4, (int) value);
                } else if (value instanceof Map) {
                    ProtoAdapter.STRUCT_MAP.encodeWithTag(writer, 5, (int) value);
                } else {
                    if (!(value instanceof List)) {
                        throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected struct value: ", value));
                    }
                    ProtoAdapter.STRUCT_LIST.encodeWithTag(writer, 6, (int) value);
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encodeWithTag(@NotNull ProtoWriter writer, int tag, @Nullable Object value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value == null) {
                    writer.writeTag(tag, getFieldEncoding());
                    writer.writeVarint32(encodedSize(value));
                    encode(writer, value);
                    return;
                }
                super.encodeWithTag(writer, tag, (int) value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@Nullable Object value) {
                if (value == null) {
                    return ProtoAdapter.STRUCT_NULL.encodedSizeWithTag(1, value);
                }
                if (value instanceof Number) {
                    return ProtoAdapter.DOUBLE.encodedSizeWithTag(2, Double.valueOf(((Number) value).doubleValue()));
                }
                if (value instanceof String) {
                    return ProtoAdapter.STRING.encodedSizeWithTag(3, value);
                }
                if (value instanceof Boolean) {
                    return ProtoAdapter.BOOL.encodedSizeWithTag(4, value);
                }
                if (value instanceof Map) {
                    return ProtoAdapter.STRUCT_MAP.encodedSizeWithTag(5, (Map) value);
                }
                if (value instanceof List) {
                    return ProtoAdapter.STRUCT_LIST.encodedSizeWithTag(6, value);
                }
                throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected struct value: ", value));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSizeWithTag(int tag, @Nullable Object value) {
                if (value == null) {
                    int encodedSize = encodedSize(value);
                    ProtoWriter.Companion companion = ProtoWriter.INSTANCE;
                    return companion.tagSize$wire_runtime(tag) + companion.varint32Size$wire_runtime(encodedSize) + encodedSize;
                }
                return super.encodedSizeWithTag(tag, value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public Object redact(@Nullable Object value) {
                if (value == null) {
                    return ProtoAdapter.STRUCT_NULL.redact(value);
                }
                if (!(value instanceof Number)) {
                    if (value instanceof String) {
                        return null;
                    }
                    if (!(value instanceof Boolean)) {
                        if (value instanceof Map) {
                            return ProtoAdapter.STRUCT_MAP.redact((Map) value);
                        }
                        if (value instanceof List) {
                            return ProtoAdapter.STRUCT_LIST.redact(value);
                        }
                        throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected struct value: ", value));
                    }
                    return value;
                }
                return value;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encodeWithTag(@NotNull ReverseProtoWriter writer, int tag, @Nullable Object value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value == null) {
                    int byteCount = writer.getByteCount();
                    encode(writer, value);
                    writer.writeVarint32(writer.getByteCount() - byteCount);
                    writer.writeTag(tag, getFieldEncoding());
                    return;
                }
                super.encodeWithTag(writer, tag, (int) value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ReverseProtoWriter writer, @Nullable Object value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value == null) {
                    ProtoAdapter.STRUCT_NULL.encodeWithTag(writer, 1, (int) value);
                    return;
                }
                if (value instanceof Number) {
                    ProtoAdapter.DOUBLE.encodeWithTag(writer, 2, (int) Double.valueOf(((Number) value).doubleValue()));
                    return;
                }
                if (value instanceof String) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, (int) value);
                    return;
                }
                if (value instanceof Boolean) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 4, (int) value);
                } else if (value instanceof Map) {
                    ProtoAdapter.STRUCT_MAP.encodeWithTag(writer, 5, (int) value);
                } else {
                    if (!(value instanceof List)) {
                        throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected struct value: ", value));
                    }
                    ProtoAdapter.STRUCT_LIST.encodeWithTag(writer, 6, (int) value);
                }
            }
        };
    }

    @NotNull
    public static final <E> String commonToString(E e) {
        return String.valueOf(e);
    }

    @NotNull
    public static final ProtoAdapter<Integer> commonUint32() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Integer>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonUint32$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Integer num) {
                encode(protoWriter, num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Integer num) {
                return encodedSize(num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Integer redact(Integer num) {
                return redact(num.intValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Integer decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Integer.valueOf(reader.readVarint32());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Integer num) {
                encode(reverseProtoWriter, num.intValue());
            }

            public int encodedSize(int value) {
                return ProtoWriter.INSTANCE.varint32Size$wire_runtime(value);
            }

            @NotNull
            public Integer redact(int value) {
                throw new UnsupportedOperationException();
            }

            public void encode(@NotNull ProtoWriter writer, int value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint32(value);
            }

            public void encode(@NotNull ReverseProtoWriter writer, int value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint32(value);
            }
        };
    }

    @NotNull
    public static final ProtoAdapter<Long> commonUint64() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Long>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonUint64$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Long l) {
                encode(protoWriter, l.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Long l) {
                return encodedSize(l.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Long redact(Long l) {
                return redact(l.longValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Long decode(@NotNull ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Long.valueOf(reader.readVarint64());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Long l) {
                encode(reverseProtoWriter, l.longValue());
            }

            public int encodedSize(long value) {
                return ProtoWriter.INSTANCE.varint64Size$wire_runtime(value);
            }

            @NotNull
            public Long redact(long value) {
                throw new UnsupportedOperationException();
            }

            public void encode(@NotNull ProtoWriter writer, long value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint64(value);
            }

            public void encode(@NotNull ReverseProtoWriter writer, long value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint64(value);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <E> ProtoAdapter<?> commonWithLabel(@NotNull ProtoAdapter<E> protoAdapter, @NotNull WireField.Label label) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Intrinsics.checkNotNullParameter(label, "label");
        if (label.isRepeated()) {
            if (label.isPacked()) {
                return protoAdapter.asPacked();
            }
            return protoAdapter.asRepeated();
        }
        return protoAdapter;
    }

    @NotNull
    public static final <T> ProtoAdapter<T> commonWrapper(@NotNull final ProtoAdapter<T> protoAdapter, @NotNull final String str) {
        Intrinsics.checkNotNullParameter(protoAdapter, "delegate");
        Intrinsics.checkNotNullParameter(str, "typeUrl");
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass<?> type = protoAdapter.getType();
        final Syntax syntax = Syntax.PROTO_3;
        final T identity = protoAdapter.getIdentity();
        return new ProtoAdapter<T>(str, protoAdapter, fieldEncoding, type, syntax, identity) { // from class: com.squareup.wire.ProtoAdapterKt$commonWrapper$1
            final /* synthetic */ ProtoAdapter<T> $delegate;
            final /* synthetic */ String $typeUrl;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(fieldEncoding, type, str, syntax, identity);
                this.$typeUrl = str;
                this.$delegate = protoAdapter;
            }

            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public T decode(@NotNull ProtoReader reader) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                T identity2 = this.$delegate.getIdentity();
                ProtoAdapter<T> protoAdapter2 = this.$delegate;
                long beginMessage = reader.beginMessage();
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        reader.endMessageAndGetUnknownFields(beginMessage);
                        return identity2;
                    }
                    if (nextTag == 1) {
                        identity2 = protoAdapter2.decode(reader);
                    } else {
                        reader.readUnknownField(nextTag);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @Nullable T value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value == null || Intrinsics.areEqual(value, this.$delegate.getIdentity())) {
                    return;
                }
                this.$delegate.encodeWithTag(writer, 1, (int) value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@Nullable T value) {
                if (value != null && !Intrinsics.areEqual(value, this.$delegate.getIdentity())) {
                    return this.$delegate.encodedSizeWithTag(1, value);
                }
                return 0;
            }

            @Override // com.squareup.wire.ProtoAdapter
            @Nullable
            public T redact(@Nullable T value) {
                if (value == null) {
                    return null;
                }
                return this.$delegate.redact(value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ReverseProtoWriter writer, @Nullable T value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value == null || Intrinsics.areEqual(value, this.$delegate.getIdentity())) {
                    return;
                }
                this.$delegate.encodeWithTag(writer, 1, (int) value);
            }
        };
    }

    public static final <E> void delegateEncode(@NotNull ProtoAdapter<E> protoAdapter, @NotNull ReverseProtoWriter reverseProtoWriter, E e) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        reverseProtoWriter.writeForward$wire_runtime(new ProtoAdapterKt$delegateEncode$1(protoAdapter, e));
    }

    public static final <E> E commonDecode(@NotNull ProtoAdapter<E> protoAdapter, @NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        return protoAdapter.decode((BufferedSource) new Buffer().write(byteString));
    }

    public static final <E> E commonDecode(@NotNull ProtoAdapter<E> protoAdapter, @NotNull BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        return protoAdapter.decode(new ProtoReader(bufferedSource));
    }

    @NotNull
    public static final <E> byte[] commonEncode(@NotNull ProtoAdapter<E> protoAdapter, E e) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Buffer buffer = new Buffer();
        protoAdapter.encode((BufferedSink) buffer, (Buffer) e);
        return buffer.readByteArray();
    }

    public static final <E> void commonEncodeWithTag(@NotNull ProtoAdapter<E> protoAdapter, @NotNull ReverseProtoWriter reverseProtoWriter, int i, @Nullable E e) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        if (e == null) {
            return;
        }
        if (protoAdapter.getFieldEncoding() == FieldEncoding.LENGTH_DELIMITED) {
            int byteCount = reverseProtoWriter.getByteCount();
            protoAdapter.encode(reverseProtoWriter, (ReverseProtoWriter) e);
            reverseProtoWriter.writeVarint32(reverseProtoWriter.getByteCount() - byteCount);
        } else {
            protoAdapter.encode(reverseProtoWriter, (ReverseProtoWriter) e);
        }
        reverseProtoWriter.writeTag(i, protoAdapter.getFieldEncoding());
    }
}
