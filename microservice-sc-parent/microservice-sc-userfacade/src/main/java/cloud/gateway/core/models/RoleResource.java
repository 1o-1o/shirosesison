package cloud.gateway.core.models;

import java.io.Serializable;
import java.util.Date;


public class RoleResource implements Serializable {

	private static final long serialVersionUID = 5606409519598928351L;

	private Integer id;

    private Integer roleId;

    private Integer resourceId;
    
    private Integer site_id;
    
    private Integer deleted;
    
    private Date crteteDate;
    
    private Date updateDate;
    private Integer version;//版本号
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Date getCrteteDate() {
		return crteteDate;
	}

	public void setCrteteDate(Date crteteDate) {
		this.crteteDate = crteteDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public Integer getSite_id() {
		return site_id;
	}

	public void setSite_id(Integer site_id) {
		this.site_id = site_id;
	}

}
