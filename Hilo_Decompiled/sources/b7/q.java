package b7;

import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class q implements z6.j {

    /* renamed from: a, reason: collision with root package name */
    private final Set f٥٥٢٧a;

    /* renamed from: b, reason: collision with root package name */
    private final p f٥٥٢٨b;

    /* renamed from: c, reason: collision with root package name */
    private final t f٥٥٢٩c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Set set, p pVar, t tVar) {
        this.f٥٥٢٧a = set;
        this.f٥٥٢٨b = pVar;
        this.f٥٥٢٩c = tVar;
    }

    @Override // z6.j
    public z6.i a(String str, Class cls, z6.c cVar, z6.h hVar) {
        if (this.f٥٥٢٧a.contains(cVar)) {
            return new s(this.f٥٥٢٨b, str, cVar, hVar, this.f٥٥٢٩c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", cVar, this.f٥٥٢٧a));
    }
}
