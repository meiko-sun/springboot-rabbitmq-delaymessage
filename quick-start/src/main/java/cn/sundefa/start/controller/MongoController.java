package cn.sundefa.start.controller;

import cn.sundefa.start.base.result.Result;
import cn.sundefa.start.entity.User;
import cn.sundefa.start.repository.UserRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TestController
 *
 * @author sundefa
 * @date 2018/12/13
 */
@RestController
public class MongoController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getUser")
    public Result getUser(int pageNum ,int pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<User> userList = userRepository.findAll();
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        return Result.make(userPageInfo);
    }

    @PostMapping("/saveUser")
    public Result saveUser(@RequestBody User user) {

        userRepository.save(user);
        return Result.make(user);
    }


    @GetMapping("/updateUserById")
    public Result updateUserById(@RequestParam String userId) {

        User user = userRepository.findById(userId).get();
        return Result.make(user);
    }
}
