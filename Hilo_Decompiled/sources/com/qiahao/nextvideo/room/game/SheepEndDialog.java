package com.qiahao.nextvideo.room.game;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogSheepEndBinding;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010$\u001a\u00020%H\u0014J\b\u0010&\u001a\u00020'H\u0014J\b\u0010(\u001a\u00020\u0013H\u0016J\b\u0010)\u001a\u00020\u0013H\u0016J\b\u0010*\u001a\u00020\u0013H\u0016J\b\u0010+\u001a\u00020\u0013H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR7\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006-"}, d2 = {"Lcom/qiahao/nextvideo/room/game/SheepEndDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogSheepEndBinding;", "context", "Landroid/content/Context;", "ludoGameAward", "LuserProxy/UserProxy1$SheepGameResult;", "<init>", "(Landroid/content/Context;LuserProxy/UserProxy1$SheepGameResult;)V", "getLudoGameAward", "()LuserProxy/UserProxy1$SheepGameResult;", "setLudoGameAward", "(LuserProxy/UserProxy1$SheepGameResult;)V", "listener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "type", "", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "adapter", "Lcom/qiahao/nextvideo/room/game/SheepEndAdapter;", "getAdapter", "()Lcom/qiahao/nextvideo/room/game/SheepEndAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "timerTask", "Landroid/os/CountDownTimer;", "getTimerTask", "()Landroid/os/CountDownTimer;", "setTimerTask", "(Landroid/os/CountDownTimer;)V", "getLayoutResId", "", "isNeedFullScreen", "", "onInitialize", "dismiss", "onBackPressed", "show", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSheepEndDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SheepEndDialog.kt\ncom/qiahao/nextvideo/room/game/SheepEndDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,97:1\n61#2,9:98\n61#2,9:107\n*S KotlinDebug\n*F\n+ 1 SheepEndDialog.kt\ncom/qiahao/nextvideo/room/game/SheepEndDialog\n*L\n68#1:98,9\n73#1:107,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SheepEndDialog extends BaseBindingDialog<DialogSheepEndBinding> {

    @NotNull
    public static final String BACK_PRESSED = "back_pressed";

    @NotNull
    public static final String CLOSE_GAME = "close_game";

    @NotNull
    public static final String ONCE_AGAIN = "once_again";

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter;

    @Nullable
    private Function1<? super String, Unit> listener;

    @NotNull
    private UserProxy1.SheepGameResult ludoGameAward;

    @Nullable
    private CountDownTimer timerTask;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SheepEndDialog(@NotNull Context context, @NotNull UserProxy1.SheepGameResult sheepGameResult) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sheepGameResult, "ludoGameAward");
        this.ludoGameAward = sheepGameResult;
        this.adapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.game.g0
            public final Object invoke() {
                SheepEndAdapter adapter_delegate$lambda$0;
                adapter_delegate$lambda$0 = SheepEndDialog.adapter_delegate$lambda$0();
                return adapter_delegate$lambda$0;
            }
        });
    }

    public static final /* synthetic */ DialogSheepEndBinding access$getBinding(SheepEndDialog sheepEndDialog) {
        return (DialogSheepEndBinding) sheepEndDialog.getBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SheepEndAdapter adapter_delegate$lambda$0() {
        return new SheepEndAdapter();
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
    public final SheepEndAdapter getAdapter() {
        return (SheepEndAdapter) this.adapter.getValue();
    }

    protected int getLayoutResId() {
        return R.layout.dialog_sheep_end;
    }

    @Nullable
    public final Function1<String, Unit> getListener() {
        return this.listener;
    }

    @NotNull
    public final UserProxy1.SheepGameResult getLudoGameAward() {
        return this.ludoGameAward;
    }

    @Nullable
    public final CountDownTimer getTimerTask() {
        return this.timerTask;
    }

    protected boolean isNeedFullScreen() {
        return true;
    }

    public void onBackPressed() {
        Function1<? super String, Unit> function1 = this.listener;
        if (function1 != null) {
            function1.invoke(BACK_PRESSED);
        }
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        this.timerTask = new CountDownTimer() { // from class: com.qiahao.nextvideo.room.game.SheepEndDialog$onInitialize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(5000L, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                SheepEndDialog.this.setTimerTask(null);
                Function1<String, Unit> listener = SheepEndDialog.this.getListener();
                if (listener != null) {
                    listener.invoke(SheepEndDialog.CLOSE_GAME);
                }
                SheepEndDialog.this.dismiss();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                String valueOf;
                if (millisUntilFinished < 1000) {
                    valueOf = MessageService.MSG_DB_READY_REPORT;
                } else {
                    valueOf = String.valueOf((int) (millisUntilFinished / 1000));
                }
                SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(new SpannableTextBuilder(SheepEndDialog.access$getBinding(SheepEndDialog.this).close), ResourcesKtxKt.getStringById(this, 2131952968), (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 254, (Object) null), "(", Integer.valueOf(androidx.core.content.a.getColor(SheepEndDialog.this.getContext(), 2131101137)), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 252, (Object) null), valueOf + "s", Integer.valueOf(androidx.core.content.a.getColor(SheepEndDialog.this.getContext(), 2131101137)), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 252, (Object) null), ")", Integer.valueOf(androidx.core.content.a.getColor(SheepEndDialog.this.getContext(), 2131101137)), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 252, (Object) null).apply();
            }
        };
        final TextView textView = ((DialogSheepEndBinding) getBinding()).close;
        final long j = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.game.SheepEndDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    Function1<String, Unit> listener = this.getListener();
                    if (listener != null) {
                        listener.invoke(SheepEndDialog.CLOSE_GAME);
                    }
                    this.dismiss();
                }
            }
        });
        final TextView textView2 = ((DialogSheepEndBinding) getBinding()).playAgain;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.game.SheepEndDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    Function1<String, Unit> listener = this.getListener();
                    if (listener != null) {
                        listener.invoke(SheepEndDialog.ONCE_AGAIN);
                    }
                    this.dismiss();
                }
            }
        });
        ((DialogSheepEndBinding) getBinding()).recyclerView.setAdapter(getAdapter());
        List<UserProxy1.SheepGamePlayer> playersList = this.ludoGameAward.getPlayersList();
        if (playersList != null) {
            getAdapter().setList(playersList);
        }
    }

    public final void setListener(@Nullable Function1<? super String, Unit> function1) {
        this.listener = function1;
    }

    public final void setLudoGameAward(@NotNull UserProxy1.SheepGameResult sheepGameResult) {
        Intrinsics.checkNotNullParameter(sheepGameResult, "<set-?>");
        this.ludoGameAward = sheepGameResult;
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
}
