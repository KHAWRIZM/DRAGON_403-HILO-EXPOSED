package com.qiahao.nextvideo.ui.example;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.qiahao.nextvideo.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/ui/example/ExampleActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "fullscreenContent", "Landroid/widget/TextView;", "fullscreenContentControls", "Landroid/widget/LinearLayout;", "hideHandler", "Landroid/os/Handler;", "hidePart2Runnable", "Ljava/lang/Runnable;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ExampleActivity extends AppCompatActivity {
    private TextView fullscreenContent;
    private LinearLayout fullscreenContentControls;

    @NotNull
    private final Handler hideHandler = new Handler();

    @SuppressLint({"InlinedApi"})
    @NotNull
    private final Runnable hidePart2Runnable = new Runnable() { // from class: com.qiahao.nextvideo.ui.example.a
        @Override // java.lang.Runnable
        public final void run() {
            ExampleActivity.hidePart2Runnable$lambda$0(ExampleActivity.this);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hidePart2Runnable$lambda$0(ExampleActivity exampleActivity) {
        TextView textView = exampleActivity.fullscreenContent;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fullscreenContent");
            textView = null;
        }
        textView.setSystemUiVisibility(4871);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_entrance);
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.s(true);
        }
    }
}
