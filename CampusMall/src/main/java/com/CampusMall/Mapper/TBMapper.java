package com.CampusMall.Mapper;

import com.CampusMall.Pojo.TB;
import com.CampusMall.Pojo.TBExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_by
     *
     * @mbggenerated Wed May 31 21:46:48 CST 2023
     */
    int countByExample(TBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_by
     *
     * @mbggenerated Wed May 31 21:46:48 CST 2023
     */
    int deleteByExample(TBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_by
     *
     * @mbggenerated Wed May 31 21:46:48 CST 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_by
     *
     * @mbggenerated Wed May 31 21:46:48 CST 2023
     */
    int insert(TB record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_by
     *
     * @mbggenerated Wed May 31 21:46:48 CST 2023
     */
    int insertSelective(TB record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_by
     *
     * @mbggenerated Wed May 31 21:46:48 CST 2023
     */
    List<TB> selectByExampleWithBLOBs(TBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_by
     *
     * @mbggenerated Wed May 31 21:46:48 CST 2023
     */
    List<TB> selectByExample(TBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_by
     *
     * @mbggenerated Wed May 31 21:46:48 CST 2023
     */
    TB selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_by
     *
     * @mbggenerated Wed May 31 21:46:48 CST 2023
     */
    int updateByExampleSelective(@Param("record") TB record, @Param("example") TBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_by
     *
     * @mbggenerated Wed May 31 21:46:48 CST 2023
     */
    int updateByExampleWithBLOBs(@Param("record") TB record, @Param("example") TBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_by
     *
     * @mbggenerated Wed May 31 21:46:48 CST 2023
     */
    int updateByExample(@Param("record") TB record, @Param("example") TBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_by
     *
     * @mbggenerated Wed May 31 21:46:48 CST 2023
     */
    int updateByPrimaryKeySelective(TB record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_by
     *
     * @mbggenerated Wed May 31 21:46:48 CST 2023
     */
    int updateByPrimaryKeyWithBLOBs(TB record);
}