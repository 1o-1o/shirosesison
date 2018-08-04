package cloud.gateway.core.models.function;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SysFuncRoleR implements Serializable{

  private String id;

  private String func_Id;

  private String func_Code;

  private String func_Name;

  private String role_Id;

  private String role_Code;

  private String role_Name;

  private String authuser;

  private Integer version;

  private Date authtime;

  private String deleted;

  private List<SysFuncRoleR> funcRoleRList;

  public List<SysFuncRoleR> getFuncRoleRList() {
    return funcRoleRList;
  }

  public void setFuncRoleRList(List<SysFuncRoleR> funcRoleRList) {
    this.funcRoleRList = funcRoleRList;
  }

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
