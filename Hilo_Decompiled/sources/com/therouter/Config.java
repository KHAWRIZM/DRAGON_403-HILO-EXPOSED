package com.therouter;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u001a\u000e\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"\u001a\u0010\u0006\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0004\b\b\u0010\u0005\"\u001a\u0010\t\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0003\"\u0004\b\u000b\u0010\u0005¨\u0006\u000e"}, d2 = {"ROUTE_MAP_ASSETS_PATH", "", "getROUTE_MAP_ASSETS_PATH", "()Ljava/lang/String;", "setROUTE_MAP_ASSETS_PATH", "(Ljava/lang/String;)V", "WEB_HOST", "getWEB_HOST", "setWEB_HOST", "WEB_SCHEME", "getWEB_SCHEME", "setWEB_SCHEME", "fixPath", "url", "router_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = org.android.agoo.common.Config.TAG)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class Config {

    @NotNull
    private static String ROUTE_MAP_ASSETS_PATH = "therouter/routeMap.json";

    @NotNull
    private static String WEB_HOST = "therouter.com";

    @NotNull
    private static String WEB_SCHEME = "https";

    @NotNull
    public static final String fixPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        if (!StringsKt.startsWith$default(str, "http", false, 2, (Object) null)) {
            if (StringsKt.startsWith$default(str, "//", false, 2, (Object) null)) {
                return WEB_SCHEME + ":" + str;
            }
            if (StringsKt.startsWith$default(str, "/", false, 2, (Object) null)) {
                if (StringsKt.startsWith$default(str, "/" + WEB_HOST, false, 2, (Object) null)) {
                    return WEB_SCHEME + ":/" + str;
                }
                return WEB_SCHEME + "://" + WEB_HOST + str;
            }
            if (StringsKt.startsWith$default(str, WEB_HOST, false, 2, (Object) null)) {
                return WEB_SCHEME + "://" + str;
            }
            return WEB_SCHEME + "://" + WEB_HOST + "/" + str;
        }
        return str;
    }

    @NotNull
    public static final String getROUTE_MAP_ASSETS_PATH() {
        return ROUTE_MAP_ASSETS_PATH;
    }

    @NotNull
    public static final String getWEB_HOST() {
        return WEB_HOST;
    }

    @NotNull
    public static final String getWEB_SCHEME() {
        return WEB_SCHEME;
    }

    public static final void setROUTE_MAP_ASSETS_PATH(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        ROUTE_MAP_ASSETS_PATH = str;
    }

    public static final void setWEB_HOST(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        WEB_HOST = str;
    }

    public static final void setWEB_SCHEME(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        WEB_SCHEME = str;
    }
}
