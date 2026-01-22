package pa;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class b implements h {
    @Override // pa.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float evaluate(float f10, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(floatValue + (f10 * (number2.floatValue() - floatValue)));
    }
}
