package cloud.gateway.core.repositories.jpa.user;

import cloud.gateway.core.models.userRelation.SysUserRoleR;
import cloud.gateway.core.repositories.base.BaseDaoRepository;
import cloud.gateway.core.repositories.user.SysUserRoleRRepo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
/**
 * Created by Administrator on 2017/11/7.
 */
@Component
@Transactional
public class SysUserRoleRRepository extends BaseDaoRepository<SysUserRoleR> implements SysUserRoleRRepo {


    @Override
    public List<SysUserRoleR> findByUserId(String userid) throws Exception {
        List<SysUserRoleR> list = this.baseService.findByWhere("SysUserRoleR", new String[]{"userId", "deleted"}, new String[]{userid, "0"});
        if(list.size()==0 || list.isEmpty()){
            return  null;
        }
        return list;
    }
}
