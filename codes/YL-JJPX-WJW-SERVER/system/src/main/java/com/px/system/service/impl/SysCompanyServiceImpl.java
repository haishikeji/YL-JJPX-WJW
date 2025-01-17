package com.px.system.service.impl;

import com.px.common.core.domain.TreeSelect;
import com.px.common.utils.DateUtils;
import com.px.system.domain.SysCompany;
import com.px.system.mapper.SysCompanyMapper;
import com.px.system.service.ISysCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 单位Service业务层处理
 *
 * @author 品讯科技
 * @date 2024-08
 */
@Service
public class SysCompanyServiceImpl implements ISysCompanyService {
    @Autowired
    private SysCompanyMapper sysCompanyMapper;

    /**
     * 查询单位
     *
     * @param ID 单位主键
     * @return 单位
     */
    @Override
    public SysCompany selectTCompanyByID(Long ID) {
        return sysCompanyMapper.selectSysCompanyById(ID);
    }

    /**
     * 查询单位列表
     *
     * @param sysCompany 单位
     * @return 单位
     */
    @Override
    public List<SysCompany> selectTCompanyList(SysCompany sysCompany) {
        return sysCompanyMapper.selectSysCompanyList(sysCompany);
    }

    /**
     * 根据单位名称查找单位
     *
     * @param company
     * @return
     */
    @Override
    public SysCompany selectDeptByName(SysCompany company) {
        return sysCompanyMapper.selectDeptByName(company);
    }

    /**
     * 新增单位
     *
     * @param sysCompany 单位
     * @return 结果
     */
    @Override
    public int insertTCompany(SysCompany sysCompany) {
        sysCompany.setCreateTime(DateUtils.getNowDate());
        return sysCompanyMapper.insertSysCompany(sysCompany);
    }

    /**
     * 修改单位
     *
     * @param sysCompany 单位
     * @return 结果
     */
    @Override
    public int updateTCompany(SysCompany sysCompany) {
        return sysCompanyMapper.updateSysCompany(sysCompany);
    }

    /**
     * 批量删除单位
     *
     * @param IDs 需要删除的单位主键
     * @return 结果
     */
    @Override
    public int deleteTCompanyByIds(String[] IDs) {
        return sysCompanyMapper.deleteSysCompanyByIds(IDs);
    }

    /**
     * 删除单位信息
     *
     * @param ID 单位主键
     * @return 结果
     */
    @Override
    public int deleteTCompanyById(String ID) {
        return sysCompanyMapper.deleteSysCompanyById(ID);
    }

    /**
     * 更新用户状态
     *
     * @param company
     * @return
     */
    @Override
    public int updateCompanyStatus(SysCompany company) {
        company.setUpdateTime(DateUtils.getNowDate());
        return sysCompanyMapper.updateSysCompany(company);
    }

    @Override
    public List<TreeSelect> companySelect(SysCompany sysCompany) {
        List<TreeSelect> treeSelects = new ArrayList<>();
        List<SysCompany> sysCompanies = sysCompanyMapper.selectSysCompanyList(sysCompany);
        for (SysCompany company : sysCompanies) {
            TreeSelect treeSelect = new TreeSelect();
            treeSelect.setId(company.getId());
            treeSelect.setLabel(company.getCoName());
            treeSelects.add(treeSelect);
        }
        return treeSelects;
    }
}
