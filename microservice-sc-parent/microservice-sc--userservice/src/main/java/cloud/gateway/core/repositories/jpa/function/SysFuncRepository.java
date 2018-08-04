package cloud.gateway.core.repositories.jpa.function;

import cloud.gateway.core.models.function.SysFunc;
import cloud.gateway.core.repositories.base.BaseDaoRepository;
import cloud.gateway.core.repositories.function.SysFuncRepo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/11/8.
 */
@Component
@Transactional
public class SysFuncRepository extends BaseDaoRepository<SysFunc> implements SysFuncRepo {
    @Override
    public List selectIdAndName(String sql) {
        return jdbcDao.findAll(sql,new HashMap<>());
    }

    @Override
    public List selectSiteIdByArgs(String sql) {
        return jdbcDao.findAll(sql,new HashMap<>());
    }
}
