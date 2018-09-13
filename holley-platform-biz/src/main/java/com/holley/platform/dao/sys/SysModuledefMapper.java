package com.holley.platform.dao.sys;

import com.holley.platform.model.sys.SysModuledef;
import com.holley.platform.model.sys.SysModuledefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysModuledefMapper {
    int countByExample(SysModuledefExample example);

    int deleteByExample(SysModuledefExample example);

    int deleteByPrimaryKey(String moduleid);

    int insert(SysModuledef record);

    int insertSelective(SysModuledef record);

    List<SysModuledef> selectByExample(SysModuledefExample example);

    SysModuledef selectByPrimaryKey(String moduleid);

    int updateByExampleSelective(@Param("record") SysModuledef record, @Param("example") SysModuledefExample example);

    int updateByExample(@Param("record") SysModuledef record, @Param("example") SysModuledefExample example);

    int updateByPrimaryKeySelective(SysModuledef record);

    int updateByPrimaryKey(SysModuledef record);
    
    List<SysModuledef> selectModuledefByUserid(Integer userid);
}