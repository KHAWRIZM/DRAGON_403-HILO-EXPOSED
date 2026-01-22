package da;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.XmlResourceParser;
import com.facebook.internal.NativeProtocol;
import ea.c;
import ea.d;
import ea.e;
import ea.f;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import ka.g;
import ka.h;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b {
    public static int a(Context context, String str) {
        AssetManager assets = context.getAssets();
        try {
            if (h.b(context) >= 28 && h.a() >= 28 && h.a() < 30) {
                Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                declaredMethod.setAccessible(true);
                Method method = (Method) declaredMethod.invoke(AssetManager.class, "findCookieForPath", new Class[]{String.class});
                if (method != null) {
                    method.setAccessible(true);
                    Integer num = (Integer) method.invoke(context.getAssets(), str);
                    if (num != null) {
                        return num.intValue();
                    }
                }
            }
            Integer num2 = (Integer) assets.getClass().getDeclaredMethod("addAssetPath", String.class).invoke(assets, str);
            if (num2 != null) {
                return num2.intValue();
            }
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (NoSuchMethodException e11) {
            e11.printStackTrace();
        } catch (InvocationTargetException e12) {
            e12.printStackTrace();
        }
        return 0;
    }

    public static a b(Context context) {
        a d10;
        int a10 = a(context, context.getApplicationInfo().sourceDir);
        a aVar = null;
        if (a10 == 0) {
            return null;
        }
        try {
            d10 = d(context, a10);
        } catch (IOException e10) {
            e = e10;
        } catch (XmlPullParserException e11) {
            e = e11;
        }
        try {
            if (!g.t(context.getPackageName(), d10.f١٣٦٦٠a)) {
                return null;
            }
            return d10;
        } catch (IOException | XmlPullParserException e12) {
            e = e12;
            aVar = d10;
            e.printStackTrace();
            return aVar;
        }
    }

    private static ea.a c(XmlResourceParser xmlResourceParser) {
        ea.a aVar = new ea.a();
        String attributeValue = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        if (attributeValue == null) {
            attributeValue = "";
        }
        aVar.f١٣٩٦٩a = attributeValue;
        aVar.f١٣٩٧٠b = xmlResourceParser.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "supportsPictureInPicture", false);
        while (true) {
            int next = xmlResourceParser.next();
            String name = xmlResourceParser.getName();
            if (next != 3 || (!g.l("activity", name) && !g.l("activity-alias", name))) {
                if (next == 2 && g.l("intent-filter", name)) {
                    if (aVar.f١٣٩٧١c == null) {
                        aVar.f١٣٩٧١c = new ArrayList();
                    }
                    aVar.f١٣٩٧١c.add(g(xmlResourceParser));
                } else if (next == 2 && g.l("meta-data", name)) {
                    if (aVar.f١٣٩٧٢d == null) {
                        aVar.f١٣٩٧٢d = new ArrayList();
                    }
                    aVar.f١٣٩٧٢d.add(h(xmlResourceParser));
                }
            }
        }
        return aVar;
    }

    public static a d(Context context, int i10) {
        ea.b bVar;
        a aVar = new a();
        XmlResourceParser openXmlResourceParser = context.getAssets().openXmlResourceParser(i10, "AndroidManifest.xml");
        do {
            try {
                if (openXmlResourceParser.getEventType() == 2) {
                    String name = openXmlResourceParser.getName();
                    if (g.l("manifest", name)) {
                        aVar.f١٣٦٦٠a = i(openXmlResourceParser);
                    }
                    if (g.l("uses-sdk", name)) {
                        aVar.f١٣٦٦١b = l(openXmlResourceParser);
                    }
                    if (g.l("uses-permission", name) || g.l("uses-permission-sdk-23", name) || g.l("uses-permission-sdk-m", name)) {
                        aVar.f١٣٦٦٢c.add(j(openXmlResourceParser));
                    }
                    if (g.l("queries", name)) {
                        aVar.f١٣٦٦٣d.add(i(openXmlResourceParser));
                    }
                    if (g.l("application", name)) {
                        aVar.f١٣٦٦٤e = e(openXmlResourceParser);
                    }
                    if (g.l("activity", name) || g.l("activity-alias", name)) {
                        aVar.f١٣٦٦٥f.add(c(openXmlResourceParser));
                    }
                    if (g.l("service", name)) {
                        aVar.f١٣٦٦٦g.add(k(openXmlResourceParser));
                    }
                    if (g.l("receiver", name)) {
                        aVar.f١٣٦٦٧h.add(f(openXmlResourceParser));
                    }
                    if (g.l("meta-data", name) && (bVar = aVar.f١٣٦٦٤e) != null) {
                        if (bVar.f١٣٩٧٥c == null) {
                            bVar.f١٣٩٧٥c = new ArrayList();
                        }
                        aVar.f١٣٦٦٤e.f١٣٩٧٥c.add(h(openXmlResourceParser));
                    }
                }
            } catch (Throwable th) {
                if (openXmlResourceParser != null) {
                    try {
                        openXmlResourceParser.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } while (openXmlResourceParser.next() != 1);
        openXmlResourceParser.close();
        return aVar;
    }

    private static ea.b e(XmlResourceParser xmlResourceParser) {
        ea.b bVar = new ea.b();
        String attributeValue = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        if (attributeValue == null) {
            attributeValue = "";
        }
        bVar.f١٣٩٧٣a = attributeValue;
        bVar.f١٣٩٧٤b = xmlResourceParser.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "requestLegacyExternalStorage", false);
        return bVar;
    }

    private static c f(XmlResourceParser xmlResourceParser) {
        c cVar = new c();
        String attributeValue = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        if (attributeValue == null) {
            attributeValue = "";
        }
        cVar.f١٣٩٧٦a = attributeValue;
        cVar.f١٣٩٧٧b = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "permission");
        while (true) {
            int next = xmlResourceParser.next();
            String name = xmlResourceParser.getName();
            if (next == 3 && g.l("receiver", name)) {
                return cVar;
            }
            if (next == 2 && g.l("intent-filter", name)) {
                if (cVar.f١٣٩٧٨c == null) {
                    cVar.f١٣٩٧٨c = new ArrayList();
                }
                cVar.f١٣٩٧٨c.add(g(xmlResourceParser));
            } else if (next == 2 && g.l("meta-data", name)) {
                if (cVar.f١٣٩٧٩d == null) {
                    cVar.f١٣٩٧٩d = new ArrayList();
                }
                cVar.f١٣٩٧٩d.add(h(xmlResourceParser));
            }
        }
    }

    private static d g(XmlResourceParser xmlResourceParser) {
        d dVar = new d();
        while (true) {
            int next = xmlResourceParser.next();
            String name = xmlResourceParser.getName();
            if (next == 3 && g.l("intent-filter", name)) {
                return dVar;
            }
            if (next == 2) {
                if (g.l(NativeProtocol.WEB_DIALOG_ACTION, name)) {
                    dVar.f١٣٩٨٠a.add(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name"));
                } else if (g.l("category", name)) {
                    dVar.f١٣٩٨١b.add(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name"));
                }
            }
        }
    }

    private static e h(XmlResourceParser xmlResourceParser) {
        e eVar = new e();
        eVar.f١٣٩٨٢a = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        eVar.f١٣٩٨٣b = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "value");
        eVar.f١٣٩٨٤c = xmlResourceParser.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "resource", 0);
        return eVar;
    }

    private static String i(XmlResourceParser xmlResourceParser) {
        String attributeValue = xmlResourceParser.getAttributeValue(null, "package");
        if (attributeValue == null) {
            return "";
        }
        return attributeValue;
    }

    private static f j(XmlResourceParser xmlResourceParser) {
        f fVar = new f();
        fVar.f١٣٩٨٦a = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        fVar.f١٣٩٨٧b = xmlResourceParser.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxSdkVersion", Integer.MAX_VALUE);
        fVar.f١٣٩٨٨c = xmlResourceParser.getAttributeIntValue("http://schemas.android.com/apk/res/android", "usesPermissionFlags", 0);
        return fVar;
    }

    private static ea.g k(XmlResourceParser xmlResourceParser) {
        ea.g gVar = new ea.g();
        String attributeValue = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        if (attributeValue == null) {
            attributeValue = "";
        }
        gVar.f١٣٩٨٩a = attributeValue;
        gVar.f١٣٩٩٠b = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "permission");
        while (true) {
            int next = xmlResourceParser.next();
            String name = xmlResourceParser.getName();
            if (next == 3 && g.l("service", name)) {
                return gVar;
            }
            if (next == 2 && g.l("intent-filter", name)) {
                if (gVar.f١٣٩٩١c == null) {
                    gVar.f١٣٩٩١c = new ArrayList();
                }
                gVar.f١٣٩٩١c.add(g(xmlResourceParser));
            } else if (next == 2 && g.l("meta-data", name)) {
                if (gVar.f١٣٩٩٢d == null) {
                    gVar.f١٣٩٩٢d = new ArrayList();
                }
                gVar.f١٣٩٩٢d.add(h(xmlResourceParser));
            }
        }
    }

    private static ea.h l(XmlResourceParser xmlResourceParser) {
        ea.h hVar = new ea.h();
        hVar.f١٣٩٩٣a = xmlResourceParser.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minSdkVersion", 0);
        return hVar;
    }
}
