package cn.sundefa.start;

import cn.sundefa.start.entity.Address;
import cn.sundefa.start.entity.User;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StartApplicationTests {

    @Test
    public void contextLoads() {


        User user = User.builder().build();
        Address address1 = Address.builder()
//                .addressId(1)
                .province("北京").city("北京").house("城中村").build();

        Address address2 = Address.builder()
//                .addressId(2)
                .province("上海").city("上海").house("瓜皮村").build();

        Address address3 = Address.builder()
//                .addressId(3)
                .province("浙江").city("杭州").house("西湖水").build();

        List<Address> addresses = Lists.newArrayList();

        addresses.add(address1);
        addresses.add(address2);
        addresses.add(address3);
        user.setAddress(addresses);
        user.setUserId("111");
        user.setAge("5");
        user.setCreatTime(new Date());
        user.setName("无敌是多么寂寞");
        System.out.println(JSON.toJSONString(user));
    }

}

