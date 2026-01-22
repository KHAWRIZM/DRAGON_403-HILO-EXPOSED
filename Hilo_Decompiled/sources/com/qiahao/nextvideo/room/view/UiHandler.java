package com.qiahao.nextvideo.room.view;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.MyAward;
import com.qiahao.nextvideo.data.model.RocketResultBean;
import com.qiahao.nextvideo.databinding.ViewRocketSvgaCountDownBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/room/view/UiHandler;", "Landroid/os/Handler;", "mRocketSvgaCountdownView", "Lcom/qiahao/nextvideo/room/view/RocketSvgaCountdownView;", "<init>", "(Lcom/qiahao/nextvideo/room/view/RocketSvgaCountdownView;)V", "mRocketSvgaCountDownRefrence", "Ljava/lang/ref/WeakReference;", "getMRocketSvgaCountDownRefrence", "()Ljava/lang/ref/WeakReference;", "setMRocketSvgaCountDownRefrence", "(Ljava/lang/ref/WeakReference;)V", "countDown", "", "getCountDown", "()I", "setCountDown", "(I)V", "handleMessage", "", "msg", "Landroid/os/Message;", "getCurrentIndexRes", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class UiHandler extends Handler {
    private int countDown;

    @Nullable
    private WeakReference<RocketSvgaCountdownView> mRocketSvgaCountDownRefrence;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UiHandler(@NotNull RocketSvgaCountdownView rocketSvgaCountdownView) {
        super(r0);
        Intrinsics.checkNotNullParameter(rocketSvgaCountdownView, "mRocketSvgaCountdownView");
        Looper myLooper = Looper.myLooper();
        Intrinsics.checkNotNull(myLooper);
        this.mRocketSvgaCountDownRefrence = new WeakReference<>(rocketSvgaCountdownView);
        this.countDown = 10;
    }

    private final int getCurrentIndexRes(int countDown) {
        switch (countDown) {
            case 1:
            default:
                return R.drawable.rocket_1;
            case 2:
                return R.drawable.rocket_2;
            case 3:
                return R.drawable.rocket_3;
            case 4:
                return R.drawable.rocket_4;
            case 5:
                return R.drawable.rocket_5;
            case 6:
                return R.drawable.rocket_6;
            case 7:
                return R.drawable.rocket_7;
            case 8:
                return R.drawable.rocket_8;
            case 9:
                return R.drawable.rocket_9;
            case 10:
                return R.drawable.rocket_10;
        }
    }

    public final int getCountDown() {
        return this.countDown;
    }

    @Nullable
    public final WeakReference<RocketSvgaCountdownView> getMRocketSvgaCountDownRefrence() {
        return this.mRocketSvgaCountDownRefrence;
    }

    @Override // android.os.Handler
    public void handleMessage(@NotNull Message msg) {
        RocketSvgaCountdownView rocketSvgaCountdownView;
        ArrayList<RocketResultBean> mRocketList;
        ArrayList<RocketResultBean> mRocketList2;
        ArrayList<RocketResultBean> mRocketList3;
        ViewRocketSvgaCountDownBinding binding;
        ImageView imageView;
        ViewRocketSvgaCountDownBinding binding2;
        ImageView imageView2;
        String str;
        String str2;
        String str3;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        String str4;
        MyAward myAward;
        MyAward myAward2;
        MyAward myAward3;
        RocketResultBean mCurrentPlayRocketResultBean;
        ViewRocketSvgaCountDownBinding binding3;
        ImageView imageView3;
        Intrinsics.checkNotNullParameter(msg, "msg");
        super.handleMessage(msg);
        WeakReference<RocketSvgaCountdownView> weakReference = this.mRocketSvgaCountDownRefrence;
        Integer num5 = null;
        MyAward myAward4 = null;
        r3 = null;
        Integer num6 = null;
        num5 = null;
        if (weakReference != null) {
            rocketSvgaCountdownView = weakReference.get();
        } else {
            rocketSvgaCountdownView = null;
        }
        int i = msg.what;
        int i2 = 0;
        if (i != 1) {
            if (i == 2) {
                Log.d(RocketSvgaCountdownView.TAG, "handleMessage: what = 2,countDown = " + this.countDown);
                if (this.countDown == 0) {
                    if (rocketSvgaCountdownView != null) {
                        rocketSvgaCountdownView.stopSvga();
                    }
                    if (rocketSvgaCountdownView != null) {
                        rocketSvgaCountdownView.sendToPlaySvga(false);
                    }
                    if (rocketSvgaCountdownView != null && (binding3 = rocketSvgaCountdownView.getBinding()) != null && (imageView3 = binding3.countDownText) != null) {
                        imageView3.setVisibility(8);
                    }
                    String mGroupId = MeetingRoomManager.INSTANCE.getMGroupId();
                    if (rocketSvgaCountdownView != null && (mCurrentPlayRocketResultBean = rocketSvgaCountdownView.getMCurrentPlayRocketResultBean()) != null) {
                        str = mCurrentPlayRocketResultBean.getGroupId();
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(mGroupId, str)) {
                        RocketResultBean mCurrentPlayRocketResultBean2 = rocketSvgaCountdownView.getMCurrentPlayRocketResultBean();
                        if (mCurrentPlayRocketResultBean2 != null) {
                            str2 = mCurrentPlayRocketResultBean2.getGroupId();
                        } else {
                            str2 = null;
                        }
                        if (mCurrentPlayRocketResultBean2 != null) {
                            str3 = mCurrentPlayRocketResultBean2.getPeriod();
                        } else {
                            str3 = null;
                        }
                        if (mCurrentPlayRocketResultBean2 != null) {
                            num = Integer.valueOf(mCurrentPlayRocketResultBean2.getRound());
                        } else {
                            num = null;
                        }
                        if (mCurrentPlayRocketResultBean2 != null) {
                            num2 = Integer.valueOf(mCurrentPlayRocketResultBean2.getStage());
                        } else {
                            num2 = null;
                        }
                        if (mCurrentPlayRocketResultBean2 != null && (myAward3 = mCurrentPlayRocketResultBean2.getMyAward()) != null) {
                            num3 = Integer.valueOf(myAward3.getAwardType());
                        } else {
                            num3 = null;
                        }
                        if (mCurrentPlayRocketResultBean2 != null && (myAward2 = mCurrentPlayRocketResultBean2.getMyAward()) != null) {
                            num4 = Integer.valueOf(myAward2.getNumber());
                        } else {
                            num4 = null;
                        }
                        if (mCurrentPlayRocketResultBean2 != null && (myAward = mCurrentPlayRocketResultBean2.getMyAward()) != null) {
                            str4 = myAward.getUrl();
                        } else {
                            str4 = null;
                        }
                        Log.d(RocketSvgaCountdownView.TAG, "展示结果:" + str2 + " " + str3 + " " + num + " " + num2 + " " + num3 + " " + num4 + " " + str4);
                        RocketSvgaCountdownViewListener countdownViewListener = rocketSvgaCountdownView.getCountdownViewListener();
                        if (countdownViewListener != null) {
                            RocketResultBean mCurrentPlayRocketResultBean3 = rocketSvgaCountdownView.getMCurrentPlayRocketResultBean();
                            if (mCurrentPlayRocketResultBean3 != null) {
                                myAward4 = mCurrentPlayRocketResultBean3.getMyAward();
                            }
                            countdownViewListener.rocketViewSvgaOrCountdown(myAward4);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (rocketSvgaCountdownView != null && (binding2 = rocketSvgaCountdownView.getBinding()) != null && (imageView2 = binding2.countDownText) != null) {
                    ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(getCurrentIndexRes(this.countDown)), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                }
                if (rocketSvgaCountdownView != null && (binding = rocketSvgaCountdownView.getBinding()) != null && (imageView = binding.countDownText) != null) {
                    imageView.setVisibility(0);
                }
                if (rocketSvgaCountdownView != null) {
                    rocketSvgaCountdownView.countDownNext(false, false);
                }
                this.countDown--;
                return;
            }
            return;
        }
        if (rocketSvgaCountdownView != null && (mRocketList3 = rocketSvgaCountdownView.getMRocketList()) != null) {
            i2 = mRocketList3.size();
        }
        if (i2 > 0) {
            if (rocketSvgaCountdownView != null && (mRocketList2 = rocketSvgaCountdownView.getMRocketList()) != null) {
                num6 = Integer.valueOf(mRocketList2.size());
            }
            Log.d(RocketSvgaCountdownView.TAG, "handleMessage: what = 1 " + num6);
            if (rocketSvgaCountdownView != null) {
                rocketSvgaCountdownView.playSvga();
                return;
            }
            return;
        }
        if (rocketSvgaCountdownView != null && (mRocketList = rocketSvgaCountdownView.getMRocketList()) != null) {
            num5 = Integer.valueOf(mRocketList.size());
        }
        Log.d(RocketSvgaCountdownView.TAG, "handleMessage: what = 1 " + num5);
    }

    public final void setCountDown(int i) {
        this.countDown = i;
    }

    public final void setMRocketSvgaCountDownRefrence(@Nullable WeakReference<RocketSvgaCountdownView> weakReference) {
        this.mRocketSvgaCountDownRefrence = weakReference;
    }
}
