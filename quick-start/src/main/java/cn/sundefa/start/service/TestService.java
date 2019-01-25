package cn.sundefa.start.service;

import cn.sundefa.start.base.result.Result;
import cn.sundefa.start.entity.AdvertPosition;
import cn.sundefa.start.mapper.AdvertPositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TestServerice
 *
 * @author sundefa
 * @date 2018/12/13
 */
@Service
public class TestService {

    @Autowired
    private AdvertPositionMapper advertPositionMapper;


    public Result<List<AdvertPosition>> getadvert() {

        List<AdvertPosition> advertPositions = advertPositionMapper.selectAll();

        return Result.make(advertPositions);
    }

}
