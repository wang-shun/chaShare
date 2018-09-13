package com.holley.platform.service;

import java.util.List;
import java.util.Map;

import com.holley.platform.model.sys.SysCarBrand;
import com.holley.platform.model.sys.SysCarBrandExample;
import com.holley.platform.model.sys.SysDefArea;
import com.holley.platform.model.sys.SysDefAreaExample;
import com.holley.platform.model.sys.SysLink;
import com.holley.platform.model.sys.SysLinkExample;
import com.holley.platform.model.sys.SysLinkType;
import com.holley.platform.model.sys.SysLinkTypeExample;
import com.holley.platform.model.sys.SysRule;
import com.holley.platform.model.sys.SysRuleExample;

/**
 * 数据字典
 * 
 * @author zhouli
 */
public interface DictionaryService {

    // ---------SysLinkType---------------
    List<SysLinkType> selectLinkTypeByExample(SysLinkTypeExample example);

    // ---------SysLink-------------------
    int insertLink(SysLink record);

    int updateLinkByPKSelective(SysLink record);

    /**
     * 由定义的linktype得到对应的数据字典定义
     */
    public List<SysLink> selectLinkByType(String linkType);

    List<SysLink> selectLinkByExample(SysLinkExample example);

    List<SysLink> selectLinkByPage(Map<String, Object> params);

    SysLink selectLinkByPK(String id);

    // ----------SysDefArea----------------
    public List<SysDefArea> selectByAreaExample(SysDefAreaExample example);

    // ----------SysCarBrand---------------
    List<SysCarBrand> selectCarBrandByExample(SysCarBrandExample example);

    // ----------SysRule---------------
    int insertRuleSelective(SysRule record);

    int updateRuleByPKSelective(SysRule record);

    SysRule selectRuleByPK(String id);

    List<SysRule> selectRuleByExample(SysRuleExample emp);

    List<SysRule> selectRuleByPage(Map<String, Object> params);

}
