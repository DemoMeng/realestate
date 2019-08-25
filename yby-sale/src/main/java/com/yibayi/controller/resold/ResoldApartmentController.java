package com.yibayi.controller.resold;


import bean.common.response.ResponseBean;
import com.yibayi.bean.entity.resold.ResoldApartment;
import com.yibayi.bean.entity.resold.vo.OwnerAssetRecord;
import com.yibayi.core.base.controller.BaseController;
import com.yibayi.service.resold.ResoldApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 二手房 前端控制器
 * </p>
 *
 * @author mamba
 * @since 2019-08-25
 */
@RestController
@RequestMapping("/resold-apartment")
public class ResoldApartmentController extends BaseController {


    @Autowired
    private ResoldApartmentService resoldApartmentService;


    /**
     * 业主主页统计
     */
    @RequestMapping(value = "/assetRecord")
    @ResponseBody
    public ResponseBean<OwnerAssetRecord> assetRecord(Long id){
        return resoldApartmentService.assetRecord(id);
    }


    /*
    * 业主主页房源
    * */
    @RequestMapping(value = "/resoldApartment")
    @ResponseBody
    public ResponseBean<List<ResoldApartment>> resoldApartment(Long id, String status){
        return resoldApartmentService.resoldApartment(id,status);
    }

}
