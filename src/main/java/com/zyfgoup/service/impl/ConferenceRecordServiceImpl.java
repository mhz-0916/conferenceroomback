package com.zyfgoup.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.zyfgoup.common.dto.Record;
import com.zyfgoup.entity.ConferenceRecord;
import com.zyfgoup.entity.group.ConRApplyRecord;
import com.zyfgoup.mapper.ConferenceRecordMapper;
import com.zyfgoup.service.ConferenceRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zyfgoup
 * @since 2020-06-18
 */
@Service
public class ConferenceRecordServiceImpl extends ServiceImpl<ConferenceRecordMapper, ConferenceRecord> implements ConferenceRecordService {

    @Autowired
    ConferenceRecordMapper conferenceRecordMapper;

    @Override
    public List<ConRApplyRecord> listByConditions( Integer auditState,
                                                  String depName,Integer currentPage,Integer deleted){

        //index从0开始
        Integer startIndex = (currentPage-1)*7; //一页7条数据
        if(StringUtils.equals("000all000",depName)){
            depName=null;
        }
        return conferenceRecordMapper.listByConditions(auditState,depName,startIndex,deleted);
    }

    @Override
    public Integer getTotalByConditions(Integer auditState, String depName,Integer deleted) {
        if(StringUtils.equals("000all000",depName)){
            depName=null;
        }
        return conferenceRecordMapper.getTotalByConditions(auditState,depName,deleted);
    }
    @Override
    public Integer searchApplyId(Integer roomId) {
        return conferenceRecordMapper.searchApplyId(roomId);
    }

    @Override
    public List<ConRApplyRecord> searchRecord(LocalDateTime searchTime){
        // 2020-08-31
        // startTime 2020-08-31 00:00:00
        LocalDateTime startTime = searchTime;
        // endTime 2020-08-31 24:00:00
        LocalDateTime endTime = searchTime.plusDays(1);
        return conferenceRecordMapper.searchRecord(startTime,endTime);
    }

}
