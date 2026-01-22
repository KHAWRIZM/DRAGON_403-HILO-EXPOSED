package com.qiahao.nextvideo.utilities.firebase;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.HiloApplication;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\tj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001`\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/utilities/firebase/FirebaseHelper;", "", "<init>", "()V", "onEvent", "", "eventKey", "", "values", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FirebaseHelper {

    @NotNull
    public static final FirebaseHelper INSTANCE = new FirebaseHelper();

    private FirebaseHelper() {
    }

    @SuppressLint({"Range"})
    public final void onEvent(@Nullable String eventKey, @NotNull HashMap<String, Object> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        if (!TextUtils.isEmpty(eventKey) && !HiloUtils.INSTANCE.isEmpty(values)) {
            Bundle bundle = new Bundle();
            for (String str : values.keySet()) {
                Intrinsics.checkNotNullExpressionValue(str, "next(...)");
                String str2 = str;
                if (values.get(str2) instanceof String) {
                    bundle.putString(str2, (String) values.get(str2));
                } else {
                    bundle.putString(str2, String.valueOf(values.get(str2)));
                }
            }
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(HiloApplication.INSTANCE.getCONTEXT());
            if (eventKey == null) {
                eventKey = "";
            }
            firebaseAnalytics.logEvent(eventKey, bundle);
        }
    }
}
