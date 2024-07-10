package com.enigmacamp.tokonyadia.utils.specifications;

import com.enigmacamp.tokonyadia.model.dto.request.CustomerRequest;
import com.enigmacamp.tokonyadia.model.entity.Customer;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CustomerSpecification {
    public static Specification<Customer> getSpecification(CustomerRequest customerRequest) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (customerRequest.getName()!= null) {
                Predicate name = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%"+ customerRequest.getName().toLowerCase() + "%");
                predicates.add(name);
            }
            if (customerRequest.getPhoneNumber()!= null) {
                Predicate phoneNumber = criteriaBuilder.like(criteriaBuilder.lower(root.get("phoneNumber")), "%"+ customerRequest.getPhoneNumber() + "%");
                predicates.add(phoneNumber);
            }
            if (customerRequest.getAddress()!= null) {
                Predicate address = criteriaBuilder.like(criteriaBuilder.lower(root.get("address")), "%"+ customerRequest.getAddress().toLowerCase() + "%");
                predicates.add(address);
            }
            if (customerRequest.getBirthDate()!= null) {
            Predicate birthDate = criteriaBuilder.like(criteriaBuilder.lower(root.get("birthDate")), "%"+ customerRequest.getBirthDate().toString().toLowerCase() + "%");
            predicates.add(birthDate);
            }
            Predicate[] arrayPredicate = predicates.toArray((new Predicate[0]));
            return criteriaBuilder.and(arrayPredicate);
        });
    }

}
