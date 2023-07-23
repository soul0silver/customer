package com.customer;

import com.customer.model.Student;
import com.customer.model.StudentDTO;
import com.customer.serrvice.customerServiceImp.FileSvImp;
import com.customer.serrvice.customerServiceImp.StudentServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/student",method = RequestMethod.POST)
public class StudentController {
    @Autowired
    StudentServiceImp serviceImp;
    @Autowired
    FileSvImp fileSvImp;
    @GetMapping("/home")
    public String getHome(Model model){
       ArrayList<StudentDTO> students = serviceImp.read();
       model.addAttribute("student",students);
        return "student/list";
    }
    @GetMapping("/reg")
    public String res(Model model){
        Student student=new Student();
        model.addAttribute("student",student);
        return "student/sign";
    }
    @PostMapping("/save")
    @Transactional
    public String save(@ModelAttribute @Valid Student s, @RequestParam("file")MultipartFile file, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "student/sign";

        fileSvImp.saveFile(file,serviceImp.create(s).getS_id());
        return "redirect:/student/home";
    }
    @GetMapping("/update/{id}")
    public String up(Model model , @PathVariable int id){
        Student student= serviceImp.findById(id);
        model.addAttribute("student",student);
        return "student/sign";}
    @GetMapping("/profile/{id}")
    public String profile(Model model , @PathVariable int id){
        Student student= serviceImp.findById(id);
        fileSvImp.findByUid(id);
        model.addAttribute("student",student);
        return "student/profile";}
}
