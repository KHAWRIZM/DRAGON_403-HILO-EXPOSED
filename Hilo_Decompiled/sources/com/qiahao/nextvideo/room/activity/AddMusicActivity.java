package com.qiahao.nextvideo.room.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityLocalAddMusicBinding;
import com.qiahao.nextvideo.room.adapter.LocalMusicAdapter;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.room.music.MusicLoader;
import com.qiahao.nextvideo.room.music.c;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001$B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0006J\u000f\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0006R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/AddMusicActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityLocalAddMusicBinding;", "Landroid/view/View$OnClickListener;", "Lcom/qiahao/nextvideo/room/music/c$b;", "<init>", "()V", "", "getLayoutResId", "()I", "", "onInitialize", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "event", "onRoomEvent", "(Lcom/qiahao/nextvideo/room/manager/RoomEvent;)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "onLoadingFinish", "onBackPressed", "Lcom/qiahao/nextvideo/room/music/c;", "mMusicManager", "Lcom/qiahao/nextvideo/room/music/c;", "Lcom/qiahao/nextvideo/room/adapter/LocalMusicAdapter;", "mLocalMusicAdapter$delegate", "Lkotlin/Lazy;", "getMLocalMusicAdapter", "()Lcom/qiahao/nextvideo/room/adapter/LocalMusicAdapter;", "mLocalMusicAdapter", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "mViewModel$delegate", "getMViewModel", "()Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "mViewModel", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAddMusicActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AddMusicActivity.kt\ncom/qiahao/nextvideo/room/activity/AddMusicActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,181:1\n1869#2,2:182\n*S KotlinDebug\n*F\n+ 1 AddMusicActivity.kt\ncom/qiahao/nextvideo/room/activity/AddMusicActivity\n*L\n139#1:182,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AddMusicActivity extends HiloBaseBindingActivity<ActivityLocalAddMusicBinding> implements View.OnClickListener, c.b {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "AddMusicActivity";

    @Nullable
    private com.qiahao.nextvideo.room.music.c mMusicManager;

    /* renamed from: mLocalMusicAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mLocalMusicAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.activity.a
        public final Object invoke() {
            LocalMusicAdapter mLocalMusicAdapter_delegate$lambda$0;
            mLocalMusicAdapter_delegate$lambda$0 = AddMusicActivity.mLocalMusicAdapter_delegate$lambda$0();
            return mLocalMusicAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.activity.b
        public final Object invoke() {
            BaseViewModel mViewModel_delegate$lambda$1;
            mViewModel_delegate$lambda$1 = AddMusicActivity.mViewModel_delegate$lambda$1(AddMusicActivity.this);
            return mViewModel_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/AddMusicActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "TAG", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) AddMusicActivity.class));
        }

        private Companion() {
        }
    }

    private final LocalMusicAdapter getMLocalMusicAdapter() {
        return (LocalMusicAdapter) this.mLocalMusicAdapter.getValue();
    }

    private final BaseViewModel getMViewModel() {
        return (BaseViewModel) this.mViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocalMusicAdapter mLocalMusicAdapter_delegate$lambda$0() {
        return new LocalMusicAdapter(R.layout.item_local_music);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseViewModel mViewModel_delegate$lambda$1(AddMusicActivity addMusicActivity) {
        return new ViewModelProvider(addMusicActivity).get(BaseViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$2(AddMusicActivity addMusicActivity, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = addMusicActivity.getBinding().titleBar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMargins(0, i, 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$4(AddMusicActivity addMusicActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        MusicLoader g;
        MusicLoader g2;
        List j;
        MusicLoader g3;
        MusicLoader g4;
        List i2;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        MusicLoader.MusicInfo musicInfo = (MusicLoader.MusicInfo) addMusicActivity.getMLocalMusicAdapter().getItem(i);
        com.qiahao.nextvideo.room.music.c cVar = addMusicActivity.mMusicManager;
        if (cVar != null && (g4 = cVar.g()) != null && (i2 = g4.i()) != null && i2.contains(Long.valueOf(musicInfo.c()))) {
            return;
        }
        com.qiahao.nextvideo.room.music.c cVar2 = addMusicActivity.mMusicManager;
        if (cVar2 != null && (g3 = cVar2.g()) != null) {
            g3.b(musicInfo);
        }
        com.qiahao.nextvideo.room.music.c cVar3 = addMusicActivity.mMusicManager;
        if (cVar3 != null && (g2 = cVar3.g()) != null && (j = g2.j()) != null && j.size() == 1) {
            MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().setEventId(RoomEvent.ROOM_MUSIC_ADD));
        }
        LocalMusicAdapter mLocalMusicAdapter = addMusicActivity.getMLocalMusicAdapter();
        com.qiahao.nextvideo.room.music.c cVar4 = addMusicActivity.mMusicManager;
        if (cVar4 != null && (g = cVar4.g()) != null) {
            copyOnWriteArrayList = g.h();
        } else {
            copyOnWriteArrayList = null;
        }
        mLocalMusicAdapter.setList(copyOnWriteArrayList);
        Log.d(TAG, "onCreate: " + musicInfo.c());
    }

    @JvmStatic
    public static final void start(@NotNull Context context) {
        INSTANCE.start(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_local_add_music;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onBackPressed() {
        com.qiahao.nextvideo.room.music.c cVar = this.mMusicManager;
        if (cVar != null) {
            cVar.removeOnLoadingListener(this);
        }
        super.onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        MusicLoader g;
        MusicLoader g2;
        MusicLoader g3;
        CopyOnWriteArrayList h;
        MusicLoader g4;
        List j;
        com.qiahao.nextvideo.room.music.c cVar;
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131362039) {
            if (id2 != 2131363588) {
                if (id2 == 2131364547 && (cVar = this.mMusicManager) != null) {
                    cVar.o();
                    return;
                }
                return;
            }
            com.qiahao.nextvideo.room.music.c cVar2 = this.mMusicManager;
            boolean z = false;
            if (cVar2 != null && (g4 = cVar2.g()) != null && (j = g4.j()) != null && j.isEmpty()) {
                z = true;
            }
            ArrayList arrayList = new ArrayList();
            com.qiahao.nextvideo.room.music.c cVar3 = this.mMusicManager;
            if (cVar3 != null && (g3 = cVar3.g()) != null && (h = g3.h()) != null) {
                Iterator it = h.iterator();
                while (it.hasNext()) {
                    arrayList.add((MusicLoader.MusicInfo) it.next());
                }
            }
            if (arrayList.size() > 0) {
                com.qiahao.nextvideo.room.music.c cVar4 = this.mMusicManager;
                if (cVar4 != null && (g2 = cVar4.g()) != null) {
                    g2.a(arrayList);
                }
                LocalMusicAdapter mLocalMusicAdapter = getMLocalMusicAdapter();
                com.qiahao.nextvideo.room.music.c cVar5 = this.mMusicManager;
                if (cVar5 != null && (g = cVar5.g()) != null) {
                    copyOnWriteArrayList = g.h();
                } else {
                    copyOnWriteArrayList = null;
                }
                mLocalMusicAdapter.setList(copyOnWriteArrayList);
                if (z) {
                    MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().setEventId(RoomEvent.ROOM_MUSIC_ADD));
                }
            } else {
                Log.d(TAG, "onClick: 没有选择的音乐");
            }
            ImageView imageView = ((ActivityLocalAddMusicBinding) getBinding()).oneKeySelect;
            Intrinsics.checkNotNullExpressionValue(imageView, "oneKeySelect");
            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_onkey_select_all_check), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            return;
        }
        com.qiahao.nextvideo.room.music.c cVar6 = this.mMusicManager;
        if (cVar6 != null) {
            cVar6.removeOnLoadingListener(this);
        }
        finish();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        Integer num;
        MusicLoader g;
        List j;
        MusicLoader g2;
        CopyOnWriteArrayList h;
        super.onInitialize();
        Toolbar toolbar = getBinding().titleBar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "titleBar");
        getStatusBarTopOrBottom(toolbar, new Function2() { // from class: com.qiahao.nextvideo.room.activity.c
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$2;
                onInitialize$lambda$2 = AddMusicActivity.onInitialize$lambda$2(AddMusicActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$2;
            }
        });
        setStatusBarIconColor(false);
        getBinding().setClick(this);
        RecyclerView recyclerView = getBinding().musicListView;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getMLocalMusicAdapter());
        getMLocalMusicAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.activity.d
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AddMusicActivity.onInitialize$lambda$4(AddMusicActivity.this, baseQuickAdapter, view, i);
            }
        });
        com.qiahao.nextvideo.room.music.c musicManager = MeetingRoomManager.INSTANCE.getMusicManager();
        this.mMusicManager = musicManager;
        if (musicManager != null) {
            musicManager.setOnLoadingListener(this);
        }
        com.qiahao.nextvideo.room.music.c cVar = this.mMusicManager;
        if (cVar != null) {
            cVar.o();
        }
        com.qiahao.nextvideo.room.music.c cVar2 = this.mMusicManager;
        Integer num2 = null;
        if (cVar2 != null && (g2 = cVar2.g()) != null && (h = g2.h()) != null) {
            num = Integer.valueOf(h.size());
        } else {
            num = null;
        }
        com.qiahao.nextvideo.room.music.c cVar3 = this.mMusicManager;
        if (cVar3 != null && (g = cVar3.g()) != null && (j = g.j()) != null) {
            num2 = Integer.valueOf(j.size());
        }
        if (Intrinsics.areEqual(num, num2)) {
            ImageView imageView = getBinding().oneKeySelect;
            Intrinsics.checkNotNullExpressionValue(imageView, "oneKeySelect");
            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_onkey_select_all_check), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        } else {
            ImageView imageView2 = getBinding().oneKeySelect;
            Intrinsics.checkNotNullExpressionValue(imageView2, "oneKeySelect");
            ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_onkey_select_all_normal), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        }
    }

    @Override // com.qiahao.nextvideo.room.music.c.b
    public void onLoadingFinish() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        MusicLoader g;
        com.qiahao.nextvideo.room.music.c cVar = this.mMusicManager;
        Integer num = null;
        if (cVar != null && (g = cVar.g()) != null) {
            copyOnWriteArrayList = g.h();
        } else {
            copyOnWriteArrayList = null;
        }
        if (copyOnWriteArrayList != null) {
            num = Integer.valueOf(copyOnWriteArrayList.size());
        }
        Log.d(TAG, "onLoadingFinish: " + num);
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            getBinding().musicListView.setVisibility(0);
            getBinding().llSelectAllContent.setVisibility(0);
            getBinding().llEmptyMusic.setVisibility(8);
            getMLocalMusicAdapter().setList(copyOnWriteArrayList);
            return;
        }
        getBinding().musicListView.setVisibility(8);
        getBinding().llSelectAllContent.setVisibility(8);
        getBinding().llEmptyMusic.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onRoomEvent(@NotNull RoomEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getMEventId() == 214) {
            finish();
        }
    }
}
