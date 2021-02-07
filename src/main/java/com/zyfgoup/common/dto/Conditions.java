package com.zyfgoup.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 用来传递给前端显示会议室的条件筛选
 * @Author Zyfgoup
 * @Date 2020/6/19 16:25
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conditions {

    //所有楼层 数据库楼层为varchar  这样就无法排序了

    List<Map<String,String>> buildings;
    List<Map<String,Integer>> floors;
    List<Map<String,String>> nos;

    }

