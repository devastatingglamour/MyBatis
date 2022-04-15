import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmt.mybatis.mapper.EmpMapper;
import com.xmt.mybatis.pojo.Emp;
import com.xmt.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author xmttz
 * @create 2022/3/25 19:43
 * @description
 */
public class PageTest {
    /**
     * limit index,pageSize
     * index:当前页的起始索引
     * paegSize:每页显示的条数
     * pageNum:每页显示的页码
     * index=(pageNum-1)*pageSize
     * 使用MyBatis的分页插件实现分页功能：
     * 1、需要在查询功能之前开启分页
     * PageHelper.startPage(int pageNum, int pageSize)
     * 2、在查询功能之后获取分页相关信息
     * PageInfo<Emp> pageInfo=new PageInfo<>(emps,5)
     * emps表示分页数据
     * 5表示当前导航分页的个数
     */

    @Test
    public void testPageHelper(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        PageHelper.startPage(2,5);
        List<Emp> emps = mapper.selectByExample(null);
        PageInfo<Emp> pageInfo=new PageInfo<>(emps,5);
        emps.forEach(emp -> System.out.println(emp));
        System.out.println(pageInfo);
    }
}
