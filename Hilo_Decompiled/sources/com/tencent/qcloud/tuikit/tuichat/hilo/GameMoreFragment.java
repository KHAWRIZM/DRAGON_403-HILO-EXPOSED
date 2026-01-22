package com.tencent.qcloud.tuikit.tuichat.hilo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.tencent.qcloud.tuicore.component.fragments.BaseFragment;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloGameFragmentBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.adapter.GameAdapter;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.game.GameData;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\nH\u0002J-\u0010+\u001a\u00020\n2%\b\u0002\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005J\b\u0010-\u001a\u00020\nH\u0016R7\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R+\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\u001f\u0010 ¨\u0006."}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/GameMoreFragment;", "Lcom/tencent/qcloud/tuicore/component/fragments/BaseFragment;", "<init>", "()V", "mListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", GameMatchActivity.GAME_ID, "", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloGameFragmentBinding;", "getBinding", "()Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloGameFragmentBinding;", "setBinding", "(Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloGameFragmentBinding;)V", "gameList", "Ljava/util/ArrayList;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/game/GameData;", "Lkotlin/collections/ArrayList;", "getGameList", "()Ljava/util/ArrayList;", "gameList$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/adapter/GameAdapter;", "getAdapter", "()Lcom/tencent/qcloud/tuikit/tuichat/hilo/adapter/GameAdapter;", "adapter$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "setClickListener", "listener", "onDestroyView", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class GameMoreFragment extends BaseFragment {

    @Nullable
    private HiloGameFragmentBinding binding;

    @Nullable
    private Function1<? super Integer, Unit> mListener;

    /* renamed from: gameList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy gameList = LazyKt.lazy(new Function0() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.n
        public final Object invoke() {
            ArrayList gameList_delegate$lambda$0;
            gameList_delegate$lambda$0 = GameMoreFragment.gameList_delegate$lambda$0(GameMoreFragment.this);
            return gameList_delegate$lambda$0;
        }
    });

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter = LazyKt.lazy(new Function0() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.o
        public final Object invoke() {
            GameAdapter adapter_delegate$lambda$1;
            adapter_delegate$lambda$1 = GameMoreFragment.adapter_delegate$lambda$1();
            return adapter_delegate$lambda$1;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final GameAdapter adapter_delegate$lambda$1() {
        return new GameAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList gameList_delegate$lambda$0(GameMoreFragment gameMoreFragment) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new GameData(9, ResourcesKtxKt.getStringById(gameMoreFragment, R.string.sheep), R.drawable.sheep_im_icon));
        arrayList.add(new GameData(15, ResourcesKtxKt.getStringById(gameMoreFragment, R.string.snake), R.drawable.snake_im_icon));
        return arrayList;
    }

    private final void initView() {
        RecyclerView recyclerView;
        getAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.p
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                GameMoreFragment.initView$lambda$2(GameMoreFragment.this, baseQuickAdapter, view, i);
            }
        });
        HiloGameFragmentBinding hiloGameFragmentBinding = this.binding;
        if (hiloGameFragmentBinding != null && (recyclerView = hiloGameFragmentBinding.recyclerView) != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setList(getGameList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(GameMoreFragment gameMoreFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        GameData gameData = (GameData) gameMoreFragment.getAdapter().getData().get(i);
        Function1<? super Integer, Unit> function1 = gameMoreFragment.mListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(gameData.getGameId()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setClickListener$default(GameMoreFragment gameMoreFragment, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        gameMoreFragment.setClickListener(function1);
    }

    @NotNull
    public final GameAdapter getAdapter() {
        return (GameAdapter) this.adapter.getValue();
    }

    @Nullable
    public final HiloGameFragmentBinding getBinding() {
        return this.binding;
    }

    @NotNull
    public final ArrayList<GameData> getGameList() {
        return (ArrayList) this.gameList.getValue();
    }

    @Nullable
    public final Function1<Integer, Unit> getMListener() {
        return this.mListener;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.binding = HiloGameFragmentBinding.inflate(inflater, container, false);
        initView();
        HiloGameFragmentBinding hiloGameFragmentBinding = this.binding;
        if (hiloGameFragmentBinding != null) {
            return hiloGameFragmentBinding.getRoot();
        }
        return null;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public final void setBinding(@Nullable HiloGameFragmentBinding hiloGameFragmentBinding) {
        this.binding = hiloGameFragmentBinding;
    }

    public final void setClickListener(@Nullable Function1<? super Integer, Unit> listener) {
        this.mListener = listener;
    }

    public final void setMListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.mListener = function1;
    }
}
