package com.holley.platform.dao.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.platform.model.sys.SysNotice;
import com.holley.platform.model.sys.SysNoticeExample;
import com.holley.platform.model.sys.SysNoticeMessage;

public interface SysNoticeMapper {

    int countByExample(SysNoticeExample example);

    int deleteByExample(SysNoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNotice record);

    int insertSelective(SysNotice record);

    List<SysNotice> selectByExample(SysNoticeExample example);

    SysNotice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNotice record, @Param("example") SysNoticeExample example);

    int updateByExample(@Param("record") SysNotice record, @Param("example") SysNoticeExample example);

    int updateByPrimaryKeySelective(SysNotice record);

    int updateByPrimaryKey(SysNotice record);

    /**
     * 分页查询消息列表
     * 
     * @param param
     * @return
     */
    List<SysNoticeMessage> selectSysNoticeByPage(Map<String, Object> param);

    /**
     * 批量插入
     * 
     * @param list
     * @return
     */
    int insertNoticeBatch(List<SysNotice> list);

    /**
     * 根据条件查询单一信息
     * 
     * @param param
     * @return
     */
    SysNoticeMessage selectSysNoticeMessage(Map<String, Object> param);
}
