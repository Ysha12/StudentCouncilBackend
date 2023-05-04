//package com.example.demo.Service;
//
//import com.example.demo.models.Report;
//import com.example.demo.models.User;
//import com.example.demo.repository.Report_repository;
//import lombok.Data;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//@Data
//public class Report_service {
//    private final Report_repository reportRepository;
//
//    public Report_service(Report_repository reportRepository) {
//        this.reportRepository = reportRepository;
//    }
//
//    public ResponseEntity addReport(Report r){
//        Report report = new Report();
//        report.setRepID(r.getRepID());
//        report.setDesc(r.getDesc());
//        report.setDate(r.getDate());
//        report.setID(r.getID());
//        reportRepository.save(r);
//
//        Map resp = new HashMap();
//        resp.put("resp",Boolean.TRUE);
//        return  ResponseEntity.ok().body(resp);
//    }
//}
