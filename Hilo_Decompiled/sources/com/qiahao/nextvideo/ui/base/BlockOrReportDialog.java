package com.qiahao.nextvideo.ui.base;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatButton;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.interfaceing.SelectInterface;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.DialogItemData;
import com.qiahao.nextvideo.databinding.DialogBlockOrReportBinding;
import com.qiahao.nextvideo.databinding.IncludeReportItemBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\"\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u0014H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/ui/base/BlockOrReportDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogBlockOrReportBinding;", "mContext", "Landroid/content/Context;", "list", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/DialogItemData;", "Lkotlin/collections/ArrayList;", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getMContext", "()Landroid/content/Context;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "getLayoutResId", "", "isBottomStyle", "", "mListener", "Lcom/qiahao/base_common/interfaceing/SelectInterface;", "getMListener", "()Lcom/qiahao/base_common/interfaceing/SelectInterface;", "setMListener", "(Lcom/qiahao/base_common/interfaceing/SelectInterface;)V", "onInitialize", "", "refreshItem", "position", "data", "isEnd", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBlockOrReportDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockOrReportDialog.kt\ncom/qiahao/nextvideo/ui/base/BlockOrReportDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,344:1\n1878#2,3:345\n61#3,9:348\n61#3,9:357\n61#3,9:366\n61#3,9:375\n61#3,9:384\n61#3,9:393\n61#3,9:402\n61#3,9:411\n*S KotlinDebug\n*F\n+ 1 BlockOrReportDialog.kt\ncom/qiahao/nextvideo/ui/base/BlockOrReportDialog\n*L\n282#1:345,3\n286#1:348,9\n291#1:357,9\n296#1:366,9\n301#1:375,9\n306#1:384,9\n310#1:393,9\n314#1:402,9\n319#1:411,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BlockOrReportDialog extends BaseBindingDialog<DialogBlockOrReportBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String REPORT = "report";

    @NotNull
    public static final String REPORT_AND_BLOCK = "report_and_block";

    @NotNull
    public static final String REPORT_AND_DELETE = "report_and_delete";

    @NotNull
    public static final String REPORT_ROOM_MANAGE = "room_manage";

    @NotNull
    public static final String REPORT_USER = "report_user";

    @NotNull
    public static final String ROOM_LIST_REPORT_AND_DELETE = "room_list_report_and_delete";

    @Nullable
    private ArrayList<DialogItemData> list;

    @NotNull
    private final Context mContext;

    @Nullable
    private SelectInterface mListener;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/ui/base/BlockOrReportDialog$Companion;", "", "<init>", "()V", "REPORT_USER", "", "REPORT_AND_BLOCK", "REPORT", "REPORT_ROOM_MANAGE", "REPORT_AND_DELETE", "ROOM_LIST_REPORT_AND_DELETE", "getTextList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/DialogItemData;", "Lkotlin/collections/ArrayList;", "type", "isOfficialStaff", "", "svipPrivilege27", "svipPrivilege29", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ArrayList getTextList$default(Companion companion, String str, boolean z, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            if ((i & 8) != 0) {
                z3 = false;
            }
            return companion.getTextList(str, z, z2, z3);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x020d, code lost:
        
            return r2;
         */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final ArrayList<DialogItemData> getTextList(@NotNull String type, boolean isOfficialStaff, boolean svipPrivilege27, boolean svipPrivilege29) {
            Intrinsics.checkNotNullParameter(type, "type");
            ArrayList<DialogItemData> arrayList = new ArrayList<>();
            switch (type.hashCode()) {
                case -934521548:
                    if (type.equals("report")) {
                        arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131953910), 0));
                        if (isOfficialStaff) {
                            arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131954180), 5));
                        }
                        if (svipPrivilege27) {
                            arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131954352), 6));
                        }
                        if (svipPrivilege29) {
                            arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131952074), 7));
                            break;
                        }
                    }
                    break;
                case -793902374:
                    if (type.equals(BlockOrReportDialog.REPORT_AND_BLOCK)) {
                        if (isOfficialStaff) {
                            arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131954180), 5));
                        }
                        arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131953910), 0));
                        arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131952126), 1));
                        if (svipPrivilege27) {
                            arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131954352), 6));
                        }
                        if (svipPrivilege29) {
                            arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131952074), 7));
                            break;
                        }
                    }
                    break;
                case -576612479:
                    if (type.equals(BlockOrReportDialog.ROOM_LIST_REPORT_AND_DELETE)) {
                        arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131953910), 0));
                        arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131952126), 1));
                        break;
                    }
                    break;
                case -246517770:
                    if (type.equals(BlockOrReportDialog.REPORT_USER)) {
                        arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131953923), 2));
                        arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131953922), 3));
                        if (isOfficialStaff) {
                            arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131954180), 5));
                        }
                        arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131953910), 0));
                        arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131952126), 1));
                        if (svipPrivilege27) {
                            arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131954352), 6));
                        }
                        if (svipPrivilege29) {
                            arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131952074), 7));
                            break;
                        }
                    }
                    break;
                case 523664713:
                    if (type.equals(BlockOrReportDialog.REPORT_ROOM_MANAGE)) {
                        arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131953923), 2));
                        arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131953922), 3));
                        if (isOfficialStaff) {
                            arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131954180), 5));
                        }
                        arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131953910), 0));
                        arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131952126), 1));
                        if (svipPrivilege27) {
                            arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131954352), 6));
                        }
                        if (svipPrivilege29) {
                            arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131952074), 7));
                            break;
                        }
                    }
                    break;
                case 1209536766:
                    if (type.equals(BlockOrReportDialog.REPORT_AND_DELETE)) {
                        arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131953910), 0));
                        if (isOfficialStaff) {
                            arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131954180), 5));
                        }
                        arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131952536), 4));
                        if (svipPrivilege27) {
                            arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131954352), 6));
                        }
                        if (svipPrivilege29) {
                            arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131952074), 7));
                            break;
                        }
                    }
                    break;
            }
        }

        private Companion() {
        }
    }

    public /* synthetic */ BlockOrReportDialog(Context context, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : arrayList);
    }

    private final void refreshItem(int position, DialogItemData data, boolean isEnd) {
        IncludeReportItemBinding includeReportItemBinding;
        int i;
        switch (position) {
            case 0:
                includeReportItemBinding = ((DialogBlockOrReportBinding) getBinding()).oneLayout;
                break;
            case 1:
                includeReportItemBinding = ((DialogBlockOrReportBinding) getBinding()).twoLayout;
                break;
            case 2:
                includeReportItemBinding = ((DialogBlockOrReportBinding) getBinding()).threeLayout;
                break;
            case 3:
                includeReportItemBinding = ((DialogBlockOrReportBinding) getBinding()).fourLayout;
                break;
            case 4:
                includeReportItemBinding = ((DialogBlockOrReportBinding) getBinding()).fiveLayout;
                break;
            case 5:
                includeReportItemBinding = ((DialogBlockOrReportBinding) getBinding()).sixLayout;
                break;
            case 6:
                includeReportItemBinding = ((DialogBlockOrReportBinding) getBinding()).sevenLayout;
                break;
            default:
                includeReportItemBinding = null;
                break;
        }
        if (includeReportItemBinding != null) {
            int i2 = 0;
            includeReportItemBinding.getRoot().setVisibility(0);
            includeReportItemBinding.button.setText(data.getTitle());
            View view = includeReportItemBinding.line;
            if (isEnd) {
                i = 8;
            } else {
                i = 0;
            }
            view.setVisibility(i);
            ImageView imageView = includeReportItemBinding.svipType;
            if (data.getType() != 6 && data.getType() != 7) {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    static /* synthetic */ void refreshItem$default(BlockOrReportDialog blockOrReportDialog, int i, DialogItemData dialogItemData, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        blockOrReportDialog.refreshItem(i, dialogItemData, z);
    }

    protected int getLayoutResId() {
        return R.layout.dialog_block_or_report;
    }

    @Nullable
    public final ArrayList<DialogItemData> getList() {
        return this.list;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @Nullable
    public final SelectInterface getMListener() {
        return this.mListener;
    }

    protected boolean isBottomStyle() {
        return true;
    }

    public void onInitialize() {
        int i;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        ArrayList<DialogItemData> arrayList = this.list;
        if (arrayList != null) {
            int i2 = 0;
            for (Object obj : arrayList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                DialogItemData dialogItemData = (DialogItemData) obj;
                ArrayList<DialogItemData> arrayList2 = this.list;
                if (arrayList2 != null) {
                    i = arrayList2.size();
                } else {
                    i = 0;
                }
                boolean z = true;
                if (i2 != i - 1) {
                    z = false;
                }
                refreshItem(i2, dialogItemData, z);
                i2 = i3;
            }
        }
        final View root = ((DialogBlockOrReportBinding) getBinding()).oneLayout.getRoot();
        final long j = 800;
        root.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.base.BlockOrReportDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogItemData dialogItemData2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                    ArrayList<DialogItemData> list = this.getList();
                    if (list != null && (dialogItemData2 = list.get(0)) != null) {
                        int type = dialogItemData2.getType();
                        SelectInterface mListener = this.getMListener();
                        if (mListener != null) {
                            mListener.onSelect(type);
                        }
                    }
                    this.dismiss();
                }
            }
        });
        final View root2 = ((DialogBlockOrReportBinding) getBinding()).twoLayout.getRoot();
        root2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.base.BlockOrReportDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogItemData dialogItemData2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root2) > j || (root2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root2, currentTimeMillis);
                    ArrayList<DialogItemData> list = this.getList();
                    if (list != null && (dialogItemData2 = list.get(1)) != null) {
                        int type = dialogItemData2.getType();
                        SelectInterface mListener = this.getMListener();
                        if (mListener != null) {
                            mListener.onSelect(type);
                        }
                    }
                    this.dismiss();
                }
            }
        });
        final View root3 = ((DialogBlockOrReportBinding) getBinding()).threeLayout.getRoot();
        root3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.base.BlockOrReportDialog$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogItemData dialogItemData2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root3) > j || (root3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root3, currentTimeMillis);
                    ArrayList<DialogItemData> list = this.getList();
                    if (list != null && (dialogItemData2 = list.get(2)) != null) {
                        int type = dialogItemData2.getType();
                        SelectInterface mListener = this.getMListener();
                        if (mListener != null) {
                            mListener.onSelect(type);
                        }
                    }
                    this.dismiss();
                }
            }
        });
        final View root4 = ((DialogBlockOrReportBinding) getBinding()).fourLayout.getRoot();
        root4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.base.BlockOrReportDialog$onInitialize$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogItemData dialogItemData2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root4) > j || (root4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root4, currentTimeMillis);
                    ArrayList<DialogItemData> list = this.getList();
                    if (list != null && (dialogItemData2 = list.get(3)) != null) {
                        int type = dialogItemData2.getType();
                        SelectInterface mListener = this.getMListener();
                        if (mListener != null) {
                            mListener.onSelect(type);
                        }
                    }
                    this.dismiss();
                }
            }
        });
        final View root5 = ((DialogBlockOrReportBinding) getBinding()).fiveLayout.getRoot();
        root5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.base.BlockOrReportDialog$onInitialize$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogItemData dialogItemData2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root5) > j || (root5 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root5, currentTimeMillis);
                    ArrayList<DialogItemData> list = this.getList();
                    if (list != null && (dialogItemData2 = list.get(4)) != null) {
                        int type = dialogItemData2.getType();
                        SelectInterface mListener = this.getMListener();
                        if (mListener != null) {
                            mListener.onSelect(type);
                        }
                    }
                    this.dismiss();
                }
            }
        });
        final View root6 = ((DialogBlockOrReportBinding) getBinding()).sixLayout.getRoot();
        root6.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.base.BlockOrReportDialog$onInitialize$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogItemData dialogItemData2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root6) > j || (root6 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root6, currentTimeMillis);
                    ArrayList<DialogItemData> list = this.getList();
                    if (list != null && (dialogItemData2 = list.get(5)) != null) {
                        int type = dialogItemData2.getType();
                        SelectInterface mListener = this.getMListener();
                        if (mListener != null) {
                            mListener.onSelect(type);
                        }
                    }
                    this.dismiss();
                }
            }
        });
        final View root7 = ((DialogBlockOrReportBinding) getBinding()).sevenLayout.getRoot();
        root7.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.base.BlockOrReportDialog$onInitialize$$inlined$singleClick$default$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogItemData dialogItemData2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root7) > j || (root7 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root7, currentTimeMillis);
                    ArrayList<DialogItemData> list = this.getList();
                    if (list != null && (dialogItemData2 = list.get(6)) != null) {
                        int type = dialogItemData2.getType();
                        SelectInterface mListener = this.getMListener();
                        if (mListener != null) {
                            mListener.onSelect(type);
                        }
                    }
                    this.dismiss();
                }
            }
        });
        final AppCompatButton appCompatButton = ((DialogBlockOrReportBinding) getBinding()).cancelButton;
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.base.BlockOrReportDialog$onInitialize$$inlined$singleClick$default$8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton) > j || (appCompatButton instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton, currentTimeMillis);
                    AppCompatButton appCompatButton2 = appCompatButton;
                    this.dismiss();
                }
            }
        });
    }

    public final void setList(@Nullable ArrayList<DialogItemData> arrayList) {
        this.list = arrayList;
    }

    public final void setMListener(@Nullable SelectInterface selectInterface) {
        this.mListener = selectInterface;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockOrReportDialog(@NotNull Context context, @Nullable ArrayList<DialogItemData> arrayList) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
        this.list = arrayList;
    }
}
