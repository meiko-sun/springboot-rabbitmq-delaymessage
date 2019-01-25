package cn.sundefa.start.controller;

import cn.sundefa.start.base.result.Result;
import cn.sundefa.start.entity.AdvertPosition;
import cn.sundefa.start.service.TestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TestController
 *
 * @author sundefa
 * @date 2018/12/13
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public Result test(int pageNum ,int pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        Result<List<AdvertPosition>> getadvert = testService.getadvert();
        PageInfo pageInfo = new PageInfo(getadvert.getData());
        return Result.make(pageInfo);
    }
}
