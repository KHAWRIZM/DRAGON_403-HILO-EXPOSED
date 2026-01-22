package x6;

import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    final ArrayList f١٨٩٤٢a;

    /* renamed from: b, reason: collision with root package name */
    private final int f١٨٩٤٣b;

    private d(ArrayList arrayList, int i10) {
        this.f١٨٩٤٢a = arrayList;
        this.f١٨٩٤٣b = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final d a(String str, XmlPullParser xmlPullParser) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            if (xmlPullParser.getAttributeName(i10).equals(str)) {
                return b(xmlPullParser.getAttributeValue(i10));
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d b(String str) {
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        boolean z10 = false;
        for (int i11 = 1; i11 < length; i11++) {
            if (z10) {
                z10 = false;
            } else {
                char charAt = str.charAt(i11);
                switch (charAt) {
                    case '\t':
                    case '\n':
                    case ' ':
                    case ',':
                        String substring = str.substring(i10, i11);
                        if (substring.trim().length() > 0) {
                            arrayList.add(Float.valueOf(Float.parseFloat(substring)));
                            if (charAt == '-') {
                                i10 = i11;
                                break;
                            } else {
                                i10 = i11 + 1;
                                z10 = true;
                                break;
                            }
                        } else {
                            i10++;
                            break;
                        }
                    case ')':
                    case 'A':
                    case 'C':
                    case 'H':
                    case 'L':
                    case 'M':
                    case 'Q':
                    case 'S':
                    case 'T':
                    case 'V':
                    case 'Z':
                    case 'a':
                    case 'c':
                    case 'h':
                    case 'l':
                    case 'm':
                    case 'q':
                    case 's':
                    case 't':
                    case 'v':
                    case 'z':
                        String substring2 = str.substring(i10, i11);
                        if (substring2.trim().length() > 0) {
                            arrayList.add(Float.valueOf(Float.parseFloat(substring2)));
                        }
                        return new d(arrayList, i11);
                }
            }
        }
        String substring3 = str.substring(i10);
        if (substring3.length() > 0) {
            try {
                arrayList.add(Float.valueOf(Float.parseFloat(substring3)));
            } catch (NumberFormatException unused) {
            }
            i10 = str.length();
        }
        return new d(arrayList, i10);
    }
}
