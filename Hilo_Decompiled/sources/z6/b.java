package z6;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class b extends g {

    /* renamed from: a, reason: collision with root package name */
    private final Integer f١٩٤٩٦a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Integer num) {
        this.f١٩٤٩٦a = num;
    }

    @Override // z6.g
    public Integer a() {
        return this.f١٩٤٩٦a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        Integer num = this.f١٩٤٩٦a;
        Integer a10 = ((g) obj).a();
        if (num == null) {
            if (a10 == null) {
                return true;
            }
            return false;
        }
        return num.equals(a10);
    }

    public int hashCode() {
        int hashCode;
        Integer num = this.f١٩٤٩٦a;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        return hashCode ^ 1000003;
    }

    public String toString() {
        return "ProductData{productId=" + this.f١٩٤٩٦a + "}";
    }
}
