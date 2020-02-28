package com.suixiang.mapper;

import com.suixiang.pojo.UserVision;
import com.suixiang.pojo.UserVisionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserVisionMapper {
    int countByExample(UserVisionExample example);

    int deleteByExample(UserVisionExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserVision record);

    int insertSelective(UserVision record);

    List<UserVision> selectByExample(UserVisionExample example);

    UserVision selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserVision record, @Param("example") UserVisionExample example);

    int updateByExample(@Param("record") UserVision record, @Param("example") UserVisionExample example);

    int updateByPrimaryKeySelective(UserVision record);

    int updateByPrimaryKey(UserVision record);
}