package com.kits.quanlybenhvien.web;


import com.kits.quanlybenhvien.entity.Doctor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/doctor")
public class DoctorController {
    private RestTemplate rest = new RestTemplate();
    @GetMapping()
    public String InformationDoctor(Model model){
        List<Doctor> doctors = Arrays.asList(rest.getForObject("http://localhost:8081/doctor",Doctor[].class));
        System.out.println(doctors);
        model.addAttribute("doctors",doctors);
        return "informationDoctor";
    }
    @GetMapping("/add")
    public String addDoctor(Model model){
        model.addAttribute("doctor", new Doctor());
        return "formAddDoctor";
    }

    @PostMapping()
    public String processDesign(@RequestParam(value = "id",required = false) String id , @RequestParam(value = "identity",required = false) String identity, @RequestParam(value = "name",required = false) String name, @RequestParam(value = "dob",required = false) Date dob , @RequestParam(value = "address",required = false) String address, @RequestParam(value = "exp",required = false) int exp,
                                @RequestParam(value = "diploma",required = false) String diploma , @RequestParam(value = "field",required = false) String field, @RequestParam(value = "position",required = false) String position) {
        Doctor doctor = new Doctor();
        doctor.setID_Doctor(id);
        doctor.setIdentityNumber(identity);
        doctor.setNameDoctor(name);
        doctor.setDOB(dob);
        doctor.setAddress(address);
        doctor.setExp(exp);
        doctor.setDiploma(diploma);
        doctor.setField(field);
        doctor.setPosition(position);
        log.info("New "+ doctor);
        rest.postForObject("http://localhost:8081/doctor", doctor, Doctor.class);
        return "redirect:/doctor";
    }

   /* @GetMapping("/delete/{id}")
    public String deleteIngredient(@PathVariable("id")String id, Model model) {
        rest.delete("http://localhost:8443/ingredients/delete/{id}",id);
        List<Ingredient> ingredients = Arrays.asList(rest.getForObject("http://localhost:8443/ingredients",Ingredient[].class));
        System.out.println(ingredients);
        model.addAttribute("ingredients",ingredients);
        return "informationIngredient";
    }

    @GetMapping("/edit/{id}")
    public String editIngredient(@PathVariable("id")String id,Model model){
        Ingredient ingredient = rest.getForObject("http://localhost:8443/ingredients/{id}",Ingredient.class,id);
        model.addAttribute("ingredient",ingredient);
        return "formAddIngredient";
    }
    @GetMapping("search")
    public String search(@RequestParam("id") String id,Model model){
        Ingredient ingredient = rest.getForObject("http://localhost:8443/ingredients/{id}",Ingredient.class,id);
        model.addAttribute("ingredients",ingredient);
        return "informationIngredient";
    }
*/

}

