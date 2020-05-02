package cn.stylefeng.guns.modular.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (AuditBottom)实体类
 *
 * @author makejava
 * @since 2020-04-29 17:05:45
 */
@TableName("audit_bottom")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditBottom extends Model<AuditBottom> implements Serializable {
    private static final long serialVersionUID = 358734224700323921L;
    @TableId(value = "ID", type = IdType.AUTO)

    private Long id;
    /**
    * 描述
    */

    private String des;
    /**
    * 1：已审核 2：未审核
    */
    @TableField("audit_status")
    private Long auditStatus;
    @TableField("audit_people")
    private Long auditPeople;
    @TableField("audit_time")
    private Date auditTime;
    @TableField("type_name")
    private String typeName;
    /**
    * 项目id
    */
    @TableField("mgr_id")
    private Long mgrId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
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
        this.typeName = typeName;
    }

    public Long getMgrId() {
        return mgrId;
    }

    public void setMgrId(Long mgrId) {
        this.mgrId = mgrId;
    }

}