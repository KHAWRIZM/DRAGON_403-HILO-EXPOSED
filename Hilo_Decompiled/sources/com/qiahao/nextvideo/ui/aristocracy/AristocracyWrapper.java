package com.qiahao.nextvideo.ui.aristocracy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.AristocracyPermissionBean;
import com.qiahao.nextvideo.data.model.MyNobleBeanItem;
import com.qiahao.nextvideo.data.model.NobleBeanConfig;
import com.qiahao.nextvideo.databinding.ViewAristocracyPermissionListBinding;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 I2\u00020\u0001:\u0001IB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J>\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020&2\u0016\u0010>\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020@0,j\b\u0012\u0004\u0012\u00020@`.J\b\u0010A\u001a\u00020\u000eH\u0002J\"\u0010B\u001a\u00020\u000e2\b\b\u0002\u0010C\u001a\u00020\u00172\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ\"\u0010E\u001a\u00020\u000e2\b\b\u0002\u0010C\u001a\u00020\u00172\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ\b\u0010F\u001a\u00020\u000eH\u0003J\b\u0010G\u001a\u00020\u000eH\u0003J\b\u0010H\u001a\u00020\u000eH\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001b\u0010\u001f\u001a\u00020 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R.\u0010+\u001a\u0016\u0012\u0004\u0012\u00020-\u0018\u00010,j\n\u0012\u0004\u0012\u00020-\u0018\u0001`.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0019\"\u0004\b5\u0010\u001bR\u001a\u00106\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0019\"\u0004\b8\u0010\u001bR\u001a\u00109\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0019\"\u0004\b;\u0010\u001b¨\u0006J"}, d2 = {"Lcom/qiahao/nextvideo/ui/aristocracy/AristocracyWrapper;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ViewAristocracyPermissionListBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ViewAristocracyPermissionListBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ViewAristocracyPermissionListBinding;)V", "mClick", "Lkotlin/Function0;", "", "getMClick", "()Lkotlin/jvm/functions/Function0;", "setMClick", "(Lkotlin/jvm/functions/Function0;)V", "mClick9", "getMClick9", "setMClick9", "mNobelPosition", "", "getMNobelPosition", "()I", "setMNobelPosition", "(I)V", "mNobel", "getMNobel", "setMNobel", "mAdapter", "Lcom/qiahao/nextvideo/ui/aristocracy/AristocracyPermissionAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/aristocracy/AristocracyPermissionAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "mNobleBeanConfig", "Lcom/qiahao/nextvideo/data/model/NobleBeanConfig;", "getMNobleBeanConfig", "()Lcom/qiahao/nextvideo/data/model/NobleBeanConfig;", "setMNobleBeanConfig", "(Lcom/qiahao/nextvideo/data/model/NobleBeanConfig;)V", "mAristocracyPermissionViewBean", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/AristocracyPermissionBean;", "Lkotlin/collections/ArrayList;", "getMAristocracyPermissionViewBean", "()Ljava/util/ArrayList;", "setMAristocracyPermissionViewBean", "(Ljava/util/ArrayList;)V", "currentPermissionSum", "getCurrentPermissionSum", "setCurrentPermissionSum", "mStatus", "getMStatus", "setMStatus", "mStatus9", "getMStatus9", "setMStatus9", "setDataAndShowView", "nobleBeanConfig", "aristocracyPermissionViewBean", "myNobleBeanItemList", "Lcom/qiahao/nextvideo/data/model/MyNobleBeanItem;", "refreshView", "refreshNoble8", "status", "click", "refreshNoble9", "refreshViewNoble8", "refreshViewNoble9", "initView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAristocracyWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AristocracyWrapper.kt\ncom/qiahao/nextvideo/ui/aristocracy/AristocracyWrapper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 4 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,228:1\n1869#2,2:229\n1878#2,3:249\n61#3,9:231\n61#3,9:240\n439#4:252\n439#4:253\n439#4:254\n439#4:255\n439#4:256\n439#4:257\n439#4:258\n439#4:259\n*S KotlinDebug\n*F\n+ 1 AristocracyWrapper.kt\ncom/qiahao/nextvideo/ui/aristocracy/AristocracyWrapper\n*L\n68#1:229,2\n85#1:249,3\n73#1:231,9\n78#1:240,9\n155#1:252\n162#1:253\n167#1:254\n172#1:255\n189#1:256\n196#1:257\n201#1:258\n206#1:259\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AristocracyWrapper extends FrameLayout {

    @NotNull
    private static final String TAG = "AristocracyWrapper";
    private int currentPermissionSum;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    @Nullable
    private ArrayList<AristocracyPermissionBean> mAristocracyPermissionViewBean;

    @Nullable
    private Function0<Unit> mClick;

    @Nullable
    private Function0<Unit> mClick9;

    @NotNull
    private ViewAristocracyPermissionListBinding mDataBinding;
    private int mNobel;
    private int mNobelPosition;

    @Nullable
    private NobleBeanConfig mNobleBeanConfig;
    private int mStatus;
    private int mStatus9;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AristocracyWrapper(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mNobelPosition = -1;
        this.mNobel = -1;
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.m
            public final Object invoke() {
                AristocracyPermissionAdapter mAdapter_delegate$lambda$0;
                mAdapter_delegate$lambda$0 = AristocracyWrapper.mAdapter_delegate$lambda$0();
                return mAdapter_delegate$lambda$0;
            }
        });
        this.mDataBinding = (ViewAristocracyPermissionListBinding) androidx.databinding.g.h(LayoutInflater.from(context), R.layout.view_aristocracy_permission_list, this, true);
        initView();
        this.mStatus9 = -1;
    }

    private final void initView() {
        RecyclerView recyclerView = this.mDataBinding.recycler;
        recyclerView.setAdapter(getMAdapter());
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
        recyclerView.setHasFixedSize(true);
        ImageView imageView = this.mDataBinding.image;
        Intrinsics.checkNotNullExpressionValue(imageView, "image");
        ImageKtxKt.toHorizontalMirror(imageView, R.drawable.aristocracy_gift_icon);
        ImageView imageView2 = this.mDataBinding.image9;
        Intrinsics.checkNotNullExpressionValue(imageView2, "image9");
        ImageKtxKt.toHorizontalMirror(imageView2, R.drawable.aristocracy_gift_icon9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AristocracyPermissionAdapter mAdapter_delegate$lambda$0() {
        return new AristocracyPermissionAdapter(R.layout.item_aristocracy);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refreshNoble8$default(AristocracyWrapper aristocracyWrapper, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            function0 = null;
        }
        aristocracyWrapper.refreshNoble8(i, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refreshNoble9$default(AristocracyWrapper aristocracyWrapper, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            function0 = null;
        }
        aristocracyWrapper.refreshNoble9(i, function0);
    }

    private final void refreshView() {
        int i;
        ArrayList<Integer> privileges;
        getMAdapter().setList(this.mAristocracyPermissionViewBean);
        TextView textView = this.mDataBinding.permissionNumber;
        int i2 = this.currentPermissionSum;
        NobleBeanConfig nobleBeanConfig = this.mNobleBeanConfig;
        if (nobleBeanConfig != null && (privileges = nobleBeanConfig.getPrivileges()) != null) {
            i = privileges.size();
        } else {
            i = 0;
        }
        textView.setText("(" + i2 + "/" + i + ")");
    }

    @SuppressLint({"SetTextI18n"})
    private final void refreshViewNoble8() {
        int i;
        NobleBeanConfig nobleBeanConfig;
        Long l8Diamond;
        String str;
        NobleBeanConfig nobleBeanConfig2;
        NobleBeanConfig nobleBeanConfig3 = this.mNobleBeanConfig;
        if (nobleBeanConfig3 != null) {
            i = nobleBeanConfig3.getLevel();
        } else {
            i = 0;
        }
        if (i >= 8) {
            this.mDataBinding.aristocracyLayout8.setVisibility(0);
            TextView textView = this.mDataBinding.number;
            long j = 0;
            if (this.mNobelPosition < 10 ? !((nobleBeanConfig = this.mNobleBeanConfig) == null || (l8Diamond = nobleBeanConfig.getL8Diamond()) == null) : !((nobleBeanConfig2 = this.mNobleBeanConfig) == null || (l8Diamond = nobleBeanConfig2.getL8Noble10Diamond()) == null)) {
                j = l8Diamond.longValue();
            }
            textView.setText(String.valueOf(j));
            TextView textView2 = this.mDataBinding.aristocracyLayoutSubTitle;
            String stringById = ResourcesKtxKt.getStringById(this, 2131952278);
            NobleBeanConfig nobleBeanConfig4 = this.mNobleBeanConfig;
            if (nobleBeanConfig4 != null) {
                str = nobleBeanConfig4.getL8DiamondGetDesc();
            } else {
                str = null;
            }
            textView2.setText(stringById + "\r\n" + str);
            if (this.mNobel != this.mNobelPosition) {
                this.mDataBinding.receive.setText(ResourcesKtxKt.getStringById(this, 2131953840));
                this.mDataBinding.receive.setTextColor(Color.parseColor("#333333"));
                this.mDataBinding.receive.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.aristocracy_gift_receive_default));
                return;
            }
            int i2 = this.mStatus;
            if (i2 != 1) {
                if (i2 != 2) {
                    this.mDataBinding.receive.setText(ResourcesKtxKt.getStringById(this, 2131953840));
                    this.mDataBinding.receive.setTextColor(Color.parseColor("#333333"));
                    this.mDataBinding.receive.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.aristocracy_gift_receive_default));
                    return;
                } else {
                    this.mDataBinding.receive.setText(ResourcesKtxKt.getStringById(this, 2131953844));
                    this.mDataBinding.receive.setTextColor(Color.parseColor("#333333"));
                    this.mDataBinding.receive.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.aristocracy_gift_receive_default));
                    return;
                }
            }
            this.mDataBinding.receive.setText(ResourcesKtxKt.getStringById(this, 2131953840));
            this.mDataBinding.receive.setTextColor(Color.parseColor("#A30D00"));
            this.mDataBinding.receive.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.aristocracy_gift_receive));
            return;
        }
        this.mDataBinding.aristocracyLayout8.setVisibility(8);
    }

    @SuppressLint({"SetTextI18n"})
    private final void refreshViewNoble9() {
        int i;
        NobleBeanConfig nobleBeanConfig;
        Long l9Diamond;
        String str;
        NobleBeanConfig nobleBeanConfig2;
        NobleBeanConfig nobleBeanConfig3 = this.mNobleBeanConfig;
        if (nobleBeanConfig3 != null) {
            i = nobleBeanConfig3.getLevel();
        } else {
            i = 0;
        }
        if (i >= 9) {
            this.mDataBinding.aristocracyLayout9.setVisibility(0);
            TextView textView = this.mDataBinding.number9;
            long j = 0;
            if (this.mNobelPosition < 10 ? !((nobleBeanConfig = this.mNobleBeanConfig) == null || (l9Diamond = nobleBeanConfig.getL9Diamond()) == null) : !((nobleBeanConfig2 = this.mNobleBeanConfig) == null || (l9Diamond = nobleBeanConfig2.getL9Noble10Diamond()) == null)) {
                j = l9Diamond.longValue();
            }
            textView.setText(String.valueOf(j));
            TextView textView2 = this.mDataBinding.aristocracyLayoutSubTitle9;
            String stringById = ResourcesKtxKt.getStringById(this, 2131952278);
            NobleBeanConfig nobleBeanConfig4 = this.mNobleBeanConfig;
            if (nobleBeanConfig4 != null) {
                str = nobleBeanConfig4.getL9DiamondGetDesc();
            } else {
                str = null;
            }
            textView2.setText(stringById + "\r\n" + str);
            if (this.mNobel != this.mNobelPosition) {
                this.mDataBinding.receive9.setText(ResourcesKtxKt.getStringById(this, 2131953840));
                this.mDataBinding.receive9.setTextColor(Color.parseColor("#333333"));
                this.mDataBinding.receive9.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.aristocracy_gift_receive_default));
                return;
            }
            int i2 = this.mStatus9;
            if (i2 != 1) {
                if (i2 != 2) {
                    this.mDataBinding.receive9.setText(ResourcesKtxKt.getStringById(this, 2131953840));
                    this.mDataBinding.receive9.setTextColor(Color.parseColor("#333333"));
                    this.mDataBinding.receive9.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.aristocracy_gift_receive_default));
                    return;
                } else {
                    this.mDataBinding.receive9.setText(ResourcesKtxKt.getStringById(this, 2131953844));
                    this.mDataBinding.receive9.setTextColor(Color.parseColor("#333333"));
                    this.mDataBinding.receive9.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.aristocracy_gift_receive_default));
                    return;
                }
            }
            this.mDataBinding.receive9.setText(ResourcesKtxKt.getStringById(this, 2131953840));
            this.mDataBinding.receive9.setTextColor(Color.parseColor("#A30D00"));
            this.mDataBinding.receive9.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.aristocracy_gift_receive));
            return;
        }
        this.mDataBinding.aristocracyLayout9.setVisibility(8);
    }

    public final int getCurrentPermissionSum() {
        return this.currentPermissionSum;
    }

    @NotNull
    public final AristocracyPermissionAdapter getMAdapter() {
        return (AristocracyPermissionAdapter) this.mAdapter.getValue();
    }

    @Nullable
    public final ArrayList<AristocracyPermissionBean> getMAristocracyPermissionViewBean() {
        return this.mAristocracyPermissionViewBean;
    }

    @Nullable
    public final Function0<Unit> getMClick() {
        return this.mClick;
    }

    @Nullable
    public final Function0<Unit> getMClick9() {
        return this.mClick9;
    }

    @NotNull
    public final ViewAristocracyPermissionListBinding getMDataBinding() {
        return this.mDataBinding;
    }

    public final int getMNobel() {
        return this.mNobel;
    }

    public final int getMNobelPosition() {
        return this.mNobelPosition;
    }

    @Nullable
    public final NobleBeanConfig getMNobleBeanConfig() {
        return this.mNobleBeanConfig;
    }

    public final int getMStatus() {
        return this.mStatus;
    }

    public final int getMStatus9() {
        return this.mStatus9;
    }

    public final void refreshNoble8(int status, @Nullable Function0<Unit> click) {
        this.mStatus = status;
        this.mClick = click;
        refreshViewNoble8();
    }

    public final void refreshNoble9(int status, @Nullable Function0<Unit> click) {
        this.mStatus9 = status;
        this.mClick9 = click;
        refreshViewNoble9();
    }

    public final void setCurrentPermissionSum(int i) {
        this.currentPermissionSum = i;
    }

    public final void setDataAndShowView(@NotNull NobleBeanConfig nobleBeanConfig, @NotNull ArrayList<AristocracyPermissionBean> aristocracyPermissionViewBean, @NotNull ArrayList<MyNobleBeanItem> myNobleBeanItemList) {
        int i;
        AristocracyPermissionBean aristocracyPermissionBean;
        int i2;
        ArrayList<AristocracyPermissionBean> arrayList;
        AristocracyPermissionBean aristocracyPermissionBean2;
        Integer num;
        Intrinsics.checkNotNullParameter(nobleBeanConfig, "nobleBeanConfig");
        Intrinsics.checkNotNullParameter(aristocracyPermissionViewBean, "aristocracyPermissionViewBean");
        Intrinsics.checkNotNullParameter(myNobleBeanItemList, "myNobleBeanItemList");
        for (MyNobleBeanItem myNobleBeanItem : myNobleBeanItemList) {
            if (myNobleBeanItem.getLevel() > this.mNobel) {
                this.mNobel = myNobleBeanItem.getLevel();
            }
        }
        final TextView textView = this.mDataBinding.receive;
        final long j = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.aristocracy.AristocracyWrapper$setDataAndShowView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function0<Unit> mClick;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    if (this.getMStatus() != 4 && this.getMNobel() == this.getMNobelPosition() && (mClick = this.getMClick()) != null) {
                        mClick.invoke();
                    }
                }
            }
        });
        final TextView textView2 = this.mDataBinding.receive9;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.aristocracy.AristocracyWrapper$setDataAndShowView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function0<Unit> mClick9;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    if (this.getMStatus9() != 4 && this.getMNobel() == this.getMNobelPosition() && (mClick9 = this.getMClick9()) != null) {
                        mClick9.invoke();
                    }
                }
            }
        });
        if (nobleBeanConfig.getPrivileges().size() > aristocracyPermissionViewBean.size()) {
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            int i3 = 0;
            for (Object obj : nobleBeanConfig.getPrivileges()) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                int intValue = ((Number) obj).intValue();
                if (i3 < aristocracyPermissionViewBean.size()) {
                    arrayList2.add(Integer.valueOf(intValue));
                }
                i3 = i4;
            }
            nobleBeanConfig.setPrivileges(arrayList2);
        }
        this.mNobleBeanConfig = nobleBeanConfig;
        this.mAristocracyPermissionViewBean = aristocracyPermissionViewBean;
        ArrayList<Integer> privileges = nobleBeanConfig.getPrivileges();
        if (privileges != null) {
            try {
                int size = privileges.size();
                if (size >= 0) {
                    int i5 = 0;
                    while (true) {
                        ArrayList<AristocracyPermissionBean> arrayList3 = this.mAristocracyPermissionViewBean;
                        if (arrayList3 != null) {
                            i = arrayList3.size();
                        } else {
                            i = -1;
                        }
                        if (i5 > i) {
                            return;
                        }
                        if (i5 == 0) {
                            this.currentPermissionSum = 0;
                        }
                        Integer num2 = privileges.get(i5);
                        if (num2 != null && num2.intValue() == 1) {
                            this.currentPermissionSum++;
                            ArrayList<AristocracyPermissionBean> arrayList4 = this.mAristocracyPermissionViewBean;
                            if (arrayList4 != null && (aristocracyPermissionBean = arrayList4.get(i5)) != null) {
                                aristocracyPermissionBean.setHasPermission(true);
                            }
                        }
                        break;
                        i5++;
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Exception e) {
                String localizedMessage = e.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "数据越界！！！";
                }
                Log.d(TAG, localizedMessage);
            }
        }
        NobleBeanConfig nobleBeanConfig2 = this.mNobleBeanConfig;
        if (nobleBeanConfig2 != null) {
            i2 = nobleBeanConfig2.getLevel();
        } else {
            i2 = 0;
        }
        if (i2 > 0 && (arrayList = this.mAristocracyPermissionViewBean) != null && (aristocracyPermissionBean2 = arrayList.get(2)) != null) {
            String stringById = ResourcesKtxKt.getStringById(this, 2131953564);
            NobleBeanConfig nobleBeanConfig3 = this.mNobleBeanConfig;
            if (nobleBeanConfig3 != null) {
                num = Integer.valueOf(nobleBeanConfig3.getDailyGold());
            } else {
                num = null;
            }
            String format = String.format(stringById, Arrays.copyOf(new Object[]{String.valueOf(num)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            aristocracyPermissionBean2.setPermissionText(format);
        }
        refreshView();
        refreshViewNoble8();
        refreshViewNoble9();
    }

    public final void setMAristocracyPermissionViewBean(@Nullable ArrayList<AristocracyPermissionBean> arrayList) {
        this.mAristocracyPermissionViewBean = arrayList;
    }

    public final void setMClick(@Nullable Function0<Unit> function0) {
        this.mClick = function0;
    }

    public final void setMClick9(@Nullable Function0<Unit> function0) {
        this.mClick9 = function0;
    }

    public final void setMDataBinding(@NotNull ViewAristocracyPermissionListBinding viewAristocracyPermissionListBinding) {
        Intrinsics.checkNotNullParameter(viewAristocracyPermissionListBinding, "<set-?>");
        this.mDataBinding = viewAristocracyPermissionListBinding;
    }

    public final void setMNobel(int i) {
        this.mNobel = i;
    }

    public final void setMNobelPosition(int i) {
        this.mNobelPosition = i;
    }

    public final void setMNobleBeanConfig(@Nullable NobleBeanConfig nobleBeanConfig) {
        this.mNobleBeanConfig = nobleBeanConfig;
    }

    public final void setMStatus(int i) {
        this.mStatus = i;
    }

    public final void setMStatus9(int i) {
        this.mStatus9 = i;
    }
}
