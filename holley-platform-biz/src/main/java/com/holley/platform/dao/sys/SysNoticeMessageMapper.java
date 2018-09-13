package com.holley.platform.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.holley.platform.model.sys.SysNoticeMessage;
import com.holley.platform.model.sys.SysNoticeMessageExample;

public interface SysNoticeMessageMapper {

    int countByExample(SysNoticeMessageExample example);

    int deleteByExample(SysNoticeMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNoticeMessage record);

    int insertSelective(SysNoticeMessage record);

    List<SysNoticeMessage> selectByExample(SysNoticeMessageExample example);

    SysNoticeMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNoticeMessage record, @Param("example") SysNoticeMessageExample example);

    int updateByExample(@Param("record") SysNoticeMessage record, @Param("example") SysNoticeMessageExample example);

    int updateByPrimaryKeySelective(SysNoticeMessage record);

    int updateByPrimaryKey(SysNoticeMessage record);

}
