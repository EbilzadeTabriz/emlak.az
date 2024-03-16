package TK.example.emlak.az.controller;


import TK.example.emlak.az.dto.UserDto;
import TK.example.emlak.az.manager.UserManager;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Controller
public class UserController {
    private final UserManager userManager;

    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @GetMapping("/user")
    public String getAll(Model model) {
        List<UserDto> userDtoList = userManager.getAll();
        model.addAttribute("user", userDtoList);
        return "user";
    }

    @GetMapping("/user/new")
    public String newUser(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "create_user";
    }

    @PostMapping("/users")
    public String saveUser(@ModelAttribute("user") @Valid UserDto userDto) {
        userManager.saveInfo(userDto);
        return "redirect:/user";

    }

//    @PutMapping("/saveAll")
//    public ResponseEntity<String> saveAll(@RequestBody List<UserDto> userDto, UriComponentsBuilder uriComponentsBuilder) {
//        userManager.saveAll(userDto);
//        String responseMessage = "Users were saved successfully";
//        URI location = uriComponentsBuilder.path("/saveAll").build().toUri();
//        return ResponseEntity.created(location).body(responseMessage);
//
//    }

    @PutMapping("/saveInfo")
    public String saveInfo(@RequestBody UserDto userDto) {
        userManager.saveInfo(userDto);
        return "successful";
    }

    @GetMapping("/user/{id}/edit")
    public String editUser(@PathVariable("id") Long id,
                           Model model) {
        UserDto userDto = userManager.getById(id);
        model.addAttribute("user", userDto);
        return "edit_user";

    }

    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable("id") Long id,
                             @ModelAttribute("user")@Valid UserDto userDto,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "edit_user";
        }
        userDto.setId(id);
        userManager.update(userDto);
        return "redirect:/user";
    }

    @GetMapping("user/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userManager.deleteById(id);
        return "redirect:/user";
    }
    @GetMapping("/user/{id}/view")
    public String viewUser(@PathVariable("id") Long id,
                           Model model){
        UserDto userDto  = userManager.getById(id);
        model.addAttribute("user",userDto);
        return "view_user";
    }

    @PostMapping("updated/{id}")
    public ResponseEntity<String> update(@RequestBody UserDto userDto, @PathVariable("id") Long id, UriComponentsBuilder uriComponentsBuilder) {

        userDto.setId(id);
        userManager.update(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("User updated successfully!");


    }

    @PutMapping("/updateAll/{id}")
    public ResponseEntity<String> updateAll(@RequestBody List<UserDto> userDtoList, @PathVariable("id") Long id) {
        userManager.updateAll(userDtoList, id);
        return ResponseEntity.status(HttpStatus.CREATED).body("All info were updated!");

    }

    @PutMapping("/updateAndSave/{id}")
    public ResponseEntity<String> updateAndSave(@RequestBody UserDto userDto, @PathVariable("id") Long id) {
        userManager.updateAndSave(userDto, id);
        String message = "Info were both updated and saved!";
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        userManager.deleteById(id);
        String message = "Info was deleted!";
        return ResponseEntity.ok(message);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAll() {
        userManager.deleteAll();
        String message = "All info were deleted!";
        return ResponseEntity.ok(message);
    }

    @PatchMapping("/existsByEmail/{email}")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable("email") String email) {

        Boolean exist = userManager.existsByEmail(email);
        System.out.println("Received email: " + exist);
        return ResponseEntity.ok(exist);

    }

    @PatchMapping("/existsById/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable("id") Long id) {
        Boolean exists = userManager.existsById(id);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        Long count = userManager.count();
        return ResponseEntity.ok(count);

    }

    @GetMapping("/sort")
    public ResponseEntity<List<UserDto>> getAllSortedByName() {
        List<UserDto> userDtoList = userManager.getAllSortedByName();

        if (userDtoList != null && !userDtoList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(userDtoList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }

    }

}

