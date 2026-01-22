package k8;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class i extends g {
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private final Object f١٥٥٤٩a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Object obj) {
        this.f١٥٥٤٩a = obj;
    }

    @Override // k8.g
    public Object b() {
        return this.f١٥٥٤٩a;
    }

    @Override // k8.g
    public boolean c() {
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f١٥٥٤٩a.equals(((i) obj).f١٥٥٤٩a);
        }
        return false;
    }

    public int hashCode() {
        return this.f١٥٥٤٩a.hashCode() + 1502476572;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f١٥٥٤٩a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 13);
        sb.append("Optional.of(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}
