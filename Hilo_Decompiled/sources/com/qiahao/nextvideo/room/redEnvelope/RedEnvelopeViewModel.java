package com.qiahao.nextvideo.room.redEnvelope;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.room.EnvelopeData;
import com.qiahao.nextvideo.data.room.EnvelopeRecordData;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0005J\b\u0010 \u001a\u00020\u001bH\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00138F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "mEnvelopeId", "", "getMEnvelopeId", "()J", "setMEnvelopeId", "(J)V", "redRecordBaseData", "Lcom/qiahao/base_common/model/BaseListData;", "getRedRecordBaseData", "()Lcom/qiahao/base_common/model/BaseListData;", "redRecordMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/nextvideo/data/room/EnvelopeRecordData;", "redRecord", "Landroidx/lifecycle/LiveData;", "getRedRecord", "()Landroidx/lifecycle/LiveData;", "redEnvelopInfoMutable", "Lcom/qiahao/nextvideo/data/room/EnvelopeData;", "redEnvelopInfo", "getRedEnvelopInfo", "envelopeRecord", "", "hasID", "", "getEnvelopeInfo", AgooConstants.MESSAGE_ID, "onCleared", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RedEnvelopeViewModel extends BaseViewModel {

    @NotNull
    public static final String ENVELOP_INFO = "EnvelopeInfo";
    private long mEnvelopeId;

    @NotNull
    private final MutableLiveData<EnvelopeData> redEnvelopInfoMutable;

    @NotNull
    private final BaseListData redRecordBaseData;

    @NotNull
    private final MutableLiveData<List<EnvelopeRecordData>> redRecordMutable;

    public RedEnvelopeViewModel() {
        BaseListData baseListData = new BaseListData();
        baseListData.setPageSize(20);
        this.redRecordBaseData = baseListData;
        this.redRecordMutable = new MutableLiveData<>();
        this.redEnvelopInfoMutable = new MutableLiveData<>();
    }

    public static /* synthetic */ void envelopeRecord$default(RedEnvelopeViewModel redEnvelopeViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        redEnvelopeViewModel.envelopeRecord(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit envelopeRecord$lambda$1(RedEnvelopeViewModel redEnvelopeViewModel, ApiResponse apiResponse) {
        List list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        redEnvelopeViewModel.redRecordBaseData.setList((ApiList) apiResponse.getData());
        MutableLiveData<List<EnvelopeRecordData>> mutableLiveData = redEnvelopeViewModel.redRecordMutable;
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList != null) {
            list = apiList.getData();
        } else {
            list = null;
        }
        mutableLiveData.setValue(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit envelopeRecord$lambda$2(RedEnvelopeViewModel redEnvelopeViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        redEnvelopeViewModel.redRecordBaseData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getEnvelopeInfo$lambda$3(RedEnvelopeViewModel redEnvelopeViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        redEnvelopeViewModel.redEnvelopInfoMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getEnvelopeInfo$lambda$4(RedEnvelopeViewModel redEnvelopeViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        redEnvelopeViewModel.getMException().setValue(new Pair(ENVELOP_INFO, th));
        return Unit.INSTANCE;
    }

    public final void envelopeRecord(boolean hasID) {
        Long l;
        ServerApi apis = AppServer.INSTANCE.getApis();
        if (hasID) {
            l = Long.valueOf(this.mEnvelopeId);
        } else {
            l = null;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.envelopeRecord(l, this.redRecordBaseData.nextPage(), this.redRecordBaseData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.room.redEnvelope.z
            public final Object invoke(Object obj) {
                Unit envelopeRecord$lambda$1;
                envelopeRecord$lambda$1 = RedEnvelopeViewModel.envelopeRecord$lambda$1(RedEnvelopeViewModel.this, (ApiResponse) obj);
                return envelopeRecord$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.redEnvelope.a0
            public final Object invoke(Object obj) {
                Unit envelopeRecord$lambda$2;
                envelopeRecord$lambda$2 = RedEnvelopeViewModel.envelopeRecord$lambda$2(RedEnvelopeViewModel.this, (Throwable) obj);
                return envelopeRecord$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void getEnvelopeInfo(long id2) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getEnvelopeData(id2, MeetingRoomManager.INSTANCE.getMGroupId()), new Function1() { // from class: com.qiahao.nextvideo.room.redEnvelope.b0
            public final Object invoke(Object obj) {
                Unit envelopeInfo$lambda$3;
                envelopeInfo$lambda$3 = RedEnvelopeViewModel.getEnvelopeInfo$lambda$3(RedEnvelopeViewModel.this, (ApiResponse) obj);
                return envelopeInfo$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.redEnvelope.c0
            public final Object invoke(Object obj) {
                Unit envelopeInfo$lambda$4;
                envelopeInfo$lambda$4 = RedEnvelopeViewModel.getEnvelopeInfo$lambda$4(RedEnvelopeViewModel.this, (Throwable) obj);
                return envelopeInfo$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final long getMEnvelopeId() {
        return this.mEnvelopeId;
    }

    @NotNull
    public final LiveData<EnvelopeData> getRedEnvelopInfo() {
        return this.redEnvelopInfoMutable;
    }

    @NotNull
    public final LiveData<List<EnvelopeRecordData>> getRedRecord() {
        return this.redRecordMutable;
    }

    @NotNull
    public final BaseListData getRedRecordBaseData() {
        return this.redRecordBaseData;
    }

    protected void onCleared() {
        super.onCleared();
        this.redRecordBaseData.destroy();
    }

    public final void setMEnvelopeId(long j) {
        this.mEnvelopeId = j;
    }
}
