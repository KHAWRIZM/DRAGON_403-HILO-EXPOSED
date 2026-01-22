package com.qiahao.nextvideo.room.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.CommonTextDialog;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityMyMusicBinding;
import com.qiahao.nextvideo.room.adapter.MyMusicAdapter;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.room.music.MusicLoader;
import com.qiahao.nextvideo.room.music.MusicStatus;
import com.qiahao.nextvideo.room.music.c;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
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
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u00010B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0006J+\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001d\u0010\u0006R$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020+8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/MyMusicActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityMyMusicBinding;", "Lcom/qiahao/nextvideo/room/music/c$b;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "", "getLayoutResId", "()I", "", "onInitialize", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "event", "onRoomEvent", "(Lcom/qiahao/nextvideo/room/manager/RoomEvent;)V", "search", "onResume", "onLoadingFinish", "", "isSearchEmpty", "isLoadEmpty", "isShowRecyclerView", "showLayout", "(ZZZ)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "onBackPressed", "Lcom/qiahao/nextvideo/room/music/c;", "mMusicManager", "Lcom/qiahao/nextvideo/room/music/c;", "getMMusicManager", "()Lcom/qiahao/nextvideo/room/music/c;", "setMMusicManager", "(Lcom/qiahao/nextvideo/room/music/c;)V", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "getMViewModel", "()Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "mViewModel", "Lcom/qiahao/nextvideo/room/adapter/MyMusicAdapter;", "mMyMusicAdapter$delegate", "getMMyMusicAdapter", "()Lcom/qiahao/nextvideo/room/adapter/MyMusicAdapter;", "mMyMusicAdapter", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMyMusicActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyMusicActivity.kt\ncom/qiahao/nextvideo/room/activity/MyMusicActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,301:1\n1869#2,2:302\n*S KotlinDebug\n*F\n+ 1 MyMusicActivity.kt\ncom/qiahao/nextvideo/room/activity/MyMusicActivity\n*L\n207#1:302,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MyMusicActivity extends HiloBaseBindingActivity<ActivityMyMusicBinding> implements c.b, View.OnClickListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "MyMusicActivity";

    @Nullable
    private com.qiahao.nextvideo.room.music.c mMusicManager;

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.activity.p0
        public final Object invoke() {
            BaseViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = MyMusicActivity.mViewModel_delegate$lambda$0(MyMusicActivity.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mMyMusicAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMyMusicAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.activity.q0
        public final Object invoke() {
            MyMusicAdapter mMyMusicAdapter_delegate$lambda$1;
            mMyMusicAdapter_delegate$lambda$1 = MyMusicActivity.mMyMusicAdapter_delegate$lambda$1();
            return mMyMusicAdapter_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/MyMusicActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "TAG", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) MyMusicActivity.class));
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MusicStatus.values().length];
            try {
                iArr[MusicStatus.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MusicStatus.STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final BaseViewModel getMViewModel() {
        return (BaseViewModel) this.mViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MyMusicAdapter mMyMusicAdapter_delegate$lambda$1() {
        return new MyMusicAdapter(R.layout.item_my_music);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseViewModel mViewModel_delegate$lambda$0(MyMusicActivity myMusicActivity) {
        return new ViewModelProvider(myMusicActivity).get(BaseViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$2(MyMusicActivity myMusicActivity, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = myMusicActivity.getBinding().titleBar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMargins(0, i, 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$4(MyMusicActivity myMusicActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        MusicLoader.MusicInfo musicInfo = (MusicLoader.MusicInfo) myMusicActivity.getMMyMusicAdapter().getData().get(i);
        Long l = null;
        MusicStatus musicStatus = null;
        Long l2 = null;
        if (MusicLoader.m() != null) {
            if (musicInfo != null && MusicLoader.m().c() == musicInfo.c()) {
                com.qiahao.nextvideo.room.music.c cVar = myMusicActivity.mMusicManager;
                if (cVar != null) {
                    musicStatus = cVar.i();
                }
                if (musicStatus == null) {
                    i2 = -1;
                } else {
                    i2 = WhenMappings.$EnumSwitchMapping$0[musicStatus.ordinal()];
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        baseQuickAdapter.notifyDataSetChanged();
                        com.qiahao.nextvideo.room.music.c cVar2 = myMusicActivity.mMusicManager;
                        if (cVar2 != null) {
                            cVar2.q();
                        }
                        Log.d(TAG, "onCreate: " + musicInfo.c());
                        return;
                    }
                    MusicLoader.o(musicInfo);
                    baseQuickAdapter.notifyDataSetChanged();
                    com.qiahao.nextvideo.room.music.c cVar3 = myMusicActivity.mMusicManager;
                    if (cVar3 != null) {
                        cVar3.r();
                    }
                    Log.d(TAG, "onCreate: " + musicInfo.c());
                    return;
                }
                baseQuickAdapter.notifyDataSetChanged();
                com.qiahao.nextvideo.room.music.c cVar4 = myMusicActivity.mMusicManager;
                if (cVar4 != null) {
                    cVar4.s();
                }
                Log.d(TAG, "onCreate: " + musicInfo.c());
                return;
            }
            MusicLoader.o(musicInfo);
            baseQuickAdapter.notifyDataSetChanged();
            com.qiahao.nextvideo.room.music.c cVar5 = myMusicActivity.mMusicManager;
            if (cVar5 != null) {
                cVar5.r();
            }
            if (musicInfo != null) {
                l2 = Long.valueOf(musicInfo.c());
            }
            Log.d(TAG, "onCreate: " + l2);
            return;
        }
        MusicLoader.o(musicInfo);
        baseQuickAdapter.notifyDataSetChanged();
        com.qiahao.nextvideo.room.music.c cVar6 = myMusicActivity.mMusicManager;
        if (cVar6 != null) {
            cVar6.r();
        }
        if (musicInfo != null) {
            l = Long.valueOf(musicInfo.c());
        }
        Log.d(TAG, "onCreate: " + l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
    public static final boolean onInitialize$lambda$6(final MyMusicActivity myMusicActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.room.music.MusicLoader.MusicInfo");
        final MusicLoader.MusicInfo musicInfo = (MusicLoader.MusicInfo) item;
        ?? commonTextDialog = new CommonTextDialog(myMusicActivity, 0.0f, 2, null);
        String string = commonTextDialog.getMContext().getString(2131952550);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        commonTextDialog.setContentText(string, true, new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.activity.MyMusicActivity$onInitialize$4$1$1
            public void cancel() {
            }

            public void confirm() {
                List list;
                MusicLoader g;
                MusicLoader g2;
                MusicLoader g3;
                com.qiahao.nextvideo.room.music.c mMusicManager = MyMusicActivity.this.getMMusicManager();
                if (mMusicManager != null && (g3 = mMusicManager.g()) != null) {
                    g3.c(musicInfo.c());
                }
                MyMusicAdapter mMyMusicAdapter = MyMusicActivity.this.getMMyMusicAdapter();
                com.qiahao.nextvideo.room.music.c mMusicManager2 = MyMusicActivity.this.getMMusicManager();
                List list2 = null;
                if (mMusicManager2 != null && (g2 = mMusicManager2.g()) != null) {
                    list = g2.j();
                } else {
                    list = null;
                }
                mMyMusicAdapter.setList(list);
                com.qiahao.nextvideo.room.music.c mMusicManager3 = MyMusicActivity.this.getMMusicManager();
                if (mMusicManager3 != null && (g = mMusicManager3.g()) != null) {
                    list2 = g.j();
                }
                if (list2 == null || list2.isEmpty()) {
                    MyMusicActivity.showLayout$default(MyMusicActivity.this, false, true, false, 5, null);
                }
            }
        });
        commonTextDialog.show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onInitialize$lambda$7(MyMusicActivity myMusicActivity, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        myMusicActivity.search();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onInitialize$lambda$8(MyMusicActivity myMusicActivity, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 4 || i == 6 || (keyEvent != null && 66 == keyEvent.getKeyCode() && keyEvent.getAction() == 0)) {
            myMusicActivity.search();
            return false;
        }
        return false;
    }

    public static /* synthetic */ void showLayout$default(MyMusicActivity myMusicActivity, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        myMusicActivity.showLayout(z, z2, z3);
    }

    @JvmStatic
    public static final void start(@NotNull Context context) {
        INSTANCE.start(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_my_music;
    }

    @Nullable
    public final com.qiahao.nextvideo.room.music.c getMMusicManager() {
        return this.mMusicManager;
    }

    @NotNull
    public final MyMusicAdapter getMMyMusicAdapter() {
        return (MyMusicAdapter) this.mMyMusicAdapter.getValue();
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
        Intrinsics.checkNotNullParameter(v, "v");
        switch (v.getId()) {
            case R.id.add_music /* 2131361933 */:
            case R.id.ll_add_music /* 2131363529 */:
                AddMusicActivity.INSTANCE.start(this);
                return;
            case R.id.back_image_view /* 2131362039 */:
                com.qiahao.nextvideo.room.music.c cVar = this.mMusicManager;
                if (cVar != null) {
                    cVar.removeOnLoadingListener(this);
                }
                finish();
                return;
            case R.id.clear_edit /* 2131362360 */:
                ((ActivityMyMusicBinding) getBinding()).searchEditText.setText("");
                ((ActivityMyMusicBinding) getBinding()).clearEdit.setVisibility(8);
                return;
            default:
                return;
        }
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        Toolbar toolbar = getBinding().titleBar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "titleBar");
        getStatusBarTopOrBottom(toolbar, new Function2() { // from class: com.qiahao.nextvideo.room.activity.r0
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$2;
                onInitialize$lambda$2 = MyMusicActivity.onInitialize$lambda$2(MyMusicActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$2;
            }
        });
        setStatusBarIconColor(false);
        getBinding().setClick(this);
        RecyclerView recyclerView = getBinding().musicListView;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getMMyMusicAdapter());
        getBinding().clearEdit.setVisibility(8);
        getMMyMusicAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.activity.s0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MyMusicActivity.onInitialize$lambda$4(MyMusicActivity.this, baseQuickAdapter, view, i);
            }
        });
        getMMyMusicAdapter().setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.qiahao.nextvideo.room.activity.t0
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                boolean onInitialize$lambda$6;
                onInitialize$lambda$6 = MyMusicActivity.onInitialize$lambda$6(MyMusicActivity.this, baseQuickAdapter, view, i);
                return onInitialize$lambda$6;
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
        getBinding().searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.qiahao.nextvideo.room.activity.u0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean onInitialize$lambda$7;
                onInitialize$lambda$7 = MyMusicActivity.onInitialize$lambda$7(MyMusicActivity.this, textView, i, keyEvent);
                return onInitialize$lambda$7;
            }
        });
        getBinding().searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.qiahao.nextvideo.room.activity.v0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean onInitialize$lambda$8;
                onInitialize$lambda$8 = MyMusicActivity.onInitialize$lambda$8(MyMusicActivity.this, textView, i, keyEvent);
                return onInitialize$lambda$8;
            }
        });
        getBinding().searchEditText.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.room.activity.MyMusicActivity$onInitialize$7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                int i;
                ActivityMyMusicBinding binding;
                ActivityMyMusicBinding binding2;
                if (s != null) {
                    i = s.length();
                } else {
                    i = 0;
                }
                if (i > 0) {
                    binding2 = MyMusicActivity.this.getBinding();
                    binding2.clearEdit.setVisibility(0);
                } else {
                    MyMusicActivity.this.search();
                    binding = MyMusicActivity.this.getBinding();
                    binding.clearEdit.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    @Override // com.qiahao.nextvideo.room.music.c.b
    public void onLoadingFinish() {
        List list;
        MusicLoader g;
        com.qiahao.nextvideo.room.music.c cVar = this.mMusicManager;
        if (cVar != null && (g = cVar.g()) != null) {
            list = g.j();
        } else {
            list = null;
        }
        if (list != null && list.isEmpty()) {
            showLayout$default(this, false, true, false, 5, null);
        } else {
            showLayout$default(this, false, false, true, 3, null);
            getMMyMusicAdapter().setList(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onResume() {
        List list;
        MusicLoader g;
        MusicLoader g2;
        super.onResume();
        com.qiahao.nextvideo.room.music.c cVar = this.mMusicManager;
        List list2 = null;
        if (cVar != null && (g2 = cVar.g()) != null) {
            list = g2.j();
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            showLayout$default(this, false, false, true, 3, null);
            MyMusicAdapter mMyMusicAdapter = getMMyMusicAdapter();
            com.qiahao.nextvideo.room.music.c cVar2 = this.mMusicManager;
            if (cVar2 != null && (g = cVar2.g()) != null) {
                list2 = g.j();
            }
            mMyMusicAdapter.setList(list2);
            return;
        }
        showLayout$default(this, false, true, false, 5, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onRoomEvent(@NotNull RoomEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getMEventId() == 214) {
            finish();
        }
    }

    public final void search() {
        MusicLoader g;
        MusicLoader g2;
        List j;
        MusicLoader g3;
        List<MusicLoader.MusicInfo> j2;
        String obj = StringsKt.trim(getBinding().searchEditText.getEditableText().toString()).toString();
        List list = null;
        if (obj.length() > 0) {
            ArrayList arrayList = new ArrayList();
            com.qiahao.nextvideo.room.music.c cVar = this.mMusicManager;
            if (cVar != null && (g3 = cVar.g()) != null && (j2 = g3.j()) != null) {
                for (MusicLoader.MusicInfo musicInfo : j2) {
                    String d = musicInfo.d();
                    Intrinsics.checkNotNullExpressionValue(d, "getTitle(...)");
                    if (StringsKt.contains$default(d, obj, false, 2, (Object) null)) {
                        arrayList.add(musicInfo);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                showLayout$default(this, true, false, false, 6, null);
                return;
            } else {
                getMMyMusicAdapter().setList(arrayList);
                showLayout$default(this, false, false, true, 3, null);
                return;
            }
        }
        com.qiahao.nextvideo.room.music.c cVar2 = this.mMusicManager;
        if (cVar2 != null && (g2 = cVar2.g()) != null && (j = g2.j()) != null && j.isEmpty()) {
            showLayout$default(this, false, true, false, 5, null);
            return;
        }
        MyMusicAdapter mMyMusicAdapter = getMMyMusicAdapter();
        com.qiahao.nextvideo.room.music.c cVar3 = this.mMusicManager;
        if (cVar3 != null && (g = cVar3.g()) != null) {
            list = g.j();
        }
        mMyMusicAdapter.setList(list);
        showLayout$default(this, false, false, true, 3, null);
    }

    public final void setMMusicManager(@Nullable com.qiahao.nextvideo.room.music.c cVar) {
        this.mMusicManager = cVar;
    }

    public final void showLayout(boolean isSearchEmpty, boolean isLoadEmpty, boolean isShowRecyclerView) {
        if (isSearchEmpty) {
            getBinding().llEmptyMusic.setVisibility(0);
            getBinding().llAddMusic.setVisibility(8);
            getBinding().musicListView.setVisibility(8);
        } else if (isLoadEmpty) {
            getBinding().llEmptyMusic.setVisibility(8);
            getBinding().llAddMusic.setVisibility(0);
            getBinding().musicListView.setVisibility(8);
        } else if (isShowRecyclerView) {
            getBinding().llEmptyMusic.setVisibility(8);
            getBinding().llAddMusic.setVisibility(8);
            getBinding().musicListView.setVisibility(0);
        }
    }
}
