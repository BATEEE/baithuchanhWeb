/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.repositories.iml;

import com.ttt.pojo.OrderDetail;
import com.ttt.pojo.Product;
import com.ttt.utils.HibernateUtils;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class StatsRepositoryIml {

    public List<Object[]> statsRevenueProduct() {
        try (Session s = HibernateUtils.getFACTORY().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
            Root root = q.from(Product.class);
            Join<OrderDetail, Product> join = root.join("productId", JoinType.RIGHT);
            q.multiselect(join.get("id"), join.get("name"), b.sum(b.prod(root.get("unitPrice"), root.get("quantity"))));
            q.groupBy(join.get("id"));
            
            Query q 
        }
    }
}
