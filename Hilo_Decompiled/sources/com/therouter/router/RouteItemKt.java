package com.therouter.router;

import android.os.Bundle;
import com.therouter.router.interceptor.NavigatorParamsFixHandle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0002¨\u0006\b"}, d2 = {"getUrlWithParams", "", "Lcom/therouter/router/RouteItem;", "handle", "Lkotlin/Function2;", "Lcom/therouter/router/interceptor/NavigatorParamsFixHandle;", "toNavigator", "Lcom/therouter/router/Navigator;", "router_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RouteItemKt {
    @NotNull
    public static final String getUrlWithParams(@NotNull RouteItem routeItem) {
        Intrinsics.checkNotNullParameter(routeItem, "<this>");
        return getUrlWithParams(routeItem, new Function2<String, String, String>() { // from class: com.therouter.router.RouteItemKt$getUrlWithParams$1
            @NotNull
            public final String invoke(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkNotNullParameter(str, "k");
                Intrinsics.checkNotNullParameter(str2, "v");
                return str + "=" + str2;
            }
        });
    }

    @NotNull
    public static final Navigator toNavigator(@NotNull RouteItem routeItem) {
        Intrinsics.checkNotNullParameter(routeItem, "<this>");
        return new Navigator(getUrlWithParams(routeItem), null);
    }

    @NotNull
    public static final String getUrlWithParams(@NotNull RouteItem routeItem, @NotNull NavigatorParamsFixHandle navigatorParamsFixHandle) {
        Intrinsics.checkNotNullParameter(routeItem, "<this>");
        Intrinsics.checkNotNullParameter(navigatorParamsFixHandle, "handle");
        return getUrlWithParams(routeItem, new RouteItemKt$getUrlWithParams$2(navigatorParamsFixHandle));
    }

    @NotNull
    public static final String getUrlWithParams(@NotNull RouteItem routeItem, @NotNull Function2<? super String, ? super String, String> function2) {
        String str;
        Intrinsics.checkNotNullParameter(routeItem, "<this>");
        Intrinsics.checkNotNullParameter(function2, "handle");
        StringBuilder sb2 = new StringBuilder(routeItem.getPath());
        Bundle extras = routeItem.getExtras();
        boolean z = true;
        for (String str2 : extras.keySet()) {
            if (z) {
                sb2.append("?");
                z = false;
            } else {
                sb2.append("&");
            }
            Intrinsics.checkNotNull(str2);
            Object obj = extras.get(str2);
            if (obj == null || (str = obj.toString()) == null) {
                str = "";
            }
            sb2.append((String) function2.invoke(str2, str));
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        return sb3;
    }
}
