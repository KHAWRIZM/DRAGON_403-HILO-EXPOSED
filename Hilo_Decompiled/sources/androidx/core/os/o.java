package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class o implements h {

    /* renamed from: a, reason: collision with root package name */
    private final LocaleList f٢٨٨١a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Object obj) {
        this.f٢٨٨١a = n.a(obj);
    }

    @Override // androidx.core.os.h
    public String a() {
        String languageTags;
        languageTags = this.f٢٨٨١a.toLanguageTags();
        return languageTags;
    }

    @Override // androidx.core.os.h
    public Object b() {
        return this.f٢٨٨١a;
    }

    public boolean equals(Object obj) {
        boolean equals;
        equals = this.f٢٨٨١a.equals(((h) obj).b());
        return equals;
    }

    @Override // androidx.core.os.h
    public Locale get(int i10) {
        Locale locale;
        locale = this.f٢٨٨١a.get(i10);
        return locale;
    }

    public int hashCode() {
        int hashCode;
        hashCode = this.f٢٨٨١a.hashCode();
        return hashCode;
    }

    @Override // androidx.core.os.h
    public boolean isEmpty() {
        boolean isEmpty;
        isEmpty = this.f٢٨٨١a.isEmpty();
        return isEmpty;
    }

    @Override // androidx.core.os.h
    public int size() {
        int size;
        size = this.f٢٨٨١a.size();
        return size;
    }

    public String toString() {
        String localeList;
        localeList = this.f٢٨٨١a.toString();
        return localeList;
    }
}
