package anetwork.channel.cache;

import anet.channel.util.HttpHelper;
import anetwork.channel.cache.Cache;
import com.amazonaws.services.s3.Headers;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final TimeZone f٥١٣٧a = TimeZone.getTimeZone("GMT");

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f٥١٣٨b = new ThreadLocal<>();

    public static String a(long j10) {
        return a().format(new Date(j10));
    }

    private static long a(String str) {
        if (str.length() == 0) {
            return 0L;
        }
        try {
            ParsePosition parsePosition = new ParsePosition(0);
            Date parse = a().parse(str, parsePosition);
            if (parsePosition.getIndex() == str.length()) {
                return parse.getTime();
            }
        } catch (Exception unused) {
        }
        return 0L;
    }

    public static Cache.Entry a(Map<String, List<String>> map) {
        long j10;
        long currentTimeMillis = System.currentTimeMillis();
        String singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, "Cache-Control");
        int i10 = 0;
        if (singleHeaderFieldByKey != null) {
            String[] split = singleHeaderFieldByKey.split(",");
            j10 = 0;
            while (true) {
                if (i10 >= split.length) {
                    break;
                }
                String trim = split[i10].trim();
                if (trim.equals("no-store")) {
                    return null;
                }
                if (trim.equals("no-cache")) {
                    j10 = 0;
                    break;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j10 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                }
                i10++;
            }
            i10 = 1;
        } else {
            j10 = 0;
        }
        String singleHeaderFieldByKey2 = HttpHelper.getSingleHeaderFieldByKey(map, "Date");
        long a10 = singleHeaderFieldByKey2 != null ? a(singleHeaderFieldByKey2) : 0L;
        String singleHeaderFieldByKey3 = HttpHelper.getSingleHeaderFieldByKey(map, Headers.EXPIRES);
        long a11 = singleHeaderFieldByKey3 != null ? a(singleHeaderFieldByKey3) : 0L;
        String singleHeaderFieldByKey4 = HttpHelper.getSingleHeaderFieldByKey(map, Headers.LAST_MODIFIED);
        long a12 = singleHeaderFieldByKey4 != null ? a(singleHeaderFieldByKey4) : 0L;
        String singleHeaderFieldByKey5 = HttpHelper.getSingleHeaderFieldByKey(map, Headers.ETAG);
        if (i10 != 0) {
            currentTimeMillis += j10 * 1000;
        } else if (a10 > 0 && a11 >= a10) {
            currentTimeMillis += a11 - a10;
        } else if (a12 <= 0) {
            currentTimeMillis = 0;
        }
        if (currentTimeMillis == 0 && singleHeaderFieldByKey5 == null) {
            return null;
        }
        Cache.Entry entry = new Cache.Entry();
        entry.etag = singleHeaderFieldByKey5;
        entry.ttl = currentTimeMillis;
        entry.serverDate = a10;
        entry.lastModified = a12;
        entry.responseHeaders = map;
        return entry;
    }

    private static SimpleDateFormat a() {
        ThreadLocal<SimpleDateFormat> threadLocal = f٥١٣٨b;
        SimpleDateFormat simpleDateFormat = threadLocal.get();
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat2.setTimeZone(f٥١٣٧a);
        threadLocal.set(simpleDateFormat2);
        return simpleDateFormat2;
    }
}
