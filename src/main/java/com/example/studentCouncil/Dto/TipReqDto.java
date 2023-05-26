package com.example.studentCouncil.Dto;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class TipReqDto {
    private MultipartFile name;
    private String category;
    private String tipsDescription;
    private Long consalt;
}
