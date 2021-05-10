package shop.cloud.order.configuration;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;


@Configuration
public class ConfigJsonFomatter {
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
	    // 一、须要先定义一个 convert 转换消息的对象;
	    FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
	
	    //二、添加fastJson 的配置信息，好比：是否要格式化返回的json数据;
	    FastJsonConfig fastJsonConfig = new FastJsonConfig();
	    fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
	    //三、在convert中添加配置信息.
		fastConverter.setDefaultCharset(StandardCharsets.UTF_8);
		fastConverter.setFastJsonConfig(fastJsonConfig);

	    return new HttpMessageConverters(fastConverter);
	}
}

