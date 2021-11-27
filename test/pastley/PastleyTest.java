package pastley;

import java.util.List;

import com.pastley.controller.request.ProviderRequest;
import com.pastley.models.dto.ExceptionDTO;
import com.pastley.models.model.Provider;

public class PastleyTest {
	
	public static void main(String args []) {
		ProviderRequest r = new ProviderRequest();
		try {
			List<Provider> list = r.findAll();
			for(Provider c: list) {
				System.out.println(c);
			}
		} catch (ExceptionDTO e) {
			System.out.println(e.getMessage());
		}
	}
}
