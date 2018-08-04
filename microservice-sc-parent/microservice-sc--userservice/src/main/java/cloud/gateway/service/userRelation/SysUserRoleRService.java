package cloud.gateway.service.userRelation;

import cloud.gateway.core.models.userRelation.SysUserRoleR;
import cloud.gateway.service.base.BaseService;

import java.util.List;

/**
 * Created by Administrator on 2017/11/7.
 */
public interface SysUserRoleRService extends BaseService<SysUserRoleR> {
    public boolean deleteByUserId(String userid);
    /**
     * 根据userId查询全部角色
     * @param userid
     * @return
     */
    public List<SysUserRoleR> findByUserId(String userid);
}
