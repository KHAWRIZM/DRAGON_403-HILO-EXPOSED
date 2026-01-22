package com.google.gson;

import java.math.BigInteger;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class o extends i {

    /* renamed from: a, reason: collision with root package name */
    private final Object f١٠٨٤٨a;

    public o(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f١٠٨٤٨a = bool;
    }

    private static boolean t(o oVar) {
        Object obj = oVar.f١٠٨٤٨a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if (!(number instanceof BigInteger) && !(number instanceof Long) && !(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f١٠٨٤٨a == null) {
            if (oVar.f١٠٨٤٨a == null) {
                return true;
            }
            return false;
        }
        if (t(this) && t(oVar)) {
            if (r().longValue() == oVar.r().longValue()) {
                return true;
            }
            return false;
        }
        Object obj2 = this.f١٠٨٤٨a;
        if ((obj2 instanceof Number) && (oVar.f١٠٨٤٨a instanceof Number)) {
            double doubleValue = r().doubleValue();
            double doubleValue2 = oVar.r().doubleValue();
            if (doubleValue == doubleValue2) {
                return true;
            }
            if (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2)) {
                return true;
            }
            return false;
        }
        return obj2.equals(oVar.f١٠٨٤٨a);
    }

    @Override // com.google.gson.i
    public String h() {
        Object obj = this.f١٠٨٤٨a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (u()) {
            return r().toString();
        }
        if (s()) {
            return ((Boolean) this.f١٠٨٤٨a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f١٠٨٤٨a.getClass());
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f١٠٨٤٨a == null) {
            return 31;
        }
        if (t(this)) {
            doubleToLongBits = r().longValue();
        } else {
            Object obj = this.f١٠٨٤٨a;
            if (obj instanceof Number) {
                doubleToLongBits = Double.doubleToLongBits(r().doubleValue());
            } else {
                return obj.hashCode();
            }
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean n() {
        if (s()) {
            return ((Boolean) this.f١٠٨٤٨a).booleanValue();
        }
        return Boolean.parseBoolean(h());
    }

    public double o() {
        if (u()) {
            return r().doubleValue();
        }
        return Double.parseDouble(h());
    }

    public int p() {
        if (u()) {
            return r().intValue();
        }
        return Integer.parseInt(h());
    }

    public long q() {
        if (u()) {
            return r().longValue();
        }
        return Long.parseLong(h());
    }

    public Number r() {
        Object obj = this.f١٠٨٤٨a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new q8.g((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public boolean s() {
        return this.f١٠٨٤٨a instanceof Boolean;
    }

    public boolean u() {
        return this.f١٠٨٤٨a instanceof Number;
    }

    public boolean v() {
        return this.f١٠٨٤٨a instanceof String;
    }

    public o(Number number) {
        Objects.requireNonNull(number);
        this.f١٠٨٤٨a = number;
    }

    public o(String str) {
        Objects.requireNonNull(str);
        this.f١٠٨٤٨a = str;
    }
}
