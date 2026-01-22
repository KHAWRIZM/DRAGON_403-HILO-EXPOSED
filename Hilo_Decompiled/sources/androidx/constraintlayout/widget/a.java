package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.KotlinVersion;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f٢٣٧١a;

    /* renamed from: b, reason: collision with root package name */
    String f٢٣٧٢b;

    /* renamed from: c, reason: collision with root package name */
    private b f٢٣٧٣c;

    /* renamed from: d, reason: collision with root package name */
    private int f٢٣٧٤d;

    /* renamed from: e, reason: collision with root package name */
    private float f٢٣٧٥e;

    /* renamed from: f, reason: collision with root package name */
    private String f٢٣٧٦f;

    /* renamed from: g, reason: collision with root package name */
    boolean f٢٣٧٧g;

    /* renamed from: h, reason: collision with root package name */
    private int f٢٣٧٨h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.widget.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static /* synthetic */ class C٠٠١٦a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f٢٣٧٩a;

        static {
            int[] iArr = new int[b.values().length];
            f٢٣٧٩a = iArr;
            try {
                iArr[b.REFERENCE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f٢٣٧٩a[b.BOOLEAN_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f٢٣٧٩a[b.STRING_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f٢٣٧٩a[b.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f٢٣٧٩a[b.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f٢٣٧٩a[b.INT_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f٢٣٧٩a[b.FLOAT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f٢٣٧٩a[b.DIMENSION_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum b {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public a(String str, b bVar, Object obj, boolean z10) {
        this.f٢٣٧٢b = str;
        this.f٢٣٧٣c = bVar;
        this.f٢٣٧١a = z10;
        j(obj);
    }

    public static HashMap a(HashMap hashMap, View view) {
        HashMap hashMap2 = new HashMap();
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            a aVar = (a) hashMap.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    hashMap2.put(str, new a(aVar, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    hashMap2.put(str, new a(aVar, cls.getMethod("getMap" + str, null).invoke(view, null)));
                }
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (NoSuchMethodException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void h(Context context, XmlPullParser xmlPullParser, HashMap hashMap) {
        b bVar;
        Object valueOf;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        b bVar2 = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == R.styleable.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == R.styleable.CustomAttribute_methodName) {
                str = obtainStyledAttributes.getString(index);
                z10 = true;
            } else if (index == R.styleable.CustomAttribute_customBoolean) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                bVar2 = b.BOOLEAN_TYPE;
            } else {
                if (index == R.styleable.CustomAttribute_customColorValue) {
                    bVar = b.COLOR_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customColorDrawableValue) {
                    bVar = b.COLOR_DRAWABLE_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customPixelDimension) {
                    bVar = b.DIMENSION_TYPE;
                    valueOf = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, DownloadProgress.UNKNOWN_PROGRESS), context.getResources().getDisplayMetrics()));
                } else if (index == R.styleable.CustomAttribute_customDimension) {
                    bVar = b.DIMENSION_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getDimension(index, DownloadProgress.UNKNOWN_PROGRESS));
                } else if (index == R.styleable.CustomAttribute_customFloatValue) {
                    bVar = b.FLOAT_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == R.styleable.CustomAttribute_customIntegerValue) {
                    bVar = b.INT_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == R.styleable.CustomAttribute_customStringValue) {
                    bVar = b.STRING_TYPE;
                    valueOf = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.CustomAttribute_customReference) {
                    bVar = b.REFERENCE_TYPE;
                    int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = obtainStyledAttributes.getInt(index, -1);
                    }
                    valueOf = Integer.valueOf(resourceId);
                }
                Object obj2 = valueOf;
                bVar2 = bVar;
                obj = obj2;
            }
        }
        if (str != null && obj != null) {
            hashMap.put(str, new a(str, bVar2, obj, z10));
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0047. Please report as an issue. */
    public static void i(View view, HashMap hashMap) {
        String str;
        Class<?> cls = view.getClass();
        for (String str2 : hashMap.keySet()) {
            a aVar = (a) hashMap.get(str2);
            if (!aVar.f٢٣٧١a) {
                str = "set" + str2;
            } else {
                str = str2;
            }
            try {
                switch (C٠٠١٦a.f٢٣٧٩a[aVar.f٢٣٧٣c.ordinal()]) {
                    case 1:
                        cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f٢٣٧٤d));
                        break;
                    case 2:
                        cls.getMethod(str, Boolean.TYPE).invoke(view, Boolean.valueOf(aVar.f٢٣٧٧g));
                        break;
                    case 3:
                        cls.getMethod(str, CharSequence.class).invoke(view, aVar.f٢٣٧٦f);
                        break;
                    case 4:
                        cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f٢٣٧٨h));
                        break;
                    case 5:
                        Method method = cls.getMethod(str, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(aVar.f٢٣٧٨h);
                        method.invoke(view, colorDrawable);
                        break;
                    case 6:
                        cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f٢٣٧٤d));
                        break;
                    case 7:
                        cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(aVar.f٢٣٧٥e));
                        break;
                    case 8:
                        cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(aVar.f٢٣٧٥e));
                        break;
                }
            } catch (IllegalAccessException e10) {
                Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                e10.printStackTrace();
            } catch (NoSuchMethodException e11) {
                Log.e("TransitionLayout", e11.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                StringBuilder sb = new StringBuilder();
                sb.append(cls.getName());
                sb.append(" must have a method ");
                sb.append(str);
                Log.e("TransitionLayout", sb.toString());
            } catch (InvocationTargetException e12) {
                Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                e12.printStackTrace();
            }
        }
    }

    public String b() {
        return this.f٢٣٧٢b;
    }

    public b c() {
        return this.f٢٣٧٣c;
    }

    public float d() {
        switch (C٠٠١٦a.f٢٣٧٩a[this.f٢٣٧٣c.ordinal()]) {
            case 2:
                if (this.f٢٣٧٧g) {
                    return 1.0f;
                }
                return DownloadProgress.UNKNOWN_PROGRESS;
            case 3:
                throw new RuntimeException("Cannot interpolate String");
            case 4:
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                return this.f٢٣٧٤d;
            case 7:
                return this.f٢٣٧٥e;
            case 8:
                return this.f٢٣٧٥e;
            default:
                return Float.NaN;
        }
    }

    public void e(float[] fArr) {
        float f10;
        switch (C٠٠١٦a.f٢٣٧٩a[this.f٢٣٧٣c.ordinal()]) {
            case 2:
                if (this.f٢٣٧٧g) {
                    f10 = 1.0f;
                } else {
                    f10 = DownloadProgress.UNKNOWN_PROGRESS;
                }
                fArr[0] = f10;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i10 = this.f٢٣٧٨h;
                int i11 = (i10 >> 24) & KotlinVersion.MAX_COMPONENT_VALUE;
                int i12 = (i10 >> 16) & KotlinVersion.MAX_COMPONENT_VALUE;
                int i13 = (i10 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE;
                int i14 = i10 & KotlinVersion.MAX_COMPONENT_VALUE;
                float pow = (float) Math.pow(i12 / 255.0f, 2.2d);
                float pow2 = (float) Math.pow(i13 / 255.0f, 2.2d);
                float pow3 = (float) Math.pow(i14 / 255.0f, 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = pow3;
                fArr[3] = i11 / 255.0f;
                return;
            case 6:
                fArr[0] = this.f٢٣٧٤d;
                return;
            case 7:
                fArr[0] = this.f٢٣٧٥e;
                return;
            case 8:
                fArr[0] = this.f٢٣٧٥e;
                return;
            default:
                return;
        }
    }

    public boolean f() {
        int i10 = C٠٠١٦a.f٢٣٧٩a[this.f٢٣٧٣c.ordinal()];
        if (i10 != 1 && i10 != 2 && i10 != 3) {
            return true;
        }
        return false;
    }

    public int g() {
        int i10 = C٠٠١٦a.f٢٣٧٩a[this.f٢٣٧٣c.ordinal()];
        if (i10 == 4 || i10 == 5) {
            return 4;
        }
        return 1;
    }

    public void j(Object obj) {
        switch (C٠٠١٦a.f٢٣٧٩a[this.f٢٣٧٣c.ordinal()]) {
            case 1:
            case 6:
                this.f٢٣٧٤d = ((Integer) obj).intValue();
                return;
            case 2:
                this.f٢٣٧٧g = ((Boolean) obj).booleanValue();
                return;
            case 3:
                this.f٢٣٧٦f = (String) obj;
                return;
            case 4:
            case 5:
                this.f٢٣٧٨h = ((Integer) obj).intValue();
                return;
            case 7:
                this.f٢٣٧٥e = ((Float) obj).floatValue();
                return;
            case 8:
                this.f٢٣٧٥e = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public a(a aVar, Object obj) {
        this.f٢٣٧١a = false;
        this.f٢٣٧٢b = aVar.f٢٣٧٢b;
        this.f٢٣٧٣c = aVar.f٢٣٧٣c;
        j(obj);
    }
}
