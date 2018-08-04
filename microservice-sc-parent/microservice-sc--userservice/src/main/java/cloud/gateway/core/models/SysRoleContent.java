package cloud.gateway.core.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/** 角色与资源目录关联表
 * Created by Administrator on 2017/11/29.
 */
@Entity
@Table(name="SYS_ROLE_CONTENT")
public class SysRoleContent implements Serializable {
    @Id
    @GenericGenerator(name = "user-uuid", strategy = "uuid")
    @GeneratedValue(generator = "user-uuid")
    @Column(name = "ID")
    private String roCoid;
    @Column(name = "role_id")
    private String roleId;
    @Column(name = "con_id")
    private String conId;
    @Transient
    private List<String> listId;
    @Transient
    private boolean flag;

    public String getRoCoid() {
        return roCoid;
    }

    public void setRoCoid(String roCoid) {
        this.roCoid = roCoid;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<String> getListId() {
        return listId;
    }

    public void setListId(List<String> listId) {
        this.listId = listId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getConId() {
        return conId;
    }

    public void setConId(String conId) {
        this.conId = conId;
    }
}
