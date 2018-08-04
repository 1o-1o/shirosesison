package cloud.gateway.service.function;

import cloud.gateway.service.Base.BaseService;
import cloud.gateway.core.models.function.SysFunc;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/8.
 */
public interface SysFuncService extends BaseService<SysFunc> {
    public List selectIdAndName();
    public List<String> selectAllLeafsByPid(List<String> idList, String pid);
    public void deleteAllLeafsByIds(List<String> ids);
    public List<String> selectAllLeafsByPidWithSql(String pid);
    public List<SysFunc> selectSysFuncByUserName(Map<String, Object> map);

    /**
     * 根据主键查询出所有的父节点
     * @param id
     * @return
     */
    List<String> findByPid(String id);

    List<String> selectSiteIdByUserName(Map map);
}
