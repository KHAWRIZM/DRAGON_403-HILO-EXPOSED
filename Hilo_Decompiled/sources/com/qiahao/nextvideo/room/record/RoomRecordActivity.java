package com.qiahao.nextvideo.room.record;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityRoomRecordBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\tj\b\u0012\u0004\u0012\u00020\u0006`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/room/record/RoomRecordActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityRoomRecordBinding;", "<init>", "()V", "mDiamondFragment", "Lcom/qiahao/nextvideo/room/record/RoomRecordFragment;", "mGemFragment", "mFragmentList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mGroupId", "", "mTypeList", "", "getMTypeList", "()[Ljava/lang/String;", "setMTypeList", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getLayoutResId", "", "onInitialize", "", "initView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomRecordActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomRecordActivity.kt\ncom/qiahao/nextvideo/room/record/RoomRecordActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,89:1\n1#2:90\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomRecordActivity extends HiloBaseBindingActivity<ActivityRoomRecordBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private RoomRecordFragment mDiamondFragment;

    @Nullable
    private RoomRecordFragment mGemFragment;

    @Nullable
    private String mGroupId;

    @NotNull
    private ArrayList<RoomRecordFragment> mFragmentList = new ArrayList<>();

    @NotNull
    private String[] mTypeList = {ResourcesKtxKt.getStringById(this, 2131952567), ResourcesKtxKt.getStringById(this, 2131952860)};

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/room/record/RoomRecordActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "groupId", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, @NotNull String groupId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intent intent = new Intent(context, (Class<?>) RoomRecordActivity.class);
            intent.putExtra("group_id", groupId);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        this.mGroupId = getIntent().getStringExtra("group_id");
        View view = ((ActivityRoomRecordBinding) getBinding()).titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.room.record.a
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$0;
                initView$lambda$0 = RoomRecordActivity.initView$lambda$0(RoomRecordActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$0;
            }
        });
        ((ActivityRoomRecordBinding) getBinding()).titleBar.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.record.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RoomRecordActivity.this.finish();
            }
        });
        ((ActivityRoomRecordBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.toStringRes(2131951941));
        if (this.mDiamondFragment == null) {
            Bundle bundle = new Bundle();
            bundle.putString("group_id", this.mGroupId);
            bundle.putInt("transfer_type", 1);
            RoomRecordFragment roomRecordFragment = new RoomRecordFragment();
            roomRecordFragment.setArguments(bundle);
            this.mDiamondFragment = roomRecordFragment;
            this.mFragmentList.add(roomRecordFragment);
        }
        if (this.mGemFragment == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("group_id", this.mGroupId);
            bundle2.putInt("transfer_type", 2);
            RoomRecordFragment roomRecordFragment2 = new RoomRecordFragment();
            roomRecordFragment2.setArguments(bundle2);
            this.mGemFragment = roomRecordFragment2;
            this.mFragmentList.add(roomRecordFragment2);
        }
        ((ActivityRoomRecordBinding) getBinding()).viewPage.setOffscreenPageLimit(2);
        ((ActivityRoomRecordBinding) getBinding()).viewPage.setAdapter(new androidx.viewpager2.adapter.a() { // from class: com.qiahao.nextvideo.room.record.RoomRecordActivity$initView$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(RoomRecordActivity.this);
            }

            public Fragment createFragment(int position) {
                ArrayList arrayList;
                arrayList = RoomRecordActivity.this.mFragmentList;
                Object obj = arrayList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return (Fragment) obj;
            }

            public int getItemCount() {
                ArrayList arrayList;
                arrayList = RoomRecordActivity.this.mFragmentList;
                return arrayList.size();
            }
        });
        ViewPage2TabLayout viewPage2TabLayout = ((ActivityRoomRecordBinding) getBinding()).tabSegment;
        ViewPager2 viewPager2 = ((ActivityRoomRecordBinding) getBinding()).viewPage;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "viewPage");
        viewPage2TabLayout.setViewPager2(viewPager2, new RoomRecordTitleAdapter());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$0(RoomRecordActivity roomRecordActivity, int i, int i2) {
        roomRecordActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_room_record;
    }

    @NotNull
    public final String[] getMTypeList() {
        return this.mTypeList;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
    }

    public final void setMTypeList(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.mTypeList = strArr;
    }
}
