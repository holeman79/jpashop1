package jpabook.jpashop1.repository;

import jpabook.jpashop1.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final EntityManager em;

    public void save(Order order){
        em.persist(order);
    }

    public Order findOne(Long id){
        return em.find(Order.class, id);
    }

    public List<Order> findAll(OrderSearch orderSearch){


        String jpql = "select o from Order o join o.member m";
        return em.createQuery(jpql, Order.class)
                .setMaxResults(1000)    // 최대 1000건
                .getResultList();
    }
//
//    /**
//     * JPA Criteria
//     */
//    public List<Order> findAllByCriteria(OrderSearch orderSearch){
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
//
//    }
}
