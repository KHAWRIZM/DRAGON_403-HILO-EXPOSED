package df;

import android.util.Log;
import cf.g;
import java.util.logging.Level;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class c implements g {
    private final String a;

    public c(String str) {
        this.a = str;
    }

    private int c(Level level) {
        int intValue = level.intValue();
        if (intValue < 800) {
            if (intValue < 500) {
                return 2;
            }
            return 3;
        }
        if (intValue < 900) {
            return 4;
        }
        if (intValue < 1000) {
            return 5;
        }
        return 6;
    }

    @Override // cf.g
    public void a(Level level, String str, Throwable th) {
        if (level != Level.OFF) {
            Log.println(c(level), this.a, str + "\n" + Log.getStackTraceString(th));
        }
    }

    @Override // cf.g
    public void b(Level level, String str) {
        if (level != Level.OFF) {
            Log.println(c(level), this.a, str);
        }
    }
}
