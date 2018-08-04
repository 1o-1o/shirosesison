package cloud.gateway.service.impl;

import cloud.gateway.core.models.SysRoleContent;
import cloud.gateway.core.pagination.Page;
import cloud.gateway.service.SysRoleContentService;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/29.
 */
@Service(version = "1.1.0.0")
public class SysRoleContentServiceImpl implements SysRoleContentService {
    Logger logger = LoggerFactory.getLogger(SysRoleContentServiceImpl.class);
    @Autowired
    private cloud.gateway.core.repositories.SysRoleContentRepo SysRoleContentRepo;
    @Override
    public void add(SysRoleContent bean) throws Exception {
        SysRoleContentRepo.add(bean);
    }

    @Override
    public void saveOrUpdate(SysRoleContent bean) throws Exception {
        SysRoleContentRepo.saveOrUpdate(bean);
    }

    @Override
    public void delete(SysRoleContent bean) throws Exception {
        SysRoleContentRepo.delete(bean);
    }

    @Override
    public void update(SysRoleContent bean) throws Exception {
        SysRoleContentRepo.update(bean);
    }

    @Override
    public SysRoleContent getById(String id) throws Exception {
        return null;
    }

    @Override
    public Page<SysRoleContent> getListByPage(SysRoleContent obj, Page<SysRoleContent> page, String orderBySql) throws Exception {
        return null;
    }

    @Override
    public List<SysRoleContent> getListByHql(SysRoleContent obj, String orderBySql) throws Exception {
        return null;
    }

    @Override
    public List<Map<String, Object>> findAllBySql(SysRoleContent obj, Map<String, Object> paramMap) {
        return null;
    }

    @Override
    public boolean deleteByRoleId(String roleId) {
        try {
            boolean b = SysRoleContentRepo.deleteByRoleId(roleId);
            if(b){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<SysRoleContent> findByRoleId(String roleId) {
        List<SysRoleContent> list = SysRoleContentRepo.findByRoleId(roleId);
        return list;
    }
}
