package com.holley.platform.dao.sys;

import com.holley.platform.model.sys.SysNoticeTemplate;
import com.holley.platform.model.sys.SysNoticeTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNoticeTemplateMapper {
    int countByExample(SysNoticeTemplateExample example);

    int deleteByExample(SysNoticeTemplateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNoticeTemplate record);

    int insertSelective(SysNoticeTemplate record);

    List<SysNoticeTemplate> selectByExample(SysNoticeTemplateExample example);

    SysNoticeTemplate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNoticeTemplate record, @Param("example") SysNoticeTemplateExample example);

    int updateByExample(@Param("record") SysNoticeTemplate record, @Param("example") SysNoticeTemplateExample example);

    int updateByPrimaryKeySelective(SysNoticeTemplate record);

    int updateByPrimaryKey(SysNoticeTemplate record);
}