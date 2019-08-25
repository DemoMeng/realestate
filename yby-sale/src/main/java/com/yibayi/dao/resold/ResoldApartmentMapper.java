package com.yibayi.dao.resold;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yibayi.bean.entity.resold.ResoldApartment;

/**
 * <p>
 * 二手房 Mapper 接口
 * </p>
 *
 * @author mamba
 * @since 2019-08-25
 */
public interface ResoldApartmentMapper extends BaseMapper<ResoldApartment> {

    int assetRecordArea(Long id);

    int assetRecordSale(Long id);

    int assetRecordDone(Long id);
}
