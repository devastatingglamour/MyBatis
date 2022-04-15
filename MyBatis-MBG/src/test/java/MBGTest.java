import com.xmt.mybatis.mapper.EmpMapper;
import com.xmt.mybatis.pojo.Emp;
import com.xmt.mybatis.pojo.EmpExample;
import com.xmt.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author xmttz
 * @create 2022/3/25 17:10
 * @description
 */
public class MBGTest {
    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询所有数据
        // List<Emp> emps = mapper.selectByExample(null);
        // emps.forEach(emp -> System.out.println(emp));

        //根据条件查询
        // EmpExample example=new EmpExample();
        // example.createCriteria().andEmpNameBetween("张三","田七");
        // example.or().andDidIsNotNull();
        // List<Emp> emps = mapper.selectByExample(example);
        // emps.forEach(emp -> System.out.println(emp));

        mapper.updateByPrimaryKey(new Emp(12,"admin",22,"男","321@qq.com",3));

    }
}
