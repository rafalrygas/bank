package com.rafal.bank.controller;

import com.rafal.bank.model.User;
import com.rafal.bank.model.UserRole;
import com.rafal.bank.service.UserRoleService;
import com.rafal.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/secure/admin")
public class AdminHomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String adminPage(Model model) {
        return "menuAdmin";
    }

    // list page
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showAllUsers(Model model) {

        model.addAttribute("users", userService.findAll());
        return "list";

    }

    // show user
    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
    public String showUser(@PathVariable("username") String username, Model model) {

        User user = userService.getUserByUsername(username);
        if (user == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        }
        model.addAttribute("user", user);

        return "show";

    }

    // show update form
    @RequestMapping(value = "/users/{username}/update", method = RequestMethod.GET)
    public String showUpdateUserForm(@PathVariable("username") String username, Model model) {

        User user = userService.getUserByUsername(username);
        model.addAttribute("userForm", user);

        return "userform";

    }

    @RequestMapping(value = "/users/{username}/delete", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("username") String username,
                             final RedirectAttributes redirectAttributes) {
        System.out.println("User deleting");
        userService.delete(username);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "User is deleted!");

        return "redirect:/secure/admin/users";

    }

    // show add user form
    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String showAddUserForm(Model model) {
        User newUser = new User();
        model.addAttribute("userForm", newUser);
        return "userform";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated User user,
                                   BindingResult result, Model model,
                                   final RedirectAttributes redirectAttributes) {


        if (result.hasErrors()) {
            return "userform";
        } else {

            // Add message to flash scope
            redirectAttributes.addFlashAttribute("css", "success");
            if (user.isNew()) {
                redirectAttributes.addFlashAttribute("msg", "User added successfully!");
            } else {
                redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
            }

            System.out.println("Saving user");
            userService.saveOrUpdate(user);

            // POST/REDIRECT/GET
            return "redirect:/secure/admin/users/" + user.getUsername();

        }

    }

    // show update form
    @RequestMapping(value = "/users/{username}/roles", method = RequestMethod.GET)
    public String showEditUserRoleForm(@PathVariable("username") String username, Model model) {

        User user = userService.getUserByUsername(username);
        Set<UserRole> userRoles = user.getUserRole();
        model.addAttribute("userRoles", userRoles);
        model.addAttribute("user", user.getUsername());
        return "userRoleForm";

    }

    @RequestMapping(value = "users/{username}/roles/add", method = RequestMethod.GET)
    public String showAddUserRoleForm(@PathVariable("username") String username, Model model) {

        List<String> list = new ArrayList<String>();
        list.add("ROLE_ADMIN");
        list.add("ROLE_USER");
        UserRole userRole = new UserRole();
        User user = userService.getUserByUsername(username);
        model.addAttribute("username", username);
        model.addAttribute("list", list);
        model.addAttribute("userRole", userRole);
        return "addUserRoleForm";

    }

    @RequestMapping(value = "users/{username}/roles/add", method = RequestMethod.POST)
    public String addUserRole(@PathVariable("username") String username, @ModelAttribute("userRole") @Validated UserRole userRole,
                                   BindingResult result, Model model,
                                   final RedirectAttributes redirectAttributes) {
        User user = userService.getUserByUsername(username);
        user.getUserRole().add(new UserRole(user, userRole.getRole()));
        userService.saveOrUpdate(user);
        return "redirect:/secure/admin/users/" + user.getUsername();
    }


    @RequestMapping(value = "/users/{username}/roles/{userRoleId}/delete", method = RequestMethod.GET)
    public String deleteUserRole(@PathVariable("username") String username, @PathVariable("userRoleId") int userRoleId,
                             final RedirectAttributes redirectAttributes) {

        userRoleService.delete(userRoleId);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "UserRole is deleted!");

        return "redirect:/secure/admin/users/{username}/roles";

    }
}
