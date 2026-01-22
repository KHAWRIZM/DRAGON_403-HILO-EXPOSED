package com.qiahao.nextvideo.room.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.opensource.svgaplayer.SVGACallback;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.StringKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.data.model.RocketResultBean;
import com.qiahao.nextvideo.data.model.TopContributor;
import com.qiahao.nextvideo.databinding.ViewRocketSvgaCountDownBinding;
import com.qiahao.nextvideo.utilities.SVGAUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 R2\u00020\u0001:\u0001RB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0006\u0010?\u001a\u00020@J\u000e\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u0011J\u001e\u0010C\u001a\u00020@2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010E2\u0006\u0010F\u001a\u00020\"J\u0006\u0010G\u001a\u00020@J\u000e\u0010H\u001a\u00020@2\u0006\u0010F\u001a\u00020\"J\u0016\u0010I\u001a\u00020@2\u0006\u0010J\u001a\u00020\"2\u0006\u0010F\u001a\u00020\"J\u0006\u0010K\u001a\u00020@J\u0006\u0010L\u001a\u00020@J\u000e\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020(J\u0006\u0010P\u001a\u00020@J\b\u0010Q\u001a\u00020@H\u0014R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010*\"\u0004\b5\u0010,R\u001a\u00106\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010*\"\u0004\b8\u0010,R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b;\u0010<¨\u0006S"}, d2 = {"Lcom/qiahao/nextvideo/room/view/RocketSvgaCountdownView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mContext", "mRocketList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/RocketResultBean;", "Lkotlin/collections/ArrayList;", "getMRocketList", "()Ljava/util/ArrayList;", "countdownViewListener", "Lcom/qiahao/nextvideo/room/view/RocketSvgaCountdownViewListener;", "getCountdownViewListener", "()Lcom/qiahao/nextvideo/room/view/RocketSvgaCountdownViewListener;", "setCountdownViewListener", "(Lcom/qiahao/nextvideo/room/view/RocketSvgaCountdownViewListener;)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewRocketSvgaCountDownBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewRocketSvgaCountDownBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewRocketSvgaCountDownBinding;)V", "mCurrentPlayRocketResultBean", "getMCurrentPlayRocketResultBean", "()Lcom/qiahao/nextvideo/data/model/RocketResultBean;", "setMCurrentPlayRocketResultBean", "(Lcom/qiahao/nextvideo/data/model/RocketResultBean;)V", "mIsPlaySVGA", "", "getMIsPlaySVGA", "()Z", "setMIsPlaySVGA", "(Z)V", "mFirstPlay", "", "getMFirstPlay", "()I", "setMFirstPlay", "(I)V", "mUiHandler", "Lcom/qiahao/nextvideo/room/view/UiHandler;", "getMUiHandler", "()Lcom/qiahao/nextvideo/room/view/UiHandler;", "setMUiHandler", "(Lcom/qiahao/nextvideo/room/view/UiHandler;)V", "clickSum", "getClickSum", "setClickSum", "playSum", "getPlaySum", "setPlaySum", "parser", "Lcom/opensource/svgaplayer/SVGAParser;", "getParser", "()Lcom/opensource/svgaplayer/SVGAParser;", "parser$delegate", "Lkotlin/Lazy;", "initView", "", "setListener", "rocketSvgaCountdownViewListener", "setData", "rocketList", "", "isFirst", "stopRocket", "sendToPlaySvga", "countDownNext", "isStart", "playSvga", "stopSvga", "getSvgaType", "", "random", "release", "onDetachedFromWindow", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRocketSvgaCountdownView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RocketSvgaCountdownView.kt\ncom/qiahao/nextvideo/room/view/RocketSvgaCountdownView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,346:1\n1869#2,2:347\n*S KotlinDebug\n*F\n+ 1 RocketSvgaCountdownView.kt\ncom/qiahao/nextvideo/room/view/RocketSvgaCountdownView\n*L\n98#1:347,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RocketSvgaCountdownView extends FrameLayout {

    @NotNull
    public static final String TAG = "RocketSvgaCountdownView";
    public ViewRocketSvgaCountDownBinding binding;
    private int clickSum;

    @Nullable
    private RocketSvgaCountdownViewListener countdownViewListener;

    @NotNull
    private Context mContext;

    @Nullable
    private RocketResultBean mCurrentPlayRocketResultBean;
    private int mFirstPlay;
    private boolean mIsPlaySVGA;

    @NotNull
    private final ArrayList<RocketResultBean> mRocketList;

    @Nullable
    private UiHandler mUiHandler;

    /* renamed from: parser$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy parser;
    private int playSum;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RocketSvgaCountdownView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final SVGAParser getParser() {
        return (SVGAParser) this.parser.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SVGAParser parser_delegate$lambda$0() {
        return SVGAParser.Companion.shareParser();
    }

    public final void countDownNext(boolean isStart, boolean isFirst) {
        Integer num;
        int i;
        if (isStart) {
            RocketResultBean rocketResultBean = this.mCurrentPlayRocketResultBean;
            if (rocketResultBean != null) {
                num = Integer.valueOf(rocketResultBean.getRemainTime());
            } else {
                num = null;
            }
            Log.d(TAG, "countDownNext: 重新倒计时 " + num);
            UiHandler uiHandler = this.mUiHandler;
            if (uiHandler != null) {
                if (isFirst) {
                    i = this.mFirstPlay;
                } else {
                    i = 10;
                }
                uiHandler.setCountDown(i);
            }
            UiHandler uiHandler2 = this.mUiHandler;
            if (uiHandler2 != null) {
                uiHandler2.removeMessages(2);
            }
            Message obtain = Message.obtain();
            obtain.what = 2;
            UiHandler uiHandler3 = this.mUiHandler;
            if (uiHandler3 != null) {
                uiHandler3.sendMessage(obtain);
            }
        } else {
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            UiHandler uiHandler4 = this.mUiHandler;
            if (uiHandler4 != null) {
                uiHandler4.sendMessageDelayed(obtain2, 1000L);
            }
        }
        Log.d(TAG, "countDownNext: 倒计时");
    }

    @NotNull
    public final ViewRocketSvgaCountDownBinding getBinding() {
        ViewRocketSvgaCountDownBinding viewRocketSvgaCountDownBinding = this.binding;
        if (viewRocketSvgaCountDownBinding != null) {
            return viewRocketSvgaCountDownBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final int getClickSum() {
        return this.clickSum;
    }

    @Nullable
    public final RocketSvgaCountdownViewListener getCountdownViewListener() {
        return this.countdownViewListener;
    }

    @Nullable
    public final RocketResultBean getMCurrentPlayRocketResultBean() {
        return this.mCurrentPlayRocketResultBean;
    }

    public final int getMFirstPlay() {
        return this.mFirstPlay;
    }

    public final boolean getMIsPlaySVGA() {
        return this.mIsPlaySVGA;
    }

    @NotNull
    public final ArrayList<RocketResultBean> getMRocketList() {
        return this.mRocketList;
    }

    @Nullable
    public final UiHandler getMUiHandler() {
        return this.mUiHandler;
    }

    public final int getPlaySum() {
        return this.playSum;
    }

    @NotNull
    public final String getSvgaType(int random) {
        if (random == 0) {
            return "svga/svga_rocket_green.svga";
        }
        if (random != 1) {
            if (random != 2) {
                if (random != 3) {
                    if (random != 4) {
                        return "svga/svga_rocket_green.svga";
                    }
                    return "svga/svga_rocket_orange.svga";
                }
                return "svga/svga_rocket_purple.svga";
            }
            return "svga/svga_rocket_red.svga";
        }
        return "svga/svga_rocket_blue.svga";
    }

    public final void initView() {
        setBinding(ViewRocketSvgaCountDownBinding.inflate(LayoutInflater.from(this.mContext), this, true));
        getBinding().bigSvga.setCallback(new SVGACallback() { // from class: com.qiahao.nextvideo.room.view.RocketSvgaCountdownView$initView$1
            public void onFinished() {
                RocketSvgaCountdownView.this.setMIsPlaySVGA(false);
                Log.d(RocketSvgaCountdownView.TAG, "onFinished: ");
            }

            public void onPause() {
            }

            public void onRepeat() {
            }

            public void onStep(int frame, double percentage) {
            }
        });
        this.mUiHandler = new UiHandler(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    public final void playSvga() {
        if (this.mRocketList.isEmpty()) {
            return;
        }
        this.mIsPlaySVGA = true;
        RocketResultBean remove = this.mRocketList.remove(0);
        this.mCurrentPlayRocketResultBean = remove;
        if (remove == null) {
            return;
        }
        try {
            SVGAParser parser = getParser();
            RocketResultBean rocketResultBean = this.mCurrentPlayRocketResultBean;
            Intrinsics.checkNotNull(rocketResultBean);
            parser.decodeFromAssets(getSvgaType(rocketResultBean.getStage()), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.view.RocketSvgaCountdownView$playSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    String str;
                    TopContributor topContributor;
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                    Drawable sVGADrawable = new SVGADrawable(videoItem, sVGADynamicEntity);
                    RocketResultBean mCurrentPlayRocketResultBean = RocketSvgaCountdownView.this.getMCurrentPlayRocketResultBean();
                    if (mCurrentPlayRocketResultBean != null && (topContributor = mCurrentPlayRocketResultBean.getTopContributor()) != null) {
                        str = topContributor.getAvatar();
                    } else {
                        str = null;
                    }
                    if (str != null && StringKtxKt.isUrl(str)) {
                        sVGADynamicEntity.setDynamicImage(ImageSizeKt.imageCircle(str, 100), SVGAUtil.SENDER_AVATAR);
                    }
                    RocketSvgaCountdownView.this.getBinding().bigSvga.stopAnimation();
                    Log.d(RocketSvgaCountdownView.TAG, "onComplete:  giftSvgaList播放");
                    RocketSvgaCountdownView.this.getBinding().bigSvga.setLoops(-1);
                    RocketSvgaCountdownView.this.getBinding().bigSvga.setImageDrawable(sVGADrawable);
                    RocketSvgaCountdownView.this.getBinding().bigSvga.startAnimation();
                }

                public void onError() {
                    RocketSvgaCountdownView.this.setMIsPlaySVGA(false);
                }
            });
        } catch (Exception unused) {
            this.mIsPlaySVGA = false;
            Log.d(TAG, "initObserve: svga相关问题");
        }
    }

    public final void release() {
        this.countdownViewListener = null;
        UiHandler uiHandler = this.mUiHandler;
        if (uiHandler != null) {
            uiHandler.removeCallbacksAndMessages(null);
        }
        this.mUiHandler = null;
    }

    public final void sendToPlaySvga(boolean isFirst) {
        if (!this.mRocketList.isEmpty()) {
            Log.d(TAG, "sendToPlaySvga: 发送开发播放svga");
            Message obtain = Message.obtain();
            obtain.what = 1;
            UiHandler uiHandler = this.mUiHandler;
            if (uiHandler != null) {
                uiHandler.sendMessage(obtain);
            }
            countDownNext(true, isFirst);
            return;
        }
        Log.d(TAG, "sendToPlaySvga: 发送开发播放svga失败");
    }

    public final void setBinding(@NotNull ViewRocketSvgaCountDownBinding viewRocketSvgaCountDownBinding) {
        Intrinsics.checkNotNullParameter(viewRocketSvgaCountDownBinding, "<set-?>");
        this.binding = viewRocketSvgaCountDownBinding;
    }

    public final void setClickSum(int i) {
        this.clickSum = i;
    }

    public final void setCountdownViewListener(@Nullable RocketSvgaCountdownViewListener rocketSvgaCountdownViewListener) {
        this.countdownViewListener = rocketSvgaCountdownViewListener;
    }

    public final void setData(@Nullable List<RocketResultBean> rocketList, boolean isFirst) {
        String str;
        RocketResultBean rocketResultBean;
        RocketResultBean rocketResultBean2;
        if (rocketList == null) {
            return;
        }
        List mutableList = CollectionsKt.toMutableList(rocketList);
        if (!this.mRocketList.isEmpty()) {
            for (RocketResultBean rocketResultBean3 : this.mRocketList) {
                Iterator it = mutableList.iterator();
                while (it.hasNext()) {
                    RocketResultBean rocketResultBean4 = (RocketResultBean) it.next();
                    if (Intrinsics.areEqual(rocketResultBean4.getGroupId(), rocketResultBean3.getGroupId()) && Intrinsics.areEqual(rocketResultBean4.getPeriod(), rocketResultBean3.getPeriod()) && rocketResultBean4.getRound() == rocketResultBean3.getRound() && rocketResultBean4.getStage() == rocketResultBean3.getStage()) {
                        it.remove();
                    }
                }
            }
        }
        if (this.mCurrentPlayRocketResultBean != null) {
            Iterator it2 = mutableList.iterator();
            while (it2.hasNext()) {
                RocketResultBean rocketResultBean5 = (RocketResultBean) it2.next();
                String groupId = rocketResultBean5.getGroupId();
                RocketResultBean rocketResultBean6 = this.mCurrentPlayRocketResultBean;
                String str2 = null;
                if (rocketResultBean6 != null) {
                    str = rocketResultBean6.getGroupId();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(groupId, str)) {
                    String period = rocketResultBean5.getPeriod();
                    RocketResultBean rocketResultBean7 = this.mCurrentPlayRocketResultBean;
                    if (rocketResultBean7 != null) {
                        str2 = rocketResultBean7.getPeriod();
                    }
                    if (Intrinsics.areEqual(period, str2) && (rocketResultBean = this.mCurrentPlayRocketResultBean) != null && rocketResultBean5.getRound() == rocketResultBean.getRound() && (rocketResultBean2 = this.mCurrentPlayRocketResultBean) != null && rocketResultBean5.getStage() == rocketResultBean2.getStage()) {
                        it2.remove();
                        Log.d(TAG, "addData: 清除新来的数据包含了现在播放的数据 当前数组size=" + mutableList.size() + " " + rocketResultBean5.getGroupId() + " " + rocketResultBean5.getPeriod() + " " + rocketResultBean5.getRound() + " " + rocketResultBean5.getStage());
                    }
                }
            }
        }
        if (mutableList.isEmpty()) {
            Log.d(TAG, "addData: 没有数据 返回。。。。");
            return;
        }
        this.mRocketList.addAll(mutableList);
        if (isFirst) {
            this.mFirstPlay = this.mRocketList.get(0).getRemainTime();
            Log.d(TAG, "setData: 第一次获取到数据");
        } else {
            Log.d(TAG, "setData: 非第一次获取数据");
        }
        if (!this.mIsPlaySVGA) {
            sendToPlaySvga(isFirst);
        } else {
            Log.d(TAG, "addData: 播放中，等待下次播放");
        }
    }

    public final void setListener(@NotNull RocketSvgaCountdownViewListener rocketSvgaCountdownViewListener) {
        Intrinsics.checkNotNullParameter(rocketSvgaCountdownViewListener, "rocketSvgaCountdownViewListener");
        this.countdownViewListener = rocketSvgaCountdownViewListener;
    }

    public final void setMCurrentPlayRocketResultBean(@Nullable RocketResultBean rocketResultBean) {
        this.mCurrentPlayRocketResultBean = rocketResultBean;
    }

    public final void setMFirstPlay(int i) {
        this.mFirstPlay = i;
    }

    public final void setMIsPlaySVGA(boolean z) {
        this.mIsPlaySVGA = z;
    }

    public final void setMUiHandler(@Nullable UiHandler uiHandler) {
        this.mUiHandler = uiHandler;
    }

    public final void setPlaySum(int i) {
        this.playSum = i;
    }

    public final void stopRocket() {
        this.mIsPlaySVGA = false;
        getBinding().bigSvga.clear();
        this.mRocketList.clear();
        UiHandler uiHandler = this.mUiHandler;
        if (uiHandler != null) {
            uiHandler.removeCallbacksAndMessages(null);
        }
        getBinding().countDownText.setVisibility(8);
    }

    public final void stopSvga() {
        getBinding().bigSvga.stopAnimation();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RocketSvgaCountdownView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mContext = context2;
        this.mRocketList = new ArrayList<>();
        this.mFirstPlay = 10;
        this.parser = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.view.x
            public final Object invoke() {
                SVGAParser parser_delegate$lambda$0;
                parser_delegate$lambda$0 = RocketSvgaCountdownView.parser_delegate$lambda$0();
                return parser_delegate$lambda$0;
            }
        });
        initView();
    }
}
