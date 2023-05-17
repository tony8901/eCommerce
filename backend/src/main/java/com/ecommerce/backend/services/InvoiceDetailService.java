package com.ecommerce.backend.services;

import com.ecommerce.backend.entities.InvoiceDetail;
import com.ecommerce.backend.repositories.InvoiceDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class InvoiceDetailService extends BasicServices<InvoiceDetail, Long>{

    public InvoiceDetailService(InvoiceDetailRepository invoiceDetailRepository){
        super(invoiceDetailRepository, "InvoiceDetail");
    }
}
