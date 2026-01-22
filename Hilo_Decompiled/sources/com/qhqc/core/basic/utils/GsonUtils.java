package com.qhqc.core.basic.utils;

import com.google.gson.d;
import com.google.gson.e;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import com.google.gson.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/qhqc/core/basic/utils/GsonUtils;", "", "<init>", "()V", "Lcom/google/gson/d;", "getGson", "()Lcom/google/gson/d;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class GsonUtils {

    @NotNull
    public static final GsonUtils INSTANCE = new GsonUtils();

    private GsonUtils() {
    }

    @NotNull
    public final d getGson() {
        d b10 = new e().d(new x() { // from class: com.qhqc.core.basic.utils.GsonUtils$getGson$1
            @Override // com.google.gson.x
            @Nullable
            public <T> w create(@Nullable d gson, @NotNull TypeToken<T> type) {
                Intrinsics.checkNotNullParameter(type, "type");
                Class<? super T> rawType = type.getRawType();
                if (Intrinsics.areEqual(rawType, String.class)) {
                    return new w() { // from class: com.qhqc.core.basic.utils.GsonUtils$getGson$1$create$1
                        @Override // com.google.gson.w
                        @NotNull
                        public String read(@NotNull JsonReader reader) {
                            Intrinsics.checkNotNullParameter(reader, "reader");
                            if (reader.peek() == JsonToken.NULL) {
                                reader.nextNull();
                                return "";
                            }
                            String nextString = reader.nextString();
                            Intrinsics.checkNotNullExpressionValue(nextString, "nextString(...)");
                            return nextString;
                        }

                        @Override // com.google.gson.w
                        public void write(@Nullable JsonWriter out, @Nullable String value) {
                            if (value == null) {
                                if (out != null) {
                                    out.value("");
                                }
                            } else if (out != null) {
                                out.value(value);
                            }
                        }
                    };
                }
                if (Intrinsics.areEqual(rawType, Integer.TYPE)) {
                    return new w() { // from class: com.qhqc.core.basic.utils.GsonUtils$getGson$1$create$2
                        @Override // com.google.gson.w
                        @NotNull
                        public Integer read(@NotNull JsonReader reader) {
                            Intrinsics.checkNotNullParameter(reader, "reader");
                            int i10 = 0;
                            if (reader.peek() == JsonToken.NULL) {
                                reader.nextNull();
                                return 0;
                            }
                            try {
                                String nextString = reader.nextString();
                                Intrinsics.checkNotNullExpressionValue(nextString, "nextString(...)");
                                i10 = Integer.parseInt(nextString);
                            } catch (NumberFormatException unused) {
                            }
                            return Integer.valueOf(i10);
                        }

                        @Override // com.google.gson.w
                        public void write(@Nullable JsonWriter out, @Nullable Integer value) {
                            if (value == null) {
                                if (out != null) {
                                    out.value(0L);
                                }
                            } else if (out != null) {
                                out.value(value);
                            }
                        }
                    };
                }
                return null;
            }
        }).b();
        Intrinsics.checkNotNullExpressionValue(b10, "create(...)");
        return b10;
    }
}
