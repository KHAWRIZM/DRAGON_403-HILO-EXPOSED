package com.qiahao.base_common.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.databinding.IncludeGameLevelBinding;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0007\u001a\f\u0010\u0006\u001a\u00020\u0004*\u00020\u0005H\u0007\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\n\u0010\u000b\u001a\u00020\u0004*\u00020\f\u001a\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u001a#\u0010\u0017\u001a\u00020\u00042\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001a0\u0019\"\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001b\u001a\n\u0010\u001c\u001a\u00020\u001d*\u00020\u001d\u001a(\u0010\u001e\u001a\u00020\u0004*\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u001d2\b\b\u0002\u0010#\u001a\u00020!\u001a(\u0010$\u001a\u00020\u0004*\u00020%2\b\b\u0002\u0010&\u001a\u00020!2\b\b\u0002\u0010'\u001a\u00020\u001d2\b\b\u0002\u0010#\u001a\u00020!\u001a\u0010\u0010(\u001a\u00020\u00162\b\u0010)\u001a\u0004\u0018\u00010\u001d\u001a\u0016\u0010*\u001a\u00020\u0004*\u00020+2\n\u0010,\u001a\u00020-\"\u00020!\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0000\u0010\u0002\"\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006."}, d2 = {"isAppInForeground", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "dismissKeyboard", "", "Landroid/view/View;", "showKeyboard", "toByteArray", "", "parcelable", "Landroid/os/Parcelable;", "toAppSetting", "Landroidx/appcompat/app/AppCompatActivity;", "vibrator", "Landroid/os/Vibrator;", "getVibrator", "()Landroid/os/Vibrator;", "setVibrator", "(Landroid/os/Vibrator;)V", "context", "Landroid/content/Context;", "rate", "", "printfNetwork", "args", "", "", "([Ljava/lang/Object;)V", "changeNickNameSizeInSixInclude", "", "familyNamePlate", "Lcom/qiahao/base_common/databinding/IncludeFamilyNamePlateBinding;", "grade", "", "namePlateStr", "maxLength", "gameLevelBinding", "Lcom/qiahao/base_common/databinding/IncludeGameLevelBinding;", FirebaseAnalytics.Param.LEVEL, "gameText", "getAudioFileVoiceTime", "filePath", "setMultiGradientText", "Landroid/widget/TextView;", "colors", "", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppUtilities.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppUtilities.kt\ncom/qiahao/base_common/utils/AppUtilitiesKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,217:1\n1563#2:218\n1634#2,3:219\n*S KotlinDebug\n*F\n+ 1 AppUtilities.kt\ncom/qiahao/base_common/utils/AppUtilitiesKt\n*L\n203#1:218\n203#1:219,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class AppUtilitiesKt {

    @NotNull
    private static final AtomicBoolean isAppInForeground = new AtomicBoolean(true);

    @Nullable
    private static Vibrator vibrator;

    @NotNull
    public static final String changeNickNameSizeInSixInclude(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() == 0) {
            return "";
        }
        if (str.length() > 6) {
            return ((Object) str.subSequence(0, 5)) + "...";
        }
        return str;
    }

    @RequiresApi(3)
    public static final void dismissKeyboard(@NotNull View view) {
        InputMethodManager inputMethodManager;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object systemService = view.getContext().getSystemService("input_method");
        if (systemService instanceof InputMethodManager) {
            inputMethodManager = (InputMethodManager) systemService;
        } else {
            inputMethodManager = null;
        }
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static final void familyNamePlate(@NotNull final IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, int i10, @NotNull String namePlateStr, int i11) {
        Intrinsics.checkNotNullParameter(includeFamilyNamePlateBinding, "<this>");
        Intrinsics.checkNotNullParameter(namePlateStr, "namePlateStr");
        if (i10 >= 0 && !TextUtils.isEmpty(namePlateStr)) {
            includeFamilyNamePlateBinding.getRoot().setVisibility(0);
            includeFamilyNamePlateBinding.getRoot().post(new Runnable() { // from class: com.qiahao.base_common.utils.a
                @Override // java.lang.Runnable
                public final void run() {
                    AppUtilitiesKt.familyNamePlate$lambda$0(IncludeFamilyNamePlateBinding.this);
                }
            });
            includeFamilyNamePlateBinding.medal.setImageDrawable(androidx.core.content.a.getDrawable(includeFamilyNamePlateBinding.getRoot().getContext(), HiloResUtilsKt.familyMedal(i10)));
            TextView textView = includeFamilyNamePlateBinding.namePlate;
            if (namePlateStr.length() > i11) {
                String substring = namePlateStr.substring(0, i11 - 1);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                namePlateStr = substring + "...";
            }
            textView.setBackground(androidx.core.content.a.getDrawable(includeFamilyNamePlateBinding.getRoot().getContext(), HiloResUtilsKt.familyMedalBg(i10)));
            textView.setTextColor(androidx.core.content.a.getColor(includeFamilyNamePlateBinding.getRoot().getContext(), HiloResUtilsKt.familyTextColor(i10)));
            textView.setText(namePlateStr);
            textView.setTextSize(2, 9.0f);
            return;
        }
        includeFamilyNamePlateBinding.getRoot().setVisibility(8);
    }

    public static /* synthetic */ void familyNamePlate$default(IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, int i10, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = -1;
        }
        if ((i12 & 2) != 0) {
            str = "";
        }
        if ((i12 & 4) != 0) {
            i11 = 15;
        }
        familyNamePlate(includeFamilyNamePlateBinding, i10, str, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void familyNamePlate$lambda$0(IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding) {
        ViewGroup.LayoutParams layoutParams = includeFamilyNamePlateBinding.namePlate.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        if (includeFamilyNamePlateBinding.getRoot().getHeight() <= UiKtxKt.toPX(20)) {
            bVar.setMargins(0, UiKtxKt.toPX(2), 0, UiKtxKt.toPX(4));
        } else {
            bVar.setMargins(0, UiKtxKt.toPX(4), 0, UiKtxKt.toPX(4));
        }
        includeFamilyNamePlateBinding.namePlate.setLayoutParams(bVar);
    }

    public static final void gameLevelBinding(@NotNull IncludeGameLevelBinding includeGameLevelBinding, int i10, @NotNull String gameText, int i11) {
        Intrinsics.checkNotNullParameter(includeGameLevelBinding, "<this>");
        Intrinsics.checkNotNullParameter(gameText, "gameText");
        if (i10 >= 0 && !TextUtils.isEmpty(gameText)) {
            includeGameLevelBinding.getRoot().setVisibility(0);
            includeGameLevelBinding.medal.setImageDrawable(androidx.core.content.a.getDrawable(includeGameLevelBinding.getRoot().getContext(), HiloResUtilsKt.gameLevelMedal(i10)));
            TextView textView = includeGameLevelBinding.namePlate;
            if (gameText.length() > i11) {
                String substring = gameText.substring(0, i11 - 1);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                gameText = substring + "...";
            }
            textView.setBackground(androidx.core.content.a.getDrawable(includeGameLevelBinding.getRoot().getContext(), HiloResUtilsKt.gameLevelMedalBg(i10)));
            textView.setTextColor(androidx.core.content.a.getColor(includeGameLevelBinding.getRoot().getContext(), HiloResUtilsKt.gameLevelTextColor(i10)));
            textView.setText(gameText);
            textView.setTextSize(2, 9.0f);
            return;
        }
        includeGameLevelBinding.getRoot().setVisibility(8);
    }

    public static /* synthetic */ void gameLevelBinding$default(IncludeGameLevelBinding includeGameLevelBinding, int i10, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = -1;
        }
        if ((i12 & 2) != 0) {
            str = "";
        }
        if ((i12 & 4) != 0) {
            i11 = 15;
        }
        gameLevelBinding(includeGameLevelBinding, i10, str, i11);
    }

    public static final long getAudioFileVoiceTime(@Nullable String str) {
        long j10 = 0;
        if (str != null && str.length() != 0) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(str);
                mediaPlayer.prepare();
                j10 = mediaPlayer.getDuration();
            } catch (IOException unused) {
                Log.e("getAudioFileVoiceTime", "获取音乐播放时间错误");
            }
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();
        }
        return j10;
    }

    @Nullable
    public static final Vibrator getVibrator() {
        return vibrator;
    }

    @NotNull
    public static final AtomicBoolean isAppInForeground() {
        return isAppInForeground;
    }

    public static final void printfNetwork(@NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        Log.d("NextVideo", ArraysKt.joinToString$default(args, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
    }

    public static final void setMultiGradientText(@NotNull final TextView textView, @NotNull final int... colors) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(colors, "colors");
        if (textView.getWidth() == 0) {
            textView.post(new Runnable() { // from class: com.qiahao.base_common.utils.b
                @Override // java.lang.Runnable
                public final void run() {
                    AppUtilitiesKt.setMultiGradientText$lambda$3(textView, colors);
                }
            });
            return;
        }
        IntRange indices = ArraysKt.getIndices(colors);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(indices, 10));
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(((IntIterator) it).nextInt() / (colors.length - 1.0f)));
        }
        textView.getPaint().setShader(new LinearGradient(textView.getPaddingStart(), DownloadProgress.UNKNOWN_PROGRESS, textView.getWidth() - textView.getPaddingEnd(), DownloadProgress.UNKNOWN_PROGRESS, colors, CollectionsKt.toFloatArray(arrayList), Shader.TileMode.REPEAT));
        textView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMultiGradientText$lambda$3(TextView textView, int[] iArr) {
        setMultiGradientText(textView, Arrays.copyOf(iArr, iArr.length));
    }

    public static final void setVibrator(@Nullable Vibrator vibrator2) {
        vibrator = vibrator2;
    }

    @RequiresApi(3)
    public static final void showKeyboard(@NotNull View view) {
        InputMethodManager inputMethodManager;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object systemService = view.getContext().getSystemService("input_method");
        if (systemService instanceof InputMethodManager) {
            inputMethodManager = (InputMethodManager) systemService;
        } else {
            inputMethodManager = null;
        }
        if (inputMethodManager != null) {
            view.requestFocus();
            inputMethodManager.showSoftInput(view, 0);
        }
    }

    public static final void toAppSetting(@NotNull AppCompatActivity appCompatActivity) {
        Intent intent;
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", appCompatActivity.getPackageName());
            } else {
                intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", appCompatActivity.getPackageName(), null));
            }
            appCompatActivity.startActivity(intent);
        } catch (ActivityNotFoundException e10) {
            e10.printStackTrace();
            appCompatActivity.startActivity(new Intent("android.settings.SETTINGS"));
        }
    }

    @NotNull
    public static final byte[] toByteArray(@NotNull Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "parcelable");
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain(...)");
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        Intrinsics.checkNotNull(marshall);
        return marshall;
    }

    public static final void vibrator(@NotNull Context context, long j10) {
        VibrationEffect createOneShot;
        Vibrator vibrator2;
        Intrinsics.checkNotNullParameter(context, "context");
        if (vibrator == null) {
            Object systemService = context.getSystemService("vibrator");
            if (systemService instanceof Vibrator) {
                vibrator2 = (Vibrator) systemService;
            } else {
                vibrator2 = null;
            }
            vibrator = vibrator2;
        }
        if (androidx.core.content.a.checkSelfPermission(context, "android.permission.VIBRATE") == 0) {
            if (Build.VERSION.SDK_INT >= 26) {
                Vibrator vibrator3 = vibrator;
                if (vibrator3 != null) {
                    createOneShot = VibrationEffect.createOneShot(j10, -1);
                    vibrator3.vibrate(createOneShot);
                    return;
                }
                return;
            }
            Vibrator vibrator4 = vibrator;
            if (vibrator4 != null) {
                vibrator4.vibrate(j10);
            }
        }
    }

    public static /* synthetic */ void vibrator$default(Context context, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 500;
        }
        vibrator(context, j10);
    }
}
