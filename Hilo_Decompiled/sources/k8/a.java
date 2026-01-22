package k8;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class a extends g {

    /* renamed from: a, reason: collision with root package name */
    static final a f١٥٥٤٠a = new a();
    private static final long serialVersionUID = 0;

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g e() {
        return f١٥٥٤٠a;
    }

    private Object readResolve() {
        return f١٥٥٤٠a;
    }

    @Override // k8.g
    public Object b() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // k8.g
    public boolean c() {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 2040732332;
    }

    public String toString() {
        return "Optional.absent()";
    }
}
