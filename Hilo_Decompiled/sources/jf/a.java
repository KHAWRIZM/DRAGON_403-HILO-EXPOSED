package jf;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.UtilityImpl;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Hashtable;
import org.android.agoo.message.MessageService;
import org.apache.commons.codec.CharEncoding;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class a implements XmlPullParser {
    private String C;
    private int E;
    private boolean F;
    private boolean G;
    private boolean H;
    private Object a;
    private String b;
    private Boolean c;
    private boolean d;
    private boolean e;
    private Hashtable f;
    private int g;
    private Reader k;
    private String l;
    private char[] m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int s;
    private int t;
    private boolean u;
    private String v;
    private String w;
    private String x;
    private boolean y;
    private int z;
    private String[] h = new String[16];
    private String[] i = new String[8];
    private int[] j = new int[4];
    private char[] r = new char[128];
    private String[] A = new String[16];
    private int B = 0;
    private int[] D = new int[2];

    public a() {
        this.m = new char[Runtime.getRuntime().freeMemory() >= 1048576 ? 8192 : 128];
    }

    private final boolean a() {
        int i;
        String str;
        int i2 = 0;
        boolean z = false;
        while (true) {
            i = this.z;
            if (i2 >= (i << 2)) {
                break;
            }
            String str2 = this.A[i2 + 2];
            int indexOf = str2.indexOf(58);
            if (indexOf != -1) {
                String substring = str2.substring(0, indexOf);
                str = str2.substring(indexOf + 1);
                str2 = substring;
            } else if (str2.equals("xmlns")) {
                str = null;
            } else {
                i2 += 4;
            }
            if (!str2.equals("xmlns")) {
                z = true;
            } else {
                int[] iArr = this.j;
                int i3 = this.g;
                int i4 = iArr[i3];
                iArr[i3] = i4 + 1;
                int i5 = i4 << 1;
                String[] b = b(this.i, i5 + 2);
                this.i = b;
                b[i5] = str;
                String[] strArr = this.A;
                int i6 = i2 + 3;
                b[i5 + 1] = strArr[i6];
                if (str != null && strArr[i6].equals("")) {
                    c("illegal empty namespace");
                }
                String[] strArr2 = this.A;
                int i7 = this.z - 1;
                this.z = i7;
                System.arraycopy(strArr2, i2 + 4, strArr2, i2, (i7 << 2) - i2);
                i2 -= 4;
            }
            i2 += 4;
        }
        if (z) {
            for (int i8 = (i << 2) - 4; i8 >= 0; i8 -= 4) {
                int i9 = i8 + 2;
                String str3 = this.A[i9];
                int indexOf2 = str3.indexOf(58);
                if (indexOf2 == 0 && !this.e) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("illegal attribute name: ");
                    stringBuffer.append(str3);
                    stringBuffer.append(" at ");
                    stringBuffer.append(this);
                    throw new RuntimeException(stringBuffer.toString());
                }
                if (indexOf2 != -1) {
                    String substring2 = str3.substring(0, indexOf2);
                    String substring3 = str3.substring(indexOf2 + 1);
                    String namespace = getNamespace(substring2);
                    if (namespace == null && !this.e) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("Undefined Prefix: ");
                        stringBuffer2.append(substring2);
                        stringBuffer2.append(" in ");
                        stringBuffer2.append(this);
                        throw new RuntimeException(stringBuffer2.toString());
                    }
                    String[] strArr3 = this.A;
                    strArr3[i8] = namespace;
                    strArr3[i8 + 1] = substring2;
                    strArr3[i9] = substring3;
                }
            }
        }
        int indexOf3 = this.x.indexOf(58);
        if (indexOf3 == 0) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("illegal tag name: ");
            stringBuffer3.append(this.x);
            c(stringBuffer3.toString());
        }
        if (indexOf3 != -1) {
            this.w = this.x.substring(0, indexOf3);
            this.x = this.x.substring(indexOf3 + 1);
        }
        String namespace2 = getNamespace(this.w);
        this.v = namespace2;
        if (namespace2 == null) {
            if (this.w != null) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("undefined prefix: ");
                stringBuffer4.append(this.w);
                c(stringBuffer4.toString());
            }
            this.v = "";
        }
        return z;
    }

    private final String[] b(String[] strArr, int i) {
        if (strArr.length >= i) {
            return strArr;
        }
        String[] strArr2 = new String[i + 16];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }

    private final void c(String str) {
        if (this.e) {
            if (this.C == null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("ERR: ");
                stringBuffer.append(str);
                this.C = stringBuffer.toString();
                return;
            }
            return;
        }
        d(str);
    }

    private final void d(String str) {
        if (str.length() >= 100) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.substring(0, 100));
            stringBuffer.append("\n");
            str = stringBuffer.toString();
        }
        throw new XmlPullParserException(str, this, null);
    }

    private final String e(int i) {
        return new String(this.r, i, this.s - i);
    }

    private final boolean f(String str, boolean z, String str2) {
        int i;
        if (!str.startsWith("http://xmlpull.org/v1/doc/")) {
            return false;
        }
        if (z) {
            i = 42;
        } else {
            i = 40;
        }
        return str.substring(i).equals(str2);
    }

    private final void g() {
        int j;
        if (this.k == null) {
            d("No Input specified");
        }
        if (this.t == 3) {
            this.g--;
        }
        do {
            this.z = -1;
            if (this.y) {
                this.y = false;
                this.t = 3;
                return;
            }
            if (this.C != null) {
                for (int i = 0; i < this.C.length(); i++) {
                    n(this.C.charAt(i));
                }
                this.C = null;
                this.t = 9;
                return;
            }
            if (this.e && (this.B > 0 || (l(0) == -1 && this.g > 0))) {
                int i2 = (this.g - 1) << 2;
                this.t = 3;
                String[] strArr = this.h;
                this.v = strArr[i2];
                this.w = strArr[i2 + 1];
                this.x = strArr[i2 + 2];
                if (this.B != 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("missing end tag /");
                    stringBuffer.append(this.x);
                    stringBuffer.append(" inserted");
                    this.C = stringBuffer.toString();
                }
                int i3 = this.B;
                if (i3 > 0) {
                    this.B = i3 - 1;
                    return;
                }
                return;
            }
            this.w = null;
            this.x = null;
            this.v = null;
            int m = m();
            this.t = m;
            if (m != 1) {
                if (m != 2) {
                    if (m != 3) {
                        if (m != 4) {
                            if (m != 6) {
                                j = j(this.H);
                                this.t = j;
                            } else {
                                o();
                                return;
                            }
                        } else {
                            p(60, !this.H);
                            if (this.g == 0 && this.u) {
                                this.t = 7;
                                return;
                            }
                            return;
                        }
                    } else {
                        i();
                        return;
                    }
                } else {
                    k(false);
                    return;
                }
            } else {
                return;
            }
        } while (j == 998);
    }

    private final void h(boolean z) {
        int i = 1;
        boolean z2 = false;
        while (true) {
            int q = q();
            if (q != -1) {
                if (q != 39) {
                    if (q != 60) {
                        if (q == 62 && !z2 && i - 1 == 0) {
                            return;
                        }
                    } else if (!z2) {
                        i++;
                    }
                } else {
                    z2 = !z2;
                }
                if (z) {
                    n(q);
                }
            } else {
                c("Unexpected EOF");
                return;
            }
        }
    }

    private final void i() {
        q();
        q();
        this.x = s();
        t();
        r('>');
        int i = this.g;
        int i2 = (i - 1) << 2;
        if (i == 0) {
            c("element stack empty");
            this.t = 9;
            return;
        }
        int i3 = i2 + 3;
        if (!this.x.equals(this.h[i3])) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("expected: /");
            stringBuffer.append(this.h[i3]);
            stringBuffer.append(" read: ");
            stringBuffer.append(this.x);
            c(stringBuffer.toString());
            int i4 = i2;
            while (i4 >= 0 && !this.x.toLowerCase().equals(this.h[i4 + 3].toLowerCase())) {
                this.B++;
                i4 -= 4;
            }
            if (i4 < 0) {
                this.B = 0;
                this.t = 9;
                return;
            }
        }
        String[] strArr = this.h;
        this.v = strArr[i2];
        this.w = strArr[i2 + 1];
        this.x = strArr[i2 + 2];
    }

    private final int j(boolean z) {
        String stringBuffer;
        String str;
        int i;
        int i2;
        Boolean bool;
        q();
        int q = q();
        if (q == 63) {
            if ((l(0) == 120 || l(0) == 88) && (l(1) == 109 || l(1) == 77)) {
                if (z) {
                    n(l(0));
                    n(l(1));
                }
                q();
                q();
                if ((l(0) == 108 || l(0) == 76) && l(1) <= 32) {
                    if (this.p != 1 || this.q > 4) {
                        c("PI must not start with xml");
                    }
                    k(true);
                    int i3 = 2;
                    if (this.z < 1 || !Constants.SP_KEY_VERSION.equals(this.A[2])) {
                        c("version expected");
                    }
                    String[] strArr = this.A;
                    this.b = strArr[3];
                    if (1 < this.z && "encoding".equals(strArr[6])) {
                        this.l = this.A[7];
                    } else {
                        i3 = 1;
                    }
                    if (i3 < this.z) {
                        int i4 = i3 * 4;
                        if ("standalone".equals(this.A[i4 + 2])) {
                            String str2 = this.A[i4 + 3];
                            if ("yes".equals(str2)) {
                                bool = new Boolean(true);
                            } else if ("no".equals(str2)) {
                                bool = new Boolean(false);
                            } else {
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append("illegal standalone value: ");
                                stringBuffer2.append(str2);
                                c(stringBuffer2.toString());
                                i3++;
                            }
                            this.c = bool;
                            i3++;
                        }
                    }
                    if (i3 != this.z) {
                        c("illegal xmldecl");
                    }
                    this.u = true;
                    this.s = 0;
                    return 998;
                }
            }
            str = "";
            i = 63;
            i2 = 8;
        } else if (q == 33) {
            if (l(0) == 45) {
                str = "--";
                i = 45;
                i2 = 9;
            } else if (l(0) == 91) {
                str = "[CDATA[";
                z = true;
                i = 93;
                i2 = 5;
            } else {
                str = "DOCTYPE";
                i = -1;
                i2 = 10;
            }
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("illegal: <");
            stringBuffer3.append(q);
            stringBuffer = stringBuffer3.toString();
            c(stringBuffer);
            return 9;
        }
        for (int i5 = 0; i5 < str.length(); i5++) {
            r(str.charAt(i5));
        }
        if (i2 == 10) {
            h(z);
        } else {
            int i6 = 0;
            while (true) {
                int q2 = q();
                if (q2 == -1) {
                    stringBuffer = "Unexpected EOF";
                    break;
                }
                if (z) {
                    n(q2);
                }
                if ((i == 63 || q2 == i) && l(0) == i && l(1) == 62) {
                    if (i == 45 && i6 == 45) {
                        c("illegal comment delimiter: --->");
                    }
                    q();
                    q();
                    if (z && i != 63) {
                        this.s--;
                    }
                } else {
                    i6 = q2;
                }
            }
            c(stringBuffer);
            return 9;
        }
        return i2;
    }

    private final void k(boolean z) {
        if (!z) {
            q();
        }
        this.x = s();
        this.z = 0;
        while (true) {
            t();
            int l = l(0);
            if (z) {
                if (l == 63) {
                    q();
                    r('>');
                    return;
                }
            } else {
                if (l == 47) {
                    this.y = true;
                    q();
                    t();
                    r('>');
                    break;
                }
                if (l == 62 && !z) {
                    q();
                    break;
                }
            }
            if (l == -1) {
                c("Unexpected EOF");
                return;
            }
            String s = s();
            if (s.length() == 0) {
                c("attr name expected");
                break;
            }
            int i = this.z;
            this.z = i + 1;
            int i2 = i << 2;
            String[] b = b(this.A, i2 + 4);
            this.A = b;
            b[i2] = "";
            int i3 = i2 + 2;
            b[i2 + 1] = null;
            int i4 = i2 + 3;
            b[i3] = s;
            t();
            if (l(0) != 61) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Attr.value missing f. ");
                stringBuffer.append(s);
                c(stringBuffer.toString());
                this.A[i4] = MessageService.MSG_DB_NOTIFY_REACHED;
            } else {
                r('=');
                t();
                int l2 = l(0);
                if (l2 != 39 && l2 != 34) {
                    c("attr value delimiter missing!");
                    l2 = 32;
                } else {
                    q();
                }
                int i5 = this.s;
                p(l2, true);
                this.A[i4] = e(i5);
                this.s = i5;
                if (l2 != 32) {
                    q();
                }
            }
        }
        int i6 = this.g;
        this.g = i6 + 1;
        int i7 = i6 << 2;
        String[] b2 = b(this.h, i7 + 4);
        this.h = b2;
        b2[i7 + 3] = this.x;
        int i8 = this.g;
        int[] iArr = this.j;
        if (i8 >= iArr.length) {
            int[] iArr2 = new int[i8 + 4];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.j = iArr2;
        }
        int[] iArr3 = this.j;
        int i9 = this.g;
        iArr3[i9] = iArr3[i9 - 1];
        if (this.d) {
            a();
        } else {
            this.v = "";
        }
        String[] strArr = this.h;
        strArr[i7] = this.v;
        strArr[i7 + 1] = this.w;
        strArr[i7 + 2] = this.x;
    }

    private final int l(int i) {
        int i2;
        int i3;
        while (i >= this.E) {
            char[] cArr = this.m;
            if (cArr.length <= 1) {
                i3 = this.k.read();
            } else {
                int i4 = this.n;
                if (i4 < this.o) {
                    this.n = i4 + 1;
                    i3 = cArr[i4];
                } else {
                    int read = this.k.read(cArr, 0, cArr.length);
                    this.o = read;
                    if (read <= 0) {
                        i2 = -1;
                    } else {
                        i2 = this.m[0];
                    }
                    this.n = 1;
                    i3 = i2;
                }
            }
            if (i3 == 13) {
                this.F = true;
                int[] iArr = this.D;
                int i5 = this.E;
                this.E = i5 + 1;
                iArr[i5] = 10;
            } else {
                if (i3 == 10) {
                    if (!this.F) {
                        int[] iArr2 = this.D;
                        int i6 = this.E;
                        this.E = i6 + 1;
                        iArr2[i6] = 10;
                    }
                } else {
                    int[] iArr3 = this.D;
                    int i7 = this.E;
                    this.E = i7 + 1;
                    iArr3[i7] = i3;
                }
                this.F = false;
            }
        }
        return this.D[i];
    }

    private final int m() {
        int l = l(0);
        if (l == -1) {
            return 1;
        }
        if (l != 38) {
            if (l != 60) {
                return 4;
            }
            int l2 = l(1);
            if (l2 != 33) {
                if (l2 != 47) {
                    if (l2 != 63) {
                        return 2;
                    }
                    return 999;
                }
                return 3;
            }
            return 999;
        }
        return 6;
    }

    private final void n(int i) {
        boolean z;
        boolean z2 = this.u;
        if (i <= 32) {
            z = true;
        } else {
            z = false;
        }
        this.u = z2 & z;
        int i2 = this.s;
        char[] cArr = this.r;
        if (i2 == cArr.length) {
            char[] cArr2 = new char[((i2 * 4) / 3) + 4];
            System.arraycopy(cArr, 0, cArr2, 0, i2);
            this.r = cArr2;
        }
        char[] cArr3 = this.r;
        int i3 = this.s;
        this.s = i3 + 1;
        cArr3[i3] = (char) i;
    }

    private final void o() {
        int parseInt;
        n(q());
        int i = this.s;
        while (true) {
            int q = q();
            if (q == 59) {
                String e = e(i);
                boolean z = true;
                this.s = i - 1;
                if (this.H && this.t == 6) {
                    this.x = e;
                }
                if (e.charAt(0) == '#') {
                    if (e.charAt(1) == 'x') {
                        parseInt = Integer.parseInt(e.substring(2), 16);
                    } else {
                        parseInt = Integer.parseInt(e.substring(1));
                    }
                    n(parseInt);
                    return;
                }
                String str = (String) this.f.get(e);
                if (str != null) {
                    z = false;
                }
                this.G = z;
                if (z) {
                    if (!this.H) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("unresolved: &");
                        stringBuffer.append(e);
                        stringBuffer.append(";");
                        c(stringBuffer.toString());
                        return;
                    }
                    return;
                }
                for (int i2 = 0; i2 < str.length(); i2++) {
                    n(str.charAt(i2));
                }
                return;
            }
            if (q < 128 && ((q < 48 || q > 57) && ((q < 97 || q > 122) && ((q < 65 || q > 90) && q != 95 && q != 45 && q != 35)))) {
                if (!this.e) {
                    c("unterminated entity ref");
                }
                if (q != -1) {
                    n(q);
                    return;
                }
                return;
            }
            n(q);
        }
    }

    private final void p(int i, boolean z) {
        int l = l(0);
        int i2 = 0;
        while (l != -1 && l != i) {
            int i3 = 32;
            if (i != 32 || (l > 32 && l != 62)) {
                if (l == 38) {
                    if (z) {
                        o();
                    } else {
                        return;
                    }
                } else {
                    if (l == 10 && this.t == 2) {
                        q();
                    } else {
                        i3 = q();
                    }
                    n(i3);
                }
                if (l == 62 && i2 >= 2 && i != 93) {
                    c("Illegal: ]]>");
                }
                if (l == 93) {
                    i2++;
                } else {
                    i2 = 0;
                }
                l = l(0);
            } else {
                return;
            }
        }
    }

    private final int q() {
        int i;
        if (this.E == 0) {
            i = l(0);
        } else {
            int[] iArr = this.D;
            int i2 = iArr[0];
            iArr[0] = iArr[1];
            i = i2;
        }
        this.E--;
        this.q++;
        if (i == 10) {
            this.p++;
            this.q = 1;
        }
        return i;
    }

    private final void r(char c) {
        int q = q();
        if (q != c) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("expected: '");
            stringBuffer.append(c);
            stringBuffer.append("' actual: '");
            stringBuffer.append((char) q);
            stringBuffer.append("'");
            c(stringBuffer.toString());
        }
    }

    private final String s() {
        int i = this.s;
        int l = l(0);
        if ((l < 97 || l > 122) && ((l < 65 || l > 90) && l != 95 && l != 58 && l < 192 && !this.e)) {
            c("name expected");
        }
        while (true) {
            n(q());
            int l2 = l(0);
            if (l2 < 97 || l2 > 122) {
                if (l2 < 65 || l2 > 90) {
                    if (l2 < 48 || l2 > 57) {
                        if (l2 != 95 && l2 != 45 && l2 != 58 && l2 != 46 && l2 < 183) {
                            String e = e(i);
                            this.s = i;
                            return e;
                        }
                    }
                }
            }
        }
    }

    private final void t() {
        while (true) {
            int l = l(0);
            if (l <= 32 && l != -1) {
                q();
            } else {
                return;
            }
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void defineEntityReplacementText(String str, String str2) {
        Hashtable hashtable = this.f;
        if (hashtable != null) {
            hashtable.put(str, str2);
            return;
        }
        throw new RuntimeException("entity replacement text must be defined after setInput!");
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getAttributeCount() {
        return this.z;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeName(int i) {
        if (i < this.z) {
            return this.A[(i << 2) + 2];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeNamespace(int i) {
        if (i < this.z) {
            return this.A[i << 2];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributePrefix(int i) {
        if (i < this.z) {
            return this.A[(i << 2) + 1];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeType(int i) {
        return "CDATA";
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeValue(int i) {
        if (i < this.z) {
            return this.A[(i << 2) + 3];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getColumnNumber() {
        return this.q;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getDepth() {
        return this.g;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getEventType() {
        return this.t;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean getFeature(String str) {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            return this.d;
        }
        if (!f(str, false, "relaxed")) {
            return false;
        }
        return this.e;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getInputEncoding() {
        return this.l;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getLineNumber() {
        return this.p;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getName() {
        return this.x;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace() {
        return this.v;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getNamespaceCount(int i) {
        if (i <= this.g) {
            return this.j[i];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespacePrefix(int i) {
        return this.i[i << 1];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespaceUri(int i) {
        return this.i[(i << 1) + 1];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getPositionDescription() {
        String str;
        String text;
        int i = this.t;
        String[] strArr = XmlPullParser.TYPES;
        if (i < strArr.length) {
            str = strArr[i];
        } else {
            str = UtilityImpl.NET_TYPE_UNKNOWN;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(' ');
        int i2 = this.t;
        if (i2 != 2 && i2 != 3) {
            if (i2 != 7) {
                if (i2 != 4) {
                    text = getText();
                } else if (this.u) {
                    text = "(whitespace)";
                } else {
                    text = getText();
                    if (text.length() > 16) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append(text.substring(0, 16));
                        stringBuffer2.append("...");
                        text = stringBuffer2.toString();
                    }
                }
                stringBuffer.append(text);
            }
        } else {
            if (this.y) {
                stringBuffer.append("(empty) ");
            }
            stringBuffer.append('<');
            if (this.t == 3) {
                stringBuffer.append('/');
            }
            if (this.w != null) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("{");
                stringBuffer3.append(this.v);
                stringBuffer3.append("}");
                stringBuffer3.append(this.w);
                stringBuffer3.append(":");
                stringBuffer.append(stringBuffer3.toString());
            }
            stringBuffer.append(this.x);
            int i3 = this.z << 2;
            for (int i4 = 0; i4 < i3; i4 += 4) {
                stringBuffer.append(' ');
                int i5 = i4 + 1;
                if (this.A[i5] != null) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("{");
                    stringBuffer4.append(this.A[i4]);
                    stringBuffer4.append("}");
                    stringBuffer4.append(this.A[i5]);
                    stringBuffer4.append(":");
                    stringBuffer.append(stringBuffer4.toString());
                }
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append(this.A[i4 + 2]);
                stringBuffer5.append("='");
                stringBuffer5.append(this.A[i4 + 3]);
                stringBuffer5.append("'");
                stringBuffer.append(stringBuffer5.toString());
            }
            stringBuffer.append('>');
        }
        StringBuffer stringBuffer6 = new StringBuffer();
        stringBuffer6.append("@");
        stringBuffer6.append(this.p);
        stringBuffer6.append(":");
        stringBuffer6.append(this.q);
        stringBuffer.append(stringBuffer6.toString());
        if (this.a != null) {
            stringBuffer.append(" in ");
            stringBuffer.append(this.a);
        } else if (this.k != null) {
            stringBuffer.append(" in ");
            stringBuffer.append(this.k.toString());
        }
        return stringBuffer.toString();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getPrefix() {
        return this.w;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public Object getProperty(String str) {
        if (f(str, true, "xmldecl-version")) {
            return this.b;
        }
        if (f(str, true, "xmldecl-standalone")) {
            return this.c;
        }
        if (f(str, true, "location")) {
            Object obj = this.a;
            if (obj == null) {
                return this.k.toString();
            }
            return obj;
        }
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getText() {
        int i = this.t;
        if (i >= 4 && (i != 6 || !this.G)) {
            return e(0);
        }
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public char[] getTextCharacters(int[] iArr) {
        int i = this.t;
        if (i >= 4) {
            if (i == 6) {
                iArr[0] = 0;
                iArr[1] = this.x.length();
                return this.x.toCharArray();
            }
            iArr[0] = 0;
            iArr[1] = this.s;
            return this.r;
        }
        iArr[0] = -1;
        iArr[1] = -1;
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isAttributeDefault(int i) {
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isEmptyElementTag() {
        if (this.t != 2) {
            d("Wrong event type");
        }
        return this.y;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isWhitespace() {
        int i = this.t;
        if (i != 4 && i != 7 && i != 5) {
            d("Wrong event type");
        }
        return this.u;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int next() {
        this.s = 0;
        this.u = true;
        this.H = false;
        int i = 9999;
        while (true) {
            g();
            int i2 = this.t;
            if (i2 < i) {
                i = i2;
            }
            if (i > 6 || (i >= 4 && m() >= 4)) {
            }
        }
        this.t = i;
        if (i > 4) {
            this.t = 4;
        }
        return this.t;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int nextTag() {
        next();
        if (this.t == 4 && this.u) {
            next();
        }
        int i = this.t;
        if (i != 3 && i != 2) {
            d("unexpected type");
        }
        return this.t;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String nextText() {
        String str;
        if (this.t != 2) {
            d("precondition: START_TAG");
        }
        next();
        if (this.t == 4) {
            str = getText();
            next();
        } else {
            str = "";
        }
        if (this.t != 3) {
            d("END_TAG expected");
        }
        return str;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int nextToken() {
        this.u = true;
        this.s = 0;
        this.H = true;
        g();
        return this.t;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void require(int i, String str, String str2) {
        if (i != this.t || ((str != null && !str.equals(getNamespace())) || (str2 != null && !str2.equals(getName())))) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("expected: ");
            stringBuffer.append(XmlPullParser.TYPES[i]);
            stringBuffer.append(" {");
            stringBuffer.append(str);
            stringBuffer.append("}");
            stringBuffer.append(str2);
            d(stringBuffer.toString());
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setFeature(String str, boolean z) {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            this.d = z;
            return;
        }
        if (f(str, false, "relaxed")) {
            this.e = z;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("unsupported feature: ");
        stringBuffer.append(str);
        d(stringBuffer.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008f A[Catch: Exception -> 0x0028, TryCatch #0 {Exception -> 0x0028, blocks: (B:7:0x000c, B:9:0x0012, B:11:0x0019, B:14:0x002b, B:18:0x0041, B:20:0x0048, B:23:0x0057, B:25:0x0064, B:27:0x006c, B:29:0x0074, B:31:0x0077, B:32:0x0087, B:34:0x008f, B:38:0x00f0, B:45:0x00a3, B:47:0x00b3, B:49:0x00ba, B:54:0x00c4, B:55:0x00cd, B:57:0x00d5, B:58:0x00de, B:59:0x00e1, B:60:0x00e8), top: B:6:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009f  */
    @Override // org.xmlpull.v1.XmlPullParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setInput(InputStream inputStream, String str) {
        String str2;
        int i;
        int read;
        this.n = 0;
        this.o = 0;
        if (inputStream == null) {
            throw new IllegalArgumentException();
        }
        String str3 = "UTF-8";
        if (str == null) {
            int i2 = 0;
            while (this.o < 4 && (read = inputStream.read()) != -1) {
                try {
                    i2 = (i2 << 8) | read;
                    char[] cArr = this.m;
                    int i3 = this.o;
                    this.o = i3 + 1;
                    cArr[i3] = (char) read;
                } catch (Exception e) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Invalid stream or encoding: ");
                    stringBuffer.append(e.toString());
                    throw new XmlPullParserException(stringBuffer.toString(), this, e);
                }
            }
            if (this.o == 4) {
                str2 = "UTF-32BE";
                switch (i2) {
                    case -131072:
                        this.o = 0;
                        str2 = "UTF-32LE";
                        break;
                    case 60:
                        this.m[0] = '<';
                        this.o = 1;
                        break;
                    case 65279:
                        this.o = 0;
                        break;
                    case 3932223:
                        char[] cArr2 = this.m;
                        cArr2[0] = '<';
                        cArr2[1] = '?';
                        this.o = 2;
                        str2 = CharEncoding.UTF_16BE;
                        break;
                    case 1006632960:
                        this.m[0] = '<';
                        this.o = 1;
                        str2 = "UTF-32LE";
                        break;
                    case 1006649088:
                        char[] cArr3 = this.m;
                        cArr3[0] = '<';
                        cArr3[1] = '?';
                        this.o = 2;
                        str2 = CharEncoding.UTF_16LE;
                        break;
                    case 1010792557:
                        while (true) {
                            int read2 = inputStream.read();
                            if (read2 != -1) {
                                char[] cArr4 = this.m;
                                int i4 = this.o;
                                int i5 = i4 + 1;
                                this.o = i5;
                                cArr4[i4] = (char) read2;
                                if (read2 == 62) {
                                    String str4 = new String(cArr4, 0, i5);
                                    int indexOf = str4.indexOf("encoding");
                                    if (indexOf != -1) {
                                        while (str4.charAt(indexOf) != '\"' && str4.charAt(indexOf) != '\'') {
                                            indexOf++;
                                        }
                                        int i6 = indexOf + 1;
                                        str2 = str4.substring(i6, str4.indexOf(str4.charAt(indexOf), i6));
                                    }
                                }
                            }
                        }
                        str2 = str;
                        i = (-65536) & i2;
                        if (i == -16842752) {
                            if (i != -131072) {
                                if ((i2 & (-256)) == -272908544) {
                                    char[] cArr5 = this.m;
                                    cArr5[0] = cArr5[3];
                                    this.o = 1;
                                    str2 = "UTF-8";
                                    break;
                                }
                            } else {
                                char[] cArr6 = this.m;
                                cArr6[0] = (char) ((cArr6[3] << '\b') | cArr6[2]);
                                this.o = 1;
                                str2 = CharEncoding.UTF_16LE;
                                break;
                            }
                        } else {
                            char[] cArr7 = this.m;
                            cArr7[0] = (char) ((cArr7[2] << '\b') | cArr7[3]);
                            this.o = 1;
                            str2 = CharEncoding.UTF_16BE;
                            break;
                        }
                        break;
                    default:
                        str2 = str;
                        i = (-65536) & i2;
                        if (i == -16842752) {
                        }
                        break;
                }
                if (str2 == null) {
                    str3 = str2;
                }
                int i7 = this.o;
                setInput(new InputStreamReader(inputStream, str3));
                this.l = str;
                this.o = i7;
            }
        }
        str2 = str;
        if (str2 == null) {
        }
        int i72 = this.o;
        setInput(new InputStreamReader(inputStream, str3));
        this.l = str;
        this.o = i72;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setProperty(String str, Object obj) {
        if (f(str, true, "location")) {
            this.a = obj;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("unsupported property: ");
        stringBuffer.append(str);
        throw new XmlPullParserException(stringBuffer.toString());
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeValue(String str, String str2) {
        for (int i = (this.z << 2) - 4; i >= 0; i -= 4) {
            if (this.A[i + 2].equals(str2) && (str == null || this.A[i].equals(str))) {
                return this.A[i + 3];
            }
        }
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace(String str) {
        if ("xml".equals(str)) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        if ("xmlns".equals(str)) {
            return "http://www.w3.org/2000/xmlns/";
        }
        for (int namespaceCount = (getNamespaceCount(this.g) << 1) - 2; namespaceCount >= 0; namespaceCount -= 2) {
            String[] strArr = this.i;
            if (str == null) {
                if (strArr[namespaceCount] == null) {
                    return strArr[namespaceCount + 1];
                }
            } else if (str.equals(strArr[namespaceCount])) {
                return this.i[namespaceCount + 1];
            }
        }
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(Reader reader) {
        this.k = reader;
        this.p = 1;
        this.q = 0;
        this.t = 0;
        this.x = null;
        this.v = null;
        this.y = false;
        this.z = -1;
        this.l = null;
        this.b = null;
        this.c = null;
        if (reader == null) {
            return;
        }
        this.n = 0;
        this.o = 0;
        this.E = 0;
        this.g = 0;
        Hashtable hashtable = new Hashtable();
        this.f = hashtable;
        hashtable.put("amp", "&");
        this.f.put("apos", "'");
        this.f.put("gt", ">");
        this.f.put("lt", "<");
        this.f.put("quot", "\"");
    }
}
