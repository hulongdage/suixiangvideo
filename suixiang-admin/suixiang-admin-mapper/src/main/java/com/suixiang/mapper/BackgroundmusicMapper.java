package com.suixiang.mapper;

import com.suixiang.pojo.Backgroundmusic;
import com.suixiang.pojo.BackgroundmusicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BackgroundmusicMapper {
    int countByExample(BackgroundmusicExample example);

    int deleteByExample(BackgroundmusicExample example);

    int deleteByPrimaryKey(String id);

    int insert(Backgroundmusic record);

    int insertSelective(Backgroundmusic record);

    List<Backgroundmusic> selectByExample(BackgroundmusicExample example);

    Backgroundmusic selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Backgroundmusic record, @Param("example") BackgroundmusicExample example);

    int updateByExample(@Param("record") Backgroundmusic record, @Param("example") BackgroundmusicExample example);

    int updateByPrimaryKeySelective(Backgroundmusic record);

    int updateByPrimaryKey(Backgroundmusic record);
}