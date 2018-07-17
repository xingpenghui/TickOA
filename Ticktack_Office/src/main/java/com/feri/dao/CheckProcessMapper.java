package com.feri.dao;

import com.feri.common.vo.EchartsItem;
import com.feri.common.vo.ProcessVo;
import com.feri.domain.CheckProcess;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/11 23:22
 */
public interface CheckProcessMapper {
    //发起流程
    @Insert("insert into t_check (type,startname,info,startno,startdate,enddate,days,pid,flag) values(#{type},#{startname},#{info},#{startno},#{startDate},#{endDate},#{days},#{pid},1)")
    int insert(CheckProcess checkProcess);
    //审批流程
    @Update("update t_check set flag=#{flag} where id=#{id}")
    int update(@Param("id") int id, @Param("flag") int flag);
    //查询流程信息
    @Select("select * from t_check where startno=#{no}")
    @ResultType(CheckProcess.class)
    List<CheckProcess> queryAll(String no);
    //待办事项
    @Select("select t.id_ tid,t.name_ tname,t.CREATE_TIME_ tctime,c.* from act_ru_task t left join t_check c on t.PROC_INST_ID_=c.pid where t.ASSIGNEE_=#{name}")
    @ResultType(ProcessVo.class)
    List<ProcessVo> queryByName(String name);
    @Select("select PROC_inst_id_ id,act_name_ aname,start_time_ stime,end_time_ etime,duration_ dura from act_hi_actinst where PROC_inst_id_=#{pid} order by start_time_")
    @ResultType(EchartsItem.class)
    public List<EchartsItem> queryBtEcharts(String pid);

}
