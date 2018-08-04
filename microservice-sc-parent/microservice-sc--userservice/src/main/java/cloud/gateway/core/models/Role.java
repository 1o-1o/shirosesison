package cloud.gateway.core.models;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 传统角色
 * @author Administrator
 *
 */
@Entity
@Table(name = "sys_role")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Role implements Serializable{

	private static final long serialVersionUID = -4469236450461851881L;

	@Id
	@Column(name = "role_id")
	private String id;//角色ID
	
	@Column(name = "ROLE_CODE")
	private String roleCode;//角色代码

	@Column(name = "ROLE_NAME")
	private String roleName;//角色名称

	@Column(name = "ROLE_DESC")
	private String roleDesc;//角色描述

	@Column(name = "CREATEUSER")
	private String createUser;//创建者

	@Column(name = "CREATETIME")
	private Date createDate;//创建时间

	@Column(name = "Deleted")
	private Integer deleted;//删除标志

	@Column(name = "version")
	private Integer version;//版本号

	@Column(name = "SITE_ID")
	private Integer siteId;//站点id 1 后台，2 业务系统 ，3 门户网站

//	@Column(name="search")
	@Transient
	private String search;//搜索

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
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
