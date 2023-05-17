package com.ecommerce.backend.controllers;

import com.ecommerce.backend.entities.Invoice;
import com.ecommerce.backend.entities.InvoiceDetail;
import com.ecommerce.backend.services.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/invoice-details")
@PreAuthorize("hasRole('ADMIN')")
public class InvoiceDetailController {

    @Autowired
    private final InvoiceDetailService invoiceDetailService;

    public InvoiceDetailController(InvoiceDetailService invoiceDetailService) {
        this.invoiceDetailService = invoiceDetailService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return invoiceDetailService.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return invoiceDetailService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody InvoiceDetail invoiceDetail){
        return invoiceDetailService.save(invoiceDetail);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return invoiceDetailService.deleteById(id);
    }

}
