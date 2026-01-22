package n5;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class c {
    public static String a(int i10) {
        if (i10 != 2) {
            if (i10 != 3) {
                if (i10 != 4) {
                    if (i10 != 5) {
                        if (i10 != 6) {
                            if (i10 < 2) {
                                return "VERBOSE-" + (2 - i10);
                            }
                            return "ERROR+" + (i10 - 6);
                        }
                        return "ERROR";
                    }
                    return "WARN";
                }
                return "INFO";
            }
            return "DEBUG";
        }
        return "VERBOSE";
    }

    public static String b(int i10) {
        if (i10 != 2) {
            if (i10 != 3) {
                if (i10 != 4) {
                    if (i10 != 5) {
                        if (i10 != 6) {
                            if (i10 < 2) {
                                return "V-" + (2 - i10);
                            }
                            return "E+" + (i10 - 6);
                        }
                        return "E";
                    }
                    return "W";
                }
                return "I";
            }
            return "D";
        }
        return "V";
    }
}
