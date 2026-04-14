package com.beaconfire.crud_app.Controller;

import com.beaconfire.crud_app.DTO.request.CreateEmployee;
import com.beaconfire.crud_app.DTO.request.UpdateEmployee;
import com.beaconfire.crud_app.Entity.Employee;
import com.beaconfire.crud_app.Service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService es;

    @Autowired
    public void setEmployeeService(EmployeeService es) {this.es = es;}

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Integer id) {
        return es.findById(id);
    }

    @GetMapping
    public List<Employee> findAll() {
        return es.findAll();
    }

    @PostMapping
    public void create(@Valid @RequestBody CreateEmployee req) {
        es.create(req);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody UpdateEmployee ue) {
        es.update(id, ue);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        es.deleteById(id);
    }

    @GetMapping("/test")
    public String test() {
        log.info("进入controller");   // ⭐关键
        return "ok";
    }
}
