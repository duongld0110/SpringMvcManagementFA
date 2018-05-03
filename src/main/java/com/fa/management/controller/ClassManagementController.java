package com.fa.management.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.management.dto.ClassbatchInfo;
import com.fa.management.dto.PaginationResult;
import com.fa.management.entity.Classadmin;
import com.fa.management.entity.Location;
import com.fa.management.service.ClassAdminService;
import com.fa.management.service.ClassBatchService;
import com.fa.management.service.LocationService;
import com.fa.management.validator.ClassBatchValidator;

@Controller
@Transactional
public class ClassManagementController {

	@Autowired
	private ClassBatchService classBatchService;

	@Autowired
	private LocationService locationService;

	@Autowired
	private ClassAdminService classAdminService;

	@Autowired
	private ClassBatchValidator ClassBatchValidator;

	@RequestMapping(value = {"/", "/login"})
	public String home(Model model, ClassbatchInfo classbatchInfo) {
		return "login";
	}

	@RequestMapping(value = { "/accountInfo" })
	public String accountInfo(Model model) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("userDetails", userDetails);
		return "accountInfo";
	}

	@RequestMapping(value = { "/classList", "/ClassManagement" })
	public String classList(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
		final int maxResult = 7;
		final int maxNavigationPage = 12;
		PaginationResult<ClassbatchInfo> result = classBatchService.listClassBatchInfo(page, maxResult,
				maxNavigationPage);

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String authorityRole = null;
		for (GrantedAuthority grantedAuthority : userDetails.getAuthorities()) {
			authorityRole = grantedAuthority.getAuthority();
		}
		model.addAttribute("authorityRole", authorityRole);
		model.addAttribute("classBatchInfoList", result);
		return "ClassList";
	}

	@RequestMapping(value = "/searchClass")
	public String searchClass(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "locationId", defaultValue = "1") int locationID,
			@RequestParam(value = "classCode", defaultValue = "") String classCode,
			@RequestParam(value = "expectedStartDate", defaultValue = "") String expectedStartDate,
			@RequestParam(value = "expectedEndDate", defaultValue = "") String expectedEndDate,
			@RequestParam(value = "status", defaultValue = "") String status) {
		final int maxResult = 7;
		final int maxNavigationPage = 12;
		PaginationResult<ClassbatchInfo> result = classBatchService.listClassBatchInfoForSearch(page, maxResult,
				maxNavigationPage, locationID, classCode, expectedStartDate, expectedEndDate, status);
		List<Location> locationList = locationService.getLocations();
		
		model.addAttribute("locationList", locationList);
		model.addAttribute("classBatchInfoList", result);
		return "ClassSearch";
	}


	@RequestMapping(value = "/viewClass")
	public String viewClassBatch(Model model, @RequestParam("id") int id,
			@RequestParam(value = "role", defaultValue = "ROLE_1") String role) {
		ClassbatchInfo classbatchInfo = null;
		if (id > 0) {
			classbatchInfo = classBatchService.findClassbatchInfoByID(id);
		}
		if (classbatchInfo == null) {
			return "redirect:/classList";
		}
		List<Location> locationList = locationService.getLocations();
		List<Classadmin> classAdminList = classAdminService.getAllClassAdmin();
		for (Classadmin classadmin : classAdminList) {
			if (classadmin.getClassAdminId() == classbatchInfo.getClassadminID()) {
				model.addAttribute("classAdminName", classadmin.getRemarks());
			}
		}
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String authorityRole = null;
		for (GrantedAuthority grantedAuthority : userDetails.getAuthorities()) {
			authorityRole = grantedAuthority.getAuthority();
		}
		if (role.equals(authorityRole)) {
			model.addAttribute("ROLE", role);
		}
		model.addAttribute("locationList", locationList);
		model.addAttribute("classAdminList", classAdminList);
		model.addAttribute("classbatchInfo", classbatchInfo);

		return "ClassBatchView";
	}

	@RequestMapping(value = "/deliveryManager/createNewClass")
	public String createClassBatch(Model model) {
		return this.formClassBatch(model, new ClassbatchInfo());
	}

	@RequestMapping(value = "/deliveryManager/editClass")
	public String editClassBatch(Model model, @RequestParam("id") int id) {
		ClassbatchInfo classbatchInfo = null;
		if (id > 0) {
			classbatchInfo = classBatchService.findClassbatchInfoByID(id);
		}
		if (classbatchInfo == null) {
			return "redirect:/classList";
		}
		return this.formClassBatch(model, classbatchInfo);
	}

	public String formClassBatch(Model model, ClassbatchInfo classbatchInfo) {
		List<Location> locationList = locationService.getLocations();
		List<Classadmin> classAdminList = classAdminService.getAllClassAdmin();
		model.addAttribute("locationList", locationList);
		model.addAttribute("classAdminList", classAdminList);
		model.addAttribute("formClassBatch", classbatchInfo);
		if (classbatchInfo.getClassId() <= 0) {
			model.addAttribute("formTitle", "Create Class");
			model.addAttribute("ButtonSubmit", "Create");
		} else {
			model.addAttribute("formTitle", "Edit Class");
			model.addAttribute("ButtonSubmit", "Update");
		}
		return "ClassManagement";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		Object target = binder.getTarget();
		if (target == null) {
			return;
		}
		if (target.getClass() == ClassbatchInfo.class) {
			binder.setValidator(ClassBatchValidator);
		}
		// SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		// sdf.setLenient(true);
		// binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping(value = "/deliveryManager/saveClassBatch", method = RequestMethod.POST)
	public String saveOrUpdateClassBatch(Model model, //
			@ModelAttribute("formClassBatch") @Validated ClassbatchInfo classbatchInfo, //
			BindingResult result) {
		if (result.hasErrors()) {
			return this.formClassBatch(model, classbatchInfo);
		}
		classBatchService.saveOrUpdateClassBatch(classbatchInfo);
		model.addAttribute("message", "Save Class Success");
		return this.formClassBatch(model, classbatchInfo);
	}

	@RequestMapping(value = "/403")
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			model.addAttribute("messageAccessDenied",
					"Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} 
		return "403Page";
	}

}
