package com.qiahao.nextvideo.utilities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.taobao.accs.messenger.MessengerService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0010\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010¢\u0006\u0004\b\u000e\u0010\u0015J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u001b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u0019J/\u0010\u001c\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0010\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001e\u0010\u0019J\u001b\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001f\u0010\u0019J\u0015\u0010!\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/utilities/PermissionRequester;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", MessengerService.INTENT, "", "isIntentAvailable", "(Landroid/content/Context;Landroid/content/Intent;)Z", "", "permission", "Lio/reactivex/rxjava3/core/i0;", "get", "(Landroid/content/Context;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "", "permissions", "Lio/reactivex/rxjava3/core/z;", "Lkotlin/Pair;", "", "(Landroid/content/Context;[Ljava/lang/String;)Lio/reactivex/rxjava3/core/z;", "Landroidx/appcompat/app/AppCompatActivity;", "c", "getContact", "(Landroidx/appcompat/app/AppCompatActivity;)Lio/reactivex/rxjava3/core/i0;", "getCamera", "getRecordAudio", "getAccessNotificationPolicy", "(Landroidx/appcompat/app/AppCompatActivity;)Lio/reactivex/rxjava3/core/z;", "getReadExternalStorage", "getWriteExternalStorage", "", "launchAppDetailsSettings", "(Landroid/content/Context;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PermissionRequester {

    @NotNull
    public static final PermissionRequester INSTANCE = new PermissionRequester();

    private PermissionRequester() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void get$lambda$1(Context context, final String str, final io.reactivex.rxjava3.core.j0 j0Var) {
        Intrinsics.checkNotNullParameter(j0Var, "subscriber");
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.qiahao.nextvideo.utilities.PermissionGranter");
        PermissionGranter permissionGranter = (PermissionGranter) context;
        if (androidx.core.content.a.checkSelfPermission(context, str) != 0) {
            permissionGranter.requestPermission(new String[]{str}, new Function2() { // from class: com.qiahao.nextvideo.utilities.o0
                public final Object invoke(Object obj, Object obj2) {
                    Unit unit;
                    unit = PermissionRequester.get$lambda$1$lambda$0(j0Var, str, (String[]) obj, (int[]) obj2);
                    return unit;
                }
            });
        } else {
            j0Var.onSuccess(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit get$lambda$1$lambda$0(io.reactivex.rxjava3.core.j0 j0Var, String str, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "<unused var>");
        Intrinsics.checkNotNullParameter(iArr, "result");
        if (ArraysKt.first(iArr) == 0) {
            j0Var.onSuccess(Boolean.TRUE);
        } else {
            j0Var.onError(new SystemPermissionDenied(str));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void get$lambda$3(Context context, String[] strArr, final io.reactivex.rxjava3.core.b0 b0Var) {
        Intrinsics.checkNotNullParameter(b0Var, "subscriber");
        if (!(context instanceof PermissionGranter)) {
            b0Var.onError(new IllegalArgumentException("Context must implement PermissionGranter"));
        } else {
            ((PermissionGranter) context).requestPermission(strArr, new Function2() { // from class: com.qiahao.nextvideo.utilities.l0
                public final Object invoke(Object obj, Object obj2) {
                    Unit unit;
                    unit = PermissionRequester.get$lambda$3$lambda$2(b0Var, (String[]) obj, (int[]) obj2);
                    return unit;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit get$lambda$3$lambda$2(io.reactivex.rxjava3.core.b0 b0Var, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "results");
        b0Var.onNext(new Pair(strArr, iArr));
        return Unit.INSTANCE;
    }

    private final boolean isIntentAvailable(Context context, Intent intent) {
        if (context.getApplicationContext().getPackageManager().queryIntentActivities(intent, 65536).size() > 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public final io.reactivex.rxjava3.core.i0<Boolean> get(@NotNull final Context context, @NotNull final String permission) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permission, "permission");
        io.reactivex.rxjava3.core.i0<Boolean> d = io.reactivex.rxjava3.core.i0.d(new io.reactivex.rxjava3.core.l0() { // from class: com.qiahao.nextvideo.utilities.m0
            public final void a(io.reactivex.rxjava3.core.j0 j0Var) {
                PermissionRequester.get$lambda$1(context, permission, j0Var);
            }
        });
        Intrinsics.checkNotNullExpressionValue(d, "create(...)");
        return d;
    }

    @RequiresApi(23)
    @NotNull
    public final io.reactivex.rxjava3.core.z<Pair<String[], int[]>> getAccessNotificationPolicy(@NotNull AppCompatActivity c) {
        Intrinsics.checkNotNullParameter(c, "c");
        return get((Context) c, new String[]{"android.permission.ACCESS_NOTIFICATION_POLICY"});
    }

    @NotNull
    public final io.reactivex.rxjava3.core.i0<Boolean> getCamera(@NotNull AppCompatActivity c) {
        Intrinsics.checkNotNullParameter(c, "c");
        return get((Context) c, "android.permission.CAMERA");
    }

    @NotNull
    public final io.reactivex.rxjava3.core.i0<Boolean> getContact(@NotNull AppCompatActivity c) {
        Intrinsics.checkNotNullParameter(c, "c");
        return get((Context) c, "android.permission.READ_CONTACTS");
    }

    @NotNull
    public final io.reactivex.rxjava3.core.i0<Boolean> getReadExternalStorage(@NotNull AppCompatActivity c) {
        Intrinsics.checkNotNullParameter(c, "c");
        return get((Context) c, "android.permission.READ_EXTERNAL_STORAGE");
    }

    @NotNull
    public final io.reactivex.rxjava3.core.i0<Boolean> getRecordAudio(@NotNull AppCompatActivity c) {
        Intrinsics.checkNotNullParameter(c, "c");
        return get((Context) c, "android.permission.RECORD_AUDIO");
    }

    @NotNull
    public final io.reactivex.rxjava3.core.i0<Boolean> getWriteExternalStorage(@NotNull AppCompatActivity c) {
        Intrinsics.checkNotNullParameter(c, "c");
        return get((Context) c, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public final void launchAppDetailsSettings(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + applicationContext.getPackageName()));
        if (!isIntentAvailable(context, intent)) {
            return;
        }
        applicationContext.startActivity(intent.addFlags(268435456));
    }

    @NotNull
    public final io.reactivex.rxjava3.core.z<Pair<String[], int[]>> get(@NotNull final Context context, @NotNull final String[] permissions) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        io.reactivex.rxjava3.core.z<Pair<String[], int[]>> create = io.reactivex.rxjava3.core.z.create(new io.reactivex.rxjava3.core.c0() { // from class: com.qiahao.nextvideo.utilities.n0
            public final void a(io.reactivex.rxjava3.core.b0 b0Var) {
                PermissionRequester.get$lambda$3(context, permissions, b0Var);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return create;
    }
}
