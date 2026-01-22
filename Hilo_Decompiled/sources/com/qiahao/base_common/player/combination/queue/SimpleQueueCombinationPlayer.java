package com.qiahao.base_common.player.combination.queue;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.oudi.utils.log.ILog;
import com.qiahao.base_common.player.IPlayer;
import com.qiahao.base_common.player.PlayerMediaSource;
import com.qiahao.base_common.player.PlayerState;
import com.qiahao.base_common.player.combination.CombinationPlayer;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000eJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00112\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001b0\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0017H\u0017J\b\u0010%\u001a\u00020\u0017H\u0016R!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, d2 = {"Lcom/qiahao/base_common/player/combination/queue/SimpleQueueCombinationPlayer;", "Lcom/qiahao/base_common/player/combination/CombinationPlayer;", "Lcom/qiahao/base_common/player/combination/queue/IQueueCombinationPlayer;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "sourceQueue", "Ljava/util/LinkedList;", "Lcom/qiahao/base_common/player/PlayerMediaSource;", "getSourceQueue", "()Ljava/util/LinkedList;", "sourceQueue$delegate", "Lkotlin/Lazy;", "addQueue", "", "source", "loopQueue", "isIdleState", "", "getFirstOrNullFromQueue", "predicate", "Lkotlin/Function1;", "isPlayEnd", "onPlayerStateChanged", "playWhenReady", "playbackState", "Lcom/qiahao/base_common/player/PlayerState;", "restart", "onCleared", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSimpleQueueCombinationPlayer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SimpleQueueCombinationPlayer.kt\ncom/qiahao/base_common/player/combination/queue/SimpleQueueCombinationPlayer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,98:1\n295#2,2:99\n1869#2,2:101\n*S KotlinDebug\n*F\n+ 1 SimpleQueueCombinationPlayer.kt\ncom/qiahao/base_common/player/combination/queue/SimpleQueueCombinationPlayer\n*L\n63#1:99,2\n92#1:101,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class SimpleQueueCombinationPlayer extends CombinationPlayer implements IQueueCombinationPlayer {

    /* renamed from: sourceQueue$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy sourceQueue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleQueueCombinationPlayer(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.sourceQueue = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                LinkedList sourceQueue_delegate$lambda$0;
                sourceQueue_delegate$lambda$0 = SimpleQueueCombinationPlayer.sourceQueue_delegate$lambda$0();
                return sourceQueue_delegate$lambda$0;
            }
        });
    }

    private final void loopQueue() {
        PlayerMediaSource poll;
        if (getSourceQueue().isEmpty()) {
            ILog.DefaultImpls.logD$default(this, "队列为空", null, false, 6, null);
        } else {
            if (!isPlayEnd() || (poll = getSourceQueue().poll()) == null) {
                return;
            }
            prepare(poll);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinkedList sourceQueue_delegate$lambda$0() {
        return new LinkedList();
    }

    @Override // com.qiahao.base_common.player.combination.queue.IQueueCombinationPlayer
    public void addQueue(@NotNull PlayerMediaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        ILog.DefaultImpls.logD$default(this, "addQueue() source:" + source, null, false, 6, null);
        getSourceQueue().add(source);
        loopQueue();
    }

    @Override // com.qiahao.base_common.player.combination.queue.IQueueCombinationPlayer
    @Nullable
    public PlayerMediaSource getFirstOrNullFromQueue(@NotNull Function1<? super PlayerMediaSource, Boolean> predicate) {
        Object obj;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Iterator<T> it = getSourceQueue().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (predicate.invoke(obj).booleanValue()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (PlayerMediaSource) obj;
    }

    @NotNull
    protected final LinkedList<PlayerMediaSource> getSourceQueue() {
        return (LinkedList) this.sourceQueue.getValue();
    }

    @Override // com.qiahao.base_common.player.combination.queue.IQueueCombinationPlayer
    public boolean isIdleState() {
        if (getSourceQueue().isEmpty() && isPlayEnd()) {
            return true;
        }
        return false;
    }

    public boolean isPlayEnd() {
        PlayerState playerState = getPlayerState();
        if (playerState != PlayerState.ENDED && playerState != PlayerState.IDLE) {
            return false;
        }
        return true;
    }

    @Override // com.qiahao.base_common.player.combination.CombinationPlayer, com.qiahao.base_common.player.IPlayer, com.oudi.utils.ICleared
    public void onCleared() {
        Iterator<T> it = getSourceQueue().iterator();
        while (it.hasNext()) {
            ((PlayerMediaSource) it.next()).onCleared();
        }
        getSourceQueue().clear();
        super.onCleared();
    }

    @Override // com.qiahao.base_common.player.combination.CombinationPlayer, com.qiahao.base_common.player.PlayerEventListener
    public void onPlayerStateChanged(boolean playWhenReady, @NotNull PlayerState playbackState) {
        View view;
        Intrinsics.checkNotNullParameter(playbackState, "playbackState");
        super.onPlayerStateChanged(playWhenReady, playbackState);
        if (isPlayEnd()) {
            ILog.DefaultImpls.logD$default(this, "onPlayerStateChanged() 当前源播放结束 playbackState：" + playbackState, null, false, 6, null);
            IPlayer currentPlayer = getCurrentPlayer();
            if (currentPlayer != null) {
                currentPlayer.setPlayerEventListener(null);
            }
            IPlayer currentPlayer2 = getCurrentPlayer();
            if (currentPlayer2 != null) {
                currentPlayer2.stop(true);
            }
            IPlayer currentPlayer3 = getCurrentPlayer();
            if (currentPlayer3 != null && (view = currentPlayer3.getView()) != null) {
                view.setVisibility(8);
            }
            setCurrentPlayer(null);
        }
        loopQueue();
    }

    @Override // com.qiahao.base_common.player.combination.CombinationPlayer, com.qiahao.base_common.player.combination.ICombinationPlayer, com.qiahao.base_common.player.IPlayer
    @Deprecated(message = "队列播放器时，暂不支持该方法。")
    public void restart() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleQueueCombinationPlayer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.sourceQueue = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                LinkedList sourceQueue_delegate$lambda$0;
                sourceQueue_delegate$lambda$0 = SimpleQueueCombinationPlayer.sourceQueue_delegate$lambda$0();
                return sourceQueue_delegate$lambda$0;
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleQueueCombinationPlayer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.sourceQueue = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                LinkedList sourceQueue_delegate$lambda$0;
                sourceQueue_delegate$lambda$0 = SimpleQueueCombinationPlayer.sourceQueue_delegate$lambda$0();
                return sourceQueue_delegate$lambda$0;
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleQueueCombinationPlayer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.sourceQueue = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                LinkedList sourceQueue_delegate$lambda$0;
                sourceQueue_delegate$lambda$0 = SimpleQueueCombinationPlayer.sourceQueue_delegate$lambda$0();
                return sourceQueue_delegate$lambda$0;
            }
        });
    }
}
