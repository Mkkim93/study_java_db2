package hello.itemservice;

import com.zaxxer.hikari.util.DriverDataSource;
import hello.itemservice.config.*;
import hello.itemservice.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
@Slf4j
@Import(QueryDslConfig.class)
@SpringBootApplication(scanBasePackages = "hello.itemservice.web")
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	@Bean
	@Profile("local")
	public TestDataInit testDataInit(ItemRepository itemRepository) {
		return new TestDataInit(itemRepository);
	}

	// 임베디드 db 테스트 시 코드 작성
	/*@Bean
	@Profile("test")
	public DataSource dataSource() {
		log.info("메모리 데이터 베이스 초기화");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.mysql.Driver");
		dataSource.setUrl("jdbc:mysql:mem:db;DB_CLOSE_DELAY=-1"); // mysql 사용 불가
		dataSource.setUsername("test");
		dataSource.setPassword("java");
		return dataSource;
	}*/
}

