package z5;

import n5.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f١٩٤٩١a;

    static {
        String name = e.class.getName();
        f١٩٤٩١a = name.substring(0, name.lastIndexOf(46) + 1);
    }

    private static StackTraceElement[] a(StackTraceElement[] stackTraceElementArr, int i10) {
        int length = stackTraceElementArr.length;
        if (i10 > 0) {
            length = Math.min(i10, length);
        }
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[length];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, length);
        return stackTraceElementArr2;
    }

    public static StackTraceElement[] b(StackTraceElement[] stackTraceElementArr, String str, int i10) {
        return a(c(stackTraceElementArr, str), i10);
    }

    private static StackTraceElement[] c(StackTraceElement[] stackTraceElementArr, String str) {
        int i10;
        int length = stackTraceElementArr.length;
        for (int i11 = length - 1; i11 >= 0; i11--) {
            String className = stackTraceElementArr[i11].getClassName();
            if (className.startsWith(f١٩٤٩١a) || (str != null && className.startsWith(str))) {
                i10 = i11 + 1;
                break;
            }
        }
        i10 = 0;
        int i12 = length - i10;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[i12];
        System.arraycopy(stackTraceElementArr, i10, stackTraceElementArr2, 0, i12);
        return stackTraceElementArr2;
    }
}
