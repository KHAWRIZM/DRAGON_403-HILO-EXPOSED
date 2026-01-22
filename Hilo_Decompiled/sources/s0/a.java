package s0;

import java.util.Locale;
import tech.sud.gip.R;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.GameInfo;
import tech.sud.gip.core.PkgDownloadStatus;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a implements re.a {

    /* renamed from: a, reason: collision with root package name */
    public f.a f١٧٥٤١a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f١٧٥٤٢b;

    public a(i iVar) {
        this.f١٧٥٤٢b = iVar;
    }

    @Override // re.a
    public final void a() {
        LogUtils.file("SudGameLoadingStageLoadPackage", "PackageDownloadListener.onDownloadStart");
        SudLogger.d(i.f١٧٥٦٨j, "PackageDownloadListener.onDownloadStart");
        i iVar = this.f١٧٥٤٢b;
        if (!iVar.f١٧٥٧٤f) {
            iVar.f١٧٥٧١c.c(iVar.f١٧٥٦٩a.getString(R.string.fsm_mgp_game_loading_stage_loadPackage_game_package_download_start));
            this.f١٧٥٤١a = new f.a("checkoutGamePkg");
        }
    }

    @Override // re.a
    public final void b(String str, wf.e eVar) {
        SudLogger.v(i.f١٧٥٦٨j, "PackageDownloadListener.onSuccess");
        i iVar = this.f١٧٥٤٢b;
        if (!iVar.f١٧٥٧٤f) {
            iVar.f١٧٥٧١c.c(iVar.f١٧٥٦٩a.getString(R.string.fsm_mgp_game_loading_stage_loadPackage_game_package_download_finish));
            i iVar2 = this.f١٧٥٤٢b;
            GameInfo gameInfo = iVar2.f١٧٥٧٠b;
            gameInfo.gamePath = str;
            int i10 = gameInfo.engine;
            xe.a aVar = iVar2.f١٧٥٧٢d;
            f fVar = iVar2.f١٧٥٧٧i;
            if (1 == i10) {
                aVar.a.i(fVar);
            } else if (5 == i10) {
                aVar.b.i(fVar);
            } else {
                aVar.getClass();
            }
            f.a aVar2 = this.f١٧٥٤١a;
            if (aVar2 != null) {
                GameInfo gameInfo2 = this.f١٧٥٤٢b.f١٧٥٧٠b;
                if (gameInfo2 != null) {
                    aVar2.f١٤٠٠٧j.put("engine", Integer.valueOf(gameInfo2.engine));
                }
                this.f١٧٥٤١a.f١٤٠٠٧j.put("package_type", 2);
                f.a aVar3 = this.f١٧٥٤١a;
                aVar3.f١٤٠٠٢e = 0;
                aVar3.f١٤٠٠٣f = "success";
                aVar3.f١٤٠٠٤g = String.valueOf(this.f١٧٥٤٢b.f١٧٥٧٥g);
                f.a aVar4 = this.f١٧٥٤١a;
                aVar4.f١٤٠١١n = eVar;
                String str2 = f.d.f١٤٠٢٣a;
                ThreadUtils.postUITask(new f.b(aVar4.toString(), false, aVar4.f١٣٩٩٨a, aVar4.f١٤٠٠٢e));
            }
        }
    }

    @Override // re.a
    public final void d(long j10, long j11) {
        e eVar;
        SudLogger.v(i.f١٧٥٦٨j, "PackageDownloadListener.onDownloadProgress " + j10 + "/" + j11);
        i iVar = this.f١٧٥٤٢b;
        if (!iVar.f١٧٥٧٤f && (eVar = iVar.f١٧٥٧١c.f١٧٥٨٧a.f١٧٥٩٦h) != null) {
            eVar.f١٧٥٥٤k.setText(String.format(eVar.f١٧٥٤٨e.getString(R.string.fsm_mgp_game_loading_view_download_update_progress), eVar.f١٧٥٨٦b, String.format(Locale.US, "%.2fKB/%.2fKB", Float.valueOf((((float) j10) * 1.0f) / 1024.0f), Float.valueOf((((float) j11) * 1.0f) / 1024.0f))));
            eVar.d(j10, j11, 40, 80);
        }
    }

    @Override // re.a
    public final void e(int i10, String str, wf.e eVar) {
        SudLogger.e(i.f١٧٥٦٨j, "PackageDownloadListener.onFailure:" + str);
        i iVar = this.f١٧٥٤٢b;
        if (!iVar.f١٧٥٧٤f) {
            iVar.f١٧٥٧١c.c(iVar.f١٧٥٦٩a.getString(R.string.fsm_mgp_game_loading_stage_loadPackage_game_package_download_fail));
            this.f١٧٥٤٢b.f١٧٥٧١c.b(3, i10, str);
            f.a aVar = this.f١٧٥٤١a;
            if (aVar != null) {
                GameInfo gameInfo = this.f١٧٥٤٢b.f١٧٥٧٠b;
                if (gameInfo != null) {
                    aVar.f١٤٠٠٧j.put("engine", Integer.valueOf(gameInfo.engine));
                }
                this.f١٧٥٤١a.f١٤٠٠٧j.put("package_type", 2);
                f.a aVar2 = this.f١٧٥٤١a;
                aVar2.f١٤٠٠٢e = i10;
                if (str != null) {
                    aVar2.f١٤٠٠٣f = str;
                }
                aVar2.f١٤٠٠٤g = String.valueOf(this.f١٧٥٤٢b.f١٧٥٧٥g);
                f.a aVar3 = this.f١٧٥٤١a;
                aVar3.f١٤٠١١n = eVar;
                String str2 = f.d.f١٤٠٢٣a;
                ThreadUtils.postUITask(new f.b(aVar3.toString(), false, aVar3.f١٣٩٩٨a, aVar3.f١٤٠٠٢e));
            }
        }
    }

    @Override // re.a
    public final void c(long j10, long j11, PkgDownloadStatus pkgDownloadStatus) {
    }
}
