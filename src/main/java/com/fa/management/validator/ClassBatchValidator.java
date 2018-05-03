package com.fa.management.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.fa.management.dto.ClassbatchInfo;

@Component
public class ClassBatchValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return clazz == ClassbatchInfo.class;
	}

	public void validate(Object target, Errors errors) {
		ClassbatchInfo classbatchInfo = (ClassbatchInfo) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "className", "Notempty.formClassBatch.className");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "classCode", "Notempty.formClassBatch.classCode");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expectedStartDate", "Notempty.formClassBatch.expectedStartDate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expectedEndDate", "Notempty.formClassBatch.expectedEndDate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "detailLocation", "Notempty.formClassBatch.detailLocation");
		
		if (classbatchInfo.getClassName().length() >= 30) {
			errors.reject("className", "Pattern.formClassBatch.className");
		}
	}

}
