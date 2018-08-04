package cloud.gateway.service.userRelation;


import cloud.gateway.service.Base.BaseService;
import cloud.gateway.core.models.userRelation.SysUserRoleR;

import java.util.List;

/**
 * Created by Administrator on 2017/11/7.
 */
public interface SysUserRoleRService extends BaseService<SysUserRoleR> {
    /**
     * 根据用户主键，删除数据
     * @param userid
     * @return
     */
    public boolean deleteByUserId(String userid);

    /**
     * 根据userId查询全部角色
     * @param userid
     * @return
     */
    public List<SysUserRoleR> findByUserId(String userid);

}
