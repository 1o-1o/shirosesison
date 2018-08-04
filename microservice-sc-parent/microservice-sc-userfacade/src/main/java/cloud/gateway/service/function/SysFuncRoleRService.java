package cloud.gateway.service.function;

import cloud.gateway.service.Base.BaseService;
import cloud.gateway.core.models.function.SysFuncRoleR;

/**
 * Created by Administrator on 2017/11/9.
 */
public interface SysFuncRoleRService extends BaseService<SysFuncRoleR> {
    public boolean deleteFunRoleByRoleId(SysFuncRoleR bean);
}
