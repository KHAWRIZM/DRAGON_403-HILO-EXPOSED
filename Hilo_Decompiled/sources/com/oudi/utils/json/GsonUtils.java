package com.oudi.utils.json;

import com.google.gson.d;
import com.google.gson.e;
import com.google.gson.reflect.TypeToken;
import com.oudi.utils.json.GsonAnyTypeAdapter;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\f\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Lcom/oudi/utils/json/GsonUtils;", "", "<init>", "()V", "Lcom/google/gson/d;", "gson$delegate", "Lkotlin/Lazy;", "getGson", "()Lcom/google/gson/d;", "gson", "intGson$delegate", "getIntGson", "intGson", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class GsonUtils {
    public static final GsonUtils INSTANCE = new GsonUtils();

    /* renamed from: gson$delegate, reason: from kotlin metadata */
    private static final Lazy gson = LazyKt.lazy(new Function0() { // from class: com.oudi.utils.json.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            d gson_delegate$lambda$0;
            gson_delegate$lambda$0 = GsonUtils.gson_delegate$lambda$0();
            return gson_delegate$lambda$0;
        }
    });

    /* renamed from: intGson$delegate, reason: from kotlin metadata */
    private static final Lazy intGson = LazyKt.lazy(new Function0() { // from class: com.oudi.utils.json.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            d intGson_delegate$lambda$1;
            intGson_delegate$lambda$1 = GsonUtils.intGson_delegate$lambda$1();
            return intGson_delegate$lambda$1;
        }
    });

    private GsonUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d gson_delegate$lambda$0() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d intGson_delegate$lambda$1() {
        e eVar = new e();
        GsonAnyTypeAdapter.Companion companion = GsonAnyTypeAdapter.INSTANCE;
        Type type = new TypeToken<Map<String, Object>>() { // from class: com.oudi.utils.json.GsonUtils$intGson$2$1
        }.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return eVar.d(companion.newFactory(type)).b();
    }

    public final d getGson() {
        return (d) gson.getValue();
    }

    public final d getIntGson() {
        Object value = intGson.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (d) value;
    }
}
