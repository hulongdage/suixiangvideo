package com.suixiang.mapper;

import com.suixiang.pojo.ReportNodes;
import com.suixiang.pojo.ReportNodesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReportNodesMapper {
    int countByExample(ReportNodesExample example);

    int deleteByExample(ReportNodesExample example);

    int deleteByPrimaryKey(String id);

    int insert(ReportNodes record);

    int insertSelective(ReportNodes record);

    List<ReportNodes> selectByExample(ReportNodesExample example);

    ReportNodes selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ReportNodes record, @Param("example") ReportNodesExample example);

    int updateByExample(@Param("record") ReportNodes record, @Param("example") ReportNodesExample example);

    int updateByPrimaryKeySelective(ReportNodes record);

    int updateByPrimaryKey(ReportNodes record);
}