package cloud.gateway.core.repositories.function;

import cloud.gateway.core.models.function.SysFunc;
import cloud.gateway.core.repositories.base.BaseDaoRepo;

import java.util.List;

/**
 * Created by Administrator on 2017/11/8.
 */
public interface SysFuncRepo extends BaseDaoRepo<SysFunc> {
    public List selectIdAndName(String sql);
    public List selectSiteIdByArgs(String sql);
}
