package x6;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.oudi.utils.date.DateFormat;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Float a(String str, XmlPullParser xmlPullParser, float f10, float f11, float f12) {
        float f13;
        String c10 = c(str, xmlPullParser);
        if (c10 == null) {
            return null;
        }
        if (c10.endsWith("px")) {
            return Float.valueOf(Float.parseFloat(c10.substring(0, c10.length() - 2)));
        }
        if (c10.endsWith(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_PT)) {
            return Float.valueOf((Float.valueOf(c10.substring(0, c10.length() - 2)).floatValue() * f10) / 72.0f);
        }
        if (c10.endsWith("pc")) {
            return Float.valueOf((Float.valueOf(c10.substring(0, c10.length() - 2)).floatValue() * f10) / 6.0f);
        }
        if (c10.endsWith("cm")) {
            return Float.valueOf((Float.valueOf(c10.substring(0, c10.length() - 2)).floatValue() * f10) / 2.54f);
        }
        if (c10.endsWith(DateFormat.MINUTE)) {
            return Float.valueOf((Float.valueOf(c10.substring(0, c10.length() - 2)).floatValue() * f10) / 254.0f);
        }
        if (c10.endsWith("in")) {
            return Float.valueOf(Float.valueOf(c10.substring(0, c10.length() - 2)).floatValue() * f10);
        }
        if (c10.endsWith("%")) {
            Float valueOf = Float.valueOf(c10.substring(0, c10.length() - 1));
            if (!str.contains("x") && !str.equals(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
                if (!str.contains("y") && !str.equals(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
                    f13 = (f12 + f11) / 2.0f;
                } else {
                    f13 = f12 / 100.0f;
                }
            } else {
                f13 = f11 / 100.0f;
            }
            return Float.valueOf(valueOf.floatValue() * f13);
        }
        return Float.valueOf(c10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String b(String str) {
        return str.replaceAll("\"", "&quot;").replaceAll("'", "&apos").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll(DispatchConstants.SIGN_SPLIT_SYMBOL, "&amp;");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String c(String str, XmlPullParser xmlPullParser) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            if (xmlPullParser.getAttributeName(i10).equals(str)) {
                return xmlPullParser.getAttributeValue(i10);
            }
        }
        return null;
    }
}
