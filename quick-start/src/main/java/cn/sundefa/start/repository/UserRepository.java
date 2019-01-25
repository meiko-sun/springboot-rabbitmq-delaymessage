package cn.sundefa.start.repository;

import cn.sundefa.start.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * MongoDB测试repository
 *
 * @author defa sun
 * @date 2018-08-21 15:44:39
 */
public interface UserRepository extends MongoRepository<User, String> {

}
