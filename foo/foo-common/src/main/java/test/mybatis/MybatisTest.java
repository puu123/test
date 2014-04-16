package test.mybatis;

import java.io.FileInputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("mybatis\\mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(fis);
		SqlSession session = sqlSessionFactory.openSession(true);
		TestMapper mapper = session.getMapper(TestMapper.class);

		// id="select"
		Test t1 = mapper.select(1);
		System.out.println(t1.getId() + ":" + t1.getName());

		// id="insert"
		Test t2 = new CopyOfTestImpl();
		t2.setId(3);
		t2.setName("oro");
		mapper.insert(t2);

		// id="selectALL"
		List<Test> list = mapper.selectALL();
		for (Test t : list) {
			System.out.println(t.getId() + ":" + t.getName());
		}

		session.close();
	}

}
