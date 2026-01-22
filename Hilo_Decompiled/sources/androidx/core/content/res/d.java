package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final Shader f٢٧٤٩a;

    /* renamed from: b, reason: collision with root package name */
    private final ColorStateList f٢٧٥٠b;

    /* renamed from: c, reason: collision with root package name */
    private int f٢٧٥١c;

    private d(Shader shader, ColorStateList colorStateList, int i10) {
        this.f٢٧٤٩a = shader;
        this.f٢٧٥٠b = colorStateList;
        this.f٢٧٥١c = i10;
    }

    private static d a(Resources resources, int i10, Resources.Theme theme) {
        int next;
        XmlResourceParser xml = resources.getXml(i10);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            name.hashCode();
            if (!name.equals("gradient")) {
                if (name.equals("selector")) {
                    return c(c.b(resources, xml, asAttributeSet, theme));
                }
                throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
            }
            return d(f.b(resources, xml, asAttributeSet, theme));
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d b(int i10) {
        return new d(null, null, i10);
    }

    static d c(ColorStateList colorStateList) {
        return new d(null, colorStateList, colorStateList.getDefaultColor());
    }

    static d d(Shader shader) {
        return new d(shader, null, 0);
    }

    public static d g(Resources resources, int i10, Resources.Theme theme) {
        try {
            return a(resources, i10, theme);
        } catch (Exception e10) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e10);
            return null;
        }
    }

    public int e() {
        return this.f٢٧٥١c;
    }

    public Shader f() {
        return this.f٢٧٤٩a;
    }

    public boolean h() {
        if (this.f٢٧٤٩a != null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        ColorStateList colorStateList;
        if (this.f٢٧٤٩a == null && (colorStateList = this.f٢٧٥٠b) != null && colorStateList.isStateful()) {
            return true;
        }
        return false;
    }

    public boolean j(int[] iArr) {
        if (i()) {
            ColorStateList colorStateList = this.f٢٧٥٠b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f٢٧٥١c) {
                this.f٢٧٥١c = colorForState;
                return true;
            }
        }
        return false;
    }

    public void k(int i10) {
        this.f٢٧٥١c = i10;
    }

    public boolean l() {
        if (!h() && this.f٢٧٥١c == 0) {
            return false;
        }
        return true;
    }
}
