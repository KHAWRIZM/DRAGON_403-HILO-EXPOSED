package com.skydoves.transformationlayout;

import android.app.Activity;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import com.skydoves.transformationlayout.TransformationLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"Lcom/skydoves/transformationlayout/TransformationActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "transformationlayout_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class TransformationActivity extends ComponentActivity {
    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        TransitionExtensionKt.onTransformationEndContainer((Activity) this, (TransformationLayout.Params) getIntent().getParcelableExtra(TransformationCompat.activityTransitionName));
        super.onCreate(savedInstanceState);
    }
}
