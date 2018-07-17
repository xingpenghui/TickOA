package com.feri.service;

import java.util.List;

import com.feri.common.vo.PageVo;
import com.feri.domain.InterviewQuest;
import com.feri.domain.LoginLog;

public interface InterviewQuestService {

	boolean insert(InterviewQuest quest);
	PageVo<InterviewQuest> queryByPage(int page,int count);
}
