package com.ecommerce.backend.services;

import com.ecommerce.backend.entities.Invoice;
import com.ecommerce.backend.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService extends BasicServices<Invoice, Long>{

    public InvoiceService(InvoiceRepository invoiceRepository){
        super(invoiceRepository, "Invoice");
    }
}
