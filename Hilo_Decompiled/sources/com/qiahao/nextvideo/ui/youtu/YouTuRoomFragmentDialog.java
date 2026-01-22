package com.qiahao.nextvideo.ui.youtu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialogFragment;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.youtube.YouTuBeData;
import com.qiahao.nextvideo.databinding.DialogYouTuRoomFragmentBinding;
import com.qiahao.nextvideo.room.adapter.ViewPagerFragmentAdapter;
import com.qiahao.nextvideo.room.dialog.YouTuHelperDialog;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.TabEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0006RA\u0010\u0017\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR'\u0010#\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R&\u0010(\u001a\u0012\u0012\u0004\u0012\u00020'0 j\b\u0012\u0004\u0012\u00020'`\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010$R\u0016\u0010)\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/qiahao/nextvideo/ui/youtu/YouTuRoomFragmentDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialogFragment;", "Lcom/qiahao/nextvideo/databinding/DialogYouTuRoomFragmentBinding;", "", "videoId", "<init>", "(Ljava/lang/String;)V", "", "getLayoutResId", "()I", "getGravity", "", "onInitialize", "()V", "Ljava/lang/String;", "getVideoId", "()Ljava/lang/String;", "setVideoId", "Lkotlin/Function1;", "Lcom/qiahao/nextvideo/data/model/youtube/YouTuBeData;", "Lkotlin/ParameterName;", "name", "data", "mListener", "Lkotlin/jvm/functions/Function1;", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "", "titles", "[Ljava/lang/String;", "Ljava/util/ArrayList;", "Lo6/a;", "Lkotlin/collections/ArrayList;", "tabEntities", "Ljava/util/ArrayList;", "getTabEntities", "()Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "mFragments", "position", "I", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nYouTuRoomFragmentDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 YouTuRoomFragmentDialog.kt\ncom/qiahao/nextvideo/ui/youtu/YouTuRoomFragmentDialog\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,102:1\n13472#2,2:103\n1#3:105\n61#4,9:106\n*S KotlinDebug\n*F\n+ 1 YouTuRoomFragmentDialog.kt\ncom/qiahao/nextvideo/ui/youtu/YouTuRoomFragmentDialog\n*L\n32#1:103,2\n48#1:106,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class YouTuRoomFragmentDialog extends BaseBindingDialogFragment<DialogYouTuRoomFragmentBinding> {

    @NotNull
    private ArrayList<Fragment> mFragments;

    @Nullable
    private Function1<? super YouTuBeData, Unit> mListener;
    private int position;

    @NotNull
    private final ArrayList<o6.a> tabEntities;

    @NotNull
    private String[] titles;

    @Nullable
    private String videoId;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public YouTuRoomFragmentDialog() {
        this(r0, 1, r0);
        String str = null;
    }

    public static final /* synthetic */ DialogYouTuRoomFragmentBinding access$getBinding(YouTuRoomFragmentDialog youTuRoomFragmentDialog) {
        return (DialogYouTuRoomFragmentBinding) youTuRoomFragmentDialog.getBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$6$lambda$5(YouTuRoomFragmentDialog youTuRoomFragmentDialog) {
        youTuRoomFragmentDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$8$lambda$7(YouTuRoomFragmentDialog youTuRoomFragmentDialog) {
        youTuRoomFragmentDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$9(YouTuRoomFragmentDialog youTuRoomFragmentDialog) {
        ((DialogYouTuRoomFragmentBinding) youTuRoomFragmentDialog.getBinding()).viewPage.setCurrentItem(youTuRoomFragmentDialog.position);
    }

    protected int getGravity() {
        return 80;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_you_tu_room_fragment;
    }

    @Nullable
    public final Function1<YouTuBeData, Unit> getMListener() {
        return this.mListener;
    }

    @NotNull
    public final ArrayList<o6.a> getTabEntities() {
        return this.tabEntities;
    }

    @Nullable
    public final String getVideoId() {
        return this.videoId;
    }

    public void onInitialize() {
        Drawable drawable;
        super/*com.qiahao.base_common.common.BaseDialogFragment*/.onInitialize();
        ConstraintLayout constraintLayout = ((DialogYouTuRoomFragmentBinding) getBinding()).constraint;
        Context context = getContext();
        if (context != null) {
            drawable = ShapeUtil.createShape$default(ShapeUtil.INSTANCE, context, 2131101214, 2131101214, 16, 16, 0, 0, (GradientDrawable.Orientation) null, 128, (Object) null);
        } else {
            drawable = null;
        }
        constraintLayout.setBackground(drawable);
        final ImageView imageView = ((DialogYouTuRoomFragmentBinding) getBinding()).helper;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.youtu.YouTuRoomFragmentDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    Context context2 = this.getContext();
                    if (context2 != null) {
                        new YouTuHelperDialog(context2).show();
                    }
                }
            }
        });
        if (this.mFragments.isEmpty()) {
            ArrayList<Fragment> arrayList = this.mFragments;
            YouTuPlayListFragment youTuPlayListFragment = new YouTuPlayListFragment();
            youTuPlayListFragment.setMListener(this.mListener);
            youTuPlayListFragment.setVideoId(this.videoId);
            youTuPlayListFragment.setMDismiss(new Function0() { // from class: com.qiahao.nextvideo.ui.youtu.p
                public final Object invoke() {
                    Unit onInitialize$lambda$6$lambda$5;
                    onInitialize$lambda$6$lambda$5 = YouTuRoomFragmentDialog.onInitialize$lambda$6$lambda$5(YouTuRoomFragmentDialog.this);
                    return onInitialize$lambda$6$lambda$5;
                }
            });
            arrayList.add(youTuPlayListFragment);
            ArrayList<Fragment> arrayList2 = this.mFragments;
            YouTuHotListFragment youTuHotListFragment = new YouTuHotListFragment();
            youTuHotListFragment.setMListener(this.mListener);
            youTuHotListFragment.setMDismiss(new Function0() { // from class: com.qiahao.nextvideo.ui.youtu.q
                public final Object invoke() {
                    Unit onInitialize$lambda$8$lambda$7;
                    onInitialize$lambda$8$lambda$7 = YouTuRoomFragmentDialog.onInitialize$lambda$8$lambda$7(YouTuRoomFragmentDialog.this);
                    return onInitialize$lambda$8$lambda$7;
                }
            });
            arrayList2.add(youTuHotListFragment);
        }
        ((DialogYouTuRoomFragmentBinding) getBinding()).tabLayout.setOnTabSelectListener(new o6.b() { // from class: com.qiahao.nextvideo.ui.youtu.YouTuRoomFragmentDialog$onInitialize$5
            public void onTabReselect(int position) {
            }

            public void onTabSelect(int position) {
                YouTuRoomFragmentDialog.access$getBinding(YouTuRoomFragmentDialog.this).viewPage.setCurrentItem(position);
            }
        });
        ((DialogYouTuRoomFragmentBinding) getBinding()).viewPage.addOnPageChangeListener(new ViewPager.j() { // from class: com.qiahao.nextvideo.ui.youtu.YouTuRoomFragmentDialog$onInitialize$6
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                YouTuRoomFragmentDialog.access$getBinding(YouTuRoomFragmentDialog.this).tabLayout.setCurrentTab(position);
            }
        });
        ((DialogYouTuRoomFragmentBinding) getBinding()).viewPage.setOffscreenPageLimit(2);
        ViewPager viewPager = ((DialogYouTuRoomFragmentBinding) getBinding()).viewPage;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        viewPager.setAdapter(new ViewPagerFragmentAdapter(childFragmentManager, this.mFragments));
        ((DialogYouTuRoomFragmentBinding) getBinding()).tabLayout.setTabData(this.tabEntities);
        if (this.position < this.titles.length) {
            ((DialogYouTuRoomFragmentBinding) getBinding()).viewPage.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.youtu.r
                @Override // java.lang.Runnable
                public final void run() {
                    YouTuRoomFragmentDialog.onInitialize$lambda$9(YouTuRoomFragmentDialog.this);
                }
            }, 500L);
        }
    }

    public final void setMListener(@Nullable Function1<? super YouTuBeData, Unit> function1) {
        this.mListener = function1;
    }

    public final void setVideoId(@Nullable String str) {
        this.videoId = str;
    }

    public YouTuRoomFragmentDialog(@Nullable String str) {
        this.videoId = str;
        this.titles = new String[]{ResourcesKtxKt.getStringById(this, 2131953966), ResourcesKtxKt.getStringById(this, 2131953083)};
        ArrayList<o6.a> arrayList = new ArrayList<>();
        for (String str2 : this.titles) {
            arrayList.add(new TabEntity(str2, 0, 0));
        }
        this.tabEntities = arrayList;
        this.mFragments = new ArrayList<>();
    }

    public /* synthetic */ YouTuRoomFragmentDialog(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }
}
