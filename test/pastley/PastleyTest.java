package pastley;

import java.util.List;

import com.pastley.controller.request.CategoryRequest;
import com.pastley.models.dto.ExceptionDTO;
import com.pastley.models.model.Category;

public class PastleyTest {
	
	public static void main(String args []) {
		CategoryRequest cr = new CategoryRequest();
		try {
			List<Category> list = cr.findAll();
			for(Category c: list) {
				System.out.println(c);
			}
		} catch (ExceptionDTO e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\nstatu");
		try {
			List<Category> list = cr.findByStatuAll(false);
			for(Category c: list) {
				System.out.println(c);
			}
		} catch (ExceptionDTO e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nrange");
		try {
			List<Category> list = cr.findByRangeDateRegister("2000-02-12", "2020-02-12");
			for(Category c: list) {
				System.out.println(c);
			}
		} catch (ExceptionDTO e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nid");
		try {
			Category c= cr.findById(1L, null);
			System.out.println(c);
		} catch (ExceptionDTO e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nname");
		try {
			Category c= cr.findByName("postre", null);
			System.out.println(c);
		} catch (ExceptionDTO e) {
			System.out.println(e.getMessage());
		}
	}
}
