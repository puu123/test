package test.mybatis;

import java.util.List;

public interface TestMapper {
	Test select(int id);
	List<Test> selectALL();
	void insert(Test t);
}
