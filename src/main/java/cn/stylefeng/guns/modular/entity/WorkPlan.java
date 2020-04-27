package cn.stylefeng.guns.modular.entity;

import java.util.Date;

public class WorkPlan {
    private Long id;

    private String workPlan;

    private Long auditStatus;

    private Long auditPeople;

    private Date auditTime;

    private String typeName;

    private Long mgrId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkPlan() {
        return workPlan;
    }

    public void setWorkPlan(String workPlan) {
        this.workPlan = workPlan == null ? null : workPlan.trim();
    }

    public Long getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Long auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Long getAuditPeople() {
        return auditPeople;
    }

    public void setAuditPeople(Long auditPeople) {
        this.auditPeople = auditPeople;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Long getMgrId() {
        return mgrId;
    }

    public void setMgrId(Long mgrId) {
        this.mgrId = mgrId;
    }
}