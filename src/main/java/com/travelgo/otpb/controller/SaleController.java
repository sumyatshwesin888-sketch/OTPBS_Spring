package com.travelgo.otpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelgo.otpb.dto.ProductDto;
import com.travelgo.otpb.dto.SaleDto;
import com.travelgo.otpb.service.SaleService;

@RestController
@RequestMapping("/api/v1/")
public class SaleController {

    @Autowired
    SaleService saleService;

    @GetMapping("sale")

    public List<SaleDto> getSale(
    		@RequestParam(name="status",defaultValue = "All")String status) {

    	 try {
             return saleService.getSale(status);
         } catch (Exception e) {
             e.printStackTrace();
             throw new RuntimeException("Get Sale Error!", e);
         }

    }

	
    @PostMapping("sale")
    public SaleDto addSale(
            @RequestBody SaleDto saleDto
    ){
    	 System.out.println("SALE DATA");
    	    System.out.println(saleDto);
        return saleService.addSale(saleDto);
    }
    @PutMapping("sale/{saleId}")
    public SaleDto updateSale(
            @PathVariable("saleId") int saleId,
            @RequestBody SaleDto dto) {

        try {

            dto.setSaleId(saleId);

            return saleService.updateSale(dto);

        } catch (Exception e) {

            throw new RuntimeException("Update Sale Error!", e);

        }

    }

    @DeleteMapping("sale/{saleId}")
    public int deleteSale(
            @PathVariable("saleId") int saleId) {

        try {

            return saleService.deleteSale(saleId);

        } catch (Exception e) {

            throw new RuntimeException("Delete Sale Error!", e);

        }

    }

}