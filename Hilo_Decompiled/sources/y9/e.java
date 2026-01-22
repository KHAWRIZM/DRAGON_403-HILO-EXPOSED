package y9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.IntRange;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface e extends ja.a {
    Activity getActivity();

    Bundle getArguments();

    boolean isAdded();

    boolean isRemoving();

    void requestPermissions(String[] strArr, @IntRange(from = 1, to = 65535) int i10);

    void setArguments(Bundle bundle);

    void setRetainInstance(boolean z10);

    @Override // ja.a
    /* synthetic */ void startActivity(Intent intent);

    @Override // ja.a
    /* synthetic */ void startActivityForResult(Intent intent, @IntRange(from = 1, to = 65535) int i10);
}
