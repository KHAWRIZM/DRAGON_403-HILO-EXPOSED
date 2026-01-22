package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.gson.reflect.TypeToken;
import com.oudi.utils.log.LogUtil;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.databinding.DialogRoomGameBinding;
import com.qiahao.nextvideo.room.adapter.GameListAdapter;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b\u001e\u0010\u001aR\u001b\u0010 \u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001c\u001a\u0004\b!\u0010\u001a¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/RoomGameDialog;", "Lcom/qiahao/nextvideo/room/dialog/BaseBottomSheetDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/qiahao/nextvideo/databinding/DialogRoomGameBinding;", "mCurrentContext", "mListener", "Lcom/qiahao/nextvideo/room/dialog/RoomGamePanelListener;", "getMListener", "()Lcom/qiahao/nextvideo/room/dialog/RoomGamePanelListener;", "setMListener", "(Lcom/qiahao/nextvideo/room/dialog/RoomGamePanelListener;)V", AgooConstants.MESSAGE_TIME, "", "getTime", "()J", "setTime", "(J)V", "moreTouch", "", "mPartyAdapter", "Lcom/qiahao/nextvideo/room/adapter/GameListAdapter;", "getMPartyAdapter", "()Lcom/qiahao/nextvideo/room/adapter/GameListAdapter;", "mPartyAdapter$delegate", "Lkotlin/Lazy;", "mLuckyAdapter", "getMLuckyAdapter", "mLuckyAdapter$delegate", "mTogetherAdapter", "getMTogetherAdapter", "mTogetherAdapter$delegate", "initDataBinding", "", "dismiss", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomGameDialog extends BaseBottomSheetDialog {
    private DialogRoomGameBinding binding;

    @NotNull
    private Context mCurrentContext;

    @Nullable
    private RoomGamePanelListener mListener;

    /* renamed from: mLuckyAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mLuckyAdapter;

    /* renamed from: mPartyAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPartyAdapter;

    /* renamed from: mTogetherAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mTogetherAdapter;
    private int moreTouch;
    private long time;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomGameDialog(@NotNull Context context) {
        super(context, R.style.HiloBottomSheetDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentContext = context;
        this.time = System.currentTimeMillis();
        this.mPartyAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.a2
            public final Object invoke() {
                GameListAdapter mPartyAdapter_delegate$lambda$0;
                mPartyAdapter_delegate$lambda$0 = RoomGameDialog.mPartyAdapter_delegate$lambda$0();
                return mPartyAdapter_delegate$lambda$0;
            }
        });
        this.mLuckyAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.b2
            public final Object invoke() {
                GameListAdapter mLuckyAdapter_delegate$lambda$1;
                mLuckyAdapter_delegate$lambda$1 = RoomGameDialog.mLuckyAdapter_delegate$lambda$1();
                return mLuckyAdapter_delegate$lambda$1;
            }
        });
        this.mTogetherAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.c2
            public final Object invoke() {
                GameListAdapter mTogetherAdapter_delegate$lambda$2;
                mTogetherAdapter_delegate$lambda$2 = RoomGameDialog.mTogetherAdapter_delegate$lambda$2();
                return mTogetherAdapter_delegate$lambda$2;
            }
        });
    }

    private final GameListAdapter getMLuckyAdapter() {
        return (GameListAdapter) this.mLuckyAdapter.getValue();
    }

    private final GameListAdapter getMPartyAdapter() {
        return (GameListAdapter) this.mPartyAdapter.getValue();
    }

    private final GameListAdapter getMTogetherAdapter() {
        return (GameListAdapter) this.mTogetherAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDataBinding$lambda$3(RoomGameDialog roomGameDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        RoomGamePanelListener roomGamePanelListener = roomGameDialog.mListener;
        if (roomGamePanelListener != null) {
            roomGamePanelListener.clickGame((GameConfiguration) roomGameDialog.getMPartyAdapter().getData().get(i));
        }
        roomGameDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDataBinding$lambda$4(RoomGameDialog roomGameDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        RoomGamePanelListener roomGamePanelListener = roomGameDialog.mListener;
        if (roomGamePanelListener != null) {
            roomGamePanelListener.clickGame((GameConfiguration) roomGameDialog.getMLuckyAdapter().getData().get(i));
        }
        roomGameDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDataBinding$lambda$5(RoomGameDialog roomGameDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        RoomGamePanelListener roomGamePanelListener = roomGameDialog.mListener;
        if (roomGamePanelListener != null) {
            roomGamePanelListener.clickGame((GameConfiguration) roomGameDialog.getMTogetherAdapter().getData().get(i));
        }
        roomGameDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GameListAdapter mLuckyAdapter_delegate$lambda$1() {
        return new GameListAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GameListAdapter mPartyAdapter_delegate$lambda$0() {
        return new GameListAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GameListAdapter mTogetherAdapter_delegate$lambda$2() {
        return new GameListAdapter();
    }

    public void dismiss() {
        this.mListener = null;
        super/*androidx.appcompat.app.AppCompatDialog*/.dismiss();
    }

    @Nullable
    public final RoomGamePanelListener getMListener() {
        return this.mListener;
    }

    public final long getTime() {
        return this.time;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(25:1|(1:3)|4|(1:6)|7|(1:9)|10|(1:12)|13|14|15|(1:17)|18|(10:(19:23|24|25|26|27|(1:29)|30|(10:35|36|37|38|39|(1:41)(1:51)|42|(1:50)|46|48)|57|36|37|38|39|(0)(0)|42|(1:44)|50|46|48)|(12:32|35|36|37|38|39|(0)(0)|42|(0)|50|46|48)|38|39|(0)(0)|42|(0)|50|46|48)|62|24|25|26|27|(0)|30|57|36|37|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x011f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x013b, code lost:
    
        com.oudi.utils.log.LogUtil.e$default(com.oudi.utils.log.LogUtil.INSTANCE, "eTag", "解析数据出错" + r0.getMessage() + "               " + r7, false, 4, (java.lang.Object) null);
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x011a A[Catch: Exception -> 0x011f, TryCatch #1 {Exception -> 0x011f, blocks: (B:27:0x0101, B:29:0x011a, B:30:0x0121, B:32:0x0125, B:36:0x0130), top: B:26:0x0101 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0189 A[Catch: Exception -> 0x018d, TryCatch #2 {Exception -> 0x018d, blocks: (B:39:0x0170, B:41:0x0189, B:42:0x0190, B:44:0x0194, B:46:0x019c), top: B:38:0x0170 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0194 A[Catch: Exception -> 0x018d, TryCatch #2 {Exception -> 0x018d, blocks: (B:39:0x0170, B:41:0x0189, B:42:0x0190, B:44:0x0194, B:46:0x019c), top: B:38:0x0170 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x018f  */
    @Override // com.qiahao.nextvideo.room.dialog.BaseBottomSheetDialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initDataBinding() {
        ArrayList arrayList;
        DialogRoomGameBinding dialogRoomGameBinding;
        ArrayList arrayList2;
        DialogRoomGameBinding dialogRoomGameBinding2;
        int i;
        ArrayList arrayList3;
        TextView textView;
        int i2;
        DialogRoomGameBinding dialogRoomGameBinding3 = null;
        int i3 = 0;
        DialogRoomGameBinding dialogRoomGameBinding4 = (DialogRoomGameBinding) androidx.databinding.g.h(LayoutInflater.from(this.mCurrentContext), R.layout.dialog_room_game, (ViewGroup) null, false);
        this.binding = dialogRoomGameBinding4;
        if (dialogRoomGameBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogRoomGameBinding4 = null;
        }
        setContentView(dialogRoomGameBinding4.getRoot());
        DialogRoomGameBinding dialogRoomGameBinding5 = this.binding;
        if (dialogRoomGameBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogRoomGameBinding5 = null;
        }
        dialogRoomGameBinding5.partyRecyclerView.setAdapter(getMPartyAdapter());
        DialogRoomGameBinding dialogRoomGameBinding6 = this.binding;
        if (dialogRoomGameBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogRoomGameBinding6 = null;
        }
        dialogRoomGameBinding6.luckyRecyclerView.setAdapter(getMLuckyAdapter());
        DialogRoomGameBinding dialogRoomGameBinding7 = this.binding;
        if (dialogRoomGameBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogRoomGameBinding7 = null;
        }
        dialogRoomGameBinding7.togetherRecyclerView.setAdapter(getMTogetherAdapter());
        getMPartyAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.dialog.d2
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i4) {
                RoomGameDialog.initDataBinding$lambda$3(RoomGameDialog.this, baseQuickAdapter, view, i4);
            }
        });
        getMLuckyAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.dialog.e2
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i4) {
                RoomGameDialog.initDataBinding$lambda$4(RoomGameDialog.this, baseQuickAdapter, view, i4);
            }
        });
        getMTogetherAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.dialog.f2
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i4) {
                RoomGameDialog.initDataBinding$lambda$5(RoomGameDialog.this, baseQuickAdapter, view, i4);
            }
        });
        String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "game_party_list", "", (String) null, 4, (Object) null);
        try {
            arrayList3 = (ArrayList) BaseApplication.Companion.getGSON().k(str, new TypeToken<ArrayList<GameConfiguration>>() { // from class: com.qiahao.nextvideo.room.dialog.RoomGameDialog$initDataBinding$type$1
            }.getType());
            DialogRoomGameBinding dialogRoomGameBinding8 = this.binding;
            if (dialogRoomGameBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogRoomGameBinding8 = null;
            }
            textView = dialogRoomGameBinding8.partyTitle;
        } catch (Exception e) {
            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "解析数据出错" + e.getMessage() + "               " + str, false, 4, (Object) null);
        }
        try {
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                i2 = 0;
                textView.setVisibility(i2);
                getMPartyAdapter().setList(arrayList3);
                arrayList2 = (ArrayList) BaseApplication.Companion.getGSON().k((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "game_lucky_list", "", (String) null, 4, (Object) null), new TypeToken<ArrayList<GameConfiguration>>() { // from class: com.qiahao.nextvideo.room.dialog.RoomGameDialog$initDataBinding$type$2
                }.getType());
                dialogRoomGameBinding2 = this.binding;
                if (dialogRoomGameBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogRoomGameBinding2 = null;
                }
                TextView textView2 = dialogRoomGameBinding2.luckyTitle;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    i = 0;
                    textView2.setVisibility(i);
                    getMLuckyAdapter().setList(arrayList2);
                    arrayList = (ArrayList) BaseApplication.Companion.getGSON().k((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "game_together_list", "", (String) null, 4, (Object) null), new TypeToken<ArrayList<GameConfiguration>>() { // from class: com.qiahao.nextvideo.room.dialog.RoomGameDialog$initDataBinding$type$3
                    }.getType());
                    dialogRoomGameBinding = this.binding;
                    if (dialogRoomGameBinding != null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        dialogRoomGameBinding3 = dialogRoomGameBinding;
                    }
                    TextView textView3 = dialogRoomGameBinding3.togetherTitle;
                    if (arrayList != null || arrayList.isEmpty()) {
                        i3 = 8;
                    }
                    textView3.setVisibility(i3);
                    getMTogetherAdapter().setList(arrayList);
                    return;
                }
                i = 8;
                textView2.setVisibility(i);
                getMLuckyAdapter().setList(arrayList2);
                arrayList = (ArrayList) BaseApplication.Companion.getGSON().k((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "game_together_list", "", (String) null, 4, (Object) null), new TypeToken<ArrayList<GameConfiguration>>() { // from class: com.qiahao.nextvideo.room.dialog.RoomGameDialog$initDataBinding$type$3
                }.getType());
                dialogRoomGameBinding = this.binding;
                if (dialogRoomGameBinding != null) {
                }
                TextView textView32 = dialogRoomGameBinding3.togetherTitle;
                if (arrayList != null) {
                }
                i3 = 8;
                textView32.setVisibility(i3);
                getMTogetherAdapter().setList(arrayList);
                return;
            }
            if (arrayList2 != null) {
                i = 0;
                textView2.setVisibility(i);
                getMLuckyAdapter().setList(arrayList2);
                arrayList = (ArrayList) BaseApplication.Companion.getGSON().k((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "game_together_list", "", (String) null, 4, (Object) null), new TypeToken<ArrayList<GameConfiguration>>() { // from class: com.qiahao.nextvideo.room.dialog.RoomGameDialog$initDataBinding$type$3
                }.getType());
                dialogRoomGameBinding = this.binding;
                if (dialogRoomGameBinding != null) {
                }
                TextView textView322 = dialogRoomGameBinding3.togetherTitle;
                if (arrayList != null) {
                }
                i3 = 8;
                textView322.setVisibility(i3);
                getMTogetherAdapter().setList(arrayList);
                return;
            }
            arrayList = (ArrayList) BaseApplication.Companion.getGSON().k((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "game_together_list", "", (String) null, 4, (Object) null), new TypeToken<ArrayList<GameConfiguration>>() { // from class: com.qiahao.nextvideo.room.dialog.RoomGameDialog$initDataBinding$type$3
            }.getType());
            dialogRoomGameBinding = this.binding;
            if (dialogRoomGameBinding != null) {
            }
            TextView textView3222 = dialogRoomGameBinding3.togetherTitle;
            if (arrayList != null) {
            }
            i3 = 8;
            textView3222.setVisibility(i3);
            getMTogetherAdapter().setList(arrayList);
            return;
        } catch (Exception e2) {
            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "解析数据出错" + e2.getMessage() + "               " + str, false, 4, (Object) null);
            return;
        }
        i2 = 8;
        textView.setVisibility(i2);
        getMPartyAdapter().setList(arrayList3);
        arrayList2 = (ArrayList) BaseApplication.Companion.getGSON().k((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "game_lucky_list", "", (String) null, 4, (Object) null), new TypeToken<ArrayList<GameConfiguration>>() { // from class: com.qiahao.nextvideo.room.dialog.RoomGameDialog$initDataBinding$type$2
        }.getType());
        dialogRoomGameBinding2 = this.binding;
        if (dialogRoomGameBinding2 == null) {
        }
        TextView textView22 = dialogRoomGameBinding2.luckyTitle;
        i = 8;
        textView22.setVisibility(i);
        getMLuckyAdapter().setList(arrayList2);
    }

    public final void setMListener(@Nullable RoomGamePanelListener roomGamePanelListener) {
        this.mListener = roomGamePanelListener;
    }

    public final void setTime(long j) {
        this.time = j;
    }
}
