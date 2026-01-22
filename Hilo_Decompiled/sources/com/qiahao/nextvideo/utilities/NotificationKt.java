package com.qiahao.nextvideo.utilities;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.qiahao.nextvideo.app.MainActivity;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"NOTIFICATION_CHANNEL_ID", "", "NOTIFICATION_MAX_ID", "Ljava/util/concurrent/atomic/AtomicInteger;", "getNOTIFICATION_MAX_ID", "()Ljava/util/concurrent/atomic/AtomicInteger;", "makeMoodIntent", "Landroid/app/PendingIntent;", "context", "Landroid/content/Context;", "name", "moodId", "", "app_googleRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class NotificationKt {

    @NotNull
    public static final String NOTIFICATION_CHANNEL_ID = "com.qiahao.nextvideo";

    @NotNull
    private static final AtomicInteger NOTIFICATION_MAX_ID = new AtomicInteger(Integer.MAX_VALUE);

    @NotNull
    public static final AtomicInteger getNOTIFICATION_MAX_ID() {
        return NOTIFICATION_MAX_ID;
    }

    @NotNull
    public static final PendingIntent makeMoodIntent(@NotNull Context context, @NotNull String str, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        Intent putExtra = new Intent(context, (Class<?>) MainActivity.class).putExtra(str, i);
        if (Build.VERSION.SDK_INT >= 23) {
            i2 = 67108864;
        } else {
            i2 = 134217728;
        }
        PendingIntent activity = PendingIntent.getActivity(context, 10, putExtra, i2);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        return activity;
    }

    public static /* synthetic */ PendingIntent makeMoodIntent$default(Context context, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        return makeMoodIntent(context, str, i);
    }
}
