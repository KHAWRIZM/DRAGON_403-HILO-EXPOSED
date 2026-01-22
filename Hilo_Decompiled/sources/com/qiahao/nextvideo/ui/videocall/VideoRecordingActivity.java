package com.qiahao.nextvideo.ui.videocall;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.model.TabConfig;
import com.qiahao.base_common.wedgit.BackgroundTabLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityVideoRecordingBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0004R&\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR&\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000bj\b\u0012\u0004\u0012\u00020\u0010`\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/VideoRecordingActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityVideoRecordingBinding;", "<init>", "()V", "", "initView", "", "getLayoutResId", "()I", "onInitialize", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/TabConfig;", "Lkotlin/collections/ArrayList;", "mTypeList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/ui/videocall/VideoRecordingFragment;", "mFragments", "Landroidx/viewpager2/adapter/a;", "mPagerAdapter", "Landroidx/viewpager2/adapter/a;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoRecordingActivity extends HiloBaseBindingActivity<ActivityVideoRecordingBinding> {

    @NotNull
    public static final String FRAGMENT_TYPE = "fragment_type";

    @NotNull
    public static final String TYPE_MISS = "Miss";

    @NotNull
    public static final String TYPE_PAIR = "Pair";
    private androidx.viewpager2.adapter.a mPagerAdapter;

    @NotNull
    private ArrayList<TabConfig> mTypeList = new ArrayList<>();

    @NotNull
    private ArrayList<VideoRecordingFragment> mFragments = new ArrayList<>();

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        View view = ((ActivityVideoRecordingBinding) getBinding()).titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.videocall.g
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$0;
                initView$lambda$0 = VideoRecordingActivity.initView$lambda$0(VideoRecordingActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$0;
            }
        });
        ((ActivityVideoRecordingBinding) getBinding()).titleBar.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VideoRecordingActivity.this.onBackPressed();
            }
        });
        ((ActivityVideoRecordingBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.toStringRes(2131954440));
        ArrayList<VideoRecordingFragment> arrayList = this.mFragments;
        if (arrayList == null || arrayList.isEmpty()) {
            ArrayList<VideoRecordingFragment> arrayList2 = this.mFragments;
            VideoRecordingFragment videoRecordingFragment = new VideoRecordingFragment();
            Bundle bundle = new Bundle();
            bundle.putString("fragment_type", TYPE_PAIR);
            videoRecordingFragment.setArguments(bundle);
            arrayList2.add(videoRecordingFragment);
            ArrayList<VideoRecordingFragment> arrayList3 = this.mFragments;
            VideoRecordingFragment videoRecordingFragment2 = new VideoRecordingFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("fragment_type", TYPE_MISS);
            videoRecordingFragment2.setArguments(bundle2);
            arrayList3.add(videoRecordingFragment2);
        }
        ArrayList<TabConfig> arrayList4 = this.mTypeList;
        if (arrayList4 == null || arrayList4.isEmpty()) {
            this.mTypeList.add(new TabConfig(getString(2131954437), 2131099900, 2131099872, 13.0f, 13.0f));
            this.mTypeList.add(new TabConfig(getString(2131954435), 2131099900, 2131099872, 13.0f, 13.0f));
        }
        this.mPagerAdapter = new androidx.viewpager2.adapter.a() { // from class: com.qiahao.nextvideo.ui.videocall.VideoRecordingActivity$initView$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(VideoRecordingActivity.this);
            }

            public Fragment createFragment(int position) {
                ArrayList arrayList5;
                arrayList5 = VideoRecordingActivity.this.mFragments;
                Object obj = arrayList5.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return (Fragment) obj;
            }

            public int getItemCount() {
                ArrayList arrayList5;
                arrayList5 = VideoRecordingActivity.this.mFragments;
                return arrayList5.size();
            }
        };
        ((ActivityVideoRecordingBinding) getBinding()).viewPage.setOffscreenPageLimit(2);
        ViewPager2 viewPager2 = ((ActivityVideoRecordingBinding) getBinding()).viewPage;
        RecyclerView.Adapter adapter = this.mPagerAdapter;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPagerAdapter");
            adapter = null;
        }
        viewPager2.setAdapter(adapter);
        ((ActivityVideoRecordingBinding) getBinding()).tabSegment.r(((ActivityVideoRecordingBinding) getBinding()).viewPage, this.mTypeList);
        ((ActivityVideoRecordingBinding) getBinding()).tabSegment.setShowBackground(true);
        ((ActivityVideoRecordingBinding) getBinding()).tabSegment.setBackgroundColor(androidx.core.content.a.getColor(this, 2131101214));
        ((ActivityVideoRecordingBinding) getBinding()).tabSegment.setonTabSelectListener(new BackgroundTabLayout.b() { // from class: com.qiahao.nextvideo.ui.videocall.VideoRecordingActivity$initView$6
            public void notRedPoint() {
            }

            public void onPageSelected(int position) {
                if (position == 1) {
                    IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "video_miss_number", 0, (String) null, 4, (Object) null);
                }
            }
        });
        ((ActivityVideoRecordingBinding) getBinding()).viewPage.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.videocall.i
            @Override // java.lang.Runnable
            public final void run() {
                VideoRecordingActivity.initView$lambda$4(VideoRecordingActivity.this);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$0(VideoRecordingActivity videoRecordingActivity, int i, int i2) {
        videoRecordingActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(VideoRecordingActivity videoRecordingActivity) {
        int intValue = ((Number) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "video_miss_number", 0, (String) null, 4, (Object) null)).intValue();
        if (intValue > 0) {
            videoRecordingActivity.getBinding().tabSegment.q(1, true, intValue);
        } else {
            videoRecordingActivity.getBinding().tabSegment.q(1, false, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_video_recording;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
    }
}
