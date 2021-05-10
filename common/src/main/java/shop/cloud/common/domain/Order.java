package shop.cloud.common.domain;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name="shop_order")
@Data
public class Order implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long oid;
	
	private Integer uid;
	
	private String username;
	
	private Integer pid;
	
	private String pname;
	
	private Double pprice;
	
	private Integer number;

	@Transient
	private Integer port;
}
