package cn.sundefa.start.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Address
 *
 * @author sundefa
 * @date 2019/01/10
 */
@Document
@Data
@Builder
public class Address {

    @Id
    private  Integer addressId;

    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 门牌号楼道
     */
    private String house;
}
