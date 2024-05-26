package TK.example.emlak.az.controller;

import TK.example.emlak.az.dto.UserDto;
import TK.example.emlak.az.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private final UserManager manager;

    public UserController(UserManager manager) {
        this.manager = manager;
    }

    @GetMapping("/users")
    public String getAll(Model model) {
        List<UserDto> userDto = manager.getAll();
        model.addAttribute("userDto", userDto);
        return "user-index";
    }

    @GetMapping("user/{userId}/delete")
    public String deleteUserById(@PathVariable("userId") Long id) {
        manager.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("user/new")
    public String createUser(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "user-new";
    }

    @PostMapping("/users")
    public String saveUser(@ModelAttribute("user") @Validated UserDto userDto, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userDto);
            return "user-new";
        }
        manager.saveInfo(userDto);
        return "redirect:/users";
    }

    @GetMapping("/users/home")
    public String userHome() {
        return "redirect:/users";
    }

    @GetMapping("user/{userId}/edit")
    public String editUser(@PathVariable("userId") Long id, Model model) {
        UserDto userDto = manager.getById(id);
        model.addAttribute("userDto", userDto);
        return "edit-user";
    }

    @PostMapping("user/{userId}")
    public String updateUser(@PathVariable("userId") Long id,
                             @ModelAttribute("userDto") @Validated UserDto userDto,
                             BindingResult bindingResult,
                             Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "edit-user";
        }
        manager.updateAndSave(userDto,id);
        return "redirect:/users";
    }

    @GetMapping("user/{userId}/view")
    public String userView(@PathVariable("userId") Long id, Model model) {
        UserDto userDto = manager.getById(id);
        model.addAttribute("userDto", userDto);
        return "user-view";
    }
}
