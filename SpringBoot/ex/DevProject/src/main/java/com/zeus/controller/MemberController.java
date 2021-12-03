package com.zeus.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zeus.domain.Address;
import com.zeus.domain.Card;
import com.zeus.domain.FileMember;
import com.zeus.domain.Member;

import lombok.extern.java.Log;

@Log
@Controller
public class MemberController {
	
	@RequestMapping(value="/registerFileUpForm", method=RequestMethod.GET)
	public String registerFileUpForm() {
		log.info("registerFileUpForm");
		
		return "registerFileUpForm";
	}
	
	@RequestMapping(value="/registerFileUp01", method=RequestMethod.POST)
	public String registerFileUp01(MultipartFile picture) throws Exception{
		log.info("registerFileUp01");
		
		log.info("originalName: " + picture.getOriginalFilename());
		log.info("size: " + picture.getSize());
		log.info("contentType: " + picture.getContentType());
		
		return "success";
	}
	
	@RequestMapping(value="/registerFileUp02", method=RequestMethod.POST)
	public String registerFileUp02(String userId, String password, MultipartFile picture) throws Exception{
		log.info("registerFileUp02");
		
		log.info("userId = " + userId);
		log.info("password = " + password);
		
		log.info("originalName: " + picture.getOriginalFilename());
		log.info("size: " + picture.getSize());
		log.info("contentType: " + picture.getContentType());
		
		return "success";
	}
	
	@RequestMapping(value="/registerFileUp03", method=RequestMethod.POST)
	public String registerFileUp03(Member member, MultipartFile picture) throws Exception{
		log.info("registerFileUp03");
		
		log.info("userId = " + member.getUserId());
		log.info("password = " + member.getPassword());
		
		log.info("originalName: " + picture.getOriginalFilename());
		log.info("size: " + picture.getSize());
		log.info("contentType: " + picture.getContentType());
		
		return "success";
	}
	
	@RequestMapping(value="/registerFileUp04", method=RequestMethod.POST)
	public String registerFileUp04(FileMember fileMember) throws Exception{
		log.info("registerFileUp04");
		
		log.info("userId = " + fileMember.getUserId());
		log.info("password = " + fileMember.getPassword());
		
		MultipartFile picture = fileMember.getPicture();
		
		log.info("originalName: " + picture.getOriginalFilename());
		log.info("size: " + picture.getSize());
		log.info("contentType: " + picture.getContentType());
		
		return "success";
	}
	
	@RequestMapping(value="/registerFileUp05", method=RequestMethod.POST)
	public String registerFileUp05(MultipartFile picture, MultipartFile picture2) throws Exception{
		log.info("registerFileUp05");
		
		log.info("picture originalName: " + picture.getOriginalFilename());
		log.info("picture size: " + picture.getSize());
		log.info("contentType: " + picture.getContentType());
		
		log.info("originalName: " + picture.getOriginalFilename());
		log.info("size: " + picture.getSize());
		log.info("contentType: " + picture.getContentType());
		
		return "success";
	}
	
	/*  폼 양식 요청 처리 
	@RequestMapping(value="/registerAllForm", method=RequestMethod.GET)
	public  String registerAllForm() {
		log.info("registerAllForm");
		
		return "registerAllForm";
	}
	
	@RequestMapping(value="/registerForm", method=RequestMethod.GET)
	public  String registerForm() {
		log.info("registerForm");
		
		return "registerForm";
	}
	
	@RequestMapping(value="/registerMemberUserId", method=RequestMethod.POST)
	public  String registerUserId(Member member) {
		log.info("registerUserId");
		log.info("member.getUserId() = " + member.getUserId());
		
		return "success";
	}
	
	@RequestMapping(value="/registerUser", method=RequestMethod.POST)
	public  String registerUser(Member member) {
		log.info("registerUser");
		
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getGender() = " + member.getGender());
		log.info("member.getHobby() = " + member.getHobby());
		log.info("member.isForeigner() = " + member.isForeigner());
		log.info("member.getDeveloper() = " + member.getDeveloper());
		log.info("member.getBirthDate() = " + member.getDateOfBirth());
		log.info("member.getCars() = " + member.getCars());
		log.info("member.getIntroduction() = " + member.getIntroduction());
		
		String[] hobbyArray = member.getHobbyArray();
		
		if(hobbyArray != null) {
			log.info("hobbyArray.length = " + hobbyArray.length);
			
			for(int i=0; i<hobbyArray.length; i++) {
				log.info("hobbyArray[" + i + "] = " + hobbyArray[i]);
			}
		}else {
			log.info("hobbyArray == null");
		}
		
		List<String> hobbyList = member.getHobbyList();
		
		if(hobbyList != null) {
			log.info("hobbyList.size() = " + hobbyList.size());
			
			for(int i=0; i<hobbyList.size(); i++) {
				log.info("hobbyList(" + i + ") = " + hobbyList.get(i));
			}
		}else {
			log.info("hobbyList == null");
		}
		
		Address address = member.getAddress();
		
		if(address != null) {
			log.info("address.getPostCode() = " + address.getPostCode());
			log.info("address.getLocation() = " + address.getLocation());	
		}else {
			log.info("address == null");
		}
		
		List<Card> cardList = member.getCardList();
		
		if(cardList != null) {
			log.info("cardList.size() = " + cardList.size());
	
			for(int i=0; i<cardList.size(); i++) {
				Card card = cardList.get(i);
				log.info("card.getNo() = " + card.getNo());
				log.info("card.getValidMonth() = " + card.getValidMonth());
			}
		}else {
			log.info("cardList == null");
		}
		
		String[] carArray = member.getCarArray();
		
		if(carArray != null) {
			log.info("carArray.length = " + carArray.length);
			
			for(int i=0; i<carArray.length; i++) {
				log.info("carArray[" + i + "] = " + carArray[i]);
			}
		}else {
			log.info("carArray == null");
		}
		
		List<String> carList = member.getCarList();
		
		if(carList != null) {
			log.info("carList.size() = " + carList.size());
		
			for(int i=0; i<carList.size(); i++) {
				log.info("hobbyList(" + i + ") = " + carList.get(i));
			}
		}else {
			log.info("carList == null");
		}
		
		return "success";
	}
	
	@RequestMapping(value="/registerUserId", method=RequestMethod.POST)
	public String registerUserId(String userId) {
		log.info("registerUserId");
		log.info("userId = " + userId);
		
		return "success";
	}
	
	@RequestMapping(value="/registerPassword", method=RequestMethod.POST)
	public String registerPassword(String password) {
		log.info("registerPassword");
		log.info("password = " + password);
		
		return "success";
	}

	@RequestMapping(value="/registerTextArea", method=RequestMethod.POST)
	public String registerTextArea(String introduction) {
		log.info("registerTextArea");
		log.info("introduction = " + introduction);
		
		return "success";
	}
	
	@RequestMapping(value="/registerRadio", method=RequestMethod.POST)
	public String registerRadio(String gender) {
		log.info("registerRadio");
		log.info("gender = " + gender);
		
		return "success";
	}
	
	@RequestMapping(value="/registerCheckbox01", method=RequestMethod.POST)
	public String registerCheckbox01(String hobby) {
		log.info("registerCheckbox01");
		log.info("hobby = " + hobby);
		
		return "success";
	}
	
	@RequestMapping(value="/registerCheckbox02", method=RequestMethod.POST)
	public String registerCheckbox02(String[] hobbyArray) {
		log.info("registerCheckbox02");
		
		if(hobbyArray != null) {
			log.info("hobbyArray.length = " + hobbyArray.length);
		
			for(int i=0; i<hobbyArray.length; i++) {
				log.info("hobbyArray[" + i + "] = " + hobbyArray[i]);
			}
		}
		else {
			log.info("hobbyArray == null");
		}
		
		return "success";
	}
	
	@RequestMapping(value="/registerCheckbox03", method=RequestMethod.POST)
	public String registerCheckbox03(String developer) {
		log.info("registerCheckbox03");
		log.info("developer = " + developer);
		
		return "success";
	}
	
	@RequestMapping(value="/registerCheckbox04", method=RequestMethod.POST)
	public String registerCheckbox04(boolean foreigner) {
		log.info("registerCheckbox04");
		log.info("foreigner = " + foreigner);
		
		return "success";
	}
	
	@RequestMapping(value="/registerSelect", method=RequestMethod.POST)
	public String registerSelect(String nationality){
		log.info("registerSelect");
		log.info("nationality = " + nationality);
		
		return "success";
	}
	
	@RequestMapping(value="/registerMultipleSelect01", method=RequestMethod.POST)
	public String registerMultipleSelect01(String cars){
		log.info("registerMultipleSelect01");
		log.info("cars = " + cars);
		
		return "success";
	}
	
	@RequestMapping(value="/registerMultipleSelect02", method=RequestMethod.POST)
	public String registerMultipleSelect02(String[] carArray){
		log.info("registerMultipleSelect02");
		
		if(carArray != null) {
			log.info("carArray.length = " + carArray.length);
			
			for(int i=0; i<carArray.length; i++) {
				log.info("carArray[" + i + "] = " + carArray[i]);
			}
		}else {
			log.info("carArray == null");
		}
		
		return "success";
	}
	
	@RequestMapping(value="/registerMultipleSelect03", method=RequestMethod.POST)
	public String registerMultipleSelect03(ArrayList<String> carList){
		log.info("registerMultipleSelect03");
		
		if(carList != null) {
			log.info("carList.size() = " + carList.size());
			
			for(int i=0; i<carList.size(); i++) {
				log.info("carList[" + i + "] = " + carList.get(i));
			}
		}else {
			log.info("carList == null");
		}
		
		return "success";
	}
	
	@RequestMapping(value="/registerAddress", method=RequestMethod.POST)
	public String registerAddress(Address address){
		log.info("registerAddress");
		
		if(address != null) {
			log.info("address.getPostCode() = " + address.getPostCode());
			log.info("address.getLocation() = " + address.getLocation());
		}else {
			log.info("address == null");
		}
		
		return "success";
	}
	
	@RequestMapping(value="/registerUserAddress", method=RequestMethod.POST)
	public String registerUserAddress(Member member){
		log.info("registerUserAddress");
		
		Address address = member.getAddress();
		
		if(address != null) {
			log.info("address.getPostCode() = " + address.getPostCode());
			log.info("address.getLocation() = " + address.getLocation());
		}else {
			log.info("address == null");
		}
		
		return "success";
	}
	
	@RequestMapping(value="/registerUserCardList", method=RequestMethod.POST)
	public String registerUserCardList(Member member){
		log.info("registerUserCardList");
		
		List<Card> cardList = member.getCardList();
		
		if(cardList != null) {
			log.info("cardList.size() = " + cardList.size());
			
			for(int i=0; i<cardList.size(); i++) {
				Card card = cardList.get(i);
				log.info("card.getNo() = " + card.getNo());
				log.info("card.getValidMonth() = " + card.getValidMonth());
			}
		}else {
			log.info("cardList == null");
		}
		
		return "success";
	}
	
	@RequestMapping(value="/registerDate01", method=RequestMethod.POST)
	public String registerDate01(@DateTimeFormat(pattern="yyyyMMdd")Date dateOfBirth){
		log.info("registerDate01");
		
		if(dateOfBirth != null) {
			log.info("dateOfBirth = " + dateOfBirth);
		}else {
			log.info("dateOfBirth == null");
		}
		
		return "success";
	} 
 
	 * */
	
	/* @DateTimeFormat 애너테이션 처리
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(Member member) {
		log.info("register");
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getPassword() = " + member.getPassword());
		log.info("member.getDateOfBirth() = " + member.getDateOfBirth());
		return "success";
	}
	
	@RequestMapping(value="/registerByDateFormat", method=RequestMethod.GET)
	public String registerByDateFormat(String userId, @DateTimeFormat(pattern="yyyyMMdd") Date dateOfBirth) {
		log.info("registerByDateFormat");
		log.info("userId() = " + userId);
		log.info("dateOfBirth() = " + dateOfBirth);
		return "success";
	}
	
	@RequestMapping(value="/registerByDateFormat01", method=RequestMethod.GET)
	public String registerByDateFormat01(String userId, @DateTimeFormat(pattern="yyyy-MM-dd") Date dateOfBirth) {
		log.info("registerByDateFormat01");
		log.info("userId() = " + userId);
		log.info("dateOfBirth() = " + dateOfBirth);
		return "success";
	}
	
	@RequestMapping(value="/registerByDateFormat02", method=RequestMethod.GET)
	public String registerByDateFormat02(String userId, @DateTimeFormat(pattern="yyyy/MM/dd") Date dateOfBirth) {
		log.info("registerByDateFormat02");
		log.info("userId() = " + userId);
		log.info("dateOfBirth() = " + dateOfBirth);
		return "success";
	}
	
	@RequestMapping(value="/registerByDateFormat03", method=RequestMethod.GET)
	public String registerByDateFormat03(Member member) {
		log.info("registerByDateFormat03");
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getDateOfBirth() = " + member.getDateOfBirth());
		return "success";
	}*/
	
	/* Date 애너테이션 처리
	@RequestMapping(value="/registerByDate01", method=RequestMethod.GET)
	public String registerByDate01(String userId, Date dateOfBirth ) {
		log.info("registerByDate01");
		log.info("userId = " + userId);
		log.info("dateOfBirth = " + dateOfBirth);
		
		return "success";
	}
	
	@RequestMapping(value="/registerByDate02", method=RequestMethod.GET)
	public String registerByDate02(Member member) {
		log.info("registerByDate02");
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getDateOfBirth() = " + member.getDateOfBirth());
		
		return "success";
	}
	
	@RequestMapping(value="/registerdate", method=RequestMethod.POST)
	public String registerdate(Member member) {
		log.info("registerdate");
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getPassword() = " + member.getPassword());
		log.info("member.getDateOfBirth() = " + member.getDateOfBirth());
		
		return "success";
	}*/
	
	/*
	 * 
	 * 자바빈즈 처리 애너테이션
	@RequestMapping(value="/registerbeans01", method=RequestMethod.POST)
	public String registerbeans01(Member member) {
		log.info("registerBeans");
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getPassword() = " + member.getPassword());
		log.info("member.getCoin() = " + member.getCoin());
		return "success";
	}
	
	@RequestMapping(value="/registerbeans02", method=RequestMethod.POST)
	public String registerbeans02(Member member, int coin) {
		log.info("registerBeans");
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getPassword() = " + member.getPassword());
		log.info("member.getCoin() = " + member.getCoin());
		log.info("coin = " + coin);
		return "success";
	}
	*/
	
	/*
	 * 
	 * 요청 데이터 처리 애너테이션
	 @RequestMapping(value="/register/{userId}", method=RequestMethod.GET)
	public String registerByPath(@PathVariable("userId") String userId) {
		log.info("registerByPath : /register/{userId}");
		log.info("userId = " + userId);
		return "success";
	}
	
	@RequestMapping(value="/register/{userId}/{coin}", method=RequestMethod.GET)
	public String registerByPath(@PathVariable("userId") String userId, @PathVariable("coin") int coin) {
		log.info("registerByPath : /register/{userId}/{coin}");
		log.info("userId = " + userId);
		log.info("coin = " + coin);
		return "success";
	}
	
	@RequestMapping(value="/register01", method=RequestMethod.POST)
	public String register01(String userId) {
		log.info("register01 : userId");
		log.info("userId = " + userId);
		return "success";
	}
	
	@RequestMapping(value="/register02", method=RequestMethod.POST)
	public String register02(@RequestParam("userId") String username ) {
		log.info("register02 : @RequestParam");
		log.info("userId = " + username);
		return "success";
	}
	 */
	
	/*
	 * 
	 * 컨트롤러 메소드 매개변수
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerByParameter(String userId, String password) {
		log.info("registerByParameter");
		log.info("userId = " + userId);
		log.info("password = " + password);
		return "success";
	}  
	 
	@RequestMapping(value="/register/{userId}", method=RequestMethod.GET)
	public String registerByPath(String userId) {
		log.info("registerByPath");
		log.info("userId = " + userId);
		return "success";
	} 
	 
	@RequestMapping(value="/register01", method=RequestMethod.POST)
	public String register01(String userId) {
		log.info("HTML 폼 필드명과 컨트롤러 매개변수명이 일치 register01");
		log.info("userId = " + userId);
		return "success";
	}
	
	@RequestMapping(value="/register02", method=RequestMethod.POST)
	public String register02(String userId, String password) {
		log.info("HTML 폼 필드가 여러개일 경우 register02");
		log.info("userId = " + userId);
		log.info("password = " + password);
		return "success";
	}

	@RequestMapping(value="/register03", method=RequestMethod.POST)
	public String register03(String password, String userId) {
		log.info("컨트롤러 매개변수의 위치 register03");
		log.info("userId = " + userId);
		log.info("password = " + password);
		return "success";
	}
	
	@RequestMapping(value="/register04", method=RequestMethod.POST)
	public String register04(String userId, String password, String coin) {
		log.info("HTML 폼 필드값이 숫자일 경우 register04");
		log.info("userId = " + userId);
		log.info("password = " + password);
		log.info("coin = " + coin);
		return "success";
	}
	
	@RequestMapping(value="/register05", method=RequestMethod.POST)
	public String register05(String userId, String password, int coin) {
		log.info("숫자형이면 숫자로 타입변환 register05");
		log.info("userId = " + userId);
		log.info("password = " + password);
		log.info("coin = " + coin);
		return "success";
	}*/
}
