package org.xmlpull.v1;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class XmlPullParserFactory {
    public static final String PROPERTY_NAME = "org.xmlpull.v1.XmlPullParserFactory";
    private static final String RESOURCE_NAME = "/META-INF/services/org.xmlpull.v1.XmlPullParserFactory";
    static final Class referenceContextClass;
    protected String classNamesLocation;
    protected Hashtable features = new Hashtable();
    protected Vector parserClasses;
    protected Vector serializerClasses;

    static {
        new XmlPullParserFactory();
        referenceContextClass = XmlPullParserFactory.class;
    }

    protected XmlPullParserFactory() {
    }

    public static XmlPullParserFactory newInstance() throws XmlPullParserException {
        return newInstance(null, null);
    }

    public boolean getFeature(String str) {
        Boolean bool = (Boolean) this.features.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean isNamespaceAware() {
        return getFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES);
    }

    public boolean isValidating() {
        return getFeature(XmlPullParser.FEATURE_VALIDATION);
    }

    public XmlPullParser newPullParser() throws XmlPullParserException {
        Vector vector = this.parserClasses;
        if (vector != null) {
            if (vector.size() != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < this.parserClasses.size(); i++) {
                    Class cls = (Class) this.parserClasses.elementAt(i);
                    try {
                        XmlPullParser xmlPullParser = (XmlPullParser) cls.newInstance();
                        Enumeration keys = this.features.keys();
                        while (keys.hasMoreElements()) {
                            String str = (String) keys.nextElement();
                            Boolean bool = (Boolean) this.features.get(str);
                            if (bool != null && bool.booleanValue()) {
                                xmlPullParser.setFeature(str, true);
                            }
                        }
                        return xmlPullParser;
                    } catch (Exception e) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append(cls.getName());
                        stringBuffer2.append(": ");
                        stringBuffer2.append(e.toString());
                        stringBuffer2.append("; ");
                        stringBuffer.append(stringBuffer2.toString());
                    }
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("could not create parser: ");
                stringBuffer3.append((Object) stringBuffer);
                throw new XmlPullParserException(stringBuffer3.toString());
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("No valid parser classes found in ");
            stringBuffer4.append(this.classNamesLocation);
            throw new XmlPullParserException(stringBuffer4.toString());
        }
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append("Factory initialization was incomplete - has not tried ");
        stringBuffer5.append(this.classNamesLocation);
        throw new XmlPullParserException(stringBuffer5.toString());
    }

    public XmlSerializer newSerializer() throws XmlPullParserException {
        Vector vector = this.serializerClasses;
        if (vector != null) {
            if (vector.size() != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < this.serializerClasses.size(); i++) {
                    Class cls = (Class) this.serializerClasses.elementAt(i);
                    try {
                        return (XmlSerializer) cls.newInstance();
                    } catch (Exception e) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append(cls.getName());
                        stringBuffer2.append(": ");
                        stringBuffer2.append(e.toString());
                        stringBuffer2.append("; ");
                        stringBuffer.append(stringBuffer2.toString());
                    }
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("could not create serializer: ");
                stringBuffer3.append((Object) stringBuffer);
                throw new XmlPullParserException(stringBuffer3.toString());
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("No valid serializer classes found in ");
            stringBuffer4.append(this.classNamesLocation);
            throw new XmlPullParserException(stringBuffer4.toString());
        }
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append("Factory initialization incomplete - has not tried ");
        stringBuffer5.append(this.classNamesLocation);
        throw new XmlPullParserException(stringBuffer5.toString());
    }

    public void setFeature(String str, boolean z) throws XmlPullParserException {
        this.features.put(str, new Boolean(z));
    }

    public void setNamespaceAware(boolean z) {
        this.features.put(XmlPullParser.FEATURE_PROCESS_NAMESPACES, new Boolean(z));
    }

    public void setValidating(boolean z) {
        this.features.put(XmlPullParser.FEATURE_VALIDATION, new Boolean(z));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static XmlPullParserFactory newInstance(String str, Class cls) throws XmlPullParserException {
        String stringBuffer;
        Class<?> cls2;
        Object obj;
        boolean z;
        if (cls == null) {
            cls = referenceContextClass;
        }
        if (str != null && str.length() != 0 && !"DEFAULT".equals(str)) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("parameter classNames to newInstance() that contained '");
            stringBuffer2.append(str);
            stringBuffer2.append("'");
            stringBuffer = stringBuffer2.toString();
        } else {
            try {
                InputStream resourceAsStream = cls.getResourceAsStream(RESOURCE_NAME);
                if (resourceAsStream != null) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    while (true) {
                        int read = resourceAsStream.read();
                        if (read < 0) {
                            break;
                        }
                        if (read > 32) {
                            stringBuffer3.append((char) read);
                        }
                    }
                    resourceAsStream.close();
                    str = stringBuffer3.toString();
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("resource /META-INF/services/org.xmlpull.v1.XmlPullParserFactory that contained '");
                    stringBuffer4.append(str);
                    stringBuffer4.append("'");
                    stringBuffer = stringBuffer4.toString();
                } else {
                    throw new XmlPullParserException("resource not found: /META-INF/services/org.xmlpull.v1.XmlPullParserFactory make sure that parser implementing XmlPull API is available");
                }
            } catch (Exception e) {
                throw new XmlPullParserException(null, null, e);
            }
        }
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        XmlPullParserFactory xmlPullParserFactory = null;
        int i = 0;
        while (i < str.length()) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            String substring = str.substring(i, indexOf);
            try {
                cls2 = Class.forName(substring);
            } catch (Exception unused) {
                cls2 = null;
            }
            try {
                obj = cls2.newInstance();
            } catch (Exception unused2) {
                obj = null;
                if (cls2 == null) {
                }
                i = indexOf + 1;
            }
            if (cls2 == null) {
                boolean z2 = true;
                if (obj instanceof XmlPullParser) {
                    vector.addElement(cls2);
                    z = true;
                } else {
                    z = false;
                }
                if (obj instanceof XmlSerializer) {
                    vector2.addElement(cls2);
                    z = true;
                }
                if (!(obj instanceof XmlPullParserFactory)) {
                    z2 = z;
                } else if (xmlPullParserFactory == null) {
                    xmlPullParserFactory = (XmlPullParserFactory) obj;
                }
                if (!z2) {
                    StringBuffer stringBuffer5 = new StringBuffer();
                    stringBuffer5.append("incompatible class: ");
                    stringBuffer5.append(substring);
                    throw new XmlPullParserException(stringBuffer5.toString());
                }
            }
            i = indexOf + 1;
        }
        if (xmlPullParserFactory == null) {
            xmlPullParserFactory = new XmlPullParserFactory();
        }
        xmlPullParserFactory.parserClasses = vector;
        xmlPullParserFactory.serializerClasses = vector2;
        xmlPullParserFactory.classNamesLocation = stringBuffer;
        return xmlPullParserFactory;
    }
}
