package com.therouter.router;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.therouter.TheRouterKt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0006\u001a\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u001a\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002¨\u0006\u000b"}, d2 = {"getFileListFromAssets", "", "", "context", "Landroid/content/Context;", TUIConstants.TUICalling.PARAM_NAME_AUDIO_PATH, "(Landroid/content/Context;Ljava/lang/String;)[Ljava/lang/String;", "getStreamFromAssets", "Ljava/io/InputStream;", "fileName", "getStringFromAssets", "router_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAssetUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AssetUtils.kt\ncom/therouter/router/AssetUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,60:1\n1#2:61\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class AssetUtilsKt {
    @Nullable
    public static final String[] getFileListFromAssets(@Nullable Context context, @Nullable String str) {
        if (context == null) {
            return null;
        }
        AssetManager assets = context.getAssets();
        try {
            Intrinsics.checkNotNull(str);
            return assets.list(str);
        } catch (IOException e) {
            TheRouterKt.debug("AssetsUtils", "error read " + str + " from assets", new Function0<Unit>() { // from class: com.therouter.router.AssetUtilsKt$getFileListFromAssets$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m١٨٠invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m١٨٠invoke() {
                    e.printStackTrace();
                }
            });
            return null;
        }
    }

    @Nullable
    public static final InputStream getStreamFromAssets(@Nullable Context context, @Nullable String str) {
        Resources resources;
        AssetManager assets;
        if (str == null || context == null || (resources = context.getResources()) == null || (assets = resources.getAssets()) == null) {
            return null;
        }
        return assets.open(str);
    }

    @NotNull
    public static final String getStringFromAssets(@NotNull Context context, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            AssetManager assets = context.getResources().getAssets();
            Intrinsics.checkNotNull(str);
            InputStreamReader inputStreamReader = new InputStreamReader(assets.open(str));
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb2.append(readLine);
                        } else {
                            String sb3 = sb2.toString();
                            Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
                            CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                            CloseableKt.closeFinally(inputStreamReader, (Throwable) null);
                            return sb3;
                        }
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamReader, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            TheRouterKt.debug("AssetsUtils", "error read " + str + " from assets", new Function0<Unit>() { // from class: com.therouter.router.AssetUtilsKt$getStringFromAssets$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m١٨١invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m١٨١invoke() {
                    e.printStackTrace();
                }
            });
            return "";
        }
    }
}
