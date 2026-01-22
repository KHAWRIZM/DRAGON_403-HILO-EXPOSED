package a7;

import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class n {
    public static n a(List list) {
        return new d(list);
    }

    public static DataEncoder b() {
        return new JsonDataEncoderBuilder().configureWith(b.f٢٣١a).ignoreNullValues(true).build();
    }

    public abstract List c();
}
