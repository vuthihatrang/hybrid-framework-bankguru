package pageUIs.nopCommerce;

public class HomePageUI {
	public static final String HOMEPAGE_SLIDER ="//div[@id ='nivo-slider']";
	
	//public: phạm vi rộng ngoài package
	//static: biến tĩnh - cho phép 1 class khác truy cập đến biến của class mà không cần khởi tạo đối tượng của class này lên
	//HomePageUI.HOMEPAGE_SLIDER
	//final: ngăn cản việc gắn lại giá trị cho biến này
	//static final = constant - phải viết hoa và phân cách bời dấu gạch nối
	//String: kiểu dữ liệu của xpath
	public static final String REGISTER_LINK ="//a[@class ='ico-register']";
	public static final String LOGIN_LINK ="//a[@class ='ico-login']";
	
}
