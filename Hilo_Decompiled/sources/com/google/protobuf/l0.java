package com.google.protobuf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'e' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class l0 {

    /* renamed from: d, reason: collision with root package name */
    public static final l0 f١١٢١٦d = new l0("VOID", 0, Void.class, Void.class, null);

    /* renamed from: e, reason: collision with root package name */
    public static final l0 f١١٢١٧e;

    /* renamed from: f, reason: collision with root package name */
    public static final l0 f١١٢١٨f;

    /* renamed from: g, reason: collision with root package name */
    public static final l0 f١١٢١٩g;

    /* renamed from: h, reason: collision with root package name */
    public static final l0 f١١٢٢٠h;

    /* renamed from: i, reason: collision with root package name */
    public static final l0 f١١٢٢١i;

    /* renamed from: j, reason: collision with root package name */
    public static final l0 f١١٢٢٢j;

    /* renamed from: k, reason: collision with root package name */
    public static final l0 f١١٢٢٣k;

    /* renamed from: l, reason: collision with root package name */
    public static final l0 f١١٢٢٤l;

    /* renamed from: m, reason: collision with root package name */
    public static final l0 f١١٢٢٥m;

    /* renamed from: n, reason: collision with root package name */
    private static final /* synthetic */ l0[] f١١٢٢٦n;

    /* renamed from: a, reason: collision with root package name */
    private final Class f١١٢٢٧a;

    /* renamed from: b, reason: collision with root package name */
    private final Class f١١٢٢٨b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f١١٢٢٩c;

    static {
        Class cls = Integer.TYPE;
        f١١٢١٧e = new l0("INT", 1, cls, Integer.class, 0);
        f١١٢١٨f = new l0("LONG", 2, Long.TYPE, Long.class, 0L);
        f١١٢١٩g = new l0("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS));
        f١١٢٢٠h = new l0("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        f١١٢٢١i = new l0("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f١١٢٢٢j = new l0("STRING", 6, String.class, String.class, "");
        f١١٢٢٣k = new l0("BYTE_STRING", 7, h.class, h.class, h.f١١٠١١b);
        f١١٢٢٤l = new l0("ENUM", 8, cls, Integer.class, null);
        f١١٢٢٥m = new l0("MESSAGE", 9, Object.class, Object.class, null);
        f١١٢٢٦n = a();
    }

    private l0(String str, int i10, Class cls, Class cls2, Object obj) {
        this.f١١٢٢٧a = cls;
        this.f١١٢٢٨b = cls2;
        this.f١١٢٢٩c = obj;
    }

    private static /* synthetic */ l0[] a() {
        return new l0[]{f١١٢١٦d, f١١٢١٧e, f١١٢١٨f, f١١٢١٩g, f١١٢٢٠h, f١١٢٢١i, f١١٢٢٢j, f١١٢٢٣k, f١١٢٢٤l, f١١٢٢٥m};
    }

    public static l0 valueOf(String str) {
        return (l0) Enum.valueOf(l0.class, str);
    }

    public static l0[] values() {
        return (l0[]) f١١٢٢٦n.clone();
    }

    public Class c() {
        return this.f١١٢٢٨b;
    }
}
