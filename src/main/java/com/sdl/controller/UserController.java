package com.sdl.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.sdl.model.Description;
import com.sdl.model.Pet;
import com.sdl.service.UserService;
import com.sdl.utils.Coverimage;
import com.sdl.utils.SelectUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Resource
    public UserService userService;
    @RequestMapping("/toaddPet")
    public String toaddPet(int userid, Model model){
        model.addAttribute("petUserid",userid);
        return "/user/addPet";
    }
    @RequestMapping("/addPet")
    public String addPet(Pet pet, @RequestParam(value = "petimage",required = false) MultipartFile petimage) throws IOException {
        System.out.println("pet==========>>>"+pet);
        byte []uppetimage = petimage.getBytes();
        pet.setPetimage(uppetimage);
        System.out.println("pet后==========>>>"+pet);
        userService.addPet(pet);
        return "success";
    }
    @RequestMapping("/findAllPet")
    public String findAllPet(int petuserid,HttpServletRequest request, @RequestParam(value = "pageNum",
            defaultValue = "1",required = false) int pagegNum, Model model) throws IOException {

        String path = request.getSession().getServletContext().getRealPath("/upload/image/");
        PageHelper.startPage(pagegNum,3);
        List<Pet> petList = userService.findAllPet(petuserid);
        System.out.println("pet后==========>>>"+petList);
        for(Pet pet:petList){
            String imageUrl = new Coverimage().outimage(pet.getPetimage(),path);
            pet.setPetimage(imageUrl);
        }
        System.out.println("pet后==========>>>"+petList);
        PageInfo<Pet> pageInfo = new PageInfo<Pet>(petList);
        model.addAttribute("pageInfo",pageInfo);
        return "/user/allPetlist";
    }
    @RequestMapping("/deltePet")
    public String deltePet(int petid,int petuserid,Model model){
        userService.deltePet(petid);
        model.addAttribute("petuserid",petuserid);
        return "redirect:/findAllPet";
    }
    @RequestMapping("/toUpdataPetInfo")
    public String toUpdataPetInfo(HttpServletRequest request,int petid,Model model) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/upload/image/");
        Pet pet = userService.findaPet(petid);
        pet.setPetimage(new Coverimage().outimage(pet.getPetimage(),path));
        model.addAttribute("APet",pet);
        return "/user/updataPetInfo";
    }
    @RequestMapping("/updataPetInfo")
    public String updataPetInfo(Pet pet,@RequestParam(value = "petimage",required = false) MultipartFile petimage,Model model) throws IOException {
        byte[] image = petimage.getBytes();
        if (image.length>0){
            pet.setPetimage(image);
        }else {
            pet.setPetimage(null);
        }
        userService.updataPetInfo(pet);
        System.out.println("修改weiPetInfo"+pet);
        model.addAttribute("petid",pet.getPetid());
        return "redirect:/toUpdataPetInfo";
    }
    @RequestMapping("/todescript")
    public String todescript(int userid,Model model){
        System.out.println("useridssssss"+userid);
        List<Pet> petList = userService.findAllPet(userid);
        System.out.println("选择列表为"+petList);
        List<SelectUtil> selectUtils = new ArrayList<SelectUtil>();
        for(Pet pet : petList){
            System.out.println("迷茫"+pet.getPetname());
            SelectUtil selectUtil = new SelectUtil(pet.getPetname(),pet.getPetid());
            selectUtils.add(selectUtil);
        }
        Gson gson = new Gson();
        JsonElement selectPet = gson.toJsonTree(selectUtils);
        System.out.println("选择列表为"+selectPet);
        model.addAttribute("selectPet",selectPet);
        return "/user/descriptForm";
    }
    @RequestMapping("/descript")
    public String descript(Description description,Model model){
        description.setPetname(userService.findaPet(description.getPetid()).getPetname());
        System.out.println("挂号单信息"+description);
        userService.newDescription(description);
        model.addAttribute("userid",description.getUserid());
        return "redirect:/descripted";
    }
    @RequestMapping("/descripted")
    public String descripted(int userid,@RequestParam(value = "pageNum",
            defaultValue = "1",required = false) int pagegNum, Model model){
        PageHelper.startPage(pagegNum,6);
        List<Description> descriptionList = userService.findAllDescription(userid);
        PageInfo<Description> pageInfo = new PageInfo<Description>(descriptionList);
        System.out.println("挂号单信息"+pageInfo);
        model.addAttribute("pageInfo",pageInfo);
        return "/user/descripted";
    }
    @RequestMapping("/delDescription")
    public String delDescription(int did,int userid,Model model){
        userService.delDescription(did);
        model.addAttribute("userid",userid);
        return "redirect:/descripted";
    }
    @RequestMapping("/resoved")
    public String resoved(int userid,@RequestParam(value = "pageNum",
            defaultValue = "1",required = false) int pagegNum, Model model){
        System.out.println("usrid========.>>>>"+userid);
        List<Description>  descriptionList = userService.findDescresoved(userid,1);
        PageHelper.startPage(pagegNum,6);
        PageInfo<Description> pageInfo = new PageInfo<Description>(descriptionList);
        model.addAttribute("pageInfo",pageInfo);
        return "/user/resovedList";
    }
}
