package cloud.gateway.core.repositories;

import cloud.gateway.core.models.SysRoleContent;
import cloud.gateway.core.repositories.base.BaseDaoRepo;
import java.util.List;
/**
 * Created by Administrator on 2017/11/29.
 */
public interface SysRoleContentRepo extends BaseDaoRepo<SysRoleContent> {
     boolean deleteByRoleId(String roleid) throws Exception;
     /**
      * 根据角色id出所有
      * @param roleId
      * @return
      */
     List<SysRoleContent> findByRoleId(String roleId);
}
