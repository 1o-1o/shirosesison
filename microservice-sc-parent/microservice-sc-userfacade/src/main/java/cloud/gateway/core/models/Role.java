package cloud.gateway.core.models;

import java.io.Serializable;
import java.util.Date;

/**
 * 传统角色
 * @author Administrator
 *
 */
public class Role implements Serializable{

	private static final long serialVersionUID = -4469236450461851881L;

	private String id;//角色ID

	private String roleCode;//角色代码

	private String roleName;//角色名称

	private String roleDesc;//角色描述

	private String createUser;//创建者

	private Date createDate;//创建时间

	private Integer deleted;//删除标志

	private Integer version;//版本号

	private String search;//搜索

	private boolean roleFlag;

	private Integer siteId;//站点id 1 后台，2 业务系统 ，3 门户网站

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public boolean getRoleFlag() {
		return roleFlag;
	}

	public void setRoleFlag(boolean roleFlag) {
		this.roleFlag = roleFlag;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
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

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
