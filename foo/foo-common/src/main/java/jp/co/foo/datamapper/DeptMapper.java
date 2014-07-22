package jp.co.foo.datamapper;

import java.util.List;
import jp.co.foo.dto.DeptDto;
import jp.co.foo.dto.DeptExample;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DEPT
     *
     * @mbggenerated Tue Jul 22 21:56:38 JST 2014
     */
    int countByExample(DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DEPT
     *
     * @mbggenerated Tue Jul 22 21:56:38 JST 2014
     */
    int deleteByExample(DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DEPT
     *
     * @mbggenerated Tue Jul 22 21:56:38 JST 2014
     */
    int deleteByPrimaryKey(Short deptno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DEPT
     *
     * @mbggenerated Tue Jul 22 21:56:38 JST 2014
     */
    int insert(DeptDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DEPT
     *
     * @mbggenerated Tue Jul 22 21:56:38 JST 2014
     */
    int insertSelective(DeptDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DEPT
     *
     * @mbggenerated Tue Jul 22 21:56:38 JST 2014
     */
    List<DeptDto> selectByExample(DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DEPT
     *
     * @mbggenerated Tue Jul 22 21:56:38 JST 2014
     */
    DeptDto selectByPrimaryKey(Short deptno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DEPT
     *
     * @mbggenerated Tue Jul 22 21:56:38 JST 2014
     */
    int updateByExampleSelective(@Param("record") DeptDto record, @Param("example") DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DEPT
     *
     * @mbggenerated Tue Jul 22 21:56:38 JST 2014
     */
    int updateByExample(@Param("record") DeptDto record, @Param("example") DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DEPT
     *
     * @mbggenerated Tue Jul 22 21:56:38 JST 2014
     */
    int updateByPrimaryKeySelective(DeptDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DEPT
     *
     * @mbggenerated Tue Jul 22 21:56:38 JST 2014
     */
    int updateByPrimaryKey(DeptDto record);
}