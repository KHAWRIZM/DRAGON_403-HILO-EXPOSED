package x6;

import android.util.Log;
import java.util.HashMap;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class b {

    /* renamed from: d, reason: collision with root package name */
    private static final String f١٨٩٣٤d = i.f١٨٩٥٣n;

    /* renamed from: a, reason: collision with root package name */
    final HashMap f١٨٩٣٥a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Stack f١٨٩٣٦b = new Stack();

    /* renamed from: c, reason: collision with root package name */
    private final XmlPullParser f١٨٩٣٧c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        final String f١٨٩٣٨a;

        /* renamed from: b, reason: collision with root package name */
        int f١٨٩٣٩b = 0;

        /* renamed from: c, reason: collision with root package name */
        final StringBuilder f١٨٩٤٠c = new StringBuilder();

        public a(String str) {
            this.f١٨٩٣٨a = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(XmlPullParser xmlPullParser) {
        this.f١٨٩٣٧c = xmlPullParser;
    }

    private void a(StringBuilder sb, String str, XmlPullParser xmlPullParser) {
        sb.append("<");
        sb.append(str);
        for (int i10 = 0; i10 < xmlPullParser.getAttributeCount(); i10++) {
            sb.append(" ");
            sb.append(xmlPullParser.getAttributeName(i10));
            sb.append("='");
            sb.append(e.b(xmlPullParser.getAttributeValue(i10)));
            sb.append("'");
        }
        sb.append(">");
    }

    void b() {
        String name = this.f١٨٩٣٧c.getName();
        if (this.f١٨٩٣٦b.size() > 0) {
            a aVar = (a) this.f١٨٩٣٦b.lastElement();
            aVar.f١٨٩٤٠c.append("</");
            aVar.f١٨٩٤٠c.append(name);
            aVar.f١٨٩٤٠c.append(">");
            int i10 = aVar.f١٨٩٣٩b - 1;
            aVar.f١٨٩٣٩b = i10;
            if (i10 == 0) {
                String sb = aVar.f١٨٩٤٠c.toString();
                this.f١٨٩٣٥a.put(aVar.f١٨٩٣٨a, sb);
                this.f١٨٩٣٦b.pop();
                if (this.f١٨٩٣٦b.size() > 0) {
                    ((a) this.f١٨٩٣٦b.lastElement()).f١٨٩٤٠c.append(sb);
                }
                Log.w(f١٨٩٣٤d, sb);
            }
        }
    }

    public void c() {
        int eventType = this.f١٨٩٣٧c.getEventType();
        do {
            if (eventType != 0 && eventType != 1) {
                if (eventType == 2) {
                    d();
                } else if (eventType == 3) {
                    b();
                }
            }
            eventType = this.f١٨٩٣٧c.next();
        } while (eventType != 1);
    }

    void d() {
        String name = this.f١٨٩٣٧c.getName();
        String c10 = e.c("id", this.f١٨٩٣٧c);
        if (c10 != null) {
            this.f١٨٩٣٦b.push(new a(c10));
        }
        if (this.f١٨٩٣٦b.size() > 0) {
            a aVar = (a) this.f١٨٩٣٦b.lastElement();
            aVar.f١٨٩٣٩b++;
            a(aVar.f١٨٩٤٠c, name, this.f١٨٩٣٧c);
        }
    }
}
