package tech.sud.gip.core.network.detection;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class NetworkDetectionDetail {
    public long timestamp;
    public NetworkDetectionDetailType type;

    public NetworkDetectionDetail deepCopy() {
        NetworkDetectionDetail networkDetectionDetail = new NetworkDetectionDetail();
        networkDetectionDetail.type = this.type;
        networkDetectionDetail.timestamp = this.timestamp;
        return networkDetectionDetail;
    }
}
