package com.ichaoge.pet.controller;

import com.ichaoge.pet.controller.baseinfo.BaseController;
import com.ichaoge.pet.domain.baseenum.ResulstCodeEnum;
import com.ichaoge.pet.domain.entity.LabelSort;
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
            if(labelSortList.size()>0){
                for (LabelSort labelSort:labelSortList) {
                    result.add(new LabelSortOutput(labelSort));
                }
            }
            logger.info("应答参数：" + labelSortList + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("查询所有标签失败!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),"查询所有标签失败!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), result);
    }

}
