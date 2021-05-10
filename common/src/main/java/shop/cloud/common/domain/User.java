package shop.cloud.common.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name="shop_user")
@Data//lombok 不再写 set get
public class User  implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer uid;
	
	private String username;
	
	private String password;
	
	private String telphone;
	
}
