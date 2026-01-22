package io.agora.rtc.audio;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class SpatialAudioParams {
    public Boolean enable_air_absorb;
    public Boolean enable_blur;
    public Double spk_azimuth;
    public Double spk_distance;
    public Double spk_elevation;
    public Integer spk_orientation;

    public void enableAirAbsorb(Boolean bool) {
        this.enable_air_absorb = bool;
    }

    public void enableBlur(Boolean bool) {
        this.enable_blur = bool;
    }

    public Boolean getAirAbsorbFlag() {
        return this.enable_air_absorb;
    }

    public Boolean getBlurFlag() {
        return this.enable_blur;
    }

    public Double getSpeakerAzimuth() {
        return this.spk_azimuth;
    }

    public Double getSpeakerDistance() {
        return this.spk_distance;
    }

    public Double getSpeakerElevation() {
        return this.spk_elevation;
    }

    public Integer getSpeakerOrientation() {
        return this.spk_orientation;
    }

    public void setSpeakerAzimuth(Double d10) {
        this.spk_azimuth = d10;
    }

    public void setSpeakerDistance(Double d10) {
        this.spk_distance = d10;
    }

    public void setSpeakerElevation(Double d10) {
        this.spk_elevation = d10;
    }

    public void setSpeakerOrientation(Integer num) {
        this.spk_orientation = num;
    }
}
