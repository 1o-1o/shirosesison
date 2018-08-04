package cloud.gateway.core.models;

import java.io.Serializable;
import java.util.Date;

/** 数据字典表
 * Created by Administrator on 2017/11/10.
 */
public class SysDict implements Serializable {
    private static final long serialVersionUID = -4469236450461851881L;
    private String id; //唯一标识

    private String zdxbm; //字典项编码

    private String name; //字典项名称

    private String pid;//父ID

    private String zdlb; //字典类别

    private Integer version; //版本号

    private Date updateTime; //更新时间

    private Date createTime ; //创建时间

    private Boolean isParent;//是否是父节点

    private Boolean open;//节点展开状态

    private String remark;//节点展开状态

    private String pidName;

    private String zdfl;//字典分类

    public String getZdfl() {
        return zdfl;
    }

    public void setZdfl(String zdfl) {
        this.zdfl = zdfl;
    }

    public String getPidName() {
        return pidName;
    }

    public void setPidName(String pidName) {
        this.pidName = pidName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZdxbm() {
        return zdxbm;
    }

    public void setZdxbm(String zdxbm) {
        this.zdxbm = zdxbm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getZdlb() {
        return zdlb;
    }

    public void setZdlb(String zdlb) {
        this.zdlb = zdlb;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean getisParent() {
        return isParent;
    }

    public void setisParent(boolean parent) {
        isParent = parent;
    }

    public boolean getOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}