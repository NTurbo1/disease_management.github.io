package com.turbo.disease_management.Controllers;

import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.turbo.disease_management.Dto.DoctorDto;
import com.turbo.disease_management.Dto.PublicServantDto;
import com.turbo.disease_management.Dto.SpecializeDto;
import com.turbo.disease_management.Dto.UserDto;
import com.turbo.disease_management.Entity.PublicServant;
import com.turbo.disease_management.Entity.User;
import com.turbo.disease_management.Service.DoctorService;
import com.turbo.disease_management.Service.PublicServantService;
import com.turbo.disease_management.Service.SpecializeService;
import com.turbo.disease_management.Service.UserService;

@Controller
public class AuthController {
    @Autowired
	private UserService userService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PublicServantService publicServantService;

    @Autowired
    private SpecializeService specializeService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // handler method to handle home page request
    @GetMapping("/")
    public String home(){
        return "home";
    }

    // handler method to handle login request
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDto user = new UserDto();
        // Doctor doctor = new Doctor();
        //String occupation = "";
        // PublicServant publicServant = new PublicServant();
        //Specialize specialize = new Specialize();
        model.addAttribute("user", user);
        // model.addAttribute("doctor", doctor);
        //model.addAttribute("occupation", occupation);
        // model.addAttribute("publicServant", publicServant);
        //model.addAttribute("specialize", specialize);
        return "register";
    }

    @GetMapping("/register/occupation")
    public String redirectBasedOnOccupation(@Valid @ModelAttribute("user") UserDto user,
                                            BindingResult result,
                                            Model model,
                                            @RequestParam(value="occupation", required = false)
                                            String occupation) {
        User existingUser = userService.findUserByEmail(user.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if (result.hasErrors()){
            model.addAttribute("user", user);
            return "/register";
        }

        if (occupation.equals("doctor")) {
            System.out.println("Heading to /register/doctor");
            System.out.println("USER PASSWORD " + user.getPassword());
            return "redirect:/register/doctor?name=" + user.getName() +
                                              "&surname=" + user.getSurname() +
                                              "&email=" + user.getEmail() +
                                              "&phone=" + user.getPhone() +
                                              "&cname=" + user.getCname() +
                                              "&salary=" + user.getSalary() +
                                              "&password=" + user.getPassword();
        } else {
            return "redirect:/register/publicServant?name=" + user.getName() +
                                              "&surname=" + user.getSurname() +
                                              "&email=" + user.getEmail() +
                                              "&phone=" + user.getPhone() +
                                              "&cname=" + user.getCname() +
                                              "&salary=" + user.getSalary() +
                                              "&password=" + user.getPassword();
        }
    }
    
    @GetMapping("/register/doctor")
    public String doctorRegistration(@RequestParam(value="name", required=false) String name,
                                     @RequestParam(value="surname", required=false) String surname,
                                     @RequestParam(value="email", required=false) String email,
                                     @RequestParam(value="phone", required=false) String phone,
                                     @RequestParam(value="cname", required=false) String cname,
                                     @RequestParam(value="salary", required=false) BigInteger salary,
                                     @RequestParam(value="password", required=false) String password, 
                                     Model model) {

        SpecializeDto specialize = new SpecializeDto();
        DoctorDto doctor = new DoctorDto();
        UserDto user = new UserDto();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setCname(cname);
        user.setSalary(salary);
        user.setPassword(password);

        System.out.println("In /register/doctor");
        model.addAttribute("doctor", doctor);
        model.addAttribute("specialize", specialize);
        model.addAttribute("user", user);
        return "register_doctor";
    }

    @PostMapping("/register/doctor/save")
    public String saveDoctor(@ModelAttribute("doctor") DoctorDto doctor,
                             @ModelAttribute("specialize") SpecializeDto specialize,
                             @RequestParam(value="name", required=false) String name,
                             @RequestParam(value="surname", required=false) String surname,
                             @RequestParam(value="email", required=false) String email,
                             @RequestParam(value="phone", required=false) String phone,
                             @RequestParam(value="cname", required=false) String cname,
                             @RequestParam(value="salary", required=false) BigInteger salary,
                             @RequestParam(value="password", required=false) String password){

        UserDto user = new UserDto();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setCname(cname);
        user.setSalary(salary);
        user.setPassword(password);

        doctor.setEmail(user.getEmail());
        specialize.setEmail(user.getEmail());
        userService.saveUser(user);
        doctorService.saveDoctor(doctor);
        specializeService.saveSpecialization(specialize);
        return "redirect:/register?success";
    }

    @GetMapping("/register/publicServant")
    public String publicServantRegistration(@RequestParam(value="name", required=false) String name,
                                            @RequestParam(value="surname", required=false) String surname,
                                            @RequestParam(value="email", required=false) String email,
                                            @RequestParam(value="phone", required=false) String phone,
                                            @RequestParam(value="cname", required=false) String cname,
                                            @RequestParam(value="salary", required=false) BigInteger salary,
                                            @RequestParam(value="password", required=false) String password,
                                            Model model) {

        PublicServant publicServant = new PublicServant();
        UserDto user = new UserDto();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setCname(cname);
        user.setSalary(salary);
        user.setPassword(password);
        
        model.addAttribute("publicServant", publicServant);
        model.addAttribute("user", user);
        return "register_public_servant";
    }
    
    @PostMapping("/register/publicServant/save")
    public String savePublicServant(@ModelAttribute("publicServant") PublicServantDto publicServant,
                                    @RequestParam(value="name", required=false) String name,
                                    @RequestParam(value="surname", required=false) String surname,
                                    @RequestParam(value="email", required=false) String email,
                                    @RequestParam(value="phone", required=false) String phone,
                                    @RequestParam(value="cname", required=false) String cname,
                                    @RequestParam(value="salary", required=false) BigInteger salary,
                                    @RequestParam(value="password", required=false) String password){

        UserDto user = new UserDto();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setCname(cname);
        user.setSalary(salary);
        user.setPassword(password);
        publicServant.setEmail(email);

        userService.saveUser(user);
        publicServantService.savePublicServant(publicServant);
        return "redirect:/register?success";
    }

    // handler method to handle list of users
    @GetMapping("/users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

}
