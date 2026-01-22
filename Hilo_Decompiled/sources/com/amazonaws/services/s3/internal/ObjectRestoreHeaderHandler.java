package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.internal.ObjectRestoreResult;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ObjectRestoreHeaderHandler<T extends ObjectRestoreResult> implements HeaderHandler<T> {
    private static final Pattern DATE_PATTERN = Pattern.compile("expiry-date=\"(.*?)\"");
    private static final Pattern ONGOING_PATTERN = Pattern.compile("ongoing-request=\"(.*?)\"");
    private static final Log log = LogFactory.getLog(ObjectRestoreHeaderHandler.class);

    private Boolean parseBoolean(String str) {
        Matcher matcher = ONGOING_PATTERN.matcher(str);
        if (matcher.find()) {
            return Boolean.valueOf(Boolean.parseBoolean(matcher.group(1)));
        }
        return null;
    }

    private Date parseDate(String str) {
        Matcher matcher = DATE_PATTERN.matcher(str);
        if (matcher.find()) {
            try {
                return ServiceUtils.parseRfc822Date(matcher.group(1));
            } catch (Exception e10) {
                log.warn("Error parsing expiry-date from x-amz-restore header.", e10);
                return null;
            }
        }
        return null;
    }

    @Override // com.amazonaws.services.s3.internal.HeaderHandler
    public void handle(T t10, HttpResponse httpResponse) {
        String str = httpResponse.getHeaders().get(Headers.RESTORE);
        if (str != null) {
            t10.setRestoreExpirationTime(parseDate(str));
            Boolean parseBoolean = parseBoolean(str);
            if (parseBoolean != null) {
                t10.setOngoingRestore(parseBoolean.booleanValue());
            }
        }
    }
}
