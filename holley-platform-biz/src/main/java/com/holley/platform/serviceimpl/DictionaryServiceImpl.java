package com.holley.platform.serviceimpl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.holley.platform.dao.sys.SysDefAreaMapper;
import com.holley.platform.dao.sys.SysLinkMapper;
import com.holley.platform.dao.sys.SysLinkTypeMapper;
import com.holley.platform.dao.sys.SysRuleMapper;
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
import com.holley.platform.service.DictionaryService;

public class DictionaryServiceImpl implements DictionaryService {

    private SysLinkMapper     sysLinkMapper;
    private SysLinkTypeMapper sysLinkTypeMapper;
    private SysDefAreaMapper  sysDefAreaMapper;
    private SysRuleMapper     sysRuleMapper;

    // -----------------------------------SysLinkType--------------------------------------
    @Override
    public List<SysLinkType> selectLinkTypeByExample(SysLinkTypeExample example) {
        return sysLinkTypeMapper.selectByExample(example);
    }

    // -----------------------------------SysLink--------------------------------------
    @Override
    public int insertLink(SysLink record) {
        return sysLinkMapper.insert(record);
    }

    @Override
    public int updateLinkByPKSelective(SysLink record) {
        return sysLinkMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<SysLink> selectLinkByExample(SysLinkExample example) {
        return sysLinkMapper.selectByExample(example);
    }

    @Override
    public List<SysLink> selectLinkByType(String linkType) {
        if (StringUtils.isEmpty(linkType)) {
            return null;
        }
        SysLinkExample example = new SysLinkExample();
        SysLinkExample.Criteria cr = example.createCriteria();
        cr.andTypeIdEqualTo(linkType);
        return sysLinkMapper.selectByExample(example);
    }

    @Override
    public List<SysLink> selectLinkByPage(Map<String, Object> params) {
        return sysLinkMapper.selectLinkByPage(params);
    }

    @Override
    public SysLink selectLinkByPK(String id) {
        return sysLinkMapper.selectByPrimaryKey(id);
    }

    // ---------------------------------------SysDefArea--------------------------------------
    public List<SysDefArea> selectByAreaExample(SysDefAreaExample example) {
        return sysDefAreaMapper.selectByExample(example);
    }

    // --------------------------------------- SysCarBrand--------------------------------------
    @Override
    public List<SysCarBrand> selectCarBrandByExample(SysCarBrandExample example) {
        return null;
    }

    // --------------------------------------- SysRule--------------------------------------
    @Override
    public int insertRuleSelective(SysRule record) {
        return sysRuleMapper.insertSelective(record);
    }

    @Override
    public int updateRuleByPKSelective(SysRule record) {
        return sysRuleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public SysRule selectRuleByPK(String id) {
        return sysRuleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysRule> selectRuleByExample(SysRuleExample emp) {
        return sysRuleMapper.selectByExample(emp);
    }

    @Override
    public List<SysRule> selectRuleByPage(Map<String, Object> params) {
        return sysRuleMapper.selectRuleByPage(params);
    }

    // ----------------------------------set--------------------------------------

    public void setSysLinkMapper(SysLinkMapper sysLinkMapper) {
        this.sysLinkMapper = sysLinkMapper;
    }

    public void setSysLinkTypeMapper(SysLinkTypeMapper sysLinkTypeMapper) {
        this.sysLinkTypeMapper = sysLinkTypeMapper;
    }

    public void setSysDefAreaMapper(SysDefAreaMapper sysDefAreaMapper) {
        this.sysDefAreaMapper = sysDefAreaMapper;
    }

    public void setSysRuleMapper(SysRuleMapper sysRuleMapper) {
        this.sysRuleMapper = sysRuleMapper;
    }

}
