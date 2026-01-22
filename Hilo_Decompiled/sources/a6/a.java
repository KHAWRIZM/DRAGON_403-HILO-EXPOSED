package a6;

import android.util.Log;
import com.qiahao.base_common.network.model.ErrorCode;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f٢٢٨a;

    /* renamed from: b, reason: collision with root package name */
    private int f٢٢٩b;

    public a(boolean z10) {
        this(z10, ErrorCode.ERROR_4000);
    }

    static int a(String str, int i10, int i11) {
        if (i11 == str.length()) {
            return i11;
        }
        if (str.charAt(i11) == '\n') {
            return i11;
        }
        for (int i12 = i11 - 1; i10 < i12; i12--) {
            if (str.charAt(i12) == '\n') {
                return i12;
            }
        }
        return i11;
    }

    void b(int i10, String str, String str2) {
        Log.println(i10, str, str2);
    }

    @Override // a6.b
    public void println(int i10, String str, String str2) {
        int length = str2.length();
        int i11 = 0;
        while (i11 < length) {
            if (str2.charAt(i11) == '\n') {
                i11++;
            } else {
                int min = Math.min(this.f٢٢٩b + i11, length);
                if (this.f٢٢٨a) {
                    int indexOf = str2.indexOf(10, i11);
                    if (indexOf != -1) {
                        min = Math.min(min, indexOf);
                    }
                } else {
                    min = a(str2, i11, min);
                }
                b(i10, str, str2.substring(i11, min));
                i11 = min;
            }
        }
    }

    public a(boolean z10, int i10) {
        this.f٢٢٨a = z10;
        this.f٢٢٩b = i10;
    }
}
