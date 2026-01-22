package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UserImportJobType implements Serializable {
    private String cloudWatchLogsRoleArn;
    private Date completionDate;
    private String completionMessage;
    private Date creationDate;
    private Long failedUsers;
    private Long importedUsers;
    private String jobId;
    private String jobName;
    private String preSignedUrl;
    private Long skippedUsers;
    private Date startDate;
    private String status;
    private String userPoolId;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z30;
        boolean z31;
        boolean z32;
        boolean z33;
        boolean z34;
        boolean z35;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserImportJobType)) {
            return false;
        }
        UserImportJobType userImportJobType = (UserImportJobType) obj;
        if (userImportJobType.getJobName() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getJobName() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (userImportJobType.getJobName() != null && !userImportJobType.getJobName().equals(getJobName())) {
            return false;
        }
        if (userImportJobType.getJobId() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getJobId() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (userImportJobType.getJobId() != null && !userImportJobType.getJobId().equals(getJobId())) {
            return false;
        }
        if (userImportJobType.getUserPoolId() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getUserPoolId() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (userImportJobType.getUserPoolId() != null && !userImportJobType.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (userImportJobType.getPreSignedUrl() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getPreSignedUrl() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (userImportJobType.getPreSignedUrl() != null && !userImportJobType.getPreSignedUrl().equals(getPreSignedUrl())) {
            return false;
        }
        if (userImportJobType.getCreationDate() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getCreationDate() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (userImportJobType.getCreationDate() != null && !userImportJobType.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if (userImportJobType.getStartDate() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getStartDate() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (userImportJobType.getStartDate() != null && !userImportJobType.getStartDate().equals(getStartDate())) {
            return false;
        }
        if (userImportJobType.getCompletionDate() == null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (getCompletionDate() == null) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (z22 ^ z23) {
            return false;
        }
        if (userImportJobType.getCompletionDate() != null && !userImportJobType.getCompletionDate().equals(getCompletionDate())) {
            return false;
        }
        if (userImportJobType.getStatus() == null) {
            z24 = true;
        } else {
            z24 = false;
        }
        if (getStatus() == null) {
            z25 = true;
        } else {
            z25 = false;
        }
        if (z24 ^ z25) {
            return false;
        }
        if (userImportJobType.getStatus() != null && !userImportJobType.getStatus().equals(getStatus())) {
            return false;
        }
        if (userImportJobType.getCloudWatchLogsRoleArn() == null) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (getCloudWatchLogsRoleArn() == null) {
            z27 = true;
        } else {
            z27 = false;
        }
        if (z26 ^ z27) {
            return false;
        }
        if (userImportJobType.getCloudWatchLogsRoleArn() != null && !userImportJobType.getCloudWatchLogsRoleArn().equals(getCloudWatchLogsRoleArn())) {
            return false;
        }
        if (userImportJobType.getImportedUsers() == null) {
            z28 = true;
        } else {
            z28 = false;
        }
        if (getImportedUsers() == null) {
            z29 = true;
        } else {
            z29 = false;
        }
        if (z28 ^ z29) {
            return false;
        }
        if (userImportJobType.getImportedUsers() != null && !userImportJobType.getImportedUsers().equals(getImportedUsers())) {
            return false;
        }
        if (userImportJobType.getSkippedUsers() == null) {
            z30 = true;
        } else {
            z30 = false;
        }
        if (getSkippedUsers() == null) {
            z31 = true;
        } else {
            z31 = false;
        }
        if (z30 ^ z31) {
            return false;
        }
        if (userImportJobType.getSkippedUsers() != null && !userImportJobType.getSkippedUsers().equals(getSkippedUsers())) {
            return false;
        }
        if (userImportJobType.getFailedUsers() == null) {
            z32 = true;
        } else {
            z32 = false;
        }
        if (getFailedUsers() == null) {
            z33 = true;
        } else {
            z33 = false;
        }
        if (z32 ^ z33) {
            return false;
        }
        if (userImportJobType.getFailedUsers() != null && !userImportJobType.getFailedUsers().equals(getFailedUsers())) {
            return false;
        }
        if (userImportJobType.getCompletionMessage() == null) {
            z34 = true;
        } else {
            z34 = false;
        }
        if (getCompletionMessage() == null) {
            z35 = true;
        } else {
            z35 = false;
        }
        if (z34 ^ z35) {
            return false;
        }
        if (userImportJobType.getCompletionMessage() == null || userImportJobType.getCompletionMessage().equals(getCompletionMessage())) {
            return true;
        }
        return false;
    }

    public String getCloudWatchLogsRoleArn() {
        return this.cloudWatchLogsRoleArn;
    }

    public Date getCompletionDate() {
        return this.completionDate;
    }

    public String getCompletionMessage() {
        return this.completionMessage;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public Long getFailedUsers() {
        return this.failedUsers;
    }

    public Long getImportedUsers() {
        return this.importedUsers;
    }

    public String getJobId() {
        return this.jobId;
    }

    public String getJobName() {
        return this.jobName;
    }

    public String getPreSignedUrl() {
        return this.preSignedUrl;
    }

    public Long getSkippedUsers() {
        return this.skippedUsers;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public String getStatus() {
        return this.status;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
        int hashCode11;
        int hashCode12;
        int i10 = 0;
        if (getJobName() == null) {
            hashCode = 0;
        } else {
            hashCode = getJobName().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getJobId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getJobId().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getUserPoolId() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getUserPoolId().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getPreSignedUrl() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getPreSignedUrl().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getCreationDate() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getCreationDate().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getStartDate() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getStartDate().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getCompletionDate() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getCompletionDate().hashCode();
        }
        int i17 = (i16 + hashCode7) * 31;
        if (getStatus() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = getStatus().hashCode();
        }
        int i18 = (i17 + hashCode8) * 31;
        if (getCloudWatchLogsRoleArn() == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = getCloudWatchLogsRoleArn().hashCode();
        }
        int i19 = (i18 + hashCode9) * 31;
        if (getImportedUsers() == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = getImportedUsers().hashCode();
        }
        int i20 = (i19 + hashCode10) * 31;
        if (getSkippedUsers() == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = getSkippedUsers().hashCode();
        }
        int i21 = (i20 + hashCode11) * 31;
        if (getFailedUsers() == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = getFailedUsers().hashCode();
        }
        int i22 = (i21 + hashCode12) * 31;
        if (getCompletionMessage() != null) {
            i10 = getCompletionMessage().hashCode();
        }
        return i22 + i10;
    }

    public void setCloudWatchLogsRoleArn(String str) {
        this.cloudWatchLogsRoleArn = str;
    }

    public void setCompletionDate(Date date) {
        this.completionDate = date;
    }

    public void setCompletionMessage(String str) {
        this.completionMessage = str;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setFailedUsers(Long l10) {
        this.failedUsers = l10;
    }

    public void setImportedUsers(Long l10) {
        this.importedUsers = l10;
    }

    public void setJobId(String str) {
        this.jobId = str;
    }

    public void setJobName(String str) {
        this.jobName = str;
    }

    public void setPreSignedUrl(String str) {
        this.preSignedUrl = str;
    }

    public void setSkippedUsers(Long l10) {
        this.skippedUsers = l10;
    }

    public void setStartDate(Date date) {
        this.startDate = date;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getJobName() != null) {
            sb.append("JobName: " + getJobName() + ",");
        }
        if (getJobId() != null) {
            sb.append("JobId: " + getJobId() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getPreSignedUrl() != null) {
            sb.append("PreSignedUrl: " + getPreSignedUrl() + ",");
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate() + ",");
        }
        if (getStartDate() != null) {
            sb.append("StartDate: " + getStartDate() + ",");
        }
        if (getCompletionDate() != null) {
            sb.append("CompletionDate: " + getCompletionDate() + ",");
        }
        if (getStatus() != null) {
            sb.append("Status: " + getStatus() + ",");
        }
        if (getCloudWatchLogsRoleArn() != null) {
            sb.append("CloudWatchLogsRoleArn: " + getCloudWatchLogsRoleArn() + ",");
        }
        if (getImportedUsers() != null) {
            sb.append("ImportedUsers: " + getImportedUsers() + ",");
        }
        if (getSkippedUsers() != null) {
            sb.append("SkippedUsers: " + getSkippedUsers() + ",");
        }
        if (getFailedUsers() != null) {
            sb.append("FailedUsers: " + getFailedUsers() + ",");
        }
        if (getCompletionMessage() != null) {
            sb.append("CompletionMessage: " + getCompletionMessage());
        }
        sb.append("}");
        return sb.toString();
    }

    public UserImportJobType withCloudWatchLogsRoleArn(String str) {
        this.cloudWatchLogsRoleArn = str;
        return this;
    }

    public UserImportJobType withCompletionDate(Date date) {
        this.completionDate = date;
        return this;
    }

    public UserImportJobType withCompletionMessage(String str) {
        this.completionMessage = str;
        return this;
    }

    public UserImportJobType withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public UserImportJobType withFailedUsers(Long l10) {
        this.failedUsers = l10;
        return this;
    }

    public UserImportJobType withImportedUsers(Long l10) {
        this.importedUsers = l10;
        return this;
    }

    public UserImportJobType withJobId(String str) {
        this.jobId = str;
        return this;
    }

    public UserImportJobType withJobName(String str) {
        this.jobName = str;
        return this;
    }

    public UserImportJobType withPreSignedUrl(String str) {
        this.preSignedUrl = str;
        return this;
    }

    public UserImportJobType withSkippedUsers(Long l10) {
        this.skippedUsers = l10;
        return this;
    }

    public UserImportJobType withStartDate(Date date) {
        this.startDate = date;
        return this;
    }

    public UserImportJobType withStatus(String str) {
        this.status = str;
        return this;
    }

    public UserImportJobType withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public void setStatus(UserImportJobStatusType userImportJobStatusType) {
        this.status = userImportJobStatusType.toString();
    }

    public UserImportJobType withStatus(UserImportJobStatusType userImportJobStatusType) {
        this.status = userImportJobStatusType.toString();
        return this;
    }
}
