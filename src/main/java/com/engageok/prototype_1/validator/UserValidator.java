package com.engageok.prototype_1.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.engageok.prototype_1.models.User;

@Component

public class UserValidator implements Validator{

	@Override

	public boolean supports(Class<?> clazz) {

		return User.class.equals(clazz);

	}

	@Override

    public void validate(Object object, Errors errors) {

        User user = (User) object;

        

        if (!user.getPasswordConfirmation().equals(user.getPassword())) {

            // 3

            errors.rejectValue("passwordConfirmation", "Match");

        } 

    }

}


