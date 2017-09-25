package com.ityun.mc.web;

import com.ityun.mc.core.Result;
import com.ityun.mc.core.ResultGenerator;
import com.ityun.mc.model.User;
import com.ityun.mc.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2017/09/25.
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;

	@PostMapping("/add")
	public Result add(User user) {
		userService.save(user);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		userService.deleteById(id);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/update")
	public Result update(User user) {
		userService.update(user);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		User user = userService.findById(id);
		return ResultGenerator.genSuccessResult(user);
	}

	@PostMapping("/login")
	public Result login(@RequestParam String loginName, @RequestParam String loginPassword) {
		User user = userService.findBy("username", loginName);
		if(user!=null&&user.getPassword().equals(loginPassword))
		{
			return  ResultGenerator.genSuccessResult();
		}
		return ResultGenerator.genFailResult("用户名或密码错误");
	}

	// @PostMapping("/list")
	@GetMapping("/list")
	public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		List<User> list = userService.findAll();
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}
}
