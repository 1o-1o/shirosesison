package cloud.gateway.service;

import cloud.gateway.core.models.SysRoleContent;
import cloud.gateway.service.base.BaseService;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */
public interface SysRoleContentService extends BaseService<SysRoleContent> {
    /**
     * 根据角色id删除关系
     * @param roleId
     * @return
     */
    boolean deleteByRoleId(String roleId);
    /**
     * 根据角色id出所有
     * @param roleId
     * @return
     */
    List<SysRoleContent> findByRoleId(String roleId);

}
