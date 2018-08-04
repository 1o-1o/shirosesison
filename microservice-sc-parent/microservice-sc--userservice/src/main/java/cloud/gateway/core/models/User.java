package cloud.gateway.core.models;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "SYS_USER")
@DynamicInsert(true)
@DynamicUpdate(true)
public class User implements Serializable{

	@Id
	@Column(name = "USER_ID")
	private String userid;//用户ID
	
	@Column(name = "USER_NAME")
	private String username;//登陆名称
	
	@Column(name = "USER_TYPE")
	private String userType;//用户类型

	@Column(name = "PASSWORD")
	private String passwd;//密码
	
	@Column(name = "STATUS")
	private String status;//用户状态

	@Column(name = "CREATEUSER")
	private String createUser;//创建人
	
	@Column(name = "CREATETIME")
	private Date createDate;//创建时间
	
	@Column(name = "GENDER")
	private String gender;//性别

	@Column(name = "CARDTYPE")
	private String cardType;//证件类型

	@Column(name = "CARDNO")
	private String cardno;//证件号码

	@Column(name = "PARTY")
	private String party;//政治面貌

	@Column(name = "DEPARTMENT")
	private String daParTment;//所在单位

	@Column(name = "OADDRESS")
	private String oAddress;//办公室地址

	@Column(name = "POSITION")
	private String position;//所在岗位

	@Column(name = "DEGREE")
	private String degree;//职级

	@Column(name = "EMPSTATUS")
	private String empStatus;//人员状态

	@Column(name = "PHOTO")
	private String photo;//用户照片

	@Column(name = "OTEL")
	private String otel;//联系电话
	
	@Column(name = "MOBILENO")
	private String mobiLeno;//手机号码
	
	@Column(name = "QQ")
	private String qQ;//QQ号码
	
	@Column(name = "EMAIL")
	private String email;//邮箱
	
	@Column(name = "WEIXIN")
	private String WeiXin;//微信
	
	@Column(name = "HADDRESS")
	private String hAddress;//家庭地址

	@Column(name = "DELETED")
	private Integer deleted;//删除标示
	
	@Column(name = "REMARK")
	private String remark;//备注

	@Column(name="VERSION")
	 private Integer version;//版本号

	@Column(name="NICKNAME")
	private String  nickName;//用户姓名

	@Column(name="XZDWCODE")
	private String  xzdwCode;//行政单位

	@Transient
	private String search;//搜索

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getDaParTment() {
		return daParTment;
	}

	public void setDaParTment(String daParTment) {
		this.daParTment = daParTment;
	}

	public String getoAddress() {
		return oAddress;
	}

	public void setoAddress(String oAddress) {
		this.oAddress = oAddress;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getOtel() {
		return otel;
	}

	public void setOtel(String otel) {
		this.otel = otel;
	}

	public String getMobiLeno() {
		return mobiLeno;
	}

	public void setMobiLeno(String mobiLeno) {
		this.mobiLeno = mobiLeno;
	}

	public String getqQ() {
		return qQ;
	}

	public void setqQ(String qQ) {
		this.qQ = qQ;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeiXin() {
		return WeiXin;
	}

	public void setWeiXin(String weiXin) {
		WeiXin = weiXin;
	}

	public String gethAddress() {
		return hAddress;
	}

	public void sethAddress(String hAddress) {
		this.hAddress = hAddress;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getXzdwCode() {
		return xzdwCode;
	}

	public void setXzdwCode(String xzdwCode) {
		this.xzdwCode = xzdwCode;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
}
