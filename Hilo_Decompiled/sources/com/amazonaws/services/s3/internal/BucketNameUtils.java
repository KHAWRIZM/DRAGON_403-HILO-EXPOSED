package com.amazonaws.services.s3.internal;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum BucketNameUtils {
    ;

    private static final Pattern IP_ADDRESS_PATTERN = Pattern.compile("(\\d+\\.){3}\\d+");
    private static final int MAX_BUCKET_NAME_LENGTH = 63;
    private static final int MIN_BUCKET_NAME_LENGTH = 3;

    private static boolean exception(boolean z10, String str) {
        if (!z10) {
            return false;
        }
        throw new IllegalArgumentException(str);
    }

    public static boolean isDNSBucketName(String str) {
        return isValidV2BucketName(str);
    }

    public static boolean isValidV2BucketName(String str) {
        return isValidV2BucketName(str, false);
    }

    public static void validateBucketName(String str) {
        isValidV2BucketName(str, true);
    }

    private static boolean isValidV2BucketName(String str, boolean z10) {
        if (str == null) {
            return exception(z10, "Bucket name cannot be null");
        }
        if (str.length() >= 3 && str.length() <= 63) {
            if (IP_ADDRESS_PATTERN.matcher(str).matches()) {
                return exception(z10, "Bucket name must not be formatted as an IP Address");
            }
            int i10 = 0;
            char c10 = 0;
            while (i10 < str.length()) {
                char charAt = str.charAt(i10);
                if (charAt >= 'A' && charAt <= 'Z') {
                    return exception(z10, "Bucket name should not contain uppercase characters");
                }
                if (charAt == ' ' || charAt == '\t' || charAt == '\r' || charAt == '\n') {
                    return exception(z10, "Bucket name should not contain white space");
                }
                if (charAt == '.') {
                    if (c10 == 0) {
                        return exception(z10, "Bucket name should not begin with a period");
                    }
                    if (c10 == '.') {
                        return exception(z10, "Bucket name should not contain two adjacent periods");
                    }
                    if (c10 == '-') {
                        return exception(z10, "Bucket name should not contain dashes next to periods");
                    }
                } else if (charAt == '-') {
                    if (c10 == '.') {
                        return exception(z10, "Bucket name should not contain dashes next to periods");
                    }
                    if (c10 == 0) {
                        return exception(z10, "Bucket name should not begin with a '-'");
                    }
                } else if (charAt < '0' || ((charAt > '9' && charAt < 'a') || charAt > 'z')) {
                    return exception(z10, "Bucket name should not contain '" + charAt + "'");
                }
                i10++;
                c10 = charAt;
            }
            if (c10 == '.' || c10 == '-') {
                return exception(z10, "Bucket name should not end with '-' or '.'");
            }
            return !str.contains(InstructionFileId.DOT);
        }
        return exception(z10, "Bucket name should be between 3 and 63 characters long");
    }
}
