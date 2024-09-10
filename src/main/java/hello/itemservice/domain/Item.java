package hello.itemservice.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity // JPA 가 인식하기 위한 어노테이션 (DB 테이블 매칭)
@Table(name = "item")
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // @Id : PK GenerationType.IDENTITY : DB 에서 값을 자동으로 증가 시키는 경우 (auto_increment)
    private Long id;

    @Column(name = "item_name", length = 10)
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() { // JPA 를 사용하기 위해서는 항상 기본 생성자를 정의해야한다.
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
