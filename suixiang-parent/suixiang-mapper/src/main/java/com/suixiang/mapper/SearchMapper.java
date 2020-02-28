package com.suixiang.mapper;

import java.util.List;

import com.suixiang.pojo.Search;
import com.suixiang.utils.MyMapper;

public interface SearchMapper extends MyMapper<Search> {
	public List<String> getHotWordList();
}