package cloud.gateway.core.repositories.jpa;

import cloud.gateway.core.dao.IBaseDao;
import cloud.gateway.core.dao.IJdbcDao;
import cloud.gateway.core.models.SysRoleContent;
import cloud.gateway.core.pagination.Page;
import cloud.gateway.core.repositories.BaseRepo;
import cloud.gateway.core.repositories.SysRoleContentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/29.
 */
@Service
@Transactional
public class SysRoleContentRepository implements SysRoleContentRepo {
    Logger logger = LoggerFactory.getLogger(SysDictRepository.class);
    @Autowired
    private BaseRepo<SysRoleContent> baseService;

    @Autowired
    protected IJdbcDao jdbcDao;

    @Autowired
    private IBaseDao<SysRoleContent> baseDao;
    @Override
    public void add(SysRoleContent bean) throws Exception {
        baseService.add(bean);
    }

    @Override
    public void saveOrUpdate(SysRoleContent bean) throws Exception {
        baseService.saveOrUpdate(bean);
    }

    @Override
    public void delete(SysRoleContent bean) throws Exception {
        baseService.delete(bean);
    }

    @Override
    public void update(SysRoleContent bean) throws Exception {
        baseService.update(bean);
    }

    @Override
    public List<Map<String, Object>> findAllBySql(String sql, Map<String, Object> paramMap) throws Exception {
        return null;
    }

    @Override
    public boolean deleteSql(String sql) throws Exception {
        return false;
    }

    @Override
    public void updateSql(String sql, Map<String, Object> paramMap) throws Exception {

    }

    @Override
    public SysRoleContent getByArgs(String tableEntityName, String[] fieldsName, String[] values) {
        return null;
    }

    @Override
    public Page<SysRoleContent> getListPageByHql(String hql, String counthql, Page<SysRoleContent> page) throws Exception {
        return null;
    }

    @Override
    public List<SysRoleContent> getListByHql(String hql) throws Exception {
        return null;
    }
    @Override
    public boolean deleteByRoleId(String  roleid) throws Exception {
        String sql = "delete from SYS_ROLE_CONTENT where ROLE_ID=:roleid ";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("roleid", roleid);
        int delete = this.jdbcDao.delete(sql, paramMap);
        if(delete!=0){
            return true;
        }
        return false;
    }

    @Override
    public List<SysRoleContent> findByRoleId(String roleId) {
        try {
            List<SysRoleContent> list = this.baseService.findByWhere("SysRoleContent", new String[]{"roleId"}, new String[]{roleId});
            return  list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
