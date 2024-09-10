package hello.itemservice.repository.jpa;

import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataJpaItemRepository extends JpaRepository<Item, Long> { // JpaRepository <사용할 객체명, PK(@Id) 타입>

    List<Item> findByItemNameLike(String itemName); // 이름으로만 조회

    List<Item> findByPriceLessThanEqual(Integer price); // 이름으로만 조회

    // 쿼리 메서드 findItems 과 동일
    List<Item> findByItemNameLikeAndPriceLessThanEqual(String itemName, Integer price);

    // 쿼리 직접 실행 @Query(사용할 쿼리 jpql) + @Param(사용할 파라미터명) - 파라미터 바인딩 추가
    @Query("select i from Item i where i.itemName like :itemName and i.price < :price")
    List<Item> findItems(@Param("itemName") String itemName, @Param("price") Integer price);
}
