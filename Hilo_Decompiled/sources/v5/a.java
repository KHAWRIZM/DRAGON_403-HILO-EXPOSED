package v5;

import x5.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a implements b {
    @Override // p5.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String format(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder(256);
        if (stackTraceElementArr != null && stackTraceElementArr.length != 0) {
            if (stackTraceElementArr.length == 1) {
                return "\t─ " + stackTraceElementArr[0].toString();
            }
            int length = stackTraceElementArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                if (i10 != length - 1) {
                    sb.append("\t├ ");
                    sb.append(stackTraceElementArr[i10].toString());
                    sb.append(c.f١٨٩٣٠a);
                } else {
                    sb.append("\t└ ");
                    sb.append(stackTraceElementArr[i10].toString());
                }
            }
            return sb.toString();
        }
        return null;
    }
}
