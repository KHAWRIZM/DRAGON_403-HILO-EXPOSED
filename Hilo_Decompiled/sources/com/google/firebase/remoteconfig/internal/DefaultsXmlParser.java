package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class DefaultsXmlParser {
    private static final String XML_TAG_ENTRY = "entry";
    private static final String XML_TAG_KEY = "key";
    private static final String XML_TAG_VALUE = "value";

    /* JADX WARN: Removed duplicated region for block: B:37:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0088 A[Catch: IOException -> 0x0013, XmlPullParserException -> 0x0016, TryCatch #2 {IOException -> 0x0013, XmlPullParserException -> 0x0016, blocks: (B:3:0x0007, B:5:0x000d, B:8:0x0019, B:13:0x002b, B:15:0x008c, B:18:0x0033, B:22:0x0043, B:24:0x0047, B:30:0x0055, B:38:0x007d, B:40:0x0083, B:42:0x0088, B:44:0x0064, B:47:0x006e), top: B:2:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, String> getDefaultsFromXml(Context context, int i10) {
        Resources resources;
        char c10;
        HashMap hashMap = new HashMap();
        try {
            resources = context.getResources();
        } catch (IOException e10) {
            e = e10;
            Log.e(FirebaseRemoteConfig.TAG, "Encountered an error while parsing the defaults XML file.", e);
            return hashMap;
        } catch (XmlPullParserException e11) {
            e = e11;
            Log.e(FirebaseRemoteConfig.TAG, "Encountered an error while parsing the defaults XML file.", e);
            return hashMap;
        }
        if (resources == null) {
            Log.e(FirebaseRemoteConfig.TAG, "Could not find the resources of the current context while trying to set defaults from an XML.");
            return hashMap;
        }
        XmlResourceParser xml = resources.getXml(i10);
        String str = null;
        String str2 = null;
        String str3 = null;
        for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
            if (eventType == 2) {
                str = xml.getName();
            } else if (eventType == 3) {
                if (xml.getName().equals(XML_TAG_ENTRY)) {
                    if (str2 != null && str3 != null) {
                        hashMap.put(str2, str3);
                    } else {
                        Log.w(FirebaseRemoteConfig.TAG, "An entry in the defaults XML has an invalid key and/or value tag.");
                    }
                    str2 = null;
                    str3 = null;
                }
                str = null;
            } else if (eventType == 4 && str != null) {
                int hashCode = str.hashCode();
                if (hashCode != 106079) {
                    if (hashCode == 111972721 && str.equals("value")) {
                        c10 = 1;
                        if (c10 == 0) {
                            if (c10 != 1) {
                                Log.w(FirebaseRemoteConfig.TAG, "Encountered an unexpected tag while parsing the defaults XML.");
                            } else {
                                str3 = xml.getText();
                            }
                        } else {
                            str2 = xml.getText();
                        }
                    }
                    c10 = 65535;
                    if (c10 == 0) {
                    }
                } else {
                    if (str.equals("key")) {
                        c10 = 0;
                        if (c10 == 0) {
                        }
                    }
                    c10 = 65535;
                    if (c10 == 0) {
                    }
                }
            }
        }
        return hashMap;
    }
}
