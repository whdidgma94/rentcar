package frontController;

import java.util.HashMap;

import controller.AdminAddCarController;
import controller.AdminImgUploadController;
import controller.AdminInsertCarVOController;
import controller.AdminMemberController;
import controller.AdminMemberDeleteController;
import controller.BoardAddController;
import controller.BoardDeleteController;
import controller.BoardListController;
import controller.BoardMainController;
import controller.BoardViewController;
import controller.CheckRentController;
import controller.Controller;
import controller.MainController;
import controller.MemberIdConfirmController;
import controller.MemberJoinController;
import controller.MemberLoginController;
import controller.MemberLogoutController;
import controller.MemberProfileController;
import controller.RentController;
import controller.ReserveAddController;
import controller.ReserveController;
import controller.ReserveRemoveController;


public class HandlerMapping {
	 private HashMap<String, Controller> mappings;
	 public HandlerMapping() {
		  mappings=new HashMap<String, Controller>();
		  mappings.put("/memberJoin.do", new MemberJoinController());
		  mappings.put("/memberLogin.do", new MemberLoginController());
		  mappings.put("/memberLogout.do", new MemberLogoutController());
		  mappings.put("/boardAdd.do", new BoardAddController());
		  mappings.put("/boardDelete.do", new BoardDeleteController());
		  mappings.put("/boardList.do", new BoardListController());
		  mappings.put("/boardView.do", new BoardViewController());
		  mappings.put("/boardMain.do", new BoardMainController());
		  mappings.put("/rent.do", new RentController());
		  mappings.put("/reserve.do", new ReserveController());
		  mappings.put("/checkRent.do", new CheckRentController());
		  mappings.put("/reserveAdd.do", new ReserveAddController());
		  mappings.put("/reserveRemove.do", new ReserveRemoveController());
		  mappings.put("/memberIdConfirm.do", new MemberIdConfirmController());
		  mappings.put("/_main.do", new MainController());
		  mappings.put("/adminMember.do", new AdminMemberController());
		  mappings.put("/adminMemberDelete.do", new AdminMemberDeleteController());
		  mappings.put("/memberProfile.do", new MemberProfileController());
		  mappings.put("/adminAddCar.do", new AdminAddCarController());
		  mappings.put("/adminImgUpload.do", new AdminImgUploadController());
		  mappings.put("/adminInsertCarVO.do", new AdminInsertCarVOController());
	 }
	 public Controller getController(String key) { 
		  return mappings.get(key);
	  }
}
