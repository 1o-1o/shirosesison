package cloud.gateway.service.impl.userRelation;

import cloud.gateway.core.models.userRelation.SysUserRoleR;
import cloud.gateway.core.pagination.Page;
import cloud.gateway.core.repositories.user.SysUserRoleRRepo;
import cloud.gateway.service.userRelation.SysUserRoleRService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/7.
 */
@Service(version = "1.1.0.0")
public class SysUserRoleRServiceImpl implements SysUserRoleRService {
    @Autowired
    private SysUserRoleRRepo sysUserRoleRRepo;
    @Override
    public void add(SysUserRoleR bean) throws Exception {
        sysUserRoleRRepo.add(bean);
    }

    @Override
    public void saveOrUpdate(SysUserRoleR bean) throws Exception {
        sysUserRoleRRepo.saveOrUpdate(bean);
    }

    @Override
    public void delete(SysUserRoleR bean) throws Exception {
        sysUserRoleRRepo.delete(bean);
    }

    @Override
    public void update(SysUserRoleR bean) throws Exception {
        sysUserRoleRRepo.update(bean);
    }

    @Override
    public SysUserRoleR getById(String id) throws Exception {
        return sysUserRoleRRepo.getByArgs("SysUserRoleR",new String[]{"id"},new String[]{id});
    }

    @Override
    public Page<SysUserRoleR> getListByPage(SysUserRoleR obj, Page<SysUserRoleR> page, String orderBySql) throws Exception {
       /* StringBuffer buffer = new StringBuffer();
        String selectHql = "select a from SysUserOrgR a ";
        String countHql = "select count(*) from SysUserOrgR a ";
        if(!StringUtils.isBlank(obj.getOrgId())){ //条件的拼接
            buffer.append("and a.orgId = '"+obj.getOrgId()+"' ");
        }
        if(!StringUtils.isBlank(obj.getUserId())){
            buffer.append("and a.userId = '"+obj.getUserId()+"' ");
        }
        if(!StringUtils.isBlank(obj.getDeleted())){
            buffer.append("and a.deleted = "+obj.getDeleted()+" ");
        }
        String cotentHql = buffer.toString();
        if(!StringUtils.isBlank(cotentHql)){ //如果有条件则截取拼接到
            selectHql = selectHql + "where "+cotentHql.substring(cotentHql.indexOf("a."));
            countHql = countHql + "where "+cotentHql.substring(cotentHql.indexOf("a."));
        }
        selectHql = selectHql+orderBySql;
        //默认必须传入page，如果不想分页，那传入一个大值也行
        Page<SysUserOrgR> pageResponse =  sysUserOrgRRepo.getListPageByHql(selectHql,countHql,page);*/
        return null;
    }

    @Override
    public List<SysUserRoleR> getListByHql(SysUserRoleR obj, String orderBySql) throws Exception {
        return null;
    }

    @Override
    public List<Map<String, Object>> findAllBySql(SysUserRoleR obj, Map<String, Object> paramMap) {
        return null;
    }


    @Override
    public boolean deleteByUserId(String userid) {
        String sql = "delete from SYS_USER_ROLE_R where USER_ID='"+userid+"'";
        try {
            sysUserRoleRRepo.deleteSql(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SysUserRoleR> findByUserId(String userid) {
        List<SysUserRoleR> list=null;
        try {
            list = sysUserRoleRRepo.findByUserId(userid);
            if(list== null || list.size() == 0){
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
