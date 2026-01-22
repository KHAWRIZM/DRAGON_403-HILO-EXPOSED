package androidx.datastore.preferences.protobuf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'e' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class w {

    /* renamed from: d, reason: collision with root package name */
    public static final w f٣٥٢٣d;

    /* renamed from: e, reason: collision with root package name */
    public static final w f٣٥٢٤e;

    /* renamed from: f, reason: collision with root package name */
    public static final w f٣٥٢٥f;

    /* renamed from: g, reason: collision with root package name */
    public static final w f٣٥٢٦g;

    /* renamed from: h, reason: collision with root package name */
    public static final w f٣٥٢٧h;

    /* renamed from: i, reason: collision with root package name */
    public static final w f٣٥٢٨i;

    /* renamed from: j, reason: collision with root package name */
    public static final w f٣٥٢٩j;

    /* renamed from: k, reason: collision with root package name */
    public static final w f٣٥٣٠k;

    /* renamed from: l, reason: collision with root package name */
    public static final w f٣٥٣١l;

    /* renamed from: m, reason: collision with root package name */
    public static final w f٣٥٣٢m;

    /* renamed from: n, reason: collision with root package name */
    private static final /* synthetic */ w[] f٣٥٣٣n;

    /* renamed from: a, reason: collision with root package name */
    private final Class f٣٥٣٤a;

    /* renamed from: b, reason: collision with root package name */
    private final Class f٣٥٣٥b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f٣٥٣٦c;

    static {
        w wVar = new w("VOID", 0, Void.class, Void.class, null);
        f٣٥٢٣d = wVar;
        Class cls = Integer.TYPE;
        w wVar2 = new w("INT", 1, cls, Integer.class, 0);
        f٣٥٢٤e = wVar2;
        w wVar3 = new w("LONG", 2, Long.TYPE, Long.class, 0L);
        f٣٥٢٥f = wVar3;
        w wVar4 = new w("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS));
        f٣٥٢٦g = wVar4;
        w wVar5 = new w("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        f٣٥٢٧h = wVar5;
        w wVar6 = new w("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f٣٥٢٨i = wVar6;
        w wVar7 = new w("STRING", 6, String.class, String.class, "");
        f٣٥٢٩j = wVar7;
        w wVar8 = new w("BYTE_STRING", 7, f.class, f.class, f.f٣٢٨٥b);
        f٣٥٣٠k = wVar8;
        w wVar9 = new w("ENUM", 8, cls, Integer.class, null);
        f٣٥٣١l = wVar9;
        w wVar10 = new w("MESSAGE", 9, Object.class, Object.class, null);
        f٣٥٣٢m = wVar10;
        f٣٥٣٣n = new w[]{wVar, wVar2, wVar3, wVar4, wVar5, wVar6, wVar7, wVar8, wVar9, wVar10};
    }

    private w(String str, int i10, Class cls, Class cls2, Object obj) {
        this.f٣٥٣٤a = cls;
        this.f٣٥٣٥b = cls2;
        this.f٣٥٣٦c = obj;
    }

    public static w valueOf(String str) {
        return (w) Enum.valueOf(w.class, str);
    }

    public static w[] values() {
        return (w[]) f٣٥٣٣n.clone();
    }

    public Class a() {
        return this.f٣٥٣٥b;
    }
}
