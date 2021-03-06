package br.com.homework.digitalinnovation.personapi.utils;


import br.com.homework.digitalinnovation.personapi.dto.request.PhoneDTO;
import br.com.homework.digitalinnovation.personapi.entity.Phone;
import br.com.homework.digitalinnovation.personapi.enums.PhoneType;

public class PhoneUtils {
	
	private static final String PHONE_NUMBER = "11999999999";
	private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
	private static final Long PHONE_ID = 1L;
	
	public static PhoneDTO createFakeDTO() {
		return PhoneDTO.builder().number(PHONE_NUMBER).type(PHONE_TYPE)
					.build();
	}
	
	public static Phone createFakeEntity() {
		return Phone.builder().id(PHONE_ID).number(PHONE_NUMBER).type(PHONE_TYPE)
					.build();
	}
}
