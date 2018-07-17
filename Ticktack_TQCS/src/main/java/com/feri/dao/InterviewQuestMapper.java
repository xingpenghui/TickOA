package com.feri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.feri.domain.InterviewQuest;

public interface InterviewQuestMapper {

	//新增
	int insert(InterviewQuest quest);
	//查询 分页
	List<InterviewQuest> queryByPage(@Param("index")int index,@Param("count")int count);
	//查询数量
	Long queryCount();
}
