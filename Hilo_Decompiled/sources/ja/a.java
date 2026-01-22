package ja;

import android.content.Intent;
import androidx.annotation.IntRange;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface a {
    void startActivity(Intent intent);

    void startActivityForResult(Intent intent, @IntRange(from = 1, to = 65535) int i10);
}
