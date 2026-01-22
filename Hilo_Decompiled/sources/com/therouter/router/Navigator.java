package com.therouter.router;

import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.qiahao.nextvideo.data.service.match.MatchingProvide;
import com.taobao.accs.common.Constants;
import com.taobao.accs.messenger.MessengerService;
import com.therouter.InnerTheRouterContentProviderKt;
import com.therouter.TheRouter;
import com.therouter.TheRouterKt;
import com.therouter.TheRouterLifecycleCallback;
import com.therouter.history.ActivityNavigatorHistory;
import com.therouter.history.FragmentNavigatorHistory;
import com.therouter.history.HistoryRecorder;
import com.therouter.router.action.ActionManager;
import com.therouter.router.interceptor.NavigationCallback;
import com.therouter.router.interceptor.NavigatorParamsFixHandle;
import com.therouter.router.interceptor.NavigatorPathFixHandle;
import com.therouter.router.interceptor.PathReplaceInterceptor;
import com.therouter.router.interceptor.RouterReplaceInterceptor;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010%\u001a\u00020&J\u0012\u0010%\u001a\u00020&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+J\u0019\u0010,\u001a\u0004\u0018\u0001H-\"\n\b\u0000\u0010-*\u0004\u0018\u00010.¢\u0006\u0002\u0010/J(\u00100\u001a\u00020&\"\n\b\u0000\u0010-*\u0004\u0018\u00010.2\u0014\u00101\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u0001H-\u0012\u0004\u0012\u00020&02J\u0010\u00103\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010(J$\u00104\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020&02J\u001a\u00105\u001a\u00020\u00002\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020&02J\u0006\u00106\u001a\u00020\u0003J \u00106\u001a\u00020\u00032\u0018\u00107\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000308J\u000e\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u000209J0\u0010:\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010;\u001a\u0004\u0018\u00010.2\u0006\u0010<\u001a\u00020+2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>H\u0007J \u0010:\u001a\u00020&2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010(2\n\b\u0002\u00101\u001a\u0004\u0018\u00010>H\u0007J&\u0010:\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010<\u001a\u00020+2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>H\u0007J\u001e\u0010:\u001a\u00020&2\b\u0010;\u001a\u0004\u0018\u00010.2\n\b\u0002\u00101\u001a\u0004\u0018\u00010>H\u0007J&\u0010:\u001a\u00020&2\b\u0010;\u001a\u0004\u0018\u00010.2\u0006\u0010<\u001a\u00020+2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>H\u0007J\u0010\u0010@\u001a\u0004\u0018\u00010\u00012\u0006\u0010A\u001a\u00020\u0003J\u0006\u0010\u001f\u001a\u00020\u0000J\u0010\u0010B\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010D\u001a\u00020\u00002\b\u0010E\u001a\u0004\u0018\u00010\u0011J\u0010\u0010F\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010\u0003J\u0010\u0010H\u001a\u00020\u00002\b\u0010I\u001a\u0004\u0018\u00010\tJ\u0018\u0010J\u001a\u00020\u00002\b\u0010A\u001a\u0004\u0018\u00010\u00032\u0006\u0010I\u001a\u00020 J\u001a\u0010K\u001a\u00020\u00002\b\u0010A\u001a\u0004\u0018\u00010\u00032\b\u0010I\u001a\u0004\u0018\u00010\tJ\u0018\u0010L\u001a\u00020\u00002\b\u0010A\u001a\u0004\u0018\u00010\u00032\u0006\u0010I\u001a\u00020MJ\u0018\u0010N\u001a\u00020\u00002\b\u0010A\u001a\u0004\u0018\u00010\u00032\u0006\u0010I\u001a\u00020OJ\u0018\u0010P\u001a\u00020\u00002\b\u0010A\u001a\u0004\u0018\u00010\u00032\u0006\u0010I\u001a\u00020QJ\u000e\u0010R\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+J\u0018\u0010S\u001a\u00020\u00002\b\u0010A\u001a\u0004\u0018\u00010\u00032\u0006\u0010I\u001a\u00020TJ\u000e\u0010U\u001a\u00020\u00002\u0006\u0010V\u001a\u00020+J\u0018\u0010W\u001a\u00020\u00002\b\u0010A\u001a\u0004\u0018\u00010\u00032\u0006\u0010I\u001a\u00020+J\u0018\u0010X\u001a\u00020\u00002\b\u0010A\u001a\u0004\u0018\u00010\u00032\u0006\u0010I\u001a\u00020YJ\u0016\u0010Z\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u0001J\u0010\u0010[\u001a\u00020\u00002\b\u0010\\\u001a\u0004\u0018\u00010\tJ\u000e\u0010]\u001a\u00020\u00002\u0006\u0010V\u001a\u00020+J\u001a\u0010^\u001a\u00020\u00002\b\u0010A\u001a\u0004\u0018\u00010\u00032\b\u0010I\u001a\u0004\u0018\u00010_J\u001a\u0010`\u001a\u00020\u00002\b\u0010A\u001a\u0004\u0018\u00010\u00032\b\u0010I\u001a\u0004\u0018\u00010aJ\u001a\u0010b\u001a\u00020\u00002\b\u0010A\u001a\u0004\u0018\u00010\u00032\b\u0010I\u001a\u0004\u0018\u00010\u0003R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0014j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001b\"\u0004\b\u001e\u0010\u0004R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u0004¨\u0006c"}, d2 = {"Lcom/therouter/router/Navigator;", "", "url", "", "(Ljava/lang/String;)V", MessengerService.INTENT, "Landroid/content/Intent;", "(Ljava/lang/String;Landroid/content/Intent;)V", "extras", "Landroid/os/Bundle;", "getExtras", "()Landroid/os/Bundle;", "getIntent", "()Landroid/content/Intent;", "intentClipData", "Landroid/content/ClipData;", "intentData", "Landroid/net/Uri;", "intentIdentifier", "kvPair", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getKvPair", "()Ljava/util/HashMap;", "optionsCompat", "originalUrl", "getOriginalUrl", "()Ljava/lang/String;", "pathFixOriginalUrl", "getPathFixOriginalUrl", "setPathFixOriginalUrl", MatchingProvide.MATCH_PENDING, "", "simpleUrl", "getSimpleUrl", "getUrl", "setUrl", "action", "", "ctx", "Landroid/content/Context;", "addFlags", Constants.KEY_FLAGS, "", "createFragment", "T", "Landroidx/fragment/app/Fragment;", "()Landroidx/fragment/app/Fragment;", "createFragmentWithCallback", "callback", "Lkotlin/Function1;", "createIntent", "createIntentWithCallback", "fillParams", "getUrlWithParams", "handle", "Lkotlin/Function2;", "Lcom/therouter/router/interceptor/NavigatorParamsFixHandle;", "navigation", "fragment", "requestCode", "ncb", "Lcom/therouter/router/interceptor/NavigationCallback;", "context", "optObject", "key", "setClipData", "clipData", "setData", "uri", "setIdentifier", "identifier", "with", "value", "withBoolean", "withBundle", "withByte", "", "withChar", "", "withDouble", "", "withFlags", "withFloat", "", "withInAnimation", AgooConstants.MESSAGE_ID, "withInt", "withLong", "", "withObject", "withOptionsCompat", "options", "withOutAnimation", "withParcelable", "Landroid/os/Parcelable;", "withSerializable", "Ljava/io/Serializable;", "withString", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNavigator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Navigator.kt\ncom/therouter/router/Navigator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,866:1\n1855#2,2:867\n1855#2,2:869\n1855#2,2:871\n1855#2,2:873\n1855#2,2:875\n*S KotlinDebug\n*F\n+ 1 Navigator.kt\ncom/therouter/router/Navigator\n*L\n199#1:867,2\n363#1:869,2\n484#1:871,2\n586#1:873,2\n130#1:875,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class Navigator {

    @NotNull
    private final Bundle extras;

    @Nullable
    private final Intent intent;

    @Nullable
    private ClipData intentClipData;

    @Nullable
    private Uri intentData;

    @Nullable
    private String intentIdentifier;

    @NotNull
    private final HashMap<String, String> kvPair;

    @Nullable
    private Bundle optionsCompat;

    @Nullable
    private final String originalUrl;

    @NotNull
    private String pathFixOriginalUrl;
    private boolean pending;

    @Nullable
    private String url;

    public Navigator(@Nullable String str, @Nullable Intent intent) {
        this.url = str;
        this.intent = intent;
        this.originalUrl = str;
        this.pathFixOriginalUrl = "";
        this.extras = new Bundle();
        this.kvPair = new HashMap<>();
        TheRouterKt.require(!TextUtils.isEmpty(this.url), "Navigator", "Navigator constructor parameter url is empty");
        for (NavigatorPathFixHandle navigatorPathFixHandle : NavigatorKt.access$getFixHandles$p()) {
            if (navigatorPathFixHandle != null && navigatorPathFixHandle.watch(this.url)) {
                this.url = navigatorPathFixHandle.fix(this.url);
            }
        }
        String str2 = this.url;
        this.pathFixOriginalUrl = str2 == null ? "" : str2;
        Uri parse = Uri.parse(str2 != null ? str2 : "");
        _init_$parserString(this, parse.getEncodedFragment());
        _init_$parserString(this, parse.getEncodedQuery());
    }

    private static final void _init_$parser(Navigator navigator, String str, String str2) {
        String str3;
        String substring;
        if (str != null && !StringsKt.isBlank(str) && !Intrinsics.areEqual(StringsKt.trim(str).toString(), "=")) {
            int indexOf$default = StringsKt.indexOf$default(str, "=", 0, false, 6, (Object) null);
            String str4 = "";
            if (indexOf$default != -1) {
                if (indexOf$default != 0) {
                    str4 = str.substring(0, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(str4, "substring(...)");
                    substring = str.substring(indexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                } else {
                    substring = str.substring(1);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                }
                String str5 = str4;
                str4 = substring;
                str = str5;
            }
            if (str2 != null) {
                str3 = StringsKt.trim(str2).toString();
            } else {
                str3 = null;
            }
            if (!TextUtils.isEmpty(str3)) {
                str4 = str4 + str2;
            }
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str4)) {
                navigator.kvPair.put(str, str4);
            }
        }
    }

    static /* synthetic */ void _init_$parser$default(Navigator navigator, String str, String str2, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str2 = "";
            }
            _init_$parser(navigator, str, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: _init_$parser");
    }

    private static final void _init_$parserString(Navigator navigator, String str) {
        List split$default;
        if (str != null && StringsKt.contains$default(str, '?', false, 2, (Object) null)) {
            int indexOf$default = StringsKt.indexOf$default(str, '?', 0, false, 6, (Object) null);
            if (indexOf$default > -1) {
                String substring = str.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                String substring2 = str.substring(indexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                List split$default2 = StringsKt.split$default(substring, new char[]{'&'}, false, 0, 6, (Object) null);
                if (!split$default2.isEmpty()) {
                    int size = split$default2.size();
                    for (int i = 0; i < size; i++) {
                        if (i == split$default2.size() - 1) {
                            _init_$parser(navigator, (String) split$default2.get(i), substring2);
                        } else {
                            _init_$parser$default(navigator, (String) split$default2.get(i), null, 4, null);
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (str != null && (split$default = StringsKt.split$default(str, new String[]{"&"}, false, 0, 6, (Object) null)) != null) {
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                _init_$parser$default(navigator, (String) it.next(), null, 4, null);
            }
        }
    }

    public static /* synthetic */ void action$default(Navigator navigator, Context context, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                context = null;
            }
            navigator.action(context);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: action");
    }

    public static /* synthetic */ void navigation$default(Navigator navigator, Fragment fragment, NavigationCallback navigationCallback, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigation");
        }
        if ((i & 2) != 0) {
            navigationCallback = null;
        }
        navigator.navigation(fragment, navigationCallback);
    }

    public final void action() {
        action(null);
    }

    @NotNull
    public final Navigator addFlags(int flags) {
        Bundle bundle = this.extras;
        bundle.putInt(NavigatorKt.KEY_INTENT_FLAGS, flags | bundle.getInt(NavigatorKt.KEY_INTENT_FLAGS, 0));
        return this;
    }

    @Nullable
    public final <T extends Fragment> T createFragment() {
        Bundle extras;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        TheRouterKt.debug$default("Navigator::navigationFragment", "begin navigate " + getSimpleUrl(), null, 4, null);
        String simpleUrl = getSimpleUrl();
        for (PathReplaceInterceptor pathReplaceInterceptor : NavigatorKt.access$getPathReplaceInterceptors$p()) {
            if (pathReplaceInterceptor != null && pathReplaceInterceptor.watch(simpleUrl)) {
                simpleUrl = pathReplaceInterceptor.replace(simpleUrl);
            }
        }
        TheRouterKt.debug$default("Navigator::navigationFragment", "path replace to " + ((Object) simpleUrl), null, 4, null);
        RouteItem matchRouteMap = RouteMapKt.matchRouteMap(simpleUrl);
        if (matchRouteMap != null && (extras = matchRouteMap.getExtras()) != null) {
            extras.putAll(this.extras);
            Set<String> keySet = this.kvPair.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
            for (String str : keySet) {
                if (!extras.containsKey(str)) {
                    extras.putString(str, this.kvPair.get(str));
                }
            }
        }
        if (matchRouteMap != null) {
            TheRouterKt.debug$default("Navigator::navigationFragment", "match route " + matchRouteMap, null, 4, null);
        }
        for (RouterReplaceInterceptor routerReplaceInterceptor : NavigatorKt.access$getRouterReplaceInterceptors$p()) {
            if (routerReplaceInterceptor != null && routerReplaceInterceptor.watch(matchRouteMap)) {
                matchRouteMap = routerReplaceInterceptor.replace(matchRouteMap);
            }
        }
        TheRouterKt.debug$default("Navigator::navigationFragment", "route replace to " + matchRouteMap, null, 4, null);
        if (matchRouteMap != null) {
            NavigatorKt.access$getRouterInterceptor$p().invoke(matchRouteMap, new Function1<RouteItem, Unit>() { // from class: com.therouter.router.Navigator$createFragment$5$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((RouteItem) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull RouteItem routeItem) {
                    Bundle extras2;
                    Intrinsics.checkNotNullParameter(routeItem, "routeItem");
                    if (FragmentFactoryKt.isFragmentClass(routeItem.getClassName())) {
                        try {
                            objectRef.element = FragmentFactoryKt.instantiate(routeItem.getClassName());
                            Bundle extras3 = routeItem.getExtras();
                            Intent intent = this.getIntent();
                            if (intent != null && (extras2 = intent.getExtras()) != null) {
                                extras3.putAll(extras2);
                            }
                            extras3.putString(NavigatorKt.KEY_ACTION, routeItem.getAction());
                            extras3.putString(NavigatorKt.KEY_PATH, this.getUrlWithParams());
                            extras3.putString(NavigatorKt.KEY_DESCRIPTION, routeItem.getDescription());
                            Fragment fragment = (Fragment) objectRef.element;
                            if (fragment != null) {
                                fragment.setArguments(extras3);
                            }
                            TheRouterKt.debug$default("Navigator::navigation", "create fragment " + routeItem.getClassName(), null, 4, null);
                        } catch (Exception e) {
                            TheRouterKt.debug("Navigator::navigationFragment", "create fragment instance error " + e.getMessage(), new Function0<Unit>() { // from class: com.therouter.router.Navigator$createFragment$5$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m١٨٢invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: collision with other method in class */
                                public final void m١٨٢invoke() {
                                    e.printStackTrace();
                                }
                            });
                        }
                        HistoryRecorder.pushHistory(new FragmentNavigatorHistory(this.getUrlWithParams()));
                        return;
                    }
                    if (TheRouter.isDebug()) {
                        throw new RuntimeException("TheRouter::Navigator " + routeItem.getClassName() + " is not Fragment");
                    }
                }
            });
        }
        return (T) objectRef.element;
    }

    public final <T extends Fragment> void createFragmentWithCallback(@NotNull final Function1<? super T, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (RouteMapKt.getInitedRouteMap() && !this.pending) {
            callback.invoke(createFragment());
            return;
        }
        this.pending = true;
        TheRouterKt.debug$default("Navigator::createFragmentWithCallback", "add pending navigator " + getSimpleUrl(), null, 4, null);
        NavigatorKt.access$getDisposableQueue$p().addLast(new PendingNavigator(this, new Function0<Unit>() { // from class: com.therouter.router.Navigator$createFragmentWithCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m١٨٣invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m١٨٣invoke() {
                Navigator.this.pending = false;
                callback.invoke(Navigator.this.createFragment());
            }
        }));
    }

    @NotNull
    public final Intent createIntent(@Nullable final Context ctx) {
        Bundle extras;
        TheRouterKt.debug$default("Navigator::createIntent", "begin navigate " + getSimpleUrl(), null, 4, null);
        if (ctx == null) {
            ctx = InnerTheRouterContentProviderKt.getApplicationContext();
        }
        String simpleUrl = getSimpleUrl();
        for (PathReplaceInterceptor pathReplaceInterceptor : NavigatorKt.access$getPathReplaceInterceptors$p()) {
            if (pathReplaceInterceptor != null && pathReplaceInterceptor.watch(simpleUrl)) {
                String replace = pathReplaceInterceptor.replace(simpleUrl);
                TheRouterKt.debug$default("Navigator::createIntent", simpleUrl + " replace to " + ((Object) replace), null, 4, null);
                simpleUrl = replace;
            }
        }
        RouteItem matchRouteMap = RouteMapKt.matchRouteMap(simpleUrl);
        if (matchRouteMap != null && (extras = matchRouteMap.getExtras()) != null) {
            extras.putAll(this.extras);
            Set<String> keySet = this.kvPair.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
            for (String str : keySet) {
                if (!extras.containsKey(str)) {
                    extras.putString(str, this.kvPair.get(str));
                }
            }
        }
        if (matchRouteMap != null) {
            TheRouterKt.debug$default("Navigator::createIntent", "match route " + matchRouteMap, null, 4, null);
        }
        for (RouterReplaceInterceptor routerReplaceInterceptor : NavigatorKt.access$getRouterReplaceInterceptors$p()) {
            if (routerReplaceInterceptor != null && routerReplaceInterceptor.watch(matchRouteMap) && (matchRouteMap = routerReplaceInterceptor.replace(matchRouteMap)) != null) {
                TheRouterKt.debug$default("Navigator::createIntent", "route replace to " + matchRouteMap, null, 4, null);
            }
        }
        final Intent intent = this.intent;
        if (intent == null) {
            intent = new Intent();
        }
        if (matchRouteMap != null) {
            NavigatorKt.access$getRouterInterceptor$p().invoke(matchRouteMap, new Function1<RouteItem, Unit>() { // from class: com.therouter.router.Navigator$createIntent$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((RouteItem) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull final RouteItem routeItem) {
                    Uri uri;
                    ClipData clipData;
                    ComponentName componentName;
                    String str2;
                    String str3;
                    Intrinsics.checkNotNullParameter(routeItem, "routeItem");
                    uri = Navigator.this.intentData;
                    if (uri != null) {
                        intent.setData(uri);
                    }
                    clipData = Navigator.this.intentClipData;
                    if (clipData != null) {
                        intent.setClipData(clipData);
                    }
                    if (Build.VERSION.SDK_INT >= 29) {
                        str2 = Navigator.this.intentIdentifier;
                        if (str2 != null) {
                            Intent intent2 = intent;
                            str3 = Navigator.this.intentIdentifier;
                            intent2.setIdentifier(str3);
                        }
                    }
                    Intent intent3 = intent;
                    Context context = ctx;
                    if (context != null) {
                        componentName = new ComponentName(context.getPackageName(), routeItem.getClassName());
                    } else {
                        Navigator navigator = Navigator.this;
                        if (!TheRouter.isDebug()) {
                            TheRouterKt.debug$default("Navigator::createIntent", "context is null, path is -> " + navigator.getUrlWithParams(), null, 4, null);
                            componentName = null;
                        } else {
                            throw new RuntimeException("context is null, path is -> " + navigator.getUrlWithParams());
                        }
                    }
                    intent3.setComponent(componentName);
                    if (!(ctx instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    TheRouterLifecycleCallback theRouterLifecycleCallback = TheRouterLifecycleCallback.INSTANCE;
                    String className = routeItem.getClassName();
                    final Navigator navigator2 = Navigator.this;
                    theRouterLifecycleCallback.addActivityCreatedObserver(className, new Function1<Activity, Unit>() { // from class: com.therouter.router.Navigator$createIntent$5.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Activity) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull Activity activity) {
                            Intrinsics.checkNotNullParameter(activity, "it");
                            if (!Intrinsics.areEqual(activity.getClass().getName(), RouteItem.this.getClassName()) || TextUtils.isEmpty(RouteItem.this.getAction())) {
                                return;
                            }
                            TheRouter.build(RouteItem.this.getAction()).withObject(NavigatorKt.KEY_OBJECT_NAVIGATOR, navigator2).withObject(NavigatorKt.KEY_OBJECT_ACTIVITY, activity).action(activity);
                        }
                    });
                    intent.putExtra(NavigatorKt.KEY_ACTION, routeItem.getAction());
                    intent.putExtra(NavigatorKt.KEY_PATH, Navigator.this.getUrlWithParams());
                    intent.putExtra(NavigatorKt.KEY_DESCRIPTION, routeItem.getDescription());
                    Bundle extras2 = routeItem.getExtras();
                    Intent intent4 = intent;
                    Bundle bundle = extras2.getBundle(NavigatorKt.KEY_BUNDLE);
                    if (bundle != null) {
                        extras2.remove(NavigatorKt.KEY_BUNDLE);
                        intent4.putExtra(NavigatorKt.KEY_BUNDLE, bundle);
                    }
                    intent4.putExtras(extras2);
                    intent.addFlags(routeItem.getExtras().getInt(NavigatorKt.KEY_INTENT_FLAGS));
                    int i = routeItem.getExtras().getInt(NavigatorKt.KEY_ANIM_IN);
                    int i2 = routeItem.getExtras().getInt(NavigatorKt.KEY_ANIM_OUT);
                    if (i == 0 && i2 == 0) {
                        return;
                    }
                    if (ctx instanceof Activity) {
                        TheRouterKt.debug$default("Navigator::createIntent", "overridePendingTransition " + routeItem.getClassName(), null, 4, null);
                        ((Activity) ctx).overridePendingTransition(routeItem.getExtras().getInt(NavigatorKt.KEY_ANIM_IN), routeItem.getExtras().getInt(NavigatorKt.KEY_ANIM_OUT));
                        return;
                    }
                    if (TheRouter.isDebug()) {
                        throw new RuntimeException("Navigator::createIntent context is not Activity, ignore animation");
                    }
                }
            });
        }
        return intent;
    }

    public final void createIntentWithCallback(@Nullable final Context ctx, @NotNull final Function1<? super Intent, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (RouteMapKt.getInitedRouteMap() && !this.pending) {
            callback.invoke(createIntent(ctx));
            return;
        }
        this.pending = true;
        TheRouterKt.debug$default("Navigator::createIntentWithCallback", "add pending navigator " + getSimpleUrl(), null, 4, null);
        NavigatorKt.access$getDisposableQueue$p().addLast(new PendingNavigator(this, new Function0<Unit>() { // from class: com.therouter.router.Navigator$createIntentWithCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m١٨٤invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m١٨٤invoke() {
                Navigator.this.pending = false;
                callback.invoke(Navigator.this.createIntent(ctx));
            }
        }));
    }

    @NotNull
    public final Navigator fillParams(@NotNull Function1<? super Bundle, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        action.invoke(this.extras);
        return this;
    }

    @NotNull
    public final Bundle getExtras() {
        return this.extras;
    }

    @Nullable
    public final Intent getIntent() {
        return this.intent;
    }

    @NotNull
    public final HashMap<String, String> getKvPair() {
        return this.kvPair;
    }

    @Nullable
    public final String getOriginalUrl() {
        return this.originalUrl;
    }

    @NotNull
    public final String getPathFixOriginalUrl() {
        return this.pathFixOriginalUrl;
    }

    @NotNull
    public final String getSimpleUrl() {
        String str = this.url;
        if (str == null) {
            str = "";
        }
        if (StringsKt.contains$default(str, "?", false, 2, (Object) null)) {
            String substring = str.substring(0, StringsKt.indexOf$default(str, '?', 0, false, 6, (Object) null));
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        return str;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final String getUrlWithParams() {
        return getUrlWithParams(new Function2<String, String, String>() { // from class: com.therouter.router.Navigator$getUrlWithParams$1
            @NotNull
            public final String invoke(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkNotNullParameter(str, "k");
                Intrinsics.checkNotNullParameter(str2, "v");
                return str + "=" + str2;
            }
        });
    }

    @JvmOverloads
    public final void navigation() {
        navigation$default(this, (Context) null, (NavigationCallback) null, 3, (Object) null);
    }

    @Nullable
    public final Object optObject(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        SoftReference<Object> softReference = NavigatorKt.getArguments().get(key);
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    @NotNull
    public final Navigator pending() {
        this.pending = true;
        return this;
    }

    @NotNull
    public final Navigator setClipData(@Nullable ClipData clipData) {
        this.intentClipData = clipData;
        return this;
    }

    @NotNull
    public final Navigator setData(@Nullable Uri uri) {
        this.intentData = uri;
        return this;
    }

    @NotNull
    public final Navigator setIdentifier(@Nullable String identifier) {
        this.intentIdentifier = identifier;
        return this;
    }

    public final void setPathFixOriginalUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pathFixOriginalUrl = str;
    }

    public final void setUrl(@Nullable String str) {
        this.url = str;
    }

    @NotNull
    public final Navigator with(@Nullable Bundle value) {
        return withBundle(NavigatorKt.KEY_BUNDLE, value);
    }

    @NotNull
    public final Navigator withBoolean(@Nullable String key, boolean value) {
        this.extras.putBoolean(key, value);
        return this;
    }

    @NotNull
    public final Navigator withBundle(@Nullable String key, @Nullable Bundle value) {
        this.extras.putBundle(key, value);
        return this;
    }

    @NotNull
    public final Navigator withByte(@Nullable String key, byte value) {
        this.extras.putByte(key, value);
        return this;
    }

    @NotNull
    public final Navigator withChar(@Nullable String key, char value) {
        this.extras.putChar(key, value);
        return this;
    }

    @NotNull
    public final Navigator withDouble(@Nullable String key, double value) {
        this.extras.putDouble(key, value);
        return this;
    }

    @NotNull
    public final Navigator withFlags(int flags) {
        this.extras.putInt(NavigatorKt.KEY_INTENT_FLAGS, flags);
        return this;
    }

    @NotNull
    public final Navigator withFloat(@Nullable String key, float value) {
        this.extras.putFloat(key, value);
        return this;
    }

    @NotNull
    public final Navigator withInAnimation(int id2) {
        this.extras.putInt(NavigatorKt.KEY_ANIM_IN, id2);
        return this;
    }

    @NotNull
    public final Navigator withInt(@Nullable String key, int value) {
        this.extras.putInt(key, value);
        return this;
    }

    @NotNull
    public final Navigator withLong(@Nullable String key, long value) {
        this.extras.putLong(key, value);
        return this;
    }

    @NotNull
    public final Navigator withObject(@NotNull String key, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        NavigatorKt.getArguments().put(key, new SoftReference<>(value));
        return this;
    }

    @NotNull
    public final Navigator withOptionsCompat(@Nullable Bundle options) {
        this.optionsCompat = options;
        return this;
    }

    @NotNull
    public final Navigator withOutAnimation(int id2) {
        this.extras.putInt(NavigatorKt.KEY_ANIM_OUT, id2);
        return this;
    }

    @NotNull
    public final Navigator withParcelable(@Nullable String key, @Nullable Parcelable value) {
        this.extras.putParcelable(key, value);
        return this;
    }

    @NotNull
    public final Navigator withSerializable(@Nullable String key, @Nullable Serializable value) {
        this.extras.putSerializable(key, value);
        return this;
    }

    @NotNull
    public final Navigator withString(@Nullable String key, @Nullable String value) {
        this.extras.putString(key, value);
        return this;
    }

    public static /* synthetic */ void navigation$default(Navigator navigator, Fragment fragment, int i, NavigationCallback navigationCallback, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigation");
        }
        if ((i2 & 4) != 0) {
            navigationCallback = null;
        }
        navigator.navigation(fragment, i, navigationCallback);
    }

    public final void action(@Nullable Context ctx) {
        if (ActionManager.INSTANCE.isAction$router_release(this)) {
            navigation$default(this, ctx, (NavigationCallback) null, 2, (Object) null);
        }
    }

    @NotNull
    public final String getUrlWithParams(@NotNull NavigatorParamsFixHandle handle) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        return getUrlWithParams(new Navigator$getUrlWithParams$2(handle));
    }

    @JvmOverloads
    public final void navigation(@Nullable Context context) {
        navigation$default(this, context, (NavigationCallback) null, 2, (Object) null);
    }

    public static /* synthetic */ void navigation$default(Navigator navigator, Context context, NavigationCallback navigationCallback, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigation");
        }
        if ((i & 1) != 0) {
            context = InnerTheRouterContentProviderKt.getApplicationContext();
        }
        if ((i & 2) != 0) {
            navigationCallback = null;
        }
        navigator.navigation(context, navigationCallback);
    }

    @NotNull
    public final String getUrlWithParams(@NotNull Function2<? super String, ? super String, String> handle) {
        String str;
        String str2;
        String obj;
        Intrinsics.checkNotNullParameter(handle, "handle");
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = this.extras.keySet().iterator();
        boolean z = true;
        while (true) {
            String str3 = "";
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (!this.kvPair.containsKey(next)) {
                Intrinsics.checkNotNull(next);
                Object obj2 = this.extras.get(next);
                if (obj2 == null || (str2 = obj2.toString()) == null) {
                    str2 = "";
                }
                String str4 = (String) handle.invoke(next, str2);
                if (!TextUtils.isEmpty(str4)) {
                    if (z) {
                        sb2.append(str4);
                        z = false;
                    } else {
                        sb2.append('&');
                        Object obj3 = this.extras.get(next);
                        if (obj3 != null && (obj = obj3.toString()) != null) {
                            str3 = obj;
                        }
                        sb2.append((String) handle.invoke(next, str3));
                    }
                }
            }
        }
        Uri parse = Uri.parse(this.pathFixOriginalUrl);
        String encodedQuery = parse.getEncodedQuery();
        String str5 = encodedQuery == null ? "" : encodedQuery;
        String encodedFragment = parse.getEncodedFragment();
        String str6 = encodedFragment == null ? "" : encodedFragment;
        if (TextUtils.isEmpty(sb2)) {
            str = this.pathFixOriginalUrl;
        } else if (!TextUtils.isEmpty(str5)) {
            if (!StringsKt.startsWith$default(str5, '&', false, 2, (Object) null)) {
                sb2.append('&');
            }
            sb2.append(str5);
            String str7 = this.pathFixOriginalUrl;
            String sb3 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
            str = StringsKt.replace$default(str7, str5, sb3, false, 4, (Object) null);
        } else if (!TextUtils.isEmpty(str6)) {
            int indexOf$default = StringsKt.indexOf$default(this.pathFixOriginalUrl, str6, 0, false, 6, (Object) null);
            if (indexOf$default > -1) {
                String substring = this.pathFixOriginalUrl.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                if (StringsKt.contains$default(substring, '?', false, 2, (Object) null)) {
                    str = StringsKt.replace$default(this.pathFixOriginalUrl, "?", "?" + ((Object) sb2), false, 4, (Object) null);
                } else {
                    str = StringsKt.replace$default(this.pathFixOriginalUrl, "#", "?" + ((Object) sb2) + "#", false, 4, (Object) null);
                }
            } else {
                str = this.pathFixOriginalUrl;
            }
        } else if (StringsKt.contains$default(this.pathFixOriginalUrl, '?', false, 2, (Object) null)) {
            str = StringsKt.replace$default(this.pathFixOriginalUrl, "?", "?" + ((Object) sb2), false, 4, (Object) null);
        } else {
            str = this.pathFixOriginalUrl + "?" + ((Object) sb2);
        }
        Set<String> keySet = this.kvPair.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
        while (true) {
            String str8 = str;
            for (String str9 : keySet) {
                if (this.extras.containsKey(str9)) {
                    break;
                }
            }
            return str8;
            str = StringsKt.replace$default(str8, str9 + "=" + ((Object) this.kvPair.get(str9)), str9 + "=" + this.extras.get(str9), false, 4, (Object) null);
        }
    }

    @JvmOverloads
    public final void navigation(@Nullable Context context, int i) {
        navigation$default(this, context, i, (NavigationCallback) null, 4, (Object) null);
    }

    public static /* synthetic */ void navigation$default(Navigator navigator, Context context, int i, NavigationCallback navigationCallback, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigation");
        }
        if ((i2 & 4) != 0) {
            navigationCallback = null;
        }
        navigator.navigation(context, i, navigationCallback);
    }

    @JvmOverloads
    public final void navigation(@Nullable Context context, @Nullable Fragment fragment, int i) {
        navigation$default(this, context, fragment, i, null, 8, null);
    }

    public static /* synthetic */ void navigation$default(Navigator navigator, Context context, Fragment fragment, int i, NavigationCallback navigationCallback, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigation");
        }
        if ((i2 & 8) != 0) {
            navigationCallback = null;
        }
        navigator.navigation(context, fragment, i, navigationCallback);
    }

    @JvmOverloads
    public final void navigation(@Nullable Fragment fragment) {
        navigation$default(this, fragment, (NavigationCallback) null, 2, (Object) null);
    }

    @JvmOverloads
    public final void navigation(@Nullable Fragment fragment, int i) {
        navigation$default(this, fragment, i, (NavigationCallback) null, 4, (Object) null);
    }

    @JvmOverloads
    public final void navigation(@Nullable Fragment fragment, @Nullable NavigationCallback callback) {
        navigation(fragment, NavigatorKt.DEFAULT_REQUEST_CODE, callback);
    }

    @JvmOverloads
    public final void navigation(@Nullable Fragment fragment, int requestCode, @Nullable NavigationCallback ncb) {
        navigation(fragment != null ? fragment.getActivity() : null, fragment, requestCode, ncb);
    }

    @JvmOverloads
    public final void navigation(@Nullable Context context, @Nullable NavigationCallback callback) {
        navigation(context, NavigatorKt.DEFAULT_REQUEST_CODE, callback);
    }

    @JvmOverloads
    public final void navigation(@Nullable Context ctx, int requestCode, @Nullable NavigationCallback ncb) {
        navigation(ctx, null, requestCode, ncb);
    }

    @JvmOverloads
    public final void navigation(@Nullable final Context ctx, @Nullable final Fragment fragment, final int requestCode, @Nullable final NavigationCallback ncb) {
        Bundle extras;
        if (RouteMapKt.getInitedRouteMap() && !this.pending) {
            TheRouterKt.debug$default("Navigator::navigation", "begin navigate " + getSimpleUrl(), null, 4, null);
            if (ctx == null) {
                ctx = fragment != null ? fragment.getActivity() : null;
                if (ctx == null) {
                    ctx = InnerTheRouterContentProviderKt.getApplicationContext();
                }
            }
            final Context context = ctx;
            if (ncb == null) {
                ncb = NavigatorKt.access$getDefaultCallback$p();
            }
            String simpleUrl = getSimpleUrl();
            for (PathReplaceInterceptor pathReplaceInterceptor : NavigatorKt.access$getPathReplaceInterceptors$p()) {
                if (pathReplaceInterceptor != null && pathReplaceInterceptor.watch(simpleUrl)) {
                    String replace = pathReplaceInterceptor.replace(simpleUrl);
                    TheRouterKt.debug$default("Navigator::navigation", simpleUrl + " replace to " + ((Object) replace), null, 4, null);
                    simpleUrl = replace;
                }
            }
            RouteItem matchRouteMap = RouteMapKt.matchRouteMap(simpleUrl);
            ActionManager actionManager = ActionManager.INSTANCE;
            if (actionManager.isAction$router_release(this) && matchRouteMap == null) {
                actionManager.handleAction$router_release(this, context);
                return;
            }
            if (matchRouteMap != null && (extras = matchRouteMap.getExtras()) != null) {
                extras.putAll(this.extras);
                Set<String> keySet = this.kvPair.keySet();
                Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
                for (String str : keySet) {
                    if (!extras.containsKey(str)) {
                        extras.putString(str, this.kvPair.get(str));
                    }
                }
            }
            if (matchRouteMap != null) {
                TheRouterKt.debug$default("Navigator::navigation", "match route " + matchRouteMap, null, 4, null);
            }
            for (RouterReplaceInterceptor routerReplaceInterceptor : NavigatorKt.access$getRouterReplaceInterceptors$p()) {
                if (routerReplaceInterceptor != null && routerReplaceInterceptor.watch(matchRouteMap) && (matchRouteMap = routerReplaceInterceptor.replace(matchRouteMap)) != null) {
                    TheRouterKt.debug$default("Navigator::navigation", "route replace to " + matchRouteMap, null, 4, null);
                }
            }
            if (matchRouteMap != null) {
                String className = matchRouteMap.getClassName();
                if (className == null) {
                    className = "";
                }
                if (!FragmentFactoryKt.isFragmentClass(className)) {
                    TheRouterKt.debug$default("Navigator::navigation", "NavigationCallback on found", null, 4, null);
                    ncb.onFound(this);
                    final NavigationCallback navigationCallback = ncb;
                    NavigatorKt.access$getRouterInterceptor$p().invoke(matchRouteMap, new Function1<RouteItem, Unit>() { // from class: com.therouter.router.Navigator$navigation$6
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((RouteItem) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull final RouteItem routeItem) {
                            Uri uri;
                            ClipData clipData;
                            ComponentName componentName;
                            Bundle bundle;
                            Bundle bundle2;
                            Bundle bundle3;
                            Bundle bundle4;
                            Bundle bundle5;
                            String str2;
                            String str3;
                            Intrinsics.checkNotNullParameter(routeItem, "routeItem");
                            Intent intent = Navigator.this.getIntent();
                            if (intent == null) {
                                intent = new Intent();
                            }
                            uri = Navigator.this.intentData;
                            if (uri != null) {
                                intent.setData(uri);
                            }
                            clipData = Navigator.this.intentClipData;
                            if (clipData != null) {
                                intent.setClipData(clipData);
                            }
                            if (Build.VERSION.SDK_INT >= 29) {
                                str2 = Navigator.this.intentIdentifier;
                                if (str2 != null) {
                                    str3 = Navigator.this.intentIdentifier;
                                    intent.setIdentifier(str3);
                                }
                            }
                            Context context2 = context;
                            if (context2 != null) {
                                componentName = new ComponentName(context2.getPackageName(), routeItem.getClassName());
                            } else {
                                Navigator navigator = Navigator.this;
                                if (!TheRouter.isDebug()) {
                                    TheRouterKt.debug$default("Navigator::navigation", "context is null, path is -> " + navigator.getUrlWithParams(), null, 4, null);
                                    componentName = null;
                                } else {
                                    throw new RuntimeException("context is null, path is -> " + navigator.getUrlWithParams());
                                }
                            }
                            intent.setComponent(componentName);
                            if (!(context instanceof Activity) && fragment == null) {
                                intent.addFlags(268435456);
                            }
                            TheRouterLifecycleCallback theRouterLifecycleCallback = TheRouterLifecycleCallback.INSTANCE;
                            String className2 = routeItem.getClassName();
                            final NavigationCallback navigationCallback2 = navigationCallback;
                            final Navigator navigator2 = Navigator.this;
                            theRouterLifecycleCallback.addActivityCreatedObserver(className2, new Function1<Activity, Unit>() { // from class: com.therouter.router.Navigator$navigation$6.5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Activity) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@NotNull Activity activity) {
                                    Intrinsics.checkNotNullParameter(activity, "it");
                                    if (Intrinsics.areEqual(activity.getClass().getName(), RouteItem.this.getClassName())) {
                                        navigationCallback2.onActivityCreated(navigator2, activity);
                                        if (TextUtils.isEmpty(RouteItem.this.getAction())) {
                                            return;
                                        }
                                        TheRouter.build(RouteItem.this.getAction()).withObject(NavigatorKt.KEY_OBJECT_NAVIGATOR, navigator2).withObject(NavigatorKt.KEY_OBJECT_ACTIVITY, activity).action(activity);
                                    }
                                }
                            });
                            intent.putExtra(NavigatorKt.KEY_ACTION, routeItem.getAction());
                            intent.putExtra(NavigatorKt.KEY_PATH, Navigator.this.getUrlWithParams());
                            intent.putExtra(NavigatorKt.KEY_DESCRIPTION, routeItem.getDescription());
                            Bundle extras2 = routeItem.getExtras();
                            Bundle bundle6 = extras2.getBundle(NavigatorKt.KEY_BUNDLE);
                            if (bundle6 != null) {
                                extras2.remove(NavigatorKt.KEY_BUNDLE);
                                intent.putExtra(NavigatorKt.KEY_BUNDLE, bundle6);
                            }
                            intent.putExtras(extras2);
                            intent.addFlags(routeItem.getExtras().getInt(NavigatorKt.KEY_INTENT_FLAGS));
                            if (requestCode == -1008600) {
                                if (fragment != null) {
                                    TheRouterKt.debug$default("Navigator::navigation", "fragment.startActivity " + routeItem.getClassName(), null, 4, null);
                                    Fragment fragment2 = fragment;
                                    bundle5 = Navigator.this.optionsCompat;
                                    fragment2.startActivity(intent, bundle5);
                                } else {
                                    TheRouterKt.debug$default("Navigator::navigation", "startActivity " + routeItem.getClassName(), null, 4, null);
                                    Context context3 = context;
                                    if (context3 != null) {
                                        bundle4 = Navigator.this.optionsCompat;
                                        context3.startActivity(intent, bundle4);
                                    }
                                }
                            } else if (fragment != null) {
                                TheRouterKt.debug$default("Navigator::navigation", "fragment.startActivityForResult " + routeItem.getClassName(), null, 4, null);
                                Fragment fragment3 = fragment;
                                int i = requestCode;
                                bundle3 = Navigator.this.optionsCompat;
                                fragment3.startActivityForResult(intent, i, bundle3);
                            } else if (context instanceof Activity) {
                                TheRouterKt.debug$default("Navigator::navigation", "startActivityForResult " + routeItem.getClassName(), null, 4, null);
                                Activity activity = (Activity) context;
                                int i2 = requestCode;
                                bundle2 = Navigator.this.optionsCompat;
                                activity.startActivityForResult(intent, i2, bundle2);
                            } else if (!TheRouter.isDebug()) {
                                Context context4 = context;
                                if (context4 != null) {
                                    bundle = Navigator.this.optionsCompat;
                                    context4.startActivity(intent, bundle);
                                }
                            } else {
                                throw new RuntimeException("TheRouter::Navigator context is not Activity or Fragment");
                            }
                            int i3 = routeItem.getExtras().getInt(NavigatorKt.KEY_ANIM_IN);
                            int i4 = routeItem.getExtras().getInt(NavigatorKt.KEY_ANIM_OUT);
                            if (i3 != 0 || i4 != 0) {
                                if (context instanceof Activity) {
                                    TheRouterKt.debug$default("Navigator::navigation", "overridePendingTransition " + routeItem.getClassName(), null, 4, null);
                                    ((Activity) context).overridePendingTransition(routeItem.getExtras().getInt(NavigatorKt.KEY_ANIM_IN), routeItem.getExtras().getInt(NavigatorKt.KEY_ANIM_OUT));
                                } else {
                                    Fragment fragment4 = fragment;
                                    if (fragment4 != null) {
                                        FragmentActivity activity2 = fragment4.getActivity();
                                        if (activity2 != null) {
                                            activity2.overridePendingTransition(routeItem.getExtras().getInt(NavigatorKt.KEY_ANIM_IN), routeItem.getExtras().getInt(NavigatorKt.KEY_ANIM_OUT));
                                        }
                                    } else if (TheRouter.isDebug()) {
                                        throw new RuntimeException("TheRouter::Navigator context is not Activity, ignore animation");
                                    }
                                }
                            }
                            HistoryRecorder.pushHistory(new ActivityNavigatorHistory(Navigator.this.getUrlWithParams()));
                        }
                    });
                    ncb.onArrival(this);
                    return;
                }
                if (TheRouter.isDebug()) {
                    throw new RuntimeException("TheRouter::Navigator " + matchRouteMap.getClassName() + " is Fragment");
                }
                return;
            }
            ncb.onLost(this, requestCode);
            return;
        }
        this.pending = true;
        TheRouterKt.debug$default("Navigator::navigation", "add pending navigator " + getSimpleUrl(), null, 4, null);
        NavigatorKt.access$getDisposableQueue$p().addLast(new PendingNavigator(this, new Function0<Unit>() { // from class: com.therouter.router.Navigator$navigation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m١٨٥invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m١٨٥invoke() {
                Navigator.this.pending = false;
                Navigator.this.navigation(ctx, fragment, requestCode, ncb);
            }
        }));
    }

    public Navigator(@Nullable String str) {
        this(str, null);
    }
}
