package anet.channel.util;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static AtomicInteger f٥٠٨٩a = new AtomicInteger();

    public static String a(String str) {
        if (f٥٠٨٩a.get() == Integer.MAX_VALUE) {
            f٥٠٨٩a.set(0);
        }
        if (!TextUtils.isEmpty(str)) {
            return StringUtils.concatString(str, ".AWCN", String.valueOf(f٥٠٨٩a.incrementAndGet()));
        }
        return StringUtils.concatString("AWCN", String.valueOf(f٥٠٨٩a.incrementAndGet()));
    }
}
