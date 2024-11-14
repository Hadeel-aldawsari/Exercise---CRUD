package com.example.exercisebankcrud.Controller;


import com.example.exercisebankcrud.ApiResponse.ApiResponse;
import com.example.exercisebankcrud.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    ArrayList<Customer> customers=new ArrayList<>();


@GetMapping("/get-all")
    public ArrayList<Customer> getCustomers() {
        return customers;
    }


    @PostMapping("/add")
    public ApiResponse addCustomer(@RequestBody Customer customer){
    customers.add(customer);
    return new ApiResponse("Customer added successfully");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateCustomer(@RequestBody Customer customer,@PathVariable int index){
    if(index>customers.size())return new ApiResponse("Customer index out of bounds");
    customers.set(index,customer);
    return new ApiResponse("Customer updated successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteCustomer(@PathVariable int index){
    if(index>customers.size())return new ApiResponse("Customer index out of bounds");
    customers.remove(index);
    return new ApiResponse("Customer deleted successfully");
    }

    @PutMapping("/deposit/{index}/{amount}")
    public ApiResponse deposit(@PathVariable int index,@PathVariable double amount){
    customers.get(index).setBalance(customers.get(index).getBalance()+amount);
    return new ApiResponse("Customer deposit successfully");
    }

    @PutMapping("/withdraw/{index}/{amount}")
    public ApiResponse withdraw(@PathVariable int index,@PathVariable double amount){
    if(amount>customers.get(index).getBalance())return new ApiResponse("Sorry amount is greater than balance, withdraw filed");

    customers.get(index).setBalance(customers.get(index).getBalance()-amount);
    return new ApiResponse("Customer withdraw successfully");
    }

}
