package com.feri.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.feri.common.vo.PageVo;
import com.feri.dao.InterviewQuestMapper;
import com.feri.domain.InterviewQuest;
import com.feri.service.InterviewQuestService;

@Service
public class InterviewQuestServiceImpl implements InterviewQuestService{

	@Autowired
	private InterviewQuestMapper mapper;
	@Override
	public boolean insert(InterviewQuest quest) {
		// TODO Auto-generated method stub
		return mapper.insert(quest)>0;
	}

	@Override
	public PageVo<InterviewQuest> queryByPage(int page, int count) {
		// TODO Auto-generated method stub
		int index=0;
		if(page>0) {
			index=(page-1)*count;
		}
		PageVo<InterviewQuest> po=new PageVo<>();
		po.setData(mapper.queryByPage(index, count));
		if(po.getData()!=null) {
			po.setCount(mapper.queryCount().intValue());
		}
		po.setCode(0);
		po.setMsg("OK");
		return po;
	}

}
