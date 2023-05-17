package com.ecommerce.backend.controllers;

import com.ecommerce.backend.entities.Invoice;
import com.ecommerce.backend.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/invoices")
@PreAuthorize("hasRole('ADMIN')")
public class InvoiceController {

    @Autowired
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return invoiceService.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return invoiceService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Invoice invoice){
        return invoiceService.save(invoice);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return invoiceService.deleteById(id);
    }

}
