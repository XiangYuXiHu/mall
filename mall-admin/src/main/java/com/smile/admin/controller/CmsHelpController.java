package com.smile.admin.controller;


import com.smile.admin.service.CmsHelpService;
import com.smile.common.domain.BizResponse;
import com.smile.dao.entity.CmsHelp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 帮助表 前端控制器
 * </p>
 *
 * @author smile
 * @since 2022-07-02
 */
@Slf4j
@Api(tags = "CmsHelpController", value = "cms帮助")
@RestController
@RequestMapping("cmsHelp")
public class CmsHelpController {

    @Autowired
    private CmsHelpService cmsHelpService;

    @ApiOperation("cms帮助列表")
    @GetMapping("list")
    public BizResponse<List<CmsHelp>> test(@ApiParam("标题") String title) {
        List<CmsHelp> list = cmsHelpService.list();
        return BizResponse.success(list);
    }

}

