package com.qiahao.nextvideo.room.luckyfruit;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import androidx.annotation.Keep;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.luckyfruit.LuckyBaseGridView;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitBean;", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyBaseGridView$BaseBean;", "<init>", "()V", AgooConstants.MESSAGE_ID, "", "(I)V", "mId", "getMId", "()I", "setMId", "getId", "stake", "", "getStake", "()J", "setStake", "(J)V", "rate", "getRate", "setRate", "textColor", "getTextColor", "setTextColor", "getDes", "", "getItemDrawable", "Landroid/graphics/drawable/Drawable;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLuckyFruitBean.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LuckyFruitBean.kt\ncom/qiahao/nextvideo/room/luckyfruit/LuckyFruitBean\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,58:1\n1#2:59\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LuckyFruitBean implements LuckyBaseGridView.BaseBean {
    private int mId;
    private int rate = 5;
    private long stake;
    private int textColor;

    public LuckyFruitBean() {
    }

    @NotNull
    public final String getDes() {
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131953085), Arrays.copyOf(new Object[]{String.valueOf(this.rate)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    @Override // com.qiahao.nextvideo.room.luckyfruit.LuckyBaseGridView.BaseBean
    /* renamed from: getId, reason: from getter */
    public int getMId() {
        return this.mId;
    }

    @Nullable
    public final Drawable getItemDrawable() {
        switch (this.mId) {
            case 1:
                Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
                if (currentActivity == null) {
                    return null;
                }
                return androidx.core.content.a.getDrawable(currentActivity, R.drawable.chat_room_lucky_fruit_item1);
            case 2:
                Activity currentActivity2 = ActivityLifecycleManager.INSTANCE.currentActivity();
                if (currentActivity2 == null) {
                    return null;
                }
                return androidx.core.content.a.getDrawable(currentActivity2, R.drawable.chat_room_lucky_fruit_item2);
            case 3:
                Activity currentActivity3 = ActivityLifecycleManager.INSTANCE.currentActivity();
                if (currentActivity3 == null) {
                    return null;
                }
                return androidx.core.content.a.getDrawable(currentActivity3, R.drawable.chat_room_lucky_fruit_item3);
            case 4:
                Activity currentActivity4 = ActivityLifecycleManager.INSTANCE.currentActivity();
                if (currentActivity4 == null) {
                    return null;
                }
                return androidx.core.content.a.getDrawable(currentActivity4, R.drawable.chat_room_lucky_fruit_item4);
            case 5:
                Activity currentActivity5 = ActivityLifecycleManager.INSTANCE.currentActivity();
                if (currentActivity5 == null) {
                    return null;
                }
                return androidx.core.content.a.getDrawable(currentActivity5, R.drawable.chat_room_lucky_fruit_item5);
            case 6:
                Activity currentActivity6 = ActivityLifecycleManager.INSTANCE.currentActivity();
                if (currentActivity6 == null) {
                    return null;
                }
                return androidx.core.content.a.getDrawable(currentActivity6, R.drawable.chat_room_lucky_fruit_item6);
            case 7:
                Activity currentActivity7 = ActivityLifecycleManager.INSTANCE.currentActivity();
                if (currentActivity7 == null) {
                    return null;
                }
                return androidx.core.content.a.getDrawable(currentActivity7, R.drawable.chat_room_lucky_fruit_item7);
            case 8:
                Activity currentActivity8 = ActivityLifecycleManager.INSTANCE.currentActivity();
                if (currentActivity8 == null) {
                    return null;
                }
                return androidx.core.content.a.getDrawable(currentActivity8, R.drawable.chat_room_lucky_fruit_item8);
            default:
                return null;
        }
    }

    public final int getMId() {
        return this.mId;
    }

    public final int getRate() {
        return this.rate;
    }

    public final long getStake() {
        return this.stake;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final void setMId(int i) {
        this.mId = i;
    }

    public final void setRate(int i) {
        this.rate = i;
    }

    public final void setStake(long j) {
        this.stake = j;
    }

    public final void setTextColor(int i) {
        this.textColor = i;
    }

    public LuckyFruitBean(int i) {
        this.mId = i;
    }
}
