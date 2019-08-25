package com.yibayi.service.resold.impl;

import bean.common.response.ResponseBean;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yibayi.bean.entity.resold.ResoldApartment;
import com.yibayi.bean.entity.resold.vo.OwnerAssetRecord;
import com.yibayi.dao.resold.ResoldApartmentMapper;
import com.yibayi.service.resold.ResoldApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 二手房 服务实现类
 * </p>
 *
 * @author mamba
 * @since 2019-08-25
 */
@Service
public class ResoldApartmentServiceImpl extends ServiceImpl<ResoldApartmentMapper, ResoldApartment> implements ResoldApartmentService {


    @Autowired
    private ResoldApartmentMapper resoldApartmentMapper;

    @Override
    public ResponseBean<OwnerAssetRecord> assetRecord(Long id) {
        ResponseBean<OwnerAssetRecord> res = new ResponseBean<OwnerAssetRecord>();
        if(id == null){
            res.setMsg("参数不能为空！");
        }
//        QueryWrapper<ResoldApartment> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().eq(ResoldApartment::getUserId,id ).groupBy(ResoldApartment::getCity);
//        int i = count(queryWrapper);
        OwnerAssetRecord record = new OwnerAssetRecord();
        int areaCount = resoldApartmentMapper.assetRecordArea(id);
        int saleCount = resoldApartmentMapper.assetRecordSale(id);
        int doneCount = resoldApartmentMapper.assetRecordDone(id);
        record.setAreaCount(String.valueOf(areaCount)+" 个");
        record.setOnSaleCount(String.valueOf(saleCount)+" 套");
        record.setDoneCount(String.valueOf(doneCount)+" 套");
        res.success();
        res.setObj(record);
        return res;
    }

    @Override
    public ResponseBean<List<ResoldApartment>> resoldApartment(Long id, String status) {
        ResponseBean<List<ResoldApartment>> res = new ResponseBean<List<ResoldApartment>>();
        QueryWrapper<ResoldApartment> queryWrapper = new QueryWrapper<ResoldApartment>();
        queryWrapper.lambda().eq(ResoldApartment::getUserId,id).eq(ResoldApartment::getSellStatus, status);
        List<ResoldApartment> list = list(queryWrapper);
        res.setObj(list);
        return res;
    }
}
