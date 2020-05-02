package cn.stylefeng.guns.modular.controller;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.core.util.KommonUtil;
import cn.stylefeng.guns.modular.dao.WorkUnitDao;
import cn.stylefeng.guns.modular.entity.WorkUnit;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ErrorResponseData;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * (WorkUnit)表控制层
 *
 * @author makejava
 * @since 2020-04-29 17:05:46
 */
@Controller
@RequestMapping("workUnit")
@Slf4j
public class WorkUnitController extends BaseController { 

    private static final String PREFIX = "modular/kenchan/";
    private static final ErrorResponseData ERROR_TIP = ResponseData.error("请检查输入是否合法");

    @Resource
    WorkUnitDao workUnitDao;

    @RequestMapping("")
    public String api1() {
        return PREFIX + "workUnit" + KommonUtil.HTML_SUFFIX;
    }

    @RequestMapping("/add")
    public String add() {
        return PREFIX + "workUnitEdit" + KommonUtil.HTML_SUFFIX;
    }

    @RequestMapping("/save")
    @ResponseBody
    public ResponseData add(WorkUnit workUnit) {
        try {
            workUnit.insertOrUpdate();
            return SUCCESS_TIP;
        } catch (Exception e) {
            log.error(null, e);
            return ERROR_TIP;
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(@RequestParam Long id) {
        try {
            new WorkUnit(id).deleteById();
            return SUCCESS_TIP;
        } catch (Exception e) {
            log.error(null, e);
            return ERROR_TIP;
        }
    }

    @RequestMapping("/list")
    @ResponseBody
    public LayuiPageInfo list(long page, long limit, String condition) {
        try {
            IPage<WorkUnit> workUnitIPage;
            if (StringUtils.isEmpty(condition)) {
                workUnitIPage = workUnitDao
                        .selectPage(new Page<>(page, limit), null);
            } else {
                workUnitIPage = workUnitDao
                        .selectPage(new Page<>(page, limit),
                                new QueryWrapper<WorkUnit>()
                                        .like("unit_name", condition).select());
            }
            return LayuiPageFactory.createPageInfo(workUnitIPage);

        } catch (Exception e) {
            log.error(null, e);
            return LayuiPageFactory.createPageInfo(new Page(0, 0));
        }

    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Object getUserInfo(@RequestParam Long id) {
        WorkUnit workUnit;
        try {
            workUnit = new WorkUnit(id).selectById();

        } catch (Exception e) {
            log.error(null, e);
            return ERROR_TIP;
        }
        return ResponseData.success(workUnit);
    }

}