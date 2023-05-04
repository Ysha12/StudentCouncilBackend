//package com.example.demo.web;
//
//import com.example.demo.Service.Report_service;
//import com.example.demo.models.Report;
//import com.example.demo.models.User;
//import com.example.demo.web.api.ReportApi;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@Data
//public class ReportController implements ReportApi {
//    @Autowired
//    private final Report_service report_service;
//    @Override
//
//
//    public ResponseEntity addReport(Report r) {
//        return ResponseEntity.ok().body(report_service.addReport(r));
//    }
//}
