package cloud.gateway.core.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable{

	private String userid;//用户ID

	private String username;//登陆名称

	private String userType;//用户类型

	private String passwd;//密码

	private String status;//用户状态

	private String createUser;//创建人

	private Date createDate;//创建时间

	private String gender;//性别

	private String cardType;//证件类型

	private String cardno;//证件号码

	private String party;//政治面貌

	private String daParTment;//所在单位

	private String oAddress;//办公室地址

	private String position;//所在岗位

	private String degree;//职级

	private String empStatus;//人员状态

	private String photo;//用户照片

	private String otel;//联系电话

	private String mobiLeno;//手机号码

	private String qQ;//QQ号码

	private String email;//邮箱

	private String WeiXin;//微信

	private String hAddress;//家庭地址

	private Integer deleted;//删除标示

	private String remark;//备注

	private Integer version;//版本号

	private String  nickName;//用户姓名

	private boolean userFlag;

	private String orgId;

	private String  xzdwCode;//行政单位
	
	private List<String>  list;

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

	public boolean isUserFlag() {
		return userFlag;
	}

	public void setUserFlag(boolean userFlag) {
		this.userFlag = userFlag;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getXzdwCode() {
		return xzdwCode;
	}

	public void setXzdwCode(String xzdwCode) {
		this.xzdwCode = xzdwCode;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
}
