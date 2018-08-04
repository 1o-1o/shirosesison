package cloud.gateway.core.models;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户和传统角色关联表
 * @author Administrator
 *
 */
@Entity
@Table(name = "U_USER_ROLE")
@DynamicInsert(true)
@DynamicUpdate(true)
public class UserRole implements Serializable {

	private static final long serialVersionUID = 5606409519598928351L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sequenceGenerator")
	@SequenceGenerator(name="sequenceGenerator",sequenceName="U_USER_ROLE_SEQ", allocationSize=1)
	@Column(name = "u_r_id")
	private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "user_id")
    private String userId;
    
    @Column(name = "site_id")
    private Integer siteId;
    
    @Column(name = "deleted")
    private Integer deleted;//删除标志（0：未删除，1：已删除）
    
    @Column(name = "CREATE_USER")
    private String createUser;//创建人
    
    @Column(name = "CREATE_DATE")
    private Date createDate;//创建时间
    
    @Column(name = "modifiedUser")
    private String modifiedUser;//修改人
    
    @Column(name = "UPDATE_DATE")
    private Date updateDate;//更新时间
    
    @Column(name="	VERSION")
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

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	
	
}
