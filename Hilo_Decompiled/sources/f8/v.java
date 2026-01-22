package f8;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.google.android.material.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    int f١٤٢٥٨a;

    /* renamed from: b, reason: collision with root package name */
    private d f١٤٢٥٩b;

    /* renamed from: c, reason: collision with root package name */
    int[][] f١٤٢٦٠c = new int[10];

    /* renamed from: d, reason: collision with root package name */
    d[] f١٤٢٦١d = new d[10];

    private void a(int[] iArr, d dVar) {
        int i10 = this.f١٤٢٥٨a;
        if (i10 == 0 || iArr.length == 0) {
            this.f١٤٢٥٩b = dVar;
        }
        if (i10 >= this.f١٤٢٦٠c.length) {
            f(i10, i10 + 10);
        }
        int[][] iArr2 = this.f١٤٢٦٠c;
        int i11 = this.f١٤٢٥٨a;
        iArr2[i11] = iArr;
        this.f١٤٢٦١d[i11] = dVar;
        this.f١٤٢٥٨a = i11 + 1;
    }

    public static v b(Context context, TypedArray typedArray, int i10, d dVar) {
        int next;
        int resourceId = typedArray.getResourceId(i10, 0);
        if (resourceId == 0) {
            return c(o.m(typedArray, i10, dVar));
        }
        if (!context.getResources().getResourceTypeName(resourceId).equals("xml")) {
            return c(o.m(typedArray, i10, dVar));
        }
        try {
            XmlResourceParser xml = context.getResources().getXml(resourceId);
            try {
                v vVar = new v();
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next == 2) {
                    if (xml.getName().equals("selector")) {
                        vVar.i(context, xml, asAttributeSet, context.getTheme());
                    }
                    xml.close();
                    return vVar;
                }
                throw new XmlPullParserException("No start tag found");
            } catch (Throwable th) {
                if (xml != null) {
                    try {
                        xml.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
            return c(dVar);
        }
    }

    public static v c(d dVar) {
        v vVar = new v();
        vVar.a(StateSet.WILD_CARD, dVar);
        return vVar;
    }

    private void f(int i10, int i11) {
        int[][] iArr = new int[i11];
        System.arraycopy(this.f١٤٢٦٠c, 0, iArr, 0, i10);
        this.f١٤٢٦٠c = iArr;
        d[] dVarArr = new d[i11];
        System.arraycopy(this.f١٤٢٦١d, 0, dVarArr, 0, i10);
        this.f١٤٢٦١d = dVarArr;
    }

    private int g(int[] iArr) {
        int[][] iArr2 = this.f١٤٢٦٠c;
        for (int i10 = 0; i10 < this.f١٤٢٥٨a; i10++) {
            if (StateSet.stateSetMatches(iArr2[i10], iArr)) {
                return i10;
            }
        }
        return -1;
    }

    private void i(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainStyledAttributes;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 >= depth || next != 3) {
                    if (next == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                        Resources resources = context.getResources();
                        if (theme == null) {
                            obtainStyledAttributes = resources.obtainAttributes(attributeSet, R.styleable.ShapeAppearance);
                        } else {
                            obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.ShapeAppearance, 0, 0);
                        }
                        d m10 = o.m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSize, new a(DownloadProgress.UNKNOWN_PROGRESS));
                        obtainStyledAttributes.recycle();
                        int attributeCount = attributeSet.getAttributeCount();
                        int[] iArr = new int[attributeCount];
                        int i10 = 0;
                        for (int i11 = 0; i11 < attributeCount; i11++) {
                            int attributeNameResource = attributeSet.getAttributeNameResource(i11);
                            if (attributeNameResource != R.attr.cornerSize) {
                                int i12 = i10 + 1;
                                if (!attributeSet.getAttributeBooleanValue(i11, false)) {
                                    attributeNameResource = -attributeNameResource;
                                }
                                iArr[i10] = attributeNameResource;
                                i10 = i12;
                            }
                        }
                        a(StateSet.trimStateSet(iArr, i10), m10);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public d d(int[] iArr) {
        int g10 = g(iArr);
        if (g10 < 0) {
            g10 = g(StateSet.WILD_CARD);
        }
        if (g10 < 0) {
            return this.f١٤٢٥٩b;
        }
        return this.f١٤٢٦١d[g10];
    }

    public d e() {
        return this.f١٤٢٥٩b;
    }

    public boolean h() {
        if (this.f١٤٢٥٨a > 1) {
            return true;
        }
        return false;
    }
}
