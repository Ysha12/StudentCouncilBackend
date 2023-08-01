//package com.example.studentCouncil.Services;
//
//import com.example.studentCouncil.Dto.CategoryReqDto;
//import com.example.studentCouncil.Dto.CategoryResDto;
//import com.example.studentCouncil.Dto.CourseReqDto;
//import com.example.studentCouncil.Dto.CourseResDto;
//import com.example.studentCouncil.Model.Category;
//import com.example.studentCouncil.Model.Course;
//import com.example.studentCouncil.Model.University;
//import com.example.studentCouncil.Repository.CategoryRepository;
//import com.example.studentCouncil.Repository.CourseRepository;
//import com.example.studentCouncil.Repository.UniversityRepository;
//import lombok.Data;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.*;
//
//@Data
//@Service
//public class CategoryService {
//    @Autowired
//    private CategoryRepository categoryRepository;
//    private final ModelMapper modelMapper;
//    private final CourseRepository courseRepository;
//
//    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper, CourseRepository courseRepository) {
//        this.categoryRepository = categoryRepository;
//        this.modelMapper = modelMapper;
//        this.courseRepository = courseRepository;
//    }
////    public ResponseEntity addNewCategory(CategoryReqDto categoryReqDto){
////        Optional<Course> u = courseRepository.findById(categoryReqDto.getCrsId());
////        if(!u.isPresent()){
////            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id"+"  "+categoryReqDto.getCrsId()+"   "+"does not exist");
////        }
////        Category category = modelMapper.map(categoryReqDto, Category.class);
////        Course course  = u.get();
////        category.setCourse(course);
////        courseRepository.save(course);
////
////        Map resp = new HashMap();
////        resp.put("resp",Boolean.TRUE);
////        return  ResponseEntity.ok().body(resp);
////    }
//    public List<Course> getAllCategory(int page, int size){
//        Pageable pageable = PageRequest.of(page,size);
//        CategoryResDto categoryResDto=null;
//        List list = new ArrayList();
//        for (Category category : categoryRepository.findAll(pageable)) {
//            categoryResDto = modelMapper.map(category, CategoryResDto.class);
//
//            list.add(categoryResDto);
//        }
//        return list;
//    }
//    public ResponseEntity editCategory(Long catID, CategoryReqDto categoryReqDto) throws ResponseStatusException {
//        Optional<Category> p = categoryRepository.findById(catID);
//        if(p.isPresent()){
//            Category category  = modelMapper.map(categoryReqDto,Category.class);
////            category.setCatID(catID);
//            categoryRepository.save(category);
//        }else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"");
//        }
//
//        Map response=new HashMap();
//        response.put("response",Boolean.TRUE);
//        return  ResponseEntity.ok().body(response);
//    }
//    public ResponseEntity deleteCategory(Long catID){
//        categoryRepository.deleteById(catID);
//
//        Map response=new HashMap();
//        response.put("response",Boolean.TRUE);
//        return  ResponseEntity.ok().body(response);
//    }
//}
