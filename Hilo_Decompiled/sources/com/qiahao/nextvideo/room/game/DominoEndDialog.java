package com.qiahao.nextvideo.room.game;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.game.SUDGameAward;
import com.qiahao.nextvideo.data.game.SUDGamePlayerAward;
import com.qiahao.nextvideo.databinding.DialogDominoEndBinding;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010%\u001a\u00020&H\u0014J\b\u0010'\u001a\u00020\bH\u0014J\b\u0010(\u001a\u00020\u0014H\u0016J\b\u0010)\u001a\u00020\u0014H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006+"}, d2 = {"Lcom/qiahao/nextvideo/room/game/DominoEndDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogDominoEndBinding;", "context", "Landroid/content/Context;", "ludoGameAward", "Lcom/qiahao/nextvideo/data/game/SUDGameAward;", "isGameLobby", "", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/game/SUDGameAward;Z)V", "getLudoGameAward", "()Lcom/qiahao/nextvideo/data/game/SUDGameAward;", "setLudoGameAward", "(Lcom/qiahao/nextvideo/data/game/SUDGameAward;)V", "()Z", "setGameLobby", "(Z)V", "listener", "Lkotlin/Function0;", "", "getListener", "()Lkotlin/jvm/functions/Function0;", "setListener", "(Lkotlin/jvm/functions/Function0;)V", "adapter", "Lcom/qiahao/nextvideo/room/game/DominoEndAdapter;", "getAdapter", "()Lcom/qiahao/nextvideo/room/game/DominoEndAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "timerTask", "Landroid/os/CountDownTimer;", "getTimerTask", "()Landroid/os/CountDownTimer;", "setTimerTask", "(Landroid/os/CountDownTimer;)V", "getLayoutResId", "", "isNeedFullScreen", "onInitialize", "dismiss", "show", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDominoEndDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DominoEndDialog.kt\ncom/qiahao/nextvideo/room/game/DominoEndDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,102:1\n61#2,9:103\n61#2,9:112\n61#2,9:121\n*S KotlinDebug\n*F\n+ 1 DominoEndDialog.kt\ncom/qiahao/nextvideo/room/game/DominoEndDialog\n*L\n41#1:103,9\n78#1:112,9\n82#1:121,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DominoEndDialog extends BaseBindingDialog<DialogDominoEndBinding> {

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter;
    private boolean isGameLobby;

    @Nullable
    private Function0<Unit> listener;

    @NotNull
    private SUDGameAward ludoGameAward;

    @Nullable
    private CountDownTimer timerTask;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DominoEndDialog(@NotNull Context context, @NotNull SUDGameAward sUDGameAward, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sUDGameAward, "ludoGameAward");
        this.ludoGameAward = sUDGameAward;
        this.isGameLobby = z;
        this.adapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.game.d0
            public final Object invoke() {
                DominoEndAdapter adapter_delegate$lambda$0;
                adapter_delegate$lambda$0 = DominoEndDialog.adapter_delegate$lambda$0();
                return adapter_delegate$lambda$0;
            }
        });
    }

    public static final /* synthetic */ DialogDominoEndBinding access$getBinding(DominoEndDialog dominoEndDialog) {
        return (DialogDominoEndBinding) dominoEndDialog.getBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DominoEndAdapter adapter_delegate$lambda$0() {
        return new DominoEndAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$5(DominoEndDialog dominoEndDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
    }

    public void dismiss() {
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timerTask = null;
        super.dismiss();
    }

    @NotNull
    public final DominoEndAdapter getAdapter() {
        return (DominoEndAdapter) this.adapter.getValue();
    }

    protected int getLayoutResId() {
        return R.layout.dialog_domino_end;
    }

    @Nullable
    public final Function0<Unit> getListener() {
        return this.listener;
    }

    @NotNull
    public final SUDGameAward getLudoGameAward() {
        return this.ludoGameAward;
    }

    @Nullable
    public final CountDownTimer getTimerTask() {
        return this.timerTask;
    }

    /* renamed from: isGameLobby, reason: from getter */
    public final boolean getIsGameLobby() {
        return this.isGameLobby;
    }

    protected boolean isNeedFullScreen() {
        return true;
    }

    public void onInitialize() {
        String str;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        final FrameLayout frameLayout = ((DialogDominoEndBinding) getBinding()).rootLayout;
        final long j = 800;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.game.DominoEndDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        this.timerTask = new CountDownTimer() { // from class: com.qiahao.nextvideo.room.game.DominoEndDialog$onInitialize$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(5000L, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                DominoEndDialog.this.setTimerTask(null);
                DominoEndDialog.this.dismiss();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                String valueOf;
                if (millisUntilFinished < 1000) {
                    valueOf = MessageService.MSG_DB_READY_REPORT;
                } else {
                    valueOf = String.valueOf((int) (millisUntilFinished / 1000));
                }
                SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(new SpannableTextBuilder(DominoEndDialog.access$getBinding(DominoEndDialog.this).close), ResourcesKtxKt.getStringById(this, 2131952968), (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 254, (Object) null), "(", Integer.valueOf(androidx.core.content.a.getColor(DominoEndDialog.this.getContext(), 2131101137)), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 252, (Object) null), valueOf + "s", Integer.valueOf(androidx.core.content.a.getColor(DominoEndDialog.this.getContext(), 2131101137)), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 252, (Object) null), ")", Integer.valueOf(androidx.core.content.a.getColor(DominoEndDialog.this.getContext(), 2131101137)), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 252, (Object) null).apply();
            }
        };
        String ownerId = this.ludoGameAward.getOwnerId();
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(ownerId, str) && !this.isGameLobby) {
            ((DialogDominoEndBinding) getBinding()).playAgain.setVisibility(8);
        } else {
            ((DialogDominoEndBinding) getBinding()).playAgain.setVisibility(0);
        }
        ArrayList<SUDGamePlayerAward> players = this.ludoGameAward.getPlayers();
        if (players != null) {
            getAdapter().setList(players);
        }
        final TextView textView = ((DialogDominoEndBinding) getBinding()).close;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.game.DominoEndDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        final TextView textView2 = ((DialogDominoEndBinding) getBinding()).playAgain;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.game.DominoEndDialog$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    Function0<Unit> listener = this.getListener();
                    if (listener != null) {
                        listener.invoke();
                    }
                }
            }
        });
        ((DialogDominoEndBinding) getBinding()).recyclerView.setAdapter(getAdapter());
        getAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.game.c0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                DominoEndDialog.onInitialize$lambda$5(DominoEndDialog.this, baseQuickAdapter, view, i);
            }
        });
    }

    public final void setGameLobby(boolean z) {
        this.isGameLobby = z;
    }

    public final void setListener(@Nullable Function0<Unit> function0) {
        this.listener = function0;
    }

    public final void setLudoGameAward(@NotNull SUDGameAward sUDGameAward) {
        Intrinsics.checkNotNullParameter(sUDGameAward, "<set-?>");
        this.ludoGameAward = sUDGameAward;
    }

    public final void setTimerTask(@Nullable CountDownTimer countDownTimer) {
        this.timerTask = countDownTimer;
    }

    public void show() {
        super/*com.oudi.core.component.SuperDialog*/.show();
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    public /* synthetic */ DominoEndDialog(Context context, SUDGameAward sUDGameAward, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, sUDGameAward, (i & 4) != 0 ? false : z);
    }
}
