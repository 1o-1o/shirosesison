package cloud.gateway.core.repositories.user;


import cloud.gateway.core.models.userRelation.SysUserRoleR;
import cloud.gateway.core.repositories.base.BaseDaoRepo;

import java.util.List;

/**
 * Created by Administrator on 2017/11/7.
 */
public interface SysUserRoleRRepo extends BaseDaoRepo<SysUserRoleR> {

    public List<SysUserRoleR> findByUserId(String userid)throws Exception;
}
