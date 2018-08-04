package cloud.gateway.core.repositories.jpa;

import cloud.gateway.core.dao.IBaseDao;
import cloud.gateway.core.dao.IJdbcDao;
import cloud.gateway.core.models.SysDict;
import cloud.gateway.core.repositories.BaseRepo;
import cloud.gateway.core.repositories.SysDictRepo;
import cloud.gateway.core.repositories.base.BaseDaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/10.
 */
@Service
@Transactional
public class SysDictRepository extends BaseDaoRepository<SysDict> implements SysDictRepo {
    Logger logger = LoggerFactory.getLogger(SysDictRepository.class);
    @Autowired
    private BaseRepo<SysDict> baseService;

    @Autowired
    protected IJdbcDao jdbcDao;

    @Autowired
    private IBaseDao<SysDict> baseDao;
    @Override
    public List<SysDict> findAll() throws Exception {
        List<SysDict> list = this.baseService.getAllList("SysDict");
        return list;
    }

    @Override
    public List<SysDict> findByType(String type) throws Exception {
        List<SysDict> list = this.baseService.findByWhere("SysDict", new String[]{"zdlb"}, new String[]{type});
        return list;
    }

    @Override
    public List<SysDict> findByXzdwAndXj(String xzdw , String type) throws Exception {
        StringBuffer hql = new StringBuffer();
        hql.append("select a from SysDict  a where  a.zdlb = '").append(type).append("' and a.dict_code like '").append(xzdw).append("__' ");
        //List<Dict> list = this.baseService.findByWhere("Dict", new String[]{"dict_code","dict_type"}, new String[]{xzdw,type});
        List<SysDict> list = this.baseService.findByWhereHql(hql.toString());
        return list;

    }

    @Override
    public List<SysDict> findByBjdwAndXjdw(String xzdw , String type) throws Exception {
        StringBuffer hql = new StringBuffer();
        hql.append("select a from Dict  a where  a.dict_type = '").append(type)
                .append("' and ( a.dict_code like '").append(xzdw).append("___' or a.dict_code = '").append(xzdw).append("')");
        //List<Dict> list = this.baseService.findByWhere("Dict", new String[]{"dict_code","dict_type"}, new String[]{xzdw,type});
        List<SysDict> list = this.baseService.findByWhereHql(hql.toString());
        return list;

    }

    @Override
    public List<SysDict> getLinkageById(String id) throws Exception {
//        List<SysDict> list = baseService.findLinkageById("Sys_Dict",id);
//        logger.info("getLinkageById:"+list);
//        return list;
        return null;
    }

    @Override
    public List<SysDict> getLinkage(String id) throws Exception {
//        List<SysDict> list = baseService.findLinkage("Sys_Dict",id);
//        logger.info("getLinkageById:"+list);
//        return list;
        return null;
    }

    @Override
    public List<SysDict> findByXzdwAndXjdw(String xzdw , String type) throws Exception {
        StringBuffer hql = new StringBuffer();
        hql.append("select a from Dict  a where  a.dict_type = '").append(type).append("' and a.dict_code like '").append(xzdw).append("___' ");
        //List<Dict> list = this.baseService.findByWhere("Dict", new String[]{"dict_code","dict_type"}, new String[]{xzdw,type});
        List<SysDict> list = this.baseService.findByWhereHql(hql.toString());
        return list;

    }

    @Override
    public SysDict findById(String  id) throws Exception {

        SysDict dict = this.baseService.getUnique("SysDict", new String[]{"id"}, new String[]{id});
        return dict;

    }

    @Override
    public List<SysDict> findByPid(String pid) throws Exception {
        /*List<SysDict> list = baseService.findByWhere("SysDict", new String[]{"pid"}, new String[]{pid});
        return list;*/
        String sql="select * from  sys_dict a start with  a.fid= '"+pid+"' connect by prior a.fid=a.id";
        List<SysDict> list = baseDao.findStartWith(sql);
        return list;
    }

    @Override
    public List<SysDict> findByPid2(String pid) throws Exception {
        /*List<SysDict> list = baseService.findByWhere("SysDict", new String[]{"pid"}, new String[]{pid});
        return list;*/
        String sql="select * from  sys_dict a where  a.fid= '"+pid+"' ";
        List<SysDict> list = baseDao.findStartWith(sql);
        return list;
    }

    @Override
    public void importExecl(List<SysDict> list, Map map) throws Exception {
//        baseService.batchInsert(list);
    }

    @Override
    public List<SysDict> findByXzdw(String xzdw, String type) throws Exception {
        StringBuffer hql = new StringBuffer();
        hql.append("select a from Dict  a where  a.dict_type = '").append(type).append("' and a.dict_code like '").append(xzdw).append("%' ");
        //List<Dict> list = this.baseService.findByWhere("Dict", new String[]{"dict_code","dict_type"}, new String[]{xzdw,type});
        List<SysDict> list = this.baseService.findByWhereHql(hql.toString());
        return list;
    }

    @Override
    public void doSave(SysDict dict) throws Exception{
        this.baseService.add(dict);
    }

    @Override
    public void doUpdate(SysDict dict) throws Exception{
        this.baseService.update(dict);

    }

    @Override
    public void doDelete(String id) throws Exception{
        String sql = "delete from SYS_DICT where ID=:id ";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        this.jdbcDao.delete(sql, paramMap);
    }

    @Override
    public Integer getCountBySql(String id) {
//            Integer integer = baseService.countBySql("SYS_DICT", id);
//            if(integer<0){
//                return null;
//            }
//            return integer;
        return null;
    }

    @Override
    public Integer getCount() {
        try {
            Integer integer = baseService.getCountAll("SysDict");
            return integer;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<SysDict> getByNote(String id) {
        try {
            List<SysDict> list = this.baseService.findByWhere("SysDict", new String[]{"pid","zdlb"}, new String[]{id,"字典项"});
            return  list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer countByNote(String id) {
        try {
           Integer integer = baseService.getCountWhere("SysDict", new String[]{"pid","zdlb"}, new String[]{id,"字典项"});
        return integer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SysDict> findUpByid(String id) {
        String sql="select * from  sys_dict a start with  a.id= '"+id+"' connect by prior a.fid=a.id";
        List<SysDict> list = baseDao.findStartWith(sql);
        return list;
    }



}
