package com.qiahao.nextvideo.room.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityCommonChangeRoomSettingBinding;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001#B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\b\u0010\u001b\u001a\u00020\tH\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\tH\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/CommonChangeRoomSettingActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityCommonChangeRoomSettingBinding;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "mText", "", "getLayoutResId", "", "viewModel", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "getViewModel", "()Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mType", "mMaxTextNumber", "getMMaxTextNumber", "()I", "setMMaxTextNumber", "(I)V", "onInitialize", "", "onRoomEvent", "event", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "getTypeMaxNumber", "getTypeEditTextContent", "getTypeMinHeight", "getTypeHint", "getTypeTitle", "onClick", "v", "Landroid/view/View;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CommonChangeRoomSettingActivity extends HiloBaseBindingActivity<ActivityCommonChangeRoomSettingBinding> implements View.OnClickListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TEXT_VIEW_STRING = "text_view_type";
    public static final int TYPE_ROOM_ANNOUNCEMENT = 3;
    public static final int TYPE_ROOM_AUTO_WELCOME = 4;
    public static final int TYPE_ROOM_INTRODUCTION = 2;
    public static final int TYPE_ROOM_NAME = 1;

    @NotNull
    public static final String TYPE_STRING = "type";
    private int mMaxTextNumber;
    private int mType;

    @NotNull
    private String mText = "";

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.activity.n
        public final Object invoke() {
            BaseViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = CommonChangeRoomSettingActivity.viewModel_delegate$lambda$0(CommonChangeRoomSettingActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/CommonChangeRoomSettingActivity$Companion;", "", "<init>", "()V", "TYPE_STRING", "", "TEXT_VIEW_STRING", "TYPE_ROOM_NAME", "", "TYPE_ROOM_INTRODUCTION", "TYPE_ROOM_ANNOUNCEMENT", "TYPE_ROOM_AUTO_WELCOME", "start", "", "context", "Landroid/content/Context;", "requestCode", "text", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context, int requestCode, @NotNull String text) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(text, "text");
            Intent putExtra = new Intent(context, (Class<?>) CommonChangeRoomSettingActivity.class).putExtra("type", requestCode).putExtra(CommonChangeRoomSettingActivity.TEXT_VIEW_STRING, text);
            Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
            ((Activity) context).startActivityForResult(putExtra, requestCode);
        }

        private Companion() {
        }
    }

    private final void getTypeEditTextContent() {
        EditText editText = getBinding().etContent;
        editText.setHint(getTypeHint());
        editText.setMinHeight(getTypeMinHeight());
        editText.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.room.activity.CommonChangeRoomSettingActivity$getTypeEditTextContent$1$1
            @Override // android.text.TextWatcher
            @SuppressLint({"SetTextI18n"})
            public void afterTextChanged(Editable s) {
                ActivityCommonChangeRoomSettingBinding binding;
                Intrinsics.checkNotNullParameter(s, "s");
                if (s.length() <= CommonChangeRoomSettingActivity.this.getMMaxTextNumber()) {
                    binding = CommonChangeRoomSettingActivity.this.getBinding();
                    binding.textNumber.setText(s.length() + "/" + CommonChangeRoomSettingActivity.this.getMMaxTextNumber());
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

    /* JADX WARN: Multi-variable type inference failed */
    private final String getTypeHint() {
        int i = this.mType;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return "";
                    }
                    String string = getString(2131953675);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    return string;
                }
                String string2 = getString(2131952616);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            }
            String string3 = getString(2131952974);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        String string4 = getString(2131952975);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        return string4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
    
        if (r0 != 4) goto L١٣;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int getTypeMaxNumber() {
        int i = this.mType;
        int i2 = 30;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    i2 = UserProxyUtility.cpUpgrades;
                }
            }
            i2 = 500;
        }
        this.mMaxTextNumber = i2;
        return i2;
    }

    private final int getTypeMinHeight() {
        int i = this.mType;
        if (i != 1) {
            if (i != 2) {
                if (i != 3 && i != 4) {
                    return Dimens.INSTANCE.dpToPx(49);
                }
                return Dimens.INSTANCE.dpToPx(145);
            }
            return Dimens.INSTANCE.dpToPx(100);
        }
        return Dimens.INSTANCE.dpToPx(49);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String getTypeTitle() {
        int i = this.mType;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return "";
                    }
                    String string = getString(2131952956);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    return string;
                }
                String string2 = getString(2131953016);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            }
            String string3 = getString(2131953017);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        String string4 = getString(2131952999);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        return string4;
    }

    private final BaseViewModel getViewModel() {
        return (BaseViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$1(CommonChangeRoomSettingActivity commonChangeRoomSettingActivity, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = commonChangeRoomSettingActivity.getBinding().titleBar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMargins(0, i, 0, 0);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void start(@NotNull Context context, int i, @NotNull String str) {
        INSTANCE.start(context, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseViewModel viewModel_delegate$lambda$0(CommonChangeRoomSettingActivity commonChangeRoomSettingActivity) {
        return new ViewModelProvider(commonChangeRoomSettingActivity).get(BaseViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_common_change_room_setting;
    }

    public final int getMMaxTextNumber() {
        return this.mMaxTextNumber;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131362039) {
            if (id2 == 2131364705) {
                Editable text = ((ActivityCommonChangeRoomSettingBinding) getBinding()).etContent.getText();
                Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                if (text.length() == 0) {
                    HiloToasty.Companion companion = HiloToasty.Companion;
                    String string = getString(2131952667);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    Toast normal$default = HiloToasty.Companion.normal$default(companion, this, string, false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                        return;
                    }
                    return;
                }
                String obj = ((ActivityCommonChangeRoomSettingBinding) getBinding()).etContent.getText().toString();
                if (StringsKt.replace$default(obj, " ", "", false, 4, (Object) null).length() == 0) {
                    HiloToasty.Companion companion2 = HiloToasty.Companion;
                    String string2 = getString(2131952667);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    Toast normal$default2 = HiloToasty.Companion.normal$default(companion2, this, string2, false, 4, (Object) null);
                    if (normal$default2 != null) {
                        normal$default2.show();
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual(obj, this.mText) && 4 == this.mType) {
                    HiloToasty.Companion companion3 = HiloToasty.Companion;
                    String string3 = getString(2131952667);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    Toast normal$default3 = HiloToasty.Companion.normal$default(companion3, this, string3, false, 4, (Object) null);
                    if (normal$default3 != null) {
                        normal$default3.show();
                        return;
                    }
                    return;
                }
                setResult(-1, new Intent().putExtra("type", ((ActivityCommonChangeRoomSettingBinding) getBinding()).etContent.getText().toString()));
                finish();
                return;
            }
            return;
        }
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        this.mType = getIntent().getIntExtra("type", 0);
        String stringExtra = getIntent().getStringExtra(TEXT_VIEW_STRING);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mText = stringExtra;
        ((ActivityCommonChangeRoomSettingBinding) getBinding()).setTitle(getTypeTitle());
        ((ActivityCommonChangeRoomSettingBinding) getBinding()).setClick(this);
        ((ActivityCommonChangeRoomSettingBinding) getBinding()).setNumber(Integer.valueOf(getTypeMaxNumber()));
        ((ActivityCommonChangeRoomSettingBinding) getBinding()).etContent.setText(this.mText);
        ((ActivityCommonChangeRoomSettingBinding) getBinding()).textNumber.setText(this.mText.length() + "/" + this.mMaxTextNumber);
        getTypeEditTextContent();
        Toolbar toolbar = ((ActivityCommonChangeRoomSettingBinding) getBinding()).titleBar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "titleBar");
        getStatusBarTopOrBottom(toolbar, new Function2() { // from class: com.qiahao.nextvideo.room.activity.o
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$1;
                onInitialize$lambda$1 = CommonChangeRoomSettingActivity.onInitialize$lambda$1(CommonChangeRoomSettingActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$1;
            }
        });
        setStatusBarIconColor(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onRoomEvent(@NotNull RoomEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getMEventId() == 214) {
            finish();
        }
    }

    public final void setMMaxTextNumber(int i) {
        this.mMaxTextNumber = i;
    }
}
