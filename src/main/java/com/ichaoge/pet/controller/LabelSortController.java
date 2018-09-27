package com.ichaoge.pet.controller;

import com.ichaoge.pet.controller.baseinfo.BaseController;
import com.ichaoge.pet.domain.baseenum.ResulstCodeEnum;
import com.ichaoge.pet.domain.entity.LabelSort;
import com.ichaoge.pet.domain.entity.enums.LabelTypeEnums;
import com.ichaoge.pet.domain.output.LabelSortOutput;
import com.ichaoge.pet.service.iservice.LabelSortServiceI;
import com.ichaoge.pet.utils.Utils;
import com.retail.sap.api.base.RemoteResult;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoge on 2018/9/18.
 */
@CrossOrigin(allowCredentials = "true", origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/labelSort")
public class LabelSortController extends BaseController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LabelSortController.class);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Resource
    private LabelSortServiceI labelSortServiceI;

    /**
     * 查询所有标签
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> queryAll(HttpServletRequest request, @RequestBody LabelSort param) {
        logger.info("请求地址：" + request.getRequestURI() + ",请求参数："+param + "，sessionid:" + request.getSession().getId() + "，用户：" + getUser());
        List<LabelSortOutput> result = new ArrayList<>();
        //开始查询
        try {

            List<LabelSort> labelSortList = labelSortServiceI.selectByExample(param);
            List<com.ichaoge.pet.domain.output.LabelSort> labelSortList1 = new ArrayList<>();
            List<com.ichaoge.pet.domain.output.LabelSort> labelSortList2 = new ArrayList<>();
            List<com.ichaoge.pet.domain.output.LabelSort> labelSortList3 = new ArrayList<>();
            List<com.ichaoge.pet.domain.output.LabelSort> labelSortList4 = new ArrayList<>();
            if(labelSortList.size()>0){
                for (LabelSort labelSort:labelSortList) {
                    if(labelSort.getType() == LabelTypeEnums.DAILY.getValue()){
                        labelSortList1.add(new com.ichaoge.pet.domain.output.LabelSort(labelSort));
                    }
                    if(labelSort.getType() == LabelTypeEnums.APPLIANCE.getValue()){
                        labelSortList2.add(new com.ichaoge.pet.domain.output.LabelSort(labelSort));
                    }
                    if(labelSort.getType() == LabelTypeEnums.FOOD.getValue()){
                        labelSortList3.add(new com.ichaoge.pet.domain.output.LabelSort(labelSort));
                    }
                    if(labelSort.getType() == LabelTypeEnums.HEALTHCARE.getValue()){
                        labelSortList4.add(new com.ichaoge.pet.domain.output.LabelSort(labelSort));
                    }
                }

                for(int i=0;i<LabelTypeEnums.values().length;i++){
                    if(LabelTypeEnums.values()[i].getValue()==1){
                        result.add(new LabelSortOutput(LabelTypeEnums.values()[i].getValue(),LabelTypeEnums.values()[i].getDesc(),labelSortList1));
                    }
                    if(LabelTypeEnums.values()[i].getValue()==2){
                        result.add(new LabelSortOutput(LabelTypeEnums.values()[i].getValue(),LabelTypeEnums.values()[i].getDesc(),labelSortList2));
                    }
                    if(LabelTypeEnums.values()[i].getValue()==3){
                        result.add(new LabelSortOutput(LabelTypeEnums.values()[i].getValue(),LabelTypeEnums.values()[i].getDesc(),labelSortList3));
                    }
                    if(LabelTypeEnums.values()[i].getValue()==4){
                        result.add(new LabelSortOutput(LabelTypeEnums.values()[i].getValue(),LabelTypeEnums.values()[i].getDesc(),labelSortList4));
                    }
                }
            }
            logger.info("应答参数：" + result + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("查询所有标签失败!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"查询所有标签失败!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), result);
    }

}
