package cloud.gateway.service.impl;

import cloud.gateway.core.models.SysDict;
import cloud.gateway.core.pagination.Page;
import cloud.gateway.core.repositories.SysDictRepo;
import cloud.gateway.service.SysDictService;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/10.
 */
@Service(version = "1.1.0.0")
public class SysDictServiceImpl implements SysDictService {
    Logger logger = LoggerFactory.getLogger(SysDictServiceImpl.class);

    @Autowired
    private SysDictRepo sysDictRepo;

    @Override
    public List<SysDict> getLinkageById(String id) throws Exception {
        if(id == null){
            logger.error("getLinkageById :"+"参数异常");
            return null;

        }
        List<SysDict> list = sysDictRepo.getLinkageById(id);
        if(list.size()==0 || list.isEmpty()){
            logger.error("getLinkageById :"+"获取数据失败");
            return null;
        }
        logger.info("getLinkageById:"+list);
        return list;
    }

    @Override
    public List<SysDict> findAll() {
        try {
            List<SysDict> list = sysDictRepo.findAll();
            if(list.size() == 0 || list.isEmpty()){
                return null;
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer getCount() {
        Integer count = sysDictRepo.getCount();
        return count;
    }

    @Override
    public void add(SysDict bean) throws Exception {
        sysDictRepo.add(bean);
    }

    @Override
    public void saveOrUpdate(SysDict bean) throws Exception {
        sysDictRepo.saveOrUpdate(bean);
    }

    @Override
    public void delete(SysDict bean) throws Exception {
        sysDictRepo.delete(bean);
    }

    @Override
    public void update(SysDict bean) throws Exception {
        sysDictRepo.update(bean);
    }

    @Override
    public SysDict getById(String id) throws Exception {
        return sysDictRepo.getByArgs("SysDict",new String[]{"id"},new String[]{id});
    }

    @Override
    public Page<SysDict> getListByPage(SysDict obj, Page<SysDict> page, String orderBySql) throws Exception {
        StringBuffer buffer = new StringBuffer();
        String selectHql = "select a from SysDict a ";
        String countHql = "select count(*) from SysDict a ";
        if(!StringUtils.isBlank(obj.getZdfl())){ //字典分类
            buffer.append("and a.zdfl  ='"+obj.getZdfl()+"' ");
        }
        if(!StringUtils.isBlank(obj.getName())){//字典名称
            buffer.append("and a.name = '"+obj.getName()+"' ");
        }
        if(!StringUtils.isBlank(obj.getZdxbm())){//字典编码
            buffer.append("and a.zdxbm = '"+obj.getZdxbm()+"' ");
        }
        if(!StringUtils.isBlank(obj.getPid())){
            buffer.append("and a.pid = '"+obj.getPid()+"' ");
        }
        String cotentHql = buffer.toString();
        if(!StringUtils.isBlank(cotentHql)){ //如果有条件则截取拼接到
            selectHql = selectHql + "where "+cotentHql.substring(cotentHql.indexOf("a."));
            countHql = countHql + "where "+cotentHql.substring(cotentHql.indexOf("a."));
        }
        selectHql = selectHql+orderBySql;
        //默认必须传入page，如果不想分页，那传入一个大值也行
        Page<SysDict> pageResponse =  sysDictRepo.getListPageByHql(selectHql,countHql,page);
        return pageResponse;
    }

    @Override
    public List<SysDict> getListByHql(SysDict obj, String orderBySql) throws Exception {
        return null;
    }

    @Override
    public List<Map<String, Object>> findAllBySql(SysDict obj, Map<String, Object> paramMap) {
        return null;
    }

    @Override
    public Page<SysDict> getPageBySql(SysDict obj, Page<SysDict> page, String orderBySql) throws Exception {
        StringBuffer buffer = new StringBuffer();
        String selectHql = "select * from  start with id= '\"+id+\"' \"+\" connect by prior fid=id\";";
        String countHql = "select count(*) from SysDict a ";
      /*  if(!StringUtils.isBlank(obj.getName())){ //条件的拼接
            buffer.append(" and a.name ='"+obj.getName()+"'");
        }
        buffer.append(" and a.deleted!=1 ");

        String cotentHql = buffer.toString();
        if(!StringUtils.isBlank(cotentHql)){ //如果有条件则截取拼接到
            selectHql = selectHql + "where "+cotentHql.substring(cotentHql.indexOf(" a."));
            countHql = countHql + " where "+cotentHql.substring(cotentHql.indexOf(" a."));
        }*/
        //selectHql = selectHql+orderBySql;
        //默认必须传入page，如果不想分页，那传入一个大值也行
        Page<SysDict> pageResponse =  sysDictRepo.getListPageByHql(selectHql,countHql,page);
        return pageResponse;
    }

    @Override
    public boolean deleteById(String id) {
        try {
            sysDictRepo.doDelete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Integer getCountById(String id) {
        Integer integer = sysDictRepo.getCountBySql(id);
        if(integer<0){
            return 0;
        }
        return integer;
    }

    @Override
    public List<SysDict> getLinkage(String id) throws Exception {
        if(id == null){
            return null;
        }
        List<SysDict> list = sysDictRepo.getLinkage(id);
        if(list.size()==0 || list.isEmpty()){
            logger.error("getLinkage :"+"获取数据失败");
            return null;
        }
        logger.info("getLinkage:"+list);
        return list;
    }

    @Override
    public List<SysDict> getBeanByPid(String pid) {
        try {
            List<SysDict> list = sysDictRepo.findByPid(pid);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SysDict> getDictByPid(String pid) {
        try {
            List<SysDict> list = sysDictRepo.findByPid2(pid);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void importExecl(List<SysDict> list, Map map) throws Exception {
        sysDictRepo.importExecl(list,map);
    }

    @Override
    public List<SysDict> getByNote(String id) {
        List<SysDict> byNote = sysDictRepo.getByNote(id);
        return byNote;
    }

    @Override
    public Integer countByNote(String id) {
        Integer integer = sysDictRepo.countByNote(id);
        return integer;
    }

    @Override
    public List<SysDict> findUpByid(String id) {
        List<SysDict> list = sysDictRepo.findUpByid(id);
        return list;
    }

}
