//package com.example.studentCouncil.Controller;
//
//import com.example.studentCouncil.Controller.Api.CategoryApi;
//import com.example.studentCouncil.Dto.CategoryReqDto;
//import com.example.studentCouncil.Services.CategoryService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class CategoryController implements CategoryApi {
//    private CategoryService categoryService;
//    public CategoryController (CategoryService categoryService) {
//        this.categoryService=categoryService;
//    }
//    public ResponseEntity getAllCategory(int page, int size){
//        return ResponseEntity.ok().body(categoryService.getAllCategory(page,size));
//    }
//    public ResponseEntity addNewCategory(CategoryReqDto categoryReqDto) {
//
////        return ResponseEntity.ok().body(categoryService.addNewCategory(categoryReqDto));
//    }
//    public ResponseEntity editLoan(Long ID, CategoryReqDto categoryReqDto) {
//        return  ResponseEntity.ok().body(categoryService.editCategory(ID, categoryReqDto));
//    }
//    public ResponseEntity deleteCategory(Long catID){
//
//        return ResponseEntity.ok().body(categoryService.deleteCategory(catID));
//    }
//}
