package cloud.gateway.core.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: Resource
 * @Description:资源表
 * @author: zml
 * @date: 2015-01-9 下午19:59:48
 *
 */

/**
 *                  
 * @date: 2017年8月12日
 * @Author: yunpeng
 * @Email: 
 * @FileName: Permission.java
 * @Version: 1.0
 * @About: 
 *
 */
public class Resource implements Serializable {

	private static final long serialVersionUID = 53889172259830160L;
	
	private Integer id; 								//编号
	
	//@NotEmpty(message = "{resource.name.not.empty}")
    private String name; 							//资源名称
	
    private String type;							//资源类型
	
    private String url; 							//资源路径
	
	//@NotEmpty(message = "{resource.permission.not.empty}")
    private String permission; 						//权限字符串
	
    private Integer parentId; 							//父编号
	
	/*@NotEmpty(message="{resource.parentIds.not.empty}")
	@Length(min = 2, max = 20, message = "{resource.parentIds.length.illegal}")*/
    private String parentIds; 						//父编号列表
	
    private Integer available;
	
	private String classfield;
	
	private Integer ordernum;
	
	/*=================================================*/
	
	private Integer siteid;

	 private Integer deleted;//删除标示(0:未删除,1:删除成功)
	
	 private Date createDate;//创建时间
	 
	 private Date updateDate;//更新时间
	 
	 private Integer version;//版本号
	 
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getSiteid() {
		return siteid;
	}

	public void setSiteid(Integer siteid) {
		this.siteid = siteid;
	}

	/*=================================================*/
	
	private List<Resource> children = new ArrayList<Resource>();
    


	public String getClassfield() {
		return classfield;
	}

	public void setClassfield(String classfield) {
		this.classfield = classfield;
	}

	public List<Resource> getChildren() {
		return children;
	}

	public void setChildren(List<Resource> children) {
		this.children = children;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	public boolean isRootNode() {
        return parentId == 0;
    }

    public String makeSelfAsParentIds() {
        return getParentIds() + getId() + "/";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource resource = (Resource) o;

        if (id != null ? !id.equals(resource.id) : resource.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

	@Override
	public String toString() {
		return "Resource [id=" + id + ", name=" + name + ", type=" + type + ", url=" + url + ", permission="
				+ permission + ", parentId=" + parentId + ", parentIds=" + parentIds + ", available=" + available
				+ ", classfield=" + classfield + ", ordernum=" + ordernum + ", siteid=" + siteid + ", deleted="
				+ deleted + ", createDate=" + createDate + ", updateDate=" + updateDate + ", children=" + children
				+ "]";
	}

}
