package jpabook.jpashop1.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private List<OrderItem> orderItems = new ArrayList();

    private Delivery delivery;

    private LocalDateTime orderDate;    // 주문시간

    private OrderStatus status; // 주문상태 [ORDER, CANCEL]

}
