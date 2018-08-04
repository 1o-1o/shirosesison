package cloud.gateway.core.models.userRelation;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SysUserRoleR implements Serializable{
  private static final long serialVersionUID = -4469236450461851881L;

  private String id;//主键

  private String roleId;//角色主键

  private String userId;//用户主键

  private Integer version;//版本号

  private Date createtime;//创建时间

  private String deleted;//删除标志

  private boolean flag;//前端标志

  private List<String> listSysUserRoleR;

  public boolean isFlag() {
    return flag;
  }

  public void setFlag(boolean flag) {
    this.flag = flag;
  }

  public Integer getVersion() {
    return version;
  }

  public Date getCreatetime() {
    return createtime;
  }

  public List<String> getListSysUserRoleR() {
    return listSysUserRoleR;
  }

  public void setListSysUserRoleR(List<String> listSysUserRoleR) {
    this.listSysUserRoleR = listSysUserRoleR;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }

  public String getDeleted() {
    return deleted;
  }

  public void setDeleted(String deleted) {
    this.deleted = deleted;
  }

}
