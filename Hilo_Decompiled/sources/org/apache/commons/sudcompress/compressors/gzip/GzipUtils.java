package org.apache.commons.sudcompress.compressors.gzip;

import java.util.LinkedHashMap;
import java.util.Locale;
import y.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class GzipUtils {
    private static final b fileNameUtil;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(".tgz", ".tar");
        linkedHashMap.put(".taz", ".tar");
        linkedHashMap.put(".svgz", ".svg");
        linkedHashMap.put(".cpgz", ".cpio");
        linkedHashMap.put(".wmz", ".wmf");
        linkedHashMap.put(".emz", ".emf");
        linkedHashMap.put(".gz", "");
        linkedHashMap.put(".z", "");
        linkedHashMap.put("-gz", "");
        linkedHashMap.put("-z", "");
        linkedHashMap.put("_z", "");
        fileNameUtil = new b(linkedHashMap);
    }

    private GzipUtils() {
    }

    public static String getCompressedFilename(String str) {
        b bVar = fileNameUtil;
        bVar.getClass();
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        int length = lowerCase.length();
        for (int i = bVar.f; i <= bVar.e && i < length; i++) {
            int i2 = length - i;
            String str2 = (String) bVar.a.get(lowerCase.substring(i2));
            if (str2 != null) {
                return str.substring(0, i2) + str2;
            }
        }
        return str + bVar.g;
    }

    public static String getUncompressedFilename(String str) {
        b bVar = fileNameUtil;
        bVar.getClass();
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        int length = lowerCase.length();
        for (int i = bVar.d; i <= bVar.c && i < length; i++) {
            int i2 = length - i;
            String str2 = (String) bVar.b.get(lowerCase.substring(i2));
            if (str2 != null) {
                return str.substring(0, i2) + str2;
            }
        }
        return str;
    }

    public static boolean isCompressedFilename(String str) {
        b bVar = fileNameUtil;
        bVar.getClass();
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        int length = lowerCase.length();
        for (int i = bVar.d; i <= bVar.c && i < length; i++) {
            if (bVar.b.containsKey(lowerCase.substring(length - i))) {
                return true;
            }
        }
        return false;
    }
}
