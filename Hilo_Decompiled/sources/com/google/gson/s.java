package com.google.gson;

import com.qiahao.base_common.model.eventBus.VideoEvent;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f١٠٨٤٩a;

    /* renamed from: b, reason: collision with root package name */
    public static final s f١٠٨٥٠b;

    /* renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ s[] f١٠٨٥١c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    enum a extends s {
        a(String str, int i10) {
            super(str, i10, null);
        }
    }

    static {
        a aVar = new a(VideoEvent.DEFAULT, 0);
        f١٠٨٤٩a = aVar;
        s sVar = new s("STRING", 1) { // from class: com.google.gson.s.b
            {
                a aVar2 = null;
            }
        };
        f١٠٨٥٠b = sVar;
        f١٠٨٥١c = new s[]{aVar, sVar};
    }

    private s(String str, int i10) {
    }

    public static s valueOf(String str) {
        return (s) Enum.valueOf(s.class, str);
    }

    public static s[] values() {
        return (s[]) f١٠٨٥١c.clone();
    }

    /* synthetic */ s(String str, int i10, a aVar) {
        this(str, i10);
    }
}
