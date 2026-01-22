package a7;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class l extends v {

    /* renamed from: a, reason: collision with root package name */
    private final long f٣٥٤a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(long j10) {
        this.f٣٥٤a = j10;
    }

    @Override // a7.v
    public long c() {
        return this.f٣٥٤a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof v) && this.f٣٥٤a == ((v) obj).c()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f٣٥٤a;
        return 1000003 ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f٣٥٤a + "}";
    }
}
