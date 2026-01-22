package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialogFragment;
import com.qiahao.base_common.interfaceing.SelectInterface;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.BaseSelectDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.MicroUserBean;
import com.qiahao.nextvideo.databinding.DialogCreate1v1PkBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.room.adapter.Pk1v1Adapter;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\tH\u0014¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/Create1v1PKDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialogFragment;", "Lcom/qiahao/nextvideo/databinding/DialogCreate1v1PkBinding;", "<init>", "()V", "", "initView", "refreshSelect", "createPK", "", "getLayoutResId", "()I", "onInitialize", "getGravity", "getHeight", "dismiss", "mTime", "I", "Lkotlin/Function0;", "mListener", "Lkotlin/jvm/functions/Function0;", "getMListener", "()Lkotlin/jvm/functions/Function0;", "setMListener", "(Lkotlin/jvm/functions/Function0;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "timeList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/room/adapter/Pk1v1Adapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getMAdapter", "()Lcom/qiahao/nextvideo/room/adapter/Pk1v1Adapter;", "mAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCreate1v1PKDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Create1v1PKDialog.kt\ncom/qiahao/nextvideo/room/dialog/Create1v1PKDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,272:1\n1869#2,2:273\n1869#2,2:311\n61#3,9:275\n61#3,9:284\n61#3,9:293\n61#3,9:302\n61#3,9:313\n61#3,9:322\n61#3,9:331\n*S KotlinDebug\n*F\n+ 1 Create1v1PKDialog.kt\ncom/qiahao/nextvideo/room/dialog/Create1v1PKDialog\n*L\n42#1:273,2\n94#1:311,2\n75#1:275,9\n79#1:284,9\n83#1:293,9\n87#1:302,9\n100#1:313,9\n106#1:322,9\n112#1:331,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class Create1v1PKDialog extends BaseBindingDialogFragment<DialogCreate1v1PkBinding> {

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    @Nullable
    private Function0<Unit> mListener;

    @NotNull
    private final ArrayList<String> timeList;
    private int mTime = 5;

    @NotNull
    private nd.a mCompositeDisposable = new nd.a();

    public Create1v1PKDialog() {
        List<Integer> groupPk1V1;
        ArrayList<String> arrayList = new ArrayList<>();
        GroupDetailBean mGroupDetailBean = MeetingRoomManager.INSTANCE.getMGroupDetailBean();
        if (mGroupDetailBean != null && (groupPk1V1 = mGroupDetailBean.getGroupPk1V1()) != null) {
            Iterator<T> it = groupPk1V1.iterator();
            while (it.hasNext()) {
                String format = String.format(ResourcesKtxKt.getStringById(arrayList, 2131953401), Arrays.copyOf(new Object[]{Integer.valueOf(((Number) it.next()).intValue())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                arrayList.add(format);
            }
        }
        this.timeList = arrayList;
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.f
            public final Object invoke() {
                Pk1v1Adapter mAdapter_delegate$lambda$2;
                mAdapter_delegate$lambda$2 = Create1v1PKDialog.mAdapter_delegate$lambda$2();
                return mAdapter_delegate$lambda$2;
            }
        });
    }

    public static final /* synthetic */ DialogCreate1v1PkBinding access$getBinding(Create1v1PKDialog create1v1PKDialog) {
        return (DialogCreate1v1PkBinding) create1v1PKDialog.getBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createPK() {
        String str;
        String externalId;
        ServerApi apis = AppServer.INSTANCE.getApis();
        MicroBean blueSelectUser = getMAdapter().getBlueSelectUser();
        String str2 = "";
        if (blueSelectUser == null || (str = blueSelectUser.getExternalId()) == null) {
            str = "";
        }
        MicroBean redSelectUser = getMAdapter().getRedSelectUser();
        if (redSelectUser != null && (externalId = redSelectUser.getExternalId()) != null) {
            str2 = externalId;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.pk1v1Start(str, str2, this.mTime, MeetingRoomManager.INSTANCE.getMGroupId()), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.g
            public final Object invoke(Object obj) {
                Unit createPK$lambda$14;
                createPK$lambda$14 = Create1v1PKDialog.createPK$lambda$14(Create1v1PKDialog.this, (ApiResponse) obj);
                return createPK$lambda$14;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.h
            public final Object invoke(Object obj) {
                Unit createPK$lambda$15;
                createPK$lambda$15 = Create1v1PKDialog.createPK$lambda$15(Create1v1PKDialog.this, (Throwable) obj);
                return createPK$lambda$15;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createPK$lambda$14(Create1v1PKDialog create1v1PKDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        create1v1PKDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createPK$lambda$15(Create1v1PKDialog create1v1PKDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = create1v1PKDialog.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(create1v1PKDialog, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pk1v1Adapter getMAdapter() {
        return (Pk1v1Adapter) this.mAdapter.getValue();
    }

    private final void initView() {
        if (!this.timeList.isEmpty()) {
            ((DialogCreate1v1PkBinding) getBinding()).selectTime.setText(this.timeList.get(0));
        }
        View view = ((DialogCreate1v1PkBinding) getBinding()).memberBg;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        view.setBackground(ShapeUtil.createShape$default(shapeUtil, "#4c000000", "#4c000000", 12, (GradientDrawable.Orientation) null, 8, (Object) null));
        ((DialogCreate1v1PkBinding) getBinding()).timeBg.setBackground(ShapeUtil.createShape$default(shapeUtil, "#4c000000", "#4c000000", 12, (GradientDrawable.Orientation) null, 8, (Object) null));
        ImageView imageView = ((DialogCreate1v1PkBinding) getBinding()).bg;
        Intrinsics.checkNotNullExpressionValue(imageView, "bg");
        ImageKtxKt.toHorizontalMirror(imageView, R.drawable.pk1v1_create_bg);
        final ImageView imageView2 = ((DialogCreate1v1PkBinding) getBinding()).helper;
        final long j = 800;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.Create1v1PKDialog$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                    Context context = this.getContext();
                    if (context != null) {
                        new PK1v1RuleDialog(context).show();
                    }
                }
            }
        });
        final View view2 = ((DialogCreate1v1PkBinding) getBinding()).topView;
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.Create1v1PKDialog$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(view2) > j || (view2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(view2, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        final ImageView imageView3 = ((DialogCreate1v1PkBinding) getBinding()).close;
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.Create1v1PKDialog$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView3) > j || (imageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView3, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        final View view3 = ((DialogCreate1v1PkBinding) getBinding()).startBg;
        view3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.Create1v1PKDialog$initView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                Pk1v1Adapter mAdapter;
                Pk1v1Adapter mAdapter2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(view3) > j || (view3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(view3, currentTimeMillis);
                    mAdapter = this.getMAdapter();
                    if (mAdapter.getRedSelectUser() != null) {
                        mAdapter2 = this.getMAdapter();
                        if (mAdapter2.getBlueSelectUser() != null) {
                            this.createPK();
                        }
                    }
                }
            }
        });
        ((DialogCreate1v1PkBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        ArrayList arrayList = new ArrayList();
        Collection<MicroBean> values = MeetingRoomManager.INSTANCE.getMMicQueueMemberMap().values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        for (MicroBean microBean : values) {
            if (microBean.getUser() != null) {
                arrayList.add(microBean);
            }
        }
        getMAdapter().setList(arrayList);
        final QMUIRadiusImageView qMUIRadiusImageView = ((DialogCreate1v1PkBinding) getBinding()).blueAvatar;
        qMUIRadiusImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.Create1v1PKDialog$initView$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                Pk1v1Adapter mAdapter;
                Pk1v1Adapter mAdapter2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView) > j || (qMUIRadiusImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(qMUIRadiusImageView, currentTimeMillis);
                    QMUIRadiusImageView qMUIRadiusImageView2 = qMUIRadiusImageView;
                    mAdapter = this.getMAdapter();
                    mAdapter.setSelectModel(0);
                    mAdapter2 = this.getMAdapter();
                    mAdapter2.notifyDataSetChanged();
                    this.refreshSelect();
                }
            }
        });
        final QMUIRadiusImageView qMUIRadiusImageView2 = ((DialogCreate1v1PkBinding) getBinding()).redAvatar;
        qMUIRadiusImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.Create1v1PKDialog$initView$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                Pk1v1Adapter mAdapter;
                Pk1v1Adapter mAdapter2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView2) > j || (qMUIRadiusImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(qMUIRadiusImageView2, currentTimeMillis);
                    QMUIRadiusImageView qMUIRadiusImageView3 = qMUIRadiusImageView2;
                    mAdapter = this.getMAdapter();
                    mAdapter.setSelectModel(1);
                    mAdapter2 = this.getMAdapter();
                    mAdapter2.notifyDataSetChanged();
                    this.refreshSelect();
                }
            }
        });
        final View view4 = ((DialogCreate1v1PkBinding) getBinding()).timeBg;
        view4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.Create1v1PKDialog$initView$$inlined$singleClick$default$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                ArrayList arrayList2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(view4) > j || (view4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(view4, currentTimeMillis);
                    Context context = this.getContext();
                    if (context != null) {
                        BaseSelectDialog baseSelectDialog = new BaseSelectDialog(context);
                        arrayList2 = this.timeList;
                        BaseSelectDialog dataListOfString = baseSelectDialog.setDataListOfString(arrayList2);
                        final Create1v1PKDialog create1v1PKDialog = this;
                        dataListOfString.setListener(new SelectInterface() { // from class: com.qiahao.nextvideo.room.dialog.Create1v1PKDialog$initView$8$1$1
                            public void onSelect(int index) {
                                int i;
                                ArrayList arrayList3;
                                List<Integer> groupPk1V1;
                                Create1v1PKDialog create1v1PKDialog2 = Create1v1PKDialog.this;
                                GroupDetailBean mGroupDetailBean = MeetingRoomManager.INSTANCE.getMGroupDetailBean();
                                if (mGroupDetailBean != null && (groupPk1V1 = mGroupDetailBean.getGroupPk1V1()) != null) {
                                    i = groupPk1V1.get(index).intValue();
                                } else {
                                    i = 5;
                                }
                                create1v1PKDialog2.mTime = i;
                                TextView textView = Create1v1PKDialog.access$getBinding(Create1v1PKDialog.this).selectTime;
                                arrayList3 = Create1v1PKDialog.this.timeList;
                                textView.setText((CharSequence) arrayList3.get(index));
                            }
                        }).show();
                    }
                }
            }
        });
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.dialog.e
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view5, int i) {
                Create1v1PKDialog.initView$lambda$13(Create1v1PKDialog.this, baseQuickAdapter, view5, i);
            }
        });
        refreshSelect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$13(Create1v1PKDialog create1v1PKDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        MicroBean microBean = (MicroBean) create1v1PKDialog.getMAdapter().getData().get(i);
        String str7 = null;
        if (create1v1PKDialog.getMAdapter().getSelectModel() == 0) {
            MicroUserBean user = microBean.getUser();
            if (user != null) {
                str4 = user.getExternalId();
            } else {
                str4 = null;
            }
            MicroBean blueSelectUser = create1v1PKDialog.getMAdapter().getBlueSelectUser();
            if (blueSelectUser != null) {
                str5 = blueSelectUser.getExternalId();
            } else {
                str5 = null;
            }
            if (!Intrinsics.areEqual(str4, str5)) {
                MicroUserBean user2 = microBean.getUser();
                if (user2 != null) {
                    str6 = user2.getExternalId();
                } else {
                    str6 = null;
                }
                MicroBean redSelectUser = create1v1PKDialog.getMAdapter().getRedSelectUser();
                if (redSelectUser != null) {
                    str7 = redSelectUser.getExternalId();
                }
                if (!Intrinsics.areEqual(str6, str7)) {
                    create1v1PKDialog.getMAdapter().setBlueSelectUser(microBean);
                    if (create1v1PKDialog.getMAdapter().getRedSelectUser() == null) {
                        create1v1PKDialog.getMAdapter().setSelectModel(1);
                    }
                    create1v1PKDialog.getMAdapter().notifyDataSetChanged();
                    create1v1PKDialog.refreshSelect();
                    return;
                }
                return;
            }
            return;
        }
        if (create1v1PKDialog.getMAdapter().getSelectModel() == 1) {
            MicroUserBean user3 = microBean.getUser();
            if (user3 != null) {
                str = user3.getExternalId();
            } else {
                str = null;
            }
            MicroBean blueSelectUser2 = create1v1PKDialog.getMAdapter().getBlueSelectUser();
            if (blueSelectUser2 != null) {
                str2 = blueSelectUser2.getExternalId();
            } else {
                str2 = null;
            }
            if (!Intrinsics.areEqual(str, str2)) {
                MicroUserBean user4 = microBean.getUser();
                if (user4 != null) {
                    str3 = user4.getExternalId();
                } else {
                    str3 = null;
                }
                MicroBean redSelectUser2 = create1v1PKDialog.getMAdapter().getRedSelectUser();
                if (redSelectUser2 != null) {
                    str7 = redSelectUser2.getExternalId();
                }
                if (!Intrinsics.areEqual(str3, str7)) {
                    create1v1PKDialog.getMAdapter().setRedSelectUser(microBean);
                    create1v1PKDialog.getMAdapter().notifyDataSetChanged();
                    create1v1PKDialog.refreshSelect();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pk1v1Adapter mAdapter_delegate$lambda$2() {
        return new Pk1v1Adapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshSelect() {
        String str;
        String str2;
        String str3;
        MicroUserBean user;
        MicroUserBean user2;
        String str4;
        String str5;
        MicroUserBean user3;
        MicroUserBean user4;
        MicroBean blueSelectUser = getMAdapter().getBlueSelectUser();
        String str6 = null;
        if (blueSelectUser != null) {
            str = blueSelectUser.getExternalId();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            ((DialogCreate1v1PkBinding) getBinding()).blueDefault.setVisibility(0);
            QMUIRadiusImageView qMUIRadiusImageView = ((DialogCreate1v1PkBinding) getBinding()).blueAvatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "blueAvatar");
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.pk1v1_create_blue_default_head), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            ((DialogCreate1v1PkBinding) getBinding()).blueHead.setVisibility(8);
            ((DialogCreate1v1PkBinding) getBinding()).blueSelect.setVisibility(8);
        } else {
            ((DialogCreate1v1PkBinding) getBinding()).blueDefault.setVisibility(8);
            ((DialogCreate1v1PkBinding) getBinding()).blueHead.setVisibility(0);
            ((DialogCreate1v1PkBinding) getBinding()).blueSelect.setVisibility(0);
            QMUIRadiusImageView qMUIRadiusImageView2 = ((DialogCreate1v1PkBinding) getBinding()).blueAvatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "blueAvatar");
            MicroBean blueSelectUser2 = getMAdapter().getBlueSelectUser();
            if (blueSelectUser2 != null && (user2 = blueSelectUser2.getUser()) != null) {
                str2 = user2.getAvatar();
            } else {
                str2 = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, ImageSizeKt.image200(str2), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            TextView textView = ((DialogCreate1v1PkBinding) getBinding()).blueNick;
            MicroBean blueSelectUser3 = getMAdapter().getBlueSelectUser();
            if (blueSelectUser3 != null && (user = blueSelectUser3.getUser()) != null) {
                str3 = user.getNick();
            } else {
                str3 = null;
            }
            textView.setText(str3);
        }
        MicroBean redSelectUser = getMAdapter().getRedSelectUser();
        if (redSelectUser != null) {
            str4 = redSelectUser.getExternalId();
        } else {
            str4 = null;
        }
        if (TextUtils.isEmpty(str4)) {
            ((DialogCreate1v1PkBinding) getBinding()).redDefault.setVisibility(0);
            QMUIRadiusImageView qMUIRadiusImageView3 = ((DialogCreate1v1PkBinding) getBinding()).redAvatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView3, "redAvatar");
            ImageKtxKt.loadImage$default(qMUIRadiusImageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.pk1v1_create_red_default_head), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            ((DialogCreate1v1PkBinding) getBinding()).redHead.setVisibility(8);
            ((DialogCreate1v1PkBinding) getBinding()).redSelect.setVisibility(8);
        } else {
            ((DialogCreate1v1PkBinding) getBinding()).redDefault.setVisibility(8);
            ((DialogCreate1v1PkBinding) getBinding()).redHead.setVisibility(0);
            ((DialogCreate1v1PkBinding) getBinding()).redSelect.setVisibility(0);
            QMUIRadiusImageView qMUIRadiusImageView4 = ((DialogCreate1v1PkBinding) getBinding()).redAvatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView4, "redAvatar");
            MicroBean redSelectUser2 = getMAdapter().getRedSelectUser();
            if (redSelectUser2 != null && (user4 = redSelectUser2.getUser()) != null) {
                str5 = user4.getAvatar();
            } else {
                str5 = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView4, ImageSizeKt.image200(str5), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            TextView textView2 = ((DialogCreate1v1PkBinding) getBinding()).redNick;
            MicroBean redSelectUser3 = getMAdapter().getRedSelectUser();
            if (redSelectUser3 != null && (user3 = redSelectUser3.getUser()) != null) {
                str6 = user3.getNick();
            }
            textView2.setText(str6);
        }
        ViewGroup.LayoutParams layoutParams = ((DialogCreate1v1PkBinding) getBinding()).triangle.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.b) layoutParams;
        if (getMAdapter().getSelectModel() == 0) {
            ((ConstraintLayout.b) layoutParams2).t = ((DialogCreate1v1PkBinding) getBinding()).blueAvatar.getId();
            ((ConstraintLayout.b) layoutParams2).v = ((DialogCreate1v1PkBinding) getBinding()).blueAvatar.getId();
            ((DialogCreate1v1PkBinding) getBinding()).blueAvatar.setAlpha(1.0f);
            ((DialogCreate1v1PkBinding) getBinding()).blueDefault.setAlpha(1.0f);
            ((DialogCreate1v1PkBinding) getBinding()).blueHead.setAlpha(1.0f);
            ((DialogCreate1v1PkBinding) getBinding()).blueSelect.setAlpha(1.0f);
            ((DialogCreate1v1PkBinding) getBinding()).blueNick.setAlpha(1.0f);
            ((DialogCreate1v1PkBinding) getBinding()).redAvatar.setAlpha(0.7f);
            ((DialogCreate1v1PkBinding) getBinding()).redDefault.setAlpha(0.2f);
            ((DialogCreate1v1PkBinding) getBinding()).redHead.setAlpha(0.5f);
            ((DialogCreate1v1PkBinding) getBinding()).redSelect.setAlpha(0.5f);
            ((DialogCreate1v1PkBinding) getBinding()).redNick.setAlpha(0.5f);
            try {
                SpannableTextBuilder spannableTextBuilder = new SpannableTextBuilder(((DialogCreate1v1PkBinding) getBinding()).selectTitle);
                String format = String.format(ResourcesKtxKt.getStringById(this, 2131954020), Arrays.copyOf(new Object[]{ResourcesKtxKt.getStringById(this, 2131952133)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                SpannableTextBuilder.changeTextColor$default(spannableTextBuilder, format, ResourcesKtxKt.getStringById(this, 2131952133), Integer.valueOf(Color.parseColor("#3496FF")), (Integer) null, 8, (Object) null).apply();
            } catch (Exception unused) {
                TextView textView3 = ((DialogCreate1v1PkBinding) getBinding()).selectTitle;
                String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131954020), Arrays.copyOf(new Object[]{ResourcesKtxKt.getStringById(this, 2131952133)}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                textView3.setText(format2);
            }
        } else if (getMAdapter().getSelectModel() == 1) {
            ((ConstraintLayout.b) layoutParams2).t = ((DialogCreate1v1PkBinding) getBinding()).redAvatar.getId();
            ((ConstraintLayout.b) layoutParams2).v = ((DialogCreate1v1PkBinding) getBinding()).redAvatar.getId();
            ((DialogCreate1v1PkBinding) getBinding()).blueAvatar.setAlpha(0.75f);
            ((DialogCreate1v1PkBinding) getBinding()).blueDefault.setAlpha(0.15f);
            ((DialogCreate1v1PkBinding) getBinding()).blueHead.setAlpha(0.5f);
            ((DialogCreate1v1PkBinding) getBinding()).blueSelect.setAlpha(0.5f);
            ((DialogCreate1v1PkBinding) getBinding()).blueNick.setAlpha(0.5f);
            ((DialogCreate1v1PkBinding) getBinding()).redAvatar.setAlpha(1.0f);
            ((DialogCreate1v1PkBinding) getBinding()).redDefault.setAlpha(1.0f);
            ((DialogCreate1v1PkBinding) getBinding()).redHead.setAlpha(1.0f);
            ((DialogCreate1v1PkBinding) getBinding()).redSelect.setAlpha(1.0f);
            ((DialogCreate1v1PkBinding) getBinding()).redNick.setAlpha(1.0f);
            try {
                SpannableTextBuilder spannableTextBuilder2 = new SpannableTextBuilder(((DialogCreate1v1PkBinding) getBinding()).selectTitle);
                String format3 = String.format(ResourcesKtxKt.getStringById(this, 2131954020), Arrays.copyOf(new Object[]{ResourcesKtxKt.getStringById(this, 2131953873)}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                SpannableTextBuilder.changeTextColor$default(spannableTextBuilder2, format3, ResourcesKtxKt.getStringById(this, 2131953873), Integer.valueOf(Color.parseColor("#FF344C")), (Integer) null, 8, (Object) null).apply();
            } catch (Exception unused2) {
                TextView textView4 = ((DialogCreate1v1PkBinding) getBinding()).selectTitle;
                String format4 = String.format(ResourcesKtxKt.getStringById(this, 2131954020), Arrays.copyOf(new Object[]{ResourcesKtxKt.getStringById(this, 2131953873)}, 1));
                Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
                textView4.setText(format4);
            }
        }
        ((DialogCreate1v1PkBinding) getBinding()).triangle.setLayoutParams(layoutParams2);
        if (getMAdapter().getRedSelectUser() != null && getMAdapter().getBlueSelectUser() != null) {
            ((DialogCreate1v1PkBinding) getBinding()).startBg.setAlpha(1.0f);
            ((DialogCreate1v1PkBinding) getBinding()).tick.setAlpha(1.0f);
            ((DialogCreate1v1PkBinding) getBinding()).startPk.setAlpha(1.0f);
        } else {
            ((DialogCreate1v1PkBinding) getBinding()).startBg.setAlpha(0.5f);
            ((DialogCreate1v1PkBinding) getBinding()).tick.setAlpha(0.5f);
            ((DialogCreate1v1PkBinding) getBinding()).startPk.setAlpha(0.5f);
        }
    }

    public void dismiss() {
        super/*androidx.fragment.app.DialogFragment*/.dismiss();
        this.mCompositeDisposable.d();
        Function0<Unit> function0 = this.mListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    protected int getGravity() {
        return 80;
    }

    protected int getHeight() {
        return -1;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_create_1v1_pk;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @Nullable
    public final Function0<Unit> getMListener() {
        return this.mListener;
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseDialogFragment*/.onInitialize();
        initView();
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void setMListener(@Nullable Function0<Unit> function0) {
        this.mListener = function0;
    }
}
