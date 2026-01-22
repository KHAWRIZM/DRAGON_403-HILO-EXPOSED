package q8;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.math.BigDecimal;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class g extends Number {

    /* renamed from: a, reason: collision with root package name */
    private final String f١٧٢١١a;

    public g(String str) {
        this.f١٧٢١١a = str;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() throws ObjectStreamException {
        return new BigDecimal(this.f١٧٢١١a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f١٧٢١١a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        String str = this.f١٧٢١١a;
        String str2 = ((g) obj).f١٧٢١١a;
        if (str == str2 || str.equals(str2)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f١٧٢١١a);
    }

    public int hashCode() {
        return this.f١٧٢١١a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f١٧٢١١a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f١٧٢١١a);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f١٧٢١١a).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f١٧٢١١a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f١٧٢١١a).longValue();
        }
    }

    public String toString() {
        return this.f١٧٢١١a;
    }
}
