package frontController;

import java.util.HashMap;
import controller.BoardAddController;
import controller.BoardDeleteController;
import controller.BoardListController;
import controller.BoardMainController;
import controller.BoardViewController;
import controller.CheckRentController;
import controller.Controller;
import controller.MemberJoinController;
import controller.MemberLoginController;
import controller.MemberLogoutController;
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
	 }
	 public Controller getController(String key) { 
		  return mappings.get(key);
	  }
}
