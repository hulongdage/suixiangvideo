package com.suixiang.mapper;

import com.suixiang.pojo.Search;
import com.suixiang.pojo.SearchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SearchMapper {
    int countByExample(SearchExample example);

    int deleteByExample(SearchExample example);

    int deleteByPrimaryKey(String id);

    int insert(Search record);

    int insertSelective(Search record);

    List<Search> selectByExample(SearchExample example);

    Search selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Search record, @Param("example") SearchExample example);

    int updateByExample(@Param("record") Search record, @Param("example") SearchExample example);

    int updateByPrimaryKeySelective(Search record);

    int updateByPrimaryKey(Search record);
}