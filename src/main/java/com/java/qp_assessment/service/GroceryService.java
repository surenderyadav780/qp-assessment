package com.java.qp_assessment.service;

import com.java.qp_assessment.model.Grocery;
import com.java.qp_assessment.repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GroceryService {

    @Autowired
    private GroceryRepository repository;

    public List<Grocery> getAllItems() {
        return repository.findAll();
    }

    public Grocery addItem(Grocery item) {
        return repository.save(item);
    }

    public void removeItem(Long id) {
        repository.deleteById(id);
    }

    public Grocery updateItem(Long id, Grocery grocery) {
        Grocery item = repository.findById(id).orElseThrow();
        item.setName(grocery.getName());
        item.setPrice(grocery.getPrice());
        item.setQuantity(grocery.getQuantity());
        return repository.save(item);
    }


}
