package cloud.gateway.core.models;

import java.io.Serializable;
import java.util.List;

/** 角色与资源目录关联表
 * Created by Administrator on 2017/11/29.
 */
public class SysRoleContent implements Serializable {
    private String roCoid;
    private String roleId;
    private String conId;
    private List<String> listId;
    private boolean flag;

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

    public String getRoCoid() {
        return roCoid;
    }

    public void setRoCoid(String roCoid) {
        this.roCoid = roCoid;
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
