package cloud.gateway.core.models.function;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SYS_FUNC")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SysFunc implements Serializable{

  @Id
  @Column(name = "ID")
  @GenericGenerator(name = "user-uuid", strategy = "uuid")
  @GeneratedValue(generator = "user-uuid")
  private String id;

  @Column(name = "FUNC_CODE")
  private String func_Code;

  @Column(name = "NAME")
  private String name;

  @Column(name = "FUNC_TYPE")
  private String func_Type;

  @Column(name = "ISOPEN")
  private boolean isopen;

  @Column(name = "OPENDATE")
  private Date opendate;

  @Column(name = "FUNC_URL")
  private String func_Url;

  @Column(name = "FUNC_DESC")
  private String func_Desc;

  @Column(name = "PID")
  private String pid;

  @Column(name = "FUNC_LEVEL")
  private String func_Level;

  @Column(name = "FUNC_SEQ")
  private Integer func_Seq;

  @Column(name = "ISLEAF")
  private boolean isleaf;

  @Column(name = "ISPARENT")
  private boolean isParent;

  @Column(name = "CREATEUSER")
  private String createuser;

  @Column(name = "CREATETIME")
  private Date createtime;

  @Column(name = "BZ")
  private String bz;

  @Column(name = "VERSION")
  private Integer version;

  @Column(name = "DELETED")
  private String deleted;

  @Column(name = "CLASSFIELD")
  private String classField;

  @Column(name = "SITEID")
  private String siteId; //在菜单上加一个站点id，角色上的id不再使用

  @Column(name = "GROUPTYPE")
  private String groupType; //分组id,新添字段

  @Column(name = "SERVICEADDR")
  private String serviceAddr; //服务地址,新添字段

  @Column(name = "SELECTLAYER")
  private String selectLayer; //选择图层,新添字段

  @Column(name = "TABLENAME")
  private String tableName; //选择表,新添字段

  @Transient
  private List<String> ids;

  public String getGroupType() {
    return groupType;
  }

  public void setGroupType(String groupType) {
    this.groupType = groupType;
  }

  public String getServiceAddr() {
    return serviceAddr;
  }

  public void setServiceAddr(String serviceAddr) {
    this.serviceAddr = serviceAddr;
  }

  public String getSelectLayer() {
    return selectLayer;
  }

  public void setSelectLayer(String selectLayer) {
    this.selectLayer = selectLayer;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public List<String> getIds() {
    return ids;
  }

  public void setIds(List<String> ids) {
    this.ids = ids;
  }

  /*  @Column(name="open")
  private boolean open;

  public boolean getOpen() {
    return open;
  }

  public void setOpen(boolean open) {
    this.open = open;
  }*/

  public String getSiteId() {
    return siteId;
  }

  public void setSiteId(String siteId) {
    this.siteId = siteId;
  }

  public String getClassField() {
    return classField;
  }

  public void setClassField(String classField) {
    this.classField = classField;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public boolean getIsParent() {
    return isParent;
  }

  public void setIsParent(boolean isParent) {
    this.isParent = isParent;
  }

  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }

  public String getFunc_Code() {
    return func_Code;
  }

  public void setFunc_Code(String func_Code) {
    this.func_Code = func_Code;
  }



  public String getFunc_Type() {
    return func_Type;
  }

  public void setFunc_Type(String func_Type) {
    this.func_Type = func_Type;
  }


  public boolean getIsopen() {
    return isopen;
  }

  public void setIsopen(boolean isopen) {
    this.isopen = isopen;
  }


  public Date getOpendate() {
    return opendate;
  }

  public void setOpendate(Date opendate) {
    this.opendate = opendate;
  }


  public String getFunc_Url() {
    return func_Url;
  }

  public void setFunc_Url(String func_Url) {
    this.func_Url = func_Url;
  }


  public String getFunc_Desc() {
    return func_Desc;
  }

  public void setFunc_Desc(String func_Desc) {
    this.func_Desc = func_Desc;
  }


  public String getFunc_Level() {
    return func_Level;
  }

  public void setFunc_Level(String func_Level) {
    this.func_Level = func_Level;
  }


  public Integer getFunc_Seq() {
    return func_Seq;
  }

  public void setFunc_Seq(Integer func_Seq) {
    this.func_Seq = func_Seq;
  }


  public boolean getIsleaf() {
    return isleaf;
  }

  public void setIsleaf(boolean isleaf) {
    this.isleaf = isleaf;
  }

  public String getCreateuser() {
    return createuser;
  }

  public void setCreateuser(String createuser) {
    this.createuser = createuser;
  }


  public Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Date createtime) {
    this.createtime = createtime;
  }


  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }


  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }


  public String getDeleted() {
    return deleted;
  }

  public void setDeleted(String deleted) {
    this.deleted = deleted;
  }

}
