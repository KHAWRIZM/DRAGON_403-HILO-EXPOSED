package k3;

import com.qiahao.base_common.room.roomDao.DownloadFileDao;
import com.qiahao.base_common.room.roomModel.DownloadFile;
import com.qiahao.hilo_message.activity.MediaDetailActivity;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f١٥٤٨٥a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaDetailActivity f١٥٤٨٦b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f١٥٤٨٧c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(MediaDetailActivity mediaDetailActivity, String str, Continuation continuation) {
        super(2, continuation);
        this.f١٥٤٨٦b = mediaDetailActivity;
        this.f١٥٤٨٧c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new e(this.f١٥٤٨٦b, this.f١٥٤٨٧c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new e(this.f١٥٤٨٦b, this.f١٥٤٨٧c, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DownloadFileDao downloadFileDao;
        String str;
        int i10;
        int i11;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i12 = this.f١٥٤٨٥a;
        if (i12 != 0) {
            if (i12 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            downloadFileDao = this.f١٥٤٨٦b.getDownloadFileDao();
            String str2 = this.f١٥٤٨٧c;
            if (str2 == null) {
                str2 = "";
            }
            str = this.f١٥٤٨٦b.downloadPath;
            i10 = this.f١٥٤٨٦b.mediaType;
            if (i10 == 0) {
                i11 = 0;
            } else {
                i11 = 1;
            }
            DownloadFile downloadFile = new DownloadFile(str2, str, i11);
            this.f١٥٤٨٥a = 1;
            if (downloadFileDao.insertDownloadFile(downloadFile, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
