package cloud.gateway.core.models.function;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SYS_FUNC_ROLE_R")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SysFuncRoleR implements Serializable{

  @Id
  @Column(name = "ID")
  @GenericGenerator(name = "user-uuid", strategy = "uuid")
  @GeneratedValue(generator = "user-uuid")
  private String id;

  @Column(name = "FUNC_ID")
  private String func_Id;

  @Column(name = "FUNC_CODE")
  private String func_Code;

  @Column(name = "FUNC_NAME")
  private String func_Name;

  @Column(name = "ROLE_ID")
  private String role_Id;

  @Column(name = "ROLE_CODE")
  private String role_Code;

  @Column(name = "ROLE_NAME")
  private String role_Name;

  @Column(name = "AUTHUSER")
  private String authuser;

  @Column(name = "VERSION")
  private Integer version;

  @Column(name = "AUTHTIME")
  private Date authtime;

  @Column(name = "DELETED")
  private String deleted;


  public String getFunc_Id() {
    return func_Id;
  }

  public void setFunc_Id(String func_Id) {
    this.func_Id = func_Id;
  }


  public String getFunc_Code() {
    return func_Code;
  }

  public void setFunc_Code(String func_Code) {
    this.func_Code = func_Code;
  }


  public String getFunc_Name() {
    return func_Name;
  }

  public void setFunc_Name(String func_Name) {
    this.func_Name = func_Name;
  }


  public String getRole_Id() {
    return role_Id;
  }

  public void setRole_Id(String role_Id) {
    this.role_Id = role_Id;
  }


  public String getRole_Code() {
    return role_Code;
  }

  public void setRole_Code(String role_Code) {
    this.role_Code = role_Code;
  }


  public String getRole_Name() {
    return role_Name;
  }

  public void setRole_Name(String role_Name) {
    this.role_Name = role_Name;
  }


  public String getAuthuser() {
    return authuser;
  }

  public void setAuthuser(String authuser) {
    this.authuser = authuser;
  }


  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }


  public Date getAuthtime() {
    return authtime;
  }

  public void setAuthtime(Date authtime) {
    this.authtime = authtime;
  }


  public String getDeleted() {
    return deleted;
  }

  public void setDeleted(String deleted) {
    this.deleted = deleted;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
