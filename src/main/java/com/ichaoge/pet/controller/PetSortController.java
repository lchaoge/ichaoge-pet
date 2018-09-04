package com.ichaoge.pet.controller;

import com.ichaoge.pet.common.MenuPetSortUtil;
import com.ichaoge.pet.controller.baseinfo.BaseController;
import com.ichaoge.pet.domain.baseenum.ResulstCodeEnum;
import com.ichaoge.pet.domain.entity.PetSort;
import com.ichaoge.pet.domain.entity.PetSortExample;
import com.ichaoge.pet.service.iservice.PetSortServiceI;
import com.ichaoge.pet.utils.Utils;
import com.retail.sap.api.base.RemoteResult;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by chaoge on 2018/8/30.
 */
@CrossOrigin(allowCredentials = "true", origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/petSort")
public class PetSortController extends BaseController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PetSortController.class);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Resource
    private PetSortServiceI petSortServiceI;

    /**
     * 获取宠物分类
     *
     * @param request
     * @return 查询结果信息
     */
    @RequestMapping(value = "/queryAllPetSort", method = RequestMethod.POST)
    @ResponseBody
    public RemoteResult<?> queryAllPetSort(HttpServletRequest request) {
        logger.info("请求地址：" + request.getRequestURI() + "  " + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        List<Object> menuList = null;
        //开始查询
        try {
            PetSortExample param = new PetSortExample();
            MenuPetSortUtil menuTree = new MenuPetSortUtil();
            List<PetSort> petSorts = petSortServiceI.selectByExample(param);
            menuList = menuTree.menuList(petSorts);
            logger.info("应答参数：" + petSorts.size() + "sessionid:" + request.getSession().getId() + "用户：" + getUser());
        } catch (Exception e) {
            logger.error("查询发生未知错误!", e);
            return Utils.webResult(false, ResulstCodeEnum.SERVICE_EXCEPTION.getCode(),
                    "查询发生未知错误!", null);
        }
        return Utils.webResult(true, ResulstCodeEnum.SERVICE_SUCESS.getCode(),
                ResulstCodeEnum.SERVICE_SUCESS.getCodeDesc(), menuList);
    }

}
