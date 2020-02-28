package com.suixiang.mapper;

import com.suixiang.pojo.Vision;
import com.suixiang.pojo.VisionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VisionMapper {
    int countByExample(VisionExample example);

    int deleteByExample(VisionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Vision record);

    int insertSelective(Vision record);

    List<Vision> selectByExample(VisionExample example);

    Vision selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Vision record, @Param("example") VisionExample example);

    int updateByExample(@Param("record") Vision record, @Param("example") VisionExample example);

    int updateByPrimaryKeySelective(Vision record);

    int updateByPrimaryKey(Vision record);
}