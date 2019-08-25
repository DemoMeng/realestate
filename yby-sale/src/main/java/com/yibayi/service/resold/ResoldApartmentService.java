package com.yibayi.service.resold;

import bean.common.response.ResponseBean;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yibayi.bean.entity.resold.ResoldApartment;
import com.yibayi.bean.entity.resold.vo.OwnerAssetRecord;

import java.util.List;

/**
 * <p>
 * 二手房 服务类
 * </p>
 *
 * @author mamba
 * @since 2019-08-25
 */
public interface ResoldApartmentService extends IService<ResoldApartment> {

    /*
    * 业主主页获取统计数据
    * */
    ResponseBean<OwnerAssetRecord> assetRecord(Long id);
    /*
     * 业主主页房源
     * */
    ResponseBean<List<ResoldApartment>> resoldApartment(Long id, String status);
}
