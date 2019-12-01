package com.sdl.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdl.model.Drug;
import com.sdl.model.SUserInfo;
import com.sdl.model.User;
import com.sdl.model.UserInfo;
import com.sdl.service.AdminService;
import com.sdl.utils.Coverimage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Resource
    AdminService adminService;
    @RequestMapping("/userInfo")
    public String userInfo(UserInfo userInfo, Model model){
        System.out.println("UserID=========>>>>>>>"+userInfo.getUserid());
        userInfo = adminService.getInfoByID(userInfo.getUserid());
        System.out.println("UserInfo=========>>>>>>>"+userInfo);
        model.addAttribute("LoginUserInfo",userInfo);
        return "/admin/admin_info";
    }
    @RequestMapping(value = "/updateUserInfo",method = {RequestMethod.POST})
    public String updateUserInfo(UserInfo userInfo,Model model){
        System.out.println("修改UserInfo=========>>>>>>>"+userInfo);
        int userid = userInfo.getUserid();
        int flag = adminService.updateUserInfo(userInfo);
        System.out.println("修改状态=========>>>>>>>"+flag);
       // model.addAttribute("msg","修改成功！");
        return "redirect:/userInfo?userid="+userid+"";
    }
    @RequestMapping(value = "/updateUserPassword",method = {RequestMethod.POST})
    public String updateUserPassword(User user,Model model){
        System.out.println("修改UserPassword=========>>>>>>>"+user);
        int flag = adminService.updateUserPassword(user);
        System.out.println("修改状态=========>>>>>>>"+flag);
        return "login";
    }
    @RequestMapping("/findAllUserInfo")
    public String findAllUserInfo(@RequestParam(value = "usertype",defaultValue = "admin") String usertype,
                                  @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pagegNum,
                                  Model model){
        System.out.println("状态=========>>>>>>>"+usertype);
        model.addAttribute("nowusertype",usertype);
        PageHelper.startPage(pagegNum,6);
        List<SUserInfo> list = adminService.findAllUserInfo(usertype);
        PageInfo<SUserInfo> page = new PageInfo<SUserInfo>(list);
        System.out.println("总数量：" + page.getTotal());
        System.out.println("当前页查询记录：" + page.getList().size());
        System.out.println("当前页码：" + page.getPageNum());
        System.out.println("每页显示数量：" + page.getPageSize());
        System.out.println("总页：" + page.getPages());
        model.addAttribute("pageInfo",page);
        return "/admin/userlist";
    }
    @RequestMapping("/delUser")
    public String delUser(@RequestParam(value = "userid") int userid){
        int flag = adminService.delUserbyId(userid);
        System.out.println("删除状态=========>>>>>>>"+flag);
        return "redirect:/findAllUserInfo";
    }
    @RequestMapping("/toaddUser")
    public String toaddUser(@RequestParam String usertype,Model model){
        System.out.println("添加的用户类型=========>>>>>>>"+usertype);
        model.addAttribute("addusertype",usertype);
        return "/admin/addUser";
    }
    @RequestMapping("/addUser")
    public String addUser(SUserInfo sUserInfo){
        System.out.println("添加状态=========>>>>>>>"+sUserInfo);
        User user = new User(sUserInfo.getUserId(),sUserInfo.getUserType(),sUserInfo.getUserName(),sUserInfo.getUserPassword());
        UserInfo userInfo = new UserInfo(sUserInfo.getUserSex(),sUserInfo.
                getUserTel(),sUserInfo.getUserQQ(),sUserInfo.getUserNote(),sUserInfo.getUserId());
        adminService.addUser(user);
        int flag = adminService.addUserInfo(userInfo);
        System.out.println("添加状态=========>>>>>>>"+flag);
        return "/admin/addUser";
    }
    @RequestMapping("toaddDrug")
    public String toaddDrug(){
        return "/admin/addDrug";
    }
    @RequestMapping("addDrug")
    public String addDrug(Drug drug, @RequestParam(value = "gimage",required = false) MultipartFile gimage, ModelMap modelMap) throws IOException, SQLException {
        byte []upimage = gimage.getBytes();
        drug.setGimage(upimage);
        System.out.println("添加的药品=========>>>>>>>"+drug);
        adminService.addDrugInfo(drug);
        return "/admin/success";
    }
    @RequestMapping("/findDrug")
    public String findDrug(int gid,HttpServletRequest request,Model model) throws IOException, SQLException {
        String path = request.getSession().getServletContext().getRealPath("/upload/image/");
        System.out.println("查找药品ID=========>>>>id>>>"+gid);
        Drug drug = adminService.findDrug(gid);
        System.out.println("找到药品=========>>>>id>>>"+drug);
        System.out.println("地址=========>>>>id>>>"+path);
        Coverimage image = new Coverimage();
        String getimageUlr = image.outimage(drug.getGimage(),path);
        System.out.println("图片地址=========>>>>id>>>"+getimageUlr);
      //  request.getSession().setAttribute("getimage",getimage);
        model.addAttribute("getimage",getimageUlr);
        return"/admin/success";
    }
    @RequestMapping("/findAllDrug")
    public String findAllDrug(HttpServletRequest request,@RequestParam(value = "pageNum",
            defaultValue = "1",required = false) int pagegNum,Model model) throws IOException {

        String path = request.getSession().getServletContext().getRealPath("/upload/image/");
        PageHelper.startPage(pagegNum,3);
        List<Drug> drugList = adminService.finaAllDrug();
        System.out.println("替换前=========>>>>"+drugList);
        for(Drug drug:drugList){
            String imageUrl = new Coverimage().outimage(drug.getGimage(),path);
            drug.setGimage(imageUrl);

        }
        System.out.println("替换后=========>>>>"+drugList);
       PageInfo<Drug> pageInfo = new PageInfo<Drug>(drugList);
       model.addAttribute("pageInfo",pageInfo);
        return "/admin/allDruglist";
    }
}
