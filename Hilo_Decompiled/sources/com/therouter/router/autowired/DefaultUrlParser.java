package com.therouter.router.autowired;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.taobao.accs.common.Constants;
import com.therouter.router.AutowiredItem;
import com.therouter.router.interceptor.AutowiredParser;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000bJ)\u0010\f\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/therouter/router/autowired/DefaultUrlParser;", "Lcom/therouter/router/interceptor/AutowiredParser;", "()V", "parse", "T", "type", "", Constants.KEY_TARGET, "", "item", "Lcom/therouter/router/AutowiredItem;", "(Ljava/lang/String;Ljava/lang/Object;Lcom/therouter/router/AutowiredItem;)Ljava/lang/Object;", "parseValue", "value", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class DefaultUrlParser implements AutowiredParser {
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007d, code lost:
    
        r7 = com.therouter.router.autowired.DefaultUrlParserKt.foundClass(r7);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <T> T parseValue(Object value, String type) {
        boolean javaTypeEqualsKotlinType;
        Class foundClass;
        String str;
        Class foundClass2;
        Object transform;
        if (value == 0 || type == null) {
            return null;
        }
        String name = value.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        javaTypeEqualsKotlinType = DefaultUrlParserKt.javaTypeEqualsKotlinType(name, type);
        if (javaTypeEqualsKotlinType) {
            return value;
        }
        if (Intrinsics.areEqual(value.getClass().getName(), "java.lang.String") || Intrinsics.areEqual(value.getClass().getName(), "kotlin.String")) {
            try {
                transform = DefaultUrlParserKt.transform(type, value.toString());
                return (T) transform;
            } catch (NumberFormatException unused) {
            }
        }
        if (!(value instanceof Serializable) && !(value instanceof Parcelable)) {
            String name2 = value.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            if (StringsKt.contains$default(name2, '$', false, 2, (Object) null)) {
                foundClass = DefaultUrlParserKt.foundClass(type);
                if (foundClass != null) {
                    str = foundClass.getName();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, value.getClass().getName()) || (foundClass2 != null && foundClass2.isAssignableFrom(value.getClass()))) {
                    return value;
                }
            }
            return null;
        }
        return value;
    }

    @Override // com.therouter.router.interceptor.AutowiredParser
    @Nullable
    public <T> T parse(@Nullable String type, @Nullable Object target, @Nullable AutowiredItem item) {
        Bundle extras;
        Object obj = null;
        if (item != null && item.getId() == 0) {
            if (target instanceof Activity) {
                Intent intent = ((Activity) target).getIntent();
                if (intent != null && (extras = intent.getExtras()) != null) {
                    obj = extras.get(item.getKey());
                }
                return (T) parseValue(obj, type);
            }
            if (target instanceof Fragment) {
                Bundle arguments = ((Fragment) target).getArguments();
                if (arguments != null) {
                    obj = arguments.get(item.getKey());
                }
                return (T) parseValue(obj, type);
            }
            if (target instanceof androidx.fragment.app.Fragment) {
                Bundle arguments2 = ((androidx.fragment.app.Fragment) target).getArguments();
                if (arguments2 != null) {
                    obj = arguments2.get(item.getKey());
                }
                return (T) parseValue(obj, type);
            }
        }
        return null;
    }
}
