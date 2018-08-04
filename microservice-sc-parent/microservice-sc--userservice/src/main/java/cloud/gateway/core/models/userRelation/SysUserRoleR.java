package cloud.gateway.core.models.userRelation;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SYS_USER_ROLE_R")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SysUserRoleR implements Serializable{
  private static final long serialVersionUID = -4469236450461851881L;

  @Id
  @GenericGenerator(name = "user-uuid", strategy = "uuid")
  @GeneratedValue(generator = "user-uuid")
  @Column(name = "ID")
  private String id;//主键

  @Column(name = "ROLE_ID")
  private String roleId;//角色主键

  @Column(name = "USER_ID")
  private String userId;//用户主键

  @Column(name = "VERSION")
  private Integer version;//版本号

  @Column(name = "CREATETIME")
  private Date createtime;//创建时间

  @Column(name = "DELETED")
  private String deleted;//删除标志

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
