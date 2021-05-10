package shop.cloud.common.domain;

import javax.persistence.*;

import lombok.Data;
import org.springframework.boot.web.server.WebServer;

import java.io.Serializable;

@Entity
@Table(name="shop_product")
@Data
public class Product  implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pid;
	
	private String pname;
	
	private Double pprice;
	
	private Integer stock;

	//由哪个微服务端口生产的对象，用于openfein的负载均衡
	@Transient
	private Integer port;
}
