package pc;

import android.graphics.Paint;
import android.text.TextUtils;
import android.widget.TextView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f١٧٠٤٤a;

    private a() {
    }

    public static a a() {
        a aVar = f١٧٠٤٤a;
        if (aVar != null) {
            return aVar;
        }
        synchronized (a.class) {
            try {
                a aVar2 = f١٧٠٤٤a;
                if (aVar2 != null) {
                    return aVar2;
                }
                a aVar3 = new a();
                f١٧٠٤٤a = aVar3;
                return aVar3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean d() {
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            return true;
        }
        return false;
    }

    public float b(TextView textView, int i10, int i11, int i12, int i13) {
        if (textView == null) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        Paint.FontMetrics fontMetrics = textView.getPaint().getFontMetrics();
        float abs = Math.abs(fontMetrics.bottom - fontMetrics.top) * textView.getLineCount();
        float height = (((textView.getHeight() - i10) - i11) - i12) - i13;
        if (abs > height) {
            return height;
        }
        return abs;
    }

    public float c(TextView textView, int i10, int i11, int i12, int i13) {
        float measureText;
        if (textView == null) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        String charSequence = textView.getText().toString();
        if (charSequence.contains("\n")) {
            String[] split = charSequence.split("\n");
            ArrayList arrayList = new ArrayList(split.length);
            for (String str : split) {
                arrayList.add(Float.valueOf(textView.getPaint().measureText(str)));
            }
            measureText = ((Float) Collections.max(arrayList)).floatValue();
        } else {
            measureText = textView.getPaint().measureText(charSequence);
        }
        float width = (((textView.getWidth() - i10) - i11) - i12) - i13;
        if (measureText > width) {
            return width;
        }
        return measureText;
    }
}
