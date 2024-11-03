package com.java.qp_assessment.controller;

import com.java.qp_assessment.model.Grocery;
import com.java.qp_assessment.model.Order;
import com.java.qp_assessment.service.GroceryService;
import com.java.qp_assessment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grocery")
public class GroceryController {

    @Autowired
    private GroceryService groceryService;

    @Autowired
    private OrderService orderService;

   // place user order
/*    {
          "userId": 1,
          "groceryIds": [1, 2, 4] // IDs of the grocery items being ordered
      }  */
   @PostMapping("/placeOrder")
   public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        Order savedOrder = orderService.placeOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

    @GetMapping("orders")  // get all user orders
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }


    @GetMapping
    public List<Grocery> getAllItems() {
        return groceryService.getAllItems();
    }


     // Add item to the system Admin access
     /*    {
        "name": "apple",
        "price": 20,
        "quantity": 80
        }
      */
     @PostMapping("/admin/addItem")
     public Grocery addItem(@RequestBody Grocery grocery) {
        return groceryService.addItem(grocery);
    }

    @DeleteMapping("/admin/{id}") // Only Admin can access
    public ResponseEntity<Void> removeItem(@PathVariable Long id) {
        groceryService.removeItem(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/admin/{id}") // Only Admin can access
    public Grocery updateItem(@PathVariable Long id, @RequestBody Grocery grocery) {
        return groceryService.updateItem(id, grocery);
    }
}
