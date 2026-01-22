package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    static HashMap f١٩٧٥b;

    /* renamed from: a, reason: collision with root package name */
    private HashMap f١٩٧٦a = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        f١٩٧٥b = hashMap;
        try {
            hashMap.put("KeyAttribute", e.class.getConstructor(null));
            f١٩٧٥b.put("KeyPosition", h.class.getConstructor(null));
            f١٩٧٥b.put("KeyCycle", f.class.getConstructor(null));
            f١٩٧٥b.put("KeyTimeCycle", j.class.getConstructor(null));
            f١٩٧٥b.put("KeyTrigger", k.class.getConstructor(null));
        } catch (NoSuchMethodException e10) {
            Log.e("KeyFrames", "unable to load", e10);
        }
    }

    public g() {
    }

    public void a(m mVar) {
        ArrayList arrayList = (ArrayList) this.f١٩٧٦a.get(-1);
        if (arrayList != null) {
            mVar.b(arrayList);
        }
    }

    public void b(m mVar) {
        ArrayList arrayList = (ArrayList) this.f١٩٧٦a.get(Integer.valueOf(mVar.f٢٠٢١c));
        if (arrayList != null) {
            mVar.b(arrayList);
        }
        ArrayList arrayList2 = (ArrayList) this.f١٩٧٦a.get(-1);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f(((ConstraintLayout.b) mVar.f٢٠٢٠b.getLayoutParams()).f٢٣٠٤c0)) {
                    mVar.a(dVar);
                }
            }
        }
    }

    public void c(d dVar) {
        if (!this.f١٩٧٦a.containsKey(Integer.valueOf(dVar.f١٩٥٣b))) {
            this.f١٩٧٦a.put(Integer.valueOf(dVar.f١٩٥٣b), new ArrayList());
        }
        ArrayList arrayList = (ArrayList) this.f١٩٧٦a.get(Integer.valueOf(dVar.f١٩٥٣b));
        if (arrayList != null) {
            arrayList.add(dVar);
        }
    }

    public ArrayList d(int i10) {
        return (ArrayList) this.f١٩٧٦a.get(Integer.valueOf(i10));
    }

    public g(Context context, XmlPullParser xmlPullParser) {
        Exception e10;
        d dVar;
        Constructor constructor;
        HashMap hashMap;
        HashMap hashMap2;
        try {
            int eventType = xmlPullParser.getEventType();
            d dVar2 = null;
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && "KeyFrameSet".equals(xmlPullParser.getName())) {
                        return;
                    }
                } else {
                    String name = xmlPullParser.getName();
                    if (f١٩٧٥b.containsKey(name)) {
                        try {
                            constructor = (Constructor) f١٩٧٥b.get(name);
                        } catch (Exception e11) {
                            d dVar3 = dVar2;
                            e10 = e11;
                            dVar = dVar3;
                        }
                        if (constructor != null) {
                            dVar = (d) constructor.newInstance(null);
                            try {
                                dVar.e(context, Xml.asAttributeSet(xmlPullParser));
                                c(dVar);
                            } catch (Exception e12) {
                                e10 = e12;
                                Log.e("KeyFrames", "unable to create ", e10);
                                dVar2 = dVar;
                                eventType = xmlPullParser.next();
                            }
                            dVar2 = dVar;
                        } else {
                            throw new NullPointerException("Keymaker for " + name + " not found");
                            break;
                        }
                    } else if (name.equalsIgnoreCase("CustomAttribute")) {
                        if (dVar2 != null && (hashMap2 = dVar2.f١٩٥٦e) != null) {
                            androidx.constraintlayout.widget.a.h(context, xmlPullParser, hashMap2);
                        }
                    } else if (name.equalsIgnoreCase("CustomMethod") && dVar2 != null && (hashMap = dVar2.f١٩٥٦e) != null) {
                        androidx.constraintlayout.widget.a.h(context, xmlPullParser, hashMap);
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e13) {
            e13.printStackTrace();
        } catch (XmlPullParserException e14) {
            e14.printStackTrace();
        }
    }
}
